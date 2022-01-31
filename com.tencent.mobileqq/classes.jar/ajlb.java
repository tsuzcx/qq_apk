import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyLockScreenJumpDelegate;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil.1;
import com.tencent.mobileqq.activity.recent.RecentUtil.2;
import com.tencent.mobileqq.activity.recent.RecentUtil.3;
import com.tencent.mobileqq.activity.recent.RecentUtil.4;
import com.tencent.mobileqq.activity.recent.RecentUtil.5;
import com.tencent.mobileqq.activity.recent.RecentUtil.6;
import com.tencent.mobileqq.activity.recent.RecentUtil.7;
import com.tencent.mobileqq.activity.recent.data.RecentItemNoticeData;
import com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.confess.ConfessMsgListFragment;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper;
import com.tencent.mobileqq.mini.report.MiniAppBusiReport;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.thread.SuspendThreadManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.contentbox.QZoneMsgActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public final class ajlb
{
  public static long a;
  public static MessageRecord a;
  public static boolean a;
  public static boolean b;
  public static boolean c = true;
  
  public static int a(Activity paramActivity, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, String paramString, boolean paramBoolean, int paramInt, RecentBaseData paramRecentBaseData)
  {
    return a(paramActivity, paramQQAppInterface, paramRecentUser, paramString, paramBoolean, paramInt, paramRecentBaseData, null, null);
  }
  
  public static int a(Activity paramActivity, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, String paramString, boolean paramBoolean, int paramInt, RecentBaseData paramRecentBaseData, Bundle paramBundle, Intent[] paramArrayOfIntent)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    if ((paramRecentUser == null) || (paramActivity == null) || (paramQQAppInterface == null))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "onRecentUserClick|[" + paramRecentUser + "," + paramActivity + "," + paramQQAppInterface + "]");
      }
      i = 0;
      return i;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onRecentUserClick|[" + paramRecentUser.uin + "," + paramRecentUser.getType() + "]");
    }
    boolean bool1;
    if ((paramInt == 0) || (paramInt == 2))
    {
      bool1 = true;
      label146:
      if ((paramRecentBaseData != null) && (paramInt == 0) && (paramRecentUser.uin != null) && ((paramRecentUser.getType() == 1008) || (paramRecentUser.getType() == 7220)))
      {
        ajkm.a(paramQQAppInterface, paramRecentUser.uin, paramRecentBaseData.mUnreadFlag, paramRecentBaseData.b(), 1, paramString);
        if ((paramRecentUser.getType() == 7220) || (alof.aA.equalsIgnoreCase(paramRecentBaseData.a())) || (alof.aQ.equalsIgnoreCase(paramRecentBaseData.a())) || ("2290230341".equalsIgnoreCase(paramRecentBaseData.a()))) {
          ajkm.a.add(new ajkr(paramRecentUser.uin, paramString, System.currentTimeMillis()));
        }
      }
      if (((paramRecentUser.uin == null) || (paramRecentUser.uin.length() != 4)) && (!alof.J.equals(paramRecentUser.uin)) && (!TextUtils.equals(paramRecentUser.uin, alof.az)) && (!TextUtils.equals(paramRecentUser.uin, alof.aQ)) && (!TextUtils.equals(paramRecentUser.uin, alof.aV)) && (!TextUtils.equals(paramRecentUser.uin, alof.aR)) && (!TextUtils.equals(paramRecentUser.uin, alof.aS)) && (!TextUtils.equals(paramRecentUser.uin, "2290230341")) && (!TextUtils.equals(paramRecentUser.uin, "2747277822")) && (!TextUtils.equals(paramRecentUser.uin, "3046055438"))) {
        break label655;
      }
    }
    for (;;)
    {
      try
      {
        bool2 = a(paramQQAppInterface, paramActivity, paramRecentUser, paramInt, paramRecentBaseData);
        paramInt = k;
        if (bool2) {
          break label2206;
        }
        if (paramRecentUser.getType() != 8999) {
          break label661;
        }
        paramInt = 0;
        if (paramRecentUser.msgType != 17) {
          break label2028;
        }
        paramActivity = (auga)paramQQAppInterface.getManager(37);
        long l = 0L;
        if (paramRecentUser.uin != null) {
          l = paramActivity.b(paramRecentUser.uin);
        }
        paramActivity = null;
        if (l != 0L) {
          paramActivity = paramQQAppInterface.a().d(paramRecentUser.uin, paramRecentUser.getType(), l);
        }
        if (!MessageForQQWalletMsg.isRedPacketMsg(paramActivity)) {
          break label1999;
        }
        azqs.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_hongbaoSign", 0, 0, paramRecentUser.uin, "", "", "");
        label541:
        azqs.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_sfsign", 0, 0, paramRecentUser.uin, "", "", "");
        paramActivity = ".troop.special_msg.special_attention";
        label570:
        i = paramInt;
        if (TextUtils.isEmpty(paramActivity)) {
          break;
        }
        i = paramInt;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(ajlb.class.getSimpleName() + paramActivity, 2, "onRecentUserClick, r.uin:" + paramRecentUser.uin);
        return paramInt;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      bool1 = false;
      break label146;
      label655:
      boolean bool2 = false;
    }
    label661:
    if (paramRecentUser.getType() == 7000)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "RecentUtil.onRecentUserClick. r.uin=" + paramRecentUser.uin + " r.type=" + paramRecentUser.getType());
      }
      paramString = paramRecentUser.uin;
      if ((paramRecentBaseData instanceof RecentItemSubAccount)) {
        paramString = ((RecentItemSubAccount)paramRecentBaseData).showSubUin;
      }
      paramRecentBaseData = paramString;
      if (paramString == null) {
        paramRecentBaseData = "";
      }
      bact.a(paramQQAppInterface, paramActivity, paramRecentBaseData);
      paramQQAppInterface.a().c(paramRecentUser.uin, paramRecentUser.getType());
      if (alof.x.equals(paramRecentUser.uin)) {}
      for (paramActivity = null;; paramActivity = paramRecentUser.uin)
      {
        azqs.b(paramQQAppInterface, "CliOper", "", paramActivity, "Bind_account", "Clk_bind_account", 0, 0, "", "", "", "");
        azqs.b(paramQQAppInterface, "CliOper", "", "", "0X800713E", "0X800713E", 0, 0, "", "", "", "");
        paramInt = 0;
        break;
      }
    }
    if ((paramRecentUser.getType() == 1000) || (paramRecentUser.getType() == 1020) || (paramRecentUser.getType() == 1004)) {
      if (a(paramQQAppInterface, paramRecentUser.uin))
      {
        paramRecentUser.setType(0);
        if (!paramBoolean) {
          break label2209;
        }
      }
    }
    label2206:
    label2209:
    for (paramInt = 2;; paramInt = 0)
    {
      i = paramInt | a(paramActivity, paramQQAppInterface, String.valueOf(paramRecentUser.uin), paramRecentUser.getType(), paramString, bool1);
      paramInt = i;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.recent", 2, "from_enterchat");
        paramInt = i;
        break;
        if ((paramRecentUser.troopUin == null) || (paramRecentUser.troopUin.trim().length() == 0))
        {
          paramRecentBaseData = paramQQAppInterface.a().a().b(paramRecentUser.uin, 1);
          if (paramRecentBaseData != null) {
            paramRecentUser.troopUin = paramRecentBaseData.troopUin;
          }
        }
        a(paramActivity, paramRecentUser.uin, paramRecentUser.troopUin, paramRecentUser.getType(), paramString, bool1);
        paramInt = 0;
        break;
        if ((paramRecentUser.getType() == 1005) || (paramRecentUser.getType() == 1023))
        {
          paramInt = i;
          if (a(paramQQAppInterface, paramRecentUser.uin))
          {
            paramRecentUser.setType(0);
            paramInt = i;
            if (paramBoolean) {
              paramInt = 2;
            }
          }
          paramInt |= a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType(), paramString, bool1);
          break;
        }
        if (paramRecentUser.getType() == 1024)
        {
          paramInt = 0x0 | a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType(), paramString, bool1);
          break;
        }
        if (paramRecentUser.getType() == 6002)
        {
          paramString = (ztp)paramQQAppInterface.a(51);
          paramString.a(paramActivity, paramString.a(Long.parseLong(paramRecentUser.uin)), false);
          paramInt = 0;
          break;
        }
        if (paramRecentUser.getType() == 10005)
        {
          b(paramQQAppInterface, paramRecentUser.uin, 10005);
          paramQQAppInterface.a().a(paramRecentUser.uin, 10005, true, true);
          asyc.a().a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType());
          paramInt = 0;
          break;
        }
        if (paramRecentUser.lFlag == 16L)
        {
          b(paramQQAppInterface, paramRecentUser.uin, 1008);
          paramQQAppInterface.a().a(paramRecentUser.uin, 1008, true, true);
          a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType());
          paramInt = 0;
          break;
        }
        if (paramRecentUser.getType() == 6004)
        {
          paramRecentBaseData = ((nan)paramQQAppInterface.getManager(70)).a(46, false);
          if ((paramRecentBaseData != null) && (paramRecentBaseData.uint32_number.has()))
          {
            paramInt = paramRecentBaseData.uint32_number.get();
            label1350:
            if ((paramRecentBaseData == null) || (paramRecentBaseData.bool_display_reddot.get())) {}
          }
          for (;;)
          {
            try
            {
              if (!paramRecentBaseData.str_custom_buffer.has()) {
                continue;
              }
              paramString = paramRecentBaseData.str_custom_buffer.get().toStringUtf8();
              if (TextUtils.isEmpty(paramString)) {
                continue;
              }
              paramString = new JSONObject(paramString);
              if (paramRecentBaseData.uint32_last_time.has()) {
                paramString.put("lastTime", paramRecentBaseData.uint32_last_time.get());
              }
              paramString.put("lastMsg", paramString.get("msg"));
              paramString = paramString.toString();
              paramRecentBaseData.str_custom_buffer.set(ByteStringMicro.copyFromUtf8(paramString));
              nag.a(paramQQAppInterface, paramRecentBaseData, 0, true);
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
              continue;
              if (paramInt <= 99) {
                continue;
              }
              paramString = paramString + "(99+)";
              continue;
              paramString = paramString + "(" + paramInt + ")";
              continue;
            }
            paramString = null;
            if (paramInt > 0)
            {
              a(paramQQAppInterface, paramRecentUser, true, true);
              paramInt = paramQQAppInterface.a().b();
              paramString = alud.a(2131713610);
              if (paramInt > 0) {
                continue;
              }
            }
            paramRecentBaseData = new Intent(paramActivity, QQBrowserActivity.class);
            if (!TextUtils.isEmpty(paramString)) {
              paramRecentBaseData.putExtra("selfSet_leftViewText", paramString);
            }
            paramRecentBaseData.putExtra("is_wrap_content", true);
            paramRecentBaseData.putExtra("url", "https://docs.qq.com/components/Notifications.html?_wv=3");
            paramRecentBaseData.putExtra("hide_more_button", true);
            paramRecentBaseData.putExtra("webStyle", "noBottomBar");
            paramRecentBaseData.putExtra("isScreenOrientationPortrait", true);
            paramRecentBaseData.putExtra("title", paramQQAppInterface.getApp().getString(2131720741));
            paramRecentBaseData.addFlags(603979776);
            paramActivity.startActivity(paramRecentBaseData);
            paramInt = 0;
            break;
            paramInt = 0;
            break label1350;
            paramString = null;
            continue;
            paramString = new JSONObject();
          }
        }
        if (paramRecentUser.getType() == 8114)
        {
          LoginUserGuideHelper.a(paramActivity, paramQQAppInterface);
          azqs.b(paramQQAppInterface, "dc00898", "", "", "0X8009F4C", "0X8009F4C", 0, 0, "", "", "", "");
          paramInt = 0;
          break;
        }
        if ((paramRecentUser.getType() == 1) && ((paramRecentUser.lFlag & 1L) != 0L))
        {
          paramRecentBaseData = paramQQAppInterface.a(true);
          if (paramRecentBaseData != null)
          {
            HotChatInfo localHotChatInfo = paramRecentBaseData.a(paramRecentUser.uin);
            if ((localHotChatInfo != null) && (localHotChatInfo.apolloGameId > 0)) {
              VipUtils.a(null, "cmshow", "Apollo", "clk_reliao_msgtab", 0, 0, new String[] { String.valueOf(localHotChatInfo.apolloGameId) });
            }
          }
          if ((paramRecentBaseData != null) && (!paramRecentBaseData.b(paramRecentUser.uin))) {
            return 4;
          }
        }
        if (a(paramQQAppInterface, paramRecentUser.uin))
        {
          paramInt = j;
          if (1 != paramRecentUser.getType())
          {
            paramInt = j;
            if (3000 != paramRecentUser.getType())
            {
              paramInt = j;
              if (paramRecentUser.getType() != 0)
              {
                paramRecentUser.setType(0);
                paramInt = j;
                if (paramBoolean) {
                  paramInt = 2;
                }
              }
            }
          }
          paramInt |= a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType(), paramString, bool1, paramBundle, paramArrayOfIntent);
          break;
        }
        paramInt = 0x0 | a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType(), paramString, bool1, paramBundle, paramArrayOfIntent);
        break;
        label1999:
        azqs.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_sfsign", 0, 0, paramRecentUser.uin, "", "", "");
        break label541;
        label2028:
        if (paramRecentUser.msgType == 24)
        {
          azqs.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_atsign", 0, 0, paramRecentUser.uin, "", "", "");
          paramActivity = ".troop.special_msg.at_msg";
          break label570;
        }
        if (paramRecentUser.msgType == 22)
        {
          i = paramQQAppInterface.b(paramRecentUser.uin);
          if (paramRecentUser.getType() == 3000) {}
          for (paramActivity = "Grp_Dis_replyMsg";; paramActivity = "Grp_replyMsg")
          {
            azqs.b(paramQQAppInterface, "P_CliOper", paramActivity, "", "Msglist", "Clk_replySign", 0, 0, paramRecentUser.uin, "" + i, "", "");
            paramActivity = "";
            break;
          }
        }
        if (paramRecentUser.msgType == 16) {
          azqs.b(null, "dc00898", "", paramRecentUser.uin, "qq_vip", "0X800A907", 0, 1, 0, "", "", "", "");
        }
        paramActivity = "";
        break label570;
      }
      break;
    }
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    return a(paramContext, paramQQAppInterface, paramString1, paramInt, paramString2, paramBoolean, null, null);
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    return a(paramContext, paramQQAppInterface, paramString1, paramInt, paramString2, paramBoolean, paramBundle, null);
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, boolean paramBoolean, Bundle paramBundle, Intent[] paramArrayOfIntent)
  {
    bdnm.a(null, "Recent_clk_enterchat");
    SuspendThreadManager.a().a(true);
    int i = 0;
    Object localObject1 = new Intent();
    if ((paramArrayOfIntent != null) && (paramArrayOfIntent.length != 0)) {
      paramArrayOfIntent[0] = localObject1;
    }
    long l1;
    if (jdField_a_of_type_Boolean)
    {
      ((Intent)localObject1).setClassName(paramContext, ChatActivity.class.getName());
      if (jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
        if ((jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 1) || (jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 3000))
        {
          l1 = jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq;
          ((Intent)localObject1).putExtra("searched_timeorseq", l1);
          paramArrayOfIntent = (Intent[])localObject1;
        }
      }
    }
    for (;;)
    {
      label113:
      if (paramBundle != null) {
        paramArrayOfIntent.putExtras(paramBundle);
      }
      if (paramInt == 3000) {
        i = 0;
      }
      label136:
      label193:
      boolean bool;
      for (;;)
      {
        paramArrayOfIntent.putExtra("uin", paramString1);
        paramArrayOfIntent.putExtra("uintype", paramInt);
        paramArrayOfIntent.putExtra("uinname", paramString2);
        paramArrayOfIntent.putExtra("entrance", 1);
        a(paramArrayOfIntent);
        if (!paramBoolean) {
          break label1108;
        }
        a(paramContext, paramArrayOfIntent);
        bdnm.a("Recent_clk_enterchat", null);
        label539:
        do
        {
          return i;
          l1 = jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
          break;
          if (jdField_a_of_type_Long == 0L) {
            break label1130;
          }
          ((Intent)localObject1).putExtra("searched_timeorseq", jdField_a_of_type_Long);
          paramArrayOfIntent = (Intent[])localObject1;
          break label113;
          paramArrayOfIntent = null;
          if (paramBundle != null) {
            paramArrayOfIntent = paramBundle.getString("KEY_OPEN_AIO_INTENT_CLASS_NAME");
          }
          localObject2 = paramArrayOfIntent;
          if (TextUtils.isEmpty(paramArrayOfIntent)) {
            localObject2 = SplashActivity.class.getName();
          }
          ((Intent)localObject1).setClassName(paramContext, (String)localObject2);
          paramArrayOfIntent = aepi.a((Intent)localObject1, new int[] { 1 });
          break label113;
          if ((paramInt == 0) || (paramInt == 1024))
          {
            if (paramInt != 1024)
            {
              bool = paramBoolean;
              if (!ndv.c(paramQQAppInterface, paramString1)) {
                break label1088;
              }
            }
            bdnm.a(null, "Recent_clk_enterchat_cmr");
            azqs.b(paramQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, paramString1, "0", "", "");
            bdnm.a("Recent_clk_enterchat_cmr", null);
            i = 0;
            break label136;
          }
          if (paramInt != 1) {
            break label584;
          }
          bdnm.a(null, "Recent_clk_enterchat_troop");
          paramBundle = ((HotChatManager)paramQQAppInterface.getManager(60)).a(paramString1);
          if (paramBundle != null) {
            paramArrayOfIntent.putExtra("troop_uin", paramBundle.troopCode);
          }
          for (;;)
          {
            i = 1;
            bdnm.a("Recent_clk_enterchat_troop", null);
            break;
            paramBundle = (TroopManager)paramQQAppInterface.getManager(52);
            if (paramBundle != null)
            {
              paramBundle = paramBundle.a(paramString1 + "", true);
              if ((paramBundle == null) || (paramBundle.troopuin == null)) {
                break label539;
              }
              paramArrayOfIntent.putExtra("troop_uin", paramBundle.troopuin);
            }
            azqs.b(paramQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
          }
          if (QLog.isColorLevel()) {
            QLog.e("RecentUtil", 2, "when enter troop AIO, troop is not exist!!");
          }
        } while (Looper.myLooper() != Looper.getMainLooper());
        QQToast.a(BaseApplicationImpl.getContext(), 1, alud.a(2131713615), 0).a();
        return 0;
        label584:
        if (paramInt != 1008) {
          break label952;
        }
        bdnm.a(null, "Recent_clk_enterchat_cmr");
        paramBundle = ((alzl)paramQQAppInterface.getManager(56)).c(String.valueOf(paramString1));
        if ((paramBundle == null) || (paramBundle.extendType != 2)) {
          break label692;
        }
        azqs.b(paramQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, paramString1, "0", "", "");
        paramArrayOfIntent.putExtra("chat_subType", 1);
        paramArrayOfIntent.setClass(paramContext, ChatActivity.class);
        paramBoolean = false;
        bdnm.a("Recent_clk_enterchat_pub", null);
        i = 0;
      }
      label692:
      Object localObject2 = paramQQAppInterface.a().a(paramString1, 1008);
      paramBundle = "";
      localObject1 = paramBundle;
      if (localObject2 != null)
      {
        localObject1 = aeum.a((MessageRecord)localObject2);
        if (localObject1 != null) {
          paramBundle = Long.toString(((PAMessage)localObject1).mMsgId);
        }
        localObject1 = paramBundle;
        if (!TextUtils.isEmpty(paramBundle)) {}
      }
      for (paramBundle = ((MessageRecord)localObject2).getExtInfoFromExtStr("pa_msgId");; paramBundle = (Bundle)localObject1)
      {
        if (localObject2 != null) {}
        for (i = paramQQAppInterface.a().a(paramString1, ((MessageRecord)localObject2).istroop);; i = 0)
        {
          nrt.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_3", "msg_aio", 0, 0, paramString1, paramBundle, String.valueOf(i), "", false);
          int j;
          if ("2909288299".equals(paramString1))
          {
            if (i > 0)
            {
              j = 2;
              label830:
              azqs.b(paramQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X8007055", "0X8007055", 0, 0, "", "", "", ssp.a(j));
            }
          }
          else
          {
            paramArrayOfIntent.putExtra("shouldreport", true);
            if ((paramContext instanceof SplashActivity))
            {
              paramArrayOfIntent.putExtra("start_time", System.currentTimeMillis());
              paramArrayOfIntent.putExtra("red_hot_count", i);
            }
            if (i <= 0) {
              break label946;
            }
          }
          label946:
          for (paramBoolean = true;; paramBoolean = false)
          {
            paramArrayOfIntent.putExtra("has_unread_msg", paramBoolean);
            paramArrayOfIntent.putExtra("jump_from", 1);
            syp.a(null, "SUBSCRIPT_AIO_COST");
            break;
            j = 1;
            break label830;
          }
          label952:
          bool = paramBoolean;
          if (paramInt == 9501)
          {
            aagb.a(paramQQAppInterface, "Usr_AIO_Open", 2, 0, 0);
            paramQQAppInterface = (ztp)paramQQAppInterface.a(51);
            l1 = 0L;
          }
          try
          {
            long l2 = Long.parseLong(paramString1);
            l1 = l2;
          }
          catch (Exception paramBundle)
          {
            for (;;)
            {
              paramBundle.printStackTrace();
            }
          }
          paramArrayOfIntent.setClass(paramContext, ChatActivity.class);
          paramBoolean = false;
          bool = paramBoolean;
          if (paramQQAppInterface != null)
          {
            bool = paramBoolean;
            if (paramQQAppInterface.a(l1, 9))
            {
              paramQQAppInterface = new Bundle();
              paramQQAppInterface.putString("din", String.valueOf(l1));
              paramQQAppInterface.putString("devName", paramString2);
              paramQQAppInterface.putBoolean("bFromLightApp", false);
              paramQQAppInterface.putInt("operType", 5);
              paramArrayOfIntent.putExtras(paramQQAppInterface);
              bool = paramBoolean;
            }
          }
          label1088:
          i = 0;
          paramBoolean = bool;
          break;
          label1108:
          paramContext.startActivity(paramArrayOfIntent);
          break label193;
        }
      }
      label1130:
      paramArrayOfIntent = (Intent[])localObject1;
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    if ((paramContext instanceof SplashActivity))
    {
      paramContext = (SplashActivity)paramContext;
      paramIntent.putExtra("isFromMainTab", true);
      paramIntent.putExtra("isBack2Root", true);
      paramContext.setIntent(paramIntent);
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.SpalshActivity", 2, "mainTabToAio-->openAioFragment");
      }
      paramContext.a(false, 1);
    }
    while (paramIntent.getBooleanExtra("KEY_MULTI_WINDOW_AIO_BLOCK_JUMP_BOTTOM", false)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.SpalshActivity", 2, "start->SpalshActivity-->AIO");
    }
    paramContext.startActivity(paramIntent);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramContext == null) {}
    nlx localnlx;
    nlo localnlo;
    do
    {
      return;
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        while (TextUtils.isEmpty(paramString)) {
          if (QLog.isColorLevel())
          {
            QLog.d("RecentUtil", 2, "openAdvertisement empty uin!");
            return;
          }
        }
        localnlx = nlx.a();
        localObject = localnlx.a(paramString);
        if (localObject != null)
        {
          a(paramContext, paramQQAppInterface, paramString, paramInt, (nlo)localObject);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("RecentUtil", 2, "openAdvertisement item recreate, uin:" + paramString);
        }
        localObject = paramQQAppInterface.a().b(paramString, paramInt).iterator();
      }
      localnlo = nmh.a(paramQQAppInterface, (MessageRecord)((Iterator)localObject).next(), true);
    } while (localnlo == null);
    localnlx.a(localnlo);
    a(paramContext, paramQQAppInterface, paramString, paramInt, localnlo);
  }
  
  private static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt, nlo paramnlo)
  {
    Intent localIntent = new Intent(paramContext, PublicAccountAdvertisementActivity.class);
    localIntent.putExtra("arg_ad_json", paramnlo.a());
    localIntent.putExtra("USR_CLICK_TIME", SystemClock.uptimeMillis());
    localIntent.putExtra("is_first_open_imax_ad", c);
    c = false;
    paramContext.startActivity(localIntent);
    ThreadManager.post(new RecentUtil.7(paramQQAppInterface, paramString, paramInt, paramnlo), 5, null, false);
    nlx.a().a(paramQQAppInterface, 2, paramnlo);
    if (QLog.isColorLevel()) {
      QLog.d("RecentUtil", 2, "openAdvertisement start, uin:" + paramString);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean)
  {
    Intent localIntent;
    long l;
    if (paramContext != null)
    {
      if (!jdField_a_of_type_Boolean) {
        break label146;
      }
      localIntent = new Intent(paramContext, ChatActivity.class);
      if (jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
        break label179;
      }
      if ((jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop != 1) && (jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop != 3000)) {
        break label135;
      }
      l = jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq;
      localIntent.putExtra("searched_timeorseq", l);
    }
    label135:
    label146:
    label179:
    for (;;)
    {
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("troop_uin", paramString2);
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("uinname", paramString3);
      a(localIntent);
      if (paramBoolean)
      {
        if ((paramContext instanceof SplashActivity)) {
          a(paramContext, localIntent);
        }
        return;
        l = jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
        break;
        localIntent = aepi.a(new Intent(paramContext, SplashActivity.class), new int[] { 1 });
        continue;
      }
      paramContext.startActivity(localIntent);
      return;
    }
  }
  
  public static void a(Intent paramIntent)
  {
    if (jdField_a_of_type_Boolean)
    {
      paramIntent.putExtra("aio_msg_source", 1);
      paramIntent.putExtra("entrance", 7);
      jdField_a_of_type_Boolean = false;
      jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
      jdField_a_of_type_Long = 0L;
      return;
    }
    paramIntent.putExtra("aio_msg_source", 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    if (paramRecentUser.getType() == 5000) {}
    for (;;)
    {
      azqs.b(paramQQAppInterface, "CliOper", "", "", "0X800419C", "0X800419C", 0, 0, "", "", "", "");
      azqs.b(paramQQAppInterface, "CliOper", "", "", "0X80041A0", "0X80041A0", 0, 0, "", "", "", "");
      return;
      if ((paramRecentUser.getType() == 7200) || (paramRecentUser.getType() == 1008))
      {
        azqs.b(paramQQAppInterface, "CliOper", "", "", "0X80041A1", "0X80041A1", 0, 0, "", "", "", "");
        if (paramRecentUser.getType() == 1008) {
          a(paramQQAppInterface, paramRecentUser.uin, 1);
        }
      }
      else if (String.valueOf(9992L).equals(paramRecentUser.uin))
      {
        azqs.b(paramQQAppInterface, "CliOper", "", "", "0X800419F", "0X800419F", 0, 0, "", "", "", "");
      }
      else if (((paramRecentUser.getType() == 1001) || (paramRecentUser.getType() == 10002)) && (alof.H.equals(paramRecentUser.uin)))
      {
        azqs.b(paramQQAppInterface, "CliOper", "", "", "0X80041A2", "0X80041A2", 0, 0, "", "", "", "");
        azqs.b(paramQQAppInterface, "CliOper", "", "", "0X80050FD", "0X80050FD", 0, 0, "", "", "", "");
        azqs.b(paramQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "drag_msg", 0, 0, "", "", "", "");
      }
      else if ((paramRecentUser.getType() == 1010) && (alof.ab.equals(paramRecentUser.uin)))
      {
        azqs.b(paramQQAppInterface, "CliOper", "", "", "0X80050FF", "0X80050FF", 0, 0, "", "", "", "");
      }
      else if ((paramRecentUser.getType() == 1009) && (alof.w.equals(paramRecentUser.uin)))
      {
        azqs.b(paramQQAppInterface, "CliOper", "", "", "0X80041A4", "0X80041A4", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramRecentUser == null)) {}
    label135:
    label502:
    label632:
    do
    {
      do
      {
        Object localObject1;
        do
        {
          do
          {
            int i;
            do
            {
              do
              {
                return;
                paramQQAppInterface.a().a().b(paramRecentUser, false);
                if (!abti.b(paramRecentUser.uin, paramRecentUser.getType())) {
                  break label781;
                }
                if ((!alof.ab.equals(paramRecentUser.uin)) && (!alof.H.equals(paramRecentUser.uin))) {
                  break;
                }
                localObject1 = paramQQAppInterface.a().a(paramRecentUser.uin, paramRecentUser.getType());
                if (localObject1 != null) {
                  paramQQAppInterface.a().a(paramRecentUser.getType(), ((QQMessageFacade.Message)localObject1).time);
                }
                localObject1 = paramRecentUser.uin;
                i = paramRecentUser.getType();
                ThreadManager.post(new RecentUtil.3((MessageHandler)paramQQAppInterface.a(0), (String)localObject1, i), 8, null, false);
                paramQQAppInterface.a().a(paramRecentUser.uin, paramRecentUser.getType(), true, true);
                if (paramRecentUser.getType() == 1) {
                  auud.a(paramQQAppInterface, paramRecentUser.uin);
                }
                if ((paramRecentUser.getType() == 9000) && (alof.W.equals(paramRecentUser.uin)))
                {
                  paramQQAppInterface.a().a().c();
                  bafj.a().a(paramQQAppInterface, 0);
                  ((ambh)paramQQAppInterface.getManager(22)).b();
                }
                if ((paramRecentUser.getType() == 7210) && (alof.ac.equals(paramRecentUser.uin)))
                {
                  suv.a().e(paramQQAppInterface);
                  suv.a().d(paramQQAppInterface);
                  paramQQAppInterface.a(true, 0);
                }
                if ((paramRecentUser.getType() == 7230) && (alof.aB.equals(paramRecentUser.uin)))
                {
                  localObject1 = ssp.a();
                  i = ((ssp)localObject1).b();
                  int j = ((ssp)localObject1).a(paramQQAppInterface);
                  long l = ((ssp)localObject1).a();
                  if (paramInt != -1) {
                    azqs.b(paramQQAppInterface, "dc01160", "Pb_account_lifeservice", "", "0X80067EB", "0X80067EB", 0, 0, "" + j, "" + i, String.valueOf(paramInt + 1), "" + l);
                  }
                  ((ssp)localObject1).d(paramQQAppInterface);
                  paramQQAppInterface.a(true, 0);
                  if (QLog.isColorLevel()) {
                    QLog.d("RecentUtil", 2, "deleteServiceAccountFolderFromMsgTab");
                  }
                }
                if (!alof.ac.equals(paramRecentUser.uin)) {
                  break label796;
                }
                azqs.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572D", "0X800572D", 0, 0, "", "", "", "");
                azqs.b(paramQQAppInterface, "CliOper", "", "", "0X800623F", "0X800623F", 0, 0, "", "", "", "");
                suk.c(paramQQAppInterface, false);
                paramInt = 0;
                switch (paramRecentUser.getType())
                {
                default: 
                  azqs.b(paramQQAppInterface, "CliOper", "", "", "Msg_tab", "Delete_msg", 0, 0, paramInt + "", "", "", "");
                  if (paramRecentUser.getType() != 5000) {
                    break label996;
                  }
                  auam.a().a(paramQQAppInterface, true);
                  paramRecentUser = auam.a().b(paramQQAppInterface);
                  if (paramRecentUser != null) {
                    break label951;
                  }
                  paramInt = 0;
                  i = 0;
                }
              } while (i >= paramInt);
              localObject1 = (TroopAssistantData)paramRecentUser.get(i);
              if (localObject1 == null) {}
              for (;;)
              {
                i += 1;
                break label709;
                if ((1032 != paramRecentUser.getType()) || (!alof.aN.equals(paramRecentUser.uin))) {
                  break;
                }
                paramQQAppInterface.a().b();
                aoiy.b(paramQQAppInterface, false);
                aoiy.a(paramQQAppInterface, false);
                break;
                b(paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType());
                break label135;
                if (!alof.ae.equals(paramRecentUser.uin)) {
                  break label502;
                }
                if (((ntw)paramQQAppInterface.getManager(88)).a(paramQQAppInterface) > 0) {}
                for (localObject1 = "havereddot";; localObject1 = "noreddot")
                {
                  azqs.b(paramQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_DelMsglist", "Del_shopHelper", 0, 0, "", "", (String)localObject1, "");
                  break;
                }
                if (!paramRecentUser.uin.equals(alof.G)) {
                  break label632;
                }
                paramInt = 7;
                break label632;
                paramInt = 1;
                break label632;
                paramInt = 2;
                break label632;
                paramInt = 3;
                a(paramQQAppInterface, paramRecentUser.uin, 2);
                break label632;
                paramInt = 4;
                break label632;
                paramInt = 5;
                break label632;
                paramInt = 6;
                break label632;
                paramInt = 8;
                break label632;
                paramInt = 9;
                break label632;
                paramInt = 11;
                break label632;
                paramInt = 12;
                break label632;
                paramInt = paramRecentUser.size();
                break label707;
                localObject1 = paramQQAppInterface.a().a(((TroopAssistantData)localObject1).troopUin, 1);
                if (localObject1 != null) {
                  auam.a().a(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).time);
                }
              }
              if (paramRecentUser.getType() == 7210)
              {
                suv.a().a(paramQQAppInterface, true);
                ThreadManager.post(new RecentUtil.4(paramQQAppInterface), 8, null, false);
                suv.a().h(paramQQAppInterface);
                return;
              }
              if (paramRecentUser.getType() != 7120) {
                break;
              }
              paramRecentUser = (ntw)paramQQAppInterface.getManager(88);
            } while (paramRecentUser == null);
            paramRecentUser.a(true);
            localObject1 = paramRecentUser.a();
            Object localObject2;
            if (localObject1 == null)
            {
              paramInt = 0;
              i = 0;
              if (i < paramInt)
              {
                localObject2 = (EcShopData)((List)localObject1).get(i);
                if (localObject2 != null) {
                  break label1122;
                }
              }
            }
            for (;;)
            {
              i += 1;
              break label1081;
              break;
              paramInt = ((List)localObject1).size();
              break label1079;
              localObject2 = paramQQAppInterface.a().a(((EcShopData)localObject2).mUin, 1008);
              if (localObject2 != null) {
                paramRecentUser.a(((QQMessageFacade.Message)localObject2).time);
              }
            }
            if (paramRecentUser.getType() != 9002) {
              break;
            }
            azqs.b(paramQQAppInterface, "CliOper", "", "", "0X8004E99", "0X8004E99", 0, 0, "", "", "", "");
            localObject1 = paramQQAppInterface.a().b(alof.ad, 0);
            paramRecentUser = new ArrayList(((List)localObject1).size());
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (MessageRecord)((Iterator)localObject1).next();
              if ((!((MessageRecord)localObject2).isread) && ((((MessageRecord)localObject2).extLong & 0x1) == 1) && (!TextUtils.isEmpty(((MessageRecord)localObject2).extStr))) {
                paramRecentUser.add(((MessageRecord)localObject2).extStr);
              }
              paramQQAppInterface.a().b(alof.ad, 0, ((MessageRecord)localObject2).uniseq);
            }
          } while (paramRecentUser.size() <= 0);
          amfz.a(paramQQAppInterface, (ArrayList)paramRecentUser);
          return;
          if (paramRecentUser.getType() == 9003)
          {
            ((ahcr)paramQQAppInterface.getManager(138)).d();
            return;
          }
          if ((paramRecentUser.getType() == 7000) && (alof.x.equals(paramRecentUser.uin)))
          {
            ThreadManager.postImmediately(new RecentUtil.5(paramQQAppInterface), null, true);
            return;
          }
          if (paramRecentUser.getType() != 10005) {
            break;
          }
          localObject1 = asyc.a().b(paramRecentUser.uin);
        } while (localObject1 == null);
        asyc.a().a(paramQQAppInterface, paramRecentUser, (nlo)localObject1, true);
        return;
      } while (paramRecentUser.getType() != 6004);
      paramQQAppInterface = (nag)paramQQAppInterface.a(43);
    } while (paramQQAppInterface == null);
    label707:
    label709:
    label996:
    paramQQAppInterface.b(46);
    label781:
    label796:
    label951:
    label1079:
    label1081:
    label1122:
    return;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    if ((paramQQAppInterface == null) || (paramRecentUser == null)) {}
    label136:
    label185:
    label210:
    label468:
    do
    {
      do
      {
        Object localObject1;
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
                      for (;;)
                      {
                        return;
                        int i = paramRecentUser.getType();
                        localObject1 = paramRecentUser.uin;
                        if ((i != 1033) && (i != 1034)) {
                          azpz.a(1, 1, i, paramQQAppInterface.a().a((String)localObject1, i));
                        }
                        if (abti.b(paramRecentUser.uin, paramRecentUser.getType())) {
                          if ((alof.ab.equals(paramRecentUser.uin)) || (alof.H.equals(paramRecentUser.uin)))
                          {
                            localObject1 = paramQQAppInterface.a().a(paramRecentUser.uin, paramRecentUser.getType());
                            if (localObject1 != null) {
                              paramQQAppInterface.a().a(paramRecentUser.getType(), ((QQMessageFacade.Message)localObject1).time);
                            }
                            localObject1 = paramRecentUser.uin;
                            i = paramRecentUser.getType();
                            paramQQAppInterface.a().d((String)localObject1, i);
                            ThreadManager.post(new RecentUtil.2((MessageHandler)paramQQAppInterface.a(0), (String)localObject1, i), 8, null, false);
                            if (paramRecentUser.getType() != 5000) {
                              break label468;
                            }
                            paramRecentUser = auam.a().b(paramQQAppInterface);
                            if (paramRecentUser != null) {
                              break label422;
                            }
                            i = 0;
                            if (j >= i) {
                              break label431;
                            }
                            localObject1 = (TroopAssistantData)paramRecentUser.get(j);
                            if (localObject1 != null) {
                              break label433;
                            }
                          }
                        }
                        for (;;)
                        {
                          j += 1;
                          break label210;
                          if ((1032 != paramRecentUser.getType()) || (!alof.aN.equals(paramRecentUser.uin))) {
                            break label136;
                          }
                          paramQQAppInterface.a().b();
                          aoiy.b(paramQQAppInterface, false);
                          aoiy.a(paramQQAppInterface, false);
                          break label136;
                          if (paramBoolean1)
                          {
                            localObject1 = new SessionInfo();
                            ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString = paramRecentUser.uin;
                            ((SessionInfo)localObject1).b = paramRecentUser.uin;
                            ((SessionInfo)localObject1).jdField_a_of_type_Int = paramRecentUser.getType();
                            if (((SessionInfo)localObject1).jdField_a_of_type_Int == 1006) {
                              ((SessionInfo)localObject1).f = bdgc.e(paramQQAppInterface, ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString);
                            }
                            acjm.a(paramQQAppInterface, (SessionInfo)localObject1);
                          }
                          if ((7000 == paramRecentUser.getType()) && (alof.x.equals(paramRecentUser.uin))) {
                            bacu.c(paramQQAppInterface);
                          }
                          paramQQAppInterface.a().a(paramRecentUser.uin, paramRecentUser.getType(), true, paramBoolean2);
                          if (paramRecentUser.getType() != 1) {
                            break label185;
                          }
                          auud.a(paramQQAppInterface, paramRecentUser.uin);
                          break label185;
                          i = paramRecentUser.size();
                          break label210;
                          break;
                          localObject1 = paramQQAppInterface.a().a(((TroopAssistantData)localObject1).troopUin, 1);
                          if (localObject1 != null) {
                            auam.a().a(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).time);
                          }
                        }
                        if (5001 != paramRecentUser.getType()) {
                          break;
                        }
                        paramRecentUser = (alug)paramQQAppInterface.getManager(255);
                        localObject1 = paramRecentUser.a();
                        if ((localObject1 != null) && (((List)localObject1).size() > 0))
                        {
                          localObject1 = ((List)localObject1).iterator();
                          while (((Iterator)localObject1).hasNext())
                          {
                            Object localObject2 = (HotChatItemData)((Iterator)localObject1).next();
                            localObject2 = paramQQAppInterface.a().a(((HotChatItemData)localObject2).mTroopUin, 1);
                            if (localObject2 != null) {
                              paramRecentUser.a(((QQMessageFacade.Message)localObject2).time);
                            }
                          }
                        }
                      }
                      if (alof.D.equals(paramRecentUser.uin))
                      {
                        ((alxr)paramQQAppInterface.getManager(34)).f();
                        return;
                      }
                      if (String.valueOf(9980L).equals(paramRecentUser.uin))
                      {
                        paramQQAppInterface.a().a().c();
                        bafj.a().a(paramQQAppInterface, 0);
                        ((ambh)paramQQAppInterface.getManager(22)).b();
                        return;
                      }
                      if (paramRecentUser.getType() != 7210) {
                        break;
                      }
                      paramRecentUser = suv.a().a(paramQQAppInterface);
                    } while ((paramRecentUser == null) || (paramRecentUser.size() <= 0));
                    paramRecentUser = (TroopBarData)paramRecentUser.get(0);
                  } while (paramRecentUser == null);
                  paramRecentUser = paramQQAppInterface.a().a(paramRecentUser.mUin, 1008);
                } while (paramRecentUser == null);
                suv.a().a(paramQQAppInterface, paramRecentUser.time);
                return;
                if (paramRecentUser.getType() != 7120) {
                  break;
                }
                paramRecentUser = (ntw)paramQQAppInterface.getManager(88);
              } while (paramRecentUser == null);
              localObject1 = paramRecentUser.a();
            } while ((localObject1 == null) || (((List)localObject1).size() <= 0));
            localObject1 = (EcShopData)((List)localObject1).get(0);
          } while (localObject1 == null);
          paramQQAppInterface = paramQQAppInterface.a().a(((EcShopData)localObject1).mUin, 1008);
        } while (paramQQAppInterface == null);
        paramRecentUser.a(paramQQAppInterface.time);
        return;
        if (paramRecentUser.getType() == 7220)
        {
          ((KandianMergeManager)paramQQAppInterface.getManager(162)).b();
          return;
        }
        if (1001 == paramRecentUser.getType())
        {
          paramQQAppInterface.a().clearMsgBoxUnreadCount();
          return;
        }
        if (paramRecentUser.lFlag == 16L)
        {
          localObject1 = new SessionInfo();
          ((SessionInfo)localObject1).jdField_a_of_type_Int = 1008;
          paramRecentUser = paramRecentUser.uin;
          ((SessionInfo)localObject1).b = paramRecentUser;
          ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString = paramRecentUser;
          acjm.a(paramQQAppInterface, (SessionInfo)localObject1);
          paramQQAppInterface.a().a(((SessionInfo)localObject1).jdField_a_of_type_JavaLangString, 1008, true, paramBoolean2);
          return;
        }
        if (paramRecentUser.getType() == 10005)
        {
          localObject1 = new SessionInfo();
          ((SessionInfo)localObject1).jdField_a_of_type_Int = 10005;
          paramRecentUser = paramRecentUser.uin;
          ((SessionInfo)localObject1).b = paramRecentUser;
          ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString = paramRecentUser;
          acjm.a(paramQQAppInterface, (SessionInfo)localObject1);
          paramQQAppInterface.a().a(((SessionInfo)localObject1).jdField_a_of_type_JavaLangString, 1008, true, paramBoolean2);
          return;
        }
        if (paramRecentUser.getType() != 6004) {
          break;
        }
        paramQQAppInterface = (nag)paramQQAppInterface.a(43);
      } while (paramQQAppInterface == null);
      paramQQAppInterface.b(46);
      return;
    } while ((!"2747277822".equals(paramRecentUser.uin)) || (!asmu.a()));
    label422:
    label431:
    label433:
    ((asmu)paramQQAppInterface.getManager(358)).a(0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    ThreadManager.post(new RecentUtil.6(paramQQAppInterface, paramString, paramInt), 2, null, false);
    if ("2290230341".equals(paramString))
    {
      if (paramInt != 1) {
        break label57;
      }
      paramString = "0X80090E4";
    }
    for (;;)
    {
      azqs.b(paramQQAppInterface, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
      return;
      label57:
      paramString = "0X80090E5";
      azqp.a(3);
    }
  }
  
  public static void a(RecentUser paramRecentUser, QQMessageFacade paramQQMessageFacade)
  {
    long l1 = System.currentTimeMillis();
    if ((paramRecentUser == null) || (paramQQMessageFacade == null)) {}
    long l2;
    do
    {
      return;
      if ((paramRecentUser.getStatus() == 1000) && (paramRecentUser.lastmsgdrafttime == 0L))
      {
        paramQQMessageFacade = paramQQMessageFacade.a(paramRecentUser.uin, paramRecentUser.getType());
        if (paramQQMessageFacade != null) {
          paramRecentUser.lastmsgdrafttime = paramQQMessageFacade.getTime();
        }
      }
      l2 = System.currentTimeMillis();
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.recent", 4, "updateLastDraftTimeForNewRU| cost = " + (l2 - l1));
  }
  
  public static void a(List<ssj> paramList)
  {
    if ((paramList != null) && (paramList.size() == 0)) {}
  }
  
  public static boolean a(RecentBaseData paramRecentBaseData)
  {
    if (paramRecentBaseData == null) {}
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, int paramInt, RecentBaseData paramRecentBaseData)
  {
    if (alof.H.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.a(paramActivity, 1001, paramRecentUser.uin);
      azqs.b(paramQQAppInterface, "CliOper", "", "", "0X80050F5", "0X80050F5", 0, 0, "", "", "", "");
      azqs.b(paramQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "clk_friend", 0, 0, "", "", "", "");
      paramActivity = paramQQAppInterface.a().a(paramRecentUser.uin, 1001);
      if ((paramActivity != null) && (paramActivity.msgtype == -4011))
      {
        paramActivity = avue.a(paramQQAppInterface);
        azqs.b(paramQQAppInterface, "CliOper", "", "", "0X80055FB", "0X80055FB", 0, 0, paramActivity[0], "", paramActivity[1], "");
      }
      return true;
    }
    if (alof.ab.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.a(paramActivity, 1010, paramRecentUser.uin);
      azqs.b(paramQQAppInterface, "CliOper", "", "", "0X8004947", "0X8004947", 0, 0, "", "", "", "");
      azqs.b(paramQQAppInterface, "CliOper", "", "", "0X80050F6", "0X80050F6", 0, 0, "", "", "", "");
      return true;
    }
    if (alof.ah.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.a(paramActivity, 1001, alof.H);
      azqs.b(paramQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "tip_single", 0, 0, "", "", "", "");
      return true;
    }
    if (alof.ai.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.a(paramActivity, 1010, alof.ab);
      return true;
    }
    if (String.valueOf(alof.w).equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.a(paramActivity, 1009, paramRecentUser.uin);
      return true;
    }
    if (alof.E.equals(paramRecentUser.uin))
    {
      paramQQAppInterface.a().c(alof.E, 0);
      paramRecentUser = new Intent(paramActivity, VisitorsActivity.class);
      paramRecentUser.putExtra("votersOnly", true);
      paramRecentUser.putExtra("toUin", Long.valueOf(paramQQAppInterface.getCurrentAccountUin()));
      paramActivity.startActivity(paramRecentUser);
      return true;
    }
    if (alof.D.equals(paramRecentUser.uin))
    {
      paramRecentUser = new Intent();
      if ((paramActivity instanceof QQLSActivity)) {
        paramRecentUser.putExtra("from", "from_lsa");
      }
      NewFriendActivity.a(paramActivity, paramRecentUser, 1);
      azqs.b(paramQQAppInterface, "CliOper", "", "", "Add_frd", "Clk_Frd_offer", 22, 0, "", "", "", "");
      return true;
    }
    if (alof.C.equals(paramRecentUser.uin))
    {
      paramRecentUser = new Intent(paramActivity, TroopAssistantActivity.class);
      paramRecentUser.setFlags(67108864);
      paramActivity.startActivity(paramRecentUser);
      azqs.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_help", 0, 0, "", "", "", "");
      return true;
    }
    Object localObject1;
    Object localObject2;
    if (alof.aL.equals(paramRecentUser.uin))
    {
      paramRecentUser = new Intent(paramActivity, HotChatCenterFragment.class);
      paramRecentBaseData = (alug)paramQQAppInterface.getManager(255);
      localObject1 = paramRecentBaseData.a();
      ApolloGameUtil.a(paramQQAppInterface.getEntityManagerFactory().createEntityManager(), true);
      if (localObject1 != null)
      {
        paramRecentBaseData.a(((HotChatItemData)localObject1).mTroopUin, 1);
        localObject2 = paramQQAppInterface.getHandler(Conversation.class);
        if (localObject2 != null) {
          ((MqqHandler)localObject2).sendEmptyMessage(1009);
        }
        if (((HotChatItemData)localObject1).mIsRead4Folder) {
          break label675;
        }
      }
      label675:
      for (paramInt = 99;; paramInt = paramRecentBaseData.a())
      {
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "clk_reliao_folder", paramInt, 0, new String[0]);
        paramRecentUser.setFlags(67108864);
        PublicFragmentActivity.a(paramActivity, paramRecentUser, HotChatCenterFragment.class);
        return true;
      }
    }
    if (alof.J.equals(paramRecentUser.uin))
    {
      paramQQAppInterface = new Intent(paramActivity, QQBroadcastActivity.class);
      paramQQAppInterface.setFlags(67108864);
      paramActivity.startActivity(paramQQAppInterface);
      return true;
    }
    if (alof.ac.equals(paramRecentUser.uin))
    {
      suk.c(paramQQAppInterface, false);
      paramRecentUser = suv.a();
      if (paramRecentUser.c(paramQQAppInterface)) {
        azqs.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B70", "0X8005B70", 0, 0, paramQQAppInterface.getCurrentAccountUin(), "", "", "");
      }
      paramRecentUser.e(paramQQAppInterface, false);
      paramRecentUser.d(paramQQAppInterface, false);
      paramInt = suv.a().a(paramQQAppInterface);
      if (paramInt > 0)
      {
        azqs.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572B", "0X800572B", 0, 0, "", "", "", "");
        azqs.b(paramQQAppInterface, "CliOper", "", "", "0X8006573", "0X8006573", 0, 0, "", "", "", "");
        if (paramInt <= 0) {
          break label3764;
        }
      }
    }
    label1066:
    label3114:
    label3764:
    for (paramInt = 1;; paramInt = 0)
    {
      ThreadManager.post(new RecentUtil.1(paramQQAppInterface, paramInt), 8, null, false);
      azqs.b(paramQQAppInterface, "CliOper", "", "", "0X800623E", "0X800623E", 0, 0, "", "", "", "");
      azqs.b(paramQQAppInterface, "P_CliOper", "Grp_tribe", "", "Msglist", "Clk_tribeHelper", 0, 0, "", "", "", "");
      if (bkbq.a(paramQQAppInterface))
      {
        paramQQAppInterface = nxu.a(paramActivity, 0, 1);
        label948:
        paramQQAppInterface.putExtra("start_time", System.currentTimeMillis());
        if (paramInt == 0) {
          break label1066;
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        paramQQAppInterface.putExtra("has_red_hot", bool1);
        paramQQAppInterface.putExtra("come_from", 1);
        paramQQAppInterface.setFlags(67108864);
        paramActivity.startActivity(paramQQAppInterface);
        return true;
        azqs.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572C", "0X800572C", 0, 0, "", "", "", "");
        azqs.b(paramQQAppInterface, "CliOper", "", "", "0X8006574", "0X8006574", 0, 0, "", "", "", "");
        break;
        paramQQAppInterface = nxu.a(paramActivity, -1, 1);
        break label948;
      }
      int j;
      int i;
      if (TextUtils.equals(alof.az, paramRecentUser.uin))
      {
        if (paramRecentBaseData != null) {
          paramInt = paramRecentBaseData.mPosition;
        }
        for (;;)
        {
          localObject1 = new ArrayList();
          paramRecentBaseData = paramQQAppInterface.a();
          if (paramRecentBaseData == null) {
            break label1494;
          }
          paramRecentBaseData = paramRecentBaseData.b(paramRecentUser.uin, paramRecentUser.getType());
          if ((paramRecentBaseData == null) || (!(paramRecentBaseData instanceof MessageForStructing)) || (paramRecentBaseData.extInt != 1)) {
            break label1533;
          }
          paramRecentUser = (MessageForStructing)paramRecentBaseData;
          if (paramRecentUser.structingMsg == null) {
            paramRecentUser.parse();
          }
          if (paramRecentUser.structingMsg == null) {
            break label1356;
          }
          if (!TextUtils.isEmpty(paramRecentUser.structingMsg.mArticleIds))
          {
            localObject2 = paramRecentUser.structingMsg.mArticleIds.split("\\|");
            j = localObject2.length;
            i = 0;
            label1213:
            if (i < j)
            {
              String str2 = localObject2[i];
              try
              {
                ((ArrayList)localObject1).add(Long.valueOf(Long.parseLong(str2)));
                i += 1;
                break label1213;
                paramInt = -1;
              }
              catch (Exception localException3)
              {
                for (;;)
                {
                  localException3.printStackTrace();
                }
              }
            }
          }
        }
        if (!TextUtils.isEmpty(paramRecentUser.structingMsg.mMsgActionData))
        {
          localObject2 = syb.a(paramRecentUser.structingMsg.mMsgActionData);
          if (localObject2 == null) {}
        }
      }
      for (;;)
      {
        long l;
        try
        {
          l = Long.parseLong(((JSONObject)localObject2).getString("id"));
          if (l != -1L) {
            azqs.b(null, "CliOper", "", "", "0X80066F5", "0X80066F5", 0, 0, String.valueOf(paramInt + 1), "", String.valueOf(l), "");
          }
          syb.a(paramQQAppInterface, paramRecentUser, 1);
          label1356:
          paramQQAppInterface = "";
          paramRecentUser = paramQQAppInterface;
          if (paramRecentBaseData == null) {
            break label3752;
          }
          paramRecentUser = paramQQAppInterface;
        }
        catch (Exception localException2)
        {
          label1494:
          localException2.printStackTrace();
        }
        try
        {
          if (!(paramRecentBaseData instanceof MessageForStructing)) {
            break label3752;
          }
          paramRecentBaseData = (MessageForStructing)paramRecentBaseData;
          if (paramRecentBaseData.structingMsg.mStrategyIds != null) {
            paramQQAppInterface = paramRecentBaseData.structingMsg.mStrategyIds.split("\\|")[0];
          }
          paramRecentUser = paramQQAppInterface;
          if (paramRecentBaseData.structingMsg.mAlgorithmIds == null) {
            break label3752;
          }
          paramRecentUser = paramRecentBaseData.structingMsg.mAlgorithmIds.split("\\|")[0];
          nrt.a(null, "CliOper", "", "", "0X80066F4", "0X80066F4", 0, 0, String.valueOf(paramInt + 1), "", paramQQAppInterface, ors.b(paramRecentUser), false);
          nrt.a("0X80066F4", "", String.valueOf(paramInt + 1), "", paramQQAppInterface, ors.b(paramRecentUser));
        }
        catch (Exception paramQQAppInterface)
        {
          label1533:
          QLog.d("KandianMergeManager", 1, "failed to report new kandian click " + paramQQAppInterface.toString());
          continue;
          l = ((Long)((ArrayList)localObject1).get(0)).longValue();
          continue;
        }
        if (((ArrayList)localObject1).isEmpty())
        {
          l = -1L;
          nxu.a(paramActivity, (List)localObject1, l, 5);
          return true;
          l = -1L;
          continue;
          azqs.b(null, "CliOper", "", "", "0X80066F6", "0X80066F6", 0, 0, String.valueOf(paramInt + 1), "", "", "");
        }
        else
        {
          if (alof.au.equals(paramRecentUser.uin))
          {
            paramRecentUser = (ahcr)paramQQAppInterface.getManager(138);
            if (paramRecentUser != null)
            {
              paramRecentUser.a(paramActivity);
              paramRecentUser.b(false);
              azqs.b(paramQQAppInterface, "CliOper", "", "", "0X800618B", "0X800618B", 0, 0, "", "", "", "");
            }
            return true;
          }
          if (alof.U.equals(paramRecentUser.uin)) {
            return true;
          }
          Object localObject3;
          if (alof.W.equals(paramRecentUser.uin))
          {
            paramRecentBaseData = "1";
            localObject3 = new Intent();
            ((Intent)localObject3).putExtra("key_tab_mode", 2);
            ((Intent)localObject3).setClass(paramActivity, TroopActivity.class);
            paramInt = bafj.a().a(paramQQAppInterface);
            if (paramInt > 0)
            {
              localObject1 = "0";
              paramRecentBaseData = "0";
              paramQQAppInterface.a().d(alof.W, 9000, -paramInt);
              ((Intent)localObject3).putExtra("_key_mode", paramRecentUser.jumpTabMode);
              ((Intent)localObject3).putExtra("key_from", 2);
              if (paramInt <= 0) {
                break label1888;
              }
            }
            label1888:
            for (bool1 = true;; bool1 = false)
            {
              ((Intent)localObject3).putExtra("has_red", bool1);
              paramActivity.startActivity((Intent)localObject3);
              azqs.b(paramQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "Clk_notice", 0, 0, "", paramRecentBaseData, (String)localObject1, "");
              return true;
              paramInt = ambh.b(paramQQAppInterface);
              if (paramInt > 0)
              {
                paramRecentBaseData = "0";
                localObject1 = "1";
                break;
              }
              localObject1 = "0";
              break;
            }
          }
          if (alof.z.equals(paramRecentUser.uin))
          {
            paramRecentUser = new Intent(paramActivity, LiteActivity.class);
            paramRecentUser.putExtra("targetUin", alof.z);
            paramActivity.startActivity(paramRecentUser);
            azqs.b(paramQQAppInterface, "CliOper", "", "", "0X800603B", "0X800603B", 0, 0, "", "", "", "");
            return true;
          }
          if (alof.A.equals(paramRecentUser.uin))
          {
            paramRecentUser = new Intent(paramActivity, LiteActivity.class);
            paramRecentUser.putExtra("targetUin", alof.A);
            paramActivity.startActivity(paramRecentUser);
            azqs.b(paramQQAppInterface, "CliOper", "", "", "0X8006040", "0X8006040", 0, 0, "", "", "", "");
            return true;
          }
          if (alof.ad.equals(paramRecentUser.uin))
          {
            paramQQAppInterface = new Intent(paramActivity, ActivateFriendActivity.class);
            paramQQAppInterface.setFlags(67108864);
            if (paramInt == 0) {}
            for (paramInt = 1;; paramInt = 3)
            {
              paramQQAppInterface.putExtra("af_key_from", paramInt);
              paramActivity.startActivity(paramQQAppInterface);
              return true;
            }
          }
          Object localObject4;
          if (alof.ae.equals(paramRecentUser.uin))
          {
            paramRecentUser = new Intent(paramActivity, EcshopWebActivity.class);
            paramRecentUser.putExtra("start_time", System.currentTimeMillis());
            paramRecentUser.setFlags(67108864);
            azqs.b(paramQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Msglist", "Clk_ShopHelper", 0, 0, "", "", "", "");
            localObject1 = (ntw)paramQQAppInterface.getManager(88);
            localObject3 = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappecshopurl", "");
            if (localObject1 != null)
            {
              localObject4 = ((ntw)localObject1).a();
              if (localObject4 != null) {
                break label2381;
              }
              paramInt = 0;
              if (paramInt == 0) {
                azqs.b(paramQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_noMsglist", "Clk_ShopHelper", 0, 0, "", "", "", "");
              }
              i = ((ntw)localObject1).a(paramQQAppInterface);
              if (i <= 0) {
                break label3749;
              }
              i = 1;
            }
          }
          for (;;)
          {
            azqs.b(paramQQAppInterface, "dc00899", "Pb_account_lifeservice", "1", "0X80064CB", "0X80064CB", 0, 0, "" + i, "" + paramInt, "", "");
            if (i != 0)
            {
              bool1 = true;
              paramRecentUser.putExtra("has_red_hot", bool1);
              if (paramRecentBaseData != null) {
                break label2398;
              }
              paramInt = -1;
              ((ntw)localObject1).a(paramRecentUser, paramActivity, paramInt);
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                ((ntw)localObject1).b(paramQQAppInterface);
              }
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                break label2407;
              }
              paramActivity.startActivity(paramRecentUser);
            }
            for (;;)
            {
              return true;
              label2381:
              paramInt = ((List)localObject4).size();
              break;
              bool1 = false;
              break label2327;
              label2398:
              paramInt = paramRecentBaseData.mUnreadNum;
              break label2344;
              label2407:
              if (MiniAppLauncher.isMiniAppUrl((String)localObject3))
              {
                MiniAppLauncher.startMiniApp(paramActivity, (String)localObject3, 4003, null);
                MiniAppBusiReport.report("shopping_folder", "click", "message", String.valueOf(paramRecentBaseData.mUnreadNum));
              }
            }
            if (1012 == paramRecentUser.msgType)
            {
              paramQQAppInterface = new ProfileActivity.AllInOne(paramQQAppInterface.getCurrentAccountUin(), 0);
              paramRecentUser = new Intent(paramActivity, NearbyPeopleProfileActivity.class);
              paramRecentUser.putExtra("param_mode", 2);
              paramRecentUser.putExtra("AllInOne", paramQQAppInterface);
              paramRecentUser.putExtra("frome_where", -1);
              paramRecentUser.putExtra("abp_flag", true);
              paramRecentUser.addFlags(67108864);
              paramActivity.startActivity(paramRecentUser);
              return true;
            }
            if ((1030 == paramRecentUser.msgType) || (1035 == paramRecentUser.msgType) || (1041 == paramRecentUser.msgType) || (1042 == paramRecentUser.msgType))
            {
              if ((paramRecentBaseData instanceof RecentItemNoticeData))
              {
                paramQQAppInterface = ((RecentItemNoticeData)paramRecentBaseData).intent;
                if (paramQQAppInterface != null) {
                  paramActivity.startActivity(paramQQAppInterface);
                }
                return true;
              }
            }
            else
            {
              MessageRecord localMessageRecord;
              String str3;
              String str4;
              String str5;
              if (TextUtils.equals(alof.aA, paramRecentUser.uin))
              {
                localObject1 = paramQQAppInterface.a();
                if (localObject1 != null)
                {
                  localMessageRecord = ((QQMessageFacade)localObject1).b(paramRecentUser.uin, paramRecentUser.getType());
                  ors.a(paramQQAppInterface, localMessageRecord);
                  str3 = ors.a.b;
                  str4 = ors.a.jdField_a_of_type_JavaLangString;
                  str5 = ors.a.c;
                  paramRecentUser = (KandianMergeManager)paramQQAppInterface.getManager(162);
                  localObject1 = paramRecentUser.a();
                  if (localObject1 == null) {
                    break label3736;
                  }
                  l = ((KandianMsgBoxRedPntInfo)localObject1).mUin;
                  i = ((KandianMsgBoxRedPntInfo)localObject1).mMsgType;
                  localObject3 = String.valueOf(l);
                }
              }
              for (localObject4 = String.valueOf(i);; localObject4 = "")
              {
                label2755:
                boolean bool2;
                label2772:
                boolean bool3;
                if (paramRecentBaseData != null)
                {
                  i = paramRecentBaseData.mPosition;
                  if ((localMessageRecord == null) || (localMessageRecord.uniseq != paramRecentUser.b())) {
                    break label3108;
                  }
                  j = 1;
                  bool1 = false;
                  bool2 = false;
                  if (localMessageRecord == null) {
                    break label3114;
                  }
                  paramRecentUser = localMessageRecord.senderuin;
                  localObject1 = paramRecentUser;
                  if (localMessageRecord != null) {
                    bool3 = bool1;
                  }
                }
                for (;;)
                {
                  try
                  {
                    JSONObject localJSONObject = new JSONObject(localMessageRecord.extStr);
                    bool3 = bool1;
                    if (!localJSONObject.has("kdShouldShowMergedAvatar")) {
                      continue;
                    }
                    bool3 = bool1;
                    if (!localJSONObject.getBoolean("kdShouldShowMergedAvatar")) {
                      continue;
                    }
                    bool3 = bool1;
                    if (localMessageRecord.isread) {
                      continue;
                    }
                    bool1 = true;
                    localObject1 = paramRecentUser;
                    bool2 = bool1;
                    bool3 = bool1;
                    if (localJSONObject.has("kdUin"))
                    {
                      bool3 = bool1;
                      localObject1 = localJSONObject.getString("kdUin");
                      bool2 = bool1;
                    }
                    paramRecentUser = (RecentUser)localObject1;
                  }
                  catch (Exception localException1)
                  {
                    localException1.printStackTrace();
                    bool2 = bool3;
                    continue;
                    String str1 = "";
                    continue;
                    paramRecentUser = "";
                    continue;
                    paramRecentUser = "";
                    continue;
                    bool1 = false;
                    continue;
                    paramInt = 5;
                    continue;
                  }
                  if (paramInt != 1)
                  {
                    if (j == 0) {
                      continue;
                    }
                    localObject1 = "1";
                    nrt.a(null, "CliOper", "", paramRecentUser, "0X80066F4", "0X80066F4", 0, 0, String.valueOf(i + 1), str5, str3, ors.a(str4, (String)localObject4, (String)localObject1, (String)localObject3, bool2), false);
                    nrt.a("0X80066F4", paramRecentUser, String.valueOf(i + 1), "", str3, ors.a(str4, (String)localObject4));
                    ors.a(21, str5, str3, str4, paramRecentUser, -1);
                  }
                  if (paramRecentBaseData == null) {
                    continue;
                  }
                  if (paramRecentBaseData.mLastMsg == null) {
                    continue;
                  }
                  paramRecentUser = paramRecentBaseData.mLastMsg.toString();
                  paramRecentUser = new StringBuilder().append("enter kandianMergeBox, brief : ").append(ors.c(paramRecentUser)).append(",isUnRead : ");
                  if ((paramRecentBaseData == null) || (paramRecentBaseData.mUnreadNum == 0)) {
                    continue;
                  }
                  bool1 = true;
                  QLog.d("KandianMergeManager", 1, bool1);
                  if (paramInt != 1) {
                    continue;
                  }
                  paramInt = 9;
                  nxu.a(paramQQAppInterface, paramActivity, paramInt, 0);
                  syp.a(null, "KANDIAN_FEEDS_STAGE_1_COST");
                  syp.a(null, "KANDIAN_FEEDS_COST");
                  syp.a(null, "KANDIAN_NEW_FEEDS_ACTIVITY_MANAGER");
                  return true;
                  i = -1;
                  break;
                  j = 0;
                  break label2755;
                  paramRecentUser = "";
                  break label2772;
                  bool1 = false;
                }
                if (alof.aB.equals(paramRecentUser.uin))
                {
                  syb.a(paramQQAppInterface, paramActivity, paramRecentUser, paramInt, paramRecentBaseData);
                  syp.a(null, "SERVICE_FOLDER_COST");
                  return true;
                }
                if (alof.aE.equals(paramRecentUser.uin))
                {
                  ((bckr)paramQQAppInterface.getManager(183)).a(paramActivity);
                  return true;
                }
                if (alof.aN.equals(paramRecentUser.uin))
                {
                  ConfessMsgListFragment.a(paramActivity, 1);
                  azqs.b(paramQQAppInterface, "dc00898", "", "", "0X8008F4C", "0X8008F4C", 0, 0, "", "", "", "");
                  return true;
                }
                if (alof.aQ.equals(paramRecentUser.uin))
                {
                  tch.a(paramActivity, "from_home_page", 1, true);
                  return true;
                }
                if (alof.aV.equals(paramRecentUser.uin))
                {
                  syb.a(paramActivity, paramQQAppInterface);
                  return true;
                }
                if (alof.aR.equals(paramRecentUser.uin))
                {
                  paramQQAppInterface = paramQQAppInterface.a().b(paramRecentUser.uin, paramRecentUser.getType());
                  if (paramQQAppInterface != null) {
                    opw.a(paramQQAppInterface);
                  }
                  if (paramRecentBaseData.mUnreadNum > 0) {}
                  for (paramInt = 1;; paramInt = 3)
                  {
                    KandianSubscribeManager.a(paramActivity, paramInt);
                    return true;
                  }
                }
                if ((TextUtils.equals(paramRecentUser.uin, "2290230341")) && (QZoneMsgActivity.a(paramActivity, paramQQAppInterface))) {
                  return true;
                }
                if (alof.aS.equals(paramRecentUser.uin))
                {
                  paramRecentUser = paramQQAppInterface.a().b(paramRecentUser.uin, paramRecentUser.getType());
                  if (paramInt == 1)
                  {
                    ors.h();
                    paramActivity.startActivity(ReadInJoyLockScreenJumpDelegate.a(paramActivity, 9, ((KandianDailyManager)paramQQAppInterface.getManager(296)).b()));
                  }
                  for (;;)
                  {
                    return true;
                    if (paramRecentUser != null)
                    {
                      opt.a(paramRecentUser);
                      KandianDailyManager.a(paramActivity);
                    }
                  }
                }
                if (("2747277822".equals(paramRecentUser.uin)) && (asnk.a()))
                {
                  paramRecentUser = new Intent();
                  paramRecentUser.putExtra("settingInfo", "");
                  paramRecentUser.putExtra("big_brother_source_key", "biz_src_zf_games");
                  paramRecentUser.putExtra("moduleId", "cmshowgame_module");
                  paramRecentUser.putExtra("startTime", System.currentTimeMillis());
                  if (asnk.b())
                  {
                    PublicFragmentActivityForTool.b(paramActivity, paramRecentUser, QQGameFeedWebFragment.class, 10000);
                    asnm.a();
                  }
                  for (;;)
                  {
                    paramQQAppInterface.a().a("2747277822", 1008, false);
                    b(paramQQAppInterface, "2747277822", 1008);
                    if (asmu.a())
                    {
                      paramQQAppInterface = (asmu)paramQQAppInterface.getManager(358);
                      if (paramQQAppInterface.jdField_a_of_type_Boolean)
                      {
                        paramActivity = paramQQAppInterface.a();
                        paramQQAppInterface = "";
                        if (paramActivity != null) {
                          paramQQAppInterface = paramActivity.d();
                        }
                        bkjb.a().a(paramQQAppInterface, "1", "145", "920", "92003", "206346", "0", "0", "20", "0");
                      }
                    }
                    return true;
                    PublicFragmentActivity.a(paramActivity, paramRecentUser, QQGamePubAccountFragment.class, 10000);
                  }
                }
                if (TextUtils.equals("3046055438", paramRecentUser.uin))
                {
                  nur.a(paramQQAppInterface, paramActivity, paramRecentUser.uin, paramActivity.getResources().getString(2131692016));
                  nur.a(paramQQAppInterface, "qgg.push.click");
                  paramQQAppInterface.a().a("3046055438", 1008, false);
                  return true;
                }
                return false;
                localObject3 = "";
              }
            }
            return true;
          }
          paramRecentBaseData = "";
          paramQQAppInterface = paramRecentUser;
          paramRecentUser = paramRecentBaseData;
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        paramQQAppInterface = (alto)paramQQAppInterface.getManager(51);
        if (paramQQAppInterface != null) {
          break label35;
        }
      }
    }
    label35:
    for (bool1 = false;; bool1 = paramQQAppInterface.b(paramString)) {
      return bool1;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {}
    do
    {
      long l;
      do
      {
        do
        {
          return;
        } while (paramQQAppInterface.a().a(paramString, paramInt) <= 0);
        l = paramQQAppInterface.a().a(paramString, paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.sendReadConfirm_PB", 2, String.format("RecentUtil,uin: %s, uinType: %d, id: %d", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(l) }));
        }
      } while (l == -1L);
      String str = abti.b(paramInt);
      paramQQAppInterface.a().a(str).a(paramString, paramInt, l);
    } while (!asmu.a());
    ((asmu)paramQQAppInterface.getManager(358)).a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlb
 * JD-Core Version:    0.7.0.1
 */