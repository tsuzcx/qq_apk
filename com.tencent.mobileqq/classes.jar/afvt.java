import com.tencent.mobileqq.activity.ProfileActivity;
import mqq.app.QQPermissionCallback;

class afvt
  implements QQPermissionCallback
{
  afvt(afvr paramafvr) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    babr.a(this.a.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a.a = ProfileActivity.a(this.a.a, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afvt
 * JD-Core Version:    0.7.0.1
 */