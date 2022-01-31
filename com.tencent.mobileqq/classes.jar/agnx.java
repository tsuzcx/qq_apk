import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class agnx
  implements View.OnClickListener
{
  agnx(agnn paramagnn) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    paramView = paramView.getTag();
    if ((paramView == null) || (!(paramView instanceof Integer))) {
      return;
    }
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    switch (((Integer)paramView).intValue())
    {
    default: 
      return;
    case 1: 
      ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (String)localObject, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, true);
      return;
    case 2: 
      ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (String)localObject, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, false);
      return;
    }
    if (this.a.jdField_a_of_type_Bfyh.f(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      paramView = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      String str = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131690623);
      if (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("param_return_addr") != null) {}
      for (;;)
      {
        ChatActivityUtils.a(paramView, (SessionInfo)localObject, str, bool);
        return;
        bool = false;
      }
    }
    this.a.bu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agnx
 * JD-Core Version:    0.7.0.1
 */