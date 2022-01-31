import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.location.LocationDataManager;
import com.tencent.mobileqq.nearby.now.location.LocationListener;
import com.tencent.mobileqq.nearby.now.location.SelectLocationFragment;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.util.LogUtil;
import mqq.os.MqqHandler;

public class aesw
  implements LocationListener
{
  public aesw(SelectLocationFragment paramSelectLocationFragment) {}
  
  public void a(LocationInfo paramLocationInfo)
  {
    ThreadManager.getUIHandler().removeCallbacks(this.a.a);
    LogUtil.d("SelectLocationFragment", "getLocation: onSuccess :" + paramLocationInfo.toString());
    SelectLocationFragment.a(this.a, paramLocationInfo);
    if (SelectLocationFragment.e())
    {
      SelectLocationFragment.a(this.a).setCity("北京");
      SelectLocationFragment.a(this.a).setName("天安门广场");
      SelectLocationFragment.a(this.a).setLat("39.914380");
      SelectLocationFragment.a(this.a).setLng("116.412914");
      SelectLocationFragment.a(this.a, SelectLocationFragment.a(this.a));
    }
    SelectLocationFragment.a(this.a).a(paramLocationInfo);
  }
  
  public void b(LocationInfo paramLocationInfo)
  {
    ThreadManager.getUIHandler().removeCallbacks(this.a.a);
    LogUtil.d("SelectLocationFragment", "getLocation: onFail");
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aesw
 * JD-Core Version:    0.7.0.1
 */