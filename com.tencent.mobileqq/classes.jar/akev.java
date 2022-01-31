import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.widget.ConfigClearableEditText;

public class akev
  implements TextWatcher
{
  public akev(ConfigClearableEditText paramConfigClearableEditText) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = this.a.getText().toString();
    if (this.a.isFocused())
    {
      if ((paramCharSequence == null) || (paramCharSequence.length() == 0)) {
        this.a.setClearButtonVisible(false);
      }
    }
    else {
      return;
    }
    if ((ConfigClearableEditText.a(this.a)) || (ConfigClearableEditText.b(this.a)))
    {
      this.a.setClearButtonVisible(true);
      return;
    }
    this.a.setClearButtonVisible(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akev
 * JD-Core Version:    0.7.0.1
 */