import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class aadh
  implements DialogInterface.OnCancelListener, bfoq, bfos
{
  aabm jdField_a_of_type_Aabm;
  bfol jdField_a_of_type_Bfol;
  
  public aadh(bfol parambfol, aabm paramaabm)
  {
    this.jdField_a_of_type_Bfol = parambfol;
    this.jdField_a_of_type_Aabm = paramaabm;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bfol.dismiss();
    paramView = new JSONObject();
    try
    {
      paramView.put("cancel", false);
      paramView.put("tapIndex", paramInt);
      aaet.a(this.jdField_a_of_type_Aabm, paramView);
      return;
    }
    catch (JSONException paramView)
    {
      String str = paramView.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, paramView);
      }
      aabm localaabm = this.jdField_a_of_type_Aabm;
      paramView = str;
      if (str == null) {
        paramView = "";
      }
      aaet.a(localaabm, -2, paramView);
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("cancel", true);
      paramDialogInterface.put("tapIndex", -1);
      aaet.a(this.jdField_a_of_type_Aabm, paramDialogInterface);
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      String str = paramDialogInterface.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, paramDialogInterface);
      }
      aabm localaabm = this.jdField_a_of_type_Aabm;
      paramDialogInterface = str;
      if (str == null) {
        paramDialogInterface = "";
      }
      aaet.a(localaabm, -2, paramDialogInterface);
    }
  }
  
  public void onDismiss()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cancel", true);
      localJSONObject.put("tapIndex", -1);
      aaet.a(this.jdField_a_of_type_Aabm, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      String str = localJSONException.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, localJSONException);
      }
      aabm localaabm = this.jdField_a_of_type_Aabm;
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      aaet.a(localaabm, -2, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadh
 * JD-Core Version:    0.7.0.1
 */