import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class aadd
  implements DialogInterface.OnCancelListener, bfph, bfpj
{
  aabi jdField_a_of_type_Aabi;
  bfpc jdField_a_of_type_Bfpc;
  
  public aadd(bfpc parambfpc, aabi paramaabi)
  {
    this.jdField_a_of_type_Bfpc = parambfpc;
    this.jdField_a_of_type_Aabi = paramaabi;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bfpc.dismiss();
    paramView = new JSONObject();
    try
    {
      paramView.put("cancel", false);
      paramView.put("tapIndex", paramInt);
      aaep.a(this.jdField_a_of_type_Aabi, paramView);
      return;
    }
    catch (JSONException paramView)
    {
      String str = paramView.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, paramView);
      }
      aabi localaabi = this.jdField_a_of_type_Aabi;
      paramView = str;
      if (str == null) {
        paramView = "";
      }
      aaep.a(localaabi, -2, paramView);
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("cancel", true);
      paramDialogInterface.put("tapIndex", -1);
      aaep.a(this.jdField_a_of_type_Aabi, paramDialogInterface);
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      String str = paramDialogInterface.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, paramDialogInterface);
      }
      aabi localaabi = this.jdField_a_of_type_Aabi;
      paramDialogInterface = str;
      if (str == null) {
        paramDialogInterface = "";
      }
      aaep.a(localaabi, -2, paramDialogInterface);
    }
  }
  
  public void onDismiss()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cancel", true);
      localJSONObject.put("tapIndex", -1);
      aaep.a(this.jdField_a_of_type_Aabi, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      String str = localJSONException.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, localJSONException);
      }
      aabi localaabi = this.jdField_a_of_type_Aabi;
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      aaep.a(localaabi, -2, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadd
 * JD-Core Version:    0.7.0.1
 */