import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class acws
  implements DialogInterface.OnClickListener
{
  public acws(acxa paramacxa) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.onCancel();
    }
    mrd.e(true, false);
    paramDialogInterface.dismiss();
    mrd.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acws
 * JD-Core Version:    0.7.0.1
 */