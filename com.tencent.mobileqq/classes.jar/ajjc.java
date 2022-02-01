import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class ajjc
  implements View.OnClickListener
{
  private WeakReference<ajiy> a;
  
  public ajjc(ajiy paramajiy)
  {
    this.a = new WeakReference(paramajiy);
  }
  
  public void onClick(View paramView)
  {
    ajiy localajiy = (ajiy)this.a.get();
    if (localajiy != null) {
      localajiy.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjc
 * JD-Core Version:    0.7.0.1
 */