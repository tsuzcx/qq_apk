import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.activity.PublicAccountListActivity;

public class adpk
  implements TextWatcher
{
  public adpk(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.a.getText().toString().trim();
    this.a.b(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adpk
 * JD-Core Version:    0.7.0.1
 */