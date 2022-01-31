import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class aejh
  implements Runnable
{
  public aejh(MultiMsgManager paramMultiMsgManager, ArrayList paramArrayList, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int j = 0;
    int i = 0;
    Object localObject2;
    Object localObject1;
    if (localIterator.hasNext())
    {
      localObject2 = (ChatMessage)localIterator.next();
      if (((ChatMessage)localObject2).msgtype == -2000)
      {
        localObject1 = (MessageForPic)localObject2;
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForPic)localObject1);
        i += 1;
        label75:
        if (j >= MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager)) {
          break label835;
        }
      }
    }
    for (;;)
    {
      try
      {
        Thread.sleep(MultiMsgManager.b(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager));
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "sendMultuMsgSeperaterFromLocal delay  i = " + j + " mDelayTime = " + MultiMsgManager.b(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager));
        }
        j += 1;
        break;
        if (((ChatMessage)localObject2).msgtype == -2011)
        {
          if (!(localObject2 instanceof MessageForStructing)) {
            break label838;
          }
          localObject1 = ((MessageForStructing)localObject2).structingMsg;
          if ((localObject1 == null) || (!(localObject1 instanceof StructMsgForImageShare))) {
            break label838;
          }
          StructMsgForImageShare.sendAndUploadImageShare(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (StructMsgForImageShare)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, 0);
          k = 1;
          if (k == 0) {
            ShareMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((MessageForStructing)localObject2).structingMsg, null);
          }
          break label75;
        }
        if (((ChatMessage)localObject2).msgtype == -5008)
        {
          ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((MessageForArkApp)localObject2).ark_app_message);
          break label75;
        }
        if (((ChatMessage)localObject2).msgtype == -5017)
        {
          ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((MessageForArkApp)localObject2).ark_app_message);
          break label75;
        }
        if (((ChatMessage)localObject2).msgtype == -5016)
        {
          ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForArkBabyqReply)localObject2, false, false);
          break label75;
        }
        if (((ChatMessage)localObject2).msgtype == -5013)
        {
          ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((MessageForArkFlashChat)localObject2).ark_app_message);
          break label75;
        }
        if ((((ChatMessage)localObject2).msgtype == -1035) || (((ChatMessage)localObject2).msgtype == -1036))
        {
          if (((ChatMessage)localObject2).msgtype == -1036)
          {
            localObject1 = (MessageForMixedMsg)((MessageForLongMsg)localObject2).rebuildLongMsg();
            ((MessageForMixedMsg)localObject1).mForwardFromUniSeq = ((ChatMessage)localObject2).uniseq;
            ((MixedMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(173)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForMixedMsg)localObject1, false);
            break label75;
          }
          localObject1 = (MessageForMixedMsg)localObject2;
          continue;
        }
        if (((ChatMessage)localObject2).msgtype == -2022)
        {
          localObject1 = (MessageForShortVideo)localObject2;
          ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForShortVideo)localObject1);
          break label75;
        }
        localObject1 = ((ChatMessage)localObject2).msg;
        localObject2 = new ChatActivityFacade.SendMsgParams();
        ((ChatActivityFacade.SendMsgParams)localObject2).f = true;
        ((ChatActivityFacade.SendMsgParams)localObject2).h = true;
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1, null, (ChatActivityFacade.SendMsgParams)localObject2);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "sendMultuMsgSeperaterFromLocal sendMsg cost = " + (System.currentTimeMillis() - l));
      }
      int k = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (localChatMessage != null) {}
      for (j = localChatMessage.istroop;; j = 0)
      {
        if (j == 0) {
          j = 1;
        }
        for (;;)
        {
          if (k == 0) {
            k = 1;
          }
          for (;;)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004876", "0X8004876", 0, 0, j + "", k + "", "" + this.jdField_a_of_type_JavaUtilArrayList.size(), "" + i + "");
            return;
            if (j == 3000)
            {
              j = 2;
              break;
            }
            if (j != 1) {
              break label825;
            }
            j = 3;
            break;
            if (k == 3000) {
              k = 2;
            } else if (k == 1) {
              k = 3;
            } else {
              k = 4;
            }
          }
          label825:
          j = 4;
        }
      }
      label835:
      continue;
      label838:
      k = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejh
 * JD-Core Version:    0.7.0.1
 */