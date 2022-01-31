import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;

public class abqf
  implements View.OnKeyListener
{
  public abqf(SelectedAndSearchBar paramSelectedAndSearchBar) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 67)
    {
      if (paramKeyEvent.getAction() != 0) {
        break label36;
      }
      SelectedAndSearchBar.a(this.a, TextUtils.isEmpty(SelectedAndSearchBar.a(this.a).getText()));
    }
    for (;;)
    {
      return false;
      label36:
      if ((paramKeyEvent.getAction() == 1) && (SelectedAndSearchBar.a(this.a))) {
        SelectedAndSearchBar.a(this.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abqf
 * JD-Core Version:    0.7.0.1
 */