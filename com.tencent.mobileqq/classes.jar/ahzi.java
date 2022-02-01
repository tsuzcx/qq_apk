import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

class ahzi
  implements Handler.Callback
{
  ahzi(ahzc paramahzc) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, "[handleMessage] handle message mStoped = " + ahzc.a(this.a));
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      Object localObject = (amme)this.a.app.getManager(QQManagerFactory.APOLLO_MANAGER);
      paramMessage = (String)paramMessage.obj;
      if (!ahzc.a(this.a)) {
        ((amme)localObject).a().e(paramMessage);
      }
      localObject = Message.obtain();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = paramMessage;
      ahzc.a(this.a).removeMessages(1);
      ahzc.a(this.a).sendMessageDelayed((Message)localObject, 30000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzi
 * JD-Core Version:    0.7.0.1
 */