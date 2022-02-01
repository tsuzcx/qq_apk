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
  private static Map<String, c.g> DHQ;
  public static final String[] DHR;
  
  static
  {
    AppMethodBeat.i(152436);
    DHQ = null;
    DHR = (String[])new c.1().toArray(new String[0]);
    AppMethodBeat.o(152436);
  }
  
  public static Bundle aIx(String paramString)
  {
    AppMethodBeat.i(152434);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("handle", true);
    localBundle.putString("handle_result", paramString);
    AppMethodBeat.o(152434);
    return localBundle;
  }
  
  public static c.g aIy(String paramString)
  {
    AppMethodBeat.i(152435);
    if ((DHQ == null) || (DHQ.size() <= 0))
    {
      Object localObject = new HashMap(128);
      DHQ = (Map)localObject;
      ((Map)localObject).put("log", new et());
      DHQ.put("imagePreview", new eb());
      DHQ.put("profile", new hp());
      DHQ.put("shareWeibo", new mh());
      DHQ.put("shareTimeline", new lf());
      DHQ.put("adDataReport", new o());
      DHQ.put("streamingVideoPlay", new lc());
      DHQ.put("addContact", new h());
      DHQ.put("getWidgetCaptureImgUrl", new do());
      DHQ.put("sendAppMessage", new iy());
      DHQ.put("scanQRCode", new iq());
      DHQ.put("hideOptionMenu", new dy());
      DHQ.put("showOptionMenu", new ki());
      DHQ.put("getNetworkType", new cp());
      DHQ.put("closeWindow", new ao());
      DHQ.put("getInstallState", new ck());
      DHQ.put("setFontSizeCallback", new jm());
      DHQ.put("jumpToInstallUrl", new ei());
      DHQ.put("launchApp", new eo());
      DHQ.put("getBrandWCPayRequest", new bz());
      DHQ.put("secureTunnel", new is());
      DHQ.put("wcpaySecurityCrosscutBack", new lx());
      DHQ.put("editAddress", new bj());
      DHQ.put("getHeadingAndPitch", new ch());
      DHQ.put("sendEmail", new jd());
      DHQ.put("addDownloadTask", new k());
      DHQ.put("cancelDownloadTask", new v());
      DHQ.put("pauseDownloadTask", new hf());
      DHQ.put("resumeDownloadTask", new io());
      DHQ.put("queryDownloadTask", new hr());
      DHQ.put("installDownloadTask", new ee());
      DHQ.put("getLatestAddress", new cu());
      DHQ.put("openSpecificView", new gp());
      DHQ.put("jumpWCMall", new ek());
      DHQ.put("launch3rdApp", new en());
      DHQ.put("writeCommData", new mo());
      DHQ.put("openUrlByExtBrowser", new gq());
      DHQ.put("geoLocation", new bw());
      DHQ.put("getBrandWCPayBindCardRequest", new by());
      DHQ.put("openProductView", new gi());
      DHQ.put("openProductViewWithPid", new gj());
      DHQ.put("jumpToBizProfile", new ej());
      DHQ.put("openTimelineCheckInList", new ez());
      DHQ.put("openLocation", new ey());
      DHQ.put("timelineCheckIn", new ex());
      DHQ.put("getBrandWCPayCreateCreditCardRequest", new gw());
      DHQ.put("chooseCard", new ab());
      DHQ.put("chooseInvoice", new af());
      DHQ.put("sendServiceAppMessage", new je());
      DHQ.put("musicPlay", new ew());
      DHQ.put("mmsf0001", new cc());
      DHQ.put("connectToWiFi", new au());
      DHQ.put("getTransferMoneyRequest", new dk());
      DHQ.put("openWCPaySpecificView", new gs());
      DHQ.put("setCloseWindowConfirmDialogInfo", new jk());
      DHQ.put("batchAddCard", new q());
      DHQ.put("preVerifyJSAPI", new hm());
      DHQ.put("startRecord", new ks());
      DHQ.put("stopRecord", new kz());
      DHQ.put("playVoice", new hh());
      DHQ.put("pauseVoice", new hg());
      DHQ.put("stopVoice", new lb());
      DHQ.put("uploadVoice", new lt());
      DHQ.put("downloadVoice", new bg());
      DHQ.put("chooseImage", new ae());
      DHQ.put("uploadImage", new lq());
      DHQ.put("downloadImage", new bf());
      DHQ.put("uploadMediaFile", new lr());
      DHQ.put("hideMenuItems", new dw());
      DHQ.put("showMenuItems", new kg());
      DHQ.put("hideAllNonBaseMenuItem", new dv());
      DHQ.put("showAllNonBaseMenuItem", new kd());
      DHQ.put("checkJsApi", new aa());
      DHQ.put("translateVoice", new lg());
      DHQ.put("shareQQ", new ka());
      DHQ.put("shareWeiboApp", new kc());
      DHQ.put("shareQZone", new kb());
      DHQ.put("connectToFreeWifi", new at());
      DHQ.put("getSendC2CMessageRequest", new dh());
      DHQ.put("batchViewCard", new t());
      DHQ.put("configWXDeviceWiFi", new ar());
      DHQ.put("getCurrentSSID", new ca());
      DHQ.put("setPageOwner", new js());
      DHQ.put("getWechatVerifyTicket", new dm());
      DHQ.put("openWXDeviceLib", new gx());
      DHQ.put("startScanWXDevice", new kt());
      DHQ.put("stopScanWXDevice", new la());
      DHQ.put("connectWXDevice", new av());
      DHQ.put("disconnectWXDevice", new be());
      DHQ.put("getWXDeviceTicket", new dq());
      DHQ.put("getWXDeviceInfos", new dp());
      DHQ.put("sendDataToWXDevice", new ja());
      DHQ.put("closeWXDeviceLib", new aq());
      DHQ.put("setSendDataDirection", new jw());
      DHQ.put("verifyWCPayPassword", new lv());
      DHQ.put("getPaymentOrderRequest", new ct());
      DHQ.put("openGameDetail", new fy());
      DHQ.put("openGameCenter", new fx());
      DHQ.put("setGameDebugConfig", new jo());
      DHQ.put("startTempSession", new kv());
      DHQ.put("getH5PrepayRequest", new ci());
      DHQ.put("getH5TransactionRequest", new cj());
      DHQ.put("menu:share:timeline", new mz());
      DHQ.put("menu:share:appmessage", new mw());
      DHQ.put("menu:share:qq", new mx());
      DHQ.put("menu:share:weiboApp", new na());
      DHQ.put("menu:setfont", new mv());
      DHQ.put("menu:share:weibo", new na());
      DHQ.put("menu:share:QZone", new my());
      DHQ.put("getRecevieBizHongBaoRequest", new e());
      DHQ.put("insertVideoPlayer", new ed());
      DHQ.put("updateVideoPlayer", new ln());
      DHQ.put("removeVideoPlayer", new hz());
      DHQ.put("operateVideoPlayer", new hb());
      DHQ.put("deleteSearchHistory", new bb());
      DHQ.put("getSearchHistory", new dd());
      DHQ.put("getSearchData", new cz());
      DHQ.put("getPoiInfo", new cg());
      DHQ.put("updateReddotTimeStamps", new lj());
      DHQ.put("getTeachSearchData", new dj());
      DHQ.put("getSearchGuideData", new dc());
      DHQ.put("getSearchAvatarList", new cy());
      DHQ.put("getSearchSnsImageList", new df());
      DHQ.put("getSearchImageList", new de());
      DHQ.put("getSearchDisplayNameList", new da());
      DHQ.put("startSearchItemDetailPage", new ku());
      DHQ.put("reportSearchStatistics", new ig());
      DHQ.put("reportSearchRealTimeStatistics", new if());
      DHQ.put("searchDataHasResult", new ir());
      DHQ.put("openEmotionPage", new bs());
      DHQ.put("getSearchSuggestionData", new dg());
      DHQ.put("setSearchInputWord", new jv());
      DHQ.put("setSnsObjectXmlDescList", new jx());
      DHQ.put("clickSnsMusicPlayButton", new an());
      DHQ.put("openWeAppPage", new gv());
      DHQ.put("reportWeAppSearchRealtime", new mi());
      DHQ.put("doSearchOperation", new bi());
      DHQ.put("insertSearchWAWidgetView", new ec());
      DHQ.put("removeSearchWAWidgetView", new hy());
      DHQ.put("updateSearchWAWidgetView", new ll());
      DHQ.put("showSearchActionSheet", new kj());
      DHQ.put("cancelSearchActionSheet", new x());
      DHQ.put("showSearchToast", new km());
      DHQ.put("showSearchLoading", new kk());
      DHQ.put("hideSearchLoading", new dz());
      DHQ.put("updateWASearchTemplate", new lo());
      DHQ.put("preloadSearchWeapp", new hk());
      DHQ.put("uxSearchOpLog", new lu());
      DHQ.put("querySearchWeb", new bu());
      DHQ.put("openFinderProfile", new fw());
      DHQ.put("openFinderFeed", new fv());
      DHQ.put("jumpToWXWallet", new el());
      DHQ.put("scanCover", new f());
      DHQ.put("reportActionInfo", new ia());
      DHQ.put("openMyDeviceProfile", new gf());
      DHQ.put("selectPedometerSource", new iv());
      DHQ.put("nfcIsConnect", new ff());
      DHQ.put("nfcConnect", new fc());
      DHQ.put("nfcTransceive", new fg());
      DHQ.put("nfcBatchTransceive", new fa());
      DHQ.put("nfcGetId", new fd());
      DHQ.put("nfcGetInfo", new fe());
      DHQ.put("startMonitoringBeacons", new kq());
      DHQ.put("stopMonitoringBeacons", new kx());
      DHQ.put("nfcCheckState", new fb());
      DHQ.put("videoProxyInit", new ma());
      DHQ.put("videoProxyStartPlay", new md());
      DHQ.put("videoProxyStopPlay", new me());
      DHQ.put("videoProxySetPlayerState", new mb());
      DHQ.put("videoProxySetRemainTime", new mc());
      DHQ.put("videoProxyPreload", new mg());
      DHQ.put("getWebPayCheckoutCounterRequst", new es());
      DHQ.put("addCustomMenuItems", new i());
      DHQ.put("operateGameCenterMsg", new ha());
      DHQ.put("openEnterpriseChat", new ft());
      DHQ.put("enterEnterpriseChat", new bn());
      DHQ.put("openEnterpriseContact", new fu());
      DHQ.put("selectEnterpriseContact", new iu());
      DHQ.put("getEnterpriseChat", new ce());
      DHQ.put("reportIDKey", new id());
      DHQ.put("quicklyAddBrandContact", new hu());
      DHQ.put("consumedShareCard", new aw());
      DHQ.put("cache", new lz());
      DHQ.put("publicCache", new mf());
      DHQ.put("kvReport", new em());
      DHQ.put("realtimeReport", new hv());
      DHQ.put("openUrlWithExtraWebview", new gr());
      DHQ.put("setFreeWifiOwner", new jn());
      DHQ.put("selectSingleContact", new iw());
      DHQ.put("sendAppMessageToSpecifiedContact", new ix());
      DHQ.put("setLocalData", new jp());
      DHQ.put("getLocalData", new cl());
      DHQ.put("clearLocalData", new al());
      DHQ.put("showKeyboard", new kf());
      DHQ.put("showSmileyPanel", new kn());
      DHQ.put("disableBounceScroll", new bc());
      DHQ.put("clearBounceBackground", new aj());
      DHQ.put("setNavigationBarButtons", new jq());
      DHQ.put("enableFullScreen", new bl());
      DHQ.put("showNavigationBarLoading", new kh());
      DHQ.put("hideNavigationBarLoading", new dx());
      DHQ.put("enablePullDownRefresh", new bm());
      DHQ.put("startPullDownRefresh", new kr());
      DHQ.put("stopPullDownRefresh", new ky());
      DHQ.put("disablePullDownRefresh", new bd());
      DHQ.put("setPageTitle", new jt());
      DHQ.put("setStatusBarStyle", new jy());
      DHQ.put("deleteAccountSuccess", new ba());
      DHQ.put("chooseVideo", new ai());
      DHQ.put("uploadVideo", new ls());
      DHQ.put("openMapNavigateMenu", new ge());
      DHQ.put("setNavigationBarColor", new jr());
      DHQ.put("getWCPayRealnameVerify", new dl());
      DHQ.put("openDesignerEmojiView", new fn());
      DHQ.put("openDesignerProfile", new fp());
      DHQ.put("openEmoticonTopicList", new fs());
      DHQ.put("openDesignerEmojiViewLocal", new fo());
      DHQ.put("openDesignerProfileLocal", new fq());
      DHQ.put("openEmotionDetailViewLocal", new d());
      DHQ.put("openNewPage", new gg());
      DHQ.put("getSearchEmotionData", new db());
      DHQ.put("openEmotionUrl", new bk());
      DHQ.put("WNNativeCallbackOnClick", new mm());
      DHQ.put("WNNativeCallbackOnLongClick", new mn());
      DHQ.put("WNNativeCallbackOnCaretChange", new ml());
      DHQ.put("WNNativeCallbackInitData", new mk());
      DHQ.put("WNNativeAsyncCallback", new mj());
      DHQ.put("WNNativeCallbackOnBecomeEditing", new ms());
      DHQ.put("WNNativeCallbackOnBecomeEdited", new mt());
      DHQ.put("changePayActivityView", new y());
      DHQ.put("selectWalletCurrency", new ld());
      DHQ.put("scanLicence", new ip());
      DHQ.put("operateMusicPlayer", new b());
      DHQ.put("getMusicPlayerState", new a());
      DHQ.put("clearWebviewCache", new am());
      DHQ.put("requireSoterBiometricAuthentication", new ko());
      DHQ.put("getSupportSoter", new kp());
      DHQ.put("unbindBankCard", new lh());
      DHQ.put("setBounceBackground", new jj());
      DHQ.put("sendEnterpriseChat", new jb());
      DHQ.put("doExposePreparation", new bh());
      DHQ.put("getMsgProofItems", new co());
      DHQ.put("openSecurityView", new gn());
      DHQ.put("startVoipCall", new kw());
      DHQ.put("chooseInvoiceTitle", new ag());
      DHQ.put("getOpenDeviceId", new cr());
      DHQ.put("getRouteUrl", new cx());
      DHQ.put("idCardRealnameVerify", new ea());
      DHQ.put("uploadIdCardSuccess", new nc());
      DHQ.put("showDatePickerView", new ke());
      DHQ.put("openLuckyMoneyDetailView", new gc());
      DHQ.put("resendRemittanceMsg", new in());
      DHQ.put("getGameCommInfo", new cf());
      DHQ.put("openGameRegion", new fz());
      DHQ.put("chooseIdCard", new ad());
      DHQ.put("getLocalImgData", new c());
      DHQ.put("openWeApp", new gu());
      DHQ.put("recordVideo", new hw());
      DHQ.put("previewVideo", new hl());
      DHQ.put("uploadEncryptMediaFile", new lp());
      DHQ.put("chooseMedia", new ah());
      DHQ.put("requestWxFacePictureVerify", new bo());
      DHQ.put("openCustomWebview", new fm());
      DHQ.put("forceUpdateWxaAttr", new br());
      DHQ.put("openLuckyMoneyHistory", new gd());
      DHQ.put("menuitem:gameSendDesktop", new jc());
      DHQ.put("getWePkgAuthResult", new dn());
      DHQ.put("getLocalWePkgInfo", new cm());
      DHQ.put("openGameWebView", new gb());
      DHQ.put("reportGameWeb", new ic());
      DHQ.put("launchApplication", new ep());
      DHQ.put("showSearchOfBizHistory", new kl());
      DHQ.put("login", new eu());
      DHQ.put("authorize", new p());
      DHQ.put("requestWxFacePictureVerifyUnionVideo", new bp());
      DHQ.put("checkIsSupportFaceDetect", new z());
      DHQ.put("operateBackgroundAudio", new gz());
      DHQ.put("setBackgroundAudioState", new ji());
      DHQ.put("getBackgroundAudioState", new bx());
      DHQ.put("addDownloadTaskStraight", new l());
      DHQ.put("setScreenOrientation", new ju());
      DHQ.put("addToEmoticon", new n());
      DHQ.put("shareEmoticon", new jz());
      DHQ.put("makePhoneCall", new ev());
      DHQ.put("openADCanvas", new fl());
      DHQ.put("openSearchCanvas", new gk());
      DHQ.put("opVoteAdData", new he());
      DHQ.put("opJumpView", new hd());
      DHQ.put("opAdH5Func", new hc());
      DHQ.put("requestWxFaceRegisterInternal", new ik());
      DHQ.put("requestWxFaceVerifyInternal", new il());
      DHQ.put("launchMiniProgram", new er());
      DHQ.put("reportMiniProgramPageData", new ie());
      DHQ.put("selectContact", new it());
      DHQ.put("openSearchWAWidgetLogView", new gl());
      DHQ.put("reloadSearchWAWidgetData", new hx());
      DHQ.put("gotoEmoticonPad", new dr());
      DHQ.put("querySimilarEmotion", new ht());
      DHQ.put("closeWindowAndGoNext", new ap());
      DHQ.put("requestWxVoicePrintVerifyInternal", new im());
      DHQ.put("openBizChat", new fk());
      DHQ.put("handleWCPayWalletBuffer", new du());
      DHQ.put("tapSearchWAWidgetView", new le());
      DHQ.put("getMatchContactList", new cn());
      DHQ.put("openSearchWebView", new gm());
      DHQ.put("openWXSearchPage", new gy());
      DHQ.put("viewTypeChange", new lw());
      DHQ.put("invokeMiniProgramAPI", new eg());
      DHQ.put("openGameUrlWithExtraWebView", new ga());
      DHQ.put("setGameData", new jl());
      DHQ.put("getGameData", new cb());
      DHQ.put("clearGameData", new ak());
      DHQ.put("openECard", new fr());
      DHQ.put("reportGamePageTime", new ib());
      DHQ.put("setWCPayPassword", new jh());
      DHQ.put("openWCPayCardList", new fj());
      DHQ.put("bindEmail", new u());
      DHQ.put("openOfflinePayView", new gh());
      DHQ.put("bindEmail", new u());
      DHQ.put("doGoToRecVideoList", new cv());
      DHQ.put("jumpWSRecVideoList", new mu());
      DHQ.put("openWebSearchOutLinkItem", new nb());
      DHQ.put("recordHistory", new bv());
      localObject = eQW().iterator();
      while (((Iterator)localObject).hasNext())
      {
        c.g localg = (c.g)((Iterator)localObject).next();
        DHQ.put(localg.getName(), localg);
      }
      DHQ.put("getSystemInfo", new di());
      DHQ.put("serviceClick", new jg());
      DHQ.put("openRealnameAuth", new mr());
      DHQ.put("sendSingleAppMessage", new jf());
      DHQ.put("wcPrivacyPolicyResult", new ly());
      DHQ.put("currentMpInfo", new ax());
      DHQ.put("updateAppMessageShareData", new lk());
      DHQ.put("updateTimelineShareData", new lm());
      DHQ.put("getCCData", new mq());
      DHQ.put("calRqt", new mp());
      DHQ.put("faceVerifyForPay", new bq());
      DHQ.put("request", new ih());
      DHQ.put("notifyPageInfo", new fh());
      DHQ.put("updatePageAuth", new li());
      DHQ.put("jumpDownloaderWidget", new eh());
      DHQ.put("batchUpdateWepkg", new s());
      DHQ.put("addGameDownloadTask", new m());
      DHQ.put("internelWxFaceVerify", new ef());
      DHQ.put("getDownloadWidgetTaskInfos", new cd());
      DHQ.put("chooseHaowanMedia", new ac());
      DHQ.put("queryHaowanPublish", new hs());
      DHQ.put("publishHaowanEdition", new hq());
      DHQ.put("cancelHaowanPublish", new w());
      DHQ.put("launchGameVideoEditor", new eq());
      DHQ.put("requestJointPayment", new ij());
      DHQ.put("openSelectPayment", new go());
      DHQ.put("requestEntrustAuthorization", new ii());
      DHQ.put("getOAID", new cq());
    }
    paramString = (c.g)DHQ.get(paramString);
    AppMethodBeat.o(152435);
    return paramString;
  }
  
  private static List<c.g> eQW()
  {
    AppMethodBeat.i(192702);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new c.az());
    localLinkedList.add(new c.ay());
    localLinkedList.add(new hj());
    localLinkedList.add(new c.hi());
    localLinkedList.add(new c.iz());
    localLinkedList.add(new c.ds());
    localLinkedList.add(new dt());
    localLinkedList.add(new c.j());
    localLinkedList.add(new c.ho());
    localLinkedList.add(new c.hn());
    localLinkedList.add(new bt());
    localLinkedList.add(new c.gt());
    localLinkedList.add(new as());
    localLinkedList.add(new c.cs());
    localLinkedList.add(new c.cw());
    localLinkedList.add(new c.r());
    localLinkedList.add(new c.fi());
    AppMethodBeat.o(192702);
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
  
  static final class fj
    extends c.g
  {
    fj()
    {
      super("openWCPayCardList", 310, true);
    }
  }
  
  static final class fk
    extends c.g
  {
    fk()
    {
      super("openBizChat", 296, true);
    }
  }
  
  static final class fl
    extends c.g
  {
    fl()
    {
      super("openADCanvas", 283, true);
    }
  }
  
  static final class fm
    extends c.g
  {
    fm()
    {
      super("openCustomWebview", 256, false);
    }
  }
  
  public static final class fn
    extends c.g
  {
    public fn()
    {
      super("openDesignerEmojiView", 185, true);
    }
  }
  
  public static final class fo
    extends c.g
  {
    public fo()
    {
      super("openDesignerEmojiViewLocal", 20000, false);
    }
  }
  
  public static final class fp
    extends c.g
  {
    public fp()
    {
      super("openDesignerProfile", 193, true);
    }
  }
  
  public static final class fq
    extends c.g
  {
    public fq()
    {
      super("openDesignerProfileLocal", 20000, false);
    }
  }
  
  static final class fr
    extends c.g
  {
    fr()
    {
      super("openECard", 268, true);
    }
  }
  
  public static final class fs
    extends c.g
  {
    public fs()
    {
      super("openEmoticonTopicList", 212, true);
    }
  }
  
  public static final class ft
    extends c.g
  {
    public ft()
    {
      super("openEnterpriseChat", 165, false);
    }
  }
  
  public static final class fu
    extends c.g
  {
    public fu()
    {
      super("openEnterpriseContact", 183, true);
    }
  }
  
  public static final class fv
    extends c.g
  {
    public fv()
    {
      super("", 10000, false);
    }
  }
  
  public static final class fw
    extends c.g
  {
    public fw()
    {
      super("", 10000, false);
    }
  }
  
  public static final class fx
    extends c.g
  {
    public fx()
    {
      super("openGameCenter", 175, true);
    }
  }
  
  public static final class fy
    extends c.g
  {
    public fy()
    {
      super("openGameDetail", 131, true);
    }
  }
  
  public static final class fz
    extends c.g
  {
    public fz()
    {
      super("openGameRegion", 242, true);
    }
  }
  
  static final class ga
    extends c.g
  {
    ga()
    {
      super("openGameUrlWithExtraWebView", 297, false);
    }
  }
  
  static final class gb
    extends c.g
  {
    gb()
    {
      super("openGameWebView", 287, false);
    }
  }
  
  public static final class gc
    extends c.g
  {
    public gc()
    {
      super("openLuckyMoneyDetailView", 245, false);
    }
  }
  
  static final class gd
    extends c.g
  {
    gd()
    {
      super("openLuckyMoneyHistory", 258, true);
    }
  }
  
  public static final class ge
    extends c.g
  {
    public ge()
    {
      super("openMapNavigateMenu", 184, true);
    }
  }
  
  public static final class gf
    extends c.g
  {
    public gf()
    {
      super("openMyDeviceProfile", 145, false);
    }
  }
  
  public static final class gg
    extends c.g
  {
    public gg()
    {
      super("openNewPage", 20000, false);
    }
  }
  
  static final class gh
    extends c.g
  {
    gh()
    {
      super("openOfflinePayView", 305, true);
    }
  }
  
  public static final class gi
    extends c.g
  {
    public gi()
    {
      super("open_product_view", 59, true);
    }
  }
  
  public static final class gj
    extends c.g
  {
    public gj()
    {
      super("open_product_view", 60, true);
    }
  }
  
  static final class gk
    extends c.g
  {
    gk()
    {
      super("openSearchCanvas", 283, true);
    }
  }
  
  static final class gl
    extends c.g
  {
    gl()
    {
      super("openSearchWAWidgetLogView", 10000, true);
    }
  }
  
  static final class gm
    extends c.g
  {
    gm()
    {
      super("openSearchWebView", 10000, true);
    }
  }
  
  public static final class gn
    extends c.g
  {
    public gn()
    {
      super("openSecurityView", 229, false);
    }
  }
  
  static final class go
    extends c.g
  {
    go()
    {
      super("openSelectPayment", 359, true);
    }
  }
  
  public static final class gp
    extends c.g
  {
    public gp()
    {
      super("specific_view", 48, true);
    }
  }
  
  public static final class gq
    extends c.g
  {
    public gq()
    {
      super("open_url_by_ext_browser", 55, false);
    }
  }
  
  public static final class gr
    extends c.g
  {
    public gr()
    {
      super("openUrlWithExtraWebview", 173, false);
    }
  }
  
  public static final class gs
    extends c.g
  {
    public gs()
    {
      super("open_wcpay_specific_view", 76, true);
    }
  }
  
  static final class gu
    extends c.g
  {
    gu()
    {
      super("openWeApp", 250, false);
    }
  }
  
  public static final class gv
    extends c.g
  {
    public gv()
    {
      super("", 10000, false);
    }
  }
  
  public static final class gw
    extends c.g
  {
    public gw()
    {
      super("get_wcpay_create_credit_card_request", 65, true);
    }
  }
  
  public static final class gx
    extends c.g
  {
    public gx()
    {
      super("openWXDeviceLib", 117, false);
    }
  }
  
  static final class gy
    extends c.g
  {
    gy()
    {
      super("openWXSearchPage", 309, true);
    }
  }
  
  static final class gz
    extends c.g
  {
    gz()
    {
      super("operateBackgroundAudio", 261, false);
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
      super("operateGameCenterMsg", 174, false);
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
  
  static final class hc
    extends c.g
  {
    hc()
    {
      super("", -2, false);
    }
  }
  
  static final class hd
    extends c.g
  {
    hd()
    {
      super("", -2, false);
    }
  }
  
  static final class he
    extends c.g
  {
    he()
    {
      super("", -2, false);
    }
  }
  
  public static final class hf
    extends c.g
  {
    public hf()
    {
      super("cancel_download_task", 239, false);
    }
  }
  
  public static final class hg
    extends c.g
  {
    public hg()
    {
      super("pauseVoice", 100, false);
    }
  }
  
  public static final class hh
    extends c.g
  {
    public hh()
    {
      super("playVoice", 99, false);
    }
  }
  
  static final class hj
    extends c.g
  {
    hj()
    {
      super("preloadMiniProgramEnv", 302, false);
    }
  }
  
  public static final class hk
    extends c.g
  {
    public hk()
    {
      super("preloadSearchWeapp", 10000, false);
    }
  }
  
  static final class hl
    extends c.g
  {
    hl()
    {
      super("previewVideo", 252, true);
    }
  }
  
  public static final class hm
    extends c.g
  {
    public hm()
    {
      super("pre_verify_jsapi", -3, false);
    }
  }
  
  public static final class hp
    extends c.g
  {
    public hp()
    {
      super("profile", 2, false);
    }
  }
  
  static final class hq
    extends c.g
  {
    hq()
    {
      super("publishHaowanEdition", 351, false);
    }
  }
  
  public static final class hr
    extends c.g
  {
    public hr()
    {
      super("query_download_task", 40, false);
    }
  }
  
  static final class hs
    extends c.g
  {
    hs()
    {
      super("queryHaowanPublish", 352, false);
    }
  }
  
  public static final class ht
    extends c.g
  {
    public ht()
    {
      super("", 10000, false);
    }
  }
  
  public static final class hu
    extends c.g
  {
    public hu()
    {
      super("quicklyAddBrandContact", 166, true);
    }
  }
  
  public static final class hv
    extends c.g
  {
    public hv()
    {
      super("realtimeReport", 171, false);
    }
  }
  
  static final class hw
    extends c.g
  {
    hw()
    {
      super("recordVideo", 251, true);
    }
  }
  
  public static final class hx
    extends c.g
  {
    public hx()
    {
      super("", 10000, false);
    }
  }
  
  public static final class hy
    extends c.g
  {
    public hy()
    {
      super("", 10000, false);
    }
  }
  
  public static final class hz
    extends c.g
  {
    public hz()
    {
      super("", 10000, false);
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
      super("reportActionInfo", 234, false);
    }
  }
  
  static final class ib
    extends c.g
  {
    ib()
    {
      super("reportGamePageTime", 301, false);
    }
  }
  
  static final class ic
    extends c.g
  {
    ic()
    {
      super("reportGameWeb", 332, false);
    }
  }
  
  public static final class id
    extends c.g
  {
    public id()
    {
      super("reportIDKey", 163, false);
    }
  }
  
  static final class ie
    extends c.g
  {
    ie()
    {
      super("reportMiniProgramPageData", 284, false);
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
  
  static final class ih
    extends c.g
  {
    ih()
    {
      super("request", 331, false);
    }
  }
  
  static final class ii
    extends c.g
  {
    ii()
    {
      super("requestEntrustAuthorization", 360, true);
    }
  }
  
  static final class ij
    extends c.g
  {
    ij()
    {
      super("requestJointPayment", 358, true);
    }
  }
  
  static final class ik
    extends c.g
  {
    ik()
    {
      super("requestWxFaceRegisterInternal", 272, true);
    }
  }
  
  static final class il
    extends c.g
  {
    il()
    {
      super("requestWxFaceVerifyInternal", 273, true);
    }
  }
  
  static final class im
    extends c.g
  {
    im()
    {
      super("requestWxVoicePrintVerifyInternal", 292, true);
    }
  }
  
  public static final class in
    extends c.g
  {
    public in()
    {
      super("resendRemittanceMsg", 246, true);
    }
  }
  
  public static final class io
    extends c.g
  {
    public io()
    {
      super("resume_download_task", 240, true);
    }
  }
  
  public static final class ip
    extends c.g
  {
    public ip()
    {
      super("scanLicence", 203, false);
    }
  }
  
  public static final class iq
    extends c.g
  {
    public iq()
    {
      super("scanQRCode", 7, true);
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
      super("", 329, false);
    }
  }
  
  static final class it
    extends c.g
  {
    it()
    {
      super("selectContact", 10000, true);
    }
  }
  
  public static final class iu
    extends c.g
  {
    public iu()
    {
      super("selectEnterpriseContact", 286, true);
    }
  }
  
  public static final class iv
    extends c.g
  {
    public iv()
    {
      super("selectPedometerSource", 146, true);
    }
  }
  
  public static final class iw
    extends c.g
  {
    public iw()
    {
      super("selectSingleContact", 167, true);
    }
  }
  
  public static final class ix
    extends c.g
  {
    public ix()
    {
      super("sendAppMessageToSpecifiedContact", 168, true);
    }
  }
  
  public static final class iy
    extends c.g
  {
    public iy()
    {
      super("send_app_msg", 6, true);
    }
  }
  
  public static final class ja
    extends c.g
  {
    public ja()
    {
      super("sendDataToWXDevice", 120, true);
    }
  }
  
  public static final class jb
    extends c.g
  {
    public jb()
    {
      super("sendEnterpriseChat", 222, true);
    }
  }
  
  static final class jc
    extends c.g
  {
    jc()
    {
      super("menuitem:gameSendDesktop", 255, false);
    }
  }
  
  public static final class jd
    extends c.g
  {
    public jd()
    {
      super("send_email", 35, false);
    }
  }
  
  public static final class je
    extends c.g
  {
    public je()
    {
      super("send_service_app_msg", 67, true);
    }
  }
  
  static final class jf
    extends c.g
  {
    jf()
    {
      super("sendSingleAppMessage", 316, true);
    }
  }
  
  static final class jg
    extends c.g
  {
    jg()
    {
      super("serviceClick", 304, false);
    }
  }
  
  static final class jh
    extends c.g
  {
    jh()
    {
      super("setWCPayPassword", 289, true);
    }
  }
  
  static final class ji
    extends c.g
  {
    ji()
    {
      super("setBackgroundAudioState", 262, false);
    }
  }
  
  public static final class jj
    extends c.g
  {
    public jj()
    {
      super("setBounceBackground", 218, false);
    }
  }
  
  public static final class jk
    extends c.g
  {
    public jk()
    {
      super("setCloseWindowConfirmDialogInfo", 77, false);
    }
  }
  
  static final class jl
    extends c.g
  {
    jl()
    {
      super("setGameData", 298, false);
    }
  }
  
  public static final class jm
    extends c.g
  {
    public jm()
    {
      super("", -2, false);
    }
  }
  
  public static final class jn
    extends c.g
  {
    public jn()
    {
      super("setFreeWifiOwner", 169, false);
    }
  }
  
  public static final class jo
    extends c.g
  {
    public jo()
    {
      super("setGameDebugConfig", 1111111, false);
    }
  }
  
  public static final class jp
    extends c.g
  {
    public jp()
    {
      super("setLocalData", 180, false);
    }
  }
  
  public static final class jq
    extends c.g
  {
    public jq()
    {
      super("setNavigationBarButtons", 195, false);
    }
  }
  
  public static final class jr
    extends c.g
  {
    public jr()
    {
      super("setNavigationBarColor", 182, false);
    }
  }
  
  public static final class js
    extends c.g
  {
    public js()
    {
      super("setPageOwner", 114, false);
    }
  }
  
  public static final class jt
    extends c.g
  {
    public jt()
    {
      super("setPageTitle", 113, false);
    }
  }
  
  static final class ju
    extends c.g
  {
    ju()
    {
      super("setScreenOrientation", 270, false);
    }
  }
  
  public static final class jv
    extends c.g
  {
    public jv()
    {
      super("", 10000, false);
    }
  }
  
  public static final class jw
    extends c.g
  {
    public jw()
    {
      super("setSendDataDirection", 127, false);
    }
  }
  
  public static final class jx
    extends c.g
  {
    public jx()
    {
      super("", 10000, false);
    }
  }
  
  public static final class jy
    extends c.g
  {
    public jy()
    {
      super("setStatusBarStyle", 206, false);
    }
  }
  
  static final class jz
    extends c.g
  {
    jz()
    {
      super("shareEmoticon", 275, true);
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
      super("shareQQ", 90, true);
    }
  }
  
  public static final class kb
    extends c.g
  {
    public kb()
    {
      super("shareQZone", 132, true);
    }
  }
  
  public static final class kc
    extends c.g
  {
    public kc()
    {
      super("shareWeiboApp", 107, false);
    }
  }
  
  public static final class kd
    extends c.g
  {
    public kd()
    {
      super("showAllNonBaseMenuItem", 92, false);
    }
  }
  
  public static final class ke
    extends c.g
  {
    public ke()
    {
      super("showDatePickerView", 248, true);
    }
  }
  
  public static final class kf
    extends c.g
  {
    public kf()
    {
      super("showKeyboard", 187, false);
    }
  }
  
  public static final class kg
    extends c.g
  {
    public kg()
    {
      super("showMenuItems", 86, false);
    }
  }
  
  public static final class kh
    extends c.g
  {
    public kh()
    {
      super("showNavigationBarLoading", 197, false);
    }
  }
  
  public static final class ki
    extends c.g
  {
    public ki()
    {
      super("", 14, false);
    }
  }
  
  public static final class kj
    extends c.g
  {
    public kj()
    {
      super("showSearchActionSheet", 10000, false);
    }
  }
  
  public static final class kk
    extends c.g
  {
    public kk()
    {
      super("showSearchLoading", 10000, false);
    }
  }
  
  static final class kl
    extends c.g
  {
    kl()
    {
      super("showSearchOfBizHistory", 266, false);
    }
  }
  
  public static final class km
    extends c.g
  {
    public km()
    {
      super("showSearchToast", 10000, false);
    }
  }
  
  public static final class kn
    extends c.g
  {
    public kn()
    {
      super("showSmileyPanel", 238, false);
    }
  }
  
  public static final class ko
    extends c.g
  {
    public ko()
    {
      super("soter_biometric_authentication", 214, true);
    }
  }
  
  public static final class kp
    extends c.g
  {
    public kp()
    {
      super("getSupportSoter", 213, true);
    }
  }
  
  public static final class kq
    extends c.g
  {
    public kq()
    {
      super("startMonitoringBeacons", 151, false);
    }
  }
  
  public static final class kr
    extends c.g
  {
    public kr()
    {
      super("startPullDownRefresh", 204, false);
    }
  }
  
  public static final class ks
    extends c.g
  {
    public ks()
    {
      super("startRecord", 96, false);
    }
  }
  
  public static final class kt
    extends c.g
  {
    public kt()
    {
      super("startScanWXDevice", 121, true);
    }
  }
  
  public static final class ku
    extends c.g
  {
    public ku()
    {
      super("", 10000, false);
    }
  }
  
  public static final class kv
    extends c.g
  {
    public kv()
    {
      super("startTempSession", 128, true);
    }
  }
  
  public static final class kw
    extends c.g
  {
    public kw()
    {
      super("startVoipCall", 230, false);
    }
  }
  
  public static final class kx
    extends c.g
  {
    public kx()
    {
      super("stopMonitoringBeacons", 152, false);
    }
  }
  
  public static final class ky
    extends c.g
  {
    public ky()
    {
      super("stopPullDownRefresh", 200, false);
    }
  }
  
  public static final class kz
    extends c.g
  {
    public kz()
    {
      super("stopRecord", 98, false);
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
      super("stopScanWXDevice", 122, true);
    }
  }
  
  public static final class lb
    extends c.g
  {
    public lb()
    {
      super("stopVoice", 101, false);
    }
  }
  
  public static final class lc
    extends c.g
  {
    public lc()
    {
      super("playStreamingVideo", 209, false);
    }
  }
  
  public static final class ld
    extends c.g
  {
    public ld()
    {
      super("selectWalletCurrency", 201, true);
    }
  }
  
  static final class le
    extends c.g
  {
    le()
    {
      super("tapSearchWAWidgetView", 10000, false);
    }
  }
  
  public static final class lf
    extends c.g
  {
    public lf()
    {
      super("share_timeline", 4, true);
    }
  }
  
  public static final class lg
    extends c.g
  {
    public lg()
    {
      super("translateVoice", 97, true);
    }
  }
  
  public static final class lh
    extends c.g
  {
    public lh()
    {
      super("unbindBankCard", 216, true);
    }
  }
  
  static final class li
    extends c.g
  {
    li()
    {
      super("updatePageAuth", -2, false);
    }
  }
  
  public static final class lj
    extends c.g
  {
    public lj()
    {
      super("", 10000, false);
    }
  }
  
  static final class lk
    extends c.g
  {
    lk()
    {
      super("updateAppMessageShareData", 326, false);
    }
  }
  
  public static final class ll
    extends c.g
  {
    public ll()
    {
      super("", 10000, false);
    }
  }
  
  static final class lm
    extends c.g
  {
    lm()
    {
      super("updateTimelineShareData", 327, false);
    }
  }
  
  public static final class ln
    extends c.g
  {
    public ln()
    {
      super("", 10000, false);
    }
  }
  
  public static final class lo
    extends c.g
  {
    public lo()
    {
      super("updateWASearchTemplate", 10000, false);
    }
  }
  
  static final class lp
    extends c.g
  {
    lp()
    {
      super("uploadEncryptMediaFile", 253, false);
    }
  }
  
  public static final class lq
    extends c.g
  {
    public lq()
    {
      super("uploadImage", 105, true);
    }
  }
  
  public static final class lr
    extends c.g
  {
    public lr()
    {
      super("uploadMediaFile", 237, true);
    }
  }
  
  public static final class ls
    extends c.g
  {
    public ls()
    {
      super("uploadVideo", 192, true);
    }
  }
  
  public static final class lt
    extends c.g
  {
    public lt()
    {
      super("uploadVoice", 102, true);
    }
  }
  
  public static final class lu
    extends c.g
  {
    public lu()
    {
      super("uxSearchOpLog", 10000, false);
    }
  }
  
  public static final class lv
    extends c.g
  {
    public lv()
    {
      super("verifyWCPayPassword", 115, true);
    }
  }
  
  static final class lw
    extends c.g
  {
    lw()
    {
      super("", 10000, false);
    }
  }
  
  public static final class lx
    extends c.g
  {
    public lx()
    {
      super("", 355, true);
    }
  }
  
  static final class ly
    extends c.g
  {
    ly()
    {
      super("wcPrivacyPolicyResult", 315, false);
    }
  }
  
  public static final class lz
    extends c.g
  {
    public lz()
    {
      super("cache", 150, false);
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
      super("videoProxyInit", 156, false);
    }
  }
  
  public static final class mb
    extends c.g
  {
    public mb()
    {
      super("videoProxySetPlayerState", 159, false);
    }
  }
  
  public static final class mc
    extends c.g
  {
    public mc()
    {
      super("videoProxySetPlayerState", 160, false);
    }
  }
  
  public static final class md
    extends c.g
  {
    public md()
    {
      super("videoProxyStartPlay", 157, false);
    }
  }
  
  public static final class me
    extends c.g
  {
    public me()
    {
      super("videoProxyStopPlay", 158, false);
    }
  }
  
  public static final class mf
    extends c.g
  {
    public mf()
    {
      super("publicCache", 149, false);
    }
  }
  
  public static final class mg
    extends c.g
  {
    public mg()
    {
      super("videoProxyPreload", 172, false);
    }
  }
  
  public static final class mh
    extends c.g
  {
    public mh()
    {
      super("share_weibo", 3, true);
    }
  }
  
  public static final class mi
    extends c.g
  {
    public mi()
    {
      super("", 10000, false);
    }
  }
  
  public static final class mj
    extends c.g
  {
    public mj()
    {
      super("WNNativeAsyncCallback", 10006, false);
    }
  }
  
  public static final class mk
    extends c.g
  {
    public mk()
    {
      super("WNNativeCallbackInitData", 10006, false);
    }
  }
  
  public static final class ml
    extends c.g
  {
    public ml()
    {
      super("WNNativeCallbackOnCaretChange", 10006, false);
    }
  }
  
  public static final class mm
    extends c.g
  {
    public mm()
    {
      super("WNNativeCallbackOnClick", 10006, false);
    }
  }
  
  public static final class mn
    extends c.g
  {
    public mn()
    {
      super("WNNativeCallbackOnLongClick", 10006, false);
    }
  }
  
  public static final class mo
    extends c.g
  {
    public mo()
    {
      super("write_comm_data", 53, false);
    }
  }
  
  static final class mp
    extends c.g
  {
    mp()
    {
      super("calRqt", 319, false);
    }
  }
  
  static final class mq
    extends c.g
  {
    mq()
    {
      super("getCCData", 312, false);
    }
  }
  
  static final class mr
    extends c.g
  {
    mr()
    {
      super("openRealnameAuth", 314, true);
    }
  }
  
  public static final class ms
    extends c.g
  {
    public ms()
    {
      super("WNNativeCallbackOnBecomeEditing", 10006, false);
    }
  }
  
  public static final class mt
    extends c.g
  {
    public mt()
    {
      super("WNNativeCallbackOnBecomeEdited", 10006, false);
    }
  }
  
  public static final class mu
    extends c.g
  {
    public mu()
    {
      super("", 317, true);
    }
  }
  
  public static final class mv
    extends c.g
  {
    public mv()
    {
      super("", 129, false);
    }
  }
  
  public static final class mw
    extends c.g
  {
    public mw()
    {
      super("", 89, false);
    }
  }
  
  public static final class mx
    extends c.g
  {
    public mx()
    {
      super("", 94, false);
    }
  }
  
  public static final class my
    extends c.g
  {
    public my()
    {
      super("", 134, false);
    }
  }
  
  public static final class mz
    extends c.g
  {
    public mz()
    {
      super("", 88, false);
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
      super("", 109, false);
    }
  }
  
  public static final class nb
    extends c.g
  {
    public nb()
    {
      super("", 320, true);
    }
  }
  
  public static final class nc
    extends c.g
  {
    public nc()
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