import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.app.ThreadManager;

public class ambo
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ambo(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void onGlobalLayout()
  {
    ThreadManager.post(this.a, 8, null, false);
    this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ambo
 * JD-Core Version:    0.7.0.1
 */