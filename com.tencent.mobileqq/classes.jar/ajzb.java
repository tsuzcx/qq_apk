import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;

public final class ajzb
  extends View.AccessibilityDelegate
{
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setVisibleToUser(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzb
 * JD-Core Version:    0.7.0.1
 */