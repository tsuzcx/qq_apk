import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;

class acxc
  implements Runnable
{
  acxc(acxb paramacxb) {}
  
  public void run()
  {
    DownloadManager.a().a(UniformDownloadActivity.a(this.a.a));
    MyAppApi.a().a(this.a.a, "http://a.app.qq.com/o/myapp-down?g_f=1001647", "ANDROIDQQ.WIFIDLYYB.GAME", 2, true);
    OpenSdkStatic.a().a(UniformDownloadActivity.a(this.a.a), "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3004", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acxc
 * JD-Core Version:    0.7.0.1
 */