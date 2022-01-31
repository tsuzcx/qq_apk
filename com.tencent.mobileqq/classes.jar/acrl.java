import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

public class acrl
  implements View.OnClickListener
{
  public acrl(VoiceTextEditPanel paramVoiceTextEditPanel) {}
  
  public void onClick(View paramView)
  {
    VoiceTextEditPanel.a(this.a).a.setVisibility(0);
    if (!this.a.a())
    {
      VoiceTextEditPanel.a(this.a).h(false);
      VoiceTextEditPanel.a(this.a).a();
      VoiceTextEditPanel.b(this.a);
      awqx.b(null, "dc00898", "", "", "0X800A1DB", "0X800A1DB", 1, 0, "", "", "", "");
    }
    for (;;)
    {
      VoiceTextEditPanel.c(this.a);
      return;
      VoiceTextEditPanel.a(this.a).a(1);
      VoiceTextEditPanel.a(this.a).aI();
      awqx.b(null, "dc00898", "", "", "0X800A1DB", "0X800A1DB", 2, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acrl
 * JD-Core Version:    0.7.0.1
 */