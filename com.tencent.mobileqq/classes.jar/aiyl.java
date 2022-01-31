import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;

public class aiyl
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private final aiym jdField_a_of_type_Aiym;
  private aiyn jdField_a_of_type_Aiyn;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public aiyl(aiym paramaiym)
  {
    this.jdField_a_of_type_Aiym = paramaiym;
    this.jdField_a_of_type_AndroidOsHandler = new befq(ThreadManager.getSubThreadLooper(), this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt, aiyn paramaiyn)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Aiyn = paramaiyn;
  }
  
  public void a(Bundle paramBundle)
  {
    this.b = false;
    do
    {
      while (!this.b) {
        switch (this.jdField_a_of_type_Aiym.a(paramBundle))
        {
        case 0: 
        default: 
          break;
        case -1: 
          if (this.jdField_a_of_type_Aiyn != null)
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
    this.jdField_a_of_type_Aiyn = null;
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
      if (this.jdField_a_of_type_Aiyn != null)
      {
        this.jdField_a_of_type_Aiyn.b();
        this.jdField_a_of_type_Aiyn = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiyl
 * JD-Core Version:    0.7.0.1
 */