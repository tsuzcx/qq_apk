import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.fragment.KuaKuaHbFragment;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alay
  implements View.OnClickListener
{
  public alay(KuaKuaHbFragment paramKuaKuaHbFragment) {}
  
  public void onClick(View paramView)
  {
    if (KuaKuaHbFragment.a(this.a) != null) {
      KuaKuaHbFragment.a(this.a).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alay
 * JD-Core Version:    0.7.0.1
 */