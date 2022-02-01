import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class acvj
  implements DialogInterface.OnClickListener
{
  acvj(acxa paramacxa) {}
  
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
 * Qualified Name:     acvj
 * JD-Core Version:    0.7.0.1
 */