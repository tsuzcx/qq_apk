import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

class adat
{
  private long jdField_a_of_type_Long;
  private MsgInfo jdField_a_of_type_OnlinePushPackMsgInfo;
  private SvcReqPushMsg jdField_a_of_type_OnlinePushPackSvcReqPushMsg;
  private FromServiceMsg jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<MessageRecord> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private ArrayList<MsgInfo> jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean;
  private ArrayList<DelMsgInfo> c;
  private ArrayList<String> d;
  
  public adat(FromServiceMsg paramFromServiceMsg, SvcReqPushMsg paramSvcReqPushMsg, String paramString, ArrayList<MessageRecord> paramArrayList, ArrayList<MsgInfo> paramArrayList1, ArrayList<DelMsgInfo> paramArrayList2, long paramLong, ArrayList<String> paramArrayList3, MsgInfo paramMsgInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramSvcReqPushMsg;
    this.jdField_a_of_type_OnlinePushPackSvcReqPushMsg = paramString;
    this.jdField_a_of_type_JavaLangString = paramArrayList;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList1;
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList2;
    this.c = paramLong;
    this.jdField_a_of_type_Long = ???;
    this.d = paramMsgInfo;
    this.jdField_a_of_type_OnlinePushPackMsgInfo = paramBoolean;
    boolean bool1;
    this.jdField_b_of_type_Boolean = bool1;
  }
  
