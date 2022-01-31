import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;

public class abxa
  implements DialogInterface.OnDismissListener
{
  public abxa(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abxa
 * JD-Core Version:    0.7.0.1
 */