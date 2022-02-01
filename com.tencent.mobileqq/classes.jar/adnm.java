import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class adnm
  implements DialogInterface.OnCancelListener
{
  adnm(adni paramadni, adnh paramadnh, admz paramadmz, JSONObject paramJSONObject, admy paramadmy) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Adni.d();
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "cancel " + this.jdField_a_of_type_Adnh.a);
    adni.c(this.jdField_a_of_type_Adni, 4, this.jdField_a_of_type_Admz, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Admy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adnm
 * JD-Core Version:    0.7.0.1
 */