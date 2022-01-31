import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class alup
  implements DialogInterface.OnClickListener
{
  alup(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    alun.a("1");
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (this.a != null) {
      this.a.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alup
 * JD-Core Version:    0.7.0.1
 */