import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import java.util.List;

public class aiss
  extends Handler
{
  public aiss(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      paramMessage = (List)paramMessage.obj;
      this.a.a(paramMessage, true);
      return;
    }
    paramMessage = (List)paramMessage.obj;
    this.a.a(paramMessage, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiss
 * JD-Core Version:    0.7.0.1
 */