import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.fragment.KuaKuaHbFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akul
  implements View.OnClickListener
{
  public akul(KuaKuaHbFragment paramKuaKuaHbFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof TextView)) {
      KuaKuaHbFragment.a(this.a).setText(((TextView)paramView).getText().toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akul
 * JD-Core Version:    0.7.0.1
 */