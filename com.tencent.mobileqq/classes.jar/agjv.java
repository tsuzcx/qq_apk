import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class agjv
  implements Handler.Callback
{
  agjv(agjp paramagjp) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "[handleMessage] handle message mStoped = " + agjp.a(this.a));
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      Object localObject = (akji)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      paramMessage = (String)paramMessage.obj;
      if (!agjp.a(this.a)) {
        ((akji)localObject).a().e(paramMessage);
      }
      localObject = Message.obtain();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = paramMessage;
      agjp.a(this.a).removeMessages(1);
      agjp.a(this.a).sendMessageDelayed((Message)localObject, 30000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agjv
 * JD-Core Version:    0.7.0.1
 */