package mqq.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.VerifyDevLockManager;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.util.LogUtil;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class VerifyDevLockManagerImpl
  implements VerifyDevLockManager
{
  private static final int CODE_GATEWAY = 239;
  private static final String KEY_UIN = "uin";
  public static final int MSG_NOTIFY_UI_CLOSE = 1;
  public static final int MSG_NOTIFY_UI_RECVED = 0;
  private static final String TAG = "VerifyDevLockManagerImpl";
  private final AppRuntime mApp;
  private final Handler mHandler = new VerifyDevLockManagerImpl.1(this, Looper.getMainLooper());
  ConcurrentHashMap<Integer, VerifyDevLockManagerImpl.VerifyDevLockWrapper> mVerifyDevLockWrapperMap = new ConcurrentHashMap();
  
  public VerifyDevLockManagerImpl(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  private int getNoticeType(MsfCommand paramMsfCommand)
  {
    if (paramMsfCommand == MsfCommand.wt_RefreshSMSData) {
      return 1002;
    }
    return 1001;
  }
  
  private void notifyApp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyApp seq:");
    localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
    localStringBuilder.append(" uin:");
    localStringBuilder.append(LogUtil.getSafePrintUin(paramFromServiceMsg.getUin()));
    localStringBuilder.append(" msfCmd:");
    localStringBuilder.append(paramFromServiceMsg.getMsfCommand());
    QLog.i(str, 1, localStringBuilder.toString());
    this.mApp.getService().onRecvVerifyManagerCallback(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void notifyClose(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg)
  {
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyClose seq:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" uin:");
    localStringBuilder.append(LogUtil.getSafePrintUin(paramString));
    localStringBuilder.append(" ret:");
    localStringBuilder.append(paramInt2);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    localObject = this.mHandler.obtainMessage();
    ((Message)localObject).obj = new Object[] { paramVerifyDevLockObserver, Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), paramErrMsg };
    ((Message)localObject).what = 1;
    ((Message)localObject).sendToTarget();
  }
  
  private void notifyUI(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt, ErrMsg paramErrMsg, DevlockInfo paramDevlockInfo)
  {
    int j = getNoticeType(paramFromServiceMsg.getMsfCommand());
    int i = j;
    if (paramToServiceMsg.getAttribute("smsExtraData") != null) {
      if (j == 1002) {
        i = 1003;
      } else {
        i = 1004;
      }
    }
    j = paramToServiceMsg.getRequestSsoSeq();
    String str1 = paramFromServiceMsg.getUin();
    String str2 = String.valueOf(paramToServiceMsg.getAttribute("process"));
    VerifyDevLockManagerImpl.VerifyDevLockWrapper localVerifyDevLockWrapper = (VerifyDevLockManagerImpl.VerifyDevLockWrapper)this.mVerifyDevLockWrapperMap.get(Integer.valueOf(j));
    Object localObject = paramToServiceMsg.getAttribute("from_where");
    StringBuilder localStringBuilder = null;
    if (localObject != null)
    {
      localObject = (String)paramToServiceMsg.getAttribute("from_where");
      paramToServiceMsg = (String)paramToServiceMsg.getAttribute("mainaccount");
    }
    else
    {
      paramToServiceMsg = null;
      localObject = paramToServiceMsg;
    }
    if ((localVerifyDevLockWrapper != null) && (localVerifyDevLockWrapper.mVerifyDevLockObserver != null))
    {
      if (i != 1003)
      {
        paramToServiceMsg = localStringBuilder;
        if (i != 1004) {}
      }
      else
      {
        paramFromServiceMsg = paramFromServiceMsg.getAttribute("smsExtraData");
        paramToServiceMsg = localStringBuilder;
        if (paramFromServiceMsg != null) {
          paramToServiceMsg = (byte[])paramFromServiceMsg;
        }
      }
      paramFromServiceMsg = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyUI already started, notifyType:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" seq:");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(" uin:");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(" ret:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d(paramFromServiceMsg, 2, ((StringBuilder)localObject).toString());
      paramFromServiceMsg = this.mHandler.obtainMessage();
      paramFromServiceMsg.obj = new Object[] { localVerifyDevLockWrapper.mVerifyDevLockObserver, Integer.valueOf(i), Integer.valueOf(j), str1, Integer.valueOf(paramInt), paramErrMsg, paramDevlockInfo, paramToServiceMsg };
      paramFromServiceMsg.what = 0;
      paramFromServiceMsg.sendToTarget();
      return;
    }
    if (QLog.isColorLevel())
    {
      paramErrMsg = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyUI wrapper=");
      localStringBuilder.append(localVerifyDevLockWrapper);
      localStringBuilder.append(" mVerifyDevLockObserver=");
      if (localVerifyDevLockWrapper == null) {
        paramFromServiceMsg = "null";
      } else {
        paramFromServiceMsg = localVerifyDevLockWrapper.mVerifyDevLockObserver;
      }
      localStringBuilder.append(paramFromServiceMsg);
      QLog.d(paramErrMsg, 2, localStringBuilder.toString());
    }
    paramFromServiceMsg = TAG;
    paramErrMsg = new StringBuilder();
    paramErrMsg.append("notifyUI start, notifyType:");
    paramErrMsg.append(i);
    paramErrMsg.append(" seq:");
    paramErrMsg.append(j);
    paramErrMsg.append(" uin:");
    paramErrMsg.append(str1);
    paramErrMsg.append(" ret:");
    paramErrMsg.append(paramInt);
    QLog.d(paramFromServiceMsg, 2, paramErrMsg.toString());
    paramFromServiceMsg = new Intent();
    paramFromServiceMsg.setFlags(268435456);
    if ("com.tencent.mobileqq:openSdk".equals(str2))
    {
      paramFromServiceMsg.setAction("mqq.opensdk.intent.action.ACTION_VERYFY_LOCK_CODE");
      paramFromServiceMsg.setPackage(MobileQQ.sMobileQQ.getPackageName());
    }
    else if (paramInt == 239)
    {
      paramFromServiceMsg.setAction("android.intent.action.VIEW");
      paramFromServiceMsg.setData(Uri.parse("mqqverifycode://puzzle_verify_code/GATEVERIFY?"));
    }
    else
    {
      paramFromServiceMsg.setAction("android.intent.action.VIEW");
      paramFromServiceMsg.setData(Uri.parse("mqqverifycode://puzzle_verify_code/DEVLOCK_CODE?"));
    }
    paramFromServiceMsg.putExtra("DevlockInfo", paramDevlockInfo);
    paramFromServiceMsg.putExtra("seq", j);
    paramFromServiceMsg.putExtra("uin", str1);
    paramFromServiceMsg.putExtra("from_login", true);
    paramFromServiceMsg.putExtra("from_where", (String)localObject);
    paramFromServiceMsg.putExtra("mainaccount", paramToServiceMsg);
    paramFromServiceMsg.putExtra("process", str2);
    this.mApp.getApplication().startActivity(paramFromServiceMsg);
  }
  
  public void cancelVerify(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    if (paramVerifyDevLockObserver == null)
    {
      QLog.d(TAG, 2, "cancelVerify observer==null");
      return;
    }
    paramVerifyDevLockObserver = (VerifyDevLockManagerImpl.VerifyDevLockWrapper)this.mVerifyDevLockWrapperMap.remove(Integer.valueOf(paramVerifyDevLockObserver.getSeq()));
    if ((paramVerifyDevLockObserver != null) && (paramVerifyDevLockObserver.mToServiceMsg != null))
    {
      QLog.d(TAG, 2, "cancelVerify");
      ToServiceMsg localToServiceMsg = paramVerifyDevLockObserver.mToServiceMsg;
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(localToServiceMsg.getAppId(), localToServiceMsg.getAppSeq(), localToServiceMsg.getUin(), localToServiceMsg.getServiceCmd());
      localFromServiceMsg.setMsfCommand(localToServiceMsg.getMsfCommand());
      localFromServiceMsg.setBusinessFail(2006, "");
      notifyApp(paramVerifyDevLockObserver.mToServiceMsg, localFromServiceMsg);
    }
  }
  
  public boolean checkVerifyDevLockSmsResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i;
    if (paramFromServiceMsg.attributes.get("ret") != null) {
      i = ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue();
    } else {
      i = 1001;
    }
    ErrMsg localErrMsg;
    if (paramFromServiceMsg.attributes.get("lastError") != null) {
      localErrMsg = (ErrMsg)paramFromServiceMsg.attributes.get("lastError");
    } else {
      localErrMsg = null;
    }
    DevlockInfo localDevlockInfo;
    if (paramFromServiceMsg.getAttribute("resp_devlockinfo") != null) {
      localDevlockInfo = (DevlockInfo)paramFromServiceMsg.getAttribute("resp_devlockinfo");
    } else {
      localDevlockInfo = null;
    }
    try
    {
      if ((!TextUtils.isEmpty(paramFromServiceMsg.getUin())) && (paramFromServiceMsg.getUin().equals("0"))) {
        if ((!TextUtils.isEmpty(paramToServiceMsg.getUin())) && (!paramToServiceMsg.getUin().equals("0")))
        {
          QLog.d(TAG, 2, "copy uin from toServiceMsg");
          paramFromServiceMsg.setUin(paramToServiceMsg.getUin());
        }
        else
        {
          QLog.d(TAG, 2, "all uin is 0");
        }
      }
    }
    catch (Throwable localThrowable)
    {
      label176:
      Object localObject;
      StringBuilder localStringBuilder;
      break label176;
    }
    localObject = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkVerifyDevLockSmsResp ssoSeq:");
    localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
    localStringBuilder.append(" msfCmd:");
    localStringBuilder.append(paramFromServiceMsg.getMsfCommand());
    localStringBuilder.append(" ret:");
    localStringBuilder.append(i);
    localStringBuilder.append(" busCode:");
    localStringBuilder.append(paramFromServiceMsg.getBusinessFailCode());
    QLog.d((String)localObject, 2, localStringBuilder.toString());
    if (paramFromServiceMsg.getBusinessFailCode() == 2016)
    {
      if (!this.mVerifyDevLockWrapperMap.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq())))
      {
        this.mVerifyDevLockWrapperMap.putIfAbsent(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), new VerifyDevLockManagerImpl.VerifyDevLockWrapper(this, paramToServiceMsg.getRequestSsoSeq()));
        ((VerifyDevLockManagerImpl.VerifyDevLockWrapper)this.mVerifyDevLockWrapperMap.get(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))).mToServiceMsg = paramToServiceMsg;
      }
      ((VerifyDevLockManagerImpl.VerifyDevLockWrapper)this.mVerifyDevLockWrapperMap.get(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))).mUin = paramFromServiceMsg.getUin();
      notifyUI(paramToServiceMsg, paramFromServiceMsg, i, localErrMsg, localDevlockInfo);
      return false;
    }
    if ((paramFromServiceMsg.getBusinessFailCode() != 2017) && (!this.mVerifyDevLockWrapperMap.containsKey(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()))))
    {
      if (i == 239)
      {
        notifyUI(paramToServiceMsg, paramFromServiceMsg, i, localErrMsg, localDevlockInfo);
        return false;
      }
      return true;
    }
    localObject = (VerifyDevLockManagerImpl.VerifyDevLockWrapper)this.mVerifyDevLockWrapperMap.get(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()));
    if (i == 0)
    {
      QLog.i(TAG, 1, "checkVerifyDevLockSmsResp ret == util.S_SUCCESS remove");
      notifySuccess(((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject).mVerifyDevLockObserver, paramFromServiceMsg.getUin(), paramToServiceMsg, paramFromServiceMsg);
      this.mVerifyDevLockWrapperMap.remove(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()));
      notifyClose(((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject).mVerifyDevLockObserver, paramFromServiceMsg.getRequestSsoSeq(), paramFromServiceMsg.getUin(), i, localErrMsg);
      paramFromServiceMsg.setMsfCommand(((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject).mToServiceMsg.getMsfCommand());
      notifyApp(((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject).mToServiceMsg, paramFromServiceMsg);
      return false;
    }
    if (i == 2)
    {
      QLog.i(TAG, 1, "checkVerifyDevLockSmsResp ret == util.S_GET_IMAGE checkVerifyDevLockSmsResp remove");
      this.mVerifyDevLockWrapperMap.remove(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()));
      notifyClose(((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject).mVerifyDevLockObserver, paramFromServiceMsg.getRequestSsoSeq(), paramFromServiceMsg.getUin(), i, localErrMsg);
      return true;
    }
    notifyUI(paramToServiceMsg, paramFromServiceMsg, i, localErrMsg, localDevlockInfo);
    return false;
  }
  
  public void gatewayVerify(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, byte[] paramArrayOfByte)
  {
    if (paramVerifyDevLockObserver == null)
    {
      QLog.d(TAG, 2, "submitSms observer == null!");
      return;
    }
    Object localObject = (VerifyDevLockManagerImpl.VerifyDevLockWrapper)this.mVerifyDevLockWrapperMap.get(Integer.valueOf(paramVerifyDevLockObserver.getSeq()));
    if (localObject != null)
    {
      ToServiceMsg localToServiceMsg = ((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject).mToServiceMsg;
      ((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject).mVerifyDevLockObserver = paramVerifyDevLockObserver;
      paramVerifyDevLockObserver = this.mApp.getService().msfSub.getCheckSMSAndGetStMsg(((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject).mUin, new byte[0]);
      paramVerifyDevLockObserver.setRequestSsoSeq(((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject).mSeq);
      paramVerifyDevLockObserver.setAppSeq(((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject).mSeq);
      if (localToServiceMsg.getAttribute("from_where") != null)
      {
        localObject = (String)localToServiceMsg.getAttribute("from_where");
        String str = (String)localToServiceMsg.getAttribute("mainaccount");
        paramVerifyDevLockObserver.addAttribute("from_where", localObject);
        paramVerifyDevLockObserver.addAttribute("mainaccount", str);
      }
      paramVerifyDevLockObserver.addAttribute("smsExtraData", paramArrayOfByte);
      VerifyCodeManagerImpl.addConnectData(localToServiceMsg, paramVerifyDevLockObserver);
      this.mApp.getService().msfSub.sendMsg(paramVerifyDevLockObserver);
    }
  }
  
  protected void notifySuccess(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramVerifyDevLockObserver != null) {
      paramVerifyDevLockObserver.onVerifySuccess(paramString, paramToServiceMsg, paramFromServiceMsg);
    }
  }
  
  public void onDestroy() {}
  
  public void pullToServiceMsg(int paramInt, ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null)
    {
      paramToServiceMsg = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pullToServiceMsg toServiceMsg = null,seq=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i(paramToServiceMsg, 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pullToServiceMsg seq = ");
    localStringBuilder.append(paramInt);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    localObject = new VerifyDevLockManagerImpl.VerifyDevLockWrapper(this, paramInt);
    ((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject).mToServiceMsg = paramToServiceMsg;
    ((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject).mUin = paramToServiceMsg.getUin();
    this.mVerifyDevLockWrapperMap.putIfAbsent(Integer.valueOf(paramInt), localObject);
  }
  
  public void refreshDevLockSms(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, HashMap<String, Object> paramHashMap)
  {
    if (paramVerifyDevLockObserver == null)
    {
      QLog.d(TAG, 2, "refreshDevLockSms observer == null!");
      return;
    }
    Object localObject1 = (VerifyDevLockManagerImpl.VerifyDevLockWrapper)this.mVerifyDevLockWrapperMap.get(Integer.valueOf(paramVerifyDevLockObserver.getSeq()));
    if (localObject1 != null)
    {
      Object localObject2 = TAG;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("refreshDevLockSms");
      ((StringBuilder)localObject3).append(paramVerifyDevLockObserver.getSeq());
      QLog.i((String)localObject2, 1, ((StringBuilder)localObject3).toString());
      ((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject1).mVerifyDevLockObserver = paramVerifyDevLockObserver;
      paramVerifyDevLockObserver = this.mApp.getService().msfSub.getRefreshDevLockSmsMsg(((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject1).mUin);
      paramVerifyDevLockObserver.setRequestSsoSeq(((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject1).mSeq);
      paramVerifyDevLockObserver.setAppSeq(((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject1).mSeq);
      if (paramHashMap != null)
      {
        localObject2 = paramHashMap.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          paramVerifyDevLockObserver.addAttribute((String)localObject3, paramHashMap.get(localObject3));
        }
      }
      VerifyCodeManagerImpl.addConnectData(((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject1).mToServiceMsg, paramVerifyDevLockObserver);
      this.mApp.getService().msfSub.sendMsg(paramVerifyDevLockObserver);
      return;
    }
    paramHashMap = TAG;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("refreshDevLockSms wrapper == null ");
    ((StringBuilder)localObject1).append(paramVerifyDevLockObserver.getSeq());
    QLog.i(paramHashMap, 1, ((StringBuilder)localObject1).toString());
  }
  
  public void refreshDevLockSms(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, byte[] paramArrayOfByte)
  {
    if (paramVerifyDevLockObserver == null)
    {
      QLog.d(TAG, 1, "refreshDevLockSms2 observer == null!");
      return;
    }
    VerifyDevLockManagerImpl.VerifyDevLockWrapper localVerifyDevLockWrapper = (VerifyDevLockManagerImpl.VerifyDevLockWrapper)this.mVerifyDevLockWrapperMap.get(Integer.valueOf(paramVerifyDevLockObserver.getSeq()));
    if (localVerifyDevLockWrapper != null)
    {
      QLog.d(TAG, 1, "refreshDevLockSms2");
      localVerifyDevLockWrapper.mVerifyDevLockObserver = paramVerifyDevLockObserver;
      paramVerifyDevLockObserver = this.mApp.getService().msfSub.getRefreshDevLockSmsMsg(localVerifyDevLockWrapper.mUin);
      paramVerifyDevLockObserver.setRequestSsoSeq(localVerifyDevLockWrapper.mSeq);
      paramVerifyDevLockObserver.setAppSeq(localVerifyDevLockWrapper.mSeq);
      paramVerifyDevLockObserver.getAttributes().put("smsExtraData", paramArrayOfByte);
      VerifyCodeManagerImpl.addConnectData(localVerifyDevLockWrapper.mToServiceMsg, paramVerifyDevLockObserver);
      this.mApp.getService().msfSub.sendMsg(paramVerifyDevLockObserver);
    }
  }
  
  public void removeVerifyDevlockObserver(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    ConcurrentHashMap localConcurrentHashMap = this.mVerifyDevLockWrapperMap;
    if ((localConcurrentHashMap != null) && (paramVerifyDevLockObserver != null)) {
      localConcurrentHashMap.remove(Integer.valueOf(paramVerifyDevLockObserver.getSeq()));
    }
  }
  
  public void submitSms(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, String paramString, HashMap<String, Object> paramHashMap)
  {
    if (paramVerifyDevLockObserver == null)
    {
      QLog.d(TAG, 2, "submitSms observer == null!");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d(TAG, 2, "submitSms smscode is empty!");
      return;
    }
    Object localObject2 = (VerifyDevLockManagerImpl.VerifyDevLockWrapper)this.mVerifyDevLockWrapperMap.get(Integer.valueOf(paramVerifyDevLockObserver.getSeq()));
    if (localObject2 != null)
    {
      Object localObject1 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("submitSms smscode:");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject1, 2, localStringBuilder.toString());
      localObject1 = ((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject2).mToServiceMsg;
      ((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject2).mVerifyDevLockObserver = paramVerifyDevLockObserver;
      paramVerifyDevLockObserver = this.mApp.getService().msfSub.getCheckSMSAndGetStMsg(((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject2).mUin, paramString.getBytes());
      paramVerifyDevLockObserver.setRequestSsoSeq(((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject2).mSeq);
      paramVerifyDevLockObserver.setAppSeq(((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject2).mSeq);
      if (((ToServiceMsg)localObject1).getAttribute("from_where") != null)
      {
        paramString = (String)((ToServiceMsg)localObject1).getAttribute("from_where");
        localObject2 = (String)((ToServiceMsg)localObject1).getAttribute("mainaccount");
        paramVerifyDevLockObserver.addAttribute("from_where", paramString);
        paramVerifyDevLockObserver.addAttribute("mainaccount", localObject2);
      }
      if (paramHashMap != null)
      {
        paramString = paramHashMap.keySet().iterator();
        while (paramString.hasNext())
        {
          localObject2 = (String)paramString.next();
          paramVerifyDevLockObserver.addAttribute((String)localObject2, paramHashMap.get(localObject2));
        }
      }
      VerifyCodeManagerImpl.addConnectData((ToServiceMsg)localObject1, paramVerifyDevLockObserver);
      this.mApp.getService().msfSub.sendMsg(paramVerifyDevLockObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.VerifyDevLockManagerImpl
 * JD-Core Version:    0.7.0.1
 */