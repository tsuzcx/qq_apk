import android.graphics.Point;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener;

public class agnr
  implements TencentMap.OnMapLoadedListener
{
  public agnr(ScanTorchActivity paramScanTorchActivity) {}
  
  public void onMapLoaded()
  {
    this.a.t = true;
    if (ScanTorchActivity.a(this.a) != null)
    {
      Projection localProjection = ScanTorchActivity.a(this.a).getProjection();
      TencentMap localTencentMap = ScanTorchActivity.a(this.a).getMap();
      if ((localProjection != null) && (localTencentMap != null))
      {
        Point localPoint = localProjection.toScreenLocation(localTencentMap.getMapCenter());
        localPoint.offset(0, AIOUtils.a(60.0F, this.a.getResources()) * -1);
        localTencentMap.setCenter(localProjection.fromScreenLocation(localPoint));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agnr
 * JD-Core Version:    0.7.0.1
 */