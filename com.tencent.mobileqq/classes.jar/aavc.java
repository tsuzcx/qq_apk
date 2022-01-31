import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.qphone.base.util.QLog;

public class aavc
  extends bbqu
{
  public aavc(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void onGetMyTroopEffect(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "onGetMyTroopEffect  result = " + paramBoolean);
    }
    if (paramBoolean) {
      this.a.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aavc
 * JD-Core Version:    0.7.0.1
 */