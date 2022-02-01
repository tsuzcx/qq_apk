import android.view.View;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

class aauy
  implements bjoe
{
  aauy(aaux paramaaux, MessageForPtt paramMessageForPtt, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Aaux.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByUniseq(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.uniseq);
    paramView = null;
    if (this.jdField_a_of_type_Aaux.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      paramView = bbli.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      ((MessageForPtt)paramView).fileSize = -3L;
      this.jdField_a_of_type_Aaux.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage(paramView, this.jdField_a_of_type_Aaux.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    if (paramView != null)
    {
      if (!"device_groupchat".equals(paramView.extStr)) {
        break label256;
      }
      if ((!NetworkUtil.isNetSupport(BaseApplication.getContext())) && ((paramView instanceof MessageForDevPtt)))
      {
        paramView = (MessageForDevPtt)paramView;
        paramView.fileSize = -1L;
        paramView.extraflag = 32768;
        paramView.extStr = "device_groupchat";
        paramView.serial();
        this.jdField_a_of_type_Aaux.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(paramView.frienduin, paramView.istroop, paramView.uniseq, paramView.msgData);
        this.jdField_a_of_type_Aaux.b();
        this.jdField_a_of_type_Bjnw.dismiss();
        return;
      }
      ahff.a(((aara)this.jdField_a_of_type_Aaux.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(51)).a(Long.parseLong(this.jdField_a_of_type_Aaux.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin), this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceLength), paramView);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aaux.b();
      this.jdField_a_of_type_Bjnw.dismiss();
      return;
      label256:
      ((aavk)this.jdField_a_of_type_Aaux.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(49)).a().a(aavk.f, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url, Long.parseLong(this.jdField_a_of_type_Aaux.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin), paramView.uniseq, paramView.istroop, (int)this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgRecTime / 1000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aauy
 * JD-Core Version:    0.7.0.1
 */