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
  private static Map<String, c.g> FFv;
  public static final String[] FFw;
  
  static
  {
    AppMethodBeat.i(152436);
    FFv = null;
    FFw = (String[])new c.1().toArray(new String[0]);
    AppMethodBeat.o(152436);
  }
  
  public static Bundle aPx(String paramString)
  {
    AppMethodBeat.i(152434);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("handle", true);
    localBundle.putString("handle_result", paramString);
    AppMethodBeat.o(152434);
    return localBundle;
  }
  
  public static c.g aPy(String paramString)
  {
    AppMethodBeat.i(152435);
    if ((FFv == null) || (FFv.size() <= 0))
    {
      Object localObject = new HashMap(128);
      FFv = (Map)localObject;
      ((Map)localObject).put("log", new ez());
      FFv.put("imagePreview", new eh());
      FFv.put("profile", new hw());
      FFv.put("shareWeibo", new mp());
      FFv.put("shareTimeline", new ln());
      FFv.put("adDataReport", new o());
      FFv.put("streamingVideoPlay", new lk());
      FFv.put("addContact", new h());
      FFv.put("getWidgetCaptureImgUrl", new ds());
      FFv.put("sendAppMessage", new jg());
      FFv.put("scanQRCode", new iy());
      FFv.put("hideOptionMenu", new ee());
      FFv.put("showOptionMenu", new kq());
      FFv.put("getNetworkType", new ct());
      FFv.put("closeWindow", new aq());
      FFv.put("getInstallState", new co());
      FFv.put("setFontSizeCallback", new ju());
      FFv.put("jumpToInstallUrl", new eo());
      FFv.put("launchApp", new eu());
      FFv.put("getBrandWCPayRequest", new cc());
      FFv.put("secureTunnel", new ja());
      FFv.put("wcpaySecurityCrosscutBack", new mf());
      FFv.put("editAddress", new bl());
      FFv.put("getHeadingAndPitch", new cl());
      FFv.put("sendEmail", new jl());
      FFv.put("addDownloadTask", new k());
      FFv.put("cancelDownloadTask", new x());
      FFv.put("pauseDownloadTask", new hl());
      FFv.put("resumeDownloadTask", new iw());
      FFv.put("queryDownloadTask", new hz());
      FFv.put("installDownloadTask", new ek());
      FFv.put("getLatestAddress", new cy());
      FFv.put("openSpecificView", new gv());
      FFv.put("jumpWCMall", new eq());
      FFv.put("launch3rdApp", new et());
      FFv.put("writeCommData", new mw());
      FFv.put("openUrlByExtBrowser", new gw());
      FFv.put("geoLocation", new by());
      FFv.put("getBrandWCPayBindCardRequest", new cb());
      FFv.put("openProductView", new go());
      FFv.put("openProductViewWithPid", new gp());
      FFv.put("jumpToBizProfile", new ep());
      FFv.put("openTimelineCheckInList", new ff());
      FFv.put("openLocation", new fe());
      FFv.put("timelineCheckIn", new fd());
      FFv.put("getBrandWCPayCreateCreditCardRequest", new hc());
      FFv.put("chooseCard", new ad());
      FFv.put("chooseInvoice", new ah());
      FFv.put("sendServiceAppMessage", new jm());
      FFv.put("musicPlay", new fc());
      FFv.put("mmsf0001", new cg());
      FFv.put("connectToWiFi", new aw());
      FFv.put("getTransferMoneyRequest", new do());
      FFv.put("openWCPaySpecificView", new gy());
      FFv.put("setCloseWindowConfirmDialogInfo", new js());
      FFv.put("batchAddCard", new s());
      FFv.put("preVerifyJSAPI", new ht());
      FFv.put("startRecord", new la());
      FFv.put("stopRecord", new lh());
      FFv.put("playVoice", new ho());
      FFv.put("pauseVoice", new hm());
      FFv.put("stopVoice", new lj());
      FFv.put("uploadVoice", new mb());
      FFv.put("downloadVoice", new bi());
      FFv.put("chooseImage", new ag());
      FFv.put("uploadImage", new ly());
      FFv.put("downloadImage", new bh());
      FFv.put("uploadMediaFile", new lz());
      FFv.put("hideMenuItems", new ec());
      FFv.put("showMenuItems", new ko());
      FFv.put("hideAllNonBaseMenuItem", new eb());
      FFv.put("showAllNonBaseMenuItem", new kl());
      FFv.put("checkJsApi", new ac());
      FFv.put("translateVoice", new lo());
      FFv.put("shareQQ", new ki());
      FFv.put("shareWeiboApp", new kk());
      FFv.put("shareQZone", new kj());
      FFv.put("connectToFreeWifi", new av());
      FFv.put("getSendC2CMessageRequest", new dl());
      FFv.put("batchViewCard", new v());
      FFv.put("configWXDeviceWiFi", new at());
      FFv.put("getCurrentSSID", new ce());
      FFv.put("setPageOwner", new ka());
      FFv.put("getWechatVerifyTicket", new dq());
      FFv.put("openWXDeviceLib", new hd());
      FFv.put("startScanWXDevice", new lb());
      FFv.put("stopScanWXDevice", new li());
      FFv.put("connectWXDevice", new ax());
      FFv.put("disconnectWXDevice", new bg());
      FFv.put("getWXDeviceTicket", new du());
      FFv.put("getWXDeviceInfos", new dt());
      FFv.put("sendDataToWXDevice", new ji());
      FFv.put("closeWXDeviceLib", new as());
      FFv.put("setSendDataDirection", new ke());
      FFv.put("verifyWCPayPassword", new md());
      FFv.put("getPaymentOrderRequest", new cx());
      FFv.put("openGameDetail", new ge());
      FFv.put("openGameCenter", new gd());
      FFv.put("setGameDebugConfig", new jw());
      FFv.put("startTempSession", new ld());
      FFv.put("getH5PrepayRequest", new cm());
      FFv.put("getH5TransactionRequest", new cn());
      FFv.put("menu:share:timeline", new nh());
      FFv.put("menu:share:appmessage", new ne());
      FFv.put("menu:share:qq", new nf());
      FFv.put("menu:share:weiboApp", new ni());
      FFv.put("menu:setfont", new nd());
      FFv.put("menu:share:weibo", new ni());
      FFv.put("menu:share:QZone", new ng());
      FFv.put("getRecevieBizHongBaoRequest", new e());
      FFv.put("insertVideoPlayer", new ej());
      FFv.put("updateVideoPlayer", new lv());
      FFv.put("removeVideoPlayer", new ih());
      FFv.put("operateVideoPlayer", new hh());
      FFv.put("deleteSearchHistory", new bd());
      FFv.put("getSearchHistory", new dh());
      FFv.put("getSearchData", new dd());
      FFv.put("getChatSearchData", new cd());
      FFv.put("getPoiInfo", new ck());
      FFv.put("updateReddotTimeStamps", new lr());
      FFv.put("getTeachSearchData", new dn());
      FFv.put("getSearchGuideData", new dg());
      FFv.put("getSearchAvatarList", new dc());
      FFv.put("getSearchSnsImageList", new dj());
      FFv.put("getSearchImageList", new di());
      FFv.put("getSearchDisplayNameList", new de());
      FFv.put("startSearchItemDetailPage", new lc());
      FFv.put("reportSearchStatistics", new io());
      FFv.put("reportSearchRealTimeStatistics", new in());
      FFv.put("searchDataHasResult", new iz());
      FFv.put("openEmotionPage", new bu());
      FFv.put("getSearchSuggestionData", new dk());
      FFv.put("setSearchInputWord", new kd());
      FFv.put("setSnsObjectXmlDescList", new kf());
      FFv.put("clickSnsMusicPlayButton", new ap());
      FFv.put("openWeAppPage", new hb());
      FFv.put("reportWeAppSearchRealtime", new mq());
      FFv.put("doSearchOperation", new bk());
      FFv.put("insertSearchWAWidgetView", new ei());
      FFv.put("removeSearchWAWidgetView", new ig());
      FFv.put("updateSearchWAWidgetView", new lt());
      FFv.put("showSearchActionSheet", new kr());
      FFv.put("cancelSearchActionSheet", new z());
      FFv.put("showSearchToast", new ku());
      FFv.put("showSearchLoading", new ks());
      FFv.put("hideSearchLoading", new ef());
      FFv.put("updateWASearchTemplate", new lw());
      FFv.put("preloadSearchWeapp", new hr());
      FFv.put("uxSearchOpLog", new mc());
      FFv.put("querySearchWeb", new bw());
      FFv.put("openFinderProfile", new gc());
      FFv.put("openFinderFeed", new gb());
      FFv.put("jumpToWXWallet", new er());
      FFv.put("scanCover", new f());
      FFv.put("reportActionInfo", new ii());
      FFv.put("openMyDeviceProfile", new gl());
      FFv.put("selectPedometerSource", new jd());
      FFv.put("nfcIsConnect", new fl());
      FFv.put("nfcConnect", new fi());
      FFv.put("nfcTransceive", new fm());
      FFv.put("nfcBatchTransceive", new fg());
      FFv.put("nfcGetId", new fj());
      FFv.put("nfcGetInfo", new fk());
      FFv.put("startMonitoringBeacons", new ky());
      FFv.put("stopMonitoringBeacons", new lf());
      FFv.put("nfcCheckState", new fh());
      FFv.put("videoProxyInit", new mi());
      FFv.put("videoProxyStartPlay", new ml());
      FFv.put("videoProxyStopPlay", new mm());
      FFv.put("videoProxySetPlayerState", new mj());
      FFv.put("videoProxySetRemainTime", new mk());
      FFv.put("videoProxyPreload", new mo());
      FFv.put("getWebPayCheckoutCounterRequst", new ey());
      FFv.put("addCustomMenuItems", new i());
      FFv.put("operateGameCenterMsg", new hg());
      FFv.put("openEnterpriseChat", new fz());
      FFv.put("enterEnterpriseChat", new bp());
      FFv.put("openEnterpriseContact", new ga());
      FFv.put("selectEnterpriseContact", new jc());
      FFv.put("getEnterpriseChat", new ci());
      FFv.put("reportIDKey", new il());
      FFv.put("quicklyAddBrandContact", new ic());
      FFv.put("consumedShareCard", new ay());
      FFv.put("cache", new mh());
      FFv.put("publicCache", new mn());
      FFv.put("kvReport", new es());
      FFv.put("realtimeReport", new id());
      FFv.put("openUrlWithExtraWebview", new gx());
      FFv.put("setFreeWifiOwner", new jv());
      FFv.put("selectSingleContact", new je());
      FFv.put("sendAppMessageToSpecifiedContact", new jf());
      FFv.put("setLocalData", new jx());
      FFv.put("getLocalData", new cp());
      FFv.put("clearLocalData", new an());
      FFv.put("showKeyboard", new kn());
      FFv.put("showSmileyPanel", new kv());
      FFv.put("disableBounceScroll", new be());
      FFv.put("clearBounceBackground", new al());
      FFv.put("setNavigationBarButtons", new jy());
      FFv.put("enableFullScreen", new bn());
      FFv.put("showNavigationBarLoading", new kp());
      FFv.put("hideNavigationBarLoading", new ed());
      FFv.put("enablePullDownRefresh", new bo());
      FFv.put("startPullDownRefresh", new kz());
      FFv.put("stopPullDownRefresh", new lg());
      FFv.put("disablePullDownRefresh", new bf());
      FFv.put("setPageTitle", new kb());
      FFv.put("setStatusBarStyle", new kg());
      FFv.put("deleteAccountSuccess", new bc());
      FFv.put("chooseVideo", new ak());
      FFv.put("uploadVideo", new ma());
      FFv.put("openMapNavigateMenu", new gk());
      FFv.put("setNavigationBarColor", new jz());
      FFv.put("getWCPayRealnameVerify", new dp());
      FFv.put("openDesignerEmojiView", new ft());
      FFv.put("openDesignerProfile", new fv());
      FFv.put("openEmoticonTopicList", new fy());
      FFv.put("openDesignerEmojiViewLocal", new fu());
      FFv.put("openDesignerProfileLocal", new fw());
      FFv.put("openEmotionDetailViewLocal", new d());
      FFv.put("openNewPage", new gm());
      FFv.put("getSearchEmotionData", new df());
      FFv.put("openEmotionUrl", new bm());
      FFv.put("WNNativeCallbackOnClick", new mu());
      FFv.put("WNNativeCallbackOnLongClick", new mv());
      FFv.put("WNNativeCallbackOnCaretChange", new mt());
      FFv.put("WNNativeCallbackInitData", new ms());
      FFv.put("WNNativeAsyncCallback", new mr());
      FFv.put("WNNativeCallbackOnBecomeEditing", new na());
      FFv.put("WNNativeCallbackOnBecomeEdited", new nb());
      FFv.put("changePayActivityView", new aa());
      FFv.put("selectWalletCurrency", new ll());
      FFv.put("scanLicence", new ix());
      FFv.put("operateMusicPlayer", new b());
      FFv.put("getMusicPlayerState", new a());
      FFv.put("clearWebviewCache", new ao());
      FFv.put("requireSoterBiometricAuthentication", new kw());
      FFv.put("getSupportSoter", new kx());
      FFv.put("unbindBankCard", new lp());
      FFv.put("setBounceBackground", new jr());
      FFv.put("sendEnterpriseChat", new jj());
      FFv.put("doExposePreparation", new bj());
      FFv.put("getMsgProofItems", new cs());
      FFv.put("openSecurityView", new gt());
      FFv.put("startVoipCall", new le());
      FFv.put("chooseInvoiceTitle", new ai());
      FFv.put("getOpenDeviceId", new cv());
      FFv.put("getRouteUrl", new db());
      FFv.put("idCardRealnameVerify", new eg());
      FFv.put("uploadIdCardSuccess", new nk());
      FFv.put("showDatePickerView", new km());
      FFv.put("openLuckyMoneyDetailView", new gi());
      FFv.put("resendRemittanceMsg", new iv());
      FFv.put("getGameCommInfo", new cj());
      FFv.put("openGameRegion", new gf());
      FFv.put("chooseIdCard", new af());
      FFv.put("getLocalImgData", new c());
      FFv.put("openWeApp", new ha());
      FFv.put("recordVideo", new ie());
      FFv.put("previewVideo", new hs());
      FFv.put("uploadEncryptMediaFile", new lx());
      FFv.put("chooseMedia", new aj());
      FFv.put("requestWxFacePictureVerify", new bq());
      FFv.put("openCustomWebview", new fs());
      FFv.put("forceUpdateWxaAttr", new bt());
      FFv.put("openLuckyMoneyHistory", new gj());
      FFv.put("menuitem:gameSendDesktop", new jk());
      FFv.put("getWePkgAuthResult", new dr());
      FFv.put("getLocalWePkgInfo", new cq());
      FFv.put("openGameWebView", new gh());
      FFv.put("reportGameWeb", new ik());
      FFv.put("launchApplication", new ev());
      FFv.put("showSearchOfBizHistory", new kt());
      FFv.put("login", new fa());
      FFv.put("authorize", new r());
      FFv.put("requestWxFacePictureVerifyUnionVideo", new br());
      FFv.put("checkIsSupportFaceDetect", new ab());
      FFv.put("operateBackgroundAudio", new hf());
      FFv.put("setBackgroundAudioState", new jq());
      FFv.put("getBackgroundAudioState", new ca());
      FFv.put("addDownloadTaskStraight", new l());
      FFv.put("setScreenOrientation", new kc());
      FFv.put("addToEmoticon", new n());
      FFv.put("shareEmoticon", new kh());
      FFv.put("makePhoneCall", new fb());
      FFv.put("openADCanvas", new fr());
      FFv.put("openSearchCanvas", new gq());
      FFv.put("opVoteAdData", new hk());
      FFv.put("opJumpView", new hj());
      FFv.put("opAdH5Func", new hi());
      FFv.put("requestWxFaceRegisterInternal", new is());
      FFv.put("requestWxFaceVerifyInternal", new it());
      FFv.put("launchMiniProgram", new ex());
      FFv.put("reportMiniProgramPageData", new im());
      FFv.put("selectContact", new jb());
      FFv.put("openSearchWAWidgetLogView", new gr());
      FFv.put("reloadSearchWAWidgetData", new if());
      FFv.put("gotoEmoticonPad", new dv());
      FFv.put("querySimilarEmotion", new ib());
      FFv.put("closeWindowAndGoNext", new ar());
      FFv.put("requestWxVoicePrintVerifyInternal", new iu());
      FFv.put("openBizChat", new fq());
      FFv.put("handleWCPayWalletBuffer", new ea());
      FFv.put("tapSearchWAWidgetView", new lm());
      FFv.put("getMatchContactList", new cr());
      FFv.put("openSearchWebView", new gs());
      FFv.put("openWXSearchPage", new he());
      FFv.put("viewTypeChange", new me());
      FFv.put("invokeMiniProgramAPI", new em());
      FFv.put("openGameUrlWithExtraWebView", new gg());
      FFv.put("setGameData", new jt());
      FFv.put("getGameData", new cf());
      FFv.put("clearGameData", new am());
      FFv.put("openECard", new fx());
      FFv.put("reportGamePageTime", new ij());
      FFv.put("setWCPayPassword", new jp());
      FFv.put("openWCPayCardList", new fp());
      FFv.put("bindEmail", new w());
      FFv.put("openOfflinePayView", new gn());
      FFv.put("bindEmail", new w());
      FFv.put("doGoToRecVideoList", new cz());
      FFv.put("jumpWSRecVideoList", new nc());
      FFv.put("openWebSearchOutLinkItem", new nj());
      FFv.put("recordHistory", new bx());
      localObject = fjQ().iterator();
      while (((Iterator)localObject).hasNext())
      {
        c.g localg = (c.g)((Iterator)localObject).next();
        FFv.put(localg.getName(), localg);
      }
      FFv.put("getSystemInfo", new dm());
      FFv.put("serviceClick", new jo());
      FFv.put("openRealnameAuth", new mz());
      FFv.put("sendSingleAppMessage", new jn());
      FFv.put("wcPrivacyPolicyResult", new mg());
      FFv.put("currentMpInfo", new az());
      FFv.put("updateAppMessageShareData", new ls());
      FFv.put("updateTimelineShareData", new lu());
      FFv.put("getCCData", new my());
      FFv.put("calRqt", new mx());
      FFv.put("faceVerifyForPay", new bs());
      FFv.put("request", new ip());
      FFv.put("notifyPageInfo", new fn());
      FFv.put("updatePageAuth", new lq());
      FFv.put("jumpDownloaderWidget", new en());
      FFv.put("batchUpdateWepkg", new u());
      FFv.put("addGameDownloadTask", new m());
      FFv.put("internelWxFaceVerify", new el());
      FFv.put("getDownloadWidgetTaskInfos", new ch());
      FFv.put("chooseHaowanMedia", new ae());
      FFv.put("queryHaowanPublish", new ia());
      FFv.put("publishHaowanEdition", new hx());
      FFv.put("cancelHaowanPublish", new y());
      FFv.put("launchGameVideoEditor", new ew());
      FFv.put("requestJointPayment", new ir());
      FFv.put("openSelectPayment", new gu());
      FFv.put("requestEntrustAuthorization", new iq());
      FFv.put("getOAID", new cu());
      FFv.put("qqMailLoginResult", new hy());
    }
    paramString = (c.g)FFv.get(paramString);
    AppMethodBeat.o(152435);
    return paramString;
  }
  
  private static List<c.g> fjQ()
  {
    AppMethodBeat.i(218908);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new c.bb());
    localLinkedList.add(new c.ba());
    localLinkedList.add(new c.bz());
    localLinkedList.add(new dz());
    localLinkedList.add(new c.dw());
    localLinkedList.add(new hq());
    localLinkedList.add(new c.hp());
    localLinkedList.add(new c.jh());
    localLinkedList.add(new c.dx());
    localLinkedList.add(new dy());
    localLinkedList.add(new c.j());
    localLinkedList.add(new c.hv());
    localLinkedList.add(new c.hu());
    localLinkedList.add(new bv());
    localLinkedList.add(new c.gz());
    localLinkedList.add(new au());
    localLinkedList.add(new cw());
    localLinkedList.add(new c.da());
    localLinkedList.add(new c.t());
    localLinkedList.add(new c.fo());
    localLinkedList.add(new hn());
    localLinkedList.add(new c.p());
    localLinkedList.add(new q());
    AppMethodBeat.o(218908);
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
      super("connectToFreeWifi", 95, false);
    }
  }
  
  public static final class aw
    extends c.g
  {
    public aw()
    {
      super("connecttowifi", 71, false);
    }
  }
  
  public static final class ax
    extends c.g
  {
    public ax()
    {
      super("connectWXDevice", 123, true);
    }
  }
  
  public static final class ay
    extends c.g
  {
    public ay()
    {
      super("consumedShareCard", 177, true);
    }
  }
  
  static final class az
    extends c.g
  {
    public az()
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
  
  public static final class bc
    extends c.g
  {
    public bc()
    {
      super("deleteAccountSuccess", 144, false);
    }
  }
  
  public static final class bd
    extends c.g
  {
    public bd()
    {
      super("", 10000, false);
    }
  }
  
  public static final class be
    extends c.g
  {
    public be()
    {
      super("disableBounceScroll", 188, false);
    }
  }
  
  public static final class bf
    extends c.g
  {
    public bf()
    {
      super("disablePullDownRefresh", 205, false);
    }
  }
  
  public static final class bg
    extends c.g
  {
    public bg()
    {
      super("disconnectWXDevice", 124, true);
    }
  }
  
  public static final class bh
    extends c.g
  {
    public bh()
    {
      super("downloadImage", 106, true);
    }
  }
  
  public static final class bi
    extends c.g
  {
    public bi()
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
  
  public static final class cb
    extends c.g
  {
    public cb()
    {
      super("get_brand_WCPay_bind_card_request", 58, true);
    }
  }
  
  public static final class cc
    extends c.g
  {
    public cc()
    {
      super("get_brand_wcpay_request", 28, true);
    }
  }
  
  public static final class cd
    extends c.g
  {
    public cd()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ce
    extends c.g
  {
    public ce()
    {
      super("getCurrentSSID", 176, true);
    }
  }
  
  static final class cf
    extends c.g
  {
    cf()
    {
      super("getGameData", 299, false);
    }
  }
  
  public static final class cg
    extends c.g
  {
    public cg()
    {
      super("mmsf0001", -2, false);
    }
  }
  
  static final class ch
    extends c.g
  {
    ch()
    {
      super("getDownloadWidgetTaskInfos", 340, false);
    }
  }
  
  public static final class ci
    extends c.g
  {
    public ci()
    {
      super("getEnterpriseChat", 244, false);
    }
  }
  
  public static final class cj
    extends c.g
  {
    public cj()
    {
      super("getGameCommInfo", 241, false);
    }
  }
  
  public static final class ck
    extends c.g
  {
    public ck()
    {
      super("", 10000, false);
    }
  }
  
  public static final class cl
    extends c.g
  {
    public cl()
    {
      super("get_heading_and_pitch", 33, false);
    }
  }
  
  public static final class cm
    extends c.g
  {
    public cm()
    {
      super("getH5PrepayRequest", 137, true);
    }
  }
  
  public static final class cn
    extends c.g
  {
    public cn()
    {
      super("getH5TransactionRequest", 138, true);
    }
  }
  
  public static final class co
    extends c.g
  {
    public co()
    {
      super("get_install_state", 25, false);
    }
  }
  
  public static final class cp
    extends c.g
  {
    public cp()
    {
      super("getLocalData", 179, false);
    }
  }
  
  static final class cq
    extends c.g
  {
    cq()
    {
      super("getLocalWePkgInfo", -2, false);
    }
  }
  
  static final class cr
    extends c.g
  {
    cr()
    {
      super("getMatchContactList", 10000, false);
    }
  }
  
  public static final class cs
    extends c.g
  {
    public cs()
    {
      super("getMsgProofItems", 226, true);
    }
  }
  
  public static final class ct
    extends c.g
  {
    public ct()
    {
      super("network_type", 16, false);
    }
  }
  
  static final class cu
    extends c.g
  {
    cu()
    {
      super("getOAID", 361, false);
    }
  }
  
  public static final class cv
    extends c.g
  {
    public cv()
    {
      super("getOpenDeviceId", 227, false);
    }
  }
  
  static final class cw
    extends c.g
  {
    cw()
    {
      super("getPasteboardContent", 364, false);
    }
  }
  
  public static final class cx
    extends c.g
  {
    public cx()
    {
      super("getPaymentOrderRequest", 116, true);
    }
  }
  
  public static final class cy
    extends c.g
  {
    public cy()
    {
      super("get_recently_used_address", 46, true);
    }
  }
  
  static final class cz
    extends c.g
  {
    cz()
    {
      super("doGoToRecVideoList", 10000, false);
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
  
  public static final class db
    extends c.g
  {
    public db()
    {
      super("getRouteUrl", 235, false);
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
      super("getSearchDisplayNameList", 10000, false);
    }
  }
  
  public static final class df
    extends c.g
  {
    public df()
    {
      super("getSearchEmotionData", 20000, false);
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
      super("", 10000, false);
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
      super("get_send_c2c_message_request", 83, true);
    }
  }
  
  static final class dm
    extends c.g
  {
    dm()
    {
      super("getSystemInfo", 311, false);
    }
  }
  
  public static final class dn
    extends c.g
  {
    public dn()
    {
      super("", 10000, false);
    }
  }
  
  public static final class do
    extends c.g
  {
    public do()
    {
      super("get_transfer_money_request", 74, true);
    }
  }
  
  public static final class dp
    extends c.g
  {
    public dp()
    {
      super("getWCPayRealnameVerify", 194, true);
    }
  }
  
  public static final class dq
    extends c.g
  {
    public dq()
    {
      super("getWechatVerifyTicket", 112, false);
    }
  }
  
  static final class dr
    extends c.g
  {
    dr()
    {
      super("getWePkgAuthResult", -3, false);
    }
  }
  
  public static final class ds
    extends c.g
  {
    public ds()
    {
      super("add_contact", 10000, false);
    }
  }
  
  public static final class dt
    extends c.g
  {
    public dt()
    {
      super("getWXDeviceInfos", 119, true);
    }
  }
  
  public static final class du
    extends c.g
  {
    public du()
    {
      super("getWXDeviceTicket", 125, true);
    }
  }
  
  public static final class dv
    extends c.g
  {
    public dv()
    {
      super("", 10000, false);
    }
  }
  
  static final class dy
    extends c.g
  {
    dy()
    {
      super("handleMPPageAction", 345, false);
    }
  }
  
  static final class dz
    extends c.g
  {
    dz()
    {
      super("handleVideoAction", 371, false);
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
      super("handleWCPayWalletBuffer", 294, false);
    }
  }
  
  public static final class eb
    extends c.g
  {
    public eb()
    {
      super("hideAllNonBaseMenuItem", 93, false);
    }
  }
  
  public static final class ec
    extends c.g
  {
    public ec()
    {
      super("hideMenuItems", 85, false);
    }
  }
  
  public static final class ed
    extends c.g
  {
    public ed()
    {
      super("hideNavigationBarLoading", 198, false);
    }
  }
  
  public static final class ee
    extends c.g
  {
    public ee()
    {
      super("", 14, false);
    }
  }
  
  public static final class ef
    extends c.g
  {
    public ef()
    {
      super("hideSearchLoading", 10000, false);
    }
  }
  
  public static final class eg
    extends c.g
  {
    public eg()
    {
      super("idCardRealnameVerify", 235, true);
    }
  }
  
  public static final class eh
    extends c.g
  {
    public eh()
    {
      super("", 1, true);
    }
  }
  
  public static final class ei
    extends c.g
  {
    public ei()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ej
    extends c.g
  {
    public ej()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ek
    extends c.g
  {
    public ek()
    {
      super("install_download_task", 41, false);
    }
  }
  
  public static final class el
    extends c.g
  {
    el()
    {
      super("internelWxFaceVerify", 325, true);
    }
  }
  
  static final class em
    extends c.g
  {
    em()
    {
      super("invokeMiniProgramAPI", 295, false);
    }
  }
  
  static final class en
    extends c.g
  {
    en()
    {
      super("jumpDownloaderWidget", 339, true);
    }
  }
  
  public static final class eo
    extends c.g
  {
    public eo()
    {
      super("", 26, false);
    }
  }
  
  public static final class ep
    extends c.g
  {
    public ep()
    {
      super("jump_to_biz_profile", 61, true);
    }
  }
  
  public static final class eq
    extends c.g
  {
    public eq()
    {
      super("jump_wcmall", 51, true);
    }
  }
  
  public static final class er
    extends c.g
  {
    public er()
    {
      super("jumpToWXWallet", 147, true);
    }
  }
  
  public static final class es
    extends c.g
  {
    public es()
    {
      super("kvReport", 170, false);
    }
  }
  
  public static final class et
    extends c.g
  {
    public et()
    {
      super("launch_3rdApp", 52, true);
    }
  }
  
  public static final class eu
    extends c.g
  {
    public eu()
    {
      super("", 27, false);
    }
  }
  
  static final class ev
    extends c.g
  {
    ev()
    {
      super("launchApplication", 260, true);
    }
  }
  
  static final class ew
    extends c.g
  {
    ew()
    {
      super("launchGameVideoEditor", 350, true);
    }
  }
  
  static final class ex
    extends c.g
  {
    ex()
    {
      super("launchMiniProgram", 277, true);
    }
  }
  
  public static final class ey
    extends c.g
  {
    public ey()
    {
      super("getWebPayCheckoutCounterRequst", 161, true);
    }
  }
  
  public static final class ez
    extends c.g
  {
    public ez()
    {
      super("", 0, false);
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
      super("login", 231, true);
    }
  }
  
  static final class fb
    extends c.g
  {
    fb()
    {
      super("makePhoneCall", 356, true);
    }
  }
  
  public static final class fc
    extends c.g
  {
    public fc()
    {
      super("playMusic", 69, false);
    }
  }
  
  public static final class fd
    extends c.g
  {
    public fd()
    {
      super("timeline_check_in", 64, false);
    }
  }
  
  public static final class fe
    extends c.g
  {
    public fe()
    {
      super("open_location", 63, true);
    }
  }
  
  public static final class ff
    extends c.g
  {
    public ff()
    {
      super("open_timeline_checkin_list", 62, false);
    }
  }
  
  public static final class fg
    extends c.g
  {
    public fg()
    {
      super("nfcBatchTransceive", 142, false);
    }
  }
  
  public static final class fh
    extends c.g
  {
    public fh()
    {
      super("nfcCheckState", 155, true);
    }
  }
  
  public static final class fi
    extends c.g
  {
    public fi()
    {
      super("nfcConnect", 140, false);
    }
  }
  
  public static final class fj
    extends c.g
  {
    public fj()
    {
      super("nfcGetId", 143, false);
    }
  }
  
  public static final class fk
    extends c.g
  {
    public fk()
    {
      super("nfcGetInfo", 148, false);
    }
  }
  
  public static final class fl
    extends c.g
  {
    public fl()
    {
      super("nfcIsConnect", 139, true);
    }
  }
  
  public static final class fm
    extends c.g
  {
    public fm()
    {
      super("nfcTransceive", 141, false);
    }
  }
  
  static final class fn
    extends c.g
  {
    fn()
    {
      super("notifyPageInfo", -2, false);
    }
  }
  
  static final class fp
    extends c.g
  {
    fp()
    {
      super("openWCPayCardList", 310, true);
    }
  }
  
  static final class fq
    extends c.g
  {
    fq()
    {
      super("openBizChat", 296, true);
    }
  }
  
  static final class fr
    extends c.g
  {
    fr()
    {
      super("openADCanvas", 283, true);
    }
  }
  
  static final class fs
    extends c.g
  {
    fs()
    {
      super("openCustomWebview", 256, false);
    }
  }
  
  public static final class ft
    extends c.g
  {
    public ft()
    {
      super("openDesignerEmojiView", 185, true);
    }
  }
  
  public static final class fu
    extends c.g
  {
    public fu()
    {
      super("openDesignerEmojiViewLocal", 20000, false);
    }
  }
  
  public static final class fv
    extends c.g
  {
    public fv()
    {
      super("openDesignerProfile", 193, true);
    }
  }
  
  public static final class fw
    extends c.g
  {
    public fw()
    {
      super("openDesignerProfileLocal", 20000, false);
    }
  }
  
  static final class fx
    extends c.g
  {
    fx()
    {
      super("openECard", 268, true);
    }
  }
  
  public static final class fy
    extends c.g
  {
    public fy()
    {
      super("openEmoticonTopicList", 212, true);
    }
  }
  
  public static final class fz
    extends c.g
  {
    public fz()
    {
      super("openEnterpriseChat", 165, false);
    }
  }
  
  public static final class ga
    extends c.g
  {
    public ga()
    {
      super("openEnterpriseContact", 183, true);
    }
  }
  
  public static final class gb
    extends c.g
  {
    public gb()
    {
      super("", 10000, false);
    }
  }
  
  public static final class gc
    extends c.g
  {
    public gc()
    {
      super("", 10000, false);
    }
  }
  
  public static final class gd
    extends c.g
  {
    public gd()
    {
      super("openGameCenter", 175, true);
    }
  }
  
  public static final class ge
    extends c.g
  {
    public ge()
    {
      super("openGameDetail", 131, true);
    }
  }
  
  public static final class gf
    extends c.g
  {
    public gf()
    {
      super("openGameRegion", 242, true);
    }
  }
  
  static final class gg
    extends c.g
  {
    gg()
    {
      super("openGameUrlWithExtraWebView", 297, false);
    }
  }
  
  static final class gh
    extends c.g
  {
    gh()
    {
      super("openGameWebView", 287, false);
    }
  }
  
  public static final class gi
    extends c.g
  {
    public gi()
    {
      super("openLuckyMoneyDetailView", 245, false);
    }
  }
  
  static final class gj
    extends c.g
  {
    gj()
    {
      super("openLuckyMoneyHistory", 258, true);
    }
  }
  
  public static final class gk
    extends c.g
  {
    public gk()
    {
      super("openMapNavigateMenu", 184, true);
    }
  }
  
  public static final class gl
    extends c.g
  {
    public gl()
    {
      super("openMyDeviceProfile", 145, false);
    }
  }
  
  public static final class gm
    extends c.g
  {
    public gm()
    {
      super("openNewPage", 20000, false);
    }
  }
  
  static final class gn
    extends c.g
  {
    gn()
    {
      super("openOfflinePayView", 305, true);
    }
  }
  
  public static final class go
    extends c.g
  {
    public go()
    {
      super("open_product_view", 59, true);
    }
  }
  
  public static final class gp
    extends c.g
  {
    public gp()
    {
      super("open_product_view", 60, true);
    }
  }
  
  static final class gq
    extends c.g
  {
    gq()
    {
      super("openSearchCanvas", 283, true);
    }
  }
  
  static final class gr
    extends c.g
  {
    gr()
    {
      super("openSearchWAWidgetLogView", 10000, true);
    }
  }
  
  static final class gs
    extends c.g
  {
    gs()
    {
      super("openSearchWebView", 10000, true);
    }
  }
  
  public static final class gt
    extends c.g
  {
    public gt()
    {
      super("openSecurityView", 229, false);
    }
  }
  
  static final class gu
    extends c.g
  {
    gu()
    {
      super("openSelectPayment", 359, true);
    }
  }
  
  public static final class gv
    extends c.g
  {
    public gv()
    {
      super("specific_view", 48, true);
    }
  }
  
  public static final class gw
    extends c.g
  {
    public gw()
    {
      super("open_url_by_ext_browser", 55, false);
    }
  }
  
  public static final class gx
    extends c.g
  {
    public gx()
    {
      super("openUrlWithExtraWebview", 173, false);
    }
  }
  
  public static final class gy
    extends c.g
  {
    public gy()
    {
      super("open_wcpay_specific_view", 76, true);
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
      super("openWeApp", 250, false);
    }
  }
  
  public static final class hb
    extends c.g
  {
    public hb()
    {
      super("", 10000, false);
    }
  }
  
  public static final class hc
    extends c.g
  {
    public hc()
    {
      super("get_wcpay_create_credit_card_request", 65, true);
    }
  }
  
  public static final class hd
    extends c.g
  {
    public hd()
    {
      super("openWXDeviceLib", 117, false);
    }
  }
  
  static final class he
    extends c.g
  {
    he()
    {
      super("openWXSearchPage", 309, true);
    }
  }
  
  static final class hf
    extends c.g
  {
    hf()
    {
      super("operateBackgroundAudio", 261, false);
    }
  }
  
  public static final class hg
    extends c.g
  {
    public hg()
    {
      super("operateGameCenterMsg", 174, false);
    }
  }
  
  public static final class hh
    extends c.g
  {
    public hh()
    {
      super("", 10000, false);
    }
  }
  
  static final class hi
    extends c.g
  {
    hi()
    {
      super("", -2, false);
    }
  }
  
  static final class hj
    extends c.g
  {
    hj()
    {
      super("", -2, false);
    }
  }
  
  static final class hk
    extends c.g
  {
    hk()
    {
      super("", -2, false);
    }
  }
  
  public static final class hl
    extends c.g
  {
    public hl()
    {
      super("cancel_download_task", 239, false);
    }
  }
  
  public static final class hm
    extends c.g
  {
    public hm()
    {
      super("pauseVoice", 100, false);
    }
  }
  
  static final class hn
    extends c.g
  {
    hn()
    {
      super("phoneBindCardVerifySms", 370, false);
    }
  }
  
  public static final class ho
    extends c.g
  {
    public ho()
    {
      super("playVoice", 99, false);
    }
  }
  
  static final class hq
    extends c.g
  {
    hq()
    {
      super("preloadMiniProgramEnv", 302, false);
    }
  }
  
  public static final class hr
    extends c.g
  {
    public hr()
    {
      super("preloadSearchWeapp", 10000, false);
    }
  }
  
  static final class hs
    extends c.g
  {
    hs()
    {
      super("previewVideo", 252, true);
    }
  }
  
  public static final class ht
    extends c.g
  {
    public ht()
    {
      super("pre_verify_jsapi", -3, false);
    }
  }
  
  public static final class hw
    extends c.g
  {
    public hw()
    {
      super("profile", 2, false);
    }
  }
  
  static final class hx
    extends c.g
  {
    hx()
    {
      super("publishHaowanEdition", 351, false);
    }
  }
  
  static final class hy
    extends c.g
  {
    hy()
    {
      super("qqMailLoginResult", 357, false);
    }
  }
  
  public static final class hz
    extends c.g
  {
    public hz()
    {
      super("query_download_task", 40, false);
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
  
  static final class ia
    extends c.g
  {
    ia()
    {
      super("queryHaowanPublish", 352, false);
    }
  }
  
  public static final class ib
    extends c.g
  {
    public ib()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ic
    extends c.g
  {
    public ic()
    {
      super("quicklyAddBrandContact", 166, true);
    }
  }
  
  public static final class id
    extends c.g
  {
    public id()
    {
      super("realtimeReport", 171, false);
    }
  }
  
  static final class ie
    extends c.g
  {
    ie()
    {
      super("recordVideo", 251, true);
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
      super("", 10000, false);
    }
  }
  
  public static final class ih
    extends c.g
  {
    public ih()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ii
    extends c.g
  {
    public ii()
    {
      super("reportActionInfo", 234, false);
    }
  }
  
  static final class ij
    extends c.g
  {
    ij()
    {
      super("reportGamePageTime", 301, false);
    }
  }
  
  static final class ik
    extends c.g
  {
    ik()
    {
      super("reportGameWeb", 332, false);
    }
  }
  
  public static final class il
    extends c.g
  {
    public il()
    {
      super("reportIDKey", 163, false);
    }
  }
  
  static final class im
    extends c.g
  {
    im()
    {
      super("reportMiniProgramPageData", 284, false);
    }
  }
  
  public static final class in
    extends c.g
  {
    public in()
    {
      super("", 10000, false);
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
  
  static final class ip
    extends c.g
  {
    ip()
    {
      super("request", 331, false);
    }
  }
  
  static final class iq
    extends c.g
  {
    iq()
    {
      super("requestEntrustAuthorization", 360, true);
    }
  }
  
  static final class ir
    extends c.g
  {
    ir()
    {
      super("requestJointPayment", 358, true);
    }
  }
  
  static final class is
    extends c.g
  {
    is()
    {
      super("requestWxFaceRegisterInternal", 272, true);
    }
  }
  
  static final class it
    extends c.g
  {
    it()
    {
      super("requestWxFaceVerifyInternal", 273, true);
    }
  }
  
  static final class iu
    extends c.g
  {
    iu()
    {
      super("requestWxVoicePrintVerifyInternal", 292, true);
    }
  }
  
  public static final class iv
    extends c.g
  {
    public iv()
    {
      super("resendRemittanceMsg", 246, true);
    }
  }
  
  public static final class iw
    extends c.g
  {
    public iw()
    {
      super("resume_download_task", 240, true);
    }
  }
  
  public static final class ix
    extends c.g
  {
    public ix()
    {
      super("scanLicence", 203, false);
    }
  }
  
  public static final class iy
    extends c.g
  {
    public iy()
    {
      super("scanQRCode", 7, true);
    }
  }
  
  public static final class iz
    extends c.g
  {
    public iz()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ja
    extends c.g
  {
    public ja()
    {
      super("", 329, false);
    }
  }
  
  static final class jb
    extends c.g
  {
    jb()
    {
      super("selectContact", 10000, true);
    }
  }
  
  public static final class jc
    extends c.g
  {
    public jc()
    {
      super("selectEnterpriseContact", 286, true);
    }
  }
  
  public static final class jd
    extends c.g
  {
    public jd()
    {
      super("selectPedometerSource", 146, true);
    }
  }
  
  public static final class je
    extends c.g
  {
    public je()
    {
      super("selectSingleContact", 167, true);
    }
  }
  
  public static final class jf
    extends c.g
  {
    public jf()
    {
      super("sendAppMessageToSpecifiedContact", 168, true);
    }
  }
  
  public static final class jg
    extends c.g
  {
    public jg()
    {
      super("send_app_msg", 6, true);
    }
  }
  
  public static final class ji
    extends c.g
  {
    public ji()
    {
      super("sendDataToWXDevice", 120, true);
    }
  }
  
  public static final class jj
    extends c.g
  {
    public jj()
    {
      super("sendEnterpriseChat", 222, true);
    }
  }
  
  static final class jk
    extends c.g
  {
    jk()
    {
      super("menuitem:gameSendDesktop", 255, false);
    }
  }
  
  public static final class jl
    extends c.g
  {
    public jl()
    {
      super("send_email", 35, false);
    }
  }
  
  public static final class jm
    extends c.g
  {
    public jm()
    {
      super("send_service_app_msg", 67, true);
    }
  }
  
  static final class jn
    extends c.g
  {
    jn()
    {
      super("sendSingleAppMessage", 316, true);
    }
  }
  
  static final class jo
    extends c.g
  {
    jo()
    {
      super("serviceClick", 304, false);
    }
  }
  
  static final class jp
    extends c.g
  {
    jp()
    {
      super("setWCPayPassword", 289, true);
    }
  }
  
  static final class jq
    extends c.g
  {
    jq()
    {
      super("setBackgroundAudioState", 262, false);
    }
  }
  
  public static final class jr
    extends c.g
  {
    public jr()
    {
      super("setBounceBackground", 218, false);
    }
  }
  
  public static final class js
    extends c.g
  {
    public js()
    {
      super("setCloseWindowConfirmDialogInfo", 77, false);
    }
  }
  
  static final class jt
    extends c.g
  {
    jt()
    {
      super("setGameData", 298, false);
    }
  }
  
  public static final class ju
    extends c.g
  {
    public ju()
    {
      super("", -2, false);
    }
  }
  
  public static final class jv
    extends c.g
  {
    public jv()
    {
      super("setFreeWifiOwner", 169, false);
    }
  }
  
  public static final class jw
    extends c.g
  {
    public jw()
    {
      super("setGameDebugConfig", 1111111, false);
    }
  }
  
  public static final class jx
    extends c.g
  {
    public jx()
    {
      super("setLocalData", 180, false);
    }
  }
  
  public static final class jy
    extends c.g
  {
    public jy()
    {
      super("setNavigationBarButtons", 195, false);
    }
  }
  
  public static final class jz
    extends c.g
  {
    public jz()
    {
      super("setNavigationBarColor", 182, false);
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
      super("setPageOwner", 114, false);
    }
  }
  
  public static final class kb
    extends c.g
  {
    public kb()
    {
      super("setPageTitle", 113, false);
    }
  }
  
  static final class kc
    extends c.g
  {
    kc()
    {
      super("setScreenOrientation", 270, false);
    }
  }
  
  public static final class kd
    extends c.g
  {
    public kd()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ke
    extends c.g
  {
    public ke()
    {
      super("setSendDataDirection", 127, false);
    }
  }
  
  public static final class kf
    extends c.g
  {
    public kf()
    {
      super("", 10000, false);
    }
  }
  
  public static final class kg
    extends c.g
  {
    public kg()
    {
      super("setStatusBarStyle", 206, false);
    }
  }
  
  static final class kh
    extends c.g
  {
    kh()
    {
      super("shareEmoticon", 275, true);
    }
  }
  
  public static final class ki
    extends c.g
  {
    public ki()
    {
      super("shareQQ", 90, true);
    }
  }
  
  public static final class kj
    extends c.g
  {
    public kj()
    {
      super("shareQZone", 132, true);
    }
  }
  
  public static final class kk
    extends c.g
  {
    public kk()
    {
      super("shareWeiboApp", 107, false);
    }
  }
  
  public static final class kl
    extends c.g
  {
    public kl()
    {
      super("showAllNonBaseMenuItem", 92, false);
    }
  }
  
  public static final class km
    extends c.g
  {
    public km()
    {
      super("showDatePickerView", 248, true);
    }
  }
  
  public static final class kn
    extends c.g
  {
    public kn()
    {
      super("showKeyboard", 187, false);
    }
  }
  
  public static final class ko
    extends c.g
  {
    public ko()
    {
      super("showMenuItems", 86, false);
    }
  }
  
  public static final class kp
    extends c.g
  {
    public kp()
    {
      super("showNavigationBarLoading", 197, false);
    }
  }
  
  public static final class kq
    extends c.g
  {
    public kq()
    {
      super("", 14, false);
    }
  }
  
  public static final class kr
    extends c.g
  {
    public kr()
    {
      super("showSearchActionSheet", 10000, false);
    }
  }
  
  public static final class ks
    extends c.g
  {
    public ks()
    {
      super("showSearchLoading", 10000, false);
    }
  }
  
  static final class kt
    extends c.g
  {
    kt()
    {
      super("showSearchOfBizHistory", 266, false);
    }
  }
  
  public static final class ku
    extends c.g
  {
    public ku()
    {
      super("showSearchToast", 10000, false);
    }
  }
  
  public static final class kv
    extends c.g
  {
    public kv()
    {
      super("showSmileyPanel", 238, false);
    }
  }
  
  public static final class kw
    extends c.g
  {
    public kw()
    {
      super("soter_biometric_authentication", 214, true);
    }
  }
  
  public static final class kx
    extends c.g
  {
    public kx()
    {
      super("getSupportSoter", 213, true);
    }
  }
  
  public static final class ky
    extends c.g
  {
    public ky()
    {
      super("startMonitoringBeacons", 151, false);
    }
  }
  
  public static final class kz
    extends c.g
  {
    public kz()
    {
      super("startPullDownRefresh", 204, false);
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
      super("startRecord", 96, false);
    }
  }
  
  public static final class lb
    extends c.g
  {
    public lb()
    {
      super("startScanWXDevice", 121, true);
    }
  }
  
  public static final class lc
    extends c.g
  {
    public lc()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ld
    extends c.g
  {
    public ld()
    {
      super("startTempSession", 128, true);
    }
  }
  
  public static final class le
    extends c.g
  {
    public le()
    {
      super("startVoipCall", 230, false);
    }
  }
  
  public static final class lf
    extends c.g
  {
    public lf()
    {
      super("stopMonitoringBeacons", 152, false);
    }
  }
  
  public static final class lg
    extends c.g
  {
    public lg()
    {
      super("stopPullDownRefresh", 200, false);
    }
  }
  
  public static final class lh
    extends c.g
  {
    public lh()
    {
      super("stopRecord", 98, false);
    }
  }
  
  public static final class li
    extends c.g
  {
    public li()
    {
      super("stopScanWXDevice", 122, true);
    }
  }
  
  public static final class lj
    extends c.g
  {
    public lj()
    {
      super("stopVoice", 101, false);
    }
  }
  
  public static final class lk
    extends c.g
  {
    public lk()
    {
      super("playStreamingVideo", 209, false);
    }
  }
  
  public static final class ll
    extends c.g
  {
    public ll()
    {
      super("selectWalletCurrency", 201, true);
    }
  }
  
  static final class lm
    extends c.g
  {
    lm()
    {
      super("tapSearchWAWidgetView", 10000, false);
    }
  }
  
  public static final class ln
    extends c.g
  {
    public ln()
    {
      super("share_timeline", 4, true);
    }
  }
  
  public static final class lo
    extends c.g
  {
    public lo()
    {
      super("translateVoice", 97, true);
    }
  }
  
  public static final class lp
    extends c.g
  {
    public lp()
    {
      super("unbindBankCard", 216, true);
    }
  }
  
  static final class lq
    extends c.g
  {
    lq()
    {
      super("updatePageAuth", -2, false);
    }
  }
  
  public static final class lr
    extends c.g
  {
    public lr()
    {
      super("", 10000, false);
    }
  }
  
  static final class ls
    extends c.g
  {
    ls()
    {
      super("updateAppMessageShareData", 326, false);
    }
  }
  
  public static final class lt
    extends c.g
  {
    public lt()
    {
      super("", 10000, false);
    }
  }
  
  static final class lu
    extends c.g
  {
    lu()
    {
      super("updateTimelineShareData", 327, false);
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
  
  public static final class lw
    extends c.g
  {
    public lw()
    {
      super("updateWASearchTemplate", 10000, false);
    }
  }
  
  static final class lx
    extends c.g
  {
    lx()
    {
      super("uploadEncryptMediaFile", 253, false);
    }
  }
  
  public static final class ly
    extends c.g
  {
    public ly()
    {
      super("uploadImage", 105, true);
    }
  }
  
  public static final class lz
    extends c.g
  {
    public lz()
    {
      super("uploadMediaFile", 237, true);
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
      super("uploadVideo", 192, true);
    }
  }
  
  public static final class mb
    extends c.g
  {
    public mb()
    {
      super("uploadVoice", 102, true);
    }
  }
  
  public static final class mc
    extends c.g
  {
    public mc()
    {
      super("uxSearchOpLog", 10000, false);
    }
  }
  
  public static final class md
    extends c.g
  {
    public md()
    {
      super("verifyWCPayPassword", 115, true);
    }
  }
  
  static final class me
    extends c.g
  {
    me()
    {
      super("", 10000, false);
    }
  }
  
  public static final class mf
    extends c.g
  {
    public mf()
    {
      super("", 355, true);
    }
  }
  
  static final class mg
    extends c.g
  {
    mg()
    {
      super("wcPrivacyPolicyResult", 315, false);
    }
  }
  
  public static final class mh
    extends c.g
  {
    public mh()
    {
      super("cache", 150, false);
    }
  }
  
  public static final class mi
    extends c.g
  {
    public mi()
    {
      super("videoProxyInit", 156, false);
    }
  }
  
  public static final class mj
    extends c.g
  {
    public mj()
    {
      super("videoProxySetPlayerState", 159, false);
    }
  }
  
  public static final class mk
    extends c.g
  {
    public mk()
    {
      super("videoProxySetPlayerState", 160, false);
    }
  }
  
  public static final class ml
    extends c.g
  {
    public ml()
    {
      super("videoProxyStartPlay", 157, false);
    }
  }
  
  public static final class mm
    extends c.g
  {
    public mm()
    {
      super("videoProxyStopPlay", 158, false);
    }
  }
  
  public static final class mn
    extends c.g
  {
    public mn()
    {
      super("publicCache", 149, false);
    }
  }
  
  public static final class mo
    extends c.g
  {
    public mo()
    {
      super("videoProxyPreload", 172, false);
    }
  }
  
  public static final class mp
    extends c.g
  {
    public mp()
    {
      super("share_weibo", 3, true);
    }
  }
  
  public static final class mq
    extends c.g
  {
    public mq()
    {
      super("", 10000, false);
    }
  }
  
  public static final class mr
    extends c.g
  {
    public mr()
    {
      super("WNNativeAsyncCallback", 10006, false);
    }
  }
  
  public static final class ms
    extends c.g
  {
    public ms()
    {
      super("WNNativeCallbackInitData", 10006, false);
    }
  }
  
  public static final class mt
    extends c.g
  {
    public mt()
    {
      super("WNNativeCallbackOnCaretChange", 10006, false);
    }
  }
  
  public static final class mu
    extends c.g
  {
    public mu()
    {
      super("WNNativeCallbackOnClick", 10006, false);
    }
  }
  
  public static final class mv
    extends c.g
  {
    public mv()
    {
      super("WNNativeCallbackOnLongClick", 10006, false);
    }
  }
  
  public static final class mw
    extends c.g
  {
    public mw()
    {
      super("write_comm_data", 53, false);
    }
  }
  
  static final class mx
    extends c.g
  {
    mx()
    {
      super("calRqt", 319, false);
    }
  }
  
  static final class my
    extends c.g
  {
    my()
    {
      super("getCCData", 312, false);
    }
  }
  
  static final class mz
    extends c.g
  {
    mz()
    {
      super("openRealnameAuth", 314, true);
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
      super("WNNativeCallbackOnBecomeEditing", 10006, false);
    }
  }
  
  public static final class nb
    extends c.g
  {
    public nb()
    {
      super("WNNativeCallbackOnBecomeEdited", 10006, false);
    }
  }
  
  public static final class nc
    extends c.g
  {
    public nc()
    {
      super("", 317, true);
    }
  }
  
  public static final class nd
    extends c.g
  {
    public nd()
    {
      super("", 129, false);
    }
  }
  
  public static final class ne
    extends c.g
  {
    public ne()
    {
      super("", 89, false);
    }
  }
  
  public static final class nf
    extends c.g
  {
    public nf()
    {
      super("", 94, false);
    }
  }
  
  public static final class ng
    extends c.g
  {
    public ng()
    {
      super("", 134, false);
    }
  }
  
  public static final class nh
    extends c.g
  {
    public nh()
    {
      super("", 88, false);
    }
  }
  
  public static final class ni
    extends c.g
  {
    public ni()
    {
      super("", 109, false);
    }
  }
  
  public static final class nj
    extends c.g
  {
    public nj()
    {
      super("", 320, true);
    }
  }
  
  public static final class nk
    extends c.g
  {
    public nk()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c
 * JD-Core Version:    0.7.0.1
 */