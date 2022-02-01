import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.data.QIMNotifyAddFriend.VideoInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.manager.TicketManager;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.AddQimFriendNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.MCardNotificationLike;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.PushLostDevFound;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.QimFriendNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.RewardInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.VideoInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.VipInfoNotify;

public class acrm
  implements acpi
{
  private static void a(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("msg0x210.SubMsgType0x6f", 2, "get notice from handleC2COnlinePushMsg0x210Resp");
    }
    int j;
    Object localObject1;
    int k;
    label477:
    label498:
    int m;
    int n;
    try
    {
      SubMsgType0x6f.MsgBody localMsgBody = new SubMsgType0x6f.MsgBody();
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      int i = 0;
      for (;;)
      {
        if (i >= localMsgBody.rpt_msg_mod_infos.size()) {
          break label798;
        }
        paramMsgType0x210 = (SubMsgType0x6f.ForwardBody)localMsgBody.rpt_msg_mod_infos.get().get(i);
        j = -1;
        if (paramMsgType0x210.uint32_op_type.has()) {
          j = paramMsgType0x210.uint32_op_type.get();
        }
        if (QLog.isColorLevel()) {
          QLog.d("msg0x210.SubMsgType0x6f", 2, "get notice from handleC2COnlinePushMsg0x210Resp " + j);
        }
        if ((j != 2001) || (!paramMsgType0x210.msg_mcard_notification_like.has())) {
          break;
        }
        localObject1 = (SubMsgType0x6f.MCardNotificationLike)paramMsgType0x210.msg_mcard_notification_like.get();
        paramMsgType0x210 = "";
        l = 0L;
        k = 0;
        j = 0;
        if (((SubMsgType0x6f.MCardNotificationLike)localObject1).str_wording.has()) {
          paramMsgType0x210 = ((SubMsgType0x6f.MCardNotificationLike)localObject1).str_wording.get();
        }
        if (((SubMsgType0x6f.MCardNotificationLike)localObject1).uint32_counter_new.has()) {
          j = ((SubMsgType0x6f.MCardNotificationLike)localObject1).uint32_counter_new.get();
        }
        if (((SubMsgType0x6f.MCardNotificationLike)localObject1).uint64_from_uin.has()) {
          l = ((SubMsgType0x6f.MCardNotificationLike)localObject1).uint64_from_uin.get();
        }
        if (((SubMsgType0x6f.MCardNotificationLike)localObject1).uint32_counter_total.has()) {
          k = ((SubMsgType0x6f.MCardNotificationLike)localObject1).uint32_counter_total.get();
        }
        if (QLog.isColorLevel()) {
          QLog.d("msg0x210.SubMsgType0x6f", 2, "card_notification_like : wording: " + paramMsgType0x210 + " totalCount: " + k + " newCount: " + j + " fromUin: " + l);
        }
        paramMsgType0x210 = (arxv)paramQQAppInterface.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
        if (paramMsgType0x210 != null) {
          paramMsgType0x210.a().a((SubMsgType0x6f.MCardNotificationLike)localObject1);
        }
        bcrx.a(paramMessageHandler, paramMsgInfo.lFromUin, paramMsgInfo.shMsgSeq, paramMsgInfo.lMsgUid, paramMsgInfo.shMsgType);
        i += 1;
      }
      if ((j != 2002) || (!paramMsgType0x210.msg_vip_info_notify.has())) {
        break label799;
      }
      localObject1 = (SubMsgType0x6f.VipInfoNotify)paramMsgType0x210.msg_vip_info_notify.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "vip info notify: " + localObject1.toString());
      }
      long l = 0L;
      if (((SubMsgType0x6f.VipInfoNotify)localObject1).uint64_uin.has()) {
        l = ((SubMsgType0x6f.VipInfoNotify)localObject1).uint64_uin.get();
      }
      paramMsgType0x210 = Long.toString(l);
      if (!((SubMsgType0x6f.VipInfoNotify)localObject1).uint32_vip_identify.has()) {
        break label1570;
      }
      j = ((SubMsgType0x6f.VipInfoNotify)localObject1).uint32_vip_identify.get();
      if (!((SubMsgType0x6f.VipInfoNotify)localObject1).uint32_vip_level.has()) {
        break label1564;
      }
      k = ((SubMsgType0x6f.VipInfoNotify)localObject1).uint32_vip_level.get();
      m = -1;
      n = -1;
      if (((SubMsgType0x6f.VipInfoNotify)localObject1).uint32_red_flag.has()) {
        m = ((SubMsgType0x6f.VipInfoNotify)localObject1).uint32_red_flag.get();
      }
      if (((SubMsgType0x6f.VipInfoNotify)localObject1).uint32_disable_red_envelope.has()) {
        n = ((SubMsgType0x6f.VipInfoNotify)localObject1).uint32_disable_red_envelope.get();
      }
      i1 = ((SubMsgType0x6f.VipInfoNotify)localObject1).uint32_redpack_id.get();
      localObject1 = ((SubMsgType0x6f.VipInfoNotify)localObject1).str_redpack_name.get();
      if (!QLog.isColorLevel()) {
        break label1576;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, "iRedPacketId = " + i1 + ";redText = " + (String)localObject1);
    }
    catch (Exception paramQQAppInterface)
    {
      int i1;
      label611:
      if (!QLog.isColorLevel()) {
        break label798;
      }
      QLog.d("msg0x210.SubMsgType0x6f", 2, "exception : " + paramQQAppInterface);
    }
    Object localObject2 = (anxc)paramQQAppInterface.getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER);
    ((anxc)localObject2).a(m, n, true);
    ((anxc)localObject2).a(i1, (String)localObject1);
    label642:
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "UIN " + paramMsgType0x210 + " vip info changed.");
    }
    label1564:
    for (;;)
    {
      label681:
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "need pull vip info from svr. vipIdentiy=" + j + "; vipLevel=" + k);
      }
      localObject1 = ((TicketManager)paramQQAppInterface.getManager(2)).getSkey(paramMsgType0x210);
      ((aogw)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a((String)localObject1, paramMsgType0x210);
      label798:
      label799:
      label1570:
      label1576:
      do
      {
        bhsv.a(paramQQAppInterface).b();
        break;
        return;
        if ((j == 2003) && (paramMsgType0x210.msg_push_lost_dev_found.has()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QFindBLE", 2, "onlinePush receive ...");
          }
          paramMsgType0x210 = (SubMsgType0x6f.PushLostDevFound)paramMsgType0x210.msg_push_lost_dev_found.get();
          localObject1 = new Bundle();
          if (paramMsgType0x210.uint32_msg_type.has()) {
            ((Bundle)localObject1).putInt("msgtype", paramMsgType0x210.uint32_msg_type.get());
          }
          if (paramMsgType0x210.uint32_dev_time.has()) {
            ((Bundle)localObject1).putInt("devtime", paramMsgType0x210.uint32_dev_time.get());
          }
          if (paramMsgType0x210.uint64_din.has()) {
            ((Bundle)localObject1).putLong("din", paramMsgType0x210.uint64_din.get());
          }
          ((abgm)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(111, (Bundle)localObject1);
          break;
        }
        if ((j == 2007) && (paramMsgType0x210.msg_babyq_reward_info.has()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "receive msg_babyq_reward_info...");
          }
          ((anqn)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).a(paramMsgType0x210);
          break;
        }
        if ((j != 2011) || (!paramMsgType0x210.msg_mod_qim_friend_to_qq.has())) {
          break;
        }
        paramMsgType0x210 = (SubMsgType0x6f.QimFriendNotifyToQQ)paramMsgType0x210.msg_mod_qim_friend_to_qq.get();
        j = -1;
        if (paramMsgType0x210.uint32_notify_type.has()) {
          j = paramMsgType0x210.uint32_notify_type.get();
        }
        if (QLog.isColorLevel()) {
          QLog.d("QIMNewNotifyPush", 2, "receive msg_add_notify_to_qq... " + j);
        }
        if (j == 1)
        {
          if (!paramMsgType0x210.msg_add_notify_to_qq.has()) {
            break;
          }
          paramMsgType0x210 = paramMsgType0x210.msg_add_notify_to_qq;
          localObject1 = new QIMFollwerAdd();
          ((QIMFollwerAdd)localObject1).uin = paramMsgType0x210.uint64_uin.get();
          ((QIMFollwerAdd)localObject1).gender = paramMsgType0x210.uint32_gender.get();
          ((QIMFollwerAdd)localObject1).careSCount = paramMsgType0x210.uint64_cares_count.get();
          ((QIMFollwerAdd)localObject1).totalNum = paramMsgType0x210.uint64_storys_total_num.get();
          ((QIMFollwerAdd)localObject1).smartRemark = paramMsgType0x210.bytes_smart_remark.get().toStringUtf8();
          ((QIMFollwerAdd)localObject1).opType = paramMsgType0x210.uint32_op_type.get();
          ((QIMFollwerAdd)localObject1).fansCount = paramMsgType0x210.uint64_fans_count.get();
          ((QIMFollwerAdd)localObject1).longNick = RichStatus.parseStatus(paramMsgType0x210.bytes_longnick.get().toByteArray()).getPlainText();
          ((QIMFollwerAdd)localObject1).upTime = bcrg.a();
          ((QIMFollwerAdd)localObject1).source = paramMsgType0x210.bytes_src_wording.get().toStringUtf8();
          ((aizi)paramQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).b((QIMFollwerAdd)localObject1);
          break;
        }
        if ((j == 2) || (j != 3) || (!paramMsgType0x210.msg_add_not_login_frd_notify_to_qq.has())) {
          break;
        }
        paramMsgType0x210 = (SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)paramMsgType0x210.msg_add_not_login_frd_notify_to_qq.get();
        localObject1 = new QIMNotifyAddFriend();
        ((QIMNotifyAddFriend)localObject1).uin = paramMsgType0x210.uint64_uin.get();
        ((QIMNotifyAddFriend)localObject1).qqUin = paramMsgType0x210.uint64_qq_uin.get();
        ((QIMNotifyAddFriend)localObject1).nickName = paramMsgType0x210.bytes_nick.get().toStringUtf8();
        ((QIMNotifyAddFriend)localObject1).gender = paramMsgType0x210.uint32_gender.get();
        ((QIMNotifyAddFriend)localObject1).age = paramMsgType0x210.uint32_age.get();
        ((QIMNotifyAddFriend)localObject1).coverStory = paramMsgType0x210.bytes_coverstory.get().toStringUtf8();
        ((QIMNotifyAddFriend)localObject1).storyTotalNum = paramMsgType0x210.uint64_storys_total_num.get();
        ((QIMNotifyAddFriend)localObject1).wording = paramMsgType0x210.bytes_wording.get().toStringUtf8();
        j = 0;
        while (j < paramMsgType0x210.rpt_msg_video_info.size())
        {
          localObject2 = (SubMsgType0x6f.VideoInfo)paramMsgType0x210.rpt_msg_video_info.get(j);
          QIMNotifyAddFriend.VideoInfo localVideoInfo = new QIMNotifyAddFriend.VideoInfo();
          localVideoInfo.coverUrl = ((SubMsgType0x6f.VideoInfo)localObject2).bytes_video_cover_url.get().toStringUtf8();
          localVideoInfo.videoVid = ((SubMsgType0x6f.VideoInfo)localObject2).bytes_vid.get().toStringUtf8();
          ((QIMNotifyAddFriend)localObject1).videoInfos.add(localVideoInfo);
          j += 1;
        }
        ((QIMNotifyAddFriend)localObject1).pushTime = bcrg.a();
        if (QLog.isColorLevel()) {
          QLog.d("QIMNewNotifyPush", 2, "receive data= " + ((QIMNotifyAddFriend)localObject1).toString());
        }
        ((aoay)paramQQAppInterface.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a((QIMNotifyAddFriend)localObject1);
        break;
        k = 0;
        break label498;
        j = 0;
        break label477;
        if (m >= 0) {
          break label611;
        }
        if (n < 0) {
          break label642;
        }
        break label611;
        if (j != 0) {
          break label681;
        }
      } while (k == 0);
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk.a(), paramacnk.a().getMsgHandler(), paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acrm
 * JD-Core Version:    0.7.0.1
 */