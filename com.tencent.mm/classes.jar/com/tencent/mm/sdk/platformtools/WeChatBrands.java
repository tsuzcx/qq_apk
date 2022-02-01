package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import android.support.v4.e.c;
import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WeChatBrands
{
  public static final String TAG = "MicroMsg.WeChatBrands";
  
  public static void update(int paramInt)
  {
    AppMethodBeat.i(200969);
    int i = paramInt;
    if (paramInt == 0) {
      i = AppInfo.current().getDefaultXAgreementId();
    }
    UserInfo.xagreementId = i;
    updateEnableAutoSeparate();
    AppMethodBeat.o(200969);
  }
  
  public static void updateBizRestrictAlertHandler(android.arch.a.c.a<WeChatBrands.Business.Entries, Boolean> parama)
  {
    Business.sAlertHandler = parama;
  }
  
  public static void updateBizRestrictAlertSupplier(WeChatBrands.Business.AvailabilityAlertSupplier paramAvailabilityAlertSupplier)
  {
    Business.sAlertSupplier = paramAvailabilityAlertSupplier;
  }
  
  public static void updateBizRestrictHandler(android.arch.a.c.a<WeChatBrands.Business.Entries, Boolean> parama)
  {
    Business.sRestrictHanlder = parama;
  }
  
  private static void updateEnableAutoSeparate()
  {
    AppMethodBeat.i(200972);
    if (("HK".equals(AppInfo.lang)) || ("TW".equals(AppInfo.lang)))
    {
      Wordings.access$102(true);
      AppMethodBeat.o(200972);
      return;
    }
    Wordings.access$102(false);
    AppMethodBeat.o(200972);
  }
  
  public static void updateLang(String paramString)
  {
    AppMethodBeat.i(200970);
    AppInfo.lang = AppInfo.getBrandLang(paramString);
    updateEnableAutoSeparate();
    if (Wordings.handler.mReplacer != null) {
      Wordings.handler.mReplacer.reload();
    }
    AppMethodBeat.o(200970);
  }
  
  public static void updateReplacer(IReplaceApply<String, String> paramIReplaceApply)
  {
    AppMethodBeat.i(200971);
    Wordings.handler.attachReplacer(paramIReplaceApply);
    AppMethodBeat.o(200971);
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
      AppMethodBeat.i(200932);
      lang = getBrandLang(LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
      AppMethodBeat.o(200932);
    }
    
    public static WhichApp current()
    {
      return com.tencent.mm.cn.a.RwA;
    }
    
    public static String getBrandLang(String paramString)
    {
      AppMethodBeat.i(200931);
      int i = -1;
      switch (paramString.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          AppMethodBeat.o(200931);
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
      AppMethodBeat.o(200931);
      return "CN";
      AppMethodBeat.o(200931);
      return "HK";
      AppMethodBeat.o(200931);
      return "TW";
    }
    
    public static boolean isSimplifiedChinese()
    {
      AppMethodBeat.i(200930);
      boolean bool = String.valueOf(lang).toUpperCase().equals("CN");
      AppMethodBeat.o(200930);
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
    static android.arch.a.c.a<Entries, Boolean> sAlertHandler;
    static AvailabilityAlertSupplier sAlertSupplier;
    static android.arch.a.c.a<Entries, Boolean> sRestrictHanlder;
    
    static
    {
      AppMethodBeat.i(200951);
      sRestrictHanlder = new android.arch.a.c.a()
      {
        public final Boolean apply(WeChatBrands.Business.Entries paramAnonymousEntries)
        {
          AppMethodBeat.i(200933);
          boolean bool = paramAnonymousEntries.restricted();
          AppMethodBeat.o(200933);
          return Boolean.valueOf(bool);
        }
      };
      sAlertHandler = new android.arch.a.c.a()
      {
        public final Boolean apply(WeChatBrands.Business.Entries paramAnonymousEntries)
        {
          AppMethodBeat.i(200935);
          boolean bool = paramAnonymousEntries.signRequsted();
          AppMethodBeat.o(200935);
          return Boolean.valueOf(bool);
        }
      };
      sAlertSupplier = new AvailabilityAlertSupplier();
      AppMethodBeat.o(200951);
    }
    
    public static class AvailabilityAlertSupplier
    {
      public static final int ON_DISMISS = -1;
      public static final int ON_NO = 0;
      public static final int ON_YES = 1;
      protected String mBody;
      protected c<Integer> mCallback;
      protected String mNegativeBtnText;
      protected DialogInterface.OnClickListener mOnDismissListener;
      protected DialogInterface.OnClickListener mOnNegativeClickListener;
      protected DialogInterface.OnClickListener mOnPositiveClickListener;
      protected String mPositiveBtnText;
      protected String mTilte;
      
      public AvailabilityAlertSupplier attach(c<Integer> paramc)
      {
        this.mCallback = paramc;
        return this;
      }
      
      public String getBody()
      {
        return this.mBody;
      }
      
      public c<Integer> getCallback()
      {
        return this.mCallback;
      }
      
      public String getNegativeBtnText()
      {
        return this.mNegativeBtnText;
      }
      
      public DialogInterface.OnClickListener getOnDismissListener()
      {
        return this.mOnDismissListener;
      }
      
      public DialogInterface.OnClickListener getOnNegativeClickListener()
      {
        return this.mOnNegativeClickListener;
      }
      
      public DialogInterface.OnClickListener getOnPositiveClickListener()
      {
        return this.mOnPositiveClickListener;
      }
      
      public String getPositiveBtnText()
      {
        return this.mPositiveBtnText;
      }
      
      public String getTilte()
      {
        return this.mTilte;
      }
      
      public AvailabilityAlertSupplier setBody(String paramString)
      {
        this.mBody = paramString;
        return this;
      }
      
      public AvailabilityAlertSupplier setNegativeBtnText(String paramString)
      {
        this.mNegativeBtnText = paramString;
        return this;
      }
      
      public AvailabilityAlertSupplier setOnDismissListener(DialogInterface.OnClickListener paramOnClickListener)
      {
        this.mOnDismissListener = paramOnClickListener;
        return this;
      }
      
      public AvailabilityAlertSupplier setOnNegativeClickListener(DialogInterface.OnClickListener paramOnClickListener)
      {
        this.mOnNegativeClickListener = paramOnClickListener;
        return this;
      }
      
      public AvailabilityAlertSupplier setOnPositiveClickListener(DialogInterface.OnClickListener paramOnClickListener)
      {
        this.mOnPositiveClickListener = paramOnClickListener;
        return this;
      }
      
      public AvailabilityAlertSupplier setPositiveBtnText(String paramString)
      {
        this.mPositiveBtnText = paramString;
        return this;
      }
      
      public AvailabilityAlertSupplier setTilte(String paramString)
      {
        this.mTilte = paramString;
        return this;
      }
      
      public void showDialog(Context paramContext) {}
    }
    
    public static enum Entries
    {
      public final String group;
      public final String identifier;
      public final int status;
      
      static
      {
        AppMethodBeat.i(200950);
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
        DiscoveryShake = new Entries("DiscoveryShake", 26, "cross_data", 1);
        DiscoveryLooks = new Entries("DiscoveryLooks", 27, "search", 1);
        DiscoverySearch = new Entries("DiscoverySearch", 28, "search", 1);
        DiscoveryNearby = new Entries("DiscoveryNearby", 29, "cross_data", 1);
        DiscoveryNearbyLiveFriends = new Entries("DiscoveryNearbyLiveFriends", 30, "cross_data", 1);
        DiscoveryShop = new Entries("DiscoveryShop", 31, "third_party", 1);
        DiscoveryGame = new Entries("DiscoveryGame", 32, "third_party", 1);
        DiscoveryAppbrand = new Entries("DiscoveryAppbrand", 33, "mp", 1);
        DiscoveryWeChatOut = new Entries("DiscoveryWeChatOut", 34, "wechat_out", 1);
        MePayment = new Entries("MePayment", 35, "pay", 1);
        MeCouponCard = new Entries("MeCouponCard", 36, "pay", 1);
        MeAvatarAddress = new Entries("MeAvatarAddress", 37, "pay", 1);
        MeAvatarInvoiceTitle = new Entries("MeAvatarInvoiceTitle", 38, "pay", 1);
        MeAvatarWeChatId = new Entries("MeAvatarWeChatId", 39, 2);
        MeStickerDeclare = new Entries("MeStickerDeclare", 40, 2);
        MeSetSecurityVoicePrint = new Entries("MeSetSecurityVoicePrint", 41, 2);
        MeSetSecurityQQ = new Entries("MeSetSecurityQQ", 42, 2);
        MeSetSecurityFacebook = new Entries("MeSetSecurityFacebook", 43, 2);
        MeSetSecurityApple = new Entries("MeSetSecurityApple", 44, 2);
        MeSetNewMsgChannels = new Entries("MeSetNewMsgChannels", 45, "channels", 2);
        MeSetPrivacyAddByQQ = new Entries("MeSetPrivacyAddByQQ", 46, 2);
        MeSetPrivacyPermissions = new Entries("MeSetPrivacyPermissions", 47, "open", 1);
        MeSetAboutIntros = new Entries("MeSetAboutIntros", 48, 2);
        MeSetPlugin = new Entries("MeSetPlugin", 49, 2);
        MeSetDiscoveryChannels = new Entries("MeSetDiscoveryChannels", 50, 0);
        MeSetDiscoveryShake = new Entries("MeSetDiscoveryShake", 51, 0);
        MeSetDiscoveryLooks = new Entries("MeSetDiscoveryLooks", 52, 0);
        MeSetDiscoverySearch = new Entries("MeSetDiscoverySearch", 53, 0);
        MeSetDiscoveryNearby = new Entries("MeSetDiscoveryNearby", 54, 0);
        MeSetDiscoveryNearbyLiveFriends = new Entries("MeSetDiscoveryNearbyLiveFriends", 55, 0);
        MeSetDiscoveryNearbyLiveFriendsPerson = new Entries("MeSetDiscoveryNearbyLiveFriendsPerson", 56, 0);
        MeSetDiscoveryShop = new Entries("MeSetDiscoveryShop", 57, 0);
        MeSetDiscoveryGame = new Entries("MeSetDiscoveryGame", 58, 0);
        MeSetDiscoveryAppbrand = new Entries("MeSetDiscoveryAppbrand", 59, 0);
        MeSetDiscoveryWeChatOut = new Entries("MeSetDiscoveryWeChatOut", 60, 0);
        LoginRegistFacebook = new Entries("LoginRegistFacebook", 61, 2);
        LoginRegistApple = new Entries("LoginRegistApple", 62, 2);
        LoginFacebook = new Entries("LoginFacebook", 63, 2);
        LoginApple = new Entries("LoginApple", 64, 2);
        LoginQQ = new Entries("LoginQQ", 65, 2);
        LoginPasswordReset = new Entries("LoginPasswordReset", 66, 0);
        ContextTranslate = new Entries("ContextTranslate", 67, "cross_data", 1);
        ContextSearch = new Entries("ContextSearch", 68, "search", 1);
        SessionSpeech2TextSnd = new Entries("SessionSpeech2TextSnd", 69, "cross_data", 1);
        SessionSpeech2TextRcv = new Entries("SessionSpeech2TextRcv", 70, "cross_data", 1);
        SessionMusic = new Entries("SessionMusic", 71, "cross_data", 1);
        SessionLocation = new Entries("SessionLocation", 72, "cross_data", 1);
        SessionAppbrand = new Entries("SessionAppbrand", 73, "mp", 1);
        SessionOa = new Entries("SessionOa", 74, "oa", 1);
        SessionLuckyMoney = new Entries("SessionLuckyMoney", 75, "pay", 1);
        SessionPayment = new Entries("SessionPayment", 76, "pay", 1);
        SessionCouponCard = new Entries("SessionCouponCard", 77, "pay", 1);
        SessionGroupTools = new Entries("SessionGroupTools", 78, "mp", 1);
        SessionGroupSolitaire = new Entries("SessionGroupSolitaire", 79, "mp", 0);
        SessionGroupLive = new Entries("SessionGroupLive", 80, "live", 1);
        SessionChannels = new Entries("SessionChannels", 81, "channels", 2);
        SessionVoiceMsg = new Entries("SessionVoiceMsg", 82, "cross_data", 1);
        PaymentH5Jsb = new Entries("PaymentH5Jsb", 83, "pay", 1);
        PaymentAppbrandJsb = new Entries("PaymentAppbrandJsb", 84, "pay", 1);
        PaymentOpenSdk = new Entries("PaymentOpenSdk", 85, "pay", 1);
        MomentChannels = new Entries("MomentChannels", 86, "channels", 2);
        MomentAds = new Entries("MomentAds", 87, "ads", 1);
        MomentApprand = new Entries("MomentApprand", 88, "mp", 1);
        Unknown = new Entries("Unknown", 89, "unknownKey", "unknownGroup", 2);
        $VALUES = new Entries[] { GlobalScan, GlobalAppbrand, GlobalWeCom, Global3rdSrv, HomeMorePayment, HomeMoreFeedback, HomeAppbrandDrawer, HomeNotifyMessage, HomeServiceOa, HomeServiceMp, HomePluginQQMail, HomePluginSports, HomePluginWePay, ContactNewFriendOa, ContactNewFriendWeWeCom, ContactOa, ContactWeCom, DiscoveryScanPayCode, DiscoveryScanPayReward, DiscoveryScanAppbrand, DiscoveryScanFace2Face, DiscoveryScanRecognize, DiscoveryScanTranslate, DiscoveryScanSecondary, DiscoveryScanExtDevice, DiscoveryChannels, DiscoveryShake, DiscoveryLooks, DiscoverySearch, DiscoveryNearby, DiscoveryNearbyLiveFriends, DiscoveryShop, DiscoveryGame, DiscoveryAppbrand, DiscoveryWeChatOut, MePayment, MeCouponCard, MeAvatarAddress, MeAvatarInvoiceTitle, MeAvatarWeChatId, MeStickerDeclare, MeSetSecurityVoicePrint, MeSetSecurityQQ, MeSetSecurityFacebook, MeSetSecurityApple, MeSetNewMsgChannels, MeSetPrivacyAddByQQ, MeSetPrivacyPermissions, MeSetAboutIntros, MeSetPlugin, MeSetDiscoveryChannels, MeSetDiscoveryShake, MeSetDiscoveryLooks, MeSetDiscoverySearch, MeSetDiscoveryNearby, MeSetDiscoveryNearbyLiveFriends, MeSetDiscoveryNearbyLiveFriendsPerson, MeSetDiscoveryShop, MeSetDiscoveryGame, MeSetDiscoveryAppbrand, MeSetDiscoveryWeChatOut, LoginRegistFacebook, LoginRegistApple, LoginFacebook, LoginApple, LoginQQ, LoginPasswordReset, ContextTranslate, ContextSearch, SessionSpeech2TextSnd, SessionSpeech2TextRcv, SessionMusic, SessionLocation, SessionAppbrand, SessionOa, SessionLuckyMoney, SessionPayment, SessionCouponCard, SessionGroupTools, SessionGroupSolitaire, SessionGroupLive, SessionChannels, SessionVoiceMsg, PaymentH5Jsb, PaymentAppbrandJsb, PaymentOpenSdk, MomentChannels, MomentAds, MomentApprand, Unknown };
        AppMethodBeat.o(200950);
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
        AppMethodBeat.i(200948);
        if (WeChatBrands.AppInfo.current().isMainland())
        {
          AppMethodBeat.o(200948);
          return false;
        }
        if (paramInt == 2) {
          bool = true;
        }
        Log.i("MicroMsg.WeChatBrands", "Business.Entry#isBanned = ".concat(String.valueOf(bool)));
        AppMethodBeat.o(200948);
        return bool;
      }
      
      public static boolean restricted(int paramInt)
      {
        boolean bool = false;
        AppMethodBeat.i(200946);
        if (WeChatBrands.AppInfo.current().isMainland())
        {
          AppMethodBeat.o(200946);
          return false;
        }
        if (paramInt != 0) {
          bool = true;
        }
        Log.i("MicroMsg.WeChatBrands", "Business.Entry#isRestricted = ".concat(String.valueOf(bool)));
        AppMethodBeat.o(200946);
        return bool;
      }
      
      public static void showAlert(Context paramContext, final c<Integer> paramc)
      {
        AppMethodBeat.i(200949);
        paramContext = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(200937);
            if (((this.val$context instanceof Activity)) || (((this.val$context instanceof ContextWrapper)) && ((((ContextWrapper)this.val$context).getBaseContext() instanceof Activity))))
            {
              WeChatBrands.Business.sAlertSupplier.attach(paramc).showDialog(this.val$context);
              AppMethodBeat.o(200937);
              return;
            }
            StringBuilder localStringBuilder = new StringBuilder("Business.Entry#showAlert error: the given context is not activty, context = ");
            if (this.val$context == null) {}
            for (Object localObject = "null";; localObject = this.val$context.getClass())
            {
              Log.i("MicroMsg.WeChatBrands", localObject);
              AppMethodBeat.o(200937);
              return;
            }
          }
        };
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          paramContext.run();
          AppMethodBeat.o(200949);
          return;
        }
        h.RTc.aV(paramContext);
        AppMethodBeat.o(200949);
      }
      
      public static boolean signRequsted(int paramInt)
      {
        boolean bool = true;
        AppMethodBeat.i(200947);
        if (WeChatBrands.AppInfo.current().isMainland())
        {
          AppMethodBeat.o(200947);
          return false;
        }
        if (paramInt == 1) {}
        for (;;)
        {
          Log.i("MicroMsg.WeChatBrands", "Business.Entry#signRequsted = ".concat(String.valueOf(bool)));
          AppMethodBeat.o(200947);
          return bool;
          bool = false;
        }
      }
      
      public final boolean banned()
      {
        AppMethodBeat.i(200942);
        boolean bool = banned(this.status);
        AppMethodBeat.o(200942);
        return bool;
      }
      
      public final boolean checkAvailable(Context paramContext)
      {
        AppMethodBeat.i(200943);
        boolean bool = checkAvailable(paramContext, null);
        AppMethodBeat.o(200943);
        return bool;
      }
      
      public final boolean checkAvailable(Context paramContext, c<Integer> paramc)
      {
        AppMethodBeat.i(200944);
        if (WeChatBrands.AppInfo.current().isMainland())
        {
          AppMethodBeat.o(200944);
          return true;
        }
        if (!((Boolean)WeChatBrands.Business.sRestrictHanlder.apply(this)).booleanValue())
        {
          AppMethodBeat.o(200944);
          return true;
        }
        if (((Boolean)WeChatBrands.Business.sAlertHandler.apply(this)).booleanValue()) {
          showAlert(paramContext, paramc);
        }
        AppMethodBeat.o(200944);
        return false;
      }
      
      public final boolean checkAvailableSlient(Context paramContext, c<WeChatBrands.Business.AvailabilityAlertSupplier> paramc)
      {
        AppMethodBeat.i(200945);
        if (WeChatBrands.AppInfo.current().isMainland())
        {
          AppMethodBeat.o(200945);
          return true;
        }
        if (!((Boolean)WeChatBrands.Business.sRestrictHanlder.apply(this)).booleanValue())
        {
          AppMethodBeat.o(200945);
          return true;
        }
        if (((paramContext instanceof Activity)) && (((Boolean)WeChatBrands.Business.sAlertHandler.apply(this)).booleanValue()) && (paramc != null)) {
          paramc.accept(WeChatBrands.Business.sAlertSupplier);
        }
        AppMethodBeat.o(200945);
        return false;
      }
      
      public final boolean restricted()
      {
        AppMethodBeat.i(200940);
        boolean bool = restricted(this.status);
        AppMethodBeat.o(200940);
        return bool;
      }
      
      public final boolean signRequsted()
      {
        AppMethodBeat.i(200941);
        boolean bool = signRequsted(this.status);
        AppMethodBeat.o(200941);
        return bool;
      }
    }
  }
  
  public static abstract interface IReplaceApply<I, O>
  {
    public abstract O apply(I paramI, PInt paramPInt);
    
    public abstract void reload();
  }
  
  public static class PlaceHolderHandler
  {
    private static final String SYMBOL_END = "}";
    private static final int SYMBOL_END_LEN = 1;
    private static final String SYMBOL_STR = "${";
    private static final int SYMBOL_STR_LEN = 2;
    android.arch.a.c.a<List, String> mJoiner;
    WeChatBrands.IReplaceApply<String, String> mReplacer;
    
    public PlaceHolderHandler()
    {
      AppMethodBeat.i(200957);
      this.mReplacer = new WeChatBrands.IReplaceApply()
      {
        public String apply(String paramAnonymousString, PInt paramAnonymousPInt)
        {
          return paramAnonymousString;
        }
        
        public void reload() {}
      };
      this.mJoiner = new android.arch.a.c.a()
      {
        public String apply(List paramAnonymousList)
        {
          AppMethodBeat.i(200953);
          StringBuilder localStringBuilder = new StringBuilder();
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext()) {
            localStringBuilder.append(paramAnonymousList.next().toString());
          }
          paramAnonymousList = localStringBuilder.toString();
          AppMethodBeat.o(200953);
          return paramAnonymousList;
        }
      };
      AppMethodBeat.o(200957);
    }
    
    private static Object computePlaceHolders(String paramString, WeChatBrands.IReplaceApply<String, String> paramIReplaceApply)
    {
      AppMethodBeat.i(200959);
      try
      {
        paramIReplaceApply = iterateComputingPlaceHolders(paramString, paramIReplaceApply);
        AppMethodBeat.o(200959);
        return paramIReplaceApply;
      }
      catch (Throwable paramIReplaceApply)
      {
        Log.printErrStackTrace("MicroMsg.WeChatBrands", paramIReplaceApply, "compute place holders error: " + paramIReplaceApply.getMessage() + ", input = " + paramString, new Object[0]);
        AppMethodBeat.o(200959);
      }
      return paramString;
    }
    
    private static Object iterateComputingPlaceHolders(String paramString, WeChatBrands.IReplaceApply<String, String> paramIReplaceApply)
    {
      AppMethodBeat.i(200960);
      int i = paramString.indexOf("${");
      if (i < 0)
      {
        AppMethodBeat.o(200960);
        return paramString;
      }
      ArrayList localArrayList = new ArrayList(5);
      for (;;)
      {
        if (i > 0)
        {
          localArrayList.add(paramString.substring(0, i));
          paramString = paramString.substring(i);
          i = paramString.indexOf("${");
        }
        else
        {
          if (i < 0)
          {
            localArrayList.add(paramString);
            AppMethodBeat.o(200960);
            return localArrayList;
          }
          int j = paramString.indexOf("}");
          if ((j < 0) || (SYMBOL_STR_LEN + i >= paramString.length() - 1))
          {
            localArrayList.add(paramString);
            AppMethodBeat.o(200960);
            return localArrayList;
          }
          if (SYMBOL_STR_LEN + i == j)
          {
            localArrayList.add(paramString.substring(i, j + 1));
            paramString = paramString.substring(j + 1);
            i = paramString.indexOf("${");
          }
          else
          {
            PlaceHolderSpan localPlaceHolderSpan = new PlaceHolderSpan(paramString.substring(i + SYMBOL_STR_LEN, j));
            localPlaceHolderSpan.attach(paramIReplaceApply);
            localArrayList.add(localPlaceHolderSpan);
            if (j == paramString.length() - SYMBOL_END_LEN)
            {
              AppMethodBeat.o(200960);
              return localArrayList;
            }
            paramString = paramString.substring(SYMBOL_END_LEN + j);
            i = paramString.indexOf("${");
          }
        }
      }
    }
    
    public PlaceHolderHandler attachJoiner(android.arch.a.c.a<List, String> parama)
    {
      this.mJoiner = parama;
      return this;
    }
    
    public PlaceHolderHandler attachReplacer(WeChatBrands.IReplaceApply<String, String> paramIReplaceApply)
    {
      this.mReplacer = paramIReplaceApply;
      return this;
    }
    
    public String replace(String paramString)
    {
      AppMethodBeat.i(200958);
      if (paramString == null)
      {
        AppMethodBeat.o(200958);
        return null;
      }
      if (paramString.length() == 0)
      {
        AppMethodBeat.o(200958);
        return "";
      }
      paramString = computePlaceHolders(paramString, this.mReplacer);
      if ((paramString instanceof String))
      {
        paramString = (String)paramString;
        AppMethodBeat.o(200958);
        return paramString;
      }
      paramString = (String)this.mJoiner.apply((List)paramString);
      AppMethodBeat.o(200958);
      return paramString;
    }
    
    public static class PlaceHolderSpan
      extends WeChatBrands.PlaceHolderHandler.StringSpan
    {
      public static final int BrandReplacement = 0;
      public static final int DomainReplacement = 1;
      boolean mIsDomainReplace;
      WeChatBrands.IReplaceApply<String, String> mReplacer;
      
      public PlaceHolderSpan(String paramString)
      {
        super();
      }
      
      public PlaceHolderSpan attach(WeChatBrands.IReplaceApply<String, String> paramIReplaceApply)
      {
        this.mReplacer = paramIReplaceApply;
        return this;
      }
      
      public boolean isReplaceable()
      {
        return true;
      }
      
      public String toString()
      {
        boolean bool = true;
        AppMethodBeat.i(200955);
        if (this.mReplacer == null)
        {
          localObject = String.valueOf(this.mText);
          AppMethodBeat.o(200955);
          return localObject;
        }
        Object localObject = new PInt();
        String str = (String)this.mReplacer.apply(this.mText, (PInt)localObject);
        if (((PInt)localObject).value == 1) {}
        for (;;)
        {
          this.mIsDomainReplace = bool;
          AppMethodBeat.o(200955);
          return str;
          bool = false;
        }
      }
    }
    
    public static class StringSpan
    {
      protected final String mText;
      
      public StringSpan(String paramString)
      {
        this.mText = paramString;
      }
      
      public boolean isReplaceable()
      {
        return false;
      }
      
      public String toString()
      {
        AppMethodBeat.i(200956);
        String str = String.valueOf(this.mText);
        AppMethodBeat.o(200956);
        return str;
      }
    }
  }
  
  public static class UserInfo
  {
    public static final int kMMXAgreementId_MainlandOnWeixin = 1;
    public static final int kMMXAgreementId_Oversea = 2;
    public static final int kMMXAgreementId_UnSet = 0;
    public static final int kMMXAgreementId_WechatUS = 3;
    public static int xagreementId = 0;
  }
  
  public static class Wordings
  {
    private static final char SYMBOL_LINEFEED = '\n';
    private static final char SYMBOL_SEPARATOR = ' ';
    private static final WeChatBrands.PlaceHolderHandler handler;
    private static boolean sEnableAutoSeparate;
    
    static
    {
      AppMethodBeat.i(200968);
      handler = new WeChatBrands.PlaceHolderHandler();
      sEnableAutoSeparate = false;
      handler.attachJoiner(new android.arch.a.c.a()
      {
        public final String apply(List paramAnonymousList)
        {
          AppMethodBeat.i(200961);
          StringBuilder localStringBuilder = new StringBuilder();
          int i = 0;
          Object localObject1 = null;
          String str;
          if (i < paramAnonymousList.size())
          {
            Object localObject2 = paramAnonymousList.get(i);
            str = localObject2.toString();
            if (TextUtils.isEmpty(str)) {
              break label185;
            }
            if (((localObject2 instanceof WeChatBrands.PlaceHolderHandler.PlaceHolderSpan)) && (WeChatBrands.Wordings.sEnableAutoSeparate) && (!((WeChatBrands.PlaceHolderHandler.PlaceHolderSpan)localObject2).mIsDomainReplace))
            {
              if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (WeChatBrands.Wordings.access$200((String)localObject1, str))) {
                localStringBuilder.append(' ');
              }
              localStringBuilder.append(str);
              if ((i < paramAnonymousList.size() - 1) && (WeChatBrands.Wordings.access$200(str, paramAnonymousList.get(i + 1).toString()))) {
                localStringBuilder.append(' ');
              }
              localObject1 = null;
            }
          }
          label185:
          for (;;)
          {
            i += 1;
            break;
            localStringBuilder.append(str);
            localObject1 = str;
            continue;
            paramAnonymousList = localStringBuilder.toString();
            AppMethodBeat.o(200961);
            return paramAnonymousList;
          }
        }
      });
      AppMethodBeat.o(200968);
    }
    
    private static boolean isAlphabet(char paramChar)
    {
      return ((paramChar >= 'a') && (paramChar <= 'z')) || ((paramChar >= 'A') && (paramChar <= 'Z'));
    }
    
    private static boolean isChineseMarks(char paramChar)
    {
      return (paramChar == 65292) || (paramChar == '。') || (paramChar == 65281) || (paramChar == 65311) || (paramChar == 65306) || (paramChar == 65307) || (paramChar == '、') || (paramChar == '「') || (paramChar == '」');
    }
    
    private static boolean isEnMarks(char paramChar)
    {
      return (paramChar == '.') || (paramChar == ',') || (paramChar == '?') || (paramChar == '!') || (paramChar == ';') || (paramChar == ':');
    }
    
    private static boolean isLeftLinefeed(String paramString)
    {
      AppMethodBeat.i(200965);
      if ((paramString.charAt(paramString.length() - 1) == 'n') && (paramString.length() > 1) && (paramString.charAt(paramString.length() - 2) == '\\'))
      {
        AppMethodBeat.o(200965);
        return true;
      }
      AppMethodBeat.o(200965);
      return false;
    }
    
    private static boolean isLeftXmlFormat(String paramString)
    {
      AppMethodBeat.i(200966);
      if ((paramString.charAt(paramString.length() - 1) == 's') && (paramString.length() > 1) && (paramString.charAt(paramString.length() - 2) == '%'))
      {
        AppMethodBeat.o(200966);
        return true;
      }
      AppMethodBeat.o(200966);
      return false;
    }
    
    private static boolean notSeparateChar(char paramChar)
    {
      return (paramChar == '-') || (paramChar == '/') || (paramChar == '\\');
    }
    
    private static boolean shouldSeparate(String paramString1, String paramString2)
    {
      AppMethodBeat.i(200964);
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
      {
        AppMethodBeat.o(200964);
        return false;
      }
      char c1 = paramString1.charAt(paramString1.length() - 1);
      char c2 = paramString2.charAt(0);
      if ((c1 == ' ') || (c2 == ' ') || (c1 == '\n') || (c2 == '\n'))
      {
        AppMethodBeat.o(200964);
        return false;
      }
      if ((isChineseMarks(c1)) || (isChineseMarks(c2)))
      {
        AppMethodBeat.o(200964);
        return false;
      }
      if ((notSeparateChar(c1)) || (notSeparateChar(c2)))
      {
        AppMethodBeat.o(200964);
        return false;
      }
      if (isEnMarks(c2))
      {
        AppMethodBeat.o(200964);
        return false;
      }
      if (isEnMarks(c1))
      {
        AppMethodBeat.o(200964);
        return true;
      }
      if ((isAlphabet(c1)) || (Character.isDigit(c1)))
      {
        if (isLeftLinefeed(paramString1))
        {
          AppMethodBeat.o(200964);
          return false;
        }
        if ((isLeftXmlFormat(paramString1)) && (!isAlphabet(c2)))
        {
          AppMethodBeat.o(200964);
          return false;
        }
        AppMethodBeat.o(200964);
        return true;
      }
      if ((isAlphabet(c2)) || (Character.isDigit(c2)))
      {
        AppMethodBeat.o(200964);
        return true;
      }
      AppMethodBeat.o(200964);
      return false;
    }
    
    public static String translate(String paramString)
    {
      AppMethodBeat.i(200963);
      paramString = handler.replace(paramString);
      AppMethodBeat.o(200963);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.WeChatBrands
 * JD-Core Version:    0.7.0.1
 */