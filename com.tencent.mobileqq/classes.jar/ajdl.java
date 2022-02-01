import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajdl
  implements View.OnClickListener
{
  public ajdl(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void onClick(View paramView)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.a.getSystemService("input_method");
    if ((localInputMethodManager != null) && (localInputMethodManager.isActive())) {
      localInputMethodManager.hideSoftInputFromWindow(this.a.getWindow().getDecorView().getWindowToken(), 0);
    }
    this.a.setResult(1);
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdl
 * JD-Core Version:    0.7.0.1
 */