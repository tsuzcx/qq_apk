import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.werewolves.HalfScreenBrowserActivity;

public class akzm
  implements Runnable
{
  public akzm(HalfScreenBrowserActivity paramHalfScreenBrowserActivity) {}
  
  public void run()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.a.getSystemService("input_method");
    if ((localInputMethodManager != null) && (this.a.getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(this.a.getCurrentFocus().getWindowToken(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akzm
 * JD-Core Version:    0.7.0.1
 */