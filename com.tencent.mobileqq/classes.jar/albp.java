import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class albp
  extends aldv
{
  albp(albo paramalbo, String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, Object paramObject)
  {
    if (!paramBoolean)
    {
      QLog.i("ArkApp", 1, "ArkAppSchemeCenter.AppSchemeHandler.get packagename failed.");
      return;
    }
    albo.a((albo)paramObject, paramString2, this.jdField_a_of_type_JavaLangString, this.b, paramString1);
    BaseApplication.getContext().getSharedPreferences("arkappid2pkname_entry", 4).edit().putString(paramString2, paramString1).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     albp
 * JD-Core Version:    0.7.0.1
 */