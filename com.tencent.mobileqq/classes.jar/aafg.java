import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class aafg
  implements DialogInterface.OnClickListener
{
  public aafg(aagm paramaagm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.a();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aafg
 * JD-Core Version:    0.7.0.1
 */