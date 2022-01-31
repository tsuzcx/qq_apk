import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.onSizeChangedListenner;

public class akuq
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public akuq(InputMethodRelativeLayout paramInputMethodRelativeLayout) {}
  
  public void onGlobalLayout()
  {
    int i;
    if (this.a.a != null)
    {
      i = InputMethodRelativeLayout.a(this.a);
      if (i != InputMethodRelativeLayout.b(this.a))
      {
        int j = this.a.getRootView().getHeight();
        if (j - i <= j / 4) {
          break label102;
        }
        InputMethodRelativeLayout.a(this.a, true);
      }
    }
    for (;;)
    {
      this.a.a.a(InputMethodRelativeLayout.a(this.a), InputMethodRelativeLayout.b(this.a), i);
      this.a.requestLayout();
      InputMethodRelativeLayout.a(this.a, i);
      return;
      label102:
      InputMethodRelativeLayout.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akuq
 * JD-Core Version:    0.7.0.1
 */