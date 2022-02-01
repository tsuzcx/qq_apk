import OnlinePushPack.DelMsgInfo;
import PushNotifyPack.C2CMsgReadedNotify;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.imcore.message.C2CMessageProcessor.4;
import com.tencent.imcore.message.C2CMessageProcessor.6;
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

public class acvt
  extends acvl
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
  
  public acvt(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 3;
    this.jdField_c_of_type_Int = 10;
    this.jdField_d_of_type_Int = 30;
    this.jdField_a_of_type_JavaUtilComparator = new acvu(this);
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
    acxm localacxm;
    do
    {
      k = paramInt;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localacxm = (acxm)((Iterator)localObject).next();
      arrayOfInt[0] = paramInt;
    } while (!localacxm.a(paramUinPairMsg, paramString, arrayOfInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    int k = arrayOfInt[0];
    return k;
  }
  
  private Pair<String, Integer> a(String paramString, msg_comm.UinPairMsg paramUinPairMsg, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ArrayList localArrayList1 = new ArrayList();
    long l6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject1 = paramUinPairMsg.msg.get();
    if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
      return new Pair(paramString, Integer.valueOf(0));
    }
    ArrayList localArrayList2 = new ArrayList();
    a((List)localObject1, localArrayList2);
    StringBuilder localStringBuilder = new StringBuilder();
    HashMap localHashMap = new HashMap();
    HashSet localHashSet = new HashSet();
    bbyn localbbyn = new bbyn(l6, Long.parseLong(paramString), true, paramBoolean2, paramBoolean3, false);
    localbbyn.jdField_e_of_type_Boolean = true;
    localbbyn.a(1000, localHashMap);
    localbbyn.a(1001, localHashSet);
    int n = 0;
    long l2 = -1L;
    localObject1 = paramString;
    int k = 0;
    long l1 = -1L;
    if (n < localArrayList2.size())
    {
      m = k;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
    }
    try
    {
      localObject4 = (msg_comm.Msg)localArrayList2.get(n);
      m = k;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      localObject5 = (msg_comm.MsgHead)((msg_comm.Msg)localObject4).msg_head.get();
      m = k;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      if (!((msg_comm.Msg)localObject4).msg_head.has())
      {
        m = k;
        l4 = l1;
        localObject2 = localObject1;
        l3 = l2;
        if (!QLog.isColorLevel()) {
          break label2385;
        }
        m = k;
        l4 = l1;
        localObject2 = localObject1;
        l3 = l2;
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage: msgList[" + n + "] : msg doesn't has msgHead.");
        break label2385;
      }
      m = k;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      l8 = ((msg_comm.MsgHead)localObject5).to_uin.get();
      m = k;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      l7 = ((msg_comm.MsgHead)localObject5).from_uin.get();
      m = k;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      l9 = ((msg_comm.MsgHead)localObject5).from_uin.get();
      m = k;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      l5 = ((msg_comm.MsgHead)localObject5).msg_time.get();
      if (l5 <= paramLong) {
        break label2376;
      }
      paramBoolean3 = false;
      bool = false;
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        Object localObject4;
        Object localObject5;
        long l8;
        long l7;
        long l9;
        long l5;
        localObject1 = localObject3;
        localObject3 = localException3;
        k = m;
        l1 = l4;
        l2 = l3;
        continue;
        paramBoolean3 = true;
        boolean bool = true;
      }
    }
    int m = k;
    long l4 = l1;
    Object localObject2 = localObject1;
    long l3 = l2;
    l8 = anqc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l9, l8, paramUinPairMsg.peer_uin.get(), paramUinPairMsg);
    m = k;
    l4 = l1;
    localObject2 = localObject1;
    l3 = l2;
    localbbyn.i = true;
    m = k;
    l4 = l1;
    localObject2 = localObject1;
    l3 = l2;
    localObject1 = String.valueOf(l8);
    m = k;
    l4 = l1;
    localObject2 = localObject1;
    l3 = l2;
    l9 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l8), 0);
    if ((l5 <= l9) && (bool))
    {
      m = k;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      if (QLog.isColorLevel())
      {
        m = k;
        l4 = l1;
        localObject2 = localObject1;
        l3 = l2;
        localStringBuilder.setLength(0);
        m = k;
        l4 = l1;
        localObject2 = localObject1;
        l3 = l2;
        localStringBuilder.append("<---decodeC2CMessagePackage : msgList[").append(n).append("] : filter msg by del time delTime =").append(l9).append(", msgTime = ").append(l5);
        m = k;
        l4 = l1;
        localObject2 = localObject1;
        l3 = l2;
        QLog.d("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
      }
    }
    else
    {
      m = k;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      localbbyn.jdField_a_of_type_Boolean = bool;
      m = k;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      localbbyn.jdField_e_of_type_Long = l8;
      m = k;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      localbbyn.h = paramBoolean3;
      m = k;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      localObject4 = a((msg_comm.Msg)localObject4, localbbyn).iterator();
      m = k;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      if (((Iterator)localObject4).hasNext())
      {
        m = k;
        l4 = l1;
        localObject2 = localObject1;
        l3 = l2;
        localObject5 = (MessageRecord)((Iterator)localObject4).next();
        m = k;
        l4 = l1;
        localObject2 = localObject1;
        l3 = l2;
        l5 = ((MessageRecord)localObject5).vipBubbleID;
        if (l5 != -1L)
        {
          m = k;
          l4 = l1;
          localObject2 = localObject1;
          l3 = l2;
          paramBoolean3 = bgnr.a(((MessageRecord)localObject5).issend);
          if (paramBoolean3) {
            l1 = l5;
          }
        }
        for (;;)
        {
          try
          {
            for (;;)
            {
              label934:
              m = ((MessageRecord)localObject5).istroop;
              try
              {
                paramBoolean3 = a((MessageRecord)localObject5, true);
                bool = b((MessageRecord)localObject5);
                if ((!paramBoolean3) && (!bool)) {
                  if ((((MessageRecord)localObject5).istroop == 1008) && ((localObject5 instanceof MessageForStructing)) && ((StructLongMessageDownloadProcessor.b((MessageRecord)localObject5)) || (StructLongMessageDownloadProcessor.d((MessageRecord)localObject5))))
                  {
                    localObject2 = ((MessageRecord)localObject5).getExtInfoFromExtStr("longMsg_State");
                    if ((localObject2 == null) || (!String.valueOf(3).equals(localObject2))) {
                      break label1683;
                    }
                  }
                }
                for (;;)
                {
                  if ((localObject5 instanceof MessageForMarketFace)) {
                    awmq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForMarketFace)localObject5);
                  }
                  if (anhk.az.equals(((MessageRecord)localObject5).frienduin)) {
                    ((MessageRecord)localObject5).time = NetConnInfoCenter.getServerTime();
                  }
                  if (anhk.aR.equals(((MessageRecord)localObject5).frienduin)) {
                    ((KandianDailyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(296)).b((MessageRecord)localObject5);
                  }
                  localArrayList1.add(localObject5);
                  k = KandianMergeManager.a((MessageRecord)localObject5, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                  if ((k == 0) || (k == 1))
                  {
                    localObject2 = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).a((MessageRecord)localObject5);
                    if (localObject2 != null) {
                      localArrayList1.add(localObject2);
                    }
                  }
                  Object localObject6;
                  if (((MessageRecord)localObject5).msgtype == -2002)
                  {
                    if ((!paramBoolean3) && (bcvj.a(((MessageRecord)localObject5).msgUid, ((MessageRecord)localObject5).shmsgseq) != null)) {
                      bdxh.a(true);
                    }
                    if ((paramBoolean3) && ((localObject5 instanceof MessageForPtt)) && (acwh.d(((MessageRecord)localObject5).istroop)))
                    {
                      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject5).frienduin, ((MessageRecord)localObject5).istroop).iterator();
                      while (((Iterator)localObject2).hasNext())
                      {
                        localObject6 = (MessageRecord)((Iterator)localObject2).next();
                        if (((localObject6 instanceof MessageForPtt)) && (((MessageRecord)localObject6).msgUid == ((MessageRecord)localObject5).msgUid) && (((MessageRecord)localObject6).shmsgseq == ((MessageRecord)localObject5).shmsgseq)) {
                          a((MessageForPtt)localObject6, (MessageForPtt)localObject5);
                        }
                      }
                    }
                  }
                  if ((!paramBoolean3) && (((MessageRecord)localObject5).istroop == 1008))
                  {
                    if (!"1".equals(((MessageRecord)localObject5).getExtInfoFromExtStr("is_AdArrive_Msg"))) {
                      break label1733;
                    }
                    localObject2 = ((MessageRecord)localObject5).getExtInfoFromExtStr("gdt_msgImp");
                    localObject6 = ((MessageRecord)localObject5).getExtInfoFromExtStr("pa_msgId");
                    String str2 = ((MessageRecord)localObject5).getExtInfoFromExtStr("gdt_view_id");
                    ArrayList localArrayList3 = new ArrayList();
                    localArrayList3.add(localObject6);
                    txr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", ((MessageRecord)localObject5).senderuin, (String)localObject2, str2, localArrayList3);
                  }
                  k = m;
                  break;
                  l2 = l5;
                  break label934;
                  m = k;
                  l4 = l1;
                  localObject2 = localObject1;
                  l3 = l2;
                  if (((MessageRecord)localObject5).msgtype == -2002)
                  {
                    m = k;
                    l4 = l1;
                    localObject2 = localObject1;
                    l3 = l2;
                    if (bgnr.a(((MessageRecord)localObject5).issend))
                    {
                      if (l1 != -1L)
                      {
                        m = k;
                        l4 = l1;
                        localObject2 = localObject1;
                        l3 = l2;
                        ((MessageRecord)localObject5).vipBubbleID = l1;
                        break label934;
                      }
                      m = k;
                      l4 = l1;
                      localObject2 = localObject1;
                      l3 = l2;
                      ((MessageRecord)localObject5).vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l8), String.valueOf(l7));
                      break label934;
                    }
                    if (l2 != -1L)
                    {
                      m = k;
                      l4 = l1;
                      localObject2 = localObject1;
                      l3 = l2;
                      ((MessageRecord)localObject5).vipBubbleID = l2;
                      break label934;
                    }
                    m = k;
                    l4 = l1;
                    localObject2 = localObject1;
                    l3 = l2;
                    ((MessageRecord)localObject5).vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l8), String.valueOf(l7));
                    break label934;
                  }
                  m = k;
                  l4 = l1;
                  localObject2 = localObject1;
                  l3 = l2;
                  ((MessageRecord)localObject5).vipBubbleID = 0L;
                  break label934;
                  label1683:
                  ((MessageRecord)localObject5).saveExtInfoToExtStr("longMsg_State", String.valueOf(1));
                  StructLongMessageDownloadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject5);
                }
                if (!QLog.isColorLevel()) {
                  break label1730;
                }
              }
              catch (Exception localException1)
              {
                k = m;
              }
            }
          }
          catch (Exception localException2)
          {
            label1730:
            label1733:
            Object localObject3;
            continue;
          }
          QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeC2CMessage error,", localException1);
          break label2385;
          if ("2290230341".equals(((MessageRecord)localObject5).frienduin)) {
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80090E1", "0X80090E1", 0, 0, "", "", "", "");
          }
        }
      }
      break label2385;
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
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l6, ((im_msg_body.MsgBody)((msg_comm.Msg)localObject3).msg_body.get()).msg_content.get().toByteArray(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject3).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject3).msg_head.get()).msg_time.get());
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
        m = acwh.a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        aqjq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if ((!paramBoolean3) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {
          break label2283;
        }
      }
      label2283:
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        ((QQMessageFacade)localObject1).a(localArrayList1, str1, paramBoolean1);
        a(localArrayList1);
        b(localArrayList1);
        a("handleGetBuddyMessageResp", true, m, paramBoolean3, paramBoolean2);
        a(localArrayList1, paramBoolean2);
        aofl.a((MessageRecord)localArrayList1.get(0), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (k == 1008)
        {
          localObject1 = (anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
          if (localObject1 != null) {
            ((anrs)localObject1).a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
        }
        if ((k != 0) || (localArrayList1.size() <= 0)) {
          break;
        }
        localObject1 = localArrayList1.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (MessageRecord)((Iterator)localObject1).next();
          bajn.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 0, (MessageRecord)localObject3);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage : dstUin:" + paramUinPairMsg + ", pkgUinType:" + k);
      }
      return new Pair(paramUinPairMsg, Integer.valueOf(k));
    }
    for (;;)
    {
      label2376:
      label2385:
      n += 1;
      break;
    }
  }
  
  private Pair<List<MessageRecord>, List<MessageRecord>> a(List<msg_comm.Msg> paramList, List<MessageRecord> paramList1, long paramLong1, long paramLong2, long paramLong3)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = ((anqg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92)).a(String.valueOf(paramLong1), paramLong2 - 30L, 30L + paramLong3);
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
        bctj.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap(), "");
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
  
  private void a(int paramInt, msg_comm.Msg paramMsg, ArrayList<MessageRecord> paramArrayList, MessageHandler paramMessageHandler, bbyn parambbyn)
  {
    bbzr localbbzr = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramInt);
    if (localbbzr != null) {
      localbbzr.a(paramMessageHandler, paramMsg, paramArrayList, parambbyn);
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
    //   7: getfield 657	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   10: ldc_w 684
    //   13: iconst_1
    //   14: invokevirtual 687	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   17: istore 11
    //   19: aload_1
    //   20: getfield 657	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   23: ldc_w 689
    //   26: iconst_1
    //   27: invokevirtual 687	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   30: istore 13
    //   32: aload_1
    //   33: getfield 657	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   36: ldc_w 691
    //   39: iconst_0
    //   40: invokevirtual 687	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   43: istore 12
    //   45: invokestatic 696	java/lang/System:currentTimeMillis	()J
    //   48: lstore 14
    //   50: aload_0
    //   51: aload_3
    //   52: checkcast 698	[B
    //   55: checkcast 698	[B
    //   58: invokespecial 700	acvt:a	([B)Lmsf/msgsvc/msg_svc$PbGetMsgResp;
    //   61: astore 25
    //   63: new 91	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   70: astore 23
    //   72: aload 25
    //   74: ifnull +25 -> 99
    //   77: aload 25
    //   79: getfield 703	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 75	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   85: ifeq +14 -> 99
    //   88: aload 25
    //   90: getfield 703	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   93: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   96: ifeq +150 -> 246
    //   99: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +104 -> 206
    //   105: aload 23
    //   107: iconst_0
    //   108: invokevirtual 283	java/lang/StringBuilder:setLength	(I)V
    //   111: aload 23
    //   113: ldc_w 705
    //   116: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 708	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   123: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: ldc_w 710
    //   129: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: astore 22
    //   134: aload 25
    //   136: ifnonnull +80 -> 216
    //   139: ldc_w 712
    //   142: astore_3
    //   143: aload 22
    //   145: aload_3
    //   146: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   149: ldc_w 714
    //   152: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: astore 22
    //   157: aload 25
    //   159: ifnonnull +72 -> 231
    //   162: ldc_w 712
    //   165: astore_3
    //   166: aload 22
    //   168: aload_3
    //   169: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   172: ldc_w 716
    //   175: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: iload 11
    //   180: invokevirtual 719	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   183: ldc_w 721
    //   186: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: iload 13
    //   191: invokevirtual 719	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: ldc 89
    //   197: iconst_2
    //   198: aload 23
    //   200: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 723	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload_0
    //   207: getfield 512	acvt:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   210: aload_1
    //   211: aload_2
    //   212: invokevirtual 725	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   215: return
    //   216: aload 25
    //   218: getfield 703	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   221: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   224: invokestatic 195	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   227: astore_3
    //   228: goto -85 -> 143
    //   231: aload 25
    //   233: getfield 728	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   236: invokevirtual 509	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   239: invokestatic 733	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   242: astore_3
    //   243: goto -77 -> 166
    //   246: aload 25
    //   248: getfield 736	msf/msgsvc/msg_svc$PbGetMsgResp:uin_pair_msgs	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   251: invokevirtual 184	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   254: astore 24
    //   256: aload_0
    //   257: getfield 512	acvt:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   260: iconst_0
    //   261: putfield 737	com/tencent/mobileqq/app/MessageHandler:g	I
    //   264: aload 25
    //   266: getfield 741	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   269: invokevirtual 744	com/tencent/mobileqq/pb/PBEnumField:has	()Z
    //   272: ifeq +13 -> 285
    //   275: aload 25
    //   277: getfield 741	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   280: invokevirtual 745	com/tencent/mobileqq/pb/PBEnumField:get	()I
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
    //   299: getfield 728	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   302: invokevirtual 509	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   305: ifeq +15 -> 320
    //   308: aload 25
    //   310: getfield 728	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   313: invokevirtual 515	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   316: invokevirtual 521	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   319: astore_2
    //   320: aconst_null
    //   321: astore 22
    //   323: aload 25
    //   325: getfield 748	msf/msgsvc/msg_svc$PbGetMsgResp:pubaccount_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   328: invokevirtual 509	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   331: ifeq +16 -> 347
    //   334: aload 25
    //   336: getfield 748	msf/msgsvc/msg_svc$PbGetMsgResp:pubaccount_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   339: invokevirtual 515	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   342: invokevirtual 521	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   345: astore 22
    //   347: iconst_0
    //   348: istore 6
    //   350: aload 25
    //   352: getfield 751	msf/msgsvc/msg_svc$PbGetMsgResp:msg_rsp_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   355: invokevirtual 75	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   358: ifeq +13 -> 371
    //   361: aload 25
    //   363: getfield 751	msf/msgsvc/msg_svc$PbGetMsgResp:msg_rsp_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   366: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   369: istore 6
    //   371: aload_0
    //   372: aload_2
    //   373: aload 22
    //   375: iload 6
    //   377: invokespecial 754	acvt:a	([B[BI)V
    //   380: iconst_0
    //   381: istore 10
    //   383: aload_0
    //   384: getfield 512	acvt:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   387: invokevirtual 756	com/tencent/mobileqq/app/MessageHandler:a	()Z
    //   390: ifeq +6 -> 396
    //   393: iconst_1
    //   394: istore 10
    //   396: iload 4
    //   398: ifle +25 -> 423
    //   401: aload_0
    //   402: getfield 512	acvt:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   405: iload 4
    //   407: aload_2
    //   408: iload 5
    //   410: iload 11
    //   412: iload 13
    //   414: iload 10
    //   416: aconst_null
    //   417: iload 6
    //   419: aconst_null
    //   420: invokevirtual 759	com/tencent/mobileqq/app/MessageHandler:a	(B[BIZZZLjava/lang/String;ILjava/lang/Object;)V
    //   423: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   426: ifeq +153 -> 579
    //   429: aload 23
    //   431: iconst_0
    //   432: invokevirtual 283	java/lang/StringBuilder:setLength	(I)V
    //   435: aload 23
    //   437: ldc_w 705
    //   440: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload_1
    //   444: invokevirtual 708	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   447: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   450: ldc_w 710
    //   453: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: aload 25
    //   458: getfield 703	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   461: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   464: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   467: ldc_w 761
    //   470: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload 25
    //   475: getfield 728	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   478: invokevirtual 509	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   481: invokevirtual 719	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   484: ldc 107
    //   486: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: iload 4
    //   491: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   494: ldc_w 763
    //   497: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: iload 5
    //   502: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   505: ldc_w 765
    //   508: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: iload 11
    //   513: invokevirtual 719	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   516: ldc_w 721
    //   519: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: iload 13
    //   524: invokevirtual 719	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   527: ldc_w 767
    //   530: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: aload 24
    //   535: invokeinterface 187 1 0
    //   540: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   543: ldc_w 769
    //   546: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: aload_3
    //   550: invokevirtual 774	java/lang/Object:hashCode	()I
    //   553: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   556: ldc_w 776
    //   559: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: iload 6
    //   564: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: ldc 89
    //   570: iconst_2
    //   571: aload 23
    //   573: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   579: iconst_0
    //   580: istore 7
    //   582: iload 7
    //   584: aload 24
    //   586: invokeinterface 187 1 0
    //   591: if_icmpge +1015 -> 1606
    //   594: invokestatic 696	java/lang/System:currentTimeMillis	()J
    //   597: lstore 14
    //   599: aload 24
    //   601: iload 7
    //   603: invokeinterface 602 2 0
    //   608: checkcast 65	msf/msgcomm/msg_comm$UinPairMsg
    //   611: astore 22
    //   613: aload 22
    //   615: getfield 259	msf/msgcomm/msg_comm$UinPairMsg:peer_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   618: invokevirtual 250	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   621: invokestatic 271	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   624: astore_2
    //   625: aload 22
    //   627: getfield 779	msf/msgcomm/msg_comm$UinPairMsg:last_read_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   630: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   633: i2l
    //   634: ldc2_w 780
    //   637: land
    //   638: lstore 16
    //   640: aload 22
    //   642: getfield 180	msf/msgcomm/msg_comm$UinPairMsg:msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   645: invokevirtual 184	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   648: astore_3
    //   649: aload 22
    //   651: getfield 784	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   654: invokevirtual 75	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   657: ifeq +847 -> 1504
    //   660: aload 22
    //   662: getfield 784	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   665: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   668: ifeq +836 -> 1504
    //   671: iconst_1
    //   672: istore 10
    //   674: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   677: ifeq +77 -> 754
    //   680: aload 23
    //   682: iconst_0
    //   683: invokevirtual 283	java/lang/StringBuilder:setLength	(I)V
    //   686: aload 23
    //   688: ldc_w 786
    //   691: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: aload_2
    //   695: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: ldc_w 788
    //   701: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: iload 10
    //   706: invokevirtual 719	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   709: ldc_w 790
    //   712: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: lload 16
    //   717: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   720: ldc_w 792
    //   723: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: astore 25
    //   728: aload_3
    //   729: ifnonnull +781 -> 1510
    //   732: ldc_w 712
    //   735: astore_1
    //   736: aload 25
    //   738: aload_1
    //   739: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   742: pop
    //   743: ldc 89
    //   745: iconst_2
    //   746: aload 23
    //   748: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   754: aload_3
    //   755: ifnull +811 -> 1566
    //   758: aload_3
    //   759: invokeinterface 187 1 0
    //   764: ifle +802 -> 1566
    //   767: aload_3
    //   768: invokeinterface 187 1 0
    //   773: iconst_1
    //   774: if_icmple +11 -> 785
    //   777: aload_3
    //   778: aload_0
    //   779: getfield 48	acvt:jdField_a_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   782: invokestatic 798	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   785: aload_0
    //   786: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   789: bipush 51
    //   791: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   794: checkcast 800	anmw
    //   797: aload_3
    //   798: iconst_0
    //   799: invokeinterface 602 2 0
    //   804: checkcast 228	msf/msgcomm/msg_comm$Msg
    //   807: getfield 232	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   810: invokevirtual 237	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   813: checkcast 234	msf/msgcomm/msg_comm$MsgHead
    //   816: getfield 253	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   819: invokevirtual 250	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   822: invokevirtual 803	anmw:a	(J)V
    //   825: aload_0
    //   826: getfield 512	acvt:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   829: aload_2
    //   830: iconst_0
    //   831: invokevirtual 806	com/tencent/mobileqq/app/MessageHandler:a	(Ljava/lang/String;I)Ljava/lang/Object;
    //   834: astore 25
    //   836: aload 25
    //   838: monitorenter
    //   839: aload_0
    //   840: aload_2
    //   841: aload 22
    //   843: lload 16
    //   845: iload 10
    //   847: iload 11
    //   849: iload 12
    //   851: invokespecial 808	acvt:a	(Ljava/lang/String;Lmsf/msgcomm/msg_comm$UinPairMsg;JZZZ)Landroid/util/Pair;
    //   854: astore_2
    //   855: aload_2
    //   856: getfield 812	android/util/Pair:first	Ljava/lang/Object;
    //   859: checkcast 268	java/lang/String
    //   862: astore_1
    //   863: aload_2
    //   864: getfield 815	android/util/Pair:second	Ljava/lang/Object;
    //   867: checkcast 191	java/lang/Integer
    //   870: invokevirtual 818	java/lang/Integer:intValue	()I
    //   873: istore 5
    //   875: aload 25
    //   877: monitorexit
    //   878: iload 10
    //   880: ifne +169 -> 1049
    //   883: aload_0
    //   884: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   887: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:a	()Lbbyp;
    //   890: aload_1
    //   891: invokevirtual 820	bbyp:g	(Ljava/lang/String;)J
    //   894: lstore 18
    //   896: aload_3
    //   897: iconst_0
    //   898: invokeinterface 602 2 0
    //   903: checkcast 228	msf/msgcomm/msg_comm$Msg
    //   906: getfield 232	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   909: invokevirtual 237	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   912: checkcast 234	msf/msgcomm/msg_comm$MsgHead
    //   915: getfield 256	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   918: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   921: i2l
    //   922: lstore 20
    //   924: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   927: ifeq +60 -> 987
    //   930: ldc 89
    //   932: iconst_2
    //   933: new 91	java/lang/StringBuilder
    //   936: dup
    //   937: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   940: ldc 94
    //   942: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: aload_1
    //   946: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: ldc_w 822
    //   952: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: lload 18
    //   957: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   960: ldc_w 824
    //   963: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: lload 20
    //   968: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   971: ldc 107
    //   973: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: iload 4
    //   978: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   981: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   984: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   987: lload 18
    //   989: lconst_0
    //   990: lcmp
    //   991: ifeq +11 -> 1002
    //   994: lload 20
    //   996: lload 18
    //   998: lcmp
    //   999: ifge +35 -> 1034
    //   1002: aload_0
    //   1003: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1006: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:a	()Lbbyp;
    //   1009: aload_1
    //   1010: lload 20
    //   1012: lconst_0
    //   1013: invokevirtual 827	bbyp:b	(Ljava/lang/String;JJ)V
    //   1016: iload 4
    //   1018: ifle +16 -> 1034
    //   1021: aload_0
    //   1022: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1025: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:a	()Lbbyp;
    //   1028: aload_1
    //   1029: lload 20
    //   1031: invokevirtual 829	bbyp:g	(Ljava/lang/String;J)V
    //   1034: iload 4
    //   1036: ifne +13 -> 1049
    //   1039: aload_0
    //   1040: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1043: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:a	()Lbbyp;
    //   1046: invokevirtual 831	bbyp:c	()V
    //   1049: iconst_0
    //   1050: istore 8
    //   1052: iload 11
    //   1054: ifeq +441 -> 1495
    //   1057: iload 5
    //   1059: sipush 1006
    //   1062: if_icmpne +24 -> 1086
    //   1065: aload_0
    //   1066: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1069: bipush 11
    //   1071: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1074: checkcast 833	awmz
    //   1077: aload_1
    //   1078: invokeinterface 835 2 0
    //   1083: ifnull +3 -> 1086
    //   1086: iload 5
    //   1088: invokestatic 838	acwh:a	(I)I
    //   1091: sipush 1032
    //   1094: if_icmpne +1165 -> 2259
    //   1097: iconst_0
    //   1098: istore 9
    //   1100: aload 22
    //   1102: aload_0
    //   1103: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1106: iload 9
    //   1108: invokestatic 843	autm:a	(Lmsf/msgcomm/msg_comm$UinPairMsg;Lcom/tencent/mobileqq/app/QQAppInterface;I)Ljava/lang/String;
    //   1111: astore_1
    //   1112: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1115: ifeq +51 -> 1166
    //   1118: ldc 89
    //   1120: iconst_2
    //   1121: new 91	java/lang/StringBuilder
    //   1124: dup
    //   1125: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1128: ldc_w 845
    //   1131: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1134: aload_1
    //   1135: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: ldc_w 847
    //   1141: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: iload 5
    //   1146: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1149: ldc_w 849
    //   1152: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: lload 16
    //   1157: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1160: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1163: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1166: iload 8
    //   1168: ifne +238 -> 1406
    //   1171: aload_1
    //   1172: iload 9
    //   1174: invokestatic 855	com/tencent/mobileqq/data/ConversationInfo:reportPublicaccoutTypeError	(Ljava/lang/String;I)Z
    //   1177: ifeq +229 -> 1406
    //   1180: new 91	java/lang/StringBuilder
    //   1183: dup
    //   1184: sipush 128
    //   1187: invokespecial 857	java/lang/StringBuilder:<init>	(I)V
    //   1190: astore_2
    //   1191: aload_2
    //   1192: ldc_w 858
    //   1195: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: ldc_w 860
    //   1201: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: aload_1
    //   1205: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1208: pop
    //   1209: aload_2
    //   1210: ldc_w 862
    //   1213: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: iload 9
    //   1218: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1221: pop
    //   1222: aload_3
    //   1223: ifnull +173 -> 1396
    //   1226: aload_3
    //   1227: invokeinterface 187 1 0
    //   1232: ifle +164 -> 1396
    //   1235: aload_3
    //   1236: iconst_0
    //   1237: invokeinterface 602 2 0
    //   1242: checkcast 228	msf/msgcomm/msg_comm$Msg
    //   1245: astore_3
    //   1246: aload_3
    //   1247: getfield 232	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1250: invokevirtual 238	msf/msgcomm/msg_comm$MsgHead:has	()Z
    //   1253: ifeq +143 -> 1396
    //   1256: aload_3
    //   1257: getfield 232	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1260: invokevirtual 237	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1263: checkcast 234	msf/msgcomm/msg_comm$MsgHead
    //   1266: astore_3
    //   1267: aload_2
    //   1268: ldc_w 864
    //   1271: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1274: aload_3
    //   1275: getfield 867	msf/msgcomm/msg_comm$MsgHead:msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1278: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1281: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1284: pop
    //   1285: aload_2
    //   1286: ldc_w 869
    //   1289: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1292: aload_3
    //   1293: getfield 601	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1296: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1299: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1302: pop
    //   1303: aload_2
    //   1304: ldc_w 871
    //   1307: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1310: aload_3
    //   1311: getfield 598	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1314: invokevirtual 250	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1317: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1320: pop
    //   1321: aload_2
    //   1322: ldc_w 873
    //   1325: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1328: aload_3
    //   1329: getfield 256	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1332: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1335: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1338: pop
    //   1339: aload_3
    //   1340: getfield 877	msf/msgcomm/msg_comm$MsgHead:c2c_tmp_msg_head	Lmsf/msgcomm/msg_comm$C2CTmpMsgHead;
    //   1343: invokevirtual 880	msf/msgcomm/msg_comm$C2CTmpMsgHead:has	()Z
    //   1346: ifeq +50 -> 1396
    //   1349: aload_3
    //   1350: getfield 877	msf/msgcomm/msg_comm$MsgHead:c2c_tmp_msg_head	Lmsf/msgcomm/msg_comm$C2CTmpMsgHead;
    //   1353: invokevirtual 881	msf/msgcomm/msg_comm$C2CTmpMsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1356: checkcast 879	msf/msgcomm/msg_comm$C2CTmpMsgHead
    //   1359: astore_3
    //   1360: aload_2
    //   1361: ldc_w 883
    //   1364: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1367: aload_3
    //   1368: getfield 884	msf/msgcomm/msg_comm$C2CTmpMsgHead:service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1371: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1374: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1377: pop
    //   1378: aload_2
    //   1379: ldc_w 886
    //   1382: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: aload_3
    //   1386: getfield 887	msf/msgcomm/msg_comm$C2CTmpMsgHead:c2c_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1389: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1392: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1395: pop
    //   1396: ldc 89
    //   1398: iconst_1
    //   1399: aload_2
    //   1400: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1403: invokestatic 723	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1406: new 889	android/os/Message
    //   1409: dup
    //   1410: invokespecial 890	android/os/Message:<init>	()V
    //   1413: astore_2
    //   1414: aload_2
    //   1415: iconst_1
    //   1416: putfield 893	android/os/Message:what	I
    //   1419: new 648	android/os/Bundle
    //   1422: dup
    //   1423: invokespecial 649	android/os/Bundle:<init>	()V
    //   1426: astore_3
    //   1427: aload_3
    //   1428: ldc_w 895
    //   1431: lload 16
    //   1433: invokevirtual 666	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1436: aload_3
    //   1437: ldc_w 897
    //   1440: aload_1
    //   1441: invokevirtual 900	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1444: aload_3
    //   1445: ldc_w 902
    //   1448: iload 9
    //   1450: invokevirtual 906	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1453: aload_2
    //   1454: aload_3
    //   1455: invokevirtual 910	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   1458: aload_0
    //   1459: getfield 512	acvt:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1462: astore_3
    //   1463: iload 4
    //   1465: ifgt +121 -> 1586
    //   1468: iconst_1
    //   1469: istore 10
    //   1471: aload_3
    //   1472: aload_2
    //   1473: iload 10
    //   1475: invokevirtual 913	com/tencent/mobileqq/app/MessageHandler:a	(Landroid/os/Message;Z)V
    //   1478: iload 6
    //   1480: iconst_2
    //   1481: if_icmpne +111 -> 1592
    //   1484: aload_0
    //   1485: getfield 61	acvt:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   1488: aload_1
    //   1489: invokeinterface 914 2 0
    //   1494: pop
    //   1495: iload 7
    //   1497: iconst_1
    //   1498: iadd
    //   1499: istore 7
    //   1501: goto -919 -> 582
    //   1504: iconst_0
    //   1505: istore 10
    //   1507: goto -833 -> 674
    //   1510: aload_3
    //   1511: invokeinterface 187 1 0
    //   1516: invokestatic 195	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1519: astore_1
    //   1520: goto -784 -> 736
    //   1523: astore_1
    //   1524: aload 25
    //   1526: monitorexit
    //   1527: aload_1
    //   1528: athrow
    //   1529: astore_1
    //   1530: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1533: ifeq -38 -> 1495
    //   1536: ldc 89
    //   1538: iconst_2
    //   1539: new 91	java/lang/StringBuilder
    //   1542: dup
    //   1543: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1546: ldc_w 916
    //   1549: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1552: aload_1
    //   1553: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1556: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1559: aload_1
    //   1560: invokestatic 634	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1563: goto -68 -> 1495
    //   1566: aload_0
    //   1567: iload 4
    //   1569: aload 22
    //   1571: aload_2
    //   1572: iconst_0
    //   1573: invokespecial 918	acvt:a	(BLmsf/msgcomm/msg_comm$UinPairMsg;Ljava/lang/String;I)I
    //   1576: istore 5
    //   1578: iconst_1
    //   1579: istore 8
    //   1581: aload_2
    //   1582: astore_1
    //   1583: goto -531 -> 1052
    //   1586: iconst_0
    //   1587: istore 10
    //   1589: goto -118 -> 1471
    //   1592: aload_0
    //   1593: getfield 59	acvt:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1596: aload_1
    //   1597: invokeinterface 914 2 0
    //   1602: pop
    //   1603: goto -108 -> 1495
    //   1606: iload 4
    //   1608: ifgt +544 -> 2152
    //   1611: aload_0
    //   1612: getfield 512	acvt:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1615: invokevirtual 919	com/tencent/mobileqq/app/MessageHandler:c	()V
    //   1618: iload 11
    //   1620: ifeq +454 -> 2074
    //   1623: aload_0
    //   1624: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1627: invokevirtual 922	com/tencent/mobileqq/app/QQAppInterface:a	()Lacvy;
    //   1630: invokevirtual 926	acvy:a	()Ljava/util/Set;
    //   1633: invokeinterface 492 1 0
    //   1638: astore_1
    //   1639: aload_1
    //   1640: invokeinterface 154 1 0
    //   1645: ifeq +414 -> 2059
    //   1648: aload_1
    //   1649: invokeinterface 158 1 0
    //   1654: checkcast 851	com/tencent/mobileqq/data/ConversationInfo
    //   1657: astore_2
    //   1658: aload_2
    //   1659: getfield 929	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1662: ifnull -23 -> 1639
    //   1665: aload_2
    //   1666: getfield 932	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1669: sipush 1036
    //   1672: if_icmpeq -33 -> 1639
    //   1675: aload_2
    //   1676: getfield 932	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1679: invokestatic 838	acwh:a	(I)I
    //   1682: sipush 1032
    //   1685: if_icmpeq -46 -> 1639
    //   1688: iload 6
    //   1690: iconst_1
    //   1691: if_icmpne +13 -> 1704
    //   1694: aload_2
    //   1695: getfield 932	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1698: sipush 1008
    //   1701: if_icmpeq -62 -> 1639
    //   1704: iload 6
    //   1706: iconst_2
    //   1707: if_icmpne +13 -> 1720
    //   1710: aload_2
    //   1711: getfield 932	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1714: sipush 1008
    //   1717: if_icmpne -78 -> 1639
    //   1720: iload 6
    //   1722: iconst_2
    //   1723: if_icmpeq +31 -> 1754
    //   1726: aload_0
    //   1727: getfield 59	acvt:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1730: invokeinterface 933 1 0
    //   1735: ifle +19 -> 1754
    //   1738: aload_0
    //   1739: getfield 59	acvt:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1742: aload_2
    //   1743: getfield 929	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1746: invokeinterface 936 2 0
    //   1751: ifne -112 -> 1639
    //   1754: iload 6
    //   1756: iconst_2
    //   1757: if_icmpne +31 -> 1788
    //   1760: aload_0
    //   1761: getfield 61	acvt:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   1764: invokeinterface 933 1 0
    //   1769: ifle +19 -> 1788
    //   1772: aload_0
    //   1773: getfield 61	acvt:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   1776: aload_2
    //   1777: getfield 929	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1780: invokeinterface 936 2 0
    //   1785: ifne -146 -> 1639
    //   1788: aload_2
    //   1789: getfield 932	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1792: invokestatic 414	acwh:d	(I)Z
    //   1795: ifeq -156 -> 1639
    //   1798: aload_2
    //   1799: invokestatic 939	acvy:c	(Lcom/tencent/mobileqq/data/ConversationInfo;)I
    //   1802: ifle -163 -> 1639
    //   1805: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1808: ifeq +45 -> 1853
    //   1811: ldc 89
    //   1813: iconst_2
    //   1814: new 91	java/lang/StringBuilder
    //   1817: dup
    //   1818: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1821: ldc_w 941
    //   1824: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1827: aload_2
    //   1828: getfield 929	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1831: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1834: ldc_w 943
    //   1837: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1840: aload_2
    //   1841: getfield 932	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1844: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1847: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1850: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1853: aload_2
    //   1854: getfield 929	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1857: invokevirtual 946	java/lang/String:length	()I
    //   1860: iconst_4
    //   1861: if_icmple -222 -> 1639
    //   1864: aload_2
    //   1865: getfield 932	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1868: sipush 1001
    //   1871: if_icmpne +134 -> 2005
    //   1874: aload_0
    //   1875: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1878: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:a	()Lbbyp;
    //   1881: aload_2
    //   1882: getfield 929	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1885: invokevirtual 950	bbyp:n	(Ljava/lang/String;)[B
    //   1888: astore_3
    //   1889: aload_3
    //   1890: ifnull -251 -> 1639
    //   1893: aload_3
    //   1894: arraylength
    //   1895: ifle -256 -> 1639
    //   1898: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1901: ifeq +29 -> 1930
    //   1904: ldc 89
    //   1906: iconst_2
    //   1907: new 91	java/lang/StringBuilder
    //   1910: dup
    //   1911: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1914: ldc_w 952
    //   1917: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1920: aload_3
    //   1921: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1924: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1927: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1930: new 889	android/os/Message
    //   1933: dup
    //   1934: invokespecial 890	android/os/Message:<init>	()V
    //   1937: astore_3
    //   1938: aload_3
    //   1939: iconst_1
    //   1940: putfield 893	android/os/Message:what	I
    //   1943: new 648	android/os/Bundle
    //   1946: dup
    //   1947: invokespecial 649	android/os/Bundle:<init>	()V
    //   1950: astore 22
    //   1952: aload 22
    //   1954: ldc_w 895
    //   1957: ldc2_w 953
    //   1960: invokevirtual 666	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1963: aload 22
    //   1965: ldc_w 897
    //   1968: aload_2
    //   1969: getfield 929	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1972: invokevirtual 900	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1975: aload 22
    //   1977: ldc_w 902
    //   1980: aload_2
    //   1981: getfield 932	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1984: invokevirtual 906	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1987: aload_3
    //   1988: aload 22
    //   1990: invokevirtual 910	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   1993: aload_0
    //   1994: getfield 512	acvt:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1997: aload_3
    //   1998: iconst_1
    //   1999: invokevirtual 913	com/tencent/mobileqq/app/MessageHandler:a	(Landroid/os/Message;Z)V
    //   2002: goto -363 -> 1639
    //   2005: aload_2
    //   2006: getfield 932	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   2009: sipush 10002
    //   2012: if_icmpne +21 -> 2033
    //   2015: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2018: ifeq -88 -> 1930
    //   2021: ldc 89
    //   2023: iconst_2
    //   2024: ldc_w 956
    //   2027: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2030: goto -100 -> 1930
    //   2033: aload_2
    //   2034: getfield 959	com/tencent/mobileqq/data/ConversationInfo:isImax	Z
    //   2037: ifeq -107 -> 1930
    //   2040: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2043: ifeq -404 -> 1639
    //   2046: ldc_w 961
    //   2049: iconst_2
    //   2050: ldc_w 963
    //   2053: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2056: goto -417 -> 1639
    //   2059: iload 6
    //   2061: iconst_2
    //   2062: if_icmpne +140 -> 2202
    //   2065: aload_0
    //   2066: getfield 61	acvt:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   2069: invokeinterface 966 1 0
    //   2074: invokestatic 972	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   2077: invokevirtual 975	com/tencent/util/MsgAutoMonitorUtil:markC2CFinishTime	()V
    //   2080: iload 6
    //   2082: tableswitch	default:+26 -> 2108, 0:+132->2214, 1:+153->2235, 2:+165->2247
    //   2109: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2112: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:a	()Lbbyp;
    //   2115: invokevirtual 977	bbyp:i	()V
    //   2118: aload_0
    //   2119: getfield 512	acvt:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2122: invokevirtual 756	com/tencent/mobileqq/app/MessageHandler:a	()Z
    //   2125: ifeq +27 -> 2152
    //   2128: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2131: ifeq +12 -> 2143
    //   2134: ldc 89
    //   2136: iconst_2
    //   2137: ldc_w 979
    //   2140: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2143: aload_0
    //   2144: getfield 512	acvt:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2147: iconst_0
    //   2148: iconst_0
    //   2149: invokevirtual 982	com/tencent/mobileqq/app/MessageHandler:a	(ZI)V
    //   2152: invokestatic 696	java/lang/System:currentTimeMillis	()J
    //   2155: lload 14
    //   2157: lsub
    //   2158: lstore 14
    //   2160: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2163: ifeq +30 -> 2193
    //   2166: ldc 89
    //   2168: iconst_2
    //   2169: new 91	java/lang/StringBuilder
    //   2172: dup
    //   2173: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   2176: ldc_w 984
    //   2179: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2182: lload 14
    //   2184: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2187: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2190: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2193: ldc_w 986
    //   2196: lload 14
    //   2198: invokestatic 988	aofl:a	(Ljava/lang/String;J)V
    //   2201: return
    //   2202: aload_0
    //   2203: getfield 59	acvt:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   2206: invokeinterface 966 1 0
    //   2211: goto -137 -> 2074
    //   2214: aload_0
    //   2215: sipush 4016
    //   2218: iconst_1
    //   2219: aconst_null
    //   2220: invokevirtual 681	acvt:a	(IZLjava/lang/Object;)V
    //   2223: aload_0
    //   2224: sipush 4001
    //   2227: iconst_1
    //   2228: aconst_null
    //   2229: invokevirtual 681	acvt:a	(IZLjava/lang/Object;)V
    //   2232: goto -124 -> 2108
    //   2235: aload_0
    //   2236: sipush 4001
    //   2239: iconst_1
    //   2240: aconst_null
    //   2241: invokevirtual 681	acvt:a	(IZLjava/lang/Object;)V
    //   2244: goto -136 -> 2108
    //   2247: aload_0
    //   2248: sipush 4016
    //   2251: iconst_1
    //   2252: aconst_null
    //   2253: invokevirtual 681	acvt:a	(IZLjava/lang/Object;)V
    //   2256: goto -148 -> 2108
    //   2259: iload 5
    //   2261: istore 9
    //   2263: goto -1163 -> 1100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2266	0	this	acvt
    //   0	2266	1	paramToServiceMsg	ToServiceMsg
    //   0	2266	2	paramFromServiceMsg	FromServiceMsg
    //   0	2266	3	paramObject	Object
    //   1	1606	4	b1	byte
    //   4	2256	5	k	int
    //   348	1733	6	m	int
    //   580	920	7	n	int
    //   1050	530	8	i1	int
    //   1098	1164	9	i2	int
    //   381	1207	10	bool1	boolean
    //   17	1602	11	bool2	boolean
    //   43	807	12	bool3	boolean
    //   30	493	13	bool4	boolean
    //   48	2149	14	l1	long
    //   638	794	16	l2	long
    //   894	103	18	l3	long
    //   922	108	20	l4	long
    //   132	1857	22	localObject1	Object
    //   70	677	23	localStringBuilder	StringBuilder
    //   254	346	24	localList	List
    // Exception table:
    //   from	to	target	type
    //   839	878	1523	finally
    //   1524	1527	1523	finally
    //   825	839	1529	java/lang/Exception
    //   1527	1529	1529	java/lang/Exception
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
      if (anhk.G.equals(paramString))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
        return;
      }
      if ((paramInt != 1001) || (Long.valueOf(paramString).longValue() <= anhk.g))
      {
        if ((paramInt == 1001) && ((acwh.c(paramString)) || (acwh.d(paramString))))
        {
          if (acwh.e(paramString))
          {
            arlh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, null);
            return;
          }
          if (acwh.d(paramString))
          {
            arlh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            return;
          }
          arlh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, null);
          return;
        }
        Object localObject;
        long l;
        if (paramInt == 1006)
        {
          localObject = bglf.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label360;
          }
          l = Long.valueOf((String)localObject).longValue();
        }
        while (l != -1L) {
          if (paramInt == 10007)
          {
            autm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPbMsgReadedReportReq, paramString, paramLong);
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
                  QLog.d("Q.msg.sendReadConfirm_PB", 4, "Readcomfirmed------->Sig:" + bgmj.a(paramString) + ",length:" + paramString.length);
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
  
  private void a(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      long l = System.currentTimeMillis() / 1000L;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if (localMessageRecord.istroop == 1008) {
          if ((!TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("public_account_send_flag"))) && (!TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("public_account_msg_id"))) && (!TextUtils.equals(localMessageRecord.frienduin, localMessageRecord.selfuin))) {
            ThreadManager.post(new C2CMessageProcessor.6(this, localMessageRecord.frienduin, localMessageRecord.selfuin, localMessageRecord.getExtInfoFromExtStr("public_account_msg_id"), localMessageRecord.time, l, localMessageRecord.getExtInfoFromExtStr("public_account_send_flag")), 5, null, false);
          } else if (QLog.isColorLevel()) {
            QLog.d("Q.msg.C2CMessageProcessor", 2, "reportPubAccMsg exception, public_account_send_flag null || public_account_msg_id null || ");
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
        localObject2 = new bbyn(l7, l2, true, false, false, false);
        ((bbyn)localObject2).h = true;
        paramMsg = a(paramMsg, (bbzk)localObject2);
        anqc.a(paramMsg);
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
        bool2 = anqc.a((ArrayList)localObject2);
        k = acwh.a((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (!bool2) {
          break label858;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop) {}
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
  
  private void a(msg_comm.Msg paramMsg, ArrayList<MessageRecord> paramArrayList, bbyn parambbyn, MessageHandler paramMessageHandler)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a().a().iterator();
    while (localIterator.hasNext()) {
      ((bbzr)localIterator.next()).a(paramMessageHandler, paramMsg, paramArrayList, parambbyn);
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
    bbyn localbbyn = new bbyn(l3, 0L, true, true, false, false);
    localbbyn.h = true;
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
      localbbyn.jdField_e_of_type_Long = l1;
      paramPbSearchRoamMsgInCloudResp = a(paramPbSearchRoamMsgInCloudResp, localbbyn);
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
          Collections.sort(localArrayList1, new acvx(this));
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
      Object localObject1 = (anqg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
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
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(str, ((Long)localObject4).longValue(), paramFromServiceMsg.last_msgtime.get(), paramToServiceMsg.extraData.getLong("lEndTime"), (short)0, paramFromServiceMsg.random.get(), 1, ((anqg)localObject1).a(), ((anqg)localObject1).b(), paramToServiceMsg.extraData.getBoolean("fetchMore"), n, bool2, bool3);
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
          l1 = anqc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((msg_comm.MsgHead)((msg_comm.Msg)localObject6).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject6).msg_head.get()).to_uin.get(), paramFromServiceMsg.peer_uin.get());
        }
        ((ArrayList)localObject3).addAll((Collection)a((List)localObject2, (List)localObject5, l1, ((Long)localObject4).longValue(), paramToServiceMsg.extraData.getLong("lEndTime")).second);
        localObject4 = new bbyn(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), l1, true, true, false, false);
        ((bbyn)localObject4).h = true;
        localObject5 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (msg_comm.Msg)((Iterator)localObject5).next();
          try
          {
            localObject6 = a((msg_comm.Msg)localObject6, (bbzk)localObject4);
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
          Collections.sort((List)localObject3, new acvv(this));
          if (localObject1 == null) {}
        }
        try
        {
          ((anqg)localObject1).a((List)localObject3, str, bool3);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a((ArrayList)localObject3, false);
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()));
          if ((localObject4 == null) || (((Long)((Pair)localObject4).first).longValue() > paramFromServiceMsg.last_msgtime.get())) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()), paramToServiceMsg.extraData.getLong("lBeginTime"), 0L);
          }
          ((anqg)localObject1).a().b(str, paramToServiceMsg.extraData.getLong("lBeginTime"), 3);
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
        PAMessage localPAMessage = agaw.a(localMessageRecord);
        if ((localPAMessage != null) && (localPAMessage.mMsgId > 0L)) {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localMessageRecord.frienduin, "mp_msg_sys_15", "msg_get", 0, 1, 0, Long.toString(localPAMessage.mMsgId), "", "", "");
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
        localObject1 = new bbyn(l7, l3, true, false, false, false);
        ((bbyn)localObject1).h = true;
        localObject1 = a(paramMsg, (bbzk)localObject1);
        anqc.a((List)localObject1);
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
      bbzj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2);
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
          bbyn localbbyn;
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
        l1 = anqc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).to_uin.get(), paramFromServiceMsg.peer_uin.get());
      }
      localbbyn = new bbyn(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), l1, true, true, false, false);
      localbbyn.h = true;
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
          localObject = a((msg_comm.Msg)localObject, localbbyn);
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
      Collections.sort(paramObject, new acvw(this));
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
    //   1: getfield 657	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 1012
    //   7: invokevirtual 1016	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   10: istore 4
    //   12: new 203	java/util/HashMap
    //   15: dup
    //   16: iconst_1
    //   17: invokespecial 990	java/util/HashMap:<init>	(I)V
    //   20: astore 7
    //   22: aload 7
    //   24: ldc_w 992
    //   27: aload_1
    //   28: getfield 657	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   31: ldc_w 994
    //   34: invokevirtual 997	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokevirtual 1001	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: pop
    //   41: aload 7
    //   43: ldc_w 1003
    //   46: aload_1
    //   47: getfield 657	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   50: ldc_w 1005
    //   53: invokevirtual 662	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   56: invokestatic 1008	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   59: invokevirtual 1001	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   62: pop
    //   63: aload 7
    //   65: ldc_w 1010
    //   68: iload 4
    //   70: invokestatic 195	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   73: invokevirtual 1001	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   76: pop
    //   77: new 1312	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp
    //   80: dup
    //   81: invokespecial 1708	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:<init>	()V
    //   84: astore 6
    //   86: aload 6
    //   88: aload_3
    //   89: checkcast 698	[B
    //   92: checkcast 698	[B
    //   95: invokevirtual 1709	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 1312	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp
    //   101: astore 6
    //   103: aload 6
    //   105: ifnull +67 -> 172
    //   108: new 1342	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody
    //   111: dup
    //   112: invokespecial 1710	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:<init>	()V
    //   115: astore_3
    //   116: aload 6
    //   118: getfield 1713	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:serialize_rspbody	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   121: invokevirtual 509	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   124: ifeq +139 -> 263
    //   127: aload_3
    //   128: aload 6
    //   130: getfield 1713	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:serialize_rspbody	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   133: invokevirtual 515	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   136: invokevirtual 521	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   139: invokevirtual 1714	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   142: checkcast 1342	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody
    //   145: astore_3
    //   146: aload_3
    //   147: ifnonnull +121 -> 268
    //   150: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +12 -> 165
    //   156: ldc 89
    //   158: iconst_2
    //   159: ldc_w 1716
    //   162: invokestatic 1022	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload_0
    //   166: aload_1
    //   167: aload_2
    //   168: iconst_0
    //   169: invokespecial 1718	acvt:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Z)V
    //   172: return
    //   173: astore_3
    //   174: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +13 -> 190
    //   180: ldc 89
    //   182: iconst_2
    //   183: ldc_w 1720
    //   186: aload_3
    //   187: invokestatic 457	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   190: aconst_null
    //   191: astore 6
    //   193: goto -90 -> 103
    //   196: astore_3
    //   197: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +13 -> 213
    //   203: ldc 89
    //   205: iconst_2
    //   206: ldc_w 1722
    //   209: aload_3
    //   210: invokestatic 457	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   213: aconst_null
    //   214: astore 6
    //   216: goto -113 -> 103
    //   219: astore_3
    //   220: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +13 -> 236
    //   226: ldc 89
    //   228: iconst_2
    //   229: ldc_w 1724
    //   232: aload_3
    //   233: invokestatic 457	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: aconst_null
    //   237: astore_3
    //   238: goto -92 -> 146
    //   241: astore_3
    //   242: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +13 -> 258
    //   248: ldc 89
    //   250: iconst_2
    //   251: ldc_w 1726
    //   254: aload_3
    //   255: invokestatic 457	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   258: aconst_null
    //   259: astore_3
    //   260: goto -114 -> 146
    //   263: aconst_null
    //   264: astore_3
    //   265: goto -119 -> 146
    //   268: aload_3
    //   269: getfield 1728	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:result	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   272: invokevirtual 745	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   275: istore 5
    //   277: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq +41 -> 321
    //   283: ldc 89
    //   285: iconst_2
    //   286: new 91	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   293: ldc_w 1730
    //   296: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: iload 5
    //   301: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   304: ldc_w 1732
    //   307: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: iload 4
    //   312: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   315: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 1022	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   343: invokespecial 1734	acvt:a	(Lmsf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp;Ltencent/im/oidb/searcher/oidb_c2c_searcher$RspBody;ILcom/tencent/qphone/base/remote/ToServiceMsg;ILjava/util/HashMap;)V
    //   346: return
    //   347: aload_0
    //   348: aload_1
    //   349: aload_2
    //   350: iconst_0
    //   351: invokespecial 1718	acvt:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Z)V
    //   354: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	this	acvt
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
  
  public List<MessageRecord> a(msg_comm.Msg paramMsg, bbzk parambbzk)
  {
    if (!(parambbzk instanceof bbyn)) {
      return new ArrayList();
    }
    bbyn localbbyn = (bbyn)parambbzk;
    long l4 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    if ((paramMsg == null) || (!paramMsg.msg_head.has()) || (!paramMsg.msg_body.has()))
    {
      if (QLog.isColorLevel())
      {
        parambbzk = new StringBuilder().append("decodeSinglePBMsg_C2C return : ");
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
    localbbyn.jdField_c_of_type_Int = 0;
    localbbyn.jdField_d_of_type_Int = 0;
    int i1;
    int n;
    int m;
    if (paramMsg.content_head.has())
    {
      parambbzk = (msg_comm.ContentHead)paramMsg.content_head.get();
      i1 = parambbzk.div_seq.get();
      n = parambbzk.pkg_num.get();
      m = parambbzk.pkg_index.get();
    }
    for (;;)
    {
      long l1 = -1L;
      if (!localbbyn.jdField_d_of_type_Boolean) {
        l1 = bbzf.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, String.valueOf(localbbyn.jdField_e_of_type_Long), String.valueOf(l5));
      }
      localbbyn.jdField_b_of_type_Long = l5;
      localbbyn.jdField_c_of_type_Long = l3;
      int i4 = bbzf.a(paramMsg);
      localbbyn.jdField_a_of_type_Int = i4;
      localbbyn.jdField_d_of_type_Long = anuk.a((int)l1, i4);
      localbbyn.jdField_b_of_type_Int = bbzf.e(paramMsg);
      if (l5 == localbbyn.jdField_a_of_type_Long)
      {
        localbbyn.jdField_a_of_type_Boolean = true;
        localbbyn.f = true;
      }
      for (;;)
      {
        label652:
        Object localObject1;
        if (QLog.isColorLevel())
        {
          parambbzk = new StringBuilder();
          parambbzk.append("<---decodeSinglePBMsg_C2C : decode msg: msgTime:").append(l3).append(" shortSeq:").append(i2).append(" uint32Seq:").append(localMsgHead.msg_seq.get()).append(" msgUid:").append(l6).append(" toUin:").append(l2).append(" senderUin:").append(l5).append(" friendUin:").append(localbbyn.jdField_e_of_type_Long).append(" isReaded:").append(localbbyn.jdField_a_of_type_Boolean).append(" isSyncFromOtherTerm:").append(localbbyn.f).append(" msgType:").append(i3).append(" c2CCmd:").append(k).append(" hasTemp:").append(localMsgHead.c2c_tmp_msg_head.has()).append(" hasShare:").append(paramMsg.appshare_info.has()).append(" pkgID:").append(l1).append(" longMsgID:").append(i1).append(" longMsgCount:").append(n).append(" longMsgIndex:").append(m).append("init_direction_flag").append(localbbyn.jdField_d_of_type_Int);
          QLog.d("Q.msg.C2CMessageProcessor", 2, parambbzk.toString());
          parambbzk = new ArrayList();
          a(i3, paramMsg, parambbzk, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, localbbyn);
          a(paramMsg, parambbzk, localbbyn, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler);
          if ((parambbzk.size() == 0) && (n > 1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C, empty long msg fragment");
            }
            localObject1 = (MessageForText)bbzh.a(-1000);
            ((MessageForText)localObject1).msgtype = -1000;
            ((MessageForText)localObject1).msg = "";
            parambbzk.add(localObject1);
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
              localbbyn.f = false;
              continue;
              if (localbbyn.jdField_e_of_type_Long != 0L) {
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
              localMessageRecord.selfuin = String.valueOf(localbbyn.jdField_a_of_type_Long);
              localMessageRecord.frienduin = String.valueOf(localbbyn.jdField_e_of_type_Long);
              localMessageRecord.senderuin = String.valueOf(localbbyn.jdField_b_of_type_Long);
              localMessageRecord.time = localbbyn.jdField_c_of_type_Long;
              localMessageRecord.shmsgseq = i2;
              localMessageRecord.msgUid = l6;
              localMessageRecord.istroop = localbbyn.jdField_c_of_type_Int;
              localMessageRecord.longMsgId = i1;
              localMessageRecord.longMsgCount = n;
              localMessageRecord.longMsgIndex = m;
              if ((1 == localbbyn.jdField_d_of_type_Int) && (acwh.t(localMessageRecord.istroop)) && (acwh.a(localMessageRecord.istroop) != 1032) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, acwh.a(localMessageRecord.istroop), acwh.a(acwh.a(localMessageRecord.istroop)))))
              {
                acwh.a(localMessageRecord, true);
                if (localMessageRecord.msgtype == -2058) {
                  EmojiStickerManager.a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                }
                if ((!acwh.t(localbbyn.jdField_c_of_type_Int)) || (!(localMessageRecord instanceof MessageForStructing))) {
                  break label1749;
                }
                k = aoff.a(localMessageRecord, 1);
                if (k > 0) {
                  localMessageRecord.saveExtInfoToExtStr("nearby_gift_msg", "1|" + k);
                }
                parambbzk = (MessageForStructing)localMessageRecord;
                if ((parambbzk.structingMsg.mMsgServiceID != 52) || ((anqt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(124) == null)) {
                  break label1749;
                }
                parambbzk = new NearbyFlowerMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambbzk);
                if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(parambbzk.sUin)) {
                  break label1693;
                }
                bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060AF", "0X80060AF", 0, 0, "", "", "", "");
              }
              for (;;)
              {
                if (!"4".equals(parambbzk.version)) {
                  break label1749;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.C2CMessageProcessor", 2, "<---received random chat flower message, don't put it to aio");
                }
                bbzf.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i2, l6, i3);
                break;
                acwh.a(localMessageRecord, false);
                break label1461;
                if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(parambbzk.rUin)) {
                  bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060B0", "0X80060B0", 0, 0, "", "", "", "");
                }
              }
              parambbzk = (msg_comm.C2CTmpMsgHead)localMsgHead.c2c_tmp_msg_head.get();
              if ((parambbzk != null) && (parambbzk.lock_display.has()) && (parambbzk.lock_display.get() == 1))
              {
                localMessageRecord.extLong |= 0x1;
                localMessageRecord.saveExtInfoToExtStr("lockDisplay", "true");
              }
              if ((localbbyn.jdField_c_of_type_Int == 0) && ((localMessageRecord instanceof MessageForPic))) {
                ((MessageForPic)localMessageRecord).bEnableEnc = true;
              }
              if (localbbyn.jdField_c_of_type_Int == 1006)
              {
                if (localMsgHead.from_nick.has()) {
                  ((anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(String.valueOf(localbbyn.jdField_e_of_type_Long), localMsgHead.from_nick.get());
                }
                localMessageRecord.frienduin = bglf.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(localbbyn.jdField_e_of_type_Long));
                localMessageRecord.senderuin = bglf.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l5));
                if ((TextUtils.isEmpty(localMessageRecord.frienduin)) && (localbbyn.jdField_d_of_type_Boolean)) {
                  localMessageRecord.frienduin = String.valueOf(localbbyn.jdField_e_of_type_Long);
                }
                if (localMessageRecord.frienduin == null)
                {
                  QLog.e("Q.msg.C2CMessageProcessor", 1, String.format("decodeMessage error, getPhoneNumByUin is null, friendUin: %d senderUin: %d uinType: %d msgType: %d", new Object[] { Long.valueOf(localbbyn.jdField_e_of_type_Long), Long.valueOf(l5), Integer.valueOf(localMessageRecord.istroop), Integer.valueOf(localMessageRecord.msgtype) }));
                  continue;
                }
              }
              if (localbbyn.f)
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
                localMessageRecord.vipBubbleID = localbbyn.jdField_d_of_type_Long;
                localMessageRecord.vipBubbleDiyTextId = localbbyn.jdField_a_of_type_Int;
                localMessageRecord.vipSubBubbleId = localbbyn.jdField_b_of_type_Int;
                if (localbbyn.jdField_b_of_type_Int > 0) {
                  localMessageRecord.saveExtInfoToExtStr("bubble_sub_id", String.valueOf(localbbyn.jdField_b_of_type_Int));
                }
                k = bbzf.c(paramMsg);
                if (k > 0) {
                  localMessageRecord.saveExtInfoToExtStr("vip_pendant_diy_id", String.valueOf(k));
                }
                k = bbzf.b(paramMsg);
                if (k >= 0) {
                  localMessageRecord.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(k));
                }
                k = bbzf.d(paramMsg);
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
                  parambbzk = (MessageForStructing)localMessageRecord;
                  if ((parambbzk.structingMsg != null) && (parambbzk.structingMsg.mMsgServiceID == 76)) {
                    ((noq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(171)).a(parambbzk);
                  }
                }
                if (localMessageRecord.msgtype == -7005)
                {
                  avsr.a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                  continue;
                  if (localMessageRecord.msgtype == -2037) {
                    break label2044;
                  }
                  localMessageRecord.isread = localbbyn.jdField_a_of_type_Boolean;
                }
              }
              catch (Throwable parambbzk)
              {
                for (;;)
                {
                  QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeMessage: ", parambbzk);
                }
                localArrayList.add(localMessageRecord);
                if (localbbyn.jdField_c_of_type_Int == 1036) {
                  bbzf.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i2, l6, i3);
                }
              }
            }
          } while (localMessageRecord.msgtype != -2039);
          label1693:
          localObject3 = (MessageForApollo)localMessageRecord;
          localamhd = (amhd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
          parambbzk = null;
          if (!QLog.isColorLevel()) {
            break label2531;
          }
          parambbzk = new StringBuilder("decode apollo c2c msg: ").append(", id: ").append(((MessageForApollo)localObject3).mApolloMessage.id).append(", name: ").append(new String(((MessageForApollo)localObject3).mApolloMessage.name)).append(", doubleAction: ").append(((MessageForApollo)localObject3).isDoubleAction()).append(", signTS: ").append(((MessageForApollo)localObject3).signTs);
          label2531:
          i5 = ((MessageForApollo)localObject3).isSend();
          if (((MessageForApollo)localObject3).mApolloMessage.peer_uin == 0L) {
            break label3101;
          }
        }
      }
      localObject2 = parambbzk.iterator();
      Object localObject3;
      amhd localamhd;
      label2553:
      ApolloBaseInfo localApolloBaseInfo;
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
          if ((localMessageRecord != null) && ((localbbyn.jdField_b_of_type_Long != 3338705755L) || (!tzo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) && ((localbbyn.jdField_b_of_type_Long != 2171946401L) || (!pha.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))))
          {
            if (localbbyn.jdField_b_of_type_Long == 2171946401L) {
              tzo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
            }
            if (((localbbyn.jdField_c_of_type_Int != 1025) && (localbbyn.jdField_c_of_type_Int != 1024)) || (localMessageRecord.msgtype != -1000) || (!localMessageRecord.msg.startsWith("default:SigT=")))
            {
              if (acwh.a(localbbyn.jdField_c_of_type_Int) == 1032)
              {
                localObject1 = null;
                parambbzk = (bbzk)localObject1;
                if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
                {
                  localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                  parambbzk = (bbzk)localObject1;
                  if (localObject3 != null) {
                    parambbzk = ((bbyp)localObject3).a(String.valueOf(localbbyn.jdField_e_of_type_Long), String.valueOf(localbbyn.jdField_a_of_type_Long));
                  }
                }
                bbzf.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i2, l6, i3, parambbzk);
                if (localbbyn.jdField_c_of_type_Int == 1032)
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
                localApolloBaseInfo = localamhd.b(((MessageForApollo)localObject3).mApolloMessage.peer_uin + "");
                l2 = ((MessageForApollo)localObject3).mApolloMessage.peer_ts;
                k = ((MessageForApollo)localObject3).mApolloMessage.peer_status;
                label2632:
                if ((QLog.isColorLevel()) && (localApolloBaseInfo != null)) {
                  parambbzk.append("\n fuin: ").append(localApolloBaseInfo.uin).append(", msg time: ").append(localMessageRecord.time).append(", msg ts: ").append(l2).append(", svr ts: ").append(localApolloBaseInfo.apolloServerTS).append(", update time: ").append(localApolloBaseInfo.apolloUpdateTime).append(", status: ").append(k);
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
          localamhd.a(localApolloBaseInfo);
          if (QLog.isColorLevel()) {
            parambbzk.append("\n save apollo info fuin: ").append(localApolloBaseInfo.uin).append("-->").append(localApolloBaseInfo.apolloVipFlag).append("|").append(localApolloBaseInfo.apolloStatus).append("|").append(localApolloBaseInfo.apolloLocalTS).append("|").append(localApolloBaseInfo.apolloServerTS).append("|").append(localApolloBaseInfo.apolloUpdateTime).append("|").append(localApolloBaseInfo.apolloSignValidTS);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, parambbzk.toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break;
        }
        k = localamhd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        parambbzk = "";
        if (((MessageForApollo)localObject3).msgType == 0) {
          parambbzk = String.valueOf(((MessageForApollo)localObject3).mApolloMessage.id);
        }
        for (;;)
        {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "rev_action", String.valueOf(((MessageForApollo)localObject3).mApolloMessage.peer_uin), 0, ((MessageForApollo)localObject3).msgType, new String[] { parambbzk, Integer.toString(k), Integer.toString(amhd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)), String.valueOf(System.currentTimeMillis() / 1000L) });
          break;
          label3101:
          k = 0;
          break label2553;
          localApolloBaseInfo = localamhd.b(((MessageForApollo)localObject3).senderuin);
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
            parambbzk = "" + ((MessageForApollo)localObject3).gameId;
          }
        }
        if ((localbbyn.jdField_c_of_type_Int == 1008) && (paramMsg.msg_body.has()))
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
                parambbzk = (im_msg_body.Elem)paramMsg.next();
                if (parambbzk.pub_acc_info.has())
                {
                  k = parambbzk.pub_acc_info.uint32_is_inter_num.get();
                  paramMsg = parambbzk.pub_acc_info.string_msg_template_id.get();
                  if (k != 0)
                  {
                    parambbzk = localArrayList.iterator();
                    while (parambbzk.hasNext()) {
                      ((MessageRecord)parambbzk.next()).saveExtInfoToExtStr("inter_num", String.valueOf(k));
                    }
                  }
                  parambbzk = localArrayList.iterator();
                  while (parambbzk.hasNext()) {
                    ((MessageRecord)parambbzk.next()).saveExtInfoToExtStr("msg_template_id", paramMsg);
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
          parambbzk = (MessageRecord)paramMsg.next();
          m = parambbzk.istroop;
          if (parambbzk.isread) {
            break label3514;
          }
          k += 1;
        }
        label3514:
        for (;;)
        {
          break;
          bcsa.a(0, 1, m, k);
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
      autm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, paramC2CMsgReadedNotify);
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
    if (acwh.d(paramInt))
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
    //   12: invokestatic 2271	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   15: aload_0
    //   16: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   22: invokestatic 2276	com/tencent/mobileqq/activity/UserguideActivity:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   25: ifne -14 -> 11
    //   28: invokestatic 2271	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   31: invokevirtual 2280	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   34: aload_0
    //   35: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   38: invokestatic 2285	bghu:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)Z
    //   41: ifeq -30 -> 11
    //   44: aload_1
    //   45: invokevirtual 573	java/util/ArrayList:iterator	()Ljava/util/Iterator;
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
    //   77: invokestatic 1901	acwh:t	(I)Z
    //   80: ifeq -30 -> 50
    //   83: aload 8
    //   85: invokestatic 2286	acwh:d	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   88: ifeq -38 -> 50
    //   91: aload_0
    //   92: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   95: aload 8
    //   97: invokestatic 2289	acwh:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   100: ifne -50 -> 50
    //   103: aload 8
    //   105: invokevirtual 1981	com/tencent/mobileqq/data/MessageRecord:isSend	()Z
    //   108: ifne -58 -> 50
    //   111: aload 8
    //   113: getfield 1246	com/tencent/mobileqq/data/MessageRecord:isread	Z
    //   116: ifne -66 -> 50
    //   119: iconst_1
    //   120: istore_3
    //   121: iload_3
    //   122: ifeq -111 -> 11
    //   125: aload_0
    //   126: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   129: bipush 51
    //   131: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   134: checkcast 800	anmw
    //   137: aload_0
    //   138: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   141: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   144: invokevirtual 2292	anmw:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   147: astore 7
    //   149: aload_0
    //   150: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   153: invokevirtual 125	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   156: astore 10
    //   158: aload 7
    //   160: ifnonnull +566 -> 726
    //   163: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +1472 -> 1638
    //   169: ldc 89
    //   171: iconst_2
    //   172: ldc_w 2294
    //   175: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: iconst_1
    //   179: istore 4
    //   181: aload_0
    //   182: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   185: bipush 106
    //   187: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   190: checkcast 2296	axby
    //   193: invokevirtual 2297	axby:a	()Z
    //   196: istore 6
    //   198: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +42 -> 243
    //   204: ldc_w 2299
    //   207: iconst_2
    //   208: new 91	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 2301
    //   218: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: iload 4
    //   223: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: ldc_w 2303
    //   229: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: iload 6
    //   234: invokevirtual 719	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   237: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload_0
    //   244: getfield 2304	acvt:jdField_a_of_type_Boolean	Z
    //   247: ifne +293 -> 540
    //   250: invokestatic 2309	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   253: getstatic 2315	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:OneyWayDateMsgNotifyCfg	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   256: invokevirtual 2317	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   259: invokevirtual 2319	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   262: astore 8
    //   264: invokestatic 2309	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   267: getstatic 2322	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:OneyWayLBSFriendMsgNotifyCfg	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   270: invokevirtual 2317	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   273: invokevirtual 2319	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   276: astore 7
    //   278: aload 8
    //   280: ldc_w 2324
    //   283: invokevirtual 2328	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   286: astore 8
    //   288: aload 7
    //   290: ldc_w 2324
    //   293: invokevirtual 2328	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   319: invokestatic 1577	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   322: putfield 27	acvt:jdField_a_of_type_Int	I
    //   325: aload_0
    //   326: aload 8
    //   328: iconst_1
    //   329: aaload
    //   330: invokestatic 1577	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   333: putfield 29	acvt:jdField_b_of_type_Int	I
    //   336: aload_0
    //   337: aload 8
    //   339: iconst_2
    //   340: aaload
    //   341: invokestatic 1577	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   344: putfield 31	acvt:jdField_c_of_type_Int	I
    //   347: aload_0
    //   348: aload 8
    //   350: iconst_3
    //   351: aaload
    //   352: invokestatic 1577	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   355: putfield 33	acvt:jdField_d_of_type_Int	I
    //   358: aload_0
    //   359: aload 7
    //   361: iconst_0
    //   362: aaload
    //   363: invokestatic 1577	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   366: putfield 35	acvt:f	I
    //   369: aload_0
    //   370: aload 7
    //   372: iconst_1
    //   373: aaload
    //   374: invokestatic 1577	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   377: putfield 37	acvt:g	I
    //   380: aload_0
    //   381: aload 7
    //   383: iconst_2
    //   384: aaload
    //   385: invokestatic 1577	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   388: putfield 39	acvt:h	I
    //   391: aload_0
    //   392: aload 7
    //   394: iconst_3
    //   395: aaload
    //   396: invokestatic 1577	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   399: putfield 41	acvt:i	I
    //   402: invokestatic 1090	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   405: ifeq +130 -> 535
    //   408: ldc_w 2330
    //   411: iconst_4
    //   412: new 91	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   419: ldc_w 2332
    //   422: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload_0
    //   426: getfield 27	acvt:jdField_a_of_type_Int	I
    //   429: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   432: ldc_w 2111
    //   435: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload_0
    //   439: getfield 29	acvt:jdField_b_of_type_Int	I
    //   442: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: ldc_w 2111
    //   448: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload_0
    //   452: getfield 31	acvt:jdField_c_of_type_Int	I
    //   455: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   458: ldc_w 2111
    //   461: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload_0
    //   465: getfield 33	acvt:jdField_d_of_type_Int	I
    //   468: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   471: ldc_w 2334
    //   474: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload_0
    //   478: getfield 35	acvt:f	I
    //   481: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   484: ldc_w 2111
    //   487: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload_0
    //   491: getfield 37	acvt:g	I
    //   494: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   497: ldc_w 2111
    //   500: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: aload_0
    //   504: getfield 39	acvt:h	I
    //   507: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   510: ldc_w 2111
    //   513: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_0
    //   517: getfield 41	acvt:i	I
    //   520: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   523: ldc_w 2336
    //   526: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   535: aload_0
    //   536: iconst_1
    //   537: putfield 2304	acvt:jdField_a_of_type_Boolean	Z
    //   540: invokestatic 2271	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   543: new 91	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   550: aload_0
    //   551: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   554: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   557: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: ldc_w 2338
    //   563: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: iconst_0
    //   570: invokevirtual 2342	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   573: astore 11
    //   575: ldc_w 433
    //   578: astore 8
    //   580: ldc_w 433
    //   583: astore 9
    //   585: aload 8
    //   587: astore 7
    //   589: aload_0
    //   590: getfield 50	acvt:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   593: ifnonnull +145 -> 738
    //   596: aload_0
    //   597: monitorenter
    //   598: aload 8
    //   600: astore 7
    //   602: aload_0
    //   603: getfield 50	acvt:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   606: ifnonnull +130 -> 736
    //   609: aload_0
    //   610: new 54	java/util/HashSet
    //   613: dup
    //   614: invokespecial 57	java/util/HashSet:<init>	()V
    //   617: putfield 50	acvt:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   620: aload 11
    //   622: new 91	java/lang/StringBuilder
    //   625: dup
    //   626: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   629: aload_0
    //   630: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   633: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   636: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: ldc_w 2344
    //   642: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: ldc_w 433
    //   651: invokeinterface 2349 3 0
    //   656: astore 8
    //   658: aload 8
    //   660: ldc_w 2324
    //   663: invokevirtual 2328	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   693: invokevirtual 946	java/lang/String:length	()I
    //   696: ifle +23 -> 719
    //   699: aload 7
    //   701: invokestatic 212	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   704: lconst_0
    //   705: lcmp
    //   706: ifle +13 -> 719
    //   709: aload_0
    //   710: getfield 50	acvt:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   713: aload 7
    //   715: invokevirtual 2350	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   718: pop
    //   719: iload_3
    //   720: iconst_1
    //   721: iadd
    //   722: istore_3
    //   723: goto -48 -> 675
    //   726: aload 7
    //   728: getfield 2355	com/tencent/mobileqq/data/Card:shGender	S
    //   731: istore 4
    //   733: goto -552 -> 181
    //   736: aload_0
    //   737: monitorexit
    //   738: aload 9
    //   740: astore 8
    //   742: aload_0
    //   743: getfield 52	acvt:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   746: ifnonnull +140 -> 886
    //   749: aload_0
    //   750: monitorenter
    //   751: aload 9
    //   753: astore 8
    //   755: aload_0
    //   756: getfield 52	acvt:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   759: ifnonnull +125 -> 884
    //   762: aload_0
    //   763: new 54	java/util/HashSet
    //   766: dup
    //   767: invokespecial 57	java/util/HashSet:<init>	()V
    //   770: putfield 52	acvt:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   773: aload 11
    //   775: new 91	java/lang/StringBuilder
    //   778: dup
    //   779: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   782: aload_0
    //   783: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   786: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   789: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: ldc_w 2357
    //   795: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   801: ldc_w 433
    //   804: invokeinterface 2349 3 0
    //   809: astore 9
    //   811: aload 9
    //   813: ldc_w 2324
    //   816: invokevirtual 2328	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   846: invokevirtual 946	java/lang/String:length	()I
    //   849: ifle +23 -> 872
    //   852: aload 8
    //   854: invokestatic 212	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   857: lconst_0
    //   858: lcmp
    //   859: ifle +13 -> 872
    //   862: aload_0
    //   863: getfield 52	acvt:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   866: aload 8
    //   868: invokevirtual 2350	java/util/HashSet:add	(Ljava/lang/Object;)Z
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
    //   887: invokevirtual 573	java/util/ArrayList:iterator	()Ljava/util/Iterator;
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
    //   923: invokevirtual 2359	acvt:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
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
    //   953: getfield 50	acvt:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   956: aload 13
    //   958: getfield 358	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   961: invokevirtual 2360	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   964: ifne +89 -> 1053
    //   967: aload_0
    //   968: getfield 50	acvt:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   971: aload 13
    //   973: getfield 358	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   976: invokevirtual 2350	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   979: pop
    //   980: aload 7
    //   982: invokevirtual 946	java/lang/String:length	()I
    //   985: ifne +237 -> 1222
    //   988: aload 13
    //   990: getfield 358	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   993: astore 7
    //   995: aload 11
    //   997: invokeinterface 2364 1 0
    //   1002: new 91	java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1009: aload_0
    //   1010: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1013: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1016: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: ldc_w 2344
    //   1022: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1028: aload 7
    //   1030: invokeinterface 2369 3 0
    //   1035: pop
    //   1036: aload 11
    //   1038: invokeinterface 2364 1 0
    //   1043: invokeinterface 2372 1 0
    //   1048: pop
    //   1049: aload 7
    //   1051: astore 8
    //   1053: iload 4
    //   1055: ifne +209 -> 1264
    //   1058: iload 6
    //   1060: ifeq +196 -> 1256
    //   1063: aload_0
    //   1064: getfield 31	acvt:jdField_c_of_type_Int	I
    //   1067: istore_3
    //   1068: aload_0
    //   1069: aload_0
    //   1070: getfield 50	acvt:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1073: invokevirtual 2373	java/util/HashSet:size	()I
    //   1076: putfield 2375	acvt:e	I
    //   1079: aload_0
    //   1080: getfield 2375	acvt:e	I
    //   1083: iload_3
    //   1084: irem
    //   1085: ifne +113 -> 1198
    //   1088: aload_0
    //   1089: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1092: aload 13
    //   1094: iload_2
    //   1095: invokevirtual 2376	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/MessageRecord;Z)V
    //   1098: aload_0
    //   1099: getfield 50	acvt:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1102: invokevirtual 2377	java/util/HashSet:clear	()V
    //   1105: aload 11
    //   1107: invokeinterface 2364 1 0
    //   1112: new 91	java/lang/StringBuilder
    //   1115: dup
    //   1116: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1119: aload_0
    //   1120: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1123: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1126: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: ldc_w 2344
    //   1132: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1138: invokeinterface 2380 2 0
    //   1143: pop
    //   1144: aload 11
    //   1146: invokeinterface 2364 1 0
    //   1151: invokeinterface 2372 1 0
    //   1156: pop
    //   1157: iload 6
    //   1159: ifeq +39 -> 1198
    //   1162: aload_0
    //   1163: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1166: ldc_w 461
    //   1169: ldc_w 433
    //   1172: ldc_w 433
    //   1175: ldc_w 2382
    //   1178: ldc_w 2382
    //   1181: iconst_0
    //   1182: iconst_0
    //   1183: ldc_w 433
    //   1186: ldc_w 433
    //   1189: ldc_w 433
    //   1192: ldc_w 433
    //   1195: invokestatic 468	bcst:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
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
    //   1234: ldc_w 2111
    //   1237: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: aload 13
    //   1242: getfield 358	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1245: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1251: astore 7
    //   1253: goto -258 -> 995
    //   1256: aload_0
    //   1257: getfield 27	acvt:jdField_a_of_type_Int	I
    //   1260: istore_3
    //   1261: goto -193 -> 1068
    //   1264: iload 6
    //   1266: ifeq +11 -> 1277
    //   1269: aload_0
    //   1270: getfield 33	acvt:jdField_d_of_type_Int	I
    //   1273: istore_3
    //   1274: goto -206 -> 1068
    //   1277: aload_0
    //   1278: getfield 29	acvt:jdField_b_of_type_Int	I
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
    //   1314: getfield 52	acvt:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1317: aload 13
    //   1319: getfield 358	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1322: invokevirtual 2360	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   1325: ifne +85 -> 1410
    //   1328: aload_0
    //   1329: getfield 52	acvt:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1332: aload 13
    //   1334: getfield 358	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1337: invokevirtual 2350	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1340: pop
    //   1341: aload_1
    //   1342: invokevirtual 946	java/lang/String:length	()I
    //   1345: ifne +232 -> 1577
    //   1348: aload 13
    //   1350: getfield 358	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1353: astore_1
    //   1354: aload 11
    //   1356: invokeinterface 2364 1 0
    //   1361: new 91	java/lang/StringBuilder
    //   1364: dup
    //   1365: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1368: aload_0
    //   1369: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1372: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1375: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: ldc_w 2357
    //   1381: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1384: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1387: aload_1
    //   1388: invokeinterface 2369 3 0
    //   1393: pop
    //   1394: aload 11
    //   1396: invokeinterface 2364 1 0
    //   1401: invokeinterface 2372 1 0
    //   1406: pop
    //   1407: aload_1
    //   1408: astore 8
    //   1410: iload 4
    //   1412: ifne +205 -> 1617
    //   1415: iload 6
    //   1417: ifeq +192 -> 1609
    //   1420: aload_0
    //   1421: getfield 39	acvt:h	I
    //   1424: istore_3
    //   1425: aload_0
    //   1426: aload_0
    //   1427: getfield 52	acvt:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1430: invokevirtual 2373	java/util/HashSet:size	()I
    //   1433: putfield 2384	acvt:j	I
    //   1436: aload 8
    //   1438: astore 9
    //   1440: aload_0
    //   1441: getfield 2384	acvt:j	I
    //   1444: iload_3
    //   1445: irem
    //   1446: ifne +121 -> 1567
    //   1449: aload_0
    //   1450: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1453: aload 13
    //   1455: iload_2
    //   1456: invokevirtual 2376	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/MessageRecord;Z)V
    //   1459: aload_0
    //   1460: getfield 52	acvt:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1463: invokevirtual 2377	java/util/HashSet:clear	()V
    //   1466: aload 11
    //   1468: invokeinterface 2364 1 0
    //   1473: new 91	java/lang/StringBuilder
    //   1476: dup
    //   1477: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1480: aload_0
    //   1481: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1484: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1487: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: ldc_w 2357
    //   1493: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1496: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1499: invokeinterface 2380 2 0
    //   1504: pop
    //   1505: aload 11
    //   1507: invokeinterface 2364 1 0
    //   1512: invokeinterface 2372 1 0
    //   1517: pop
    //   1518: aload 8
    //   1520: astore 9
    //   1522: iload 6
    //   1524: ifeq +43 -> 1567
    //   1527: aload_0
    //   1528: getfield 120	acvt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1531: ldc_w 461
    //   1534: ldc_w 433
    //   1537: ldc_w 433
    //   1540: ldc_w 2382
    //   1543: ldc_w 2382
    //   1546: iconst_0
    //   1547: iconst_0
    //   1548: ldc_w 433
    //   1551: ldc_w 433
    //   1554: ldc_w 433
    //   1557: ldc_w 433
    //   1560: invokestatic 468	bcst:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
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
    //   1588: ldc_w 2111
    //   1591: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1594: aload 13
    //   1596: getfield 358	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1599: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1605: astore_1
    //   1606: goto -252 -> 1354
    //   1609: aload_0
    //   1610: getfield 35	acvt:f	I
    //   1613: istore_3
    //   1614: goto -189 -> 1425
    //   1617: iload 6
    //   1619: ifeq +11 -> 1630
    //   1622: aload_0
    //   1623: getfield 41	acvt:i	I
    //   1626: istore_3
    //   1627: goto -202 -> 1425
    //   1630: aload_0
    //   1631: getfield 37	acvt:g	I
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
    //   0	1649	0	this	acvt
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
    while (((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) || (((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002)) && ((paramMessageRecord.msgtype == -3001) || (!acwh.d(paramMessageRecord)) || (acwh.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord))))) {
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
    } while ((localMessageRecord.isSend()) || (localMessageRecord.isread) || ((acwh.d(localMessageRecord)) && (!acwh.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord))) || (FriendsStatusUtil.a(localMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (!akxz.a(localMessageRecord.frienduin)) || (!autm.a(localMessageRecord)));
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
 * Qualified Name:     acvt
 * JD-Core Version:    0.7.0.1
 */