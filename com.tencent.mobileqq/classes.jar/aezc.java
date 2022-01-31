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

public class aezc
  implements aeyv
{
  private aeyx jdField_a_of_type_Aeyx;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aezd(this);
  public Toast a;
  public aznm a;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener b = new aeze(this);
  
  public aezc(QQAppInterface paramQQAppInterface, aeyx paramaeyx, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, aznm paramaznm, Toast paramToast)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aeyx = paramaeyx;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Aznm = paramaznm;
    this.jdField_a_of_type_AndroidWidgetToast = paramToast;
  }
  
  public int a()
  {
    return 20;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131720567);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 3) {
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131720568);
    }
    View localView = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramVarArgs, this.b, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "AIOchat", "exp_setmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 3) {}
    for (paramVarArgs = "1";; paramVarArgs = "0")
    {
      axqw.b(localQQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "exp_topbar", 0, 0, str, paramVarArgs, "", "");
      return localView;
    }
  }
  
  public void a()
  {
    if ((a()) || (this.jdField_a_of_type_Boolean)) {
      asfb.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1);
      if ((this.jdField_a_of_type_Aznm == null) || (!this.jdField_a_of_type_Aznm.a())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopAssistTipsBar", 2, "navigateBar is show, return ");
    return;
    ThreadManager.post(new TroopAssistTipsBar.1(this), 8, null, true);
  }
  
  public boolean a()
  {
    return 3 == this.jdField_a_of_type_Aeyx.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aezc
 * JD-Core Version:    0.7.0.1
 */