import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class akzv
  implements DialogInterface.OnKeyListener
{
  akzv(akzr paramakzr, akzz paramakzz) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_a_of_type_Akzz != null)) {
      this.jdField_a_of_type_Akzz.a(this.jdField_a_of_type_Akzr.a(), "sc.xy_alert_show_success.local", "{\"cancel\":1}");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzv
 * JD-Core Version:    0.7.0.1
 */