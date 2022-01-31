import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class ackq
  implements DialogInterface.OnClickListener
{
  public ackq(acln paramacln) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.a();
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackq
 * JD-Core Version:    0.7.0.1
 */