import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class affq
  extends Handler
{
  public affq(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    boolean bool;
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "handleMessage,msg.what:" + paramMessage.what);
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
              TroopMemberListActivity.a(this.a, paramMessage);
              return;
              this.a.k();
            }
          case 13: 
            paramMessage = this.a;
            paramMessage.jdField_a_of_type_Double += TroopMemberListActivity.jdField_b_of_type_Double;
          }
        } while ((this.a.jdField_a_of_type_Double <= this.a.jdField_a_of_type_AndroidWidgetProgressBar.getProgress()) || (this.a.jdField_a_of_type_Double >= 90.0D) || (TroopMemberListActivity.a(this.a) <= 0));
        int i = (int)this.a.jdField_a_of_type_Double;
        int j = (int)(TroopMemberListActivity.a(this.a) * this.a.jdField_a_of_type_Double / 100.0D);
        TroopMemberListActivity.a(this.a, j, TroopMemberListActivity.a(this.a), i);
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(13), 800L);
        return;
        List localList;
        synchronized (this.a)
        {
          TroopMemberListActivity.b(this.a);
          localList = (List)paramMessage.obj;
          if ((localList == null) && (this.a.jdField_d_of_type_Int != 14)) {
            return;
          }
        }
        if (this.a.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
        {
          this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(13);
          double d = Math.min(0.9D + paramMessage.arg1 * 1.0D / TroopMemberListActivity.a(this.a), 1.0D);
          i = (int)(100.0D * d);
          if (i > this.a.jdField_a_of_type_AndroidWidgetProgressBar.getProgress())
          {
            j = (int)(d * TroopMemberListActivity.a(this.a));
            TroopMemberListActivity.a(this.a, j, TroopMemberListActivity.a(this.a), i);
          }
        }
        if (localList != null) {
          this.a.jdField_a_of_type_JavaUtilList.addAll(localList);
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "handleMessage, mJobCount left:" + TroopMemberListActivity.c(this.a) + "mATroopMemberList.size():" + this.a.jdField_a_of_type_JavaUtilList.size());
        }
        if (TroopMemberListActivity.c(this.a) <= 0) {
          TroopMemberListActivity.b(this.a, true);
        }
        if ((TroopMemberListActivity.b(this.a)) && (TroopMemberListActivity.d(this.a)))
        {
          if (this.a.jdField_a_of_type_JavaUtilList.isEmpty()) {
            return;
          }
          this.a.k();
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "handleMessage real totalTime:" + (System.currentTimeMillis() - TroopMemberListActivity.a(this.a)) + "start refreshUI");
          }
          if (this.a.app.getProxyManager() != null) {
            this.a.app.getProxyManager().notifyRefreshTroopMember();
          }
          paramMessage.obj = this.a.jdField_a_of_type_Afgk.a();
          TroopMemberListActivity.a(this.a, paramMessage);
        }
        return;
        this.a.k();
        return;
        if (this.a.jdField_a_of_type_Afgk != null)
        {
          if (this.a.jdField_a_of_type_Afgk.b != null) {
            this.a.jdField_a_of_type_Afgk.b.clear();
          }
          this.a.jdField_a_of_type_Afgk.a();
        }
        if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
          this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        QQToast.a(this.a, this.a.getString(2131691443), 0).b(this.a.jdField_a_of_type_AndroidViewView.getHeight());
        TroopMemberListActivity.a(this.a);
        return;
        if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
          this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        QQToast.a(this.a, this.a.getString(2131691442), 0).b(this.a.jdField_a_of_type_AndroidViewView.getHeight());
        return;
      } while ((this.a.jdField_a_of_type_AndroidAppDialog == null) || (!this.a.jdField_a_of_type_AndroidAppDialog.isShowing()));
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      return;
      paramMessage = (Object[])paramMessage.obj;
      bool = ((Boolean)paramMessage[0]).booleanValue();
      paramMessage = (ArrayList)paramMessage[1];
      ChatSettingForTroop.a(this.a, this.a.jdField_b_of_type_JavaLangString, bool, paramMessage);
      return;
    } while (this.a.jdField_a_of_type_Afgk == null);
    this.a.jdField_a_of_type_Afgk.a();
    return;
    paramMessage = (TroopInfo)paramMessage.obj;
    if (paramMessage.troopowneruin != null) {
      this.a.e = paramMessage.troopowneruin;
    }
    if (paramMessage.Administrator != null) {
      this.a.f = paramMessage.Administrator;
    }
    ??? = this.a;
    if ((this.a.app.getCurrentAccountUin().equals(paramMessage.troopowneruin)) || ((this.a.f != null) && (this.a.f.contains(this.a.app.getCurrentAccountUin()))))
    {
      bool = true;
      label1083:
      ???.jdField_a_of_type_Boolean = bool;
      if ((this.a.e == null) || (!this.a.e.equals(this.a.app.getCurrentAccountUin()))) {
        break label1160;
      }
    }
    for (this.a.n = "0"; this.a.jdField_a_of_type_Afgk != null; this.a.n = "1")
    {
      label1133:
      this.a.jdField_a_of_type_Afgk.a();
      return;
      bool = false;
      break label1083;
      label1160:
      if ((this.a.f == null) || (!this.a.f.contains(this.a.app.getCurrentAccountUin()))) {
        break label1133;
      }
    }
    this.a.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     affq
 * JD-Core Version:    0.7.0.1
 */