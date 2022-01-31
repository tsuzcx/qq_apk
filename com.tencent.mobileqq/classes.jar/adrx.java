import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;

public class adrx
  implements View.OnFocusChangeListener
{
  public adrx(SelectedAndSearchBar paramSelectedAndSearchBar) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (SelectedAndSearchBar.a(this.a) != null) {
      SelectedAndSearchBar.a(this.a).a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adrx
 * JD-Core Version:    0.7.0.1
 */