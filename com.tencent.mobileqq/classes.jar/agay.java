import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;

public class agay
  implements TextWatcher
{
  public agay(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.a.getText().toString().trim();
    this.a.e(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agay
 * JD-Core Version:    0.7.0.1
 */