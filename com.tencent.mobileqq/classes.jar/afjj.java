import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;

public class afjj
  extends GestureDetector.SimpleOnGestureListener
{
  public afjj(ArkAppRootLayout paramArkAppRootLayout) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (ArkAppRootLayout.a(this.a) != null) {
      ArkAppRootLayout.a(this.a).a();
    }
    return super.onSingleTapUp(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afjj
 * JD-Core Version:    0.7.0.1
 */