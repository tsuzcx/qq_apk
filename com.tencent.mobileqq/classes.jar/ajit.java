import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;

public class ajit
  implements DialogInterface.OnDismissListener
{
  public ajit(TroopCreateLogic paramTroopCreateLogic) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajit
 * JD-Core Version:    0.7.0.1
 */