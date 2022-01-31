import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ajds
  implements DialogInterface.OnClickListener
{
  ajds(ajdq paramajdq, ajdy paramajdy) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Ajdy != null) {
      this.jdField_a_of_type_Ajdy.a(this.jdField_a_of_type_Ajdq.a(), "sc.xy_alert_show_success.local", "{\"confirm\":1}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajds
 * JD-Core Version:    0.7.0.1
 */