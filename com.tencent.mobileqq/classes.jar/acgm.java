import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class acgm
  implements DialogInterface.OnClickListener
{
  public acgm(acgy paramacgy) {}
  
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
 * Qualified Name:     acgm
 * JD-Core Version:    0.7.0.1
 */