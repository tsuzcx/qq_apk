import android.app.Activity;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import com.tencent.mobileqq.nearby.now.view.widget.StoryNewGuideDialog;

public class aefc
  implements Runnable
{
  public aefc(StoryPlayController paramStoryPlayController) {}
  
  public void run()
  {
    if ((StoryPlayController.a(this.a) != null) && (StoryPlayController.a(this.a).isShowing()))
    {
      if (((this.a.a instanceof Activity)) && ((StoryPlayController.b(this.a)) || (((Activity)this.a.a).isFinishing()))) {
        StoryPlayController.a(this.a, null);
      }
    }
    else {
      return;
    }
    StoryPlayController.a(this.a).dismiss();
    StoryPlayController.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aefc
 * JD-Core Version:    0.7.0.1
 */