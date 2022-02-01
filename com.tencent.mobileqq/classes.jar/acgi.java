import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.jsbridge.GdtDeviceDemoFragment;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acgi
  implements View.OnClickListener
{
  public acgi(GdtDeviceDemoFragment paramGdtDeviceDemoFragment) {}
  
  public void onClick(View paramView)
  {
    GdtDeviceDemoFragment.a(this.a, "LbsManagerService.startLocation start");
    LbsManagerService.startLocation(new acgj(this, "gdt_tangram", true));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgi
 * JD-Core Version:    0.7.0.1
 */