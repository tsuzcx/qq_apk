import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.data.ReadInJoyDAUReport;
import com.tencent.gamecenter.appointment.GameCenterCheck;
import com.tencent.mobileqq.activity.activateFriend.biz.QQReminderStepAsync;
import com.tencent.mobileqq.activity.miniaio.MiniMsgTabServerInitStep;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.InitBeforeSyncMsg;
import com.tencent.mobileqq.app.automator.LinearGroup;
import com.tencent.mobileqq.app.automator.ParallGroup;
import com.tencent.mobileqq.app.automator.ReportDevice;
import com.tencent.mobileqq.app.automator.TimerChecker;
import com.tencent.mobileqq.app.automator.step.ActiveAccount;
import com.tencent.mobileqq.app.automator.step.ActivityDAUReport;
import com.tencent.mobileqq.app.automator.step.AfterSyncMsg;
import com.tencent.mobileqq.app.automator.step.AppNewsAlert;
import com.tencent.mobileqq.app.automator.step.AutomatorFinish;
import com.tencent.mobileqq.app.automator.step.CameraCategoryMaterialStep;
import com.tencent.mobileqq.app.automator.step.ChatBackgroundAuth;
import com.tencent.mobileqq.app.automator.step.CheckAuthCode;
import com.tencent.mobileqq.app.automator.step.CheckFriendsLastLoginInfo;
import com.tencent.mobileqq.app.automator.step.CheckHotSpotNode;
import com.tencent.mobileqq.app.automator.step.CheckMsgCount;
import com.tencent.mobileqq.app.automator.step.CheckPublicAccount;
import com.tencent.mobileqq.app.automator.step.CheckQZoneOatFile;
import com.tencent.mobileqq.app.automator.step.CheckSafeCenterConfig;
import com.tencent.mobileqq.app.automator.step.CleanCache;
import com.tencent.mobileqq.app.automator.step.EcShopFirstRunMsgConfigs;
import com.tencent.mobileqq.app.automator.step.GetApolloContentUpdateStatus;
import com.tencent.mobileqq.app.automator.step.GetBigEmoticonStep;
import com.tencent.mobileqq.app.automator.step.GetCheckUpdate;
import com.tencent.mobileqq.app.automator.step.GetClubContentUpdateStatus;
import com.tencent.mobileqq.app.automator.step.GetCommonUsedSystemEmojiStep;
import com.tencent.mobileqq.app.automator.step.GetConfig;
import com.tencent.mobileqq.app.automator.step.GetDiscussionInfo;
import com.tencent.mobileqq.app.automator.step.GetDonateFriends;
import com.tencent.mobileqq.app.automator.step.GetEmosmList;
import com.tencent.mobileqq.app.automator.step.GetEmoticonWhenNoFile;
import com.tencent.mobileqq.app.automator.step.GetFunCallData;
import com.tencent.mobileqq.app.automator.step.GetGeneralSettings;
import com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListMessageStep;
import com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListStep;
import com.tencent.mobileqq.app.automator.step.GetNumRedStep;
import com.tencent.mobileqq.app.automator.step.GetQZoneFeedCount;
import com.tencent.mobileqq.app.automator.step.GetQZoneFeeds;
import com.tencent.mobileqq.app.automator.step.GetQZonePhotoGuideCheck;
import com.tencent.mobileqq.app.automator.step.GetRecommendEmotionStep;
import com.tencent.mobileqq.app.automator.step.GetRedpointStep;
import com.tencent.mobileqq.app.automator.step.GetSecMsgConfigs;
import com.tencent.mobileqq.app.automator.step.GetSecMsgNewSeq;
import com.tencent.mobileqq.app.automator.step.GetSelfInfo;
import com.tencent.mobileqq.app.automator.step.GetSelfPendantId;
import com.tencent.mobileqq.app.automator.step.GetSig;
import com.tencent.mobileqq.app.automator.step.GetSplashConfig;
import com.tencent.mobileqq.app.automator.step.GetSubAccount;
import com.tencent.mobileqq.app.automator.step.GetSubAccountSpecialCare;
import com.tencent.mobileqq.app.automator.step.GetTbsSwitchInfo;
import com.tencent.mobileqq.app.automator.step.GetTroopAssisMsg;
import com.tencent.mobileqq.app.automator.step.GetTroopConfig;
import com.tencent.mobileqq.app.automator.step.GetTroopRedPointInfoStep;
import com.tencent.mobileqq.app.automator.step.GetWebViewAuthorize;
import com.tencent.mobileqq.app.automator.step.LimitChatSettingStep;
import com.tencent.mobileqq.app.automator.step.LoginWelcomeRequest;
import com.tencent.mobileqq.app.automator.step.MonitorSocketDownload;
import com.tencent.mobileqq.app.automator.step.NotifyQZoneServer;
import com.tencent.mobileqq.app.automator.step.PPCLoginAuth;
import com.tencent.mobileqq.app.automator.step.QAVStep;
import com.tencent.mobileqq.app.automator.step.QQComicStep;
import com.tencent.mobileqq.app.automator.step.QQUpdateVersion;
import com.tencent.mobileqq.app.automator.step.RegisterProxy;
import com.tencent.mobileqq.app.automator.step.RegisterPush;
import com.tencent.mobileqq.app.automator.step.ReportClientInfo;
import com.tencent.mobileqq.app.automator.step.ReportLoginInfo;
import com.tencent.mobileqq.app.automator.step.SendThemeAuth;
import com.tencent.mobileqq.app.automator.step.SetLogOn;
import com.tencent.mobileqq.app.automator.step.SignatureScan;
import com.tencent.mobileqq.app.automator.step.StartQSecLogic;
import com.tencent.mobileqq.app.automator.step.StartSecurityScan;
import com.tencent.mobileqq.app.automator.step.StartSecurityUpdate;
import com.tencent.mobileqq.app.automator.step.StartSmartDevice;
import com.tencent.mobileqq.app.automator.step.StartTxVerifyApk;
import com.tencent.mobileqq.app.automator.step.TimerCheckMsgCount;
import com.tencent.mobileqq.app.automator.step.TroopEnterEffectsStep;
import com.tencent.mobileqq.app.automator.step.UpdateDiscuss;
import com.tencent.mobileqq.app.automator.step.UpdateFriend;
import com.tencent.mobileqq.app.automator.step.UpdateIcon;
import com.tencent.mobileqq.app.automator.step.UpdateTroop;
import com.tencent.mobileqq.app.automator.step.VideoConfigUpdate;
import com.tencent.mobileqq.app.automator.step.VipCheckGift;
import com.tencent.mobileqq.app.automator.step.VipRequestMessageRoamPassword;
import com.tencent.mobileqq.app.automator.step.WeiyunCheckAlbum;
import com.tencent.mobileqq.app.automator.step.getLocalRedtouchStep;
import com.tencent.mobileqq.statistics.DailyReport;
import com.tencent.mobileqq.vashealth.StepServiceAsync;
import java.util.HashSet;
import java.util.Set;

