package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum WeChatBrands$Business$Entries
{
  public final String group;
  public final String identifier;
  public final int status;
  
  static
  {
    AppMethodBeat.i(249109);
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
    AppMethodBeat.o(249109);
  }
  
  private WeChatBrands$Business$Entries(int paramInt)
  {
    this.identifier = "";
    this.group = "";
    this.status = paramInt;
  }
  
  private WeChatBrands$Business$Entries(String paramString, int paramInt)
  {
    this.identifier = "";
    this.group = paramString;
    this.status = paramInt;
  }
  
  private WeChatBrands$Business$Entries(String paramString1, String paramString2, int paramInt)
  {
    this.identifier = paramString1;
    this.group = paramString2;
    this.status = paramInt;
  }
  
  public static boolean banned(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(249105);
    if (WeChatBrands.AppInfo.current().isMainland())
    {
      AppMethodBeat.o(249105);
      return false;
    }
    if (paramInt == 2) {
      bool = true;
    }
    Log.i("MicroMsg.WeChatBrands", "Business.Entry#isBanned = ".concat(String.valueOf(bool)));
    AppMethodBeat.o(249105);
    return bool;
  }
  
  public static boolean restricted(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(249103);
    if (WeChatBrands.AppInfo.current().isMainland())
    {
      AppMethodBeat.o(249103);
      return false;
    }
    if (paramInt != 0) {
      bool = true;
    }
    Log.i("MicroMsg.WeChatBrands", "Business.Entry#isRestricted = ".concat(String.valueOf(bool)));
    AppMethodBeat.o(249103);
    return bool;
  }
  
  public static void showAlert(Context paramContext, androidx.core.f.a<Integer> parama)
  {
    AppMethodBeat.i(249106);
    paramContext = new WeChatBrands.Business.Entries.1(paramContext, parama);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramContext.run();
      AppMethodBeat.o(249106);
      return;
    }
    h.ZvG.bc(paramContext);
    AppMethodBeat.o(249106);
  }
  
  public static boolean signRequsted(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(249104);
    if (WeChatBrands.AppInfo.current().isMainland())
    {
      AppMethodBeat.o(249104);
      return false;
    }
    if (paramInt == 1) {}
    for (;;)
    {
      Log.i("MicroMsg.WeChatBrands", "Business.Entry#signRequsted = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(249104);
      return bool;
      bool = false;
    }
  }
  
  public final boolean banned()
  {
    AppMethodBeat.i(249094);
    boolean bool = banned(this.status);
    AppMethodBeat.o(249094);
    return bool;
  }
  
  public final boolean checkAvailable(Context paramContext)
  {
    AppMethodBeat.i(249096);
    boolean bool = checkAvailable(paramContext, null);
    AppMethodBeat.o(249096);
    return bool;
  }
  
  public final boolean checkAvailable(Context paramContext, androidx.core.f.a<Integer> parama)
  {
    AppMethodBeat.i(249099);
    if (WeChatBrands.AppInfo.current().isMainland())
    {
      AppMethodBeat.o(249099);
      return true;
    }
    if (!((Boolean)WeChatBrands.Business.sRestrictHanlder.apply(this)).booleanValue())
    {
      AppMethodBeat.o(249099);
      return true;
    }
    if (((Boolean)WeChatBrands.Business.sAlertHandler.apply(this)).booleanValue()) {
      showAlert(paramContext, parama);
    }
    AppMethodBeat.o(249099);
    return false;
  }
  
  public final boolean checkAvailableSlient(Context paramContext, androidx.core.f.a<WeChatBrands.Business.AvailabilityAlertSupplier> parama)
  {
    AppMethodBeat.i(249101);
    if (WeChatBrands.AppInfo.current().isMainland())
    {
      AppMethodBeat.o(249101);
      return true;
    }
    if (!((Boolean)WeChatBrands.Business.sRestrictHanlder.apply(this)).booleanValue())
    {
      AppMethodBeat.o(249101);
      return true;
    }
    if (((paramContext instanceof Activity)) && (((Boolean)WeChatBrands.Business.sAlertHandler.apply(this)).booleanValue()) && (parama != null)) {
      parama.accept(WeChatBrands.Business.sAlertSupplier);
    }
    AppMethodBeat.o(249101);
    return false;
  }
  
  public final boolean restricted()
  {
    AppMethodBeat.i(249092);
    boolean bool = restricted(this.status);
    AppMethodBeat.o(249092);
    return bool;
  }
  
  public final boolean signRequsted()
  {
    AppMethodBeat.i(249093);
    boolean bool = signRequsted(this.status);
    AppMethodBeat.o(249093);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries
 * JD-Core Version:    0.7.0.1
 */