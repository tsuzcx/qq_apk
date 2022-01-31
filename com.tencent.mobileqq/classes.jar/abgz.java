import android.graphics.Point;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener;

public class abgz
  implements TencentMap.OnMapLoadedListener
{
  public abgz(ARMapActivity paramARMapActivity) {}
  
  public void onMapLoaded()
  {
    this.a.e = true;
    if (this.a.a != null)
    {
      Projection localProjection = this.a.a.getProjection();
      TencentMap localTencentMap = this.a.a.getMap();
      if ((localProjection != null) && (localTencentMap != null))
      {
        Point localPoint = localProjection.toScreenLocation(localTencentMap.getMapCenter());
        localPoint.offset(0, AIOUtils.a(60.0F, this.a.getResources()) * -1);
        localTencentMap.setCenter(localProjection.fromScreenLocation(localPoint));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abgz
 * JD-Core Version:    0.7.0.1
 */