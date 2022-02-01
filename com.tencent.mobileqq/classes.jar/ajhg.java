import android.view.View;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.mobileim.structmsg.structmsg.RspNextSystemMsg;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgNew;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class ajhg
{
  public static void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2130839460);
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839458);
      return;
    }
    paramView.setBackgroundResource(2130839455);
  }
  
  public static void a(aooy paramaooy, QQAppInterface paramQQAppInterface, structmsg.RspNextSystemMsg paramRspNextSystemMsg, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramRspNextSystemMsg == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramRspNextSystemMsg.msgs.get();
    int j = ((List)localObject).size();
    if (QLog.isColorLevel()) {
      QLog.e("Q.systemmsg.", 2, "<---sendGetNextGroupSystemMsg Resp : decode pb size = " + j);
    }
    HashSet localHashSet = new HashSet();
    int i = 0;
    if (i < j)
    {
      structmsg.StructMsg localStructMsg = (structmsg.StructMsg)((structmsg.StructMsg)((List)localObject).get(i)).get();
      if ((localStructMsg != null) && (localStructMsg.msg_seq.has()) && (localHashSet.contains(Long.valueOf(localStructMsg.msg_seq.get())))) {}
      for (;;)
      {
        i += 1;
        break;
        MessageRecord localMessageRecord = bcsa.a(-2018);
        localMessageRecord.msgtype = -2018;
        localMessageRecord.selfuin = paramString;
        localMessageRecord.frienduin = AppConstants.TROOP_SUSPICIOUS_MSG_UIN;
        localMessageRecord.senderuin = (((structmsg.StructMsg)((List)localObject).get(i)).req_uin.get() + "");
        localMessageRecord.istroop = 0;
        MessageForSystemMsg localMessageForSystemMsg = (MessageForSystemMsg)localMessageRecord;
        localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)((List)localObject).get(i)).get());
        localMessageRecord.msgData = localMessageForSystemMsg.structMsg.toByteArray();
        localArrayList.add(localMessageForSystemMsg);
        if ((localStructMsg != null) && (localStructMsg.msg_seq.has())) {
          localHashSet.add(Long.valueOf(localStructMsg.msg_seq.get()));
        }
      }
    }
    localObject = (awzf)paramQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER);
    boolean bool;
    if (localArrayList.size() > 0)
    {
      if ((localArrayList.size() < 100) && (localObject != null)) {
        ((awzf)localObject).b(true);
      }
      long l2 = paramRspNextSystemMsg.following_group_seq.get();
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = paramQQAppInterface.getMsgCache().e("following_group_suspicious_seq");
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.systemmsg.", 2, "<---sendGetNextGroupSystemMsg : decode pb following_group_seq" + l1);
      }
      paramQQAppInterface.getMsgCache().e("following_group_suspicious_seq", l1);
      paramRspNextSystemMsg = paramQQAppInterface.getMessageFacade();
      paramString = String.valueOf(paramString);
      if ((anyv.a(localArrayList)) && (paramQQAppInterface.isBackgroundStop))
      {
        bool = true;
        paramRspNextSystemMsg.addMessage(localArrayList, paramString, bool);
      }
    }
    for (;;)
    {
      paramaooy.a(4019, true, localArrayList);
      return;
      bool = false;
      break;
      if (localObject != null) {
        ((awzf)localObject).b(true);
      }
    }
  }
  
  public static void a(aooy paramaooy, QQAppInterface paramQQAppInterface, structmsg.RspSystemMsgNew paramRspSystemMsgNew, List<structmsg.StructMsg> paramList, int paramInt, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramList == null) || (paramRspSystemMsgNew == null)) {
      break label12;
    }
    label12:
    while (paramList.size() == 0) {
      return;
    }
    paramQQAppInterface.getMsgCache().e("last_group_suspicious_seq", paramRspSystemMsgNew.latest_group_seq.get());
    paramQQAppInterface.getMsgCache().e("following_group_suspicious_seq", paramRspSystemMsgNew.following_group_seq.get());
    bdzy.a().b(paramQQAppInterface, paramInt);
    paramRspSystemMsgNew = new ArrayList();
    int i = paramList.size();
    Object localObject = (awzf)paramQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER);
    if (localObject != null) {
      ((awzf)localObject).b(false);
    }
    Collections.sort(paramList, new ajhh());
    paramInt = 0;
    if (paramInt < i)
    {
      localObject = bcsa.a(-2018);
      ((MessageRecord)localObject).msgtype = -2018;
      ((MessageRecord)localObject).selfuin = paramString;
      ((MessageRecord)localObject).frienduin = AppConstants.TROOP_SUSPICIOUS_MSG_UIN;
      structmsg.StructMsg localStructMsg = (structmsg.StructMsg)paramList.get(paramInt);
      int j = localStructMsg.msg.group_msg_type.get();
      int k = TroopUtils.getMsgSenderType(j);
      if (k == 1) {
        ((MessageRecord)localObject).senderuin = (localStructMsg.msg.action_uin.get() + "");
      }
      for (;;)
      {
        ((MessageRecord)localObject).istroop = 0;
        MessageForSystemMsg localMessageForSystemMsg = (MessageForSystemMsg)localObject;
        localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)localStructMsg.get());
        localMessageForSystemMsg.shmsgseq = localMessageForSystemMsg.structMsg.msg_seq.get();
        k = localMessageForSystemMsg.structMsg.msg_type.get();
        int m = localMessageForSystemMsg.structMsg.msg.sub_type.get();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" type:").append(k);
          localStringBuilder.append(" groupMsgType:").append(j);
          localStringBuilder.append(" subType:").append(m);
          localStringBuilder.append(" troopUin:").append(localStructMsg.msg.group_code.get());
          localStringBuilder.append(" msgTime:").append(localStructMsg.msg_time.get());
          QLog.d("TroopSuspiciousHelper", 2, "processGroupSystemMsg-->" + localStringBuilder.toString());
        }
        ((MessageRecord)localObject).msgData = localMessageForSystemMsg.structMsg.toByteArray();
        paramRspSystemMsgNew.add(localMessageForSystemMsg);
        paramInt += 1;
        break;
        if (k == 2) {
          ((MessageRecord)localObject).senderuin = (localStructMsg.req_uin.get() + "");
        }
      }
    }
    paramQQAppInterface.getMessageFacade().clearHistory(AppConstants.TROOP_SUSPICIOUS_MSG_UIN, 0);
    if (paramRspSystemMsgNew.size() > 0)
    {
      paramList = paramQQAppInterface.getMessageFacade();
      paramString = String.valueOf(paramString);
      if ((!anyv.a(paramRspSystemMsgNew)) || (!paramQQAppInterface.isBackgroundStop)) {
        break label569;
      }
    }
    label569:
    for (boolean bool = true;; bool = false)
    {
      paramList.addMessage(paramRspSystemMsgNew, paramString, bool);
      if (paramaooy == null) {
        break;
      }
      paramaooy.a(4019, true, paramRspSystemMsgNew);
      return;
    }
  }
  
  public static void a(BaseMessageManager paramBaseMessageManager, MessageRecord paramMessageRecord, QQMessageFacade paramQQMessageFacade, QQAppInterface paramQQAppInterface)
  {
    if ((paramBaseMessageManager == null) || (paramMessageRecord == null) || (paramQQMessageFacade == null) || (paramQQAppInterface == null)) {}
    Object localObject;
    int k;
    int i;
    do
    {
      return;
      if ((paramMessageRecord instanceof MessageForSystemMsg))
      {
        localObject = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
        if (localObject != null) {
          paramMessageRecord.time = ((structmsg.StructMsg)localObject).msg_time.get();
        }
      }
      localObject = paramQQMessageFacade.getLastMessage(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      k = bdzy.a().b(paramQQAppInterface);
      if (k <= 0) {
        break;
      }
      int j = 0;
      i = j;
      if (!paramMessageRecord.isSendFromLocal())
      {
        i = j;
        if (paramMessageRecord.time < ((QQMessageFacade.Message)localObject).time) {
          i = 1;
        }
      }
    } while (i != 0);
    MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject, paramMessageRecord);
    ((QQMessageFacade.Message)localObject).msgData = paramMessageRecord.msgData;
    paramQQMessageFacade.setIncomingMsg((QQMessageFacade.Message)localObject);
    try
    {
      paramBaseMessageManager.a((QQMessageFacade.Message)localObject);
      paramQQMessageFacade.getIncomingMsg().unReadNum = k;
      return;
    }
    catch (Throwable paramBaseMessageManager)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopSuspiciousHelper", 2, "add GroupSuspiciousMsg ERROR", paramBaseMessageManager);
        }
      }
    }
    paramQQMessageFacade.setIncomingMsg(null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface.getMsgHandler().a().a(3, 3, true);
  }
  
  public static void a(List<MessageRecord> paramList, QQAppInterface paramQQAppInterface)
  {
    if (paramList.size() >= 40)
    {
      paramList = (MessageRecord)paramList.get(39);
      if ((paramList instanceof MessageForSystemMsg))
      {
        paramList = ((MessageForSystemMsg)paramList).getSystemMsg();
        if ((paramList != null) && (paramList.msg_seq.has()))
        {
          long l = paramList.msg_seq.get();
          if (l > 0L) {
            paramQQAppInterface.getMsgCache().e("following_group_suspicious_seq", l);
          }
        }
      }
    }
  }
  
  public static void a(structmsg.StructMsg paramStructMsg)
  {
    if (paramStructMsg == null) {
      break label4;
    }
    for (;;)
    {
      label4:
      return;
      if ((paramStructMsg.msg.has()) && (paramStructMsg.msg.actions.has()))
      {
        paramStructMsg = paramStructMsg.msg.actions.get();
        if (paramStructMsg == null) {
          break;
        }
        int i = 0;
        while (i < paramStructMsg.size())
        {
          ((structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)paramStructMsg.get(i)).action_info.get()).uint32_req_msg_type.set(2);
          i += 1;
        }
      }
    }
  }
  
  public static void a(structmsg.StructMsg paramStructMsg, String paramString)
  {
    if (paramStructMsg == null) {
      return;
    }
    String str1 = paramStructMsg.msg.group_code.get() + "";
    String str2 = paramStructMsg.msg.group_msg_type.get() + "";
    if (paramStructMsg.msg.bytes_warning_tips.get() != null) {}
    for (paramStructMsg = paramStructMsg.msg.bytes_warning_tips.get().toStringUtf8();; paramStructMsg = "")
    {
      bhbu.a("Grp_contacts_news", "notice", paramString, 0, 0, new String[] { str1, str2, paramStructMsg });
      return;
    }
  }
  
  public static boolean a()
  {
    boolean bool = arpa.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("TroopSuspiciousHelper", 2, "isSuspiciousSwitchOpen is :" + bool);
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    List localList = paramQQAppInterface.getMessageFacade().getMsgList(AppConstants.TROOP_SUSPICIOUS_MSG_UIN, 0);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("hasSuspiciousMsg-->mDataList:");
      if (localList != null) {
        break label75;
      }
    }
    label75:
    for (paramQQAppInterface = "";; paramQQAppInterface = Integer.valueOf(localList.size()))
    {
      QLog.d("TroopSuspiciousHelper", 2, paramQQAppInterface);
      if ((localList == null) || (localList.size() <= 0)) {
        break;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhg
 * JD-Core Version:    0.7.0.1
 */