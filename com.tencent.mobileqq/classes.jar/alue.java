import android.content.Context;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;

class alue
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  alue(alub paramalub, String paramString, Context paramContext) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if ((paramInt == 0) && (paramAppPathInfo.path != null)) {
      ArkAppCacheMgr.getAppIcon(this.jdField_a_of_type_JavaLangString, new aluf(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alue
 * JD-Core Version:    0.7.0.1
 */