import com.tencent.mobileqq.activity.Conversation;
import com.tencent.qphone.base.util.QLog;

public class aaws
  extends akfn
{
  public aaws(Conversation paramConversation) {}
  
  protected void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, new Object[] { "onRegPrxyUpdateLoginDevStatus int iState = ", Integer.valueOf(paramInt) });
    }
    if (paramInt == 1)
    {
      this.a.a.a(27, 2);
      this.a.a.a(-1, null);
      return;
    }
    this.a.a.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaws
 * JD-Core Version:    0.7.0.1
 */