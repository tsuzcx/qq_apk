import android.text.TextUtils;
import android.widget.Button;
import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

public class abpd
  extends AccountObserver
{
  public abpd(RegisterSendUpSms paramRegisterSendUpSms) {}
  
  public void onRegisterQuerySmsStatResp(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    RegisterSendUpSms.c(this.a, paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("RegisterSendUpSms", 2, "onRegisterQuerySmsStatResp isSuccess=" + paramBoolean + ", code=" + paramInt1 + ", uin=" + paramString1 + ", nick=" + paramString2 + ", faceUrl=" + paramString3 + ", errmsg=" + paramString4);
    }
    if (paramInt1 == 4) {}
    for (;;)
    {
      RegisterSendUpSms.a(this.a, 0);
      return;
      RegisterSendUpSms.a(this.a).setEnabled(true);
      if (paramInt1 == 0)
      {
        RegisterSendUpSms.a(this.a).setText(ajjy.a(2131647574));
        RegisterSendUpSms.a(this.a, paramString1);
        RegisterSendUpSms.b(this.a, paramString2);
        RegisterSendUpSms.c(this.a, paramString3);
        RegisterSendUpSms.a(this.a);
        continue;
      }
      paramString1 = paramString4;
      if (paramInt1 == -1) {}
      try
      {
        paramString1 = new String(paramArrayOfByte, "utf-8");
        paramArrayOfByte = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          paramArrayOfByte = this.a.getString(2131651349);
        }
        bbmy.a(this.a, paramArrayOfByte.trim(), 0).b(this.a.getTitleBarHeight());
      }
      catch (Throwable paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          paramString1 = paramString4;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abpd
 * JD-Core Version:    0.7.0.1
 */