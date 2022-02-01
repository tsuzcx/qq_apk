import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;

class agzf
  extends ahaa
{
  private agog jdField_a_of_type_Agog;
  private agop jdField_a_of_type_Agop;
  private agoy jdField_a_of_type_Agoy;
  
  agzf(agvm paramagvm)
  {
    super(paramagvm, null);
  }
  
  protected afrj a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return null;
  }
  
  protected afrj b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
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
    if ((this.jdField_a_of_type_Agvm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1008) || (this.jdField_a_of_type_Agvm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1038))
    {
      if (this.jdField_a_of_type_Agoy == null) {
        this.jdField_a_of_type_Agoy = new agoy(this.jdField_a_of_type_Agvm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_Agvm.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Agvm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Agvm.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_Agvm.a(this.jdField_a_of_type_Agoy, paramBaseAdapter);
    }
    if ((i == 0) || (this.jdField_a_of_type_Agvm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 9501))
    {
      if (this.jdField_a_of_type_Agop == null) {
        this.jdField_a_of_type_Agop = new agop(this.jdField_a_of_type_Agvm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_Agvm.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Agvm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Agvm.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_Agvm.a(this.jdField_a_of_type_Agop, paramBaseAdapter);
    }
    if (this.jdField_a_of_type_Agog == null) {
      this.jdField_a_of_type_Agog = new agog(this.jdField_a_of_type_Agvm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_Agvm.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Agvm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Agvm.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
    }
    return this.jdField_a_of_type_Agvm.a(this.jdField_a_of_type_Agog, paramBaseAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agzf
 * JD-Core Version:    0.7.0.1
 */