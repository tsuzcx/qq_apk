import com.tencent.biz.qqcircle.list.bizblocks.QCircleObserver;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aeam
  extends QCircleObserver
{
  private WeakReference<Conversation> a;
  
  public aeam(Conversation paramConversation)
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
        localConversation.p();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeam
 * JD-Core Version:    0.7.0.1
 */