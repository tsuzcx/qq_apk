import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class abut
  implements View.OnClickListener
{
  public abut(GdtVideoImaxFragment paramGdtVideoImaxFragment) {}
  
  public void onClick(View paramView)
  {
    GdtVideoImaxFragment.a(this.a);
    GdtVideoImaxFragment.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abut
 * JD-Core Version:    0.7.0.1
 */