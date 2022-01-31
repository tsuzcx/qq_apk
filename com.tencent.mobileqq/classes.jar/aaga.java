import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class aaga
  implements DialogInterface.OnClickListener
{
  public aaga(aagm paramaagm) {}
  
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
 * Qualified Name:     aaga
 * JD-Core Version:    0.7.0.1
 */