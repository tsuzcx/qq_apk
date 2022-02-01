import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.qwallet.RedPacketKuaKuaFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akse
  implements View.OnClickListener
{
  public akse(RedPacketKuaKuaFragment paramRedPacketKuaKuaFragment) {}
  
  public void onClick(View paramView)
  {
    if (RedPacketKuaKuaFragment.a(this.a) != null) {
      RedPacketKuaKuaFragment.a(this.a).hideSoftInputFromWindow(this.a.getActivity().getWindow().getDecorView().getWindowToken(), 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akse
 * JD-Core Version:    0.7.0.1
 */