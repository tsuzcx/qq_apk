import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aaoj
  implements View.OnClickListener
{
  public aaoj(VideoPlayerView paramVideoPlayerView) {}
  
  public void onClick(View paramView)
  {
    VideoPlayerView.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaoj
 * JD-Core Version:    0.7.0.1
 */