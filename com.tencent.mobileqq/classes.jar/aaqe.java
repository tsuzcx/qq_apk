import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class aaqe
  implements DialogInterface.OnKeyListener
{
  aaqe(aaqa paramaaqa) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    return (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaqe
 * JD-Core Version:    0.7.0.1
 */