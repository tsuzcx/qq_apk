import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.home.Conversation;
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
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.confess.ConfessMsgListFragment;
import com.tencent.mobileqq.config.business.QQComicConfBean;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper;
import com.tencent.mobileqq.mini.report.MiniAppBusiReport;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountHelper;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.thread.SuspendThreadManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.ContactUtils;
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
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public final class akms
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
    if ((paramRecentUser == null) || (paramActivity == null) || (paramQQAppInterface == null))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "onRecentUserClick|[" + paramRecentUser + "," + paramActivity + "," + paramQQAppInterface + "]");
      }
      return 0;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onRecentUserClick|[" + paramRecentUser.uin + "," + paramRecentUser.getType() + "]");
    }
    boolean bool;
    int i;
    if ((paramInt == 0) || (paramInt == 2))
    {
      bool = true;
      a(paramQQAppInterface, paramRecentUser, paramString, paramInt, paramRecentBaseData);
      i = j;
      if (!a(paramActivity, paramQQAppInterface, paramRecentUser, paramInt, paramRecentBaseData))
      {
        if (paramRecentUser.getType() != 8999) {
          break label191;
        }
        i = j;
      }
    }
    for (;;)
    {
      b(paramQQAppInterface, paramRecentUser);
      return i;
      bool = false;
      break;
      label191:
      if (paramRecentUser.getType() == 7000)
      {
        a(paramActivity, paramQQAppInterface, paramRecentUser, paramRecentBaseData);
        i = j;
      }
      else
      {
        if ((paramRecentUser.getType() != 1000) && (paramRecentUser.getType() != 1020) && (paramRecentUser.getType() != 1004) && (paramRecentUser.getType() != 10010)) {
          break label273;
        }
        i = a(paramActivity, paramQQAppInterface, paramRecentUser, paramString, paramBoolean, 0, bool);
      }
    }
    label273:
    if ((paramRecentUser.getType() == 1005) || (paramRecentUser.getType() == 1023))
    {
      if (!a(paramQQAppInterface, paramRecentUser.uin)) {
        break label650;
      }
      paramRecentUser.setType(0);
      if (!paramBoolean) {
        break label650;
      }
    }
    label650:
    for (paramInt = 2;; paramInt = 0)
    {
      i = paramInt | a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType(), paramString, bool);
      break;
      if (paramRecentUser.getType() == 1024)
      {
        i = 0x0 | a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType(), paramString, bool);
        break;
      }
      if (paramRecentUser.getType() == 6002)
      {
        paramString = (aara)paramQQAppInterface.getBusinessHandler(51);
        paramString.a(paramActivity, paramString.a(Long.parseLong(paramRecentUser.uin)), false);
        i = j;
        break;
      }
      if (paramRecentUser.getType() == 10005)
      {
        b(paramQQAppInterface, paramRecentUser.uin, 10005);
        paramQQAppInterface.getMessageFacade().setReaded(paramRecentUser.uin, 10005, true, true);
        aukx.a().a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType());
        i = j;
        break;
      }
      if (paramRecentUser.lFlag == 16L)
      {
        b(paramQQAppInterface, paramRecentUser.uin, 1008);
        paramQQAppInterface.getMessageFacade().setReaded(paramRecentUser.uin, 1008, true, true);
        a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType());
        i = j;
        break;
      }
      if (paramRecentUser.getType() == 6004)
      {
        a(paramActivity, paramQQAppInterface, paramRecentUser);
        i = j;
        break;
      }
      if (paramRecentUser.getType() == 8114)
      {
        LoginUserGuideHelper.a(paramActivity, paramQQAppInterface);
        bcef.b(paramQQAppInterface, "dc00898", "", "", "0X8009F4C", "0X8009F4C", 0, 0, "", "", "", "");
        i = j;
        break;
      }
      if (a(paramQQAppInterface, paramRecentUser)) {
        return 4;
      }
      i = a(paramQQAppInterface, paramRecentUser, paramBoolean, 0) | a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType(), paramString, bool, paramBundle, paramArrayOfIntent);
      break;
    }
  }
  
  private static int a(Activity paramActivity, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (a(paramQQAppInterface, paramRecentUser.uin))
    {
      paramRecentUser.setType(0);
      if (paramBoolean1) {
        paramInt = 2;
      }
      int i = a(paramActivity, paramQQAppInterface, String.valueOf(paramRecentUser.uin), paramRecentUser.getType(), paramString, paramBoolean2);
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "from_enterchat");
      }
      return paramInt | i;
    }
    if ((paramRecentUser.troopUin == null) || (paramRecentUser.troopUin.trim().length() == 0))
    {
      paramQQAppInterface = (RecentUser)paramQQAppInterface.getProxyManager().a().findRecentUser(paramRecentUser.uin, 1);
      if (paramQQAppInterface != null) {
        paramRecentUser.troopUin = paramQQAppInterface.troopUin;
      }
    }
    a(paramActivity, paramRecentUser.uin, paramRecentUser.troopUin, paramRecentUser.getType(), paramString, paramBoolean2);
    return paramInt;
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
    bfzg.a(null, "Recent_clk_enterchat");
    SuspendThreadManager.a().c();
    int i = 0;
    Intent localIntent = new Intent();
    if ((paramArrayOfIntent != null) && (paramArrayOfIntent.length != 0)) {
      paramArrayOfIntent[0] = localIntent;
    }
    paramBundle = a(paramContext, paramBundle, localIntent);
    if ((paramInt == 0) || (paramInt == 1024))
    {
      if ((paramInt != 1024) && (!npt.c(paramQQAppInterface, paramString1))) {
        break label290;
      }
      bfzg.a(null, "Recent_clk_enterchat_cmr");
      bcef.b(paramQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, paramString1, "0", "", "");
      bfzg.a("Recent_clk_enterchat_cmr", null);
      i = 0;
    }
    for (;;)
    {
      paramBundle.putExtra("uin", paramString1);
      paramBundle.putExtra("uintype", paramInt);
      paramBundle.putExtra("uinname", paramString2);
      paramBundle.putExtra("entrance", 1);
      a(paramBundle);
      if (paramBoolean) {
        a(paramContext, paramBundle);
      }
      for (;;)
      {
        bfzg.a("Recent_clk_enterchat", null);
        do
        {
          do
          {
            return i;
            if (paramInt != 1) {
              break;
            }
            bfzg.a(null, "Recent_clk_enterchat_troop");
          } while (a(paramQQAppInterface, paramString1, 0, paramBundle));
          i = 1;
          bfzg.a("Recent_clk_enterchat_troop", null);
          break;
          if (paramInt != 1008) {
            break label256;
          }
          bfzg.a(null, "Recent_clk_enterchat_pub");
        } while (a(paramContext, paramQQAppInterface, paramString1, 0, paramBundle));
        paramBoolean = false;
        bfzg.a("Recent_clk_enterchat_pub", null);
        i = 0;
        break;
        label256:
        if (paramInt != 9501) {
          break label290;
        }
        paramBoolean = a(paramContext, paramQQAppInterface, paramString1, paramString2, paramBundle);
        i = 0;
        break;
        paramContext.startActivity(paramBundle);
      }
      label290:
      i = 0;
    }
  }
  
  private static int a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, boolean paramBoolean, int paramInt)
  {
    int i = paramInt;
    if (a(paramQQAppInterface, paramRecentUser.uin))
    {
      i = paramInt;
      if (1 != paramRecentUser.getType())
      {
        i = paramInt;
        if (3000 != paramRecentUser.getType())
        {
          i = paramInt;
          if (paramRecentUser.getType() != 0)
          {
            paramRecentUser.setType(0);
            i = paramInt;
            if (paramBoolean) {
              i = 2;
            }
          }
        }
      }
    }
    return i;
  }
  
  @NotNull
  private static Intent a(Context paramContext, Bundle paramBundle, Intent paramIntent)
  {
    long l;
    if (jdField_a_of_type_Boolean)
    {
      paramIntent.setClassName(paramContext, ChatActivity.class.getName());
      if (jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
        if ((jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 1) || (jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 3000))
        {
          l = jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq;
          paramIntent.putExtra("searched_timeorseq", l);
          paramContext = paramIntent;
        }
      }
    }
    for (;;)
    {
      if (paramBundle != null) {
        paramContext.putExtras(paramBundle);
      }
      return paramContext;
      l = jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
      break;
      paramContext = paramIntent;
      if (jdField_a_of_type_Long != 0L)
      {
        paramIntent.putExtra("searched_timeorseq", jdField_a_of_type_Long);
        paramContext = paramIntent;
        continue;
        String str1 = null;
        if (paramBundle != null) {
          str1 = paramBundle.getString("KEY_OPEN_AIO_INTENT_CLASS_NAME");
        }
        String str2 = str1;
        if (TextUtils.isEmpty(str1)) {
          str2 = SplashActivity.class.getName();
        }
        paramIntent.setClassName(paramContext, str2);
        paramContext = AIOUtils.setOpenAIOIntent(paramIntent, new int[] { 1 });
      }
    }
  }
  
  private static void a(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, ActivateFriendActivity.class);
    localIntent.setFlags(67108864);
    if (paramInt == 0) {}
    for (paramInt = 1;; paramInt = 3)
    {
      localIntent.putExtra("af_key_from", paramInt);
      paramActivity.startActivity(localIntent);
      return;
    }
  }
  
  private static void a(Activity paramActivity, RecentBaseData paramRecentBaseData)
  {
    if ((paramRecentBaseData instanceof RecentItemNoticeData))
    {
      paramRecentBaseData = ((RecentItemNoticeData)paramRecentBaseData).intent;
      if (paramRecentBaseData != null) {
        paramActivity.startActivity(paramRecentBaseData);
      }
    }
  }
  
  private static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    oidb_0x791.RedDotInfo localRedDotInfo = ((nmq)paramQQAppInterface.getManager(70)).a(46, false);
    if ((localRedDotInfo != null) && (localRedDotInfo.uint32_number.has()))
    {
      i = localRedDotInfo.uint32_number.get();
      if ((localRedDotInfo == null) || (localRedDotInfo.bool_display_reddot.get())) {}
    }
    for (;;)
    {
      try
      {
        if (!localRedDotInfo.str_custom_buffer.has()) {
          continue;
        }
        localObject = localRedDotInfo.str_custom_buffer.get().toStringUtf8();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        localObject = new JSONObject((String)localObject);
        if (localRedDotInfo.uint32_last_time.has()) {
          ((JSONObject)localObject).put("lastTime", localRedDotInfo.uint32_last_time.get());
        }
        ((JSONObject)localObject).put("lastMsg", ((JSONObject)localObject).get("msg"));
        localObject = ((JSONObject)localObject).toString();
        localRedDotInfo.str_custom_buffer.set(ByteStringMicro.copyFromUtf8((String)localObject));
        nmj.a(paramQQAppInterface, localRedDotInfo, 0, true);
      }
      catch (Exception localException)
      {
        Object localObject;
        localException.printStackTrace();
        continue;
        if (i <= 99) {
          continue;
        }
        paramRecentUser = paramRecentUser + "(99+)";
        continue;
        paramRecentUser = paramRecentUser + "(" + i + ")";
        continue;
        paramRecentUser = null;
        continue;
      }
      if (i <= 0) {
        continue;
      }
      a(paramQQAppInterface, paramRecentUser, true, true);
      i = paramQQAppInterface.getMessageFacade().getUnreadMsgsNum();
      paramRecentUser = amtj.a(2131712330);
      if (i > 0) {
        continue;
      }
      localObject = new Intent(paramActivity, QQBrowserActivity.class);
      if (!TextUtils.isEmpty(paramRecentUser)) {
        ((Intent)localObject).putExtra("selfSet_leftViewText", paramRecentUser);
      }
      ((Intent)localObject).putExtra("is_wrap_content", true);
      ((Intent)localObject).putExtra("url", "https://docs.qq.com/components/Notifications.html?_wv=3");
      ((Intent)localObject).putExtra("hide_more_button", true);
      ((Intent)localObject).putExtra("webStyle", "noBottomBar");
      ((Intent)localObject).putExtra("isScreenOrientationPortrait", true);
      ((Intent)localObject).putExtra("title", paramQQAppInterface.getApp().getString(2131718916));
      ((Intent)localObject).addFlags(603979776);
      paramActivity.startActivity((Intent)localObject);
      return;
      i = 0;
      break;
      localObject = null;
      continue;
      localObject = new JSONObject();
    }
  }
  
  private static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, RecentBaseData paramRecentBaseData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "RecentUtil.onRecentUserClick. r.uin=" + paramRecentUser.uin + " r.type=" + paramRecentUser.getType());
    }
    String str = paramRecentUser.uin;
    if ((paramRecentBaseData instanceof RecentItemSubAccount)) {
      str = ((RecentItemSubAccount)paramRecentBaseData).showSubUin;
    }
    paramRecentBaseData = str;
    if (str == null) {
      paramRecentBaseData = "";
    }
    bcqj.a(paramQQAppInterface, paramActivity, paramRecentBaseData);
    paramQQAppInterface.getMessageFacade().setReaded(paramRecentUser.uin, paramRecentUser.getType());
    if (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramRecentUser.uin)) {}
    for (paramActivity = null;; paramActivity = paramRecentUser.uin)
    {
      bcef.b(paramQQAppInterface, "CliOper", "", paramActivity, "Bind_account", "Clk_bind_account", 0, 0, "", "", "", "");
      bcef.b(paramQQAppInterface, "CliOper", "", "", "0X800713E", "0X800713E", 0, 0, "", "", "", "");
      return;
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
    nxz localnxz;
    nxq localnxq;
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
        localnxz = nxz.a();
        localObject = localnxz.a(paramString);
        if (localObject != null)
        {
          a(paramContext, paramQQAppInterface, paramString, paramInt, (nxq)localObject);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("RecentUtil", 2, "openAdvertisement item recreate, uin:" + paramString);
        }
        localObject = paramQQAppInterface.getMessageFacade().getMsgList(paramString, paramInt).iterator();
      }
      localnxq = nyj.a(paramQQAppInterface, (MessageRecord)((Iterator)localObject).next(), true);
    } while (localnxq == null);
    localnxz.a(localnxq);
    a(paramContext, paramQQAppInterface, paramString, paramInt, localnxq);
  }
  
  private static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt, nxq paramnxq)
  {
    Intent localIntent = new Intent(paramContext, PublicAccountAdvertisementActivity.class);
    localIntent.putExtra("arg_ad_json", paramnxq.a());
    localIntent.putExtra("USR_CLICK_TIME", SystemClock.uptimeMillis());
    localIntent.putExtra("is_first_open_imax_ad", c);
    c = false;
    paramContext.startActivity(localIntent);
    ThreadManager.post(new RecentUtil.7(paramQQAppInterface, paramString, paramInt, paramnxq), 5, null, false);
    nxz.a().a(paramQQAppInterface, 2, paramnxq);
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
        break label143;
      }
      localIntent = new Intent(paramContext, ChatActivity.class);
      if (jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
        break label176;
      }
      if ((jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop != 1) && (jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop != 3000)) {
        break label132;
      }
      l = jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq;
      localIntent.putExtra("searched_timeorseq", l);
    }
    label132:
    label143:
    label176:
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
        localIntent = AIOUtils.setOpenAIOIntent(new Intent(paramContext, SplashActivity.class), new int[] { 1 });
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
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (nmj)paramQQAppInterface.getBusinessHandler(43);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.b(46);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    atzd.b(paramActivity);
    paramQQAppInterface.getConversationFacade().a("2747277822", 1008, false);
    b(paramQQAppInterface, "2747277822", 1008);
    int i;
    if (atyd.a())
    {
      paramActivity = (atyd)paramQQAppInterface.getManager(358);
      if (paramActivity.b)
      {
        GameCenterSessionInfo localGameCenterSessionInfo = paramActivity.a();
        if (localGameCenterSessionInfo == null) {
          break label139;
        }
        paramQQAppInterface = localGameCenterSessionInfo.e();
        i = localGameCenterSessionInfo.a();
      }
    }
    for (;;)
    {
      if (paramActivity.c() > 0) {}
      for (paramActivity = "0";; paramActivity = "1")
      {
        atyf.a(paramQQAppInterface, "1", "145", "920", "92003", "206346", paramActivity, i + "", "0", "20", "0", "", "");
        return;
      }
      label139:
      i = -1;
      paramQQAppInterface = "";
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentBaseData paramRecentBaseData)
  {
    Intent localIntent = new Intent(paramActivity, EcshopWebActivity.class);
    localIntent.putExtra("start_time", System.currentTimeMillis());
    localIntent.setFlags(67108864);
    bcef.b(paramQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Msglist", "Clk_ShopHelper", 0, 0, "", "", "", "");
    ofx localofx = (ofx)paramQQAppInterface.getManager(88);
    String str = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappecshopurl", "");
    List localList;
    int i;
    int j;
    if (localofx != null)
    {
      localList = localofx.a();
      if (localList != null) {
        break label283;
      }
      i = 0;
      if (i == 0) {
        bcef.b(paramQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_noMsglist", "Clk_ShopHelper", 0, 0, "", "", "", "");
      }
      j = localofx.a(paramQQAppInterface);
      if (j <= 0) {
        break label347;
      }
      j = 1;
    }
    label283:
    label300:
    label308:
    label347:
    for (;;)
    {
      bcef.b(paramQQAppInterface, "dc00899", "Pb_account_lifeservice", "1", "0X80064CB", "0X80064CB", 0, 0, "" + j, "" + i, "", "");
      boolean bool;
      if (j != 0)
      {
        bool = true;
        label228:
        localIntent.putExtra("has_red_hot", bool);
        if (paramRecentBaseData != null) {
          break label300;
        }
        i = -1;
        label245:
        localofx.a(localIntent, paramActivity, i);
        if (!TextUtils.isEmpty(str)) {
          localofx.b(paramQQAppInterface);
        }
        if (!TextUtils.isEmpty(str)) {
          break label308;
        }
        paramActivity.startActivity(localIntent);
      }
      while (!MiniAppLauncher.isMiniAppUrl(str))
      {
        return;
        i = localList.size();
        break;
        bool = false;
        break label228;
        i = paramRecentBaseData.mUnreadNum;
        break label245;
      }
      MiniAppLauncher.startMiniApp(paramActivity, str, 4003, null);
      MiniAppBusiReport.report("shopping_folder", "click", "message", String.valueOf(paramRecentBaseData.mUnreadNum));
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_tab_mode", 2);
    localIntent.setClass(paramActivity, TroopActivity.class);
    int i = bcsz.a().a(paramQQAppInterface);
    String str1;
    String str2;
    if (i > 0)
    {
      str1 = "0";
      str2 = "0";
      paramQQAppInterface.getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, -i);
      bcef.b(null, "dc00898", "", "", "0X800B527", "0X800B527", 0, 0, "", "", null, null);
      if (i > 0) {
        bcef.b(null, "dc00898", "", "", "0X800B529", "0X800B529", 0, 0, "", "", null, null);
      }
      if (ailu.a())
      {
        ailu.a(false);
        ailu.a();
        localIntent.putExtra("show_type", true);
        bcef.b(null, "dc00898", "", "", "0X800B52D", "0X800B52D", 0, 0, "", "", null, null);
      }
      localIntent.putExtra("_key_mode", paramRecentUser.jumpTabMode);
      localIntent.putExtra("key_from", 2);
      if (i <= 0) {
        break label272;
      }
    }
    label272:
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("has_red", bool);
      paramActivity.startActivity(localIntent);
      bcef.b(paramQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "Clk_notice", 0, 0, "", str1, str2, "");
      return;
      i = amzp.b(paramQQAppInterface);
      if (i > 0)
      {
        str1 = "0";
        str2 = "1";
        break;
      }
      str1 = "1";
      str2 = "0";
      break;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, int paramInt)
  {
    paramRecentUser = paramQQAppInterface.getMessageFacade().getLastMsgForMsgTab(paramRecentUser.uin, paramRecentUser.getType());
    if (paramInt == 1)
    {
      paramQQAppInterface = (KandianDailyManager)paramQQAppInterface.getManager(296);
      pay.a(paramQQAppInterface.a());
      paramActivity.startActivity(ReadInJoyLockScreenJumpDelegate.a(paramActivity, 9, paramQQAppInterface.b()));
    }
    while (paramRecentUser == null) {
      return;
    }
    ozh.a(paramRecentUser);
    KandianDailyManager.a(paramActivity);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, int paramInt, RecentBaseData paramRecentBaseData)
  {
    ugf.a(paramQQAppInterface, paramActivity, paramRecentUser, paramInt, paramRecentBaseData);
    ugt.a(null, "SERVICE_FOLDER_COST");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, RecentBaseData paramRecentBaseData)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().getLastMsgForMsgTab(paramRecentUser.uin, paramRecentUser.getType());
    if (paramQQAppInterface != null) {
      ozk.a(paramQQAppInterface);
    }
    if (paramRecentBaseData.mUnreadNum > 0) {}
    for (int i = 1;; i = 3)
    {
      KandianSubscribeManager.a(paramActivity, i);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    if (paramRecentUser.getType() == 5000) {}
    for (;;)
    {
      bcef.b(paramQQAppInterface, "CliOper", "", "", "0X800419C", "0X800419C", 0, 0, "", "", "", "");
      bcef.b(paramQQAppInterface, "CliOper", "", "", "0X80041A0", "0X80041A0", 0, 0, "", "", "", "");
      return;
      if ((paramRecentUser.getType() == 7200) || (paramRecentUser.getType() == 1008))
      {
        bcef.b(paramQQAppInterface, "CliOper", "", "", "0X80041A1", "0X80041A1", 0, 0, "", "", "", "");
        if (paramRecentUser.getType() == 1008) {
          a(paramQQAppInterface, paramRecentUser.uin, 1);
        }
      }
      else if (String.valueOf(9992L).equals(paramRecentUser.uin))
      {
        bcef.b(paramQQAppInterface, "CliOper", "", "", "0X800419F", "0X800419F", 0, 0, "", "", "", "");
      }
      else if (((paramRecentUser.getType() == 1001) || (paramRecentUser.getType() == 10002)) && (AppConstants.LBS_HELLO_UIN.equals(paramRecentUser.uin)))
      {
        bcef.b(paramQQAppInterface, "CliOper", "", "", "0X80041A2", "0X80041A2", 0, 0, "", "", "", "");
        bcef.b(paramQQAppInterface, "CliOper", "", "", "0X80050FD", "0X80050FD", 0, 0, "", "", "", "");
        bcef.b(paramQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "drag_msg", 0, 0, "", "", "", "");
      }
      else if ((paramRecentUser.getType() == 1010) && (AppConstants.DATE_UIN.equals(paramRecentUser.uin)))
      {
        bcef.b(paramQQAppInterface, "CliOper", "", "", "0X80050FF", "0X80050FF", 0, 0, "", "", "", "");
      }
      else if ((paramRecentUser.getType() == 1009) && (AppConstants.SAME_STATE_BOX_UIN.equals(paramRecentUser.uin)))
      {
        bcef.b(paramQQAppInterface, "CliOper", "", "", "0X80041A4", "0X80041A4", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramRecentUser == null)) {
      return;
    }
    paramQQAppInterface.getProxyManager().a().delRecentUser(paramRecentUser, false);
    if (abwz.b(paramRecentUser.uin, paramRecentUser.getType())) {
      if ((AppConstants.DATE_UIN.equals(paramRecentUser.uin)) || (AppConstants.LBS_HELLO_UIN.equals(paramRecentUser.uin)))
      {
        Object localObject = paramQQAppInterface.getMessageFacade().getLastMessage(paramRecentUser.uin, paramRecentUser.getType());
        if (localObject != null) {
          paramQQAppInterface.getConversationFacade().a(paramRecentUser.getType(), ((QQMessageFacade.Message)localObject).time);
        }
        localObject = paramRecentUser.uin;
        int i = paramRecentUser.getType();
        ThreadManager.post(new RecentUtil.3((MessageHandler)paramQQAppInterface.getBusinessHandler(0), (String)localObject, i), 8, null, false);
      }
    }
    for (;;)
    {
      paramQQAppInterface.getMessageFacade().setReaded(paramRecentUser.uin, paramRecentUser.getType(), true, true);
      b(paramQQAppInterface, paramRecentUser, paramInt);
      e(paramQQAppInterface, paramRecentUser);
      d(paramQQAppInterface, paramRecentUser);
      return;
      if ((1032 != paramRecentUser.getType()) || (!AppConstants.CONFESS_UIN.equals(paramRecentUser.uin))) {
        break;
      }
      paramQQAppInterface.getConversationFacade().b();
      apse.b(paramQQAppInterface, false);
      apse.a(paramQQAppInterface, false);
      break;
      b(paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType());
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, String paramString, int paramInt, RecentBaseData paramRecentBaseData)
  {
    if ((paramRecentBaseData != null) && (paramInt == 0) && (paramRecentUser.uin != null) && ((paramRecentUser.getType() == 1008) || (paramRecentUser.getType() == 7220)))
    {
      akmc.a(paramQQAppInterface, paramRecentUser.uin, paramRecentBaseData.mUnreadFlag, paramRecentBaseData.getUnreadNum(), 1, paramString);
      if ((paramRecentUser.getType() == 7220) || (AppConstants.KANDIAN_MERGE_UIN.equalsIgnoreCase(paramRecentBaseData.getRecentUserUin())) || (AppConstants.WEISHI_UIN.equalsIgnoreCase(paramRecentBaseData.getRecentUserUin())) || ("2290230341".equalsIgnoreCase(paramRecentBaseData.getRecentUserUin()))) {
        akmc.a.add(new akmh(paramRecentUser.uin, paramString, System.currentTimeMillis()));
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, boolean paramBoolean)
  {
    if (paramRecentUser.getType() == 5000) {
      f(paramQQAppInterface);
    }
    do
    {
      return;
      if (5001 == paramRecentUser.getType())
      {
        e(paramQQAppInterface);
        return;
      }
      if (AppConstants.RECOMMEND_CONTACT_UIN.equals(paramRecentUser.uin))
      {
        ((aiej)paramQQAppInterface.getManager(34)).f();
        return;
      }
      if (String.valueOf(9980L).equals(paramRecentUser.uin))
      {
        paramQQAppInterface.getMsgHandler().a().c();
        bcsz.a().a(paramQQAppInterface, 0);
        ((amzp)paramQQAppInterface.getManager(22)).b();
        return;
      }
      if (paramRecentUser.getType() == 7210)
      {
        c(paramQQAppInterface);
        return;
      }
      if (paramRecentUser.getType() == 7120)
      {
        d(paramQQAppInterface);
        return;
      }
      if (paramRecentUser.getType() == 7220)
      {
        ((KandianMergeManager)paramQQAppInterface.getManager(162)).c();
        return;
      }
      if (1001 == paramRecentUser.getType())
      {
        paramQQAppInterface.getInterFollowMgr().clearMsgBoxUnreadCount();
        return;
      }
      if (paramRecentUser.lFlag == 16L)
      {
        a(paramQQAppInterface, paramRecentUser, paramBoolean, 1008);
        return;
      }
      if (paramRecentUser.getType() == 10005)
      {
        a(paramQQAppInterface, paramRecentUser, paramBoolean, 10005);
        return;
      }
      if (paramRecentUser.getType() == 6004)
      {
        a(paramQQAppInterface);
        return;
      }
    } while (!"2747277822".equals(paramRecentUser.uin));
    b(paramQQAppInterface);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, boolean paramBoolean, int paramInt)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.curType = paramInt;
    paramRecentUser = paramRecentUser.uin;
    localSessionInfo.troopUin = paramRecentUser;
    localSessionInfo.curFriendUin = paramRecentUser;
    acvv.a(paramQQAppInterface, localSessionInfo);
    paramQQAppInterface.getMessageFacade().setReaded(localSessionInfo.curFriendUin, 1008, true, paramBoolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramQQAppInterface == null) || (paramRecentUser == null)) {
      return;
    }
    c(paramQQAppInterface, paramRecentUser);
    Object localObject;
    if (abwz.b(paramRecentUser.uin, paramRecentUser.getType())) {
      if ((AppConstants.DATE_UIN.equals(paramRecentUser.uin)) || (AppConstants.LBS_HELLO_UIN.equals(paramRecentUser.uin)))
      {
        localObject = paramQQAppInterface.getMessageFacade().getLastMessage(paramRecentUser.uin, paramRecentUser.getType());
        if (localObject != null) {
          paramQQAppInterface.getConversationFacade().a(paramRecentUser.getType(), ((QQMessageFacade.Message)localObject).time);
        }
        localObject = paramRecentUser.uin;
        int i = paramRecentUser.getType();
        paramQQAppInterface.getMessageFacade().setBoxReaded((String)localObject, i);
        ThreadManager.post(new RecentUtil.2((MessageHandler)paramQQAppInterface.getBusinessHandler(0), (String)localObject, i), 8, null, false);
      }
    }
    for (;;)
    {
      a(paramQQAppInterface, paramRecentUser, paramBoolean2);
      return;
      if ((1032 != paramRecentUser.getType()) || (!AppConstants.CONFESS_UIN.equals(paramRecentUser.uin))) {
        break;
      }
      paramQQAppInterface.getConversationFacade().b();
      apse.b(paramQQAppInterface, false);
      apse.a(paramQQAppInterface, false);
      break;
      if (paramBoolean1)
      {
        localObject = new SessionInfo();
        ((SessionInfo)localObject).curFriendUin = paramRecentUser.uin;
        ((SessionInfo)localObject).troopUin = paramRecentUser.uin;
        ((SessionInfo)localObject).curType = paramRecentUser.getType();
        if (((SessionInfo)localObject).curType == 1006) {
          ((SessionInfo)localObject).contactUin = ContactUtils.getUinByPhoneNum(paramQQAppInterface, ((SessionInfo)localObject).curFriendUin);
        }
        acvv.a(paramQQAppInterface, (SessionInfo)localObject);
      }
      if ((7000 == paramRecentUser.getType()) && (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramRecentUser.uin))) {
        bcqk.c(paramQQAppInterface);
      }
      paramQQAppInterface.getMessageFacade().setReaded(paramRecentUser.uin, paramRecentUser.getType(), true, paramBoolean2);
      if (paramRecentUser.getType() == 1) {
        awhn.a(paramQQAppInterface, paramRecentUser.uin);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    ThreadManager.post(new RecentUtil.6(paramQQAppInterface, paramString, paramInt), 2, null, false);
    if ("2290230341".equals(paramString))
    {
      if (paramInt != 1) {
        break label58;
      }
      paramString = "0X80090E4";
    }
    for (;;)
    {
      bcef.b(paramQQAppInterface, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
      return;
      label58:
      paramString = "0X80090E5";
      bcec.a(3);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, MessageRecord paramMessageRecord, int paramInt)
  {
    Object localObject = "";
    if (paramMessageRecord != null)
    {
      localObject = afdj.a(paramMessageRecord);
      if (localObject != null) {
        localObject = Long.toString(((PAMessage)localObject).mMsgId);
      }
    }
    else
    {
      odq.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_3", "msg_aio", 0, 0, paramString, (String)localObject, String.valueOf(paramInt), "", false);
      if ("2909288299".equals(paramString)) {
        if (paramInt <= 0) {
          break label118;
        }
      }
    }
    label118:
    for (paramInt = 2;; paramInt = 1)
    {
      bcef.b(paramQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X8007055", "0X8007055", 0, 0, "", "", "", uaw.a(paramInt));
      return;
      localObject = paramMessageRecord.getExtInfoFromExtStr("pa_msgId");
      break;
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
        paramQQMessageFacade = paramQQMessageFacade.getDraftSummaryInfo(paramRecentUser.uin, paramRecentUser.getType());
        if (paramQQMessageFacade != null) {
          paramRecentUser.lastmsgdrafttime = paramQQMessageFacade.getTime();
        }
      }
      l2 = System.currentTimeMillis();
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.recent", 4, "updateLastDraftTimeForNewRU| cost = " + (l2 - l1));
  }
  
  public static void a(List<uaq> paramList)
  {
    if ((paramList != null) && (paramList.size() == 0)) {}
  }
  
  private static boolean a(Activity paramActivity, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, int paramInt, RecentBaseData paramRecentBaseData)
  {
    boolean bool = false;
    if (((paramRecentUser.uin != null) && (paramRecentUser.uin.length() == 4)) || (AppConstants.QQBROADCAST_MSG_UIN.equals(paramRecentUser.uin)) || (TextUtils.equals(paramRecentUser.uin, AppConstants.NEW_KANDIAN_UIN)) || (TextUtils.equals(paramRecentUser.uin, AppConstants.WEISHI_UIN)) || (TextUtils.equals(paramRecentUser.uin, AppConstants.TIM_TEAM_UIN)) || (TextUtils.equals(paramRecentUser.uin, AppConstants.KANDIAN_SUBSCRIBE_UIN)) || (TextUtils.equals(paramRecentUser.uin, AppConstants.KANDIAN_DAILY_UIN)) || (TextUtils.equals(paramRecentUser.uin, "2290230341")) || (TextUtils.equals(paramRecentUser.uin, "2747277822")) || (TextUtils.equals(paramRecentUser.uin, "3046055438")) || (TextUtils.equals(paramRecentUser.uin, AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN)) || (TextUtils.equals(paramRecentUser.uin, AppConstants.QQ_VIP_UIN)) || (TextUtils.equals(paramRecentUser.uin, axil.a)) || (QQComicConfBean.a().a(paramRecentUser.uin)) || (TextUtils.equals(paramRecentUser.uin, "2711679534"))) {}
    try
    {
      bool = a(paramQQAppInterface, paramActivity, paramRecentUser, paramInt, paramRecentBaseData);
      return bool;
    }
    catch (JSONException paramActivity)
    {
      paramActivity.printStackTrace();
    }
    return false;
  }
  
  private static boolean a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt, Intent paramIntent)
  {
    Object localObject = ((amxz)paramQQAppInterface.getManager(56)).c(String.valueOf(paramString));
    String str = null;
    paramInt = 0;
    if (localObject != null)
    {
      str = ((PublicAccountInfo)localObject).name;
      paramInt = ((PublicAccountInfo)localObject).extendType;
    }
    if (paramInt == 2)
    {
      bcef.b(paramQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, paramString, "0", "", "");
      paramIntent.putExtra("chat_subType", 1);
      paramIntent.setClass(paramContext, ChatActivity.class);
      return false;
    }
    localObject = paramQQAppInterface.getMessageFacade().getLastMessage(paramString, 1008);
    paramInt = 0;
    if (localObject != null) {
      paramInt = paramQQAppInterface.getConversationFacade().a(paramString, ((MessageRecord)localObject).istroop);
    }
    a(paramQQAppInterface, paramString, (MessageRecord)localObject, paramInt);
    if ((agjp.a(paramString)) && (alhb.a(paramContext, paramQQAppInterface))) {
      return true;
    }
    if ((bgmy.a(paramString)) && (bgmy.a(paramContext, paramQQAppInterface, str, 161))) {
      return true;
    }
    paramIntent.putExtra("shouldreport", true);
    if ((paramContext instanceof SplashActivity))
    {
      paramIntent.putExtra("start_time", System.currentTimeMillis());
      paramIntent.putExtra("red_hot_count", paramInt);
    }
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramIntent.putExtra("has_unread_msg", bool);
      paramIntent.putExtra("jump_from", 1);
      ugt.a(null, "SUBSCRIPT_AIO_COST");
      break;
    }
  }
  
  private static boolean a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, Intent paramIntent)
  {
    abdm.a(paramQQAppInterface, "Usr_AIO_Open", 2, 0, 0);
    paramQQAppInterface = (aara)paramQQAppInterface.getBusinessHandler(51);
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString1);
      l1 = l2;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
    paramIntent.setClass(paramContext, ChatActivity.class);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.a(l1, 9)))
    {
      paramContext = new Bundle();
      paramContext.putString("din", String.valueOf(l1));
      paramContext.putString("devName", paramString2);
      paramContext.putBoolean("bFromLightApp", false);
      paramContext.putInt("operType", 5);
      paramIntent.putExtras(paramContext);
    }
    return false;
  }
  
  public static boolean a(RecentBaseData paramRecentBaseData)
  {
    if (paramRecentBaseData == null) {}
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser)
  {
    return QQComicConfBean.a().a(paramRecentUser.uin, paramActivity, 1043, paramQQAppInterface);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, int paramInt, RecentBaseData paramRecentBaseData)
  {
    if (AppConstants.LBS_HELLO_UIN.equals(paramRecentUser.uin)) {
      c(paramQQAppInterface, paramActivity, paramRecentUser);
    }
    do
    {
      return true;
      if (AppConstants.DATE_UIN.equals(paramRecentUser.uin))
      {
        b(paramQQAppInterface, paramActivity, paramRecentUser);
        return true;
      }
      if (AppConstants.LOCK_SCREEN_LBS_HELLO_UIN.equals(paramRecentUser.uin))
      {
        k(paramQQAppInterface, paramActivity);
        return true;
      }
      if (AppConstants.LOCK_SCREEN_DATE_UIN.equals(paramRecentUser.uin))
      {
        MsgBoxListActivity.a(paramActivity, 1010, AppConstants.DATE_UIN);
        return true;
      }
      if (AppConstants.SAME_STATE_BOX_UIN.equals(paramRecentUser.uin))
      {
        MsgBoxListActivity.a(paramActivity, 1009, paramRecentUser.uin);
        return true;
      }
      if (AppConstants.VOTE_MSG_UIN.equals(paramRecentUser.uin))
      {
        j(paramQQAppInterface, paramActivity);
        return true;
      }
      if (AppConstants.RECOMMEND_CONTACT_UIN.equals(paramRecentUser.uin))
      {
        i(paramQQAppInterface, paramActivity);
        return true;
      }
      if (AppConstants.TROOP_ASSISTANT_UIN.equals(paramRecentUser.uin))
      {
        h(paramQQAppInterface, paramActivity);
        return true;
      }
      if (AppConstants.HOTCHAT_CENTER_UIN.equals(paramRecentUser.uin))
      {
        g(paramQQAppInterface, paramActivity);
        return true;
      }
      if (AppConstants.QQBROADCAST_MSG_UIN.equals(paramRecentUser.uin))
      {
        paramQQAppInterface = new Intent(paramActivity, QQBroadcastActivity.class);
        paramQQAppInterface.setFlags(67108864);
        paramActivity.startActivity(paramQQAppInterface);
        return true;
      }
      if (AppConstants.TROOP_BAR_ASSISTANT_UIN.equals(paramRecentUser.uin))
      {
        f(paramQQAppInterface, paramActivity);
        return true;
      }
      if (TextUtils.equals(AppConstants.NEW_KANDIAN_UIN, paramRecentUser.uin))
      {
        b(paramQQAppInterface, paramActivity, paramRecentUser, paramRecentBaseData);
        return true;
      }
      if (AppConstants.SEND_BLESS_UIN.equals(paramRecentUser.uin))
      {
        e(paramQQAppInterface, paramActivity);
        return true;
      }
    } while (AppConstants.PUBLIC_ACCOUNT_WPA_ASSISTANT_UIN.equals(paramRecentUser.uin));
    if (AppConstants.TROOP_NOTIFICATION_UIN.equals(paramRecentUser.uin))
    {
      a(paramQQAppInterface, paramActivity, paramRecentUser);
      return true;
    }
    if (AppConstants.DATALINE_PC_UIN.equals(paramRecentUser.uin))
    {
      d(paramQQAppInterface, paramActivity);
      return true;
    }
    if (AppConstants.DATALINE_IPAD_UIN.equals(paramRecentUser.uin))
    {
      c(paramQQAppInterface, paramActivity);
      return true;
    }
    if (AppConstants.ACTIVATE_FRIENDS_UIN.equals(paramRecentUser.uin))
    {
      a(paramActivity, paramInt);
      return true;
    }
    if (AppConstants.EC_SHOP_ASSISTANT_UIN.equals(paramRecentUser.uin))
    {
      a(paramQQAppInterface, paramActivity, paramRecentBaseData);
      return true;
    }
    if (1012 == paramRecentUser.msgType)
    {
      b(paramQQAppInterface, paramActivity);
      return true;
    }
    if ((1030 == paramRecentUser.msgType) || (1035 == paramRecentUser.msgType) || (1041 == paramRecentUser.msgType) || (1042 == paramRecentUser.msgType))
    {
      a(paramActivity, paramRecentBaseData);
      return true;
    }
    return b(paramQQAppInterface, paramActivity, paramRecentUser, paramInt, paramRecentBaseData);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramRecentUser.getType() == 1)
    {
      bool1 = bool2;
      if ((paramRecentUser.lFlag & 1L) != 0L)
      {
        paramQQAppInterface = paramQQAppInterface.getHotChatMng(true);
        if (paramQQAppInterface != null)
        {
          HotChatInfo localHotChatInfo = paramQQAppInterface.a(paramRecentUser.uin);
          if ((localHotChatInfo != null) && (localHotChatInfo.apolloGameId > 0)) {
            VipUtils.a(null, "cmshow", "Apollo", "clk_reliao_msgtab", 0, 0, new String[] { String.valueOf(localHotChatInfo.apolloGameId) });
          }
        }
        bool1 = bool2;
        if (paramQQAppInterface != null)
        {
          bool1 = bool2;
          if (!paramQQAppInterface.b(paramRecentUser.uin)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
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
        paramQQAppInterface = (amsw)paramQQAppInterface.getManager(51);
        if ((paramQQAppInterface == null) || (!paramQQAppInterface.b(paramString))) {
          break label43;
        }
      }
    }
    label43:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, Intent paramIntent)
  {
    Object localObject = ((HotChatManager)paramQQAppInterface.getManager(60)).a(paramString);
    if (localObject != null)
    {
      paramIntent.putExtra("troop_uin", ((HotChatInfo)localObject).troopCode);
      return false;
    }
    localObject = (TroopManager)paramQQAppInterface.getManager(52);
    if (localObject != null)
    {
      paramString = ((TroopManager)localObject).a(paramString + "", true);
      if ((paramString != null) && (paramString.troopuin != null)) {
        paramIntent.putExtra("troop_uin", paramString.troopuin);
      }
    }
    else
    {
      bcef.b(paramQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.e("RecentUtil", 2, "when enter troop AIO, troop is not exist!!");
    }
    if (Looper.myLooper() == Looper.getMainLooper()) {
      QQToast.a(BaseApplicationImpl.getContext(), 1, amtj.a(2131712335), 0).a();
    }
    return true;
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    if (atyd.a()) {
      ((atyd)paramQQAppInterface.getManager(358)).c(0);
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    paramQQAppInterface = new ProfileActivity.AllInOne(paramQQAppInterface.getCurrentAccountUin(), 0);
    Intent localIntent = new Intent(paramActivity, NearbyPeopleProfileActivity.class);
    localIntent.putExtra("param_mode", 2);
    localIntent.putExtra("AllInOne", paramQQAppInterface);
    localIntent.putExtra("frome_where", -1);
    localIntent.putExtra("abp_flag", true);
    localIntent.addFlags(67108864);
    paramActivity.startActivity(localIntent);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser)
  {
    MsgBoxListActivity.a(paramActivity, 1010, paramRecentUser.uin);
    bcef.b(paramQQAppInterface, "CliOper", "", "", "0X8004947", "0X8004947", 0, 0, "", "", "", "");
    bcef.b(paramQQAppInterface, "CliOper", "", "", "0X80050F6", "0X80050F6", 0, 0, "", "", "", "");
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, int paramInt, RecentBaseData paramRecentBaseData)
  {
    Object localObject = paramQQAppInterface.getMessageFacade();
    MessageRecord localMessageRecord;
    String str4;
    String str5;
    String str6;
    int i;
    String str2;
    if (localObject != null)
    {
      localMessageRecord = ((QQMessageFacade)localObject).getLastMsgForMsgTab(paramRecentUser.uin, paramRecentUser.getType());
      pay.a(paramQQAppInterface, localMessageRecord);
      str4 = pay.a.b;
      str5 = pay.a.a;
      str6 = pay.a.c;
      paramRecentUser = (KandianMergeManager)paramQQAppInterface.getManager(162);
      localObject = paramRecentUser.a();
      if (localObject == null) {
        break label553;
      }
      long l = ((KandianMsgBoxRedPntInfo)localObject).mUin;
      i = ((KandianMsgBoxRedPntInfo)localObject).mMsgType;
      str2 = String.valueOf(l);
    }
    for (String str3 = String.valueOf(i);; str3 = "")
    {
      int j;
      label139:
      boolean bool1;
      boolean bool2;
      label156:
      boolean bool3;
      if (paramRecentBaseData != null)
      {
        i = paramRecentBaseData.mPosition;
        if ((localMessageRecord == null) || (localMessageRecord.uniseq != paramRecentUser.b())) {
          break label491;
        }
        j = 1;
        bool1 = false;
        bool2 = false;
        if (localMessageRecord == null) {
          break label497;
        }
        paramRecentUser = localMessageRecord.senderuin;
        localObject = paramRecentUser;
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
          localObject = paramRecentUser;
          bool2 = bool1;
          bool3 = bool1;
          if (localJSONObject.has("kdUin"))
          {
            bool3 = bool1;
            localObject = localJSONObject.getString("kdUin");
            bool2 = bool1;
          }
          paramRecentUser = (RecentUser)localObject;
        }
        catch (Exception localException)
        {
          label491:
          label497:
          localException.printStackTrace();
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
          localObject = "1";
          odq.a(null, "CliOper", "", paramRecentUser, "0X80066F4", "0X80066F4", 0, 0, String.valueOf(i + 1), str6, str4, pay.a(str5, str3, (String)localObject, str2, bool2), false);
          odq.a("0X80066F4", paramRecentUser, String.valueOf(i + 1), "", str4, pay.a(str5, str3));
          pay.a(21, str6, str4, str5, paramRecentUser, -1);
        }
        if (paramRecentBaseData == null) {
          continue;
        }
        if (paramRecentBaseData.mLastMsg == null) {
          continue;
        }
        paramRecentUser = paramRecentBaseData.mLastMsg.toString();
        paramRecentUser = new StringBuilder().append("enter kandianMergeBox, brief : ").append(pay.d(paramRecentUser)).append(",isUnRead : ");
        if ((paramRecentBaseData == null) || (paramRecentBaseData.mUnreadNum == 0)) {
          continue;
        }
        bool1 = true;
        QLog.d("KandianMergeManager", 1, bool1);
        if (paramInt != 1) {
          continue;
        }
        paramInt = 9;
        okj.a(paramQQAppInterface, paramActivity, paramInt, 0);
        ugt.a(null, "KANDIAN_FEEDS_STAGE_1_COST");
        ugt.a(null, "KANDIAN_FEEDS_COST");
        ugt.a(null, "KANDIAN_NEW_FEEDS_ACTIVITY_MANAGER");
        return;
        i = -1;
        break;
        j = 0;
        break label139;
        paramRecentUser = "";
        break label156;
        bool1 = false;
      }
      label553:
      str2 = "";
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, RecentBaseData paramRecentBaseData)
  {
    int i;
    if (paramRecentBaseData != null) {
      i = paramRecentBaseData.mPosition;
    }
    ArrayList localArrayList;
    Object localObject;
    for (;;)
    {
      localArrayList = new ArrayList();
      paramRecentBaseData = paramQQAppInterface.getMessageFacade();
      if (paramRecentBaseData == null) {
        break label396;
      }
      paramRecentBaseData = paramRecentBaseData.getLastMsgForMsgTab(paramRecentUser.uin, paramRecentUser.getType());
      if ((paramRecentBaseData == null) || (!(paramRecentBaseData instanceof MessageForStructing)) || (paramRecentBaseData.extInt != 1)) {
        break label434;
      }
      paramRecentUser = (MessageForStructing)paramRecentBaseData;
      if (paramRecentUser.structingMsg == null) {
        paramRecentUser.parse();
      }
      if (paramRecentUser.structingMsg == null) {
        break label264;
      }
      if (!TextUtils.isEmpty(paramRecentUser.structingMsg.mArticleIds))
      {
        localObject = paramRecentUser.structingMsg.mArticleIds.split("\\|");
        int k = localObject.length;
        int j = 0;
        label119:
        if (j < k)
        {
          String str = localObject[j];
          try
          {
            localArrayList.add(Long.valueOf(Long.parseLong(str)));
            j += 1;
            break label119;
            i = -1;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localException2.printStackTrace();
            }
          }
        }
      }
    }
    if (!TextUtils.isEmpty(paramRecentUser.structingMsg.mMsgActionData))
    {
      localObject = ugf.a(paramRecentUser.structingMsg.mMsgActionData);
      if (localObject == null) {}
    }
    for (;;)
    {
      long l;
      try
      {
        l = Long.parseLong(((JSONObject)localObject).getString("id"));
        if (l != -1L) {
          bcef.b(null, "CliOper", "", "", "0X80066F5", "0X80066F5", 0, 0, String.valueOf(i + 1), "", String.valueOf(l), "");
        }
        ugf.a(paramQQAppInterface, paramRecentUser, 1);
        label264:
        paramQQAppInterface = "";
        paramRecentUser = paramQQAppInterface;
        if (paramRecentBaseData == null) {
          break label519;
        }
        paramRecentUser = paramQQAppInterface;
      }
      catch (Exception localException1)
      {
        label396:
        localException1.printStackTrace();
      }
      try
      {
        if (!(paramRecentBaseData instanceof MessageForStructing)) {
          break label519;
        }
        paramRecentBaseData = (MessageForStructing)paramRecentBaseData;
        if (paramRecentBaseData.structingMsg.mStrategyIds != null) {
          paramQQAppInterface = paramRecentBaseData.structingMsg.mStrategyIds.split("\\|")[0];
        }
        paramRecentUser = paramQQAppInterface;
        if (paramRecentBaseData.structingMsg.mAlgorithmIds == null) {
          break label519;
        }
        paramRecentUser = paramRecentBaseData.structingMsg.mAlgorithmIds.split("\\|")[0];
        odq.a(null, "CliOper", "", "", "0X80066F4", "0X80066F4", 0, 0, String.valueOf(i + 1), "", paramQQAppInterface, pay.c(paramRecentUser), false);
        odq.a("0X80066F4", "", String.valueOf(i + 1), "", paramQQAppInterface, pay.c(paramRecentUser));
      }
      catch (Exception paramQQAppInterface)
      {
        label434:
        QLog.d("KandianMergeManager", 1, "failed to report new kandian click " + paramQQAppInterface.toString());
        continue;
        l = ((Long)localArrayList.get(0)).longValue();
        continue;
      }
      if (localArrayList.isEmpty())
      {
        l = -1L;
        okj.a(paramActivity, localArrayList, l, 5);
        return;
        l = -1L;
        continue;
        bcef.b(null, "CliOper", "", "", "0X80066F6", "0X80066F6", 0, 0, String.valueOf(i + 1), "", "", "");
      }
      else
      {
        label519:
        paramRecentBaseData = "";
        paramQQAppInterface = paramRecentUser;
        paramRecentUser = paramRecentBaseData;
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    Object localObject = null;
    bese localbese;
    if (paramRecentUser.msgType == 17)
    {
      localbese = (bese)paramQQAppInterface.getManager(363);
      if (paramRecentUser.uin == null) {
        break label416;
      }
    }
    label416:
    for (long l = localbese.a(paramRecentUser.uin);; l = 0L)
    {
      if (l != 0L) {
        localObject = paramQQAppInterface.getMessageFacade().queryMsgItemByShmsgseq4Troop(paramRecentUser.uin, paramRecentUser.getType(), l);
      }
      if (MessageForQQWalletMsg.isRedPacketMsg((MessageRecord)localObject))
      {
        bcef.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_hongbaoSign", 0, 0, paramRecentUser.uin, "", "", "");
        bcef.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_sfsign", 0, 0, paramRecentUser.uin, "", "", "");
        paramQQAppInterface = ".troop.special_msg.special_attention";
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty(paramQQAppInterface)) && (QLog.isColorLevel())) {
          QLog.d(akms.class.getSimpleName() + paramQQAppInterface, 2, "onRecentUserClick, r.uin:" + paramRecentUser.uin);
        }
        return;
        bcef.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_sfsign", 0, 0, paramRecentUser.uin, "", "", "");
        break;
        if (paramRecentUser.msgType == 24)
        {
          bcef.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_atsign", 0, 0, paramRecentUser.uin, "", "", "");
          paramQQAppInterface = ".troop.special_msg.at_msg";
        }
        else
        {
          if (paramRecentUser.msgType == 22)
          {
            int i = paramQQAppInterface.getTroopMask(paramRecentUser.uin);
            if (paramRecentUser.getType() == 3000) {}
            for (localObject = "Grp_Dis_replyMsg";; localObject = "Grp_replyMsg")
            {
              bcef.b(paramQQAppInterface, "P_CliOper", (String)localObject, "", "Msglist", "Clk_replySign", 0, 0, paramRecentUser.uin, "" + i, "", "");
              paramQQAppInterface = "";
              break;
            }
          }
          if (paramRecentUser.msgType == 16) {
            bcef.b(null, "dc00898", "", paramRecentUser.uin, "qq_vip", "0X800A907", 0, 1, 0, "", "", "", "");
          }
          paramQQAppInterface = "";
        }
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, int paramInt)
  {
    if (paramRecentUser.getType() == 1) {
      awhn.a(paramQQAppInterface, paramRecentUser.uin);
    }
    if ((paramRecentUser.getType() == 9000) && (AppConstants.TROOP_NOTIFICATION_UIN.equals(paramRecentUser.uin)))
    {
      paramQQAppInterface.getMsgHandler().a().c();
      bcsz.a().a(paramQQAppInterface, 0);
      ((amzp)paramQQAppInterface.getManager(22)).b();
    }
    if ((paramRecentUser.getType() == 7210) && (AppConstants.TROOP_BAR_ASSISTANT_UIN.equals(paramRecentUser.uin)))
    {
      uda.a().e(paramQQAppInterface);
      uda.a().d(paramQQAppInterface);
      paramQQAppInterface.refreshMsgTabUnreadNum(true, 0);
    }
    if ((paramRecentUser.getType() == 7230) && (AppConstants.SERVICE_ACCOUNT_FOLDER_UIN.equals(paramRecentUser.uin)))
    {
      uaw localuaw = uaw.a();
      int i = localuaw.b();
      int j = localuaw.a(paramQQAppInterface);
      long l = localuaw.a();
      if (paramInt != -1) {
        bcef.b(paramQQAppInterface, "dc01160", "Pb_account_lifeservice", "", "0X80067EB", "0X80067EB", 0, 0, "" + j, "" + i, String.valueOf(paramInt + 1), "" + l);
      }
      localuaw.d(paramQQAppInterface);
      paramQQAppInterface.refreshMsgTabUnreadNum(true, 0);
      if (QLog.isColorLevel()) {
        QLog.d("RecentUtil", 2, "deleteServiceAccountFolderFromMsgTab");
      }
    }
    if (AppConstants.TROOP_BAR_ASSISTANT_UIN.equals(paramRecentUser.uin))
    {
      bcef.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572D", "0X800572D", 0, 0, "", "", "", "");
      bcef.b(paramQQAppInterface, "CliOper", "", "", "0X800623F", "0X800623F", 0, 0, "", "", "", "");
      ucp.c(paramQQAppInterface, false);
    }
    while (!AppConstants.EC_SHOP_ASSISTANT_UIN.equals(paramRecentUser.uin)) {
      return;
    }
    if (((ofx)paramQQAppInterface.getManager(88)).a(paramQQAppInterface) > 0) {}
    for (paramRecentUser = "havereddot";; paramRecentUser = "noreddot")
    {
      bcef.b(paramQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_DelMsglist", "Del_shopHelper", 0, 0, "", "", paramRecentUser, "");
      return;
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
        } while (paramQQAppInterface.getConversationFacade().a(paramString, paramInt) <= 0);
        l = paramQQAppInterface.getMessageFacade().getReadConfirmStamp(paramString, paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.sendReadConfirm_PB", 2, String.format("RecentUtil,uin: %s, uinType: %d, id: %d", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(l) }));
        }
      } while (l == -1L);
      String str = abwz.b(paramInt);
      paramQQAppInterface.getMsgHandler().a(str).a(paramString, paramInt, l);
    } while (!paramString.equals("2747277822"));
    b(paramQQAppInterface);
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, int paramInt, RecentBaseData paramRecentBaseData)
  {
    if (TextUtils.equals(AppConstants.KANDIAN_MERGE_UIN, paramRecentUser.uin))
    {
      b(paramQQAppInterface, paramActivity, paramRecentUser, paramInt, paramRecentBaseData);
      return true;
    }
    if (AppConstants.SERVICE_ACCOUNT_FOLDER_UIN.equals(paramRecentUser.uin))
    {
      a(paramQQAppInterface, paramActivity, paramRecentUser, paramInt, paramRecentBaseData);
      return true;
    }
    if (AppConstants.CONFESS_UIN.equals(paramRecentUser.uin))
    {
      ConfessMsgListFragment.a(paramActivity, 1);
      bcef.b(paramQQAppInterface, "dc00898", "", "", "0X8008F4C", "0X8008F4C", 0, 0, "", "", "", "");
      return true;
    }
    if (AppConstants.WEISHI_UIN.equals(paramRecentUser.uin))
    {
      ukw.a(paramActivity, "from_home_page", 1, true);
      return true;
    }
    if (AppConstants.TIM_TEAM_UIN.equals(paramRecentUser.uin))
    {
      ugf.a(paramActivity, paramQQAppInterface);
      return true;
    }
    if (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramRecentUser.uin))
    {
      a(paramQQAppInterface, paramActivity, paramRecentUser, paramRecentBaseData);
      return true;
    }
    if ((TextUtils.equals(paramRecentUser.uin, "2290230341")) && (QZoneMsgActivity.open(paramActivity, paramQQAppInterface))) {
      return true;
    }
    if (AppConstants.KANDIAN_DAILY_UIN.equals(paramRecentUser.uin))
    {
      a(paramQQAppInterface, paramActivity, paramRecentUser, paramInt);
      return true;
    }
    if ((AppConstants.QQ_VIP_UIN.equals(paramRecentUser.uin)) && (atzb.a()) && (bgjk.b(paramActivity)))
    {
      bgjk.a(paramActivity);
      paramQQAppInterface.getConversationFacade().a(AppConstants.QQ_VIP_UIN, 1008, false);
      return true;
    }
    if (("2747277822".equals(paramRecentUser.uin)) && (atzb.a()))
    {
      a(paramQQAppInterface, paramActivity);
      return true;
    }
    if (MiniGamePublicAccountHelper.shouldOpenWebFragment(paramRecentUser.uin))
    {
      MiniGamePublicAccountHelper.launchMiniGamePublicAccount(paramActivity);
      paramQQAppInterface.getConversationFacade().a(AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN, 1008, false);
      return true;
    }
    if (TextUtils.equals("3046055438", paramRecentUser.uin))
    {
      ohn.a(paramQQAppInterface, paramActivity);
      ohq.a(paramQQAppInterface, "qgg.push.click");
      ohm.a(paramQQAppInterface, "3046055438");
      return true;
    }
    if (TextUtils.equals("2711679534", paramRecentUser.uin))
    {
      ohm.a(paramQQAppInterface, "2711679534");
      return false;
    }
    if (axil.a.equals(paramRecentUser.uin)) {
      return axin.a(paramActivity, paramRecentUser.uin, 1);
    }
    if (QQComicConfBean.a().a(paramRecentUser.uin)) {
      return a(paramQQAppInterface, paramActivity, paramRecentUser);
    }
    return false;
  }
  
  private static void c(QQAppInterface paramQQAppInterface)
  {
    Object localObject = uda.a().a(paramQQAppInterface);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (TroopBarData)((List)localObject).get(0);
      if (localObject != null)
      {
        localObject = paramQQAppInterface.getMessageFacade().getLastMessage(((TroopBarData)localObject).mUin, 1008);
        if (localObject != null) {
          uda.a().a(paramQQAppInterface, ((QQMessageFacade.Message)localObject).time);
        }
      }
    }
  }
  
  private static void c(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, LiteActivity.class);
    localIntent.putExtra("targetUin", AppConstants.DATALINE_IPAD_UIN);
    paramActivity.startActivity(localIntent);
    bcef.b(paramQQAppInterface, "CliOper", "", "", "0X8006040", "0X8006040", 0, 0, "", "", "", "");
  }
  
  private static void c(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser)
  {
    MsgBoxListActivity.a(paramActivity, 1001, paramRecentUser.uin);
    bcef.b(paramQQAppInterface, "CliOper", "", "", "0X80050F5", "0X80050F5", 0, 0, "", "", "", "");
    bcef.b(paramQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "clk_friend", 0, 0, "", "", "", "");
    paramActivity = paramQQAppInterface.getMessageFacade().getLastMessage(paramRecentUser.uin, 1001);
    if ((paramActivity != null) && (paramActivity.msgtype == -4011))
    {
      paramActivity = axhv.a(paramQQAppInterface);
      bcef.b(paramQQAppInterface, "CliOper", "", "", "0X80055FB", "0X80055FB", 0, 0, paramActivity[0], "", paramActivity[1], "");
    }
  }
  
  private static void c(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    int i = paramRecentUser.getType();
    paramRecentUser = paramRecentUser.uin;
    if ((i != 1033) && (i != 1034)) {
      bcdm.a(1, 1, i, paramQQAppInterface.getConversationFacade().a(paramRecentUser, i));
    }
  }
  
  private static void d(QQAppInterface paramQQAppInterface)
  {
    ofx localofx = (ofx)paramQQAppInterface.getManager(88);
    if (localofx != null)
    {
      Object localObject = localofx.a();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = (EcShopData)((List)localObject).get(0);
        if (localObject != null)
        {
          paramQQAppInterface = paramQQAppInterface.getMessageFacade().getLastMessage(((EcShopData)localObject).mUin, 1008);
          if (paramQQAppInterface != null) {
            localofx.a(paramQQAppInterface.time);
          }
        }
      }
    }
  }
  
  private static void d(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, LiteActivity.class);
    localIntent.putExtra("targetUin", AppConstants.DATALINE_PC_UIN);
    paramActivity.startActivity(localIntent);
    bcef.b(paramQQAppInterface, "CliOper", "", "", "0X800603B", "0X800603B", 0, 0, "", "", "", "");
  }
  
  private static void d(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    if (paramRecentUser.getType() == 5000)
    {
      avnu.a().a(paramQQAppInterface, true);
      f(paramQQAppInterface);
    }
    do
    {
      Object localObject;
      do
      {
        do
        {
          return;
          if (paramRecentUser.getType() == 7210)
          {
            uda.a().a(paramQQAppInterface, true);
            ThreadManager.post(new RecentUtil.4(paramQQAppInterface), 8, null, false);
            uda.a().h(paramQQAppInterface);
            return;
          }
          if (paramRecentUser.getType() == 7120)
          {
            g(paramQQAppInterface);
            return;
          }
          if (paramRecentUser.getType() != 9002) {
            break;
          }
          bcef.b(paramQQAppInterface, "CliOper", "", "", "0X8004E99", "0X8004E99", 0, 0, "", "", "", "");
          localObject = paramQQAppInterface.getMessageFacade().getMsgList(AppConstants.ACTIVATE_FRIENDS_UIN, 0);
          paramRecentUser = new ArrayList(((List)localObject).size());
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
            if ((!localMessageRecord.isread) && ((localMessageRecord.extLong & 0x1) == 1) && (!TextUtils.isEmpty(localMessageRecord.extStr))) {
              paramRecentUser.add(localMessageRecord.extStr);
            }
            paramQQAppInterface.getMessageFacade().removeMsgByUniseq(AppConstants.ACTIVATE_FRIENDS_UIN, 0, localMessageRecord.uniseq);
          }
        } while (paramRecentUser.size() <= 0);
        anen.a(paramQQAppInterface, (ArrayList)paramRecentUser);
        return;
        if (paramRecentUser.getType() == 9003)
        {
          ((ahux)paramQQAppInterface.getManager(138)).d();
          return;
        }
        if ((paramRecentUser.getType() == 7000) && (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramRecentUser.uin)))
        {
          ThreadManager.postImmediately(new RecentUtil.5(paramQQAppInterface), null, true);
          return;
        }
        if (paramRecentUser.getType() != 10005) {
          break;
        }
        localObject = aukx.a().b(paramRecentUser.uin);
      } while (localObject == null);
      aukx.a().a(paramQQAppInterface, paramRecentUser, (nxq)localObject, true);
      return;
    } while (paramRecentUser.getType() != 6004);
    a(paramQQAppInterface);
  }
  
  private static void e(QQAppInterface paramQQAppInterface)
  {
    amtm localamtm = (amtm)paramQQAppInterface.getManager(255);
    Object localObject1 = localamtm.a();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (HotChatItemData)((Iterator)localObject1).next();
        localObject2 = paramQQAppInterface.getMessageFacade().getLastMessage(((HotChatItemData)localObject2).mTroopUin, 1);
        if (localObject2 != null) {
          localamtm.a(((QQMessageFacade.Message)localObject2).time);
        }
      }
    }
  }
  
  private static void e(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    ahux localahux = (ahux)paramQQAppInterface.getManager(138);
    if (localahux != null)
    {
      localahux.a(paramActivity);
      localahux.b(false);
      bcef.b(paramQQAppInterface, "CliOper", "", "", "0X800618B", "0X800618B", 0, 0, "", "", "", "");
    }
  }
  
  private static void e(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    int i = 2;
    switch (paramRecentUser.getType())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      bcef.b(paramQQAppInterface, "CliOper", "", "", "Msg_tab", "Delete_msg", 0, 0, i + "", "", "", "");
      return;
      if (!paramRecentUser.uin.equals(AppConstants.SYSTEM_MSG_UIN)) {
        break;
      }
      i = 7;
      continue;
      i = 1;
      continue;
      a(paramQQAppInterface, paramRecentUser.uin, 2);
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 6;
      continue;
      i = 8;
      continue;
      i = 9;
      continue;
      i = 11;
      continue;
      i = 12;
      continue;
      i = 13;
    }
  }
  
  private static void f(QQAppInterface paramQQAppInterface)
  {
    List localList = avnu.a().b(paramQQAppInterface);
    int i;
    int j;
    label16:
    Object localObject;
    if (localList == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        return;
      }
      localObject = (TroopAssistantData)localList.get(j);
      if (localObject != null) {
        break label55;
      }
    }
    for (;;)
    {
      j += 1;
      break label16;
      i = localList.size();
      break;
      label55:
      localObject = paramQQAppInterface.getMessageFacade().getLastMessage(((TroopAssistantData)localObject).troopUin, 1);
      if (localObject != null) {
        avnu.a().a(paramQQAppInterface, ((QQMessageFacade.Message)localObject).time);
      }
    }
  }
  
  private static void f(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    boolean bool = false;
    ucp.c(paramQQAppInterface, false);
    uda localuda = uda.a();
    if (localuda.c(paramQQAppInterface)) {
      bcef.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B70", "0X8005B70", 0, 0, paramQQAppInterface.getCurrentAccountUin(), "", "", "");
    }
    localuda.e(paramQQAppInterface, false);
    localuda.d(paramQQAppInterface, false);
    int i = uda.a().a(paramQQAppInterface);
    if (i > 0)
    {
      bcef.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572B", "0X800572B", 0, 0, "", "", "", "");
      bcef.b(paramQQAppInterface, "CliOper", "", "", "0X8006573", "0X8006573", 0, 0, "", "", "", "");
      if (i <= 0) {
        break label337;
      }
    }
    label337:
    for (i = 1;; i = 0)
    {
      ThreadManager.post(new RecentUtil.1(paramQQAppInterface, i), 8, null, false);
      bcef.b(paramQQAppInterface, "CliOper", "", "", "0X800623E", "0X800623E", 0, 0, "", "", "", "");
      bcef.b(paramQQAppInterface, "P_CliOper", "Grp_tribe", "", "Msglist", "Clk_tribeHelper", 0, 0, "", "", "", "");
      if (bkwm.a(paramQQAppInterface)) {}
      for (paramQQAppInterface = okj.a(paramActivity, 0, 1);; paramQQAppInterface = okj.a(paramActivity, -1, 1))
      {
        paramQQAppInterface.putExtra("start_time", System.currentTimeMillis());
        if (i != 0) {
          bool = true;
        }
        paramQQAppInterface.putExtra("has_red_hot", bool);
        paramQQAppInterface.putExtra("come_from", 1);
        paramQQAppInterface.setFlags(67108864);
        paramActivity.startActivity(paramQQAppInterface);
        return;
        bcef.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572C", "0X800572C", 0, 0, "", "", "", "");
        bcef.b(paramQQAppInterface, "CliOper", "", "", "0X8006574", "0X8006574", 0, 0, "", "", "", "");
        break;
      }
    }
  }
  
  private static void g(QQAppInterface paramQQAppInterface)
  {
    ofx localofx = (ofx)paramQQAppInterface.getManager(88);
    if (localofx != null)
    {
      localofx.a(true);
      List localList = localofx.a();
      int i;
      int j;
      label34:
      Object localObject;
      if (localList == null)
      {
        i = 0;
        j = 0;
        if (j >= i) {
          return;
        }
        localObject = (EcShopData)localList.get(j);
        if (localObject != null) {
          break label75;
        }
      }
      for (;;)
      {
        j += 1;
        break label34;
        i = localList.size();
        break;
        label75:
        localObject = paramQQAppInterface.getMessageFacade().getLastMessage(((EcShopData)localObject).mUin, 1008);
        if (localObject != null) {
          localofx.a(((QQMessageFacade.Message)localObject).time);
        }
      }
    }
  }
  
  private static void g(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, HotChatCenterFragment.class);
    amtm localamtm = (amtm)paramQQAppInterface.getManager(255);
    HotChatItemData localHotChatItemData = localamtm.a();
    ApolloGameUtil.a(paramQQAppInterface.getEntityManagerFactory().createEntityManager(), true);
    if (localHotChatItemData != null)
    {
      localamtm.a(localHotChatItemData.mTroopUin, 1);
      MqqHandler localMqqHandler = paramQQAppInterface.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1009);
      }
      if (localHotChatItemData.mIsRead4Folder) {
        break label128;
      }
    }
    label128:
    for (int i = 99;; i = localamtm.a())
    {
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "clk_reliao_folder", i, 0, new String[0]);
      localIntent.setFlags(67108864);
      PublicFragmentActivity.a(paramActivity, localIntent, HotChatCenterFragment.class);
      return;
    }
  }
  
  private static void h(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, TroopAssistantActivity.class);
    localIntent.setFlags(67108864);
    paramActivity.startActivity(localIntent);
    bcef.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_help", 0, 0, "", "", "", "");
  }
  
  private static void i(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    Intent localIntent = new Intent();
    if ((paramActivity instanceof QQLSActivity)) {
      localIntent.putExtra("from", "from_lsa");
    }
    NewFriendActivity.a(paramActivity, localIntent, 1);
    bcef.b(paramQQAppInterface, "CliOper", "", "", "Add_frd", "Clk_Frd_offer", 22, 0, "", "", "", "");
  }
  
  private static void j(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    paramQQAppInterface.getMessageFacade().setReaded(AppConstants.VOTE_MSG_UIN, 0);
    Intent localIntent = new Intent(paramActivity, VisitorsActivity.class);
    localIntent.putExtra("votersOnly", true);
    localIntent.putExtra("toUin", Long.valueOf(paramQQAppInterface.getCurrentAccountUin()));
    paramActivity.startActivity(localIntent);
  }
  
  private static void k(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    MsgBoxListActivity.a(paramActivity, 1001, AppConstants.LBS_HELLO_UIN);
    bcef.b(paramQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "tip_single", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akms
 * JD-Core Version:    0.7.0.1
 */