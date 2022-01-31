import com.tencent.mobileqq.filemanager.core.FileVideoManager;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.VideoControl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class acvx
  implements Runnable
{
  public acvx(long paramLong) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.a + "]FreeVideoControl");
    }
    if ((FileVideoManager.a == null) || (FileVideoManager.a(FileVideoManager.a) == null) || (!FileVideoManager.a(FileVideoManager.a).containsKey(Long.valueOf(this.a)))) {
      if (QLog.isDevelopLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.a + "]queue is zero return");
      }
    }
    do
    {
      return;
      FileVideoManager.VideoControl localVideoControl = (FileVideoManager.VideoControl)FileVideoManager.a(FileVideoManager.a).get(Long.valueOf(this.a));
      localVideoControl.a();
      FileVideoManager.a(localVideoControl);
      FileVideoManager.a(FileVideoManager.a).remove(Long.valueOf(this.a));
    } while (!QLog.isDevelopLevel());
    QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.a + "]removed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acvx
 * JD-Core Version:    0.7.0.1
 */