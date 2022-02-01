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
  private static Map<String, c.g> RAp;
  public static final String[] RAq;
  
  static
  {
    AppMethodBeat.i(152436);
    RAp = null;
    RAq = (String[])new c.1().toArray(new String[0]);
    AppMethodBeat.o(152436);
  }
  
  public static c.g bst(String paramString)
  {
    AppMethodBeat.i(152435);
    if ((RAp == null) || (RAp.size() <= 0))
    {
      Object localObject = new HashMap(128);
      RAp = (Map)localObject;
      ((Map)localObject).put("log", new fd());
      RAp.put("imagePreview", new el());
      RAp.put("profile", new ie());
      RAp.put("shareWeibo", new na());
      RAp.put("shareTimeline", new lx());
      RAp.put("adDataReport", new o());
      RAp.put("streamingVideoPlay", new lu());
      RAp.put("addContact", new h());
      RAp.put("getWidgetCaptureImgUrl", new dv());
      RAp.put("sendAppMessage", new jp());
      RAp.put("vibrateShort", new mo());
      RAp.put("scanQRCode", new jh());
      RAp.put("hideOptionMenu", new ei());
      RAp.put("showOptionMenu", new kz());
      RAp.put("getNetworkType", new cw());
      RAp.put("closeWindow", new aq());
      RAp.put("getInstallState", new cr());
      RAp.put("setFontSizeCallback", new kd());
      RAp.put("jumpToInstallUrl", new es());
      RAp.put("launchApp", new ey());
      RAp.put("getBrandWCPayRequest", new cd());
      RAp.put("secureTunnel", new jj());
      RAp.put("wcpaySecurityCrosscutBack", new mq());
      RAp.put("editAddress", new bk());
      RAp.put("getHeadingAndPitch", new co());
      RAp.put("sendEmail", new ju());
      RAp.put("addDownloadTask", new k());
      RAp.put("cancelDownloadTask", new x());
      RAp.put("pauseDownloadTask", new hs());
      RAp.put("resumeDownloadTask", new jf());
      RAp.put("queryDownloadTask", new ih());
      RAp.put("installDownloadTask", new eo());
      RAp.put("getLatestAddress", new db());
      RAp.put("openSpecificView", new hc());
      RAp.put("jumpWCMall", new eu());
      RAp.put("launch3rdApp", new ex());
      RAp.put("writeCommData", new nh());
      RAp.put("openUrlByExtBrowser", new hd());
      RAp.put("geoLocation", new by());
      RAp.put("getBrandWCPayBindCardRequest", new cc());
      RAp.put("openProductView", new gv());
      RAp.put("openProductViewWithPid", new gw());
      RAp.put("jumpToBizProfile", new et());
      RAp.put("openTimelineCheckInList", new fk());
      RAp.put("openLocation", new fj());
      RAp.put("timelineCheckIn", new fi());
      RAp.put("getBrandWCPayCreateCreditCardRequest", new hj());
      RAp.put("chooseCard", new ad());
      RAp.put("chooseInvoice", new ah());
      RAp.put("sendServiceAppMessage", new jv());
      RAp.put("musicPlay", new fg());
      RAp.put("mmsf0001", new ci());
      RAp.put("getTransferMoneyRequest", new dr());
      RAp.put("openWCPaySpecificView", new hf());
      RAp.put("setCloseWindowConfirmDialogInfo", new kb());
      RAp.put("batchAddCard", new s());
      RAp.put("preVerifyJSAPI", new ib());
      RAp.put("startRecord", new lk());
      RAp.put("stopRecord", new lr());
      RAp.put("playVoice", new hw());
      RAp.put("pauseVoice", new ht());
      RAp.put("stopVoice", new lt());
      RAp.put("uploadVoice", new ml());
      RAp.put("downloadVoice", new bg());
      RAp.put("chooseImage", new ag());
      RAp.put("uploadImage", new mi());
      RAp.put("downloadImage", new bf());
      RAp.put("uploadMediaFile", new mj());
      RAp.put("hideMenuItems", new ef());
      RAp.put("showMenuItems", new kw());
      RAp.put("hideAllNonBaseMenuItem", new ee());
      RAp.put("showAllNonBaseMenuItem", new kt());
      RAp.put("checkJsApi", new ac());
      RAp.put("translateVoice", new ly());
      RAp.put("shareQQ", new kq());
      RAp.put("shareWeiboApp", new ks());
      RAp.put("shareQZone", new kr());
      RAp.put("getSendC2CMessageRequest", new do());
      RAp.put("batchViewCard", new v());
      RAp.put("configWXDeviceWiFi", new at());
      RAp.put("getCurrentSSID", new cg());
      RAp.put("setPageOwner", new ki());
      RAp.put("getWechatVerifyTicket", new dt());
      RAp.put("openWXDeviceLib", new hk());
      RAp.put("startScanWXDevice", new ll());
      RAp.put("stopScanWXDevice", new ls());
      RAp.put("connectWXDevice", new av());
      RAp.put("disconnectWXDevice", new be());
      RAp.put("getWXDeviceTicket", new dx());
      RAp.put("getWXDeviceInfos", new dw());
      RAp.put("sendDataToWXDevice", new jr());
      RAp.put("closeWXDeviceLib", new as());
      RAp.put("setSendDataDirection", new km());
      RAp.put("verifyWCPayPassword", new mn());
      RAp.put("getPaymentOrderRequest", new da());
      RAp.put("openGameDetail", new gk());
      RAp.put("openGameCenter", new gj());
      RAp.put("setGameDebugConfig", new ke());
      RAp.put("startTempSession", new ln());
      RAp.put("getH5PrepayRequest", new cp());
      RAp.put("getH5TransactionRequest", new cq());
      RAp.put("menu:share:timeline", new ns());
      RAp.put("menu:share:appmessage", new np());
      RAp.put("menu:share:qq", new nq());
      RAp.put("menu:share:weiboApp", new nt());
      RAp.put("menu:setfont", new no());
      RAp.put("menu:share:weibo", new nt());
      RAp.put("menu:share:QZone", new nr());
      RAp.put("getRecevieBizHongBaoRequest", new e());
      RAp.put("openCamera", new fw());
      RAp.put("insertVideoPlayer", new en());
      RAp.put("updateVideoPlayer", new mf());
      RAp.put("removeVideoPlayer", new ip());
      RAp.put("operateVideoPlayer", new ho());
      RAp.put("deleteSearchHistory", new bb());
      RAp.put("getSearchHistory", new dk());
      RAp.put("getSearchData", new dg());
      RAp.put("showWeDrawHomeView", new lf());
      RAp.put("getFestivalLiveInfo", new cl());
      RAp.put("getChatSearchData", new ce());
      RAp.put("getPoiInfo", new cn());
      RAp.put("updateReddotTimeStamps", new mb());
      RAp.put("getTeachSearchData", new dq());
      RAp.put("getSearchGuideData", new dj());
      RAp.put("getSearchAvatarList", new df());
      RAp.put("getSearchSnsImageList", new dm());
      RAp.put("getSearchImageList", new dl());
      RAp.put("getSearchDisplayNameList", new dh());
      RAp.put("startSearchItemDetailPage", new lm());
      RAp.put("reportSearchStatistics", new iw());
      RAp.put("reportSearchRealTimeStatistics", new iv());
      RAp.put("searchDataHasResult", new ji());
      RAp.put("openEmotionPage", new bu());
      RAp.put("getSearchSuggestionData", new dn());
      RAp.put("setSearchInputWord", new kl());
      RAp.put("setSnsObjectXmlDescList", new kn());
      RAp.put("clickSnsMusicPlayButton", new ap());
      RAp.put("openWeAppPage", new hi());
      RAp.put("reportWeAppSearchRealtime", new nb());
      RAp.put("doSearchOperation", new bj());
      RAp.put("insertSearchWAWidgetView", new em());
      RAp.put("removeSearchWAWidgetView", new io());
      RAp.put("updateSearchWAWidgetView", new md());
      RAp.put("showSearchActionSheet", new la());
      RAp.put("cancelSearchActionSheet", new z());
      RAp.put("showSearchToast", new ld());
      RAp.put("showSearchLoading", new lb());
      RAp.put("hideSearchLoading", new ej());
      RAp.put("updateWASearchTemplate", new mg());
      RAp.put("preloadSearchWeapp", new hz());
      RAp.put("uxSearchOpLog", new mm());
      RAp.put("querySearchWeb", new bw());
      RAp.put("openFinderProfile", new gi());
      RAp.put("playMusic", new hv());
      RAp.put("openMusicPage", new gr());
      RAp.put("openFinderFeed", new gh());
      RAp.put("getCurrentLocation", new cf());
      RAp.put("navControl", new fh());
      RAp.put("showNavBarShadow", new ky());
      RAp.put("hideNavBarShadow", new eh());
      RAp.put("jumpToWXWallet", new ev());
      RAp.put("scanCover", new f());
      RAp.put("reportActionInfo", new iq());
      RAp.put("openMyDeviceProfile", new gs());
      RAp.put("selectPedometerSource", new jm());
      RAp.put("nfcIsConnect", new fq());
      RAp.put("nfcConnect", new fn());
      RAp.put("nfcTransceive", new fr());
      RAp.put("nfcBatchTransceive", new fl());
      RAp.put("nfcGetId", new fo());
      RAp.put("nfcGetInfo", new fp());
      RAp.put("startMonitoringBeacons", new li());
      RAp.put("stopMonitoringBeacons", new lp());
      RAp.put("nfcCheckState", new fm());
      RAp.put("videoProxyInit", new mt());
      RAp.put("videoProxyStartPlay", new mw());
      RAp.put("videoProxyStopPlay", new mx());
      RAp.put("videoProxySetPlayerState", new mu());
      RAp.put("videoProxySetRemainTime", new mv());
      RAp.put("videoProxyPreload", new mz());
      RAp.put("getWebPayCheckoutCounterRequst", new fc());
      RAp.put("addCustomMenuItems", new i());
      RAp.put("operateGameCenterMsg", new hn());
      RAp.put("openEnterpriseChat", new gf());
      RAp.put("enterEnterpriseChat", new bo());
      RAp.put("openEnterpriseContact", new gg());
      RAp.put("selectEnterpriseContact", new jl());
      RAp.put("getEnterpriseChat", new ck());
      RAp.put("reportIDKey", new it());
      RAp.put("quicklyAddBrandContact", new ik());
      RAp.put("consumedShareCard", new aw());
      RAp.put("cache", new ms());
      RAp.put("publicCache", new my());
      RAp.put("kvReport", new ew());
      RAp.put("realtimeReport", new il());
      RAp.put("openUrlWithExtraWebview", new he());
      RAp.put("selectSingleContact", new jn());
      RAp.put("sendAppMessageToSpecifiedContact", new jo());
      RAp.put("setLocalData", new kf());
      RAp.put("getLocalData", new cs());
      RAp.put("clearLocalData", new an());
      RAp.put("showKeyboard", new kv());
      RAp.put("showSmileyPanel", new le());
      RAp.put("disableBounceScroll", new bc());
      RAp.put("clearBounceBackground", new al());
      RAp.put("setNavigationBarButtons", new kg());
      RAp.put("enableFullScreen", new bm());
      RAp.put("showNavigationBarLoading", new kx());
      RAp.put("hideNavigationBarLoading", new eg());
      RAp.put("enablePullDownRefresh", new bn());
      RAp.put("startPullDownRefresh", new lj());
      RAp.put("stopPullDownRefresh", new lq());
      RAp.put("disablePullDownRefresh", new bd());
      RAp.put("setPageTitle", new kj());
      RAp.put("setStatusBarStyle", new ko());
      RAp.put("deleteAccountSuccess", new ba());
      RAp.put("chooseVideo", new ak());
      RAp.put("uploadVideo", new mk());
      RAp.put("openMapNavigateMenu", new gq());
      RAp.put("setNavigationBarColor", new kh());
      RAp.put("getWCPayRealnameVerify", new ds());
      RAp.put("openDesignerEmojiView", new fz());
      RAp.put("openDesignerProfile", new gb());
      RAp.put("openEmoticonTopicList", new ge());
      RAp.put("openDesignerEmojiViewLocal", new ga());
      RAp.put("openDesignerProfileLocal", new gc());
      RAp.put("openEmotionDetailViewLocal", new d());
      RAp.put("openNewPage", new gt());
      RAp.put("getSearchEmotionData", new di());
      RAp.put("openEmotionUrl", new bl());
      RAp.put("WNNativeCallbackOnClick", new nf());
      RAp.put("WNNativeCallbackOnLongClick", new ng());
      RAp.put("WNNativeCallbackOnCaretChange", new ne());
      RAp.put("WNNativeCallbackInitData", new nd());
      RAp.put("WNNativeAsyncCallback", new nc());
      RAp.put("WNNativeCallbackOnBecomeEditing", new nl());
      RAp.put("WNNativeCallbackOnBecomeEdited", new nm());
      RAp.put("changePayActivityView", new aa());
      RAp.put("selectWalletCurrency", new lv());
      RAp.put("scanLicence", new jg());
      RAp.put("operateMusicPlayer", new b());
      RAp.put("getMusicPlayerState", new a());
      RAp.put("clearWebviewCache", new ao());
      RAp.put("requireSoterBiometricAuthentication", new lg());
      RAp.put("getSupportSoter", new lh());
      RAp.put("unbindBankCard", new lz());
      RAp.put("setBounceBackground", new ka());
      RAp.put("sendEnterpriseChat", new js());
      RAp.put("doExposePreparation", new bi());
      RAp.put("getMsgProofItems", new cv());
      RAp.put("openSecurityView", new ha());
      RAp.put("startVoipCall", new lo());
      RAp.put("chooseInvoiceTitle", new ai());
      RAp.put("getOpenDeviceId", new cy());
      RAp.put("getRouteUrl", new de());
      RAp.put("idCardRealnameVerify", new ek());
      RAp.put("uploadIdCardSuccess", new nv());
      RAp.put("showDatePickerView", new ku());
      RAp.put("openLuckyMoneyDetailView", new go());
      RAp.put("resendRemittanceMsg", new je());
      RAp.put("getGameCommInfo", new cm());
      RAp.put("openGameRegion", new gl());
      RAp.put("chooseIdCard", new af());
      RAp.put("getLocalImgData", new c());
      RAp.put("openWeApp", new hh());
      RAp.put("recordVideo", new im());
      RAp.put("previewVideo", new ia());
      RAp.put("uploadEncryptMediaFile", new mh());
      RAp.put("chooseMedia", new aj());
      RAp.put("requestWxFacePictureVerify", new bp());
      RAp.put("openCustomWebview", new fy());
      RAp.put("forceUpdateWxaAttr", new bt());
      RAp.put("openLuckyMoneyHistory", new gp());
      RAp.put("menuitem:gameSendDesktop", new jt());
      RAp.put("getWePkgAuthResult", new du());
      RAp.put("getLocalWePkgInfo", new ct());
      RAp.put("openGameWebView", new gn());
      RAp.put("reportGameWeb", new is());
      RAp.put("launchApplication", new ez());
      RAp.put("showSearchOfBizHistory", new lc());
      RAp.put("login", new fe());
      RAp.put("authorize", new r());
      RAp.put("requestWxFacePictureVerifyUnionVideo", new bq());
      RAp.put("checkIsSupportFaceDetect", new ab());
      RAp.put("operateBackgroundAudio", new hm());
      RAp.put("setBackgroundAudioState", new jz());
      RAp.put("getBackgroundAudioState", new ca());
      RAp.put("addDownloadTaskStraight", new l());
      RAp.put("setScreenOrientation", new kk());
      RAp.put("addToEmoticon", new n());
      RAp.put("shareEmoticon", new kp());
      RAp.put("makePhoneCall", new ff());
      RAp.put("openADCanvas", new fx());
      RAp.put("openSearchCanvas", new gx());
      RAp.put("opVoteAdData", new hr());
      RAp.put("opJumpView", new hq());
      RAp.put("opAdH5Func", new hp());
      RAp.put("requestWxFaceRegisterInternal", new jb());
      RAp.put("requestWxFaceVerifyInternal", new jc());
      RAp.put("launchMiniProgram", new fb());
      RAp.put("reportMiniProgramPageData", new iu());
      RAp.put("selectContact", new jk());
      RAp.put("openSearchWAWidgetLogView", new gy());
      RAp.put("reloadSearchWAWidgetData", new in());
      RAp.put("gotoEmoticonPad", new dy());
      RAp.put("querySimilarEmotion", new ij());
      RAp.put("closeWindowAndGoNext", new ar());
      RAp.put("requestWxVoicePrintVerifyInternal", new jd());
      RAp.put("openBizChat", new fv());
      RAp.put("handleWCPayWalletBuffer", new ed());
      RAp.put("tapSearchWAWidgetView", new lw());
      RAp.put("getMatchContactList", new cu());
      RAp.put("openSearchWebView", new gz());
      RAp.put("openWXSearchPage", new hl());
      RAp.put("viewTypeChange", new mp());
      RAp.put("invokeMiniProgramAPI", new eq());
      RAp.put("openGameUrlWithExtraWebView", new gm());
      RAp.put("setGameData", new kc());
      RAp.put("getGameData", new ch());
      RAp.put("clearGameData", new am());
      RAp.put("openECard", new gd());
      RAp.put("reportGamePageTime", new ir());
      RAp.put("setWCPayPassword", new jy());
      RAp.put("openWCPayCardList", new fu());
      RAp.put("bindEmail", new w());
      RAp.put("openOfflinePayView", new gu());
      RAp.put("bindEmail", new w());
      RAp.put("doGoToRecVideoList", new dc());
      RAp.put("jumpWSRecVideoList", new nn());
      RAp.put("openWebSearchOutLinkItem", new nu());
      RAp.put("recordHistory", new bx());
      localObject = hoE().iterator();
      while (((Iterator)localObject).hasNext())
      {
        c.g localg = (c.g)((Iterator)localObject).next();
        RAp.put(localg.getName(), localg);
      }
      RAp.put("getSystemInfo", new dp());
      RAp.put("serviceClick", new jx());
      RAp.put("openRealnameAuth", new nk());
      RAp.put("sendSingleAppMessage", new jw());
      RAp.put("wcPrivacyPolicyResult", new mr());
      RAp.put("currentMpInfo", new ax());
      RAp.put("updateAppMessageShareData", new mc());
      RAp.put("updateTimelineShareData", new me());
      RAp.put("getCCData", new nj());
      RAp.put("calRqt", new ni());
      RAp.put("faceVerifyForPay", new br());
      RAp.put("request", new ix());
      RAp.put("notifyPageInfo", new fs());
      RAp.put("updatePageAuth", new ma());
      RAp.put("jumpDownloaderWidget", new er());
      RAp.put("batchUpdateWepkg", new u());
      RAp.put("addGameDownloadTask", new m());
      RAp.put("internelWxFaceVerify", new ep());
      RAp.put("getDownloadWidgetTaskInfos", new cj());
      RAp.put("chooseHaowanMedia", new ae());
      RAp.put("queryHaowanPublish", new ii());
      RAp.put("publishHaowanEdition", new if());
      RAp.put("cancelHaowanPublish", new y());
      RAp.put("launchGameVideoEditor", new fa());
      RAp.put("requestJointPayment", new iz());
      RAp.put("openSelectPayment", new hb());
      RAp.put("requestEntrustAuthorization", new iy());
      RAp.put("getOAID", new cx());
      RAp.put("qqMailLoginResult", new ig());
    }
    paramString = (c.g)RAp.get(paramString);
    AppMethodBeat.o(152435);
    return paramString;
  }
  
  public static Bundle hoD()
  {
    AppMethodBeat.i(221700);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("handle", true);
    localBundle.putString("handle_result", null);
    AppMethodBeat.o(221700);
    return localBundle;
  }
  
  private static List<c.g> hoE()
  {
    AppMethodBeat.i(221817);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new c.az());
    localLinkedList.add(new c.ay());
    localLinkedList.add(new c.bz());
    localLinkedList.add(new ec());
    localLinkedList.add(new c.dz());
    localLinkedList.add(new hy());
    localLinkedList.add(new c.hx());
    localLinkedList.add(new c.jq());
    localLinkedList.add(new c.ea());
    localLinkedList.add(new eb());
    localLinkedList.add(new c.j());
    localLinkedList.add(new c.id());
    localLinkedList.add(new c.ic());
    localLinkedList.add(new bv());
    localLinkedList.add(new c.hg());
    localLinkedList.add(new au());
    localLinkedList.add(new cz());
    localLinkedList.add(new c.dd());
    localLinkedList.add(new c.t());
    localLinkedList.add(new c.ft());
    localLinkedList.add(new hu());
    localLinkedList.add(new bs());
    localLinkedList.add(new ja());
    localLinkedList.add(new c.p());
    localLinkedList.add(new q());
    localLinkedList.add(new cb());
    localLinkedList.add(new c.bh());
    AppMethodBeat.o(221817);
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
  
  public static final class bi
    extends c.g
  {
    public bi()
    {
      super("doExposePreparation", 225, false);
    }
  }
  
  public static final class bj
    extends c.g
  {
    public bj()
    {
      super("", 10000, false);
    }
  }
  
  public static final class bk
    extends c.g
  {
    public bk()
    {
      super("edit_address", 29, true);
    }
  }
  
  public static final class bl
    extends c.g
  {
    public bl()
    {
      super("openEmotionUrl", 20000, false);
    }
  }
  
  public static final class bm
    extends c.g
  {
    public bm()
    {
      super("enableFullScreen", 196, false);
    }
  }
  
  public static final class bn
    extends c.g
  {
    public bn()
    {
      super("enablePullDownRefresh", 199, false);
    }
  }
  
  public static final class bo
    extends c.g
  {
    public bo()
    {
      super("enterEnterpriseChat", 223, false);
    }
  }
  
  static final class bp
    extends c.g
  {
    bp()
    {
      super("requestWxFacePictureVerify", 259, true);
    }
  }
  
  static final class bq
    extends c.g
  {
    bq()
    {
      super("requestWxFacePictureVerifyUnionVideo", 264, true);
    }
  }
  
  static final class br
    extends c.g
  {
    br()
    {
      super("faceVerifyForPay", 328, true);
    }
  }
  
  static final class bs
    extends c.g
  {
    bs()
    {
      super("fastBindCardGetResult", 402, false);
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
      super("", 10000, false);
    }
  }
  
  public static final class cm
    extends c.g
  {
    public cm()
    {
      super("getGameCommInfo", 241, false);
    }
  }
  
  public static final class cn
    extends c.g
  {
    public cn()
    {
      super("", 10000, false);
    }
  }
  
  public static final class co
    extends c.g
  {
    public co()
    {
      super("get_heading_and_pitch", 33, false);
    }
  }
  
  public static final class cp
    extends c.g
  {
    public cp()
    {
      super("getH5PrepayRequest", 137, true);
    }
  }
  
  public static final class cq
    extends c.g
  {
    public cq()
    {
      super("getH5TransactionRequest", 138, true);
    }
  }
  
  public static final class cr
    extends c.g
  {
    public cr()
    {
      super("get_install_state", 25, false);
    }
  }
  
  public static final class cs
    extends c.g
  {
    public cs()
    {
      super("getLocalData", 179, false);
    }
  }
  
  static final class ct
    extends c.g
  {
    ct()
    {
      super("getLocalWePkgInfo", -2, false);
    }
  }
  
  static final class cu
    extends c.g
  {
    cu()
    {
      super("getMatchContactList", 10000, false);
    }
  }
  
  public static final class cv
    extends c.g
  {
    public cv()
    {
      super("getMsgProofItems", 226, true);
    }
  }
  
  public static final class cw
    extends c.g
  {
    public cw()
    {
      super("network_type", 16, false);
    }
  }
  
  static final class cx
    extends c.g
  {
    cx()
    {
      super("getOAID", 361, false);
    }
  }
  
  public static final class cy
    extends c.g
  {
    public cy()
    {
      super("getOpenDeviceId", 227, false);
    }
  }
  
  static final class cz
    extends c.g
  {
    cz()
    {
      super("getPasteboardContent", 364, false);
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
      super("getPaymentOrderRequest", 116, true);
    }
  }
  
  public static final class db
    extends c.g
  {
    public db()
    {
      super("get_recently_used_address", 46, true);
    }
  }
  
  static final class dc
    extends c.g
  {
    dc()
    {
      super("doGoToRecVideoList", 10000, false);
    }
  }
  
  public static final class de
    extends c.g
  {
    public de()
    {
      super("getRouteUrl", 235, false);
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
      super("getSearchDisplayNameList", 10000, false);
    }
  }
  
  public static final class di
    extends c.g
  {
    public di()
    {
      super("getSearchEmotionData", 20000, false);
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
      super("", 10000, false);
    }
  }
  
  public static final class do
    extends c.g
  {
    public do()
    {
      super("get_send_c2c_message_request", 83, true);
    }
  }
  
  static final class dp
    extends c.g
  {
    dp()
    {
      super("getSystemInfo", 311, false);
    }
  }
  
  public static final class dq
    extends c.g
  {
    public dq()
    {
      super("", 10000, false);
    }
  }
  
  public static final class dr
    extends c.g
  {
    public dr()
    {
      super("get_transfer_money_request", 74, true);
    }
  }
  
  public static final class ds
    extends c.g
  {
    public ds()
    {
      super("getWCPayRealnameVerify", 194, true);
    }
  }
  
  public static final class dt
    extends c.g
  {
    public dt()
    {
      super("getWechatVerifyTicket", 112, false);
    }
  }
  
  static final class du
    extends c.g
  {
    du()
    {
      super("getWePkgAuthResult", -3, false);
    }
  }
  
  public static final class dv
    extends c.g
  {
    public dv()
    {
      super("add_contact", 10000, false);
    }
  }
  
  public static final class dw
    extends c.g
  {
    public dw()
    {
      super("getWXDeviceInfos", 119, true);
    }
  }
  
  public static final class dx
    extends c.g
  {
    public dx()
    {
      super("getWXDeviceTicket", 125, true);
    }
  }
  
  public static final class dy
    extends c.g
  {
    public dy()
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
  
  static final class eb
    extends c.g
  {
    eb()
    {
      super("handleMPPageAction", 345, false);
    }
  }
  
  static final class ec
    extends c.g
  {
    ec()
    {
      super("handleVideoAction", 371, false);
    }
  }
  
  static final class ed
    extends c.g
  {
    ed()
    {
      super("handleWCPayWalletBuffer", 294, false);
    }
  }
  
  public static final class ee
    extends c.g
  {
    public ee()
    {
      super("hideAllNonBaseMenuItem", 93, false);
    }
  }
  
  public static final class ef
    extends c.g
  {
    public ef()
    {
      super("hideMenuItems", 85, false);
    }
  }
  
  public static final class eg
    extends c.g
  {
    public eg()
    {
      super("hideNavigationBarLoading", 198, false);
    }
  }
  
  public static final class eh
    extends c.g
  {
    public eh()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ei
    extends c.g
  {
    public ei()
    {
      super("", 14, false);
    }
  }
  
  public static final class ej
    extends c.g
  {
    public ej()
    {
      super("hideSearchLoading", 10000, false);
    }
  }
  
  public static final class ek
    extends c.g
  {
    public ek()
    {
      super("idCardRealnameVerify", 235, true);
    }
  }
  
  public static final class el
    extends c.g
  {
    public el()
    {
      super("", 1, true);
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
      super("", 10000, false);
    }
  }
  
  public static final class eo
    extends c.g
  {
    public eo()
    {
      super("install_download_task", 41, false);
    }
  }
  
  public static final class ep
    extends c.g
  {
    ep()
    {
      super("internelWxFaceVerify", 325, true);
    }
  }
  
  static final class eq
    extends c.g
  {
    eq()
    {
      super("invokeMiniProgramAPI", 295, false);
    }
  }
  
  static final class er
    extends c.g
  {
    er()
    {
      super("jumpDownloaderWidget", 339, true);
    }
  }
  
  public static final class es
    extends c.g
  {
    public es()
    {
      super("", 26, false);
    }
  }
  
  public static final class et
    extends c.g
  {
    public et()
    {
      super("jump_to_biz_profile", 61, true);
    }
  }
  
  public static final class eu
    extends c.g
  {
    public eu()
    {
      super("jump_wcmall", 51, true);
    }
  }
  
  public static final class ev
    extends c.g
  {
    public ev()
    {
      super("jumpToWXWallet", 147, true);
    }
  }
  
  public static final class ew
    extends c.g
  {
    public ew()
    {
      super("kvReport", 170, false);
    }
  }
  
  public static final class ex
    extends c.g
  {
    public ex()
    {
      super("launch_3rdApp", 52, true);
    }
  }
  
  public static final class ey
    extends c.g
  {
    public ey()
    {
      super("", 27, false);
    }
  }
  
  static final class ez
    extends c.g
  {
    ez()
    {
      super("launchApplication", 260, true);
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
      super("launchGameVideoEditor", 350, true);
    }
  }
  
  static final class fb
    extends c.g
  {
    fb()
    {
      super("launchMiniProgram", 277, true);
    }
  }
  
  public static final class fc
    extends c.g
  {
    public fc()
    {
      super("getWebPayCheckoutCounterRequst", 161, true);
    }
  }
  
  public static final class fd
    extends c.g
  {
    public fd()
    {
      super("", 0, false);
    }
  }
  
  static final class fe
    extends c.g
  {
    fe()
    {
      super("login", 231, true);
    }
  }
  
  static final class ff
    extends c.g
  {
    ff()
    {
      super("makePhoneCall", 356, true);
    }
  }
  
  public static final class fg
    extends c.g
  {
    public fg()
    {
      super("playMusic", 69, false);
    }
  }
  
  public static final class fh
    extends c.g
  {
    public fh()
    {
      super("", 10000, false);
    }
  }
  
  public static final class fi
    extends c.g
  {
    public fi()
    {
      super("timeline_check_in", 64, false);
    }
  }
  
  public static final class fj
    extends c.g
  {
    public fj()
    {
      super("open_location", 63, true);
    }
  }
  
  public static final class fk
    extends c.g
  {
    public fk()
    {
      super("open_timeline_checkin_list", 62, false);
    }
  }
  
  public static final class fl
    extends c.g
  {
    public fl()
    {
      super("nfcBatchTransceive", 142, false);
    }
  }
  
  public static final class fm
    extends c.g
  {
    public fm()
    {
      super("nfcCheckState", 155, true);
    }
  }
  
  public static final class fn
    extends c.g
  {
    public fn()
    {
      super("nfcConnect", 140, false);
    }
  }
  
  public static final class fo
    extends c.g
  {
    public fo()
    {
      super("nfcGetId", 143, false);
    }
  }
  
  public static final class fp
    extends c.g
  {
    public fp()
    {
      super("nfcGetInfo", 148, false);
    }
  }
  
  public static final class fq
    extends c.g
  {
    public fq()
    {
      super("nfcIsConnect", 139, true);
    }
  }
  
  public static final class fr
    extends c.g
  {
    public fr()
    {
      super("nfcTransceive", 141, false);
    }
  }
  
  static final class fs
    extends c.g
  {
    fs()
    {
      super("notifyPageInfo", -2, false);
    }
  }
  
  static final class fu
    extends c.g
  {
    fu()
    {
      super("openWCPayCardList", 310, true);
    }
  }
  
  static final class fv
    extends c.g
  {
    fv()
    {
      super("openBizChat", 296, true);
    }
  }
  
  public static final class fw
    extends c.g
  {
    public fw()
    {
      super("openCamera", 10008, true);
    }
  }
  
  static final class fx
    extends c.g
  {
    fx()
    {
      super("openADCanvas", 283, true);
    }
  }
  
  static final class fy
    extends c.g
  {
    fy()
    {
      super("openCustomWebview", 256, false);
    }
  }
  
  public static final class fz
    extends c.g
  {
    public fz()
    {
      super("openDesignerEmojiView", 185, true);
    }
  }
  
  public static final class ga
    extends c.g
  {
    public ga()
    {
      super("openDesignerEmojiViewLocal", 20000, false);
    }
  }
  
  public static final class gb
    extends c.g
  {
    public gb()
    {
      super("openDesignerProfile", 193, true);
    }
  }
  
  public static final class gc
    extends c.g
  {
    public gc()
    {
      super("openDesignerProfileLocal", 20000, false);
    }
  }
  
  static final class gd
    extends c.g
  {
    gd()
    {
      super("openECard", 268, true);
    }
  }
  
  public static final class ge
    extends c.g
  {
    public ge()
    {
      super("openEmoticonTopicList", 212, true);
    }
  }
  
  public static final class gf
    extends c.g
  {
    public gf()
    {
      super("openEnterpriseChat", 165, false);
    }
  }
  
  public static final class gg
    extends c.g
  {
    public gg()
    {
      super("openEnterpriseContact", 183, true);
    }
  }
  
  public static final class gh
    extends c.g
  {
    public gh()
    {
      super("", 10000, false);
    }
  }
  
  public static final class gi
    extends c.g
  {
    public gi()
    {
      super("", 10000, false);
    }
  }
  
  public static final class gj
    extends c.g
  {
    public gj()
    {
      super("openGameCenter", 175, true);
    }
  }
  
  public static final class gk
    extends c.g
  {
    public gk()
    {
      super("openGameDetail", 131, true);
    }
  }
  
  public static final class gl
    extends c.g
  {
    public gl()
    {
      super("openGameRegion", 242, true);
    }
  }
  
  static final class gm
    extends c.g
  {
    gm()
    {
      super("openGameUrlWithExtraWebView", 297, false);
    }
  }
  
  static final class gn
    extends c.g
  {
    gn()
    {
      super("openGameWebView", 287, false);
    }
  }
  
  public static final class go
    extends c.g
  {
    public go()
    {
      super("openLuckyMoneyDetailView", 245, false);
    }
  }
  
  static final class gp
    extends c.g
  {
    gp()
    {
      super("openLuckyMoneyHistory", 258, true);
    }
  }
  
  public static final class gq
    extends c.g
  {
    public gq()
    {
      super("openMapNavigateMenu", 184, true);
    }
  }
  
  public static final class gr
    extends c.g
  {
    public gr()
    {
      super("", 10000, false);
    }
  }
  
  public static final class gs
    extends c.g
  {
    public gs()
    {
      super("openMyDeviceProfile", 145, false);
    }
  }
  
  public static final class gt
    extends c.g
  {
    public gt()
    {
      super("openNewPage", 20000, false);
    }
  }
  
  static final class gu
    extends c.g
  {
    gu()
    {
      super("openOfflinePayView", 305, true);
    }
  }
  
  public static final class gv
    extends c.g
  {
    public gv()
    {
      super("open_product_view", 59, true);
    }
  }
  
  public static final class gw
    extends c.g
  {
    public gw()
    {
      super("open_product_view", 60, true);
    }
  }
  
  static final class gx
    extends c.g
  {
    gx()
    {
      super("openSearchCanvas", 283, true);
    }
  }
  
  static final class gy
    extends c.g
  {
    gy()
    {
      super("openSearchWAWidgetLogView", 10000, true);
    }
  }
  
  static final class gz
    extends c.g
  {
    gz()
    {
      super("openSearchWebView", 10000, true);
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
      super("openSecurityView", 229, false);
    }
  }
  
  static final class hb
    extends c.g
  {
    hb()
    {
      super("openSelectPayment", 359, true);
    }
  }
  
  public static final class hc
    extends c.g
  {
    public hc()
    {
      super("specific_view", 48, true);
    }
  }
  
  public static final class hd
    extends c.g
  {
    public hd()
    {
      super("open_url_by_ext_browser", 55, false);
    }
  }
  
  public static final class he
    extends c.g
  {
    public he()
    {
      super("openUrlWithExtraWebview", 173, false);
    }
  }
  
  public static final class hf
    extends c.g
  {
    public hf()
    {
      super("open_wcpay_specific_view", 76, true);
    }
  }
  
  static final class hh
    extends c.g
  {
    hh()
    {
      super("openWeApp", 250, false);
    }
  }
  
  public static final class hi
    extends c.g
  {
    public hi()
    {
      super("", 10000, false);
    }
  }
  
  public static final class hj
    extends c.g
  {
    public hj()
    {
      super("get_wcpay_create_credit_card_request", 65, true);
    }
  }
  
  public static final class hk
    extends c.g
  {
    public hk()
    {
      super("openWXDeviceLib", 117, false);
    }
  }
  
  static final class hl
    extends c.g
  {
    hl()
    {
      super("openWXSearchPage", 309, true);
    }
  }
  
  static final class hm
    extends c.g
  {
    hm()
    {
      super("operateBackgroundAudio", 261, false);
    }
  }
  
  public static final class hn
    extends c.g
  {
    public hn()
    {
      super("operateGameCenterMsg", 174, false);
    }
  }
  
  public static final class ho
    extends c.g
  {
    public ho()
    {
      super("", 10000, false);
    }
  }
  
  static final class hp
    extends c.g
  {
    hp()
    {
      super("", -2, false);
    }
  }
  
  static final class hq
    extends c.g
  {
    hq()
    {
      super("", -2, false);
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
  
  public static final class hs
    extends c.g
  {
    public hs()
    {
      super("cancel_download_task", 239, false);
    }
  }
  
  public static final class ht
    extends c.g
  {
    public ht()
    {
      super("pauseVoice", 100, false);
    }
  }
  
  static final class hu
    extends c.g
  {
    hu()
    {
      super("phoneBindCardVerifySms", 370, false);
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
      super("playVoice", 99, false);
    }
  }
  
  static final class hy
    extends c.g
  {
    hy()
    {
      super("preloadMiniProgramEnv", 302, false);
    }
  }
  
  public static final class hz
    extends c.g
  {
    public hz()
    {
      super("preloadSearchWeapp", 10000, false);
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
      super("previewVideo", 252, true);
    }
  }
  
  public static final class ib
    extends c.g
  {
    public ib()
    {
      super("pre_verify_jsapi", -3, false);
    }
  }
  
  public static final class ie
    extends c.g
  {
    public ie()
    {
      super("profile", 2, false);
    }
  }
  
  static final class if
    extends c.g
  {
    if()
    {
      super("publishHaowanEdition", 351, false);
    }
  }
  
  static final class ig
    extends c.g
  {
    ig()
    {
      super("qqMailLoginResult", 357, false);
    }
  }
  
  public static final class ih
    extends c.g
  {
    public ih()
    {
      super("query_download_task", 40, false);
    }
  }
  
  static final class ii
    extends c.g
  {
    ii()
    {
      super("queryHaowanPublish", 352, false);
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
      super("quicklyAddBrandContact", 166, true);
    }
  }
  
  public static final class il
    extends c.g
  {
    public il()
    {
      super("realtimeReport", 171, false);
    }
  }
  
  static final class im
    extends c.g
  {
    im()
    {
      super("recordVideo", 251, true);
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
      super("reportActionInfo", 234, false);
    }
  }
  
  static final class ir
    extends c.g
  {
    ir()
    {
      super("reportGamePageTime", 301, false);
    }
  }
  
  static final class is
    extends c.g
  {
    is()
    {
      super("reportGameWeb", 332, false);
    }
  }
  
  public static final class it
    extends c.g
  {
    public it()
    {
      super("reportIDKey", 163, false);
    }
  }
  
  static final class iu
    extends c.g
  {
    iu()
    {
      super("reportMiniProgramPageData", 284, false);
    }
  }
  
  public static final class iv
    extends c.g
  {
    public iv()
    {
      super("", 10000, false);
    }
  }
  
  public static final class iw
    extends c.g
  {
    public iw()
    {
      super("", 10000, false);
    }
  }
  
  static final class ix
    extends c.g
  {
    ix()
    {
      super("request", 331, false);
    }
  }
  
  static final class iy
    extends c.g
  {
    iy()
    {
      super("requestEntrustAuthorization", 360, true);
    }
  }
  
  static final class iz
    extends c.g
  {
    iz()
    {
      super("requestJointPayment", 358, true);
    }
  }
  
  static final class ja
    extends c.g
  {
    ja()
    {
      super("requestQueryCashier", 374, false);
    }
  }
  
  static final class jb
    extends c.g
  {
    jb()
    {
      super("requestWxFaceRegisterInternal", 272, true);
    }
  }
  
  static final class jc
    extends c.g
  {
    jc()
    {
      super("requestWxFaceVerifyInternal", 273, true);
    }
  }
  
  static final class jd
    extends c.g
  {
    jd()
    {
      super("requestWxVoicePrintVerifyInternal", 292, true);
    }
  }
  
  public static final class je
    extends c.g
  {
    public je()
    {
      super("resendRemittanceMsg", 246, true);
    }
  }
  
  public static final class jf
    extends c.g
  {
    public jf()
    {
      super("resume_download_task", 240, true);
    }
  }
  
  public static final class jg
    extends c.g
  {
    public jg()
    {
      super("scanLicence", 203, false);
    }
  }
  
  public static final class jh
    extends c.g
  {
    public jh()
    {
      super("scanQRCode", 7, true);
    }
  }
  
  public static final class ji
    extends c.g
  {
    public ji()
    {
      super("", 10000, false);
    }
  }
  
  public static final class jj
    extends c.g
  {
    public jj()
    {
      super("", 329, false);
    }
  }
  
  static final class jk
    extends c.g
  {
    jk()
    {
      super("selectContact", 10000, true);
    }
  }
  
  public static final class jl
    extends c.g
  {
    public jl()
    {
      super("selectEnterpriseContact", 286, true);
    }
  }
  
  public static final class jm
    extends c.g
  {
    public jm()
    {
      super("selectPedometerSource", 146, true);
    }
  }
  
  public static final class jn
    extends c.g
  {
    public jn()
    {
      super("selectSingleContact", 167, true);
    }
  }
  
  public static final class jo
    extends c.g
  {
    public jo()
    {
      super("sendAppMessageToSpecifiedContact", 168, true);
    }
  }
  
  public static final class jp
    extends c.g
  {
    public jp()
    {
      super("send_app_msg", 6, true);
    }
  }
  
  public static final class jr
    extends c.g
  {
    public jr()
    {
      super("sendDataToWXDevice", 120, true);
    }
  }
  
  public static final class js
    extends c.g
  {
    public js()
    {
      super("sendEnterpriseChat", 222, true);
    }
  }
  
  static final class jt
    extends c.g
  {
    jt()
    {
      super("menuitem:gameSendDesktop", 255, false);
    }
  }
  
  public static final class ju
    extends c.g
  {
    public ju()
    {
      super("send_email", 35, false);
    }
  }
  
  public static final class jv
    extends c.g
  {
    public jv()
    {
      super("send_service_app_msg", 67, true);
    }
  }
  
  static final class jw
    extends c.g
  {
    jw()
    {
      super("sendSingleAppMessage", 316, true);
    }
  }
  
  static final class jx
    extends c.g
  {
    jx()
    {
      super("serviceClick", 304, false);
    }
  }
  
  static final class jy
    extends c.g
  {
    jy()
    {
      super("setWCPayPassword", 289, true);
    }
  }
  
  static final class jz
    extends c.g
  {
    jz()
    {
      super("setBackgroundAudioState", 262, false);
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
      super("setBounceBackground", 218, false);
    }
  }
  
  public static final class kb
    extends c.g
  {
    public kb()
    {
      super("setCloseWindowConfirmDialogInfo", 77, false);
    }
  }
  
  static final class kc
    extends c.g
  {
    kc()
    {
      super("setGameData", 298, false);
    }
  }
  
  public static final class kd
    extends c.g
  {
    public kd()
    {
      super("", -2, false);
    }
  }
  
  public static final class ke
    extends c.g
  {
    public ke()
    {
      super("setGameDebugConfig", 1111111, false);
    }
  }
  
  public static final class kf
    extends c.g
  {
    public kf()
    {
      super("setLocalData", 180, false);
    }
  }
  
  public static final class kg
    extends c.g
  {
    public kg()
    {
      super("setNavigationBarButtons", 195, false);
    }
  }
  
  public static final class kh
    extends c.g
  {
    public kh()
    {
      super("setNavigationBarColor", 182, false);
    }
  }
  
  public static final class ki
    extends c.g
  {
    public ki()
    {
      super("setPageOwner", 114, false);
    }
  }
  
  public static final class kj
    extends c.g
  {
    public kj()
    {
      super("setPageTitle", 113, false);
    }
  }
  
  static final class kk
    extends c.g
  {
    kk()
    {
      super("setScreenOrientation", 270, false);
    }
  }
  
  public static final class kl
    extends c.g
  {
    public kl()
    {
      super("", 10000, false);
    }
  }
  
  public static final class km
    extends c.g
  {
    public km()
    {
      super("setSendDataDirection", 127, false);
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
      super("setStatusBarStyle", 206, false);
    }
  }
  
  static final class kp
    extends c.g
  {
    kp()
    {
      super("shareEmoticon", 275, true);
    }
  }
  
  public static final class kq
    extends c.g
  {
    public kq()
    {
      super("shareQQ", 90, true);
    }
  }
  
  public static final class kr
    extends c.g
  {
    public kr()
    {
      super("shareQZone", 132, true);
    }
  }
  
  public static final class ks
    extends c.g
  {
    public ks()
    {
      super("shareWeiboApp", 107, false);
    }
  }
  
  public static final class kt
    extends c.g
  {
    public kt()
    {
      super("showAllNonBaseMenuItem", 92, false);
    }
  }
  
  public static final class ku
    extends c.g
  {
    public ku()
    {
      super("showDatePickerView", 248, true);
    }
  }
  
  public static final class kv
    extends c.g
  {
    public kv()
    {
      super("showKeyboard", 187, false);
    }
  }
  
  public static final class kw
    extends c.g
  {
    public kw()
    {
      super("showMenuItems", 86, false);
    }
  }
  
  public static final class kx
    extends c.g
  {
    public kx()
    {
      super("showNavigationBarLoading", 197, false);
    }
  }
  
  public static final class ky
    extends c.g
  {
    public ky()
    {
      super("", 10000, false);
    }
  }
  
  public static final class kz
    extends c.g
  {
    public kz()
    {
      super("", 14, false);
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
      super("showSearchActionSheet", 10000, false);
    }
  }
  
  public static final class lb
    extends c.g
  {
    public lb()
    {
      super("showSearchLoading", 10000, false);
    }
  }
  
  static final class lc
    extends c.g
  {
    lc()
    {
      super("showSearchOfBizHistory", 266, false);
    }
  }
  
  public static final class ld
    extends c.g
  {
    public ld()
    {
      super("showSearchToast", 10000, false);
    }
  }
  
  public static final class le
    extends c.g
  {
    public le()
    {
      super("showSmileyPanel", 238, false);
    }
  }
  
  public static final class lf
    extends c.g
  {
    public lf()
    {
      super("", 10000, false);
    }
  }
  
  public static final class lg
    extends c.g
  {
    public lg()
    {
      super("soter_biometric_authentication", 214, true);
    }
  }
  
  public static final class lh
    extends c.g
  {
    public lh()
    {
      super("getSupportSoter", 213, true);
    }
  }
  
  public static final class li
    extends c.g
  {
    public li()
    {
      super("startMonitoringBeacons", 151, false);
    }
  }
  
  public static final class lj
    extends c.g
  {
    public lj()
    {
      super("startPullDownRefresh", 204, false);
    }
  }
  
  public static final class lk
    extends c.g
  {
    public lk()
    {
      super("startRecord", 96, false);
    }
  }
  
  public static final class ll
    extends c.g
  {
    public ll()
    {
      super("startScanWXDevice", 121, true);
    }
  }
  
  public static final class lm
    extends c.g
  {
    public lm()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ln
    extends c.g
  {
    public ln()
    {
      super("startTempSession", 128, true);
    }
  }
  
  public static final class lo
    extends c.g
  {
    public lo()
    {
      super("startVoipCall", 230, false);
    }
  }
  
  public static final class lp
    extends c.g
  {
    public lp()
    {
      super("stopMonitoringBeacons", 152, false);
    }
  }
  
  public static final class lq
    extends c.g
  {
    public lq()
    {
      super("stopPullDownRefresh", 200, false);
    }
  }
  
  public static final class lr
    extends c.g
  {
    public lr()
    {
      super("stopRecord", 98, false);
    }
  }
  
  public static final class ls
    extends c.g
  {
    public ls()
    {
      super("stopScanWXDevice", 122, true);
    }
  }
  
  public static final class lt
    extends c.g
  {
    public lt()
    {
      super("stopVoice", 101, false);
    }
  }
  
  public static final class lu
    extends c.g
  {
    public lu()
    {
      super("playStreamingVideo", 209, false);
    }
  }
  
  public static final class lv
    extends c.g
  {
    public lv()
    {
      super("selectWalletCurrency", 201, true);
    }
  }
  
  static final class lw
    extends c.g
  {
    lw()
    {
      super("tapSearchWAWidgetView", 10000, false);
    }
  }
  
  public static final class lx
    extends c.g
  {
    public lx()
    {
      super("share_timeline", 4, true);
    }
  }
  
  public static final class ly
    extends c.g
  {
    public ly()
    {
      super("translateVoice", 97, true);
    }
  }
  
  public static final class lz
    extends c.g
  {
    public lz()
    {
      super("unbindBankCard", 216, true);
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
  
  static final class ma
    extends c.g
  {
    ma()
    {
      super("updatePageAuth", -2, false);
    }
  }
  
  public static final class mb
    extends c.g
  {
    public mb()
    {
      super("", 10000, false);
    }
  }
  
  static final class mc
    extends c.g
  {
    mc()
    {
      super("updateAppMessageShareData", 326, false);
    }
  }
  
  public static final class md
    extends c.g
  {
    public md()
    {
      super("", 10000, false);
    }
  }
  
  static final class me
    extends c.g
  {
    me()
    {
      super("updateTimelineShareData", 327, false);
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
      super("updateWASearchTemplate", 10000, false);
    }
  }
  
  static final class mh
    extends c.g
  {
    mh()
    {
      super("uploadEncryptMediaFile", 253, false);
    }
  }
  
  public static final class mi
    extends c.g
  {
    public mi()
    {
      super("uploadImage", 105, true);
    }
  }
  
  public static final class mj
    extends c.g
  {
    public mj()
    {
      super("uploadMediaFile", 237, true);
    }
  }
  
  public static final class mk
    extends c.g
  {
    public mk()
    {
      super("uploadVideo", 192, true);
    }
  }
  
  public static final class ml
    extends c.g
  {
    public ml()
    {
      super("uploadVoice", 102, true);
    }
  }
  
  public static final class mm
    extends c.g
  {
    public mm()
    {
      super("uxSearchOpLog", 10000, false);
    }
  }
  
  public static final class mn
    extends c.g
  {
    public mn()
    {
      super("verifyWCPayPassword", 115, true);
    }
  }
  
  public static final class mo
    extends c.g
  {
    public mo()
    {
      super("vibrateShort", 401, true);
    }
  }
  
  static final class mp
    extends c.g
  {
    mp()
    {
      super("", 10000, false);
    }
  }
  
  public static final class mq
    extends c.g
  {
    public mq()
    {
      super("", 355, true);
    }
  }
  
  static final class mr
    extends c.g
  {
    mr()
    {
      super("wcPrivacyPolicyResult", 315, false);
    }
  }
  
  public static final class ms
    extends c.g
  {
    public ms()
    {
      super("cache", 150, false);
    }
  }
  
  public static final class mt
    extends c.g
  {
    public mt()
    {
      super("videoProxyInit", 156, false);
    }
  }
  
  public static final class mu
    extends c.g
  {
    public mu()
    {
      super("videoProxySetPlayerState", 159, false);
    }
  }
  
  public static final class mv
    extends c.g
  {
    public mv()
    {
      super("videoProxySetPlayerState", 160, false);
    }
  }
  
  public static final class mw
    extends c.g
  {
    public mw()
    {
      super("videoProxyStartPlay", 157, false);
    }
  }
  
  public static final class mx
    extends c.g
  {
    public mx()
    {
      super("videoProxyStopPlay", 158, false);
    }
  }
  
  public static final class my
    extends c.g
  {
    public my()
    {
      super("publicCache", 149, false);
    }
  }
  
  public static final class mz
    extends c.g
  {
    public mz()
    {
      super("videoProxyPreload", 172, false);
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
      super("share_weibo", 3, true);
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
      super("WNNativeAsyncCallback", 10006, false);
    }
  }
  
  public static final class nd
    extends c.g
  {
    public nd()
    {
      super("WNNativeCallbackInitData", 10006, false);
    }
  }
  
  public static final class ne
    extends c.g
  {
    public ne()
    {
      super("WNNativeCallbackOnCaretChange", 10006, false);
    }
  }
  
  public static final class nf
    extends c.g
  {
    public nf()
    {
      super("WNNativeCallbackOnClick", 10006, false);
    }
  }
  
  public static final class ng
    extends c.g
  {
    public ng()
    {
      super("WNNativeCallbackOnLongClick", 10006, false);
    }
  }
  
  public static final class nh
    extends c.g
  {
    public nh()
    {
      super("write_comm_data", 53, false);
    }
  }
  
  static final class ni
    extends c.g
  {
    ni()
    {
      super("calRqt", 319, false);
    }
  }
  
  static final class nj
    extends c.g
  {
    nj()
    {
      super("getCCData", 312, false);
    }
  }
  
  static final class nk
    extends c.g
  {
    nk()
    {
      super("openRealnameAuth", 314, true);
    }
  }
  
  public static final class nl
    extends c.g
  {
    public nl()
    {
      super("WNNativeCallbackOnBecomeEditing", 10006, false);
    }
  }
  
  public static final class nm
    extends c.g
  {
    public nm()
    {
      super("WNNativeCallbackOnBecomeEdited", 10006, false);
    }
  }
  
  public static final class nn
    extends c.g
  {
    public nn()
    {
      super("", 317, true);
    }
  }
  
  public static final class no
    extends c.g
  {
    public no()
    {
      super("", 129, false);
    }
  }
  
  public static final class np
    extends c.g
  {
    public np()
    {
      super("", 89, false);
    }
  }
  
  public static final class nq
    extends c.g
  {
    public nq()
    {
      super("", 94, false);
    }
  }
  
  public static final class nr
    extends c.g
  {
    public nr()
    {
      super("", 134, false);
    }
  }
  
  public static final class ns
    extends c.g
  {
    public ns()
    {
      super("", 88, false);
    }
  }
  
  public static final class nt
    extends c.g
  {
    public nt()
    {
      super("", 109, false);
    }
  }
  
  public static final class nu
    extends c.g
  {
    public nu()
    {
      super("", 320, true);
    }
  }
  
  public static final class nv
    extends c.g
  {
    public nv()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.c
 * JD-Core Version:    0.7.0.1
 */