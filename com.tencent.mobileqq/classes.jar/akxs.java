import android.content.Context;
import android.graphics.Point;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

public class akxs
  implements TencentMap.OnMapLoadedCallback
{
  public akxs(ARScanEntryView paramARScanEntryView) {}
  
  public void onMapLoaded()
  {
    this.a.j = true;
    if (ARScanEntryView.a(this.a) != null)
    {
      Projection localProjection = ARScanEntryView.a(this.a).getMap().getProjection();
      TencentMap localTencentMap = ARScanEntryView.a(this.a).getMap();
      if ((localProjection != null) && (localTencentMap != null))
      {
        Point localPoint = localProjection.toScreenLocation(localTencentMap.getCameraPosition().target);
        if (localPoint != null)
        {
          localPoint.offset(0, aciy.a(60.0F, this.a.a.getResources()) * -1);
          localTencentMap.moveCamera(CameraUpdateFactory.newLatLng(localProjection.fromScreenLocation(localPoint)));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akxs
 * JD-Core Version:    0.7.0.1
 */