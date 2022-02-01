import com.tencent.mobileqq.activity.DevlockQuickLoginActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class adue
  extends WtloginObserver
{
  public adue(DevlockQuickLoginActivity paramDevlockQuickLoginActivity) {}
  
  public void onCloseCode(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("DevlockQuickLoginActivity", 2, "OnCloseCode userAccount=" + paramString + " ret=" + paramInt + " time=" + paramLong);
      if (paramArrayOfByte2 == null) {}
    }
    try
    {
      paramString = new String(paramArrayOfByte2, "utf-8");
      QLog.d("DevlockQuickLoginActivity", 2, "OnCloseCode errMsg=" + paramString);
      this.a.c();
      if (DevlockQuickLoginActivity.a(this.a)) {
        return;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
      if (paramInt == 0)
      {
        QQToast.a(this.a.getApplicationContext(), 2, 2131691991, 0).b(DevlockQuickLoginActivity.a(this.a));
        DevlockQuickLoginActivity.a(this.a);
        DevlockQuickLoginActivity.a(this.a, 0, 2130772001);
        return;
      }
      if (paramInt == 21)
      {
        paramString = this.a.getString(2131691988);
        paramArrayOfByte1 = this.a.getString(2131719059);
        this.a.a(null, paramString, paramArrayOfByte1, new aduf(this));
        return;
      }
      paramString = DevlockQuickLoginActivity.a(this.a, 2131691989);
      QQToast.a(this.a.getApplicationContext(), 1, paramString, 0).b(DevlockQuickLoginActivity.b(this.a));
    }
  }
  
  public void onException(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevlockQuickLoginActivity", 2, "OnException e=" + paramString);
    }
    this.a.c();
    QQToast.a(DevlockQuickLoginActivity.b(this.a), 1, this.a.getString(2131691990), 0).b(DevlockQuickLoginActivity.d(this.a));
  }
  
  public void onVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, ArrayList<String> paramArrayList, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevlockQuickLoginActivity", 2, "OnVerifyCode userAccount=" + paramString + " ret=" + paramInt);
    }
    if (DevlockQuickLoginActivity.b(this.a))
    {
      this.a.c();
      return;
    }
    if (paramInt == 0)
    {
      this.a.b();
      return;
    }
    this.a.c();
    if (paramInt == 21)
    {
      paramString = this.a.getString(2131691988);
      paramArrayOfByte1 = this.a.getString(2131719059);
      this.a.a(null, paramString, paramArrayOfByte1, new adug(this));
      return;
    }
    paramString = this.a.getString(2131691989);
    QQToast.a(DevlockQuickLoginActivity.a(this.a), 1, paramString, 0).b(DevlockQuickLoginActivity.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adue
 * JD-Core Version:    0.7.0.1
 */