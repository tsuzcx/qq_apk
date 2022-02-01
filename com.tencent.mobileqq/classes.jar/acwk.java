import IMMsgBodyPack.MsgType0x210;
import IMMsgBodyPack.MsgType0x210SubMsgType0x24;
import IMMsgBodyPack.PluginNum;
import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodePushNotify;
import com.tencent.gamecenter.appointment.GameCenterCheck;
import com.tencent.imcore.message.OnLinePushMessageProcessor.1;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.data.PushRecommend;
import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.data.QIMNotifyAddFriend.VideoInfo;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList.MsgBody;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList.NowPushMsg;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mqp.app.sec.d;
import com.tencent.msf.service.protocol.pb.SubMsgType0x51.MsgBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.troop.NearbyVideoProxyBroadcastReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import protocol.KQQConfig.GetResourceReqInfo;
import tencent.im.apollo_game_status.STCMGameMessage;
import tencent.im.apollo_game_status.STCMGameMessage.STMsgComm;
import tencent.im.apollo_push_msgInfo.STPushMsgElem;
import tencent.im.c2c.msgtype0x210.submsgtype0x79.submsgtype0x79.MsgBody;
import tencent.im.c2c.msgtype0x210.submsgtype0xeb.submsgtype0xeb.MsgBody;
import tencent.im.group.cmd0x2dc.GroupVisitorJoinMsg;
import tencent.im.group.cmd0x2dc.VisitorJoinInfo;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a.ReqBody;
import tencent.im.oidb.olympic.submsgtype0xb4.BodyType;
import tencent.im.oidb.olympic.submsgtype0xb4.MsgBody;
import tencent.im.oidb.olympic.torch_transfer.TorchbearerInfo;
import tencent.im.oidb.submsgtype0x136.Submsgtype0x136.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x101.SubMsgType0x27.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x103.submsgtype0x103.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x104.submsgtype0x104.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x115.SubMsgType0x115.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x115.SubMsgType0x115.NotifyItem;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x117.submsgtype0x117.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x118.submsgtype0x118.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x118.submsgtype0x118.SystemNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x119.SubMsgType0x119.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x11a.submsgtype0x11a.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x11b.submsgtype0x11b.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x120.SubMsgType0x120.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x128.submsgtype0x128.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppID;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppTipNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x3UpdateDiscussAppInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x31.submsgtype0x31.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x35.Submsgtype0x35.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x3b.Submsgtype0x3b.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.ClearCountMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.FriendSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.GroupSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.ModifySyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.WaitingSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x48.RecommendDeviceLock;
import tencent.im.s2c.msgtype0x210.submsgtype0x54.submsgtype0x54.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x54.submsgtype0x54.MsgBody.TaskInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x63.submsgtype0x63.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x67.submsgtype0x67.MsgBody;
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
import tencent.im.s2c.msgtype0x210.submsgtype0x78.submsgtype0x78.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x83.SubMsgType0x83.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x83.SubMsgType0x83.MsgParams;
import tencent.im.s2c.msgtype0x210.submsgtype0x85.SubMsgType0x85.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x86.SubMsgType0x86.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x92.SubMsgType0x92.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x94.Submsgtype0x94.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x96.submsgtype0x96.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x98.submsgtype0x98.ModBlock;
import tencent.im.s2c.msgtype0x210.submsgtype0x98.submsgtype0x98.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xa0.submsgtype0xa0.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xa4.submsgtype0xa4.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xa8.SubMsgType0xa8.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xab.SubMsgType0xab.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.AddFriendSource;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.PersonMayKnow;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.PushPeopleMayKnowV2;
import tencent.im.s2c.msgtype0x210.submsgtype0xb3.SubMsgType0xb3.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xb3.SubMsgType0xb3.PushAddFrdNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0xbe.SubMsgType0xbe.Medal;
import tencent.im.s2c.msgtype0x210.submsgtype0xbe.SubMsgType0xbe.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc1.submsgtype0xc1.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.HotFriendNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;
import tencent.im.s2c.msgtype0x210.submsgtype0xc9.submsgtype0xc9.BusinessMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0xc9.submsgtype0xc9.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xcb.SubMsgType0xcb.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xce.submsgtype0xce.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xcf.submsgtype0xcf.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xdb.submsgtype0xdb.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xdf.submsgtype0xdf.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xe5.Submsgtype0xe5.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xe8.submsgtype0xe8.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xe9.SubMsgType0xe9.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xea.submsgtype0xea.MsgBody;

