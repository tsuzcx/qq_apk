import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import mqq.app.QQPermissionCallback;

public class akmy
  implements QQPermissionCallback
{
  public akmy(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhlq.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AvatarPendantActivity.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akmy
 * JD-Core Version:    0.7.0.1
 */