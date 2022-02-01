import Wallet.AcsMsg;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.qwallet.emoj.EmojiGifHelper;
import com.tencent.mobileqq.activity.qwallet.emoj.EmojiGifHelper.ConvertParam;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCModule.1;
import com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCModule.2;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.microapp.apkg.ApkgConfigManager;
import com.tencent.mobileqq.microapp.apkg.AppInfo;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.apkg.UsedAppListManager;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class akxq
  extends QIPCModule
{
  public static akxq a;
  private Map<Integer, akud> a;
  
  private akxq()
  {
    super("QWalletIPCModule");
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static akxq a()
  {
    if (jdField_a_of_type_Akxq == null) {}
    try
    {
      if (jdField_a_of_type_Akxq == null) {
        jdField_a_of_type_Akxq = new akxq();
      }
      return jdField_a_of_type_Akxq;
    }
    finally {}
  }
  
  private EIPCResult a(QQAppInterface paramQQAppInterface, Bundle paramBundle, int paramInt)
  {
    boolean bool;
    switch (paramBundle.getInt("oper_type", -1))
    {
    case 14: 
    default: 
      return null;
    case 9: 
      paramBundle = new Bundle();
      paramQQAppInterface = (aohe)paramQQAppInterface.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
      if (paramQQAppInterface != null) {
        paramBundle.putBoolean("res", paramQQAppInterface.a(true));
      }
      for (;;)
      {
        return EIPCResult.createSuccessResult(paramBundle);
        paramBundle.putBoolean("res", true);
      }
    case 10: 
      bool = paramBundle.getBoolean("req_param");
      paramQQAppInterface = (aohe)paramQQAppInterface.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(bool, true);
      }
      return null;
    case 11: 
      paramBundle = (AcsMsg)paramBundle.getSerializable("req_param");
      paramQQAppInterface = (afnl)paramQQAppInterface.getManager(QQManagerFactory.QQ_REMINDER_ALARM_MANAGER);
      if ((paramQQAppInterface != null) && (paramBundle != null)) {
        paramQQAppInterface.a(paramBundle);
      }
      return null;
    case 12: 
      paramBundle = (AcsMsg)paramBundle.getSerializable("req_param");
      if (paramBundle != null)
      {
        localObject = paramQQAppInterface.getApp().getSharedPreferences("pref_act_frd" + paramQQAppInterface.getCurrentAccountUin(), 0);
        if (localObject != null) {
          ((SharedPreferences)localObject).edit().remove(paramBundle.msg_id + paramQQAppInterface.getCurrentAccountUin()).apply();
        }
        paramQQAppInterface = (afnl)paramQQAppInterface.getManager(QQManagerFactory.QQ_REMINDER_ALARM_MANAGER);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.a(afmn.a(paramBundle).hashCode());
        }
      }
      return null;
    case 13: 
      paramBundle = (AcsMsg)paramBundle.getSerializable("req_param");
      if ((paramQQAppInterface != null) && (paramBundle != null))
      {
        paramQQAppInterface.getMessageFacade().removeMsgByUniseq(AppConstants.ACTIVATE_FRIENDS_UIN, 9002, paramBundle.msg_id.hashCode());
        paramQQAppInterface.refreshAppBadge();
      }
      return null;
    case 0: 
      paramQQAppInterface = ContactUtils.getBuddyName(paramQQAppInterface, paramBundle.getString("uin"), true);
      paramBundle = new Bundle();
      paramBundle.putString("res", paramQQAppInterface);
      return EIPCResult.createSuccessResult(paramBundle);
    case 7: 
      paramQQAppInterface = (EmojiGifHelper.ConvertParam)paramBundle.getSerializable("req_param");
      EmojiGifHelper.getInstance().compositeAndTransToGifInner(paramQQAppInterface, new akxv(this, paramInt));
      return null;
    case 8: 
      paramInt = paramBundle.getInt("req_id");
      EmojiGifHelper.getInstance().removeTaskInner(paramInt);
      return null;
    case 17: 
      bool = paramBundle.getBoolean("is_sync");
      paramQQAppInterface = (LoadParam)paramBundle.getSerializable("load_param");
      paramBundle = (LoadParam.LoadItem)paramBundle.getSerializable("load_item");
      if (bool)
      {
        paramQQAppInterface = new bdfv(paramQQAppInterface, paramBundle).a();
        paramBundle = new Bundle();
        paramBundle.putSerializable("res", paramQQAppInterface);
        return EIPCResult.createSuccessResult(paramBundle);
      }
      new bdfq(paramQQAppInterface, paramBundle).a(new akxw(this, paramInt));
      return null;
    case 18: 
      paramInt = albn.a(paramBundle.getString("path"));
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putInt("res", paramInt);
      return EIPCResult.createSuccessResult(paramQQAppInterface);
    case 1: 
      paramBundle = (LaunchParam)paramBundle.getSerializable("mini_launch_param");
      MiniAppLauncher.launchMiniApp(paramQQAppInterface.getApp(), paramBundle);
      callbackResult(paramInt, EIPCResult.createSuccessResult(null));
      return null;
    case 3: 
      UsedAppListManager.recordAppStart((AppInfo)paramBundle.getSerializable("req_param"));
      return null;
    case 4: 
      paramQQAppInterface = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("req_param");
      ApolloGameUtil.a(ApolloGameUtil.a(), paramQQAppInterface);
      return null;
    case 5: 
      paramBundle.getInt("action");
      paramQQAppInterface = (MiniAppConfig)paramBundle.getSerializable("req_param");
      return null;
    case 6: 
      paramBundle = paramBundle.getString("req_param");
      paramQQAppInterface = (akyj)paramQQAppInterface.getManager(QQManagerFactory.QWALLET_RED_MANAGER);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(paramBundle);
      }
      return null;
    case 16: 
      localObject = paramBundle.getString("key");
      paramInt = paramBundle.getInt("code");
      if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))))
      {
        paramBundle = (akud)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
        paramQQAppInterface = (aktz)paramQQAppInterface.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.d((String)localObject, paramBundle);
        }
      }
      return null;
    case 15: 
      localObject = paramBundle.getString("key");
      paramInt = paramBundle.getInt("code");
      paramBundle = new akxx(this, (ResultReceiver)paramBundle.getParcelable("receiver"));
      paramQQAppInterface = (aktz)paramQQAppInterface.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
      if (paramQQAppInterface != null)
      {
        if ((this.jdField_a_of_type_JavaUtilMap != null) && (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt)))) {
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramBundle);
        }
        paramQQAppInterface.c((String)localObject, paramBundle);
      }
      return null;
    }
    Object localObject = (LaunchParam)paramBundle.getSerializable("mini_launch_param");
    paramInt = paramBundle.getInt("version");
    paramBundle = new akxy(this, (ResultReceiver)paramBundle.getParcelable("receiver"));
    ((ApkgConfigManager)paramQQAppInterface.getManager(QQManagerFactory.APKG_CONFIG_MANAGER)).tryUpdate((LaunchParam)localObject, paramInt, paramBundle);
    return null;
  }
  
  private void a(Bundle paramBundle, QQAppInterface paramQQAppInterface, int paramInt)
  {
    int i = paramBundle.getInt("channel");
    String str = paramBundle.getString("uin");
    paramBundle = paramBundle.getString("group_id");
    Object localObject2 = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject1;
    if (((i != 5) && ((i & 0x10) == 0)) || ((((anvk)localObject2).b(str)) && (!paramQQAppInterface.getCurrentAccountUin().equals(str)))) {
      if (!TextUtils.isEmpty(paramBundle))
      {
        localObject1 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        localObject2 = ((anvk)localObject2).e(str);
        paramBundle = ((TroopManager)localObject1).b(paramBundle, str);
        if ((localObject2 != null) && (!TextUtils.isEmpty(((Friends)localObject2).remark))) {
          paramBundle = ((Friends)localObject2).remark;
        }
      }
    }
    for (;;)
    {
      localObject1 = paramBundle;
      if (TextUtils.isEmpty(paramBundle)) {
        localObject1 = ContactUtils.getBuddyName(paramQQAppInterface, str, true);
      }
      for (;;)
      {
        paramBundle = new EIPCResult();
        paramQQAppInterface = new Bundle();
        paramQQAppInterface.putString("user_nick", (String)localObject1);
        paramBundle.data = paramQQAppInterface;
        callbackResult(paramInt, paramBundle);
        return;
        if ((paramBundle != null) && (!TextUtils.isEmpty(paramBundle.troopnick)))
        {
          paramBundle = paramBundle.troopnick;
          break;
        }
        if (localObject2 != null)
        {
          paramBundle = ((Friends)localObject2).name;
          break;
        }
        if (paramBundle == null) {
          break label310;
        }
        if (str.equals(paramQQAppInterface.getCurrentAccountUin()))
        {
          paramBundle = paramBundle.friendnick;
          break;
        }
        if (!TextUtils.isEmpty(paramBundle.autoremark))
        {
          paramBundle = paramBundle.autoremark;
          break;
        }
        paramBundle = paramBundle.friendnick;
        break;
        localObject1 = ContactUtils.getBuddyName(paramQQAppInterface, str, true);
        continue;
        paramBundle = ContactUtils.getDateNickName(paramQQAppInterface, str);
        localObject1 = paramBundle;
        if (TextUtils.isEmpty(paramBundle)) {
          localObject1 = str;
        }
      }
      label310:
      paramBundle = null;
    }
  }
  
  private void a(AppRuntime paramAppRuntime, Bundle paramBundle)
  {
    if ((paramAppRuntime != null) && (paramBundle != null))
    {
      paramBundle = (HashMap)paramBundle.getSerializable("params_value");
      if (paramBundle != null)
      {
        paramAppRuntime = (aktz)((QQAppInterface)paramAppRuntime).getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
        if (paramAppRuntime != null) {
          paramAppRuntime.a(paramBundle);
        }
      }
    }
  }
  
  private EIPCResult b(QQAppInterface paramQQAppInterface, Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null) {
      return null;
    }
    switch (paramBundle.getInt("method_type", -1))
    {
    default: 
      return null;
    case 1: 
      paramBundle = (DownloadParam)paramBundle.getSerializable("download_params");
      ((PreloadManager)paramQQAppInterface.getManager(QQManagerFactory.PRELOAD_MANAGER)).a(paramBundle, new akya(this, paramInt));
      return null;
    case 2: 
      Object localObject = paramBundle.getStringArray("url");
      if (localObject == null) {}
      for (localObject = null;; localObject = Arrays.asList((Object[])localObject))
      {
        paramBundle = new akxz(this, (ResultReceiver)paramBundle.getParcelable("receiver"));
        ((PreloadManager)paramQQAppInterface.getManager(QQManagerFactory.PRELOAD_MANAGER)).a((List)localObject, paramBundle);
        return null;
      }
    case 4: 
      paramQQAppInterface = PreloadManager.a((DownloadParam)paramBundle.getSerializable("download_params"));
      paramBundle = new Bundle();
      paramBundle.putSerializable("path_result", paramQQAppInterface);
      return EIPCResult.createSuccessResult(paramBundle);
    }
    paramBundle = (LinkedList)paramBundle.getSerializable("download_params");
    ((PreloadManager)paramQQAppInterface.getManager(QQManagerFactory.PRELOAD_MANAGER)).a(paramBundle, new akxr(this, paramInt));
    return null;
  }
  
  public Bundle a(AppRuntime paramAppRuntime, Bundle paramBundle)
  {
    paramAppRuntime = (aktz)((QQAppInterface)paramAppRuntime).getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
    Bundle localBundle = new Bundle();
    String str = paramBundle.getString("module");
    int i = paramBundle.getInt("oper_type");
    String[] arrayOfString = paramBundle.getStringArray("sub_keys");
    switch (i)
    {
    default: 
      return localBundle;
    case 0: 
      localBundle.putInt("res_get_value", paramAppRuntime.a(str, paramBundle.getInt("def_value"), arrayOfString));
      return localBundle;
    case 1: 
      localBundle.putString("res_get_value", paramAppRuntime.a(str, paramBundle.getString("def_value"), arrayOfString));
      return localBundle;
    }
    localBundle.putString("res_get_value", paramAppRuntime.a(str));
    return localBundle;
  }
  
  public EIPCResult a(Bundle paramBundle, int paramInt)
  {
    paramBundle.setClassLoader(getClass().getClassLoader());
    paramInt = paramBundle.getInt("key_func");
    ResultReceiver localResultReceiver = (ResultReceiver)paramBundle.getParcelable("key_callback");
    IRedPacket localIRedPacket = RedPacketManager.getInstance();
    Object localObject = new Bundle();
    switch (paramInt)
    {
    default: 
    case 1: 
    case 5: 
    case 2: 
    case 3: 
      for (;;)
      {
        return null;
        paramBundle = (RedPacketInfoBase)paramBundle.getParcelable("key_red_packet_info");
        localObject = new akxs(this, (Bundle)localObject, localResultReceiver);
        if (paramInt == 1) {
          localIRedPacket.getSkin(paramBundle, (IRedPacket.OnGetSkinListener)localObject);
        }
        for (;;)
        {
          return null;
          if (paramInt == 5) {
            localIRedPacket.getVoiceRateRes(paramBundle, (IRedPacket.OnGetSkinListener)localObject);
          }
        }
        ((Bundle)localObject).putBoolean("key_is_risk_switch_open", localIRedPacket.isRiskSwitchOpen());
        return EIPCResult.createSuccessResult((Bundle)localObject);
        localIRedPacket.requestRedPacketSkinList();
      }
    case 6: 
      paramInt = paramBundle.getInt("theme_id");
      ((Bundle)localObject).putBoolean("key_theme_exist", ((RedPacketManager)RedPacketManager.getInstance()).onGetThemeConfig(paramInt));
      return EIPCResult.createSuccessResult((Bundle)localObject);
    }
    paramBundle = localIRedPacket.getPopAd(paramBundle.getInt("key_skin_id", 0), paramBundle.getInt("key_channel", 0));
    if (paramBundle != null)
    {
      ((Bundle)localObject).putString("pop_ad_tips", paramBundle.optString("tips"));
      ((Bundle)localObject).putString("pop_ad_url", paramBundle.optString("url"));
      ((Bundle)localObject).putInt("pop_ad_url_type", paramBundle.optInt("urlType"));
      ((Bundle)localObject).putInt("pop_ad_icon", paramBundle.optInt("icon"));
    }
    return EIPCResult.createSuccessResult((Bundle)localObject);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCModule", 2, "action = " + paramString + ", params = " + paramBundle);
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      return null;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
    if ("getFilePathByResID".equals(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCModule", 2, "onCall getFilePathByResID");
      }
      ThreadManager.post(new QWalletIPCModule.1(this, paramBundle, paramInt, (AppRuntime)localObject), 5, null, true);
    }
    for (;;)
    {
      return null;
      if (("downloadModule".equals(paramString)) || ("downloadRes".equals(paramString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QWalletIPCModule", 2, "onCall downloadModule:" + System.currentTimeMillis());
        }
        ThreadManager.post(new QWalletIPCModule.2(this, paramBundle, (AppRuntime)localObject, paramString), 5, null, true);
        callbackResult(paramInt, null);
      }
      else
      {
        if ("getVideoResPathByMID".equals(paramString))
        {
          paramString = paramBundle.getString("mid");
          paramString = ((PreloadManager)((QQAppInterface)localObject).getManager(QQManagerFactory.PRELOAD_MANAGER)).e(paramString);
          if (QLog.isColorLevel()) {
            QLog.d("QWalletIPCModule", 2, "onCall getVideoResPathByMID:" + paramString);
          }
          paramBundle = new Bundle();
          paramBundle.putString("path", paramString);
          return EIPCResult.createSuccessResult(paramBundle);
        }
        if ("getResourceByResID".equals(paramString))
        {
          paramString = paramBundle.getString("res_id");
          paramString = ((PreloadManager)((QQAppInterface)localObject).getManager(QQManagerFactory.PRELOAD_MANAGER)).a(paramString);
          if (QLog.isColorLevel()) {
            QLog.d("QWalletIPCModule", 2, "onCall getResourceByResID:" + paramString);
          }
          paramBundle = new Bundle();
          paramBundle.putSerializable("res_info", paramString);
          return EIPCResult.createSuccessResult(paramBundle);
        }
        if ("getResInfoByResID".equals(paramString))
        {
          paramString = paramBundle.getString("res_id");
          paramString = ((PreloadManager)((QQAppInterface)localObject).getManager(QQManagerFactory.PRELOAD_MANAGER)).a(paramString);
          if (QLog.isColorLevel()) {
            QLog.d("QWalletIPCModule", 2, "onCall ACTION_GET_RESINFO_BY_RESID:" + paramString);
          }
          paramBundle = new Bundle();
          paramBundle.putSerializable("res_info", paramString);
          return EIPCResult.createSuccessResult(paramBundle);
        }
        if ("getResIDByBusinessID".equals(paramString))
        {
          paramBundle.getString("bid");
          paramBundle.getString("uin");
          paramString = new Bundle();
          paramString.putString("res_id", null);
          return EIPCResult.createSuccessResult(paramString);
        }
        if ("getConfig".equals(paramString)) {
          return EIPCResult.createSuccessResult(a((AppRuntime)localObject, paramBundle));
        }
        if ("setConfigSession".equals(paramString))
        {
          a((AppRuntime)localObject, paramBundle);
        }
        else
        {
          if ("getConditionSearchManager".equals(paramString))
          {
            paramString = (ResultReceiver)paramBundle.getParcelable("receiver");
            paramBundle = (anrz)((QQAppInterface)localObject).getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
            QLog.d("QWalletIPCModule", 2, "ConditionSearchManager " + paramBundle.toString());
            paramInt = paramBundle.a();
            if (paramInt != 0)
            {
              int i = paramBundle.a(paramInt, true);
              if (QLog.isColorLevel()) {
                QLog.d("QWalletIPCModule", 2, "ConditionSearchManager | update result = " + i);
              }
              localObject = new Bundle();
              if (i == 0) {
                paramBundle.c(new akxu(this, (Bundle)localObject, i, paramString, paramBundle));
              }
              ((Bundle)localObject).putInt("isUpdateSuccess", 0);
              ((Bundle)localObject).putInt("updateResult", i);
              paramString.send(paramInt, (Bundle)localObject);
              return null;
            }
            paramString.send(0, null);
            return null;
          }
          if ("getUserNick".equals(paramString))
          {
            a(paramBundle, (QQAppInterface)localObject, paramInt);
          }
          else
          {
            if ("red_packet".equals(paramString)) {
              return a(paramBundle, paramInt);
            }
            if ("ComIPCUtils".equals(paramString)) {
              try
              {
                paramString = a(localQQAppInterface, paramBundle, paramInt);
                return paramString;
              }
              catch (Throwable paramString)
              {
                if (-1 == paramInt) {
                  return EIPCResult.createExceptionResult(paramString);
                }
                callbackResult(paramInt, EIPCResult.createExceptionResult(paramString));
                return null;
              }
            }
            if ("preloadCommon".equals(paramString)) {
              return b(localQQAppInterface, paramBundle, paramInt);
            }
            if ("onVfcPluginStart".equals(paramString))
            {
              paramString = bluc.a();
              if (paramString == null) {
                return null;
              }
              paramString.a(localQQAppInterface.getApplication(), 1);
              if (QLog.isColorLevel()) {
                QLog.d("IpcModule", 2, "，收到插件onStart通知");
              }
            }
            else if ("onVfcPluginDestroy".equals(paramString))
            {
              paramString = bluc.a();
              if (paramString == null) {
                return null;
              }
              paramString.a(localQQAppInterface.getApplication(), 0);
              if (QLog.isColorLevel()) {
                QLog.d("IpcModule", 2, "，收到插件onDestroy通知");
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxq
 * JD-Core Version:    0.7.0.1
 */