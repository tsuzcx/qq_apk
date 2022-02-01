import OnlinePushPack.DelMsgInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import msf.msgcomm.msg_comm.Msg;

class acmu
{
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<MessageRecord> jdField_a_of_type_JavaUtilArrayList;
  private msg_comm.Msg jdField_a_of_type_MsfMsgcommMsg_comm$Msg;
  private boolean jdField_a_of_type_Boolean;
  private ArrayList<DelMsgInfo> b;
  private ArrayList<MessageRecord> c;
  
  public acmu(msg_comm.Msg paramMsg, ArrayList<MessageRecord> paramArrayList1, boolean paramBoolean, String paramString, ArrayList<DelMsgInfo> paramArrayList, ArrayList<MessageRecord> paramArrayList2)
  {
    this.jdField_a_of_type_MsfMsgcommMsg_comm$Msg = paramArrayList1;
    this.jdField_a_of_type_JavaUtilArrayList = paramBoolean;
    this.jdField_a_of_type_Boolean = paramString;
    this.jdField_a_of_type_JavaLangString = paramArrayList;
    this.b = paramArrayList2;
    Object localObject;
    this.c = localObject;
  }
  
  private boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, MessageForStructing paramMessageForStructing)
  {
    boolean bool2 = false;
    boolean bool1 = paramBoolean;
    String str;
    if (paramMessageForStructing != null)
    {
      bool1 = paramBoolean;
      if (paramMessageForStructing.structingMsg != null)
      {
        bool1 = paramBoolean;
        if (paramMessageForStructing.structingMsg.mMsgServiceID == 128) {
          str = paramMessageRecord.getExtInfoFromExtStr("key_message_extra_info_flag");
        }
      }
    }
    try
    {
      i = Integer.parseInt(str);
      if ((i & 0x4) == 4)
      {
        j = 1;
        if (j != 0)
        {
          paramMessageForStructing.extraflag = 32768;
          paramMessageRecord.issend = 1;
          paramMessageForStructing.saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(i & 0xFFFFFFFB));
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_JavaLangString = paramMessageForStructing.frienduin;
        }
        paramMessageForStructing.isCheckNeedShowInListTypeMsg = true;
        i = acmp.a(this.jdField_a_of_type_Acmp, this.jdField_a_of_type_MsfMsgcommMsg_comm$Msg);
        paramBoolean = bool2;
        if (i == 1) {
          paramBoolean = true;
        }
        paramMessageForStructing.needNeedShowInList = paramBoolean;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_SlaveMaster isCheckNeedShowInListTypeMsg:" + paramMessageForStructing.isCheckNeedShowInListTypeMsg + " needNeedShowInList:" + paramMessageForStructing.needNeedShowInList + " uint32ShowInMsgList:" + i);
        }
        bool1 = true;
        return bool1;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
        int i = 0;
        continue;
        int j = 0;
      }
    }
  }
  
  public acmu a()
  {
    MessageRecord localMessageRecord;
    boolean bool;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      int j = this.jdField_a_of_type_JavaUtilArrayList.size();
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_SlaveMaster after analysis mr.senderuin: " + localMessageRecord.senderuin + " mr.msgtype: " + localMessageRecord.msgtype + " mr.frienduin: " + localMessageRecord.frienduin + " mr.shmsgseq: " + localMessageRecord.shmsgseq + " mr.time:" + localMessageRecord.time + " mr.msg: " + localMessageRecord.getLogColorContent());
          }
          if ((localMessageRecord.frienduin == null) || (localMessageRecord.frienduin.length() <= 2))
          {
            i += 1;
          }
          else
          {
            localMessageRecord.isread = true;
            localMessageRecord.issend = 2;
            if ((localMessageRecord instanceof MessageForStructing)) {
              bool = a(localMessageRecord, false, (MessageForStructing)localMessageRecord);
            }
          }
        }
      }
    }
    for (;;)
    {
      if (!bool) {
        this.jdField_a_of_type_Acmp.a.getMessageFacade().setReadFrom(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.time);
      }
      this.c.add(localMessageRecord);
      DelMsgInfo localDelMsgInfo = new DelMsgInfo();
      localDelMsgInfo.lFromUin = Long.parseLong(localMessageRecord.senderuin);
      localDelMsgInfo.shMsgSeq = ((short)(int)localMessageRecord.shmsgseq);
      localDelMsgInfo.uMsgTime = localMessageRecord.time;
      this.b.add(localDelMsgInfo);
      break;
      if (localMessageRecord.msgtype == -10000)
      {
        bool = true;
        continue;
        return this;
      }
      else
      {
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acmu
 * JD-Core Version:    0.7.0.1
 */