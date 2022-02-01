import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aepy
  implements View.OnClickListener
{
  public aepy(NearbyActivity paramNearbyActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    while (i < this.a.a.size())
    {
      ((View.OnClickListener)this.a.a.get(i)).onClick(paramView);
      i += 1;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aepy
 * JD-Core Version:    0.7.0.1
 */