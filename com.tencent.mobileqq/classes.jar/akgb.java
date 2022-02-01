import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import mqq.app.QQPermissionCallback;

class akgb
  implements QQPermissionCallback
{
  akgb(akga paramakga) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhdj.a(this.a.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akgb
 * JD-Core Version:    0.7.0.1
 */