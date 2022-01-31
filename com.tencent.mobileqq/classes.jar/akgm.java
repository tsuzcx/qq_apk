import android.annotation.TargetApi;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.tencent.mobileqq.widget.LeftPopupMenuDialog;

public class akgm
  extends View.AccessibilityDelegate
{
  public akgm(LeftPopupMenuDialog paramLeftPopupMenuDialog) {}
  
  @TargetApi(14)
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 32) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akgm
 * JD-Core Version:    0.7.0.1
 */