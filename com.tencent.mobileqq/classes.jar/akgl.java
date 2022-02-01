import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import mqq.app.QQPermissionCallback;

public class akgl
  implements QQPermissionCallback
{
  public akgl(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhdj.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AvatarPendantActivity.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akgl
 * JD-Core Version:    0.7.0.1
 */