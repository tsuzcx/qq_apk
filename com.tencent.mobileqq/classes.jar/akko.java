import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.utils.NewUpgradeDialog;
import java.lang.ref.WeakReference;

public class akko
  implements DialogInterface.OnKeyListener
{
  public akko(NewUpgradeDialog paramNewUpgradeDialog) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.a.dismiss();
      ((Activity)this.a.a.get()).finish();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akko
 * JD-Core Version:    0.7.0.1
 */