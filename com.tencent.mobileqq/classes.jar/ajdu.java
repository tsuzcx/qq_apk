import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class ajdu
  implements DialogInterface.OnKeyListener
{
  ajdu(ajdq paramajdq, ajdy paramajdy) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_a_of_type_Ajdy != null)) {
      this.jdField_a_of_type_Ajdy.a(this.jdField_a_of_type_Ajdq.a(), "sc.xy_alert_show_success.local", "{\"cancel\":1}");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajdu
 * JD-Core Version:    0.7.0.1
 */