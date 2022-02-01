import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import face.qqlogin.FaceSecureCheck.SecureCheckResponse;

public class acts
  extends axkv
{
  public acts(AuthDevActivity paramAuthDevActivity) {}
  
  public void checkSecureResponse(FaceSecureCheck.SecureCheckResponse paramSecureCheckResponse)
  {
    AuthDevActivity.a(this.a, paramSecureCheckResponse);
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    QQToast.a(this.a, paramString2, 0).a();
    QLog.e("Q.devlock.AuthDevActivity", 1, "cmd : " + paramString1 + " request failed  code : " + paramInt + " message : " + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acts
 * JD-Core Version:    0.7.0.1
 */