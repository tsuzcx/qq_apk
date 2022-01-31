import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class akzu
  implements DialogInterface.OnClickListener
{
  akzu(akzr paramakzr, akzz paramakzz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Akzz != null) {
      this.jdField_a_of_type_Akzz.a(this.jdField_a_of_type_Akzr.a(), "sc.xy_alert_show_success.local", "{\"cancel\":1}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzu
 * JD-Core Version:    0.7.0.1
 */