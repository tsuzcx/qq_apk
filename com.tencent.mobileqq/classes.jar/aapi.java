import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class aapi
  implements nuw
{
  aapi(aapg paramaapg, QQAppInterface paramQQAppInterface) {}
  
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
          FileUtils.deleteDirectory(nvf.a(this.jdField_a_of_type_Aapg.a) + this.jdField_a_of_type_Aapg.a);
          this.jdField_a_of_type_Aapg.b();
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        this.jdField_a_of_type_Aapg.a();
        return;
      }
      if ((!TextUtils.isEmpty(str)) && (paramInt != 0))
      {
        this.jdField_a_of_type_Aapg.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      this.jdField_a_of_type_Aapg.a();
      return;
    }
    this.jdField_a_of_type_Aapg.a();
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapi
 * JD-Core Version:    0.7.0.1
 */