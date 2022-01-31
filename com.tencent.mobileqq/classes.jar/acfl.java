import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class acfl
  implements DialogInterface.OnClickListener
{
  public acfl(acgy paramacgy) {}
  
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
 * Qualified Name:     acfl
 * JD-Core Version:    0.7.0.1
 */