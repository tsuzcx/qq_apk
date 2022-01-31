import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class ajdw
  implements DialogInterface.OnKeyListener
{
  ajdw(ajds paramajds, ajea paramajea) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_a_of_type_Ajea != null)) {
      this.jdField_a_of_type_Ajea.a(this.jdField_a_of_type_Ajds.a(), "sc.xy_alert_show_success.local", "{\"cancel\":1}");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajdw
 * JD-Core Version:    0.7.0.1
 */