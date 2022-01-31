import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;

public class aglz
  implements DialogInterface.OnClickListener
{
  public aglz(TransactionActivity paramTransactionActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a(TransactionActivity.b(this.a), 128, "transfer.amount.go", "", "", TransactionActivity.b(this.a), "");
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aglz
 * JD-Core Version:    0.7.0.1
 */