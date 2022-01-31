import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.msfmqpsdkbridge.MSFIntChkStrike;

public class akzm
  implements DialogInterface.OnDismissListener
{
  public akzm(MSFIntChkStrike paramMSFIntChkStrike) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    MSFIntChkStrike.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akzm
 * JD-Core Version:    0.7.0.1
 */