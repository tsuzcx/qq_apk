import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class aehf
  implements Runnable
{
  public aehf(MixedMsgManager paramMixedMsgManager, SessionInfo paramSessionInfo, MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager.a.getAccount();
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b;
    localObject2 = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager.a, str, (String)localObject2, i);
    ((MessageForMixedMsg)localObject2).extraflag = 32772;
    ((MessageForMixedMsg)localObject2).msgData = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.msgData;
    ((MessageForMixedMsg)localObject2).msgElemList = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.msgElemList;
    if (!this.jdField_a_of_type_Boolean)
    {
      ((MessageForMixedMsg)localObject2).mForwardFromIsTroop = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.istroop;
      ((MessageForMixedMsg)localObject2).mForwardFromUin = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.frienduin;
    }
    for (;;)
    {
      localObject3 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
        if ((localMessageRecord instanceof MessageForPic)) {
          localMessageRecord.istroop = i;
        }
      }
      ((MessageForMixedMsg)localObject2).mIsResend = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager.a.a().b((MessageRecord)localObject2, this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager.a.getAccount());
    this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager.a.a().a(1000, true, str);
    Object localObject3 = new ArrayList();
    localObject1 = PicBusiManager.a(7, (MessageForMixedMsg)localObject2, i, (String)localObject1, str, this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager.a.getAccount());
    if (localObject1 != null) {
      ((ArrayList)localObject3).addAll((Collection)localObject1);
    }
    while (((ArrayList)localObject3).size() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "[forwardMixedMsg]Upload pictures, count is [" + ((ArrayList)localObject3).size() + "], goto requestUploadPics");
      }
      MixedMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager, this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager.a, str, i, (ArrayList)localObject3, (MessageForMixedMsg)localObject2);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("MixedMsgManager", 2, "[forwardMixedMsg]createForwardPicInfos from MessageForMixedMsg failed");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, "[forwardMixedMsg]There's not any picture messages, goto onPackAndSendMsg");
    }
    MixedMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager, this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager.a, str, i, (MessageForMixedMsg)localObject2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehf
 * JD-Core Version:    0.7.0.1
 */