import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;

class aggo
  extends aghj
{
  private afvr jdField_a_of_type_Afvr;
  private afwa jdField_a_of_type_Afwa;
  private afwj jdField_a_of_type_Afwj;
  
  aggo(agcw paramagcw)
  {
    super(paramagcw, null);
  }
  
  protected aezx a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return null;
  }
  
  protected aezx b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
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
    if ((this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1008) || (this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1038))
    {
      if (this.jdField_a_of_type_Afwj == null) {
        this.jdField_a_of_type_Afwj = new afwj(this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_Agcw.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_Agcw.a(this.jdField_a_of_type_Afwj, paramBaseAdapter);
    }
    if ((i == 0) || (this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 9501))
    {
      if (this.jdField_a_of_type_Afwa == null) {
        this.jdField_a_of_type_Afwa = new afwa(this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_Agcw.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_Agcw.a(this.jdField_a_of_type_Afwa, paramBaseAdapter);
    }
    if (this.jdField_a_of_type_Afvr == null) {
      this.jdField_a_of_type_Afvr = new afvr(this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_Agcw.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
    }
    return this.jdField_a_of_type_Agcw.a(this.jdField_a_of_type_Afvr, paramBaseAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aggo
 * JD-Core Version:    0.7.0.1
 */