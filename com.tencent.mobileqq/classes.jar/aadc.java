import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class aadc
  extends aabm
{
  private bbgu jdField_a_of_type_Bbgu;
  private bfpc jdField_a_of_type_Bfpc;
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull aabi paramaabi)
  {
    int j = 0;
    switch (paramInt)
    {
    default: 
      return false;
    case 29: 
      if ((this.jdField_a_of_type_Bbgu != null) && (this.jdField_a_of_type_Bbgu.isShowing())) {
        this.jdField_a_of_type_Bbgu.dismiss();
      }
      paramString = this.jdField_a_of_type_Aabl.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("DoraemonOpenAPI.widget", 1, "execute show dialog activity is null or finish");
        return false;
      }
      this.jdField_a_of_type_Bbgu = bbdj.a(paramString, 230);
      paramString = paramJSONObject.optString("title");
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_Bbgu.setTitle(paramString);
      }
      paramString = paramJSONObject.optString("content");
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_Bbgu.setMessage(paramString);
      }
      paramString = new aade(paramaabi);
      paramaabi = paramJSONObject.optString("confirmText");
      if (!TextUtils.isEmpty(paramaabi)) {
        this.jdField_a_of_type_Bbgu.setPositiveButton(paramaabi, paramString);
      }
      paramJSONObject = paramJSONObject.optString("cancelText");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        this.jdField_a_of_type_Bbgu.setNegativeButton(paramJSONObject, paramString);
      }
      this.jdField_a_of_type_Bbgu.setOnCancelListener(paramString);
      this.jdField_a_of_type_Bbgu.show();
    }
    for (;;)
    {
      return true;
      if ((this.jdField_a_of_type_Bfpc != null) && (this.jdField_a_of_type_Bfpc.isShowing())) {
        this.jdField_a_of_type_Bfpc.dismiss();
      }
      paramString = this.jdField_a_of_type_Aabl.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("DoraemonOpenAPI.widget", 1, "execute show action sheet activity is null or finish");
        return false;
      }
      this.jdField_a_of_type_Bfpc = bfpc.a(paramString);
      paramString = paramJSONObject.optJSONArray("itemList");
      if (paramString == null)
      {
        aaep.a(paramaabi, -1, "param error");
      }
      else
      {
        int k = paramString.length();
        int i = 0;
        for (paramInt = j; i < k; paramInt = 1)
        {
          String str = paramString.optString(i, "");
          this.jdField_a_of_type_Bfpc.c(str);
          i += 1;
        }
        paramString = new aadd(this.jdField_a_of_type_Bfpc, paramaabi);
        paramJSONObject = paramJSONObject.optString("cancelText");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          this.jdField_a_of_type_Bfpc.d(paramJSONObject);
          paramInt = 1;
        }
        if (paramInt != 0)
        {
          this.jdField_a_of_type_Bfpc.a(paramString);
          this.jdField_a_of_type_Bfpc.setOnCancelListener(paramString);
          this.jdField_a_of_type_Bfpc.a(paramString);
          this.jdField_a_of_type_Bfpc.show();
        }
        else
        {
          aaep.a(paramaabi, -1, "param error");
        }
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bbgu != null) && (this.jdField_a_of_type_Bbgu.isShowing())) {
      this.jdField_a_of_type_Bbgu.dismiss();
    }
    if ((this.jdField_a_of_type_Bfpc != null) && (this.jdField_a_of_type_Bfpc.isShowing())) {
      this.jdField_a_of_type_Bfpc.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadc
 * JD-Core Version:    0.7.0.1
 */