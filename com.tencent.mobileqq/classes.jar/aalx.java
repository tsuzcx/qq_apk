import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.qphone.base.util.BaseApplication;

public class aalx
  implements View.OnTouchListener
{
  public aalx(AutoRemarkActivity paramAutoRemarkActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    do
    {
      return false;
      paramView = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
    } while (!paramView.isActive());
    paramView.hideSoftInputFromWindow(this.a.getWindow().getDecorView().getWindowToken(), 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aalx
 * JD-Core Version:    0.7.0.1
 */