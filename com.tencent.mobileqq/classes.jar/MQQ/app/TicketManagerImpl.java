package mqq.app;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.request.WtloginHelper;

public class TicketManagerImpl
  implements TicketManager
{
  public static final int APPID_QQ = 16;
  public static final int BUFLAG_OPEN_CONNECT = 1600001540;
  private static final int FAIL_NOT_PSKEY_DOMAIN = -5;
  private static final int FAIL_SDK_EXCEPTION = -4;
  private static final int FAIL_TICKET_NULL = -2;
  private static final int FAIL_TICKET_SIG_NULL = -3;
  private static final int FAIL_UIN_NONE = -1;
  private static final String TAG = "TicketManager";
  private HashMap<String, String> mAlterTicketsMap = new HashMap();
  private final AppRuntime mApp;
  private ArrayList<TicketManagerListener> mTicketListeners = new ArrayList();
  private WtloginHelper mWtLoginHelper;
  
  public TicketManagerImpl(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.mWtLoginHelper = new WtloginHelper(BaseApplication.getContext(), this);
    this.mWtLoginHelper.SetMsfTransportFlag(1);
    oicq.wlogin_sdk.tools.util.LOGCAT_OUT = false;
  }
  
  private String getA2Impl(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        Object localObject = this.mWtLoginHelper.GetLocalTicket(paramString1, paramInt1, paramInt2);
        if (localObject != null)
        {
          localObject = ((Ticket)localObject)._sig;
          if (localObject != null)
          {
            reportGetTicketResult(true, paramString2, paramString1, 0);
            QLog.d("TicketManager", 1, "get ticket succ, a!");
            return HexUtil.bytes2HexStr((byte[])localObject);
          }
          QLog.d("TicketManager", 1, "get ticket failed, A2, sig is null");
          paramInt1 = -3;
        }
        else
        {
          QLog.d("TicketManager", 1, "get ticket failed, A2, ticket is null");
          paramInt1 = -2;
        }
      }
      else
      {
        QLog.d("TicketManager", 1, "get ticket failed, A2, uin is empty!");
        paramInt1 = -1;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get ticket failed, A2, exception: ");
      localStringBuilder.append(localException.toString());
      QLog.d("TicketManager", 1, localStringBuilder.toString());
      paramInt1 = -4;
    }
    if ((this.mApp != null) && (!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.mApp.getAccount())) && (!TextUtils.isEmpty((CharSequence)this.mAlterTicketsMap.get(paramString2))))
    {
      reportGetTicketResult(true, paramString2, paramString1, paramInt1);
      return (String)this.mAlterTicketsMap.get(paramString2);
    }
    reportGetTicketResult(false, paramString2, paramString1, paramInt1);
    return null;
  }
  
  private String getSkey(String paramString, int paramInt)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = this.mWtLoginHelper.GetLocalTicket(paramString, paramInt, 4096);
        if (localObject != null)
        {
          localObject = ((Ticket)localObject)._sig;
          if (localObject != null)
          {
            reportGetTicketResult(true, "SKEY", paramString, 0);
            QLog.d("TicketManager", 1, "get ticket succ, sk!");
            return new String((byte[])localObject);
          }
          QLog.d("TicketManager", 1, "get ticket failed, SKEY, sig is null");
          paramInt = -3;
        }
        else
        {
          QLog.d("TicketManager", 1, "get ticket failed, SKEY, ticket is null");
          paramInt = -2;
        }
      }
      else
      {
        QLog.d("TicketManager", 1, "get ticket failed, SKEY, uin is empty!");
        paramInt = -1;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get ticket failed, SKEY, exception: ");
      localStringBuilder.append(localException.toString());
      QLog.d("TicketManager", 1, localStringBuilder.toString());
      paramInt = -4;
    }
    if ((this.mApp != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.mApp.getAccount())) && (!TextUtils.isEmpty((CharSequence)this.mAlterTicketsMap.get("skey"))))
    {
      reportGetTicketResult(true, "SKEY", paramString, paramInt);
      return (String)this.mAlterTicketsMap.get("skey");
    }
    reportGetTicketResult(false, "SKEY", paramString, paramInt);
    return null;
  }
  
  private void reportGetTicketResult(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  public String getA2(String paramString)
  {
    return getA2Impl(paramString, 16, 64, "A2");
  }
  
  public byte[] getDA2(String paramString)
  {
    int i;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = this.mWtLoginHelper.GetLocalTicket(paramString, 16L, 33554432);
        if (localObject != null)
        {
          localObject = ((Ticket)localObject)._sig;
          if (localObject != null)
          {
            reportGetTicketResult(true, "da2", paramString, 0);
            QLog.d("TicketManager", 1, "get ticket succ, da!");
            return localObject;
          }
          QLog.d("TicketManager", 1, "get ticket failed, da2, sig is null");
          i = -3;
        }
        else
        {
          QLog.d("TicketManager", 1, "get ticket failed, da2, ticket is null");
          i = -2;
        }
      }
      else
      {
        QLog.d("TicketManager", 1, "get ticket failed, da2, uin is empty!");
        i = -1;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get ticket failed, da2, exception: ");
      localStringBuilder.append(localException.toString());
      QLog.d("TicketManager", 1, localStringBuilder.toString());
      i = -4;
    }
    reportGetTicketResult(false, "da2", paramString, i);
    return null;
  }
  
  public Ticket getLocalTicket(String paramString, int paramInt)
  {
    try
    {
      paramString = this.mWtLoginHelper.GetLocalTicket(paramString, 16L, paramInt);
      return paramString;
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cannot getLocalTicket from helper ");
      localStringBuilder.append(paramString.toString());
      QLog.d("TicketManager", 1, localStringBuilder.toString());
    }
    return null;
  }
  
  public String getOpenSdkKey(String paramString, int paramInt)
  {
    if (paramInt != 64)
    {
      if (paramInt != 4096)
      {
        paramString = new StringBuilder();
        paramString.append("getOpenSdkKey type: ");
        paramString.append(paramInt);
        QLog.d("TicketManager", 1, paramString.toString());
        return null;
      }
      return getSkey(paramString, 1600001540);
    }
    return getA2Impl(paramString, 1600001540, paramInt, "OpenConnectA2");
  }
  
  public String getPskey(String paramString1, String paramString2)
  {
    int i;
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("domain: ");
        ((StringBuilder)localObject).append(paramString2);
        QLog.d("TicketManager", 1, ((StringBuilder)localObject).toString());
        localObject = this.mWtLoginHelper.GetLocalTicket(paramString1, 16L, 1048576);
        if ((localObject != null) && (((Ticket)localObject)._pskey_map != null))
        {
          paramString2 = (byte[])((Ticket)localObject)._pskey_map.get(paramString2);
          if (paramString2 != null)
          {
            reportGetTicketResult(true, "PSKEY", paramString1, 0);
            QLog.d("TicketManager", 1, "get ticket succ, ps!");
            return new String(paramString2);
          }
          QLog.d("TicketManager", 1, "get ticket failed, PSKEY, sig is null");
          i = -3;
        }
        else
        {
          QLog.d("TicketManager", 1, "get ticket failed, PSKEY, ticket is null");
          i = -2;
        }
      }
      else
      {
        QLog.d("TicketManager", 1, "get ticket failed, PSKEY, uin is empty!");
        i = -1;
      }
    }
    catch (Exception paramString2)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get ticket failed, PSKEY, exception: ");
      ((StringBuilder)localObject).append(paramString2.toString());
      QLog.d("TicketManager", 1, ((StringBuilder)localObject).toString());
      i = -4;
    }
    reportGetTicketResult(false, "PSKEY", paramString1, i);
    return null;
  }
  
  public Ticket getPskey(String paramString, long paramLong, String[] paramArrayOfString, WtTicketPromise paramWtTicketPromise)
  {
    try
    {
      paramString = this.mWtLoginHelper.GetPskey(paramString, paramLong, paramArrayOfString, paramWtTicketPromise);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("cannot getpskey from helper ");
      paramArrayOfString.append(paramString.toString());
      QLog.d("TicketManager", 1, paramArrayOfString.toString());
    }
    return null;
  }
  
  public String getPt4Token(String paramString1, String paramString2)
  {
    int i;
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("domain: ");
        ((StringBuilder)localObject).append(paramString2);
        QLog.d("TicketManager", 1, ((StringBuilder)localObject).toString());
        localObject = this.mWtLoginHelper.GetLocalTicket(paramString1, 16L, 1048576);
        if (localObject != null)
        {
          paramString2 = ((Ticket)localObject).getPt4Token(paramString2);
          if (paramString2 != null)
          {
            reportGetTicketResult(true, "PT4TOKEN", paramString1, 0);
            QLog.d("TicketManager", 1, "get ticket succ, pt!");
            return paramString2;
          }
          QLog.d("TicketManager", 1, "get ticket failed, PT4TOKEN, expired");
          i = -3;
        }
        else
        {
          QLog.d("TicketManager", 1, "get ticket failed, PT4TOKEN, ticket is null");
          i = -2;
        }
      }
      else
      {
        QLog.d("TicketManager", 1, "get ticket failed, PT4TOKEN, uin is empty!");
        i = -1;
      }
    }
    catch (Exception paramString2)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get ticket failed, PT4TOKEN, exception: ");
      ((StringBuilder)localObject).append(paramString2.toString());
      QLog.d("TicketManager", 1, ((StringBuilder)localObject).toString());
      i = -4;
    }
    reportGetTicketResult(false, "PT4TOKEN", paramString1, i);
    return null;
  }
  
  public String getSkey(String paramString)
  {
    return getSkey(paramString, 16);
  }
  
  public Ticket getSkey(String paramString, long paramLong, WtTicketPromise paramWtTicketPromise)
  {
    try
    {
      paramString = this.mWtLoginHelper.GetSkey(paramString, paramLong, paramWtTicketPromise);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramWtTicketPromise = new StringBuilder();
      paramWtTicketPromise.append("cannot getskey from helper ");
      paramWtTicketPromise.append(paramString.toString());
      QLog.d("TicketManager", 1, paramWtTicketPromise.toString());
    }
    return null;
  }
  
  public byte[] getSt(String paramString, int paramInt)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = this.mWtLoginHelper.GetLocalTicket(paramString, paramInt, 128);
        if (localObject != null)
        {
          localObject = ((Ticket)localObject)._sig;
          if (localObject != null)
          {
            reportGetTicketResult(true, "st", paramString, 0);
            QLog.d("TicketManager", 1, "get ticket succ, st!");
            return localObject;
          }
          QLog.d("TicketManager", 1, "get ticket failed, st, sig is null");
          paramInt = -3;
        }
        else
        {
          QLog.d("TicketManager", 1, "get ticket failed, st, ticket is null");
          paramInt = -2;
        }
      }
      else
      {
        QLog.d("TicketManager", 1, "get ticket failed, st, uin is empty!");
        paramInt = -1;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get ticket failed, st, exception: ");
      localStringBuilder.append(localException.toString());
      QLog.d("TicketManager", 1, localStringBuilder.toString());
      paramInt = -4;
    }
    reportGetTicketResult(false, "st", paramString, paramInt);
    return null;
  }
  
  public byte[] getStkey(String paramString, int paramInt)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = this.mWtLoginHelper.GetLocalTicket(paramString, paramInt, 128);
        if (localObject != null)
        {
          localObject = ((Ticket)localObject)._sig_key;
          if (localObject != null)
          {
            reportGetTicketResult(true, "stKey", paramString, 0);
            QLog.d("TicketManager", 1, "get ticket succ, stKey!");
            return localObject;
          }
          QLog.d("TicketManager", 1, "get ticket failed, stKey, sig is null");
          paramInt = -3;
        }
        else
        {
          QLog.d("TicketManager", 1, "get ticket failed, stKey, ticket is null");
          paramInt = -2;
        }
      }
      else
      {
        QLog.d("TicketManager", 1, "get ticket failed, stKey, uin is empty!");
        paramInt = -1;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get ticket failed, stKey, exception: ");
      localStringBuilder.append(localException.toString());
      QLog.d("TicketManager", 1, localStringBuilder.toString());
      paramInt = -4;
    }
    reportGetTicketResult(false, "stKey", paramString, paramInt);
    return null;
  }
  
  public String getStweb(String paramString)
  {
    int i;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = this.mWtLoginHelper.GetLocalTicket(paramString, 16L, 32);
        if (localObject != null)
        {
          localObject = ((Ticket)localObject)._sig;
          if (localObject != null)
          {
            reportGetTicketResult(true, "STWEB", paramString, 0);
            QLog.d("TicketManager", 1, "get ticket succ, st!");
            return HexUtil.bytes2HexStr((byte[])localObject);
          }
          QLog.d("TicketManager", 1, "get ticket failed, STWEB, sig is null");
          i = -3;
        }
        else
        {
          QLog.d("TicketManager", 1, "get ticket failed, STWEB, ticket is null");
          i = -2;
        }
      }
      else
      {
        QLog.d("TicketManager", 1, "get ticket failed, STWEB, uin is empty!");
        i = -1;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get ticket failed, STWEB, exception: ");
      localStringBuilder.append(localException.toString());
      QLog.d("TicketManager", 1, localStringBuilder.toString());
      i = -4;
    }
    if ((this.mApp != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.mApp.getAccount())) && (!TextUtils.isEmpty((CharSequence)this.mAlterTicketsMap.get("stweb"))))
    {
      reportGetTicketResult(true, "STWEB", paramString, i);
      return (String)this.mAlterTicketsMap.get("stweb");
    }
    reportGetTicketResult(false, "STWEB", paramString, i);
    return null;
  }
  
  public String getSuperkey(String paramString)
  {
    int i;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = this.mWtLoginHelper.GetLocalTicket(paramString, 16L, 1048576);
        if (localObject != null)
        {
          localObject = ((Ticket)localObject)._sig;
          if (localObject != null)
          {
            reportGetTicketResult(true, "SUPERKEY", paramString, 0);
            QLog.d("TicketManager", 1, "get ticket succ, su!");
            return new String((byte[])localObject);
          }
          QLog.d("TicketManager", 1, "get ticket failed, SUPERKEY, sig is null");
          i = -3;
        }
        else
        {
          QLog.d("TicketManager", 1, "get ticket failed, SUPERKEY, ticket is null");
          i = -2;
        }
      }
      else
      {
        QLog.d("TicketManager", 1, "get ticket failed, SUPERKEY, uin is empty!");
        i = -1;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get ticket failed, SUPERKEY, exception: ");
      localStringBuilder.append(localException.toString());
      QLog.d("TicketManager", 1, localStringBuilder.toString());
      i = -4;
    }
    if ((this.mApp != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.mApp.getAccount())) && (!TextUtils.isEmpty((CharSequence)this.mAlterTicketsMap.get("superkey"))))
    {
      reportGetTicketResult(true, "SUPERKEY", paramString, i);
      return (String)this.mAlterTicketsMap.get("superkey");
    }
    reportGetTicketResult(false, "SUPERKEY", paramString, i);
    return null;
  }
  
  public Ticket getTicket(String paramString, long paramLong, int paramInt, WtTicketPromise paramWtTicketPromise, Bundle paramBundle)
  {
    try
    {
      paramString = this.mWtLoginHelper.GetTicket(paramString, paramLong, paramInt, paramWtTicketPromise, paramBundle);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramWtTicketPromise = new StringBuilder();
      paramWtTicketPromise.append("cannot getticket from helper ");
      paramWtTicketPromise.append(paramString.toString());
      QLog.d("TicketManager", 1, paramWtTicketPromise.toString());
    }
    return null;
  }
  
  @Deprecated
  public String getVkey(String paramString)
  {
    return null;
  }
  
  public void onDestroy() {}
  
  public void registTicketManagerListener(TicketManagerListener paramTicketManagerListener)
  {
    try
    {
      if (!this.mTicketListeners.contains(paramTicketManagerListener))
      {
        this.mTicketListeners.add(paramTicketManagerListener);
        return;
      }
    }
    catch (Throwable paramTicketManagerListener)
    {
      paramTicketManagerListener.printStackTrace();
    }
  }
  
  public void reloadCache(Context paramContext)
  {
    QLog.d("TicketManager", 1, "reload ticket cache");
    WtloginHelper localWtloginHelper = this.mWtLoginHelper;
    if (localWtloginHelper == null) {
      this.mWtLoginHelper = new WtloginHelper(paramContext, true);
    } else {
      localWtloginHelper.RefreshMemorySig();
    }
    paramContext = this.mTicketListeners;
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      paramContext = this.mTicketListeners.iterator();
      while (paramContext.hasNext()) {
        ((TicketManagerListener)paramContext.next()).onTicketRefreshed();
      }
    }
  }
  
  public int sendRPCData(long paramLong, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      NewIntent localNewIntent = new NewIntent(this.mApp.getApplication(), BuiltInServlet.class);
      localNewIntent.putExtra("uin", paramString1);
      localNewIntent.putExtra("cmd", paramString2);
      localNewIntent.putExtra("busBuf", paramArrayOfByte);
      localNewIntent.putExtra("timeout", paramInt);
      localNewIntent.putExtra("wtsdkseq", paramLong);
      localNewIntent.putExtra("action", 2203);
      this.mApp.getServletContainer().forward(this.mApp, localNewIntent);
      return 0;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return -1;
  }
  
  public void setAlterTicket(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null)
    {
      if (this.mApp == null) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("set alter tickets for ");
      ((StringBuilder)localObject).append(MsfSdkUtils.getShortUin(this.mApp.getAccount()));
      QLog.d("TicketManager", 1, ((StringBuilder)localObject).toString());
      localObject = (String)paramHashMap.get("uin");
      String str1 = (String)paramHashMap.get("A2");
      String str2 = (String)paramHashMap.get("vkey");
      String str3 = (String)paramHashMap.get("skey");
      String str4 = (String)paramHashMap.get("stweb");
      paramHashMap = (String)paramHashMap.get("superkey");
      AppRuntime localAppRuntime = this.mApp;
      if ((localAppRuntime != null) && (localAppRuntime.getAccount() != null) && (this.mApp.getAccount().equals(localObject)))
      {
        this.mAlterTicketsMap.put("A2", str1);
        this.mAlterTicketsMap.put("vkey", str2);
        this.mAlterTicketsMap.put("skey", str3);
        this.mAlterTicketsMap.put("stweb", str4);
        this.mAlterTicketsMap.put("superkey", paramHashMap);
      }
    }
  }
  
  public void unregistTicketManagerListener(TicketManagerListener paramTicketManagerListener)
  {
    try
    {
      if (this.mTicketListeners.contains(paramTicketManagerListener))
      {
        this.mTicketListeners.remove(paramTicketManagerListener);
        return;
      }
    }
    catch (Throwable paramTicketManagerListener)
    {
      paramTicketManagerListener.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.TicketManagerImpl
 * JD-Core Version:    0.7.0.1
 */