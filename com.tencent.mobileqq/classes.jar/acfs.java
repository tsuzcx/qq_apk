import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class acfs
  implements DialogInterface.OnClickListener
{
  public acfs(acgy paramacgy) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.a();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfs
 * JD-Core Version:    0.7.0.1
 */