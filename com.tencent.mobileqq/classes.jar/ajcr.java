import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class ajcr
  extends anaz
{
  public ajcr(Conversation paramConversation) {}
  
  public void onCheckRealNameRsp(boolean paramBoolean, int paramInt)
  {
    if (!this.a.f) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "VideoRedbag, onCheckRealNameRsp in conv");
      }
    } while ((!paramBoolean) || (paramInt != bbwb.a));
    bfur.a(this.a.a(), 0, null, this.a.a(2131718471), 2131718473, 2131718472, new ajcs(this), new ajct(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajcr
 * JD-Core Version:    0.7.0.1
 */