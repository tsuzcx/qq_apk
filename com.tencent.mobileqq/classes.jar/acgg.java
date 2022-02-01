import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.lbs.AdLocation;
import com.tencent.ad.tangram.lbs.AdLocationManager;
import com.tencent.gdtad.jsbridge.GdtDeviceDemoFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acgg
  implements View.OnClickListener
{
  public acgg(GdtDeviceDemoFragment paramGdtDeviceDemoFragment) {}
  
  public void onClick(View paramView)
  {
    AdLocation localAdLocation = AdLocationManager.INSTANCE.getLocationCache(this.a.getActivity());
    GdtDeviceDemoFragment.a(this.a, String.format("getLocationCache %s", new Object[] { localAdLocation }));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgg
 * JD-Core Version:    0.7.0.1
 */