public class ajws
{
  public static Set<Integer> a;
  public static final int[] a;
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 6, 12, 24, 168 };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "{,101}", "{94}", "{56,64,36,52,66,68,62,76,75,83,90,31}", "{}" };
    jdField_a_of_type_JavaUtilSet = new HashSet();
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(85));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(4));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(3));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(5));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(6));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(11));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(12));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(14));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(17));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(20));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(21));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(59));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(60));
  }
  
  public static int a(LinearGroup paramLinearGroup, boolean paramBoolean)
  {
    if ("{85,{4,3,5,6},[11,12,14],17,20,21,59,60,22,108,44,45,[100,65,25,10,26,27,28,29,30,32,34,35,39,40,41,42,43,47,48,50,55,107,69,93,70,71,72,73,{91},53,54,61,104,63,77,81,67,80,74,36,37,38,87,88,78,82,84,98,86,102,103,109,110,111,112],57,95,105}".equals(paramLinearGroup.jdField_a_of_type_JavaLangString)) {
      if (paramLinearGroup.e <= 4) {}
    }
    while (paramBoolean)
    {
      return 1;
      return 0;
    }
    return 0;
  }
  
  public static AsyncStep a(Automator paramAutomator, String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.trim();
    }
    if (TextUtils.isEmpty(str)) {
      throw new RuntimeException("createStepGroup: " + str);
    }
    int i = -1;
    if (str.startsWith("{"))
    {
      paramString = new LinearGroup();
      paramString.b = str;
    }
    for (;;)
    {
      paramString.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator = paramAutomator;
      paramString.b = i;
      if (i < 0) {
        break;
      }
      paramString.jdField_a_of_type_JavaLangString = paramString.getClass().getSimpleName();
      return paramString;
      if (str.startsWith("["))
      {
        paramString = new ParallGroup();
        paramString.b = str;
      }
      else
      {
        i = Integer.parseInt(str);
        switch (i)
        {
        case 49: 
        case 51: 
        case 62: 
        case 79: 
        case 82: 
        case 106: 
        default: 
          paramString = new AsyncStep();
          break;
        case 2: 
          paramString = new ActiveAccount();
          break;
        case 3: 
        case 7: 
        case 8: 
          paramString = new UpdateFriend();
          break;
        case 4: 
        case 9: 
          paramString = new UpdateTroop();
          break;
        case 5: 
          paramString = new UpdateDiscuss();
          break;
        case 6: 
        case 10: 
          paramString = new CheckPublicAccount();
          break;
        case 12: 
        case 13: 
          paramString = new RegisterPush();
          break;
        case 17: 
        case 18: 
        case 19: 
          paramString = new RegisterProxy();
          break;
        case 20: 
          paramString = new GetGeneralSettings();
          break;
        case 21: 
          paramString = new GetTroopAssisMsg();
          break;
        case 14: 
        case 15: 
        case 16: 
          paramString = new InitBeforeSyncMsg();
          break;
        case 11: 
          paramString = new GetSubAccount();
          break;
        case 22: 
        case 23: 
        case 24: 
          paramString = new AfterSyncMsg();
          break;
        case 26: 
          paramString = new GetEmoticonWhenNoFile();
          break;
        case 25: 
          paramString = new QAVStep();
          break;
        case 27: 
          paramString = new GetSelfPendantId();
          break;
        case 28: 
          paramString = new StartSecurityScan();
          break;
        case 29: 
          paramString = new GetEmosmList();
          break;
        case 30: 
          paramString = new GetSelfInfo();
          break;
        case 31: 
          paramString = new EcShopFirstRunMsgConfigs();
          break;
        case 32: 
          paramString = new GetSecMsgConfigs();
          break;
        case 33: 
          paramString = new GetSecMsgNewSeq();
          break;
        case 34: 
          paramString = new CheckFriendsLastLoginInfo();
          break;
        case 35: 
          paramString = new GetSig();
          break;
        case 36: 
          paramString = new StartSecurityUpdate();
          break;
        case 39: 
          paramString = new GetWebViewAuthorize();
          break;
        case 40: 
          paramString = new GetDiscussionInfo();
          break;
        case 41: 
          paramString = new SetLogOn();
          break;
        case 42: 
          paramString = new GetQZoneFeedCount();
          break;
        case 43: 
          paramString = new CheckQZoneOatFile();
          break;
        case 44: 
          paramString = new GetConfig();
          break;
        case 45: 
        case 46: 
          paramString = new GetCheckUpdate();
          break;
        case 47: 
          paramString = new GetSplashConfig();
          break;
        case 72: 
          paramString = new GetFunCallData();
          break;
        case 48: 
          paramString = new SendThemeAuth();
          break;
        case 50: 
          paramString = new GetTbsSwitchInfo();
          break;
        case 91: 
          paramString = new CheckAuthCode();
          break;
        case 52: 
          paramString = new CleanCache();
          break;
        case 53: 
          paramString = new CheckMsgCount();
          break;
        case 75: 
          paramString = new TimerCheckMsgCount();
          break;
        case 55: 
          paramString = new GetClubContentUpdateStatus();
          break;
        case 107: 
          paramString = new GetApolloContentUpdateStatus();
          break;
        case 56: 
          paramString = new VideoConfigUpdate();
          break;
        case 57: 
          paramString = new TimerChecker();
          break;
        case 105: 
          paramString = new AutomatorFinish();
          break;
        case 54: 
          paramString = new SignatureScan();
          break;
        case 58: 
        case 59: 
          paramString = new GetJoinedHotChatListStep();
          break;
        case 60: 
          paramString = new GetJoinedHotChatListMessageStep();
          break;
        case 61: 
          paramString = new GetTroopRedPointInfoStep();
          break;
        case 65: 
          paramString = new UpdateIcon();
          break;
        case 63: 
          paramString = new VipCheckGift();
          break;
        case 64: 
          paramString = new VipRequestMessageRoamPassword();
          break;
        case 66: 
          paramString = new ReportDevice();
          break;
        case 67: 
          paramString = new StartSmartDevice();
          break;
        case 68: 
          paramString = new WeiyunCheckAlbum();
          break;
        case 69: 
          paramString = new ChatBackgroundAuth();
          break;
        case 70: 
          paramString = new GetRecommendEmotionStep();
          break;
        case 73: 
          paramString = new PPCLoginAuth();
          break;
        case 71: 
          paramString = new GetNumRedStep();
          break;
        case 74: 
          paramString = new QQUpdateVersion();
          break;
        case 76: 
          paramString = new MonitorSocketDownload();
          break;
        case 77: 
          paramString = new GetQZoneFeeds();
          break;
        case 78: 
          paramString = new GetBigEmoticonStep();
          break;
        case 80: 
          paramString = new StepServiceAsync();
          break;
        case 81: 
          paramString = new GetQZonePhotoGuideCheck();
          break;
        case 83: 
          paramString = new ActivityDAUReport();
          break;
        case 84: 
          paramString = new CheckHotSpotNode();
          break;
        case 85: 
          paramString = new LoginWelcomeRequest();
          break;
        case 86: 
          paramString = new QQComicStep();
          break;
        case 87: 
          paramString = new GetDonateFriends();
          break;
        case 88: 
        case 89: 
          paramString = new GetRedpointStep();
          break;
        case 90: 
          paramString = new ReadInJoyDAUReport();
          break;
        case 92: 
          paramString = new getLocalRedtouchStep();
          break;
        case 93: 
          paramString = new GetCommonUsedSystemEmojiStep();
          break;
        case 94: 
          paramString = new DailyReport();
          break;
        case 95: 
        case 96: 
          paramString = new GetSubAccountSpecialCare();
          break;
        case 99: 
          paramString = new NotifyQZoneServer();
          break;
        case 37: 
          paramString = new ReportClientInfo();
          break;
        case 38: 
          paramString = new StartTxVerifyApk();
          break;
        case 97: 
        case 98: 
          paramString = new CheckSafeCenterConfig();
          break;
        case 100: 
          paramString = new GameCenterCheck();
          break;
        case 101: 
          paramString = new AppNewsAlert();
          break;
        case 102: 
          paramString = new StartQSecLogic();
          break;
        case 103: 
          paramString = new GetTroopConfig();
          break;
        case 104: 
          paramString = new TroopEnterEffectsStep();
          break;
        case 108: 
          paramString = new MiniMsgTabServerInitStep();
          break;
        case 109: 
          paramString = new QQReminderStepAsync();
          break;
        case 110: 
          paramString = new ReportLoginInfo();
          break;
        case 111: 
          paramString = new CameraCategoryMaterialStep();
          break;
        case 112: 
          paramString = new LimitChatSettingStep();
        }
      }
    }
    paramString.jdField_a_of_type_JavaLangString = str;
    return paramString;
  }
  
  public static boolean a(LinearGroup paramLinearGroup)
  {
    if ("{85,{4,3,5,6},[11,12,14],17,20,21,59,60,22,108,44,45,[100,65,25,10,26,27,28,29,30,32,34,35,39,40,41,42,43,47,48,50,55,107,69,93,70,71,72,73,{91},53,54,61,104,63,77,81,67,80,74,36,37,38,87,88,78,82,84,98,86,102,103,109,110,111,112],57,95,105}".equals(paramLinearGroup.jdField_a_of_type_JavaLangString)) {
      if (paramLinearGroup.e < 3) {}
    }
    do
    {
      do
      {
        return true;
        return false;
        if (!"{[13,16],19,21,58,60,89,23,46,33,61,42,92,96,97,99}".equals(paramLinearGroup.jdField_a_of_type_JavaLangString)) {
          break;
        }
      } while (paramLinearGroup.e >= 1);
      return false;
    } while (("{15,18,21,58,60,24}".equals(paramLinearGroup.jdField_a_of_type_JavaLangString)) || (!"{[11,12,14],17,20,21,22108,}".equals(paramLinearGroup.jdField_a_of_type_JavaLangString)) || (paramLinearGroup.e >= 2));
    return false;
  }
  
  public static boolean b(LinearGroup paramLinearGroup)
  {
    return (!"{85,{4,3,5,6},[11,12,14],17,20,21,59,60,22,108,44,45,[100,65,25,10,26,27,28,29,30,32,34,35,39,40,41,42,43,47,48,50,55,107,69,93,70,71,72,73,{91},53,54,61,104,63,77,81,67,80,74,36,37,38,87,88,78,82,84,98,86,102,103,109,110,111,112],57,95,105}".equals(paramLinearGroup.jdField_a_of_type_JavaLangString)) || (paramLinearGroup.e > 5);
  }
  
  public static boolean c(LinearGroup paramLinearGroup)
  {
    if ("{85,{4,3,5,6},[11,12,14],17,20,21,59,60,22,108,44,45,[100,65,25,10,26,27,28,29,30,32,34,35,39,40,41,42,43,47,48,50,55,107,69,93,70,71,72,73,{91},53,54,61,104,63,77,81,67,80,74,36,37,38,87,88,78,82,84,98,86,102,103,109,110,111,112],57,95,105}".equals(paramLinearGroup.jdField_a_of_type_JavaLangString)) {
      if (paramLinearGroup.e <= 4) {}
    }
    do
    {
      do
      {
        do
        {
          return true;
          return false;
          if (!"{[13,16],19,21,58,60,89,23,46,33,61,42,92,96,97,99}".equals(paramLinearGroup.jdField_a_of_type_JavaLangString)) {
            break;
          }
        } while (paramLinearGroup.e > 2);
        return false;
        if (!"{15,18,21,58,60,24}".equals(paramLinearGroup.jdField_a_of_type_JavaLangString)) {
          break;
        }
      } while (paramLinearGroup.e > 2);
      return false;
    } while ((!"{[11,12,14],17,20,21,22108,}".equals(paramLinearGroup.jdField_a_of_type_JavaLangString)) || (paramLinearGroup.e > 2));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajws
 * JD-Core Version:    0.7.0.1
 */