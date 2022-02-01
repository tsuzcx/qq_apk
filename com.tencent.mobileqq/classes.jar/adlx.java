import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class adlx
  implements DialogInterface.OnClickListener
{
  adlx(adnm paramadnm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.onCancel();
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adlx
 * JD-Core Version:    0.7.0.1
 */