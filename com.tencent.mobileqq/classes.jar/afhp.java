import android.view.MotionEvent;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.CommonRefreshLayout;

public abstract interface afhp
{
  public abstract void onFlingScrollHeader(int paramInt1, int paramInt2);
  
  public abstract void onTouchMoving(CommonRefreshLayout paramCommonRefreshLayout, int paramInt, MotionEvent paramMotionEvent);
  
  public abstract int onViewCompleteAfterRefresh(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afhp
 * JD-Core Version:    0.7.0.1
 */