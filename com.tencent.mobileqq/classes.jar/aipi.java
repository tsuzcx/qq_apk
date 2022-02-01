import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class aipi
  implements View.OnClickListener
{
  private WeakReference<aipe> a;
  
  public aipi(aipe paramaipe)
  {
    this.a = new WeakReference(paramaipe);
  }
  
  public void onClick(View paramView)
  {
    aipe localaipe = (aipe)this.a.get();
    if (localaipe != null) {
      localaipe.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipi
 * JD-Core Version:    0.7.0.1
 */