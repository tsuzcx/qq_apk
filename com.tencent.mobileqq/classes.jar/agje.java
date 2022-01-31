import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;

public class agje
  implements TencentMap.OnMapCameraChangeListener
{
  public agje(ScanTorchActivity paramScanTorchActivity) {}
  
  public void onCameraChange(CameraPosition paramCameraPosition) {}
  
  public void onCameraChangeFinish(CameraPosition paramCameraPosition)
  {
    if ((ScanTorchActivity.a(this.a) != null) && (QLog.isColorLevel())) {
      QLog.d("ScanTorchActivity", 2, "ARLBSPOIDialog onCameraChangeFinish");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agje
 * JD-Core Version:    0.7.0.1
 */