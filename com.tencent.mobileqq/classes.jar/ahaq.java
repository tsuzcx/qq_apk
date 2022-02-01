import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;

class ahaq
  extends ahbl
{
  private agpz jdField_a_of_type_Agpz;
  private agqi jdField_a_of_type_Agqi;
  private agqr jdField_a_of_type_Agqr;
  
  ahaq(agwz paramagwz)
  {
    super(paramagwz, null);
  }
  
  protected afxi a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return null;
  }
  
  protected afxi b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
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
    if ((this.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1008) || (this.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1038))
    {
      if (this.jdField_a_of_type_Agqr == null) {
        this.jdField_a_of_type_Agqr = new agqr(this.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_Agwz.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_Agwz.a(this.jdField_a_of_type_Agqr, paramBaseAdapter);
    }
    if ((i == 0) || (this.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 9501))
    {
      if (this.jdField_a_of_type_Agqi == null) {
        this.jdField_a_of_type_Agqi = new agqi(this.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_Agwz.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_Agwz.a(this.jdField_a_of_type_Agqi, paramBaseAdapter);
    }
    if (this.jdField_a_of_type_Agpz == null) {
      this.jdField_a_of_type_Agpz = new agpz(this.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_Agwz.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
    }
    return this.jdField_a_of_type_Agwz.a(this.jdField_a_of_type_Agpz, paramBaseAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahaq
 * JD-Core Version:    0.7.0.1
 */