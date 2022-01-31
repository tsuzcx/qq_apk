import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class akzt
  implements DialogInterface.OnClickListener
{
  akzt(akzr paramakzr, akzz paramakzz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Akzz != null) {
      this.jdField_a_of_type_Akzz.a(this.jdField_a_of_type_Akzr.a(), "sc.xy_alert_show_success.local", "{\"confirm\":1}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzt
 * JD-Core Version:    0.7.0.1
 */