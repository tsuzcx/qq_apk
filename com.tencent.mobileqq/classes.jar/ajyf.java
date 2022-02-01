import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class ajyf
  extends aodo
{
  public ajyf(Conversation paramConversation) {}
  
  public void onCheckRealNameRsp(boolean paramBoolean, int paramInt)
  {
    if (!this.a.f) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "VideoRedbag, onCheckRealNameRsp in conv");
      }
    } while ((!paramBoolean) || (paramInt != bdcw.a));
    bhdj.a(this.a.a(), 0, null, this.a.a(2131718857), 2131718859, 2131718858, new ajyg(this), new ajyh(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyf
 * JD-Core Version:    0.7.0.1
 */