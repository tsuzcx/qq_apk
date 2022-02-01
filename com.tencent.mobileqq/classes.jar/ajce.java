import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.Conversation.39.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ajce
  extends amrc
{
  public ajce(Conversation paramConversation) {}
  
  protected void onAddDiscussionMember(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    this.a.a(8, Long.toString(paramLong), 3000);
  }
  
  protected void onChangeDiscussionName(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onChangeDiscussionName");
      }
      this.a.a(8, paramString, 3000);
    }
  }
  
  protected void onDelDiscussion()
  {
    this.a.a(9, null, -2147483648);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onDelDiscussion");
    }
  }
  
  protected void onQuitDiscussion(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onQuitDiscussion");
      }
      this.a.a(8, paramString, 3000);
    }
  }
  
  protected void onUpdateDiscussionFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "conversation onUpdateDiscussionFaceIcon|[" + paramBoolean1 + ", " + paramBoolean2 + ", " + paramString + "]");
    }
    if (paramBoolean1) {
      this.a.b(new Conversation.39.1(this, paramString));
    }
  }
  
  protected void updateDiscussionInfo(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_updateDiscussionInfo");
      }
      this.a.a(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajce
 * JD-Core Version:    0.7.0.1
 */