import com.tencent.ark.ArkAppPreloader.PreloadAppCallback;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.qphone.base.util.QLog;

class altj
  implements ArkAppPreloader.PreloadAppCallback
{
  altj(alth paramalth) {}
  
  public void beginAppload(String paramString, int paramInt)
  {
    if (paramInt == 1) {
      altb.a(paramString);
    }
  }
  
  public void onAppLoaded(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramInt == 1)
    {
      altb.b(paramString);
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, new Object[] { "profiling preload app appname=", paramString, ",success=", Boolean.valueOf(paramBoolean) });
      }
    }
  }
  
  public void onReleaseAndReload(String paramString, int paramInt)
  {
    QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling onReleaseAndReload begin app = " + paramString);
    ArkAppMgr.getInstance().getAppPathByName(paramString, "", "0.0.0.1", null, new altk(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     altj
 * JD-Core Version:    0.7.0.1
 */