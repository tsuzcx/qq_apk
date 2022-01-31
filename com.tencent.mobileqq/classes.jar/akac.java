import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.BaseMessageProcessor.1;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lmsf.msgcomm.msg_comm.Msg;>;
import java.util.Set;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;

public abstract class akac
{
  protected final int a;
  public MessageHandler a;
  public QQAppInterface a;
  protected QQMessageFacade a;
  private List<akbz> a;
  protected final int b = 9;
  protected final int c = 3;
  private final int d = 450000;
  
  public akac(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 480000;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = paramMessageHandler;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade = paramQQAppInterface.a();
  }
  
  public akbx a(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    return null;
  }
  
  protected Pair<Boolean, StringBuilder> a(List<msg_comm.Msg> paramList1, List<msg_comm.Msg> paramList2)
  {
    if ((paramList1 == null) || (paramList1.size() == 0)) {
      return new Pair(Boolean.valueOf(false), null);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramList1.iterator();
    paramList1 = Boolean.valueOf(false);
    while (localIterator.hasNext())
    {
      Object localObject = (msg_comm.Msg)localIterator.next();
      if (((msg_comm.Msg)localObject).msg_head.has())
      {
        String str = a((msg_comm.Msg)localObject);
        if (localHashSet.contains(str))
        {
          localObject = Boolean.valueOf(true);
          paramList1 = (List<msg_comm.Msg>)localObject;
          if (QLog.isColorLevel())
          {
            localStringBuilder.append("< duplicatedMsg:").append(str).append(" >");
            paramList1 = (List<msg_comm.Msg>)localObject;
          }
        }
        for (;;)
        {
          break;
          localHashSet.add(str);
          paramList2.add(localObject);
        }
      }
    }
    return new Pair(paramList1, localStringBuilder);
  }
  
  protected String a(msg_comm.Msg paramMsg)
  {
    return String.valueOf(paramMsg.hashCode());
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((akbz)localIterator.next()).b(paramInt, paramBoolean, paramObject);
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(akbz paramakbz)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramakbz);
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramToServiceMsg.extraData.putLong("msgSeq", paramLong);
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        paramToServiceMsg.setNeedRemindSlowNetwork(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.sendPbReq(paramToServiceMsg);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.send(paramToServiceMsg);
  }
  
  protected void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((akbz)localIterator.next()).a(getClass().getSimpleName(), paramString, paramBoolean1, paramInt, paramBoolean2, paramBoolean3);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, List<MessageRecord> arg3, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = akbm.a(???, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((akbz)localIterator.next()).a(getClass().getSimpleName(), paramString, paramBoolean1, i, paramBoolean2, paramBoolean3);
      }
    }
  }
  
  protected void a(ArrayList<MessageRecord> paramArrayList1, ArrayList<MessageRecord> paramArrayList2, boolean paramBoolean)
  {
    if (paramArrayList1.size() > 0)
    {
      paramArrayList1 = paramArrayList1.iterator();
      while (paramArrayList1.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramArrayList1.next();
        if (!ajml.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, paramBoolean)) {
          paramArrayList2.add(localMessageRecord);
        }
      }
    }
  }
  
  public void a(msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "sendMsgReadConfirm");
    }
    a(true, true, false, 0L, new akad(this, paramPbMsgReadedReportReq));
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong, akae paramakae)
  {
    int i;
    if (paramLong == 0L)
    {
      i = avys.jdField_a_of_type_Int;
      avys.jdField_a_of_type_Int = i + 1;
      paramLong = i;
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      if (!paramBoolean1)
      {
        paramakae = paramakae.a();
        if (paramakae == null) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "processRequest cmd=" + paramakae.getServiceCmd() + ",reqSeq=" + paramLong);
        }
        a(paramakae, paramLong, paramBoolean2, paramBoolean3);
        return;
      }
      SendMessageHandler localSendMessageHandler = new SendMessageHandler();
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramLong, localSendMessageHandler);
      i = 0;
      while (i < 9)
      {
        localSendMessageHandler.a(new BaseMessageProcessor.1(this, paramakae, paramLong, l, paramBoolean2, paramBoolean3));
        i += 1;
      }
      i = 0;
      label168:
      if (i < 3) {
        if (i != 0) {
          break label222;
        }
      }
      label222:
      for (paramLong = 480000L;; paramLong = (3 - i) * 480000 / 3 - i * 2000)
      {
        l = 480000 * i / 3;
        localSendMessageHandler.getClass();
        localSendMessageHandler.a(l, paramLong, "period");
        i += 1;
        break label168;
        break;
      }
    }
  }
  
  protected boolean a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return ajml.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, paramBoolean);
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((akbz)localIterator.next()).c(paramInt, paramBoolean, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akac
 * JD-Core Version:    0.7.0.1
 */