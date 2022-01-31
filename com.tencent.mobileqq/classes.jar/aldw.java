import android.os.Handler;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mobileqq.widget.QQMapView;

public class aldw
  implements Runnable
{
  public aldw(QQMapView paramQQMapView) {}
  
  public void run()
  {
    for (;;)
    {
      if (this.a.jdField_a_of_type_Int <= 0) {
        try
        {
          if (this.a.jdField_a_of_type_JavaLangThread != null) {
            synchronized (this.a.jdField_a_of_type_JavaLangThread)
            {
              this.a.jdField_a_of_type_Int = 0;
              this.a.b = true;
              this.a.jdField_a_of_type_JavaLangThread.wait();
            }
          }
          return;
        }
        catch (InterruptedException localInterruptedException) {}
      }
      this.a.b = false;
      Object localObject1 = this.a.getMapCenter();
      localObject1 = new GeoPoint((int)(((LatLng)localObject1).getLatitude() * 1000000.0D), (int)(((LatLng)localObject1).getLongitude() * 1000000.0D));
      if ((this.a.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint != null) && (localObject1 != null))
      {
        int i = Math.abs(this.a.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint.getLatitudeE6() - ((GeoPoint)localObject1).getLatitudeE6());
        int j = Math.abs(this.a.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint.getLongitudeE6() - ((GeoPoint)localObject1).getLongitudeE6());
        if ((i < 1) && (j < 1) && (this.a.d) && (!this.a.c))
        {
          this.a.d = false;
          if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
            this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.a(0, (GeoPoint)localObject1));
          }
        }
      }
      this.a.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint = ((GeoPoint)localObject1);
      this.a.jdField_a_of_type_Int = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aldw
 * JD-Core Version:    0.7.0.1
 */