import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.now.enter.NowFestivalWebViewFragment;

public class agak
  implements Runnable
{
  public agak(NowFestivalWebViewFragment paramNowFestivalWebViewFragment) {}
  
  public void run()
  {
    NowFestivalWebViewFragment.a(this.a).setVisibility(8);
    NowFestivalWebViewFragment.a(this.a).startAnimation(AnimationUtils.loadAnimation(NowFestivalWebViewFragment.a(this.a), 2131034322));
    NowFestivalWebViewFragment.a(this.a).l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agak
 * JD-Core Version:    0.7.0.1
 */