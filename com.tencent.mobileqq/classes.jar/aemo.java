import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.qidian.data.BmqqAccountType;

class aemo
  extends ajto
{
  aemo(aemh paramaemh) {}
  
  protected void onGetAccountType(boolean paramBoolean, BmqqAccountType paramBmqqAccountType)
  {
    super.onGetAccountType(paramBoolean, paramBmqqAccountType);
    aemh.a(this.a);
    this.a.bo();
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (this.a.jdField_a_of_type_Bduf.f(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!aemh.a(this.a)))
    {
      aemh.a(this.a, true);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getChatFragment().a);
    }
    if ((paramBmqqAccountType != null) && (paramBmqqAccountType.getUin() != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (paramBmqqAccountType.getUin().equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (paramBmqqAccountType.getAccountType() == 6)) {
      aemh.b(this.a);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) && ((TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d)) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = naz.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.a.e.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aemo
 * JD-Core Version:    0.7.0.1
 */