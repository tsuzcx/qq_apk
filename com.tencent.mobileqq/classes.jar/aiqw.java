import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class aiqw
  implements DialogInterface.OnClickListener
{
  aiqw(aiqu paramaiqu, airc paramairc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Airc != null) {
      this.jdField_a_of_type_Airc.a(this.jdField_a_of_type_Aiqu.a(), "sc.xy_alert_show_success.local", "{\"confirm\":1}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiqw
 * JD-Core Version:    0.7.0.1
 */