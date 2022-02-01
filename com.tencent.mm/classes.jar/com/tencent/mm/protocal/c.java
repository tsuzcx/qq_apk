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
  private static Map<String, c.g> KyB;
  public static final String[] KyC;
  
  static
  {
    AppMethodBeat.i(152436);
    KyB = null;
    KyC = (String[])new c.1().toArray(new String[0]);
    AppMethodBeat.o(152436);
  }
  
  public static Bundle bga(String paramString)
  {
    AppMethodBeat.i(152434);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("handle", true);
    localBundle.putString("handle_result", paramString);
    AppMethodBeat.o(152434);
    return localBundle;
  }
  
  public static c.g bgb(String paramString)
  {
    AppMethodBeat.i(152435);
    if ((KyB == null) || (KyB.size() <= 0))
    {
      Object localObject = new HashMap(128);
      KyB = (Map)localObject;
      ((Map)localObject).put("log", new fc());
      KyB.put("imagePreview", new ek());
      KyB.put("profile", new ia());
      KyB.put("shareWeibo", new mt());
      KyB.put("shareTimeline", new lr());
      KyB.put("adDataReport", new o());
      KyB.put("streamingVideoPlay", new lo());
      KyB.put("addContact", new h());
      KyB.put("getWidgetCaptureImgUrl", new du());
      KyB.put("sendAppMessage", new jk());
      KyB.put("scanQRCode", new jc());
      KyB.put("hideOptionMenu", new eh());
      KyB.put("showOptionMenu", new ku());
      KyB.put("getNetworkType", new cv());
      KyB.put("closeWindow", new aq());
      KyB.put("getInstallState", new cq());
      KyB.put("setFontSizeCallback", new jy());
      KyB.put("jumpToInstallUrl", new er());
      KyB.put("launchApp", new ex());
      KyB.put("getBrandWCPayRequest", new cd());
      KyB.put("secureTunnel", new je());
      KyB.put("wcpaySecurityCrosscutBack", new mj());
      KyB.put("editAddress", new bl());
      KyB.put("getHeadingAndPitch", new cn());
      KyB.put("sendEmail", new jp());
      KyB.put("addDownloadTask", new k());
      KyB.put("cancelDownloadTask", new x());
      KyB.put("pauseDownloadTask", new hp());
      KyB.put("resumeDownloadTask", new ja());
      KyB.put("queryDownloadTask", new id());
      KyB.put("installDownloadTask", new en());
      KyB.put("getLatestAddress", new da());
      KyB.put("openSpecificView", new gz());
      KyB.put("jumpWCMall", new et());
      KyB.put("launch3rdApp", new ew());
      KyB.put("writeCommData", new na());
      KyB.put("openUrlByExtBrowser", new ha());
      KyB.put("geoLocation", new by());
      KyB.put("getBrandWCPayBindCardRequest", new cc());
      KyB.put("openProductView", new gs());
      KyB.put("openProductViewWithPid", new gt());
      KyB.put("jumpToBizProfile", new es());
      KyB.put("openTimelineCheckInList", new fj());
      KyB.put("openLocation", new fi());
      KyB.put("timelineCheckIn", new fh());
      KyB.put("getBrandWCPayCreateCreditCardRequest", new hg());
      KyB.put("chooseCard", new ad());
      KyB.put("chooseInvoice", new ah());
      KyB.put("sendServiceAppMessage", new jq());
      KyB.put("musicPlay", new ff());
      KyB.put("mmsf0001", new ci());
      KyB.put("connectToWiFi", new av());
      KyB.put("getTransferMoneyRequest", new dq());
      KyB.put("openWCPaySpecificView", new hc());
      KyB.put("setCloseWindowConfirmDialogInfo", new jw());
      KyB.put("batchAddCard", new s());
      KyB.put("preVerifyJSAPI", new hx());
      KyB.put("startRecord", new le());
      KyB.put("stopRecord", new ll());
      KyB.put("playVoice", new hs());
      KyB.put("pauseVoice", new hq());
      KyB.put("stopVoice", new ln());
      KyB.put("uploadVoice", new mf());
      KyB.put("downloadVoice", new bh());
      KyB.put("chooseImage", new ag());
      KyB.put("uploadImage", new mc());
      KyB.put("downloadImage", new bg());
      KyB.put("uploadMediaFile", new md());
      KyB.put("hideMenuItems", new ee());
      KyB.put("showMenuItems", new kr());
      KyB.put("hideAllNonBaseMenuItem", new ed());
      KyB.put("showAllNonBaseMenuItem", new ko());
      KyB.put("checkJsApi", new ac());
      KyB.put("translateVoice", new ls());
      KyB.put("shareQQ", new kl());
      KyB.put("shareWeiboApp", new kn());
      KyB.put("shareQZone", new km());
      KyB.put("getSendC2CMessageRequest", new dn());
      KyB.put("batchViewCard", new v());
      KyB.put("configWXDeviceWiFi", new at());
      KyB.put("getCurrentSSID", new cg());
      KyB.put("setPageOwner", new kd());
      KyB.put("getWechatVerifyTicket", new ds());
      KyB.put("openWXDeviceLib", new hh());
      KyB.put("startScanWXDevice", new lf());
      KyB.put("stopScanWXDevice", new lm());
      KyB.put("connectWXDevice", new aw());
      KyB.put("disconnectWXDevice", new bf());
      KyB.put("getWXDeviceTicket", new dw());
      KyB.put("getWXDeviceInfos", new dv());
      KyB.put("sendDataToWXDevice", new jm());
      KyB.put("closeWXDeviceLib", new as());
      KyB.put("setSendDataDirection", new kh());
      KyB.put("verifyWCPayPassword", new mh());
      KyB.put("getPaymentOrderRequest", new cz());
      KyB.put("openGameDetail", new gi());
      KyB.put("openGameCenter", new gh());
      KyB.put("setGameDebugConfig", new jz());
      KyB.put("startTempSession", new lh());
      KyB.put("getH5PrepayRequest", new co());
      KyB.put("getH5TransactionRequest", new cp());
      KyB.put("menu:share:timeline", new nl());
      KyB.put("menu:share:appmessage", new ni());
      KyB.put("menu:share:qq", new nj());
      KyB.put("menu:share:weiboApp", new nm());
      KyB.put("menu:setfont", new nh());
      KyB.put("menu:share:weibo", new nm());
      KyB.put("menu:share:QZone", new nk());
      KyB.put("getRecevieBizHongBaoRequest", new e());
      KyB.put("insertVideoPlayer", new em());
      KyB.put("updateVideoPlayer", new lz());
      KyB.put("removeVideoPlayer", new il());
      KyB.put("operateVideoPlayer", new hl());
      KyB.put("deleteSearchHistory", new bc());
      KyB.put("getSearchHistory", new dj());
      KyB.put("getSearchData", new df());
      KyB.put("getChatSearchData", new ce());
      KyB.put("getPoiInfo", new cm());
      KyB.put("updateReddotTimeStamps", new lv());
      KyB.put("getTeachSearchData", new dp());
      KyB.put("getSearchGuideData", new di());
      KyB.put("getSearchAvatarList", new de());
      KyB.put("getSearchSnsImageList", new dl());
      KyB.put("getSearchImageList", new dk());
      KyB.put("getSearchDisplayNameList", new dg());
      KyB.put("startSearchItemDetailPage", new lg());
      KyB.put("reportSearchStatistics", new is());
      KyB.put("reportSearchRealTimeStatistics", new ir());
      KyB.put("searchDataHasResult", new jd());
      KyB.put("openEmotionPage", new bu());
      KyB.put("getSearchSuggestionData", new dm());
      KyB.put("setSearchInputWord", new kg());
      KyB.put("setSnsObjectXmlDescList", new ki());
      KyB.put("clickSnsMusicPlayButton", new ap());
      KyB.put("openWeAppPage", new hf());
      KyB.put("reportWeAppSearchRealtime", new mu());
      KyB.put("doSearchOperation", new bk());
      KyB.put("insertSearchWAWidgetView", new el());
      KyB.put("removeSearchWAWidgetView", new ik());
      KyB.put("updateSearchWAWidgetView", new lx());
      KyB.put("showSearchActionSheet", new kv());
      KyB.put("cancelSearchActionSheet", new z());
      KyB.put("showSearchToast", new ky());
      KyB.put("showSearchLoading", new kw());
      KyB.put("hideSearchLoading", new ei());
      KyB.put("updateWASearchTemplate", new ma());
      KyB.put("preloadSearchWeapp", new hv());
      KyB.put("uxSearchOpLog", new mg());
      KyB.put("querySearchWeb", new bw());
      KyB.put("openFinderProfile", new gg());
      KyB.put("openFinderFeed", new gf());
      KyB.put("getCurrentLocation", new cf());
      KyB.put("navControl", new fg());
      KyB.put("showNavBarShadow", new kt());
      KyB.put("hideNavBarShadow", new eg());
      KyB.put("jumpToWXWallet", new eu());
      KyB.put("scanCover", new f());
      KyB.put("reportActionInfo", new im());
      KyB.put("openMyDeviceProfile", new gp());
      KyB.put("selectPedometerSource", new jh());
      KyB.put("nfcIsConnect", new fp());
      KyB.put("nfcConnect", new fm());
      KyB.put("nfcTransceive", new fq());
      KyB.put("nfcBatchTransceive", new fk());
      KyB.put("nfcGetId", new fn());
      KyB.put("nfcGetInfo", new fo());
      KyB.put("startMonitoringBeacons", new lc());
      KyB.put("stopMonitoringBeacons", new lj());
      KyB.put("nfcCheckState", new fl());
      KyB.put("videoProxyInit", new mm());
      KyB.put("videoProxyStartPlay", new mp());
      KyB.put("videoProxyStopPlay", new mq());
      KyB.put("videoProxySetPlayerState", new mn());
      KyB.put("videoProxySetRemainTime", new mo());
      KyB.put("videoProxyPreload", new ms());
      KyB.put("getWebPayCheckoutCounterRequst", new fb());
      KyB.put("addCustomMenuItems", new i());
      KyB.put("operateGameCenterMsg", new hk());
      KyB.put("openEnterpriseChat", new gd());
      KyB.put("enterEnterpriseChat", new bp());
      KyB.put("openEnterpriseContact", new ge());
      KyB.put("selectEnterpriseContact", new jg());
      KyB.put("getEnterpriseChat", new ck());
      KyB.put("reportIDKey", new ip());
      KyB.put("quicklyAddBrandContact", new ig());
      KyB.put("consumedShareCard", new ax());
      KyB.put("cache", new ml());
      KyB.put("publicCache", new mr());
      KyB.put("kvReport", new ev());
      KyB.put("realtimeReport", new ih());
      KyB.put("openUrlWithExtraWebview", new hb());
      KyB.put("selectSingleContact", new ji());
      KyB.put("sendAppMessageToSpecifiedContact", new jj());
      KyB.put("setLocalData", new ka());
      KyB.put("getLocalData", new cr());
      KyB.put("clearLocalData", new an());
      KyB.put("showKeyboard", new kq());
      KyB.put("showSmileyPanel", new kz());
      KyB.put("disableBounceScroll", new bd());
      KyB.put("clearBounceBackground", new al());
      KyB.put("setNavigationBarButtons", new kb());
      KyB.put("enableFullScreen", new bn());
      KyB.put("showNavigationBarLoading", new ks());
      KyB.put("hideNavigationBarLoading", new ef());
      KyB.put("enablePullDownRefresh", new bo());
      KyB.put("startPullDownRefresh", new ld());
      KyB.put("stopPullDownRefresh", new lk());
      KyB.put("disablePullDownRefresh", new be());
      KyB.put("setPageTitle", new ke());
      KyB.put("setStatusBarStyle", new kj());
      KyB.put("deleteAccountSuccess", new bb());
      KyB.put("chooseVideo", new ak());
      KyB.put("uploadVideo", new me());
      KyB.put("openMapNavigateMenu", new go());
      KyB.put("setNavigationBarColor", new kc());
      KyB.put("getWCPayRealnameVerify", new dr());
      KyB.put("openDesignerEmojiView", new fx());
      KyB.put("openDesignerProfile", new fz());
      KyB.put("openEmoticonTopicList", new gc());
      KyB.put("openDesignerEmojiViewLocal", new fy());
      KyB.put("openDesignerProfileLocal", new ga());
      KyB.put("openEmotionDetailViewLocal", new d());
      KyB.put("openNewPage", new gq());
      KyB.put("getSearchEmotionData", new dh());
      KyB.put("openEmotionUrl", new bm());
      KyB.put("WNNativeCallbackOnClick", new my());
      KyB.put("WNNativeCallbackOnLongClick", new mz());
      KyB.put("WNNativeCallbackOnCaretChange", new mx());
      KyB.put("WNNativeCallbackInitData", new mw());
      KyB.put("WNNativeAsyncCallback", new mv());
      KyB.put("WNNativeCallbackOnBecomeEditing", new ne());
      KyB.put("WNNativeCallbackOnBecomeEdited", new nf());
      KyB.put("changePayActivityView", new aa());
      KyB.put("selectWalletCurrency", new lp());
      KyB.put("scanLicence", new jb());
      KyB.put("operateMusicPlayer", new b());
      KyB.put("getMusicPlayerState", new a());
      KyB.put("clearWebviewCache", new ao());
      KyB.put("requireSoterBiometricAuthentication", new la());
      KyB.put("getSupportSoter", new lb());
      KyB.put("unbindBankCard", new lt());
      KyB.put("setBounceBackground", new jv());
      KyB.put("sendEnterpriseChat", new jn());
      KyB.put("doExposePreparation", new bj());
      KyB.put("getMsgProofItems", new cu());
      KyB.put("openSecurityView", new gx());
      KyB.put("startVoipCall", new li());
      KyB.put("chooseInvoiceTitle", new ai());
      KyB.put("getOpenDeviceId", new cx());
      KyB.put("getRouteUrl", new dd());
      KyB.put("idCardRealnameVerify", new ej());
      KyB.put("uploadIdCardSuccess", new no());
      KyB.put("showDatePickerView", new kp());
      KyB.put("openLuckyMoneyDetailView", new gm());
      KyB.put("resendRemittanceMsg", new iz());
      KyB.put("getGameCommInfo", new cl());
      KyB.put("openGameRegion", new gj());
      KyB.put("chooseIdCard", new af());
      KyB.put("getLocalImgData", new c());
      KyB.put("openWeApp", new he());
      KyB.put("recordVideo", new ii());
      KyB.put("previewVideo", new hw());
      KyB.put("uploadEncryptMediaFile", new mb());
      KyB.put("chooseMedia", new aj());
      KyB.put("requestWxFacePictureVerify", new bq());
      KyB.put("openCustomWebview", new fw());
      KyB.put("forceUpdateWxaAttr", new bt());
      KyB.put("openLuckyMoneyHistory", new gn());
      KyB.put("menuitem:gameSendDesktop", new jo());
      KyB.put("getWePkgAuthResult", new dt());
      KyB.put("getLocalWePkgInfo", new cs());
      KyB.put("openGameWebView", new gl());
      KyB.put("reportGameWeb", new io());
      KyB.put("launchApplication", new ey());
      KyB.put("showSearchOfBizHistory", new kx());
      KyB.put("login", new fd());
      KyB.put("authorize", new r());
      KyB.put("requestWxFacePictureVerifyUnionVideo", new br());
      KyB.put("checkIsSupportFaceDetect", new ab());
      KyB.put("operateBackgroundAudio", new hj());
      KyB.put("setBackgroundAudioState", new ju());
      KyB.put("getBackgroundAudioState", new ca());
      KyB.put("addDownloadTaskStraight", new l());
      KyB.put("setScreenOrientation", new kf());
      KyB.put("addToEmoticon", new n());
      KyB.put("shareEmoticon", new kk());
      KyB.put("makePhoneCall", new fe());
      KyB.put("openADCanvas", new fv());
      KyB.put("openSearchCanvas", new gu());
      KyB.put("opVoteAdData", new ho());
      KyB.put("opJumpView", new hn());
      KyB.put("opAdH5Func", new hm());
      KyB.put("requestWxFaceRegisterInternal", new iw());
      KyB.put("requestWxFaceVerifyInternal", new ix());
      KyB.put("launchMiniProgram", new fa());
      KyB.put("reportMiniProgramPageData", new iq());
      KyB.put("selectContact", new jf());
      KyB.put("openSearchWAWidgetLogView", new gv());
      KyB.put("reloadSearchWAWidgetData", new ij());
      KyB.put("gotoEmoticonPad", new dx());
      KyB.put("querySimilarEmotion", new if());
      KyB.put("closeWindowAndGoNext", new ar());
      KyB.put("requestWxVoicePrintVerifyInternal", new iy());
      KyB.put("openBizChat", new fu());
      KyB.put("handleWCPayWalletBuffer", new ec());
      KyB.put("tapSearchWAWidgetView", new lq());
      KyB.put("getMatchContactList", new ct());
      KyB.put("openSearchWebView", new gw());
      KyB.put("openWXSearchPage", new hi());
      KyB.put("viewTypeChange", new mi());
      KyB.put("invokeMiniProgramAPI", new ep());
      KyB.put("openGameUrlWithExtraWebView", new gk());
      KyB.put("setGameData", new jx());
      KyB.put("getGameData", new ch());
      KyB.put("clearGameData", new am());
      KyB.put("openECard", new gb());
      KyB.put("reportGamePageTime", new in());
      KyB.put("setWCPayPassword", new jt());
      KyB.put("openWCPayCardList", new ft());
      KyB.put("bindEmail", new w());
      KyB.put("openOfflinePayView", new gr());
      KyB.put("bindEmail", new w());
      KyB.put("doGoToRecVideoList", new db());
      KyB.put("jumpWSRecVideoList", new ng());
      KyB.put("openWebSearchOutLinkItem", new nn());
      KyB.put("recordHistory", new bx());
      localObject = gtr().iterator();
      while (((Iterator)localObject).hasNext())
      {
        c.g localg = (c.g)((Iterator)localObject).next();
        KyB.put(localg.getName(), localg);
      }
      KyB.put("getSystemInfo", new do());
      KyB.put("serviceClick", new js());
      KyB.put("openRealnameAuth", new nd());
      KyB.put("sendSingleAppMessage", new jr());
      KyB.put("wcPrivacyPolicyResult", new mk());
      KyB.put("currentMpInfo", new ay());
      KyB.put("updateAppMessageShareData", new lw());
      KyB.put("updateTimelineShareData", new ly());
      KyB.put("getCCData", new nc());
      KyB.put("calRqt", new nb());
      KyB.put("faceVerifyForPay", new bs());
      KyB.put("request", new it());
      KyB.put("notifyPageInfo", new fr());
      KyB.put("updatePageAuth", new lu());
      KyB.put("jumpDownloaderWidget", new eq());
      KyB.put("batchUpdateWepkg", new u());
      KyB.put("addGameDownloadTask", new m());
      KyB.put("internelWxFaceVerify", new eo());
      KyB.put("getDownloadWidgetTaskInfos", new cj());
      KyB.put("chooseHaowanMedia", new ae());
      KyB.put("queryHaowanPublish", new ie());
      KyB.put("publishHaowanEdition", new ib());
      KyB.put("cancelHaowanPublish", new y());
      KyB.put("launchGameVideoEditor", new ez());
      KyB.put("requestJointPayment", new iv());
      KyB.put("openSelectPayment", new gy());
      KyB.put("requestEntrustAuthorization", new iu());
      KyB.put("getOAID", new cw());
      KyB.put("qqMailLoginResult", new ic());
    }
    paramString = (c.g)KyB.get(paramString);
    AppMethodBeat.o(152435);
    return paramString;
  }
  
  private static List<c.g> gtr()
  {
    AppMethodBeat.i(223873);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new c.ba());
    localLinkedList.add(new c.az());
    localLinkedList.add(new c.bz());
    localLinkedList.add(new eb());
    localLinkedList.add(new c.dy());
    localLinkedList.add(new hu());
    localLinkedList.add(new c.ht());
    localLinkedList.add(new c.jl());
    localLinkedList.add(new c.dz());
    localLinkedList.add(new ea());
    localLinkedList.add(new c.j());
    localLinkedList.add(new c.hz());
    localLinkedList.add(new c.hy());
    localLinkedList.add(new bv());
    localLinkedList.add(new c.hd());
    localLinkedList.add(new au());
    localLinkedList.add(new cy());
    localLinkedList.add(new c.dc());
    localLinkedList.add(new c.t());
    localLinkedList.add(new c.fs());
    localLinkedList.add(new hr());
    localLinkedList.add(new c.p());
    localLinkedList.add(new q());
    localLinkedList.add(new cb());
    localLinkedList.add(new c.bi());
    AppMethodBeat.o(223873);
    return localLinkedList;
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
      super("change_pay_activity_view", 207, true);
    }
  }
  
  static final class ab
    extends c.g
  {
    ab()
    {
      super("checkIsSupportFaceDetect", 265, false);
    }
  }
  
  public static final class ac
    extends c.g
  {
    public ac()
    {
      super("checkJsApi", 84, false);
    }
  }
  
  public static final class ad
    extends c.g
  {
    public ad()
    {
      super("choose_card", 70, true);
    }
  }
  
  static final class ae
    extends c.g
  {
    ae()
    {
      super("chooseHaowanMedia", 354, true);
    }
  }
  
  public static final class af
    extends c.g
  {
    public af()
    {
      super("chooseIdCard", 247, true);
    }
  }
  
  public static final class ag
    extends c.g
  {
    public ag()
    {
      super("chooseImage", 104, true);
    }
  }
  
  public static final class ah
    extends c.g
  {
    public ah()
    {
      super("chooseInvoice", 202, true);
    }
  }
  
  public static final class ai
    extends c.g
  {
    public ai()
    {
      super("chooseInvoiceTitle", 288, true);
    }
  }
  
  static final class aj
    extends c.g
  {
    aj()
    {
      super("chooseMedia", 254, true);
    }
  }
  
  public static final class ak
    extends c.g
  {
    public ak()
    {
      super("chooseVideo", 191, true);
    }
  }
  
  public static final class al
    extends c.g
  {
    public al()
    {
      super("clearBounceBackground", 189, false);
    }
  }
  
  static final class am
    extends c.g
  {
    am()
    {
      super("clearGameData", 300, false);
    }
  }
  
  public static final class an
    extends c.g
  {
    public an()
    {
      super("clearLocalData", 181, false);
    }
  }
  
  public static final class ao
    extends c.g
  {
    public ao()
    {
      super("clearWebviewCache", 208, false);
    }
  }
  
  public static final class ap
    extends c.g
  {
    public ap()
    {
      super("", 10000, false);
    }
  }
  
  public static final class aq
    extends c.g
  {
    public aq()
    {
      super("close_window", 17, false);
    }
  }
  
  static final class ar
    extends c.g
  {
    ar()
    {
      super("closeWindowAndGoNext", 293, false);
    }
  }
  
  public static final class as
    extends c.g
  {
    public as()
    {
      super("closeWXDeviceLib", 118, false);
    }
  }
  
  public static final class at
    extends c.g
  {
    public at()
    {
      super("configWXDeviceWiFi", 126, true);
    }
  }
  
  static final class au
    extends c.g
  {
    au()
    {
      super("confirmDialog", 343, true);
    }
  }
  
  public static final class av
    extends c.g
  {
    public av()
    {
      super("connecttowifi", 71, false);
    }
  }
  
  public static final class aw
    extends c.g
  {
    public aw()
    {
      super("connectWXDevice", 123, true);
    }
  }
  
  public static final class ax
    extends c.g
  {
    public ax()
    {
      super("consumedShareCard", 177, true);
    }
  }
  
  static final class ay
    extends c.g
  {
    public ay()
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
  
  public static final class bb
    extends c.g
  {
    public bb()
    {
      super("deleteAccountSuccess", 144, false);
    }
  }
  
  public static final class bc
    extends c.g
  {
    public bc()
    {
      super("", 10000, false);
    }
  }
  
  public static final class bd
    extends c.g
  {
    public bd()
    {
      super("disableBounceScroll", 188, false);
    }
  }
  
  public static final class be
    extends c.g
  {
    public be()
    {
      super("disablePullDownRefresh", 205, false);
    }
  }
  
  public static final class bf
    extends c.g
  {
    public bf()
    {
      super("disconnectWXDevice", 124, true);
    }
  }
  
  public static final class bg
    extends c.g
  {
    public bg()
    {
      super("downloadImage", 106, true);
    }
  }
  
  public static final class bh
    extends c.g
  {
    public bh()
    {
      super("downloadVoice", 103, true);
    }
  }
  
  public static final class bj
    extends c.g
  {
    public bj()
    {
      super("doExposePreparation", 225, false);
    }
  }
  
  public static final class bk
    extends c.g
  {
    public bk()
    {
      super("", 10000, false);
    }
  }
  
  public static final class bl
    extends c.g
  {
    public bl()
    {
      super("edit_address", 29, true);
    }
  }
  
  public static final class bm
    extends c.g
  {
    public bm()
    {
      super("openEmotionUrl", 20000, false);
    }
  }
  
  public static final class bn
    extends c.g
  {
    public bn()
    {
      super("enableFullScreen", 196, false);
    }
  }
  
  public static final class bo
    extends c.g
  {
    public bo()
    {
      super("enablePullDownRefresh", 199, false);
    }
  }
  
  public static final class bp
    extends c.g
  {
    public bp()
    {
      super("enterEnterpriseChat", 223, false);
    }
  }
  
  static final class bq
    extends c.g
  {
    bq()
    {
      super("requestWxFacePictureVerify", 259, true);
    }
  }
  
  static final class br
    extends c.g
  {
    br()
    {
      super("requestWxFacePictureVerifyUnionVideo", 264, true);
    }
  }
  
  static final class bs
    extends c.g
  {
    bs()
    {
      super("faceVerifyForPay", 328, true);
    }
  }
  
  static final class bt
    extends c.g
  {
    bt()
    {
      super("forceUpdateWxaAttr", 257, false);
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
      super("openBusinessView", 338, true);
    }
  }
  
  public static final class bw
    extends c.g
  {
    public bw()
    {
      super("", 10000, false);
    }
  }
  
  static final class bx
    extends c.g
  {
    bx()
    {
      super("recordHistory", 219, false);
    }
  }
  
  public static final class by
    extends c.g
  {
    public by()
    {
      super("geo_location", 57, false);
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
  
  static final class ca
    extends c.g
  {
    ca()
    {
      super("getBackgroundAudioState", 263, false);
    }
  }
  
  static final class cb
    extends c.g
  {
    cb()
    {
      super("requestBindPhoneNumber", 387, false);
    }
  }
  
  public static final class cc
    extends c.g
  {
    public cc()
    {
      super("get_brand_WCPay_bind_card_request", 58, true);
    }
  }
  
  public static final class cd
    extends c.g
  {
    public cd()
    {
      super("get_brand_wcpay_request", 28, true);
    }
  }
  
  public static final class ce
    extends c.g
  {
    public ce()
    {
      super("", 10000, false);
    }
  }
  
  public static final class cf
    extends c.g
  {
    public cf()
    {
      super("", 10000, false);
    }
  }
  
  public static final class cg
    extends c.g
  {
    public cg()
    {
      super("getCurrentSSID", 176, true);
    }
  }
  
  static final class ch
    extends c.g
  {
    ch()
    {
      super("getGameData", 299, false);
    }
  }
  
  public static final class ci
    extends c.g
  {
    public ci()
    {
      super("mmsf0001", -2, false);
    }
  }
  
  static final class cj
    extends c.g
  {
    cj()
    {
      super("getDownloadWidgetTaskInfos", 340, false);
    }
  }
  
  public static final class ck
    extends c.g
  {
    public ck()
    {
      super("getEnterpriseChat", 244, false);
    }
  }
  
  public static final class cl
    extends c.g
  {
    public cl()
    {
      super("getGameCommInfo", 241, false);
    }
  }
  
  public static final class cm
    extends c.g
  {
    public cm()
    {
      super("", 10000, false);
    }
  }
  
  public static final class cn
    extends c.g
  {
    public cn()
    {
      super("get_heading_and_pitch", 33, false);
    }
  }
  
  public static final class co
    extends c.g
  {
    public co()
    {
      super("getH5PrepayRequest", 137, true);
    }
  }
  
  public static final class cp
    extends c.g
  {
    public cp()
    {
      super("getH5TransactionRequest", 138, true);
    }
  }
  
  public static final class cq
    extends c.g
  {
    public cq()
    {
      super("get_install_state", 25, false);
    }
  }
  
  public static final class cr
    extends c.g
  {
    public cr()
    {
      super("getLocalData", 179, false);
    }
  }
  
  static final class cs
    extends c.g
  {
    cs()
    {
      super("getLocalWePkgInfo", -2, false);
    }
  }
  
  static final class ct
    extends c.g
  {
    ct()
    {
      super("getMatchContactList", 10000, false);
    }
  }
  
  public static final class cu
    extends c.g
  {
    public cu()
    {
      super("getMsgProofItems", 226, true);
    }
  }
  
  public static final class cv
    extends c.g
  {
    public cv()
    {
      super("network_type", 16, false);
    }
  }
  
  static final class cw
    extends c.g
  {
    cw()
    {
      super("getOAID", 361, false);
    }
  }
  
  public static final class cx
    extends c.g
  {
    public cx()
    {
      super("getOpenDeviceId", 227, false);
    }
  }
  
  static final class cy
    extends c.g
  {
    cy()
    {
      super("getPasteboardContent", 364, false);
    }
  }
  
  public static final class cz
    extends c.g
  {
    public cz()
    {
      super("getPaymentOrderRequest", 116, true);
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
      super("get_recently_used_address", 46, true);
    }
  }
  
  static final class db
    extends c.g
  {
    db()
    {
      super("doGoToRecVideoList", 10000, false);
    }
  }
  
  public static final class dd
    extends c.g
  {
    public dd()
    {
      super("getRouteUrl", 235, false);
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
      super("getSearchDisplayNameList", 10000, false);
    }
  }
  
  public static final class dh
    extends c.g
  {
    public dh()
    {
      super("getSearchEmotionData", 20000, false);
    }
  }
  
  public static final class di
    extends c.g
  {
    public di()
    {
      super("", 10000, false);
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
      super("", 10000, false);
    }
  }
  
  public static final class dl
    extends c.g
  {
    public dl()
    {
      super("", 10000, false);
    }
  }
  
  public static final class dm
    extends c.g
  {
    public dm()
    {
      super("", 10000, false);
    }
  }
  
  public static final class dn
    extends c.g
  {
    public dn()
    {
      super("get_send_c2c_message_request", 83, true);
    }
  }
  
  static final class do
    extends c.g
  {
    do()
    {
      super("getSystemInfo", 311, false);
    }
  }
  
  public static final class dp
    extends c.g
  {
    public dp()
    {
      super("", 10000, false);
    }
  }
  
  public static final class dq
    extends c.g
  {
    public dq()
    {
      super("get_transfer_money_request", 74, true);
    }
  }
  
  public static final class dr
    extends c.g
  {
    public dr()
    {
      super("getWCPayRealnameVerify", 194, true);
    }
  }
  
  public static final class ds
    extends c.g
  {
    public ds()
    {
      super("getWechatVerifyTicket", 112, false);
    }
  }
  
  static final class dt
    extends c.g
  {
    dt()
    {
      super("getWePkgAuthResult", -3, false);
    }
  }
  
  public static final class du
    extends c.g
  {
    public du()
    {
      super("add_contact", 10000, false);
    }
  }
  
  public static final class dv
    extends c.g
  {
    public dv()
    {
      super("getWXDeviceInfos", 119, true);
    }
  }
  
  public static final class dw
    extends c.g
  {
    public dw()
    {
      super("getWXDeviceTicket", 125, true);
    }
  }
  
  public static final class dx
    extends c.g
  {
    public dx()
    {
      super("", 10000, false);
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
  
  static final class ea
    extends c.g
  {
    ea()
    {
      super("handleMPPageAction", 345, false);
    }
  }
  
  static final class eb
    extends c.g
  {
    eb()
    {
      super("handleVideoAction", 371, false);
    }
  }
  
  static final class ec
    extends c.g
  {
    ec()
    {
      super("handleWCPayWalletBuffer", 294, false);
    }
  }
  
  public static final class ed
    extends c.g
  {
    public ed()
    {
      super("hideAllNonBaseMenuItem", 93, false);
    }
  }
  
  public static final class ee
    extends c.g
  {
    public ee()
    {
      super("hideMenuItems", 85, false);
    }
  }
  
  public static final class ef
    extends c.g
  {
    public ef()
    {
      super("hideNavigationBarLoading", 198, false);
    }
  }
  
  public static final class eg
    extends c.g
  {
    public eg()
    {
      super("", 10000, false);
    }
  }
  
  public static final class eh
    extends c.g
  {
    public eh()
    {
      super("", 14, false);
    }
  }
  
  public static final class ei
    extends c.g
  {
    public ei()
    {
      super("hideSearchLoading", 10000, false);
    }
  }
  
  public static final class ej
    extends c.g
  {
    public ej()
    {
      super("idCardRealnameVerify", 235, true);
    }
  }
  
  public static final class ek
    extends c.g
  {
    public ek()
    {
      super("", 1, true);
    }
  }
  
  public static final class el
    extends c.g
  {
    public el()
    {
      super("", 10000, false);
    }
  }
  
  public static final class em
    extends c.g
  {
    public em()
    {
      super("", 10000, false);
    }
  }
  
  public static final class en
    extends c.g
  {
    public en()
    {
      super("install_download_task", 41, false);
    }
  }
  
  public static final class eo
    extends c.g
  {
    eo()
    {
      super("internelWxFaceVerify", 325, true);
    }
  }
  
  static final class ep
    extends c.g
  {
    ep()
    {
      super("invokeMiniProgramAPI", 295, false);
    }
  }
  
  static final class eq
    extends c.g
  {
    eq()
    {
      super("jumpDownloaderWidget", 339, true);
    }
  }
  
  public static final class er
    extends c.g
  {
    public er()
    {
      super("", 26, false);
    }
  }
  
  public static final class es
    extends c.g
  {
    public es()
    {
      super("jump_to_biz_profile", 61, true);
    }
  }
  
  public static final class et
    extends c.g
  {
    public et()
    {
      super("jump_wcmall", 51, true);
    }
  }
  
  public static final class eu
    extends c.g
  {
    public eu()
    {
      super("jumpToWXWallet", 147, true);
    }
  }
  
  public static final class ev
    extends c.g
  {
    public ev()
    {
      super("kvReport", 170, false);
    }
  }
  
  public static final class ew
    extends c.g
  {
    public ew()
    {
      super("launch_3rdApp", 52, true);
    }
  }
  
  public static final class ex
    extends c.g
  {
    public ex()
    {
      super("", 27, false);
    }
  }
  
  static final class ey
    extends c.g
  {
    ey()
    {
      super("launchApplication", 260, true);
    }
  }
  
  static final class ez
    extends c.g
  {
    ez()
    {
      super("launchGameVideoEditor", 350, true);
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
  
  static final class fa
    extends c.g
  {
    fa()
    {
      super("launchMiniProgram", 277, true);
    }
  }
  
  public static final class fb
    extends c.g
  {
    public fb()
    {
      super("getWebPayCheckoutCounterRequst", 161, true);
    }
  }
  
  public static final class fc
    extends c.g
  {
    public fc()
    {
      super("", 0, false);
    }
  }
  
  static final class fd
    extends c.g
  {
    fd()
    {
      super("login", 231, true);
    }
  }
  
  static final class fe
    extends c.g
  {
    fe()
    {
      super("makePhoneCall", 356, true);
    }
  }
  
  public static final class ff
    extends c.g
  {
    public ff()
    {
      super("playMusic", 69, false);
    }
  }
  
  public static final class fg
    extends c.g
  {
    public fg()
    {
      super("", 10000, false);
    }
  }
  
  public static final class fh
    extends c.g
  {
    public fh()
    {
      super("timeline_check_in", 64, false);
    }
  }
  
  public static final class fi
    extends c.g
  {
    public fi()
    {
      super("open_location", 63, true);
    }
  }
  
  public static final class fj
    extends c.g
  {
    public fj()
    {
      super("open_timeline_checkin_list", 62, false);
    }
  }
  
  public static final class fk
    extends c.g
  {
    public fk()
    {
      super("nfcBatchTransceive", 142, false);
    }
  }
  
  public static final class fl
    extends c.g
  {
    public fl()
    {
      super("nfcCheckState", 155, true);
    }
  }
  
  public static final class fm
    extends c.g
  {
    public fm()
    {
      super("nfcConnect", 140, false);
    }
  }
  
  public static final class fn
    extends c.g
  {
    public fn()
    {
      super("nfcGetId", 143, false);
    }
  }
  
  public static final class fo
    extends c.g
  {
    public fo()
    {
      super("nfcGetInfo", 148, false);
    }
  }
  
  public static final class fp
    extends c.g
  {
    public fp()
    {
      super("nfcIsConnect", 139, true);
    }
  }
  
  public static final class fq
    extends c.g
  {
    public fq()
    {
      super("nfcTransceive", 141, false);
    }
  }
  
  static final class fr
    extends c.g
  {
    fr()
    {
      super("notifyPageInfo", -2, false);
    }
  }
  
  static final class ft
    extends c.g
  {
    ft()
    {
      super("openWCPayCardList", 310, true);
    }
  }
  
  static final class fu
    extends c.g
  {
    fu()
    {
      super("openBizChat", 296, true);
    }
  }
  
  static final class fv
    extends c.g
  {
    fv()
    {
      super("openADCanvas", 283, true);
    }
  }
  
  static final class fw
    extends c.g
  {
    fw()
    {
      super("openCustomWebview", 256, false);
    }
  }
  
  public static final class fx
    extends c.g
  {
    public fx()
    {
      super("openDesignerEmojiView", 185, true);
    }
  }
  
  public static final class fy
    extends c.g
  {
    public fy()
    {
      super("openDesignerEmojiViewLocal", 20000, false);
    }
  }
  
  public static final class fz
    extends c.g
  {
    public fz()
    {
      super("openDesignerProfile", 193, true);
    }
  }
  
  public static final class ga
    extends c.g
  {
    public ga()
    {
      super("openDesignerProfileLocal", 20000, false);
    }
  }
  
  static final class gb
    extends c.g
  {
    gb()
    {
      super("openECard", 268, true);
    }
  }
  
  public static final class gc
    extends c.g
  {
    public gc()
    {
      super("openEmoticonTopicList", 212, true);
    }
  }
  
  public static final class gd
    extends c.g
  {
    public gd()
    {
      super("openEnterpriseChat", 165, false);
    }
  }
  
  public static final class ge
    extends c.g
  {
    public ge()
    {
      super("openEnterpriseContact", 183, true);
    }
  }
  
  public static final class gf
    extends c.g
  {
    public gf()
    {
      super("", 10000, false);
    }
  }
  
  public static final class gg
    extends c.g
  {
    public gg()
    {
      super("", 10000, false);
    }
  }
  
  public static final class gh
    extends c.g
  {
    public gh()
    {
      super("openGameCenter", 175, true);
    }
  }
  
  public static final class gi
    extends c.g
  {
    public gi()
    {
      super("openGameDetail", 131, true);
    }
  }
  
  public static final class gj
    extends c.g
  {
    public gj()
    {
      super("openGameRegion", 242, true);
    }
  }
  
  static final class gk
    extends c.g
  {
    gk()
    {
      super("openGameUrlWithExtraWebView", 297, false);
    }
  }
  
  static final class gl
    extends c.g
  {
    gl()
    {
      super("openGameWebView", 287, false);
    }
  }
  
  public static final class gm
    extends c.g
  {
    public gm()
    {
      super("openLuckyMoneyDetailView", 245, false);
    }
  }
  
  static final class gn
    extends c.g
  {
    gn()
    {
      super("openLuckyMoneyHistory", 258, true);
    }
  }
  
  public static final class go
    extends c.g
  {
    public go()
    {
      super("openMapNavigateMenu", 184, true);
    }
  }
  
  public static final class gp
    extends c.g
  {
    public gp()
    {
      super("openMyDeviceProfile", 145, false);
    }
  }
  
  public static final class gq
    extends c.g
  {
    public gq()
    {
      super("openNewPage", 20000, false);
    }
  }
  
  static final class gr
    extends c.g
  {
    gr()
    {
      super("openOfflinePayView", 305, true);
    }
  }
  
  public static final class gs
    extends c.g
  {
    public gs()
    {
      super("open_product_view", 59, true);
    }
  }
  
  public static final class gt
    extends c.g
  {
    public gt()
    {
      super("open_product_view", 60, true);
    }
  }
  
  static final class gu
    extends c.g
  {
    gu()
    {
      super("openSearchCanvas", 283, true);
    }
  }
  
  static final class gv
    extends c.g
  {
    gv()
    {
      super("openSearchWAWidgetLogView", 10000, true);
    }
  }
  
  static final class gw
    extends c.g
  {
    gw()
    {
      super("openSearchWebView", 10000, true);
    }
  }
  
  public static final class gx
    extends c.g
  {
    public gx()
    {
      super("openSecurityView", 229, false);
    }
  }
  
  static final class gy
    extends c.g
  {
    gy()
    {
      super("openSelectPayment", 359, true);
    }
  }
  
  public static final class gz
    extends c.g
  {
    public gz()
    {
      super("specific_view", 48, true);
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
  
  public static final class ha
    extends c.g
  {
    public ha()
    {
      super("open_url_by_ext_browser", 55, false);
    }
  }
  
  public static final class hb
    extends c.g
  {
    public hb()
    {
      super("openUrlWithExtraWebview", 173, false);
    }
  }
  
  public static final class hc
    extends c.g
  {
    public hc()
    {
      super("open_wcpay_specific_view", 76, true);
    }
  }
  
  static final class he
    extends c.g
  {
    he()
    {
      super("openWeApp", 250, false);
    }
  }
  
  public static final class hf
    extends c.g
  {
    public hf()
    {
      super("", 10000, false);
    }
  }
  
  public static final class hg
    extends c.g
  {
    public hg()
    {
      super("get_wcpay_create_credit_card_request", 65, true);
    }
  }
  
  public static final class hh
    extends c.g
  {
    public hh()
    {
      super("openWXDeviceLib", 117, false);
    }
  }
  
  static final class hi
    extends c.g
  {
    hi()
    {
      super("openWXSearchPage", 309, true);
    }
  }
  
  static final class hj
    extends c.g
  {
    hj()
    {
      super("operateBackgroundAudio", 261, false);
    }
  }
  
  public static final class hk
    extends c.g
  {
    public hk()
    {
      super("operateGameCenterMsg", 174, false);
    }
  }
  
  public static final class hl
    extends c.g
  {
    public hl()
    {
      super("", 10000, false);
    }
  }
  
  static final class hm
    extends c.g
  {
    hm()
    {
      super("", -2, false);
    }
  }
  
  static final class hn
    extends c.g
  {
    hn()
    {
      super("", -2, false);
    }
  }
  
  static final class ho
    extends c.g
  {
    ho()
    {
      super("", -2, false);
    }
  }
  
  public static final class hp
    extends c.g
  {
    public hp()
    {
      super("cancel_download_task", 239, false);
    }
  }
  
  public static final class hq
    extends c.g
  {
    public hq()
    {
      super("pauseVoice", 100, false);
    }
  }
  
  static final class hr
    extends c.g
  {
    hr()
    {
      super("phoneBindCardVerifySms", 370, false);
    }
  }
  
  public static final class hs
    extends c.g
  {
    public hs()
    {
      super("playVoice", 99, false);
    }
  }
  
  static final class hu
    extends c.g
  {
    hu()
    {
      super("preloadMiniProgramEnv", 302, false);
    }
  }
  
  public static final class hv
    extends c.g
  {
    public hv()
    {
      super("preloadSearchWeapp", 10000, false);
    }
  }
  
  static final class hw
    extends c.g
  {
    hw()
    {
      super("previewVideo", 252, true);
    }
  }
  
  public static final class hx
    extends c.g
  {
    public hx()
    {
      super("pre_verify_jsapi", -3, false);
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
      super("profile", 2, false);
    }
  }
  
  static final class ib
    extends c.g
  {
    ib()
    {
      super("publishHaowanEdition", 351, false);
    }
  }
  
  static final class ic
    extends c.g
  {
    ic()
    {
      super("qqMailLoginResult", 357, false);
    }
  }
  
  public static final class id
    extends c.g
  {
    public id()
    {
      super("query_download_task", 40, false);
    }
  }
  
  static final class ie
    extends c.g
  {
    ie()
    {
      super("queryHaowanPublish", 352, false);
    }
  }
  
  public static final class if
    extends c.g
  {
    public if()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ig
    extends c.g
  {
    public ig()
    {
      super("quicklyAddBrandContact", 166, true);
    }
  }
  
  public static final class ih
    extends c.g
  {
    public ih()
    {
      super("realtimeReport", 171, false);
    }
  }
  
  static final class ii
    extends c.g
  {
    ii()
    {
      super("recordVideo", 251, true);
    }
  }
  
  public static final class ij
    extends c.g
  {
    public ij()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ik
    extends c.g
  {
    public ik()
    {
      super("", 10000, false);
    }
  }
  
  public static final class il
    extends c.g
  {
    public il()
    {
      super("", 10000, false);
    }
  }
  
  public static final class im
    extends c.g
  {
    public im()
    {
      super("reportActionInfo", 234, false);
    }
  }
  
  static final class in
    extends c.g
  {
    in()
    {
      super("reportGamePageTime", 301, false);
    }
  }
  
  static final class io
    extends c.g
  {
    io()
    {
      super("reportGameWeb", 332, false);
    }
  }
  
  public static final class ip
    extends c.g
  {
    public ip()
    {
      super("reportIDKey", 163, false);
    }
  }
  
  static final class iq
    extends c.g
  {
    iq()
    {
      super("reportMiniProgramPageData", 284, false);
    }
  }
  
  public static final class ir
    extends c.g
  {
    public ir()
    {
      super("", 10000, false);
    }
  }
  
  public static final class is
    extends c.g
  {
    public is()
    {
      super("", 10000, false);
    }
  }
  
  static final class it
    extends c.g
  {
    it()
    {
      super("request", 331, false);
    }
  }
  
  static final class iu
    extends c.g
  {
    iu()
    {
      super("requestEntrustAuthorization", 360, true);
    }
  }
  
  static final class iv
    extends c.g
  {
    iv()
    {
      super("requestJointPayment", 358, true);
    }
  }
  
  static final class iw
    extends c.g
  {
    iw()
    {
      super("requestWxFaceRegisterInternal", 272, true);
    }
  }
  
  static final class ix
    extends c.g
  {
    ix()
    {
      super("requestWxFaceVerifyInternal", 273, true);
    }
  }
  
  static final class iy
    extends c.g
  {
    iy()
    {
      super("requestWxVoicePrintVerifyInternal", 292, true);
    }
  }
  
  public static final class iz
    extends c.g
  {
    public iz()
    {
      super("resendRemittanceMsg", 246, true);
    }
  }
  
  public static final class ja
    extends c.g
  {
    public ja()
    {
      super("resume_download_task", 240, true);
    }
  }
  
  public static final class jb
    extends c.g
  {
    public jb()
    {
      super("scanLicence", 203, false);
    }
  }
  
  public static final class jc
    extends c.g
  {
    public jc()
    {
      super("scanQRCode", 7, true);
    }
  }
  
  public static final class jd
    extends c.g
  {
    public jd()
    {
      super("", 10000, false);
    }
  }
  
  public static final class je
    extends c.g
  {
    public je()
    {
      super("", 329, false);
    }
  }
  
  static final class jf
    extends c.g
  {
    jf()
    {
      super("selectContact", 10000, true);
    }
  }
  
  public static final class jg
    extends c.g
  {
    public jg()
    {
      super("selectEnterpriseContact", 286, true);
    }
  }
  
  public static final class jh
    extends c.g
  {
    public jh()
    {
      super("selectPedometerSource", 146, true);
    }
  }
  
  public static final class ji
    extends c.g
  {
    public ji()
    {
      super("selectSingleContact", 167, true);
    }
  }
  
  public static final class jj
    extends c.g
  {
    public jj()
    {
      super("sendAppMessageToSpecifiedContact", 168, true);
    }
  }
  
  public static final class jk
    extends c.g
  {
    public jk()
    {
      super("send_app_msg", 6, true);
    }
  }
  
  public static final class jm
    extends c.g
  {
    public jm()
    {
      super("sendDataToWXDevice", 120, true);
    }
  }
  
  public static final class jn
    extends c.g
  {
    public jn()
    {
      super("sendEnterpriseChat", 222, true);
    }
  }
  
  static final class jo
    extends c.g
  {
    jo()
    {
      super("menuitem:gameSendDesktop", 255, false);
    }
  }
  
  public static final class jp
    extends c.g
  {
    public jp()
    {
      super("send_email", 35, false);
    }
  }
  
  public static final class jq
    extends c.g
  {
    public jq()
    {
      super("send_service_app_msg", 67, true);
    }
  }
  
  static final class jr
    extends c.g
  {
    jr()
    {
      super("sendSingleAppMessage", 316, true);
    }
  }
  
  static final class js
    extends c.g
  {
    js()
    {
      super("serviceClick", 304, false);
    }
  }
  
  static final class jt
    extends c.g
  {
    jt()
    {
      super("setWCPayPassword", 289, true);
    }
  }
  
  static final class ju
    extends c.g
  {
    ju()
    {
      super("setBackgroundAudioState", 262, false);
    }
  }
  
  public static final class jv
    extends c.g
  {
    public jv()
    {
      super("setBounceBackground", 218, false);
    }
  }
  
  public static final class jw
    extends c.g
  {
    public jw()
    {
      super("setCloseWindowConfirmDialogInfo", 77, false);
    }
  }
  
  static final class jx
    extends c.g
  {
    jx()
    {
      super("setGameData", 298, false);
    }
  }
  
  public static final class jy
    extends c.g
  {
    public jy()
    {
      super("", -2, false);
    }
  }
  
  public static final class jz
    extends c.g
  {
    public jz()
    {
      super("setGameDebugConfig", 1111111, false);
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
      super("setLocalData", 180, false);
    }
  }
  
  public static final class kb
    extends c.g
  {
    public kb()
    {
      super("setNavigationBarButtons", 195, false);
    }
  }
  
  public static final class kc
    extends c.g
  {
    public kc()
    {
      super("setNavigationBarColor", 182, false);
    }
  }
  
  public static final class kd
    extends c.g
  {
    public kd()
    {
      super("setPageOwner", 114, false);
    }
  }
  
  public static final class ke
    extends c.g
  {
    public ke()
    {
      super("setPageTitle", 113, false);
    }
  }
  
  static final class kf
    extends c.g
  {
    kf()
    {
      super("setScreenOrientation", 270, false);
    }
  }
  
  public static final class kg
    extends c.g
  {
    public kg()
    {
      super("", 10000, false);
    }
  }
  
  public static final class kh
    extends c.g
  {
    public kh()
    {
      super("setSendDataDirection", 127, false);
    }
  }
  
  public static final class ki
    extends c.g
  {
    public ki()
    {
      super("", 10000, false);
    }
  }
  
  public static final class kj
    extends c.g
  {
    public kj()
    {
      super("setStatusBarStyle", 206, false);
    }
  }
  
  static final class kk
    extends c.g
  {
    kk()
    {
      super("shareEmoticon", 275, true);
    }
  }
  
  public static final class kl
    extends c.g
  {
    public kl()
    {
      super("shareQQ", 90, true);
    }
  }
  
  public static final class km
    extends c.g
  {
    public km()
    {
      super("shareQZone", 132, true);
    }
  }
  
  public static final class kn
    extends c.g
  {
    public kn()
    {
      super("shareWeiboApp", 107, false);
    }
  }
  
  public static final class ko
    extends c.g
  {
    public ko()
    {
      super("showAllNonBaseMenuItem", 92, false);
    }
  }
  
  public static final class kp
    extends c.g
  {
    public kp()
    {
      super("showDatePickerView", 248, true);
    }
  }
  
  public static final class kq
    extends c.g
  {
    public kq()
    {
      super("showKeyboard", 187, false);
    }
  }
  
  public static final class kr
    extends c.g
  {
    public kr()
    {
      super("showMenuItems", 86, false);
    }
  }
  
  public static final class ks
    extends c.g
  {
    public ks()
    {
      super("showNavigationBarLoading", 197, false);
    }
  }
  
  public static final class kt
    extends c.g
  {
    public kt()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ku
    extends c.g
  {
    public ku()
    {
      super("", 14, false);
    }
  }
  
  public static final class kv
    extends c.g
  {
    public kv()
    {
      super("showSearchActionSheet", 10000, false);
    }
  }
  
  public static final class kw
    extends c.g
  {
    public kw()
    {
      super("showSearchLoading", 10000, false);
    }
  }
  
  static final class kx
    extends c.g
  {
    kx()
    {
      super("showSearchOfBizHistory", 266, false);
    }
  }
  
  public static final class ky
    extends c.g
  {
    public ky()
    {
      super("showSearchToast", 10000, false);
    }
  }
  
  public static final class kz
    extends c.g
  {
    public kz()
    {
      super("showSmileyPanel", 238, false);
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
      super("soter_biometric_authentication", 214, true);
    }
  }
  
  public static final class lb
    extends c.g
  {
    public lb()
    {
      super("getSupportSoter", 213, true);
    }
  }
  
  public static final class lc
    extends c.g
  {
    public lc()
    {
      super("startMonitoringBeacons", 151, false);
    }
  }
  
  public static final class ld
    extends c.g
  {
    public ld()
    {
      super("startPullDownRefresh", 204, false);
    }
  }
  
  public static final class le
    extends c.g
  {
    public le()
    {
      super("startRecord", 96, false);
    }
  }
  
  public static final class lf
    extends c.g
  {
    public lf()
    {
      super("startScanWXDevice", 121, true);
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
  
  public static final class lh
    extends c.g
  {
    public lh()
    {
      super("startTempSession", 128, true);
    }
  }
  
  public static final class li
    extends c.g
  {
    public li()
    {
      super("startVoipCall", 230, false);
    }
  }
  
  public static final class lj
    extends c.g
  {
    public lj()
    {
      super("stopMonitoringBeacons", 152, false);
    }
  }
  
  public static final class lk
    extends c.g
  {
    public lk()
    {
      super("stopPullDownRefresh", 200, false);
    }
  }
  
  public static final class ll
    extends c.g
  {
    public ll()
    {
      super("stopRecord", 98, false);
    }
  }
  
  public static final class lm
    extends c.g
  {
    public lm()
    {
      super("stopScanWXDevice", 122, true);
    }
  }
  
  public static final class ln
    extends c.g
  {
    public ln()
    {
      super("stopVoice", 101, false);
    }
  }
  
  public static final class lo
    extends c.g
  {
    public lo()
    {
      super("playStreamingVideo", 209, false);
    }
  }
  
  public static final class lp
    extends c.g
  {
    public lp()
    {
      super("selectWalletCurrency", 201, true);
    }
  }
  
  static final class lq
    extends c.g
  {
    lq()
    {
      super("tapSearchWAWidgetView", 10000, false);
    }
  }
  
  public static final class lr
    extends c.g
  {
    public lr()
    {
      super("share_timeline", 4, true);
    }
  }
  
  public static final class ls
    extends c.g
  {
    public ls()
    {
      super("translateVoice", 97, true);
    }
  }
  
  public static final class lt
    extends c.g
  {
    public lt()
    {
      super("unbindBankCard", 216, true);
    }
  }
  
  static final class lu
    extends c.g
  {
    lu()
    {
      super("updatePageAuth", -2, false);
    }
  }
  
  public static final class lv
    extends c.g
  {
    public lv()
    {
      super("", 10000, false);
    }
  }
  
  static final class lw
    extends c.g
  {
    lw()
    {
      super("updateAppMessageShareData", 326, false);
    }
  }
  
  public static final class lx
    extends c.g
  {
    public lx()
    {
      super("", 10000, false);
    }
  }
  
  static final class ly
    extends c.g
  {
    ly()
    {
      super("updateTimelineShareData", 327, false);
    }
  }
  
  public static final class lz
    extends c.g
  {
    public lz()
    {
      super("", 10000, false);
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
      super("updateWASearchTemplate", 10000, false);
    }
  }
  
  static final class mb
    extends c.g
  {
    mb()
    {
      super("uploadEncryptMediaFile", 253, false);
    }
  }
  
  public static final class mc
    extends c.g
  {
    public mc()
    {
      super("uploadImage", 105, true);
    }
  }
  
  public static final class md
    extends c.g
  {
    public md()
    {
      super("uploadMediaFile", 237, true);
    }
  }
  
  public static final class me
    extends c.g
  {
    public me()
    {
      super("uploadVideo", 192, true);
    }
  }
  
  public static final class mf
    extends c.g
  {
    public mf()
    {
      super("uploadVoice", 102, true);
    }
  }
  
  public static final class mg
    extends c.g
  {
    public mg()
    {
      super("uxSearchOpLog", 10000, false);
    }
  }
  
  public static final class mh
    extends c.g
  {
    public mh()
    {
      super("verifyWCPayPassword", 115, true);
    }
  }
  
  static final class mi
    extends c.g
  {
    mi()
    {
      super("", 10000, false);
    }
  }
  
  public static final class mj
    extends c.g
  {
    public mj()
    {
      super("", 355, true);
    }
  }
  
  static final class mk
    extends c.g
  {
    mk()
    {
      super("wcPrivacyPolicyResult", 315, false);
    }
  }
  
  public static final class ml
    extends c.g
  {
    public ml()
    {
      super("cache", 150, false);
    }
  }
  
  public static final class mm
    extends c.g
  {
    public mm()
    {
      super("videoProxyInit", 156, false);
    }
  }
  
  public static final class mn
    extends c.g
  {
    public mn()
    {
      super("videoProxySetPlayerState", 159, false);
    }
  }
  
  public static final class mo
    extends c.g
  {
    public mo()
    {
      super("videoProxySetPlayerState", 160, false);
    }
  }
  
  public static final class mp
    extends c.g
  {
    public mp()
    {
      super("videoProxyStartPlay", 157, false);
    }
  }
  
  public static final class mq
    extends c.g
  {
    public mq()
    {
      super("videoProxyStopPlay", 158, false);
    }
  }
  
  public static final class mr
    extends c.g
  {
    public mr()
    {
      super("publicCache", 149, false);
    }
  }
  
  public static final class ms
    extends c.g
  {
    public ms()
    {
      super("videoProxyPreload", 172, false);
    }
  }
  
  public static final class mt
    extends c.g
  {
    public mt()
    {
      super("share_weibo", 3, true);
    }
  }
  
  public static final class mu
    extends c.g
  {
    public mu()
    {
      super("", 10000, false);
    }
  }
  
  public static final class mv
    extends c.g
  {
    public mv()
    {
      super("WNNativeAsyncCallback", 10006, false);
    }
  }
  
  public static final class mw
    extends c.g
  {
    public mw()
    {
      super("WNNativeCallbackInitData", 10006, false);
    }
  }
  
  public static final class mx
    extends c.g
  {
    public mx()
    {
      super("WNNativeCallbackOnCaretChange", 10006, false);
    }
  }
  
  public static final class my
    extends c.g
  {
    public my()
    {
      super("WNNativeCallbackOnClick", 10006, false);
    }
  }
  
  public static final class mz
    extends c.g
  {
    public mz()
    {
      super("WNNativeCallbackOnLongClick", 10006, false);
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
  
  public static final class na
    extends c.g
  {
    public na()
    {
      super("write_comm_data", 53, false);
    }
  }
  
  static final class nb
    extends c.g
  {
    nb()
    {
      super("calRqt", 319, false);
    }
  }
  
  static final class nc
    extends c.g
  {
    nc()
    {
      super("getCCData", 312, false);
    }
  }
  
  static final class nd
    extends c.g
  {
    nd()
    {
      super("openRealnameAuth", 314, true);
    }
  }
  
  public static final class ne
    extends c.g
  {
    public ne()
    {
      super("WNNativeCallbackOnBecomeEditing", 10006, false);
    }
  }
  
  public static final class nf
    extends c.g
  {
    public nf()
    {
      super("WNNativeCallbackOnBecomeEdited", 10006, false);
    }
  }
  
  public static final class ng
    extends c.g
  {
    public ng()
    {
      super("", 317, true);
    }
  }
  
  public static final class nh
    extends c.g
  {
    public nh()
    {
      super("", 129, false);
    }
  }
  
  public static final class ni
    extends c.g
  {
    public ni()
    {
      super("", 89, false);
    }
  }
  
  public static final class nj
    extends c.g
  {
    public nj()
    {
      super("", 94, false);
    }
  }
  
  public static final class nk
    extends c.g
  {
    public nk()
    {
      super("", 134, false);
    }
  }
  
  public static final class nl
    extends c.g
  {
    public nl()
    {
      super("", 88, false);
    }
  }
  
  public static final class nm
    extends c.g
  {
    public nm()
    {
      super("", 109, false);
    }
  }
  
  public static final class nn
    extends c.g
  {
    public nn()
    {
      super("", 320, true);
    }
  }
  
  public static final class no
    extends c.g
  {
    public no()
    {
      super("uploadIdCardSuccess", 233, false);
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
  
  static final class q
    extends c.g
  {
    q()
    {
      super("joinGroup", 377, false);
    }
  }
  
  static final class r
    extends c.g
  {
    r()
    {
      super("authorize", 232, true);
    }
  }
  
  public static final class s
    extends c.g
  {
    public s()
    {
      super("batch_add_card", 82, true);
    }
  }
  
  static final class u
    extends c.g
  {
    u()
    {
      super("batchUpdateWepkg", 334, false);
    }
  }
  
  public static final class v
    extends c.g
  {
    public v()
    {
      super("batchViewCard", 111, true);
    }
  }
  
  static final class w
    extends c.g
  {
    w()
    {
      super("bindEmail", 306, true);
    }
  }
  
  public static final class x
    extends c.g
  {
    public x()
    {
      super("cancel_download_task", 39, false);
    }
  }
  
  static final class y
    extends c.g
  {
    y()
    {
      super("cancelHaowanPublish", 353, false);
    }
  }
  
  public static final class z
    extends c.g
  {
    public z()
    {
      super("cancelSearchActionSheet", 10000, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c
 * JD-Core Version:    0.7.0.1
 */