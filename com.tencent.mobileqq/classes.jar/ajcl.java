import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.qphone.base.util.QLog;

public class ajcl
  extends anaa
{
  public ajcl(Conversation paramConversation) {}
  
  protected void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, new Object[] { "onRegPrxyUpdateLoginDevStatus int iState = ", Integer.valueOf(paramInt) });
    }
    if (paramInt == 1)
    {
      this.a.a.a(31, 2);
      this.a.a.a(-1, null);
      return;
    }
    this.a.a.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajcl
 * JD-Core Version:    0.7.0.1
 */