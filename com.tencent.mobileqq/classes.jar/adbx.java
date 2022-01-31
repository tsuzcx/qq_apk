import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.atomic.AtomicInteger;

public class adbx
  implements CompoundButton.OnCheckedChangeListener
{
  public adbx(VoiceTextEditPanel paramVoiceTextEditPanel) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((VoiceTextEditPanel.a(this.a).get() > 0) && (bbkk.a(VoiceTextEditPanel.a(this.a))) && (!VoiceTextEditPanel.a(this.a).isEnabled())) {
        this.a.setSendEnable(true);
      }
      if (VoiceTextEditPanel.a(this.a) != null) {
        VoiceTextEditPanel.a(this.a).edit().putBoolean("businessinfo_ptt_vt_send_type_" + VoiceTextEditPanel.a(this.a).getCurrentAccountUin(), true).commit();
      }
      VoiceTextEditPanel.a(this.a).setText(2131719289);
      if (this.a.a())
      {
        axqy.b(null, "dc00898", "", "", "0X800A1D8", "0X800A1D8", 2, 0, "", "", "", "");
        return;
      }
      axqy.b(null, "dc00898", "", "", "0X800A1D8", "0X800A1D8", 1, 0, "", "", "", "");
      return;
    }
    if (VoiceTextEditPanel.a(this.a) != null) {
      VoiceTextEditPanel.a(this.a).edit().putBoolean("businessinfo_ptt_vt_send_type_" + VoiceTextEditPanel.a(this.a).getCurrentAccountUin(), false).commit();
    }
    VoiceTextEditPanel.a(this.a).setText(2131719287);
    if ((VoiceTextEditPanel.a(this.a).get() == 5) && (bbkk.a(VoiceTextEditPanel.a(this.a)))) {
      this.a.setSendEnable(false);
    }
    if (this.a.a())
    {
      axqy.b(null, "dc00898", "", "", "0X800A1D9", "0X800A1D9", 2, 0, "", "", "", "");
      return;
    }
    axqy.b(null, "dc00898", "", "", "0X800A1D9", "0X800A1D9", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adbx
 * JD-Core Version:    0.7.0.1
 */