import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class aaca
  implements DialogInterface.OnCancelListener
{
  aaca(aabw paramaabw, aabv paramaabv, aabn paramaabn, JSONObject paramJSONObject, aabm paramaabm) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Aabw.d();
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "cancel " + this.jdField_a_of_type_Aabv.a);
    aabw.c(this.jdField_a_of_type_Aabw, 4, this.jdField_a_of_type_Aabn, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Aabm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaca
 * JD-Core Version:    0.7.0.1
 */