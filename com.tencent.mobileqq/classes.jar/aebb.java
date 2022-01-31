import android.os.Message;
import com.tencent.mobileqq.leba.model.pluginactions.JDPluginAction;
import mqq.os.MqqHandler;

public class aebb
  extends MqqHandler
{
  public aebb(JDPluginAction paramJDPluginAction) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1134008: 
      this.a.a(paramMessage);
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebb
 * JD-Core Version:    0.7.0.1
 */