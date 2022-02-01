import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class adng
  implements DialogInterface.OnClickListener
{
  public adng(adnm paramadnm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.onCancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adng
 * JD-Core Version:    0.7.0.1
 */