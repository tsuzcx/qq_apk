import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class ados
  extends adnc
{
  private bhpc jdField_a_of_type_Bhpc;
  private blir jdField_a_of_type_Blir;
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull admy paramadmy)
  {
    int j = 0;
    switch (paramInt)
    {
    default: 
      return false;
    case 29: 
      if ((this.jdField_a_of_type_Bhpc != null) && (this.jdField_a_of_type_Bhpc.isShowing())) {
        this.jdField_a_of_type_Bhpc.dismiss();
      }
      paramString = this.jdField_a_of_type_Adnb.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("DoraemonOpenAPI.widget", 1, "execute show dialog activity is null or finish");
        return false;
      }
      this.jdField_a_of_type_Bhpc = bhlq.a(paramString, 230);
      paramString = paramJSONObject.optString("title");
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_Bhpc.setTitle(paramString);
      }
      paramString = paramJSONObject.optString("content");
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_Bhpc.setMessage(paramString);
      }
      paramString = new adou(paramadmy);
      paramadmy = paramJSONObject.optString("confirmText");
      if (!TextUtils.isEmpty(paramadmy)) {
        this.jdField_a_of_type_Bhpc.setPositiveButton(paramadmy, paramString);
      }
      paramJSONObject = paramJSONObject.optString("cancelText");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        this.jdField_a_of_type_Bhpc.setNegativeButton(paramJSONObject, paramString);
      }
      this.jdField_a_of_type_Bhpc.setOnCancelListener(paramString);
      this.jdField_a_of_type_Bhpc.show();
    }
    for (;;)
    {
      return true;
      if ((this.jdField_a_of_type_Blir != null) && (this.jdField_a_of_type_Blir.isShowing())) {
        this.jdField_a_of_type_Blir.dismiss();
      }
      paramString = this.jdField_a_of_type_Adnb.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("DoraemonOpenAPI.widget", 1, "execute show action sheet activity is null or finish");
        return false;
      }
      this.jdField_a_of_type_Blir = blir.a(paramString);
      paramString = paramJSONObject.optJSONArray("itemList");
      if (paramString == null)
      {
        adqf.a(paramadmy, -1, "param error");
      }
      else
      {
        int k = paramString.length();
        int i = 0;
        for (paramInt = j; i < k; paramInt = 1)
        {
          String str = paramString.optString(i, "");
          this.jdField_a_of_type_Blir.c(str);
          i += 1;
        }
        paramString = new adot(this.jdField_a_of_type_Blir, paramadmy);
        paramJSONObject = paramJSONObject.optString("cancelText");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          this.jdField_a_of_type_Blir.d(paramJSONObject);
          paramInt = 1;
        }
        if (paramInt != 0)
        {
          this.jdField_a_of_type_Blir.a(paramString);
          this.jdField_a_of_type_Blir.setOnCancelListener(paramString);
          this.jdField_a_of_type_Blir.a(paramString);
          this.jdField_a_of_type_Blir.show();
        }
        else
        {
          adqf.a(paramadmy, -1, "param error");
        }
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bhpc != null) && (this.jdField_a_of_type_Bhpc.isShowing())) {
      this.jdField_a_of_type_Bhpc.dismiss();
    }
    if ((this.jdField_a_of_type_Blir != null) && (this.jdField_a_of_type_Blir.isShowing())) {
      this.jdField_a_of_type_Blir.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ados
 * JD-Core Version:    0.7.0.1
 */