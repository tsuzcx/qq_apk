import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.qphone.base.util.QLog;

public class abrx
  extends Handler
{
  public abrx(Client paramClient, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
    }
    do
    {
      do
      {
        return;
        this.a.onRespFromServer(paramMessage.getData());
      } while (!QLog.isColorLevel());
      QLog.i("Q.emoji.web.Client", 2, "resp from server MSG_CLIENT_RESP");
      return;
      this.a.onPushMsgFromServer(paramMessage.getData());
    } while (!QLog.isColorLevel());
    QLog.i("Q.emoji.web.Client", 2, "resp from server MSG_SERVER_DOWNLOAD_STATE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abrx
 * JD-Core Version:    0.7.0.1
 */