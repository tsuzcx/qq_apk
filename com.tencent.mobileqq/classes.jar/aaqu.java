import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public final class aaqu
  implements View.OnTouchListener
{
  public aaqu(ImageView paramImageView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.a.setAlpha(1.0F);
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 0) {
        this.a.setAlpha(0.5F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqu
 * JD-Core Version:    0.7.0.1
 */