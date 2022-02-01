import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class adbu
  extends adae
{
  private bkzi jdField_a_of_type_Bkzi;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull adaa paramadaa)
  {
    int j = 0;
    switch (paramInt)
    {
    default: 
      return false;
    case 29: 
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
      paramString = this.jdField_a_of_type_Adad.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("DoraemonOpenAPI.widget", 1, "execute show dialog activity is null or finish");
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(paramString, 230);
      paramString = paramJSONObject.optString("title");
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(paramString);
      }
      paramString = paramJSONObject.optString("content");
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString);
      }
      paramString = new adbw(paramadaa);
      paramadaa = paramJSONObject.optString("confirmText");
      if (!TextUtils.isEmpty(paramadaa)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(paramadaa, paramString);
      }
      paramJSONObject = paramJSONObject.optString("cancelText");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(paramJSONObject, paramString);
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(paramString);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
    for (;;)
    {
      return true;
      if ((this.jdField_a_of_type_Bkzi != null) && (this.jdField_a_of_type_Bkzi.isShowing())) {
        this.jdField_a_of_type_Bkzi.dismiss();
      }
      paramString = this.jdField_a_of_type_Adad.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("DoraemonOpenAPI.widget", 1, "execute show action sheet activity is null or finish");
        return false;
      }
      this.jdField_a_of_type_Bkzi = bkzi.a(paramString);
      paramString = paramJSONObject.optJSONArray("itemList");
      if (paramString == null)
      {
        addh.a(paramadaa, -1, "param error");
      }
      else
      {
        int k = paramString.length();
        int i = 0;
        for (paramInt = j; i < k; paramInt = 1)
        {
          String str = paramString.optString(i, "");
          this.jdField_a_of_type_Bkzi.c(str);
          i += 1;
        }
        paramString = new adbv(this.jdField_a_of_type_Bkzi, paramadaa);
        paramJSONObject = paramJSONObject.optString("cancelText");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          this.jdField_a_of_type_Bkzi.d(paramJSONObject);
          paramInt = 1;
        }
        if (paramInt != 0)
        {
          this.jdField_a_of_type_Bkzi.a(paramString);
          this.jdField_a_of_type_Bkzi.setOnCancelListener(paramString);
          this.jdField_a_of_type_Bkzi.a(paramString);
          this.jdField_a_of_type_Bkzi.show();
        }
        else
        {
          addh.a(paramadaa, -1, "param error");
        }
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    if ((this.jdField_a_of_type_Bkzi != null) && (this.jdField_a_of_type_Bkzi.isShowing())) {
      this.jdField_a_of_type_Bkzi.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adbu
 * JD-Core Version:    0.7.0.1
 */