import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ackf
  implements DialogInterface.OnCancelListener
{
  ackf(ackb paramackb, acka paramacka, acjs paramacjs, JSONObject paramJSONObject, acjr paramacjr) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Ackb.d();
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "cancel " + this.jdField_a_of_type_Acka.a);
    ackb.c(this.jdField_a_of_type_Ackb, 4, this.jdField_a_of_type_Acjs, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Acjr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackf
 * JD-Core Version:    0.7.0.1
 */