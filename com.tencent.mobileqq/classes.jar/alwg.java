import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class alwg
  implements DialogInterface.OnClickListener
{
  public alwg(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.onClick(paramDialogInterface, paramInt);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alwg
 * JD-Core Version:    0.7.0.1
 */