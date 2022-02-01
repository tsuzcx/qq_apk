import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aalp
  implements View.OnClickListener
{
  public aalp(SubscribeVideoDetailFragment paramSubscribeVideoDetailFragment) {}
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    aagc localaagc;
    if ((SubscribeVideoDetailFragment.a(this.a) != null) && (SubscribeVideoDetailFragment.a(this.a) != null))
    {
      localaagc = SubscribeVideoDetailFragment.a(this.a).a(1);
      bool1 = bool2;
      if (SubscribeVideoDetailFragment.a(this.a).j()) {
        if (SubscribeVideoDetailFragment.a(this.a).l()) {
          break label88;
        }
      }
    }
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localaagc.c = bool1;
      this.a.a(localaagc);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalp
 * JD-Core Version:    0.7.0.1
 */