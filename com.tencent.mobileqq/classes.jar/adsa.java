import android.app.Dialog;
import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.ChatSettingForTroop.ClearChatRecordTask;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class adsa
  implements binu
{
  public adsa(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a(Dialog paramDialog, View paramView, boolean paramBoolean)
  {
    ThreadManager.post(new ChatSettingForTroop.ClearChatRecordTask(this.a), 5, null, false);
    bhbu.a("Grp_set_new", "grpData_admin", "confirm_delRecord", 0, 0, new String[] { this.a.a.troopUin, bhbu.a(this.a.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adsa
 * JD-Core Version:    0.7.0.1
 */