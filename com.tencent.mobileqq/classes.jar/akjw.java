import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.msfmqpsdkbridge.MSFIntChkStrike;

public class akjw
  implements DialogInterface.OnDismissListener
{
  public akjw(MSFIntChkStrike paramMSFIntChkStrike) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    MSFIntChkStrike.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akjw
 * JD-Core Version:    0.7.0.1
 */