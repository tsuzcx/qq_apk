import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class akxa
  implements View.OnTouchListener
{
  private float b = 1.0F;
  
  akxa(float paramFloat) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.b = paramView.getAlpha();
      paramView.setAlpha(this.a);
    }
    for (;;)
    {
      return false;
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        paramView.setAlpha(this.b);
      }
      else if (paramMotionEvent.getAction() == 2)
      {
        int i = (int)paramMotionEvent.getRawX();
        int j = (int)paramMotionEvent.getRawY();
        if (!akww.a(paramView, i, j)) {
          paramView.setAlpha(1.0F);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxa
 * JD-Core Version:    0.7.0.1
 */