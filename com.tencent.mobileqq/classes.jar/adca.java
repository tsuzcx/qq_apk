import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel;
import java.util.concurrent.atomic.AtomicInteger;

public class adca
  implements TextWatcher
{
  public adca(VoiceTextEditPanel paramVoiceTextEditPanel) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (VoiceTextEditPanel.a(this.a).get() == 5)
    {
      VoiceTextEditPanel.a(this.a, paramEditable.toString());
      if (!bbkk.a(VoiceTextEditPanel.a(this.a))) {
        break label55;
      }
      this.a.setSendEnable(false);
    }
    for (;;)
    {
      this.a.c();
      return;
      label55:
      this.a.setSendEnable(true);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adca
 * JD-Core Version:    0.7.0.1
 */