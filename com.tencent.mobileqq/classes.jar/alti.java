import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.3;
import com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.3.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

public class alti
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  public alti(ArkAppPreDownloadMgr.3.1 param1) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkAppPreDownloadMgr", 2, new Object[] { "profiling preDownloadApp app=", this.a.a.a.a, ",retcode=", Integer.valueOf(paramInt), ",msg=", paramString });
    }
    paramString = (QQAppInterface)alth.a(this.a.a.this$0).get();
    if (paramString != null)
    {
      paramString = (ayxs)paramString.getManager(193);
      if (paramString != null)
      {
        if ((paramInt != 0) || (paramAppPathInfo == null) || (paramAppPathInfo.path == null)) {
          break label211;
        }
        long l = 0L;
        paramAppPathInfo = new File(paramAppPathInfo.path);
        if (paramAppPathInfo.exists()) {
          l = paramAppPathInfo.length();
        }
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp.ArkAppPreDownloadMgr", 2, new Object[] { "profiling preDownloadApp app=", this.a.a.a.a, ",filesize=", Long.valueOf(l) });
        }
        paramString.a(this.a.a.a.a, l);
      }
    }
    return;
    label211:
    paramString.a(this.a.a.a.a, -1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alti
 * JD-Core Version:    0.7.0.1
 */