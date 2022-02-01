import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ajdi
  extends amzx
{
  private WeakReference<Conversation> a;
  
  public ajdi(Conversation paramConversation)
  {
    this.a = new WeakReference(paramConversation);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "cameraRedTouchObserver notify dataChanged");
    }
    Conversation localConversation = (Conversation)this.a.get();
    if (localConversation != null)
    {
      localConversation.f(false);
      Conversation.k(localConversation);
      localConversation.q();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdi
 * JD-Core Version:    0.7.0.1
 */