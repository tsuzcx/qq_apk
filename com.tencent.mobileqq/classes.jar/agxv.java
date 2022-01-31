import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;

public class agxv
  implements DialogInterface.OnClickListener
{
  public agxv(SendHbActivity paramSendHbActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    SendHbActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agxv
 * JD-Core Version:    0.7.0.1
 */