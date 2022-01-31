import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aene
  implements Handler.Callback
{
  aene(aemy paramaemy) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "[handleMessage] handle message mStoped = " + aemy.a(this.a));
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      Object localObject = (airx)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      paramMessage = (String)paramMessage.obj;
      if (!aemy.a(this.a)) {
        ((airx)localObject).a().e(paramMessage);
      }
      localObject = Message.obtain();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = paramMessage;
      aemy.a(this.a).removeMessages(1);
      aemy.a(this.a).sendMessageDelayed((Message)localObject, 30000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aene
 * JD-Core Version:    0.7.0.1
 */