import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.map.ARGridMapViewDialog;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;

public class abgy
  implements TencentMap.OnMapCameraChangeListener
{
  public abgy(ARMapActivity paramARMapActivity) {}
  
  public void onCameraChange(CameraPosition paramCameraPosition) {}
  
  public void onCameraChangeFinish(CameraPosition paramCameraPosition)
  {
    if (ARMapActivity.a(this.a) != null) {
      ARMapActivity.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abgy
 * JD-Core Version:    0.7.0.1
 */