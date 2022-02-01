import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class aicd
  implements DialogInterface.OnClickListener
{
  aicd(aibr paramaibr) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    aibr.I(this.a).setResult(8001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicd
 * JD-Core Version:    0.7.0.1
 */