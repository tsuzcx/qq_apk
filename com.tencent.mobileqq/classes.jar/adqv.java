import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.qphone.base.util.QLog;

public class adqv
  extends anyz
{
  public adqv(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void onInsertIntoBlackList(boolean paramBoolean, String paramString)
  {
    if (!ChatSettingActivity.d(this.a)) {
      return;
    }
    ChatSettingActivity.c(this.a, false);
    ChatSettingActivity.g(this.a);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "onInsertIntoBlackList, isSuccess=" + paramBoolean);
    }
    if (paramBoolean)
    {
      if ((paramString != null) && (paramString.equals(ChatSettingActivity.e(this.a)))) {
        ChatSettingActivity.a(this.a, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.a, 2, "onInsertIntoBlackList, mIsShield=" + ChatSettingActivity.a(this.a));
      }
      ChatSettingActivity.b(this.a);
      return;
    }
    ChatSettingActivity.a(this.a, 2131718805, 1);
  }
  
  protected void onRemoveFromBlackList(boolean paramBoolean, String paramString)
  {
    if (!ChatSettingActivity.d(this.a)) {
      return;
    }
    ChatSettingActivity.c(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "onRemoveFromBlackList, isSuccess=" + paramBoolean);
    }
    ChatSettingActivity.g(this.a);
    if (paramBoolean)
    {
      if ((paramString != null) && (paramString.equals(ChatSettingActivity.e(this.a)))) {
        ChatSettingActivity.a(this.a, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.a, 2, "onRemoveFromBlackList, mIsShield=" + ChatSettingActivity.a(this.a));
      }
      ChatSettingActivity.b(this.a);
      return;
    }
    ChatSettingActivity.a(this.a, 2131718805, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqv
 * JD-Core Version:    0.7.0.1
 */