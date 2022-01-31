import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel;

public class aeyq
  implements TextView.OnEditorActionListener
{
  public aeyq(VoiceTextEditPanel paramVoiceTextEditPanel) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 4)
    {
      azqs.b(null, "dc00898", "", "", "0X800A89F", "0X800A89F", 0, 0, "", "", "", "");
      VoiceTextEditPanel.a(this.a);
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeyq
 * JD-Core Version:    0.7.0.1
 */