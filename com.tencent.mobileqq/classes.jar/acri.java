import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel;
import java.util.concurrent.atomic.AtomicInteger;

public class acri
  implements View.OnClickListener
{
  public acri(VoiceTextEditPanel paramVoiceTextEditPanel) {}
  
  public void onClick(View paramView)
  {
    if ((VoiceTextEditPanel.a(this.a).get() == 1) || (VoiceTextEditPanel.a(this.a).get() == 3)) {
      bbmy.a(this.a.getContext(), ajjy.a(2131651065), 0).b(this.a.getContext().getResources().getDimensionPixelSize(2131167766));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acri
 * JD-Core Version:    0.7.0.1
 */