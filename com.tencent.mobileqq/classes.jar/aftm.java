import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;

public class aftm
  implements DialogInterface.OnClickListener
{
  public aftm(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aftm
 * JD-Core Version:    0.7.0.1
 */