import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.fragment.KuaKuaHbFragment;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akuk
  implements View.OnClickListener
{
  public akuk(KuaKuaHbFragment paramKuaKuaHbFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      KuaKuaHbFragment.b(this.a).setVisibility(0);
      this.a.a = ((TextView)paramView).getText().toString();
      KuaKuaHbFragment.b(this.a).setText(this.a.a);
      KuaKuaHbFragment.a(this.a).setText("");
      this.a.a(this.a.a);
      KuaKuaHbFragment.a(this.a).setIsShow(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akuk
 * JD-Core Version:    0.7.0.1
 */