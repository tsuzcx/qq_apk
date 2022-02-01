import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;

public class aktd
  implements DialogInterface.OnClickListener
{
  public aktd(TransactionActivity paramTransactionActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aktd
 * JD-Core Version:    0.7.0.1
 */