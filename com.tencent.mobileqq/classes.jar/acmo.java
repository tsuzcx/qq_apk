import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tencent.mobileim.structmsg.structmsg.StructMsg;

class acmo
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private acmw jdField_a_of_type_Acmw;
  private aoxz jdField_a_of_type_Aoxz;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private String jdField_a_of_type_JavaLangString;
  private Map<String, RecentUser> jdField_a_of_type_JavaUtilMap;
  
  public acmo(MessageRecord paramMessageRecord, EntityManager paramEntityManager, Map<String, RecentUser> paramMap, aoxz paramaoxz, acmw paramacmw, String paramString, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramEntityManager;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramMap;
    this.jdField_a_of_type_JavaUtilMap = paramaoxz;
    this.jdField_a_of_type_Aoxz = paramacmw;
    this.jdField_a_of_type_Acmw = paramString;
    this.jdField_a_of_type_JavaLangString = paramInt;
    this.jdField_a_of_type_Int = paramLong;
    Object localObject;
    this.jdField_a_of_type_Long = localObject;
  }
  
  private void a()
  {
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_Acml.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop);
    aizi localaizi = (aizi)this.jdField_a_of_type_Acml.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER);
    localMessage.istroop = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
    localaizi.a(false);
    int j = localaizi.d();
    if (j > 0) {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSendFromLocal()) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time >= localMessage.time)) {
        break label185;
      }
    }
    label185:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        MessageRecord.copyMessageRecordBaseField(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        localMessage.msgData = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgData;
        this.jdField_a_of_type_Acml.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setIncomingMsg(localMessage);
      }
      try
      {
        this.jdField_a_of_type_Acml.a(localMessage);
        this.jdField_a_of_type_Acml.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getIncomingMsg().unReadNum = j;
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "addMessageRecord ERROR", localThrowable);
          }
        }
      }
      this.jdField_a_of_type_Acml.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setIncomingMsg(null);
      return;
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString1, String paramString2)
  {
    MessageRecord localMessageRecord = bcsa.a(paramMessageRecord.msgtype);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
    localMessageRecord.senderuin = paramString2;
    localMessageRecord.frienduin = paramString1;
    if (TextUtils.equals(AppConstants.LBS_HELLO_UIN, paramString1)) {
      paramMessageRecord.saveExtInfoToExtStr("msg_in_box", "msg_in_box");
    }
    if (acnh.a(paramMessageRecord.istroop) == 1032) {}
    for (localMessageRecord.istroop = 1032;; localMessageRecord.istroop = paramMessageRecord.istroop)
    {
      if (!acnh.h(paramMessageRecord.msgtype))
      {
        this.jdField_a_of_type_Acml.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramMessageRecord.istroop).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.senderuin, localMessageRecord.selfuin, localMessageRecord.getExtraKey());
        this.jdField_a_of_type_Acml.a(localMessageRecord, null, false, true, 1);
      }
      return;
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (((this.jdField_a_of_type_Acmw.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin)) || (this.jdField_a_of_type_JavaUtilMap.containsKey(acnh.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop)))) && (!alik.a(this.jdField_a_of_type_Acml.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin))) {
      this.jdField_a_of_type_Aoxz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramString, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForSystemMsg))
    {
      localObject = ((MessageForSystemMsg)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).getSystemMsg();
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time = ((structmsg.StructMsg)localObject).msg_time.get();
      }
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
    }
    Object localObject = this.jdField_a_of_type_Acml.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop);
    int k = bdzy.a().a(this.jdField_a_of_type_Acml.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (k > 0)
    {
      int j = 0;
      int i = j;
      if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSendFromLocal())
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time < ((QQMessageFacade.Message)localObject).time) {
          i = 1;
        }
      }
      if (i == 0)
      {
        MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        ((QQMessageFacade.Message)localObject).msgData = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgData;
        this.jdField_a_of_type_Acml.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setIncomingMsg((QQMessageFacade.Message)localObject);
      }
      try
      {
        this.jdField_a_of_type_Acml.a((QQMessageFacade.Message)localObject);
        this.jdField_a_of_type_Acml.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getIncomingMsg().unReadNum = k;
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "addMessageRecord ERROR", localThrowable);
          }
        }
      }
    }
    this.jdField_a_of_type_Acml.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setIncomingMsg(null);
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Acmw.a(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaUtilMap.containsKey(acnh.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop)))) {
      this.jdField_a_of_type_Aoxz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
    }
    int j = 0;
    int i = 0;
    boolean bool = aryo.a();
    if (acnh.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.LBS_SAY_HELLO_LIST_UIN, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
      if (!bool) {
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.LBS_HELLO_UIN, AppConstants.LBS_SAY_HELLO_LIST_UIN);
      }
      a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.NEARBY_LBS_HELLO_UIN, AppConstants.LBS_SAY_HELLO_LIST_UIN);
      j = i;
      if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isread)
      {
        this.jdField_a_of_type_Acmw.a(1001, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
        j = i;
      }
      if (j != 0) {
        break label335;
      }
    }
    label335:
    for (this.jdField_a_of_type_JavaLangString = AppConstants.NEARBY_LBS_HELLO_UIN;; this.jdField_a_of_type_JavaLangString = AppConstants.LBS_HELLO_UIN)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
      return;
      if (this.jdField_a_of_type_Acmw.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, 1001, AppConstants.LBS_SAY_HELLO_LIST_UIN)) {
        this.jdField_a_of_type_Acml.a(AppConstants.LBS_SAY_HELLO_LIST_UIN, 1001, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin, this.jdField_a_of_type_Acml.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      i = j;
      if (aryo.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
      {
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.LBS_HELLO_UIN, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
        i = 1;
      }
      j = i;
      if (aryo.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin)) {
        break;
      }
      j = i;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop != 1001) {
        break;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.NEARBY_LBS_HELLO_UIN, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
      j = i;
      break;
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Acmw.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin)) || (this.jdField_a_of_type_JavaUtilMap.containsKey(acnh.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop)))) {
      this.jdField_a_of_type_Aoxz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
    }
    int j = 0;
    int i = 0;
    boolean bool = aryo.a();
    if (acnh.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.LBS_SAY_HELLO_LIST_UIN, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
      if (!bool) {
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.LBS_HELLO_UIN, AppConstants.LBS_SAY_HELLO_LIST_UIN);
      }
      a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.NEARBY_LBS_HELLO_UIN, AppConstants.LBS_SAY_HELLO_LIST_UIN);
      j = i;
      if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isread)
      {
        this.jdField_a_of_type_Acmw.a(1001, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
        j = i;
      }
      if (j != 0) {
        break label330;
      }
    }
    label330:
    for (this.jdField_a_of_type_JavaLangString = AppConstants.NEARBY_LBS_HELLO_UIN;; this.jdField_a_of_type_JavaLangString = AppConstants.LBS_HELLO_UIN)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      return;
      if (this.jdField_a_of_type_Acmw.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, 1001, AppConstants.LBS_SAY_HELLO_LIST_UIN)) {
        this.jdField_a_of_type_Acml.a(AppConstants.LBS_SAY_HELLO_LIST_UIN, 1001, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin, this.jdField_a_of_type_Acml.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      i = j;
      if (aryo.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
      {
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.LBS_HELLO_UIN, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
        i = 1;
      }
      j = i;
      if (aryo.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin)) {
        break;
      }
      j = i;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop != 1001) {
        break;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.NEARBY_LBS_HELLO_UIN, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
      j = i;
      break;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public acmo a()
  {
    if (acnh.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop) == 1009)
    {
      if ((this.jdField_a_of_type_Acmw.a(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaUtilMap.containsKey(acnh.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop)))) {
        this.jdField_a_of_type_Aoxz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
      }
      a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.SAME_STATE_BOX_UIN, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
      this.jdField_a_of_type_JavaLangString = AppConstants.SAME_STATE_BOX_UIN;
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
    }
    do
    {
      do
      {
        return this;
        if (String.valueOf(AppConstants.LBS_HELLO_UIN).equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin))
        {
          d();
          return this;
        }
        if (((acnh.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop) == 1001) && (acnh.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype))) || (acnh.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop) == 1010))
        {
          c();
          return this;
        }
        if (!String.valueOf(AppConstants.SYSTEM_MSG_UIN).equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin)) {
          break;
        }
      } while (!(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForSystemMsg));
      ??? = ((MessageForSystemMsg)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).getSystemMsg();
      if (??? != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time = ((structmsg.StructMsg)???).msg_time.get();
      }
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
      return this;
      if (String.valueOf(AppConstants.TROOP_SYSTEM_MSG_UIN).equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin))
      {
        b();
        return this;
      }
      if (AppConstants.TROOP_SUSPICIOUS_MSG_UIN.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin))
      {
        ajhg.a(this.jdField_a_of_type_Acml, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Acml.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade, this.jdField_a_of_type_Acml.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
        return this;
      }
      if (AppConstants.VOTE_MSG_UIN.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin))
      {
        synchronized (this.jdField_a_of_type_Acml)
        {
          Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(MessageRecord.class, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getTableName(), false, null, null, null, null, null, null);
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localMessageRecord);
            }
          }
        }
        return this;
      }
      if ((String.valueOf(AppConstants.MAYKNOW_RECOMMEND_UIN).equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin)) || (AppConstants.FRIEND_ANNIVER_UIN.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin)))
      {
        a();
        return this;
      }
      if (acnh.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop) == 1032)
      {
        if (aqvh.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
          a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.CONFESS_UIN, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
        }
        this.jdField_a_of_type_JavaLangString = AppConstants.CONFESS_UIN;
        this.jdField_a_of_type_Int = 1032;
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
        return this;
      }
      if (acnh.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop) == 1044)
      {
        a(AppConstants.MATCH_CHAT_UIN, 1044);
        return this;
      }
    } while (acnh.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop) != 10008);
    a(AppConstants.QCIRCLE_CHAT_UIN, 10008);
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acmo
 * JD-Core Version:    0.7.0.1
 */