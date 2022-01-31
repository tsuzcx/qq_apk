import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aaoc
  extends axvs
{
  final WeakReference<Conversation> a;
  
  public aaoc(Conversation paramConversation)
  {
    this.a = new WeakReference(paramConversation);
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void handleMessage(Message paramMessage)
  {
    int j = 0;
    Conversation localConversation = (Conversation)this.a.get();
    if (localConversation == null) {}
    do
    {
      axqf localaxqf;
      int k;
      int i;
      do
      {
        do
        {
          return;
          localaxqf = (axqf)paramMessage.obj;
        } while ((Conversation.a(localConversation) == null) || (localaxqf == null) || (TextUtils.isEmpty(localaxqf.p)));
        k = paramMessage.what;
        if (localaxqf.b != 1)
        {
          i = j;
          if (localaxqf.b != 2) {}
        }
        else if ((k != 1001) && (k != 1002) && (k != 1000) && (k != 1005))
        {
          i = j;
          if (k != 1003) {}
        }
        else
        {
          i = 1;
        }
      } while ((i == 0) && (((k != 1003) && (k != 2003)) || ((localaxqf.b != 2) && (!localConversation.f))));
      localConversation.a(8, localaxqf.p, -2147483648);
    } while (!QLog.isColorLevel());
    QLog.i("Q.recent", 2, "refresh recent, from_transferListener2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaoc
 * JD-Core Version:    0.7.0.1
 */