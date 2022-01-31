import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;

public class abqh
  implements View.OnFocusChangeListener
{
  public abqh(SelectedAndSearchBar paramSelectedAndSearchBar) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (SelectedAndSearchBar.a(this.a) != null) {
      SelectedAndSearchBar.a(this.a).a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abqh
 * JD-Core Version:    0.7.0.1
 */