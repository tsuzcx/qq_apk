import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;

public class aewa
  implements View.OnFocusChangeListener
{
  public aewa(SelectedAndSearchBar paramSelectedAndSearchBar) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (SelectedAndSearchBar.a(this.a) != null) {
      SelectedAndSearchBar.a(this.a).onEditTextFocusChanged(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aewa
 * JD-Core Version:    0.7.0.1
 */