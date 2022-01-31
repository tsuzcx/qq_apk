import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;

public class ajml
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private final ajmm jdField_a_of_type_Ajmm;
  private ajmn jdField_a_of_type_Ajmn;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public ajml(ajmm paramajmm)
  {
    this.jdField_a_of_type_Ajmm = paramajmm;
    this.jdField_a_of_type_AndroidOsHandler = new bfob(ThreadManager.getSubThreadLooper(), this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt, ajmn paramajmn)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Ajmn = paramajmn;
  }
  
  public void a(Bundle paramBundle)
  {
    this.b = false;
    do
    {
      while (!this.b) {
        switch (this.jdField_a_of_type_Ajmm.a(paramBundle))
        {
        case 0: 
        default: 
          break;
        case -1: 
          if (this.jdField_a_of_type_Ajmn != null)
          {
            paramBundle = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
            this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramBundle, this.jdField_a_of_type_Int);
          }
          break;
        }
      }
      return;
    } while (!this.jdField_a_of_type_Boolean);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.setData(paramBundle);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b()
  {
    this.b = true;
    this.jdField_a_of_type_Ajmn = null;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (!this.b) {
        a(paramMessage.getData());
      }
      return true;
      if (this.jdField_a_of_type_Ajmn != null)
      {
        this.jdField_a_of_type_Ajmn.b();
        this.jdField_a_of_type_Ajmn = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajml
 * JD-Core Version:    0.7.0.1
 */