import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class adbv
  implements DialogInterface.OnCancelListener, bkzq, bkzs
{
  adaa jdField_a_of_type_Adaa;
  bkzi jdField_a_of_type_Bkzi;
  
  public adbv(bkzi parambkzi, adaa paramadaa)
  {
    this.jdField_a_of_type_Bkzi = parambkzi;
    this.jdField_a_of_type_Adaa = paramadaa;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bkzi.dismiss();
    paramView = new JSONObject();
    try
    {
      paramView.put("cancel", false);
      paramView.put("tapIndex", paramInt);
      addh.a(this.jdField_a_of_type_Adaa, paramView);
      return;
    }
    catch (JSONException paramView)
    {
      String str = paramView.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, paramView);
      }
      adaa localadaa = this.jdField_a_of_type_Adaa;
      paramView = str;
      if (str == null) {
        paramView = "";
      }
      addh.a(localadaa, -2, paramView);
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("cancel", true);
      paramDialogInterface.put("tapIndex", -1);
      addh.a(this.jdField_a_of_type_Adaa, paramDialogInterface);
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      String str = paramDialogInterface.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, paramDialogInterface);
      }
      adaa localadaa = this.jdField_a_of_type_Adaa;
      paramDialogInterface = str;
      if (str == null) {
        paramDialogInterface = "";
      }
      addh.a(localadaa, -2, paramDialogInterface);
    }
  }
  
  public void onDismiss()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cancel", true);
      localJSONObject.put("tapIndex", -1);
      addh.a(this.jdField_a_of_type_Adaa, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      String str = localJSONException.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, localJSONException);
      }
      adaa localadaa = this.jdField_a_of_type_Adaa;
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      addh.a(localadaa, -2, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adbv
 * JD-Core Version:    0.7.0.1
 */