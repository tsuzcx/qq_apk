import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;

public class aakk
  implements View.OnClickListener
{
  public aakk(VideoPlayerView paramVideoPlayerView) {}
  
  public void onClick(View paramView)
  {
    if (aauy.a("mLLSkipBackWrapper", 500L))
    {
      VideoPlayerView.e(this.a);
      VideoPlayerView.a(this.a, VideoPlayerView.b(this.a), 0, 1, true);
      if (this.a.a() != null) {
        this.a.a(this.a.a().getCurrentPositionMs() - 10000L);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aakk
 * JD-Core Version:    0.7.0.1
 */