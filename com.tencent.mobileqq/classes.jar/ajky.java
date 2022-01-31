import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;

public final class ajky
  extends View.AccessibilityDelegate
{
  public ajky(CharSequence paramCharSequence, String paramString) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
    if (this.jdField_a_of_type_JavaLangCharSequence != null) {
      paramAccessibilityNodeInfo.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
    }
    paramAccessibilityNodeInfo.setClassName(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajky
 * JD-Core Version:    0.7.0.1
 */