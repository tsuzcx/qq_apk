import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class abub
  implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener
{
  absf a;
  
  public abub(absf paramabsf)
  {
    this.a = paramabsf;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("confirm", false);
      paramDialogInterface.put("cancel", true);
      abvm.a(this.a, paramDialogInterface);
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      String str = paramDialogInterface.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, paramDialogInterface);
      }
      absf localabsf = this.a;
      paramDialogInterface = str;
      if (str == null) {
        paramDialogInterface = "";
      }
      abvm.a(localabsf, -1, paramDialogInterface);
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool2 = true;
    paramDialogInterface = new JSONObject();
    boolean bool1;
    if (paramInt == 1) {
      bool1 = true;
    }
    try
    {
      paramDialogInterface.put("confirm", bool1);
      if (paramInt != 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramDialogInterface.put("cancel", bool1);
        abvm.a(this.a, paramDialogInterface);
        return;
        bool1 = false;
        break;
      }
      String str;
      absf localabsf;
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      str = paramDialogInterface.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, paramDialogInterface);
      }
      localabsf = this.a;
      paramDialogInterface = str;
      if (str == null) {
        paramDialogInterface = "";
      }
      abvm.a(localabsf, -1, paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abub
 * JD-Core Version:    0.7.0.1
 */