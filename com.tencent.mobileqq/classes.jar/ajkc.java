import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;

public class ajkc
  extends View.AccessibilityDelegate
{
  public ajkc(SimpleSlidingIndicator paramSimpleSlidingIndicator) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 4096) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkc
 * JD-Core Version:    0.7.0.1
 */