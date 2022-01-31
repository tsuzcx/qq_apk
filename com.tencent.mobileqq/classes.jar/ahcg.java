import Wallet.AcsMsg;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.microapp.apkg.ApkgConfigManager;
import com.tencent.mobileqq.microapp.apkg.AppInfo;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.apkg.UsedAppListManager;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.microapp.sdk.MiniAppLifeUtil;
import com.tencent.mobileqq.qipc.QIPCModule;
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

public class ahcg
  extends QIPCModule
{
  public static ahcg a;
  private Map<Integer, agzh> a;
  
  private ahcg()
  {
    super("QWalletIPCModule");
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static ahcg a()
  {
    if (jdField_a_of_type_Ahcg == null) {}
    try
    {
      if (jdField_a_of_type_Ahcg == null) {
        jdField_a_of_type_Ahcg = new ahcg();
      }
      return jdField_a_of_type_Ahcg;
    }
    finally {}
  }
  
  private EIPCResult a(QQAppInterface paramQQAppInterface, Bundle paramBundle, int paramInt)
  {
    switch (paramBundle.getInt("oper_type", -1))
    {
    default: 
      return null;
    case 9: 
      paramBundle = new Bundle();
      paramQQAppInterface = (akjv)paramQQAppInterface.getManager(85);
      if (paramQQAppInterface != null) {
        paramBundle.putBoolean("res", paramQQAppInterface.a(true));
      }
      for (;;)
      {
        return EIPCResult.createSuccessResult(paramBundle);
        paramBundle.putBoolean("res", true);
      }
    case 10: 
      boolean bool = paramBundle.getBoolean("req_param");
      paramQQAppInterface = (akjv)paramQQAppInterface.getManager(85);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(bool, true);
      }
      return null;
    case 11: 
      paramBundle = (AcsMsg)paramBundle.getSerializable("req_param");
      paramQQAppInterface = (acsk)paramQQAppInterface.getManager(321);
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
        paramQQAppInterface = (acsk)paramQQAppInterface.getManager(321);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.a(paramBundle.hashCode());
        }
      }
      return null;
    case 13: 
      paramBundle = (AcsMsg)paramBundle.getSerializable("req_param");
      if ((paramQQAppInterface != null) && (paramBundle != null))
      {
        paramQQAppInterface.a().b(ajsd.ad, 9002, paramBundle.msg_id.hashCode());
        paramQQAppInterface.D();
      }
      return null;
    case 0: 
      paramQQAppInterface = bbcz.b(paramQQAppInterface, paramBundle.getString("uin"), true);
      paramBundle = new Bundle();
      paramBundle.putString("res", paramQQAppInterface);
      return EIPCResult.createSuccessResult(paramBundle);
    case 7: 
      paramQQAppInterface = (EmojiGifHelper.ConvertParam)paramBundle.getSerializable("req_param");
      EmojiGifHelper.getInstance().compositeAndTransToGifInner(paramQQAppInterface, new ahcl(this, paramInt));
      return null;
    case 8: 
      paramInt = paramBundle.getInt("req_id");
      EmojiGifHelper.getInstance().removeTaskInner(paramInt);
      return null;
    case 14: 
      paramQQAppInterface = paramBundle.getString("name");
      axnl.a().a(paramQQAppInterface, new ahcm(this, paramInt));
      return null;
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
      MiniAppLifeUtil.notifyLifeAction(paramBundle.getInt("action"), (MiniAppConfig)paramBundle.getSerializable("req_param"));
      return null;
    case 6: 
      paramBundle = paramBundle.getString("req_param");
      paramQQAppInterface = (ahcw)paramQQAppInterface.getManager(273);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(paramBundle);
      }
      return null;
    case 16: 
      localObject = paramBundle.getString("key");
      paramInt = paramBundle.getInt("code");
      if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))))
      {
        paramBundle = (agzh)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
        paramQQAppInterface = (agzd)paramQQAppInterface.getManager(245);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.d((String)localObject, paramBundle);
        }
      }
      return null;
    case 15: 
      localObject = paramBundle.getString("key");
      paramInt = paramBundle.getInt("code");
      paramBundle = new ahcn(this, (ResultReceiver)paramBundle.getParcelable("receiver"));
      paramQQAppInterface = (agzd)paramQQAppInterface.getManager(245);
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
    paramBundle = new ahco(this, (ResultReceiver)paramBundle.getParcelable("receiver"));
    ((ApkgConfigManager)paramQQAppInterface.getManager(287)).tryUpdate((LaunchParam)localObject, paramInt, paramBundle);
    return null;
  }
  
  private void a(Bundle paramBundle, QQAppInterface paramQQAppInterface, int paramInt)
  {
    int i = paramBundle.getInt("channel");
    String str = paramBundle.getString("uin");
    paramBundle = paramBundle.getString("group_id");
    Object localObject2 = (ajxl)paramQQAppInterface.getManager(51);
    Object localObject1;
    if (((i != 5) && ((i & 0x10) == 0)) || ((((ajxl)localObject2).b(str)) && (!paramQQAppInterface.getCurrentAccountUin().equals(str)))) {
      if (!TextUtils.isEmpty(paramBundle))
      {
        localObject1 = (TroopManager)paramQQAppInterface.getManager(52);
        localObject2 = ((ajxl)localObject2).e(str);
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
        localObject1 = bbcz.b(paramQQAppInterface, str, true);
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
          break label308;
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
        localObject1 = bbcz.b(paramQQAppInterface, str, true);
        continue;
        paramBundle = bbcz.q(paramQQAppInterface, str);
        localObject1 = paramBundle;
        if (TextUtils.isEmpty(paramBundle)) {
          localObject1 = str;
        }
      }
      label308:
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
        paramAppRuntime = (agzd)((QQAppInterface)paramAppRuntime).getManager(245);
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
      ((PreloadManager)paramQQAppInterface.getManager(151)).a(paramBundle, new ahcq(this, paramInt));
      return null;
    case 2: 
      Object localObject = paramBundle.getStringArray("url");
      if (localObject == null) {}
      for (localObject = null;; localObject = Arrays.asList((Object[])localObject))
      {
        paramBundle = new ahcp(this, (ResultReceiver)paramBundle.getParcelable("receiver"));
        ((PreloadManager)paramQQAppInterface.getManager(151)).a((List)localObject, paramBundle);
        return null;
      }
    }
    paramBundle = (LinkedList)paramBundle.getSerializable("download_params");
    ((PreloadManager)paramQQAppInterface.getManager(151)).a(paramBundle, new ahch(this, paramInt));
    return null;
  }
  
  public Bundle a(AppRuntime paramAppRuntime, Bundle paramBundle)
  {
    paramAppRuntime = (agzd)((QQAppInterface)paramAppRuntime).getManager(245);
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
        localObject = new ahci(this, (Bundle)localObject, localResultReceiver);
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
          paramString = ((PreloadManager)((QQAppInterface)localObject).getManager(151)).d(paramString);
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
          paramString = ((PreloadManager)((QQAppInterface)localObject).getManager(151)).a(paramString);
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
          paramString = ((PreloadManager)((QQAppInterface)localObject).getManager(151)).a(paramString);
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
            paramBundle = (ajtw)((QQAppInterface)localObject).getManager(59);
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
                paramBundle.c(new ahck(this, (Bundle)localObject, i, paramString, paramBundle));
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
              return a(localQQAppInterface, paramBundle, paramInt);
            }
            if ("preloadCommon".equals(paramString)) {
              return b(localQQAppInterface, paramBundle, paramInt);
            }
            if ("onVfcPluginStart".equals(paramString))
            {
              paramString = bgkw.a();
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
              paramString = bgkw.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahcg
 * JD-Core Version:    0.7.0.1
 */