import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.location.LocationListener;
import com.tencent.mobileqq.nearby.now.location.TLocationManager;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.util.LogUtil;
import mqq.os.MqqHandler;

public class aetd
  implements aeth
{
  public aetd(TLocationManager paramTLocationManager, double paramDouble1, double paramDouble2, LocationListener paramLocationListener) {}
  
  public void a()
  {
    LogUtil.i("TLocationManager", "getCityByLatLng onFail() ");
    ThreadManager.getUIHandler().post(new aete(this));
  }
  
  public void a(String paramString)
  {
    LogUtil.i("TLocationManager", "getCityByLatLng onSuccess() " + paramString);
    LocationInfo localLocationInfo = new LocationInfo();
    localLocationInfo.lng = String.valueOf(this.jdField_a_of_type_Double);
    localLocationInfo.lat = String.valueOf(this.b);
    localLocationInfo.city = paramString;
    TLocationManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationTLocationManager, this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationListener, localLocationInfo);
    TLocationManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationTLocationManager).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aetd
 * JD-Core Version:    0.7.0.1
 */