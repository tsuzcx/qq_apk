import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import mqq.app.QQPermissionCallback;

class afvs
  implements QQPermissionCallback
{
  afvs(afvr paramafvr) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    babr.a(this.a.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afvs
 * JD-Core Version:    0.7.0.1
 */