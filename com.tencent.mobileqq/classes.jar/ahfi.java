import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.FileUtils;

class ahfi
  implements DialogInterface.OnClickListener
{
  ahfi(ahff paramahff) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    FileUtils.deleteFile(this.a.b);
    this.a.b = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfi
 * JD-Core Version:    0.7.0.1
 */