import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import QQService.EVIPSPEC;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BusinessHandler;
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
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
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

public class acah
  implements abzb
{
  private int a(abxc paramabxc, amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    ExtensionInfo localExtensionInfo = paramamsw.a(String.valueOf(paramLong));
    paramProfileInfo = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramProfileInfo = new ExtensionInfo();
      paramProfileInfo.uin = String.valueOf(paramLong);
    }
    if ((paramProfileInfo.uVipFont != gb.a(i)) || (paramProfileInfo.vipFontType != gb.b(i)))
    {
      paramProfileInfo.uVipFont = gb.a(i);
      paramProfileInfo.vipFontType = gb.b(i);
      paramProfileInfo.timestamp = System.currentTimeMillis();
      paramamsw.a(paramProfileInfo);
      bgae.a(paramabxc.a());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Font, uin=" + paramLong + ", id=" + paramProfileInfo.uVipFont + ", type = " + paramProfileInfo.vipFontType);
    }
    return (int)gb.a(i);
  }
  
  private int a(abxc paramabxc, amsw paramamsw, Friends[] paramArrayOfFriends, int paramInt, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    String str = paramProfileInfo.bytes_value.get().toStringUtf8();
    if (QLog.isColorLevel()) {
      QLog.d("cardpush", 2, "push a ModProfile Nick = " + str);
    }
    Friends localFriends = paramamsw.e(Long.toString(paramLong));
    paramProfileInfo = null;
    if (localFriends != null) {
      paramProfileInfo = localFriends.name;
    }
    paramArrayOfFriends[paramInt] = paramamsw.a(paramLong + "", str);
    if ((localFriends != null) && (localFriends.isFriend()) && (amzf.a(str, paramProfileInfo))) {
      amzf.a(paramLong, str, (amrb)paramabxc.a().getManager(53));
    }
    paramArrayOfFriends = paramamsw.b(paramLong + "");
    if (paramArrayOfFriends != null)
    {
      paramArrayOfFriends.strNick = str;
      paramamsw.a(paramArrayOfFriends);
      paramabxc.a().getBusinessHandler(2).notifyUI(1, true, paramArrayOfFriends);
    }
    paramabxc.a().getBusinessHandler(1).notifyUI(3, true, Long.toString(paramLong));
    TroopNameHelper.b(Long.toString(paramLong));
    return paramInt + 1;
  }
  
  private int a(abxc paramabxc, SubMsgType0x27.ForwardBody paramForwardBody, amsw paramamsw, alnr paramalnr, Friends[] paramArrayOfFriends, int paramInt)
  {
    Object localObject1 = (SubMsgType0x27.ModProfile)paramForwardBody.msg_mod_profile.get();
    if (((SubMsgType0x27.ModProfile)localObject1).uint64_uin.has())
    {
      long l = ((SubMsgType0x27.ModProfile)localObject1).uint64_uin.get();
      paramForwardBody = new ayzo(paramabxc.a());
      paramForwardBody.a(l);
      localObject1 = ((SubMsgType0x27.ModProfile)localObject1).rpt_msg_profile_infos.get().iterator();
      int j = 0;
      int i = 0;
      int k = 0;
      int m = paramInt;
      paramInt = k;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (SubMsgType0x27.ProfileInfo)((Iterator)localObject1).next();
        k = i;
        ByteStringMicro localByteStringMicro;
        if (((SubMsgType0x27.ProfileInfo)localObject2).uint32_field.has())
        {
          k = i;
          if (((SubMsgType0x27.ProfileInfo)localObject2).bytes_value.has())
          {
            k = ((SubMsgType0x27.ProfileInfo)localObject2).uint32_field.get();
            localByteStringMicro = ((SubMsgType0x27.ProfileInfo)localObject2).bytes_value.get();
          }
        }
        switch (k)
        {
        default: 
          paramForwardBody.a(k, localByteStringMicro);
          k = i;
          label724:
          int n = j;
          i = k;
          j = paramInt;
          paramInt = n;
        }
        for (;;)
        {
          k = j;
          j = paramInt;
          paramInt = k;
          break;
          m = a(paramabxc, paramamsw, paramArrayOfFriends, m, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          k(paramabxc, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          t(paramabxc, paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          s(paramabxc, paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          j(paramabxc, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          r(paramabxc, paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          q(paramabxc, paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          p(paramabxc, paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          i(paramabxc, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          d(paramabxc, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          o(paramabxc, paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          k = a(paramabxc, paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          paramInt = j;
          j = k;
          continue;
          n(paramabxc, paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          m(paramabxc, paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          i = ByteBuffer.wrap(((SubMsgType0x27.ProfileInfo)localObject2).bytes_value.get().toByteArray()).asIntBuffer().get();
          k = i;
          if (i == 0) {
            break label724;
          }
          k = 1;
          j = paramInt;
          paramInt = k;
          continue;
          l(paramabxc, paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          c(paramalnr, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          b(paramalnr, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          d(paramabxc, paramalnr, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          c(paramabxc, paramalnr, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          c(paramabxc, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          a(paramalnr, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          b(paramabxc, paramalnr, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          a(paramabxc, paramalnr, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          k(paramabxc, paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          j(paramabxc, paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          i(paramabxc, paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          h(paramabxc, paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          localObject2 = ((TicketManager)paramabxc.a().getManager(2)).getSkey(l + "");
          ((aneg)paramabxc.a().getBusinessHandler(27)).a((String)localObject2, l + "");
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          d(paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          c(paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          g(paramabxc, paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          f(paramabxc, paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          e(paramabxc, paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          d(paramabxc, paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          c(paramabxc, paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          b(paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          a(paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          b(paramabxc, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          h(paramabxc, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          a(paramabxc, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          b(paramabxc, paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          g(paramabxc, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          f(paramabxc, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          e(paramabxc, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          a((SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          d(paramabxc, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          c(paramabxc, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          b(paramabxc, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          a(paramabxc, paramamsw, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          a(paramabxc, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
        }
      }
      paramForwardBody.b();
      if (j != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "Onlinepush hasDiyFontTimestamp: uin = " + l + " fontid = " + paramInt + " timestamp = " + i);
        }
        paramamsw = paramamsw.a(String.valueOf(l));
        paramForwardBody = paramamsw;
        if (paramamsw == null)
        {
          paramForwardBody = new ExtensionInfo();
          paramForwardBody.uin = String.valueOf(l);
        }
        j = paramInt;
        if (paramInt == 0) {
          j = (int)paramForwardBody.uVipFont;
        }
        gb.a(paramabxc.a(), String.valueOf(l), paramForwardBody, j, i);
      }
      return m;
    }
    return paramInt;
  }
  
  private void a(abxc paramabxc, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    boolean bool2 = true;
    byte[] arrayOfByte = paramProfileInfo.bytes_value.get().toByteArray();
    boolean bool1;
    short s;
    if (arrayOfByte.length == 1) {
      if (arrayOfByte[0] == 1)
      {
        bool1 = true;
        paramabxc = (avnl)paramabxc.a().getManager(303);
        s = (short)paramProfileInfo.uint32_field.get();
        if (bool1) {
          break label168;
        }
      }
    }
    for (;;)
    {
      paramabxc.a(s, false, "", bool2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "push temp msg block,uin=" + paramLong + ", id=" + bool1 + " field=" + paramProfileInfo.uint32_field.get());
      }
      return;
      bool1 = false;
      break;
      if (ByteBuffer.wrap(arrayOfByte).asShortBuffer().get() == 1) {}
      for (bool1 = true;; bool1 = false) {
        break;
      }
      label168:
      bool2 = false;
    }
  }
  
  private void a(abxc paramabxc, alnr paramalnr, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {}
    for (int i = paramProfileInfo[0];; i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get())
    {
      String str = String.valueOf(paramLong);
      paramProfileInfo = paramalnr.b(str);
      QLog.d("Q.msg.BaseMessageProcessor", 1, new Object[] { "cmshow_online_push,  uin: ", ApolloUtil.d(str), ", cmshow3dFlag: ", Integer.valueOf(i), ", local=", Integer.valueOf(paramProfileInfo.cmshow3dFlag) });
      if (paramProfileInfo.cmshow3dFlag != i)
      {
        int j = paramProfileInfo.cmshow3dFlag;
        paramProfileInfo.cmshow3dFlag = i;
        paramalnr.a(paramProfileInfo);
        if (paramabxc.a().getCurrentAccountUin().equals(String.valueOf(paramLong))) {
          paramalnr.c(j, i);
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(str);
        paramabxc = ambc.a(paramabxc.a());
        if (paramabxc != null) {
          paramabxc.a(3, localArrayList);
        }
      }
      if (((i & 0x1) == 1) && (paramProfileInfo.getApolloDress3D() == null)) {
        paramalnr.a("" + paramLong, alnr.a);
      }
      return;
    }
  }
  
  private void a(abxc paramabxc, amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    boolean bool2 = false;
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "handleModProfileBranch: invoked. c2c online push, field id: 42360, changed troopHonorSwitch", " troopHonorSwitch: ", Integer.valueOf(i) });
    }
    paramProfileInfo = paramamsw.b(paramLong + "");
    boolean bool3;
    if (paramProfileInfo != null)
    {
      bool3 = paramProfileInfo.troopHonorSwitch;
      if (i != 0) {
        break label181;
      }
    }
    label181:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (bool3 != bool1)
      {
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
        paramProfileInfo.troopHonorSwitch = bool1;
      }
      paramamsw.a(paramProfileInfo);
      paramabxc.a().getBusinessHandler(2).notifyUI(113, true, Boolean.valueOf(paramProfileInfo.troopHonorSwitch));
      ((anca)paramabxc.a().getBusinessHandler(20)).notifyUI(80, true, null);
      return;
    }
  }
  
  private void a(abxc paramabxc, amsw paramamsw, amxz paramamxz, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_del_friend.has())
    {
      Object localObject1 = ((SubMsgType0x27.DelFriend)paramForwardBody.msg_del_friend.get()).rpt_uint64_uins.get();
      paramForwardBody = (vky)paramabxc.a().getManager(253);
      localObject1 = ((List)localObject1).iterator();
      long l;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label432;
        }
        l = ((Long)((Iterator)localObject1).next()).longValue();
        paramamsw.d(l + "");
        paramamxz.b(l + "");
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a DelFriend  = id:" + l);
        }
        try
        {
          localObject2 = (bily)paramabxc.a().getManager(165);
          if ((localObject2 != null) && (((bily)localObject2).a(l + "")))
          {
            paramabxc.a().getProxyManager().a().a(String.valueOf(l), true);
            localObject2 = paramabxc.a().getApplication().getBaseContext().getSharedPreferences(paramabxc.a().getCurrentAccountUin() + "_customer_transfer_sharepreference", 0).edit();
            ((SharedPreferences.Editor)localObject2).putBoolean(paramabxc.a().getCurrentAccountUin() + "_" + l + "", false);
            ((SharedPreferences.Editor)localObject2).apply();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject2;
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a DelFriend  = id:" + l + " error :" + localException.toString());
            }
          }
        }
        paramabxc.a().getBusinessHandler(1).notifyUI(15, true, Long.valueOf(l));
        localObject2 = String.valueOf(l);
        paramForwardBody.a((String)localObject2);
        azxb.a(paramabxc.a(), (String)localObject2);
        bdcj.a(paramabxc.a(), (String)localObject2);
      }
      label432:
      paramabxc = (PhoneContactManagerImp)paramabxc.a().getManager(11);
      if (paramabxc != null) {
        paramabxc.b();
      }
    }
  }
  
  private void a(abxc paramabxc, amsw paramamsw, TroopManager paramTroopManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject5;
    int i;
    Object localObject4;
    if (paramForwardBody.msg_mod_friend_rings.has())
    {
      localObject1 = ((SubMsgType0x27.ModSnsGeneralInfo)paramForwardBody.msg_mod_friend_rings.get()).rpt_msg_sns_general_infos.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SubMsgType0x27.SnsUpateBuffer)((Iterator)localObject1).next();
        localObject3 = ((SubMsgType0x27.SnsUpateBuffer)localObject2).rpt_msg_sns_update_item.get().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject5 = (SubMsgType0x27.SnsUpdateItem)((Iterator)localObject3).next();
          i = ((SubMsgType0x27.SnsUpdateItem)localObject5).uint32_update_sns_type.get();
          byte[] arrayOfByte;
          if ((i == 13569) && (((SubMsgType0x27.SnsUpateBuffer)localObject2).uint32_result.get() == 0))
          {
            localObject4 = paramTroopManager.b(Long.toString(((SubMsgType0x27.SnsUpateBuffer)localObject2).uint64_uin.get()));
            i = ((SubMsgType0x27.SnsUpdateItem)localObject5).bytes_value.get().size();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 4, "ONLine push commonTroop troopUin=" + (String)localObject4 + " status=" + i);
            }
            if (i == 0)
            {
              if (paramTroopManager.c((String)localObject4)) {
                paramabxc.a().getBusinessHandler(22).notifyUI(18, true, new Object[] { localObject4, Integer.valueOf(1), Integer.valueOf(0), null });
              }
            }
            else if (i >= 4)
            {
              localObject5 = ((SubMsgType0x27.SnsUpdateItem)localObject5).bytes_value.get().toByteArray();
              arrayOfByte = new byte[4];
              System.arraycopy(localObject5, 0, arrayOfByte, 0, 4);
              if (paramTroopManager.a((String)localObject4, amwh.a(arrayOfByte))) {
                paramabxc.a().getBusinessHandler(22).notifyUI(18, true, new Object[] { localObject4, Integer.valueOf(0), Integer.valueOf(0), null });
              }
            }
          }
          else if (i == 13571)
          {
            localObject4 = String.valueOf(Long.valueOf(((SubMsgType0x27.SnsUpateBuffer)localObject2).uint64_code.get()));
            i = ((SubMsgType0x27.SnsUpdateItem)localObject5).bytes_value.get().size();
            localObject5 = ((SubMsgType0x27.SnsUpdateItem)localObject5).bytes_value.get().toByteArray();
            if (i >= 6)
            {
              i = localObject5[1];
              if (i == 1)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "onlinePush, oprerate external show troop...");
                }
                arrayOfByte = new byte[4];
                System.arraycopy(localObject5, 2, arrayOfByte, 0, 4);
                if (paramTroopManager.b((String)localObject4, amwh.a(arrayOfByte))) {
                  paramabxc.a().getBusinessHandler(20).notifyUI(54, true, new Object[] { localObject4, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i) });
                }
              }
              if ((i == 0) && (paramTroopManager.e((String)localObject4))) {
                paramabxc.a().getBusinessHandler(20).notifyUI(54, true, new Object[] { localObject4, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i) });
              }
            }
          }
        }
      }
    }
    if (paramForwardBody.msg_mod_friend_rings.has())
    {
      paramTroopManager = (SubMsgType0x27.ModSnsGeneralInfo)paramForwardBody.msg_mod_friend_rings.get();
      if ((paramTroopManager != null) && (paramTroopManager.rpt_msg_sns_general_infos.has()))
      {
        paramTroopManager = paramTroopManager.rpt_msg_sns_general_infos.get();
        localObject1 = new HashMap();
        localObject2 = paramTroopManager.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          paramTroopManager = (SubMsgType0x27.SnsUpateBuffer)((Iterator)localObject2).next();
          if ((paramTroopManager != null) && (paramTroopManager.uint64_uin.has()) && (paramTroopManager.rpt_msg_sns_update_item.has()))
          {
            long l = paramTroopManager.uint64_uin.get();
            localObject3 = String.valueOf(l);
            localObject4 = paramTroopManager.rpt_msg_sns_update_item.get().iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (SubMsgType0x27.SnsUpdateItem)((Iterator)localObject4).next();
              if ((localObject5 != null) && (((SubMsgType0x27.SnsUpdateItem)localObject5).uint32_update_sns_type.has()) && (((SubMsgType0x27.SnsUpdateItem)localObject5).bytes_value.has()) && (!FriendsStatusUtil.a((SubMsgType0x27.SnsUpdateItem)localObject5, paramabxc.a(), (String)localObject3)))
              {
                if (((SubMsgType0x27.SnsUpdateItem)localObject5).uint32_update_sns_type.get() == 13568) {
                  alem.a((String)localObject3, ((SubMsgType0x27.SnsUpdateItem)localObject5).bytes_value.get().toStringUtf8(), paramabxc.a());
                }
                paramForwardBody = (SpecialCareInfo)((HashMap)localObject1).get(localObject3);
                paramTroopManager = paramForwardBody;
                if (paramForwardBody == null)
                {
                  paramForwardBody = paramamsw.a(String.valueOf(l));
                  paramTroopManager = paramForwardBody;
                  if (paramForwardBody == null)
                  {
                    paramTroopManager = new SpecialCareInfo();
                    paramTroopManager.uin = String.valueOf(l);
                  }
                  ((HashMap)localObject1).put(paramTroopManager.uin, paramTroopManager);
                }
                i = ((SubMsgType0x27.SnsUpdateItem)localObject5).uint32_update_sns_type.get();
                paramForwardBody = ((SubMsgType0x27.SnsUpdateItem)localObject5).bytes_value.get().toStringUtf8();
                FriendListHandler.initSpecialCareInfo(paramTroopManager, i, paramForwardBody);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x27 uin=" + paramTroopManager.uin + ", itemtype=" + i + ",itemVal=" + paramForwardBody);
                }
              }
            }
          }
        }
        paramTroopManager = ((HashMap)localObject1).entrySet().iterator();
        paramForwardBody = new ArrayList();
        while (paramTroopManager.hasNext())
        {
          localObject1 = (SpecialCareInfo)((Map.Entry)paramTroopManager.next()).getValue();
          if ((localObject1 != null) && ((((SpecialCareInfo)localObject1).getStatus() != 1000) || (((SpecialCareInfo)localObject1).globalSwitch != 0))) {
            paramForwardBody.add(localObject1);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x27 bulkSaveOrUpdateSpecialCareInfos=" + paramForwardBody.size());
        }
        paramamsw.c(paramForwardBody);
        if (paramForwardBody.size() > 0) {
          paramabxc.a().getBusinessHandler(1).notifyUI(99, true, new Object[] { Boolean.valueOf(true), paramForwardBody });
        }
      }
    }
  }
  
  private void a(abxc paramabxc, amsw paramamsw, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_mod_rich_long_nick_ex.has())
    {
      SubMsgType0x27.ModLongNick localModLongNick = (SubMsgType0x27.ModLongNick)paramForwardBody.msg_mod_rich_long_nick_ex.get();
      String str = Long.toString(localModLongNick.uint64_uin.get());
      paramForwardBody = ByteBuffer.wrap(localModLongNick.bytes_value.get().toByteArray());
      long l = paramForwardBody.getLong();
      byte[] arrayOfByte = new byte[paramForwardBody.remaining()];
      paramForwardBody.get(arrayOfByte);
      ExtensionInfo localExtensionInfo = paramamsw.a(str);
      paramForwardBody = localExtensionInfo;
      if (localExtensionInfo == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = str;
      }
      paramForwardBody.setRichBuffer(arrayOfByte, l);
      paramForwardBody.isAdded2C2C = SignatureManager.a(paramabxc.a(), str, paramForwardBody.getRichStatus());
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "insertSignMsgIfNeeded from OnLinePush uin = " + str + " result =  " + paramForwardBody.isAdded2C2C);
      }
      paramamsw.a(paramForwardBody);
      paramForwardBody = paramamsw.b(localModLongNick.uint64_uin.get() + "");
      if (paramForwardBody != null)
      {
        paramForwardBody.vRichSign = arrayOfByte;
        paramForwardBody.lSignModifyTime = l;
        paramamsw.a(paramForwardBody);
      }
      paramabxc.a().getBusinessHandler(1).notifyUI(3, true, str);
      paramabxc.a().getBusinessHandler(1).notifyUI(2, true, new String[] { str });
    }
  }
  
  private void a(abxc paramabxc, TroopManager paramTroopManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_mod_group_member_profile.has())
    {
      Object localObject1 = (SubMsgType0x27.ModGroupMemberProfile)paramForwardBody.msg_mod_group_member_profile.get();
      if ((((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_code.has()) && (((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_uin.has()))
      {
        long l1 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_uin.get();
        long l2 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_code.get();
        long l3 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_uin.get();
        paramForwardBody = bfun.a().a(paramabxc.a(), l2 + "", l3 + "");
        localObject1 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).rpt_msg_group_member_profile_infos.get().iterator();
        label463:
        label1015:
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (SubMsgType0x27.GroupMemberProfileInfo)((Iterator)localObject1).next();
          if ((((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.has()) && (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.has()))
          {
            if (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.get() != 1) {
              break label463;
            }
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModGroupMemberProfile 1--Nick = " + ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toStringUtf8() + " info.bytes_value.get().size() = " + ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().size());
            }
            amzf.a("cardpush", ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toByteArray(), ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().size());
            if (paramForwardBody != null)
            {
              paramForwardBody.colorNick = bgdk.a(((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get());
              paramForwardBody.name = bgdk.b(paramForwardBody.colorNick);
              paramTroopManager.a(l1 + "", l3 + "", paramForwardBody.colorNick, -100, null, null, -100, -100, -100, -100L, -100L);
            }
          }
          for (;;)
          {
            if (paramForwardBody == null) {
              break label1015;
            }
            bfun.a().a(paramabxc.a(), paramForwardBody);
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(paramForwardBody);
            paramabxc.a().getBusinessHandler(20).notifyUI(16, true, localObject2);
            paramabxc.a().getBusinessHandler(20).notifyUI(11, true, new Object[] { localObject2, Boolean.valueOf(true) });
            break;
            if (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.get() == 2)
            {
              if (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().size() == 1)
              {
                byte b = ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().byteAt(0);
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModGroupMemberProfile 2--sex = " + b);
                }
                paramTroopManager.a(l1 + "", l3 + "", null, -100, null, null, -100, b, -100, -100L, -100L);
                if (paramForwardBody != null) {
                  paramForwardBody.sex = b;
                }
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.get() == 3)
            {
              localObject2 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 3--phone = " + (String)localObject2);
              }
              if (paramForwardBody != null) {
                paramForwardBody.tel = ((String)localObject2);
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.get() == 4)
            {
              localObject2 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 4--email= " + (String)localObject2);
              }
              if (paramForwardBody != null) {
                paramForwardBody.email = ((String)localObject2);
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.get() == 5)
            {
              localObject2 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 5--remark= " + (String)localObject2);
              }
              ((TroopManager)paramabxc.a().getManager(52)).a(l1 + "", l3 + "", null, -100, null, (String)localObject2, -100, -100, -100, -100L, -100L);
              if (paramForwardBody != null) {
                paramForwardBody.memo = ((String)localObject2);
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.get() == 6)
            {
              localObject2 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 6--job= " + (String)localObject2);
              }
              if (paramForwardBody != null) {
                paramForwardBody.job = ((String)localObject2);
              }
            }
            else if ((((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.get() == 7) && (paramForwardBody != null))
            {
              paramForwardBody.colorNick = bgdk.a(((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get());
              paramForwardBody.name = bgdk.b(paramForwardBody.colorNick);
            }
          }
        }
      }
    }
  }
  
  private void a(abxc paramabxc, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_push_report_dev.has())
    {
      paramForwardBody = (SubMsgType0x27.PushReportDev)paramForwardBody.msg_push_report_dev.get();
      Bundle localBundle = new Bundle();
      localBundle.putInt("optype", 201);
      if (paramForwardBody.uint32_msg_type.has()) {
        localBundle.putInt("msgtype", paramForwardBody.uint32_msg_type.get());
      }
      if (paramForwardBody.bytes_cookie.has()) {
        localBundle.putString("cookie", paramForwardBody.bytes_cookie.get().toStringUtf8());
      }
      if (paramForwardBody.uint32_report_max_num.has()) {
        localBundle.putInt("count", paramForwardBody.uint32_report_max_num.get());
      }
      if (paramForwardBody.bytes_sn.has()) {
        localBundle.putString("sn", paramForwardBody.bytes_sn.get().toStringUtf8());
      }
      ((aara)paramabxc.a().getBusinessHandler(51)).a(39, localBundle);
    }
  }
  
  private void a(abxc paramabxc, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    ((aubv)paramabxc.a().getManager(379)).a(i);
  }
  
  private void a(abxc paramabxc, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject1 = new SubMsgType0x27.MsgBody();
    Object localObject2;
    int i;
    for (;;)
    {
      amxz localamxz;
      alnr localalnr;
      SubMsgType0x27.ForwardBody localForwardBody;
      try
      {
        localObject2 = (SubMsgType0x27.MsgBody)((SubMsgType0x27.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (amsw)paramabxc.a().getManager(51);
        localObject1 = (TroopManager)paramabxc.a().getManager(52);
        localamxz = (amxz)paramabxc.a().getManager(56);
        localalnr = (alnr)paramabxc.a().getManager(153);
        Object localObject3 = ((SubMsgType0x27.MsgBody)localObject2).rpt_msg_mod_infos.get();
        i = 0;
        localObject2 = new Friends[((List)localObject3).size()];
        localObject3 = ((List)localObject3).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localForwardBody = (SubMsgType0x27.ForwardBody)((Iterator)localObject3).next();
        if (((localForwardBody.uint32_notify_type.has()) && (localForwardBody.uint32_notify_type.get() == 1)) || (!localForwardBody.uint32_op_type.has())) {
          continue;
        }
        switch (localForwardBody.uint32_op_type.get())
        {
        case 60: 
        case 61: 
        default: 
          break;
        case 0: 
          i(paramabxc, paramArrayOfByte, localForwardBody);
          break;
        case 1: 
          h(paramabxc, paramArrayOfByte, localForwardBody);
        }
      }
      catch (Exception paramabxc)
      {
        QLog.e("MsgType0x210SubMsgType0x27", 1, "handleMsgType0x210SubMsgType0x27 decode fail.", paramabxc);
        return;
      }
      continue;
      g(paramabxc, paramArrayOfByte, localForwardBody);
      continue;
      f(paramabxc, paramArrayOfByte, localForwardBody);
      continue;
      e(paramabxc, paramArrayOfByte, localForwardBody);
      continue;
      a(paramabxc, paramArrayOfByte, localamxz, localForwardBody);
      continue;
      a(paramabxc, paramArrayOfByte, (TroopManager)localObject1, localForwardBody);
      continue;
      d(paramabxc, paramArrayOfByte, localForwardBody);
      continue;
      if (localForwardBody.msg_mod_profile.has())
      {
        i = a(paramabxc, localForwardBody, paramArrayOfByte, localalnr, (Friends[])localObject2, i);
        continue;
        c(paramabxc, (TroopManager)localObject1, localForwardBody);
        continue;
        c(paramabxc, paramArrayOfByte, localForwardBody);
        continue;
        b(paramabxc, paramArrayOfByte, localForwardBody);
        continue;
        a(paramabxc, paramArrayOfByte, localForwardBody);
        continue;
        b(paramabxc, (TroopManager)localObject1, localForwardBody);
        continue;
        a(paramabxc, (TroopManager)localObject1, localForwardBody);
        continue;
        g(paramabxc, localForwardBody);
        continue;
        f(paramabxc, localForwardBody);
        continue;
        b(paramabxc, localForwardBody);
        continue;
        a(paramabxc, localForwardBody);
        continue;
        e(paramabxc, localForwardBody);
        continue;
        d(paramabxc, localForwardBody);
        continue;
        c(paramabxc, localForwardBody);
        continue;
        b(localForwardBody);
        a(localForwardBody);
      }
    }
    paramArrayOfByte.a((Friends[])localObject2, i);
  }
  
  private void a(alnr paramalnr, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    long l1 = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    paramProfileInfo = paramalnr.b(String.valueOf(paramLong));
    long l2 = NetConnInfoCenter.getServerTime();
    if ((l1 > l2) && (paramProfileInfo.apolloSignValidTS != l1))
    {
      paramProfileInfo.apolloLocalSignTs = paramProfileInfo.apolloSignValidTS;
      paramProfileInfo.apolloSignValidTS = l1;
      paramProfileInfo.apolloSignStr = "";
      paramalnr.a(paramProfileInfo);
    }
    QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo push sign uin: " + paramLong + ", valid TS: " + l1 + ", currTS: " + l2);
  }
  
  private void a(amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    ExtensionInfo localExtensionInfo = paramamsw.a(String.valueOf(paramLong));
    paramProfileInfo = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramProfileInfo = new ExtensionInfo();
      paramProfileInfo.uin = String.valueOf(paramLong);
    }
    paramProfileInfo.pendantDiyId = i;
    paramProfileInfo.timestamp = System.currentTimeMillis();
    paramamsw.a(paramProfileInfo);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get PendantDiyId, uin=" + paramLong + ", id=" + paramProfileInfo.pendantDiyId);
    }
  }
  
  private void a(SubMsgType0x27.ForwardBody paramForwardBody)
  {
    try
    {
      paramForwardBody = (SubMsgType0x27.FrdCustomOnlineStatusChange)paramForwardBody.msg_frd_custom_online_status_change.get();
      if (paramForwardBody != null)
      {
        bgeg.a(paramForwardBody);
        QLog.d("Q.msg.BaseMessageProcessorCustomOnlineStatus", 2, "SubMsgType0x27.FrdCustomOnlineStatusChange");
      }
      return;
    }
    catch (Exception paramForwardBody)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.msg.BaseMessageProcessor", 2, "deal SubMsgType0x27.FrdCustomOnlineStatusChange fail", paramForwardBody);
    }
  }
  
  private void a(SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    bghq.b(i);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, " theme font online push " + paramProfileInfo.uint32_field.get() + " id:" + i);
    }
  }
  
  private void b(abxc paramabxc, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    ((bgga)paramabxc.a().getManager(235)).a.b(Long.toString(paramLong), i);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get faceId, uin=" + paramLong + ", id=" + i);
    }
  }
  
  private void b(abxc paramabxc, alnr paramalnr, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    if (paramalnr != null)
    {
      paramProfileInfo = paramalnr.b(paramabxc.a().getCurrentUin());
      if ((paramProfileInfo != null) && (i != paramProfileInfo.apolloAISwitch))
      {
        paramProfileInfo.apolloAISwitch = i;
        if ((paramabxc.a() != null) && (String.valueOf(paramLong).equals(paramabxc.a().getCurrentUin()))) {
          paramalnr.a(i, 2);
        }
        paramalnr.a(paramProfileInfo);
      }
    }
    QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo aiSwitch  push: " + i);
  }
  
  private void b(abxc paramabxc, amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {}
    for (int i = paramProfileInfo[0];; i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get())
    {
      paramProfileInfo = paramamsw.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.bigClubExtTemplateId = i;
        paramamsw.a(paramProfileInfo);
        paramabxc.a().getBusinessHandler(1).notifyUI(3, true, Long.toString(paramLong));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "vip_card_extension id by push=" + i);
      }
      return;
    }
  }
  
  private void b(abxc paramabxc, amsw paramamsw, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_mod_friend_remark.has())
    {
      Iterator localIterator = ((SubMsgType0x27.ModFriendRemark)paramForwardBody.msg_mod_friend_remark.get()).rpt_msg_frd_rmk.get().iterator();
      while (localIterator.hasNext())
      {
        SubMsgType0x27.FriendRemark localFriendRemark = (SubMsgType0x27.FriendRemark)localIterator.next();
        if (localFriendRemark.uint32_type.has()) {
          if (localFriendRemark.uint32_type.get() == 0)
          {
            long l = localFriendRemark.uint64_fuin.get();
            Friends localFriends = paramamsw.e(Long.toString(l));
            paramForwardBody = null;
            if (localFriends != null) {
              paramForwardBody = localFriends.remark;
            }
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModFriendRemark  : 0 Friend uin = " + localFriendRemark.uint64_fuin.get() + "备注 = " + localFriendRemark.bytes_rmk_name.get().toStringUtf8() + ",oldRemark = " + paramForwardBody);
            }
            paramamsw.b(localFriendRemark.uint64_fuin.get() + "", localFriendRemark.bytes_rmk_name.get().toStringUtf8());
            Card localCard = paramamsw.b(localFriendRemark.uint64_fuin.get() + "");
            String str = localFriendRemark.bytes_rmk_name.get().toStringUtf8();
            if ((localCard != null) && (!str.equals(localCard.strReMark)))
            {
              localCard.strReMark = str;
              paramamsw.a(localCard);
            }
            if ((localFriends != null) && (localFriends.isFriend()) && (amzf.b(str, paramForwardBody))) {
              amzf.b(l, str, (amrb)paramabxc.a().getManager(53));
            }
            paramabxc.a().getBusinessHandler(1).notifyUI(3, true, Long.toString(localFriendRemark.uint64_fuin.get()));
            paramabxc.a().getBusinessHandler(1).notifyUI(27, true, new Object[] { localFriendRemark.uint64_fuin.get() + "", localFriendRemark.bytes_rmk_name.get().toStringUtf8(), Byte.valueOf(1) });
            TroopNameHelper.b(Long.toString(l));
          }
          else if (localFriendRemark.uint32_type.get() == 1)
          {
            if (localFriendRemark.uint64_group_code.has())
            {
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModFriendRemark  : 1 troop remarkuin = " + localFriendRemark.uint64_fuin.get() + " troopcode = " + localFriendRemark.uint64_group_code.get() + " remark = " + localFriendRemark.bytes_rmk_name.get().toStringUtf8() + "目前群备注在android上没看到有地方显示？");
              }
            }
            else if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModFriendRemark  : 1 troop remark uin = " + localFriendRemark.uint64_fuin.get() + " remark = " + localFriendRemark.bytes_rmk_name.get().toStringUtf8() + "目前群备注在android上没看到有地方显示？");
            }
          }
        }
      }
    }
  }
  
  private void b(abxc paramabxc, TroopManager paramTroopManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    long l1;
    long l2;
    if (paramForwardBody.msg_mod_group_profile.has())
    {
      paramForwardBody = (SubMsgType0x27.ModGroupProfile)paramForwardBody.msg_mod_group_profile.get();
      if (paramForwardBody.uint64_group_code.has())
      {
        l1 = paramForwardBody.uint64_group_uin.get();
        l2 = paramForwardBody.uint64_group_code.get();
      }
    }
    for (;;)
    {
      Object localObject;
      try
      {
        paramForwardBody = paramForwardBody.rpt_msg_group_profile_infos.get().iterator();
        if (paramForwardBody.hasNext())
        {
          localObject = (SubMsgType0x27.GroupProfileInfo)paramForwardBody.next();
          if ((!((SubMsgType0x27.GroupProfileInfo)localObject).uint32_field.has()) || (!((SubMsgType0x27.GroupProfileInfo)localObject).bytes_value.has())) {
            continue;
          }
          if (((SubMsgType0x27.GroupProfileInfo)localObject).uint32_field.get() == 1)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("cardpush", 2, "push a ModGroupProfile 1--TroopName  = " + ((SubMsgType0x27.GroupProfileInfo)localObject).bytes_value.get().toStringUtf8());
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramabxc)
      {
        paramabxc.printStackTrace();
      }
      if (((SubMsgType0x27.GroupProfileInfo)localObject).uint32_field.get() == 2)
      {
        localObject = ((SubMsgType0x27.GroupProfileInfo)localObject).bytes_value.get();
        if ((localObject != null) && (((ByteStringMicro)localObject).size() == 2))
        {
          int i = ((ByteStringMicro)localObject).byteAt(0);
          short s = (short)(((ByteStringMicro)localObject).byteAt(1) | i << 8);
          localObject = paramTroopManager.b(l1 + "");
          ((TroopInfo)localObject).troopface = s;
          ((TroopInfo)localObject).hasSetNewTroopHead = true;
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModGroupProfile 2--TroopHead(2bytes) = " + s);
          }
          paramTroopManager.b((TroopInfo)localObject);
          ((FriendListHandler)paramabxc.a().getBusinessHandler(1)).getTroopHead(l1 + "");
        }
      }
      else if (((SubMsgType0x27.GroupProfileInfo)localObject).uint32_field.get() == 3)
      {
        localObject = ((SubMsgType0x27.GroupProfileInfo)localObject).bytes_value.get().toStringUtf8();
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.data", 2, "onLinePush, creditLevelChange:" + l1 + "," + l2 + "," + (String)localObject);
        }
        TroopInfo localTroopInfo = paramTroopManager.b(l2 + "");
        if (localTroopInfo != null)
        {
          localTroopInfo.troopCreditLevel = Long.valueOf((String)localObject).longValue();
          paramTroopManager.b(localTroopInfo);
          if (QLog.isColorLevel()) {
            QLog.i("troop.credit.data", 2, "onLinePush, creditLevelChange, save");
          }
        }
      }
    }
  }
  
  private void b(abxc paramabxc, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_push_search_dev.has())
    {
      paramForwardBody = (SubMsgType0x27.PushSearchDev)paramForwardBody.msg_push_search_dev.get();
      Bundle localBundle = new Bundle();
      localBundle.putInt("optype", 200);
      if (paramForwardBody.uint32_msg_type.has()) {
        localBundle.putInt("msgtype", paramForwardBody.uint32_msg_type.get());
      }
      if (paramForwardBody.uint32_dev_time.has()) {
        localBundle.putInt("devtime", paramForwardBody.uint32_dev_time.get());
      }
      if (paramForwardBody.uint64_din.has()) {
        localBundle.putLong("din", paramForwardBody.uint64_din.get());
      }
      if (paramForwardBody.str_data.has()) {
        localBundle.putString("data", paramForwardBody.str_data.get());
      }
      ((aara)paramabxc.a().getBusinessHandler(51)).a(39, localBundle);
    }
  }
  
  private void b(abxc paramabxc, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "handleModProfileBranch: invoked. c2c online push, field id: 27370, changed global ring id", " ringId: ", Integer.valueOf(i) });
    }
    apka.a(paramabxc.a()).b(i);
  }
  
  private void b(alnr paramalnr, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    paramProfileInfo = paramalnr.b(String.valueOf(paramLong));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "apollo push uin: " + paramLong + ", avip level: " + i);
    }
    if (paramProfileInfo.apolloVipLevel != i)
    {
      paramProfileInfo.apolloVipLevel = i;
      paramalnr.a(paramProfileInfo);
    }
  }
  
  private void b(amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {}
    for (int i = paramProfileInfo[0];; i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get())
    {
      paramProfileInfo = paramamsw.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.cNewLoverDiamondFlag = i;
        paramamsw.a(paramProfileInfo);
      }
      return;
    }
  }
  
  private void b(SubMsgType0x27.ForwardBody paramForwardBody)
  {
    try
    {
      if ((SubMsgType0x27.ChatMatchInfo)paramForwardBody.msg_chat_match_info.get() != null) {
        QLog.d("Q.msg.BaseMessageProcessorExtendFriendLimitChat", 2, "SubMsgType0x27.ChatMatchInfo");
      }
      return;
    }
    catch (Exception paramForwardBody)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.msg.BaseMessageProcessor", 2, "deal SubMsgType0x27.ChatMatchInfo fail", paramForwardBody);
    }
  }
  
  private void c(abxc paramabxc, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    if (paramLong == paramabxc.a().getLongAccountUin())
    {
      int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
      if (i != alnr.a(paramabxc.a()))
      {
        paramProfileInfo = (alnr)paramabxc.a().getManager(153);
        paramProfileInfo.b(i);
        if (i == 1)
        {
          paramProfileInfo = paramProfileInfo.b(paramabxc.a().getCurrentUin());
          if ((paramProfileInfo.isApolloStatusOpen()) && (paramProfileInfo.apolloLocalTS != paramProfileInfo.apolloServerTS))
          {
            paramabxc = (VasExtensionHandler)paramabxc.a().getBusinessHandler(71);
            if (paramabxc != null) {
              paramabxc.a("whiteList");
            }
          }
        }
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo push white list: " + i);
    }
  }
  
  private void c(abxc paramabxc, alnr paramalnr, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    paramProfileInfo = String.valueOf(paramLong);
    if (TextUtils.isEmpty(paramProfileInfo)) {}
    do
    {
      return;
      ApolloBaseInfo localApolloBaseInfo = paramalnr.b(paramProfileInfo);
      if (paramProfileInfo.equals(paramabxc.a().getCurrentUin())) {
        ((VasExtensionHandler)paramabxc.a().getBusinessHandler(71)).a(new long[] { paramLong });
      }
      QLog.d("Q.msg.BaseMessageProcessor", 1, new Object[] { "apollo push uin: " + new StringBuilder().append(paramLong).append("temp").toString().substring(0, 4) + ", timeStamp: " + i, ", local server:", Long.valueOf(localApolloBaseInfo.apolloServerTS) });
      if (localApolloBaseInfo.apolloServerTS != i)
      {
        localApolloBaseInfo.apolloServerTS = i;
        paramalnr.a(localApolloBaseInfo);
      }
      int j = 0;
      paramalnr = paramabxc.a().getMessageFacade();
      i = j;
      if (paramalnr != null)
      {
        i = j;
        if (paramalnr.isChatting())
        {
          i = j;
          if (!TextUtils.isEmpty(paramalnr.getCurrChatUin()))
          {
            i = j;
            if (paramalnr.getCurrChatType() == 0)
            {
              i = j;
              if (paramalnr.getCurrChatUin().equals(paramProfileInfo)) {
                i = 1;
              }
            }
          }
        }
      }
    } while (((!paramProfileInfo.equals(paramabxc.a().getCurrentUin())) || (alnr.a(paramabxc.a()) != 2)) && (i == 0));
    paramabxc = (VasExtensionHandler)paramabxc.a().getBusinessHandler(71);
    paramalnr = new ArrayList();
    paramalnr.add(Long.valueOf(paramLong));
    paramabxc.a(paramalnr, "online_push");
  }
  
  private void c(abxc paramabxc, amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = 0;
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {
      i = paramProfileInfo[0];
    }
    for (;;)
    {
      paramProfileInfo = paramamsw.b(paramLong + "");
      if ((paramProfileInfo != null) && (paramProfileInfo.mQQLevelType != i))
      {
        paramProfileInfo.mQQLevelType = i;
        paramamsw.a(paramProfileInfo);
        paramabxc.a().getBusinessHandler(2).notifyUI(1, true, paramProfileInfo);
      }
      return;
      if (paramProfileInfo.length == 2) {
        i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get();
      } else if (paramProfileInfo.length == 4) {
        i = ByteBuffer.wrap(paramProfileInfo).asIntBuffer().get();
      } else {
        QLog.e("Q.msg.BaseMessageProcessor", 2, "rsp VASPROFILEGATE_SERVICE oidb FIELD_QQ_LEVEL_ICON_TYPE flag content error, len:" + paramProfileInfo.length);
      }
    }
  }
  
  private void c(abxc paramabxc, amsw paramamsw, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_daren_notify.has())
    {
      paramForwardBody = (SubMsgType0x27.DaRenNotify)paramForwardBody.msg_daren_notify.get();
      long l = paramForwardBody.uint64_uin.get();
      int i = paramForwardBody.uint32_login_days.get();
      int j = paramForwardBody.uint32_days.get();
      if (paramabxc.a().getCurrentAccountUin().equals(String.valueOf(l)))
      {
        paramForwardBody = paramamsw.c(paramabxc.a().getCurrentAccountUin());
        if ((i != paramForwardBody.lLoginDays) || (j != paramForwardBody.lQQMasterLogindays))
        {
          paramForwardBody.lLoginDays = i;
          paramForwardBody.lQQMasterLogindays = j;
          paramamsw.a(paramForwardBody);
          paramabxc.a().getBusinessHandler(2).notifyUI(1, true, paramForwardBody);
        }
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "daren notify received local data logindays=" + paramForwardBody.lLoginDays + ";days=" + paramForwardBody.lQQMasterLogindays);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "daren notify received uin=" + l + ";logindays=" + i + ";days=" + j);
      }
    }
  }
  
  private void c(abxc paramabxc, TroopManager paramTroopManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    SubMsgType0x27.ModCustomFace localModCustomFace;
    if (paramForwardBody.msg_mod_custom_face.has())
    {
      localModCustomFace = (SubMsgType0x27.ModCustomFace)paramForwardBody.msg_mod_custom_face.get();
      if ((localModCustomFace.uint32_type.has()) && (localModCustomFace.uint64_uin.has()))
      {
        paramForwardBody = (FriendListHandler)paramabxc.a().getBusinessHandler(1);
        if (localModCustomFace.uint32_type.get() != 0) {
          break label136;
        }
        l = localModCustomFace.uint64_uin.get();
        paramTroopManager = Long.toString(l);
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModCustomFace  :0  Normal user uin = " + l);
        }
        paramForwardBody.getCustomHead(paramTroopManager);
        paramabxc.a().getBusinessHandler(1).notifyUI(3, true, paramTroopManager);
      }
    }
    label136:
    while (localModCustomFace.uint32_type.get() != 1) {
      return;
    }
    long l = localModCustomFace.uint64_group_code.get();
    if (QLog.isColorLevel()) {
      QLog.d("cardpush", 2, "push a ModCustomFace  :1 Troop uin = " + l);
    }
    paramabxc = paramTroopManager.b(String.valueOf(l));
    paramabxc.hasSetNewTroopHead = true;
    paramTroopManager.b(paramabxc);
    paramForwardBody.getTroopHead(Long.toString(l));
  }
  
  private void c(abxc paramabxc, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    try
    {
      paramForwardBody = (SubMsgType0x27.MQQCampusNotify)paramForwardBody.msg_campus_notify.get();
      if (paramForwardBody != null) {
        ((apjz)paramabxc.a().getManager(240)).a(paramForwardBody);
      }
      return;
    }
    catch (Exception paramabxc)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.msg.BaseMessageProcessor", 2, "deal SubMsgType0x27.MQQCampusNotify fail", paramabxc);
    }
  }
  
  private void c(abxc paramabxc, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length > 1)
    {
      boolean bool1;
      boolean bool2;
      Object localObject;
      String str;
      long l;
      if (paramProfileInfo[1] == 1)
      {
        bool1 = true;
        QLog.e("vip_ptt.Q.msg.BaseMessageProcessor", 1, "it have receive push value:" + bool1);
        bool2 = bool1;
        if (bool1)
        {
          paramProfileInfo = (aqai)apub.a().a(442);
          bool2 = bool1;
          if (paramProfileInfo != null)
          {
            bool2 = bool1;
            if (!paramProfileInfo.a())
            {
              QLog.e("vip_ptt.Q.msg.BaseMessageProcessor", 1, "get ptt auto to txt push switch is true but config is close!!");
              bool2 = false;
            }
          }
        }
        localObject = paramabxc.a().getApp().getSharedPreferences("check_update_sp_key", 0);
        paramProfileInfo = "businessinfo_ptt_auto_change_text_" + paramabxc.a().getCurrentAccountUin();
        str = "businessinfo_ptt_auto_change_time_" + paramabxc.a().getCurrentAccountUin();
        paramabxc = "businessinfo_ptt_auto_change_guide_has_show_" + paramabxc.a().getCurrentAccountUin();
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putBoolean(paramProfileInfo, bool2);
        l = NetConnInfoCenter.getServerTime();
        if (!bool2) {
          break label276;
        }
        ((SharedPreferences.Editor)localObject).putLong(str, l);
        ((SharedPreferences.Editor)localObject).putBoolean(paramabxc, true);
      }
      for (;;)
      {
        ((SharedPreferences.Editor)localObject).apply();
        agkq.d = bool2;
        agkq.a = l;
        return;
        bool1 = false;
        break;
        label276:
        ((SharedPreferences.Editor)localObject).putLong(str, 9223372036854775807L);
      }
    }
    QLog.e("vip_ptt.Q.msg.BaseMessageProcessor", 1, "it have receive push value is null");
    paramabxc = (amov)paramabxc.a().getBusinessHandler(2);
    paramProfileInfo = new ArrayList();
    paramProfileInfo.add(Short.valueOf((short)-23249));
    paramabxc.a(paramProfileInfo, null);
  }
  
  private void c(alnr paramalnr, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    paramProfileInfo = paramalnr.b(String.valueOf(paramLong));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "apollo push uin: " + paramLong + ", avip flag: " + i);
    }
    if (paramProfileInfo.apolloVipFlag != i)
    {
      paramProfileInfo.apolloVipFlag = i;
      paramalnr.a(paramProfileInfo);
    }
  }
  
  private void c(amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    if ((paramProfileInfo.uint32_field.has()) && (paramProfileInfo.bytes_value.has()))
    {
      int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push 42354 = " + i);
      }
      paramProfileInfo = paramamsw.b(paramLong + "");
      Friends localFriends = paramamsw.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.grayNameplateFlag = i;
        paramamsw.a(paramProfileInfo);
      }
      if (localFriends != null)
      {
        localFriends.grayNameplateFlag = i;
        paramamsw.a(localFriends);
      }
    }
  }
  
  private void d(abxc paramabxc, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = 3;
    paramProfileInfo = paramProfileInfo.bytes_value.get();
    SharedPreferences localSharedPreferences;
    if (((paramProfileInfo.byteAt(31) & 0x20) != 0) || ((paramProfileInfo.byteAt(34) & 0x10) != 0) || ((paramProfileInfo.byteAt(29) & 0x10) != 0))
    {
      localSharedPreferences = paramabxc.a().getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
      if (((paramProfileInfo.byteAt(11) & 0x20) == 0) && ((paramProfileInfo.byteAt(14) & 0x10) == 0)) {
        break label357;
      }
      i = 4;
      if (i != -1)
      {
        localSharedPreferences.edit().putInt("message_roam_flag" + paramabxc.a().getCurrentAccountUin(), i).apply();
        paramabxc.a().getBusinessHandler(1).notifyUI(101, true, Integer.valueOf(i));
      }
    }
    if ((paramProfileInfo.byteAt(12) & 0x8) != 0)
    {
      bool = true;
      label183:
      bcmt.a(paramabxc.a(), bool);
      if ((paramProfileInfo.byteAt(13) & 0x40) == 0) {
        break label436;
      }
    }
    label436:
    for (boolean bool = true;; bool = false)
    {
      if (SettingCloneUtil.readValue(paramabxc.a().getApplication(), Long.toString(paramLong), null, "qqsetting_pcactive_key", false) != bool)
      {
        SettingCloneUtil.writeValue(paramabxc.a().getApplication(), Long.valueOf(paramLong).toString(), null, "qqsetting_pcactive_key", bool);
        paramProfileInfo = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
        paramProfileInfo.putExtra("pcActive", bool);
        paramProfileInfo.putExtra("uin", Long.valueOf(paramLong).toString());
        paramabxc.a().getApp().sendBroadcast(paramProfileInfo);
        if (bool)
        {
          SettingCloneUtil.writeValue(paramabxc.a().getApplication(), Long.toString(paramLong), null, "pcactive_config", true);
          paramabxc.a().openMsfPCActive(Long.toString(paramLong), "config", true);
          QLog.d("OnlinePush", 1, "PCActive opened: true by switch push");
        }
      }
      return;
      label357:
      if ((paramProfileInfo.byteAt(9) & 0x10) != 0) {
        break;
      }
      i = localSharedPreferences.getInt("message_roam_flag" + paramabxc.a().getCurrentAccountUin(), -1);
      if ((i == 4) || (i == 3))
      {
        i = 1;
        break;
      }
      i = -1;
      break;
      bool = false;
      break label183;
    }
  }
  
  private void d(abxc paramabxc, alnr paramalnr, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    paramProfileInfo = paramalnr.b(String.valueOf(paramLong));
    if ((QLog.isColorLevel()) || (paramLong == paramabxc.a().getLongAccountUin())) {
      QLog.d("Q.msg.BaseMessageProcessor", 1, "apollo push uin: " + paramLong + ", apollo status: " + i);
    }
    if (paramProfileInfo.apolloStatus != i)
    {
      paramProfileInfo.apolloStatus = i;
      paramalnr.a(paramProfileInfo);
      if ((paramLong == paramabxc.a().getLongAccountUin()) && (paramProfileInfo.isApolloStatusOpen()) && (paramProfileInfo.apolloLocalTS != paramProfileInfo.apolloServerTS))
      {
        paramalnr = (VasExtensionHandler)paramabxc.a().getBusinessHandler(71);
        if (paramalnr != null) {
          paramalnr.a("statusChange");
        }
      }
    }
    paramProfileInfo = String.valueOf(paramLong);
    if (paramLong == paramabxc.a().getLongAccountUin())
    {
      paramalnr = new Pair(paramProfileInfo, Integer.valueOf(i));
      paramabxc.a().getBusinessHandler(71).notifyUI(3, true, paramalnr);
    }
    do
    {
      return;
      paramalnr = new ArrayList();
      paramalnr.add(paramProfileInfo);
      paramabxc = ambc.a(paramabxc.a());
    } while (paramabxc == null);
    paramabxc.a(i, paramalnr);
  }
  
  private void d(abxc paramabxc, amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {}
    for (int i = paramProfileInfo[0];; i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push the big club iVipType change = " + i);
      }
      paramProfileInfo = paramamsw.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.bigClubInfo = ((i & 0xFF) << 16 | paramProfileInfo.bigClubInfo & 0xFF00FFFF);
        paramamsw.a(paramProfileInfo);
        paramabxc.a().getBusinessHandler(1).notifyUI(3, true, Long.toString(paramLong));
      }
      paramamsw = ((TicketManager)paramabxc.a().getManager(2)).getSkey(paramLong + "");
      ((aneg)paramabxc.a().getBusinessHandler(27)).a(paramamsw, paramLong + "");
      return;
    }
  }
  
  private void d(abxc paramabxc, amsw paramamsw, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_mod_friend_flag.has())
    {
      paramForwardBody = (SubMsgType0x27.SnsUpdateFlag)paramForwardBody.msg_mod_friend_flag.get();
      if (paramForwardBody.rpt_msg_update_sns_flag.has())
      {
        paramForwardBody = paramForwardBody.rpt_msg_update_sns_flag.get().iterator();
        while (paramForwardBody.hasNext())
        {
          Object localObject = (SubMsgType0x27.SnsUpdateOneFlag)paramForwardBody.next();
          long l1 = ((SubMsgType0x27.SnsUpdateOneFlag)localObject).uint64__uin.get();
          int i = ((SubMsgType0x27.SnsUpdateOneFlag)localObject).uint32_flag.get();
          long l2 = ((SubMsgType0x27.SnsUpdateOneFlag)localObject).uint64_id.get();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "FriendShield : onLinePush : uin : " + l1 + " flag:" + i + " id:" + l2);
          }
          if (l2 == 4051L)
          {
            localObject = paramamsw.e(String.valueOf(l1));
            if (localObject != null)
            {
              if (i == 1) {}
              for (boolean bool = true;; bool = false)
              {
                ((Friends)localObject).setShieldFlag(bool);
                paramamsw.a((Friends)localObject);
                paramabxc.a().getBusinessHandler(1).notifyUI(56, true, new Object[] { Long.valueOf(l1), Boolean.valueOf(bool), Boolean.valueOf(true), Boolean.valueOf(true), "" });
                break;
              }
            }
          }
        }
      }
    }
  }
  
  private void d(abxc paramabxc, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    paramForwardBody = (SubMsgType0x27.PraiseRankNotify)paramForwardBody.msg_praise_rank_notify.get();
    if (paramForwardBody.str_msg.has()) {}
    for (paramForwardBody = paramForwardBody.str_msg.get();; paramForwardBody = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "praise rank notify: " + paramForwardBody);
      }
      if (!TextUtils.isEmpty(paramForwardBody))
      {
        Bitmap localBitmap = bfpx.a(paramabxc.a().getApp().getResources(), 2130840385);
        ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramabxc.a().getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
        Intent localIntent = new Intent(paramabxc.a().getApp(), LikeRankingListActivity.class);
        localIntent.putExtra("param_from", 1);
        localIntent.addFlags(67108864);
        localToServiceMsg.extraData.putStringArray("cmds", new String[] { "QQ", "QQ", paramForwardBody });
        localToServiceMsg.extraData.putParcelable("intent", localIntent);
        localToServiceMsg.extraData.putParcelable("bitmap", localBitmap);
        paramabxc.a().sendToService(localToServiceMsg);
        paramabxc.a().reportClickEvent("dc00898", "0X8007618");
      }
      return;
    }
  }
  
  private void d(abxc paramabxc, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    boolean bool = false;
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {
      if (paramProfileInfo[0] == 0) {
        bool = true;
      }
    }
    for (;;)
    {
      ahns.a(paramabxc.a()).a(bool);
      paramabxc.a().getBusinessHandler(2).notifyUI(104, true, Boolean.valueOf(bool));
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageProcessor", 2, "handleModProfileBranch emotionRec flag:" + bool);
      }
      return;
      if (ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get() == 0) {
        bool = true;
      }
    }
  }
  
  private void d(amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    if ((paramProfileInfo.uint32_field.has()) && (paramProfileInfo.bytes_value.has()))
    {
      int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push 42344 = " + i);
      }
      paramProfileInfo = paramamsw.b(paramLong + "");
      Friends localFriends = paramamsw.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.nameplateVipType = i;
        paramamsw.a(paramProfileInfo);
      }
      if (localFriends != null)
      {
        localFriends.nameplateVipType = i;
        paramamsw.a(localFriends);
      }
    }
  }
  
  private void e(abxc paramabxc, amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {}
    for (int i = paramProfileInfo[0];; i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get())
    {
      paramProfileInfo = paramamsw.b(paramLong + "");
      Friends localFriends = paramamsw.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.lBigClubTemplateId = i;
        paramProfileInfo.lSuperVipTemplateId = i;
        paramamsw.a(paramProfileInfo);
        paramabxc.a().getBusinessHandler(2).notifyUI(1, true, paramProfileInfo);
      }
      if (localFriends != null)
      {
        localFriends.superVipTemplateId = i;
        localFriends.bigClubTemplateId = i;
        paramamsw.a(localFriends);
        paramabxc.a().getBusinessHandler(1).notifyUI(3, true, Long.toString(paramLong));
      }
      return;
    }
  }
  
  private void e(abxc paramabxc, amsw paramamsw, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    SubMsgType0x27.FriendGroup localFriendGroup;
    long l;
    int j;
    if (paramForwardBody.msg_mod_friend_group.has())
    {
      paramForwardBody = ((SubMsgType0x27.ModFriendGroup)paramForwardBody.msg_mod_friend_group.get()).rpt_msg_frd_group.get();
      if (paramForwardBody != null)
      {
        paramForwardBody = paramForwardBody.iterator();
        while (paramForwardBody.hasNext())
        {
          localFriendGroup = (SubMsgType0x27.FriendGroup)paramForwardBody.next();
          if ((localFriendGroup.uint64_fuin.has()) && (localFriendGroup.rpt_uint32_new_group_id.get().size() > 0))
          {
            l = localFriendGroup.uint64_fuin.get();
            j = ((Integer)localFriendGroup.rpt_uint32_new_group_id.get(0)).intValue();
            if (localFriendGroup.rpt_uint32_old_group_id.get().size() <= 0) {
              break label278;
            }
          }
        }
      }
    }
    label278:
    for (int i = ((Integer)localFriendGroup.rpt_uint32_old_group_id.get(0)).intValue();; i = 0)
    {
      paramamsw.a(l + "", j);
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "push a ModFriendGroup  = id:" + l + " newgroupid:" + j);
      }
      paramabxc.a().getBusinessHandler(1).notifyUI(9, true, new Object[] { l + "", Byte.valueOf((byte)j), Byte.valueOf((byte)i) });
      break;
      return;
    }
  }
  
  private void e(abxc paramabxc, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_new_comein_user_notify.has())
    {
      paramForwardBody = (SubMsgType0x27.NewComeinUserNotify)paramForwardBody.msg_new_comein_user_notify.get();
      if (!paramForwardBody.uint32_msg_type.has()) {
        break label132;
      }
    }
    label132:
    for (int i = paramForwardBody.uint32_msg_type.get();; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "receive msg0x210submsg0x27 face2face add friend push, type:" + i);
      }
      if (i == 1)
      {
        paramabxc = (amuu)paramabxc.a().getBusinessHandler(3);
        if (paramabxc != null) {
          paramabxc.a(paramForwardBody);
        }
      }
      do
      {
        do
        {
          return;
        } while ((i != 2) && (i != 3));
        paramabxc = (amwx)paramabxc.a().getBusinessHandler(57);
      } while (paramabxc == null);
      paramabxc.a(i, paramForwardBody);
      return;
    }
  }
  
  private void e(abxc paramabxc, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    paramabxc = (ChatBackgroundManager)paramabxc.a().getManager(63);
    if (paramabxc != null) {
      paramabxc.a(i, 0, null, "onlinePush", -1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, " bg online push " + paramProfileInfo.uint32_field.get() + " bgId:" + i);
    }
  }
  
  private void f(abxc paramabxc, amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {}
    for (int i = paramProfileInfo[0];; i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get())
    {
      paramProfileInfo = paramamsw.b(paramLong + "");
      Friends localFriends = paramamsw.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.iBigClubVipType = i;
        paramamsw.a(paramProfileInfo);
        paramabxc.a().getBusinessHandler(2).notifyUI(1, true, paramProfileInfo);
      }
      if (localFriends != null)
      {
        localFriends.bigClubInfo = (localFriends.bigClubInfo & 0xFFFFFF | (i & 0xFF) << 24);
        paramamsw.a(localFriends);
        paramabxc.a().getBusinessHandler(1).notifyUI(3, true, Long.toString(paramLong));
      }
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push the big club type change=" + i);
      }
      paramamsw = ((TicketManager)paramabxc.a().getManager(2)).getSkey(paramLong + "");
      ((aneg)paramabxc.a().getBusinessHandler(27)).a(paramamsw, paramLong + "");
      return;
    }
  }
  
  private void f(abxc paramabxc, amsw paramamsw, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    byte[] arrayOfByte;
    if (paramForwardBody.msg_mod_group_sort.has())
    {
      Object localObject = ((SubMsgType0x27.ModGroupSort)paramForwardBody.msg_mod_group_sort.get()).rpt_msg_groupsort.get();
      if (localObject != null)
      {
        paramForwardBody = new byte[((List)localObject).size()];
        arrayOfByte = new byte[((List)localObject).size()];
        localObject = ((List)localObject).iterator();
        int i = 0;
        if (((Iterator)localObject).hasNext())
        {
          SubMsgType0x27.GroupSort localGroupSort = (SubMsgType0x27.GroupSort)((Iterator)localObject).next();
          if ((!localGroupSort.uint32_groupid.has()) || (!localGroupSort.uint32_sortid.has())) {
            break label225;
          }
          paramForwardBody[i] = ((byte)localGroupSort.uint32_groupid.get());
          arrayOfByte[i] = ((byte)localGroupSort.uint32_sortid.get());
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModGroupSort  = id:" + localGroupSort.uint32_groupid.get() + " sortid:" + localGroupSort.uint32_sortid.get());
          }
          i += 1;
        }
      }
    }
    label225:
    for (;;)
    {
      break;
      paramabxc.a().getBusinessHandler(1).notifyUI(22, true, null);
      paramamsw.a(paramForwardBody, arrayOfByte);
      return;
    }
  }
  
  private void f(abxc paramabxc, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.bytes_redpoint_info.has()) {
      ((axfy)paramabxc.a().getManager(160)).a(paramForwardBody.bytes_redpoint_info.get().toByteArray());
    }
  }
  
  private void f(abxc paramabxc, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    boolean bool = ThemeUtil.isNowThemeIsSimple(paramabxc.a(), false, null);
    if ((!bool) && (bdai.a(String.valueOf(i)))) {
      if (!ThemeSwitcher.a(String.valueOf(i))) {
        ThemeSwitcher.a(String.valueOf(i), "209", null);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "theme online push " + paramProfileInfo.uint32_field.get() + " themeId:" + i + " isSimpleMode：" + bool);
      }
      return;
      bdbo.a(paramabxc.a(), String.valueOf(i), "20000000");
    }
  }
  
  private void g(abxc paramabxc, amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {}
    for (int i = paramProfileInfo[0];; i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push the big club level change=" + i);
      }
      paramProfileInfo = paramamsw.b(paramLong + "");
      Friends localFriends = paramamsw.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.iBigClubVipLevel = i;
        paramamsw.a(paramProfileInfo);
        paramabxc.a().getBusinessHandler(2).notifyUI(1, true, paramProfileInfo);
      }
      if (localFriends != null)
      {
        localFriends.bigClubInfo = (i & 0xFFFF | localFriends.bigClubInfo & 0xFFFF0000);
        paramamsw.a(localFriends);
        paramabxc.a().getBusinessHandler(1).notifyUI(3, true, Long.toString(paramLong));
      }
      paramamsw = ((TicketManager)paramabxc.a().getManager(2)).getSkey(paramLong + "");
      ((aneg)paramabxc.a().getBusinessHandler(27)).a(paramamsw, paramLong + "");
      return;
    }
  }
  
  private void g(abxc paramabxc, amsw paramamsw, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    SubMsgType0x27.ModGroupName localModGroupName;
    int i;
    String str;
    if (paramForwardBody.msg_mod_group_name.has())
    {
      localModGroupName = (SubMsgType0x27.ModGroupName)paramForwardBody.msg_mod_group_name.get();
      if ((localModGroupName.uint32_groupid.has()) && (localModGroupName.bytes_groupname.has()))
      {
        i = localModGroupName.uint32_groupid.get();
        str = localModGroupName.bytes_groupname.get().toStringUtf8();
        paramForwardBody = paramamsw.a(String.valueOf(i));
        if (paramForwardBody == null) {
          break label215;
        }
      }
    }
    for (paramForwardBody.group_name = str;; paramForwardBody.group_name = str)
    {
      paramamsw.a(paramForwardBody);
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "push a ModGroupName  = id:" + localModGroupName.uint32_groupid.get() + " name:" + localModGroupName.bytes_groupname.get().toStringUtf8());
      }
      paramamsw = new RenameGroupResp();
      paramamsw.dwToUin = localModGroupName.uint32_groupid.get();
      paramamsw.sGroupName = localModGroupName.bytes_groupname.get().toStringUtf8();
      paramamsw = new GroupActionResp(0, "", paramamsw);
      paramabxc.a().getBusinessHandler(1).notifyUI(19, true, paramamsw);
      return;
      label215:
      paramForwardBody = new Groups();
      paramForwardBody.group_id = i;
    }
  }
  
  private void g(abxc paramabxc, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    Object localObject;
    long l1;
    if (paramForwardBody.msg_appointment_notify.has())
    {
      localObject = (SubMsgType0x27.AppointmentNotify)paramForwardBody.msg_appointment_notify.get();
      if (((SubMsgType0x27.AppointmentNotify)localObject).uint32_notifytype.has())
      {
        l1 = ((SubMsgType0x27.AppointmentNotify)localObject).uint32_notifytype.get();
        if ((l1 != 2L) && (l1 != 4L) && (l1 != 5L) && ((l1 != 6L) || (!((SubMsgType0x27.AppointmentNotify)localObject).bytes_feed_event_info.has()))) {
          break label99;
        }
        paramabxc.a().getNearbyProxy().a((SubMsgType0x27.AppointmentNotify)localObject);
      }
    }
    label99:
    while (((l1 != 0L) && (l1 != 1L) && (l1 != 3L)) || (!((SubMsgType0x27.AppointmentNotify)localObject).uint64_from_uin.has())) {
      return;
    }
    long l2 = ((SubMsgType0x27.AppointmentNotify)localObject).uint64_from_uin.get();
    String str1 = null;
    String str2 = paramabxc.a().getCurrentAccountUin();
    String str3 = Long.toString(l2);
    if (l1 == 0L) {}
    for (paramForwardBody = str2;; paramForwardBody = str3)
    {
      if (((SubMsgType0x27.AppointmentNotify)localObject).str_tips_content.has()) {
        str1 = ((SubMsgType0x27.AppointmentNotify)localObject).str_tips_content.get();
      }
      localObject = new ArrayList();
      MessageRecord localMessageRecord = bbli.a(-1024);
      l2 = bbko.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "handle date push friendUin=" + str3 + ",senderUin=" + paramForwardBody + ",notifytype=" + l1);
      }
      localMessageRecord.init(str2, str3, paramForwardBody, str1, l2, -1024, 1010, l2);
      localMessageRecord.isread = false;
      if (l1 == 0L)
      {
        localMessageRecord.issend = 1;
        localMessageRecord.isread = true;
      }
      ((ArrayList)localObject).add(localMessageRecord);
      paramabxc.a().getMessageFacade().addMessage(localMessageRecord, localMessageRecord.selfuin);
      paramabxc.a("handleMsgType0x210SubMsgType0x27", true, (List)localObject, false, false);
      return;
      if ((l1 == 1L) && (((SubMsgType0x27.AppointmentNotify)localObject).bytes_sig.has()))
      {
        paramForwardBody = ((SubMsgType0x27.AppointmentNotify)localObject).bytes_sig.get().toByteArray();
        paramabxc.a().getMsgCache().l(str3, paramForwardBody);
      }
    }
  }
  
  private void g(abxc paramabxc, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    long l1 = 0L;
    int j;
    if (paramProfileInfo.length == 4)
    {
      j = ByteBuffer.wrap(new byte[] { paramProfileInfo[3] }).get();
      i = j;
      if (j == 1) {
        l1 = ByteBuffer.wrap(new byte[] { paramProfileInfo[2], paramProfileInfo[1] }).asShortBuffer().get() & 0xFFFF;
      }
    }
    for (int i = j;; i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get())
    {
      paramProfileInfo = axvd.a(i);
      AppRuntime.Status localStatus = paramabxc.a().getOnlineStatus();
      long l2 = axuy.a().a(paramabxc.a());
      if ((paramProfileInfo != localStatus) || (l2 != l1))
      {
        paramabxc.a().setOnlineStatus(paramProfileInfo);
        paramabxc.a().setExtOnlineStatus(l1);
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("onlineStatus", paramProfileInfo);
        localBundle.putLong("extOnlineStatus", l1);
        paramabxc.a().notifyObservers(AccountObserver.class, 2211, true, localBundle);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, String.format("online new status push code: %s, newStatus: %s, curStatus: %s, ext:%s", new Object[] { Integer.valueOf(i), paramProfileInfo, localStatus, Long.valueOf(l1) }));
      }
      if ((paramProfileInfo == AppRuntime.Status.online) && (l1 == 1000L) && ((localStatus != paramProfileInfo) || (l1 != l2)))
      {
        paramabxc.a().checkBatteryStatus();
        paramabxc.a().updateOnlineStatus(paramProfileInfo, l1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "udc reset battery status");
        }
      }
      return;
    }
  }
  
  private void h(abxc paramabxc, amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    boolean bool2 = false;
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    paramProfileInfo = paramamsw.b(paramLong + "");
    Friends localFriends = paramamsw.e(Long.toString(paramLong));
    if (paramProfileInfo != null) {
      if (i != 1) {
        break label190;
      }
    }
    label190:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramProfileInfo.namePlateOfKingDanDisplatSwitch = bool1;
      paramamsw.a(paramProfileInfo);
      paramabxc.a().getBusinessHandler(2).notifyUI(1, true, paramProfileInfo);
      if (localFriends != null)
      {
        bool1 = bool2;
        if (i == 1) {
          bool1 = true;
        }
        localFriends.namePlateOfKingDanDisplatSwitch = bool1;
        paramamsw.a(localFriends);
        paramabxc.a().getBusinessHandler(1).notifyUI(3, true, Long.toString(paramLong));
      }
      QLog.i("namePlateOfKing", 1, "handle push namePlateOfKingDanDisplatSwitch = " + i + ", uin = " + paramLong);
      return;
    }
  }
  
  private void h(abxc paramabxc, amsw paramamsw, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_del_group.has())
    {
      paramForwardBody = (SubMsgType0x27.DelGroup)paramForwardBody.msg_del_group.get();
      if (paramForwardBody.uint32_groupid.has())
      {
        Groups localGroups = paramamsw.a(paramForwardBody.uint32_groupid.get() + "");
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a DelGroup  = id:" + paramForwardBody.uint32_groupid.get());
        }
        paramamsw = new DelGroupResp();
        paramamsw.dwToUin = Long.valueOf(paramabxc.a().getAccount()).longValue();
        paramamsw.dwSequence = localGroups.seqid;
        paramamsw.cGroupid = ((byte)paramForwardBody.uint32_groupid.get());
        paramForwardBody = new GroupActionResp(0, "", paramamsw);
        ((FriendListHandler)paramabxc.a().getBusinessHandler(1)).handleDelGroupResp(paramamsw, true, paramForwardBody);
      }
    }
  }
  
  private void h(abxc paramabxc, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    paramabxc = (BubbleManager)paramabxc.a().getManager(44);
    if (paramabxc != null) {
      if (i != 0) {
        break label95;
      }
    }
    label95:
    for (boolean bool = true;; bool = false)
    {
      paramabxc.a(bool);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, String.format("bubble unread feature push %s", new Object[] { "" + i }));
      }
      return;
    }
  }
  
  private void i(abxc paramabxc, amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    paramProfileInfo = paramamsw.b(paramLong + "");
    Friends localFriends = paramamsw.e(Long.toString(paramLong));
    if (paramProfileInfo != null)
    {
      paramProfileInfo.namePlateOfKingDan = i;
      paramamsw.a(paramProfileInfo);
      paramabxc.a().getBusinessHandler(2).notifyUI(1, true, paramProfileInfo);
    }
    if (localFriends != null)
    {
      localFriends.namePlateOfKingDan = i;
      paramamsw.a(localFriends);
      paramabxc.a().getBusinessHandler(1).notifyUI(3, true, Long.toString(paramLong));
    }
    QLog.i("namePlateOfKing", 1, "handle push namePlateOfKingDan = " + i + ", uin = " + paramLong);
  }
  
  private void i(abxc paramabxc, amsw paramamsw, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_add_group.has())
    {
      SubMsgType0x27.AddGroup localAddGroup = (SubMsgType0x27.AddGroup)paramForwardBody.msg_add_group.get();
      paramForwardBody = new Groups();
      if (localAddGroup.uint32_groupid.has()) {
        paramForwardBody.group_id = localAddGroup.uint32_groupid.get();
      }
      if (localAddGroup.bytes_groupname.has()) {
        paramForwardBody.group_name = localAddGroup.bytes_groupname.get().toStringUtf8();
      }
      if (localAddGroup.uint32_sortid.has()) {
        paramForwardBody.seqid = ((byte)localAddGroup.uint32_sortid.get());
      }
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "push a AddGroup  = id:" + paramForwardBody.group_id + " name : " + paramForwardBody.group_name + " sortid: " + paramForwardBody.seqid);
      }
      paramamsw.a(paramForwardBody);
      paramamsw = new AddGroupResp();
      paramamsw.dwToUin = Long.valueOf(paramabxc.a().getAccount()).longValue();
      paramamsw.dwSequence = paramForwardBody.seqid;
      paramamsw.cGroupId = ((byte)paramForwardBody.group_id);
      paramamsw.cSortId = paramForwardBody.seqid;
      paramamsw = new GroupActionResp(0, "", paramamsw);
      paramabxc.a().getBusinessHandler(1).notifyUI(18, true, paramamsw);
    }
  }
  
  private void i(abxc paramabxc, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = 2;
    paramProfileInfo = paramProfileInfo.bytes_value.get();
    SharedPreferences localSharedPreferences;
    if ((paramProfileInfo.byteAt(5) & 0x2) != 0)
    {
      localSharedPreferences = paramabxc.a().getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
      if ((paramProfileInfo.byteAt(1) & 0x2) == 0) {
        break label114;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        localSharedPreferences.edit().putInt("message_roam_flag" + paramabxc.a().getCurrentAccountUin(), i).apply();
        paramabxc.a().getBusinessHandler(1).notifyUI(101, true, Integer.valueOf(i));
      }
      return;
      label114:
      if (localSharedPreferences.getInt("message_roam_flag" + paramabxc.a().getCurrentAccountUin(), -1) == 2) {
        i = 1;
      } else {
        i = -1;
      }
    }
  }
  
  private void j(abxc paramabxc, amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    long l = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    paramProfileInfo = paramamsw.b(paramLong + "");
    Friends localFriends = paramamsw.e(Long.toString(paramLong));
    if (paramProfileInfo != null)
    {
      paramProfileInfo.namePlateOfKingLoginTime = l;
      paramamsw.a(paramProfileInfo);
      paramabxc.a().getBusinessHandler(2).notifyUI(1, true, paramProfileInfo);
    }
    if (localFriends != null)
    {
      localFriends.namePlateOfKingLoginTime = l;
      paramamsw.a(localFriends);
      paramabxc.a().getBusinessHandler(1).notifyUI(3, true, Long.toString(paramLong));
    }
    QLog.i("namePlateOfKing", 1, "handle push gameLoginTime = " + l + ", uin = " + paramLong);
  }
  
  private void j(abxc paramabxc, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get(0);
    paramabxc.a(i);
    ((anaj)paramabxc.a().getBusinessHandler(13)).notifyUI(101, true, Integer.valueOf(i));
    if (QLog.isColorLevel()) {
      QLog.d("vip", 2, "bubble id = " + i);
    }
  }
  
  private void k(abxc paramabxc, amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    long l = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    paramProfileInfo = paramamsw.b(paramLong + "");
    Friends localFriends = paramamsw.e(Long.toString(paramLong));
    if (paramProfileInfo != null)
    {
      paramProfileInfo.namePlateOfKingGameId = l;
      paramamsw.a(paramProfileInfo);
      paramabxc.a().getBusinessHandler(2).notifyUI(1, true, paramProfileInfo);
    }
    if (localFriends != null)
    {
      localFriends.namePlateOfKingGameId = l;
      paramamsw.a(localFriends);
      paramabxc.a().getBusinessHandler(1).notifyUI(3, true, Long.toString(paramLong));
    }
    QLog.i("namePlateOfKing", 1, "handle push gameId = " + l + ", uin = " + paramLong);
  }
  
  private void k(abxc paramabxc, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int j = -1;
    int i;
    int k;
    if (paramProfileInfo.bytes_value.has())
    {
      paramProfileInfo = paramProfileInfo.bytes_value.get();
      i = paramProfileInfo.size();
      if (paramProfileInfo.size() > 0)
      {
        paramabxc = (amov)paramabxc.a().getBusinessHandler(2);
        if (paramabxc != null)
        {
          k = paramProfileInfo.byteAt(0);
          if (k != 101) {
            paramabxc.d(k);
          }
          j = i;
          i = k;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "20014 push a ProfileInfo size = " + j + "  settingValue = " + i);
      }
      return;
      k = -1;
      j = i;
      i = k;
      continue;
      i = -1;
    }
  }
  
  private void l(abxc paramabxc, amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    ExtensionInfo localExtensionInfo = paramamsw.a(String.valueOf(paramLong));
    paramProfileInfo = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramProfileInfo = new ExtensionInfo();
      paramProfileInfo.uin = String.valueOf(paramLong);
    }
    if (paramProfileInfo.colorRingId != i)
    {
      paramProfileInfo.colorRingId = i;
      paramProfileInfo.timestamp = System.currentTimeMillis();
      paramamsw.a(paramProfileInfo);
      bgdt.a(paramProfileInfo.uin, 1, paramabxc.a().getCurrentAccountUin());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get ColorRing, uin=" + paramLong + ", id=" + paramProfileInfo.colorRingId);
    }
  }
  
  private void m(abxc paramabxc, amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int j = 1;
    int k = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    ExtensionInfo localExtensionInfo = paramamsw.a(String.valueOf(paramLong));
    int i = 0;
    paramProfileInfo = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramProfileInfo = new ExtensionInfo();
      paramProfileInfo.uin = String.valueOf(paramLong);
      paramProfileInfo.fontEffect = -1;
      i = 1;
    }
    if (paramProfileInfo.fontEffect != k)
    {
      paramProfileInfo.fontEffect = k;
      paramProfileInfo.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
      ((gb)paramabxc.a().getManager(42)).e();
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        paramamsw.a(paramProfileInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "push Get fontEffect uin = " + paramLong + ", fontEffect = " + k + ", updateTime = " + paramProfileInfo.fontEffectLastUpdateTime);
      }
      return;
    }
  }
  
  private void n(abxc paramabxc, amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    ExtensionInfo localExtensionInfo = paramamsw.a(String.valueOf(paramLong));
    paramProfileInfo = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramProfileInfo = new ExtensionInfo();
      paramProfileInfo.uin = String.valueOf(paramLong);
      paramProfileInfo.magicFont = -1;
    }
    if (paramProfileInfo.magicFont != i)
    {
      paramProfileInfo.magicFont = i;
      paramProfileInfo.timestamp = System.currentTimeMillis();
      paramamsw.a(paramProfileInfo);
      bgae.a(paramabxc.a());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push Get MagicFont uin = " + paramLong + ", magicFont = " + i);
    }
  }
  
  private void o(abxc paramabxc, amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    long l = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asLongBuffer().get();
    ExtensionInfo localExtensionInfo = paramamsw.a(String.valueOf(paramLong));
    paramProfileInfo = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramProfileInfo = new ExtensionInfo();
      paramProfileInfo.uin = String.valueOf(paramLong);
    }
    paramProfileInfo.pendantId = l;
    paramProfileInfo.timestamp = System.currentTimeMillis();
    paramamsw.a(paramProfileInfo);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Pendant, uin=" + paramLong + ", id=" + paramProfileInfo.pendantId);
    }
    paramamsw = new HashSet(1);
    paramamsw.add(String.valueOf(paramLong));
    paramabxc.a().getBusinessHandler(1).notifyUI(66, true, paramamsw);
  }
  
  private void p(abxc paramabxc, amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("vip", 2, "svip update uin=" + paramLong);
    }
    paramProfileInfo = paramProfileInfo.bytes_value.get();
    String str = Long.toString(paramLong);
    Friends localFriends = paramamsw.e(str);
    boolean bool;
    int j;
    if (localFriends != null)
    {
      localFriends = (Friends)localFriends.clone();
      if ((paramProfileInfo.byteAt(5) & 0x20) == 0) {
        break label248;
      }
      bool = true;
      j = localFriends.superVipInfo;
      if (!bool) {
        break label254;
      }
    }
    label248:
    label254:
    for (int i = 1;; i = 0)
    {
      localFriends.superVipInfo = (i << 24 | 0xFFFFFF & j);
      paramamsw.a(localFriends);
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, "isSVip=" + bool + "friend.superVipInfo=" + localFriends.superVipInfo);
      }
      if (paramabxc.a().getCurrentAccountUin().equals(str))
      {
        paramabxc.a().getBusinessHandler(13).notifyUI(100, true, null);
        if (QLog.isColorLevel()) {
          QLog.d("vip", 2, "[EmoticonUpdateAuth] 23107 updateEmoticonAuth");
        }
        paramabxc = (amrg)paramabxc.a().getBusinessHandler(12);
        paramabxc.a(0, 0);
        paramabxc.a(0, 0, 1, 0);
      }
      return;
      bool = false;
      break;
    }
  }
  
  private void q(abxc paramabxc, amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("vip", 2, "vip update uin=" + paramLong);
    }
    paramProfileInfo = paramProfileInfo.bytes_value.get();
    String str = Long.toString(paramLong);
    Friends localFriends = paramamsw.e(str);
    boolean bool2;
    boolean bool3;
    boolean bool4;
    int n;
    byte b1;
    int k;
    int m;
    int j;
    if (localFriends != null)
    {
      localFriends = (Friends)localFriends.clone();
      boolean bool1 = localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
      bool2 = localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
      bool3 = localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ);
      bool4 = localFriends.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB);
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, "SVIP: " + bool1 + "; VIP: " + bool2 + "; SuperQQ: " + bool3);
      }
      n = 0;
      b1 = paramProfileInfo.byteAt(4);
      int i = paramProfileInfo.byteAt(5);
      if ((i & 0xF0) == 0) {
        break label381;
      }
      k = 16;
      m = 0;
      j = n;
      if (m < 4)
      {
        if ((i & k) == 0) {
          break label365;
        }
        j = 13 - m;
      }
      label228:
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, String.format("[%02X%02X] => LV %d", new Object[] { Byte.valueOf(b1), Byte.valueOf(i), Integer.valueOf(j) }));
      }
      if (!bool1) {
        break label443;
      }
      localFriends.superVipInfo = (localFriends.superVipInfo & 0xFFFF0000 | 0xFFFF & j);
    }
    for (;;)
    {
      if (bool4) {
        localFriends.bigClubInfo = (j & 0xFFFF | localFriends.bigClubInfo & 0xFFFF0000);
      }
      paramamsw.a(localFriends);
      if (paramabxc.a().getCurrentAccountUin().equals(str)) {
        paramabxc.a().getBusinessHandler(13).notifyUI(100, true, null);
      }
      return;
      label365:
      m += 1;
      byte b2 = (byte)(k << 1);
      break;
      label381:
      if (b1 != 0)
      {
        b2 = 1;
        m = 0;
        for (;;)
        {
          j = n;
          if (m >= 8) {
            break;
          }
          if ((b1 & b2) != 0)
          {
            j = 9 - m;
            break;
          }
          m += 1;
          b2 = (byte)(b2 << 1);
        }
      }
      j = 1;
      break label228;
      label443:
      if (bool2) {
        localFriends.qqVipInfo = (localFriends.qqVipInfo & 0xFFFF0000 | 0xFFFF & j);
      } else if (bool3) {
        localFriends.superQqInfo = (localFriends.superQqInfo & 0xFFFF0000 | 0xFFFF & j);
      }
    }
  }
  
  private void r(abxc paramabxc, amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("vip", 2, "vip update uin=" + paramLong);
    }
    paramProfileInfo = paramProfileInfo.bytes_value.get();
    Friends localFriends = paramamsw.e(Long.toString(paramLong));
    int i;
    label165:
    boolean bool;
    if (localFriends != null)
    {
      localFriends = (Friends)localFriends.clone();
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, String.format("bit info = %02X", new Object[] { Byte.valueOf(paramProfileInfo.byteAt(0)) }));
      }
      int j = localFriends.qqVipInfo;
      if ((paramProfileInfo.byteAt(0) & 0x80) != 0) {
        break label585;
      }
      i = 0;
      localFriends.qqVipInfo = (i << 24 | 0xFFFFFF & j);
      j = localFriends.superQqInfo;
      if ((paramProfileInfo.byteAt(0) & 0x8) != 0) {
        break label591;
      }
      i = 0;
      localFriends.superQqInfo = (i << 24 | 0xFFFFFF & j);
      if ((paramProfileInfo.byteAt(0) & 0x40) == 0) {
        break label597;
      }
      bool = true;
      label197:
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, "is year vip =" + bool);
      }
      if (!bool) {
        break label603;
      }
      i = 65536;
      label241:
      if (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        break label609;
      }
      localFriends.superVipInfo = (localFriends.superVipInfo & 0xFF00FFFF | i);
    }
    for (;;)
    {
      if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB)) {
        localFriends.bigClubInfo = (i | localFriends.bigClubInfo & 0xFF00FFFF);
      }
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, String.format("SVIP = %08X, VIP = %08X, SuperQQ = %08X", new Object[] { Integer.valueOf(localFriends.superVipInfo), Integer.valueOf(localFriends.qqVipInfo), Integer.valueOf(localFriends.superQqInfo) }));
      }
      paramamsw.a(localFriends);
      ((anaj)paramabxc.a().getBusinessHandler(13)).notifyUI(100, true, null);
      if (paramabxc.a().getCurrentAccountUin().equals(Long.toString(paramLong)))
      {
        paramamsw = new Intent("tencent.video.q2v.SVIP.PAY");
        paramamsw.putExtra("SVIPpaySuccess", true);
        paramamsw.setPackage(MobileQQ.getContext().getPackageName());
        paramabxc.a().getApp().sendBroadcast(paramamsw);
      }
      if (paramabxc.a().getCurrentAccountUin().equals(Long.toString(paramLong)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("vip", 2, "[EmoticonUpdateAuth] 23105 updateEmoticonAuth");
        }
        paramamsw = (amrg)paramabxc.a().getBusinessHandler(12);
        paramamsw.a(0, 0);
        paramamsw.a(0, 0, 1, 0);
        if (QLog.isColorLevel()) {
          QLog.d("QVipSettingMe.", 2, "[vipInfoPush] 23105 request vipInfoHandler");
        }
        bgov.a(paramabxc.a(), "last_pull_pay_rule", 0L);
        paramamsw = ((TicketManager)paramabxc.a().getManager(2)).getSkey(paramabxc.a().getCurrentAccountUin());
        ((aneg)paramabxc.a().getBusinessHandler(27)).a(paramamsw, paramLong + "");
      }
      return;
      label585:
      i = 1;
      break;
      label591:
      i = 1;
      break label165;
      label597:
      bool = false;
      break label197;
      label603:
      i = 0;
      break label241;
      label609:
      if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
        localFriends.qqVipInfo = (localFriends.qqVipInfo & 0xFF00FFFF | i);
      } else if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
        localFriends.superQqInfo = (localFriends.superQqInfo & 0xFF00FFFF | i);
      }
    }
  }
  
  private void s(abxc paramabxc, amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = 0;
    int j = paramProfileInfo.bytes_value.get().byteAt(0);
    if (j == 1) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "push a ModProfile Sex = " + i);
      }
      paramProfileInfo = paramamsw.b(paramLong + "");
      if (paramProfileInfo != null)
      {
        paramProfileInfo.shGender = ((short)i);
        paramamsw.a(paramProfileInfo);
        paramabxc.a().getBusinessHandler(2).notifyUI(1, true, paramProfileInfo);
      }
      return;
      if (j == 2) {
        i = 1;
      } else if (j == 0) {
        i = 2;
      } else {
        i = j;
      }
    }
  }
  
  private void t(abxc paramabxc, amsw paramamsw, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get();
    if ((paramProfileInfo != null) && (paramProfileInfo.size() == 2))
    {
      int i = paramProfileInfo.byteAt(0);
      i = (short)(paramProfileInfo.byteAt(1) | i << 8);
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "push a ModProfile Head = " + i);
      }
      ((FriendListHandler)paramabxc.a().getBusinessHandler(1)).getCustomHead(Long.toString(paramLong));
      paramProfileInfo = paramamsw.b(paramLong + "");
      if (paramProfileInfo != null)
      {
        paramProfileInfo.nFaceID = i;
        paramamsw.a(paramProfileInfo);
        paramabxc.a().getBusinessHandler(1).notifyUI(4, true, new Object[] { paramLong + "", paramProfileInfo, null });
        paramabxc.a().getBusinessHandler(2).notifyUI(1, true, paramProfileInfo);
      }
    }
  }
  
  public MessageRecord a(abxc paramabxc, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramabxc, paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acah
 * JD-Core Version:    0.7.0.1
 */