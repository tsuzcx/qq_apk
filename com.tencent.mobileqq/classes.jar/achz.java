import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class achz
  extends TransProcessorHandler
{
  public achz(FavroamingManager paramFavroamingManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.c != 9)) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      case 1002: 
      default: 
        return;
      case 1001: 
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "start uploadFace favEmoticon");
        }
        break;
      }
    } while (FavroamingManager.b().incrementAndGet() < FavroamingManager.b());
    FavroamingManager.a(this.a);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "finish uploadFace favEmoticon resId=" + localFileMsg.g);
    }
    ThreadManager.post(new acia(this, localFileMsg), 5, null, false);
    return;
    QLog.i("FavroamingManager", 1, "upload fav error:" + localFileMsg.g);
    if (this.a.a != null) {}
    for (int i = NetworkUtil.b(this.a.a.getApplication());; i = -1)
    {
      VasReportUtils.a("emotionType", "emotionActionFav", "4", "", "", i + "", localFileMsg.g, "", "", "");
      return;
      QLog.i("FavroamingManager", 1, "upload fav cancel:" + localFileMsg.g);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     achz
 * JD-Core Version:    0.7.0.1
 */