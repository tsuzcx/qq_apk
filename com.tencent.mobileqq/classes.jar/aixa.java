import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;

public class aixa
  implements TextView.OnEditorActionListener
{
  public aixa(TransactionActivity paramTransactionActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 6) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      if (TransactionActivity.a(this.a).isEnabled()) {
        TransactionActivity.a(this.a).performClick();
      }
      if (TransactionActivity.a(this.a) != null) {
        ((InputMethodManager)TransactionActivity.a(this.a).getSystemService("input_method")).hideSoftInputFromWindow(TransactionActivity.c(this.a).getWindowToken(), 0);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixa
 * JD-Core Version:    0.7.0.1
 */