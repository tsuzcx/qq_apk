import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class alzm
  implements DialogInterface.OnClickListener
{
  alzm(alzj paramalzj, alzr paramalzr) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Alzr != null) {
      this.jdField_a_of_type_Alzr.a(this.jdField_a_of_type_Alzj.a(), "sc.xy_alert_show_success.local", "{\"cancel\":1}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alzm
 * JD-Core Version:    0.7.0.1
 */