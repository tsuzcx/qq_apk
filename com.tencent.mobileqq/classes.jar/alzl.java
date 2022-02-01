import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class alzl
  implements DialogInterface.OnClickListener
{
  alzl(alzj paramalzj, alzr paramalzr) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Alzr != null) {
      this.jdField_a_of_type_Alzr.a(this.jdField_a_of_type_Alzj.a(), "sc.xy_alert_show_success.local", "{\"confirm\":1}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alzl
 * JD-Core Version:    0.7.0.1
 */