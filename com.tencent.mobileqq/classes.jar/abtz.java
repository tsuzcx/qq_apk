import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class abtz
  extends absj
{
  private bdfq jdField_a_of_type_Bdfq;
  private bhpy jdField_a_of_type_Bhpy;
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull absf paramabsf)
  {
    int j = 0;
    switch (paramInt)
    {
    default: 
      return false;
    case 29: 
      if ((this.jdField_a_of_type_Bdfq != null) && (this.jdField_a_of_type_Bdfq.isShowing())) {
        this.jdField_a_of_type_Bdfq.dismiss();
      }
      paramString = this.jdField_a_of_type_Absi.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("DoraemonOpenAPI.widget", 1, "execute show dialog activity is null or finish");
        return false;
      }
      this.jdField_a_of_type_Bdfq = bdcd.a(paramString, 230);
      paramString = paramJSONObject.optString("title");
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_Bdfq.setTitle(paramString);
      }
      paramString = paramJSONObject.optString("content");
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_Bdfq.setMessage(paramString);
      }
      paramString = new abub(paramabsf);
      paramabsf = paramJSONObject.optString("confirmText");
      if (!TextUtils.isEmpty(paramabsf)) {
        this.jdField_a_of_type_Bdfq.setPositiveButton(paramabsf, paramString);
      }
      paramJSONObject = paramJSONObject.optString("cancelText");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        this.jdField_a_of_type_Bdfq.setNegativeButton(paramJSONObject, paramString);
      }
      this.jdField_a_of_type_Bdfq.setOnCancelListener(paramString);
      this.jdField_a_of_type_Bdfq.show();
    }
    for (;;)
    {
      return true;
      if ((this.jdField_a_of_type_Bhpy != null) && (this.jdField_a_of_type_Bhpy.isShowing())) {
        this.jdField_a_of_type_Bhpy.dismiss();
      }
      paramString = this.jdField_a_of_type_Absi.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("DoraemonOpenAPI.widget", 1, "execute show action sheet activity is null or finish");
        return false;
      }
      this.jdField_a_of_type_Bhpy = bhpy.a(paramString);
      paramString = paramJSONObject.optJSONArray("itemList");
      if (paramString == null)
      {
        abvm.a(paramabsf, -1, "param error");
      }
      else
      {
        int k = paramString.length();
        int i = 0;
        for (paramInt = j; i < k; paramInt = 1)
        {
          String str = paramString.optString(i, "");
          this.jdField_a_of_type_Bhpy.c(str);
          i += 1;
        }
        paramString = new abua(this.jdField_a_of_type_Bhpy, paramabsf);
        paramJSONObject = paramJSONObject.optString("cancelText");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          this.jdField_a_of_type_Bhpy.d(paramJSONObject);
          paramInt = 1;
        }
        if (paramInt != 0)
        {
          this.jdField_a_of_type_Bhpy.a(paramString);
          this.jdField_a_of_type_Bhpy.setOnCancelListener(paramString);
          this.jdField_a_of_type_Bhpy.a(paramString);
          this.jdField_a_of_type_Bhpy.show();
        }
        else
        {
          abvm.a(paramabsf, -1, "param error");
        }
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bdfq != null) && (this.jdField_a_of_type_Bdfq.isShowing())) {
      this.jdField_a_of_type_Bdfq.dismiss();
    }
    if ((this.jdField_a_of_type_Bhpy != null) && (this.jdField_a_of_type_Bhpy.isShowing())) {
      this.jdField_a_of_type_Bhpy.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abtz
 * JD-Core Version:    0.7.0.1
 */