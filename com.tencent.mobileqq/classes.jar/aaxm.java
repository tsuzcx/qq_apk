import com.tencent.mobileqq.activity.Conversation;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aaxm
  extends akfk
{
  private WeakReference<Conversation> a;
  
  public aaxm(Conversation paramConversation)
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
      Conversation.g(localConversation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaxm
 * JD-Core Version:    0.7.0.1
 */