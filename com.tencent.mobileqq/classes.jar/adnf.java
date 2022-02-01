import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class adnf
  implements DialogInterface.OnClickListener
{
  public adnf(adnm paramadnm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.onCancel();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adnf
 * JD-Core Version:    0.7.0.1
 */