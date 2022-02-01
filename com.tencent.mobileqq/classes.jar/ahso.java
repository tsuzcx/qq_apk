import android.view.View.MeasureSpec;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.qphone.base.util.QLog;

public class ahso
  implements ahse
{
  public ahso(VoiceTextPanel paramVoiceTextPanel) {}
  
  public void a()
  {
    VoiceTextPanel.a(this.a).hideSoftInput();
  }
  
  public void a(int paramInt)
  {
    if (VoiceTextPanel.a(this.a).b() != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextPanel", 2, "onActionDown but mHeader cannot see");
      }
      return;
    }
    VoiceTextPanel.a(this.a, true);
    this.a.measure(View.MeasureSpec.makeMeasureSpec(this.a.getRight() - this.a.getLeft(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt - this.a.getTop(), 1073741824));
    this.a.layout(this.a.getLeft(), this.a.getTop(), this.a.getRight(), paramInt);
    VoiceTextPanel.a(this.a).a(this.a.getLeft(), this.a.getTop(), this.a.getRight(), this.a.getBottom(), paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextPanel", 2, "enterEditState");
    }
    VoiceTextPanel.a(this.a).a();
    VoiceTextPanel.a(this.a).a(paramInt1, paramInt2, this.a.getHeight(), this.a.getTop());
    VoiceTextPanel.a(this.a).showInputPanel();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    VoiceTextPanel.a(this.a).a(paramInt1, paramInt2, paramInt3);
    VoiceTextPanel.a(this.a).b();
  }
  
  public void b()
  {
    VoiceTextPanel.a(this.a).a(true);
    VoiceTextPanel.a(this.a, false);
    VoiceTextPanel.a(this.a).b();
  }
  
  public void c()
  {
    VoiceTextPanel.a(this.a).a(false);
    VoiceTextPanel.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahso
 * JD-Core Version:    0.7.0.1
 */