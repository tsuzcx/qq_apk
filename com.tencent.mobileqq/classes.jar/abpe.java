import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.database.corrupt.DBFixLoadingDialog;

public class abpe
  implements DialogInterface.OnKeyListener
{
  public abpe(DBFixLoadingDialog paramDBFixLoadingDialog) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    return (paramInt == 84) || (paramInt == 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abpe
 * JD-Core Version:    0.7.0.1
 */