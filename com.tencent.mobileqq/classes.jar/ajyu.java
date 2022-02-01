import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.fragment.LingHbFragment;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajyu
  implements View.OnClickListener
{
  public ajyu(LingHbFragment paramLingHbFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.c.clearFocus();
    LingHbFragment.a(this.a).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyu
 * JD-Core Version:    0.7.0.1
 */