import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class adne
  implements DialogInterface.OnClickListener
{
  public adne(adnm paramadnm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.onCancel();
    }
    msa.e(true, false);
    paramDialogInterface.dismiss();
    msa.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adne
 * JD-Core Version:    0.7.0.1
 */