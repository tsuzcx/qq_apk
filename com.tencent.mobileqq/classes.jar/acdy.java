import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.database.corrupt.DBFixDialogUI;

public class acdy
  implements DialogInterface.OnKeyListener
{
  public acdy(DBFixDialogUI paramDBFixDialogUI) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    return (paramInt == 84) || (paramInt == 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acdy
 * JD-Core Version:    0.7.0.1
 */