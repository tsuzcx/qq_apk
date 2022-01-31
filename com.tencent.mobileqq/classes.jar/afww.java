import android.text.TextUtils;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class afww
  extends AccountObserver
{
  public afww(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment, boolean paramBoolean) {}
  
  public void onRefreshDA2(boolean paramBoolean, String paramString1, String paramString2)
  {
    int j = 1;
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder().append("onRefrshDA2 result: ").append(paramBoolean).append(", da2 length: ");
      if (paramString2 == null)
      {
        i = 0;
        QLog.d("Q.history.C2CAllFragment", 2, i);
      }
    }
    else
    {
      if ((!paramBoolean) || (TextUtils.isEmpty(paramString2))) {
        break label133;
      }
      i = 1;
      label67:
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CAllFragment.a.obtainMessage(39);
      if (i == 0) {
        break label139;
      }
      i = 1;
      label88:
      paramString1.arg1 = i;
      if (!this.jdField_a_of_type_Boolean) {
        break label145;
      }
    }
    label133:
    label139:
    label145:
    for (int i = j;; i = 0)
    {
      paramString1.arg2 = i;
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CAllFragment.a.sendMessage(paramString1);
      return;
      i = paramString2.length();
      break;
      i = 0;
      break label67;
      i = 0;
      break label88;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afww
 * JD-Core Version:    0.7.0.1
 */