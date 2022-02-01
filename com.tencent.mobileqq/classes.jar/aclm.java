import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class aclm
  implements DialogInterface.OnCancelListener, bjoe, bjog
{
  acjr jdField_a_of_type_Acjr;
  bjnw jdField_a_of_type_Bjnw;
  
  public aclm(bjnw parambjnw, acjr paramacjr)
  {
    this.jdField_a_of_type_Bjnw = parambjnw;
    this.jdField_a_of_type_Acjr = paramacjr;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bjnw.dismiss();
    paramView = new JSONObject();
    try
    {
      paramView.put("cancel", false);
      paramView.put("tapIndex", paramInt);
      acmy.a(this.jdField_a_of_type_Acjr, paramView);
      return;
    }
    catch (JSONException paramView)
    {
      String str = paramView.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, paramView);
      }
      acjr localacjr = this.jdField_a_of_type_Acjr;
      paramView = str;
      if (str == null) {
        paramView = "";
      }
      acmy.a(localacjr, -2, paramView);
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("cancel", true);
      paramDialogInterface.put("tapIndex", -1);
      acmy.a(this.jdField_a_of_type_Acjr, paramDialogInterface);
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      String str = paramDialogInterface.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, paramDialogInterface);
      }
      acjr localacjr = this.jdField_a_of_type_Acjr;
      paramDialogInterface = str;
      if (str == null) {
        paramDialogInterface = "";
      }
      acmy.a(localacjr, -2, paramDialogInterface);
    }
  }
  
  public void onDismiss()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cancel", true);
      localJSONObject.put("tapIndex", -1);
      acmy.a(this.jdField_a_of_type_Acjr, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      String str = localJSONException.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, localJSONException);
      }
      acjr localacjr = this.jdField_a_of_type_Acjr;
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      acmy.a(localacjr, -2, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aclm
 * JD-Core Version:    0.7.0.1
 */