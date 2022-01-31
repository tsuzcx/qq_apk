import com.tencent.mobileqq.nearby.now.location.LocationListener;
import com.tencent.mobileqq.nearby.now.location.TLocationManager;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;

public class aetf
  implements Runnable
{
  public aetf(TLocationManager paramTLocationManager, LocationInfo paramLocationInfo, LocationListener paramLocationListener) {}
  
  public void run()
  {
    TLocationManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationTLocationManager, System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationTLocationManager.c = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.getCity();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationTLocationManager.a = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.getLng();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationTLocationManager.b = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.getLat();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationListener.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aetf
 * JD-Core Version:    0.7.0.1
 */