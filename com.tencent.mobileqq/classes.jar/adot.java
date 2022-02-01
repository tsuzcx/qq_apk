import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class adot
  implements DialogInterface.OnCancelListener, bliz, bljb
{
  admy jdField_a_of_type_Admy;
  blir jdField_a_of_type_Blir;
  
  public adot(blir paramblir, admy paramadmy)
  {
    this.jdField_a_of_type_Blir = paramblir;
    this.jdField_a_of_type_Admy = paramadmy;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Blir.dismiss();
    paramView = new JSONObject();
    try
    {
      paramView.put("cancel", false);
      paramView.put("tapIndex", paramInt);
      adqf.a(this.jdField_a_of_type_Admy, paramView);
      return;
    }
    catch (JSONException paramView)
    {
      String str = paramView.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, paramView);
      }
      admy localadmy = this.jdField_a_of_type_Admy;
      paramView = str;
      if (str == null) {
        paramView = "";
      }
      adqf.a(localadmy, -2, paramView);
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("cancel", true);
      paramDialogInterface.put("tapIndex", -1);
      adqf.a(this.jdField_a_of_type_Admy, paramDialogInterface);
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      String str = paramDialogInterface.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, paramDialogInterface);
      }
      admy localadmy = this.jdField_a_of_type_Admy;
      paramDialogInterface = str;
      if (str == null) {
        paramDialogInterface = "";
      }
      adqf.a(localadmy, -2, paramDialogInterface);
    }
  }
  
  public void onDismiss()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cancel", true);
      localJSONObject.put("tapIndex", -1);
      adqf.a(this.jdField_a_of_type_Admy, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      String str = localJSONException.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, localJSONException);
      }
      admy localadmy = this.jdField_a_of_type_Admy;
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      adqf.a(localadmy, -2, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adot
 * JD-Core Version:    0.7.0.1
 */