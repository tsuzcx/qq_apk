import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class abst
  implements DialogInterface.OnCancelListener
{
  abst(absp paramabsp, abso paramabso, absg paramabsg, JSONObject paramJSONObject, absf paramabsf) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Absp.d();
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "cancel " + this.jdField_a_of_type_Abso.a);
    absp.c(this.jdField_a_of_type_Absp, 4, this.jdField_a_of_type_Absg, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Absf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abst
 * JD-Core Version:    0.7.0.1
 */