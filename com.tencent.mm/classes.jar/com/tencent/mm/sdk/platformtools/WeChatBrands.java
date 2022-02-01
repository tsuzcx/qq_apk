package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.b.a;
import com.tencent.threadpool.i;

public class WeChatBrands
{
  public static final String TAG = "MicroMsg.WeChatBrands";
  
  public static void update(int paramInt)
  {
    AppMethodBeat.i(243366);
    int i = paramInt;
    if (paramInt == 0) {
      i = AppInfo.current().getDefaultXAgreementId();
    }
    WeChatBrands.UserInfo.xagreementId = i;
    updateEnableAutoSeparate();
    AppMethodBeat.o(243366);
  }
  
  public static void updateBizRestrictAlertHandler(androidx.a.a.c.a<WeChatBrands.Business.Entries, Boolean> parama)
  {
    Business.sAlertHandler = parama;
  }
  
  public static void updateBizRestrictAlertSupplier(WeChatBrands.Business.AvailabilityAlertSupplier paramAvailabilityAlertSupplier)
  {
    Business.sAlertSupplier = paramAvailabilityAlertSupplier;
  }
  
  public static void updateBizRestrictHandler(androidx.a.a.c.a<WeChatBrands.Business.Entries, Boolean> parama)
  {
    Business.sRestrictHanlder = parama;
  }
  
  private static void updateEnableAutoSeparate()
  {
    AppMethodBeat.i(243384);
    if (("HK".equals(AppInfo.lang)) || ("TW".equals(AppInfo.lang)))
    {
      WeChatBrands.Wordings.access$102(true);
      AppMethodBeat.o(243384);
      return;
    }
    WeChatBrands.Wordings.access$102(false);
    AppMethodBeat.o(243384);
  }
  
  public static void updateLang(String paramString)
  {
    AppMethodBeat.i(243374);
    AppInfo.lang = AppInfo.getBrandLang(paramString);
    updateEnableAutoSeparate();
    if (WeChatBrands.Wordings.access$000().mReplacer != null) {
      WeChatBrands.Wordings.access$000().mReplacer.reload();
    }
    AppMethodBeat.o(243374);
  }
  
  public static void updateReplacer(WeChatBrands.IReplaceApply<String, String> paramIReplaceApply)
  {
    AppMethodBeat.i(243381);
    WeChatBrands.Wordings.access$000().attachReplacer(paramIReplaceApply);
    AppMethodBeat.o(243381);
  }
  
  public static class AppInfo
  {
    public static final String LANG_CN = "CN";
    public static final String LANG_EN = "EN";
    public static final String LANG_HK = "HK";
    public static final String LANG_TW = "TW";
    public static String lang;
    
    static
    {
      AppMethodBeat.i(243866);
      lang = getBrandLang(LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
      AppMethodBeat.o(243866);
    }
    
    public static WhichApp current()
    {
      return com.tencent.mm.co.a.agWg;
    }
    
    public static String getBrandLang(String paramString)
    {
      AppMethodBeat.i(243861);
      int i = -1;
      switch (paramString.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          AppMethodBeat.o(243861);
          return "EN";
          if (paramString.equals("zh_CN"))
          {
            i = 0;
            continue;
            if (paramString.equals("zh_HK"))
            {
              i = 1;
              continue;
              if (paramString.equals("zh_TW"))
              {
                i = 2;
                continue;
                if (paramString.equals("en")) {
                  i = 3;
                }
              }
            }
          }
          break;
        }
      }
      AppMethodBeat.o(243861);
      return "CN";
      AppMethodBeat.o(243861);
      return "HK";
      AppMethodBeat.o(243861);
      return "TW";
    }
    
    public static boolean isSimplifiedChinese()
    {
      AppMethodBeat.i(243857);
      boolean bool = String.valueOf(lang).toUpperCase().equals("CN");
      AppMethodBeat.o(243857);
      return bool;
    }
    
    public static final class WhichApp
    {
      private final int mDefaultXAgreementId;
      private final String mPackageName;
      private final String mUA;
      
      public WhichApp(String paramString1, String paramString2, int paramInt)
      {
        this.mPackageName = paramString1;
        this.mUA = paramString2;
        this.mDefaultXAgreementId = paramInt;
      }
      
