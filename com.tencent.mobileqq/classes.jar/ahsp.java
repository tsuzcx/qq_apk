import android.view.MotionEvent;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

public class ahsp
  implements ahsg
{
  public ahsp(VoiceTextPanel paramVoiceTextPanel) {}
  
  public void a()
  {
    VoiceTextPanel.a(this.a).mCustomTitleView.setVisibility(0);
    VoiceTextPanel.a(this.a).j();
    if (!VoiceTextPanel.a(this.a).a().a())
    {
      VoiceTextPanel.a(this.a).showAudioPanel(false);
      VoiceTextPanel.a(this.a).a();
    }
    for (;;)
    {
      VoiceTextPanel.a(this.a);
      return;
      VoiceTextPanel.a(this.a).a(1);
      VoiceTextPanel.a(this.a).hideAllPanels();
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 2) || (!VoiceTextPanel.a(this.a).a().a())) {
      return;
    }
    VoiceTextPanel.a(this.a).a(paramMotionEvent);
  }
  
  public void a(String paramString)
  {
    VoiceTextPanel.a(this.a).b(paramString);
    VoiceTextPanel.a(this.a).a().b(true);
    VoiceTextPanel.a(this.a).a();
    this.a.c();
  }
  
  public void b()
  {
    VoiceTextPanel.a(this.a).mCustomTitleView.setVisibility(0);
    if (!VoiceTextPanel.a(this.a).a().a())
    {
      VoiceTextPanel.a(this.a).showAudioPanel(false);
      VoiceTextPanel.a(this.a).a();
      VoiceTextPanel.a(this.a).g();
      ahtf.a("0X800A1DB", 1, 0);
    }
    for (;;)
    {
      VoiceTextPanel.a(this.a);
      return;
      VoiceTextPanel.a(this.a).a(1);
      VoiceTextPanel.a(this.a).hideAllPanels();
      ahtf.a("0X800A1DB", 2, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsp
 * JD-Core Version:    0.7.0.1
 */