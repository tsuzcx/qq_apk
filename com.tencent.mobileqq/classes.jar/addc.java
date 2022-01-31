import android.content.IntentFilter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.qphone.base.util.BaseApplication;

public class addc
  implements Runnable
{
  public addc(FileManagerDataCenter paramFileManagerDataCenter) {}
  
  public void run()
  {
    if ((this.a.a != null) && (this.a.a.getApp() != null))
    {
      if (FileManagerDataCenter.a(this.a) != null) {
        this.a.a.getApp().unregisterReceiver(FileManagerDataCenter.a(this.a));
      }
      if (FileManagerDataCenter.a(this.a) == null) {
        FileManagerDataCenter.a(this.a, new addd(this));
      }
      IntentFilter localIntentFilter = new IntentFilter("com.opensdk.downloadmanager.renameFilename");
      this.a.a.getApp().registerReceiver(FileManagerDataCenter.a(this.a), localIntentFilter);
      FMSettings.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     addc
 * JD-Core Version:    0.7.0.1
 */