import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer;

public class adoe
  implements Runnable
{
  public adoe(VideoFileViewer paramVideoFileViewer) {}
  
  public void run()
  {
    if (VideoFileViewer.a(this.a).getVisibility() == 0)
    {
      Animation localAnimation = VideoFileViewer.a(this.a).getAnimation();
      if (localAnimation != null) {
        localAnimation.cancel();
      }
      VideoFileViewer.a(this.a).clearAnimation();
    }
    VideoFileViewer.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adoe
 * JD-Core Version:    0.7.0.1
 */