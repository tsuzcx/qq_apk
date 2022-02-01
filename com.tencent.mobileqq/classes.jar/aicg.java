import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class aicg
  implements DialogInterface.OnKeyListener
{
  aicg(aibr paramaibr) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.a.n = true;
      aibr.a(this.a).dismiss();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicg
 * JD-Core Version:    0.7.0.1
 */