import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class ajul
  implements View.OnClickListener
{
  private WeakReference<ajuh> a;
  
  public ajul(ajuh paramajuh)
  {
    this.a = new WeakReference(paramajuh);
  }
  
  public void onClick(View paramView)
  {
    ajuh localajuh = (ajuh)this.a.get();
    if (localajuh != null) {
      localajuh.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajul
 * JD-Core Version:    0.7.0.1
 */