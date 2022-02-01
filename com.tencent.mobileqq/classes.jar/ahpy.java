import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

class ahpy
  implements agjk
{
  ahpy(ahpx paramahpx) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = (ahqh)((View)paramView.getParent().getParent().getParent()).getTag();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpy
 * JD-Core Version:    0.7.0.1
 */