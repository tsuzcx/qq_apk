import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public abstract class alcd
  implements TextWatcher
{
  protected EditText a;
  
  public alcd(EditText paramEditText)
  {
    this.a = paramEditText;
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alcd
 * JD-Core Version:    0.7.0.1
 */