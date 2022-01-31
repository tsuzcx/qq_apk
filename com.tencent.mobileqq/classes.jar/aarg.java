import android.content.Context;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.AppPathInfo;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.IGetAppPathByNameCallback;
import com.tencent.mobileqq.ark.ArkTipsManager;

public class aarg
  implements ArkLocalAppMgr.IGetAppPathByNameCallback
{
  public aarg(ArkTipsManager paramArkTipsManager, Context paramContext) {}
  
  public void a(int paramInt, String paramString, ArkLocalAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if ((paramInt == 0) && (paramAppPathInfo.a != null)) {
      ArkAppCenter.a(paramAppPathInfo.a, new aarh(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aarg
 * JD-Core Version:    0.7.0.1
 */