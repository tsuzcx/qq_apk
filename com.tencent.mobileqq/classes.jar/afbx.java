import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.activity.OverloadTipsActivity;

public class afbx
  implements DialogInterface.OnKeyListener
{
  public afbx(OverloadTipsActivity paramOverloadTipsActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      this.a.finish();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbx
 * JD-Core Version:    0.7.0.1
 */