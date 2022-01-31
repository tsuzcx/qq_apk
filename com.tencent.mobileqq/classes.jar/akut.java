import android.annotation.TargetApi;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.tencent.mobileqq.widget.LeftPopupMenuDialog;

public class akut
  extends View.AccessibilityDelegate
{
  public akut(LeftPopupMenuDialog paramLeftPopupMenuDialog) {}
  
  @TargetApi(14)
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 32) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akut
 * JD-Core Version:    0.7.0.1
 */