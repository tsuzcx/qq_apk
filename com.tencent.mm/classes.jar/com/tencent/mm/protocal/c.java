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
  private static Map<String, c.g> YwT;
  public static final String[] YwU;
  
  static
  {
    AppMethodBeat.i(152436);
    YwT = null;
    YwU = (String[])new c.1().toArray(new String[0]);
    AppMethodBeat.o(152436);
  }
  
  public static c.g bsk(String paramString)
  {
    AppMethodBeat.i(152435);
    if ((YwT == null) || (YwT.size() <= 0))
    {
      Object localObject = new HashMap(128);
      YwT = (Map)localObject;
      ((Map)localObject).put("log", new ff());
      YwT.put("imagePreview", new en());
      YwT.put("profile", new ig());
      YwT.put("shareWeibo", new nd());
      YwT.put("shareTimeline", new ma());
      YwT.put("adDataReport", new o());
      YwT.put("streamingVideoPlay", new lx());
      YwT.put("addContact", new h());
      YwT.put("getWidgetCaptureImgUrl", new dx());
      YwT.put("sendAppMessage", new jr());
      YwT.put("vibrateShort", new mr());
      YwT.put("scanQRCode", new jj());
      YwT.put("hideOptionMenu", new ek());
      YwT.put("showOptionMenu", new lb());
      YwT.put("getNetworkType", new cy());
      YwT.put("closeWindow", new aq());
      YwT.put("getInstallState", new ct());
      YwT.put("setFontSizeCallback", new kf());
      YwT.put("jumpToInstallUrl", new eu());
      YwT.put("launchApp", new fa());
      YwT.put("getBrandWCPayRequest", new ce());
      YwT.put("secureTunnel", new jl());
      YwT.put("wcpaySecurityCrosscutBack", new mt());
      YwT.put("editAddress", new bl());
      YwT.put("getHeadingAndPitch", new cq());
      YwT.put("sendEmail", new jw());
      YwT.put("addDownloadTask", new k());
      YwT.put("cancelDownloadTask", new x());
      YwT.put("pauseDownloadTask", new hu());
      YwT.put("resumeDownloadTask", new jh());
      YwT.put("queryDownloadTask", new ij());
      YwT.put("installDownloadTask", new eq());
      YwT.put("getLatestAddress", new dd());
      YwT.put("openSpecificView", new he());
      YwT.put("jumpWCMall", new ew());
      YwT.put("launch3rdApp", new ez());
      YwT.put("writeCommData", new nk());
      YwT.put("openUrlByExtBrowser", new hf());
      YwT.put("geoLocation", new bz());
      YwT.put("getBrandWCPayBindCardRequest", new cd());
      YwT.put("openProductView", new gx());
      YwT.put("openProductViewWithPid", new gy());
      YwT.put("jumpToBizProfile", new ev());
      YwT.put("openTimelineCheckInList", new fm());
      YwT.put("openLocation", new fl());
      YwT.put("timelineCheckIn", new fk());
      YwT.put("getBrandWCPayCreateCreditCardRequest", new hl());
      YwT.put("chooseCard", new ad());
      YwT.put("chooseInvoice", new ah());
      YwT.put("sendServiceAppMessage", new jx());
      YwT.put("musicPlay", new fi());
      YwT.put("mmsf0001", new cj());
      YwT.put("getTransferMoneyRequest", new dt());
      YwT.put("openWCPaySpecificView", new hh());
      YwT.put("setCloseWindowConfirmDialogInfo", new kd());
      YwT.put("batchAddCard", new s());
      YwT.put("preVerifyJSAPI", new id());
      YwT.put("startRecord", new ln());
      YwT.put("stopRecord", new lu());
      YwT.put("playVoice", new hy());
      YwT.put("pauseVoice", new hv());
      YwT.put("stopVoice", new lw());
      YwT.put("uploadVoice", new mo());
      YwT.put("downloadVoice", new bh());
      YwT.put("chooseImage", new ag());
      YwT.put("uploadImage", new ml());
      YwT.put("downloadImage", new bg());
      YwT.put("uploadMediaFile", new mm());
      YwT.put("hideMenuItems", new eh());
      YwT.put("showMenuItems", new ky());
      YwT.put("hideAllNonBaseMenuItem", new eg());
      YwT.put("showAllNonBaseMenuItem", new kv());
      YwT.put("checkJsApi", new ac());
      YwT.put("translateVoice", new mb());
      YwT.put("shareQQ", new ks());
      YwT.put("shareWeiboApp", new ku());
      YwT.put("shareQZone", new kt());
      YwT.put("getSendC2CMessageRequest", new dq());
      YwT.put("batchViewCard", new v());
      YwT.put("configWXDeviceWiFi", new at());
      YwT.put("getCurrentSSID", new ch());
      YwT.put("setPageOwner", new kk());
      YwT.put("getWechatVerifyTicket", new dv());
      YwT.put("openWXDeviceLib", new hm());
      YwT.put("startScanWXDevice", new lo());
      YwT.put("stopScanWXDevice", new lv());
      YwT.put("connectWXDevice", new av());
      YwT.put("disconnectWXDevice", new bf());
      YwT.put("getWXDeviceTicket", new dz());
      YwT.put("getWXDeviceInfos", new dy());
      YwT.put("sendDataToWXDevice", new jt());
      YwT.put("closeWXDeviceLib", new as());
      YwT.put("setSendDataDirection", new ko());
      YwT.put("verifyWCPayPassword", new mq());
      YwT.put("getPaymentOrderRequest", new dc());
      YwT.put("openGameDetail", new gm());
      YwT.put("openGameCenter", new gl());
      YwT.put("setGameDebugConfig", new kg());
      YwT.put("startTempSession", new lq());
      YwT.put("getH5PrepayRequest", new cr());
      YwT.put("getH5TransactionRequest", new cs());
      YwT.put("menu:share:timeline", new nw());
      YwT.put("menu:share:appmessage", new nt());
      YwT.put("menu:share:qq", new nu());
      YwT.put("menu:share:weiboApp", new nx());
      YwT.put("menu:setfont", new ns());
      YwT.put("menu:share:weibo", new nx());
      YwT.put("menu:share:QZone", new nv());
      YwT.put("getRecevieBizHongBaoRequest", new e());
      YwT.put("openCamera", new fy());
      YwT.put("insertVideoPlayer", new ep());
      YwT.put("updateVideoPlayer", new mi());
      YwT.put("removeVideoPlayer", new ir());
      YwT.put("operateVideoPlayer", new hq());
      YwT.put("deleteSearchHistory", new bc());
      YwT.put("getSearchHistory", new dm());
      YwT.put("getSearchData", new di());
      YwT.put("showWeDrawHomeView", new li());
      YwT.put("getFestivalLiveInfo", new cm());
      YwT.put("getChatSearchData", new cf());
      YwT.put("getPoiInfo", new cp());
      YwT.put("updateReddotTimeStamps", new me());
      YwT.put("getTeachSearchData", new ds());
      YwT.put("getSearchGuideData", new dl());
      YwT.put("getSearchAvatarList", new dh());
      YwT.put("getSearchSnsImageList", new do());
      YwT.put("getSearchImageList", new dn());
      YwT.put("getSearchDisplayNameList", new dj());
      YwT.put("startSearchItemDetailPage", new lp());
      YwT.put("reportSearchStatistics", new iy());
      YwT.put("reportSearchRealTimeStatistics", new ix());
      YwT.put("searchDataHasResult", new jk());
      YwT.put("openEmotionPage", new bv());
      YwT.put("getSearchSuggestionData", new dp());
      YwT.put("setSearchInputWord", new kn());
      YwT.put("setSnsObjectXmlDescList", new kp());
      YwT.put("clickSnsMusicPlayButton", new ap());
      YwT.put("openWeAppPage", new hk());
      YwT.put("reportWeAppSearchRealtime", new ne());
      YwT.put("doSearchOperation", new bk());
      YwT.put("insertSearchWAWidgetView", new eo());
      YwT.put("removeSearchWAWidgetView", new iq());
      YwT.put("updateSearchWAWidgetView", new mg());
      YwT.put("showSearchActionSheet", new lc());
      YwT.put("cancelSearchActionSheet", new z());
      YwT.put("showSearchToast", new lf());
      YwT.put("showSearchLoading", new ld());
      YwT.put("hideSearchLoading", new el());
      YwT.put("updateWASearchTemplate", new mj());
      YwT.put("preloadSearchWeapp", new ib());
      YwT.put("uxSearchOpLog", new mp());
      YwT.put("querySearchWeb", new bx());
      YwT.put("openFinderProfile", new gk());
      YwT.put("playMusic", new hx());
      YwT.put("openMusicPage", new gt());
      YwT.put("openFinderFeed", new gj());
      YwT.put("getCurrentLocation", new cg());
      YwT.put("navControl", new fj());
      YwT.put("showNavBarShadow", new la());
      YwT.put("hideNavBarShadow", new ej());
      YwT.put("jumpToWXWallet", new ex());
      YwT.put("scanCover", new f());
      YwT.put("reportActionInfo", new is());
      YwT.put("openMyDeviceProfile", new gu());
      YwT.put("selectPedometerSource", new jo());
      YwT.put("nfcIsConnect", new fs());
      YwT.put("nfcConnect", new fp());
      YwT.put("nfcTransceive", new ft());
      YwT.put("nfcBatchTransceive", new fn());
      YwT.put("nfcGetId", new fq());
      YwT.put("nfcGetInfo", new fr());
      YwT.put("startMonitoringBeacons", new ll());
      YwT.put("stopMonitoringBeacons", new ls());
      YwT.put("nfcCheckState", new fo());
      YwT.put("videoProxyInit", new mw());
      YwT.put("videoProxyStartPlay", new mz());
      YwT.put("videoProxyStopPlay", new na());
      YwT.put("videoProxySetPlayerState", new mx());
      YwT.put("videoProxySetRemainTime", new my());
      YwT.put("videoProxyPreload", new nc());
      YwT.put("getWebPayCheckoutCounterRequst", new fe());
      YwT.put("addCustomMenuItems", new i());
      YwT.put("operateGameCenterMsg", new hp());
      YwT.put("openEnterpriseChat", new gh());
      YwT.put("enterEnterpriseChat", new bp());
      YwT.put("openEnterpriseContact", new gi());
      YwT.put("selectEnterpriseContact", new jn());
      YwT.put("getEnterpriseChat", new cl());
      YwT.put("reportIDKey", new iv());
      YwT.put("quicklyAddBrandContact", new im());
      YwT.put("consumedShareCard", new aw());
      YwT.put("cache", new mv());
      YwT.put("publicCache", new nb());
      YwT.put("kvReport", new ey());
      YwT.put("realtimeReport", new in());
      YwT.put("openUrlWithExtraWebview", new hg());
      YwT.put("selectSingleContact", new jp());
      YwT.put("sendAppMessageToSpecifiedContact", new jq());
      YwT.put("setLocalData", new kh());
      YwT.put("getLocalData", new cu());
      YwT.put("clearLocalData", new an());
      YwT.put("showKeyboard", new kx());
      YwT.put("showSmileyPanel", new lg());
      YwT.put("disableBounceScroll", new bd());
      YwT.put("clearBounceBackground", new al());
      YwT.put("setNavigationBarButtons", new ki());
      YwT.put("enableFullScreen", new bn());
      YwT.put("showNavigationBarLoading", new kz());
      YwT.put("hideNavigationBarLoading", new ei());
      YwT.put("enablePullDownRefresh", new bo());
      YwT.put("startPullDownRefresh", new lm());
      YwT.put("stopPullDownRefresh", new lt());
      YwT.put("disablePullDownRefresh", new be());
      YwT.put("setPageTitle", new kl());
      YwT.put("setStatusBarStyle", new kq());
      YwT.put("deleteAccountSuccess", new bb());
      YwT.put("chooseVideo", new ak());
      YwT.put("uploadVideo", new mn());
      YwT.put("openMapNavigateMenu", new gs());
      YwT.put("setNavigationBarColor", new kj());
      YwT.put("getWCPayRealnameVerify", new du());
      YwT.put("openDesignerEmojiView", new gb());
      YwT.put("openDesignerProfile", new gd());
      YwT.put("openEmoticonTopicList", new gg());
      YwT.put("openDesignerEmojiViewLocal", new gc());
      YwT.put("openDesignerProfileLocal", new ge());
      YwT.put("openEmotionDetailViewLocal", new d());
      YwT.put("openNewPage", new gv());
      YwT.put("getSearchEmotionData", new dk());
      YwT.put("openEmotionUrl", new bm());
      YwT.put("WNNativeCallbackOnClick", new ni());
      YwT.put("WNNativeCallbackOnLongClick", new nj());
      YwT.put("WNNativeCallbackOnCaretChange", new nh());
      YwT.put("WNNativeCallbackInitData", new ng());
      YwT.put("WNNativeAsyncCallback", new nf());
      YwT.put("WNNativeCallbackOnBecomeEditing", new np());
      YwT.put("WNNativeCallbackOnBecomeEdited", new nq());
      YwT.put("changePayActivityView", new aa());
      YwT.put("selectWalletCurrency", new ly());
      YwT.put("scanLicence", new ji());
      YwT.put("operateMusicPlayer", new b());
      YwT.put("getMusicPlayerState", new a());
      YwT.put("clearWebviewCache", new ao());
      YwT.put("requireSoterBiometricAuthentication", new lj());
      YwT.put("getSupportSoter", new lk());
      YwT.put("unbindBankCard", new mc());
      YwT.put("setBounceBackground", new kc());
      YwT.put("sendEnterpriseChat", new ju());
      YwT.put("doExposePreparation", new bj());
      YwT.put("getMsgProofItems", new cx());
      YwT.put("openSecurityView", new hc());
      YwT.put("startVoipCall", new lr());
      YwT.put("chooseInvoiceTitle", new ai());
      YwT.put("getOpenDeviceId", new da());
      YwT.put("getRouteUrl", new dg());
      YwT.put("idCardRealnameVerify", new em());
      YwT.put("uploadIdCardSuccess", new nz());
      YwT.put("showDatePickerView", new kw());
      YwT.put("openLuckyMoneyDetailView", new gq());
      YwT.put("resendRemittanceMsg", new jg());
      YwT.put("getGameCommInfo", new co());
      YwT.put("openGameRegion", new gn());
      YwT.put("chooseIdCard", new af());
      YwT.put("getLocalImgData", new c());
      YwT.put("openWeApp", new hj());
      YwT.put("recordVideo", new io());
      YwT.put("previewVideo", new ic());
      YwT.put("uploadEncryptMediaFile", new mk());
      YwT.put("chooseMedia", new aj());
      YwT.put("requestWxFacePictureVerify", new bq());
      YwT.put("openCustomWebview", new ga());
      YwT.put("forceUpdateWxaAttr", new bu());
      YwT.put("openLuckyMoneyHistory", new gr());
      YwT.put("menuitem:gameSendDesktop", new jv());
      YwT.put("getWePkgAuthResult", new dw());
      YwT.put("getLocalWePkgInfo", new cv());
      YwT.put("openGameWebView", new gp());
      YwT.put("reportGameWeb", new iu());
      YwT.put("launchApplication", new fb());
      YwT.put("showSearchOfBizHistory", new le());
      YwT.put("login", new fg());
      YwT.put("authorize", new r());
      YwT.put("requestWxFacePictureVerifyUnionVideo", new br());
      YwT.put("checkIsSupportFaceDetect", new ab());
      YwT.put("operateBackgroundAudio", new ho());
      YwT.put("setBackgroundAudioState", new kb());
      YwT.put("getBackgroundAudioState", new cb());
      YwT.put("addDownloadTaskStraight", new l());
      YwT.put("setScreenOrientation", new km());
      YwT.put("addToEmoticon", new n());
      YwT.put("shareEmoticon", new kr());
      YwT.put("makePhoneCall", new fh());
      YwT.put("openADCanvas", new fz());
      YwT.put("openSearchCanvas", new gz());
      YwT.put("opVoteAdData", new ht());
      YwT.put("opJumpView", new hs());
      YwT.put("opAdH5Func", new hr());
      YwT.put("requestWxFaceRegisterInternal", new jd());
      YwT.put("requestWxFaceVerifyInternal", new je());
      YwT.put("launchMiniProgram", new fd());
      YwT.put("reportMiniProgramPageData", new iw());
      YwT.put("selectContact", new jm());
      YwT.put("openSearchWAWidgetLogView", new ha());
      YwT.put("reloadSearchWAWidgetData", new ip());
      YwT.put("gotoEmoticonPad", new ea());
      YwT.put("querySimilarEmotion", new il());
      YwT.put("closeWindowAndGoNext", new ar());
      YwT.put("requestWxVoicePrintVerifyInternal", new jf());
      YwT.put("openBizChat", new fx());
      YwT.put("handleWCPayWalletBuffer", new ef());
      YwT.put("tapSearchWAWidgetView", new lz());
      YwT.put("getMatchContactList", new cw());
      YwT.put("openSearchWebView", new hb());
      YwT.put("openWXSearchPage", new hn());
      YwT.put("viewTypeChange", new ms());
      YwT.put("invokeMiniProgramAPI", new es());
      YwT.put("openGameUrlWithExtraWebView", new go());
      YwT.put("setGameData", new ke());
      YwT.put("getGameData", new ci());
      YwT.put("clearGameData", new am());
      YwT.put("openECard", new gf());
      YwT.put("reportGamePageTime", new it());
      YwT.put("setWCPayPassword", new ka());
      YwT.put("openWCPayCardList", new fw());
      YwT.put("bindEmail", new w());
      YwT.put("openOfflinePayView", new gw());
      YwT.put("bindEmail", new w());
      YwT.put("doGoToRecVideoList", new de());
      YwT.put("jumpWSRecVideoList", new nr());
      YwT.put("openWebSearchOutLinkItem", new ny());
      YwT.put("recordHistory", new by());
      localObject = iPA().iterator();
      while (((Iterator)localObject).hasNext())
      {
        c.g localg = (c.g)((Iterator)localObject).next();
        YwT.put(localg.getName(), localg);
      }
      YwT.put("getSystemInfo", new dr());
      YwT.put("serviceClick", new jz());
      YwT.put("openRealnameAuth", new no());
      YwT.put("sendSingleAppMessage", new jy());
      YwT.put("wcPrivacyPolicyResult", new mu());
      YwT.put("currentMpInfo", new ay());
      YwT.put("updateAppMessageShareData", new mf());
      YwT.put("updateTimelineShareData", new mh());
      YwT.put("getCCData", new nm());
      YwT.put("calRqt", new nl());
      YwT.put("faceVerifyForPay", new bs());
      YwT.put("request", new iz());
      YwT.put("notifyPageInfo", new fu());
      YwT.put("updatePageAuth", new md());
      YwT.put("jumpDownloaderWidget", new et());
      YwT.put("batchUpdateWepkg", new u());
      YwT.put("addGameDownloadTask", new m());
      YwT.put("internelWxFaceVerify", new er());
      YwT.put("getDownloadWidgetTaskInfos", new ck());
      YwT.put("chooseHaowanMedia", new ae());
      YwT.put("queryHaowanPublish", new ik());
      YwT.put("publishHaowanEdition", new ih());
      YwT.put("cancelHaowanPublish", new y());
      YwT.put("launchGameVideoEditor", new fc());
      YwT.put("requestJointPayment", new jb());
      YwT.put("openSelectPayment", new hd());
      YwT.put("requestEntrustAuthorization", new ja());
      YwT.put("buyWCCoin", new nn());
      YwT.put("consumeWCCoin", new ax());
      YwT.put("showWCCoinFirstBuyCoinTips", new lh());
      YwT.put("getOAID", new cz());
      YwT.put("qqMailLoginResult", new ii());
      YwT.put("getFinderLivePreviewUrl", new c.cn());
      YwT.put("getFinderLivePreviewMicCover", new c.cn());
    }
    paramString = (c.g)YwT.get(paramString);
    AppMethodBeat.o(152435);
    return paramString;
  }
  
  private static List<c.g> iPA()
  {
    AppMethodBeat.i(257316);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new c.ba());
    localLinkedList.add(new c.az());
    localLinkedList.add(new c.ca());
    localLinkedList.add(new ee());
    localLinkedList.add(new c.eb());
    localLinkedList.add(new ia());
    localLinkedList.add(new hz());
    localLinkedList.add(new c.js());
    localLinkedList.add(new c.ec());
    localLinkedList.add(new ed());
    localLinkedList.add(new c.j());
    localLinkedList.add(new c.if());
    localLinkedList.add(new c.ie());
    localLinkedList.add(new bw());
    localLinkedList.add(new c.hi());
    localLinkedList.add(new au());
    localLinkedList.add(new c.db());
    localLinkedList.add(new c.df());
    localLinkedList.add(new c.t());
    localLinkedList.add(new fv());
    localLinkedList.add(new hw());
    localLinkedList.add(new bt());
    localLinkedList.add(new jc());
    localLinkedList.add(new p());
    localLinkedList.add(new q());
    localLinkedList.add(new cc());
    localLinkedList.add(new bi());
    AppMethodBeat.o(257316);
    return localLinkedList;
  }
  
  public static Bundle iPz()
  {
    AppMethodBeat.i(257314);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("handle", true);
    localBundle.putString("handle_result", null);
    AppMethodBeat.o(257314);
    return localBundle;
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
    ax()
    {
      super("consumeWCCoin", 409, true);
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
  
  static final class bi
    extends c.g
  {
    bi()
    {
      super("doAuthCurrentUrl", 397, false);
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
      super("fastBindCardGetResult", 402, false);
    }
  }
  
  static final class bu
    extends c.g
  {
    bu()
    {
      super("forceUpdateWxaAttr", 257, false);
    }
  }
  
  public static final class bv
    extends c.g
  {
    public bv()
    {
      super("", 10000, false);
    }
  }
  
  static final class bw
    extends c.g
  {
    bw()
    {
      super("openBusinessView", 338, true);
    }
  }
  
  public static final class bx
    extends c.g
  {
    public bx()
    {
      super("", 10000, false);
    }
  }
  
  static final class by
    extends c.g
  {
    by()
    {
      super("recordHistory", 219, false);
    }
  }
  
  public static final class bz
    extends c.g
  {
    public bz()
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
  
  static final class cb
    extends c.g
  {
    cb()
    {
      super("getBackgroundAudioState", 263, false);
    }
  }
  
  static final class cc
    extends c.g
  {
    cc()
    {
      super("requestBindPhoneNumber", 387, false);
    }
  }
  
  public static final class cd
    extends c.g
  {
    public cd()
    {
      super("get_brand_WCPay_bind_card_request", 58, true);
    }
  }
  
  public static final class ce
    extends c.g
  {
    public ce()
    {
      super("get_brand_wcpay_request", 28, true);
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
      super("", 10000, false);
    }
  }
  
  public static final class ch
    extends c.g
  {
    public ch()
    {
      super("getCurrentSSID", 176, true);
    }
  }
  
  static final class ci
    extends c.g
  {
    ci()
    {
      super("getGameData", 299, false);
    }
  }
  
  public static final class cj
    extends c.g
  {
    public cj()
    {
      super("mmsf0001", -2, false);
    }
  }
  
  static final class ck
    extends c.g
  {
    ck()
    {
      super("getDownloadWidgetTaskInfos", 340, false);
    }
  }
  
  public static final class cl
    extends c.g
  {
    public cl()
    {
      super("getEnterpriseChat", 244, false);
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
  
  public static final class co
    extends c.g
  {
    public co()
    {
      super("getGameCommInfo", 241, false);
    }
  }
  
  public static final class cp
    extends c.g
  {
    public cp()
    {
      super("", 10000, false);
    }
  }
  
  public static final class cq
    extends c.g
  {
    public cq()
    {
      super("get_heading_and_pitch", 33, false);
    }
  }
  
  public static final class cr
    extends c.g
  {
    public cr()
    {
      super("getH5PrepayRequest", 137, true);
    }
  }
  
  public static final class cs
    extends c.g
  {
    public cs()
    {
      super("getH5TransactionRequest", 138, true);
    }
  }
  
  public static final class ct
    extends c.g
  {
    public ct()
    {
      super("get_install_state", 25, false);
    }
  }
  
  public static final class cu
    extends c.g
  {
    public cu()
    {
      super("getLocalData", 179, false);
    }
  }
  
  static final class cv
    extends c.g
  {
    cv()
    {
      super("getLocalWePkgInfo", -2, false);
    }
  }
  
  static final class cw
    extends c.g
  {
    cw()
    {
      super("getMatchContactList", 10000, false);
    }
  }
  
  public static final class cx
    extends c.g
  {
    public cx()
    {
      super("getMsgProofItems", 226, true);
    }
  }
  
  public static final class cy
    extends c.g
  {
    public cy()
    {
      super("network_type", 16, false);
    }
  }
  
  static final class cz
    extends c.g
  {
    cz()
    {
      super("getOAID", 361, false);
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
      super("getOpenDeviceId", 227, false);
    }
  }
  
  public static final class dc
    extends c.g
  {
    public dc()
    {
      super("getPaymentOrderRequest", 116, true);
    }
  }
  
  public static final class dd
    extends c.g
  {
    public dd()
    {
      super("get_recently_used_address", 46, true);
    }
  }
  
  static final class de
    extends c.g
  {
    de()
    {
      super("doGoToRecVideoList", 10000, false);
    }
  }
  
  public static final class dg
    extends c.g
  {
    public dg()
    {
      super("getRouteUrl", 235, false);
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
      super("getSearchDisplayNameList", 10000, false);
    }
  }
  
  public static final class dk
    extends c.g
  {
    public dk()
    {
      super("getSearchEmotionData", 20000, false);
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
      super("", 10000, false);
    }
  }
  
  public static final class do
    extends c.g
  {
    public do()
    {
      super("", 10000, false);
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
      super("get_send_c2c_message_request", 83, true);
    }
  }
  
  static final class dr
    extends c.g
  {
    dr()
    {
      super("getSystemInfo", 311, false);
    }
  }
  
  public static final class ds
    extends c.g
  {
    public ds()
    {
      super("", 10000, false);
    }
  }
  
  public static final class dt
    extends c.g
  {
    public dt()
    {
      super("get_transfer_money_request", 74, true);
    }
  }
  
  public static final class du
    extends c.g
  {
    public du()
    {
      super("getWCPayRealnameVerify", 194, true);
    }
  }
  
  public static final class dv
    extends c.g
  {
    public dv()
    {
      super("getWechatVerifyTicket", 112, false);
    }
  }
  
  static final class dw
    extends c.g
  {
    dw()
    {
      super("getWePkgAuthResult", -3, false);
    }
  }
  
  public static final class dx
    extends c.g
  {
    public dx()
    {
      super("add_contact", 10000, false);
    }
  }
  
  public static final class dy
    extends c.g
  {
    public dy()
    {
      super("getWXDeviceInfos", 119, true);
    }
  }
  
  public static final class dz
    extends c.g
  {
    public dz()
    {
      super("getWXDeviceTicket", 125, true);
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
      super("", 10000, false);
    }
  }
  
  static final class ed
    extends c.g
  {
    ed()
    {
      super("handleMPPageAction", 345, true);
    }
  }
  
  static final class ee
    extends c.g
  {
    ee()
    {
      super("handleVideoAction", 371, false);
    }
  }
  
  static final class ef
    extends c.g
  {
    ef()
    {
      super("handleWCPayWalletBuffer", 294, false);
    }
  }
  
  public static final class eg
    extends c.g
  {
    public eg()
    {
      super("hideAllNonBaseMenuItem", 93, false);
    }
  }
  
  public static final class eh
    extends c.g
  {
    public eh()
    {
      super("hideMenuItems", 85, false);
    }
  }
  
  public static final class ei
    extends c.g
  {
    public ei()
    {
      super("hideNavigationBarLoading", 198, false);
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
      super("", 14, false);
    }
  }
  
  public static final class el
    extends c.g
  {
    public el()
    {
      super("hideSearchLoading", 10000, false);
    }
  }
  
  public static final class em
    extends c.g
  {
    public em()
    {
      super("idCardRealnameVerify", 235, true);
    }
  }
  
  public static final class en
    extends c.g
  {
    public en()
    {
      super("", 1, true);
    }
  }
  
  public static final class eo
    extends c.g
  {
    public eo()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ep
    extends c.g
  {
    public ep()
    {
      super("", 10000, false);
    }
  }
  
  public static final class eq
    extends c.g
  {
    public eq()
    {
      super("install_download_task", 41, false);
    }
  }
  
  public static final class er
    extends c.g
  {
    er()
    {
      super("internelWxFaceVerify", 325, true);
    }
  }
  
  static final class es
    extends c.g
  {
    es()
    {
      super("invokeMiniProgramAPI", 295, false);
    }
  }
  
  static final class et
    extends c.g
  {
    et()
    {
      super("jumpDownloaderWidget", 339, true);
    }
  }
  
  public static final class eu
    extends c.g
  {
    public eu()
    {
      super("", 26, false);
    }
  }
  
  public static final class ev
    extends c.g
  {
    public ev()
    {
      super("jump_to_biz_profile", 61, true);
    }
  }
  
  public static final class ew
    extends c.g
  {
    public ew()
    {
      super("jump_wcmall", 51, true);
    }
  }
  
  public static final class ex
    extends c.g
  {
    public ex()
    {
      super("jumpToWXWallet", 147, true);
    }
  }
  
  public static final class ey
    extends c.g
  {
    public ey()
    {
      super("kvReport", 170, false);
    }
  }
  
  public static final class ez
    extends c.g
  {
    public ez()
    {
      super("launch_3rdApp", 52, true);
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
      super("", 27, false);
    }
  }
  
  static final class fb
    extends c.g
  {
    fb()
    {
      super("launchApplication", 260, true);
    }
  }
  
  static final class fc
    extends c.g
  {
    fc()
    {
      super("launchGameVideoEditor", 350, true);
    }
  }
  
  static final class fd
    extends c.g
  {
    fd()
    {
      super("launchMiniProgram", 277, true);
    }
  }
  
  public static final class fe
    extends c.g
  {
    public fe()
    {
      super("getWebPayCheckoutCounterRequst", 161, true);
    }
  }
  
  public static final class ff
    extends c.g
  {
    public ff()
    {
      super("", 0, false);
    }
  }
  
  static final class fg
    extends c.g
  {
    fg()
    {
      super("login", 231, true);
    }
  }
  
  static final class fh
    extends c.g
  {
    fh()
    {
      super("makePhoneCall", 356, true);
    }
  }
  
  public static final class fi
    extends c.g
  {
    public fi()
    {
      super("playMusic", 69, false);
    }
  }
  
  public static final class fj
    extends c.g
  {
    public fj()
    {
      super("", 10000, false);
    }
  }
  
  public static final class fk
    extends c.g
  {
    public fk()
    {
      super("timeline_check_in", 64, false);
    }
  }
  
  public static final class fl
    extends c.g
  {
    public fl()
    {
      super("open_location", 63, true);
    }
  }
  
  public static final class fm
    extends c.g
  {
    public fm()
    {
      super("open_timeline_checkin_list", 62, false);
    }
  }
  
  public static final class fn
    extends c.g
  {
    public fn()
    {
      super("nfcBatchTransceive", 142, false);
    }
  }
  
  public static final class fo
    extends c.g
  {
    public fo()
    {
      super("nfcCheckState", 155, true);
    }
  }
  
  public static final class fp
    extends c.g
  {
    public fp()
    {
      super("nfcConnect", 140, false);
    }
  }
  
  public static final class fq
    extends c.g
  {
    public fq()
    {
      super("nfcGetId", 143, false);
    }
  }
  
  public static final class fr
    extends c.g
  {
    public fr()
    {
      super("nfcGetInfo", 148, false);
    }
  }
  
  public static final class fs
    extends c.g
  {
    public fs()
    {
      super("nfcIsConnect", 139, true);
    }
  }
  
  public static final class ft
    extends c.g
  {
    public ft()
    {
      super("nfcTransceive", 141, false);
    }
  }
  
  static final class fu
    extends c.g
  {
    fu()
    {
      super("notifyPageInfo", -2, false);
    }
  }
  
  static final class fv
    extends c.g
  {
    fv()
    {
      super("onWebPageUrlExposed", 373, false);
    }
  }
  
  static final class fw
    extends c.g
  {
    fw()
    {
      super("openWCPayCardList", 310, true);
    }
  }
  
  static final class fx
    extends c.g
  {
    fx()
    {
      super("openBizChat", 296, true);
    }
  }
  
  public static final class fy
    extends c.g
  {
    public fy()
    {
      super("openCamera", 10008, true);
    }
  }
  
  static final class fz
    extends c.g
  {
    fz()
    {
      super("openADCanvas", 283, true);
    }
  }
  
  static final class ga
    extends c.g
  {
    ga()
    {
      super("openCustomWebview", 256, false);
    }
  }
  
  public static final class gb
    extends c.g
  {
    public gb()
    {
      super("openDesignerEmojiView", 185, true);
    }
  }
  
  public static final class gc
    extends c.g
  {
    public gc()
    {
      super("openDesignerEmojiViewLocal", 20000, false);
    }
  }
  
  public static final class gd
    extends c.g
  {
    public gd()
    {
      super("openDesignerProfile", 193, true);
    }
  }
  
  public static final class ge
    extends c.g
  {
    public ge()
    {
      super("openDesignerProfileLocal", 20000, false);
    }
  }
  
  static final class gf
    extends c.g
  {
    gf()
    {
      super("openECard", 268, true);
    }
  }
  
  public static final class gg
    extends c.g
  {
    public gg()
    {
      super("openEmoticonTopicList", 212, true);
    }
  }
  
  public static final class gh
    extends c.g
  {
    public gh()
    {
      super("openEnterpriseChat", 165, false);
    }
  }
  
  public static final class gi
    extends c.g
  {
    public gi()
    {
      super("openEnterpriseContact", 183, true);
    }
  }
  
  public static final class gj
    extends c.g
  {
    public gj()
    {
      super("", 10000, false);
    }
  }
  
  public static final class gk
    extends c.g
  {
    public gk()
    {
      super("", 10000, false);
    }
  }
  
  public static final class gl
    extends c.g
  {
    public gl()
    {
      super("openGameCenter", 175, true);
    }
  }
  
  public static final class gm
    extends c.g
  {
    public gm()
    {
      super("openGameDetail", 131, true);
    }
  }
  
  public static final class gn
    extends c.g
  {
    public gn()
    {
      super("openGameRegion", 242, true);
    }
  }
  
  static final class go
    extends c.g
  {
    go()
    {
      super("openGameUrlWithExtraWebView", 297, false);
    }
  }
  
  static final class gp
    extends c.g
  {
    gp()
    {
      super("openGameWebView", 287, false);
    }
  }
  
  public static final class gq
    extends c.g
  {
    public gq()
    {
      super("openLuckyMoneyDetailView", 245, false);
    }
  }
  
  static final class gr
    extends c.g
  {
    gr()
    {
      super("openLuckyMoneyHistory", 258, true);
    }
  }
  
  public static final class gs
    extends c.g
  {
    public gs()
    {
      super("openMapNavigateMenu", 184, true);
    }
  }
  
  public static final class gt
    extends c.g
  {
    public gt()
    {
      super("", 10000, false);
    }
  }
  
  public static final class gu
    extends c.g
  {
    public gu()
    {
      super("openMyDeviceProfile", 145, false);
    }
  }
  
  public static final class gv
    extends c.g
  {
    public gv()
    {
      super("openNewPage", 20000, false);
    }
  }
  
  static final class gw
    extends c.g
  {
    gw()
    {
      super("openOfflinePayView", 305, true);
    }
  }
  
  public static final class gx
    extends c.g
  {
    public gx()
    {
      super("open_product_view", 59, true);
    }
  }
  
  public static final class gy
    extends c.g
  {
    public gy()
    {
      super("open_product_view", 60, true);
    }
  }
  
  static final class gz
    extends c.g
  {
    gz()
    {
      super("openSearchCanvas", 283, true);
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
      super("openSearchWAWidgetLogView", 10000, true);
    }
  }
  
  static final class hb
    extends c.g
  {
    hb()
    {
      super("openSearchWebView", 10000, true);
    }
  }
  
  public static final class hc
    extends c.g
  {
    public hc()
    {
      super("openSecurityView", 229, false);
    }
  }
  
  static final class hd
    extends c.g
  {
    hd()
    {
      super("openSelectPayment", 359, true);
    }
  }
  
  public static final class he
    extends c.g
  {
    public he()
    {
      super("specific_view", 48, true);
    }
  }
  
  public static final class hf
    extends c.g
  {
    public hf()
    {
      super("open_url_by_ext_browser", 55, false);
    }
  }
  
  public static final class hg
    extends c.g
  {
    public hg()
    {
      super("openUrlWithExtraWebview", 173, false);
    }
  }
  
  public static final class hh
    extends c.g
  {
    public hh()
    {
      super("open_wcpay_specific_view", 76, true);
    }
  }
  
  static final class hj
    extends c.g
  {
    hj()
    {
      super("openWeApp", 250, false);
    }
  }
  
  public static final class hk
    extends c.g
  {
    public hk()
    {
      super("", 10000, false);
    }
  }
  
  public static final class hl
    extends c.g
  {
    public hl()
    {
      super("get_wcpay_create_credit_card_request", 65, true);
    }
  }
  
  public static final class hm
    extends c.g
  {
    public hm()
    {
      super("openWXDeviceLib", 117, false);
    }
  }
  
  static final class hn
    extends c.g
  {
    hn()
    {
      super("openWXSearchPage", 309, true);
    }
  }
  
  static final class ho
    extends c.g
  {
    ho()
    {
      super("operateBackgroundAudio", 261, false);
    }
  }
  
  public static final class hp
    extends c.g
  {
    public hp()
    {
      super("operateGameCenterMsg", 174, false);
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
  
  static final class hr
    extends c.g
  {
    hr()
    {
      super("", -2, false);
    }
  }
  
  static final class hs
    extends c.g
  {
    hs()
    {
      super("", -2, false);
    }
  }
  
  static final class ht
    extends c.g
  {
    ht()
    {
      super("", -2, false);
    }
  }
  
  public static final class hu
    extends c.g
  {
    public hu()
    {
      super("cancel_download_task", 239, false);
    }
  }
  
  public static final class hv
    extends c.g
  {
    public hv()
    {
      super("pauseVoice", 100, false);
    }
  }
  
  static final class hw
    extends c.g
  {
    hw()
    {
      super("phoneBindCardVerifySms", 370, false);
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
      super("playVoice", 99, false);
    }
  }
  
  static final class hz
    extends c.g
  {
    public hz()
    {
      super("preloadMiniProgramContacts", 303, false);
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
      super("preloadMiniProgramEnv", 302, false);
    }
  }
  
  public static final class ib
    extends c.g
  {
    public ib()
    {
      super("preloadSearchWeapp", 10000, false);
    }
  }
  
  static final class ic
    extends c.g
  {
    ic()
    {
      super("previewVideo", 252, true);
    }
  }
  
  public static final class id
    extends c.g
  {
    public id()
    {
      super("pre_verify_jsapi", -3, false);
    }
  }
  
  public static final class ig
    extends c.g
  {
    public ig()
    {
      super("profile", 2, false);
    }
  }
  
  static final class ih
    extends c.g
  {
    ih()
    {
      super("publishHaowanEdition", 351, false);
    }
  }
  
  static final class ii
    extends c.g
  {
    ii()
    {
      super("qqMailLoginResult", 357, false);
    }
  }
  
  public static final class ij
    extends c.g
  {
    public ij()
    {
      super("query_download_task", 40, false);
    }
  }
  
  static final class ik
    extends c.g
  {
    ik()
    {
      super("queryHaowanPublish", 352, false);
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
      super("quicklyAddBrandContact", 166, true);
    }
  }
  
  public static final class in
    extends c.g
  {
    public in()
    {
      super("realtimeReport", 171, false);
    }
  }
  
  static final class io
    extends c.g
  {
    io()
    {
      super("recordVideo", 251, true);
    }
  }
  
  public static final class ip
    extends c.g
  {
    public ip()
    {
      super("", 10000, false);
    }
  }
  
  public static final class iq
    extends c.g
  {
    public iq()
    {
      super("", 10000, false);
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
      super("reportActionInfo", 234, false);
    }
  }
  
  static final class it
    extends c.g
  {
    it()
    {
      super("reportGamePageTime", 301, false);
    }
  }
  
  static final class iu
    extends c.g
  {
    iu()
    {
      super("reportGameWeb", 332, false);
    }
  }
  
  public static final class iv
    extends c.g
  {
    public iv()
    {
      super("reportIDKey", 163, false);
    }
  }
  
  static final class iw
    extends c.g
  {
    iw()
    {
      super("reportMiniProgramPageData", 284, false);
    }
  }
  
  public static final class ix
    extends c.g
  {
    public ix()
    {
      super("", 10000, false);
    }
  }
  
  public static final class iy
    extends c.g
  {
    public iy()
    {
      super("", 10000, false);
    }
  }
  
  static final class iz
    extends c.g
  {
    iz()
    {
      super("request", 331, false);
    }
  }
  
  static final class ja
    extends c.g
  {
    ja()
    {
      super("requestEntrustAuthorization", 360, true);
    }
  }
  
  static final class jb
    extends c.g
  {
    jb()
    {
      super("requestJointPayment", 358, true);
    }
  }
  
  static final class jc
    extends c.g
  {
    jc()
    {
      super("requestQueryCashier", 374, false);
    }
  }
  
  static final class jd
    extends c.g
  {
    jd()
    {
      super("requestWxFaceRegisterInternal", 272, true);
    }
  }
  
  static final class je
    extends c.g
  {
    je()
    {
      super("requestWxFaceVerifyInternal", 273, true);
    }
  }
  
  static final class jf
    extends c.g
  {
    jf()
    {
      super("requestWxVoicePrintVerifyInternal", 292, true);
    }
  }
  
  public static final class jg
    extends c.g
  {
    public jg()
    {
      super("resendRemittanceMsg", 246, true);
    }
  }
  
  public static final class jh
    extends c.g
  {
    public jh()
    {
      super("resume_download_task", 240, true);
    }
  }
  
  public static final class ji
    extends c.g
  {
    public ji()
    {
      super("scanLicence", 203, false);
    }
  }
  
  public static final class jj
    extends c.g
  {
    public jj()
    {
      super("scanQRCode", 7, true);
    }
  }
  
  public static final class jk
    extends c.g
  {
    public jk()
    {
      super("", 10000, false);
    }
  }
  
  public static final class jl
    extends c.g
  {
    public jl()
    {
      super("", 329, false);
    }
  }
  
  static final class jm
    extends c.g
  {
    jm()
    {
      super("selectContact", 10000, true);
    }
  }
  
  public static final class jn
    extends c.g
  {
    public jn()
    {
      super("selectEnterpriseContact", 286, true);
    }
  }
  
  public static final class jo
    extends c.g
  {
    public jo()
    {
      super("selectPedometerSource", 146, true);
    }
  }
  
  public static final class jp
    extends c.g
  {
    public jp()
    {
      super("selectSingleContact", 167, true);
    }
  }
  
  public static final class jq
    extends c.g
  {
    public jq()
    {
      super("sendAppMessageToSpecifiedContact", 168, true);
    }
  }
  
  public static final class jr
    extends c.g
  {
    public jr()
    {
      super("send_app_msg", 6, true);
    }
  }
  
  public static final class jt
    extends c.g
  {
    public jt()
    {
      super("sendDataToWXDevice", 120, true);
    }
  }
  
  public static final class ju
    extends c.g
  {
    public ju()
    {
      super("sendEnterpriseChat", 222, true);
    }
  }
  
  static final class jv
    extends c.g
  {
    jv()
    {
      super("menuitem:gameSendDesktop", 255, false);
    }
  }
  
  public static final class jw
    extends c.g
  {
    public jw()
    {
      super("send_email", 35, false);
    }
  }
  
  public static final class jx
    extends c.g
  {
    public jx()
    {
      super("send_service_app_msg", 67, true);
    }
  }
  
  static final class jy
    extends c.g
  {
    jy()
    {
      super("sendSingleAppMessage", 316, true);
    }
  }
  
  static final class jz
    extends c.g
  {
    jz()
    {
      super("serviceClick", 304, false);
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
  
  static final class ka
    extends c.g
  {
    ka()
    {
      super("setWCPayPassword", 289, true);
    }
  }
  
  static final class kb
    extends c.g
  {
    kb()
    {
      super("setBackgroundAudioState", 262, false);
    }
  }
  
  public static final class kc
    extends c.g
  {
    public kc()
    {
      super("setBounceBackground", 218, false);
    }
  }
  
  public static final class kd
    extends c.g
  {
    public kd()
    {
      super("setCloseWindowConfirmDialogInfo", 77, false);
    }
  }
  
  static final class ke
    extends c.g
  {
    ke()
    {
      super("setGameData", 298, false);
    }
  }
  
  public static final class kf
    extends c.g
  {
    public kf()
    {
      super("", -2, false);
    }
  }
  
  public static final class kg
    extends c.g
  {
    public kg()
    {
      super("setGameDebugConfig", 1111111, false);
    }
  }
  
  public static final class kh
    extends c.g
  {
    public kh()
    {
      super("setLocalData", 180, false);
    }
  }
  
  public static final class ki
    extends c.g
  {
    public ki()
    {
      super("setNavigationBarButtons", 195, false);
    }
  }
  
  public static final class kj
    extends c.g
  {
    public kj()
    {
      super("setNavigationBarColor", 182, false);
    }
  }
  
  public static final class kk
    extends c.g
  {
    public kk()
    {
      super("setPageOwner", 114, false);
    }
  }
  
  public static final class kl
    extends c.g
  {
    public kl()
    {
      super("setPageTitle", 113, false);
    }
  }
  
  static final class km
    extends c.g
  {
    km()
    {
      super("setScreenOrientation", 270, false);
    }
  }
  
  public static final class kn
    extends c.g
  {
    public kn()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ko
    extends c.g
  {
    public ko()
    {
      super("setSendDataDirection", 127, false);
    }
  }
  
  public static final class kp
    extends c.g
  {
    public kp()
    {
      super("", 10000, false);
    }
  }
  
  public static final class kq
    extends c.g
  {
    public kq()
    {
      super("setStatusBarStyle", 206, false);
    }
  }
  
  static final class kr
    extends c.g
  {
    kr()
    {
      super("shareEmoticon", 275, true);
    }
  }
  
  public static final class ks
    extends c.g
  {
    public ks()
    {
      super("shareQQ", 90, true);
    }
  }
  
  public static final class kt
    extends c.g
  {
    public kt()
    {
      super("shareQZone", 132, true);
    }
  }
  
  public static final class ku
    extends c.g
  {
    public ku()
    {
      super("shareWeiboApp", 107, false);
    }
  }
  
  public static final class kv
    extends c.g
  {
    public kv()
    {
      super("showAllNonBaseMenuItem", 92, false);
    }
  }
  
  public static final class kw
    extends c.g
  {
    public kw()
    {
      super("showDatePickerView", 248, true);
    }
  }
  
  public static final class kx
    extends c.g
  {
    public kx()
    {
      super("showKeyboard", 187, false);
    }
  }
  
  public static final class ky
    extends c.g
  {
    public ky()
    {
      super("showMenuItems", 86, false);
    }
  }
  
  public static final class kz
    extends c.g
  {
    public kz()
    {
      super("showNavigationBarLoading", 197, false);
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
      super("", 10000, false);
    }
  }
  
  public static final class lb
    extends c.g
  {
    public lb()
    {
      super("", 14, false);
    }
  }
  
  public static final class lc
    extends c.g
  {
    public lc()
    {
      super("showSearchActionSheet", 10000, false);
    }
  }
  
  public static final class ld
    extends c.g
  {
    public ld()
    {
      super("showSearchLoading", 10000, false);
    }
  }
  
  static final class le
    extends c.g
  {
    le()
    {
      super("showSearchOfBizHistory", 266, false);
    }
  }
  
  public static final class lf
    extends c.g
  {
    public lf()
    {
      super("showSearchToast", 10000, false);
    }
  }
  
  public static final class lg
    extends c.g
  {
    public lg()
    {
      super("showSmileyPanel", 238, false);
    }
  }
  
  static final class lh
    extends c.g
  {
    lh()
    {
      super("showWCCoinFirstBuyCoinTips", 437, true);
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
  
  public static final class lj
    extends c.g
  {
    public lj()
    {
      super("soter_biometric_authentication", 214, true);
    }
  }
  
  public static final class lk
    extends c.g
  {
    public lk()
    {
      super("getSupportSoter", 213, true);
    }
  }
  
  public static final class ll
    extends c.g
  {
    public ll()
    {
      super("startMonitoringBeacons", 151, false);
    }
  }
  
  public static final class lm
    extends c.g
  {
    public lm()
    {
      super("startPullDownRefresh", 204, false);
    }
  }
  
  public static final class ln
    extends c.g
  {
    public ln()
    {
      super("startRecord", 96, false);
    }
  }
  
  public static final class lo
    extends c.g
  {
    public lo()
    {
      super("startScanWXDevice", 121, true);
    }
  }
  
  public static final class lp
    extends c.g
  {
    public lp()
    {
      super("", 10000, false);
    }
  }
  
  public static final class lq
    extends c.g
  {
    public lq()
    {
      super("startTempSession", 128, true);
    }
  }
  
  public static final class lr
    extends c.g
  {
    public lr()
    {
      super("startVoipCall", 230, false);
    }
  }
  
  public static final class ls
    extends c.g
  {
    public ls()
    {
      super("stopMonitoringBeacons", 152, false);
    }
  }
  
  public static final class lt
    extends c.g
  {
    public lt()
    {
      super("stopPullDownRefresh", 200, false);
    }
  }
  
  public static final class lu
    extends c.g
  {
    public lu()
    {
      super("stopRecord", 98, false);
    }
  }
  
  public static final class lv
    extends c.g
  {
    public lv()
    {
      super("stopScanWXDevice", 122, true);
    }
  }
  
  public static final class lw
    extends c.g
  {
    public lw()
    {
      super("stopVoice", 101, false);
    }
  }
  
  public static final class lx
    extends c.g
  {
    public lx()
    {
      super("playStreamingVideo", 209, false);
    }
  }
  
  public static final class ly
    extends c.g
  {
    public ly()
    {
      super("selectWalletCurrency", 201, true);
    }
  }
  
  static final class lz
    extends c.g
  {
    lz()
    {
      super("tapSearchWAWidgetView", 10000, false);
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
      super("share_timeline", 4, true);
    }
  }
  
  public static final class mb
    extends c.g
  {
    public mb()
    {
      super("translateVoice", 97, true);
    }
  }
  
  public static final class mc
    extends c.g
  {
    public mc()
    {
      super("unbindBankCard", 216, true);
    }
  }
  
  static final class md
    extends c.g
  {
    md()
    {
      super("updatePageAuth", -2, false);
    }
  }
  
  public static final class me
    extends c.g
  {
    public me()
    {
      super("", 10000, false);
    }
  }
  
  static final class mf
    extends c.g
  {
    mf()
    {
      super("updateAppMessageShareData", 326, false);
    }
  }
  
  public static final class mg
    extends c.g
  {
    public mg()
    {
      super("", 10000, false);
    }
  }
  
  static final class mh
    extends c.g
  {
    mh()
    {
      super("updateTimelineShareData", 327, false);
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
      super("updateWASearchTemplate", 10000, false);
    }
  }
  
  static final class mk
    extends c.g
  {
    mk()
    {
      super("uploadEncryptMediaFile", 253, false);
    }
  }
  
  public static final class ml
    extends c.g
  {
    public ml()
    {
      super("uploadImage", 105, true);
    }
  }
  
  public static final class mm
    extends c.g
  {
    public mm()
    {
      super("uploadMediaFile", 237, true);
    }
  }
  
  public static final class mn
    extends c.g
  {
    public mn()
    {
      super("uploadVideo", 192, true);
    }
  }
  
  public static final class mo
    extends c.g
  {
    public mo()
    {
      super("uploadVoice", 102, true);
    }
  }
  
  public static final class mp
    extends c.g
  {
    public mp()
    {
      super("uxSearchOpLog", 10000, false);
    }
  }
  
  public static final class mq
    extends c.g
  {
    public mq()
    {
      super("verifyWCPayPassword", 115, true);
    }
  }
  
  public static final class mr
    extends c.g
  {
    public mr()
    {
      super("vibrateShort", 401, true);
    }
  }
  
  static final class ms
    extends c.g
  {
    ms()
    {
      super("", 10000, false);
    }
  }
  
  public static final class mt
    extends c.g
  {
    public mt()
    {
      super("", 355, true);
    }
  }
  
  static final class mu
    extends c.g
  {
    mu()
    {
      super("wcPrivacyPolicyResult", 315, false);
    }
  }
  
  public static final class mv
    extends c.g
  {
    public mv()
    {
      super("cache", 150, false);
    }
  }
  
  public static final class mw
    extends c.g
  {
    public mw()
    {
      super("videoProxyInit", 156, false);
    }
  }
  
  public static final class mx
    extends c.g
  {
    public mx()
    {
      super("videoProxySetPlayerState", 159, false);
    }
  }
  
  public static final class my
    extends c.g
  {
    public my()
    {
      super("videoProxySetPlayerState", 160, false);
    }
  }
  
  public static final class mz
    extends c.g
  {
    public mz()
    {
      super("videoProxyStartPlay", 157, false);
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
      super("videoProxyStopPlay", 158, false);
    }
  }
  
  public static final class nb
    extends c.g
  {
    public nb()
    {
      super("publicCache", 149, false);
    }
  }
  
  public static final class nc
    extends c.g
  {
    public nc()
    {
      super("videoProxyPreload", 172, false);
    }
  }
  
  public static final class nd
    extends c.g
  {
    public nd()
    {
      super("share_weibo", 3, true);
    }
  }
  
  public static final class ne
    extends c.g
  {
    public ne()
    {
      super("", 10000, false);
    }
  }
  
  public static final class nf
    extends c.g
  {
    public nf()
    {
      super("WNNativeAsyncCallback", 10006, false);
    }
  }
  
  public static final class ng
    extends c.g
  {
    public ng()
    {
      super("WNNativeCallbackInitData", 10006, false);
    }
  }
  
  public static final class nh
    extends c.g
  {
    public nh()
    {
      super("WNNativeCallbackOnCaretChange", 10006, false);
    }
  }
  
  public static final class ni
    extends c.g
  {
    public ni()
    {
      super("WNNativeCallbackOnClick", 10006, false);
    }
  }
  
  public static final class nj
    extends c.g
  {
    public nj()
    {
      super("WNNativeCallbackOnLongClick", 10006, false);
    }
  }
  
  public static final class nk
    extends c.g
  {
    public nk()
    {
      super("write_comm_data", 53, false);
    }
  }
  
  static final class nl
    extends c.g
  {
    nl()
    {
      super("calRqt", 319, false);
    }
  }
  
  static final class nm
    extends c.g
  {
    nm()
    {
      super("getCCData", 312, false);
    }
  }
  
  static final class nn
    extends c.g
  {
    nn()
    {
      super("buyWCCoin", 408, true);
    }
  }
  
  static final class no
    extends c.g
  {
    no()
    {
      super("openRealnameAuth", 314, true);
    }
  }
  
  public static final class np
    extends c.g
  {
    public np()
    {
      super("WNNativeCallbackOnBecomeEditing", 10006, false);
    }
  }
  
  public static final class nq
    extends c.g
  {
    public nq()
    {
      super("WNNativeCallbackOnBecomeEdited", 10006, false);
    }
  }
  
  public static final class nr
    extends c.g
  {
    public nr()
    {
      super("", 317, true);
    }
  }
  
  public static final class ns
    extends c.g
  {
    public ns()
    {
      super("", 129, false);
    }
  }
  
  public static final class nt
    extends c.g
  {
    public nt()
    {
      super("", 89, false);
    }
  }
  
  public static final class nu
    extends c.g
  {
    public nu()
    {
      super("", 94, false);
    }
  }
  
  public static final class nv
    extends c.g
  {
    public nv()
    {
      super("", 134, false);
    }
  }
  
  public static final class nw
    extends c.g
  {
    public nw()
    {
      super("", 88, false);
    }
  }
  
  public static final class nx
    extends c.g
  {
    public nx()
    {
      super("", 109, false);
    }
  }
  
  public static final class ny
    extends c.g
  {
    public ny()
    {
      super("", 320, true);
    }
  }
  
  public static final class nz
    extends c.g
  {
    public nz()
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
      super("bindGroup", 376, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.protocal.c
 * JD-Core Version:    0.7.0.1
 */