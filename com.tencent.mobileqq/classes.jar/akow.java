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
import com.tencent.mobileqq.app.message.C2CMessageProcessor.2;
import com.tencent.mobileqq.app.message.C2CMessageProcessor.5;
import com.tencent.mobileqq.app.message.C2CMessageProcessor.7;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
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
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
import msf.msgsvc.msg_svc.PbGetMsgResp;
import msf.msgsvc.msg_svc.PbGetOneDayRoamMsgResp;
import msf.msgsvc.msg_svc.PbGetRoamMsgResp;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.PubAccInfo;
import tencent.im.msg.im_msg_body.RichText;

public class akow
  extends akoo
{
  public Comparator a;
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
  
  public akow(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_JavaUtilComparator = new akox(this);
  }
  
  private int a(byte paramByte, msg_comm.UinPairMsg paramUinPairMsg, String paramString, int paramInt)
  {
    if ((paramUinPairMsg.c2c_type.has()) && (paramUinPairMsg.service_type.has()))
    {
      int n = paramUinPairMsg.c2c_type.get();
      int i1 = paramUinPairMsg.service_type.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage : peerUin:" + paramString + "c2c_type:" + n + " service_type:" + i1 + " channelType:" + paramByte);
      }
      if ((n == 1) && (i1 == 130)) {
        return 1006;
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt).istroop;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt).istroop;
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
    awzu localawzu = new awzu(l6, Long.parseLong(paramString), true, paramBoolean2, paramBoolean3, false);
    localawzu.jdField_e_of_type_Boolean = true;
    localawzu.a(1000, localHashMap);
    localawzu.a(1001, localHashSet);
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
      if (!((msg_comm.Msg)localObject4).msg_head.has())
      {
        l4 = l2;
        l3 = l1;
        i1 = n;
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          break label2625;
        }
        l4 = l2;
        l3 = l1;
        i1 = n;
        localObject2 = localObject1;
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage: msgList[" + i2 + "] : msg doesn't has msgHead.");
        break label2625;
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
        break label2616;
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
    l8 = akau.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l9, l8, paramUinPairMsg.peer_uin.get());
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
      localawzu.jdField_a_of_type_Boolean = bool;
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      localawzu.jdField_e_of_type_Long = l8;
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      localawzu.h = paramBoolean3;
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      localObject4 = a((msg_comm.Msg)localObject4, localawzu).iterator();
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
          paramBoolean3 = bbet.a(((MessageRecord)localObject5).issend);
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
                askc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForMarketFace)localObject5);
              }
              n = i1;
              if (ajsf.az.equals(((MessageRecord)localObject5).frienduin))
              {
                n = i1;
                ((MessageRecord)localObject5).time = NetConnInfoCenter.getServerTime();
              }
              n = i1;
              if (ajsf.aR.equals(((MessageRecord)localObject5).frienduin))
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
            Object localObject6;
            if (((MessageRecord)localObject5).msgtype == -2002)
            {
              if (!paramBoolean3)
              {
                n = i1;
                if (axue.a(((MessageRecord)localObject5).msgUid, ((MessageRecord)localObject5).shmsgseq) != null)
                {
                  n = i1;
                  aytl.a(true);
                }
              }
              if (paramBoolean3)
              {
                n = i1;
                if ((localObject5 instanceof MessageForPtt))
                {
                  n = i1;
                  if (akpy.c(((MessageRecord)localObject5).istroop))
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
                  break label1963;
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
                ses.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", ((MessageRecord)localObject5).senderuin, (String)localObject2, str2, localArrayList3);
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
              if (bbet.a(((MessageRecord)localObject5).issend))
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
              break label1952;
            }
          }
          catch (Exception localException1)
          {
            l3 = l2;
            l4 = l1;
          }
          QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeC2CMessage error,", localException1);
          label1952:
          l1 = l4;
          l2 = l3;
          break label2637;
          label1963:
          n = i1;
          if ("2290230341".equals(((MessageRecord)localObject5).frienduin))
          {
            n = i1;
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80090E1", "0X80090E1", 0, 0, "", "", "", "");
          }
        }
      }
      l3 = l1;
      l1 = l2;
      l2 = l3;
      break label2637;
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
        i1 = akpy.a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        amns.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if ((!paramBoolean3) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {
          break label2536;
        }
      }
      label2536:
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        ((QQMessageFacade)localObject1).a(localArrayList1, str1, paramBoolean1);
        a(localArrayList1);
        b(localArrayList1);
        a("handleGetBuddyMessageResp", true, i1, paramBoolean3, paramBoolean2);
        a(localArrayList1, paramBoolean2);
        akpr.a((MessageRecord)localArrayList1.get(0), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (n == 1008)
        {
          localObject1 = (akdi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
          if (localObject1 != null) {
            ((akdi)localObject1).a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
        }
        if ((n != 0) || (localArrayList1.size() <= 0)) {
          break;
        }
        localObject1 = localArrayList1.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (MessageRecord)((Iterator)localObject1).next();
          akny.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 0, (MessageRecord)localObject3);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage : dstUin:" + paramUinPairMsg + ", pkgUinType:" + n);
      }
      return new Pair(paramUinPairMsg, Integer.valueOf(n));
    }
    for (;;)
    {
      label2616:
      label2625:
      label2637:
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
    List localList = ((akay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92)).a(String.valueOf(paramLong1), paramLong2 - 30L, 30L + paramLong3);
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
  
  @Nullable
  private msg_svc.PbGetMsgResp a(byte[] paramArrayOfByte)
  {
    msg_svc.PbGetMsgResp localPbGetMsgResp = new msg_svc.PbGetMsgResp();
    try
    {
      paramArrayOfByte = (msg_svc.PbGetMsgResp)localPbGetMsgResp.mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        axrl.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap(), "");
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
        ajyc.a(2131701272);
        return;
      }
      if (TextUtils.isEmpty(paramMsgHead)) {}
      for (Object localObject2 = akau.a(paramQQAppInterface, paramString1, str);; localObject2 = paramMsgHead) {
        for (;;)
        {
          Object localObject5;
          boolean bool;
          try
          {
            paramLong2 = Long.parseLong((String)localObject4);
            if ((paramInt == -126) || (paramInt == 2))
            {
              paramString2 = (String)localObject2 + ajyc.a(2131701270);
              paramMsgHead = (TroopManager)paramQQAppInterface.getManager(52);
              localObject3 = paramMsgHead.c(paramMsgHead.c(str));
              if ((localObject3 != null) && (((TroopInfo)localObject3).cGroupOption == 2))
              {
                localObject1 = paramQQAppInterface.getApp().getApplicationContext().getString(2131697668);
                if (!a(str)) {
                  break label1731;
                }
                paramString2 = paramString2 + "，" + (String)localObject1;
                paramMsgHead = "";
                localObject4 = (MessageForGrayTips)axaq.a(-1012);
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
                paramMsgHead = (bamj)paramQQAppInterface.getManager(81);
                if ((!a((MessageRecord)localObject4, false)) && (!paramMsgHead.a(paramLong1 + "", paramLong3))) {
                  continue;
                }
                bool = true;
                if (!bool)
                {
                  paramQQAppInterface.a().a((MessageRecord)localObject4, String.valueOf(localLong));
                  paramMsgHead = ((akhq)paramQQAppInterface.a(20)).a();
                  if ((paramMsgHead.b("newMember")) && (paramMsgHead.a(str))) {
                    paramMsgHead.c(str, paramString1);
                  }
                  new axra(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("exp_bar").a(new String[] { str, "", "" + bamn.b(paramQQAppInterface, str) }).a();
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
            paramMsgHead = paramQQAppInterface.getApp().getApplicationContext().getString(2131697669);
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
          if (((paramInt != -125) && (paramInt != 3)) || (((azoa)paramQQAppInterface.getManager(32)).a(str, (String)localObject4))) {
            break;
          }
          paramMsgHead = akau.a(paramQQAppInterface, paramString2, str);
          int n = 0;
          if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).equals(paramString2)))
          {
            paramMsgHead = ajyc.a(2131701269);
            n = 1;
          }
          for (;;)
          {
            if (n != 0)
            {
              localObject1 = paramMsgHead + ajyc.a(2131701271);
              label1121:
              localObject3 = (String)localObject1 + (String)localObject2 + ajyc.a(2131701278);
              localObject4 = paramQQAppInterface.getApp().getApplicationContext().getString(2131697669);
              localObject3 = (String)localObject3 + "，" + (String)localObject4;
              localObject5 = (MessageForGrayTips)axaq.a(-1012);
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
              paramString2 = (bamj)paramQQAppInterface.getManager(81);
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
                paramString2 = ((akhq)paramQQAppInterface.a(20)).a();
                if ((paramString2.b("newMember")) && (paramString2.a(str))) {
                  paramString2.c(str, paramString1);
                }
                new axra(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("exp_bar").a(new String[] { str, "", "" + bamn.b(paramQQAppInterface, str) }).a();
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.msg.C2CMessageProcessor", 2, "seq:" + paramLong3 + "|cOpt:" + paramInt + "|tips:" + (String)localObject3 + "|msgFilter:" + bool);
              return;
              localObject1 = paramMsgHead + ajyc.a(2131701276);
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
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_2
    //   4: istore 5
    //   6: aload_1
    //   7: getfield 859	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   10: ldc_w 881
    //   13: iconst_1
    //   14: invokevirtual 884	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   17: istore 11
    //   19: aload_1
    //   20: getfield 859	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   23: ldc_w 886
    //   26: iconst_1
    //   27: invokevirtual 884	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   30: istore 13
    //   32: aload_1
    //   33: getfield 859	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   36: ldc_w 888
    //   39: iconst_0
    //   40: invokevirtual 884	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   43: istore 12
    //   45: invokestatic 893	java/lang/System:currentTimeMillis	()J
    //   48: lstore 14
    //   50: aload_0
    //   51: aload_3
    //   52: checkcast 895	[B
    //   55: checkcast 895	[B
    //   58: invokespecial 897	akow:a	([B)Lmsf/msgsvc/msg_svc$PbGetMsgResp;
    //   61: astore 25
    //   63: new 93	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   70: astore 23
    //   72: aload 25
    //   74: ifnull +25 -> 99
    //   77: aload 25
    //   79: getfield 900	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 77	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   85: ifeq +14 -> 99
    //   88: aload 25
    //   90: getfield 900	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   93: invokevirtual 84	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   96: ifeq +150 -> 246
    //   99: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +104 -> 206
    //   105: aload 23
    //   107: iconst_0
    //   108: invokevirtual 255	java/lang/StringBuilder:setLength	(I)V
    //   111: aload 23
    //   113: ldc_w 902
    //   116: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 905	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   123: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: ldc_w 907
    //   129: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: astore 22
    //   134: aload 25
    //   136: ifnonnull +80 -> 216
    //   139: ldc_w 909
    //   142: astore_3
    //   143: aload 22
    //   145: aload_3
    //   146: invokevirtual 472	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   149: ldc_w 911
    //   152: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: astore 22
    //   157: aload 25
    //   159: ifnonnull +72 -> 231
    //   162: ldc_w 909
    //   165: astore_3
    //   166: aload 22
    //   168: aload_3
    //   169: invokevirtual 472	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   172: ldc_w 913
    //   175: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: iload 11
    //   180: invokevirtual 838	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   183: ldc_w 915
    //   186: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: iload 13
    //   191: invokevirtual 838	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: ldc 91
    //   197: iconst_2
    //   198: aload 23
    //   200: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 917	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload_0
    //   207: getfield 499	akow:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   210: aload_1
    //   211: aload_2
    //   212: invokevirtual 919	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   215: return
    //   216: aload 25
    //   218: getfield 900	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   221: invokevirtual 84	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   224: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   227: astore_3
    //   228: goto -85 -> 143
    //   231: aload 25
    //   233: getfield 922	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   236: invokevirtual 496	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   239: invokestatic 927	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   242: astore_3
    //   243: goto -77 -> 166
    //   246: aload 25
    //   248: getfield 930	msf/msgsvc/msg_svc$PbGetMsgResp:uin_pair_msgs	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   251: invokevirtual 156	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   254: astore 24
    //   256: aload_0
    //   257: getfield 499	akow:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   260: iconst_0
    //   261: putfield 931	com/tencent/mobileqq/app/MessageHandler:g	I
    //   264: aload 25
    //   266: getfield 935	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   269: invokevirtual 938	com/tencent/mobileqq/pb/PBEnumField:has	()Z
    //   272: ifeq +13 -> 285
    //   275: aload 25
    //   277: getfield 935	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   280: invokevirtual 939	com/tencent/mobileqq/pb/PBEnumField:get	()I
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
    //   299: getfield 922	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   302: invokevirtual 496	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   305: ifeq +15 -> 320
    //   308: aload 25
    //   310: getfield 922	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   313: invokevirtual 502	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   316: invokevirtual 508	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   319: astore_2
    //   320: aconst_null
    //   321: astore 22
    //   323: aload 25
    //   325: getfield 942	msf/msgsvc/msg_svc$PbGetMsgResp:pubaccount_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   328: invokevirtual 496	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   331: ifeq +16 -> 347
    //   334: aload 25
    //   336: getfield 942	msf/msgsvc/msg_svc$PbGetMsgResp:pubaccount_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   339: invokevirtual 502	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   342: invokevirtual 508	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   345: astore 22
    //   347: iconst_0
    //   348: istore 6
    //   350: aload 25
    //   352: getfield 945	msf/msgsvc/msg_svc$PbGetMsgResp:msg_rsp_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   355: invokevirtual 77	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   358: ifeq +13 -> 371
    //   361: aload 25
    //   363: getfield 945	msf/msgsvc/msg_svc$PbGetMsgResp:msg_rsp_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   366: invokevirtual 84	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   369: istore 6
    //   371: aload_0
    //   372: aload_2
    //   373: aload 22
    //   375: iload 6
    //   377: invokespecial 948	akow:a	([B[BI)V
    //   380: iconst_0
    //   381: istore 10
    //   383: aload_0
    //   384: getfield 499	akow:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   387: invokevirtual 950	com/tencent/mobileqq/app/MessageHandler:a	()Z
    //   390: ifeq +6 -> 396
    //   393: iconst_1
    //   394: istore 10
    //   396: iload 4
    //   398: ifle +25 -> 423
    //   401: aload_0
    //   402: getfield 499	akow:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   405: iload 4
    //   407: aload_2
    //   408: iload 5
    //   410: iload 11
    //   412: iload 13
    //   414: iload 10
    //   416: aconst_null
    //   417: iload 6
    //   419: aconst_null
    //   420: invokevirtual 953	com/tencent/mobileqq/app/MessageHandler:a	(B[BIZZZLjava/lang/String;ILjava/lang/Object;)V
    //   423: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   426: ifeq +153 -> 579
    //   429: aload 23
    //   431: iconst_0
    //   432: invokevirtual 255	java/lang/StringBuilder:setLength	(I)V
    //   435: aload 23
    //   437: ldc_w 902
    //   440: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload_1
    //   444: invokevirtual 905	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   447: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   450: ldc_w 907
    //   453: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: aload 25
    //   458: getfield 900	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   461: invokevirtual 84	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   464: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   467: ldc_w 955
    //   470: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload 25
    //   475: getfield 922	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   478: invokevirtual 496	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   481: invokevirtual 838	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   484: ldc 109
    //   486: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: iload 4
    //   491: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   494: ldc_w 957
    //   497: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: iload 5
    //   502: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   505: ldc_w 959
    //   508: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: iload 11
    //   513: invokevirtual 838	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   516: ldc_w 915
    //   519: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: iload 13
    //   524: invokevirtual 838	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   527: ldc_w 961
    //   530: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: aload 24
    //   535: invokeinterface 161 1 0
    //   540: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   543: ldc_w 963
    //   546: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: aload_3
    //   550: invokevirtual 968	java/lang/Object:hashCode	()I
    //   553: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   556: ldc_w 970
    //   559: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: iload 6
    //   564: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: ldc 91
    //   570: iconst_2
    //   571: aload 23
    //   573: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   579: iconst_0
    //   580: istore 7
    //   582: iload 7
    //   584: aload 24
    //   586: invokeinterface 161 1 0
    //   591: if_icmpge +1019 -> 1610
    //   594: invokestatic 893	java/lang/System:currentTimeMillis	()J
    //   597: lstore 14
    //   599: aload 24
    //   601: iload 7
    //   603: invokeinterface 591 2 0
    //   608: checkcast 67	msf/msgcomm/msg_comm$UinPairMsg
    //   611: astore_3
    //   612: aload_3
    //   613: getfield 233	msf/msgcomm/msg_comm$UinPairMsg:peer_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   616: invokevirtual 224	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   619: invokestatic 243	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   622: astore_2
    //   623: aload_3
    //   624: getfield 973	msf/msgcomm/msg_comm$UinPairMsg:last_read_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   627: invokevirtual 84	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   630: i2l
    //   631: ldc2_w 974
    //   634: land
    //   635: lstore 16
    //   637: aload_3
    //   638: getfield 151	msf/msgcomm/msg_comm$UinPairMsg:msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   641: invokevirtual 156	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   644: astore 22
    //   646: aload_3
    //   647: getfield 978	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   650: invokevirtual 77	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   653: ifeq +855 -> 1508
    //   656: aload_3
    //   657: getfield 978	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   660: invokevirtual 84	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   663: ifeq +845 -> 1508
    //   666: iconst_1
    //   667: istore 10
    //   669: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   672: ifeq +78 -> 750
    //   675: aload 23
    //   677: iconst_0
    //   678: invokevirtual 255	java/lang/StringBuilder:setLength	(I)V
    //   681: aload 23
    //   683: ldc_w 980
    //   686: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: aload_2
    //   690: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: ldc_w 982
    //   696: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: iload 10
    //   701: invokevirtual 838	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   704: ldc_w 984
    //   707: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: lload 16
    //   712: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   715: ldc_w 986
    //   718: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: astore 25
    //   723: aload 22
    //   725: ifnonnull +789 -> 1514
    //   728: ldc_w 909
    //   731: astore_1
    //   732: aload 25
    //   734: aload_1
    //   735: invokevirtual 472	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: ldc 91
    //   741: iconst_2
    //   742: aload 23
    //   744: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   747: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   750: aload 22
    //   752: ifnull +819 -> 1571
    //   755: aload 22
    //   757: invokeinterface 161 1 0
    //   762: ifle +809 -> 1571
    //   765: aload 22
    //   767: invokeinterface 161 1 0
    //   772: iconst_1
    //   773: if_icmple +12 -> 785
    //   776: aload 22
    //   778: aload_0
    //   779: getfield 63	akow:jdField_a_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   782: invokestatic 992	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   785: aload_0
    //   786: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   789: bipush 51
    //   791: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   794: checkcast 994	ajxn
    //   797: aload 22
    //   799: iconst_0
    //   800: invokeinterface 591 2 0
    //   805: checkcast 202	msf/msgcomm/msg_comm$Msg
    //   808: getfield 206	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   811: invokevirtual 211	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   814: checkcast 208	msf/msgcomm/msg_comm$MsgHead
    //   817: getfield 227	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   820: invokevirtual 224	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   823: invokevirtual 997	ajxn:a	(J)V
    //   826: aload_0
    //   827: getfield 499	akow:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   830: aload_2
    //   831: iconst_0
    //   832: invokevirtual 1000	com/tencent/mobileqq/app/MessageHandler:a	(Ljava/lang/String;I)Ljava/lang/Object;
    //   835: astore 25
    //   837: aload 25
    //   839: monitorenter
    //   840: aload_0
    //   841: aload_2
    //   842: aload_3
    //   843: lload 16
    //   845: iload 10
    //   847: iload 11
    //   849: iload 12
    //   851: invokespecial 1002	akow:a	(Ljava/lang/String;Lmsf/msgcomm/msg_comm$UinPairMsg;JZZZ)Landroid/util/Pair;
    //   854: astore_2
    //   855: aload_2
    //   856: getfield 1006	android/util/Pair:first	Ljava/lang/Object;
    //   859: checkcast 240	java/lang/String
    //   862: astore_1
    //   863: aload_2
    //   864: getfield 1009	android/util/Pair:second	Ljava/lang/Object;
    //   867: checkcast 165	java/lang/Integer
    //   870: invokevirtual 1012	java/lang/Integer:intValue	()I
    //   873: istore 5
    //   875: aload 25
    //   877: monitorexit
    //   878: iload 10
    //   880: ifne +170 -> 1050
    //   883: aload_0
    //   884: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   887: invokevirtual 246	com/tencent/mobileqq/app/QQAppInterface:a	()Lawzw;
    //   890: aload_1
    //   891: invokevirtual 1014	awzw:g	(Ljava/lang/String;)J
    //   894: lstore 18
    //   896: aload 22
    //   898: iconst_0
    //   899: invokeinterface 591 2 0
    //   904: checkcast 202	msf/msgcomm/msg_comm$Msg
    //   907: getfield 206	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   910: invokevirtual 211	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   913: checkcast 208	msf/msgcomm/msg_comm$MsgHead
    //   916: getfield 230	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   919: invokevirtual 84	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   922: i2l
    //   923: lstore 20
    //   925: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   928: ifeq +60 -> 988
    //   931: ldc 91
    //   933: iconst_2
    //   934: new 93	java/lang/StringBuilder
    //   937: dup
    //   938: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   941: ldc 96
    //   943: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: aload_1
    //   947: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   950: ldc_w 1016
    //   953: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: lload 18
    //   958: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   961: ldc_w 1018
    //   964: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: lload 20
    //   969: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   972: ldc 109
    //   974: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: iload 4
    //   979: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   982: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   985: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   988: lload 18
    //   990: lconst_0
    //   991: lcmp
    //   992: ifeq +11 -> 1003
    //   995: lload 20
    //   997: lload 18
    //   999: lcmp
    //   1000: ifge +35 -> 1035
    //   1003: aload_0
    //   1004: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1007: invokevirtual 246	com/tencent/mobileqq/app/QQAppInterface:a	()Lawzw;
    //   1010: aload_1
    //   1011: lload 20
    //   1013: lconst_0
    //   1014: invokevirtual 1021	awzw:b	(Ljava/lang/String;JJ)V
    //   1017: iload 4
    //   1019: ifle +16 -> 1035
    //   1022: aload_0
    //   1023: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1026: invokevirtual 246	com/tencent/mobileqq/app/QQAppInterface:a	()Lawzw;
    //   1029: aload_1
    //   1030: lload 20
    //   1032: invokevirtual 1023	awzw:g	(Ljava/lang/String;J)V
    //   1035: iload 4
    //   1037: ifne +13 -> 1050
    //   1040: aload_0
    //   1041: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1044: invokevirtual 246	com/tencent/mobileqq/app/QQAppInterface:a	()Lawzw;
    //   1047: invokevirtual 1025	awzw:c	()V
    //   1050: iconst_0
    //   1051: istore 8
    //   1053: iload 11
    //   1055: ifeq +444 -> 1499
    //   1058: aload_1
    //   1059: astore_2
    //   1060: iload 5
    //   1062: sipush 1006
    //   1065: if_icmpne +30 -> 1095
    //   1068: aload_0
    //   1069: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1072: bipush 11
    //   1074: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1077: checkcast 1027	askl
    //   1080: aload_1
    //   1081: invokeinterface 1029 2 0
    //   1086: astore_3
    //   1087: aload_1
    //   1088: astore_2
    //   1089: aload_3
    //   1090: ifnull +5 -> 1095
    //   1093: aload_3
    //   1094: astore_2
    //   1095: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1098: ifeq +51 -> 1149
    //   1101: ldc 91
    //   1103: iconst_2
    //   1104: new 93	java/lang/StringBuilder
    //   1107: dup
    //   1108: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1111: ldc_w 1031
    //   1114: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1117: aload_2
    //   1118: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: ldc_w 1033
    //   1124: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: iload 5
    //   1129: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1132: ldc_w 1035
    //   1135: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: lload 16
    //   1140: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1143: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1146: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1149: iload 5
    //   1151: istore 9
    //   1153: iload 5
    //   1155: invokestatic 1038	akpy:a	(I)I
    //   1158: sipush 1032
    //   1161: if_icmpne +6 -> 1167
    //   1164: iconst_0
    //   1165: istore 9
    //   1167: iload 8
    //   1169: ifne +241 -> 1410
    //   1172: aload_2
    //   1173: iload 9
    //   1175: invokestatic 1044	com/tencent/mobileqq/data/ConversationInfo:reportPublicaccoutTypeError	(Ljava/lang/String;I)Z
    //   1178: ifeq +232 -> 1410
    //   1181: new 93	java/lang/StringBuilder
    //   1184: dup
    //   1185: sipush 128
    //   1188: invokespecial 1046	java/lang/StringBuilder:<init>	(I)V
    //   1191: astore_1
    //   1192: aload_1
    //   1193: ldc_w 1047
    //   1196: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: ldc_w 1049
    //   1202: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: aload_2
    //   1206: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: pop
    //   1210: aload_1
    //   1211: ldc_w 1051
    //   1214: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: iload 9
    //   1219: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1222: pop
    //   1223: aload 22
    //   1225: ifnull +175 -> 1400
    //   1228: aload 22
    //   1230: invokeinterface 161 1 0
    //   1235: ifle +165 -> 1400
    //   1238: aload 22
    //   1240: iconst_0
    //   1241: invokeinterface 591 2 0
    //   1246: checkcast 202	msf/msgcomm/msg_comm$Msg
    //   1249: astore_3
    //   1250: aload_3
    //   1251: getfield 206	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1254: invokevirtual 212	msf/msgcomm/msg_comm$MsgHead:has	()Z
    //   1257: ifeq +143 -> 1400
    //   1260: aload_3
    //   1261: getfield 206	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1264: invokevirtual 211	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1267: checkcast 208	msf/msgcomm/msg_comm$MsgHead
    //   1270: astore_3
    //   1271: aload_1
    //   1272: ldc_w 1053
    //   1275: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: aload_3
    //   1279: getfield 1056	msf/msgcomm/msg_comm$MsgHead:msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1282: invokevirtual 84	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1285: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1288: pop
    //   1289: aload_1
    //   1290: ldc_w 1058
    //   1293: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: aload_3
    //   1297: getfield 590	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1300: invokevirtual 84	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1303: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1306: pop
    //   1307: aload_1
    //   1308: ldc_w 1060
    //   1311: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: aload_3
    //   1315: getfield 587	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1318: invokevirtual 224	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1321: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1324: pop
    //   1325: aload_1
    //   1326: ldc_w 1062
    //   1329: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1332: aload_3
    //   1333: getfield 230	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1336: invokevirtual 84	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1339: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1342: pop
    //   1343: aload_3
    //   1344: getfield 1066	msf/msgcomm/msg_comm$MsgHead:c2c_tmp_msg_head	Lmsf/msgcomm/msg_comm$C2CTmpMsgHead;
    //   1347: invokevirtual 1069	msf/msgcomm/msg_comm$C2CTmpMsgHead:has	()Z
    //   1350: ifeq +50 -> 1400
    //   1353: aload_3
    //   1354: getfield 1066	msf/msgcomm/msg_comm$MsgHead:c2c_tmp_msg_head	Lmsf/msgcomm/msg_comm$C2CTmpMsgHead;
    //   1357: invokevirtual 1070	msf/msgcomm/msg_comm$C2CTmpMsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1360: checkcast 1068	msf/msgcomm/msg_comm$C2CTmpMsgHead
    //   1363: astore_3
    //   1364: aload_1
    //   1365: ldc_w 1072
    //   1368: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1371: aload_3
    //   1372: getfield 1073	msf/msgcomm/msg_comm$C2CTmpMsgHead:service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1375: invokevirtual 84	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1378: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1381: pop
    //   1382: aload_1
    //   1383: ldc_w 1075
    //   1386: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1389: aload_3
    //   1390: getfield 1076	msf/msgcomm/msg_comm$C2CTmpMsgHead:c2c_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1393: invokevirtual 84	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1396: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1399: pop
    //   1400: ldc 91
    //   1402: iconst_1
    //   1403: aload_1
    //   1404: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1407: invokestatic 917	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1410: new 1078	android/os/Message
    //   1413: dup
    //   1414: invokespecial 1079	android/os/Message:<init>	()V
    //   1417: astore_1
    //   1418: aload_1
    //   1419: iconst_1
    //   1420: putfield 1082	android/os/Message:what	I
    //   1423: new 734	android/os/Bundle
    //   1426: dup
    //   1427: invokespecial 735	android/os/Bundle:<init>	()V
    //   1430: astore_3
    //   1431: aload_3
    //   1432: ldc_w 1084
    //   1435: lload 16
    //   1437: invokevirtual 868	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1440: aload_3
    //   1441: ldc_w 1086
    //   1444: aload_2
    //   1445: invokevirtual 746	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1448: aload_3
    //   1449: ldc_w 1088
    //   1452: iload 9
    //   1454: invokevirtual 741	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1457: aload_1
    //   1458: aload_3
    //   1459: invokevirtual 1092	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   1462: aload_0
    //   1463: getfield 499	akow:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1466: astore_3
    //   1467: iload 4
    //   1469: ifgt +121 -> 1590
    //   1472: iconst_1
    //   1473: istore 10
    //   1475: aload_3
    //   1476: aload_1
    //   1477: iload 10
    //   1479: invokevirtual 1095	com/tencent/mobileqq/app/MessageHandler:a	(Landroid/os/Message;Z)V
    //   1482: iload 6
    //   1484: iconst_2
    //   1485: if_icmpne +111 -> 1596
    //   1488: aload_0
    //   1489: getfield 36	akow:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   1492: aload_2
    //   1493: invokeinterface 1096 2 0
    //   1498: pop
    //   1499: iload 7
    //   1501: iconst_1
    //   1502: iadd
    //   1503: istore 7
    //   1505: goto -923 -> 582
    //   1508: iconst_0
    //   1509: istore 10
    //   1511: goto -842 -> 669
    //   1514: aload 22
    //   1516: invokeinterface 161 1 0
    //   1521: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1524: astore_1
    //   1525: goto -793 -> 732
    //   1528: astore_1
    //   1529: aload 25
    //   1531: monitorexit
    //   1532: aload_1
    //   1533: athrow
    //   1534: astore_1
    //   1535: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1538: ifeq -39 -> 1499
    //   1541: ldc 91
    //   1543: iconst_2
    //   1544: new 93	java/lang/StringBuilder
    //   1547: dup
    //   1548: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1551: ldc_w 1098
    //   1554: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1557: aload_1
    //   1558: invokevirtual 472	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1561: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1564: aload_1
    //   1565: invokestatic 623	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1568: goto -69 -> 1499
    //   1571: aload_0
    //   1572: iload 4
    //   1574: aload_3
    //   1575: aload_2
    //   1576: iconst_0
    //   1577: invokespecial 1100	akow:a	(BLmsf/msgcomm/msg_comm$UinPairMsg;Ljava/lang/String;I)I
    //   1580: istore 5
    //   1582: iconst_1
    //   1583: istore 8
    //   1585: aload_2
    //   1586: astore_1
    //   1587: goto -534 -> 1053
    //   1590: iconst_0
    //   1591: istore 10
    //   1593: goto -118 -> 1475
    //   1596: aload_0
    //   1597: getfield 34	akow:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1600: aload_2
    //   1601: invokeinterface 1096 2 0
    //   1606: pop
    //   1607: goto -108 -> 1499
    //   1610: iload 4
    //   1612: ifgt +544 -> 2156
    //   1615: aload_0
    //   1616: getfield 499	akow:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1619: invokevirtual 1101	com/tencent/mobileqq/app/MessageHandler:c	()V
    //   1622: iload 11
    //   1624: ifeq +454 -> 2078
    //   1627: aload_0
    //   1628: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1631: invokevirtual 1104	com/tencent/mobileqq/app/QQAppInterface:a	()Lakpc;
    //   1634: invokevirtual 1108	akpc:a	()Ljava/util/Set;
    //   1637: invokeinterface 479 1 0
    //   1642: astore_1
    //   1643: aload_1
    //   1644: invokeinterface 283 1 0
    //   1649: ifeq +414 -> 2063
    //   1652: aload_1
    //   1653: invokeinterface 287 1 0
    //   1658: checkcast 1040	com/tencent/mobileqq/data/ConversationInfo
    //   1661: astore_2
    //   1662: aload_2
    //   1663: getfield 1111	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1666: ifnull -23 -> 1643
    //   1669: aload_2
    //   1670: getfield 1114	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1673: sipush 1036
    //   1676: if_icmpeq -33 -> 1643
    //   1679: aload_2
    //   1680: getfield 1114	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1683: invokestatic 1038	akpy:a	(I)I
    //   1686: sipush 1032
    //   1689: if_icmpeq -46 -> 1643
    //   1692: iload 6
    //   1694: iconst_1
    //   1695: if_icmpne +13 -> 1708
    //   1698: aload_2
    //   1699: getfield 1114	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1702: sipush 1008
    //   1705: if_icmpeq -62 -> 1643
    //   1708: iload 6
    //   1710: iconst_2
    //   1711: if_icmpne +13 -> 1724
    //   1714: aload_2
    //   1715: getfield 1114	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1718: sipush 1008
    //   1721: if_icmpne -78 -> 1643
    //   1724: iload 6
    //   1726: iconst_2
    //   1727: if_icmpeq +31 -> 1758
    //   1730: aload_0
    //   1731: getfield 34	akow:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1734: invokeinterface 1115 1 0
    //   1739: ifle +19 -> 1758
    //   1742: aload_0
    //   1743: getfield 34	akow:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1746: aload_2
    //   1747: getfield 1111	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1750: invokeinterface 1118 2 0
    //   1755: ifne -112 -> 1643
    //   1758: iload 6
    //   1760: iconst_2
    //   1761: if_icmpne +31 -> 1792
    //   1764: aload_0
    //   1765: getfield 36	akow:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   1768: invokeinterface 1115 1 0
    //   1773: ifle +19 -> 1792
    //   1776: aload_0
    //   1777: getfield 36	akow:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   1780: aload_2
    //   1781: getfield 1111	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1784: invokeinterface 1118 2 0
    //   1789: ifne -146 -> 1643
    //   1792: aload_2
    //   1793: getfield 1114	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1796: invokestatic 400	akpy:c	(I)Z
    //   1799: ifeq -156 -> 1643
    //   1802: aload_2
    //   1803: invokestatic 1121	akpc:b	(Lcom/tencent/mobileqq/data/ConversationInfo;)I
    //   1806: ifle -163 -> 1643
    //   1809: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1812: ifeq +45 -> 1857
    //   1815: ldc 91
    //   1817: iconst_2
    //   1818: new 93	java/lang/StringBuilder
    //   1821: dup
    //   1822: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1825: ldc_w 1123
    //   1828: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1831: aload_2
    //   1832: getfield 1111	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1835: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1838: ldc_w 1125
    //   1841: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1844: aload_2
    //   1845: getfield 1114	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1848: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1851: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1854: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1857: aload_2
    //   1858: getfield 1111	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1861: invokevirtual 755	java/lang/String:length	()I
    //   1864: iconst_4
    //   1865: if_icmple -222 -> 1643
    //   1868: aload_2
    //   1869: getfield 1114	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1872: sipush 1001
    //   1875: if_icmpne +134 -> 2009
    //   1878: aload_0
    //   1879: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1882: invokevirtual 246	com/tencent/mobileqq/app/QQAppInterface:a	()Lawzw;
    //   1885: aload_2
    //   1886: getfield 1111	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1889: invokevirtual 1128	awzw:m	(Ljava/lang/String;)[B
    //   1892: astore_3
    //   1893: aload_3
    //   1894: ifnull -251 -> 1643
    //   1897: aload_3
    //   1898: arraylength
    //   1899: ifle -256 -> 1643
    //   1902: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1905: ifeq +29 -> 1934
    //   1908: ldc 91
    //   1910: iconst_2
    //   1911: new 93	java/lang/StringBuilder
    //   1914: dup
    //   1915: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1918: ldc_w 1130
    //   1921: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1924: aload_3
    //   1925: invokevirtual 472	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1928: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1931: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1934: new 1078	android/os/Message
    //   1937: dup
    //   1938: invokespecial 1079	android/os/Message:<init>	()V
    //   1941: astore_3
    //   1942: aload_3
    //   1943: iconst_1
    //   1944: putfield 1082	android/os/Message:what	I
    //   1947: new 734	android/os/Bundle
    //   1950: dup
    //   1951: invokespecial 735	android/os/Bundle:<init>	()V
    //   1954: astore 22
    //   1956: aload 22
    //   1958: ldc_w 1084
    //   1961: ldc2_w 1131
    //   1964: invokevirtual 868	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1967: aload 22
    //   1969: ldc_w 1086
    //   1972: aload_2
    //   1973: getfield 1111	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1976: invokevirtual 746	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1979: aload 22
    //   1981: ldc_w 1088
    //   1984: aload_2
    //   1985: getfield 1114	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1988: invokevirtual 741	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1991: aload_3
    //   1992: aload 22
    //   1994: invokevirtual 1092	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   1997: aload_0
    //   1998: getfield 499	akow:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2001: aload_3
    //   2002: iconst_1
    //   2003: invokevirtual 1095	com/tencent/mobileqq/app/MessageHandler:a	(Landroid/os/Message;Z)V
    //   2006: goto -363 -> 1643
    //   2009: aload_2
    //   2010: getfield 1114	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   2013: sipush 10002
    //   2016: if_icmpne +21 -> 2037
    //   2019: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2022: ifeq -88 -> 1934
    //   2025: ldc 91
    //   2027: iconst_2
    //   2028: ldc_w 1134
    //   2031: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2034: goto -100 -> 1934
    //   2037: aload_2
    //   2038: getfield 1137	com/tencent/mobileqq/data/ConversationInfo:isImax	Z
    //   2041: ifeq -107 -> 1934
    //   2044: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2047: ifeq -404 -> 1643
    //   2050: ldc_w 1139
    //   2053: iconst_2
    //   2054: ldc_w 1141
    //   2057: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2060: goto -417 -> 1643
    //   2063: iload 6
    //   2065: iconst_2
    //   2066: if_icmpne +140 -> 2206
    //   2069: aload_0
    //   2070: getfield 36	akow:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   2073: invokeinterface 1144 1 0
    //   2078: invokestatic 1149	bfmu:a	()Lbfmu;
    //   2081: invokevirtual 1151	bfmu:e	()V
    //   2084: iload 6
    //   2086: tableswitch	default:+26 -> 2112, 0:+132->2218, 1:+153->2239, 2:+165->2251
    //   2113: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2116: invokevirtual 246	com/tencent/mobileqq/app/QQAppInterface:a	()Lawzw;
    //   2119: invokevirtual 1153	awzw:i	()V
    //   2122: aload_0
    //   2123: getfield 499	akow:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2126: invokevirtual 950	com/tencent/mobileqq/app/MessageHandler:a	()Z
    //   2129: ifeq +27 -> 2156
    //   2132: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2135: ifeq +12 -> 2147
    //   2138: ldc 91
    //   2140: iconst_2
    //   2141: ldc_w 1155
    //   2144: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2147: aload_0
    //   2148: getfield 499	akow:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2151: iconst_0
    //   2152: iconst_0
    //   2153: invokevirtual 1158	com/tencent/mobileqq/app/MessageHandler:a	(ZI)V
    //   2156: invokestatic 893	java/lang/System:currentTimeMillis	()J
    //   2159: lload 14
    //   2161: lsub
    //   2162: lstore 14
    //   2164: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2167: ifeq +30 -> 2197
    //   2170: ldc 91
    //   2172: iconst_2
    //   2173: new 93	java/lang/StringBuilder
    //   2176: dup
    //   2177: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   2180: ldc_w 1160
    //   2183: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2186: lload 14
    //   2188: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2191: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2194: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2197: ldc_w 1162
    //   2200: lload 14
    //   2202: invokestatic 1164	akpr:a	(Ljava/lang/String;J)V
    //   2205: return
    //   2206: aload_0
    //   2207: getfield 34	akow:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   2210: invokeinterface 1144 1 0
    //   2215: goto -137 -> 2078
    //   2218: aload_0
    //   2219: sipush 4016
    //   2222: iconst_1
    //   2223: aconst_null
    //   2224: invokevirtual 878	akow:a	(IZLjava/lang/Object;)V
    //   2227: aload_0
    //   2228: sipush 4001
    //   2231: iconst_1
    //   2232: aconst_null
    //   2233: invokevirtual 878	akow:a	(IZLjava/lang/Object;)V
    //   2236: goto -124 -> 2112
    //   2239: aload_0
    //   2240: sipush 4001
    //   2243: iconst_1
    //   2244: aconst_null
    //   2245: invokevirtual 878	akow:a	(IZLjava/lang/Object;)V
    //   2248: goto -136 -> 2112
    //   2251: aload_0
    //   2252: sipush 4016
    //   2255: iconst_1
    //   2256: aconst_null
    //   2257: invokevirtual 878	akow:a	(IZLjava/lang/Object;)V
    //   2260: goto -148 -> 2112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2263	0	this	akow
    //   0	2263	1	paramToServiceMsg	ToServiceMsg
    //   0	2263	2	paramFromServiceMsg	FromServiceMsg
    //   0	2263	3	paramObject	Object
    //   1	1610	4	b1	byte
    //   4	1577	5	n	int
    //   348	1737	6	i1	int
    //   580	924	7	i2	int
    //   1051	533	8	i3	int
    //   1151	302	9	i4	int
    //   381	1211	10	bool1	boolean
    //   17	1606	11	bool2	boolean
    //   43	807	12	bool3	boolean
    //   30	493	13	bool4	boolean
    //   48	2153	14	l1	long
    //   635	801	16	l2	long
    //   894	104	18	l3	long
    //   923	108	20	l4	long
    //   132	1861	22	localObject1	Object
    //   70	673	23	localStringBuilder	StringBuilder
    //   254	346	24	localList	List
    // Exception table:
    //   from	to	target	type
    //   840	878	1528	finally
    //   1529	1532	1528	finally
    //   826	840	1534	java/lang/Exception
    //   1532	1534	1534	java/lang/Exception
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
        localObject2 = new awzu(l7, l2, true, false, false, false);
        ((awzu)localObject2).h = true;
        paramMsg = a(paramMsg, (axat)localObject2);
        akau.a(paramMsg);
        if ((paramMsg != null) && (paramMsg.size() != 0))
        {
          a(paramMsg, (ArrayList)localObject1, true);
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
        bool2 = akau.a((ArrayList)localObject2);
        n = akpy.a((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (!bool2) {
          break label856;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop) {}
    label856:
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
      a("handleMsgPush_PB_C2CPush", true, n, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2), false);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b((ArrayList)localObject2);
      return;
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    long l1 = bbmj.a(paramArrayOfByte, 0);
    String str = String.valueOf(l1);
    bbmj.a(paramArrayOfByte, 10);
    int n = bbmj.a(paramArrayOfByte, 16);
    Object localObject = null;
    if (n > 0) {
      localObject = bbmj.a(paramArrayOfByte, 18, n);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.C2CMessageProcessor", 2, "----->handleHotChatAnnouncementMsg dwGroupCode = " + l1 + ", len = " + n + ", announcement = " + (String)localObject);
    }
    paramArrayOfByte = (ajyi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35);
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
      Object localObject1 = (akay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
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
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(str, ((Long)localObject4).longValue(), paramFromServiceMsg.last_msgtime.get(), paramToServiceMsg.extraData.getLong("lEndTime"), (short)0, paramFromServiceMsg.random.get(), 1, ((akay)localObject1).a(), ((akay)localObject1).b(), paramToServiceMsg.extraData.getBoolean("fetchMore"), i2, bool2);
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
          l1 = akau.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((msg_comm.MsgHead)((msg_comm.Msg)localObject6).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject6).msg_head.get()).to_uin.get(), paramFromServiceMsg.peer_uin.get());
        }
        ((ArrayList)localObject3).addAll((Collection)a((List)localObject2, (List)localObject5, l1, ((Long)localObject4).longValue(), paramToServiceMsg.extraData.getLong("lEndTime")).second);
        localObject4 = new awzu(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), l1, true, true, false, false);
        ((awzu)localObject4).h = true;
        localObject5 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (msg_comm.Msg)((Iterator)localObject5).next();
          try
          {
            localObject6 = a((msg_comm.Msg)localObject6, (axat)localObject4);
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
          Collections.sort((List)localObject3, new akoy(this));
          if (localObject1 == null) {}
        }
        try
        {
          ((akay)localObject1).a((List)localObject3, str);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a((ArrayList)localObject3, false);
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()));
          if ((localObject4 == null) || (((Long)((Pair)localObject4).first).longValue() > paramFromServiceMsg.last_msgtime.get())) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()), paramToServiceMsg.extraData.getLong("lBeginTime"), 0L);
          }
          ((akay)localObject1).a().b(str, paramToServiceMsg.extraData.getLong("lBeginTime"), 3);
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
  
  private void b(ArrayList<MessageRecord> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord.msgtype == -3006) || (localMessageRecord.msgtype == -5004))
      {
        PAMessage localPAMessage = acyn.a(localMessageRecord);
        if ((localPAMessage != null) && (localPAMessage.mMsgId > 0L)) {
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localMessageRecord.frienduin, "mp_msg_sys_15", "msg_get", 0, 1, 0, Long.toString(localPAMessage.mMsgId), "", "", "");
        }
      }
      if ((localMessageRecord.mQidianMasterUin != 0L) && (!TextUtils.isEmpty(localMessageRecord.mQidianTipText)) && (localMessageRecord.mIsShowQidianTips == 1)) {
        ThreadManager.executeOnSubThread(new C2CMessageProcessor.5(this, localMessageRecord));
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
        localObject1 = new awzu(l7, l3, true, false, false, false);
        ((awzu)localObject1).h = true;
        localObject1 = a(paramMsg, (axat)localObject1);
        akau.a((List)localObject1);
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
            break label1511;
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
                  boolean bool = localElem.general_flags.bytes_pb_reserve.has();
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localArrayList3, String.valueOf(l7), false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMsgHead.msg_seq.get());
      i1 = paramFromServiceMsg.getRequestSsoSeq();
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l2, localArrayList2, paramPbPushMsg.svrip.get(), i1, null);
      if (l1 == 127L) {
        break;
      }
      a("handleMsgPush_PB_SlaveMaster", true, 0, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(false), false);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(localArrayList3);
      if ((n == 0) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        break;
      }
      axas.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2);
      return;
      label1511:
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
          awzu localawzu;
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
        l1 = akau.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).to_uin.get(), paramFromServiceMsg.peer_uin.get());
      }
      localawzu = new awzu(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), l1, true, true, false, false);
      localawzu.h = true;
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
          localObject = a((msg_comm.Msg)localObject, localawzu);
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
      Collections.sort(paramObject, new akoz(this));
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
    //   1: getfield 859	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 1184
    //   7: invokevirtual 1188	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   10: istore 4
    //   12: new 177	java/util/HashMap
    //   15: dup
    //   16: iconst_1
    //   17: invokespecial 1166	java/util/HashMap:<init>	(I)V
    //   20: astore 14
    //   22: aload 14
    //   24: ldc_w 1168
    //   27: aload_1
    //   28: getfield 859	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   31: ldc_w 1170
    //   34: invokevirtual 1172	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokevirtual 1176	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: pop
    //   41: aload 14
    //   43: ldc_w 1178
    //   46: aload_1
    //   47: getfield 859	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   50: ldc_w 1180
    //   53: invokevirtual 864	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   56: invokestatic 628	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   59: invokevirtual 1176	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   62: pop
    //   63: aload 14
    //   65: ldc_w 1182
    //   68: iload 4
    //   70: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   73: invokevirtual 1176	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   76: pop
    //   77: new 1755	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp
    //   80: dup
    //   81: invokespecial 1756	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:<init>	()V
    //   84: astore 13
    //   86: aload 13
    //   88: aload_3
    //   89: checkcast 895	[B
    //   92: checkcast 895	[B
    //   95: invokevirtual 1757	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 1755	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp
    //   101: astore 13
    //   103: aload 13
    //   105: ifnull +67 -> 172
    //   108: new 1759	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody
    //   111: dup
    //   112: invokespecial 1760	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:<init>	()V
    //   115: astore_3
    //   116: aload 13
    //   118: getfield 1763	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:serialize_rspbody	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   121: invokevirtual 496	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   124: ifeq +139 -> 263
    //   127: aload_3
    //   128: aload 13
    //   130: getfield 1763	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:serialize_rspbody	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   133: invokevirtual 502	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   136: invokevirtual 508	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   139: invokevirtual 1764	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   142: checkcast 1759	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody
    //   145: astore_3
    //   146: aload_3
    //   147: ifnonnull +121 -> 268
    //   150: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +12 -> 165
    //   156: ldc 91
    //   158: iconst_2
    //   159: ldc_w 1766
    //   162: invokestatic 1194	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload_0
    //   166: aload_1
    //   167: aload_2
    //   168: iconst_0
    //   169: invokespecial 1768	akow:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Z)V
    //   172: return
    //   173: astore_3
    //   174: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +13 -> 190
    //   180: ldc 91
    //   182: iconst_2
    //   183: ldc_w 1770
    //   186: aload_3
    //   187: invokestatic 444	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   190: aconst_null
    //   191: astore 13
    //   193: goto -90 -> 103
    //   196: astore_3
    //   197: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +13 -> 213
    //   203: ldc 91
    //   205: iconst_2
    //   206: ldc_w 1772
    //   209: aload_3
    //   210: invokestatic 444	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   213: aconst_null
    //   214: astore 13
    //   216: goto -113 -> 103
    //   219: astore_3
    //   220: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +13 -> 236
    //   226: ldc 91
    //   228: iconst_2
    //   229: ldc_w 1774
    //   232: aload_3
    //   233: invokestatic 444	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: aconst_null
    //   237: astore_3
    //   238: goto -92 -> 146
    //   241: astore_3
    //   242: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +13 -> 258
    //   248: ldc 91
    //   250: iconst_2
    //   251: ldc_w 1776
    //   254: aload_3
    //   255: invokestatic 444	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   258: aconst_null
    //   259: astore_3
    //   260: goto -114 -> 146
    //   263: aconst_null
    //   264: astore_3
    //   265: goto -119 -> 146
    //   268: aload_3
    //   269: getfield 1778	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:result	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   272: invokevirtual 939	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   275: istore 5
    //   277: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq +41 -> 321
    //   283: ldc 91
    //   285: iconst_2
    //   286: new 93	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   293: ldc_w 1780
    //   296: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: iload 5
    //   301: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   304: ldc_w 1782
    //   307: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: iload 4
    //   312: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   315: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 1194	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: iload 5
    //   323: ifeq +9 -> 332
    //   326: iload 5
    //   328: iconst_1
    //   329: if_icmpne +699 -> 1028
    //   332: aload 13
    //   334: getfield 1783	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   337: invokevirtual 156	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   340: astore 15
    //   342: aload 15
    //   344: ifnonnull +19 -> 363
    //   347: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   350: ifeq -178 -> 172
    //   353: ldc 91
    //   355: iconst_2
    //   356: ldc_w 1785
    //   359: invokestatic 1194	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: return
    //   363: new 139	java/util/ArrayList
    //   366: dup
    //   367: invokespecial 140	java/util/ArrayList:<init>	()V
    //   370: astore 16
    //   372: aload_0
    //   373: aload 15
    //   375: aload 16
    //   377: invokespecial 175	akow:a	(Ljava/util/List;Ljava/util/List;)V
    //   380: aload_0
    //   381: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   384: invokevirtual 147	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   387: invokestatic 186	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   390: lstore 10
    //   392: new 180	awzu
    //   395: dup
    //   396: lload 10
    //   398: lconst_0
    //   399: iconst_1
    //   400: iconst_1
    //   401: iconst_0
    //   402: iconst_0
    //   403: invokespecial 189	awzu:<init>	(JJZZZZ)V
    //   406: astore 17
    //   408: aload 17
    //   410: iconst_1
    //   411: putfield 271	awzu:h	Z
    //   414: new 139	java/util/ArrayList
    //   417: dup
    //   418: invokespecial 140	java/util/ArrayList:<init>	()V
    //   421: astore 13
    //   423: aload 16
    //   425: invokevirtual 278	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   428: astore 18
    //   430: aload 18
    //   432: invokeinterface 283 1 0
    //   437: ifeq +253 -> 690
    //   440: aload 18
    //   442: invokeinterface 287 1 0
    //   447: checkcast 202	msf/msgcomm/msg_comm$Msg
    //   450: astore_2
    //   451: aload_2
    //   452: ifnull +23 -> 475
    //   455: aload_2
    //   456: getfield 206	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   459: invokevirtual 212	msf/msgcomm/msg_comm$MsgHead:has	()Z
    //   462: ifeq +13 -> 475
    //   465: aload_2
    //   466: getfield 485	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   469: invokevirtual 488	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   472: ifne +113 -> 585
    //   475: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   478: ifeq -48 -> 430
    //   481: new 93	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   488: ldc_w 1787
    //   491: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: astore 19
    //   496: aload_2
    //   497: ifnonnull +45 -> 542
    //   500: ldc_w 1789
    //   503: astore_2
    //   504: ldc 91
    //   506: iconst_2
    //   507: aload 19
    //   509: aload_2
    //   510: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   519: goto -89 -> 430
    //   522: astore_2
    //   523: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   526: ifeq -96 -> 430
    //   529: ldc 91
    //   531: iconst_2
    //   532: ldc_w 1791
    //   535: aload_2
    //   536: invokestatic 444	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   539: goto -109 -> 430
    //   542: new 93	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 1793
    //   552: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload_2
    //   556: getfield 206	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   559: invokevirtual 472	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   562: ldc_w 1795
    //   565: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: aload_2
    //   569: getfield 485	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   572: invokevirtual 488	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   575: invokevirtual 838	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   578: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: astore_2
    //   582: goto -78 -> 504
    //   585: aload_2
    //   586: getfield 206	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   589: invokevirtual 211	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   592: checkcast 208	msf/msgcomm/msg_comm$MsgHead
    //   595: astore 19
    //   597: aload 19
    //   599: getfield 220	msf/msgcomm/msg_comm$MsgHead:to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   602: invokevirtual 224	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   605: lstore 6
    //   607: aload 19
    //   609: getfield 227	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   612: invokevirtual 224	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   615: lstore 8
    //   617: lload 6
    //   619: lload 10
    //   621: lcmp
    //   622: ifeq +414 -> 1036
    //   625: lload 8
    //   627: lload 10
    //   629: lcmp
    //   630: ifeq +406 -> 1036
    //   633: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   636: ifeq -206 -> 430
    //   639: ldc 91
    //   641: iconst_2
    //   642: ldc_w 1797
    //   645: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   648: goto -218 -> 430
    //   651: aload 17
    //   653: lload 6
    //   655: putfield 269	awzu:jdField_e_of_type_Long	J
    //   658: aload_0
    //   659: aload_2
    //   660: aload 17
    //   662: invokevirtual 274	akow:a	(Lmsf/msgcomm/msg_comm$Msg;Laxat;)Ljava/util/ArrayList;
    //   665: astore_2
    //   666: aload_2
    //   667: ifnull -237 -> 430
    //   670: aload_2
    //   671: invokevirtual 1508	java/util/ArrayList:isEmpty	()Z
    //   674: ifne -244 -> 430
    //   677: aload 13
    //   679: aload_2
    //   680: invokevirtual 1507	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   683: pop
    //   684: goto -254 -> 430
    //   687: goto -36 -> 651
    //   690: aload 13
    //   692: invokevirtual 197	java/util/ArrayList:size	()I
    //   695: ifle +16 -> 711
    //   698: aload 13
    //   700: new 1799	akpa
    //   703: dup
    //   704: aload_0
    //   705: invokespecial 1800	akpa:<init>	(Lakow;)V
    //   708: invokestatic 992	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   711: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   714: ifeq +63 -> 777
    //   717: ldc 91
    //   719: iconst_2
    //   720: new 93	java/lang/StringBuilder
    //   723: dup
    //   724: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   727: ldc_w 1802
    //   730: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: aload 15
    //   735: invokeinterface 161 1 0
    //   740: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   743: ldc_w 1804
    //   746: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: aload 16
    //   751: invokevirtual 197	java/util/ArrayList:size	()I
    //   754: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   757: ldc_w 1806
    //   760: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: aload 13
    //   765: invokevirtual 197	java/util/ArrayList:size	()I
    //   768: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   771: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   774: invokestatic 1194	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   777: aload_3
    //   778: getfield 1809	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:friends	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   781: invokevirtual 1810	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   784: ifeq +124 -> 908
    //   787: aload_3
    //   788: getfield 1809	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:friends	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   791: invokevirtual 156	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   794: astore_2
    //   795: aload_2
    //   796: ifnull +117 -> 913
    //   799: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   802: ifeq +34 -> 836
    //   805: ldc 91
    //   807: iconst_2
    //   808: new 93	java/lang/StringBuilder
    //   811: dup
    //   812: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   815: ldc_w 1812
    //   818: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: aload_2
    //   822: invokeinterface 161 1 0
    //   827: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   830: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   833: invokestatic 1194	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   836: aload 13
    //   838: invokevirtual 197	java/util/ArrayList:size	()I
    //   841: ifne +126 -> 967
    //   844: iload 5
    //   846: iconst_1
    //   847: if_icmpeq +120 -> 967
    //   850: aload_1
    //   851: getfield 859	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   854: ldc_w 1190
    //   857: invokevirtual 1188	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   860: istore 5
    //   862: iload 5
    //   864: iconst_4
    //   865: if_icmpge +66 -> 931
    //   868: aload_0
    //   869: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   872: invokevirtual 1197	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/MessageHandler;
    //   875: iload 4
    //   877: aconst_null
    //   878: aload_1
    //   879: getfield 859	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   882: ldc_w 1170
    //   885: invokevirtual 1172	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   888: aload_1
    //   889: getfield 859	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   892: ldc_w 1180
    //   895: invokevirtual 864	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   898: aload_2
    //   899: iload 5
    //   901: iconst_1
    //   902: iadd
    //   903: lconst_0
    //   904: invokevirtual 1815	com/tencent/mobileqq/app/MessageHandler:a	(ILjava/util/List;Ljava/lang/String;JLjava/util/List;IJ)V
    //   907: return
    //   908: aconst_null
    //   909: astore_2
    //   910: goto -115 -> 795
    //   913: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   916: ifeq -80 -> 836
    //   919: ldc 91
    //   921: iconst_2
    //   922: ldc_w 1817
    //   925: invokestatic 1194	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   928: goto -92 -> 836
    //   931: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   934: ifeq +12 -> 946
    //   937: ldc 91
    //   939: iconst_2
    //   940: ldc_w 1819
    //   943: invokestatic 1194	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   946: aload 14
    //   948: ldc_w 1821
    //   951: aload_2
    //   952: invokevirtual 1176	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   955: pop
    //   956: aload_0
    //   957: sipush 8015
    //   960: iconst_0
    //   961: aload 14
    //   963: invokevirtual 878	akow:a	(IZLjava/lang/Object;)V
    //   966: return
    //   967: aload 14
    //   969: ldc_w 1821
    //   972: aload_2
    //   973: invokevirtual 1176	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   976: pop
    //   977: aload 14
    //   979: ldc_w 1823
    //   982: aload 13
    //   984: invokevirtual 1176	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   987: pop
    //   988: iload 5
    //   990: iconst_1
    //   991: if_icmpne +31 -> 1022
    //   994: iconst_1
    //   995: istore 12
    //   997: aload 14
    //   999: ldc_w 1825
    //   1002: iload 12
    //   1004: invokestatic 927	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1007: invokevirtual 1176	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1010: pop
    //   1011: aload_0
    //   1012: sipush 8015
    //   1015: iconst_1
    //   1016: aload 14
    //   1018: invokevirtual 878	akow:a	(IZLjava/lang/Object;)V
    //   1021: return
    //   1022: iconst_0
    //   1023: istore 12
    //   1025: goto -28 -> 997
    //   1028: aload_0
    //   1029: aload_1
    //   1030: aload_2
    //   1031: iconst_0
    //   1032: invokespecial 1768	akow:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Z)V
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
    //   0	1051	0	this	akow
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
    //   406	255	17	localawzu	awzu
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
  
  public ArrayList<MessageRecord> a(msg_comm.Msg paramMsg, axat paramaxat)
  {
    if (!(paramaxat instanceof awzu)) {
      return new ArrayList();
    }
    awzu localawzu = (awzu)paramaxat;
    long l4 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    if ((paramMsg == null) || (!paramMsg.msg_head.has()) || (!paramMsg.msg_body.has()))
    {
      if (QLog.isColorLevel())
      {
        paramaxat = new StringBuilder().append("decodeSinglePBMsg_C2C return : ");
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
      paramaxat = (msg_comm.ContentHead)paramMsg.content_head.get();
      i5 = paramaxat.div_seq.get();
      i4 = paramaxat.pkg_num.get();
      i3 = paramaxat.pkg_index.get();
    }
    for (;;)
    {
      long l1 = -1L;
      paramaxat = null;
      label424:
      Object localObject1;
      Object localObject2;
      if (!localawzu.jdField_d_of_type_Boolean)
      {
        paramaxat = axao.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, String.valueOf(localawzu.jdField_e_of_type_Long), String.valueOf(l5));
        if (((Long)paramaxat.first).longValue() != 4294967295L) {
          l1 = ((Long)paramaxat.first).longValue();
        }
      }
      else
      {
        localawzu.jdField_b_of_type_Long = l5;
        localawzu.jdField_c_of_type_Long = l3;
        int i8 = axao.a(paramMsg);
        localawzu.jdField_a_of_type_Int = i8;
        localawzu.jdField_d_of_type_Long = akfw.a((int)l1, i8);
        localawzu.jdField_b_of_type_Int = axao.e(paramMsg);
        if (l5 != localawzu.jdField_a_of_type_Long) {
          break label1134;
        }
        localawzu.jdField_a_of_type_Boolean = true;
        localawzu.f = true;
        if (!QLog.isColorLevel()) {
          break label1154;
        }
        localObject1 = new StringBuilder();
        localObject2 = ((StringBuilder)localObject1).append("<---decodeSinglePBMsg_C2C : decode msg: msgTime:").append(l3).append(" shortSeq:").append(i7).append(" uint32Seq:").append(localMsgHead.msg_seq.get()).append(" msgUid:").append(l6).append(" toUin:").append(l2).append(" senderUin:").append(l5).append(" friendUin:").append(localawzu.jdField_e_of_type_Long).append(" isReaded:").append(localawzu.jdField_a_of_type_Boolean).append(" isSyncFromOtherTerm:").append(localawzu.f).append(" msgType:").append(i6).append(" C2CCmd:").append(i2).append(" hasTemp:").append(localMsgHead.c2c_tmp_msg_head.has()).append(" hasShare:").append(paramMsg.appshare_info.has()).append(" pkgID:");
        if (paramaxat != null) {
          break label1143;
        }
        paramaxat = "nullPair";
        label626:
        ((StringBuilder)localObject2).append(paramaxat).append(" longMsgID:").append(i5).append(" longMsgCount:").append(i4).append(" longMsgIndex:").append(i3).append("init_direction_flag").append(0);
        QLog.d("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject1).toString());
        label687:
        paramaxat = new ArrayList();
        if ((i6 != 140) && (i6 != 141) && ((i6 != 529) || (localMsgHead.c2c_cmd.get() != 6))) {
          break label1238;
        }
        i1 = 1;
        localObject1 = axao.a(paramMsg);
        if (((axau)localObject1).jdField_a_of_type_Int != -1) {
          break label1176;
        }
        n = 0;
        label752:
        if (n == 0) {
          break label1228;
        }
        i2 = ((axau)localObject1).jdField_b_of_type_Int;
        axao.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramaxat, paramMsg, (axau)localObject1, localawzu);
        n = ((axau)localObject1).jdField_a_of_type_Int;
        if ((paramaxat.size() <= 0) || (!amns.a((MessageRecord)paramaxat.get(0)))) {
          break label5364;
        }
        if (!((MessageRecord)paramaxat.get(0)).isSelfConfessor()) {
          break label1231;
        }
        n = 1033;
        label821:
        ((axau)localObject1).jdField_a_of_type_Int = n;
        n = ((axau)localObject1).jdField_a_of_type_Int;
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
          if ((paramaxat.size() == 0) && (i4 > 1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C, empty long msg fragment");
            }
            localObject1 = (MessageForText)axaq.a(-1000);
            ((MessageForText)localObject1).msgtype = -1000;
            ((MessageForText)localObject1).msg = "";
            paramaxat.add(localObject1);
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
              ((MessageRecord)localObject3).selfuin = String.valueOf(localawzu.jdField_a_of_type_Long);
              ((MessageRecord)localObject3).frienduin = String.valueOf(localawzu.jdField_e_of_type_Long);
              ((MessageRecord)localObject3).senderuin = String.valueOf(localawzu.jdField_b_of_type_Long);
              ((MessageRecord)localObject3).time = localawzu.jdField_c_of_type_Long;
              ((MessageRecord)localObject3).shmsgseq = i7;
              ((MessageRecord)localObject3).msgUid = l6;
              ((MessageRecord)localObject3).istroop = i1;
              ((MessageRecord)localObject3).longMsgId = i5;
              ((MessageRecord)localObject3).longMsgCount = i4;
              ((MessageRecord)localObject3).longMsgIndex = i3;
              if ((1 != n) || (!akpy.r(((MessageRecord)localObject3).istroop)) || (akpy.a(((MessageRecord)localObject3).istroop) == 1032) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject3).frienduin)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject3).frienduin, akpy.a(((MessageRecord)localObject3).istroop), akpy.a(akpy.a(((MessageRecord)localObject3).istroop))))) {
                continue;
              }
              akpy.a((MessageRecord)localObject3, true);
              if (((MessageRecord)localObject3).msgtype != -2058) {
                continue;
              }
              EmojiStickerManager.a((MessageRecord)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              if ((!akpy.r(i1)) || (!(localObject3 instanceof MessageForStructing))) {
                continue;
              }
              i2 = akpl.a((MessageRecord)localObject3, 1);
              if (i2 <= 0) {
                continue;
              }
              ((MessageRecord)localObject3).saveExtInfoToExtStr("nearby_gift_msg", "1|" + String.valueOf(i2));
              paramaxat = (MessageForStructing)localObject3;
              if ((paramaxat.structingMsg.mMsgServiceID != 52) || ((akbk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(124) == null)) {
                continue;
              }
              paramaxat = new NearbyFlowerMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaxat);
              if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(paramaxat.sUin)) {
                continue;
              }
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060AF", "0X80060AF", 0, 0, "", "", "", "");
              if (!"4".equals(paramaxat.version)) {
                continue;
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.msg.C2CMessageProcessor", 2, "<---received random chat flower message, don't put it to aio");
              axao.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i7, l6, i6);
              continue;
              akpy.a((MessageRecord)localObject3, false);
              continue;
              if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(paramaxat.rUin)) {
                continue;
              }
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060B0", "0X80060B0", 0, 0, "", "", "", "");
              continue;
              paramaxat = (msg_comm.C2CTmpMsgHead)localMsgHead.c2c_tmp_msg_head.get();
              if ((paramaxat == null) || (!paramaxat.lock_display.has()) || (paramaxat.lock_display.get() != 1)) {
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
              ((ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(String.valueOf(localawzu.jdField_e_of_type_Long), localMsgHead.from_nick.get());
              ((MessageRecord)localObject3).frienduin = bbcl.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(localawzu.jdField_e_of_type_Long));
              ((MessageRecord)localObject3).senderuin = bbcl.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l5));
              if ((!TextUtils.isEmpty(((MessageRecord)localObject3).frienduin)) || (!localawzu.jdField_d_of_type_Boolean)) {
                continue;
              }
              ((MessageRecord)localObject3).frienduin = String.valueOf(localawzu.jdField_e_of_type_Long);
              if (((MessageRecord)localObject3).frienduin != null) {
                continue;
              }
              QLog.e("Q.msg.C2CMessageProcessor", 1, String.format("decodeMessage error, getPhoneNumByUin is null, friendUin: %d senderUin: %d uinType: %d msgType: %d", new Object[] { Long.valueOf(localawzu.jdField_e_of_type_Long), Long.valueOf(l5), Integer.valueOf(((MessageRecord)localObject3).istroop), Integer.valueOf(((MessageRecord)localObject3).msgtype) }));
              continue;
              if (!localawzu.f) {
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
              ((MessageRecord)localObject3).vipBubbleID = localawzu.jdField_d_of_type_Long;
              ((MessageRecord)localObject3).vipBubbleDiyTextId = localawzu.jdField_a_of_type_Int;
              ((MessageRecord)localObject3).vipSubBubbleId = localawzu.jdField_b_of_type_Int;
              if (localawzu.jdField_b_of_type_Int <= 0) {
                continue;
              }
              ((MessageRecord)localObject3).saveExtInfoToExtStr("bubble_sub_id", String.valueOf(localawzu.jdField_b_of_type_Int));
              i2 = axao.c(paramMsg);
              if (i2 <= 0) {
                continue;
              }
              ((MessageRecord)localObject3).saveExtInfoToExtStr("vip_pendant_diy_id", String.valueOf(i2));
              i2 = axao.b(paramMsg);
              if (i2 < 0) {
                continue;
              }
              ((MessageRecord)localObject3).saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(i2));
              i2 = axao.d(paramMsg);
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
                  paramaxat = (MessageForStructing)localObject3;
                  if ((paramaxat.structingMsg != null) && (paramaxat.structingMsg.mMsgServiceID == 76)) {
                    ((ndh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(171)).a(paramaxat);
                  }
                }
                if (((MessageRecord)localObject3).msgtype == -7005)
                {
                  arqn.a((MessageRecord)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                  continue;
                  if (((MessageRecord)localObject3).msgtype == -2037) {
                    continue;
                  }
                  ((MessageRecord)localObject3).isread = localawzu.jdField_a_of_type_Boolean;
                }
              }
              catch (Throwable paramaxat)
              {
                QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeMessage: ", paramaxat);
                continue;
                localArrayList.add(localObject3);
                if (i1 == 1036) {
                  axao.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i7, l6, i6);
                }
              }
              if (((MessageRecord)localObject3).msgtype != -2039) {
                continue;
              }
              Object localObject4 = (MessageForApollo)localObject3;
              airz localairz = (airz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
              paramaxat = null;
              if (!QLog.isColorLevel()) {
                continue;
              }
              paramaxat = new StringBuilder("decode apollo c2c msg: ").append(", id: ").append(((MessageForApollo)localObject4).mApolloMessage.id).append(", name: ").append(new String(((MessageForApollo)localObject4).mApolloMessage.name)).append(", doubleAction: ").append(((MessageForApollo)localObject4).isDoubleAction()).append(", signTS: ").append(((MessageForApollo)localObject4).signTs);
              int i9 = ((MessageForApollo)localObject4).isSend();
              if (((MessageForApollo)localObject4).mApolloMessage.peer_uin == 0L) {
                continue;
              }
              i2 = 1;
              if (((i2 & i9) == 0) || (((MessageForApollo)localObject4).mApolloMessage.peer_uin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())) {
                continue;
              }
              ApolloBaseInfo localApolloBaseInfo = localairz.b(((MessageForApollo)localObject4).mApolloMessage.peer_uin + "");
              l2 = ((MessageForApollo)localObject4).mApolloMessage.peer_ts;
              i2 = ((MessageForApollo)localObject4).mApolloMessage.peer_status;
              if ((!QLog.isColorLevel()) || (localApolloBaseInfo == null)) {
                continue;
              }
              paramaxat.append("\n fuin: ").append(localApolloBaseInfo.uin).append(", msg time: ").append(((MessageRecord)localObject3).time).append(", msg ts: ").append(l2).append(", svr ts: ").append(localApolloBaseInfo.apolloServerTS).append(", update time: ").append(localApolloBaseInfo.apolloUpdateTime).append(", status: ").append(i2);
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
              localairz.a(localApolloBaseInfo);
              if (!QLog.isColorLevel()) {
                continue;
              }
              paramaxat.append("\n save apollo info fuin: ").append(localApolloBaseInfo.uin).append("-->").append(localApolloBaseInfo.apolloVipFlag).append("|").append(localApolloBaseInfo.apolloStatus).append("|").append(localApolloBaseInfo.apolloLocalTS).append("|").append(localApolloBaseInfo.apolloServerTS).append("|").append(localApolloBaseInfo.apolloUpdateTime).append("|").append(localApolloBaseInfo.apolloSignValidTS);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.msg.C2CMessageProcessor", 2, paramaxat.toString());
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
                continue;
              }
              i2 = localairz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
              if (((MessageForApollo)localObject4).msgType != 0) {
                continue;
              }
              paramaxat = String.valueOf(((MessageForApollo)localObject4).mApolloMessage.id);
              VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "rev_action", String.valueOf(((MessageForApollo)localObject4).mApolloMessage.peer_uin), 0, ((MessageForApollo)localObject4).msgType, new String[] { paramaxat, Integer.toString(i2), Integer.toString(airz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)), String.valueOf(System.currentTimeMillis() / 1000L) });
              continue;
              i2 = 0;
              continue;
              localApolloBaseInfo = localairz.b(((MessageForApollo)localObject4).senderuin);
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
              paramaxat = "" + ((MessageForApollo)localObject4).gameId;
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
              paramaxat = (im_msg_body.Elem)paramMsg.next();
              if (!paramaxat.pub_acc_info.has()) {
                continue;
              }
              n = paramaxat.pub_acc_info.uint32_is_inter_num.get();
              paramMsg = paramaxat.pub_acc_info.string_msg_template_id.get();
              if (n == 0) {
                continue;
              }
              paramaxat = localArrayList.iterator();
              if (!paramaxat.hasNext()) {
                continue;
              }
              ((MessageRecord)paramaxat.next()).saveExtInfoToExtStr("inter_num", String.valueOf(n));
              continue;
              paramaxat = localArrayList.iterator();
              if (!paramaxat.hasNext()) {
                continue;
              }
              ((MessageRecord)paramaxat.next()).saveExtInfoToExtStr("msg_template_id", paramMsg);
              continue;
              bfmu.a().f(System.currentTimeMillis() - l4);
              i1 = 0;
              paramMsg = localArrayList.iterator();
              n = 0;
              if (!paramMsg.hasNext()) {
                continue;
              }
              paramaxat = (MessageRecord)paramMsg.next();
              i1 = paramaxat.istroop;
              if (paramaxat.isread) {
                continue;
              }
              n += 1;
              continue;
              axqd.a(0, 1, i1, n);
              return localArrayList;
              continue;
              paramaxat = "";
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
          l1 = ((Long)paramaxat.second).longValue();
          break;
          localawzu.f = false;
          break label424;
          label1143:
          paramaxat = (Serializable)paramaxat.first;
          break label626;
          if (localawzu.jdField_e_of_type_Long != 0L) {
            break label687;
          }
          QLog.e("Q.msg.C2CMessageProcessor", 1, "<---decodeSinglePBMsg_C2C : decode msg: frienduin=0");
          break label687;
          if ((((axau)localObject1).jdField_a_of_type_Int != 1000) && (((axau)localObject1).jdField_a_of_type_Int != 1020))
          {
            n = i1;
            if (((axau)localObject1).jdField_a_of_type_Int != 1004) {
              break label752;
            }
          }
          localawzu.jdField_b_of_type_Long = ((axau)localObject1).jdField_b_of_type_Long;
          n = i1;
          break label752;
          return localArrayList;
          n = 1034;
          break label821;
          if (paramMsg.appshare_info.has())
          {
            axao.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramaxat, paramMsg, 0L, 0L, localawzu.jdField_d_of_type_Boolean);
            n = 0;
          }
          else
          {
            if ((axas.c(i6)) && (localMsgHead.c2c_cmd.has())) {}
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
              l1 = localawzu.jdField_e_of_type_Long;
              bool1 = localawzu.jdField_a_of_type_Boolean;
              bool2 = localawzu.jdField_b_of_type_Boolean;
              if (l5 == localawzu.jdField_a_of_type_Long) {}
              for (i9 = 1;; i9 = 0)
              {
                axao.a((MessageHandler)localObject1, paramaxat, i2, paramMsg, l1, bool1, bool2, i9, localawzu.jdField_d_of_type_Long, localawzu.jdField_d_of_type_Boolean, localawzu.jdField_a_of_type_Int);
                n = 0;
                break;
              }
            case 11: 
            case 175: 
              axao.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramaxat, paramMsg, localawzu.jdField_e_of_type_Long, localawzu.jdField_b_of_type_Boolean, localawzu.jdField_a_of_type_Boolean, localawzu.jdField_d_of_type_Boolean);
              n = 0;
              break;
            case 193: 
              n = 0;
              break;
            case 129: 
            case 131: 
            case 133: 
              axao.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localawzu.jdField_e_of_type_Long, localawzu.jdField_a_of_type_Boolean, localawzu.jdField_b_of_type_Boolean, localawzu.jdField_d_of_type_Long, localawzu.jdField_a_of_type_Int);
              n = 0;
              continue;
              if (i6 == 208)
              {
                axao.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramaxat, paramMsg);
                n = 0;
              }
              else
              {
                if (i6 == 193)
                {
                  if (!localawzu.jdField_d_of_type_Boolean)
                  {
                    axao.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localawzu);
                    n = 0;
                  }
                }
                else
                {
                  if (i6 == 734)
                  {
                    axao.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localawzu);
                    n = 0;
                    continue;
                  }
                  if (i6 == 562)
                  {
                    axao.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localawzu);
                    n = 0;
                    continue;
                  }
                  if (i6 == 519)
                  {
                    if ((!localawzu.jdField_d_of_type_Boolean) && (ldi.jdField_a_of_type_Boolean))
                    {
                      axao.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localawzu.jdField_a_of_type_Boolean, localawzu.f);
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
                      if ((!localawzu.jdField_c_of_type_Boolean) && (n == 0)) {
                        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(2);
                      }
                      localawzu.jdField_e_of_type_Long = 9998L;
                      axao.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localawzu.jdField_a_of_type_Boolean, localawzu.f, localawzu.jdField_d_of_type_Boolean, i7);
                      axao.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i7, l6, i6);
                      return localArrayList;
                    }
                    if (a(i6))
                    {
                      a(paramaxat, paramMsg, localawzu.jdField_d_of_type_Boolean);
                      n = 0;
                      continue;
                    }
                    if (732 == i6)
                    {
                      a(paramaxat, paramMsg, i7, l5, l6, i6, localawzu.jdField_d_of_type_Boolean);
                      n = 0;
                      continue;
                    }
                    if (524 == i6)
                    {
                      if ((paramaxat == null) || (paramMsg == null) || (!paramMsg.msg_body.has()) || (!paramMsg.msg_body.msg_content.has())) {
                        return localArrayList;
                      }
                      localObject1 = paramMsg.msg_body.msg_content.get().toByteArray();
                      bbmj.a((byte[])localObject1, 0);
                      n = localObject1[4];
                      if (n == 25) {
                        if (!localawzu.jdField_d_of_type_Boolean) {
                          akpj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte[])localObject1, 5, null, false);
                        }
                      }
                      for (;;)
                      {
                        n = 0;
                        break;
                        if (n == 35)
                        {
                          QLog.i("ApolloPushManager", 1, "[discuss.OffLine]");
                          if (!localawzu.jdField_d_of_type_Boolean) {
                            akpj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte[])localObject1, 5, null, false);
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
                      if ((!localawzu.jdField_c_of_type_Boolean) && (n == 0)) {
                        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(3, 1, false);
                      }
                      localawzu.jdField_e_of_type_Long = 9998L;
                      axao.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localawzu.jdField_a_of_type_Boolean, localawzu.f, localawzu.jdField_d_of_type_Boolean);
                      if (n == 0) {
                        aydb.a().a(l5, l3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                      }
                      return localArrayList;
                    }
                    if (i6 == 528)
                    {
                      if (!localawzu.jdField_d_of_type_Boolean)
                      {
                        axao.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, localawzu.jdField_a_of_type_Long, paramMsg, localawzu.h, localawzu.jdField_d_of_type_Boolean);
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
                          localObject1 = axao.a(paramMsg);
                          if (((axau)localObject1).jdField_a_of_type_Int == -1)
                          {
                            n = 0;
                            if (n == 0) {
                              break label5359;
                            }
                            axao.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramaxat, paramMsg, (axau)localObject1, localawzu);
                            n = ((axau)localObject1).jdField_a_of_type_Int;
                            if ((paramaxat.size() <= 0) || (!amns.a((MessageRecord)paramaxat.get(0)))) {
                              break label5356;
                            }
                            if (!((MessageRecord)paramaxat.get(0)).isSelfConfessor()) {
                              break label2471;
                            }
                            n = 1033;
                            ((axau)localObject1).jdField_a_of_type_Int = n;
                            n = ((axau)localObject1).jdField_a_of_type_Int;
                            i1 = n;
                            if (n == 1006)
                            {
                              QLog.e("Q.msg.C2CMessageProcessor", 1, "decodeMessage FileMsg, tempInfo has Uin [" + ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).from_phone.has() + "]");
                              i1 = n;
                            }
                            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
                            l1 = localawzu.jdField_e_of_type_Long;
                            bool1 = localawzu.jdField_a_of_type_Boolean;
                            bool2 = localawzu.jdField_b_of_type_Boolean;
                            if (l5 != localawzu.jdField_a_of_type_Long) {
                              break label2627;
                            }
                          }
                        }
                        for (i9 = 1;; i9 = 0)
                        {
                          axao.a((MessageHandler)localObject1, paramaxat, paramMsg, l1, bool1, bool2, i9, localawzu.jdField_d_of_type_Long, localawzu.jdField_d_of_type_Boolean, localawzu.jdField_a_of_type_Int);
                          n = 0;
                          break;
                          if ((((axau)localObject1).jdField_a_of_type_Int != 1000) && (((axau)localObject1).jdField_a_of_type_Int != 1020))
                          {
                            n = i1;
                            if (((axau)localObject1).jdField_a_of_type_Int != 1004) {
                              break label2200;
                            }
                          }
                          localawzu.jdField_b_of_type_Long = ((axau)localObject1).jdField_b_of_type_Long;
                          n = i1;
                          break label2200;
                          n = 1034;
                          break label2262;
                          localObject1 = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                          if (myy.a(BaseApplicationImpl.getContext(), String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get())))
                          {
                            i1 = n;
                            if (((ajxn)localObject1).b(String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get()))) {
                              break label2343;
                            }
                            i1 = 1025;
                            break label2343;
                          }
                          i1 = n;
                          if (!myy.a(BaseApplicationImpl.getContext(), String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get()))) {
                            break label2343;
                          }
                          i1 = n;
                          if (((ajxn)localObject1).b(String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get()))) {
                            break label2343;
                          }
                          i1 = 1025;
                          break label2343;
                        }
                      }
                      if (i6 == 38)
                      {
                        localObject1 = String.valueOf(baxb.a(paramMsg.msg_body.msg_content.get().toByteArray()));
                        localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                        if ((localObject2 != null) && (((TroopManager)localObject2).b((String)localObject1) == null))
                        {
                          localObject3 = new TroopInfo();
                          ((TroopInfo)localObject3).troopuin = ((String)localObject1);
                          ((TroopInfo)localObject3).troopcode = ((String)localObject1);
                          ((TroopInfo)localObject3).dwAdditionalFlag = 1L;
                          ((TroopManager)localObject2).b((TroopInfo)localObject3);
                        }
                        localObject2 = (akhq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
                        if (localObject2 != null) {
                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(getClass()).postDelayed(new C2CMessageProcessor.2(this, (akhq)localObject2, (String)localObject1), 2000L);
                        }
                        axao.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i7, l6, i6);
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
        localObject2 = paramaxat.iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label5065;
          }
          localObject3 = (MessageRecord)((Iterator)localObject2).next();
          if ((localObject3 != null) && ((localawzu.jdField_b_of_type_Long != 3338705755L) || (!sgj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) && ((localawzu.jdField_b_of_type_Long != 2171946401L) || (!onk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))))
          {
            if (localawzu.jdField_b_of_type_Long == 2171946401L) {
              sgj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
            }
            if (((i1 != 1025) && (i1 != 1024)) || (((MessageRecord)localObject3).msgtype != -1000) || (!((MessageRecord)localObject3).msg.startsWith("default:SigT=")))
            {
              if (akpy.a(i1) != 1032) {
                break;
              }
              localObject1 = null;
              paramaxat = (axat)localObject1;
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
              {
                localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                paramaxat = (axat)localObject1;
                if (localObject4 != null) {
                  paramaxat = ((awzw)localObject4).a(String.valueOf(localawzu.jdField_e_of_type_Long), String.valueOf(localawzu.jdField_a_of_type_Long));
                }
              }
              axao.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i7, l6, i6, paramaxat);
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
              bbmj.a((byte[])localObject, 0, arrayOfByte1, 0, localObject.length);
            } while (localObject.length < 5);
            n = localObject[4];
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "<---hotchat and opentroop push  groupCode:" + bbmj.a(arrayOfByte1, 0) + " subType:" + n);
            }
            if ((n != 12) && (n != 14)) {
              break;
            }
          } while (!((bakk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a((byte[])localObject, paramInt1));
          axao.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramLong1, paramInt1, paramLong2, paramInt2);
          return;
          if ((n != 16) && (n != 17) && (n != 20)) {
            break;
          }
          localObject = new akpb(this);
          if (arrayOfByte1.length > 7)
          {
            bamj localbamj = (bamj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(81);
            byte[] arrayOfByte2 = new byte[arrayOfByte1.length - 7];
            bbmj.a(arrayOfByte2, 0, arrayOfByte1, 7, arrayOfByte2.length);
            paramArrayList.add(localbamj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, arrayOfByte2, paramInt1, paramMsg.msg_head.msg_time.get(), true, paramBoolean, (akpb)localObject));
          }
        } while (!((akpb)localObject).jdField_a_of_type_Boolean);
        axao.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramLong1, paramInt1, paramLong2, paramInt2);
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
    //   5: invokevirtual 197	java/util/ArrayList:size	()I
    //   8: ifne +4 -> 12
    //   11: return
    //   12: invokestatic 2551	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   15: aload_0
    //   16: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: invokevirtual 147	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   22: invokestatic 2554	com/tencent/mobileqq/activity/UserguideActivity:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   25: ifne -14 -> 11
    //   28: invokestatic 2551	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   31: invokevirtual 2555	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   34: aload_0
    //   35: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   38: invokestatic 2560	bazk:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)Z
    //   41: ifeq -30 -> 11
    //   44: aload_1
    //   45: invokevirtual 278	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   48: astore 7
    //   50: aload 7
    //   52: invokeinterface 283 1 0
    //   57: ifeq +1587 -> 1644
    //   60: aload 7
    //   62: invokeinterface 287 1 0
    //   67: checkcast 289	com/tencent/mobileqq/data/MessageRecord
    //   70: astore 8
    //   72: aload 8
    //   74: getfield 301	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   77: invokestatic 2158	akpy:r	(I)Z
    //   80: ifeq -30 -> 50
    //   83: aload 8
    //   85: invokestatic 2561	akpy:d	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   88: ifeq -38 -> 50
    //   91: aload_0
    //   92: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   95: aload 8
    //   97: invokestatic 2564	akpy:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   100: ifne -50 -> 50
    //   103: aload 8
    //   105: invokevirtual 2236	com/tencent/mobileqq/data/MessageRecord:isSend	()Z
    //   108: ifne -58 -> 50
    //   111: aload 8
    //   113: getfield 1314	com/tencent/mobileqq/data/MessageRecord:isread	Z
    //   116: ifne -66 -> 50
    //   119: iconst_1
    //   120: istore_3
    //   121: iload_3
    //   122: ifeq -111 -> 11
    //   125: aload_0
    //   126: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   129: bipush 51
    //   131: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   134: checkcast 994	ajxn
    //   137: aload_0
    //   138: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   141: invokevirtual 147	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   144: invokevirtual 2567	ajxn:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   147: astore 7
    //   149: aload_0
    //   150: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   153: invokevirtual 124	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   156: astore 10
    //   158: aload 7
    //   160: ifnonnull +566 -> 726
    //   163: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +1472 -> 1638
    //   169: ldc 91
    //   171: iconst_2
    //   172: ldc_w 2569
    //   175: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: iconst_1
    //   179: istore 4
    //   181: aload_0
    //   182: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   185: bipush 106
    //   187: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   190: checkcast 2571	aszd
    //   193: invokevirtual 2572	aszd:a	()Z
    //   196: istore 6
    //   198: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +42 -> 243
    //   204: ldc_w 2574
    //   207: iconst_2
    //   208: new 93	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 2576
    //   218: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: iload 4
    //   223: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: ldc_w 2578
    //   229: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: iload 6
    //   234: invokevirtual 838	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   237: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload_0
    //   244: getfield 2579	akow:jdField_a_of_type_Boolean	Z
    //   247: ifne +293 -> 540
    //   250: invokestatic 2584	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   253: getstatic 2590	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:OneyWayDateMsgNotifyCfg	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   256: invokevirtual 2592	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   259: invokevirtual 2594	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   262: astore 8
    //   264: invokestatic 2584	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   267: getstatic 2597	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:OneyWayLBSFriendMsgNotifyCfg	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   270: invokevirtual 2592	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   273: invokevirtual 2594	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   276: astore 7
    //   278: aload 8
    //   280: ldc_w 2599
    //   283: invokevirtual 2603	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   286: astore 8
    //   288: aload 7
    //   290: ldc_w 2599
    //   293: invokevirtual 2603	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   319: invokestatic 1618	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   322: putfield 38	akow:d	I
    //   325: aload_0
    //   326: aload 8
    //   328: iconst_1
    //   329: aaload
    //   330: invokestatic 1618	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   333: putfield 40	akow:e	I
    //   336: aload_0
    //   337: aload 8
    //   339: iconst_2
    //   340: aaload
    //   341: invokestatic 1618	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   344: putfield 42	akow:f	I
    //   347: aload_0
    //   348: aload 8
    //   350: iconst_3
    //   351: aaload
    //   352: invokestatic 1618	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   355: putfield 44	akow:g	I
    //   358: aload_0
    //   359: aload 7
    //   361: iconst_0
    //   362: aaload
    //   363: invokestatic 1618	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   366: putfield 46	akow:i	I
    //   369: aload_0
    //   370: aload 7
    //   372: iconst_1
    //   373: aaload
    //   374: invokestatic 1618	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   377: putfield 48	akow:j	I
    //   380: aload_0
    //   381: aload 7
    //   383: iconst_2
    //   384: aaload
    //   385: invokestatic 1618	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   388: putfield 50	akow:k	I
    //   391: aload_0
    //   392: aload 7
    //   394: iconst_3
    //   395: aaload
    //   396: invokestatic 1618	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   399: putfield 52	akow:l	I
    //   402: invokestatic 2606	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   405: ifeq +130 -> 535
    //   408: ldc_w 2608
    //   411: iconst_4
    //   412: new 93	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   419: ldc_w 2610
    //   422: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload_0
    //   426: getfield 38	akow:d	I
    //   429: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   432: ldc_w 2366
    //   435: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload_0
    //   439: getfield 40	akow:e	I
    //   442: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: ldc_w 2366
    //   448: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload_0
    //   452: getfield 42	akow:f	I
    //   455: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   458: ldc_w 2366
    //   461: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload_0
    //   465: getfield 44	akow:g	I
    //   468: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   471: ldc_w 2612
    //   474: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload_0
    //   478: getfield 46	akow:i	I
    //   481: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   484: ldc_w 2366
    //   487: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload_0
    //   491: getfield 48	akow:j	I
    //   494: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   497: ldc_w 2366
    //   500: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: aload_0
    //   504: getfield 50	akow:k	I
    //   507: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   510: ldc_w 2366
    //   513: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_0
    //   517: getfield 52	akow:l	I
    //   520: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   523: ldc_w 2059
    //   526: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   535: aload_0
    //   536: iconst_1
    //   537: putfield 2579	akow:jdField_a_of_type_Boolean	Z
    //   540: invokestatic 2551	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   543: new 93	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   550: aload_0
    //   551: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   554: invokevirtual 147	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   557: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: ldc_w 2614
    //   563: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: iconst_0
    //   570: invokevirtual 2618	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   573: astore 11
    //   575: ldc_w 420
    //   578: astore 8
    //   580: ldc_w 420
    //   583: astore 9
    //   585: aload 8
    //   587: astore 7
    //   589: aload_0
    //   590: getfield 54	akow:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   593: ifnonnull +145 -> 738
    //   596: aload_0
    //   597: monitorenter
    //   598: aload 8
    //   600: astore 7
    //   602: aload_0
    //   603: getfield 54	akow:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   606: ifnonnull +130 -> 736
    //   609: aload_0
    //   610: new 29	java/util/HashSet
    //   613: dup
    //   614: invokespecial 32	java/util/HashSet:<init>	()V
    //   617: putfield 54	akow:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   620: aload 11
    //   622: new 93	java/lang/StringBuilder
    //   625: dup
    //   626: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   629: aload_0
    //   630: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   633: invokevirtual 147	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   636: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: ldc_w 2620
    //   642: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: ldc_w 420
    //   651: invokeinterface 2625 3 0
    //   656: astore 8
    //   658: aload 8
    //   660: ldc_w 2599
    //   663: invokevirtual 2603	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   693: invokevirtual 755	java/lang/String:length	()I
    //   696: ifle +23 -> 719
    //   699: aload 7
    //   701: invokestatic 186	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   704: lconst_0
    //   705: lcmp
    //   706: ifle +13 -> 719
    //   709: aload_0
    //   710: getfield 54	akow:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   713: aload 7
    //   715: invokevirtual 2626	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   718: pop
    //   719: iload_3
    //   720: iconst_1
    //   721: iadd
    //   722: istore_3
    //   723: goto -48 -> 675
    //   726: aload 7
    //   728: getfield 2631	com/tencent/mobileqq/data/Card:shGender	S
    //   731: istore 4
    //   733: goto -552 -> 181
    //   736: aload_0
    //   737: monitorexit
    //   738: aload 9
    //   740: astore 8
    //   742: aload_0
    //   743: getfield 56	akow:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   746: ifnonnull +140 -> 886
    //   749: aload_0
    //   750: monitorenter
    //   751: aload 9
    //   753: astore 8
    //   755: aload_0
    //   756: getfield 56	akow:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   759: ifnonnull +125 -> 884
    //   762: aload_0
    //   763: new 29	java/util/HashSet
    //   766: dup
    //   767: invokespecial 32	java/util/HashSet:<init>	()V
    //   770: putfield 56	akow:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   773: aload 11
    //   775: new 93	java/lang/StringBuilder
    //   778: dup
    //   779: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   782: aload_0
    //   783: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   786: invokevirtual 147	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   789: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: ldc_w 2633
    //   795: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   801: ldc_w 420
    //   804: invokeinterface 2625 3 0
    //   809: astore 9
    //   811: aload 9
    //   813: ldc_w 2599
    //   816: invokevirtual 2603	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   846: invokevirtual 755	java/lang/String:length	()I
    //   849: ifle +23 -> 872
    //   852: aload 8
    //   854: invokestatic 186	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   857: lconst_0
    //   858: lcmp
    //   859: ifle +13 -> 872
    //   862: aload_0
    //   863: getfield 56	akow:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   866: aload 8
    //   868: invokevirtual 2626	java/util/HashSet:add	(Ljava/lang/Object;)Z
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
    //   887: invokevirtual 278	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   890: astore 12
    //   892: aload 8
    //   894: astore_1
    //   895: aload 12
    //   897: invokeinterface 283 1 0
    //   902: ifeq -891 -> 11
    //   905: aload 12
    //   907: invokeinterface 287 1 0
    //   912: checkcast 289	com/tencent/mobileqq/data/MessageRecord
    //   915: astore 13
    //   917: aload_1
    //   918: astore 9
    //   920: aload_0
    //   921: aload 13
    //   923: invokevirtual 2634	akow:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   926: ifeq +641 -> 1567
    //   929: aload_1
    //   930: astore 9
    //   932: aload 10
    //   934: ifnull +633 -> 1567
    //   937: aload 13
    //   939: getfield 301	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   942: sipush 1010
    //   945: if_icmpne +340 -> 1285
    //   948: aload 7
    //   950: astore 8
    //   952: aload_0
    //   953: getfield 54	akow:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   956: aload 13
    //   958: getfield 343	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   961: invokevirtual 2635	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   964: ifne +89 -> 1053
    //   967: aload_0
    //   968: getfield 54	akow:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   971: aload 13
    //   973: getfield 343	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   976: invokevirtual 2626	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   979: pop
    //   980: aload 7
    //   982: invokevirtual 755	java/lang/String:length	()I
    //   985: ifne +237 -> 1222
    //   988: aload 13
    //   990: getfield 343	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   993: astore 7
    //   995: aload 11
    //   997: invokeinterface 2639 1 0
    //   1002: new 93	java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1009: aload_0
    //   1010: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1013: invokevirtual 147	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1016: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: ldc_w 2620
    //   1022: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1028: aload 7
    //   1030: invokeinterface 2644 3 0
    //   1035: pop
    //   1036: aload 11
    //   1038: invokeinterface 2639 1 0
    //   1043: invokeinterface 2647 1 0
    //   1048: pop
    //   1049: aload 7
    //   1051: astore 8
    //   1053: iload 4
    //   1055: ifne +209 -> 1264
    //   1058: iload 6
    //   1060: ifeq +196 -> 1256
    //   1063: aload_0
    //   1064: getfield 42	akow:f	I
    //   1067: istore_3
    //   1068: aload_0
    //   1069: aload_0
    //   1070: getfield 54	akow:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1073: invokevirtual 2648	java/util/HashSet:size	()I
    //   1076: putfield 2650	akow:h	I
    //   1079: aload_0
    //   1080: getfield 2650	akow:h	I
    //   1083: iload_3
    //   1084: irem
    //   1085: ifne +113 -> 1198
    //   1088: aload_0
    //   1089: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1092: aload 13
    //   1094: iload_2
    //   1095: invokevirtual 2651	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/MessageRecord;Z)V
    //   1098: aload_0
    //   1099: getfield 54	akow:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1102: invokevirtual 2652	java/util/HashSet:clear	()V
    //   1105: aload 11
    //   1107: invokeinterface 2639 1 0
    //   1112: new 93	java/lang/StringBuilder
    //   1115: dup
    //   1116: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1119: aload_0
    //   1120: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1123: invokevirtual 147	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1126: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: ldc_w 2620
    //   1132: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1138: invokeinterface 2655 2 0
    //   1143: pop
    //   1144: aload 11
    //   1146: invokeinterface 2639 1 0
    //   1151: invokeinterface 2647 1 0
    //   1156: pop
    //   1157: iload 6
    //   1159: ifeq +39 -> 1198
    //   1162: aload_0
    //   1163: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1166: ldc_w 448
    //   1169: ldc_w 420
    //   1172: ldc_w 420
    //   1175: ldc_w 2657
    //   1178: ldc_w 2657
    //   1181: iconst_0
    //   1182: iconst_0
    //   1183: ldc_w 420
    //   1186: ldc_w 420
    //   1189: ldc_w 420
    //   1192: ldc_w 420
    //   1195: invokestatic 455	axqw:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
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
    //   1222: new 93	java/lang/StringBuilder
    //   1225: dup
    //   1226: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1229: aload 7
    //   1231: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: ldc_w 2366
    //   1237: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: aload 13
    //   1242: getfield 343	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1245: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1251: astore 7
    //   1253: goto -258 -> 995
    //   1256: aload_0
    //   1257: getfield 38	akow:d	I
    //   1260: istore_3
    //   1261: goto -193 -> 1068
    //   1264: iload 6
    //   1266: ifeq +11 -> 1277
    //   1269: aload_0
    //   1270: getfield 44	akow:g	I
    //   1273: istore_3
    //   1274: goto -206 -> 1068
    //   1277: aload_0
    //   1278: getfield 40	akow:e	I
    //   1281: istore_3
    //   1282: goto -214 -> 1068
    //   1285: aload 13
    //   1287: getfield 301	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   1290: sipush 1001
    //   1293: if_icmpeq +17 -> 1310
    //   1296: aload_1
    //   1297: astore 9
    //   1299: aload 13
    //   1301: getfield 301	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   1304: sipush 10002
    //   1307: if_icmpne +260 -> 1567
    //   1310: aload_1
    //   1311: astore 8
    //   1313: aload_0
    //   1314: getfield 56	akow:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1317: aload 13
    //   1319: getfield 343	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1322: invokevirtual 2635	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   1325: ifne +85 -> 1410
    //   1328: aload_0
    //   1329: getfield 56	akow:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1332: aload 13
    //   1334: getfield 343	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1337: invokevirtual 2626	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1340: pop
    //   1341: aload_1
    //   1342: invokevirtual 755	java/lang/String:length	()I
    //   1345: ifne +232 -> 1577
    //   1348: aload 13
    //   1350: getfield 343	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1353: astore_1
    //   1354: aload 11
    //   1356: invokeinterface 2639 1 0
    //   1361: new 93	java/lang/StringBuilder
    //   1364: dup
    //   1365: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1368: aload_0
    //   1369: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1372: invokevirtual 147	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1375: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: ldc_w 2633
    //   1381: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1384: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1387: aload_1
    //   1388: invokeinterface 2644 3 0
    //   1393: pop
    //   1394: aload 11
    //   1396: invokeinterface 2639 1 0
    //   1401: invokeinterface 2647 1 0
    //   1406: pop
    //   1407: aload_1
    //   1408: astore 8
    //   1410: iload 4
    //   1412: ifne +205 -> 1617
    //   1415: iload 6
    //   1417: ifeq +192 -> 1609
    //   1420: aload_0
    //   1421: getfield 50	akow:k	I
    //   1424: istore_3
    //   1425: aload_0
    //   1426: aload_0
    //   1427: getfield 56	akow:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1430: invokevirtual 2648	java/util/HashSet:size	()I
    //   1433: putfield 2659	akow:m	I
    //   1436: aload 8
    //   1438: astore 9
    //   1440: aload_0
    //   1441: getfield 2659	akow:m	I
    //   1444: iload_3
    //   1445: irem
    //   1446: ifne +121 -> 1567
    //   1449: aload_0
    //   1450: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1453: aload 13
    //   1455: iload_2
    //   1456: invokevirtual 2651	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/MessageRecord;Z)V
    //   1459: aload_0
    //   1460: getfield 56	akow:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1463: invokevirtual 2652	java/util/HashSet:clear	()V
    //   1466: aload 11
    //   1468: invokeinterface 2639 1 0
    //   1473: new 93	java/lang/StringBuilder
    //   1476: dup
    //   1477: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1480: aload_0
    //   1481: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1484: invokevirtual 147	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1487: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: ldc_w 2633
    //   1493: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1496: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1499: invokeinterface 2655 2 0
    //   1504: pop
    //   1505: aload 11
    //   1507: invokeinterface 2639 1 0
    //   1512: invokeinterface 2647 1 0
    //   1517: pop
    //   1518: aload 8
    //   1520: astore 9
    //   1522: iload 6
    //   1524: ifeq +43 -> 1567
    //   1527: aload_0
    //   1528: getfield 119	akow:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1531: ldc_w 448
    //   1534: ldc_w 420
    //   1537: ldc_w 420
    //   1540: ldc_w 2657
    //   1543: ldc_w 2657
    //   1546: iconst_0
    //   1547: iconst_0
    //   1548: ldc_w 420
    //   1551: ldc_w 420
    //   1554: ldc_w 420
    //   1557: ldc_w 420
    //   1560: invokestatic 455	axqw:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1563: aload 8
    //   1565: astore 9
    //   1567: aload 7
    //   1569: astore_1
    //   1570: aload 9
    //   1572: astore 7
    //   1574: goto -370 -> 1204
    //   1577: new 93	java/lang/StringBuilder
    //   1580: dup
    //   1581: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1584: aload_1
    //   1585: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1588: ldc_w 2366
    //   1591: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1594: aload 13
    //   1596: getfield 343	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1599: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1605: astore_1
    //   1606: goto -252 -> 1354
    //   1609: aload_0
    //   1610: getfield 46	akow:i	I
    //   1613: istore_3
    //   1614: goto -189 -> 1425
    //   1617: iload 6
    //   1619: ifeq +11 -> 1630
    //   1622: aload_0
    //   1623: getfield 52	akow:l	I
    //   1626: istore_3
    //   1627: goto -202 -> 1425
    //   1630: aload_0
    //   1631: getfield 48	akow:j	I
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
    //   0	1649	0	this	akow
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
    long l1 = bbbd.a(paramMsg, 0);
    int n = paramMsg[4];
    String str = String.valueOf(bbbd.a(paramMsg, 5));
    n = paramMsg[9];
    long l2 = bbbd.a(paramMsg, 10);
    int i1 = paramMsg[14];
    try
    {
      new String(paramMsg, 15, i1, "GBK");
      if (!paramBoolean)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, n, str, String.valueOf(l2), l1, paramList.msg_time.get(), paramList.msg_seq.get(), paramList);
        ((akhq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(l1 + "", str, paramList.auth_nick.get());
        paramMsg = new ArrayList();
        paramMsg.add(new Pair(Long.valueOf(paramList.from_uin.get()), Long.valueOf(paramList.msg_time.get())));
        ((akow)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("c2c_processor")).a(paramMsg);
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
    while (((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) || (((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002)) && ((paramMessageRecord.msgtype == -3001) || (!akpy.d(paramMessageRecord)) || (akpy.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord))))) {
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
    } while ((localMessageRecord.isSend()) || (localMessageRecord.isread) || ((akpy.d(localMessageRecord)) && (!akpy.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord))) || (FriendsStatusUtil.a(localMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (!ahjz.a(localMessageRecord.frienduin)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akow
 * JD-Core Version:    0.7.0.1
 */