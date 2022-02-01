import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.chat.QCircleObserver;
import java.lang.ref.WeakReference;

public class ajdh
  extends QCircleObserver
{
  private WeakReference<Conversation> a;
  
  public ajdh(Conversation paramConversation)
  {
    this.a = new WeakReference(paramConversation);
  }
  
  public void onUpdateRedPoint(int paramInt)
  {
    Conversation localConversation = (Conversation)this.a.get();
    StringBuilder localStringBuilder = new StringBuilder().append("QCircleObserver onUpdateRedPoint: ");
    if (localConversation != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.recent", 2, bool);
      if (localConversation != null) {
        localConversation.q();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdh
 * JD-Core Version:    0.7.0.1
 */