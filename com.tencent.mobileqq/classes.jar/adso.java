import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.qphone.base.util.QLog;

public class adso
  implements View.OnLongClickListener
{
  public adso(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public boolean onLongClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "setTroopUinTextViewClickListener onLongClick");
    }
    ChatSettingForTroop.p(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adso
 * JD-Core Version:    0.7.0.1
 */