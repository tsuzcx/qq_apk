import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class agad
  extends Handler
{
  public agad(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.getActivity() == null) || (this.a.getActivity().isFinishing())) {}
    boolean bool;
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.history.BaseFragment", 2, "handleMessage,msg.what:" + paramMessage.what);
          }
          switch (paramMessage.what)
          {
          case 3: 
          case 4: 
          case 10: 
          default: 
            return;
          case 1: 
          case 2: 
            for (;;)
            {
              ChatHistoryTroopMemberFragment.a(this.a, paramMessage);
              return;
              this.a.y();
            }
          case 13: 
            paramMessage = this.a;
            paramMessage.jdField_a_of_type_Double += ChatHistoryTroopMemberFragment.jdField_b_of_type_Double;
          }
        } while ((this.a.jdField_a_of_type_Double <= this.a.jdField_a_of_type_AndroidWidgetProgressBar.getProgress()) || (this.a.jdField_a_of_type_Double >= 90.0D) || (ChatHistoryTroopMemberFragment.a(this.a) <= 0));
        int i = (int)this.a.jdField_a_of_type_Double;
        int j = (int)(ChatHistoryTroopMemberFragment.a(this.a) * this.a.jdField_a_of_type_Double / 100.0D);
        ChatHistoryTroopMemberFragment.a(this.a, j, ChatHistoryTroopMemberFragment.a(this.a), i);
        this.a.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(13), 800L);
        return;
        List localList;
        synchronized (this.a)
        {
          ChatHistoryTroopMemberFragment.b(this.a);
          localList = (List)paramMessage.obj;
          if ((localList == null) && (this.a.jdField_d_of_type_Int != 14)) {
            return;
          }
        }
        if (this.a.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
        {
          this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(13);
          double d = Math.min(0.9D + paramMessage.arg1 * 1.0D / ChatHistoryTroopMemberFragment.a(this.a), 1.0D);
          i = (int)(100.0D * d);
          if (i > this.a.jdField_a_of_type_AndroidWidgetProgressBar.getProgress())
          {
            j = (int)(d * ChatHistoryTroopMemberFragment.a(this.a));
            ChatHistoryTroopMemberFragment.a(this.a, j, ChatHistoryTroopMemberFragment.a(this.a), i);
          }
        }
        if (localList != null) {
          this.a.jdField_a_of_type_JavaUtilList.addAll(localList);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.history.BaseFragment", 2, "handleMessage, mJobCount left:" + ChatHistoryTroopMemberFragment.c(this.a) + "mATroopMemberList.size():" + this.a.jdField_a_of_type_JavaUtilList.size());
        }
        if (ChatHistoryTroopMemberFragment.c(this.a) <= 0) {
          ChatHistoryTroopMemberFragment.b(this.a, true);
        }
        if ((ChatHistoryTroopMemberFragment.b(this.a)) && (ChatHistoryTroopMemberFragment.d(this.a)))
        {
          if (this.a.jdField_a_of_type_JavaUtilList.isEmpty()) {
            return;
          }
          this.a.y();
          if (QLog.isColorLevel()) {
            QLog.d("Q.history.BaseFragment", 2, "handleMessage real totalTime:" + (System.currentTimeMillis() - ChatHistoryTroopMemberFragment.a(this.a)) + "start refreshUI");
          }
          if (this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
            this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().g();
          }
          paramMessage.obj = this.a.jdField_a_of_type_Agaw.a();
          ChatHistoryTroopMemberFragment.a(this.a, paramMessage);
        }
        return;
        this.a.y();
        return;
        if (this.a.jdField_a_of_type_Agaw != null)
        {
          if (this.a.jdField_a_of_type_Agaw.b != null) {
            this.a.jdField_a_of_type_Agaw.b.clear();
          }
          this.a.jdField_a_of_type_Agaw.a();
        }
        if ((this.a.jdField_c_of_type_AndroidAppDialog != null) && (this.a.jdField_c_of_type_AndroidAppDialog.isShowing())) {
          this.a.jdField_c_of_type_AndroidAppDialog.dismiss();
        }
        bcpw.a(this.a.getActivity(), this.a.getString(2131691499), 0).b(this.a.jdField_b_of_type_AndroidViewView.getHeight());
        ChatHistoryTroopMemberFragment.a(this.a);
        return;
        if ((this.a.jdField_c_of_type_AndroidAppDialog != null) && (this.a.jdField_c_of_type_AndroidAppDialog.isShowing())) {
          this.a.jdField_c_of_type_AndroidAppDialog.dismiss();
        }
        bcpw.a(this.a.getActivity(), this.a.getString(2131691498), 0).b(this.a.jdField_b_of_type_AndroidViewView.getHeight());
        return;
      } while ((this.a.jdField_c_of_type_AndroidAppDialog == null) || (!this.a.jdField_c_of_type_AndroidAppDialog.isShowing()));
      this.a.jdField_c_of_type_AndroidAppDialog.dismiss();
      return;
      paramMessage = (Object[])paramMessage.obj;
      bool = ((Boolean)paramMessage[0]).booleanValue();
      paramMessage = (ArrayList)paramMessage[1];
      ChatSettingForTroop.a(this.a.getActivity(), this.a.jdField_c_of_type_JavaLangString, bool, paramMessage);
      return;
    } while (this.a.jdField_a_of_type_Agaw == null);
    this.a.jdField_a_of_type_Agaw.a();
    return;
    paramMessage = (TroopInfo)paramMessage.obj;
    if (paramMessage.troopowneruin != null) {
      this.a.f = paramMessage.troopowneruin;
    }
    if (paramMessage.Administrator != null) {
      this.a.g = paramMessage.Administrator;
    }
    ??? = this.a;
    if ((this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramMessage.troopowneruin)) || ((this.a.g != null) && (this.a.g.contains(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))))
    {
      bool = true;
      label1104:
      ???.jdField_d_of_type_Boolean = bool;
      if ((this.a.f == null) || (!this.a.f.equals(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        break label1181;
      }
    }
    for (this.a.o = "0"; this.a.jdField_a_of_type_Agaw != null; this.a.o = "1")
    {
      label1154:
      this.a.jdField_a_of_type_Agaw.a();
      return;
      bool = false;
      break label1104;
      label1181:
      if ((this.a.g == null) || (!this.a.g.contains(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        break label1154;
      }
    }
    this.a.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agad
 * JD-Core Version:    0.7.0.1
 */