import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption;

public class adte
  implements Runnable
{
  public adte(ForwardPluginShareStructMsgOption paramForwardPluginShareStructMsgOption, SessionInfo paramSessionInfo, String paramString) {}
  
  public void run()
  {
    AnonymousChatHelper.a().a = true;
    ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqForwardForwardPluginShareStructMsgOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqForwardForwardPluginShareStructMsgOption.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adte
 * JD-Core Version:    0.7.0.1
 */