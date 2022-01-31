import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.UpdateFriend;
import com.tencent.qphone.base.util.QLog;

public class ajyh
  extends ajjh
{
  private ajyh(UpdateFriend paramUpdateFriend) {}
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.a.b == 7) || (this.a.b == 3))
    {
      if (paramBoolean1) {
        break label37;
      }
      this.a.a(6);
    }
    label37:
    while ((!paramBoolean1) || (!paramBoolean2)) {
      return;
    }
    this.a.a.a.edit().putBoolean("isFriendlistok", true).commit();
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "onUpdateFriendList put PREF_ISFRIENDLIST_OK true");
    }
    this.a.a.notifyUI(3, true, Integer.valueOf(1));
    this.a.a(7);
  }
  
  protected void onUpdateGatherFriendList(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.a.b == 8)
    {
      if (paramBoolean1) {
        break label26;
      }
      this.a.a(6);
    }
    label26:
    while (!paramBoolean2) {
      return;
    }
    this.a.a(7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajyh
 * JD-Core Version:    0.7.0.1
 */