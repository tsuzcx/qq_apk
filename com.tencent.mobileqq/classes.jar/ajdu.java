import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ajdu
  implements DialogInterface.OnClickListener
{
  ajdu(ajds paramajds, ajea paramajea) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Ajea != null) {
      this.jdField_a_of_type_Ajea.a(this.jdField_a_of_type_Ajds.a(), "sc.xy_alert_show_success.local", "{\"confirm\":1}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajdu
 * JD-Core Version:    0.7.0.1
 */