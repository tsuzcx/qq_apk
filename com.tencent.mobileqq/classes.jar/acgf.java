import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.jsbridge.GdtDeviceDemoFragment;
import com.tencent.gdtad.jsbridge.GdtDeviceDemoFragment.1.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acgf
  implements View.OnClickListener
{
  public acgf(GdtDeviceDemoFragment paramGdtDeviceDemoFragment) {}
  
  public void onClick(View paramView)
  {
    AdThreadManager.INSTANCE.post(new GdtDeviceDemoFragment.1.1(this), 3);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgf
 * JD-Core Version:    0.7.0.1
 */