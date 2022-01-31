import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class ackg
  implements DialogInterface.OnClickListener
{
  public ackg(acln paramacln) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.a();
    }
    mtq.e(true, false);
    paramDialogInterface.dismiss();
    mtq.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackg
 * JD-Core Version:    0.7.0.1
 */