import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import QQService.EVIPSPEC;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopNameHelper;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
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
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.observer.AccountObserver;
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

public class addn
  implements adci
{
  private static int a(adan paramadan, SubMsgType0x27.ForwardBody paramForwardBody, anyw paramanyw, amsx paramamsx, Friends[] paramArrayOfFriends, int paramInt)
  {
    paramForwardBody = (SubMsgType0x27.ModProfile)paramForwardBody.msg_mod_profile.get();
    int n = paramInt;
    long l2;
    int m;
    int k;
    int i1;
    int i2;
    label737:
    Object localObject1;
    Object localObject2;
    int i3;
    if (paramForwardBody.uint64_uin.has())
    {
      l2 = paramForwardBody.uint64_uin.get();
      Iterator localIterator = paramForwardBody.rpt_msg_profile_infos.get().iterator();
      m = 0;
      k = 0;
      n = 0;
      i1 = paramInt;
      paramInt = n;
      if (localIterator.hasNext())
      {
        paramForwardBody = (SubMsgType0x27.ProfileInfo)localIterator.next();
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
            localObject1 = paramForwardBody.bytes_value.get().toStringUtf8();
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModProfile Nick = " + (String)localObject1);
            }
            localObject2 = paramanyw.e(Long.toString(l2));
            paramForwardBody = null;
            if (localObject2 != null) {
              paramForwardBody = ((Friends)localObject2).name;
            }
            paramArrayOfFriends[i1] = paramanyw.a(l2 + "", (String)localObject1);
            if ((localObject2 != null) && (((Friends)localObject2).isFriend()) && (aofp.a((String)localObject1, paramForwardBody))) {
              aofp.a(l2, (String)localObject1, (anws)paramadan.a().getManager(53));
            }
            paramForwardBody = paramanyw.b(l2 + "");
            if (paramForwardBody != null)
            {
              paramForwardBody.strNick = ((String)localObject1);
              paramanyw.a(paramForwardBody);
              paramadan.a().a(2).notifyUI(1, true, paramForwardBody);
            }
            paramadan.a().a(1).notifyUI(3, true, Long.toString(l2));
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
              localObject1 = (anum)paramadan.a().a(2);
              if (localObject1 != null)
              {
                i3 = paramForwardBody.byteAt(0);
                if (i3 != 101) {
                  ((anum)localObject1).d(i3);
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
      break label737;
      paramForwardBody = paramForwardBody.bytes_value.get();
      if ((paramForwardBody != null) && (paramForwardBody.size() == 2))
      {
        n = paramForwardBody.byteAt(0);
        n = (short)(paramForwardBody.byteAt(1) | n << 8);
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModProfile Head = " + n);
        }
        ((FriendListHandler)paramadan.a().a(1)).c(Long.toString(l2));
        paramForwardBody = paramanyw.b(l2 + "");
        if (paramForwardBody != null)
        {
          paramForwardBody.nFaceID = n;
          paramanyw.a(paramForwardBody);
          paramadan.a().a(1).notifyUI(4, true, new Object[] { l2 + "", paramForwardBody, null });
          paramadan.a().a(2).notifyUI(1, true, paramForwardBody);
        }
      }
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
      i2 = paramForwardBody.bytes_value.get().byteAt(0);
      if (i2 == 1) {
        n = 0;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModProfile Sex = " + n);
        }
        paramForwardBody = paramanyw.b(l2 + "");
        if (paramForwardBody != null)
        {
          paramForwardBody.shGender = ((short)n);
          paramanyw.a(paramForwardBody);
          paramadan.a().a(2).notifyUI(1, true, paramForwardBody);
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
      paramadan.a(i2);
      ((aogu)paramadan.a().a(13)).notifyUI(101, true, Integer.valueOf(i2));
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("vip", 2, "bubble id = " + i2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, "vip update uin=" + l2);
      }
      paramForwardBody = paramForwardBody.bytes_value.get();
      localObject1 = paramanyw.e(Long.toString(l2));
      n = k;
      if (localObject1 == null) {
        break;
      }
      localObject1 = (Friends)((Friends)localObject1).clone();
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, String.format("bit info = %02X", new Object[] { Byte.valueOf(paramForwardBody.byteAt(0)) }));
      }
      i2 = ((Friends)localObject1).qqVipInfo;
      if ((paramForwardBody.byteAt(0) & 0x80) == 0)
      {
        n = 0;
        label1726:
        ((Friends)localObject1).qqVipInfo = (n << 24 | 0xFFFFFF & i2);
        i2 = ((Friends)localObject1).superQqInfo;
        if ((paramForwardBody.byteAt(0) & 0x8) != 0) {
          break label2206;
        }
        n = 0;
        label1764:
        ((Friends)localObject1).superQqInfo = (n << 24 | 0xFFFFFF & i2);
        if ((paramForwardBody.byteAt(0) & 0x40) == 0) {
          break label2212;
        }
        bool1 = true;
        label1795:
        if (QLog.isColorLevel()) {
          QLog.d("vip", 2, "is year vip =" + bool1);
        }
        if (!bool1) {
          break label2218;
        }
        n = 65536;
        label1839:
        if (!((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
          break label2224;
        }
        ((Friends)localObject1).superVipInfo = (((Friends)localObject1).superVipInfo & 0xFF00FFFF | n);
      }
      for (;;)
      {
        if (((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB)) {
          ((Friends)localObject1).bigClubInfo = (n | ((Friends)localObject1).bigClubInfo & 0xFF00FFFF);
        }
        if (QLog.isColorLevel()) {
          QLog.d("vip", 2, String.format("SVIP = %08X, VIP = %08X, SuperQQ = %08X", new Object[] { Integer.valueOf(((Friends)localObject1).superVipInfo), Integer.valueOf(((Friends)localObject1).qqVipInfo), Integer.valueOf(((Friends)localObject1).superQqInfo) }));
        }
        paramanyw.a((Friends)localObject1);
        ((aogu)paramadan.a().a(13)).notifyUI(100, true, null);
        if (paramadan.a().getCurrentAccountUin().equals(Long.toString(l2)))
        {
          paramForwardBody = new Intent("tencent.video.q2v.SVIP.PAY");
          paramForwardBody.putExtra("SVIPpaySuccess", true);
          paramForwardBody.setPackage(MobileQQ.getContext().getPackageName());
          paramadan.a().getApp().sendBroadcast(paramForwardBody);
        }
        if (paramadan.a().getCurrentAccountUin().equals(Long.toString(l2)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("vip", 2, "[EmoticonUpdateAuth] 23105 updateEmoticonAuth");
          }
          paramForwardBody = (anwx)paramadan.a().a(12);
          paramForwardBody.a(0, 0);
          paramForwardBody.a(0, 0, 1, 0);
          if (QLog.isColorLevel()) {
            QLog.d("QVipSettingMe.", 2, "[vipInfoPush] 23105 request vipInfoHandler");
          }
          biik.a(paramadan.a(), "last_pull_pay_rule", 0L);
          paramForwardBody = ((TicketManager)paramadan.a().getManager(2)).getSkey(paramadan.a().getCurrentAccountUin());
          ((aokv)paramadan.a().a(27)).a(paramForwardBody, l2 + "");
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        n = 1;
        break label1726;
        label2206:
        n = 1;
        break label1764;
        label2212:
        bool1 = false;
        break label1795;
        label2218:
        n = 0;
        break label1839;
        label2224:
        if (((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
          ((Friends)localObject1).qqVipInfo = (((Friends)localObject1).qqVipInfo & 0xFF00FFFF | n);
        } else if (((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
          ((Friends)localObject1).superQqInfo = (((Friends)localObject1).superQqInfo & 0xFF00FFFF | n);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, "vip update uin=" + l2);
      }
      paramForwardBody = paramForwardBody.bytes_value.get();
      localObject1 = Long.toString(l2);
      localObject2 = paramanyw.e((String)localObject1);
      n = k;
      if (localObject2 == null) {
        break;
      }
      localObject2 = (Friends)((Friends)localObject2).clone();
      boolean bool1 = ((Friends)localObject2).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
      boolean bool2 = ((Friends)localObject2).isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
      boolean bool3 = ((Friends)localObject2).isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ);
      boolean bool4 = ((Friends)localObject2).isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB);
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
        label2491:
        n = i4;
        if (i3 < 4)
        {
          if ((j & i2) != 0) {
            n = 13 - i3;
          }
        }
        else
        {
          label2516:
          if (QLog.isColorLevel()) {
            QLog.d("vip", 2, String.format("[%02X%02X] => LV %d", new Object[] { Byte.valueOf(i), Byte.valueOf(j), Integer.valueOf(n) }));
          }
          if (!bool1) {
            break label2745;
          }
          ((Friends)localObject2).superVipInfo = (((Friends)localObject2).superVipInfo & 0xFFFF0000 | 0xFFFF & n);
        }
      }
      for (;;)
      {
        if (bool4) {
          ((Friends)localObject2).bigClubInfo = (n & 0xFFFF | ((Friends)localObject2).bigClubInfo & 0xFFFF0000);
        }
        paramanyw.a((Friends)localObject2);
        if (paramadan.a().getCurrentAccountUin().equals(localObject1)) {
          paramadan.a().a(13).notifyUI(100, true, null);
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        i3 += 1;
        i2 = (byte)(i2 << 1);
        break label2491;
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
        break label2516;
        label2745:
        if (bool2) {
          ((Friends)localObject2).qqVipInfo = (((Friends)localObject2).qqVipInfo & 0xFFFF0000 | 0xFFFF & n);
        } else if (bool3) {
          ((Friends)localObject2).superQqInfo = (((Friends)localObject2).superQqInfo & 0xFFFF0000 | 0xFFFF & n);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, "svip update uin=" + l2);
      }
      paramForwardBody = paramForwardBody.bytes_value.get();
      localObject1 = Long.toString(l2);
      localObject2 = paramanyw.e((String)localObject1);
      n = k;
      if (localObject2 == null) {
        break;
      }
      localObject2 = (Friends)((Friends)localObject2).clone();
      if ((paramForwardBody.byteAt(5) & 0x20) != 0)
      {
        bool1 = true;
        label2893:
        i2 = ((Friends)localObject2).superVipInfo;
        if (!bool1) {
          break label3074;
        }
      }
      label3074:
      for (n = 1;; n = 0)
      {
        ((Friends)localObject2).superVipInfo = (n << 24 | 0xFFFFFF & i2);
        paramanyw.a((Friends)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("vip", 2, "isSVip=" + bool1 + "friend.superVipInfo=" + ((Friends)localObject2).superVipInfo);
        }
        if (paramadan.a().getCurrentAccountUin().equals(localObject1))
        {
          paramadan.a().a(13).notifyUI(100, true, null);
          if (QLog.isColorLevel()) {
            QLog.d("vip", 2, "[EmoticonUpdateAuth] 23107 updateEmoticonAuth");
          }
          paramForwardBody = (anwx)paramadan.a().a(12);
          paramForwardBody.a(0, 0);
          paramForwardBody.a(0, 0, 1, 0);
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        bool1 = false;
        break label2893;
      }
      paramForwardBody = paramForwardBody.bytes_value.get();
      n = k;
      if ((paramForwardBody.byteAt(5) & 0x2) == 0) {
        break;
      }
      localObject1 = paramadan.a().getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
      if ((paramForwardBody.byteAt(1) & 0x2) != 0) {
        n = 2;
      }
      for (;;)
      {
        if (n != -1)
        {
          ((SharedPreferences)localObject1).edit().putInt("message_roam_flag" + paramadan.a().getCurrentAccountUin(), n).apply();
          paramadan.a().a(1).notifyUI(101, true, Integer.valueOf(n));
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        if (((SharedPreferences)localObject1).getInt("message_roam_flag" + paramadan.a().getCurrentAccountUin(), -1) == 2) {
          n = 1;
        } else {
          n = -1;
        }
      }
      paramForwardBody = paramForwardBody.bytes_value.get();
      if (((paramForwardBody.byteAt(31) & 0x20) != 0) || ((paramForwardBody.byteAt(34) & 0x10) != 0) || ((paramForwardBody.byteAt(29) & 0x10) != 0))
      {
        localObject1 = paramadan.a().getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
        if (((paramForwardBody.byteAt(11) & 0x20) == 0) && ((paramForwardBody.byteAt(14) & 0x10) == 0)) {
          break label3630;
        }
        n = 4;
        label3353:
        if (n != -1)
        {
          ((SharedPreferences)localObject1).edit().putInt("message_roam_flag" + paramadan.a().getCurrentAccountUin(), n).apply();
          paramadan.a().a(1).notifyUI(101, true, Integer.valueOf(n));
        }
      }
      if ((paramForwardBody.byteAt(12) & 0x8) != 0)
      {
        bool1 = true;
        label3438:
        bduh.a(paramadan.a(), bool1);
        if ((paramForwardBody.byteAt(13) & 0x40) == 0) {
          break label3714;
        }
      }
      label3714:
      for (bool1 = true;; bool1 = false)
      {
        n = k;
        if (SettingCloneUtil.readValue(paramadan.a().getApplication(), Long.toString(l2), null, "qqsetting_pcactive_key", false) == bool1) {
          break;
        }
        SettingCloneUtil.writeValue(paramadan.a().getApplication(), Long.valueOf(l2).toString(), null, "qqsetting_pcactive_key", bool1);
        paramForwardBody = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
        paramForwardBody.putExtra("pcActive", bool1);
        paramForwardBody.putExtra("uin", Long.valueOf(l2).toString());
        paramadan.a().getApp().sendBroadcast(paramForwardBody);
        if (bool1)
        {
          SettingCloneUtil.writeValue(paramadan.a().getApplication(), Long.toString(l2), null, "pcactive_config", true);
          paramadan.a().openMsfPCActive(Long.toString(l2), "config", true);
          QLog.d("OnlinePush", 1, "PCActive opened: true by switch push");
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break label737;
        label3630:
        if ((paramForwardBody.byteAt(9) & 0x10) != 0)
        {
          n = 3;
          break label3353;
        }
        n = ((SharedPreferences)localObject1).getInt("message_roam_flag" + paramadan.a().getCurrentAccountUin(), -1);
        if ((n == 4) || (n == 3))
        {
          n = 1;
          break label3353;
        }
        n = -1;
        break label3353;
        bool1 = false;
        break label3438;
      }
      long l1 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asLongBuffer().get();
      localObject1 = paramanyw.a(String.valueOf(l2));
      paramForwardBody = (SubMsgType0x27.ForwardBody)localObject1;
      if (localObject1 == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = String.valueOf(l2);
      }
      paramForwardBody.pendantId = l1;
      paramForwardBody.timestamp = System.currentTimeMillis();
      paramanyw.a(paramForwardBody);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Pendant, uin=" + l2 + ", id=" + paramForwardBody.pendantId);
      }
      paramForwardBody = new HashSet(1);
      paramForwardBody.add(String.valueOf(l2));
      paramadan.a().a(1).notifyUI(66, true, paramForwardBody);
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
      paramInt = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      localObject1 = paramanyw.a(String.valueOf(l2));
      paramForwardBody = (SubMsgType0x27.ForwardBody)localObject1;
      if (localObject1 == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = String.valueOf(l2);
      }
      if ((paramForwardBody.uVipFont != gc.a(paramInt)) || (paramForwardBody.vipFontType != gc.b(paramInt)))
      {
        paramForwardBody.uVipFont = gc.a(paramInt);
        paramForwardBody.vipFontType = gc.b(paramInt);
        paramForwardBody.timestamp = System.currentTimeMillis();
        paramanyw.a(paramForwardBody);
        bhto.a(paramadan.a());
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Font, uin=" + l2 + ", id=" + paramForwardBody.uVipFont + ", type = " + paramForwardBody.vipFontType);
      }
      n = (int)gc.a(paramInt);
      paramInt = m;
      m = n;
      break label737;
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      localObject1 = paramanyw.a(String.valueOf(l2));
      paramForwardBody = (SubMsgType0x27.ForwardBody)localObject1;
      if (localObject1 == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = String.valueOf(l2);
        paramForwardBody.magicFont = -1;
      }
      if (paramForwardBody.magicFont != i2)
      {
        paramForwardBody.magicFont = i2;
        paramForwardBody.timestamp = System.currentTimeMillis();
        paramanyw.a(paramForwardBody);
        bhto.a(paramadan.a());
      }
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push Get MagicFont uin = " + l2 + ", magicFont = " + i2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      localObject1 = paramanyw.a(String.valueOf(l2));
      n = 0;
      paramForwardBody = (SubMsgType0x27.ForwardBody)localObject1;
      if (localObject1 == null)
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
        ((gc)paramadan.a().getManager(42)).e();
        n = 1;
      }
      if (n != 0) {
        paramanyw.a(paramForwardBody);
      }
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push Get fontEffect uin = " + l2 + ", fontEffect = " + i2 + ", updateTime = " + paramForwardBody.fontEffectLastUpdateTime);
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
      k = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      n = k;
      if (k == 0) {
        break;
      }
      n = 1;
      m = paramInt;
      paramInt = n;
      break label737;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      localObject1 = paramanyw.a(String.valueOf(l2));
      paramForwardBody = (SubMsgType0x27.ForwardBody)localObject1;
      if (localObject1 == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = String.valueOf(l2);
      }
      if (paramForwardBody.colorRingId != n)
      {
        paramForwardBody.colorRingId = n;
        paramForwardBody.timestamp = System.currentTimeMillis();
        paramanyw.a(paramForwardBody);
        bhxi.a(paramForwardBody.uin, 1, paramadan.a().getCurrentAccountUin());
      }
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get ColorRing, uin=" + l2 + ", id=" + paramForwardBody.colorRingId);
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramForwardBody = paramamsx.b(String.valueOf(l2));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "apollo push uin: " + l2 + ", avip flag: " + i2);
      }
      n = k;
      if (paramForwardBody.apolloVipFlag == i2) {
        break;
      }
      paramForwardBody.apolloVipFlag = i2;
      paramamsx.a(paramForwardBody);
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramForwardBody = paramamsx.b(String.valueOf(l2));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "apollo push uin: " + l2 + ", avip level: " + i2);
      }
      n = k;
      if (paramForwardBody.apolloVipLevel == i2) {
        break;
      }
      paramForwardBody.apolloVipLevel = i2;
      paramamsx.a(paramForwardBody);
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramForwardBody = paramamsx.b(String.valueOf(l2));
      if ((QLog.isColorLevel()) || (l2 == paramadan.a().getLongAccountUin())) {
        QLog.d("Q.msg.BaseMessageProcessor", 1, "apollo push uin: " + l2 + ", apollo status: " + n);
      }
      if (paramForwardBody.apolloStatus != n)
      {
        paramForwardBody.apolloStatus = n;
        paramamsx.a(paramForwardBody);
        if ((l2 == paramadan.a().getLongAccountUin()) && (paramForwardBody.isApolloStatusOpen()) && (paramForwardBody.apolloLocalTS != paramForwardBody.apolloServerTS))
        {
          paramForwardBody = (VasExtensionHandler)paramadan.a().a(71);
          if (paramForwardBody != null) {
            paramForwardBody.a("statusChange");
          }
        }
      }
      localObject1 = String.valueOf(l2);
      if (l2 == paramadan.a().getLongAccountUin())
      {
        paramForwardBody = new Pair(localObject1, Integer.valueOf(n));
        paramadan.a().a(71).notifyUI(3, true, paramForwardBody);
        n = paramInt;
        paramInt = m;
        m = n;
        break label737;
      }
      paramForwardBody = new ArrayList();
      paramForwardBody.add(localObject1);
      localObject1 = angi.a(paramadan.a());
      if (localObject1 != null) {
        ((angf)localObject1).a(n, paramForwardBody);
      }
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramForwardBody = String.valueOf(l2);
      if (TextUtils.isEmpty(paramForwardBody))
      {
        n = paramInt;
        paramInt = m;
        m = n;
        break label737;
      }
      localObject1 = paramamsx.b(paramForwardBody);
      if (paramForwardBody.equals(paramadan.a().c())) {
        ((VasExtensionHandler)paramadan.a().a(71)).a(new long[] { l2 });
      }
      QLog.d("Q.msg.BaseMessageProcessor", 1, new Object[] { "apollo push uin: " + new StringBuilder().append(l2).append("temp").toString().substring(0, 4) + ", timeStamp: " + n, ", local server:", Long.valueOf(((ApolloBaseInfo)localObject1).apolloServerTS) });
      if (((ApolloBaseInfo)localObject1).apolloServerTS != n)
      {
        ((ApolloBaseInfo)localObject1).apolloServerTS = n;
        paramamsx.a((ApolloBaseInfo)localObject1);
      }
      n = 0;
      localObject1 = paramadan.a().a();
      i2 = n;
      if (localObject1 != null)
      {
        i2 = n;
        if (((QQMessageFacade)localObject1).a())
        {
          i2 = n;
          if (!TextUtils.isEmpty(((QQMessageFacade)localObject1).a()))
          {
            i2 = n;
            if (((QQMessageFacade)localObject1).a() == 0)
            {
              i2 = n;
              if (((QQMessageFacade)localObject1).a().equals(paramForwardBody)) {
                i2 = 1;
              }
            }
          }
        }
      }
      if ((!paramForwardBody.equals(paramadan.a().c())) || (amsx.a(paramadan.a()) != 2))
      {
        n = k;
        if (i2 == 0) {
          break;
        }
      }
      paramForwardBody = (VasExtensionHandler)paramadan.a().a(71);
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(Long.valueOf(l2));
      paramForwardBody.a((ArrayList)localObject1, "online_push");
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
      n = k;
      if (l2 != paramadan.a().getLongAccountUin()) {
        break;
      }
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      if (n != amsx.a(paramadan.a()))
      {
        paramForwardBody = (amsx)paramadan.a().getManager(153);
        paramForwardBody.b(n);
        if (n == 1)
        {
          paramForwardBody = paramForwardBody.b(paramadan.a().c());
          if ((paramForwardBody.isApolloStatusOpen()) && (paramForwardBody.apolloLocalTS != paramForwardBody.apolloServerTS))
          {
            paramForwardBody = (VasExtensionHandler)paramadan.a().a(71);
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
      break label737;
      l1 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramForwardBody = paramamsx.b(String.valueOf(l2));
      long l3 = NetConnInfoCenter.getServerTime();
      if ((l1 > l3) && (paramForwardBody.apolloSignValidTS != l1))
      {
        paramForwardBody.apolloLocalSignTs = paramForwardBody.apolloSignValidTS;
        paramForwardBody.apolloSignValidTS = l1;
        paramForwardBody.apolloSignStr = "";
        paramamsx.a(paramForwardBody);
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo push sign uin: " + l2 + ", valid TS: " + l1 + ", currTS: " + l3);
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      if (paramamsx != null)
      {
        paramForwardBody = paramamsx.b(paramadan.a().c());
        if ((paramForwardBody != null) && (n != paramForwardBody.apolloAISwitch))
        {
          paramForwardBody.apolloAISwitch = n;
          if ((paramadan.a() != null) && (String.valueOf(l2).equals(paramadan.a().c()))) {
            paramamsx.a(n, 2);
          }
          paramamsx.a(paramForwardBody);
        }
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo aiSwitch  push: " + n);
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {}
      for (i2 = paramForwardBody[0];; i2 = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        localObject2 = String.valueOf(l2);
        paramForwardBody = paramamsx.b((String)localObject2);
        QLog.d("Q.msg.BaseMessageProcessor", 1, new Object[] { "cmshow_online_push,  uin: ", ApolloUtil.d((String)localObject2), ", cmshow3dFlag: ", Integer.valueOf(i2), ", local=", Integer.valueOf(paramForwardBody.cmshow3dFlag) });
        if (paramForwardBody.cmshow3dFlag != i2)
        {
          n = paramForwardBody.cmshow3dFlag;
          paramForwardBody.cmshow3dFlag = i2;
          paramamsx.a(paramForwardBody);
          if (paramadan.a().getCurrentAccountUin().equals(String.valueOf(l2))) {
            paramamsx.c(n, i2);
          }
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(localObject2);
          localObject2 = angi.a(paramadan.a());
          if (localObject2 != null) {
            ((angf)localObject2).a(3, (ArrayList)localObject1);
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
        paramamsx.a("" + l2, amsx.a);
        n = paramInt;
        paramInt = m;
        m = n;
        break label737;
      }
      l1 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramForwardBody = paramanyw.b(l2 + "");
      localObject1 = paramanyw.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        paramForwardBody.namePlateOfKingGameId = l1;
        paramanyw.a(paramForwardBody);
        paramadan.a().a(2).notifyUI(1, true, paramForwardBody);
      }
      if (localObject1 != null)
      {
        ((Friends)localObject1).namePlateOfKingGameId = l1;
        paramanyw.a((Friends)localObject1);
        paramadan.a().a(1).notifyUI(3, true, Long.toString(l2));
      }
      QLog.i("namePlateOfKing", 1, "handle push gameId = " + l1 + ", uin = " + l2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
      l1 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      paramForwardBody = paramanyw.b(l2 + "");
      localObject1 = paramanyw.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        paramForwardBody.namePlateOfKingLoginTime = l1;
        paramanyw.a(paramForwardBody);
        paramadan.a().a(2).notifyUI(1, true, paramForwardBody);
      }
      if (localObject1 != null)
      {
        ((Friends)localObject1).namePlateOfKingLoginTime = l1;
        paramanyw.a((Friends)localObject1);
        paramadan.a().a(1).notifyUI(3, true, Long.toString(l2));
      }
      QLog.i("namePlateOfKing", 1, "handle push gameLoginTime = " + l1 + ", uin = " + l2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramForwardBody = paramanyw.b(l2 + "");
      localObject1 = paramanyw.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        paramForwardBody.namePlateOfKingDan = n;
        paramanyw.a(paramForwardBody);
        paramadan.a().a(2).notifyUI(1, true, paramForwardBody);
      }
      if (localObject1 != null)
      {
        ((Friends)localObject1).namePlateOfKingDan = n;
        paramanyw.a((Friends)localObject1);
        paramadan.a().a(1).notifyUI(3, true, Long.toString(l2));
      }
      QLog.i("namePlateOfKing", 1, "handle push namePlateOfKingDan = " + n + ", uin = " + l2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      paramForwardBody = paramanyw.b(l2 + "");
      localObject1 = paramanyw.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        if (n == 1)
        {
          bool1 = true;
          label6887:
          paramForwardBody.namePlateOfKingDanDisplatSwitch = bool1;
          paramanyw.a(paramForwardBody);
          paramadan.a().a(2).notifyUI(1, true, paramForwardBody);
        }
      }
      else if (localObject1 != null) {
        if (n != 1) {
          break label7018;
        }
      }
      label7018:
      for (bool1 = true;; bool1 = false)
      {
        ((Friends)localObject1).namePlateOfKingDanDisplatSwitch = bool1;
        paramanyw.a((Friends)localObject1);
        paramadan.a().a(1).notifyUI(3, true, Long.toString(l2));
        QLog.i("namePlateOfKing", 1, "handle push namePlateOfKingDanDisplatSwitch = " + n + ", uin = " + l2);
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        bool1 = false;
        break label6887;
      }
      paramForwardBody = ((TicketManager)paramadan.a().getManager(2)).getSkey(l2 + "");
      ((aokv)paramadan.a().a(27)).a(paramForwardBody, l2 + "");
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
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
      paramForwardBody = paramanyw.b(l2 + "");
      localObject1 = paramanyw.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        paramForwardBody.nameplateVipType = n;
        paramanyw.a(paramForwardBody);
      }
      if (localObject1 != null)
      {
        ((Friends)localObject1).nameplateVipType = n;
        paramanyw.a((Friends)localObject1);
      }
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
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
      paramForwardBody = paramanyw.b(l2 + "");
      localObject1 = paramanyw.e(Long.toString(l2));
      if (paramForwardBody != null)
      {
        paramForwardBody.grayNameplateFlag = n;
        paramanyw.a(paramForwardBody);
      }
      if (localObject1 != null)
      {
        ((Friends)localObject1).grayNameplateFlag = n;
        paramanyw.a((Friends)localObject1);
      }
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {}
      for (n = paramForwardBody[0];; n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push the big club level change=" + n);
        }
        paramForwardBody = paramanyw.b(l2 + "");
        localObject1 = paramanyw.e(Long.toString(l2));
        if (paramForwardBody != null)
        {
          paramForwardBody.iBigClubVipLevel = n;
          paramanyw.a(paramForwardBody);
          paramadan.a().a(2).notifyUI(1, true, paramForwardBody);
        }
        if (localObject1 != null)
        {
          ((Friends)localObject1).bigClubInfo = (n & 0xFFFF | ((Friends)localObject1).bigClubInfo & 0xFFFF0000);
          paramanyw.a((Friends)localObject1);
          paramadan.a().a(1).notifyUI(3, true, Long.toString(l2));
        }
        paramForwardBody = ((TicketManager)paramadan.a().getManager(2)).getSkey(l2 + "");
        ((aokv)paramadan.a().a(27)).a(paramForwardBody, l2 + "");
        n = paramInt;
        paramInt = m;
        m = n;
        break;
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {}
      for (n = paramForwardBody[0];; n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        paramForwardBody = paramanyw.b(l2 + "");
        localObject1 = paramanyw.e(Long.toString(l2));
        if (paramForwardBody != null)
        {
          paramForwardBody.iBigClubVipType = n;
          paramanyw.a(paramForwardBody);
          paramadan.a().a(2).notifyUI(1, true, paramForwardBody);
        }
        if (localObject1 != null)
        {
          ((Friends)localObject1).bigClubInfo = (((Friends)localObject1).bigClubInfo & 0xFFFFFF | (n & 0xFF) << 24);
          paramanyw.a((Friends)localObject1);
          paramadan.a().a(1).notifyUI(3, true, Long.toString(l2));
        }
        if (QLog.isColorLevel()) {
          QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push the big club type change=" + n);
        }
        paramForwardBody = ((TicketManager)paramadan.a().getManager(2)).getSkey(l2 + "");
        ((aokv)paramadan.a().a(27)).a(paramForwardBody, l2 + "");
        n = paramInt;
        paramInt = m;
        m = n;
        break;
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {}
      for (n = paramForwardBody[0];; n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        paramForwardBody = paramanyw.b(l2 + "");
        localObject1 = paramanyw.e(Long.toString(l2));
        if (paramForwardBody != null)
        {
          paramForwardBody.lBigClubTemplateId = n;
          paramForwardBody.lSuperVipTemplateId = n;
          paramanyw.a(paramForwardBody);
          paramadan.a().a(2).notifyUI(1, true, paramForwardBody);
        }
        if (localObject1 != null)
        {
          ((Friends)localObject1).superVipTemplateId = n;
          ((Friends)localObject1).bigClubTemplateId = n;
          paramanyw.a((Friends)localObject1);
          paramadan.a().a(1).notifyUI(3, true, Long.toString(l2));
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
        paramForwardBody = paramanyw.e(Long.toString(l2));
        if (paramForwardBody != null)
        {
          paramForwardBody.bigClubInfo = ((n & 0xFF) << 16 | paramForwardBody.bigClubInfo & 0xFF00FFFF);
          paramanyw.a(paramForwardBody);
          paramadan.a().a(1).notifyUI(3, true, Long.toString(l2));
        }
        paramForwardBody = ((TicketManager)paramadan.a().getManager(2)).getSkey(l2 + "");
        ((aokv)paramadan.a().a(27)).a(paramForwardBody, l2 + "");
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
        paramForwardBody = paramanyw.b(l2 + "");
        if ((paramForwardBody != null) && (paramForwardBody.mQQLevelType != n))
        {
          paramForwardBody.mQQLevelType = n;
          paramanyw.a(paramForwardBody);
          paramadan.a().a(2).notifyUI(1, true, paramForwardBody);
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
        paramForwardBody = paramanyw.e(Long.toString(l2));
        if (paramForwardBody != null)
        {
          paramForwardBody.cNewLoverDiamondFlag = n;
          paramanyw.a(paramForwardBody);
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
      }
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      localObject1 = paramanyw.a(String.valueOf(l2));
      paramForwardBody = (SubMsgType0x27.ForwardBody)localObject1;
      if (localObject1 == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = String.valueOf(l2);
      }
      paramForwardBody.pendantDiyId = n;
      paramForwardBody.timestamp = System.currentTimeMillis();
      paramanyw.a(paramForwardBody);
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get PendantDiyId, uin=" + l2 + ", id=" + paramForwardBody.pendantDiyId);
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      ((bhzq)paramadan.a().getManager(235)).a.b(Long.toString(l2), n);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get faceId, uin=" + l2 + ", id=" + n);
      }
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      localObject1 = (BubbleManager)paramadan.a().getManager(44);
      label8923:
      short s;
      if (localObject1 != null)
      {
        if (n == 0)
        {
          bool1 = true;
          ((BubbleManager)localObject1).a(bool1);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, String.format("bubble unread feature push %s", new Object[] { "" + n }));
        }
        localObject1 = paramForwardBody.bytes_value.get().toByteArray();
        if (localObject1.length != 1) {
          break label9139;
        }
        if (localObject1[0] != 1) {
          break label9133;
        }
        bool1 = true;
        label9006:
        localObject1 = (axae)paramadan.a().getManager(303);
        s = (short)paramForwardBody.uint32_field.get();
        if (bool1) {
          break label9166;
        }
      }
      label9133:
      label9139:
      label9166:
      for (bool2 = true;; bool2 = false)
      {
        ((axae)localObject1).a(s, false, "", bool2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "push temp msg block,uin=" + l2 + ", id=" + bool1 + " field=" + paramForwardBody.uint32_field.get());
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        bool1 = false;
        break label8923;
        bool1 = false;
        break label9006;
        if (ByteBuffer.wrap((byte[])localObject1).asShortBuffer().get() == 1) {}
        for (bool1 = true;; bool1 = false) {
          break;
        }
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {}
      for (n = paramForwardBody[0];; n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        paramForwardBody = paramanyw.e(Long.toString(l2));
        if (paramForwardBody != null)
        {
          paramForwardBody.bigClubExtTemplateId = n;
          paramanyw.a(paramForwardBody);
          paramadan.a().a(1).notifyUI(3, true, Long.toString(l2));
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "vip_card_extension id by push=" + n);
        }
        n = paramInt;
        paramInt = m;
        m = n;
        break;
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      l1 = 0L;
      if (paramForwardBody.length == 4)
      {
        i2 = ByteBuffer.wrap(new byte[] { paramForwardBody[3] }).get();
        n = i2;
        if (i2 == 1) {
          l1 = ByteBuffer.wrap(new byte[] { paramForwardBody[2], paramForwardBody[1] }).asShortBuffer().get() & 0xFFFF;
        }
      }
      for (n = i2;; n = ByteBuffer.wrap(paramForwardBody).asShortBuffer().get())
      {
        paramForwardBody = azhv.a(n);
        localObject1 = paramadan.a().getOnlineStatus();
        l3 = azhq.a().a(paramadan.a());
        if ((paramForwardBody != localObject1) || (l3 != l1))
        {
          paramadan.a().setOnlineStatus(paramForwardBody);
          paramadan.a().setExtOnlineStatus(l1);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putSerializable("onlineStatus", paramForwardBody);
          ((Bundle)localObject2).putLong("extOnlineStatus", l1);
          paramadan.a().notifyObservers(AccountObserver.class, 2211, true, (Bundle)localObject2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, String.format("online new status push code: %s, newStatus: %s, curStatus: %s, ext:%s", new Object[] { Integer.valueOf(n), paramForwardBody, localObject1, Long.valueOf(l1) }));
        }
        if ((paramForwardBody == AppRuntime.Status.online) && (l1 == 1000L) && ((localObject1 != paramForwardBody) || (l1 != l3)))
        {
          paramadan.a().r();
          paramadan.a().a(paramForwardBody, l1);
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
      bool1 = ThemeUtil.isNowThemeIsSimple(paramadan.a(), false, null);
      if ((!bool1) && (behm.a(String.valueOf(i2)))) {
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
        break label737;
        beis.a(paramadan.a(), String.valueOf(i2), "20000000");
      }
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      localObject1 = (ChatBackgroundManager)paramadan.a().getManager(63);
      if (localObject1 != null) {
        ((ChatBackgroundManager)localObject1).a(i2, 0, null, "onlinePush", -1);
      }
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, " bg online push " + paramForwardBody.uint32_field.get() + " bgId:" + i2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      bibg.b(i2);
      n = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, " theme font online push " + paramForwardBody.uint32_field.get() + " id:" + i2);
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      if (paramForwardBody.length == 1) {
        if (paramForwardBody[0] == 0) {
          bool1 = true;
        }
      }
      for (;;)
      {
        aiti.a(paramadan.a()).a(bool1);
        paramadan.a().a(2).notifyUI(104, true, Boolean.valueOf(bool1));
        n = k;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.msg.BaseMessageProcessor", 2, "handleModProfileBranch emotionRec flag:" + bool1);
        n = paramInt;
        paramInt = m;
        m = n;
        break label737;
        bool1 = false;
        continue;
        if (ByteBuffer.wrap(paramForwardBody).asShortBuffer().get() == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
      }
      paramForwardBody = paramForwardBody.bytes_value.get().toByteArray();
      label10182:
      Object localObject3;
      if (paramForwardBody.length > 1) {
        if (paramForwardBody[1] == 1)
        {
          bool1 = true;
          QLog.e("vip_ptt.Q.msg.BaseMessageProcessor", 1, "it have receive push value:" + bool1);
          bool2 = bool1;
          if (bool1)
          {
            paramForwardBody = (args)aran.a().a(442);
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
          localObject3 = paramadan.a().getApp().getSharedPreferences("check_update_sp_key", 0);
          paramForwardBody = "businessinfo_ptt_auto_change_text_" + paramadan.a().getCurrentAccountUin();
          localObject1 = "businessinfo_ptt_auto_change_time_" + paramadan.a().getCurrentAccountUin();
          localObject2 = "businessinfo_ptt_auto_change_guide_has_show_" + paramadan.a().getCurrentAccountUin();
          localObject3 = ((SharedPreferences)localObject3).edit();
          ((SharedPreferences.Editor)localObject3).putBoolean(paramForwardBody, bool2);
          l1 = NetConnInfoCenter.getServerTime();
          if (!bool2) {
            break label10454;
          }
          ((SharedPreferences.Editor)localObject3).putLong((String)localObject1, l1);
          ((SharedPreferences.Editor)localObject3).putBoolean((String)localObject2, true);
          label10416:
          ((SharedPreferences.Editor)localObject3).apply();
          ahod.d = bool2;
          ahod.a = l1;
        }
      }
      for (;;)
      {
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        bool1 = false;
        break label10182;
        label10454:
        ((SharedPreferences.Editor)localObject3).putLong((String)localObject1, 9223372036854775807L);
        break label10416;
        QLog.e("vip_ptt.Q.msg.BaseMessageProcessor", 1, "it have receive push value is null");
        paramForwardBody = (anum)paramadan.a().a(2);
        localObject1 = new ArrayList();
        ((List)localObject1).add(Short.valueOf((short)-23249));
        paramForwardBody.a((List)localObject1, null);
      }
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "handleModProfileBranch: invoked. c2c online push, field id: 27370, changed global ring id", " ringId: ", Integer.valueOf(n) });
      }
      aqqr.a(paramadan.a()).b(n);
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
      i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "handleModProfileBranch: invoked. c2c online push, field id: 42360, changed troopHonorSwitch", " troopHonorSwitch: ", Integer.valueOf(i2) });
      }
      paramForwardBody = paramanyw.b(l2 + "");
      n = k;
      if (paramForwardBody == null) {
        break;
      }
      bool2 = paramForwardBody.troopHonorSwitch;
      if (i2 == 0)
      {
        bool1 = true;
        label10715:
        if (bool2 != bool1) {
          if (i2 != 0) {
            break label10803;
          }
        }
      }
      label10803:
      for (bool1 = true;; bool1 = false)
      {
        paramForwardBody.troopHonorSwitch = bool1;
        paramanyw.a(paramForwardBody);
        paramadan.a().a(2).notifyUI(113, true, Boolean.valueOf(paramForwardBody.troopHonorSwitch));
        ((aoip)paramadan.a().a(20)).notifyUI(80, true, null);
        n = paramInt;
        paramInt = m;
        m = n;
        break;
        bool1 = false;
        break label10715;
      }
      n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
      ((avot)paramadan.a().getManager(379)).a(n);
      n = paramInt;
      paramInt = m;
      m = n;
      break label737;
      n = i1;
      if (m != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "Onlinepush hasDiyFontTimestamp: uin = " + l2 + " fontid = " + paramInt + " timestamp = " + k);
        }
        paramanyw = paramanyw.a(String.valueOf(l2));
        paramForwardBody = paramanyw;
        if (paramanyw == null)
        {
          paramForwardBody = new ExtensionInfo();
          paramForwardBody.uin = String.valueOf(l2);
        }
        m = paramInt;
        if (paramInt == 0) {
          m = (int)paramForwardBody.uVipFont;
        }
        gc.a(paramadan.a(), String.valueOf(l2), paramForwardBody, m, k);
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
  
  public static void a(adan paramadan, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject1 = new SubMsgType0x27.MsgBody();
    anyw localanyw;
    TroopManager localTroopManager;
    aody localaody;
    amsx localamsx;
    int j;
    Friends[] arrayOfFriends;
    Object localObject2;
    int i;
    label1170:
    Object localObject4;
    for (;;)
    {
      try
      {
        paramArrayOfByte = (SubMsgType0x27.MsgBody)((SubMsgType0x27.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
        localanyw = (anyw)paramadan.a().getManager(51);
        localTroopManager = (TroopManager)paramadan.a().getManager(52);
        localaody = (aody)paramadan.a().getManager(56);
        localamsx = (amsx)paramadan.a().getManager(153);
        j = 0;
        paramArrayOfByte = paramArrayOfByte.rpt_msg_mod_infos.get();
        arrayOfFriends = new Friends[paramArrayOfByte.size()];
        Iterator localIterator = paramArrayOfByte.iterator();
        if (!localIterator.hasNext()) {
          break label7696;
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
      catch (Exception paramadan)
      {
        paramadan.printStackTrace();
        return;
      }
      switch (paramArrayOfByte.uint32_op_type.get())
      {
      case 60: 
      case 61: 
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
          localanyw.a(paramArrayOfByte);
          localObject1 = new AddGroupResp();
          ((AddGroupResp)localObject1).dwToUin = Long.valueOf(paramadan.a().getAccount()).longValue();
          ((AddGroupResp)localObject1).dwSequence = paramArrayOfByte.seqid;
          ((AddGroupResp)localObject1).cGroupId = ((byte)paramArrayOfByte.group_id);
          ((AddGroupResp)localObject1).cSortId = paramArrayOfByte.seqid;
          paramArrayOfByte = new GroupActionResp(0, "", (AddGroupResp)localObject1);
          paramadan.a().a(1).notifyUI(18, true, paramArrayOfByte);
        }
        break;
      case 1: 
        if (paramArrayOfByte.msg_del_group.has())
        {
          localObject1 = (SubMsgType0x27.DelGroup)paramArrayOfByte.msg_del_group.get();
          if (((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.has())
          {
            localObject2 = localanyw.a(((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get() + "");
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a DelGroup  = id:" + ((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get());
            }
            paramArrayOfByte = new DelGroupResp();
            paramArrayOfByte.dwToUin = Long.valueOf(paramadan.a().getAccount()).longValue();
            paramArrayOfByte.dwSequence = ((Groups)localObject2).seqid;
            paramArrayOfByte.cGroupid = ((byte)((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get());
            localObject1 = new GroupActionResp(0, "", paramArrayOfByte);
            ((FriendListHandler)paramadan.a().a(1)).a(paramArrayOfByte, true, (GroupActionResp)localObject1);
          }
        }
        break;
      case 2: 
        if (paramArrayOfByte.msg_mod_group_name.has())
        {
          localObject1 = (SubMsgType0x27.ModGroupName)paramArrayOfByte.msg_mod_group_name.get();
          if ((((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.has()) && (((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.has()))
          {
            i = ((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get();
            localObject2 = ((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8();
            paramArrayOfByte = localanyw.a(String.valueOf(i));
            if (paramArrayOfByte != null) {}
            for (paramArrayOfByte.group_name = ((String)localObject2);; paramArrayOfByte.group_name = ((String)localObject2))
            {
              localanyw.a(paramArrayOfByte);
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupName  = id:" + ((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get() + " name:" + ((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8());
              }
              paramArrayOfByte = new RenameGroupResp();
              paramArrayOfByte.dwToUin = ((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get();
              paramArrayOfByte.sGroupName = ((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8();
              paramArrayOfByte = new GroupActionResp(0, "", paramArrayOfByte);
              paramadan.a().a(1).notifyUI(19, true, paramArrayOfByte);
              break;
              paramArrayOfByte = new Groups();
              paramArrayOfByte.group_id = i;
            }
          }
        }
        break;
      case 3: 
        if (paramArrayOfByte.msg_mod_group_sort.has())
        {
          localObject2 = ((SubMsgType0x27.ModGroupSort)paramArrayOfByte.msg_mod_group_sort.get()).rpt_msg_groupsort.get();
          if (localObject2 != null)
          {
            paramArrayOfByte = new byte[((List)localObject2).size()];
            localObject1 = new byte[((List)localObject2).size()];
            localObject2 = ((List)localObject2).iterator();
            i = 0;
            if (((Iterator)localObject2).hasNext())
            {
              localObject4 = (SubMsgType0x27.GroupSort)((Iterator)localObject2).next();
              if ((!((SubMsgType0x27.GroupSort)localObject4).uint32_groupid.has()) || (!((SubMsgType0x27.GroupSort)localObject4).uint32_sortid.has())) {
                break label7724;
              }
              paramArrayOfByte[i] = ((byte)((SubMsgType0x27.GroupSort)localObject4).uint32_groupid.get());
              localObject1[i] = ((byte)((SubMsgType0x27.GroupSort)localObject4).uint32_sortid.get());
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupSort  = id:" + ((SubMsgType0x27.GroupSort)localObject4).uint32_groupid.get() + " sortid:" + ((SubMsgType0x27.GroupSort)localObject4).uint32_sortid.get());
              }
              i += 1;
            }
          }
        }
        break;
      }
    }
    label7696:
    label7724:
    for (;;)
    {
      break label1170;
      paramadan.a().a(1).notifyUI(22, true, null);
      localanyw.a(paramArrayOfByte, (byte[])localObject1);
      break;
      if (!paramArrayOfByte.msg_mod_friend_group.has()) {
        break;
      }
      paramArrayOfByte = ((SubMsgType0x27.ModFriendGroup)paramArrayOfByte.msg_mod_friend_group.get()).rpt_msg_frd_group.get();
      if (paramArrayOfByte == null) {
        break;
      }
      paramArrayOfByte = paramArrayOfByte.iterator();
      label1370:
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
        localanyw.a(l1 + "", k);
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModFriendGroup  = id:" + l1 + " newgroupid:" + k);
        }
        paramadan.a().a(1).notifyUI(9, true, new Object[] { l1 + "", Byte.valueOf((byte)k), Byte.valueOf((byte)i) });
        break label1370;
        if (!paramArrayOfByte.msg_del_friend.has()) {
          break;
        }
        localObject1 = ((SubMsgType0x27.DelFriend)paramArrayOfByte.msg_del_friend.get()).rpt_uint64_uins.get();
        paramArrayOfByte = (wiz)paramadan.a().getManager(253);
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label2040;
          }
          l1 = ((Long)((Iterator)localObject1).next()).longValue();
          localanyw.d(l1 + "");
          localaody.b(l1 + "");
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a DelFriend  = id:" + l1);
          }
          try
          {
            localObject2 = (bkgt)paramadan.a().getManager(165);
            if ((localObject2 != null) && (((bkgt)localObject2).a(l1 + "")))
            {
              paramadan.a().a().a().a(String.valueOf(l1), true);
              localObject2 = paramadan.a().getApplication().getBaseContext().getSharedPreferences(paramadan.a().getCurrentAccountUin() + "_customer_transfer_sharepreference", 0).edit();
              ((SharedPreferences.Editor)localObject2).putBoolean(paramadan.a().getCurrentAccountUin() + "_" + l1 + "", false);
              ((SharedPreferences.Editor)localObject2).apply();
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
          paramadan.a().a(1).notifyUI(15, true, Long.valueOf(l1));
          localObject2 = String.valueOf(l1);
          paramArrayOfByte.a((String)localObject2);
          bbcg.a(paramadan.a(), (String)localObject2);
          bejn.a(paramadan.a(), (String)localObject2);
        }
        label2040:
        paramArrayOfByte = (PhoneContactManagerImp)paramadan.a().getManager(11);
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
                localObject5 = localTroopManager.b(Long.toString(((SubMsgType0x27.SnsUpateBuffer)localObject3).uint64_uin.get()));
                i = ((SubMsgType0x27.SnsUpdateItem)localObject6).bytes_value.get().size();
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 4, "ONLine push commonTroop troopUin=" + (String)localObject5 + " status=" + i);
                }
                if (i == 0)
                {
                  if (localTroopManager.c((String)localObject5)) {
                    paramadan.a().a(22).notifyUI(18, true, new Object[] { localObject5, Integer.valueOf(1), Integer.valueOf(0), null });
                  }
                }
                else if (i >= 4)
                {
                  localObject6 = ((SubMsgType0x27.SnsUpdateItem)localObject6).bytes_value.get().toByteArray();
                  localObject7 = new byte[4];
                  System.arraycopy(localObject6, 0, localObject7, 0, 4);
                  if (localTroopManager.a((String)localObject5, aoci.a((byte[])localObject7))) {
                    paramadan.a().a(22).notifyUI(18, true, new Object[] { localObject5, Integer.valueOf(0), Integer.valueOf(0), null });
                  }
                }
              }
              else if (i == 13571)
              {
                localObject5 = String.valueOf(Long.valueOf(((SubMsgType0x27.SnsUpateBuffer)localObject3).uint64_code.get()));
                i = ((SubMsgType0x27.SnsUpdateItem)localObject6).bytes_value.get().size();
                localObject6 = ((SubMsgType0x27.SnsUpdateItem)localObject6).bytes_value.get().toByteArray();
                if (i >= 6)
                {
                  i = localObject6[1];
                  if (i == 1)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.BaseMessageProcessor", 2, "onlinePush, oprerate external show troop...");
                    }
                    localObject7 = new byte[4];
                    System.arraycopy(localObject6, 2, localObject7, 0, 4);
                    if (localTroopManager.b((String)localObject5, aoci.a((byte[])localObject7))) {
                      paramadan.a().a(20).notifyUI(54, true, new Object[] { localObject5, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i) });
                    }
                  }
                  if ((i == 0) && (localTroopManager.e((String)localObject5))) {
                    paramadan.a().a(20).notifyUI(54, true, new Object[] { localObject5, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i) });
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
              if ((localObject7 != null) && (((SubMsgType0x27.SnsUpdateItem)localObject7).uint32_update_sns_type.has()) && (((SubMsgType0x27.SnsUpdateItem)localObject7).bytes_value.has()) && (!FriendsStatusUtil.a((SubMsgType0x27.SnsUpdateItem)localObject7, paramadan.a(), (String)localObject5)))
              {
                if (((SubMsgType0x27.SnsUpdateItem)localObject7).uint32_update_sns_type.get() == 13568) {
                  amjp.a((String)localObject5, ((SubMsgType0x27.SnsUpdateItem)localObject7).bytes_value.get().toStringUtf8(), paramadan.a());
                }
                localObject1 = (SpecialCareInfo)((HashMap)localObject3).get(localObject5);
                paramArrayOfByte = (byte[])localObject1;
                if (localObject1 == null)
                {
                  localObject1 = localanyw.a(String.valueOf(l1));
                  paramArrayOfByte = (byte[])localObject1;
                  if (localObject1 == null)
                  {
                    paramArrayOfByte = new SpecialCareInfo();
                    paramArrayOfByte.uin = String.valueOf(l1);
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
        localanyw.c((List)localObject1);
        if (((List)localObject1).size() <= 0) {
          break;
        }
        paramadan.a().a(1).notifyUI(99, true, new Object[] { Boolean.valueOf(true), localObject1 });
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
          localObject1 = localanyw.e(String.valueOf(l1));
        } while (localObject1 == null);
        if (i == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ((Friends)localObject1).setShieldFlag(bool);
          localanyw.a((Friends)localObject1);
          paramadan.a().a(1).notifyUI(56, true, new Object[] { Long.valueOf(l1), Boolean.valueOf(bool), Boolean.valueOf(true), Boolean.valueOf(true), "" });
          break;
        }
        if (!paramArrayOfByte.msg_mod_profile.has()) {
          break;
        }
        j = a(paramadan, paramArrayOfByte, localanyw, localamsx, arrayOfFriends, j);
        break;
        if (!paramArrayOfByte.msg_mod_custom_face.has()) {
          break;
        }
        localObject1 = (SubMsgType0x27.ModCustomFace)paramArrayOfByte.msg_mod_custom_face.get();
        if ((!((SubMsgType0x27.ModCustomFace)localObject1).uint32_type.has()) || (!((SubMsgType0x27.ModCustomFace)localObject1).uint64_uin.has())) {
          break;
        }
        paramArrayOfByte = (FriendListHandler)paramadan.a().a(1);
        if (((SubMsgType0x27.ModCustomFace)localObject1).uint32_type.get() == 0)
        {
          l1 = ((SubMsgType0x27.ModCustomFace)localObject1).uint64_uin.get();
          localObject1 = Long.toString(l1);
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModCustomFace  :0  Normal user uin = " + l1);
          }
          paramArrayOfByte.c((String)localObject1);
          paramadan.a().a(1).notifyUI(3, true, localObject1);
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
        if (paramadan.a().getCurrentAccountUin().equals(String.valueOf(l1)))
        {
          paramArrayOfByte = localanyw.c(paramadan.a().getCurrentAccountUin());
          if ((i != paramArrayOfByte.lLoginDays) || (k != paramArrayOfByte.lQQMasterLogindays))
          {
            paramArrayOfByte.lLoginDays = i;
            paramArrayOfByte.lQQMasterLogindays = k;
            localanyw.a(paramArrayOfByte);
            paramadan.a().a(2).notifyUI(1, true, paramArrayOfByte);
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
              localObject4 = localanyw.e(Long.toString(l1));
              paramArrayOfByte = null;
              if (localObject4 != null) {
                paramArrayOfByte = ((Friends)localObject4).remark;
              }
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModFriendRemark  : 0 Friend uin = " + ((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + "备注 = " + ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8() + ",oldRemark = " + paramArrayOfByte);
              }
              localanyw.b(((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + "", ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8());
              localObject5 = localanyw.b(((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + "");
              localObject6 = ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8();
              if ((localObject5 != null) && (!((String)localObject6).equals(((Card)localObject5).strReMark)))
              {
                ((Card)localObject5).strReMark = ((String)localObject6);
                localanyw.a((Card)localObject5);
              }
              if ((localObject4 != null) && (((Friends)localObject4).isFriend()) && (aofp.b((String)localObject6, paramArrayOfByte))) {
                aofp.b(l1, (String)localObject6, (anws)paramadan.a().getManager(53));
              }
              paramadan.a().a(1).notifyUI(3, true, Long.toString(((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get()));
              paramadan.a().a(1).notifyUI(27, true, new Object[] { ((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + "", ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8(), Byte.valueOf(1) });
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
        localObject1 = localanyw.a((String)localObject3);
        paramArrayOfByte = (byte[])localObject1;
        if (localObject1 == null)
        {
          paramArrayOfByte = new ExtensionInfo();
          paramArrayOfByte.uin = ((String)localObject3);
        }
        paramArrayOfByte.setRichBuffer((byte[])localObject4, l1);
        paramArrayOfByte.isAdded2C2C = SignatureManager.a(paramadan.a(), (String)localObject3, paramArrayOfByte.getRichStatus());
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "insertSignMsgIfNeeded from OnLinePush uin = " + (String)localObject3 + " result =  " + paramArrayOfByte.isAdded2C2C);
        }
        localanyw.a(paramArrayOfByte);
        paramArrayOfByte = localanyw.b(((SubMsgType0x27.ModLongNick)localObject5).uint64_uin.get() + "");
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.vRichSign = ((byte[])localObject4);
          paramArrayOfByte.lSignModifyTime = l1;
          localanyw.a(paramArrayOfByte);
        }
        paramadan.a().a(1).notifyUI(3, true, localObject3);
        paramadan.a().a(1).notifyUI(2, true, new String[] { localObject3 });
        break;
        if (!paramArrayOfByte.msg_mod_group_profile.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.ModGroupProfile)paramArrayOfByte.msg_mod_group_profile.get();
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
              ((FriendListHandler)paramadan.a().a(1)).d(l1 + "");
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
        paramArrayOfByte = bhlk.a().a(paramadan.a(), l2 + "", l3 + "");
        localObject1 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).rpt_msg_group_member_profile_infos.get().iterator();
        label5828:
        label6377:
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (SubMsgType0x27.GroupMemberProfileInfo)((Iterator)localObject1).next();
          if ((((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.has()) && (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.has()))
          {
            if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.get() != 1) {
              break label5828;
            }
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModGroupMemberProfile 1--Nick = " + ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toStringUtf8() + " info.bytes_value.get().size() = " + ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().size());
            }
            aofp.a("cardpush", ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toByteArray(), ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().size());
            if (paramArrayOfByte != null)
            {
              paramArrayOfByte.colorNick = bhwz.a(((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get());
              paramArrayOfByte.name = bhwz.b(paramArrayOfByte.colorNick);
              localTroopManager.a(l1 + "", l3 + "", paramArrayOfByte.colorNick, -100, null, null, -100, -100, -100, -100L, -100L);
            }
          }
          for (;;)
          {
            if (paramArrayOfByte == null) {
              break label6377;
            }
            bhlk.a().a(paramadan.a(), paramArrayOfByte);
            localObject3 = new ArrayList();
            ((ArrayList)localObject3).add(paramArrayOfByte);
            paramadan.a().a(20).notifyUI(16, true, localObject3);
            paramadan.a().a(20).notifyUI(11, true, new Object[] { localObject3, Boolean.valueOf(true) });
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
              ((TroopManager)paramadan.a().getManager(52)).a(l1 + "", l3 + "", null, -100, null, (String)localObject3, -100, -100, -100, -100L, -100L);
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
              paramArrayOfByte.colorNick = bhwz.a(((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get());
              paramArrayOfByte.name = bhwz.b(paramArrayOfByte.colorNick);
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
          paramadan.a().a().a((SubMsgType0x27.AppointmentNotify)localObject5);
          break;
        }
        if (((l1 != 0L) && (l1 != 1L) && (l1 != 3L)) || (!((SubMsgType0x27.AppointmentNotify)localObject5).uint64_from_uin.has())) {
          break;
        }
        l2 = ((SubMsgType0x27.AppointmentNotify)localObject5).uint64_from_uin.get();
        localObject1 = null;
        localObject3 = paramadan.a().getCurrentAccountUin();
        localObject4 = Long.toString(l2);
        if (l1 == 0L) {}
        for (paramArrayOfByte = (byte[])localObject3;; paramArrayOfByte = (byte[])localObject4)
        {
          if (((SubMsgType0x27.AppointmentNotify)localObject5).str_tips_content.has()) {
            localObject1 = ((SubMsgType0x27.AppointmentNotify)localObject5).str_tips_content.get();
          }
          localObject5 = new ArrayList();
          localObject6 = bcry.a(-1024);
          l2 = bcrg.a();
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
          paramadan.a().a().a((MessageRecord)localObject6, ((MessageRecord)localObject6).selfuin);
          paramadan.a("handleMsgType0x210SubMsgType0x27", true, (List)localObject5, false, false);
          break;
          if ((l1 == 1L) && (((SubMsgType0x27.AppointmentNotify)localObject5).bytes_sig.has()))
          {
            paramArrayOfByte = ((SubMsgType0x27.AppointmentNotify)localObject5).bytes_sig.get().toByteArray();
            paramadan.a().a().l((String)localObject4, paramArrayOfByte);
          }
        }
        if (!paramArrayOfByte.bytes_redpoint_info.has()) {
          break;
        }
        ((aysq)paramadan.a().getManager(160)).a(paramArrayOfByte.bytes_redpoint_info.get().toByteArray());
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
        ((abur)paramadan.a().a(51)).a(39, (Bundle)localObject1);
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
        ((abur)paramadan.a().a(51)).a(39, (Bundle)localObject1);
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
            localObject1 = (aoat)paramadan.a().a(3);
            if (localObject1 == null) {
              break;
            }
            ((aoat)localObject1).a(paramArrayOfByte);
            break;
          }
          if ((i != 2) && (i != 3)) {
            break;
          }
          localObject1 = (aocv)paramadan.a().a(57);
          if (localObject1 == null) {
            break;
          }
          ((aocv)localObject1).a(i, paramArrayOfByte);
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
                localObject1 = bhgm.a(paramadan.a().getApp().getResources(), 2130840347);
                localObject3 = new ToServiceMsg("mobileqq.service", paramadan.a().getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
                localObject4 = new Intent(paramadan.a().getApp(), LikeRankingListActivity.class);
                ((Intent)localObject4).putExtra("param_from", 1);
                ((Intent)localObject4).addFlags(67108864);
                ((ToServiceMsg)localObject3).extraData.putStringArray("cmds", new String[] { "QQ", "QQ", paramArrayOfByte });
                ((ToServiceMsg)localObject3).extraData.putParcelable("intent", (Parcelable)localObject4);
                ((ToServiceMsg)localObject3).extraData.putParcelable("bitmap", (Parcelable)localObject1);
                paramadan.a().sendToService((ToServiceMsg)localObject3);
                paramadan.a().reportClickEvent("dc00898", "0X8007618");
                break;
                try
                {
                  paramArrayOfByte = (SubMsgType0x27.MQQCampusNotify)paramArrayOfByte.msg_campus_notify.get();
                  if (paramArrayOfByte == null) {
                    break;
                  }
                  ((aqqq)paramadan.a().getManager(240)).a(paramArrayOfByte);
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
                    bhxv.a(paramArrayOfByte);
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
            localanyw.a(arrayOfFriends, j);
            return;
          }
        }
      }
    }
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan, paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     addn
 * JD-Core Version:    0.7.0.1
 */