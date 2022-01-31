import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.HistorySearchEntryModel;
import com.tencent.qphone.base.util.BaseApplication;

public class ahqz
  implements View.OnTouchListener
{
  public ahqz(HistorySearchEntryModel paramHistorySearchEntryModel) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahqz
 * JD-Core Version:    0.7.0.1
 */