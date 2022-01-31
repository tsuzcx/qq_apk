import android.os.Handler;
import com.tencent.mobileqq.nearby.now.location.TLocationManager;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;

class aefy
  implements Runnable
{
  aefy(aefx paramaefx) {}
  
  public void run()
  {
    LocationInfo localLocationInfo = new LocationInfo();
    localLocationInfo.lng = String.valueOf(this.a.jdField_a_of_type_Double);
    localLocationInfo.lat = String.valueOf(this.a.b);
    localLocationInfo.city = "";
    TLocationManager.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationTLocationManager, this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationListener, localLocationInfo);
    TLocationManager.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationTLocationManager).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aefy
 * JD-Core Version:    0.7.0.1
 */