import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;

public class alin
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private final alio jdField_a_of_type_Alio;
  private alip jdField_a_of_type_Alip;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public alin(alio paramalio)
  {
    this.jdField_a_of_type_Alio = paramalio;
    this.jdField_a_of_type_AndroidOsHandler = new bhtd(ThreadManager.getSubThreadLooper(), this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt, alip paramalip)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Alip = paramalip;
  }
  
  public void a(Bundle paramBundle)
  {
    this.b = false;
    do
    {
      while (!this.b) {
        switch (this.jdField_a_of_type_Alio.a(paramBundle))
        {
        case 0: 
        default: 
          break;
        case -1: 
          if (this.jdField_a_of_type_Alip != null)
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
    this.jdField_a_of_type_Alip = null;
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
      if (this.jdField_a_of_type_Alip != null)
      {
        this.jdField_a_of_type_Alip.b();
        this.jdField_a_of_type_Alip = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alin
 * JD-Core Version:    0.7.0.1
 */