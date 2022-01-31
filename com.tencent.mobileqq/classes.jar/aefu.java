import android.content.Context;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.nearby.now.location.SelectLocationFragment;

public class aefu
  implements TextView.OnEditorActionListener
{
  public aefu(SelectLocationFragment paramSelectLocationFragment) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 2) || (paramInt == 3) || (paramInt == 6))
    {
      paramKeyEvent = (InputMethodManager)paramTextView.getContext().getSystemService("input_method");
      if (paramKeyEvent.isActive()) {
        paramKeyEvent.hideSoftInputFromWindow(paramTextView.getApplicationWindowToken(), 0);
      }
      SelectLocationFragment.a(this.a).removeMessages(1);
      SelectLocationFragment.a(this.a).sendEmptyMessage(1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aefu
 * JD-Core Version:    0.7.0.1
 */