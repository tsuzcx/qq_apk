import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.fragment.LingHbFragment;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class albb
  implements View.OnClickListener
{
  public albb(LingHbFragment paramLingHbFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.c.clearFocus();
    LingHbFragment.a(this.a).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     albb
 * JD-Core Version:    0.7.0.1
 */