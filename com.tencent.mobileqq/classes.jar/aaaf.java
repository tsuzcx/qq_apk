import android.os.Handler;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView.15.1;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView.15.2;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.superplayer.api.ISuperPlayer;

public class aaaf
  implements aabh
{
  public aaaf(VideoPlayerView paramVideoPlayerView) {}
  
  public void a(boolean paramBoolean)
  {
    VideoPlayerView.d(this.a, paramBoolean);
    if (VideoPlayerView.d(this.a)) {
      this.a.a().post(new VideoPlayerView.15.1(this));
    }
    do
    {
      do
      {
        return;
        if (VideoPlayerView.b(this.a))
        {
          this.a.a().post(new VideoPlayerView.15.2(this));
          return;
        }
      } while (!VideoPlayerView.e(this.a));
      if (this.a.a() != null) {
        this.a.a().setLoopback(true);
      }
      this.a.h();
    } while (VideoPlayerView.a(this.a) == null);
    VideoPlayerView.a(this.a).onVideoStart((int)this.a.a().getDurationMs());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaaf
 * JD-Core Version:    0.7.0.1
 */