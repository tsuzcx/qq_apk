import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Queue;

class akgt
  extends Handler
{
  akgt(akgr paramakgr, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = (akgv)paramMessage.obj;
    this.a.a.remove(paramMessage);
    paramMessage.jdField_a_of_type_AndroidContentContext.startActivity(paramMessage.jdField_a_of_type_AndroidContentIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akgt
 * JD-Core Version:    0.7.0.1
 */