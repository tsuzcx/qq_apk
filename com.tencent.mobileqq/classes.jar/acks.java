import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acks
  implements View.OnClickListener
{
  public acks(GdtVideoImaxFragment paramGdtVideoImaxFragment) {}
  
  public void onClick(View paramView)
  {
    boolean bool = this.a.a(paramView);
    GdtVideoImaxFragment.a(this.a, bool);
    GdtVideoImaxFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acks
 * JD-Core Version:    0.7.0.1
 */