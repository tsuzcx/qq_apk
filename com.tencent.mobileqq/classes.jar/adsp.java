import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class adsp
  implements DialogInterface.OnClickListener
{
  public adsp(adsx paramadsx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.a();
    }
    mqw.e(true, false);
    paramDialogInterface.dismiss();
    mqw.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adsp
 * JD-Core Version:    0.7.0.1
 */