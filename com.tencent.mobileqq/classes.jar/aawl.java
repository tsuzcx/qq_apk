import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.Conversation.35.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aawl
  extends ajvj
{
  public aawl(Conversation paramConversation) {}
  
  protected void a()
  {
    this.a.a(9, null, -2147483648);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onDelDiscussion");
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    this.a.a(8, Long.toString(paramLong), 3000);
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_updateDiscussionInfo");
      }
      this.a.a(0L);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onChangeDiscussionName");
      }
      this.a.a(8, paramString, 3000);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "conversation onUpdateDiscussionFaceIcon|[" + paramBoolean1 + ", " + paramBoolean2 + ", " + paramString + "]");
    }
    if (paramBoolean1) {
      this.a.a(new Conversation.35.1(this, paramString));
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onQuitDiscussion");
      }
      this.a.a(8, paramString, 3000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aawl
 * JD-Core Version:    0.7.0.1
 */