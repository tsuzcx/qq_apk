import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

class aasz
  implements View.OnClickListener
{
  aasz(aasy paramaasy) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof String)) {
      return;
    }
    Object localObject1 = (ChatMessage)((aimg)paramView.getTag()).a;
    if (this.a.a()) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a((ChatMessage)localObject1)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b((ChatMessage)localObject1);
      }
    }
    while ((!(localObject1 instanceof MessageForStructing)) || (((MessageForStructing)localObject1).structingMsg == null) || (!(((MessageForStructing)localObject1).structingMsg instanceof AbsShareMsg))) {
      for (;;)
      {
        this.a.jdField_a_of_type_Aimf.notifyDataSetChanged();
        return;
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a()) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a((ChatMessage)localObject1);
      }
    }
    localObject1 = (AbsShareMsg)((MessageForStructing)localObject1).structingMsg;
    Object localObject2;
    if ((localObject1 instanceof StructMsgForGeneralShare))
    {
      localObject2 = (StructMsgForGeneralShare)localObject1;
      axvk localaxvk = new axvk(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, (StructMsgForGeneralShare)localObject2);
      StructMsgForGeneralShare.onClickEvent(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, (StructMsgForGeneralShare)localObject2, paramView, localaxvk);
    }
    for (;;)
    {
      ((AbsShareMsg)localObject1).getOnClickListener().onClick(paramView);
      break;
      if ((localObject1 instanceof StructMsgForAudioShare))
      {
        localObject2 = (StructMsgForAudioShare)localObject1;
        StructMsgForAudioShare.onClickEvent(this.a.jdField_a_of_type_AndroidContentContext, (StructMsgForAudioShare)localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aasz
 * JD-Core Version:    0.7.0.1
 */