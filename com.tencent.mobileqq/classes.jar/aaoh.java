import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aaoh
  implements View.OnClickListener
{
  public aaoh(VideoPlayerView paramVideoPlayerView) {}
  
  public void onClick(View paramView)
  {
    if (VideoPlayerView.a(this.a) != null) {
      VideoPlayerView.a(this.a).setVisibility(8);
    }
    VideoPlayerView.a(this.a, false);
    VideoPlayerView.a(true);
    this.a.d();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaoh
 * JD-Core Version:    0.7.0.1
 */