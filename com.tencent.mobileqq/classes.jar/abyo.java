import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class abyo
  extends abwy
{
  private bdjz jdField_a_of_type_Bdjz;
  private bhuf jdField_a_of_type_Bhuf;
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull abwu paramabwu)
  {
    int j = 0;
    switch (paramInt)
    {
    default: 
      return false;
    case 29: 
      if ((this.jdField_a_of_type_Bdjz != null) && (this.jdField_a_of_type_Bdjz.isShowing())) {
        this.jdField_a_of_type_Bdjz.dismiss();
      }
      paramString = this.jdField_a_of_type_Abwx.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("DoraemonOpenAPI.widget", 1, "execute show dialog activity is null or finish");
        return false;
      }
      this.jdField_a_of_type_Bdjz = bdgm.a(paramString, 230);
      paramString = paramJSONObject.optString("title");
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_Bdjz.setTitle(paramString);
      }
      paramString = paramJSONObject.optString("content");
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_Bdjz.setMessage(paramString);
      }
      paramString = new abyq(paramabwu);
      paramabwu = paramJSONObject.optString("confirmText");
      if (!TextUtils.isEmpty(paramabwu)) {
        this.jdField_a_of_type_Bdjz.setPositiveButton(paramabwu, paramString);
      }
      paramJSONObject = paramJSONObject.optString("cancelText");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        this.jdField_a_of_type_Bdjz.setNegativeButton(paramJSONObject, paramString);
      }
      this.jdField_a_of_type_Bdjz.setOnCancelListener(paramString);
      this.jdField_a_of_type_Bdjz.show();
    }
    for (;;)
    {
      return true;
      if ((this.jdField_a_of_type_Bhuf != null) && (this.jdField_a_of_type_Bhuf.isShowing())) {
        this.jdField_a_of_type_Bhuf.dismiss();
      }
      paramString = this.jdField_a_of_type_Abwx.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("DoraemonOpenAPI.widget", 1, "execute show action sheet activity is null or finish");
        return false;
      }
      this.jdField_a_of_type_Bhuf = bhuf.a(paramString);
      paramString = paramJSONObject.optJSONArray("itemList");
      if (paramString == null)
      {
        acab.a(paramabwu, -1, "param error");
      }
      else
      {
        int k = paramString.length();
        int i = 0;
        for (paramInt = j; i < k; paramInt = 1)
        {
          String str = paramString.optString(i, "");
          this.jdField_a_of_type_Bhuf.c(str);
          i += 1;
        }
        paramString = new abyp(this.jdField_a_of_type_Bhuf, paramabwu);
        paramJSONObject = paramJSONObject.optString("cancelText");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          this.jdField_a_of_type_Bhuf.d(paramJSONObject);
          paramInt = 1;
        }
        if (paramInt != 0)
        {
          this.jdField_a_of_type_Bhuf.a(paramString);
          this.jdField_a_of_type_Bhuf.setOnCancelListener(paramString);
          this.jdField_a_of_type_Bhuf.a(paramString);
          this.jdField_a_of_type_Bhuf.show();
        }
        else
        {
          acab.a(paramabwu, -1, "param error");
        }
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bdjz != null) && (this.jdField_a_of_type_Bdjz.isShowing())) {
      this.jdField_a_of_type_Bdjz.dismiss();
    }
    if ((this.jdField_a_of_type_Bhuf != null) && (this.jdField_a_of_type_Bhuf.isShowing())) {
      this.jdField_a_of_type_Bhuf.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abyo
 * JD-Core Version:    0.7.0.1
 */