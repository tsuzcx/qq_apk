import com.tencent.ark.open.ArkAppInfo.AppTemplateView;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public final class afik
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  protected WeakReference<afii> a;
  
  public afik(WeakReference<afii> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    paramObject = (afii)this.a.get();
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkAppContainer", 1, "onGetAppPathByName.wrapper == null");
      }
      return;
    }
    String str1 = paramObject.a(paramString);
    if (paramAppPathInfo != null) {}
    for (paramString = paramAppPathInfo.path;; paramString = null)
    {
      paramObject.a.getAppFromLocal = false;
      paramObject.a.endOfGetApp = System.currentTimeMillis();
      if ((paramAppPathInfo != null) && (paramAppPathInfo.appTempInfo != null))
      {
        String str2 = paramAppPathInfo.appTempInfo.template;
        str2 = paramAppPathInfo.appTempInfo.templateView;
        afii.a(paramObject).view = str2;
      }
      afii.a(paramAppPathInfo);
      paramObject.a(paramString, paramInt, str1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afik
 * JD-Core Version:    0.7.0.1
 */