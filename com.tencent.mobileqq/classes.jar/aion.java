import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class aion
  extends Handler
{
  aion(aioi paramaioi, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      do
      {
        do
        {
          return;
          paramMessage = (aioz)paramMessage.obj;
          if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, aioi.a(paramMessage.d, "main handler", paramMessage.a, "all img process is finished, now is in main thread"));
          }
          this.a.e(paramMessage);
          return;
          paramMessage = (String)paramMessage.obj;
          if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "response is empty, errorMsg is " + paramMessage);
          }
        } while (this.a.jdField_a_of_type_Aiou == null);
        this.a.jdField_a_of_type_Aiou.a(paramMessage);
        return;
        i = paramMessage.arg1;
        paramMessage = (String)paramMessage.obj;
        if (paramMessage.equals(this.a.a())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ZhituManager", 2, aioi.a(paramMessage, "main handler", "reqKey is outdated, skip"));
      return;
      if (this.a.jdField_a_of_type_Aiox != null) {
        this.a.jdField_a_of_type_Aiox.a(i, paramMessage);
      }
    } while (this.a.jdField_a_of_type_Aiou == null);
    this.a.jdField_a_of_type_Aiou.a(i, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aion
 * JD-Core Version:    0.7.0.1
 */