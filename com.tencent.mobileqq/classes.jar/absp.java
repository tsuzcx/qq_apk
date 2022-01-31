import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.Apollo3DMessage;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.Attr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.ExtraInfo;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.GroupBusinessMsg;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.msg.im_msg_body.RichText;

public class absp
  extends absm
{
  protected Comparator a;
  
  public absp(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_JavaUtilComparator = new absr(this);
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
      if ((paramMessageRecord == null) || ((!"com.tencent.homeworkContent".equals(paramMessageRecord.appName)) && (!"com.tencent.test.homeworkContent".equals(paramMessageRecord.appName)))) {}
    }
    else
    {
      do
      {
        return true;
        if (!(paramMessageRecord instanceof MessageForStructing)) {
          break;
        }
        paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
      } while ((paramMessageRecord != null) && (paramMessageRecord.mMsgServiceID == 60));
    }
    return false;
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForArkApp)) && ("com.tencent.qqopen.teamup".equals(((MessageForArkApp)paramMessageRecord).ark_app_message.appName));
  }
  
  private boolean c(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = (MessageForArkApp)paramMessageRecord;
      bool1 = bool2;
      if (paramMessageRecord.ark_app_message != null)
      {
        bool1 = bool2;
        if (anly.a(paramMessageRecord.ark_app_message.appName)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected TroopMemberInfo a(msg_comm.Msg paramMsg, ArrayList<MessageRecord> paramArrayList, azai paramazai, boolean paramBoolean, bbpd parambbpd)
  {
    long l5;
    Object localObject7;
    long l6;
    long l3;
    long l2;
    long l7;
    Object localObject8;
    Object localObject2;
    int m;
    int k;
    int j;
    long l1;
    try
    {
      l5 = System.currentTimeMillis();
      if ((paramazai == null) || (paramMsg == null) || (paramArrayList == null)) {
        break label8064;
      }
      localObject7 = (msg_comm.MsgHead)paramMsg.msg_head.get();
      l6 = ((msg_comm.MsgHead)localObject7).from_uin.get();
      ((msg_comm.MsgHead)localObject7).to_uin.get();
      l3 = ((msg_comm.MsgHead)localObject7).msg_seq.get();
      l2 = ((msg_comm.MsgHead)localObject7).msg_time.get();
      l7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
      localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (paramazai.c == 1026)
      {
        l3 = bdeu.a(((msg_comm.MsgHead)localObject7).msg_seq.get());
        l2 = bdeu.a(((msg_comm.MsgHead)localObject7).msg_time.get());
      }
      if (!paramMsg.content_head.has()) {
        break label8052;
      }
      localObject2 = (msg_comm.ContentHead)paramMsg.content_head.get();
      m = ((msg_comm.ContentHead)localObject2).div_seq.get();
      k = ((msg_comm.ContentHead)localObject2).pkg_num.get();
      j = ((msg_comm.ContentHead)localObject2).pkg_index.get();
      localObject2 = azad.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, String.valueOf(l6), String.valueOf(l6));
      if (((Long)((Pair)localObject2).first).longValue() == 4294967295L) {
        break label1037;
      }
      l1 = ((Long)((Pair)localObject2).first).longValue();
    }
    catch (Throwable paramMsg)
    {
      label233:
      if (!QLog.isColorLevel()) {
        break label1035;
      }
      QLog.e("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis failure : ", paramMsg);
      return null;
    }
    Object localObject3 = new ArrayList();
    bbpd localbbpd = new bbpd();
    if (paramMsg.appshare_info.has())
    {
      azad.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, (List)localObject3, paramMsg, paramazai.e, l2, false);
      localObject2 = null;
      l1 = 0L;
    }
    label284:
    label1132:
    int i;
    label1035:
    label1037:
    label1396:
    label1911:
    int i1;
    label1754:
    int n;
    label2991:
    label3276:
    label3311:
    label3576:
    Object localObject5;
    label3338:
    label3375:
    label3537:
    label3955:
    boolean bool3;
    label3777:
    label4037:
    boolean bool2;
    int i3;
    int i4;
    int i5;
    label4494:
    int i2;
    boolean bool1;
    boolean bool4;
    label4636:
    boolean bool5;
    int i9;
    int i8;
    int i7;
    int i6;
    label4827:
    label4848:
    int i18;
    label4869:
    label4890:
    label5068:
    label5087:
    int i17;
    label5575:
    int i16;
    int i15;
    int i14;
    int i13;
    int i12;
    int i10;
    int i11;
    boolean bool6;
    for (;;)
    {
      Object localObject4;
      if ((((List)localObject3).size() == 0) && (k > 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "<---decodeSinglePbMsg_GroupDis, empty long msg fragment");
        }
        localObject4 = (MessageForText)azaf.a(-1000);
        ((MessageForText)localObject4).msgtype = -1000;
        ((MessageForText)localObject4).msg = "";
        ((List)localObject3).add(localObject4);
      }
      byte b2 = 0;
      Iterator localIterator = ((List)localObject3).iterator();
      localObject3 = null;
      Object localObject6;
      long l8;
      if (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        localMessageRecord.time = l2;
        localMessageRecord.msgseq = l2;
        localMessageRecord.shmsgseq = l3;
        localMessageRecord.msgUid = l1;
        localMessageRecord.selfuin = ((String)localObject8);
        localMessageRecord.istroop = paramazai.c;
        localMessageRecord.senderuin = String.valueOf(l6);
        localMessageRecord.frienduin = String.valueOf(paramazai.e);
        localMessageRecord.longMsgId = m;
        localMessageRecord.longMsgCount = k;
        localMessageRecord.longMsgIndex = j;
        if (((localMessageRecord instanceof MessageForFoldMsg)) && (QLog.isColorLevel())) {
          QLog.d("msgFold", 2, String.format("Recv, recv foldMsg, frienduin: %s, senduin: %s, msguid: %s, shmsgseq: %s content: %s", new Object[] { localMessageRecord.frienduin, localMessageRecord.senderuin, Long.valueOf(localMessageRecord.msgUid), Long.valueOf(localMessageRecord.shmsgseq), localMessageRecord.getLogColorContent() }));
        }
        if (paramazai.d == 127)
        {
          localMessageRecord.msg = "PTT_URL";
          localMessageRecord.msgtype = -2006;
          localMessageRecord.isread = true;
        }
        if (localMessageRecord.msgtype == -1035) {
          ((ChatMessage)localMessageRecord).parse();
        }
        byte b1 = b2;
        if (((msg_comm.MsgHead)localObject7).msg_flag.has())
        {
          b1 = b2;
          if ((((msg_comm.MsgHead)localObject7).msg_flag.get() & 1L) == 1L)
          {
            b1 = b2;
            if (localMessageRecord.msgtype != -2058)
            {
              b2 = 1;
              localbbpd.c.a(l3, localMessageRecord.uniseq);
              b1 = b2;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "receive the TroopMsg from TroopSpecialAttention!");
                b1 = b2;
              }
            }
          }
        }
        if ((localMessageRecord.istroop == 1) && (bdww.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localMessageRecord.msg, localMessageRecord.frienduin))) {
          localbbpd.b.a(l3, localMessageRecord.uniseq);
        }
        if (((localMessageRecord instanceof MessageForTroopConfess)) && (((MessageForTroopConfess)localMessageRecord).isToSelf)) {
          localbbpd.d.a(l3, localMessageRecord.uniseq);
        }
        if (a(localMessageRecord)) {
          localbbpd.g.a(l3, localMessageRecord.uniseq);
        }
        if (b(localMessageRecord)) {
          localbbpd.s.a(l3, localMessageRecord.uniseq);
        }
        if (c(localMessageRecord)) {
          localbbpd.w.a(l3, localMessageRecord.uniseq);
        }
        Object localObject9;
        if (((paramazai.c == 1) || (paramazai.c == 1026)) && (localObject2 != null))
        {
          localObject4 = ((List)localObject2).iterator();
          for (;;)
          {
            if (((Iterator)localObject4).hasNext())
            {
              localObject6 = (im_msg_body.Elem)((Iterator)localObject4).next();
              if ((((im_msg_body.Elem)localObject6).general_flags.has()) && (((im_msg_body.Elem)localObject6).general_flags.bytes_pb_reserve.has()))
              {
                localObject9 = new generalflags.ResvAttr();
                ((generalflags.ResvAttr)localObject9).mergeFrom(((im_msg_body.Elem)localObject6).general_flags.bytes_pb_reserve.get().toByteArray());
                if ((((generalflags.ResvAttr)localObject9).uint32_group_savedb_flag.has()) && ((((generalflags.ResvAttr)localObject9).uint32_group_savedb_flag.get() & 0x1) == 1))
                {
                  localbbpd.x.a(l3, localMessageRecord.uniseq);
                  if (QLog.isColorLevel())
                  {
                    QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis, should show shop ark");
                    continue;
                    l1 = ((Long)((Pair)localObject2).second).longValue();
                    break label8066;
                    if (!paramMsg.msg_body.has()) {
                      break label8036;
                    }
                    localObject2 = (im_msg_body.MsgBody)paramMsg.msg_body.get();
                    if (!((im_msg_body.MsgBody)localObject2).rich_text.has()) {
                      break label8036;
                    }
                    localObject4 = (im_msg_body.RichText)((im_msg_body.MsgBody)localObject2).rich_text.get();
                    if (!((im_msg_body.RichText)localObject4).attr.has()) {
                      break label8030;
                    }
                    l1 = azah.a(((im_msg_body.Attr)((im_msg_body.RichText)localObject4).attr.get()).random.get());
                    localObject2 = ((im_msg_body.RichText)localObject4).elems.get();
                    if (((im_msg_body.RichText)localObject4).ptt.has())
                    {
                      azad.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, (List)localObject3);
                      break;
                    }
                    localbbpd.jdField_a_of_type_JavaLangString = String.valueOf(paramazai.e);
                    localbbpd.jdField_a_of_type_Int = paramazai.c;
                    azad.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, (List)localObject3, paramMsg, false, false, localbbpd);
                    break;
                  }
                }
              }
            }
          }
        }
        if (localMessageRecord.msgtype == -1049)
        {
          localObject4 = (MessageForReplyText)localMessageRecord;
          if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((MessageForReplyText)localObject4).mSourceMsgInfo.mSourceMsgSenderUin + ""))) {
            localbbpd.l.a(l3, localMessageRecord.uniseq);
          }
        }
        if (localMessageRecord.msgtype == -5015) {
          localbbpd.v.a(l3, localMessageRecord.uniseq);
        }
        if (localMessageRecord.msgtype == -2058) {
          EmojiStickerManager.a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        if (((localMessageRecord.msgtype != -2058) || (parambbpd.t.a != -1L) || (parambbpd.t.b != -1L)) || (localMessageRecord.msgtype == -1035))
        {
          localObject4 = (MessageForMixedMsg)localMessageRecord;
          i = 0;
          if (i < ((MessageForMixedMsg)localObject4).msgElemList.size())
          {
            localObject6 = (MessageRecord)((MessageForMixedMsg)localObject4).msgElemList.get(i);
            if (!(localObject6 instanceof MessageForReplyText)) {
              break label8084;
            }
            localObject4 = (MessageForReplyText)localObject6;
            if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((MessageForReplyText)localObject4).mSourceMsgInfo.mSourceMsgSenderUin + ""))) {
              localbbpd.l.a(l3, localMessageRecord.uniseq);
            }
          }
        }
        if ((localMessageRecord.msgtype == -2035) || (localMessageRecord.msgtype == -2038))
        {
          localObject4 = (MessageForDeliverGiftTips)localMessageRecord;
          localObject6 = bdgc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForDeliverGiftTips)localObject4).istroop, ((MessageForDeliverGiftTips)localObject4).frienduin, ((MessageForDeliverGiftTips)localObject4).senderuin);
          if (!TextUtils.isEmpty((CharSequence)localObject6)) {
            ((MessageForDeliverGiftTips)localObject4).senderName = ((String)localObject6);
          }
          if (!((MessageForDeliverGiftTips)localObject4).isFromNearby)
          {
            localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            if (!TextUtils.isEmpty((CharSequence)localObject6))
            {
              if ((!((String)localObject6).equals(((MessageForDeliverGiftTips)localObject4).receiverUin + "")) && (!((MessageForDeliverGiftTips)localObject4).isToAll())) {
                break label3311;
              }
              localbbpd.h.a(l3, localMessageRecord.uniseq);
            }
            localObject6 = (bcka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
            if (localObject6 != null) {
              ((bcka)localObject6).b((MessageForDeliverGiftTips)localObject4);
            }
          }
        }
        if (auuv.a(localMessageRecord))
        {
          localObject4 = new NearbyFlowerMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForStructing)localMessageRecord);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((NearbyFlowerMessage)localObject4).rUin)) {
              break label3338;
            }
            localbbpd.h.a(l3, localMessageRecord.uniseq);
          }
        }
        if ((localMessageRecord instanceof MessageForStructing))
        {
          localObject4 = azvd.a(localMessageRecord.msgData);
          if ((localObject4 instanceof StructMsgForGeneralShare))
          {
            localObject4 = (StructMsgForGeneralShare)localObject4;
            if ((localObject4 == null) || (((StructMsgForGeneralShare)localObject4).mMsgServiceID != 75)) {
              break label3375;
            }
            localObject4 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
            l8 = localMessageRecord.uniseq;
            localObject4 = localMessageRecord.frienduin;
            localObject9 = new absj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            localObject6 = ((absj)localObject9).jdField_a_of_type_Amnz;
            localObject9 = ((absj)localObject9).jdField_a_of_type_JavaUtilMap;
            localObject6 = ((amnz)localObject6).a((String)localObject4, 1);
            TroopManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord.frienduin, StructMsgForGeneralShare.eventId, localMessageRecord.shmsgseq, new absq(this, false, localbbpd, l3, l8, (RecentUser)localObject6, (String)localObject4, localMessageRecord, (Map)localObject9));
          }
        }
        if ((localMessageRecord instanceof MessageForTroopFile)) {
          localbbpd.n.a(l3, localMessageRecord.uniseq);
        }
        if (bcml.a(localMessageRecord)) {
          localbbpd.j.a(l3, localMessageRecord.uniseq);
        }
        if ((localMessageRecord.msgtype == -5008) && ((localMessageRecord instanceof MessageForArkApp)))
        {
          localObject4 = (MessageForArkApp)localMessageRecord;
          if ((((MessageForArkApp)localObject4).ark_app_message != null) && (((MessageForArkApp)localObject4).ark_app_message.appName.equals("com.tencent.mannounce"))) {
            localbbpd.q.a(l3, localMessageRecord.uniseq);
          }
        }
        Object localObject10;
        Object localObject11;
        if (localMessageRecord.msgtype == -2039)
        {
          localObject6 = (MessageForApollo)localMessageRecord;
          localObject9 = new ArrayList(2);
          localObject10 = (aknx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
          localObject4 = null;
          if (QLog.isColorLevel()) {
            localObject4 = new StringBuilder("decode apollo troop msg: ").append(", id: ").append(((MessageForApollo)localObject6).mApolloMessage.id).append(", name: ").append(new String(((MessageForApollo)localObject6).mApolloMessage.name)).append(", doubleAction: ").append(((MessageForApollo)localObject6).isDoubleAction()).append(", time: ").append(localMessageRecord.time).append("\nsender: ").append(localMessageRecord.senderuin);
          }
          if (!localMessageRecord.isSend())
          {
            localObject11 = ((aknx)localObject10).b(((MessageForApollo)localObject6).senderuin);
            if (QLog.isColorLevel()) {
              ((StringBuilder)localObject4).append(", update time: ").append(((ApolloBaseInfo)localObject11).apolloUpdateTime);
            }
            if ((localMessageRecord.time > ((ApolloBaseInfo)localObject11).apolloUpdateTime) && ((((ApolloBaseInfo)localObject11).apolloServerTS < ((MessageForApollo)localObject6).mApolloMessage.sender_ts) || (((ApolloBaseInfo)localObject11).apolloStatus != ((MessageForApollo)localObject6).mApolloMessage.sender_status) || (((ApolloBaseInfo)localObject11).superYellowDiamondFlag != (((MessageForApollo)localObject6).mApolloMessage.flag >> 30 & 0x1)) || ((((MessageForApollo)localObject6).is3dAction()) && (((MessageForApollo)localObject6).mApollo3DMessage != null) && (((ApolloBaseInfo)localObject11).cmshow3dFlag != ((MessageForApollo)localObject6).mApollo3DMessage.senderStatus_3D))))
            {
              ((ApolloBaseInfo)localObject11).apolloStatus = ((MessageForApollo)localObject6).mApolloMessage.sender_status;
              ((ApolloBaseInfo)localObject11).apolloServerTS = ((MessageForApollo)localObject6).mApolloMessage.sender_ts;
              ((ApolloBaseInfo)localObject11).superYellowDiamondFlag = (((MessageForApollo)localObject6).mApolloMessage.flag >> 30 & 0x1);
              if ((((MessageForApollo)localObject6).is3dAction()) && (((MessageForApollo)localObject6).mApollo3DMessage != null)) {
                ((ApolloBaseInfo)localObject11).cmshow3dFlag = ((MessageForApollo)localObject6).mApollo3DMessage.senderStatus_3D;
              }
              ((ApolloBaseInfo)localObject11).apolloUpdateTime = localMessageRecord.time;
              ((ArrayList)localObject9).add(localObject11);
              if (QLog.isColorLevel()) {
                ((StringBuilder)localObject4).append("\n save apollo info: ").append(((ApolloBaseInfo)localObject11).apolloVipFlag).append("|").append(((ApolloBaseInfo)localObject11).apolloStatus).append("|").append(((ApolloBaseInfo)localObject11).apolloLocalTS).append("|").append(((ApolloBaseInfo)localObject11).apolloServerTS).append("|").append(((ApolloBaseInfo)localObject11).cmshow3dFlag).append("|").append(((ApolloBaseInfo)localObject11).apolloUpdateTime);
              }
            }
          }
          if ((((MessageForApollo)localObject6).isDoubleAction()) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ((MessageForApollo)localObject6).mApolloMessage.peer_uin + "")))
          {
            localObject11 = ((aknx)localObject10).b(((MessageForApollo)localObject6).mApolloMessage.peer_uin + "");
            if (QLog.isColorLevel()) {
              ((StringBuilder)localObject4).append("\n peer: ").append(((ApolloBaseInfo)localObject11).uin).append(", update time: ").append(((ApolloBaseInfo)localObject11).apolloUpdateTime);
            }
            if ((localMessageRecord.time > ((ApolloBaseInfo)localObject11).apolloUpdateTime) && ((((ApolloBaseInfo)localObject11).apolloServerTS < ((MessageForApollo)localObject6).mApolloMessage.peer_ts) || (((ApolloBaseInfo)localObject11).apolloStatus != ((MessageForApollo)localObject6).mApolloMessage.peer_status) || (((ApolloBaseInfo)localObject11).superYellowDiamondFlag != (((MessageForApollo)localObject6).mApolloMessage.flag >> 31 & 0x1)) || ((((MessageForApollo)localObject6).is3dAction()) && (((MessageForApollo)localObject6).mApollo3DMessage != null) && (((ApolloBaseInfo)localObject11).cmshow3dFlag != ((MessageForApollo)localObject6).mApollo3DMessage.peerStatus_3D))))
            {
              ((ApolloBaseInfo)localObject11).apolloStatus = ((MessageForApollo)localObject6).mApolloMessage.peer_status;
              ((ApolloBaseInfo)localObject11).apolloServerTS = ((MessageForApollo)localObject6).mApolloMessage.peer_ts;
              ((ApolloBaseInfo)localObject11).superYellowDiamondFlag = (((MessageForApollo)localObject6).mApolloMessage.flag >> 31 & 0x1);
              if ((((MessageForApollo)localObject6).is3dAction()) && (((MessageForApollo)localObject6).mApollo3DMessage != null)) {
                ((ApolloBaseInfo)localObject11).cmshow3dFlag = ((MessageForApollo)localObject6).mApollo3DMessage.peerStatus_3D;
              }
              ((ApolloBaseInfo)localObject11).apolloUpdateTime = localMessageRecord.time;
              ((ArrayList)localObject9).add(localObject11);
              if (QLog.isColorLevel()) {
                ((StringBuilder)localObject4).append("\n save apollo info ").append(((ApolloBaseInfo)localObject11).apolloVipFlag).append("|").append(((ApolloBaseInfo)localObject11).apolloStatus).append("|").append(((ApolloBaseInfo)localObject11).apolloLocalTS).append("|").append(((ApolloBaseInfo)localObject11).apolloServerTS).append("|").append(((ApolloBaseInfo)localObject11).cmshow3dFlag).append("|").append(((ApolloBaseInfo)localObject11).apolloUpdateTime);
              }
            }
          }
          if (((ArrayList)localObject9).size() > 0) {
            ((aknx)localObject10).b((List)localObject9);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, ((StringBuilder)localObject4).toString());
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            i1 = ((aknx)localObject10).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
            localObject4 = "";
            if (((MessageForApollo)localObject6).msgType != 0) {
              break label3537;
            }
            localObject4 = String.valueOf(((MessageForApollo)localObject6).mApolloMessage.id);
          }
        }
        for (;;)
        {
          if (localMessageRecord.istroop != 1) {
            break label8093;
          }
          i = 1;
          localObject9 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(false);
          n = i;
          if (localObject9 != null)
          {
            n = i;
            if (((HotChatManager)localObject9).b(localMessageRecord.frienduin)) {
              n = 3;
            }
          }
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "rev_action", String.valueOf(localMessageRecord.senderuin), n, ((MessageForApollo)localObject6).msgType, new String[] { localObject4, Integer.toString(i1), Integer.toString(aknx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)), String.valueOf(System.currentTimeMillis() / 1000L) });
          if (parambbpd != null)
          {
            if (localbbpd.f.a != -1L) {
              localbbpd.f.b = localMessageRecord.uniseq;
            }
            if (localbbpd.jdField_a_of_type_Bbpe.a != -1L) {
              localbbpd.jdField_a_of_type_Bbpe.b = localMessageRecord.uniseq;
            }
            if ((l3 > this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramazai.e), paramazai.c)) && (localbbpd.a()))
            {
              parambbpd.a(localbbpd);
              localMessageRecord.mMessageInfo = localbbpd;
            }
          }
          if (((paramazai.c != 1) && (paramazai.c != 1026) && (paramazai.c != 3000)) || (localObject2 == null) || (TextUtils.equals(localMessageRecord.selfuin, localMessageRecord.senderuin))) {
            break label3777;
          }
          i = 0;
          localObject4 = ((List)localObject2).iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label3576;
          }
          if (!((im_msg_body.Elem)((Iterator)localObject4).next()).anon_group_msg.has()) {
            break label8027;
          }
          i = 1;
          break label8081;
          if (((MessageForDeliverGiftTips)localObject4).animationPackageId <= 0) {
            break;
          }
          localbbpd.i.a(l3, localMessageRecord.uniseq);
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((NearbyFlowerMessage)localObject4).sUin)) {
            break label1754;
          }
          localbbpd.i.a(l3, localMessageRecord.uniseq);
          break label1754;
          if ((localObject4 != null) && (((StructMsgForGeneralShare)localObject4).mMsgServiceID == 19) && (!((StructMsgForGeneralShare)localObject4).mMsgBrief.startsWith(alud.a(2131701406))) && (!((StructMsgForGeneralShare)localObject4).mMsgBrief.equals(alud.a(2131701400))))
          {
            localbbpd.o.a(l3, localMessageRecord.uniseq);
            break label1911;
          }
          if ((localObject4 != null) && (((StructMsgForGeneralShare)localObject4).mMsgServiceID == 106))
          {
            if ((((StructMsgForGeneralShare)localObject4).atMembers == null) || (!((StructMsgForGeneralShare)localObject4).atMembers.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
              break label1911;
            }
            localbbpd.jdField_a_of_type_Bbpe.a(l3, localMessageRecord.uniseq);
            break label1911;
          }
          if ((localObject4 == null) || (((StructMsgForGeneralShare)localObject4).mMsgServiceID != 107)) {
            break label1911;
          }
          localbbpd.u.a(l3, localMessageRecord.uniseq);
          break label1911;
          if (ApolloGameUtil.a(((MessageForApollo)localObject6).msgType)) {
            localObject4 = "" + ((MessageForApollo)localObject6).gameId;
          }
        }
        localObject4 = ((List)localObject2).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject6 = (im_msg_body.Elem)((Iterator)localObject4).next();
          if ((i == 0) && (((im_msg_body.Elem)localObject6).extra_info.has()))
          {
            localObject6 = (im_msg_body.ExtraInfo)((im_msg_body.Elem)localObject6).extra_info.get();
            if (((im_msg_body.ExtraInfo)localObject6).uint32_msg_tail_id.has())
            {
              n = ((im_msg_body.ExtraInfo)localObject6).uint32_msg_tail_id.get();
              if (n > 0)
              {
                localObject6 = azaf.a(-1002);
                if (localObject6 != null)
                {
                  localObject9 = Integer.toString(n);
                  localObject10 = new SafeMsg.SafeMoreInfo();
                  ((SafeMsg.SafeMoreInfo)localObject10).strMsgTxt.set((String)localObject9);
                  ((MessageRecord)localObject6).init(localMessageRecord.selfuin, localMessageRecord.frienduin, localMessageRecord.senderuin, (String)localObject9, localMessageRecord.time, -1002, localMessageRecord.istroop, localMessageRecord.msgseq);
                  ((MessageRecord)localObject6).isread = true;
                  ((MessageRecord)localObject6).shmsgseq = localMessageRecord.shmsgseq;
                  ((MessageRecord)localObject6).msgData = ((SafeMsg.SafeMoreInfo)localObject10).toByteArray();
                  paramArrayList.add(localObject6);
                }
              }
            }
          }
        }
        if (paramazai.c != 1)
        {
          localObject4 = localObject3;
          if (paramazai.c != 1026) {}
        }
        else
        {
          localObject4 = localObject3;
          if (localObject2 != null)
          {
            localObject6 = ((List)localObject2).iterator();
            do
            {
              localObject4 = localObject3;
              if (!((Iterator)localObject6).hasNext()) {
                break label8020;
              }
              localObject9 = (im_msg_body.Elem)((Iterator)localObject6).next();
              if (((im_msg_body.Elem)localObject9).anon_group_msg.has())
              {
                localObject9 = (im_msg_body.AnonymousGroupMsg)((im_msg_body.Elem)localObject9).anon_group_msg.get();
                i = ((im_msg_body.AnonymousGroupMsg)localObject9).uint32_flags.get();
                localObject4 = ((im_msg_body.AnonymousGroupMsg)localObject9).str_anon_id.get().toByteArray();
                localObject6 = ((im_msg_body.AnonymousGroupMsg)localObject9).str_anon_nick.get().toByteArray();
                n = ((im_msg_body.AnonymousGroupMsg)localObject9).uint32_head_portrait.get();
                i1 = ((im_msg_body.AnonymousGroupMsg)localObject9).uint32_expire_time.get();
                localObject9 = ((im_msg_body.AnonymousGroupMsg)localObject9).str_rank_color.get().toStringUtf8();
                if (localObject4 == null) {
                  break label8099;
                }
                for (;;)
                {
                  try
                  {
                    localObject4 = new String((byte[])localObject4, "ISO-8859-1");
                    if (localObject6 == null)
                    {
                      localObject6 = "";
                      localMessageRecord.saveExtInfoToExtStr("anonymous", nav.a(i, (String)localObject4, (String)localObject6, n, i1, (String)localObject9));
                      localMessageRecord.extLong |= 0x3;
                      localObject4 = localObject3;
                      if (!QLog.isColorLevel()) {
                        break label8020;
                      }
                      QLog.d("anonymous_decode", 2, "anonymous_flags = " + i);
                      paramArrayList.add(localMessageRecord);
                      b2 = b1;
                    }
                  }
                  catch (UnsupportedEncodingException localUnsupportedEncodingException)
                  {
                    localUnsupportedEncodingException.printStackTrace();
                    break label8099;
                  }
                  localObject6 = new String((byte[])localObject6);
                }
              }
              localObject5 = localObject3;
              if (((im_msg_body.Elem)localObject9).extra_info.has())
              {
                localObject10 = (im_msg_body.ExtraInfo)((im_msg_body.Elem)localObject9).extra_info.get();
                localObject3 = ((im_msg_body.ExtraInfo)localObject10).bytes_sender_title.get().toStringUtf8();
                i = ((im_msg_body.ExtraInfo)localObject10).uint32_flags.get();
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc.troop.special_msg", 2, "dwFlags:" + i);
                }
                localObject5 = localObject3;
                if (((im_msg_body.ExtraInfo)localObject10).uint32_new_group_flag.has())
                {
                  localObject11 = paramazai.e + "";
                  localObject5 = localObject3;
                  if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b((String)localObject11) != ((im_msg_body.ExtraInfo)localObject10).uint32_new_group_flag.get())
                  {
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject11, Integer.valueOf(((im_msg_body.ExtraInfo)localObject10).uint32_new_group_flag.get()));
                    localObject5 = localObject3;
                  }
                }
              }
              localObject3 = localObject5;
            } while (!((im_msg_body.Elem)localObject9).group_business_msg.has());
            localObject9 = bcmn.a(((im_msg_body.Elem)localObject9).group_business_msg);
            bcmm.a(localMessageRecord, (bcmn)localObject9);
            localObject10 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (localMessageRecord.frienduin == null) {}
            for (localObject3 = "";; localObject3 = localMessageRecord.frienduin)
            {
              azqs.b((QQAppInterface)localObject10, "P_CliOper", "Grp_AIO", "", "five_m", "revice_msg", 0, 0, (String)localObject3, localMessageRecord.msgtype + "", ((bcmn)localObject9).c, "");
              localObject3 = localObject5;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decode group_business_msg:" + localObject9);
              localObject3 = localObject5;
              break;
            }
          }
        }
      }
      else
      {
        bool3 = false;
        bool2 = false;
        i3 = 0;
        i4 = 0;
        j = -100;
        k = -100;
        m = -100;
        n = -100;
        i1 = -100;
        i5 = -100;
        if ((paramazai.c == 1) || (paramazai.c == 1026))
        {
          double d = -100.0D;
          i = -1;
          localObject5 = (msg_comm.GroupInfo)((msg_comm.MsgHead)localObject7).group_info.get();
          if (localObject5 != null)
          {
            l1 = ((msg_comm.GroupInfo)localObject5).group_code.get();
            if (localObject2 != null)
            {
              localObject2 = ((List)localObject2).iterator();
              i = -1;
              n = -100;
              m = -100;
              k = -100;
              j = -100;
              i2 = -100;
              d = -100.0D;
              i1 = -100;
              i3 = -100;
              bool1 = false;
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  localObject6 = (im_msg_body.Elem)((Iterator)localObject2).next();
                  if (((im_msg_body.Elem)localObject6).general_flags.has())
                  {
                    bool4 = bool2;
                    bool3 = bool1;
                    if (!((im_msg_body.Elem)localObject6).general_flags.uint32_group_type.has()) {}
                  }
                  switch (((im_msg_body.Elem)localObject6).general_flags.uint32_group_type.get())
                  {
                  case 1: 
                    label5765:
                    do
                    {
                      bool4 = bool2;
                      bool3 = bool5;
                      if (QLog.isColorLevel())
                      {
                        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis,receive general_flags.uint32_group_type, isPubGroupVisitor = " + bool2 + ", isHotChatMsg = " + bool5);
                        bool3 = bool5;
                        bool4 = bool2;
                      }
                      if (((im_msg_body.Elem)localObject6).general_flags.uint32_glamour_level.has()) {
                        i3 = ((im_msg_body.Elem)localObject6).general_flags.uint32_glamour_level.get();
                      }
                      i9 = i;
                      i8 = n;
                      i7 = m;
                      i6 = k;
                      i5 = j;
                      if (((im_msg_body.Elem)localObject6).general_flags.bytes_pb_reserve.has())
                      {
                        parambbpd = new generalflags.ResvAttr();
                        parambbpd.mergeFrom(((im_msg_body.Elem)localObject6).general_flags.bytes_pb_reserve.get().toByteArray());
                        if (parambbpd.uint32_rich_card_name_ver.has()) {
                          parambbpd.uint32_rich_card_name_ver.get();
                        }
                        if (!parambbpd.uint32_nearby_charm_level.has()) {
                          break label8229;
                        }
                        i2 = parambbpd.uint32_nearby_charm_level.get();
                        if (!parambbpd.uint32_global_group_level.has()) {
                          break label8236;
                        }
                        i6 = parambbpd.uint32_global_group_level.get();
                        if (!parambbpd.uint32_vip_type.has()) {
                          break label8243;
                        }
                        i1 = parambbpd.uint32_vip_type.get();
                        if (!parambbpd.uint32_vip_level.has()) {
                          break label8249;
                        }
                        i5 = parambbpd.uint32_vip_level.get();
                        i7 = VipUtils.c(i5);
                        if (parambbpd.uint32_user_bigclub_flag.has()) {
                          j = parambbpd.uint32_user_bigclub_flag.get();
                        }
                        if (parambbpd.uint32_user_bigclub_level.has()) {
                          k = parambbpd.uint32_user_bigclub_level.get();
                        }
                        if (parambbpd.uint32_nameplate.has()) {
                          m = parambbpd.uint32_nameplate.get();
                        }
                        if (parambbpd.uint32_req_is_bigclub_hidden.has()) {
                          n = parambbpd.uint32_req_is_bigclub_hidden.get();
                        }
                        i8 = n;
                        i5 = j;
                        if (j != 0)
                        {
                          i8 = n;
                          i5 = j;
                          if (parambbpd.uint32_nameplate_vip_type.has())
                          {
                            i8 = n;
                            i5 = j;
                            if (parambbpd.uint32_gray_name_plate.has())
                            {
                              i5 = parambbpd.uint32_nameplate_vip_type.get();
                              localObject7 = bdox.a(i5);
                              if ((!bdow.a(i5)) || (((bdox)localObject7).b())) {
                                break label8255;
                              }
                              i5 = 1;
                              if ((parambbpd.uint32_gray_name_plate.get() != 0) || (i5 != 0)) {
                                break label8113;
                              }
                              i8 = n;
                              i5 = j;
                              if (j == 3)
                              {
                                i8 = n;
                                i5 = j;
                                if (!((bdox)localObject7).c())
                                {
                                  i5 = 1;
                                  i8 = n;
                                }
                              }
                            }
                          }
                        }
                        if (QLog.isColorLevel()) {
                          QLog.d("kaiyan", 2, "isHideBigClub=" + i8);
                        }
                        i9 = i;
                        if (parambbpd.uint32_title_id.has())
                        {
                          j = parambbpd.uint32_title_id.get();
                          if (j > 0) {
                            i = j;
                          }
                          i9 = i;
                          if (QLog.isColorLevel())
                          {
                            QLog.d("TroopRankConfig", 2, "decodeSinglePbMsg_GroupDis, titleId=" + j + ", troopUin=" + l1 + ", sender=" + l6 + ", msgTime=" + l2 + ", isSaveDb=" + paramBoolean);
                            i9 = i;
                          }
                        }
                        if ((paramazai.c == 1) && (parambbpd.uint32_group_member_flag_ex2.has()))
                        {
                          i = parambbpd.uint32_group_member_flag_ex2.get();
                          amjo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, i);
                        }
                        if ((paramazai.c == 1) && (parambbpd.uint32_group_ringtone_id.has()) && (parambbpd.uint32_group_ringtone_id.get() > 0))
                        {
                          i = parambbpd.uint32_group_ringtone_id.get();
                          amjo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, i);
                        }
                        localObject7 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                        if (localObject7 != null) {
                          ((TroopManager)localObject7).a(String.valueOf(l1), String.valueOf(l6), i2, i6);
                        }
                        if ((paramazai.c == 1) && (parambbpd.uint32_custom_featureid.has()) && (localObject7 != null) && (parambbpd.uint32_custom_featureid.get() == 19713))
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d(".troop.qidian_private_troop", 2, "decodeSinglePbMsg_GroupDis, hasPrivateTroopFlag, troopUin=" + l1);
                          }
                          localObject8 = ((TroopManager)localObject7).b(String.valueOf(l1));
                          if ((localObject8 != null) && (!((TroopInfo)localObject8).isQidianPrivateTroop()))
                          {
                            ((TroopInfo)localObject8).setQidianPrivateTroopFlag();
                            ((TroopManager)localObject7).b((TroopInfo)localObject8);
                            if (QLog.isColorLevel()) {
                              QLog.d(".troop.qidian_private_troop", 2, "set privateTroop flag, troopUin=" + l1);
                            }
                          }
                        }
                        if (!parambbpd.bytes_hudong_mark.has()) {
                          break label8261;
                        }
                        parambbpd = parambbpd.bytes_hudong_mark.get().toByteArray();
                        parambbpd = bcgg.a(parambbpd);
                        ((bcgc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(346)).a(String.valueOf(l1), String.valueOf(l6), parambbpd);
                        i2 = i7;
                        i6 = k;
                        i7 = m;
                      }
                      i18 = i9;
                      i17 = i8;
                      i16 = i7;
                      i15 = i6;
                      i14 = i5;
                      i13 = i2;
                      i12 = i1;
                      i10 = i3;
                      i11 = i4;
                      bool6 = bool4;
                      bool5 = bool3;
                      if (paramazai.c != 1) {
                        break label7938;
                      }
                      i18 = i9;
                      i17 = i8;
                      i16 = i7;
                      i15 = i6;
                      i14 = i5;
                      i13 = i2;
                      i12 = i1;
                      i10 = i3;
                      i11 = i4;
                      bool6 = bool4;
                      bool5 = bool3;
                      if (!((im_msg_body.Elem)localObject6).general_flags.uint64_group_rank_seq.has()) {
                        break label7938;
                      }
                      parambbpd = String.valueOf(l1);
                      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.c())) {
                        break label8267;
                      }
                      bool1 = true;
                      if (!bool1) {
                        break;
                      }
                      localObject7 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(parambbpd);
                      if (localObject7 == null) {
                        break label8119;
                      }
                      l8 = ((im_msg_body.Elem)localObject6).general_flags.uint64_group_rank_seq.get();
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.getTroopMemberLevelInfo", 2, "onNewMsg: troopUin=" + parambbpd + ", serverRankSeq=" + l8 + ", localRankSeq=" + ((TroopInfo)localObject7).dwGroupLevelSeq + ", isSyncMsgFinish=" + bool1);
                      }
                      if (l8 <= ((TroopInfo)localObject7).dwGroupLevelSeq) {
                        break label8119;
                      }
                      ((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).c(parambbpd, false);
                      break label8119;
                      bool5 = bool1;
                    } while (!((im_msg_body.Elem)localObject6).general_flags.uint32_to_uin_flag.has());
                    if (((im_msg_body.Elem)localObject6).general_flags.uint32_to_uin_flag.get() == 2)
                    {
                      bool2 = true;
                      break label8210;
                      if (QLog.isColorLevel())
                      {
                        QLog.d("Q.getTroopMemberLevelInfo", 2, "onNewMsg: troopUin=" + parambbpd + ", isSyncMsgFinish=" + bool1);
                        break label8119;
                        if ((((im_msg_body.Elem)localObject6).extra_info.has()) && (((im_msg_body.Elem)localObject6).extra_info.uint32_flags.has()))
                        {
                          i18 = i;
                          i17 = n;
                          i16 = m;
                          i15 = k;
                          i14 = j;
                          i13 = i2;
                          i12 = i1;
                          i10 = i3;
                          i11 = i4;
                          bool6 = bool2;
                          bool5 = bool1;
                          if (bool1)
                          {
                            i5 = ((im_msg_body.Elem)localObject6).extra_info.uint32_flags.get();
                            if (QLog.isColorLevel()) {
                              QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "elem.extra_info.uint32_flags:" + i5 + "|groupCode:" + l1 + "fromUin:" + l6);
                            }
                            if ((i5 & 0x10) != 16) {
                              break label8273;
                            }
                            parambbpd = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).a(l1 + "");
                            localObject6 = l6 + "";
                            if ((parambbpd == null) || (parambbpd.adminUins.contains(localObject6))) {
                              break label8273;
                            }
                            parambbpd.adminUins.add(localObject6);
                            break label8273;
                          }
                        }
                        else if (((im_msg_body.Elem)localObject6).pub_group.has())
                        {
                          i11 = 1;
                          i18 = i;
                          i17 = n;
                          i16 = m;
                          i15 = k;
                          i14 = j;
                          i13 = i2;
                          i12 = i1;
                          i10 = i3;
                          bool6 = bool2;
                          bool5 = bool1;
                          if (QLog.isColorLevel())
                          {
                            if (!((im_msg_body.PubGroup)((im_msg_body.Elem)localObject6).pub_group.get()).bytes_nickname.has()) {
                              break label7985;
                            }
                            parambbpd = ((im_msg_body.PubGroup)((im_msg_body.Elem)localObject6).pub_group.get()).bytes_nickname.get().toStringUtf8();
                            label6345:
                            QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis,receive  pub_group,bytes_nickname = " + parambbpd);
                            i4 = k;
                            i5 = j;
                            i6 = i1;
                            i7 = 1;
                            bool3 = bool1;
                            j = n;
                            k = m;
                            m = i4;
                            n = i5;
                            i1 = i2;
                            i2 = i6;
                            i4 = i7;
                            bool1 = bool2;
                            bool2 = bool3;
                            break label8159;
                          }
                        }
                        else
                        {
                          i18 = i;
                          i17 = n;
                          i16 = m;
                          i15 = k;
                          i14 = j;
                          i13 = i2;
                          i12 = i1;
                          i10 = i3;
                          i11 = i4;
                          bool6 = bool2;
                          bool5 = bool1;
                          if (((im_msg_body.Elem)localObject6).elem_flags2.has())
                          {
                            i18 = i;
                            i17 = n;
                            i16 = m;
                            i15 = k;
                            i14 = j;
                            i13 = i2;
                            i12 = i1;
                            i10 = i3;
                            i11 = i4;
                            bool6 = bool2;
                            bool5 = bool1;
                            if (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject6).elem_flags2.get()).uint32_longtitude.has())
                            {
                              i18 = i;
                              i17 = n;
                              i16 = m;
                              i15 = k;
                              i14 = j;
                              i13 = i2;
                              i12 = i1;
                              i10 = i3;
                              i11 = i4;
                              bool6 = bool2;
                              bool5 = bool1;
                              if (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject6).elem_flags2.get()).uint32_latitude.has())
                              {
                                if (l7 == l6) {
                                  continue;
                                }
                                d = -1001.0D;
                                i5 = k;
                                i6 = j;
                                i7 = i1;
                                bool3 = bool1;
                                j = n;
                                k = m;
                                m = i5;
                                n = i6;
                                i1 = i2;
                                i2 = i7;
                                bool1 = bool2;
                                bool2 = bool3;
                                break label8159;
                                label6677:
                                parambbpd = String.valueOf(l1);
                                paramazai = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                                localObject2 = paramazai.b(parambbpd);
                                if (QLog.isColorLevel()) {
                                  QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis: troopUin=" + l1 + ", memberUin=" + l6 + "，isHotChatMsg = " + bool1 + ",ti = " + localObject2);
                                }
                                if ((!bool1) && (localObject2 == null))
                                {
                                  if (QLog.isColorLevel()) {
                                    QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis: troopUin=" + l1 + ", memberUin=" + l6 + " troopinfo is null, getGroupInfoReq ");
                                  }
                                  localObject2 = new TroopInfo();
                                  ((TroopInfo)localObject2).troopuin = parambbpd;
                                  paramazai.b((TroopInfo)localObject2);
                                  ((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).j(parambbpd);
                                }
                                localObject2 = String.valueOf(l6);
                                i3 = ((msg_comm.GroupInfo)localObject5).group_level.get();
                                localObject6 = bdrv.a(((msg_comm.GroupInfo)localObject5).group_card.get());
                                i6 = ((msg_comm.GroupInfo)localObject5).group_card_type.get();
                                if (bool1) {
                                  ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).b(l1);
                                }
                                if (!bool2) {
                                  break label8359;
                                }
                                paramazai = paramArrayList.iterator();
                                while (paramazai.hasNext()) {
                                  ((MessageRecord)paramazai.next()).isOpenTroopMessage = true;
                                }
                                paramazai = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                                if ((paramazai == null) || (paramazai.f(parambbpd))) {
                                  break label8359;
                                }
                                paramazai = (amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
                                if (paramazai == null) {
                                  break label8359;
                                }
                                paramazai.f(parambbpd, false);
                                break label8359;
                                label7020:
                                if (i2 != -100)
                                {
                                  paramazai = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                                  if (paramazai != null) {
                                    paramazai.a(parambbpd, (String)localObject2, i2);
                                  }
                                }
                                if (paramBoolean) {
                                  paramazai = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                                }
                                switch (i6)
                                {
                                case 1: 
                                  paramazai.a(parambbpd, (String)localObject2, (String)localObject6, i, null, null, 0, 1, 100, l3, b2, 0L, d, null, -100, j, k, m, n, i1, i5);
                                case 2: 
                                  for (;;)
                                  {
                                    label7096:
                                    paramazai.a(parambbpd, (String)localObject2, (String)localObject3);
                                    paramazai = null;
                                    label7149:
                                    if ((localObject2 == null) || (((String)localObject2).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
                                      break label8400;
                                    }
                                    localObject2 = (bcml)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132);
                                    if (((bcml)localObject2).a(parambbpd)) {
                                      break label8400;
                                    }
                                    if (!((bcml)localObject2).b(parambbpd)) {
                                      break label7595;
                                    }
                                    i2 = paramArrayList.size();
                                    i = 0;
                                    i3 = i2 - 1;
                                    if (i3 < 0) {
                                      break label7595;
                                    }
                                    localObject3 = (MessageRecord)paramArrayList.get(i3);
                                    i2 = i;
                                    if (!bcml.a((MessageRecord)localObject3)) {
                                      break label8393;
                                    }
                                    if ((!TextUtils.isEmpty(((MessageRecord)localObject3).msg)) || (((MessageRecord)localObject3).msgData != null)) {
                                      break;
                                    }
                                    break label8375;
                                    paramazai.a(parambbpd, (String)localObject2, (String)localObject6, i, null, null, 0, 1, 100, l3, b2, 0L, d, null, -100, j, k, m, n, i1, i5);
                                    continue;
                                    paramazai.a(parambbpd, (String)localObject2, "", i, (String)localObject6, null, 0, 1, 100, l3, b2, 0L, d, null, -100, j, k, m, n, i1, i5);
                                  }
                                  paramazai = new TroopMemberInfo();
                                  paramazai.troopuin = parambbpd;
                                  paramazai.memberuin = ((String)localObject2);
                                  switch (i6)
                                  {
                                  case 2: 
                                    label7400:
                                    localObject3 = bdrv.b((String)localObject6);
                                    paramazai.troopColorNick = ((String)localObject6);
                                    paramazai.troopnick = ((String)localObject3);
                                    for (;;)
                                    {
                                      paramazai.level = i;
                                      paramazai.realLevel = i3;
                                      paramazai.sex = 1;
                                      paramazai.age = 0;
                                      paramazai.distance = 100;
                                      paramazai.msgseq = l3;
                                      if (b2 != 1) {
                                        break label8387;
                                      }
                                      paramBoolean = true;
                                      label7462:
                                      paramazai.isTroopFollowed = paramBoolean;
                                      paramazai.distanceToSelf = d;
                                      paramazai.distanceToSelfUpdateTimeStamp = System.currentTimeMillis();
                                      break;
                                      paramazai.troopnick = "";
                                      paramazai.friendnick = ((String)localObject6);
                                    }
                                    i2 = i;
                                    if (i == 0)
                                    {
                                      ((bcml)localObject2).a(parambbpd, ((MessageRecord)localObject3).uniseq);
                                      i2 = 1;
                                    }
                                    if (QLog.isColorLevel()) {
                                      QLog.d("TroopBindPublicAccountMgr.redDot", 2, "decodePBAccountMSg:" + parambbpd + "," + ((MessageRecord)localObject3).uniseq + "," + ((MessageRecord)localObject3).shmsgseq);
                                    }
                                    ((bcml)localObject2).c(parambbpd);
                                    break label8393;
                                    label7595:
                                    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(parambbpd) != 3) {
                                      break label8400;
                                    }
                                    if (QLog.isColorLevel()) {
                                      QLog.d(".troop.closeRcvMsgTmp", 2, "Shield troop recv msg:" + parambbpd);
                                    }
                                    ((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(parambbpd, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, 0);
                                    break label8400;
                                  }
                                  break;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                    break;
                  }
                }
              }
            }
          }
        }
      }
    }
    label7938:
    label7985:
    label8113:
    label8119:
    label8249:
    label8255:
    label8261:
    label8267:
    label8400:
    for (;;)
    {
      label7671:
      i = azad.a(paramMsg);
      i2 = azad.e(paramMsg);
      i3 = azad.c(paramMsg);
      i4 = azad.b(paramMsg);
      i5 = azad.d(paramMsg);
      paramMsg = paramArrayList.iterator();
      while (paramMsg.hasNext())
      {
        paramArrayList = (MessageRecord)paramMsg.next();
        paramArrayList.vipBubbleDiyTextId = i;
        Object localObject1;
        paramArrayList.vipBubbleID = amca.a((int)localObject1, i);
        paramArrayList.vipSubBubbleId = i2;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramArrayList.time);
        if (i2 != 0) {
          paramArrayList.saveExtInfoToExtStr("bubble_sub_id", String.valueOf(i2));
        }
        if (i3 > 0) {
          paramArrayList.saveExtInfoToExtStr("vip_pendant_diy_id", String.valueOf(i3));
        }
        if (i5 >= 0) {
          paramArrayList.saveExtInfoToExtStr("vip_face_id", String.valueOf(i5));
        }
        if (i4 >= 0) {
          paramArrayList.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(i4));
        }
        if (j > 0) {
          paramArrayList.saveExtInfoToExtStr("vip_type", String.valueOf(j));
        }
        if (k > 0) {
          paramArrayList.saveExtInfoToExtStr("vip_level", String.valueOf(k));
        }
        if (m > 0) {
          paramArrayList.saveExtInfoToExtStr("bigClub_type", String.valueOf(m));
        }
        if (n > 0) {
          paramArrayList.saveExtInfoToExtStr("bigClub_level", String.valueOf(n));
        }
        if (i1 > 0) {
          paramArrayList.saveExtInfoToExtStr("vip_card_id", String.valueOf(i1));
        }
      }
      bhsm.a().g(System.currentTimeMillis() - l5);
      return paramazai;
      label8020:
      label8027:
      label8030:
      label8036:
      label8052:
      do
      {
        paramazai = null;
        break label7149;
        i = i18;
        j = i17;
        k = i16;
        m = i15;
        n = i14;
        i1 = i13;
        i2 = i12;
        i3 = i10;
        i4 = i11;
        bool1 = bool6;
        bool2 = bool5;
        break label8159;
        parambbpd = null;
        break label6345;
        i2 = -100;
        bool1 = false;
        i4 = i3;
        bool2 = bool3;
        break label6677;
        l1 = 0L;
        break label4494;
        paramazai = null;
        break label7671;
        localObject3 = localObject5;
        break label4037;
        break label8081;
        l1 = 0L;
        break label1132;
        localObject2 = null;
        l1 = 0L;
        break label284;
        do
        {
          l4 = l1;
          break label233;
          j = 0;
          k = 0;
          m = 0;
          break;
          return null;
        } while (l1 != -1L);
        long l4 = 0L;
        break label233;
        break label3276;
        i += 1;
        break label1396;
        i = 2;
        break label2991;
        localObject5 = "";
        break label3955;
        bool5 = bool1;
        break label4636;
        n = 1;
        break label5087;
        i = i9;
        j = i8;
        k = i7;
        m = i6;
        n = i5;
        i5 = i2;
        bool1 = bool4;
        bool2 = bool3;
        i2 = i1;
        i1 = i5;
        for (;;)
        {
          bool3 = bool2;
          i5 = i2;
          i2 = m;
          i6 = n;
          n = j;
          m = k;
          k = i2;
          j = i6;
          i2 = i1;
          i1 = i5;
          bool2 = bool1;
          bool1 = bool3;
          break;
          for (;;)
          {
            bool5 = bool1;
            break;
            bool2 = false;
          }
          bool5 = true;
          break label4636;
          i2 = -100;
          break label4827;
          i6 = -100;
          break label4848;
          i1 = 0;
          break label4869;
          i5 = 0;
          break label4890;
          i5 = 0;
          break label5068;
          parambbpd = null;
          break label5575;
          bool1 = false;
          break label5765;
          i5 = k;
          i6 = j;
          i7 = i1;
          bool3 = bool1;
          j = n;
          k = m;
          m = i5;
          n = i6;
          i1 = i2;
          i2 = i7;
          bool1 = bool2;
          bool2 = bool3;
        }
        i5 = n;
        i6 = m;
        n = k;
        m = j;
        k = i2;
        i2 = i3;
        j = i1;
        i1 = i6;
        break label6677;
        if (i4 == 0) {
          break label7020;
        }
      } while (!bool1);
      label8159:
      break label7020;
      label8273:
      break label7096;
      for (;;)
      {
        i3 -= 1;
        break;
        break label7400;
        paramBoolean = false;
        break label7462;
        i = i2;
      }
    }
  }
  
  protected String a(msg_comm.Msg paramMsg)
  {
    long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    return 64 + "key_seq_" + l;
  }
  
  public List<MessageRecord> a(msg_comm.Msg paramMsg, azai paramazai)
  {
    return null;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  protected void a(MessageRecord paramMessageRecord)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageRecord))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "handle push . notifySendMessageSuccessful" + paramMessageRecord.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
      a(6003, true, new Object[] { paramMessageRecord.frienduin, String.valueOf(paramMessageRecord.uniseq) });
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramMessageRecord.msgseq);
      if (abti.q(paramMessageRecord.msgtype))
      {
        alwy localalwy = new alwy();
        localalwy.b = 1000;
        localalwy.c = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(5006, true, new Object[] { Long.valueOf(paramMessageRecord.uniseq), localalwy });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     absp
 * JD-Core Version:    0.7.0.1
 */