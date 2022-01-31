import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class akve
  implements DialogInterface.OnClickListener
{
  akve(akvc paramakvc, akvk paramakvk) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Akvk != null) {
      this.jdField_a_of_type_Akvk.a(this.jdField_a_of_type_Akvc.a(), "sc.xy_alert_show_success.local", "{\"confirm\":1}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akve
 * JD-Core Version:    0.7.0.1
 */