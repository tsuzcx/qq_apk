import android.content.Intent;
import android.util.Base64;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.activity.QQIdentiferLegacyActivity;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0x87a.RspBody;
import tencent.im.oidb.oidb_0x87c.RspBody;

public class adoj
  extends ayeu
{
  public adoj(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.e("Q.devlock.AuthDevVerifyCodeActivity", 1, "set face data onRecvVerifyCode error, code : " + this.a.b + " ");
    if (paramInt != -1) {}
    for (;;)
    {
      this.a.a(paramString2, 1);
      return;
      paramString2 = this.a.getString(2131715770);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this.a, QQIdentiferLegacyActivity.class);
    localIntent.putExtra("platformAppId", 101810106);
    localIntent.putExtra("srcAppId", 101810106);
    localIntent.putExtra("srcOpenId", paramString1);
    localIntent.putExtra("key", paramString2);
    localIntent.putExtra("method", "setFaceData");
    localIntent.putExtra("serviceType", 2);
    this.a.startActivityForResult(localIntent, 21);
    AuthDevVerifyCodeActivity.a(this.a).setClickable(false);
  }
  
  public void a(oidb_0x87a.RspBody paramRspBody)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.c();
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "Set face data onRecvVerifyCode");
    }
    AuthDevVerifyCodeActivity.b(this.a).setVisibility(0);
    int i = 60;
    if (paramRspBody.uint32_resend_interval.get() > 0) {
      i = paramRspBody.uint32_resend_interval.get();
    }
    AuthDevVerifyCodeActivity.a(this.a, i);
  }
  
  public void a(oidb_0x87c.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "onVerifyClose ret = ");
    }
    if (this.a.isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "onVerifyClose activity is finishing.");
      }
      return;
    }
    this.a.c();
    AuthDevVerifyCodeActivity.a(this.a);
    paramRspBody = Base64.encodeToString(paramRspBody.toByteArray(), 11);
    bccl.a(101810106, this.a.getCurrentAccountUin(), "sms", paramRspBody, AuthDevVerifyCodeActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adoj
 * JD-Core Version:    0.7.0.1
 */