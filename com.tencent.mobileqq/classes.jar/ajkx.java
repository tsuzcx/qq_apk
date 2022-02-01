import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class ajkx
  implements View.OnClickListener
{
  private WeakReference<ajkt> a;
  
  public ajkx(ajkt paramajkt)
  {
    this.a = new WeakReference(paramajkt);
  }
  
  public void onClick(View paramView)
  {
    ajkt localajkt = (ajkt)this.a.get();
    if (localajkt != null) {
      localajkt.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkx
 * JD-Core Version:    0.7.0.1
 */