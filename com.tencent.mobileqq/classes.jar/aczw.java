import OnlinePushPack.DelMsgInfo;
import PushNotifyPack.C2CMsgReadedNotify;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.imcore.message.C2CMessageProcessor.4;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbGetMsgResp;
import msf.msgsvc.msg_svc.PbGetOneDayRoamMsgResp;
import msf.msgsvc.msg_svc.PbGetRoamMsgResp;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import msf.msgsvc.msg_svc.PbSearchRoamMsgInCloudResp;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.PubAccInfo;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.oidb.searcher.oidb_c2c_searcher.RspBody;

public class aczw
  extends aczo
{
  public int a;
  public Comparator a;
  HashSet<String> jdField_a_of_type_JavaUtilHashSet = null;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  HashSet<String> jdField_b_of_type_JavaUtilHashSet = null;
  private Set<String> jdField_b_of_type_JavaUtilSet = new HashSet();
  public int c;
  public int d;
  public int e;
  public int f = 1;
  public int g = 5;
  public int h = 10;
  public int i = 50;
  public int j;
  
  public aczw(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 3;
    this.jdField_c_of_type_Int = 10;
    this.jdField_d_of_type_Int = 30;
    this.jdField_a_of_type_JavaUtilComparator = new aczx(this);
  }
  
  private int a(byte paramByte, msg_comm.UinPairMsg paramUinPairMsg, String paramString, int paramInt)
  {
    byte b1;
    int k;
    if ((paramUinPairMsg.c2c_type.has()) && (paramUinPairMsg.service_type.has()))
    {
      b1 = paramUinPairMsg.c2c_type.get();
      k = paramUinPairMsg.service_type.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage : peerUin:" + paramString + "c2cType:" + b1 + " serviceType:" + k + " channelType:" + paramByte);
      }
      if ((b1 == 1) && (k == 130)) {
        paramByte = 1006;
      }
    }
    for (;;)
    {
      b1 = a(paramUinPairMsg, paramString, paramInt);
      paramInt = paramByte;
      if (b1 != paramByte) {
        paramInt = b1;
      }
      return paramInt;
      if ((b1 == 1) && (k == 164))
      {
        paramByte = 10007;
      }
      else
      {
        paramByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt).istroop;
        continue;
        paramByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt).istroop;
      }
    }
  }
  
  private int a(msg_comm.UinPairMsg paramUinPairMsg, String paramString, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b();
    int[] arrayOfInt = new int[1];
    localObject = ((List)localObject).iterator();
    adbt localadbt;
    do
    {
      k = paramInt;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localadbt = (adbt)((Iterator)localObject).next();
      arrayOfInt[0] = paramInt;
    } while (!localadbt.a(paramUinPairMsg, paramString, arrayOfInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    int k = arrayOfInt[0];
    return k;
  }
  
  private Pair<String, Integer> a(String paramString, msg_comm.UinPairMsg paramUinPairMsg, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ArrayList localArrayList1 = new ArrayList();
    long l7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject1 = paramUinPairMsg.msg.get();
    if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
      return new Pair(paramString, Integer.valueOf(0));
    }
    ArrayList localArrayList2 = new ArrayList();
    a((List)localObject1, localArrayList2);
    StringBuilder localStringBuilder = new StringBuilder();
    HashMap localHashMap = new HashMap();
    HashSet localHashSet = new HashSet();
    bcre localbcre = new bcre(l7, Long.parseLong(paramString), true, paramBoolean2, paramBoolean3, false);
    localbcre.jdField_e_of_type_Boolean = true;
    localbcre.a(1000, localHashMap);
    localbcre.a(1001, localHashSet);
    long l1 = -1L;
    int k = 0;
    localObject1 = paramString;
    long l2 = -1L;
    int n = 0;
    if (n < localArrayList2.size()) {}
    try
    {
      localObject2 = (msg_comm.Msg)localArrayList2.get(n);
      localObject4 = (msg_comm.MsgHead)((msg_comm.Msg)localObject2).msg_head.get();
      if (!((msg_comm.Msg)localObject2).msg_head.has())
      {
        if (!QLog.isColorLevel()) {
          break label2485;
        }
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage: msgList[" + n + "] : msg doesn't has msgHead.");
        break label2485;
      }
      l3 = ((msg_comm.MsgHead)localObject4).to_uin.get();
      l8 = ((msg_comm.MsgHead)localObject4).from_uin.get();
      l4 = ((msg_comm.MsgHead)localObject4).from_uin.get();
      l5 = ((msg_comm.MsgHead)localObject4).msg_time.get();
      if (l5 <= paramLong) {
        break label2476;
      }
      paramBoolean3 = false;
      bool = false;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject4;
        long l8;
        long l4;
        long l5;
        long l9;
        int m;
        Object localObject3;
        continue;
        paramBoolean3 = true;
        boolean bool = true;
      }
      l3 = l2;
      l2 = l1;
      l1 = l3;
    }
    l9 = aoci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l4, l3, paramUinPairMsg.peer_uin.get(), paramUinPairMsg);
    localbcre.i = true;
    localObject1 = String.valueOf(l9);
    long l3 = l2;
    l4 = l1;
    m = k;
    for (;;)
    {
      int i1;
      try
      {
        l6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l9), 0);
        if ((l5 <= l6) && (bool))
        {
          l3 = l2;
          l4 = l1;
          m = k;
          if (!QLog.isColorLevel()) {
            break label2518;
          }
          l3 = l2;
          l4 = l1;
          m = k;
          localStringBuilder.setLength(0);
          l3 = l2;
          l4 = l1;
          m = k;
          localStringBuilder.append("<---decodeC2CMessagePackage : msgList[").append(n).append("] : filter msg by del time delTime =").append(l6).append(", msgTime = ").append(l5);
          l3 = l2;
          l4 = l1;
          m = k;
          QLog.d("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
          break label2518;
        }
        l3 = l2;
        l4 = l1;
        m = k;
        localbcre.jdField_a_of_type_Boolean = bool;
        l3 = l2;
        l4 = l1;
        m = k;
        localbcre.jdField_e_of_type_Long = l9;
        l3 = l2;
        l4 = l1;
        m = k;
        localbcre.h = paramBoolean3;
        l3 = l2;
        l4 = l1;
        m = k;
        localObject2 = a((msg_comm.Msg)localObject2, localbcre).iterator();
        l3 = l2;
        l4 = l1;
        m = k;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        l3 = l2;
        l4 = l1;
        m = k;
        localObject4 = (MessageRecord)((Iterator)localObject2).next();
        l3 = l2;
        l4 = l1;
        m = k;
        l5 = ((MessageRecord)localObject4).vipBubbleID;
        if (l5 == -1L) {
          break label1595;
        }
        l3 = l2;
        l4 = l1;
        m = k;
        if (!bhnt.a(((MessageRecord)localObject4).issend)) {
          break label1584;
        }
        l6 = l1;
        l3 = l5;
        l4 = l6;
        m = k;
        i1 = ((MessageRecord)localObject4).istroop;
        l3 = l5;
        l4 = l6;
        m = i1;
        paramBoolean3 = a((MessageRecord)localObject4, true);
        l3 = l5;
        l4 = l6;
        m = i1;
        bool = b((MessageRecord)localObject4);
        Object localObject5;
        if ((!paramBoolean3) && (!bool))
        {
          l3 = l5;
          l4 = l6;
          m = i1;
          if (((MessageRecord)localObject4).istroop == 1008)
          {
            l3 = l5;
            l4 = l6;
            m = i1;
            if ((localObject4 instanceof MessageForStructing))
            {
              l3 = l5;
              l4 = l6;
              m = i1;
              if (!StructLongMessageDownloadProcessor.b((MessageRecord)localObject4))
              {
                l3 = l5;
                l4 = l6;
                m = i1;
                if (!StructLongMessageDownloadProcessor.d((MessageRecord)localObject4)) {}
              }
              else
              {
                l3 = l5;
                l4 = l6;
                m = i1;
                localObject5 = ((MessageRecord)localObject4).getExtInfoFromExtStr("longMsg_State");
                if (localObject5 == null) {
                  break label1844;
                }
                l3 = l5;
                l4 = l6;
                m = i1;
                if (!String.valueOf(3).equals(localObject5)) {
                  break label1844;
                }
              }
            }
          }
          l3 = l5;
          l4 = l6;
          m = i1;
          if ((localObject4 instanceof MessageForMarketFace))
          {
            l3 = l5;
            l4 = l6;
            m = i1;
            axfi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForMarketFace)localObject4);
          }
          l3 = l5;
          l4 = l6;
          m = i1;
          if (antf.az.equals(((MessageRecord)localObject4).frienduin))
          {
            l3 = l5;
            l4 = l6;
            m = i1;
            ((MessageRecord)localObject4).time = NetConnInfoCenter.getServerTime();
          }
          l3 = l5;
          l4 = l6;
          m = i1;
          if (antf.aR.equals(((MessageRecord)localObject4).frienduin))
          {
            l3 = l5;
            l4 = l6;
            m = i1;
            ((KandianDailyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(296)).b((MessageRecord)localObject4);
          }
          l3 = l5;
          l4 = l6;
          m = i1;
          localArrayList1.add(localObject4);
          l3 = l5;
          l4 = l6;
          m = i1;
          k = KandianMergeManager.a((MessageRecord)localObject4, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if ((k == 0) || (k == 1))
          {
            l3 = l5;
            l4 = l6;
            m = i1;
            localObject5 = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).a((MessageRecord)localObject4);
            if (localObject5 != null)
            {
              l3 = l5;
              l4 = l6;
              m = i1;
              localArrayList1.add(localObject5);
            }
          }
        }
        l3 = l5;
        l4 = l6;
        m = i1;
        if (((MessageRecord)localObject4).msgtype == -2002)
        {
          if (!paramBoolean3)
          {
            l3 = l5;
            l4 = l6;
            m = i1;
            if (bdoc.a(((MessageRecord)localObject4).msgUid, ((MessageRecord)localObject4).shmsgseq) != null)
            {
              l3 = l5;
              l4 = l6;
              m = i1;
              bewa.a(true);
            }
          }
          if (paramBoolean3)
          {
            l3 = l5;
            l4 = l6;
            m = i1;
            if ((localObject4 instanceof MessageForPtt))
            {
              l3 = l5;
              l4 = l6;
              m = i1;
              if (adak.d(((MessageRecord)localObject4).istroop))
              {
                l3 = l5;
                l4 = l6;
                m = i1;
                localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject4).frienduin, ((MessageRecord)localObject4).istroop).iterator();
                l3 = l5;
                l4 = l6;
                m = i1;
                if (((Iterator)localObject5).hasNext())
                {
                  l3 = l5;
                  l4 = l6;
                  m = i1;
                  MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject5).next();
                  l3 = l5;
                  l4 = l6;
                  m = i1;
                  if (!(localMessageRecord instanceof MessageForPtt)) {
                    continue;
                  }
                  l3 = l5;
                  l4 = l6;
                  m = i1;
                  if (localMessageRecord.msgUid != ((MessageRecord)localObject4).msgUid) {
                    continue;
                  }
                  l3 = l5;
                  l4 = l6;
                  m = i1;
                  if (localMessageRecord.shmsgseq != ((MessageRecord)localObject4).shmsgseq) {
                    continue;
                  }
                  l3 = l5;
                  l4 = l6;
                  m = i1;
                  a((MessageForPtt)localMessageRecord, (MessageForPtt)localObject4);
                }
              }
            }
          }
        }
        l2 = l5;
        l1 = l6;
        k = i1;
        if (paramBoolean3) {
          continue;
        }
        l2 = l5;
        l1 = l6;
        k = i1;
        l3 = l5;
        l4 = l6;
        m = i1;
        if (((MessageRecord)localObject4).istroop != 1008) {
          continue;
        }
        l3 = l5;
        l4 = l6;
        m = i1;
        apeg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject4);
        l2 = l5;
        l1 = l6;
        k = i1;
        continue;
        if (!QLog.isColorLevel()) {
          break label1569;
        }
      }
      catch (Exception localException1)
      {
        k = m;
        l1 = l4;
        l2 = l3;
      }
      QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeC2CMessage error,", localException1);
      label1569:
      l3 = l1;
      l1 = l2;
      l2 = l3;
      break label2497;
      label1584:
      long l6 = l5;
      l5 = l2;
      continue;
      label1595:
      l3 = l2;
      l4 = l1;
      m = k;
      if (((MessageRecord)localObject4).msgtype == -2002)
      {
        l3 = l2;
        l4 = l1;
        m = k;
        if (bhnt.a(((MessageRecord)localObject4).issend))
        {
          if (l2 != -1L)
          {
            l3 = l2;
            l4 = l1;
            m = k;
            ((MessageRecord)localObject4).vipBubbleID = l2;
            l5 = l2;
            l6 = l1;
          }
          else
          {
            l3 = l2;
            l4 = l1;
            m = k;
            ((MessageRecord)localObject4).vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l9), String.valueOf(l8));
            l5 = l2;
            l6 = l1;
          }
        }
        else if (l1 != -1L)
        {
          l3 = l2;
          l4 = l1;
          m = k;
          ((MessageRecord)localObject4).vipBubbleID = l1;
          l5 = l2;
          l6 = l1;
        }
        else
        {
          l3 = l2;
          l4 = l1;
          m = k;
          ((MessageRecord)localObject4).vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l9), String.valueOf(l8));
          l5 = l2;
          l6 = l1;
        }
      }
      else
      {
        l3 = l2;
        l4 = l1;
        m = k;
        ((MessageRecord)localObject4).vipBubbleID = 0L;
        l5 = l2;
        l6 = l1;
        continue;
        label1844:
        l3 = l5;
        l4 = l6;
        m = i1;
        ((MessageRecord)localObject4).saveExtInfoToExtStr("longMsg_State", String.valueOf(1));
        l3 = l5;
        l4 = l6;
        m = i1;
        StructLongMessageDownloadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject4);
      }
    }
    l3 = l1;
    l1 = l2;
    l2 = l3;
    break label2497;
    if (localObject1 != null)
    {
      paramUinPairMsg = (msg_comm.UinPairMsg)localObject1;
      if (!((String)localObject1).equals("0")) {}
    }
    else
    {
      paramUinPairMsg = paramString;
    }
    if (!localHashMap.isEmpty())
    {
      localObject1 = localHashSet.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Long)((Iterator)localObject1).next();
        localHashMap.remove(localObject3);
        if (QLog.isColorLevel()) {
          QLog.d("svenxu", 2, "Discard video request because canceled: fromUin = " + localObject3);
        }
      }
      localObject1 = localHashMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (msg_comm.Msg)localHashMap.get((Long)((Iterator)localObject1).next());
        if ((((msg_comm.Msg)localObject3).msg_body.has()) && (((im_msg_body.MsgBody)((msg_comm.Msg)localObject3).msg_body.get()).msg_content.has())) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l7, ((im_msg_body.MsgBody)((msg_comm.Msg)localObject3).msg_body.get()).msg_content.get().toByteArray(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject3).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject3).msg_head.get()).msg_time.get());
        }
      }
    }
    if (localArrayList1.size() > 0)
    {
      if (!paramBoolean2) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localArrayList1);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramUinPairMsg, 0, localArrayList1, paramBoolean1);
      paramBoolean3 = a(localArrayList1);
      m = adak.a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      aqyt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList1);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((!paramBoolean3) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop)) {
        break label2408;
      }
    }
    label2408:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      ((QQMessageFacade)localObject1).a(localArrayList1, str, paramBoolean1);
      ocd.a(localArrayList1);
      nqw.a.a(localArrayList1);
      b(localArrayList1);
      a("handleGetBuddyMessageResp", true, m, paramBoolean3, paramBoolean2);
      a(localArrayList1, paramBoolean2);
      aosq.a((MessageRecord)localArrayList1.get(0), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (k == 1008)
      {
        localObject1 = (aody)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
        if (localObject1 != null) {
          ((aody)localObject1).a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      if ((k != 0) || (localArrayList1.size() <= 0)) {
        break;
      }
      localObject1 = localArrayList1.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (MessageRecord)((Iterator)localObject1).next();
        bbcg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 0, (MessageRecord)localObject3);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage : dstUin:" + paramUinPairMsg + ", pkgUinType:" + k);
    }
    return new Pair(paramUinPairMsg, Integer.valueOf(k));
    for (;;)
    {
      label2476:
      label2485:
      label2497:
      n += 1;
      l3 = l2;
      l2 = l1;
      l1 = l3;
      break;
      label2518:
      l3 = l1;
      l1 = l2;
      l2 = l3;
    }
  }
  
  private Pair<List<MessageRecord>, List<MessageRecord>> a(List<msg_comm.Msg> paramList, List<MessageRecord> paramList1, long paramLong1, long paramLong2, long paramLong3)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = ((aocm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92)).a(String.valueOf(paramLong1), paramLong2 - 30L, 30L + paramLong3);
    if ((localList != null) && (!localList.isEmpty()))
    {
      paramList = paramList.iterator();
      Object localObject;
      int k;
      while (paramList.hasNext())
      {
        localObject = (msg_comm.Msg)paramList.next();
        if (!((msg_comm.Msg)localObject).msg_head.has())
        {
          paramList.remove();
        }
        else
        {
          localObject = (msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get();
          paramLong1 = ((msg_comm.MsgHead)localObject).msg_uid.get();
          paramLong2 = (short)((msg_comm.MsgHead)localObject).msg_seq.get();
          k = 0;
          while (k < localList.size())
          {
            localObject = (MessageRecord)localList.get(k);
            if ((((MessageRecord)localObject).msgUid == paramLong1) && (((MessageRecord)localObject).shmsgseq == paramLong2))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 2, "filterRoamMsgFromDB duplicated " + localObject);
              }
              localArrayList.add(localObject);
              paramList.remove();
            }
            k += 1;
          }
        }
      }
      paramList = paramList1.iterator();
      while (paramList.hasNext())
      {
        localObject = (MessageRecord)paramList.next();
        k = 0;
        while (k < localList.size())
        {
          MessageRecord localMessageRecord = (MessageRecord)localList.get(k);
          if ((localMessageRecord.msgUid == ((MessageRecord)localObject).msgUid) && (localMessageRecord.shmsgseq == ((MessageRecord)localObject).shmsgseq))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "filterRoamMsgFromDB duplicated " + localObject);
            }
            paramList.remove();
          }
          k += 1;
        }
      }
    }
    return new Pair(localArrayList, paramList1);
  }
  
  @Nullable
  private msg_svc.PbGetMsgResp a(byte[] paramArrayOfByte)
  {
    msg_svc.PbGetMsgResp localPbGetMsgResp = new msg_svc.PbGetMsgResp();
    try
    {
      paramArrayOfByte = (msg_svc.PbGetMsgResp)localPbGetMsgResp.mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        bdmc.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap(), "");
      }
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.C2CMessageProcessor", 2, "<---handleGetC2CMessageResp_PB : decode pb:", paramArrayOfByte);
        }
        paramArrayOfByte = null;
      }
    }
  }
  
  private void a(int paramInt, msg_comm.Msg paramMsg, ArrayList<MessageRecord> paramArrayList, MessageHandler paramMessageHandler, bcre parambcre)
  {
    bcsi localbcsi = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramInt);
    if (localbcsi != null) {
      localbcsi.a(paramMessageHandler, paramMsg, paramArrayList, parambcre);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = new Bundle();
    paramFromServiceMsg.putLong("BEGTIME", paramToServiceMsg.extraData.getLong("lBeginTime"));
    paramFromServiceMsg.putBoolean("FETCH_MORE", paramToServiceMsg.extraData.getBoolean("fetchMore"));
    a(1004, false, paramFromServiceMsg);
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_2
    //   4: istore 5
    //   6: aload_1
    //   7: getfield 641	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   10: ldc_w 668
    //   13: iconst_1
    //   14: invokevirtual 671	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   17: istore 11
    //   19: aload_1
    //   20: getfield 641	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   23: ldc_w 673
    //   26: iconst_1
    //   27: invokevirtual 671	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   30: istore 13
    //   32: aload_1
    //   33: getfield 641	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   36: ldc_w 675
    //   39: iconst_0
    //   40: invokevirtual 671	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   43: istore 12
    //   45: invokestatic 680	java/lang/System:currentTimeMillis	()J
    //   48: lstore 14
    //   50: aload_0
    //   51: aload_3
    //   52: checkcast 682	[B
    //   55: checkcast 682	[B
    //   58: invokespecial 684	aczw:a	([B)Lmsf/msgsvc/msg_svc$PbGetMsgResp;
    //   61: astore 25
    //   63: new 91	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   70: astore 23
    //   72: aload 25
    //   74: ifnull +25 -> 99
    //   77: aload 25
    //   79: getfield 687	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 75	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   85: ifeq +14 -> 99
    //   88: aload 25
    //   90: getfield 687	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   93: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   96: ifeq +150 -> 246
    //   99: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +104 -> 206
    //   105: aload 23
    //   107: iconst_0
    //   108: invokevirtual 283	java/lang/StringBuilder:setLength	(I)V
    //   111: aload 23
    //   113: ldc_w 689
    //   116: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 692	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   123: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: ldc_w 694
    //   129: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: astore 22
    //   134: aload 25
    //   136: ifnonnull +80 -> 216
    //   139: ldc_w 696
    //   142: astore_3
    //   143: aload 22
    //   145: aload_3
    //   146: invokevirtual 456	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   149: ldc_w 698
    //   152: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: astore 22
    //   157: aload 25
    //   159: ifnonnull +72 -> 231
    //   162: ldc_w 696
    //   165: astore_3
    //   166: aload 22
    //   168: aload_3
    //   169: invokevirtual 456	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   172: ldc_w 700
    //   175: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: iload 11
    //   180: invokevirtual 703	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   183: ldc_w 705
    //   186: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: iload 13
    //   191: invokevirtual 703	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: ldc 89
    //   197: iconst_2
    //   198: aload 23
    //   200: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 707	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload_0
    //   207: getfield 483	aczw:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   210: aload_1
    //   211: aload_2
    //   212: invokevirtual 709	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   215: return
    //   216: aload 25
    //   218: getfield 687	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   221: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   224: invokestatic 195	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   227: astore_3
    //   228: goto -85 -> 143
    //   231: aload 25
    //   233: getfield 712	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   236: invokevirtual 480	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   239: invokestatic 717	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   242: astore_3
    //   243: goto -77 -> 166
    //   246: aload 25
    //   248: getfield 720	msf/msgsvc/msg_svc$PbGetMsgResp:uin_pair_msgs	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   251: invokevirtual 184	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   254: astore 24
    //   256: aload_0
    //   257: getfield 483	aczw:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   260: iconst_0
    //   261: putfield 721	com/tencent/mobileqq/app/MessageHandler:g	I
    //   264: aload 25
    //   266: getfield 725	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   269: invokevirtual 728	com/tencent/mobileqq/pb/PBEnumField:has	()Z
    //   272: ifeq +13 -> 285
    //   275: aload 25
    //   277: getfield 725	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   280: invokevirtual 729	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   283: istore 5
    //   285: iload 5
    //   287: iconst_2
    //   288: if_icmpge +7 -> 295
    //   291: iconst_1
    //   292: i2b
    //   293: istore 4
    //   295: aconst_null
    //   296: astore_2
    //   297: aload 25
    //   299: getfield 712	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   302: invokevirtual 480	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   305: ifeq +15 -> 320
    //   308: aload 25
    //   310: getfield 712	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   313: invokevirtual 486	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   316: invokevirtual 492	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   319: astore_2
    //   320: aconst_null
    //   321: astore 22
    //   323: aload 25
    //   325: getfield 732	msf/msgsvc/msg_svc$PbGetMsgResp:pubaccount_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   328: invokevirtual 480	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   331: ifeq +16 -> 347
    //   334: aload 25
    //   336: getfield 732	msf/msgsvc/msg_svc$PbGetMsgResp:pubaccount_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   339: invokevirtual 486	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   342: invokevirtual 492	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   345: astore 22
    //   347: iconst_0
    //   348: istore 6
    //   350: aload 25
    //   352: getfield 735	msf/msgsvc/msg_svc$PbGetMsgResp:msg_rsp_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   355: invokevirtual 75	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   358: ifeq +13 -> 371
    //   361: aload 25
    //   363: getfield 735	msf/msgsvc/msg_svc$PbGetMsgResp:msg_rsp_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   366: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   369: istore 6
    //   371: aload_0
    //   372: aload_2
    //   373: aload 22
    //   375: iload 6
    //   377: invokespecial 738	aczw:a	([B[BI)V
    //   380: iconst_0
    //   381: istore 10
    //   383: aload_0
    //   384: getfield 483	aczw:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   387: invokevirtual 740	com/tencent/mobileqq/app/MessageHandler:a	()Z
    //   390: ifeq +6 -> 396
    //   393: iconst_1
    //   394: istore 10
    //   396: iload 4
    //   398: ifle +25 -> 423
    //   401: aload_0
    //   402: getfield 483	aczw:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   405: iload 4
    //   407: aload_2
    //   408: iload 5
    //   410: iload 11
    //   412: iload 13
    //   414: iload 10
    //   416: aconst_null
    //   417: iload 6
    //   419: aconst_null
    //   420: invokevirtual 743	com/tencent/mobileqq/app/MessageHandler:a	(B[BIZZZLjava/lang/String;ILjava/lang/Object;)V
    //   423: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   426: ifeq +156 -> 582
    //   429: aload 23
    //   431: iconst_0
    //   432: invokevirtual 283	java/lang/StringBuilder:setLength	(I)V
    //   435: aload 23
    //   437: ldc_w 689
    //   440: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload_1
    //   444: invokevirtual 692	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   447: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   450: ldc_w 694
    //   453: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: aload 25
    //   458: getfield 687	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   461: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   464: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   467: ldc_w 745
    //   470: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload 25
    //   475: getfield 712	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   478: invokevirtual 480	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   481: invokevirtual 703	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   484: ldc 107
    //   486: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: iload 4
    //   491: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   494: ldc_w 747
    //   497: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: iload 5
    //   502: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   505: ldc_w 749
    //   508: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: iload 11
    //   513: invokevirtual 703	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   516: ldc_w 705
    //   519: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: iload 13
    //   524: invokevirtual 703	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   527: ldc_w 751
    //   530: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: aload 24
    //   535: invokeinterface 187 1 0
    //   540: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   543: ldc_w 753
    //   546: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: aload_3
    //   550: invokevirtual 758	java/lang/Object:hashCode	()I
    //   553: invokestatic 761	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   556: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: ldc_w 763
    //   562: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: iload 6
    //   567: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: ldc 89
    //   573: iconst_2
    //   574: aload 23
    //   576: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   582: iconst_0
    //   583: istore 7
    //   585: iload 7
    //   587: aload 24
    //   589: invokeinterface 187 1 0
    //   594: if_icmpge +1015 -> 1609
    //   597: invokestatic 680	java/lang/System:currentTimeMillis	()J
    //   600: lstore 14
    //   602: aload 24
    //   604: iload 7
    //   606: invokeinterface 583 2 0
    //   611: checkcast 65	msf/msgcomm/msg_comm$UinPairMsg
    //   614: astore 22
    //   616: aload 22
    //   618: getfield 259	msf/msgcomm/msg_comm$UinPairMsg:peer_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   621: invokevirtual 250	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   624: invokestatic 271	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   627: astore_2
    //   628: aload 22
    //   630: getfield 766	msf/msgcomm/msg_comm$UinPairMsg:last_read_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   633: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   636: i2l
    //   637: ldc2_w 767
    //   640: land
    //   641: lstore 16
    //   643: aload 22
    //   645: getfield 180	msf/msgcomm/msg_comm$UinPairMsg:msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   648: invokevirtual 184	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   651: astore_3
    //   652: aload 22
    //   654: getfield 771	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   657: invokevirtual 75	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   660: ifeq +847 -> 1507
    //   663: aload 22
    //   665: getfield 771	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   668: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   671: ifeq +836 -> 1507
    //   674: iconst_1
    //   675: istore 10
    //   677: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   680: ifeq +77 -> 757
    //   683: aload 23
    //   685: iconst_0
    //   686: invokevirtual 283	java/lang/StringBuilder:setLength	(I)V
    //   689: aload 23
    //   691: ldc_w 773
    //   694: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: aload_2
    //   698: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: ldc_w 775
    //   704: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: iload 10
    //   709: invokevirtual 703	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   712: ldc_w 777
    //   715: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: lload 16
    //   720: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   723: ldc_w 779
    //   726: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: astore 25
    //   731: aload_3
    //   732: ifnonnull +781 -> 1513
    //   735: ldc_w 696
    //   738: astore_1
    //   739: aload 25
    //   741: aload_1
    //   742: invokevirtual 456	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   745: pop
    //   746: ldc 89
    //   748: iconst_2
    //   749: aload 23
    //   751: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   754: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   757: aload_3
    //   758: ifnull +811 -> 1569
    //   761: aload_3
    //   762: invokeinterface 187 1 0
    //   767: ifle +802 -> 1569
    //   770: aload_3
    //   771: invokeinterface 187 1 0
    //   776: iconst_1
    //   777: if_icmple +11 -> 788
    //   780: aload_3
    //   781: aload_0
    //   782: getfield 48	aczw:jdField_a_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   785: invokestatic 785	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   788: aload_0
    //   789: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   792: bipush 51
    //   794: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   797: checkcast 787	anyw
    //   800: aload_3
    //   801: iconst_0
    //   802: invokeinterface 583 2 0
    //   807: checkcast 228	msf/msgcomm/msg_comm$Msg
    //   810: getfield 232	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   813: invokevirtual 237	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   816: checkcast 234	msf/msgcomm/msg_comm$MsgHead
    //   819: getfield 253	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   822: invokevirtual 250	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   825: invokevirtual 790	anyw:a	(J)V
    //   828: aload_0
    //   829: getfield 483	aczw:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   832: aload_2
    //   833: iconst_0
    //   834: invokevirtual 793	com/tencent/mobileqq/app/MessageHandler:a	(Ljava/lang/String;I)Ljava/lang/Object;
    //   837: astore 25
    //   839: aload 25
    //   841: monitorenter
    //   842: aload_0
    //   843: aload_2
    //   844: aload 22
    //   846: lload 16
    //   848: iload 10
    //   850: iload 11
    //   852: iload 12
    //   854: invokespecial 795	aczw:a	(Ljava/lang/String;Lmsf/msgcomm/msg_comm$UinPairMsg;JZZZ)Landroid/util/Pair;
    //   857: astore_2
    //   858: aload_2
    //   859: getfield 799	android/util/Pair:first	Ljava/lang/Object;
    //   862: checkcast 268	java/lang/String
    //   865: astore_1
    //   866: aload_2
    //   867: getfield 802	android/util/Pair:second	Ljava/lang/Object;
    //   870: checkcast 191	java/lang/Integer
    //   873: invokevirtual 805	java/lang/Integer:intValue	()I
    //   876: istore 5
    //   878: aload 25
    //   880: monitorexit
    //   881: iload 10
    //   883: ifne +169 -> 1052
    //   886: aload_0
    //   887: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   890: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:a	()Lbcrg;
    //   893: aload_1
    //   894: invokevirtual 807	bcrg:g	(Ljava/lang/String;)J
    //   897: lstore 18
    //   899: aload_3
    //   900: iconst_0
    //   901: invokeinterface 583 2 0
    //   906: checkcast 228	msf/msgcomm/msg_comm$Msg
    //   909: getfield 232	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   912: invokevirtual 237	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   915: checkcast 234	msf/msgcomm/msg_comm$MsgHead
    //   918: getfield 256	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   921: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   924: i2l
    //   925: lstore 20
    //   927: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   930: ifeq +60 -> 990
    //   933: ldc 89
    //   935: iconst_2
    //   936: new 91	java/lang/StringBuilder
    //   939: dup
    //   940: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   943: ldc 94
    //   945: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: aload_1
    //   949: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: ldc_w 809
    //   955: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: lload 18
    //   960: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   963: ldc_w 811
    //   966: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: lload 20
    //   971: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   974: ldc 107
    //   976: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: iload 4
    //   981: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   984: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   987: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   990: lload 18
    //   992: lconst_0
    //   993: lcmp
    //   994: ifeq +11 -> 1005
    //   997: lload 20
    //   999: lload 18
    //   1001: lcmp
    //   1002: ifge +35 -> 1037
    //   1005: aload_0
    //   1006: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1009: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:a	()Lbcrg;
    //   1012: aload_1
    //   1013: lload 20
    //   1015: lconst_0
    //   1016: invokevirtual 814	bcrg:b	(Ljava/lang/String;JJ)V
    //   1019: iload 4
    //   1021: ifle +16 -> 1037
    //   1024: aload_0
    //   1025: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1028: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:a	()Lbcrg;
    //   1031: aload_1
    //   1032: lload 20
    //   1034: invokevirtual 816	bcrg:g	(Ljava/lang/String;J)V
    //   1037: iload 4
    //   1039: ifne +13 -> 1052
    //   1042: aload_0
    //   1043: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1046: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:a	()Lbcrg;
    //   1049: invokevirtual 818	bcrg:c	()V
    //   1052: iconst_0
    //   1053: istore 8
    //   1055: iload 11
    //   1057: ifeq +441 -> 1498
    //   1060: iload 5
    //   1062: sipush 1006
    //   1065: if_icmpne +24 -> 1089
    //   1068: aload_0
    //   1069: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1072: bipush 11
    //   1074: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1077: checkcast 820	axfr
    //   1080: aload_1
    //   1081: invokeinterface 822 2 0
    //   1086: ifnull +3 -> 1089
    //   1089: iload 5
    //   1091: invokestatic 825	adak:a	(I)I
    //   1094: sipush 1032
    //   1097: if_icmpne +1172 -> 2269
    //   1100: iconst_0
    //   1101: istore 9
    //   1103: aload 22
    //   1105: aload_0
    //   1106: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1109: iload 9
    //   1111: invokestatic 830	avlm:a	(Lmsf/msgcomm/msg_comm$UinPairMsg;Lcom/tencent/mobileqq/app/QQAppInterface;I)Ljava/lang/String;
    //   1114: astore_1
    //   1115: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1118: ifeq +51 -> 1169
    //   1121: ldc 89
    //   1123: iconst_2
    //   1124: new 91	java/lang/StringBuilder
    //   1127: dup
    //   1128: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1131: ldc_w 832
    //   1134: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: aload_1
    //   1138: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: ldc_w 834
    //   1144: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: iload 5
    //   1149: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1152: ldc_w 836
    //   1155: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1158: lload 16
    //   1160: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1163: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1166: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1169: iload 8
    //   1171: ifne +238 -> 1409
    //   1174: aload_1
    //   1175: iload 9
    //   1177: invokestatic 842	com/tencent/mobileqq/data/ConversationInfo:reportPublicaccoutTypeError	(Ljava/lang/String;I)Z
    //   1180: ifeq +229 -> 1409
    //   1183: new 91	java/lang/StringBuilder
    //   1186: dup
    //   1187: sipush 128
    //   1190: invokespecial 844	java/lang/StringBuilder:<init>	(I)V
    //   1193: astore_2
    //   1194: aload_2
    //   1195: ldc_w 845
    //   1198: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1201: ldc_w 847
    //   1204: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: aload_1
    //   1208: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1211: pop
    //   1212: aload_2
    //   1213: ldc_w 849
    //   1216: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: iload 9
    //   1221: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1224: pop
    //   1225: aload_3
    //   1226: ifnull +173 -> 1399
    //   1229: aload_3
    //   1230: invokeinterface 187 1 0
    //   1235: ifle +164 -> 1399
    //   1238: aload_3
    //   1239: iconst_0
    //   1240: invokeinterface 583 2 0
    //   1245: checkcast 228	msf/msgcomm/msg_comm$Msg
    //   1248: astore_3
    //   1249: aload_3
    //   1250: getfield 232	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1253: invokevirtual 238	msf/msgcomm/msg_comm$MsgHead:has	()Z
    //   1256: ifeq +143 -> 1399
    //   1259: aload_3
    //   1260: getfield 232	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1263: invokevirtual 237	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1266: checkcast 234	msf/msgcomm/msg_comm$MsgHead
    //   1269: astore_3
    //   1270: aload_2
    //   1271: ldc_w 851
    //   1274: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: aload_3
    //   1278: getfield 854	msf/msgcomm/msg_comm$MsgHead:msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1281: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1284: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1287: pop
    //   1288: aload_2
    //   1289: ldc_w 856
    //   1292: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: aload_3
    //   1296: getfield 582	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1299: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1302: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1305: pop
    //   1306: aload_2
    //   1307: ldc_w 858
    //   1310: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: aload_3
    //   1314: getfield 579	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1317: invokevirtual 250	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1320: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1323: pop
    //   1324: aload_2
    //   1325: ldc_w 860
    //   1328: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: aload_3
    //   1332: getfield 256	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1335: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1338: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1341: pop
    //   1342: aload_3
    //   1343: getfield 864	msf/msgcomm/msg_comm$MsgHead:c2c_tmp_msg_head	Lmsf/msgcomm/msg_comm$C2CTmpMsgHead;
    //   1346: invokevirtual 867	msf/msgcomm/msg_comm$C2CTmpMsgHead:has	()Z
    //   1349: ifeq +50 -> 1399
    //   1352: aload_3
    //   1353: getfield 864	msf/msgcomm/msg_comm$MsgHead:c2c_tmp_msg_head	Lmsf/msgcomm/msg_comm$C2CTmpMsgHead;
    //   1356: invokevirtual 868	msf/msgcomm/msg_comm$C2CTmpMsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1359: checkcast 866	msf/msgcomm/msg_comm$C2CTmpMsgHead
    //   1362: astore_3
    //   1363: aload_2
    //   1364: ldc_w 870
    //   1367: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1370: aload_3
    //   1371: getfield 871	msf/msgcomm/msg_comm$C2CTmpMsgHead:service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1374: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1377: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1380: pop
    //   1381: aload_2
    //   1382: ldc_w 873
    //   1385: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1388: aload_3
    //   1389: getfield 874	msf/msgcomm/msg_comm$C2CTmpMsgHead:c2c_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1392: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1395: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1398: pop
    //   1399: ldc 89
    //   1401: iconst_1
    //   1402: aload_2
    //   1403: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1406: invokestatic 707	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1409: new 876	android/os/Message
    //   1412: dup
    //   1413: invokespecial 877	android/os/Message:<init>	()V
    //   1416: astore_2
    //   1417: aload_2
    //   1418: iconst_1
    //   1419: putfield 880	android/os/Message:what	I
    //   1422: new 632	android/os/Bundle
    //   1425: dup
    //   1426: invokespecial 633	android/os/Bundle:<init>	()V
    //   1429: astore_3
    //   1430: aload_3
    //   1431: ldc_w 882
    //   1434: lload 16
    //   1436: invokevirtual 650	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1439: aload_3
    //   1440: ldc_w 884
    //   1443: aload_1
    //   1444: invokevirtual 887	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1447: aload_3
    //   1448: ldc_w 889
    //   1451: iload 9
    //   1453: invokevirtual 893	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1456: aload_2
    //   1457: aload_3
    //   1458: invokevirtual 897	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   1461: aload_0
    //   1462: getfield 483	aczw:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1465: astore_3
    //   1466: iload 4
    //   1468: ifgt +121 -> 1589
    //   1471: iconst_1
    //   1472: istore 10
    //   1474: aload_3
    //   1475: aload_2
    //   1476: iload 10
    //   1478: invokevirtual 900	com/tencent/mobileqq/app/MessageHandler:a	(Landroid/os/Message;Z)V
    //   1481: iload 6
    //   1483: iconst_2
    //   1484: if_icmpne +111 -> 1595
    //   1487: aload_0
    //   1488: getfield 61	aczw:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   1491: aload_1
    //   1492: invokeinterface 901 2 0
    //   1497: pop
    //   1498: iload 7
    //   1500: iconst_1
    //   1501: iadd
    //   1502: istore 7
    //   1504: goto -919 -> 585
    //   1507: iconst_0
    //   1508: istore 10
    //   1510: goto -833 -> 677
    //   1513: aload_3
    //   1514: invokeinterface 187 1 0
    //   1519: invokestatic 195	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1522: astore_1
    //   1523: goto -784 -> 739
    //   1526: astore_1
    //   1527: aload 25
    //   1529: monitorexit
    //   1530: aload_1
    //   1531: athrow
    //   1532: astore_1
    //   1533: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1536: ifeq -38 -> 1498
    //   1539: ldc 89
    //   1541: iconst_2
    //   1542: new 91	java/lang/StringBuilder
    //   1545: dup
    //   1546: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1549: ldc_w 903
    //   1552: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1555: aload_1
    //   1556: invokevirtual 456	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1559: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1562: aload_1
    //   1563: invokestatic 618	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1566: goto -68 -> 1498
    //   1569: aload_0
    //   1570: iload 4
    //   1572: aload 22
    //   1574: aload_2
    //   1575: iconst_0
    //   1576: invokespecial 905	aczw:a	(BLmsf/msgcomm/msg_comm$UinPairMsg;Ljava/lang/String;I)I
    //   1579: istore 5
    //   1581: iconst_1
    //   1582: istore 8
    //   1584: aload_2
    //   1585: astore_1
    //   1586: goto -531 -> 1055
    //   1589: iconst_0
    //   1590: istore 10
    //   1592: goto -118 -> 1474
    //   1595: aload_0
    //   1596: getfield 59	aczw:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1599: aload_1
    //   1600: invokeinterface 901 2 0
    //   1605: pop
    //   1606: goto -108 -> 1498
    //   1609: iload 4
    //   1611: ifgt +545 -> 2156
    //   1614: aload_0
    //   1615: getfield 483	aczw:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1618: invokevirtual 906	com/tencent/mobileqq/app/MessageHandler:c	()V
    //   1621: iload 11
    //   1623: ifeq +454 -> 2077
    //   1626: aload_0
    //   1627: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1630: invokevirtual 909	com/tencent/mobileqq/app/QQAppInterface:a	()Ladab;
    //   1633: invokevirtual 913	adab:a	()Ljava/util/Set;
    //   1636: invokeinterface 463 1 0
    //   1641: astore_1
    //   1642: aload_1
    //   1643: invokeinterface 154 1 0
    //   1648: ifeq +414 -> 2062
    //   1651: aload_1
    //   1652: invokeinterface 158 1 0
    //   1657: checkcast 838	com/tencent/mobileqq/data/ConversationInfo
    //   1660: astore_2
    //   1661: aload_2
    //   1662: getfield 916	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1665: ifnull -23 -> 1642
    //   1668: aload_2
    //   1669: getfield 919	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1672: sipush 1036
    //   1675: if_icmpeq -33 -> 1642
    //   1678: aload_2
    //   1679: getfield 919	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1682: invokestatic 825	adak:a	(I)I
    //   1685: sipush 1032
    //   1688: if_icmpeq -46 -> 1642
    //   1691: iload 6
    //   1693: iconst_1
    //   1694: if_icmpne +13 -> 1707
    //   1697: aload_2
    //   1698: getfield 919	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1701: sipush 1008
    //   1704: if_icmpeq -62 -> 1642
    //   1707: iload 6
    //   1709: iconst_2
    //   1710: if_icmpne +13 -> 1723
    //   1713: aload_2
    //   1714: getfield 919	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1717: sipush 1008
    //   1720: if_icmpne -78 -> 1642
    //   1723: iload 6
    //   1725: iconst_2
    //   1726: if_icmpeq +31 -> 1757
    //   1729: aload_0
    //   1730: getfield 59	aczw:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1733: invokeinterface 920 1 0
    //   1738: ifle +19 -> 1757
    //   1741: aload_0
    //   1742: getfield 59	aczw:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1745: aload_2
    //   1746: getfield 916	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1749: invokeinterface 923 2 0
    //   1754: ifne -112 -> 1642
    //   1757: iload 6
    //   1759: iconst_2
    //   1760: if_icmpne +31 -> 1791
    //   1763: aload_0
    //   1764: getfield 61	aczw:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   1767: invokeinterface 920 1 0
    //   1772: ifle +19 -> 1791
    //   1775: aload_0
    //   1776: getfield 61	aczw:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   1779: aload_2
    //   1780: getfield 916	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1783: invokeinterface 923 2 0
    //   1788: ifne -146 -> 1642
    //   1791: aload_2
    //   1792: getfield 919	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1795: invokestatic 414	adak:d	(I)Z
    //   1798: ifeq -156 -> 1642
    //   1801: aload_2
    //   1802: invokestatic 926	adab:c	(Lcom/tencent/mobileqq/data/ConversationInfo;)I
    //   1805: ifle -163 -> 1642
    //   1808: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1811: ifeq +45 -> 1856
    //   1814: ldc 89
    //   1816: iconst_2
    //   1817: new 91	java/lang/StringBuilder
    //   1820: dup
    //   1821: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1824: ldc_w 928
    //   1827: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1830: aload_2
    //   1831: getfield 916	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1834: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1837: ldc_w 930
    //   1840: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1843: aload_2
    //   1844: getfield 919	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1847: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1850: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1853: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1856: aload_2
    //   1857: getfield 916	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1860: invokevirtual 933	java/lang/String:length	()I
    //   1863: iconst_4
    //   1864: if_icmple -222 -> 1642
    //   1867: aload_2
    //   1868: getfield 919	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1871: sipush 1001
    //   1874: if_icmpne +134 -> 2008
    //   1877: aload_0
    //   1878: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1881: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:a	()Lbcrg;
    //   1884: aload_2
    //   1885: getfield 916	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1888: invokevirtual 937	bcrg:n	(Ljava/lang/String;)[B
    //   1891: astore_3
    //   1892: aload_3
    //   1893: ifnull -251 -> 1642
    //   1896: aload_3
    //   1897: arraylength
    //   1898: ifle -256 -> 1642
    //   1901: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1904: ifeq +29 -> 1933
    //   1907: ldc 89
    //   1909: iconst_2
    //   1910: new 91	java/lang/StringBuilder
    //   1913: dup
    //   1914: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1917: ldc_w 939
    //   1920: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1923: aload_3
    //   1924: invokevirtual 456	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1927: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1930: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1933: new 876	android/os/Message
    //   1936: dup
    //   1937: invokespecial 877	android/os/Message:<init>	()V
    //   1940: astore_3
    //   1941: aload_3
    //   1942: iconst_1
    //   1943: putfield 880	android/os/Message:what	I
    //   1946: new 632	android/os/Bundle
    //   1949: dup
    //   1950: invokespecial 633	android/os/Bundle:<init>	()V
    //   1953: astore 22
    //   1955: aload 22
    //   1957: ldc_w 882
    //   1960: ldc2_w 940
    //   1963: invokevirtual 650	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1966: aload 22
    //   1968: ldc_w 884
    //   1971: aload_2
    //   1972: getfield 916	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1975: invokevirtual 887	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1978: aload 22
    //   1980: ldc_w 889
    //   1983: aload_2
    //   1984: getfield 919	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1987: invokevirtual 893	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1990: aload_3
    //   1991: aload 22
    //   1993: invokevirtual 897	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   1996: aload_0
    //   1997: getfield 483	aczw:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2000: aload_3
    //   2001: iconst_1
    //   2002: invokevirtual 900	com/tencent/mobileqq/app/MessageHandler:a	(Landroid/os/Message;Z)V
    //   2005: goto -363 -> 1642
    //   2008: aload_2
    //   2009: getfield 919	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   2012: sipush 10002
    //   2015: if_icmpne +21 -> 2036
    //   2018: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2021: ifeq -88 -> 1933
    //   2024: ldc 89
    //   2026: iconst_2
    //   2027: ldc_w 943
    //   2030: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2033: goto -100 -> 1933
    //   2036: aload_2
    //   2037: getfield 946	com/tencent/mobileqq/data/ConversationInfo:isImax	Z
    //   2040: ifeq -107 -> 1933
    //   2043: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2046: ifeq -404 -> 1642
    //   2049: ldc_w 948
    //   2052: iconst_2
    //   2053: ldc_w 950
    //   2056: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2059: goto -417 -> 1642
    //   2062: iload 6
    //   2064: iconst_2
    //   2065: if_icmpne +147 -> 2212
    //   2068: aload_0
    //   2069: getfield 61	aczw:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   2072: invokeinterface 953 1 0
    //   2077: invokestatic 959	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   2080: invokevirtual 962	com/tencent/util/MsgAutoMonitorUtil:markC2CFinishTime	()V
    //   2083: iload 6
    //   2085: tableswitch	default:+27 -> 2112, 0:+139->2224, 1:+160->2245, 2:+172->2257
    //   2113: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2116: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:a	()Lbcrg;
    //   2119: invokevirtual 964	bcrg:i	()V
    //   2122: aload_0
    //   2123: getfield 483	aczw:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2126: invokevirtual 740	com/tencent/mobileqq/app/MessageHandler:a	()Z
    //   2129: ifeq +27 -> 2156
    //   2132: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2135: ifeq +12 -> 2147
    //   2138: ldc 89
    //   2140: iconst_2
    //   2141: ldc_w 966
    //   2144: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2147: aload_0
    //   2148: getfield 483	aczw:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2151: iconst_0
    //   2152: iconst_0
    //   2153: invokevirtual 969	com/tencent/mobileqq/app/MessageHandler:a	(ZI)V
    //   2156: invokestatic 680	java/lang/System:currentTimeMillis	()J
    //   2159: lload 14
    //   2161: lsub
    //   2162: lstore 14
    //   2164: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2167: ifeq +36 -> 2203
    //   2170: ldc 89
    //   2172: iconst_2
    //   2173: new 91	java/lang/StringBuilder
    //   2176: dup
    //   2177: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   2180: ldc_w 971
    //   2183: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2186: lload 14
    //   2188: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2191: ldc_w 973
    //   2194: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2197: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2200: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2203: ldc_w 975
    //   2206: lload 14
    //   2208: invokestatic 977	aosq:a	(Ljava/lang/String;J)V
    //   2211: return
    //   2212: aload_0
    //   2213: getfield 59	aczw:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   2216: invokeinterface 953 1 0
    //   2221: goto -144 -> 2077
    //   2224: aload_0
    //   2225: sipush 4016
    //   2228: iconst_1
    //   2229: aconst_null
    //   2230: invokevirtual 665	aczw:a	(IZLjava/lang/Object;)V
    //   2233: aload_0
    //   2234: sipush 4001
    //   2237: iconst_1
    //   2238: aconst_null
    //   2239: invokevirtual 665	aczw:a	(IZLjava/lang/Object;)V
    //   2242: goto -130 -> 2112
    //   2245: aload_0
    //   2246: sipush 4001
    //   2249: iconst_1
    //   2250: aconst_null
    //   2251: invokevirtual 665	aczw:a	(IZLjava/lang/Object;)V
    //   2254: goto -142 -> 2112
    //   2257: aload_0
    //   2258: sipush 4016
    //   2261: iconst_1
    //   2262: aconst_null
    //   2263: invokevirtual 665	aczw:a	(IZLjava/lang/Object;)V
    //   2266: goto -154 -> 2112
    //   2269: iload 5
    //   2271: istore 9
    //   2273: goto -1170 -> 1103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2276	0	this	aczw
    //   0	2276	1	paramToServiceMsg	ToServiceMsg
    //   0	2276	2	paramFromServiceMsg	FromServiceMsg
    //   0	2276	3	paramObject	Object
    //   1	1609	4	b1	byte
    //   4	2266	5	k	int
    //   348	1736	6	m	int
    //   583	920	7	n	int
    //   1053	530	8	i1	int
    //   1101	1171	9	i2	int
    //   381	1210	10	bool1	boolean
    //   17	1605	11	bool2	boolean
    //   43	810	12	bool3	boolean
    //   30	493	13	bool4	boolean
    //   48	2159	14	l1	long
    //   641	794	16	l2	long
    //   897	103	18	l3	long
    //   925	108	20	l4	long
    //   132	1860	22	localObject1	Object
    //   70	680	23	localStringBuilder	StringBuilder
    //   254	349	24	localList	List
    // Exception table:
    //   from	to	target	type
    //   842	881	1526	finally
    //   1527	1530	1526	finally
    //   828	842	1532	java/lang/Exception
    //   1530	1532	1532	java/lang/Exception
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    paramFromServiceMsg = new HashMap(1);
    paramFromServiceMsg.put("KEYWORD", paramToServiceMsg.extraData.getString("keyword"));
    paramFromServiceMsg.put("SEARCHSEQUENCE", Long.valueOf(paramToServiceMsg.extraData.getLong("sequence")));
    paramFromServiceMsg.put("LOADTYPE", Integer.valueOf(paramToServiceMsg.extraData.getInt("loadType")));
    int k = paramToServiceMsg.extraData.getInt("retryIndex");
    if ((!paramBoolean) && (k < 2))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.C2CMessageProcessor", 2, "handleSearchRoamMsgInCloudTimeOutAndError retry index:" + k);
      }
      paramToServiceMsg.extraData.putInt("retryIndex", k + 1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendPbReq(paramToServiceMsg);
      return;
    }
    a(8015, false, paramFromServiceMsg);
  }
  
  private void a(String paramString, int paramInt, long paramLong, msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq)
  {
    if (paramLong == 0L) {}
    for (;;)
    {
      return;
      if (antf.G.equals(paramString))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
        return;
      }
      if ((paramInt != 1001) || (Long.valueOf(paramString).longValue() <= antf.g))
      {
        if ((paramInt == 1001) && ((adak.c(paramString)) || (adak.d(paramString))))
        {
          if (adak.e(paramString))
          {
            asax.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, null);
            return;
          }
          if (adak.d(paramString))
          {
            asax.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            return;
          }
          asax.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, null);
          return;
        }
        Object localObject;
        long l;
        if (paramInt == 1006)
        {
          localObject = bhlg.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label360;
          }
          l = Long.valueOf((String)localObject).longValue();
        }
        while (l != -1L) {
          if (paramInt == 10007)
          {
            avlm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPbMsgReadedReportReq, paramString, paramLong);
            return;
            l = Long.valueOf(paramString).longValue();
          }
          else
          {
            localObject = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
            ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).peer_uin.set(l);
            ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).last_read_time.set((int)paramLong);
            if (paramInt == 1024)
            {
              paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramString);
              if (paramString != null)
              {
                if (QLog.isDevelopLevel()) {
                  QLog.d("Q.msg.sendReadConfirm_PB", 4, "Readcomfirmed------->Sig:" + bhml.a(paramString) + ",length:" + paramString.length);
                }
                ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).crm_sig.set(ByteStringMicro.copyFrom(paramString));
              }
            }
            paramString = new msg_svc.PbC2CReadedReportReq();
            paramString.pair_info.add((MessageMicro)localObject);
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
            if (localObject != null) {
              paramString.sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject));
            }
            paramPbMsgReadedReportReq.c2c_read_report.set(paramString);
            return;
            label360:
            l = -1L;
          }
        }
      }
    }
  }
  
  private void a(List<msg_comm.Msg> paramList1, List<msg_comm.Msg> paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---C2CMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:").append(paramList1.size()).append(" outListSize:").append(paramList2.size());
      QLog.d("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
    }
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!localMsgHead.c2c_cmd.has()) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_C2CPush: no C2CCmd.");
      }
    }
    long l1;
    long l2;
    int k;
    int m;
    Object localObject1;
    long l7;
    Object localObject2;
    boolean bool2;
    for (;;)
    {
      return;
      l1 = localMsgHead.c2c_cmd.get();
      l2 = localMsgHead.from_uin.get();
      long l3 = localMsgHead.to_uin.get();
      long l4 = localMsgHead.msg_seq.get();
      long l5 = localMsgHead.msg_time.get();
      long l6 = localMsgHead.msg_uid.get();
      k = localMsgHead.user_active.get();
      m = localMsgHead.from_instid.get();
      if (paramFromServiceMsg.getUin() == null)
      {
        localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        l7 = ((Long)localObject1).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_C2CPush:fromUin:" + l2 + ",toUin:" + l3 + ",msgTime:" + l5 + ",msgSeq:" + l4 + ",msgUid:" + l6 + ",userActive:" + k + ",fromInstid:" + m + ",hasAppShare:" + paramMsg.appshare_info.has() + ",hasMsgBody:" + paramMsg.msg_body.has());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_Int = k;
        localObject1 = new ArrayList();
      }
      try
      {
        localObject2 = new bcre(l7, l2, true, false, false, false);
        ((bcre)localObject2).h = true;
        paramMsg = a(paramMsg, (bcsb)localObject2);
        aoci.a(paramMsg);
        if ((paramMsg != null) && (paramMsg.size() != 0))
        {
          a(paramMsg, (ArrayList)localObject1, true);
          paramMsg = new ArrayList();
          localObject2 = new ArrayList();
          if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
          {
            m = ((ArrayList)localObject1).size();
            k = 0;
            for (;;)
            {
              if (k < m)
              {
                localMessageRecord = (MessageRecord)((ArrayList)localObject1).get(k);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_C2CPush after analysis mr.senderuin: " + localMessageRecord.senderuin + " mr.msgtype: " + localMessageRecord.msgtype + " mr.frienduin: " + localMessageRecord.frienduin + " mr.shmsgseq: " + localMessageRecord.shmsgseq + " mr.time:" + localMessageRecord.time + " mr.msg: " + localMessageRecord.getLogColorContent());
                }
                if ((localMessageRecord.frienduin == null) || (localMessageRecord.frienduin.length() <= 2))
                {
                  k += 1;
                  continue;
                  localObject1 = Long.valueOf(paramFromServiceMsg.getUin());
                }
              }
            }
          }
        }
      }
      catch (Exception paramMsg)
      {
        for (;;)
        {
          MessageRecord localMessageRecord;
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handleMsgPush_PB_C2CPush decodeSinglePBMsg_C2C error,", paramMsg);
          }
          paramMsg = null;
          continue;
          localMessageRecord.isread = false;
          ((ArrayList)localObject2).add(localMessageRecord);
          DelMsgInfo localDelMsgInfo = new DelMsgInfo();
          localDelMsgInfo.lFromUin = Long.parseLong(localMessageRecord.senderuin);
          localDelMsgInfo.shMsgSeq = ((short)(int)localMessageRecord.shmsgseq);
          localDelMsgInfo.uMsgTime = localMessageRecord.time;
          paramMsg.add(localDelMsgInfo);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((List)localObject2);
        bool2 = aoci.a((ArrayList)localObject2);
        k = adak.a((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (!bool2) {
          break label858;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop) {}
    label858:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((QQMessageFacade)localObject1).a((ArrayList)localObject2, String.valueOf(l7), bool1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMsgHead.msg_seq.get());
      m = paramFromServiceMsg.getRequestSsoSeq();
      paramFromServiceMsg = paramPbPushMsg.bytes_push_token.get().toStringUtf8();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, new Object[] { "----------handleMsgPush_PB_C2CPush get Push token = ", paramFromServiceMsg, " and use ", "OnlinePush.RespPush", " send back to server" });
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l2, paramMsg, paramPbPushMsg.svrip.get(), m, paramPbPushMsg);
      if (l1 == 127L) {
        break;
      }
      a("handleMsgPush_PB_C2CPush", true, k, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2), false);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b((ArrayList)localObject2);
      return;
    }
  }
  
  private void a(msg_comm.Msg paramMsg, ArrayList<MessageRecord> paramArrayList, bcre parambcre, MessageHandler paramMessageHandler)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a().a().iterator();
    while (localIterator.hasNext()) {
      ((bcsi)localIterator.next()).a(paramMessageHandler, paramMsg, paramArrayList, parambcre);
    }
  }
  
  private void a(msg_svc.PbSearchRoamMsgInCloudResp paramPbSearchRoamMsgInCloudResp, oidb_c2c_searcher.RspBody paramRspBody, int paramInt1, ToServiceMsg paramToServiceMsg, int paramInt2, HashMap<String, Object> paramHashMap)
  {
    List localList = paramPbSearchRoamMsgInCloudResp.msg.get();
    if (localList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud pb error search result == null");
      }
      return;
    }
    ArrayList localArrayList2 = new ArrayList();
    a(localList, localArrayList2);
    long l3 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    bcre localbcre = new bcre(l3, 0L, true, true, false, false);
    localbcre.h = true;
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator = localArrayList2.iterator();
    label209:
    label252:
    long l1;
    long l2;
    while (localIterator.hasNext())
    {
      paramPbSearchRoamMsgInCloudResp = (msg_comm.Msg)localIterator.next();
      if (paramPbSearchRoamMsgInCloudResp != null) {}
      for (;;)
      {
        try
        {
          if ((paramPbSearchRoamMsgInCloudResp.msg_head.has()) && (paramPbSearchRoamMsgInCloudResp.msg_body.has())) {
            break label252;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          localObject = new StringBuilder().append("decodeSinglePBMsg_C2C return : ");
          if (paramPbSearchRoamMsgInCloudResp != null) {
            break label209;
          }
          paramPbSearchRoamMsgInCloudResp = " msg=null";
          QLog.d("Q.msg.C2CMessageProcessor", 2, paramPbSearchRoamMsgInCloudResp);
        }
        catch (Exception paramPbSearchRoamMsgInCloudResp) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud decodeSinglePBMsg_C2C error,", paramPbSearchRoamMsgInCloudResp);
        break;
        paramPbSearchRoamMsgInCloudResp = " msg.msg_head:" + paramPbSearchRoamMsgInCloudResp.msg_head + " msg.msg_body:" + paramPbSearchRoamMsgInCloudResp.msg_body.has();
      }
      Object localObject = (msg_comm.MsgHead)paramPbSearchRoamMsgInCloudResp.msg_head.get();
      l1 = ((msg_comm.MsgHead)localObject).to_uin.get();
      l2 = ((msg_comm.MsgHead)localObject).from_uin.get();
      if ((l1 == l3) || (l2 == l3)) {
        break label695;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C msg uin not selfUin and toUin : ");
      }
    }
    for (;;)
    {
      localbcre.jdField_e_of_type_Long = l1;
      paramPbSearchRoamMsgInCloudResp = a(paramPbSearchRoamMsgInCloudResp, localbcre);
      if ((paramPbSearchRoamMsgInCloudResp == null) || (paramPbSearchRoamMsgInCloudResp.isEmpty())) {
        break;
      }
      localArrayList1.addAll(paramPbSearchRoamMsgInCloudResp);
      break;
      label581:
      do
      {
        break;
        if (localArrayList1.size() > 0) {
          Collections.sort(localArrayList1, new adaa(this));
        }
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud resultList size:" + localList.size() + ",outList size:" + localArrayList2.size() + ",loopList size:" + localArrayList1.size());
        }
        if (paramRspBody.friends.has())
        {
          paramPbSearchRoamMsgInCloudResp = paramRspBody.friends.get();
          if (paramPbSearchRoamMsgInCloudResp == null) {
            break label581;
          }
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud friendsInfo size:" + paramPbSearchRoamMsgInCloudResp.size());
          }
        }
        for (;;)
        {
          if ((localArrayList1.size() == 0) && (paramInt1 != 1))
          {
            paramInt1 = paramToServiceMsg.extraData.getInt("retryIndex");
            if (paramInt1 < 4)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt2, null, paramToServiceMsg.extraData.getString("keyword"), paramToServiceMsg.extraData.getLong("sequence"), paramPbSearchRoamMsgInCloudResp, paramInt1 + 1, 0L);
              return;
              paramPbSearchRoamMsgInCloudResp = null;
              break;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud friendsInfo == null");
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud retry extend 5 times, do not request again");
            }
            paramHashMap.put("SEARCHINFO", paramPbSearchRoamMsgInCloudResp);
            a(8015, false, paramHashMap);
            return;
          }
        }
        paramHashMap.put("SEARCHINFO", paramPbSearchRoamMsgInCloudResp);
        paramHashMap.put("SEARCHRESULT", localArrayList1);
        if (paramInt1 == 1) {}
        for (boolean bool = true;; bool = false)
        {
          paramHashMap.put("SEARCHCOMPLETE", Boolean.valueOf(bool));
          a(8015, true, paramHashMap);
          return;
        }
      } while (l1 != l3);
      label695:
      l1 = l2;
    }
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayOfByte1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramArrayOfByte1);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(false);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.c(false);
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayOfByte1);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramArrayOfByte2);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.c(false);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = new Bundle();
    paramFromServiceMsg.putLong("BEGTIME", paramToServiceMsg.extraData.getLong("lBeginTime"));
    paramFromServiceMsg.putBoolean("FETCH_MORE", paramToServiceMsg.extraData.getBoolean("fetchMore"));
    a(1004, false, paramFromServiceMsg);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = new msg_svc.PbGetRoamMsgResp();
    try
    {
      paramFromServiceMsg = (msg_svc.PbGetRoamMsgResp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      localObject4 = Long.valueOf(paramToServiceMsg.extraData.getLong("lBeginTime"));
      bool1 = paramToServiceMsg.extraData.getBoolean("fetchMore");
      n = paramToServiceMsg.extraData.getInt("fetchNum");
      bool2 = paramToServiceMsg.extraData.getBoolean("preloadType");
      bool3 = paramToServiceMsg.extraData.getBoolean("notify", true);
      paramObject = new Bundle();
      paramObject.putLong("BEGTIME", ((Long)localObject4).longValue());
      paramObject.putBoolean("FETCH_MORE", bool1);
      paramObject.putInt("MSG_COUNT", n);
      paramObject.putString("PEER_UIN", paramToServiceMsg.extraData.getString("peerUin"));
      paramObject.putBoolean("IS_PRELOAD_TYPE", bool2);
      if (paramFromServiceMsg != null)
      {
        str = String.valueOf(paramFromServiceMsg.peer_uin.get());
        m = paramFromServiceMsg.result.get();
        localObject1 = paramFromServiceMsg.msg.get();
        if (localObject1 == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.remove(str);
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg code=" + m + ", msgList is null !");
          }
          a(1004, false, paramObject);
          return;
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg InvalidProtocolBufferMicroException ! ", paramFromServiceMsg);
        }
        paramFromServiceMsg = null;
      }
    }
    catch (OutOfMemoryError paramFromServiceMsg)
    {
      Object localObject4;
      boolean bool1;
      int n;
      boolean bool2;
      boolean bool3;
      String str;
      int m;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", paramFromServiceMsg);
        }
        paramFromServiceMsg = null;
      }
      ArrayList localArrayList = new ArrayList();
      a((List)localObject1, localArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg begTime: " + localObject4 + ", code=" + m + " ,errMsg=" + paramFromServiceMsg.errmsg.get() + ", msgList.size()=" + localArrayList.size() + ",peerUin=" + str + ",time=" + paramFromServiceMsg.last_msgtime.get() + ",fetchMore:" + bool1 + ",fetchNum: " + n);
      }
      Object localObject1 = (aocm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
      int k = 0;
      if (((m != 0) && (m != 1)) || (m == 0)) {}
      for (;;)
      {
        try
        {
          if (localArrayList.size() > 0)
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(str)) {
              continue;
            }
            localObject2 = (List)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.get(str);
            if (((List)localObject2).size() == 0) {
              ((List)localObject2).addAll(0, localArrayList);
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(str, ((Long)localObject4).longValue(), paramFromServiceMsg.last_msgtime.get(), paramToServiceMsg.extraData.getLong("lEndTime"), (short)0, paramFromServiceMsg.random.get(), 1, ((aocm)localObject1).a(), ((aocm)localObject1).b(), paramToServiceMsg.extraData.getBoolean("fetchMore"), n, bool2, bool3);
            return;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg exception ! ", paramToServiceMsg);
          }
          k = 0;
          if (k != 0) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.remove(str);
          paramObject.putInt("SVR_CODE", m);
          if (paramFromServiceMsg.errmsg.has()) {
            paramObject.putString("SVR_MSG", paramFromServiceMsg.errmsg.get());
          }
          a(1004, false, paramObject);
          return;
          if ((((msg_comm.MsgHead)((msg_comm.Msg)((List)localObject2).get(0)).msg_head.get()).msg_uid.get() == ((msg_comm.MsgHead)((msg_comm.Msg)localArrayList.get(0)).msg_head.get()).msg_uid.get()) && (((msg_comm.MsgHead)((msg_comm.Msg)((List)localObject2).get(0)).msg_head.get()).msg_seq.get() == ((msg_comm.MsgHead)((msg_comm.Msg)localArrayList.get(0)).msg_head.get()).msg_seq.get())) {
            continue;
          }
          ((List)localObject2).addAll(0, localArrayList);
          continue;
        }
        catch (OutOfMemoryError paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", paramToServiceMsg);
          }
          k = 0;
          continue;
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.put(str, localArrayList);
          continue;
        }
        localArrayList = new ArrayList(localArrayList);
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(str))
        {
          localArrayList.addAll((Collection)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.get(str));
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.remove(str);
        }
        if (localArrayList.isEmpty())
        {
          new Object[2][0] = Boolean.valueOf(true);
          paramObject.putBoolean("NO_MSG", Boolean.TRUE.booleanValue());
          a(1004, false, paramObject);
          return;
        }
        long l1 = paramToServiceMsg.extraData.getLong("lBeginTime");
        long l2 = paramToServiceMsg.extraData.getLong("lEndTime");
        Object localObject2 = new ArrayList();
        Object localObject3 = localArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject5 = (msg_comm.Msg)((Iterator)localObject3).next();
          if (!((msg_comm.Msg)localObject5).msg_head.has())
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg msg msg_head = null");
            }
          }
          else
          {
            long l3 = ((msg_comm.MsgHead)((msg_comm.Msg)localObject5).msg_head.get()).msg_time.get();
            if ((l3 >= l1) && (l3 <= l2)) {
              ((ArrayList)localObject2).add(localObject5);
            }
          }
        }
        Object localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, (List)localObject2, Long.valueOf(str).longValue(), true);
        localObject3 = new ArrayList();
        l1 = Long.parseLong(str);
        Object localObject6;
        if (!((ArrayList)localObject2).isEmpty())
        {
          localObject6 = (msg_comm.Msg)((ArrayList)localObject2).get(0);
          l1 = aoci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((msg_comm.MsgHead)((msg_comm.Msg)localObject6).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject6).msg_head.get()).to_uin.get(), paramFromServiceMsg.peer_uin.get());
        }
        ((ArrayList)localObject3).addAll((Collection)a((List)localObject2, (List)localObject5, l1, ((Long)localObject4).longValue(), paramToServiceMsg.extraData.getLong("lEndTime")).second);
        localObject4 = new bcre(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), l1, true, true, false, false);
        ((bcre)localObject4).h = true;
        localObject5 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (msg_comm.Msg)((Iterator)localObject5).next();
          try
          {
            localObject6 = a((msg_comm.Msg)localObject6, (bcsb)localObject4);
            if ((localObject6 == null) || (((List)localObject6).isEmpty())) {
              continue;
            }
            ((ArrayList)localObject3).addAll((Collection)localObject6);
          }
          catch (Exception localException2) {}
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException2);
          }
        }
        if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
        {
          Collections.sort((List)localObject3, new aczy(this));
          if (localObject1 == null) {}
        }
        try
        {
          ((aocm)localObject1).a((List)localObject3, str, bool3);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a((ArrayList)localObject3, false);
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()));
          if ((localObject4 == null) || (((Long)((Pair)localObject4).first).longValue() > paramFromServiceMsg.last_msgtime.get())) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()), paramToServiceMsg.extraData.getLong("lBeginTime"), 0L);
          }
          ((aocm)localObject1).a().b(str, paramToServiceMsg.extraData.getLong("lBeginTime"), 3);
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg resList size = " + localArrayList.size() + ", dayList size = " + ((ArrayList)localObject2).size() + ", loopList size=" + ((ArrayList)localObject3).size());
          }
          paramObject.putInt("MSG_COUNT", n - ((ArrayList)localObject3).size());
          a(1004, true, paramObject);
          k = 1;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg exception ! ", localException1);
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", localOutOfMemoryError);
            }
          }
        }
      }
      a(1004, false, paramObject);
    }
  }
  
  private void b(ArrayList<MessageRecord> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord.msgtype == -3006) || (localMessageRecord.msgtype == -5004))
      {
        PAMessage localPAMessage = agkq.a(localMessageRecord);
        if ((localPAMessage != null) && (localPAMessage.mMsgId > 0L)) {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localMessageRecord.frienduin, "mp_msg_sys_15", "msg_get", 0, 1, 0, Long.toString(localPAMessage.mMsgId), "", "", "");
        }
      }
      if ((localMessageRecord.mQidianMasterUin != 0L) && (!TextUtils.isEmpty(localMessageRecord.mQidianTipText)) && (localMessageRecord.mIsShowQidianTips == 1)) {
        ThreadManager.executeOnSubThread(new C2CMessageProcessor.4(this, localMessageRecord));
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramArrayList);
  }
  
  private void b(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!localMsgHead.c2c_cmd.has()) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_SlaveMaster: no C2CCmd.");
      }
    }
    long l1;
    long l2;
    int k;
    long l7;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    MessageRecord localMessageRecord;
    Object localObject2;
    int n;
    for (;;)
    {
      return;
      l1 = localMsgHead.c2c_cmd.get();
      l2 = localMsgHead.from_uin.get();
      long l3 = localMsgHead.to_uin.get();
      long l4 = localMsgHead.msg_seq.get();
      long l5 = localMsgHead.msg_time.get();
      long l6 = localMsgHead.msg_uid.get();
      k = localMsgHead.user_active.get();
      m = localMsgHead.from_instid.get();
      Object localObject1;
      ArrayList localArrayList1;
      if (paramFromServiceMsg.getUin() == null)
      {
        localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        l7 = ((Long)localObject1).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_SlaveMaster:fromUin:" + l2 + ",toUin:" + l3 + ",msgTime:" + l5 + ",msgSeq:" + l4 + ",msgUid:" + l6 + ",userActive:" + k + ",fromInstid:" + m + ",hasAppShare:" + paramMsg.appshare_info.has() + ",hasMsgBody:" + paramMsg.msg_body.has());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_Int = k;
        localArrayList1 = new ArrayList();
      }
      try
      {
        localObject1 = new bcre(l7, l3, true, false, false, false);
        ((bcre)localObject1).h = true;
        localObject1 = a(paramMsg, (bcsb)localObject1);
        aoci.a((List)localObject1);
        if ((localObject1 != null) && (((List)localObject1).size() != 0))
        {
          if (localArrayList1 != null) {
            a((List)localObject1, localArrayList1, true);
          }
          k = 0;
          localObject1 = null;
          localArrayList2 = new ArrayList();
          localArrayList3 = new ArrayList();
          if ((localArrayList1 == null) || (localArrayList1.size() <= 0)) {
            break label1514;
          }
          int i5 = localArrayList1.size();
          int i3 = 0;
          for (;;)
          {
            if (i3 >= i5) {
              break label1368;
            }
            localMessageRecord = (MessageRecord)localArrayList1.get(i3);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_SlaveMaster after analysis mr.senderuin: " + localMessageRecord.senderuin + " mr.msgtype: " + localMessageRecord.msgtype + " mr.frienduin: " + localMessageRecord.frienduin + " mr.shmsgseq: " + localMessageRecord.shmsgseq + " mr.time:" + localMessageRecord.time + " mr.msg: " + localMessageRecord.getLogColorContent());
            }
            localObject3 = localObject1;
            i1 = k;
            if (localMessageRecord.frienduin != null)
            {
              if (localMessageRecord.frienduin.length() > 2) {
                break;
              }
              i1 = k;
              localObject3 = localObject1;
            }
            i3 += 1;
            localObject1 = localObject3;
            k = i1;
          }
          localObject1 = Long.valueOf(paramFromServiceMsg.getUin());
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException1);
          }
          localObject2 = null;
        }
        localMessageRecord.isread = true;
        localMessageRecord.issend = 2;
        n = 0;
        if (!(localMessageRecord instanceof MessageForStructing)) {
          break label1331;
        }
      }
    }
    MessageForStructing localMessageForStructing = (MessageForStructing)localMessageRecord;
    int m = n;
    Object localObject3 = localObject2;
    int i1 = k;
    if (localMessageForStructing != null)
    {
      m = n;
      localObject3 = localObject2;
      i1 = k;
      if (localMessageForStructing.structingMsg != null)
      {
        m = n;
        localObject3 = localObject2;
        i1 = k;
        if (localMessageForStructing.structingMsg.mMsgServiceID == 128) {
          localObject3 = localMessageRecord.getExtInfoFromExtStr("key_message_extra_info_flag");
        }
      }
    }
    for (;;)
    {
      try
      {
        m = Integer.parseInt((String)localObject3);
        if ((m & 0x4) == 4)
        {
          n = 1;
          i1 = k;
          if (n != 0)
          {
            localMessageForStructing.extraflag = 32768;
            localMessageRecord.issend = 1;
            localMessageForStructing.saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(m & 0xFFFFFFFB));
            localObject2 = localMessageForStructing.frienduin;
            i1 = 1;
          }
          localMessageForStructing.isCheckNeedShowInListTypeMsg = true;
          k = -1;
          n = k;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          try
          {
            localObject3 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
            m = k;
            if (localObject3 != null)
            {
              m = k;
              n = k;
              if (((List)localObject3).size() > 0)
              {
                i4 = 0;
                m = k;
                n = k;
                if (i4 < ((List)localObject3).size())
                {
                  n = k;
                  localElem = (im_msg_body.Elem)((List)localObject3).get(i4);
                  n = k;
                  if (!localElem.general_flags.has()) {
                    continue;
                  }
                  n = k;
                  bool = localElem.general_flags.bytes_pb_reserve.has();
                  if (!bool) {
                    continue;
                  }
                  i2 = k;
                  n = k;
                }
              }
            }
          }
          catch (Throwable localThrowable2)
          {
            int i4;
            im_msg_body.Elem localElem;
            boolean bool;
            int i2;
            generalflags.ResvAttr localResvAttr;
            Object localObject4;
            m = n;
            continue;
            continue;
          }
          try
          {
            localResvAttr = new generalflags.ResvAttr();
            i2 = k;
            n = k;
            localResvAttr.mergeFrom(localElem.general_flags.bytes_pb_reserve.get().toByteArray());
            i2 = k;
            n = k;
            if (!localResvAttr.uint32_show_in_msg_list.has()) {
              continue;
            }
            i2 = k;
            n = k;
            k = localResvAttr.uint32_show_in_msg_list.get();
            m = k;
            i2 = k;
            n = k;
            if (QLog.isColorLevel())
            {
              i2 = k;
              n = k;
              QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_SlaveMaster has uint32ShowInMsgList:" + k);
              m = k;
            }
            if (m != 1) {
              continue;
            }
            bool = true;
            localMessageForStructing.needNeedShowInList = bool;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_SlaveMaster isCheckNeedShowInListTypeMsg:" + localMessageForStructing.isCheckNeedShowInListTypeMsg + " needNeedShowInList:" + localMessageForStructing.needNeedShowInList + " uint32ShowInMsgList:" + m);
            }
            m = 1;
            localObject3 = localObject2;
            if (m == 0) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.time);
            }
            localArrayList3.add(localMessageRecord);
            localObject2 = new DelMsgInfo();
            ((DelMsgInfo)localObject2).lFromUin = Long.parseLong(localMessageRecord.senderuin);
            ((DelMsgInfo)localObject2).shMsgSeq = ((short)(int)localMessageRecord.shmsgseq);
            ((DelMsgInfo)localObject2).uMsgTime = localMessageRecord.time;
            localArrayList2.add(localObject2);
          }
          catch (Exception localException2)
          {
            k = i2;
            try
            {
              QLog.e("msgFold", 1, "prase ResvAttr error, ", localException2);
            }
            catch (Throwable localThrowable1)
            {
              m = k;
            }
          }
        }
        localNumberFormatException = localNumberFormatException;
        localNumberFormatException.printStackTrace();
        m = 0;
        continue;
        n = 0;
        continue;
      }
      i4 += 1;
      continue;
      QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C: ", localThrowable1);
      continue;
      bool = false;
      continue;
      label1331:
      m = n;
      localObject4 = localObject2;
      i1 = k;
      if (localMessageRecord.msgtype == -10000)
      {
        m = 1;
        localObject4 = localObject2;
        i1 = k;
      }
    }
    for (;;)
    {
      label1368:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localArrayList3);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localArrayList3, String.valueOf(l7), false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMsgHead.msg_seq.get());
      m = paramFromServiceMsg.getRequestSsoSeq();
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l2, localArrayList2, paramPbPushMsg.svrip.get(), m, null);
      if (l1 == 127L) {
        break;
      }
      a("handleMsgPush_PB_SlaveMaster", true, 0, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(false), false);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(localArrayList3);
      if ((k == 0) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        break;
      }
      bcsa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2);
      return;
      label1514:
      k = 0;
      localObject2 = null;
    }
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.msgUid, paramMessageRecord.shmsgseq);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsgInOneDay ");
    }
    paramFromServiceMsg = new msg_svc.PbGetOneDayRoamMsgResp();
    Bundle localBundle;
    long l2;
    int k;
    long l1;
    try
    {
      paramFromServiceMsg = (msg_svc.PbGetOneDayRoamMsgResp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      localBundle = paramToServiceMsg.extraData.getBundle("context");
      paramObject = null;
      l2 = 0L;
      if (paramFromServiceMsg == null) {
        break label683;
      }
      k = paramFromServiceMsg.result.get();
      Object localObject = paramFromServiceMsg.msg.get();
      paramToServiceMsg = new ArrayList();
      a((List)localObject, paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsgInOneDay code=" + k + ", complete=" + paramFromServiceMsg.iscomplete.get() + " ,respRandom:" + paramFromServiceMsg.random.get() + ", lastMsgTime:" + paramFromServiceMsg.last_msgtime.get() + ", msgList.size()=" + paramToServiceMsg.size() + ", context" + localBundle);
      }
      if (k != 0) {
        break label684;
      }
      paramObject = new ArrayList();
      try
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramToServiceMsg, paramFromServiceMsg.peer_uin.get(), true);
        if (localObject != null) {
          paramObject.addAll((Collection)localObject);
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          bcre localbcre;
          Iterator localIterator;
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "FileMsg filter error,", localException1);
          }
        }
      }
      l1 = paramFromServiceMsg.peer_uin.get();
      if (!paramToServiceMsg.isEmpty())
      {
        localObject = (msg_comm.Msg)paramToServiceMsg.get(0);
        l1 = aoci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).to_uin.get(), paramFromServiceMsg.peer_uin.get());
      }
      localbcre = new bcre(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), l1, true, true, false, false);
      localbcre.h = true;
      localIterator = paramToServiceMsg.iterator();
      paramToServiceMsg = null;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label481;
        }
        localObject = (msg_comm.Msg)localIterator.next();
        try
        {
          localObject = a((msg_comm.Msg)localObject, localbcre);
          paramToServiceMsg = (ToServiceMsg)localObject;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException2);
            }
          }
        }
        if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0)) {
          paramObject.addAll(paramToServiceMsg);
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = null;
      }
    }
    label481:
    if (paramObject.size() > 0)
    {
      Collections.sort(paramObject, new aczz(this));
      l1 = ((MessageRecord)paramObject.get(0)).time;
    }
    for (paramToServiceMsg = paramObject;; paramToServiceMsg = null)
    {
      for (;;)
      {
        boolean bool3;
        boolean bool1;
        label555:
        boolean bool2;
        if (localBundle != null)
        {
          l2 = localBundle.getLong("UIN", 0L);
          bool3 = localBundle.getBoolean("canUpdateEct", true);
          if (paramFromServiceMsg.iscomplete.get() == 0) {
            break label726;
          }
          bool1 = true;
          if ((k != 0) && (k != 1) && (k != 4)) {
            break label732;
          }
          bool2 = true;
          label575:
          if ((!bool2) || (!bool3)) {
            break label775;
          }
          if (!bool1) {
            break label738;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(l2), 0L, 0L);
          label607:
          localBundle.putBoolean("complete", bool1);
          localBundle.putBoolean("success", bool2);
          localBundle.putLong("lowTime", l1);
          paramObject = new ArrayList();
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramFromServiceMsg.peer_uin.get()), 0, paramToServiceMsg, paramObject, localBundle);
          if (paramToServiceMsg != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramObject, false);
          }
          label683:
          return;
          label684:
          l1 = l2;
          paramToServiceMsg = paramObject;
          if (k == 1)
          {
            l1 = l2;
            paramToServiceMsg = paramObject;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "code == 0x01");
              l1 = l2;
              paramToServiceMsg = paramObject;
              continue;
              label726:
              bool1 = false;
              break label555;
              label732:
              bool2 = false;
              break label575;
              label738:
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()), paramFromServiceMsg.last_msgtime.get(), paramFromServiceMsg.random.get());
              break label607;
              label775:
              if (bool3) {
                break label607;
              }
              if (bool1)
              {
                localBundle.putLong("tempEct", 0L);
                localBundle.putLong("tempRandom", 0L);
                break label607;
              }
              localBundle.putLong("tempEct", paramFromServiceMsg.last_msgtime.get());
              localBundle.putLong("tempRandom", paramFromServiceMsg.random.get());
            }
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          for (;;)
          {
            paramFromServiceMsg.printStackTrace();
          }
        }
      }
      l1 = 0L;
    }
  }
  
  /* Error */
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 641	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 1001
    //   7: invokevirtual 1005	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   10: istore 4
    //   12: new 203	java/util/HashMap
    //   15: dup
    //   16: iconst_1
    //   17: invokespecial 979	java/util/HashMap:<init>	(I)V
    //   20: astore 7
    //   22: aload 7
    //   24: ldc_w 981
    //   27: aload_1
    //   28: getfield 641	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   31: ldc_w 983
    //   34: invokevirtual 986	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokevirtual 990	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: pop
    //   41: aload 7
    //   43: ldc_w 992
    //   46: aload_1
    //   47: getfield 641	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   50: ldc_w 994
    //   53: invokevirtual 646	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   56: invokestatic 997	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   59: invokevirtual 990	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   62: pop
    //   63: aload 7
    //   65: ldc_w 999
    //   68: iload 4
    //   70: invokestatic 195	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   73: invokevirtual 990	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   76: pop
    //   77: new 1278	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp
    //   80: dup
    //   81: invokespecial 1678	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:<init>	()V
    //   84: astore 6
    //   86: aload 6
    //   88: aload_3
    //   89: checkcast 682	[B
    //   92: checkcast 682	[B
    //   95: invokevirtual 1679	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 1278	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp
    //   101: astore 6
    //   103: aload 6
    //   105: ifnull +67 -> 172
    //   108: new 1308	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody
    //   111: dup
    //   112: invokespecial 1680	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:<init>	()V
    //   115: astore_3
    //   116: aload 6
    //   118: getfield 1683	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:serialize_rspbody	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   121: invokevirtual 480	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   124: ifeq +139 -> 263
    //   127: aload_3
    //   128: aload 6
    //   130: getfield 1683	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:serialize_rspbody	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   133: invokevirtual 486	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   136: invokevirtual 492	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   139: invokevirtual 1684	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   142: checkcast 1308	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody
    //   145: astore_3
    //   146: aload_3
    //   147: ifnonnull +121 -> 268
    //   150: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +12 -> 165
    //   156: ldc 89
    //   158: iconst_2
    //   159: ldc_w 1686
    //   162: invokestatic 1011	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload_0
    //   166: aload_1
    //   167: aload_2
    //   168: iconst_0
    //   169: invokespecial 1688	aczw:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Z)V
    //   172: return
    //   173: astore_3
    //   174: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +13 -> 190
    //   180: ldc 89
    //   182: iconst_2
    //   183: ldc_w 1690
    //   186: aload_3
    //   187: invokestatic 431	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   190: aconst_null
    //   191: astore 6
    //   193: goto -90 -> 103
    //   196: astore_3
    //   197: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +13 -> 213
    //   203: ldc 89
    //   205: iconst_2
    //   206: ldc_w 1692
    //   209: aload_3
    //   210: invokestatic 431	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   213: aconst_null
    //   214: astore 6
    //   216: goto -113 -> 103
    //   219: astore_3
    //   220: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +13 -> 236
    //   226: ldc 89
    //   228: iconst_2
    //   229: ldc_w 1694
    //   232: aload_3
    //   233: invokestatic 431	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: aconst_null
    //   237: astore_3
    //   238: goto -92 -> 146
    //   241: astore_3
    //   242: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +13 -> 258
    //   248: ldc 89
    //   250: iconst_2
    //   251: ldc_w 1696
    //   254: aload_3
    //   255: invokestatic 431	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   258: aconst_null
    //   259: astore_3
    //   260: goto -114 -> 146
    //   263: aconst_null
    //   264: astore_3
    //   265: goto -119 -> 146
    //   268: aload_3
    //   269: getfield 1698	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:result	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   272: invokevirtual 729	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   275: istore 5
    //   277: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq +41 -> 321
    //   283: ldc 89
    //   285: iconst_2
    //   286: new 91	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   293: ldc_w 1700
    //   296: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: iload 5
    //   301: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   304: ldc_w 1702
    //   307: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: iload 4
    //   312: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   315: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 1011	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: iload 5
    //   323: ifeq +9 -> 332
    //   326: iload 5
    //   328: iconst_1
    //   329: if_icmpne +18 -> 347
    //   332: aload_0
    //   333: aload 6
    //   335: aload_3
    //   336: iload 5
    //   338: aload_1
    //   339: iload 4
    //   341: aload 7
    //   343: invokespecial 1704	aczw:a	(Lmsf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp;Ltencent/im/oidb/searcher/oidb_c2c_searcher$RspBody;ILcom/tencent/qphone/base/remote/ToServiceMsg;ILjava/util/HashMap;)V
    //   346: return
    //   347: aload_0
    //   348: aload_1
    //   349: aload_2
    //   350: iconst_0
    //   351: invokespecial 1688	aczw:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Z)V
    //   354: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	this	aczw
    //   0	355	1	paramToServiceMsg	ToServiceMsg
    //   0	355	2	paramFromServiceMsg	FromServiceMsg
    //   0	355	3	paramObject	Object
    //   10	330	4	k	int
    //   275	62	5	m	int
    //   84	250	6	localPbSearchRoamMsgInCloudResp	msg_svc.PbSearchRoamMsgInCloudResp
    //   20	322	7	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   86	103	173	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   86	103	196	java/lang/OutOfMemoryError
    //   127	146	219	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   127	146	241	java/lang/OutOfMemoryError
  }
  
  protected String a(msg_comm.Msg paramMsg)
  {
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    return 64 + "key_uid_" + l1 + "_seq_" + l2;
  }
  
  public List<MessageRecord> a(msg_comm.Msg paramMsg, bcsb parambcsb)
  {
    if (!(parambcsb instanceof bcre)) {
      return new ArrayList();
    }
    bcre localbcre = (bcre)parambcsb;
    long l4 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    if ((paramMsg == null) || (!paramMsg.msg_head.has()) || (!paramMsg.msg_body.has()))
    {
      if (QLog.isColorLevel())
      {
        parambcsb = new StringBuilder().append("decodeSinglePBMsg_C2C return : ");
        if (paramMsg != null) {
          break label104;
        }
      }
      label104:
      for (paramMsg = " msg=null";; paramMsg = " msg.msg_head:" + paramMsg.msg_head + " msg.msg_body:" + paramMsg.msg_body.has())
      {
        QLog.d("Q.msg.C2CMessageProcessor", 2, paramMsg);
        return localArrayList;
      }
    }
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    int i2 = (short)localMsgHead.msg_seq.get();
    long l2 = localMsgHead.to_uin.get();
    long l5 = localMsgHead.from_uin.get();
    long l3 = localMsgHead.msg_time.get();
    long l6 = localMsgHead.msg_uid.get();
    int i3 = localMsgHead.msg_type.get();
    int k = paramMsg.msg_head.c2c_cmd.get();
    localbcre.jdField_c_of_type_Int = 0;
    localbcre.jdField_d_of_type_Int = 0;
    int i1;
    int n;
    int m;
    if (paramMsg.content_head.has())
    {
      parambcsb = (msg_comm.ContentHead)paramMsg.content_head.get();
      i1 = parambcsb.div_seq.get();
      n = parambcsb.pkg_num.get();
      m = parambcsb.pkg_index.get();
    }
    for (;;)
    {
      long l1 = -1L;
      if (!localbcre.jdField_d_of_type_Boolean) {
        l1 = bcrw.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, String.valueOf(localbcre.jdField_e_of_type_Long), String.valueOf(l5));
      }
      localbcre.jdField_b_of_type_Long = l5;
      localbcre.jdField_c_of_type_Long = l3;
      int i4 = bcrw.a(paramMsg);
      localbcre.jdField_a_of_type_Int = i4;
      localbcre.jdField_d_of_type_Long = aogu.a((int)l1, i4);
      localbcre.jdField_b_of_type_Int = bcrw.e(paramMsg);
      if (l5 == localbcre.jdField_a_of_type_Long)
      {
        localbcre.jdField_a_of_type_Boolean = true;
        localbcre.f = true;
      }
      for (;;)
      {
        label652:
        Object localObject1;
        if (QLog.isColorLevel())
        {
          parambcsb = new StringBuilder();
          parambcsb.append("<---decodeSinglePBMsg_C2C : decode msg: msgTime:").append(l3).append(" shortSeq:").append(i2).append(" uint32Seq:").append(localMsgHead.msg_seq.get()).append(" msgUid:").append(l6).append(" toUin:").append(l2).append(" senderUin:").append(l5).append(" friendUin:").append(localbcre.jdField_e_of_type_Long).append(" isReaded:").append(localbcre.jdField_a_of_type_Boolean).append(" isSyncFromOtherTerm:").append(localbcre.f).append(" msgType:").append(i3).append(" c2CCmd:").append(k).append(" hasTemp:").append(localMsgHead.c2c_tmp_msg_head.has()).append(" hasShare:").append(paramMsg.appshare_info.has()).append(" pkgID:").append(l1).append(" longMsgID:").append(i1).append(" longMsgCount:").append(n).append(" longMsgIndex:").append(m).append("init_direction_flag").append(localbcre.jdField_d_of_type_Int);
          QLog.d("Q.msg.C2CMessageProcessor", 2, parambcsb.toString());
          parambcsb = new ArrayList();
          a(i3, paramMsg, parambcsb, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, localbcre);
          a(paramMsg, parambcsb, localbcre, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler);
          if ((parambcsb.size() == 0) && (n > 1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C, empty long msg fragment");
            }
            localObject1 = (MessageForText)bcry.a(-1000);
            ((MessageForText)localObject1).msgtype = -1000;
            ((MessageForText)localObject1).msg = "";
            parambcsb.add(localObject1);
          }
          l1 = -1L;
          l2 = l1;
        }
        try
        {
          localObject1 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
          l3 = l1;
          if (localObject1 != null)
          {
            l3 = l1;
            l2 = l1;
            if (((List)localObject1).size() > 0)
            {
              k = 0;
              for (;;)
              {
                l3 = l1;
                l2 = l1;
                if (k >= ((List)localObject1).size()) {
                  break;
                }
                l2 = l1;
                localObject2 = (im_msg_body.Elem)((List)localObject1).get(k);
                l3 = l1;
                l2 = l1;
                if (((im_msg_body.Elem)localObject2).elem_flags2.has())
                {
                  l3 = l1;
                  l2 = l1;
                  if (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject2).elem_flags2.get()).uint64_msg_id.has())
                  {
                    l2 = l1;
                    l3 = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject2).elem_flags2.get()).uint64_msg_id.get();
                  }
                }
                k += 1;
                l1 = l3;
              }
              localbcre.f = false;
              continue;
              if (localbcre.jdField_e_of_type_Long != 0L) {
                break label652;
              }
              QLog.e("Q.msg.C2CMessageProcessor", 1, "<---decodeSinglePBMsg_C2C : decode msg: frienduin=0");
              break label652;
            }
          }
          l1 = l3;
        }
        catch (Throwable localThrowable)
        {
          label1461:
          label1749:
          label2044:
          do
          {
            for (;;)
            {
              Object localObject2;
              QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C: ", localThrowable);
              l1 = l2;
              continue;
              localMessageRecord.selfuin = String.valueOf(localbcre.jdField_a_of_type_Long);
              localMessageRecord.frienduin = String.valueOf(localbcre.jdField_e_of_type_Long);
              localMessageRecord.senderuin = String.valueOf(localbcre.jdField_b_of_type_Long);
              localMessageRecord.time = localbcre.jdField_c_of_type_Long;
              localMessageRecord.shmsgseq = i2;
              localMessageRecord.msgUid = l6;
              localMessageRecord.istroop = localbcre.jdField_c_of_type_Int;
              localMessageRecord.longMsgId = i1;
              localMessageRecord.longMsgCount = n;
              localMessageRecord.longMsgIndex = m;
              if ((1 == localbcre.jdField_d_of_type_Int) && (adak.t(localMessageRecord.istroop)) && (adak.a(localMessageRecord.istroop) != 1032) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, adak.a(localMessageRecord.istroop), adak.a(adak.a(localMessageRecord.istroop)))))
              {
                adak.a(localMessageRecord, true);
                if (localMessageRecord.msgtype == -2058) {
                  EmojiStickerManager.a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                }
                if ((!adak.t(localbcre.jdField_c_of_type_Int)) || (!(localMessageRecord instanceof MessageForStructing))) {
                  break label1749;
                }
                k = aosk.a(localMessageRecord, 1);
                if (k > 0) {
                  localMessageRecord.saveExtInfoToExtStr("nearby_gift_msg", "1|" + k);
                }
                parambcsb = (MessageForStructing)localMessageRecord;
                if ((parambcsb.structingMsg.mMsgServiceID != 52) || ((aocz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(124) == null)) {
                  break label1749;
                }
                parambcsb = new NearbyFlowerMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambcsb);
                if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(parambcsb.sUin)) {
                  break label1693;
                }
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060AF", "0X80060AF", 0, 0, "", "", "", "");
              }
              for (;;)
              {
                if (!"4".equals(parambcsb.version)) {
                  break label1749;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.C2CMessageProcessor", 2, "<---received random chat flower message, don't put it to aio");
                }
                bcrw.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i2, l6, i3);
                break;
                adak.a(localMessageRecord, false);
                break label1461;
                if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(parambcsb.rUin)) {
                  bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060B0", "0X80060B0", 0, 0, "", "", "", "");
                }
              }
              parambcsb = (msg_comm.C2CTmpMsgHead)localMsgHead.c2c_tmp_msg_head.get();
              if ((parambcsb != null) && (parambcsb.lock_display.has()) && (parambcsb.lock_display.get() == 1))
              {
                localMessageRecord.extLong |= 0x1;
                localMessageRecord.saveExtInfoToExtStr("lockDisplay", "true");
              }
              if ((localbcre.jdField_c_of_type_Int == 0) && ((localMessageRecord instanceof MessageForPic))) {
                ((MessageForPic)localMessageRecord).bEnableEnc = true;
              }
              if (localbcre.jdField_c_of_type_Int == 1006)
              {
                if (localMsgHead.from_nick.has()) {
                  ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(String.valueOf(localbcre.jdField_e_of_type_Long), localMsgHead.from_nick.get());
                }
                localMessageRecord.frienduin = bhlg.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(localbcre.jdField_e_of_type_Long));
                localMessageRecord.senderuin = bhlg.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l5));
                if ((TextUtils.isEmpty(localMessageRecord.frienduin)) && (localbcre.jdField_d_of_type_Boolean)) {
                  localMessageRecord.frienduin = String.valueOf(localbcre.jdField_e_of_type_Long);
                }
                if (localMessageRecord.frienduin == null)
                {
                  QLog.e("Q.msg.C2CMessageProcessor", 1, String.format("decodeMessage error, getPhoneNumByUin is null, friendUin: %d senderUin: %d uinType: %d msgType: %d", new Object[] { Long.valueOf(localbcre.jdField_e_of_type_Long), Long.valueOf(l5), Integer.valueOf(localMessageRecord.istroop), Integer.valueOf(localMessageRecord.msgtype) }));
                  continue;
                }
              }
              if (localbcre.f)
              {
                localMessageRecord.issend = 2;
                localMessageRecord.isread = true;
                if ((localMessageRecord instanceof MessageForPoke))
                {
                  if ((!localMessageRecord.isread) && (!localMessageRecord.isSend())) {
                    ((MessageForPoke)localMessageRecord).isPlayed = false;
                  }
                  ((MessageForPoke)localMessageRecord).initMsg();
                }
                localMessageRecord.vipBubbleID = localbcre.jdField_d_of_type_Long;
                localMessageRecord.vipBubbleDiyTextId = localbcre.jdField_a_of_type_Int;
                localMessageRecord.vipSubBubbleId = localbcre.jdField_b_of_type_Int;
                if (localbcre.jdField_b_of_type_Int > 0) {
                  localMessageRecord.saveExtInfoToExtStr("bubble_sub_id", String.valueOf(localbcre.jdField_b_of_type_Int));
                }
                k = bcrw.c(paramMsg);
                if (k > 0) {
                  localMessageRecord.saveExtInfoToExtStr("vip_pendant_diy_id", String.valueOf(k));
                }
                k = bcrw.b(paramMsg);
                if (k >= 0) {
                  localMessageRecord.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(k));
                }
                k = bcrw.d(paramMsg);
                if (k >= 0) {
                  localMessageRecord.saveExtInfoToExtStr("vip_face_id", String.valueOf(k));
                }
                if (localMessageRecord.istroop != 1008) {}
              }
              try
              {
                if (localMsgHead.public_account_group_send_flag.has()) {
                  localMessageRecord.saveExtInfoToExtStr("public_account_send_flag", String.valueOf(localMsgHead.public_account_group_send_flag.get()));
                }
                if (l1 != -1L) {
                  localMessageRecord.saveExtInfoToExtStr("public_account_msg_id", String.valueOf(l1));
                }
                if ((localMessageRecord instanceof MessageForStructing))
                {
                  parambcsb = (MessageForStructing)localMessageRecord;
                  if ((parambcsb.structingMsg != null) && (parambcsb.structingMsg.mMsgServiceID == 76)) {
                    ((nql)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(171)).a(parambcsb);
                  }
                }
                if (localMessageRecord.msgtype == -7005)
                {
                  awlm.a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                  continue;
                  if (localMessageRecord.msgtype == -2037) {
                    break label2044;
                  }
                  localMessageRecord.isread = localbcre.jdField_a_of_type_Boolean;
                }
              }
              catch (Throwable parambcsb)
              {
                for (;;)
                {
                  QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeMessage: ", parambcsb);
                }
                localArrayList.add(localMessageRecord);
                if (localbcre.jdField_c_of_type_Int == 1036) {
                  bcrw.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i2, l6, i3);
                }
              }
            }
          } while (localMessageRecord.msgtype != -2039);
          label1693:
          localObject3 = (MessageForApollo)localMessageRecord;
          localamsx = (amsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
          parambcsb = null;
          if (!QLog.isColorLevel()) {
            break label2531;
          }
          parambcsb = new StringBuilder("decode apollo c2c msg: ").append(", id: ").append(((MessageForApollo)localObject3).mApolloMessage.id).append(", name: ").append(new String(((MessageForApollo)localObject3).mApolloMessage.name)).append(", doubleAction: ").append(((MessageForApollo)localObject3).isDoubleAction()).append(", signTS: ").append(((MessageForApollo)localObject3).signTs);
          label2531:
          i5 = ((MessageForApollo)localObject3).isSend();
          if (((MessageForApollo)localObject3).mApolloMessage.peer_uin == 0L) {
            break label3101;
          }
        }
      }
      localObject2 = parambcsb.iterator();
      Object localObject3;
      amsx localamsx;
      label2553:
      ApolloBaseInfo localApolloBaseInfo;
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
          if ((localMessageRecord != null) && ((localbcre.jdField_b_of_type_Long != 3338705755L) || (!tzq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) && ((localbcre.jdField_b_of_type_Long != 2171946401L) || (!ozs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))))
          {
            if (localbcre.jdField_b_of_type_Long == 2171946401L) {
              tzq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
            }
            if (((localbcre.jdField_c_of_type_Int != 1025) && (localbcre.jdField_c_of_type_Int != 1024)) || (localMessageRecord.msgtype != -1000) || (!localMessageRecord.msg.startsWith("default:SigT=")))
            {
              if (adak.a(localbcre.jdField_c_of_type_Int) == 1032)
              {
                localObject1 = null;
                parambcsb = (bcsb)localObject1;
                if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
                {
                  localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                  parambcsb = (bcsb)localObject1;
                  if (localObject3 != null) {
                    parambcsb = ((bcrg)localObject3).a(String.valueOf(localbcre.jdField_e_of_type_Long), String.valueOf(localbcre.jdField_a_of_type_Long));
                  }
                }
                bcrw.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i2, l6, i3, parambcsb);
                if (localbcre.jdField_c_of_type_Int == 1032)
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.i("Q.msg.C2CMessageProcessor", 2, String.format("decodeMessage discard confess msg senderUin:%s msgSeq:%d msgType:%d", new Object[] { Long.toString(l5), Integer.valueOf(i2), Integer.valueOf(i3) }));
                  continue;
                }
              }
              int i5;
              k = 1;
              if (((k & i5) != 0) && (((MessageForApollo)localObject3).mApolloMessage.peer_uin != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()))
              {
                localApolloBaseInfo = localamsx.b(((MessageForApollo)localObject3).mApolloMessage.peer_uin + "");
                l2 = ((MessageForApollo)localObject3).mApolloMessage.peer_ts;
                k = ((MessageForApollo)localObject3).mApolloMessage.peer_status;
                label2632:
                if ((QLog.isColorLevel()) && (localApolloBaseInfo != null)) {
                  parambcsb.append("\n fuin: ").append(localApolloBaseInfo.uin).append(", msg time: ").append(localMessageRecord.time).append(", msg ts: ").append(l2).append(", svr ts: ").append(localApolloBaseInfo.apolloServerTS).append(", update time: ").append(localApolloBaseInfo.apolloUpdateTime).append(", status: ").append(k);
                }
                if ((localApolloBaseInfo == null) || (localMessageRecord.time <= localApolloBaseInfo.apolloUpdateTime) || (localApolloBaseInfo.apolloServerTS >= l2)) {
                  break label3140;
                }
                localApolloBaseInfo.apolloStatus = k;
                localApolloBaseInfo.apolloServerTS = l2;
                localApolloBaseInfo.apolloVipFlag = (((MessageForApollo)localObject3).mApolloMessage.flag >> 30 & 0x1);
                localApolloBaseInfo.apolloUpdateTime = localMessageRecord.time;
                if ((((MessageForApollo)localObject3).isSend()) || (((MessageForApollo)localObject3).signTs <= NetConnInfoCenter.getServerTime()) || (((MessageForApollo)localObject3).signTs == localApolloBaseInfo.apolloSignValidTS)) {
                  break label3517;
                }
                localApolloBaseInfo.apolloSignValidTS = ((MessageForApollo)localObject3).signTs;
                localApolloBaseInfo.apolloSignStr = "";
                k = 1;
              }
            }
          }
        }
      }
      for (;;)
      {
        label2847:
        if (k != 0)
        {
          localamsx.a(localApolloBaseInfo);
          if (QLog.isColorLevel()) {
            parambcsb.append("\n save apollo info fuin: ").append(localApolloBaseInfo.uin).append("-->").append(localApolloBaseInfo.apolloVipFlag).append("|").append(localApolloBaseInfo.apolloStatus).append("|").append(localApolloBaseInfo.apolloLocalTS).append("|").append(localApolloBaseInfo.apolloServerTS).append("|").append(localApolloBaseInfo.apolloUpdateTime).append("|").append(localApolloBaseInfo.apolloSignValidTS);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, parambcsb.toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break;
        }
        k = localamsx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        parambcsb = "";
        if (((MessageForApollo)localObject3).msgType == 0) {
          parambcsb = String.valueOf(((MessageForApollo)localObject3).mApolloMessage.id);
        }
        for (;;)
        {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "rev_action", String.valueOf(((MessageForApollo)localObject3).mApolloMessage.peer_uin), 0, ((MessageForApollo)localObject3).msgType, new String[] { parambcsb, Integer.toString(k), Integer.toString(amsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)), String.valueOf(System.currentTimeMillis() / 1000L) });
          break;
          label3101:
          k = 0;
          break label2553;
          localApolloBaseInfo = localamsx.b(((MessageForApollo)localObject3).senderuin);
          l2 = ((MessageForApollo)localObject3).mApolloMessage.sender_ts;
          k = ((MessageForApollo)localObject3).mApolloMessage.sender_status;
          break label2632;
          label3140:
          if ((localApolloBaseInfo == null) || (((MessageForApollo)localObject3).isSend()) || (((MessageForApollo)localObject3).signTs <= NetConnInfoCenter.getServerTime()) || (((MessageForApollo)localObject3).signTs == localApolloBaseInfo.apolloSignValidTS)) {
            break label3517;
          }
          localApolloBaseInfo.apolloSignValidTS = ((MessageForApollo)localObject3).signTs;
          localApolloBaseInfo.apolloSignStr = "";
          k = 1;
          break label2847;
          if (((MessageForApollo)localObject3).msgType == 2) {
            parambcsb = "" + ((MessageForApollo)localObject3).gameId;
          }
        }
        if ((localbcre.jdField_c_of_type_Int == 1008) && (paramMsg.msg_body.has()))
        {
          paramMsg = (im_msg_body.MsgBody)paramMsg.msg_body.get();
          if (paramMsg.rich_text.has())
          {
            paramMsg = (im_msg_body.RichText)paramMsg.rich_text.get();
            if (paramMsg.elems.has())
            {
              paramMsg = paramMsg.elems.get().iterator();
              while (paramMsg.hasNext())
              {
                parambcsb = (im_msg_body.Elem)paramMsg.next();
                if (parambcsb.pub_acc_info.has())
                {
                  k = parambcsb.pub_acc_info.uint32_is_inter_num.get();
                  paramMsg = parambcsb.pub_acc_info.string_msg_template_id.get();
                  if (k != 0)
                  {
                    parambcsb = localArrayList.iterator();
                    while (parambcsb.hasNext()) {
                      ((MessageRecord)parambcsb.next()).saveExtInfoToExtStr("inter_num", String.valueOf(k));
                    }
                  }
                  parambcsb = localArrayList.iterator();
                  while (parambcsb.hasNext()) {
                    ((MessageRecord)parambcsb.next()).saveExtInfoToExtStr("msg_template_id", paramMsg);
                  }
                }
              }
            }
          }
        }
        MsgAutoMonitorUtil.getInstance().addDecodeC2CMsgTime(System.currentTimeMillis() - l4);
        m = 0;
        paramMsg = localArrayList.iterator();
        k = 0;
        if (paramMsg.hasNext())
        {
          parambcsb = (MessageRecord)paramMsg.next();
          m = parambcsb.istroop;
          if (parambcsb.isread) {
            break label3514;
          }
          k += 1;
        }
        label3514:
        for (;;)
        {
          break;
          bdks.a(0, 1, m, k);
          return localArrayList;
        }
        label3517:
        k = 0;
      }
      m = 0;
      n = 0;
      i1 = 0;
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2001: 
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, false);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "processType" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (msg_onlinepush.PbPushMsg)paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 1002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 2001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 2005: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        d((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 1003: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        c((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      b((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (msg_onlinepush.PbPushMsg)paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(C2CMsgReadedNotify paramC2CMsgReadedNotify)
  {
    String str = String.valueOf(paramC2CMsgReadedNotify.lPeerUin);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "processPushReadedNotify is called. uAioType = " + paramC2CMsgReadedNotify.uAioType);
    }
    if (paramC2CMsgReadedNotify.uAioType == 3L) {
      avlm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, paramC2CMsgReadedNotify);
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 0, paramC2CMsgReadedNotify.lLastReadTime);
    } while (paramC2CMsgReadedNotify.lLastReadTime < 0L);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a.a(str, 0);
  }
  
  public void a(MessageForPtt paramMessageForPtt1, MessageForPtt paramMessageForPtt2)
  {
    bool2 = false;
    bool1 = bool2;
    if (paramMessageForPtt1.getPttStreamFlag() == 10001)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramMessageForPtt2.directUrl))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramMessageForPtt1.directUrl)) {}
      }
    }
    try
    {
      paramMessageForPtt1.directUrl = paramMessageForPtt2.directUrl;
      paramMessageForPtt1.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPtt1.frienduin, paramMessageForPtt1.istroop, paramMessageForPtt1.uniseq, paramMessageForPtt1.msgData);
      bool1 = true;
    }
    catch (Exception paramMessageForPtt1)
    {
      for (;;)
      {
        paramMessageForPtt1.printStackTrace();
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "updateStreamPttDirectUrl : " + bool1);
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    super.a(paramString, paramInt, paramLong);
    if (adak.d(paramInt))
    {
      msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
      a(paramString, paramInt, paramLong, localPbMsgReadedReportReq);
      a(localPbMsgReadedReportReq);
    }
  }
  
  public void a(ArrayList<Pair<Long, Long>> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("-ReportList-");
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
    msg_svc.PbC2CReadedReportReq localPbC2CReadedReportReq = new msg_svc.PbC2CReadedReportReq();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Pair localPair = (Pair)paramArrayList.next();
      msg_svc.PbC2CReadedReportReq.UinPairReadInfo localUinPairReadInfo = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
      localUinPairReadInfo.peer_uin.set(((Long)localPair.first).longValue());
      localUinPairReadInfo.last_read_time.set(((Long)localPair.second).intValue());
      localStringBuilder.append("-uin:").append(localPair.first).append("-ReadTime-").append(localPair.second);
      localPbC2CReadedReportReq.pair_info.add(localUinPairReadInfo);
    }
    paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
    if (paramArrayList != null) {
      localPbC2CReadedReportReq.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayList));
    }
    localPbMsgReadedReportReq.c2c_read_report.set(localPbC2CReadedReportReq);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "<ReadReport><S>_C2C:" + localStringBuilder.toString());
    }
    a(localPbMsgReadedReportReq);
  }
  
  /* Error */
  public void a(ArrayList<MessageRecord> paramArrayList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 223	java/util/ArrayList:size	()I
    //   8: ifne +4 -> 12
    //   11: return
    //   12: invokestatic 2255	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   15: aload_0
    //   16: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   22: invokestatic 2260	com/tencent/mobileqq/activity/UserguideActivity:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   25: ifne -14 -> 11
    //   28: invokestatic 2255	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   31: invokevirtual 2264	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   34: aload_0
    //   35: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   38: invokestatic 2269	bhhv:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)Z
    //   41: ifeq -30 -> 11
    //   44: aload_1
    //   45: invokevirtual 554	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   48: astore 7
    //   50: aload 7
    //   52: invokeinterface 154 1 0
    //   57: ifeq +1587 -> 1644
    //   60: aload 7
    //   62: invokeinterface 158 1 0
    //   67: checkcast 304	com/tencent/mobileqq/data/MessageRecord
    //   70: astore 8
    //   72: aload 8
    //   74: getfield 316	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   77: invokestatic 1874	adak:t	(I)Z
    //   80: ifeq -30 -> 50
    //   83: aload 8
    //   85: invokestatic 2270	adak:d	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   88: ifeq -38 -> 50
    //   91: aload_0
    //   92: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   95: aload 8
    //   97: invokestatic 2273	adak:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   100: ifne -50 -> 50
    //   103: aload 8
    //   105: invokevirtual 1959	com/tencent/mobileqq/data/MessageRecord:isSend	()Z
    //   108: ifne -58 -> 50
    //   111: aload 8
    //   113: getfield 1212	com/tencent/mobileqq/data/MessageRecord:isread	Z
    //   116: ifne -66 -> 50
    //   119: iconst_1
    //   120: istore_3
    //   121: iload_3
    //   122: ifeq -111 -> 11
    //   125: aload_0
    //   126: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   129: bipush 51
    //   131: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   134: checkcast 787	anyw
    //   137: aload_0
    //   138: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   141: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   144: invokevirtual 2276	anyw:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   147: astore 7
    //   149: aload_0
    //   150: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   153: invokevirtual 125	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   156: astore 10
    //   158: aload 7
    //   160: ifnonnull +566 -> 726
    //   163: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +1472 -> 1638
    //   169: ldc 89
    //   171: iconst_2
    //   172: ldc_w 2278
    //   175: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: iconst_1
    //   179: istore 4
    //   181: aload_0
    //   182: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   185: bipush 106
    //   187: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   190: checkcast 2280	axup
    //   193: invokevirtual 2281	axup:a	()Z
    //   196: istore 6
    //   198: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +42 -> 243
    //   204: ldc_w 2283
    //   207: iconst_2
    //   208: new 91	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 2285
    //   218: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: iload 4
    //   223: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: ldc_w 2287
    //   229: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: iload 6
    //   234: invokevirtual 703	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   237: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload_0
    //   244: getfield 2288	aczw:jdField_a_of_type_Boolean	Z
    //   247: ifne +293 -> 540
    //   250: invokestatic 2293	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   253: getstatic 2299	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:OneyWayDateMsgNotifyCfg	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   256: invokevirtual 2301	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   259: invokevirtual 2303	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   262: astore 8
    //   264: invokestatic 2293	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   267: getstatic 2306	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:OneyWayLBSFriendMsgNotifyCfg	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   270: invokevirtual 2301	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   273: invokevirtual 2303	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   276: astore 7
    //   278: aload 8
    //   280: ldc_w 2308
    //   283: invokevirtual 2312	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   286: astore 8
    //   288: aload 7
    //   290: ldc_w 2308
    //   293: invokevirtual 2312	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   296: astore 7
    //   298: aload 8
    //   300: arraylength
    //   301: bipush 6
    //   303: if_icmplt +232 -> 535
    //   306: aload 7
    //   308: arraylength
    //   309: bipush 6
    //   311: if_icmplt +224 -> 535
    //   314: aload_0
    //   315: aload 8
    //   317: iconst_0
    //   318: aaload
    //   319: invokestatic 1547	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   322: putfield 27	aczw:jdField_a_of_type_Int	I
    //   325: aload_0
    //   326: aload 8
    //   328: iconst_1
    //   329: aaload
    //   330: invokestatic 1547	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   333: putfield 29	aczw:jdField_b_of_type_Int	I
    //   336: aload_0
    //   337: aload 8
    //   339: iconst_2
    //   340: aaload
    //   341: invokestatic 1547	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   344: putfield 31	aczw:jdField_c_of_type_Int	I
    //   347: aload_0
    //   348: aload 8
    //   350: iconst_3
    //   351: aaload
    //   352: invokestatic 1547	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   355: putfield 33	aczw:jdField_d_of_type_Int	I
    //   358: aload_0
    //   359: aload 7
    //   361: iconst_0
    //   362: aaload
    //   363: invokestatic 1547	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   366: putfield 35	aczw:f	I
    //   369: aload_0
    //   370: aload 7
    //   372: iconst_1
    //   373: aaload
    //   374: invokestatic 1547	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   377: putfield 37	aczw:g	I
    //   380: aload_0
    //   381: aload 7
    //   383: iconst_2
    //   384: aaload
    //   385: invokestatic 1547	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   388: putfield 39	aczw:h	I
    //   391: aload_0
    //   392: aload 7
    //   394: iconst_3
    //   395: aaload
    //   396: invokestatic 1547	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   399: putfield 41	aczw:i	I
    //   402: invokestatic 1079	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   405: ifeq +130 -> 535
    //   408: ldc_w 2314
    //   411: iconst_4
    //   412: new 91	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   419: ldc_w 2316
    //   422: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload_0
    //   426: getfield 27	aczw:jdField_a_of_type_Int	I
    //   429: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   432: ldc_w 2093
    //   435: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload_0
    //   439: getfield 29	aczw:jdField_b_of_type_Int	I
    //   442: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: ldc_w 2093
    //   448: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload_0
    //   452: getfield 31	aczw:jdField_c_of_type_Int	I
    //   455: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   458: ldc_w 2093
    //   461: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload_0
    //   465: getfield 33	aczw:jdField_d_of_type_Int	I
    //   468: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   471: ldc_w 2318
    //   474: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload_0
    //   478: getfield 35	aczw:f	I
    //   481: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   484: ldc_w 2093
    //   487: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload_0
    //   491: getfield 37	aczw:g	I
    //   494: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   497: ldc_w 2093
    //   500: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: aload_0
    //   504: getfield 39	aczw:h	I
    //   507: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   510: ldc_w 2093
    //   513: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_0
    //   517: getfield 41	aczw:i	I
    //   520: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   523: ldc_w 973
    //   526: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   535: aload_0
    //   536: iconst_1
    //   537: putfield 2288	aczw:jdField_a_of_type_Boolean	Z
    //   540: invokestatic 2255	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   543: new 91	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   550: aload_0
    //   551: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   554: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   557: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: ldc_w 2320
    //   563: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: iconst_0
    //   570: invokevirtual 2324	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   573: astore 11
    //   575: ldc_w 611
    //   578: astore 8
    //   580: ldc_w 611
    //   583: astore 9
    //   585: aload 8
    //   587: astore 7
    //   589: aload_0
    //   590: getfield 50	aczw:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   593: ifnonnull +145 -> 738
    //   596: aload_0
    //   597: monitorenter
    //   598: aload 8
    //   600: astore 7
    //   602: aload_0
    //   603: getfield 50	aczw:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   606: ifnonnull +130 -> 736
    //   609: aload_0
    //   610: new 54	java/util/HashSet
    //   613: dup
    //   614: invokespecial 57	java/util/HashSet:<init>	()V
    //   617: putfield 50	aczw:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   620: aload 11
    //   622: new 91	java/lang/StringBuilder
    //   625: dup
    //   626: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   629: aload_0
    //   630: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   633: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   636: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: ldc_w 2326
    //   642: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: ldc_w 611
    //   651: invokeinterface 2331 3 0
    //   656: astore 8
    //   658: aload 8
    //   660: ldc_w 2308
    //   663: invokevirtual 2312	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   666: astore 12
    //   668: aload 12
    //   670: arraylength
    //   671: istore 5
    //   673: iconst_0
    //   674: istore_3
    //   675: aload 8
    //   677: astore 7
    //   679: iload_3
    //   680: iload 5
    //   682: if_icmpge +54 -> 736
    //   685: aload 12
    //   687: iload_3
    //   688: aaload
    //   689: astore 7
    //   691: aload 7
    //   693: invokevirtual 933	java/lang/String:length	()I
    //   696: ifle +23 -> 719
    //   699: aload 7
    //   701: invokestatic 212	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   704: lconst_0
    //   705: lcmp
    //   706: ifle +13 -> 719
    //   709: aload_0
    //   710: getfield 50	aczw:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   713: aload 7
    //   715: invokevirtual 2332	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   718: pop
    //   719: iload_3
    //   720: iconst_1
    //   721: iadd
    //   722: istore_3
    //   723: goto -48 -> 675
    //   726: aload 7
    //   728: getfield 2337	com/tencent/mobileqq/data/Card:shGender	S
    //   731: istore 4
    //   733: goto -552 -> 181
    //   736: aload_0
    //   737: monitorexit
    //   738: aload 9
    //   740: astore 8
    //   742: aload_0
    //   743: getfield 52	aczw:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   746: ifnonnull +140 -> 886
    //   749: aload_0
    //   750: monitorenter
    //   751: aload 9
    //   753: astore 8
    //   755: aload_0
    //   756: getfield 52	aczw:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   759: ifnonnull +125 -> 884
    //   762: aload_0
    //   763: new 54	java/util/HashSet
    //   766: dup
    //   767: invokespecial 57	java/util/HashSet:<init>	()V
    //   770: putfield 52	aczw:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   773: aload 11
    //   775: new 91	java/lang/StringBuilder
    //   778: dup
    //   779: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   782: aload_0
    //   783: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   786: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   789: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: ldc_w 2339
    //   795: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   801: ldc_w 611
    //   804: invokeinterface 2331 3 0
    //   809: astore 9
    //   811: aload 9
    //   813: ldc_w 2308
    //   816: invokevirtual 2312	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   819: astore 12
    //   821: aload 12
    //   823: arraylength
    //   824: istore 5
    //   826: iconst_0
    //   827: istore_3
    //   828: aload 9
    //   830: astore 8
    //   832: iload_3
    //   833: iload 5
    //   835: if_icmpge +49 -> 884
    //   838: aload 12
    //   840: iload_3
    //   841: aaload
    //   842: astore 8
    //   844: aload 8
    //   846: invokevirtual 933	java/lang/String:length	()I
    //   849: ifle +23 -> 872
    //   852: aload 8
    //   854: invokestatic 212	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   857: lconst_0
    //   858: lcmp
    //   859: ifle +13 -> 872
    //   862: aload_0
    //   863: getfield 52	aczw:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   866: aload 8
    //   868: invokevirtual 2332	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   871: pop
    //   872: iload_3
    //   873: iconst_1
    //   874: iadd
    //   875: istore_3
    //   876: goto -48 -> 828
    //   879: astore_1
    //   880: aload_0
    //   881: monitorexit
    //   882: aload_1
    //   883: athrow
    //   884: aload_0
    //   885: monitorexit
    //   886: aload_1
    //   887: invokevirtual 554	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   890: astore 12
    //   892: aload 8
    //   894: astore_1
    //   895: aload 12
    //   897: invokeinterface 154 1 0
    //   902: ifeq -891 -> 11
    //   905: aload 12
    //   907: invokeinterface 158 1 0
    //   912: checkcast 304	com/tencent/mobileqq/data/MessageRecord
    //   915: astore 13
    //   917: aload_1
    //   918: astore 9
    //   920: aload_0
    //   921: aload 13
    //   923: invokevirtual 2341	aczw:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   926: ifeq +641 -> 1567
    //   929: aload_1
    //   930: astore 9
    //   932: aload 10
    //   934: ifnull +633 -> 1567
    //   937: aload 13
    //   939: getfield 316	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   942: sipush 1010
    //   945: if_icmpne +340 -> 1285
    //   948: aload 7
    //   950: astore 8
    //   952: aload_0
    //   953: getfield 50	aczw:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   956: aload 13
    //   958: getfield 358	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   961: invokevirtual 2342	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   964: ifne +89 -> 1053
    //   967: aload_0
    //   968: getfield 50	aczw:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   971: aload 13
    //   973: getfield 358	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   976: invokevirtual 2332	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   979: pop
    //   980: aload 7
    //   982: invokevirtual 933	java/lang/String:length	()I
    //   985: ifne +237 -> 1222
    //   988: aload 13
    //   990: getfield 358	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   993: astore 7
    //   995: aload 11
    //   997: invokeinterface 2346 1 0
    //   1002: new 91	java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1009: aload_0
    //   1010: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1013: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1016: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: ldc_w 2326
    //   1022: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1028: aload 7
    //   1030: invokeinterface 2351 3 0
    //   1035: pop
    //   1036: aload 11
    //   1038: invokeinterface 2346 1 0
    //   1043: invokeinterface 2354 1 0
    //   1048: pop
    //   1049: aload 7
    //   1051: astore 8
    //   1053: iload 4
    //   1055: ifne +209 -> 1264
    //   1058: iload 6
    //   1060: ifeq +196 -> 1256
    //   1063: aload_0
    //   1064: getfield 31	aczw:jdField_c_of_type_Int	I
    //   1067: istore_3
    //   1068: aload_0
    //   1069: aload_0
    //   1070: getfield 50	aczw:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1073: invokevirtual 2355	java/util/HashSet:size	()I
    //   1076: putfield 2357	aczw:e	I
    //   1079: aload_0
    //   1080: getfield 2357	aczw:e	I
    //   1083: iload_3
    //   1084: irem
    //   1085: ifne +113 -> 1198
    //   1088: aload_0
    //   1089: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1092: aload 13
    //   1094: iload_2
    //   1095: invokevirtual 2358	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/MessageRecord;Z)V
    //   1098: aload_0
    //   1099: getfield 50	aczw:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1102: invokevirtual 2359	java/util/HashSet:clear	()V
    //   1105: aload 11
    //   1107: invokeinterface 2346 1 0
    //   1112: new 91	java/lang/StringBuilder
    //   1115: dup
    //   1116: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1119: aload_0
    //   1120: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1123: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1126: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: ldc_w 2326
    //   1132: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1138: invokeinterface 2362 2 0
    //   1143: pop
    //   1144: aload 11
    //   1146: invokeinterface 2346 1 0
    //   1151: invokeinterface 2354 1 0
    //   1156: pop
    //   1157: iload 6
    //   1159: ifeq +39 -> 1198
    //   1162: aload_0
    //   1163: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1166: ldc_w 1910
    //   1169: ldc_w 611
    //   1172: ldc_w 611
    //   1175: ldc_w 2364
    //   1178: ldc_w 2364
    //   1181: iconst_0
    //   1182: iconst_0
    //   1183: ldc_w 611
    //   1186: ldc_w 611
    //   1189: ldc_w 611
    //   1192: ldc_w 611
    //   1195: invokestatic 1915	bdll:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1198: aload_1
    //   1199: astore 7
    //   1201: aload 8
    //   1203: astore_1
    //   1204: aload_1
    //   1205: astore 8
    //   1207: aload 7
    //   1209: astore_1
    //   1210: aload 8
    //   1212: astore 7
    //   1214: goto -319 -> 895
    //   1217: astore_1
    //   1218: aload_0
    //   1219: monitorexit
    //   1220: aload_1
    //   1221: athrow
    //   1222: new 91	java/lang/StringBuilder
    //   1225: dup
    //   1226: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1229: aload 7
    //   1231: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: ldc_w 2093
    //   1237: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: aload 13
    //   1242: getfield 358	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1245: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1251: astore 7
    //   1253: goto -258 -> 995
    //   1256: aload_0
    //   1257: getfield 27	aczw:jdField_a_of_type_Int	I
    //   1260: istore_3
    //   1261: goto -193 -> 1068
    //   1264: iload 6
    //   1266: ifeq +11 -> 1277
    //   1269: aload_0
    //   1270: getfield 33	aczw:jdField_d_of_type_Int	I
    //   1273: istore_3
    //   1274: goto -206 -> 1068
    //   1277: aload_0
    //   1278: getfield 29	aczw:jdField_b_of_type_Int	I
    //   1281: istore_3
    //   1282: goto -214 -> 1068
    //   1285: aload 13
    //   1287: getfield 316	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   1290: sipush 1001
    //   1293: if_icmpeq +17 -> 1310
    //   1296: aload_1
    //   1297: astore 9
    //   1299: aload 13
    //   1301: getfield 316	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   1304: sipush 10002
    //   1307: if_icmpne +260 -> 1567
    //   1310: aload_1
    //   1311: astore 8
    //   1313: aload_0
    //   1314: getfield 52	aczw:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1317: aload 13
    //   1319: getfield 358	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1322: invokevirtual 2342	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   1325: ifne +85 -> 1410
    //   1328: aload_0
    //   1329: getfield 52	aczw:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1332: aload 13
    //   1334: getfield 358	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1337: invokevirtual 2332	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1340: pop
    //   1341: aload_1
    //   1342: invokevirtual 933	java/lang/String:length	()I
    //   1345: ifne +232 -> 1577
    //   1348: aload 13
    //   1350: getfield 358	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1353: astore_1
    //   1354: aload 11
    //   1356: invokeinterface 2346 1 0
    //   1361: new 91	java/lang/StringBuilder
    //   1364: dup
    //   1365: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1368: aload_0
    //   1369: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1372: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1375: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: ldc_w 2339
    //   1381: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1384: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1387: aload_1
    //   1388: invokeinterface 2351 3 0
    //   1393: pop
    //   1394: aload 11
    //   1396: invokeinterface 2346 1 0
    //   1401: invokeinterface 2354 1 0
    //   1406: pop
    //   1407: aload_1
    //   1408: astore 8
    //   1410: iload 4
    //   1412: ifne +205 -> 1617
    //   1415: iload 6
    //   1417: ifeq +192 -> 1609
    //   1420: aload_0
    //   1421: getfield 39	aczw:h	I
    //   1424: istore_3
    //   1425: aload_0
    //   1426: aload_0
    //   1427: getfield 52	aczw:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1430: invokevirtual 2355	java/util/HashSet:size	()I
    //   1433: putfield 2366	aczw:j	I
    //   1436: aload 8
    //   1438: astore 9
    //   1440: aload_0
    //   1441: getfield 2366	aczw:j	I
    //   1444: iload_3
    //   1445: irem
    //   1446: ifne +121 -> 1567
    //   1449: aload_0
    //   1450: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1453: aload 13
    //   1455: iload_2
    //   1456: invokevirtual 2358	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/MessageRecord;Z)V
    //   1459: aload_0
    //   1460: getfield 52	aczw:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1463: invokevirtual 2359	java/util/HashSet:clear	()V
    //   1466: aload 11
    //   1468: invokeinterface 2346 1 0
    //   1473: new 91	java/lang/StringBuilder
    //   1476: dup
    //   1477: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1480: aload_0
    //   1481: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1484: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1487: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: ldc_w 2339
    //   1493: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1496: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1499: invokeinterface 2362 2 0
    //   1504: pop
    //   1505: aload 11
    //   1507: invokeinterface 2346 1 0
    //   1512: invokeinterface 2354 1 0
    //   1517: pop
    //   1518: aload 8
    //   1520: astore 9
    //   1522: iload 6
    //   1524: ifeq +43 -> 1567
    //   1527: aload_0
    //   1528: getfield 120	aczw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1531: ldc_w 1910
    //   1534: ldc_w 611
    //   1537: ldc_w 611
    //   1540: ldc_w 2364
    //   1543: ldc_w 2364
    //   1546: iconst_0
    //   1547: iconst_0
    //   1548: ldc_w 611
    //   1551: ldc_w 611
    //   1554: ldc_w 611
    //   1557: ldc_w 611
    //   1560: invokestatic 1915	bdll:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1563: aload 8
    //   1565: astore 9
    //   1567: aload 7
    //   1569: astore_1
    //   1570: aload 9
    //   1572: astore 7
    //   1574: goto -370 -> 1204
    //   1577: new 91	java/lang/StringBuilder
    //   1580: dup
    //   1581: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1584: aload_1
    //   1585: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1588: ldc_w 2093
    //   1591: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1594: aload 13
    //   1596: getfield 358	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1599: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1605: astore_1
    //   1606: goto -252 -> 1354
    //   1609: aload_0
    //   1610: getfield 35	aczw:f	I
    //   1613: istore_3
    //   1614: goto -189 -> 1425
    //   1617: iload 6
    //   1619: ifeq +11 -> 1630
    //   1622: aload_0
    //   1623: getfield 41	aczw:i	I
    //   1626: istore_3
    //   1627: goto -202 -> 1425
    //   1630: aload_0
    //   1631: getfield 37	aczw:g	I
    //   1634: istore_3
    //   1635: goto -210 -> 1425
    //   1638: iconst_1
    //   1639: istore 4
    //   1641: goto -1460 -> 181
    //   1644: iconst_0
    //   1645: istore_3
    //   1646: goto -1525 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1649	0	this	aczw
    //   0	1649	1	paramArrayList	ArrayList<MessageRecord>
    //   0	1649	2	paramBoolean	boolean
    //   120	1526	3	k	int
    //   179	1461	4	m	int
    //   671	165	5	n	int
    //   196	1422	6	bool	boolean
    //   48	1525	7	localObject1	Object
    //   70	1494	8	localObject2	Object
    //   583	988	9	localObject3	Object
    //   156	777	10	localQQMessageFacade	QQMessageFacade
    //   573	933	11	localSharedPreferences	android.content.SharedPreferences
    //   666	240	12	localObject4	Object
    //   915	680	13	localMessageRecord	MessageRecord
    // Exception table:
    //   from	to	target	type
    //   602	673	879	finally
    //   691	719	879	finally
    //   736	738	879	finally
    //   880	882	879	finally
    //   755	826	1217	finally
    //   844	872	1217	finally
    //   884	886	1217	finally
    //   1218	1220	1217	finally
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop != 1010) && (paramMessageRecord.istroop != 1001) && (paramMessageRecord.istroop != 10002)) {}
    while (((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) || (((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002)) && ((paramMessageRecord.msgtype == -3001) || (!adak.d(paramMessageRecord)) || (adak.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord))))) {
      return false;
    }
    return true;
  }
  
  public boolean a(ArrayList<MessageRecord> paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    MessageRecord localMessageRecord;
    do
    {
      if (!paramArrayList.hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)paramArrayList.next();
    } while ((localMessageRecord.isSend()) || (localMessageRecord.isread) || ((adak.d(localMessageRecord)) && (!adak.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord))) || (FriendsStatusUtil.a(localMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (!aljo.a(localMessageRecord.frienduin)) || (!avlm.a(localMessageRecord)));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2001: 
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aczw
 * JD-Core Version:    0.7.0.1
 */