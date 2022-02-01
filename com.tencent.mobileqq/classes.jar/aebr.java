import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class aebr
  implements DialogInterface.OnClickListener
{
  public aebr(aebz paramaebz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.a();
    }
    mru.e(true, false);
    paramDialogInterface.dismiss();
    mru.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebr
 * JD-Core Version:    0.7.0.1
 */