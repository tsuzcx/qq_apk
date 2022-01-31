import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel;

public class adcc
  implements TextView.OnEditorActionListener
{
  public adcc(VoiceTextEditPanel paramVoiceTextEditPanel) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 4)
    {
      axqw.b(null, "dc00898", "", "", "0X800A89F", "0X800A89F", 0, 0, "", "", "", "");
      VoiceTextEditPanel.a(this.a);
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adcc
 * JD-Core Version:    0.7.0.1
 */