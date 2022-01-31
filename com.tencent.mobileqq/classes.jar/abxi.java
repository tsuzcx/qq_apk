import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class abxi
  implements DialogInterface.OnCancelListener
{
  abxi(abxe paramabxe, abxd paramabxd, abwv paramabwv, JSONObject paramJSONObject, abwu paramabwu) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Abxe.d();
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "cancel " + this.jdField_a_of_type_Abxd.a);
    abxe.c(this.jdField_a_of_type_Abxe, 4, this.jdField_a_of_type_Abwv, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Abwu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abxi
 * JD-Core Version:    0.7.0.1
 */