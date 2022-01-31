import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;

class aihy
  implements PopupWindow.OnDismissListener
{
  aihy(aihx paramaihx) {}
  
  public void onDismiss()
  {
    WindowManager.LayoutParams localLayoutParams = ((Activity)this.a.a).getWindow().getAttributes();
    localLayoutParams.alpha = 1.0F;
    ((Activity)this.a.a).getWindow().setAttributes(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aihy
 * JD-Core Version:    0.7.0.1
 */