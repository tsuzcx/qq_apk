import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawHbFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akzv
  implements View.OnClickListener
{
  public akzv(DrawHbFragment paramDrawHbFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzv
 * JD-Core Version:    0.7.0.1
 */