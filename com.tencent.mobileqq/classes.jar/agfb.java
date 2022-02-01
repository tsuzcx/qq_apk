import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.atomic.AtomicInteger;

public class agfb
  implements View.OnClickListener
{
  public agfb(VoiceTextEditPanel paramVoiceTextEditPanel) {}
  
  public void onClick(View paramView)
  {
    if ((VoiceTextEditPanel.a(this.a).get() == 1) || (VoiceTextEditPanel.a(this.a).get() == 3)) {
      QQToast.a(this.a.getContext(), anni.a(2131715528), 0).b(this.a.getContext().getResources().getDimensionPixelSize(2131298998));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agfb
 * JD-Core Version:    0.7.0.1
 */