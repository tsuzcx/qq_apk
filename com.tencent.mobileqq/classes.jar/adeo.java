import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import java.lang.ref.WeakReference;

public class adeo
  extends Handler
{
  public adeo(GamePartyManager paramGamePartyManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)GamePartyManager.a(this.a).get();
    if (localQQAppInterface == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = "http://openmobile.qq.com/gameteam/get_team_context?uin=" + localQQAppInterface.getCurrentAccountUin();
    this.a.a(paramMessage, null);
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adeo
 * JD-Core Version:    0.7.0.1
 */