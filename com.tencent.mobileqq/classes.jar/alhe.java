import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.msfmqpsdkbridge.MSFIntChkStrike;

public class alhe
  implements DialogInterface.OnDismissListener
{
  public alhe(MSFIntChkStrike paramMSFIntChkStrike) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    MSFIntChkStrike.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alhe
 * JD-Core Version:    0.7.0.1
 */