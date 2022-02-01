import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class ailw
  implements ailp
{
  private ailr jdField_a_of_type_Ailr;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ailx(this);
  public Toast a;
  public bfgl a;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener b = new aily(this);
  
  public ailw(QQAppInterface paramQQAppInterface, ailr paramailr, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, bfgl parambfgl, Toast paramToast)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ailr = paramailr;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Bfgl = parambfgl;
    this.jdField_a_of_type_AndroidWidgetToast = paramToast;
  }
  
  public int a()
  {
    return 20;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719730);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin) == 3) {
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719731);
    }
    View localView = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramVarArgs, this.b, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "AIOchat", "exp_setmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin) == 3) {}
    for (paramVarArgs = "1";; paramVarArgs = "0")
    {
      bdla.b(localQQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "exp_topbar", 0, 0, str, paramVarArgs, "", "");
      return localView;
    }
  }
  
  public void a()
  {
    if ((a()) || (this.jdField_a_of_type_Boolean)) {
      awtz.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1);
      if ((this.jdField_a_of_type_Bfgl == null) || (!this.jdField_a_of_type_Bfgl.a())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopAssistTipsBar", 2, "navigateBar is show, return ");
    return;
    ThreadManager.post(new TroopAssistTipsBar.1(this), 8, null, true);
  }
  
  public boolean a()
  {
    return 3 == this.jdField_a_of_type_Ailr.a();
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailw
 * JD-Core Version:    0.7.0.1
 */