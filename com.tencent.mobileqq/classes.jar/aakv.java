import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.qphone.base.util.QLog;
import face.qqlogin.FaceSecureCheck.SecureCheckResponse;

public class aakv
  extends atzn
{
  public aakv(AuthDevActivity paramAuthDevActivity) {}
  
  public void a(FaceSecureCheck.SecureCheckResponse paramSecureCheckResponse)
  {
    AuthDevActivity.a(this.a, paramSecureCheckResponse);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    bcpw.a(this.a, paramString2, 0).a();
    QLog.e("Q.devlock.AuthDevActivity", 1, "cmd : " + paramString1 + " request failed  code : " + paramInt + " message : " + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aakv
 * JD-Core Version:    0.7.0.1
 */