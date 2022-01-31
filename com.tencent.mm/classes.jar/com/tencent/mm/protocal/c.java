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
  private static Map<String, c.g> whv;
  public static final String[] whw;
  
  static
  {
    AppMethodBeat.i(151635);
    whv = null;
    whw = (String[])new c.1().toArray(new String[0]);
    AppMethodBeat.o(151635);
  }
  
  public static Bundle anl(String paramString)
  {
    AppMethodBeat.i(79962);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("handle", true);
    localBundle.putString("handle_result", paramString);
    AppMethodBeat.o(79962);
    return localBundle;
  }
  
  public static c.g anm(String paramString)
  {
    AppMethodBeat.i(79963);
    if ((whv == null) || (whv.size() <= 0))
    {
      Object localObject = new HashMap(128);
      whv = (Map)localObject;
      ((Map)localObject).put("log", new el());
      whv.put("imagePreview", new c.dt());
      whv.put("profile", new c.hb());
      whv.put("shareWeibo", new c.lq());
      whv.put("shareTimeline", new c.kp());
      whv.put("adDataReport", new c.n());
      whv.put("streamingVideoPlay", new c.km());
      whv.put("addContact", new c.h());
      whv.put("getWidgetCaptureImgUrl", new c.dg());
      whv.put("sendAppMessage", new ii());
      whv.put("scanQRCode", new c.ia());
      whv.put("hideOptionMenu", new c.dq());
      whv.put("showOptionMenu", new js());
      whv.put("getNetworkType", new c.ck());
      whv.put("closeWindow", new c.am());
      whv.put("getInstallState", new c.cf());
      whv.put("setFontSizeCallback", new c.iw());
      whv.put("jumpToInstallUrl", new c.ea());
      whv.put("launchApp", new c.eg());
      whv.put("getBrandWCPayRequest", new c.bu());
      whv.put("secureTunnel", new c.ic());
      whv.put("editAddress", new bf());
      whv.put("getHeadingAndPitch", new c.cc());
      whv.put("sendEmail", new c.in());
      whv.put("addDownloadTask", new c.j());
      whv.put("cancelDownloadTask", new c.t());
      whv.put("pauseDownloadTask", new c.gr());
      whv.put("resumeDownloadTask", new c.hy());
      whv.put("queryDownloadTask", new c.hd());
      whv.put("installDownloadTask", new c.dw());
      whv.put("getLatestAddress", new c.cn());
      whv.put("openSpecificView", new c.gd());
      whv.put("jumpWCMall", new ec());
      whv.put("launch3rdApp", new c.ef());
      whv.put("writeCommData", new c.lx());
      whv.put("openUrlByExtBrowser", new c.ge());
      whv.put("geoLocation", new c.br());
      whv.put("getBrandWCPayBindCardRequest", new c.bt());
      whv.put("openProductView", new c.fx());
      whv.put("openProductViewWithPid", new c.fy());
      whv.put("jumpToBizProfile", new c.eb());
      whv.put("openTimelineCheckInList", new c.er());
      whv.put("openLocation", new c.eq());
      whv.put("timelineCheckIn", new c.ep());
      whv.put("getBrandWCPayCreateCreditCardRequest", new c.gk());
      whv.put("chooseCard", new c.z());
      whv.put("chooseInvoice", new c.ad());
      whv.put("sendServiceAppMessage", new c.io());
      whv.put("musicPlay", new c.eo());
      whv.put("mmsf0001", new c.bx());
      whv.put("connectToWiFi", new c.as());
      whv.put("getTransferMoneyRequest", new c.dc());
      whv.put("openWCPaySpecificView", new gg());
      whv.put("setCloseWindowConfirmDialogInfo", new c.iu());
      whv.put("batchAddCard", new p());
      whv.put("preVerifyJSAPI", new c.gy());
      whv.put("startRecord", new c.kc());
      whv.put("stopRecord", new c.kj());
      whv.put("playVoice", new c.gt());
      whv.put("pauseVoice", new c.gs());
      whv.put("stopVoice", new kl());
      whv.put("uploadVoice", new c.ld());
      whv.put("downloadVoice", new c.bc());
      whv.put("chooseImage", new c.ac());
      whv.put("uploadImage", new c.la());
      whv.put("downloadImage", new c.bb());
      whv.put("uploadMediaFile", new c.lb());
      whv.put("hideMenuItems", new c.do());
      whv.put("showMenuItems", new c.jq());
      whv.put("hideAllNonBaseMenuItem", new c.dn());
      whv.put("showAllNonBaseMenuItem", new c.jn());
      whv.put("checkJsApi", new y());
      whv.put("translateVoice", new c.kq());
      whv.put("shareQQ", new c.jk());
      whv.put("shareWeiboApp", new c.jm());
      whv.put("shareQZone", new c.jl());
      whv.put("connectToFreeWifi", new c.ar());
      whv.put("getSendC2CMessageRequest", new c.cz());
      whv.put("batchViewCard", new c.r());
      whv.put("configWXDeviceWiFi", new c.ap());
      whv.put("getCurrentSSID", new c.bv());
      whv.put("setPageOwner", new c.jc());
      whv.put("getWechatVerifyTicket", new c.de());
      whv.put("openWXDeviceLib", new c.gl());
      whv.put("startScanWXDevice", new kd());
      whv.put("stopScanWXDevice", new c.kk());
      whv.put("connectWXDevice", new c.at());
      whv.put("disconnectWXDevice", new c.ba());
      whv.put("getWXDeviceTicket", new c.di());
      whv.put("getWXDeviceInfos", new c.dh());
      whv.put("sendDataToWXDevice", new c.ik());
      whv.put("closeWXDeviceLib", new ao());
      whv.put("setSendDataDirection", new c.jg());
      whv.put("verifyWCPayPassword", new c.lf());
      whv.put("getPaymentOrderRequest", new c.cm());
      whv.put("openGameDetail", new c.fn());
      whv.put("openGameCenter", new fm());
      whv.put("setGameDebugConfig", new c.iy());
      whv.put("startTempSession", new kf());
      whv.put("getH5PrepayRequest", new c.cd());
      whv.put("getH5TransactionRequest", new c.ce());
      whv.put("menu:share:timeline", new c.mi());
      whv.put("menu:share:appmessage", new mf());
      whv.put("menu:share:qq", new c.mg());
      whv.put("menu:share:weiboApp", new c.mj());
      whv.put("menu:setfont", new c.me());
      whv.put("menu:share:weibo", new c.mj());
      whv.put("menu:share:QZone", new c.mh());
      whv.put("getRecevieBizHongBaoRequest", new c.e());
      whv.put("insertVideoPlayer", new dv());
      whv.put("updateVideoPlayer", new kx());
      whv.put("removeVideoPlayer", new c.hl());
      whv.put("operateVideoPlayer", new c.gp());
      whv.put("deleteSearchHistory", new c.ax());
      whv.put("getSearchHistory", new c.cv());
      whv.put("getSearchData", new c.cr());
      whv.put("getPoiInfo", new c.cb());
      whv.put("updateReddotTimeStamps", new c.kt());
      whv.put("getTeachSearchData", new c.db());
      whv.put("getSearchGuideData", new c.cu());
      whv.put("getSearchAvatarList", new c.cq());
      whv.put("getSearchSnsImageList", new c.cx());
      whv.put("getSearchImageList", new c.cw());
      whv.put("getSearchDisplayNameList", new c.cs());
      whv.put("startSearchItemDetailPage", new c.ke());
      whv.put("reportSearchStatistics", new c.hs());
      whv.put("reportSearchRealTimeStatistics", new c.hr());
      whv.put("searchDataHasResult", new c.ib());
      whv.put("openEmotionPage", new bo());
      whv.put("getSearchSuggestionData", new c.cy());
      whv.put("setSearchInputWord", new c.jf());
      whv.put("setSnsObjectXmlDescList", new c.jh());
      whv.put("clickSnsMusicPlayButton", new al());
      whv.put("openWeAppPage", new c.gj());
      whv.put("reportWeAppSearchRealtime", new c.lr());
      whv.put("doSearchOperation", new c.be());
      whv.put("insertSearchWAWidgetView", new c.du());
      whv.put("removeSearchWAWidgetView", new c.hk());
      whv.put("updateSearchWAWidgetView", new c.kv());
      whv.put("showSearchActionSheet", new c.jt());
      whv.put("cancelSearchActionSheet", new c.v());
      whv.put("showSearchToast", new c.jw());
      whv.put("showSearchLoading", new c.ju());
      whv.put("hideSearchLoading", new c.dr());
      whv.put("updateWASearchTemplate", new c.ky());
      whv.put("preloadSearchWeapp", new c.gw());
      whv.put("uxSearchOpLog", new c.le());
      whv.put("jumpToWXWallet", new c.ed());
      whv.put("scanCover", new f());
      whv.put("reportActionInfo", new c.hm());
      whv.put("openMyDeviceProfile", new c.fu());
      whv.put("selectPedometerSource", new c.if());
      whv.put("nfcIsConnect", new c.ex());
      whv.put("nfcConnect", new c.eu());
      whv.put("nfcTransceive", new c.ey());
      whv.put("nfcBatchTransceive", new c.es());
      whv.put("nfcGetId", new c.ev());
      whv.put("nfcGetInfo", new c.ew());
      whv.put("startMonitoringBeacons", new c.ka());
      whv.put("stopMonitoringBeacons", new c.kh());
      whv.put("nfcCheckState", new c.et());
      whv.put("videoProxyInit", new c.lj());
      whv.put("videoProxyStartPlay", new c.lm());
      whv.put("videoProxyStopPlay", new c.ln());
      whv.put("videoProxySetPlayerState", new c.lk());
      whv.put("videoProxySetRemainTime", new c.ll());
      whv.put("videoProxyPreload", new c.lp());
      whv.put("getWebPayCheckoutCounterRequst", new c.ek());
      whv.put("addCustomMenuItems", new c.i());
      whv.put("operateGameCenterMsg", new go());
      whv.put("openEnterpriseChat", new c.fk());
      whv.put("enterEnterpriseChat", new c.bj());
      whv.put("openEnterpriseContact", new fl());
      whv.put("selectEnterpriseContact", new c.ie());
      whv.put("getEnterpriseChat", new c.bz());
      whv.put("reportIDKey", new c.hp());
      whv.put("quicklyAddBrandContact", new c.hg());
      whv.put("consumedShareCard", new c.au());
      whv.put("cache", new c.li());
      whv.put("publicCache", new c.lo());
      whv.put("kvReport", new c.ee());
      whv.put("realtimeReport", new c.hh());
      whv.put("openUrlWithExtraWebview", new c.gf());
      whv.put("setFreeWifiOwner", new c.ix());
      whv.put("selectSingleContact", new c.ig());
      whv.put("sendAppMessageToSpecifiedContact", new c.ih());
      whv.put("setLocalData", new c.iz());
      whv.put("getLocalData", new c.cg());
      whv.put("clearLocalData", new c.aj());
      whv.put("showKeyboard", new c.jp());
      whv.put("showSmileyPanel", new c.jx());
      whv.put("disableBounceScroll", new c.ay());
      whv.put("clearBounceBackground", new c.ah());
      whv.put("setNavigationBarButtons", new ja());
      whv.put("enableFullScreen", new bh());
      whv.put("showNavigationBarLoading", new c.jr());
      whv.put("hideNavigationBarLoading", new c.dp());
      whv.put("enablePullDownRefresh", new c.bi());
      whv.put("startPullDownRefresh", new c.kb());
      whv.put("stopPullDownRefresh", new c.ki());
      whv.put("disablePullDownRefresh", new c.az());
      whv.put("setPageTitle", new c.jd());
      whv.put("setStatusBarStyle", new ji());
      whv.put("deleteAccountSuccess", new c.aw());
      whv.put("chooseVideo", new c.ag());
      whv.put("uploadVideo", new c.lc());
      whv.put("openMapNavigateMenu", new c.ft());
      whv.put("setNavigationBarColor", new jb());
      whv.put("getWCPayRealnameVerify", new c.dd());
      whv.put("openDesignerEmojiView", new fe());
      whv.put("openDesignerProfile", new c.fg());
      whv.put("openEmoticonTopicList", new c.fj());
      whv.put("openDesignerEmojiViewLocal", new c.ff());
      whv.put("openDesignerProfileLocal", new c.fh());
      whv.put("openEmotionDetailViewLocal", new c.d());
      whv.put("openNewPage", new fv());
      whv.put("getSearchEmotionData", new c.ct());
      whv.put("openEmotionUrl", new bg());
      whv.put("WNNativeCallbackOnClick", new c.lv());
      whv.put("WNNativeCallbackOnLongClick", new c.lw());
      whv.put("WNNativeCallbackOnCaretChange", new c.lu());
      whv.put("WNNativeCallbackInitData", new c.lt());
      whv.put("WNNativeAsyncCallback", new ls());
      whv.put("WNNativeCallbackOnBecomeEditing", new c.mb());
      whv.put("WNNativeCallbackOnBecomeEdited", new mc());
      whv.put("changePayActivityView", new w());
      whv.put("selectWalletCurrency", new c.kn());
      whv.put("scanLicence", new c.hz());
      whv.put("operateMusicPlayer", new c.b());
      whv.put("getMusicPlayerState", new c.a());
      whv.put("clearWebviewCache", new c.ak());
      whv.put("requireSoterBiometricAuthentication", new c.jy());
      whv.put("getSupportSoter", new c.jz());
      whv.put("unbindBankCard", new c.kr());
      whv.put("setBounceBackground", new c.it());
      whv.put("sendEnterpriseChat", new c.il());
      whv.put("doExposePreparation", new c.bd());
      whv.put("getMsgProofItems", new cj());
      whv.put("openSecurityView", new c.gc());
      whv.put("startVoipCall", new c.kg());
      whv.put("chooseInvoiceTitle", new c.ae());
      whv.put("getOpenDeviceId", new cl());
      whv.put("getRouteUrl", new c.cp());
      whv.put("idCardRealnameVerify", new c.ds());
      whv.put("uploadIdCardSuccess", new c.ml());
      whv.put("showDatePickerView", new c.jo());
      whv.put("openLuckyMoneyDetailView", new c.fr());
      whv.put("resendRemittanceMsg", new c.hx());
      whv.put("getGameCommInfo", new c.ca());
      whv.put("openGameRegion", new c.fo());
      whv.put("chooseIdCard", new c.ab());
      whv.put("getLocalImgData", new c.c());
      whv.put("openWeApp", new gi());
      whv.put("recordVideo", new c.hi());
      whv.put("previewVideo", new c.gx());
      whv.put("uploadEncryptMediaFile", new c.kz());
      whv.put("chooseMedia", new af());
      whv.put("requestWxFacePictureVerify", new c.bk());
      whv.put("openCustomWebview", new fd());
      whv.put("forceUpdateWxaAttr", new c.bn());
      whv.put("openLuckyMoneyHistory", new c.fs());
      whv.put("menuitem:gameSendDesktop", new c.im());
      whv.put("getWePkgAuthResult", new c.df());
      whv.put("getLocalWePkgInfo", new c.ch());
      whv.put("openGameWebView", new c.fq());
      whv.put("reportGameWeb", new c.ho());
      whv.put("launchApplication", new c.eh());
      whv.put("showSearchOfBizHistory", new c.jv());
      whv.put("login", new c.em());
      whv.put("authorize", new o());
      whv.put("requestWxFacePictureVerifyUnionVideo", new c.bl());
      whv.put("checkIsSupportFaceDetect", new x());
      whv.put("operateBackgroundAudio", new c.gn());
      whv.put("setBackgroundAudioState", new c.is());
      whv.put("getBackgroundAudioState", new c.bs());
      whv.put("addDownloadTaskStraight", new c.k());
      whv.put("setScreenOrientation", new c.je());
      whv.put("addToEmoticon", new c.m());
      whv.put("shareEmoticon", new jj());
      whv.put("makePhoneCall", new c.en());
      whv.put("openADCanvas", new fc());
      whv.put("openSearchCanvas", new c.fz());
      whv.put("opVoteAdData", new c.gq());
      whv.put("requestWxFaceRegisterInternal", new hu());
      whv.put("requestWxFaceVerifyInternal", new hv());
      whv.put("launchMiniProgram", new c.ej());
      whv.put("reportMiniProgramPageData", new c.hq());
      whv.put("selectContact", new c.id());
      whv.put("openSearchWAWidgetLogView", new c.ga());
      whv.put("reloadSearchWAWidgetData", new c.hj());
      whv.put("gotoEmoticonPad", new c.dj());
      whv.put("querySimilarEmotion", new c.hf());
      whv.put("closeWindowAndGoNext", new c.an());
      whv.put("requestWxVoicePrintVerifyInternal", new c.hw());
      whv.put("openBizChat", new c.fb());
      whv.put("handleWCPayWalletBuffer", new c.dm());
      whv.put("tapSearchWAWidgetView", new c.ko());
      whv.put("getMatchContactList", new c.ci());
      whv.put("openSearchWebView", new c.gb());
      whv.put("openWXSearchPage", new c.gm());
      whv.put("viewTypeChange", new c.lg());
      whv.put("invokeMiniProgramAPI", new dy());
      whv.put("openGameUrlWithExtraWebView", new c.fp());
      whv.put("setGameData", new c.iv());
      whv.put("getGameData", new c.bw());
      whv.put("clearGameData", new c.ai());
      whv.put("openECard", new c.fi());
      whv.put("reportGamePageTime", new c.hn());
      whv.put("setWCPayPassword", new c.ir());
      whv.put("openWCPayCardList", new c.fa());
      whv.put("bindEmail", new c.s());
      whv.put("openOfflinePayView", new c.fw());
      whv.put("bindEmail", new c.s());
      whv.put("doGoToRecVideoList", new c.co());
      whv.put("jumpWSRecVideoList", new c.md());
      whv.put("openWebSearchOutLinkItem", new c.mk());
      whv.put("recordHistory", new c.bq());
      localObject = new LinkedList();
      ((List)localObject).add(new c.gv());
      ((List)localObject).add(new c.gu());
      ((List)localObject).add(new c.ij());
      ((List)localObject).add(new c.dk());
      ((List)localObject).add(new c.dl());
      ((List)localObject).add(new c.ha());
      ((List)localObject).add(new c.gz());
      ((List)localObject).add(new bp());
      ((List)localObject).add(new c.gh());
      ((List)localObject).add(new c.aq());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        c.g localg = (c.g)((Iterator)localObject).next();
        whv.put(localg.getName(), localg);
      }
      whv.put("getSystemInfo", new c.da());
      whv.put("serviceClick", new c.iq());
      whv.put("openRealnameAuth", new c.ma());
      whv.put("sendSingleAppMessage", new c.ip());
      whv.put("wcPrivacyPolicyResult", new c.lh());
      whv.put("currentMpInfo", new c.av());
      whv.put("updateAppMessageShareData", new c.ku());
      whv.put("updateTimelineShareData", new c.kw());
      whv.put("getCCData", new lz());
      whv.put("calRqt", new c.ly());
      whv.put("faceVerifyForPay", new c.bm());
      whv.put("request", new c.ht());
      whv.put("notifyPageInfo", new c.ez());
      whv.put("updatePageAuth", new c.ks());
      whv.put("jumpDownloaderWidget", new c.dz());
      whv.put("batchUpdateWepkg", new c.q());
      whv.put("addGameDownloadTask", new c.l());
      whv.put("internelWxFaceVerify", new dx());
      whv.put("getDownloadWidgetTaskInfos", new by());
      whv.put("chooseHaowanMedia", new c.aa());
      whv.put("queryHaowanPublish", new c.he());
      whv.put("publishHaowanEdition", new c.hc());
      whv.put("cancelHaowanPublish", new c.u());
      whv.put("launchGameVideoEditor", new ei());
    }
    paramString = (c.g)whv.get(paramString);
    AppMethodBeat.o(79963);
    return paramString;
  }
  
  static final class af
    extends c.g
  {
    af()
    {
      super("chooseMedia", 254, true);
    }
  }
  
  public static final class al
    extends c.g
  {
    public al()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ao
    extends c.g
  {
    public ao()
    {
      super("closeWXDeviceLib", 118, false);
    }
  }
  
  public static final class bf
    extends c.g
  {
    public bf()
    {
      super("edit_address", 29, true);
    }
  }
  
  public static final class bg
    extends c.g
  {
    public bg()
    {
      super("openEmotionUrl", 20000, false);
    }
  }
  
  public static final class bh
    extends c.g
  {
    public bh()
    {
      super("enableFullScreen", 196, false);
    }
  }
  
  public static final class bo
    extends c.g
  {
    public bo()
    {
      super("", 10000, false);
    }
  }
  
  static final class bp
    extends c.g
  {
    bp()
    {
      super("openBusinessView", 338, true);
    }
  }
  
  static final class by
    extends c.g
  {
    by()
    {
      super("getDownloadWidgetTaskInfos", 340, false);
    }
  }
  
  public static final class cj
    extends c.g
  {
    public cj()
    {
      super("getMsgProofItems", 226, true);
    }
  }
  
  public static final class cl
    extends c.g
  {
    public cl()
    {
      super("getOpenDeviceId", 227, false);
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
  
  public static final class dx
    extends c.g
  {
    dx()
    {
      super("internelWxFaceVerify", 325, true);
    }
  }
  
  static final class dy
    extends c.g
  {
    dy()
    {
      super("invokeMiniProgramAPI", 295, false);
    }
  }
  
  public static final class ec
    extends c.g
  {
    public ec()
    {
      super("jump_wcmall", 51, true);
    }
  }
  
  static final class ei
    extends c.g
  {
    ei()
    {
      super("launchGameVideoEditor", 350, true);
    }
  }
  
  public static final class el
    extends c.g
  {
    public el()
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
  
  static final class fc
    extends c.g
  {
    fc()
    {
      super("openADCanvas", 283, true);
    }
  }
  
  static final class fd
    extends c.g
  {
    fd()
    {
      super("openCustomWebview", 256, false);
    }
  }
  
  public static final class fe
    extends c.g
  {
    public fe()
    {
      super("openDesignerEmojiView", 185, true);
    }
  }
  
  public static final class fl
    extends c.g
  {
    public fl()
    {
      super("openEnterpriseContact", 183, true);
    }
  }
  
  public static final class fm
    extends c.g
  {
    public fm()
    {
      super("openGameCenter", 175, true);
    }
  }
  
  public static final class fv
    extends c.g
  {
    public fv()
    {
      super("openNewPage", 20000, false);
    }
  }
  
  public static final class gg
    extends c.g
  {
    public gg()
    {
      super("open_wcpay_specific_view", 76, true);
    }
  }
  
  static final class gi
    extends c.g
  {
    gi()
    {
      super("openWeApp", 250, false);
    }
  }
  
  public static final class go
    extends c.g
  {
    public go()
    {
      super("operateGameCenterMsg", 174, false);
    }
  }
  
  static final class hu
    extends c.g
  {
    hu()
    {
      super("requestWxFaceRegisterInternal", 272, true);
    }
  }
  
  static final class hv
    extends c.g
  {
    hv()
    {
      super("requestWxFaceVerifyInternal", 273, true);
    }
  }
  
  public static final class ii
    extends c.g
  {
    public ii()
    {
      super("send_app_msg", 6, true);
    }
  }
  
  public static final class ja
    extends c.g
  {
    public ja()
    {
      super("setNavigationBarButtons", 195, false);
    }
  }
  
  public static final class jb
    extends c.g
  {
    public jb()
    {
      super("setNavigationBarColor", 182, false);
    }
  }
  
  public static final class ji
    extends c.g
  {
    public ji()
    {
      super("setStatusBarStyle", 206, false);
    }
  }
  
  static final class jj
    extends c.g
  {
    jj()
    {
      super("shareEmoticon", 275, true);
    }
  }
  
  public static final class js
    extends c.g
  {
    public js()
    {
      super("", 14, false);
    }
  }
  
  public static final class kd
    extends c.g
  {
    public kd()
    {
      super("startScanWXDevice", 121, true);
    }
  }
  
  public static final class kf
    extends c.g
  {
    public kf()
    {
      super("startTempSession", 128, true);
    }
  }
  
  public static final class kl
    extends c.g
  {
    public kl()
    {
      super("stopVoice", 101, false);
    }
  }
  
  public static final class kx
    extends c.g
  {
    public kx()
    {
      super("", 10000, false);
    }
  }
  
  public static final class ls
    extends c.g
  {
    public ls()
    {
      super("WNNativeAsyncCallback", 10006, false);
    }
  }
  
  static final class lz
    extends c.g
  {
    lz()
    {
      super("getCCData", 312, false);
    }
  }
  
  public static final class mc
    extends c.g
  {
    public mc()
    {
      super("WNNativeCallbackOnBecomeEdited", 10006, false);
    }
  }
  
  public static final class mf
    extends c.g
  {
    public mf()
    {
      super("", 89, false);
    }
  }
  
  static final class o
    extends c.g
  {
    o()
    {
      super("authorize", 232, true);
    }
  }
  
  public static final class p
    extends c.g
  {
    public p()
    {
      super("batch_add_card", 82, true);
    }
  }
  
  public static final class w
    extends c.g
  {
    public w()
    {
      super("change_pay_activity_view", 207, true);
    }
  }
  
  static final class x
    extends c.g
  {
    x()
    {
      super("checkIsSupportFaceDetect", 265, false);
    }
  }
  
  public static final class y
    extends c.g
  {
    public y()
    {
      super("checkJsApi", 84, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c
 * JD-Core Version:    0.7.0.1
 */