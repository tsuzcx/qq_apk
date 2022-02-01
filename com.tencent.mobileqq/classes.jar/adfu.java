import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class adfu
  extends adee
{
  private bgpa jdField_a_of_type_Bgpa;
  private bkho jdField_a_of_type_Bkho;
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull adea paramadea)
  {
    int j = 0;
    switch (paramInt)
    {
    default: 
      return false;
    case 29: 
      if ((this.jdField_a_of_type_Bgpa != null) && (this.jdField_a_of_type_Bgpa.isShowing())) {
        this.jdField_a_of_type_Bgpa.dismiss();
      }
      paramString = this.jdField_a_of_type_Aded.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("DoraemonOpenAPI.widget", 1, "execute show dialog activity is null or finish");
        return false;
      }
      this.jdField_a_of_type_Bgpa = bglp.a(paramString, 230);
      paramString = paramJSONObject.optString("title");
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_Bgpa.setTitle(paramString);
      }
      paramString = paramJSONObject.optString("content");
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_Bgpa.setMessage(paramString);
      }
      paramString = new adfw(paramadea);
      paramadea = paramJSONObject.optString("confirmText");
      if (!TextUtils.isEmpty(paramadea)) {
        this.jdField_a_of_type_Bgpa.setPositiveButton(paramadea, paramString);
      }
      paramJSONObject = paramJSONObject.optString("cancelText");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        this.jdField_a_of_type_Bgpa.setNegativeButton(paramJSONObject, paramString);
      }
      this.jdField_a_of_type_Bgpa.setOnCancelListener(paramString);
      this.jdField_a_of_type_Bgpa.show();
    }
    for (;;)
    {
      return true;
      if ((this.jdField_a_of_type_Bkho != null) && (this.jdField_a_of_type_Bkho.isShowing())) {
        this.jdField_a_of_type_Bkho.dismiss();
      }
      paramString = this.jdField_a_of_type_Aded.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("DoraemonOpenAPI.widget", 1, "execute show action sheet activity is null or finish");
        return false;
      }
      this.jdField_a_of_type_Bkho = bkho.a(paramString);
      paramString = paramJSONObject.optJSONArray("itemList");
      if (paramString == null)
      {
        adhh.a(paramadea, -1, "param error");
      }
      else
      {
        int k = paramString.length();
        int i = 0;
        for (paramInt = j; i < k; paramInt = 1)
        {
          String str = paramString.optString(i, "");
          this.jdField_a_of_type_Bkho.c(str);
          i += 1;
        }
        paramString = new adfv(this.jdField_a_of_type_Bkho, paramadea);
        paramJSONObject = paramJSONObject.optString("cancelText");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          this.jdField_a_of_type_Bkho.d(paramJSONObject);
          paramInt = 1;
        }
        if (paramInt != 0)
        {
          this.jdField_a_of_type_Bkho.a(paramString);
          this.jdField_a_of_type_Bkho.setOnCancelListener(paramString);
          this.jdField_a_of_type_Bkho.a(paramString);
          this.jdField_a_of_type_Bkho.show();
        }
        else
        {
          adhh.a(paramadea, -1, "param error");
        }
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bgpa != null) && (this.jdField_a_of_type_Bgpa.isShowing())) {
      this.jdField_a_of_type_Bgpa.dismiss();
    }
    if ((this.jdField_a_of_type_Bkho != null) && (this.jdField_a_of_type_Bkho.isShowing())) {
      this.jdField_a_of_type_Bkho.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adfu
 * JD-Core Version:    0.7.0.1
 */