public class acwk
  extends acvl
{
  public acwk(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private void A(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qqprotect.alert.push", 2, "get a push message for sec svc handler, 0xc6");
    }
    anus localanus = (anus)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(34);
    if (localanus != null) {
      localanus.a(paramMsgType0x210.uSubMsgType, paramMsgType0x210.vProtobuf);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("qqprotect.alert.push", 2, "failed to get sec svc handler, 0xc6");
  }
  
  private void B(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor runhw", 2, "onLinePush Audio Trans 0x210_0xe9");
    }
    try
    {
      SubMsgType0xe9.MsgBody localMsgBody = new SubMsgType0xe9.MsgBody();
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMsgBody);
      if (QLog.isColorLevel())
      {
        paramMsgType0x210 = localMsgBody.bytes_business.get().toByteArray();
        QLog.d("Q.msg.BaseMessageProcessor runhw", 2, "onLinePush 0x210_0xe9 =" + paramMsgType0x210.length);
        QLog.d("Q.msg.BaseMessageProcessor runhw", 2, "onLinePush 0x210_0xe9 businessBytes = " + paramMsgType0x210.length);
      }
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      do
      {
        paramMsgType0x210.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("Q.msg.BaseMessageProcessor runhw", 2, "onLinePush 0x210_0xe9 push exception = " + paramMsgType0x210.getMessage());
    }
  }
  
  private void C(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QAV.Random.push", 2, "[random room owner] onLinePush receive 0x210_0xc1");
    }
    try
    {
      submsgtype0xc1.MsgBody localMsgBody = new submsgtype0xc1.MsgBody();
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMsgBody);
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QAV.Random.push", 2, "[random room owner] onLinePush 0x210_0xc1 push exception", paramMsgType0x210);
    }
  }
  
  private void D(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("olympic.OnLinePush", 2, "receive push 0xb4");
    }
    Object localObject = new submsgtype0xb4.MsgBody();
    try
    {
      ((submsgtype0xb4.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
      int i = ((submsgtype0xb4.MsgBody)localObject).uint32_type.get();
      if (QLog.isColorLevel()) {
        QLog.d("olympic.OnLinePush", 2, new Object[] { "receive push 0xb4, type = ", Integer.valueOf(i) });
      }
      if (i == 1)
      {
        paramMsgType0x210 = ((submsgtype0xb4.MsgBody)localObject).msg_body_type;
        if (paramMsgType0x210.msg_torchbearer.has())
        {
          localObject = (ayka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(94);
          if (localObject != null) {
            ((ayka)localObject).a((torch_transfer.TorchbearerInfo)paramMsgType0x210.msg_torchbearer.get());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("olympic.OnLinePush", 2, "receive push 0xb4, bodyType.msg_torchbearer.has() == false");
          return;
        }
      }
    }
    catch (Exception paramMsgType0x210)
    {
      if (QLog.isColorLevel()) {
        QLog.d("olympic.OnLinePush", 2, "receive push 0xb4, parse msgBody err,", paramMsgType0x210);
      }
    }
  }
  
  private void E(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameParty", 2, "recv 0x210_0xaa push message");
    }
    SubMsgType0xaa.MsgBody localMsgBody = new SubMsgType0xaa.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      ((auwj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a(localMsgBody, false);
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GameParty", 2, "recv 0x210_0xaa, prase msgBody error");
        }
      }
    }
  }
  
  private void F(MsgType0x210 paramMsgType0x210)
  {
    SubMsgType0xa8.MsgBody localMsgBody = new SubMsgType0xa8.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      a(localMsgBody);
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PullActive", 2, "recv 0x210_0xa8, prase msgBody error");
    }
  }
  
  private void G(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward.push", 2, "onLinePush receive 0x210_0xab");
    }
    try
    {
      SubMsgType0xab.MsgBody localMsgBody = new SubMsgType0xab.MsgBody();
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      ((anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(localMsgBody);
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w(".troop.troop_reward.push", 2, "onLinePush 0x210_0xab push exception", paramMsgType0x210);
    }
  }
  
  private void H(MsgType0x210 paramMsgType0x210)
  {
    bool = true;
    submsgtype0xa0.MsgBody localMsgBody = new submsgtype0xa0.MsgBody();
    for (;;)
    {
      try
      {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        int i = localMsgBody.uint32_is_mass_bless_open.get();
        if (i != 0) {
          continue;
        }
      }
      catch (Exception paramMsgType0x210)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("BlessManager", 2, "handleMsgType0x210SubMsgType0x8f : fail to parse 0x211_0xa0.");
        bool = true;
        continue;
      }
      ((aipe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(138)).c(bool);
      return;
      bool = false;
    }
  }
  
  private void I(MsgType0x210 paramMsgType0x210)
  {
    submsgtype0x98.MsgBody localMsgBody = new submsgtype0x98.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      label17:
      localMsgBody.uint64_uin.get();
      localMsgBody.uint32_sub_cmd.get();
      ((submsgtype0x98.ModBlock)localMsgBody.msg_mod_block.get()).uint32_op.get();
      return;
    }
    catch (Throwable paramMsgType0x210)
    {
      break label17;
    }
  }
  
  private void J(MsgType0x210 paramMsgType0x210)
  {
    Object localObject1 = new Submsgtype0x94.MsgBody();
    try
    {
      ((Submsgtype0x94.MsgBody)localObject1).mergeFrom(paramMsgType0x210.vProtobuf);
      label90:
      boolean bool5;
      if (((Submsgtype0x94.MsgBody)localObject1).str_folder_msg.has())
      {
        paramMsgType0x210 = ((Submsgtype0x94.MsgBody)localObject1).str_folder_msg.get().trim();
        if (QLog.isColorLevel()) {
          QLog.i("EcShopAssistantActivity", 2, "diy string:" + paramMsgType0x210);
        }
        if (((Submsgtype0x94.MsgBody)localObject1).uint32_discover_reddot_flag.get() != 1) {
          break label436;
        }
        bool4 = true;
        if (((Submsgtype0x94.MsgBody)localObject1).uint32_folder_reddot_flag.get() != 1) {
          break label442;
        }
        bool5 = true;
        label105:
        if (((Submsgtype0x94.MsgBody)localObject1).uint32_discount_reddot_flag.get() != 1) {
          break label448;
        }
        bool2 = true;
        label120:
        if (((Submsgtype0x94.MsgBody)localObject1).uint32_nearby_reddot_flag.get() != 1) {
          break label454;
        }
        bool1 = true;
        label135:
        if (((Submsgtype0x94.MsgBody)localObject1).uint32_mine_reddot_flag.get() != 1) {
          break label460;
        }
      }
      int k;
      int m;
      int n;
      int j;
      int i1;
      String str2;
      String str3;
      String str4;
      String str1;
      int i2;
      label436:
      label442:
      label448:
      label454:
      label460:
      for (bool3 = true;; bool3 = false)
      {
        k = ((Submsgtype0x94.MsgBody)localObject1).uint32_start_ts.get();
        m = ((Submsgtype0x94.MsgBody)localObject1).uint32_end_ts.get();
        n = (int)(System.currentTimeMillis() / 1000L);
        j = ((Submsgtype0x94.MsgBody)localObject1).uint32_period_of_validity.get();
        i1 = ((Submsgtype0x94.MsgBody)localObject1).uint32_task_type.get();
        str2 = ((Submsgtype0x94.MsgBody)localObject1).str_task_info.get();
        str3 = ((Submsgtype0x94.MsgBody)localObject1).str_type_name.get();
        str4 = ((Submsgtype0x94.MsgBody)localObject1).str_type_color.get();
        str1 = ((Submsgtype0x94.MsgBody)localObject1).str_jump_url.get();
        i2 = ((Submsgtype0x94.MsgBody)localObject1).uint32_task_id.get();
        if (QLog.isColorLevel()) {
          QLog.i("EcShopAssistantActivity", 2, "reddot start=" + k + ",end=" + m + ",showtime=" + j + "flags:" + bool5 + "," + bool4 + "," + bool2 + "," + bool1 + "," + bool3 + ",type:" + i1 + ",taskInfo:" + str2 + ",typeName:" + str3 + ",typeColor:" + str4 + ",jumpUrl:" + str1);
        }
        if ((n >= k) && (n <= m)) {
          break label466;
        }
        return;
        paramMsgType0x210 = "";
        break;
        bool4 = false;
        break label90;
        bool5 = false;
        break label105;
        bool2 = false;
        break label120;
        bool1 = false;
        break label135;
      }
      label466:
      int i = j;
      if (j > 172800000) {
        i = 172800000;
      }
      if ((bool4) || (bool2) || (bool1) || (bool3))
      {
        bool5 = true;
        if (!bool5)
        {
          if ((bool4) || (((Submsgtype0x94.MsgBody)localObject1).uint32_only_discover_reddot_flag.get() == 1))
          {
            bool4 = true;
            if ((!bool2) && (((Submsgtype0x94.MsgBody)localObject1).uint32_only_discount_reddot_flag.get() != 1)) {
              break label1269;
            }
            bool2 = true;
            label547:
            if ((!bool1) && (((Submsgtype0x94.MsgBody)localObject1).uint32_only_nearby_reddot_flag.get() != 1)) {
              break label1275;
            }
            bool1 = true;
            label567:
            if ((!bool3) && (((Submsgtype0x94.MsgBody)localObject1).uint32_only_mine_reddot_flag.get() != 1)) {
              break label1281;
            }
            bool3 = true;
            label587:
            bool6 = bool3;
            bool7 = bool4;
            bool8 = bool2;
            bool9 = bool1;
            if (QLog.isColorLevel())
            {
              QLog.i("EcShopAssistantActivity", 2, "new flag:" + bool4 + "," + bool2 + "," + bool1 + "," + bool3);
              bool9 = bool1;
              bool8 = bool2;
              bool7 = bool4;
              bool6 = bool3;
            }
            Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = "noLogin";
            }
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("ecshop_sp" + (String)localObject1, 0);
            localObject1 = ((SharedPreferences)localObject2).edit();
            if ((((SharedPreferences)localObject2).getBoolean("disc_reddot", false)) || (((SharedPreferences)localObject2).getBoolean("welfare_reddot", false)) || (((SharedPreferences)localObject2).getBoolean("nearby_reddot", false)) || (((SharedPreferences)localObject2).getBoolean("mine_reddot", false)) || (((SharedPreferences)localObject2).getBoolean("folder_reddot", false)))
            {
              j = ((SharedPreferences)localObject2).getInt("last_show_time1", 0);
              int i3 = ((SharedPreferences)localObject2).getInt("reddot_start", 0);
              int i4 = ((SharedPreferences)localObject2).getInt("reddot_end", 0);
              int i5 = ((SharedPreferences)localObject2).getInt("max_reddot_time", 0);
              int i6 = (int)(System.currentTimeMillis() / 1000L);
              if ((i6 != 0) && (i3 != 0) && (i4 != 0) && (i5 != 0) && ((i6 < i3) || (i6 > i4) || (i6 - j >= i5))) {
                break label1287;
              }
            }
            label929:
            ((SharedPreferences.Editor)localObject1).putInt("reddot_start", k);
            ((SharedPreferences.Editor)localObject1).putInt("reddot_end", m);
            ((SharedPreferences.Editor)localObject1).putInt("max_reddot_time", i);
            ((SharedPreferences.Editor)localObject1).putString("str_ecshop_diy", paramMsgType0x210);
            ((SharedPreferences.Editor)localObject1).putInt("last_show_time1", n);
            ((SharedPreferences.Editor)localObject1).putInt("PUSH_TASK_TYPE", i1);
            ((SharedPreferences.Editor)localObject1).putString("PUSH_TASK_INFO", str2);
            ((SharedPreferences.Editor)localObject1).putString("PUSH_TYPE_NAME", str3);
            ((SharedPreferences.Editor)localObject1).putString("PUSH_TYPE_COLOR", str4);
            ((SharedPreferences.Editor)localObject1).putLong("PUSH_RECEIVE_TIME", NetConnInfoCenter.getServerTime());
            ((SharedPreferences.Editor)localObject1).putInt("PUSH_TASK_ID", i2);
            if (str1 != null) {
              break label1366;
            }
            paramMsgType0x210 = "";
            label1080:
            ((SharedPreferences.Editor)localObject1).putString("PUSH_JUMP_URL", paramMsgType0x210);
            ((SharedPreferences.Editor)localObject1).putInt("FOLDER_MSG_TYPE", 1);
            ((SharedPreferences.Editor)localObject1).putBoolean("folder_reddot", bool5);
            ((SharedPreferences.Editor)localObject1).putBoolean("disc_reddot", bool7);
            ((SharedPreferences.Editor)localObject1).putBoolean("welfare_reddot", bool8);
            ((SharedPreferences.Editor)localObject1).putBoolean("nearby_reddot", bool9);
            ((SharedPreferences.Editor)localObject1).putBoolean("mine_reddot", bool6);
            ((SharedPreferences.Editor)localObject1).commit();
            if (!bool5) {
              break label1372;
            }
            ((oda)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88)).a(NetConnInfoCenter.getServerTime(), bool5);
            label1202:
            ((ode)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(68)).a();
            paramMsgType0x210 = null;
            if (!bool7) {
              break label1398;
            }
            paramMsgType0x210 = "Arrived_shopdiscover_dot";
          }
          for (;;)
          {
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "Shop_folder", paramMsgType0x210, 0, 0, "", "", "", "");
            return;
            bool4 = false;
            break;
            label1269:
            bool2 = false;
            break label547;
            label1275:
            bool1 = false;
            break label567;
            label1281:
            bool3 = false;
            break label587;
            label1287:
            if (QLog.isColorLevel()) {
              QLog.i("EcShopAssistantActivity", 2, "online push found reddot out of date!");
            }
            ((SharedPreferences.Editor)localObject1).putBoolean("disc_reddot", false);
            ((SharedPreferences.Editor)localObject1).putBoolean("welfare_reddot", false);
            ((SharedPreferences.Editor)localObject1).putBoolean("nearby_reddot", false);
            ((SharedPreferences.Editor)localObject1).putBoolean("mine_reddot", false);
            ((SharedPreferences.Editor)localObject1).putBoolean("folder_reddot", false);
            break label929;
            label1366:
            paramMsgType0x210 = str1;
            break label1080;
            label1372:
            paramMsgType0x210 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
            if (paramMsgType0x210 == null) {
              break label1202;
            }
            paramMsgType0x210.sendEmptyMessage(1009);
            break label1202;
            label1398:
            if (bool8) {
              paramMsgType0x210 = "Arrived_shoppreferential_dot";
            } else if (bool9) {
              paramMsgType0x210 = "Arrived_shopnearbynot_dot";
            } else if (bool6) {
              paramMsgType0x210 = "Arrived_shopmynot_dot";
            } else if (bool5) {
              paramMsgType0x210 = "Arrived_folder_dot";
            }
          }
        }
      }
    }
    catch (Throwable paramMsgType0x210)
    {
      for (;;)
      {
        boolean bool4;
        boolean bool2;
        boolean bool1;
        boolean bool3;
        continue;
        boolean bool6 = bool3;
        boolean bool7 = bool4;
        boolean bool8 = bool2;
        boolean bool9 = bool1;
      }
    }
  }
  
  private void K(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "OnLinePushMessageProcessor receive 0x11c push message ");
    }
    tencent.im.s2c.msgtype0x210.submsgtype0x11c.MsgBody localMsgBody = new tencent.im.s2c.msgtype0x210.submsgtype0x11c.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      ((bccg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12)).a(localMsgBody);
      return;
    }
    catch (Exception paramMsgType0x210) {}
  }
  
  private void L(MsgType0x210 paramMsgType0x210)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "OnLinePushMessageProcessor receive 0xce push message ");
    }
    Object localObject = new submsgtype0xce.MsgBody();
    try
    {
      ((submsgtype0xce.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
      paramMsgType0x210 = ((submsgtype0xce.MsgBody)localObject).string_params.get();
      if (QLog.isColorLevel()) {
        bize.c("Q.msg.BaseMessageProcessor", "yuyue(push):OnLinePushMessageProcessor receive 0xce strJson=" + paramMsgType0x210);
      }
      localObject = new JSONObject(paramMsgType0x210).optString("appid");
      String[] arrayOfString = aceh.a("APPOINTMENT_DOWNLOAD_LIST").split("\\|");
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < arrayOfString.length)
        {
          if ((!TextUtils.isEmpty(arrayOfString[i])) && (!TextUtils.isEmpty((CharSequence)localObject)) && (arrayOfString[i].equals(localObject))) {
            j = 1;
          }
        }
        else
        {
          if ((j == 0) && (!TextUtils.isEmpty((CharSequence)localObject)))
          {
            aceh.c((String)localObject, "APPOINTMENT_LIST");
            aceh.a((String)localObject, paramMsgType0x210, "APPOINT_APPID_DETAIL_");
            aced.a();
          }
          GameCenterCheck.a();
          aceh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "426", "202136", (String)localObject, "42601", "1", "116");
          return;
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      paramMsgType0x210.printStackTrace();
    }
  }
  
  private void M(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 4, "OnLinePushMessageProcessor receive 0x96 push message ");
    }
    submsgtype0x96.MsgBody localMsgBody = new submsgtype0x96.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      paramMsgType0x210 = new Intent("tencent.qqcomic.push.msg");
      if (localMsgBody.uint32_push_type.has()) {
        switch (localMsgBody.uint32_push_type.get())
        {
        case 0: 
          paramMsgType0x210.setAction("tencent.qqcomic.show.dialog");
          for (;;)
          {
            paramMsgType0x210.putExtra("msg", localMsgBody.string_push_msg.get());
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramMsgType0x210);
            return;
            paramMsgType0x210.setAction("tencent.qqcomic.show.dialog");
          }
        }
      }
    }
    catch (Exception paramMsgType0x210)
    {
      while (QLog.isColorLevel())
      {
        QLog.d("Q.msg.BaseMessageProcessor", 4, "OnLinePushMessageProcessor mergeFrom 0x96 exception ");
        return;
        paramMsgType0x210.setAction("tencent.qqcomic.show.egg");
        continue;
        paramMsgType0x210.setAction("tencent.qqcomic.show.dialog");
      }
    }
  }
  
  private void N(MsgType0x210 paramMsgType0x210)
  {
    try
    {
      d.e1(2, d.x(), paramMsgType0x210.vProtobuf);
      return;
    }
    catch (Throwable paramMsgType0x210)
    {
      paramMsgType0x210.printStackTrace();
    }
  }
  
  private void O(MsgType0x210 paramMsgType0x210)
  {
    SubMsgType0x87.MsgBody localMsgBody = new SubMsgType0x87.MsgBody();
    for (;;)
    {
      try
      {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        if (localMsgBody.uint64_friend_msg_type_flag.has())
        {
          if (localMsgBody.uint64_friend_msg_type_flag.get() != 1L) {
            break label102;
          }
          i = 1;
          if (i != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(2);
          }
        }
        if (localMsgBody.rpt_msg_msg_notify.has()) {
          aixz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMsgBody);
        }
        return;
      }
      catch (Throwable paramMsgType0x210)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PortalManager", 2, "", paramMsgType0x210);
        }
        throw new RuntimeException(paramMsgType0x210);
      }
      label102:
      int i = 0;
    }
  }
  
  private void P(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Qidian0xe5Push", 2, "<---receive qidian0xe5 push : forward to qidianHandler");
    }
    try
    {
      paramMsgType0x210 = (Submsgtype0xe5.MsgBody)new Submsgtype0xe5.MsgBody().mergeFrom(paramMsgType0x210.vProtobuf);
      ((bjhb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(paramMsgType0x210);
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.BaseMessageProcessor", 2, "<---decode0xe5push parse failed.", paramMsgType0x210);
    }
  }
  
  private void Q(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Qidian0x92Push", 2, "<---receive qidian0x92 push : forward to qidianHandler");
    }
    try
    {
      paramMsgType0x210 = (SubMsgType0x92.MsgBody)new SubMsgType0x92.MsgBody().mergeFrom(paramMsgType0x210.vProtobuf);
      ((bjhb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(paramMsgType0x210);
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.BaseMessageProcessor", 2, "<---decode0x92push parse failed.", paramMsgType0x210);
    }
  }
  
  private void R(MsgType0x210 paramMsgType0x210)
  {
    ((ansf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(47)).a(paramMsgType0x210.vProtobuf);
  }
  
  private void S(MsgType0x210 paramMsgType0x210)
  {
    ((baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramMsgType0x210.vProtobuf);
  }
  
  private void T(MsgType0x210 paramMsgType0x210)
  {
    ((baif)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramMsgType0x210.vProtobuf);
  }
  
  private void U(MsgType0x210 paramMsgType0x210)
  {
    submsgtype0x78.MsgBody localMsgBody = new submsgtype0x78.MsgBody();
    for (;;)
    {
      int i;
      try
      {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        i = localMsgBody.uint32_type.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "MSG_TYPE_RED_PACKET type:" + i + ", serverVersion:" + localMsgBody.uint32_version.get());
        }
        if (i == 1004)
        {
          paramMsgType0x210 = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(79);
          if (paramMsgType0x210 != null) {
            paramMsgType0x210.a(localMsgBody);
          }
          return;
        }
      }
      catch (Throwable paramMsgType0x210)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PortalManager", 2, "", paramMsgType0x210);
        }
        throw new RuntimeException(paramMsgType0x210);
      }
      if (i == 49)
      {
        arcj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localMsgBody.uint32_version.get());
        return;
      }
      if (i == 46)
      {
        acvg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localMsgBody.uint32_version.get(), "C2COnlinePush");
        return;
      }
      if (i == 1003)
      {
        ((OlympicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(167)).a(localMsgBody);
        return;
      }
      if (i == 222)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("public_account_ad_preload_task", 0);
        if (i != localMsgBody.uint32_version.get()) {
          arcj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 222, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "handlePublicAccountAdPreloadTaskPush localVersion:" + i + ", serverVersion:" + localMsgBody.uint32_version.get());
        }
      }
      else if (i == 283)
      {
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            QLog.d("Q.msg.BaseMessageProcessor", 1, "SAFE_MODE_COMMAND_CONFIG excute");
            paramMsgType0x210 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            arcj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 283, paramMsgType0x210);
            return;
          }
        }
        catch (Throwable paramMsgType0x210)
        {
          QLog.e("Q.msg.BaseMessageProcessor", 1, "SAFE_MODE_COMMAND_CONFIG  Push throw an exception:", paramMsgType0x210);
        }
      }
    }
  }
  
  private void V(MsgType0x210 paramMsgType0x210)
  {
    paramMsgType0x210 = niz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210.vProtobuf);
    if (paramMsgType0x210 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("storyRedDotDebug", 2, "receive push");
      }
      a(105, true, paramMsgType0x210);
    }
  }
  
  private void W(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "Get crm voip push from handleC2COnlinePushMsg0x210Resp");
    }
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "VoipService.ivrPush", "VoipService.ivrPush", 0, 0, "", "", "", "");
    new submsgtype0x63.MsgBody();
    new lxd(BaseApplication.getContext()).a(new acwl(this, paramMsgType0x210));
  }
  
  private void X(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearbyTroopPush", 2, "receive msgtype0x210.submsgtype0x67 group recmd push: " + h(paramMsgType0x210));
    }
    Object localObject = new submsgtype0x67.MsgBody();
    try
    {
      ((submsgtype0x67.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
      if (((submsgtype0x67.MsgBody)localObject).rpt_msg_grpinfo.has())
      {
        paramMsgType0x210 = ((submsgtype0x67.MsgBody)localObject).rpt_msg_grpinfo.get();
        localObject = (anos)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(3);
        if (localObject != null) {
          ((anos)localObject).a(paramMsgType0x210);
        }
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramMsgType0x210)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("nearbyTroopPush", 2, "receive msgtype0x210.submsgtype0x67 mergeFrom exception: " + paramMsgType0x210.toString());
        }
      }
    }
  }
  
  private void Y(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQOperateVoIP", 2, "get voip_tips from handleC2COnlinePushMsg0x210Resp");
    }
    anjo localanjo = (anjo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4);
    long l;
    if (localanjo != null)
    {
      submsgtype0x54.MsgBody localMsgBody = new submsgtype0x54.MsgBody();
      try
      {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        i = localMsgBody.peer_type.get();
        Object localObject = localMsgBody.task_list.get();
        paramMsgType0x210 = new ArrayList();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            submsgtype0x54.MsgBody.TaskInfo localTaskInfo = (submsgtype0x54.MsgBody.TaskInfo)((Iterator)localObject).next();
            QQOperationViopTipTask localQQOperationViopTipTask = new QQOperationViopTipTask();
            localQQOperationViopTipTask.taskid = localTaskInfo.task_id.get();
            paramMsgType0x210.add(localQQOperationViopTipTask);
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramMsgType0x210)
      {
        for (;;)
        {
          paramMsgType0x210.printStackTrace();
        }
        l = localMsgBody.peer_uin.get();
        if (i != 1) {}
      }
    }
    for (int i = 0;; i = 3000)
    {
      localanjo.a(String.valueOf(l), i, paramMsgType0x210);
      return;
    }
  }
  
  private void Z(MsgType0x210 paramMsgType0x210)
  {
    ((anuo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(24)).a(paramMsgType0x210.vProtobuf);
  }
  
  public static MsgType0x210 a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte);
      paramArrayOfByte.setServerEncoding("utf-8");
      MsgType0x210 localMsgType0x210 = new MsgType0x210();
      localMsgType0x210.readFrom(paramArrayOfByte);
      return localMsgType0x210;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  private MessageRecord a(MsgInfo paramMsgInfo, long paramLong)
  {
    MsgType0x210 localMsgType0x210 = a(paramMsgInfo.vMsg);
    if (g(localMsgType0x210)) {}
    do
    {
      return null;
      if (j(localMsgType0x210))
      {
        ah(localMsgType0x210);
        return null;
      }
      if (h(localMsgType0x210)) {
        return a(paramMsgInfo, paramLong, localMsgType0x210);
      }
    } while (!i(localMsgType0x210));
    ai(localMsgType0x210);
    return null;
  }
  
  private MessageRecord a(MsgInfo paramMsgInfo, long paramLong, MsgType0x210 paramMsgType0x210)
  {
    boolean bool = true;
    if (f(paramMsgType0x210))
    {
      bcaz.a(this, paramMsgType0x210.vProtobuf);
      return null;
    }
    if ((paramMsgType0x210.uSubMsgType == 40L) || (paramMsgType0x210.uSubMsgType == 63L) || (paramMsgType0x210.uSubMsgType == 166L))
    {
      h(paramMsgType0x210);
      return null;
    }
    if (e(paramMsgType0x210))
    {
      g(paramMsgType0x210);
      return null;
    }
    if (d(paramMsgType0x210))
    {
      b(paramLong, paramMsgType0x210.vProtobuf);
      return null;
    }
    if (c(paramMsgType0x210))
    {
      ag(paramMsgType0x210);
      return null;
    }
    if (b(paramMsgType0x210))
    {
      af(paramMsgType0x210);
      return null;
    }
    if (a(paramMsgType0x210))
    {
      ae(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 61L)
    {
      ad(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 67L)
    {
      ac(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 68L)
    {
      a(paramLong, paramMsgType0x210.vProtobuf);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 179L)
    {
      a(paramMsgType0x210.vProtobuf);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 228L)
    {
      f(paramMsgType0x210.vProtobuf);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 38L)
    {
      a(paramMsgType0x210.vProtobuf);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 278L)
    {
      g(paramMsgType0x210.vProtobuf);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 279L)
    {
      h(paramMsgType0x210.vProtobuf);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 309L)
    {
      ab(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 131L)
    {
      c(paramMsgType0x210.vProtobuf);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 181L)
    {
      d(paramMsgType0x210.vProtobuf);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 190L)
    {
      b(paramMsgType0x210.vProtobuf);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 72L)
    {
      aa(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 81L)
    {
      s(paramMsgInfo, paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 74L)
    {
      Z(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 84L)
    {
      Y(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 103L)
    {
      X(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 110L)
    {
      b();
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 99L)
    {
      W(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 102L)
    {
      b(paramMsgInfo, paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 195L)
    {
      c(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 126L)
    {
      a(paramMsgInfo, paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 78L)
    {
      r(paramMsgInfo, paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 107L)
    {
      q(paramMsgInfo, paramMsgType0x210);
      return null;
    }
    if (105L == paramMsgType0x210.uSubMsgType)
    {
      V(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 222L)
    {
      a();
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 111L)
    {
      p(paramMsgInfo, paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 120L)
    {
      U(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 113L)
    {
      T(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 137L)
    {
      S(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 280L)
    {
      o(paramMsgInfo, paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 118L)
    {
      a(paramMsgInfo, paramLong, paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 114L)
    {
      R(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 121L)
    {
      n(paramMsgInfo, paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 124L)
    {
      bcaw.a(paramMsgInfo.shMsgSeq, paramMsgInfo.shMsgType, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210.vProtobuf);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 134L)
    {
      m(paramMsgInfo, paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 133L) {
      return e(paramMsgInfo, paramMsgType0x210);
    }
    if (paramMsgType0x210.uSubMsgType == 146L)
    {
      Q(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 229L)
    {
      P(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 159L) {
      return d(paramMsgInfo, paramMsgType0x210);
    }
    if (paramMsgType0x210.uSubMsgType == 162L) {
      return c(paramMsgInfo, paramMsgType0x210);
    }
    if (paramMsgType0x210.uSubMsgType == 141L)
    {
      l(paramMsgInfo, paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 135L)
    {
      O(paramMsgType0x210);
      return null;
    }
    if ((paramMsgType0x210.uSubMsgType == 138L) || (paramMsgType0x210.uSubMsgType == 139L))
    {
      f(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 144L)
    {
      e(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 149L)
    {
      N(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 150L)
    {
      M(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 206L)
    {
      L(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 284L)
    {
      K(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 148L)
    {
      J(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 220L)
    {
      k(paramMsgInfo, paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 152L)
    {
      I(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 160L)
    {
      H(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 164L)
    {
      d(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 171L)
    {
      G(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 168L)
    {
      F(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 170L)
    {
      E(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 174L)
    {
      j(paramMsgInfo, paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 180L)
    {
      D(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 177L)
    {
      bcbc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210.vProtobuf, true);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 193L)
    {
      C(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 233L)
    {
      B(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 199L)
    {
      i(paramMsgInfo, paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 197L)
    {
      a(paramMsgType0x210.vProtobuf, paramMsgInfo.uRealMsgTime);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 258L)
    {
      bbzf.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsgInfo.lFromUin, paramMsgInfo.shMsgSeq, paramMsgInfo.lMsgUid, paramMsgInfo.shMsgType);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 238L)
    {
      b(paramMsgType0x210.vProtobuf, paramMsgInfo.uRealMsgTime);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 249L)
    {
      a(paramMsgType0x210.vProtobuf, 1, paramMsgInfo);
      bbzf.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsgInfo.lFromUin, paramMsgInfo.shMsgSeq, paramMsgInfo.lMsgUid, paramMsgInfo.shMsgType);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 253L)
    {
      a(paramMsgType0x210.vProtobuf, 1);
      bbzf.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsgInfo.lFromUin, paramMsgInfo.shMsgSeq, paramMsgInfo.lMsgUid, paramMsgInfo.shMsgType);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 198L)
    {
      A(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 203L)
    {
      a(paramMsgType0x210.vProtobuf, paramMsgInfo);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 204L)
    {
      ((wff)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98)).a(paramMsgType0x210.vProtobuf);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 207L)
    {
      z(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 208L)
    {
      ((wff)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98)).b(paramMsgType0x210.vProtobuf);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 218L)
    {
      ((wff)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98)).c(paramMsgType0x210.vProtobuf);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 215L)
    {
      b(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 254L)
    {
      a(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 221L)
    {
      ((bhte)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(107)).a(paramMsgType0x210.vProtobuf);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 219L)
    {
      y(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 223L)
    {
      b(paramLong, paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 232L)
    {
      x(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 235L)
    {
      w(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 239L)
    {
      v(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 267L)
    {
      u(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 244L)
    {
      h(paramMsgInfo, paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 251L)
    {
      t(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 256L) {
      return b(paramMsgInfo, paramMsgType0x210);
    }
    if (paramMsgType0x210.uSubMsgType == 257L)
    {
      g(paramMsgInfo, paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 259L)
    {
      s(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 260L)
    {
      r(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 264L) {
      return a(paramMsgInfo, paramMsgType0x210);
    }
    if (paramMsgType0x210.uSubMsgType == 273L)
    {
      q(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 286L)
    {
      p(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 287L)
    {
      f(paramMsgInfo, paramMsgType0x210);
      return null;
    }
    if ((paramMsgType0x210.uSubMsgType == 295L) || (paramMsgType0x210.uSubMsgType == 297L))
    {
      e(paramMsgInfo, paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 275L)
    {
      a(paramLong, paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 277L)
    {
      o(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 281L)
    {
      d(paramMsgInfo, paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 288L)
    {
      n(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 293L)
    {
      c(paramMsgInfo, paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 282L)
    {
      m(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 294L)
    {
      l(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 283L)
    {
      k(paramMsgType0x210);
      return null;
    }
    if ((paramMsgType0x210.uSubMsgType == 290L) || (paramMsgType0x210.uSubMsgType == 291L))
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      byte[] arrayOfByte = paramMsgType0x210.vProtobuf;
      if (paramMsgType0x210.uSubMsgType == 290L) {}
      for (;;)
      {
        auxd.a(localQQAppInterface, arrayOfByte, paramMsgInfo, bool);
        return null;
        bool = false;
      }
    }
    if ((paramMsgType0x210.uSubMsgType == 296L) || (paramMsgType0x210.uSubMsgType == 311L))
    {
      j(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 307L)
    {
      i(paramMsgType0x210);
      return null;
    }
    if (paramMsgType0x210.uSubMsgType == 310L) {
      e(paramMsgType0x210.vProtobuf);
    }
    return null;
  }
  
  private MessageRecord a(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x108");
    }
    return arlu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210.vProtobuf, paramMsgInfo);
  }
  
  private void a()
  {
    yqu.a("dyn", "refresh", 0, 0, new String[] { "2" });
  }
  
  private void a(int paramInt, bdei parambdei, long paramLong)
  {
    Object localObject1 = (bddy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(62);
    if (paramInt == 1)
    {
      bddy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte)0, parambdei.c);
      bddy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambdei.c);
      parambdei.a = 1;
      ((bddy)localObject1).a(parambdei.c, 1);
      a(8004, true, parambdei);
    }
    while (paramInt != 0) {
      return;
    }
    localObject1 = String.valueOf(paramLong);
    bdeh localbdeh = (bdeh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61);
    parambdei.a((String)localObject1);
    localbdeh.a(parambdei);
    Object localObject2 = parambdei.a();
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "decodeC2CMsgPush() hint is new,msg num=1, subUin=" + str);
        }
        paramInt = 1 - this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 7000);
        if (paramInt != 0) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(str, 7000, paramInt);
        }
      }
    }
    boolean bool = false;
    localObject2 = bddy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1);
    if (localObject2 != null) {
      bool = ((Boolean)((Pair)localObject2).second).booleanValue();
    }
    if (bool)
    {
      localbdeh.a((String)localObject1, 1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSubAccountKey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), String.valueOf(paramLong), new acwm(this, localbdeh));
    }
    for (;;)
    {
      parambdei.a = 0;
      a(8004, true, parambdei);
      return;
      if (localbdeh.a(String.valueOf(paramLong), 2))
      {
        paramInt = 1 - this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1, 7000);
        if (paramInt != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d((String)localObject1, 7000, paramInt);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new String[] { anhk.x, localObject1 });
        }
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "decodeC2CMsgPush() hint need to verify,msg num=1, subUin=" + (String)localObject1);
        }
      }
    }
  }
  
  private void a(long paramLong1, long paramLong2, SubMsgType0x83.MsgParams paramMsgParams, int paramInt)
  {
    if ((paramInt >= 2001) && (paramInt <= 3000)) {
      if ((paramMsgParams.str_data.has()) && (paramMsgParams.uint64_from_uin.has()) && (paramMsgParams.uint64_to_uin.has())) {}
    }
    do
    {
      int i;
      do
      {
        return;
        localObject = paramMsgParams.str_data.get();
        try
        {
          i = new JSONObject((String)localObject).getInt("count");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt, paramMsgParams.uint64_from_uin.get(), paramMsgParams.uint64_to_uin.get(), i, paramLong1, paramLong2);
          return;
        }
        catch (Exception paramMsgParams)
        {
          return;
        }
        if (paramInt != 1005) {
          break;
        }
      } while ((!paramMsgParams.str_data.has()) || (!paramMsgParams.uint64_from_uin.has()) || (!paramMsgParams.uint64_to_uin.has()));
      Object localObject = paramMsgParams.str_data.get();
      try
      {
        localObject = new JSONObject((String)localObject);
        paramInt = ((JSONObject)localObject).optInt("enable");
        i = ((JSONObject)localObject).optInt("level");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMsgParams.uint32_type.get(), paramMsgParams.uint64_from_uin.get(), paramMsgParams.uint64_to_uin.get(), paramInt, i, paramLong1, paramLong2);
        return;
      }
      catch (Exception paramMsgParams)
      {
        return;
      }
    } while ((paramInt != 1010) || (!paramMsgParams.bytes_data.has()));
    paramMsgParams = new String(paramMsgParams.bytes_data.get().toByteArray());
    for (;;)
    {
      try
      {
        paramMsgParams = new JSONObject(paramMsgParams);
        if (paramMsgParams.getInt("sndRank") != 0)
        {
          paramInt = 1;
          boolean bool = paramMsgParams.getBoolean("rank_changed");
          if ((paramInt == 0) || (!bool)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2);
          return;
        }
      }
      catch (Exception paramMsgParams)
      {
        return;
      }
      paramInt = 0;
    }
  }
  
  private void a(long paramLong, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x113, ]");
    }
    azvf.a(paramMsgType0x210.vProtobuf, paramLong);
  }
  
  private void a(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0xfe");
    }
    ((MsgBoxInterFollowManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202)).decode0xfeInteractAndFollowMsg(paramMsgType0x210.vProtobuf);
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong, MsgType0x210 paramMsgType0x210)
  {
    long l1 = paramMsgInfo.lFromUin;
    int i = paramMsgInfo.shMsgSeq;
    long l2 = paramMsgInfo.lMsgUid;
    int j = paramMsgInfo.shMsgType;
    int k = (int)paramMsgType0x210.uSubMsgType;
    if (((anyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(85)).a(paramMsgInfo.shMsgSeq)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "receive same message, seq = " + paramMsgInfo.shMsgSeq);
      }
    }
    for (;;)
    {
      bbzf.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l1, i, l2, j);
      return;
      if (bcal.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210.vProtobuf, l1, paramLong, i, j, k)) {
        a("handleActivateFriendsPush", true, 1, true, false);
      }
    }
  }
  
  private void a(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "receive msg0x210submsg0x7e");
    }
    akmq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210.vProtobuf, paramMsgInfo.lFromUin, paramMsgInfo.shMsgSeq, paramMsgInfo.lMsgUid, paramMsgInfo.shMsgType);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcReqPushMsg paramSvcReqPushMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a = paramSvcReqPushMsg.wUserActive;
    String str1;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    long l3;
    int m;
    ArrayList localArrayList4;
    label153:
    MsgInfo localMsgInfo;
    if ((paramSvcReqPushMsg.wGeneralFlag & 0x20) == 32)
    {
      bghu.a(true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "OnlinePush.ReqPush,notify.wUserActive:", Integer.valueOf(paramSvcReqPushMsg.wUserActive), ", muteGeneralFlag:", Integer.valueOf(paramSvcReqPushMsg.wGeneralFlag) });
      }
      str1 = (String)paramFromServiceMsg.getAttribute("_tag_LOGSTR");
      localArrayList1 = new ArrayList();
      localArrayList2 = paramSvcReqPushMsg.vMsgInfos;
      if ((localArrayList2 == null) || (localArrayList2.size() <= 0)) {
        break label2290;
      }
      localArrayList3 = new ArrayList();
      l3 = paramSvcReqPushMsg.lUin;
      m = paramSvcReqPushMsg.svrip;
      localArrayList4 = new ArrayList();
      Iterator localIterator = localArrayList2.iterator();
      if (!localIterator.hasNext()) {
        break label2050;
      }
      localMsgInfo = (MsgInfo)localIterator.next();
    }
    for (;;)
    {
      long l2;
      long l1;
      long l4;
      label514:
      MessageRecord localMessageRecord;
      try
      {
        new ArrayList();
        k = localMsgInfo.shMsgType;
        localObject = null;
        l2 = localMsgInfo.lFromUin;
        l1 = localMsgInfo.lFromUin;
        if (paramFromServiceMsg.getUin() != null) {
          continue;
        }
        paramToServiceMsg = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        l4 = paramToServiceMsg.longValue();
        if (l4 == l2) {}
        paramToServiceMsg = new DelMsgInfo();
        ((anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(localMsgInfo.lFromUin);
        paramToServiceMsg.lFromUin = localMsgInfo.lFromUin;
        paramToServiceMsg.shMsgSeq = localMsgInfo.shMsgSeq;
        paramToServiceMsg.uMsgTime = localMsgInfo.uMsgTime;
        paramToServiceMsg.vMsgCookies = localMsgInfo.vMsgCookies;
        localArrayList3.add(paramToServiceMsg);
        if ((42 != k) && (83 != k) && (127 != k) && (QLog.isColorLevel())) {
          anqc.a("Q.msg.BaseMessageProcessor", str1, localMsgInfo.shMsgSeq, String.valueOf(l3), String.valueOf(localMsgInfo.lFromUin));
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp  before analysis msgInfo.lFromUin: " + localMsgInfo.lFromUin + " msgInfo.shMsgType: " + localMsgInfo.shMsgType + " msgInfo.uRealMsgTime: " + localMsgInfo.uRealMsgTime + " msgInfo.shMsgSeq: " + localMsgInfo.shMsgSeq + ", msgInfo.lMsgUid" + localMsgInfo.lMsgUid);
        }
        if (!aofs.a().containsKey(Integer.valueOf(k))) {
          continue;
        }
        paramToServiceMsg = b(k, localMsgInfo, paramSvcReqPushMsg);
        if (paramToServiceMsg == null) {
          break label2224;
        }
        if (paramToServiceMsg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
          localArrayList1.add(paramToServiceMsg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        }
        if (paramToServiceMsg.jdField_a_of_type_Boolean) {
          break label153;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        String str2;
        label587:
        paramToServiceMsg.printStackTrace();
        if ((localMsgInfo.vMsg == null) || (!QLog.isColorLevel())) {
          continue;
        }
        QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp Exception msgInfo.vMsg: " + bgmj.a(localMsgInfo.vMsg));
        continue;
      }
      if (paramToServiceMsg != null)
      {
        localMessageRecord = bbzh.a(i);
        if (j != 1006) {
          break label2020;
        }
        str2 = bglf.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l2));
        localMessageRecord.init(String.valueOf(l3), bglf.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1)), str2, paramToServiceMsg, localMsgInfo.uRealMsgTime, i, j, localMsgInfo.uMsgTime);
        localMessageRecord.shmsgseq = localMsgInfo.shMsgSeq;
        localMessageRecord.isread = bool1;
        localMessageRecord.msgUid = localMsgInfo.lMsgUid;
        localMessageRecord.msgData = ((byte[])localObject);
        if (k > 0) {
          localMessageRecord.extraflag = k;
        }
        if (!anqc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, true)) {
          localArrayList1.add(localMessageRecord);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp after analysis friendUin: " + l1 + " msgType: " + i + " friendType: " + j + " shMsgSeq: " + localMsgInfo.shMsgSeq + " msgContent: " + bgjw.a(paramToServiceMsg));
        }
      }
      if (localMsgInfo.uAppShareID <= 0L) {
        break label153;
      }
      localArrayList4.add(bgkh.a(localMsgInfo.uAppShareID));
      break label153;
      bghu.a(false);
      break;
      paramToServiceMsg = Long.valueOf(paramFromServiceMsg.getUin());
      continue;
      if (169 == k)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "------->msgFilter-handleC2COnlinePushMsgResp receive msg size:" + localArrayList2.size());
        }
        if (anqc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, String.valueOf(l1), String.valueOf(l2), localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq)) {
          break label153;
        }
        localArrayList3.remove(paramToServiceMsg);
        paramToServiceMsg = new String(localMsgInfo.vMsg) + localMsgInfo.uMsgTime;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramToServiceMsg))
        {
          paramToServiceMsg = new long[1];
          paramToServiceMsg[0] = localMsgInfo.lFromUin;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "---->handleC2COnlinePushMsgResp, new file msg, about to call handleOffLineFileResp");
          }
          a(String.valueOf(l1), l3, paramToServiceMsg, localMsgInfo.vMsg, localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq, false);
          localMsgInfo.lFromUin = paramToServiceMsg[0];
          break label153;
        }
        if (!QLog.isColorLevel()) {
          break label153;
        }
        QLog.d("Q.msg.BaseMessageProcessor", 2, "rcv a repeated offline file push msg");
        break label153;
      }
      if (8 == k)
      {
        paramToServiceMsg = new byte[4];
        if (localMsgInfo.vMsg.length > 4) {
          bgva.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, 4);
        }
        l2 = bgva.a(paramToServiceMsg, 0);
        if (localMsgInfo.vMsg.length >= 9)
        {
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 9];
          bgva.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 8, paramToServiceMsg.length);
          paramToServiceMsg = new String(bbzj.a(paramToServiceMsg), "utf-8");
          break label2246;
        }
      }
      else
      {
        if (132 == k)
        {
          paramToServiceMsg = new byte[4];
          if (localMsgInfo.vMsg.length > 4) {
            bgva.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, 4);
          }
          l2 = bgva.a(paramToServiceMsg, 0);
          paramToServiceMsg = (ToServiceMsg)localObject;
          if (localMsgInfo.vMsg.length < 9) {
            break label2268;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 9];
          bgva.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 8, paramToServiceMsg.length);
          paramToServiceMsg = new String(bbzj.a(paramToServiceMsg), "utf-8");
          break label2268;
        }
        if (732 == k)
        {
          if (localMsgInfo.vMsg == null) {
            return;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length];
          bgva.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, paramToServiceMsg.length);
          i = paramToServiceMsg[4];
          if (!QLog.isColorLevel()) {
            break label2291;
          }
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<---0x2dc push  groupCode:" + bgva.a(localMsgInfo.vMsg, 0) + " subType:" + i + "msgSeq:" + localMsgInfo.shMsgSeq);
          break label2291;
          label1367:
          if (localMsgInfo.vMsg.length <= 7) {
            break label2315;
          }
          paramToServiceMsg = (bfuk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(81);
          localObject = new byte[localMsgInfo.vMsg.length - 7];
          bgva.a((byte[])localObject, 0, localMsgInfo.vMsg, 7, localObject.length);
          paramToServiceMsg = paramToServiceMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte[])localObject, localMsgInfo.shMsgSeq, localMsgInfo.uRealMsgTime, false, false, null);
          if (paramToServiceMsg == null) {
            break label2315;
          }
          localArrayList1.add(paramToServiceMsg);
          break label2315;
          label1459:
          ((bfsk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(paramToServiceMsg, localMsgInfo.shMsgSeq);
          break label2315;
          label1484:
          if (i == 15)
          {
            a(paramToServiceMsg, localMsgInfo.shMsgSeq);
            return;
          }
          if (i != 6) {
            break label2354;
          }
          i(paramToServiceMsg);
          break label2315;
          label1518:
          if (localMsgInfo.vMsg.length <= 7) {
            break label2315;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 7];
          bgva.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 7, paramToServiceMsg.length);
          b(paramToServiceMsg, i);
          break label2315;
        }
        if (230 == k)
        {
          paramToServiceMsg = new String(bbzj.a(localMsgInfo.vMsg), "utf-8");
          localObject = ((anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(l1 + "");
          if ((localObject != null) && (((Friends)localObject).isFriend())) {
            j = 0;
          }
        }
      }
      for (;;)
      {
        localObject = new SafeMsg.SafeMoreInfo();
        ((SafeMsg.SafeMoreInfo)localObject).strFromMobile.set(localMsgInfo.strFromMobile);
        ((SafeMsg.SafeMoreInfo)localObject).strFromName.set(localMsgInfo.strFromName);
        ((SafeMsg.SafeMoreInfo)localObject).strMsgTxt.set(paramToServiceMsg);
        localObject = ((SafeMsg.SafeMoreInfo)localObject).toByteArray();
        i = -1002;
        k = -1;
        bool1 = true;
        break label514;
        localObject = ((awmz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).b(String.valueOf(l2));
        if ((localObject != null) && (((String)localObject).length() != 0))
        {
          j = 1006;
          continue;
          if (SystemMsg.isSystemMessage(k))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(2);
            l1 = 9998L;
            i = -1006 - (k - 187);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(l3, localMsgInfo.lFromUin, k, i, localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq);
            bool1 = false;
            k = -1;
            localObject = null;
            paramToServiceMsg = null;
            j = 0;
            break label514;
          }
          if (SystemMsg.isTroopSystemMessage(k))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(3);
            if (k == 45) {
              break label2208;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(k, localMsgInfo.vMsg, localMsgInfo.lFromUin, localMsgInfo.uMsgTime, null);
            l1 = 9998L;
            j = 32769;
          }
          for (i = SystemMsg.getTroopSystemMsgType(k);; i = -1000)
          {
            bdgn.a().a(l2, localMsgInfo.uMsgTime, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            k = j;
            localObject = null;
            paramToServiceMsg = null;
            j = 0;
            bool1 = false;
            break label514;
            if (528 == k)
            {
              paramToServiceMsg = a(localMsgInfo, l4);
              if ((paramToServiceMsg == null) || (anqc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, true))) {
                break label2379;
              }
              localArrayList1.add(paramToServiceMsg);
              break label2379;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp msgtype: unknow msgType!!!");
            break;
            label2020:
            localMessageRecord.init(l3, l1, l2, paramToServiceMsg, localMsgInfo.uRealMsgTime, i, j, localMsgInfo.uMsgTime);
            break label587;
            label2050:
            if (localArrayList4.size() > 0) {
              a(localArrayList4);
            }
            i = paramFromServiceMsg.getRequestSsoSeq();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l3, localArrayList3, m, i, null);
            boolean bool2;
            if (localArrayList1.size() > 0)
            {
              bool2 = anqc.a(localArrayList1);
              i = acwh.a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
              if ((!bool2) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {
                break label2202;
              }
            }
            label2202:
            for (bool1 = true;; bool1 = false)
            {
              paramToServiceMsg.a(localArrayList1, String.valueOf(l3), bool1);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((int)paramSvcReqPushMsg.uMsgTime);
              a("handleGetBuddyMessageResp", true, i, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2), false);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localArrayList1);
              return;
            }
            label2208:
            j = -1;
          }
          paramToServiceMsg = null;
          break label2246;
          label2224:
          bool1 = false;
          k = -1;
          localObject = null;
          paramToServiceMsg = null;
          i = -1000;
          j = 0;
          break label514;
          label2246:
          j = 1000;
          i = -1000;
          k = -1;
          localObject = null;
          bool1 = false;
          break label514;
          label2268:
          j = 1020;
          i = -1000;
          k = -1;
          localObject = null;
          bool1 = false;
          break label514;
          label2290:
          return;
          label2291:
          if ((i == 16) || (i == 17)) {
            break label1367;
          }
          if (i == 20) {
            break label1367;
          }
          label2315:
          label2354:
          do
          {
            bool1 = false;
            k = -1;
            localObject = null;
            paramToServiceMsg = null;
            i = -1000;
            j = 0;
            break;
            if (i == 12) {
              break label1459;
            }
            if (i != 14) {
              break label1484;
            }
            break label1459;
            if (i == 11) {
              break label1518;
            }
          } while (i != 13);
          break label1518;
        }
        j = 1000;
      }
      label2379:
      boolean bool1 = false;
      int k = -1;
      Object localObject = null;
      paramToServiceMsg = null;
      int i = -1000;
      int j = 0;
    }
  }
  
  private void a(String paramString, long paramLong1, long[] paramArrayOfLong, byte[] paramArrayOfByte, long paramLong2, short paramShort, boolean paramBoolean)
  {
    paramLong1 = paramArrayOfLong[0];
    paramArrayOfByte = bdtd.a(paramArrayOfByte, paramArrayOfLong);
    if (paramArrayOfByte != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, String.valueOf(paramArrayOfLong[0]), paramArrayOfByte, paramLong2, paramShort, paramLong1, paramBoolean);
    }
  }
  
  private boolean a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 2: 
    default: 
      return false;
    case 1: 
      return true;
    }
    return true;
  }
  
  private boolean a(MsgType0x210 paramMsgType0x210)
  {
    return paramMsgType0x210.uSubMsgType == 59L;
  }
  
  private boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = false;
    long l1 = bgva.a(paramArrayOfByte, 0);
    if (paramArrayOfByte[4] == 15)
    {
      long l2 = bgva.a(paramArrayOfByte, 5);
      long l3 = bgva.a(paramArrayOfByte, 9);
      int i = bgva.b(paramArrayOfByte, 13);
      paramArrayOfByte = bgva.a(paramArrayOfByte, 15, i);
      long l4 = NetConnInfoCenter.getServerTime();
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(paramInt, l1, l4, l3, l2, paramArrayOfByte);
      bool = true;
    }
    return bool;
  }
  
  private void aa(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevLock", 2, "recv msg0x210.Submsgtype0x48");
    }
    RecommendDeviceLock localRecommendDeviceLock = new RecommendDeviceLock();
    try
    {
      localRecommendDeviceLock.mergeFrom(paramMsgType0x210.vProtobuf);
      paramMsgType0x210 = new Intent();
      paramMsgType0x210.putExtra("canCancel", localRecommendDeviceLock.canCancel.get());
      paramMsgType0x210.putExtra("tipMsg", localRecommendDeviceLock.wording.get());
      paramMsgType0x210.putExtra("title", localRecommendDeviceLock.str_title.get());
      paramMsgType0x210.putExtra("secondTitle", localRecommendDeviceLock.str_second_title.get());
      paramMsgType0x210.putExtra("thirdTitle", localRecommendDeviceLock.str_third_title.get());
      List localList = localRecommendDeviceLock.str_wording_list.get();
      ArrayList localArrayList = new ArrayList();
      if ((localList != null) && (localList.size() > 0)) {
        localArrayList.addAll(localList);
      }
      paramMsgType0x210.putStringArrayListExtra("wordsList", localArrayList);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setDevLockIntent(paramMsgType0x210);
      a(8007, true, new Object[] { Boolean.valueOf(localRecommendDeviceLock.canCancel.get()), localRecommendDeviceLock.wording.get(), localRecommendDeviceLock.str_title.get(), localRecommendDeviceLock.str_second_title.get(), localRecommendDeviceLock.str_third_title.get(), localArrayList });
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevLock", 2, "failed to parse msg0x210.Submsgtype0x48");
      }
      a(8007, false, new Object[] { Boolean.valueOf(true), "" });
    }
  }
  
  private void ab(MsgType0x210 paramMsgType0x210)
  {
    new ayby(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramMsgType0x210.vProtobuf);
  }
  
  private void ac(MsgType0x210 paramMsgType0x210)
  {
    anjo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210.vProtobuf);
  }
  
  private void ad(MsgType0x210 paramMsgType0x210)
  {
    ((bdbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17)).a(paramMsgType0x210.vProtobuf);
  }
  
  private void ae(MsgType0x210 paramMsgType0x210)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        Submsgtype0x3b.MsgBody localMsgBody = new Submsgtype0x3b.MsgBody();
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder().append("0x210Push_0x3b, group code: ");
          if (!localMsgBody.uint64_group_code.has()) {
            break label414;
          }
          paramMsgType0x210 = String.valueOf(localMsgBody.uint64_group_code.get());
          localObject1 = ((StringBuilder)localObject1).append(paramMsgType0x210).append(", user switch: ");
          if (localMsgBody.uint32_user_show_flag.has())
          {
            paramMsgType0x210 = String.valueOf(localMsgBody.uint32_user_show_flag.get());
            QLog.d("Q.getTroopMemberLevelInfo", 2, paramMsgType0x210 + ", level map changed: " + localMsgBody.uint32_member_level_changed.has() + ",uint32_member_level_new_changed" + localMsgBody.uint32_member_level_new_changed.has());
          }
        }
        else
        {
          if (!localMsgBody.uint64_group_code.has()) {
            break label413;
          }
          if (localMsgBody.uint32_user_show_flag.has())
          {
            int i = localMsgBody.uint32_user_show_flag.get();
            paramMsgType0x210 = String.valueOf(localMsgBody.uint64_group_code.get());
            Object localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
            localObject1 = ((TroopManager)localObject2).b(paramMsgType0x210);
            ((TroopInfo)localObject1).cGroupRankUserFlag = ((byte)i);
            ((TroopManager)localObject2).b((TroopInfo)localObject1);
            localObject2 = (anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
            if (localObject2 != null)
            {
              if (i == 1) {
                bool = true;
              }
              ((anwd)localObject2).notifyUI(152, true, new Object[] { paramMsgType0x210, Boolean.valueOf(bool) });
            }
            if (1 == ((TroopInfo)localObject1).cGroupRankUserFlag) {
              ((anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).f(paramMsgType0x210);
            }
          }
          if (localMsgBody.uint32_member_level_changed.has())
          {
            l = localMsgBody.uint64_group_code.get();
            ((anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).f(String.valueOf(l));
          }
          if (!localMsgBody.uint32_member_level_new_changed.has()) {
            break label413;
          }
          long l = localMsgBody.uint64_group_code.get();
          ((anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).f(String.valueOf(l));
          return;
        }
        paramMsgType0x210 = "";
        continue;
        return;
      }
      catch (Exception paramMsgType0x210)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.getTroopMemberLevelInfo", 2, "0x210Push_0x3b, failed to parse Submsgtype0x3b.MsgBody");
        }
      }
      label413:
      label414:
      paramMsgType0x210 = "";
    }
  }
  
  private void af(MsgType0x210 paramMsgType0x210)
  {
    int i;
    int j;
    Object localObject3;
    label357:
    do
    {
      for (;;)
      {
        try
        {
          Object localObject1 = new submsgtype0xc9.MsgBody();
          ((submsgtype0xc9.MsgBody)localObject1).mergeFrom(paramMsgType0x210.vProtobuf);
          if (((submsgtype0xc9.MsgBody)localObject1).uint32_type.get() == 1)
          {
            String str1 = ((submsgtype0xc9.MsgBody)localObject1).uint64_from_uin.get() + "";
            String str2 = ((submsgtype0xc9.MsgBody)localObject1).uint64_action_uin.get() + "";
            if (((submsgtype0xc9.MsgBody)localObject1).source.get() != 2) {
              break label357;
            }
            i = 1001;
            if (((submsgtype0xc9.MsgBody)localObject1).bool_new_friend.get())
            {
              i = 0;
              localObject2 = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
              ((FriendListHandler)localObject2).notifyUI(63, true, str1);
              ((FriendListHandler)localObject2).b(str1);
            }
            localObject1 = ((submsgtype0xc9.MsgBody)localObject1).rpt_msg_business_msg.get().iterator();
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (submsgtype0xc9.BusinessMsg)((Iterator)localObject1).next();
              j = ((submsgtype0xc9.BusinessMsg)localObject2).msg_type.get();
              if (j != 1) {
                break;
              }
              localObject3 = (MessageForText)bbzh.a(-1000);
              ((MessageForText)localObject3).frienduin = str1;
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(str2)) {
                ((MessageForText)localObject3).issend = 1;
              }
              ((MessageForText)localObject3).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str1, str2, ((submsgtype0xc9.BusinessMsg)localObject2).bytes_msg_data.get().toStringUtf8(), NetConnInfoCenter.getServerTime(), -1000, i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, i).shmsgseq + 1L);
              ((MessageForText)localObject3).isread = false;
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
              continue;
            }
          }
          return;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessorQ.nearby.follow", 2, "附近、部落关注关系变化通知小灰条InvalidProtocolBufferMicroException|msg0x210.uSubMsgType:" + paramMsgType0x210.uSubMsgType);
          }
        }
        i = 10002;
      }
    } while (j != 2);
    boolean bool = ((submsgtype0xc9.BusinessMsg)localObject2).bool_tab_visible.get();
    Object localObject2 = ((submsgtype0xc9.BusinessMsg)localObject2).bytes_msg_data.get().toStringUtf8();
    if (bool)
    {
      localObject3 = (MessageForNewGrayTips)bbzh.a(-5001);
      ((MessageForNewGrayTips)localObject3).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localInvalidProtocolBufferMicroException, localInvalidProtocolBufferMicroException, (String)localObject2, NetConnInfoCenter.getServerTime(), -5001, i, 1L + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localInvalidProtocolBufferMicroException, i).shmsgseq);
      ((MessageForNewGrayTips)localObject3).isread = true;
      ((MessageForNewGrayTips)localObject3).mNeedTimeStamp = true;
      ((MessageForNewGrayTips)localObject3).updateMsgData();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    while (QLog.isColorLevel())
    {
      QLog.d("Q.msg.BaseMessageProcessorQ.nearby.follow", 2, "附近、部落关注关系变化通知小灰条.grayTipsTabVisable:" + bool + "|msg:" + (String)localObject2);
      break;
      localObject3 = bbzh.a(-5000);
      ((MessageRecord)localObject3).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localInvalidProtocolBufferMicroException, localInvalidProtocolBufferMicroException, (String)localObject2, NetConnInfoCenter.getServerTime(), -5000, i, 1L + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localInvalidProtocolBufferMicroException, i).shmsgseq);
      ((MessageRecord)localObject3).isread = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
  }
  
  private void ag(MsgType0x210 paramMsgType0x210)
  {
    try
    {
      int i = ((Submsgtype0x35.MsgBody)new Submsgtype0x35.MsgBody().mergeFrom(paramMsgType0x210.vProtobuf)).uint32_bubble_timestamp.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "bubble push timestamp=" + i);
      }
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.BaseMessageProcessor", 2, "<---decodeC2CMsgPkg_SecretfileReport parse failed.", paramMsgType0x210);
    }
  }
  
  private void ah(MsgType0x210 paramMsgType0x210)
  {
    paramMsgType0x210 = paramMsgType0x210.stMsgInfo0x24;
    if ((paramMsgType0x210 != null) && (paramMsgType0x210.vPluginNumList != null))
    {
      Object localObject = paramMsgType0x210.vPluginNumList;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramMsgType0x210 = (bccg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
        if (paramMsgType0x210 != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            PluginNum localPluginNum = (PluginNum)((Iterator)localObject).next();
            if (localPluginNum != null)
            {
              long l = localPluginNum.dwID;
              if (localPluginNum.cFlag == 0) {}
              for (boolean bool = false;; bool = true)
              {
                paramMsgType0x210.a(l, bool, localPluginNum.dwNUm);
                break;
              }
            }
          }
        }
      }
    }
  }
  
  private void ai(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xea, [S2C push for ark]");
    }
    for (;;)
    {
      try
      {
        Object localObject = new submsgtype0xea.MsgBody();
        if (h(paramMsgType0x210))
        {
          ((submsgtype0xea.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
          if (((submsgtype0xea.MsgBody)localObject).bytes_title.has())
          {
            paramMsgType0x210 = ((submsgtype0xea.MsgBody)localObject).bytes_title.get().toStringUtf8();
            if (((submsgtype0xea.MsgBody)localObject).bytes_content.has())
            {
              localObject = ((submsgtype0xea.MsgBody)localObject).bytes_content.get().toStringUtf8();
              appj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210, (String)localObject);
              return;
            }
            localObject = "";
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramMsgType0x210)
      {
        QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0xea], errInfo->" + paramMsgType0x210.getMessage());
      }
      paramMsgType0x210 = "";
    }
  }
  
  private acwn b(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(aofs.a(paramInt)).a(aofs.a(paramInt), paramMsgInfo, paramSvcReqPushMsg);
  }
  
  private MessageRecord b(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x100");
    }
    return arkq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210.vProtobuf, paramMsgInfo);
  }
  
  private void b()
  {
    antq localantq = (antq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(22);
    if (localantq != null) {
      localantq.a();
    }
  }
  
  private void b(long paramLong, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, "onLinePush receive 0x210_0xdf, [C2C push]");
    }
    Object localObject1;
    long l;
    try
    {
      localObject1 = new submsgtype0xdf.MsgBody();
      ((submsgtype0xdf.MsgBody)localObject1).mergeFrom(paramMsgType0x210.vProtobuf);
      if (((submsgtype0xdf.MsgBody)localObject1).msg_game_state.has())
      {
        paramMsgType0x210 = (apollo_game_status.STCMGameMessage)((submsgtype0xdf.MsgBody)localObject1).msg_game_state.get();
        Object localObject2 = (apollo_game_status.STCMGameMessage.STMsgComm)paramMsgType0x210.msg_comm.get();
        l = bgjw.a(((apollo_game_status.STCMGameMessage.STMsgComm)localObject2).uint32_session_id.get());
        localObject1 = (amgz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(211);
        if (paramLong != l) {
          break label203;
        }
        localObject2 = ((apollo_game_status.STCMGameMessage.STMsgComm)localObject2).rpt_uint32_session_list.get();
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            l = bgjw.a(((Integer)((Iterator)localObject2).next()).intValue());
            if (l != paramLong) {
              ((amgz)localObject1).a(0, 0, Long.toString(l), paramMsgType0x210);
            }
          }
        }
      }
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      QLog.e("ApolloGameManager", 1, "onLinePush 0x210_0xdf push exception : ", paramMsgType0x210);
    }
    label203:
    ((amgz)localObject1).a(0, 0, Long.toString(l), paramMsgType0x210);
  }
  
  private void b(long paramLong, byte[] paramArrayOfByte)
  {
    Object localObject = new submsgtype0x31.MsgBody();
    try
    {
      paramArrayOfByte = (submsgtype0x31.MsgBody)((submsgtype0x31.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = new HashMap();
        paramArrayOfByte.put("param_FailCode", "12017");
        paramArrayOfByte.put("fail_step", "msgbyod_null");
        paramArrayOfByte.put("fail_location", "MessageHandler");
        bctj.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      int i;
      long l1;
      long l2;
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "<---decodeC2CMsgPkg_SecretfileReport parse failed.", paramArrayOfByte);
          }
          paramArrayOfByte = null;
        }
        if ((!paramArrayOfByte.uint32_flag.has()) || (!paramArrayOfByte.uint64_bind_uin.has()) || (!paramArrayOfByte.uint64_uin.has()))
        {
          paramArrayOfByte = new HashMap();
          paramArrayOfByte.put("param_FailCode", "12017");
          paramArrayOfByte.put("fail_step", "uinflag_null");
          paramArrayOfByte.put("fail_location", "MessageHandler");
          bctj.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
          return;
        }
        i = paramArrayOfByte.uint32_flag.get();
        l1 = paramArrayOfByte.uint32_time.get();
        l1 = paramArrayOfByte.uint64_uin.get();
        l2 = paramArrayOfByte.uint64_bind_uin.get();
        if ((l1 <= 0L) || (l2 <= 0L))
        {
          paramArrayOfByte = new HashMap();
          paramArrayOfByte.put("param_FailCode", "12017");
          paramArrayOfByte.put("fail_step", "uin_error");
          paramArrayOfByte.put("fail_location", "MessageHandler");
          bctj.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
          return;
        }
      } while (!String.valueOf(paramLong).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
      paramArrayOfByte = new bdei();
      paramArrayOfByte.c = String.valueOf(l1);
      paramArrayOfByte.b = String.valueOf(l2);
      localObject = new HashMap();
      ((HashMap)localObject).put("param_FailCode", "12018");
      ((HashMap)localObject).put("fail_step", "success_" + i);
      ((HashMap)localObject).put("fail_location", "MessageHandler");
      bctj.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBPushNotifaction", true, 0L, 0L, (HashMap)localObject, "");
      a(i, paramArrayOfByte, l1);
    }
  }
  
  private void b(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0xd7");
    }
    ((MsgBoxInterFollowManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202)).decode0xd7InteractAndFollowMsg(paramMsgType0x210.vProtobuf);
  }
  
  private void b(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "receive msg0x210submsg0x66");
    }
    akmq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210.vProtobuf, paramMsgInfo.lFromUin, paramMsgInfo.shMsgSeq, paramMsgInfo.lMsgUid, paramMsgInfo.shMsgType);
  }
  
  private void b(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = new cmd0x2dc.GroupVisitorJoinMsg();
    try
    {
      cmd0x2dc.GroupVisitorJoinMsg localGroupVisitorJoinMsg = (cmd0x2dc.GroupVisitorJoinMsg)((cmd0x2dc.GroupVisitorJoinMsg)localObject).mergeFrom(paramArrayOfByte);
      long l = localGroupVisitorJoinMsg.uint64_group_code.get();
      paramArrayOfByte = localGroupVisitorJoinMsg.rpt_msg_visitor_join_info.get();
      int i;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).b(String.valueOf(l)))
        {
          Iterator localIterator = paramArrayOfByte.iterator();
          paramArrayOfByte = "";
          while (localIterator.hasNext())
          {
            cmd0x2dc.VisitorJoinInfo localVisitorJoinInfo = (cmd0x2dc.VisitorJoinInfo)localIterator.next();
            String str = "" + localVisitorJoinInfo.uint64_visitor_uin.get();
            if (!str.equalsIgnoreCase((String)localObject))
            {
              if (localVisitorJoinInfo.bytes_visitor_name.get().toStringUtf8().equals("")) {}
              for (paramArrayOfByte = paramArrayOfByte + str + "、";; paramArrayOfByte = paramArrayOfByte + localVisitorJoinInfo.bytes_visitor_name.get().toStringUtf8() + "、") {
                break;
              }
            }
          }
          localObject = paramArrayOfByte;
          if (paramArrayOfByte.length() > 1) {
            localObject = paramArrayOfByte.substring(0, paramArrayOfByte.length() - 1);
          }
          if (!localGroupVisitorJoinMsg.uint32_op_flag.has()) {
            break label398;
          }
          i = localGroupVisitorJoinMsg.uint32_op_flag.get();
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageProcessor", 2, "handleEnterOpenTroopHotChatPushMsg. groupCode=" + l + ", name=" + (String)localObject + ", op_flag=" + i);
          }
          if (paramInt != 11) {
            break label403;
          }
          paramArrayOfByte = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131692886);
        }
      }
      for (;;)
      {
        aoey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l), paramArrayOfByte, 1, false, true);
        return;
        label398:
        i = 0;
        break;
        label403:
        paramArrayOfByte = (byte[])localObject;
        if (paramInt == 13) {
          if (1 == i) {
            paramArrayOfByte = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131692904);
          } else {
            paramArrayOfByte = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131692890);
          }
        }
      }
      return;
    }
    catch (Exception paramArrayOfByte) {}
  }
  
  private boolean b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private boolean b(MsgType0x210 paramMsgType0x210)
  {
    return paramMsgType0x210.uSubMsgType == 201L;
  }
  
  @Nullable
  private MessageRecord c(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    Object localObject = (anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    tencent.im.s2c.msgtype0x210.submsgtype0xa2.MsgBody localMsgBody = new tencent.im.s2c.msgtype0x210.submsgtype0xa2.MsgBody();
    localMessageForQQWalletTips = (MessageForQQWalletTips)bbzh.a(-2029);
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      String str1 = localMsgBody.uint64_sender_uin.get() + "";
      String str2 = localMsgBody.uint64_receiver_uin.get() + "";
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(str1))
      {
        paramMsgType0x210 = str2;
        localObject = ((anmw)localObject).e(paramMsgType0x210);
        if ((localObject == null) || (!((Friends)localObject).isFriend())) {
          break label282;
        }
      }
      label282:
      for (int i = 0;; i = 1001)
      {
        localMessageForQQWalletTips.senderUin = str1;
        localMessageForQQWalletTips.reciverUin = str2;
        localMessageForQQWalletTips.senderContent = localMsgBody.bytes_sender_rich_content.get().toStringUtf8();
        localMessageForQQWalletTips.reciverContent = localMsgBody.bytes_receiver_rich_content.get().toStringUtf8();
        localMessageForQQWalletTips.authKey = localMsgBody.bytes_authkey.get().toStringUtf8();
        localMessageForQQWalletTips.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramMsgType0x210, "", "[QQWallet Tips]", paramMsgInfo.getUMsgTime(), -2029, i, paramMsgInfo.getShMsgSeq());
        localMessageForQQWalletTips.isread = true;
        localMessageForQQWalletTips.shmsgseq = paramMsgInfo.shMsgSeq;
        localMessageForQQWalletTips.msgUid = paramMsgInfo.lMsgUid;
        localMessageForQQWalletTips.getBytes();
        localMessageForQQWalletTips.onReceiveGrapTips();
        return localMessageForQQWalletTips;
        paramMsgType0x210 = str1;
        break;
      }
      return localMessageForQQWalletTips;
    }
    catch (Exception paramMsgInfo)
    {
      paramMsgInfo.printStackTrace();
    }
  }
  
  private void c(MsgType0x210 paramMsgType0x210)
  {
    aima.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210.vProtobuf);
  }
  
  private void c(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    avws.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210.vProtobuf, paramMsgInfo.shMsgSeq, paramMsgInfo.uRealMsgTime, false);
  }
  
  private boolean c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private boolean c(MsgType0x210 paramMsgType0x210)
  {
    return paramMsgType0x210.uSubMsgType == 53L;
  }
  
  @Nullable
  private MessageRecord d(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    Object localObject = new tencent.im.s2c.msgtype0x210.submsgtype0x9f.MsgBody();
    MessageForQQWalletTips localMessageForQQWalletTips = (MessageForQQWalletTips)bbzh.a(-2029);
    for (;;)
    {
      int j;
      String str;
      try
      {
        ((tencent.im.s2c.msgtype0x210.submsgtype0x9f.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
        j = 0;
        str = "";
        paramMsgType0x210 = str;
        i = j;
        switch (((tencent.im.s2c.msgtype0x210.submsgtype0x9f.MsgBody)localObject).sint32_sessiontype.get())
        {
        case 5: 
          localMessageForQQWalletTips.senderUin = (((tencent.im.s2c.msgtype0x210.submsgtype0x9f.MsgBody)localObject).uint64_sender_uin.get() + "");
          localMessageForQQWalletTips.reciverUin = (((tencent.im.s2c.msgtype0x210.submsgtype0x9f.MsgBody)localObject).uint64_receiver_uin.get() + "");
          localMessageForQQWalletTips.senderContent = ((tencent.im.s2c.msgtype0x210.submsgtype0x9f.MsgBody)localObject).bytes_sender_rich_content.get().toStringUtf8();
          localMessageForQQWalletTips.reciverContent = ((tencent.im.s2c.msgtype0x210.submsgtype0x9f.MsgBody)localObject).bytes_receiver_rich_content.get().toStringUtf8();
          localMessageForQQWalletTips.authKey = ((tencent.im.s2c.msgtype0x210.submsgtype0x9f.MsgBody)localObject).bytes_authkey.get().toStringUtf8();
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localMessageForQQWalletTips.senderUin))
          {
            str = localMessageForQQWalletTips.reciverUin;
            localMessageForQQWalletTips.init((String)localObject, str, paramMsgType0x210, "[QQWallet Tips]", paramMsgInfo.getUMsgTime(), -2029, i, paramMsgInfo.getShMsgSeq());
            localMessageForQQWalletTips.isread = true;
            localMessageForQQWalletTips.shmsgseq = paramMsgInfo.shMsgSeq;
            localMessageForQQWalletTips.msgUid = paramMsgInfo.lMsgUid;
            localMessageForQQWalletTips.getBytes();
            localMessageForQQWalletTips.onReceiveGrapTips();
            return localMessageForQQWalletTips;
          }
        case 3: 
          i = 1000;
          paramMsgType0x210 = String.valueOf(((tencent.im.s2c.msgtype0x210.submsgtype0x9f.MsgBody)localObject).uint64_group_uin.get());
          break;
        case 4: 
          i = 1004;
          paramMsgType0x210 = String.valueOf(((tencent.im.s2c.msgtype0x210.submsgtype0x9f.MsgBody)localObject).uint64_group_uin.get());
          continue;
          str = localMessageForQQWalletTips.senderUin;
          break;
        default: 
          paramMsgType0x210 = str;
        }
      }
      catch (Exception paramMsgInfo)
      {
        paramMsgInfo.printStackTrace();
        return localMessageForQQWalletTips;
      }
      int i = j;
      continue;
      i = 1001;
      paramMsgType0x210 = str;
    }
  }
  
  private void d(MsgType0x210 paramMsgType0x210)
  {
    for (int i = 0;; i = 0) {
      for (;;)
      {
        try
        {
          Object localObject1 = ((ActivityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSystemService("activity")).getRunningTasks(1);
          if ((localObject1 == null) || (((List)localObject1).size() < 1)) {
            break;
          }
          localObject1 = ((ActivityManager.RunningTaskInfo)((List)localObject1).get(0)).topActivity.getClassName();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xa4 : curActivity: " + (String)localObject1);
          }
          boolean bool = "com.tencent.mobileqq.activity.QQBrowserActivity".equals(localObject1);
          i = bool;
          Intent localIntent;
          Object localObject3 = null;
        }
        catch (Exception localException1)
        {
          try
          {
            bool = ((PowerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSystemService("power")).isScreenOn();
            if ((!bool) || ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) && (i == 0))) {
              localObject3 = new submsgtype0xa4.MsgBody();
            }
            try
            {
              ((submsgtype0xa4.MsgBody)localObject3).mergeFrom(paramMsgType0x210.vProtobuf);
              if (!((submsgtype0xa4.MsgBody)localObject3).bytes_title.has()) {
                break label559;
              }
              paramMsgType0x210 = ((submsgtype0xa4.MsgBody)localObject3).bytes_title.get().toStringUtf8();
              if (!((submsgtype0xa4.MsgBody)localObject3).bytes_brief.has()) {
                break label553;
              }
              localObject1 = ((submsgtype0xa4.MsgBody)localObject3).bytes_brief.get().toStringUtf8();
              if (!((submsgtype0xa4.MsgBody)localObject3).bytes_url.has()) {
                break label547;
              }
              localObject3 = ((submsgtype0xa4.MsgBody)localObject3).bytes_url.get().toStringUtf8();
              if ((!TextUtils.isEmpty(paramMsgType0x210)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xa4 : title: " + paramMsgType0x210 + ", brief: " + (String)localObject1 + ", url:" + (String)localObject3);
                }
                localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), QQBrowserActivity.class);
                localIntent.putExtra("url", (String)localObject3);
                localIntent.putExtra("uintype", 3001);
                localObject3 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
                ((ToServiceMsg)localObject3).extraData.putStringArray("cmds", new String[] { localObject1, paramMsgType0x210, localObject1 });
                ((ToServiceMsg)localObject3).extraData.putParcelable("intent", localIntent);
                ((ToServiceMsg)localObject3).extraData.putParcelable("bitmap", null);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService((ToServiceMsg)localObject3);
                bcst.b(null, "dc00898", "", "", "0X8006425", "0X8006425", 0, 0, "", "", "", "");
              }
              return;
            }
            catch (Exception paramMsgType0x210)
            {
              if (!QLog.isColorLevel()) {
                break label542;
              }
              QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xa4 : fail to parse 0x210_0xa4.");
              paramMsgType0x210.printStackTrace();
              return;
            }
            localException1 = localException1;
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xa4 : fail to get curActivity.");
            }
            localException1.printStackTrace();
            continue;
          }
          catch (Exception localException2)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xa4 : fail to get screen on.");
            }
            localException2.printStackTrace();
            bool = true;
            continue;
          }
        }
        label542:
        label547:
        continue;
        label553:
        Object localObject2 = null;
        continue;
        label559:
        paramMsgType0x210 = null;
      }
    }
  }
  
  private void d(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x119, [S2C push for input status]");
    }
    try
    {
      SubMsgType0x119.MsgBody localMsgBody = new SubMsgType0x119.MsgBody();
      if (h(paramMsgType0x210))
      {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        QLog.d("Q.msg.BaseMessageProcessor", 1, "troopFormLog receive c2c" + localMsgBody.toString());
        if (!bdjg.a(paramMsgInfo.shMsgSeq))
        {
          bdjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMsgBody);
          QLog.d("Q.msg.BaseMessageProcessor", 1, "troopFormLog isPushMessageDuplicated");
        }
      }
      return;
    }
    catch (Exception paramMsgInfo)
    {
      QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0x115], errInfo->" + paramMsgInfo.getMessage());
    }
  }
  
  private boolean d(MsgType0x210 paramMsgType0x210)
  {
    return paramMsgType0x210.uSubMsgType == 49L;
  }
  
  private MessageRecord e(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    Object localObject = new SubMsgType0x85.MsgBody();
    MessageForQQWalletTips localMessageForQQWalletTips = (MessageForQQWalletTips)bbzh.a(-2029);
    for (;;)
    {
      try
      {
        ((SubMsgType0x85.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
        localMessageForQQWalletTips.senderUin = (((SubMsgType0x85.MsgBody)localObject).uint64_sender_uin.get() + "");
        localMessageForQQWalletTips.reciverUin = (((SubMsgType0x85.MsgBody)localObject).uint64_receiver_uin.get() + "");
        localMessageForQQWalletTips.senderContent = ((SubMsgType0x85.MsgBody)localObject).bytes_sender_rich_content.get().toStringUtf8();
        localMessageForQQWalletTips.reciverContent = ((SubMsgType0x85.MsgBody)localObject).bytes_receiver_rich_content.get().toStringUtf8();
        localMessageForQQWalletTips.authKey = ((SubMsgType0x85.MsgBody)localObject).bytes_authkey.get().toStringUtf8();
        localMessageForQQWalletTips.type = ((SubMsgType0x85.MsgBody)localObject).uint32_type.get();
        localMessageForQQWalletTips.subType = ((SubMsgType0x85.MsgBody)localObject).uint32_sub_type.get();
        localMessageForQQWalletTips.bytes_jumpurl = ((SubMsgType0x85.MsgBody)localObject).bytes_jumpurl.get().toStringUtf8();
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localMessageForQQWalletTips.senderUin)) {
          continue;
        }
        paramMsgType0x210 = localMessageForQQWalletTips.reciverUin;
        localMessageForQQWalletTips.init((String)localObject, paramMsgType0x210, "", "[QQWallet Tips]", paramMsgInfo.getUMsgTime(), -2029, 0, paramMsgInfo.getShMsgSeq());
        localMessageForQQWalletTips.isread = true;
        localMessageForQQWalletTips.shmsgseq = paramMsgInfo.shMsgSeq;
        localMessageForQQWalletTips.msgUid = paramMsgInfo.lMsgUid;
        localMessageForQQWalletTips.getBytes();
        localMessageForQQWalletTips.onReceiveGrapTips();
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "0x85 push type: " + localMessageForQQWalletTips.type + ", subtype: " + localMessageForQQWalletTips.subType);
          QLog.d("Q.msg.BaseMessageProcessor", 2, "0x85 push jumpurl: " + localMessageForQQWalletTips.bytes_jumpurl);
        }
      }
      catch (Exception paramMsgInfo)
      {
        String str;
        paramMsgInfo.printStackTrace();
        continue;
        if (!paramMsgType0x210.equals(localMessageForQQWalletTips.reciverUin)) {
          continue;
        }
        paramMsgInfo = localMessageForQQWalletTips.reciverContent;
        continue;
      }
      if ((localMessageForQQWalletTips.type == 1) && (localMessageForQQWalletTips.subType == 0)) {
        break label515;
      }
      paramMsgInfo = localMessageForQQWalletTips;
      if (localMessageForQQWalletTips.type == 1)
      {
        paramMsgType0x210 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        paramMsgInfo = null;
        if (!paramMsgType0x210.equals(localMessageForQQWalletTips.senderUin)) {
          continue;
        }
        paramMsgInfo = localMessageForQQWalletTips.senderContent;
        paramMsgType0x210 = anni.a(2131706610);
        localObject = anni.a(2131706609);
        str = localMessageForQQWalletTips.getQQWalletTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgInfo);
        paramMsgInfo = localMessageForQQWalletTips;
        if (!TextUtils.isEmpty(str)) {
          if (!str.equals(paramMsgType0x210))
          {
            paramMsgInfo = localMessageForQQWalletTips;
            if (!str.equals(localObject)) {}
          }
          else
          {
            localMessageForQQWalletTips.addQQWalletTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, localMessageForQQWalletTips.highLightStart, localMessageForQQWalletTips.highLightEnd, localMessageForQQWalletTips.textColor, localMessageForQQWalletTips.url);
            paramMsgInfo = null;
          }
        }
      }
      return paramMsgInfo;
      paramMsgType0x210 = localMessageForQQWalletTips.senderUin;
    }
    label515:
    return null;
  }
  
  private void e(MsgType0x210 paramMsgType0x210)
  {
    ((abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(paramMsgType0x210.vProtobuf);
  }
  
  private void e(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    bdrm localbdrm = ((bdrb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(339)).a(4);
    QQAppInterface localQQAppInterface;
    byte[] arrayOfByte;
    long l1;
    long l2;
    if (localbdrm != null)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      arrayOfByte = paramMsgType0x210.vProtobuf;
      l1 = paramMsgInfo.shMsgSeq;
      l2 = paramMsgInfo.uRealMsgTime;
      if (paramMsgType0x210.uSubMsgType != 295L) {
        break label80;
      }
    }
    label80:
    for (boolean bool = false;; bool = true)
    {
      localbdrm.a(localQQAppInterface, arrayOfByte, l1, l2, bool);
      return;
    }
  }
  
  private void e(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x136");
    }
    Submsgtype0x136.MsgBody localMsgBody = new Submsgtype0x136.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      if (localMsgBody.uint32_msg_type.get() == 0) {
        ((anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(String.valueOf(localMsgBody.uint64_group_id.get()), 1, 0, null, 0);
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x136 " + paramArrayOfByte);
    }
  }
  
  private boolean e(MsgType0x210 paramMsgType0x210)
  {
    return paramMsgType0x210.uSubMsgType == 48L;
  }
  
  private void f(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b onlinepush");
    }
    Submsgtype0x8a.ReqBody localReqBody = new Submsgtype0x8a.ReqBody();
    try
    {
      localReqBody.mergeFrom(paramMsgType0x210.vProtobuf);
      bcap.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localReqBody, 0L, false);
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b online msg, prase reqBody error");
    }
  }
  
  private void f(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x11f");
    }
    avto.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210.vProtobuf, paramMsgInfo.shMsgSeq, paramMsgInfo.uRealMsgTime, false);
  }
  
  private void f(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessorQ.nearby.video_chat", 2, "handleMsgType0x210SuMsgType0xe4");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.nearbyVideoChatPush");
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      localIntent.putExtra("pushData", paramArrayOfByte);
      localIntent.setPackage(MobileQQ.getContext().getPackageName());
      NearbyVideoProxyBroadcastReceiver.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), localIntent);
    }
  }
  
  private boolean f(MsgType0x210 paramMsgType0x210)
  {
    return paramMsgType0x210.uSubMsgType == 39L;
  }
  
  private void g(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListSvrPush", 2, "<---receive shieldlist push : forward to shieldlisthandler");
    }
    ((anuv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(18)).a(paramMsgType0x210.vProtobuf);
  }
  
  private void g(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    SubMsgType0x27.MsgBody localMsgBody = new SubMsgType0x27.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      ((awhi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(284)).a(localMsgBody, paramMsgInfo.shMsgSeq, paramMsgInfo.lMsgUid);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramMsgInfo)
    {
      QLog.e("Q.msg.BaseMessageProcessor", 1, paramMsgInfo, new Object[0]);
    }
  }
  
  private void g(byte[] paramArrayOfByte)
  {
    Object localObject = new submsgtype0x116.MsgBody();
    try
    {
      ((submsgtype0x116.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      long l1 = lcr.a(((submsgtype0x116.MsgBody)localObject).uint32_group_id.get());
      long l2 = lcr.a(((submsgtype0x116.MsgBody)localObject).uint32_room_id.get());
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SuMsgType0x116 qqMainThread;roomId=" + l2 + ";groupId=" + l1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        localObject = new Intent("tencent.video.q2v.GvideoMemInviteUpdate");
        ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        ((Intent)localObject).putExtra("groupId", l1);
        ((Intent)localObject).putExtra("roomId", l2);
        ((Intent)localObject).putExtra("pushData", paramArrayOfByte);
        ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast((Intent)localObject);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
  
  private boolean g(MsgType0x210 paramMsgType0x210)
  {
    return paramMsgType0x210 == null;
  }
  
  private void h(MsgType0x210 paramMsgType0x210)
  {
    ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11)).a(paramMsgType0x210.uSubMsgType, paramMsgType0x210.vProtobuf);
  }
  
  private void h(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "handleC2COnlinePushMsg0x210Resp invoked. info: AIO story feed. msg0x210.uSubMsgType: " + paramMsgType0x210.uSubMsgType);
    }
    wfe localwfe = (wfe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(253);
    long l = paramMsgInfo.lFromUin;
    localwfe.a(localwfe.a(paramMsgType0x210.vProtobuf, String.valueOf(l)));
  }
  
  private void h(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    Object localObject;
    do
    {
      for (;;)
      {
        return;
        localObject = new submsgtype0x117.MsgBody();
        try
        {
          ((submsgtype0x117.MsgBody)localObject).mergeFrom(paramArrayOfByte);
          paramArrayOfByte = ((submsgtype0x117.MsgBody)localObject).rpt_uint32_moudle_id.get();
          l = ((submsgtype0x117.MsgBody)localObject).uint64_uin.get();
          if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SuMsgType0x117 音视频测试环境push,moudleIds==null || moudleIds.size()== 0");
          }
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          long l;
          for (;;)
          {
            paramArrayOfByte.printStackTrace();
          }
          localObject = new StringBuilder(anni.a(2131706611));
          ((StringBuilder)localObject).append(l);
          paramArrayOfByte = paramArrayOfByte.iterator();
          while (paramArrayOfByte.hasNext())
          {
            int i = ((Integer)paramArrayOfByte.next()).intValue();
            if (i == 92) {
              ((StringBuilder)localObject).append("|音视频");
            } else if (i == 93) {
              ((StringBuilder)localObject).append("|双人");
            } else if (i == 94) {
              ((StringBuilder)localObject).append("|多人");
            }
          }
          ((StringBuilder)localObject).append("】");
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SuMsgType0x117 音视频测试环境push" + ((StringBuilder)localObject).toString());
  }
  
  private boolean h(MsgType0x210 paramMsgType0x210)
  {
    return paramMsgType0x210.vProtobuf != null;
  }
  
  private void i(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x133");
    }
    aiug localaiug = (aiug)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(169);
    if (localaiug != null) {
      localaiug.a(paramMsgType0x210.vProtobuf);
    }
  }
  
  private void i(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.e("HotFriend_PushMessage", 2, "onLinePush receive 0x210_0xc7");
    }
    long l1 = paramMsgInfo.lFromUin;
    int i = paramMsgInfo.shMsgSeq;
    long l2 = paramMsgInfo.lMsgUid;
    int j = paramMsgInfo.shMsgType;
    int k = paramMsgInfo.uRealMsgTime;
    paramMsgInfo = new aofx(l1, i, l2, j, k, true);
    a(paramMsgType0x210.vProtobuf, paramMsgInfo);
    bbzf.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l1, i, l2, j);
  }
  
  private void i(byte[] paramArrayOfByte)
  {
    long l = bgva.a(paramArrayOfByte, 0);
    String str = String.valueOf(l);
    int i = paramArrayOfByte[5];
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg cOp = " + i);
    }
    int j;
    HotChatManager localHotChatManager;
    HotChatInfo localHotChatInfo;
    if (i == 3)
    {
      j = paramArrayOfByte[10];
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg dwGroupCode = " + l + ", cOp = " + i + ", cSubOp = " + j);
      }
      localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
      localHotChatInfo = localHotChatManager.a(String.valueOf(l));
      if (j == 3)
      {
        int k = paramArrayOfByte[11];
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg dwGroupCode = " + l + ", cOp = " + i + ", cSubOp = " + j + ", cSubOp2 = " + k);
        }
        switch (k)
        {
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                  } while (localHotChatInfo == null);
                  localHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED);
                  annq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692900), true);
                  anob.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 6);
                  ((anno)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).notifyUI(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED });
                  return;
                } while (localHotChatInfo == null);
                localHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT);
                annq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692880), true);
                anob.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 6);
                ((anno)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).notifyUI(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT });
                return;
              } while (localHotChatInfo == null);
              localHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT);
              annq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692881), true);
              anob.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 6);
              ((anno)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).notifyUI(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT });
              return;
              if (j != 2) {
                break;
              }
            } while (localHotChatInfo == null);
            localHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT__LONG_TIME_NOT_SAY);
            annq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692879), false);
            anob.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 6);
            ((anno)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).notifyUI(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_LEFT__LONG_TIME_NOT_SAY });
            return;
          } while (j != 1);
          paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        } while (paramArrayOfByte == null);
        paramArrayOfByte.a(l, false);
        return;
      } while (i != 1);
      j = paramArrayOfByte[10];
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg dwGroupCode = " + l + ", cOp = " + i + ", cSubOp = " + j);
      }
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    } while (paramArrayOfByte == null);
    switch (j)
    {
    default: 
      return;
    case 0: 
    case 2: 
      paramArrayOfByte.a(l, true);
      return;
    case 1: 
      paramArrayOfByte.b(l, false);
      return;
    }
    paramArrayOfByte.b(l, true);
  }
  
  private boolean i(MsgType0x210 paramMsgType0x210)
  {
    return paramMsgType0x210.uSubMsgType == 234L;
  }
  
  private void j(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive submsgtype0x128,or 0x137" + paramMsgType0x210.uSubMsgType);
    }
    for (;;)
    {
      try
      {
        submsgtype0x128.MsgBody localMsgBody = new submsgtype0x128.MsgBody();
        if (h(paramMsgType0x210))
        {
          localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
          asfs localasfs = (asfs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127);
          if (paramMsgType0x210.uSubMsgType == 296L)
          {
            bool = true;
            localasfs.a(localMsgBody, bool);
            QLog.d("Q.msg.BaseMessageProcessorExtendFriendLimitChat", 2, "SubMsgType0x27.ChatMatchInfo");
          }
        }
        else
        {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "submsgtype0x128 or 0x137 onLinePush vProto null   " + paramMsgType0x210.uSubMsgType);
          return;
        }
      }
      catch (Exception paramMsgType0x210)
      {
        QLog.e("Q.msg.BaseMessageProcessor", 1, "troopFormLog onLinePush receive submsgtype match chat0x128 decodeC2CMsgPkg_MsgType0x210 receive 0x128 push message, errInfo->" + paramMsgType0x210.getMessage());
        return;
      }
      boolean bool = false;
    }
  }
  
  private void j(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    SubMsgType0xae.MsgBody localMsgBody = new SubMsgType0xae.MsgBody();
    long l1;
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      Object localObject;
      if ((localMsgBody.uint32_type.has()) && (localMsgBody.uint32_type.get() == 2))
      {
        l1 = localMsgBody.msg_persons_may_know.fixed32_timestamp.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "handlePushRecommend receive push time=" + l1);
        }
        localObject = localMsgBody.msg_persons_may_know.rpt_msg_friend_list.get();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          paramMsgType0x210 = new ArrayList(((List)localObject).size());
          localObject = ((List)localObject).iterator();
        }
      }
      else
      {
        while (((Iterator)localObject).hasNext())
        {
          SubMsgType0xae.PersonMayKnow localPersonMayKnow = (SubMsgType0xae.PersonMayKnow)((Iterator)localObject).next();
          PushRecommend localPushRecommend = new PushRecommend();
          if (localPersonMayKnow.uint64_uin.has()) {
            localPushRecommend.uin = Long.toString(localPersonMayKnow.uint64_uin.get());
          }
          if (localPersonMayKnow.bytes_name.has()) {
            localPushRecommend.nick = new String(localPersonMayKnow.bytes_name.get().toByteArray());
          }
          if (localPersonMayKnow.uint32_age.has()) {
            localPushRecommend.age = ((short)localPersonMayKnow.uint32_age.get());
          }
          if (localPersonMayKnow.uint32_sex.has()) {
            localPushRecommend.gender = ((short)localPersonMayKnow.uint32_sex.get());
          }
          if (localPersonMayKnow.bytes_main_reason.has()) {
            localPushRecommend.recommendReason = new String(localPersonMayKnow.bytes_main_reason.get().toByteArray());
          }
          if (localPersonMayKnow.bytes_alghrithm.has()) {
            localPushRecommend.algBuffer = localPersonMayKnow.bytes_alghrithm.get().toByteArray();
          }
          if (localPersonMayKnow.bytes_soure_reason.has()) {
            localPushRecommend.sourceReason = new String(localPersonMayKnow.bytes_soure_reason.get().toByteArray());
          }
          if (localPersonMayKnow.uint32_source.has()) {
            localPushRecommend.fromSource = localPersonMayKnow.uint32_source.get();
          }
          if (localPersonMayKnow.msg_android_source.has())
          {
            SubMsgType0xae.AddFriendSource localAddFriendSource = (SubMsgType0xae.AddFriendSource)localPersonMayKnow.msg_android_source.get();
            if (localAddFriendSource != null)
            {
              if (localAddFriendSource.uint32_source.has()) {
                localPushRecommend.sourceId = localAddFriendSource.uint32_source.get();
              }
              if (localAddFriendSource.uint32_sub_source.has()) {
                localPushRecommend.subSourceId = localAddFriendSource.uint32_sub_source.get();
              }
            }
          }
          if (localPersonMayKnow.bytes_msg.has()) {
            localPushRecommend.wzryVerifyStr = new String(localPersonMayKnow.bytes_msg.get().toByteArray());
          }
          if (localPersonMayKnow.uint32_game_source.has()) {
            localPushRecommend.wzrySourceId = localPersonMayKnow.uint32_game_source.get();
          }
          if (localPersonMayKnow.bytes_role_name.has()) {
            localPushRecommend.wzryGameNick = new String(localPersonMayKnow.bytes_role_name.get().toByteArray());
          }
          localPushRecommend.timestamp = l1;
          paramMsgType0x210.add(localPushRecommend);
          continue;
          l1 = paramMsgInfo.lFromUin;
        }
      }
    }
    catch (Exception paramMsgType0x210)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PullActive", 2, "recv 0x210_0xae, prase msgBody error");
      }
    }
    for (;;)
    {
      int i = paramMsgInfo.shMsgSeq;
      long l2 = paramMsgInfo.lMsgUid;
      int j = paramMsgInfo.shMsgType;
      bbzf.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l1, i, l2, j);
      return;
      if (localMsgBody.msg_persons_may_know.bytes_role_name.has())
      {
        paramMsgType0x210 = localMsgBody.msg_persons_may_know.bytes_role_name.get().toStringUtf8();
        KplRoleInfo.saveGameNickWithUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramMsgType0x210);
      }
    }
  }
  
  private boolean j(MsgType0x210 paramMsgType0x210)
  {
    return (paramMsgType0x210.uSubMsgType == 36L) && (paramMsgType0x210.stMsgInfo0x24 != null);
  }
  
  private void k(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x11b");
    }
    try
    {
      submsgtype0x11b.MsgBody localMsgBody = new submsgtype0x11b.MsgBody();
      if (h(paramMsgType0x210))
      {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        awni.a().a(localMsgBody);
      }
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0x11b], errInfo->" + paramMsgType0x210.getMessage());
    }
  }
  
  private void k(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "OnLinePushMessageProcessor receive 0xdc push message");
    }
    amhd localamhd = (amhd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    if (localamhd != null) {
      localamhd.a(paramMsgType0x210.vProtobuf);
    }
    long l1 = paramMsgInfo.lFromUin;
    int i = paramMsgInfo.shMsgSeq;
    long l2 = paramMsgInfo.lMsgUid;
    int j = paramMsgInfo.shMsgType;
    bbzf.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l1, i, l2, j);
  }
  
  /* Error */
  private void l(MsgType0x210 paramMsgType0x210)
  {
    // Byte code:
    //   0: invokestatic 17	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 554
    //   9: iconst_2
    //   10: ldc_w 3173
    //   13: invokestatic 25	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: new 3175	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody
    //   19: dup
    //   20: invokespecial 3176	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:<init>	()V
    //   23: astore 4
    //   25: aload_0
    //   26: aload_1
    //   27: invokespecial 872	acwk:h	(LIMMsgBodyPack/MsgType0x210;)Z
    //   30: ifeq +222 -> 252
    //   33: aload 4
    //   35: aload_1
    //   36: getfield 46	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   39: invokevirtual 3177	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   42: pop
    //   43: aload 4
    //   45: getfield 3178	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   48: invokevirtual 654	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   51: ifeq +202 -> 253
    //   54: aload 4
    //   56: getfield 3178	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   59: invokevirtual 155	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   62: istore_2
    //   63: iload_2
    //   64: iconst_2
    //   65: if_icmpne +60 -> 125
    //   68: aload_0
    //   69: getfield 29	acwk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   72: invokevirtual 3181	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   75: aload 4
    //   77: invokevirtual 3186	com/tencent/av/gaudio/AVNotifyCenter:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody;)V
    //   80: ldc_w 394
    //   83: astore_1
    //   84: invokestatic 17	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +165 -> 252
    //   90: ldc_w 554
    //   93: iconst_2
    //   94: iconst_4
    //   95: anewarray 157	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: ldc_w 3188
    //   103: aastore
    //   104: dup
    //   105: iconst_1
    //   106: iload_2
    //   107: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   110: aastore
    //   111: dup
    //   112: iconst_2
    //   113: ldc_w 3190
    //   116: aastore
    //   117: dup
    //   118: iconst_3
    //   119: aload_1
    //   120: aastore
    //   121: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   124: return
    //   125: aload 4
    //   127: getfield 3193	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:str_msg_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   130: invokevirtual 1663	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   133: istore_3
    //   134: iload_3
    //   135: ifeq +110 -> 245
    //   138: aload 4
    //   140: getfield 3193	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:str_msg_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   143: invokevirtual 85	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   146: invokevirtual 2236	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   149: astore_1
    //   150: new 2683	android/os/Bundle
    //   153: dup
    //   154: invokespecial 3194	android/os/Bundle:<init>	()V
    //   157: astore 4
    //   159: aload 4
    //   161: ldc_w 3196
    //   164: iload_2
    //   165: invokevirtual 3199	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   168: aload 4
    //   170: ldc_w 3201
    //   173: aload_1
    //   174: invokevirtual 3203	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload_0
    //   178: getfield 29	acwk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   181: ldc_w 3205
    //   184: bipush 11
    //   186: iconst_1
    //   187: aload 4
    //   189: invokevirtual 3209	com/tencent/mobileqq/app/QQAppInterface:notifyObservers	(Ljava/lang/Class;IZLandroid/os/Bundle;)V
    //   192: goto -108 -> 84
    //   195: astore_1
    //   196: ldc_w 554
    //   199: iconst_1
    //   200: new 93	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 3211
    //   210: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_1
    //   214: invokevirtual 117	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   217: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 120	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: return
    //   227: astore_1
    //   228: invokestatic 17	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq +14 -> 245
    //   234: ldc_w 554
    //   237: iconst_2
    //   238: ldc_w 3213
    //   241: aload_1
    //   242: invokestatic 3215	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   245: ldc_w 394
    //   248: astore_1
    //   249: goto -99 -> 150
    //   252: return
    //   253: iconst_0
    //   254: istore_2
    //   255: goto -192 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	acwk
    //   0	258	1	paramMsgType0x210	MsgType0x210
    //   62	193	2	i	int
    //   133	2	3	bool	boolean
    //   23	165	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	63	195	java/lang/Exception
    //   68	80	195	java/lang/Exception
    //   84	124	195	java/lang/Exception
    //   125	134	195	java/lang/Exception
    //   138	150	195	java/lang/Exception
    //   150	192	195	java/lang/Exception
    //   228	245	195	java/lang/Exception
    //   138	150	227	java/lang/Throwable
  }
  
  private void l(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    ((aoom)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(62)).a(paramMsgType0x210.vProtobuf);
    long l1 = paramMsgInfo.lFromUin;
    int i = paramMsgInfo.shMsgSeq;
    long l2 = paramMsgInfo.lMsgUid;
    int j = paramMsgInfo.shMsgType;
    bbzf.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l1, i, l2, j);
  }
  
  private void m(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x11a");
    }
    try
    {
      submsgtype0x11a.MsgBody localMsgBody = new submsgtype0x11a.MsgBody();
      if (h(paramMsgType0x210))
      {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        awni.a().a(localMsgBody);
      }
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0x11a], errInfo->" + paramMsgType0x210.getMessage());
    }
  }
  
  private void m(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 4, "OnLinePushMessageProcessor receive 0x86 push message, seq = " + paramMsgInfo.shMsgSeq + "submsgtype:" + paramMsgInfo.shMsgType);
    }
    paramMsgInfo = new SubMsgType0x86.MsgBody();
    for (;;)
    {
      try
      {
        paramMsgInfo.mergeFrom(paramMsgType0x210.vProtobuf);
        if (paramMsgInfo != null)
        {
          if (paramMsgInfo.uint32_notify_flag.get() != 1) {
            continue;
          }
          bool = true;
          if (bool == true)
          {
            paramMsgInfo = new String(paramMsgInfo.bytes_notify_wording.get().toByteArray(), "utf-8");
            azwe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool, paramMsgInfo);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, paramMsgInfo);
          }
        }
        return;
      }
      catch (Exception paramMsgInfo)
      {
        boolean bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.msg.BaseMessageProcessor", 2, "parse 0x86 push msg error", paramMsgInfo);
      }
      bool = false;
    }
  }
  
  private void n(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x120,");
    }
    try
    {
      SubMsgType0x120.MsgBody localMsgBody = new SubMsgType0x120.MsgBody();
      if (h(paramMsgType0x210))
      {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMsgBody);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x120, handle0x210_0x120push");
        }
      }
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0x120], errInfo->" + paramMsgType0x210.getMessage());
    }
  }
  
  private void n(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("UndealCount.ZebraAlbum.Q.msg.BaseMessageProcessor", 4, "OnLinePushMessageProcessor receive zebarunread push message, seq = " + paramMsgInfo.shMsgSeq + "submsgtype:" + paramMsgInfo.shMsgType);
    }
    try
    {
      paramMsgInfo = new submsgtype0x79.MsgBody();
      paramMsgInfo.mergeFrom(paramMsgType0x210.vProtobuf);
      paramMsgInfo.uint32_src_app_id.get();
      int i = paramMsgInfo.uint32_undeal_count.get();
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.ZebraAlbum.Q.msg.BaseMessageProcessor", 2, "OnLinePushMessageProcessor receive zebarunread count: " + i);
      }
      int j = LocalMultiProcConfig.getInt4Uin("NavigatorItemShow7", -1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "account: " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin() + " QZoneGetFeedAlertRequest read NavigatorItemShow 7 from sharerefrence value: " + j);
      }
      if (j == 1)
      {
        paramMsgInfo = (bccv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
        paramMsgType0x210 = new ArrayList();
        QZoneCountUserInfo localQZoneCountUserInfo = new QZoneCountUserInfo();
        localQZoneCountUserInfo.a = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
        paramMsgType0x210.add(localQZoneCountUserInfo);
        paramMsgInfo.a(17, i, paramMsgType0x210, "", false, true, "");
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramMsgInfo)
    {
      paramMsgInfo.printStackTrace();
    }
  }
  
  private void o(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x115, [S2C push for input status]");
    }
    try
    {
      Object localObject = new SubMsgType0x115.MsgBody();
      if (h(paramMsgType0x210))
      {
        ((SubMsgType0x115.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
        long l1 = ((SubMsgType0x115.MsgBody)localObject).uint64_from_uin.get();
        long l2 = ((SubMsgType0x115.MsgBody)localObject).uint64_to_uin.get();
        paramMsgType0x210 = (SubMsgType0x115.NotifyItem)((SubMsgType0x115.MsgBody)localObject).msg_notify_item.get();
        int i = paramMsgType0x210.uint32_timeout_s.get();
        int j = paramMsgType0x210.uint32_event_type.get();
        int k = paramMsgType0x210.uint32_interval.get();
        long l3 = paramMsgType0x210.uint64_timestamp.get();
        paramMsgType0x210 = paramMsgType0x210.bytes_wording.get().toStringUtf8();
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(316);
        if ((localObject instanceof avgm)) {
          ((avgm)localObject).a(l1, l2, l3, k, i, j, paramMsgType0x210);
        }
      }
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0x115], errInfo->" + paramMsgType0x210.getMessage());
    }
  }
  
  private void o(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    anyr localanyr = (anyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(85);
    if (!localanyr.a(paramMsgInfo.shMsgSeq)) {
      paramMsgInfo = new submsgtype0x118.MsgBody();
    }
    while (!QLog.isColorLevel()) {
      try
      {
        paramMsgInfo.mergeFrom(paramMsgType0x210.vProtobuf);
        paramMsgType0x210 = ((submsgtype0x118.SystemNotify)paramMsgInfo.msg_system_notify.get()).bytes_msg_title.get().toStringUtf8();
        paramMsgInfo = new JSONObject(paramMsgInfo.bytes_push_data.get().toStringUtf8());
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "-----qq reminder-----title: " + paramMsgType0x210 + "---msgId: " + paramMsgInfo.optString("msg_id") + "---notice_time: " + paramMsgInfo.optLong("notice_time"));
        }
        localanyr.a(paramMsgType0x210, paramMsgInfo.optString("msg_id"), paramMsgInfo.optLong("notice_time"));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "do report: QQnotice.list.push");
        }
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "QQnotice", "", "", "QQnotice.list.push", 0, 0, "", "", paramMsgInfo.optString("msg_id"), "");
        return;
      }
      catch (Exception paramMsgInfo)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("QQReminder", 2, "parse push got error.", paramMsgInfo);
        return;
      }
    }
    QLog.d("Q.msg.BaseMessageProcessor", 2, "receive same message, seq = " + paramMsgInfo.shMsgSeq);
  }
  
  private void p(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x11e");
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    if (localFriendListHandler != null) {
      localFriendListHandler.a(paramMsgType0x210.vProtobuf);
    }
  }
  
  private void p(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("msg0x210.SubMsgType0x6f", 2, "get notice from handleC2COnlinePushMsg0x210Resp");
    }
    int j;
    Object localObject1;
    int k;
    label505:
    int m;
    label526:
    int n;
    try
    {
      SubMsgType0x6f.MsgBody localMsgBody = new SubMsgType0x6f.MsgBody();
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      int i = 0;
      for (;;)
      {
        if (i >= localMsgBody.rpt_msg_mod_infos.size()) {
          break label847;
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
        l1 = 0L;
        k = 0;
        j = 0;
        if (((SubMsgType0x6f.MCardNotificationLike)localObject1).str_wording.has()) {
          paramMsgType0x210 = ((SubMsgType0x6f.MCardNotificationLike)localObject1).str_wording.get();
        }
        if (((SubMsgType0x6f.MCardNotificationLike)localObject1).uint32_counter_new.has()) {
          j = ((SubMsgType0x6f.MCardNotificationLike)localObject1).uint32_counter_new.get();
        }
        if (((SubMsgType0x6f.MCardNotificationLike)localObject1).uint64_from_uin.has()) {
          l1 = ((SubMsgType0x6f.MCardNotificationLike)localObject1).uint64_from_uin.get();
        }
        if (((SubMsgType0x6f.MCardNotificationLike)localObject1).uint32_counter_total.has()) {
          k = ((SubMsgType0x6f.MCardNotificationLike)localObject1).uint32_counter_total.get();
        }
        if (QLog.isColorLevel()) {
          QLog.d("msg0x210.SubMsgType0x6f", 2, "card_notification_like : wording: " + paramMsgType0x210 + " totalCount: " + k + " newCount: " + j + " fromUin: " + l1);
        }
        paramMsgType0x210 = (arku)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(71);
        if (paramMsgType0x210 != null) {
          paramMsgType0x210.a().a((SubMsgType0x6f.MCardNotificationLike)localObject1);
        }
        l1 = paramMsgInfo.lFromUin;
        j = paramMsgInfo.shMsgSeq;
        long l2 = paramMsgInfo.lMsgUid;
        k = paramMsgInfo.shMsgType;
        bbzf.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l1, j, l2, k);
        i += 1;
      }
      if ((j != 2002) || (!paramMsgType0x210.msg_vip_info_notify.has())) {
        break label848;
      }
      localObject1 = (SubMsgType0x6f.VipInfoNotify)paramMsgType0x210.msg_vip_info_notify.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "vip info notify: " + localObject1.toString());
      }
      long l1 = 0L;
      if (((SubMsgType0x6f.VipInfoNotify)localObject1).uint64_uin.has()) {
        l1 = ((SubMsgType0x6f.VipInfoNotify)localObject1).uint64_uin.get();
      }
      paramMsgType0x210 = Long.toString(l1);
      if (!((SubMsgType0x6f.VipInfoNotify)localObject1).uint32_vip_identify.has()) {
        break label1629;
      }
      j = ((SubMsgType0x6f.VipInfoNotify)localObject1).uint32_vip_identify.get();
      if (!((SubMsgType0x6f.VipInfoNotify)localObject1).uint32_vip_level.has()) {
        break label1623;
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
        break label1635;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, "iRedPacketId = " + i1 + ";redText = " + (String)localObject1);
    }
    catch (Exception paramMsgInfo)
    {
      int i1;
      label642:
      if (!QLog.isColorLevel()) {
        break label847;
      }
      QLog.d("msg0x210.SubMsgType0x6f", 2, "exception : " + paramMsgInfo);
    }
    Object localObject2 = (anom)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131);
    ((anom)localObject2).a(m, n, true);
    ((anom)localObject2).a(i1, (String)localObject1);
    label676:
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "UIN " + paramMsgType0x210 + " vip info changed.");
    }
    for (;;)
    {
      label718:
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "need pull vip info from svr. vipIdentiy=" + j + "; vipLevel=" + k);
      }
      localObject1 = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(paramMsgType0x210);
      ((anyj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(27)).a((String)localObject1, paramMsgType0x210);
      label847:
      label848:
      label1623:
      label1629:
      label1635:
      do
      {
        bhdd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
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
          ((abqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(111, (Bundle)localObject1);
          break;
        }
        if ((j == 2007) && (paramMsgType0x210.msg_babyq_reward_info.has()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "receive msg_babyq_reward_info...");
          }
          ((anhp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a(paramMsgType0x210);
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
          ((QIMFollwerAdd)localObject1).upTime = bbyp.a();
          ((QIMFollwerAdd)localObject1).source = paramMsgType0x210.bytes_src_wording.get().toStringUtf8();
          ((aiyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b((QIMFollwerAdd)localObject1);
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
        ((QIMNotifyAddFriend)localObject1).pushTime = bbyp.a();
        if (QLog.isColorLevel()) {
          QLog.d("QIMNewNotifyPush", 2, "receive data= " + ((QIMNotifyAddFriend)localObject1).toString());
        }
        ((ansb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(257)).a((QIMNotifyAddFriend)localObject1);
        break;
        k = 0;
        break label526;
        j = 0;
        break label505;
        if (m >= 0) {
          break label642;
        }
        if (n < 0) {
          break label676;
        }
        break label642;
        if (j != 0) {
          break label718;
        }
      } while (k == 0);
    }
  }
  
  private void q(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x111");
    }
    anpk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210.vProtobuf);
  }
  
  /* Error */
  private void q(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    // Byte code:
    //   0: invokestatic 17	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 3742
    //   9: iconst_2
    //   10: ldc_w 3400
    //   13: invokestatic 25	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: invokestatic 17	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +13 -> 32
    //   22: ldc_w 3744
    //   25: iconst_2
    //   26: ldc_w 3746
    //   29: invokestatic 25	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: new 3748	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody
    //   35: dup
    //   36: invokespecial 3749	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:<init>	()V
    //   39: astore 12
    //   41: aload 12
    //   43: aload_2
    //   44: getfield 46	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   47: invokevirtual 3750	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   50: pop
    //   51: aload 12
    //   53: getfield 3751	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:uint64_to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   56: invokevirtual 282	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   59: lstore 5
    //   61: aload_0
    //   62: getfield 29	acwk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   65: invokevirtual 1606	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   68: astore_2
    //   69: invokestatic 3756	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   72: lload 5
    //   74: invokestatic 2381	java/lang/Long:toString	(J)Ljava/lang/String;
    //   77: aconst_null
    //   78: ldc_w 3758
    //   81: iconst_0
    //   82: invokestatic 3764	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:readValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   85: ifne +324 -> 409
    //   88: lload 5
    //   90: invokestatic 2381	java/lang/Long:toString	(J)Ljava/lang/String;
    //   93: aload_2
    //   94: invokevirtual 609	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: istore 9
    //   99: iload 9
    //   101: ifeq +308 -> 409
    //   104: aconst_null
    //   105: astore_2
    //   106: aconst_null
    //   107: astore 10
    //   109: aconst_null
    //   110: astore 14
    //   112: aload 12
    //   114: getfield 3767	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_tips_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   117: invokevirtual 1663	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   120: ifeq +330 -> 450
    //   123: new 310	java/lang/String
    //   126: dup
    //   127: aload 12
    //   129: getfield 3767	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_tips_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   132: invokevirtual 85	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   135: invokevirtual 91	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   138: ldc_w 967
    //   141: invokespecial 1914	java/lang/String:<init>	([BLjava/lang/String;)V
    //   144: astore 11
    //   146: aload 11
    //   148: astore_2
    //   149: aload 12
    //   151: getfield 3770	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_yes_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   154: invokevirtual 1663	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   157: ifeq +287 -> 444
    //   160: new 310	java/lang/String
    //   163: dup
    //   164: aload 12
    //   166: getfield 3770	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_yes_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   169: invokevirtual 85	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   172: invokevirtual 91	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   175: ldc_w 967
    //   178: invokespecial 1914	java/lang/String:<init>	([BLjava/lang/String;)V
    //   181: astore 11
    //   183: aload 11
    //   185: astore 10
    //   187: aload 12
    //   189: getfield 3773	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_no_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   192: invokevirtual 1663	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   195: ifeq +243 -> 438
    //   198: new 310	java/lang/String
    //   201: dup
    //   202: aload 12
    //   204: getfield 3773	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_no_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   207: invokevirtual 85	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   210: invokevirtual 91	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   213: ldc_w 967
    //   216: invokespecial 1914	java/lang/String:<init>	([BLjava/lang/String;)V
    //   219: astore 11
    //   221: aload 11
    //   223: astore 12
    //   225: aload_2
    //   226: astore 11
    //   228: aload 10
    //   230: astore 13
    //   232: invokestatic 3756	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   235: lload 5
    //   237: invokestatic 2381	java/lang/Long:toString	(J)Ljava/lang/String;
    //   240: aload 11
    //   242: aload 12
    //   244: aload 13
    //   246: invokevirtual 3777	com/tencent/common/app/BaseApplicationImpl:setPCActiveNotice	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   249: aload_0
    //   250: sipush 8013
    //   253: iconst_1
    //   254: iconst_4
    //   255: anewarray 157	java/lang/Object
    //   258: dup
    //   259: iconst_0
    //   260: lload 5
    //   262: invokestatic 2381	java/lang/Long:toString	(J)Ljava/lang/String;
    //   265: aastore
    //   266: dup
    //   267: iconst_1
    //   268: aload 11
    //   270: aastore
    //   271: dup
    //   272: iconst_2
    //   273: aload 12
    //   275: aastore
    //   276: dup
    //   277: iconst_3
    //   278: aload 13
    //   280: aastore
    //   281: invokevirtual 835	acwk:a	(IZLjava/lang/Object;)V
    //   284: aload_1
    //   285: getfield 1333	OnlinePushPack/MsgInfo:lFromUin	J
    //   288: lstore 5
    //   290: aload_1
    //   291: getfield 1191	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   294: istore_3
    //   295: aload_1
    //   296: getfield 1336	OnlinePushPack/MsgInfo:lMsgUid	J
    //   299: lstore 7
    //   301: aload_1
    //   302: getfield 1194	OnlinePushPack/MsgInfo:shMsgType	S
    //   305: istore 4
    //   307: aload_0
    //   308: getfield 701	acwk:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   311: lload 5
    //   313: iload_3
    //   314: lload 7
    //   316: iload 4
    //   318: invokestatic 1341	bbzf:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   321: return
    //   322: astore 11
    //   324: aload 10
    //   326: astore 13
    //   328: aload 14
    //   330: astore 12
    //   332: aload_2
    //   333: astore 11
    //   335: invokestatic 17	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   338: ifeq -106 -> 232
    //   341: ldc_w 3742
    //   344: iconst_2
    //   345: ldc_w 3779
    //   348: invokestatic 25	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: aload 10
    //   353: astore 13
    //   355: aload 14
    //   357: astore 12
    //   359: aload_2
    //   360: astore 11
    //   362: goto -130 -> 232
    //   365: astore_2
    //   366: aload_2
    //   367: invokevirtual 947	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   370: aload_0
    //   371: sipush 8013
    //   374: iconst_0
    //   375: iconst_4
    //   376: anewarray 157	java/lang/Object
    //   379: dup
    //   380: iconst_0
    //   381: ldc_w 394
    //   384: aastore
    //   385: dup
    //   386: iconst_1
    //   387: ldc_w 394
    //   390: aastore
    //   391: dup
    //   392: iconst_2
    //   393: ldc_w 394
    //   396: aastore
    //   397: dup
    //   398: iconst_3
    //   399: ldc_w 394
    //   402: aastore
    //   403: invokevirtual 835	acwk:a	(IZLjava/lang/Object;)V
    //   406: goto -122 -> 284
    //   409: invokestatic 17	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   412: ifeq -128 -> 284
    //   415: ldc_w 3742
    //   418: iconst_2
    //   419: ldc_w 3781
    //   422: invokestatic 25	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: goto -141 -> 284
    //   428: astore 11
    //   430: goto -106 -> 324
    //   433: astore 11
    //   435: goto -111 -> 324
    //   438: aconst_null
    //   439: astore 11
    //   441: goto -220 -> 221
    //   444: aconst_null
    //   445: astore 10
    //   447: goto -260 -> 187
    //   450: aconst_null
    //   451: astore_2
    //   452: goto -303 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	455	0	this	acwk
    //   0	455	1	paramMsgInfo	MsgInfo
    //   0	455	2	paramMsgType0x210	MsgType0x210
    //   294	20	3	i	int
    //   305	12	4	j	int
    //   59	253	5	l1	long
    //   299	16	7	l2	long
    //   97	3	9	bool	boolean
    //   107	339	10	localObject1	Object
    //   144	125	11	localObject2	Object
    //   322	1	11	localException1	Exception
    //   333	28	11	localMsgType0x210	MsgType0x210
    //   428	1	11	localException2	Exception
    //   433	1	11	localException3	Exception
    //   439	1	11	localObject3	Object
    //   39	319	12	localObject4	Object
    //   230	124	13	localObject5	Object
    //   110	246	14	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   112	146	322	java/lang/Exception
    //   16	32	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   32	99	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   112	146	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   149	183	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   187	221	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   232	284	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   335	351	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   409	425	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   149	183	428	java/lang/Exception
    //   187	221	433	java/lang/Exception
  }
  
  private void r(MsgType0x210 paramMsgType0x210)
  {
    submsgtype0x104.MsgBody localMsgBody = new submsgtype0x104.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(localMsgBody);
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x104 wrong:" + paramMsgType0x210.toString());
    }
  }
  
  private void r(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "get notice from handleC2COnlinePushMsg0x210Resp");
    }
    bcbb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210.vProtobuf);
    long l1 = paramMsgInfo.lFromUin;
    int i = paramMsgInfo.shMsgSeq;
    long l2 = paramMsgInfo.lMsgUid;
    int j = paramMsgInfo.shMsgType;
    bbzf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), l1, i, l2, j);
  }
  
  private void s(MsgType0x210 paramMsgType0x210)
  {
    submsgtype0x103.MsgBody localMsgBody = new submsgtype0x103.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(localMsgBody);
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x103 wrong:" + paramMsgType0x210.toString());
    }
  }
  
  private void s(MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    byte[] arrayOfByte = null;
    if (QLog.isColorLevel()) {
      QLog.d("DevLock", 2, "recv msg0x210.Submsgtype0x51");
    }
    new SubMsgType0x51.MsgBody();
    try
    {
      SubMsgType0x51.MsgBody localMsgBody = new SubMsgType0x51.MsgBody();
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      if (localMsgBody.bytes_qrsig_url.has())
      {
        paramMsgType0x210 = new String(localMsgBody.bytes_qrsig_url.get().toByteArray(), "utf-8");
        if (localMsgBody.bytes_hint1.has())
        {
          str1 = new String(localMsgBody.bytes_hint1.get().toByteArray(), "utf-8");
          if (localMsgBody.bytes_hint2.has())
          {
            str2 = new String(localMsgBody.bytes_hint2.get().toByteArray(), "utf-8");
            if (localMsgBody.bytes_login_conf.has()) {
              arrayOfByte = localMsgBody.bytes_login_conf.get().toByteArray();
            }
            if (QLog.isColorLevel()) {
              QLog.d("DevLock", 2, "recv devlock quicklogin push qrcode=" + paramMsgType0x210 + " maintip=" + str1 + " smalltip" + str2);
            }
            asfr.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210, str1, str2, arrayOfByte);
            long l1 = paramMsgInfo.lFromUin;
            int i = paramMsgInfo.shMsgSeq;
            long l2 = paramMsgInfo.lMsgUid;
            int j = paramMsgInfo.shMsgType;
            bbzf.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l1, i, l2, j);
            return;
          }
        }
      }
    }
    catch (Exception paramMsgType0x210)
    {
      for (;;)
      {
        String str1;
        String str2;
        if (QLog.isColorLevel())
        {
          QLog.d("DevLock", 2, "failed to parse msg0x210.Submsgtype0x51");
          continue;
          str2 = null;
          continue;
          str1 = null;
          continue;
          paramMsgType0x210 = null;
        }
      }
    }
  }
  
  private void t(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xfb");
    }
    try
    {
      Object localObject = new NowPushMsgList.MsgBody();
      if (h(paramMsgType0x210))
      {
        ((NowPushMsgList.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
        paramMsgType0x210 = ((NowPushMsgList.MsgBody)localObject).rpt_now_push_msg.get().iterator();
        while (paramMsgType0x210.hasNext())
        {
          localObject = (NowPushMsgList.NowPushMsg)paramMsgType0x210.next();
          ((aycq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(266)).a((NowPushMsgList.NowPushMsg)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xfb " + ((NowPushMsgList.NowPushMsg)localObject).uint32_switch.get() + "  uint32_task_id " + ((NowPushMsgList.NowPushMsg)localObject).uint32_task_id.get() + "  uint32_type " + ((NowPushMsgList.NowPushMsg)localObject).uint32_type.get() + "  uint64_start_time " + ((NowPushMsgList.NowPushMsg)localObject).uint64_start_time.get() + "  uint64_end_time " + ((NowPushMsgList.NowPushMsg)localObject).uint64_end_time.get());
          }
        }
      }
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0xfb], errInfo->" + paramMsgType0x210.getMessage());
    }
  }
  
  private void u(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x10b");
    }
    wsm localwsm = (wsm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252);
    try
    {
      qqstory_service.MsgTabNodePushNotify localMsgTabNodePushNotify = new qqstory_service.MsgTabNodePushNotify();
      localMsgTabNodePushNotify.mergeFrom(paramMsgType0x210.vProtobuf);
      paramMsgType0x210 = (wsl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251);
      if (localwsm.jdField_a_of_type_Boolean) {
        paramMsgType0x210.a().a(localMsgTabNodePushNotify);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramMsgType0x210)
    {
      QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0xf3], errInfo->" + paramMsgType0x210.getMessage());
    }
  }
  
  private void v(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xef, [linkstar push test]");
    }
    int i = paramMsgType0x210.vProtobuf.length;
    if (i < 6) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xef, [linkstar push test]. vProtoBuf.length is " + i);
    }
    int j;
    byte[] arrayOfByte1;
    do
    {
      return;
      j = (paramMsgType0x210.vProtobuf[0] << 4) + paramMsgType0x210.vProtobuf[1];
      arrayOfByte1 = new byte[4];
      System.arraycopy(paramMsgType0x210.vProtobuf, 2, arrayOfByte1, 0, 4);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xef, [linkstar push test]. msgType=" + j);
      }
      ThreadManager.getUIHandler().post(new OnLinePushMessageProcessor.1(this, j));
    } while (i <= 6);
    byte[] arrayOfByte2 = new byte[i - 6];
    System.arraycopy(paramMsgType0x210.vProtobuf, 6, arrayOfByte2, 0, i - 6);
    aopv.a(j, arrayOfByte1, arrayOfByte2);
  }
  
  private void w(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xeb");
    }
    try
    {
      submsgtype0xeb.MsgBody localMsgBody = new submsgtype0xeb.MsgBody();
      if (h(paramMsgType0x210)) {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      }
      anyr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMsgBody);
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0xeb], errInfo->" + paramMsgType0x210.getMessage());
    }
  }
  
  private void x(MsgType0x210 paramMsgType0x210)
  {
    QLog.d("ApolloPushManager", 1, "recv action push message 0x210_0xe8, [C2C.OnlinePush]");
    try
    {
      Object localObject = new submsgtype0xe8.MsgBody();
      ((submsgtype0xe8.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
      if (((submsgtype0xe8.MsgBody)localObject).msg_item.has())
      {
        paramMsgType0x210 = (apollo_push_msgInfo.STPushMsgElem)((submsgtype0xe8.MsgBody)localObject).msg_item.get();
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          localObject = (amhy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(227);
          ((amhy)localObject).a(0, paramMsgType0x210);
          ((amhy)localObject).c(paramMsgType0x210);
          ((amhy)localObject).b(paramMsgType0x210);
          ((amhy)localObject).a(paramMsgType0x210);
        }
      }
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      paramMsgType0x210.printStackTrace();
      QLog.e("ApolloPushManager", 1, "[msg0x210.uSubMsgType == 0xe8], errInfo->" + paramMsgType0x210.getMessage());
    }
  }
  
  private void y(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAV.push", 2, "onLinePush receive 0x210_0xdb");
    }
    try
    {
      submsgtype0xdb.MsgBody localMsgBody = new submsgtype0xdb.MsgBody();
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMsgBody);
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QAV.push", 2, "onLinePush 0x210_0xdb push exception : ", paramMsgType0x210);
    }
  }
  
  private void z(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAV.Random.push", 2, "[1v1] onLinePush receive 0x210_0xcf");
    }
    try
    {
      submsgtype0xcf.MsgBody localMsgBody = new submsgtype0xcf.MsgBody();
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMsgBody);
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QAV.Random.push", 2, "[1v1] onLinePush 0x210_0xcf push exception", paramMsgType0x210);
    }
  }
  
  protected long a(submsgtype0x26.MsgBody paramMsgBody)
  {
    long l2 = 0L;
    long l1 = l2;
    Object localObject1;
    int i;
    if (paramMsgBody.uint32_sub_cmd.get() == 1)
    {
      l1 = l2;
      if (paramMsgBody.rpt_msg_subcmd_0x1_push_body.has())
      {
        localObject1 = paramMsgBody.rpt_msg_subcmd_0x1_push_body.get();
        l1 = 0L;
        i = 0;
        while (i < ((List)localObject1).size())
        {
          Object localObject2 = (submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)((List)localObject1).get(i);
          if (((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject2).msg_app_id.uint64_app_id.get() == 101846662L)
          {
            l2 = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject2).uint64_group_code.get();
            localObject2 = (bfkr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(355);
            l1 = l2;
            if (localObject2 != null)
            {
              ((bfkr)localObject2).a(l2);
              l1 = l2;
            }
          }
          i += 1;
        }
      }
    }
    l2 = l1;
    if (paramMsgBody.uint32_sub_cmd.get() == 1)
    {
      l2 = l1;
      if (paramMsgBody.rpt_msg_subcmd_0x1_push_body.has())
      {
        paramMsgBody = paramMsgBody.rpt_msg_subcmd_0x1_push_body.get();
        i = 0;
        for (;;)
        {
          l2 = l1;
          if (i >= paramMsgBody.size()) {
            break;
          }
          localObject1 = (submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)paramMsgBody.get(i);
          l1 = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject1).uint64_group_code.get();
          l2 = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject1).msg_app_id.uint64_app_id.get();
          int j = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject1).sint32_unread_num.get();
          localObject1 = (bfkr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(355);
          if (localObject1 != null) {
            ((bfkr)localObject1).a(l1, l2, j);
          }
          i += 1;
        }
      }
    }
    return l2;
  }
  
  public String a(byte[] paramArrayOfByte)
  {
    String str = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 parse start");
    }
    SubMsgType0xb3.PushAddFrdNotify localPushAddFrdNotify;
    int i;
    int j;
    long l1;
    MessageHandler localMessageHandler;
    for (;;)
    {
      try
      {
        paramArrayOfByte = (SubMsgType0xb3.MsgBody)new SubMsgType0xb3.MsgBody().mergeFrom(paramArrayOfByte);
        if (paramArrayOfByte == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 | msgBody is null.");
          }
          return null;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 parse failed.", paramArrayOfByte);
        }
        paramArrayOfByte = null;
        continue;
        if (!paramArrayOfByte.msg_add_frd_notify.has())
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 | msg_add_frd_notify is null.");
          return null;
        }
        localPushAddFrdNotify = (SubMsgType0xb3.PushAddFrdNotify)paramArrayOfByte.msg_add_frd_notify.get();
        i = localPushAddFrdNotify.uint32_source_id.get();
        j = localPushAddFrdNotify.uint32_subsource_id.get();
        if (!localPushAddFrdNotify.uint64_req_uin.has()) {
          break;
        }
      }
      l1 = localPushAddFrdNotify.uint64_req_uin.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorQ.nearby.follow", 2, "decodeC2CMsgPkgSubMsgType0xb3, sourceid:" + i + "|subSourceid:" + j + " |reqUin: " + l1);
      }
      if ((i != 3076) && (i != 3077) && (i != 2076) && (i != 2077) && (i != 10012) && (i != 10013))
      {
        boolean bool = bqkd.a(i);
        localMessageHandler = (MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
        if (!bool) {
          break label415;
        }
        if (!localPushAddFrdNotify.bytes_mobile.has()) {
          break label402;
        }
        paramArrayOfByte = localPushAddFrdNotify.bytes_mobile.get().toStringUtf8();
      }
    }
    for (;;)
    {
      label301:
      long l3 = localPushAddFrdNotify.uint64_fuin.get();
      if (localPushAddFrdNotify.uint64_fuin_bubble_id.has()) {}
      for (long l2 = localPushAddFrdNotify.uint64_fuin_bubble_id.get();; l2 = -1L)
      {
        if (localPushAddFrdNotify.bytes_wording.has()) {
          str = localPushAddFrdNotify.bytes_wording.get().toStringUtf8();
        }
        localMessageHandler.a(String.valueOf(l3), paramArrayOfByte, l2, str, localPushAddFrdNotify.fixed32_timestamp.get(), i, j, l1);
        return String.valueOf(localPushAddFrdNotify.uint64_fuin.get());
        l1 = 0L;
        break;
        label402:
        paramArrayOfByte = null;
        break label301;
      }
      label415:
      paramArrayOfByte = null;
    }
  }
  
  public void a(int paramInt)
  {
    ((anuk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramInt);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (SvcReqPushMsg)paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 parse start");
    }
    int n = 0;
    int m = 0;
    try
    {
      paramArrayOfByte = (submsgtype0x44.MsgBody)new submsgtype0x44.MsgBody().mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 parse failed.", paramArrayOfByte);
        }
        paramArrayOfByte = null;
      }
      if (QLog.isColorLevel())
      {
        if ((paramArrayOfByte.msg_friend_msg_sync.has()) && (paramArrayOfByte.msg_friend_msg_sync.get() != null)) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_friend_msg_sync processflag=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processflag.get() + ";processtype=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processtype.get() + ";fuin" + paramArrayOfByte.msg_friend_msg_sync.uint64_fuin.get());
        }
        if ((paramArrayOfByte.msg_group_msg_sync.has()) && (paramArrayOfByte.msg_group_msg_sync.get() != null)) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_group_msg_sync processflag=" + paramArrayOfByte.msg_group_msg_sync.uint32_processflag.get() + ";processtype=" + paramArrayOfByte.msg_group_msg_sync.uint32_msg_type.get() + ";grp_code=" + paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get());
        }
        if ((paramArrayOfByte.msg_clean_count_msg.has()) && (paramArrayOfByte.msg_clean_count_msg.get() != null)) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_clean_count_msg processflag=" + paramArrayOfByte.msg_clean_count_msg.uint32_processflag.get());
        }
      }
      if (!paramArrayOfByte.msg_friend_msg_sync.has()) {
        break label1315;
      }
    }
    int i;
    label355:
    Object localObject2;
    Object localObject1;
    if (paramArrayOfByte.msg_friend_msg_sync.get() != null) {
      if (a(paramArrayOfByte.msg_friend_msg_sync.uint32_processflag.get()))
      {
        i = 1;
        if (c(paramArrayOfByte.msg_friend_msg_sync.uint32_processtype.get()))
        {
          localObject2 = String.valueOf(paramArrayOfByte.msg_friend_msg_sync.uint64_fuin.get());
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (bgsp.c((String)localObject2)))
          {
            localObject1 = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
            j = paramArrayOfByte.msg_friend_msg_sync.uint32_sourceid.get();
            localObject2 = String.valueOf(localObject2);
            if (!((FriendListHandler)localObject1).a((String)localObject2, 0, j, null, false, false, -1L)) {
              ((FriendListHandler)localObject1).a((String)localObject2);
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_friend_msg_sync uint32_processflag=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processflag.get() + ";uint32_processtype=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processtype.get());
        }
      }
    }
    label1315:
    for (int j = i;; j = 0)
    {
      int k = n;
      if (paramArrayOfByte.msg_group_msg_sync.has())
      {
        k = n;
        if (paramArrayOfByte.msg_group_msg_sync.get() != null)
        {
          i = m;
          if (a(paramArrayOfByte.msg_group_msg_sync.uint32_processflag.get())) {
            i = 1;
          }
          if (b(paramArrayOfByte.msg_group_msg_sync.uint32_msg_type.get()))
          {
            localObject1 = String.valueOf(paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get());
            Object localObject3 = bdgo.a(paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get());
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (bgsp.c((String)localObject1)))
            {
              TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
              if (localTroopManager.b((String)localObject1) == null)
              {
                localObject2 = new TroopInfo();
                ((TroopInfo)localObject2).troopuin = ((String)localObject1);
                ((TroopInfo)localObject2).troopcode = ((String)localObject3);
                localTroopManager.a((TroopInfo)localObject2);
                localObject3 = (anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
                ((anwd)localObject3).a(((TroopInfo)localObject2).troopuin, false, "", true, true, true, false);
                ((anwd)localObject3).a(1, anie.a(((TroopInfo)localObject2).troopuin), 0L, 2, 0, 0, true);
                ((anwd)localObject3).f((String)localObject1);
                ((anwd)localObject3).notifyUI(6, true, new Object[] { Integer.valueOf(6), Byte.valueOf(0), localObject1 });
                ((anwd)localObject3).notifyUI(127, true, new Object[] { localObject1 });
              }
              a(2001, true, null);
            }
          }
          k = i;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_group_msg_sync uint32_processflag=" + paramArrayOfByte.msg_group_msg_sync.uint32_processflag.get() + ";uint32_msg_type=" + paramArrayOfByte.msg_group_msg_sync.uint32_msg_type.get());
            k = i;
          }
        }
      }
      if ((j != 0) || (k != 0))
      {
        if ((j == 0) || (k == 0)) {
          break label1269;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(4);
      }
      for (;;)
      {
        if ((paramArrayOfByte.msg_clean_count_msg.has()) && (paramArrayOfByte.msg_clean_count_msg.get() != null))
        {
          if (a(paramArrayOfByte.msg_clean_count_msg.uint32_processflag.get()))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(anhk.W, 9000, 0 - bdgn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
            bdgn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
            bdgm.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
            localObject1 = (aiyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(anhk.M, 0, true, true);
            ((aiyr)localObject1).b();
          }
          i = ((submsgtype0x44.ClearCountMsg)paramArrayOfByte.msg_clean_count_msg.get()).uint32_updateflag.get();
          if (i > 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(2);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_clean_count_msg uint32_processflag=" + paramArrayOfByte.msg_clean_count_msg.uint32_processflag.get() + " updateFlag=" + i);
          }
        }
        if ((paramArrayOfByte.msg_modify_msg_sync.has()) && (paramArrayOfByte.msg_modify_msg_sync.get() != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().b(2);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_modify_msg_sync =" + paramArrayOfByte.msg_modify_msg_sync.get());
          }
        }
        if ((!paramArrayOfByte.msg_waiting_msg_sync.has()) || (paramArrayOfByte.msg_waiting_msg_sync.get() == null)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(2);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_waiting_msg_sync =" + paramArrayOfByte.msg_waiting_msg_sync.get());
        return;
        label1269:
        if (j != 0) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(2);
        } else if (k != 0) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(3, 1, false);
        }
      }
      i = 0;
      break label355;
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str);
        if (((localObject == null) || (System.currentTimeMillis() - ((AppShareID)localObject).updateTime >= 86400000L)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().add(str)))
        {
          localObject = new GetResourceReqInfo();
          ((GetResourceReqInfo)localObject).uiResID = 0L;
          ((GetResourceReqInfo)localObject).strPkgName = str;
          ((GetResourceReqInfo)localObject).uiCurVer = 0L;
          ((GetResourceReqInfo)localObject).sResType = 4;
          ((GetResourceReqInfo)localObject).sLanType = 0;
          ((GetResourceReqInfo)localObject).sReqType = 1;
          localArrayList.add(localObject);
          if (QLog.isColorLevel()) {
            QLog.d("share_appid", 2, "Request list add appid = " + str);
          }
        }
      }
      if (localArrayList.size() > 0) {
        bbxs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localArrayList);
      }
    }
  }
  
  protected void a(submsgtype0x26.MsgBody paramMsgBody)
  {
    if ((!paramMsgBody.msg_subcmd_0x3_push_body.has()) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : msg has not 0x3_push_body");
    }
    paramMsgBody = (submsgtype0x26.MsgBody.SubCmd0x3UpdateDiscussAppInfo)paramMsgBody.msg_subcmd_0x3_push_body.get();
    if ((paramMsgBody.uint64_conf_uin.has()) && (paramMsgBody.msg_app_tip_notify.has()))
    {
      paramMsgBody.uint64_conf_uin.get();
      paramMsgBody = (submsgtype0x26.AppTipNotify)paramMsgBody.msg_app_tip_notify.get();
      if (paramMsgBody.bytes_text.has())
      {
        paramMsgBody = paramMsgBody.bytes_text.get().toByteArray();
        if (paramMsgBody.length > 0) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramMsgBody);
        }
      }
    }
  }
  
  public void a(SubMsgType0xa8.MsgBody paramMsgBody)
  {
    if (!a()) {
      if (QLog.isColorLevel()) {
        QLog.d("PullActive", 2, "handlePullActivePushMsg, isNeedNotifyActivePush is false");
      }
    }
    Object localObject1;
    Intent localIntent;
    int i;
    do
    {
      do
      {
        return;
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80065A9", "0X80065A9", 0, 0, "", "", "", "");
      } while (!paramMsgBody.bytes_msg_summary.has());
      localObject1 = paramMsgBody.bytes_msg_summary.get().toStringUtf8();
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.b);
      localIntent.putExtra("fragment_id", 1);
      localIntent.setFlags(335544320);
      i = paramMsgBody.uint32_action_type.get();
      if (QLog.isColorLevel()) {
        QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: actionType: %d, brief: %s", new Object[] { Integer.valueOf(i), localObject1 }));
      }
      if (i != 1) {
        break;
      }
    } while (!paramMsgBody.uint32_action_subType.has());
    int j = paramMsgBody.uint32_action_subType.get();
    localIntent.putExtra("extra_pull_active_push_type", i);
    localIntent.putExtra("extra_pull_active_push_subtype", j);
    if (QLog.isColorLevel()) {
      QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: actionSubType: %d", new Object[] { Integer.valueOf(j) }));
    }
    paramMsgBody = "";
    for (;;)
    {
      localIntent.putExtra(awhh.b, (String)localObject1);
      localIntent.putExtra("activepull_push_flag", true);
      Object localObject2 = awhh.jdField_a_of_type_JavaLangString;
      Object localObject3 = bggl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130840337);
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
      localToServiceMsg.extraData.putStringArray("cmds", new String[] { localObject1, localObject2, localObject1 });
      localToServiceMsg.extraData.putParcelable("intent", localIntent);
      localToServiceMsg.extraData.putParcelable("bitmap", (Parcelable)localObject3);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService(localToServiceMsg);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext();
      if (!bgrj.a((Context)localObject1)) {
        break;
      }
      localObject2 = (awhh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(145);
      ((awhh)localObject2).a(localIntent);
      localObject3 = (awhk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(72);
      if (SettingCloneUtil.readValue((Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ((Context)localObject1).getString(2131693426), "qqsetting_lock_screen_whenexit_key", true))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "handlePullActivePushMsg, start lsActivity");
        }
        ((awhk)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, anhk.aw, 9653, false, awhg.a(paramMsgBody, 1008, localIntent));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((awhh)localObject2).jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush);
      return;
      if (i == 2)
      {
        if (!paramMsgBody.bytes_extend_content.has()) {
          break;
        }
        paramMsgBody = paramMsgBody.bytes_extend_content.get().toStringUtf8();
        localIntent.putExtra("extra_pull_active_push_type", i);
        localIntent.putExtra("extra_pull_active_push_url", paramMsgBody);
        if (QLog.isColorLevel()) {
          QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: url: %s", new Object[] { paramMsgBody }));
        }
        paramMsgBody = "";
        continue;
      }
      if ((i != 3) || (!paramMsgBody.bytes_extend_content.has())) {
        break;
      }
      paramMsgBody = paramMsgBody.bytes_extend_content.get().toStringUtf8();
      localIntent.putExtra("open_chatfragment", true);
      localIntent.putExtra("uin", paramMsgBody);
      localIntent.putExtra("param_fromuin", paramMsgBody);
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("isforceRequestDetail", true);
      if (QLog.isColorLevel()) {
        QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: public account uin: %s", new Object[] { paramMsgBody }));
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26");
    }
    submsgtype0x26.MsgBody localMsgBody = new submsgtype0x26.MsgBody();
    do
    {
      try
      {
        localMsgBody.mergeFrom(paramArrayOfByte);
        if (!localMsgBody.uint32_sub_cmd.has())
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : msg has not body");
          }
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : fail to parse submsgtype0x26.");
        return;
      }
      long l = a(localMsgBody);
      if (l != 0L)
      {
        bfkp localbfkp = (bfkp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(171);
        if (localbfkp != null) {
          localbfkp.notifyUI(3, true, new Object[] { Long.valueOf(l) });
        }
      }
      if ((localMsgBody.uint32_sub_cmd.get() == 1) || (localMsgBody.uint32_sub_cmd.get() == 4))
      {
        ((anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(paramArrayOfByte);
        return;
      }
    } while (localMsgBody.uint32_sub_cmd.get() != 3);
    a(localMsgBody);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    ((avfx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(268)).a(paramArrayOfByte, paramInt);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt, MsgInfo paramMsgInfo)
  {
    ((avfx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(268)).a(paramArrayOfByte, paramInt, paramMsgInfo);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).a(paramArrayOfByte, paramLong, this);
  }
  
  public void a(byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    boolean bool2 = true;
    Object localObject = new SubMsgType0xcb.MsgBody();
    label480:
    String str;
    try
    {
      ((SubMsgType0xcb.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (MessageForNearbyLiveTip)bbzh.a(-2053);
      if (((SubMsgType0xcb.MsgBody)localObject).uint32_anchor_status.get() == 1)
      {
        bool1 = true;
        paramArrayOfByte.isLiving = bool1;
        paramArrayOfByte.jumpingUrl = ((SubMsgType0xcb.MsgBody)localObject).bytes_jump_schema.get().toStringUtf8();
        paramArrayOfByte.msg = ((SubMsgType0xcb.MsgBody)localObject).bytes_live_wording.get().toStringUtf8();
        paramArrayOfByte.headUrl = ((SubMsgType0xcb.MsgBody)localObject).bytes_anchor_head_url.get().toStringUtf8();
        paramArrayOfByte.nickName = ((SubMsgType0xcb.MsgBody)localObject).bytes_anchor_nickname.get().toStringUtf8();
        paramArrayOfByte.liveEndWording = ((SubMsgType0xcb.MsgBody)localObject).bytes_live_end_wording.get().toStringUtf8();
        paramArrayOfByte.c2cMsgWording = ((SubMsgType0xcb.MsgBody)localObject).bytes_c2c_msg_wording.get().toStringUtf8();
        paramArrayOfByte.startLiveWordingType = ((SubMsgType0xcb.MsgBody)localObject).uint32_live_wording_type.get();
        paramArrayOfByte.endLiveWordingType = ((SubMsgType0xcb.MsgBody)localObject).uint32_end_wording_type.get();
        paramArrayOfByte.time = paramMsgInfo.uRealMsgTime;
        paramArrayOfByte.msgseq = paramMsgInfo.uRealMsgTime;
        paramArrayOfByte.shmsgseq = paramMsgInfo.shMsgSeq;
        paramArrayOfByte.msgUid = paramMsgInfo.lMsgUid;
        paramArrayOfByte.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        paramArrayOfByte.istroop = 1001;
        paramArrayOfByte.senderuin = String.valueOf(paramMsgInfo.lFromUin + anhk.g);
        paramArrayOfByte.frienduin = String.valueOf(paramMsgInfo.lFromUin + anhk.g);
        paramArrayOfByte.getBytes();
        if (QLog.isColorLevel())
        {
          paramMsgInfo = new StringBuilder();
          paramMsgInfo.append("status=").append(paramArrayOfByte.isLiving).append("jumpingUrl=").append(paramArrayOfByte.jumpingUrl).append("liveWording=").append(paramArrayOfByte.msg).append("headUrl").append(paramArrayOfByte.headUrl).append("nickName").append(paramArrayOfByte.nickName).append("startLiveWordingType=").append(((SubMsgType0xcb.MsgBody)localObject).uint32_live_wording_type.get()).append("endLiveWordingType=").append(((SubMsgType0xcb.MsgBody)localObject).uint32_end_wording_type.get());
          QLog.i("Q.msg.BaseMessageProcessor", 2, paramMsgInfo.toString());
        }
        if ((!MessageForNearbyLiveTip.isHuayangTip(paramArrayOfByte.jumpingUrl)) || (MessageForNearbyLiveTip.isSupportHuayangBusinessType(paramArrayOfByte.jumpingUrl))) {
          break label480;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.BaseMessageProcessor", 2, "decodeNearbyLiveTipMsg discard a not support huayang tips message, jumpUrl=" + paramArrayOfByte.jumpingUrl);
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("Q.msg.BaseMessageProcessor", 2, "decodeNearbyLiveTipMsg decode failed" + paramArrayOfByte.toString());
            continue;
            bool1 = false;
          }
        }
        paramMsgInfo = new ArrayList();
      } while (anqc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte, true));
      paramMsgInfo.add(paramArrayOfByte);
      boolean bool3 = paramArrayOfByte.senderuin.equals(String.valueOf(1822701914L + anhk.g));
      if (bool3) {
        paramArrayOfByte.isLiving = true;
      }
      if (paramArrayOfByte.isLiving)
      {
        bool2 = anqc.a(paramMsgInfo);
        int i = acwh.a(paramMsgInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if ((bool2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {}
        for (bool1 = true;; bool1 = false)
        {
          ((QQMessageFacade)localObject).a(paramMsgInfo, str, bool1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((int)paramArrayOfByte.time);
          if ((bdch.a()) || (!bool3)) {
            break;
          }
          a("handleGetBuddyMessageResp", true, i, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2), false);
          return;
        }
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayOfByte.frienduin, paramArrayOfByte.istroop);
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayOfByte.frienduin, paramArrayOfByte.istroop, ((MessageRecord)localObject).uniseq, paramArrayOfByte.msgData);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localObject);
        return;
      }
      bool1 = anqc.a(paramMsgInfo);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (!bool1) {
        break label789;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop) {}
    label789:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((QQMessageFacade)localObject).a(paramMsgInfo, str, bool1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((int)paramArrayOfByte.time);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte, aofx paramaofx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7");
    }
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject = new submsgtype0xc7.MsgBody();
    for (;;)
    {
      try
      {
        paramArrayOfByte = (submsgtype0xc7.MsgBody)((submsgtype0xc7.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        if (paramArrayOfByte == null) {
          break;
        }
        paramArrayOfByte = paramArrayOfByte.rpt_msg_mod_infos.get().iterator();
        if (!paramArrayOfByte.hasNext()) {
          break;
        }
        localObject = (submsgtype0xc7.ForwardBody)paramArrayOfByte.next();
        if ((!((submsgtype0xc7.ForwardBody)localObject).uint32_notify_type.has()) || (((submsgtype0xc7.ForwardBody)localObject).uint32_notify_type.get() != 1)) {
          break label133;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7 push a no content");
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramArrayOfByte) {}
      QLog.e("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7", paramArrayOfByte);
      return;
      label133:
      if (((submsgtype0xc7.ForwardBody)localObject).uint32_op_type.has()) {
        switch (((submsgtype0xc7.ForwardBody)localObject).uint32_op_type.get())
        {
        default: 
          break;
        case 3000: 
          if (((submsgtype0xc7.ForwardBody)localObject).msg_hot_friend_notify.has())
          {
            localObject = (submsgtype0xc7.HotFriendNotify)((submsgtype0xc7.ForwardBody)localObject).msg_hot_friend_notify.get();
            axax.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (submsgtype0xc7.HotFriendNotify)localObject, paramaofx);
          }
          break;
        case 4000: 
          if (((submsgtype0xc7.ForwardBody)localObject).msg_relational_chain_change.has())
          {
            localObject = (submsgtype0xc7.RelationalChainChange)((submsgtype0xc7.ForwardBody)localObject).msg_relational_chain_change.get();
            if (((submsgtype0xc7.RelationalChainChange)localObject).uint64_appid.get() == 10001L) {
              axas.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (submsgtype0xc7.RelationalChainChange)localObject, paramaofx);
            } else if (((submsgtype0xc7.RelationalChainChange)localObject).uint64_appid.get() == 19999L) {
              axbb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (submsgtype0xc7.RelationalChainChange)localObject, paramaofx);
            } else if (((submsgtype0xc7.RelationalChainChange)localObject).uint64_appid.get() == 10002L) {
              afyc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (submsgtype0xc7.RelationalChainChange)localObject, paramaofx);
            }
          }
          break;
        }
      }
    }
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a == 0);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xbe");
    }
    Object localObject = new SubMsgType0xbe.MsgBody();
    try
    {
      ((SubMsgType0xbe.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      if (!((SubMsgType0xbe.MsgBody)localObject).uint64_group_code.has())
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xbe : msg has not uint64_group_code");
        }
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xbe : fail to parse submsgtype0xbe.");
      return;
    }
    try
    {
      paramArrayOfByte = new JSONObject();
      if (((SubMsgType0xbe.MsgBody)localObject).uint64_uin.has()) {
        paramArrayOfByte.put("uin", ((SubMsgType0xbe.MsgBody)localObject).uint64_uin.get());
      }
      if (((SubMsgType0xbe.MsgBody)localObject).uint64_group_code.has()) {
        paramArrayOfByte.put("groupCode", ((SubMsgType0xbe.MsgBody)localObject).uint64_group_code.get());
      }
      if (((SubMsgType0xbe.MsgBody)localObject).uint32_notify_type.has()) {
        paramArrayOfByte.put("notifyType", ((SubMsgType0xbe.MsgBody)localObject).uint32_notify_type.get());
      }
      if (((SubMsgType0xbe.MsgBody)localObject).uint32_online_level.has()) {
        paramArrayOfByte.put("onlineLevel", ((SubMsgType0xbe.MsgBody)localObject).uint32_online_level.get());
      }
      if (((SubMsgType0xbe.MsgBody)localObject).rpt_msg_medal_list.has())
      {
        JSONArray localJSONArray = new JSONArray();
        localObject = ((SubMsgType0xbe.MsgBody)localObject).rpt_msg_medal_list.get().iterator();
        while (((Iterator)localObject).hasNext())
        {
          SubMsgType0xbe.Medal localMedal = (SubMsgType0xbe.Medal)((Iterator)localObject).next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("id", localMedal.uint32_id.get());
          localJSONObject.put("level", localMedal.uint32_level.get());
          localJSONObject.put("type", localMedal.uint32_type.get());
          localJSONObject.put("iconUrl", localMedal.str_icon_url.get());
          localJSONObject.put("flashUrl", localMedal.str_flash_url.get());
          localJSONObject.put("name", localMedal.str_name.get());
          localJSONArray.put(localJSONObject);
        }
        paramArrayOfByte.put("medalList", localJSONArray);
      }
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayOfByte.toString());
  }
  
  public void b(byte[] paramArrayOfByte, long paramLong)
  {
    ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).a(paramArrayOfByte, paramLong);
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x83");
    }
    Object localObject = new SubMsgType0x83.MsgBody();
    do
    {
      try
      {
        ((SubMsgType0x83.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        if (!((SubMsgType0x83.MsgBody)localObject).uint64_group_id.has())
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x83 : msg has not uint64_group_id");
          }
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x83 : fail to parse submsgtype0x83.");
        return;
      }
    } while (!((SubMsgType0x83.MsgBody)localObject).rpt_msg_params.has());
    paramArrayOfByte = ((SubMsgType0x83.MsgBody)localObject).rpt_msg_params;
    if (((SubMsgType0x83.MsgBody)localObject).uint64_seq.has()) {}
    for (long l1 = ((SubMsgType0x83.MsgBody)localObject).uint64_seq.get();; l1 = -1L)
    {
      if (((SubMsgType0x83.MsgBody)localObject).uint64_group_id.has()) {}
      for (long l2 = ((SubMsgType0x83.MsgBody)localObject).uint64_group_id.get();; l2 = -1L)
      {
        int i = 0;
        label138:
        if (i < paramArrayOfByte.size())
        {
          localObject = (SubMsgType0x83.MsgParams)paramArrayOfByte.get(i);
          if ((localObject != null) && (((SubMsgType0x83.MsgParams)localObject).uint32_type.has())) {
            break label179;
          }
        }
        for (;;)
        {
          i += 1;
          break label138;
          break;
          label179:
          a(l1, l2, (SubMsgType0x83.MsgParams)localObject, ((SubMsgType0x83.MsgParams)localObject).uint32_type.get());
        }
      }
    }
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().i(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwk
 * JD-Core Version:    0.7.0.1
 */