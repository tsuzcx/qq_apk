import com.tencent.mobileqq.nearby.now.view.logic.VideoInfoListenerImpl;
import com.tencent.mobileqq.nearby.now.view.widget.HorizontalBallLoadingView;

public class afdn
  implements Runnable
{
  public afdn(VideoInfoListenerImpl paramVideoInfoListenerImpl) {}
  
  public void run()
  {
    if (VideoInfoListenerImpl.a(this.a) != null) {
      VideoInfoListenerImpl.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afdn
 * JD-Core Version:    0.7.0.1
 */