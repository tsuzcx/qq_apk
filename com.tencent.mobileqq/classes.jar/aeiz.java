import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NewAuthDevUgFragment;
import com.tencent.mobileqq.activity.NewAuthDevUgFragment.1.1;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.VerifyDevLockManager.NotifyType;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.tools.ErrMsg;

public class aeiz
  extends VerifyDevLockManager.VerifyDevLockObserver
{
  public aeiz(NewAuthDevUgFragment paramNewAuthDevUgFragment) {}
  
  public void onReceive(VerifyDevLockManager.NotifyType paramNotifyType, int paramInt, Object paramObject)
  {
    int i = 1;
    if (this.a.a())
    {
      QLog.e("NewAuthDevUgFragment", 1, "onReceive getActivity is null or activity is finish");
      return;
    }
    if (paramObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("NewAuthDevUgFragment", 1, new Object[] { "VerifyDevLockObserver onReceive, type is ", paramNotifyType, ", ret is ", Integer.valueOf(paramInt), "data == null ? ", Boolean.valueOf(bool) });
      if ((paramNotifyType != VerifyDevLockManager.NotifyType.NOTIFY_GET_GATEWAY_URL) || (paramInt != 239)) {
        break;
      }
      NewAuthDevUgFragment.a(this.a, 0);
      NewAuthDevUgFragment.a(this.a, paramObject);
      return;
    }
    if (paramNotifyType == VerifyDevLockManager.NotifyType.NOTIFY_CHECK_SELF_PHONE)
    {
      if ((NewAuthDevUgFragment.a(this.a) instanceof QQAppInterface)) {}
      for (paramNotifyType = (QQAppInterface)NewAuthDevUgFragment.a(this.a);; paramNotifyType = null) {
        switch (paramInt)
        {
        default: 
          NewAuthDevUgFragment.a(this.a);
          NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt, "");
          NewAuthDevUgFragment.b(this.a);
          awov.a(NewAuthDevUgFragment.a(this.a), paramNotifyType, 3, NewAuthDevUgFragment.a(this.a));
          return;
        }
      }
      NewAuthDevUgFragment.a(this.a);
      NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt, "need sms");
      NewAuthDevUgFragment.b(this.a);
      return;
      NewAuthDevUgFragment.a(this.a);
      NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt, "not match");
      NewAuthDevUgFragment.c(this.a);
      awov.a(NewAuthDevUgFragment.a(this.a), paramNotifyType, 5, NewAuthDevUgFragment.a(this.a));
      return;
      NewAuthDevUgFragment.a(this.a);
      NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt, "pre check not match");
      NewAuthDevUgFragment.b(this.a);
      awov.a(NewAuthDevUgFragment.a(this.a), paramNotifyType, 5, NewAuthDevUgFragment.a(this.a));
      return;
      NewAuthDevUgFragment.a(this.a);
      if (NewAuthDevUgFragment.b(this.a) > 5)
      {
        NewAuthDevUgFragment.a(this.a);
        NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt, "redirect time out");
        NewAuthDevUgFragment.b(this.a);
        awov.a(NewAuthDevUgFragment.a(this.a), paramNotifyType, 3, NewAuthDevUgFragment.a(this.a));
        return;
      }
      QLog.d("NewAuthDevUgFragment", 1, "VerifyDevLockObserver redirect");
      NewAuthDevUgFragment.a(this.a, paramObject);
      return;
    }
    NewAuthDevUgFragment.a(this.a);
    if (paramNotifyType == VerifyDevLockManager.NotifyType.NOTIFY_GET_GATEWAY_URL)
    {
      if (i == 0) {
        break label530;
      }
      paramNotifyType = "V_GET_GATEWAY_URL_ERROR";
      label462:
      NewAuthDevUgFragment.a(this.a, paramNotifyType, paramInt, "");
      NewAuthDevUgFragment.b(this.a);
      if (!(NewAuthDevUgFragment.a(this.a) instanceof QQAppInterface)) {
        break label536;
      }
    }
    label530:
    label536:
    for (paramNotifyType = (QQAppInterface)NewAuthDevUgFragment.a(this.a);; paramNotifyType = null)
    {
      awov.a(NewAuthDevUgFragment.a(this.a), paramNotifyType, 3, NewAuthDevUgFragment.a(this.a));
      return;
      i = 0;
      break;
      paramNotifyType = "V_VERIFY_TOKEN_ERROR";
      break label462;
    }
  }
  
  public void onVerifyClose(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg)
  {
    if (this.a.a())
    {
      QLog.e("NewAuthDevUgFragment", 1, "onVerifyClose getActivity is null or activity is finish");
      return;
    }
    QLog.d("NewAuthDevUgFragment", 1, new Object[] { "onVerifyClose ret : ", Integer.valueOf(paramInt2) });
    if (paramInt2 == 0)
    {
      NewAuthDevUgFragment.a(this.a, "V_RET_SUCCESS", paramInt2, "");
      NewAuthDevUgFragment.d(this.a);
      NewAuthDevUgFragment.a(this.a).postDelayed(new NewAuthDevUgFragment.1.1(this), 800L);
      if (NewAuthDevUgFragment.a(this.a))
      {
        paramString = NewAuthDevUgFragment.a(this.a).getHandler(LoginActivity.class);
        if (paramString != null) {
          paramString.sendEmptyMessage(20200515);
        }
        paramString = NewAuthDevUgFragment.a(this.a).getHandler(SubLoginActivity.class);
        if (paramString != null) {
          paramString.sendEmptyMessage(20200515);
        }
        paramString = NewAuthDevUgFragment.a(this.a).getHandler(AddAccountActivity.class);
        if (paramString != null) {
          paramString.sendEmptyMessage(20200515);
        }
      }
      if ((NewAuthDevUgFragment.a(this.a) instanceof QQAppInterface))
      {
        paramString = (QQAppInterface)NewAuthDevUgFragment.a(this.a);
        awov.a(NewAuthDevUgFragment.a(this.a), paramString, 4, NewAuthDevUgFragment.a(this.a));
        if (!(NewAuthDevUgFragment.a(this.a) instanceof QQAppInterface)) {
          break label270;
        }
      }
      label270:
      for (paramString = (QQAppInterface)NewAuthDevUgFragment.a(this.a);; paramString = null)
      {
        bdla.a(paramString, "dc00898", "", NewAuthDevUgFragment.a(this.a), "0X800AEFB", "0X800AEFB", 0, 0, "", "", "", "");
        return;
        paramString = null;
        break;
      }
    }
    QLog.e("NewAuthDevUgFragment", 1, new Object[] { "VerifyDevLockObserver onVerifyClose error, ret : ", Integer.valueOf(paramInt2) });
    NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt2, paramErrMsg.getMessage());
    NewAuthDevUgFragment.b(this.a);
    if ((NewAuthDevUgFragment.a(this.a) instanceof QQAppInterface)) {}
    for (paramString = (QQAppInterface)NewAuthDevUgFragment.a(this.a);; paramString = null)
    {
      awov.a(NewAuthDevUgFragment.a(this.a), paramString, 3, NewAuthDevUgFragment.a(this.a));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeiz
 * JD-Core Version:    0.7.0.1
 */