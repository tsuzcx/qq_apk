import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class afwk
  implements TextWatcher
{
  public afwk(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.a.getText().toString().trim();
    this.a.c(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwk
 * JD-Core Version:    0.7.0.1
 */