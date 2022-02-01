import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;

public class akzg
  implements DialogInterface.OnClickListener
{
  public akzg(SendHbActivity paramSendHbActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    SendHbActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzg
 * JD-Core Version:    0.7.0.1
 */