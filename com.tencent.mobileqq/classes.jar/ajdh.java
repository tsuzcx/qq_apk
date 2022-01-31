import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.Overlay;
import com.tencent.tencentmap.mapsdk.map.Projection;

public class ajdh
  extends Overlay
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private GeoPoint jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint;
  
  public ajdh(Bitmap paramBitmap, GeoPoint paramGeoPoint)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint = paramGeoPoint;
  }
  
  public void draw(Canvas paramCanvas, MapView paramMapView)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint != null))
    {
      Point localPoint = paramMapView.getProjection().toPixels(this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint, null);
      localPoint.x -= this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2;
      localPoint.y -= this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2;
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localPoint.x, localPoint.y, localPaint);
    }
    super.draw(paramCanvas, paramMapView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajdh
 * JD-Core Version:    0.7.0.1
 */