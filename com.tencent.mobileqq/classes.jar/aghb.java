import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import dov.com.qq.im.ptv.AIOLongCaptureCtrl;

public class aghb
  implements View.OnLongClickListener
{
  public aghb(PanelIconLinearLayout paramPanelIconLinearLayout) {}
  
  public boolean onLongClick(View paramView)
  {
    if (PanelIconLinearLayout.a(this.a) != null) {
      PanelIconLinearLayout.a(this.a).a(1);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aghb
 * JD-Core Version:    0.7.0.1
 */