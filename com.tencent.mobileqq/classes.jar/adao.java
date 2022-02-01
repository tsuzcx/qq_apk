import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class adao
  implements DialogInterface.OnCancelListener
{
  adao(adak paramadak, adaj paramadaj, adab paramadab, JSONObject paramJSONObject, adaa paramadaa) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Adak.d();
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "cancel " + this.jdField_a_of_type_Adaj.a);
    adak.c(this.jdField_a_of_type_Adak, 4, this.jdField_a_of_type_Adab, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Adaa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adao
 * JD-Core Version:    0.7.0.1
 */