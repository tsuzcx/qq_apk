import android.app.Activity;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.qphone.base.util.QLog;

public class ajls
  extends ajif
{
  public ajls(SystemMsgListView paramSystemMsgListView) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendVerification.manager", 2, "ui.onRefreshBlockedEntrance");
    }
    if (((Activity)SystemMsgListView.a(this.a)).isFinishing()) {}
    while ((!paramBoolean) || (SystemMsgListView.a(this.a) == null)) {
      return;
    }
    SystemMsgListView.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajls
 * JD-Core Version:    0.7.0.1
 */