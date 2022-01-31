import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class acfr
  implements DialogInterface.OnClickListener
{
  public acfr(acgy paramacgy) {}
  
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
 * Qualified Name:     acfr
 * JD-Core Version:    0.7.0.1
 */