import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.open.applist.QZoneAppListActivity;

public class alfd
  extends OnPluginInstallListener.Stub
{
  public alfd(QZoneAppListActivity paramQZoneAppListActivity) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    this.a.a(paramInt1 / paramInt2 * 100);
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    this.a.runOnUiThread(new alfe(this));
  }
  
  public void onInstallFinish(String paramString)
  {
    QZoneAppListActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alfd
 * JD-Core Version:    0.7.0.1
 */