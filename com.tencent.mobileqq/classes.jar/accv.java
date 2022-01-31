import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

public class accv
  implements View.OnClickListener
{
  public accv(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof Integer))) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (aeke.b());
        paramView = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) {
          paramView = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f;
        }
        switch (((Integer)localObject).intValue())
        {
        default: 
          return;
        case 1: 
          ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, true);
        }
      } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1010);
      azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004954", "0X8004954", 0, 0, "", "", "", "");
      return;
      ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, false);
    } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1010);
    azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
    return;
    boolean bool2 = ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if (bool2) {
      azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Manage_stranger", "Manage_str_add", 0, 0, "", "", "", "");
    }
    paramView = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    String str = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131690623);
    if (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("param_return_addr") != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ChatActivityUtils.a(paramView, (SessionInfo)localObject, str, bool1, bool2);
      return;
    }
    paramView = (bhpy)bhql.a(this.a.a(), null);
    paramView.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131720206));
    paramView.a(2131720204, 3);
    paramView.b(2131720203);
    paramView.c(2131690648);
    paramView.a(new accw(this, paramView));
    paramView.show();
    azmj.b(null, "dc00898", "", "", "0X800ACA2", "0X800ACA2", 0, 0, "", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     accv
 * JD-Core Version:    0.7.0.1
 */