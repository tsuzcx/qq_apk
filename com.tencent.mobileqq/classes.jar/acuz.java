import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.core.FileVideoManager;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class acuz
  extends MqqHandler
{
  public acuz(FileManagerNotifyCenter paramFileManagerNotifyCenter, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerNotifyCenter<FileAssistant>", 1, "recv Netchang event!");
    }
    this.a.a.a().a(true);
    this.a.a.a().b(-1);
    FileVideoManager.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acuz
 * JD-Core Version:    0.7.0.1
 */