import OnlinePushPack.DelMsgInfo;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.C2CMessageProcessor.1;
import com.tencent.mobileqq.app.message.C2CMessageProcessor.5;
import com.tencent.mobileqq.app.message.C2CMessageProcessor.7;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.ExtGroupKeyInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbGetOneDayRoamMsgResp;
import msf.msgsvc.msg_svc.PbGetRoamMsgResp;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.PubAccInfo;
import tencent.im.msg.im_msg_body.RichText;

public class akak
  extends akac
{
  HashSet<String> jdField_a_of_type_JavaUtilHashSet = null;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  HashSet<String> jdField_b_of_type_JavaUtilHashSet = null;
  private Set<String> jdField_b_of_type_JavaUtilSet = new HashSet();
  public int d = 1;
  public int e = 3;
  public int f = 10;
  public int g = 30;
  public int h;
  public int i = 1;
  public int j = 5;
  public int k = 10;
  public int l = 50;
  public int m;
  
  public akak(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private Pair<String, Integer> a(String paramString, msg_comm.UinPairMsg paramUinPairMsg, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ArrayList localArrayList1 = new ArrayList();
    new ArrayList();
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
    awam localawam = new awam(l6, Long.parseLong(paramString), true, paramBoolean2, paramBoolean3, false);
    localawam.jdField_e_of_type_Boolean = true;
    localawam.a(1000, localHashMap);
    localawam.a(1001, localHashSet);
    int i2 = 0;
    int n = 0;
    localObject1 = paramString;
    long l1 = -1L;
    long l2 = -1L;
    if (i2 < localArrayList2.size())
    {
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
    }
    try
    {
      localObject4 = (msg_comm.Msg)localArrayList2.get(i2);
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      localObject5 = (msg_comm.MsgHead)((msg_comm.Msg)localObject4).msg_head.get();
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      localObject6 = (im_msg_body.MsgBody)((msg_comm.Msg)localObject4).msg_body.get();
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      if (!((msg_comm.Msg)localObject4).msg_head.has())
      {
        l4 = l2;
        l3 = l1;
        i1 = n;
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          break label2659;
        }
        l4 = l2;
        l3 = l1;
        i1 = n;
        localObject2 = localObject1;
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage: msgList[" + i2 + "] : msg doesn't has msgHead.");
        break label2659;
      }
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      l8 = ((msg_comm.MsgHead)localObject5).to_uin.get();
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      l7 = ((msg_comm.MsgHead)localObject5).from_uin.get();
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      l9 = ((msg_comm.MsgHead)localObject5).from_uin.get();
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      l5 = ((msg_comm.MsgHead)localObject5).msg_time.get();
      if (l5 <= paramLong) {
        break label2650;
      }
      paramBoolean3 = false;
      bool = false;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject4;
        Object localObject5;
        Object localObject6;
        long l8;
        long l7;
        long l9;
        long l5;
        localObject1 = localObject3;
        Object localObject3 = localException2;
        n = i1;
        continue;
        paramBoolean3 = true;
        boolean bool = true;
      }
      l3 = l2;
      l2 = l1;
      l1 = l3;
    }
    long l4 = l2;
    long l3 = l1;
    int i1 = n;
    Object localObject2 = localObject1;
    l8 = ajml.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l9, l8, paramUinPairMsg.peer_uin.get());
    l4 = l2;
    l3 = l1;
    i1 = n;
    localObject2 = localObject1;
    localObject1 = String.valueOf(l8);
    l4 = l2;
    l3 = l1;
    i1 = n;
    localObject2 = localObject1;
    l9 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l8), 0);
    if ((l5 <= l9) && (bool))
    {
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        l4 = l2;
        l3 = l1;
        i1 = n;
        localObject2 = localObject1;
        localStringBuilder.setLength(0);
        l4 = l2;
        l3 = l1;
        i1 = n;
        localObject2 = localObject1;
        localStringBuilder.append("<---decodeC2CMessagePackage : msgList[").append(i2).append("] : filter msg by del time delTime =").append(l9).append(", msgTime = ").append(l5);
        l4 = l2;
        l3 = l1;
        i1 = n;
        localObject2 = localObject1;
        QLog.d("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
      }
    }
    else
    {
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      localawam.jdField_a_of_type_Boolean = bool;
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      localawam.jdField_e_of_type_Long = l8;
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      localawam.h = paramBoolean3;
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      localObject4 = a((msg_comm.Msg)localObject4, localawam).iterator();
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      if (((Iterator)localObject4).hasNext())
      {
        l4 = l2;
        l3 = l1;
        i1 = n;
        localObject2 = localObject1;
        localObject5 = (MessageRecord)((Iterator)localObject4).next();
        l4 = l2;
        l3 = l1;
        i1 = n;
        localObject2 = localObject1;
        l5 = ((MessageRecord)localObject5).vipBubbleID;
        if (l5 != -1L)
        {
          l4 = l2;
          l3 = l1;
          i1 = n;
          localObject2 = localObject1;
          paramBoolean3 = bado.a(((MessageRecord)localObject5).issend);
          if (paramBoolean3)
          {
            l2 = l1;
            l1 = l5;
          }
        }
        for (;;)
        {
          try
          {
            i1 = ((MessageRecord)localObject5).istroop;
            n = i1;
            paramBoolean3 = a((MessageRecord)localObject5, true);
            n = i1;
            bool = b((MessageRecord)localObject5);
            if ((!paramBoolean3) && (!bool))
            {
              n = i1;
              if (((MessageRecord)localObject5).istroop == 1008)
              {
                n = i1;
                if ((localObject5 instanceof MessageForStructing))
                {
                  n = i1;
                  if (!StructLongMessageDownloadProcessor.b((MessageRecord)localObject5))
                  {
                    n = i1;
                    if (!StructLongMessageDownloadProcessor.d((MessageRecord)localObject5)) {}
                  }
                  else
                  {
                    n = i1;
                    localObject2 = ((MessageRecord)localObject5).getExtInfoFromExtStr("longMsg_State");
                    if (localObject2 == null) {
                      continue;
                    }
                    n = i1;
                    if (!String.valueOf(3).equals(localObject2)) {
                      continue;
                    }
                  }
                }
              }
              n = i1;
              if ((localObject5 instanceof MessageForMarketFace))
              {
                n = i1;
                arny.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForMarketFace)localObject5);
              }
              n = i1;
              if (ajed.ay.equals(((MessageRecord)localObject5).frienduin))
              {
                n = i1;
                ((MessageRecord)localObject5).time = NetConnInfoCenter.getServerTime();
              }
              n = i1;
              if (ajed.aQ.equals(((MessageRecord)localObject5).frienduin))
              {
                n = i1;
                ((KandianDailyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(296)).a((MessageRecord)localObject5);
              }
              n = i1;
              localArrayList1.add(localObject5);
              n = i1;
              int i3 = KandianMergeManager.a((MessageRecord)localObject5, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              if ((i3 == 0) || (i3 == 1))
              {
                n = i1;
                localObject2 = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).a((MessageRecord)localObject5);
                if (localObject2 != null)
                {
                  n = i1;
                  localArrayList1.add(localObject2);
                }
              }
            }
            n = i1;
            if (((MessageRecord)localObject5).msgtype == -2002)
            {
              if (!paramBoolean3)
              {
                n = i1;
                if (awuc.a(((MessageRecord)localObject5).msgUid, ((MessageRecord)localObject5).shmsgseq) != null)
                {
                  n = i1;
                  axte.a(true);
                }
              }
              if (paramBoolean3)
              {
                n = i1;
                if ((localObject5 instanceof MessageForPtt))
                {
                  n = i1;
                  if (akbm.c(((MessageRecord)localObject5).istroop))
                  {
                    n = i1;
                    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject5).frienduin, ((MessageRecord)localObject5).istroop).iterator();
                    n = i1;
                    if (((Iterator)localObject2).hasNext())
                    {
                      n = i1;
                      localObject6 = (MessageRecord)((Iterator)localObject2).next();
                      n = i1;
                      if (!(localObject6 instanceof MessageForPtt)) {
                        continue;
                      }
                      n = i1;
                      if (((MessageRecord)localObject6).msgUid != ((MessageRecord)localObject5).msgUid) {
                        continue;
                      }
                      n = i1;
                      if (((MessageRecord)localObject6).shmsgseq != ((MessageRecord)localObject5).shmsgseq) {
                        continue;
                      }
                      n = i1;
                      a((MessageForPtt)localObject6, (MessageForPtt)localObject5);
                    }
                  }
                }
              }
            }
            if (!paramBoolean3)
            {
              n = i1;
              if (((MessageRecord)localObject5).istroop == 1008)
              {
                n = i1;
                if (!"1".equals(((MessageRecord)localObject5).getExtInfoFromExtStr("is_AdArrive_Msg"))) {
                  break label1997;
                }
                n = i1;
                localObject2 = ((MessageRecord)localObject5).getExtInfoFromExtStr("gdt_msgImp");
                n = i1;
                localObject6 = ((MessageRecord)localObject5).getExtInfoFromExtStr("pa_msgId");
                n = i1;
                String str2 = ((MessageRecord)localObject5).getExtInfoFromExtStr("gdt_view_id");
                n = i1;
                ArrayList localArrayList3 = new ArrayList();
                n = i1;
                localArrayList3.add(localObject6);
                n = i1;
                rsa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", ((MessageRecord)localObject5).senderuin, (String)localObject2, str2, localArrayList3);
              }
            }
            l3 = l2;
            l2 = l1;
            l1 = l3;
            n = i1;
            break;
            l1 = l2;
            l2 = l5;
            continue;
            l4 = l2;
            l3 = l1;
            i1 = n;
            localObject2 = localObject1;
            if (((MessageRecord)localObject5).msgtype == -2002)
            {
              l4 = l2;
              l3 = l1;
              i1 = n;
              localObject2 = localObject1;
              if (bado.a(((MessageRecord)localObject5).issend))
              {
                if (l2 != -1L)
                {
                  l4 = l2;
                  l3 = l1;
                  i1 = n;
                  localObject2 = localObject1;
                  ((MessageRecord)localObject5).vipBubbleID = l2;
                  l3 = l1;
                  l1 = l2;
                  l2 = l3;
                  continue;
                }
                l4 = l2;
                l3 = l1;
                i1 = n;
                localObject2 = localObject1;
                ((MessageRecord)localObject5).vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l8), String.valueOf(l7));
                l3 = l1;
                l1 = l2;
                l2 = l3;
                continue;
              }
              if (l1 != -1L)
              {
                l4 = l2;
                l3 = l1;
                i1 = n;
                localObject2 = localObject1;
                ((MessageRecord)localObject5).vipBubbleID = l1;
                l3 = l1;
                l1 = l2;
                l2 = l3;
                continue;
              }
              l4 = l2;
              l3 = l1;
              i1 = n;
              localObject2 = localObject1;
              ((MessageRecord)localObject5).vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l8), String.valueOf(l7));
              l3 = l1;
              l1 = l2;
              l2 = l3;
              continue;
            }
            l4 = l2;
            l3 = l1;
            i1 = n;
            localObject2 = localObject1;
            ((MessageRecord)localObject5).vipBubbleID = 0L;
            l3 = l1;
            l1 = l2;
            l2 = l3;
            continue;
            n = i1;
            ((MessageRecord)localObject5).saveExtInfoToExtStr("longMsg_State", String.valueOf(1));
            n = i1;
            StructLongMessageDownloadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForStructing)localObject5);
            continue;
            if (!QLog.isColorLevel()) {
              break label1986;
            }
          }
          catch (Exception localException1)
          {
            l3 = l2;
            l4 = l1;
          }
          QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeC2CMessage error,", localException1);
          label1986:
          l1 = l4;
          l2 = l3;
          break label2671;
          label1997:
          n = i1;
          if ("2290230341".equals(((MessageRecord)localObject5).frienduin))
          {
            n = i1;
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80090E1", "0X80090E1", 0, 0, "", "", "", "");
          }
        }
      }
      l3 = l1;
      l1 = l2;
      l2 = l3;
      break label2671;
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramUinPairMsg), 0, localArrayList1, paramBoolean1);
        paramBoolean3 = a(localArrayList1);
        i1 = akbm.a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        alyc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if ((!paramBoolean3) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {
          break label2570;
        }
      }
      label2570:
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        ((QQMessageFacade)localObject1).a(localArrayList1, str1, paramBoolean1);
        a(localArrayList1);
        a(localArrayList1);
        a("handleGetBuddyMessageResp", true, i1, paramBoolean3, paramBoolean2);
        a(localArrayList1, paramBoolean2);
        akbf.a((MessageRecord)localArrayList1.get(0), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (n == 1008)
        {
          localObject1 = (ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
          if (localObject1 != null) {
            ((ajoy)localObject1).a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
        }
        if ((n != 0) || (localArrayList1.size() <= 0)) {
          break;
        }
        localObject1 = localArrayList1.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (MessageRecord)((Iterator)localObject1).next();
          ajzm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 0, (MessageRecord)localObject3);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage : dstUin:" + paramUinPairMsg + ", pkgUinType:" + n);
      }
      return new Pair(paramUinPairMsg, Integer.valueOf(n));
    }
    for (;;)
    {
      label2650:
      label2659:
      label2671:
      i2 += 1;
      l3 = l2;
      l2 = l1;
      l1 = l3;
      break;
      l3 = l1;
      l1 = l2;
      l2 = l3;
    }
  }
  
  private Pair<List<MessageRecord>, List<MessageRecord>> a(List<msg_comm.Msg> paramList, List<MessageRecord> paramList1, long paramLong1, long paramLong2, long paramLong3)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = ((ajmp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92)).a(String.valueOf(paramLong1), paramLong2 - 30L, 30L + paramLong3);
    if ((localList != null) && (!localList.isEmpty()))
    {
      paramList = paramList.iterator();
      Object localObject;
      int n;
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
          n = 0;
          while (n < localList.size())
          {
            localObject = (MessageRecord)localList.get(n);
            if ((((MessageRecord)localObject).msgUid == paramLong1) && (((MessageRecord)localObject).shmsgseq == paramLong2))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 2, "filterRoamMsgFromDB duplicated " + localObject);
              }
              localArrayList.add(localObject);
              paramList.remove();
            }
            n += 1;
          }
        }
      }
      paramList = paramList1.iterator();
      while (paramList.hasNext())
      {
        localObject = (MessageRecord)paramList.next();
        n = 0;
        while (n < localList.size())
        {
          MessageRecord localMessageRecord = (MessageRecord)localList.get(n);
          if ((localMessageRecord.msgUid == ((MessageRecord)localObject).msgUid) && (localMessageRecord.shmsgseq == ((MessageRecord)localObject).shmsgseq))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "filterRoamMsgFromDB duplicated " + localObject);
            }
            paramList.remove();
          }
          n += 1;
        }
      }
    }
    return new Pair(localArrayList, paramList1);
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, msg_comm.MsgHead paramMsgHead)
  {
    Object localObject3 = paramQQAppInterface.getCurrentAccountUin();
    Long localLong = Long.valueOf(Long.parseLong((String)localObject3));
    String str = String.valueOf(paramLong1);
    Object localObject1 = (msg_comm.ExtGroupKeyInfo)paramMsgHead.ext_group_key_info.get();
    long l1 = ((msg_comm.ExtGroupKeyInfo)localObject1).cur_max_seq.get();
    long l2 = ((msg_comm.ExtGroupKeyInfo)localObject1).cur_time.get();
    if (QLog.isColorLevel()) {
      QLog.d("GrayTipsForTroop", 2, "0x21 troopUin = " + paramLong1 + " maxseq = " + l1 + ", maxTime = " + l2 + ", member = " + paramString1 + ", adminUin" + paramString2 + ", cOpt" + paramInt);
    }
    Object localObject4 = "" + paramMsgHead.auth_uin.get();
    localObject1 = paramMsgHead.auth_nick.get();
    paramMsgHead.auth_sex.get();
    if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject4).equals(paramString1))) {}
    for (paramMsgHead = (msg_comm.MsgHead)localObject1;; paramMsgHead = "")
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).equals(paramString1)))
      {
        ajjy.a(2131635488);
        return;
      }
      if (TextUtils.isEmpty(paramMsgHead)) {}
      for (Object localObject2 = ajml.a(paramQQAppInterface, paramString1, str);; localObject2 = paramMsgHead) {
        for (;;)
        {
          Object localObject5;
          boolean bool;
          try
          {
            paramLong2 = Long.parseLong((String)localObject4);
            if ((paramInt == -126) || (paramInt == 2))
            {
              paramString2 = (String)localObject2 + ajjy.a(2131635486);
              paramMsgHead = (TroopManager)paramQQAppInterface.getManager(52);
              localObject3 = paramMsgHead.c(paramMsgHead.c(str));
              if ((localObject3 != null) && (((TroopInfo)localObject3).cGroupOption == 2))
              {
                localObject1 = paramQQAppInterface.getApp().getApplicationContext().getString(2131631954);
                if (!a(str)) {
                  break label1731;
                }
                paramString2 = paramString2 + "，" + (String)localObject1;
                paramMsgHead = "";
                localObject4 = (MessageForGrayTips)awbi.a(-1012);
                ((MessageForGrayTips)localObject4).init(localLong.longValue(), paramLong1, paramLong2, paramString2, l2, -1012, 1, paramLong3);
                ((MessageForGrayTips)localObject4).shmsgseq = l1;
                ((MessageForGrayTips)localObject4).switch2HightlightMsg();
                localObject5 = new Bundle();
                ((Bundle)localObject5).putInt("key_action", 5);
                ((Bundle)localObject5).putString("troop_mem_uin", paramString1);
                ((Bundle)localObject5).putBoolean("need_update_nick", false);
                ((MessageForGrayTips)localObject4).addHightlightItem(0, ((String)localObject2).length(), (Bundle)localObject5);
                ((MessageForGrayTips)localObject4).saveExtInfoToExtStr("troop_new_member_uin", paramString1);
                if ((localObject3 == null) || (((TroopInfo)localObject3).cGroupOption != 2)) {
                  continue;
                }
                if (a(str))
                {
                  paramMsgHead = new Bundle();
                  paramMsgHead.putInt("key_action", 19);
                  paramMsgHead.putString("troop_mem_uin", paramString1);
                  paramMsgHead.putString("troopUin", str);
                  ((MessageForGrayTips)localObject4).addHightlightItem(paramString2.length() - ((String)localObject1).length(), paramString2.length(), paramMsgHead);
                }
                ((MessageForGrayTips)localObject4).isread = true;
                paramMsgHead = (azlf)paramQQAppInterface.getManager(81);
                if ((!a((MessageRecord)localObject4, false)) && (!paramMsgHead.a(paramLong1 + "", paramLong3))) {
                  continue;
                }
                bool = true;
                if (!bool)
                {
                  paramQQAppInterface.a().a((MessageRecord)localObject4, String.valueOf(localLong));
                  paramMsgHead = ((ajtg)paramQQAppInterface.a(20)).a();
                  if ((paramMsgHead.b("newMember")) && (paramMsgHead.a(str))) {
                    paramMsgHead.c(str, paramString1);
                  }
                  new awrb(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("exp_bar").a(new String[] { str, "", "" + azlj.b(paramQQAppInterface, str) }).a();
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("Q.msg.C2CMessageProcessor", 2, "seq:" + paramLong3 + "|cOpt:" + paramInt + "|tips:" + paramString2 + "|msgFilter:" + bool);
                return;
              }
            }
          }
          catch (Exception paramMsgHead)
          {
            QLog.e("GrayTipsForTroop", 1, "senderUin=" + 0L, paramMsgHead);
            paramLong2 = paramLong1;
            continue;
            paramMsgHead = paramQQAppInterface.getApp().getApplicationContext().getString(2131631955);
            paramString2 = paramString2 + "，" + paramMsgHead;
            localObject1 = "";
            continue;
            localObject1 = new Bundle();
            ((Bundle)localObject1).putInt("key_action", 48);
            ((Bundle)localObject1).putString("troop_mem_uin", paramString1);
            ((Bundle)localObject1).putString("troopUin", str);
            ((MessageForGrayTips)localObject4).addHightlightItem(paramString2.length() - paramMsgHead.length(), paramString2.length(), (Bundle)localObject1);
            continue;
            bool = false;
            continue;
          }
          if (((paramInt != -125) && (paramInt != 3)) || (((aynk)paramQQAppInterface.getManager(32)).a(str, (String)localObject4))) {
            break;
          }
          paramMsgHead = ajml.a(paramQQAppInterface, paramString2, str);
          int n = 0;
          if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).equals(paramString2)))
          {
            paramMsgHead = ajjy.a(2131635485);
            n = 1;
          }
          for (;;)
          {
            if (n != 0)
            {
              localObject1 = paramMsgHead + ajjy.a(2131635487);
              label1121:
              localObject3 = (String)localObject1 + (String)localObject2 + ajjy.a(2131635494);
              localObject4 = paramQQAppInterface.getApp().getApplicationContext().getString(2131631955);
              localObject3 = (String)localObject3 + "，" + (String)localObject4;
              localObject5 = (MessageForGrayTips)awbi.a(-1012);
              ((MessageForGrayTips)localObject5).init(localLong.longValue(), paramLong1, paramLong2, (String)localObject3, l2, -1012, 1, paramLong3);
              ((MessageForGrayTips)localObject5).switch2HightlightMsg();
              ((MessageForGrayTips)localObject5).shmsgseq = l1;
              if (n == 0)
              {
                Bundle localBundle = new Bundle();
                localBundle.putInt("key_action", 5);
                localBundle.putString("troop_mem_uin", paramString2);
                localBundle.putBoolean("need_update_nick", false);
                ((MessageForGrayTips)localObject5).addHightlightItem(0, paramMsgHead.length(), localBundle);
              }
              paramString2 = new Bundle();
              paramString2.putInt("key_action", 5);
              paramString2.putString("troop_mem_uin", paramString1);
              paramString2.putBoolean("need_update_nick", false);
              ((MessageForGrayTips)localObject5).addHightlightItem(((String)localObject1).length(), ((String)localObject1).length() + ((String)localObject2).length(), paramString2);
              ((MessageForGrayTips)localObject5).saveExtInfoToExtStr("troop_new_member_uin", paramString1);
              paramString2 = new Bundle();
              paramString2.putInt("key_action", 48);
              paramString2.putString("troop_mem_uin", paramString1);
              paramString2.putString("troopUin", str);
              ((MessageForGrayTips)localObject5).addHightlightItem(((String)localObject3).length() - ((String)localObject4).length(), ((String)localObject3).length(), paramString2);
              ((MessageForGrayTips)localObject5).isread = true;
              paramString2 = (azlf)paramQQAppInterface.getManager(81);
              if ((!a((MessageRecord)localObject5, false)) && (!paramString2.a(paramLong1 + "", paramLong3))) {
                break label1722;
              }
            }
            label1722:
            for (bool = true;; bool = false)
            {
              if (!bool)
              {
                paramQQAppInterface.a().a((MessageRecord)localObject5, String.valueOf(localLong));
                paramString2 = ((ajtg)paramQQAppInterface.a(20)).a();
                if ((paramString2.b("newMember")) && (paramString2.a(str))) {
                  paramString2.c(str, paramString1);
                }
                new awrb(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("exp_bar").a(new String[] { str, "", "" + azlj.b(paramQQAppInterface, str) }).a();
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.msg.C2CMessageProcessor", 2, "seq:" + paramLong3 + "|cOpt:" + paramInt + "|tips:" + (String)localObject3 + "|msgFilter:" + bool);
              return;
              localObject1 = paramMsgHead + ajjy.a(2131635492);
              break label1121;
            }
          }
          label1731:
          paramMsgHead = "";
        }
      }
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
    //   0: aload_1
    //   1: getfield 804	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 826
    //   7: iconst_1
    //   8: invokevirtual 829	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   11: istore 11
    //   13: aload_1
    //   14: getfield 804	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   17: ldc_w 831
    //   20: iconst_1
    //   21: invokevirtual 829	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   24: istore 13
    //   26: aload_1
    //   27: getfield 804	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   30: ldc_w 833
    //   33: iconst_0
    //   34: invokevirtual 829	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   37: istore 12
    //   39: invokestatic 838	java/lang/System:currentTimeMillis	()J
    //   42: lstore 14
    //   44: new 840	msf/msgsvc/msg_svc$PbGetMsgResp
    //   47: dup
    //   48: invokespecial 841	msf/msgsvc/msg_svc$PbGetMsgResp:<init>	()V
    //   51: astore 22
    //   53: aload 22
    //   55: aload_3
    //   56: checkcast 843	[B
    //   59: checkcast 843	[B
    //   62: invokevirtual 847	msf/msgsvc/msg_svc$PbGetMsgResp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   65: checkcast 840	msf/msgsvc/msg_svc$PbGetMsgResp
    //   68: astore 22
    //   70: aload 22
    //   72: ifnonnull +35 -> 107
    //   75: invokestatic 850	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   78: invokestatic 855	awrn:a	(Landroid/content/Context;)Lawrn;
    //   81: aload_0
    //   82: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   85: invokevirtual 75	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   88: ldc_w 857
    //   91: iconst_0
    //   92: lconst_0
    //   93: lconst_0
    //   94: new 112	java/util/HashMap
    //   97: dup
    //   98: invokespecial 113	java/util/HashMap:<init>	()V
    //   101: ldc_w 397
    //   104: invokevirtual 860	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   107: new 109	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   114: astore 24
    //   116: aload 22
    //   118: ifnull +25 -> 143
    //   121: aload 22
    //   123: getfield 863	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   126: invokevirtual 864	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   129: ifeq +14 -> 143
    //   132: aload 22
    //   134: getfield 863	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   137: invokevirtual 200	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   140: ifeq +175 -> 315
    //   143: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +104 -> 250
    //   149: aload 24
    //   151: iconst_0
    //   152: invokevirtual 225	java/lang/StringBuilder:setLength	(I)V
    //   155: aload 24
    //   157: ldc_w 866
    //   160: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_1
    //   164: invokevirtual 869	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   167: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: ldc_w 871
    //   173: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: astore 23
    //   178: aload 22
    //   180: ifnonnull +105 -> 285
    //   183: ldc_w 873
    //   186: astore_3
    //   187: aload 23
    //   189: aload_3
    //   190: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   193: ldc_w 875
    //   196: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: astore 23
    //   201: aload 22
    //   203: ifnonnull +97 -> 300
    //   206: ldc_w 873
    //   209: astore_3
    //   210: aload 23
    //   212: aload_3
    //   213: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   216: ldc_w 877
    //   219: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: iload 11
    //   224: invokevirtual 781	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   227: ldc_w 879
    //   230: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: iload 13
    //   235: invokevirtual 781	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: ldc 164
    //   241: iconst_2
    //   242: aload 24
    //   244: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 881	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: aload_0
    //   251: getfield 469	akak:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   254: aload_1
    //   255: aload_2
    //   256: invokevirtual 883	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   259: return
    //   260: astore 22
    //   262: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   265: ifeq +14 -> 279
    //   268: ldc 164
    //   270: iconst_2
    //   271: ldc_w 885
    //   274: aload 22
    //   276: invokestatic 785	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   279: aconst_null
    //   280: astore 22
    //   282: goto -212 -> 70
    //   285: aload 22
    //   287: getfield 863	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   290: invokevirtual 200	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   293: invokestatic 101	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   296: astore_3
    //   297: goto -110 -> 187
    //   300: aload 22
    //   302: getfield 888	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   305: invokevirtual 466	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   308: invokestatic 893	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   311: astore_3
    //   312: goto -102 -> 210
    //   315: aconst_null
    //   316: astore_2
    //   317: aload 22
    //   319: getfield 888	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   322: invokevirtual 466	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   325: ifeq +15 -> 340
    //   328: aload 22
    //   330: getfield 888	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   333: invokevirtual 472	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   336: invokevirtual 478	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   339: astore_2
    //   340: aload 22
    //   342: getfield 896	msf/msgsvc/msg_svc$PbGetMsgResp:uin_pair_msgs	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   345: invokevirtual 87	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   348: astore 25
    //   350: aload_0
    //   351: getfield 469	akak:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   354: iconst_0
    //   355: putfield 897	com/tencent/mobileqq/app/MessageHandler:f	I
    //   358: aload 22
    //   360: getfield 901	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   363: invokevirtual 904	com/tencent/mobileqq/pb/PBEnumField:has	()Z
    //   366: ifeq +2235 -> 2601
    //   369: aload 22
    //   371: getfield 901	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   374: invokevirtual 905	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   377: istore 5
    //   379: iload 5
    //   381: iconst_2
    //   382: if_icmpge +2213 -> 2595
    //   385: iconst_1
    //   386: i2b
    //   387: istore 4
    //   389: aconst_null
    //   390: astore 23
    //   392: aload 22
    //   394: getfield 908	msf/msgsvc/msg_svc$PbGetMsgResp:pubaccount_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   397: invokevirtual 466	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   400: ifeq +16 -> 416
    //   403: aload 22
    //   405: getfield 908	msf/msgsvc/msg_svc$PbGetMsgResp:pubaccount_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   408: invokevirtual 472	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   411: invokevirtual 478	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   414: astore 23
    //   416: iconst_0
    //   417: istore 6
    //   419: aload 22
    //   421: getfield 911	msf/msgsvc/msg_svc$PbGetMsgResp:msg_rsp_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   424: invokevirtual 864	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   427: ifeq +13 -> 440
    //   430: aload 22
    //   432: getfield 911	msf/msgsvc/msg_svc$PbGetMsgResp:msg_rsp_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   435: invokevirtual 200	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   438: istore 6
    //   440: iload 6
    //   442: tableswitch	default:+26 -> 468, 0:+1161->1603, 1:+1202->1644, 2:+1224->1666
    //   469: istore 10
    //   471: aload_0
    //   472: getfield 469	akak:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   475: invokevirtual 913	com/tencent/mobileqq/app/MessageHandler:a	()Z
    //   478: ifeq +6 -> 484
    //   481: iconst_1
    //   482: istore 10
    //   484: iload 4
    //   486: ifle +25 -> 511
    //   489: aload_0
    //   490: getfield 469	akak:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   493: iload 4
    //   495: aload_2
    //   496: iload 5
    //   498: iload 11
    //   500: iload 13
    //   502: iload 10
    //   504: aconst_null
    //   505: iload 6
    //   507: aconst_null
    //   508: invokevirtual 916	com/tencent/mobileqq/app/MessageHandler:a	(B[BIZZZLjava/lang/String;ILjava/lang/Object;)V
    //   511: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   514: ifeq +154 -> 668
    //   517: aload 24
    //   519: iconst_0
    //   520: invokevirtual 225	java/lang/StringBuilder:setLength	(I)V
    //   523: aload 24
    //   525: ldc_w 866
    //   528: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: aload_1
    //   532: invokevirtual 869	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   535: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   538: ldc_w 871
    //   541: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload 22
    //   546: getfield 863	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   549: invokevirtual 200	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   552: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   555: ldc_w 918
    //   558: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: aload 22
    //   563: getfield 888	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   566: invokevirtual 466	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   569: invokevirtual 781	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   572: ldc_w 920
    //   575: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: iload 4
    //   580: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   583: ldc_w 922
    //   586: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: iload 5
    //   591: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   594: ldc_w 924
    //   597: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: iload 11
    //   602: invokevirtual 781	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   605: ldc_w 879
    //   608: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: iload 13
    //   613: invokevirtual 781	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   616: ldc_w 926
    //   619: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: aload 25
    //   624: invokeinterface 93 1 0
    //   629: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   632: ldc_w 928
    //   635: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: aload_3
    //   639: invokevirtual 933	java/lang/Object:hashCode	()I
    //   642: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   645: ldc_w 935
    //   648: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: iload 6
    //   653: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: ldc 164
    //   659: iconst_2
    //   660: aload 24
    //   662: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   665: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   668: iconst_0
    //   669: istore 7
    //   671: iload 7
    //   673: aload 25
    //   675: invokeinterface 93 1 0
    //   680: if_icmpge +1262 -> 1942
    //   683: invokestatic 838	java/lang/System:currentTimeMillis	()J
    //   686: lstore 14
    //   688: aload 25
    //   690: iload 7
    //   692: invokeinterface 561 2 0
    //   697: checkcast 77	msf/msgcomm/msg_comm$UinPairMsg
    //   700: astore_3
    //   701: aload_3
    //   702: getfield 203	msf/msgcomm/msg_comm$UinPairMsg:peer_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   705: invokevirtual 189	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   708: invokestatic 213	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   711: astore_2
    //   712: aload_3
    //   713: getfield 938	msf/msgcomm/msg_comm$UinPairMsg:last_read_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   716: invokevirtual 200	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   719: i2l
    //   720: ldc2_w 939
    //   723: land
    //   724: lstore 16
    //   726: aload_3
    //   727: getfield 81	msf/msgcomm/msg_comm$UinPairMsg:msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   730: invokevirtual 87	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   733: astore 22
    //   735: aload_3
    //   736: getfield 943	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   739: invokevirtual 864	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   742: ifeq +947 -> 1689
    //   745: aload_3
    //   746: getfield 943	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   749: invokevirtual 200	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   752: ifeq +937 -> 1689
    //   755: iconst_1
    //   756: istore 10
    //   758: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   761: ifeq +78 -> 839
    //   764: aload 24
    //   766: iconst_0
    //   767: invokevirtual 225	java/lang/StringBuilder:setLength	(I)V
    //   770: aload 24
    //   772: ldc_w 945
    //   775: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: aload_2
    //   779: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: ldc_w 947
    //   785: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: iload 10
    //   790: invokevirtual 781	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   793: ldc_w 949
    //   796: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: lload 16
    //   801: invokevirtual 232	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   804: ldc_w 951
    //   807: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: astore 23
    //   812: aload 22
    //   814: ifnonnull +881 -> 1695
    //   817: ldc_w 873
    //   820: astore_1
    //   821: aload 23
    //   823: aload_1
    //   824: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   827: pop
    //   828: ldc 164
    //   830: iconst_2
    //   831: aload 24
    //   833: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   836: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   839: aload 22
    //   841: ifnull +911 -> 1752
    //   844: aload 22
    //   846: invokeinterface 93 1 0
    //   851: ifle +901 -> 1752
    //   854: aload 22
    //   856: invokeinterface 93 1 0
    //   861: iconst_1
    //   862: if_icmple +16 -> 878
    //   865: aload 22
    //   867: new 953	akal
    //   870: dup
    //   871: aload_0
    //   872: invokespecial 956	akal:<init>	(Lakak;)V
    //   875: invokestatic 962	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   878: aload_0
    //   879: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   882: bipush 51
    //   884: invokevirtual 330	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   887: checkcast 964	ajjj
    //   890: aload 22
    //   892: iconst_0
    //   893: invokeinterface 561 2 0
    //   898: checkcast 137	msf/msgcomm/msg_comm$Msg
    //   901: getfield 141	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   904: invokevirtual 146	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   907: checkcast 143	msf/msgcomm/msg_comm$MsgHead
    //   910: getfield 192	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   913: invokevirtual 189	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   916: invokevirtual 967	ajjj:a	(J)V
    //   919: aload_0
    //   920: getfield 469	akak:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   923: aload_2
    //   924: iconst_0
    //   925: invokevirtual 970	com/tencent/mobileqq/app/MessageHandler:a	(Ljava/lang/String;I)Ljava/lang/Object;
    //   928: astore 23
    //   930: aload 23
    //   932: monitorenter
    //   933: aload_0
    //   934: aload_2
    //   935: aload_3
    //   936: lload 16
    //   938: iload 10
    //   940: iload 11
    //   942: iload 12
    //   944: invokespecial 972	akak:a	(Ljava/lang/String;Lmsf/msgcomm/msg_comm$UinPairMsg;JZZZ)Landroid/util/Pair;
    //   947: astore_2
    //   948: aload_2
    //   949: getfield 976	android/util/Pair:first	Ljava/lang/Object;
    //   952: checkcast 210	java/lang/String
    //   955: astore_1
    //   956: aload_2
    //   957: getfield 979	android/util/Pair:second	Ljava/lang/Object;
    //   960: checkcast 97	java/lang/Integer
    //   963: invokevirtual 982	java/lang/Integer:intValue	()I
    //   966: istore 5
    //   968: aload 23
    //   970: monitorexit
    //   971: iload 10
    //   973: ifne +172 -> 1145
    //   976: aload_0
    //   977: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   980: invokevirtual 216	com/tencent/mobileqq/app/QQAppInterface:a	()Lawao;
    //   983: aload_1
    //   984: invokevirtual 984	awao:g	(Ljava/lang/String;)J
    //   987: lstore 18
    //   989: aload 22
    //   991: iconst_0
    //   992: invokeinterface 561 2 0
    //   997: checkcast 137	msf/msgcomm/msg_comm$Msg
    //   1000: getfield 141	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1003: invokevirtual 146	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1006: checkcast 143	msf/msgcomm/msg_comm$MsgHead
    //   1009: getfield 196	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1012: invokevirtual 200	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1015: i2l
    //   1016: lstore 20
    //   1018: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1021: ifeq +62 -> 1083
    //   1024: ldc 164
    //   1026: iconst_2
    //   1027: new 109	java/lang/StringBuilder
    //   1030: dup
    //   1031: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   1034: ldc_w 986
    //   1037: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: aload_1
    //   1041: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: ldc_w 988
    //   1047: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: lload 18
    //   1052: invokevirtual 232	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1055: ldc_w 990
    //   1058: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: lload 20
    //   1063: invokevirtual 232	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1066: ldc_w 920
    //   1069: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: iload 4
    //   1074: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1077: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1080: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1083: lload 18
    //   1085: lconst_0
    //   1086: lcmp
    //   1087: ifeq +11 -> 1098
    //   1090: lload 20
    //   1092: lload 18
    //   1094: lcmp
    //   1095: ifge +35 -> 1130
    //   1098: aload_0
    //   1099: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1102: invokevirtual 216	com/tencent/mobileqq/app/QQAppInterface:a	()Lawao;
    //   1105: aload_1
    //   1106: lload 20
    //   1108: lconst_0
    //   1109: invokevirtual 993	awao:b	(Ljava/lang/String;JJ)V
    //   1112: iload 4
    //   1114: ifle +16 -> 1130
    //   1117: aload_0
    //   1118: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1121: invokevirtual 216	com/tencent/mobileqq/app/QQAppInterface:a	()Lawao;
    //   1124: aload_1
    //   1125: lload 20
    //   1127: invokevirtual 995	awao:g	(Ljava/lang/String;J)V
    //   1130: iload 4
    //   1132: ifne +13 -> 1145
    //   1135: aload_0
    //   1136: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1139: invokevirtual 216	com/tencent/mobileqq/app/QQAppInterface:a	()Lawao;
    //   1142: invokevirtual 997	awao:c	()V
    //   1145: iconst_0
    //   1146: istore 8
    //   1148: iload 11
    //   1150: ifeq +444 -> 1594
    //   1153: aload_1
    //   1154: astore_2
    //   1155: iload 5
    //   1157: sipush 1006
    //   1160: if_icmpne +30 -> 1190
    //   1163: aload_0
    //   1164: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1167: bipush 11
    //   1169: invokevirtual 330	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1172: checkcast 999	aroh
    //   1175: aload_1
    //   1176: invokeinterface 1001 2 0
    //   1181: astore_3
    //   1182: aload_1
    //   1183: astore_2
    //   1184: aload_3
    //   1185: ifnull +5 -> 1190
    //   1188: aload_3
    //   1189: astore_2
    //   1190: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1193: ifeq +51 -> 1244
    //   1196: ldc 164
    //   1198: iconst_2
    //   1199: new 109	java/lang/StringBuilder
    //   1202: dup
    //   1203: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   1206: ldc_w 1003
    //   1209: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: aload_2
    //   1213: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: ldc_w 1005
    //   1219: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1222: iload 5
    //   1224: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1227: ldc_w 1007
    //   1230: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1233: lload 16
    //   1235: invokevirtual 232	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1238: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1241: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1244: iload 5
    //   1246: istore 9
    //   1248: iload 5
    //   1250: invokestatic 1010	akbm:a	(I)I
    //   1253: sipush 1032
    //   1256: if_icmpne +6 -> 1262
    //   1259: iconst_0
    //   1260: istore 9
    //   1262: iload 8
    //   1264: ifne +241 -> 1505
    //   1267: aload_2
    //   1268: iload 9
    //   1270: invokestatic 1016	com/tencent/mobileqq/data/ConversationInfo:reportPublicaccoutTypeError	(Ljava/lang/String;I)Z
    //   1273: ifeq +232 -> 1505
    //   1276: new 109	java/lang/StringBuilder
    //   1279: dup
    //   1280: sipush 128
    //   1283: invokespecial 1018	java/lang/StringBuilder:<init>	(I)V
    //   1286: astore_1
    //   1287: aload_1
    //   1288: ldc_w 1019
    //   1291: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1294: ldc_w 1021
    //   1297: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1300: aload_2
    //   1301: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1304: pop
    //   1305: aload_1
    //   1306: ldc_w 1023
    //   1309: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: iload 9
    //   1314: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1317: pop
    //   1318: aload 22
    //   1320: ifnull +175 -> 1495
    //   1323: aload 22
    //   1325: invokeinterface 93 1 0
    //   1330: ifle +165 -> 1495
    //   1333: aload 22
    //   1335: iconst_0
    //   1336: invokeinterface 561 2 0
    //   1341: checkcast 137	msf/msgcomm/msg_comm$Msg
    //   1344: astore_3
    //   1345: aload_3
    //   1346: getfield 141	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1349: invokevirtual 157	msf/msgcomm/msg_comm$MsgHead:has	()Z
    //   1352: ifeq +143 -> 1495
    //   1355: aload_3
    //   1356: getfield 141	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1359: invokevirtual 146	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1362: checkcast 143	msf/msgcomm/msg_comm$MsgHead
    //   1365: astore_3
    //   1366: aload_1
    //   1367: ldc_w 1025
    //   1370: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1373: aload_3
    //   1374: getfield 1028	msf/msgcomm/msg_comm$MsgHead:msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1377: invokevirtual 200	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1380: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1383: pop
    //   1384: aload_1
    //   1385: ldc_w 1030
    //   1388: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: aload_3
    //   1392: getfield 560	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1395: invokevirtual 200	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1398: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1401: pop
    //   1402: aload_1
    //   1403: ldc_w 1032
    //   1406: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1409: aload_3
    //   1410: getfield 557	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1413: invokevirtual 189	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1416: invokevirtual 232	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1419: pop
    //   1420: aload_1
    //   1421: ldc_w 1034
    //   1424: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1427: aload_3
    //   1428: getfield 196	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1431: invokevirtual 200	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1434: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1437: pop
    //   1438: aload_3
    //   1439: getfield 1038	msf/msgcomm/msg_comm$MsgHead:c2c_tmp_msg_head	Lmsf/msgcomm/msg_comm$C2CTmpMsgHead;
    //   1442: invokevirtual 1041	msf/msgcomm/msg_comm$C2CTmpMsgHead:has	()Z
    //   1445: ifeq +50 -> 1495
    //   1448: aload_3
    //   1449: getfield 1038	msf/msgcomm/msg_comm$MsgHead:c2c_tmp_msg_head	Lmsf/msgcomm/msg_comm$C2CTmpMsgHead;
    //   1452: invokevirtual 1042	msf/msgcomm/msg_comm$C2CTmpMsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1455: checkcast 1040	msf/msgcomm/msg_comm$C2CTmpMsgHead
    //   1458: astore_3
    //   1459: aload_1
    //   1460: ldc_w 1044
    //   1463: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: aload_3
    //   1467: getfield 1047	msf/msgcomm/msg_comm$C2CTmpMsgHead:service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1470: invokevirtual 200	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1473: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1476: pop
    //   1477: aload_1
    //   1478: ldc_w 1049
    //   1481: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: aload_3
    //   1485: getfield 1052	msf/msgcomm/msg_comm$C2CTmpMsgHead:c2c_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1488: invokevirtual 200	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1491: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1494: pop
    //   1495: ldc 164
    //   1497: iconst_1
    //   1498: aload_1
    //   1499: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1502: invokestatic 881	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1505: new 1054	android/os/Message
    //   1508: dup
    //   1509: invokespecial 1055	android/os/Message:<init>	()V
    //   1512: astore_1
    //   1513: aload_1
    //   1514: iconst_1
    //   1515: putfield 1058	android/os/Message:what	I
    //   1518: new 677	android/os/Bundle
    //   1521: dup
    //   1522: invokespecial 678	android/os/Bundle:<init>	()V
    //   1525: astore_3
    //   1526: aload_3
    //   1527: ldc_w 1060
    //   1530: lload 16
    //   1532: invokevirtual 813	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1535: aload_3
    //   1536: ldc_w 1062
    //   1539: aload_2
    //   1540: invokevirtual 689	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1543: aload_3
    //   1544: ldc_w 1064
    //   1547: iload 9
    //   1549: invokevirtual 684	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1552: aload_1
    //   1553: aload_3
    //   1554: invokevirtual 1068	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   1557: aload_0
    //   1558: getfield 469	akak:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1561: astore_3
    //   1562: iload 4
    //   1564: ifgt +358 -> 1922
    //   1567: iconst_1
    //   1568: istore 10
    //   1570: aload_3
    //   1571: aload_1
    //   1572: iload 10
    //   1574: invokevirtual 1071	com/tencent/mobileqq/app/MessageHandler:a	(Landroid/os/Message;Z)V
    //   1577: iload 6
    //   1579: iconst_2
    //   1580: if_icmpne +348 -> 1928
    //   1583: aload_0
    //   1584: getfield 35	akak:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   1587: aload_2
    //   1588: invokeinterface 1072 2 0
    //   1593: pop
    //   1594: iload 7
    //   1596: iconst_1
    //   1597: iadd
    //   1598: istore 7
    //   1600: goto -929 -> 671
    //   1603: aload_0
    //   1604: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1607: invokevirtual 216	com/tencent/mobileqq/app/QQAppInterface:a	()Lawao;
    //   1610: aload_2
    //   1611: invokevirtual 1075	awao:a	([B)V
    //   1614: aload_0
    //   1615: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1618: invokevirtual 216	com/tencent/mobileqq/app/QQAppInterface:a	()Lawao;
    //   1621: aload_2
    //   1622: invokevirtual 1077	awao:b	([B)V
    //   1625: aload_0
    //   1626: getfield 469	akak:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1629: iconst_0
    //   1630: invokevirtual 1079	com/tencent/mobileqq/app/MessageHandler:b	(Z)V
    //   1633: aload_0
    //   1634: getfield 469	akak:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1637: iconst_0
    //   1638: invokevirtual 1081	com/tencent/mobileqq/app/MessageHandler:c	(Z)V
    //   1641: goto -1173 -> 468
    //   1644: aload_0
    //   1645: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1648: invokevirtual 216	com/tencent/mobileqq/app/QQAppInterface:a	()Lawao;
    //   1651: aload_2
    //   1652: invokevirtual 1075	awao:a	([B)V
    //   1655: aload_0
    //   1656: getfield 469	akak:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1659: iconst_0
    //   1660: invokevirtual 1079	com/tencent/mobileqq/app/MessageHandler:b	(Z)V
    //   1663: goto -1195 -> 468
    //   1666: aload_0
    //   1667: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1670: invokevirtual 216	com/tencent/mobileqq/app/QQAppInterface:a	()Lawao;
    //   1673: aload 23
    //   1675: invokevirtual 1077	awao:b	([B)V
    //   1678: aload_0
    //   1679: getfield 469	akak:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1682: iconst_0
    //   1683: invokevirtual 1081	com/tencent/mobileqq/app/MessageHandler:c	(Z)V
    //   1686: goto -1218 -> 468
    //   1689: iconst_0
    //   1690: istore 10
    //   1692: goto -934 -> 758
    //   1695: aload 22
    //   1697: invokeinterface 93 1 0
    //   1702: invokestatic 101	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1705: astore_1
    //   1706: goto -885 -> 821
    //   1709: astore_1
    //   1710: aload 23
    //   1712: monitorexit
    //   1713: aload_1
    //   1714: athrow
    //   1715: astore_1
    //   1716: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1719: ifeq -125 -> 1594
    //   1722: ldc 164
    //   1724: iconst_2
    //   1725: new 109	java/lang/StringBuilder
    //   1728: dup
    //   1729: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   1732: ldc_w 1083
    //   1735: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1738: aload_1
    //   1739: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1742: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1745: aload_1
    //   1746: invokestatic 785	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1749: goto -155 -> 1594
    //   1752: aload_3
    //   1753: getfield 1084	msf/msgcomm/msg_comm$UinPairMsg:c2c_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1756: invokevirtual 864	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1759: ifeq +143 -> 1902
    //   1762: aload_3
    //   1763: getfield 1085	msf/msgcomm/msg_comm$UinPairMsg:service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1766: invokevirtual 864	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1769: ifeq +133 -> 1902
    //   1772: aload_3
    //   1773: getfield 1084	msf/msgcomm/msg_comm$UinPairMsg:c2c_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1776: invokevirtual 200	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1779: istore 5
    //   1781: aload_3
    //   1782: getfield 1085	msf/msgcomm/msg_comm$UinPairMsg:service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1785: invokevirtual 200	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1788: istore 8
    //   1790: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1793: ifeq +62 -> 1855
    //   1796: ldc 164
    //   1798: iconst_2
    //   1799: new 109	java/lang/StringBuilder
    //   1802: dup
    //   1803: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   1806: ldc_w 986
    //   1809: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1812: aload_2
    //   1813: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1816: ldc_w 1087
    //   1819: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1822: iload 5
    //   1824: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1827: ldc_w 1089
    //   1830: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1833: iload 8
    //   1835: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1838: ldc_w 920
    //   1841: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1844: iload 4
    //   1846: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1849: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1852: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1855: iload 5
    //   1857: iconst_1
    //   1858: if_icmpne +24 -> 1882
    //   1861: iload 8
    //   1863: sipush 130
    //   1866: if_icmpne +16 -> 1882
    //   1869: sipush 1006
    //   1872: istore 5
    //   1874: iconst_1
    //   1875: istore 8
    //   1877: aload_2
    //   1878: astore_1
    //   1879: goto -731 -> 1148
    //   1882: aload_0
    //   1883: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1886: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1889: aload_2
    //   1890: iconst_0
    //   1891: invokevirtual 1092	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;
    //   1894: getfield 1095	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1897: istore 5
    //   1899: goto -25 -> 1874
    //   1902: aload_0
    //   1903: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1906: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1909: aload_2
    //   1910: iconst_0
    //   1911: invokevirtual 1092	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;
    //   1914: getfield 1095	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1917: istore 5
    //   1919: goto -45 -> 1874
    //   1922: iconst_0
    //   1923: istore 10
    //   1925: goto -355 -> 1570
    //   1928: aload_0
    //   1929: getfield 33	akak:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1932: aload_2
    //   1933: invokeinterface 1072 2 0
    //   1938: pop
    //   1939: goto -345 -> 1594
    //   1942: iload 4
    //   1944: ifgt +544 -> 2488
    //   1947: aload_0
    //   1948: getfield 469	akak:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1951: invokevirtual 1096	com/tencent/mobileqq/app/MessageHandler:c	()V
    //   1954: iload 11
    //   1956: ifeq +454 -> 2410
    //   1959: aload_0
    //   1960: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1963: invokevirtual 1099	com/tencent/mobileqq/app/QQAppInterface:a	()Lakaq;
    //   1966: invokevirtual 1103	akaq:a	()Ljava/util/Set;
    //   1969: invokeinterface 456 1 0
    //   1974: astore_1
    //   1975: aload_1
    //   1976: invokeinterface 253 1 0
    //   1981: ifeq +414 -> 2395
    //   1984: aload_1
    //   1985: invokeinterface 257 1 0
    //   1990: checkcast 1012	com/tencent/mobileqq/data/ConversationInfo
    //   1993: astore_2
    //   1994: aload_2
    //   1995: getfield 1106	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1998: ifnull -23 -> 1975
    //   2001: aload_2
    //   2002: getfield 1109	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   2005: sipush 1036
    //   2008: if_icmpeq -33 -> 1975
    //   2011: aload_2
    //   2012: getfield 1109	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   2015: invokestatic 1010	akbm:a	(I)I
    //   2018: sipush 1032
    //   2021: if_icmpeq -46 -> 1975
    //   2024: iload 6
    //   2026: iconst_1
    //   2027: if_icmpne +13 -> 2040
    //   2030: aload_2
    //   2031: getfield 1109	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   2034: sipush 1008
    //   2037: if_icmpeq -62 -> 1975
    //   2040: iload 6
    //   2042: iconst_2
    //   2043: if_icmpne +13 -> 2056
    //   2046: aload_2
    //   2047: getfield 1109	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   2050: sipush 1008
    //   2053: if_icmpne -78 -> 1975
    //   2056: iload 6
    //   2058: iconst_2
    //   2059: if_icmpeq +31 -> 2090
    //   2062: aload_0
    //   2063: getfield 33	akak:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   2066: invokeinterface 1110 1 0
    //   2071: ifle +19 -> 2090
    //   2074: aload_0
    //   2075: getfield 33	akak:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   2078: aload_2
    //   2079: getfield 1106	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   2082: invokeinterface 1113 2 0
    //   2087: ifne -112 -> 1975
    //   2090: iload 6
    //   2092: iconst_2
    //   2093: if_icmpne +31 -> 2124
    //   2096: aload_0
    //   2097: getfield 35	akak:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   2100: invokeinterface 1110 1 0
    //   2105: ifle +19 -> 2124
    //   2108: aload_0
    //   2109: getfield 35	akak:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   2112: aload_2
    //   2113: getfield 1106	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   2116: invokeinterface 1113 2 0
    //   2121: ifne -146 -> 1975
    //   2124: aload_2
    //   2125: getfield 1109	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   2128: invokestatic 372	akbm:c	(I)Z
    //   2131: ifeq -156 -> 1975
    //   2134: aload_2
    //   2135: invokestatic 1116	akaq:b	(Lcom/tencent/mobileqq/data/ConversationInfo;)I
    //   2138: ifle -163 -> 1975
    //   2141: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2144: ifeq +45 -> 2189
    //   2147: ldc 164
    //   2149: iconst_2
    //   2150: new 109	java/lang/StringBuilder
    //   2153: dup
    //   2154: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   2157: ldc_w 1118
    //   2160: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2163: aload_2
    //   2164: getfield 1106	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   2167: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2170: ldc_w 1120
    //   2173: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2176: aload_2
    //   2177: getfield 1109	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   2180: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2183: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2186: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2189: aload_2
    //   2190: getfield 1106	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   2193: invokevirtual 698	java/lang/String:length	()I
    //   2196: iconst_4
    //   2197: if_icmple -222 -> 1975
    //   2200: aload_2
    //   2201: getfield 1109	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   2204: sipush 1001
    //   2207: if_icmpne +134 -> 2341
    //   2210: aload_0
    //   2211: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2214: invokevirtual 216	com/tencent/mobileqq/app/QQAppInterface:a	()Lawao;
    //   2217: aload_2
    //   2218: getfield 1106	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   2221: invokevirtual 1123	awao:m	(Ljava/lang/String;)[B
    //   2224: astore_3
    //   2225: aload_3
    //   2226: ifnull -251 -> 1975
    //   2229: aload_3
    //   2230: arraylength
    //   2231: ifle -256 -> 1975
    //   2234: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2237: ifeq +29 -> 2266
    //   2240: ldc 164
    //   2242: iconst_2
    //   2243: new 109	java/lang/StringBuilder
    //   2246: dup
    //   2247: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   2250: ldc_w 1125
    //   2253: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2256: aload_3
    //   2257: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2260: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2263: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2266: new 1054	android/os/Message
    //   2269: dup
    //   2270: invokespecial 1055	android/os/Message:<init>	()V
    //   2273: astore_3
    //   2274: aload_3
    //   2275: iconst_1
    //   2276: putfield 1058	android/os/Message:what	I
    //   2279: new 677	android/os/Bundle
    //   2282: dup
    //   2283: invokespecial 678	android/os/Bundle:<init>	()V
    //   2286: astore 22
    //   2288: aload 22
    //   2290: ldc_w 1060
    //   2293: ldc2_w 1126
    //   2296: invokevirtual 813	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   2299: aload 22
    //   2301: ldc_w 1062
    //   2304: aload_2
    //   2305: getfield 1106	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   2308: invokevirtual 689	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2311: aload 22
    //   2313: ldc_w 1064
    //   2316: aload_2
    //   2317: getfield 1109	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   2320: invokevirtual 684	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2323: aload_3
    //   2324: aload 22
    //   2326: invokevirtual 1068	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   2329: aload_0
    //   2330: getfield 469	akak:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2333: aload_3
    //   2334: iconst_1
    //   2335: invokevirtual 1071	com/tencent/mobileqq/app/MessageHandler:a	(Landroid/os/Message;Z)V
    //   2338: goto -363 -> 1975
    //   2341: aload_2
    //   2342: getfield 1109	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   2345: sipush 10002
    //   2348: if_icmpne +21 -> 2369
    //   2351: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2354: ifeq -88 -> 2266
    //   2357: ldc 164
    //   2359: iconst_2
    //   2360: ldc_w 1129
    //   2363: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2366: goto -100 -> 2266
    //   2369: aload_2
    //   2370: getfield 1132	com/tencent/mobileqq/data/ConversationInfo:isImax	Z
    //   2373: ifeq -107 -> 2266
    //   2376: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2379: ifeq -404 -> 1975
    //   2382: ldc_w 1134
    //   2385: iconst_2
    //   2386: ldc_w 1136
    //   2389: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2392: goto -417 -> 1975
    //   2395: iload 6
    //   2397: iconst_2
    //   2398: if_icmpne +140 -> 2538
    //   2401: aload_0
    //   2402: getfield 35	akak:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   2405: invokeinterface 1139 1 0
    //   2410: invokestatic 1144	befa:a	()Lbefa;
    //   2413: invokevirtual 1146	befa:e	()V
    //   2416: iload 6
    //   2418: tableswitch	default:+26 -> 2444, 0:+132->2550, 1:+153->2571, 2:+165->2583
    //   2445: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2448: invokevirtual 216	com/tencent/mobileqq/app/QQAppInterface:a	()Lawao;
    //   2451: invokevirtual 1148	awao:i	()V
    //   2454: aload_0
    //   2455: getfield 469	akak:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2458: invokevirtual 913	com/tencent/mobileqq/app/MessageHandler:a	()Z
    //   2461: ifeq +27 -> 2488
    //   2464: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2467: ifeq +12 -> 2479
    //   2470: ldc 164
    //   2472: iconst_2
    //   2473: ldc_w 1150
    //   2476: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2479: aload_0
    //   2480: getfield 469	akak:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2483: iconst_0
    //   2484: iconst_0
    //   2485: invokevirtual 1153	com/tencent/mobileqq/app/MessageHandler:a	(ZI)V
    //   2488: invokestatic 838	java/lang/System:currentTimeMillis	()J
    //   2491: lload 14
    //   2493: lsub
    //   2494: lstore 14
    //   2496: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2499: ifeq +30 -> 2529
    //   2502: ldc 164
    //   2504: iconst_2
    //   2505: new 109	java/lang/StringBuilder
    //   2508: dup
    //   2509: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   2512: ldc_w 1155
    //   2515: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2518: lload 14
    //   2520: invokevirtual 232	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2523: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2526: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2529: ldc_w 1157
    //   2532: lload 14
    //   2534: invokestatic 1159	akbf:a	(Ljava/lang/String;J)V
    //   2537: return
    //   2538: aload_0
    //   2539: getfield 33	akak:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   2542: invokeinterface 1139 1 0
    //   2547: goto -137 -> 2410
    //   2550: aload_0
    //   2551: sipush 4016
    //   2554: iconst_1
    //   2555: aconst_null
    //   2556: invokevirtual 823	akak:a	(IZLjava/lang/Object;)V
    //   2559: aload_0
    //   2560: sipush 4001
    //   2563: iconst_1
    //   2564: aconst_null
    //   2565: invokevirtual 823	akak:a	(IZLjava/lang/Object;)V
    //   2568: goto -124 -> 2444
    //   2571: aload_0
    //   2572: sipush 4001
    //   2575: iconst_1
    //   2576: aconst_null
    //   2577: invokevirtual 823	akak:a	(IZLjava/lang/Object;)V
    //   2580: goto -136 -> 2444
    //   2583: aload_0
    //   2584: sipush 4016
    //   2587: iconst_1
    //   2588: aconst_null
    //   2589: invokevirtual 823	akak:a	(IZLjava/lang/Object;)V
    //   2592: goto -148 -> 2444
    //   2595: iconst_0
    //   2596: istore 4
    //   2598: goto -2209 -> 389
    //   2601: iconst_2
    //   2602: istore 5
    //   2604: goto -2225 -> 379
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2607	0	this	akak
    //   0	2607	1	paramToServiceMsg	ToServiceMsg
    //   0	2607	2	paramFromServiceMsg	FromServiceMsg
    //   0	2607	3	paramObject	Object
    //   387	2210	4	b1	byte
    //   377	2226	5	n	int
    //   417	2000	6	i1	int
    //   669	930	7	i2	int
    //   1146	730	8	i3	int
    //   1246	302	9	i4	int
    //   469	1455	10	bool1	boolean
    //   11	1944	11	bool2	boolean
    //   37	906	12	bool3	boolean
    //   24	588	13	bool4	boolean
    //   42	2491	14	l1	long
    //   724	807	16	l2	long
    //   987	106	18	l3	long
    //   1016	110	20	l4	long
    //   51	151	22	localPbGetMsgResp	msf.msgsvc.msg_svc.PbGetMsgResp
    //   260	15	22	localException	Exception
    //   280	2045	22	localObject1	Object
    //   114	718	24	localStringBuilder	StringBuilder
    //   348	341	25	localList	List
    // Exception table:
    //   from	to	target	type
    //   53	70	260	java/lang/Exception
    //   933	971	1709	finally
    //   1710	1713	1709	finally
    //   919	933	1715	java/lang/Exception
    //   1713	1715	1715	java/lang/Exception
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    paramFromServiceMsg = new HashMap(1);
    paramFromServiceMsg.put("KEYWORD", paramToServiceMsg.extraData.getString("keyword"));
    paramFromServiceMsg.put("SEARCHSEQUENCE", Long.valueOf(paramToServiceMsg.extraData.getLong("sequence")));
    paramFromServiceMsg.put("LOADTYPE", Integer.valueOf(paramToServiceMsg.extraData.getInt("loadType")));
    int n = paramToServiceMsg.extraData.getInt("retryIndex");
    if ((!paramBoolean) && (n < 2))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.C2CMessageProcessor", 2, "handleSearchRoamMsgInCloudTimeOutAndError retry index:" + n);
      }
      paramToServiceMsg.extraData.putInt("retryIndex", n + 1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendPbReq(paramToServiceMsg);
      return;
    }
    a(8015, false, paramFromServiceMsg);
  }
  
  private void a(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      long l1 = System.currentTimeMillis() / 1000L;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if (localMessageRecord.istroop == 1008) {
          if ((!TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("public_account_send_flag"))) && (!TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("public_account_msg_id"))) && (!TextUtils.equals(localMessageRecord.frienduin, localMessageRecord.selfuin))) {
            ThreadManager.post(new C2CMessageProcessor.7(this, localMessageRecord.frienduin, localMessageRecord.selfuin, localMessageRecord.getExtInfoFromExtStr("public_account_msg_id"), localMessageRecord.time, l1, localMessageRecord.getExtInfoFromExtStr("public_account_send_flag")), 5, null, false);
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
    int n;
    int i1;
    Object localObject1;
    long l7;
    Object localObject2;
    boolean bool2;
    boolean bool3;
    for (;;)
    {
      return;
      l1 = localMsgHead.c2c_cmd.get();
      l2 = localMsgHead.from_uin.get();
      long l3 = localMsgHead.to_uin.get();
      long l4 = localMsgHead.msg_seq.get();
      long l5 = localMsgHead.msg_time.get();
      long l6 = localMsgHead.msg_uid.get();
      n = localMsgHead.user_active.get();
      i1 = localMsgHead.from_instid.get();
      if (paramFromServiceMsg.getUin() == null)
      {
        localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        l7 = ((Long)localObject1).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_C2CPush:fromUin:" + l2 + ",toUin:" + l3 + ",msgTime:" + l5 + ",msgSeq:" + l4 + ",msgUid:" + l6 + ",userActive:" + n + ",fromInstid:" + i1 + ",hasAppShare:" + paramMsg.appshare_info.has() + ",hasMsgBody:" + paramMsg.msg_body.has());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_Int = n;
        localObject1 = new ArrayList();
      }
      try
      {
        localObject2 = new awam(l7, l2, true, false, false, false);
        ((awam)localObject2).h = true;
        paramMsg = a(paramMsg, (awbl)localObject2);
        ajml.a(paramMsg);
        if ((paramMsg != null) && (paramMsg.size() != 0))
        {
          if (localObject1 != null) {
            a(paramMsg, (ArrayList)localObject1, true);
          }
          paramMsg = new ArrayList();
          localObject2 = new ArrayList();
          if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
          {
            i1 = ((ArrayList)localObject1).size();
            n = 0;
            for (;;)
            {
              if (n < i1)
              {
                localMessageRecord = (MessageRecord)((ArrayList)localObject1).get(n);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_C2CPush after analysis mr.senderuin: " + localMessageRecord.senderuin + " mr.msgtype: " + localMessageRecord.msgtype + " mr.frienduin: " + localMessageRecord.frienduin + " mr.shmsgseq: " + localMessageRecord.shmsgseq + " mr.time:" + localMessageRecord.time + " mr.msg: " + localMessageRecord.getLogColorContent());
                }
                if ((localMessageRecord.frienduin == null) || (localMessageRecord.frienduin.length() <= 2))
                {
                  n += 1;
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
        bool2 = ajml.a((ArrayList)localObject2);
        bool3 = ajml.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)localObject2);
        n = akbm.a((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (!bool2) {
          break label874;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop) {}
    label874:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((QQMessageFacade)localObject1).a((ArrayList)localObject2, String.valueOf(l7), bool1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMsgHead.msg_seq.get());
      i1 = paramFromServiceMsg.getRequestSsoSeq();
      paramFromServiceMsg = paramPbPushMsg.bytes_push_token.get().toStringUtf8();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, new Object[] { "----------handleMsgPush_PB_C2CPush get Push token = ", paramFromServiceMsg, " and use ", "OnlinePush.RespPush", " send back to server" });
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l2, paramMsg, paramPbPushMsg.svrip.get(), i1, paramPbPushMsg);
      if (l1 == 127L) {
        break;
      }
      a("handleMsgPush_PB_C2CPush", true, n, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool3), false);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b((ArrayList)localObject2);
      return;
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    long l1 = bakz.a(paramArrayOfByte, 0);
    String str = String.valueOf(l1);
    bakz.a(paramArrayOfByte, 10);
    int n = bakz.a(paramArrayOfByte, 16);
    Object localObject = null;
    if (n > 0) {
      localObject = bakz.a(paramArrayOfByte, 18, n);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.C2CMessageProcessor", 2, "----->handleHotChatAnnouncementMsg dwGroupCode = " + l1 + ", len = " + n + ", announcement = " + (String)localObject);
    }
    paramArrayOfByte = (ajkc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35);
    localObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
    if ((paramArrayOfByte != null) && (localObject != null))
    {
      localObject = ((HotChatManager)localObject).a(str);
      if (localObject != null)
      {
        if (((HotChatInfo)localObject).userCreate != 1) {
          break label162;
        }
        paramArrayOfByte.a(str);
      }
    }
    return;
    label162:
    paramArrayOfByte.a(((HotChatInfo)localObject).uuid.getBytes(), str);
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
      i2 = paramToServiceMsg.extraData.getInt("fetchNum");
      bool2 = paramToServiceMsg.extraData.getBoolean("preloadType");
      paramObject = new Bundle();
      paramObject.putLong("BEGTIME", ((Long)localObject4).longValue());
      paramObject.putBoolean("FETCH_MORE", bool1);
      paramObject.putInt("MSG_COUNT", i2);
      paramObject.putString("PEER_UIN", paramToServiceMsg.extraData.getString("peerUin"));
      paramObject.putBoolean("IS_PRELOAD_TYPE", bool2);
      if (paramFromServiceMsg != null)
      {
        str = String.valueOf(paramFromServiceMsg.peer_uin.get());
        i1 = paramFromServiceMsg.result.get();
        localObject1 = paramFromServiceMsg.msg.get();
        if (localObject1 == null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(str)) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.remove(str);
          }
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg code=" + i1 + ", msgList is null !");
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
      int i2;
      boolean bool2;
      String str;
      int i1;
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
        QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg begTime: " + localObject4 + ", code=" + i1 + " ,errMsg=" + paramFromServiceMsg.errmsg.get() + ", msgList.size()=" + localArrayList.size() + ",peerUin=" + str + ",time=" + paramFromServiceMsg.last_msgtime.get() + ",fetchMore:" + bool1 + ",fetchNum: " + i2);
      }
      Object localObject1 = (ajmp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
      int n = 0;
      if (((i1 != 0) && (i1 != 1)) || (i1 == 0)) {}
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
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(str, ((Long)localObject4).longValue(), paramFromServiceMsg.last_msgtime.get(), paramToServiceMsg.extraData.getLong("lEndTime"), (short)0, paramFromServiceMsg.random.get(), 1, ((ajmp)localObject1).a(), ((ajmp)localObject1).b(), paramToServiceMsg.extraData.getBoolean("fetchMore"), i2, bool2);
            return;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg exception ! ", paramToServiceMsg);
          }
          n = 0;
          if (n != 0) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(str)) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.remove(str);
          }
          paramObject.putInt("SVR_CODE", i1);
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
          n = 0;
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
          l1 = ajml.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((msg_comm.MsgHead)((msg_comm.Msg)localObject6).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject6).msg_head.get()).to_uin.get(), paramFromServiceMsg.peer_uin.get());
        }
        ((ArrayList)localObject3).addAll((Collection)a((List)localObject2, (List)localObject5, l1, ((Long)localObject4).longValue(), paramToServiceMsg.extraData.getLong("lEndTime")).second);
        localObject4 = new awam(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), l1, true, true, false, false);
        ((awam)localObject4).h = true;
        localObject5 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (msg_comm.Msg)((Iterator)localObject5).next();
          try
          {
            localObject6 = a((msg_comm.Msg)localObject6, (awbl)localObject4);
            if ((localObject6 == null) || (((ArrayList)localObject6).isEmpty())) {
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
          Collections.sort((List)localObject3, new akam(this));
          if (localObject1 == null) {}
        }
        try
        {
          ((ajmp)localObject1).a((List)localObject3, str);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a((ArrayList)localObject3, false);
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()));
          if ((localObject4 == null) || (((Long)((Pair)localObject4).first).longValue() > paramFromServiceMsg.last_msgtime.get())) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()), paramToServiceMsg.extraData.getLong("lBeginTime"), 0L);
          }
          ((ajmp)localObject1).a().b(str, paramToServiceMsg.extraData.getLong("lBeginTime"), 3);
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg resList size = " + localArrayList.size() + ", dayList size = " + ((ArrayList)localObject2).size() + ", loopList size=" + ((ArrayList)localObject3).size());
          }
          paramObject.putInt("MSG_COUNT", i2 - ((ArrayList)localObject3).size());
          a(1004, true, paramObject);
          n = 1;
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
    int n;
    long l7;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    MessageRecord localMessageRecord;
    Object localObject2;
    int i2;
    for (;;)
    {
      return;
      l1 = localMsgHead.c2c_cmd.get();
      l2 = localMsgHead.from_uin.get();
      long l3 = localMsgHead.to_uin.get();
      long l4 = localMsgHead.msg_seq.get();
      long l5 = localMsgHead.msg_time.get();
      long l6 = localMsgHead.msg_uid.get();
      n = localMsgHead.user_active.get();
      i1 = localMsgHead.from_instid.get();
      Object localObject1;
      ArrayList localArrayList1;
      if (paramFromServiceMsg.getUin() == null)
      {
        localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        l7 = ((Long)localObject1).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_SlaveMaster:fromUin:" + l2 + ",toUin:" + l3 + ",msgTime:" + l5 + ",msgSeq:" + l4 + ",msgUid:" + l6 + ",userActive:" + n + ",fromInstid:" + i1 + ",hasAppShare:" + paramMsg.appshare_info.has() + ",hasMsgBody:" + paramMsg.msg_body.has());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_Int = n;
        localArrayList1 = new ArrayList();
      }
      try
      {
        localObject1 = new awam(l7, l3, true, false, false, false);
        ((awam)localObject1).h = true;
        localObject1 = a(paramMsg, (awbl)localObject1);
        ajml.a((List)localObject1);
        if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
        {
          if (localArrayList1 != null) {
            a((ArrayList)localObject1, localArrayList1, true);
          }
          n = 0;
          localObject1 = null;
          localArrayList2 = new ArrayList();
          localArrayList3 = new ArrayList();
          if ((localArrayList1 == null) || (localArrayList1.size() <= 0)) {
            break label1524;
          }
          int i7 = localArrayList1.size();
          int i5 = 0;
          for (;;)
          {
            if (i5 >= i7) {
              break label1365;
            }
            localMessageRecord = (MessageRecord)localArrayList1.get(i5);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_SlaveMaster after analysis mr.senderuin: " + localMessageRecord.senderuin + " mr.msgtype: " + localMessageRecord.msgtype + " mr.frienduin: " + localMessageRecord.frienduin + " mr.shmsgseq: " + localMessageRecord.shmsgseq + " mr.time:" + localMessageRecord.time + " mr.msg: " + localMessageRecord.getLogColorContent());
            }
            localObject3 = localObject1;
            i3 = n;
            if (localMessageRecord.frienduin != null)
            {
              if (localMessageRecord.frienduin.length() > 2) {
                break;
              }
              i3 = n;
              localObject3 = localObject1;
            }
            i5 += 1;
            localObject1 = localObject3;
            n = i3;
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
        i2 = 0;
        if (!(localMessageRecord instanceof MessageForStructing)) {
          break label1328;
        }
      }
    }
    MessageForStructing localMessageForStructing = (MessageForStructing)localMessageRecord;
    int i1 = i2;
    Object localObject3 = localObject2;
    int i3 = n;
    if (localMessageForStructing != null)
    {
      i1 = i2;
      localObject3 = localObject2;
      i3 = n;
      if (localMessageForStructing.structingMsg != null)
      {
        i1 = i2;
        localObject3 = localObject2;
        i3 = n;
        if (localMessageForStructing.structingMsg.mMsgServiceID == 128) {
          localObject3 = localMessageRecord.getExtInfoFromExtStr("key_message_extra_info_flag");
        }
      }
    }
    for (;;)
    {
      try
      {
        i1 = Integer.parseInt((String)localObject3);
        if ((i1 & 0x4) == 4)
        {
          i2 = 1;
          i3 = n;
          if (i2 != 0)
          {
            localMessageForStructing.extraflag = 32768;
            localMessageRecord.issend = 1;
            localMessageForStructing.saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(i1 & 0xFFFFFFFB));
            localObject2 = localMessageForStructing.frienduin;
            i3 = 1;
          }
          localMessageForStructing.isCheckNeedShowInListTypeMsg = true;
          n = -1;
          i2 = n;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          try
          {
            localObject3 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
            i1 = n;
            if (localObject3 != null)
            {
              i1 = n;
              i2 = n;
              if (((List)localObject3).size() > 0)
              {
                i6 = 0;
                i1 = n;
                i2 = n;
                if (i6 < ((List)localObject3).size())
                {
                  i2 = n;
                  localElem = (im_msg_body.Elem)((List)localObject3).get(i6);
                  i2 = n;
                  if (!localElem.general_flags.has()) {
                    continue;
                  }
                  i2 = n;
                  bool = localElem.general_flags.bytes_pb_reserve.has();
                  if (!bool) {
                    continue;
                  }
                  i4 = n;
                  i2 = n;
                }
              }
            }
          }
          catch (Throwable localThrowable2)
          {
            int i6;
            im_msg_body.Elem localElem;
            boolean bool;
            int i4;
            generalflags.ResvAttr localResvAttr;
            Object localObject4;
            i1 = i2;
            continue;
            continue;
          }
          try
          {
            localResvAttr = new generalflags.ResvAttr();
            i4 = n;
            i2 = n;
            localResvAttr.mergeFrom(localElem.general_flags.bytes_pb_reserve.get().toByteArray());
            i4 = n;
            i2 = n;
            if (!localResvAttr.uint32_show_in_msg_list.has()) {
              continue;
            }
            i4 = n;
            i2 = n;
            n = localResvAttr.uint32_show_in_msg_list.get();
            i1 = n;
            i4 = n;
            i2 = n;
            if (QLog.isColorLevel())
            {
              i4 = n;
              i2 = n;
              QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_SlaveMaster has uint32_show_in_msg_list:" + n);
              i1 = n;
            }
            if (i1 != 1) {
              continue;
            }
            localMessageForStructing.needNeedShowInList = true;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_SlaveMaster isCheckNeedShowInListTypeMsg:" + localMessageForStructing.isCheckNeedShowInListTypeMsg + " needNeedShowInList:" + localMessageForStructing.needNeedShowInList + " uint32_show_in_msg_list:" + i1);
            }
            i1 = 1;
            localObject3 = localObject2;
            if (i1 == 0) {
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
            n = i4;
            try
            {
              QLog.e("msgFold", 1, "prase ResvAttr error, ", localException2);
            }
            catch (Throwable localThrowable1)
            {
              i1 = n;
            }
          }
        }
        localNumberFormatException = localNumberFormatException;
        localNumberFormatException.printStackTrace();
        i1 = 0;
        continue;
        i2 = 0;
        continue;
      }
      i6 += 1;
      continue;
      QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C: ", localThrowable1);
      continue;
      localMessageForStructing.needNeedShowInList = false;
      continue;
      label1328:
      i1 = i2;
      localObject4 = localObject2;
      i3 = n;
      if (localMessageRecord.msgtype == -10000)
      {
        i1 = 1;
        localObject4 = localObject2;
        i3 = n;
      }
    }
    for (;;)
    {
      label1365:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localArrayList3);
      bool = ajml.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList3);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localArrayList3, String.valueOf(l7), false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMsgHead.msg_seq.get());
      i1 = paramFromServiceMsg.getRequestSsoSeq();
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l2, localArrayList2, paramPbPushMsg.svrip.get(), i1, null);
      if (l1 == 127L) {
        break;
      }
      a("handleMsgPush_PB_SlaveMaster", true, 0, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(false, bool), false);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(localArrayList3);
      if ((n == 0) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        break;
      }
      awbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2);
      return;
      label1524:
      n = 0;
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
    int n;
    long l1;
    try
    {
      paramFromServiceMsg = (msg_svc.PbGetOneDayRoamMsgResp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      localBundle = paramToServiceMsg.extraData.getBundle("context");
      paramObject = null;
      l2 = 0L;
      if (paramFromServiceMsg == null) {
        break label691;
      }
      n = paramFromServiceMsg.result.get();
      Object localObject = paramFromServiceMsg.msg.get();
      paramToServiceMsg = new ArrayList();
      a((List)localObject, paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsgInOneDay code=" + n + ", complete=" + paramFromServiceMsg.iscomplete.get() + " ,respRandom:" + paramFromServiceMsg.random.get() + ", lastMsgTime:" + paramFromServiceMsg.last_msgtime.get() + ", msgList.size()=" + paramToServiceMsg.size() + ", context" + localBundle);
      }
      if (n != 0) {
        break label692;
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
          awam localawam;
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
        l1 = ajml.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).to_uin.get(), paramFromServiceMsg.peer_uin.get());
      }
      localawam = new awam(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), l1, true, true, false, false);
      localawam.h = true;
      localIterator = paramToServiceMsg.iterator();
      paramToServiceMsg = null;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label479;
        }
        localObject = (msg_comm.Msg)localIterator.next();
        try
        {
          localObject = a((msg_comm.Msg)localObject, localawam);
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
    label479:
    if (paramObject.size() > 0)
    {
      Collections.sort(paramObject, new akan(this));
      l1 = ((MessageRecord)paramObject.get(0)).time;
    }
    for (paramToServiceMsg = paramObject;; paramToServiceMsg = null)
    {
      for (;;)
      {
        boolean bool3;
        boolean bool1;
        label563:
        boolean bool2;
        if (localBundle != null)
        {
          localBundle.getInt("size_req", 0);
          l2 = localBundle.getLong("UIN", 0L);
          bool3 = localBundle.getBoolean("canUpdateEct", true);
          if (paramFromServiceMsg.iscomplete.get() == 0) {
            break label734;
          }
          bool1 = true;
          if ((n != 0) && (n != 1) && (n != 4)) {
            break label740;
          }
          bool2 = true;
          label583:
          if ((!bool2) || (!bool3)) {
            break label783;
          }
          if (!bool1) {
            break label746;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(l2), 0L, 0L);
          label615:
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
          label691:
          return;
          label692:
          l1 = l2;
          paramToServiceMsg = paramObject;
          if (n == 1)
          {
            l1 = l2;
            paramToServiceMsg = paramObject;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "code == 0x01");
              l1 = l2;
              paramToServiceMsg = paramObject;
              continue;
              label734:
              bool1 = false;
              break label563;
              label740:
              bool2 = false;
              break label583;
              label746:
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()), paramFromServiceMsg.last_msgtime.get(), paramFromServiceMsg.random.get());
              break label615;
              label783:
              if (bool3) {
                break label615;
              }
              if (bool1)
              {
                localBundle.putLong("tempEct", 0L);
                localBundle.putLong("tempRandom", 0L);
                break label615;
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
    //   1: getfield 804	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 1179
    //   7: invokevirtual 1183	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   10: istore 4
    //   12: new 112	java/util/HashMap
    //   15: dup
    //   16: iconst_1
    //   17: invokespecial 1161	java/util/HashMap:<init>	(I)V
    //   20: astore 14
    //   22: aload 14
    //   24: ldc_w 1163
    //   27: aload_1
    //   28: getfield 804	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   31: ldc_w 1165
    //   34: invokevirtual 1167	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokevirtual 1171	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: pop
    //   41: aload 14
    //   43: ldc_w 1173
    //   46: aload_1
    //   47: getfield 804	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   50: ldc_w 1175
    //   53: invokevirtual 809	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   56: invokestatic 568	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   59: invokevirtual 1171	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   62: pop
    //   63: aload 14
    //   65: ldc_w 1177
    //   68: iload 4
    //   70: invokestatic 101	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   73: invokevirtual 1171	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   76: pop
    //   77: new 1703	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp
    //   80: dup
    //   81: invokespecial 1704	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:<init>	()V
    //   84: astore 13
    //   86: aload 13
    //   88: aload_3
    //   89: checkcast 843	[B
    //   92: checkcast 843	[B
    //   95: invokevirtual 1705	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 1703	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp
    //   101: astore 13
    //   103: aload 13
    //   105: ifnull +67 -> 172
    //   108: new 1707	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody
    //   111: dup
    //   112: invokespecial 1708	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:<init>	()V
    //   115: astore_3
    //   116: aload 13
    //   118: getfield 1711	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:serialize_rspbody	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   121: invokevirtual 466	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   124: ifeq +139 -> 263
    //   127: aload_3
    //   128: aload 13
    //   130: getfield 1711	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:serialize_rspbody	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   133: invokevirtual 472	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   136: invokevirtual 478	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   139: invokevirtual 1712	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   142: checkcast 1707	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody
    //   145: astore_3
    //   146: aload_3
    //   147: ifnonnull +121 -> 268
    //   150: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +12 -> 165
    //   156: ldc 164
    //   158: iconst_2
    //   159: ldc_w 1714
    //   162: invokestatic 1189	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload_0
    //   166: aload_1
    //   167: aload_2
    //   168: iconst_0
    //   169: invokespecial 1716	akak:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Z)V
    //   172: return
    //   173: astore_3
    //   174: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +13 -> 190
    //   180: ldc 164
    //   182: iconst_2
    //   183: ldc_w 1718
    //   186: aload_3
    //   187: invokestatic 421	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   190: aconst_null
    //   191: astore 13
    //   193: goto -90 -> 103
    //   196: astore_3
    //   197: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +13 -> 213
    //   203: ldc 164
    //   205: iconst_2
    //   206: ldc_w 1720
    //   209: aload_3
    //   210: invokestatic 421	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   213: aconst_null
    //   214: astore 13
    //   216: goto -113 -> 103
    //   219: astore_3
    //   220: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +13 -> 236
    //   226: ldc 164
    //   228: iconst_2
    //   229: ldc_w 1722
    //   232: aload_3
    //   233: invokestatic 421	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: aconst_null
    //   237: astore_3
    //   238: goto -92 -> 146
    //   241: astore_3
    //   242: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +13 -> 258
    //   248: ldc 164
    //   250: iconst_2
    //   251: ldc_w 1724
    //   254: aload_3
    //   255: invokestatic 421	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   258: aconst_null
    //   259: astore_3
    //   260: goto -114 -> 146
    //   263: aconst_null
    //   264: astore_3
    //   265: goto -119 -> 146
    //   268: aload_3
    //   269: getfield 1726	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:result	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   272: invokevirtual 905	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   275: istore 5
    //   277: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq +41 -> 321
    //   283: ldc 164
    //   285: iconst_2
    //   286: new 109	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   293: ldc_w 1728
    //   296: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: iload 5
    //   301: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   304: ldc_w 1730
    //   307: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: iload 4
    //   312: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   315: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 1189	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: iload 5
    //   323: ifeq +9 -> 332
    //   326: iload 5
    //   328: iconst_1
    //   329: if_icmpne +699 -> 1028
    //   332: aload 13
    //   334: getfield 1731	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   337: invokevirtual 87	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   340: astore 15
    //   342: aload 15
    //   344: ifnonnull +19 -> 363
    //   347: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   350: ifeq -178 -> 172
    //   353: ldc 164
    //   355: iconst_2
    //   356: ldc_w 1733
    //   359: invokestatic 1189	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: return
    //   363: new 61	java/util/ArrayList
    //   366: dup
    //   367: invokespecial 62	java/util/ArrayList:<init>	()V
    //   370: astore 16
    //   372: aload_0
    //   373: aload 15
    //   375: aload 16
    //   377: invokespecial 107	akak:a	(Ljava/util/List;Ljava/util/List;)V
    //   380: aload_0
    //   381: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   384: invokevirtual 75	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   387: invokestatic 121	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   390: lstore 10
    //   392: new 115	awam
    //   395: dup
    //   396: lload 10
    //   398: lconst_0
    //   399: iconst_1
    //   400: iconst_1
    //   401: iconst_0
    //   402: iconst_0
    //   403: invokespecial 124	awam:<init>	(JJZZZZ)V
    //   406: astore 17
    //   408: aload 17
    //   410: iconst_1
    //   411: putfield 241	awam:h	Z
    //   414: new 61	java/util/ArrayList
    //   417: dup
    //   418: invokespecial 62	java/util/ArrayList:<init>	()V
    //   421: astore 13
    //   423: aload 16
    //   425: invokevirtual 248	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   428: astore 18
    //   430: aload 18
    //   432: invokeinterface 253 1 0
    //   437: ifeq +253 -> 690
    //   440: aload 18
    //   442: invokeinterface 257 1 0
    //   447: checkcast 137	msf/msgcomm/msg_comm$Msg
    //   450: astore_2
    //   451: aload_2
    //   452: ifnull +23 -> 475
    //   455: aload_2
    //   456: getfield 141	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   459: invokevirtual 157	msf/msgcomm/msg_comm$MsgHead:has	()Z
    //   462: ifeq +13 -> 475
    //   465: aload_2
    //   466: getfield 150	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   469: invokevirtual 459	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   472: ifne +113 -> 585
    //   475: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   478: ifeq -48 -> 430
    //   481: new 109	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   488: ldc_w 1735
    //   491: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: astore 19
    //   496: aload_2
    //   497: ifnonnull +45 -> 542
    //   500: ldc_w 1737
    //   503: astore_2
    //   504: ldc 164
    //   506: iconst_2
    //   507: aload 19
    //   509: aload_2
    //   510: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   519: goto -89 -> 430
    //   522: astore_2
    //   523: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   526: ifeq -96 -> 430
    //   529: ldc 164
    //   531: iconst_2
    //   532: ldc_w 1739
    //   535: aload_2
    //   536: invokestatic 421	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   539: goto -109 -> 430
    //   542: new 109	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 1741
    //   552: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload_2
    //   556: getfield 141	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   559: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   562: ldc_w 1743
    //   565: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: aload_2
    //   569: getfield 150	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   572: invokevirtual 459	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   575: invokevirtual 781	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   578: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: astore_2
    //   582: goto -78 -> 504
    //   585: aload_2
    //   586: getfield 141	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   589: invokevirtual 146	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   592: checkcast 143	msf/msgcomm/msg_comm$MsgHead
    //   595: astore 19
    //   597: aload 19
    //   599: getfield 185	msf/msgcomm/msg_comm$MsgHead:to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   602: invokevirtual 189	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   605: lstore 6
    //   607: aload 19
    //   609: getfield 192	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   612: invokevirtual 189	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   615: lstore 8
    //   617: lload 6
    //   619: lload 10
    //   621: lcmp
    //   622: ifeq +414 -> 1036
    //   625: lload 8
    //   627: lload 10
    //   629: lcmp
    //   630: ifeq +406 -> 1036
    //   633: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   636: ifeq -206 -> 430
    //   639: ldc 164
    //   641: iconst_2
    //   642: ldc_w 1745
    //   645: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   648: goto -218 -> 430
    //   651: aload 17
    //   653: lload 6
    //   655: putfield 239	awam:jdField_e_of_type_Long	J
    //   658: aload_0
    //   659: aload_2
    //   660: aload 17
    //   662: invokevirtual 244	akak:a	(Lmsf/msgcomm/msg_comm$Msg;Lawbl;)Ljava/util/ArrayList;
    //   665: astore_2
    //   666: aload_2
    //   667: ifnull -237 -> 430
    //   670: aload_2
    //   671: invokevirtual 1498	java/util/ArrayList:isEmpty	()Z
    //   674: ifne -244 -> 430
    //   677: aload 13
    //   679: aload_2
    //   680: invokevirtual 1497	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   683: pop
    //   684: goto -254 -> 430
    //   687: goto -36 -> 651
    //   690: aload 13
    //   692: invokevirtual 132	java/util/ArrayList:size	()I
    //   695: ifle +16 -> 711
    //   698: aload 13
    //   700: new 1747	akao
    //   703: dup
    //   704: aload_0
    //   705: invokespecial 1748	akao:<init>	(Lakak;)V
    //   708: invokestatic 962	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   711: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   714: ifeq +63 -> 777
    //   717: ldc 164
    //   719: iconst_2
    //   720: new 109	java/lang/StringBuilder
    //   723: dup
    //   724: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   727: ldc_w 1750
    //   730: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: aload 15
    //   735: invokeinterface 93 1 0
    //   740: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   743: ldc_w 1752
    //   746: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: aload 16
    //   751: invokevirtual 132	java/util/ArrayList:size	()I
    //   754: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   757: ldc_w 1754
    //   760: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: aload 13
    //   765: invokevirtual 132	java/util/ArrayList:size	()I
    //   768: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   771: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   774: invokestatic 1189	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   777: aload_3
    //   778: getfield 1757	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:friends	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   781: invokevirtual 1758	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   784: ifeq +124 -> 908
    //   787: aload_3
    //   788: getfield 1757	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:friends	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   791: invokevirtual 87	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   794: astore_2
    //   795: aload_2
    //   796: ifnull +117 -> 913
    //   799: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   802: ifeq +34 -> 836
    //   805: ldc 164
    //   807: iconst_2
    //   808: new 109	java/lang/StringBuilder
    //   811: dup
    //   812: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   815: ldc_w 1760
    //   818: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: aload_2
    //   822: invokeinterface 93 1 0
    //   827: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   830: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   833: invokestatic 1189	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   836: aload 13
    //   838: invokevirtual 132	java/util/ArrayList:size	()I
    //   841: ifne +126 -> 967
    //   844: iload 5
    //   846: iconst_1
    //   847: if_icmpeq +120 -> 967
    //   850: aload_1
    //   851: getfield 804	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   854: ldc_w 1185
    //   857: invokevirtual 1183	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   860: istore 5
    //   862: iload 5
    //   864: iconst_4
    //   865: if_icmpge +66 -> 931
    //   868: aload_0
    //   869: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   872: invokevirtual 1192	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/MessageHandler;
    //   875: iload 4
    //   877: aconst_null
    //   878: aload_1
    //   879: getfield 804	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   882: ldc_w 1165
    //   885: invokevirtual 1167	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   888: aload_1
    //   889: getfield 804	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   892: ldc_w 1175
    //   895: invokevirtual 809	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   898: aload_2
    //   899: iload 5
    //   901: iconst_1
    //   902: iadd
    //   903: lconst_0
    //   904: invokevirtual 1763	com/tencent/mobileqq/app/MessageHandler:a	(ILjava/util/List;Ljava/lang/String;JLjava/util/List;IJ)V
    //   907: return
    //   908: aconst_null
    //   909: astore_2
    //   910: goto -115 -> 795
    //   913: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   916: ifeq -80 -> 836
    //   919: ldc 164
    //   921: iconst_2
    //   922: ldc_w 1765
    //   925: invokestatic 1189	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   928: goto -92 -> 836
    //   931: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   934: ifeq +12 -> 946
    //   937: ldc 164
    //   939: iconst_2
    //   940: ldc_w 1767
    //   943: invokestatic 1189	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   946: aload 14
    //   948: ldc_w 1769
    //   951: aload_2
    //   952: invokevirtual 1171	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   955: pop
    //   956: aload_0
    //   957: sipush 8015
    //   960: iconst_0
    //   961: aload 14
    //   963: invokevirtual 823	akak:a	(IZLjava/lang/Object;)V
    //   966: return
    //   967: aload 14
    //   969: ldc_w 1769
    //   972: aload_2
    //   973: invokevirtual 1171	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   976: pop
    //   977: aload 14
    //   979: ldc_w 1771
    //   982: aload 13
    //   984: invokevirtual 1171	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   987: pop
    //   988: iload 5
    //   990: iconst_1
    //   991: if_icmpne +31 -> 1022
    //   994: iconst_1
    //   995: istore 12
    //   997: aload 14
    //   999: ldc_w 1773
    //   1002: iload 12
    //   1004: invokestatic 893	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1007: invokevirtual 1171	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1010: pop
    //   1011: aload_0
    //   1012: sipush 8015
    //   1015: iconst_1
    //   1016: aload 14
    //   1018: invokevirtual 823	akak:a	(IZLjava/lang/Object;)V
    //   1021: return
    //   1022: iconst_0
    //   1023: istore 12
    //   1025: goto -28 -> 997
    //   1028: aload_0
    //   1029: aload_1
    //   1030: aload_2
    //   1031: iconst_0
    //   1032: invokespecial 1716	akak:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Z)V
    //   1035: return
    //   1036: lload 6
    //   1038: lload 10
    //   1040: lcmp
    //   1041: ifne -354 -> 687
    //   1044: lload 8
    //   1046: lstore 6
    //   1048: goto -397 -> 651
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1051	0	this	akak
    //   0	1051	1	paramToServiceMsg	ToServiceMsg
    //   0	1051	2	paramFromServiceMsg	FromServiceMsg
    //   0	1051	3	paramObject	Object
    //   10	866	4	n	int
    //   275	717	5	i1	int
    //   605	442	6	l1	long
    //   615	430	8	l2	long
    //   390	649	10	l3	long
    //   995	29	12	bool	boolean
    //   84	899	13	localObject1	Object
    //   20	997	14	localHashMap	HashMap
    //   340	394	15	localList	List
    //   370	380	16	localArrayList	ArrayList
    //   406	255	17	localawam	awam
    //   428	13	18	localIterator	Iterator
    //   494	114	19	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   86	103	173	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   86	103	196	java/lang/OutOfMemoryError
    //   127	146	219	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   127	146	241	java/lang/OutOfMemoryError
    //   455	475	522	java/lang/Exception
    //   475	496	522	java/lang/Exception
    //   504	519	522	java/lang/Exception
    //   542	582	522	java/lang/Exception
    //   585	617	522	java/lang/Exception
    //   633	648	522	java/lang/Exception
    //   651	666	522	java/lang/Exception
    //   670	684	522	java/lang/Exception
  }
  
  protected String a(msg_comm.Msg paramMsg)
  {
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    return 64 + "key_uid_" + l1 + "_seq_" + l2;
  }
  
  public ArrayList<MessageRecord> a(msg_comm.Msg paramMsg, awbl paramawbl)
  {
    if (!(paramawbl instanceof awam)) {
      return new ArrayList();
    }
    awam localawam = (awam)paramawbl;
    long l4 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    if ((paramMsg == null) || (!paramMsg.msg_head.has()) || (!paramMsg.msg_body.has()))
    {
      if (QLog.isColorLevel())
      {
        paramawbl = new StringBuilder().append("decodeSinglePBMsg_C2C return : ");
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
    int i7 = (short)localMsgHead.msg_seq.get();
    long l2 = localMsgHead.to_uin.get();
    long l5 = localMsgHead.from_uin.get();
    long l3 = localMsgHead.msg_time.get();
    long l6 = localMsgHead.msg_uid.get();
    int i6 = localMsgHead.msg_type.get();
    int i2 = paramMsg.msg_head.c2c_cmd.get();
    int n = 0;
    int i1 = 0;
    int i5;
    int i4;
    int i3;
    if (paramMsg.content_head.has())
    {
      paramawbl = (msg_comm.ContentHead)paramMsg.content_head.get();
      i5 = paramawbl.div_seq.get();
      i4 = paramawbl.pkg_num.get();
      i3 = paramawbl.pkg_index.get();
    }
    for (;;)
    {
      long l1 = -1L;
      paramawbl = null;
      label424:
      Object localObject1;
      Object localObject2;
      if (!localawam.jdField_d_of_type_Boolean)
      {
        paramawbl = awbg.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, String.valueOf(localawam.jdField_e_of_type_Long), String.valueOf(l5));
        if (((Long)paramawbl.first).longValue() != 4294967295L) {
          l1 = ((Long)paramawbl.first).longValue();
        }
      }
      else
      {
        localawam.jdField_b_of_type_Long = l5;
        localawam.jdField_c_of_type_Long = l3;
        int i8 = awbg.a(paramMsg);
        localawam.jdField_a_of_type_Int = i8;
        localawam.jdField_d_of_type_Long = ajrm.a((int)l1, i8);
        localawam.jdField_b_of_type_Int = awbg.e(paramMsg);
        if (l5 != localawam.jdField_a_of_type_Long) {
          break label1134;
        }
        localawam.jdField_a_of_type_Boolean = true;
        localawam.f = true;
        if (!QLog.isColorLevel()) {
          break label1154;
        }
        localObject1 = new StringBuilder();
        localObject2 = ((StringBuilder)localObject1).append("<---decodeSinglePBMsg_C2C : decode msg: msgTime:").append(l3).append(" shortSeq:").append(i7).append(" uint32Seq:").append(localMsgHead.msg_seq.get()).append(" msgUid:").append(l6).append(" toUin:").append(l2).append(" senderUin:").append(l5).append(" friendUin:").append(localawam.jdField_e_of_type_Long).append(" isReaded:").append(localawam.jdField_a_of_type_Boolean).append(" isSyncFromOtherTerm:").append(localawam.f).append(" msgType:").append(i6).append(" C2CCmd:").append(i2).append(" hasTemp:").append(localMsgHead.c2c_tmp_msg_head.has()).append(" hasShare:").append(paramMsg.appshare_info.has()).append(" pkgID:");
        if (paramawbl != null) {
          break label1143;
        }
        paramawbl = "nullPair";
        label626:
        ((StringBuilder)localObject2).append(paramawbl).append(" longMsgID:").append(i5).append(" longMsgCount:").append(i4).append(" longMsgIndex:").append(i3).append("init_direction_flag").append(0);
        QLog.d("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject1).toString());
        label687:
        paramawbl = new ArrayList();
        if ((i6 != 140) && (i6 != 141) && ((i6 != 529) || (localMsgHead.c2c_cmd.get() != 6))) {
          break label1238;
        }
        i1 = 1;
        localObject1 = awbg.a(paramMsg);
        if (((awbm)localObject1).jdField_a_of_type_Int != -1) {
          break label1176;
        }
        n = 0;
        label752:
        if (n == 0) {
          break label1228;
        }
        i2 = ((awbm)localObject1).jdField_b_of_type_Int;
        awbg.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramawbl, paramMsg, (awbm)localObject1, localawam);
        n = ((awbm)localObject1).jdField_a_of_type_Int;
        if ((paramawbl.size() <= 0) || (!alyc.a((MessageRecord)paramawbl.get(0)))) {
          break label5364;
        }
        if (!((MessageRecord)paramawbl.get(0)).isSelfConfessor()) {
          break label1231;
        }
        n = 1033;
        label821:
        ((awbm)localObject1).jdField_a_of_type_Int = n;
        n = ((awbm)localObject1).jdField_a_of_type_Int;
      }
      label1134:
      label5359:
      label5364:
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "friendType:" + n + ", direction_flag:" + i2);
        }
        i1 = n;
        n = i2;
        for (;;)
        {
          if ((paramawbl.size() == 0) && (i4 > 1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C, empty long msg fragment");
            }
            localObject1 = (MessageForText)awbi.a(-1000);
            ((MessageForText)localObject1).msgtype = -1000;
            ((MessageForText)localObject1).msg = "";
            paramawbl.add(localObject1);
          }
          l1 = -1L;
          l2 = l1;
          for (;;)
          {
            try
            {
              localObject1 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
              l3 = l1;
              if (localObject1 == null) {
                continue;
              }
              l3 = l1;
              l2 = l1;
              if (((List)localObject1).size() <= 0) {
                continue;
              }
              i2 = 0;
              l3 = l1;
              l2 = l1;
              if (i2 >= ((List)localObject1).size()) {
                continue;
              }
              l2 = l1;
              localObject2 = (im_msg_body.Elem)((List)localObject1).get(i2);
              l2 = l1;
              if (!((im_msg_body.Elem)localObject2).elem_flags2.has()) {
                continue;
              }
              l2 = l1;
              if (!((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject2).elem_flags2.get()).uint64_msg_id.has()) {
                continue;
              }
              l2 = l1;
              l1 = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject2).elem_flags2.get()).uint64_msg_id.get();
            }
            catch (Throwable localThrowable)
            {
              boolean bool1;
              boolean bool2;
              Object localObject3;
              QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C: ", localThrowable);
              l1 = l2;
              continue;
              ((MessageRecord)localObject3).selfuin = String.valueOf(localawam.jdField_a_of_type_Long);
              ((MessageRecord)localObject3).frienduin = String.valueOf(localawam.jdField_e_of_type_Long);
              ((MessageRecord)localObject3).senderuin = String.valueOf(localawam.jdField_b_of_type_Long);
              ((MessageRecord)localObject3).time = localawam.jdField_c_of_type_Long;
              ((MessageRecord)localObject3).shmsgseq = i7;
              ((MessageRecord)localObject3).msgUid = l6;
              ((MessageRecord)localObject3).istroop = i1;
              ((MessageRecord)localObject3).longMsgId = i5;
              ((MessageRecord)localObject3).longMsgCount = i4;
              ((MessageRecord)localObject3).longMsgIndex = i3;
              if ((1 != n) || (!akbm.r(((MessageRecord)localObject3).istroop)) || (akbm.a(((MessageRecord)localObject3).istroop) == 1032) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject3).frienduin)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject3).frienduin, akbm.a(((MessageRecord)localObject3).istroop), akbm.a(akbm.a(((MessageRecord)localObject3).istroop))))) {
                continue;
              }
              akbm.a((MessageRecord)localObject3, true);
              if (((MessageRecord)localObject3).msgtype != -2058) {
                continue;
              }
              EmojiStickerManager.a((MessageRecord)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              if ((!akbm.r(i1)) || (!(localObject3 instanceof MessageForStructing))) {
                continue;
              }
              i2 = akaz.a((MessageRecord)localObject3, 1);
              if (i2 <= 0) {
                continue;
              }
              ((MessageRecord)localObject3).saveExtInfoToExtStr("nearby_gift_msg", "1|" + String.valueOf(i2));
              paramawbl = (MessageForStructing)localObject3;
              if ((paramawbl.structingMsg.mMsgServiceID != 52) || ((ajnb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(124) == null)) {
                continue;
              }
              paramawbl = new NearbyFlowerMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramawbl);
              if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(paramawbl.sUin)) {
                continue;
              }
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060AF", "0X80060AF", 0, 0, "", "", "", "");
              if (!"4".equals(paramawbl.version)) {
                continue;
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.msg.C2CMessageProcessor", 2, "<---received random chat flower message, don't put it to aio");
              awbg.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i7, l6, i6);
              continue;
              akbm.a((MessageRecord)localObject3, false);
              continue;
              if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(paramawbl.rUin)) {
                continue;
              }
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060B0", "0X80060B0", 0, 0, "", "", "", "");
              continue;
              paramawbl = (msg_comm.C2CTmpMsgHead)localMsgHead.c2c_tmp_msg_head.get();
              if ((paramawbl == null) || (!paramawbl.lock_display.has()) || (paramawbl.lock_display.get() != 1)) {
                continue;
              }
              ((MessageRecord)localObject3).extLong |= 0x1;
              ((MessageRecord)localObject3).saveExtInfoToExtStr("lockDisplay", "true");
              if ((i1 != 0) || (!(localObject3 instanceof MessageForPic))) {
                continue;
              }
              ((MessageForPic)localObject3).bEnableEnc = true;
              if (i1 != 1006) {
                continue;
              }
              if (!localMsgHead.from_nick.has()) {
                continue;
              }
              ((ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(String.valueOf(localawam.jdField_e_of_type_Long), localMsgHead.from_nick.get());
              ((MessageRecord)localObject3).frienduin = babh.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(localawam.jdField_e_of_type_Long));
              ((MessageRecord)localObject3).senderuin = babh.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l5));
              if ((!TextUtils.isEmpty(((MessageRecord)localObject3).frienduin)) || (!localawam.jdField_d_of_type_Boolean)) {
                continue;
              }
              ((MessageRecord)localObject3).frienduin = String.valueOf(localawam.jdField_e_of_type_Long);
              if (((MessageRecord)localObject3).frienduin != null) {
                continue;
              }
              QLog.e("Q.msg.C2CMessageProcessor", 1, String.format("decodeMessage error, getPhoneNumByUin is null, friendUin: %d senderUin: %d uinType: %d msgType: %d", new Object[] { Long.valueOf(localawam.jdField_e_of_type_Long), Long.valueOf(l5), Integer.valueOf(((MessageRecord)localObject3).istroop), Integer.valueOf(((MessageRecord)localObject3).msgtype) }));
              continue;
              if (!localawam.f) {
                continue;
              }
              ((MessageRecord)localObject3).issend = 2;
              ((MessageRecord)localObject3).isread = true;
              if (!(localObject3 instanceof MessageForPoke)) {
                continue;
              }
              if ((((MessageRecord)localObject3).isread) || (((MessageRecord)localObject3).isSend())) {
                continue;
              }
              ((MessageForPoke)localObject3).isPlayed = false;
              ((MessageForPoke)localObject3).initMsg();
              ((MessageRecord)localObject3).vipBubbleID = localawam.jdField_d_of_type_Long;
              ((MessageRecord)localObject3).vipBubbleDiyTextId = localawam.jdField_a_of_type_Int;
              ((MessageRecord)localObject3).vipSubBubbleId = localawam.jdField_b_of_type_Int;
              if (localawam.jdField_b_of_type_Int <= 0) {
                continue;
              }
              ((MessageRecord)localObject3).saveExtInfoToExtStr("bubble_sub_id", String.valueOf(localawam.jdField_b_of_type_Int));
              i2 = awbg.c(paramMsg);
              if (i2 <= 0) {
                continue;
              }
              ((MessageRecord)localObject3).saveExtInfoToExtStr("vip_pendant_diy_id", String.valueOf(i2));
              i2 = awbg.b(paramMsg);
              if (i2 < 0) {
                continue;
              }
              ((MessageRecord)localObject3).saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(i2));
              i2 = awbg.d(paramMsg);
              if (i2 < 0) {
                continue;
              }
              ((MessageRecord)localObject3).saveExtInfoToExtStr("vip_face_id", String.valueOf(i2));
              if (((MessageRecord)localObject3).istroop != 1008) {
                continue;
              }
              try
              {
                if (localMsgHead.public_account_group_send_flag.has()) {
                  ((MessageRecord)localObject3).saveExtInfoToExtStr("public_account_send_flag", String.valueOf(localMsgHead.public_account_group_send_flag.get()));
                }
                if (l1 != -1L) {
                  ((MessageRecord)localObject3).saveExtInfoToExtStr("public_account_msg_id", String.valueOf(l1));
                }
                if ((localObject3 instanceof MessageForStructing))
                {
                  paramawbl = (MessageForStructing)localObject3;
                  if ((paramawbl.structingMsg != null) && (paramawbl.structingMsg.mMsgServiceID == 76)) {
                    ((msg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(171)).a(paramawbl);
                  }
                }
                if (((MessageRecord)localObject3).msgtype == -7005)
                {
                  aqux.a((MessageRecord)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                  continue;
                  if (((MessageRecord)localObject3).msgtype == -2037) {
                    continue;
                  }
                  ((MessageRecord)localObject3).isread = localawam.jdField_a_of_type_Boolean;
                }
              }
              catch (Throwable paramawbl)
              {
                QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeMessage: ", paramawbl);
                continue;
                localArrayList.add(localObject3);
                if (i1 == 1036) {
                  awbg.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i7, l6, i6);
                }
              }
              if (((MessageRecord)localObject3).msgtype != -2039) {
                continue;
              }
              Object localObject4 = (MessageForApollo)localObject3;
              aifg localaifg = (aifg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
              paramawbl = null;
              if (!QLog.isColorLevel()) {
                continue;
              }
              paramawbl = new StringBuilder("decode apollo c2c msg: ").append(", id: ").append(((MessageForApollo)localObject4).mApolloMessage.id).append(", name: ").append(new String(((MessageForApollo)localObject4).mApolloMessage.name)).append(", doubleAction: ").append(((MessageForApollo)localObject4).isDoubleAction()).append(", signTS: ").append(((MessageForApollo)localObject4).signTs);
              int i9 = ((MessageForApollo)localObject4).isSend();
              if (((MessageForApollo)localObject4).mApolloMessage.peer_uin == 0L) {
                continue;
              }
              i2 = 1;
              if (((i2 & i9) == 0) || (((MessageForApollo)localObject4).mApolloMessage.peer_uin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())) {
                continue;
              }
              ApolloBaseInfo localApolloBaseInfo = localaifg.b(((MessageForApollo)localObject4).mApolloMessage.peer_uin + "");
              l2 = ((MessageForApollo)localObject4).mApolloMessage.peer_ts;
              i2 = ((MessageForApollo)localObject4).mApolloMessage.peer_status;
              if ((!QLog.isColorLevel()) || (localApolloBaseInfo == null)) {
                continue;
              }
              paramawbl.append("\n fuin: ").append(localApolloBaseInfo.uin).append(", msg time: ").append(((MessageRecord)localObject3).time).append(", msg ts: ").append(l2).append(", svr ts: ").append(localApolloBaseInfo.apolloServerTS).append(", update time: ").append(localApolloBaseInfo.apolloUpdateTime).append(", status: ").append(i2);
              if ((localApolloBaseInfo == null) || (((MessageRecord)localObject3).time <= localApolloBaseInfo.apolloUpdateTime) || (localApolloBaseInfo.apolloServerTS >= l2)) {
                continue;
              }
              localApolloBaseInfo.apolloStatus = i2;
              localApolloBaseInfo.apolloServerTS = l2;
              localApolloBaseInfo.apolloVipFlag = (((MessageForApollo)localObject4).mApolloMessage.flag >> 30 & 0x1);
              localApolloBaseInfo.apolloUpdateTime = ((MessageRecord)localObject3).time;
              if ((((MessageForApollo)localObject4).isSend()) || (((MessageForApollo)localObject4).signTs <= NetConnInfoCenter.getServerTime()) || (((MessageForApollo)localObject4).signTs == localApolloBaseInfo.apolloSignValidTS)) {
                continue;
              }
              localApolloBaseInfo.apolloSignValidTS = ((MessageForApollo)localObject4).signTs;
              localApolloBaseInfo.apolloSignStr = "";
              i2 = 1;
              if (i2 == 0) {
                continue;
              }
              localaifg.a(localApolloBaseInfo);
              if (!QLog.isColorLevel()) {
                continue;
              }
              paramawbl.append("\n save apollo info fuin: ").append(localApolloBaseInfo.uin).append("-->").append(localApolloBaseInfo.apolloVipFlag).append("|").append(localApolloBaseInfo.apolloStatus).append("|").append(localApolloBaseInfo.apolloLocalTS).append("|").append(localApolloBaseInfo.apolloServerTS).append("|").append(localApolloBaseInfo.apolloUpdateTime).append("|").append(localApolloBaseInfo.apolloSignValidTS);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.msg.C2CMessageProcessor", 2, paramawbl.toString());
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
                continue;
              }
              i2 = localaifg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
              if (((MessageForApollo)localObject4).msgType != 0) {
                continue;
              }
              paramawbl = String.valueOf(((MessageForApollo)localObject4).mApolloMessage.id);
              bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "rev_action", String.valueOf(((MessageForApollo)localObject4).mApolloMessage.peer_uin), 0, ((MessageForApollo)localObject4).msgType, new String[] { paramawbl, Integer.toString(i2), Integer.toString(aifg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)), String.valueOf(System.currentTimeMillis() / 1000L) });
              continue;
              i2 = 0;
              continue;
              localApolloBaseInfo = localaifg.b(((MessageForApollo)localObject4).senderuin);
              l2 = ((MessageForApollo)localObject4).mApolloMessage.sender_ts;
              i2 = ((MessageForApollo)localObject4).mApolloMessage.sender_status;
              continue;
              if ((localApolloBaseInfo == null) || (((MessageForApollo)localObject4).isSend()) || (((MessageForApollo)localObject4).signTs <= NetConnInfoCenter.getServerTime()) || (((MessageForApollo)localObject4).signTs == localApolloBaseInfo.apolloSignValidTS)) {
                continue;
              }
              localApolloBaseInfo.apolloSignValidTS = ((MessageForApollo)localObject4).signTs;
              localApolloBaseInfo.apolloSignStr = "";
              i2 = 1;
              continue;
              if (((MessageForApollo)localObject4).msgType != 2) {
                continue;
              }
              paramawbl = "" + ((MessageForApollo)localObject4).gameId;
              continue;
              if ((i1 != 1008) || (!paramMsg.msg_body.has())) {
                continue;
              }
              paramMsg = (im_msg_body.MsgBody)paramMsg.msg_body.get();
              if (!paramMsg.rich_text.has()) {
                continue;
              }
              paramMsg = (im_msg_body.RichText)paramMsg.rich_text.get();
              if (!paramMsg.elems.has()) {
                continue;
              }
              paramMsg = paramMsg.elems.get().iterator();
              if (!paramMsg.hasNext()) {
                continue;
              }
              paramawbl = (im_msg_body.Elem)paramMsg.next();
              if (!paramawbl.pub_acc_info.has()) {
                continue;
              }
              n = paramawbl.pub_acc_info.uint32_is_inter_num.get();
              paramMsg = paramawbl.pub_acc_info.string_msg_template_id.get();
              if (n == 0) {
                continue;
              }
              paramawbl = localArrayList.iterator();
              if (!paramawbl.hasNext()) {
                continue;
              }
              ((MessageRecord)paramawbl.next()).saveExtInfoToExtStr("inter_num", String.valueOf(n));
              continue;
              paramawbl = localArrayList.iterator();
              if (!paramawbl.hasNext()) {
                continue;
              }
              ((MessageRecord)paramawbl.next()).saveExtInfoToExtStr("msg_template_id", paramMsg);
              continue;
              befa.a().f(System.currentTimeMillis() - l4);
              i1 = 0;
              paramMsg = localArrayList.iterator();
              n = 0;
              if (!paramMsg.hasNext()) {
                continue;
              }
              paramawbl = (MessageRecord)paramMsg.next();
              i1 = paramawbl.istroop;
              if (paramawbl.isread) {
                continue;
              }
              n += 1;
              continue;
              awqe.a(0, 1, i1, n);
              return localArrayList;
              continue;
              paramawbl = "";
              continue;
              i2 = 0;
              continue;
              continue;
              continue;
              n = 0;
              continue;
            }
            i2 += 1;
          }
          l1 = ((Long)paramawbl.second).longValue();
          break;
          localawam.f = false;
          break label424;
          label1143:
          paramawbl = (Serializable)paramawbl.first;
          break label626;
          if (localawam.jdField_e_of_type_Long != 0L) {
            break label687;
          }
          QLog.e("Q.msg.C2CMessageProcessor", 1, "<---decodeSinglePBMsg_C2C : decode msg: frienduin=0");
          break label687;
          if ((((awbm)localObject1).jdField_a_of_type_Int != 1000) && (((awbm)localObject1).jdField_a_of_type_Int != 1020))
          {
            n = i1;
            if (((awbm)localObject1).jdField_a_of_type_Int != 1004) {
              break label752;
            }
          }
          localawam.jdField_b_of_type_Long = ((awbm)localObject1).jdField_b_of_type_Long;
          n = i1;
          break label752;
          return localArrayList;
          n = 1034;
          break label821;
          if (paramMsg.appshare_info.has())
          {
            awbg.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramawbl, paramMsg, 0L, 0L, localawam.jdField_d_of_type_Boolean);
            n = 0;
          }
          else
          {
            if ((awbk.c(i6)) && (localMsgHead.c2c_cmd.has())) {}
            switch (i2)
            {
            default: 
              n = 0;
              break;
            case 169: 
            case 241: 
            case 242: 
            case 243: 
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
              l1 = localawam.jdField_e_of_type_Long;
              bool1 = localawam.jdField_a_of_type_Boolean;
              bool2 = localawam.jdField_b_of_type_Boolean;
              if (l5 == localawam.jdField_a_of_type_Long) {}
              for (i9 = 1;; i9 = 0)
              {
                awbg.a((MessageHandler)localObject1, paramawbl, i2, paramMsg, l1, bool1, bool2, i9, localawam.jdField_d_of_type_Long, localawam.jdField_d_of_type_Boolean, localawam.jdField_a_of_type_Int);
                n = 0;
                break;
              }
            case 11: 
            case 175: 
              awbg.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramawbl, paramMsg, localawam.jdField_e_of_type_Long, localawam.jdField_b_of_type_Boolean, localawam.jdField_a_of_type_Boolean, localawam.jdField_d_of_type_Boolean);
              n = 0;
              break;
            case 193: 
              n = 0;
              break;
            case 129: 
            case 131: 
            case 133: 
              awbg.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localawam.jdField_e_of_type_Long, localawam.jdField_a_of_type_Boolean, localawam.jdField_b_of_type_Boolean, localawam.jdField_d_of_type_Long, localawam.jdField_a_of_type_Int);
              n = 0;
              continue;
              if (i6 == 208)
              {
                awbg.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramawbl, paramMsg);
                n = 0;
              }
              else
              {
                if (i6 == 193)
                {
                  if (!localawam.jdField_d_of_type_Boolean)
                  {
                    awbg.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localawam);
                    n = 0;
                  }
                }
                else
                {
                  if (i6 == 734)
                  {
                    awbg.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localawam);
                    n = 0;
                    continue;
                  }
                  if (i6 == 562)
                  {
                    awbg.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localawam);
                    n = 0;
                    continue;
                  }
                  if (i6 == 519)
                  {
                    if ((!localawam.jdField_d_of_type_Boolean) && (kst.jdField_a_of_type_Boolean))
                    {
                      awbg.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localawam.jdField_a_of_type_Boolean, localawam.f);
                      n = 0;
                    }
                  }
                  else
                  {
                    if (SystemMsg.isSystemMessage(i6))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.systemmsg.", 2, "friend system msg notify");
                      }
                      n = 0;
                      if ((i6 == 188) || (i6 == 189)) {
                        n = 1;
                      }
                      if ((!localawam.jdField_c_of_type_Boolean) && (n == 0)) {
                        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(2);
                      }
                      localawam.jdField_e_of_type_Long = 9998L;
                      awbg.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localawam.jdField_a_of_type_Boolean, localawam.f, localawam.jdField_d_of_type_Boolean, i7);
                      awbg.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i7, l6, i6);
                      return localArrayList;
                    }
                    if (a(i6))
                    {
                      a(paramawbl, paramMsg, localawam.jdField_d_of_type_Boolean);
                      n = 0;
                      continue;
                    }
                    if (732 == i6)
                    {
                      a(paramawbl, paramMsg, i7, l5, l6, i6, localawam.jdField_d_of_type_Boolean);
                      n = 0;
                      continue;
                    }
                    if (524 == i6)
                    {
                      if ((paramawbl == null) || (paramMsg == null) || (!paramMsg.msg_body.has()) || (!paramMsg.msg_body.msg_content.has())) {
                        return localArrayList;
                      }
                      localObject1 = paramMsg.msg_body.msg_content.get().toByteArray();
                      bakz.a((byte[])localObject1, 0);
                      n = localObject1[4];
                      if (n == 25) {
                        if (!localawam.jdField_d_of_type_Boolean) {
                          akax.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte[])localObject1, 5, null, false);
                        }
                      }
                      for (;;)
                      {
                        n = 0;
                        break;
                        if (n == 35)
                        {
                          QLog.i("ApolloPushManager", 1, "[discuss.OffLine]");
                          if (!localawam.jdField_d_of_type_Boolean) {
                            akax.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte[])localObject1, 5, null, false);
                          }
                        }
                      }
                    }
                    if (SystemMsg.isTroopSystemMessage(i6))
                    {
                      n = 0;
                      if ((i6 == 85) || (i6 == 36)) {
                        n = 1;
                      }
                      if ((!localawam.jdField_c_of_type_Boolean) && (n == 0)) {
                        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(3, 1, false);
                      }
                      localawam.jdField_e_of_type_Long = 9998L;
                      awbg.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localawam.jdField_a_of_type_Boolean, localawam.f, localawam.jdField_d_of_type_Boolean);
                      if (n == 0) {
                        axcz.a().a(l5, l3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                      }
                      return localArrayList;
                    }
                    if (i6 == 528)
                    {
                      if (!localawam.jdField_d_of_type_Boolean)
                      {
                        awbg.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, localawam.jdField_a_of_type_Long, paramMsg, localawam.h, localawam.jdField_d_of_type_Boolean);
                        n = 0;
                      }
                    }
                    else
                    {
                      if (i6 == 529)
                      {
                        if (((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.has())
                        {
                          i1 = 1;
                          localObject1 = awbg.a(paramMsg);
                          if (((awbm)localObject1).jdField_a_of_type_Int == -1)
                          {
                            n = 0;
                            if (n == 0) {
                              break label5359;
                            }
                            awbg.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramawbl, paramMsg, (awbm)localObject1, localawam);
                            n = ((awbm)localObject1).jdField_a_of_type_Int;
                            if ((paramawbl.size() <= 0) || (!alyc.a((MessageRecord)paramawbl.get(0)))) {
                              break label5356;
                            }
                            if (!((MessageRecord)paramawbl.get(0)).isSelfConfessor()) {
                              break label2471;
                            }
                            n = 1033;
                            ((awbm)localObject1).jdField_a_of_type_Int = n;
                            n = ((awbm)localObject1).jdField_a_of_type_Int;
                            i1 = n;
                            if (n == 1006)
                            {
                              QLog.e("Q.msg.C2CMessageProcessor", 1, "decodeMessage FileMsg, tempInfo has Uin [" + ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).from_phone.has() + "]");
                              i1 = n;
                            }
                            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
                            l1 = localawam.jdField_e_of_type_Long;
                            bool1 = localawam.jdField_a_of_type_Boolean;
                            bool2 = localawam.jdField_b_of_type_Boolean;
                            if (l5 != localawam.jdField_a_of_type_Long) {
                              break label2627;
                            }
                          }
                        }
                        for (i9 = 1;; i9 = 0)
                        {
                          awbg.a((MessageHandler)localObject1, paramawbl, paramMsg, l1, bool1, bool2, i9, localawam.jdField_d_of_type_Long, localawam.jdField_d_of_type_Boolean, localawam.jdField_a_of_type_Int);
                          n = 0;
                          break;
                          if ((((awbm)localObject1).jdField_a_of_type_Int != 1000) && (((awbm)localObject1).jdField_a_of_type_Int != 1020))
                          {
                            n = i1;
                            if (((awbm)localObject1).jdField_a_of_type_Int != 1004) {
                              break label2200;
                            }
                          }
                          localawam.jdField_b_of_type_Long = ((awbm)localObject1).jdField_b_of_type_Long;
                          n = i1;
                          break label2200;
                          n = 1034;
                          break label2262;
                          localObject1 = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                          if (mnz.a(BaseApplicationImpl.getContext(), String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get())))
                          {
                            i1 = n;
                            if (((ajjj)localObject1).b(String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get()))) {
                              break label2343;
                            }
                            i1 = 1025;
                            break label2343;
                          }
                          i1 = n;
                          if (!mnz.a(BaseApplicationImpl.getContext(), String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get()))) {
                            break label2343;
                          }
                          i1 = n;
                          if (((ajjj)localObject1).b(String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get()))) {
                            break label2343;
                          }
                          i1 = 1025;
                          break label2343;
                        }
                      }
                      if (i6 == 38)
                      {
                        localObject1 = String.valueOf(azvx.a(paramMsg.msg_body.msg_content.get().toByteArray()));
                        localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                        if ((localObject2 != null) && (((TroopManager)localObject2).b((String)localObject1) == null))
                        {
                          localObject3 = new TroopInfo();
                          ((TroopInfo)localObject3).troopuin = ((String)localObject1);
                          ((TroopInfo)localObject3).troopcode = ((String)localObject1);
                          ((TroopInfo)localObject3).dwAdditionalFlag = 1L;
                          ((TroopManager)localObject2).b((TroopInfo)localObject3);
                        }
                        localObject2 = (ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
                        if (localObject2 != null) {
                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(getClass()).postDelayed(new C2CMessageProcessor.1(this, (ajtg)localObject2, (String)localObject1), 2000L);
                        }
                        awbg.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i7, l6, i6);
                      }
                    }
                  }
                }
                n = 0;
              }
              break;
            }
          }
        }
        l1 = l3;
        localObject2 = paramawbl.iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label5065;
          }
          localObject3 = (MessageRecord)((Iterator)localObject2).next();
          if ((localObject3 != null) && ((localawam.jdField_b_of_type_Long != 3338705755L) || (!rtr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) && ((localawam.jdField_b_of_type_Long != 2171946401L) || (!obz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))))
          {
            if (localawam.jdField_b_of_type_Long == 2171946401L) {
              rtr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
            }
            if (((i1 != 1025) && (i1 != 1024)) || (((MessageRecord)localObject3).msgtype != -1000) || (!((MessageRecord)localObject3).msg.startsWith("default:SigT=")))
            {
              if (akbm.a(i1) != 1032) {
                break;
              }
              localObject1 = null;
              paramawbl = (awbl)localObject1;
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
              {
                localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                paramawbl = (awbl)localObject1;
                if (localObject4 != null) {
                  paramawbl = ((awao)localObject4).a(String.valueOf(localawam.jdField_e_of_type_Long), String.valueOf(localawam.jdField_a_of_type_Long));
                }
              }
              awbg.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i7, l6, i6, paramawbl);
              if (i1 != 1032) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.i("Q.msg.C2CMessageProcessor", 2, String.format("decodeMessage discard confess msg senderUin:%s msgSeq:%d msgType:%d", new Object[] { Long.toString(l5), Integer.valueOf(i7), Integer.valueOf(i6) }));
              }
            }
          }
        }
      }
      label1154:
      label1176:
      label1228:
      label1231:
      label1238:
      label2262:
      label5356:
      i3 = 0;
      label2200:
      label2343:
      label2627:
      label5065:
      i4 = 0;
      label2471:
      i5 = 0;
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
  
  public void a(ArrayList<MessageRecord> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord.msgtype == -3006) || (localMessageRecord.msgtype == -5004))
      {
        PAMessage localPAMessage = acnu.a(localMessageRecord);
        if ((localPAMessage != null) && (localPAMessage.mMsgId > 0L)) {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localMessageRecord.frienduin, "mp_msg_sys_15", "msg_get", 0, 1, 0, Long.toString(localPAMessage.mMsgId), "", "", "");
        }
      }
      if ((localMessageRecord.mQidianMasterUin != 0L) && (!TextUtils.isEmpty(localMessageRecord.mQidianTipText)) && (localMessageRecord.mIsShowQidianTips == 1)) {
        ThreadManager.executeOnSubThread(new C2CMessageProcessor.5(this, localMessageRecord));
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramArrayList);
  }
  
  public void a(ArrayList<MessageRecord> paramArrayList, msg_comm.Msg paramMsg, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramMsg == null) || (!paramMsg.msg_body.has()) || (!paramMsg.msg_body.msg_content.has())) {}
    Object localObject;
    int n;
    do
    {
      do
      {
        do
        {
          byte[] arrayOfByte1;
          do
          {
            do
            {
              return;
              arrayOfByte1 = paramMsg.msg_body.msg_content.get().toByteArray();
              localObject = new byte[arrayOfByte1.length];
              bakz.a((byte[])localObject, 0, arrayOfByte1, 0, localObject.length);
            } while (localObject.length < 5);
            n = localObject[4];
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "<---hotchat and opentroop push  groupCode:" + bakz.a(arrayOfByte1, 0) + " subType:" + n);
            }
            if ((n != 12) && (n != 14)) {
              break;
            }
          } while (!((azjh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a((byte[])localObject, paramInt1));
          awbg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramLong1, paramInt1, paramLong2, paramInt2);
          return;
          if ((n != 16) && (n != 17) && (n != 20)) {
            break;
          }
          localObject = new akap(this);
          if (arrayOfByte1.length > 7)
          {
            azlf localazlf = (azlf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(81);
            byte[] arrayOfByte2 = new byte[arrayOfByte1.length - 7];
            bakz.a(arrayOfByte2, 0, arrayOfByte1, 7, arrayOfByte2.length);
            paramArrayList.add(localazlf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, arrayOfByte2, paramInt1, paramMsg.msg_head.msg_time.get(), true, paramBoolean, (akap)localObject));
          }
        } while (!((akap)localObject).jdField_a_of_type_Boolean);
        awbg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramLong1, paramInt1, paramLong2, paramInt2);
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.C2CMessageProcessor", 2, String.format("handle0x2dcMessage==>sendDelMsgReqToServer fromUin:%d, seq:%d, msgUid:%d, msgType:%d", new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) }));
      return;
    } while (n != 3);
    a((byte[])localObject);
  }
  
  /* Error */
  public void a(ArrayList<MessageRecord> paramArrayList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 132	java/util/ArrayList:size	()I
    //   8: ifne +4 -> 12
    //   11: return
    //   12: invokestatic 2489	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   15: aload_0
    //   16: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: invokevirtual 75	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   22: invokestatic 2492	com/tencent/mobileqq/activity/UserguideActivity:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   25: ifne -14 -> 11
    //   28: invokestatic 2489	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   31: invokevirtual 2493	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   34: aload_0
    //   35: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   38: invokestatic 2498	azyg:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)Z
    //   41: ifeq -30 -> 11
    //   44: aload_1
    //   45: invokevirtual 248	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   48: astore 7
    //   50: aload 7
    //   52: invokeinterface 253 1 0
    //   57: ifeq +1587 -> 1644
    //   60: aload 7
    //   62: invokeinterface 257 1 0
    //   67: checkcast 259	com/tencent/mobileqq/data/MessageRecord
    //   70: astore 8
    //   72: aload 8
    //   74: getfield 273	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   77: invokestatic 2108	akbm:r	(I)Z
    //   80: ifeq -30 -> 50
    //   83: aload 8
    //   85: invokestatic 2499	akbm:d	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   88: ifeq -38 -> 50
    //   91: aload_0
    //   92: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   95: aload 8
    //   97: invokestatic 2502	akbm:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   100: ifne -50 -> 50
    //   103: aload 8
    //   105: invokevirtual 2186	com/tencent/mobileqq/data/MessageRecord:isSend	()Z
    //   108: ifne -58 -> 50
    //   111: aload 8
    //   113: getfield 1309	com/tencent/mobileqq/data/MessageRecord:isread	Z
    //   116: ifne -66 -> 50
    //   119: iconst_1
    //   120: istore_3
    //   121: iload_3
    //   122: ifeq -111 -> 11
    //   125: aload_0
    //   126: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   129: bipush 51
    //   131: invokevirtual 330	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   134: checkcast 964	ajjj
    //   137: aload_0
    //   138: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   141: invokevirtual 75	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   144: invokevirtual 2505	ajjj:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   147: astore 7
    //   149: aload_0
    //   150: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   153: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   156: astore 10
    //   158: aload 7
    //   160: ifnonnull +566 -> 726
    //   163: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +1472 -> 1638
    //   169: ldc 164
    //   171: iconst_2
    //   172: ldc_w 2507
    //   175: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: iconst_1
    //   179: istore 4
    //   181: aload_0
    //   182: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   185: bipush 106
    //   187: invokevirtual 330	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   190: checkcast 2509	ascz
    //   193: invokevirtual 2510	ascz:a	()Z
    //   196: istore 6
    //   198: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +42 -> 243
    //   204: ldc_w 2512
    //   207: iconst_2
    //   208: new 109	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 2514
    //   218: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: iload 4
    //   223: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: ldc_w 2516
    //   229: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: iload 6
    //   234: invokevirtual 781	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   237: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload_0
    //   244: getfield 2517	akak:jdField_a_of_type_Boolean	Z
    //   247: ifne +293 -> 540
    //   250: invokestatic 2522	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   253: getstatic 2528	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:OneyWayDateMsgNotifyCfg	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   256: invokevirtual 2530	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   259: invokevirtual 2532	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   262: astore 8
    //   264: invokestatic 2522	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   267: getstatic 2535	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:OneyWayLBSFriendMsgNotifyCfg	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   270: invokevirtual 2530	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   273: invokevirtual 2532	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   276: astore 7
    //   278: aload 8
    //   280: ldc_w 2537
    //   283: invokevirtual 2541	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   286: astore 8
    //   288: aload 7
    //   290: ldc_w 2537
    //   293: invokevirtual 2541	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   319: invokestatic 1566	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   322: putfield 37	akak:d	I
    //   325: aload_0
    //   326: aload 8
    //   328: iconst_1
    //   329: aaload
    //   330: invokestatic 1566	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   333: putfield 39	akak:e	I
    //   336: aload_0
    //   337: aload 8
    //   339: iconst_2
    //   340: aaload
    //   341: invokestatic 1566	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   344: putfield 41	akak:f	I
    //   347: aload_0
    //   348: aload 8
    //   350: iconst_3
    //   351: aaload
    //   352: invokestatic 1566	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   355: putfield 43	akak:g	I
    //   358: aload_0
    //   359: aload 7
    //   361: iconst_0
    //   362: aaload
    //   363: invokestatic 1566	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   366: putfield 45	akak:i	I
    //   369: aload_0
    //   370: aload 7
    //   372: iconst_1
    //   373: aaload
    //   374: invokestatic 1566	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   377: putfield 47	akak:j	I
    //   380: aload_0
    //   381: aload 7
    //   383: iconst_2
    //   384: aaload
    //   385: invokestatic 1566	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   388: putfield 49	akak:k	I
    //   391: aload_0
    //   392: aload 7
    //   394: iconst_3
    //   395: aaload
    //   396: invokestatic 1566	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   399: putfield 51	akak:l	I
    //   402: invokestatic 2544	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   405: ifeq +130 -> 535
    //   408: ldc_w 2546
    //   411: iconst_4
    //   412: new 109	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   419: ldc_w 2548
    //   422: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload_0
    //   426: getfield 37	akak:d	I
    //   429: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   432: ldc_w 2315
    //   435: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload_0
    //   439: getfield 39	akak:e	I
    //   442: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: ldc_w 2315
    //   448: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload_0
    //   452: getfield 41	akak:f	I
    //   455: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   458: ldc_w 2315
    //   461: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload_0
    //   465: getfield 43	akak:g	I
    //   468: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   471: ldc_w 2550
    //   474: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload_0
    //   478: getfield 45	akak:i	I
    //   481: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   484: ldc_w 2315
    //   487: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload_0
    //   491: getfield 47	akak:j	I
    //   494: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   497: ldc_w 2315
    //   500: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: aload_0
    //   504: getfield 49	akak:k	I
    //   507: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   510: ldc_w 2315
    //   513: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_0
    //   517: getfield 51	akak:l	I
    //   520: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   523: ldc_w 2007
    //   526: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   535: aload_0
    //   536: iconst_1
    //   537: putfield 2517	akak:jdField_a_of_type_Boolean	Z
    //   540: invokestatic 2489	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   543: new 109	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   550: aload_0
    //   551: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   554: invokevirtual 75	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   557: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: ldc_w 2552
    //   563: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: iconst_0
    //   570: invokevirtual 2556	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   573: astore 11
    //   575: ldc_w 397
    //   578: astore 8
    //   580: ldc_w 397
    //   583: astore 9
    //   585: aload 8
    //   587: astore 7
    //   589: aload_0
    //   590: getfield 53	akak:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   593: ifnonnull +145 -> 738
    //   596: aload_0
    //   597: monitorenter
    //   598: aload 8
    //   600: astore 7
    //   602: aload_0
    //   603: getfield 53	akak:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   606: ifnonnull +130 -> 736
    //   609: aload_0
    //   610: new 28	java/util/HashSet
    //   613: dup
    //   614: invokespecial 31	java/util/HashSet:<init>	()V
    //   617: putfield 53	akak:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   620: aload 11
    //   622: new 109	java/lang/StringBuilder
    //   625: dup
    //   626: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   629: aload_0
    //   630: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   633: invokevirtual 75	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   636: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: ldc_w 2558
    //   642: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: ldc_w 397
    //   651: invokeinterface 2563 3 0
    //   656: astore 8
    //   658: aload 8
    //   660: ldc_w 2537
    //   663: invokevirtual 2541	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   693: invokevirtual 698	java/lang/String:length	()I
    //   696: ifle +23 -> 719
    //   699: aload 7
    //   701: invokestatic 121	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   704: lconst_0
    //   705: lcmp
    //   706: ifle +13 -> 719
    //   709: aload_0
    //   710: getfield 53	akak:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   713: aload 7
    //   715: invokevirtual 2564	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   718: pop
    //   719: iload_3
    //   720: iconst_1
    //   721: iadd
    //   722: istore_3
    //   723: goto -48 -> 675
    //   726: aload 7
    //   728: getfield 2569	com/tencent/mobileqq/data/Card:shGender	S
    //   731: istore 4
    //   733: goto -552 -> 181
    //   736: aload_0
    //   737: monitorexit
    //   738: aload 9
    //   740: astore 8
    //   742: aload_0
    //   743: getfield 55	akak:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   746: ifnonnull +140 -> 886
    //   749: aload_0
    //   750: monitorenter
    //   751: aload 9
    //   753: astore 8
    //   755: aload_0
    //   756: getfield 55	akak:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   759: ifnonnull +125 -> 884
    //   762: aload_0
    //   763: new 28	java/util/HashSet
    //   766: dup
    //   767: invokespecial 31	java/util/HashSet:<init>	()V
    //   770: putfield 55	akak:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   773: aload 11
    //   775: new 109	java/lang/StringBuilder
    //   778: dup
    //   779: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   782: aload_0
    //   783: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   786: invokevirtual 75	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   789: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: ldc_w 2571
    //   795: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   801: ldc_w 397
    //   804: invokeinterface 2563 3 0
    //   809: astore 9
    //   811: aload 9
    //   813: ldc_w 2537
    //   816: invokevirtual 2541	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   846: invokevirtual 698	java/lang/String:length	()I
    //   849: ifle +23 -> 872
    //   852: aload 8
    //   854: invokestatic 121	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   857: lconst_0
    //   858: lcmp
    //   859: ifle +13 -> 872
    //   862: aload_0
    //   863: getfield 55	akak:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   866: aload 8
    //   868: invokevirtual 2564	java/util/HashSet:add	(Ljava/lang/Object;)Z
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
    //   887: invokevirtual 248	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   890: astore 12
    //   892: aload 8
    //   894: astore_1
    //   895: aload 12
    //   897: invokeinterface 253 1 0
    //   902: ifeq -891 -> 11
    //   905: aload 12
    //   907: invokeinterface 257 1 0
    //   912: checkcast 259	com/tencent/mobileqq/data/MessageRecord
    //   915: astore 13
    //   917: aload_1
    //   918: astore 9
    //   920: aload_0
    //   921: aload 13
    //   923: invokevirtual 2572	akak:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   926: ifeq +641 -> 1567
    //   929: aload_1
    //   930: astore 9
    //   932: aload 10
    //   934: ifnull +633 -> 1567
    //   937: aload 13
    //   939: getfield 273	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   942: sipush 1010
    //   945: if_icmpne +340 -> 1285
    //   948: aload 7
    //   950: astore 8
    //   952: aload_0
    //   953: getfield 53	akak:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   956: aload 13
    //   958: getfield 315	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   961: invokevirtual 2573	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   964: ifne +89 -> 1053
    //   967: aload_0
    //   968: getfield 53	akak:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   971: aload 13
    //   973: getfield 315	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   976: invokevirtual 2564	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   979: pop
    //   980: aload 7
    //   982: invokevirtual 698	java/lang/String:length	()I
    //   985: ifne +237 -> 1222
    //   988: aload 13
    //   990: getfield 315	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   993: astore 7
    //   995: aload 11
    //   997: invokeinterface 2577 1 0
    //   1002: new 109	java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   1009: aload_0
    //   1010: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1013: invokevirtual 75	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1016: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: ldc_w 2558
    //   1022: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1028: aload 7
    //   1030: invokeinterface 2582 3 0
    //   1035: pop
    //   1036: aload 11
    //   1038: invokeinterface 2577 1 0
    //   1043: invokeinterface 2585 1 0
    //   1048: pop
    //   1049: aload 7
    //   1051: astore 8
    //   1053: iload 4
    //   1055: ifne +209 -> 1264
    //   1058: iload 6
    //   1060: ifeq +196 -> 1256
    //   1063: aload_0
    //   1064: getfield 41	akak:f	I
    //   1067: istore_3
    //   1068: aload_0
    //   1069: aload_0
    //   1070: getfield 53	akak:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1073: invokevirtual 2586	java/util/HashSet:size	()I
    //   1076: putfield 2588	akak:h	I
    //   1079: aload_0
    //   1080: getfield 2588	akak:h	I
    //   1083: iload_3
    //   1084: irem
    //   1085: ifne +113 -> 1198
    //   1088: aload_0
    //   1089: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1092: aload 13
    //   1094: iload_2
    //   1095: invokevirtual 2589	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/MessageRecord;Z)V
    //   1098: aload_0
    //   1099: getfield 53	akak:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1102: invokevirtual 2590	java/util/HashSet:clear	()V
    //   1105: aload 11
    //   1107: invokeinterface 2577 1 0
    //   1112: new 109	java/lang/StringBuilder
    //   1115: dup
    //   1116: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   1119: aload_0
    //   1120: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1123: invokevirtual 75	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1126: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: ldc_w 2558
    //   1132: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1138: invokeinterface 2593 2 0
    //   1143: pop
    //   1144: aload 11
    //   1146: invokeinterface 2577 1 0
    //   1151: invokeinterface 2585 1 0
    //   1156: pop
    //   1157: iload 6
    //   1159: ifeq +39 -> 1198
    //   1162: aload_0
    //   1163: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1166: ldc_w 425
    //   1169: ldc_w 397
    //   1172: ldc_w 397
    //   1175: ldc_w 2595
    //   1178: ldc_w 2595
    //   1181: iconst_0
    //   1182: iconst_0
    //   1183: ldc_w 397
    //   1186: ldc_w 397
    //   1189: ldc_w 397
    //   1192: ldc_w 397
    //   1195: invokestatic 432	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
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
    //   1222: new 109	java/lang/StringBuilder
    //   1225: dup
    //   1226: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   1229: aload 7
    //   1231: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: ldc_w 2315
    //   1237: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: aload 13
    //   1242: getfield 315	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1245: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1251: astore 7
    //   1253: goto -258 -> 995
    //   1256: aload_0
    //   1257: getfield 37	akak:d	I
    //   1260: istore_3
    //   1261: goto -193 -> 1068
    //   1264: iload 6
    //   1266: ifeq +11 -> 1277
    //   1269: aload_0
    //   1270: getfield 43	akak:g	I
    //   1273: istore_3
    //   1274: goto -206 -> 1068
    //   1277: aload_0
    //   1278: getfield 39	akak:e	I
    //   1281: istore_3
    //   1282: goto -214 -> 1068
    //   1285: aload 13
    //   1287: getfield 273	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   1290: sipush 1001
    //   1293: if_icmpeq +17 -> 1310
    //   1296: aload_1
    //   1297: astore 9
    //   1299: aload 13
    //   1301: getfield 273	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   1304: sipush 10002
    //   1307: if_icmpne +260 -> 1567
    //   1310: aload_1
    //   1311: astore 8
    //   1313: aload_0
    //   1314: getfield 55	akak:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1317: aload 13
    //   1319: getfield 315	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1322: invokevirtual 2573	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   1325: ifne +85 -> 1410
    //   1328: aload_0
    //   1329: getfield 55	akak:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1332: aload 13
    //   1334: getfield 315	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1337: invokevirtual 2564	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1340: pop
    //   1341: aload_1
    //   1342: invokevirtual 698	java/lang/String:length	()I
    //   1345: ifne +232 -> 1577
    //   1348: aload 13
    //   1350: getfield 315	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1353: astore_1
    //   1354: aload 11
    //   1356: invokeinterface 2577 1 0
    //   1361: new 109	java/lang/StringBuilder
    //   1364: dup
    //   1365: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   1368: aload_0
    //   1369: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1372: invokevirtual 75	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1375: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: ldc_w 2571
    //   1381: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1384: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1387: aload_1
    //   1388: invokeinterface 2582 3 0
    //   1393: pop
    //   1394: aload 11
    //   1396: invokeinterface 2577 1 0
    //   1401: invokeinterface 2585 1 0
    //   1406: pop
    //   1407: aload_1
    //   1408: astore 8
    //   1410: iload 4
    //   1412: ifne +205 -> 1617
    //   1415: iload 6
    //   1417: ifeq +192 -> 1609
    //   1420: aload_0
    //   1421: getfield 49	akak:k	I
    //   1424: istore_3
    //   1425: aload_0
    //   1426: aload_0
    //   1427: getfield 55	akak:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1430: invokevirtual 2586	java/util/HashSet:size	()I
    //   1433: putfield 2597	akak:m	I
    //   1436: aload 8
    //   1438: astore 9
    //   1440: aload_0
    //   1441: getfield 2597	akak:m	I
    //   1444: iload_3
    //   1445: irem
    //   1446: ifne +121 -> 1567
    //   1449: aload_0
    //   1450: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1453: aload 13
    //   1455: iload_2
    //   1456: invokevirtual 2589	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/MessageRecord;Z)V
    //   1459: aload_0
    //   1460: getfield 55	akak:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1463: invokevirtual 2590	java/util/HashSet:clear	()V
    //   1466: aload 11
    //   1468: invokeinterface 2577 1 0
    //   1473: new 109	java/lang/StringBuilder
    //   1476: dup
    //   1477: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   1480: aload_0
    //   1481: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1484: invokevirtual 75	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1487: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: ldc_w 2571
    //   1493: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1496: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1499: invokeinterface 2593 2 0
    //   1504: pop
    //   1505: aload 11
    //   1507: invokeinterface 2577 1 0
    //   1512: invokeinterface 2585 1 0
    //   1517: pop
    //   1518: aload 8
    //   1520: astore 9
    //   1522: iload 6
    //   1524: ifeq +43 -> 1567
    //   1527: aload_0
    //   1528: getfield 65	akak:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1531: ldc_w 425
    //   1534: ldc_w 397
    //   1537: ldc_w 397
    //   1540: ldc_w 2595
    //   1543: ldc_w 2595
    //   1546: iconst_0
    //   1547: iconst_0
    //   1548: ldc_w 397
    //   1551: ldc_w 397
    //   1554: ldc_w 397
    //   1557: ldc_w 397
    //   1560: invokestatic 432	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1563: aload 8
    //   1565: astore 9
    //   1567: aload 7
    //   1569: astore_1
    //   1570: aload 9
    //   1572: astore 7
    //   1574: goto -370 -> 1204
    //   1577: new 109	java/lang/StringBuilder
    //   1580: dup
    //   1581: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   1584: aload_1
    //   1585: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1588: ldc_w 2315
    //   1591: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1594: aload 13
    //   1596: getfield 315	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1599: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1605: astore_1
    //   1606: goto -252 -> 1354
    //   1609: aload_0
    //   1610: getfield 45	akak:i	I
    //   1613: istore_3
    //   1614: goto -189 -> 1425
    //   1617: iload 6
    //   1619: ifeq +11 -> 1630
    //   1622: aload_0
    //   1623: getfield 51	akak:l	I
    //   1626: istore_3
    //   1627: goto -202 -> 1425
    //   1630: aload_0
    //   1631: getfield 47	akak:j	I
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
    //   0	1649	0	this	akak
    //   0	1649	1	paramArrayList	ArrayList<MessageRecord>
    //   0	1649	2	paramBoolean	boolean
    //   120	1526	3	n	int
    //   179	1461	4	i1	int
    //   671	165	5	i2	int
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
  
  public void a(List<MessageRecord> paramList, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    paramList = (msg_comm.MsgHead)paramMsg.msg_head.get();
    paramMsg = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
    long l1 = azzz.a(paramMsg, 0);
    int n = paramMsg[4];
    String str = String.valueOf(azzz.a(paramMsg, 5));
    n = paramMsg[9];
    long l2 = azzz.a(paramMsg, 10);
    int i1 = paramMsg[14];
    try
    {
      new String(paramMsg, 15, i1, "GBK");
      if (!paramBoolean)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, n, str, String.valueOf(l2), l1, paramList.msg_time.get(), paramList.msg_seq.get(), paramList);
        ((ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(l1 + "", str, paramList.auth_nick.get());
        paramMsg = new ArrayList();
        paramMsg.add(new Pair(Long.valueOf(paramList.from_uin.get()), Long.valueOf(paramList.msg_time.get())));
        ((akak)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("c2c_processor")).b(paramMsg);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        new String(paramMsg, 15, i1);
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 33;
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop != 1010) && (paramMessageRecord.istroop != 1001) && (paramMessageRecord.istroop != 10002)) {}
    while (((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) || (((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002)) && ((paramMessageRecord.msgtype == -3001) || (!akbm.d(paramMessageRecord)) || (akbm.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord))))) {
      return false;
    }
    return true;
  }
  
  protected boolean a(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localTroopManager == null) {
      return false;
    }
    paramString = localTroopManager.b(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.isAdmin();
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
    } while ((localMessageRecord.isSend()) || (localMessageRecord.isread) || ((akbm.d(localMessageRecord)) && (!akbm.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord))) || (FriendsStatusUtil.a(localMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
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
  
  public void b(ArrayList<Pair<Long, Long>> paramArrayList)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akak
 * JD-Core Version:    0.7.0.1
 */