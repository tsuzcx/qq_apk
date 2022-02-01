import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
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

class abwh
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private abwp jdField_a_of_type_Abwp;
  private anuz jdField_a_of_type_Anuz;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private String jdField_a_of_type_JavaLangString;
  private Map<String, RecentUser> jdField_a_of_type_JavaUtilMap;
  
  public abwh(MessageRecord paramMessageRecord, EntityManager paramEntityManager, Map<String, RecentUser> paramMap, anuz paramanuz, abwp paramabwp, String paramString, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramEntityManager;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramMap;
    this.jdField_a_of_type_JavaUtilMap = paramanuz;
    this.jdField_a_of_type_Anuz = paramabwp;
    this.jdField_a_of_type_Abwp = paramString;
    this.jdField_a_of_type_JavaLangString = paramInt;
    this.jdField_a_of_type_Int = paramLong;
    Object localObject;
    this.jdField_a_of_type_Long = localObject;
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString1, String paramString2)
  {
    MessageRecord localMessageRecord = bbli.a(paramMessageRecord.msgtype);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
    localMessageRecord.senderuin = paramString2;
    localMessageRecord.frienduin = paramString1;
    if (TextUtils.equals(AppConstants.LBS_HELLO_UIN, paramString1)) {
      paramMessageRecord.saveExtInfoToExtStr("msg_in_box", "msg_in_box");
    }
    if (abwz.a(paramMessageRecord.istroop) == 1032) {}
    for (localMessageRecord.istroop = 1032;; localMessageRecord.istroop = paramMessageRecord.istroop)
    {
      if (!abwz.h(paramMessageRecord.msgtype))
      {
        this.jdField_a_of_type_Abwe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramMessageRecord.istroop).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.senderuin, localMessageRecord.selfuin, localMessageRecord.getExtraKey());
        this.jdField_a_of_type_Abwe.a(localMessageRecord, null, false, true, 1);
      }
      return;
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
  
  public abwh a()
  {
    int i = 1;
    int k = 0;
    int j = 0;
    if (abwz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop) == 1009)
    {
      if ((this.jdField_a_of_type_Abwp.a(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaUtilMap.containsKey(abwz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop)))) {
        this.jdField_a_of_type_Anuz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
      }
      a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.SAME_STATE_BOX_UIN, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
      this.jdField_a_of_type_JavaLangString = AppConstants.SAME_STATE_BOX_UIN;
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
      return this;
    }
    boolean bool;
    if (String.valueOf(AppConstants.LBS_HELLO_UIN).equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin))
    {
      if ((this.jdField_a_of_type_Abwp.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin)) || (this.jdField_a_of_type_JavaUtilMap.containsKey(abwz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop)))) {
        this.jdField_a_of_type_Anuz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
      }
      bool = aquz.a();
      if (abwz.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
      {
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.LBS_SAY_HELLO_LIST_UIN, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
        if (!bool) {
          a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.LBS_HELLO_UIN, AppConstants.LBS_SAY_HELLO_LIST_UIN);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.NEARBY_LBS_HELLO_UIN, AppConstants.LBS_SAY_HELLO_LIST_UIN);
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isread) {
          break label1964;
        }
        this.jdField_a_of_type_Abwp.a(1001, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
        i = 0;
      }
    }
    for (;;)
    {
      label302:
      if (i == 0)
      {
        this.jdField_a_of_type_JavaLangString = AppConstants.NEARBY_LBS_HELLO_UIN;
        label313:
        this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
        return this;
        if (this.jdField_a_of_type_Abwp.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, 1001, AppConstants.LBS_SAY_HELLO_LIST_UIN)) {
          this.jdField_a_of_type_Abwe.a(AppConstants.LBS_SAY_HELLO_LIST_UIN, 1001, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin, this.jdField_a_of_type_Abwe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        if (!aquz.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
          break label1959;
        }
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.LBS_HELLO_UIN, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
      }
      label1949:
      label1954:
      label1959:
      for (j = 1;; j = 0)
      {
        i = j;
        if (aquz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin)) {
          break label302;
        }
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop != 1001) {
          break label302;
        }
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.NEARBY_LBS_HELLO_UIN, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
        i = j;
        break label302;
        this.jdField_a_of_type_JavaLangString = AppConstants.LBS_HELLO_UIN;
        break label313;
        if (((abwz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop) == 1001) && (abwz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype))) || (abwz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop) == 1010))
        {
          if ((this.jdField_a_of_type_Abwp.a(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaUtilMap.containsKey(abwz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop)))) {
            this.jdField_a_of_type_Anuz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
          }
          bool = aquz.a();
          if (abwz.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
          {
            a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.LBS_SAY_HELLO_LIST_UIN, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
            if (!bool) {
              a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.LBS_HELLO_UIN, AppConstants.LBS_SAY_HELLO_LIST_UIN);
            }
            a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.NEARBY_LBS_HELLO_UIN, AppConstants.LBS_SAY_HELLO_LIST_UIN);
            if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isread) {
              break label1954;
            }
            this.jdField_a_of_type_Abwp.a(1001, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
            i = 0;
          }
        }
        for (;;)
        {
          label686:
          if (i == 0)
          {
            this.jdField_a_of_type_JavaLangString = AppConstants.NEARBY_LBS_HELLO_UIN;
            label697:
            this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
            this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
            return this;
            if (this.jdField_a_of_type_Abwp.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, 1001, AppConstants.LBS_SAY_HELLO_LIST_UIN)) {
              this.jdField_a_of_type_Abwe.a(AppConstants.LBS_SAY_HELLO_LIST_UIN, 1001, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin, this.jdField_a_of_type_Abwe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            }
            if (!aquz.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
              break label1949;
            }
            a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.LBS_HELLO_UIN, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
          }
          for (j = i;; j = 0)
          {
            i = j;
            if (aquz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin)) {
              break label686;
            }
            i = j;
            if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop != 1001) {
              break label686;
            }
            a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.NEARBY_LBS_HELLO_UIN, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
            i = j;
            break label686;
            this.jdField_a_of_type_JavaLangString = AppConstants.LBS_HELLO_UIN;
            break label697;
            Object localObject1;
            if (String.valueOf(AppConstants.SYSTEM_MSG_UIN).equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin))
            {
              if (!(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForSystemMsg)) {
                break;
              }
              localObject1 = ((MessageForSystemMsg)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).getSystemMsg();
              if (localObject1 != null) {
                this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time = ((structmsg.StructMsg)localObject1).msg_time.get();
              }
              this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
              return this;
            }
            if (String.valueOf(AppConstants.TROOP_SYSTEM_MSG_UIN).equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin))
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForSystemMsg))
              {
                localObject1 = ((MessageForSystemMsg)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).getSystemMsg();
                if (localObject1 != null) {
                  this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time = ((structmsg.StructMsg)localObject1).msg_time.get();
                }
                this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
              }
              localObject1 = this.jdField_a_of_type_Abwe.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop);
              k = bcsz.a().a(this.jdField_a_of_type_Abwe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              if (k > 0)
              {
                i = j;
                if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSendFromLocal())
                {
                  i = j;
                  if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time < ((QQMessageFacade.Message)localObject1).time) {
                    i = 1;
                  }
                }
                if (i != 0) {
                  break;
                }
                MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
                ((QQMessageFacade.Message)localObject1).msgData = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgData;
                this.jdField_a_of_type_Abwe.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setIncomingMsg((QQMessageFacade.Message)localObject1);
                try
                {
                  this.jdField_a_of_type_Abwe.a((QQMessageFacade.Message)localObject1);
                  this.jdField_a_of_type_Abwe.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getIncomingMsg().unReadNum = k;
                  return this;
                }
                catch (Throwable localThrowable1)
                {
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.BaseMessageManager", 2, "addMessageRecord ERROR", localThrowable1);
                    }
                  }
                }
              }
              this.jdField_a_of_type_Abwe.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setIncomingMsg(null);
              return this;
            }
            if (AppConstants.TROOP_SUSPICIOUS_MSG_UIN.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin))
            {
              aimg.a(this.jdField_a_of_type_Abwe, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Abwe.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade, this.jdField_a_of_type_Abwe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
              return this;
            }
            if (AppConstants.VOTE_MSG_UIN.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin))
            {
              synchronized (this.jdField_a_of_type_Abwe)
              {
                Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(MessageRecord.class, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getTableName(), false, null, null, null, null, null, null);
                if (localObject3 != null)
                {
                  localObject3 = ((List)localObject3).iterator();
                  if (((Iterator)localObject3).hasNext())
                  {
                    MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
                    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localMessageRecord);
                  }
                }
              }
              return this;
            }
            if ((String.valueOf(AppConstants.MAYKNOW_RECOMMEND_UIN).equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin)) || (AppConstants.FRIEND_ANNIVER_UIN.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin)))
            {
              ??? = this.jdField_a_of_type_Abwe.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop);
              aiej localaiej = (aiej)this.jdField_a_of_type_Abwe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
              ((QQMessageFacade.Message)???).istroop = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
              localaiej.a(false);
              j = localaiej.d();
              if (j > 0)
              {
                i = k;
                if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSendFromLocal())
                {
                  i = k;
                  if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time < ((QQMessageFacade.Message)???).time) {
                    i = 1;
                  }
                }
                if (i != 0) {
                  break;
                }
                MessageRecord.copyMessageRecordBaseField((MessageRecord)???, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
                ((QQMessageFacade.Message)???).msgData = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgData;
                this.jdField_a_of_type_Abwe.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setIncomingMsg((QQMessageFacade.Message)???);
                try
                {
                  this.jdField_a_of_type_Abwe.a((QQMessageFacade.Message)???);
                  this.jdField_a_of_type_Abwe.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getIncomingMsg().unReadNum = j;
                  return this;
                }
                catch (Throwable localThrowable2)
                {
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.BaseMessageManager", 2, "addMessageRecord ERROR", localThrowable2);
                    }
                  }
                }
              }
              this.jdField_a_of_type_Abwe.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setIncomingMsg(null);
              return this;
            }
            if (abwz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop) == 1032)
            {
              if (apse.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
                a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.CONFESS_UIN, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
              }
              this.jdField_a_of_type_JavaLangString = AppConstants.CONFESS_UIN;
              this.jdField_a_of_type_Int = 1032;
              this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
              return this;
            }
            if (abwz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop) == 1044)
            {
              if (((this.jdField_a_of_type_Abwp.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin)) || (this.jdField_a_of_type_JavaUtilMap.containsKey(abwz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop)))) && (!akms.a(this.jdField_a_of_type_Abwe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin))) {
                this.jdField_a_of_type_Anuz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
              }
              a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.MATCH_CHAT_UIN, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
              this.jdField_a_of_type_JavaLangString = AppConstants.MATCH_CHAT_UIN;
              this.jdField_a_of_type_Int = 1044;
              this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
              return this;
            }
            if (abwz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop) != 10008) {
              break;
            }
            if (((this.jdField_a_of_type_Abwp.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin)) || (this.jdField_a_of_type_JavaUtilMap.containsKey(abwz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop)))) && (!akms.a(this.jdField_a_of_type_Abwe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin))) {
              this.jdField_a_of_type_Anuz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
            }
            a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, AppConstants.QCIRCLE_CHAT_UIN, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
            this.jdField_a_of_type_JavaLangString = AppConstants.QCIRCLE_CHAT_UIN;
            this.jdField_a_of_type_Int = 10008;
            this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
            return this;
          }
          i = 0;
        }
      }
      label1964:
      i = 0;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwh
 * JD-Core Version:    0.7.0.1
 */