      public final int getDefaultXAgreementId()
      {
        return this.mDefaultXAgreementId;
      }
      
      public final String getPackageName()
      {
        return this.mPackageName;
      }
      
      public final String getUserAgent()
      {
        return this.mUA;
      }
      
      public final boolean isMainland()
      {
        return this.mDefaultXAgreementId == 0;
      }
      
      public final boolean isUS()
      {
        return this.mDefaultXAgreementId == 3;
      }
    }
  }
  
  public static class Business
  {
    public static final String GROUP_ADS = "ads";
    public static final String GROUP_CHANNELS = "channels";
    public static final String GROUP_CROSS_DATA = "cross_data";
    public static final String GROUP_LIVE = "live";
    public static final String GROUP_MP = "mp";
    public static final String GROUP_OA = "oa";
    public static final String GROUP_OPEN = "open";
    public static final String GROUP_PAY = "pay";
    public static final String GROUP_SEARCH = "search";
    public static final String GROUP_SECONDARY = "secondary";
    public static final String GROUP_THIRD_PARTY = "third_party";
    public static final String GROUP_WECHAT_OUT = "wechat_out";
    public static final String GROUP_WECOM = "wecom";
    public static final int STATUS_O = 0;
    public static final int STATUS_R = 2;
    public static final int STATUS_X = 1;
    static androidx.a.a.c.a<Entries, Boolean> sAlertHandler;
    static WeChatBrands.Business.AvailabilityAlertSupplier sAlertSupplier;
    static androidx.a.a.c.a<Entries, Boolean> sRestrictHanlder;
    
    static
    {
      AppMethodBeat.i(243380);
      sRestrictHanlder = new androidx.a.a.c.a()
      {
        public Boolean apply(WeChatBrands.Business.Entries paramAnonymousEntries)
        {
          AppMethodBeat.i(244166);
          boolean bool = paramAnonymousEntries.restricted();
          AppMethodBeat.o(244166);
          return Boolean.valueOf(bool);
        }
      };
      sAlertHandler = new androidx.a.a.c.a()
      {
        public Boolean apply(WeChatBrands.Business.Entries paramAnonymousEntries)
        {
          AppMethodBeat.i(244149);
          boolean bool = paramAnonymousEntries.signRequsted();
          AppMethodBeat.o(244149);
          return Boolean.valueOf(bool);
        }
      };
      sAlertSupplier = new WeChatBrands.Business.AvailabilityAlertSupplier();
      AppMethodBeat.o(243380);
    }
    
    public static enum Entries
    {
      public final String group;
      public final String identifier;
      public final int status;
      
