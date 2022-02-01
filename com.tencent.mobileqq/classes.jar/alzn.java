import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class alzn
  implements DialogInterface.OnKeyListener
{
  alzn(alzj paramalzj, alzr paramalzr) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_a_of_type_Alzr != null)) {
      this.jdField_a_of_type_Alzr.a(this.jdField_a_of_type_Alzj.a(), "sc.xy_alert_show_success.local", "{\"cancel\":1}");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alzn
 * JD-Core Version:    0.7.0.1
 */