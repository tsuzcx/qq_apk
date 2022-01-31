import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;

public class affa
  implements View.OnClickListener
{
  public affa(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (InputMethodManager)this.a.getSystemService("input_method");
    if ((paramView != null) && (paramView.isActive())) {
      paramView.hideSoftInputFromWindow(this.a.getWindow().getDecorView().getWindowToken(), 0);
    }
    this.a.setResult(1);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     affa
 * JD-Core Version:    0.7.0.1
 */