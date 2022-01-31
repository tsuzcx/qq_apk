import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import QQService.EVIPSPEC;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopNameHelper;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.troop.NearbyVideoProxyBroadcastReceiver;
import friendlist.AddGroupResp;
import friendlist.DelGroupResp;
import friendlist.RenameGroupResp;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.observer.AccountObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import protocol.KQQConfig.GetResourceReqInfo;
import tencent.im.group.cmd0x2dc.GroupVisitorJoinMsg;
import tencent.im.group.cmd0x2dc.VisitorJoinInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x117.submsgtype0x117.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppID;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppTipNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x3UpdateDiscussAppInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AddGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AppointmentNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ChatMatchInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DaRenNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DelFriend;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DelGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.FrdCustomOnlineStatusChange;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.FriendGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.FriendRemark;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.GroupMemberProfileInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.GroupProfileInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.GroupSort;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.MQQCampusNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModCustomFace;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModFriendGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModFriendRemark;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupMemberProfile;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupName;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupProfile;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupSort;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModLongNick;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModProfile;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModSnsGeneralInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.NewComeinUserNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.PraiseRankNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ProfileInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.PushReportDev;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.PushSearchDev;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpateBuffer;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateFlag;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateItem;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateOneFlag;
import tencent.im.s2c.msgtype0x210.submsgtype0x31.submsgtype0x31.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.ClearCountMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.FriendSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.GroupSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.ModifySyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.WaitingSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x83.SubMsgType0x83.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x83.SubMsgType0x83.MsgParams;
import tencent.im.s2c.msgtype0x210.submsgtype0xa8.SubMsgType0xa8.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xb3.SubMsgType0xb3.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xb3.SubMsgType0xb3.PushAddFrdNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0xbe.SubMsgType0xbe.Medal;
import tencent.im.s2c.msgtype0x210.submsgtype0xbe.SubMsgType0xbe.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.HotFriendNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;
import tencent.im.s2c.msgtype0x210.submsgtype0xcb.SubMsgType0xcb.MsgBody;

public class akqf
  extends akoo
{
  public akqf(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private int a(SubMsgType0x27.ForwardBody paramForwardBody, ajxn paramajxn, TroopManager paramTroopManager, Object paramObject, airz paramairz, Friends[] paramArrayOfFriends, int paramInt)
  {
    paramForwardBody = (SubMsgType0x27.ModProfile)paramForwardBody.msg_mod_profile.get();
    int n = paramInt;
    long l2;
    int m;
    int k;
    int i1;
    int i2;
    label689:
    Object localObject;
    int i3;
    if (paramForwardBody.uint64_uin.has())
    {
      l2 = paramForwardBody.uint64_uin.get();
      paramObject = paramForwardBody.rpt_msg_profile_infos.get().iterator();
      m = 0;
      k = 0;
      n = 0;
      i1 = paramInt;
      paramInt = n;
      if (paramObject.hasNext())
      {
        paramForwardBody = (SubMsgType0x27.ProfileInfo)paramObject.next();
        n = k;
        if (paramForwardBody.uint32_field.has())
        {
          n = k;
          if (!paramForwardBody.bytes_value.has()) {}
        }
        switch (paramForwardBody.uint32_field.get())
        {
        default: 
          n = k;
          if (QLog.isColorLevel())
          {
            QLog.d("cardpush", 2, "push a unknow field Uint32Field = " + paramForwardBody.uint32_field.get());
            n = k;
          }
          i2 = m;
          k = n;
          m = paramInt;
        case 20002: 
          for (paramInt = i2;; paramInt = n)
          {
            n = m;
            m = paramInt;
            paramInt = n;
            break;
            paramTroopManager = paramForwardBody.bytes_value.get().toStringUtf8();
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModProfile Nick = " + paramTroopManager);
            }
            localObject = paramajxn.e(Long.toString(l2));
            paramForwardBody = null;
            if (localObject != null) {
              paramForwardBody = ((Friends)localObject).name;
            }
            paramArrayOfFriends[i1] = paramajxn.a(l2 + "", paramTroopManager);
            if ((localObject != null) && (((Friends)localObject).isFriend()) && (aket.a(paramTroopManager, paramForwardBody))) {
              aket.a(l2, paramTroopManager, (ajvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53));
            }
            paramForwardBody = paramajxn.b(l2 + "");
            if (paramForwardBody != null)
            {
              paramForwardBody.strNick = paramTroopManager;
              paramajxn.a(paramForwardBody);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(1, true, paramForwardBody);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(3, true, Long.toString(l2));
            TroopNameHelper.b(Long.toString(l2));
            n = m;
            m = paramInt;
            i1 += 1;
          }
        case 20014: 
          if (paramForwardBody.bytes_value.has())
          {
            paramForwardBody = paramForwardBody.bytes_value.get();
            n = paramForwardBody.size();
            if (paramForwardBody.size() > 0)
            {
              paramTroopManager = (ajtk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
              if (paramTroopManager != null)
              {
                i3 = paramForwardBody.byteAt(0);
                if (i3 != 101) {
                  paramTroopManager.d(i3);
                }
                i2 = n;
                n = i3;
              }
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "20014 push a ProfileInfo size = " + i2 + "  settingValue = " + n);
      }
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      paramForwardBody = paramForwardBody.bytes_value.get();
      if ((paramForwardBody != null) && (paramForwardBody.size() == 2))
      {
        n = paramForwardBody.byteAt(0);
        n = (short)(paramForwardBody.byteAt(1) | n << 8);
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModProfile Head = " + n);
        }
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).c(Long.toString(l2));
        paramForwardBody = paramajxn.b(l2 + "");
        if (paramForwardBody != null)
        {
          paramForwardBody.nFaceID = n;
          paramajxn.a(paramForwardBody);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(4, true, new Object[] { l2 + "", paramForwardBody, null });
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(1, true, paramForwardBody);
        }
      }
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      i2 = paramForwardBody.bytes_value.get().byteAt(0);
      if (i2 == 1) {
        n = 0;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModProfile Sex = " + n);
        }
        paramForwardBody = paramajxn.b(l2 + "");
        if (paramForwardBody != null)
        {
          paramForwardBody.shGender = ((short)n);
          paramajxn.a(paramForwardBody);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(1, true, paramForwardBody);
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        if (i2 == 2)
        {
          n = 1;
        }
        else
        {
          n = i2;
          if (i2 == 0) {
            n = 2;
          }
        }
      }
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get(0);
      a(i2);
      ((akfw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).notifyUI(101, true, Integer.valueOf(i2));
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("vip", 2, "bubble id = " + i2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, "vip update uin=" + l2);
      }
      paramForwardBody = paramForwardBody.bytes_value.get();
      paramTroopManager = paramajxn.e(Long.toString(l2));
      n = k;
      if (paramTroopManager == null) {
        break;
      }
      paramTroopManager = (Friends)paramTroopManager.clone();
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, String.format("bit info = %02X", new Object[] { Byte.valueOf(paramForwardBody.byteAt(0)) }));
      }
      i2 = paramTroopManager.qqVipInfo;
      if ((paramForwardBody.byteAt(0) & 0x80) == 0)
      {
        n = 0;
        label1664:
        paramTroopManager.qqVipInfo = (n << 24 | 0xFFFFFF & i2);
        i2 = paramTroopManager.superQqInfo;
        if ((paramForwardBody.byteAt(0) & 0x8) != 0) {
          break label2131;
        }
        n = 0;
        label1700:
        paramTroopManager.superQqInfo = (n << 24 | 0xFFFFFF & i2);
        if ((paramForwardBody.byteAt(0) & 0x40) == 0) {
          break label2137;
        }
        bool1 = true;
        label1730:
        if (QLog.isColorLevel()) {
          QLog.d("vip", 2, "is year vip =" + bool1);
        }
        if (!bool1) {
          break label2143;
        }
        n = 65536;
        label1774:
        if (!paramTroopManager.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
          break label2149;
        }
        paramTroopManager.superVipInfo = (paramTroopManager.superVipInfo & 0xFF00FFFF | n);
      }
      for (;;)
      {
        if (paramTroopManager.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB)) {
          paramTroopManager.bigClubInfo = (n | paramTroopManager.bigClubInfo & 0xFF00FFFF);
        }
        if (QLog.isColorLevel()) {
          QLog.d("vip", 2, String.format("SVIP = %08X, VIP = %08X, SuperQQ = %08X", new Object[] { Integer.valueOf(paramTroopManager.superVipInfo), Integer.valueOf(paramTroopManager.qqVipInfo), Integer.valueOf(paramTroopManager.superQqInfo) }));
        }
        paramajxn.a(paramTroopManager);
        ((akfw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).notifyUI(100, true, null);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(Long.toString(l2)))
        {
          paramForwardBody = new Intent("tencent.video.q2v.SVIP.PAY");
          paramForwardBody.putExtra("SVIPpaySuccess", true);
          paramForwardBody.setPackage(MobileQQ.getContext().getPackageName());
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramForwardBody);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(Long.toString(l2)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("vip", 2, "[EmoticonUpdateAuth] 23105 updateEmoticonAuth");
          }
          paramForwardBody = (ajvp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
          paramForwardBody.a(0, 0);
          paramForwardBody.a(0, 0, 1, 0);
          if (QLog.isColorLevel()) {
            QLog.d("QVipSettingMe.", 2, "[vipInfoPush] 23105 request vipInfoHandler");
          }
          bbwv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "last_pull_pay_rule", 0L);
          paramForwardBody = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          ((akjo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(27)).a(paramForwardBody, l2 + "");
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        n = 1;
        break label1664;
        label2131:
        n = 1;
        break label1700;
        label2137:
        bool1 = false;
        break label1730;
        label2143:
        n = 0;
        break label1774;
        label2149:
        if (paramTroopManager.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
          paramTroopManager.qqVipInfo = (paramTroopManager.qqVipInfo & 0xFF00FFFF | n);
        } else if (paramTroopManager.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
          paramTroopManager.superQqInfo = (paramTroopManager.superQqInfo & 0xFF00FFFF | n);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, "vip update uin=" + l2);
      }
      paramForwardBody = paramForwardBody.bytes_value.get();
      paramTroopManager = Long.toString(l2);
      localObject = paramajxn.e(paramTroopManager);
      n = k;
      if (localObject == null) {
        break;
      }
      localObject = (Friends)((Friends)localObject).clone();
      boolean bool1 = ((Friends)localObject).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
      boolean bool2 = ((Friends)localObject).isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
      boolean bool3 = ((Friends)localObject).isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ);
      boolean bool4 = ((Friends)localObject).isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB);
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, "SVIP: " + bool1 + "; VIP: " + bool2 + "; SuperQQ: " + bool3);
      }
      int i4 = 0;
      int i = paramForwardBody.byteAt(4);
      int j = paramForwardBody.byteAt(5);
      if ((j & 0xF0) != 0)
      {
        i2 = 16;
        i3 = 0;
        label2408:
        n = i4;
        if (i3 < 4)
        {
          if ((j & i2) != 0) {
            n = 13 - i3;
          }
        }
        else
        {
          label2433:
          if (QLog.isColorLevel()) {
            QLog.d("vip", 2, String.format("[%02X%02X] => LV %d", new Object[] { Byte.valueOf(i), Byte.valueOf(j), Integer.valueOf(n) }));
          }
          if (!bool1) {
            break label2664;
          }
          ((Friends)localObject).superVipInfo = (((Friends)localObject).superVipInfo & 0xFFFF0000 | 0xFFFF & n);
        }
      }
      for (;;)
      {
        if (bool4) {
          ((Friends)localObject).bigClubInfo = (n & 0xFFFF | ((Friends)localObject).bigClubInfo & 0xFFFF0000);
        }
        paramajxn.a((Friends)localObject);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramTroopManager)) {
          ((akfw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).notifyUI(100, true, null);
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        i3 += 1;
        i2 = (byte)(i2 << 1);
        break label2408;
        if (i != 0)
        {
          i2 = 1;
          i3 = 0;
          for (;;)
          {
            n = i4;
            if (i3 >= 8) {
              break;
            }
            if ((i & i2) != 0)
            {
              n = 9 - i3;
              break;
            }
            i3 += 1;
            i2 = (byte)(i2 << 1);
          }
        }
        n = 1;
        break label2433;
        label2664:
        if (bool2) {
          ((Friends)localObject).qqVipInfo = (((Friends)localObject).qqVipInfo & 0xFFFF0000 | 0xFFFF & n);
        } else if (bool3) {
          ((Friends)localObject).superQqInfo = (((Friends)localObject).superQqInfo & 0xFFFF0000 | 0xFFFF & n);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, "svip update uin=" + l2);
      }
      paramForwardBody = paramForwardBody.bytes_value.get();
      paramTroopManager = Long.toString(l2);
      localObject = paramajxn.e(paramTroopManager);
      n = k;
      if (localObject == null) {
        break;
      }
      localObject = (Friends)((Friends)localObject).clone();
      if ((paramForwardBody.byteAt(5) & 0x20) != 0)
      {
        bool1 = true;
        label2810:
        i2 = ((Friends)localObject).superVipInfo;
        if (!bool1) {
          break label2993;
        }
      }
      label2993:
      for (n = 1;; n = 0)
      {
        ((Friends)localObject).superVipInfo = (n << 24 | 0xFFFFFF & i2);
        paramajxn.a((Friends)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("vip", 2, "isSVip=" + bool1 + "friend.superVipInfo=" + ((Friends)localObject).superVipInfo);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramTroopManager))
        {
          ((akfw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).notifyUI(100, true, null);
          if (QLog.isColorLevel()) {
            QLog.d("vip", 2, "[EmoticonUpdateAuth] 23107 updateEmoticonAuth");
          }
          paramForwardBody = (ajvp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
          paramForwardBody.a(0, 0);
          paramForwardBody.a(0, 0, 1, 0);
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        bool1 = false;
        break label2810;
      }
      paramForwardBody = paramForwardBody.bytes_value.get();
      n = k;
      if ((paramForwardBody.byteAt(5) & 0x2) == 0) {
        break;
      }
      paramTroopManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
      if ((paramForwardBody.byteAt(1) & 0x2) != 0) {
        n = 2;
      }
      for (;;)
      {
        if (n != -1)
        {
          paramTroopManager.edit().putInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), n).commit();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(101, true, Integer.valueOf(n));
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        if (paramTroopManager.getInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1) == 2) {
          n = 1;
        } else {
          n = -1;
        }
      }
      paramForwardBody = paramForwardBody.bytes_value.get();
      if (((paramForwardBody.byteAt(31) & 0x20) != 0) || ((paramForwardBody.byteAt(34) & 0x10) != 0) || ((paramForwardBody.byteAt(29) & 0x10) != 0))
      {
        paramTroopManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
        if (((paramForwardBody.byteAt(11) & 0x20) == 0) && ((paramForwardBody.byteAt(14) & 0x10) == 0)) {
          break label3546;
        }
        n = 4;
        label3269:
        if (n != -1)
        {
          paramTroopManager.edit().putInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), n).commit();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(101, true, Integer.valueOf(n));
        }
      }
      if ((paramForwardBody.byteAt(12) & 0x8) != 0)
      {
        bool1 = true;
        label3354:
        ayah.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool1);
        if ((paramForwardBody.byteAt(13) & 0x40) == 0) {
          break label3629;
        }
      }
      label3629:
      for (bool1 = true;; bool1 = false)
      {
        n = k;
        if (SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), Long.toString(l2), null, "qqsetting_pcactive_key", false) == bool1) {
          break;
        }
        SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), Long.valueOf(l2).toString(), null, "qqsetting_pcactive_key", bool1);
        paramForwardBody = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
        paramForwardBody.putExtra("pcActive", bool1);
        paramForwardBody.putExtra("uin", Long.valueOf(l2).toString());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramForwardBody);
        if (bool1)
        {
          SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), Long.toString(l2), null, "pcactive_config", true);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.openMsfPCActive(Long.toString(l2), "config", true);
          QLog.d("OnlinePush", 1, "PCActive opened: true by switch push");
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break label689;
        label3546:
        if ((paramForwardBody.byteAt(9) & 0x10) != 0)
        {
          n = 3;
          break label3269;
        }
        n = paramTroopManager.getInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
        if ((n == 4) || (n == 3))
        {
          n = 1;
          break label3269;
        }
        n = -1;
        break label3269;
        bool1 = false;
        break label3354;
      }
      long l1 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asLongBuffer().get();
      paramTroopManager = paramajxn.a(String.valueOf(l2));
      paramForwardBody = paramTroopManager;
      if (paramTroopManager == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = String.valueOf(l2);
      }
      paramForwardBody.pendantId = l1;
      paramForwardBody.timestamp = System.currentTimeMillis();
      paramajxn.a(paramForwardBody);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Pendant, uin=" + l2 + ", id=" + paramForwardBody.pendantId);
      }
      paramForwardBody = new HashSet(1);
      paramForwardBody.add(String.valueOf(l2));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(66, true, paramForwardBody);
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      paramInt = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramTroopManager = paramajxn.a(String.valueOf(l2));
      paramForwardBody = paramTroopManager;
      if (paramTroopManager == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = String.valueOf(l2);
      }
      if ((paramForwardBody.uVipFont != ho.a(paramInt)) || (paramForwardBody.vipFontType != ho.b(paramInt)))
      {
        paramForwardBody.uVipFont = ho.a(paramInt);
        paramForwardBody.vipFontType = ho.b(paramInt);
        paramForwardBody.timestamp = System.currentTimeMillis();
        paramajxn.a(paramForwardBody);
        bbkv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Font, uin=" + l2 + ", id=" + paramForwardBody.uVipFont + ", type = " + paramForwardBody.vipFontType);
      }
      n = (int)ho.a(paramInt);
      paramInt = m;
      m = n;
      break label689;
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramTroopManager = paramajxn.a(String.valueOf(l2));
      paramForwardBody = paramTroopManager;
      if (paramTroopManager == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = String.valueOf(l2);
        paramForwardBody.magicFont = -1;
      }
      if (paramForwardBody.magicFont != i2)
      {
        paramForwardBody.magicFont = i2;
        paramForwardBody.timestamp = System.currentTimeMillis();
        paramajxn.a(paramForwardBody);
        bbkv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push Get MagicFont uin = " + l2 + ", magicFont = " + i2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramTroopManager = paramajxn.a(String.valueOf(l2));
      n = 0;
      paramForwardBody = paramTroopManager;
      if (paramTroopManager == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = String.valueOf(l2);
        paramForwardBody.fontEffect = -1;
        n = 1;
      }
      if (paramForwardBody.fontEffect != i2)
      {
        paramForwardBody.fontEffect = i2;
        paramForwardBody.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
        ((ho)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).e();
        n = 1;
      }
      if (n != 0) {
        paramajxn.a(paramForwardBody);
      }
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push Get fontEffect uin = " + l2 + ", fontEffect = " + i2 + ", updateTime = " + paramForwardBody.fontEffectLastUpdateTime);
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      k = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      n = k;
      if (k == 0) {
        break;
      }
      n = 1;
      m = paramInt;
      paramInt = n;
      break label689;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramTroopManager = paramajxn.a(String.valueOf(l2));
      paramForwardBody = paramTroopManager;
      if (paramTroopManager == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = String.valueOf(l2);
      }
      if (paramForwardBody.colorRingId != n)
      {
        paramForwardBody.colorRingId = n;
        paramForwardBody.timestamp = System.currentTimeMillis();
        paramajxn.a(paramForwardBody);
        bbon.a(paramForwardBody.uin, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get ColorRing, uin=" + l2 + ", id=" + paramForwardBody.colorRingId);
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      paramTroopManager = paramForwardBody.bytes_value.get();
      n = paramForwardBody.uint32_field.get();
      if ((n >= 42005) && (n <= 42012))
      {
        ByteBuffer.wrap(paramTroopManager.toByteArray()).asShortBuffer().get();
        n = paramInt;
        paramInt = m;
        m = n;
        break label689;
      }
      ByteBuffer.wrap(paramTroopManager.toByteArray()).asIntBuffer().get();
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramForwardBody = paramairz.b(String.valueOf(l2));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "apollo push uin: " + l2 + ", avip flag: " + i2);
      }
      n = k;
      if (paramForwardBody.apolloVipFlag == i2) {
        break;
      }
      paramForwardBody.apolloVipFlag = i2;
      paramairz.a(paramForwardBody);
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramForwardBody = paramairz.b(String.valueOf(l2));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "apollo push uin: " + l2 + ", avip level: " + i2);
      }
      n = k;
      if (paramForwardBody.apolloVipLevel == i2) {
        break;
      }
      paramForwardBody.apolloVipLevel = i2;
      paramairz.a(paramForwardBody);
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramForwardBody = paramairz.b(String.valueOf(l2));
      if ((QLog.isColorLevel()) || (l2 == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())) {
        QLog.d("Q.msg.BaseMessageProcessor", 1, "apollo push uin: " + l2 + ", apollo status: " + n);
      }
      if (paramForwardBody.apolloStatus != n)
      {
        paramForwardBody.apolloStatus = n;
        paramairz.a(paramForwardBody);
        if ((l2 == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) && (paramForwardBody.isApolloStatusOpen()) && (paramForwardBody.apolloLocalTS != paramForwardBody.apolloServerTS))
        {
          paramForwardBody = (bbqp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
          if (paramForwardBody != null) {
            paramForwardBody.a("statusChange");
          }
        }
      }
      paramTroopManager = String.valueOf(l2);
      if (l2 == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())
      {
        paramForwardBody = new Pair(paramTroopManager, Integer.valueOf(n));
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71).notifyUI(3, true, paramForwardBody);
        n = paramInt;
        paramInt = m;
        m = n;
        break label689;
      }
      paramForwardBody = new ArrayList();
      paramForwardBody.add(paramTroopManager);
      paramTroopManager = ajfj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramTroopManager != null) {
        paramTroopManager.a(n, paramForwardBody);
      }
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramForwardBody = String.valueOf(l2);
      if (TextUtils.isEmpty(paramForwardBody))
      {
        n = paramInt;
        paramInt = m;
        m = n;
        break label689;
      }
      paramTroopManager = paramairz.b(paramForwardBody);
      if (paramForwardBody.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) {
        ((bbqp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(new long[] { l2 });
      }
      QLog.d("Q.msg.BaseMessageProcessor", 1, new Object[] { "apollo push uin: " + new StringBuilder().append(l2).append("temp").toString().substring(0, 4) + ", timeStamp: " + n, ", local server:", Long.valueOf(paramTroopManager.apolloServerTS) });
      if (paramTroopManager.apolloServerTS != n)
      {
        paramTroopManager.apolloServerTS = n;
        paramairz.a(paramTroopManager);
      }
      n = 0;
      paramTroopManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      i2 = n;
      if (paramTroopManager != null)
      {
        i2 = n;
        if (paramTroopManager.a())
        {
          i2 = n;
          if (!TextUtils.isEmpty(paramTroopManager.a()))
          {
            i2 = n;
            if (paramTroopManager.a() == 0)
            {
              i2 = n;
              if (paramTroopManager.a().equals(paramForwardBody)) {
                i2 = 1;
              }
            }
          }
        }
      }
      if ((!paramForwardBody.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) || (airz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 2))
      {
        n = k;
        if (i2 == 0) {
          break;
        }
      }
      paramForwardBody = (bbqp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
      paramTroopManager = new ArrayList();
      paramTroopManager.add(Long.valueOf(l2));
      paramForwardBody.a(paramTroopManager, "online_push");
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      n = k;
      if (l2 != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) {
        break;
      }
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      if (n != airz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        paramForwardBody = (airz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
        paramForwardBody.b(n);
        if (n == 1)
        {
          paramForwardBody = paramForwardBody.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          if ((paramForwardBody.isApolloStatusOpen()) && (paramForwardBody.apolloLocalTS != paramForwardBody.apolloServerTS))
          {
            paramForwardBody = (bbqp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
            if (paramForwardBody != null) {
              paramForwardBody.a("whiteList");
            }
          }
        }
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo push white list: " + n);
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      l1 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramForwardBody = paramairz.b(String.valueOf(l2));
      long l3 = NetConnInfoCenter.getServerTime();
      if ((l1 > l3) && (paramForwardBody.apolloSignValidTS != l1))
      {
        paramForwardBody.apolloLocalSignTs = paramForwardBody.apolloSignValidTS;
        paramForwardBody.apolloSignValidTS = l1;
        paramForwardBody.apolloSignStr = "";
        paramairz.a(paramForwardBody);
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo push sign uin: " + l2 + ", valid TS: " + l1 + ", currTS: " + l3);
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      if (paramairz != null)
      {
        paramForwardBody = paramairz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        if ((paramForwardBody != null) && (n != paramForwardBody.apolloAISwitch))
        {
          paramForwardBody.apolloAISwitch = n;
          if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (String.valueOf(l2).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))) {
            paramairz.a(n, 2);
          }
          paramairz.a(paramForwardBody);
        }
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo aiSwitch  push: " + n);
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {}
      for (i2 = paramForwardBody[0];; i2 = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        localObject = String.valueOf(l2);
        paramForwardBody = paramairz.b((String)localObject);
        QLog.d("Q.msg.BaseMessageProcessor", 1, new Object[] { "cmshow_online_push,  uin: ", ApolloUtil.d((String)localObject), ", cmshow3dFlag: ", Integer.valueOf(i2), ", local=", Integer.valueOf(paramForwardBody.cmshow3dFlag) });
        if (paramForwardBody.cmshow3dFlag != i2)
        {
          n = paramForwardBody.cmshow3dFlag;
          paramForwardBody.cmshow3dFlag = i2;
          paramairz.a(paramForwardBody);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l2))) {
            paramairz.c(n, i2);
          }
          paramTroopManager = new ArrayList();
          paramTroopManager.add(localObject);
          localObject = ajfj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (localObject != null) {
            ((ajfg)localObject).a(3, paramTroopManager);
          }
        }
        n = k;
        if ((i2 & 0x1) != 1) {
          break;
        }
        n = k;
        if (paramForwardBody.getApolloDress3D() != null) {
          break;
        }
        paramairz.a("" + l2, airz.a);
        n = paramInt;
        paramInt = m;
        m = n;
        break label689;
      }
      l1 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramForwardBody = paramajxn.b(l2 + "");
      paramTroopManager = paramajxn.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        paramForwardBody.namePlateOfKingGameId = l1;
        paramajxn.a(paramForwardBody);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(1, true, paramForwardBody);
      }
      if (paramTroopManager != null)
      {
        paramTroopManager.namePlateOfKingGameId = l1;
        paramajxn.a(paramTroopManager);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(3, true, Long.toString(l2));
      }
      QLog.i("namePlateOfKing", 1, "handle push gameId = " + l1 + ", uin = " + l2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      l1 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramForwardBody = paramajxn.b(l2 + "");
      paramTroopManager = paramajxn.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        paramForwardBody.namePlateOfKingLoginTime = l1;
        paramajxn.a(paramForwardBody);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(1, true, paramForwardBody);
      }
      if (paramTroopManager != null)
      {
        paramTroopManager.namePlateOfKingLoginTime = l1;
        paramajxn.a(paramTroopManager);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(3, true, Long.toString(l2));
      }
      QLog.i("namePlateOfKing", 1, "handle push gameLoginTime = " + l1 + ", uin = " + l2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramForwardBody = paramajxn.b(l2 + "");
      paramTroopManager = paramajxn.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        paramForwardBody.namePlateOfKingDan = n;
        paramajxn.a(paramForwardBody);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(1, true, paramForwardBody);
      }
      if (paramTroopManager != null)
      {
        paramTroopManager.namePlateOfKingDan = n;
        paramajxn.a(paramTroopManager);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(3, true, Long.toString(l2));
      }
      QLog.i("namePlateOfKing", 1, "handle push namePlateOfKingDan = " + n + ", uin = " + l2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramForwardBody = paramajxn.b(l2 + "");
      paramTroopManager = paramajxn.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        if (n == 1)
        {
          bool1 = true;
          label6845:
          paramForwardBody.namePlateOfKingDanDisplatSwitch = bool1;
          paramajxn.a(paramForwardBody);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(1, true, paramForwardBody);
        }
      }
      else if (paramTroopManager != null) {
        if (n != 1) {
          break label6973;
        }
      }
      label6973:
      for (bool1 = true;; bool1 = false)
      {
        paramTroopManager.namePlateOfKingDanDisplatSwitch = bool1;
        paramajxn.a(paramTroopManager);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(3, true, Long.toString(l2));
        QLog.i("namePlateOfKing", 1, "handle push namePlateOfKingDanDisplatSwitch = " + n + ", uin = " + l2);
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        bool1 = false;
        break label6845;
      }
      paramForwardBody = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(l2 + "");
      ((akjo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(27)).a(paramForwardBody, l2 + "");
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      n = k;
      if (!paramForwardBody.uint32_field.has()) {
        break;
      }
      n = k;
      if (!paramForwardBody.bytes_value.has()) {
        break;
      }
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push 42344 = " + n);
      }
      paramForwardBody = paramajxn.b(l2 + "");
      paramTroopManager = paramajxn.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        paramForwardBody.nameplateVipType = n;
        paramajxn.a(paramForwardBody);
      }
      if (paramTroopManager != null)
      {
        paramTroopManager.nameplateVipType = n;
        paramajxn.a(paramTroopManager);
      }
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      n = k;
      if (!paramForwardBody.uint32_field.has()) {
        break;
      }
      n = k;
      if (!paramForwardBody.bytes_value.has()) {
        break;
      }
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push 42354 = " + n);
      }
      paramForwardBody = paramajxn.b(l2 + "");
      paramTroopManager = paramajxn.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        paramForwardBody.grayNameplateFlag = n;
        paramajxn.a(paramForwardBody);
      }
      if (paramTroopManager != null)
      {
        paramTroopManager.grayNameplateFlag = n;
        paramajxn.a(paramTroopManager);
      }
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {}
      for (n = paramForwardBody[0];; n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push the big club level change=" + n);
        }
        paramForwardBody = paramajxn.b(l2 + "");
        paramTroopManager = paramajxn.e(Long.toString(l2));
        if (paramForwardBody != null)
        {
          paramForwardBody.iBigClubVipLevel = n;
          paramajxn.a(paramForwardBody);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(1, true, paramForwardBody);
        }
        if (paramTroopManager != null)
        {
          paramTroopManager.bigClubInfo = (n & 0xFFFF | paramTroopManager.bigClubInfo & 0xFFFF0000);
          paramajxn.a(paramTroopManager);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(3, true, Long.toString(l2));
        }
        paramForwardBody = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(l2 + "");
        ((akjo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(27)).a(paramForwardBody, l2 + "");
        n = paramInt;
        paramInt = m;
        m = n;
        break;
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {}
      for (n = paramForwardBody[0];; n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        paramForwardBody = paramajxn.b(l2 + "");
        paramTroopManager = paramajxn.e(Long.toString(l2));
        if (paramForwardBody != null)
        {
          paramForwardBody.iBigClubVipType = n;
          paramajxn.a(paramForwardBody);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(1, true, paramForwardBody);
        }
        if (paramTroopManager != null)
        {
          paramTroopManager.bigClubInfo = (paramTroopManager.bigClubInfo & 0xFFFFFF | (n & 0xFF) << 24);
          paramajxn.a(paramTroopManager);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(3, true, Long.toString(l2));
        }
        if (QLog.isColorLevel()) {
          QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push the big club type change=" + n);
        }
        paramForwardBody = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(l2 + "");
        ((akjo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(27)).a(paramForwardBody, l2 + "");
        n = paramInt;
        paramInt = m;
        m = n;
        break;
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {}
      for (n = paramForwardBody[0];; n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        paramForwardBody = paramajxn.b(l2 + "");
        paramTroopManager = paramajxn.e(Long.toString(l2));
        if (paramForwardBody != null)
        {
          paramForwardBody.lBigClubTemplateId = n;
          paramForwardBody.lSuperVipTemplateId = n;
          paramajxn.a(paramForwardBody);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(1, true, paramForwardBody);
        }
        if (paramTroopManager != null)
        {
          paramTroopManager.superVipTemplateId = n;
          paramTroopManager.bigClubTemplateId = n;
          paramajxn.a(paramTroopManager);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(3, true, Long.toString(l2));
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {}
      for (n = paramForwardBody[0];; n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        paramForwardBody = paramajxn.e(Long.toString(l2));
        if (paramForwardBody != null)
        {
          paramForwardBody.isHideBigClub = n;
          paramajxn.a(paramForwardBody);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(3, true, Long.toString(l2));
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {}
      for (n = paramForwardBody[0];; n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push the big club iVipType change = " + n);
        }
        paramForwardBody = paramajxn.e(Long.toString(l2));
        if (paramForwardBody != null)
        {
          paramForwardBody.bigClubInfo = ((n & 0xFF) << 16 | paramForwardBody.bigClubInfo & 0xFF00FFFF);
          paramajxn.a(paramForwardBody);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(3, true, Long.toString(l2));
        }
        paramForwardBody = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(l2 + "");
        ((akjo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(27)).a(paramForwardBody, l2 + "");
        n = paramInt;
        paramInt = m;
        m = n;
        break;
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      n = 0;
      if (paramForwardBody.length == 1) {
        n = paramForwardBody[0];
      }
      for (;;)
      {
        paramForwardBody = paramajxn.b(l2 + "");
        if ((paramForwardBody != null) && (paramForwardBody.mQQLevelType != n))
        {
          paramForwardBody.mQQLevelType = n;
          paramajxn.a(paramForwardBody);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(1, true, paramForwardBody);
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        if (paramForwardBody.length == 2) {
          n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get();
        } else if (paramForwardBody.length == 4) {
          n = ByteBuffer.wrap(paramForwardBody).asIntBuffer().get();
        } else {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "rsp VASPROFILEGATE_SERVICE oidb FIELD_QQ_LEVEL_ICON_TYPE flag content error, len:" + paramForwardBody.length);
        }
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {}
      for (n = paramForwardBody[0];; n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        paramForwardBody = paramajxn.e(Long.toString(l2));
        if (paramForwardBody != null)
        {
          paramForwardBody.cNewLoverDiamondFlag = n;
          paramajxn.a(paramForwardBody);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(3, true, Long.toString(l2));
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
      }
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramTroopManager = paramajxn.a(String.valueOf(l2));
      paramForwardBody = paramTroopManager;
      if (paramTroopManager == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = String.valueOf(l2);
      }
      paramForwardBody.pendantDiyId = n;
      paramForwardBody.timestamp = System.currentTimeMillis();
      paramajxn.a(paramForwardBody);
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get PendantDiyId, uin=" + l2 + ", id=" + paramForwardBody.pendantDiyId);
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      ((bbqs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(235)).a.b(Long.toString(l2), n);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get faceId, uin=" + l2 + ", id=" + n);
      }
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramTroopManager = (BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44);
      label8963:
      label9042:
      short s;
      if (paramTroopManager != null)
      {
        if (n == 0)
        {
          bool1 = true;
          paramTroopManager.a(bool1);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, String.format("bubble unread feature push %s", new Object[] { "" + n }));
        }
        paramTroopManager = paramForwardBody.bytes_value.get().toByteArray();
        if (paramTroopManager.length != 1) {
          break label9173;
        }
        if (paramTroopManager[0] != 1) {
          break label9167;
        }
        bool1 = true;
        paramTroopManager = (ases)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(303);
        s = (short)paramForwardBody.uint32_field.get();
        if (bool1) {
          break label9199;
        }
      }
      label9167:
      label9173:
      label9199:
      for (bool2 = true;; bool2 = false)
      {
        paramTroopManager.a(s, false, "", bool2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "push temp msg block,uin=" + l2 + ", id=" + bool1 + " field=" + paramForwardBody.uint32_field.get());
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        bool1 = false;
        break label8963;
        bool1 = false;
        break label9042;
        if (ByteBuffer.wrap(paramTroopManager).asShortBuffer().get() == 1) {}
        for (bool1 = true;; bool1 = false) {
          break;
        }
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      l1 = -1L;
      if (paramForwardBody.length == 4)
      {
        i2 = ByteBuffer.wrap(new byte[] { paramForwardBody[3] }).get();
        n = i2;
        if (i2 == 1) {
          l1 = ByteBuffer.wrap(new byte[] { paramForwardBody[2], paramForwardBody[1] }).asShortBuffer().get();
        }
      }
      for (n = i2;; n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        paramForwardBody = aujd.a(n);
        paramTroopManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
        l3 = auja.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if ((paramForwardBody != paramTroopManager) || (l3 != l1))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setOnlineStatus(paramForwardBody);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setExtOnlineStatus(l1);
          localObject = new Bundle();
          ((Bundle)localObject).putSerializable("onlineStatus", paramForwardBody);
          ((Bundle)localObject).putLong("extOnlineStatus", l1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.notifyObservers(AccountObserver.class, 2211, true, (Bundle)localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, String.format("online new status push code: %s, newStatus: %s, curStatus: %s, ext:%s", new Object[] { Integer.valueOf(n), paramForwardBody, paramTroopManager, Long.valueOf(l1) }));
        }
        if ((paramForwardBody == AppRuntime.Status.online) && (l1 == 1000L) && ((paramTroopManager != paramForwardBody) || (l1 != l3)))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.q();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramForwardBody, l1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "udc reset battery status");
          }
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
      }
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      bool1 = ThemeUtil.isNowThemeIsSimple(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
      if ((!bool1) && (aylf.a(String.valueOf(i2)))) {
        if (!ThemeSwitcher.a(String.valueOf(i2))) {
          ThemeSwitcher.a(String.valueOf(i2), "209", null);
        }
      }
      for (;;)
      {
        n = k;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.BaseMessageProcessor", 2, "theme online push " + paramForwardBody.uint32_field.get() + " themeId:" + i2 + " isSimpleMode：" + bool1);
        n = paramInt;
        paramInt = m;
        m = n;
        break label689;
        ayml.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(i2), "20000000");
      }
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramTroopManager = (ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63);
      if (paramTroopManager != null) {
        paramTroopManager.a(i2, 0, null, "onlinePush", -1);
      }
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, " bg online push " + paramForwardBody.uint32_field.get() + " bgId:" + i2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {
        if (paramForwardBody[0] == 0) {
          bool1 = true;
        }
      }
      for (;;)
      {
        aexd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(bool1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(104, true, Boolean.valueOf(bool1));
        n = k;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.msg.BaseMessageProcessor", 2, "handleModProfileBranch emotionRec flag:" + bool1);
        n = paramInt;
        paramInt = m;
        m = n;
        break label689;
        bool1 = false;
        continue;
        if (ByteBuffer.wrap(paramForwardBody).asShortBuffer().get() == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      label9982:
      SharedPreferences.Editor localEditor;
      if (paramForwardBody.length > 1) {
        if (paramForwardBody[1] == 1)
        {
          bool1 = true;
          QLog.e("vip_ptt.Q.msg.BaseMessageProcessor", 1, "it have receive push value:" + bool1);
          bool2 = bool1;
          if (bool1)
          {
            paramForwardBody = (amuf)ampm.a().a(442);
            bool2 = bool1;
            if (paramForwardBody != null)
            {
              bool2 = bool1;
              if (!paramForwardBody.a())
              {
                QLog.e("vip_ptt.Q.msg.BaseMessageProcessor", 1, "get ptt auto to txt push switch is true but config is close!!");
                bool2 = false;
              }
            }
          }
          paramForwardBody = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0);
          paramTroopManager = "businessinfo_ptt_auto_change_text_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          localObject = "businessinfo_ptt_auto_change_time_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          String str = "businessinfo_ptt_auto_change_guide_has_show_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          localEditor = paramForwardBody.edit();
          localEditor.putBoolean(paramTroopManager, bool2);
          l1 = NetConnInfoCenter.getServerTime();
          if (!bool2) {
            break label10257;
          }
          localEditor.putLong((String)localObject, l1);
          paramForwardBody.edit().putBoolean(str, true);
          label10218:
          localEditor.commit();
          adwv.d = bool2;
          adwv.a = l1;
        }
      }
      for (;;)
      {
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        bool1 = false;
        break label9982;
        label10257:
        localEditor.putLong((String)localObject, 9223372036854775807L);
        break label10218;
        QLog.e("vip_ptt.Q.msg.BaseMessageProcessor", 1, "it have receive push value is null");
        paramForwardBody = (ajtk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
        paramTroopManager = new ArrayList();
        paramTroopManager.add(Short.valueOf((short)-23249));
        paramForwardBody.a(paramTroopManager, null);
      }
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "handleModProfileBranch: invoked. c2c online push, field id: 27370, changed global ring id", " ringId: ", Integer.valueOf(n) });
      }
      amgc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(n);
      n = paramInt;
      paramInt = m;
      m = n;
      break label689;
      n = i1;
      if (m != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "Onlinepush hasDiyFontTimestamp: uin = " + l2 + " fontid = " + paramInt + " timestamp = " + k);
        }
        paramajxn = paramajxn.a(String.valueOf(l2));
        paramForwardBody = paramajxn;
        if (paramajxn == null)
        {
          paramForwardBody = new ExtensionInfo();
          paramForwardBody.uin = String.valueOf(l2);
        }
        m = paramInt;
        if (paramInt == 0) {
          m = (int)paramForwardBody.uVipFont;
        }
        ho.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l2), paramForwardBody, m, k);
        n = i1;
      }
      return n;
      i3 = -1;
      i2 = n;
      n = i3;
      continue;
      i2 = -1;
      n = -1;
    }
  }
  
  private MessageRecord a(MsgInfo paramMsgInfo, long paramLong)
  {
    paramMsgInfo = paramMsgInfo.vMsg;
    bbmj.a(paramMsgInfo, 0);
    int i = paramMsgInfo[4];
    bbmj.a(paramMsgInfo, 5);
    bbmj.a(paramMsgInfo, 9);
    bbmj.a(paramMsgInfo, 13);
    i = paramMsgInfo[17];
    bbmj.a(paramMsgInfo, 18);
    bbmj.a(paramMsgInfo, 22);
    bbmj.a(paramMsgInfo, 24);
    return null;
  }
  
  private void a(int paramInt)
  {
    ((akfw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramInt);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcReqPushMsg paramSvcReqPushMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a = paramSvcReqPushMsg.wUserActive;
    String str1;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    long l3;
    int n;
    ArrayList localArrayList4;
    label153:
    MsgInfo localMsgInfo;
    if ((paramSvcReqPushMsg.wGeneralFlag & 0x20) == 32)
    {
      bazk.a(true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "OnlinePush.ReqPush,notify.wUserActive:", Integer.valueOf(paramSvcReqPushMsg.wUserActive), ", muteGeneralFlag:", Integer.valueOf(paramSvcReqPushMsg.wGeneralFlag) });
      }
      str1 = (String)paramFromServiceMsg.getAttribute("_tag_LOGSTR");
      localArrayList1 = new ArrayList();
      localArrayList2 = paramSvcReqPushMsg.vMsgInfos;
      if ((localArrayList2 == null) || (localArrayList2.size() <= 0)) {
        break label2324;
      }
      localArrayList3 = new ArrayList();
      l3 = paramSvcReqPushMsg.lUin;
      n = paramSvcReqPushMsg.svrip;
      localArrayList4 = new ArrayList();
      Iterator localIterator = localArrayList2.iterator();
      if (!localIterator.hasNext()) {
        break label2095;
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
        j = localMsgInfo.shMsgType;
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
        ((ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(localMsgInfo.lFromUin);
        paramToServiceMsg.lFromUin = localMsgInfo.lFromUin;
        paramToServiceMsg.shMsgSeq = localMsgInfo.shMsgSeq;
        paramToServiceMsg.uMsgTime = localMsgInfo.uMsgTime;
        paramToServiceMsg.vMsgCookies = localMsgInfo.vMsgCookies;
        localArrayList3.add(paramToServiceMsg);
        if ((42 != j) && (83 != j) && (127 != j) && (QLog.isColorLevel())) {
          akau.a("Q.msg.BaseMessageProcessor", str1, localMsgInfo.shMsgSeq, String.valueOf(l3), String.valueOf(localMsgInfo.lFromUin));
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp  before analysis msgInfo.lFromUin: " + localMsgInfo.lFromUin + " msgInfo.shMsgType: " + localMsgInfo.shMsgType + " msgInfo.uRealMsgTime: " + localMsgInfo.uRealMsgTime + " msgInfo.shMsgSeq: " + localMsgInfo.shMsgSeq + ", msgInfo.lMsgUid" + localMsgInfo.lMsgUid);
        }
        if (!akqi.a().containsKey(Integer.valueOf(j))) {
          continue;
        }
        paramToServiceMsg = b(j, localMsgInfo, paramSvcReqPushMsg);
        if (paramToServiceMsg == null) {
          break label2258;
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
        QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp Exception msgInfo.vMsg: " + bbdm.a(localMsgInfo.vMsg));
        continue;
      }
      if (paramToServiceMsg != null)
      {
        localMessageRecord = axaq.a(i);
        if (j != 1006) {
          break label2065;
        }
        str2 = bbcl.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l2));
        localMessageRecord.init(String.valueOf(l3), bbcl.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1)), str2, paramToServiceMsg, localMsgInfo.uRealMsgTime, i, j, localMsgInfo.uMsgTime);
        localMessageRecord.shmsgseq = localMsgInfo.shMsgSeq;
        localMessageRecord.isread = bool1;
        localMessageRecord.msgUid = localMsgInfo.lMsgUid;
        localMessageRecord.msgData = ((byte[])localObject);
        if (k > 0) {
          localMessageRecord.extraflag = k;
        }
        if (!akau.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, true)) {
          localArrayList1.add(localMessageRecord);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp after analysis friendUin: " + l1 + " msgType: " + i + " friendType: " + j + " shMsgSeq: " + localMsgInfo.shMsgSeq + " msgContent: " + bbbd.a(paramToServiceMsg));
        }
      }
      if (localMsgInfo.uAppShareID <= 0L) {
        break label153;
      }
      localArrayList4.add(bbbo.a(localMsgInfo.uAppShareID));
      break label153;
      bazk.a(false);
      break;
      paramToServiceMsg = Long.valueOf(paramFromServiceMsg.getUin());
      continue;
      if (169 == j)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "------->msgFilter-handleC2COnlinePushMsgResp receive msg size:" + localArrayList2.size());
        }
        if (akau.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, String.valueOf(l1), String.valueOf(l2), localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq)) {
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
      if (8 == j)
      {
        paramToServiceMsg = new byte[4];
        if (localMsgInfo.vMsg.length > 4) {
          bbmj.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, 4);
        }
        l2 = bbmj.a(paramToServiceMsg, 0);
        if (localMsgInfo.vMsg.length >= 9)
        {
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 9];
          bbmj.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 8, paramToServiceMsg.length);
          paramToServiceMsg = new String(axas.a(paramToServiceMsg), "utf-8");
          break label2280;
        }
      }
      else
      {
        if (132 == j)
        {
          paramToServiceMsg = new byte[4];
          if (localMsgInfo.vMsg.length > 4) {
            bbmj.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, 4);
          }
          l2 = bbmj.a(paramToServiceMsg, 0);
          paramToServiceMsg = (ToServiceMsg)localObject;
          if (localMsgInfo.vMsg.length < 9) {
            break label2302;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 9];
          bbmj.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 8, paramToServiceMsg.length);
          paramToServiceMsg = new String(axas.a(paramToServiceMsg), "utf-8");
          break label2302;
        }
        if (732 == j)
        {
          if (localMsgInfo.vMsg == null) {
            return;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length];
          bbmj.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, paramToServiceMsg.length);
          i = paramToServiceMsg[4];
          if (!QLog.isColorLevel()) {
            break label2325;
          }
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<---0x2dc push  groupCode:" + bbmj.a(localMsgInfo.vMsg, 0) + " subType:" + i + "msgSeq:" + localMsgInfo.shMsgSeq);
          break label2325;
          label1367:
          if (localMsgInfo.vMsg.length <= 7) {
            break label2349;
          }
          paramToServiceMsg = (bamj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(81);
          localObject = new byte[localMsgInfo.vMsg.length - 7];
          bbmj.a((byte[])localObject, 0, localMsgInfo.vMsg, 7, localObject.length);
          paramToServiceMsg = paramToServiceMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte[])localObject, localMsgInfo.shMsgSeq, localMsgInfo.uRealMsgTime, false, false, null);
          if (paramToServiceMsg == null) {
            break label2349;
          }
          localArrayList1.add(paramToServiceMsg);
          break label2349;
          label1459:
          ((bakk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(paramToServiceMsg, localMsgInfo.shMsgSeq);
          break label2349;
          label1484:
          if (i == 15)
          {
            a(paramToServiceMsg, localMsgInfo.shMsgSeq);
            return;
          }
          if (i != 6) {
            break label2388;
          }
          i(paramToServiceMsg);
          break label2349;
          label1518:
          if (localMsgInfo.vMsg.length <= 7) {
            break label2349;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 7];
          bbmj.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 7, paramToServiceMsg.length);
          b(paramToServiceMsg, i);
          break label2349;
        }
        if (230 == j)
        {
          paramToServiceMsg = new String(axas.a(localMsgInfo.vMsg), "utf-8");
          localObject = ((ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(l1 + "");
          if ((localObject != null) && (((Friends)localObject).isFriend())) {}
          for (j = 0;; j = 1006)
          {
            label1645:
            localObject = new SafeMsg.SafeMoreInfo();
            ((SafeMsg.SafeMoreInfo)localObject).strFromMobile.set(localMsgInfo.strFromMobile);
            ((SafeMsg.SafeMoreInfo)localObject).strFromName.set(localMsgInfo.strFromName);
            ((SafeMsg.SafeMoreInfo)localObject).strMsgTxt.set(paramToServiceMsg);
            localObject = ((SafeMsg.SafeMoreInfo)localObject).toByteArray();
            i = -1002;
            k = -1;
            bool1 = true;
            break;
            localObject = ((askl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).b(String.valueOf(l2));
            if ((localObject == null) || (((String)localObject).length() == 0)) {
              break label2405;
            }
          }
        }
        if (SystemMsg.isSystemMessage(j))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(2);
          l1 = 9998L;
          i = -1006 - (j - 187);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(l3, localMsgInfo.lFromUin, j, i, localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq);
          bool1 = false;
          k = -1;
          localObject = null;
          paramToServiceMsg = null;
          j = 0;
          continue;
        }
        if (SystemMsg.isTroopSystemMessage(j))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(3);
          if (j == 45)
          {
            paramToServiceMsg = a(localMsgInfo, l3);
            if ((paramToServiceMsg == null) || (akau.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, true))) {
              break label2413;
            }
            localArrayList1.add(paramToServiceMsg);
            break label2413;
          }
        }
      }
      for (;;)
      {
        aydb.a().a(l2, localMsgInfo.uMsgTime, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        k = i;
        localObject = null;
        paramToServiceMsg = null;
        int m = 0;
        bool1 = false;
        i = j;
        j = m;
        break label514;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(j, localMsgInfo.vMsg, localMsgInfo.lFromUin, localMsgInfo.uMsgTime, null);
        l1 = 9998L;
        i = 32769;
        j = SystemMsg.getTroopSystemMsgType(j);
        continue;
        if (528 == j)
        {
          paramToServiceMsg = b(localMsgInfo, l4);
          if ((paramToServiceMsg == null) || (akau.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, true))) {
            break label2424;
          }
          localArrayList1.add(paramToServiceMsg);
          break label2424;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp msgtype: unknow msgType!!!");
        break;
        label2065:
        localMessageRecord.init(l3, l1, l2, paramToServiceMsg, localMsgInfo.uRealMsgTime, i, j, localMsgInfo.uMsgTime);
        break label587;
        label2095:
        if (localArrayList4.size() > 0) {
          a(localArrayList4);
        }
        i = paramFromServiceMsg.getRequestSsoSeq();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l3, localArrayList3, n, i, null);
        boolean bool2;
        if (localArrayList1.size() > 0)
        {
          bool2 = akau.a(localArrayList1);
          i = akpy.a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if ((!bool2) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {
            break label2247;
          }
        }
        label2247:
        for (bool1 = true;; bool1 = false)
        {
          paramToServiceMsg.a(localArrayList1, String.valueOf(l3), bool1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((int)paramSvcReqPushMsg.uMsgTime);
          a("handleGetBuddyMessageResp", true, i, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2), false);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localArrayList1);
          return;
        }
        paramToServiceMsg = null;
        break label2280;
        label2258:
        bool1 = false;
        k = -1;
        localObject = null;
        paramToServiceMsg = null;
        i = -1000;
        j = 0;
        break label514;
        label2280:
        j = 1000;
        i = -1000;
        k = -1;
        localObject = null;
        bool1 = false;
        break label514;
        label2302:
        j = 1020;
        i = -1000;
        k = -1;
        localObject = null;
        bool1 = false;
        break label514;
        label2324:
        return;
        label2325:
        if ((i == 16) || (i == 17)) {
          break label1367;
        }
        if (i == 20) {
          break label1367;
        }
        label2349:
        label2388:
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
        label2405:
        j = 1000;
        break label1645;
        label2413:
        i = -1;
        j = -1000;
      }
      label2424:
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
    paramArrayOfByte = aypf.a(paramArrayOfByte, paramArrayOfLong);
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
  
  private boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = false;
    long l1 = bbmj.a(paramArrayOfByte, 0);
    if (paramArrayOfByte[4] == 15)
    {
      long l2 = bbmj.a(paramArrayOfByte, 5);
      long l3 = bbmj.a(paramArrayOfByte, 9);
      int i = bbmj.b(paramArrayOfByte, 13);
      paramArrayOfByte = bbmj.a(paramArrayOfByte, 15, i);
      long l4 = NetConnInfoCenter.getServerTime();
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(paramInt, l1, l4, l3, l2, paramArrayOfByte);
      bool = true;
    }
    return bool;
  }
  
  private akqj b(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(akqi.a(paramInt)).a(akqi.a(paramInt), paramMsgInfo, paramSvcReqPushMsg);
  }
  
  /* Error */
  private MessageRecord b(MsgInfo paramMsgInfo, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 86
    //   8: iconst_2
    //   9: ldc_w 1502
    //   12: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_1
    //   16: getfield 1089	OnlinePushPack/MsgInfo:vMsg	[B
    //   19: invokestatic 1507	awzo:a	([B)LIMMsgBodyPack/MsgType0x210;
    //   22: astore 32
    //   24: aload 32
    //   26: ifnonnull +5 -> 31
    //   29: aconst_null
    //   30: areturn
    //   31: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +33 -> 67
    //   37: ldc 86
    //   39: iconst_2
    //   40: new 88	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   47: ldc_w 1509
    //   50: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload 32
    //   55: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   58: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   61: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: aload 32
    //   69: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   72: ldc2_w 1515
    //   75: lcmp
    //   76: ifne +140 -> 216
    //   79: aload 32
    //   81: getfield 1520	IMMsgBodyPack/MsgType0x210:stMsgInfo0x24	LIMMsgBodyPack/MsgType0x210SubMsgType0x24;
    //   84: ifnull +132 -> 216
    //   87: aload 32
    //   89: getfield 1520	IMMsgBodyPack/MsgType0x210:stMsgInfo0x24	LIMMsgBodyPack/MsgType0x210SubMsgType0x24;
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull -65 -> 29
    //   97: aload_1
    //   98: getfield 1525	IMMsgBodyPack/MsgType0x210SubMsgType0x24:vPluginNumList	Ljava/util/ArrayList;
    //   101: ifnull -72 -> 29
    //   104: aload_1
    //   105: getfield 1525	IMMsgBodyPack/MsgType0x210SubMsgType0x24:vPluginNumList	Ljava/util/ArrayList;
    //   108: astore 28
    //   110: aload 28
    //   112: ifnull -83 -> 29
    //   115: aload 28
    //   117: invokeinterface 1526 1 0
    //   122: ifle -93 -> 29
    //   125: aload_0
    //   126: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   129: bipush 12
    //   131: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   134: checkcast 1528	axbt
    //   137: astore_1
    //   138: aload_1
    //   139: ifnull -110 -> 29
    //   142: aload 28
    //   144: invokeinterface 51 1 0
    //   149: astore 28
    //   151: aload 28
    //   153: invokeinterface 56 1 0
    //   158: ifeq -129 -> 29
    //   161: aload 28
    //   163: invokeinterface 60 1 0
    //   168: checkcast 1530	IMMsgBodyPack/PluginNum
    //   171: astore 29
    //   173: aload 29
    //   175: ifnull -24 -> 151
    //   178: aload 29
    //   180: getfield 1533	IMMsgBodyPack/PluginNum:dwID	J
    //   183: lstore_2
    //   184: aload 29
    //   186: getfield 1537	IMMsgBodyPack/PluginNum:cFlag	B
    //   189: ifne +21 -> 210
    //   192: iconst_0
    //   193: istore 19
    //   195: aload_1
    //   196: lload_2
    //   197: iload 19
    //   199: aload 29
    //   201: getfield 1540	IMMsgBodyPack/PluginNum:dwNUm	J
    //   204: invokevirtual 1543	axbt:a	(JZJ)V
    //   207: goto -56 -> 151
    //   210: iconst_1
    //   211: istore 19
    //   213: goto -18 -> 195
    //   216: aload 32
    //   218: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   221: ifnull +16967 -> 17188
    //   224: aload 32
    //   226: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   229: ldc2_w 1547
    //   232: lcmp
    //   233: ifne +29 -> 262
    //   236: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq +12 -> 251
    //   242: ldc 86
    //   244: iconst_2
    //   245: ldc_w 1550
    //   248: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: aload_0
    //   252: aload 32
    //   254: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   257: invokevirtual 1552	akqf:a	([B)V
    //   260: aconst_null
    //   261: areturn
    //   262: aload 32
    //   264: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   267: ldc2_w 1553
    //   270: lcmp
    //   271: ifeq +27 -> 298
    //   274: aload 32
    //   276: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   279: ldc2_w 1555
    //   282: lcmp
    //   283: ifeq +15 -> 298
    //   286: aload 32
    //   288: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   291: ldc2_w 1557
    //   294: lcmp
    //   295: ifne +46 -> 341
    //   298: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq +13 -> 314
    //   304: ldc_w 1560
    //   307: iconst_2
    //   308: ldc_w 1562
    //   311: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: aload_0
    //   315: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   318: bipush 11
    //   320: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   323: checkcast 1564	com/tencent/mobileqq/app/PublicAccountHandler
    //   326: aload 32
    //   328: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   331: aload 32
    //   333: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   336: invokevirtual 1567	com/tencent/mobileqq/app/PublicAccountHandler:a	(J[B)V
    //   339: aconst_null
    //   340: areturn
    //   341: aload 32
    //   343: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   346: ldc2_w 1568
    //   349: lcmp
    //   350: ifne +41 -> 391
    //   353: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq +13 -> 369
    //   359: ldc_w 1571
    //   362: iconst_2
    //   363: ldc_w 1573
    //   366: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: aload_0
    //   370: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   373: bipush 18
    //   375: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   378: checkcast 1575	akgh
    //   381: aload 32
    //   383: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   386: invokevirtual 1576	akgh:a	([B)V
    //   389: aconst_null
    //   390: areturn
    //   391: aload 32
    //   393: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   396: ldc2_w 1577
    //   399: lcmp
    //   400: ifne +15 -> 415
    //   403: aload_0
    //   404: lload_2
    //   405: aload 32
    //   407: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   410: invokespecial 1580	akqf:b	(J[B)V
    //   413: aconst_null
    //   414: areturn
    //   415: aload 32
    //   417: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   420: ldc2_w 1581
    //   423: lcmp
    //   424: ifne +85 -> 509
    //   427: new 1584	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody
    //   430: dup
    //   431: invokespecial 1585	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody:<init>	()V
    //   434: aload 32
    //   436: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   439: invokevirtual 1589	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   442: checkcast 1584	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody
    //   445: getfield 1592	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody:uint32_bubble_timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   448: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   451: istore 4
    //   453: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq -427 -> 29
    //   459: ldc_w 520
    //   462: iconst_2
    //   463: new 88	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   470: ldc_w 1594
    //   473: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: iload 4
    //   478: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   481: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   487: aconst_null
    //   488: areturn
    //   489: astore_1
    //   490: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   493: ifeq -464 -> 29
    //   496: ldc_w 520
    //   499: iconst_2
    //   500: ldc_w 1596
    //   503: aload_1
    //   504: invokestatic 1599	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   507: aconst_null
    //   508: areturn
    //   509: aload 32
    //   511: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   514: ldc2_w 1600
    //   517: lcmp
    //   518: ifne +617 -> 1135
    //   521: new 1603	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody
    //   524: dup
    //   525: invokespecial 1604	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:<init>	()V
    //   528: astore 29
    //   530: aload 29
    //   532: aload 32
    //   534: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   537: invokevirtual 1605	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   540: pop
    //   541: aload 29
    //   543: getfield 1608	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   546: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   549: iconst_1
    //   550: if_icmpne -521 -> 29
    //   553: new 88	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   560: aload 29
    //   562: getfield 1611	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:uint64_from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   565: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   568: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   571: ldc 140
    //   573: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: astore_1
    //   580: new 88	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   587: aload 29
    //   589: getfield 1614	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:uint64_action_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   592: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   595: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   598: ldc 140
    //   600: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: astore 28
    //   608: aload 29
    //   610: getfield 1618	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:source	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   613: invokevirtual 1621	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   616: iconst_2
    //   617: if_icmpne +261 -> 878
    //   620: sipush 1001
    //   623: istore 4
    //   625: aload 29
    //   627: getfield 1625	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:bool_new_friend	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   630: invokevirtual 1629	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   633: ifeq +34 -> 667
    //   636: iconst_0
    //   637: istore 4
    //   639: aload_0
    //   640: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   643: iconst_1
    //   644: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   647: checkcast 211	com/tencent/mobileqq/app/FriendListHandler
    //   650: astore 30
    //   652: aload 30
    //   654: bipush 63
    //   656: iconst_1
    //   657: aload_1
    //   658: invokevirtual 1630	com/tencent/mobileqq/app/FriendListHandler:notifyUI	(IZLjava/lang/Object;)V
    //   661: aload 30
    //   663: aload_1
    //   664: invokevirtual 1631	com/tencent/mobileqq/app/FriendListHandler:b	(Ljava/lang/String;)V
    //   667: aload 29
    //   669: getfield 1634	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:rpt_msg_business_msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   672: invokevirtual 45	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   675: invokeinterface 51 1 0
    //   680: astore 29
    //   682: aload 29
    //   684: invokeinterface 56 1 0
    //   689: ifeq -660 -> 29
    //   692: aload 29
    //   694: invokeinterface 60 1 0
    //   699: checkcast 1636	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$BusinessMsg
    //   702: astore 30
    //   704: aload 30
    //   706: getfield 1639	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$BusinessMsg:msg_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   709: invokevirtual 1621	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   712: istore 5
    //   714: iload 5
    //   716: iconst_1
    //   717: if_icmpne +169 -> 886
    //   720: sipush -1000
    //   723: invokestatic 1219	axaq:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   726: checkcast 1641	com/tencent/mobileqq/data/MessageForText
    //   729: astore 31
    //   731: aload 31
    //   733: aload_1
    //   734: putfield 1644	com/tencent/mobileqq/data/MessageForText:frienduin	Ljava/lang/String;
    //   737: aload_0
    //   738: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   741: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   744: aload 28
    //   746: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   749: ifeq +9 -> 758
    //   752: aload 31
    //   754: iconst_1
    //   755: putfield 1647	com/tencent/mobileqq/data/MessageForText:issend	I
    //   758: aload 31
    //   760: aload_0
    //   761: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   764: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   767: aload_1
    //   768: aload 28
    //   770: aload 30
    //   772: getfield 1650	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$BusinessMsg:bytes_msg_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   775: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   778: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   781: invokestatic 581	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   784: sipush -1000
    //   787: iload 4
    //   789: aload_0
    //   790: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   793: invokevirtual 694	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   796: aload_1
    //   797: iload 4
    //   799: invokevirtual 1653	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;
    //   802: getfield 1656	com/tencent/mobileqq/app/message/QQMessageFacade$Message:shmsgseq	J
    //   805: lconst_1
    //   806: ladd
    //   807: invokevirtual 1657	com/tencent/mobileqq/data/MessageForText:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   810: aload 31
    //   812: iconst_0
    //   813: putfield 1658	com/tencent/mobileqq/data/MessageForText:isread	Z
    //   816: aload_0
    //   817: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   820: invokevirtual 694	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   823: aload 31
    //   825: aload_0
    //   826: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   829: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   832: invokevirtual 1661	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   835: goto -153 -> 682
    //   838: astore_1
    //   839: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   842: ifeq -813 -> 29
    //   845: ldc_w 1663
    //   848: iconst_2
    //   849: new 88	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   856: ldc_w 1665
    //   859: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: aload 32
    //   864: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   867: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   870: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   873: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   876: aconst_null
    //   877: areturn
    //   878: sipush 10002
    //   881: istore 4
    //   883: goto -258 -> 625
    //   886: iload 5
    //   888: iconst_2
    //   889: if_icmpne -207 -> 682
    //   892: aload 30
    //   894: getfield 1668	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$BusinessMsg:bool_tab_visible	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   897: invokevirtual 1629	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   900: istore 19
    //   902: aload 30
    //   904: getfield 1650	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$BusinessMsg:bytes_msg_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   907: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   910: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   913: astore 30
    //   915: iload 19
    //   917: ifeq +140 -> 1057
    //   920: sipush -5001
    //   923: invokestatic 1219	axaq:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   926: checkcast 1670	com/tencent/mobileqq/data/MessageForNewGrayTips
    //   929: astore 31
    //   931: aload 31
    //   933: aload_0
    //   934: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   937: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   940: aload_1
    //   941: aload_1
    //   942: aload 30
    //   944: invokestatic 581	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   947: sipush -5001
    //   950: iload 4
    //   952: lconst_1
    //   953: aload_0
    //   954: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   957: invokevirtual 694	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   960: aload_1
    //   961: iload 4
    //   963: invokevirtual 1653	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;
    //   966: getfield 1656	com/tencent/mobileqq/app/message/QQMessageFacade$Message:shmsgseq	J
    //   969: ladd
    //   970: invokevirtual 1671	com/tencent/mobileqq/data/MessageForNewGrayTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   973: aload 31
    //   975: iconst_1
    //   976: putfield 1672	com/tencent/mobileqq/data/MessageForNewGrayTips:isread	Z
    //   979: aload 31
    //   981: iconst_1
    //   982: putfield 1675	com/tencent/mobileqq/data/MessageForNewGrayTips:mNeedTimeStamp	Z
    //   985: aload 31
    //   987: invokevirtual 1678	com/tencent/mobileqq/data/MessageForNewGrayTips:updateMsgData	()V
    //   990: aload_0
    //   991: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   994: invokevirtual 694	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   997: aload 31
    //   999: aload_0
    //   1000: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1003: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1006: invokevirtual 1661	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   1009: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1012: ifeq -330 -> 682
    //   1015: ldc_w 1663
    //   1018: iconst_2
    //   1019: new 88	java/lang/StringBuilder
    //   1022: dup
    //   1023: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   1026: ldc_w 1680
    //   1029: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: iload 19
    //   1034: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1037: ldc_w 1682
    //   1040: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1043: aload 30
    //   1045: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1051: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1054: goto -372 -> 682
    //   1057: sipush -5000
    //   1060: invokestatic 1219	axaq:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1063: astore 31
    //   1065: aload 31
    //   1067: aload_0
    //   1068: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1071: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1074: aload_1
    //   1075: aload_1
    //   1076: aload 30
    //   1078: invokestatic 581	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   1081: sipush -5000
    //   1084: iload 4
    //   1086: lconst_1
    //   1087: aload_0
    //   1088: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1091: invokevirtual 694	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1094: aload_1
    //   1095: iload 4
    //   1097: invokevirtual 1653	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;
    //   1100: getfield 1656	com/tencent/mobileqq/app/message/QQMessageFacade$Message:shmsgseq	J
    //   1103: ladd
    //   1104: invokevirtual 1231	com/tencent/mobileqq/data/MessageRecord:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   1107: aload 31
    //   1109: iconst_1
    //   1110: putfield 1237	com/tencent/mobileqq/data/MessageRecord:isread	Z
    //   1113: aload_0
    //   1114: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1117: invokevirtual 694	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1120: aload 31
    //   1122: aload_0
    //   1123: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1126: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1129: invokevirtual 1661	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   1132: goto -123 -> 1009
    //   1135: aload 32
    //   1137: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1140: ldc2_w 1683
    //   1143: lcmp
    //   1144: ifne +315 -> 1459
    //   1147: new 1686	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody
    //   1150: dup
    //   1151: invokespecial 1687	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:<init>	()V
    //   1154: astore 28
    //   1156: aload 28
    //   1158: aload 32
    //   1160: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1163: invokevirtual 1688	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1166: pop
    //   1167: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1170: ifeq +111 -> 1281
    //   1173: new 88	java/lang/StringBuilder
    //   1176: dup
    //   1177: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   1180: ldc_w 1690
    //   1183: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: astore 29
    //   1188: aload 28
    //   1190: getfield 1693	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1193: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1196: ifeq +251 -> 1447
    //   1199: aload 28
    //   1201: getfield 1693	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1204: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1207: invokestatic 495	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1210: astore_1
    //   1211: aload 29
    //   1213: aload_1
    //   1214: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: ldc_w 1695
    //   1220: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1223: astore 29
    //   1225: aload 28
    //   1227: getfield 1698	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1230: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1233: ifeq +220 -> 1453
    //   1236: aload 28
    //   1238: getfield 1698	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1241: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1244: invokestatic 959	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1247: astore_1
    //   1248: ldc_w 1700
    //   1251: iconst_2
    //   1252: aload 29
    //   1254: aload_1
    //   1255: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1258: ldc_w 1702
    //   1261: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: aload 28
    //   1266: getfield 1705	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_member_level_changed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1269: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1272: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1275: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1278: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1281: aload 28
    //   1283: getfield 1693	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1286: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1289: ifeq -1260 -> 29
    //   1292: aload 28
    //   1294: getfield 1698	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1297: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1300: ifeq +87 -> 1387
    //   1303: aload 28
    //   1305: getfield 1698	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1308: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1311: istore 4
    //   1313: aload 28
    //   1315: getfield 1693	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1318: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1321: invokestatic 495	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1324: astore_1
    //   1325: aload_0
    //   1326: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1329: bipush 52
    //   1331: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1334: checkcast 1484	com/tencent/mobileqq/app/TroopManager
    //   1337: astore 29
    //   1339: aload 29
    //   1341: aload_1
    //   1342: invokevirtual 1708	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   1345: astore 30
    //   1347: aload 30
    //   1349: iload 4
    //   1351: i2b
    //   1352: putfield 1713	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   1355: aload 29
    //   1357: aload 30
    //   1359: invokevirtual 1716	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   1362: iconst_1
    //   1363: aload 30
    //   1365: getfield 1713	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   1368: if_icmpne +19 -> 1387
    //   1371: aload_0
    //   1372: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1375: bipush 20
    //   1377: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   1380: checkcast 1718	akhq
    //   1383: aload_1
    //   1384: invokevirtual 1720	akhq:f	(Ljava/lang/String;)V
    //   1387: aload 28
    //   1389: getfield 1705	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_member_level_changed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1392: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1395: ifeq -1366 -> 29
    //   1398: aload 28
    //   1400: getfield 1693	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1403: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1406: lstore_2
    //   1407: aload_0
    //   1408: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1411: bipush 20
    //   1413: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   1416: checkcast 1718	akhq
    //   1419: lload_2
    //   1420: invokestatic 495	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1423: invokevirtual 1720	akhq:f	(Ljava/lang/String;)V
    //   1426: aconst_null
    //   1427: areturn
    //   1428: astore_1
    //   1429: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1432: ifeq -1403 -> 29
    //   1435: ldc_w 1700
    //   1438: iconst_2
    //   1439: ldc_w 1722
    //   1442: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1445: aconst_null
    //   1446: areturn
    //   1447: ldc 140
    //   1449: astore_1
    //   1450: goto -239 -> 1211
    //   1453: ldc 140
    //   1455: astore_1
    //   1456: goto -208 -> 1248
    //   1459: aload 32
    //   1461: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1464: ldc2_w 1723
    //   1467: lcmp
    //   1468: ifne +25 -> 1493
    //   1471: aload_0
    //   1472: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1475: bipush 17
    //   1477: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1480: checkcast 446	ayah
    //   1483: aload 32
    //   1485: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1488: invokevirtual 1725	ayah:a	([B)V
    //   1491: aconst_null
    //   1492: areturn
    //   1493: aload 32
    //   1495: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1498: ldc2_w 1726
    //   1501: lcmp
    //   1502: ifne +17 -> 1519
    //   1505: aload_0
    //   1506: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1509: aload 32
    //   1511: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1514: invokestatic 1732	ajuf:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   1517: aconst_null
    //   1518: areturn
    //   1519: aload 32
    //   1521: ifnull +35 -> 1556
    //   1524: aload 32
    //   1526: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1529: ldc2_w 1733
    //   1532: lcmp
    //   1533: ifne +23 -> 1556
    //   1536: aload 32
    //   1538: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1541: ifnull +15 -> 1556
    //   1544: aload_0
    //   1545: lload_2
    //   1546: aload 32
    //   1548: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1551: invokevirtual 1735	akqf:a	(J[B)V
    //   1554: aconst_null
    //   1555: areturn
    //   1556: aload 32
    //   1558: ifnull +35 -> 1593
    //   1561: aload 32
    //   1563: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1566: ldc2_w 1736
    //   1569: lcmp
    //   1570: ifne +23 -> 1593
    //   1573: aload 32
    //   1575: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1578: ifnull +15 -> 1593
    //   1581: aload_0
    //   1582: aload 32
    //   1584: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1587: invokevirtual 1738	akqf:a	([B)Ljava/lang/String;
    //   1590: pop
    //   1591: aconst_null
    //   1592: areturn
    //   1593: aload 32
    //   1595: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1598: ldc2_w 1739
    //   1601: lcmp
    //   1602: ifne +22 -> 1624
    //   1605: aload 32
    //   1607: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1610: ifnull +14 -> 1624
    //   1613: aload_0
    //   1614: aload 32
    //   1616: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1619: invokespecial 1742	akqf:f	([B)V
    //   1622: aconst_null
    //   1623: areturn
    //   1624: aload 32
    //   1626: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1629: ldc2_w 1743
    //   1632: lcmp
    //   1633: ifne +22 -> 1655
    //   1636: aload 32
    //   1638: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1641: ifnull +14 -> 1655
    //   1644: aload_0
    //   1645: aload 32
    //   1647: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1650: invokevirtual 1746	akqf:b	([B)V
    //   1653: aconst_null
    //   1654: areturn
    //   1655: aload 32
    //   1657: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1660: ldc2_w 1747
    //   1663: lcmp
    //   1664: ifne +22 -> 1686
    //   1667: aload 32
    //   1669: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1672: ifnull +14 -> 1686
    //   1675: aload_0
    //   1676: aload 32
    //   1678: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1681: invokespecial 1751	akqf:g	([B)V
    //   1684: aconst_null
    //   1685: areturn
    //   1686: aload 32
    //   1688: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1691: ldc2_w 1752
    //   1694: lcmp
    //   1695: ifne +22 -> 1717
    //   1698: aload 32
    //   1700: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1703: ifnull +14 -> 1717
    //   1706: aload_0
    //   1707: aload 32
    //   1709: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1712: invokespecial 1756	akqf:h	([B)V
    //   1715: aconst_null
    //   1716: areturn
    //   1717: aload 32
    //   1719: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1722: ldc2_w 1757
    //   1725: lcmp
    //   1726: ifne +14 -> 1740
    //   1729: aload_0
    //   1730: aload 32
    //   1732: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1735: invokevirtual 1760	akqf:d	([B)V
    //   1738: aconst_null
    //   1739: areturn
    //   1740: aload 32
    //   1742: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1745: ldc2_w 1761
    //   1748: lcmp
    //   1749: ifne +14 -> 1763
    //   1752: aload_0
    //   1753: aload 32
    //   1755: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1758: invokevirtual 1764	akqf:e	([B)V
    //   1761: aconst_null
    //   1762: areturn
    //   1763: aload 32
    //   1765: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1768: ldc2_w 1765
    //   1771: lcmp
    //   1772: ifne +22 -> 1794
    //   1775: aload 32
    //   1777: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1780: ifnull +14 -> 1794
    //   1783: aload_0
    //   1784: aload 32
    //   1786: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1789: invokevirtual 1768	akqf:c	([B)V
    //   1792: aconst_null
    //   1793: areturn
    //   1794: aload 32
    //   1796: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1799: ldc2_w 1769
    //   1802: lcmp
    //   1803: ifne +311 -> 2114
    //   1806: aload 32
    //   1808: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1811: ifnull +303 -> 2114
    //   1814: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1817: ifeq +13 -> 1830
    //   1820: ldc_w 1772
    //   1823: iconst_2
    //   1824: ldc_w 1774
    //   1827: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1830: new 1776	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock
    //   1833: dup
    //   1834: invokespecial 1777	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:<init>	()V
    //   1837: astore_1
    //   1838: aload_1
    //   1839: aload 32
    //   1841: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1844: invokevirtual 1778	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1847: pop
    //   1848: new 325	android/content/Intent
    //   1851: dup
    //   1852: invokespecial 1779	android/content/Intent:<init>	()V
    //   1855: astore 28
    //   1857: aload 28
    //   1859: ldc_w 1781
    //   1862: aload_1
    //   1863: getfield 1783	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:canCancel	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   1866: invokevirtual 1629	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   1869: invokevirtual 335	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1872: pop
    //   1873: aload 28
    //   1875: ldc_w 1785
    //   1878: aload_1
    //   1879: getfield 1788	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1882: invokevirtual 1790	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1885: invokevirtual 474	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1888: pop
    //   1889: aload 28
    //   1891: ldc_w 1792
    //   1894: aload_1
    //   1895: getfield 1795	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1898: invokevirtual 1790	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1901: invokevirtual 474	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1904: pop
    //   1905: aload 28
    //   1907: ldc_w 1797
    //   1910: aload_1
    //   1911: getfield 1800	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_second_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1914: invokevirtual 1790	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1917: invokevirtual 474	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1920: pop
    //   1921: aload 28
    //   1923: ldc_w 1802
    //   1926: aload_1
    //   1927: getfield 1805	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_third_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1930: invokevirtual 1790	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1933: invokevirtual 474	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1936: pop
    //   1937: aload_1
    //   1938: getfield 1809	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_wording_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1941: invokevirtual 1812	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   1944: astore 29
    //   1946: new 655	java/util/ArrayList
    //   1949: dup
    //   1950: invokespecial 656	java/util/ArrayList:<init>	()V
    //   1953: astore 30
    //   1955: aload 29
    //   1957: ifnull +21 -> 1978
    //   1960: aload 29
    //   1962: invokeinterface 1526 1 0
    //   1967: ifle +11 -> 1978
    //   1970: aload 30
    //   1972: aload 29
    //   1974: invokevirtual 1816	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   1977: pop
    //   1978: aload 28
    //   1980: ldc_w 1818
    //   1983: aload 30
    //   1985: invokevirtual 1822	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   1988: pop
    //   1989: aload_0
    //   1990: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1993: aload 28
    //   1995: invokevirtual 1825	com/tencent/mobileqq/app/QQAppInterface:setDevLockIntent	(Landroid/content/Intent;)V
    //   1998: aload_0
    //   1999: sipush 8007
    //   2002: iconst_1
    //   2003: bipush 6
    //   2005: anewarray 220	java/lang/Object
    //   2008: dup
    //   2009: iconst_0
    //   2010: aload_1
    //   2011: getfield 1783	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:canCancel	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   2014: invokevirtual 1629	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   2017: invokestatic 1007	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2020: aastore
    //   2021: dup
    //   2022: iconst_1
    //   2023: aload_1
    //   2024: getfield 1788	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2027: invokevirtual 1790	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2030: aastore
    //   2031: dup
    //   2032: iconst_2
    //   2033: aload_1
    //   2034: getfield 1795	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2037: invokevirtual 1790	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2040: aastore
    //   2041: dup
    //   2042: iconst_3
    //   2043: aload_1
    //   2044: getfield 1800	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_second_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2047: invokevirtual 1790	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2050: aastore
    //   2051: dup
    //   2052: iconst_4
    //   2053: aload_1
    //   2054: getfield 1805	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_third_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2057: invokevirtual 1790	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2060: aastore
    //   2061: dup
    //   2062: iconst_5
    //   2063: aload 30
    //   2065: aastore
    //   2066: invokevirtual 1827	akqf:a	(IZLjava/lang/Object;)V
    //   2069: aconst_null
    //   2070: areturn
    //   2071: astore_1
    //   2072: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2075: ifeq +13 -> 2088
    //   2078: ldc_w 1772
    //   2081: iconst_2
    //   2082: ldc_w 1829
    //   2085: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2088: aload_0
    //   2089: sipush 8007
    //   2092: iconst_0
    //   2093: iconst_2
    //   2094: anewarray 220	java/lang/Object
    //   2097: dup
    //   2098: iconst_0
    //   2099: iconst_1
    //   2100: invokestatic 1007	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2103: aastore
    //   2104: dup
    //   2105: iconst_1
    //   2106: ldc 140
    //   2108: aastore
    //   2109: invokevirtual 1827	akqf:a	(IZLjava/lang/Object;)V
    //   2112: aconst_null
    //   2113: areturn
    //   2114: aload 32
    //   2116: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2119: ldc2_w 1830
    //   2122: lcmp
    //   2123: ifne +327 -> 2450
    //   2126: aload 32
    //   2128: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2131: ifnull +319 -> 2450
    //   2134: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2137: ifeq +13 -> 2150
    //   2140: ldc_w 1772
    //   2143: iconst_2
    //   2144: ldc_w 1833
    //   2147: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2150: new 1835	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody
    //   2153: dup
    //   2154: invokespecial 1836	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:<init>	()V
    //   2157: pop
    //   2158: aconst_null
    //   2159: astore 28
    //   2161: aconst_null
    //   2162: astore 29
    //   2164: aconst_null
    //   2165: astore 30
    //   2167: aconst_null
    //   2168: astore 31
    //   2170: new 1835	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody
    //   2173: dup
    //   2174: invokespecial 1836	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:<init>	()V
    //   2177: astore 33
    //   2179: aload 33
    //   2181: aload 32
    //   2183: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2186: invokevirtual 1837	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2189: pop
    //   2190: aload 33
    //   2192: getfield 1840	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_qrsig_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2195: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2198: ifeq +26 -> 2224
    //   2201: new 274	java/lang/String
    //   2204: dup
    //   2205: aload 33
    //   2207: getfield 1840	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_qrsig_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2210: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2213: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2216: ldc_w 1322
    //   2219: invokespecial 1325	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2222: astore 28
    //   2224: aload 33
    //   2226: getfield 1843	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint1	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2229: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2232: ifeq +26 -> 2258
    //   2235: new 274	java/lang/String
    //   2238: dup
    //   2239: aload 33
    //   2241: getfield 1843	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint1	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2244: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2247: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2250: ldc_w 1322
    //   2253: invokespecial 1325	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2256: astore 29
    //   2258: aload 33
    //   2260: getfield 1846	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint2	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2263: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2266: ifeq +26 -> 2292
    //   2269: new 274	java/lang/String
    //   2272: dup
    //   2273: aload 33
    //   2275: getfield 1846	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint2	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2278: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2281: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2284: ldc_w 1322
    //   2287: invokespecial 1325	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2290: astore 30
    //   2292: aload 33
    //   2294: getfield 1849	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_login_conf	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2297: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2300: ifeq +16 -> 2316
    //   2303: aload 33
    //   2305: getfield 1849	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_login_conf	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2308: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2311: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2314: astore 31
    //   2316: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2319: ifeq +53 -> 2372
    //   2322: ldc_w 1772
    //   2325: iconst_2
    //   2326: new 88	java/lang/StringBuilder
    //   2329: dup
    //   2330: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   2333: ldc_w 1851
    //   2336: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2339: aload 28
    //   2341: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2344: ldc_w 1853
    //   2347: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2350: aload 29
    //   2352: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2355: ldc_w 1855
    //   2358: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2361: aload 30
    //   2363: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2366: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2369: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2372: invokestatic 1860	aoen:a	()Laoen;
    //   2375: aload_0
    //   2376: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2379: aload 28
    //   2381: aload 29
    //   2383: aload 30
    //   2385: aload 31
    //   2387: invokevirtual 1863	aoen:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V
    //   2390: aload_1
    //   2391: getfield 1143	OnlinePushPack/MsgInfo:lFromUin	J
    //   2394: lstore_2
    //   2395: aload_1
    //   2396: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   2399: istore 4
    //   2401: aload_1
    //   2402: getfield 1194	OnlinePushPack/MsgInfo:lMsgUid	J
    //   2405: lstore 15
    //   2407: aload_1
    //   2408: getfield 1140	OnlinePushPack/MsgInfo:shMsgType	S
    //   2411: istore 5
    //   2413: aload_0
    //   2414: getfield 1456	akqf:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2417: lload_2
    //   2418: iload 4
    //   2420: lload 15
    //   2422: iload 5
    //   2424: invokestatic 1868	axao:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   2427: aconst_null
    //   2428: areturn
    //   2429: astore 28
    //   2431: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2434: ifeq -44 -> 2390
    //   2437: ldc_w 1772
    //   2440: iconst_2
    //   2441: ldc_w 1870
    //   2444: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2447: goto -57 -> 2390
    //   2450: aload 32
    //   2452: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2455: ldc2_w 1871
    //   2458: lcmp
    //   2459: ifne +33 -> 2492
    //   2462: aload 32
    //   2464: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2467: ifnull +25 -> 2492
    //   2470: aload_0
    //   2471: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2474: bipush 24
    //   2476: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   2479: checkcast 1874	akga
    //   2482: aload 32
    //   2484: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2487: invokevirtual 1875	akga:a	([B)V
    //   2490: aconst_null
    //   2491: areturn
    //   2492: aload 32
    //   2494: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2497: ldc2_w 1876
    //   2500: lcmp
    //   2501: ifne +221 -> 2722
    //   2504: aload 32
    //   2506: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2509: ifnull +213 -> 2722
    //   2512: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2515: ifeq +13 -> 2528
    //   2518: ldc_w 1879
    //   2521: iconst_2
    //   2522: ldc_w 1881
    //   2525: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2528: aload_0
    //   2529: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2532: iconst_4
    //   2533: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   2536: checkcast 1729	ajuf
    //   2539: astore_1
    //   2540: aload_1
    //   2541: ifnull -2512 -> 29
    //   2544: new 1883	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody
    //   2547: dup
    //   2548: invokespecial 1884	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:<init>	()V
    //   2551: astore 28
    //   2553: aload 28
    //   2555: aload 32
    //   2557: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2560: invokevirtual 1885	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2563: pop
    //   2564: aload 28
    //   2566: getfield 1888	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:peer_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   2569: invokevirtual 1621	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   2572: istore 4
    //   2574: aload 28
    //   2576: getfield 1891	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:task_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2579: invokevirtual 45	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2582: astore 30
    //   2584: new 655	java/util/ArrayList
    //   2587: dup
    //   2588: invokespecial 656	java/util/ArrayList:<init>	()V
    //   2591: astore 29
    //   2593: aload 30
    //   2595: ifnull +87 -> 2682
    //   2598: aload 30
    //   2600: invokeinterface 1526 1 0
    //   2605: ifle +77 -> 2682
    //   2608: aload 30
    //   2610: invokeinterface 51 1 0
    //   2615: astore 30
    //   2617: aload 30
    //   2619: invokeinterface 56 1 0
    //   2624: ifeq +58 -> 2682
    //   2627: aload 30
    //   2629: invokeinterface 60 1 0
    //   2634: checkcast 1893	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody$TaskInfo
    //   2637: astore 31
    //   2639: new 1895	com/tencent/mobileqq/config/operation/QQOperationViopTipTask
    //   2642: dup
    //   2643: invokespecial 1896	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:<init>	()V
    //   2646: astore 32
    //   2648: aload 32
    //   2650: aload 31
    //   2652: getfield 1899	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody$TaskInfo:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2655: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2658: putfield 1902	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:taskid	I
    //   2661: aload 29
    //   2663: aload 32
    //   2665: invokevirtual 657	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2668: pop
    //   2669: goto -52 -> 2617
    //   2672: astore 29
    //   2674: aload 29
    //   2676: invokevirtual 1903	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   2679: goto -115 -> 2564
    //   2682: aload 28
    //   2684: getfield 1906	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:peer_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2687: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2690: lstore_2
    //   2691: iload 4
    //   2693: iconst_1
    //   2694: if_icmpne +20 -> 2714
    //   2697: iconst_0
    //   2698: istore 4
    //   2700: aload_1
    //   2701: lload_2
    //   2702: invokestatic 495	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2705: iload 4
    //   2707: aload 29
    //   2709: invokevirtual 1909	ajuf:a	(Ljava/lang/String;ILjava/util/ArrayList;)V
    //   2712: aconst_null
    //   2713: areturn
    //   2714: sipush 3000
    //   2717: istore 4
    //   2719: goto -19 -> 2700
    //   2722: aload 32
    //   2724: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2727: ldc2_w 1910
    //   2730: lcmp
    //   2731: ifne +21 -> 2752
    //   2734: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2737: ifeq -2708 -> 29
    //   2740: ldc_w 520
    //   2743: iconst_2
    //   2744: ldc_w 1913
    //   2747: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2750: aconst_null
    //   2751: areturn
    //   2752: aload 32
    //   2754: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2757: ldc2_w 1914
    //   2760: lcmp
    //   2761: ifne +160 -> 2921
    //   2764: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2767: ifeq +44 -> 2811
    //   2770: new 88	java/lang/StringBuilder
    //   2773: dup
    //   2774: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   2777: ldc_w 1917
    //   2780: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2783: astore_1
    //   2784: aload 32
    //   2786: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2789: ifnull +84 -> 2873
    //   2792: iconst_1
    //   2793: istore 19
    //   2795: ldc_w 1919
    //   2798: iconst_2
    //   2799: aload_1
    //   2800: iload 19
    //   2802: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2805: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2808: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2811: new 1921	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody
    //   2814: dup
    //   2815: invokespecial 1922	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:<init>	()V
    //   2818: astore_1
    //   2819: aload_1
    //   2820: aload 32
    //   2822: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2825: invokevirtual 1923	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2828: pop
    //   2829: aload_1
    //   2830: getfield 1926	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:rpt_msg_grpinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2833: invokevirtual 1927	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   2836: ifeq -2807 -> 29
    //   2839: aload_1
    //   2840: getfield 1926	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:rpt_msg_grpinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2843: invokevirtual 45	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2846: astore_1
    //   2847: aload_0
    //   2848: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2851: iconst_3
    //   2852: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   2855: checkcast 1929	ajzl
    //   2858: astore 28
    //   2860: aload 28
    //   2862: ifnull -2833 -> 29
    //   2865: aload 28
    //   2867: aload_1
    //   2868: invokevirtual 1932	ajzl:a	(Ljava/util/List;)V
    //   2871: aconst_null
    //   2872: areturn
    //   2873: iconst_0
    //   2874: istore 19
    //   2876: goto -81 -> 2795
    //   2879: astore 28
    //   2881: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2884: ifeq -55 -> 2829
    //   2887: ldc_w 1919
    //   2890: iconst_2
    //   2891: new 88	java/lang/StringBuilder
    //   2894: dup
    //   2895: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   2898: ldc_w 1934
    //   2901: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2904: aload 28
    //   2906: invokevirtual 1935	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   2909: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2912: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2915: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2918: goto -89 -> 2829
    //   2921: aload 32
    //   2923: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2926: ldc2_w 1936
    //   2929: lcmp
    //   2930: ifne +27 -> 2957
    //   2933: aload_0
    //   2934: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2937: bipush 22
    //   2939: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2942: checkcast 1939	akfd
    //   2945: astore_1
    //   2946: aload_1
    //   2947: ifnull -2918 -> 29
    //   2950: aload_1
    //   2951: invokevirtual 1940	akfd:a	()Z
    //   2954: pop
    //   2955: aconst_null
    //   2956: areturn
    //   2957: aload 32
    //   2959: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2962: ldc2_w 1941
    //   2965: lcmp
    //   2966: ifne +90 -> 3056
    //   2969: aload 32
    //   2971: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2974: ifnull +82 -> 3056
    //   2977: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2980: ifeq +13 -> 2993
    //   2983: ldc_w 520
    //   2986: iconst_2
    //   2987: ldc_w 1944
    //   2990: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2993: aload_0
    //   2994: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2997: ldc_w 1946
    //   3000: ldc 140
    //   3002: ldc 140
    //   3004: ldc_w 1948
    //   3007: ldc_w 1948
    //   3010: iconst_0
    //   3011: iconst_0
    //   3012: ldc 140
    //   3014: ldc 140
    //   3016: ldc 140
    //   3018: ldc 140
    //   3020: invokestatic 1953	axqw:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3023: new 1955	tencent/im/s2c/msgtype0x210/submsgtype0x63/submsgtype0x63$MsgBody
    //   3026: dup
    //   3027: invokespecial 1956	tencent/im/s2c/msgtype0x210/submsgtype0x63/submsgtype0x63$MsgBody:<init>	()V
    //   3030: pop
    //   3031: new 1958	lxv
    //   3034: dup
    //   3035: invokestatic 1959	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3038: invokespecial 1962	lxv:<init>	(Landroid/content/Context;)V
    //   3041: new 1964	akqg
    //   3044: dup
    //   3045: aload_0
    //   3046: aload 32
    //   3048: invokespecial 1967	akqg:<init>	(Lakqf;LIMMsgBodyPack/MsgType0x210;)V
    //   3051: invokevirtual 1970	lxv:a	(Llxw;)V
    //   3054: aconst_null
    //   3055: areturn
    //   3056: aload 32
    //   3058: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3061: ldc2_w 1971
    //   3064: lcmp
    //   3065: ifne +57 -> 3122
    //   3068: aload 32
    //   3070: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3073: ifnull +49 -> 3122
    //   3076: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3079: ifeq +13 -> 3092
    //   3082: ldc_w 1974
    //   3085: iconst_2
    //   3086: ldc_w 1976
    //   3089: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3092: aload_0
    //   3093: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3096: aload 32
    //   3098: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3101: aload_1
    //   3102: getfield 1143	OnlinePushPack/MsgInfo:lFromUin	J
    //   3105: aload_1
    //   3106: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3109: aload_1
    //   3110: getfield 1194	OnlinePushPack/MsgInfo:lMsgUid	J
    //   3113: aload_1
    //   3114: getfield 1140	OnlinePushPack/MsgInfo:shMsgType	S
    //   3117: invokestatic 1981	agxa:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BJIJI)V
    //   3120: aconst_null
    //   3121: areturn
    //   3122: aload 32
    //   3124: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3127: ldc2_w 1982
    //   3130: lcmp
    //   3131: ifne +25 -> 3156
    //   3134: aload 32
    //   3136: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3139: ifnull +17 -> 3156
    //   3142: aload_0
    //   3143: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3146: aload 32
    //   3148: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3151: invokestatic 1986	aeyo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   3154: aconst_null
    //   3155: areturn
    //   3156: aload 32
    //   3158: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3161: ldc2_w 1987
    //   3164: lcmp
    //   3165: ifne +57 -> 3222
    //   3168: aload 32
    //   3170: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3173: ifnull +49 -> 3222
    //   3176: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3179: ifeq +13 -> 3192
    //   3182: ldc_w 1974
    //   3185: iconst_2
    //   3186: ldc_w 1990
    //   3189: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3192: aload_0
    //   3193: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3196: aload 32
    //   3198: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3201: aload_1
    //   3202: getfield 1143	OnlinePushPack/MsgInfo:lFromUin	J
    //   3205: aload_1
    //   3206: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3209: aload_1
    //   3210: getfield 1194	OnlinePushPack/MsgInfo:lMsgUid	J
    //   3213: aload_1
    //   3214: getfield 1140	OnlinePushPack/MsgInfo:shMsgType	S
    //   3217: invokestatic 1992	agxa:b	(Lcom/tencent/mobileqq/app/QQAppInterface;[BJIJI)V
    //   3220: aconst_null
    //   3221: areturn
    //   3222: aload 32
    //   3224: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3227: ldc2_w 1993
    //   3230: lcmp
    //   3231: ifne +81 -> 3312
    //   3234: aload 32
    //   3236: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3239: ifnull +73 -> 3312
    //   3242: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3245: ifeq +13 -> 3258
    //   3248: ldc_w 1996
    //   3251: iconst_2
    //   3252: ldc_w 1998
    //   3255: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3258: aload_0
    //   3259: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3262: aload 32
    //   3264: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3267: invokestatic 1999	axao:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   3270: aload_1
    //   3271: getfield 1143	OnlinePushPack/MsgInfo:lFromUin	J
    //   3274: lstore_2
    //   3275: aload_1
    //   3276: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3279: istore 4
    //   3281: aload_1
    //   3282: getfield 1194	OnlinePushPack/MsgInfo:lMsgUid	J
    //   3285: lstore 15
    //   3287: aload_1
    //   3288: getfield 1140	OnlinePushPack/MsgInfo:shMsgType	S
    //   3291: istore 5
    //   3293: aload_0
    //   3294: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3297: invokevirtual 1284	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/MessageHandler;
    //   3300: lload_2
    //   3301: iload 4
    //   3303: lload 15
    //   3305: iload 5
    //   3307: invokestatic 1868	axao:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   3310: aconst_null
    //   3311: areturn
    //   3312: aload 32
    //   3314: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3317: ldc2_w 2000
    //   3320: lcmp
    //   3321: ifne +433 -> 3754
    //   3324: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3327: ifeq +13 -> 3340
    //   3330: ldc_w 2003
    //   3333: iconst_2
    //   3334: ldc_w 1998
    //   3337: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3340: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3343: ifeq +13 -> 3356
    //   3346: ldc_w 2005
    //   3349: iconst_2
    //   3350: ldc_w 2007
    //   3353: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3356: new 2009	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody
    //   3359: dup
    //   3360: invokespecial 2010	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:<init>	()V
    //   3363: astore 31
    //   3365: aload 31
    //   3367: aload 32
    //   3369: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3372: invokevirtual 2011	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3375: pop
    //   3376: aload 31
    //   3378: getfield 2014	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:uint64_to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3381: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   3384: lstore_2
    //   3385: aload_0
    //   3386: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3389: invokevirtual 1149	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3392: astore 28
    //   3394: invokestatic 2019	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3397: lload_2
    //   3398: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3401: aconst_null
    //   3402: ldc_w 451
    //   3405: iconst_0
    //   3406: invokestatic 457	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:readValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   3409: ifne +326 -> 3735
    //   3412: lload_2
    //   3413: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3416: aload 28
    //   3418: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3421: istore 19
    //   3423: iload 19
    //   3425: ifeq +310 -> 3735
    //   3428: aconst_null
    //   3429: astore 28
    //   3431: aconst_null
    //   3432: astore 29
    //   3434: aconst_null
    //   3435: astore 33
    //   3437: aload 31
    //   3439: getfield 2022	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_tips_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3442: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3445: ifeq +13983 -> 17428
    //   3448: new 274	java/lang/String
    //   3451: dup
    //   3452: aload 31
    //   3454: getfield 2022	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_tips_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3457: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3460: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3463: ldc_w 1322
    //   3466: invokespecial 1325	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3469: astore 30
    //   3471: aload 30
    //   3473: astore 28
    //   3475: aload 31
    //   3477: getfield 2025	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_yes_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3480: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3483: ifeq +13939 -> 17422
    //   3486: new 274	java/lang/String
    //   3489: dup
    //   3490: aload 31
    //   3492: getfield 2025	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_yes_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3495: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3498: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3501: ldc_w 1322
    //   3504: invokespecial 1325	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3507: astore 30
    //   3509: aload 30
    //   3511: astore 29
    //   3513: aload 31
    //   3515: getfield 2028	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_no_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3518: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3521: ifeq +13895 -> 17416
    //   3524: new 274	java/lang/String
    //   3527: dup
    //   3528: aload 31
    //   3530: getfield 2028	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_no_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3533: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3536: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3539: ldc_w 1322
    //   3542: invokespecial 1325	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3545: astore 30
    //   3547: aload 30
    //   3549: astore 31
    //   3551: aload 28
    //   3553: astore 30
    //   3555: aload 29
    //   3557: astore 32
    //   3559: invokestatic 2019	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3562: lload_2
    //   3563: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3566: aload 30
    //   3568: aload 31
    //   3570: aload 32
    //   3572: invokevirtual 2032	com/tencent/common/app/BaseApplicationImpl:setPCActiveNotice	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3575: aload_0
    //   3576: sipush 8013
    //   3579: iconst_1
    //   3580: iconst_4
    //   3581: anewarray 220	java/lang/Object
    //   3584: dup
    //   3585: iconst_0
    //   3586: lload_2
    //   3587: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3590: aastore
    //   3591: dup
    //   3592: iconst_1
    //   3593: aload 30
    //   3595: aastore
    //   3596: dup
    //   3597: iconst_2
    //   3598: aload 31
    //   3600: aastore
    //   3601: dup
    //   3602: iconst_3
    //   3603: aload 32
    //   3605: aastore
    //   3606: invokevirtual 1827	akqf:a	(IZLjava/lang/Object;)V
    //   3609: aload_1
    //   3610: getfield 1143	OnlinePushPack/MsgInfo:lFromUin	J
    //   3613: lstore_2
    //   3614: aload_1
    //   3615: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3618: istore 4
    //   3620: aload_1
    //   3621: getfield 1194	OnlinePushPack/MsgInfo:lMsgUid	J
    //   3624: lstore 15
    //   3626: aload_1
    //   3627: getfield 1140	OnlinePushPack/MsgInfo:shMsgType	S
    //   3630: istore 5
    //   3632: aload_0
    //   3633: getfield 1456	akqf:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   3636: lload_2
    //   3637: iload 4
    //   3639: lload 15
    //   3641: iload 5
    //   3643: invokestatic 1868	axao:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   3646: aconst_null
    //   3647: areturn
    //   3648: astore 30
    //   3650: aload 29
    //   3652: astore 32
    //   3654: aload 33
    //   3656: astore 31
    //   3658: aload 28
    //   3660: astore 30
    //   3662: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3665: ifeq -106 -> 3559
    //   3668: ldc_w 2003
    //   3671: iconst_2
    //   3672: ldc_w 2034
    //   3675: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3678: aload 29
    //   3680: astore 32
    //   3682: aload 33
    //   3684: astore 31
    //   3686: aload 28
    //   3688: astore 30
    //   3690: goto -131 -> 3559
    //   3693: astore 28
    //   3695: aload 28
    //   3697: invokevirtual 1903	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   3700: aload_0
    //   3701: sipush 8013
    //   3704: iconst_0
    //   3705: iconst_4
    //   3706: anewarray 220	java/lang/Object
    //   3709: dup
    //   3710: iconst_0
    //   3711: ldc 140
    //   3713: aastore
    //   3714: dup
    //   3715: iconst_1
    //   3716: ldc 140
    //   3718: aastore
    //   3719: dup
    //   3720: iconst_2
    //   3721: ldc 140
    //   3723: aastore
    //   3724: dup
    //   3725: iconst_3
    //   3726: ldc 140
    //   3728: aastore
    //   3729: invokevirtual 1827	akqf:a	(IZLjava/lang/Object;)V
    //   3732: goto -123 -> 3609
    //   3735: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3738: ifeq -129 -> 3609
    //   3741: ldc_w 2003
    //   3744: iconst_2
    //   3745: ldc_w 2036
    //   3748: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3751: goto -142 -> 3609
    //   3754: ldc2_w 2037
    //   3757: aload 32
    //   3759: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3762: lcmp
    //   3763: ifne +46 -> 3809
    //   3766: aload_0
    //   3767: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3770: aload 32
    //   3772: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3775: invokestatic 2043	mxq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)Ltencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo;
    //   3778: astore_1
    //   3779: aload_1
    //   3780: ifnull -3751 -> 29
    //   3783: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3786: ifeq +13 -> 3799
    //   3789: ldc_w 2045
    //   3792: iconst_2
    //   3793: ldc_w 2047
    //   3796: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3799: aload_0
    //   3800: bipush 105
    //   3802: iconst_1
    //   3803: aload_1
    //   3804: invokevirtual 1827	akqf:a	(IZLjava/lang/Object;)V
    //   3807: aconst_null
    //   3808: areturn
    //   3809: aload 32
    //   3811: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3814: ldc2_w 2048
    //   3817: lcmp
    //   3818: ifne +26 -> 3844
    //   3821: ldc_w 2051
    //   3824: ldc_w 2053
    //   3827: iconst_0
    //   3828: iconst_0
    //   3829: iconst_1
    //   3830: anewarray 274	java/lang/String
    //   3833: dup
    //   3834: iconst_0
    //   3835: ldc_w 2055
    //   3838: aastore
    //   3839: invokestatic 2060	vel:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   3842: aconst_null
    //   3843: areturn
    //   3844: aload 32
    //   3846: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3849: ldc2_w 2061
    //   3852: lcmp
    //   3853: ifne +1682 -> 5535
    //   3856: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3859: ifeq +13 -> 3872
    //   3862: ldc_w 2064
    //   3865: iconst_2
    //   3866: ldc_w 1998
    //   3869: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3872: new 2066	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody
    //   3875: dup
    //   3876: invokespecial 2067	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody:<init>	()V
    //   3879: astore 29
    //   3881: aload 29
    //   3883: aload 32
    //   3885: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3888: invokevirtual 2068	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3891: pop
    //   3892: iconst_0
    //   3893: istore 4
    //   3895: iload 4
    //   3897: aload 29
    //   3899: getfield 2071	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody:rpt_msg_mod_infos	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3902: invokevirtual 2072	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   3905: if_icmpge -3876 -> 29
    //   3908: aload 29
    //   3910: getfield 2071	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody:rpt_msg_mod_infos	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3913: invokevirtual 45	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   3916: iload 4
    //   3918: invokeinterface 2074 2 0
    //   3923: checkcast 2076	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody
    //   3926: astore 28
    //   3928: iconst_m1
    //   3929: istore 5
    //   3931: aload 28
    //   3933: getfield 2079	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:uint32_op_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3936: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3939: ifeq +13 -> 3952
    //   3942: aload 28
    //   3944: getfield 2079	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:uint32_op_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3947: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3950: istore 5
    //   3952: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3955: ifeq +31 -> 3986
    //   3958: ldc_w 2064
    //   3961: iconst_2
    //   3962: new 88	java/lang/StringBuilder
    //   3965: dup
    //   3966: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   3969: ldc_w 2081
    //   3972: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3975: iload 5
    //   3977: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3980: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3983: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3986: iload 5
    //   3988: sipush 2001
    //   3991: if_icmpne +263 -> 4254
    //   3994: aload 28
    //   3996: getfield 2085	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_mcard_notification_like	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike;
    //   3999: invokevirtual 2088	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:has	()Z
    //   4002: ifeq +252 -> 4254
    //   4005: aload 28
    //   4007: getfield 2085	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_mcard_notification_like	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike;
    //   4010: invokevirtual 2089	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4013: checkcast 2087	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike
    //   4016: astore 30
    //   4018: ldc 140
    //   4020: astore 28
    //   4022: lconst_0
    //   4023: lstore_2
    //   4024: iconst_0
    //   4025: istore 6
    //   4027: iconst_0
    //   4028: istore 5
    //   4030: aload 30
    //   4032: getfield 2092	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:str_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4035: invokevirtual 2093	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   4038: ifeq +13 -> 4051
    //   4041: aload 30
    //   4043: getfield 2092	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:str_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4046: invokevirtual 1790	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4049: astore 28
    //   4051: aload 30
    //   4053: getfield 2096	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4056: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4059: ifeq +13 -> 4072
    //   4062: aload 30
    //   4064: getfield 2096	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4067: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4070: istore 5
    //   4072: aload 30
    //   4074: getfield 2097	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint64_from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4077: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   4080: ifeq +12 -> 4092
    //   4083: aload 30
    //   4085: getfield 2097	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint64_from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4088: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4091: lstore_2
    //   4092: aload 30
    //   4094: getfield 2100	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_total	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4097: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4100: ifeq +13 -> 4113
    //   4103: aload 30
    //   4105: getfield 2100	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_total	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4108: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4111: istore 6
    //   4113: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4116: ifeq +63 -> 4179
    //   4119: ldc_w 2064
    //   4122: iconst_2
    //   4123: new 88	java/lang/StringBuilder
    //   4126: dup
    //   4127: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   4130: ldc_w 2102
    //   4133: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4136: aload 28
    //   4138: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4141: ldc_w 2104
    //   4144: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4147: iload 6
    //   4149: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4152: ldc_w 2106
    //   4155: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4158: iload 5
    //   4160: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4163: ldc_w 2108
    //   4166: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4169: lload_2
    //   4170: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4173: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4176: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4179: aload_0
    //   4180: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4183: bipush 71
    //   4185: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4188: checkcast 2110	anme
    //   4191: astore 28
    //   4193: aload 28
    //   4195: ifnull +13 -> 4208
    //   4198: aload 28
    //   4200: invokevirtual 2113	anme:a	()Lannh;
    //   4203: aload 30
    //   4205: invokevirtual 2118	annh:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike;)V
    //   4208: aload_1
    //   4209: getfield 1143	OnlinePushPack/MsgInfo:lFromUin	J
    //   4212: lstore_2
    //   4213: aload_1
    //   4214: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   4217: istore 5
    //   4219: aload_1
    //   4220: getfield 1194	OnlinePushPack/MsgInfo:lMsgUid	J
    //   4223: lstore 15
    //   4225: aload_1
    //   4226: getfield 1140	OnlinePushPack/MsgInfo:shMsgType	S
    //   4229: istore 6
    //   4231: aload_0
    //   4232: getfield 1456	akqf:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   4235: lload_2
    //   4236: iload 5
    //   4238: lload 15
    //   4240: iload 6
    //   4242: invokestatic 1868	axao:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   4245: iload 4
    //   4247: iconst_1
    //   4248: iadd
    //   4249: istore 4
    //   4251: goto -356 -> 3895
    //   4254: iload 5
    //   4256: sipush 2002
    //   4259: if_icmpne +460 -> 4719
    //   4262: aload 28
    //   4264: getfield 2122	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_vip_info_notify	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify;
    //   4267: invokevirtual 2125	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:has	()Z
    //   4270: ifeq +449 -> 4719
    //   4273: aload 28
    //   4275: getfield 2122	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_vip_info_notify	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify;
    //   4278: invokevirtual 2126	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4281: checkcast 2124	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify
    //   4284: astore 30
    //   4286: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4289: ifeq +34 -> 4323
    //   4292: ldc_w 520
    //   4295: iconst_2
    //   4296: new 88	java/lang/StringBuilder
    //   4299: dup
    //   4300: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   4303: ldc_w 2128
    //   4306: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4309: aload 30
    //   4311: invokevirtual 2129	java/lang/Object:toString	()Ljava/lang/String;
    //   4314: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4317: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4320: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4323: lconst_0
    //   4324: lstore_2
    //   4325: aload 30
    //   4327: getfield 2130	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4330: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   4333: ifeq +12 -> 4345
    //   4336: aload 30
    //   4338: getfield 2130	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4341: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4344: lstore_2
    //   4345: lload_2
    //   4346: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4349: astore 28
    //   4351: aload 30
    //   4353: getfield 2133	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_vip_identify	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4356: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4359: ifeq +13051 -> 17410
    //   4362: aload 30
    //   4364: getfield 2133	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_vip_identify	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4367: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4370: istore 5
    //   4372: aload 30
    //   4374: getfield 2136	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_vip_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4377: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4380: ifeq +13024 -> 17404
    //   4383: aload 30
    //   4385: getfield 2136	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_vip_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4388: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4391: istore 6
    //   4393: iconst_m1
    //   4394: istore 7
    //   4396: iconst_m1
    //   4397: istore 8
    //   4399: aload 30
    //   4401: getfield 2139	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_red_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4404: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4407: ifeq +13 -> 4420
    //   4410: aload 30
    //   4412: getfield 2139	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_red_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4415: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4418: istore 7
    //   4420: aload 30
    //   4422: getfield 2142	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_disable_red_envelope	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4425: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4428: ifeq +13 -> 4441
    //   4431: aload 30
    //   4433: getfield 2142	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_disable_red_envelope	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4436: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4439: istore 8
    //   4441: aload 30
    //   4443: getfield 2145	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_redpack_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4446: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4449: istore 9
    //   4451: aload 30
    //   4453: getfield 2148	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:str_redpack_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4456: invokevirtual 1790	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4459: astore 30
    //   4461: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4464: ifeq +12970 -> 17434
    //   4467: ldc_w 520
    //   4470: iconst_2
    //   4471: new 88	java/lang/StringBuilder
    //   4474: dup
    //   4475: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   4478: ldc_w 2150
    //   4481: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4484: iload 9
    //   4486: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4489: ldc_w 2152
    //   4492: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4495: aload 30
    //   4497: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4500: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4503: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4506: goto +12928 -> 17434
    //   4509: aload_0
    //   4510: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4513: sipush 131
    //   4516: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4519: checkcast 2154	ajzf
    //   4522: astore 31
    //   4524: aload 31
    //   4526: iload 7
    //   4528: iload 8
    //   4530: iconst_1
    //   4531: invokevirtual 2157	ajzf:a	(IIZ)V
    //   4534: aload 31
    //   4536: iload 9
    //   4538: aload 30
    //   4540: invokevirtual 2160	ajzf:a	(ILjava/lang/String;)V
    //   4543: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4546: ifeq +12901 -> 17447
    //   4549: ldc_w 520
    //   4552: iconst_2
    //   4553: new 88	java/lang/StringBuilder
    //   4556: dup
    //   4557: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   4560: ldc_w 2162
    //   4563: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4566: aload 28
    //   4568: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4571: ldc_w 2164
    //   4574: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4577: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4580: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4583: goto +12864 -> 17447
    //   4586: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4589: ifeq +42 -> 4631
    //   4592: ldc_w 520
    //   4595: iconst_2
    //   4596: new 88	java/lang/StringBuilder
    //   4599: dup
    //   4600: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   4603: ldc_w 2166
    //   4606: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4609: iload 5
    //   4611: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4614: ldc_w 2168
    //   4617: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4620: iload 6
    //   4622: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4625: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4628: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4631: aload_0
    //   4632: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4635: iconst_2
    //   4636: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4639: checkcast 380	mqq/manager/TicketManager
    //   4642: aload 28
    //   4644: invokeinterface 384 2 0
    //   4649: astore 30
    //   4651: aload_0
    //   4652: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4655: bipush 27
    //   4657: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   4660: checkcast 386	akjo
    //   4663: aload 30
    //   4665: aload 28
    //   4667: invokevirtual 389	akjo:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   4670: aload_0
    //   4671: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4674: invokestatic 2173	bbtc:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lbbtc;
    //   4677: invokevirtual 2175	bbtc:b	()V
    //   4680: goto -472 -> 4208
    //   4683: astore_1
    //   4684: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4687: ifeq -4658 -> 29
    //   4690: ldc_w 2064
    //   4693: iconst_2
    //   4694: new 88	java/lang/StringBuilder
    //   4697: dup
    //   4698: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   4701: ldc_w 2177
    //   4704: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4707: aload_1
    //   4708: invokevirtual 2180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4711: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4714: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4717: aconst_null
    //   4718: areturn
    //   4719: iload 5
    //   4721: sipush 2003
    //   4724: if_icmpne +155 -> 4879
    //   4727: aload 28
    //   4729: getfield 2184	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_push_lost_dev_found	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound;
    //   4732: invokevirtual 2187	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:has	()Z
    //   4735: ifeq +144 -> 4879
    //   4738: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4741: ifeq +13 -> 4754
    //   4744: ldc_w 2189
    //   4747: iconst_2
    //   4748: ldc_w 2191
    //   4751: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4754: aload 28
    //   4756: getfield 2184	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_push_lost_dev_found	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound;
    //   4759: invokevirtual 2192	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4762: checkcast 2186	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound
    //   4765: astore 28
    //   4767: new 913	android/os/Bundle
    //   4770: dup
    //   4771: invokespecial 914	android/os/Bundle:<init>	()V
    //   4774: astore 30
    //   4776: aload 28
    //   4778: getfield 2195	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4781: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4784: ifeq +19 -> 4803
    //   4787: aload 30
    //   4789: ldc_w 2197
    //   4792: aload 28
    //   4794: getfield 2195	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4797: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4800: invokevirtual 2199	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4803: aload 28
    //   4805: getfield 2202	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint32_dev_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4808: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4811: ifeq +19 -> 4830
    //   4814: aload 30
    //   4816: ldc_w 2204
    //   4819: aload 28
    //   4821: getfield 2202	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint32_dev_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4824: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4827: invokevirtual 2199	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4830: aload 28
    //   4832: getfield 2207	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint64_din	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4835: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   4838: ifeq +19 -> 4857
    //   4841: aload 30
    //   4843: ldc_w 2209
    //   4846: aload 28
    //   4848: getfield 2207	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint64_din	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4851: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4854: invokevirtual 926	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   4857: aload_0
    //   4858: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4861: bipush 51
    //   4863: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   4866: checkcast 2211	yak
    //   4869: bipush 111
    //   4871: aload 30
    //   4873: invokevirtual 2214	yak:a	(ILandroid/os/Bundle;)V
    //   4876: goto -668 -> 4208
    //   4879: iload 5
    //   4881: sipush 2007
    //   4884: if_icmpne +50 -> 4934
    //   4887: aload 28
    //   4889: getfield 2218	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_babyq_reward_info	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$RewardInfo;
    //   4892: invokevirtual 2221	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$RewardInfo:has	()Z
    //   4895: ifeq +39 -> 4934
    //   4898: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4901: ifeq +13 -> 4914
    //   4904: ldc_w 520
    //   4907: iconst_2
    //   4908: ldc_w 2223
    //   4911: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4914: aload_0
    //   4915: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4918: bipush 53
    //   4920: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   4923: checkcast 2225	ajsk
    //   4926: aload 28
    //   4928: invokevirtual 2228	ajsk:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody;)V
    //   4931: goto -723 -> 4208
    //   4934: iload 5
    //   4936: sipush 2011
    //   4939: if_icmpne -731 -> 4208
    //   4942: aload 28
    //   4944: getfield 2232	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_mod_qim_friend_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ;
    //   4947: invokevirtual 2235	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:has	()Z
    //   4950: ifeq -742 -> 4208
    //   4953: aload 28
    //   4955: getfield 2232	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_mod_qim_friend_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ;
    //   4958: invokevirtual 2236	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4961: checkcast 2234	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ
    //   4964: astore 28
    //   4966: iconst_m1
    //   4967: istore 5
    //   4969: aload 28
    //   4971: getfield 2239	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:uint32_notify_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4974: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4977: ifeq +13 -> 4990
    //   4980: aload 28
    //   4982: getfield 2239	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:uint32_notify_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4985: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4988: istore 5
    //   4990: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4993: ifeq +31 -> 5024
    //   4996: ldc_w 2241
    //   4999: iconst_2
    //   5000: new 88	java/lang/StringBuilder
    //   5003: dup
    //   5004: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   5007: ldc_w 2243
    //   5010: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5013: iload 5
    //   5015: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5018: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5021: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5024: iload 5
    //   5026: iconst_1
    //   5027: if_icmpne +190 -> 5217
    //   5030: aload 28
    //   5032: getfield 2247	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:msg_add_notify_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ;
    //   5035: invokevirtual 2250	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:has	()Z
    //   5038: ifeq -830 -> 4208
    //   5041: aload 28
    //   5043: getfield 2247	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:msg_add_notify_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ;
    //   5046: astore 28
    //   5048: new 2252	com/tencent/mobileqq/data/QIMFollwerAdd
    //   5051: dup
    //   5052: invokespecial 2253	com/tencent/mobileqq/data/QIMFollwerAdd:<init>	()V
    //   5055: astore 30
    //   5057: aload 30
    //   5059: aload 28
    //   5061: getfield 2254	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5064: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5067: putfield 2256	com/tencent/mobileqq/data/QIMFollwerAdd:uin	J
    //   5070: aload 30
    //   5072: aload 28
    //   5074: getfield 2259	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint32_gender	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5077: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5080: putfield 2262	com/tencent/mobileqq/data/QIMFollwerAdd:gender	I
    //   5083: aload 30
    //   5085: aload 28
    //   5087: getfield 2265	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint64_cares_count	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5090: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5093: putfield 2268	com/tencent/mobileqq/data/QIMFollwerAdd:careSCount	J
    //   5096: aload 30
    //   5098: aload 28
    //   5100: getfield 2271	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint64_storys_total_num	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5103: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5106: putfield 2274	com/tencent/mobileqq/data/QIMFollwerAdd:totalNum	J
    //   5109: aload 30
    //   5111: aload 28
    //   5113: getfield 2277	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:bytes_smart_remark	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5116: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5119: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5122: putfield 2280	com/tencent/mobileqq/data/QIMFollwerAdd:smartRemark	Ljava/lang/String;
    //   5125: aload 30
    //   5127: aload 28
    //   5129: getfield 2281	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint32_op_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5132: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5135: putfield 2284	com/tencent/mobileqq/data/QIMFollwerAdd:opType	I
    //   5138: aload 30
    //   5140: aload 28
    //   5142: getfield 2287	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint64_fans_count	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5145: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5148: putfield 2290	com/tencent/mobileqq/data/QIMFollwerAdd:fansCount	J
    //   5151: aload 30
    //   5153: aload 28
    //   5155: getfield 2293	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:bytes_longnick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5158: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5161: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   5164: invokestatic 2299	com/tencent/mobileqq/richstatus/RichStatus:parseStatus	([B)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   5167: invokevirtual 2302	com/tencent/mobileqq/richstatus/RichStatus:getPlainText	()Ljava/lang/String;
    //   5170: putfield 2305	com/tencent/mobileqq/data/QIMFollwerAdd:longNick	Ljava/lang/String;
    //   5173: aload 30
    //   5175: invokestatic 2307	awzw:a	()J
    //   5178: putfield 2310	com/tencent/mobileqq/data/QIMFollwerAdd:upTime	J
    //   5181: aload 30
    //   5183: aload 28
    //   5185: getfield 2313	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:bytes_src_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5188: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5191: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5194: putfield 2315	com/tencent/mobileqq/data/QIMFollwerAdd:source	Ljava/lang/String;
    //   5197: aload_0
    //   5198: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5201: bipush 34
    //   5203: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5206: checkcast 2317	akbo
    //   5209: aload 30
    //   5211: invokevirtual 2320	akbo:b	(Lcom/tencent/mobileqq/data/QIMFollwerAdd;)V
    //   5214: goto -1006 -> 4208
    //   5217: iload 5
    //   5219: iconst_2
    //   5220: if_icmpeq -1012 -> 4208
    //   5223: iload 5
    //   5225: iconst_3
    //   5226: if_icmpne -1018 -> 4208
    //   5229: aload 28
    //   5231: getfield 2324	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:msg_add_not_login_frd_notify_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ;
    //   5234: invokevirtual 2327	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:has	()Z
    //   5237: ifeq -1029 -> 4208
    //   5240: aload 28
    //   5242: getfield 2324	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:msg_add_not_login_frd_notify_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ;
    //   5245: invokevirtual 2328	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5248: checkcast 2326	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ
    //   5251: astore 28
    //   5253: new 2330	com/tencent/mobileqq/data/QIMNotifyAddFriend
    //   5256: dup
    //   5257: invokespecial 2331	com/tencent/mobileqq/data/QIMNotifyAddFriend:<init>	()V
    //   5260: astore 30
    //   5262: aload 30
    //   5264: aload 28
    //   5266: getfield 2332	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5269: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5272: putfield 2333	com/tencent/mobileqq/data/QIMNotifyAddFriend:uin	J
    //   5275: aload 30
    //   5277: aload 28
    //   5279: getfield 2336	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:uint64_qq_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5282: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5285: putfield 2339	com/tencent/mobileqq/data/QIMNotifyAddFriend:qqUin	J
    //   5288: aload 30
    //   5290: aload 28
    //   5292: getfield 2342	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:bytes_nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5295: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5298: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5301: putfield 2345	com/tencent/mobileqq/data/QIMNotifyAddFriend:nickName	Ljava/lang/String;
    //   5304: aload 30
    //   5306: aload 28
    //   5308: getfield 2346	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:uint32_gender	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5311: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5314: putfield 2347	com/tencent/mobileqq/data/QIMNotifyAddFriend:gender	I
    //   5317: aload 30
    //   5319: aload 28
    //   5321: getfield 2350	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5324: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5327: putfield 2353	com/tencent/mobileqq/data/QIMNotifyAddFriend:age	I
    //   5330: aload 30
    //   5332: aload 28
    //   5334: getfield 2356	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:bytes_coverstory	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5337: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5340: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5343: putfield 2359	com/tencent/mobileqq/data/QIMNotifyAddFriend:coverStory	Ljava/lang/String;
    //   5346: aload 30
    //   5348: aload 28
    //   5350: getfield 2360	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:uint64_storys_total_num	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5353: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5356: putfield 2363	com/tencent/mobileqq/data/QIMNotifyAddFriend:storyTotalNum	J
    //   5359: aload 30
    //   5361: aload 28
    //   5363: getfield 2366	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:bytes_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5366: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5369: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5372: putfield 2368	com/tencent/mobileqq/data/QIMNotifyAddFriend:wording	Ljava/lang/String;
    //   5375: iconst_0
    //   5376: istore 5
    //   5378: iload 5
    //   5380: aload 28
    //   5382: getfield 2371	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:rpt_msg_video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5385: invokevirtual 2072	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   5388: if_icmpge +81 -> 5469
    //   5391: aload 28
    //   5393: getfield 2371	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:rpt_msg_video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5396: iload 5
    //   5398: invokevirtual 2374	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5401: checkcast 2376	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VideoInfo
    //   5404: astore 31
    //   5406: new 2378	com/tencent/mobileqq/data/QIMNotifyAddFriend$VideoInfo
    //   5409: dup
    //   5410: invokespecial 2379	com/tencent/mobileqq/data/QIMNotifyAddFriend$VideoInfo:<init>	()V
    //   5413: astore 32
    //   5415: aload 32
    //   5417: aload 31
    //   5419: getfield 2382	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VideoInfo:bytes_video_cover_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5422: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5425: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5428: putfield 2385	com/tencent/mobileqq/data/QIMNotifyAddFriend$VideoInfo:coverUrl	Ljava/lang/String;
    //   5431: aload 32
    //   5433: aload 31
    //   5435: getfield 2388	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VideoInfo:bytes_vid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5438: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5441: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5444: putfield 2391	com/tencent/mobileqq/data/QIMNotifyAddFriend$VideoInfo:videoVid	Ljava/lang/String;
    //   5447: aload 30
    //   5449: getfield 2395	com/tencent/mobileqq/data/QIMNotifyAddFriend:videoInfos	Ljava/util/List;
    //   5452: aload 32
    //   5454: invokeinterface 1058 2 0
    //   5459: pop
    //   5460: iload 5
    //   5462: iconst_1
    //   5463: iadd
    //   5464: istore 5
    //   5466: goto -88 -> 5378
    //   5469: aload 30
    //   5471: invokestatic 2307	awzw:a	()J
    //   5474: putfield 2398	com/tencent/mobileqq/data/QIMNotifyAddFriend:pushTime	J
    //   5477: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5480: ifeq +34 -> 5514
    //   5483: ldc_w 2241
    //   5486: iconst_2
    //   5487: new 88	java/lang/StringBuilder
    //   5490: dup
    //   5491: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   5494: ldc_w 2400
    //   5497: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5500: aload 30
    //   5502: invokevirtual 2401	com/tencent/mobileqq/data/QIMNotifyAddFriend:toString	()Ljava/lang/String;
    //   5505: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5508: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5511: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5514: aload_0
    //   5515: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5518: sipush 257
    //   5521: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5524: checkcast 2403	akdr
    //   5527: aload 30
    //   5529: invokevirtual 2406	akdr:a	(Lcom/tencent/mobileqq/data/QIMNotifyAddFriend;)V
    //   5532: goto -1324 -> 4208
    //   5535: aload 32
    //   5537: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   5540: ldc2_w 2407
    //   5543: lcmp
    //   5544: ifne +523 -> 6067
    //   5547: new 2410	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody
    //   5550: dup
    //   5551: invokespecial 2411	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:<init>	()V
    //   5554: astore_1
    //   5555: aload_1
    //   5556: aload 32
    //   5558: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   5561: invokevirtual 2412	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5564: pop
    //   5565: aload_1
    //   5566: getfield 2413	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5569: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5572: istore 4
    //   5574: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5577: ifeq +47 -> 5624
    //   5580: ldc_w 520
    //   5583: iconst_2
    //   5584: new 88	java/lang/StringBuilder
    //   5587: dup
    //   5588: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   5591: ldc_w 2415
    //   5594: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5597: iload 4
    //   5599: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5602: ldc_w 2417
    //   5605: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5608: aload_1
    //   5609: getfield 2420	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5612: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5615: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5618: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5621: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5624: iload 4
    //   5626: sipush 1004
    //   5629: if_icmpne +56 -> 5685
    //   5632: aload_0
    //   5633: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5636: bipush 79
    //   5638: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5641: checkcast 2422	com/tencent/mobileqq/portal/PortalManager
    //   5644: astore 28
    //   5646: aload 28
    //   5648: ifnull -5619 -> 29
    //   5651: aload 28
    //   5653: aload_1
    //   5654: invokevirtual 2425	com/tencent/mobileqq/portal/PortalManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody;)V
    //   5657: aconst_null
    //   5658: areturn
    //   5659: astore_1
    //   5660: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5663: ifeq +13 -> 5676
    //   5666: ldc_w 2427
    //   5669: iconst_2
    //   5670: ldc 140
    //   5672: aload_1
    //   5673: invokestatic 2429	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   5676: new 2431	java/lang/RuntimeException
    //   5679: dup
    //   5680: aload_1
    //   5681: invokespecial 2434	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   5684: athrow
    //   5685: iload 4
    //   5687: bipush 49
    //   5689: if_icmpne +26 -> 5715
    //   5692: aload_0
    //   5693: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5696: aload_0
    //   5697: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5700: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5703: aload_1
    //   5704: getfield 2420	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5707: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5710: invokestatic 2439	ando:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   5713: aconst_null
    //   5714: areturn
    //   5715: iload 4
    //   5717: bipush 46
    //   5719: if_icmpne +29 -> 5748
    //   5722: aload_0
    //   5723: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5726: aload_0
    //   5727: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5730: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5733: aload_1
    //   5734: getfield 2420	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5737: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5740: ldc_w 2441
    //   5743: invokestatic 2446	zcw:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;ILjava/lang/String;)V
    //   5746: aconst_null
    //   5747: areturn
    //   5748: iload 4
    //   5750: sipush 1003
    //   5753: if_icmpne +22 -> 5775
    //   5756: aload_0
    //   5757: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5760: sipush 167
    //   5763: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5766: checkcast 2448	com/tencent/mobileqq/olympic/OlympicManager
    //   5769: aload_1
    //   5770: invokevirtual 2449	com/tencent/mobileqq/olympic/OlympicManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody;)V
    //   5773: aconst_null
    //   5774: areturn
    //   5775: iload 4
    //   5777: sipush 222
    //   5780: if_icmpne +102 -> 5882
    //   5783: aload_0
    //   5784: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5787: invokevirtual 2453	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   5790: ldc_w 2455
    //   5793: iconst_0
    //   5794: invokeinterface 444 3 0
    //   5799: istore 4
    //   5801: iload 4
    //   5803: aload_1
    //   5804: getfield 2420	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5807: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5810: if_icmpeq +20 -> 5830
    //   5813: aload_0
    //   5814: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5817: sipush 222
    //   5820: aload_0
    //   5821: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5824: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5827: invokestatic 2458	ando:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;)V
    //   5830: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5833: ifeq -5804 -> 29
    //   5836: ldc_w 520
    //   5839: iconst_2
    //   5840: new 88	java/lang/StringBuilder
    //   5843: dup
    //   5844: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   5847: ldc_w 2460
    //   5850: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5853: iload 4
    //   5855: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5858: ldc_w 2417
    //   5861: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5864: aload_1
    //   5865: getfield 2420	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5868: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5871: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5874: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5877: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5880: aconst_null
    //   5881: areturn
    //   5882: iload 4
    //   5884: sipush 1007
    //   5887: if_icmpne +43 -> 5930
    //   5890: aload_0
    //   5891: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5894: sipush 341
    //   5897: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5900: checkcast 2462	ahfq
    //   5903: astore 28
    //   5905: aload_0
    //   5906: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5909: ifnull -5880 -> 29
    //   5912: aload 28
    //   5914: aload_0
    //   5915: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5918: aload_1
    //   5919: getfield 2420	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5922: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5925: invokevirtual 2465	ahfq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   5928: aconst_null
    //   5929: areturn
    //   5930: iload 4
    //   5932: sipush 539
    //   5935: if_icmpeq +19 -> 5954
    //   5938: iload 4
    //   5940: sipush 540
    //   5943: if_icmpeq +11 -> 5954
    //   5946: iload 4
    //   5948: sipush 548
    //   5951: if_icmpne -5922 -> 29
    //   5954: invokestatic 1018	ampm:a	()Lampm;
    //   5957: iload 4
    //   5959: aload_0
    //   5960: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5963: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5966: invokevirtual 2468	ampm:a	(ILjava/lang/String;)I
    //   5969: istore 5
    //   5971: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5974: ifeq +47 -> 6021
    //   5977: ldc_w 520
    //   5980: iconst_2
    //   5981: new 88	java/lang/StringBuilder
    //   5984: dup
    //   5985: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   5988: ldc_w 2470
    //   5991: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5994: iload 5
    //   5996: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5999: ldc_w 2417
    //   6002: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6005: aload_1
    //   6006: getfield 2420	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6009: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6012: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6015: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6018: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6021: invokestatic 1018	ampm:a	()Lampm;
    //   6024: iconst_1
    //   6025: newarray int
    //   6027: dup
    //   6028: iconst_0
    //   6029: iload 4
    //   6031: iastore
    //   6032: invokevirtual 2473	ampm:a	([I)V
    //   6035: aconst_null
    //   6036: areturn
    //   6037: astore_1
    //   6038: ldc_w 520
    //   6041: iconst_1
    //   6042: new 88	java/lang/StringBuilder
    //   6045: dup
    //   6046: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6049: ldc_w 2475
    //   6052: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6055: aload_1
    //   6056: invokevirtual 2180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6059: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6062: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6065: aconst_null
    //   6066: areturn
    //   6067: aload 32
    //   6069: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6072: ldc2_w 2476
    //   6075: lcmp
    //   6076: ifne +26 -> 6102
    //   6079: aload_0
    //   6080: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6083: bipush 36
    //   6085: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6088: checkcast 2479	avpq
    //   6091: aload 32
    //   6093: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6096: invokevirtual 2482	avpq:a	([B)Z
    //   6099: pop
    //   6100: aconst_null
    //   6101: areturn
    //   6102: aload 32
    //   6104: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6107: ldc2_w 2483
    //   6110: lcmp
    //   6111: ifne +25 -> 6136
    //   6114: aload_0
    //   6115: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6118: bipush 36
    //   6120: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6123: checkcast 2479	avpq
    //   6126: aload 32
    //   6128: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6131: invokevirtual 2485	avpq:a	([B)V
    //   6134: aconst_null
    //   6135: areturn
    //   6136: aload 32
    //   6138: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6141: ldc2_w 2486
    //   6144: lcmp
    //   6145: ifne +284 -> 6429
    //   6148: aload_0
    //   6149: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6152: bipush 85
    //   6154: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6157: checkcast 2489	akjw
    //   6160: astore 28
    //   6162: aload 28
    //   6164: aload_1
    //   6165: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6168: invokevirtual 2491	akjw:a	(I)Z
    //   6171: ifne +220 -> 6391
    //   6174: new 2493	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$MsgBody
    //   6177: dup
    //   6178: invokespecial 2494	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$MsgBody:<init>	()V
    //   6181: astore_1
    //   6182: aload_1
    //   6183: aload 32
    //   6185: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6188: invokevirtual 2495	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6191: pop
    //   6192: aload_1
    //   6193: getfield 2499	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$MsgBody:msg_system_notify	Ltencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$SystemNotify;
    //   6196: invokevirtual 2502	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$SystemNotify:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6199: checkcast 2501	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$SystemNotify
    //   6202: getfield 2505	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$SystemNotify:bytes_msg_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6205: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6208: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   6211: astore 29
    //   6213: new 2507	org/json/JSONObject
    //   6216: dup
    //   6217: aload_1
    //   6218: getfield 2510	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$MsgBody:bytes_push_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6221: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6224: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   6227: invokespecial 2511	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6230: astore_1
    //   6231: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6234: ifeq +63 -> 6297
    //   6237: ldc_w 520
    //   6240: iconst_2
    //   6241: new 88	java/lang/StringBuilder
    //   6244: dup
    //   6245: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6248: ldc_w 2513
    //   6251: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6254: aload 29
    //   6256: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6259: ldc_w 2515
    //   6262: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6265: aload_1
    //   6266: ldc_w 2517
    //   6269: invokevirtual 2520	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6272: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6275: ldc_w 2522
    //   6278: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6281: aload_1
    //   6282: ldc_w 2524
    //   6285: invokevirtual 2528	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   6288: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6291: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6294: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6297: aload 28
    //   6299: aload 29
    //   6301: aload_1
    //   6302: ldc_w 2517
    //   6305: invokevirtual 2520	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6308: aload_1
    //   6309: ldc_w 2524
    //   6312: invokevirtual 2528	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   6315: invokevirtual 2531	akjw:a	(Ljava/lang/String;Ljava/lang/String;J)V
    //   6318: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6321: ifeq +13 -> 6334
    //   6324: ldc_w 520
    //   6327: iconst_2
    //   6328: ldc_w 2533
    //   6331: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6334: aload_0
    //   6335: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6338: ldc_w 2535
    //   6341: ldc_w 2537
    //   6344: ldc 140
    //   6346: ldc 140
    //   6348: ldc_w 2539
    //   6351: iconst_0
    //   6352: iconst_0
    //   6353: ldc 140
    //   6355: ldc 140
    //   6357: aload_1
    //   6358: ldc_w 2517
    //   6361: invokevirtual 2520	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6364: ldc 140
    //   6366: invokestatic 1953	axqw:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   6369: aconst_null
    //   6370: areturn
    //   6371: astore_1
    //   6372: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6375: ifeq -6346 -> 29
    //   6378: ldc_w 2541
    //   6381: iconst_2
    //   6382: ldc_w 2543
    //   6385: aload_1
    //   6386: invokestatic 2429	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   6389: aconst_null
    //   6390: areturn
    //   6391: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6394: ifeq -6365 -> 29
    //   6397: ldc_w 520
    //   6400: iconst_2
    //   6401: new 88	java/lang/StringBuilder
    //   6404: dup
    //   6405: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6408: ldc_w 2545
    //   6411: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6414: aload_1
    //   6415: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6418: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6421: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6424: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6427: aconst_null
    //   6428: areturn
    //   6429: aload 32
    //   6431: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6434: ldc2_w 2546
    //   6437: lcmp
    //   6438: ifne +148 -> 6586
    //   6441: aload_1
    //   6442: getfield 1143	OnlinePushPack/MsgInfo:lFromUin	J
    //   6445: lstore 15
    //   6447: aload_1
    //   6448: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6451: istore 4
    //   6453: aload_1
    //   6454: getfield 1194	OnlinePushPack/MsgInfo:lMsgUid	J
    //   6457: lstore 17
    //   6459: aload_1
    //   6460: getfield 1140	OnlinePushPack/MsgInfo:shMsgType	S
    //   6463: istore 5
    //   6465: aload 32
    //   6467: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6470: l2i
    //   6471: istore 6
    //   6473: aload_0
    //   6474: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6477: bipush 85
    //   6479: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6482: checkcast 2489	akjw
    //   6485: aload_1
    //   6486: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6489: invokevirtual 2491	akjw:a	(I)Z
    //   6492: ifeq +56 -> 6548
    //   6495: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6498: ifeq +33 -> 6531
    //   6501: ldc_w 520
    //   6504: iconst_2
    //   6505: new 88	java/lang/StringBuilder
    //   6508: dup
    //   6509: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6512: ldc_w 2545
    //   6515: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6518: aload_1
    //   6519: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6522: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6525: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6528: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6531: aload_0
    //   6532: getfield 1456	akqf:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   6535: lload 15
    //   6537: iload 4
    //   6539: lload 17
    //   6541: iload 5
    //   6543: invokestatic 1868	axao:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   6546: aconst_null
    //   6547: areturn
    //   6548: aload_0
    //   6549: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6552: aload 32
    //   6554: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6557: lload 15
    //   6559: lload_2
    //   6560: iload 4
    //   6562: iload 5
    //   6564: iload 6
    //   6566: invokestatic 2550	axao:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BJJIII)Z
    //   6569: ifeq -38 -> 6531
    //   6572: aload_0
    //   6573: ldc_w 2552
    //   6576: iconst_1
    //   6577: iconst_1
    //   6578: iconst_1
    //   6579: iconst_0
    //   6580: invokevirtual 1462	akqf:a	(Ljava/lang/String;ZIZZ)V
    //   6583: goto -52 -> 6531
    //   6586: aload 32
    //   6588: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6591: ldc2_w 2553
    //   6594: lcmp
    //   6595: ifne +25 -> 6620
    //   6598: aload_0
    //   6599: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6602: bipush 47
    //   6604: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   6607: checkcast 2556	akdv
    //   6610: aload 32
    //   6612: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6615: invokevirtual 2557	akdv:a	([B)V
    //   6618: aconst_null
    //   6619: areturn
    //   6620: aload 32
    //   6622: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6625: ldc2_w 2558
    //   6628: lcmp
    //   6629: ifne +271 -> 6900
    //   6632: invokestatic 2562	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6635: ifeq +46 -> 6681
    //   6638: ldc_w 2564
    //   6641: iconst_4
    //   6642: new 88	java/lang/StringBuilder
    //   6645: dup
    //   6646: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6649: ldc_w 2566
    //   6652: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6655: aload_1
    //   6656: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6659: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6662: ldc_w 2568
    //   6665: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6668: aload_1
    //   6669: getfield 1140	OnlinePushPack/MsgInfo:shMsgType	S
    //   6672: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6675: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6678: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6681: new 2570	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody
    //   6684: dup
    //   6685: invokespecial 2571	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:<init>	()V
    //   6688: astore_1
    //   6689: aload_1
    //   6690: aload 32
    //   6692: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6695: invokevirtual 2572	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6698: pop
    //   6699: aload_1
    //   6700: getfield 2575	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:uint32_src_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6703: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6706: pop
    //   6707: aload_1
    //   6708: getfield 2578	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:uint32_undeal_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6711: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6714: istore 4
    //   6716: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6719: ifeq +31 -> 6750
    //   6722: ldc_w 2564
    //   6725: iconst_2
    //   6726: new 88	java/lang/StringBuilder
    //   6729: dup
    //   6730: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6733: ldc_w 2580
    //   6736: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6739: iload 4
    //   6741: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6744: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6747: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6750: ldc_w 2582
    //   6753: iconst_m1
    //   6754: aload_0
    //   6755: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6758: invokevirtual 628	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   6761: invokestatic 2588	cooperation/qzone/LocalMultiProcConfig:getInt4Uin	(Ljava/lang/String;IJ)I
    //   6764: istore 5
    //   6766: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6769: ifeq +47 -> 6816
    //   6772: ldc_w 520
    //   6775: iconst_2
    //   6776: new 88	java/lang/StringBuilder
    //   6779: dup
    //   6780: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6783: ldc_w 2590
    //   6786: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6789: aload_0
    //   6790: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6793: invokevirtual 628	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   6796: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6799: ldc_w 2592
    //   6802: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6805: iload 5
    //   6807: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6810: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6813: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6816: iload 5
    //   6818: iconst_1
    //   6819: if_icmpne -6790 -> 29
    //   6822: aload_0
    //   6823: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6826: bipush 10
    //   6828: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6831: checkcast 2594	axch
    //   6834: astore_1
    //   6835: new 655	java/util/ArrayList
    //   6838: dup
    //   6839: invokespecial 656	java/util/ArrayList:<init>	()V
    //   6842: astore 28
    //   6844: new 2596	cooperation/qzone/UndealCount/QZoneCountUserInfo
    //   6847: dup
    //   6848: invokespecial 2597	cooperation/qzone/UndealCount/QZoneCountUserInfo:<init>	()V
    //   6851: astore 29
    //   6853: aload 29
    //   6855: aload_0
    //   6856: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6859: invokevirtual 628	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   6862: putfield 2598	cooperation/qzone/UndealCount/QZoneCountUserInfo:a	J
    //   6865: aload 28
    //   6867: aload 29
    //   6869: invokevirtual 657	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   6872: pop
    //   6873: aload_1
    //   6874: bipush 17
    //   6876: iload 4
    //   6878: i2l
    //   6879: aload 28
    //   6881: ldc 140
    //   6883: iconst_0
    //   6884: iconst_1
    //   6885: ldc 140
    //   6887: invokevirtual 2601	axch:a	(IJLjava/util/ArrayList;Ljava/lang/String;ZZLjava/lang/String;)Z
    //   6890: pop
    //   6891: aconst_null
    //   6892: areturn
    //   6893: astore_1
    //   6894: aload_1
    //   6895: invokevirtual 1903	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   6898: aconst_null
    //   6899: areturn
    //   6900: aload 32
    //   6902: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6905: ldc2_w 2602
    //   6908: lcmp
    //   6909: ifne +134 -> 7043
    //   6912: invokestatic 2562	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6915: ifeq +46 -> 6961
    //   6918: ldc_w 520
    //   6921: iconst_4
    //   6922: new 88	java/lang/StringBuilder
    //   6925: dup
    //   6926: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6929: ldc_w 2605
    //   6932: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6935: aload_1
    //   6936: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6939: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6942: ldc_w 2568
    //   6945: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6948: aload_1
    //   6949: getfield 1140	OnlinePushPack/MsgInfo:shMsgType	S
    //   6952: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6955: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6958: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6961: new 2607	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody
    //   6964: dup
    //   6965: invokespecial 2608	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody:<init>	()V
    //   6968: astore_1
    //   6969: aload_1
    //   6970: aload 32
    //   6972: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6975: invokevirtual 2609	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6978: pop
    //   6979: aload_1
    //   6980: getfield 2610	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6983: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6986: lstore_2
    //   6987: aload_0
    //   6988: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6991: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6994: lload_2
    //   6995: invokestatic 495	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   6998: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7001: ifeq -6972 -> 29
    //   7004: aload_0
    //   7005: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7008: bipush 94
    //   7010: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7013: checkcast 2612	awyj
    //   7016: aload_1
    //   7017: iconst_3
    //   7018: invokevirtual 2615	awyj:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody;I)V
    //   7021: aconst_null
    //   7022: areturn
    //   7023: astore_1
    //   7024: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7027: ifeq -6998 -> 29
    //   7030: ldc_w 520
    //   7033: iconst_2
    //   7034: ldc_w 2617
    //   7037: aload_1
    //   7038: invokestatic 1599	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   7041: aconst_null
    //   7042: areturn
    //   7043: aload 32
    //   7045: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7048: ldc2_w 2618
    //   7051: lcmp
    //   7052: ifne +166 -> 7218
    //   7055: invokestatic 2562	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7058: ifeq +46 -> 7104
    //   7061: ldc_w 520
    //   7064: iconst_4
    //   7065: new 88	java/lang/StringBuilder
    //   7068: dup
    //   7069: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   7072: ldc_w 2621
    //   7075: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7078: aload_1
    //   7079: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   7082: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7085: ldc_w 2568
    //   7088: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7091: aload_1
    //   7092: getfield 1140	OnlinePushPack/MsgInfo:shMsgType	S
    //   7095: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7098: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7101: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7104: new 2623	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody
    //   7107: dup
    //   7108: invokespecial 2624	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:<init>	()V
    //   7111: astore_1
    //   7112: aload_1
    //   7113: aload 32
    //   7115: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7118: invokevirtual 2625	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7121: pop
    //   7122: aload_1
    //   7123: ifnull -7094 -> 29
    //   7126: aload_1
    //   7127: getfield 2628	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:uint32_notify_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7130: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7133: iconst_1
    //   7134: if_icmpne +78 -> 7212
    //   7137: iconst_1
    //   7138: istore 19
    //   7140: iload 19
    //   7142: iconst_1
    //   7143: if_icmpne -7114 -> 29
    //   7146: new 274	java/lang/String
    //   7149: dup
    //   7150: aload_1
    //   7151: getfield 2631	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:bytes_notify_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7154: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7157: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   7160: ldc_w 1322
    //   7163: invokespecial 1325	java/lang/String:<init>	([BLjava/lang/String;)V
    //   7166: astore_1
    //   7167: aload_0
    //   7168: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7171: iload 19
    //   7173: aload_1
    //   7174: invokestatic 2636	aver:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ZLjava/lang/String;)V
    //   7177: aload_0
    //   7178: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7181: invokevirtual 2639	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   7184: iload 19
    //   7186: aload_1
    //   7187: invokevirtual 2644	com/tencent/av/gaudio/AVNotifyCenter:a	(ZLjava/lang/String;)V
    //   7190: aconst_null
    //   7191: areturn
    //   7192: astore_1
    //   7193: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7196: ifeq -7167 -> 29
    //   7199: ldc_w 520
    //   7202: iconst_2
    //   7203: ldc_w 2646
    //   7206: aload_1
    //   7207: invokestatic 1599	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   7210: aconst_null
    //   7211: areturn
    //   7212: iconst_0
    //   7213: istore 19
    //   7215: goto -75 -> 7140
    //   7218: aload 32
    //   7220: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7223: ldc2_w 2647
    //   7226: lcmp
    //   7227: ifne +561 -> 7788
    //   7230: new 2650	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody
    //   7233: dup
    //   7234: invokespecial 2651	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:<init>	()V
    //   7237: astore 28
    //   7239: sipush -2029
    //   7242: invokestatic 1219	axaq:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7245: checkcast 2653	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   7248: astore 29
    //   7250: aload 28
    //   7252: aload 32
    //   7254: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7257: invokevirtual 2654	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7260: pop
    //   7261: aload 29
    //   7263: new 88	java/lang/StringBuilder
    //   7266: dup
    //   7267: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   7270: aload 28
    //   7272: getfield 2657	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:uint64_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7275: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7278: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7281: ldc 140
    //   7283: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7286: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7289: putfield 2660	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7292: aload 29
    //   7294: new 88	java/lang/StringBuilder
    //   7297: dup
    //   7298: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   7301: aload 28
    //   7303: getfield 2663	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:uint64_receiver_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7306: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7309: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7312: ldc 140
    //   7314: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7317: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7320: putfield 2666	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   7323: aload 29
    //   7325: aload 28
    //   7327: getfield 2669	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:bytes_sender_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7330: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7333: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7336: putfield 2672	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   7339: aload 29
    //   7341: aload 28
    //   7343: getfield 2675	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:bytes_receiver_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7346: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7349: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7352: putfield 2678	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   7355: aload 29
    //   7357: aload 28
    //   7359: getfield 2681	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:bytes_authkey	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7362: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7365: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7368: putfield 2684	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   7371: aload 29
    //   7373: aload 28
    //   7375: getfield 2685	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7378: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7381: putfield 2688	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   7384: aload 29
    //   7386: aload 28
    //   7388: getfield 2691	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:uint32_sub_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7391: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7394: putfield 2694	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   7397: aload 29
    //   7399: aload 28
    //   7401: getfield 2697	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:bytes_jumpurl	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7404: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7407: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7410: putfield 2699	com/tencent/mobileqq/data/MessageForQQWalletTips:bytes_jumpurl	Ljava/lang/String;
    //   7413: aload_0
    //   7414: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7417: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7420: astore 30
    //   7422: aload_0
    //   7423: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7426: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7429: aload 29
    //   7431: getfield 2660	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7434: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7437: ifeq +311 -> 7748
    //   7440: aload 29
    //   7442: getfield 2666	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   7445: astore 28
    //   7447: aload 29
    //   7449: aload 30
    //   7451: aload 28
    //   7453: ldc 140
    //   7455: ldc_w 2701
    //   7458: aload_1
    //   7459: invokevirtual 2704	OnlinePushPack/MsgInfo:getUMsgTime	()J
    //   7462: sipush -2029
    //   7465: iconst_0
    //   7466: aload_1
    //   7467: invokevirtual 2707	OnlinePushPack/MsgInfo:getShMsgSeq	()S
    //   7470: i2l
    //   7471: invokevirtual 2708	com/tencent/mobileqq/data/MessageForQQWalletTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   7474: aload 29
    //   7476: iconst_1
    //   7477: putfield 2709	com/tencent/mobileqq/data/MessageForQQWalletTips:isread	Z
    //   7480: aload 29
    //   7482: aload_1
    //   7483: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   7486: i2l
    //   7487: putfield 2710	com/tencent/mobileqq/data/MessageForQQWalletTips:shmsgseq	J
    //   7490: aload 29
    //   7492: aload_1
    //   7493: getfield 1194	OnlinePushPack/MsgInfo:lMsgUid	J
    //   7496: putfield 2711	com/tencent/mobileqq/data/MessageForQQWalletTips:msgUid	J
    //   7499: aload 29
    //   7501: invokevirtual 2714	com/tencent/mobileqq/data/MessageForQQWalletTips:getBytes	()[B
    //   7504: pop
    //   7505: aload 29
    //   7507: invokevirtual 2717	com/tencent/mobileqq/data/MessageForQQWalletTips:onReceiveGrapTips	()V
    //   7510: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7513: ifeq +79 -> 7592
    //   7516: ldc_w 520
    //   7519: iconst_2
    //   7520: new 88	java/lang/StringBuilder
    //   7523: dup
    //   7524: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   7527: ldc_w 2719
    //   7530: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7533: aload 29
    //   7535: getfield 2688	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   7538: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7541: ldc_w 2721
    //   7544: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7547: aload 29
    //   7549: getfield 2694	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   7552: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7555: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7558: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7561: ldc_w 520
    //   7564: iconst_2
    //   7565: new 88	java/lang/StringBuilder
    //   7568: dup
    //   7569: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   7572: ldc_w 2723
    //   7575: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7578: aload 29
    //   7580: getfield 2699	com/tencent/mobileqq/data/MessageForQQWalletTips:bytes_jumpurl	Ljava/lang/String;
    //   7583: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7586: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7589: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7592: aload 29
    //   7594: getfield 2688	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   7597: iconst_1
    //   7598: if_icmpne +11 -> 7609
    //   7601: aload 29
    //   7603: getfield 2694	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   7606: ifeq +9793 -> 17399
    //   7609: aload 29
    //   7611: astore_1
    //   7612: aload 29
    //   7614: getfield 2688	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   7617: iconst_1
    //   7618: if_icmpne +128 -> 7746
    //   7621: aload_0
    //   7622: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7625: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7628: astore 28
    //   7630: aconst_null
    //   7631: astore_1
    //   7632: aload 28
    //   7634: aload 29
    //   7636: getfield 2660	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7639: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7642: ifeq +124 -> 7766
    //   7645: aload 29
    //   7647: getfield 2672	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   7650: astore_1
    //   7651: ldc_w 2724
    //   7654: invokestatic 2727	ajyc:a	(I)Ljava/lang/String;
    //   7657: astore 28
    //   7659: ldc_w 2728
    //   7662: invokestatic 2727	ajyc:a	(I)Ljava/lang/String;
    //   7665: astore 30
    //   7667: aload 29
    //   7669: aload_0
    //   7670: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7673: aload_1
    //   7674: invokevirtual 2731	com/tencent/mobileqq/data/MessageForQQWalletTips:getQQWalletTips	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   7677: astore 31
    //   7679: aload 29
    //   7681: astore_1
    //   7682: aload 31
    //   7684: invokestatic 673	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7687: ifne +59 -> 7746
    //   7690: aload 31
    //   7692: aload 28
    //   7694: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7697: ifne +16 -> 7713
    //   7700: aload 29
    //   7702: astore_1
    //   7703: aload 31
    //   7705: aload 30
    //   7707: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7710: ifeq +36 -> 7746
    //   7713: aload 29
    //   7715: aload_0
    //   7716: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7719: aload 31
    //   7721: aload 29
    //   7723: getfield 2734	com/tencent/mobileqq/data/MessageForQQWalletTips:highLightStart	I
    //   7726: aload 29
    //   7728: getfield 2737	com/tencent/mobileqq/data/MessageForQQWalletTips:highLightEnd	I
    //   7731: aload 29
    //   7733: getfield 2740	com/tencent/mobileqq/data/MessageForQQWalletTips:textColor	Ljava/lang/String;
    //   7736: aload 29
    //   7738: getfield 2743	com/tencent/mobileqq/data/MessageForQQWalletTips:url	Ljava/lang/String;
    //   7741: invokevirtual 2747	com/tencent/mobileqq/data/MessageForQQWalletTips:addQQWalletTips	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V
    //   7744: aconst_null
    //   7745: astore_1
    //   7746: aload_1
    //   7747: areturn
    //   7748: aload 29
    //   7750: getfield 2660	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7753: astore 28
    //   7755: goto -308 -> 7447
    //   7758: astore_1
    //   7759: aload_1
    //   7760: invokevirtual 1300	java/lang/Exception:printStackTrace	()V
    //   7763: goto -171 -> 7592
    //   7766: aload 28
    //   7768: aload 29
    //   7770: getfield 2666	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   7773: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7776: ifeq -125 -> 7651
    //   7779: aload 29
    //   7781: getfield 2678	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   7784: astore_1
    //   7785: goto -134 -> 7651
    //   7788: aload 32
    //   7790: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7793: ldc2_w 2748
    //   7796: lcmp
    //   7797: ifne +76 -> 7873
    //   7800: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7803: ifeq +13 -> 7816
    //   7806: ldc_w 2751
    //   7809: iconst_2
    //   7810: ldc_w 2753
    //   7813: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7816: new 2755	tencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody
    //   7819: dup
    //   7820: invokespecial 2756	tencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody:<init>	()V
    //   7823: aload 32
    //   7825: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7828: invokevirtual 2757	tencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7831: checkcast 2755	tencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody
    //   7834: astore_1
    //   7835: aload_0
    //   7836: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7839: bipush 85
    //   7841: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   7844: checkcast 2759	bduw
    //   7847: aload_1
    //   7848: invokevirtual 2762	bduw:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody;)V
    //   7851: aconst_null
    //   7852: areturn
    //   7853: astore_1
    //   7854: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7857: ifeq -7828 -> 29
    //   7860: ldc_w 520
    //   7863: iconst_2
    //   7864: ldc_w 2764
    //   7867: aload_1
    //   7868: invokestatic 1599	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   7871: aconst_null
    //   7872: areturn
    //   7873: aload 32
    //   7875: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7878: ldc2_w 2765
    //   7881: lcmp
    //   7882: ifne +76 -> 7958
    //   7885: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7888: ifeq +13 -> 7901
    //   7891: ldc_w 2768
    //   7894: iconst_2
    //   7895: ldc_w 2770
    //   7898: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7901: new 2772	tencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody
    //   7904: dup
    //   7905: invokespecial 2773	tencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody:<init>	()V
    //   7908: aload 32
    //   7910: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7913: invokevirtual 2774	tencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7916: checkcast 2772	tencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody
    //   7919: astore_1
    //   7920: aload_0
    //   7921: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7924: bipush 85
    //   7926: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   7929: checkcast 2759	bduw
    //   7932: aload_1
    //   7933: invokevirtual 2777	bduw:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody;)V
    //   7936: aconst_null
    //   7937: areturn
    //   7938: astore_1
    //   7939: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7942: ifeq -7913 -> 29
    //   7945: ldc_w 520
    //   7948: iconst_2
    //   7949: ldc_w 2779
    //   7952: aload_1
    //   7953: invokestatic 1599	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   7956: aconst_null
    //   7957: areturn
    //   7958: aload 32
    //   7960: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7963: ldc2_w 2780
    //   7966: lcmp
    //   7967: ifne +360 -> 8327
    //   7970: new 2783	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody
    //   7973: dup
    //   7974: invokespecial 2784	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:<init>	()V
    //   7977: astore 31
    //   7979: sipush -2029
    //   7982: invokestatic 1219	axaq:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7985: checkcast 2653	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   7988: astore 30
    //   7990: aload 31
    //   7992: aload 32
    //   7994: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7997: invokevirtual 2785	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8000: pop
    //   8001: iconst_0
    //   8002: istore 5
    //   8004: ldc 140
    //   8006: astore 29
    //   8008: aload 29
    //   8010: astore 28
    //   8012: iload 5
    //   8014: istore 4
    //   8016: aload 31
    //   8018: getfield 2789	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:sint32_sessiontype	Lcom/tencent/mobileqq/pb/PBSInt32Field;
    //   8021: invokevirtual 2792	com/tencent/mobileqq/pb/PBSInt32Field:get	()I
    //   8024: tableswitch	default:+9436 -> 17460, 3:+243->8267, 4:+264->8288, 5:+32->8056, 6:+9450->17474
    //   8057: lload_0
    //   8058: new 88	java/lang/StringBuilder
    //   8061: dup
    //   8062: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   8065: aload 31
    //   8067: getfield 2793	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8070: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8073: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8076: ldc 140
    //   8078: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8081: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8084: putfield 2660	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   8087: aload 30
    //   8089: new 88	java/lang/StringBuilder
    //   8092: dup
    //   8093: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   8096: aload 31
    //   8098: getfield 2794	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_receiver_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8101: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8104: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8107: ldc 140
    //   8109: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8112: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8115: putfield 2666	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   8118: aload 30
    //   8120: aload 31
    //   8122: getfield 2795	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:bytes_sender_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8125: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8128: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8131: putfield 2672	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   8134: aload 30
    //   8136: aload 31
    //   8138: getfield 2796	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:bytes_receiver_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8141: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8144: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8147: putfield 2678	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   8150: aload 30
    //   8152: aload 31
    //   8154: getfield 2797	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:bytes_authkey	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8157: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8160: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8163: putfield 2684	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   8166: aload_0
    //   8167: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8170: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   8173: astore 31
    //   8175: aload_0
    //   8176: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8179: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   8182: aload 30
    //   8184: getfield 2660	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   8187: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8190: ifeq +119 -> 8309
    //   8193: aload 30
    //   8195: getfield 2666	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   8198: astore 29
    //   8200: aload 30
    //   8202: aload 31
    //   8204: aload 29
    //   8206: aload 28
    //   8208: ldc_w 2701
    //   8211: aload_1
    //   8212: invokevirtual 2704	OnlinePushPack/MsgInfo:getUMsgTime	()J
    //   8215: sipush -2029
    //   8218: iload 4
    //   8220: aload_1
    //   8221: invokevirtual 2707	OnlinePushPack/MsgInfo:getShMsgSeq	()S
    //   8224: i2l
    //   8225: invokevirtual 2708	com/tencent/mobileqq/data/MessageForQQWalletTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   8228: aload 30
    //   8230: iconst_1
    //   8231: putfield 2709	com/tencent/mobileqq/data/MessageForQQWalletTips:isread	Z
    //   8234: aload 30
    //   8236: aload_1
    //   8237: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   8240: i2l
    //   8241: putfield 2710	com/tencent/mobileqq/data/MessageForQQWalletTips:shmsgseq	J
    //   8244: aload 30
    //   8246: aload_1
    //   8247: getfield 1194	OnlinePushPack/MsgInfo:lMsgUid	J
    //   8250: putfield 2711	com/tencent/mobileqq/data/MessageForQQWalletTips:msgUid	J
    //   8253: aload 30
    //   8255: invokevirtual 2714	com/tencent/mobileqq/data/MessageForQQWalletTips:getBytes	()[B
    //   8258: pop
    //   8259: aload 30
    //   8261: invokevirtual 2717	com/tencent/mobileqq/data/MessageForQQWalletTips:onReceiveGrapTips	()V
    //   8264: goto +9207 -> 17471
    //   8267: sipush 1000
    //   8270: istore 4
    //   8272: aload 31
    //   8274: getfield 2800	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_group_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8277: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8280: invokestatic 495	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   8283: astore 28
    //   8285: goto -229 -> 8056
    //   8288: sipush 1004
    //   8291: istore 4
    //   8293: aload 31
    //   8295: getfield 2800	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_group_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8298: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8301: invokestatic 495	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   8304: astore 28
    //   8306: goto -250 -> 8056
    //   8309: aload 30
    //   8311: getfield 2660	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   8314: astore 29
    //   8316: goto -116 -> 8200
    //   8319: astore_1
    //   8320: aload_1
    //   8321: invokevirtual 1300	java/lang/Exception:printStackTrace	()V
    //   8324: goto +9147 -> 17471
    //   8327: aload 32
    //   8329: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8332: ldc2_w 2801
    //   8335: lcmp
    //   8336: ifne +305 -> 8641
    //   8339: aload_0
    //   8340: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8343: bipush 51
    //   8345: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   8348: checkcast 125	ajxn
    //   8351: astore 34
    //   8353: new 2804	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody
    //   8356: dup
    //   8357: invokespecial 2805	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:<init>	()V
    //   8360: astore 33
    //   8362: sipush -2029
    //   8365: invokestatic 1219	axaq:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   8368: checkcast 2653	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   8371: astore 31
    //   8373: aload 33
    //   8375: aload 32
    //   8377: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8380: invokevirtual 2806	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8383: pop
    //   8384: new 88	java/lang/StringBuilder
    //   8387: dup
    //   8388: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   8391: aload 33
    //   8393: getfield 2807	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:uint64_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8396: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8399: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8402: ldc 140
    //   8404: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8407: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8410: astore 29
    //   8412: new 88	java/lang/StringBuilder
    //   8415: dup
    //   8416: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   8419: aload 33
    //   8421: getfield 2808	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:uint64_receiver_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8424: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8427: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8430: ldc 140
    //   8432: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8435: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8438: astore 30
    //   8440: aload_0
    //   8441: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8444: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   8447: aload 29
    //   8449: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8452: ifeq +166 -> 8618
    //   8455: aload 30
    //   8457: astore 28
    //   8459: aload 34
    //   8461: aload 28
    //   8463: invokevirtual 129	ajxn:e	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   8466: astore 32
    //   8468: aload 32
    //   8470: ifnull +155 -> 8625
    //   8473: aload 32
    //   8475: invokevirtual 146	com/tencent/mobileqq/data/Friends:isFriend	()Z
    //   8478: ifeq +147 -> 8625
    //   8481: iconst_0
    //   8482: istore 4
    //   8484: aload 31
    //   8486: aload 29
    //   8488: putfield 2660	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   8491: aload 31
    //   8493: aload 30
    //   8495: putfield 2666	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   8498: aload 31
    //   8500: aload 33
    //   8502: getfield 2809	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:bytes_sender_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8505: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8508: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8511: putfield 2672	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   8514: aload 31
    //   8516: aload 33
    //   8518: getfield 2810	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:bytes_receiver_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8521: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8524: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8527: putfield 2678	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   8530: aload 31
    //   8532: aload 33
    //   8534: getfield 2811	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:bytes_authkey	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8537: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8540: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8543: putfield 2684	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   8546: aload 31
    //   8548: aload_0
    //   8549: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8552: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   8555: aload 28
    //   8557: ldc 140
    //   8559: ldc_w 2701
    //   8562: aload_1
    //   8563: invokevirtual 2704	OnlinePushPack/MsgInfo:getUMsgTime	()J
    //   8566: sipush -2029
    //   8569: iload 4
    //   8571: aload_1
    //   8572: invokevirtual 2707	OnlinePushPack/MsgInfo:getShMsgSeq	()S
    //   8575: i2l
    //   8576: invokevirtual 2708	com/tencent/mobileqq/data/MessageForQQWalletTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   8579: aload 31
    //   8581: iconst_1
    //   8582: putfield 2709	com/tencent/mobileqq/data/MessageForQQWalletTips:isread	Z
    //   8585: aload 31
    //   8587: aload_1
    //   8588: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   8591: i2l
    //   8592: putfield 2710	com/tencent/mobileqq/data/MessageForQQWalletTips:shmsgseq	J
    //   8595: aload 31
    //   8597: aload_1
    //   8598: getfield 1194	OnlinePushPack/MsgInfo:lMsgUid	J
    //   8601: putfield 2711	com/tencent/mobileqq/data/MessageForQQWalletTips:msgUid	J
    //   8604: aload 31
    //   8606: invokevirtual 2714	com/tencent/mobileqq/data/MessageForQQWalletTips:getBytes	()[B
    //   8609: pop
    //   8610: aload 31
    //   8612: invokevirtual 2717	com/tencent/mobileqq/data/MessageForQQWalletTips:onReceiveGrapTips	()V
    //   8615: aload 31
    //   8617: areturn
    //   8618: aload 29
    //   8620: astore 28
    //   8622: goto -163 -> 8459
    //   8625: sipush 1001
    //   8628: istore 4
    //   8630: goto -146 -> 8484
    //   8633: astore_1
    //   8634: aload_1
    //   8635: invokevirtual 1300	java/lang/Exception:printStackTrace	()V
    //   8638: goto -23 -> 8615
    //   8641: aload 32
    //   8643: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8646: ldc2_w 2812
    //   8649: lcmp
    //   8650: ifne +62 -> 8712
    //   8653: aload_0
    //   8654: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8657: bipush 62
    //   8659: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   8662: checkcast 2815	akub
    //   8665: aload 32
    //   8667: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8670: invokevirtual 2816	akub:a	([B)V
    //   8673: aload_1
    //   8674: getfield 1143	OnlinePushPack/MsgInfo:lFromUin	J
    //   8677: lstore_2
    //   8678: aload_1
    //   8679: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   8682: istore 4
    //   8684: aload_1
    //   8685: getfield 1194	OnlinePushPack/MsgInfo:lMsgUid	J
    //   8688: lstore 15
    //   8690: aload_1
    //   8691: getfield 1140	OnlinePushPack/MsgInfo:shMsgType	S
    //   8694: istore 5
    //   8696: aload_0
    //   8697: getfield 1456	akqf:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   8700: lload_2
    //   8701: iload 4
    //   8703: lload 15
    //   8705: iload 5
    //   8707: invokestatic 1868	axao:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   8710: aconst_null
    //   8711: areturn
    //   8712: aload 32
    //   8714: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8717: ldc2_w 2817
    //   8720: lcmp
    //   8721: ifne +114 -> 8835
    //   8724: new 2820	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody
    //   8727: dup
    //   8728: invokespecial 2821	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:<init>	()V
    //   8731: astore_1
    //   8732: aload_1
    //   8733: aload 32
    //   8735: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8738: invokevirtual 2822	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8741: pop
    //   8742: aload_1
    //   8743: getfield 2825	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:uint64_friend_msg_type_flag	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8746: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   8749: ifeq +34 -> 8783
    //   8752: aload_1
    //   8753: getfield 2825	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:uint64_friend_msg_type_flag	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8756: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8759: lconst_1
    //   8760: lcmp
    //   8761: ifne +68 -> 8829
    //   8764: iconst_1
    //   8765: istore 4
    //   8767: iload 4
    //   8769: ifeq +14 -> 8783
    //   8772: aload_0
    //   8773: getfield 1456	akqf:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   8776: invokevirtual 1386	com/tencent/mobileqq/app/MessageHandler:a	()Lakqx;
    //   8779: iconst_2
    //   8780: invokevirtual 1389	akqx:a	(I)V
    //   8783: aload_1
    //   8784: getfield 2828	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:rpt_msg_msg_notify	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   8787: invokevirtual 1927	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   8790: ifeq -8761 -> 29
    //   8793: aload_0
    //   8794: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8797: aload_1
    //   8798: invokestatic 2833	afjm:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ltencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody;)V
    //   8801: aconst_null
    //   8802: areturn
    //   8803: astore_1
    //   8804: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8807: ifeq +13 -> 8820
    //   8810: ldc_w 2427
    //   8813: iconst_2
    //   8814: ldc 140
    //   8816: aload_1
    //   8817: invokestatic 2429	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   8820: new 2431	java/lang/RuntimeException
    //   8823: dup
    //   8824: aload_1
    //   8825: invokespecial 2434	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   8828: athrow
    //   8829: iconst_0
    //   8830: istore 4
    //   8832: goto -65 -> 8767
    //   8835: aload 32
    //   8837: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8840: ldc2_w 2834
    //   8843: lcmp
    //   8844: ifeq +15 -> 8859
    //   8847: aload 32
    //   8849: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8852: ldc2_w 2836
    //   8855: lcmp
    //   8856: ifne +68 -> 8924
    //   8859: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8862: ifeq +13 -> 8875
    //   8865: ldc_w 2839
    //   8868: iconst_2
    //   8869: ldc_w 2841
    //   8872: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8875: new 2843	tencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody
    //   8878: dup
    //   8879: invokespecial 2844	tencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody:<init>	()V
    //   8882: astore_1
    //   8883: aload_1
    //   8884: aload 32
    //   8886: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8889: invokevirtual 2845	tencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8892: pop
    //   8893: aload_0
    //   8894: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8897: aload_1
    //   8898: lconst_0
    //   8899: iconst_0
    //   8900: invokestatic 2848	axao:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ltencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody;JZ)V
    //   8903: aconst_null
    //   8904: areturn
    //   8905: astore_1
    //   8906: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8909: ifeq -8880 -> 29
    //   8912: ldc_w 2839
    //   8915: iconst_2
    //   8916: ldc_w 2850
    //   8919: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8922: aconst_null
    //   8923: areturn
    //   8924: aload 32
    //   8926: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8929: ldc2_w 2851
    //   8932: lcmp
    //   8933: ifne +25 -> 8958
    //   8936: aload_0
    //   8937: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8940: bipush 51
    //   8942: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   8945: checkcast 2211	yak
    //   8948: aload 32
    //   8950: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8953: invokevirtual 2853	yak:a	([B)V
    //   8956: aconst_null
    //   8957: areturn
    //   8958: aload 32
    //   8960: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8963: ldc2_w 2854
    //   8966: lcmp
    //   8967: ifne +24 -> 8991
    //   8970: iconst_2
    //   8971: invokestatic 2861	com/tencent/mqp/app/sec/d:x	()[Ljava/lang/Object;
    //   8974: aload 32
    //   8976: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8979: invokestatic 2865	com/tencent/mqp/app/sec/d:e1	(I[Ljava/lang/Object;[B)V
    //   8982: aconst_null
    //   8983: areturn
    //   8984: astore_1
    //   8985: aload_1
    //   8986: invokevirtual 2866	java/lang/Throwable:printStackTrace	()V
    //   8989: aconst_null
    //   8990: areturn
    //   8991: aload 32
    //   8993: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8996: ldc2_w 2867
    //   8999: lcmp
    //   9000: ifne +182 -> 9182
    //   9003: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9006: ifeq +13 -> 9019
    //   9009: ldc_w 520
    //   9012: iconst_4
    //   9013: ldc_w 2870
    //   9016: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9019: new 2872	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody
    //   9022: dup
    //   9023: invokespecial 2873	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:<init>	()V
    //   9026: astore_1
    //   9027: aload_1
    //   9028: aload 32
    //   9030: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   9033: invokevirtual 2874	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   9036: pop
    //   9037: new 325	android/content/Intent
    //   9040: dup
    //   9041: ldc_w 2876
    //   9044: invokespecial 329	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   9047: astore 28
    //   9049: aload_1
    //   9050: getfield 2879	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:uint32_push_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9053: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   9056: ifeq +114 -> 9170
    //   9059: aload_1
    //   9060: getfield 2879	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:uint32_push_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9063: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9066: tableswitch	default:+8420 -> 17486, 0:+80->9146, 1:+92->9158
    //   9089: iload_2
    //   9090: ldc_w 2881
    //   9093: invokevirtual 2884	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   9096: pop
    //   9097: aload 28
    //   9099: ldc_w 2886
    //   9102: aload_1
    //   9103: getfield 2889	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:string_push_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9106: invokevirtual 1790	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9109: invokevirtual 474	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   9112: pop
    //   9113: aload_0
    //   9114: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9117: invokevirtual 353	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9120: aload 28
    //   9122: invokevirtual 357	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   9125: aconst_null
    //   9126: areturn
    //   9127: astore_1
    //   9128: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9131: ifeq -9102 -> 29
    //   9134: ldc_w 520
    //   9137: iconst_4
    //   9138: ldc_w 2891
    //   9141: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9144: aconst_null
    //   9145: areturn
    //   9146: aload 28
    //   9148: ldc_w 2881
    //   9151: invokevirtual 2884	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   9154: pop
    //   9155: goto -58 -> 9097
    //   9158: aload 28
    //   9160: ldc_w 2893
    //   9163: invokevirtual 2884	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   9166: pop
    //   9167: goto -70 -> 9097
    //   9170: aload 28
    //   9172: ldc_w 2881
    //   9175: invokevirtual 2884	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   9178: pop
    //   9179: goto -82 -> 9097
    //   9182: aload 32
    //   9184: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   9187: ldc2_w 2894
    //   9190: lcmp
    //   9191: ifne +240 -> 9431
    //   9194: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9197: ifeq +13 -> 9210
    //   9200: ldc_w 520
    //   9203: iconst_2
    //   9204: ldc_w 2897
    //   9207: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9210: new 2899	tencent/im/s2c/msgtype0x210/submsgtype0xce/submsgtype0xce$MsgBody
    //   9213: dup
    //   9214: invokespecial 2900	tencent/im/s2c/msgtype0x210/submsgtype0xce/submsgtype0xce$MsgBody:<init>	()V
    //   9217: astore_1
    //   9218: aload_1
    //   9219: aload 32
    //   9221: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   9224: invokevirtual 2901	tencent/im/s2c/msgtype0x210/submsgtype0xce/submsgtype0xce$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   9227: pop
    //   9228: aload_1
    //   9229: getfield 2904	tencent/im/s2c/msgtype0x210/submsgtype0xce/submsgtype0xce$MsgBody:string_params	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9232: invokevirtual 1790	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9235: astore_1
    //   9236: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9239: ifeq +29 -> 9268
    //   9242: ldc_w 520
    //   9245: new 88	java/lang/StringBuilder
    //   9248: dup
    //   9249: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   9252: ldc_w 2906
    //   9255: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9258: aload_1
    //   9259: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9262: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9265: invokestatic 2910	bdoe:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   9268: new 2507	org/json/JSONObject
    //   9271: dup
    //   9272: aload_1
    //   9273: invokespecial 2511	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9276: ldc_w 2912
    //   9279: invokevirtual 2520	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9282: astore 28
    //   9284: ldc_w 2914
    //   9287: invokestatic 2917	yod:a	(Ljava/lang/String;)Ljava/lang/String;
    //   9290: ldc_w 2919
    //   9293: invokevirtual 2923	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   9296: astore 29
    //   9298: iconst_0
    //   9299: istore 6
    //   9301: iconst_0
    //   9302: istore 4
    //   9304: iload 6
    //   9306: istore 5
    //   9308: iload 4
    //   9310: aload 29
    //   9312: arraylength
    //   9313: if_icmpge +38 -> 9351
    //   9316: aload 29
    //   9318: iload 4
    //   9320: aaload
    //   9321: invokestatic 673	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9324: ifne +98 -> 9422
    //   9327: aload 28
    //   9329: invokestatic 673	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9332: ifne +90 -> 9422
    //   9335: aload 29
    //   9337: iload 4
    //   9339: aaload
    //   9340: aload 28
    //   9342: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9345: ifeq +77 -> 9422
    //   9348: iconst_1
    //   9349: istore 5
    //   9351: iload 5
    //   9353: ifne +33 -> 9386
    //   9356: aload 28
    //   9358: invokestatic 673	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9361: ifne +25 -> 9386
    //   9364: aload 28
    //   9366: ldc_w 2925
    //   9369: invokestatic 2927	yod:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   9372: pop
    //   9373: aload 28
    //   9375: aload_1
    //   9376: ldc_w 2929
    //   9379: invokestatic 2932	yod:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   9382: pop
    //   9383: invokestatic 2936	ynz:a	()V
    //   9386: invokestatic 2939	com/tencent/gamecenter/appointment/GameCenterCheck:b	()V
    //   9389: aload_0
    //   9390: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9393: ldc_w 2941
    //   9396: ldc_w 2943
    //   9399: aload 28
    //   9401: ldc_w 2945
    //   9404: ldc_w 2947
    //   9407: ldc_w 2949
    //   9410: invokestatic 2952	yod:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   9413: aconst_null
    //   9414: areturn
    //   9415: astore_1
    //   9416: aload_1
    //   9417: invokevirtual 1300	java/lang/Exception:printStackTrace	()V
    //   9420: aconst_null
    //   9421: areturn
    //   9422: iload 4
    //   9424: iconst_1
    //   9425: iadd
    //   9426: istore 4
    //   9428: goto -124 -> 9304
    //   9431: aload 32
    //   9433: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   9436: ldc2_w 2953
    //   9439: lcmp
    //   9440: ifne +58 -> 9498
    //   9443: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9446: ifeq +13 -> 9459
    //   9449: ldc_w 520
    //   9452: iconst_2
    //   9453: ldc_w 2956
    //   9456: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9459: new 2958	tencent/im/s2c/msgtype0x210/submsgtype0x11c/MsgBody
    //   9462: dup
    //   9463: invokespecial 2959	tencent/im/s2c/msgtype0x210/submsgtype0x11c/MsgBody:<init>	()V
    //   9466: astore_1
    //   9467: aload_1
    //   9468: aload 32
    //   9470: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   9473: invokevirtual 2960	tencent/im/s2c/msgtype0x210/submsgtype0x11c/MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   9476: pop
    //   9477: aload_0
    //   9478: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9481: bipush 12
    //   9483: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9486: checkcast 1528	axbt
    //   9489: aload_1
    //   9490: invokevirtual 2963	axbt:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x11c/MsgBody;)V
    //   9493: aconst_null
    //   9494: areturn
    //   9495: astore_1
    //   9496: aconst_null
    //   9497: areturn
    //   9498: aload 32
    //   9500: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   9503: ldc2_w 2964
    //   9506: lcmp
    //   9507: ifne +1451 -> 10958
    //   9510: new 2967	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody
    //   9513: dup
    //   9514: invokespecial 2968	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:<init>	()V
    //   9517: astore 28
    //   9519: aload 28
    //   9521: aload 32
    //   9523: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   9526: invokevirtual 2969	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   9529: pop
    //   9530: aload 28
    //   9532: getfield 2972	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_folder_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9535: invokevirtual 2093	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   9538: ifeq +1201 -> 10739
    //   9541: aload 28
    //   9543: getfield 2972	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_folder_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9546: invokevirtual 1790	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9549: invokevirtual 2975	java/lang/String:trim	()Ljava/lang/String;
    //   9552: astore_1
    //   9553: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9556: ifeq +30 -> 9586
    //   9559: ldc_w 2977
    //   9562: iconst_2
    //   9563: new 88	java/lang/StringBuilder
    //   9566: dup
    //   9567: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   9570: ldc_w 2979
    //   9573: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9576: aload_1
    //   9577: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9580: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9583: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9586: aload 28
    //   9588: getfield 2982	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_discover_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9591: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9594: iconst_1
    //   9595: if_icmpne +1150 -> 10745
    //   9598: iconst_1
    //   9599: istore 22
    //   9601: aload 28
    //   9603: getfield 2985	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_folder_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9606: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9609: iconst_1
    //   9610: if_icmpne +1141 -> 10751
    //   9613: iconst_1
    //   9614: istore 23
    //   9616: aload 28
    //   9618: getfield 2988	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_discount_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9621: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9624: iconst_1
    //   9625: if_icmpne +1132 -> 10757
    //   9628: iconst_1
    //   9629: istore 20
    //   9631: aload 28
    //   9633: getfield 2991	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_nearby_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9636: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9639: iconst_1
    //   9640: if_icmpne +1123 -> 10763
    //   9643: iconst_1
    //   9644: istore 19
    //   9646: aload 28
    //   9648: getfield 2994	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_mine_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9651: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9654: iconst_1
    //   9655: if_icmpne +1114 -> 10769
    //   9658: iconst_1
    //   9659: istore 21
    //   9661: aload 28
    //   9663: getfield 2997	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_start_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9666: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9669: istore 6
    //   9671: aload 28
    //   9673: getfield 3000	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_end_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9676: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9679: istore 7
    //   9681: invokestatic 512	java/lang/System:currentTimeMillis	()J
    //   9684: ldc2_w 941
    //   9687: ldiv
    //   9688: l2i
    //   9689: istore 8
    //   9691: aload 28
    //   9693: getfield 3003	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_period_of_validity	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9696: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9699: istore 5
    //   9701: aload 28
    //   9703: getfield 3006	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_task_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9706: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9709: istore 9
    //   9711: aload 28
    //   9713: getfield 3009	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_task_info	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9716: invokevirtual 1790	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9719: astore 31
    //   9721: aload 28
    //   9723: getfield 3012	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_type_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9726: invokevirtual 1790	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9729: astore 32
    //   9731: aload 28
    //   9733: getfield 3015	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_type_color	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9736: invokevirtual 1790	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9739: astore 33
    //   9741: aload 28
    //   9743: getfield 3018	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_jump_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9746: invokevirtual 1790	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9749: astore 29
    //   9751: aload 28
    //   9753: getfield 3021	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9756: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9759: istore 10
    //   9761: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9764: ifeq +163 -> 9927
    //   9767: ldc_w 2977
    //   9770: iconst_2
    //   9771: new 88	java/lang/StringBuilder
    //   9774: dup
    //   9775: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   9778: ldc_w 3023
    //   9781: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9784: iload 6
    //   9786: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9789: ldc_w 3025
    //   9792: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9795: iload 7
    //   9797: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9800: ldc_w 3027
    //   9803: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9806: iload 5
    //   9808: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9811: ldc_w 3029
    //   9814: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9817: iload 23
    //   9819: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9822: ldc_w 3031
    //   9825: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9828: iload 22
    //   9830: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9833: ldc_w 3031
    //   9836: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9839: iload 20
    //   9841: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9844: ldc_w 3031
    //   9847: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9850: iload 19
    //   9852: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9855: ldc_w 3031
    //   9858: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9861: iload 21
    //   9863: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9866: ldc_w 3033
    //   9869: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9872: iload 9
    //   9874: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9877: ldc_w 3035
    //   9880: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9883: aload 31
    //   9885: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9888: ldc_w 3037
    //   9891: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9894: aload 32
    //   9896: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9899: ldc_w 3039
    //   9902: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9905: aload 33
    //   9907: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9910: ldc_w 3041
    //   9913: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9916: aload 29
    //   9918: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9921: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9924: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9927: iload 8
    //   9929: iload 6
    //   9931: if_icmplt -9902 -> 29
    //   9934: iload 8
    //   9936: iload 7
    //   9938: if_icmpgt -9909 -> 29
    //   9941: iload 5
    //   9943: istore 4
    //   9945: iload 5
    //   9947: ldc_w 3042
    //   9950: if_icmple +8 -> 9958
    //   9953: ldc_w 3042
    //   9956: istore 4
    //   9958: iload 22
    //   9960: ifne +18 -> 9978
    //   9963: iload 20
    //   9965: ifne +13 -> 9978
    //   9968: iload 19
    //   9970: ifne +8 -> 9978
    //   9973: iload 21
    //   9975: ifeq +7421 -> 17396
    //   9978: iconst_1
    //   9979: istore 23
    //   9981: iload 23
    //   9983: ifne +7394 -> 17377
    //   9986: iload 22
    //   9988: ifne +15 -> 10003
    //   9991: aload 28
    //   9993: getfield 3045	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_discover_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9996: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9999: iconst_1
    //   10000: if_icmpne +775 -> 10775
    //   10003: iconst_1
    //   10004: istore 22
    //   10006: iload 20
    //   10008: ifne +15 -> 10023
    //   10011: aload 28
    //   10013: getfield 3048	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_discount_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   10016: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   10019: iconst_1
    //   10020: if_icmpne +761 -> 10781
    //   10023: iconst_1
    //   10024: istore 20
    //   10026: iload 19
    //   10028: ifne +15 -> 10043
    //   10031: aload 28
    //   10033: getfield 3051	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_nearby_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   10036: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   10039: iconst_1
    //   10040: if_icmpne +747 -> 10787
    //   10043: iconst_1
    //   10044: istore 19
    //   10046: iload 21
    //   10048: ifne +15 -> 10063
    //   10051: aload 28
    //   10053: getfield 3054	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_mine_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   10056: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   10059: iconst_1
    //   10060: if_icmpne +733 -> 10793
    //   10063: iconst_1
    //   10064: istore 21
    //   10066: iload 21
    //   10068: istore 24
    //   10070: iload 22
    //   10072: istore 25
    //   10074: iload 20
    //   10076: istore 26
    //   10078: iload 19
    //   10080: istore 27
    //   10082: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10085: ifeq +80 -> 10165
    //   10088: ldc_w 2977
    //   10091: iconst_2
    //   10092: new 88	java/lang/StringBuilder
    //   10095: dup
    //   10096: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   10099: ldc_w 3056
    //   10102: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10105: iload 22
    //   10107: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10110: ldc_w 3031
    //   10113: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10116: iload 20
    //   10118: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10121: ldc_w 3031
    //   10124: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10127: iload 19
    //   10129: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10132: ldc_w 3031
    //   10135: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10138: iload 21
    //   10140: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10143: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10146: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   10149: iload 19
    //   10151: istore 27
    //   10153: iload 20
    //   10155: istore 26
    //   10157: iload 22
    //   10159: istore 25
    //   10161: iload 21
    //   10163: istore 24
    //   10165: aload_0
    //   10166: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10169: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   10172: astore 30
    //   10174: aload 30
    //   10176: astore 28
    //   10178: aload 30
    //   10180: invokestatic 673	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10183: ifeq +8 -> 10191
    //   10186: ldc_w 3058
    //   10189: astore 28
    //   10191: aload_0
    //   10192: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10195: invokevirtual 353	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10198: new 88	java/lang/StringBuilder
    //   10201: dup
    //   10202: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   10205: ldc_w 3060
    //   10208: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10211: aload 28
    //   10213: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10216: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10219: iconst_0
    //   10220: invokevirtual 1029	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   10223: astore 30
    //   10225: aload 30
    //   10227: invokeinterface 429 1 0
    //   10232: astore 28
    //   10234: aload 30
    //   10236: ldc_w 3062
    //   10239: iconst_0
    //   10240: invokeinterface 3066 3 0
    //   10245: ifne +59 -> 10304
    //   10248: aload 30
    //   10250: ldc_w 3068
    //   10253: iconst_0
    //   10254: invokeinterface 3066 3 0
    //   10259: ifne +45 -> 10304
    //   10262: aload 30
    //   10264: ldc_w 3070
    //   10267: iconst_0
    //   10268: invokeinterface 3066 3 0
    //   10273: ifne +31 -> 10304
    //   10276: aload 30
    //   10278: ldc_w 3072
    //   10281: iconst_0
    //   10282: invokeinterface 3066 3 0
    //   10287: ifne +17 -> 10304
    //   10290: aload 30
    //   10292: ldc_w 3074
    //   10295: iconst_0
    //   10296: invokeinterface 3066 3 0
    //   10301: ifeq +109 -> 10410
    //   10304: aload 30
    //   10306: ldc_w 3076
    //   10309: iconst_0
    //   10310: invokeinterface 444 3 0
    //   10315: istore 5
    //   10317: aload 30
    //   10319: ldc_w 3078
    //   10322: iconst_0
    //   10323: invokeinterface 444 3 0
    //   10328: istore 11
    //   10330: aload 30
    //   10332: ldc_w 3080
    //   10335: iconst_0
    //   10336: invokeinterface 444 3 0
    //   10341: istore 12
    //   10343: aload 30
    //   10345: ldc_w 3082
    //   10348: iconst_0
    //   10349: invokeinterface 444 3 0
    //   10354: istore 13
    //   10356: invokestatic 512	java/lang/System:currentTimeMillis	()J
    //   10359: ldc2_w 941
    //   10362: ldiv
    //   10363: l2i
    //   10364: istore 14
    //   10366: iload 14
    //   10368: ifeq +42 -> 10410
    //   10371: iload 11
    //   10373: ifeq +37 -> 10410
    //   10376: iload 12
    //   10378: ifeq +32 -> 10410
    //   10381: iload 13
    //   10383: ifeq +27 -> 10410
    //   10386: iload 14
    //   10388: iload 11
    //   10390: if_icmplt +409 -> 10799
    //   10393: iload 14
    //   10395: iload 12
    //   10397: if_icmpgt +402 -> 10799
    //   10400: iload 14
    //   10402: iload 5
    //   10404: isub
    //   10405: iload 13
    //   10407: if_icmpge +392 -> 10799
    //   10410: aload 28
    //   10412: ldc_w 3078
    //   10415: iload 6
    //   10417: invokeinterface 437 3 0
    //   10422: pop
    //   10423: aload 28
    //   10425: ldc_w 3080
    //   10428: iload 7
    //   10430: invokeinterface 437 3 0
    //   10435: pop
    //   10436: aload 28
    //   10438: ldc_w 3082
    //   10441: iload 4
    //   10443: invokeinterface 437 3 0
    //   10448: pop
    //   10449: aload 28
    //   10451: ldc_w 3084
    //   10454: aload_1
    //   10455: invokeinterface 3088 3 0
    //   10460: pop
    //   10461: aload 28
    //   10463: ldc_w 3076
    //   10466: iload 8
    //   10468: invokeinterface 437 3 0
    //   10473: pop
    //   10474: aload 28
    //   10476: ldc_w 3090
    //   10479: iload 9
    //   10481: invokeinterface 437 3 0
    //   10486: pop
    //   10487: aload 28
    //   10489: ldc_w 3092
    //   10492: aload 31
    //   10494: invokeinterface 3088 3 0
    //   10499: pop
    //   10500: aload 28
    //   10502: ldc_w 3094
    //   10505: aload 32
    //   10507: invokeinterface 3088 3 0
    //   10512: pop
    //   10513: aload 28
    //   10515: ldc_w 3096
    //   10518: aload 33
    //   10520: invokeinterface 3088 3 0
    //   10525: pop
    //   10526: aload 28
    //   10528: ldc_w 3098
    //   10531: invokestatic 581	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   10534: invokeinterface 1042 4 0
    //   10539: pop
    //   10540: aload 28
    //   10542: ldc_w 3100
    //   10545: iload 10
    //   10547: invokeinterface 437 3 0
    //   10552: pop
    //   10553: aload 29
    //   10555: ifnonnull +323 -> 10878
    //   10558: ldc 140
    //   10560: astore_1
    //   10561: aload 28
    //   10563: ldc_w 3102
    //   10566: aload_1
    //   10567: invokeinterface 3088 3 0
    //   10572: pop
    //   10573: aload 28
    //   10575: ldc_w 3104
    //   10578: iconst_1
    //   10579: invokeinterface 437 3 0
    //   10584: pop
    //   10585: aload 28
    //   10587: ldc_w 3074
    //   10590: iload 23
    //   10592: invokeinterface 1039 3 0
    //   10597: pop
    //   10598: aload 28
    //   10600: ldc_w 3062
    //   10603: iload 25
    //   10605: invokeinterface 1039 3 0
    //   10610: pop
    //   10611: aload 28
    //   10613: ldc_w 3068
    //   10616: iload 26
    //   10618: invokeinterface 1039 3 0
    //   10623: pop
    //   10624: aload 28
    //   10626: ldc_w 3070
    //   10629: iload 27
    //   10631: invokeinterface 1039 3 0
    //   10636: pop
    //   10637: aload 28
    //   10639: ldc_w 3072
    //   10642: iload 24
    //   10644: invokeinterface 1039 3 0
    //   10649: pop
    //   10650: aload 28
    //   10652: invokeinterface 440 1 0
    //   10657: pop
    //   10658: iload 23
    //   10660: ifeq +224 -> 10884
    //   10663: aload_0
    //   10664: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10667: bipush 88
    //   10669: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10672: checkcast 3106	nqq
    //   10675: invokestatic 581	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   10678: iload 23
    //   10680: invokevirtual 3109	nqq:a	(JZ)V
    //   10683: aload_0
    //   10684: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10687: bipush 68
    //   10689: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   10692: checkcast 3111	nqu
    //   10695: invokevirtual 3112	nqu:a	()V
    //   10698: aconst_null
    //   10699: astore_1
    //   10700: iload 25
    //   10702: ifeq +208 -> 10910
    //   10705: ldc_w 3114
    //   10708: astore_1
    //   10709: aload_0
    //   10710: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10713: ldc_w 3116
    //   10716: ldc 140
    //   10718: ldc 140
    //   10720: ldc_w 3118
    //   10723: aload_1
    //   10724: iconst_0
    //   10725: iconst_0
    //   10726: ldc 140
    //   10728: ldc 140
    //   10730: ldc 140
    //   10732: ldc 140
    //   10734: invokestatic 1953	axqw:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   10737: aconst_null
    //   10738: areturn
    //   10739: ldc 140
    //   10741: astore_1
    //   10742: goto -1189 -> 9553
    //   10745: iconst_0
    //   10746: istore 22
    //   10748: goto -1147 -> 9601
    //   10751: iconst_0
    //   10752: istore 23
    //   10754: goto -1138 -> 9616
    //   10757: iconst_0
    //   10758: istore 20
    //   10760: goto -1129 -> 9631
    //   10763: iconst_0
    //   10764: istore 19
    //   10766: goto -1120 -> 9646
    //   10769: iconst_0
    //   10770: istore 21
    //   10772: goto -1111 -> 9661
    //   10775: iconst_0
    //   10776: istore 22
    //   10778: goto -772 -> 10006
    //   10781: iconst_0
    //   10782: istore 20
    //   10784: goto -758 -> 10026
    //   10787: iconst_0
    //   10788: istore 19
    //   10790: goto -744 -> 10046
    //   10793: iconst_0
    //   10794: istore 21
    //   10796: goto -730 -> 10066
    //   10799: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10802: ifeq +13 -> 10815
    //   10805: ldc_w 2977
    //   10808: iconst_2
    //   10809: ldc_w 3120
    //   10812: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   10815: aload 28
    //   10817: ldc_w 3062
    //   10820: iconst_0
    //   10821: invokeinterface 1039 3 0
    //   10826: pop
    //   10827: aload 28
    //   10829: ldc_w 3068
    //   10832: iconst_0
    //   10833: invokeinterface 1039 3 0
    //   10838: pop
    //   10839: aload 28
    //   10841: ldc_w 3070
    //   10844: iconst_0
    //   10845: invokeinterface 1039 3 0
    //   10850: pop
    //   10851: aload 28
    //   10853: ldc_w 3072
    //   10856: iconst_0
    //   10857: invokeinterface 1039 3 0
    //   10862: pop
    //   10863: aload 28
    //   10865: ldc_w 3074
    //   10868: iconst_0
    //   10869: invokeinterface 1039 3 0
    //   10874: pop
    //   10875: goto -465 -> 10410
    //   10878: aload 29
    //   10880: astore_1
    //   10881: goto -320 -> 10561
    //   10884: aload_0
    //   10885: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10888: ldc_w 3122
    //   10891: invokevirtual 3126	com/tencent/mobileqq/app/QQAppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   10894: astore_1
    //   10895: aload_1
    //   10896: ifnull -213 -> 10683
    //   10899: aload_1
    //   10900: sipush 1009
    //   10903: invokevirtual 3131	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   10906: pop
    //   10907: goto -224 -> 10683
    //   10910: iload 26
    //   10912: ifeq +10 -> 10922
    //   10915: ldc_w 3133
    //   10918: astore_1
    //   10919: goto -210 -> 10709
    //   10922: iload 27
    //   10924: ifeq +10 -> 10934
    //   10927: ldc_w 3135
    //   10930: astore_1
    //   10931: goto -222 -> 10709
    //   10934: iload 24
    //   10936: ifeq +10 -> 10946
    //   10939: ldc_w 3137
    //   10942: astore_1
    //   10943: goto -234 -> 10709
    //   10946: iload 23
    //   10948: ifeq -239 -> 10709
    //   10951: ldc_w 3139
    //   10954: astore_1
    //   10955: goto -246 -> 10709
    //   10958: aload 32
    //   10960: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   10963: ldc2_w 3140
    //   10966: lcmp
    //   10967: ifne +88 -> 11055
    //   10970: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10973: ifeq +13 -> 10986
    //   10976: ldc_w 520
    //   10979: iconst_2
    //   10980: ldc_w 3143
    //   10983: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10986: aload_0
    //   10987: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10990: sipush 153
    //   10993: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10996: checkcast 605	airz
    //   10999: astore 28
    //   11001: aload 28
    //   11003: ifnull +13 -> 11016
    //   11006: aload 28
    //   11008: aload 32
    //   11010: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11013: invokevirtual 3144	airz:a	([B)V
    //   11016: aload_1
    //   11017: getfield 1143	OnlinePushPack/MsgInfo:lFromUin	J
    //   11020: lstore_2
    //   11021: aload_1
    //   11022: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   11025: istore 4
    //   11027: aload_1
    //   11028: getfield 1194	OnlinePushPack/MsgInfo:lMsgUid	J
    //   11031: lstore 15
    //   11033: aload_1
    //   11034: getfield 1140	OnlinePushPack/MsgInfo:shMsgType	S
    //   11037: istore 5
    //   11039: aload_0
    //   11040: getfield 1456	akqf:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   11043: lload_2
    //   11044: iload 4
    //   11046: lload 15
    //   11048: iload 5
    //   11050: invokestatic 1868	axao:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   11053: aconst_null
    //   11054: areturn
    //   11055: aload 32
    //   11057: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11060: ldc2_w 3145
    //   11063: lcmp
    //   11064: ifne +56 -> 11120
    //   11067: new 3148	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody
    //   11070: dup
    //   11071: invokespecial 3149	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:<init>	()V
    //   11074: astore_1
    //   11075: aload_1
    //   11076: aload 32
    //   11078: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11081: invokevirtual 3150	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11084: pop
    //   11085: aload_1
    //   11086: getfield 3151	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   11089: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   11092: pop2
    //   11093: aload_1
    //   11094: getfield 3154	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11097: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   11100: pop
    //   11101: aload_1
    //   11102: getfield 3158	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:msg_mod_block	Ltencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock;
    //   11105: invokevirtual 3161	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11108: checkcast 3160	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock
    //   11111: getfield 3164	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock:uint32_op	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11114: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   11117: pop
    //   11118: aconst_null
    //   11119: areturn
    //   11120: aload 32
    //   11122: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11125: ldc2_w 3165
    //   11128: lcmp
    //   11129: ifne +87 -> 11216
    //   11132: new 3168	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody
    //   11135: dup
    //   11136: invokespecial 3169	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:<init>	()V
    //   11139: astore_1
    //   11140: aload_1
    //   11141: aload 32
    //   11143: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11146: invokevirtual 3170	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11149: pop
    //   11150: aload_1
    //   11151: getfield 3173	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:uint32_is_mass_bless_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11154: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   11157: istore 4
    //   11159: iload 4
    //   11161: ifne +26 -> 11187
    //   11164: iconst_1
    //   11165: istore 19
    //   11167: aload_0
    //   11168: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11171: sipush 138
    //   11174: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11177: checkcast 3175	afaz
    //   11180: iload 19
    //   11182: invokevirtual 3177	afaz:c	(Z)V
    //   11185: aconst_null
    //   11186: areturn
    //   11187: iconst_0
    //   11188: istore 19
    //   11190: goto -23 -> 11167
    //   11193: astore_1
    //   11194: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11197: ifeq +13 -> 11210
    //   11200: ldc_w 3179
    //   11203: iconst_2
    //   11204: ldc_w 3181
    //   11207: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11210: iconst_1
    //   11211: istore 19
    //   11213: goto -46 -> 11167
    //   11216: aload 32
    //   11218: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11221: ldc2_w 3182
    //   11224: lcmp
    //   11225: ifne +552 -> 11777
    //   11228: iconst_0
    //   11229: istore 19
    //   11231: aload_0
    //   11232: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11235: invokevirtual 353	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11238: ldc_w 3185
    //   11241: invokevirtual 3188	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   11244: checkcast 3190	android/app/ActivityManager
    //   11247: iconst_1
    //   11248: invokevirtual 3194	android/app/ActivityManager:getRunningTasks	(I)Ljava/util/List;
    //   11251: astore_1
    //   11252: aload_1
    //   11253: ifnull +6118 -> 17371
    //   11256: aload_1
    //   11257: invokeinterface 1526 1 0
    //   11262: iconst_1
    //   11263: if_icmplt +6108 -> 17371
    //   11266: aload_1
    //   11267: iconst_0
    //   11268: invokeinterface 2074 2 0
    //   11273: checkcast 3196	android/app/ActivityManager$RunningTaskInfo
    //   11276: getfield 3200	android/app/ActivityManager$RunningTaskInfo:topActivity	Landroid/content/ComponentName;
    //   11279: invokevirtual 3205	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   11282: astore_1
    //   11283: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11286: ifeq +30 -> 11316
    //   11289: ldc_w 520
    //   11292: iconst_2
    //   11293: new 88	java/lang/StringBuilder
    //   11296: dup
    //   11297: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   11300: ldc_w 3207
    //   11303: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11306: aload_1
    //   11307: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11310: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11313: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11316: ldc_w 3209
    //   11319: aload_1
    //   11320: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11323: istore 20
    //   11325: iload 20
    //   11327: istore 19
    //   11329: aload_0
    //   11330: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11333: invokevirtual 353	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11336: ldc_w 3211
    //   11339: invokevirtual 3188	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   11342: checkcast 3213	android/os/PowerManager
    //   11345: invokevirtual 3216	android/os/PowerManager:isScreenOn	()Z
    //   11348: istore 20
    //   11350: iload 20
    //   11352: ifeq +18 -> 11370
    //   11355: aload_0
    //   11356: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11359: getfield 3219	com/tencent/mobileqq/app/QQAppInterface:isBackground_Pause	Z
    //   11362: ifeq -11333 -> 29
    //   11365: iload 19
    //   11367: ifne -11338 -> 29
    //   11370: new 3221	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody
    //   11373: dup
    //   11374: invokespecial 3222	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:<init>	()V
    //   11377: astore 30
    //   11379: aconst_null
    //   11380: astore_1
    //   11381: aconst_null
    //   11382: astore 28
    //   11384: aconst_null
    //   11385: astore 29
    //   11387: aload 30
    //   11389: aload 32
    //   11391: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11394: invokevirtual 3223	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11397: pop
    //   11398: aload 30
    //   11400: getfield 3226	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11403: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   11406: ifeq +15 -> 11421
    //   11409: aload 30
    //   11411: getfield 3226	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11414: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   11417: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   11420: astore_1
    //   11421: aload 30
    //   11423: getfield 3229	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_brief	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11426: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   11429: ifeq +16 -> 11445
    //   11432: aload 30
    //   11434: getfield 3229	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_brief	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11437: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   11440: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   11443: astore 28
    //   11445: aload 30
    //   11447: getfield 3232	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11450: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   11453: ifeq +16 -> 11469
    //   11456: aload 30
    //   11458: getfield 3232	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11461: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   11464: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   11467: astore 29
    //   11469: aload_1
    //   11470: invokestatic 673	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11473: ifne -11444 -> 29
    //   11476: aload 28
    //   11478: invokestatic 673	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11481: ifne -11452 -> 29
    //   11484: aload 29
    //   11486: invokestatic 673	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11489: ifne -11460 -> 29
    //   11492: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11495: ifeq +52 -> 11547
    //   11498: ldc_w 520
    //   11501: iconst_2
    //   11502: new 88	java/lang/StringBuilder
    //   11505: dup
    //   11506: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   11509: ldc_w 3234
    //   11512: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11515: aload_1
    //   11516: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11519: ldc_w 3236
    //   11522: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11525: aload 28
    //   11527: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11530: ldc_w 3238
    //   11533: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11536: aload 29
    //   11538: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11541: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11544: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11547: new 325	android/content/Intent
    //   11550: dup
    //   11551: aload_0
    //   11552: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11555: invokevirtual 353	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11558: ldc_w 3240
    //   11561: invokespecial 3243	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   11564: astore 30
    //   11566: aload 30
    //   11568: ldc_w 3244
    //   11571: aload 29
    //   11573: invokevirtual 474	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11576: pop
    //   11577: aload 30
    //   11579: ldc_w 3246
    //   11582: sipush 3001
    //   11585: invokevirtual 3249	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11588: pop
    //   11589: new 3251	com/tencent/qphone/base/remote/ToServiceMsg
    //   11592: dup
    //   11593: ldc_w 3253
    //   11596: aload_0
    //   11597: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11600: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   11603: ldc_w 3255
    //   11606: invokespecial 3258	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   11609: astore 29
    //   11611: aload 29
    //   11613: getfield 3262	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   11616: ldc_w 3264
    //   11619: iconst_3
    //   11620: anewarray 274	java/lang/String
    //   11623: dup
    //   11624: iconst_0
    //   11625: aload 28
    //   11627: aastore
    //   11628: dup
    //   11629: iconst_1
    //   11630: aload_1
    //   11631: aastore
    //   11632: dup
    //   11633: iconst_2
    //   11634: aload 28
    //   11636: aastore
    //   11637: invokevirtual 3268	android/os/Bundle:putStringArray	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11640: aload 29
    //   11642: getfield 3262	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   11645: ldc_w 3270
    //   11648: aload 30
    //   11650: invokevirtual 3274	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   11653: aload 29
    //   11655: getfield 3262	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   11658: ldc_w 3276
    //   11661: aconst_null
    //   11662: invokevirtual 3274	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   11665: aload_0
    //   11666: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11669: aload 29
    //   11671: invokevirtual 3280	com/tencent/mobileqq/app/QQAppInterface:sendToService	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   11674: aconst_null
    //   11675: ldc_w 3116
    //   11678: ldc 140
    //   11680: ldc 140
    //   11682: ldc_w 3282
    //   11685: ldc_w 3282
    //   11688: iconst_0
    //   11689: iconst_0
    //   11690: ldc 140
    //   11692: ldc 140
    //   11694: ldc 140
    //   11696: ldc 140
    //   11698: invokestatic 1953	axqw:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   11701: aconst_null
    //   11702: areturn
    //   11703: astore_1
    //   11704: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11707: ifeq +13 -> 11720
    //   11710: ldc_w 520
    //   11713: iconst_2
    //   11714: ldc_w 3284
    //   11717: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11720: aload_1
    //   11721: invokevirtual 1300	java/lang/Exception:printStackTrace	()V
    //   11724: aconst_null
    //   11725: areturn
    //   11726: astore_1
    //   11727: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11730: ifeq +13 -> 11743
    //   11733: ldc_w 520
    //   11736: iconst_2
    //   11737: ldc_w 3286
    //   11740: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11743: aload_1
    //   11744: invokevirtual 1300	java/lang/Exception:printStackTrace	()V
    //   11747: goto -418 -> 11329
    //   11750: astore_1
    //   11751: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11754: ifeq +13 -> 11767
    //   11757: ldc_w 520
    //   11760: iconst_2
    //   11761: ldc_w 3288
    //   11764: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11767: aload_1
    //   11768: invokevirtual 1300	java/lang/Exception:printStackTrace	()V
    //   11771: iconst_1
    //   11772: istore 20
    //   11774: goto -424 -> 11350
    //   11777: aload 32
    //   11779: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11782: ldc2_w 3289
    //   11785: lcmp
    //   11786: ifne +29 -> 11815
    //   11789: aload 32
    //   11791: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11794: ifnull +21 -> 11815
    //   11797: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11800: ifeq -11771 -> 29
    //   11803: ldc_w 520
    //   11806: iconst_2
    //   11807: ldc_w 3292
    //   11810: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11813: aconst_null
    //   11814: areturn
    //   11815: aload 32
    //   11817: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11820: ldc2_w 3165
    //   11823: lcmp
    //   11824: ifne +87 -> 11911
    //   11827: new 3168	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody
    //   11830: dup
    //   11831: invokespecial 3169	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:<init>	()V
    //   11834: astore_1
    //   11835: aload_1
    //   11836: aload 32
    //   11838: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11841: invokevirtual 3170	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11844: pop
    //   11845: aload_1
    //   11846: getfield 3173	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:uint32_is_mass_bless_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11849: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   11852: istore 4
    //   11854: iload 4
    //   11856: ifne +26 -> 11882
    //   11859: iconst_1
    //   11860: istore 19
    //   11862: aload_0
    //   11863: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11866: sipush 138
    //   11869: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11872: checkcast 3175	afaz
    //   11875: iload 19
    //   11877: invokevirtual 3177	afaz:c	(Z)V
    //   11880: aconst_null
    //   11881: areturn
    //   11882: iconst_0
    //   11883: istore 19
    //   11885: goto -23 -> 11862
    //   11888: astore_1
    //   11889: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11892: ifeq +13 -> 11905
    //   11895: ldc_w 3179
    //   11898: iconst_2
    //   11899: ldc_w 3181
    //   11902: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11905: iconst_1
    //   11906: istore 19
    //   11908: goto -46 -> 11862
    //   11911: aload 32
    //   11913: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11916: ldc2_w 3293
    //   11919: lcmp
    //   11920: ifeq -11891 -> 29
    //   11923: aload 32
    //   11925: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11928: ldc2_w 3295
    //   11931: lcmp
    //   11932: ifeq -11903 -> 29
    //   11935: aload 32
    //   11937: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11940: ldc2_w 3297
    //   11943: lcmp
    //   11944: ifne +75 -> 12019
    //   11947: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11950: ifeq +13 -> 11963
    //   11953: ldc_w 3300
    //   11956: iconst_2
    //   11957: ldc_w 3302
    //   11960: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11963: new 3304	tencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody
    //   11966: dup
    //   11967: invokespecial 3305	tencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody:<init>	()V
    //   11970: astore_1
    //   11971: aload_1
    //   11972: aload 32
    //   11974: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11977: invokevirtual 3306	tencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11980: pop
    //   11981: aload_0
    //   11982: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11985: bipush 20
    //   11987: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   11990: checkcast 1718	akhq
    //   11993: aload_1
    //   11994: invokevirtual 3309	akhq:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody;)V
    //   11997: aconst_null
    //   11998: areturn
    //   11999: astore_1
    //   12000: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12003: ifeq -11974 -> 29
    //   12006: ldc_w 3300
    //   12009: iconst_2
    //   12010: ldc_w 3311
    //   12013: aload_1
    //   12014: invokestatic 3313	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   12017: aconst_null
    //   12018: areturn
    //   12019: aload 32
    //   12021: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   12024: ldc2_w 3314
    //   12027: lcmp
    //   12028: ifne +47 -> 12075
    //   12031: new 3317	tencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody
    //   12034: dup
    //   12035: invokespecial 3318	tencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody:<init>	()V
    //   12038: astore_1
    //   12039: aload_1
    //   12040: aload 32
    //   12042: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   12045: invokevirtual 3319	tencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12048: pop
    //   12049: aload_0
    //   12050: aload_1
    //   12051: invokevirtual 3322	akqf:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody;)V
    //   12054: aconst_null
    //   12055: areturn
    //   12056: astore_1
    //   12057: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12060: ifeq -12031 -> 29
    //   12063: ldc_w 3324
    //   12066: iconst_2
    //   12067: ldc_w 3326
    //   12070: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12073: aconst_null
    //   12074: areturn
    //   12075: aload 32
    //   12077: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   12080: ldc2_w 3327
    //   12083: lcmp
    //   12084: ifne +78 -> 12162
    //   12087: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12090: ifeq +13 -> 12103
    //   12093: ldc_w 3330
    //   12096: iconst_2
    //   12097: ldc_w 3332
    //   12100: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12103: new 3334	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody
    //   12106: dup
    //   12107: invokespecial 3335	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody:<init>	()V
    //   12110: astore_1
    //   12111: aload_1
    //   12112: aload 32
    //   12114: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   12117: invokevirtual 3336	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12120: pop
    //   12121: aload_0
    //   12122: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12125: sipush 156
    //   12128: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   12131: checkcast 3338	aqug
    //   12134: aload_1
    //   12135: iconst_0
    //   12136: invokevirtual 3341	aqug:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody;Z)V
    //   12139: aconst_null
    //   12140: areturn
    //   12141: astore 28
    //   12143: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12146: ifeq -25 -> 12121
    //   12149: ldc_w 3330
    //   12152: iconst_2
    //   12153: ldc_w 3343
    //   12156: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12159: goto -38 -> 12121
    //   12162: aload 32
    //   12164: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   12167: ldc2_w 3344
    //   12170: lcmp
    //   12171: ifne +698 -> 12869
    //   12174: new 3347	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody
    //   12177: dup
    //   12178: invokespecial 3348	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:<init>	()V
    //   12181: astore 28
    //   12183: aload 28
    //   12185: aload 32
    //   12187: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   12190: invokevirtual 3349	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12193: pop
    //   12194: aload 28
    //   12196: getfield 3350	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12199: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12202: ifeq +579 -> 12781
    //   12205: aload 28
    //   12207: getfield 3350	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12210: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12213: iconst_2
    //   12214: if_icmpne +567 -> 12781
    //   12217: aload 28
    //   12219: getfield 3354	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:msg_persons_may_know	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2;
    //   12222: getfield 3360	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2:fixed32_timestamp	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   12225: invokevirtual 3363	com/tencent/mobileqq/pb/PBFixed32Field:get	()I
    //   12228: i2l
    //   12229: lstore_2
    //   12230: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12233: ifeq +30 -> 12263
    //   12236: ldc_w 520
    //   12239: iconst_2
    //   12240: new 88	java/lang/StringBuilder
    //   12243: dup
    //   12244: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   12247: ldc_w 3365
    //   12250: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12253: lload_2
    //   12254: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12257: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12260: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12263: aload 28
    //   12265: getfield 3354	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:msg_persons_may_know	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2;
    //   12268: getfield 3368	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2:rpt_msg_friend_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   12271: invokevirtual 45	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   12274: astore 30
    //   12276: aload 30
    //   12278: ifnull +542 -> 12820
    //   12281: aload 30
    //   12283: invokeinterface 1526 1 0
    //   12288: ifle +532 -> 12820
    //   12291: new 655	java/util/ArrayList
    //   12294: dup
    //   12295: aload 30
    //   12297: invokeinterface 1526 1 0
    //   12302: invokespecial 3369	java/util/ArrayList:<init>	(I)V
    //   12305: astore 29
    //   12307: aload 30
    //   12309: invokeinterface 51 1 0
    //   12314: astore 30
    //   12316: aload 30
    //   12318: invokeinterface 56 1 0
    //   12323: ifeq +497 -> 12820
    //   12326: aload 30
    //   12328: invokeinterface 60 1 0
    //   12333: checkcast 3371	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow
    //   12336: astore 31
    //   12338: new 3373	com/tencent/mobileqq/data/PushRecommend
    //   12341: dup
    //   12342: invokespecial 3374	com/tencent/mobileqq/data/PushRecommend:<init>	()V
    //   12345: astore 32
    //   12347: aload 31
    //   12349: getfield 3375	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   12352: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   12355: ifeq +19 -> 12374
    //   12358: aload 32
    //   12360: aload 31
    //   12362: getfield 3375	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   12365: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   12368: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   12371: putfield 3376	com/tencent/mobileqq/data/PushRecommend:uin	Ljava/lang/String;
    //   12374: aload 31
    //   12376: getfield 3379	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12379: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12382: ifeq +26 -> 12408
    //   12385: aload 32
    //   12387: new 274	java/lang/String
    //   12390: dup
    //   12391: aload 31
    //   12393: getfield 3379	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12396: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12399: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12402: invokespecial 1281	java/lang/String:<init>	([B)V
    //   12405: putfield 3382	com/tencent/mobileqq/data/PushRecommend:nick	Ljava/lang/String;
    //   12408: aload 31
    //   12410: getfield 3383	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12413: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12416: ifeq +17 -> 12433
    //   12419: aload 32
    //   12421: aload 31
    //   12423: getfield 3383	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12426: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12429: i2s
    //   12430: putfield 3385	com/tencent/mobileqq/data/PushRecommend:age	S
    //   12433: aload 31
    //   12435: getfield 3388	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_sex	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12438: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12441: ifeq +17 -> 12458
    //   12444: aload 32
    //   12446: aload 31
    //   12448: getfield 3388	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_sex	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12451: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12454: i2s
    //   12455: putfield 3390	com/tencent/mobileqq/data/PushRecommend:gender	S
    //   12458: aload 31
    //   12460: getfield 3393	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_main_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12463: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12466: ifeq +26 -> 12492
    //   12469: aload 32
    //   12471: new 274	java/lang/String
    //   12474: dup
    //   12475: aload 31
    //   12477: getfield 3393	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_main_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12480: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12483: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12486: invokespecial 1281	java/lang/String:<init>	([B)V
    //   12489: putfield 3396	com/tencent/mobileqq/data/PushRecommend:recommendReason	Ljava/lang/String;
    //   12492: aload 31
    //   12494: getfield 3399	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_alghrithm	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12497: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12500: ifeq +19 -> 12519
    //   12503: aload 32
    //   12505: aload 31
    //   12507: getfield 3399	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_alghrithm	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12510: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12513: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12516: putfield 3402	com/tencent/mobileqq/data/PushRecommend:algBuffer	[B
    //   12519: aload 31
    //   12521: getfield 3405	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_soure_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12524: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12527: ifeq +26 -> 12553
    //   12530: aload 32
    //   12532: new 274	java/lang/String
    //   12535: dup
    //   12536: aload 31
    //   12538: getfield 3405	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_soure_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12541: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12544: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12547: invokespecial 1281	java/lang/String:<init>	([B)V
    //   12550: putfield 3408	com/tencent/mobileqq/data/PushRecommend:sourceReason	Ljava/lang/String;
    //   12553: aload 31
    //   12555: getfield 3411	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12558: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12561: ifeq +16 -> 12577
    //   12564: aload 32
    //   12566: aload 31
    //   12568: getfield 3411	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12571: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12574: putfield 3414	com/tencent/mobileqq/data/PushRecommend:fromSource	I
    //   12577: aload 31
    //   12579: getfield 3418	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:msg_android_source	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource;
    //   12582: invokevirtual 3421	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:has	()Z
    //   12585: ifeq +69 -> 12654
    //   12588: aload 31
    //   12590: getfield 3418	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:msg_android_source	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource;
    //   12593: invokevirtual 3422	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12596: checkcast 3420	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource
    //   12599: astore 33
    //   12601: aload 33
    //   12603: ifnull +51 -> 12654
    //   12606: aload 33
    //   12608: getfield 3423	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:uint32_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12611: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12614: ifeq +16 -> 12630
    //   12617: aload 32
    //   12619: aload 33
    //   12621: getfield 3423	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:uint32_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12624: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12627: putfield 3426	com/tencent/mobileqq/data/PushRecommend:sourceId	I
    //   12630: aload 33
    //   12632: getfield 3429	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:uint32_sub_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12635: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12638: ifeq +16 -> 12654
    //   12641: aload 32
    //   12643: aload 33
    //   12645: getfield 3429	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:uint32_sub_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12648: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12651: putfield 3432	com/tencent/mobileqq/data/PushRecommend:subSourceId	I
    //   12654: aload 31
    //   12656: getfield 3435	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_msg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12659: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12662: ifeq +26 -> 12688
    //   12665: aload 32
    //   12667: new 274	java/lang/String
    //   12670: dup
    //   12671: aload 31
    //   12673: getfield 3435	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_msg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12676: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12679: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12682: invokespecial 1281	java/lang/String:<init>	([B)V
    //   12685: putfield 3438	com/tencent/mobileqq/data/PushRecommend:wzryVerifyStr	Ljava/lang/String;
    //   12688: aload 31
    //   12690: getfield 3441	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_game_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12693: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12696: ifeq +16 -> 12712
    //   12699: aload 32
    //   12701: aload 31
    //   12703: getfield 3441	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_game_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12706: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12709: putfield 3444	com/tencent/mobileqq/data/PushRecommend:wzrySourceId	I
    //   12712: aload 31
    //   12714: getfield 3447	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_role_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12717: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12720: ifeq +26 -> 12746
    //   12723: aload 32
    //   12725: new 274	java/lang/String
    //   12728: dup
    //   12729: aload 31
    //   12731: getfield 3447	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_role_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12734: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12737: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12740: invokespecial 1281	java/lang/String:<init>	([B)V
    //   12743: putfield 3450	com/tencent/mobileqq/data/PushRecommend:wzryGameNick	Ljava/lang/String;
    //   12746: aload 32
    //   12748: lload_2
    //   12749: putfield 3451	com/tencent/mobileqq/data/PushRecommend:timestamp	J
    //   12752: aload 29
    //   12754: aload 32
    //   12756: invokevirtual 657	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   12759: pop
    //   12760: goto -444 -> 12316
    //   12763: astore 28
    //   12765: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12768: ifeq +13 -> 12781
    //   12771: ldc_w 3324
    //   12774: iconst_2
    //   12775: ldc_w 3453
    //   12778: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12781: aload_1
    //   12782: getfield 1143	OnlinePushPack/MsgInfo:lFromUin	J
    //   12785: lstore_2
    //   12786: aload_1
    //   12787: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   12790: istore 4
    //   12792: aload_1
    //   12793: getfield 1194	OnlinePushPack/MsgInfo:lMsgUid	J
    //   12796: lstore 15
    //   12798: aload_1
    //   12799: getfield 1140	OnlinePushPack/MsgInfo:shMsgType	S
    //   12802: istore 5
    //   12804: aload_0
    //   12805: getfield 1456	akqf:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   12808: lload_2
    //   12809: iload 4
    //   12811: lload 15
    //   12813: iload 5
    //   12815: invokestatic 1868	axao:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   12818: aconst_null
    //   12819: areturn
    //   12820: aload 28
    //   12822: getfield 3354	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:msg_persons_may_know	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2;
    //   12825: getfield 3454	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2:bytes_role_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12828: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12831: ifeq -50 -> 12781
    //   12834: aload 28
    //   12836: getfield 3354	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:msg_persons_may_know	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2;
    //   12839: getfield 3454	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2:bytes_role_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12842: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12845: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   12848: astore 28
    //   12850: aload_0
    //   12851: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12854: aload_0
    //   12855: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12858: invokevirtual 675	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   12861: aload 28
    //   12863: invokestatic 3460	com/tencent/mobileqq/data/KplRoleInfo:saveGameNickWithUin	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)V
    //   12866: goto -85 -> 12781
    //   12869: aload 32
    //   12871: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   12874: ldc2_w 3461
    //   12877: lcmp
    //   12878: ifne +172 -> 13050
    //   12881: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12884: ifeq +13 -> 12897
    //   12887: ldc_w 3464
    //   12890: iconst_2
    //   12891: ldc_w 3466
    //   12894: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12897: new 3468	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody
    //   12900: dup
    //   12901: invokespecial 3469	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:<init>	()V
    //   12904: astore_1
    //   12905: aload_1
    //   12906: aload 32
    //   12908: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   12911: invokevirtual 3470	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12914: pop
    //   12915: aload_1
    //   12916: getfield 3471	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12919: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12922: istore 4
    //   12924: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12927: ifeq +28 -> 12955
    //   12930: ldc_w 3464
    //   12933: iconst_2
    //   12934: iconst_2
    //   12935: anewarray 220	java/lang/Object
    //   12938: dup
    //   12939: iconst_0
    //   12940: ldc_w 3473
    //   12943: aastore
    //   12944: dup
    //   12945: iconst_1
    //   12946: iload 4
    //   12948: invokestatic 255	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12951: aastore
    //   12952: invokestatic 691	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   12955: iload 4
    //   12957: iconst_1
    //   12958: if_icmpne -12929 -> 29
    //   12961: aload_1
    //   12962: getfield 3477	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:msg_body_type	Ltencent/im/oidb/olympic/submsgtype0xb4$BodyType;
    //   12965: astore_1
    //   12966: aload_1
    //   12967: getfield 3483	tencent/im/oidb/olympic/submsgtype0xb4$BodyType:msg_torchbearer	Ltencent/im/oidb/olympic/torch_transfer$TorchbearerInfo;
    //   12970: invokevirtual 3486	tencent/im/oidb/olympic/torch_transfer$TorchbearerInfo:has	()Z
    //   12973: ifeq +59 -> 13032
    //   12976: aload_0
    //   12977: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12980: bipush 94
    //   12982: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   12985: checkcast 3488	auet
    //   12988: astore 28
    //   12990: aload 28
    //   12992: ifnull -12963 -> 29
    //   12995: aload 28
    //   12997: aload_1
    //   12998: getfield 3483	tencent/im/oidb/olympic/submsgtype0xb4$BodyType:msg_torchbearer	Ltencent/im/oidb/olympic/torch_transfer$TorchbearerInfo;
    //   13001: invokevirtual 3489	tencent/im/oidb/olympic/torch_transfer$TorchbearerInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13004: checkcast 3485	tencent/im/oidb/olympic/torch_transfer$TorchbearerInfo
    //   13007: invokevirtual 3492	auet:a	(Ltencent/im/oidb/olympic/torch_transfer$TorchbearerInfo;)V
    //   13010: aconst_null
    //   13011: areturn
    //   13012: astore_1
    //   13013: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13016: ifeq -12987 -> 29
    //   13019: ldc_w 3464
    //   13022: iconst_2
    //   13023: ldc_w 3494
    //   13026: aload_1
    //   13027: invokestatic 2429	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13030: aconst_null
    //   13031: areturn
    //   13032: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13035: ifeq -13006 -> 29
    //   13038: ldc_w 3464
    //   13041: iconst_2
    //   13042: ldc_w 3496
    //   13045: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13048: aconst_null
    //   13049: areturn
    //   13050: aload 32
    //   13052: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13055: ldc2_w 3497
    //   13058: lcmp
    //   13059: ifne +18 -> 13077
    //   13062: aload_0
    //   13063: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13066: aload 32
    //   13068: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13071: iconst_1
    //   13072: invokestatic 3501	axao:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BZ)V
    //   13075: aconst_null
    //   13076: areturn
    //   13077: aload 32
    //   13079: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13082: ldc2_w 3502
    //   13085: lcmp
    //   13086: ifne +70 -> 13156
    //   13089: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13092: ifeq +13 -> 13105
    //   13095: ldc_w 3505
    //   13098: iconst_2
    //   13099: ldc_w 3507
    //   13102: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13105: new 3509	tencent/im/s2c/msgtype0x210/submsgtype0xc1/submsgtype0xc1$MsgBody
    //   13108: dup
    //   13109: invokespecial 3510	tencent/im/s2c/msgtype0x210/submsgtype0xc1/submsgtype0xc1$MsgBody:<init>	()V
    //   13112: astore_1
    //   13113: aload_1
    //   13114: aload 32
    //   13116: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13119: invokevirtual 3511	tencent/im/s2c/msgtype0x210/submsgtype0xc1/submsgtype0xc1$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13122: pop
    //   13123: aload_0
    //   13124: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13127: invokevirtual 3514	com/tencent/mobileqq/app/QQAppInterface:a	()Lakef;
    //   13130: aload_1
    //   13131: invokevirtual 3519	akef:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xc1/submsgtype0xc1$MsgBody;)V
    //   13134: aconst_null
    //   13135: areturn
    //   13136: astore_1
    //   13137: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13140: ifeq -13111 -> 29
    //   13143: ldc_w 3505
    //   13146: iconst_2
    //   13147: ldc_w 3521
    //   13150: aload_1
    //   13151: invokestatic 1599	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13154: aconst_null
    //   13155: areturn
    //   13156: aload 32
    //   13158: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13161: ldc2_w 3522
    //   13164: lcmp
    //   13165: ifne +166 -> 13331
    //   13168: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13171: ifeq +13 -> 13184
    //   13174: ldc_w 3525
    //   13177: iconst_2
    //   13178: ldc_w 3527
    //   13181: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13184: new 3529	tencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody
    //   13187: dup
    //   13188: invokespecial 3530	tencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody:<init>	()V
    //   13191: astore_1
    //   13192: aload_1
    //   13193: aload 32
    //   13195: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13198: invokevirtual 3531	tencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13201: pop
    //   13202: aload_0
    //   13203: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13206: invokevirtual 3514	com/tencent/mobileqq/app/QQAppInterface:a	()Lakef;
    //   13209: aload_1
    //   13210: invokevirtual 3534	akef:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody;)V
    //   13213: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13216: ifeq -13187 -> 29
    //   13219: aload_1
    //   13220: getfield 3537	tencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody:bytes_business	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   13223: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   13226: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   13229: astore_1
    //   13230: ldc_w 3525
    //   13233: iconst_2
    //   13234: new 88	java/lang/StringBuilder
    //   13237: dup
    //   13238: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   13241: ldc_w 3539
    //   13244: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13247: aload_1
    //   13248: arraylength
    //   13249: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13252: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13255: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13258: ldc_w 3525
    //   13261: iconst_2
    //   13262: new 88	java/lang/StringBuilder
    //   13265: dup
    //   13266: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   13269: ldc_w 3541
    //   13272: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13275: aload_1
    //   13276: arraylength
    //   13277: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13280: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13283: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13286: aconst_null
    //   13287: areturn
    //   13288: astore_1
    //   13289: aload_1
    //   13290: invokevirtual 1300	java/lang/Exception:printStackTrace	()V
    //   13293: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13296: ifeq -13267 -> 29
    //   13299: ldc_w 3525
    //   13302: iconst_2
    //   13303: new 88	java/lang/StringBuilder
    //   13306: dup
    //   13307: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   13310: ldc_w 3543
    //   13313: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13316: aload_1
    //   13317: invokevirtual 3546	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   13320: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13323: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13326: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13329: aconst_null
    //   13330: areturn
    //   13331: aload 32
    //   13333: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13336: ldc2_w 3547
    //   13339: lcmp
    //   13340: ifne +101 -> 13441
    //   13343: aload 32
    //   13345: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13348: ifnull +93 -> 13441
    //   13351: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13354: ifeq +13 -> 13367
    //   13357: ldc_w 3550
    //   13360: iconst_2
    //   13361: ldc_w 3552
    //   13364: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13367: aload_1
    //   13368: getfield 1143	OnlinePushPack/MsgInfo:lFromUin	J
    //   13371: lstore_2
    //   13372: aload_1
    //   13373: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   13376: istore 4
    //   13378: aload_1
    //   13379: getfield 1194	OnlinePushPack/MsgInfo:lMsgUid	J
    //   13382: lstore 15
    //   13384: aload_1
    //   13385: getfield 1140	OnlinePushPack/MsgInfo:shMsgType	S
    //   13388: istore 5
    //   13390: aload_1
    //   13391: getfield 1187	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   13394: istore 6
    //   13396: new 3554	akqn
    //   13399: dup
    //   13400: lload_2
    //   13401: iload 4
    //   13403: i2l
    //   13404: lload 15
    //   13406: iload 5
    //   13408: iload 6
    //   13410: iconst_1
    //   13411: invokespecial 3557	akqn:<init>	(JJJIIZ)V
    //   13414: astore_1
    //   13415: aload_0
    //   13416: aload 32
    //   13418: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13421: aload_1
    //   13422: invokevirtual 3560	akqf:a	([BLakqn;)V
    //   13425: aload_0
    //   13426: getfield 1456	akqf:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   13429: lload_2
    //   13430: iload 4
    //   13432: lload 15
    //   13434: iload 5
    //   13436: invokestatic 1868	axao:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   13439: aconst_null
    //   13440: areturn
    //   13441: aload 32
    //   13443: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13446: ldc2_w 3561
    //   13449: lcmp
    //   13450: ifne +19 -> 13469
    //   13453: aload_0
    //   13454: aload 32
    //   13456: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13459: aload_1
    //   13460: getfield 1187	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   13463: i2l
    //   13464: invokevirtual 3565	akqf:a	([BJ)V
    //   13467: aconst_null
    //   13468: areturn
    //   13469: aload 32
    //   13471: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13474: ldc2_w 3566
    //   13477: lcmp
    //   13478: ifne +28 -> 13506
    //   13481: aload_0
    //   13482: getfield 1456	akqf:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   13485: aload_1
    //   13486: getfield 1143	OnlinePushPack/MsgInfo:lFromUin	J
    //   13489: aload_1
    //   13490: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   13493: aload_1
    //   13494: getfield 1194	OnlinePushPack/MsgInfo:lMsgUid	J
    //   13497: aload_1
    //   13498: getfield 1140	OnlinePushPack/MsgInfo:shMsgType	S
    //   13501: invokestatic 1868	axao:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   13504: aconst_null
    //   13505: areturn
    //   13506: aload 32
    //   13508: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13511: ldc2_w 3568
    //   13514: lcmp
    //   13515: ifne +19 -> 13534
    //   13518: aload_0
    //   13519: aload 32
    //   13521: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13524: aload_1
    //   13525: getfield 1187	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   13528: i2l
    //   13529: invokevirtual 3571	akqf:b	([BJ)V
    //   13532: aconst_null
    //   13533: areturn
    //   13534: aload 32
    //   13536: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13539: ldc2_w 3572
    //   13542: lcmp
    //   13543: ifne +39 -> 13582
    //   13546: aload_0
    //   13547: aload 32
    //   13549: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13552: iconst_1
    //   13553: aload_1
    //   13554: invokevirtual 3576	akqf:a	([BILOnlinePushPack/MsgInfo;)V
    //   13557: aload_0
    //   13558: getfield 1456	akqf:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   13561: aload_1
    //   13562: getfield 1143	OnlinePushPack/MsgInfo:lFromUin	J
    //   13565: aload_1
    //   13566: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   13569: aload_1
    //   13570: getfield 1194	OnlinePushPack/MsgInfo:lMsgUid	J
    //   13573: aload_1
    //   13574: getfield 1140	OnlinePushPack/MsgInfo:shMsgType	S
    //   13577: invokestatic 1868	axao:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   13580: aconst_null
    //   13581: areturn
    //   13582: aload 32
    //   13584: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13587: ldc2_w 3577
    //   13590: lcmp
    //   13591: ifne +38 -> 13629
    //   13594: aload_0
    //   13595: aload 32
    //   13597: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13600: iconst_1
    //   13601: invokevirtual 3580	akqf:a	([BI)V
    //   13604: aload_0
    //   13605: getfield 1456	akqf:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   13608: aload_1
    //   13609: getfield 1143	OnlinePushPack/MsgInfo:lFromUin	J
    //   13612: aload_1
    //   13613: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   13616: aload_1
    //   13617: getfield 1194	OnlinePushPack/MsgInfo:lMsgUid	J
    //   13620: aload_1
    //   13621: getfield 1140	OnlinePushPack/MsgInfo:shMsgType	S
    //   13624: invokestatic 1868	axao:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   13627: aconst_null
    //   13628: areturn
    //   13629: aload 32
    //   13631: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13634: ldc2_w 3581
    //   13637: lcmp
    //   13638: ifne +70 -> 13708
    //   13641: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13644: ifeq +13 -> 13657
    //   13647: ldc_w 3584
    //   13650: iconst_2
    //   13651: ldc_w 3586
    //   13654: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13657: aload_0
    //   13658: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13661: bipush 34
    //   13663: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   13666: checkcast 3588	akge
    //   13669: astore_1
    //   13670: aload_1
    //   13671: ifnull +19 -> 13690
    //   13674: aload_1
    //   13675: aload 32
    //   13677: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13680: aload 32
    //   13682: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13685: invokevirtual 3589	akge:a	(J[B)V
    //   13688: aconst_null
    //   13689: areturn
    //   13690: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13693: ifeq -13664 -> 29
    //   13696: ldc_w 3584
    //   13699: iconst_2
    //   13700: ldc_w 3591
    //   13703: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13706: aconst_null
    //   13707: areturn
    //   13708: aload 32
    //   13710: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13713: ldc2_w 3592
    //   13716: lcmp
    //   13717: ifne +15 -> 13732
    //   13720: aload_0
    //   13721: aload 32
    //   13723: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13726: aload_1
    //   13727: invokevirtual 3596	akqf:a	([BLOnlinePushPack/MsgInfo;)V
    //   13730: aconst_null
    //   13731: areturn
    //   13732: aload 32
    //   13734: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13737: ldc2_w 3597
    //   13740: lcmp
    //   13741: ifne +25 -> 13766
    //   13744: aload_0
    //   13745: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13748: bipush 98
    //   13750: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   13753: checkcast 3600	ssv
    //   13756: aload 32
    //   13758: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13761: invokevirtual 3601	ssv:a	([B)V
    //   13764: aconst_null
    //   13765: areturn
    //   13766: aload 32
    //   13768: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13771: ldc2_w 3602
    //   13774: lcmp
    //   13775: ifne +70 -> 13845
    //   13778: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13781: ifeq +13 -> 13794
    //   13784: ldc_w 3505
    //   13787: iconst_2
    //   13788: ldc_w 3605
    //   13791: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13794: new 3607	tencent/im/s2c/msgtype0x210/submsgtype0xcf/submsgtype0xcf$MsgBody
    //   13797: dup
    //   13798: invokespecial 3608	tencent/im/s2c/msgtype0x210/submsgtype0xcf/submsgtype0xcf$MsgBody:<init>	()V
    //   13801: astore_1
    //   13802: aload_1
    //   13803: aload 32
    //   13805: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13808: invokevirtual 3609	tencent/im/s2c/msgtype0x210/submsgtype0xcf/submsgtype0xcf$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13811: pop
    //   13812: aload_0
    //   13813: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13816: invokevirtual 3514	com/tencent/mobileqq/app/QQAppInterface:a	()Lakef;
    //   13819: aload_1
    //   13820: invokevirtual 3612	akef:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xcf/submsgtype0xcf$MsgBody;)V
    //   13823: aconst_null
    //   13824: areturn
    //   13825: astore_1
    //   13826: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13829: ifeq -13800 -> 29
    //   13832: ldc_w 3505
    //   13835: iconst_2
    //   13836: ldc_w 3614
    //   13839: aload_1
    //   13840: invokestatic 1599	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13843: aconst_null
    //   13844: areturn
    //   13845: aload 32
    //   13847: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13850: ldc2_w 3615
    //   13853: lcmp
    //   13854: ifne +25 -> 13879
    //   13857: aload_0
    //   13858: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13861: bipush 98
    //   13863: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   13866: checkcast 3600	ssv
    //   13869: aload 32
    //   13871: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13874: invokevirtual 3617	ssv:b	([B)V
    //   13877: aconst_null
    //   13878: areturn
    //   13879: aload 32
    //   13881: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13884: ldc2_w 3618
    //   13887: lcmp
    //   13888: ifne +25 -> 13913
    //   13891: aload_0
    //   13892: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13895: bipush 98
    //   13897: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   13900: checkcast 3600	ssv
    //   13903: aload 32
    //   13905: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13908: invokevirtual 3620	ssv:c	([B)V
    //   13911: aconst_null
    //   13912: areturn
    //   13913: aload 32
    //   13915: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13918: ldc2_w 3621
    //   13921: lcmp
    //   13922: ifne +42 -> 13964
    //   13925: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13928: ifeq +13 -> 13941
    //   13931: ldc_w 520
    //   13934: iconst_2
    //   13935: ldc_w 3624
    //   13938: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   13941: aload_0
    //   13942: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13945: sipush 202
    //   13948: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   13951: checkcast 3626	com/tencent/mobileqq/data/MsgBoxInterFollowManager
    //   13954: aload 32
    //   13956: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13959: invokevirtual 3629	com/tencent/mobileqq/data/MsgBoxInterFollowManager:decode0xd7InteractAndFollowMsg	([B)V
    //   13962: aconst_null
    //   13963: areturn
    //   13964: aload 32
    //   13966: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13969: ldc2_w 3630
    //   13972: lcmp
    //   13973: ifne +42 -> 14015
    //   13976: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13979: ifeq +13 -> 13992
    //   13982: ldc_w 520
    //   13985: iconst_2
    //   13986: ldc_w 3633
    //   13989: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   13992: aload_0
    //   13993: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13996: sipush 202
    //   13999: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14002: checkcast 3626	com/tencent/mobileqq/data/MsgBoxInterFollowManager
    //   14005: aload 32
    //   14007: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14010: invokevirtual 3636	com/tencent/mobileqq/data/MsgBoxInterFollowManager:decode0xfeInteractAndFollowMsg	([B)V
    //   14013: aconst_null
    //   14014: areturn
    //   14015: aload 32
    //   14017: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14020: ldc2_w 3637
    //   14023: lcmp
    //   14024: ifne +25 -> 14049
    //   14027: aload_0
    //   14028: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14031: bipush 107
    //   14033: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   14036: checkcast 3640	bcic
    //   14039: aload 32
    //   14041: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14044: invokevirtual 3641	bcic:a	([B)V
    //   14047: aconst_null
    //   14048: areturn
    //   14049: aload 32
    //   14051: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14054: ldc2_w 3642
    //   14057: lcmp
    //   14058: ifne +70 -> 14128
    //   14061: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14064: ifeq +13 -> 14077
    //   14067: ldc_w 3645
    //   14070: iconst_2
    //   14071: ldc_w 3647
    //   14074: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14077: new 3649	tencent/im/s2c/msgtype0x210/submsgtype0xdb/submsgtype0xdb$MsgBody
    //   14080: dup
    //   14081: invokespecial 3650	tencent/im/s2c/msgtype0x210/submsgtype0xdb/submsgtype0xdb$MsgBody:<init>	()V
    //   14084: astore_1
    //   14085: aload_1
    //   14086: aload 32
    //   14088: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14091: invokevirtual 3651	tencent/im/s2c/msgtype0x210/submsgtype0xdb/submsgtype0xdb$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14094: pop
    //   14095: aload_0
    //   14096: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14099: invokevirtual 3514	com/tencent/mobileqq/app/QQAppInterface:a	()Lakef;
    //   14102: aload_1
    //   14103: invokevirtual 3654	akef:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xdb/submsgtype0xdb$MsgBody;)V
    //   14106: aconst_null
    //   14107: areturn
    //   14108: astore_1
    //   14109: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14112: ifeq -14083 -> 29
    //   14115: ldc_w 3645
    //   14118: iconst_2
    //   14119: ldc_w 3656
    //   14122: aload_1
    //   14123: invokestatic 1599	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14126: aconst_null
    //   14127: areturn
    //   14128: aload 32
    //   14130: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14133: ldc2_w 3657
    //   14136: lcmp
    //   14137: ifne +21 -> 14158
    //   14140: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14143: ifeq -14114 -> 29
    //   14146: ldc_w 520
    //   14149: iconst_2
    //   14150: ldc_w 3660
    //   14153: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14156: aconst_null
    //   14157: areturn
    //   14158: aload 32
    //   14160: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14163: ldc2_w 3661
    //   14166: lcmp
    //   14167: ifne +21 -> 14188
    //   14170: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14173: ifeq -14144 -> 29
    //   14176: ldc_w 520
    //   14179: iconst_2
    //   14180: ldc_w 3664
    //   14183: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14186: aconst_null
    //   14187: areturn
    //   14188: aload 32
    //   14190: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14193: ldc2_w 3665
    //   14196: lcmp
    //   14197: ifne +219 -> 14416
    //   14200: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14203: ifeq +13 -> 14216
    //   14206: ldc_w 3668
    //   14209: iconst_2
    //   14210: ldc_w 3670
    //   14213: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14216: new 3672	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody
    //   14219: dup
    //   14220: invokespecial 3673	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody:<init>	()V
    //   14223: astore_1
    //   14224: aload_1
    //   14225: aload 32
    //   14227: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14230: invokevirtual 3674	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14233: pop
    //   14234: aload_1
    //   14235: getfield 3678	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody:msg_game_state	Ltencent/im/apollo_game_status$STCMGameMessage;
    //   14238: invokevirtual 3681	tencent/im/apollo_game_status$STCMGameMessage:has	()Z
    //   14241: ifeq -14212 -> 29
    //   14244: aload_1
    //   14245: getfield 3678	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody:msg_game_state	Ltencent/im/apollo_game_status$STCMGameMessage;
    //   14248: invokevirtual 3682	tencent/im/apollo_game_status$STCMGameMessage:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14251: checkcast 3680	tencent/im/apollo_game_status$STCMGameMessage
    //   14254: astore_1
    //   14255: aload_1
    //   14256: getfield 3686	tencent/im/apollo_game_status$STCMGameMessage:msg_comm	Ltencent/im/apollo_game_status$STCMGameMessage$STMsgComm;
    //   14259: invokevirtual 3689	tencent/im/apollo_game_status$STCMGameMessage$STMsgComm:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14262: checkcast 3688	tencent/im/apollo_game_status$STCMGameMessage$STMsgComm
    //   14265: astore 29
    //   14267: aload 29
    //   14269: getfield 3692	tencent/im/apollo_game_status$STCMGameMessage$STMsgComm:uint32_session_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   14272: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   14275: invokestatic 3695	bbbd:a	(I)J
    //   14278: lstore 15
    //   14280: aload_0
    //   14281: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14284: sipush 211
    //   14287: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14290: checkcast 3697	airv
    //   14293: astore 28
    //   14295: lload_2
    //   14296: lload 15
    //   14298: lcmp
    //   14299: ifne +102 -> 14401
    //   14302: aload 29
    //   14304: getfield 3700	tencent/im/apollo_game_status$STCMGameMessage$STMsgComm:rpt_uint32_session_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   14307: invokevirtual 1812	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   14310: astore 29
    //   14312: aload 29
    //   14314: ifnull -14285 -> 29
    //   14317: aload 29
    //   14319: invokeinterface 1526 1 0
    //   14324: ifle -14295 -> 29
    //   14327: aload 29
    //   14329: invokeinterface 51 1 0
    //   14334: astore 29
    //   14336: aload 29
    //   14338: invokeinterface 56 1 0
    //   14343: ifeq -14314 -> 29
    //   14346: aload 29
    //   14348: invokeinterface 60 1 0
    //   14353: checkcast 251	java/lang/Integer
    //   14356: invokevirtual 3703	java/lang/Integer:intValue	()I
    //   14359: invokestatic 3695	bbbd:a	(I)J
    //   14362: lstore 15
    //   14364: lload 15
    //   14366: lload_2
    //   14367: lcmp
    //   14368: ifeq -32 -> 14336
    //   14371: aload 28
    //   14373: iconst_0
    //   14374: iconst_0
    //   14375: lload 15
    //   14377: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   14380: aload_1
    //   14381: invokevirtual 3706	airv:a	(IILjava/lang/String;Ltencent/im/apollo_game_status$STCMGameMessage;)V
    //   14384: goto -48 -> 14336
    //   14387: astore_1
    //   14388: ldc_w 3668
    //   14391: iconst_1
    //   14392: ldc_w 3708
    //   14395: aload_1
    //   14396: invokestatic 1599	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14399: aconst_null
    //   14400: areturn
    //   14401: aload 28
    //   14403: iconst_0
    //   14404: iconst_0
    //   14405: lload 15
    //   14407: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   14410: aload_1
    //   14411: invokevirtual 3706	airv:a	(IILjava/lang/String;Ltencent/im/apollo_game_status$STCMGameMessage;)V
    //   14414: aconst_null
    //   14415: areturn
    //   14416: aload 32
    //   14418: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14421: ldc2_w 3709
    //   14424: lcmp
    //   14425: ifne +138 -> 14563
    //   14428: ldc_w 3712
    //   14431: iconst_1
    //   14432: ldc_w 3714
    //   14435: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14438: new 3716	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody
    //   14441: dup
    //   14442: invokespecial 3717	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody:<init>	()V
    //   14445: astore_1
    //   14446: aload_1
    //   14447: aload 32
    //   14449: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14452: invokevirtual 3718	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14455: pop
    //   14456: aload_1
    //   14457: getfield 3722	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody:msg_item	Ltencent/im/apollo_push_msgInfo$STPushMsgElem;
    //   14460: invokevirtual 3725	tencent/im/apollo_push_msgInfo$STPushMsgElem:has	()Z
    //   14463: ifeq -14434 -> 29
    //   14466: aload_1
    //   14467: getfield 3722	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody:msg_item	Ltencent/im/apollo_push_msgInfo$STPushMsgElem;
    //   14470: invokevirtual 3726	tencent/im/apollo_push_msgInfo$STPushMsgElem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14473: checkcast 3724	tencent/im/apollo_push_msgInfo$STPushMsgElem
    //   14476: astore_1
    //   14477: aload_0
    //   14478: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14481: ifnull -14452 -> 29
    //   14484: aload_0
    //   14485: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14488: sipush 227
    //   14491: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14494: checkcast 3728	aist
    //   14497: astore 28
    //   14499: aload 28
    //   14501: iconst_0
    //   14502: aload_1
    //   14503: invokevirtual 3731	aist:a	(ILtencent/im/apollo_push_msgInfo$STPushMsgElem;)V
    //   14506: aload 28
    //   14508: aload_1
    //   14509: invokevirtual 3734	aist:c	(Ltencent/im/apollo_push_msgInfo$STPushMsgElem;)V
    //   14512: aload 28
    //   14514: aload_1
    //   14515: invokevirtual 3736	aist:b	(Ltencent/im/apollo_push_msgInfo$STPushMsgElem;)V
    //   14518: aload 28
    //   14520: aload_1
    //   14521: invokevirtual 3738	aist:a	(Ltencent/im/apollo_push_msgInfo$STPushMsgElem;)V
    //   14524: aconst_null
    //   14525: areturn
    //   14526: astore_1
    //   14527: aload_1
    //   14528: invokevirtual 1300	java/lang/Exception:printStackTrace	()V
    //   14531: ldc_w 3712
    //   14534: iconst_1
    //   14535: new 88	java/lang/StringBuilder
    //   14538: dup
    //   14539: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14542: ldc_w 3740
    //   14545: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14548: aload_1
    //   14549: invokevirtual 3546	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   14552: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14555: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14558: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   14561: aconst_null
    //   14562: areturn
    //   14563: aload 32
    //   14565: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14568: ldc2_w 3741
    //   14571: lcmp
    //   14572: ifne +88 -> 14660
    //   14575: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14578: ifeq +13 -> 14591
    //   14581: ldc_w 520
    //   14584: iconst_2
    //   14585: ldc_w 3744
    //   14588: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14591: new 3746	tencent/im/c2c/msgtype0x210/submsgtype0xeb/submsgtype0xeb$MsgBody
    //   14594: dup
    //   14595: invokespecial 3747	tencent/im/c2c/msgtype0x210/submsgtype0xeb/submsgtype0xeb$MsgBody:<init>	()V
    //   14598: astore_1
    //   14599: aload 32
    //   14601: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14604: ifnull +13 -> 14617
    //   14607: aload_1
    //   14608: aload 32
    //   14610: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14613: invokevirtual 3748	tencent/im/c2c/msgtype0x210/submsgtype0xeb/submsgtype0xeb$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14616: pop
    //   14617: aload_0
    //   14618: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14621: aload_1
    //   14622: invokestatic 3751	akjw:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ltencent/im/c2c/msgtype0x210/submsgtype0xeb/submsgtype0xeb$MsgBody;)V
    //   14625: aconst_null
    //   14626: areturn
    //   14627: astore_1
    //   14628: ldc_w 520
    //   14631: iconst_1
    //   14632: new 88	java/lang/StringBuilder
    //   14635: dup
    //   14636: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14639: ldc_w 3753
    //   14642: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14645: aload_1
    //   14646: invokevirtual 3546	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   14649: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14652: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14655: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   14658: aconst_null
    //   14659: areturn
    //   14660: aload 32
    //   14662: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14665: ldc2_w 3754
    //   14668: lcmp
    //   14669: ifne +195 -> 14864
    //   14672: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14675: ifeq +13 -> 14688
    //   14678: ldc_w 520
    //   14681: iconst_2
    //   14682: ldc_w 3757
    //   14685: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14688: aload 32
    //   14690: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14693: arraylength
    //   14694: istore 4
    //   14696: iload 4
    //   14698: bipush 6
    //   14700: if_icmpge +33 -> 14733
    //   14703: ldc_w 520
    //   14706: iconst_2
    //   14707: new 88	java/lang/StringBuilder
    //   14710: dup
    //   14711: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14714: ldc_w 3759
    //   14717: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14720: iload 4
    //   14722: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14725: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14728: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14731: aconst_null
    //   14732: areturn
    //   14733: aload 32
    //   14735: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14738: iconst_0
    //   14739: baload
    //   14740: iconst_4
    //   14741: ishl
    //   14742: aload 32
    //   14744: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14747: iconst_1
    //   14748: baload
    //   14749: iadd
    //   14750: istore 5
    //   14752: iconst_4
    //   14753: newarray byte
    //   14755: astore_1
    //   14756: aload 32
    //   14758: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14761: iconst_2
    //   14762: aload_1
    //   14763: iconst_0
    //   14764: iconst_4
    //   14765: invokestatic 3763	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   14768: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14771: ifeq +31 -> 14802
    //   14774: ldc_w 520
    //   14777: iconst_2
    //   14778: new 88	java/lang/StringBuilder
    //   14781: dup
    //   14782: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14785: ldc_w 3765
    //   14788: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14791: iload 5
    //   14793: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14796: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14799: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14802: invokestatic 3771	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   14805: new 3773	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor$2
    //   14808: dup
    //   14809: aload_0
    //   14810: iload 5
    //   14812: invokespecial 3776	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor$2:<init>	(Lakqf;I)V
    //   14815: invokevirtual 3780	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   14818: pop
    //   14819: iload 4
    //   14821: bipush 6
    //   14823: if_icmple -14794 -> 29
    //   14826: iload 4
    //   14828: bipush 6
    //   14830: isub
    //   14831: newarray byte
    //   14833: astore 28
    //   14835: aload 32
    //   14837: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14840: bipush 6
    //   14842: aload 28
    //   14844: iconst_0
    //   14845: iload 4
    //   14847: bipush 6
    //   14849: isub
    //   14850: invokestatic 3763	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   14853: iload 5
    //   14855: aload_1
    //   14856: aload 28
    //   14858: invokestatic 3785	akwa:a	(I[B[B)Z
    //   14861: pop
    //   14862: aconst_null
    //   14863: areturn
    //   14864: aload 32
    //   14866: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14869: ldc2_w 3786
    //   14872: lcmp
    //   14873: ifne +120 -> 14993
    //   14876: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14879: ifeq +13 -> 14892
    //   14882: ldc_w 520
    //   14885: iconst_2
    //   14886: ldc_w 3789
    //   14889: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14892: aload_0
    //   14893: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14896: sipush 252
    //   14899: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14902: checkcast 3791	tgc
    //   14905: astore_1
    //   14906: new 3793	com/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodePushNotify
    //   14909: dup
    //   14910: invokespecial 3794	com/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodePushNotify:<init>	()V
    //   14913: astore 28
    //   14915: aload 28
    //   14917: aload 32
    //   14919: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14922: invokevirtual 3795	com/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodePushNotify:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14925: pop
    //   14926: aload_0
    //   14927: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14930: sipush 251
    //   14933: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14936: checkcast 3797	tgb
    //   14939: astore 29
    //   14941: aload_1
    //   14942: getfield 3798	tgc:jdField_a_of_type_Boolean	Z
    //   14945: ifeq -14916 -> 29
    //   14948: aload 29
    //   14950: invokevirtual 3801	tgb:a	()Ltfn;
    //   14953: aload 28
    //   14955: invokevirtual 3806	tfn:a	(Lcom/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodePushNotify;)V
    //   14958: aconst_null
    //   14959: areturn
    //   14960: astore_1
    //   14961: ldc_w 520
    //   14964: iconst_1
    //   14965: new 88	java/lang/StringBuilder
    //   14968: dup
    //   14969: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14972: ldc_w 3808
    //   14975: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14978: aload_1
    //   14979: invokevirtual 3809	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   14982: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14985: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14988: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   14991: aconst_null
    //   14992: areturn
    //   14993: aload 32
    //   14995: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14998: ldc2_w 3810
    //   15001: lcmp
    //   15002: ifne +81 -> 15083
    //   15005: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15008: ifeq +34 -> 15042
    //   15011: ldc_w 520
    //   15014: iconst_2
    //   15015: new 88	java/lang/StringBuilder
    //   15018: dup
    //   15019: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   15022: ldc_w 3813
    //   15025: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15028: aload 32
    //   15030: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15033: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15036: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15039: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15042: aload_0
    //   15043: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15046: sipush 253
    //   15049: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   15052: checkcast 3815	ssu
    //   15055: astore 28
    //   15057: aload_1
    //   15058: getfield 1143	OnlinePushPack/MsgInfo:lFromUin	J
    //   15061: lstore_2
    //   15062: aload 28
    //   15064: aload 28
    //   15066: aload 32
    //   15068: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15071: lload_2
    //   15072: invokestatic 495	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   15075: invokevirtual 3818	ssu:a	([BLjava/lang/String;)Lcom/tencent/mobileqq/data/MessageForQQStoryFeed;
    //   15078: invokevirtual 3821	ssu:a	(Lcom/tencent/mobileqq/data/MessageForQQStoryFeed;)V
    //   15081: aconst_null
    //   15082: areturn
    //   15083: aload 32
    //   15085: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15088: ldc2_w 3822
    //   15091: lcmp
    //   15092: ifne +240 -> 15332
    //   15095: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15098: ifeq +13 -> 15111
    //   15101: ldc_w 520
    //   15104: iconst_2
    //   15105: ldc_w 3825
    //   15108: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15111: new 3827	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$MsgBody
    //   15114: dup
    //   15115: invokespecial 3828	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$MsgBody:<init>	()V
    //   15118: astore_1
    //   15119: aload 32
    //   15121: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15124: ifnull -15095 -> 29
    //   15127: aload_1
    //   15128: aload 32
    //   15130: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15133: invokevirtual 3829	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15136: pop
    //   15137: aload_1
    //   15138: getfield 3832	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$MsgBody:rpt_now_push_msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   15141: invokevirtual 45	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   15144: invokeinterface 51 1 0
    //   15149: astore_1
    //   15150: aload_1
    //   15151: invokeinterface 56 1 0
    //   15156: ifeq -15127 -> 29
    //   15159: aload_1
    //   15160: invokeinterface 60 1 0
    //   15165: checkcast 3834	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg
    //   15168: astore 28
    //   15170: aload_0
    //   15171: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15174: sipush 266
    //   15177: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   15180: checkcast 3836	atzk
    //   15183: aload 28
    //   15185: invokevirtual 3839	atzk:a	(Lcom/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg;)V
    //   15188: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15191: ifeq -41 -> 15150
    //   15194: ldc_w 520
    //   15197: iconst_2
    //   15198: new 88	java/lang/StringBuilder
    //   15201: dup
    //   15202: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   15205: ldc_w 3841
    //   15208: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15211: aload 28
    //   15213: getfield 3844	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint32_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   15216: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   15219: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15222: ldc_w 3846
    //   15225: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15228: aload 28
    //   15230: getfield 3847	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint32_task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   15233: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   15236: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15239: ldc_w 3849
    //   15242: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15245: aload 28
    //   15247: getfield 3850	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   15250: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   15253: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15256: ldc_w 3852
    //   15259: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15262: aload 28
    //   15264: getfield 3855	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint64_start_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   15267: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   15270: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15273: ldc_w 3857
    //   15276: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15279: aload 28
    //   15281: getfield 3860	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint64_end_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   15284: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   15287: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15290: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15293: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15296: goto -146 -> 15150
    //   15299: astore_1
    //   15300: ldc_w 520
    //   15303: iconst_1
    //   15304: new 88	java/lang/StringBuilder
    //   15307: dup
    //   15308: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   15311: ldc_w 3862
    //   15314: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15317: aload_1
    //   15318: invokevirtual 3546	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   15321: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15324: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15327: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   15330: aconst_null
    //   15331: areturn
    //   15332: aload 32
    //   15334: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15337: ldc2_w 3863
    //   15340: lcmp
    //   15341: ifne +33 -> 15374
    //   15344: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15347: ifeq +13 -> 15360
    //   15350: ldc_w 520
    //   15353: iconst_2
    //   15354: ldc_w 3866
    //   15357: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15360: aload_0
    //   15361: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15364: aload 32
    //   15366: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15369: aload_1
    //   15370: invokestatic 3871	anma:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BLOnlinePushPack/MsgInfo;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   15373: areturn
    //   15374: aload 32
    //   15376: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15379: ldc2_w 3872
    //   15382: lcmp
    //   15383: ifne +66 -> 15449
    //   15386: new 3875	tencent/im/s2c/msgtype0x210/submsgtype0x101/SubMsgType0x27$MsgBody
    //   15389: dup
    //   15390: invokespecial 3876	tencent/im/s2c/msgtype0x210/submsgtype0x101/SubMsgType0x27$MsgBody:<init>	()V
    //   15393: astore 28
    //   15395: aload 28
    //   15397: aload 32
    //   15399: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15402: invokevirtual 3877	tencent/im/s2c/msgtype0x210/submsgtype0x101/SubMsgType0x27$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15405: pop
    //   15406: aload_0
    //   15407: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15410: sipush 284
    //   15413: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   15416: checkcast 3879	aseo
    //   15419: aload 28
    //   15421: aload_1
    //   15422: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   15425: aload_1
    //   15426: getfield 1194	OnlinePushPack/MsgInfo:lMsgUid	J
    //   15429: invokevirtual 3882	aseo:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x101/SubMsgType0x27$MsgBody;SJ)V
    //   15432: aconst_null
    //   15433: areturn
    //   15434: astore_1
    //   15435: ldc_w 520
    //   15438: iconst_1
    //   15439: aload_1
    //   15440: iconst_0
    //   15441: anewarray 220	java/lang/Object
    //   15444: invokestatic 3885	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   15447: aconst_null
    //   15448: areturn
    //   15449: aload 32
    //   15451: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15454: ldc2_w 3886
    //   15457: lcmp
    //   15458: ifne +76 -> 15534
    //   15461: new 3889	tencent/im/s2c/msgtype0x210/submsgtype0x103/submsgtype0x103$MsgBody
    //   15464: dup
    //   15465: invokespecial 3890	tencent/im/s2c/msgtype0x210/submsgtype0x103/submsgtype0x103$MsgBody:<init>	()V
    //   15468: astore_1
    //   15469: aload_1
    //   15470: aload 32
    //   15472: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15475: invokevirtual 3891	tencent/im/s2c/msgtype0x210/submsgtype0x103/submsgtype0x103$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15478: pop
    //   15479: aload_0
    //   15480: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15483: invokevirtual 3894	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   15486: invokevirtual 3899	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lamnx;
    //   15489: aload_1
    //   15490: invokevirtual 3904	amnx:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x103/submsgtype0x103$MsgBody;)V
    //   15493: aconst_null
    //   15494: areturn
    //   15495: astore_1
    //   15496: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15499: ifeq -15470 -> 29
    //   15502: ldc_w 520
    //   15505: iconst_2
    //   15506: new 88	java/lang/StringBuilder
    //   15509: dup
    //   15510: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   15513: ldc_w 3906
    //   15516: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15519: aload_1
    //   15520: invokevirtual 3907	java/lang/Exception:toString	()Ljava/lang/String;
    //   15523: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15526: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15529: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15532: aconst_null
    //   15533: areturn
    //   15534: aload 32
    //   15536: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15539: ldc2_w 3908
    //   15542: lcmp
    //   15543: ifne +76 -> 15619
    //   15546: new 3911	tencent/im/s2c/msgtype0x210/submsgtype0x104/submsgtype0x104$MsgBody
    //   15549: dup
    //   15550: invokespecial 3912	tencent/im/s2c/msgtype0x210/submsgtype0x104/submsgtype0x104$MsgBody:<init>	()V
    //   15553: astore_1
    //   15554: aload_1
    //   15555: aload 32
    //   15557: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15560: invokevirtual 3913	tencent/im/s2c/msgtype0x210/submsgtype0x104/submsgtype0x104$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15563: pop
    //   15564: aload_0
    //   15565: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15568: invokevirtual 3894	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   15571: invokevirtual 3899	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lamnx;
    //   15574: aload_1
    //   15575: invokevirtual 3916	amnx:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x104/submsgtype0x104$MsgBody;)V
    //   15578: aconst_null
    //   15579: areturn
    //   15580: astore_1
    //   15581: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15584: ifeq -15555 -> 29
    //   15587: ldc_w 520
    //   15590: iconst_2
    //   15591: new 88	java/lang/StringBuilder
    //   15594: dup
    //   15595: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   15598: ldc_w 3918
    //   15601: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15604: aload_1
    //   15605: invokevirtual 3907	java/lang/Exception:toString	()Ljava/lang/String;
    //   15608: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15611: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15614: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15617: aconst_null
    //   15618: areturn
    //   15619: aload 32
    //   15621: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15624: ldc2_w 3919
    //   15627: lcmp
    //   15628: ifne +33 -> 15661
    //   15631: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15634: ifeq +13 -> 15647
    //   15637: ldc_w 520
    //   15640: iconst_2
    //   15641: ldc_w 3922
    //   15644: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15647: aload_0
    //   15648: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15651: aload 32
    //   15653: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15656: aload_1
    //   15657: invokestatic 3925	anne:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BLOnlinePushPack/MsgInfo;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   15660: areturn
    //   15661: aload 32
    //   15663: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15666: ldc2_w 3926
    //   15669: lcmp
    //   15670: ifne +33 -> 15703
    //   15673: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15676: ifeq +13 -> 15689
    //   15679: ldc_w 520
    //   15682: iconst_2
    //   15683: ldc_w 3929
    //   15686: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15689: aload_0
    //   15690: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15693: aload 32
    //   15695: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15698: invokestatic 3932	akac:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   15701: aconst_null
    //   15702: areturn
    //   15703: aload 32
    //   15705: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15708: ldc2_w 3933
    //   15711: lcmp
    //   15712: ifne +49 -> 15761
    //   15715: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15718: ifeq +13 -> 15731
    //   15721: ldc_w 520
    //   15724: iconst_2
    //   15725: ldc_w 3936
    //   15728: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15731: aload_0
    //   15732: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15735: iconst_1
    //   15736: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   15739: checkcast 211	com/tencent/mobileqq/app/FriendListHandler
    //   15742: checkcast 211	com/tencent/mobileqq/app/FriendListHandler
    //   15745: astore_1
    //   15746: aload_1
    //   15747: ifnull -15718 -> 29
    //   15750: aload_1
    //   15751: aload 32
    //   15753: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15756: invokevirtual 3937	com/tencent/mobileqq/app/FriendListHandler:a	([B)V
    //   15759: aconst_null
    //   15760: areturn
    //   15761: aload 32
    //   15763: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15766: ldc2_w 3938
    //   15769: lcmp
    //   15770: ifne +44 -> 15814
    //   15773: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15776: ifeq +13 -> 15789
    //   15779: ldc_w 520
    //   15782: iconst_2
    //   15783: ldc_w 3941
    //   15786: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15789: aload_0
    //   15790: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15793: aload 32
    //   15795: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15798: aload_1
    //   15799: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   15802: i2l
    //   15803: aload_1
    //   15804: getfield 1187	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   15807: i2l
    //   15808: iconst_0
    //   15809: invokestatic 3946	arrj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BJJZ)V
    //   15812: aconst_null
    //   15813: areturn
    //   15814: aload 32
    //   15816: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15819: ldc2_w 3947
    //   15822: lcmp
    //   15823: ifeq +15 -> 15838
    //   15826: aload 32
    //   15828: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15831: ldc2_w 3949
    //   15834: lcmp
    //   15835: ifne +92 -> 15927
    //   15838: aload_0
    //   15839: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15842: sipush 339
    //   15845: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   15848: checkcast 3952	ayna
    //   15851: iconst_4
    //   15852: invokevirtual 3955	ayna:a	(I)Laynl;
    //   15855: astore 28
    //   15857: aload 28
    //   15859: ifnull -15830 -> 29
    //   15862: aload_0
    //   15863: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15866: astore 29
    //   15868: aload 32
    //   15870: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15873: astore 30
    //   15875: aload_1
    //   15876: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   15879: i2l
    //   15880: lstore_2
    //   15881: aload_1
    //   15882: getfield 1187	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   15885: i2l
    //   15886: lstore 15
    //   15888: aload 32
    //   15890: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15893: ldc2_w 3947
    //   15896: lcmp
    //   15897: ifne +24 -> 15921
    //   15900: iconst_0
    //   15901: istore 19
    //   15903: aload 28
    //   15905: aload 29
    //   15907: aload 30
    //   15909: lload_2
    //   15910: lload 15
    //   15912: iload 19
    //   15914: invokeinterface 3958 8 0
    //   15919: aconst_null
    //   15920: areturn
    //   15921: iconst_1
    //   15922: istore 19
    //   15924: goto -21 -> 15903
    //   15927: aload 32
    //   15929: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15932: ldc2_w 3959
    //   15935: lcmp
    //   15936: ifne +30 -> 15966
    //   15939: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15942: ifeq +13 -> 15955
    //   15945: ldc_w 520
    //   15948: iconst_2
    //   15949: ldc_w 3962
    //   15952: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15955: aload 32
    //   15957: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15960: lload_2
    //   15961: invokestatic 3965	avds:a	([BJ)V
    //   15964: aconst_null
    //   15965: areturn
    //   15966: aload 32
    //   15968: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15971: ldc2_w 3966
    //   15974: lcmp
    //   15975: ifne +195 -> 16170
    //   15978: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15981: ifeq +13 -> 15994
    //   15984: ldc_w 520
    //   15987: iconst_2
    //   15988: ldc_w 3969
    //   15991: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15994: new 3971	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$MsgBody
    //   15997: dup
    //   15998: invokespecial 3972	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$MsgBody:<init>	()V
    //   16001: astore_1
    //   16002: aload 32
    //   16004: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16007: ifnull -15978 -> 29
    //   16010: aload_1
    //   16011: aload 32
    //   16013: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16016: invokevirtual 3973	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16019: pop
    //   16020: aload_1
    //   16021: getfield 3974	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$MsgBody:uint64_from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   16024: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   16027: lstore_2
    //   16028: aload_1
    //   16029: getfield 3975	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$MsgBody:uint64_to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   16032: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   16035: lstore 15
    //   16037: aload_1
    //   16038: getfield 3979	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$MsgBody:msg_notify_item	Ltencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem;
    //   16041: invokevirtual 3982	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16044: checkcast 3981	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem
    //   16047: astore_1
    //   16048: aload_1
    //   16049: getfield 3985	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem:uint32_timeout_s	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   16052: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   16055: istore 4
    //   16057: aload_1
    //   16058: getfield 3988	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem:uint32_event_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   16061: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   16064: istore 5
    //   16066: aload_1
    //   16067: getfield 3991	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem:uint32_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   16070: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   16073: istore 6
    //   16075: aload_1
    //   16076: getfield 3994	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem:uint64_timestamp	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   16079: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   16082: lstore 17
    //   16084: aload_1
    //   16085: getfield 3995	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem:bytes_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   16088: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   16091: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   16094: astore_1
    //   16095: aload_0
    //   16096: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16099: sipush 316
    //   16102: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   16105: astore 28
    //   16107: aload 28
    //   16109: instanceof 3997
    //   16112: ifeq -16083 -> 29
    //   16115: aload 28
    //   16117: checkcast 3997	ardv
    //   16120: lload_2
    //   16121: lload 15
    //   16123: lload 17
    //   16125: iload 6
    //   16127: iload 4
    //   16129: iload 5
    //   16131: aload_1
    //   16132: invokevirtual 4000	ardv:a	(JJJIIILjava/lang/String;)V
    //   16135: aconst_null
    //   16136: areturn
    //   16137: astore_1
    //   16138: ldc_w 520
    //   16141: iconst_1
    //   16142: new 88	java/lang/StringBuilder
    //   16145: dup
    //   16146: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   16149: ldc_w 4002
    //   16152: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16155: aload_1
    //   16156: invokevirtual 3546	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   16159: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16162: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16165: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16168: aconst_null
    //   16169: areturn
    //   16170: aload 32
    //   16172: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16175: ldc2_w 4003
    //   16178: lcmp
    //   16179: ifne +142 -> 16321
    //   16182: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16185: ifeq +13 -> 16198
    //   16188: ldc_w 520
    //   16191: iconst_2
    //   16192: ldc_w 4006
    //   16195: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16198: new 4008	tencent/im/s2c/msgtype0x210/submsgtype0x119/SubMsgType0x119$MsgBody
    //   16201: dup
    //   16202: invokespecial 4009	tencent/im/s2c/msgtype0x210/submsgtype0x119/SubMsgType0x119$MsgBody:<init>	()V
    //   16205: astore 28
    //   16207: aload 32
    //   16209: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16212: ifnull -16183 -> 29
    //   16215: aload 28
    //   16217: aload 32
    //   16219: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16222: invokevirtual 4010	tencent/im/s2c/msgtype0x210/submsgtype0x119/SubMsgType0x119$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16225: pop
    //   16226: ldc_w 520
    //   16229: iconst_1
    //   16230: new 88	java/lang/StringBuilder
    //   16233: dup
    //   16234: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   16237: ldc_w 4012
    //   16240: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16243: aload 28
    //   16245: invokevirtual 2129	java/lang/Object:toString	()Ljava/lang/String;
    //   16248: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16251: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16254: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16257: aload_1
    //   16258: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   16261: invokestatic 4015	ayfv:a	(I)Z
    //   16264: ifne -16235 -> 29
    //   16267: aload_0
    //   16268: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16271: aload 28
    //   16273: invokestatic 4018	ayfv:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ltencent/im/s2c/msgtype0x210/submsgtype0x119/SubMsgType0x119$MsgBody;)V
    //   16276: ldc_w 520
    //   16279: iconst_1
    //   16280: ldc_w 4020
    //   16283: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16286: aconst_null
    //   16287: areturn
    //   16288: astore_1
    //   16289: ldc_w 520
    //   16292: iconst_1
    //   16293: new 88	java/lang/StringBuilder
    //   16296: dup
    //   16297: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   16300: ldc_w 4002
    //   16303: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16306: aload_1
    //   16307: invokevirtual 3546	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   16310: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16313: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16316: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16319: aconst_null
    //   16320: areturn
    //   16321: aload 32
    //   16323: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16326: ldc2_w 4021
    //   16329: lcmp
    //   16330: ifne +104 -> 16434
    //   16333: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16336: ifeq +13 -> 16349
    //   16339: ldc_w 520
    //   16342: iconst_2
    //   16343: ldc_w 4024
    //   16346: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16349: new 4026	tencent/im/s2c/msgtype0x210/submsgtype0x120/SubMsgType0x120$MsgBody
    //   16352: dup
    //   16353: invokespecial 4027	tencent/im/s2c/msgtype0x210/submsgtype0x120/SubMsgType0x120$MsgBody:<init>	()V
    //   16356: astore_1
    //   16357: aload 32
    //   16359: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16362: ifnull -16333 -> 29
    //   16365: aload_1
    //   16366: aload 32
    //   16368: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16371: invokevirtual 4028	tencent/im/s2c/msgtype0x210/submsgtype0x120/SubMsgType0x120$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16374: pop
    //   16375: aload_0
    //   16376: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16379: aload_1
    //   16380: invokestatic 4033	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ltencent/im/s2c/msgtype0x210/submsgtype0x120/SubMsgType0x120$MsgBody;)V
    //   16383: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16386: ifeq -16357 -> 29
    //   16389: ldc_w 520
    //   16392: iconst_2
    //   16393: ldc_w 4035
    //   16396: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16399: aconst_null
    //   16400: areturn
    //   16401: astore_1
    //   16402: ldc_w 520
    //   16405: iconst_1
    //   16406: new 88	java/lang/StringBuilder
    //   16409: dup
    //   16410: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   16413: ldc_w 4037
    //   16416: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16419: aload_1
    //   16420: invokevirtual 3546	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   16423: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16426: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16429: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16432: aconst_null
    //   16433: areturn
    //   16434: aload 32
    //   16436: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16439: ldc2_w 4038
    //   16442: lcmp
    //   16443: ifne +26 -> 16469
    //   16446: aload_0
    //   16447: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16450: aload 32
    //   16452: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16455: aload_1
    //   16456: getfield 1164	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   16459: aload_1
    //   16460: getfield 1187	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   16463: iconst_0
    //   16464: invokestatic 4044	arun:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BSIZ)V
    //   16467: aconst_null
    //   16468: areturn
    //   16469: aload 32
    //   16471: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16474: ldc2_w 4045
    //   16477: lcmp
    //   16478: ifne +87 -> 16565
    //   16481: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16484: ifeq +13 -> 16497
    //   16487: ldc_w 520
    //   16490: iconst_2
    //   16491: ldc_w 4048
    //   16494: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16497: new 4050	tencent/im/s2c/msgtype0x210/submsgtype0x11a/submsgtype0x11a$MsgBody
    //   16500: dup
    //   16501: invokespecial 4051	tencent/im/s2c/msgtype0x210/submsgtype0x11a/submsgtype0x11a$MsgBody:<init>	()V
    //   16504: astore_1
    //   16505: aload 32
    //   16507: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16510: ifnull -16481 -> 29
    //   16513: aload_1
    //   16514: aload 32
    //   16516: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16519: invokevirtual 4052	tencent/im/s2c/msgtype0x210/submsgtype0x11a/submsgtype0x11a$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16522: pop
    //   16523: invokestatic 4057	askv:a	()Laskv;
    //   16526: aload_1
    //   16527: invokevirtual 4060	askv:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x11a/submsgtype0x11a$MsgBody;)V
    //   16530: aconst_null
    //   16531: areturn
    //   16532: astore_1
    //   16533: ldc_w 520
    //   16536: iconst_1
    //   16537: new 88	java/lang/StringBuilder
    //   16540: dup
    //   16541: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   16544: ldc_w 4062
    //   16547: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16550: aload_1
    //   16551: invokevirtual 3546	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   16554: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16557: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16560: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16563: aconst_null
    //   16564: areturn
    //   16565: aload 32
    //   16567: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16570: ldc2_w 4063
    //   16573: lcmp
    //   16574: ifne +261 -> 16835
    //   16577: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16580: ifeq +13 -> 16593
    //   16583: ldc_w 520
    //   16586: iconst_2
    //   16587: ldc_w 4066
    //   16590: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16593: new 4068	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody
    //   16596: dup
    //   16597: invokespecial 4069	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:<init>	()V
    //   16600: astore_1
    //   16601: aload 32
    //   16603: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16606: ifnull -16577 -> 29
    //   16609: aload_1
    //   16610: aload 32
    //   16612: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16615: invokevirtual 4070	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16618: pop
    //   16619: aload_1
    //   16620: getfield 4071	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   16623: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   16626: ifeq +108 -> 16734
    //   16629: aload_1
    //   16630: getfield 4071	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   16633: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   16636: istore 4
    //   16638: iload 4
    //   16640: iconst_2
    //   16641: if_icmpne +99 -> 16740
    //   16644: aload_0
    //   16645: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16648: invokevirtual 2639	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   16651: aload_1
    //   16652: invokevirtual 4074	com/tencent/av/gaudio/AVNotifyCenter:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody;)V
    //   16655: ldc 140
    //   16657: astore_1
    //   16658: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16661: ifeq -16632 -> 29
    //   16664: ldc_w 520
    //   16667: iconst_2
    //   16668: iconst_4
    //   16669: anewarray 220	java/lang/Object
    //   16672: dup
    //   16673: iconst_0
    //   16674: ldc_w 4076
    //   16677: aastore
    //   16678: dup
    //   16679: iconst_1
    //   16680: iload 4
    //   16682: invokestatic 255	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16685: aastore
    //   16686: dup
    //   16687: iconst_2
    //   16688: ldc_w 4078
    //   16691: aastore
    //   16692: dup
    //   16693: iconst_3
    //   16694: aload_1
    //   16695: aastore
    //   16696: invokestatic 691	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   16699: aconst_null
    //   16700: areturn
    //   16701: astore_1
    //   16702: ldc_w 520
    //   16705: iconst_1
    //   16706: new 88	java/lang/StringBuilder
    //   16709: dup
    //   16710: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   16713: ldc_w 4080
    //   16716: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16719: aload_1
    //   16720: invokevirtual 3546	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   16723: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16726: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16729: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16732: aconst_null
    //   16733: areturn
    //   16734: iconst_0
    //   16735: istore 4
    //   16737: goto -99 -> 16638
    //   16740: aload_1
    //   16741: getfield 4083	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:str_msg_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   16744: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   16747: istore 19
    //   16749: iload 19
    //   16751: ifeq +78 -> 16829
    //   16754: aload_1
    //   16755: getfield 4083	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:str_msg_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   16758: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   16761: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   16764: astore_1
    //   16765: new 913	android/os/Bundle
    //   16768: dup
    //   16769: invokespecial 914	android/os/Bundle:<init>	()V
    //   16772: astore 28
    //   16774: aload 28
    //   16776: ldc_w 4085
    //   16779: iload 4
    //   16781: invokevirtual 2199	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   16784: aload 28
    //   16786: ldc_w 4087
    //   16789: aload_1
    //   16790: invokevirtual 4089	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   16793: aload_0
    //   16794: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16797: ldc_w 4091
    //   16800: bipush 11
    //   16802: iconst_1
    //   16803: aload 28
    //   16805: invokevirtual 932	com/tencent/mobileqq/app/QQAppInterface:notifyObservers	(Ljava/lang/Class;IZLandroid/os/Bundle;)V
    //   16808: goto -150 -> 16658
    //   16811: astore_1
    //   16812: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16815: ifeq +14 -> 16829
    //   16818: ldc_w 520
    //   16821: iconst_2
    //   16822: ldc_w 4093
    //   16825: aload_1
    //   16826: invokestatic 4095	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16829: ldc 140
    //   16831: astore_1
    //   16832: goto -67 -> 16765
    //   16835: aload 32
    //   16837: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16840: ldc2_w 4096
    //   16843: lcmp
    //   16844: ifne +87 -> 16931
    //   16847: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16850: ifeq +13 -> 16863
    //   16853: ldc_w 520
    //   16856: iconst_2
    //   16857: ldc_w 4099
    //   16860: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16863: new 4101	tencent/im/s2c/msgtype0x210/submsgtype0x11b/submsgtype0x11b$MsgBody
    //   16866: dup
    //   16867: invokespecial 4102	tencent/im/s2c/msgtype0x210/submsgtype0x11b/submsgtype0x11b$MsgBody:<init>	()V
    //   16870: astore_1
    //   16871: aload 32
    //   16873: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16876: ifnull -16847 -> 29
    //   16879: aload_1
    //   16880: aload 32
    //   16882: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16885: invokevirtual 4103	tencent/im/s2c/msgtype0x210/submsgtype0x11b/submsgtype0x11b$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16888: pop
    //   16889: invokestatic 4057	askv:a	()Laskv;
    //   16892: aload_1
    //   16893: invokevirtual 4106	askv:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x11b/submsgtype0x11b$MsgBody;)V
    //   16896: aconst_null
    //   16897: areturn
    //   16898: astore_1
    //   16899: ldc_w 520
    //   16902: iconst_1
    //   16903: new 88	java/lang/StringBuilder
    //   16906: dup
    //   16907: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   16910: ldc_w 4108
    //   16913: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16916: aload_1
    //   16917: invokevirtual 3546	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   16920: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16923: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16926: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16929: aconst_null
    //   16930: areturn
    //   16931: aload 32
    //   16933: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16936: ldc2_w 4109
    //   16939: lcmp
    //   16940: ifeq +15 -> 16955
    //   16943: aload 32
    //   16945: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16948: ldc2_w 4111
    //   16951: lcmp
    //   16952: ifne +49 -> 17001
    //   16955: aload_0
    //   16956: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16959: astore 28
    //   16961: aload 32
    //   16963: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16966: astore 29
    //   16968: aload 32
    //   16970: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16973: ldc2_w 4109
    //   16976: lcmp
    //   16977: ifne +18 -> 16995
    //   16980: iconst_1
    //   16981: istore 19
    //   16983: aload 28
    //   16985: aload 29
    //   16987: aload_1
    //   16988: iload 19
    //   16990: invokestatic 4117	aqva:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BLOnlinePushPack/MsgInfo;Z)V
    //   16993: aconst_null
    //   16994: areturn
    //   16995: iconst_0
    //   16996: istore 19
    //   16998: goto -15 -> 16983
    //   17001: aload 32
    //   17003: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   17006: ldc2_w 4118
    //   17009: lcmp
    //   17010: ifne +118 -> 17128
    //   17013: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17016: ifeq +13 -> 17029
    //   17019: ldc_w 520
    //   17022: iconst_2
    //   17023: ldc_w 4121
    //   17026: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17029: new 4123	tencent/im/s2c/msgtype0x210/submsgtype0x128/submsgtype0x128$MsgBody
    //   17032: dup
    //   17033: invokespecial 4124	tencent/im/s2c/msgtype0x210/submsgtype0x128/submsgtype0x128$MsgBody:<init>	()V
    //   17036: astore_1
    //   17037: aload 32
    //   17039: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   17042: ifnull +74 -> 17116
    //   17045: aload_1
    //   17046: aload 32
    //   17048: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   17051: invokevirtual 4125	tencent/im/s2c/msgtype0x210/submsgtype0x128/submsgtype0x128$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   17054: pop
    //   17055: aload_0
    //   17056: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17059: bipush 127
    //   17061: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   17064: checkcast 4127	aoeo
    //   17067: aload_1
    //   17068: invokevirtual 4130	aoeo:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x128/submsgtype0x128$MsgBody;)V
    //   17071: ldc_w 4132
    //   17074: iconst_2
    //   17075: ldc_w 4134
    //   17078: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17081: aconst_null
    //   17082: areturn
    //   17083: astore_1
    //   17084: ldc_w 520
    //   17087: iconst_1
    //   17088: new 88	java/lang/StringBuilder
    //   17091: dup
    //   17092: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   17095: ldc_w 4136
    //   17098: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17101: aload_1
    //   17102: invokevirtual 3546	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   17105: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17108: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17111: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   17114: aconst_null
    //   17115: areturn
    //   17116: ldc_w 520
    //   17119: iconst_2
    //   17120: ldc_w 4138
    //   17123: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   17126: aconst_null
    //   17127: areturn
    //   17128: aload 32
    //   17130: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   17133: ldc2_w 4139
    //   17136: lcmp
    //   17137: ifne -17108 -> 29
    //   17140: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17143: ifeq +13 -> 17156
    //   17146: ldc_w 520
    //   17149: iconst_2
    //   17150: ldc_w 4142
    //   17153: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   17156: aload_0
    //   17157: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17160: sipush 169
    //   17163: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   17166: checkcast 4144	afhx
    //   17169: checkcast 4144	afhx
    //   17172: astore_1
    //   17173: aload_1
    //   17174: ifnull -17145 -> 29
    //   17177: aload_1
    //   17178: aload 32
    //   17180: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   17183: invokevirtual 4145	afhx:a	([B)V
    //   17186: aconst_null
    //   17187: areturn
    //   17188: aload 32
    //   17190: getfield 1514	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   17193: ldc2_w 4146
    //   17196: lcmp
    //   17197: ifne -17168 -> 29
    //   17200: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17203: ifeq +13 -> 17216
    //   17206: ldc_w 520
    //   17209: iconst_2
    //   17210: ldc_w 4149
    //   17213: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17216: new 4151	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody
    //   17219: dup
    //   17220: invokespecial 4152	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:<init>	()V
    //   17223: astore 28
    //   17225: aload 32
    //   17227: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   17230: ifnull -17201 -> 29
    //   17233: aload 28
    //   17235: aload 32
    //   17237: getfield 1546	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   17240: invokevirtual 4153	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   17243: pop
    //   17244: aload 28
    //   17246: getfield 4154	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   17249: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   17252: ifeq +87 -> 17339
    //   17255: aload 28
    //   17257: getfield 4154	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   17260: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   17263: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   17266: astore_1
    //   17267: aload 28
    //   17269: getfield 4157	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:bytes_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   17272: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   17275: ifeq +70 -> 17345
    //   17278: aload 28
    //   17280: getfield 4157	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:bytes_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   17283: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   17286: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   17289: astore 28
    //   17291: invokestatic 4162	aluc:a	()Laluc;
    //   17294: aload_0
    //   17295: getfield 154	akqf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17298: aload_1
    //   17299: aload 28
    //   17301: invokevirtual 4164	aluc:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)V
    //   17304: aconst_null
    //   17305: areturn
    //   17306: astore_1
    //   17307: ldc_w 520
    //   17310: iconst_1
    //   17311: new 88	java/lang/StringBuilder
    //   17314: dup
    //   17315: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   17318: ldc_w 4166
    //   17321: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17324: aload_1
    //   17325: invokevirtual 3546	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   17328: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17331: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17334: invokestatic 846	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   17337: aconst_null
    //   17338: areturn
    //   17339: ldc 140
    //   17341: astore_1
    //   17342: goto -75 -> 17267
    //   17345: ldc 140
    //   17347: astore 28
    //   17349: goto -58 -> 17291
    //   17352: astore 28
    //   17354: goto -6269 -> 11085
    //   17357: astore_1
    //   17358: goto -7828 -> 9530
    //   17361: astore 30
    //   17363: goto -13713 -> 3650
    //   17366: astore 30
    //   17368: goto -13718 -> 3650
    //   17371: iconst_0
    //   17372: istore 19
    //   17374: goto -6045 -> 11329
    //   17377: iload 21
    //   17379: istore 24
    //   17381: iload 22
    //   17383: istore 25
    //   17385: iload 20
    //   17387: istore 26
    //   17389: iload 19
    //   17391: istore 27
    //   17393: goto -7228 -> 10165
    //   17396: goto -7415 -> 9981
    //   17399: aconst_null
    //   17400: astore_1
    //   17401: goto -9655 -> 7746
    //   17404: iconst_0
    //   17405: istore 6
    //   17407: goto -13014 -> 4393
    //   17410: iconst_0
    //   17411: istore 5
    //   17413: goto -13041 -> 4372
    //   17416: aconst_null
    //   17417: astore 30
    //   17419: goto -13872 -> 3547
    //   17422: aconst_null
    //   17423: astore 29
    //   17425: goto -13912 -> 3513
    //   17428: aconst_null
    //   17429: astore 28
    //   17431: goto -13956 -> 3475
    //   17434: iload 7
    //   17436: ifge -12927 -> 4509
    //   17439: iload 8
    //   17441: iflt -12898 -> 4543
    //   17444: goto -12935 -> 4509
    //   17447: iload 5
    //   17449: ifne -12863 -> 4586
    //   17452: iload 6
    //   17454: ifeq -12784 -> 4670
    //   17457: goto -12871 -> 4586
    //   17460: aload 29
    //   17462: astore 28
    //   17464: iload 5
    //   17466: istore 4
    //   17468: goto -9412 -> 8056
    //   17471: aload 30
    //   17473: areturn
    //   17474: sipush 1001
    //   17477: istore 4
    //   17479: aload 29
    //   17481: astore 28
    //   17483: goto -9427 -> 8056
    //   17486: goto -8398 -> 9088
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	17489	0	this	akqf
    //   0	17489	1	paramMsgInfo	MsgInfo
    //   0	17489	2	paramLong	long
    //   451	17027	4	i	int
    //   712	16753	5	j	int
    //   4025	13428	6	k	int
    //   4394	13041	7	m	int
    //   4397	13043	8	n	int
    //   4449	6031	9	i1	int
    //   9759	787	10	i2	int
    //   10328	63	11	i3	int
    //   10341	57	12	i4	int
    //   10354	54	13	i5	int
    //   10364	41	14	i6	int
    //   2405	13717	15	l1	long
    //   6457	9667	17	l2	long
    //   193	17197	19	bool1	boolean
    //   9629	7757	20	bool2	boolean
    //   9659	7719	21	bool3	boolean
    //   9599	7783	22	bool4	boolean
    //   9614	1333	23	bool5	boolean
    //   10068	7312	24	bool6	boolean
    //   10072	7312	25	bool7	boolean
    //   10076	7312	26	bool8	boolean
    //   10080	7312	27	bool9	boolean
    //   108	2272	28	localObject1	Object
    //   2429	1	28	localException1	Exception
    //   2551	315	28	localObject2	Object
    //   2879	26	28	localInvalidProtocolBufferMicroException1	InvalidProtocolBufferMicroException
    //   3392	295	28	localObject3	Object
    //   3693	3	28	localInvalidProtocolBufferMicroException2	InvalidProtocolBufferMicroException
    //   3926	7709	28	localObject4	Object
    //   12141	1	28	localException2	Exception
    //   12181	83	28	localMsgBody	tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.MsgBody
    //   12763	72	28	localException3	Exception
    //   12848	4500	28	localObject5	Object
    //   17352	1	28	localThrowable	java.lang.Throwable
    //   17429	53	28	localObject6	Object
    //   171	2491	29	localObject7	Object
    //   2672	36	29	localInvalidProtocolBufferMicroException3	InvalidProtocolBufferMicroException
    //   3432	14048	29	localObject8	Object
    //   650	2944	30	localObject9	Object
    //   3648	1	30	localException4	Exception
    //   3660	12248	30	localObject10	Object
    //   17361	1	30	localException5	Exception
    //   17366	1	30	localException6	Exception
    //   17417	55	30	localMessageRecord	MessageRecord
    //   729	12001	31	localObject11	Object
    //   22	17214	32	localObject12	Object
    //   2177	10467	33	localObject13	Object
    //   8351	109	34	localajxn	ajxn
    // Exception table:
    //   from	to	target	type
    //   427	487	489	java/lang/Exception
    //   521	620	838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   625	636	838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   639	667	838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   667	682	838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   682	714	838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   720	758	838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   758	835	838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   892	915	838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   920	1009	838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1009	1054	838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1057	1132	838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1147	1211	1428	java/lang/Exception
    //   1211	1248	1428	java/lang/Exception
    //   1248	1281	1428	java/lang/Exception
    //   1281	1387	1428	java/lang/Exception
    //   1387	1426	1428	java/lang/Exception
    //   1838	1955	2071	java/lang/Exception
    //   1960	1978	2071	java/lang/Exception
    //   1978	2069	2071	java/lang/Exception
    //   2170	2190	2429	java/lang/Exception
    //   2190	2224	2429	java/lang/Exception
    //   2224	2258	2429	java/lang/Exception
    //   2258	2292	2429	java/lang/Exception
    //   2292	2316	2429	java/lang/Exception
    //   2316	2372	2429	java/lang/Exception
    //   2372	2390	2429	java/lang/Exception
    //   2553	2564	2672	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2819	2829	2879	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3437	3471	3648	java/lang/Exception
    //   3340	3356	3693	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3356	3423	3693	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3437	3471	3693	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3475	3509	3693	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3513	3547	3693	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3559	3609	3693	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3662	3678	3693	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3735	3751	3693	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3872	3892	4683	java/lang/Exception
    //   3895	3928	4683	java/lang/Exception
    //   3931	3952	4683	java/lang/Exception
    //   3952	3986	4683	java/lang/Exception
    //   3994	4018	4683	java/lang/Exception
    //   4030	4051	4683	java/lang/Exception
    //   4051	4072	4683	java/lang/Exception
    //   4072	4092	4683	java/lang/Exception
    //   4092	4113	4683	java/lang/Exception
    //   4113	4179	4683	java/lang/Exception
    //   4179	4193	4683	java/lang/Exception
    //   4198	4208	4683	java/lang/Exception
    //   4208	4245	4683	java/lang/Exception
    //   4262	4323	4683	java/lang/Exception
    //   4325	4345	4683	java/lang/Exception
    //   4345	4372	4683	java/lang/Exception
    //   4372	4393	4683	java/lang/Exception
    //   4399	4420	4683	java/lang/Exception
    //   4420	4441	4683	java/lang/Exception
    //   4441	4506	4683	java/lang/Exception
    //   4509	4543	4683	java/lang/Exception
    //   4543	4583	4683	java/lang/Exception
    //   4586	4631	4683	java/lang/Exception
    //   4631	4670	4683	java/lang/Exception
    //   4670	4680	4683	java/lang/Exception
    //   4727	4754	4683	java/lang/Exception
    //   4754	4803	4683	java/lang/Exception
    //   4803	4830	4683	java/lang/Exception
    //   4830	4857	4683	java/lang/Exception
    //   4857	4876	4683	java/lang/Exception
    //   4887	4914	4683	java/lang/Exception
    //   4914	4931	4683	java/lang/Exception
    //   4942	4966	4683	java/lang/Exception
    //   4969	4990	4683	java/lang/Exception
    //   4990	5024	4683	java/lang/Exception
    //   5030	5214	4683	java/lang/Exception
    //   5229	5375	4683	java/lang/Exception
    //   5378	5460	4683	java/lang/Exception
    //   5469	5514	4683	java/lang/Exception
    //   5514	5532	4683	java/lang/Exception
    //   5555	5565	5659	java/lang/Throwable
    //   5954	6021	6037	java/lang/Throwable
    //   6021	6035	6037	java/lang/Throwable
    //   6182	6297	6371	java/lang/Exception
    //   6297	6334	6371	java/lang/Exception
    //   6334	6369	6371	java/lang/Exception
    //   6681	6750	6893	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6750	6816	6893	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6822	6891	6893	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6969	7021	7023	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   7112	7122	7192	java/lang/Exception
    //   7126	7137	7192	java/lang/Exception
    //   7146	7190	7192	java/lang/Exception
    //   7250	7447	7758	java/lang/Exception
    //   7447	7592	7758	java/lang/Exception
    //   7748	7755	7758	java/lang/Exception
    //   7816	7851	7853	java/lang/Exception
    //   7901	7936	7938	java/lang/Exception
    //   7990	8001	8319	java/lang/Exception
    //   8016	8056	8319	java/lang/Exception
    //   8056	8200	8319	java/lang/Exception
    //   8200	8264	8319	java/lang/Exception
    //   8272	8285	8319	java/lang/Exception
    //   8293	8306	8319	java/lang/Exception
    //   8309	8316	8319	java/lang/Exception
    //   8373	8455	8633	java/lang/Exception
    //   8459	8468	8633	java/lang/Exception
    //   8473	8481	8633	java/lang/Exception
    //   8484	8615	8633	java/lang/Exception
    //   8732	8742	8803	java/lang/Throwable
    //   8883	8903	8905	java/lang/Exception
    //   8970	8982	8984	java/lang/Throwable
    //   9027	9088	9127	java/lang/Exception
    //   9088	9097	9127	java/lang/Exception
    //   9097	9125	9127	java/lang/Exception
    //   9146	9155	9127	java/lang/Exception
    //   9158	9167	9127	java/lang/Exception
    //   9170	9179	9127	java/lang/Exception
    //   9218	9268	9415	java/lang/Exception
    //   9268	9298	9415	java/lang/Exception
    //   9308	9348	9415	java/lang/Exception
    //   9356	9386	9415	java/lang/Exception
    //   9386	9413	9415	java/lang/Exception
    //   9467	9493	9495	java/lang/Exception
    //   11140	11159	11193	java/lang/Exception
    //   11387	11398	11703	java/lang/Exception
    //   11398	11421	11703	java/lang/Exception
    //   11421	11445	11703	java/lang/Exception
    //   11445	11469	11703	java/lang/Exception
    //   11469	11547	11703	java/lang/Exception
    //   11547	11701	11703	java/lang/Exception
    //   11231	11252	11726	java/lang/Exception
    //   11256	11316	11726	java/lang/Exception
    //   11316	11325	11726	java/lang/Exception
    //   11329	11350	11750	java/lang/Exception
    //   11835	11854	11888	java/lang/Exception
    //   11963	11997	11999	java/lang/Exception
    //   12039	12054	12056	java/lang/Exception
    //   12111	12121	12141	java/lang/Exception
    //   12183	12263	12763	java/lang/Exception
    //   12263	12276	12763	java/lang/Exception
    //   12281	12316	12763	java/lang/Exception
    //   12316	12374	12763	java/lang/Exception
    //   12374	12408	12763	java/lang/Exception
    //   12408	12433	12763	java/lang/Exception
    //   12433	12458	12763	java/lang/Exception
    //   12458	12492	12763	java/lang/Exception
    //   12492	12519	12763	java/lang/Exception
    //   12519	12553	12763	java/lang/Exception
    //   12553	12577	12763	java/lang/Exception
    //   12577	12601	12763	java/lang/Exception
    //   12606	12630	12763	java/lang/Exception
    //   12630	12654	12763	java/lang/Exception
    //   12654	12688	12763	java/lang/Exception
    //   12688	12712	12763	java/lang/Exception
    //   12712	12746	12763	java/lang/Exception
    //   12746	12760	12763	java/lang/Exception
    //   12820	12866	12763	java/lang/Exception
    //   12905	12955	13012	java/lang/Exception
    //   12961	12990	13012	java/lang/Exception
    //   12995	13010	13012	java/lang/Exception
    //   13032	13048	13012	java/lang/Exception
    //   13105	13134	13136	java/lang/Exception
    //   13184	13286	13288	java/lang/Exception
    //   13794	13823	13825	java/lang/Exception
    //   14077	14106	14108	java/lang/Exception
    //   14216	14295	14387	java/lang/Exception
    //   14302	14312	14387	java/lang/Exception
    //   14317	14336	14387	java/lang/Exception
    //   14336	14364	14387	java/lang/Exception
    //   14371	14384	14387	java/lang/Exception
    //   14401	14414	14387	java/lang/Exception
    //   14438	14524	14526	java/lang/Exception
    //   14591	14617	14627	java/lang/Exception
    //   14617	14625	14627	java/lang/Exception
    //   14906	14958	14960	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   15111	15150	15299	java/lang/Exception
    //   15150	15296	15299	java/lang/Exception
    //   15395	15432	15434	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   15469	15493	15495	java/lang/Exception
    //   15554	15578	15580	java/lang/Exception
    //   15994	16135	16137	java/lang/Exception
    //   16198	16286	16288	java/lang/Exception
    //   16349	16399	16401	java/lang/Exception
    //   16497	16530	16532	java/lang/Exception
    //   16593	16638	16701	java/lang/Exception
    //   16644	16655	16701	java/lang/Exception
    //   16658	16699	16701	java/lang/Exception
    //   16740	16749	16701	java/lang/Exception
    //   16754	16765	16701	java/lang/Exception
    //   16765	16808	16701	java/lang/Exception
    //   16812	16829	16701	java/lang/Exception
    //   16754	16765	16811	java/lang/Throwable
    //   16863	16896	16898	java/lang/Exception
    //   17029	17081	17083	java/lang/Exception
    //   17116	17126	17083	java/lang/Exception
    //   17216	17267	17306	java/lang/Exception
    //   17267	17291	17306	java/lang/Exception
    //   17291	17304	17306	java/lang/Exception
    //   11075	11085	17352	java/lang/Throwable
    //   9519	9530	17357	java/lang/Throwable
    //   3475	3509	17361	java/lang/Exception
    //   3513	3547	17366	java/lang/Exception
  }
  
  private void b(long paramLong, byte[] paramArrayOfByte)
  {
    Object localObject1 = new submsgtype0x31.MsgBody();
    int i;
    long l1;
    ayav localayav;
    try
    {
      paramArrayOfByte = (submsgtype0x31.MsgBody)((submsgtype0x31.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = new HashMap();
        paramArrayOfByte.put("param_FailCode", "12017");
        paramArrayOfByte.put("fail_step", "msgbyod_null");
        paramArrayOfByte.put("fail_location", "MessageHandler");
        axrl.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      do
      {
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
            axrl.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
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
            axrl.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
            return;
          }
        } while (!String.valueOf(paramLong).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
        paramArrayOfByte = new ayaw();
        paramArrayOfByte.c = String.valueOf(l1);
        paramArrayOfByte.b = String.valueOf(l2);
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_FailCode", "12018");
        ((HashMap)localObject1).put("fail_step", "success_" + i);
        ((HashMap)localObject1).put("fail_location", "MessageHandler");
        axrl.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBPushNotifaction", true, 0L, 0L, (HashMap)localObject1, "");
        localObject1 = (ayao)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(62);
        if (i == 1)
        {
          ayao.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte)0, paramArrayOfByte.c);
          ayao.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte.c);
          paramArrayOfByte.a = 1;
          ((ayao)localObject1).a(paramArrayOfByte.c, 1);
          a(8004, true, paramArrayOfByte);
          return;
        }
      } while (i != 0);
      localObject1 = String.valueOf(l1);
      localayav = (ayav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61);
      paramArrayOfByte.a((String)localObject1);
      localayav.a(paramArrayOfByte);
      Object localObject2 = paramArrayOfByte.a();
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "decodeC2CMsgPush() hint is new,msg num=1, subUin=" + str);
          }
          i = 1 - this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 7000);
          if (i != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str, 7000, i);
          }
        }
      }
      boolean bool = false;
      localObject2 = ayao.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1);
      if (localObject2 != null) {
        bool = ((Boolean)((Pair)localObject2).second).booleanValue();
      }
      if (!bool) {
        break label783;
      }
    }
    localayav.a((String)localObject1, 1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSubAccountKey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), String.valueOf(l1), new akqh(this, localayav));
    for (;;)
    {
      paramArrayOfByte.a = 0;
      a(8004, true, paramArrayOfByte);
      return;
      label783:
      if (localayav.a(String.valueOf(l1), 2))
      {
        i = 1 - this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1, 7000);
        if (i != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c((String)localObject1, 7000, i);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new String[] { ajsf.x, localObject1 });
        }
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "decodeC2CMsgPush() hint need to verify,msg num=1, subUin=" + (String)localObject1);
        }
      }
    }
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
            break label395;
          }
          i = localGroupVisitorJoinMsg.uint32_op_flag.get();
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageProcessor", 2, "handleEnterOpenTroopHotChatPushMsg. groupCode=" + l + ", name=" + (String)localObject + ", op_flag=" + i);
          }
          if (paramInt != 11) {
            break label400;
          }
          paramArrayOfByte = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131693299);
        }
      }
      for (;;)
      {
        akoj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l), paramArrayOfByte, 1, false, true);
        return;
        label395:
        i = 0;
        break;
        label400:
        paramArrayOfByte = (byte[])localObject;
        if (paramInt == 13) {
          if (1 == i) {
            paramArrayOfByte = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131693321);
          } else {
            paramArrayOfByte = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131693303);
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
  
  private boolean c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
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
  
  private void g(byte[] paramArrayOfByte)
  {
    Object localObject = new submsgtype0x116.MsgBody();
    try
    {
      ((submsgtype0x116.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      long l1 = ldz.a(((submsgtype0x116.MsgBody)localObject).uint32_group_id.get());
      long l2 = ldz.a(((submsgtype0x116.MsgBody)localObject).uint32_room_id.get());
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
          localObject = new StringBuilder(ajyc.a(2131707839));
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
  
  private void i(byte[] paramArrayOfByte)
  {
    long l = bbmj.a(paramArrayOfByte, 0);
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
                  ajyk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693316), true);
                  ajyu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 6);
                  ((ajyi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).notifyUI(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED });
                  return;
                } while (localHotChatInfo == null);
                localHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT);
                ajyk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693292), true);
                ajyu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 6);
                ((ajyi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).notifyUI(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT });
                return;
              } while (localHotChatInfo == null);
              localHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT);
              ajyk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693293), true);
              ajyu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 6);
              ((ajyi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).notifyUI(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT });
              return;
              if (j != 2) {
                break;
              }
            } while (localHotChatInfo == null);
            localHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT__LONG_TIME_NOT_SAY);
            ajyk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693291), false);
            ajyu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 6);
            ((ajyi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).notifyUI(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_LEFT__LONG_TIME_NOT_SAY });
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
        boolean bool = bldc.a(i);
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
        break label1307;
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
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (bbjw.c((String)localObject2)))
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
    label1307:
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
            Object localObject3 = aydc.a(paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get());
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (bbjw.c((String)localObject1)))
            {
              TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
              if (localTroopManager.b((String)localObject1) == null)
              {
                localObject2 = new TroopInfo();
                ((TroopInfo)localObject2).troopuin = ((String)localObject1);
                ((TroopInfo)localObject2).troopcode = ((String)localObject3);
                localTroopManager.a((TroopInfo)localObject2);
                localObject3 = (akhq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
                ((akhq)localObject3).a(((TroopInfo)localObject2).troopuin, false, "", true, true, true, false);
                ((akhq)localObject3).a(1, ajsz.a(((TroopInfo)localObject2).troopuin), 0L, 2, 0, 0, true);
                ((akhq)localObject3).notifyUI(6, true, new Object[] { Integer.valueOf(6), Byte.valueOf(0), localObject1 });
                ((akhq)localObject3).notifyUI(127, true, new Object[] { localObject1 });
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
          break label1261;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(4);
      }
      for (;;)
      {
        if ((paramArrayOfByte.msg_clean_count_msg.has()) && (paramArrayOfByte.msg_clean_count_msg.get() != null))
        {
          if (a(paramArrayOfByte.msg_clean_count_msg.uint32_processflag.get()))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(ajsf.W, 9000, 0 - aydb.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
            aydb.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
            ayda.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
            localObject1 = (akbo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(ajsf.M, 0, true, true);
            ((akbo)localObject1).b();
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
        label1261:
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
        awyz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localArrayList);
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
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80065A9", "0X80065A9", 0, 0, "", "", "", "");
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
      localIntent.putExtra(asen.b, (String)localObject1);
      localIntent.putExtra("activepull_push_flag", true);
      Object localObject2 = asen.jdField_a_of_type_JavaLangString;
      Object localObject3 = bawu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130840058);
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
      localToServiceMsg.extraData.putStringArray("cmds", new String[] { localObject1, localObject2, localObject1 });
      localToServiceMsg.extraData.putParcelable("intent", localIntent);
      localToServiceMsg.extraData.putParcelable("bitmap", (Parcelable)localObject3);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService(localToServiceMsg);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext();
      if (!bbio.a((Context)localObject1)) {
        break;
      }
      localObject2 = (asen)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(145);
      ((asen)localObject2).a(localIntent);
      localObject3 = (aseq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(72);
      if (SettingCloneUtil.readValue((Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ((Context)localObject1).getString(2131694019), "qqsetting_lock_screen_whenexit_key", true))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "handlePullActivePushMsg, start lsActivity");
        }
        ((aseq)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ajsf.aw, 9653, false, asem.a(paramMsgBody, 1008, localIntent));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((asen)localObject2).jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush);
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
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject1 = new SubMsgType0x27.MsgBody();
    ajxn localajxn;
    TroopManager localTroopManager;
    akdi localakdi;
    airz localairz;
    int j;
    Friends[] arrayOfFriends;
    do
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              try
              {
                paramArrayOfByte = (SubMsgType0x27.MsgBody)((SubMsgType0x27.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
                if (paramArrayOfByte == null) {
                  break;
                }
                localajxn = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                localakdi = (akdi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
                localairz = (airz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
                j = 0;
                paramArrayOfByte = paramArrayOfByte.rpt_msg_mod_infos.get();
                arrayOfFriends = new Friends[paramArrayOfByte.size()];
                new ArrayList();
                Iterator localIterator = paramArrayOfByte.iterator();
                if (!localIterator.hasNext()) {
                  break label7785;
                }
                paramArrayOfByte = (SubMsgType0x27.ForwardBody)localIterator.next();
                if ((paramArrayOfByte.uint32_notify_type.has()) && (paramArrayOfByte.uint32_notify_type.get() == 1))
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("cardpush", 2, "push a no content，如何处理？");
                  continue;
                }
                if (!paramArrayOfByte.uint32_op_type.has()) {
                  continue;
                }
              }
              catch (Exception paramArrayOfByte)
              {
                paramArrayOfByte.printStackTrace();
                return;
              }
              switch (paramArrayOfByte.uint32_op_type.get())
              {
              case 60: 
              case 61: 
              case 202: 
              default: 
                break;
              case 0: 
                if (paramArrayOfByte.msg_add_group.has())
                {
                  localObject1 = (SubMsgType0x27.AddGroup)paramArrayOfByte.msg_add_group.get();
                  paramArrayOfByte = new Groups();
                  if (((SubMsgType0x27.AddGroup)localObject1).uint32_groupid.has()) {
                    paramArrayOfByte.group_id = ((SubMsgType0x27.AddGroup)localObject1).uint32_groupid.get();
                  }
                  if (((SubMsgType0x27.AddGroup)localObject1).bytes_groupname.has()) {
                    paramArrayOfByte.group_name = ((SubMsgType0x27.AddGroup)localObject1).bytes_groupname.get().toStringUtf8();
                  }
                  if (((SubMsgType0x27.AddGroup)localObject1).uint32_sortid.has()) {
                    paramArrayOfByte.seqid = ((byte)((SubMsgType0x27.AddGroup)localObject1).uint32_sortid.get());
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("cardpush", 2, "push a AddGroup  = id:" + paramArrayOfByte.group_id + " name : " + paramArrayOfByte.group_name + " sortid: " + paramArrayOfByte.seqid);
                  }
                  localajxn.a(paramArrayOfByte);
                  localObject1 = new AddGroupResp();
                  ((AddGroupResp)localObject1).dwToUin = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).longValue();
                  ((AddGroupResp)localObject1).dwSequence = paramArrayOfByte.seqid;
                  ((AddGroupResp)localObject1).cGroupId = ((byte)paramArrayOfByte.group_id);
                  ((AddGroupResp)localObject1).cSortId = paramArrayOfByte.seqid;
                  paramArrayOfByte = new GroupActionResp(0, "", (AddGroupResp)localObject1);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(18, true, paramArrayOfByte);
                }
                break;
              case 1: 
                if (paramArrayOfByte.msg_del_group.has())
                {
                  localObject1 = (SubMsgType0x27.DelGroup)paramArrayOfByte.msg_del_group.get();
                  if (((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.has())
                  {
                    localObject2 = localajxn.a(((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get() + "");
                    if (QLog.isColorLevel()) {
                      QLog.d("cardpush", 2, "push a DelGroup  = id:" + ((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get());
                    }
                    paramArrayOfByte = new DelGroupResp();
                    paramArrayOfByte.dwToUin = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).longValue();
                    paramArrayOfByte.dwSequence = ((Groups)localObject2).seqid;
                    paramArrayOfByte.cGroupid = ((byte)((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get());
                    localObject1 = new GroupActionResp(0, "", paramArrayOfByte);
                    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(paramArrayOfByte, true, (GroupActionResp)localObject1);
                  }
                }
                break;
              }
            }
          } while (!paramArrayOfByte.msg_mod_group_name.has());
          localObject1 = (SubMsgType0x27.ModGroupName)paramArrayOfByte.msg_mod_group_name.get();
        } while ((!((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.has()) || (!((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.has()));
        i = ((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get();
        localObject2 = ((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8();
        paramArrayOfByte = localajxn.a(String.valueOf(i));
        if (paramArrayOfByte != null) {}
        for (paramArrayOfByte.group_name = ((String)localObject2);; paramArrayOfByte.group_name = ((String)localObject2))
        {
          localajxn.a(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModGroupName  = id:" + ((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get() + " name:" + ((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8());
          }
          paramArrayOfByte = new RenameGroupResp();
          paramArrayOfByte.dwToUin = ((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get();
          i = (byte)((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get();
          paramArrayOfByte.sGroupName = new String(((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8());
          paramArrayOfByte = new GroupActionResp(0, "", paramArrayOfByte);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(19, true, paramArrayOfByte);
          break;
          paramArrayOfByte = new Groups();
          paramArrayOfByte.group_id = i;
        }
      } while (!paramArrayOfByte.msg_mod_group_sort.has());
      localObject2 = ((SubMsgType0x27.ModGroupSort)paramArrayOfByte.msg_mod_group_sort.get()).rpt_msg_groupsort.get();
    } while (localObject2 == null);
    paramArrayOfByte = new byte[((List)localObject2).size()];
    localObject1 = new byte[((List)localObject2).size()];
    Object localObject2 = ((List)localObject2).iterator();
    int i = 0;
    label1208:
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localObject4 = (SubMsgType0x27.GroupSort)((Iterator)localObject2).next();
      if ((!((SubMsgType0x27.GroupSort)localObject4).uint32_groupid.has()) || (!((SubMsgType0x27.GroupSort)localObject4).uint32_sortid.has())) {
        break label7813;
      }
      paramArrayOfByte[i] = ((byte)((SubMsgType0x27.GroupSort)localObject4).uint32_groupid.get());
      localObject1[i] = ((byte)((SubMsgType0x27.GroupSort)localObject4).uint32_sortid.get());
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "push a ModGroupSort  = id:" + ((SubMsgType0x27.GroupSort)localObject4).uint32_groupid.get() + " sortid:" + ((SubMsgType0x27.GroupSort)localObject4).uint32_sortid.get());
      }
      i += 1;
    }
    label1408:
    label7813:
    for (;;)
    {
      break label1208;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(22, true, null);
      localajxn.a(paramArrayOfByte, (byte[])localObject1);
      break;
      if (!paramArrayOfByte.msg_mod_friend_group.has()) {
        break;
      }
      paramArrayOfByte = ((SubMsgType0x27.ModFriendGroup)paramArrayOfByte.msg_mod_friend_group.get()).rpt_msg_frd_group.get();
      if (paramArrayOfByte == null) {
        break;
      }
      paramArrayOfByte = paramArrayOfByte.iterator();
      do
      {
        if (!paramArrayOfByte.hasNext()) {
          break;
        }
        localObject1 = (SubMsgType0x27.FriendGroup)paramArrayOfByte.next();
      } while ((!((SubMsgType0x27.FriendGroup)localObject1).uint64_fuin.has()) || (((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_new_group_id.get().size() <= 0));
      long l1 = ((SubMsgType0x27.FriendGroup)localObject1).uint64_fuin.get();
      int k = ((Integer)((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_new_group_id.get(0)).intValue();
      if (((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_old_group_id.get().size() > 0) {}
      for (i = ((Integer)((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_old_group_id.get(0)).intValue();; i = 0)
      {
        localajxn.a(l1 + "", k);
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModFriendGroup  = id:" + l1 + " newgroupid:" + k);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(9, true, new Object[] { l1 + "", Byte.valueOf((byte)k), Byte.valueOf((byte)i) });
        break label1408;
        if (!paramArrayOfByte.msg_del_friend.has()) {
          break;
        }
        localObject1 = ((SubMsgType0x27.DelFriend)paramArrayOfByte.msg_del_friend.get()).rpt_uint64_uins.get();
        paramArrayOfByte = (ssu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(253);
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label2070;
          }
          l1 = ((Long)((Iterator)localObject1).next()).longValue();
          localajxn.d(l1 + "");
          localakdi.b(l1 + "");
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a DelFriend  = id:" + l1);
          }
          try
          {
            localObject2 = (bdto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165);
            if ((localObject2 != null) && (((bdto)localObject2).a(l1 + "")))
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(String.valueOf(l1), true);
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getBaseContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_customer_transfer_sharepreference", 0).edit();
              ((SharedPreferences.Editor)localObject2).putBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + l1 + "", false);
              ((SharedPreferences.Editor)localObject2).commit();
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a DelFriend  = id:" + l1 + " error :" + localException2.toString());
              }
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(15, true, Long.valueOf(l1));
          localObject2 = String.valueOf(l1);
          paramArrayOfByte.a((String)localObject2);
          akny.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2);
        }
        label2070:
        paramArrayOfByte = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
        if (paramArrayOfByte == null) {
          break;
        }
        paramArrayOfByte.b();
        break;
        Object localObject6;
        Object localObject7;
        if (paramArrayOfByte.msg_mod_friend_rings.has())
        {
          localObject1 = ((SubMsgType0x27.ModSnsGeneralInfo)paramArrayOfByte.msg_mod_friend_rings.get()).rpt_msg_sns_general_infos.get().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (SubMsgType0x27.SnsUpateBuffer)((Iterator)localObject1).next();
            localObject4 = ((SubMsgType0x27.SnsUpateBuffer)localObject3).rpt_msg_sns_update_item.get().iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject6 = (SubMsgType0x27.SnsUpdateItem)((Iterator)localObject4).next();
              i = ((SubMsgType0x27.SnsUpdateItem)localObject6).uint32_update_sns_type.get();
              if ((i == 13569) && (((SubMsgType0x27.SnsUpateBuffer)localObject3).uint32_result.get() == 0))
              {
                localObject5 = localTroopManager.b(Long.valueOf(((SubMsgType0x27.SnsUpateBuffer)localObject3).uint64_uin.get()).toString());
                i = ((SubMsgType0x27.SnsUpdateItem)localObject6).bytes_value.get().size();
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 4, "ONLine push commonTroop troopUin=" + (String)localObject5 + " status=" + i);
                }
                if (i == 0)
                {
                  if (localTroopManager.c((String)localObject5)) {
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22).notifyUI(18, true, new Object[] { localObject5, Integer.valueOf(1), Integer.valueOf(0), null });
                  }
                }
                else if (i >= 4)
                {
                  localObject6 = ((SubMsgType0x27.SnsUpdateItem)localObject6).bytes_value.get().toByteArray();
                  localObject7 = new byte[4];
                  System.arraycopy(localObject6, 0, localObject7, 0, 4);
                  if (localTroopManager.a((String)localObject5, akau.a((byte[])localObject7))) {
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22).notifyUI(18, true, new Object[] { localObject5, Integer.valueOf(0), Integer.valueOf(0), null });
                  }
                }
              }
              else if (i == 13571)
              {
                l1 = ((SubMsgType0x27.SnsUpateBuffer)localObject3).uint64_uin.get();
                l2 = ((SubMsgType0x27.SnsUpateBuffer)localObject3).uint64_code.get();
                Long.valueOf(l1).toString();
                localObject5 = String.valueOf(Long.valueOf(l2));
                i = ((SubMsgType0x27.SnsUpdateItem)localObject6).bytes_value.get().size();
                localObject6 = ((SubMsgType0x27.SnsUpdateItem)localObject6).bytes_value.get().toByteArray();
                if (i >= 6)
                {
                  if ((localObject6[0] != 1) || (localObject6[0] == 0)) {}
                  i = localObject6[1];
                  if (i == 1)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.BaseMessageProcessor", 2, "onlinePush, oprerate external show troop...");
                    }
                    localObject7 = new byte[4];
                    System.arraycopy(localObject6, 2, localObject7, 0, 4);
                    if (localTroopManager.b((String)localObject5, akau.a((byte[])localObject7))) {
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20).notifyUI(54, true, new Object[] { localObject5, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i) });
                    }
                  }
                  if ((i == 0) && (localTroopManager.e((String)localObject5))) {
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20).notifyUI(54, true, new Object[] { localObject5, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i) });
                  }
                }
              }
            }
          }
        }
        if (!paramArrayOfByte.msg_mod_friend_rings.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.ModSnsGeneralInfo)paramArrayOfByte.msg_mod_friend_rings.get();
        if ((paramArrayOfByte == null) || (!paramArrayOfByte.rpt_msg_sns_general_infos.has())) {
          break;
        }
        paramArrayOfByte = paramArrayOfByte.rpt_msg_sns_general_infos.get();
        Object localObject3 = new HashMap();
        localObject4 = paramArrayOfByte.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          paramArrayOfByte = (SubMsgType0x27.SnsUpateBuffer)((Iterator)localObject4).next();
          if ((paramArrayOfByte != null) && (paramArrayOfByte.uint64_uin.has()) && (paramArrayOfByte.rpt_msg_sns_update_item.has()))
          {
            l1 = paramArrayOfByte.uint64_uin.get();
            localObject5 = String.valueOf(l1);
            localObject6 = paramArrayOfByte.rpt_msg_sns_update_item.get().iterator();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (SubMsgType0x27.SnsUpdateItem)((Iterator)localObject6).next();
              if ((localObject7 != null) && (((SubMsgType0x27.SnsUpdateItem)localObject7).uint32_update_sns_type.has()) && (((SubMsgType0x27.SnsUpdateItem)localObject7).bytes_value.has()) && (!FriendsStatusUtil.a((SubMsgType0x27.SnsUpdateItem)localObject7, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject5)))
              {
                if (((SubMsgType0x27.SnsUpdateItem)localObject7).uint32_update_sns_type.get() == 13568) {
                  aijb.a((String)localObject5, ((SubMsgType0x27.SnsUpdateItem)localObject7).bytes_value.get().toStringUtf8(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                }
                localObject1 = (SpecialCareInfo)((HashMap)localObject3).get(localObject5);
                paramArrayOfByte = (byte[])localObject1;
                if (localObject1 == null)
                {
                  localObject1 = localajxn.a(String.valueOf(l1));
                  paramArrayOfByte = (byte[])localObject1;
                  if (localObject1 == null)
                  {
                    paramArrayOfByte = new SpecialCareInfo();
                    paramArrayOfByte.uin = String.valueOf(String.valueOf(l1));
                  }
                  ((HashMap)localObject3).put(paramArrayOfByte.uin, paramArrayOfByte);
                }
                i = ((SubMsgType0x27.SnsUpdateItem)localObject7).uint32_update_sns_type.get();
                localObject1 = ((SubMsgType0x27.SnsUpdateItem)localObject7).bytes_value.get().toStringUtf8();
                FriendListHandler.a(paramArrayOfByte, i, (String)localObject1);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x27 uin=" + paramArrayOfByte.uin + ", itemtype=" + i + ",itemVal=" + (String)localObject1);
                }
              }
            }
          }
        }
        paramArrayOfByte = ((HashMap)localObject3).entrySet().iterator();
        localObject1 = new ArrayList();
        while (paramArrayOfByte.hasNext())
        {
          localObject3 = (SpecialCareInfo)((Map.Entry)paramArrayOfByte.next()).getValue();
          if ((localObject3 != null) && ((((SpecialCareInfo)localObject3).getStatus() != 1000) || (((SpecialCareInfo)localObject3).globalSwitch != 0))) {
            ((List)localObject1).add(localObject3);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x27 bulkSaveOrUpdateSpecialCareInfos=" + ((List)localObject1).size());
        }
        localajxn.c((List)localObject1);
        if (((List)localObject1).size() <= 0) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(99, true, new Object[] { Boolean.valueOf(true), localObject1 });
        break;
        if (!paramArrayOfByte.msg_mod_friend_flag.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.SnsUpdateFlag)paramArrayOfByte.msg_mod_friend_flag.get();
        if (!paramArrayOfByte.rpt_msg_update_sns_flag.has()) {
          break;
        }
        paramArrayOfByte = paramArrayOfByte.rpt_msg_update_sns_flag.get().iterator();
        do
        {
          do
          {
            if (!paramArrayOfByte.hasNext()) {
              break;
            }
            localObject1 = (SubMsgType0x27.SnsUpdateOneFlag)paramArrayOfByte.next();
            l1 = ((SubMsgType0x27.SnsUpdateOneFlag)localObject1).uint64__uin.get();
            i = ((SubMsgType0x27.SnsUpdateOneFlag)localObject1).uint32_flag.get();
            l2 = ((SubMsgType0x27.SnsUpdateOneFlag)localObject1).uint64_id.get();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "FriendShield : onLinePush : uin : " + l1 + " flag:" + i + " id:" + l2);
            }
          } while (l2 != 4051L);
          localObject1 = localajxn.e(String.valueOf(l1));
        } while (localObject1 == null);
        if (i == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ((Friends)localObject1).setShieldFlag(bool);
          localajxn.a((Friends)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(56, true, new Object[] { Long.valueOf(l1), Boolean.valueOf(bool), Boolean.valueOf(true), Boolean.valueOf(true), "" });
          break;
        }
        if (!paramArrayOfByte.msg_mod_profile.has()) {
          break;
        }
        j = a(paramArrayOfByte, localajxn, localTroopManager, null, localairz, arrayOfFriends, j);
        break;
        if (!paramArrayOfByte.msg_mod_custom_face.has()) {
          break;
        }
        localObject1 = (SubMsgType0x27.ModCustomFace)paramArrayOfByte.msg_mod_custom_face.get();
        if ((!((SubMsgType0x27.ModCustomFace)localObject1).uint32_type.has()) || (!((SubMsgType0x27.ModCustomFace)localObject1).uint64_uin.has())) {
          break;
        }
        paramArrayOfByte = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        if (((SubMsgType0x27.ModCustomFace)localObject1).uint32_type.get() == 0)
        {
          l1 = ((SubMsgType0x27.ModCustomFace)localObject1).uint64_uin.get();
          localObject1 = Long.toString(l1);
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModCustomFace  :0  Normal user uin = " + l1);
          }
          paramArrayOfByte.c((String)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(3, true, localObject1);
          break;
        }
        if (((SubMsgType0x27.ModCustomFace)localObject1).uint32_type.get() != 1) {
          break;
        }
        l1 = ((SubMsgType0x27.ModCustomFace)localObject1).uint64_group_code.get();
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModCustomFace  :1 Troop uin = " + l1);
        }
        localObject1 = localTroopManager.b(String.valueOf(l1));
        ((TroopInfo)localObject1).hasSetNewTroopHead = true;
        localTroopManager.b((TroopInfo)localObject1);
        paramArrayOfByte.d(Long.toString(l1));
        break;
        if (!paramArrayOfByte.msg_daren_notify.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.DaRenNotify)paramArrayOfByte.msg_daren_notify.get();
        l1 = paramArrayOfByte.uint64_uin.get();
        i = paramArrayOfByte.uint32_login_days.get();
        k = paramArrayOfByte.uint32_days.get();
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l1)))
        {
          paramArrayOfByte = localajxn.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          if ((i != paramArrayOfByte.lLoginDays) || (k != paramArrayOfByte.lQQMasterLogindays))
          {
            paramArrayOfByte.lLoginDays = i;
            paramArrayOfByte.lQQMasterLogindays = k;
            localajxn.a(paramArrayOfByte);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(1, true, paramArrayOfByte);
          }
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "daren notify received local data logindays=" + paramArrayOfByte.lLoginDays + ";days=" + paramArrayOfByte.lQQMasterLogindays);
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("cardpush", 2, "daren notify received uin=" + l1 + ";logindays=" + i + ";days=" + k);
        break;
        if (!paramArrayOfByte.msg_mod_friend_remark.has()) {
          break;
        }
        localObject1 = ((SubMsgType0x27.ModFriendRemark)paramArrayOfByte.msg_mod_friend_remark.get()).rpt_msg_frd_rmk.get().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (SubMsgType0x27.FriendRemark)((Iterator)localObject1).next();
          if (((SubMsgType0x27.FriendRemark)localObject3).uint32_type.has()) {
            if (((SubMsgType0x27.FriendRemark)localObject3).uint32_type.get() == 0)
            {
              l1 = ((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get();
              localObject4 = localajxn.e(Long.toString(l1));
              paramArrayOfByte = null;
              if (localObject4 != null) {
                paramArrayOfByte = ((Friends)localObject4).remark;
              }
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModFriendRemark  : 0 Friend uin = " + ((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + "备注 = " + ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8() + ",oldRemark = " + paramArrayOfByte);
              }
              localajxn.b(((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + "", ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8());
              localObject5 = localajxn.b(((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + "");
              localObject6 = ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8();
              if ((localObject5 != null) && (!((String)localObject6).equals(((Card)localObject5).strReMark)))
              {
                ((Card)localObject5).strReMark = ((String)localObject6);
                localajxn.a((Card)localObject5);
              }
              if ((localObject4 != null) && (((Friends)localObject4).isFriend()) && (aket.b((String)localObject6, paramArrayOfByte))) {
                aket.b(l1, (String)localObject6, (ajvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53));
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(3, true, Long.toString(((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get()));
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(27, true, new Object[] { ((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + "", ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8(), Byte.valueOf(1) });
              TroopNameHelper.b(Long.toString(l1));
            }
            else if (((SubMsgType0x27.FriendRemark)localObject3).uint32_type.get() == 1)
            {
              if (((SubMsgType0x27.FriendRemark)localObject3).uint64_group_code.has())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModFriendRemark  : 1 troop remarkuin = " + ((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + " troopcode = " + ((SubMsgType0x27.FriendRemark)localObject3).uint64_group_code.get() + " remark = " + ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8() + "目前群备注在android上没看到有地方显示？");
                }
              }
              else if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModFriendRemark  : 1 troop remark uin = " + ((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + " remark = " + ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8() + "目前群备注在android上没看到有地方显示？");
              }
            }
          }
        }
        if (!paramArrayOfByte.msg_mod_rich_long_nick_ex.has()) {
          break;
        }
        Object localObject5 = (SubMsgType0x27.ModLongNick)paramArrayOfByte.msg_mod_rich_long_nick_ex.get();
        localObject3 = Long.toString(((SubMsgType0x27.ModLongNick)localObject5).uint64_uin.get());
        paramArrayOfByte = ByteBuffer.wrap(((SubMsgType0x27.ModLongNick)localObject5).bytes_value.get().toByteArray());
        l1 = paramArrayOfByte.getLong();
        localObject4 = new byte[paramArrayOfByte.remaining()];
        paramArrayOfByte.get((byte[])localObject4);
        localObject1 = localajxn.a((String)localObject3);
        paramArrayOfByte = (byte[])localObject1;
        if (localObject1 == null)
        {
          paramArrayOfByte = new ExtensionInfo();
          paramArrayOfByte.uin = ((String)localObject3);
        }
        paramArrayOfByte.setRichBuffer((byte[])localObject4, l1);
        paramArrayOfByte.isAdded2C2C = SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, paramArrayOfByte.getRichStatus());
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "insertSignMsgIfNeeded from OnLinePush uin = " + (String)localObject3 + " result =  " + paramArrayOfByte.isAdded2C2C);
        }
        localajxn.a(paramArrayOfByte);
        paramArrayOfByte = localajxn.b(((SubMsgType0x27.ModLongNick)localObject5).uint64_uin.get() + "");
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.vRichSign = ((byte[])localObject4);
          paramArrayOfByte.lSignModifyTime = l1;
          localajxn.a(paramArrayOfByte);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(3, true, localObject3);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(2, true, new String[] { localObject3 });
        break;
        if (!paramArrayOfByte.msg_mod_group_profile.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.ModGroupProfile)paramArrayOfByte.msg_mod_group_profile.get();
        paramArrayOfByte.uint64_cmd_uin.get();
        if (!paramArrayOfByte.uint64_group_code.has()) {
          break;
        }
        l1 = paramArrayOfByte.uint64_group_uin.get();
        long l2 = paramArrayOfByte.uint64_group_code.get();
        for (;;)
        {
          try
          {
            paramArrayOfByte = paramArrayOfByte.rpt_msg_group_profile_infos.get().iterator();
            if (!paramArrayOfByte.hasNext()) {
              break;
            }
            localObject1 = (SubMsgType0x27.GroupProfileInfo)paramArrayOfByte.next();
            if ((!((SubMsgType0x27.GroupProfileInfo)localObject1).uint32_field.has()) || (!((SubMsgType0x27.GroupProfileInfo)localObject1).bytes_value.has())) {
              continue;
            }
            if (((SubMsgType0x27.GroupProfileInfo)localObject1).uint32_field.get() == 1)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("cardpush", 2, "push a ModGroupProfile 1--TroopName  = " + ((SubMsgType0x27.GroupProfileInfo)localObject1).bytes_value.get().toStringUtf8());
              continue;
            }
          }
          catch (Exception paramArrayOfByte)
          {
            paramArrayOfByte.printStackTrace();
          }
          if (((SubMsgType0x27.GroupProfileInfo)localObject1).uint32_field.get() == 2)
          {
            localObject1 = ((SubMsgType0x27.GroupProfileInfo)localObject1).bytes_value.get();
            if ((localObject1 != null) && (((ByteStringMicro)localObject1).size() == 2))
            {
              i = ((ByteStringMicro)localObject1).byteAt(0);
              short s = (short)(((ByteStringMicro)localObject1).byteAt(1) | i << 8);
              localObject1 = localTroopManager.b(l1 + "");
              ((TroopInfo)localObject1).troopface = s;
              ((TroopInfo)localObject1).hasSetNewTroopHead = true;
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupProfile 2--TroopHead(2bytes) = " + s);
              }
              localTroopManager.b((TroopInfo)localObject1);
              ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).d(l1 + "");
            }
          }
          else if (((SubMsgType0x27.GroupProfileInfo)localObject1).uint32_field.get() == 3)
          {
            localObject1 = ((SubMsgType0x27.GroupProfileInfo)localObject1).bytes_value.get().toStringUtf8();
            if (QLog.isColorLevel()) {
              QLog.i("troop.credit.data", 2, "onLinePush, creditLevelChange:" + l1 + "," + l2 + "," + (String)localObject1);
            }
            localObject3 = localTroopManager.b(l2 + "");
            if (localObject3 != null)
            {
              ((TroopInfo)localObject3).troopCreditLevel = Long.valueOf((String)localObject1).longValue();
              localTroopManager.b((TroopInfo)localObject3);
              if (QLog.isColorLevel()) {
                QLog.i("troop.credit.data", 2, "onLinePush, creditLevelChange, save");
              }
            }
          }
        }
        if (!paramArrayOfByte.msg_mod_group_member_profile.has()) {
          break;
        }
        localObject1 = (SubMsgType0x27.ModGroupMemberProfile)paramArrayOfByte.msg_mod_group_member_profile.get();
        if ((!((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_code.has()) || (!((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_uin.has())) {
          break;
        }
        l1 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_uin.get();
        l2 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_code.get();
        long l3 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_uin.get();
        paramArrayOfByte = bbcp.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l2 + "", l3 + "");
        localObject1 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).rpt_msg_group_member_profile_infos.get().iterator();
        label5913:
        label6462:
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (SubMsgType0x27.GroupMemberProfileInfo)((Iterator)localObject1).next();
          if ((((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.has()) && (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.has()))
          {
            if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.get() != 1) {
              break label5913;
            }
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModGroupMemberProfile 1--Nick = " + ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toStringUtf8() + " info.bytes_value.get().size() = " + ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().size());
            }
            aket.a("cardpush", ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toByteArray(), ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().size());
            if (paramArrayOfByte != null)
            {
              paramArrayOfByte.colorNick = bboe.a(((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get());
              paramArrayOfByte.name = bboe.b(paramArrayOfByte.colorNick);
              localTroopManager.a(l1 + "", l3 + "", paramArrayOfByte.colorNick, -100, null, null, -100, -100, -100, -100L, -100L);
            }
          }
          for (;;)
          {
            if (paramArrayOfByte == null) {
              break label6462;
            }
            bbcp.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte);
            localObject3 = new ArrayList();
            ((ArrayList)localObject3).add(paramArrayOfByte);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20).notifyUI(16, true, localObject3);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20).notifyUI(11, true, new Object[] { localObject3, Boolean.valueOf(true) });
            break;
            if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.get() == 2)
            {
              if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().size() == 1)
              {
                byte b = ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().byteAt(0);
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModGroupMemberProfile 2--sex = " + b);
                }
                localTroopManager.a(l1 + "", l3 + "", null, -100, null, null, -100, b, -100, -100L, -100L);
                if (paramArrayOfByte != null) {
                  paramArrayOfByte.sex = b;
                }
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.get() == 3)
            {
              localObject3 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 3--phone = " + (String)localObject3);
              }
              if (paramArrayOfByte != null) {
                paramArrayOfByte.tel = ((String)localObject3);
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.get() == 4)
            {
              localObject3 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 4--email= " + (String)localObject3);
              }
              if (paramArrayOfByte != null) {
                paramArrayOfByte.email = ((String)localObject3);
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.get() == 5)
            {
              localObject3 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 5--remark= " + (String)localObject3);
              }
              ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(l1 + "", l3 + "", null, -100, null, (String)localObject3, -100, -100, -100, -100L, -100L);
              if (paramArrayOfByte != null) {
                paramArrayOfByte.memo = ((String)localObject3);
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.get() == 6)
            {
              localObject3 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 6--job= " + (String)localObject3);
              }
              if (paramArrayOfByte != null) {
                paramArrayOfByte.job = ((String)localObject3);
              }
            }
            else if ((((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.get() == 7) && (paramArrayOfByte != null))
            {
              paramArrayOfByte.colorNick = bboe.a(((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get());
              paramArrayOfByte.name = bboe.b(paramArrayOfByte.colorNick);
            }
          }
        }
        if (!paramArrayOfByte.msg_appointment_notify.has()) {
          break;
        }
        localObject5 = (SubMsgType0x27.AppointmentNotify)paramArrayOfByte.msg_appointment_notify.get();
        if (!((SubMsgType0x27.AppointmentNotify)localObject5).uint32_notifytype.has()) {
          break;
        }
        l1 = ((SubMsgType0x27.AppointmentNotify)localObject5).uint32_notifytype.get();
        if ((l1 == 2L) || (l1 == 4L) || (l1 == 5L) || ((l1 == 6L) && (((SubMsgType0x27.AppointmentNotify)localObject5).bytes_feed_event_info.has())))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((SubMsgType0x27.AppointmentNotify)localObject5);
          break;
        }
        if (((l1 != 0L) && (l1 != 1L) && (l1 != 3L)) || (!((SubMsgType0x27.AppointmentNotify)localObject5).uint64_from_uin.has())) {
          break;
        }
        l2 = ((SubMsgType0x27.AppointmentNotify)localObject5).uint64_from_uin.get();
        localObject1 = null;
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject4 = Long.toString(l2);
        if (l1 == 0L) {}
        for (paramArrayOfByte = (byte[])localObject3;; paramArrayOfByte = (byte[])localObject4)
        {
          if (((SubMsgType0x27.AppointmentNotify)localObject5).str_tips_content.has()) {
            localObject1 = ((SubMsgType0x27.AppointmentNotify)localObject5).str_tips_content.get();
          }
          localObject5 = new ArrayList();
          localObject6 = axaq.a(-1024);
          l2 = awzw.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "handle date push friendUin=" + (String)localObject4 + ",senderUin=" + paramArrayOfByte + ",notifytype=" + l1);
          }
          ((MessageRecord)localObject6).init((String)localObject3, (String)localObject4, paramArrayOfByte, (String)localObject1, l2, -1024, 1010, l2);
          ((MessageRecord)localObject6).isread = false;
          if (l1 == 0L)
          {
            ((MessageRecord)localObject6).issend = 1;
            ((MessageRecord)localObject6).isread = true;
          }
          ((ArrayList)localObject5).add(localObject6);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject6, ((MessageRecord)localObject6).selfuin);
          a("handleMsgType0x210SubMsgType0x27", true, (List)localObject5, false, false);
          break;
          if ((l1 == 1L) && (((SubMsgType0x27.AppointmentNotify)localObject5).bytes_sig.has()))
          {
            paramArrayOfByte = ((SubMsgType0x27.AppointmentNotify)localObject5).bytes_sig.get().toByteArray();
            if (paramArrayOfByte != null) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().l((String)localObject4, paramArrayOfByte);
            }
          }
        }
        if (!paramArrayOfByte.bytes_redpoint_info.has()) {
          break;
        }
        ((atxb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160)).a(paramArrayOfByte.bytes_redpoint_info.get().toByteArray());
        break;
        if (!paramArrayOfByte.msg_push_search_dev.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.PushSearchDev)paramArrayOfByte.msg_push_search_dev.get();
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("optype", 200);
        if (paramArrayOfByte.uint32_msg_type.has()) {
          ((Bundle)localObject1).putInt("msgtype", paramArrayOfByte.uint32_msg_type.get());
        }
        if (paramArrayOfByte.uint32_dev_time.has()) {
          ((Bundle)localObject1).putInt("devtime", paramArrayOfByte.uint32_dev_time.get());
        }
        if (paramArrayOfByte.uint64_din.has()) {
          ((Bundle)localObject1).putLong("din", paramArrayOfByte.uint64_din.get());
        }
        if (paramArrayOfByte.str_data.has()) {
          ((Bundle)localObject1).putString("data", paramArrayOfByte.str_data.get());
        }
        ((yak)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(39, (Bundle)localObject1);
        break;
        if (!paramArrayOfByte.msg_push_report_dev.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.PushReportDev)paramArrayOfByte.msg_push_report_dev.get();
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("optype", 201);
        if (paramArrayOfByte.uint32_msg_type.has()) {
          ((Bundle)localObject1).putInt("msgtype", paramArrayOfByte.uint32_msg_type.get());
        }
        if (paramArrayOfByte.bytes_cookie.has()) {
          ((Bundle)localObject1).putString("cookie", paramArrayOfByte.bytes_cookie.get().toStringUtf8());
        }
        if (paramArrayOfByte.uint32_report_max_num.has()) {
          ((Bundle)localObject1).putInt("count", paramArrayOfByte.uint32_report_max_num.get());
        }
        if (paramArrayOfByte.bytes_sn.has()) {
          ((Bundle)localObject1).putString("sn", paramArrayOfByte.bytes_sn.get().toStringUtf8());
        }
        ((yak)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(39, (Bundle)localObject1);
        break;
        if (!paramArrayOfByte.msg_new_comein_user_notify.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.NewComeinUserNotify)paramArrayOfByte.msg_new_comein_user_notify.get();
        if (paramArrayOfByte.uint32_msg_type.has()) {}
        for (i = paramArrayOfByte.uint32_msg_type.get();; i = -1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "receive msg0x210submsg0x27 face2face add friend push, type:" + i);
          }
          if (i == 1)
          {
            localObject1 = (ajzl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(3);
            if (localObject1 == null) {
              break;
            }
            ((ajzl)localObject1).a(paramArrayOfByte);
            break;
          }
          if ((i != 2) && (i != 3)) {
            break;
          }
          localObject1 = (akbg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(57);
          if (localObject1 == null) {
            break;
          }
          ((akbg)localObject1).a(i, paramArrayOfByte);
          break;
          paramArrayOfByte = (SubMsgType0x27.PraiseRankNotify)paramArrayOfByte.msg_praise_rank_notify.get();
          if (paramArrayOfByte.str_msg.has()) {}
          for (paramArrayOfByte = paramArrayOfByte.str_msg.get();; paramArrayOfByte = null)
          {
            for (;;)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "praise rank notify: " + paramArrayOfByte);
                }
                if (TextUtils.isEmpty(paramArrayOfByte)) {
                  break;
                }
                localObject1 = bawu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130840058);
                localObject3 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
                localObject4 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), LikeRankingListActivity.class);
                ((Intent)localObject4).putExtra("param_from", 1);
                ((Intent)localObject4).addFlags(67108864);
                ((ToServiceMsg)localObject3).extraData.putStringArray("cmds", new String[] { "QQ", "QQ", paramArrayOfByte });
                ((ToServiceMsg)localObject3).extraData.putParcelable("intent", (Parcelable)localObject4);
                ((ToServiceMsg)localObject3).extraData.putParcelable("bitmap", (Parcelable)localObject1);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService((ToServiceMsg)localObject3);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("dc00898", "0X8007618");
                break;
                try
                {
                  paramArrayOfByte = (SubMsgType0x27.MQQCampusNotify)paramArrayOfByte.msg_campus_notify.get();
                  if (paramArrayOfByte == null) {
                    break;
                  }
                  ((amgb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(240)).a(paramArrayOfByte);
                }
                catch (Exception paramArrayOfByte) {}
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("Q.msg.BaseMessageProcessor", 2, "deal SubMsgType0x27.MQQCampusNotify fail", paramArrayOfByte);
              break;
              try
              {
                for (;;)
                {
                  if ((SubMsgType0x27.ChatMatchInfo)paramArrayOfByte.msg_chat_match_info.get() != null) {
                    QLog.d("Q.msg.BaseMessageProcessorExtendFriendLimitChat", 2, "SubMsgType0x27.ChatMatchInfo");
                  }
                  try
                  {
                    paramArrayOfByte = (SubMsgType0x27.FrdCustomOnlineStatusChange)paramArrayOfByte.msg_frd_custom_online_status_change.get();
                    if (paramArrayOfByte == null) {
                      break;
                    }
                    bbpa.a(paramArrayOfByte);
                    QLog.d("Q.msg.BaseMessageProcessorCustomOnlineStatus", 2, "SubMsgType0x27.FrdCustomOnlineStatusChange");
                  }
                  catch (Exception paramArrayOfByte) {}
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.i("Q.msg.BaseMessageProcessor", 2, "deal SubMsgType0x27.FrdCustomOnlineStatusChange fail", paramArrayOfByte);
              }
              catch (Exception localException1)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("Q.msg.BaseMessageProcessor", 2, "deal SubMsgType0x27.ChatMatchInfo fail", localException1);
                  }
                }
              }
            }
            label7785:
            localajxn.a(arrayOfFriends, j);
            return;
          }
        }
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    ((ardg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(268)).a(paramArrayOfByte, paramInt);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt, MsgInfo paramMsgInfo)
  {
    ((ardg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(268)).a(paramArrayOfByte, paramInt, paramMsgInfo);
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
      paramArrayOfByte = (MessageForNearbyLiveTip)axaq.a(-2053);
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
        paramArrayOfByte.senderuin = String.valueOf(paramMsgInfo.lFromUin + ajsf.l);
        paramArrayOfByte.frienduin = String.valueOf(paramMsgInfo.lFromUin + ajsf.l);
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
      } while (akau.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte, true));
      paramMsgInfo.add(paramArrayOfByte);
      if (paramArrayOfByte.senderuin.equals(String.valueOf(1822701914L + ajsf.l))) {
        paramArrayOfByte.isLiving = true;
      }
      if (paramArrayOfByte.isLiving)
      {
        bool2 = akau.a(paramMsgInfo);
        int i = akpy.a(paramMsgInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if ((bool2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {}
        for (bool1 = true;; bool1 = false)
        {
          ((QQMessageFacade)localObject).a(paramMsgInfo, str, bool1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((int)paramArrayOfByte.time);
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
      bool1 = akau.a(paramMsgInfo);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (!bool1) {
        break label774;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop) {}
    label774:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((QQMessageFacade)localObject).a(paramMsgInfo, str, bool1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((int)paramArrayOfByte.time);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte, akqn paramakqn)
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
            asyj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (submsgtype0xc7.HotFriendNotify)localObject, paramakqn);
          }
          break;
        case 4000: 
          if (((submsgtype0xc7.ForwardBody)localObject).msg_relational_chain_change.has())
          {
            localObject = (submsgtype0xc7.RelationalChainChange)((submsgtype0xc7.ForwardBody)localObject).msg_relational_chain_change.get();
            if (((submsgtype0xc7.RelationalChainChange)localObject).uint64_appid.get() == 10001L) {
              asye.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (submsgtype0xc7.RelationalChainChange)localObject, paramakqn);
            } else if (((submsgtype0xc7.RelationalChainChange)localObject).uint64_appid.get() == 19999L) {
              asyn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (submsgtype0xc7.RelationalChainChange)localObject, paramakqn);
            } else if (((submsgtype0xc7.RelationalChainChange)localObject).uint64_appid.get() == 10002L) {
              acvw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (submsgtype0xc7.RelationalChainChange)localObject, paramakqn);
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
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26");
    }
    submsgtype0x26.MsgBody localMsgBody = new submsgtype0x26.MsgBody();
    do
    {
      do
      {
        do
        {
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
            int j = 0;
            long l2 = 0L;
            int i = j;
            long l1 = l2;
            Object localObject1;
            Object localObject2;
            if (localMsgBody.uint32_sub_cmd.get() == 1)
            {
              i = j;
              l1 = l2;
              if (localMsgBody.rpt_msg_subcmd_0x1_push_body.has())
              {
                localObject1 = localMsgBody.rpt_msg_subcmd_0x1_push_body.get();
                i = 0;
                j = 0;
                l1 = l2;
                while (j < ((List)localObject1).size())
                {
                  localObject2 = (submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)((List)localObject1).get(j);
                  if (((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject2).msg_app_id.uint64_app_id.get() == 101846662L)
                  {
                    l1 = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject2).uint64_group_code.get();
                    localObject2 = (baff)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(355);
                    if (localObject2 != null) {
                      ((baff)localObject2).a(l1);
                    }
                    i = 1;
                  }
                  j += 1;
                }
              }
            }
            int k = i;
            l2 = l1;
            if (localMsgBody.uint32_sub_cmd.get() == 1)
            {
              k = i;
              l2 = l1;
              if (localMsgBody.rpt_msg_subcmd_0x1_push_body.has())
              {
                localObject1 = localMsgBody.rpt_msg_subcmd_0x1_push_body.get();
                j = 0;
                for (;;)
                {
                  k = i;
                  l2 = l1;
                  if (j >= ((List)localObject1).size()) {
                    break;
                  }
                  localObject2 = (submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)((List)localObject1).get(j);
                  l1 = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject2).uint64_group_code.get();
                  l2 = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject2).msg_app_id.uint64_app_id.get();
                  i = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject2).sint32_unread_num.get();
                  localObject2 = (baff)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(355);
                  if (localObject2 != null) {
                    ((baff)localObject2).b(l1, l2, i);
                  }
                  i = 1;
                  j += 1;
                }
              }
            }
            if ((k != 0) && (l2 != 0L))
            {
              localObject1 = (bafd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(171);
              if (localObject1 != null) {
                ((bafd)localObject1).notifyUI(6, true, new Object[] { Long.valueOf(l2) });
              }
            }
            if ((localMsgBody.uint32_sub_cmd.get() == 1) || (localMsgBody.uint32_sub_cmd.get() == 4))
            {
              ((akhq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(paramArrayOfByte);
              return;
            }
          } while (localMsgBody.uint32_sub_cmd.get() != 3);
          if ((!localMsgBody.msg_subcmd_0x3_push_body.has()) && (QLog.isColorLevel())) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : msg has not 0x3_push_body");
          }
          paramArrayOfByte = (submsgtype0x26.MsgBody.SubCmd0x3UpdateDiscussAppInfo)localMsgBody.msg_subcmd_0x3_push_body.get();
        } while ((!paramArrayOfByte.uint64_conf_uin.has()) || (!paramArrayOfByte.msg_app_tip_notify.has()));
        paramArrayOfByte.uint64_conf_uin.get();
        paramArrayOfByte = (submsgtype0x26.AppTipNotify)paramArrayOfByte.msg_app_tip_notify.get();
      } while (!paramArrayOfByte.bytes_text.has());
      paramArrayOfByte = paramArrayOfByte.bytes_text.get().toByteArray();
    } while (paramArrayOfByte.length <= 0);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramArrayOfByte);
  }
  
  public void b(byte[] paramArrayOfByte, long paramLong)
  {
    ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).a(paramArrayOfByte, paramLong);
  }
  
  public void c(byte[] paramArrayOfByte)
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
  
  public void d(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x83");
    }
    Object localObject1 = new SubMsgType0x83.MsgBody();
    do
    {
      try
      {
        ((SubMsgType0x83.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
        if (!((SubMsgType0x83.MsgBody)localObject1).uint64_group_id.has())
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
    } while (!((SubMsgType0x83.MsgBody)localObject1).rpt_msg_params.has());
    paramArrayOfByte = ((SubMsgType0x83.MsgBody)localObject1).rpt_msg_params;
    long l1 = -1L;
    if (((SubMsgType0x83.MsgBody)localObject1).uint64_seq.has()) {
      l1 = ((SubMsgType0x83.MsgBody)localObject1).uint64_seq.get();
    }
    long l2 = -1L;
    if (((SubMsgType0x83.MsgBody)localObject1).uint64_group_id.has()) {
      l2 = ((SubMsgType0x83.MsgBody)localObject1).uint64_group_id.get();
    }
    int i = 0;
    label149:
    if (i < paramArrayOfByte.size())
    {
      localObject1 = (SubMsgType0x83.MsgParams)paramArrayOfByte.get(i);
      if ((localObject1 != null) && (((SubMsgType0x83.MsgParams)localObject1).uint32_type.has())) {
        break label190;
      }
    }
    label190:
    int j;
    label443:
    do
    {
      for (;;)
      {
        i += 1;
        break label149;
        break;
        j = ((SubMsgType0x83.MsgParams)localObject1).uint32_type.get();
        Object localObject3;
        int k;
        if ((j >= 2001) && (j <= 3000))
        {
          if ((((SubMsgType0x83.MsgParams)localObject1).str_data.has()) && (((SubMsgType0x83.MsgParams)localObject1).uint64_from_uin.has()) && (((SubMsgType0x83.MsgParams)localObject1).uint64_to_uin.has()))
          {
            localObject3 = ((SubMsgType0x83.MsgParams)localObject1).str_data.get();
            try
            {
              k = new JSONObject((String)localObject3).getInt("count");
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(j, ((SubMsgType0x83.MsgParams)localObject1).uint64_from_uin.get(), ((SubMsgType0x83.MsgParams)localObject1).uint64_to_uin.get(), k, l1, l2);
            }
            catch (Exception localException1) {}
          }
        }
        else
        {
          if (j != 1005) {
            break label443;
          }
          if ((localException1.str_data.has()) && (localException1.uint64_from_uin.has()) && (localException1.uint64_to_uin.has()))
          {
            localObject3 = localException1.str_data.get();
            try
            {
              localObject3 = new JSONObject((String)localObject3);
              j = ((JSONObject)localObject3).optInt("enable");
              k = ((JSONObject)localObject3).optInt("level");
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localException1.uint32_type.get(), localException1.uint64_from_uin.get(), localException1.uint64_to_uin.get(), j, k, l1, l2);
            }
            catch (Exception localException2) {}
          }
        }
      }
    } while ((j != 1010) || (!localException2.bytes_data.has()));
    Object localObject2 = new String(localException2.bytes_data.get().toByteArray());
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        if (((JSONObject)localObject2).getInt("sndRank") == 0) {
          break label544;
        }
        j = 1;
        boolean bool = ((JSONObject)localObject2).getBoolean("rank_changed");
        if ((j == 0) || (!bool)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l2);
      }
      catch (Exception localException3) {}
      break;
      label544:
      j = 0;
    }
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().i(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akqf
 * JD-Core Version:    0.7.0.1
 */