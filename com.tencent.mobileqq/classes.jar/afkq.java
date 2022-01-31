import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class afkq
  extends BroadcastReceiver
{
  public afkq(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 1;
    paramContext = paramIntent.getAction();
    if ((TextUtils.isEmpty(paramContext)) || (!TextUtils.equals(paramContext, "mqq.intent.action.DEVLOCK_ROAM"))) {}
    do
    {
      do
      {
        return;
        if (this.a.getActivity() != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.history.C2CAllFragment", 2, "OpenDevLockReceiver get activity is null");
      return;
    } while (this.a.jdField_a_of_type_AndroidContentBroadcastReceiver == null);
    this.a.getActivity().getApplicationContext().unregisterReceiver(this.a.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.a.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    boolean bool = paramIntent.getBooleanExtra("auth_dev_open", false);
    int k = paramIntent.getIntExtra("auth_dev_open_cb_reason", 0);
    paramIntent = paramIntent.getByteArrayExtra("devlock_roam_sig");
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder().append("openDevLock callback isOpen: ").append(bool).append(", reason: ").append(k).append(", da2 length: ");
      if (paramIntent == null)
      {
        i = 0;
        QLog.d("Q.history.C2CAllFragment", 2, i);
      }
    }
    else
    {
      QQAppInterface localQQAppInterface = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str = k + "";
      if (!bool) {
        break label301;
      }
      paramContext = "true";
      label211:
      bajr.a(localQQAppInterface, "chat_history", "LockSet", "opendev_amount", 1, 0, new String[] { str, "0", paramContext });
      paramContext = this.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(29);
      if (!bool) {
        break label307;
      }
    }
    label301:
    label307:
    for (int i = j;; i = 0)
    {
      paramContext.arg1 = i;
      paramContext.arg2 = k;
      paramContext.obj = paramIntent;
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramContext, 500L);
      return;
      i = paramIntent.length;
      break;
      paramContext = "false";
      break label211;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afkq
 * JD-Core Version:    0.7.0.1
 */