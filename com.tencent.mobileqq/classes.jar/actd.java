import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class actd
  extends bayj
{
  final WeakReference<Conversation> a;
  
  public actd(Conversation paramConversation)
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
      bass localbass;
      int k;
      int i;
      do
      {
        do
        {
          return;
          localbass = (bass)paramMessage.obj;
        } while ((Conversation.a(localConversation) == null) || (localbass == null) || (TextUtils.isEmpty(localbass.p)));
        k = paramMessage.what;
        if (localbass.b != 1)
        {
          i = j;
          if (localbass.b != 2) {}
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
      } while ((i == 0) && (((k != 1003) && (k != 2003)) || ((localbass.b != 2) && (!localConversation.f))));
      localConversation.a(8, localbass.p, -2147483648);
    } while (!QLog.isColorLevel());
    QLog.i("Q.recent", 2, "refresh recent, from_transferListener2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     actd
 * JD-Core Version:    0.7.0.1
 */