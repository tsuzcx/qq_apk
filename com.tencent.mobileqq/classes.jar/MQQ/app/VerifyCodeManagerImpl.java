package mqq.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.VerifyCodeManager;
import mqq.observer.HttpVerifyHandler;
import mqq.observer.ServerNotifyObserver;

public class VerifyCodeManagerImpl
  implements VerifyCodeManager
{
  public static final int MANAGER_HTTPVERIFYCODE_CHANGE = 2;
  public static final int MANAGER_VERIFYCODE_CLOSE = 1;
  public static final int MANAGER_VERIFYCODE_RECEIVE = 0;
  private static final String TAG = "VerifyCodeManagerImpl";
  private final AppRuntime app;
  ConcurrentHashMap<String, VerifyCodeManagerImpl.HttpVerifyCodeWrapper> httpVerifyCodeWrapperMap = new ConcurrentHashMap();
  private final Handler mHandler = new VerifyCodeManagerImpl.1(this, Looper.getMainLooper());
  ConcurrentHashMap<Integer, VerifyCodeManagerImpl.VerifyCodeWrapper> verifyCodeWrapperMap = new ConcurrentHashMap();
  
  public VerifyCodeManagerImpl(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
  }
  
  public static void addConnectData(ToServiceMsg paramToServiceMsg1, ToServiceMsg paramToServiceMsg2)
  {
    if ((paramToServiceMsg1 != null) && (paramToServiceMsg2 != null))
    {
      Object localObject = paramToServiceMsg1.getAttribute("process");
      if (localObject != null) {
        paramToServiceMsg2.addAttribute("process", localObject);
      }
      paramToServiceMsg1 = paramToServiceMsg1.getAttribute("connect_data");
      if (paramToServiceMsg1 != null) {
        paramToServiceMsg2.addAttribute("connect_data", paramToServiceMsg1);
      }
      return;
    }
    QLog.d("VerifyCodeManagerImpl", 1, "addConnectData null == src || null == to");
  }
  
  private FromServiceMsg createVerifyCodeCancelResp(ToServiceMsg paramToServiceMsg)
  {
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(paramToServiceMsg.getAppId(), paramToServiceMsg.getAppSeq(), paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
    localFromServiceMsg.setMsfCommand(paramToServiceMsg.getMsfCommand());
    localFromServiceMsg.setBusinessFail(2006, "");
    return localFromServiceMsg;
  }
  
  private void notifyHttpVerifyCodeActivity(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    Object localObject = (VerifyCodeManagerImpl.HttpVerifyCodeWrapper)this.httpVerifyCodeWrapperMap.get(paramString1);
    if ((localObject != null) && (((VerifyCodeManagerImpl.HttpVerifyCodeWrapper)localObject).serverNotifyObserver != null))
    {
      Message localMessage = this.mHandler.obtainMessage();
      localMessage.obj = new Object[] { ((VerifyCodeManagerImpl.HttpVerifyCodeWrapper)localObject).serverNotifyObserver, paramString1, Integer.valueOf(0), paramString2, paramArrayOfByte };
      localMessage.what = 0;
      localMessage.sendToTarget();
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    ((Intent)localObject).putExtra("key", paramString1);
    ((Intent)localObject).putExtra("note", paramString2);
    ((Intent)localObject).putExtra("image", paramArrayOfByte);
    ((Intent)localObject).setData(Uri.parse("mqqverifycode://puzzle_verify_code/VERIFYCODE?"));
    this.app.getApplication().startActivity((Intent)localObject);
  }
  
  public void cancelVerifyCode(ServerNotifyObserver paramServerNotifyObserver)
  {
    Object localObject;
    if (paramServerNotifyObserver.getSeq() == 0)
    {
      localObject = (VerifyCodeManagerImpl.HttpVerifyCodeWrapper)this.httpVerifyCodeWrapperMap.remove(paramServerNotifyObserver.getKey());
      if ((localObject != null) && (localObject != null))
      {
        HashMap localHashMap = ((VerifyCodeManagerImpl.HttpVerifyCodeWrapper)localObject).attr;
        ((VerifyCodeManagerImpl.HttpVerifyCodeWrapper)localObject).httpVerifyHandler.cancelVerifyCode(paramServerNotifyObserver.getKey(), localHashMap);
      }
    }
    else
    {
      paramServerNotifyObserver = (VerifyCodeManagerImpl.VerifyCodeWrapper)this.verifyCodeWrapperMap.remove(Integer.valueOf(paramServerNotifyObserver.getSeq()));
      if (paramServerNotifyObserver != null)
      {
        localObject = createVerifyCodeCancelResp(paramServerNotifyObserver.srcTo);
        notifyApp(paramServerNotifyObserver.srcTo, (FromServiceMsg)localObject);
      }
    }
  }
  
  public boolean checkVerifyCodeResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getBusinessFailCode() == 2002)
    {
      QLog.d("VerifyCodeManagerImpl", 1, "checkVerifyCodeResp");
      if (!this.verifyCodeWrapperMap.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq())))
      {
        this.verifyCodeWrapperMap.putIfAbsent(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), new VerifyCodeManagerImpl.VerifyCodeWrapper(this, paramToServiceMsg.getRequestSsoSeq()));
        ((VerifyCodeManagerImpl.VerifyCodeWrapper)this.verifyCodeWrapperMap.get(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))).srcTo = paramToServiceMsg;
      }
      paramFromServiceMsg = VerifyCodeInfo.getVerifyCodeInfo(paramFromServiceMsg);
      ((VerifyCodeManagerImpl.VerifyCodeWrapper)this.verifyCodeWrapperMap.get(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))).verifyCodeInfo = paramFromServiceMsg;
      notifyVerifyCodeActivity(paramToServiceMsg, paramFromServiceMsg.verifyNote, paramFromServiceMsg.verifyimage, paramFromServiceMsg.verifyurl);
      return false;
    }
    if ((paramFromServiceMsg.getBusinessFailCode() != 2003) && (!this.verifyCodeWrapperMap.containsKey(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq())))) {
      return true;
    }
    VerifyCodeManagerImpl.VerifyCodeWrapper localVerifyCodeWrapper = (VerifyCodeManagerImpl.VerifyCodeWrapper)this.verifyCodeWrapperMap.remove(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()));
    if (!paramFromServiceMsg.isSuccess()) {
      paramToServiceMsg = paramFromServiceMsg.getBusinessFailMsg();
    } else {
      paramToServiceMsg = "";
    }
    if (localVerifyCodeWrapper.serverNotifyObserver != null) {
      notifyVerifyCodeActivityClose(localVerifyCodeWrapper.serverNotifyObserver, paramToServiceMsg);
    }
    if (paramFromServiceMsg.getBusinessFailCode() == 2016)
    {
      QLog.d("VerifyCodeManagerImpl", 1, "checkVerifyCodeResp CODE_VERIFY_DEV_LOCK_SMS");
      return true;
    }
    QLog.d("VerifyCodeManagerImpl", 1, "checkVerifyCodeResp notifyApp");
    paramFromServiceMsg.setMsfCommand(localVerifyCodeWrapper.srcTo.getMsfCommand());
    notifyApp(localVerifyCodeWrapper.srcTo, paramFromServiceMsg);
    return false;
  }
  
  void notifyApp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.app.getService().onRecvVerifyManagerCallback(paramToServiceMsg, paramFromServiceMsg);
  }
  
  void notifyVerifyCodeActivity(ToServiceMsg paramToServiceMsg, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    int i = paramToServiceMsg.getRequestSsoSeq();
    String str = String.valueOf(paramToServiceMsg.getAttribute("process"));
    paramToServiceMsg = (VerifyCodeManagerImpl.VerifyCodeWrapper)this.verifyCodeWrapperMap.get(Integer.valueOf(i));
    if (paramToServiceMsg.serverNotifyObserver != null)
    {
      QLog.d("VerifyCodeManagerImpl", 1, "notifyVerifyCodeActivity MANAGER_VERIFYCODE_RECEIVE");
      localObject1 = this.mHandler.obtainMessage();
      ((Message)localObject1).obj = new Object[] { paramToServiceMsg.serverNotifyObserver, "", Integer.valueOf(i), paramString1, paramArrayOfByte, paramString2 };
      ((Message)localObject1).what = 0;
      ((Message)localObject1).sendToTarget();
      return;
    }
    QLog.d("VerifyCodeManagerImpl", 1, new Object[] { "notifyVerifyCodeActivity process=", str, "url empty=", Boolean.valueOf(TextUtils.isEmpty(paramString2)) });
    Object localObject1 = new Intent();
    ((Intent)localObject1).setFlags(268435456);
    Object localObject2 = "android.intent.action.VIEW";
    Object localObject3 = null;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramToServiceMsg = (ToServiceMsg)localObject1;
      if ("com.tencent.mobileqq:openSdk".equals(str))
      {
        paramToServiceMsg = new Intent("mqq.opensdk.intent.action.PUZZLEVERIFYCODE");
        paramToServiceMsg.setPackage(MobileQQ.sMobileQQ.getPackageName());
      }
      paramToServiceMsg.putExtra("seq", i);
      paramToServiceMsg.putExtra("url", paramString2);
      paramToServiceMsg.putExtra("business", 2097152L);
      paramToServiceMsg.putExtra("hide_operation_bar", true);
      paramToServiceMsg.putExtra("hide_more_button", true);
      paramToServiceMsg.putExtra("isSubaccount", true);
      paramToServiceMsg.putExtra("isShowAd", false);
      if ("com.tencent.mobileqq:openSdk".equals(str))
      {
        this.app.getApplication().sendBroadcast(paramToServiceMsg);
        return;
      }
      paramString1 = "PUZZLEVERIFYCODE";
    }
    else
    {
      if ("com.tencent.mobileqq:openSdk".equals(str))
      {
        paramToServiceMsg = "mqq.opensdk.intent.action.VERIFYCODE";
        paramString2 = localObject3;
      }
      else
      {
        paramString2 = "VERIFYCODE";
        paramToServiceMsg = (ToServiceMsg)localObject2;
      }
      ((Intent)localObject1).putExtra("seq", i);
      ((Intent)localObject1).putExtra("note", paramString1);
      ((Intent)localObject1).putExtra("image", paramArrayOfByte);
      paramString1 = paramString2;
      localObject2 = paramToServiceMsg;
      paramToServiceMsg = (ToServiceMsg)localObject1;
    }
    paramToServiceMsg.setAction((String)localObject2);
    if (!TextUtils.isEmpty(paramString1))
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("mqqverifycode://puzzle_verify_code/");
      paramArrayOfByte.append(paramString1);
      paramArrayOfByte.append("?");
      paramToServiceMsg.setData(Uri.parse(paramArrayOfByte.toString()));
    }
    this.app.getApplication().startActivity(paramToServiceMsg);
  }
  
  void notifyVerifyCodeActivityClose(ServerNotifyObserver paramServerNotifyObserver, String paramString)
  {
    Message localMessage = this.mHandler.obtainMessage();
    localMessage.obj = new Object[] { paramServerNotifyObserver, paramString };
    localMessage.what = 1;
    localMessage.sendToTarget();
  }
  
  public void onDestroy() {}
  
  public void onHttpVerifyCodeFail(String paramString1, String paramString2)
  {
    paramString1 = (VerifyCodeManagerImpl.HttpVerifyCodeWrapper)this.httpVerifyCodeWrapperMap.remove(paramString1);
    if (paramString1 != null) {
      notifyVerifyCodeActivityClose(paramString1.serverNotifyObserver, paramString2);
    }
  }
  
  public void onHttpVerifyCodeSucc(String paramString)
  {
    paramString = (VerifyCodeManagerImpl.HttpVerifyCodeWrapper)this.httpVerifyCodeWrapperMap.remove(paramString);
    if (paramString != null) {
      notifyVerifyCodeActivityClose(paramString.serverNotifyObserver, "");
    }
  }
  
  public void onRecvHttpVerifyCode(HttpVerifyHandler paramHttpVerifyHandler, byte[] paramArrayOfByte, String paramString, HashMap paramHashMap)
  {
    String str = (String)paramHashMap.get("key");
    if (!this.httpVerifyCodeWrapperMap.containsKey(str)) {
      this.httpVerifyCodeWrapperMap.putIfAbsent(str, new VerifyCodeManagerImpl.HttpVerifyCodeWrapper(this, str));
    }
    VerifyCodeManagerImpl.HttpVerifyCodeWrapper localHttpVerifyCodeWrapper = (VerifyCodeManagerImpl.HttpVerifyCodeWrapper)this.httpVerifyCodeWrapperMap.get(str);
    if (localHttpVerifyCodeWrapper != null)
    {
      localHttpVerifyCodeWrapper.httpVerifyHandler = paramHttpVerifyHandler;
      localHttpVerifyCodeWrapper.attr = paramHashMap;
      notifyHttpVerifyCodeActivity(str, paramString, paramArrayOfByte);
    }
  }
  
  public void refreVerifyCode(ServerNotifyObserver paramServerNotifyObserver)
  {
    Object localObject;
    if (paramServerNotifyObserver.getSeq() == 0)
    {
      localObject = (VerifyCodeManagerImpl.HttpVerifyCodeWrapper)this.httpVerifyCodeWrapperMap.get(paramServerNotifyObserver.getKey());
      if (localObject != null)
      {
        ((VerifyCodeManagerImpl.HttpVerifyCodeWrapper)localObject).serverNotifyObserver = paramServerNotifyObserver;
        HashMap localHashMap = ((VerifyCodeManagerImpl.HttpVerifyCodeWrapper)localObject).attr;
        ((VerifyCodeManagerImpl.HttpVerifyCodeWrapper)localObject).httpVerifyHandler.refreVerifyCode(paramServerNotifyObserver.getKey(), localHashMap);
      }
    }
    else
    {
      int i = paramServerNotifyObserver.getSeq();
      localObject = (VerifyCodeManagerImpl.VerifyCodeWrapper)this.verifyCodeWrapperMap.get(Integer.valueOf(i));
      if (localObject != null)
      {
        ((VerifyCodeManagerImpl.VerifyCodeWrapper)localObject).serverNotifyObserver = paramServerNotifyObserver;
        paramServerNotifyObserver = this.app.getService().msfSub.getRefreVerifyCodeMsg(((VerifyCodeManagerImpl.VerifyCodeWrapper)localObject).verifyCodeInfo);
        paramServerNotifyObserver.setAppSeq(((VerifyCodeManagerImpl.VerifyCodeWrapper)localObject).verifyCodeInfo.appSeq);
        addConnectData(((VerifyCodeManagerImpl.VerifyCodeWrapper)localObject).srcTo, paramServerNotifyObserver);
        this.app.getService().msfSub.sendMsg(paramServerNotifyObserver);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VerifyCodeManager", 2, "wrapper is null");
      }
    }
  }
  
  public void submitPuzzleVerifyCodeTicket(int paramInt, String paramString)
  {
    Object localObject = (VerifyCodeManagerImpl.VerifyCodeWrapper)this.verifyCodeWrapperMap.get(Integer.valueOf(paramInt));
    QLog.d("VerifyCodeManagerImpl", 1, new Object[] { "submitPuzzleVerifyCodeTicket wrapper=", localObject });
    if (localObject != null)
    {
      ToServiceMsg localToServiceMsg = ((VerifyCodeManagerImpl.VerifyCodeWrapper)localObject).srcTo;
      paramString = this.app.getService().msfSub.getSubmitPuzzleVerifyCodeTicketMsg(paramString, ((VerifyCodeManagerImpl.VerifyCodeWrapper)localObject).verifyCodeInfo);
      paramString.setAppSeq(((VerifyCodeManagerImpl.VerifyCodeWrapper)localObject).verifyCodeInfo.appSeq);
      if (localToServiceMsg.getAttribute("from_where") != null)
      {
        localObject = (String)localToServiceMsg.getAttribute("from_where");
        String str = (String)localToServiceMsg.getAttribute("mainaccount");
        paramString.addAttribute("from_where", localObject);
        paramString.addAttribute("mainaccount", str);
      }
      addConnectData(localToServiceMsg, paramString);
      this.app.getService().msfSub.sendMsg(paramString);
    }
  }
  
  public void submitVerifyCode(ServerNotifyObserver paramServerNotifyObserver, String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (paramServerNotifyObserver.getSeq() == 0)
    {
      localObject1 = (VerifyCodeManagerImpl.HttpVerifyCodeWrapper)this.httpVerifyCodeWrapperMap.get(paramServerNotifyObserver.getKey());
      if (localObject1 != null)
      {
        localObject2 = ((VerifyCodeManagerImpl.HttpVerifyCodeWrapper)localObject1).attr;
        ((VerifyCodeManagerImpl.HttpVerifyCodeWrapper)localObject1).serverNotifyObserver = paramServerNotifyObserver;
        ((VerifyCodeManagerImpl.HttpVerifyCodeWrapper)localObject1).httpVerifyHandler.submitVerifyCode(paramServerNotifyObserver.getKey(), (HashMap)localObject2, paramString);
      }
    }
    else
    {
      localObject1 = (VerifyCodeManagerImpl.VerifyCodeWrapper)this.verifyCodeWrapperMap.get(Integer.valueOf(paramServerNotifyObserver.getSeq()));
      if (localObject1 != null)
      {
        ((VerifyCodeManagerImpl.VerifyCodeWrapper)localObject1).serverNotifyObserver = paramServerNotifyObserver;
        paramServerNotifyObserver = ((VerifyCodeManagerImpl.VerifyCodeWrapper)localObject1).srcTo;
        paramString = this.app.getService().msfSub.getSubmitVerifyCodeMsg(paramString, ((VerifyCodeManagerImpl.VerifyCodeWrapper)localObject1).verifyCodeInfo);
        paramString.setAppSeq(((VerifyCodeManagerImpl.VerifyCodeWrapper)localObject1).verifyCodeInfo.appSeq);
        if (paramServerNotifyObserver.getAttribute("from_where") != null)
        {
          localObject1 = (String)paramServerNotifyObserver.getAttribute("from_where");
          localObject2 = (String)paramServerNotifyObserver.getAttribute("mainaccount");
          paramString.addAttribute("from_where", localObject1);
          paramString.addAttribute("mainaccount", localObject2);
        }
        addConnectData(paramServerNotifyObserver, paramString);
        this.app.getService().msfSub.sendMsg(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.VerifyCodeManagerImpl
 * JD-Core Version:    0.7.0.1
 */