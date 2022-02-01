import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.lbs.AdLocation;
import com.tencent.gdtad.jsbridge.GdtDeviceDemoFragment;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acgh
  implements View.OnClickListener
{
  public acgh(GdtDeviceDemoFragment paramGdtDeviceDemoFragment) {}
  
  public void onClick(View paramView)
  {
    AdLocation localAdLocation = GdtDeviceDemoFragment.a(LbsManagerService.getCachedLbsInfo("gdt_tangram"));
    GdtDeviceDemoFragment.a(this.a, String.format("getLocationCacheOnCurrentProcess %s", new Object[] { localAdLocation }));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgh
 * JD-Core Version:    0.7.0.1
 */