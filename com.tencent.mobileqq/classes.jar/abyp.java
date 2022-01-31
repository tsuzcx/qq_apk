import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class abyp
  implements DialogInterface.OnCancelListener, bhuk, bhum
{
  abwu jdField_a_of_type_Abwu;
  bhuf jdField_a_of_type_Bhuf;
  
  public abyp(bhuf parambhuf, abwu paramabwu)
  {
    this.jdField_a_of_type_Bhuf = parambhuf;
    this.jdField_a_of_type_Abwu = paramabwu;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bhuf.dismiss();
    paramView = new JSONObject();
    try
    {
      paramView.put("cancel", false);
      paramView.put("tapIndex", paramInt);
      acab.a(this.jdField_a_of_type_Abwu, paramView);
      return;
    }
    catch (JSONException paramView)
    {
      String str = paramView.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, paramView);
      }
      abwu localabwu = this.jdField_a_of_type_Abwu;
      paramView = str;
      if (str == null) {
        paramView = "";
      }
      acab.a(localabwu, -2, paramView);
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("cancel", true);
      paramDialogInterface.put("tapIndex", -1);
      acab.a(this.jdField_a_of_type_Abwu, paramDialogInterface);
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      String str = paramDialogInterface.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, paramDialogInterface);
      }
      abwu localabwu = this.jdField_a_of_type_Abwu;
      paramDialogInterface = str;
      if (str == null) {
        paramDialogInterface = "";
      }
      acab.a(localabwu, -2, paramDialogInterface);
    }
  }
  
  public void onDismiss()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cancel", true);
      localJSONObject.put("tapIndex", -1);
      acab.a(this.jdField_a_of_type_Abwu, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      String str = localJSONException.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, localJSONException);
      }
      abwu localabwu = this.jdField_a_of_type_Abwu;
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      acab.a(localabwu, -2, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abyp
 * JD-Core Version:    0.7.0.1
 */