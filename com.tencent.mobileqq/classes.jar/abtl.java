import com.tencent.device.bind.DevicePluginDownloadActivity;
import mqq.app.QQPermissionCallback;

public class abtl
  implements QQPermissionCallback
{
  public abtl(DevicePluginDownloadActivity paramDevicePluginDownloadActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhlq.b(this.a);
    this.a.finish();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DevicePluginDownloadActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abtl
 * JD-Core Version:    0.7.0.1
 */