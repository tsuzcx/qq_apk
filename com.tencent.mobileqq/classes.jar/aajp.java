import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.AppSchemeHandler;
import com.tencent.mobileqq.ark.ArkAppCGI.ArkAppCGICallback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aajp
  extends ArkAppCGI.ArkAppCGICallback
{
  public aajp(ArkAppSchemeCenter.AppSchemeHandler paramAppSchemeHandler, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, Object paramObject)
  {
    if (!paramBoolean)
    {
      QLog.i("ArkApp", 1, "ArkAppSchemeCenter.AppSchemeHandler.get packagename failed.");
      return;
    }
    ArkAppSchemeCenter.AppSchemeHandler.a((ArkAppSchemeCenter.AppSchemeHandler)paramObject, paramString2, this.jdField_a_of_type_JavaLangString, paramString1);
    BaseApplication.getContext().getSharedPreferences("arkappid2pkname_entry", 4).edit().putString(paramString2, paramString1).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aajp
 * JD-Core Version:    0.7.0.1
 */