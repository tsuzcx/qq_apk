import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;

public final class aapr
  implements DialogInterface.OnCancelListener
{
  public aapr(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a != null) {
      this.a.onClick(paramDialogInterface, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aapr
 * JD-Core Version:    0.7.0.1
 */