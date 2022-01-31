import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.troop.data.TroopAioMsgNavigateBar;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

public class ajhy
  implements Runnable
{
  public ajhy(TroopAioMsgNavigateBar paramTroopAioMsgNavigateBar) {}
  
  public void run()
  {
    if ((!this.a.b()) || (!this.a.jdField_a_of_type_Boolean)) {
      return;
    }
    this.a.jdField_b_of_type_Boolean = true;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    this.a.jdField_a_of_type_JavaLangObject = null;
    ??? = (TroopInfoManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    Object localObject2;
    long l1;
    long l2;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      this.a.jdField_e_of_type_Int = ((TroopInfoManager)???).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject2 = (TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localObject2 != null)
      {
        localObject2 = ((TroopManager)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject2 != null) && (((TroopInfo)localObject2).hasOrgs())) {
          this.a.jdField_e_of_type_Boolean = true;
        }
      }
      this.a.jdField_a_of_type_JavaUtilList = ((TroopInfoManager)???).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_e_of_type_Int);
      if (!this.a.c()) {
        break label877;
      }
      this.a.jdField_d_of_type_Long = ((TroopInfoManager)???).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (this.a.jdField_d_of_type_Long != -1L) {
        Collections.sort(this.a.jdField_a_of_type_JavaUtilList, new ajhz(this));
      }
      if ((this.a.jdField_a_of_type_JavaUtilList != null) && (!this.a.jdField_a_of_type_JavaUtilList.isEmpty())) {
        this.a.jdField_c_of_type_Long = ((Long)this.a.jdField_a_of_type_JavaUtilList.get(0)).longValue();
      }
      if (this.a.jdField_e_of_type_Boolean)
      {
        ??? = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (??? != null)
        {
          l1 = ((QQMessageFacade.Message)???).shmsgseq;
          l2 = this.a.jdField_c_of_type_Long;
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "his_owner", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", l1 - l2 + "");
        }
      }
      if ((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null)) {
        break label634;
      }
      localObject2 = (ChatMessage)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
      if (localObject2 == null) {
        break label634;
      }
    }
    label981:
    label4071:
    label4074:
    for (;;)
    {
      int i;
      label634:
      Object localObject9;
      Object localObject6;
      Object localObject8;
      Object localObject7;
      Object localObject5;
      synchronized (this.a.jdField_a_of_type_JavaUtilList)
      {
        i = this.a.jdField_a_of_type_JavaUtilList.size() - 1;
        if (i >= 0)
        {
          if (((ChatMessage)localObject2).shmsgseq <= ((Long)this.a.jdField_a_of_type_JavaUtilList.get(i)).longValue()) {
            this.a.jdField_a_of_type_JavaUtilList.remove(i);
          }
          i -= 1;
          continue;
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
            break;
          }
          this.a.jdField_e_of_type_Int = ((TroopInfoManager)???).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
          break;
        }
        l1 = TroopAioMsgNavigateBar.jdField_a_of_type_Long;
        localObject9 = (MessageRecord)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
        if (localObject9 != null) {
          l1 = ((MessageRecord)localObject9).shmsgseq;
        }
        localObject6 = "";
        localObject2 = null;
        localObject8 = null;
        localObject7 = "";
        if (this.a.jdField_e_of_type_Int != 1) {
          break label1146;
        }
        if (this.a.jdField_b_of_type_Long < l1) {
          break label981;
        }
        i = 0;
        if (i == 0) {
          break label4085;
        }
        ??? = String.format(this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430186), new Object[] { Integer.valueOf(this.a.jdField_d_of_type_Int) });
        localObject2 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
        bool1 = true;
        localObject5 = localObject7;
        bool2 = bool1;
        if (this.a.c())
        {
          bool2 = bool1;
          if (this.a.jdField_a_of_type_JavaUtilList.isEmpty()) {
            bool2 = false;
          }
        }
        this.a.g = bool2;
        this.a.jdField_b_of_type_JavaLangString = ((String)???);
        this.a.jdField_b_of_type_JavaLangObject = localObject2;
        this.a.jdField_c_of_type_JavaLangString = ((String)localObject5);
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(101);
        return;
      }
      label877:
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        this.a.jdField_c_of_type_Long = ((TroopInfoManager)???).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      else if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
      {
        this.a.jdField_c_of_type_Long = ((TroopInfoManager)???).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
        continue;
        if (this.a.jdField_d_of_type_Int < 30)
        {
          ??? = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          if (??? != null)
          {
            long l3 = ((QQMessageFacade.Message)???).shmsgseq;
            for (l2 = 0L;; l2 += 1L)
            {
              if (l2 >= this.a.jdField_d_of_type_Int) {
                break label4097;
              }
              ??? = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l3);
              if ((??? != null) && (((MessageRecord)???).msgtype != -2058) && (((MessageRecord)???).shmsgseq < l1))
              {
                i = 1;
                break;
              }
              l3 -= 1L;
            }
          }
        }
        else
        {
          i = 1;
          continue;
          label1146:
          if (this.a.jdField_e_of_type_Int == 21)
          {
            localObject5 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
            if ((localObject5 == null) || (((MessageRecord)localObject5).shmsgseq >= l1)) {
              break label4074;
            }
            ??? = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430192);
            localObject4 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
            localObject5 = ((MessageRecord)localObject5).senderuin;
            bool1 = true;
          }
          for (;;)
          {
            break;
            if (this.a.jdField_e_of_type_Int == 13)
            {
              localObject9 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
              localObject4 = localObject8;
              ??? = localObject6;
              bool1 = bool3;
              localObject5 = localObject7;
              if (localObject9 == null) {
                break;
              }
              localObject4 = localObject8;
              ??? = localObject6;
              bool1 = bool3;
              localObject5 = localObject7;
              if (((MessageRecord)localObject9).shmsgseq >= l1) {
                break;
              }
              ??? = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430193);
              localObject4 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
              localObject5 = ((MessageRecord)localObject9).senderuin;
              bool1 = true;
              break;
            }
            if (this.a.jdField_e_of_type_Int == 15)
            {
              localObject4 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
              localObject6 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
              if ((this.a.jdField_a_of_type_JavaUtilList != null) && (!this.a.jdField_a_of_type_JavaUtilList.isEmpty()))
              {
                localObject5 = this.a.jdField_a_of_type_AndroidContentContext.getResources();
                if (this.a.jdField_a_of_type_JavaUtilList.size() > 99)
                {
                  ??? = "99+";
                  ??? = ((Resources)localObject5).getString(2131435381, new Object[] { ??? });
                  if (!this.a.jdField_e_of_type_Boolean) {
                    break label4071;
                  }
                  if (this.a.jdField_a_of_type_JavaUtilList.size() != 1) {
                    break label1820;
                  }
                  ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "focus", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                }
              }
            }
            for (;;)
            {
              label1651:
              if (MessageForQQWalletMsg.isRedPacketMsg((MessageRecord)localObject6))
              {
                ??? = (MessageForQQWalletMsg)localObject6;
                if ((((MessageForQQWalletMsg)???).messageType == 7) || (((MessageForQQWalletMsg)???).messageType == 8))
                {
                  ??? = this.a.jdField_a_of_type_AndroidContentContext.getString(2131437925);
                  ((TroopAioAgent.Message)localObject4).jdField_b_of_type_Boolean = true;
                }
              }
              for (;;)
              {
                localObject5 = localObject7;
                if (localObject6 != null) {
                  localObject5 = ((MessageRecord)localObject6).senderuin;
                }
                if (QLog.isColorLevel())
                {
                  localObject7 = new StringBuilder().append("需要定位的第一条消息是否已经拉到本地：");
                  if (localObject6 == null) {
                    break label1938;
                  }
                }
                for (bool1 = true;; bool1 = false)
                {
                  QLog.d("TroopAioMsgNavigateBar.troop.special_msg.special_attention", 2, bool1);
                  bool1 = bool2;
                  if (localObject9 != null)
                  {
                    bool1 = bool2;
                    if (this.a.jdField_c_of_type_Long < ((MessageRecord)localObject9).shmsgseq) {
                      bool1 = true;
                    }
                  }
                  break;
                  ??? = Integer.valueOf(this.a.jdField_a_of_type_JavaUtilList.size());
                  break label1567;
                  ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "msg_owner", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_JavaUtilList.size() + "", "", "");
                  break label1651;
                  ??? = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131435380);
                  break label1651;
                  ??? = this.a.jdField_a_of_type_AndroidContentContext.getString(2131437926);
                  ((TroopAioAgent.Message)localObject4).jdField_a_of_type_Boolean = true;
                  break label1710;
                }
                if (this.a.jdField_e_of_type_Int == 6)
                {
                  localObject9 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (localObject9 == null) {
                    break;
                  }
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (((MessageRecord)localObject9).shmsgseq >= l1) {
                    break;
                  }
                  ??? = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430623);
                  localObject4 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                  localObject5 = ((MessageRecord)localObject9).senderuin;
                  bool1 = true;
                  break;
                }
                if (this.a.jdField_e_of_type_Int == 24)
                {
                  localObject9 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (localObject9 == null) {
                    break;
                  }
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (((MessageRecord)localObject9).shmsgseq >= l1) {
                    break;
                  }
                  ??? = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430197);
                  localObject4 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                  localObject5 = ((MessageRecord)localObject9).senderuin;
                  bool1 = true;
                  if (AnonymousChatHelper.a((MessageRecord)localObject9)) {}
                  for (i = 2;; i = 1)
                  {
                    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_topmsgcue", i, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                    break;
                  }
                }
                if (this.a.jdField_e_of_type_Int == 16)
                {
                  localObject9 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (localObject9 == null) {
                    break;
                  }
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (((MessageRecord)localObject9).shmsgseq >= l1) {
                    break;
                  }
                  ??? = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430202);
                  localObject4 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                  localObject5 = ((MessageRecord)localObject9).senderuin;
                  bool1 = true;
                  break;
                }
                if (this.a.jdField_e_of_type_Int == 19)
                {
                  localObject9 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (localObject9 == null) {
                    break;
                  }
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (((MessageRecord)localObject9).shmsgseq >= l1) {
                    break;
                  }
                  if ((StructMsgForGeneralShare)StructMsgFactory.a(((MessageRecord)localObject9).msgData) == null) {
                    if (QLog.isColorLevel()) {
                      QLog.d("TroopAioMsgNavigateBar", 2, "showNavigateBarIfNeeded() :calendarMsg getStructMsg is null");
                    }
                  }
                  for (??? = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430786);; ??? = StructMsgForGeneralShare.remindBrief)
                  {
                    localObject4 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject9).senderuin;
                    bool1 = true;
                    this.a.jdField_a_of_type_JavaLangString = StructMsgForGeneralShare.eventType;
                    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_calendar", "", "notice", "exp", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_JavaLangString, "", "");
                    break;
                  }
                }
                if (this.a.jdField_e_of_type_Int == 20)
                {
                  localObject9 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (localObject9 == null) {
                    break;
                  }
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (((MessageRecord)localObject9).shmsgseq >= l1) {
                    break;
                  }
                  ??? = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430746);
                  localObject4 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, ((MessageRecord)localObject9).shmsgseq, this.a.jdField_d_of_type_Int);
                  localObject5 = ((MessageRecord)localObject9).senderuin;
                  bool1 = true;
                  MessageForReplyText.reportReplyMsg(null, "AIOchat", "Appear_topmsgcue_reply", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
                  break;
                }
                if (this.a.jdField_e_of_type_Int == 3)
                {
                  localObject9 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (localObject9 == null) {
                    break;
                  }
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (((MessageRecord)localObject9).shmsgseq >= l1) {
                    break;
                  }
                  ??? = this.a.jdField_a_of_type_AndroidContentContext.getString(2131430201);
                  localObject4 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                  localObject5 = ((MessageRecord)localObject9).senderuin;
                  bool1 = true;
                  break;
                }
                if (this.a.jdField_e_of_type_Int == 4)
                {
                  localObject9 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (localObject9 == null) {
                    break;
                  }
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (((MessageRecord)localObject9).shmsgseq >= l1) {
                    break;
                  }
                  ??? = this.a.jdField_a_of_type_AndroidContentContext.getString(2131430200);
                  localObject4 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                  localObject5 = ((MessageRecord)localObject9).senderuin;
                  bool1 = true;
                  break;
                }
                if (this.a.jdField_e_of_type_Int == 5)
                {
                  localObject9 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (localObject9 == null) {
                    break;
                  }
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (((MessageRecord)localObject9).shmsgseq >= l1) {
                    break;
                  }
                  ??? = this.a.jdField_a_of_type_AndroidContentContext.getString(2131430199);
                  localObject4 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                  localObject5 = "";
                  bool1 = true;
                  break;
                }
                if (this.a.jdField_e_of_type_Int == 17)
                {
                  localObject9 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (localObject9 == null) {
                    break;
                  }
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (((MessageRecord)localObject9).shmsgseq >= l1) {
                    break;
                  }
                  ??? = this.a.jdField_a_of_type_AndroidContentContext.getString(2131438444);
                  localObject4 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                  localObject5 = ((MessageRecord)localObject9).senderuin;
                  bool1 = true;
                  break;
                }
                if (this.a.jdField_e_of_type_Int == 12)
                {
                  localObject9 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (localObject9 == null) {
                    break;
                  }
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (((MessageRecord)localObject9).shmsgseq >= l1) {
                    break;
                  }
                  ??? = this.a.jdField_a_of_type_AndroidContentContext.getString(2131439001);
                  localObject4 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                  localObject5 = ((MessageRecord)localObject9).senderuin;
                  bool1 = true;
                  break;
                }
                if (this.a.jdField_e_of_type_Int == 18)
                {
                  localObject9 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (localObject9 == null) {
                    break;
                  }
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (((MessageRecord)localObject9).shmsgseq >= l1) {
                    break;
                  }
                  localObject4 = localObject8;
                  ??? = localObject6;
                  bool1 = bool3;
                  localObject5 = localObject7;
                  if (!(localObject9 instanceof MessageForArkApp)) {
                    break;
                  }
                  ??? = ArkTipsManager.a((MessageForArkApp)localObject9);
                  localObject4 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                  localObject5 = ((MessageRecord)localObject9).senderuin;
                  bool1 = true;
                  break;
                }
                localObject4 = localObject8;
                ??? = localObject6;
                bool1 = bool3;
                localObject5 = localObject7;
                if (this.a.jdField_e_of_type_Int != 22) {
                  break;
                }
                localObject9 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
                HotChatCenterManager localHotChatCenterManager = (HotChatCenterManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(254);
                localObject4 = localObject8;
                ??? = localObject6;
                bool1 = bool3;
                localObject5 = localObject7;
                if (localHotChatCenterManager == null) {
                  break;
                }
                localObject9 = localHotChatCenterManager.a((String)localObject9);
                localObject4 = localObject8;
                ??? = localObject6;
                bool1 = bool3;
                localObject5 = localObject7;
                if (localObject9 == null) {
                  break;
                }
                localObject4 = localObject8;
                ??? = localObject6;
                bool1 = bool3;
                localObject5 = localObject7;
                if (((HotChatItemData)localObject9).mGameId <= 0) {
                  break;
                }
                localObject4 = HotChatCenterFragment.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((HotChatItemData)localObject9).mHotChatCode, ((HotChatItemData)localObject9).mGameId);
                if (localObject4 != null)
                {
                  ??? = ((AioPushData)localObject4).wording;
                  bool1 = true;
                  this.a.jdField_a_of_type_JavaLangObject = localObject4;
                }
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("TroopAioMsgNavigateBar", 2, "[showNavigateBarIfNeeded] for " + ((HotChatItemData)localObject9).mHotChatCode + " " + ((HotChatItemData)localObject9).mGameId);
                  }
                  localObject4 = localObject8;
                  localObject5 = localObject7;
                  break;
                  bool1 = false;
                  ??? = localObject6;
                }
              }
            }
            localObject5 = "";
            ??? = localObject6;
          }
          label4085:
          Object localObject4 = null;
          ??? = "";
          bool1 = false;
          continue;
        }
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhy
 * JD-Core Version:    0.7.0.1
 */