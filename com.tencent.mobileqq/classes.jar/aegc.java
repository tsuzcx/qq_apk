import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.location.LocationListener;
import com.tencent.mobileqq.nearby.now.location.TLocationManager;
import com.tencent.util.LogUtil;
import mqq.os.MqqHandler;

public class aegc
  implements TencentLocationListener
{
  private LocationListener jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationListener;
  private Runnable jdField_a_of_type_JavaLangRunnable = new aegd(this);
  
  public aegc(TLocationManager paramTLocationManager, LocationListener paramLocationListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationListener = paramLocationListener;
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void onLocationChanged(TencentLocation paramTencentLocation, int paramInt, String paramString)
  {
    LogUtil.i("TLocationManager", "onLocationChanged error = " + paramInt + ", msg = " + paramString + ", Latitude = " + paramTencentLocation.getLatitude() + ", Longitude = " + paramTencentLocation.getLongitude());
    b();
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationTLocationManager.a(paramTencentLocation, this, this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationListener);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationTLocationManager.a(this, this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationListener);
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aegc
 * JD-Core Version:    0.7.0.1
 */