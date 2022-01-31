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

public class aior
  implements Runnable
{
  public aior(TroopAioMsgNavigateBar paramTroopAioMsgNavigateBar) {}
  
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
    Object localObject1 = (TroopInfoManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      this.a.jdField_e_of_type_Int = ((TroopInfoManager)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    Object localObject2;
    long l1;
    long l2;
    int i;
    for (;;)
    {
      localObject2 = (TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localObject2 != null)
      {
        localObject2 = ((TroopManager)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject2 != null) && (((TroopInfo)localObject2).hasOrgs())) {
          this.a.jdField_e_of_type_Boolean = true;
        }
      }
      this.a.jdField_a_of_type_JavaUtilList = ((TroopInfoManager)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_e_of_type_Int);
      if (!this.a.c()) {
        break;
      }
      this.a.jdField_d_of_type_Long = ((TroopInfoManager)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (this.a.jdField_d_of_type_Long != -1L) {
        Collections.sort(this.a.jdField_a_of_type_JavaUtilList, new aios(this));
      }
      if ((this.a.jdField_a_of_type_JavaUtilList != null) && (!this.a.jdField_a_of_type_JavaUtilList.isEmpty())) {
        this.a.jdField_c_of_type_Long = ((Long)this.a.jdField_a_of_type_JavaUtilList.get(0)).longValue();
      }
      if (this.a.jdField_e_of_type_Boolean)
      {
        localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (localObject1 != null)
        {
          l1 = ((QQMessageFacade.Message)localObject1).shmsgseq;
          l2 = this.a.jdField_c_of_type_Long;
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "his_owner", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", l1 - l2 + "");
        }
      }
      if ((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null)) {
        break label655;
      }
      localObject1 = (ChatMessage)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
      if (localObject1 == null) {
        break label655;
      }
      i = this.a.jdField_a_of_type_JavaUtilList.size() - 1;
      while (i >= 0)
      {
        if (((ChatMessage)localObject1).shmsgseq <= ((Long)this.a.jdField_a_of_type_JavaUtilList.get(i)).longValue()) {
          this.a.jdField_a_of_type_JavaUtilList.remove(i);
        }
        i -= 1;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        this.a.jdField_e_of_type_Int = ((TroopInfoManager)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
      }
    }
    label655:
    Object localObject7;
    Object localObject4;
    Object localObject6;
    Object localObject5;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      this.a.jdField_c_of_type_Long = ((TroopInfoManager)localObject1).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = TroopAioMsgNavigateBar.jdField_a_of_type_Long;
      localObject7 = (MessageRecord)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
      if (localObject7 != null) {
        l1 = ((MessageRecord)localObject7).shmsgseq;
      }
      localObject4 = "";
      localObject2 = null;
      localObject6 = null;
      localObject5 = "";
      if (this.a.jdField_e_of_type_Int != 1) {
        break label1120;
      }
      if (this.a.jdField_b_of_type_Long < l1) {
        break label955;
      }
      i = 0;
    }
    for (;;)
    {
      label737:
      if (i != 0)
      {
        localObject1 = String.format(this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430166), new Object[] { Integer.valueOf(this.a.jdField_d_of_type_Int) });
        localObject2 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
      }
      for (bool1 = true;; bool1 = false)
      {
        Object localObject3 = localObject5;
        bool2 = bool1;
        if (this.a.c())
        {
          bool2 = bool1;
          if (this.a.jdField_a_of_type_JavaUtilList.isEmpty()) {
            bool2 = false;
          }
        }
        this.a.g = bool2;
        this.a.jdField_b_of_type_JavaLangString = ((String)localObject1);
        this.a.jdField_b_of_type_JavaLangObject = localObject2;
        this.a.jdField_c_of_type_JavaLangString = ((String)localObject3);
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(101);
        return;
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
          break;
        }
        this.a.jdField_c_of_type_Long = ((TroopInfoManager)localObject1).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
        break;
        label955:
        if (this.a.jdField_d_of_type_Int < 30)
        {
          localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          if (localObject1 == null) {
            break label4071;
          }
          long l3 = ((QQMessageFacade.Message)localObject1).shmsgseq;
          for (l2 = 0L;; l2 += 1L)
          {
            if (l2 >= this.a.jdField_d_of_type_Int) {
              break label4071;
            }
            localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l3);
            if ((localObject1 != null) && (((MessageRecord)localObject1).msgtype != -2058) && (((MessageRecord)localObject1).shmsgseq < l1))
            {
              i = 1;
              break;
            }
            l3 -= 1L;
          }
        }
        i = 1;
        break label737;
        label1120:
        if (this.a.jdField_e_of_type_Int == 21)
        {
          localObject3 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
          if ((localObject3 == null) || (((MessageRecord)localObject3).shmsgseq >= l1)) {
            break label4048;
          }
          localObject1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430172);
          localObject2 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
          localObject3 = ((MessageRecord)localObject3).senderuin;
          bool1 = true;
        }
        for (;;)
        {
          break;
          if (this.a.jdField_e_of_type_Int == 13)
          {
            localObject7 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
            localObject2 = localObject6;
            localObject1 = localObject4;
            bool1 = bool3;
            localObject3 = localObject5;
            if (localObject7 == null) {
              break;
            }
            localObject2 = localObject6;
            localObject1 = localObject4;
            bool1 = bool3;
            localObject3 = localObject5;
            if (((MessageRecord)localObject7).shmsgseq >= l1) {
              break;
            }
            localObject1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430173);
            localObject2 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
            localObject3 = ((MessageRecord)localObject7).senderuin;
            bool1 = true;
            break;
          }
          if (this.a.jdField_e_of_type_Int == 15)
          {
            localObject2 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
            localObject4 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
            if ((this.a.jdField_a_of_type_JavaUtilList != null) && (!this.a.jdField_a_of_type_JavaUtilList.isEmpty()))
            {
              localObject3 = this.a.jdField_a_of_type_AndroidContentContext.getResources();
              if (this.a.jdField_a_of_type_JavaUtilList.size() > 99)
              {
                localObject1 = "99+";
                label1541:
                localObject1 = ((Resources)localObject3).getString(2131435348, new Object[] { localObject1 });
                if (!this.a.jdField_e_of_type_Boolean) {
                  break label4045;
                }
                if (this.a.jdField_a_of_type_JavaUtilList.size() != 1) {
                  break label1794;
                }
                ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "focus", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              }
            }
          }
          label1684:
          label4045:
          for (;;)
          {
            label1625:
            if (MessageForQQWalletMsg.isRedPacketMsg((MessageRecord)localObject4))
            {
              localObject1 = (MessageForQQWalletMsg)localObject4;
              if ((((MessageForQQWalletMsg)localObject1).messageType == 7) || (((MessageForQQWalletMsg)localObject1).messageType == 8))
              {
                localObject1 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131437888);
                ((TroopAioAgent.Message)localObject2).jdField_b_of_type_Boolean = true;
              }
            }
            for (;;)
            {
              localObject3 = localObject5;
              if (localObject4 != null) {
                localObject3 = ((MessageRecord)localObject4).senderuin;
              }
              if (QLog.isColorLevel())
              {
                localObject5 = new StringBuilder().append("需要定位的第一条消息是否已经拉到本地：");
                if (localObject4 == null) {
                  break label1912;
                }
              }
              label1912:
              for (bool1 = true;; bool1 = false)
              {
                QLog.d("TroopAioMsgNavigateBar.troop.special_msg.special_attention", 2, bool1);
                bool1 = bool2;
                if (localObject7 != null)
                {
                  bool1 = bool2;
                  if (this.a.jdField_c_of_type_Long < ((MessageRecord)localObject7).shmsgseq) {
                    bool1 = true;
                  }
                }
                break;
                localObject1 = Integer.valueOf(this.a.jdField_a_of_type_JavaUtilList.size());
                break label1541;
                ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "msg_owner", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_JavaUtilList.size() + "", "", "");
                break label1625;
                localObject1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131435347);
                break label1625;
                localObject1 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131437889);
                ((TroopAioAgent.Message)localObject2).jdField_a_of_type_Boolean = true;
                break label1684;
              }
              if (this.a.jdField_e_of_type_Int == 6)
              {
                localObject7 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (localObject7 == null) {
                  break;
                }
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (((MessageRecord)localObject7).shmsgseq >= l1) {
                  break;
                }
                localObject1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430603);
                localObject2 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                localObject3 = ((MessageRecord)localObject7).senderuin;
                bool1 = true;
                break;
              }
              if (this.a.jdField_e_of_type_Int == 24)
              {
                localObject7 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (localObject7 == null) {
                  break;
                }
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (((MessageRecord)localObject7).shmsgseq >= l1) {
                  break;
                }
                localObject1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430177);
                localObject2 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                localObject3 = ((MessageRecord)localObject7).senderuin;
                bool1 = true;
                if (AnonymousChatHelper.a((MessageRecord)localObject7)) {}
                for (i = 2;; i = 1)
                {
                  ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_topmsgcue", i, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                  break;
                }
              }
              if (this.a.jdField_e_of_type_Int == 16)
              {
                localObject7 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (localObject7 == null) {
                  break;
                }
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (((MessageRecord)localObject7).shmsgseq >= l1) {
                  break;
                }
                localObject1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430182);
                localObject2 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                localObject3 = ((MessageRecord)localObject7).senderuin;
                bool1 = true;
                break;
              }
              if (this.a.jdField_e_of_type_Int == 19)
              {
                localObject7 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (localObject7 == null) {
                  break;
                }
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (((MessageRecord)localObject7).shmsgseq >= l1) {
                  break;
                }
                if ((StructMsgForGeneralShare)StructMsgFactory.a(((MessageRecord)localObject7).msgData) == null) {
                  if (QLog.isColorLevel()) {
                    QLog.d("TroopAioMsgNavigateBar", 2, "showNavigateBarIfNeeded() :calendarMsg getStructMsg is null");
                  }
                }
                for (localObject1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430766);; localObject1 = StructMsgForGeneralShare.remindBrief)
                {
                  localObject2 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                  localObject3 = ((MessageRecord)localObject7).senderuin;
                  bool1 = true;
                  this.a.jdField_a_of_type_JavaLangString = StructMsgForGeneralShare.eventType;
                  ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_calendar", "", "notice", "exp", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_JavaLangString, "", "");
                  break;
                }
              }
              if (this.a.jdField_e_of_type_Int == 20)
              {
                localObject7 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (localObject7 == null) {
                  break;
                }
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (((MessageRecord)localObject7).shmsgseq >= l1) {
                  break;
                }
                localObject1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430726);
                localObject2 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, ((MessageRecord)localObject7).shmsgseq, this.a.jdField_d_of_type_Int);
                localObject3 = ((MessageRecord)localObject7).senderuin;
                bool1 = true;
                MessageForReplyText.reportReplyMsg(null, "AIOchat", "Appear_topmsgcue_reply", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
                break;
              }
              if (this.a.jdField_e_of_type_Int == 3)
              {
                localObject7 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (localObject7 == null) {
                  break;
                }
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (((MessageRecord)localObject7).shmsgseq >= l1) {
                  break;
                }
                localObject1 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131430181);
                localObject2 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                localObject3 = ((MessageRecord)localObject7).senderuin;
                bool1 = true;
                break;
              }
              if (this.a.jdField_e_of_type_Int == 4)
              {
                localObject7 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (localObject7 == null) {
                  break;
                }
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (((MessageRecord)localObject7).shmsgseq >= l1) {
                  break;
                }
                localObject1 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131430180);
                localObject2 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                localObject3 = ((MessageRecord)localObject7).senderuin;
                bool1 = true;
                break;
              }
              if (this.a.jdField_e_of_type_Int == 5)
              {
                localObject7 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (localObject7 == null) {
                  break;
                }
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (((MessageRecord)localObject7).shmsgseq >= l1) {
                  break;
                }
                localObject1 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131430179);
                localObject2 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                localObject3 = "";
                bool1 = true;
                break;
              }
              if (this.a.jdField_e_of_type_Int == 17)
              {
                localObject7 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (localObject7 == null) {
                  break;
                }
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (((MessageRecord)localObject7).shmsgseq >= l1) {
                  break;
                }
                localObject1 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131438406);
                localObject2 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                localObject3 = ((MessageRecord)localObject7).senderuin;
                bool1 = true;
                break;
              }
              if (this.a.jdField_e_of_type_Int == 12)
              {
                localObject7 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (localObject7 == null) {
                  break;
                }
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (((MessageRecord)localObject7).shmsgseq >= l1) {
                  break;
                }
                localObject1 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131438949);
                localObject2 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                localObject3 = ((MessageRecord)localObject7).senderuin;
                bool1 = true;
                break;
              }
              if (this.a.jdField_e_of_type_Int == 18)
              {
                localObject7 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_c_of_type_Long);
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (localObject7 == null) {
                  break;
                }
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (((MessageRecord)localObject7).shmsgseq >= l1) {
                  break;
                }
                localObject2 = localObject6;
                localObject1 = localObject4;
                bool1 = bool3;
                localObject3 = localObject5;
                if (!(localObject7 instanceof MessageForArkApp)) {
                  break;
                }
                localObject1 = ArkTipsManager.a((MessageForArkApp)localObject7);
                localObject2 = TroopAioAgent.Message.a(this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Int);
                localObject3 = ((MessageRecord)localObject7).senderuin;
                bool1 = true;
                break;
              }
              localObject2 = localObject6;
              localObject1 = localObject4;
              bool1 = bool3;
              localObject3 = localObject5;
              if (this.a.jdField_e_of_type_Int != 22) {
                break;
              }
              localObject7 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
              HotChatCenterManager localHotChatCenterManager = (HotChatCenterManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(254);
              localObject2 = localObject6;
              localObject1 = localObject4;
              bool1 = bool3;
              localObject3 = localObject5;
              if (localHotChatCenterManager == null) {
                break;
              }
              localObject7 = localHotChatCenterManager.a((String)localObject7);
              localObject2 = localObject6;
              localObject1 = localObject4;
              bool1 = bool3;
              localObject3 = localObject5;
              if (localObject7 == null) {
                break;
              }
              localObject2 = localObject6;
              localObject1 = localObject4;
              bool1 = bool3;
              localObject3 = localObject5;
              if (((HotChatItemData)localObject7).mGameId <= 0) {
                break;
              }
              localObject2 = HotChatCenterFragment.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((HotChatItemData)localObject7).mHotChatCode, ((HotChatItemData)localObject7).mGameId);
              if (localObject2 != null)
              {
                localObject1 = ((AioPushData)localObject2).wording;
                bool1 = true;
                this.a.jdField_a_of_type_JavaLangObject = localObject2;
              }
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("TroopAioMsgNavigateBar", 2, "[showNavigateBarIfNeeded] for " + ((HotChatItemData)localObject7).mHotChatCode + " " + ((HotChatItemData)localObject7).mGameId);
                }
                localObject2 = localObject6;
                localObject3 = localObject5;
                break;
                bool1 = false;
                localObject1 = localObject4;
              }
            }
          }
          label1794:
          label4048:
          localObject3 = "";
          localObject1 = localObject4;
        }
        localObject2 = null;
        localObject1 = "";
      }
      label4071:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aior
 * JD-Core Version:    0.7.0.1
 */