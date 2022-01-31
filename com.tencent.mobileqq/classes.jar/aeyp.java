import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel;
import com.tencent.mobileqq.widget.QQToast;
import java.util.concurrent.atomic.AtomicInteger;

public class aeyp
  implements View.OnClickListener
{
  public aeyp(VoiceTextEditPanel paramVoiceTextEditPanel) {}
  
  public void onClick(View paramView)
  {
    if ((VoiceTextEditPanel.a(this.a).get() == 1) || (VoiceTextEditPanel.a(this.a).get() == 3)) {
      QQToast.a(this.a.getContext(), alud.a(2131717251), 0).b(this.a.getContext().getResources().getDimensionPixelSize(2131298914));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeyp
 * JD-Core Version:    0.7.0.1
 */