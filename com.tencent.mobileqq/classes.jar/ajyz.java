import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;

public final class ajyz
  extends View.AccessibilityDelegate
{
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    EditText localEditText = (EditText)paramView;
    localEditText.setHint("");
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setContentDescription(localEditText.getContentDescription());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyz
 * JD-Core Version:    0.7.0.1
 */