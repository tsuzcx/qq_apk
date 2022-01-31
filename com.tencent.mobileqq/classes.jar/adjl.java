import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

public class adjl
  implements QQPermissionCallback
{
  public adjl(ProfileCardMoreActivity paramProfileCardMoreActivity1, ProfileCardMoreActivity paramProfileCardMoreActivity2) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("IphoneTitleBarActivity", 1, "User requestPermissions denied...");
    bdcd.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("IphoneTitleBarActivity", 1, "User requestPermissions grant...");
    this.b.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adjl
 * JD-Core Version:    0.7.0.1
 */