package com.tencent.mm.protocal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  private static Map<String, c.g> soP = null;
  
  public static c.g Xq(String paramString)
  {
    if ((soP == null) || (soP.size() <= 0))
    {
      Object localObject = new HashMap(128);
      soP = (Map)localObject;
      ((Map)localObject).put("log", new dx());
      soP.put("imagePreview", new c.dh());
      soP.put("profile", new c.gj());
      soP.put("shareWeibo", new c.ks());
      soP.put("shareTimeline", new js());
      soP.put("adDataReport", new m());
      soP.put("streamingVideoPlay", new c.jp());
      soP.put("addContact", new c.h());
      soP.put("sendAppMessage", new c.hn());
      soP.put("scanQRCode", new c.hf());
      soP.put("hideOptionMenu", new df());
      soP.put("showOptionMenu", new c.ix());
      soP.put("getNetworkType", new c.cd());
      soP.put("closeWindow", new c.ai());
      soP.put("getInstallState", new by());
      soP.put("setFontSizeCallback", new c.ib());
      soP.put("jumpToInstallUrl", new c.dn());
      soP.put("launchApp", new c.dt());
      soP.put("getBrandWCPayRequest", new bo());
      soP.put("secureTunnel", new c.hh());
      soP.put("editAddress", new c.ba());
      soP.put("getHeadingAndPitch", new c.bv());
      soP.put("sendEmail", new c.hs());
      soP.put("addDownloadTask", new c.j());
      soP.put("cancelDownloadTask", new c.r());
      soP.put("pauseDownloadTask", new c.gc());
      soP.put("resumeDownloadTask", new c.hd());
      soP.put("queryDownloadTask", new c.gk());
      soP.put("installDownloadTask", new c.dk());
      soP.put("getLatestAddress", new c.cg());
      soP.put("openSpecificView", new c.fp());
      soP.put("jumpWCMall", new c.dp());
      soP.put("launch3rdApp", new c.ds());
      soP.put("writeCommData", new c.kz());
      soP.put("openUrlByExtBrowser", new c.fq());
      soP.put("geoLocation", new c.bl());
      soP.put("getBrandWCPayBindCardRequest", new c.bn());
      soP.put("openProductView", new c.fj());
      soP.put("openProductViewWithPid", new c.fk());
      soP.put("jumpToBizProfile", new c.do());
      soP.put("openTimelineCheckInList", new c.ed());
      soP.put("openLocation", new c.ec());
      soP.put("timelineCheckIn", new c.eb());
      soP.put("getBrandWCPayCreateCreditCardRequest", new fv());
      soP.put("chooseCard", new c.w());
      soP.put("chooseInvoice", new c.z());
      soP.put("sendServiceAppMessage", new c.ht());
      soP.put("musicPlay", new c.ea());
      soP.put("mmsf0001", new br());
      soP.put("connectToWiFi", new c.an());
      soP.put("getTransferMoneyRequest", new c.cv());
      soP.put("openWCPaySpecificView", new c.fs());
      soP.put("setCloseWindowConfirmDialogInfo", new c.hz());
      soP.put("batchAddCard", new c.o());
      soP.put("preVerifyJSAPI", new gi());
      soP.put("startRecord", new c.jf());
      soP.put("stopRecord", new c.jm());
      soP.put("playVoice", new c.ge());
      soP.put("pauseVoice", new c.gd());
      soP.put("stopVoice", new c.jo());
      soP.put("uploadVoice", new kf());
      soP.put("downloadVoice", new c.ax());
      soP.put("chooseImage", new y());
      soP.put("uploadImage", new c.kc());
      soP.put("downloadImage", new c.aw());
      soP.put("uploadMediaFile", new kd());
      soP.put("hideMenuItems", new c.dd());
      soP.put("showMenuItems", new c.iv());
      soP.put("hideAllNonBaseMenuItem", new c.dc());
      soP.put("showAllNonBaseMenuItem", new c.is());
      soP.put("checkJsApi", new c.v());
      soP.put("translateVoice", new c.jt());
      soP.put("shareQQ", new c.ip());
      soP.put("shareWeiboApp", new c.ir());
      soP.put("shareQZone", new c.iq());
      soP.put("connectToFreeWifi", new c.am());
      soP.put("getSendC2CMessageRequest", new cs());
      soP.put("batchViewCard", new p());
      soP.put("configWXDeviceWiFi", new al());
      soP.put("getCurrentSSID", new c.bp());
      soP.put("setPageOwner", new c.ih());
      soP.put("getWechatVerifyTicket", new c.cx());
      soP.put("openWXDeviceLib", new c.fw());
      soP.put("startScanWXDevice", new c.jg());
      soP.put("stopScanWXDevice", new c.jn());
      soP.put("connectWXDevice", new ao());
      soP.put("disconnectWXDevice", new c.av());
      soP.put("getWXDeviceTicket", new c.da());
      soP.put("getWXDeviceInfos", new c.cz());
      soP.put("sendDataToWXDevice", new c.hp());
      soP.put("closeWXDeviceLib", new c.ak());
      soP.put("setSendDataDirection", new c.il());
      soP.put("verifyWCPayPassword", new c.kh());
      soP.put("getPaymentOrderRequest", new c.cf());
      soP.put("openGameDetail", new c.ez());
      soP.put("openGameCenter", new c.ey());
      soP.put("setGameDebugConfig", new c.id());
      soP.put("startTempSession", new c.ji());
      soP.put("getH5PrepayRequest", new c.bw());
      soP.put("getH5TransactionRequest", new c.bx());
      soP.put("menu:share:timeline", new c.lk());
      soP.put("menu:share:appmessage", new c.lh());
      soP.put("menu:share:qq", new li());
      soP.put("menu:share:weiboApp", new c.ll());
      soP.put("menu:setfont", new c.lg());
      soP.put("menu:share:weibo", new c.ll());
      soP.put("menu:share:QZone", new c.lj());
      soP.put("getRecevieBizHongBaoRequest", new c.e());
      soP.put("insertVideoPlayer", new c.dj());
      soP.put("updateVideoPlayer", new c.ka());
      soP.put("removeVideoPlayer", new c.gq());
      soP.put("operateVideoPlayer", new c.ga());
      soP.put("deleteSearchHistory", new c.as());
      soP.put("getSearchHistory", new c.co());
      soP.put("getSearchData", new c.ck());
      soP.put("getPoiInfo", new c.bu());
      soP.put("updateReddotTimeStamps", new c.jw());
      soP.put("getTeachSearchData", new c.cu());
      soP.put("getSearchGuideData", new c.cn());
      soP.put("getSearchAvatarList", new cj());
      soP.put("getSearchSnsImageList", new c.cq());
      soP.put("getSearchImageList", new c.cp());
      soP.put("getSearchDisplayNameList", new cl());
      soP.put("startSearchItemDetailPage", new c.jh());
      soP.put("reportSearchStatistics", new c.gx());
      soP.put("reportSearchRealTimeStatistics", new c.gw());
      soP.put("searchDataHasResult", new c.hg());
      soP.put("openEmotionPage", new c.bj());
      soP.put("getSearchSuggestionData", new c.cr());
      soP.put("setSearchInputWord", new c.ik());
      soP.put("setSnsObjectXmlDescList", new c.im());
      soP.put("clickSnsMusicPlayButton", new c.ah());
      soP.put("openWeAppPage", new c.fu());
      soP.put("reportWeAppSearchRealtime", new c.kt());
      soP.put("doSearchOperation", new c.az());
      soP.put("insertSearchWAWidgetView", new c.di());
      soP.put("removeSearchWAWidgetView", new c.gp());
      soP.put("updateSearchWAWidgetView", new c.jy());
      soP.put("showSearchActionSheet", new c.iy());
      soP.put("cancelSearchActionSheet", new c.s());
      soP.put("uxSearchOpLog", new c.kg());
      soP.put("jumpToWXWallet", new c.dq());
      soP.put("scanCover", new f());
      soP.put("reportActionInfo", new c.gr());
      soP.put("openMyDeviceProfile", new c.fg());
      soP.put("selectPedometerSource", new c.hk());
      soP.put("nfcIsConnect", new c.ej());
      soP.put("nfcConnect", new c.eg());
      soP.put("nfcTransceive", new c.ek());
      soP.put("nfcBatchTransceive", new c.ee());
      soP.put("nfcGetId", new c.eh());
      soP.put("nfcGetInfo", new ei());
      soP.put("startMonitoringBeacons", new c.jd());
      soP.put("stopMonitoringBeacons", new c.jk());
      soP.put("nfcCheckState", new c.ef());
      soP.put("videoProxyInit", new c.kl());
      soP.put("videoProxyStartPlay", new c.ko());
      soP.put("videoProxyStopPlay", new c.kp());
      soP.put("videoProxySetPlayerState", new c.km());
      soP.put("videoProxySetRemainTime", new c.kn());
      soP.put("videoProxyPreload", new c.kr());
      soP.put("getWebPayCheckoutCounterRequst", new c.dw());
      soP.put("addCustomMenuItems", new c.i());
      soP.put("operateGameCenterMsg", new c.fz());
      soP.put("openEnterpriseChat", new c.ew());
      soP.put("enterEnterpriseChat", new c.be());
      soP.put("openEnterpriseContact", new c.ex());
      soP.put("selectEnterpriseContact", new hj());
      soP.put("getEnterpriseChat", new c.bs());
      soP.put("reportIDKey", new c.gu());
      soP.put("quicklyAddBrandContact", new c.gl());
      soP.put("consumedShareCard", new c.ap());
      soP.put("cache", new c.kk());
      soP.put("publicCache", new c.kq());
      soP.put("kvReport", new c.dr());
      soP.put("realtimeReport", new c.gm());
      soP.put("openUrlWithExtraWebview", new c.fr());
      soP.put("setFreeWifiOwner", new c.ic());
      soP.put("selectSingleContact", new hl());
      soP.put("sendAppMessageToSpecifiedContact", new c.hm());
      soP.put("setLocalData", new c.ie());
      soP.put("getLocalData", new c.bz());
      soP.put("clearLocalData", new af());
      soP.put("showKeyboard", new c.iu());
      soP.put("showSmileyPanel", new ja());
      soP.put("disableBounceScroll", new c.at());
      soP.put("clearBounceBackground", new c.ad());
      soP.put("setNavigationBarButtons", new if());
      soP.put("enableFullScreen", new c.bc());
      soP.put("showNavigationBarLoading", new c.iw());
      soP.put("hideNavigationBarLoading", new c.de());
      soP.put("enablePullDownRefresh", new c.bd());
      soP.put("startPullDownRefresh", new c.je());
      soP.put("stopPullDownRefresh", new jl());
      soP.put("disablePullDownRefresh", new c.au());
      soP.put("setPageTitle", new ii());
      soP.put("setStatusBarStyle", new c.in());
      soP.put("deleteAccountSuccess", new c.ar());
      soP.put("chooseVideo", new c.ac());
      soP.put("uploadVideo", new c.ke());
      soP.put("openMapNavigateMenu", new c.ff());
      soP.put("setNavigationBarColor", new c.ig());
      soP.put("getWCPayRealnameVerify", new c.cw());
      soP.put("openDesignerEmojiView", new c.eq());
      soP.put("openDesignerProfile", new c.es());
      soP.put("openEmoticonTopicList", new c.ev());
      soP.put("openDesignerEmojiViewLocal", new c.er());
      soP.put("openDesignerProfileLocal", new c.et());
      soP.put("openEmotionDetailViewLocal", new d());
      soP.put("openNewPage", new c.fh());
      soP.put("getSearchEmotionData", new c.cm());
      soP.put("openEmotionUrl", new c.bb());
      soP.put("WNNativeCallbackOnClick", new kx());
      soP.put("WNNativeCallbackOnLongClick", new c.ky());
      soP.put("WNNativeCallbackOnCaretChange", new c.kw());
      soP.put("WNNativeCallbackInitData", new kv());
      soP.put("WNNativeAsyncCallback", new c.ku());
      soP.put("WNNativeCallbackOnBecomeEditing", new c.ld());
      soP.put("WNNativeCallbackOnBecomeEdited", new c.le());
      soP.put("changePayActivityView", new c.t());
      soP.put("selectWalletCurrency", new c.jq());
      soP.put("scanLicence", new c.he());
      soP.put("operateMusicPlayer", new c.b());
      soP.put("getMusicPlayerState", new c.a());
      soP.put("clearWebviewCache", new c.ag());
      soP.put("requireSoterBiometricAuthentication", new c.jb());
      soP.put("getSupportSoter", new c.jc());
      soP.put("unbindBankCard", new ju());
      soP.put("setBounceBackground", new c.hy());
      soP.put("sendEnterpriseChat", new c.hq());
      soP.put("doExposePreparation", new c.ay());
      soP.put("getMsgProofItems", new c.cc());
      soP.put("openSecurityView", new fo());
      soP.put("startVoipCall", new c.jj());
      soP.put("chooseInvoiceTitle", new c.aa());
      soP.put("getOpenDeviceId", new c.ce());
      soP.put("getRouteUrl", new c.ci());
      soP.put("idCardRealnameVerify", new c.dg());
      soP.put("uploadIdCardSuccess", new c.ln());
      soP.put("showDatePickerView", new c.it());
      soP.put("openLuckyMoneyDetailView", new fd());
      soP.put("resendRemittanceMsg", new hc());
      soP.put("getGameCommInfo", new c.bt());
      soP.put("openGameRegion", new c.fa());
      soP.put("chooseIdCard", new c.x());
      soP.put("getLocalImgData", new c.c());
      soP.put("openWeApp", new c.ft());
      soP.put("recordVideo", new c.gn());
      soP.put("previewVideo", new c.gh());
      soP.put("uploadEncryptMediaFile", new c.kb());
      soP.put("chooseMedia", new c.ab());
      soP.put("requestWxFacePictureVerify", new c.bf());
      soP.put("openCustomWebview", new c.ep());
      soP.put("forceUpdateWxaAttr", new c.bi());
      soP.put("openLuckyMoneyHistory", new c.fe());
      soP.put("menuitem:gameSendDesktop", new c.hr());
      soP.put("getWePkgAuthResult", new c.cy());
      soP.put("getLocalWePkgInfo", new c.ca());
      soP.put("openGameWebView", new c.fc());
      soP.put("reportGameWeb", new c.gt());
      soP.put("launchApplication", new c.du());
      soP.put("showSearchOfBizHistory", new c.iz());
      soP.put("login", new c.dy());
      soP.put("authorize", new c.n());
      soP.put("requestWxFacePictureVerifyUnionVideo", new bg());
      soP.put("checkIsSupportFaceDetect", new c.u());
      soP.put("operateBackgroundAudio", new c.fy());
      soP.put("setBackgroundAudioState", new c.hx());
      soP.put("getBackgroundAudioState", new c.bm());
      soP.put("addDownloadTaskStraight", new c.k());
      soP.put("setScreenOrientation", new c.ij());
      soP.put("addToEmoticon", new c.l());
      soP.put("shareEmoticon", new c.io());
      soP.put("makePhoneCall", new c.dz());
      soP.put("openADCanvas", new c.eo());
      soP.put("openSearchCanvas", new fl());
      soP.put("opVoteAdData", new c.gb());
      soP.put("requestWxFaceRegisterInternal", new c.gz());
      soP.put("requestWxFaceVerifyInternal", new c.ha());
      soP.put("launchMiniProgram", new dv());
      soP.put("reportMiniProgramPageData", new c.gv());
      soP.put("selectContact", new c.hi());
      soP.put("openSearchWAWidgetLogView", new c.fm());
      soP.put("reloadSearchWAWidgetData", new c.go());
      soP.put("closeWindowAndGoNext", new c.aj());
      soP.put("requestWxVoicePrintVerifyInternal", new c.hb());
      soP.put("openBizChat", new c.en());
      soP.put("handleWCPayWalletBuffer", new c.db());
      soP.put("tapSearchWAWidgetView", new c.jr());
      soP.put("getMatchContactList", new c.cb());
      soP.put("openSearchWebView", new c.fn());
      soP.put("openWXSearchPage", new c.fx());
      soP.put("viewTypeChange", new c.ki());
      soP.put("invokeMiniProgramAPI", new c.dl());
      soP.put("openGameUrlWithExtraWebView", new c.fb());
      soP.put("setGameData", new c.ia());
      soP.put("getGameData", new c.bq());
      soP.put("clearGameData", new c.ae());
      soP.put("openECard", new c.eu());
      soP.put("reportGamePageTime", new c.gs());
      soP.put("setWCPayPassword", new c.hw());
      soP.put("openWCPayCardList", new c.em());
      soP.put("bindEmail", new c.q());
      soP.put("openOfflinePayView", new c.fi());
      soP.put("bindEmail", new c.q());
      soP.put("doGoToRecVideoList", new c.ch());
      soP.put("jumpWSRecVideoList", new c.lf());
      soP.put("openWebSearchOutLinkItem", new c.lm());
      soP.put("recordHistory", new c.bk());
      localObject = new LinkedList();
      ((List)localObject).add(new gg());
      ((List)localObject).add(new c.gf());
      ((List)localObject).add(new c.ho());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        c.g localg = (c.g)((Iterator)localObject).next();
        soP.put(localg.getName(), localg);
      }
      soP.put("getSystemInfo", new c.ct());
      soP.put("serviceClick", new c.hv());
      soP.put("openRealnameAuth", new c.lc());
      soP.put("sendSingleAppMessage", new hu());
      soP.put("wcPrivacyPolicyResult", new c.kj());
      soP.put("currentMpInfo", new c.aq());
      soP.put("updateAppMessageShareData", new c.jx());
      soP.put("updateTimelineShareData", new c.jz());
      soP.put("getCCData", new c.lb());
      soP.put("calRqt", new c.la());
      soP.put("faceVerifyForPay", new c.bh());
      soP.put("request", new gy());
      soP.put("notifyPageInfo", new el());
      soP.put("updatePageAuth", new c.jv());
      soP.put("jumpDownloaderApp", new dm());
    }
    return (c.g)soP.get(paramString);
  }
  
  public static final class af
    extends c.g
  {
    public af()
    {
      super("clearLocalData", 181, false);
    }
  }
  
  public static final class al
    extends c.g
  {
    public al()
    {
      super("configWXDeviceWiFi", 126, true);
    }
  }
  
  public static final class ao
    extends c.g
  {
    public ao()
    {
      super("connectWXDevice", 123, true);
    }
  }
  
  private static final class bg
    extends c.g
  {
    bg()
    {
      super("requestWxFacePictureVerifyUnionVideo", 264, true);
    }
  }
  
  public static final class bo
    extends c.g
  {
    public bo()
    {
      super("get_brand_wcpay_request", 28, true);
    }
  }
  
  public static final class br
    extends c.g
  {
    public br()
    {
      super("mmsf0001", -2, false);
    }
  }
  
  public static final class by
    extends c.g
  {
    public by()
    {
      super("get_install_state", 25, false);
    }
  }
  
  public static final class cj
    extends c.g
  {
    public cj()
    {
      super("", 10000, false);
    }
  }
  
  public static final class cl
    extends c.g
  {
    public cl()
    {
      super("getSearchDisplayNameList", 10000, false);
    }
  }
  
  public static final class cs
    extends c.g
  {
    public cs()
    {
      super("get_send_c2c_message_request", 83, true);
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
  
  public static final class df
    extends c.g
  {
    public df()
    {
      super("", 14, false);
    }
  }
  
  private static final class dm
    extends c.g
  {
    dm()
    {
      super("jumpDownloaderApp", -2, true);
    }
  }
  
  private static final class dv
    extends c.g
  {
    dv()
    {
      super("launchMiniProgram", 277, true);
    }
  }
  
  public static final class dx
    extends c.g
  {
    public dx()
    {
      super("", 0, false);
    }
  }
  
  public static final class ei
    extends c.g
  {
    public ei()
    {
      super("nfcGetInfo", 148, false);
    }
  }
  
  private static final class el
    extends c.g
  {
    el()
    {
      super("notifyPageInfo", -2, false);
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
  
  public static final class fd
    extends c.g
  {
    public fd()
    {
      super("openLuckyMoneyDetailView", 245, false);
    }
  }
  
  private static final class fl
    extends c.g
  {
    fl()
    {
      super("openSearchCanvas", 283, true);
    }
  }
  
  public static final class fo
    extends c.g
  {
    public fo()
    {
      super("openSecurityView", 229, false);
    }
  }
  
  public static final class fv
    extends c.g
  {
    public fv()
    {
      super("get_wcpay_create_credit_card_request", 65, true);
    }
  }
  
  private static final class gg
    extends c.g
  {
    gg()
    {
      super("preloadMiniProgramEnv", 302, false);
    }
  }
  
  public static final class gi
    extends c.g
  {
    public gi()
    {
      super("pre_verify_jsapi", -3, false);
    }
  }
  
  private static final class gy
    extends c.g
  {
    gy()
    {
      super("request", 331, false);
    }
  }
  
  public static final class hc
    extends c.g
  {
    public hc()
    {
      super("resendRemittanceMsg", 246, true);
    }
  }
  
  public static final class hj
    extends c.g
  {
    public hj()
    {
      super("selectEnterpriseContact", 286, true);
    }
  }
  
  public static final class hl
    extends c.g
  {
    public hl()
    {
      super("selectSingleContact", 167, true);
    }
  }
  
  private static final class hu
    extends c.g
  {
    hu()
    {
      super("sendSingleAppMessage", 316, true);
    }
  }
  
  public static final class if
    extends c.g
  {
    public if()
    {
      super("setNavigationBarButtons", 195, false);
    }
  }
  
  public static final class ii
    extends c.g
  {
    public ii()
    {
      super("setPageTitle", 113, false);
    }
  }
  
  public static final class ja
    extends c.g
  {
    public ja()
    {
      super("showSmileyPanel", 238, false);
    }
  }
  
  public static final class jl
    extends c.g
  {
    public jl()
    {
      super("stopPullDownRefresh", 200, false);
    }
  }
  
  public static final class js
    extends c.g
  {
    public js()
    {
      super("share_timeline", 4, true);
    }
  }
  
  public static final class ju
    extends c.g
  {
    public ju()
    {
      super("unbindBankCard", 216, true);
    }
  }
  
  public static final class kd
    extends c.g
  {
    public kd()
    {
      super("uploadMediaFile", 237, true);
    }
  }
  
  public static final class kf
    extends c.g
  {
    public kf()
    {
      super("uploadVoice", 102, true);
    }
  }
  
  public static final class kv
    extends c.g
  {
    public kv()
    {
      super("WNNativeCallbackInitData", 10006, false);
    }
  }
  
  public static final class kx
    extends c.g
  {
    public kx()
    {
      super("WNNativeCallbackOnClick", 10006, false);
    }
  }
  
  public static final class li
    extends c.g
  {
    public li()
    {
      super("", 94, false);
    }
  }
  
  public static final class m
    extends c.g
  {
    public m()
    {
      super("ad_data_report", 221, false);
    }
  }
  
  public static final class p
    extends c.g
  {
    public p()
    {
      super("batchViewCard", 111, true);
    }
  }
  
  public static final class y
    extends c.g
  {
    public y()
    {
      super("chooseImage", 104, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c
 * JD-Core Version:    0.7.0.1
 */