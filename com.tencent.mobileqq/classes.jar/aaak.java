import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aaak
  implements View.OnClickListener
{
  public aaak(VideoPlayerView paramVideoPlayerView) {}
  
  public void onClick(View paramView)
  {
    if (VideoPlayerView.a(this.a)) {
      VideoPlayerView.c(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      VideoPlayerView.d(this.a);
      if (VideoPlayerView.a(this.a) != null) {
        aanb.b(VideoPlayerView.a(this.a).poster.id.get(), "auth_video", "fullscreen", 0, 0, new String[] { "", "", VideoPlayerView.a(this.a).poster.nick.get(), VideoPlayerView.a(this.a).title.get() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaak
 * JD-Core Version:    0.7.0.1
 */