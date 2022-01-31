import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.tencent.mobileqq.activity.contacts.view.SimpleSlidingIndicator;

public class ahqu
  extends View.AccessibilityDelegate
{
  public ahqu(SimpleSlidingIndicator paramSimpleSlidingIndicator) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 4096) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqu
 * JD-Core Version:    0.7.0.1
 */