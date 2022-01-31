import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;

class afow
  extends afpq
{
  private afec jdField_a_of_type_Afec;
  private afek jdField_a_of_type_Afek;
  private afet jdField_a_of_type_Afet;
  
  afow(aflj paramaflj)
  {
    super(paramaflj, null);
  }
  
  protected aemj a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return null;
  }
  
  protected aemj b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    int j = 1;
    int i = j;
    if ((paramChatMessage instanceof MessageForArkApp))
    {
      paramChatMessage = (MessageForArkApp)paramChatMessage;
      ArkAppMessage.Config localConfig = new ArkAppMessage.Config();
      i = j;
      if (paramChatMessage.ark_app_message != null)
      {
        localConfig.fromString(paramChatMessage.ark_app_message.config);
        i = j;
        if (localConfig.showSender != null)
        {
          i = j;
          if (localConfig.showSender.intValue() == 0) {
            i = 0;
          }
        }
      }
    }
    if ((this.jdField_a_of_type_Aflj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1008) || (this.jdField_a_of_type_Aflj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1038))
    {
      if (this.jdField_a_of_type_Afet == null) {
        this.jdField_a_of_type_Afet = new afet(this.jdField_a_of_type_Aflj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_Aflj.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aflj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Aflj.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_Aflj.a(this.jdField_a_of_type_Afet, paramBaseAdapter);
    }
    if ((i == 0) || (this.jdField_a_of_type_Aflj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 9501))
    {
      if (this.jdField_a_of_type_Afek == null) {
        this.jdField_a_of_type_Afek = new afek(this.jdField_a_of_type_Aflj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_Aflj.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aflj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Aflj.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_Aflj.a(this.jdField_a_of_type_Afek, paramBaseAdapter);
    }
    if (this.jdField_a_of_type_Afec == null) {
      this.jdField_a_of_type_Afec = new afec(this.jdField_a_of_type_Aflj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_Aflj.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aflj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Aflj.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
    }
    return this.jdField_a_of_type_Aflj.a(this.jdField_a_of_type_Afec, paramBaseAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afow
 * JD-Core Version:    0.7.0.1
 */