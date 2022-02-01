import android.text.TextUtils;
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
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import gxh_message.Dialogue;
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

public class aczr
  extends aczo
{
  protected Comparator a;
  
  public aczr(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_JavaUtilComparator = new aczt(this);
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
        if (apzu.a(paramMessageRecord.ark_app_message.appName)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected TroopMemberInfo a(msg_comm.Msg paramMsg, ArrayList<MessageRecord> paramArrayList, bcsb parambcsb, boolean paramBoolean, bfoy parambfoy)
  {
    long l4;
    Object localObject6;
    long l5;
    long l3;
    long l2;
    long l6;
    Object localObject7;
    Object localObject1;
    int m;
    int k;
    int j;
    long l7;
    Object localObject2;
    bfoy localbfoy;
    long l1;
    label250:
    Object localObject3;
    byte b2;
    MessageRecord localMessageRecord;
    byte b1;
    Object localObject5;
    Object localObject8;
    for (;;)
    {
      try
      {
        l4 = System.currentTimeMillis();
        if ((parambcsb == null) || (paramMsg == null) || (paramArrayList == null)) {
          break label8271;
        }
        localObject6 = (msg_comm.MsgHead)paramMsg.msg_head.get();
        l5 = ((msg_comm.MsgHead)localObject6).from_uin.get();
        ((msg_comm.MsgHead)localObject6).to_uin.get();
        l3 = ((msg_comm.MsgHead)localObject6).msg_seq.get();
        l2 = ((msg_comm.MsgHead)localObject6).msg_time.get();
        l6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
        localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (parambcsb.jdField_e_of_type_Int == 1026)
        {
          l3 = bhjx.a(((msg_comm.MsgHead)localObject6).msg_seq.get());
          l2 = bhjx.a(((msg_comm.MsgHead)localObject6).msg_time.get());
        }
        if (!paramMsg.content_head.has()) {
          break label8259;
        }
        localObject1 = (msg_comm.ContentHead)paramMsg.content_head.get();
        m = ((msg_comm.ContentHead)localObject1).div_seq.get();
        k = ((msg_comm.ContentHead)localObject1).pkg_num.get();
        j = ((msg_comm.ContentHead)localObject1).pkg_index.get();
        l7 = bcrw.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, String.valueOf(l5), String.valueOf(l5));
        localObject2 = new ArrayList();
        localbfoy = new bfoy();
        if (paramMsg.appshare_info.has())
        {
          bcse.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, (List)localObject2, paramMsg, parambcsb.jdField_e_of_type_Long, l2, false);
          localObject1 = null;
          l1 = 0L;
          if ((((List)localObject2).size() == 0) && (k > 1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "<---decodeSinglePbMsg_GroupDis, empty long msg fragment");
            }
            localObject3 = (MessageForText)bcry.a(-1000);
            ((MessageForText)localObject3).msgtype = -1000;
            ((MessageForText)localObject3).msg = "";
            ((List)localObject2).add(localObject3);
          }
          b2 = 0;
          Iterator localIterator = ((List)localObject2).iterator();
          localObject2 = null;
          if (!localIterator.hasNext()) {
            break label4434;
          }
          localMessageRecord = (MessageRecord)localIterator.next();
          localMessageRecord.time = l2;
          localMessageRecord.msgseq = l2;
          localMessageRecord.shmsgseq = l3;
          localMessageRecord.msgUid = l1;
          localMessageRecord.selfuin = ((String)localObject7);
          localMessageRecord.istroop = parambcsb.jdField_e_of_type_Int;
          localMessageRecord.senderuin = String.valueOf(l5);
          localMessageRecord.frienduin = String.valueOf(parambcsb.jdField_e_of_type_Long);
          localMessageRecord.longMsgId = m;
          localMessageRecord.longMsgCount = k;
          localMessageRecord.longMsgIndex = j;
          if (((localMessageRecord instanceof MessageForFoldMsg)) && (QLog.isColorLevel())) {
            QLog.d("msgFold", 2, String.format("Recv, recv foldMsg, frienduin: %s, senduin: %s, msguid: %s, shmsgseq: %s content: %s", new Object[] { localMessageRecord.frienduin, localMessageRecord.senderuin, Long.valueOf(localMessageRecord.msgUid), Long.valueOf(localMessageRecord.shmsgseq), localMessageRecord.getLogColorContent() }));
          }
          if (parambcsb.f == 127)
          {
            localMessageRecord.msg = "PTT_URL";
            localMessageRecord.msgtype = -2006;
            localMessageRecord.isread = true;
          }
          if (localMessageRecord.msgtype == -1035) {
            ((ChatMessage)localMessageRecord).parse();
          }
          b1 = b2;
          if (((msg_comm.MsgHead)localObject6).msg_flag.has())
          {
            b1 = b2;
            if ((((msg_comm.MsgHead)localObject6).msg_flag.get() & 1L) == 1L)
            {
              b1 = b2;
              if (localMessageRecord.msgtype != -2058)
              {
                b2 = 1;
                localbfoy.jdField_a_of_type_Bfoz.a(17, l3, localMessageRecord.uniseq);
                b1 = b2;
                if (QLog.isColorLevel())
                {
                  QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "receive the TroopMsg from TroopSpecialAttention!");
                  b1 = b2;
                }
              }
            }
          }
          if ((localMessageRecord.istroop == 1) && (bidn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localMessageRecord.msg, localMessageRecord.frienduin))) {
            localbfoy.jdField_a_of_type_Bfoz.a(16, l3, localMessageRecord.uniseq);
          }
          if (((localMessageRecord instanceof MessageForTroopConfess)) && (((MessageForTroopConfess)localMessageRecord).isToSelf)) {
            localbfoy.jdField_a_of_type_Bfoz.a(10, l3, localMessageRecord.uniseq);
          }
          if (a(localMessageRecord)) {
            localbfoy.jdField_a_of_type_Bfoz.a(5, l3, localMessageRecord.uniseq);
          }
          if (b(localMessageRecord)) {
            localbfoy.jdField_a_of_type_Bfoz.a(19, l3, localMessageRecord.uniseq);
          }
          if (c(localMessageRecord)) {
            localbfoy.jdField_a_of_type_Bfoz.a(20, l3, localMessageRecord.uniseq);
          }
          if (((parambcsb.jdField_e_of_type_Int != 1) && (parambcsb.jdField_e_of_type_Int != 1026)) || (localObject1 == null)) {
            break;
          }
          localObject3 = ((List)localObject1).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject5 = (im_msg_body.Elem)((Iterator)localObject3).next();
          if ((!((im_msg_body.Elem)localObject5).general_flags.has()) || (!((im_msg_body.Elem)localObject5).general_flags.bytes_pb_reserve.has())) {
            continue;
          }
          localObject8 = new generalflags.ResvAttr();
          ((generalflags.ResvAttr)localObject8).mergeFrom(((im_msg_body.Elem)localObject5).general_flags.bytes_pb_reserve.get().toByteArray());
          if ((!((generalflags.ResvAttr)localObject8).uint32_group_savedb_flag.has()) || ((((generalflags.ResvAttr)localObject8).uint32_group_savedb_flag.get() & 0x1) != 1)) {
            continue;
          }
          localbfoy.jdField_a_of_type_Bfoz.a(23, l3, localMessageRecord.uniseq);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis, should show shop ark");
          continue;
        }
        if (!paramMsg.msg_body.has()) {
          break label8250;
        }
      }
      catch (Throwable paramMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis failure : ", paramMsg);
        }
        return null;
      }
      localObject1 = (im_msg_body.MsgBody)paramMsg.msg_body.get();
      if (!((im_msg_body.MsgBody)localObject1).rich_text.has()) {
        break label8250;
      }
      localObject3 = (im_msg_body.RichText)((im_msg_body.MsgBody)localObject1).rich_text.get();
      if (!((im_msg_body.RichText)localObject3).attr.has()) {
        break label8244;
      }
      l1 = bcsa.a(((im_msg_body.Attr)((im_msg_body.RichText)localObject3).attr.get()).random.get());
      label1095:
      localObject1 = ((im_msg_body.RichText)localObject3).elems.get();
      if (((im_msg_body.RichText)localObject3).ptt.has())
      {
        new bcsk().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, (List)localObject2, null);
      }
      else
      {
        localbfoy.jdField_a_of_type_JavaLangString = String.valueOf(parambcsb.jdField_e_of_type_Long);
        localbfoy.jdField_a_of_type_Int = parambcsb.jdField_e_of_type_Int;
        bcrw.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, (List)localObject2, paramMsg, false, false, localbfoy);
      }
    }
    if (localMessageRecord.msgtype == -1049)
    {
      localObject3 = (MessageForReplyText)localMessageRecord;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((MessageForReplyText)localObject3).mSourceMsgInfo.mSourceMsgSenderUin + ""))) {
        localbfoy.jdField_a_of_type_Bfoz.a(22, l3, localMessageRecord.uniseq);
      }
    }
    if (localMessageRecord.msgtype == -5015) {
      localbfoy.jdField_a_of_type_Bfoz.a(6, l3, localMessageRecord.uniseq);
    }
    if (localMessageRecord.msgtype == -2058) {
      EmojiStickerManager.a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    int i;
    if (((localMessageRecord.msgtype != -2058) || (parambfoy.jdField_a_of_type_Bfoz.a != -1L) || (parambfoy.jdField_a_of_type_Bfoz.b != -1L)) || (localMessageRecord.msgtype == -1035))
    {
      localObject3 = (MessageForMixedMsg)localMessageRecord;
      i = 0;
      label1371:
      if (i < ((MessageForMixedMsg)localObject3).msgElemList.size())
      {
        localObject5 = (MessageRecord)((MessageForMixedMsg)localObject3).msgElemList.get(i);
        if (!(localObject5 instanceof MessageForReplyText)) {
          break label8276;
        }
        localObject3 = (MessageForReplyText)localObject5;
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((MessageForReplyText)localObject3).mSourceMsgInfo.mSourceMsgSenderUin + ""))) {
          localbfoy.jdField_a_of_type_Bfoz.a(22, l3, localMessageRecord.uniseq);
        }
      }
    }
    boolean bool1;
    if ((localMessageRecord.msgtype == -2035) || (localMessageRecord.msgtype == -2038))
    {
      localObject3 = (MessageForDeliverGiftTips)localMessageRecord;
      localObject5 = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForDeliverGiftTips)localObject3).istroop, ((MessageForDeliverGiftTips)localObject3).frienduin, ((MessageForDeliverGiftTips)localObject3).senderuin);
      if (!TextUtils.isEmpty((CharSequence)localObject5)) {
        ((MessageForDeliverGiftTips)localObject3).senderName = ((String)localObject5);
      }
      if (!((MessageForDeliverGiftTips)localObject3).isFromNearby)
      {
        localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (!TextUtils.isEmpty((CharSequence)localObject5))
        {
          if ((!((String)localObject5).equals(((MessageForDeliverGiftTips)localObject3).receiverUin + "")) && (!((MessageForDeliverGiftTips)localObject3).isToAll())) {
            break label3332;
          }
          localObject5 = localbfoy.jdField_a_of_type_Bfoz;
          localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (localMessageRecord.istroop != 1) {
            break label8285;
          }
          bool1 = true;
          label1642:
          ((bfoz)localObject5).a((QQAppInterface)localObject8, bool1, localMessageRecord.frienduin, l3, localMessageRecord.uniseq);
        }
        localObject5 = (bgot)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
        if (localObject5 != null) {
          ((bgot)localObject5).b((MessageForDeliverGiftTips)localObject3);
        }
      }
    }
    if (axuz.a(localMessageRecord))
    {
      localObject3 = new NearbyFlowerMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForStructing)localMessageRecord);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((NearbyFlowerMessage)localObject3).rUin)) {
          break label3361;
        }
        localObject3 = localbfoy.jdField_a_of_type_Bfoz;
        localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localMessageRecord.istroop != 1) {
          break label8291;
        }
        bool1 = true;
        label1771:
        ((bfoz)localObject3).a((QQAppInterface)localObject5, bool1, localMessageRecord.frienduin, l3, localMessageRecord.uniseq);
      }
    }
    label1793:
    long l8;
    if ((localMessageRecord instanceof MessageForStructing))
    {
      localObject3 = bdow.a(localMessageRecord.msgData);
      if ((localObject3 instanceof StructMsgForGeneralShare))
      {
        localObject3 = (StructMsgForGeneralShare)localObject3;
        if ((localObject3 == null) || (((StructMsgForGeneralShare)localObject3).mMsgServiceID != 75)) {
          break label3400;
        }
        localObject3 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        l8 = localMessageRecord.uniseq;
        localObject3 = localMessageRecord.frienduin;
        localObject8 = new aczl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject5 = ((aczl)localObject8).jdField_a_of_type_Apaw;
        localObject8 = ((aczl)localObject8).jdField_a_of_type_JavaUtilMap;
        localObject5 = (RecentUser)((apaw)localObject5).findRecentUserByUin((String)localObject3, 1);
        TroopManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord.frienduin, StructMsgForGeneralShare.eventId, localMessageRecord.shmsgseq, new aczs(this, false, localbfoy, l3, l8, (RecentUser)localObject5, (String)localObject3, localMessageRecord, (Map)localObject8));
      }
    }
    label1953:
    if ((localMessageRecord instanceof MessageForTroopFile)) {
      localbfoy.jdField_a_of_type_Bfoz.a(3, l3, localMessageRecord.uniseq);
    }
    if (bgre.a(localMessageRecord)) {
      localbfoy.jdField_a_of_type_Bfoz.a(8, l3, localMessageRecord.uniseq);
    }
    if ((localMessageRecord.msgtype == -5008) && ((localMessageRecord instanceof MessageForArkApp)))
    {
      localObject3 = (MessageForArkApp)localMessageRecord;
      if ((((MessageForArkApp)localObject3).ark_app_message != null) && (((MessageForArkApp)localObject3).ark_app_message.appName.equals("com.tencent.mannounce"))) {
        localbfoy.jdField_a_of_type_Bfoz.a(11, l3, localMessageRecord.uniseq);
      }
    }
    Object localObject9;
    Object localObject10;
    int i1;
    if (localMessageRecord.msgtype == -2039)
    {
      localObject5 = (MessageForApollo)localMessageRecord;
      localObject8 = new ArrayList(2);
      localObject9 = (amsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      localObject3 = null;
      if (QLog.isColorLevel()) {
        localObject3 = new StringBuilder("decode apollo troop msg: ").append(", id: ").append(((MessageForApollo)localObject5).mApolloMessage.id).append(", name: ").append(new String(((MessageForApollo)localObject5).mApolloMessage.name)).append(", doubleAction: ").append(((MessageForApollo)localObject5).isDoubleAction()).append(", time: ").append(localMessageRecord.time).append("\nsender: ").append(localMessageRecord.senderuin);
      }
      if (!localMessageRecord.isSend())
      {
        localObject10 = ((amsx)localObject9).b(((MessageForApollo)localObject5).senderuin);
        if (QLog.isColorLevel()) {
          ((StringBuilder)localObject3).append(", update time: ").append(((ApolloBaseInfo)localObject10).apolloUpdateTime);
        }
        if ((localMessageRecord.time > ((ApolloBaseInfo)localObject10).apolloUpdateTime) && ((((ApolloBaseInfo)localObject10).apolloServerTS < ((MessageForApollo)localObject5).mApolloMessage.sender_ts) || (((ApolloBaseInfo)localObject10).apolloStatus != ((MessageForApollo)localObject5).mApolloMessage.sender_status) || (((ApolloBaseInfo)localObject10).superYellowDiamondFlag != (((MessageForApollo)localObject5).mApolloMessage.flag >> 30 & 0x1)) || ((((MessageForApollo)localObject5).is3dAction()) && (((MessageForApollo)localObject5).mApollo3DMessage != null) && (((ApolloBaseInfo)localObject10).cmshow3dFlag != ((MessageForApollo)localObject5).mApollo3DMessage.senderStatus_3D))))
        {
          ((ApolloBaseInfo)localObject10).apolloStatus = ((MessageForApollo)localObject5).mApolloMessage.sender_status;
          ((ApolloBaseInfo)localObject10).apolloServerTS = ((MessageForApollo)localObject5).mApolloMessage.sender_ts;
          ((ApolloBaseInfo)localObject10).superYellowDiamondFlag = (((MessageForApollo)localObject5).mApolloMessage.flag >> 30 & 0x1);
          if ((((MessageForApollo)localObject5).is3dAction()) && (((MessageForApollo)localObject5).mApollo3DMessage != null)) {
            ((ApolloBaseInfo)localObject10).cmshow3dFlag = ((MessageForApollo)localObject5).mApollo3DMessage.senderStatus_3D;
          }
          ((ApolloBaseInfo)localObject10).apolloUpdateTime = localMessageRecord.time;
          ((ArrayList)localObject8).add(localObject10);
          if (QLog.isColorLevel()) {
            ((StringBuilder)localObject3).append("\n save apollo info: ").append(((ApolloBaseInfo)localObject10).apolloVipFlag).append("|").append(((ApolloBaseInfo)localObject10).apolloStatus).append("|").append(((ApolloBaseInfo)localObject10).apolloLocalTS).append("|").append(((ApolloBaseInfo)localObject10).apolloServerTS).append("|").append(((ApolloBaseInfo)localObject10).cmshow3dFlag).append("|").append(((ApolloBaseInfo)localObject10).apolloUpdateTime);
          }
        }
      }
      if ((((MessageForApollo)localObject5).isDoubleAction()) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ((MessageForApollo)localObject5).mApolloMessage.peer_uin + "")))
      {
        localObject10 = ((amsx)localObject9).b(((MessageForApollo)localObject5).mApolloMessage.peer_uin + "");
        if (QLog.isColorLevel()) {
          ((StringBuilder)localObject3).append("\n peer: ").append(((ApolloBaseInfo)localObject10).uin).append(", update time: ").append(((ApolloBaseInfo)localObject10).apolloUpdateTime);
        }
        if ((localMessageRecord.time > ((ApolloBaseInfo)localObject10).apolloUpdateTime) && ((((ApolloBaseInfo)localObject10).apolloServerTS < ((MessageForApollo)localObject5).mApolloMessage.peer_ts) || (((ApolloBaseInfo)localObject10).apolloStatus != ((MessageForApollo)localObject5).mApolloMessage.peer_status) || (((ApolloBaseInfo)localObject10).superYellowDiamondFlag != (((MessageForApollo)localObject5).mApolloMessage.flag >> 31 & 0x1)) || ((((MessageForApollo)localObject5).is3dAction()) && (((MessageForApollo)localObject5).mApollo3DMessage != null) && (((ApolloBaseInfo)localObject10).cmshow3dFlag != ((MessageForApollo)localObject5).mApollo3DMessage.peerStatus_3D))))
        {
          ((ApolloBaseInfo)localObject10).apolloStatus = ((MessageForApollo)localObject5).mApolloMessage.peer_status;
          ((ApolloBaseInfo)localObject10).apolloServerTS = ((MessageForApollo)localObject5).mApolloMessage.peer_ts;
          ((ApolloBaseInfo)localObject10).superYellowDiamondFlag = (((MessageForApollo)localObject5).mApolloMessage.flag >> 31 & 0x1);
          if ((((MessageForApollo)localObject5).is3dAction()) && (((MessageForApollo)localObject5).mApollo3DMessage != null)) {
            ((ApolloBaseInfo)localObject10).cmshow3dFlag = ((MessageForApollo)localObject5).mApollo3DMessage.peerStatus_3D;
          }
          ((ApolloBaseInfo)localObject10).apolloUpdateTime = localMessageRecord.time;
          ((ArrayList)localObject8).add(localObject10);
          if (QLog.isColorLevel()) {
            ((StringBuilder)localObject3).append("\n save apollo info ").append(((ApolloBaseInfo)localObject10).apolloVipFlag).append("|").append(((ApolloBaseInfo)localObject10).apolloStatus).append("|").append(((ApolloBaseInfo)localObject10).apolloLocalTS).append("|").append(((ApolloBaseInfo)localObject10).apolloServerTS).append("|").append(((ApolloBaseInfo)localObject10).cmshow3dFlag).append("|").append(((ApolloBaseInfo)localObject10).apolloUpdateTime);
          }
        }
      }
      if (((ArrayList)localObject8).size() > 0) {
        ((amsx)localObject9).b((List)localObject8);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, ((StringBuilder)localObject3).toString());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        i1 = ((amsx)localObject9).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        localObject3 = "";
        if (((MessageForApollo)localObject5).msgType != 0) {
          break label3567;
        }
        localObject3 = String.valueOf(((MessageForApollo)localObject5).mApolloMessage.id);
      }
    }
    label3038:
    int n;
    label3297:
    label3567:
    Object localObject4;
    label3332:
    label3361:
    label3400:
    label4067:
    int i3;
    label3985:
    label4434:
    int i7;
    int i5;
    label4518:
    int i2;
    int i6;
    boolean bool2;
    int i4;
    boolean bool4;
    boolean bool3;
    label4664:
    boolean bool5;
    int i12;
    int i11;
    int i10;
    int i9;
    int i8;
    label4863:
    int i23;
    label4884:
    label4905:
    label4926:
    label5057:
    int i22;
    label5144:
    label5163:
    int i21;
    label5651:
    int i20;
    int i19;
    int i18;
    int i17;
    int i16;
    int i15;
    int i13;
    int i14;
    boolean bool6;
    for (;;)
    {
      if (localMessageRecord.istroop == 1)
      {
        i = 1;
        localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(false);
        n = i;
        if (localObject8 != null)
        {
          n = i;
          if (((HotChatManager)localObject8).b(localMessageRecord.frienduin)) {
            n = 3;
          }
        }
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "rev_action", String.valueOf(localMessageRecord.senderuin), n, ((MessageForApollo)localObject5).msgType, new String[] { localObject3, Integer.toString(i1), Integer.toString(amsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)), String.valueOf(System.currentTimeMillis() / 1000L) });
        if (parambfoy != null)
        {
          localbfoy.jdField_a_of_type_Bfoz.a(13, localMessageRecord.uniseq);
          localbfoy.jdField_a_of_type_Bfoz.a(24, localMessageRecord.uniseq);
          if ((l3 > this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(parambcsb.jdField_e_of_type_Long), parambcsb.jdField_e_of_type_Int)) && (localbfoy.a()))
          {
            parambfoy.a(localbfoy);
            localMessageRecord.mMessageInfo = localbfoy;
          }
        }
        if (((parambcsb.jdField_e_of_type_Int == 1) || (parambcsb.jdField_e_of_type_Int == 1026) || (parambcsb.jdField_e_of_type_Int == 3000)) && (localObject1 != null) && (!TextUtils.equals(localMessageRecord.selfuin, localMessageRecord.senderuin)))
        {
          i = 0;
          localObject3 = ((List)localObject1).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            if (!((im_msg_body.Elem)((Iterator)localObject3).next()).anon_group_msg.has()) {
              break label8241;
            }
            i = 1;
            break label8273;
            if (((MessageForDeliverGiftTips)localObject3).animationPackageId <= 0) {
              break;
            }
            localbfoy.jdField_a_of_type_Bfoz.a(7, l3, localMessageRecord.uniseq);
            break;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((NearbyFlowerMessage)localObject3).sUin)) {
              break label1793;
            }
            localbfoy.jdField_a_of_type_Bfoz.a(7, l3, localMessageRecord.uniseq);
            break label1793;
            if ((localObject3 != null) && (((StructMsgForGeneralShare)localObject3).mMsgServiceID == 19) && (!((StructMsgForGeneralShare)localObject3).mMsgBrief.startsWith(anzj.a(2131699937))) && (!((StructMsgForGeneralShare)localObject3).mMsgBrief.equals(anzj.a(2131699931))))
            {
              localbfoy.jdField_a_of_type_Bfoz.a(2, l3, localMessageRecord.uniseq);
              break label1953;
            }
            if ((localObject3 != null) && (((StructMsgForGeneralShare)localObject3).mMsgServiceID == 106))
            {
              if ((((StructMsgForGeneralShare)localObject3).atMembers == null) || (!((StructMsgForGeneralShare)localObject3).atMembers.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
                break label1953;
              }
              localbfoy.jdField_a_of_type_Bfoz.a(24, l3, localMessageRecord.uniseq);
              break label1953;
            }
            if ((localObject3 == null) || (((StructMsgForGeneralShare)localObject3).mMsgServiceID != 107)) {
              break label1953;
            }
            localbfoy.jdField_a_of_type_Bfoz.a(12, l3, localMessageRecord.uniseq);
            break label1953;
            if (!ApolloGameUtil.a(((MessageForApollo)localObject5).msgType)) {
              continue;
            }
            localObject3 = "" + ((MessageForApollo)localObject5).gameId;
            continue;
          }
          localObject3 = ((List)localObject1).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject5 = (im_msg_body.Elem)((Iterator)localObject3).next();
            if ((i == 0) && (((im_msg_body.Elem)localObject5).extra_info.has()))
            {
              localObject5 = (im_msg_body.ExtraInfo)((im_msg_body.Elem)localObject5).extra_info.get();
              if (((im_msg_body.ExtraInfo)localObject5).uint32_msg_tail_id.has())
              {
                n = ((im_msg_body.ExtraInfo)localObject5).uint32_msg_tail_id.get();
                if (n > 0)
                {
                  localObject5 = bcry.a(-1002);
                  if (localObject5 != null)
                  {
                    localObject8 = Integer.toString(n);
                    localObject9 = new SafeMsg.SafeMoreInfo();
                    ((SafeMsg.SafeMoreInfo)localObject9).strMsgTxt.set((String)localObject8);
                    ((MessageRecord)localObject5).init(localMessageRecord.selfuin, localMessageRecord.frienduin, localMessageRecord.senderuin, (String)localObject8, localMessageRecord.time, -1002, localMessageRecord.istroop, localMessageRecord.msgseq);
                    ((MessageRecord)localObject5).isread = true;
                    ((MessageRecord)localObject5).shmsgseq = localMessageRecord.shmsgseq;
                    ((MessageRecord)localObject5).msgData = ((SafeMsg.SafeMoreInfo)localObject9).toByteArray();
                    paramArrayList.add(localObject5);
                  }
                }
              }
            }
          }
        }
        if (parambcsb.jdField_e_of_type_Int != 1)
        {
          localObject3 = localObject2;
          if (parambcsb.jdField_e_of_type_Int != 1026) {}
        }
        else
        {
          localObject3 = localObject2;
          if (localObject1 != null)
          {
            localObject5 = ((List)localObject1).iterator();
            do
            {
              localObject3 = localObject2;
              if (!((Iterator)localObject5).hasNext()) {
                break label8234;
              }
              localObject8 = (im_msg_body.Elem)((Iterator)localObject5).next();
              if (((im_msg_body.Elem)localObject8).anon_group_msg.has())
              {
                localObject8 = (im_msg_body.AnonymousGroupMsg)((im_msg_body.Elem)localObject8).anon_group_msg.get();
                i = ((im_msg_body.AnonymousGroupMsg)localObject8).uint32_flags.get();
                localObject3 = ((im_msg_body.AnonymousGroupMsg)localObject8).str_anon_id.get().toByteArray();
                localObject5 = ((im_msg_body.AnonymousGroupMsg)localObject8).str_anon_nick.get().toByteArray();
                n = ((im_msg_body.AnonymousGroupMsg)localObject8).uint32_head_portrait.get();
                i1 = ((im_msg_body.AnonymousGroupMsg)localObject8).uint32_expire_time.get();
                localObject8 = ((im_msg_body.AnonymousGroupMsg)localObject8).str_rank_color.get().toStringUtf8();
                if (localObject3 == null) {
                  break label8303;
                }
                for (;;)
                {
                  try
                  {
                    localObject3 = new String((byte[])localObject3, "ISO-8859-1");
                    if (localObject5 == null)
                    {
                      localObject5 = "";
                      localMessageRecord.saveExtInfoToExtStr("anonymous", nlj.a(i, (String)localObject3, (String)localObject5, n, i1, (String)localObject8));
                      localMessageRecord.extLong |= 0x3;
                      localObject3 = localObject2;
                      if (!QLog.isColorLevel()) {
                        break label8234;
                      }
                      QLog.d("anonymous_decode", 2, "anonymous_flags = " + i);
                      paramArrayList.add(localMessageRecord);
                      b2 = b1;
                    }
                  }
                  catch (UnsupportedEncodingException localUnsupportedEncodingException)
                  {
                    localUnsupportedEncodingException.printStackTrace();
                    break label8303;
                  }
                  localObject5 = new String((byte[])localObject5);
                }
              }
              localObject4 = localObject2;
              if (((im_msg_body.Elem)localObject8).extra_info.has())
              {
                localObject9 = (im_msg_body.ExtraInfo)((im_msg_body.Elem)localObject8).extra_info.get();
                localObject2 = ((im_msg_body.ExtraInfo)localObject9).bytes_sender_title.get().toStringUtf8();
                i = ((im_msg_body.ExtraInfo)localObject9).uint32_flags.get();
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc.troop.special_msg", 2, "dwFlags:" + i);
                }
                localObject4 = localObject2;
                if (((im_msg_body.ExtraInfo)localObject9).uint32_new_group_flag.has())
                {
                  localObject10 = parambcsb.jdField_e_of_type_Long + "";
                  localObject4 = localObject2;
                  if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b((String)localObject10) != ((im_msg_body.ExtraInfo)localObject9).uint32_new_group_flag.get())
                  {
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject10, Integer.valueOf(((im_msg_body.ExtraInfo)localObject9).uint32_new_group_flag.get()));
                    localObject4 = localObject2;
                  }
                }
              }
              localObject2 = localObject4;
            } while (!((im_msg_body.Elem)localObject8).group_business_msg.has());
            localObject8 = bgrg.a(((im_msg_body.Elem)localObject8).group_business_msg);
            bgrf.a(localMessageRecord, (bgrg)localObject8);
            localObject9 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (localMessageRecord.frienduin == null) {}
            for (localObject2 = "";; localObject2 = localMessageRecord.frienduin)
            {
              bdll.b((QQAppInterface)localObject9, "P_CliOper", "Grp_AIO", "", "five_m", "revice_msg", 0, 0, (String)localObject2, localMessageRecord.msgtype + "", ((bgrg)localObject8).c, "");
              localObject2 = localObject4;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decode group_business_msg:" + localObject8);
              localObject2 = localObject4;
              break;
            }
            i3 = -100;
            j = -100;
            k = -100;
            m = -100;
            n = -100;
            i1 = -100;
            i7 = 0;
            i5 = 0;
            if ((parambcsb.jdField_e_of_type_Int == 1) || (parambcsb.jdField_e_of_type_Int == 1026))
            {
              double d = -100.0D;
              i = -1;
              localObject4 = (msg_comm.GroupInfo)((msg_comm.MsgHead)localObject6).group_info.get();
              if (localObject4 != null)
              {
                l1 = ((msg_comm.GroupInfo)localObject4).group_code.get();
                if (localObject1 != null)
                {
                  localObject1 = ((List)localObject1).iterator();
                  j = 0;
                  i1 = -100;
                  n = -100;
                  m = -100;
                  i2 = -100;
                  i6 = 0;
                  bool1 = false;
                  bool2 = false;
                  i = -1;
                  d = -100.0D;
                  i4 = -100;
                  k = -100;
                  for (;;)
                  {
                    if (((Iterator)localObject1).hasNext())
                    {
                      localObject5 = (im_msg_body.Elem)((Iterator)localObject1).next();
                      if (((im_msg_body.Elem)localObject5).general_flags.has())
                      {
                        bool4 = bool2;
                        bool3 = bool1;
                        if (!((im_msg_body.Elem)localObject5).general_flags.uint32_group_type.has()) {}
                      }
                      switch (((im_msg_body.Elem)localObject5).general_flags.uint32_group_type.get())
                      {
                      case 1: 
                        label5868:
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
                          if (((im_msg_body.Elem)localObject5).general_flags.uint32_glamour_level.has()) {
                            i3 = ((im_msg_body.Elem)localObject5).general_flags.uint32_glamour_level.get();
                          }
                          i12 = i;
                          i11 = i5;
                          i10 = j;
                          i9 = i1;
                          i8 = n;
                          i7 = m;
                          i5 = k;
                          if (((im_msg_body.Elem)localObject5).general_flags.bytes_pb_reserve.has())
                          {
                            parambfoy = new generalflags.ResvAttr();
                            parambfoy.mergeFrom(((im_msg_body.Elem)localObject5).general_flags.bytes_pb_reserve.get().toByteArray());
                            if (parambfoy.uint32_rich_card_name_ver.has()) {
                              parambfoy.uint32_rich_card_name_ver.get();
                            }
                            if (!parambfoy.uint32_nearby_charm_level.has()) {
                              break label8460;
                            }
                            i4 = parambfoy.uint32_nearby_charm_level.get();
                            if (!parambfoy.uint32_global_group_level.has()) {
                              break label8467;
                            }
                            i7 = parambfoy.uint32_global_group_level.get();
                            if (!parambfoy.uint32_vip_type.has()) {
                              break label8474;
                            }
                            i2 = parambfoy.uint32_vip_type.get();
                            if (!parambfoy.uint32_vip_level.has()) {
                              break label8480;
                            }
                            i5 = parambfoy.uint32_vip_level.get();
                            i8 = VipUtils.c(i5);
                            if (parambfoy.uint32_user_bigclub_flag.has()) {
                              k = parambfoy.uint32_user_bigclub_flag.get();
                            }
                            if (parambfoy.uint32_user_bigclub_level.has()) {
                              m = parambfoy.uint32_user_bigclub_level.get();
                            }
                            if (parambfoy.uint32_nameplate.has()) {
                              n = parambfoy.uint32_nameplate.get();
                            }
                            if (parambfoy.bytes_user_vip_info.has())
                            {
                              localObject6 = new Dialogue();
                              ((Dialogue)localObject6).mergeFrom(parambfoy.bytes_user_vip_info.get().toByteArray());
                              if (!((Dialogue)localObject6).short_nameplate_itemid.has()) {
                                break label8486;
                              }
                              i1 = ((Dialogue)localObject6).short_nameplate_itemid.get();
                              break label8317;
                            }
                            i10 = j;
                            i5 = k;
                            if (k != 0)
                            {
                              i10 = j;
                              i5 = k;
                              if (parambfoy.uint32_nameplate_vip_type.has())
                              {
                                i10 = j;
                                i5 = k;
                                if (parambfoy.uint32_gray_name_plate.has())
                                {
                                  i5 = parambfoy.uint32_nameplate_vip_type.get();
                                  localObject6 = bhtz.a(i5);
                                  if ((!bhty.a(i5)) || (((bhtz)localObject6).b())) {
                                    break label8492;
                                  }
                                  i5 = 1;
                                  if ((parambfoy.uint32_gray_name_plate.get() != 0) || (i5 != 0)) {
                                    break label8320;
                                  }
                                  i10 = j;
                                  i5 = k;
                                  if (k == 3)
                                  {
                                    i10 = j;
                                    i5 = k;
                                    if (!((bhtz)localObject6).c())
                                    {
                                      i5 = 1;
                                      i10 = j;
                                    }
                                  }
                                }
                              }
                            }
                            if (QLog.isColorLevel()) {
                              QLog.d("kaiyan", 2, "isHideBigClub=" + i10);
                            }
                            i12 = i;
                            if (parambfoy.uint32_title_id.has())
                            {
                              j = parambfoy.uint32_title_id.get();
                              if (j > 0) {
                                i = j;
                              }
                              i12 = i;
                              if (QLog.isColorLevel())
                              {
                                QLog.d("TroopRankConfig", 2, "decodeSinglePbMsg_GroupDis, titleId=" + j + ", troopUin=" + l1 + ", sender=" + l5 + ", msgTime=" + l2 + ", isSaveDb=" + paramBoolean);
                                i12 = i;
                              }
                            }
                            if ((parambcsb.jdField_e_of_type_Int == 1) && (parambfoy.uint32_group_member_flag_ex2.has()))
                            {
                              i = parambfoy.uint32_group_member_flag_ex2.get();
                              aorg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, i);
                            }
                            if ((parambcsb.jdField_e_of_type_Int == 1) && (parambfoy.uint32_group_ringtone_id.has()) && (parambfoy.uint32_group_ringtone_id.get() > 0))
                            {
                              i = parambfoy.uint32_group_ringtone_id.get();
                              aorg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, i);
                            }
                            localObject6 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                            if (localObject6 != null) {
                              ((TroopManager)localObject6).a(String.valueOf(l1), String.valueOf(l5), i4, i7);
                            }
                            if ((parambcsb.jdField_e_of_type_Int == 1) && (parambfoy.uint32_custom_featureid.has()) && (localObject6 != null) && (parambfoy.uint32_custom_featureid.get() == 19713))
                            {
                              if (QLog.isColorLevel()) {
                                QLog.d(".troop.qidian_private_troop", 2, "decodeSinglePbMsg_GroupDis, hasPrivateTroopFlag, troopUin=" + l1);
                              }
                              localObject7 = ((TroopManager)localObject6).b(String.valueOf(l1));
                              if ((localObject7 != null) && (!((TroopInfo)localObject7).isQidianPrivateTroop()))
                              {
                                ((TroopInfo)localObject7).setQidianPrivateTroopFlag();
                                ((TroopManager)localObject6).b((TroopInfo)localObject7);
                                if (QLog.isColorLevel()) {
                                  QLog.d(".troop.qidian_private_troop", 2, "set privateTroop flag, troopUin=" + l1);
                                }
                              }
                            }
                            if (!parambfoy.bytes_hudong_mark.has()) {
                              break label8498;
                            }
                            parambfoy = parambfoy.bytes_hudong_mark.get().toByteArray();
                            localObject6 = bggn.a(parambfoy);
                            ((bggj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(346)).a(String.valueOf(l1), String.valueOf(l5), (String)localObject6);
                            i11 = bgnm.a(parambfoy);
                            i4 = i8;
                            i7 = m;
                            i8 = n;
                            i9 = i1;
                          }
                          i23 = i12;
                          i22 = i11;
                          i21 = i10;
                          i20 = i9;
                          i19 = i8;
                          i18 = i7;
                          i17 = i5;
                          i16 = i4;
                          i15 = i2;
                          i13 = i3;
                          i14 = i6;
                          bool6 = bool4;
                          bool5 = bool3;
                          if (parambcsb.jdField_e_of_type_Int != 1) {
                            break label8139;
                          }
                          i23 = i12;
                          i22 = i11;
                          i21 = i10;
                          i20 = i9;
                          i19 = i8;
                          i18 = i7;
                          i17 = i5;
                          i16 = i4;
                          i15 = i2;
                          i13 = i3;
                          i14 = i6;
                          bool6 = bool4;
                          bool5 = bool3;
                          if (!((im_msg_body.Elem)localObject5).general_flags.uint64_group_rank_seq.has()) {
                            break label8139;
                          }
                          parambfoy = String.valueOf(l1);
                          if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.c())) {
                            break label8504;
                          }
                          bool1 = true;
                          if (!bool1) {
                            break;
                          }
                          localObject6 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(parambfoy);
                          if (localObject6 == null) {
                            break label8326;
                          }
                          l8 = ((im_msg_body.Elem)localObject5).general_flags.uint64_group_rank_seq.get();
                          if (QLog.isColorLevel()) {
                            QLog.d("Q.getTroopMemberLevelInfo", 2, "onNewMsg: troopUin=" + parambfoy + ", serverRankSeq=" + l8 + ", localRankSeq=" + ((TroopInfo)localObject6).dwGroupLevelSeq + ", isSyncMsgFinish=" + bool1);
                          }
                          if (l8 <= ((TroopInfo)localObject6).dwGroupLevelSeq) {
                            break label8326;
                          }
                          ((aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).c(parambfoy, false);
                          break label8326;
                          bool5 = bool1;
                        } while (!((im_msg_body.Elem)localObject5).general_flags.uint32_to_uin_flag.has());
                        if (((im_msg_body.Elem)localObject5).general_flags.uint32_to_uin_flag.get() == 2)
                        {
                          bool2 = true;
                          break label8441;
                          if (QLog.isColorLevel())
                          {
                            QLog.d("Q.getTroopMemberLevelInfo", 2, "onNewMsg: troopUin=" + parambfoy + ", isSyncMsgFinish=" + bool1);
                            break label8326;
                            if ((((im_msg_body.Elem)localObject5).extra_info.has()) && (((im_msg_body.Elem)localObject5).extra_info.uint32_flags.has()))
                            {
                              i23 = i;
                              i22 = i5;
                              i21 = j;
                              i20 = i1;
                              i19 = n;
                              i18 = m;
                              i17 = k;
                              i16 = i4;
                              i15 = i2;
                              i13 = i3;
                              i14 = i6;
                              bool6 = bool2;
                              bool5 = bool1;
                              if (bool1)
                              {
                                i7 = ((im_msg_body.Elem)localObject5).extra_info.uint32_flags.get();
                                if (QLog.isColorLevel()) {
                                  QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "elem.extra_info.uint32_flags:" + i7 + "|groupCode:" + l1 + "fromUin:" + l5);
                                }
                                if ((i7 & 0x10) != 16) {
                                  break label8510;
                                }
                                parambfoy = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).a(l1 + "");
                                localObject5 = l5 + "";
                                if ((parambfoy == null) || (parambfoy.adminUins.contains(localObject5))) {
                                  break label8510;
                                }
                                parambfoy.adminUins.add(localObject5);
                                break label8510;
                              }
                            }
                            else if (((im_msg_body.Elem)localObject5).pub_group.has())
                            {
                              i14 = 1;
                              i23 = i;
                              i22 = i5;
                              i21 = j;
                              i20 = i1;
                              i19 = n;
                              i18 = m;
                              i17 = k;
                              i16 = i4;
                              i15 = i2;
                              i13 = i3;
                              bool6 = bool2;
                              bool5 = bool1;
                              if (QLog.isColorLevel())
                              {
                                if (!((im_msg_body.PubGroup)((im_msg_body.Elem)localObject5).pub_group.get()).bytes_nickname.has()) {
                                  break label8194;
                                }
                                parambfoy = ((im_msg_body.PubGroup)((im_msg_body.Elem)localObject5).pub_group.get()).bytes_nickname.get().toStringUtf8();
                                label6464:
                                QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis,receive  pub_group,bytes_nickname = " + parambfoy);
                                i6 = j;
                                i7 = m;
                                i8 = k;
                                i9 = i2;
                                i10 = i3;
                                i11 = 1;
                                bool3 = bool1;
                                j = i5;
                                k = i6;
                                m = i1;
                                i1 = i7;
                                i2 = i8;
                                i3 = i4;
                                i4 = i9;
                                i5 = i10;
                                i6 = i11;
                                bool1 = bool2;
                                bool2 = bool3;
                                break label8382;
                              }
                            }
                            else
                            {
                              i23 = i;
                              i22 = i5;
                              i21 = j;
                              i20 = i1;
                              i19 = n;
                              i18 = m;
                              i17 = k;
                              i16 = i4;
                              i15 = i2;
                              i13 = i3;
                              i14 = i6;
                              bool6 = bool2;
                              bool5 = bool1;
                              if (((im_msg_body.Elem)localObject5).elem_flags2.has())
                              {
                                i23 = i;
                                i22 = i5;
                                i21 = j;
                                i20 = i1;
                                i19 = n;
                                i18 = m;
                                i17 = k;
                                i16 = i4;
                                i15 = i2;
                                i13 = i3;
                                i14 = i6;
                                bool6 = bool2;
                                bool5 = bool1;
                                if (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject5).elem_flags2.get()).uint32_longtitude.has())
                                {
                                  i23 = i;
                                  i22 = i5;
                                  i21 = j;
                                  i20 = i1;
                                  i19 = n;
                                  i18 = m;
                                  i17 = k;
                                  i16 = i4;
                                  i15 = i2;
                                  i13 = i3;
                                  i14 = i6;
                                  bool6 = bool2;
                                  bool5 = bool1;
                                  if (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject5).elem_flags2.get()).uint32_latitude.has())
                                  {
                                    if (l6 == l5) {
                                      continue;
                                    }
                                    d = -1001.0D;
                                    i7 = j;
                                    i8 = m;
                                    i9 = k;
                                    i10 = i2;
                                    i11 = i3;
                                    bool3 = bool1;
                                    j = i5;
                                    k = i7;
                                    m = i1;
                                    i1 = i8;
                                    i2 = i9;
                                    i3 = i4;
                                    i4 = i10;
                                    i5 = i11;
                                    bool1 = bool2;
                                    bool2 = bool3;
                                    break label8382;
                                    label6852:
                                    parambfoy = String.valueOf(l1);
                                    parambcsb = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                                    localObject1 = parambcsb.b(parambfoy);
                                    if (QLog.isColorLevel()) {
                                      QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis: troopUin=" + l1 + ", memberUin=" + l5 + "，isHotChatMsg = " + bool3 + ",ti = " + localObject1);
                                    }
                                    if ((!bool3) && (localObject1 == null))
                                    {
                                      if (QLog.isColorLevel()) {
                                        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis: troopUin=" + l1 + ", memberUin=" + l5 + " troopinfo is null, getGroupInfoReq ");
                                      }
                                      localObject1 = new TroopInfo();
                                      ((TroopInfo)localObject1).troopuin = parambfoy;
                                      parambcsb.b((TroopInfo)localObject1);
                                      ((aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).j(parambfoy);
                                    }
                                    localObject1 = String.valueOf(l5);
                                    i6 = ((msg_comm.GroupInfo)localObject4).group_level.get();
                                    localObject5 = bhwz.a(((msg_comm.GroupInfo)localObject4).group_card.get());
                                    i8 = ((msg_comm.GroupInfo)localObject4).group_card_type.get();
                                    if (bool3) {
                                      ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).b(l1);
                                    }
                                    if (!bool1) {
                                      break label8632;
                                    }
                                    parambcsb = paramArrayList.iterator();
                                    while (parambcsb.hasNext()) {
                                      ((MessageRecord)parambcsb.next()).isOpenTroopMessage = true;
                                    }
                                    parambcsb = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                                    if ((parambcsb == null) || (parambcsb.f(parambfoy))) {
                                      break label8632;
                                    }
                                    parambcsb = (aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
                                    if (parambcsb == null) {
                                      break label8632;
                                    }
                                    parambcsb.f(parambfoy, false);
                                    break label8632;
                                    label7195:
                                    if (i3 != -100)
                                    {
                                      parambcsb = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                                      if (parambcsb != null) {
                                        parambcsb.a(parambfoy, (String)localObject1, i3);
                                      }
                                    }
                                    if (paramBoolean) {
                                      parambcsb = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                                    }
                                    switch (i8)
                                    {
                                    case 1: 
                                      parambcsb.a(parambfoy, (String)localObject1, (String)localObject5, i, null, null, 0, 1, 100, l3, b2, 0L, d, null, -100, j, k, m, n, i1, i7);
                                    case 2: 
                                      for (;;)
                                      {
                                        label7272:
                                        parambcsb.a(parambfoy, (String)localObject1, (String)localObject2, i6, i5);
                                        parambcsb = null;
                                        label7329:
                                        if ((localObject1 == null) || (((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
                                          break label8673;
                                        }
                                        localObject1 = (bgre)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132);
                                        if (((bgre)localObject1).a(parambfoy)) {
                                          break label8673;
                                        }
                                        if (!((bgre)localObject1).b(parambfoy)) {
                                          break label7779;
                                        }
                                        i3 = paramArrayList.size();
                                        i = 0;
                                        i4 = i3 - 1;
                                        if (i4 < 0) {
                                          break label7779;
                                        }
                                        localObject2 = (MessageRecord)paramArrayList.get(i4);
                                        i3 = i;
                                        if (!bgre.a((MessageRecord)localObject2)) {
                                          break label8666;
                                        }
                                        if ((!TextUtils.isEmpty(((MessageRecord)localObject2).msg)) || (((MessageRecord)localObject2).msgData != null)) {
                                          break;
                                        }
                                        break label8648;
                                        parambcsb.a(parambfoy, (String)localObject1, (String)localObject5, i, null, null, 0, 1, 100, l3, b2, 0L, d, null, -100, j, k, m, n, i1, i7);
                                        continue;
                                        parambcsb.a(parambfoy, (String)localObject1, "", i, (String)localObject5, null, 0, 1, 100, l3, b2, 0L, d, null, -100, j, k, m, n, i1, i7);
                                      }
                                      parambcsb = new TroopMemberInfo();
                                      parambcsb.newRealLevel = i5;
                                      parambcsb.troopuin = parambfoy;
                                      parambcsb.memberuin = ((String)localObject1);
                                      switch (i8)
                                      {
                                      case 2: 
                                        label7584:
                                        localObject2 = bhwz.b((String)localObject5);
                                        parambcsb.troopColorNick = ((String)localObject5);
                                        parambcsb.troopnick = ((String)localObject2);
                                        for (;;)
                                        {
                                          parambcsb.level = i;
                                          parambcsb.realLevel = i6;
                                          parambcsb.sex = 1;
                                          parambcsb.age = 0;
                                          parambcsb.distance = 100;
                                          parambcsb.msgseq = l3;
                                          if (b2 != 1) {
                                            break label8660;
                                          }
                                          paramBoolean = true;
                                          label7646:
                                          parambcsb.isTroopFollowed = paramBoolean;
                                          parambcsb.distanceToSelf = d;
                                          parambcsb.distanceToSelfUpdateTimeStamp = System.currentTimeMillis();
                                          break;
                                          parambcsb.troopnick = "";
                                          parambcsb.friendnick = ((String)localObject5);
                                        }
                                        i3 = i;
                                        if (i == 0)
                                        {
                                          ((bgre)localObject1).a(parambfoy, ((MessageRecord)localObject2).uniseq);
                                          i3 = 1;
                                        }
                                        if (QLog.isColorLevel()) {
                                          QLog.d("TroopBindPublicAccountMgr.redDot", 2, "decodePBAccountMSg:" + parambfoy + "," + ((MessageRecord)localObject2).uniseq + "," + ((MessageRecord)localObject2).shmsgseq);
                                        }
                                        ((bgre)localObject1).c(parambfoy);
                                        break label8666;
                                        label7779:
                                        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(parambfoy) != 3) {
                                          break label8673;
                                        }
                                        if (QLog.isColorLevel()) {
                                          QLog.d(".troop.closeRcvMsgTmp", 2, "Shield troop recv msg:" + parambfoy);
                                        }
                                        ((aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(parambfoy, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, 0);
                                        break label8673;
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
      }
    }
    for (;;)
    {
      label7855:
      i2 = bcrw.a(paramMsg);
      i3 = bcrw.e(paramMsg);
      i4 = bcrw.c(paramMsg);
      i5 = bcrw.b(paramMsg);
      i6 = bcrw.d(paramMsg);
      paramMsg = paramArrayList.iterator();
      while (paramMsg.hasNext())
      {
        paramArrayList = (MessageRecord)paramMsg.next();
        paramArrayList.vipBubbleDiyTextId = i2;
        paramArrayList.vipBubbleID = aogu.a((int)l7, i2);
        paramArrayList.vipSubBubbleId = i3;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramArrayList.time);
        if (i3 != 0) {
          paramArrayList.saveExtInfoToExtStr("bubble_sub_id", String.valueOf(i3));
        }
        if (i4 > 0) {
          paramArrayList.saveExtInfoToExtStr("vip_pendant_diy_id", String.valueOf(i4));
        }
        if (i6 >= 0) {
          paramArrayList.saveExtInfoToExtStr("vip_face_id", String.valueOf(i6));
        }
        if (i5 >= 0) {
          paramArrayList.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(i5));
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
        if (i > 0) {
          paramArrayList.saveExtInfoToExtStr("vip_ext_card_id", String.valueOf(i));
        }
      }
      MsgAutoMonitorUtil.getInstance().addDecodeGrpDisMsgTime(System.currentTimeMillis() - l4);
      return parambcsb;
      label8139:
      label8271:
      label8273:
      label8276:
      label8285:
      label8291:
      label8303:
      label8317:
      do
      {
        parambcsb = null;
        break label7329;
        i = i23;
        j = i22;
        k = i21;
        m = i20;
        n = i19;
        i1 = i18;
        i2 = i17;
        i3 = i16;
        i4 = i15;
        i5 = i13;
        i6 = i14;
        bool1 = bool6;
        bool2 = bool5;
        break label8382;
        parambfoy = null;
        break label6464;
        i5 = 0;
        i2 = -100;
        i4 = 0;
        bool1 = false;
        bool3 = false;
        break label6852;
        l1 = 0L;
        break label4518;
        i = -100;
        parambcsb = null;
        break label7855;
        localObject2 = localObject4;
        break label4067;
        break label8273;
        l1 = 0L;
        break label1095;
        localObject1 = null;
        l1 = 0L;
        break label250;
        j = 0;
        k = 0;
        m = 0;
        break;
        return null;
        break label3297;
        i += 1;
        break label1371;
        bool1 = false;
        break label1642;
        bool1 = false;
        break label1771;
        i = 2;
        break label3038;
        localObject4 = "";
        break label3985;
        bool5 = bool1;
        break label4664;
        break label5057;
        j = 1;
        break label5163;
        i = i12;
        j = i11;
        k = i10;
        m = i9;
        n = i8;
        i1 = i7;
        i7 = i5;
        i8 = i4;
        bool1 = bool4;
        bool2 = bool3;
        i5 = i3;
        i4 = i2;
        i3 = i8;
        i2 = i7;
        for (;;)
        {
          bool3 = bool2;
          i7 = i5;
          i8 = i4;
          i4 = i1;
          i5 = j;
          j = k;
          i1 = m;
          m = i4;
          k = i2;
          i4 = i3;
          i2 = i8;
          i3 = i7;
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
          break label4664;
          i4 = -100;
          break label4863;
          i7 = -100;
          break label4884;
          i2 = 0;
          break label4905;
          i5 = 0;
          break label4926;
          i1 = 0;
          break label8317;
          i5 = 0;
          break label5144;
          parambfoy = null;
          break label5651;
          bool1 = false;
          break label5868;
          i7 = j;
          i8 = m;
          i9 = k;
          i10 = i2;
          i11 = i3;
          bool3 = bool1;
          j = i5;
          k = i7;
          m = i1;
          i1 = i8;
          i2 = i9;
          i3 = i4;
          i4 = i10;
          i5 = i11;
          bool1 = bool2;
          bool2 = bool3;
        }
        i7 = j;
        i8 = i1;
        i1 = n;
        n = m;
        m = i4;
        j = i2;
        bool3 = bool1;
        i2 = k;
        i4 = i6;
        bool1 = bool2;
        k = m;
        m = i2;
        i2 = i8;
        break label6852;
        if (i4 == 0) {
          break label7195;
        }
      } while (!bool3);
      label8194:
      label8234:
      label8241:
      label8244:
      label8250:
      label8259:
      label8441:
      break label7195;
      label8320:
      label8326:
      label8382:
      break label7272;
      for (;;)
      {
        label8460:
        label8467:
        label8474:
        label8480:
        label8486:
        label8492:
        label8498:
        label8504:
        label8510:
        label8648:
        i4 -= 1;
        label8632:
        break;
        break label7584;
        label8660:
        paramBoolean = false;
        break label7646;
        label8666:
        i = i3;
      }
      label8673:
      i = i2;
    }
  }
  
  protected String a(msg_comm.Msg paramMsg)
  {
    long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    return 64 + "key_seq_" + l;
  }
  
  public List<MessageRecord> a(msg_comm.Msg paramMsg, bcsb parambcsb)
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
      if (adak.q(paramMessageRecord.msgtype))
      {
        aock localaock = new aock();
        localaock.b = 1000;
        localaock.c = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(5006, true, new Object[] { Long.valueOf(paramMessageRecord.uniseq), localaock });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aczr
 * JD-Core Version:    0.7.0.1
 */