      static
      {
        AppMethodBeat.i(243915);
        GlobalScan = new Entries("GlobalScan", 0, "pay", 0);
        GlobalAppbrand = new Entries("GlobalAppbrand", 1, "mp", 1);
        GlobalWeCom = new Entries("GlobalWeCom", 2, "wecom", 1);
        Global3rdSrv = new Entries("Global3rdSrv", 3, 2);
        HomeMorePayment = new Entries("HomeMorePayment", 4, "pay", 1);
        HomeMoreFeedback = new Entries("HomeMoreFeedback", 5, 2);
        HomeAppbrandDrawer = new Entries("HomeAppbrandDrawer", 6, "mp", 1);
        HomeNotifyMessage = new Entries("HomeNotifyMessage", 7, "oa", 1);
        HomeServiceOa = new Entries("HomeServiceOa", 8, "oa", 1);
        HomeServiceMp = new Entries("HomeServiceMp", 9, "oa", 1);
        HomePluginQQMail = new Entries("HomePluginQQMail", 10, "third_party", 2);
        HomePluginSports = new Entries("HomePluginSports", 11, "cross_data", 1);
        HomePluginWePay = new Entries("HomePluginWePay", 12, "pay", 1);
        ContactNewFriendOa = new Entries("ContactNewFriendOa", 13, "oa", 1);
        ContactNewFriendWeWeCom = new Entries("ContactNewFriendWeWeCom", 14, "wecom", 1);
        ContactOa = new Entries("ContactOa", 15, "oa", 1);
        ContactWeCom = new Entries("ContactWeCom", 16, "wecom", 1);
        DiscoveryScanPayCode = new Entries("DiscoveryScanPayCode", 17, "pay", 1);
        DiscoveryScanPayReward = new Entries("DiscoveryScanPayReward", 18, "pay", 1);
        DiscoveryScanAppbrand = new Entries("DiscoveryScanAppbrand", 19, "mp", 1);
        DiscoveryScanFace2Face = new Entries("DiscoveryScanFace2Face", 20, "pay", 1);
        DiscoveryScanRecognize = new Entries("DiscoveryScanRecognize", 21, "cross_data", 1);
        DiscoveryScanTranslate = new Entries("DiscoveryScanTranslate", 22, "cross_data", 1);
        DiscoveryScanSecondary = new Entries("DiscoveryScanSecondary", 23, "secondary", 1);
        DiscoveryScanExtDevice = new Entries("DiscoveryScanExtDevice", 24, 2);
        DiscoveryChannels = new Entries("DiscoveryChannels", 25, "channels", 2);
        DiscoveryChannelsLive = new Entries("DiscoveryChannelsLive", 26, "channels", 2);
        DiscoveryShake = new Entries("DiscoveryShake", 27, "cross_data", 1);
        DiscoveryLooks = new Entries("DiscoveryLooks", 28, "search", 1);
        DiscoverySearch = new Entries("DiscoverySearch", 29, "search", 1);
        DiscoveryNearby = new Entries("DiscoveryNearby", 30, "cross_data", 1);
        DiscoveryNearbyLiveFriends = new Entries("DiscoveryNearbyLiveFriends", 31, "cross_data", 1);
        DiscoveryShop = new Entries("DiscoveryShop", 32, "third_party", 1);
        DiscoveryGame = new Entries("DiscoveryGame", 33, "third_party", 1);
        DiscoveryAppbrand = new Entries("DiscoveryAppbrand", 34, "mp", 1);
        DiscoveryWeChatOut = new Entries("DiscoveryWeChatOut", 35, "wechat_out", 1);
        MePayment = new Entries("MePayment", 36, "pay", 1);
        MeCouponCard = new Entries("MeCouponCard", 37, "pay", 1);
        MeAvatarAddress = new Entries("MeAvatarAddress", 38, "pay", 1);
        MeAvatarInvoiceTitle = new Entries("MeAvatarInvoiceTitle", 39, "pay", 1);
        MeAvatarWeChatId = new Entries("MeAvatarWeChatId", 40, 2);
        MeStickerDeclare = new Entries("MeStickerDeclare", 41, 2);
        MeSetSecurityVoicePrint = new Entries("MeSetSecurityVoicePrint", 42, 2);
        MeSetSecurityQQ = new Entries("MeSetSecurityQQ", 43, 2);
        MeSetSecurityFacebook = new Entries("MeSetSecurityFacebook", 44, 2);
        MeSetSecurityApple = new Entries("MeSetSecurityApple", 45, 2);
        MeSetNewMsgChannels = new Entries("MeSetNewMsgChannels", 46, "channels", 2);
        MeSetPrivacyAddByQQ = new Entries("MeSetPrivacyAddByQQ", 47, 2);
        MeSetPrivacyPermissions = new Entries("MeSetPrivacyPermissions", 48, "open", 1);
        MeSetAboutIntros = new Entries("MeSetAboutIntros", 49, 2);
        MeSetPlugin = new Entries("MeSetPlugin", 50, 2);
        MeSetDiscoveryChannels = new Entries("MeSetDiscoveryChannels", 51, 0);
        MeSetDiscoveryFinderLive = new Entries("MeSetDiscoveryFinderLive", 52, 0);
        MeSetDiscoveryShake = new Entries("MeSetDiscoveryShake", 53, 0);
        MeSetDiscoveryLooks = new Entries("MeSetDiscoveryLooks", 54, 0);
        MeSetDiscoverySearch = new Entries("MeSetDiscoverySearch", 55, 0);
        MeSetDiscoveryNearby = new Entries("MeSetDiscoveryNearby", 56, 0);
        MeSetDiscoveryNearbyLiveFriends = new Entries("MeSetDiscoveryNearbyLiveFriends", 57, 0);
        MeSetDiscoveryNearbyLiveFriendsPerson = new Entries("MeSetDiscoveryNearbyLiveFriendsPerson", 58, 0);
        MeSetDiscoveryShop = new Entries("MeSetDiscoveryShop", 59, 0);
        MeSetDiscoveryGame = new Entries("MeSetDiscoveryGame", 60, 0);
        MeSetDiscoveryAppbrand = new Entries("MeSetDiscoveryAppbrand", 61, 0);
        MeSetDiscoveryWeChatOut = new Entries("MeSetDiscoveryWeChatOut", 62, 0);
        LoginRegistFacebook = new Entries("LoginRegistFacebook", 63, 2);
        LoginRegistApple = new Entries("LoginRegistApple", 64, 2);
        LoginFacebook = new Entries("LoginFacebook", 65, 2);
        LoginApple = new Entries("LoginApple", 66, 2);
        LoginQQ = new Entries("LoginQQ", 67, 2);
        LoginPasswordReset = new Entries("LoginPasswordReset", 68, 0);
        ContextTranslate = new Entries("ContextTranslate", 69, "cross_data", 1);
        ContextSearch = new Entries("ContextSearch", 70, "search", 1);
        SessionSpeech2TextSnd = new Entries("SessionSpeech2TextSnd", 71, "cross_data", 1);
        SessionSpeech2TextRcv = new Entries("SessionSpeech2TextRcv", 72, "cross_data", 1);
        SessionMusic = new Entries("SessionMusic", 73, "cross_data", 1);
        SessionLocation = new Entries("SessionLocation", 74, "cross_data", 1);
        SessionAppbrand = new Entries("SessionAppbrand", 75, "mp", 1);
        SessionOa = new Entries("SessionOa", 76, "oa", 1);
        SessionLuckyMoney = new Entries("SessionLuckyMoney", 77, "pay", 1);
        SessionPayment = new Entries("SessionPayment", 78, "pay", 1);
        SessionCouponCard = new Entries("SessionCouponCard", 79, "pay", 1);
        SessionGroupTools = new Entries("SessionGroupTools", 80, "mp", 1);
        SessionGroupSolitaire = new Entries("SessionGroupSolitaire", 81, "mp", 0);
        SessionGroupLive = new Entries("SessionGroupLive", 82, "live", 1);
        SessionChannels = new Entries("SessionChannels", 83, "channels", 2);
        SessionVoiceMsg = new Entries("SessionVoiceMsg", 84, "cross_data", 1);
        PaymentH5Jsb = new Entries("PaymentH5Jsb", 85, "pay", 1);
        PaymentAppbrandJsb = new Entries("PaymentAppbrandJsb", 86, "pay", 1);
        PaymentOpenSdk = new Entries("PaymentOpenSdk", 87, "pay", 1);
        MomentChannels = new Entries("MomentChannels", 88, "channels", 2);
        MomentAds = new Entries("MomentAds", 89, "ads", 1);
        MomentApprand = new Entries("MomentApprand", 90, "mp", 1);
        Unknown = new Entries("Unknown", 91, "unknownKey", "unknownGroup", 2);
        $VALUES = new Entries[] { GlobalScan, GlobalAppbrand, GlobalWeCom, Global3rdSrv, HomeMorePayment, HomeMoreFeedback, HomeAppbrandDrawer, HomeNotifyMessage, HomeServiceOa, HomeServiceMp, HomePluginQQMail, HomePluginSports, HomePluginWePay, ContactNewFriendOa, ContactNewFriendWeWeCom, ContactOa, ContactWeCom, DiscoveryScanPayCode, DiscoveryScanPayReward, DiscoveryScanAppbrand, DiscoveryScanFace2Face, DiscoveryScanRecognize, DiscoveryScanTranslate, DiscoveryScanSecondary, DiscoveryScanExtDevice, DiscoveryChannels, DiscoveryChannelsLive, DiscoveryShake, DiscoveryLooks, DiscoverySearch, DiscoveryNearby, DiscoveryNearbyLiveFriends, DiscoveryShop, DiscoveryGame, DiscoveryAppbrand, DiscoveryWeChatOut, MePayment, MeCouponCard, MeAvatarAddress, MeAvatarInvoiceTitle, MeAvatarWeChatId, MeStickerDeclare, MeSetSecurityVoicePrint, MeSetSecurityQQ, MeSetSecurityFacebook, MeSetSecurityApple, MeSetNewMsgChannels, MeSetPrivacyAddByQQ, MeSetPrivacyPermissions, MeSetAboutIntros, MeSetPlugin, MeSetDiscoveryChannels, MeSetDiscoveryFinderLive, MeSetDiscoveryShake, MeSetDiscoveryLooks, MeSetDiscoverySearch, MeSetDiscoveryNearby, MeSetDiscoveryNearbyLiveFriends, MeSetDiscoveryNearbyLiveFriendsPerson, MeSetDiscoveryShop, MeSetDiscoveryGame, MeSetDiscoveryAppbrand, MeSetDiscoveryWeChatOut, LoginRegistFacebook, LoginRegistApple, LoginFacebook, LoginApple, LoginQQ, LoginPasswordReset, ContextTranslate, ContextSearch, SessionSpeech2TextSnd, SessionSpeech2TextRcv, SessionMusic, SessionLocation, SessionAppbrand, SessionOa, SessionLuckyMoney, SessionPayment, SessionCouponCard, SessionGroupTools, SessionGroupSolitaire, SessionGroupLive, SessionChannels, SessionVoiceMsg, PaymentH5Jsb, PaymentAppbrandJsb, PaymentOpenSdk, MomentChannels, MomentAds, MomentApprand, Unknown };
        AppMethodBeat.o(243915);
      }
      
