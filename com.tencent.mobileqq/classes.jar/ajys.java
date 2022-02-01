import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.fragment.KuaKuaHbFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajys
  implements View.OnClickListener
{
  public ajys(KuaKuaHbFragment paramKuaKuaHbFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof TextView)) {
      KuaKuaHbFragment.a(this.a).setText(((TextView)paramView).getText().toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajys
 * JD-Core Version:    0.7.0.1
 */