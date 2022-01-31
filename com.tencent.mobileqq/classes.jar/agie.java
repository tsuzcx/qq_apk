import android.annotation.TargetApi;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.tencent.mobileqq.ocr.view.TranslatePopupActionSheetMenuDialog;

public class agie
  extends View.AccessibilityDelegate
{
  public agie(TranslatePopupActionSheetMenuDialog paramTranslatePopupActionSheetMenuDialog) {}
  
  @TargetApi(14)
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 32) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agie
 * JD-Core Version:    0.7.0.1
 */