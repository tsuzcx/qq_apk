import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class aapo
  implements DialogInterface.OnClickListener
{
  public aapo(aaqa paramaaqa) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aapo
 * JD-Core Version:    0.7.0.1
 */