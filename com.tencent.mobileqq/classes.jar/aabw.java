import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class aabw
  implements DialogInterface.OnCancelListener
{
  aabw(aabs paramaabs, aabr paramaabr, aabj paramaabj, JSONObject paramJSONObject, aabi paramaabi) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Aabs.d();
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "cancel " + this.jdField_a_of_type_Aabr.a);
    aabs.c(this.jdField_a_of_type_Aabs, 4, this.jdField_a_of_type_Aabj, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Aabi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aabw
 * JD-Core Version:    0.7.0.1
 */