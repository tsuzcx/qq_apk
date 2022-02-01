import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class abdl
  implements nmg
{
  abdl(abdj paramabdj, QQAppInterface paramQQAppInterface) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViewPluginLoader", 2, "checkUp loaded json = " + paramString + " code = " + paramInt);
    }
    if (paramInt == 0)
    {
      String str;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("data").optJSONObject(0);
        str = paramString.optString("url");
        paramInt = paramString.optInt("filesize");
        if ((str != null) && (str.endsWith("patch")))
        {
          bhmi.a(nmp.a(this.jdField_a_of_type_Abdj.a) + this.jdField_a_of_type_Abdj.a);
          this.jdField_a_of_type_Abdj.b();
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        this.jdField_a_of_type_Abdj.a();
        return;
      }
      if ((!TextUtils.isEmpty(str)) && (paramInt != 0))
      {
        this.jdField_a_of_type_Abdj.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      this.jdField_a_of_type_Abdj.a();
      return;
    }
    this.jdField_a_of_type_Abdj.a();
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abdl
 * JD-Core Version:    0.7.0.1
 */