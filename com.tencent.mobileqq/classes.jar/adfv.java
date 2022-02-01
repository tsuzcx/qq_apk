import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class adfv
  implements DialogInterface.OnCancelListener, bkhw, bkhy
{
  adea jdField_a_of_type_Adea;
  bkho jdField_a_of_type_Bkho;
  
  public adfv(bkho parambkho, adea paramadea)
  {
    this.jdField_a_of_type_Bkho = parambkho;
    this.jdField_a_of_type_Adea = paramadea;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bkho.dismiss();
    paramView = new JSONObject();
    try
    {
      paramView.put("cancel", false);
      paramView.put("tapIndex", paramInt);
      adhh.a(this.jdField_a_of_type_Adea, paramView);
      return;
    }
    catch (JSONException paramView)
    {
      String str = paramView.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, paramView);
      }
      adea localadea = this.jdField_a_of_type_Adea;
      paramView = str;
      if (str == null) {
        paramView = "";
      }
      adhh.a(localadea, -2, paramView);
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("cancel", true);
      paramDialogInterface.put("tapIndex", -1);
      adhh.a(this.jdField_a_of_type_Adea, paramDialogInterface);
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      String str = paramDialogInterface.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, paramDialogInterface);
      }
      adea localadea = this.jdField_a_of_type_Adea;
      paramDialogInterface = str;
      if (str == null) {
        paramDialogInterface = "";
      }
      adhh.a(localadea, -2, paramDialogInterface);
    }
  }
  
  public void onDismiss()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cancel", true);
      localJSONObject.put("tapIndex", -1);
      adhh.a(this.jdField_a_of_type_Adea, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      String str = localJSONException.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, localJSONException);
      }
      adea localadea = this.jdField_a_of_type_Adea;
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      adhh.a(localadea, -2, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adfv
 * JD-Core Version:    0.7.0.1
 */