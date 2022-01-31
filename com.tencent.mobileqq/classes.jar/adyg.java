import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

class adyg
  implements acxj
{
  adyg(adyf paramadyf) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = (adyo)((View)paramView.getParent().getParent().getParent()).getTag();
    if (paramView != null) {
      paramView.a.performLongClick();
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adyg
 * JD-Core Version:    0.7.0.1
 */