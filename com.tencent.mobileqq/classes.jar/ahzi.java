import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ahzi
  implements DialogInterface.OnClickListener
{
  ahzi(ahzf paramahzf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bgmg.d(this.a.g);
    this.a.g = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzi
 * JD-Core Version:    0.7.0.1
 */