import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.app.FrameHelperActivity;

public class alsq
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public alsq(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.c.getVisibility() == 0) && ((this.a.c() instanceof ReadinjoyTabFrame))) {
      this.a.c.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alsq
 * JD-Core Version:    0.7.0.1
 */