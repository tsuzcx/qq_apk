import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class agok
  implements DialogInterface.OnClickListener
{
  agok(agof paramagof) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agok
 * JD-Core Version:    0.7.0.1
 */