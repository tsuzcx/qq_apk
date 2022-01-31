import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.qphone.base.util.BaseApplication;

public class aclb
  implements Runnable
{
  public aclb(FileManagerDataCenter paramFileManagerDataCenter) {}
  
  public void run()
  {
    if ((this.a.a != null) && (this.a.a.getApp() != null) && (FileManagerDataCenter.a(this.a) != null)) {
      this.a.a.getApp().unregisterReceiver(FileManagerDataCenter.a(this.a));
    }
    FileManagerDataCenter.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aclb
 * JD-Core Version:    0.7.0.1
 */