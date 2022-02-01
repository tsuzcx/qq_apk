import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajzg
  implements View.OnClickListener
{
  public ajzg(MainFragment paramMainFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.h();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzg
 * JD-Core Version:    0.7.0.1
 */