import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawHbFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class algk
  implements View.OnClickListener
{
  public algk(DrawHbFragment paramDrawHbFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.a(DrawHbFragment.a(this.a).getText().toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     algk
 * JD-Core Version:    0.7.0.1
 */