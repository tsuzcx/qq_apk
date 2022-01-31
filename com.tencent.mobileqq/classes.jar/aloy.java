import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import mqq.app.QQPermissionCallback;

public class aloy
  implements QQPermissionCallback
{
  public aloy(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.denied();
    babr.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aloy
 * JD-Core Version:    0.7.0.1
 */