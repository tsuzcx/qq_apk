import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.now.enter.NowFestivalWebViewFragment;

public class afne
  implements Runnable
{
  public afne(NowFestivalWebViewFragment paramNowFestivalWebViewFragment) {}
  
  public void run()
  {
    NowFestivalWebViewFragment.a(this.a).setVisibility(8);
    NowFestivalWebViewFragment.a(this.a).startAnimation(AnimationUtils.loadAnimation(NowFestivalWebViewFragment.a(this.a), 2131034322));
    NowFestivalWebViewFragment.a(this.a).l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     afne
 * JD-Core Version:    0.7.0.1
 */