import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment;
import com.tencent.mobileqq.activity.recent.RecentBaseData;

public class aijl
  implements aijo
{
  public aijl(MiniMsgTabFragment paramMiniMsgTabFragment) {}
  
  public void a(RecentBaseData paramRecentBaseData)
  {
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if (paramRecentBaseData.a().equals("0"))
    {
      MiniMsgTabFragment.a(this.a).findViewById(2131378103).performClick();
      return;
    }
    MiniChatActivity.a(localFragmentActivity, paramRecentBaseData.a(), paramRecentBaseData.a(), paramRecentBaseData.b(), false, MiniMsgTabFragment.b(this.a));
    aiiu.a("0X8009C2D");
    if (MiniMsgTabFragment.a(this.a) == null) {
      MiniMsgTabFragment.a(this.a, AnimationUtils.loadAnimation(this.a.getActivity(), 2130771995));
    }
    MiniMsgTabFragment.b(this.a).startAnimation(MiniMsgTabFragment.a(this.a));
    MiniMsgTabFragment.a(this.a).setAnimationListener(new aijm(this, localFragmentActivity));
    MiniMsgTabFragment.b(this.a).setVisibility(8);
    int i = paramRecentBaseData.a();
    if (abti.d(i)) {
      i = 1;
    }
    for (;;)
    {
      azqs.b(null, "dc00898", "", "", "0X800A0F7", "0X800A0F7", MiniMsgTabFragment.b(this.a), 1, "" + i, "", "", "");
      return;
      if (i == 1) {
        i = 2;
      } else if (i == 3000) {
        i = 4;
      } else {
        i = 5;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijl
 * JD-Core Version:    0.7.0.1
 */