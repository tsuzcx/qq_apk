import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;

public final class aebo
  implements DialogInterface.OnCancelListener
{
  public aebo(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a != null) {
      this.a.onClick(paramDialogInterface, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebo
 * JD-Core Version:    0.7.0.1
 */