  private void a()
  {
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_OnlinePushPackMsgInfo.uAppShareID > 0L)) {
      this.d.add(bhki.a(this.jdField_a_of_type_OnlinePushPackMsgInfo.uAppShareID));
    }
  }
  
  private void a(int paramInt)
  {
    if ((42 != paramInt) && (83 != paramInt) && (127 != paramInt) && (QLog.isColorLevel())) {
      aoci.a("Q.msg.BaseMessageProcessor", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_OnlinePushPackMsgInfo.shMsgSeq, String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_OnlinePushPackMsgInfo.lFromUin));
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp  before analysis msgInfo.lFromUin: " + this.jdField_a_of_type_OnlinePushPackMsgInfo.lFromUin + " msgInfo.shMsgType: " + this.jdField_a_of_type_OnlinePushPackMsgInfo.shMsgType + " msgInfo.uRealMsgTime: " + this.jdField_a_of_type_OnlinePushPackMsgInfo.uRealMsgTime + " msgInfo.shMsgSeq: " + this.jdField_a_of_type_OnlinePushPackMsgInfo.shMsgSeq + ", msgInfo.lMsgUid" + this.jdField_a_of_type_OnlinePushPackMsgInfo.lMsgUid);
    }
  }
  
  private void a(Exception paramException)
  {
    paramException.printStackTrace();
    if ((this.jdField_a_of_type_OnlinePushPackMsgInfo.vMsg != null) && (QLog.isColorLevel())) {
      QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp Exception msgInfo.vMsg: " + bhml.a(this.jdField_a_of_type_OnlinePushPackMsgInfo.vMsg));
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, long paramLong1, MsgInfo paramMsgInfo, int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte, int paramInt3, long paramLong2, long paramLong3, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) || (paramString == null)) {
      return;
    }
    MessageRecord localMessageRecord = bcry.a(paramInt2);
    if (paramInt1 == 1006)
    {
      String str = bhlg.f(this.jdField_a_of_type_Adan.a, String.valueOf(paramLong2));
      localMessageRecord.init(String.valueOf(paramLong1), bhlg.f(this.jdField_a_of_type_Adan.a, String.valueOf(paramLong3)), str, paramString, paramMsgInfo.uRealMsgTime, paramInt2, paramInt1, paramMsgInfo.uMsgTime);
    }
    for (;;)
    {
      localMessageRecord.shmsgseq = paramMsgInfo.shMsgSeq;
      localMessageRecord.isread = paramBoolean1;
      localMessageRecord.msgUid = paramMsgInfo.lMsgUid;
      localMessageRecord.msgData = paramArrayOfByte;
      if (paramInt3 > 0) {
        localMessageRecord.extraflag = paramInt3;
      }
      if (!aoci.a(this.jdField_a_of_type_Adan.a, localMessageRecord, true)) {
        paramArrayList.add(localMessageRecord);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp after analysis friendUin: " + paramLong3 + " msgType: " + paramInt2 + " friendType: " + paramInt1 + " shMsgSeq: " + paramMsgInfo.shMsgSeq + " msgContent: " + bhjx.a(paramString));
      return;
      localMessageRecord.init(paramLong1, paramLong3, paramLong2, paramString, paramMsgInfo.uRealMsgTime, paramInt2, paramInt1, paramMsgInfo.uMsgTime);
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, MsgInfo paramMsgInfo, long paramLong)
  {
    paramMsgInfo = adan.a(this.jdField_a_of_type_Adan, paramMsgInfo, paramLong);
    if ((paramMsgInfo != null) && (!aoci.a(this.jdField_a_of_type_Adan.a, paramMsgInfo, true))) {
      paramArrayList.add(paramMsgInfo);
    }
  }
  
  private void a(ArrayList<MsgInfo> paramArrayList, ArrayList<DelMsgInfo> paramArrayList1, long paramLong1, MsgInfo paramMsgInfo, int paramInt, long paramLong2, long paramLong3, boolean paramBoolean, DelMsgInfo paramDelMsgInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "------->msgFilter-handleC2COnlinePushMsgResp receive msg size:" + paramArrayList.size());
    }
    if (aoci.a(this.jdField_a_of_type_Adan.a, paramInt, String.valueOf(paramLong3), String.valueOf(paramLong2), paramMsgInfo.uMsgTime, paramMsgInfo.shMsgSeq)) {}
    do
    {
      return;
      paramArrayList1.remove(paramDelMsgInfo);
      paramArrayList = new String(paramMsgInfo.vMsg) + paramMsgInfo.uMsgTime;
      if (!this.jdField_a_of_type_Adan.a.a().a().a(paramArrayList))
      {
        paramArrayList = new long[1];
        paramArrayList[0] = paramMsgInfo.lFromUin;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "---->handleC2COnlinePushMsgResp, new file msg, about to call handleOffLineFileResp");
        }
        adan.a(this.jdField_a_of_type_Adan, String.valueOf(paramLong3), paramLong1, paramArrayList, paramMsgInfo.vMsg, paramMsgInfo.uMsgTime, paramMsgInfo.shMsgSeq, paramBoolean);
        paramMsgInfo.lFromUin = paramArrayList[0];
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageProcessor", 2, "rcv a repeated offline file push msg");
  }
  
  private boolean a(SvcReqPushMsg paramSvcReqPushMsg, ArrayList<MessageRecord> paramArrayList, MsgInfo paramMsgInfo, int paramInt)
  {
    paramSvcReqPushMsg = adan.a(this.jdField_a_of_type_Adan, paramInt, paramMsgInfo, paramSvcReqPushMsg);
    if (paramSvcReqPushMsg != null)
    {
      if (paramSvcReqPushMsg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
        paramArrayList.add(paramSvcReqPushMsg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
      if (paramSvcReqPushMsg.jdField_a_of_type_Boolean) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(ArrayList<MessageRecord> paramArrayList, MsgInfo paramMsgInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramMsgInfo.vMsg == null) {
      bool1 = true;
    }
    int i;
    do
    {
      do
      {
        Object localObject;
        do
        {
          do
          {
            return bool1;
            localObject = new byte[paramMsgInfo.vMsg.length];
            bhvd.a((byte[])localObject, 0, paramMsgInfo.vMsg, 0, localObject.length);
            i = localObject[4];
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "<---0x2dc push  groupCode:" + bhvd.a(paramMsgInfo.vMsg, 0) + " subType:" + i + "msgSeq:" + paramMsgInfo.shMsgSeq);
            }
            if ((i != 16) && (i != 17) && (i != 20) && (i != 21)) {
              break;
            }
            bool1 = bool2;
          } while (paramMsgInfo.vMsg.length <= 7);
          localObject = (bgul)this.jdField_a_of_type_Adan.a.getManager(81);
          byte[] arrayOfByte = new byte[paramMsgInfo.vMsg.length - 7];
          bhvd.a(arrayOfByte, 0, paramMsgInfo.vMsg, 7, arrayOfByte.length);
          paramMsgInfo = ((bgul)localObject).a(this.jdField_a_of_type_Adan.a, arrayOfByte, paramMsgInfo.shMsgSeq, paramMsgInfo.uRealMsgTime, false, false, null);
          bool1 = bool2;
        } while (paramMsgInfo == null);
        paramArrayList.add(paramMsgInfo);
        return false;
        if ((i == 12) || (i == 14))
        {
          ((bgsl)this.jdField_a_of_type_Adan.a.getManager(48)).a((byte[])localObject, paramMsgInfo.shMsgSeq);
          return false;
        }
        if (i == 15)
        {
          adan.a(this.jdField_a_of_type_Adan, (byte[])localObject, paramMsgInfo.shMsgSeq);
          return true;
        }
        if (i == 6)
        {
          adan.a(this.jdField_a_of_type_Adan, (byte[])localObject);
          return false;
        }
        if (i == 11) {
          break;
        }
        bool1 = bool2;
      } while (i != 13);
      bool1 = bool2;
    } while (paramMsgInfo.vMsg.length <= 7);
    paramArrayList = new byte[paramMsgInfo.vMsg.length - 7];
    bhvd.a(paramArrayList, 0, paramMsgInfo.vMsg, 7, paramArrayList.length);
    adan.a(this.jdField_a_of_type_Adan, paramArrayList, i);
    return false;
  }
  
  public adat a()
  {
    int i;
    long l1;
    long l2;
    long l3;
    try
    {
      new ArrayList();
      i = this.jdField_a_of_type_OnlinePushPackMsgInfo.shMsgType;
      l1 = this.jdField_a_of_type_OnlinePushPackMsgInfo.lFromUin;
      l2 = this.jdField_a_of_type_OnlinePushPackMsgInfo.lFromUin;
      if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getUin() == null) {}
      for (Object localObject1 = Long.valueOf(this.jdField_a_of_type_Adan.a.getAccount());; localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getUin()))
      {
        l3 = ((Long)localObject1).longValue();
        localObject1 = new DelMsgInfo();
        ((anyw)this.jdField_a_of_type_Adan.a.getManager(51)).a(this.jdField_a_of_type_OnlinePushPackMsgInfo.lFromUin);
        ((DelMsgInfo)localObject1).lFromUin = this.jdField_a_of_type_OnlinePushPackMsgInfo.lFromUin;
        ((DelMsgInfo)localObject1).shMsgSeq = this.jdField_a_of_type_OnlinePushPackMsgInfo.shMsgSeq;
        ((DelMsgInfo)localObject1).uMsgTime = this.jdField_a_of_type_OnlinePushPackMsgInfo.uMsgTime;
        ((DelMsgInfo)localObject1).vMsgCookies = this.jdField_a_of_type_OnlinePushPackMsgInfo.vMsgCookies;
        this.c.add(localObject1);
        a(i);
        if (!aosx.a().containsKey(Integer.valueOf(i))) {
          break;
        }
        if (!a(this.jdField_a_of_type_OnlinePushPackSvcReqPushMsg, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_OnlinePushPackMsgInfo, i)) {
          break label748;
        }
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
      if (169 != i) {
        break label281;
      }
      a(this.jdField_b_of_type_JavaUtilArrayList, this.c, this.jdField_a_of_type_Long, this.jdField_a_of_type_OnlinePushPackMsgInfo, 0, l1, l2, false, (DelMsgInfo)localObject1);
      this.jdField_a_of_type_Boolean = true;
      return this;
    }
    catch (Exception localException)
    {
      a(localException);
    }
    a();
    this.jdField_a_of_type_Boolean = false;
    return this;
    label281:
    Object localObject3;
    int j;
    Object localObject2;
    boolean bool;
    int k;
    if (8 == i)
    {
      localObject3 = new adao(this.jdField_a_of_type_Adan, this.jdField_a_of_type_OnlinePushPackMsgInfo, null).a();
      i = ((adao)localObject3).a();
      j = ((adao)localObject3).b();
      localObject2 = ((adao)localObject3).a();
      l1 = ((adao)localObject3).a();
      bool = false;
      k = -1;
      localObject3 = null;
    }
    for (;;)
    {
      a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Long, this.jdField_a_of_type_OnlinePushPackMsgInfo, i, j, (String)localObject2, (byte[])localObject3, k, l1, l2, bool, this.jdField_b_of_type_Boolean);
      break;
      if (132 == i)
      {
        localObject3 = new adap(this.jdField_a_of_type_Adan, this.jdField_a_of_type_OnlinePushPackMsgInfo, null).a();
        i = ((adap)localObject3).a();
        j = ((adap)localObject3).b();
        localObject2 = ((adap)localObject3).a();
        l1 = ((adap)localObject3).a();
        bool = false;
        k = -1;
        localObject3 = null;
      }
      else if (732 == i)
      {
        this.jdField_b_of_type_Boolean = a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_OnlinePushPackMsgInfo);
        bool = false;
        i = 0;
        localObject2 = null;
        localObject3 = null;
        k = -1;
        j = -1000;
      }
      else if (230 == i)
      {
        adaq localadaq = new adaq(this.jdField_a_of_type_Adan, this.jdField_a_of_type_OnlinePushPackMsgInfo, l1, l2).a();
        i = localadaq.a();
        j = localadaq.b();
        localObject2 = localadaq.a();
        localObject3 = localadaq.a();
        bool = localadaq.a();
        k = -1;
      }
      else if (SystemMsg.isSystemMessage(i))
      {
        localObject2 = new adar(this.jdField_a_of_type_Adan, this.jdField_a_of_type_Long, this.jdField_a_of_type_OnlinePushPackMsgInfo, i).a();
        j = ((adar)localObject2).a();
        l2 = ((adar)localObject2).a();
        bool = false;
        i = 0;
        localObject2 = null;
        localObject3 = null;
        k = -1;
      }
      else if (SystemMsg.isTroopSystemMessage(i))
      {
        localObject2 = new adas(this.jdField_a_of_type_Adan, this.jdField_a_of_type_OnlinePushPackMsgInfo, i, -1000, -1, l1, l2).a();
        j = ((adas)localObject2).a();
        k = ((adas)localObject2).b();
        l2 = ((adas)localObject2).a();
        bool = false;
        i = 0;
        localObject2 = null;
        localObject3 = null;
      }
      else if (528 == i)
      {
        a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_OnlinePushPackMsgInfo, l3);
        bool = false;
        i = 0;
        localObject2 = null;
        localObject3 = null;
        k = -1;
        j = -1000;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp msgtype: unknow msgType!!!");
        }
        this.jdField_a_of_type_Boolean = true;
        return this;
        label748:
        bool = false;
        i = 0;
        localObject2 = null;
        localObject3 = null;
        k = -1;
        j = -1000;
      }
    }
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adat
 * JD-Core Version:    0.7.0.1
 */