import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aaad
  implements View.OnClickListener
{
  public aaad(VideoPlayerView paramVideoPlayerView) {}
  
  public void onClick(View paramView)
  {
    VideoPlayerView.f(this.a);
    this.a.h();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaad
 * JD-Core Version:    0.7.0.1
 */