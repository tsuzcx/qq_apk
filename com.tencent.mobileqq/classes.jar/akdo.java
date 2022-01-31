import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.werewolves.HalfScreenBrowserActivity;

public class akdo
  implements Runnable
{
  public akdo(HalfScreenBrowserActivity paramHalfScreenBrowserActivity) {}
  
  public void run()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.a.getSystemService("input_method");
    if ((localInputMethodManager != null) && (this.a.getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(this.a.getCurrentFocus().getWindowToken(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akdo
 * JD-Core Version:    0.7.0.1
 */