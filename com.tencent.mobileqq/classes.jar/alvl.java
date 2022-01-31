import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class alvl
  extends Handler
{
  public alvl(QQAppInterface paramQQAppInterface, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      paramMessage = (QQAppInterface)((WeakReference)paramMessage.obj).get();
      if (paramMessage != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQAppInterface", 2, "getOnlineFriend app is null");
    return;
    long l1 = QQAppInterface.e;
    long l3 = SystemClock.uptimeMillis();
    long l2 = Math.abs(l3 - this.a.c);
    if ((!"0".equals(paramMessage.getCurrentAccountUin())) && (l2 >= QQAppInterface.e))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "getOnlineFriend");
      }
      this.a.c = l3;
      FriendListHandler localFriendListHandler = (FriendListHandler)paramMessage.a(1);
      if (localFriendListHandler != null) {
        localFriendListHandler.d(paramMessage.getCurrentAccountUin(), (byte)0);
      }
    }
    if (l2 < QQAppInterface.e) {
      l1 = QQAppInterface.e - l2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "getOnlineFriend send next msg " + l1);
    }
    paramMessage = this.a.a.obtainMessage(0, new WeakReference(paramMessage));
    this.a.a.sendMessageDelayed(paramMessage, l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alvl
 * JD-Core Version:    0.7.0.1
 */