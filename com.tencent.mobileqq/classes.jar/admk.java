import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;

public class admk
  extends GestureDetector.SimpleOnGestureListener
{
  public admk(ArkAppRootLayout paramArkAppRootLayout) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (ArkAppRootLayout.a(this.a) != null) {
      ArkAppRootLayout.a(this.a).a();
    }
    return super.onSingleTapUp(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     admk
 * JD-Core Version:    0.7.0.1
 */