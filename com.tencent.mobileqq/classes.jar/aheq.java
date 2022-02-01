import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aheq
  implements Handler.Callback
{
  aheq(ahek paramahek) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, "[handleMessage] handle message mStoped = " + ahek.a(this.a));
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      Object localObject = (alnr)this.a.app.getManager(153);
      paramMessage = (String)paramMessage.obj;
      if (!ahek.a(this.a)) {
        ((alnr)localObject).a().e(paramMessage);
      }
      localObject = Message.obtain();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = paramMessage;
      ahek.a(this.a).removeMessages(1);
      ahek.a(this.a).sendMessageDelayed((Message)localObject, 30000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aheq
 * JD-Core Version:    0.7.0.1
 */