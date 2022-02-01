import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.MotionEvent;

class aahp
  implements RecyclerView.OnItemTouchListener
{
  aahp(aahk paramaahk) {}
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    return aahk.a(this.a, paramMotionEvent);
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    if (aahk.a(this.a) != null) {
      aahk.a(this.a).a(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aahp
 * JD-Core Version:    0.7.0.1
 */