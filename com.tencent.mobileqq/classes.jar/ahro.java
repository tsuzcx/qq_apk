import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;

public class ahro
  implements Runnable
{
  public ahro(ActiveEntitySearchActivity paramActiveEntitySearchActivity) {}
  
  public void run()
  {
    this.a.a.requestFocus();
    ((InputMethodManager)this.a.getSystemService("input_method")).showSoftInput(this.a.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahro
 * JD-Core Version:    0.7.0.1
 */