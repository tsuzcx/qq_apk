import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class alzd
  implements DialogInterface.OnClickListener
{
  alzd(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (this.a != null) {
      this.a.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alzd
 * JD-Core Version:    0.7.0.1
 */