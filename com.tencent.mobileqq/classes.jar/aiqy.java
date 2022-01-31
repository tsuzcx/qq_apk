import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class aiqy
  implements DialogInterface.OnKeyListener
{
  aiqy(aiqu paramaiqu, airc paramairc) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_a_of_type_Airc != null)) {
      this.jdField_a_of_type_Airc.a(this.jdField_a_of_type_Aiqu.a(), "sc.xy_alert_show_success.local", "{\"cancel\":1}");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiqy
 * JD-Core Version:    0.7.0.1
 */