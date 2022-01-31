import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.database.corrupt.DBFixDialogUI;
import com.tencent.mobileqq.database.corrupt.DBFixManager;

public class abpb
  implements DialogInterface.OnClickListener
{
  public abpb(DBFixDialogUI paramDBFixDialogUI) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    DBFixDialogUI.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abpb
 * JD-Core Version:    0.7.0.1
 */