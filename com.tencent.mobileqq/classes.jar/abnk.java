import com.tencent.mobileqq.activity.NearbyActivity;
import mqq.app.QQPermissionCallback;

public class abnk
  implements QQPermissionCallback
{
  public abnk(NearbyActivity paramNearbyActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bbdj.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abnk
 * JD-Core Version:    0.7.0.1
 */