      private Entries(int paramInt)
      {
        this.identifier = "";
        this.group = "";
        this.status = paramInt;
      }
      
      private Entries(String paramString, int paramInt)
      {
        this.identifier = "";
        this.group = paramString;
        this.status = paramInt;
      }
      
      private Entries(String paramString1, String paramString2, int paramInt)
      {
        this.identifier = paramString1;
        this.group = paramString2;
        this.status = paramInt;
      }
      
      public static boolean banned(int paramInt)
      {
        boolean bool = false;
        AppMethodBeat.i(243889);
        if (WeChatBrands.AppInfo.current().isMainland())
        {
          AppMethodBeat.o(243889);
          return false;
        }
        if (paramInt == 2) {
          bool = true;
        }
        Log.i("MicroMsg.WeChatBrands", "Business.Entry#isBanned = ".concat(String.valueOf(bool)));
        AppMethodBeat.o(243889);
        return bool;
      }
      
      private static boolean checkExpansionsInstalled(Entries paramEntries)
      {
        AppMethodBeat.i(243899);
        boolean bool;
        if (paramEntries == SessionLocation)
        {
          bool = com.tencent.mm.compatible.util.h.aQh();
          AppMethodBeat.o(243899);
          return bool;
        }
        if (paramEntries == MomentAds)
        {
          bool = com.tencent.mm.compatible.util.h.aQh();
          AppMethodBeat.o(243899);
          return bool;
        }
        if ((paramEntries.group.equals("channels")) || (paramEntries.group.equals("live")))
        {
          bool = com.tencent.mm.compatible.util.h.aQh();
          AppMethodBeat.o(243899);
          return bool;
        }
        AppMethodBeat.o(243899);
        return true;
      }
      
