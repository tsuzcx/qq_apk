import com.tencent.mobileqq.activity.history.ChatHistoryC2CDateFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CDateFragment.3.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class ajpt
  implements anqi
{
  public ajpt(ChatHistoryC2CDateFragment paramChatHistoryC2CDateFragment) {}
  
  public void a(anqi paramanqi) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ChatHistoryC2CDateFragment.b(), 2, "onGetRoamMsgForDate " + paramBoolean);
    }
    this.a.p();
    if (paramBoolean)
    {
      ThreadManagerV2.executeOnSubThread(new ChatHistoryC2CDateFragment.3.1(this));
      return;
    }
    this.a.c(this.a.getString(2131690652));
  }
  
  public void b(int paramInt1, int paramInt2, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpt
 * JD-Core Version:    0.7.0.1
 */