import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;

public class ahgn
  implements View.OnTouchListener
{
  public ahgn(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramMotionEvent = (InputMethodManager)this.a.getSystemService("input_method");
    if (paramMotionEvent.isActive()) {
      paramMotionEvent.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
    this.a.a.clearFocus();
    paramView = this.a.a.getText().toString();
    this.a.a.setSelection(paramView.length());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgn
 * JD-Core Version:    0.7.0.1
 */