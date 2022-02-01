package com.tencent.mm.protocal;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  private static Map<String, c.g> Cpy;
  public static final String[] Cpz;
  
  static
  {
    AppMethodBeat.i(152436);
    Cpy = null;
    Cpz = (String[])new c.1().toArray(new String[0]);
    AppMethodBeat.o(152436);
  }
  
  public static Bundle aDg(String paramString)
  {
    AppMethodBeat.i(152434);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("handle", true);
    localBundle.putString("handle_result", paramString);
    AppMethodBeat.o(152434);
    return localBundle;
  }
  
  public static c.g aDh(String paramString)
  {
    AppMethodBeat.i(152435);
    if ((Cpy == null) || (Cpy.size() <= 0))
    {
      Object localObject = new HashMap(128);
      Cpy = (Map)localObject;
      ((Map)localObject).put("log", new et());
      Cpy.put("imagePreview", new eb());
      Cpy.put("profile", new hm());
      Cpy.put("shareWeibo", new me());
      Cpy.put("shareTimeline", new lc());
      Cpy.put("adDataReport", new o());
      Cpy.put("streamingVideoPlay", new kz());
      Cpy.put("addContact", new h());
      Cpy.put("getWidgetCaptureImgUrl", new do());
      Cpy.put("sendAppMessage", new iv());
      Cpy.put("scanQRCode", new in());
      Cpy.put("hideOptionMenu", new dy());
      Cpy.put("showOptionMenu", new kf());
      Cpy.put("getNetworkType", new cp());
      Cpy.put("closeWindow", new ao());
      Cpy.put("getInstallState", new ck());
      Cpy.put("setFontSizeCallback", new jj());
      Cpy.put("jumpToInstallUrl", new ei());
      Cpy.put("launchApp", new eo());
      Cpy.put("getBrandWCPayRequest", new bz());
      Cpy.put("secureTunnel", new ip());
      Cpy.put("wcpaySecurityCrosscutBack", new lu());
      Cpy.put("editAddress", new bj());
      Cpy.put("getHeadingAndPitch", new ch());
      Cpy.put("sendEmail", new ja());
      Cpy.put("addDownloadTask", new k());
      Cpy.put("cancelDownloadTask", new v());
      Cpy.put("pauseDownloadTask", new hc());
      Cpy.put("resumeDownloadTask", new il());
      Cpy.put("queryDownloadTask", new ho());
      Cpy.put("installDownloadTask", new ee());
      Cpy.put("getLatestAddress", new cu());
      Cpy.put("openSpecificView", new gm());
      Cpy.put("jumpWCMall", new ek());
      Cpy.put("launch3rdApp", new en());
      Cpy.put("writeCommData", new ml());
      Cpy.put("openUrlByExtBrowser", new gn());
      Cpy.put("geoLocation", new bw());
      Cpy.put("getBrandWCPayBindCardRequest", new by());
      Cpy.put("openProductView", new gf());
      Cpy.put("openProductViewWithPid", new gg());
      Cpy.put("jumpToBizProfile", new ej());
      Cpy.put("openTimelineCheckInList", new ez());
      Cpy.put("openLocation", new ey());
      Cpy.put("timelineCheckIn", new ex());
      Cpy.put("getBrandWCPayCreateCreditCardRequest", new gt());
      Cpy.put("chooseCard", new ab());
      Cpy.put("chooseInvoice", new af());
      Cpy.put("sendServiceAppMessage", new jb());
      Cpy.put("musicPlay", new ew());
      Cpy.put("mmsf0001", new cc());
      Cpy.put("connectToWiFi", new au());
      Cpy.put("getTransferMoneyRequest", new dk());
      Cpy.put("openWCPaySpecificView", new gp());
      Cpy.put("setCloseWindowConfirmDialogInfo", new jh());
      Cpy.put("batchAddCard", new q());
      Cpy.put("preVerifyJSAPI", new hj());
      Cpy.put("startRecord", new kp());
      Cpy.put("stopRecord", new kw());
      Cpy.put("playVoice", new he());
      Cpy.put("pauseVoice", new hd());
      Cpy.put("stopVoice", new ky());
      Cpy.put("uploadVoice", new lq());
      Cpy.put("downloadVoice", new bg());
      Cpy.put("chooseImage", new ae());
      Cpy.put("uploadImage", new ln());
      Cpy.put("downloadImage", new bf());
      Cpy.put("uploadMediaFile", new lo());
      Cpy.put("hideMenuItems", new dw());
      Cpy.put("showMenuItems", new kd());
      Cpy.put("hideAllNonBaseMenuItem", new dv());
      Cpy.put("showAllNonBaseMenuItem", new ka());
      Cpy.put("checkJsApi", new aa());
      Cpy.put("translateVoice", new ld());
      Cpy.put("shareQQ", new jx());
      Cpy.put("shareWeiboApp", new jz());
      Cpy.put("shareQZone", new jy());
      Cpy.put("connectToFreeWifi", new at());
      Cpy.put("getSendC2CMessageRequest", new dh());
      Cpy.put("batchViewCard", new t());
      Cpy.put("configWXDeviceWiFi", new ar());
      Cpy.put("getCurrentSSID", new ca());
      Cpy.put("setPageOwner", new jp());
      Cpy.put("getWechatVerifyTicket", new dm());
      Cpy.put("openWXDeviceLib", new gu());
      Cpy.put("startScanWXDevice", new kq());
      Cpy.put("stopScanWXDevice", new kx());
      Cpy.put("connectWXDevice", new av());
      Cpy.put("disconnectWXDevice", new be());
      Cpy.put("getWXDeviceTicket", new dq());
      Cpy.put("getWXDeviceInfos", new dp());
      Cpy.put("sendDataToWXDevice", new ix());
      Cpy.put("closeWXDeviceLib", new aq());
      Cpy.put("setSendDataDirection", new jt());
      Cpy.put("verifyWCPayPassword", new ls());
      Cpy.put("getPaymentOrderRequest", new ct());
      Cpy.put("openGameDetail", new fv());
      Cpy.put("openGameCenter", new fu());
      Cpy.put("setGameDebugConfig", new jl());
      Cpy.put("startTempSession", new ks());
      Cpy.put("getH5PrepayRequest", new ci());
      Cpy.put("getH5TransactionRequest", new cj());
      Cpy.put("menu:share:timeline", new mw());
      Cpy.put("menu:share:appmessage", new mt());
      Cpy.put("menu:share:qq", new mu());
      Cpy.put("menu:share:weiboApp", new mx());
      Cpy.put("menu:setfont", new ms());
      Cpy.put("menu:share:weibo", new mx());
      Cpy.put("menu:share:QZone", new mv());
      Cpy.put("getRecevieBizHongBaoRequest", new e());
      Cpy.put("insertVideoPlayer", new ed());
      Cpy.put("updateVideoPlayer", new lk());
      Cpy.put("removeVideoPlayer", new hw());
      Cpy.put("operateVideoPlayer", new gy());
      Cpy.put("deleteSearchHistory", new bb());
      Cpy.put("getSearchHistory", new dd());
      Cpy.put("getSearchData", new cz());
      Cpy.put("getPoiInfo", new cg());
      Cpy.put("updateReddotTimeStamps", new lg());
      Cpy.put("getTeachSearchData", new dj());
      Cpy.put("getSearchGuideData", new dc());
      Cpy.put("getSearchAvatarList", new cy());
      Cpy.put("getSearchSnsImageList", new df());
      Cpy.put("getSearchImageList", new de());
      Cpy.put("getSearchDisplayNameList", new da());
      Cpy.put("startSearchItemDetailPage", new kr());
      Cpy.put("reportSearchStatistics", new id());
      Cpy.put("reportSearchRealTimeStatistics", new ic());
      Cpy.put("searchDataHasResult", new io());
      Cpy.put("openEmotionPage", new bs());
      Cpy.put("getSearchSuggestionData", new dg());
      Cpy.put("setSearchInputWord", new js());
      Cpy.put("setSnsObjectXmlDescList", new ju());
      Cpy.put("clickSnsMusicPlayButton", new an());
      Cpy.put("openWeAppPage", new gs());
      Cpy.put("reportWeAppSearchRealtime", new mf());
      Cpy.put("doSearchOperation", new bi());
      Cpy.put("insertSearchWAWidgetView", new ec());
      Cpy.put("removeSearchWAWidgetView", new hv());
      Cpy.put("updateSearchWAWidgetView", new li());
      Cpy.put("showSearchActionSheet", new kg());
      Cpy.put("cancelSearchActionSheet", new x());
      Cpy.put("showSearchToast", new kj());
      Cpy.put("showSearchLoading", new kh());
      Cpy.put("hideSearchLoading", new dz());
      Cpy.put("updateWASearchTemplate", new ll());
      Cpy.put("preloadSearchWeapp", new hh());
      Cpy.put("uxSearchOpLog", new lr());
      Cpy.put("querySearchWeb", new bu());
      Cpy.put("openFinderProfile", new nc());
      Cpy.put("openFinderFeed", new nb());
      Cpy.put("jumpToWXWallet", new el());
      Cpy.put("scanCover", new f());
      Cpy.put("reportActionInfo", new hx());
      Cpy.put("openMyDeviceProfile", new gc());
      Cpy.put("selectPedometerSource", new is());
      Cpy.put("nfcIsConnect", new ff());
      Cpy.put("nfcConnect", new fc());
      Cpy.put("nfcTransceive", new fg());
      Cpy.put("nfcBatchTransceive", new fa());
      Cpy.put("nfcGetId", new fd());
      Cpy.put("nfcGetInfo", new fe());
      Cpy.put("startMonitoringBeacons", new kn());
      Cpy.put("stopMonitoringBeacons", new ku());
      Cpy.put("nfcCheckState", new fb());
      Cpy.put("videoProxyInit", new lx());
      Cpy.put("videoProxyStartPlay", new ma());
      Cpy.put("videoProxyStopPlay", new mb());
      Cpy.put("videoProxySetPlayerState", new ly());
      Cpy.put("videoProxySetRemainTime", new lz());
      Cpy.put("videoProxyPreload", new md());
      Cpy.put("getWebPayCheckoutCounterRequst", new es());
      Cpy.put("addCustomMenuItems", new i());
      Cpy.put("operateGameCenterMsg", new gx());
      Cpy.put("openEnterpriseChat", new fs());
      Cpy.put("enterEnterpriseChat", new bn());
      Cpy.put("openEnterpriseContact", new ft());
      Cpy.put("selectEnterpriseContact", new ir());
      Cpy.put("getEnterpriseChat", new ce());
      Cpy.put("reportIDKey", new ia());
      Cpy.put("quicklyAddBrandContact", new hr());
      Cpy.put("consumedShareCard", new aw());
      Cpy.put("cache", new lw());
      Cpy.put("publicCache", new mc());
      Cpy.put("kvReport", new em());
      Cpy.put("realtimeReport", new hs());
      Cpy.put("openUrlWithExtraWebview", new go());
      Cpy.put("setFreeWifiOwner", new jk());
      Cpy.put("selectSingleContact", new it());
      Cpy.put("sendAppMessageToSpecifiedContact", new iu());
      Cpy.put("setLocalData", new jm());
      Cpy.put("getLocalData", new cl());
      Cpy.put("clearLocalData", new al());
      Cpy.put("showKeyboard", new kc());
      Cpy.put("showSmileyPanel", new kk());
      Cpy.put("disableBounceScroll", new bc());
      Cpy.put("clearBounceBackground", new aj());
      Cpy.put("setNavigationBarButtons", new jn());
      Cpy.put("enableFullScreen", new bl());
      Cpy.put("showNavigationBarLoading", new ke());
      Cpy.put("hideNavigationBarLoading", new dx());
      Cpy.put("enablePullDownRefresh", new bm());
      Cpy.put("startPullDownRefresh", new ko());
      Cpy.put("stopPullDownRefresh", new kv());
      Cpy.put("disablePullDownRefresh", new bd());
      Cpy.put("setPageTitle", new jq());
      Cpy.put("setStatusBarStyle", new jv());
      Cpy.put("deleteAccountSuccess", new ba());
      Cpy.put("chooseVideo", new ai());
      Cpy.put("uploadVideo", new lp());
      Cpy.put("openMapNavigateMenu", new gb());
      Cpy.put("setNavigationBarColor", new jo());
      Cpy.put("getWCPayRealnameVerify", new dl());
      Cpy.put("openDesignerEmojiView", new fm());
      Cpy.put("openDesignerProfile", new fo());
      Cpy.put("openEmoticonTopicList", new fr());
      Cpy.put("openDesignerEmojiViewLocal", new fn());
      Cpy.put("openDesignerProfileLocal", new fp());
      Cpy.put("openEmotionDetailViewLocal", new d());
      Cpy.put("openNewPage", new gd());
      Cpy.put("getSearchEmotionData", new db());
      Cpy.put("openEmotionUrl", new bk());
      Cpy.put("WNNativeCallbackOnClick", new mj());
      Cpy.put("WNNativeCallbackOnLongClick", new mk());
      Cpy.put("WNNativeCallbackOnCaretChange", new mi());
      Cpy.put("WNNativeCallbackInitData", new mh());
      Cpy.put("WNNativeAsyncCallback", new mg());
      Cpy.put("WNNativeCallbackOnBecomeEditing", new mp());
      Cpy.put("WNNativeCallbackOnBecomeEdited", new mq());
      Cpy.put("changePayActivityView", new y());
      Cpy.put("selectWalletCurrency", new la());
      Cpy.put("scanLicence", new im());
      Cpy.put("operateMusicPlayer", new b());
      Cpy.put("getMusicPlayerState", new a());
      Cpy.put("clearWebviewCache", new am());
      Cpy.put("requireSoterBiometricAuthentication", new kl());
      Cpy.put("getSupportSoter", new km());
      Cpy.put("unbindBankCard", new le());
      Cpy.put("setBounceBackground", new jg());
      Cpy.put("sendEnterpriseChat", new iy());
      Cpy.put("doExposePreparation", new bh());
      Cpy.put("getMsgProofItems", new co());
      Cpy.put("openSecurityView", new gk());
      Cpy.put("startVoipCall", new kt());
      Cpy.put("chooseInvoiceTitle", new ag());
      Cpy.put("getOpenDeviceId", new cr());
      Cpy.put("getRouteUrl", new cx());
      Cpy.put("idCardRealnameVerify", new ea());
      Cpy.put("uploadIdCardSuccess", new mz());
      Cpy.put("showDatePickerView", new kb());
      Cpy.put("openLuckyMoneyDetailView", new fz());
      Cpy.put("resendRemittanceMsg", new ik());
      Cpy.put("getGameCommInfo", new cf());
      Cpy.put("openGameRegion", new fw());
      Cpy.put("chooseIdCard", new ad());
      Cpy.put("getLocalImgData", new c());
      Cpy.put("openWeApp", new gr());
      Cpy.put("recordVideo", new ht());
      Cpy.put("previewVideo", new hi());
      Cpy.put("uploadEncryptMediaFile", new lm());
      Cpy.put("chooseMedia", new ah());
      Cpy.put("requestWxFacePictureVerify", new bo());
      Cpy.put("openCustomWebview", new fl());
      Cpy.put("forceUpdateWxaAttr", new br());
      Cpy.put("openLuckyMoneyHistory", new ga());
      Cpy.put("menuitem:gameSendDesktop", new iz());
      Cpy.put("getWePkgAuthResult", new dn());
      Cpy.put("getLocalWePkgInfo", new cm());
      Cpy.put("openGameWebView", new fy());
      Cpy.put("reportGameWeb", new hz());
      Cpy.put("launchApplication", new ep());
      Cpy.put("showSearchOfBizHistory", new ki());
      Cpy.put("login", new eu());
      Cpy.put("authorize", new p());
      Cpy.put("requestWxFacePictureVerifyUnionVideo", new bp());
      Cpy.put("checkIsSupportFaceDetect", new z());
      Cpy.put("operateBackgroundAudio", new gw());
      Cpy.put("setBackgroundAudioState", new jf());
      Cpy.put("getBackgroundAudioState", new bx());
      Cpy.put("addDownloadTaskStraight", new l());
      Cpy.put("setScreenOrientation", new jr());
      Cpy.put("addToEmoticon", new n());
      Cpy.put("shareEmoticon", new jw());
      Cpy.put("makePhoneCall", new ev());
      Cpy.put("openADCanvas", new fk());
      Cpy.put("openSearchCanvas", new gh());
      Cpy.put("opVoteAdData", new hb());
      Cpy.put("opJumpView", new ha());
      Cpy.put("opAdH5Func", new gz());
      Cpy.put("requestWxFaceRegisterInternal", new ih());
      Cpy.put("requestWxFaceVerifyInternal", new ii());
      Cpy.put("launchMiniProgram", new er());
      Cpy.put("reportMiniProgramPageData", new ib());
      Cpy.put("selectContact", new iq());
      Cpy.put("openSearchWAWidgetLogView", new gi());
      Cpy.put("reloadSearchWAWidgetData", new hu());
      Cpy.put("gotoEmoticonPad", new dr());
      Cpy.put("querySimilarEmotion", new hq());
      Cpy.put("closeWindowAndGoNext", new ap());
      Cpy.put("requestWxVoicePrintVerifyInternal", new ij());
      Cpy.put("openBizChat", new fj());
      Cpy.put("handleWCPayWalletBuffer", new du());
      Cpy.put("tapSearchWAWidgetView", new lb());
      Cpy.put("getMatchContactList", new cn());
      Cpy.put("openSearchWebView", new gj());
      Cpy.put("openWXSearchPage", new gv());
      Cpy.put("viewTypeChange", new lt());
      Cpy.put("invokeMiniProgramAPI", new eg());
      Cpy.put("openGameUrlWithExtraWebView", new fx());
      Cpy.put("setGameData", new ji());
      Cpy.put("getGameData", new cb());
      Cpy.put("clearGameData", new ak());
      Cpy.put("openECard", new fq());
      Cpy.put("reportGamePageTime", new hy());
      Cpy.put("setWCPayPassword", new je());
      Cpy.put("openWCPayCardList", new fi());
      Cpy.put("bindEmail", new u());
      Cpy.put("openOfflinePayView", new ge());
      Cpy.put("bindEmail", new u());
      Cpy.put("doGoToRecVideoList", new cv());
      Cpy.put("jumpWSRecVideoList", new mr());
      Cpy.put("openWebSearchOutLinkItem", new my());
      Cpy.put("recordHistory", new bv());
      localObject = new LinkedList();
      ((List)localObject).add(new c.az());
      ((List)localObject).add(new c.ay());
      ((List)localObject).add(new hg());
      ((List)localObject).add(new c.hf());
      ((List)localObject).add(new c.iw());
      ((List)localObject).add(new c.ds());
      ((List)localObject).add(new dt());
      ((List)localObject).add(new c.j());
      ((List)localObject).add(new c.hl());
      ((List)localObject).add(new c.hk());
      ((List)localObject).add(new bt());
      ((List)localObject).add(new c.gq());
      ((List)localObject).add(new as());
      ((List)localObject).add(new c.cs());
      ((List)localObject).add(new c.cw());
      ((List)localObject).add(new c.r());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        c.g localg = (c.g)((Iterator)localObject).next();
        Cpy.put(localg.getName(), localg);
      }
      Cpy.put("getSystemInfo", new di());
      Cpy.put("serviceClick", new jd());
      Cpy.put("openRealnameAuth", new mo());
      Cpy.put("sendSingleAppMessage", new jc());
      Cpy.put("wcPrivacyPolicyResult", new lv());
      Cpy.put("currentMpInfo", new ax());
      Cpy.put("updateAppMessageShareData", new lh());
      Cpy.put("updateTimelineShareData", new lj());
      Cpy.put("getCCData", new mn());
      Cpy.put("calRqt", new mm());
      Cpy.put("faceVerifyForPay", new bq());
      Cpy.put("request", new ie());
      Cpy.put("notifyPageInfo", new fh());
      Cpy.put("updatePageAuth", new lf());
      Cpy.put("jumpDownloaderWidget", new eh());
      Cpy.put("batchUpdateWepkg", new s());
      Cpy.put("addGameDownloadTask", new m());
      Cpy.put("internelWxFaceVerify", new ef());
      Cpy.put("getDownloadWidgetTaskInfos", new cd());
      Cpy.put("chooseHaowanMedia", new ac());
      Cpy.put("queryHaowanPublish", new hp());
      Cpy.put("publishHaowanEdition", new hn());
      Cpy.put("cancelHaowanPublish", new w());
      Cpy.put("launchGameVideoEditor", new eq());
      Cpy.put("requestJointPayment", new ig());
      Cpy.put("openSelectPayment", new gl());
      Cpy.put("requestEntrustAuthorization", new if());
      Cpy.put("getOAID", new cq());
    }
    paramString = (c.g)Cpy.get(paramString);
    AppMethodBeat.o(152435);
    return paramString;
  }
  
  public static final class a
    extends c.g
  {
    public a()
    {
      super("getMusicPlayerState", 210, false);
    }
  }
  
  public static final class aa
    extends c.g
  {
    public aa()
    {
      super("checkJsApi", 84, false);
    }
  }
  
  public static final class ab
    extends c.g
  {
    public ab()
    {
      super("choose_card", 70, true);
    }
  }
  
  static final class ac
    extends c.g
  {
    ac()
    {
      super("chooseHaowanMedia", 354, true);
    }
  }
  
  public static final class ad
    extends c.g
  {
    public ad()
    {
      super("chooseIdCard", 247, true);
    }
  }
  
  public static final class ae
    extends c.g
  {
    public ae()
    {
      super("chooseImage", 104, true);
    }
  }
  
  public static final class af
    extends c.g
  {
    public af()
    {
      super("chooseInvoice", 202, true);
    }
  }
  
  public static final class ag
    extends c.g
  {
    public ag()
    {
      super("chooseInvoiceTitle", 288, true);
    }
  }
  
  static final class ah
    extends c.g
  {
    ah()
    {
      super("chooseMedia", 254, true);
    }
  }
  
  public static final class ai
    extends c.g
  {
    public ai()
    {
      super("chooseVideo", 191, true);
    }
  }
  
  public static final class aj
    extends c.g
  {
    public aj()
    {
      super("clearBounceBackground", 189, false);
    }
  }
  
  static final class ak
    extends c.g
  {
    ak()
    {
      super("clearGameData", 300, false);
    }
  }
  
  public static final class al
    extends c.g
  {
    public al()
    {
      super("clearLocalData", 181, false);
    }
  }
  
  public static final class am
    extends c.g
  {
    public am()
    {
      super("clearWebviewCache", 208, false);
    }
  }
  
  public static final class an
    extends c.g
  {
    public an()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ao
    extends c.g
  {
    public ao()
    {
      super("close_window", 17, false);
    }
  }
  
  static final class ap
    extends c.g
  {
    ap()
    {
      super("closeWindowAndGoNext", 293, false);
    }
  }
  
  public static final class aq
    extends c.g
  {
    public aq()
    {
      super("closeWXDeviceLib", 118, false);
    }
  }
  
  public static final class ar
    extends c.g
  {
    public ar()
    {
      super("configWXDeviceWiFi", 126, true);
    }
  }
  
  static final class as
    extends c.g
  {
    as()
    {
      super("confirmDialog", 343, true);
    }
  }
  
  public static final class at
    extends c.g
  {
    public at()
    {
      super("connectToFreeWifi", 95, false);
    }
  }
  
  public static final class au
    extends c.g
  {
    public au()
    {
      super("connecttowifi", 71, false);
    }
  }
  
  public static final class av
    extends c.g
  {
    public av()
    {
      super("connectWXDevice", 123, true);
    }
  }
  
  public static final class aw
    extends c.g
  {
    public aw()
    {
      super("consumedShareCard", 177, true);
    }
  }
  
  static final class ax
    extends c.g
  {
    public ax()
    {
      super("currentMpInfo", 324, false);
    }
  }
  
  public static final class b
    extends c.g
  {
    public b()
    {
      super("operateMusicPlayer", 211, false);
    }
  }
  
  public static final class ba
    extends c.g
  {
    public ba()
    {
      super("deleteAccountSuccess", 144, false);
    }
  }
  
  public static final class bb
    extends c.g
  {
    public bb()
    {
      super("", 10000, false);
    }
  }
  
  public static final class bc
    extends c.g
  {
    public bc()
    {
      super("disableBounceScroll", 188, false);
    }
  }
  
  public static final class bd
    extends c.g
  {
    public bd()
    {
      super("disablePullDownRefresh", 205, false);
    }
  }
  
  public static final class be
    extends c.g
  {
    public be()
    {
      super("disconnectWXDevice", 124, true);
    }
  }
  
  public static final class bf
    extends c.g
  {
    public bf()
    {
      super("downloadImage", 106, true);
    }
  }
  
  public static final class bg
    extends c.g
  {
    public bg()
    {
      super("downloadVoice", 103, true);
    }
  }
  
  public static final class bh
    extends c.g
  {
    public bh()
    {
      super("doExposePreparation", 225, false);
    }
  }
  
  public static final class bi
    extends c.g
  {
    public bi()
    {
      super("", 10000, false);
    }
  }
  
  public static final class bj
    extends c.g
  {
    public bj()
    {
      super("edit_address", 29, true);
    }
  }
  
  public static final class bk
    extends c.g
  {
    public bk()
    {
      super("openEmotionUrl", 20000, false);
    }
  }
  
  public static final class bl
    extends c.g
  {
    public bl()
    {
      super("enableFullScreen", 196, false);
    }
  }
  
  public static final class bm
    extends c.g
  {
    public bm()
    {
      super("enablePullDownRefresh", 199, false);
    }
  }
  
  public static final class bn
    extends c.g
  {
    public bn()
    {
      super("enterEnterpriseChat", 223, false);
    }
  }
  
  static final class bo
    extends c.g
  {
    bo()
    {
      super("requestWxFacePictureVerify", 259, true);
    }
  }
  
  static final class bp
    extends c.g
  {
    bp()
    {
      super("requestWxFacePictureVerifyUnionVideo", 264, true);
    }
  }
  
  static final class bq
    extends c.g
  {
    bq()
    {
      super("faceVerifyForPay", 328, true);
    }
  }
  
  static final class br
    extends c.g
  {
    br()
    {
      super("forceUpdateWxaAttr", 257, false);
    }
  }
  
  public static final class bs
    extends c.g
  {
    public bs()
    {
      super("", 10000, false);
    }
  }
  
  static final class bt
    extends c.g
  {
    bt()
    {
      super("openBusinessView", 338, true);
    }
  }
  
  public static final class bu
    extends c.g
  {
    public bu()
    {
      super("", 10000, false);
    }
  }
  
  static final class bv
    extends c.g
  {
    bv()
    {
      super("recordHistory", 219, false);
    }
  }
  
  public static final class bw
    extends c.g
  {
    public bw()
    {
      super("geo_location", 57, false);
    }
  }
  
  static final class bx
    extends c.g
  {
    bx()
    {
      super("getBackgroundAudioState", 263, false);
    }
  }
  
  public static final class by
    extends c.g
  {
    public by()
    {
      super("get_brand_WCPay_bind_card_request", 58, true);
    }
  }
  
  public static final class bz
    extends c.g
  {
    public bz()
    {
      super("get_brand_wcpay_request", 28, true);
    }
  }
  
  public static final class c
    extends c.g
  {
    public c()
    {
      super("getLocalImgData", 249, false);
    }
  }
  
  public static final class ca
    extends c.g
  {
    public ca()
    {
      super("getCurrentSSID", 176, true);
    }
  }
  
  static final class cb
    extends c.g
  {
    cb()
    {
      super("getGameData", 299, false);
    }
  }
  
  public static final class cc
    extends c.g
  {
    public cc()
    {
      super("mmsf0001", -2, false);
    }
  }
  
  static final class cd
    extends c.g
  {
    cd()
    {
      super("getDownloadWidgetTaskInfos", 340, false);
    }
  }
  
  public static final class ce
    extends c.g
  {
    public ce()
    {
      super("getEnterpriseChat", 244, false);
    }
  }
  
  public static final class cf
    extends c.g
  {
    public cf()
    {
      super("getGameCommInfo", 241, false);
    }
  }
  
  public static final class cg
    extends c.g
  {
    public cg()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ch
    extends c.g
  {
    public ch()
    {
      super("get_heading_and_pitch", 33, false);
    }
  }
  
  public static final class ci
    extends c.g
  {
    public ci()
    {
      super("getH5PrepayRequest", 137, true);
    }
  }
  
  public static final class cj
    extends c.g
  {
    public cj()
    {
      super("getH5TransactionRequest", 138, true);
    }
  }
  
  public static final class ck
    extends c.g
  {
    public ck()
    {
      super("get_install_state", 25, false);
    }
  }
  
  public static final class cl
    extends c.g
  {
    public cl()
    {
      super("getLocalData", 179, false);
    }
  }
  
  static final class cm
    extends c.g
  {
    cm()
    {
      super("getLocalWePkgInfo", -2, false);
    }
  }
  
  static final class cn
    extends c.g
  {
    cn()
    {
      super("getMatchContactList", 10000, false);
    }
  }
  
  public static final class co
    extends c.g
  {
    public co()
    {
      super("getMsgProofItems", 226, true);
    }
  }
  
  public static final class cp
    extends c.g
  {
    public cp()
    {
      super("network_type", 16, false);
    }
  }
  
  static final class cq
    extends c.g
  {
    cq()
    {
      super("getOAID", 361, false);
    }
  }
  
  public static final class cr
    extends c.g
  {
    public cr()
    {
      super("getOpenDeviceId", 227, false);
    }
  }
  
  public static final class ct
    extends c.g
  {
    public ct()
    {
      super("getPaymentOrderRequest", 116, true);
    }
  }
  
  public static final class cu
    extends c.g
  {
    public cu()
    {
      super("get_recently_used_address", 46, true);
    }
  }
  
  static final class cv
    extends c.g
  {
    cv()
    {
      super("doGoToRecVideoList", 10000, false);
    }
  }
  
  public static final class cx
    extends c.g
  {
    public cx()
    {
      super("getRouteUrl", 235, false);
    }
  }
  
  public static final class cy
    extends c.g
  {
    public cy()
    {
      super("", 10000, false);
    }
  }
  
  public static final class cz
    extends c.g
  {
    public cz()
    {
      super("", 10000, false);
    }
  }
  
  public static final class d
    extends c.g
  {
    public d()
    {
      super("openEmotionDetailViewLocal", 20000, false);
    }
  }
  
  public static final class da
    extends c.g
  {
    public da()
    {
      super("getSearchDisplayNameList", 10000, false);
    }
  }
  
  public static final class db
    extends c.g
  {
    public db()
    {
      super("getSearchEmotionData", 20000, false);
    }
  }
  
  public static final class dc
    extends c.g
  {
    public dc()
    {
      super("", 10000, false);
    }
  }
  
  public static final class dd
    extends c.g
  {
    public dd()
    {
      super("", 10000, false);
    }
  }
  
  public static final class de
    extends c.g
  {
    public de()
    {
      super("", 10000, false);
    }
  }
  
  public static final class df
    extends c.g
  {
    public df()
    {
      super("", 10000, false);
    }
  }
  
  public static final class dg
    extends c.g
  {
    public dg()
    {
      super("", 10000, false);
    }
  }
  
  public static final class dh
    extends c.g
  {
    public dh()
    {
      super("get_send_c2c_message_request", 83, true);
    }
  }
  
  static final class di
    extends c.g
  {
    di()
    {
      super("getSystemInfo", 311, false);
    }
  }
  
  public static final class dj
    extends c.g
  {
    public dj()
    {
      super("", 10000, false);
    }
  }
  
  public static final class dk
    extends c.g
  {
    public dk()
    {
      super("get_transfer_money_request", 74, true);
    }
  }
  
  public static final class dl
    extends c.g
  {
    public dl()
    {
      super("getWCPayRealnameVerify", 194, true);
    }
  }
  
  public static final class dm
    extends c.g
  {
    public dm()
    {
      super("getWechatVerifyTicket", 112, false);
    }
  }
  
  static final class dn
    extends c.g
  {
    dn()
    {
      super("getWePkgAuthResult", -3, false);
    }
  }
  
  public static final class do
    extends c.g
  {
    public do()
    {
      super("add_contact", 10000, false);
    }
  }
  
  public static final class dp
    extends c.g
  {
    public dp()
    {
      super("getWXDeviceInfos", 119, true);
    }
  }
  
  public static final class dq
    extends c.g
  {
    public dq()
    {
      super("getWXDeviceTicket", 125, true);
    }
  }
  
  public static final class dr
    extends c.g
  {
    public dr()
    {
      super("", 10000, false);
    }
  }
  
  static final class dt
    extends c.g
  {
    dt()
    {
      super("handleMPPageAction", 345, false);
    }
  }
  
  static final class du
    extends c.g
  {
    du()
    {
      super("handleWCPayWalletBuffer", 294, false);
    }
  }
  
  public static final class dv
    extends c.g
  {
    public dv()
    {
      super("hideAllNonBaseMenuItem", 93, false);
    }
  }
  
  public static final class dw
    extends c.g
  {
    public dw()
    {
      super("hideMenuItems", 85, false);
    }
  }
  
  public static final class dx
    extends c.g
  {
    public dx()
    {
      super("hideNavigationBarLoading", 198, false);
    }
  }
  
  public static final class dy
    extends c.g
  {
    public dy()
    {
      super("", 14, false);
    }
  }
  
  public static final class dz
    extends c.g
  {
    public dz()
    {
      super("hideSearchLoading", 10000, false);
    }
  }
  
  public static final class e
    extends c.g
  {
    public e()
    {
      super("getRecevieBizHongBaoRequest", 135, true);
    }
  }
  
  public static final class ea
    extends c.g
  {
    public ea()
    {
      super("idCardRealnameVerify", 235, true);
    }
  }
  
  public static final class eb
    extends c.g
  {
    public eb()
    {
      super("", 1, true);
    }
  }
  
  public static final class ec
    extends c.g
  {
    public ec()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ed
    extends c.g
  {
    public ed()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ee
    extends c.g
  {
    public ee()
    {
      super("install_download_task", 41, false);
    }
  }
  
  public static final class ef
    extends c.g
  {
    ef()
    {
      super("internelWxFaceVerify", 325, true);
    }
  }
  
  static final class eg
    extends c.g
  {
    eg()
    {
      super("invokeMiniProgramAPI", 295, false);
    }
  }
  
  static final class eh
    extends c.g
  {
    eh()
    {
      super("jumpDownloaderWidget", 339, true);
    }
  }
  
  public static final class ei
    extends c.g
  {
    public ei()
    {
      super("", 26, false);
    }
  }
  
  public static final class ej
    extends c.g
  {
    public ej()
    {
      super("jump_to_biz_profile", 61, true);
    }
  }
  
  public static final class ek
    extends c.g
  {
    public ek()
    {
      super("jump_wcmall", 51, true);
    }
  }
  
  public static final class el
    extends c.g
  {
    public el()
    {
      super("jumpToWXWallet", 147, true);
    }
  }
  
  public static final class em
    extends c.g
  {
    public em()
    {
      super("kvReport", 170, false);
    }
  }
  
  public static final class en
    extends c.g
  {
    public en()
    {
      super("launch_3rdApp", 52, true);
    }
  }
  
  public static final class eo
    extends c.g
  {
    public eo()
    {
      super("", 27, false);
    }
  }
  
  static final class ep
    extends c.g
  {
    ep()
    {
      super("launchApplication", 260, true);
    }
  }
  
  static final class eq
    extends c.g
  {
    eq()
    {
      super("launchGameVideoEditor", 350, true);
    }
  }
  
  static final class er
    extends c.g
  {
    er()
    {
      super("launchMiniProgram", 277, true);
    }
  }
  
  public static final class es
    extends c.g
  {
    public es()
    {
      super("getWebPayCheckoutCounterRequst", 161, true);
    }
  }
  
  public static final class et
    extends c.g
  {
    public et()
    {
      super("", 0, false);
    }
  }
  
  static final class eu
    extends c.g
  {
    eu()
    {
      super("login", 231, true);
    }
  }
  
  static final class ev
    extends c.g
  {
    ev()
    {
      super("makePhoneCall", 356, true);
    }
  }
  
  public static final class ew
    extends c.g
  {
    public ew()
    {
      super("playMusic", 69, false);
    }
  }
  
  public static final class ex
    extends c.g
  {
    public ex()
    {
      super("timeline_check_in", 64, false);
    }
  }
  
  public static final class ey
    extends c.g
  {
    public ey()
    {
      super("open_location", 63, true);
    }
  }
  
  public static final class ez
    extends c.g
  {
    public ez()
    {
      super("open_timeline_checkin_list", 62, false);
    }
  }
  
  public static final class f
    extends c.g
  {
    public f()
    {
      super("scanCover", 136, true);
    }
  }
  
  public static final class fa
    extends c.g
  {
    public fa()
    {
      super("nfcBatchTransceive", 142, false);
    }
  }
  
  public static final class fb
    extends c.g
  {
    public fb()
    {
      super("nfcCheckState", 155, true);
    }
  }
  
  public static final class fc
    extends c.g
  {
    public fc()
    {
      super("nfcConnect", 140, false);
    }
  }
  
  public static final class fd
    extends c.g
  {
    public fd()
    {
      super("nfcGetId", 143, false);
    }
  }
  
  public static final class fe
    extends c.g
  {
    public fe()
    {
      super("nfcGetInfo", 148, false);
    }
  }
  
  public static final class ff
    extends c.g
  {
    public ff()
    {
      super("nfcIsConnect", 139, true);
    }
  }
  
  public static final class fg
    extends c.g
  {
    public fg()
    {
      super("nfcTransceive", 141, false);
    }
  }
  
  static final class fh
    extends c.g
  {
    fh()
    {
      super("notifyPageInfo", -2, false);
    }
  }
  
  static final class fi
    extends c.g
  {
    fi()
    {
      super("openWCPayCardList", 310, true);
    }
  }
  
  static final class fj
    extends c.g
  {
    fj()
    {
      super("openBizChat", 296, true);
    }
  }
  
  static final class fk
    extends c.g
  {
    fk()
    {
      super("openADCanvas", 283, true);
    }
  }
  
  static final class fl
    extends c.g
  {
    fl()
    {
      super("openCustomWebview", 256, false);
    }
  }
  
  public static final class fm
    extends c.g
  {
    public fm()
    {
      super("openDesignerEmojiView", 185, true);
    }
  }
  
  public static final class fn
    extends c.g
  {
    public fn()
    {
      super("openDesignerEmojiViewLocal", 20000, false);
    }
  }
  
  public static final class fo
    extends c.g
  {
    public fo()
    {
      super("openDesignerProfile", 193, true);
    }
  }
  
  public static final class fp
    extends c.g
  {
    public fp()
    {
      super("openDesignerProfileLocal", 20000, false);
    }
  }
  
  static final class fq
    extends c.g
  {
    fq()
    {
      super("openECard", 268, true);
    }
  }
  
  public static final class fr
    extends c.g
  {
    public fr()
    {
      super("openEmoticonTopicList", 212, true);
    }
  }
  
  public static final class fs
    extends c.g
  {
    public fs()
    {
      super("openEnterpriseChat", 165, false);
    }
  }
  
  public static final class ft
    extends c.g
  {
    public ft()
    {
      super("openEnterpriseContact", 183, true);
    }
  }
  
  public static final class fu
    extends c.g
  {
    public fu()
    {
      super("openGameCenter", 175, true);
    }
  }
  
  public static final class fv
    extends c.g
  {
    public fv()
    {
      super("openGameDetail", 131, true);
    }
  }
  
  public static final class fw
    extends c.g
  {
    public fw()
    {
      super("openGameRegion", 242, true);
    }
  }
  
  static final class fx
    extends c.g
  {
    fx()
    {
      super("openGameUrlWithExtraWebView", 297, false);
    }
  }
  
  static final class fy
    extends c.g
  {
    fy()
    {
      super("openGameWebView", 287, false);
    }
  }
  
  public static final class fz
    extends c.g
  {
    public fz()
    {
      super("openLuckyMoneyDetailView", 245, false);
    }
  }
  
  static final class ga
    extends c.g
  {
    ga()
    {
      super("openLuckyMoneyHistory", 258, true);
    }
  }
  
  public static final class gb
    extends c.g
  {
    public gb()
    {
      super("openMapNavigateMenu", 184, true);
    }
  }
  
  public static final class gc
    extends c.g
  {
    public gc()
    {
      super("openMyDeviceProfile", 145, false);
    }
  }
  
  public static final class gd
    extends c.g
  {
    public gd()
    {
      super("openNewPage", 20000, false);
    }
  }
  
  static final class ge
    extends c.g
  {
    ge()
    {
      super("openOfflinePayView", 305, true);
    }
  }
  
  public static final class gf
    extends c.g
  {
    public gf()
    {
      super("open_product_view", 59, true);
    }
  }
  
  public static final class gg
    extends c.g
  {
    public gg()
    {
      super("open_product_view", 60, true);
    }
  }
  
  static final class gh
    extends c.g
  {
    gh()
    {
      super("openSearchCanvas", 283, true);
    }
  }
  
  static final class gi
    extends c.g
  {
    gi()
    {
      super("openSearchWAWidgetLogView", 10000, true);
    }
  }
  
  static final class gj
    extends c.g
  {
    gj()
    {
      super("openSearchWebView", 10000, true);
    }
  }
  
  public static final class gk
    extends c.g
  {
    public gk()
    {
      super("openSecurityView", 229, false);
    }
  }
  
  static final class gl
    extends c.g
  {
    gl()
    {
      super("openSelectPayment", 359, true);
    }
  }
  
  public static final class gm
    extends c.g
  {
    public gm()
    {
      super("specific_view", 48, true);
    }
  }
  
  public static final class gn
    extends c.g
  {
    public gn()
    {
      super("open_url_by_ext_browser", 55, false);
    }
  }
  
  public static final class go
    extends c.g
  {
    public go()
    {
      super("openUrlWithExtraWebview", 173, false);
    }
  }
  
  public static final class gp
    extends c.g
  {
    public gp()
    {
      super("open_wcpay_specific_view", 76, true);
    }
  }
  
  static final class gr
    extends c.g
  {
    gr()
    {
      super("openWeApp", 250, false);
    }
  }
  
  public static final class gs
    extends c.g
  {
    public gs()
    {
      super("", 10000, false);
    }
  }
  
  public static final class gt
    extends c.g
  {
    public gt()
    {
      super("get_wcpay_create_credit_card_request", 65, true);
    }
  }
  
  public static final class gu
    extends c.g
  {
    public gu()
    {
      super("openWXDeviceLib", 117, false);
    }
  }
  
  static final class gv
    extends c.g
  {
    gv()
    {
      super("openWXSearchPage", 309, true);
    }
  }
  
  static final class gw
    extends c.g
  {
    gw()
    {
      super("operateBackgroundAudio", 261, false);
    }
  }
  
  public static final class gx
    extends c.g
  {
    public gx()
    {
      super("operateGameCenterMsg", 174, false);
    }
  }
  
  public static final class gy
    extends c.g
  {
    public gy()
    {
      super("", 10000, false);
    }
  }
  
  static final class gz
    extends c.g
  {
    gz()
    {
      super("", -2, false);
    }
  }
  
  public static final class h
    extends c.g
  {
    public h()
    {
      super("add_contact", 5, true);
    }
  }
  
  static final class ha
    extends c.g
  {
    ha()
    {
      super("", -2, false);
    }
  }
  
  static final class hb
    extends c.g
  {
    hb()
    {
      super("", -2, false);
    }
  }
  
  public static final class hc
    extends c.g
  {
    public hc()
    {
      super("cancel_download_task", 239, false);
    }
  }
  
  public static final class hd
    extends c.g
  {
    public hd()
    {
      super("pauseVoice", 100, false);
    }
  }
  
  public static final class he
    extends c.g
  {
    public he()
    {
      super("playVoice", 99, false);
    }
  }
  
  static final class hg
    extends c.g
  {
    hg()
    {
      super("preloadMiniProgramEnv", 302, false);
    }
  }
  
  public static final class hh
    extends c.g
  {
    public hh()
    {
      super("preloadSearchWeapp", 10000, false);
    }
  }
  
  static final class hi
    extends c.g
  {
    hi()
    {
      super("previewVideo", 252, true);
    }
  }
  
  public static final class hj
    extends c.g
  {
    public hj()
    {
      super("pre_verify_jsapi", -3, false);
    }
  }
  
  public static final class hm
    extends c.g
  {
    public hm()
    {
      super("profile", 2, false);
    }
  }
  
  static final class hn
    extends c.g
  {
    hn()
    {
      super("publishHaowanEdition", 351, false);
    }
  }
  
  public static final class ho
    extends c.g
  {
    public ho()
    {
      super("query_download_task", 40, false);
    }
  }
  
  static final class hp
    extends c.g
  {
    hp()
    {
      super("queryHaowanPublish", 352, false);
    }
  }
  
  public static final class hq
    extends c.g
  {
    public hq()
    {
      super("", 10000, false);
    }
  }
  
  public static final class hr
    extends c.g
  {
    public hr()
    {
      super("quicklyAddBrandContact", 166, true);
    }
  }
  
  public static final class hs
    extends c.g
  {
    public hs()
    {
      super("realtimeReport", 171, false);
    }
  }
  
  static final class ht
    extends c.g
  {
    ht()
    {
      super("recordVideo", 251, true);
    }
  }
  
  public static final class hu
    extends c.g
  {
    public hu()
    {
      super("", 10000, false);
    }
  }
  
  public static final class hv
    extends c.g
  {
    public hv()
    {
      super("", 10000, false);
    }
  }
  
  public static final class hw
    extends c.g
  {
    public hw()
    {
      super("", 10000, false);
    }
  }
  
  public static final class hx
    extends c.g
  {
    public hx()
    {
      super("reportActionInfo", 234, false);
    }
  }
  
  static final class hy
    extends c.g
  {
    hy()
    {
      super("reportGamePageTime", 301, false);
    }
  }
  
  static final class hz
    extends c.g
  {
    hz()
    {
      super("reportGameWeb", 332, false);
    }
  }
  
  public static final class i
    extends c.g
  {
    public i()
    {
      super("addCustomMenuItems", 164, false);
    }
  }
  
  public static final class ia
    extends c.g
  {
    public ia()
    {
      super("reportIDKey", 163, false);
    }
  }
  
  static final class ib
    extends c.g
  {
    ib()
    {
      super("reportMiniProgramPageData", 284, false);
    }
  }
  
  public static final class ic
    extends c.g
  {
    public ic()
    {
      super("", 10000, false);
    }
  }
  
  public static final class id
    extends c.g
  {
    public id()
    {
      super("", 10000, false);
    }
  }
  
  static final class ie
    extends c.g
  {
    ie()
    {
      super("request", 331, false);
    }
  }
  
  static final class if
    extends c.g
  {
    if()
    {
      super("requestEntrustAuthorization", 360, true);
    }
  }
  
  static final class ig
    extends c.g
  {
    ig()
    {
      super("requestJointPayment", 358, true);
    }
  }
  
  static final class ih
    extends c.g
  {
    ih()
    {
      super("requestWxFaceRegisterInternal", 272, true);
    }
  }
  
  static final class ii
    extends c.g
  {
    ii()
    {
      super("requestWxFaceVerifyInternal", 273, true);
    }
  }
  
  static final class ij
    extends c.g
  {
    ij()
    {
      super("requestWxVoicePrintVerifyInternal", 292, true);
    }
  }
  
  public static final class ik
    extends c.g
  {
    public ik()
    {
      super("resendRemittanceMsg", 246, true);
    }
  }
  
  public static final class il
    extends c.g
  {
    public il()
    {
      super("resume_download_task", 240, true);
    }
  }
  
  public static final class im
    extends c.g
  {
    public im()
    {
      super("scanLicence", 203, false);
    }
  }
  
  public static final class in
    extends c.g
  {
    public in()
    {
      super("scanQRCode", 7, true);
    }
  }
  
  public static final class io
    extends c.g
  {
    public io()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ip
    extends c.g
  {
    public ip()
    {
      super("", 329, false);
    }
  }
  
  static final class iq
    extends c.g
  {
    iq()
    {
      super("selectContact", 10000, true);
    }
  }
  
  public static final class ir
    extends c.g
  {
    public ir()
    {
      super("selectEnterpriseContact", 286, true);
    }
  }
  
  public static final class is
    extends c.g
  {
    public is()
    {
      super("selectPedometerSource", 146, true);
    }
  }
  
  public static final class it
    extends c.g
  {
    public it()
    {
      super("selectSingleContact", 167, true);
    }
  }
  
  public static final class iu
    extends c.g
  {
    public iu()
    {
      super("sendAppMessageToSpecifiedContact", 168, true);
    }
  }
  
  public static final class iv
    extends c.g
  {
    public iv()
    {
      super("send_app_msg", 6, true);
    }
  }
  
  public static final class ix
    extends c.g
  {
    public ix()
    {
      super("sendDataToWXDevice", 120, true);
    }
  }
  
  public static final class iy
    extends c.g
  {
    public iy()
    {
      super("sendEnterpriseChat", 222, true);
    }
  }
  
  static final class iz
    extends c.g
  {
    iz()
    {
      super("menuitem:gameSendDesktop", 255, false);
    }
  }
  
  public static final class ja
    extends c.g
  {
    public ja()
    {
      super("send_email", 35, false);
    }
  }
  
  public static final class jb
    extends c.g
  {
    public jb()
    {
      super("send_service_app_msg", 67, true);
    }
  }
  
  static final class jc
    extends c.g
  {
    jc()
    {
      super("sendSingleAppMessage", 316, true);
    }
  }
  
  static final class jd
    extends c.g
  {
    jd()
    {
      super("serviceClick", 304, false);
    }
  }
  
  static final class je
    extends c.g
  {
    je()
    {
      super("setWCPayPassword", 289, true);
    }
  }
  
  static final class jf
    extends c.g
  {
    jf()
    {
      super("setBackgroundAudioState", 262, false);
    }
  }
  
  public static final class jg
    extends c.g
  {
    public jg()
    {
      super("setBounceBackground", 218, false);
    }
  }
  
  public static final class jh
    extends c.g
  {
    public jh()
    {
      super("setCloseWindowConfirmDialogInfo", 77, false);
    }
  }
  
  static final class ji
    extends c.g
  {
    ji()
    {
      super("setGameData", 298, false);
    }
  }
  
  public static final class jj
    extends c.g
  {
    public jj()
    {
      super("", -2, false);
    }
  }
  
  public static final class jk
    extends c.g
  {
    public jk()
    {
      super("setFreeWifiOwner", 169, false);
    }
  }
  
  public static final class jl
    extends c.g
  {
    public jl()
    {
      super("setGameDebugConfig", 1111111, false);
    }
  }
  
  public static final class jm
    extends c.g
  {
    public jm()
    {
      super("setLocalData", 180, false);
    }
  }
  
  public static final class jn
    extends c.g
  {
    public jn()
    {
      super("setNavigationBarButtons", 195, false);
    }
  }
  
  public static final class jo
    extends c.g
  {
    public jo()
    {
      super("setNavigationBarColor", 182, false);
    }
  }
  
  public static final class jp
    extends c.g
  {
    public jp()
    {
      super("setPageOwner", 114, false);
    }
  }
  
  public static final class jq
    extends c.g
  {
    public jq()
    {
      super("setPageTitle", 113, false);
    }
  }
  
  static final class jr
    extends c.g
  {
    jr()
    {
      super("setScreenOrientation", 270, false);
    }
  }
  
  public static final class js
    extends c.g
  {
    public js()
    {
      super("", 10000, false);
    }
  }
  
  public static final class jt
    extends c.g
  {
    public jt()
    {
      super("setSendDataDirection", 127, false);
    }
  }
  
  public static final class ju
    extends c.g
  {
    public ju()
    {
      super("", 10000, false);
    }
  }
  
  public static final class jv
    extends c.g
  {
    public jv()
    {
      super("setStatusBarStyle", 206, false);
    }
  }
  
  static final class jw
    extends c.g
  {
    jw()
    {
      super("shareEmoticon", 275, true);
    }
  }
  
  public static final class jx
    extends c.g
  {
    public jx()
    {
      super("shareQQ", 90, true);
    }
  }
  
  public static final class jy
    extends c.g
  {
    public jy()
    {
      super("shareQZone", 132, true);
    }
  }
  
  public static final class jz
    extends c.g
  {
    public jz()
    {
      super("shareWeiboApp", 107, false);
    }
  }
  
  public static final class k
    extends c.g
  {
    public k()
    {
      super("add_download_task", 38, false);
    }
  }
  
  public static final class ka
    extends c.g
  {
    public ka()
    {
      super("showAllNonBaseMenuItem", 92, false);
    }
  }
  
  public static final class kb
    extends c.g
  {
    public kb()
    {
      super("showDatePickerView", 248, true);
    }
  }
  
  public static final class kc
    extends c.g
  {
    public kc()
    {
      super("showKeyboard", 187, false);
    }
  }
  
  public static final class kd
    extends c.g
  {
    public kd()
    {
      super("showMenuItems", 86, false);
    }
  }
  
  public static final class ke
    extends c.g
  {
    public ke()
    {
      super("showNavigationBarLoading", 197, false);
    }
  }
  
  public static final class kf
    extends c.g
  {
    public kf()
    {
      super("", 14, false);
    }
  }
  
  public static final class kg
    extends c.g
  {
    public kg()
    {
      super("showSearchActionSheet", 10000, false);
    }
  }
  
  public static final class kh
    extends c.g
  {
    public kh()
    {
      super("showSearchLoading", 10000, false);
    }
  }
  
  static final class ki
    extends c.g
  {
    ki()
    {
      super("showSearchOfBizHistory", 266, false);
    }
  }
  
  public static final class kj
    extends c.g
  {
    public kj()
    {
      super("showSearchToast", 10000, false);
    }
  }
  
  public static final class kk
    extends c.g
  {
    public kk()
    {
      super("showSmileyPanel", 238, false);
    }
  }
  
  public static final class kl
    extends c.g
  {
    public kl()
    {
      super("soter_biometric_authentication", 214, true);
    }
  }
  
  public static final class km
    extends c.g
  {
    public km()
    {
      super("getSupportSoter", 213, true);
    }
  }
  
  public static final class kn
    extends c.g
  {
    public kn()
    {
      super("startMonitoringBeacons", 151, false);
    }
  }
  
  public static final class ko
    extends c.g
  {
    public ko()
    {
      super("startPullDownRefresh", 204, false);
    }
  }
  
  public static final class kp
    extends c.g
  {
    public kp()
    {
      super("startRecord", 96, false);
    }
  }
  
  public static final class kq
    extends c.g
  {
    public kq()
    {
      super("startScanWXDevice", 121, true);
    }
  }
  
  public static final class kr
    extends c.g
  {
    public kr()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ks
    extends c.g
  {
    public ks()
    {
      super("startTempSession", 128, true);
    }
  }
  
  public static final class kt
    extends c.g
  {
    public kt()
    {
      super("startVoipCall", 230, false);
    }
  }
  
  public static final class ku
    extends c.g
  {
    public ku()
    {
      super("stopMonitoringBeacons", 152, false);
    }
  }
  
  public static final class kv
    extends c.g
  {
    public kv()
    {
      super("stopPullDownRefresh", 200, false);
    }
  }
  
  public static final class kw
    extends c.g
  {
    public kw()
    {
      super("stopRecord", 98, false);
    }
  }
  
  public static final class kx
    extends c.g
  {
    public kx()
    {
      super("stopScanWXDevice", 122, true);
    }
  }
  
  public static final class ky
    extends c.g
  {
    public ky()
    {
      super("stopVoice", 101, false);
    }
  }
  
  public static final class kz
    extends c.g
  {
    public kz()
    {
      super("playStreamingVideo", 209, false);
    }
  }
  
  public static final class l
    extends c.g
  {
    public l()
    {
      super("add_download_task_straight", 269, true);
    }
  }
  
  public static final class la
    extends c.g
  {
    public la()
    {
      super("selectWalletCurrency", 201, true);
    }
  }
  
  static final class lb
    extends c.g
  {
    lb()
    {
      super("tapSearchWAWidgetView", 10000, false);
    }
  }
  
  public static final class lc
    extends c.g
  {
    public lc()
    {
      super("share_timeline", 4, true);
    }
  }
  
  public static final class ld
    extends c.g
  {
    public ld()
    {
      super("translateVoice", 97, true);
    }
  }
  
  public static final class le
    extends c.g
  {
    public le()
    {
      super("unbindBankCard", 216, true);
    }
  }
  
  static final class lf
    extends c.g
  {
    lf()
    {
      super("updatePageAuth", -2, false);
    }
  }
  
  public static final class lg
    extends c.g
  {
    public lg()
    {
      super("", 10000, false);
    }
  }
  
  static final class lh
    extends c.g
  {
    lh()
    {
      super("updateAppMessageShareData", 326, false);
    }
  }
  
  public static final class li
    extends c.g
  {
    public li()
    {
      super("", 10000, false);
    }
  }
  
  static final class lj
    extends c.g
  {
    lj()
    {
      super("updateTimelineShareData", 327, false);
    }
  }
  
  public static final class lk
    extends c.g
  {
    public lk()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ll
    extends c.g
  {
    public ll()
    {
      super("updateWASearchTemplate", 10000, false);
    }
  }
  
  static final class lm
    extends c.g
  {
    lm()
    {
      super("uploadEncryptMediaFile", 253, false);
    }
  }
  
  public static final class ln
    extends c.g
  {
    public ln()
    {
      super("uploadImage", 105, true);
    }
  }
  
  public static final class lo
    extends c.g
  {
    public lo()
    {
      super("uploadMediaFile", 237, true);
    }
  }
  
  public static final class lp
    extends c.g
  {
    public lp()
    {
      super("uploadVideo", 192, true);
    }
  }
  
  public static final class lq
    extends c.g
  {
    public lq()
    {
      super("uploadVoice", 102, true);
    }
  }
  
  public static final class lr
    extends c.g
  {
    public lr()
    {
      super("uxSearchOpLog", 10000, false);
    }
  }
  
  public static final class ls
    extends c.g
  {
    public ls()
    {
      super("verifyWCPayPassword", 115, true);
    }
  }
  
  static final class lt
    extends c.g
  {
    lt()
    {
      super("", 10000, false);
    }
  }
  
  public static final class lu
    extends c.g
  {
    public lu()
    {
      super("", 355, true);
    }
  }
  
  static final class lv
    extends c.g
  {
    lv()
    {
      super("wcPrivacyPolicyResult", 315, false);
    }
  }
  
  public static final class lw
    extends c.g
  {
    public lw()
    {
      super("cache", 150, false);
    }
  }
  
  public static final class lx
    extends c.g
  {
    public lx()
    {
      super("videoProxyInit", 156, false);
    }
  }
  
  public static final class ly
    extends c.g
  {
    public ly()
    {
      super("videoProxySetPlayerState", 159, false);
    }
  }
  
  public static final class lz
    extends c.g
  {
    public lz()
    {
      super("videoProxySetPlayerState", 160, false);
    }
  }
  
  static final class m
    extends c.g
  {
    m()
    {
      super("addGameDownloadTask", -1, true);
    }
  }
  
  public static final class ma
    extends c.g
  {
    public ma()
    {
      super("videoProxyStartPlay", 157, false);
    }
  }
  
  public static final class mb
    extends c.g
  {
    public mb()
    {
      super("videoProxyStopPlay", 158, false);
    }
  }
  
  public static final class mc
    extends c.g
  {
    public mc()
    {
      super("publicCache", 149, false);
    }
  }
  
  public static final class md
    extends c.g
  {
    public md()
    {
      super("videoProxyPreload", 172, false);
    }
  }
  
  public static final class me
    extends c.g
  {
    public me()
    {
      super("share_weibo", 3, true);
    }
  }
  
  public static final class mf
    extends c.g
  {
    public mf()
    {
      super("", 10000, false);
    }
  }
  
  public static final class mg
    extends c.g
  {
    public mg()
    {
      super("WNNativeAsyncCallback", 10006, false);
    }
  }
  
  public static final class mh
    extends c.g
  {
    public mh()
    {
      super("WNNativeCallbackInitData", 10006, false);
    }
  }
  
  public static final class mi
    extends c.g
  {
    public mi()
    {
      super("WNNativeCallbackOnCaretChange", 10006, false);
    }
  }
  
  public static final class mj
    extends c.g
  {
    public mj()
    {
      super("WNNativeCallbackOnClick", 10006, false);
    }
  }
  
  public static final class mk
    extends c.g
  {
    public mk()
    {
      super("WNNativeCallbackOnLongClick", 10006, false);
    }
  }
  
  public static final class ml
    extends c.g
  {
    public ml()
    {
      super("write_comm_data", 53, false);
    }
  }
  
  static final class mm
    extends c.g
  {
    mm()
    {
      super("calRqt", 319, false);
    }
  }
  
  static final class mn
    extends c.g
  {
    mn()
    {
      super("getCCData", 312, false);
    }
  }
  
  static final class mo
    extends c.g
  {
    mo()
    {
      super("openRealnameAuth", 314, true);
    }
  }
  
  public static final class mp
    extends c.g
  {
    public mp()
    {
      super("WNNativeCallbackOnBecomeEditing", 10006, false);
    }
  }
  
  public static final class mq
    extends c.g
  {
    public mq()
    {
      super("WNNativeCallbackOnBecomeEdited", 10006, false);
    }
  }
  
  public static final class mr
    extends c.g
  {
    public mr()
    {
      super("", 317, true);
    }
  }
  
  public static final class ms
    extends c.g
  {
    public ms()
    {
      super("", 129, false);
    }
  }
  
  public static final class mt
    extends c.g
  {
    public mt()
    {
      super("", 89, false);
    }
  }
  
  public static final class mu
    extends c.g
  {
    public mu()
    {
      super("", 94, false);
    }
  }
  
  public static final class mv
    extends c.g
  {
    public mv()
    {
      super("", 134, false);
    }
  }
  
  public static final class mw
    extends c.g
  {
    public mw()
    {
      super("", 88, false);
    }
  }
  
  public static final class mx
    extends c.g
  {
    public mx()
    {
      super("", 109, false);
    }
  }
  
  public static final class my
    extends c.g
  {
    public my()
    {
      super("", 320, true);
    }
  }
  
  public static final class mz
    extends c.g
  {
    public mz()
    {
      super("uploadIdCardSuccess", 233, false);
    }
  }
  
  static final class n
    extends c.g
  {
    n()
    {
      super("addToEmoticon", 274, true);
    }
  }
  
  public static final class nb
    extends c.g
  {
    public nb()
    {
      super("", 10000, false);
    }
  }
  
  public static final class nc
    extends c.g
  {
    public nc()
    {
      super("", 10000, false);
    }
  }
  
  public static final class o
    extends c.g
  {
    public o()
    {
      super("ad_data_report", 221, false);
    }
  }
  
  static final class p
    extends c.g
  {
    p()
    {
      super("authorize", 232, true);
    }
  }
  
  public static final class q
    extends c.g
  {
    public q()
    {
      super("batch_add_card", 82, true);
    }
  }
  
  static final class s
    extends c.g
  {
    s()
    {
      super("batchUpdateWepkg", 334, false);
    }
  }
  
  public static final class t
    extends c.g
  {
    public t()
    {
      super("batchViewCard", 111, true);
    }
  }
  
  static final class u
    extends c.g
  {
    u()
    {
      super("bindEmail", 306, true);
    }
  }
  
  public static final class v
    extends c.g
  {
    public v()
    {
      super("cancel_download_task", 39, false);
    }
  }
  
  static final class w
    extends c.g
  {
    w()
    {
      super("cancelHaowanPublish", 353, false);
    }
  }
  
  public static final class x
    extends c.g
  {
    public x()
    {
      super("cancelSearchActionSheet", 10000, false);
    }
  }
  
  public static final class y
    extends c.g
  {
    public y()
    {
      super("change_pay_activity_view", 207, true);
    }
  }
  
  static final class z
    extends c.g
  {
    z()
    {
      super("checkIsSupportFaceDetect", 265, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c
 * JD-Core Version:    0.7.0.1
 */