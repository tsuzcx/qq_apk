import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ArNativeSoLoader;
import com.tencent.mobileqq.armap.wealthgod.ARMapLoadingActivity;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.ArNativeSoDownloadHandler;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.qphone.base.util.QLog;

public class abpk
  implements Runnable
{
  public abpk(ARMapLoadingActivity paramARMapLoadingActivity) {}
  
  public void run()
  {
    ARMapLoadingActivity.a(this.a).removeMessages(111);
    ARMapLoadingActivity.a(this.a).sendEmptyMessageDelayed(111, 300000L);
    boolean bool = ArNativeSoLoader.b("ArMapEngine7652");
    Object localObject = (ArNativeSoDownloadHandler)((EarlyDownloadManager)this.a.app.getManager(76)).a("qq.android.ar.native.so_v7.6.5.2");
    if (!bool) {
      if (localObject != null)
      {
        ((ArNativeSoDownloadHandler)localObject).a().Version = 0;
        ((ArNativeSoDownloadHandler)localObject).a(ARMapLoadingActivity.a(this.a));
        ((ArNativeSoDownloadHandler)localObject).a(true, true);
      }
    }
    do
    {
      return;
      if (!this.a.a()) {
        break;
      }
      String str1 = ArNativeSoLoader.a() + "/lib" + "ArMapEngine7652" + ".so";
      String str2 = PortalUtils.a(str1);
      String str3 = this.a.a();
      if (QLog.isColorLevel()) {
        QLog.d("ARMapLoadingActivity", 2, "handleCheckAndDownloadSo, path=" + str1 + ", calc=" + str2 + ", md5=" + str3);
      }
      if (str3.equalsIgnoreCase(str2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ARMapLoadingActivity", 2, "handleCheckAndDownloadSo, md5 match, lunch armap");
        }
        ARMapLoadingActivity.a(this.a).removeMessages(111);
        localObject = ARMapLoadingActivity.a(this.a).obtainMessage(112);
        ARMapLoadingActivity.a(this.a).sendMessage((Message)localObject);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ARMapLoadingActivity", 2, "handleCheckAndDownloadSo, md5 mismatch, go download");
      }
    } while (localObject == null);
    ((ArNativeSoDownloadHandler)localObject).a().Version = 0;
    ((ArNativeSoDownloadHandler)localObject).a(ARMapLoadingActivity.a(this.a));
    ((ArNativeSoDownloadHandler)localObject).a(true, true);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "handleCheckAndDownloadSo, not need check");
    }
    ARMapLoadingActivity.a(this.a).removeMessages(111);
    localObject = ARMapLoadingActivity.a(this.a).obtainMessage(112);
    ARMapLoadingActivity.a(this.a).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abpk
 * JD-Core Version:    0.7.0.1
 */