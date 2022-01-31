import android.app.Activity;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class alos
  implements View.OnFocusChangeListener
{
  public alos(XPanelContainer paramXPanelContainer) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((QLog.isColorLevel()) && ((this.a.getContext() instanceof Activity))) {
      QLog.d("XPanelContainer", 2, new Object[] { "input focus changed, hasFocus=", Boolean.valueOf(paramBoolean), ", current focus=", ((Activity)this.a.getContext()).getCurrentFocus() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     alos
 * JD-Core Version:    0.7.0.1
 */