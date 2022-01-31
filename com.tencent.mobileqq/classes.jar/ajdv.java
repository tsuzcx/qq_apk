import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ajdv
  implements DialogInterface.OnClickListener
{
  ajdv(ajds paramajds, ajea paramajea) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Ajea != null) {
      this.jdField_a_of_type_Ajea.a(this.jdField_a_of_type_Ajds.a(), "sc.xy_alert_show_success.local", "{\"cancel\":1}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajdv
 * JD-Core Version:    0.7.0.1
 */