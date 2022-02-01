import com.tencent.device.msg.activities.DeviceTipActivity;
import mqq.app.QQPermissionCallback;

public class abyr
  implements QQPermissionCallback
{
  public abyr(DeviceTipActivity paramDeviceTipActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhlq.b(this.a);
    this.a.finish();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DeviceTipActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abyr
 * JD-Core Version:    0.7.0.1
 */