      public static boolean restricted(int paramInt)
      {
        boolean bool = false;
        AppMethodBeat.i(243879);
        if (WeChatBrands.AppInfo.current().isMainland())
        {
          AppMethodBeat.o(243879);
          return false;
        }
        if (paramInt != 0) {
          bool = true;
        }
        Log.i("MicroMsg.WeChatBrands", "Business.Entry#isRestricted = ".concat(String.valueOf(bool)));
        AppMethodBeat.o(243879);
        return bool;
      }
      
      public static void showAlert(Context paramContext, final androidx.core.f.a<Integer> parama)
      {
        AppMethodBeat.i(243893);
        paramContext = new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(243590);
            if (!com.tencent.mm.compatible.util.h.aQh())
            {
              Toast.makeText(WeChatBrands.Business.Entries.this, b.a.app_err_system_busy_tip, 1).show();
              AppMethodBeat.o(243590);
              return;
            }
            if (((WeChatBrands.Business.Entries.this instanceof Activity)) || (((WeChatBrands.Business.Entries.this instanceof ContextWrapper)) && ((((ContextWrapper)WeChatBrands.Business.Entries.this).getBaseContext() instanceof Activity))))
            {
              WeChatBrands.Business.sAlertSupplier.attach(parama).showDialog(WeChatBrands.Business.Entries.this);
              AppMethodBeat.o(243590);
              return;
            }
            StringBuilder localStringBuilder = new StringBuilder("Business.Entry#showAlert error: the given context is not activty, context = ");
            if (WeChatBrands.Business.Entries.this == null) {}
            for (Object localObject = "null";; localObject = WeChatBrands.Business.Entries.this.getClass())
            {
              Log.i("MicroMsg.WeChatBrands", localObject);
              AppMethodBeat.o(243590);
              return;
            }
          }
        };
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          paramContext.run();
          AppMethodBeat.o(243893);
          return;
        }
        com.tencent.threadpool.h.ahAA.bk(paramContext);
        AppMethodBeat.o(243893);
      }
      
      public static boolean signRequsted(int paramInt)
      {
        boolean bool = true;
        AppMethodBeat.i(243882);
        if (WeChatBrands.AppInfo.current().isMainland())
        {
          AppMethodBeat.o(243882);
          return false;
        }
        if (paramInt == 1) {}
        for (;;)
        {
          Log.i("MicroMsg.WeChatBrands", "Business.Entry#signRequsted = ".concat(String.valueOf(bool)));
          AppMethodBeat.o(243882);
          return bool;
          bool = false;
        }
      }
      
      public final boolean banned()
      {
        AppMethodBeat.i(243937);
        if ((!checkExpansionsInstalled(this)) || (banned(this.status)))
        {
          AppMethodBeat.o(243937);
          return true;
        }
        AppMethodBeat.o(243937);
        return false;
      }
      
      public final boolean checkAvailable(Context paramContext)
      {
        AppMethodBeat.i(243942);
        boolean bool = checkAvailable(paramContext, null);
        AppMethodBeat.o(243942);
        return bool;
      }
      
      public final boolean checkAvailable(Context paramContext, androidx.core.f.a<Integer> parama)
      {
        AppMethodBeat.i(243949);
        if (checkExpansionsInstalled(this))
        {
          if (WeChatBrands.AppInfo.current().isMainland())
          {
            AppMethodBeat.o(243949);
            return true;
          }
          if (!((Boolean)WeChatBrands.Business.sRestrictHanlder.apply(this)).booleanValue())
          {
            AppMethodBeat.o(243949);
            return true;
          }
          if (!((Boolean)WeChatBrands.Business.sAlertHandler.apply(this)).booleanValue())
          {
            AppMethodBeat.o(243949);
            return false;
          }
        }
        showAlert(paramContext, parama);
        AppMethodBeat.o(243949);
        return false;
      }
      
      public final boolean checkAvailableSlient(Context paramContext, androidx.core.f.a<WeChatBrands.Business.AvailabilityAlertSupplier> parama)
      {
        AppMethodBeat.i(243958);
        if (checkExpansionsInstalled(this))
        {
          if (WeChatBrands.AppInfo.current().isMainland())
          {
            AppMethodBeat.o(243958);
            return true;
          }
          if (!((Boolean)WeChatBrands.Business.sRestrictHanlder.apply(this)).booleanValue())
          {
            AppMethodBeat.o(243958);
            return true;
          }
          if (((paramContext instanceof Activity)) && (((Boolean)WeChatBrands.Business.sAlertHandler.apply(this)).booleanValue()) && (parama != null)) {
            parama.accept(WeChatBrands.Business.sAlertSupplier);
          }
        }
        AppMethodBeat.o(243958);
        return false;
      }
      
      public final boolean restricted()
      {
        AppMethodBeat.i(243924);
        if ((!checkExpansionsInstalled(this)) || (restricted(this.status)))
        {
          AppMethodBeat.o(243924);
          return true;
        }
        AppMethodBeat.o(243924);
        return false;
      }
      
      public final boolean signRequsted()
      {
        AppMethodBeat.i(243930);
        if ((!checkExpansionsInstalled(this)) || (signRequsted(this.status)))
        {
          AppMethodBeat.o(243930);
          return true;
        }
        AppMethodBeat.o(243930);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.WeChatBrands
 * JD-Core Version:    0.7.0.1
 */