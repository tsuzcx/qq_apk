import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.tencent.mobileqq.activity.HotChatAnnounceActivity;

public class ades
  implements TextWatcher
{
  public ades(HotChatAnnounceActivity paramHotChatAnnounceActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if ((paramEditable != null) && (paramEditable.trim().length() > 0))
    {
      this.a.b.setEnabled(true);
      return;
    }
    this.a.b.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ades
 * JD-Core Version:    0.7.0.1
 */