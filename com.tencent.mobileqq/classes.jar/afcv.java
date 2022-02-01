import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;

public class afcv
  implements TextWatcher
{
  public afcv(SelectedAndSearchBar paramSelectedAndSearchBar) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (SelectedAndSearchBar.a(this.a) != null) {
      SelectedAndSearchBar.a(this.a).a(paramEditable);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     afcv
 * JD-Core Version:    0.7.0.1
 */