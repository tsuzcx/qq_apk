import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class akvg
  implements DialogInterface.OnKeyListener
{
  akvg(akvc paramakvc, akvk paramakvk) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_a_of_type_Akvk != null)) {
      this.jdField_a_of_type_Akvk.a(this.jdField_a_of_type_Akvc.a(), "sc.xy_alert_show_success.local", "{\"cancel\":1}");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvg
 * JD-Core Version:    0.7.0.1
 */