import com.tencent.mobileqq.activity.NearbyActivity;
import mqq.app.QQPermissionCallback;

public class adjd
  implements QQPermissionCallback
{
  public adjd(NearbyActivity paramNearbyActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdgm.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adjd
 * JD-Core Version:    0.7.0.1
 */