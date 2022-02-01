import com.tencent.device.msg.activities.DeviceMsgSettingActivity;
import mqq.app.QQPermissionCallback;

public class abkf
  implements QQPermissionCallback
{
  public abkf(DeviceMsgSettingActivity paramDeviceMsgSettingActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhdj.a(this.a);
    this.a.finish();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DeviceMsgSettingActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abkf
 * JD-Core Version:    0.7.0.1
 */