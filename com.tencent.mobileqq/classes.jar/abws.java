import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class abws
  implements DialogInterface.OnClickListener
{
  abws(abwr paramabwr) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abws
 * JD-Core Version:    0.7.0.1
 */