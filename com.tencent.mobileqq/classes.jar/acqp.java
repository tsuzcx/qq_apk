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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class acqp
  implements acpi
{
  private int a(acnk paramacnk, anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    ExtensionInfo localExtensionInfo = paramanvk.a(String.valueOf(paramLong));
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
      paramanvk.a(paramProfileInfo);
      bhiw.a(paramacnk.a());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Font, uin=" + paramLong + ", id=" + paramProfileInfo.uVipFont + ", type = " + paramProfileInfo.vipFontType);
    }
    return (int)gb.a(i);
  }
  
  private int a(acnk paramacnk, anvk paramanvk, Friends[] paramArrayOfFriends, int paramInt, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    String str = paramProfileInfo.bytes_value.get().toStringUtf8();
    if (QLog.isColorLevel()) {
      QLog.d("cardpush", 2, "push a ModProfile Nick = " + str);
    }
    Friends localFriends = paramanvk.e(Long.toString(paramLong));
    paramProfileInfo = null;
    if (localFriends != null) {
      paramProfileInfo = localFriends.name;
    }
    paramArrayOfFriends[paramInt] = paramanvk.a(paramLong + "", str);
    if ((localFriends != null) && (localFriends.isFriend()) && (aobu.a(str, paramProfileInfo))) {
      aobu.a(paramLong, str, (antp)paramacnk.a().getManager(QQManagerFactory.DISCUSSION_MANAGER));
    }
    paramArrayOfFriends = paramanvk.b(paramLong + "");
    if (paramArrayOfFriends != null)
    {
      paramArrayOfFriends.strNick = str;
      paramanvk.a(paramArrayOfFriends);
      paramacnk.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramArrayOfFriends);
    }
    paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(paramLong));
    TroopNameHelper.b(Long.toString(paramLong));
    return paramInt + 1;
  }
  
  private int a(acnk paramacnk, SubMsgType0x27.ForwardBody paramForwardBody, anvk paramanvk, amme paramamme, Friends[] paramArrayOfFriends, int paramInt)
  {
    Object localObject1 = (SubMsgType0x27.ModProfile)paramForwardBody.msg_mod_profile.get();
    if (((SubMsgType0x27.ModProfile)localObject1).uint64_uin.has())
    {
      long l = ((SubMsgType0x27.ModProfile)localObject1).uint64_uin.get();
      paramForwardBody = new baez(paramacnk.a());
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
          label644:
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
          m = a(paramacnk, paramanvk, paramArrayOfFriends, m, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          k(paramacnk, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          t(paramacnk, paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          s(paramacnk, paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          j(paramacnk, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          r(paramacnk, paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          q(paramacnk, paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          p(paramacnk, paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          i(paramacnk, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          d(paramacnk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          o(paramacnk, paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          k = a(paramacnk, paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          paramInt = j;
          j = k;
          continue;
          n(paramacnk, paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          m(paramacnk, paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          i = ByteBuffer.wrap(((SubMsgType0x27.ProfileInfo)localObject2).bytes_value.get().toByteArray()).asIntBuffer().get();
          k = i;
          if (i == 0) {
            break label644;
          }
          k = 1;
          j = paramInt;
          paramInt = k;
          continue;
          l(paramacnk, paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          c(paramamme, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          b(paramamme, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          d(paramacnk, paramamme, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          c(paramacnk, paramamme, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          c(paramacnk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          a(paramamme, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          b(paramacnk, paramamme, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          a(paramacnk, paramamme, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          k(paramacnk, paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          j(paramacnk, paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          i(paramacnk, paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          h(paramacnk, paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          localObject2 = ((TicketManager)paramacnk.a().getManager(2)).getSkey(l + "");
          ((aogw)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a((String)localObject2, l + "");
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          d(paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          c(paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          g(paramacnk, paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          f(paramacnk, paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          e(paramacnk, paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          d(paramacnk, paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          c(paramacnk, paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          b(paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          a(paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          b(paramacnk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          h(paramacnk, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          a(paramacnk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          b(paramacnk, paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          g(paramacnk, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          f(paramacnk, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          e(paramacnk, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          a((SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          d(paramacnk, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          c(paramacnk, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          b(paramacnk, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          a(paramacnk, paramanvk, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          a(paramacnk, (SubMsgType0x27.ProfileInfo)localObject2);
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
        paramanvk = paramanvk.a(String.valueOf(l));
        paramForwardBody = paramanvk;
        if (paramanvk == null)
        {
          paramForwardBody = new ExtensionInfo();
          paramForwardBody.uin = String.valueOf(l);
        }
        j = paramInt;
        if (paramInt == 0) {
          j = (int)paramForwardBody.uVipFont;
        }
        gb.a(paramacnk.a(), String.valueOf(l), paramForwardBody, j, i);
      }
      return m;
    }
    return paramInt;
  }
  
  private void a(acnk paramacnk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    boolean bool2 = true;
    byte[] arrayOfByte = paramProfileInfo.bytes_value.get().toByteArray();
    boolean bool1;
    short s;
    if (arrayOfByte.length == 1) {
      if (arrayOfByte[0] == 1)
      {
        bool1 = true;
        paramacnk = (awtq)paramacnk.a().getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER);
        s = (short)paramProfileInfo.uint32_field.get();
        if (bool1) {
          break label168;
        }
      }
    }
    for (;;)
    {
      paramacnk.a(s, false, "", bool2);
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
  
  private void a(acnk paramacnk, amme paramamme, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {}
    for (int i = paramProfileInfo[0];; i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get())
    {
      String str = String.valueOf(paramLong);
      paramProfileInfo = paramamme.b(str);
      QLog.d("Q.msg.BaseMessageProcessor", 1, new Object[] { "cmshow_online_push,  uin: ", ApolloUtil.d(str), ", cmshow3dFlag: ", Integer.valueOf(i), ", local=", Integer.valueOf(paramProfileInfo.cmshow3dFlag) });
      if (paramProfileInfo.cmshow3dFlag != i)
      {
        int j = paramProfileInfo.cmshow3dFlag;
        paramProfileInfo.cmshow3dFlag = i;
        paramamme.a(paramProfileInfo);
        if (paramacnk.a().getCurrentAccountUin().equals(String.valueOf(paramLong))) {
          paramamme.c(j, i);
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(str);
        paramacnk = anck.a(paramacnk.a());
        if (paramacnk != null) {
          paramacnk.a(3, localArrayList);
        }
      }
      if (((i & 0x1) == 1) && (paramProfileInfo.getApolloDress3D() == null)) {
        paramamme.a("" + paramLong, amme.b);
      }
      return;
    }
  }
  
  private void a(acnk paramacnk, anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    boolean bool2 = false;
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "handleModProfileBranch: invoked. c2c online push, field id: 42360, changed troopHonorSwitch", " troopHonorSwitch: ", Integer.valueOf(i) });
    }
    paramProfileInfo = paramanvk.b(paramLong + "");
    boolean bool3;
    if (paramProfileInfo != null)
    {
      bool3 = paramProfileInfo.troopHonorSwitch;
      if (i != 0) {
        break label184;
      }
    }
    label184:
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
      paramanvk.a(paramProfileInfo);
      paramacnk.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(113, true, Boolean.valueOf(paramProfileInfo.troopHonorSwitch));
      ((aoep)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).notifyUI(80, true, null);
      return;
    }
  }
  
  private void a(acnk paramacnk, anvk paramanvk, aoan paramaoan, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_del_friend.has())
    {
      Object localObject1 = ((SubMsgType0x27.DelFriend)paramForwardBody.msg_del_friend.get()).rpt_uint64_uins.get();
      paramForwardBody = (vzt)paramacnk.a().getManager(QQManagerFactory.QQ_STORY_FEED_MANAGER);
      localObject1 = ((List)localObject1).iterator();
      long l;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label434;
        }
        l = ((Long)((Iterator)localObject1).next()).longValue();
        paramanvk.d(l + "");
        paramaoan.b(l + "");
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a DelFriend  = id:" + l);
        }
        try
        {
          localObject2 = (bjxa)paramacnk.a().getManager(QQManagerFactory.QIDIAN_MANAGER);
          if ((localObject2 != null) && (((bjxa)localObject2).a(l + "")))
          {
            paramacnk.a().getProxyManager().a().a(String.valueOf(l), true);
            localObject2 = paramacnk.a().getApplication().getBaseContext().getSharedPreferences(paramacnk.a().getCurrentAccountUin() + "_customer_transfer_sharepreference", 0).edit();
            ((SharedPreferences.Editor)localObject2).putBoolean(paramacnk.a().getCurrentAccountUin() + "_" + l + "", false);
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
        paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(15, true, Long.valueOf(l));
        localObject2 = String.valueOf(l);
        paramForwardBody.a((String)localObject2);
        bbdk.a(paramacnk.a(), (String)localObject2);
        bejj.a(paramacnk.a(), (String)localObject2);
      }
      label434:
      paramacnk = (PhoneContactManagerImp)paramacnk.a().getManager(QQManagerFactory.CONTACT_MANAGER);
      if (paramacnk != null) {
        paramacnk.b();
      }
    }
  }
  
  private void a(acnk paramacnk, anvk paramanvk, TroopManager paramTroopManager, SubMsgType0x27.ForwardBody paramForwardBody)
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
                paramacnk.a().getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER).notifyUI(18, true, new Object[] { localObject4, Integer.valueOf(1), Integer.valueOf(0), null });
              }
            }
            else if (i >= 4)
            {
              localObject5 = ((SubMsgType0x27.SnsUpdateItem)localObject5).bytes_value.get().toByteArray();
              arrayOfByte = new byte[4];
              System.arraycopy(localObject5, 0, arrayOfByte, 0, 4);
              if (paramTroopManager.a((String)localObject4, anyv.a(arrayOfByte))) {
                paramacnk.a().getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER).notifyUI(18, true, new Object[] { localObject4, Integer.valueOf(0), Integer.valueOf(0), null });
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
                if (paramTroopManager.b((String)localObject4, anyv.a(arrayOfByte))) {
                  paramacnk.a().getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER).notifyUI(54, true, new Object[] { localObject4, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i) });
                }
              }
              if ((i == 0) && (paramTroopManager.e((String)localObject4))) {
                paramacnk.a().getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER).notifyUI(54, true, new Object[] { localObject4, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i) });
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
              if ((localObject5 != null) && (((SubMsgType0x27.SnsUpdateItem)localObject5).uint32_update_sns_type.has()) && (((SubMsgType0x27.SnsUpdateItem)localObject5).bytes_value.has()) && (!FriendsStatusUtil.a((SubMsgType0x27.SnsUpdateItem)localObject5, paramacnk.a(), (String)localObject3)))
              {
                if (((SubMsgType0x27.SnsUpdateItem)localObject5).uint32_update_sns_type.get() == 13568) {
                  amci.a((String)localObject3, ((SubMsgType0x27.SnsUpdateItem)localObject5).bytes_value.get().toStringUtf8(), paramacnk.a());
                }
                paramForwardBody = (SpecialCareInfo)((HashMap)localObject1).get(localObject3);
                paramTroopManager = paramForwardBody;
                if (paramForwardBody == null)
                {
                  paramForwardBody = paramanvk.a(String.valueOf(l));
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
        paramanvk.c(paramForwardBody);
        if (paramForwardBody.size() > 0) {
          paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(99, true, new Object[] { Boolean.valueOf(true), paramForwardBody });
        }
      }
    }
  }
  
  private void a(acnk paramacnk, anvk paramanvk, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_mod_rich_long_nick_ex.has())
    {
      SubMsgType0x27.ModLongNick localModLongNick = (SubMsgType0x27.ModLongNick)paramForwardBody.msg_mod_rich_long_nick_ex.get();
      String str = Long.toString(localModLongNick.uint64_uin.get());
      paramForwardBody = ByteBuffer.wrap(localModLongNick.bytes_value.get().toByteArray());
      long l = paramForwardBody.getLong();
      byte[] arrayOfByte = new byte[paramForwardBody.remaining()];
      paramForwardBody.get(arrayOfByte);
      ExtensionInfo localExtensionInfo = paramanvk.a(str);
      paramForwardBody = localExtensionInfo;
      if (localExtensionInfo == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = str;
      }
      paramForwardBody.setRichBuffer(arrayOfByte, l);
      paramForwardBody.isAdded2C2C = SignatureManager.a(paramacnk.a(), str, paramForwardBody.getRichStatus());
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "insertSignMsgIfNeeded from OnLinePush uin = " + str + " result =  " + paramForwardBody.isAdded2C2C);
      }
      paramanvk.a(paramForwardBody);
      paramForwardBody = paramanvk.b(localModLongNick.uint64_uin.get() + "");
      if (paramForwardBody != null)
      {
        paramForwardBody.vRichSign = arrayOfByte;
        paramForwardBody.lSignModifyTime = l;
        paramanvk.a(paramForwardBody);
      }
      paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, str);
      paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(2, true, new String[] { str });
    }
  }
  
  private void a(acnk paramacnk, TroopManager paramTroopManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_mod_group_member_profile.has())
    {
      Object localObject1 = (SubMsgType0x27.ModGroupMemberProfile)paramForwardBody.msg_mod_group_member_profile.get();
      if ((((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_code.has()) && (((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_uin.has()))
      {
        long l1 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_uin.get();
        long l2 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_code.get();
        long l3 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_uin.get();
        paramForwardBody = bhdf.a().a(paramacnk.a(), l2 + "", l3 + "");
        localObject1 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).rpt_msg_group_member_profile_infos.get().iterator();
        label1058:
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (SubMsgType0x27.GroupMemberProfileInfo)((Iterator)localObject1).next();
          if ((((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.has()) && (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.has()))
          {
            if (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.get() != 1) {
              break label487;
            }
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModGroupMemberProfile 1--Nick = " + ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toStringUtf8() + " info.bytes_value.get().size() = " + ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().size());
            }
            aobu.a("cardpush", ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toByteArray(), ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().size());
            if (paramForwardBody != null)
            {
              paramForwardBody.colorNick = bhmb.a(((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get());
              paramForwardBody.name = bhmb.b(paramForwardBody.colorNick);
              paramForwardBody.colorNickId = bhmb.a(((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toByteArray());
              paramTroopManager.a(l1 + "", l3 + "", paramForwardBody.colorNick, -100, null, null, -100, -100, -100, -100L, -100L, paramForwardBody.colorNickId);
            }
          }
          for (;;)
          {
            if (paramForwardBody == null) {
              break label1058;
            }
            bhdf.a().a(paramacnk.a(), paramForwardBody);
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(paramForwardBody);
            paramacnk.a().getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER).notifyUI(16, true, localObject2);
            paramacnk.a().getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER).notifyUI(11, true, new Object[] { localObject2, Boolean.valueOf(true) });
            break;
            label487:
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
              ((TroopManager)paramacnk.a().getManager(QQManagerFactory.TROOP_MANAGER)).a(l1 + "", l3 + "", null, -100, null, (String)localObject2, -100, -100, -100, -100L, -100L);
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
              paramForwardBody.colorNick = bhmb.a(((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get());
              paramForwardBody.name = bhmb.b(paramForwardBody.colorNick);
              paramForwardBody.colorNickId = bhmb.a(((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toByteArray());
            }
          }
        }
      }
    }
  }
  
  private void a(acnk paramacnk, SubMsgType0x27.ForwardBody paramForwardBody)
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
      ((abgm)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(39, localBundle);
    }
  }
  
  private void a(acnk paramacnk, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    ((avhp)paramacnk.a().getManager(QQManagerFactory.CUSTOMIZE_GRAY_TIPS)).a(i);
  }
  
  private void a(acnk paramacnk, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject1 = new SubMsgType0x27.MsgBody();
    Object localObject2;
    int i;
    for (;;)
    {
      aoan localaoan;
      amme localamme;
      SubMsgType0x27.ForwardBody localForwardBody;
      try
      {
        localObject2 = (SubMsgType0x27.MsgBody)((SubMsgType0x27.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (anvk)paramacnk.a().getManager(QQManagerFactory.FRIENDS_MANAGER);
        localObject1 = (TroopManager)paramacnk.a().getManager(QQManagerFactory.TROOP_MANAGER);
        localaoan = (aoan)paramacnk.a().getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
        localamme = (amme)paramacnk.a().getManager(QQManagerFactory.APOLLO_MANAGER);
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
          i(paramacnk, paramArrayOfByte, localForwardBody);
          break;
        case 1: 
          h(paramacnk, paramArrayOfByte, localForwardBody);
        }
      }
      catch (Exception paramacnk)
      {
        QLog.e("MsgType0x210SubMsgType0x27", 1, "handleMsgType0x210SubMsgType0x27 decode fail.", paramacnk);
        return;
      }
      continue;
      g(paramacnk, paramArrayOfByte, localForwardBody);
      continue;
      f(paramacnk, paramArrayOfByte, localForwardBody);
      continue;
      e(paramacnk, paramArrayOfByte, localForwardBody);
      continue;
      a(paramacnk, paramArrayOfByte, localaoan, localForwardBody);
      continue;
      a(paramacnk, paramArrayOfByte, (TroopManager)localObject1, localForwardBody);
      continue;
      d(paramacnk, paramArrayOfByte, localForwardBody);
      continue;
      if (localForwardBody.msg_mod_profile.has())
      {
        i = a(paramacnk, localForwardBody, paramArrayOfByte, localamme, (Friends[])localObject2, i);
        continue;
        c(paramacnk, (TroopManager)localObject1, localForwardBody);
        continue;
        c(paramacnk, paramArrayOfByte, localForwardBody);
        continue;
        b(paramacnk, paramArrayOfByte, localForwardBody);
        continue;
        a(paramacnk, paramArrayOfByte, localForwardBody);
        continue;
        b(paramacnk, (TroopManager)localObject1, localForwardBody);
        continue;
        a(paramacnk, (TroopManager)localObject1, localForwardBody);
        continue;
        g(paramacnk, localForwardBody);
        continue;
        f(paramacnk, localForwardBody);
        continue;
        b(paramacnk, localForwardBody);
        continue;
        a(paramacnk, localForwardBody);
        continue;
        e(paramacnk, localForwardBody);
        continue;
        d(paramacnk, localForwardBody);
        continue;
        c(paramacnk, localForwardBody);
        continue;
        b(localForwardBody);
        a(localForwardBody);
      }
    }
    paramArrayOfByte.a((Friends[])localObject2, i);
  }
  
  private void a(amme paramamme, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    long l1 = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    paramProfileInfo = paramamme.b(String.valueOf(paramLong));
    long l2 = NetConnInfoCenter.getServerTime();
    if ((l1 > l2) && (paramProfileInfo.apolloSignValidTS != l1))
    {
      paramProfileInfo.apolloLocalSignTs = paramProfileInfo.apolloSignValidTS;
      paramProfileInfo.apolloSignValidTS = l1;
      paramProfileInfo.apolloSignStr = "";
      paramamme.a(paramProfileInfo);
    }
    QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo push sign uin: " + paramLong + ", valid TS: " + l1 + ", currTS: " + l2);
  }
  
  private void a(anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    ExtensionInfo localExtensionInfo = paramanvk.a(String.valueOf(paramLong));
    paramProfileInfo = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramProfileInfo = new ExtensionInfo();
      paramProfileInfo.uin = String.valueOf(paramLong);
    }
    paramProfileInfo.pendantDiyId = i;
    paramProfileInfo.timestamp = System.currentTimeMillis();
    paramanvk.a(paramProfileInfo);
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
        bhmz.a(paramForwardBody);
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
    bhql.b(i);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, " theme font online push " + paramProfileInfo.uint32_field.get() + " id:" + i);
    }
  }
  
  private void b(acnk paramacnk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    ((bhou)paramacnk.a().getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.b(Long.toString(paramLong), i);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get faceId, uin=" + paramLong + ", id=" + i);
    }
  }
  
  private void b(acnk paramacnk, amme paramamme, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    if (paramamme != null)
    {
      paramProfileInfo = paramamme.b(paramacnk.a().getCurrentUin());
      if ((paramProfileInfo != null) && (i != paramProfileInfo.apolloAISwitch))
      {
        paramProfileInfo.apolloAISwitch = i;
        if ((paramacnk.a() != null) && (String.valueOf(paramLong).equals(paramacnk.a().getCurrentUin()))) {
          paramamme.a(i, 2);
        }
        paramamme.a(paramProfileInfo);
      }
    }
    QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo aiSwitch  push: " + i);
  }
  
  private void b(acnk paramacnk, anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {}
    for (int i = paramProfileInfo[0];; i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get())
    {
      paramProfileInfo = paramanvk.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.bigClubExtTemplateId = i;
        paramanvk.a(paramProfileInfo);
        paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(paramLong));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "vip_card_extension id by push=" + i);
      }
      return;
    }
  }
  
  private void b(acnk paramacnk, anvk paramanvk, SubMsgType0x27.ForwardBody paramForwardBody)
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
            Friends localFriends = paramanvk.e(Long.toString(l));
            paramForwardBody = null;
            if (localFriends != null) {
              paramForwardBody = localFriends.remark;
            }
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModFriendRemark  : 0 Friend uin = " + localFriendRemark.uint64_fuin.get() + "备注 = " + localFriendRemark.bytes_rmk_name.get().toStringUtf8() + ",oldRemark = " + paramForwardBody);
            }
            paramanvk.b(localFriendRemark.uint64_fuin.get() + "", localFriendRemark.bytes_rmk_name.get().toStringUtf8());
            Card localCard = paramanvk.b(localFriendRemark.uint64_fuin.get() + "");
            String str = localFriendRemark.bytes_rmk_name.get().toStringUtf8();
            if ((localCard != null) && (!str.equals(localCard.strReMark)))
            {
              localCard.strReMark = str;
              paramanvk.a(localCard);
            }
            if ((localFriends != null) && (localFriends.isFriend()) && (aobu.b(str, paramForwardBody))) {
              aobu.b(l, str, (antp)paramacnk.a().getManager(QQManagerFactory.DISCUSSION_MANAGER));
            }
            paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(localFriendRemark.uint64_fuin.get()));
            paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(27, true, new Object[] { localFriendRemark.uint64_fuin.get() + "", localFriendRemark.bytes_rmk_name.get().toStringUtf8(), Byte.valueOf(1) });
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
  
  private void b(acnk paramacnk, TroopManager paramTroopManager, SubMsgType0x27.ForwardBody paramForwardBody)
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
      catch (Exception paramacnk)
      {
        paramacnk.printStackTrace();
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
          ((FriendListHandler)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getTroopHead(l1 + "");
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
  
  private void b(acnk paramacnk, SubMsgType0x27.ForwardBody paramForwardBody)
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
      ((abgm)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(39, localBundle);
    }
  }
  
  private void b(acnk paramacnk, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "handleModProfileBranch: invoked. c2c online push, field id: 27370, changed global ring id", " ringId: ", Integer.valueOf(i) });
    }
    aqne.a(paramacnk.a()).b(i);
  }
  
  private void b(amme paramamme, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    paramProfileInfo = paramamme.b(String.valueOf(paramLong));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "apollo push uin: " + paramLong + ", avip level: " + i);
    }
    if (paramProfileInfo.apolloVipLevel != i)
    {
      paramProfileInfo.apolloVipLevel = i;
      paramamme.a(paramProfileInfo);
    }
  }
  
  private void b(anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {}
    for (int i = paramProfileInfo[0];; i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get())
    {
      paramProfileInfo = paramanvk.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.cNewLoverDiamondFlag = i;
        paramanvk.a(paramProfileInfo);
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
  
  private void c(acnk paramacnk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    if (paramLong == paramacnk.a().getLongAccountUin())
    {
      int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
      if (i != amme.a(paramacnk.a()))
      {
        paramProfileInfo = (amme)paramacnk.a().getManager(QQManagerFactory.APOLLO_MANAGER);
        paramProfileInfo.b(i);
        if (i == 1)
        {
          paramProfileInfo = paramProfileInfo.b(paramacnk.a().getCurrentUin());
          if ((paramProfileInfo.isApolloStatusOpen()) && (paramProfileInfo.apolloLocalTS != paramProfileInfo.apolloServerTS))
          {
            paramacnk = (VasExtensionHandler)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER);
            if (paramacnk != null) {
              paramacnk.a("whiteList");
            }
          }
        }
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo push white list: " + i);
    }
  }
  
  private void c(acnk paramacnk, amme paramamme, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    paramProfileInfo = String.valueOf(paramLong);
    if (TextUtils.isEmpty(paramProfileInfo)) {}
    do
    {
      return;
      ApolloBaseInfo localApolloBaseInfo = paramamme.b(paramProfileInfo);
      if (paramProfileInfo.equals(paramacnk.a().getCurrentUin())) {
        ((VasExtensionHandler)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a(new long[] { paramLong });
      }
      QLog.d("Q.msg.BaseMessageProcessor", 1, new Object[] { "apollo push uin: " + new StringBuilder().append(paramLong).append("temp").toString().substring(0, 4) + ", timeStamp: " + i, ", local server:", Long.valueOf(localApolloBaseInfo.apolloServerTS) });
      if (localApolloBaseInfo.apolloServerTS != i)
      {
        localApolloBaseInfo.apolloServerTS = i;
        paramamme.a(localApolloBaseInfo);
      }
      int j = 0;
      paramamme = paramacnk.a().getMessageFacade();
      i = j;
      if (paramamme != null)
      {
        i = j;
        if (paramamme.isChatting())
        {
          i = j;
          if (!TextUtils.isEmpty(paramamme.getCurrChatUin()))
          {
            i = j;
            if (paramamme.getCurrChatType() == 0)
            {
              i = j;
              if (paramamme.getCurrChatUin().equals(paramProfileInfo)) {
                i = 1;
              }
            }
          }
        }
      }
    } while (((!paramProfileInfo.equals(paramacnk.a().getCurrentUin())) || (amme.a(paramacnk.a()) != 2)) && (i == 0));
    paramacnk = (VasExtensionHandler)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER);
    paramamme = new ArrayList();
    paramamme.add(Long.valueOf(paramLong));
    paramacnk.a(paramamme, "online_push");
  }
  
  private void c(acnk paramacnk, anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = 0;
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {
      i = paramProfileInfo[0];
    }
    for (;;)
    {
      paramProfileInfo = paramanvk.b(paramLong + "");
      if ((paramProfileInfo != null) && (paramProfileInfo.mQQLevelType != i))
      {
        paramProfileInfo.mQQLevelType = i;
        paramanvk.a(paramProfileInfo);
        paramacnk.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
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
  
  private void c(acnk paramacnk, anvk paramanvk, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_daren_notify.has())
    {
      paramForwardBody = (SubMsgType0x27.DaRenNotify)paramForwardBody.msg_daren_notify.get();
      long l = paramForwardBody.uint64_uin.get();
      int i = paramForwardBody.uint32_login_days.get();
      int j = paramForwardBody.uint32_days.get();
      if (paramacnk.a().getCurrentAccountUin().equals(String.valueOf(l)))
      {
        paramForwardBody = paramanvk.c(paramacnk.a().getCurrentAccountUin());
        if ((i != paramForwardBody.lLoginDays) || (j != paramForwardBody.lQQMasterLogindays))
        {
          paramForwardBody.lLoginDays = i;
          paramForwardBody.lQQMasterLogindays = j;
          paramanvk.a(paramForwardBody);
          paramacnk.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramForwardBody);
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
  
  private void c(acnk paramacnk, TroopManager paramTroopManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    SubMsgType0x27.ModCustomFace localModCustomFace;
    if (paramForwardBody.msg_mod_custom_face.has())
    {
      localModCustomFace = (SubMsgType0x27.ModCustomFace)paramForwardBody.msg_mod_custom_face.get();
      if ((localModCustomFace.uint32_type.has()) && (localModCustomFace.uint64_uin.has()))
      {
        paramForwardBody = (FriendListHandler)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (localModCustomFace.uint32_type.get() != 0) {
          break label146;
        }
        l = localModCustomFace.uint64_uin.get();
        paramTroopManager = Long.toString(l);
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModCustomFace  :0  Normal user uin = " + l);
        }
        paramForwardBody.getCustomHead(paramTroopManager);
        paramForwardBody.sendBroadCastHeadChanged(1, paramTroopManager);
        paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, paramTroopManager);
      }
    }
    label146:
    while (localModCustomFace.uint32_type.get() != 1) {
      return;
    }
    long l = localModCustomFace.uint64_group_code.get();
    if (QLog.isColorLevel()) {
      QLog.d("cardpush", 2, "push a ModCustomFace  :1 Troop uin = " + l);
    }
    paramacnk = paramTroopManager.b(String.valueOf(l));
    paramacnk.hasSetNewTroopHead = true;
    paramTroopManager.b(paramacnk);
    paramForwardBody.getTroopHead(Long.toString(l));
  }
  
  private void c(acnk paramacnk, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    try
    {
      paramForwardBody = (SubMsgType0x27.MQQCampusNotify)paramForwardBody.msg_campus_notify.get();
      if (paramForwardBody != null) {
        ((aqnd)paramacnk.a().getManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER)).a(paramForwardBody);
      }
      return;
    }
    catch (Exception paramacnk)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.msg.BaseMessageProcessor", 2, "deal SubMsgType0x27.MQQCampusNotify fail", paramacnk);
    }
  }
  
  private void c(acnk paramacnk, SubMsgType0x27.ProfileInfo paramProfileInfo)
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
          paramProfileInfo = (ardl)aqxe.a().a(442);
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
        localObject = paramacnk.a().getApp().getSharedPreferences("check_update_sp_key", 0);
        paramProfileInfo = "businessinfo_ptt_auto_change_text_" + paramacnk.a().getCurrentAccountUin();
        str = "businessinfo_ptt_auto_change_time_" + paramacnk.a().getCurrentAccountUin();
        paramacnk = "businessinfo_ptt_auto_change_guide_has_show_" + paramacnk.a().getCurrentAccountUin();
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putBoolean(paramProfileInfo, bool2);
        l = NetConnInfoCenter.getServerTime();
        if (!bool2) {
          break label276;
        }
        ((SharedPreferences.Editor)localObject).putLong(str, l);
        ((SharedPreferences.Editor)localObject).putBoolean(paramacnk, true);
      }
      for (;;)
      {
        ((SharedPreferences.Editor)localObject).apply();
        ahdg.d = bool2;
        ahdg.a = l;
        return;
        bool1 = false;
        break;
        label276:
        ((SharedPreferences.Editor)localObject).putLong(str, 9223372036854775807L);
      }
    }
    QLog.e("vip_ptt.Q.msg.BaseMessageProcessor", 1, "it have receive push value is null");
    paramacnk = (anri)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    paramProfileInfo = new ArrayList();
    paramProfileInfo.add(Short.valueOf((short)-23249));
    paramacnk.a(paramProfileInfo, null);
  }
  
  private void c(amme paramamme, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    paramProfileInfo = paramamme.b(String.valueOf(paramLong));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "apollo push uin: " + paramLong + ", avip flag: " + i);
    }
    if (paramProfileInfo.apolloVipFlag != i)
    {
      paramProfileInfo.apolloVipFlag = i;
      paramamme.a(paramProfileInfo);
    }
  }
  
  private void c(anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    if ((paramProfileInfo.uint32_field.has()) && (paramProfileInfo.bytes_value.has()))
    {
      int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push 42354 = " + i);
      }
      paramProfileInfo = paramanvk.b(paramLong + "");
      Friends localFriends = paramanvk.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.grayNameplateFlag = i;
        paramanvk.a(paramProfileInfo);
      }
      if (localFriends != null)
      {
        localFriends.grayNameplateFlag = i;
        paramanvk.a(localFriends);
      }
    }
  }
  
  private void d(acnk paramacnk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = 3;
    paramProfileInfo = paramProfileInfo.bytes_value.get();
    SharedPreferences localSharedPreferences;
    if (((paramProfileInfo.byteAt(31) & 0x20) != 0) || ((paramProfileInfo.byteAt(34) & 0x10) != 0) || ((paramProfileInfo.byteAt(29) & 0x10) != 0))
    {
      localSharedPreferences = paramacnk.a().getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
      if (((paramProfileInfo.byteAt(11) & 0x20) == 0) && ((paramProfileInfo.byteAt(14) & 0x10) == 0)) {
        break label359;
      }
      i = 4;
      if (i != -1)
      {
        localSharedPreferences.edit().putInt("message_roam_flag" + paramacnk.a().getCurrentAccountUin(), i).apply();
        paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(101, true, Integer.valueOf(i));
      }
    }
    if ((paramProfileInfo.byteAt(12) & 0x8) != 0)
    {
      bool = true;
      label185:
      bdtt.a(paramacnk.a(), bool);
      if ((paramProfileInfo.byteAt(13) & 0x40) == 0) {
        break label438;
      }
    }
    label438:
    for (boolean bool = true;; bool = false)
    {
      if (SettingCloneUtil.readValue(paramacnk.a().getApplication(), Long.toString(paramLong), null, "qqsetting_pcactive_key", false) != bool)
      {
        SettingCloneUtil.writeValue(paramacnk.a().getApplication(), Long.valueOf(paramLong).toString(), null, "qqsetting_pcactive_key", bool);
        paramProfileInfo = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
        paramProfileInfo.putExtra("pcActive", bool);
        paramProfileInfo.putExtra("uin", Long.valueOf(paramLong).toString());
        paramacnk.a().getApp().sendBroadcast(paramProfileInfo);
        if (bool)
        {
          SettingCloneUtil.writeValue(paramacnk.a().getApplication(), Long.toString(paramLong), null, "pcactive_config", true);
          paramacnk.a().openMsfPCActive(Long.toString(paramLong), "config", true);
          QLog.d("OnlinePush", 1, "PCActive opened: true by switch push");
        }
      }
      return;
      label359:
      if ((paramProfileInfo.byteAt(9) & 0x10) != 0) {
        break;
      }
      i = localSharedPreferences.getInt("message_roam_flag" + paramacnk.a().getCurrentAccountUin(), -1);
      if ((i == 4) || (i == 3))
      {
        i = 1;
        break;
      }
      i = -1;
      break;
      bool = false;
      break label185;
    }
  }
  
  private void d(acnk paramacnk, amme paramamme, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    paramProfileInfo = paramamme.b(String.valueOf(paramLong));
    if ((QLog.isColorLevel()) || (paramLong == paramacnk.a().getLongAccountUin())) {
      QLog.d("Q.msg.BaseMessageProcessor", 1, "apollo push uin: " + paramLong + ", apollo status: " + i);
    }
    if (paramProfileInfo.apolloStatus != i)
    {
      paramProfileInfo.apolloStatus = i;
      paramamme.a(paramProfileInfo);
      if ((paramLong == paramacnk.a().getLongAccountUin()) && (paramProfileInfo.isApolloStatusOpen()) && (paramProfileInfo.apolloLocalTS != paramProfileInfo.apolloServerTS))
      {
        paramamme = (VasExtensionHandler)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER);
        if (paramamme != null) {
          paramamme.a("statusChange");
        }
      }
    }
    paramProfileInfo = String.valueOf(paramLong);
    if (paramLong == paramacnk.a().getLongAccountUin())
    {
      paramamme = new Pair(paramProfileInfo, Integer.valueOf(i));
      paramacnk.a().getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER).notifyUI(3, true, paramamme);
    }
    do
    {
      return;
      paramamme = new ArrayList();
      paramamme.add(paramProfileInfo);
      paramacnk = anck.a(paramacnk.a());
    } while (paramacnk == null);
    paramacnk.a(i, paramamme);
  }
  
  private void d(acnk paramacnk, anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {}
    for (int i = paramProfileInfo[0];; i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push the big club iVipType change = " + i);
      }
      paramProfileInfo = paramanvk.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.bigClubInfo = ((i & 0xFF) << 16 | paramProfileInfo.bigClubInfo & 0xFF00FFFF);
        paramanvk.a(paramProfileInfo);
        paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(paramLong));
      }
      paramanvk = ((TicketManager)paramacnk.a().getManager(2)).getSkey(paramLong + "");
      ((aogw)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a(paramanvk, paramLong + "");
      return;
    }
  }
  
  private void d(acnk paramacnk, anvk paramanvk, SubMsgType0x27.ForwardBody paramForwardBody)
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
            localObject = paramanvk.e(String.valueOf(l1));
            if (localObject != null)
            {
              if (i == 1) {}
              for (boolean bool = true;; bool = false)
              {
                ((Friends)localObject).setShieldFlag(bool);
                paramanvk.a((Friends)localObject);
                paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(56, true, new Object[] { Long.valueOf(l1), Boolean.valueOf(bool), Boolean.valueOf(true), Boolean.valueOf(true), "" });
                break;
              }
            }
          }
        }
      }
    }
  }
  
  private void d(acnk paramacnk, SubMsgType0x27.ForwardBody paramForwardBody)
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
        Bitmap localBitmap = bgyo.a(paramacnk.a().getApp().getResources(), 2130840422);
        ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramacnk.a().getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
        Intent localIntent = new Intent(paramacnk.a().getApp(), LikeRankingListActivity.class);
        localIntent.putExtra("param_from", 1);
        localIntent.addFlags(67108864);
        localToServiceMsg.extraData.putStringArray("cmds", new String[] { "QQ", "QQ", paramForwardBody });
        localToServiceMsg.extraData.putParcelable("intent", localIntent);
        localToServiceMsg.extraData.putParcelable("bitmap", localBitmap);
        paramacnk.a().sendToService(localToServiceMsg);
        paramacnk.a().reportClickEvent("dc00898", "0X8007618");
      }
      return;
    }
  }
  
  private void d(acnk paramacnk, SubMsgType0x27.ProfileInfo paramProfileInfo)
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
      aiin.a(paramacnk.a()).a(bool);
      paramacnk.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(104, true, Boolean.valueOf(bool));
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageProcessor", 2, "handleModProfileBranch emotionRec flag:" + bool);
      }
      return;
      if (ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get() == 0) {
        bool = true;
      }
    }
  }
  
  private void d(anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    if ((paramProfileInfo.uint32_field.has()) && (paramProfileInfo.bytes_value.has()))
    {
      int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push 42344 = " + i);
      }
      paramProfileInfo = paramanvk.b(paramLong + "");
      Friends localFriends = paramanvk.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.nameplateVipType = i;
        paramanvk.a(paramProfileInfo);
      }
      if (localFriends != null)
      {
        localFriends.nameplateVipType = i;
        paramanvk.a(localFriends);
      }
    }
  }
  
  private void e(acnk paramacnk, anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {}
    for (int i = paramProfileInfo[0];; i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get())
    {
      paramProfileInfo = paramanvk.b(paramLong + "");
      Friends localFriends = paramanvk.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.lBigClubTemplateId = i;
        paramProfileInfo.lSuperVipTemplateId = i;
        paramanvk.a(paramProfileInfo);
        paramacnk.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
      }
      if (localFriends != null)
      {
        localFriends.superVipTemplateId = i;
        localFriends.bigClubTemplateId = i;
        paramanvk.a(localFriends);
        paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(paramLong));
      }
      return;
    }
  }
  
  private void e(acnk paramacnk, anvk paramanvk, SubMsgType0x27.ForwardBody paramForwardBody)
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
              break label280;
            }
          }
        }
      }
    }
    label280:
    for (int i = ((Integer)localFriendGroup.rpt_uint32_old_group_id.get(0)).intValue();; i = 0)
    {
      paramanvk.a(l + "", j);
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "push a ModFriendGroup  = id:" + l + " newgroupid:" + j);
      }
      paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(9, true, new Object[] { l + "", Byte.valueOf((byte)j), Byte.valueOf((byte)i) });
      break;
      return;
    }
  }
  
  private void e(acnk paramacnk, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_new_comein_user_notify.has())
    {
      paramForwardBody = (SubMsgType0x27.NewComeinUserNotify)paramForwardBody.msg_new_comein_user_notify.get();
      if (!paramForwardBody.uint32_msg_type.has()) {
        break label135;
      }
    }
    label135:
    for (int i = paramForwardBody.uint32_msg_type.get();; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "receive msg0x210submsg0x27 face2face add friend push, type:" + i);
      }
      if (i == 1)
      {
        paramacnk = (anxi)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER);
        if (paramacnk != null) {
          paramacnk.a(paramForwardBody);
        }
      }
      do
      {
        do
        {
          return;
        } while ((i != 2) && (i != 3));
        paramacnk = (anzl)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.NEARFIELD_TROOP_HANDLER);
      } while (paramacnk == null);
      paramacnk.a(i, paramForwardBody);
      return;
    }
  }
  
  private void e(acnk paramacnk, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    paramacnk = (ChatBackgroundManager)paramacnk.a().getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
    if (paramacnk != null) {
      paramacnk.a(i, 0, null, "onlinePush", -1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, " bg online push " + paramProfileInfo.uint32_field.get() + " bgId:" + i);
    }
  }
  
  private void f(acnk paramacnk, anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {}
    for (int i = paramProfileInfo[0];; i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get())
    {
      paramProfileInfo = paramanvk.b(paramLong + "");
      Friends localFriends = paramanvk.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.iBigClubVipType = i;
        paramanvk.a(paramProfileInfo);
        paramacnk.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
      }
      if (localFriends != null)
      {
        localFriends.bigClubInfo = (localFriends.bigClubInfo & 0xFFFFFF | (i & 0xFF) << 24);
        paramanvk.a(localFriends);
        paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(paramLong));
      }
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push the big club type change=" + i);
      }
      paramanvk = ((TicketManager)paramacnk.a().getManager(2)).getSkey(paramLong + "");
      ((aogw)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a(paramanvk, paramLong + "");
      return;
    }
  }
  
  private void f(acnk paramacnk, anvk paramanvk, SubMsgType0x27.ForwardBody paramForwardBody)
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
            break label227;
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
    label227:
    for (;;)
    {
      break;
      paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(22, true, null);
      paramanvk.a(paramForwardBody, arrayOfByte);
      return;
    }
  }
  
  private void f(acnk paramacnk, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.bytes_redpoint_info.has()) {
      ((aymd)paramacnk.a().getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).a(paramForwardBody.bytes_redpoint_info.get().toByteArray());
    }
  }
  
  private void f(acnk paramacnk, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    boolean bool = ThemeUtil.isNowThemeIsSimple(paramacnk.a(), false, null);
    if ((!bool) && (behh.a(String.valueOf(i)))) {
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
      beio.a(paramacnk.a(), String.valueOf(i), "20000000");
    }
  }
  
  private void g(acnk paramacnk, anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {}
    for (int i = paramProfileInfo[0];; i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push the big club level change=" + i);
      }
      paramProfileInfo = paramanvk.b(paramLong + "");
      Friends localFriends = paramanvk.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.iBigClubVipLevel = i;
        paramanvk.a(paramProfileInfo);
        paramacnk.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
      }
      if (localFriends != null)
      {
        localFriends.bigClubInfo = (i & 0xFFFF | localFriends.bigClubInfo & 0xFFFF0000);
        paramanvk.a(localFriends);
        paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(paramLong));
      }
      paramanvk = ((TicketManager)paramacnk.a().getManager(2)).getSkey(paramLong + "");
      ((aogw)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a(paramanvk, paramLong + "");
      return;
    }
  }
  
  private void g(acnk paramacnk, anvk paramanvk, SubMsgType0x27.ForwardBody paramForwardBody)
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
        paramForwardBody = paramanvk.a(String.valueOf(i));
        if (paramForwardBody == null) {
          break label217;
        }
      }
    }
    for (paramForwardBody.group_name = str;; paramForwardBody.group_name = str)
    {
      paramanvk.a(paramForwardBody);
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "push a ModGroupName  = id:" + localModGroupName.uint32_groupid.get() + " name:" + localModGroupName.bytes_groupname.get().toStringUtf8());
      }
      paramanvk = new RenameGroupResp();
      paramanvk.dwToUin = localModGroupName.uint32_groupid.get();
      paramanvk.sGroupName = localModGroupName.bytes_groupname.get().toStringUtf8();
      paramanvk = new GroupActionResp(0, "", paramanvk);
      paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(19, true, paramanvk);
      return;
      label217:
      paramForwardBody = new Groups();
      paramForwardBody.group_id = i;
    }
  }
  
  private void g(acnk paramacnk, SubMsgType0x27.ForwardBody paramForwardBody)
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
        paramacnk.a().getNearbyProxy().a((SubMsgType0x27.AppointmentNotify)localObject);
      }
    }
    label99:
    while (((l1 != 0L) && (l1 != 1L) && (l1 != 3L)) || (!((SubMsgType0x27.AppointmentNotify)localObject).uint64_from_uin.has())) {
      return;
    }
    long l2 = ((SubMsgType0x27.AppointmentNotify)localObject).uint64_from_uin.get();
    String str1 = null;
    String str2 = paramacnk.a().getCurrentAccountUin();
    String str3 = Long.toString(l2);
    if (l1 == 0L) {}
    for (paramForwardBody = str2;; paramForwardBody = str3)
    {
      if (((SubMsgType0x27.AppointmentNotify)localObject).str_tips_content.has()) {
        str1 = ((SubMsgType0x27.AppointmentNotify)localObject).str_tips_content.get();
      }
      localObject = new ArrayList();
      MessageRecord localMessageRecord = bcsa.a(-1024);
      l2 = bcrg.a();
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
      paramacnk.a().getMessageFacade().addMessage(localMessageRecord, localMessageRecord.selfuin);
      paramacnk.a("handleMsgType0x210SubMsgType0x27", true, (List)localObject, false, false);
      return;
      if ((l1 == 1L) && (((SubMsgType0x27.AppointmentNotify)localObject).bytes_sig.has()))
      {
        paramForwardBody = ((SubMsgType0x27.AppointmentNotify)localObject).bytes_sig.get().toByteArray();
        paramacnk.a().getMsgCache().l(str3, paramForwardBody);
      }
    }
  }
  
  private void g(acnk paramacnk, SubMsgType0x27.ProfileInfo paramProfileInfo)
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
      paramProfileInfo = azbo.a(i);
      AppRuntime.Status localStatus = paramacnk.a().getOnlineStatus();
      long l2 = azbj.a().a(paramacnk.a());
      if ((paramProfileInfo != localStatus) || (l2 != l1))
      {
        paramacnk.a().setOnlineStatus(paramProfileInfo);
        paramacnk.a().setExtOnlineStatus(l1);
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("onlineStatus", paramProfileInfo);
        localBundle.putLong("extOnlineStatus", l1);
        paramacnk.a().notifyObservers(AccountObserver.class, 2211, true, localBundle);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, String.format("online new status push code: %s, newStatus: %s, curStatus: %s, ext:%s", new Object[] { Integer.valueOf(i), paramProfileInfo, localStatus, Long.valueOf(l1) }));
      }
      if ((paramProfileInfo == AppRuntime.Status.online) && (l1 == 1000L) && ((localStatus != paramProfileInfo) || (l1 != l2)))
      {
        paramacnk.a().checkBatteryStatus();
        paramacnk.a().updateOnlineStatus(paramProfileInfo, l1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "udc reset battery status");
        }
      }
      return;
    }
  }
  
  private void h(acnk paramacnk, anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    boolean bool2 = false;
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    paramProfileInfo = paramanvk.b(paramLong + "");
    Friends localFriends = paramanvk.e(Long.toString(paramLong));
    if (paramProfileInfo != null) {
      if (i != 1) {
        break label194;
      }
    }
    label194:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramProfileInfo.namePlateOfKingDanDisplatSwitch = bool1;
      paramanvk.a(paramProfileInfo);
      paramacnk.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
      if (localFriends != null)
      {
        bool1 = bool2;
        if (i == 1) {
          bool1 = true;
        }
        localFriends.namePlateOfKingDanDisplatSwitch = bool1;
        paramanvk.a(localFriends);
        paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(paramLong));
      }
      QLog.i("namePlateOfKing", 1, "handle push namePlateOfKingDanDisplatSwitch = " + i + ", uin = " + paramLong);
      return;
    }
  }
  
  private void h(acnk paramacnk, anvk paramanvk, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_del_group.has())
    {
      paramForwardBody = (SubMsgType0x27.DelGroup)paramForwardBody.msg_del_group.get();
      if (paramForwardBody.uint32_groupid.has())
      {
        Groups localGroups = paramanvk.a(paramForwardBody.uint32_groupid.get() + "");
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a DelGroup  = id:" + paramForwardBody.uint32_groupid.get());
        }
        paramanvk = new DelGroupResp();
        paramanvk.dwToUin = Long.valueOf(paramacnk.a().getAccount()).longValue();
        paramanvk.dwSequence = localGroups.seqid;
        paramanvk.cGroupid = ((byte)paramForwardBody.uint32_groupid.get());
        paramForwardBody = new GroupActionResp(0, "", paramanvk);
        ((FriendListHandler)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).handleDelGroupResp(paramanvk, true, paramForwardBody);
      }
    }
  }
  
  private void h(acnk paramacnk, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    paramacnk = (BubbleManager)paramacnk.a().getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    if (paramacnk != null) {
      if (i != 0) {
        break label96;
      }
    }
    label96:
    for (boolean bool = true;; bool = false)
    {
      paramacnk.a(bool);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, String.format("bubble unread feature push %s", new Object[] { "" + i }));
      }
      return;
    }
  }
  
  private void i(acnk paramacnk, anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    paramProfileInfo = paramanvk.b(paramLong + "");
    Friends localFriends = paramanvk.e(Long.toString(paramLong));
    if (paramProfileInfo != null)
    {
      paramProfileInfo.namePlateOfKingDan = i;
      paramanvk.a(paramProfileInfo);
      paramacnk.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
    }
    if (localFriends != null)
    {
      localFriends.namePlateOfKingDan = i;
      paramanvk.a(localFriends);
      paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(paramLong));
    }
    QLog.i("namePlateOfKing", 1, "handle push namePlateOfKingDan = " + i + ", uin = " + paramLong);
  }
  
  private void i(acnk paramacnk, anvk paramanvk, SubMsgType0x27.ForwardBody paramForwardBody)
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
      paramanvk.a(paramForwardBody);
      paramanvk = new AddGroupResp();
      paramanvk.dwToUin = Long.valueOf(paramacnk.a().getAccount()).longValue();
      paramanvk.dwSequence = paramForwardBody.seqid;
      paramanvk.cGroupId = ((byte)paramForwardBody.group_id);
      paramanvk.cSortId = paramForwardBody.seqid;
      paramanvk = new GroupActionResp(0, "", paramanvk);
      paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(18, true, paramanvk);
    }
  }
  
  private void i(acnk paramacnk, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = 2;
    paramProfileInfo = paramProfileInfo.bytes_value.get();
    SharedPreferences localSharedPreferences;
    if ((paramProfileInfo.byteAt(5) & 0x2) != 0)
    {
      localSharedPreferences = paramacnk.a().getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
      if ((paramProfileInfo.byteAt(1) & 0x2) == 0) {
        break label116;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        localSharedPreferences.edit().putInt("message_roam_flag" + paramacnk.a().getCurrentAccountUin(), i).apply();
        paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(101, true, Integer.valueOf(i));
      }
      return;
      label116:
      if (localSharedPreferences.getInt("message_roam_flag" + paramacnk.a().getCurrentAccountUin(), -1) == 2) {
        i = 1;
      } else {
        i = -1;
      }
    }
  }
  
  private void j(acnk paramacnk, anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    long l = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    paramProfileInfo = paramanvk.b(paramLong + "");
    Friends localFriends = paramanvk.e(Long.toString(paramLong));
    if (paramProfileInfo != null)
    {
      paramProfileInfo.namePlateOfKingLoginTime = l;
      paramanvk.a(paramProfileInfo);
      paramacnk.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
    }
    if (localFriends != null)
    {
      localFriends.namePlateOfKingLoginTime = l;
      paramanvk.a(localFriends);
      paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(paramLong));
    }
    QLog.i("namePlateOfKing", 1, "handle push gameLoginTime = " + l + ", uin = " + paramLong);
  }
  
  private void j(acnk paramacnk, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get(0);
    paramacnk.a(i);
    ((aocy)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).notifyUI(101, true, Integer.valueOf(i));
    if (QLog.isColorLevel()) {
      QLog.d("vip", 2, "bubble id = " + i);
    }
  }
  
  private void k(acnk paramacnk, anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    long l = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    paramProfileInfo = paramanvk.b(paramLong + "");
    Friends localFriends = paramanvk.e(Long.toString(paramLong));
    if (paramProfileInfo != null)
    {
      paramProfileInfo.namePlateOfKingGameId = l;
      paramanvk.a(paramProfileInfo);
      paramacnk.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
    }
    if (localFriends != null)
    {
      localFriends.namePlateOfKingGameId = l;
      paramanvk.a(localFriends);
      paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(paramLong));
    }
    QLog.i("namePlateOfKing", 1, "handle push gameId = " + l + ", uin = " + paramLong);
  }
  
  private void k(acnk paramacnk, SubMsgType0x27.ProfileInfo paramProfileInfo)
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
        paramacnk = (anri)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        if (paramacnk != null)
        {
          k = paramProfileInfo.byteAt(0);
          if (k != 101) {
            paramacnk.d(k);
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
  
  private void l(acnk paramacnk, anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    ExtensionInfo localExtensionInfo = paramanvk.a(String.valueOf(paramLong));
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
      paramanvk.a(paramProfileInfo);
      bhml.a(paramProfileInfo.uin, 1, paramacnk.a().getCurrentAccountUin());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get ColorRing, uin=" + paramLong + ", id=" + paramProfileInfo.colorRingId);
    }
  }
  
  private void m(acnk paramacnk, anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int j = 1;
    int k = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    ExtensionInfo localExtensionInfo = paramanvk.a(String.valueOf(paramLong));
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
      ((gb)paramacnk.a().getManager(QQManagerFactory.CHAT_FONT_MANAGER)).e();
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        paramanvk.a(paramProfileInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "push Get fontEffect uin = " + paramLong + ", fontEffect = " + k + ", updateTime = " + paramProfileInfo.fontEffectLastUpdateTime);
      }
      return;
    }
  }
  
  private void n(acnk paramacnk, anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    ExtensionInfo localExtensionInfo = paramanvk.a(String.valueOf(paramLong));
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
      paramanvk.a(paramProfileInfo);
      bhiw.a(paramacnk.a());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push Get MagicFont uin = " + paramLong + ", magicFont = " + i);
    }
  }
  
  private void o(acnk paramacnk, anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    long l = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asLongBuffer().get();
    ExtensionInfo localExtensionInfo = paramanvk.a(String.valueOf(paramLong));
    paramProfileInfo = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramProfileInfo = new ExtensionInfo();
      paramProfileInfo.uin = String.valueOf(paramLong);
    }
    paramProfileInfo.pendantId = l;
    paramProfileInfo.timestamp = System.currentTimeMillis();
    paramanvk.a(paramProfileInfo);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Pendant, uin=" + paramLong + ", id=" + paramProfileInfo.pendantId);
    }
    paramanvk = new HashSet(1);
    paramanvk.add(String.valueOf(paramLong));
    paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(66, true, paramanvk);
  }
  
  private void p(acnk paramacnk, anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("vip", 2, "svip update uin=" + paramLong);
    }
    paramProfileInfo = paramProfileInfo.bytes_value.get();
    String str = Long.toString(paramLong);
    Friends localFriends = paramanvk.e(str);
    boolean bool;
    int j;
    if (localFriends != null)
    {
      localFriends = (Friends)localFriends.clone();
      if ((paramProfileInfo.byteAt(5) & 0x20) == 0) {
        break label250;
      }
      bool = true;
      j = localFriends.superVipInfo;
      if (!bool) {
        break label256;
      }
    }
    label256:
    for (int i = 1;; i = 0)
    {
      localFriends.superVipInfo = (i << 24 | 0xFFFFFF & j);
      paramanvk.a(localFriends);
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, "isSVip=" + bool + "friend.superVipInfo=" + localFriends.superVipInfo);
      }
      if (paramacnk.a().getCurrentAccountUin().equals(str))
      {
        paramacnk.a().getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER).notifyUI(100, true, null);
        if (QLog.isColorLevel()) {
          QLog.d("vip", 2, "[EmoticonUpdateAuth] 23107 updateEmoticonAuth");
        }
        paramacnk = (antu)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM);
        paramacnk.a(0, 0);
        paramacnk.a(0, 0, 1, 0);
      }
      return;
      label250:
      bool = false;
      break;
    }
  }
  
  private void q(acnk paramacnk, anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("vip", 2, "vip update uin=" + paramLong);
    }
    paramProfileInfo = paramProfileInfo.bytes_value.get();
    String str = Long.toString(paramLong);
    Friends localFriends = paramanvk.e(str);
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
        break label382;
      }
      k = 16;
      m = 0;
      j = n;
      if (m < 4)
      {
        if ((i & k) == 0) {
          break label366;
        }
        j = 13 - m;
      }
      label228:
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, String.format("[%02X%02X] => LV %d", new Object[] { Byte.valueOf(b1), Byte.valueOf(i), Integer.valueOf(j) }));
      }
      if (!bool1) {
        break label444;
      }
      localFriends.superVipInfo = (localFriends.superVipInfo & 0xFFFF0000 | 0xFFFF & j);
    }
    for (;;)
    {
      if (bool4) {
        localFriends.bigClubInfo = (j & 0xFFFF | localFriends.bigClubInfo & 0xFFFF0000);
      }
      paramanvk.a(localFriends);
      if (paramacnk.a().getCurrentAccountUin().equals(str)) {
        paramacnk.a().getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER).notifyUI(100, true, null);
      }
      return;
      label366:
      m += 1;
      byte b2 = (byte)(k << 1);
      break;
      label382:
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
      label444:
      if (bool2) {
        localFriends.qqVipInfo = (localFriends.qqVipInfo & 0xFFFF0000 | 0xFFFF & j);
      } else if (bool3) {
        localFriends.superQqInfo = (localFriends.superQqInfo & 0xFFFF0000 | 0xFFFF & j);
      }
    }
  }
  
  private void r(acnk paramacnk, anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("vip", 2, "vip update uin=" + paramLong);
    }
    paramProfileInfo = paramProfileInfo.bytes_value.get();
    Friends localFriends = paramanvk.e(Long.toString(paramLong));
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
        break label588;
      }
      i = 0;
      localFriends.qqVipInfo = (i << 24 | 0xFFFFFF & j);
      j = localFriends.superQqInfo;
      if ((paramProfileInfo.byteAt(0) & 0x8) != 0) {
        break label594;
      }
      i = 0;
      localFriends.superQqInfo = (i << 24 | 0xFFFFFF & j);
      if ((paramProfileInfo.byteAt(0) & 0x40) == 0) {
        break label600;
      }
      bool = true;
      label197:
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, "is year vip =" + bool);
      }
      if (!bool) {
        break label606;
      }
      i = 65536;
      label241:
      if (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        break label612;
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
      paramanvk.a(localFriends);
      ((aocy)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).notifyUI(100, true, null);
      if (paramacnk.a().getCurrentAccountUin().equals(Long.toString(paramLong)))
      {
        paramanvk = new Intent("tencent.video.q2v.SVIP.PAY");
        paramanvk.putExtra("SVIPpaySuccess", true);
        paramanvk.setPackage(MobileQQ.getContext().getPackageName());
        paramacnk.a().getApp().sendBroadcast(paramanvk);
      }
      if (paramacnk.a().getCurrentAccountUin().equals(Long.toString(paramLong)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("vip", 2, "[EmoticonUpdateAuth] 23105 updateEmoticonAuth");
        }
        paramanvk = (antu)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM);
        paramanvk.a(0, 0);
        paramanvk.a(0, 0, 1, 0);
        if (QLog.isColorLevel()) {
          QLog.d("QVipSettingMe.", 2, "[vipInfoPush] 23105 request vipInfoHandler");
        }
        bhzf.a(paramacnk.a(), "last_pull_pay_rule", 0L);
        paramanvk = ((TicketManager)paramacnk.a().getManager(2)).getSkey(paramacnk.a().getCurrentAccountUin());
        ((aogw)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a(paramanvk, paramLong + "");
      }
      return;
      label588:
      i = 1;
      break;
      label594:
      i = 1;
      break label165;
      label600:
      bool = false;
      break label197;
      label606:
      i = 0;
      break label241;
      label612:
      if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
        localFriends.qqVipInfo = (localFriends.qqVipInfo & 0xFF00FFFF | i);
      } else if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
        localFriends.superQqInfo = (localFriends.superQqInfo & 0xFF00FFFF | i);
      }
    }
  }
  
  private void s(acnk paramacnk, anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = 0;
    int j = paramProfileInfo.bytes_value.get().byteAt(0);
    if (j == 1) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "push a ModProfile Sex = " + i);
      }
      paramProfileInfo = paramanvk.b(paramLong + "");
      if (paramProfileInfo != null)
      {
        paramProfileInfo.shGender = ((short)i);
        paramanvk.a(paramProfileInfo);
        paramacnk.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
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
  
  private void t(acnk paramacnk, anvk paramanvk, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get();
    if ((paramProfileInfo != null) && (paramProfileInfo.size() == 2))
    {
      int i = paramProfileInfo.byteAt(0);
      i = (short)(paramProfileInfo.byteAt(1) | i << 8);
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "push a ModProfile Head = " + i);
      }
      ((FriendListHandler)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getCustomHead(Long.toString(paramLong));
      paramProfileInfo = paramanvk.b(paramLong + "");
      if (paramProfileInfo != null)
      {
        paramProfileInfo.nFaceID = i;
        paramanvk.a(paramProfileInfo);
        paramacnk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(4, true, new Object[] { paramLong + "", paramProfileInfo, null });
        paramacnk.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
      }
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk, paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqp
 * JD-Core Version:    0.7.0.1
 */