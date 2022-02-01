import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class adra
  implements DialogInterface.OnClickListener
{
  adra(adsx paramadsx) {}
  
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
 * Qualified Name:     adra
 * JD-Core Version:    0.7.0.1
 */