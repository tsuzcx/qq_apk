import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class aaps
  implements DialogInterface.OnClickListener
{
  public aaps(aaqe paramaaqe) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaps
 * JD-Core Version:    0.7.0.1
 */