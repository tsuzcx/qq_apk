import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.device.bind.DevicePluginDownloadActivity;

public class abtn
  implements DialogInterface.OnClickListener
{
  public abtn(DevicePluginDownloadActivity paramDevicePluginDownloadActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bnrt.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abtn
 * JD-Core Version:    0.7.0.1
 */