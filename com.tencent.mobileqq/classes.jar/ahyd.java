import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahyd
  implements View.OnClickListener
{
  ahyd(ahxt paramahxt) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    Object localObject1 = paramView.getTag();
    if ((localObject1 == null) || (!(localObject1 instanceof Integer))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      switch (((Integer)localObject1).intValue())
      {
      default: 
        break;
      case 1: 
        ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (String)localObject2, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, true);
        break;
      case 2: 
        ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (String)localObject2, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, false);
        break;
      case 3: 
        if (this.a.jdField_a_of_type_Bjft.f(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          localObject1 = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
          localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
          String str = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131690563);
          if (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("param_return_addr") != null) {}
          for (;;)
          {
            ChatActivityUtils.a((Activity)localObject1, (SessionInfo)localObject2, str, bool);
            break;
            bool = false;
          }
        }
        this.a.br();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyd
 * JD-Core Version:    0.7.0.1
 */