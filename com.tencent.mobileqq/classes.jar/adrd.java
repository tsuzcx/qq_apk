import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class adrd
  implements DialogInterface.OnClickListener
{
  adrd(adsx paramadsx) {}
  
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
 * Qualified Name:     adrd
 * JD-Core Version:    0.7.0.1
 */