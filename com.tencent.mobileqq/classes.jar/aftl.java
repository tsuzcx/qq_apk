import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;

class aftl
  extends afuf
{
  private afir jdField_a_of_type_Afir;
  private afiz jdField_a_of_type_Afiz;
  private afji jdField_a_of_type_Afji;
  
  aftl(afpy paramafpy)
  {
    super(paramafpy, null);
  }
  
  protected aeqy a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return null;
  }
  
  protected aeqy b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
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
    if ((this.jdField_a_of_type_Afpy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1008) || (this.jdField_a_of_type_Afpy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1038))
    {
      if (this.jdField_a_of_type_Afji == null) {
        this.jdField_a_of_type_Afji = new afji(this.jdField_a_of_type_Afpy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_Afpy.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Afpy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Afpy.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_Afpy.a(this.jdField_a_of_type_Afji, paramBaseAdapter);
    }
    if ((i == 0) || (this.jdField_a_of_type_Afpy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 9501))
    {
      if (this.jdField_a_of_type_Afiz == null) {
        this.jdField_a_of_type_Afiz = new afiz(this.jdField_a_of_type_Afpy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_Afpy.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Afpy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Afpy.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_Afpy.a(this.jdField_a_of_type_Afiz, paramBaseAdapter);
    }
    if (this.jdField_a_of_type_Afir == null) {
      this.jdField_a_of_type_Afir = new afir(this.jdField_a_of_type_Afpy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_Afpy.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Afpy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Afpy.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
    }
    return this.jdField_a_of_type_Afpy.a(this.jdField_a_of_type_Afir, paramBaseAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aftl
 * JD-Core Version:    0.7.0.1
 */