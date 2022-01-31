import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class aadg
  extends aabq
{
  private bbgg jdField_a_of_type_Bbgg;
  private bfol jdField_a_of_type_Bfol;
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull aabm paramaabm)
  {
    int j = 0;
    switch (paramInt)
    {
    default: 
      return false;
    case 29: 
      if ((this.jdField_a_of_type_Bbgg != null) && (this.jdField_a_of_type_Bbgg.isShowing())) {
        this.jdField_a_of_type_Bbgg.dismiss();
      }
      paramString = this.jdField_a_of_type_Aabp.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("DoraemonOpenAPI.widget", 1, "execute show dialog activity is null or finish");
        return false;
      }
      this.jdField_a_of_type_Bbgg = bbcv.a(paramString, 230);
      paramString = paramJSONObject.optString("title");
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_Bbgg.setTitle(paramString);
      }
      paramString = paramJSONObject.optString("content");
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_Bbgg.setMessage(paramString);
      }
      paramString = new aadi(paramaabm);
      paramaabm = paramJSONObject.optString("confirmText");
      if (!TextUtils.isEmpty(paramaabm)) {
        this.jdField_a_of_type_Bbgg.setPositiveButton(paramaabm, paramString);
      }
      paramJSONObject = paramJSONObject.optString("cancelText");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        this.jdField_a_of_type_Bbgg.setNegativeButton(paramJSONObject, paramString);
      }
      this.jdField_a_of_type_Bbgg.setOnCancelListener(paramString);
      this.jdField_a_of_type_Bbgg.show();
    }
    for (;;)
    {
      return true;
      if ((this.jdField_a_of_type_Bfol != null) && (this.jdField_a_of_type_Bfol.isShowing())) {
        this.jdField_a_of_type_Bfol.dismiss();
      }
      paramString = this.jdField_a_of_type_Aabp.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("DoraemonOpenAPI.widget", 1, "execute show action sheet activity is null or finish");
        return false;
      }
      this.jdField_a_of_type_Bfol = bfol.a(paramString);
      paramString = paramJSONObject.optJSONArray("itemList");
      if (paramString == null)
      {
        aaet.a(paramaabm, -1, "param error");
      }
      else
      {
        int k = paramString.length();
        int i = 0;
        for (paramInt = j; i < k; paramInt = 1)
        {
          String str = paramString.optString(i, "");
          this.jdField_a_of_type_Bfol.c(str);
          i += 1;
        }
        paramString = new aadh(this.jdField_a_of_type_Bfol, paramaabm);
        paramJSONObject = paramJSONObject.optString("cancelText");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          this.jdField_a_of_type_Bfol.d(paramJSONObject);
          paramInt = 1;
        }
        if (paramInt != 0)
        {
          this.jdField_a_of_type_Bfol.a(paramString);
          this.jdField_a_of_type_Bfol.setOnCancelListener(paramString);
          this.jdField_a_of_type_Bfol.a(paramString);
          this.jdField_a_of_type_Bfol.show();
        }
        else
        {
          aaet.a(paramaabm, -1, "param error");
        }
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bbgg != null) && (this.jdField_a_of_type_Bbgg.isShowing())) {
      this.jdField_a_of_type_Bbgg.dismiss();
    }
    if ((this.jdField_a_of_type_Bfol != null) && (this.jdField_a_of_type_Bfol.isShowing())) {
      this.jdField_a_of_type_Bfol.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadg
 * JD-Core Version:    0.7.0.1
 */