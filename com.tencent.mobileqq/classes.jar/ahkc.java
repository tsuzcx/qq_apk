import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;

class ahkc
  extends ahkx
{
  private agzf jdField_a_of_type_Agzf;
  private agzo jdField_a_of_type_Agzo;
  private agzx jdField_a_of_type_Agzx;
  
  ahkc(ahgk paramahgk)
  {
    super(paramahgk, null);
  }
  
  protected aghc a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return null;
  }
  
  protected aghc b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
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
    if ((this.jdField_a_of_type_Ahgk.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1008) || (this.jdField_a_of_type_Ahgk.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1038))
    {
      if (this.jdField_a_of_type_Agzx == null) {
        this.jdField_a_of_type_Agzx = new agzx(this.jdField_a_of_type_Ahgk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_Ahgk.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ahgk.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Ahgk.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_Ahgk.a(this.jdField_a_of_type_Agzx, paramBaseAdapter);
    }
    if ((i == 0) || (this.jdField_a_of_type_Ahgk.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 9501))
    {
      if (this.jdField_a_of_type_Agzo == null) {
        this.jdField_a_of_type_Agzo = new agzo(this.jdField_a_of_type_Ahgk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_Ahgk.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ahgk.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Ahgk.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_Ahgk.a(this.jdField_a_of_type_Agzo, paramBaseAdapter);
    }
    if (this.jdField_a_of_type_Agzf == null) {
      this.jdField_a_of_type_Agzf = new agzf(this.jdField_a_of_type_Ahgk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_Ahgk.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ahgk.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Ahgk.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
    }
    return this.jdField_a_of_type_Ahgk.a(this.jdField_a_of_type_Agzf, paramBaseAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkc
 * JD-Core Version:    0.7.0.1
 */