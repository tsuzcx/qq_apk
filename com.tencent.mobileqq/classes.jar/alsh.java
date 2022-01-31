import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import common.config.service.QzoneConfig;

public class alsh
  extends ContentObserver
{
  public alsh(QzoneConfig paramQzoneConfig, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    ThreadManager.post(new alsi(this, paramBoolean), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alsh
 * JD-Core Version:    0.7.0.1
 */