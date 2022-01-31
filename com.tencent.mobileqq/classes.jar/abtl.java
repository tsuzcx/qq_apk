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
import com.tencent.imcore.message.QQMessageFacade;
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
import tencent.im.oidb.submsgtype0x136.Submsgtype0x136.MsgBody;
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

public class abtl
  extends absm
{
  public abtl(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private int a(SubMsgType0x27.ForwardBody paramForwardBody, alto paramalto, TroopManager paramTroopManager, Object paramObject, aknx paramaknx, Friends[] paramArrayOfFriends, int paramInt)
  {
    paramForwardBody = (SubMsgType0x27.ModProfile)paramForwardBody.msg_mod_profile.get();
    int n = paramInt;
    long l2;
    int m;
    int k;
    int i1;
    int i2;
    label705:
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
            localObject = paramalto.e(Long.toString(l2));
            paramForwardBody = null;
            if (localObject != null) {
              paramForwardBody = ((Friends)localObject).name;
            }
            paramArrayOfFriends[i1] = paramalto.a(l2 + "", paramTroopManager);
            if ((localObject != null) && (((Friends)localObject).isFriend()) && (amax.a(paramTroopManager, paramForwardBody))) {
              amax.a(l2, paramTroopManager, (alrk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53));
            }
            paramForwardBody = paramalto.b(l2 + "");
            if (paramForwardBody != null)
            {
              paramForwardBody.strNick = paramTroopManager;
              paramalto.a(paramForwardBody);
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
              paramTroopManager = (alpk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
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
      break label705;
      paramForwardBody = paramForwardBody.bytes_value.get();
      if ((paramForwardBody != null) && (paramForwardBody.size() == 2))
      {
        n = paramForwardBody.byteAt(0);
        n = (short)(paramForwardBody.byteAt(1) | n << 8);
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModProfile Head = " + n);
        }
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).c(Long.toString(l2));
        paramForwardBody = paramalto.b(l2 + "");
        if (paramForwardBody != null)
        {
          paramForwardBody.nFaceID = n;
          paramalto.a(paramForwardBody);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(4, true, new Object[] { l2 + "", paramForwardBody, null });
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(1, true, paramForwardBody);
        }
      }
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      i2 = paramForwardBody.bytes_value.get().byteAt(0);
      if (i2 == 1) {
        n = 0;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModProfile Sex = " + n);
        }
        paramForwardBody = paramalto.b(l2 + "");
        if (paramForwardBody != null)
        {
          paramForwardBody.shGender = ((short)n);
          paramalto.a(paramForwardBody);
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
      ((amca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).notifyUI(101, true, Integer.valueOf(i2));
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("vip", 2, "bubble id = " + i2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, "vip update uin=" + l2);
      }
      paramForwardBody = paramForwardBody.bytes_value.get();
      paramTroopManager = paramalto.e(Long.toString(l2));
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
        label1680:
        paramTroopManager.qqVipInfo = (n << 24 | 0xFFFFFF & i2);
        i2 = paramTroopManager.superQqInfo;
        if ((paramForwardBody.byteAt(0) & 0x8) != 0) {
          break label2147;
        }
        n = 0;
        label1716:
        paramTroopManager.superQqInfo = (n << 24 | 0xFFFFFF & i2);
        if ((paramForwardBody.byteAt(0) & 0x40) == 0) {
          break label2153;
        }
        bool1 = true;
        label1746:
        if (QLog.isColorLevel()) {
          QLog.d("vip", 2, "is year vip =" + bool1);
        }
        if (!bool1) {
          break label2159;
        }
        n = 65536;
        label1790:
        if (!paramTroopManager.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
          break label2165;
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
        paramalto.a(paramTroopManager);
        ((amca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).notifyUI(100, true, null);
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
          paramForwardBody = (alrp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
          paramForwardBody.a(0, 0);
          paramForwardBody.a(0, 0, 1, 0);
          if (QLog.isColorLevel()) {
            QLog.d("QVipSettingMe.", 2, "[vipInfoPush] 23105 request vipInfoHandler");
          }
          beat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "last_pull_pay_rule", 0L);
          paramForwardBody = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          ((amfs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(27)).a(paramForwardBody, l2 + "");
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        n = 1;
        break label1680;
        label2147:
        n = 1;
        break label1716;
        label2153:
        bool1 = false;
        break label1746;
        label2159:
        n = 0;
        break label1790;
        label2165:
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
      localObject = paramalto.e(paramTroopManager);
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
        label2424:
        n = i4;
        if (i3 < 4)
        {
          if ((j & i2) != 0) {
            n = 13 - i3;
          }
        }
        else
        {
          label2449:
          if (QLog.isColorLevel()) {
            QLog.d("vip", 2, String.format("[%02X%02X] => LV %d", new Object[] { Byte.valueOf(i), Byte.valueOf(j), Integer.valueOf(n) }));
          }
          if (!bool1) {
            break label2680;
          }
          ((Friends)localObject).superVipInfo = (((Friends)localObject).superVipInfo & 0xFFFF0000 | 0xFFFF & n);
        }
      }
      for (;;)
      {
        if (bool4) {
          ((Friends)localObject).bigClubInfo = (n & 0xFFFF | ((Friends)localObject).bigClubInfo & 0xFFFF0000);
        }
        paramalto.a((Friends)localObject);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramTroopManager)) {
          ((amca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).notifyUI(100, true, null);
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        i3 += 1;
        i2 = (byte)(i2 << 1);
        break label2424;
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
        break label2449;
        label2680:
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
      localObject = paramalto.e(paramTroopManager);
      n = k;
      if (localObject == null) {
        break;
      }
      localObject = (Friends)((Friends)localObject).clone();
      if ((paramForwardBody.byteAt(5) & 0x20) != 0)
      {
        bool1 = true;
        label2826:
        i2 = ((Friends)localObject).superVipInfo;
        if (!bool1) {
          break label3009;
        }
      }
      label3009:
      for (n = 1;; n = 0)
      {
        ((Friends)localObject).superVipInfo = (n << 24 | 0xFFFFFF & i2);
        paramalto.a((Friends)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("vip", 2, "isSVip=" + bool1 + "friend.superVipInfo=" + ((Friends)localObject).superVipInfo);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramTroopManager))
        {
          ((amca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).notifyUI(100, true, null);
          if (QLog.isColorLevel()) {
            QLog.d("vip", 2, "[EmoticonUpdateAuth] 23107 updateEmoticonAuth");
          }
          paramForwardBody = (alrp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
          paramForwardBody.a(0, 0);
          paramForwardBody.a(0, 0, 1, 0);
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        bool1 = false;
        break label2826;
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
          break label3562;
        }
        n = 4;
        label3285:
        if (n != -1)
        {
          paramTroopManager.edit().putInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), n).commit();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(101, true, Integer.valueOf(n));
        }
      }
      if ((paramForwardBody.byteAt(12) & 0x8) != 0)
      {
        bool1 = true;
        label3370:
        baam.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool1);
        if ((paramForwardBody.byteAt(13) & 0x40) == 0) {
          break label3645;
        }
      }
      label3645:
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
        break label705;
        label3562:
        if ((paramForwardBody.byteAt(9) & 0x10) != 0)
        {
          n = 3;
          break label3285;
        }
        n = paramTroopManager.getInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
        if ((n == 4) || (n == 3))
        {
          n = 1;
          break label3285;
        }
        n = -1;
        break label3285;
        bool1 = false;
        break label3370;
      }
      long l1 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asLongBuffer().get();
      paramTroopManager = paramalto.a(String.valueOf(l2));
      paramForwardBody = paramTroopManager;
      if (paramTroopManager == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = String.valueOf(l2);
      }
      paramForwardBody.pendantId = l1;
      paramForwardBody.timestamp = System.currentTimeMillis();
      paramalto.a(paramForwardBody);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Pendant, uin=" + l2 + ", id=" + paramForwardBody.pendantId);
      }
      paramForwardBody = new HashSet(1);
      paramForwardBody.add(String.valueOf(l2));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(66, true, paramForwardBody);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      paramInt = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramTroopManager = paramalto.a(String.valueOf(l2));
      paramForwardBody = paramTroopManager;
      if (paramTroopManager == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = String.valueOf(l2);
      }
      if ((paramForwardBody.uVipFont != fx.a(paramInt)) || (paramForwardBody.vipFontType != fx.b(paramInt)))
      {
        paramForwardBody.uVipFont = fx.a(paramInt);
        paramForwardBody.vipFontType = fx.b(paramInt);
        paramForwardBody.timestamp = System.currentTimeMillis();
        paramalto.a(paramForwardBody);
        bdom.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Font, uin=" + l2 + ", id=" + paramForwardBody.uVipFont + ", type = " + paramForwardBody.vipFontType);
      }
      n = (int)fx.a(paramInt);
      paramInt = m;
      m = n;
      break label705;
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramTroopManager = paramalto.a(String.valueOf(l2));
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
        paramalto.a(paramForwardBody);
        bdom.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push Get MagicFont uin = " + l2 + ", magicFont = " + i2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramTroopManager = paramalto.a(String.valueOf(l2));
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
        ((fx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).e();
        n = 1;
      }
      if (n != 0) {
        paramalto.a(paramForwardBody);
      }
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push Get fontEffect uin = " + l2 + ", fontEffect = " + i2 + ", updateTime = " + paramForwardBody.fontEffectLastUpdateTime);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      k = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      n = k;
      if (k == 0) {
        break;
      }
      n = 1;
      m = paramInt;
      paramInt = n;
      break label705;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramTroopManager = paramalto.a(String.valueOf(l2));
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
        paramalto.a(paramForwardBody);
        bdse.a(paramForwardBody.uin, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get ColorRing, uin=" + l2 + ", id=" + paramForwardBody.colorRingId);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      paramTroopManager = paramForwardBody.bytes_value.get();
      n = paramForwardBody.uint32_field.get();
      if ((n >= 42005) && (n <= 42012))
      {
        ByteBuffer.wrap(paramTroopManager.toByteArray()).asShortBuffer().get();
        n = paramInt;
        paramInt = m;
        m = n;
        break label705;
      }
      ByteBuffer.wrap(paramTroopManager.toByteArray()).asIntBuffer().get();
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramForwardBody = paramaknx.b(String.valueOf(l2));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "apollo push uin: " + l2 + ", avip flag: " + i2);
      }
      n = k;
      if (paramForwardBody.apolloVipFlag == i2) {
        break;
      }
      paramForwardBody.apolloVipFlag = i2;
      paramaknx.a(paramForwardBody);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramForwardBody = paramaknx.b(String.valueOf(l2));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "apollo push uin: " + l2 + ", avip level: " + i2);
      }
      n = k;
      if (paramForwardBody.apolloVipLevel == i2) {
        break;
      }
      paramForwardBody.apolloVipLevel = i2;
      paramaknx.a(paramForwardBody);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramForwardBody = paramaknx.b(String.valueOf(l2));
      if ((QLog.isColorLevel()) || (l2 == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())) {
        QLog.d("Q.msg.BaseMessageProcessor", 1, "apollo push uin: " + l2 + ", apollo status: " + n);
      }
      if (paramForwardBody.apolloStatus != n)
      {
        paramForwardBody.apolloStatus = n;
        paramaknx.a(paramForwardBody);
        if ((l2 == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) && (paramForwardBody.isApolloStatusOpen()) && (paramForwardBody.apolloLocalTS != paramForwardBody.apolloServerTS))
        {
          paramForwardBody = (bdug)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
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
        break label705;
      }
      paramForwardBody = new ArrayList();
      paramForwardBody.add(paramTroopManager);
      paramTroopManager = albi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramTroopManager != null) {
        paramTroopManager.a(n, paramForwardBody);
      }
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramForwardBody = String.valueOf(l2);
      if (TextUtils.isEmpty(paramForwardBody))
      {
        n = paramInt;
        paramInt = m;
        m = n;
        break label705;
      }
      paramTroopManager = paramaknx.b(paramForwardBody);
      if (paramForwardBody.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) {
        ((bdug)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(new long[] { l2 });
      }
      QLog.d("Q.msg.BaseMessageProcessor", 1, new Object[] { "apollo push uin: " + new StringBuilder().append(l2).append("temp").toString().substring(0, 4) + ", timeStamp: " + n, ", local server:", Long.valueOf(paramTroopManager.apolloServerTS) });
      if (paramTroopManager.apolloServerTS != n)
      {
        paramTroopManager.apolloServerTS = n;
        paramaknx.a(paramTroopManager);
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
      if ((!paramForwardBody.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) || (aknx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 2))
      {
        n = k;
        if (i2 == 0) {
          break;
        }
      }
      paramForwardBody = (bdug)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
      paramTroopManager = new ArrayList();
      paramTroopManager.add(Long.valueOf(l2));
      paramForwardBody.a(paramTroopManager, "online_push");
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      n = k;
      if (l2 != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) {
        break;
      }
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      if (n != aknx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        paramForwardBody = (aknx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
        paramForwardBody.b(n);
        if (n == 1)
        {
          paramForwardBody = paramForwardBody.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          if ((paramForwardBody.isApolloStatusOpen()) && (paramForwardBody.apolloLocalTS != paramForwardBody.apolloServerTS))
          {
            paramForwardBody = (bdug)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
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
      break label705;
      l1 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramForwardBody = paramaknx.b(String.valueOf(l2));
      long l3 = NetConnInfoCenter.getServerTime();
      if ((l1 > l3) && (paramForwardBody.apolloSignValidTS != l1))
      {
        paramForwardBody.apolloLocalSignTs = paramForwardBody.apolloSignValidTS;
        paramForwardBody.apolloSignValidTS = l1;
        paramForwardBody.apolloSignStr = "";
        paramaknx.a(paramForwardBody);
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo push sign uin: " + l2 + ", valid TS: " + l1 + ", currTS: " + l3);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      if (paramaknx != null)
      {
        paramForwardBody = paramaknx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        if ((paramForwardBody != null) && (n != paramForwardBody.apolloAISwitch))
        {
          paramForwardBody.apolloAISwitch = n;
          if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (String.valueOf(l2).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))) {
            paramaknx.a(n, 2);
          }
          paramaknx.a(paramForwardBody);
        }
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo aiSwitch  push: " + n);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {}
      for (i2 = paramForwardBody[0];; i2 = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        localObject = String.valueOf(l2);
        paramForwardBody = paramaknx.b((String)localObject);
        QLog.d("Q.msg.BaseMessageProcessor", 1, new Object[] { "cmshow_online_push,  uin: ", ApolloUtil.d((String)localObject), ", cmshow3dFlag: ", Integer.valueOf(i2), ", local=", Integer.valueOf(paramForwardBody.cmshow3dFlag) });
        if (paramForwardBody.cmshow3dFlag != i2)
        {
          n = paramForwardBody.cmshow3dFlag;
          paramForwardBody.cmshow3dFlag = i2;
          paramaknx.a(paramForwardBody);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l2))) {
            paramaknx.c(n, i2);
          }
          paramTroopManager = new ArrayList();
          paramTroopManager.add(localObject);
          localObject = albi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (localObject != null) {
            ((albf)localObject).a(3, paramTroopManager);
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
        paramaknx.a("" + l2, aknx.a);
        n = paramInt;
        paramInt = m;
        m = n;
        break label705;
      }
      l1 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramForwardBody = paramalto.b(l2 + "");
      paramTroopManager = paramalto.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        paramForwardBody.namePlateOfKingGameId = l1;
        paramalto.a(paramForwardBody);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(1, true, paramForwardBody);
      }
      if (paramTroopManager != null)
      {
        paramTroopManager.namePlateOfKingGameId = l1;
        paramalto.a(paramTroopManager);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(3, true, Long.toString(l2));
      }
      QLog.i("namePlateOfKing", 1, "handle push gameId = " + l1 + ", uin = " + l2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      l1 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramForwardBody = paramalto.b(l2 + "");
      paramTroopManager = paramalto.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        paramForwardBody.namePlateOfKingLoginTime = l1;
        paramalto.a(paramForwardBody);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(1, true, paramForwardBody);
      }
      if (paramTroopManager != null)
      {
        paramTroopManager.namePlateOfKingLoginTime = l1;
        paramalto.a(paramTroopManager);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(3, true, Long.toString(l2));
      }
      QLog.i("namePlateOfKing", 1, "handle push gameLoginTime = " + l1 + ", uin = " + l2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramForwardBody = paramalto.b(l2 + "");
      paramTroopManager = paramalto.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        paramForwardBody.namePlateOfKingDan = n;
        paramalto.a(paramForwardBody);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(1, true, paramForwardBody);
      }
      if (paramTroopManager != null)
      {
        paramTroopManager.namePlateOfKingDan = n;
        paramalto.a(paramTroopManager);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(3, true, Long.toString(l2));
      }
      QLog.i("namePlateOfKing", 1, "handle push namePlateOfKingDan = " + n + ", uin = " + l2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramForwardBody = paramalto.b(l2 + "");
      paramTroopManager = paramalto.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        if (n == 1)
        {
          bool1 = true;
          label6861:
          paramForwardBody.namePlateOfKingDanDisplatSwitch = bool1;
          paramalto.a(paramForwardBody);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(1, true, paramForwardBody);
        }
      }
      else if (paramTroopManager != null) {
        if (n != 1) {
          break label6989;
        }
      }
      label6989:
      for (bool1 = true;; bool1 = false)
      {
        paramTroopManager.namePlateOfKingDanDisplatSwitch = bool1;
        paramalto.a(paramTroopManager);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(3, true, Long.toString(l2));
        QLog.i("namePlateOfKing", 1, "handle push namePlateOfKingDanDisplatSwitch = " + n + ", uin = " + l2);
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        bool1 = false;
        break label6861;
      }
      paramForwardBody = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(l2 + "");
      ((amfs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(27)).a(paramForwardBody, l2 + "");
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
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
      paramForwardBody = paramalto.b(l2 + "");
      paramTroopManager = paramalto.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        paramForwardBody.nameplateVipType = n;
        paramalto.a(paramForwardBody);
      }
      if (paramTroopManager != null)
      {
        paramTroopManager.nameplateVipType = n;
        paramalto.a(paramTroopManager);
      }
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
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
      paramForwardBody = paramalto.b(l2 + "");
      paramTroopManager = paramalto.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        paramForwardBody.grayNameplateFlag = n;
        paramalto.a(paramForwardBody);
      }
      if (paramTroopManager != null)
      {
        paramTroopManager.grayNameplateFlag = n;
        paramalto.a(paramTroopManager);
      }
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {}
      for (n = paramForwardBody[0];; n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push the big club level change=" + n);
        }
        paramForwardBody = paramalto.b(l2 + "");
        paramTroopManager = paramalto.e(Long.toString(l2));
        if (paramForwardBody != null)
        {
          paramForwardBody.iBigClubVipLevel = n;
          paramalto.a(paramForwardBody);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(1, true, paramForwardBody);
        }
        if (paramTroopManager != null)
        {
          paramTroopManager.bigClubInfo = (n & 0xFFFF | paramTroopManager.bigClubInfo & 0xFFFF0000);
          paramalto.a(paramTroopManager);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(3, true, Long.toString(l2));
        }
        paramForwardBody = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(l2 + "");
        ((amfs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(27)).a(paramForwardBody, l2 + "");
        n = paramInt;
        paramInt = m;
        m = n;
        break;
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {}
      for (n = paramForwardBody[0];; n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        paramForwardBody = paramalto.b(l2 + "");
        paramTroopManager = paramalto.e(Long.toString(l2));
        if (paramForwardBody != null)
        {
          paramForwardBody.iBigClubVipType = n;
          paramalto.a(paramForwardBody);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(1, true, paramForwardBody);
        }
        if (paramTroopManager != null)
        {
          paramTroopManager.bigClubInfo = (paramTroopManager.bigClubInfo & 0xFFFFFF | (n & 0xFF) << 24);
          paramalto.a(paramTroopManager);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(3, true, Long.toString(l2));
        }
        if (QLog.isColorLevel()) {
          QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push the big club type change=" + n);
        }
        paramForwardBody = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(l2 + "");
        ((amfs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(27)).a(paramForwardBody, l2 + "");
        n = paramInt;
        paramInt = m;
        m = n;
        break;
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {}
      for (n = paramForwardBody[0];; n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        paramForwardBody = paramalto.b(l2 + "");
        paramTroopManager = paramalto.e(Long.toString(l2));
        if (paramForwardBody != null)
        {
          paramForwardBody.lBigClubTemplateId = n;
          paramForwardBody.lSuperVipTemplateId = n;
          paramalto.a(paramForwardBody);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(1, true, paramForwardBody);
        }
        if (paramTroopManager != null)
        {
          paramTroopManager.superVipTemplateId = n;
          paramTroopManager.bigClubTemplateId = n;
          paramalto.a(paramTroopManager);
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
        paramForwardBody = paramalto.e(Long.toString(l2));
        if (paramForwardBody != null)
        {
          paramForwardBody.bigClubInfo = ((n & 0xFF) << 16 | paramForwardBody.bigClubInfo & 0xFF00FFFF);
          paramalto.a(paramForwardBody);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(3, true, Long.toString(l2));
        }
        paramForwardBody = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(l2 + "");
        ((amfs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(27)).a(paramForwardBody, l2 + "");
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
        paramForwardBody = paramalto.b(l2 + "");
        if ((paramForwardBody != null) && (paramForwardBody.mQQLevelType != n))
        {
          paramForwardBody.mQQLevelType = n;
          paramalto.a(paramForwardBody);
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
        paramForwardBody = paramalto.e(Long.toString(l2));
        if (paramForwardBody != null)
        {
          paramForwardBody.cNewLoverDiamondFlag = n;
          paramalto.a(paramForwardBody);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(3, true, Long.toString(l2));
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
      }
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramTroopManager = paramalto.a(String.valueOf(l2));
      paramForwardBody = paramTroopManager;
      if (paramTroopManager == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = String.valueOf(l2);
      }
      paramForwardBody.pendantDiyId = n;
      paramForwardBody.timestamp = System.currentTimeMillis();
      paramalto.a(paramForwardBody);
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get PendantDiyId, uin=" + l2 + ", id=" + paramForwardBody.pendantDiyId);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      ((bduj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(235)).a.b(Long.toString(l2), n);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get faceId, uin=" + l2 + ", id=" + n);
      }
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramTroopManager = (BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44);
      label8884:
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
          break label9094;
        }
        if (paramTroopManager[0] != 1) {
          break label9088;
        }
        bool1 = true;
        label8963:
        paramTroopManager = (auad)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(303);
        s = (short)paramForwardBody.uint32_field.get();
        if (bool1) {
          break label9120;
        }
      }
      label9088:
      label9094:
      label9120:
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
        break label8884;
        bool1 = false;
        break label8963;
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
        paramForwardBody = awer.a(n);
        paramTroopManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
        l3 = aweo.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      if ((!bool1) && (banm.a(String.valueOf(i2)))) {
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
        break label705;
        baos.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(i2), "20000000");
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
      break label705;
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      bdvy.b(i2);
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, " theme font online push " + paramForwardBody.uint32_field.get() + " id:" + i2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {
        if (paramForwardBody[0] == 0) {
          bool1 = true;
        }
      }
      for (;;)
      {
        agyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(bool1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(104, true, Boolean.valueOf(bool1));
        n = k;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.msg.BaseMessageProcessor", 2, "handleModProfileBranch emotionRec flag:" + bool1);
        n = paramInt;
        paramInt = m;
        m = n;
        break label705;
        bool1 = false;
        continue;
        if (ByteBuffer.wrap(paramForwardBody).asShortBuffer().get() == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      label9998:
      SharedPreferences.Editor localEditor;
      if (paramForwardBody.length > 1) {
        if (paramForwardBody[1] == 1)
        {
          bool1 = true;
          QLog.e("vip_ptt.Q.msg.BaseMessageProcessor", 1, "it have receive push value:" + bool1);
          bool2 = bool1;
          if (bool1)
          {
            paramForwardBody = (aopr)aoks.a().a(442);
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
            break label10273;
          }
          localEditor.putLong((String)localObject, l1);
          paramForwardBody.edit().putBoolean(str, true);
          label10234:
          localEditor.commit();
          afxv.d = bool2;
          afxv.a = l1;
        }
      }
      for (;;)
      {
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        bool1 = false;
        break label9998;
        label10273:
        localEditor.putLong((String)localObject, 9223372036854775807L);
        break label10234;
        QLog.e("vip_ptt.Q.msg.BaseMessageProcessor", 1, "it have receive push value is null");
        paramForwardBody = (alpk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
        paramTroopManager = new ArrayList();
        paramTroopManager.add(Short.valueOf((short)-23249));
        paramForwardBody.a(paramTroopManager, null);
      }
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "handleModProfileBranch: invoked. c2c online push, field id: 27370, changed global ring id", " ringId: ", Integer.valueOf(n) });
      }
      aobk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(n);
      n = paramInt;
      paramInt = m;
      m = n;
      break label705;
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "handleModProfileBranch: invoked. c2c online push, field id: 42360, changed troopHonorSwitch", " troopHonorSwitch: ", Integer.valueOf(i2) });
      }
      paramForwardBody = paramalto.b(l2 + "");
      n = k;
      if (paramForwardBody == null) {
        break;
      }
      bool2 = paramForwardBody.troopHonorSwitch;
      if (i2 == 0)
      {
        bool1 = true;
        label10531:
        if (bool2 != bool1) {
          if (i2 != 0) {
            break label10619;
          }
        }
      }
      label10619:
      for (bool1 = true;; bool1 = false)
      {
        paramForwardBody.troopHonorSwitch = bool1;
        paramalto.a(paramForwardBody);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).notifyUI(113, true, Boolean.valueOf(paramForwardBody.troopHonorSwitch));
        ((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).notifyUI(80, true, null);
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        bool1 = false;
        break label10531;
      }
      n = i1;
      if (m != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "Onlinepush hasDiyFontTimestamp: uin = " + l2 + " fontid = " + paramInt + " timestamp = " + k);
        }
        paramalto = paramalto.a(String.valueOf(l2));
        paramForwardBody = paramalto;
        if (paramalto == null)
        {
          paramForwardBody = new ExtensionInfo();
          paramForwardBody.uin = String.valueOf(l2);
        }
        m = paramInt;
        if (paramInt == 0) {
          m = (int)paramForwardBody.uVipFont;
        }
        fx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l2), paramForwardBody, m, k);
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
    bdqa.a(paramMsgInfo, 0);
    int i = paramMsgInfo[4];
    bdqa.a(paramMsgInfo, 5);
    bdqa.a(paramMsgInfo, 9);
    bdqa.a(paramMsgInfo, 13);
    i = paramMsgInfo[17];
    bdqa.a(paramMsgInfo, 18);
    bdqa.a(paramMsgInfo, 22);
    bdqa.a(paramMsgInfo, 24);
    return null;
  }
  
  private void a(int paramInt)
  {
    ((amca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramInt);
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
      bddb.a(true);
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
        ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(localMsgInfo.lFromUin);
        paramToServiceMsg.lFromUin = localMsgInfo.lFromUin;
        paramToServiceMsg.shMsgSeq = localMsgInfo.shMsgSeq;
        paramToServiceMsg.uMsgTime = localMsgInfo.uMsgTime;
        paramToServiceMsg.vMsgCookies = localMsgInfo.vMsgCookies;
        localArrayList3.add(paramToServiceMsg);
        if ((42 != j) && (83 != j) && (127 != j) && (QLog.isColorLevel())) {
          alww.a("Q.msg.BaseMessageProcessor", str1, localMsgInfo.shMsgSeq, String.valueOf(l3), String.valueOf(localMsgInfo.lFromUin));
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp  before analysis msgInfo.lFromUin: " + localMsgInfo.lFromUin + " msgInfo.shMsgType: " + localMsgInfo.shMsgType + " msgInfo.uRealMsgTime: " + localMsgInfo.uRealMsgTime + " msgInfo.shMsgSeq: " + localMsgInfo.shMsgSeq + ", msgInfo.lMsgUid" + localMsgInfo.lMsgUid);
        }
        if (!amlf.a().containsKey(Integer.valueOf(j))) {
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
        QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp Exception msgInfo.vMsg: " + bdhe.a(localMsgInfo.vMsg));
        continue;
      }
      if (paramToServiceMsg != null)
      {
        localMessageRecord = azaf.a(i);
        if (j != 1006) {
          break label2065;
        }
        str2 = bdgc.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l2));
        localMessageRecord.init(String.valueOf(l3), bdgc.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1)), str2, paramToServiceMsg, localMsgInfo.uRealMsgTime, i, j, localMsgInfo.uMsgTime);
        localMessageRecord.shmsgseq = localMsgInfo.shMsgSeq;
        localMessageRecord.isread = bool1;
        localMessageRecord.msgUid = localMsgInfo.lMsgUid;
        localMessageRecord.msgData = ((byte[])localObject);
        if (k > 0) {
          localMessageRecord.extraflag = k;
        }
        if (!alww.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, true)) {
          localArrayList1.add(localMessageRecord);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp after analysis friendUin: " + l1 + " msgType: " + i + " friendType: " + j + " shMsgSeq: " + localMsgInfo.shMsgSeq + " msgContent: " + bdeu.a(paramToServiceMsg));
        }
      }
      if (localMsgInfo.uAppShareID <= 0L) {
        break label153;
      }
      localArrayList4.add(bdff.a(localMsgInfo.uAppShareID));
      break label153;
      bddb.a(false);
      break;
      paramToServiceMsg = Long.valueOf(paramFromServiceMsg.getUin());
      continue;
      if (169 == j)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "------->msgFilter-handleC2COnlinePushMsgResp receive msg size:" + localArrayList2.size());
        }
        if (alww.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, String.valueOf(l1), String.valueOf(l2), localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq)) {
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
          bdqa.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, 4);
        }
        l2 = bdqa.a(paramToServiceMsg, 0);
        if (localMsgInfo.vMsg.length >= 9)
        {
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 9];
          bdqa.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 8, paramToServiceMsg.length);
          paramToServiceMsg = new String(azah.a(paramToServiceMsg), "utf-8");
          break label2280;
        }
      }
      else
      {
        if (132 == j)
        {
          paramToServiceMsg = new byte[4];
          if (localMsgInfo.vMsg.length > 4) {
            bdqa.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, 4);
          }
          l2 = bdqa.a(paramToServiceMsg, 0);
          paramToServiceMsg = (ToServiceMsg)localObject;
          if (localMsgInfo.vMsg.length < 9) {
            break label2302;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 9];
          bdqa.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 8, paramToServiceMsg.length);
          paramToServiceMsg = new String(azah.a(paramToServiceMsg), "utf-8");
          break label2302;
        }
        if (732 == j)
        {
          if (localMsgInfo.vMsg == null) {
            return;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length];
          bdqa.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, paramToServiceMsg.length);
          i = paramToServiceMsg[4];
          if (!QLog.isColorLevel()) {
            break label2325;
          }
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<---0x2dc push  groupCode:" + bdqa.a(localMsgInfo.vMsg, 0) + " subType:" + i + "msgSeq:" + localMsgInfo.shMsgSeq);
          break label2325;
          label1367:
          if (localMsgInfo.vMsg.length <= 7) {
            break label2349;
          }
          paramToServiceMsg = (bcpt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(81);
          localObject = new byte[localMsgInfo.vMsg.length - 7];
          bdqa.a((byte[])localObject, 0, localMsgInfo.vMsg, 7, localObject.length);
          paramToServiceMsg = paramToServiceMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte[])localObject, localMsgInfo.shMsgSeq, localMsgInfo.uRealMsgTime, false, false, null);
          if (paramToServiceMsg == null) {
            break label2349;
          }
          localArrayList1.add(paramToServiceMsg);
          break label2349;
          label1459:
          ((bcnu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(paramToServiceMsg, localMsgInfo.shMsgSeq);
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
          j(paramToServiceMsg);
          break label2349;
          label1518:
          if (localMsgInfo.vMsg.length <= 7) {
            break label2349;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 7];
          bdqa.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 7, paramToServiceMsg.length);
          b(paramToServiceMsg, i);
          break label2349;
        }
        if (230 == j)
        {
          paramToServiceMsg = new String(azah.a(localMsgInfo.vMsg), "utf-8");
          localObject = ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(l1 + "");
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
            localObject = ((aufv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).b(String.valueOf(l2));
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
            if ((paramToServiceMsg == null) || (alww.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, true))) {
              break label2413;
            }
            localArrayList1.add(paramToServiceMsg);
            break label2413;
          }
        }
      }
      for (;;)
      {
        bafj.a().a(l2, localMsgInfo.uMsgTime, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
          if ((paramToServiceMsg == null) || (alww.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, true))) {
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
          bool2 = alww.a(localArrayList1);
          i = abti.a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    paramArrayOfByte = barl.a(paramArrayOfByte, paramArrayOfLong);
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
    long l1 = bdqa.a(paramArrayOfByte, 0);
    if (paramArrayOfByte[4] == 15)
    {
      long l2 = bdqa.a(paramArrayOfByte, 5);
      long l3 = bdqa.a(paramArrayOfByte, 9);
      int i = bdqa.b(paramArrayOfByte, 13);
      paramArrayOfByte = bdqa.a(paramArrayOfByte, 15, i);
      long l4 = NetConnInfoCenter.getServerTime();
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(paramInt, l1, l4, l3, l2, paramArrayOfByte);
      bool = true;
    }
    return bool;
  }
  
  private abto b(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(amlf.a(paramInt)).a(amlf.a(paramInt), paramMsgInfo, paramSvcReqPushMsg);
  }
  
  /* Error */
  private MessageRecord b(MsgInfo paramMsgInfo, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 86
    //   8: iconst_2
    //   9: ldc_w 1517
    //   12: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_1
    //   16: getfield 1103	OnlinePushPack/MsgInfo:vMsg	[B
    //   19: invokestatic 1522	ayzd:a	([B)LIMMsgBodyPack/MsgType0x210;
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
    //   47: ldc_w 1524
    //   50: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload 32
    //   55: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   58: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   61: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: aload 32
    //   69: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   72: ldc2_w 1530
    //   75: lcmp
    //   76: ifne +140 -> 216
    //   79: aload 32
    //   81: getfield 1535	IMMsgBodyPack/MsgType0x210:stMsgInfo0x24	LIMMsgBodyPack/MsgType0x210SubMsgType0x24;
    //   84: ifnull +132 -> 216
    //   87: aload 32
    //   89: getfield 1535	IMMsgBodyPack/MsgType0x210:stMsgInfo0x24	LIMMsgBodyPack/MsgType0x210SubMsgType0x24;
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull -65 -> 29
    //   97: aload_1
    //   98: getfield 1540	IMMsgBodyPack/MsgType0x210SubMsgType0x24:vPluginNumList	Ljava/util/ArrayList;
    //   101: ifnull -72 -> 29
    //   104: aload_1
    //   105: getfield 1540	IMMsgBodyPack/MsgType0x210SubMsgType0x24:vPluginNumList	Ljava/util/ArrayList;
    //   108: astore 28
    //   110: aload 28
    //   112: ifnull -83 -> 29
    //   115: aload 28
    //   117: invokeinterface 1541 1 0
    //   122: ifle -93 -> 29
    //   125: aload_0
    //   126: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   129: bipush 12
    //   131: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   134: checkcast 1543	azbi
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
    //   168: checkcast 1545	IMMsgBodyPack/PluginNum
    //   171: astore 29
    //   173: aload 29
    //   175: ifnull -24 -> 151
    //   178: aload 29
    //   180: getfield 1548	IMMsgBodyPack/PluginNum:dwID	J
    //   183: lstore_2
    //   184: aload 29
    //   186: getfield 1552	IMMsgBodyPack/PluginNum:cFlag	B
    //   189: ifne +21 -> 210
    //   192: iconst_0
    //   193: istore 19
    //   195: aload_1
    //   196: lload_2
    //   197: iload 19
    //   199: aload 29
    //   201: getfield 1555	IMMsgBodyPack/PluginNum:dwNUm	J
    //   204: invokevirtual 1558	azbi:a	(JZJ)V
    //   207: goto -56 -> 151
    //   210: iconst_1
    //   211: istore 19
    //   213: goto -18 -> 195
    //   216: aload 32
    //   218: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   221: ifnull +16862 -> 17083
    //   224: aload 32
    //   226: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   229: ldc2_w 1562
    //   232: lcmp
    //   233: ifne +29 -> 262
    //   236: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq +12 -> 251
    //   242: ldc 86
    //   244: iconst_2
    //   245: ldc_w 1565
    //   248: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: aload_0
    //   252: aload 32
    //   254: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   257: invokevirtual 1567	abtl:a	([B)V
    //   260: aconst_null
    //   261: areturn
    //   262: aload 32
    //   264: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   267: ldc2_w 1568
    //   270: lcmp
    //   271: ifeq +27 -> 298
    //   274: aload 32
    //   276: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   279: ldc2_w 1570
    //   282: lcmp
    //   283: ifeq +15 -> 298
    //   286: aload 32
    //   288: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   291: ldc2_w 1572
    //   294: lcmp
    //   295: ifne +46 -> 341
    //   298: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq +13 -> 314
    //   304: ldc_w 1575
    //   307: iconst_2
    //   308: ldc_w 1577
    //   311: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: aload_0
    //   315: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   318: bipush 11
    //   320: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   323: checkcast 1579	com/tencent/mobileqq/app/PublicAccountHandler
    //   326: aload 32
    //   328: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   331: aload 32
    //   333: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   336: invokevirtual 1582	com/tencent/mobileqq/app/PublicAccountHandler:a	(J[B)V
    //   339: aconst_null
    //   340: areturn
    //   341: aload 32
    //   343: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   346: ldc2_w 1583
    //   349: lcmp
    //   350: ifne +41 -> 391
    //   353: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq +13 -> 369
    //   359: ldc_w 1586
    //   362: iconst_2
    //   363: ldc_w 1588
    //   366: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: aload_0
    //   370: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   373: bipush 18
    //   375: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   378: checkcast 1590	amcl
    //   381: aload 32
    //   383: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   386: invokevirtual 1591	amcl:a	([B)V
    //   389: aconst_null
    //   390: areturn
    //   391: aload 32
    //   393: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   396: ldc2_w 1592
    //   399: lcmp
    //   400: ifne +15 -> 415
    //   403: aload_0
    //   404: lload_2
    //   405: aload 32
    //   407: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   410: invokespecial 1595	abtl:b	(J[B)V
    //   413: aconst_null
    //   414: areturn
    //   415: aload 32
    //   417: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   420: ldc2_w 1596
    //   423: lcmp
    //   424: ifne +85 -> 509
    //   427: new 1599	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody
    //   430: dup
    //   431: invokespecial 1600	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody:<init>	()V
    //   434: aload 32
    //   436: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   439: invokevirtual 1604	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   442: checkcast 1599	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody
    //   445: getfield 1607	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody:uint32_bubble_timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   448: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   451: istore 4
    //   453: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq -427 -> 29
    //   459: ldc_w 520
    //   462: iconst_2
    //   463: new 88	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   470: ldc_w 1609
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
    //   500: ldc_w 1611
    //   503: aload_1
    //   504: invokestatic 1614	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   507: aconst_null
    //   508: areturn
    //   509: aload 32
    //   511: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   514: ldc2_w 1615
    //   517: lcmp
    //   518: ifne +617 -> 1135
    //   521: new 1618	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody
    //   524: dup
    //   525: invokespecial 1619	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:<init>	()V
    //   528: astore 29
    //   530: aload 29
    //   532: aload 32
    //   534: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   537: invokevirtual 1620	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   540: pop
    //   541: aload 29
    //   543: getfield 1623	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   546: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   549: iconst_1
    //   550: if_icmpne -521 -> 29
    //   553: new 88	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   560: aload 29
    //   562: getfield 1626	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:uint64_from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
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
    //   589: getfield 1629	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:uint64_action_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   592: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   595: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   598: ldc 140
    //   600: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: astore 28
    //   608: aload 29
    //   610: getfield 1633	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:source	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   613: invokevirtual 1636	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   616: iconst_2
    //   617: if_icmpne +261 -> 878
    //   620: sipush 1001
    //   623: istore 4
    //   625: aload 29
    //   627: getfield 1640	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:bool_new_friend	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   630: invokevirtual 1644	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   633: ifeq +34 -> 667
    //   636: iconst_0
    //   637: istore 4
    //   639: aload_0
    //   640: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   643: iconst_1
    //   644: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   647: checkcast 211	com/tencent/mobileqq/app/FriendListHandler
    //   650: astore 30
    //   652: aload 30
    //   654: bipush 63
    //   656: iconst_1
    //   657: aload_1
    //   658: invokevirtual 1645	com/tencent/mobileqq/app/FriendListHandler:notifyUI	(IZLjava/lang/Object;)V
    //   661: aload 30
    //   663: aload_1
    //   664: invokevirtual 1646	com/tencent/mobileqq/app/FriendListHandler:b	(Ljava/lang/String;)V
    //   667: aload 29
    //   669: getfield 1649	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:rpt_msg_business_msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   672: invokevirtual 45	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   675: invokeinterface 51 1 0
    //   680: astore 29
    //   682: aload 29
    //   684: invokeinterface 56 1 0
    //   689: ifeq -660 -> 29
    //   692: aload 29
    //   694: invokeinterface 60 1 0
    //   699: checkcast 1651	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$BusinessMsg
    //   702: astore 30
    //   704: aload 30
    //   706: getfield 1654	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$BusinessMsg:msg_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   709: invokevirtual 1636	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   712: istore 5
    //   714: iload 5
    //   716: iconst_1
    //   717: if_icmpne +169 -> 886
    //   720: sipush -1000
    //   723: invokestatic 1233	azaf:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   726: checkcast 1656	com/tencent/mobileqq/data/MessageForText
    //   729: astore 31
    //   731: aload 31
    //   733: aload_1
    //   734: putfield 1659	com/tencent/mobileqq/data/MessageForText:frienduin	Ljava/lang/String;
    //   737: aload_0
    //   738: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   741: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   744: aload 28
    //   746: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   749: ifeq +9 -> 758
    //   752: aload 31
    //   754: iconst_1
    //   755: putfield 1662	com/tencent/mobileqq/data/MessageForText:issend	I
    //   758: aload 31
    //   760: aload_0
    //   761: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   764: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   767: aload_1
    //   768: aload 28
    //   770: aload 30
    //   772: getfield 1665	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$BusinessMsg:bytes_msg_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   775: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   778: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   781: invokestatic 581	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   784: sipush -1000
    //   787: iload 4
    //   789: aload_0
    //   790: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   793: invokevirtual 694	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   796: aload_1
    //   797: iload 4
    //   799: invokevirtual 1668	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;I)Lcom/tencent/imcore/message/QQMessageFacade$Message;
    //   802: getfield 1671	com/tencent/imcore/message/QQMessageFacade$Message:shmsgseq	J
    //   805: lconst_1
    //   806: ladd
    //   807: invokevirtual 1672	com/tencent/mobileqq/data/MessageForText:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   810: aload 31
    //   812: iconst_0
    //   813: putfield 1673	com/tencent/mobileqq/data/MessageForText:isread	Z
    //   816: aload_0
    //   817: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   820: invokevirtual 694	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   823: aload 31
    //   825: aload_0
    //   826: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   829: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   832: invokevirtual 1676	com/tencent/imcore/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   835: goto -153 -> 682
    //   838: astore_1
    //   839: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   842: ifeq -813 -> 29
    //   845: ldc_w 1678
    //   848: iconst_2
    //   849: new 88	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   856: ldc_w 1680
    //   859: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: aload 32
    //   864: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   867: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   870: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   873: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   876: aconst_null
    //   877: areturn
    //   878: sipush 10002
    //   881: istore 4
    //   883: goto -258 -> 625
    //   886: iload 5
    //   888: iconst_2
    //   889: if_icmpne -207 -> 682
    //   892: aload 30
    //   894: getfield 1683	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$BusinessMsg:bool_tab_visible	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   897: invokevirtual 1644	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   900: istore 19
    //   902: aload 30
    //   904: getfield 1665	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$BusinessMsg:bytes_msg_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   907: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   910: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   913: astore 30
    //   915: iload 19
    //   917: ifeq +140 -> 1057
    //   920: sipush -5001
    //   923: invokestatic 1233	azaf:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   926: checkcast 1685	com/tencent/mobileqq/data/MessageForNewGrayTips
    //   929: astore 31
    //   931: aload 31
    //   933: aload_0
    //   934: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   937: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   940: aload_1
    //   941: aload_1
    //   942: aload 30
    //   944: invokestatic 581	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   947: sipush -5001
    //   950: iload 4
    //   952: lconst_1
    //   953: aload_0
    //   954: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   957: invokevirtual 694	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   960: aload_1
    //   961: iload 4
    //   963: invokevirtual 1668	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;I)Lcom/tencent/imcore/message/QQMessageFacade$Message;
    //   966: getfield 1671	com/tencent/imcore/message/QQMessageFacade$Message:shmsgseq	J
    //   969: ladd
    //   970: invokevirtual 1686	com/tencent/mobileqq/data/MessageForNewGrayTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   973: aload 31
    //   975: iconst_1
    //   976: putfield 1687	com/tencent/mobileqq/data/MessageForNewGrayTips:isread	Z
    //   979: aload 31
    //   981: iconst_1
    //   982: putfield 1690	com/tencent/mobileqq/data/MessageForNewGrayTips:mNeedTimeStamp	Z
    //   985: aload 31
    //   987: invokevirtual 1693	com/tencent/mobileqq/data/MessageForNewGrayTips:updateMsgData	()V
    //   990: aload_0
    //   991: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   994: invokevirtual 694	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   997: aload 31
    //   999: aload_0
    //   1000: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1003: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1006: invokevirtual 1676	com/tencent/imcore/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   1009: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1012: ifeq -330 -> 682
    //   1015: ldc_w 1678
    //   1018: iconst_2
    //   1019: new 88	java/lang/StringBuilder
    //   1022: dup
    //   1023: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   1026: ldc_w 1695
    //   1029: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: iload 19
    //   1034: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1037: ldc_w 1697
    //   1040: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1043: aload 30
    //   1045: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1051: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1054: goto -372 -> 682
    //   1057: sipush -5000
    //   1060: invokestatic 1233	azaf:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1063: astore 31
    //   1065: aload 31
    //   1067: aload_0
    //   1068: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1071: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1074: aload_1
    //   1075: aload_1
    //   1076: aload 30
    //   1078: invokestatic 581	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   1081: sipush -5000
    //   1084: iload 4
    //   1086: lconst_1
    //   1087: aload_0
    //   1088: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1091: invokevirtual 694	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1094: aload_1
    //   1095: iload 4
    //   1097: invokevirtual 1668	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;I)Lcom/tencent/imcore/message/QQMessageFacade$Message;
    //   1100: getfield 1671	com/tencent/imcore/message/QQMessageFacade$Message:shmsgseq	J
    //   1103: ladd
    //   1104: invokevirtual 1245	com/tencent/mobileqq/data/MessageRecord:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   1107: aload 31
    //   1109: iconst_1
    //   1110: putfield 1251	com/tencent/mobileqq/data/MessageRecord:isread	Z
    //   1113: aload_0
    //   1114: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1117: invokevirtual 694	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1120: aload 31
    //   1122: aload_0
    //   1123: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1126: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1129: invokevirtual 1676	com/tencent/imcore/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   1132: goto -123 -> 1009
    //   1135: aload 32
    //   1137: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1140: ldc2_w 1698
    //   1143: lcmp
    //   1144: ifne +315 -> 1459
    //   1147: new 1701	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody
    //   1150: dup
    //   1151: invokespecial 1702	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:<init>	()V
    //   1154: astore 28
    //   1156: aload 28
    //   1158: aload 32
    //   1160: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1163: invokevirtual 1703	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1166: pop
    //   1167: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1170: ifeq +111 -> 1281
    //   1173: new 88	java/lang/StringBuilder
    //   1176: dup
    //   1177: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   1180: ldc_w 1705
    //   1183: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: astore 29
    //   1188: aload 28
    //   1190: getfield 1708	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1193: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1196: ifeq +251 -> 1447
    //   1199: aload 28
    //   1201: getfield 1708	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1204: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1207: invokestatic 495	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1210: astore_1
    //   1211: aload 29
    //   1213: aload_1
    //   1214: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: ldc_w 1710
    //   1220: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1223: astore 29
    //   1225: aload 28
    //   1227: getfield 1713	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1230: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1233: ifeq +220 -> 1453
    //   1236: aload 28
    //   1238: getfield 1713	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1241: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1244: invokestatic 956	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1247: astore_1
    //   1248: ldc_w 1715
    //   1251: iconst_2
    //   1252: aload 29
    //   1254: aload_1
    //   1255: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1258: ldc_w 1717
    //   1261: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: aload 28
    //   1266: getfield 1720	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_member_level_changed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1269: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1272: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1275: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1278: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1281: aload 28
    //   1283: getfield 1708	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1286: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1289: ifeq -1260 -> 29
    //   1292: aload 28
    //   1294: getfield 1713	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1297: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1300: ifeq +87 -> 1387
    //   1303: aload 28
    //   1305: getfield 1713	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1308: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1311: istore 4
    //   1313: aload 28
    //   1315: getfield 1708	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1318: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1321: invokestatic 495	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1324: astore_1
    //   1325: aload_0
    //   1326: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1329: bipush 52
    //   1331: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1334: checkcast 1499	com/tencent/mobileqq/app/TroopManager
    //   1337: astore 29
    //   1339: aload 29
    //   1341: aload_1
    //   1342: invokevirtual 1723	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   1345: astore 30
    //   1347: aload 30
    //   1349: iload 4
    //   1351: i2b
    //   1352: putfield 1728	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   1355: aload 29
    //   1357: aload 30
    //   1359: invokevirtual 1731	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   1362: iconst_1
    //   1363: aload 30
    //   1365: getfield 1728	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   1368: if_icmpne +19 -> 1387
    //   1371: aload_0
    //   1372: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1375: bipush 20
    //   1377: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   1380: checkcast 1084	amdu
    //   1383: aload_1
    //   1384: invokevirtual 1733	amdu:f	(Ljava/lang/String;)V
    //   1387: aload 28
    //   1389: getfield 1720	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_member_level_changed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1392: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1395: ifeq -1366 -> 29
    //   1398: aload 28
    //   1400: getfield 1708	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1403: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1406: lstore_2
    //   1407: aload_0
    //   1408: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1411: bipush 20
    //   1413: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   1416: checkcast 1084	amdu
    //   1419: lload_2
    //   1420: invokestatic 495	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1423: invokevirtual 1733	amdu:f	(Ljava/lang/String;)V
    //   1426: aconst_null
    //   1427: areturn
    //   1428: astore_1
    //   1429: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1432: ifeq -1403 -> 29
    //   1435: ldc_w 1715
    //   1438: iconst_2
    //   1439: ldc_w 1735
    //   1442: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1445: aconst_null
    //   1446: areturn
    //   1447: ldc 140
    //   1449: astore_1
    //   1450: goto -239 -> 1211
    //   1453: ldc 140
    //   1455: astore_1
    //   1456: goto -208 -> 1248
    //   1459: aload 32
    //   1461: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1464: ldc2_w 1736
    //   1467: lcmp
    //   1468: ifne +25 -> 1493
    //   1471: aload_0
    //   1472: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1475: bipush 17
    //   1477: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1480: checkcast 446	baam
    //   1483: aload 32
    //   1485: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1488: invokevirtual 1738	baam:a	([B)V
    //   1491: aconst_null
    //   1492: areturn
    //   1493: aload 32
    //   1495: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1498: ldc2_w 1739
    //   1501: lcmp
    //   1502: ifne +17 -> 1519
    //   1505: aload_0
    //   1506: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1509: aload 32
    //   1511: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1514: invokestatic 1745	alqf:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   1517: aconst_null
    //   1518: areturn
    //   1519: aload 32
    //   1521: ifnull +35 -> 1556
    //   1524: aload 32
    //   1526: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1529: ldc2_w 1746
    //   1532: lcmp
    //   1533: ifne +23 -> 1556
    //   1536: aload 32
    //   1538: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1541: ifnull +15 -> 1556
    //   1544: aload_0
    //   1545: lload_2
    //   1546: aload 32
    //   1548: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1551: invokevirtual 1748	abtl:a	(J[B)V
    //   1554: aconst_null
    //   1555: areturn
    //   1556: aload 32
    //   1558: ifnull +35 -> 1593
    //   1561: aload 32
    //   1563: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1566: ldc2_w 1749
    //   1569: lcmp
    //   1570: ifne +23 -> 1593
    //   1573: aload 32
    //   1575: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1578: ifnull +15 -> 1593
    //   1581: aload_0
    //   1582: aload 32
    //   1584: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1587: invokevirtual 1751	abtl:a	([B)Ljava/lang/String;
    //   1590: pop
    //   1591: aconst_null
    //   1592: areturn
    //   1593: aload 32
    //   1595: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1598: ldc2_w 1752
    //   1601: lcmp
    //   1602: ifne +22 -> 1624
    //   1605: aload 32
    //   1607: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1610: ifnull +14 -> 1624
    //   1613: aload_0
    //   1614: aload 32
    //   1616: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1619: invokespecial 1756	abtl:g	([B)V
    //   1622: aconst_null
    //   1623: areturn
    //   1624: aload 32
    //   1626: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1629: ldc2_w 1757
    //   1632: lcmp
    //   1633: ifne +22 -> 1655
    //   1636: aload 32
    //   1638: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1641: ifnull +14 -> 1655
    //   1644: aload_0
    //   1645: aload 32
    //   1647: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1650: invokevirtual 1760	abtl:b	([B)V
    //   1653: aconst_null
    //   1654: areturn
    //   1655: aload 32
    //   1657: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1660: ldc2_w 1761
    //   1663: lcmp
    //   1664: ifne +22 -> 1686
    //   1667: aload 32
    //   1669: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1672: ifnull +14 -> 1686
    //   1675: aload_0
    //   1676: aload 32
    //   1678: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1681: invokespecial 1765	abtl:h	([B)V
    //   1684: aconst_null
    //   1685: areturn
    //   1686: aload 32
    //   1688: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1691: ldc2_w 1766
    //   1694: lcmp
    //   1695: ifne +22 -> 1717
    //   1698: aload 32
    //   1700: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1703: ifnull +14 -> 1717
    //   1706: aload_0
    //   1707: aload 32
    //   1709: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1712: invokespecial 1769	abtl:i	([B)V
    //   1715: aconst_null
    //   1716: areturn
    //   1717: aload 32
    //   1719: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1722: ldc2_w 1770
    //   1725: lcmp
    //   1726: ifne +14 -> 1740
    //   1729: aload_0
    //   1730: aload 32
    //   1732: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1735: invokevirtual 1773	abtl:d	([B)V
    //   1738: aconst_null
    //   1739: areturn
    //   1740: aload 32
    //   1742: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1745: ldc2_w 1774
    //   1748: lcmp
    //   1749: ifne +14 -> 1763
    //   1752: aload_0
    //   1753: aload 32
    //   1755: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1758: invokevirtual 1777	abtl:e	([B)V
    //   1761: aconst_null
    //   1762: areturn
    //   1763: aload 32
    //   1765: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1768: ldc2_w 1778
    //   1771: lcmp
    //   1772: ifne +22 -> 1794
    //   1775: aload 32
    //   1777: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1780: ifnull +14 -> 1794
    //   1783: aload_0
    //   1784: aload 32
    //   1786: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1789: invokevirtual 1781	abtl:c	([B)V
    //   1792: aconst_null
    //   1793: areturn
    //   1794: aload 32
    //   1796: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1799: ldc2_w 1782
    //   1802: lcmp
    //   1803: ifne +311 -> 2114
    //   1806: aload 32
    //   1808: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1811: ifnull +303 -> 2114
    //   1814: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1817: ifeq +13 -> 1830
    //   1820: ldc_w 1785
    //   1823: iconst_2
    //   1824: ldc_w 1787
    //   1827: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1830: new 1789	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock
    //   1833: dup
    //   1834: invokespecial 1790	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:<init>	()V
    //   1837: astore_1
    //   1838: aload_1
    //   1839: aload 32
    //   1841: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1844: invokevirtual 1791	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1847: pop
    //   1848: new 325	android/content/Intent
    //   1851: dup
    //   1852: invokespecial 1792	android/content/Intent:<init>	()V
    //   1855: astore 28
    //   1857: aload 28
    //   1859: ldc_w 1794
    //   1862: aload_1
    //   1863: getfield 1796	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:canCancel	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   1866: invokevirtual 1644	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   1869: invokevirtual 335	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1872: pop
    //   1873: aload 28
    //   1875: ldc_w 1798
    //   1878: aload_1
    //   1879: getfield 1801	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1882: invokevirtual 1803	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1885: invokevirtual 474	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1888: pop
    //   1889: aload 28
    //   1891: ldc_w 1805
    //   1894: aload_1
    //   1895: getfield 1808	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1898: invokevirtual 1803	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1901: invokevirtual 474	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1904: pop
    //   1905: aload 28
    //   1907: ldc_w 1810
    //   1910: aload_1
    //   1911: getfield 1813	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_second_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1914: invokevirtual 1803	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1917: invokevirtual 474	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1920: pop
    //   1921: aload 28
    //   1923: ldc_w 1815
    //   1926: aload_1
    //   1927: getfield 1818	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_third_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1930: invokevirtual 1803	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1933: invokevirtual 474	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1936: pop
    //   1937: aload_1
    //   1938: getfield 1822	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_wording_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1941: invokevirtual 1825	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   1944: astore 29
    //   1946: new 655	java/util/ArrayList
    //   1949: dup
    //   1950: invokespecial 656	java/util/ArrayList:<init>	()V
    //   1953: astore 30
    //   1955: aload 29
    //   1957: ifnull +21 -> 1978
    //   1960: aload 29
    //   1962: invokeinterface 1541 1 0
    //   1967: ifle +11 -> 1978
    //   1970: aload 30
    //   1972: aload 29
    //   1974: invokevirtual 1829	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   1977: pop
    //   1978: aload 28
    //   1980: ldc_w 1831
    //   1983: aload 30
    //   1985: invokevirtual 1835	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   1988: pop
    //   1989: aload_0
    //   1990: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1993: aload 28
    //   1995: invokevirtual 1838	com/tencent/mobileqq/app/QQAppInterface:setDevLockIntent	(Landroid/content/Intent;)V
    //   1998: aload_0
    //   1999: sipush 8007
    //   2002: iconst_1
    //   2003: bipush 6
    //   2005: anewarray 220	java/lang/Object
    //   2008: dup
    //   2009: iconst_0
    //   2010: aload_1
    //   2011: getfield 1796	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:canCancel	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   2014: invokevirtual 1644	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   2017: invokestatic 1011	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2020: aastore
    //   2021: dup
    //   2022: iconst_1
    //   2023: aload_1
    //   2024: getfield 1801	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2027: invokevirtual 1803	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2030: aastore
    //   2031: dup
    //   2032: iconst_2
    //   2033: aload_1
    //   2034: getfield 1808	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2037: invokevirtual 1803	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2040: aastore
    //   2041: dup
    //   2042: iconst_3
    //   2043: aload_1
    //   2044: getfield 1813	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_second_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2047: invokevirtual 1803	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2050: aastore
    //   2051: dup
    //   2052: iconst_4
    //   2053: aload_1
    //   2054: getfield 1818	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_third_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2057: invokevirtual 1803	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2060: aastore
    //   2061: dup
    //   2062: iconst_5
    //   2063: aload 30
    //   2065: aastore
    //   2066: invokevirtual 1840	abtl:a	(IZLjava/lang/Object;)V
    //   2069: aconst_null
    //   2070: areturn
    //   2071: astore_1
    //   2072: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2075: ifeq +13 -> 2088
    //   2078: ldc_w 1785
    //   2081: iconst_2
    //   2082: ldc_w 1842
    //   2085: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2088: aload_0
    //   2089: sipush 8007
    //   2092: iconst_0
    //   2093: iconst_2
    //   2094: anewarray 220	java/lang/Object
    //   2097: dup
    //   2098: iconst_0
    //   2099: iconst_1
    //   2100: invokestatic 1011	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2103: aastore
    //   2104: dup
    //   2105: iconst_1
    //   2106: ldc 140
    //   2108: aastore
    //   2109: invokevirtual 1840	abtl:a	(IZLjava/lang/Object;)V
    //   2112: aconst_null
    //   2113: areturn
    //   2114: aload 32
    //   2116: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2119: ldc2_w 1843
    //   2122: lcmp
    //   2123: ifne +327 -> 2450
    //   2126: aload 32
    //   2128: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2131: ifnull +319 -> 2450
    //   2134: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2137: ifeq +13 -> 2150
    //   2140: ldc_w 1785
    //   2143: iconst_2
    //   2144: ldc_w 1846
    //   2147: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2150: new 1848	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody
    //   2153: dup
    //   2154: invokespecial 1849	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:<init>	()V
    //   2157: pop
    //   2158: aconst_null
    //   2159: astore 28
    //   2161: aconst_null
    //   2162: astore 29
    //   2164: aconst_null
    //   2165: astore 30
    //   2167: aconst_null
    //   2168: astore 31
    //   2170: new 1848	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody
    //   2173: dup
    //   2174: invokespecial 1849	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:<init>	()V
    //   2177: astore 33
    //   2179: aload 33
    //   2181: aload 32
    //   2183: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2186: invokevirtual 1850	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2189: pop
    //   2190: aload 33
    //   2192: getfield 1853	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_qrsig_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2195: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2198: ifeq +26 -> 2224
    //   2201: new 274	java/lang/String
    //   2204: dup
    //   2205: aload 33
    //   2207: getfield 1853	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_qrsig_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2210: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2213: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2216: ldc_w 1336
    //   2219: invokespecial 1339	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2222: astore 28
    //   2224: aload 33
    //   2226: getfield 1856	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint1	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2229: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2232: ifeq +26 -> 2258
    //   2235: new 274	java/lang/String
    //   2238: dup
    //   2239: aload 33
    //   2241: getfield 1856	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint1	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2244: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2247: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2250: ldc_w 1336
    //   2253: invokespecial 1339	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2256: astore 29
    //   2258: aload 33
    //   2260: getfield 1859	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint2	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2263: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2266: ifeq +26 -> 2292
    //   2269: new 274	java/lang/String
    //   2272: dup
    //   2273: aload 33
    //   2275: getfield 1859	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint2	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2278: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2281: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2284: ldc_w 1336
    //   2287: invokespecial 1339	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2290: astore 30
    //   2292: aload 33
    //   2294: getfield 1862	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_login_conf	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2297: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2300: ifeq +16 -> 2316
    //   2303: aload 33
    //   2305: getfield 1862	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_login_conf	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2308: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2311: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2314: astore 31
    //   2316: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2319: ifeq +53 -> 2372
    //   2322: ldc_w 1785
    //   2325: iconst_2
    //   2326: new 88	java/lang/StringBuilder
    //   2329: dup
    //   2330: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   2333: ldc_w 1864
    //   2336: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2339: aload 28
    //   2341: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2344: ldc_w 1866
    //   2347: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2350: aload 29
    //   2352: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2355: ldc_w 1868
    //   2358: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2361: aload 30
    //   2363: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2366: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2369: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2372: invokestatic 1873	aqbd:a	()Laqbd;
    //   2375: aload_0
    //   2376: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2379: aload 28
    //   2381: aload 29
    //   2383: aload 30
    //   2385: aload 31
    //   2387: invokevirtual 1876	aqbd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V
    //   2390: aload_1
    //   2391: getfield 1157	OnlinePushPack/MsgInfo:lFromUin	J
    //   2394: lstore_2
    //   2395: aload_1
    //   2396: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   2399: istore 4
    //   2401: aload_1
    //   2402: getfield 1208	OnlinePushPack/MsgInfo:lMsgUid	J
    //   2405: lstore 15
    //   2407: aload_1
    //   2408: getfield 1154	OnlinePushPack/MsgInfo:shMsgType	S
    //   2411: istore 5
    //   2413: aload_0
    //   2414: getfield 1471	abtl:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2417: lload_2
    //   2418: iload 4
    //   2420: lload 15
    //   2422: iload 5
    //   2424: invokestatic 1881	azad:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   2427: aconst_null
    //   2428: areturn
    //   2429: astore 28
    //   2431: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2434: ifeq -44 -> 2390
    //   2437: ldc_w 1785
    //   2440: iconst_2
    //   2441: ldc_w 1883
    //   2444: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2447: goto -57 -> 2390
    //   2450: aload 32
    //   2452: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2455: ldc2_w 1884
    //   2458: lcmp
    //   2459: ifne +33 -> 2492
    //   2462: aload 32
    //   2464: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2467: ifnull +25 -> 2492
    //   2470: aload_0
    //   2471: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2474: bipush 24
    //   2476: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   2479: checkcast 1887	amce
    //   2482: aload 32
    //   2484: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2487: invokevirtual 1888	amce:a	([B)V
    //   2490: aconst_null
    //   2491: areturn
    //   2492: aload 32
    //   2494: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2497: ldc2_w 1889
    //   2500: lcmp
    //   2501: ifne +221 -> 2722
    //   2504: aload 32
    //   2506: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2509: ifnull +213 -> 2722
    //   2512: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2515: ifeq +13 -> 2528
    //   2518: ldc_w 1892
    //   2521: iconst_2
    //   2522: ldc_w 1894
    //   2525: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2528: aload_0
    //   2529: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2532: iconst_4
    //   2533: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   2536: checkcast 1742	alqf
    //   2539: astore_1
    //   2540: aload_1
    //   2541: ifnull -2512 -> 29
    //   2544: new 1896	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody
    //   2547: dup
    //   2548: invokespecial 1897	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:<init>	()V
    //   2551: astore 28
    //   2553: aload 28
    //   2555: aload 32
    //   2557: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2560: invokevirtual 1898	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2563: pop
    //   2564: aload 28
    //   2566: getfield 1901	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:peer_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   2569: invokevirtual 1636	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   2572: istore 4
    //   2574: aload 28
    //   2576: getfield 1904	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:task_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2579: invokevirtual 45	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2582: astore 30
    //   2584: new 655	java/util/ArrayList
    //   2587: dup
    //   2588: invokespecial 656	java/util/ArrayList:<init>	()V
    //   2591: astore 29
    //   2593: aload 30
    //   2595: ifnull +87 -> 2682
    //   2598: aload 30
    //   2600: invokeinterface 1541 1 0
    //   2605: ifle +77 -> 2682
    //   2608: aload 30
    //   2610: invokeinterface 51 1 0
    //   2615: astore 30
    //   2617: aload 30
    //   2619: invokeinterface 56 1 0
    //   2624: ifeq +58 -> 2682
    //   2627: aload 30
    //   2629: invokeinterface 60 1 0
    //   2634: checkcast 1906	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody$TaskInfo
    //   2637: astore 31
    //   2639: new 1908	com/tencent/mobileqq/config/operation/QQOperationViopTipTask
    //   2642: dup
    //   2643: invokespecial 1909	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:<init>	()V
    //   2646: astore 32
    //   2648: aload 32
    //   2650: aload 31
    //   2652: getfield 1912	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody$TaskInfo:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2655: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2658: putfield 1915	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:taskid	I
    //   2661: aload 29
    //   2663: aload 32
    //   2665: invokevirtual 657	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2668: pop
    //   2669: goto -52 -> 2617
    //   2672: astore 29
    //   2674: aload 29
    //   2676: invokevirtual 1916	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   2679: goto -115 -> 2564
    //   2682: aload 28
    //   2684: getfield 1919	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:peer_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
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
    //   2709: invokevirtual 1922	alqf:a	(Ljava/lang/String;ILjava/util/ArrayList;)V
    //   2712: aconst_null
    //   2713: areturn
    //   2714: sipush 3000
    //   2717: istore 4
    //   2719: goto -19 -> 2700
    //   2722: aload 32
    //   2724: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2727: ldc2_w 1923
    //   2730: lcmp
    //   2731: ifne +21 -> 2752
    //   2734: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2737: ifeq -2708 -> 29
    //   2740: ldc_w 520
    //   2743: iconst_2
    //   2744: ldc_w 1926
    //   2747: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2750: aconst_null
    //   2751: areturn
    //   2752: aload 32
    //   2754: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2757: ldc2_w 1927
    //   2760: lcmp
    //   2761: ifne +160 -> 2921
    //   2764: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2767: ifeq +44 -> 2811
    //   2770: new 88	java/lang/StringBuilder
    //   2773: dup
    //   2774: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   2777: ldc_w 1930
    //   2780: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2783: astore_1
    //   2784: aload 32
    //   2786: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2789: ifnull +84 -> 2873
    //   2792: iconst_1
    //   2793: istore 19
    //   2795: ldc_w 1932
    //   2798: iconst_2
    //   2799: aload_1
    //   2800: iload 19
    //   2802: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2805: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2808: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2811: new 1934	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody
    //   2814: dup
    //   2815: invokespecial 1935	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:<init>	()V
    //   2818: astore_1
    //   2819: aload_1
    //   2820: aload 32
    //   2822: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2825: invokevirtual 1936	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2828: pop
    //   2829: aload_1
    //   2830: getfield 1939	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:rpt_msg_grpinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2833: invokevirtual 1940	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   2836: ifeq -2807 -> 29
    //   2839: aload_1
    //   2840: getfield 1939	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:rpt_msg_grpinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2843: invokevirtual 45	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2846: astore_1
    //   2847: aload_0
    //   2848: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2851: iconst_3
    //   2852: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   2855: checkcast 1942	alvm
    //   2858: astore 28
    //   2860: aload 28
    //   2862: ifnull -2833 -> 29
    //   2865: aload 28
    //   2867: aload_1
    //   2868: invokevirtual 1945	alvm:a	(Ljava/util/List;)V
    //   2871: aconst_null
    //   2872: areturn
    //   2873: iconst_0
    //   2874: istore 19
    //   2876: goto -81 -> 2795
    //   2879: astore 28
    //   2881: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2884: ifeq -55 -> 2829
    //   2887: ldc_w 1932
    //   2890: iconst_2
    //   2891: new 88	java/lang/StringBuilder
    //   2894: dup
    //   2895: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   2898: ldc_w 1947
    //   2901: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2904: aload 28
    //   2906: invokevirtual 1948	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   2909: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2912: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2915: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2918: goto -89 -> 2829
    //   2921: aload 32
    //   2923: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2926: ldc2_w 1949
    //   2929: lcmp
    //   2930: ifne +27 -> 2957
    //   2933: aload_0
    //   2934: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2937: bipush 22
    //   2939: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2942: checkcast 1952	ambh
    //   2945: astore_1
    //   2946: aload_1
    //   2947: ifnull -2918 -> 29
    //   2950: aload_1
    //   2951: invokevirtual 1953	ambh:a	()Z
    //   2954: pop
    //   2955: aconst_null
    //   2956: areturn
    //   2957: aload 32
    //   2959: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2962: ldc2_w 1954
    //   2965: lcmp
    //   2966: ifne +90 -> 3056
    //   2969: aload 32
    //   2971: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2974: ifnull +82 -> 3056
    //   2977: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2980: ifeq +13 -> 2993
    //   2983: ldc_w 520
    //   2986: iconst_2
    //   2987: ldc_w 1957
    //   2990: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2993: aload_0
    //   2994: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2997: ldc_w 1959
    //   3000: ldc 140
    //   3002: ldc 140
    //   3004: ldc_w 1961
    //   3007: ldc_w 1961
    //   3010: iconst_0
    //   3011: iconst_0
    //   3012: ldc 140
    //   3014: ldc 140
    //   3016: ldc 140
    //   3018: ldc 140
    //   3020: invokestatic 1966	azqs:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3023: new 1968	tencent/im/s2c/msgtype0x210/submsgtype0x63/submsgtype0x63$MsgBody
    //   3026: dup
    //   3027: invokespecial 1969	tencent/im/s2c/msgtype0x210/submsgtype0x63/submsgtype0x63$MsgBody:<init>	()V
    //   3030: pop
    //   3031: new 1971	maf
    //   3034: dup
    //   3035: invokestatic 1972	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3038: invokespecial 1975	maf:<init>	(Landroid/content/Context;)V
    //   3041: new 1977	abtm
    //   3044: dup
    //   3045: aload_0
    //   3046: aload 32
    //   3048: invokespecial 1980	abtm:<init>	(Labtl;LIMMsgBodyPack/MsgType0x210;)V
    //   3051: invokevirtual 1983	maf:a	(Lmag;)V
    //   3054: aconst_null
    //   3055: areturn
    //   3056: aload 32
    //   3058: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3061: ldc2_w 1984
    //   3064: lcmp
    //   3065: ifne +57 -> 3122
    //   3068: aload 32
    //   3070: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3073: ifnull +49 -> 3122
    //   3076: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3079: ifeq +13 -> 3092
    //   3082: ldc_w 1987
    //   3085: iconst_2
    //   3086: ldc_w 1989
    //   3089: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3092: aload_0
    //   3093: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3096: aload 32
    //   3098: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3101: aload_1
    //   3102: getfield 1157	OnlinePushPack/MsgInfo:lFromUin	J
    //   3105: aload_1
    //   3106: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3109: aload_1
    //   3110: getfield 1208	OnlinePushPack/MsgInfo:lMsgUid	J
    //   3113: aload_1
    //   3114: getfield 1154	OnlinePushPack/MsgInfo:shMsgType	S
    //   3117: invokestatic 1994	aivm:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BJIJI)V
    //   3120: aconst_null
    //   3121: areturn
    //   3122: aload 32
    //   3124: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3127: ldc2_w 1995
    //   3130: lcmp
    //   3131: ifne +25 -> 3156
    //   3134: aload 32
    //   3136: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3139: ifnull +17 -> 3156
    //   3142: aload_0
    //   3143: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3146: aload 32
    //   3148: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3151: invokestatic 1999	ahag:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   3154: aconst_null
    //   3155: areturn
    //   3156: aload 32
    //   3158: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3161: ldc2_w 2000
    //   3164: lcmp
    //   3165: ifne +57 -> 3222
    //   3168: aload 32
    //   3170: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3173: ifnull +49 -> 3222
    //   3176: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3179: ifeq +13 -> 3192
    //   3182: ldc_w 1987
    //   3185: iconst_2
    //   3186: ldc_w 2003
    //   3189: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3192: aload_0
    //   3193: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3196: aload 32
    //   3198: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3201: aload_1
    //   3202: getfield 1157	OnlinePushPack/MsgInfo:lFromUin	J
    //   3205: aload_1
    //   3206: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3209: aload_1
    //   3210: getfield 1208	OnlinePushPack/MsgInfo:lMsgUid	J
    //   3213: aload_1
    //   3214: getfield 1154	OnlinePushPack/MsgInfo:shMsgType	S
    //   3217: invokestatic 2005	aivm:b	(Lcom/tencent/mobileqq/app/QQAppInterface;[BJIJI)V
    //   3220: aconst_null
    //   3221: areturn
    //   3222: aload 32
    //   3224: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3227: ldc2_w 2006
    //   3230: lcmp
    //   3231: ifne +81 -> 3312
    //   3234: aload 32
    //   3236: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3239: ifnull +73 -> 3312
    //   3242: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3245: ifeq +13 -> 3258
    //   3248: ldc_w 2009
    //   3251: iconst_2
    //   3252: ldc_w 2011
    //   3255: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3258: aload_0
    //   3259: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3262: aload 32
    //   3264: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3267: invokestatic 2012	azad:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   3270: aload_1
    //   3271: getfield 1157	OnlinePushPack/MsgInfo:lFromUin	J
    //   3274: lstore_2
    //   3275: aload_1
    //   3276: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3279: istore 4
    //   3281: aload_1
    //   3282: getfield 1208	OnlinePushPack/MsgInfo:lMsgUid	J
    //   3285: lstore 15
    //   3287: aload_1
    //   3288: getfield 1154	OnlinePushPack/MsgInfo:shMsgType	S
    //   3291: istore 5
    //   3293: aload_0
    //   3294: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3297: invokevirtual 1298	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/MessageHandler;
    //   3300: lload_2
    //   3301: iload 4
    //   3303: lload 15
    //   3305: iload 5
    //   3307: invokestatic 1881	azad:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   3310: aconst_null
    //   3311: areturn
    //   3312: aload 32
    //   3314: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3317: ldc2_w 2013
    //   3320: lcmp
    //   3321: ifne +433 -> 3754
    //   3324: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3327: ifeq +13 -> 3340
    //   3330: ldc_w 2016
    //   3333: iconst_2
    //   3334: ldc_w 2011
    //   3337: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3340: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3343: ifeq +13 -> 3356
    //   3346: ldc_w 2018
    //   3349: iconst_2
    //   3350: ldc_w 2020
    //   3353: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3356: new 2022	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody
    //   3359: dup
    //   3360: invokespecial 2023	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:<init>	()V
    //   3363: astore 31
    //   3365: aload 31
    //   3367: aload 32
    //   3369: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3372: invokevirtual 2024	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3375: pop
    //   3376: aload 31
    //   3378: getfield 2027	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:uint64_to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3381: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   3384: lstore_2
    //   3385: aload_0
    //   3386: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3389: invokevirtual 1163	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3392: astore 28
    //   3394: invokestatic 2032	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
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
    //   3439: getfield 2035	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_tips_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3442: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3445: ifeq +13878 -> 17323
    //   3448: new 274	java/lang/String
    //   3451: dup
    //   3452: aload 31
    //   3454: getfield 2035	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_tips_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3457: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3460: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3463: ldc_w 1336
    //   3466: invokespecial 1339	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3469: astore 30
    //   3471: aload 30
    //   3473: astore 28
    //   3475: aload 31
    //   3477: getfield 2038	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_yes_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3480: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3483: ifeq +13834 -> 17317
    //   3486: new 274	java/lang/String
    //   3489: dup
    //   3490: aload 31
    //   3492: getfield 2038	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_yes_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3495: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3498: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3501: ldc_w 1336
    //   3504: invokespecial 1339	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3507: astore 30
    //   3509: aload 30
    //   3511: astore 29
    //   3513: aload 31
    //   3515: getfield 2041	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_no_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3518: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3521: ifeq +13790 -> 17311
    //   3524: new 274	java/lang/String
    //   3527: dup
    //   3528: aload 31
    //   3530: getfield 2041	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_no_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3533: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3536: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3539: ldc_w 1336
    //   3542: invokespecial 1339	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3545: astore 30
    //   3547: aload 30
    //   3549: astore 31
    //   3551: aload 28
    //   3553: astore 30
    //   3555: aload 29
    //   3557: astore 32
    //   3559: invokestatic 2032	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3562: lload_2
    //   3563: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3566: aload 30
    //   3568: aload 31
    //   3570: aload 32
    //   3572: invokevirtual 2045	com/tencent/common/app/BaseApplicationImpl:setPCActiveNotice	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
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
    //   3606: invokevirtual 1840	abtl:a	(IZLjava/lang/Object;)V
    //   3609: aload_1
    //   3610: getfield 1157	OnlinePushPack/MsgInfo:lFromUin	J
    //   3613: lstore_2
    //   3614: aload_1
    //   3615: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3618: istore 4
    //   3620: aload_1
    //   3621: getfield 1208	OnlinePushPack/MsgInfo:lMsgUid	J
    //   3624: lstore 15
    //   3626: aload_1
    //   3627: getfield 1154	OnlinePushPack/MsgInfo:shMsgType	S
    //   3630: istore 5
    //   3632: aload_0
    //   3633: getfield 1471	abtl:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   3636: lload_2
    //   3637: iload 4
    //   3639: lload 15
    //   3641: iload 5
    //   3643: invokestatic 1881	azad:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
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
    //   3668: ldc_w 2016
    //   3671: iconst_2
    //   3672: ldc_w 2047
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
    //   3697: invokevirtual 1916	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
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
    //   3729: invokevirtual 1840	abtl:a	(IZLjava/lang/Object;)V
    //   3732: goto -123 -> 3609
    //   3735: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3738: ifeq -129 -> 3609
    //   3741: ldc_w 2016
    //   3744: iconst_2
    //   3745: ldc_w 2049
    //   3748: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3751: goto -142 -> 3609
    //   3754: ldc2_w 2050
    //   3757: aload 32
    //   3759: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3762: lcmp
    //   3763: ifne +46 -> 3809
    //   3766: aload_0
    //   3767: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3770: aload 32
    //   3772: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3775: invokestatic 2056	nag:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)Ltencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo;
    //   3778: astore_1
    //   3779: aload_1
    //   3780: ifnull -3751 -> 29
    //   3783: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3786: ifeq +13 -> 3799
    //   3789: ldc_w 2058
    //   3792: iconst_2
    //   3793: ldc_w 2060
    //   3796: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3799: aload_0
    //   3800: bipush 105
    //   3802: iconst_1
    //   3803: aload_1
    //   3804: invokevirtual 1840	abtl:a	(IZLjava/lang/Object;)V
    //   3807: aconst_null
    //   3808: areturn
    //   3809: aload 32
    //   3811: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3814: ldc2_w 2061
    //   3817: lcmp
    //   3818: ifne +26 -> 3844
    //   3821: ldc_w 2064
    //   3824: ldc_w 2066
    //   3827: iconst_0
    //   3828: iconst_0
    //   3829: iconst_1
    //   3830: anewarray 274	java/lang/String
    //   3833: dup
    //   3834: iconst_0
    //   3835: ldc_w 2068
    //   3838: aastore
    //   3839: invokestatic 2073	wxj:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   3842: aconst_null
    //   3843: areturn
    //   3844: aload 32
    //   3846: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3849: ldc2_w 2074
    //   3852: lcmp
    //   3853: ifne +1682 -> 5535
    //   3856: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3859: ifeq +13 -> 3872
    //   3862: ldc_w 2077
    //   3865: iconst_2
    //   3866: ldc_w 2011
    //   3869: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3872: new 2079	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody
    //   3875: dup
    //   3876: invokespecial 2080	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody:<init>	()V
    //   3879: astore 29
    //   3881: aload 29
    //   3883: aload 32
    //   3885: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3888: invokevirtual 2081	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3891: pop
    //   3892: iconst_0
    //   3893: istore 4
    //   3895: iload 4
    //   3897: aload 29
    //   3899: getfield 2084	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody:rpt_msg_mod_infos	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3902: invokevirtual 2085	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   3905: if_icmpge -3876 -> 29
    //   3908: aload 29
    //   3910: getfield 2084	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody:rpt_msg_mod_infos	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3913: invokevirtual 45	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   3916: iload 4
    //   3918: invokeinterface 2087 2 0
    //   3923: checkcast 2089	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody
    //   3926: astore 28
    //   3928: iconst_m1
    //   3929: istore 5
    //   3931: aload 28
    //   3933: getfield 2092	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:uint32_op_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3936: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3939: ifeq +13 -> 3952
    //   3942: aload 28
    //   3944: getfield 2092	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:uint32_op_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3947: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3950: istore 5
    //   3952: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3955: ifeq +31 -> 3986
    //   3958: ldc_w 2077
    //   3961: iconst_2
    //   3962: new 88	java/lang/StringBuilder
    //   3965: dup
    //   3966: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   3969: ldc_w 2094
    //   3972: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3975: iload 5
    //   3977: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3980: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3983: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3986: iload 5
    //   3988: sipush 2001
    //   3991: if_icmpne +263 -> 4254
    //   3994: aload 28
    //   3996: getfield 2098	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_mcard_notification_like	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike;
    //   3999: invokevirtual 2101	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:has	()Z
    //   4002: ifeq +252 -> 4254
    //   4005: aload 28
    //   4007: getfield 2098	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_mcard_notification_like	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike;
    //   4010: invokevirtual 2102	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4013: checkcast 2100	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike
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
    //   4032: getfield 2105	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:str_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4035: invokevirtual 2106	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   4038: ifeq +13 -> 4051
    //   4041: aload 30
    //   4043: getfield 2105	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:str_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4046: invokevirtual 1803	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4049: astore 28
    //   4051: aload 30
    //   4053: getfield 2109	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4056: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4059: ifeq +13 -> 4072
    //   4062: aload 30
    //   4064: getfield 2109	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4067: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4070: istore 5
    //   4072: aload 30
    //   4074: getfield 2110	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint64_from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4077: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   4080: ifeq +12 -> 4092
    //   4083: aload 30
    //   4085: getfield 2110	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint64_from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4088: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4091: lstore_2
    //   4092: aload 30
    //   4094: getfield 2113	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_total	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4097: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4100: ifeq +13 -> 4113
    //   4103: aload 30
    //   4105: getfield 2113	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_total	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4108: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4111: istore 6
    //   4113: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4116: ifeq +63 -> 4179
    //   4119: ldc_w 2077
    //   4122: iconst_2
    //   4123: new 88	java/lang/StringBuilder
    //   4126: dup
    //   4127: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   4130: ldc_w 2115
    //   4133: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4136: aload 28
    //   4138: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4141: ldc_w 2117
    //   4144: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4147: iload 6
    //   4149: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4152: ldc_w 2119
    //   4155: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4158: iload 5
    //   4160: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4163: ldc_w 2121
    //   4166: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4169: lload_2
    //   4170: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4173: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4176: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4179: aload_0
    //   4180: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4183: bipush 71
    //   4185: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4188: checkcast 2123	aphz
    //   4191: astore 28
    //   4193: aload 28
    //   4195: ifnull +13 -> 4208
    //   4198: aload 28
    //   4200: invokevirtual 2126	aphz:a	()Lapjc;
    //   4203: aload 30
    //   4205: invokevirtual 2131	apjc:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike;)V
    //   4208: aload_1
    //   4209: getfield 1157	OnlinePushPack/MsgInfo:lFromUin	J
    //   4212: lstore_2
    //   4213: aload_1
    //   4214: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   4217: istore 5
    //   4219: aload_1
    //   4220: getfield 1208	OnlinePushPack/MsgInfo:lMsgUid	J
    //   4223: lstore 15
    //   4225: aload_1
    //   4226: getfield 1154	OnlinePushPack/MsgInfo:shMsgType	S
    //   4229: istore 6
    //   4231: aload_0
    //   4232: getfield 1471	abtl:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   4235: lload_2
    //   4236: iload 5
    //   4238: lload 15
    //   4240: iload 6
    //   4242: invokestatic 1881	azad:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   4245: iload 4
    //   4247: iconst_1
    //   4248: iadd
    //   4249: istore 4
    //   4251: goto -356 -> 3895
    //   4254: iload 5
    //   4256: sipush 2002
    //   4259: if_icmpne +460 -> 4719
    //   4262: aload 28
    //   4264: getfield 2135	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_vip_info_notify	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify;
    //   4267: invokevirtual 2138	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:has	()Z
    //   4270: ifeq +449 -> 4719
    //   4273: aload 28
    //   4275: getfield 2135	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_vip_info_notify	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify;
    //   4278: invokevirtual 2139	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4281: checkcast 2137	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify
    //   4284: astore 30
    //   4286: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4289: ifeq +34 -> 4323
    //   4292: ldc_w 520
    //   4295: iconst_2
    //   4296: new 88	java/lang/StringBuilder
    //   4299: dup
    //   4300: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   4303: ldc_w 2141
    //   4306: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4309: aload 30
    //   4311: invokevirtual 2142	java/lang/Object:toString	()Ljava/lang/String;
    //   4314: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4317: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4320: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4323: lconst_0
    //   4324: lstore_2
    //   4325: aload 30
    //   4327: getfield 2143	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4330: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   4333: ifeq +12 -> 4345
    //   4336: aload 30
    //   4338: getfield 2143	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4341: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4344: lstore_2
    //   4345: lload_2
    //   4346: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4349: astore 28
    //   4351: aload 30
    //   4353: getfield 2146	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_vip_identify	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4356: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4359: ifeq +12946 -> 17305
    //   4362: aload 30
    //   4364: getfield 2146	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_vip_identify	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4367: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4370: istore 5
    //   4372: aload 30
    //   4374: getfield 2149	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_vip_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4377: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4380: ifeq +12919 -> 17299
    //   4383: aload 30
    //   4385: getfield 2149	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_vip_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4388: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4391: istore 6
    //   4393: iconst_m1
    //   4394: istore 7
    //   4396: iconst_m1
    //   4397: istore 8
    //   4399: aload 30
    //   4401: getfield 2152	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_red_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4404: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4407: ifeq +13 -> 4420
    //   4410: aload 30
    //   4412: getfield 2152	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_red_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4415: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4418: istore 7
    //   4420: aload 30
    //   4422: getfield 2155	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_disable_red_envelope	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4425: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4428: ifeq +13 -> 4441
    //   4431: aload 30
    //   4433: getfield 2155	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_disable_red_envelope	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4436: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4439: istore 8
    //   4441: aload 30
    //   4443: getfield 2158	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_redpack_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4446: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4449: istore 9
    //   4451: aload 30
    //   4453: getfield 2161	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:str_redpack_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4456: invokevirtual 1803	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4459: astore 30
    //   4461: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4464: ifeq +12865 -> 17329
    //   4467: ldc_w 520
    //   4470: iconst_2
    //   4471: new 88	java/lang/StringBuilder
    //   4474: dup
    //   4475: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   4478: ldc_w 2163
    //   4481: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4484: iload 9
    //   4486: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4489: ldc_w 2165
    //   4492: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4495: aload 30
    //   4497: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4500: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4503: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4506: goto +12823 -> 17329
    //   4509: aload_0
    //   4510: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4513: sipush 131
    //   4516: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4519: checkcast 2167	alvg
    //   4522: astore 31
    //   4524: aload 31
    //   4526: iload 7
    //   4528: iload 8
    //   4530: iconst_1
    //   4531: invokevirtual 2170	alvg:a	(IIZ)V
    //   4534: aload 31
    //   4536: iload 9
    //   4538: aload 30
    //   4540: invokevirtual 2173	alvg:a	(ILjava/lang/String;)V
    //   4543: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4546: ifeq +12796 -> 17342
    //   4549: ldc_w 520
    //   4552: iconst_2
    //   4553: new 88	java/lang/StringBuilder
    //   4556: dup
    //   4557: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   4560: ldc_w 2175
    //   4563: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4566: aload 28
    //   4568: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4571: ldc_w 2177
    //   4574: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4577: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4580: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4583: goto +12759 -> 17342
    //   4586: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4589: ifeq +42 -> 4631
    //   4592: ldc_w 520
    //   4595: iconst_2
    //   4596: new 88	java/lang/StringBuilder
    //   4599: dup
    //   4600: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   4603: ldc_w 2179
    //   4606: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4609: iload 5
    //   4611: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4614: ldc_w 2181
    //   4617: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4620: iload 6
    //   4622: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4625: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4628: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4631: aload_0
    //   4632: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4635: iconst_2
    //   4636: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4639: checkcast 380	mqq/manager/TicketManager
    //   4642: aload 28
    //   4644: invokeinterface 384 2 0
    //   4649: astore 30
    //   4651: aload_0
    //   4652: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4655: bipush 27
    //   4657: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   4660: checkcast 386	amfs
    //   4663: aload 30
    //   4665: aload 28
    //   4667: invokevirtual 389	amfs:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   4670: aload_0
    //   4671: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4674: invokestatic 2186	bdww:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lbdww;
    //   4677: invokevirtual 2188	bdww:b	()V
    //   4680: goto -472 -> 4208
    //   4683: astore_1
    //   4684: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4687: ifeq -4658 -> 29
    //   4690: ldc_w 2077
    //   4693: iconst_2
    //   4694: new 88	java/lang/StringBuilder
    //   4697: dup
    //   4698: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   4701: ldc_w 2190
    //   4704: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4707: aload_1
    //   4708: invokevirtual 2193	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4711: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4714: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4717: aconst_null
    //   4718: areturn
    //   4719: iload 5
    //   4721: sipush 2003
    //   4724: if_icmpne +155 -> 4879
    //   4727: aload 28
    //   4729: getfield 2197	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_push_lost_dev_found	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound;
    //   4732: invokevirtual 2200	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:has	()Z
    //   4735: ifeq +144 -> 4879
    //   4738: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4741: ifeq +13 -> 4754
    //   4744: ldc_w 2202
    //   4747: iconst_2
    //   4748: ldc_w 2204
    //   4751: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4754: aload 28
    //   4756: getfield 2197	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_push_lost_dev_found	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound;
    //   4759: invokevirtual 2205	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4762: checkcast 2199	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound
    //   4765: astore 28
    //   4767: new 910	android/os/Bundle
    //   4770: dup
    //   4771: invokespecial 911	android/os/Bundle:<init>	()V
    //   4774: astore 30
    //   4776: aload 28
    //   4778: getfield 2208	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4781: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4784: ifeq +19 -> 4803
    //   4787: aload 30
    //   4789: ldc_w 2210
    //   4792: aload 28
    //   4794: getfield 2208	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4797: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4800: invokevirtual 2212	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4803: aload 28
    //   4805: getfield 2215	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint32_dev_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4808: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4811: ifeq +19 -> 4830
    //   4814: aload 30
    //   4816: ldc_w 2217
    //   4819: aload 28
    //   4821: getfield 2215	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint32_dev_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4824: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4827: invokevirtual 2212	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4830: aload 28
    //   4832: getfield 2220	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint64_din	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4835: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   4838: ifeq +19 -> 4857
    //   4841: aload 30
    //   4843: ldc_w 2222
    //   4846: aload 28
    //   4848: getfield 2220	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint64_din	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4851: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4854: invokevirtual 923	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   4857: aload_0
    //   4858: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4861: bipush 51
    //   4863: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   4866: checkcast 2224	ztp
    //   4869: bipush 111
    //   4871: aload 30
    //   4873: invokevirtual 2227	ztp:a	(ILandroid/os/Bundle;)V
    //   4876: goto -668 -> 4208
    //   4879: iload 5
    //   4881: sipush 2007
    //   4884: if_icmpne +50 -> 4934
    //   4887: aload 28
    //   4889: getfield 2231	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_babyq_reward_info	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$RewardInfo;
    //   4892: invokevirtual 2234	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$RewardInfo:has	()Z
    //   4895: ifeq +39 -> 4934
    //   4898: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4901: ifeq +13 -> 4914
    //   4904: ldc_w 520
    //   4907: iconst_2
    //   4908: ldc_w 2236
    //   4911: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4914: aload_0
    //   4915: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4918: bipush 53
    //   4920: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   4923: checkcast 2238	alok
    //   4926: aload 28
    //   4928: invokevirtual 2241	alok:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody;)V
    //   4931: goto -723 -> 4208
    //   4934: iload 5
    //   4936: sipush 2011
    //   4939: if_icmpne -731 -> 4208
    //   4942: aload 28
    //   4944: getfield 2245	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_mod_qim_friend_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ;
    //   4947: invokevirtual 2248	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:has	()Z
    //   4950: ifeq -742 -> 4208
    //   4953: aload 28
    //   4955: getfield 2245	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_mod_qim_friend_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ;
    //   4958: invokevirtual 2249	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4961: checkcast 2247	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ
    //   4964: astore 28
    //   4966: iconst_m1
    //   4967: istore 5
    //   4969: aload 28
    //   4971: getfield 2252	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:uint32_notify_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4974: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4977: ifeq +13 -> 4990
    //   4980: aload 28
    //   4982: getfield 2252	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:uint32_notify_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4985: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4988: istore 5
    //   4990: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4993: ifeq +31 -> 5024
    //   4996: ldc_w 2254
    //   4999: iconst_2
    //   5000: new 88	java/lang/StringBuilder
    //   5003: dup
    //   5004: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   5007: ldc_w 2256
    //   5010: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5013: iload 5
    //   5015: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5018: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5021: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5024: iload 5
    //   5026: iconst_1
    //   5027: if_icmpne +190 -> 5217
    //   5030: aload 28
    //   5032: getfield 2260	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:msg_add_notify_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ;
    //   5035: invokevirtual 2263	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:has	()Z
    //   5038: ifeq -830 -> 4208
    //   5041: aload 28
    //   5043: getfield 2260	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:msg_add_notify_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ;
    //   5046: astore 28
    //   5048: new 2265	com/tencent/mobileqq/data/QIMFollwerAdd
    //   5051: dup
    //   5052: invokespecial 2266	com/tencent/mobileqq/data/QIMFollwerAdd:<init>	()V
    //   5055: astore 30
    //   5057: aload 30
    //   5059: aload 28
    //   5061: getfield 2267	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5064: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5067: putfield 2269	com/tencent/mobileqq/data/QIMFollwerAdd:uin	J
    //   5070: aload 30
    //   5072: aload 28
    //   5074: getfield 2272	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint32_gender	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5077: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5080: putfield 2275	com/tencent/mobileqq/data/QIMFollwerAdd:gender	I
    //   5083: aload 30
    //   5085: aload 28
    //   5087: getfield 2278	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint64_cares_count	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5090: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5093: putfield 2281	com/tencent/mobileqq/data/QIMFollwerAdd:careSCount	J
    //   5096: aload 30
    //   5098: aload 28
    //   5100: getfield 2284	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint64_storys_total_num	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5103: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5106: putfield 2287	com/tencent/mobileqq/data/QIMFollwerAdd:totalNum	J
    //   5109: aload 30
    //   5111: aload 28
    //   5113: getfield 2290	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:bytes_smart_remark	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5116: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5119: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5122: putfield 2293	com/tencent/mobileqq/data/QIMFollwerAdd:smartRemark	Ljava/lang/String;
    //   5125: aload 30
    //   5127: aload 28
    //   5129: getfield 2294	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint32_op_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5132: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5135: putfield 2297	com/tencent/mobileqq/data/QIMFollwerAdd:opType	I
    //   5138: aload 30
    //   5140: aload 28
    //   5142: getfield 2300	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint64_fans_count	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5145: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5148: putfield 2303	com/tencent/mobileqq/data/QIMFollwerAdd:fansCount	J
    //   5151: aload 30
    //   5153: aload 28
    //   5155: getfield 2306	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:bytes_longnick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5158: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5161: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   5164: invokestatic 2312	com/tencent/mobileqq/richstatus/RichStatus:parseStatus	([B)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   5167: invokevirtual 2315	com/tencent/mobileqq/richstatus/RichStatus:getPlainText	()Ljava/lang/String;
    //   5170: putfield 2318	com/tencent/mobileqq/data/QIMFollwerAdd:longNick	Ljava/lang/String;
    //   5173: aload 30
    //   5175: invokestatic 2320	ayzl:a	()J
    //   5178: putfield 2323	com/tencent/mobileqq/data/QIMFollwerAdd:upTime	J
    //   5181: aload 30
    //   5183: aload 28
    //   5185: getfield 2326	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:bytes_src_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5188: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5191: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5194: putfield 2328	com/tencent/mobileqq/data/QIMFollwerAdd:source	Ljava/lang/String;
    //   5197: aload_0
    //   5198: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5201: bipush 34
    //   5203: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5206: checkcast 2330	alxr
    //   5209: aload 30
    //   5211: invokevirtual 2333	alxr:b	(Lcom/tencent/mobileqq/data/QIMFollwerAdd;)V
    //   5214: goto -1006 -> 4208
    //   5217: iload 5
    //   5219: iconst_2
    //   5220: if_icmpeq -1012 -> 4208
    //   5223: iload 5
    //   5225: iconst_3
    //   5226: if_icmpne -1018 -> 4208
    //   5229: aload 28
    //   5231: getfield 2337	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:msg_add_not_login_frd_notify_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ;
    //   5234: invokevirtual 2340	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:has	()Z
    //   5237: ifeq -1029 -> 4208
    //   5240: aload 28
    //   5242: getfield 2337	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:msg_add_not_login_frd_notify_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ;
    //   5245: invokevirtual 2341	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5248: checkcast 2339	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ
    //   5251: astore 28
    //   5253: new 2343	com/tencent/mobileqq/data/QIMNotifyAddFriend
    //   5256: dup
    //   5257: invokespecial 2344	com/tencent/mobileqq/data/QIMNotifyAddFriend:<init>	()V
    //   5260: astore 30
    //   5262: aload 30
    //   5264: aload 28
    //   5266: getfield 2345	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5269: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5272: putfield 2346	com/tencent/mobileqq/data/QIMNotifyAddFriend:uin	J
    //   5275: aload 30
    //   5277: aload 28
    //   5279: getfield 2349	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:uint64_qq_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5282: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5285: putfield 2352	com/tencent/mobileqq/data/QIMNotifyAddFriend:qqUin	J
    //   5288: aload 30
    //   5290: aload 28
    //   5292: getfield 2355	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:bytes_nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5295: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5298: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5301: putfield 2358	com/tencent/mobileqq/data/QIMNotifyAddFriend:nickName	Ljava/lang/String;
    //   5304: aload 30
    //   5306: aload 28
    //   5308: getfield 2359	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:uint32_gender	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5311: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5314: putfield 2360	com/tencent/mobileqq/data/QIMNotifyAddFriend:gender	I
    //   5317: aload 30
    //   5319: aload 28
    //   5321: getfield 2363	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5324: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5327: putfield 2366	com/tencent/mobileqq/data/QIMNotifyAddFriend:age	I
    //   5330: aload 30
    //   5332: aload 28
    //   5334: getfield 2369	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:bytes_coverstory	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5337: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5340: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5343: putfield 2372	com/tencent/mobileqq/data/QIMNotifyAddFriend:coverStory	Ljava/lang/String;
    //   5346: aload 30
    //   5348: aload 28
    //   5350: getfield 2373	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:uint64_storys_total_num	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5353: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5356: putfield 2376	com/tencent/mobileqq/data/QIMNotifyAddFriend:storyTotalNum	J
    //   5359: aload 30
    //   5361: aload 28
    //   5363: getfield 2379	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:bytes_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5366: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5369: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5372: putfield 2381	com/tencent/mobileqq/data/QIMNotifyAddFriend:wording	Ljava/lang/String;
    //   5375: iconst_0
    //   5376: istore 5
    //   5378: iload 5
    //   5380: aload 28
    //   5382: getfield 2384	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:rpt_msg_video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5385: invokevirtual 2085	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   5388: if_icmpge +81 -> 5469
    //   5391: aload 28
    //   5393: getfield 2384	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:rpt_msg_video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5396: iload 5
    //   5398: invokevirtual 2387	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5401: checkcast 2389	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VideoInfo
    //   5404: astore 31
    //   5406: new 2391	com/tencent/mobileqq/data/QIMNotifyAddFriend$VideoInfo
    //   5409: dup
    //   5410: invokespecial 2392	com/tencent/mobileqq/data/QIMNotifyAddFriend$VideoInfo:<init>	()V
    //   5413: astore 32
    //   5415: aload 32
    //   5417: aload 31
    //   5419: getfield 2395	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VideoInfo:bytes_video_cover_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5422: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5425: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5428: putfield 2398	com/tencent/mobileqq/data/QIMNotifyAddFriend$VideoInfo:coverUrl	Ljava/lang/String;
    //   5431: aload 32
    //   5433: aload 31
    //   5435: getfield 2401	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VideoInfo:bytes_vid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5438: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5441: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5444: putfield 2404	com/tencent/mobileqq/data/QIMNotifyAddFriend$VideoInfo:videoVid	Ljava/lang/String;
    //   5447: aload 30
    //   5449: getfield 2408	com/tencent/mobileqq/data/QIMNotifyAddFriend:videoInfos	Ljava/util/List;
    //   5452: aload 32
    //   5454: invokeinterface 1062 2 0
    //   5459: pop
    //   5460: iload 5
    //   5462: iconst_1
    //   5463: iadd
    //   5464: istore 5
    //   5466: goto -88 -> 5378
    //   5469: aload 30
    //   5471: invokestatic 2320	ayzl:a	()J
    //   5474: putfield 2411	com/tencent/mobileqq/data/QIMNotifyAddFriend:pushTime	J
    //   5477: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5480: ifeq +34 -> 5514
    //   5483: ldc_w 2254
    //   5486: iconst_2
    //   5487: new 88	java/lang/StringBuilder
    //   5490: dup
    //   5491: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   5494: ldc_w 2413
    //   5497: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5500: aload 30
    //   5502: invokevirtual 2414	com/tencent/mobileqq/data/QIMNotifyAddFriend:toString	()Ljava/lang/String;
    //   5505: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5508: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5511: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5514: aload_0
    //   5515: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5518: sipush 257
    //   5521: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5524: checkcast 2416	alzu
    //   5527: aload 30
    //   5529: invokevirtual 2419	alzu:a	(Lcom/tencent/mobileqq/data/QIMNotifyAddFriend;)V
    //   5532: goto -1324 -> 4208
    //   5535: aload 32
    //   5537: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   5540: ldc2_w 2420
    //   5543: lcmp
    //   5544: ifne +398 -> 5942
    //   5547: new 2423	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody
    //   5550: dup
    //   5551: invokespecial 2424	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:<init>	()V
    //   5554: astore_1
    //   5555: aload_1
    //   5556: aload 32
    //   5558: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   5561: invokevirtual 2425	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5564: pop
    //   5565: aload_1
    //   5566: getfield 2426	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5569: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5572: istore 4
    //   5574: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5577: ifeq +47 -> 5624
    //   5580: ldc_w 520
    //   5583: iconst_2
    //   5584: new 88	java/lang/StringBuilder
    //   5587: dup
    //   5588: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   5591: ldc_w 2428
    //   5594: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5597: iload 4
    //   5599: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5602: ldc_w 2430
    //   5605: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5608: aload_1
    //   5609: getfield 2433	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5612: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5615: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5618: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5621: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5624: iload 4
    //   5626: sipush 1004
    //   5629: if_icmpne +56 -> 5685
    //   5632: aload_0
    //   5633: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5636: bipush 79
    //   5638: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5641: checkcast 2435	com/tencent/mobileqq/portal/PortalManager
    //   5644: astore 28
    //   5646: aload 28
    //   5648: ifnull -5619 -> 29
    //   5651: aload 28
    //   5653: aload_1
    //   5654: invokevirtual 2438	com/tencent/mobileqq/portal/PortalManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody;)V
    //   5657: aconst_null
    //   5658: areturn
    //   5659: astore_1
    //   5660: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5663: ifeq +13 -> 5676
    //   5666: ldc_w 2440
    //   5669: iconst_2
    //   5670: ldc 140
    //   5672: aload_1
    //   5673: invokestatic 2442	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   5676: new 2444	java/lang/RuntimeException
    //   5679: dup
    //   5680: aload_1
    //   5681: invokespecial 2447	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   5684: athrow
    //   5685: iload 4
    //   5687: bipush 49
    //   5689: if_icmpne +26 -> 5715
    //   5692: aload_0
    //   5693: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5696: aload_0
    //   5697: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5700: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5703: aload_1
    //   5704: getfield 2433	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5707: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5710: invokestatic 2452	aozj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   5713: aconst_null
    //   5714: areturn
    //   5715: iload 4
    //   5717: bipush 46
    //   5719: if_icmpne +29 -> 5748
    //   5722: aload_0
    //   5723: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5726: aload_0
    //   5727: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5730: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5733: aload_1
    //   5734: getfield 2433	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5737: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5740: ldc_w 2454
    //   5743: invokestatic 2459	aawh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;ILjava/lang/String;)V
    //   5746: aconst_null
    //   5747: areturn
    //   5748: iload 4
    //   5750: sipush 1003
    //   5753: if_icmpne +22 -> 5775
    //   5756: aload_0
    //   5757: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5760: sipush 167
    //   5763: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5766: checkcast 2461	com/tencent/mobileqq/olympic/OlympicManager
    //   5769: aload_1
    //   5770: invokevirtual 2462	com/tencent/mobileqq/olympic/OlympicManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody;)V
    //   5773: aconst_null
    //   5774: areturn
    //   5775: iload 4
    //   5777: sipush 222
    //   5780: if_icmpne +102 -> 5882
    //   5783: aload_0
    //   5784: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5787: invokevirtual 2466	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   5790: ldc_w 2468
    //   5793: iconst_0
    //   5794: invokeinterface 444 3 0
    //   5799: istore 4
    //   5801: iload 4
    //   5803: aload_1
    //   5804: getfield 2433	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5807: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5810: if_icmpeq +20 -> 5830
    //   5813: aload_0
    //   5814: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5817: sipush 222
    //   5820: aload_0
    //   5821: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5824: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5827: invokestatic 2471	aozj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;)V
    //   5830: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5833: ifeq -5804 -> 29
    //   5836: ldc_w 520
    //   5839: iconst_2
    //   5840: new 88	java/lang/StringBuilder
    //   5843: dup
    //   5844: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   5847: ldc_w 2473
    //   5850: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5853: iload 4
    //   5855: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5858: ldc_w 2430
    //   5861: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5864: aload_1
    //   5865: getfield 2433	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5868: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5871: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5874: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5877: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5880: aconst_null
    //   5881: areturn
    //   5882: iload 4
    //   5884: sipush 283
    //   5887: if_icmpne -5858 -> 29
    //   5890: aload_0
    //   5891: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5894: ifnull -5865 -> 29
    //   5897: ldc_w 520
    //   5900: iconst_1
    //   5901: ldc_w 2475
    //   5904: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5907: aload_0
    //   5908: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5911: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5914: astore_1
    //   5915: aload_0
    //   5916: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5919: sipush 283
    //   5922: aload_1
    //   5923: invokestatic 2471	aozj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;)V
    //   5926: aconst_null
    //   5927: areturn
    //   5928: astore_1
    //   5929: ldc_w 520
    //   5932: iconst_1
    //   5933: ldc_w 2477
    //   5936: aload_1
    //   5937: invokestatic 1614	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   5940: aconst_null
    //   5941: areturn
    //   5942: aload 32
    //   5944: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   5947: ldc2_w 2478
    //   5950: lcmp
    //   5951: ifne +26 -> 5977
    //   5954: aload_0
    //   5955: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5958: bipush 36
    //   5960: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5963: checkcast 2481	axlx
    //   5966: aload 32
    //   5968: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   5971: invokevirtual 2484	axlx:a	([B)Z
    //   5974: pop
    //   5975: aconst_null
    //   5976: areturn
    //   5977: aload 32
    //   5979: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   5982: ldc2_w 2485
    //   5985: lcmp
    //   5986: ifne +25 -> 6011
    //   5989: aload_0
    //   5990: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5993: bipush 36
    //   5995: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5998: checkcast 2481	axlx
    //   6001: aload 32
    //   6003: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6006: invokevirtual 2487	axlx:a	([B)V
    //   6009: aconst_null
    //   6010: areturn
    //   6011: aload 32
    //   6013: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6016: ldc2_w 2488
    //   6019: lcmp
    //   6020: ifne +284 -> 6304
    //   6023: aload_0
    //   6024: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6027: bipush 85
    //   6029: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6032: checkcast 2491	amga
    //   6035: astore 28
    //   6037: aload 28
    //   6039: aload_1
    //   6040: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6043: invokevirtual 2493	amga:a	(I)Z
    //   6046: ifne +220 -> 6266
    //   6049: new 2495	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$MsgBody
    //   6052: dup
    //   6053: invokespecial 2496	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$MsgBody:<init>	()V
    //   6056: astore_1
    //   6057: aload_1
    //   6058: aload 32
    //   6060: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6063: invokevirtual 2497	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6066: pop
    //   6067: aload_1
    //   6068: getfield 2501	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$MsgBody:msg_system_notify	Ltencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$SystemNotify;
    //   6071: invokevirtual 2504	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$SystemNotify:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6074: checkcast 2503	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$SystemNotify
    //   6077: getfield 2507	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$SystemNotify:bytes_msg_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6080: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6083: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   6086: astore 29
    //   6088: new 2509	org/json/JSONObject
    //   6091: dup
    //   6092: aload_1
    //   6093: getfield 2512	tencent/im/s2c/msgtype0x210/submsgtype0x118/submsgtype0x118$MsgBody:bytes_push_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6096: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6099: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   6102: invokespecial 2513	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6105: astore_1
    //   6106: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6109: ifeq +63 -> 6172
    //   6112: ldc_w 520
    //   6115: iconst_2
    //   6116: new 88	java/lang/StringBuilder
    //   6119: dup
    //   6120: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6123: ldc_w 2515
    //   6126: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6129: aload 29
    //   6131: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6134: ldc_w 2517
    //   6137: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6140: aload_1
    //   6141: ldc_w 2519
    //   6144: invokevirtual 2522	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6147: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6150: ldc_w 2524
    //   6153: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6156: aload_1
    //   6157: ldc_w 2526
    //   6160: invokevirtual 2530	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   6163: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6166: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6169: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6172: aload 28
    //   6174: aload 29
    //   6176: aload_1
    //   6177: ldc_w 2519
    //   6180: invokevirtual 2522	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6183: aload_1
    //   6184: ldc_w 2526
    //   6187: invokevirtual 2530	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   6190: invokevirtual 2533	amga:a	(Ljava/lang/String;Ljava/lang/String;J)V
    //   6193: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6196: ifeq +13 -> 6209
    //   6199: ldc_w 520
    //   6202: iconst_2
    //   6203: ldc_w 2535
    //   6206: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6209: aload_0
    //   6210: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6213: ldc_w 2537
    //   6216: ldc_w 2539
    //   6219: ldc 140
    //   6221: ldc 140
    //   6223: ldc_w 2541
    //   6226: iconst_0
    //   6227: iconst_0
    //   6228: ldc 140
    //   6230: ldc 140
    //   6232: aload_1
    //   6233: ldc_w 2519
    //   6236: invokevirtual 2522	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6239: ldc 140
    //   6241: invokestatic 1966	azqs:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   6244: aconst_null
    //   6245: areturn
    //   6246: astore_1
    //   6247: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6250: ifeq -6221 -> 29
    //   6253: ldc_w 2543
    //   6256: iconst_2
    //   6257: ldc_w 2545
    //   6260: aload_1
    //   6261: invokestatic 2442	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   6264: aconst_null
    //   6265: areturn
    //   6266: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6269: ifeq -6240 -> 29
    //   6272: ldc_w 520
    //   6275: iconst_2
    //   6276: new 88	java/lang/StringBuilder
    //   6279: dup
    //   6280: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6283: ldc_w 2547
    //   6286: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6289: aload_1
    //   6290: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6293: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6296: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6299: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6302: aconst_null
    //   6303: areturn
    //   6304: aload 32
    //   6306: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6309: ldc2_w 2548
    //   6312: lcmp
    //   6313: ifne +148 -> 6461
    //   6316: aload_1
    //   6317: getfield 1157	OnlinePushPack/MsgInfo:lFromUin	J
    //   6320: lstore 15
    //   6322: aload_1
    //   6323: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6326: istore 4
    //   6328: aload_1
    //   6329: getfield 1208	OnlinePushPack/MsgInfo:lMsgUid	J
    //   6332: lstore 17
    //   6334: aload_1
    //   6335: getfield 1154	OnlinePushPack/MsgInfo:shMsgType	S
    //   6338: istore 5
    //   6340: aload 32
    //   6342: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6345: l2i
    //   6346: istore 6
    //   6348: aload_0
    //   6349: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6352: bipush 85
    //   6354: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6357: checkcast 2491	amga
    //   6360: aload_1
    //   6361: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6364: invokevirtual 2493	amga:a	(I)Z
    //   6367: ifeq +56 -> 6423
    //   6370: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6373: ifeq +33 -> 6406
    //   6376: ldc_w 520
    //   6379: iconst_2
    //   6380: new 88	java/lang/StringBuilder
    //   6383: dup
    //   6384: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6387: ldc_w 2547
    //   6390: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6393: aload_1
    //   6394: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6397: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6400: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6403: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6406: aload_0
    //   6407: getfield 1471	abtl:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   6410: lload 15
    //   6412: iload 4
    //   6414: lload 17
    //   6416: iload 5
    //   6418: invokestatic 1881	azad:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   6421: aconst_null
    //   6422: areturn
    //   6423: aload_0
    //   6424: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6427: aload 32
    //   6429: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6432: lload 15
    //   6434: lload_2
    //   6435: iload 4
    //   6437: iload 5
    //   6439: iload 6
    //   6441: invokestatic 2552	azad:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BJJIII)Z
    //   6444: ifeq -38 -> 6406
    //   6447: aload_0
    //   6448: ldc_w 2554
    //   6451: iconst_1
    //   6452: iconst_1
    //   6453: iconst_1
    //   6454: iconst_0
    //   6455: invokevirtual 1477	abtl:a	(Ljava/lang/String;ZIZZ)V
    //   6458: goto -52 -> 6406
    //   6461: aload 32
    //   6463: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6466: ldc2_w 2555
    //   6469: lcmp
    //   6470: ifne +25 -> 6495
    //   6473: aload_0
    //   6474: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6477: bipush 47
    //   6479: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   6482: checkcast 2558	alzy
    //   6485: aload 32
    //   6487: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6490: invokevirtual 2559	alzy:a	([B)V
    //   6493: aconst_null
    //   6494: areturn
    //   6495: aload 32
    //   6497: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6500: ldc2_w 2560
    //   6503: lcmp
    //   6504: ifne +271 -> 6775
    //   6507: invokestatic 2564	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6510: ifeq +46 -> 6556
    //   6513: ldc_w 2566
    //   6516: iconst_4
    //   6517: new 88	java/lang/StringBuilder
    //   6520: dup
    //   6521: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6524: ldc_w 2568
    //   6527: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6530: aload_1
    //   6531: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6534: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6537: ldc_w 2570
    //   6540: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6543: aload_1
    //   6544: getfield 1154	OnlinePushPack/MsgInfo:shMsgType	S
    //   6547: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6550: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6553: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6556: new 2572	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody
    //   6559: dup
    //   6560: invokespecial 2573	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:<init>	()V
    //   6563: astore_1
    //   6564: aload_1
    //   6565: aload 32
    //   6567: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6570: invokevirtual 2574	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6573: pop
    //   6574: aload_1
    //   6575: getfield 2577	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:uint32_src_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6578: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6581: pop
    //   6582: aload_1
    //   6583: getfield 2580	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:uint32_undeal_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6586: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6589: istore 4
    //   6591: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6594: ifeq +31 -> 6625
    //   6597: ldc_w 2566
    //   6600: iconst_2
    //   6601: new 88	java/lang/StringBuilder
    //   6604: dup
    //   6605: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6608: ldc_w 2582
    //   6611: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6614: iload 4
    //   6616: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6619: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6622: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6625: ldc_w 2584
    //   6628: iconst_m1
    //   6629: aload_0
    //   6630: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6633: invokevirtual 628	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   6636: invokestatic 2590	cooperation/qzone/LocalMultiProcConfig:getInt4Uin	(Ljava/lang/String;IJ)I
    //   6639: istore 5
    //   6641: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6644: ifeq +47 -> 6691
    //   6647: ldc_w 520
    //   6650: iconst_2
    //   6651: new 88	java/lang/StringBuilder
    //   6654: dup
    //   6655: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6658: ldc_w 2592
    //   6661: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6664: aload_0
    //   6665: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6668: invokevirtual 628	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   6671: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6674: ldc_w 2594
    //   6677: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6680: iload 5
    //   6682: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6685: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6688: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6691: iload 5
    //   6693: iconst_1
    //   6694: if_icmpne -6665 -> 29
    //   6697: aload_0
    //   6698: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6701: bipush 10
    //   6703: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6706: checkcast 2596	azbw
    //   6709: astore_1
    //   6710: new 655	java/util/ArrayList
    //   6713: dup
    //   6714: invokespecial 656	java/util/ArrayList:<init>	()V
    //   6717: astore 28
    //   6719: new 2598	cooperation/qzone/UndealCount/QZoneCountUserInfo
    //   6722: dup
    //   6723: invokespecial 2599	cooperation/qzone/UndealCount/QZoneCountUserInfo:<init>	()V
    //   6726: astore 29
    //   6728: aload 29
    //   6730: aload_0
    //   6731: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6734: invokevirtual 628	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   6737: putfield 2600	cooperation/qzone/UndealCount/QZoneCountUserInfo:a	J
    //   6740: aload 28
    //   6742: aload 29
    //   6744: invokevirtual 657	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   6747: pop
    //   6748: aload_1
    //   6749: bipush 17
    //   6751: iload 4
    //   6753: i2l
    //   6754: aload 28
    //   6756: ldc 140
    //   6758: iconst_0
    //   6759: iconst_1
    //   6760: ldc 140
    //   6762: invokevirtual 2603	azbw:a	(IJLjava/util/ArrayList;Ljava/lang/String;ZZLjava/lang/String;)Z
    //   6765: pop
    //   6766: aconst_null
    //   6767: areturn
    //   6768: astore_1
    //   6769: aload_1
    //   6770: invokevirtual 1916	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   6773: aconst_null
    //   6774: areturn
    //   6775: aload 32
    //   6777: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6780: ldc2_w 2604
    //   6783: lcmp
    //   6784: ifne +134 -> 6918
    //   6787: invokestatic 2564	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6790: ifeq +46 -> 6836
    //   6793: ldc_w 520
    //   6796: iconst_4
    //   6797: new 88	java/lang/StringBuilder
    //   6800: dup
    //   6801: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6804: ldc_w 2607
    //   6807: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6810: aload_1
    //   6811: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6814: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6817: ldc_w 2570
    //   6820: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6823: aload_1
    //   6824: getfield 1154	OnlinePushPack/MsgInfo:shMsgType	S
    //   6827: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6830: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6833: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6836: new 2609	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody
    //   6839: dup
    //   6840: invokespecial 2610	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody:<init>	()V
    //   6843: astore_1
    //   6844: aload_1
    //   6845: aload 32
    //   6847: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6850: invokevirtual 2611	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6853: pop
    //   6854: aload_1
    //   6855: getfield 2612	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6858: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6861: lstore_2
    //   6862: aload_0
    //   6863: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6866: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6869: lload_2
    //   6870: invokestatic 495	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   6873: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6876: ifeq -6847 -> 29
    //   6879: aload_0
    //   6880: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6883: bipush 94
    //   6885: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6888: checkcast 2614	ayxx
    //   6891: aload_1
    //   6892: iconst_3
    //   6893: invokevirtual 2617	ayxx:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody;I)V
    //   6896: aconst_null
    //   6897: areturn
    //   6898: astore_1
    //   6899: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6902: ifeq -6873 -> 29
    //   6905: ldc_w 520
    //   6908: iconst_2
    //   6909: ldc_w 2619
    //   6912: aload_1
    //   6913: invokestatic 1614	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   6916: aconst_null
    //   6917: areturn
    //   6918: aload 32
    //   6920: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6923: ldc2_w 2620
    //   6926: lcmp
    //   6927: ifne +166 -> 7093
    //   6930: invokestatic 2564	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6933: ifeq +46 -> 6979
    //   6936: ldc_w 520
    //   6939: iconst_4
    //   6940: new 88	java/lang/StringBuilder
    //   6943: dup
    //   6944: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6947: ldc_w 2623
    //   6950: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6953: aload_1
    //   6954: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6957: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6960: ldc_w 2570
    //   6963: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6966: aload_1
    //   6967: getfield 1154	OnlinePushPack/MsgInfo:shMsgType	S
    //   6970: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6973: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6976: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6979: new 2625	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody
    //   6982: dup
    //   6983: invokespecial 2626	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:<init>	()V
    //   6986: astore_1
    //   6987: aload_1
    //   6988: aload 32
    //   6990: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6993: invokevirtual 2627	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6996: pop
    //   6997: aload_1
    //   6998: ifnull -6969 -> 29
    //   7001: aload_1
    //   7002: getfield 2630	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:uint32_notify_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7005: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7008: iconst_1
    //   7009: if_icmpne +78 -> 7087
    //   7012: iconst_1
    //   7013: istore 19
    //   7015: iload 19
    //   7017: iconst_1
    //   7018: if_icmpne -6989 -> 29
    //   7021: new 274	java/lang/String
    //   7024: dup
    //   7025: aload_1
    //   7026: getfield 2633	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:bytes_notify_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7029: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7032: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   7035: ldc_w 1336
    //   7038: invokespecial 1339	java/lang/String:<init>	([BLjava/lang/String;)V
    //   7041: astore_1
    //   7042: aload_0
    //   7043: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7046: iload 19
    //   7048: aload_1
    //   7049: invokestatic 2638	axap:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ZLjava/lang/String;)V
    //   7052: aload_0
    //   7053: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7056: invokevirtual 2641	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   7059: iload 19
    //   7061: aload_1
    //   7062: invokevirtual 2646	com/tencent/av/gaudio/AVNotifyCenter:a	(ZLjava/lang/String;)V
    //   7065: aconst_null
    //   7066: areturn
    //   7067: astore_1
    //   7068: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7071: ifeq -7042 -> 29
    //   7074: ldc_w 520
    //   7077: iconst_2
    //   7078: ldc_w 2648
    //   7081: aload_1
    //   7082: invokestatic 1614	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   7085: aconst_null
    //   7086: areturn
    //   7087: iconst_0
    //   7088: istore 19
    //   7090: goto -75 -> 7015
    //   7093: aload 32
    //   7095: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7098: ldc2_w 2649
    //   7101: lcmp
    //   7102: ifne +561 -> 7663
    //   7105: new 2652	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody
    //   7108: dup
    //   7109: invokespecial 2653	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:<init>	()V
    //   7112: astore 28
    //   7114: sipush -2029
    //   7117: invokestatic 1233	azaf:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7120: checkcast 2655	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   7123: astore 29
    //   7125: aload 28
    //   7127: aload 32
    //   7129: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7132: invokevirtual 2656	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7135: pop
    //   7136: aload 29
    //   7138: new 88	java/lang/StringBuilder
    //   7141: dup
    //   7142: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   7145: aload 28
    //   7147: getfield 2659	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:uint64_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7150: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7153: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7156: ldc 140
    //   7158: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7161: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7164: putfield 2662	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7167: aload 29
    //   7169: new 88	java/lang/StringBuilder
    //   7172: dup
    //   7173: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   7176: aload 28
    //   7178: getfield 2665	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:uint64_receiver_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7181: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7184: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7187: ldc 140
    //   7189: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7192: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7195: putfield 2668	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   7198: aload 29
    //   7200: aload 28
    //   7202: getfield 2671	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:bytes_sender_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7205: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7208: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7211: putfield 2674	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   7214: aload 29
    //   7216: aload 28
    //   7218: getfield 2677	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:bytes_receiver_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7221: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7224: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7227: putfield 2680	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   7230: aload 29
    //   7232: aload 28
    //   7234: getfield 2683	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:bytes_authkey	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7237: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7240: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7243: putfield 2686	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   7246: aload 29
    //   7248: aload 28
    //   7250: getfield 2687	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7253: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7256: putfield 2690	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   7259: aload 29
    //   7261: aload 28
    //   7263: getfield 2693	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:uint32_sub_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7266: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7269: putfield 2696	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   7272: aload 29
    //   7274: aload 28
    //   7276: getfield 2699	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:bytes_jumpurl	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7279: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7282: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7285: putfield 2701	com/tencent/mobileqq/data/MessageForQQWalletTips:bytes_jumpurl	Ljava/lang/String;
    //   7288: aload_0
    //   7289: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7292: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7295: astore 30
    //   7297: aload_0
    //   7298: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7301: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7304: aload 29
    //   7306: getfield 2662	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7309: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7312: ifeq +311 -> 7623
    //   7315: aload 29
    //   7317: getfield 2668	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   7320: astore 28
    //   7322: aload 29
    //   7324: aload 30
    //   7326: aload 28
    //   7328: ldc 140
    //   7330: ldc_w 2703
    //   7333: aload_1
    //   7334: invokevirtual 2706	OnlinePushPack/MsgInfo:getUMsgTime	()J
    //   7337: sipush -2029
    //   7340: iconst_0
    //   7341: aload_1
    //   7342: invokevirtual 2709	OnlinePushPack/MsgInfo:getShMsgSeq	()S
    //   7345: i2l
    //   7346: invokevirtual 2710	com/tencent/mobileqq/data/MessageForQQWalletTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   7349: aload 29
    //   7351: iconst_1
    //   7352: putfield 2711	com/tencent/mobileqq/data/MessageForQQWalletTips:isread	Z
    //   7355: aload 29
    //   7357: aload_1
    //   7358: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   7361: i2l
    //   7362: putfield 2712	com/tencent/mobileqq/data/MessageForQQWalletTips:shmsgseq	J
    //   7365: aload 29
    //   7367: aload_1
    //   7368: getfield 1208	OnlinePushPack/MsgInfo:lMsgUid	J
    //   7371: putfield 2713	com/tencent/mobileqq/data/MessageForQQWalletTips:msgUid	J
    //   7374: aload 29
    //   7376: invokevirtual 2716	com/tencent/mobileqq/data/MessageForQQWalletTips:getBytes	()[B
    //   7379: pop
    //   7380: aload 29
    //   7382: invokevirtual 2719	com/tencent/mobileqq/data/MessageForQQWalletTips:onReceiveGrapTips	()V
    //   7385: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7388: ifeq +79 -> 7467
    //   7391: ldc_w 520
    //   7394: iconst_2
    //   7395: new 88	java/lang/StringBuilder
    //   7398: dup
    //   7399: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   7402: ldc_w 2721
    //   7405: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7408: aload 29
    //   7410: getfield 2690	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   7413: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7416: ldc_w 2723
    //   7419: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7422: aload 29
    //   7424: getfield 2696	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   7427: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7430: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7433: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7436: ldc_w 520
    //   7439: iconst_2
    //   7440: new 88	java/lang/StringBuilder
    //   7443: dup
    //   7444: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   7447: ldc_w 2725
    //   7450: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7453: aload 29
    //   7455: getfield 2701	com/tencent/mobileqq/data/MessageForQQWalletTips:bytes_jumpurl	Ljava/lang/String;
    //   7458: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7461: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7464: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7467: aload 29
    //   7469: getfield 2690	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   7472: iconst_1
    //   7473: if_icmpne +11 -> 7484
    //   7476: aload 29
    //   7478: getfield 2696	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   7481: ifeq +9813 -> 17294
    //   7484: aload 29
    //   7486: astore_1
    //   7487: aload 29
    //   7489: getfield 2690	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   7492: iconst_1
    //   7493: if_icmpne +128 -> 7621
    //   7496: aload_0
    //   7497: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7500: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7503: astore 28
    //   7505: aconst_null
    //   7506: astore_1
    //   7507: aload 28
    //   7509: aload 29
    //   7511: getfield 2662	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7514: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7517: ifeq +124 -> 7641
    //   7520: aload 29
    //   7522: getfield 2674	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   7525: astore_1
    //   7526: ldc_w 2726
    //   7529: invokestatic 2729	alud:a	(I)Ljava/lang/String;
    //   7532: astore 28
    //   7534: ldc_w 2730
    //   7537: invokestatic 2729	alud:a	(I)Ljava/lang/String;
    //   7540: astore 30
    //   7542: aload 29
    //   7544: aload_0
    //   7545: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7548: aload_1
    //   7549: invokevirtual 2733	com/tencent/mobileqq/data/MessageForQQWalletTips:getQQWalletTips	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   7552: astore 31
    //   7554: aload 29
    //   7556: astore_1
    //   7557: aload 31
    //   7559: invokestatic 673	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7562: ifne +59 -> 7621
    //   7565: aload 31
    //   7567: aload 28
    //   7569: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7572: ifne +16 -> 7588
    //   7575: aload 29
    //   7577: astore_1
    //   7578: aload 31
    //   7580: aload 30
    //   7582: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7585: ifeq +36 -> 7621
    //   7588: aload 29
    //   7590: aload_0
    //   7591: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7594: aload 31
    //   7596: aload 29
    //   7598: getfield 2736	com/tencent/mobileqq/data/MessageForQQWalletTips:highLightStart	I
    //   7601: aload 29
    //   7603: getfield 2739	com/tencent/mobileqq/data/MessageForQQWalletTips:highLightEnd	I
    //   7606: aload 29
    //   7608: getfield 2742	com/tencent/mobileqq/data/MessageForQQWalletTips:textColor	Ljava/lang/String;
    //   7611: aload 29
    //   7613: getfield 2745	com/tencent/mobileqq/data/MessageForQQWalletTips:url	Ljava/lang/String;
    //   7616: invokevirtual 2749	com/tencent/mobileqq/data/MessageForQQWalletTips:addQQWalletTips	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V
    //   7619: aconst_null
    //   7620: astore_1
    //   7621: aload_1
    //   7622: areturn
    //   7623: aload 29
    //   7625: getfield 2662	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7628: astore 28
    //   7630: goto -308 -> 7322
    //   7633: astore_1
    //   7634: aload_1
    //   7635: invokevirtual 1314	java/lang/Exception:printStackTrace	()V
    //   7638: goto -171 -> 7467
    //   7641: aload 28
    //   7643: aload 29
    //   7645: getfield 2668	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   7648: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7651: ifeq -125 -> 7526
    //   7654: aload 29
    //   7656: getfield 2680	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   7659: astore_1
    //   7660: goto -134 -> 7526
    //   7663: aload 32
    //   7665: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7668: ldc2_w 2750
    //   7671: lcmp
    //   7672: ifne +76 -> 7748
    //   7675: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7678: ifeq +13 -> 7691
    //   7681: ldc_w 2753
    //   7684: iconst_2
    //   7685: ldc_w 2755
    //   7688: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7691: new 2757	tencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody
    //   7694: dup
    //   7695: invokespecial 2758	tencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody:<init>	()V
    //   7698: aload 32
    //   7700: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7703: invokevirtual 2759	tencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7706: checkcast 2757	tencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody
    //   7709: astore_1
    //   7710: aload_0
    //   7711: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7714: bipush 85
    //   7716: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   7719: checkcast 2761	bfzp
    //   7722: aload_1
    //   7723: invokevirtual 2764	bfzp:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody;)V
    //   7726: aconst_null
    //   7727: areturn
    //   7728: astore_1
    //   7729: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7732: ifeq -7703 -> 29
    //   7735: ldc_w 520
    //   7738: iconst_2
    //   7739: ldc_w 2766
    //   7742: aload_1
    //   7743: invokestatic 1614	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   7746: aconst_null
    //   7747: areturn
    //   7748: aload 32
    //   7750: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7753: ldc2_w 2767
    //   7756: lcmp
    //   7757: ifne +76 -> 7833
    //   7760: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7763: ifeq +13 -> 7776
    //   7766: ldc_w 2770
    //   7769: iconst_2
    //   7770: ldc_w 2772
    //   7773: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7776: new 2774	tencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody
    //   7779: dup
    //   7780: invokespecial 2775	tencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody:<init>	()V
    //   7783: aload 32
    //   7785: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7788: invokevirtual 2776	tencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7791: checkcast 2774	tencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody
    //   7794: astore_1
    //   7795: aload_0
    //   7796: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7799: bipush 85
    //   7801: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   7804: checkcast 2761	bfzp
    //   7807: aload_1
    //   7808: invokevirtual 2779	bfzp:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody;)V
    //   7811: aconst_null
    //   7812: areturn
    //   7813: astore_1
    //   7814: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7817: ifeq -7788 -> 29
    //   7820: ldc_w 520
    //   7823: iconst_2
    //   7824: ldc_w 2781
    //   7827: aload_1
    //   7828: invokestatic 1614	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   7831: aconst_null
    //   7832: areturn
    //   7833: aload 32
    //   7835: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7838: ldc2_w 2782
    //   7841: lcmp
    //   7842: ifne +357 -> 8199
    //   7845: new 2785	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody
    //   7848: dup
    //   7849: invokespecial 2786	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:<init>	()V
    //   7852: astore 31
    //   7854: sipush -2029
    //   7857: invokestatic 1233	azaf:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7860: checkcast 2655	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   7863: astore 30
    //   7865: aload 31
    //   7867: aload 32
    //   7869: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7872: invokevirtual 2787	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7875: pop
    //   7876: iconst_0
    //   7877: istore 5
    //   7879: ldc 140
    //   7881: astore 29
    //   7883: aload 29
    //   7885: astore 28
    //   7887: iload 5
    //   7889: istore 4
    //   7891: aload 31
    //   7893: getfield 2791	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:sint32_sessiontype	Lcom/tencent/mobileqq/pb/PBSInt32Field;
    //   7896: invokevirtual 2794	com/tencent/mobileqq/pb/PBSInt32Field:get	()I
    //   7899: tableswitch	default:+9456 -> 17355, 3:+240->8139, 4:+261->8160, 5:+29->7928, 6:+9470->17369
    //   7929: lload_0
    //   7930: new 88	java/lang/StringBuilder
    //   7933: dup
    //   7934: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   7937: aload 31
    //   7939: getfield 2795	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7942: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7945: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7948: ldc 140
    //   7950: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7953: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7956: putfield 2662	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7959: aload 30
    //   7961: new 88	java/lang/StringBuilder
    //   7964: dup
    //   7965: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   7968: aload 31
    //   7970: getfield 2796	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_receiver_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7973: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7976: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7979: ldc 140
    //   7981: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7984: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7987: putfield 2668	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   7990: aload 30
    //   7992: aload 31
    //   7994: getfield 2797	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:bytes_sender_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7997: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8000: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8003: putfield 2674	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   8006: aload 30
    //   8008: aload 31
    //   8010: getfield 2798	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:bytes_receiver_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8013: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8016: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8019: putfield 2680	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   8022: aload 30
    //   8024: aload 31
    //   8026: getfield 2799	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:bytes_authkey	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8029: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8032: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8035: putfield 2686	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   8038: aload_0
    //   8039: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8042: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   8045: astore 31
    //   8047: aload_0
    //   8048: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8051: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   8054: aload 30
    //   8056: getfield 2662	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   8059: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8062: ifeq +119 -> 8181
    //   8065: aload 30
    //   8067: getfield 2668	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   8070: astore 29
    //   8072: aload 30
    //   8074: aload 31
    //   8076: aload 29
    //   8078: aload 28
    //   8080: ldc_w 2703
    //   8083: aload_1
    //   8084: invokevirtual 2706	OnlinePushPack/MsgInfo:getUMsgTime	()J
    //   8087: sipush -2029
    //   8090: iload 4
    //   8092: aload_1
    //   8093: invokevirtual 2709	OnlinePushPack/MsgInfo:getShMsgSeq	()S
    //   8096: i2l
    //   8097: invokevirtual 2710	com/tencent/mobileqq/data/MessageForQQWalletTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   8100: aload 30
    //   8102: iconst_1
    //   8103: putfield 2711	com/tencent/mobileqq/data/MessageForQQWalletTips:isread	Z
    //   8106: aload 30
    //   8108: aload_1
    //   8109: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   8112: i2l
    //   8113: putfield 2712	com/tencent/mobileqq/data/MessageForQQWalletTips:shmsgseq	J
    //   8116: aload 30
    //   8118: aload_1
    //   8119: getfield 1208	OnlinePushPack/MsgInfo:lMsgUid	J
    //   8122: putfield 2713	com/tencent/mobileqq/data/MessageForQQWalletTips:msgUid	J
    //   8125: aload 30
    //   8127: invokevirtual 2716	com/tencent/mobileqq/data/MessageForQQWalletTips:getBytes	()[B
    //   8130: pop
    //   8131: aload 30
    //   8133: invokevirtual 2719	com/tencent/mobileqq/data/MessageForQQWalletTips:onReceiveGrapTips	()V
    //   8136: goto +9230 -> 17366
    //   8139: sipush 1000
    //   8142: istore 4
    //   8144: aload 31
    //   8146: getfield 2802	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_group_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8149: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8152: invokestatic 495	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   8155: astore 28
    //   8157: goto -229 -> 7928
    //   8160: sipush 1004
    //   8163: istore 4
    //   8165: aload 31
    //   8167: getfield 2802	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_group_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8170: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8173: invokestatic 495	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   8176: astore 28
    //   8178: goto -250 -> 7928
    //   8181: aload 30
    //   8183: getfield 2662	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   8186: astore 29
    //   8188: goto -116 -> 8072
    //   8191: astore_1
    //   8192: aload_1
    //   8193: invokevirtual 1314	java/lang/Exception:printStackTrace	()V
    //   8196: goto +9170 -> 17366
    //   8199: aload 32
    //   8201: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8204: ldc2_w 2803
    //   8207: lcmp
    //   8208: ifne +305 -> 8513
    //   8211: aload_0
    //   8212: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8215: bipush 51
    //   8217: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   8220: checkcast 125	alto
    //   8223: astore 34
    //   8225: new 2806	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody
    //   8228: dup
    //   8229: invokespecial 2807	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:<init>	()V
    //   8232: astore 33
    //   8234: sipush -2029
    //   8237: invokestatic 1233	azaf:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   8240: checkcast 2655	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   8243: astore 31
    //   8245: aload 33
    //   8247: aload 32
    //   8249: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8252: invokevirtual 2808	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8255: pop
    //   8256: new 88	java/lang/StringBuilder
    //   8259: dup
    //   8260: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   8263: aload 33
    //   8265: getfield 2809	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:uint64_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8268: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8271: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8274: ldc 140
    //   8276: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8279: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8282: astore 29
    //   8284: new 88	java/lang/StringBuilder
    //   8287: dup
    //   8288: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   8291: aload 33
    //   8293: getfield 2810	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:uint64_receiver_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8296: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8299: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8302: ldc 140
    //   8304: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8307: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8310: astore 30
    //   8312: aload_0
    //   8313: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8316: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   8319: aload 29
    //   8321: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8324: ifeq +166 -> 8490
    //   8327: aload 30
    //   8329: astore 28
    //   8331: aload 34
    //   8333: aload 28
    //   8335: invokevirtual 129	alto:e	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   8338: astore 32
    //   8340: aload 32
    //   8342: ifnull +155 -> 8497
    //   8345: aload 32
    //   8347: invokevirtual 146	com/tencent/mobileqq/data/Friends:isFriend	()Z
    //   8350: ifeq +147 -> 8497
    //   8353: iconst_0
    //   8354: istore 4
    //   8356: aload 31
    //   8358: aload 29
    //   8360: putfield 2662	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   8363: aload 31
    //   8365: aload 30
    //   8367: putfield 2668	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   8370: aload 31
    //   8372: aload 33
    //   8374: getfield 2811	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:bytes_sender_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8377: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8380: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8383: putfield 2674	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   8386: aload 31
    //   8388: aload 33
    //   8390: getfield 2812	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:bytes_receiver_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8393: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8396: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8399: putfield 2680	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   8402: aload 31
    //   8404: aload 33
    //   8406: getfield 2813	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:bytes_authkey	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8409: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8412: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8415: putfield 2686	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   8418: aload 31
    //   8420: aload_0
    //   8421: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8424: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   8427: aload 28
    //   8429: ldc 140
    //   8431: ldc_w 2703
    //   8434: aload_1
    //   8435: invokevirtual 2706	OnlinePushPack/MsgInfo:getUMsgTime	()J
    //   8438: sipush -2029
    //   8441: iload 4
    //   8443: aload_1
    //   8444: invokevirtual 2709	OnlinePushPack/MsgInfo:getShMsgSeq	()S
    //   8447: i2l
    //   8448: invokevirtual 2710	com/tencent/mobileqq/data/MessageForQQWalletTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   8451: aload 31
    //   8453: iconst_1
    //   8454: putfield 2711	com/tencent/mobileqq/data/MessageForQQWalletTips:isread	Z
    //   8457: aload 31
    //   8459: aload_1
    //   8460: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   8463: i2l
    //   8464: putfield 2712	com/tencent/mobileqq/data/MessageForQQWalletTips:shmsgseq	J
    //   8467: aload 31
    //   8469: aload_1
    //   8470: getfield 1208	OnlinePushPack/MsgInfo:lMsgUid	J
    //   8473: putfield 2713	com/tencent/mobileqq/data/MessageForQQWalletTips:msgUid	J
    //   8476: aload 31
    //   8478: invokevirtual 2716	com/tencent/mobileqq/data/MessageForQQWalletTips:getBytes	()[B
    //   8481: pop
    //   8482: aload 31
    //   8484: invokevirtual 2719	com/tencent/mobileqq/data/MessageForQQWalletTips:onReceiveGrapTips	()V
    //   8487: aload 31
    //   8489: areturn
    //   8490: aload 29
    //   8492: astore 28
    //   8494: goto -163 -> 8331
    //   8497: sipush 1001
    //   8500: istore 4
    //   8502: goto -146 -> 8356
    //   8505: astore_1
    //   8506: aload_1
    //   8507: invokevirtual 1314	java/lang/Exception:printStackTrace	()V
    //   8510: goto -23 -> 8487
    //   8513: aload 32
    //   8515: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8518: ldc2_w 2814
    //   8521: lcmp
    //   8522: ifne +62 -> 8584
    //   8525: aload_0
    //   8526: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8529: bipush 62
    //   8531: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   8534: checkcast 2817	ampf
    //   8537: aload 32
    //   8539: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8542: invokevirtual 2818	ampf:a	([B)V
    //   8545: aload_1
    //   8546: getfield 1157	OnlinePushPack/MsgInfo:lFromUin	J
    //   8549: lstore_2
    //   8550: aload_1
    //   8551: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   8554: istore 4
    //   8556: aload_1
    //   8557: getfield 1208	OnlinePushPack/MsgInfo:lMsgUid	J
    //   8560: lstore 15
    //   8562: aload_1
    //   8563: getfield 1154	OnlinePushPack/MsgInfo:shMsgType	S
    //   8566: istore 5
    //   8568: aload_0
    //   8569: getfield 1471	abtl:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   8572: lload_2
    //   8573: iload 4
    //   8575: lload 15
    //   8577: iload 5
    //   8579: invokestatic 1881	azad:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   8582: aconst_null
    //   8583: areturn
    //   8584: aload 32
    //   8586: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8589: ldc2_w 2819
    //   8592: lcmp
    //   8593: ifne +114 -> 8707
    //   8596: new 2822	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody
    //   8599: dup
    //   8600: invokespecial 2823	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:<init>	()V
    //   8603: astore_1
    //   8604: aload_1
    //   8605: aload 32
    //   8607: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8610: invokevirtual 2824	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8613: pop
    //   8614: aload_1
    //   8615: getfield 2827	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:uint64_friend_msg_type_flag	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8618: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   8621: ifeq +34 -> 8655
    //   8624: aload_1
    //   8625: getfield 2827	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:uint64_friend_msg_type_flag	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8628: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8631: lconst_1
    //   8632: lcmp
    //   8633: ifne +68 -> 8701
    //   8636: iconst_1
    //   8637: istore 4
    //   8639: iload 4
    //   8641: ifeq +14 -> 8655
    //   8644: aload_0
    //   8645: getfield 1471	abtl:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   8648: invokevirtual 1401	com/tencent/mobileqq/app/MessageHandler:a	()Lamlp;
    //   8651: iconst_2
    //   8652: invokevirtual 1404	amlp:a	(I)V
    //   8655: aload_1
    //   8656: getfield 2830	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:rpt_msg_msg_notify	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   8659: invokevirtual 1940	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   8662: ifeq -8633 -> 29
    //   8665: aload_0
    //   8666: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8669: aload_1
    //   8670: invokestatic 2835	ahle:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ltencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody;)V
    //   8673: aconst_null
    //   8674: areturn
    //   8675: astore_1
    //   8676: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8679: ifeq +13 -> 8692
    //   8682: ldc_w 2440
    //   8685: iconst_2
    //   8686: ldc 140
    //   8688: aload_1
    //   8689: invokestatic 2442	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   8692: new 2444	java/lang/RuntimeException
    //   8695: dup
    //   8696: aload_1
    //   8697: invokespecial 2447	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   8700: athrow
    //   8701: iconst_0
    //   8702: istore 4
    //   8704: goto -65 -> 8639
    //   8707: aload 32
    //   8709: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8712: ldc2_w 2836
    //   8715: lcmp
    //   8716: ifeq +15 -> 8731
    //   8719: aload 32
    //   8721: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8724: ldc2_w 2838
    //   8727: lcmp
    //   8728: ifne +68 -> 8796
    //   8731: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8734: ifeq +13 -> 8747
    //   8737: ldc_w 2841
    //   8740: iconst_2
    //   8741: ldc_w 2843
    //   8744: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8747: new 2845	tencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody
    //   8750: dup
    //   8751: invokespecial 2846	tencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody:<init>	()V
    //   8754: astore_1
    //   8755: aload_1
    //   8756: aload 32
    //   8758: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8761: invokevirtual 2847	tencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8764: pop
    //   8765: aload_0
    //   8766: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8769: aload_1
    //   8770: lconst_0
    //   8771: iconst_0
    //   8772: invokestatic 2850	azad:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ltencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody;JZ)V
    //   8775: aconst_null
    //   8776: areturn
    //   8777: astore_1
    //   8778: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8781: ifeq -8752 -> 29
    //   8784: ldc_w 2841
    //   8787: iconst_2
    //   8788: ldc_w 2852
    //   8791: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8794: aconst_null
    //   8795: areturn
    //   8796: aload 32
    //   8798: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8801: ldc2_w 2853
    //   8804: lcmp
    //   8805: ifne +25 -> 8830
    //   8808: aload_0
    //   8809: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8812: bipush 51
    //   8814: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   8817: checkcast 2224	ztp
    //   8820: aload 32
    //   8822: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8825: invokevirtual 2855	ztp:a	([B)V
    //   8828: aconst_null
    //   8829: areturn
    //   8830: aload 32
    //   8832: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8835: ldc2_w 2856
    //   8838: lcmp
    //   8839: ifne +24 -> 8863
    //   8842: iconst_2
    //   8843: invokestatic 2863	com/tencent/mqp/app/sec/d:x	()[Ljava/lang/Object;
    //   8846: aload 32
    //   8848: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8851: invokestatic 2867	com/tencent/mqp/app/sec/d:e1	(I[Ljava/lang/Object;[B)V
    //   8854: aconst_null
    //   8855: areturn
    //   8856: astore_1
    //   8857: aload_1
    //   8858: invokevirtual 2868	java/lang/Throwable:printStackTrace	()V
    //   8861: aconst_null
    //   8862: areturn
    //   8863: aload 32
    //   8865: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8868: ldc2_w 2869
    //   8871: lcmp
    //   8872: ifne +182 -> 9054
    //   8875: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8878: ifeq +13 -> 8891
    //   8881: ldc_w 520
    //   8884: iconst_4
    //   8885: ldc_w 2872
    //   8888: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8891: new 2874	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody
    //   8894: dup
    //   8895: invokespecial 2875	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:<init>	()V
    //   8898: astore_1
    //   8899: aload_1
    //   8900: aload 32
    //   8902: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8905: invokevirtual 2876	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8908: pop
    //   8909: new 325	android/content/Intent
    //   8912: dup
    //   8913: ldc_w 2878
    //   8916: invokespecial 329	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   8919: astore 28
    //   8921: aload_1
    //   8922: getfield 2881	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:uint32_push_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8925: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   8928: ifeq +114 -> 9042
    //   8931: aload_1
    //   8932: getfield 2881	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:uint32_push_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8935: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   8938: tableswitch	default:+8443 -> 17381, 0:+80->9018, 1:+92->9030
    //   8961: iload_2
    //   8962: ldc_w 2883
    //   8965: invokevirtual 2886	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   8968: pop
    //   8969: aload 28
    //   8971: ldc_w 2888
    //   8974: aload_1
    //   8975: getfield 2891	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:string_push_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   8978: invokevirtual 1803	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   8981: invokevirtual 474	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8984: pop
    //   8985: aload_0
    //   8986: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8989: invokevirtual 353	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8992: aload 28
    //   8994: invokevirtual 357	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   8997: aconst_null
    //   8998: areturn
    //   8999: astore_1
    //   9000: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9003: ifeq -8974 -> 29
    //   9006: ldc_w 520
    //   9009: iconst_4
    //   9010: ldc_w 2893
    //   9013: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9016: aconst_null
    //   9017: areturn
    //   9018: aload 28
    //   9020: ldc_w 2883
    //   9023: invokevirtual 2886	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   9026: pop
    //   9027: goto -58 -> 8969
    //   9030: aload 28
    //   9032: ldc_w 2895
    //   9035: invokevirtual 2886	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   9038: pop
    //   9039: goto -70 -> 8969
    //   9042: aload 28
    //   9044: ldc_w 2883
    //   9047: invokevirtual 2886	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   9050: pop
    //   9051: goto -82 -> 8969
    //   9054: aload 32
    //   9056: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   9059: ldc2_w 2896
    //   9062: lcmp
    //   9063: ifne +240 -> 9303
    //   9066: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9069: ifeq +13 -> 9082
    //   9072: ldc_w 520
    //   9075: iconst_2
    //   9076: ldc_w 2899
    //   9079: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9082: new 2901	tencent/im/s2c/msgtype0x210/submsgtype0xce/submsgtype0xce$MsgBody
    //   9085: dup
    //   9086: invokespecial 2902	tencent/im/s2c/msgtype0x210/submsgtype0xce/submsgtype0xce$MsgBody:<init>	()V
    //   9089: astore_1
    //   9090: aload_1
    //   9091: aload 32
    //   9093: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   9096: invokevirtual 2903	tencent/im/s2c/msgtype0x210/submsgtype0xce/submsgtype0xce$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   9099: pop
    //   9100: aload_1
    //   9101: getfield 2906	tencent/im/s2c/msgtype0x210/submsgtype0xce/submsgtype0xce$MsgBody:string_params	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9104: invokevirtual 1803	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9107: astore_1
    //   9108: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9111: ifeq +29 -> 9140
    //   9114: ldc_w 520
    //   9117: new 88	java/lang/StringBuilder
    //   9120: dup
    //   9121: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   9124: ldc_w 2908
    //   9127: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9130: aload_1
    //   9131: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9134: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9137: invokestatic 2912	bfrz:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   9140: new 2509	org/json/JSONObject
    //   9143: dup
    //   9144: aload_1
    //   9145: invokespecial 2513	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9148: ldc_w 2914
    //   9151: invokevirtual 2522	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9154: astore 28
    //   9156: ldc_w 2916
    //   9159: invokestatic 2919	aahi:a	(Ljava/lang/String;)Ljava/lang/String;
    //   9162: ldc_w 2921
    //   9165: invokevirtual 2925	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   9168: astore 29
    //   9170: iconst_0
    //   9171: istore 6
    //   9173: iconst_0
    //   9174: istore 4
    //   9176: iload 6
    //   9178: istore 5
    //   9180: iload 4
    //   9182: aload 29
    //   9184: arraylength
    //   9185: if_icmpge +38 -> 9223
    //   9188: aload 29
    //   9190: iload 4
    //   9192: aaload
    //   9193: invokestatic 673	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9196: ifne +98 -> 9294
    //   9199: aload 28
    //   9201: invokestatic 673	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9204: ifne +90 -> 9294
    //   9207: aload 29
    //   9209: iload 4
    //   9211: aaload
    //   9212: aload 28
    //   9214: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9217: ifeq +77 -> 9294
    //   9220: iconst_1
    //   9221: istore 5
    //   9223: iload 5
    //   9225: ifne +33 -> 9258
    //   9228: aload 28
    //   9230: invokestatic 673	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9233: ifne +25 -> 9258
    //   9236: aload 28
    //   9238: ldc_w 2927
    //   9241: invokestatic 2929	aahi:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   9244: pop
    //   9245: aload 28
    //   9247: aload_1
    //   9248: ldc_w 2931
    //   9251: invokestatic 2934	aahi:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   9254: pop
    //   9255: invokestatic 2938	aahe:a	()V
    //   9258: invokestatic 2941	com/tencent/gamecenter/appointment/GameCenterCheck:b	()V
    //   9261: aload_0
    //   9262: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9265: ldc_w 2943
    //   9268: ldc_w 2945
    //   9271: aload 28
    //   9273: ldc_w 2947
    //   9276: ldc_w 2949
    //   9279: ldc_w 2951
    //   9282: invokestatic 2954	aahi:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   9285: aconst_null
    //   9286: areturn
    //   9287: astore_1
    //   9288: aload_1
    //   9289: invokevirtual 1314	java/lang/Exception:printStackTrace	()V
    //   9292: aconst_null
    //   9293: areturn
    //   9294: iload 4
    //   9296: iconst_1
    //   9297: iadd
    //   9298: istore 4
    //   9300: goto -124 -> 9176
    //   9303: aload 32
    //   9305: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   9308: ldc2_w 2955
    //   9311: lcmp
    //   9312: ifne +58 -> 9370
    //   9315: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9318: ifeq +13 -> 9331
    //   9321: ldc_w 520
    //   9324: iconst_2
    //   9325: ldc_w 2958
    //   9328: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9331: new 2960	tencent/im/s2c/msgtype0x210/submsgtype0x11c/MsgBody
    //   9334: dup
    //   9335: invokespecial 2961	tencent/im/s2c/msgtype0x210/submsgtype0x11c/MsgBody:<init>	()V
    //   9338: astore_1
    //   9339: aload_1
    //   9340: aload 32
    //   9342: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   9345: invokevirtual 2962	tencent/im/s2c/msgtype0x210/submsgtype0x11c/MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   9348: pop
    //   9349: aload_0
    //   9350: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9353: bipush 12
    //   9355: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9358: checkcast 1543	azbi
    //   9361: aload_1
    //   9362: invokevirtual 2965	azbi:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x11c/MsgBody;)V
    //   9365: aconst_null
    //   9366: areturn
    //   9367: astore_1
    //   9368: aconst_null
    //   9369: areturn
    //   9370: aload 32
    //   9372: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   9375: ldc2_w 2966
    //   9378: lcmp
    //   9379: ifne +1451 -> 10830
    //   9382: new 2969	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody
    //   9385: dup
    //   9386: invokespecial 2970	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:<init>	()V
    //   9389: astore 28
    //   9391: aload 28
    //   9393: aload 32
    //   9395: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   9398: invokevirtual 2971	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   9401: pop
    //   9402: aload 28
    //   9404: getfield 2974	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_folder_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9407: invokevirtual 2106	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   9410: ifeq +1201 -> 10611
    //   9413: aload 28
    //   9415: getfield 2974	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_folder_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9418: invokevirtual 1803	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9421: invokevirtual 2977	java/lang/String:trim	()Ljava/lang/String;
    //   9424: astore_1
    //   9425: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9428: ifeq +30 -> 9458
    //   9431: ldc_w 2979
    //   9434: iconst_2
    //   9435: new 88	java/lang/StringBuilder
    //   9438: dup
    //   9439: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   9442: ldc_w 2981
    //   9445: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9448: aload_1
    //   9449: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9452: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9455: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9458: aload 28
    //   9460: getfield 2984	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_discover_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9463: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9466: iconst_1
    //   9467: if_icmpne +1150 -> 10617
    //   9470: iconst_1
    //   9471: istore 22
    //   9473: aload 28
    //   9475: getfield 2987	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_folder_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9478: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9481: iconst_1
    //   9482: if_icmpne +1141 -> 10623
    //   9485: iconst_1
    //   9486: istore 23
    //   9488: aload 28
    //   9490: getfield 2990	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_discount_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9493: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9496: iconst_1
    //   9497: if_icmpne +1132 -> 10629
    //   9500: iconst_1
    //   9501: istore 20
    //   9503: aload 28
    //   9505: getfield 2993	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_nearby_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9508: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9511: iconst_1
    //   9512: if_icmpne +1123 -> 10635
    //   9515: iconst_1
    //   9516: istore 19
    //   9518: aload 28
    //   9520: getfield 2996	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_mine_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9523: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9526: iconst_1
    //   9527: if_icmpne +1114 -> 10641
    //   9530: iconst_1
    //   9531: istore 21
    //   9533: aload 28
    //   9535: getfield 2999	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_start_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9538: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9541: istore 6
    //   9543: aload 28
    //   9545: getfield 3002	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_end_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9548: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9551: istore 7
    //   9553: invokestatic 512	java/lang/System:currentTimeMillis	()J
    //   9556: ldc2_w 938
    //   9559: ldiv
    //   9560: l2i
    //   9561: istore 8
    //   9563: aload 28
    //   9565: getfield 3005	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_period_of_validity	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9568: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9571: istore 5
    //   9573: aload 28
    //   9575: getfield 3008	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_task_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9578: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9581: istore 9
    //   9583: aload 28
    //   9585: getfield 3011	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_task_info	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9588: invokevirtual 1803	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9591: astore 31
    //   9593: aload 28
    //   9595: getfield 3014	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_type_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9598: invokevirtual 1803	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9601: astore 32
    //   9603: aload 28
    //   9605: getfield 3017	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_type_color	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9608: invokevirtual 1803	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9611: astore 33
    //   9613: aload 28
    //   9615: getfield 3020	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_jump_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9618: invokevirtual 1803	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9621: astore 29
    //   9623: aload 28
    //   9625: getfield 3023	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9628: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9631: istore 10
    //   9633: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9636: ifeq +163 -> 9799
    //   9639: ldc_w 2979
    //   9642: iconst_2
    //   9643: new 88	java/lang/StringBuilder
    //   9646: dup
    //   9647: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   9650: ldc_w 3025
    //   9653: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9656: iload 6
    //   9658: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9661: ldc_w 3027
    //   9664: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9667: iload 7
    //   9669: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9672: ldc_w 3029
    //   9675: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9678: iload 5
    //   9680: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9683: ldc_w 3031
    //   9686: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9689: iload 23
    //   9691: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9694: ldc_w 3033
    //   9697: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9700: iload 22
    //   9702: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9705: ldc_w 3033
    //   9708: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9711: iload 20
    //   9713: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9716: ldc_w 3033
    //   9719: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9722: iload 19
    //   9724: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9727: ldc_w 3033
    //   9730: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9733: iload 21
    //   9735: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9738: ldc_w 3035
    //   9741: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9744: iload 9
    //   9746: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9749: ldc_w 3037
    //   9752: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9755: aload 31
    //   9757: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9760: ldc_w 3039
    //   9763: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9766: aload 32
    //   9768: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9771: ldc_w 3041
    //   9774: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9777: aload 33
    //   9779: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9782: ldc_w 3043
    //   9785: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9788: aload 29
    //   9790: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9793: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9796: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9799: iload 8
    //   9801: iload 6
    //   9803: if_icmplt -9774 -> 29
    //   9806: iload 8
    //   9808: iload 7
    //   9810: if_icmpgt -9781 -> 29
    //   9813: iload 5
    //   9815: istore 4
    //   9817: iload 5
    //   9819: ldc_w 3044
    //   9822: if_icmple +8 -> 9830
    //   9825: ldc_w 3044
    //   9828: istore 4
    //   9830: iload 22
    //   9832: ifne +18 -> 9850
    //   9835: iload 20
    //   9837: ifne +13 -> 9850
    //   9840: iload 19
    //   9842: ifne +8 -> 9850
    //   9845: iload 21
    //   9847: ifeq +7444 -> 17291
    //   9850: iconst_1
    //   9851: istore 23
    //   9853: iload 23
    //   9855: ifne +7417 -> 17272
    //   9858: iload 22
    //   9860: ifne +15 -> 9875
    //   9863: aload 28
    //   9865: getfield 3047	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_discover_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9868: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9871: iconst_1
    //   9872: if_icmpne +775 -> 10647
    //   9875: iconst_1
    //   9876: istore 22
    //   9878: iload 20
    //   9880: ifne +15 -> 9895
    //   9883: aload 28
    //   9885: getfield 3050	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_discount_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9888: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9891: iconst_1
    //   9892: if_icmpne +761 -> 10653
    //   9895: iconst_1
    //   9896: istore 20
    //   9898: iload 19
    //   9900: ifne +15 -> 9915
    //   9903: aload 28
    //   9905: getfield 3053	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_nearby_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9908: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9911: iconst_1
    //   9912: if_icmpne +747 -> 10659
    //   9915: iconst_1
    //   9916: istore 19
    //   9918: iload 21
    //   9920: ifne +15 -> 9935
    //   9923: aload 28
    //   9925: getfield 3056	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_mine_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9928: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9931: iconst_1
    //   9932: if_icmpne +733 -> 10665
    //   9935: iconst_1
    //   9936: istore 21
    //   9938: iload 21
    //   9940: istore 24
    //   9942: iload 22
    //   9944: istore 25
    //   9946: iload 20
    //   9948: istore 26
    //   9950: iload 19
    //   9952: istore 27
    //   9954: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9957: ifeq +80 -> 10037
    //   9960: ldc_w 2979
    //   9963: iconst_2
    //   9964: new 88	java/lang/StringBuilder
    //   9967: dup
    //   9968: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   9971: ldc_w 3058
    //   9974: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9977: iload 22
    //   9979: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9982: ldc_w 3033
    //   9985: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9988: iload 20
    //   9990: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9993: ldc_w 3033
    //   9996: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9999: iload 19
    //   10001: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10004: ldc_w 3033
    //   10007: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10010: iload 21
    //   10012: invokevirtual 290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10015: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10018: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   10021: iload 19
    //   10023: istore 27
    //   10025: iload 20
    //   10027: istore 26
    //   10029: iload 22
    //   10031: istore 25
    //   10033: iload 21
    //   10035: istore 24
    //   10037: aload_0
    //   10038: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10041: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   10044: astore 30
    //   10046: aload 30
    //   10048: astore 28
    //   10050: aload 30
    //   10052: invokestatic 673	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10055: ifeq +8 -> 10063
    //   10058: ldc_w 3060
    //   10061: astore 28
    //   10063: aload_0
    //   10064: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10067: invokevirtual 353	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10070: new 88	java/lang/StringBuilder
    //   10073: dup
    //   10074: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   10077: ldc_w 3062
    //   10080: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10083: aload 28
    //   10085: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10088: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10091: iconst_0
    //   10092: invokevirtual 1033	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   10095: astore 30
    //   10097: aload 30
    //   10099: invokeinterface 429 1 0
    //   10104: astore 28
    //   10106: aload 30
    //   10108: ldc_w 3064
    //   10111: iconst_0
    //   10112: invokeinterface 3068 3 0
    //   10117: ifne +59 -> 10176
    //   10120: aload 30
    //   10122: ldc_w 3070
    //   10125: iconst_0
    //   10126: invokeinterface 3068 3 0
    //   10131: ifne +45 -> 10176
    //   10134: aload 30
    //   10136: ldc_w 3072
    //   10139: iconst_0
    //   10140: invokeinterface 3068 3 0
    //   10145: ifne +31 -> 10176
    //   10148: aload 30
    //   10150: ldc_w 3074
    //   10153: iconst_0
    //   10154: invokeinterface 3068 3 0
    //   10159: ifne +17 -> 10176
    //   10162: aload 30
    //   10164: ldc_w 3076
    //   10167: iconst_0
    //   10168: invokeinterface 3068 3 0
    //   10173: ifeq +109 -> 10282
    //   10176: aload 30
    //   10178: ldc_w 3078
    //   10181: iconst_0
    //   10182: invokeinterface 444 3 0
    //   10187: istore 5
    //   10189: aload 30
    //   10191: ldc_w 3080
    //   10194: iconst_0
    //   10195: invokeinterface 444 3 0
    //   10200: istore 11
    //   10202: aload 30
    //   10204: ldc_w 3082
    //   10207: iconst_0
    //   10208: invokeinterface 444 3 0
    //   10213: istore 12
    //   10215: aload 30
    //   10217: ldc_w 3084
    //   10220: iconst_0
    //   10221: invokeinterface 444 3 0
    //   10226: istore 13
    //   10228: invokestatic 512	java/lang/System:currentTimeMillis	()J
    //   10231: ldc2_w 938
    //   10234: ldiv
    //   10235: l2i
    //   10236: istore 14
    //   10238: iload 14
    //   10240: ifeq +42 -> 10282
    //   10243: iload 11
    //   10245: ifeq +37 -> 10282
    //   10248: iload 12
    //   10250: ifeq +32 -> 10282
    //   10253: iload 13
    //   10255: ifeq +27 -> 10282
    //   10258: iload 14
    //   10260: iload 11
    //   10262: if_icmplt +409 -> 10671
    //   10265: iload 14
    //   10267: iload 12
    //   10269: if_icmpgt +402 -> 10671
    //   10272: iload 14
    //   10274: iload 5
    //   10276: isub
    //   10277: iload 13
    //   10279: if_icmpge +392 -> 10671
    //   10282: aload 28
    //   10284: ldc_w 3080
    //   10287: iload 6
    //   10289: invokeinterface 437 3 0
    //   10294: pop
    //   10295: aload 28
    //   10297: ldc_w 3082
    //   10300: iload 7
    //   10302: invokeinterface 437 3 0
    //   10307: pop
    //   10308: aload 28
    //   10310: ldc_w 3084
    //   10313: iload 4
    //   10315: invokeinterface 437 3 0
    //   10320: pop
    //   10321: aload 28
    //   10323: ldc_w 3086
    //   10326: aload_1
    //   10327: invokeinterface 3090 3 0
    //   10332: pop
    //   10333: aload 28
    //   10335: ldc_w 3078
    //   10338: iload 8
    //   10340: invokeinterface 437 3 0
    //   10345: pop
    //   10346: aload 28
    //   10348: ldc_w 3092
    //   10351: iload 9
    //   10353: invokeinterface 437 3 0
    //   10358: pop
    //   10359: aload 28
    //   10361: ldc_w 3094
    //   10364: aload 31
    //   10366: invokeinterface 3090 3 0
    //   10371: pop
    //   10372: aload 28
    //   10374: ldc_w 3096
    //   10377: aload 32
    //   10379: invokeinterface 3090 3 0
    //   10384: pop
    //   10385: aload 28
    //   10387: ldc_w 3098
    //   10390: aload 33
    //   10392: invokeinterface 3090 3 0
    //   10397: pop
    //   10398: aload 28
    //   10400: ldc_w 3100
    //   10403: invokestatic 581	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   10406: invokeinterface 1046 4 0
    //   10411: pop
    //   10412: aload 28
    //   10414: ldc_w 3102
    //   10417: iload 10
    //   10419: invokeinterface 437 3 0
    //   10424: pop
    //   10425: aload 29
    //   10427: ifnonnull +323 -> 10750
    //   10430: ldc 140
    //   10432: astore_1
    //   10433: aload 28
    //   10435: ldc_w 3104
    //   10438: aload_1
    //   10439: invokeinterface 3090 3 0
    //   10444: pop
    //   10445: aload 28
    //   10447: ldc_w 3106
    //   10450: iconst_1
    //   10451: invokeinterface 437 3 0
    //   10456: pop
    //   10457: aload 28
    //   10459: ldc_w 3076
    //   10462: iload 23
    //   10464: invokeinterface 1043 3 0
    //   10469: pop
    //   10470: aload 28
    //   10472: ldc_w 3064
    //   10475: iload 25
    //   10477: invokeinterface 1043 3 0
    //   10482: pop
    //   10483: aload 28
    //   10485: ldc_w 3070
    //   10488: iload 26
    //   10490: invokeinterface 1043 3 0
    //   10495: pop
    //   10496: aload 28
    //   10498: ldc_w 3072
    //   10501: iload 27
    //   10503: invokeinterface 1043 3 0
    //   10508: pop
    //   10509: aload 28
    //   10511: ldc_w 3074
    //   10514: iload 24
    //   10516: invokeinterface 1043 3 0
    //   10521: pop
    //   10522: aload 28
    //   10524: invokeinterface 440 1 0
    //   10529: pop
    //   10530: iload 23
    //   10532: ifeq +224 -> 10756
    //   10535: aload_0
    //   10536: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10539: bipush 88
    //   10541: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10544: checkcast 3108	ntw
    //   10547: invokestatic 581	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   10550: iload 23
    //   10552: invokevirtual 3111	ntw:a	(JZ)V
    //   10555: aload_0
    //   10556: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10559: bipush 68
    //   10561: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   10564: checkcast 3113	nua
    //   10567: invokevirtual 3114	nua:a	()V
    //   10570: aconst_null
    //   10571: astore_1
    //   10572: iload 25
    //   10574: ifeq +208 -> 10782
    //   10577: ldc_w 3116
    //   10580: astore_1
    //   10581: aload_0
    //   10582: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10585: ldc_w 3118
    //   10588: ldc 140
    //   10590: ldc 140
    //   10592: ldc_w 3120
    //   10595: aload_1
    //   10596: iconst_0
    //   10597: iconst_0
    //   10598: ldc 140
    //   10600: ldc 140
    //   10602: ldc 140
    //   10604: ldc 140
    //   10606: invokestatic 1966	azqs:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   10609: aconst_null
    //   10610: areturn
    //   10611: ldc 140
    //   10613: astore_1
    //   10614: goto -1189 -> 9425
    //   10617: iconst_0
    //   10618: istore 22
    //   10620: goto -1147 -> 9473
    //   10623: iconst_0
    //   10624: istore 23
    //   10626: goto -1138 -> 9488
    //   10629: iconst_0
    //   10630: istore 20
    //   10632: goto -1129 -> 9503
    //   10635: iconst_0
    //   10636: istore 19
    //   10638: goto -1120 -> 9518
    //   10641: iconst_0
    //   10642: istore 21
    //   10644: goto -1111 -> 9533
    //   10647: iconst_0
    //   10648: istore 22
    //   10650: goto -772 -> 9878
    //   10653: iconst_0
    //   10654: istore 20
    //   10656: goto -758 -> 9898
    //   10659: iconst_0
    //   10660: istore 19
    //   10662: goto -744 -> 9918
    //   10665: iconst_0
    //   10666: istore 21
    //   10668: goto -730 -> 9938
    //   10671: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10674: ifeq +13 -> 10687
    //   10677: ldc_w 2979
    //   10680: iconst_2
    //   10681: ldc_w 3122
    //   10684: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   10687: aload 28
    //   10689: ldc_w 3064
    //   10692: iconst_0
    //   10693: invokeinterface 1043 3 0
    //   10698: pop
    //   10699: aload 28
    //   10701: ldc_w 3070
    //   10704: iconst_0
    //   10705: invokeinterface 1043 3 0
    //   10710: pop
    //   10711: aload 28
    //   10713: ldc_w 3072
    //   10716: iconst_0
    //   10717: invokeinterface 1043 3 0
    //   10722: pop
    //   10723: aload 28
    //   10725: ldc_w 3074
    //   10728: iconst_0
    //   10729: invokeinterface 1043 3 0
    //   10734: pop
    //   10735: aload 28
    //   10737: ldc_w 3076
    //   10740: iconst_0
    //   10741: invokeinterface 1043 3 0
    //   10746: pop
    //   10747: goto -465 -> 10282
    //   10750: aload 29
    //   10752: astore_1
    //   10753: goto -320 -> 10433
    //   10756: aload_0
    //   10757: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10760: ldc_w 3124
    //   10763: invokevirtual 3128	com/tencent/mobileqq/app/QQAppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   10766: astore_1
    //   10767: aload_1
    //   10768: ifnull -213 -> 10555
    //   10771: aload_1
    //   10772: sipush 1009
    //   10775: invokevirtual 3133	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   10778: pop
    //   10779: goto -224 -> 10555
    //   10782: iload 26
    //   10784: ifeq +10 -> 10794
    //   10787: ldc_w 3135
    //   10790: astore_1
    //   10791: goto -210 -> 10581
    //   10794: iload 27
    //   10796: ifeq +10 -> 10806
    //   10799: ldc_w 3137
    //   10802: astore_1
    //   10803: goto -222 -> 10581
    //   10806: iload 24
    //   10808: ifeq +10 -> 10818
    //   10811: ldc_w 3139
    //   10814: astore_1
    //   10815: goto -234 -> 10581
    //   10818: iload 23
    //   10820: ifeq -239 -> 10581
    //   10823: ldc_w 3141
    //   10826: astore_1
    //   10827: goto -246 -> 10581
    //   10830: aload 32
    //   10832: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   10835: ldc2_w 3142
    //   10838: lcmp
    //   10839: ifne +88 -> 10927
    //   10842: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10845: ifeq +13 -> 10858
    //   10848: ldc_w 520
    //   10851: iconst_2
    //   10852: ldc_w 3145
    //   10855: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10858: aload_0
    //   10859: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10862: sipush 153
    //   10865: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10868: checkcast 605	aknx
    //   10871: astore 28
    //   10873: aload 28
    //   10875: ifnull +13 -> 10888
    //   10878: aload 28
    //   10880: aload 32
    //   10882: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   10885: invokevirtual 3146	aknx:a	([B)V
    //   10888: aload_1
    //   10889: getfield 1157	OnlinePushPack/MsgInfo:lFromUin	J
    //   10892: lstore_2
    //   10893: aload_1
    //   10894: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   10897: istore 4
    //   10899: aload_1
    //   10900: getfield 1208	OnlinePushPack/MsgInfo:lMsgUid	J
    //   10903: lstore 15
    //   10905: aload_1
    //   10906: getfield 1154	OnlinePushPack/MsgInfo:shMsgType	S
    //   10909: istore 5
    //   10911: aload_0
    //   10912: getfield 1471	abtl:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   10915: lload_2
    //   10916: iload 4
    //   10918: lload 15
    //   10920: iload 5
    //   10922: invokestatic 1881	azad:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   10925: aconst_null
    //   10926: areturn
    //   10927: aload 32
    //   10929: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   10932: ldc2_w 3147
    //   10935: lcmp
    //   10936: ifne +56 -> 10992
    //   10939: new 3150	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody
    //   10942: dup
    //   10943: invokespecial 3151	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:<init>	()V
    //   10946: astore_1
    //   10947: aload_1
    //   10948: aload 32
    //   10950: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   10953: invokevirtual 3152	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   10956: pop
    //   10957: aload_1
    //   10958: getfield 3153	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   10961: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   10964: pop2
    //   10965: aload_1
    //   10966: getfield 3156	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   10969: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   10972: pop
    //   10973: aload_1
    //   10974: getfield 3160	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:msg_mod_block	Ltencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock;
    //   10977: invokevirtual 3163	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   10980: checkcast 3162	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock
    //   10983: getfield 3166	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock:uint32_op	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   10986: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   10989: pop
    //   10990: aconst_null
    //   10991: areturn
    //   10992: aload 32
    //   10994: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   10997: ldc2_w 3167
    //   11000: lcmp
    //   11001: ifne +87 -> 11088
    //   11004: new 3170	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody
    //   11007: dup
    //   11008: invokespecial 3171	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:<init>	()V
    //   11011: astore_1
    //   11012: aload_1
    //   11013: aload 32
    //   11015: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11018: invokevirtual 3172	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11021: pop
    //   11022: aload_1
    //   11023: getfield 3175	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:uint32_is_mass_bless_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11026: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   11029: istore 4
    //   11031: iload 4
    //   11033: ifne +26 -> 11059
    //   11036: iconst_1
    //   11037: istore 19
    //   11039: aload_0
    //   11040: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11043: sipush 138
    //   11046: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11049: checkcast 3177	ahcr
    //   11052: iload 19
    //   11054: invokevirtual 3179	ahcr:c	(Z)V
    //   11057: aconst_null
    //   11058: areturn
    //   11059: iconst_0
    //   11060: istore 19
    //   11062: goto -23 -> 11039
    //   11065: astore_1
    //   11066: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11069: ifeq +13 -> 11082
    //   11072: ldc_w 3181
    //   11075: iconst_2
    //   11076: ldc_w 3183
    //   11079: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11082: iconst_1
    //   11083: istore 19
    //   11085: goto -46 -> 11039
    //   11088: aload 32
    //   11090: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11093: ldc2_w 3184
    //   11096: lcmp
    //   11097: ifne +552 -> 11649
    //   11100: iconst_0
    //   11101: istore 19
    //   11103: aload_0
    //   11104: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11107: invokevirtual 353	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11110: ldc_w 3187
    //   11113: invokevirtual 3190	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   11116: checkcast 3192	android/app/ActivityManager
    //   11119: iconst_1
    //   11120: invokevirtual 3196	android/app/ActivityManager:getRunningTasks	(I)Ljava/util/List;
    //   11123: astore_1
    //   11124: aload_1
    //   11125: ifnull +6141 -> 17266
    //   11128: aload_1
    //   11129: invokeinterface 1541 1 0
    //   11134: iconst_1
    //   11135: if_icmplt +6131 -> 17266
    //   11138: aload_1
    //   11139: iconst_0
    //   11140: invokeinterface 2087 2 0
    //   11145: checkcast 3198	android/app/ActivityManager$RunningTaskInfo
    //   11148: getfield 3202	android/app/ActivityManager$RunningTaskInfo:topActivity	Landroid/content/ComponentName;
    //   11151: invokevirtual 3207	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   11154: astore_1
    //   11155: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11158: ifeq +30 -> 11188
    //   11161: ldc_w 520
    //   11164: iconst_2
    //   11165: new 88	java/lang/StringBuilder
    //   11168: dup
    //   11169: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   11172: ldc_w 3209
    //   11175: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11178: aload_1
    //   11179: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11182: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11185: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11188: ldc_w 3211
    //   11191: aload_1
    //   11192: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11195: istore 20
    //   11197: iload 20
    //   11199: istore 19
    //   11201: aload_0
    //   11202: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11205: invokevirtual 353	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11208: ldc_w 3213
    //   11211: invokevirtual 3190	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   11214: checkcast 3215	android/os/PowerManager
    //   11217: invokevirtual 3218	android/os/PowerManager:isScreenOn	()Z
    //   11220: istore 20
    //   11222: iload 20
    //   11224: ifeq +18 -> 11242
    //   11227: aload_0
    //   11228: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11231: getfield 3221	com/tencent/mobileqq/app/QQAppInterface:isBackground_Pause	Z
    //   11234: ifeq -11205 -> 29
    //   11237: iload 19
    //   11239: ifne -11210 -> 29
    //   11242: new 3223	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody
    //   11245: dup
    //   11246: invokespecial 3224	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:<init>	()V
    //   11249: astore 30
    //   11251: aconst_null
    //   11252: astore_1
    //   11253: aconst_null
    //   11254: astore 28
    //   11256: aconst_null
    //   11257: astore 29
    //   11259: aload 30
    //   11261: aload 32
    //   11263: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11266: invokevirtual 3225	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11269: pop
    //   11270: aload 30
    //   11272: getfield 3228	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11275: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   11278: ifeq +15 -> 11293
    //   11281: aload 30
    //   11283: getfield 3228	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11286: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   11289: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   11292: astore_1
    //   11293: aload 30
    //   11295: getfield 3231	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_brief	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11298: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   11301: ifeq +16 -> 11317
    //   11304: aload 30
    //   11306: getfield 3231	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_brief	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11309: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   11312: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   11315: astore 28
    //   11317: aload 30
    //   11319: getfield 3234	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11322: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   11325: ifeq +16 -> 11341
    //   11328: aload 30
    //   11330: getfield 3234	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11333: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   11336: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   11339: astore 29
    //   11341: aload_1
    //   11342: invokestatic 673	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11345: ifne -11316 -> 29
    //   11348: aload 28
    //   11350: invokestatic 673	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11353: ifne -11324 -> 29
    //   11356: aload 29
    //   11358: invokestatic 673	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11361: ifne -11332 -> 29
    //   11364: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11367: ifeq +52 -> 11419
    //   11370: ldc_w 520
    //   11373: iconst_2
    //   11374: new 88	java/lang/StringBuilder
    //   11377: dup
    //   11378: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   11381: ldc_w 3236
    //   11384: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11387: aload_1
    //   11388: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11391: ldc_w 3238
    //   11394: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11397: aload 28
    //   11399: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11402: ldc_w 3240
    //   11405: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11408: aload 29
    //   11410: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11413: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11416: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11419: new 325	android/content/Intent
    //   11422: dup
    //   11423: aload_0
    //   11424: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11427: invokevirtual 353	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11430: ldc_w 3242
    //   11433: invokespecial 3245	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   11436: astore 30
    //   11438: aload 30
    //   11440: ldc_w 3246
    //   11443: aload 29
    //   11445: invokevirtual 474	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11448: pop
    //   11449: aload 30
    //   11451: ldc_w 3248
    //   11454: sipush 3001
    //   11457: invokevirtual 3251	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11460: pop
    //   11461: new 3253	com/tencent/qphone/base/remote/ToServiceMsg
    //   11464: dup
    //   11465: ldc_w 3255
    //   11468: aload_0
    //   11469: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11472: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   11475: ldc_w 3257
    //   11478: invokespecial 3260	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   11481: astore 29
    //   11483: aload 29
    //   11485: getfield 3264	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   11488: ldc_w 3266
    //   11491: iconst_3
    //   11492: anewarray 274	java/lang/String
    //   11495: dup
    //   11496: iconst_0
    //   11497: aload 28
    //   11499: aastore
    //   11500: dup
    //   11501: iconst_1
    //   11502: aload_1
    //   11503: aastore
    //   11504: dup
    //   11505: iconst_2
    //   11506: aload 28
    //   11508: aastore
    //   11509: invokevirtual 3270	android/os/Bundle:putStringArray	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11512: aload 29
    //   11514: getfield 3264	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   11517: ldc_w 3272
    //   11520: aload 30
    //   11522: invokevirtual 3276	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   11525: aload 29
    //   11527: getfield 3264	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   11530: ldc_w 3278
    //   11533: aconst_null
    //   11534: invokevirtual 3276	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   11537: aload_0
    //   11538: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11541: aload 29
    //   11543: invokevirtual 3282	com/tencent/mobileqq/app/QQAppInterface:sendToService	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   11546: aconst_null
    //   11547: ldc_w 3118
    //   11550: ldc 140
    //   11552: ldc 140
    //   11554: ldc_w 3284
    //   11557: ldc_w 3284
    //   11560: iconst_0
    //   11561: iconst_0
    //   11562: ldc 140
    //   11564: ldc 140
    //   11566: ldc 140
    //   11568: ldc 140
    //   11570: invokestatic 1966	azqs:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   11573: aconst_null
    //   11574: areturn
    //   11575: astore_1
    //   11576: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11579: ifeq +13 -> 11592
    //   11582: ldc_w 520
    //   11585: iconst_2
    //   11586: ldc_w 3286
    //   11589: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11592: aload_1
    //   11593: invokevirtual 1314	java/lang/Exception:printStackTrace	()V
    //   11596: aconst_null
    //   11597: areturn
    //   11598: astore_1
    //   11599: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11602: ifeq +13 -> 11615
    //   11605: ldc_w 520
    //   11608: iconst_2
    //   11609: ldc_w 3288
    //   11612: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11615: aload_1
    //   11616: invokevirtual 1314	java/lang/Exception:printStackTrace	()V
    //   11619: goto -418 -> 11201
    //   11622: astore_1
    //   11623: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11626: ifeq +13 -> 11639
    //   11629: ldc_w 520
    //   11632: iconst_2
    //   11633: ldc_w 3290
    //   11636: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11639: aload_1
    //   11640: invokevirtual 1314	java/lang/Exception:printStackTrace	()V
    //   11643: iconst_1
    //   11644: istore 20
    //   11646: goto -424 -> 11222
    //   11649: aload 32
    //   11651: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11654: ldc2_w 3291
    //   11657: lcmp
    //   11658: ifne +29 -> 11687
    //   11661: aload 32
    //   11663: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11666: ifnull +21 -> 11687
    //   11669: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11672: ifeq -11643 -> 29
    //   11675: ldc_w 520
    //   11678: iconst_2
    //   11679: ldc_w 3294
    //   11682: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11685: aconst_null
    //   11686: areturn
    //   11687: aload 32
    //   11689: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11692: ldc2_w 3167
    //   11695: lcmp
    //   11696: ifne +87 -> 11783
    //   11699: new 3170	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody
    //   11702: dup
    //   11703: invokespecial 3171	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:<init>	()V
    //   11706: astore_1
    //   11707: aload_1
    //   11708: aload 32
    //   11710: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11713: invokevirtual 3172	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11716: pop
    //   11717: aload_1
    //   11718: getfield 3175	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:uint32_is_mass_bless_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11721: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   11724: istore 4
    //   11726: iload 4
    //   11728: ifne +26 -> 11754
    //   11731: iconst_1
    //   11732: istore 19
    //   11734: aload_0
    //   11735: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11738: sipush 138
    //   11741: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11744: checkcast 3177	ahcr
    //   11747: iload 19
    //   11749: invokevirtual 3179	ahcr:c	(Z)V
    //   11752: aconst_null
    //   11753: areturn
    //   11754: iconst_0
    //   11755: istore 19
    //   11757: goto -23 -> 11734
    //   11760: astore_1
    //   11761: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11764: ifeq +13 -> 11777
    //   11767: ldc_w 3181
    //   11770: iconst_2
    //   11771: ldc_w 3183
    //   11774: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11777: iconst_1
    //   11778: istore 19
    //   11780: goto -46 -> 11734
    //   11783: aload 32
    //   11785: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11788: ldc2_w 3295
    //   11791: lcmp
    //   11792: ifeq -11763 -> 29
    //   11795: aload 32
    //   11797: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11800: ldc2_w 3297
    //   11803: lcmp
    //   11804: ifeq -11775 -> 29
    //   11807: aload 32
    //   11809: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11812: ldc2_w 3299
    //   11815: lcmp
    //   11816: ifne +75 -> 11891
    //   11819: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11822: ifeq +13 -> 11835
    //   11825: ldc_w 3302
    //   11828: iconst_2
    //   11829: ldc_w 3304
    //   11832: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11835: new 3306	tencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody
    //   11838: dup
    //   11839: invokespecial 3307	tencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody:<init>	()V
    //   11842: astore_1
    //   11843: aload_1
    //   11844: aload 32
    //   11846: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11849: invokevirtual 3308	tencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11852: pop
    //   11853: aload_0
    //   11854: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11857: bipush 20
    //   11859: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   11862: checkcast 1084	amdu
    //   11865: aload_1
    //   11866: invokevirtual 3311	amdu:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody;)V
    //   11869: aconst_null
    //   11870: areturn
    //   11871: astore_1
    //   11872: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11875: ifeq -11846 -> 29
    //   11878: ldc_w 3302
    //   11881: iconst_2
    //   11882: ldc_w 3313
    //   11885: aload_1
    //   11886: invokestatic 3315	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   11889: aconst_null
    //   11890: areturn
    //   11891: aload 32
    //   11893: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11896: ldc2_w 3316
    //   11899: lcmp
    //   11900: ifne +47 -> 11947
    //   11903: new 3319	tencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody
    //   11906: dup
    //   11907: invokespecial 3320	tencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody:<init>	()V
    //   11910: astore_1
    //   11911: aload_1
    //   11912: aload 32
    //   11914: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11917: invokevirtual 3321	tencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11920: pop
    //   11921: aload_0
    //   11922: aload_1
    //   11923: invokevirtual 3324	abtl:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody;)V
    //   11926: aconst_null
    //   11927: areturn
    //   11928: astore_1
    //   11929: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11932: ifeq -11903 -> 29
    //   11935: ldc_w 3326
    //   11938: iconst_2
    //   11939: ldc_w 3328
    //   11942: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11945: aconst_null
    //   11946: areturn
    //   11947: aload 32
    //   11949: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11952: ldc2_w 3329
    //   11955: lcmp
    //   11956: ifne +78 -> 12034
    //   11959: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11962: ifeq +13 -> 11975
    //   11965: ldc_w 3332
    //   11968: iconst_2
    //   11969: ldc_w 3334
    //   11972: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11975: new 3336	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody
    //   11978: dup
    //   11979: invokespecial 3337	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody:<init>	()V
    //   11982: astore_1
    //   11983: aload_1
    //   11984: aload 32
    //   11986: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11989: invokevirtual 3338	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11992: pop
    //   11993: aload_0
    //   11994: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11997: sipush 156
    //   12000: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   12003: checkcast 3340	aspf
    //   12006: aload_1
    //   12007: iconst_0
    //   12008: invokevirtual 3343	aspf:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody;Z)V
    //   12011: aconst_null
    //   12012: areturn
    //   12013: astore 28
    //   12015: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12018: ifeq -25 -> 11993
    //   12021: ldc_w 3332
    //   12024: iconst_2
    //   12025: ldc_w 3345
    //   12028: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12031: goto -38 -> 11993
    //   12034: aload 32
    //   12036: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   12039: ldc2_w 3346
    //   12042: lcmp
    //   12043: ifne +698 -> 12741
    //   12046: new 3349	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody
    //   12049: dup
    //   12050: invokespecial 3350	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:<init>	()V
    //   12053: astore 28
    //   12055: aload 28
    //   12057: aload 32
    //   12059: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   12062: invokevirtual 3351	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12065: pop
    //   12066: aload 28
    //   12068: getfield 3352	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12071: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12074: ifeq +579 -> 12653
    //   12077: aload 28
    //   12079: getfield 3352	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12082: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12085: iconst_2
    //   12086: if_icmpne +567 -> 12653
    //   12089: aload 28
    //   12091: getfield 3356	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:msg_persons_may_know	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2;
    //   12094: getfield 3362	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2:fixed32_timestamp	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   12097: invokevirtual 3365	com/tencent/mobileqq/pb/PBFixed32Field:get	()I
    //   12100: i2l
    //   12101: lstore_2
    //   12102: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12105: ifeq +30 -> 12135
    //   12108: ldc_w 520
    //   12111: iconst_2
    //   12112: new 88	java/lang/StringBuilder
    //   12115: dup
    //   12116: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   12119: ldc_w 3367
    //   12122: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12125: lload_2
    //   12126: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12129: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12132: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12135: aload 28
    //   12137: getfield 3356	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:msg_persons_may_know	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2;
    //   12140: getfield 3370	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2:rpt_msg_friend_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   12143: invokevirtual 45	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   12146: astore 30
    //   12148: aload 30
    //   12150: ifnull +542 -> 12692
    //   12153: aload 30
    //   12155: invokeinterface 1541 1 0
    //   12160: ifle +532 -> 12692
    //   12163: new 655	java/util/ArrayList
    //   12166: dup
    //   12167: aload 30
    //   12169: invokeinterface 1541 1 0
    //   12174: invokespecial 3371	java/util/ArrayList:<init>	(I)V
    //   12177: astore 29
    //   12179: aload 30
    //   12181: invokeinterface 51 1 0
    //   12186: astore 30
    //   12188: aload 30
    //   12190: invokeinterface 56 1 0
    //   12195: ifeq +497 -> 12692
    //   12198: aload 30
    //   12200: invokeinterface 60 1 0
    //   12205: checkcast 3373	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow
    //   12208: astore 31
    //   12210: new 3375	com/tencent/mobileqq/data/PushRecommend
    //   12213: dup
    //   12214: invokespecial 3376	com/tencent/mobileqq/data/PushRecommend:<init>	()V
    //   12217: astore 32
    //   12219: aload 31
    //   12221: getfield 3377	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   12224: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   12227: ifeq +19 -> 12246
    //   12230: aload 32
    //   12232: aload 31
    //   12234: getfield 3377	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   12237: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   12240: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   12243: putfield 3378	com/tencent/mobileqq/data/PushRecommend:uin	Ljava/lang/String;
    //   12246: aload 31
    //   12248: getfield 3381	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12251: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12254: ifeq +26 -> 12280
    //   12257: aload 32
    //   12259: new 274	java/lang/String
    //   12262: dup
    //   12263: aload 31
    //   12265: getfield 3381	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12268: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12271: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12274: invokespecial 1295	java/lang/String:<init>	([B)V
    //   12277: putfield 3384	com/tencent/mobileqq/data/PushRecommend:nick	Ljava/lang/String;
    //   12280: aload 31
    //   12282: getfield 3385	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12285: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12288: ifeq +17 -> 12305
    //   12291: aload 32
    //   12293: aload 31
    //   12295: getfield 3385	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12298: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12301: i2s
    //   12302: putfield 3387	com/tencent/mobileqq/data/PushRecommend:age	S
    //   12305: aload 31
    //   12307: getfield 3390	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_sex	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12310: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12313: ifeq +17 -> 12330
    //   12316: aload 32
    //   12318: aload 31
    //   12320: getfield 3390	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_sex	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12323: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12326: i2s
    //   12327: putfield 3392	com/tencent/mobileqq/data/PushRecommend:gender	S
    //   12330: aload 31
    //   12332: getfield 3395	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_main_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12335: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12338: ifeq +26 -> 12364
    //   12341: aload 32
    //   12343: new 274	java/lang/String
    //   12346: dup
    //   12347: aload 31
    //   12349: getfield 3395	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_main_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12352: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12355: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12358: invokespecial 1295	java/lang/String:<init>	([B)V
    //   12361: putfield 3398	com/tencent/mobileqq/data/PushRecommend:recommendReason	Ljava/lang/String;
    //   12364: aload 31
    //   12366: getfield 3401	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_alghrithm	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12369: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12372: ifeq +19 -> 12391
    //   12375: aload 32
    //   12377: aload 31
    //   12379: getfield 3401	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_alghrithm	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12382: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12385: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12388: putfield 3404	com/tencent/mobileqq/data/PushRecommend:algBuffer	[B
    //   12391: aload 31
    //   12393: getfield 3407	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_soure_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12396: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12399: ifeq +26 -> 12425
    //   12402: aload 32
    //   12404: new 274	java/lang/String
    //   12407: dup
    //   12408: aload 31
    //   12410: getfield 3407	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_soure_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12413: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12416: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12419: invokespecial 1295	java/lang/String:<init>	([B)V
    //   12422: putfield 3410	com/tencent/mobileqq/data/PushRecommend:sourceReason	Ljava/lang/String;
    //   12425: aload 31
    //   12427: getfield 3413	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12430: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12433: ifeq +16 -> 12449
    //   12436: aload 32
    //   12438: aload 31
    //   12440: getfield 3413	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12443: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12446: putfield 3416	com/tencent/mobileqq/data/PushRecommend:fromSource	I
    //   12449: aload 31
    //   12451: getfield 3420	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:msg_android_source	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource;
    //   12454: invokevirtual 3423	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:has	()Z
    //   12457: ifeq +69 -> 12526
    //   12460: aload 31
    //   12462: getfield 3420	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:msg_android_source	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource;
    //   12465: invokevirtual 3424	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12468: checkcast 3422	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource
    //   12471: astore 33
    //   12473: aload 33
    //   12475: ifnull +51 -> 12526
    //   12478: aload 33
    //   12480: getfield 3425	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:uint32_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12483: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12486: ifeq +16 -> 12502
    //   12489: aload 32
    //   12491: aload 33
    //   12493: getfield 3425	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:uint32_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12496: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12499: putfield 3428	com/tencent/mobileqq/data/PushRecommend:sourceId	I
    //   12502: aload 33
    //   12504: getfield 3431	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:uint32_sub_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12507: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12510: ifeq +16 -> 12526
    //   12513: aload 32
    //   12515: aload 33
    //   12517: getfield 3431	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:uint32_sub_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12520: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12523: putfield 3434	com/tencent/mobileqq/data/PushRecommend:subSourceId	I
    //   12526: aload 31
    //   12528: getfield 3437	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_msg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12531: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12534: ifeq +26 -> 12560
    //   12537: aload 32
    //   12539: new 274	java/lang/String
    //   12542: dup
    //   12543: aload 31
    //   12545: getfield 3437	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_msg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12548: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12551: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12554: invokespecial 1295	java/lang/String:<init>	([B)V
    //   12557: putfield 3440	com/tencent/mobileqq/data/PushRecommend:wzryVerifyStr	Ljava/lang/String;
    //   12560: aload 31
    //   12562: getfield 3443	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_game_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12565: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12568: ifeq +16 -> 12584
    //   12571: aload 32
    //   12573: aload 31
    //   12575: getfield 3443	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_game_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12578: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12581: putfield 3446	com/tencent/mobileqq/data/PushRecommend:wzrySourceId	I
    //   12584: aload 31
    //   12586: getfield 3449	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_role_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12589: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12592: ifeq +26 -> 12618
    //   12595: aload 32
    //   12597: new 274	java/lang/String
    //   12600: dup
    //   12601: aload 31
    //   12603: getfield 3449	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_role_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12606: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12609: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12612: invokespecial 1295	java/lang/String:<init>	([B)V
    //   12615: putfield 3452	com/tencent/mobileqq/data/PushRecommend:wzryGameNick	Ljava/lang/String;
    //   12618: aload 32
    //   12620: lload_2
    //   12621: putfield 3453	com/tencent/mobileqq/data/PushRecommend:timestamp	J
    //   12624: aload 29
    //   12626: aload 32
    //   12628: invokevirtual 657	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   12631: pop
    //   12632: goto -444 -> 12188
    //   12635: astore 28
    //   12637: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12640: ifeq +13 -> 12653
    //   12643: ldc_w 3326
    //   12646: iconst_2
    //   12647: ldc_w 3455
    //   12650: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12653: aload_1
    //   12654: getfield 1157	OnlinePushPack/MsgInfo:lFromUin	J
    //   12657: lstore_2
    //   12658: aload_1
    //   12659: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   12662: istore 4
    //   12664: aload_1
    //   12665: getfield 1208	OnlinePushPack/MsgInfo:lMsgUid	J
    //   12668: lstore 15
    //   12670: aload_1
    //   12671: getfield 1154	OnlinePushPack/MsgInfo:shMsgType	S
    //   12674: istore 5
    //   12676: aload_0
    //   12677: getfield 1471	abtl:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   12680: lload_2
    //   12681: iload 4
    //   12683: lload 15
    //   12685: iload 5
    //   12687: invokestatic 1881	azad:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   12690: aconst_null
    //   12691: areturn
    //   12692: aload 28
    //   12694: getfield 3356	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:msg_persons_may_know	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2;
    //   12697: getfield 3456	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2:bytes_role_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12700: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12703: ifeq -50 -> 12653
    //   12706: aload 28
    //   12708: getfield 3356	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:msg_persons_may_know	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2;
    //   12711: getfield 3456	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2:bytes_role_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12714: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12717: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   12720: astore 28
    //   12722: aload_0
    //   12723: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12726: aload_0
    //   12727: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12730: invokevirtual 675	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   12733: aload 28
    //   12735: invokestatic 3462	com/tencent/mobileqq/data/KplRoleInfo:saveGameNickWithUin	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)V
    //   12738: goto -85 -> 12653
    //   12741: aload 32
    //   12743: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   12746: ldc2_w 3463
    //   12749: lcmp
    //   12750: ifne +172 -> 12922
    //   12753: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12756: ifeq +13 -> 12769
    //   12759: ldc_w 3466
    //   12762: iconst_2
    //   12763: ldc_w 3468
    //   12766: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12769: new 3470	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody
    //   12772: dup
    //   12773: invokespecial 3471	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:<init>	()V
    //   12776: astore_1
    //   12777: aload_1
    //   12778: aload 32
    //   12780: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   12783: invokevirtual 3472	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12786: pop
    //   12787: aload_1
    //   12788: getfield 3473	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12791: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12794: istore 4
    //   12796: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12799: ifeq +28 -> 12827
    //   12802: ldc_w 3466
    //   12805: iconst_2
    //   12806: iconst_2
    //   12807: anewarray 220	java/lang/Object
    //   12810: dup
    //   12811: iconst_0
    //   12812: ldc_w 3475
    //   12815: aastore
    //   12816: dup
    //   12817: iconst_1
    //   12818: iload 4
    //   12820: invokestatic 255	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12823: aastore
    //   12824: invokestatic 691	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   12827: iload 4
    //   12829: iconst_1
    //   12830: if_icmpne -12801 -> 29
    //   12833: aload_1
    //   12834: getfield 3479	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:msg_body_type	Ltencent/im/oidb/olympic/submsgtype0xb4$BodyType;
    //   12837: astore_1
    //   12838: aload_1
    //   12839: getfield 3485	tencent/im/oidb/olympic/submsgtype0xb4$BodyType:msg_torchbearer	Ltencent/im/oidb/olympic/torch_transfer$TorchbearerInfo;
    //   12842: invokevirtual 3488	tencent/im/oidb/olympic/torch_transfer$TorchbearerInfo:has	()Z
    //   12845: ifeq +59 -> 12904
    //   12848: aload_0
    //   12849: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12852: bipush 94
    //   12854: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   12857: checkcast 3490	awai
    //   12860: astore 28
    //   12862: aload 28
    //   12864: ifnull -12835 -> 29
    //   12867: aload 28
    //   12869: aload_1
    //   12870: getfield 3485	tencent/im/oidb/olympic/submsgtype0xb4$BodyType:msg_torchbearer	Ltencent/im/oidb/olympic/torch_transfer$TorchbearerInfo;
    //   12873: invokevirtual 3491	tencent/im/oidb/olympic/torch_transfer$TorchbearerInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12876: checkcast 3487	tencent/im/oidb/olympic/torch_transfer$TorchbearerInfo
    //   12879: invokevirtual 3494	awai:a	(Ltencent/im/oidb/olympic/torch_transfer$TorchbearerInfo;)V
    //   12882: aconst_null
    //   12883: areturn
    //   12884: astore_1
    //   12885: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12888: ifeq -12859 -> 29
    //   12891: ldc_w 3466
    //   12894: iconst_2
    //   12895: ldc_w 3496
    //   12898: aload_1
    //   12899: invokestatic 2442	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   12902: aconst_null
    //   12903: areturn
    //   12904: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12907: ifeq -12878 -> 29
    //   12910: ldc_w 3466
    //   12913: iconst_2
    //   12914: ldc_w 3498
    //   12917: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12920: aconst_null
    //   12921: areturn
    //   12922: aload 32
    //   12924: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   12927: ldc2_w 3499
    //   12930: lcmp
    //   12931: ifne +18 -> 12949
    //   12934: aload_0
    //   12935: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12938: aload 32
    //   12940: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   12943: iconst_1
    //   12944: invokestatic 3503	azad:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BZ)V
    //   12947: aconst_null
    //   12948: areturn
    //   12949: aload 32
    //   12951: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   12954: ldc2_w 3504
    //   12957: lcmp
    //   12958: ifne +70 -> 13028
    //   12961: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12964: ifeq +13 -> 12977
    //   12967: ldc_w 3507
    //   12970: iconst_2
    //   12971: ldc_w 3509
    //   12974: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   12977: new 3511	tencent/im/s2c/msgtype0x210/submsgtype0xc1/submsgtype0xc1$MsgBody
    //   12980: dup
    //   12981: invokespecial 3512	tencent/im/s2c/msgtype0x210/submsgtype0xc1/submsgtype0xc1$MsgBody:<init>	()V
    //   12984: astore_1
    //   12985: aload_1
    //   12986: aload 32
    //   12988: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   12991: invokevirtual 3513	tencent/im/s2c/msgtype0x210/submsgtype0xc1/submsgtype0xc1$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12994: pop
    //   12995: aload_0
    //   12996: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12999: invokevirtual 3516	com/tencent/mobileqq/app/QQAppInterface:a	()Lamai;
    //   13002: aload_1
    //   13003: invokevirtual 3521	amai:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xc1/submsgtype0xc1$MsgBody;)V
    //   13006: aconst_null
    //   13007: areturn
    //   13008: astore_1
    //   13009: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13012: ifeq -12983 -> 29
    //   13015: ldc_w 3507
    //   13018: iconst_2
    //   13019: ldc_w 3523
    //   13022: aload_1
    //   13023: invokestatic 1614	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13026: aconst_null
    //   13027: areturn
    //   13028: aload 32
    //   13030: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13033: ldc2_w 3524
    //   13036: lcmp
    //   13037: ifne +166 -> 13203
    //   13040: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13043: ifeq +13 -> 13056
    //   13046: ldc_w 3527
    //   13049: iconst_2
    //   13050: ldc_w 3529
    //   13053: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13056: new 3531	tencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody
    //   13059: dup
    //   13060: invokespecial 3532	tencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody:<init>	()V
    //   13063: astore_1
    //   13064: aload_1
    //   13065: aload 32
    //   13067: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13070: invokevirtual 3533	tencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13073: pop
    //   13074: aload_0
    //   13075: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13078: invokevirtual 3516	com/tencent/mobileqq/app/QQAppInterface:a	()Lamai;
    //   13081: aload_1
    //   13082: invokevirtual 3536	amai:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody;)V
    //   13085: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13088: ifeq -13059 -> 29
    //   13091: aload_1
    //   13092: getfield 3539	tencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody:bytes_business	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   13095: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   13098: invokevirtual 230	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   13101: astore_1
    //   13102: ldc_w 3527
    //   13105: iconst_2
    //   13106: new 88	java/lang/StringBuilder
    //   13109: dup
    //   13110: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   13113: ldc_w 3541
    //   13116: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13119: aload_1
    //   13120: arraylength
    //   13121: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13124: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13127: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13130: ldc_w 3527
    //   13133: iconst_2
    //   13134: new 88	java/lang/StringBuilder
    //   13137: dup
    //   13138: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   13141: ldc_w 3543
    //   13144: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13147: aload_1
    //   13148: arraylength
    //   13149: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13152: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13155: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13158: aconst_null
    //   13159: areturn
    //   13160: astore_1
    //   13161: aload_1
    //   13162: invokevirtual 1314	java/lang/Exception:printStackTrace	()V
    //   13165: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13168: ifeq -13139 -> 29
    //   13171: ldc_w 3527
    //   13174: iconst_2
    //   13175: new 88	java/lang/StringBuilder
    //   13178: dup
    //   13179: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   13182: ldc_w 3545
    //   13185: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13188: aload_1
    //   13189: invokevirtual 3548	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   13192: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13195: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13198: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13201: aconst_null
    //   13202: areturn
    //   13203: aload 32
    //   13205: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13208: ldc2_w 3549
    //   13211: lcmp
    //   13212: ifne +101 -> 13313
    //   13215: aload 32
    //   13217: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13220: ifnull +93 -> 13313
    //   13223: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13226: ifeq +13 -> 13239
    //   13229: ldc_w 3552
    //   13232: iconst_2
    //   13233: ldc_w 3554
    //   13236: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13239: aload_1
    //   13240: getfield 1157	OnlinePushPack/MsgInfo:lFromUin	J
    //   13243: lstore_2
    //   13244: aload_1
    //   13245: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   13248: istore 4
    //   13250: aload_1
    //   13251: getfield 1208	OnlinePushPack/MsgInfo:lMsgUid	J
    //   13254: lstore 15
    //   13256: aload_1
    //   13257: getfield 1154	OnlinePushPack/MsgInfo:shMsgType	S
    //   13260: istore 5
    //   13262: aload_1
    //   13263: getfield 1201	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   13266: istore 6
    //   13268: new 3556	amlj
    //   13271: dup
    //   13272: lload_2
    //   13273: iload 4
    //   13275: i2l
    //   13276: lload 15
    //   13278: iload 5
    //   13280: iload 6
    //   13282: iconst_1
    //   13283: invokespecial 3559	amlj:<init>	(JJJIIZ)V
    //   13286: astore_1
    //   13287: aload_0
    //   13288: aload 32
    //   13290: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13293: aload_1
    //   13294: invokevirtual 3562	abtl:a	([BLamlj;)V
    //   13297: aload_0
    //   13298: getfield 1471	abtl:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   13301: lload_2
    //   13302: iload 4
    //   13304: lload 15
    //   13306: iload 5
    //   13308: invokestatic 1881	azad:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   13311: aconst_null
    //   13312: areturn
    //   13313: aload 32
    //   13315: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13318: ldc2_w 3563
    //   13321: lcmp
    //   13322: ifne +19 -> 13341
    //   13325: aload_0
    //   13326: aload 32
    //   13328: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13331: aload_1
    //   13332: getfield 1201	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   13335: i2l
    //   13336: invokevirtual 3567	abtl:a	([BJ)V
    //   13339: aconst_null
    //   13340: areturn
    //   13341: aload 32
    //   13343: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13346: ldc2_w 3568
    //   13349: lcmp
    //   13350: ifne +28 -> 13378
    //   13353: aload_0
    //   13354: getfield 1471	abtl:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   13357: aload_1
    //   13358: getfield 1157	OnlinePushPack/MsgInfo:lFromUin	J
    //   13361: aload_1
    //   13362: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   13365: aload_1
    //   13366: getfield 1208	OnlinePushPack/MsgInfo:lMsgUid	J
    //   13369: aload_1
    //   13370: getfield 1154	OnlinePushPack/MsgInfo:shMsgType	S
    //   13373: invokestatic 1881	azad:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   13376: aconst_null
    //   13377: areturn
    //   13378: aload 32
    //   13380: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13383: ldc2_w 3570
    //   13386: lcmp
    //   13387: ifne +19 -> 13406
    //   13390: aload_0
    //   13391: aload 32
    //   13393: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13396: aload_1
    //   13397: getfield 1201	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   13400: i2l
    //   13401: invokevirtual 3573	abtl:b	([BJ)V
    //   13404: aconst_null
    //   13405: areturn
    //   13406: aload 32
    //   13408: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13411: ldc2_w 3574
    //   13414: lcmp
    //   13415: ifne +39 -> 13454
    //   13418: aload_0
    //   13419: aload 32
    //   13421: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13424: iconst_1
    //   13425: aload_1
    //   13426: invokevirtual 3578	abtl:a	([BILOnlinePushPack/MsgInfo;)V
    //   13429: aload_0
    //   13430: getfield 1471	abtl:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   13433: aload_1
    //   13434: getfield 1157	OnlinePushPack/MsgInfo:lFromUin	J
    //   13437: aload_1
    //   13438: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   13441: aload_1
    //   13442: getfield 1208	OnlinePushPack/MsgInfo:lMsgUid	J
    //   13445: aload_1
    //   13446: getfield 1154	OnlinePushPack/MsgInfo:shMsgType	S
    //   13449: invokestatic 1881	azad:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   13452: aconst_null
    //   13453: areturn
    //   13454: aload 32
    //   13456: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13459: ldc2_w 3579
    //   13462: lcmp
    //   13463: ifne +38 -> 13501
    //   13466: aload_0
    //   13467: aload 32
    //   13469: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13472: iconst_1
    //   13473: invokevirtual 3582	abtl:a	([BI)V
    //   13476: aload_0
    //   13477: getfield 1471	abtl:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   13480: aload_1
    //   13481: getfield 1157	OnlinePushPack/MsgInfo:lFromUin	J
    //   13484: aload_1
    //   13485: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   13488: aload_1
    //   13489: getfield 1208	OnlinePushPack/MsgInfo:lMsgUid	J
    //   13492: aload_1
    //   13493: getfield 1154	OnlinePushPack/MsgInfo:shMsgType	S
    //   13496: invokestatic 1881	azad:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   13499: aconst_null
    //   13500: areturn
    //   13501: aload 32
    //   13503: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13506: ldc2_w 3583
    //   13509: lcmp
    //   13510: ifne +70 -> 13580
    //   13513: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13516: ifeq +13 -> 13529
    //   13519: ldc_w 3586
    //   13522: iconst_2
    //   13523: ldc_w 3588
    //   13526: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13529: aload_0
    //   13530: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13533: bipush 34
    //   13535: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   13538: checkcast 3590	amci
    //   13541: astore_1
    //   13542: aload_1
    //   13543: ifnull +19 -> 13562
    //   13546: aload_1
    //   13547: aload 32
    //   13549: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13552: aload 32
    //   13554: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13557: invokevirtual 3591	amci:a	(J[B)V
    //   13560: aconst_null
    //   13561: areturn
    //   13562: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13565: ifeq -13536 -> 29
    //   13568: ldc_w 3586
    //   13571: iconst_2
    //   13572: ldc_w 3593
    //   13575: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13578: aconst_null
    //   13579: areturn
    //   13580: aload 32
    //   13582: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13585: ldc2_w 3594
    //   13588: lcmp
    //   13589: ifne +15 -> 13604
    //   13592: aload_0
    //   13593: aload 32
    //   13595: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13598: aload_1
    //   13599: invokevirtual 3598	abtl:a	([BLOnlinePushPack/MsgInfo;)V
    //   13602: aconst_null
    //   13603: areturn
    //   13604: aload 32
    //   13606: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13609: ldc2_w 3599
    //   13612: lcmp
    //   13613: ifne +25 -> 13638
    //   13616: aload_0
    //   13617: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13620: bipush 98
    //   13622: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   13625: checkcast 3602	ult
    //   13628: aload 32
    //   13630: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13633: invokevirtual 3603	ult:a	([B)V
    //   13636: aconst_null
    //   13637: areturn
    //   13638: aload 32
    //   13640: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13643: ldc2_w 3604
    //   13646: lcmp
    //   13647: ifne +70 -> 13717
    //   13650: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13653: ifeq +13 -> 13666
    //   13656: ldc_w 3507
    //   13659: iconst_2
    //   13660: ldc_w 3607
    //   13663: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13666: new 3609	tencent/im/s2c/msgtype0x210/submsgtype0xcf/submsgtype0xcf$MsgBody
    //   13669: dup
    //   13670: invokespecial 3610	tencent/im/s2c/msgtype0x210/submsgtype0xcf/submsgtype0xcf$MsgBody:<init>	()V
    //   13673: astore_1
    //   13674: aload_1
    //   13675: aload 32
    //   13677: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13680: invokevirtual 3611	tencent/im/s2c/msgtype0x210/submsgtype0xcf/submsgtype0xcf$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13683: pop
    //   13684: aload_0
    //   13685: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13688: invokevirtual 3516	com/tencent/mobileqq/app/QQAppInterface:a	()Lamai;
    //   13691: aload_1
    //   13692: invokevirtual 3614	amai:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xcf/submsgtype0xcf$MsgBody;)V
    //   13695: aconst_null
    //   13696: areturn
    //   13697: astore_1
    //   13698: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13701: ifeq -13672 -> 29
    //   13704: ldc_w 3507
    //   13707: iconst_2
    //   13708: ldc_w 3616
    //   13711: aload_1
    //   13712: invokestatic 1614	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13715: aconst_null
    //   13716: areturn
    //   13717: aload 32
    //   13719: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13722: ldc2_w 3617
    //   13725: lcmp
    //   13726: ifne +25 -> 13751
    //   13729: aload_0
    //   13730: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13733: bipush 98
    //   13735: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   13738: checkcast 3602	ult
    //   13741: aload 32
    //   13743: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13746: invokevirtual 3619	ult:b	([B)V
    //   13749: aconst_null
    //   13750: areturn
    //   13751: aload 32
    //   13753: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13756: ldc2_w 3620
    //   13759: lcmp
    //   13760: ifne +25 -> 13785
    //   13763: aload_0
    //   13764: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13767: bipush 98
    //   13769: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   13772: checkcast 3602	ult
    //   13775: aload 32
    //   13777: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13780: invokevirtual 3622	ult:c	([B)V
    //   13783: aconst_null
    //   13784: areturn
    //   13785: aload 32
    //   13787: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13790: ldc2_w 3623
    //   13793: lcmp
    //   13794: ifne +42 -> 13836
    //   13797: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13800: ifeq +13 -> 13813
    //   13803: ldc_w 520
    //   13806: iconst_2
    //   13807: ldc_w 3626
    //   13810: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   13813: aload_0
    //   13814: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13817: sipush 202
    //   13820: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   13823: checkcast 3628	com/tencent/mobileqq/data/MsgBoxInterFollowManager
    //   13826: aload 32
    //   13828: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13831: invokevirtual 3631	com/tencent/mobileqq/data/MsgBoxInterFollowManager:decode0xd7InteractAndFollowMsg	([B)V
    //   13834: aconst_null
    //   13835: areturn
    //   13836: aload 32
    //   13838: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13841: ldc2_w 3632
    //   13844: lcmp
    //   13845: ifne +42 -> 13887
    //   13848: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13851: ifeq +13 -> 13864
    //   13854: ldc_w 520
    //   13857: iconst_2
    //   13858: ldc_w 3635
    //   13861: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   13864: aload_0
    //   13865: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13868: sipush 202
    //   13871: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   13874: checkcast 3628	com/tencent/mobileqq/data/MsgBoxInterFollowManager
    //   13877: aload 32
    //   13879: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13882: invokevirtual 3638	com/tencent/mobileqq/data/MsgBoxInterFollowManager:decode0xfeInteractAndFollowMsg	([B)V
    //   13885: aconst_null
    //   13886: areturn
    //   13887: aload 32
    //   13889: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13892: ldc2_w 3639
    //   13895: lcmp
    //   13896: ifne +25 -> 13921
    //   13899: aload_0
    //   13900: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13903: bipush 107
    //   13905: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   13908: checkcast 3642	bema
    //   13911: aload 32
    //   13913: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13916: invokevirtual 3643	bema:a	([B)V
    //   13919: aconst_null
    //   13920: areturn
    //   13921: aload 32
    //   13923: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13926: ldc2_w 3644
    //   13929: lcmp
    //   13930: ifne +70 -> 14000
    //   13933: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13936: ifeq +13 -> 13949
    //   13939: ldc_w 3647
    //   13942: iconst_2
    //   13943: ldc_w 3649
    //   13946: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13949: new 3651	tencent/im/s2c/msgtype0x210/submsgtype0xdb/submsgtype0xdb$MsgBody
    //   13952: dup
    //   13953: invokespecial 3652	tencent/im/s2c/msgtype0x210/submsgtype0xdb/submsgtype0xdb$MsgBody:<init>	()V
    //   13956: astore_1
    //   13957: aload_1
    //   13958: aload 32
    //   13960: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13963: invokevirtual 3653	tencent/im/s2c/msgtype0x210/submsgtype0xdb/submsgtype0xdb$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13966: pop
    //   13967: aload_0
    //   13968: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13971: invokevirtual 3516	com/tencent/mobileqq/app/QQAppInterface:a	()Lamai;
    //   13974: aload_1
    //   13975: invokevirtual 3656	amai:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xdb/submsgtype0xdb$MsgBody;)V
    //   13978: aconst_null
    //   13979: areturn
    //   13980: astore_1
    //   13981: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13984: ifeq -13955 -> 29
    //   13987: ldc_w 3647
    //   13990: iconst_2
    //   13991: ldc_w 3658
    //   13994: aload_1
    //   13995: invokestatic 1614	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13998: aconst_null
    //   13999: areturn
    //   14000: aload 32
    //   14002: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14005: ldc2_w 3659
    //   14008: lcmp
    //   14009: ifne +21 -> 14030
    //   14012: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14015: ifeq -13986 -> 29
    //   14018: ldc_w 520
    //   14021: iconst_2
    //   14022: ldc_w 3662
    //   14025: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14028: aconst_null
    //   14029: areturn
    //   14030: aload 32
    //   14032: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14035: ldc2_w 3663
    //   14038: lcmp
    //   14039: ifne +21 -> 14060
    //   14042: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14045: ifeq -14016 -> 29
    //   14048: ldc_w 520
    //   14051: iconst_2
    //   14052: ldc_w 3666
    //   14055: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14058: aconst_null
    //   14059: areturn
    //   14060: aload 32
    //   14062: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14065: ldc2_w 3667
    //   14068: lcmp
    //   14069: ifne +219 -> 14288
    //   14072: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14075: ifeq +13 -> 14088
    //   14078: ldc_w 3670
    //   14081: iconst_2
    //   14082: ldc_w 3672
    //   14085: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14088: new 3674	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody
    //   14091: dup
    //   14092: invokespecial 3675	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody:<init>	()V
    //   14095: astore_1
    //   14096: aload_1
    //   14097: aload 32
    //   14099: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14102: invokevirtual 3676	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14105: pop
    //   14106: aload_1
    //   14107: getfield 3680	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody:msg_game_state	Ltencent/im/apollo_game_status$STCMGameMessage;
    //   14110: invokevirtual 3683	tencent/im/apollo_game_status$STCMGameMessage:has	()Z
    //   14113: ifeq -14084 -> 29
    //   14116: aload_1
    //   14117: getfield 3680	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody:msg_game_state	Ltencent/im/apollo_game_status$STCMGameMessage;
    //   14120: invokevirtual 3684	tencent/im/apollo_game_status$STCMGameMessage:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14123: checkcast 3682	tencent/im/apollo_game_status$STCMGameMessage
    //   14126: astore_1
    //   14127: aload_1
    //   14128: getfield 3688	tencent/im/apollo_game_status$STCMGameMessage:msg_comm	Ltencent/im/apollo_game_status$STCMGameMessage$STMsgComm;
    //   14131: invokevirtual 3691	tencent/im/apollo_game_status$STCMGameMessage$STMsgComm:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14134: checkcast 3690	tencent/im/apollo_game_status$STCMGameMessage$STMsgComm
    //   14137: astore 29
    //   14139: aload 29
    //   14141: getfield 3694	tencent/im/apollo_game_status$STCMGameMessage$STMsgComm:uint32_session_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   14144: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   14147: invokestatic 3697	bdeu:a	(I)J
    //   14150: lstore 15
    //   14152: aload_0
    //   14153: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14156: sipush 211
    //   14159: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14162: checkcast 3699	aknt
    //   14165: astore 28
    //   14167: lload_2
    //   14168: lload 15
    //   14170: lcmp
    //   14171: ifne +102 -> 14273
    //   14174: aload 29
    //   14176: getfield 3702	tencent/im/apollo_game_status$STCMGameMessage$STMsgComm:rpt_uint32_session_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   14179: invokevirtual 1825	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   14182: astore 29
    //   14184: aload 29
    //   14186: ifnull -14157 -> 29
    //   14189: aload 29
    //   14191: invokeinterface 1541 1 0
    //   14196: ifle -14167 -> 29
    //   14199: aload 29
    //   14201: invokeinterface 51 1 0
    //   14206: astore 29
    //   14208: aload 29
    //   14210: invokeinterface 56 1 0
    //   14215: ifeq -14186 -> 29
    //   14218: aload 29
    //   14220: invokeinterface 60 1 0
    //   14225: checkcast 251	java/lang/Integer
    //   14228: invokevirtual 3705	java/lang/Integer:intValue	()I
    //   14231: invokestatic 3697	bdeu:a	(I)J
    //   14234: lstore 15
    //   14236: lload 15
    //   14238: lload_2
    //   14239: lcmp
    //   14240: ifeq -32 -> 14208
    //   14243: aload 28
    //   14245: iconst_0
    //   14246: iconst_0
    //   14247: lload 15
    //   14249: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   14252: aload_1
    //   14253: invokevirtual 3708	aknt:a	(IILjava/lang/String;Ltencent/im/apollo_game_status$STCMGameMessage;)V
    //   14256: goto -48 -> 14208
    //   14259: astore_1
    //   14260: ldc_w 3670
    //   14263: iconst_1
    //   14264: ldc_w 3710
    //   14267: aload_1
    //   14268: invokestatic 1614	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14271: aconst_null
    //   14272: areturn
    //   14273: aload 28
    //   14275: iconst_0
    //   14276: iconst_0
    //   14277: lload 15
    //   14279: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   14282: aload_1
    //   14283: invokevirtual 3708	aknt:a	(IILjava/lang/String;Ltencent/im/apollo_game_status$STCMGameMessage;)V
    //   14286: aconst_null
    //   14287: areturn
    //   14288: aload 32
    //   14290: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14293: ldc2_w 3711
    //   14296: lcmp
    //   14297: ifne +138 -> 14435
    //   14300: ldc_w 3714
    //   14303: iconst_1
    //   14304: ldc_w 3716
    //   14307: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14310: new 3718	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody
    //   14313: dup
    //   14314: invokespecial 3719	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody:<init>	()V
    //   14317: astore_1
    //   14318: aload_1
    //   14319: aload 32
    //   14321: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14324: invokevirtual 3720	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14327: pop
    //   14328: aload_1
    //   14329: getfield 3724	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody:msg_item	Ltencent/im/apollo_push_msgInfo$STPushMsgElem;
    //   14332: invokevirtual 3727	tencent/im/apollo_push_msgInfo$STPushMsgElem:has	()Z
    //   14335: ifeq -14306 -> 29
    //   14338: aload_1
    //   14339: getfield 3724	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody:msg_item	Ltencent/im/apollo_push_msgInfo$STPushMsgElem;
    //   14342: invokevirtual 3728	tencent/im/apollo_push_msgInfo$STPushMsgElem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14345: checkcast 3726	tencent/im/apollo_push_msgInfo$STPushMsgElem
    //   14348: astore_1
    //   14349: aload_0
    //   14350: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14353: ifnull -14324 -> 29
    //   14356: aload_0
    //   14357: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14360: sipush 227
    //   14363: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14366: checkcast 3730	akos
    //   14369: astore 28
    //   14371: aload 28
    //   14373: iconst_0
    //   14374: aload_1
    //   14375: invokevirtual 3733	akos:a	(ILtencent/im/apollo_push_msgInfo$STPushMsgElem;)V
    //   14378: aload 28
    //   14380: aload_1
    //   14381: invokevirtual 3736	akos:c	(Ltencent/im/apollo_push_msgInfo$STPushMsgElem;)V
    //   14384: aload 28
    //   14386: aload_1
    //   14387: invokevirtual 3738	akos:b	(Ltencent/im/apollo_push_msgInfo$STPushMsgElem;)V
    //   14390: aload 28
    //   14392: aload_1
    //   14393: invokevirtual 3740	akos:a	(Ltencent/im/apollo_push_msgInfo$STPushMsgElem;)V
    //   14396: aconst_null
    //   14397: areturn
    //   14398: astore_1
    //   14399: aload_1
    //   14400: invokevirtual 1314	java/lang/Exception:printStackTrace	()V
    //   14403: ldc_w 3714
    //   14406: iconst_1
    //   14407: new 88	java/lang/StringBuilder
    //   14410: dup
    //   14411: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14414: ldc_w 3742
    //   14417: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14420: aload_1
    //   14421: invokevirtual 3548	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   14424: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14427: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14430: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   14433: aconst_null
    //   14434: areturn
    //   14435: aload 32
    //   14437: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14440: ldc2_w 3743
    //   14443: lcmp
    //   14444: ifne +88 -> 14532
    //   14447: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14450: ifeq +13 -> 14463
    //   14453: ldc_w 520
    //   14456: iconst_2
    //   14457: ldc_w 3746
    //   14460: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14463: new 3748	tencent/im/c2c/msgtype0x210/submsgtype0xeb/submsgtype0xeb$MsgBody
    //   14466: dup
    //   14467: invokespecial 3749	tencent/im/c2c/msgtype0x210/submsgtype0xeb/submsgtype0xeb$MsgBody:<init>	()V
    //   14470: astore_1
    //   14471: aload 32
    //   14473: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14476: ifnull +13 -> 14489
    //   14479: aload_1
    //   14480: aload 32
    //   14482: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14485: invokevirtual 3750	tencent/im/c2c/msgtype0x210/submsgtype0xeb/submsgtype0xeb$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14488: pop
    //   14489: aload_0
    //   14490: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14493: aload_1
    //   14494: invokestatic 3753	amga:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ltencent/im/c2c/msgtype0x210/submsgtype0xeb/submsgtype0xeb$MsgBody;)V
    //   14497: aconst_null
    //   14498: areturn
    //   14499: astore_1
    //   14500: ldc_w 520
    //   14503: iconst_1
    //   14504: new 88	java/lang/StringBuilder
    //   14507: dup
    //   14508: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14511: ldc_w 3755
    //   14514: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14517: aload_1
    //   14518: invokevirtual 3548	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   14521: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14524: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14527: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   14530: aconst_null
    //   14531: areturn
    //   14532: aload 32
    //   14534: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14537: ldc2_w 3756
    //   14540: lcmp
    //   14541: ifne +195 -> 14736
    //   14544: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14547: ifeq +13 -> 14560
    //   14550: ldc_w 520
    //   14553: iconst_2
    //   14554: ldc_w 3759
    //   14557: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14560: aload 32
    //   14562: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14565: arraylength
    //   14566: istore 4
    //   14568: iload 4
    //   14570: bipush 6
    //   14572: if_icmpge +33 -> 14605
    //   14575: ldc_w 520
    //   14578: iconst_2
    //   14579: new 88	java/lang/StringBuilder
    //   14582: dup
    //   14583: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14586: ldc_w 3761
    //   14589: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14592: iload 4
    //   14594: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14597: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14600: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14603: aconst_null
    //   14604: areturn
    //   14605: aload 32
    //   14607: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14610: iconst_0
    //   14611: baload
    //   14612: iconst_4
    //   14613: ishl
    //   14614: aload 32
    //   14616: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14619: iconst_1
    //   14620: baload
    //   14621: iadd
    //   14622: istore 5
    //   14624: iconst_4
    //   14625: newarray byte
    //   14627: astore_1
    //   14628: aload 32
    //   14630: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14633: iconst_2
    //   14634: aload_1
    //   14635: iconst_0
    //   14636: iconst_4
    //   14637: invokestatic 3765	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   14640: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14643: ifeq +31 -> 14674
    //   14646: ldc_w 520
    //   14649: iconst_2
    //   14650: new 88	java/lang/StringBuilder
    //   14653: dup
    //   14654: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14657: ldc_w 3767
    //   14660: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14663: iload 5
    //   14665: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14668: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14671: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14674: invokestatic 3773	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   14677: new 3775	com/tencent/imcore/message/OnLinePushMessageProcessor$2
    //   14680: dup
    //   14681: aload_0
    //   14682: iload 5
    //   14684: invokespecial 3778	com/tencent/imcore/message/OnLinePushMessageProcessor$2:<init>	(Labtl;I)V
    //   14687: invokevirtual 3782	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   14690: pop
    //   14691: iload 4
    //   14693: bipush 6
    //   14695: if_icmple -14666 -> 29
    //   14698: iload 4
    //   14700: bipush 6
    //   14702: isub
    //   14703: newarray byte
    //   14705: astore 28
    //   14707: aload 32
    //   14709: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14712: bipush 6
    //   14714: aload 28
    //   14716: iconst_0
    //   14717: iload 4
    //   14719: bipush 6
    //   14721: isub
    //   14722: invokestatic 3765	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   14725: iload 5
    //   14727: aload_1
    //   14728: aload 28
    //   14730: invokestatic 3787	amre:a	(I[B[B)Z
    //   14733: pop
    //   14734: aconst_null
    //   14735: areturn
    //   14736: aload 32
    //   14738: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14741: ldc2_w 3788
    //   14744: lcmp
    //   14745: ifne +120 -> 14865
    //   14748: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14751: ifeq +13 -> 14764
    //   14754: ldc_w 520
    //   14757: iconst_2
    //   14758: ldc_w 3791
    //   14761: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14764: aload_0
    //   14765: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14768: sipush 252
    //   14771: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14774: checkcast 3793	uza
    //   14777: astore_1
    //   14778: new 3795	com/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodePushNotify
    //   14781: dup
    //   14782: invokespecial 3796	com/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodePushNotify:<init>	()V
    //   14785: astore 28
    //   14787: aload 28
    //   14789: aload 32
    //   14791: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14794: invokevirtual 3797	com/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodePushNotify:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14797: pop
    //   14798: aload_0
    //   14799: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14802: sipush 251
    //   14805: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14808: checkcast 3799	uyz
    //   14811: astore 29
    //   14813: aload_1
    //   14814: getfield 3800	uza:jdField_a_of_type_Boolean	Z
    //   14817: ifeq -14788 -> 29
    //   14820: aload 29
    //   14822: invokevirtual 3803	uyz:a	()Luyl;
    //   14825: aload 28
    //   14827: invokevirtual 3808	uyl:a	(Lcom/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodePushNotify;)V
    //   14830: aconst_null
    //   14831: areturn
    //   14832: astore_1
    //   14833: ldc_w 520
    //   14836: iconst_1
    //   14837: new 88	java/lang/StringBuilder
    //   14840: dup
    //   14841: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14844: ldc_w 3810
    //   14847: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14850: aload_1
    //   14851: invokevirtual 3811	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   14854: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14857: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14860: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   14863: aconst_null
    //   14864: areturn
    //   14865: aload 32
    //   14867: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14870: ldc2_w 3812
    //   14873: lcmp
    //   14874: ifne +81 -> 14955
    //   14877: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14880: ifeq +34 -> 14914
    //   14883: ldc_w 520
    //   14886: iconst_2
    //   14887: new 88	java/lang/StringBuilder
    //   14890: dup
    //   14891: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14894: ldc_w 3815
    //   14897: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14900: aload 32
    //   14902: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14905: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14908: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14911: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14914: aload_0
    //   14915: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14918: sipush 253
    //   14921: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14924: checkcast 3817	uls
    //   14927: astore 28
    //   14929: aload_1
    //   14930: getfield 1157	OnlinePushPack/MsgInfo:lFromUin	J
    //   14933: lstore_2
    //   14934: aload 28
    //   14936: aload 28
    //   14938: aload 32
    //   14940: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14943: lload_2
    //   14944: invokestatic 495	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   14947: invokevirtual 3820	uls:a	([BLjava/lang/String;)Lcom/tencent/mobileqq/data/MessageForQQStoryFeed;
    //   14950: invokevirtual 3823	uls:a	(Lcom/tencent/mobileqq/data/MessageForQQStoryFeed;)V
    //   14953: aconst_null
    //   14954: areturn
    //   14955: aload 32
    //   14957: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14960: ldc2_w 3824
    //   14963: lcmp
    //   14964: ifne +240 -> 15204
    //   14967: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14970: ifeq +13 -> 14983
    //   14973: ldc_w 520
    //   14976: iconst_2
    //   14977: ldc_w 3827
    //   14980: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14983: new 3829	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$MsgBody
    //   14986: dup
    //   14987: invokespecial 3830	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$MsgBody:<init>	()V
    //   14990: astore_1
    //   14991: aload 32
    //   14993: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14996: ifnull -14967 -> 29
    //   14999: aload_1
    //   15000: aload 32
    //   15002: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15005: invokevirtual 3831	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15008: pop
    //   15009: aload_1
    //   15010: getfield 3834	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$MsgBody:rpt_now_push_msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   15013: invokevirtual 45	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   15016: invokeinterface 51 1 0
    //   15021: astore_1
    //   15022: aload_1
    //   15023: invokeinterface 56 1 0
    //   15028: ifeq -14999 -> 29
    //   15031: aload_1
    //   15032: invokeinterface 60 1 0
    //   15037: checkcast 3836	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg
    //   15040: astore 28
    //   15042: aload_0
    //   15043: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15046: sipush 266
    //   15049: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   15052: checkcast 3838	avuz
    //   15055: aload 28
    //   15057: invokevirtual 3841	avuz:a	(Lcom/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg;)V
    //   15060: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15063: ifeq -41 -> 15022
    //   15066: ldc_w 520
    //   15069: iconst_2
    //   15070: new 88	java/lang/StringBuilder
    //   15073: dup
    //   15074: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   15077: ldc_w 3843
    //   15080: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15083: aload 28
    //   15085: getfield 3846	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint32_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   15088: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   15091: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15094: ldc_w 3848
    //   15097: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15100: aload 28
    //   15102: getfield 3849	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint32_task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   15105: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   15108: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15111: ldc_w 3851
    //   15114: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15117: aload 28
    //   15119: getfield 3852	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   15122: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   15125: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15128: ldc_w 3854
    //   15131: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15134: aload 28
    //   15136: getfield 3857	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint64_start_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   15139: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   15142: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15145: ldc_w 3859
    //   15148: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15151: aload 28
    //   15153: getfield 3862	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint64_end_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   15156: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   15159: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15162: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15165: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15168: goto -146 -> 15022
    //   15171: astore_1
    //   15172: ldc_w 520
    //   15175: iconst_1
    //   15176: new 88	java/lang/StringBuilder
    //   15179: dup
    //   15180: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   15183: ldc_w 3864
    //   15186: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15189: aload_1
    //   15190: invokevirtual 3548	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   15193: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15196: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15199: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   15202: aconst_null
    //   15203: areturn
    //   15204: aload 32
    //   15206: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15209: ldc2_w 3865
    //   15212: lcmp
    //   15213: ifne +33 -> 15246
    //   15216: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15219: ifeq +13 -> 15232
    //   15222: ldc_w 520
    //   15225: iconst_2
    //   15226: ldc_w 3868
    //   15229: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15232: aload_0
    //   15233: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15236: aload 32
    //   15238: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15241: aload_1
    //   15242: invokestatic 3873	aphv:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BLOnlinePushPack/MsgInfo;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   15245: areturn
    //   15246: aload 32
    //   15248: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15251: ldc2_w 3874
    //   15254: lcmp
    //   15255: ifne +66 -> 15321
    //   15258: new 3877	tencent/im/s2c/msgtype0x210/submsgtype0x101/SubMsgType0x27$MsgBody
    //   15261: dup
    //   15262: invokespecial 3878	tencent/im/s2c/msgtype0x210/submsgtype0x101/SubMsgType0x27$MsgBody:<init>	()V
    //   15265: astore 28
    //   15267: aload 28
    //   15269: aload 32
    //   15271: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15274: invokevirtual 3879	tencent/im/s2c/msgtype0x210/submsgtype0x101/SubMsgType0x27$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15277: pop
    //   15278: aload_0
    //   15279: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15282: sipush 284
    //   15285: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   15288: checkcast 3881	atzz
    //   15291: aload 28
    //   15293: aload_1
    //   15294: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   15297: aload_1
    //   15298: getfield 1208	OnlinePushPack/MsgInfo:lMsgUid	J
    //   15301: invokevirtual 3884	atzz:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x101/SubMsgType0x27$MsgBody;SJ)V
    //   15304: aconst_null
    //   15305: areturn
    //   15306: astore_1
    //   15307: ldc_w 520
    //   15310: iconst_1
    //   15311: aload_1
    //   15312: iconst_0
    //   15313: anewarray 220	java/lang/Object
    //   15316: invokestatic 3887	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   15319: aconst_null
    //   15320: areturn
    //   15321: aload 32
    //   15323: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15326: ldc2_w 3888
    //   15329: lcmp
    //   15330: ifne +76 -> 15406
    //   15333: new 3891	tencent/im/s2c/msgtype0x210/submsgtype0x103/submsgtype0x103$MsgBody
    //   15336: dup
    //   15337: invokespecial 3892	tencent/im/s2c/msgtype0x210/submsgtype0x103/submsgtype0x103$MsgBody:<init>	()V
    //   15340: astore_1
    //   15341: aload_1
    //   15342: aload 32
    //   15344: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15347: invokevirtual 3893	tencent/im/s2c/msgtype0x210/submsgtype0x103/submsgtype0x103$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15350: pop
    //   15351: aload_0
    //   15352: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15355: invokevirtual 3896	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   15358: invokevirtual 3901	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Laojd;
    //   15361: aload_1
    //   15362: invokevirtual 3906	aojd:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x103/submsgtype0x103$MsgBody;)V
    //   15365: aconst_null
    //   15366: areturn
    //   15367: astore_1
    //   15368: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15371: ifeq -15342 -> 29
    //   15374: ldc_w 520
    //   15377: iconst_2
    //   15378: new 88	java/lang/StringBuilder
    //   15381: dup
    //   15382: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   15385: ldc_w 3908
    //   15388: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15391: aload_1
    //   15392: invokevirtual 3909	java/lang/Exception:toString	()Ljava/lang/String;
    //   15395: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15398: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15401: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15404: aconst_null
    //   15405: areturn
    //   15406: aload 32
    //   15408: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15411: ldc2_w 3910
    //   15414: lcmp
    //   15415: ifne +76 -> 15491
    //   15418: new 3913	tencent/im/s2c/msgtype0x210/submsgtype0x104/submsgtype0x104$MsgBody
    //   15421: dup
    //   15422: invokespecial 3914	tencent/im/s2c/msgtype0x210/submsgtype0x104/submsgtype0x104$MsgBody:<init>	()V
    //   15425: astore_1
    //   15426: aload_1
    //   15427: aload 32
    //   15429: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15432: invokevirtual 3915	tencent/im/s2c/msgtype0x210/submsgtype0x104/submsgtype0x104$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15435: pop
    //   15436: aload_0
    //   15437: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15440: invokevirtual 3896	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   15443: invokevirtual 3901	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Laojd;
    //   15446: aload_1
    //   15447: invokevirtual 3918	aojd:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x104/submsgtype0x104$MsgBody;)V
    //   15450: aconst_null
    //   15451: areturn
    //   15452: astore_1
    //   15453: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15456: ifeq -15427 -> 29
    //   15459: ldc_w 520
    //   15462: iconst_2
    //   15463: new 88	java/lang/StringBuilder
    //   15466: dup
    //   15467: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   15470: ldc_w 3920
    //   15473: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15476: aload_1
    //   15477: invokevirtual 3909	java/lang/Exception:toString	()Ljava/lang/String;
    //   15480: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15483: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15486: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15489: aconst_null
    //   15490: areturn
    //   15491: aload 32
    //   15493: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15496: ldc2_w 3921
    //   15499: lcmp
    //   15500: ifne +33 -> 15533
    //   15503: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15506: ifeq +13 -> 15519
    //   15509: ldc_w 520
    //   15512: iconst_2
    //   15513: ldc_w 3924
    //   15516: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15519: aload_0
    //   15520: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15523: aload 32
    //   15525: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15528: aload_1
    //   15529: invokestatic 3927	apiz:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BLOnlinePushPack/MsgInfo;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   15532: areturn
    //   15533: aload 32
    //   15535: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15538: ldc2_w 3928
    //   15541: lcmp
    //   15542: ifne +33 -> 15575
    //   15545: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15548: ifeq +13 -> 15561
    //   15551: ldc_w 520
    //   15554: iconst_2
    //   15555: ldc_w 3931
    //   15558: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15561: aload_0
    //   15562: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15565: aload 32
    //   15567: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15570: invokestatic 3934	alwd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   15573: aconst_null
    //   15574: areturn
    //   15575: aload 32
    //   15577: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15580: ldc2_w 3935
    //   15583: lcmp
    //   15584: ifne +49 -> 15633
    //   15587: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15590: ifeq +13 -> 15603
    //   15593: ldc_w 520
    //   15596: iconst_2
    //   15597: ldc_w 3938
    //   15600: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15603: aload_0
    //   15604: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15607: iconst_1
    //   15608: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   15611: checkcast 211	com/tencent/mobileqq/app/FriendListHandler
    //   15614: checkcast 211	com/tencent/mobileqq/app/FriendListHandler
    //   15617: astore_1
    //   15618: aload_1
    //   15619: ifnull -15590 -> 29
    //   15622: aload_1
    //   15623: aload 32
    //   15625: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15628: invokevirtual 3939	com/tencent/mobileqq/app/FriendListHandler:a	([B)V
    //   15631: aconst_null
    //   15632: areturn
    //   15633: aload 32
    //   15635: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15638: ldc2_w 3940
    //   15641: lcmp
    //   15642: ifne +44 -> 15686
    //   15645: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15648: ifeq +13 -> 15661
    //   15651: ldc_w 520
    //   15654: iconst_2
    //   15655: ldc_w 3943
    //   15658: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15661: aload_0
    //   15662: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15665: aload 32
    //   15667: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15670: aload_1
    //   15671: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   15674: i2l
    //   15675: aload_1
    //   15676: getfield 1201	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   15679: i2l
    //   15680: iconst_0
    //   15681: invokestatic 3948	atmp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BJJZ)V
    //   15684: aconst_null
    //   15685: areturn
    //   15686: aload 32
    //   15688: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15691: ldc2_w 3949
    //   15694: lcmp
    //   15695: ifeq +15 -> 15710
    //   15698: aload 32
    //   15700: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15703: ldc2_w 3951
    //   15706: lcmp
    //   15707: ifne +92 -> 15799
    //   15710: aload_0
    //   15711: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15714: sipush 339
    //   15717: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   15720: checkcast 3954	baph
    //   15723: iconst_4
    //   15724: invokevirtual 3957	baph:a	(I)Lbaps;
    //   15727: astore 28
    //   15729: aload 28
    //   15731: ifnull -15702 -> 29
    //   15734: aload_0
    //   15735: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15738: astore 29
    //   15740: aload 32
    //   15742: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15745: astore 30
    //   15747: aload_1
    //   15748: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   15751: i2l
    //   15752: lstore_2
    //   15753: aload_1
    //   15754: getfield 1201	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   15757: i2l
    //   15758: lstore 15
    //   15760: aload 32
    //   15762: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15765: ldc2_w 3949
    //   15768: lcmp
    //   15769: ifne +24 -> 15793
    //   15772: iconst_0
    //   15773: istore 19
    //   15775: aload 28
    //   15777: aload 29
    //   15779: aload 30
    //   15781: lload_2
    //   15782: lload 15
    //   15784: iload 19
    //   15786: invokeinterface 3960 8 0
    //   15791: aconst_null
    //   15792: areturn
    //   15793: iconst_1
    //   15794: istore 19
    //   15796: goto -21 -> 15775
    //   15799: aload 32
    //   15801: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15804: ldc2_w 3961
    //   15807: lcmp
    //   15808: ifne +30 -> 15838
    //   15811: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15814: ifeq +13 -> 15827
    //   15817: ldc_w 520
    //   15820: iconst_2
    //   15821: ldc_w 3964
    //   15824: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15827: aload 32
    //   15829: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15832: lload_2
    //   15833: invokestatic 3967	awzq:a	([BJ)V
    //   15836: aconst_null
    //   15837: areturn
    //   15838: aload 32
    //   15840: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15843: ldc2_w 3968
    //   15846: lcmp
    //   15847: ifne +195 -> 16042
    //   15850: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15853: ifeq +13 -> 15866
    //   15856: ldc_w 520
    //   15859: iconst_2
    //   15860: ldc_w 3971
    //   15863: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15866: new 3973	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$MsgBody
    //   15869: dup
    //   15870: invokespecial 3974	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$MsgBody:<init>	()V
    //   15873: astore_1
    //   15874: aload 32
    //   15876: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15879: ifnull -15850 -> 29
    //   15882: aload_1
    //   15883: aload 32
    //   15885: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15888: invokevirtual 3975	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15891: pop
    //   15892: aload_1
    //   15893: getfield 3976	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$MsgBody:uint64_from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   15896: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   15899: lstore_2
    //   15900: aload_1
    //   15901: getfield 3977	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$MsgBody:uint64_to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   15904: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   15907: lstore 15
    //   15909: aload_1
    //   15910: getfield 3981	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$MsgBody:msg_notify_item	Ltencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem;
    //   15913: invokevirtual 3984	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15916: checkcast 3983	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem
    //   15919: astore_1
    //   15920: aload_1
    //   15921: getfield 3987	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem:uint32_timeout_s	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   15924: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   15927: istore 4
    //   15929: aload_1
    //   15930: getfield 3990	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem:uint32_event_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   15933: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   15936: istore 5
    //   15938: aload_1
    //   15939: getfield 3993	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem:uint32_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   15942: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   15945: istore 6
    //   15947: aload_1
    //   15948: getfield 3996	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem:uint64_timestamp	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   15951: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   15954: lstore 17
    //   15956: aload_1
    //   15957: getfield 3997	tencent/im/s2c/msgtype0x210/submsgtype0x115/SubMsgType0x115$NotifyItem:bytes_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   15960: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   15963: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   15966: astore_1
    //   15967: aload_0
    //   15968: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15971: sipush 316
    //   15974: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   15977: astore 28
    //   15979: aload 28
    //   15981: instanceof 3999
    //   15984: ifeq -15955 -> 29
    //   15987: aload 28
    //   15989: checkcast 3999	asyu
    //   15992: lload_2
    //   15993: lload 15
    //   15995: lload 17
    //   15997: iload 6
    //   15999: iload 4
    //   16001: iload 5
    //   16003: aload_1
    //   16004: invokevirtual 4002	asyu:a	(JJJIIILjava/lang/String;)V
    //   16007: aconst_null
    //   16008: areturn
    //   16009: astore_1
    //   16010: ldc_w 520
    //   16013: iconst_1
    //   16014: new 88	java/lang/StringBuilder
    //   16017: dup
    //   16018: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   16021: ldc_w 4004
    //   16024: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16027: aload_1
    //   16028: invokevirtual 3548	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   16031: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16034: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16037: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16040: aconst_null
    //   16041: areturn
    //   16042: aload 32
    //   16044: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16047: ldc2_w 4005
    //   16050: lcmp
    //   16051: ifne +142 -> 16193
    //   16054: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16057: ifeq +13 -> 16070
    //   16060: ldc_w 520
    //   16063: iconst_2
    //   16064: ldc_w 4008
    //   16067: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16070: new 4010	tencent/im/s2c/msgtype0x210/submsgtype0x119/SubMsgType0x119$MsgBody
    //   16073: dup
    //   16074: invokespecial 4011	tencent/im/s2c/msgtype0x210/submsgtype0x119/SubMsgType0x119$MsgBody:<init>	()V
    //   16077: astore 28
    //   16079: aload 32
    //   16081: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16084: ifnull -16055 -> 29
    //   16087: aload 28
    //   16089: aload 32
    //   16091: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16094: invokevirtual 4012	tencent/im/s2c/msgtype0x210/submsgtype0x119/SubMsgType0x119$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16097: pop
    //   16098: ldc_w 520
    //   16101: iconst_1
    //   16102: new 88	java/lang/StringBuilder
    //   16105: dup
    //   16106: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   16109: ldc_w 4014
    //   16112: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16115: aload 28
    //   16117: invokevirtual 2142	java/lang/Object:toString	()Ljava/lang/String;
    //   16120: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16123: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16126: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16129: aload_1
    //   16130: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   16133: invokestatic 4017	baic:a	(I)Z
    //   16136: ifne -16107 -> 29
    //   16139: aload_0
    //   16140: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16143: aload 28
    //   16145: invokestatic 4020	baic:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ltencent/im/s2c/msgtype0x210/submsgtype0x119/SubMsgType0x119$MsgBody;)V
    //   16148: ldc_w 520
    //   16151: iconst_1
    //   16152: ldc_w 4022
    //   16155: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16158: aconst_null
    //   16159: areturn
    //   16160: astore_1
    //   16161: ldc_w 520
    //   16164: iconst_1
    //   16165: new 88	java/lang/StringBuilder
    //   16168: dup
    //   16169: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   16172: ldc_w 4004
    //   16175: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16178: aload_1
    //   16179: invokevirtual 3548	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   16182: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16185: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16188: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16191: aconst_null
    //   16192: areturn
    //   16193: aload 32
    //   16195: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16198: ldc2_w 4023
    //   16201: lcmp
    //   16202: ifne +104 -> 16306
    //   16205: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16208: ifeq +13 -> 16221
    //   16211: ldc_w 520
    //   16214: iconst_2
    //   16215: ldc_w 4026
    //   16218: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16221: new 4028	tencent/im/s2c/msgtype0x210/submsgtype0x120/SubMsgType0x120$MsgBody
    //   16224: dup
    //   16225: invokespecial 4029	tencent/im/s2c/msgtype0x210/submsgtype0x120/SubMsgType0x120$MsgBody:<init>	()V
    //   16228: astore_1
    //   16229: aload 32
    //   16231: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16234: ifnull -16205 -> 29
    //   16237: aload_1
    //   16238: aload 32
    //   16240: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16243: invokevirtual 4030	tencent/im/s2c/msgtype0x210/submsgtype0x120/SubMsgType0x120$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16246: pop
    //   16247: aload_0
    //   16248: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16251: aload_1
    //   16252: invokestatic 4035	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ltencent/im/s2c/msgtype0x210/submsgtype0x120/SubMsgType0x120$MsgBody;)V
    //   16255: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16258: ifeq -16229 -> 29
    //   16261: ldc_w 520
    //   16264: iconst_2
    //   16265: ldc_w 4037
    //   16268: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16271: aconst_null
    //   16272: areturn
    //   16273: astore_1
    //   16274: ldc_w 520
    //   16277: iconst_1
    //   16278: new 88	java/lang/StringBuilder
    //   16281: dup
    //   16282: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   16285: ldc_w 4039
    //   16288: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16291: aload_1
    //   16292: invokevirtual 3548	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   16295: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16298: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16301: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16304: aconst_null
    //   16305: areturn
    //   16306: aload 32
    //   16308: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16311: ldc2_w 4040
    //   16314: lcmp
    //   16315: ifne +26 -> 16341
    //   16318: aload_0
    //   16319: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16322: aload 32
    //   16324: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16327: aload_1
    //   16328: getfield 1178	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   16331: aload_1
    //   16332: getfield 1201	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   16335: iconst_0
    //   16336: invokestatic 4046	atpt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BSIZ)V
    //   16339: aconst_null
    //   16340: areturn
    //   16341: aload 32
    //   16343: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16346: ldc2_w 4047
    //   16349: lcmp
    //   16350: ifne +87 -> 16437
    //   16353: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16356: ifeq +13 -> 16369
    //   16359: ldc_w 520
    //   16362: iconst_2
    //   16363: ldc_w 4050
    //   16366: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16369: new 4052	tencent/im/s2c/msgtype0x210/submsgtype0x11a/submsgtype0x11a$MsgBody
    //   16372: dup
    //   16373: invokespecial 4053	tencent/im/s2c/msgtype0x210/submsgtype0x11a/submsgtype0x11a$MsgBody:<init>	()V
    //   16376: astore_1
    //   16377: aload 32
    //   16379: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16382: ifnull -16353 -> 29
    //   16385: aload_1
    //   16386: aload 32
    //   16388: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16391: invokevirtual 4054	tencent/im/s2c/msgtype0x210/submsgtype0x11a/submsgtype0x11a$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16394: pop
    //   16395: invokestatic 4059	augf:a	()Laugf;
    //   16398: aload_1
    //   16399: invokevirtual 4062	augf:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x11a/submsgtype0x11a$MsgBody;)V
    //   16402: aconst_null
    //   16403: areturn
    //   16404: astore_1
    //   16405: ldc_w 520
    //   16408: iconst_1
    //   16409: new 88	java/lang/StringBuilder
    //   16412: dup
    //   16413: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   16416: ldc_w 4064
    //   16419: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16422: aload_1
    //   16423: invokevirtual 3548	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   16426: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16429: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16432: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16435: aconst_null
    //   16436: areturn
    //   16437: aload 32
    //   16439: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16442: ldc2_w 4065
    //   16445: lcmp
    //   16446: ifne +261 -> 16707
    //   16449: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16452: ifeq +13 -> 16465
    //   16455: ldc_w 520
    //   16458: iconst_2
    //   16459: ldc_w 4068
    //   16462: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16465: new 4070	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody
    //   16468: dup
    //   16469: invokespecial 4071	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:<init>	()V
    //   16472: astore_1
    //   16473: aload 32
    //   16475: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16478: ifnull -16449 -> 29
    //   16481: aload_1
    //   16482: aload 32
    //   16484: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16487: invokevirtual 4072	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16490: pop
    //   16491: aload_1
    //   16492: getfield 4073	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   16495: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   16498: ifeq +108 -> 16606
    //   16501: aload_1
    //   16502: getfield 4073	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   16505: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   16508: istore 4
    //   16510: iload 4
    //   16512: iconst_2
    //   16513: if_icmpne +99 -> 16612
    //   16516: aload_0
    //   16517: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16520: invokevirtual 2641	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   16523: aload_1
    //   16524: invokevirtual 4076	com/tencent/av/gaudio/AVNotifyCenter:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody;)V
    //   16527: ldc 140
    //   16529: astore_1
    //   16530: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16533: ifeq -16504 -> 29
    //   16536: ldc_w 520
    //   16539: iconst_2
    //   16540: iconst_4
    //   16541: anewarray 220	java/lang/Object
    //   16544: dup
    //   16545: iconst_0
    //   16546: ldc_w 4078
    //   16549: aastore
    //   16550: dup
    //   16551: iconst_1
    //   16552: iload 4
    //   16554: invokestatic 255	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16557: aastore
    //   16558: dup
    //   16559: iconst_2
    //   16560: ldc_w 4080
    //   16563: aastore
    //   16564: dup
    //   16565: iconst_3
    //   16566: aload_1
    //   16567: aastore
    //   16568: invokestatic 691	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   16571: aconst_null
    //   16572: areturn
    //   16573: astore_1
    //   16574: ldc_w 520
    //   16577: iconst_1
    //   16578: new 88	java/lang/StringBuilder
    //   16581: dup
    //   16582: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   16585: ldc_w 4082
    //   16588: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16591: aload_1
    //   16592: invokevirtual 3548	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   16595: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16598: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16601: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16604: aconst_null
    //   16605: areturn
    //   16606: iconst_0
    //   16607: istore 4
    //   16609: goto -99 -> 16510
    //   16612: aload_1
    //   16613: getfield 4085	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:str_msg_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   16616: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   16619: istore 19
    //   16621: iload 19
    //   16623: ifeq +78 -> 16701
    //   16626: aload_1
    //   16627: getfield 4085	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:str_msg_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   16630: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   16633: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   16636: astore_1
    //   16637: new 910	android/os/Bundle
    //   16640: dup
    //   16641: invokespecial 911	android/os/Bundle:<init>	()V
    //   16644: astore 28
    //   16646: aload 28
    //   16648: ldc_w 4087
    //   16651: iload 4
    //   16653: invokevirtual 2212	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   16656: aload 28
    //   16658: ldc_w 4089
    //   16661: aload_1
    //   16662: invokevirtual 4091	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   16665: aload_0
    //   16666: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16669: ldc_w 4093
    //   16672: bipush 11
    //   16674: iconst_1
    //   16675: aload 28
    //   16677: invokevirtual 929	com/tencent/mobileqq/app/QQAppInterface:notifyObservers	(Ljava/lang/Class;IZLandroid/os/Bundle;)V
    //   16680: goto -150 -> 16530
    //   16683: astore_1
    //   16684: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16687: ifeq +14 -> 16701
    //   16690: ldc_w 520
    //   16693: iconst_2
    //   16694: ldc_w 4095
    //   16697: aload_1
    //   16698: invokestatic 4097	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16701: ldc 140
    //   16703: astore_1
    //   16704: goto -67 -> 16637
    //   16707: aload 32
    //   16709: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16712: ldc2_w 4098
    //   16715: lcmp
    //   16716: ifne +87 -> 16803
    //   16719: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16722: ifeq +13 -> 16735
    //   16725: ldc_w 520
    //   16728: iconst_2
    //   16729: ldc_w 4101
    //   16732: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16735: new 4103	tencent/im/s2c/msgtype0x210/submsgtype0x11b/submsgtype0x11b$MsgBody
    //   16738: dup
    //   16739: invokespecial 4104	tencent/im/s2c/msgtype0x210/submsgtype0x11b/submsgtype0x11b$MsgBody:<init>	()V
    //   16742: astore_1
    //   16743: aload 32
    //   16745: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16748: ifnull -16719 -> 29
    //   16751: aload_1
    //   16752: aload 32
    //   16754: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16757: invokevirtual 4105	tencent/im/s2c/msgtype0x210/submsgtype0x11b/submsgtype0x11b$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16760: pop
    //   16761: invokestatic 4059	augf:a	()Laugf;
    //   16764: aload_1
    //   16765: invokevirtual 4108	augf:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x11b/submsgtype0x11b$MsgBody;)V
    //   16768: aconst_null
    //   16769: areturn
    //   16770: astore_1
    //   16771: ldc_w 520
    //   16774: iconst_1
    //   16775: new 88	java/lang/StringBuilder
    //   16778: dup
    //   16779: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   16782: ldc_w 4110
    //   16785: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16788: aload_1
    //   16789: invokevirtual 3548	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   16792: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16795: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16798: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16801: aconst_null
    //   16802: areturn
    //   16803: aload 32
    //   16805: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16808: ldc2_w 4111
    //   16811: lcmp
    //   16812: ifeq +15 -> 16827
    //   16815: aload 32
    //   16817: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16820: ldc2_w 4113
    //   16823: lcmp
    //   16824: ifne +49 -> 16873
    //   16827: aload_0
    //   16828: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16831: astore 28
    //   16833: aload 32
    //   16835: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16838: astore 29
    //   16840: aload 32
    //   16842: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16845: ldc2_w 4111
    //   16848: lcmp
    //   16849: ifne +18 -> 16867
    //   16852: iconst_1
    //   16853: istore 19
    //   16855: aload 28
    //   16857: aload 29
    //   16859: aload_1
    //   16860: iload 19
    //   16862: invokestatic 4119	aspz:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BLOnlinePushPack/MsgInfo;Z)V
    //   16865: aconst_null
    //   16866: areturn
    //   16867: iconst_0
    //   16868: istore 19
    //   16870: goto -15 -> 16855
    //   16873: aload 32
    //   16875: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   16878: ldc2_w 4120
    //   16881: lcmp
    //   16882: ifne +118 -> 17000
    //   16885: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16888: ifeq +13 -> 16901
    //   16891: ldc_w 520
    //   16894: iconst_2
    //   16895: ldc_w 4123
    //   16898: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16901: new 4125	tencent/im/s2c/msgtype0x210/submsgtype0x128/submsgtype0x128$MsgBody
    //   16904: dup
    //   16905: invokespecial 4126	tencent/im/s2c/msgtype0x210/submsgtype0x128/submsgtype0x128$MsgBody:<init>	()V
    //   16908: astore_1
    //   16909: aload 32
    //   16911: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16914: ifnull +74 -> 16988
    //   16917: aload_1
    //   16918: aload 32
    //   16920: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   16923: invokevirtual 4127	tencent/im/s2c/msgtype0x210/submsgtype0x128/submsgtype0x128$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16926: pop
    //   16927: aload_0
    //   16928: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16931: bipush 127
    //   16933: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   16936: checkcast 4129	aqbe
    //   16939: aload_1
    //   16940: invokevirtual 4132	aqbe:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x128/submsgtype0x128$MsgBody;)V
    //   16943: ldc_w 4134
    //   16946: iconst_2
    //   16947: ldc_w 4136
    //   16950: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16953: aconst_null
    //   16954: areturn
    //   16955: astore_1
    //   16956: ldc_w 520
    //   16959: iconst_1
    //   16960: new 88	java/lang/StringBuilder
    //   16963: dup
    //   16964: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   16967: ldc_w 4138
    //   16970: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16973: aload_1
    //   16974: invokevirtual 3548	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   16977: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16980: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16983: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16986: aconst_null
    //   16987: areturn
    //   16988: ldc_w 520
    //   16991: iconst_2
    //   16992: ldc_w 4140
    //   16995: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16998: aconst_null
    //   16999: areturn
    //   17000: aload 32
    //   17002: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   17005: ldc2_w 4141
    //   17008: lcmp
    //   17009: ifne +51 -> 17060
    //   17012: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17015: ifeq +13 -> 17028
    //   17018: ldc_w 520
    //   17021: iconst_2
    //   17022: ldc_w 4144
    //   17025: invokestatic 724	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   17028: aload_0
    //   17029: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17032: sipush 169
    //   17035: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   17038: checkcast 4146	ahjp
    //   17041: checkcast 4146	ahjp
    //   17044: astore_1
    //   17045: aload_1
    //   17046: ifnull -17017 -> 29
    //   17049: aload_1
    //   17050: aload 32
    //   17052: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   17055: invokevirtual 4147	ahjp:a	([B)V
    //   17058: aconst_null
    //   17059: areturn
    //   17060: aload 32
    //   17062: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   17065: ldc2_w 4148
    //   17068: lcmp
    //   17069: ifne -17040 -> 29
    //   17072: aload_0
    //   17073: aload 32
    //   17075: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   17078: invokespecial 4151	abtl:f	([B)V
    //   17081: aconst_null
    //   17082: areturn
    //   17083: aload 32
    //   17085: getfield 1529	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   17088: ldc2_w 4152
    //   17091: lcmp
    //   17092: ifne -17063 -> 29
    //   17095: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17098: ifeq +13 -> 17111
    //   17101: ldc_w 520
    //   17104: iconst_2
    //   17105: ldc_w 4155
    //   17108: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17111: new 4157	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody
    //   17114: dup
    //   17115: invokespecial 4158	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:<init>	()V
    //   17118: astore 28
    //   17120: aload 32
    //   17122: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   17125: ifnull -17096 -> 29
    //   17128: aload 28
    //   17130: aload 32
    //   17132: getfield 1561	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   17135: invokevirtual 4159	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   17138: pop
    //   17139: aload 28
    //   17141: getfield 4160	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   17144: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   17147: ifeq +87 -> 17234
    //   17150: aload 28
    //   17152: getfield 4160	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   17155: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   17158: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   17161: astore_1
    //   17162: aload 28
    //   17164: getfield 4163	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:bytes_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   17167: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   17170: ifeq +70 -> 17240
    //   17173: aload 28
    //   17175: getfield 4163	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:bytes_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   17178: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   17181: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   17184: astore 28
    //   17186: invokestatic 4168	anpd:a	()Lanpd;
    //   17189: aload_0
    //   17190: getfield 154	abtl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17193: aload_1
    //   17194: aload 28
    //   17196: invokevirtual 4170	anpd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)V
    //   17199: aconst_null
    //   17200: areturn
    //   17201: astore_1
    //   17202: ldc_w 520
    //   17205: iconst_1
    //   17206: new 88	java/lang/StringBuilder
    //   17209: dup
    //   17210: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   17213: ldc_w 4172
    //   17216: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17219: aload_1
    //   17220: invokevirtual 3548	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   17223: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17226: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17229: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   17232: aconst_null
    //   17233: areturn
    //   17234: ldc 140
    //   17236: astore_1
    //   17237: goto -75 -> 17162
    //   17240: ldc 140
    //   17242: astore 28
    //   17244: goto -58 -> 17186
    //   17247: astore 28
    //   17249: goto -6292 -> 10957
    //   17252: astore_1
    //   17253: goto -7851 -> 9402
    //   17256: astore 30
    //   17258: goto -13608 -> 3650
    //   17261: astore 30
    //   17263: goto -13613 -> 3650
    //   17266: iconst_0
    //   17267: istore 19
    //   17269: goto -6068 -> 11201
    //   17272: iload 21
    //   17274: istore 24
    //   17276: iload 22
    //   17278: istore 25
    //   17280: iload 20
    //   17282: istore 26
    //   17284: iload 19
    //   17286: istore 27
    //   17288: goto -7251 -> 10037
    //   17291: goto -7438 -> 9853
    //   17294: aconst_null
    //   17295: astore_1
    //   17296: goto -9675 -> 7621
    //   17299: iconst_0
    //   17300: istore 6
    //   17302: goto -12909 -> 4393
    //   17305: iconst_0
    //   17306: istore 5
    //   17308: goto -12936 -> 4372
    //   17311: aconst_null
    //   17312: astore 30
    //   17314: goto -13767 -> 3547
    //   17317: aconst_null
    //   17318: astore 29
    //   17320: goto -13807 -> 3513
    //   17323: aconst_null
    //   17324: astore 28
    //   17326: goto -13851 -> 3475
    //   17329: iload 7
    //   17331: ifge -12822 -> 4509
    //   17334: iload 8
    //   17336: iflt -12793 -> 4543
    //   17339: goto -12830 -> 4509
    //   17342: iload 5
    //   17344: ifne -12758 -> 4586
    //   17347: iload 6
    //   17349: ifeq -12679 -> 4670
    //   17352: goto -12766 -> 4586
    //   17355: aload 29
    //   17357: astore 28
    //   17359: iload 5
    //   17361: istore 4
    //   17363: goto -9435 -> 7928
    //   17366: aload 30
    //   17368: areturn
    //   17369: sipush 1001
    //   17372: istore 4
    //   17374: aload 29
    //   17376: astore 28
    //   17378: goto -9450 -> 7928
    //   17381: goto -8421 -> 8960
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	17384	0	this	abtl
    //   0	17384	1	paramMsgInfo	MsgInfo
    //   0	17384	2	paramLong	long
    //   451	16922	4	i	int
    //   712	16648	5	j	int
    //   4025	13323	6	k	int
    //   4394	12936	7	m	int
    //   4397	12938	8	n	int
    //   4449	5903	9	i1	int
    //   9631	787	10	i2	int
    //   10200	63	11	i3	int
    //   10213	57	12	i4	int
    //   10226	54	13	i5	int
    //   10236	41	14	i6	int
    //   2405	13589	15	l1	long
    //   6332	9664	17	l2	long
    //   193	17092	19	bool1	boolean
    //   9501	7780	20	bool2	boolean
    //   9531	7742	21	bool3	boolean
    //   9471	7806	22	bool4	boolean
    //   9486	1333	23	bool5	boolean
    //   9940	7335	24	bool6	boolean
    //   9944	7335	25	bool7	boolean
    //   9948	7335	26	bool8	boolean
    //   9952	7335	27	bool9	boolean
    //   108	2272	28	localObject1	Object
    //   2429	1	28	localException1	Exception
    //   2551	315	28	localObject2	Object
    //   2879	26	28	localInvalidProtocolBufferMicroException1	InvalidProtocolBufferMicroException
    //   3392	295	28	localObject3	Object
    //   3693	3	28	localInvalidProtocolBufferMicroException2	InvalidProtocolBufferMicroException
    //   3926	7581	28	localObject4	Object
    //   12013	1	28	localException2	Exception
    //   12053	83	28	localMsgBody	tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.MsgBody
    //   12635	72	28	localException3	Exception
    //   12720	4523	28	localObject5	Object
    //   17247	1	28	localThrowable	java.lang.Throwable
    //   17324	53	28	localObject6	Object
    //   171	2491	29	localObject7	Object
    //   2672	36	29	localInvalidProtocolBufferMicroException3	InvalidProtocolBufferMicroException
    //   3432	13943	29	localObject8	Object
    //   650	2944	30	localObject9	Object
    //   3648	1	30	localException4	Exception
    //   3660	12120	30	localObject10	Object
    //   17256	1	30	localException5	Exception
    //   17261	1	30	localException6	Exception
    //   17312	55	30	localMessageRecord	MessageRecord
    //   729	11873	31	localObject11	Object
    //   22	17109	32	localObject12	Object
    //   2177	10339	33	localObject13	Object
    //   8223	109	34	localalto	alto
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
    //   5890	5926	5928	java/lang/Throwable
    //   6057	6172	6246	java/lang/Exception
    //   6172	6209	6246	java/lang/Exception
    //   6209	6244	6246	java/lang/Exception
    //   6556	6625	6768	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6625	6691	6768	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6697	6766	6768	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6844	6896	6898	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6987	6997	7067	java/lang/Exception
    //   7001	7012	7067	java/lang/Exception
    //   7021	7065	7067	java/lang/Exception
    //   7125	7322	7633	java/lang/Exception
    //   7322	7467	7633	java/lang/Exception
    //   7623	7630	7633	java/lang/Exception
    //   7691	7726	7728	java/lang/Exception
    //   7776	7811	7813	java/lang/Exception
    //   7865	7876	8191	java/lang/Exception
    //   7891	7928	8191	java/lang/Exception
    //   7928	8072	8191	java/lang/Exception
    //   8072	8136	8191	java/lang/Exception
    //   8144	8157	8191	java/lang/Exception
    //   8165	8178	8191	java/lang/Exception
    //   8181	8188	8191	java/lang/Exception
    //   8245	8327	8505	java/lang/Exception
    //   8331	8340	8505	java/lang/Exception
    //   8345	8353	8505	java/lang/Exception
    //   8356	8487	8505	java/lang/Exception
    //   8604	8614	8675	java/lang/Throwable
    //   8755	8775	8777	java/lang/Exception
    //   8842	8854	8856	java/lang/Throwable
    //   8899	8960	8999	java/lang/Exception
    //   8960	8969	8999	java/lang/Exception
    //   8969	8997	8999	java/lang/Exception
    //   9018	9027	8999	java/lang/Exception
    //   9030	9039	8999	java/lang/Exception
    //   9042	9051	8999	java/lang/Exception
    //   9090	9140	9287	java/lang/Exception
    //   9140	9170	9287	java/lang/Exception
    //   9180	9220	9287	java/lang/Exception
    //   9228	9258	9287	java/lang/Exception
    //   9258	9285	9287	java/lang/Exception
    //   9339	9365	9367	java/lang/Exception
    //   11012	11031	11065	java/lang/Exception
    //   11259	11270	11575	java/lang/Exception
    //   11270	11293	11575	java/lang/Exception
    //   11293	11317	11575	java/lang/Exception
    //   11317	11341	11575	java/lang/Exception
    //   11341	11419	11575	java/lang/Exception
    //   11419	11573	11575	java/lang/Exception
    //   11103	11124	11598	java/lang/Exception
    //   11128	11188	11598	java/lang/Exception
    //   11188	11197	11598	java/lang/Exception
    //   11201	11222	11622	java/lang/Exception
    //   11707	11726	11760	java/lang/Exception
    //   11835	11869	11871	java/lang/Exception
    //   11911	11926	11928	java/lang/Exception
    //   11983	11993	12013	java/lang/Exception
    //   12055	12135	12635	java/lang/Exception
    //   12135	12148	12635	java/lang/Exception
    //   12153	12188	12635	java/lang/Exception
    //   12188	12246	12635	java/lang/Exception
    //   12246	12280	12635	java/lang/Exception
    //   12280	12305	12635	java/lang/Exception
    //   12305	12330	12635	java/lang/Exception
    //   12330	12364	12635	java/lang/Exception
    //   12364	12391	12635	java/lang/Exception
    //   12391	12425	12635	java/lang/Exception
    //   12425	12449	12635	java/lang/Exception
    //   12449	12473	12635	java/lang/Exception
    //   12478	12502	12635	java/lang/Exception
    //   12502	12526	12635	java/lang/Exception
    //   12526	12560	12635	java/lang/Exception
    //   12560	12584	12635	java/lang/Exception
    //   12584	12618	12635	java/lang/Exception
    //   12618	12632	12635	java/lang/Exception
    //   12692	12738	12635	java/lang/Exception
    //   12777	12827	12884	java/lang/Exception
    //   12833	12862	12884	java/lang/Exception
    //   12867	12882	12884	java/lang/Exception
    //   12904	12920	12884	java/lang/Exception
    //   12977	13006	13008	java/lang/Exception
    //   13056	13158	13160	java/lang/Exception
    //   13666	13695	13697	java/lang/Exception
    //   13949	13978	13980	java/lang/Exception
    //   14088	14167	14259	java/lang/Exception
    //   14174	14184	14259	java/lang/Exception
    //   14189	14208	14259	java/lang/Exception
    //   14208	14236	14259	java/lang/Exception
    //   14243	14256	14259	java/lang/Exception
    //   14273	14286	14259	java/lang/Exception
    //   14310	14396	14398	java/lang/Exception
    //   14463	14489	14499	java/lang/Exception
    //   14489	14497	14499	java/lang/Exception
    //   14778	14830	14832	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   14983	15022	15171	java/lang/Exception
    //   15022	15168	15171	java/lang/Exception
    //   15267	15304	15306	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   15341	15365	15367	java/lang/Exception
    //   15426	15450	15452	java/lang/Exception
    //   15866	16007	16009	java/lang/Exception
    //   16070	16158	16160	java/lang/Exception
    //   16221	16271	16273	java/lang/Exception
    //   16369	16402	16404	java/lang/Exception
    //   16465	16510	16573	java/lang/Exception
    //   16516	16527	16573	java/lang/Exception
    //   16530	16571	16573	java/lang/Exception
    //   16612	16621	16573	java/lang/Exception
    //   16626	16637	16573	java/lang/Exception
    //   16637	16680	16573	java/lang/Exception
    //   16684	16701	16573	java/lang/Exception
    //   16626	16637	16683	java/lang/Throwable
    //   16735	16768	16770	java/lang/Exception
    //   16901	16953	16955	java/lang/Exception
    //   16988	16998	16955	java/lang/Exception
    //   17111	17162	17201	java/lang/Exception
    //   17162	17186	17201	java/lang/Exception
    //   17186	17199	17201	java/lang/Exception
    //   10947	10957	17247	java/lang/Throwable
    //   9391	9402	17252	java/lang/Throwable
    //   3475	3509	17256	java/lang/Exception
    //   3513	3547	17261	java/lang/Exception
  }
  
  private void b(long paramLong, byte[] paramArrayOfByte)
  {
    Object localObject1 = new submsgtype0x31.MsgBody();
    int i;
    long l1;
    badd localbadd;
    try
    {
      paramArrayOfByte = (submsgtype0x31.MsgBody)((submsgtype0x31.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = new HashMap();
        paramArrayOfByte.put("param_FailCode", "12017");
        paramArrayOfByte.put("fail_step", "msgbyod_null");
        paramArrayOfByte.put("fail_location", "MessageHandler");
        azri.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
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
            azri.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
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
            azri.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
            return;
          }
        } while (!String.valueOf(paramLong).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
        paramArrayOfByte = new bade();
        paramArrayOfByte.c = String.valueOf(l1);
        paramArrayOfByte.b = String.valueOf(l2);
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_FailCode", "12018");
        ((HashMap)localObject1).put("fail_step", "success_" + i);
        ((HashMap)localObject1).put("fail_location", "MessageHandler");
        azri.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBPushNotifaction", true, 0L, 0L, (HashMap)localObject1, "");
        localObject1 = (bacu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(62);
        if (i == 1)
        {
          bacu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte)0, paramArrayOfByte.c);
          bacu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte.c);
          paramArrayOfByte.a = 1;
          ((bacu)localObject1).a(paramArrayOfByte.c, 1);
          a(8004, true, paramArrayOfByte);
          return;
        }
      } while (i != 0);
      localObject1 = String.valueOf(l1);
      localbadd = (badd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61);
      paramArrayOfByte.a((String)localObject1);
      localbadd.a(paramArrayOfByte);
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
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(str, 7000, i);
          }
        }
      }
      boolean bool = false;
      localObject2 = bacu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1);
      if (localObject2 != null) {
        bool = ((Boolean)((Pair)localObject2).second).booleanValue();
      }
      if (!bool) {
        break label783;
      }
    }
    localbadd.a((String)localObject1, 1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSubAccountKey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), String.valueOf(l1), new abtn(this, localbadd));
    for (;;)
    {
      paramArrayOfByte.a = 0;
      a(8004, true, paramArrayOfByte);
      return;
      label783:
      if (localbadd.a(String.valueOf(l1), 2))
      {
        i = 1 - this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1, 7000);
        if (i != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d((String)localObject1, 7000, i);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new String[] { alof.x, localObject1 });
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
          paramArrayOfByte = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131693403);
        }
      }
      for (;;)
      {
        amkl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l), paramArrayOfByte, 1, false, true);
        return;
        label395:
        i = 0;
        break;
        label400:
        paramArrayOfByte = (byte[])localObject;
        if (paramInt == 13) {
          if (1 == i) {
            paramArrayOfByte = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131693425);
          } else {
            paramArrayOfByte = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131693407);
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
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x136");
    }
    Submsgtype0x136.MsgBody localMsgBody = new Submsgtype0x136.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      if (localMsgBody.uint32_msg_type.get() == 0) {
        ((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(String.valueOf(localMsgBody.uint64_group_id.get()), 1, 0, null, 0);
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x136 " + paramArrayOfByte);
    }
  }
  
  private void g(byte[] paramArrayOfByte)
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
  
  private void h(byte[] paramArrayOfByte)
  {
    Object localObject = new submsgtype0x116.MsgBody();
    try
    {
      ((submsgtype0x116.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      long l1 = lfx.a(((submsgtype0x116.MsgBody)localObject).uint32_group_id.get());
      long l2 = lfx.a(((submsgtype0x116.MsgBody)localObject).uint32_room_id.get());
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
  
  private void i(byte[] paramArrayOfByte)
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
          localObject = new StringBuilder(alud.a(2131708234));
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
  
  private void j(byte[] paramArrayOfByte)
  {
    long l = bdqa.a(paramArrayOfByte, 0);
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
                  alul.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693420), true);
                  aluv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 6);
                  ((aluj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).notifyUI(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED });
                  return;
                } while (localHotChatInfo == null);
                localHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT);
                alul.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693396), true);
                aluv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 6);
                ((aluj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).notifyUI(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT });
                return;
              } while (localHotChatInfo == null);
              localHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT);
              alul.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693397), true);
              aluv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 6);
              ((aluj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).notifyUI(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT });
              return;
              if (j != 2) {
                break;
              }
            } while (localHotChatInfo == null);
            localHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT__LONG_TIME_NOT_SAY);
            alul.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693395), false);
            aluv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 6);
            ((aluj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).notifyUI(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_LEFT__LONG_TIME_NOT_SAY });
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
        boolean bool = bntp.a(i);
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
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (bdnn.c((String)localObject2)))
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
            Object localObject3 = bafk.a(paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get());
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (bdnn.c((String)localObject1)))
            {
              TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
              if (localTroopManager.b((String)localObject1) == null)
              {
                localObject2 = new TroopInfo();
                ((TroopInfo)localObject2).troopuin = ((String)localObject1);
                ((TroopInfo)localObject2).troopcode = ((String)localObject3);
                localTroopManager.a((TroopInfo)localObject2);
                localObject3 = (amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
                ((amdu)localObject3).a(((TroopInfo)localObject2).troopuin, false, "", true, true, true, false);
                ((amdu)localObject3).a(1, aloz.a(((TroopInfo)localObject2).troopuin), 0L, 2, 0, 0, true);
                ((amdu)localObject3).notifyUI(6, true, new Object[] { Integer.valueOf(6), Byte.valueOf(0), localObject1 });
                ((amdu)localObject3).notifyUI(127, true, new Object[] { localObject1 });
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
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(alof.W, 9000, 0 - bafj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
            bafj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
            bafi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
            localObject1 = (alxr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(alof.M, 0, true, true);
            ((alxr)localObject1).b();
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
        ayyo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localArrayList);
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
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80065A9", "0X80065A9", 0, 0, "", "", "", "");
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
      localIntent.putExtra(atzy.b, (String)localObject1);
      localIntent.putExtra("activepull_push_flag", true);
      Object localObject2 = atzy.jdField_a_of_type_JavaLangString;
      Object localObject3 = bdal.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130840158);
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
      localToServiceMsg.extraData.putStringArray("cmds", new String[] { localObject1, localObject2, localObject1 });
      localToServiceMsg.extraData.putParcelable("intent", localIntent);
      localToServiceMsg.extraData.putParcelable("bitmap", (Parcelable)localObject3);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService(localToServiceMsg);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext();
      if (!bdmh.a((Context)localObject1)) {
        break;
      }
      localObject2 = (atzy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(145);
      ((atzy)localObject2).a(localIntent);
      localObject3 = (auab)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(72);
      if (SettingCloneUtil.readValue((Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ((Context)localObject1).getString(2131694138), "qqsetting_lock_screen_whenexit_key", true))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "handlePullActivePushMsg, start lsActivity");
        }
        ((auab)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, alof.aw, 9653, false, atzx.a(paramMsgBody, 1008, localIntent));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((atzy)localObject2).jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush);
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
    alto localalto;
    TroopManager localTroopManager;
    alzl localalzl;
    aknx localaknx;
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
                localalto = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                localalzl = (alzl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
                localaknx = (aknx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
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
                  localalto.a(paramArrayOfByte);
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
                    localObject2 = localalto.a(((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get() + "");
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
        paramArrayOfByte = localalto.a(String.valueOf(i));
        if (paramArrayOfByte != null) {}
        for (paramArrayOfByte.group_name = ((String)localObject2);; paramArrayOfByte.group_name = ((String)localObject2))
        {
          localalto.a(paramArrayOfByte);
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
      localalto.a(paramArrayOfByte, (byte[])localObject1);
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
        localalto.a(l1 + "", k);
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModFriendGroup  = id:" + l1 + " newgroupid:" + k);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(9, true, new Object[] { l1 + "", Byte.valueOf((byte)k), Byte.valueOf((byte)i) });
        break label1408;
        if (!paramArrayOfByte.msg_del_friend.has()) {
          break;
        }
        localObject1 = ((SubMsgType0x27.DelFriend)paramArrayOfByte.msg_del_friend.get()).rpt_uint64_uins.get();
        paramArrayOfByte = (uls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(253);
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label2070;
          }
          l1 = ((Long)((Iterator)localObject1).next()).longValue();
          localalto.d(l1 + "");
          localalzl.b(l1 + "");
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a DelFriend  = id:" + l1);
          }
          try
          {
            localObject2 = (bfyh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165);
            if ((localObject2 != null) && (((bfyh)localObject2).a(l1 + "")))
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
          amka.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2);
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
                  if (localTroopManager.a((String)localObject5, alww.a((byte[])localObject7))) {
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
                    if (localTroopManager.b((String)localObject5, alww.a((byte[])localObject7))) {
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
                  akey.a((String)localObject5, ((SubMsgType0x27.SnsUpdateItem)localObject7).bytes_value.get().toStringUtf8(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                }
                localObject1 = (SpecialCareInfo)((HashMap)localObject3).get(localObject5);
                paramArrayOfByte = (byte[])localObject1;
                if (localObject1 == null)
                {
                  localObject1 = localalto.a(String.valueOf(l1));
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
        localalto.c((List)localObject1);
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
          localObject1 = localalto.e(String.valueOf(l1));
        } while (localObject1 == null);
        if (i == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ((Friends)localObject1).setShieldFlag(bool);
          localalto.a((Friends)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).notifyUI(56, true, new Object[] { Long.valueOf(l1), Boolean.valueOf(bool), Boolean.valueOf(true), Boolean.valueOf(true), "" });
          break;
        }
        if (!paramArrayOfByte.msg_mod_profile.has()) {
          break;
        }
        j = a(paramArrayOfByte, localalto, localTroopManager, null, localaknx, arrayOfFriends, j);
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
          paramArrayOfByte = localalto.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          if ((i != paramArrayOfByte.lLoginDays) || (k != paramArrayOfByte.lQQMasterLogindays))
          {
            paramArrayOfByte.lLoginDays = i;
            paramArrayOfByte.lQQMasterLogindays = k;
            localalto.a(paramArrayOfByte);
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
              localObject4 = localalto.e(Long.toString(l1));
              paramArrayOfByte = null;
              if (localObject4 != null) {
                paramArrayOfByte = ((Friends)localObject4).remark;
              }
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModFriendRemark  : 0 Friend uin = " + ((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + "备注 = " + ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8() + ",oldRemark = " + paramArrayOfByte);
              }
              localalto.b(((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + "", ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8());
              localObject5 = localalto.b(((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + "");
              localObject6 = ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8();
              if ((localObject5 != null) && (!((String)localObject6).equals(((Card)localObject5).strReMark)))
              {
                ((Card)localObject5).strReMark = ((String)localObject6);
                localalto.a((Card)localObject5);
              }
              if ((localObject4 != null) && (((Friends)localObject4).isFriend()) && (amax.b((String)localObject6, paramArrayOfByte))) {
                amax.b(l1, (String)localObject6, (alrk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53));
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
        localObject1 = localalto.a((String)localObject3);
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
        localalto.a(paramArrayOfByte);
        paramArrayOfByte = localalto.b(((SubMsgType0x27.ModLongNick)localObject5).uint64_uin.get() + "");
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.vRichSign = ((byte[])localObject4);
          paramArrayOfByte.lSignModifyTime = l1;
          localalto.a(paramArrayOfByte);
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
        paramArrayOfByte = bdgg.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l2 + "", l3 + "");
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
            amax.a("cardpush", ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toByteArray(), ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().size());
            if (paramArrayOfByte != null)
            {
              paramArrayOfByte.colorNick = bdrv.a(((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get());
              paramArrayOfByte.name = bdrv.b(paramArrayOfByte.colorNick);
              localTroopManager.a(l1 + "", l3 + "", paramArrayOfByte.colorNick, -100, null, null, -100, -100, -100, -100L, -100L);
            }
          }
          for (;;)
          {
            if (paramArrayOfByte == null) {
              break label6462;
            }
            bdgg.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte);
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
              paramArrayOfByte.colorNick = bdrv.a(((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get());
              paramArrayOfByte.name = bdrv.b(paramArrayOfByte.colorNick);
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
          localObject6 = azaf.a(-1024);
          l2 = ayzl.a();
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
        ((avsm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160)).a(paramArrayOfByte.bytes_redpoint_info.get().toByteArray());
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
        ((ztp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(39, (Bundle)localObject1);
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
        ((ztp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(39, (Bundle)localObject1);
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
            localObject1 = (alvm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(3);
            if (localObject1 == null) {
              break;
            }
            ((alvm)localObject1).a(paramArrayOfByte);
            break;
          }
          if ((i != 2) && (i != 3)) {
            break;
          }
          localObject1 = (alxj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(57);
          if (localObject1 == null) {
            break;
          }
          ((alxj)localObject1).a(i, paramArrayOfByte);
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
                localObject1 = bdal.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130840158);
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
                  ((aobj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(240)).a(paramArrayOfByte);
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
                    bdsr.a(paramArrayOfByte);
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
            localalto.a(arrayOfFriends, j);
            return;
          }
        }
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    ((asyf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(268)).a(paramArrayOfByte, paramInt);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt, MsgInfo paramMsgInfo)
  {
    ((asyf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(268)).a(paramArrayOfByte, paramInt, paramMsgInfo);
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
      paramArrayOfByte = (MessageForNearbyLiveTip)azaf.a(-2053);
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
        paramArrayOfByte.senderuin = String.valueOf(paramMsgInfo.lFromUin + alof.l);
        paramArrayOfByte.frienduin = String.valueOf(paramMsgInfo.lFromUin + alof.l);
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
      } while (alww.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte, true));
      paramMsgInfo.add(paramArrayOfByte);
      if (paramArrayOfByte.senderuin.equals(String.valueOf(1822701914L + alof.l))) {
        paramArrayOfByte.isLiving = true;
      }
      if (paramArrayOfByte.isLiving)
      {
        bool2 = alww.a(paramMsgInfo);
        int i = abti.a(paramMsgInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if ((bool2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {}
        for (bool1 = true;; bool1 = false)
        {
          ((QQMessageFacade)localObject).a(paramMsgInfo, str, bool1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((int)paramArrayOfByte.time);
          if (babd.a()) {
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
      bool1 = alww.a(paramMsgInfo);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (!bool1) {
        break label780;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop) {}
    label780:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((QQMessageFacade)localObject).a(paramMsgInfo, str, bool1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((int)paramArrayOfByte.time);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte, amlj paramamlj)
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
            autr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (submsgtype0xc7.HotFriendNotify)localObject, paramamlj);
          }
          break;
        case 4000: 
          if (((submsgtype0xc7.ForwardBody)localObject).msg_relational_chain_change.has())
          {
            localObject = (submsgtype0xc7.RelationalChainChange)((submsgtype0xc7.ForwardBody)localObject).msg_relational_chain_change.get();
            if (((submsgtype0xc7.RelationalChainChange)localObject).uint64_appid.get() == 10001L) {
              autm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (submsgtype0xc7.RelationalChainChange)localObject, paramamlj);
            } else if (((submsgtype0xc7.RelationalChainChange)localObject).uint64_appid.get() == 19999L) {
              autv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (submsgtype0xc7.RelationalChainChange)localObject, paramamlj);
            } else if (((submsgtype0xc7.RelationalChainChange)localObject).uint64_appid.get() == 10002L) {
              aerr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (submsgtype0xc7.RelationalChainChange)localObject, paramamlj);
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
                    localObject2 = (bcio)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(355);
                    if (localObject2 != null) {
                      ((bcio)localObject2).a(l1);
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
                  localObject2 = (bcio)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(355);
                  if (localObject2 != null) {
                    ((bcio)localObject2).b(l1, l2, i);
                  }
                  i = 1;
                  j += 1;
                }
              }
            }
            if ((k != 0) && (l2 != 0L))
            {
              localObject1 = (bcim)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(171);
              if (localObject1 != null) {
                ((bcim)localObject1).notifyUI(6, true, new Object[] { Long.valueOf(l2) });
              }
            }
            if ((localMsgBody.uint32_sub_cmd.get() == 1) || (localMsgBody.uint32_sub_cmd.get() == 4))
            {
              ((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(paramArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abtl
 * JD-Core Version:    0.7.0.1
 */