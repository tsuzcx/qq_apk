package mqq.app;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class MobileQQ$5
  implements Runnable
{
  MobileQQ$5(MobileQQ paramMobileQQ, SimpleAccount paramSimpleAccount, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString) {}
  
  public void run()
  {
    int i;
    if (MobileQQ.access$000(this.this$0) == null) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject1 = this.this$0.createRuntime(MobileQQ.processName, true);
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(MobileQQ.processName);
      ((StringBuilder)localObject1).append(" needn't AppRuntime!");
      QLog.i("mqq", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject2 = this.this$0;
    ((AppRuntime)localObject1).init((MobileQQ)localObject2, MobileQQ.access$100((MobileQQ)localObject2), this.val$account);
    if (!this.this$0.getQQProcessName().endsWith(":video")) {
      ((AppRuntime)localObject1).getService().msfSub.registerMsfService();
    }
    localObject2 = this.val$account;
    if ((localObject2 != null) && (((SimpleAccount)localObject2).isLogined()))
    {
      boolean bool;
      if (this.val$cnrType != 2) {
        bool = ((AppRuntime)localObject1).canAutoLogin(this.val$account.getUin());
      } else {
        bool = true;
      }
      if ((this.val$forLogin) || (bool)) {
        ((AppRuntime)localObject1).setLogined();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("createNewRuntime, canAutoOK: ");
      ((StringBuilder)localObject2).append(bool);
      QLog.d("MobileQQ", 1, new Object[] { ((StringBuilder)localObject2).toString(), " uin : ", MsfSdkUtils.getShortUin(this.val$account.getUin()) });
    }
    else
    {
      localObject2 = this.val$account;
      if (localObject2 != null) {
        QLog.d("MobileQQ", 1, new Object[] { "CNR account != null and account.isLogined =", Boolean.valueOf(((SimpleAccount)localObject2).isLogined()), " uin : ", MsfSdkUtils.getShortUin(this.val$account.getUin()) });
      } else {
        QLog.d("MobileQQ", 1, "CNR account == null");
      }
    }
    MobileQQ.access$802(this.this$0, ((AppRuntime)localObject1).isLogin());
    if (((AppRuntime)localObject1).isLogin())
    {
      if (MobileQQ.access$000(this.this$0) != null)
      {
        MobileQQ.access$000(this.this$0).logout(Constants.LogoutReason.switchAccount, true);
        MobileQQ.access$000(this.this$0).onDestroy();
      }
      if (this.val$needSaveLoginTime)
      {
        localObject2 = this.this$0.getFirstSimpleAccount();
        long l3 = System.currentTimeMillis();
        long l2 = l3;
        if (localObject2 != null)
        {
          long l1 = l3;
          try
          {
            localObject4 = this.this$0;
            l1 = l3;
            MobileQQ localMobileQQ = this.this$0;
            l1 = l3;
            StringBuilder localStringBuilder = new StringBuilder();
            l1 = l3;
            localStringBuilder.append(((SimpleAccount)localObject2).getUin());
            l1 = l3;
            localStringBuilder.append(Constants.Key._logintime);
            l1 = l3;
            long l4 = ((MobileQQ)localObject4).string2Long(localMobileQQ.getProperty(localStringBuilder.toString()));
            l2 = l3;
            if (l3 <= l4)
            {
              l3 = 1L + l4;
              l1 = l3;
              l2 = l3;
              if (QLog.isColorLevel())
              {
                l1 = l3;
                QLog.d("mqq", 2, "CNR account savetime => system time is error..");
                l2 = l3;
              }
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            l2 = l1;
          }
        }
        Object localObject3 = ((AppRuntime)localObject1).getAccount();
        if ((localObject3 != null) && (this.this$0.getQQProcessName().equals(this.this$0.getPackageName())))
        {
          localObject3 = this.this$0.mHandler.obtainMessage(3, localObject3);
          this.this$0.mHandler.sendMessageDelayed((Message)localObject3, 1000L);
        }
        localObject3 = this.this$0;
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((AppRuntime)localObject1).getAccount());
        ((StringBuilder)localObject4).append(Constants.Key._logintime);
        ((MobileQQ)localObject3).setProperty(((StringBuilder)localObject4).toString(), String.valueOf(l2));
      }
      ((AppRuntime)localObject1).onCreate(null);
      MobileQQ.access$002(this.this$0, (AppRuntime)localObject1);
    }
    else if (MobileQQ.access$000(this.this$0) == null)
    {
      ((AppRuntime)localObject1).onCreate(null);
      MobileQQ.access$002(this.this$0, (AppRuntime)localObject1);
    }
    localObject1 = this.this$0.mHandler.obtainMessage(1);
    ((Message)localObject1).arg2 = i;
    ((Message)localObject1).arg1 = this.val$cnrType;
    ((Message)localObject1).obj = this.val$process;
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      this.this$0.mHandler.dispatchMessage((Message)localObject1);
      return;
    }
    this.this$0.mHandler.sendMessage((Message)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.MobileQQ.5
 * JD-Core Version:    0.7.0.1
 */