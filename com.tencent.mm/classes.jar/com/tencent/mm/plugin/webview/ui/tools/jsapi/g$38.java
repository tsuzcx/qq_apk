package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.preload.d;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.c.ccq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.Map;

final class g$38
  extends c.c
{
  g$38(g paramg, i parami, JsapiPermissionWrapper paramJsapiPermissionWrapper, c.g paramg1) {}
  
  public final void a(c.a.a parama, String paramString, LinkedList<ccq> paramLinkedList, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    this.rzk.cgB().put("baseErrorCode", Integer.valueOf(paramInt1));
    this.rzk.cgB().put("jsapiErrorCode", Integer.valueOf(paramInt2));
    paramLinkedList = parama;
    if (this.rzi.TV(this.rzk.rAO))
    {
      y.i("MicroMsg.MsgHandler", "current jsapi(%s) invoked is came from menu event.(original retCode : %s)", new Object[] { this.rzk.rAO, parama });
      paramLinkedList = c.a.a.rxt;
    }
    y.i("MicroMsg.MsgHandler", "onJSVerifyEnd, put webviewID = %d", new Object[] { Integer.valueOf(g.a(this.rzi)) });
    this.rzk.ndL.put("webview_instance_id", Integer.valueOf(g.a(this.rzi)));
    if (paramLinkedList == c.a.a.rxt)
    {
      if (this.rzk.rAO.equals("sendAppMessage"))
      {
        ls(g.a(this.rzi, this.rzk, this.rzL));
        bool = true;
      }
      for (;;)
      {
        parama = this.rzk.cgB().get("Internal@AsyncReport");
        if ((parama == null) || (!(parama instanceof Boolean)) || (!((Boolean)parama).booleanValue())) {
          g.d(this.rzi, this.rzk, bool);
        }
        if (!bool) {
          g.b(this.rzi, this.rzk, paramLinkedList.getCode());
        }
        return;
        if (this.rzk.rAO.equals("profile"))
        {
          ls(g.a(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("shareWeibo"))
        {
          ls(g.b(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("shareTimeline"))
        {
          ls(g.b(this.rzi, this.rzk, this.rzL));
          bool = true;
        }
        else if (this.rzk.rAO.equals("updateTimelineShareData"))
        {
          ls(g.c(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("updateAppMessageShareData"))
        {
          ls(g.d(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("adDataReport"))
        {
          ls(g.e(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("streamingVideoPlay"))
        {
          ls(g.f(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("addContact"))
        {
          ls(g.c(this.rzi, this.rzk, this.rzL));
          bool = true;
        }
        else if (this.rzk.rAO.equals("imagePreview"))
        {
          ls(g.g(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("log"))
        {
          ls(g.h(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("hideOptionMenu"))
        {
          ls(g.b(this.rzi));
          bool = true;
        }
        else if (this.rzk.rAO.equals("showOptionMenu"))
        {
          ls(g.c(this.rzi));
          bool = true;
        }
        else if (this.rzk.rAO.equals("getNetworkType"))
        {
          ls(g.i(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("closeWindow"))
        {
          ls(g.j(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("getInstallState"))
        {
          ls(g.k(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("scanQRCode"))
        {
          ls(g.l(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("setFontSizeCallback"))
        {
          ls(g.m(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("jumpToInstallUrl"))
        {
          ls(g.n(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getBrandWCPayRequest"))
        {
          ls(g.o(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("secureTunnel"))
        {
          ls(g.p(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("editAddress"))
        {
          ls(g.q(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getLatestAddress"))
        {
          ls(g.d(this.rzi));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getHeadingAndPitch"))
        {
          ls(g.r(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("sendEmail"))
        {
          ls(g.s(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("addDownloadTask"))
        {
          ls(g.t(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("cancelDownloadTask"))
        {
          ls(g.u(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("pauseDownloadTask"))
        {
          ls(g.v(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("resumeDownloadTask"))
        {
          ls(g.d(this.rzi, this.rzk, this.rzL));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("queryDownloadTask"))
        {
          ls(g.w(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("installDownloadTask"))
        {
          ls(g.x(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openSpecificView"))
        {
          ls(g.y(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("launch3rdApp"))
        {
          ls(g.z(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("jumpWCMall"))
        {
          ls(g.A(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("writeCommData"))
        {
          ls(g.B(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openUrlByExtBrowser"))
        {
          ls(g.C(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openProductView"))
        {
          ls(g.D(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openProductViewWithPid"))
        {
          ls(g.E(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getBrandWCPayBindCardRequest"))
        {
          ls(g.F(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("geoLocation"))
        {
          ls(g.G(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("jumpToBizProfile"))
        {
          ls(g.H(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openTimelineCheckInList"))
        {
          ls(g.I(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openLocation"))
        {
          ls(g.J(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("timelineCheckIn"))
        {
          ls(g.K(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getBrandWCPayCreateCreditCardRequest"))
        {
          ls(g.L(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("sendServiceAppMessage"))
        {
          ls(g.M(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("mmsf0001"))
        {
          ls(g.N(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("musicPlay"))
        {
          ls(g.O(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("connectToWiFi"))
        {
          ls(g.P(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getTransferMoneyRequest"))
        {
          ls(g.Q(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openWCPaySpecificView"))
        {
          ls(g.R(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("chooseCard"))
        {
          ls(g.S(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("chooseInvoice"))
        {
          ls(g.T(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("batchAddCard"))
        {
          ls(g.U(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("setCloseWindowConfirmDialogInfo"))
        {
          ls(g.V(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("preVerifyJSAPI"))
        {
          ls(g.W(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("startRecord"))
        {
          ls(g.X(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("stopRecord"))
        {
          ls(g.Y(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("playVoice"))
        {
          ls(g.Z(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("pauseVoice"))
        {
          ls(g.aa(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("stopVoice"))
        {
          ls(g.ab(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("uploadVoice"))
        {
          ls(g.ac(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("downloadVoice"))
        {
          ls(g.ad(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("chooseImage"))
        {
          ls(g.ae(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("uploadImage"))
        {
          ls(g.af(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("downloadImage"))
        {
          ls(g.ag(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("hideMenuItems"))
        {
          ls(g.ah(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("showMenuItems"))
        {
          ls(g.ai(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("hideAllNonBaseMenuItem"))
        {
          ls(g.aj(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("showAllNonBaseMenuItem"))
        {
          ls(g.ak(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("checkJsApi"))
        {
          ls(g.al(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("translateVoice"))
        {
          ls(g.am(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("shareQQ"))
        {
          ls(g.an(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("shareWeiboApp"))
        {
          ls(g.ao(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("configWXDeviceWiFi"))
        {
          ls(g.ap(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getCurrentSSID"))
        {
          ls(g.aq(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getPaymentOrderRequest"))
        {
          ls(g.ar(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("verifyWCPayPassword"))
        {
          ls(g.as(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("startMonitoringBeacons"))
        {
          g.e(this.rzi);
          ls(g.a(this.rzi, this.rzk, new int[0]));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("stopMonitoringBeacons"))
        {
          g.e(this.rzi);
          ls(g.b(this.rzi, this.rzk, new int[0]));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getSendC2CMessageRequest"))
        {
          ls(g.at(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("batchViewCard"))
        {
          ls(g.au(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("connectToFreeWifi"))
        {
          ls(g.av(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("setFreeWifiOwner"))
        {
          ls(g.aw(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("setPageOwner"))
        {
          ls(g.ax(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getWechatVerifyTicket"))
        {
          ls(g.ay(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openWXDeviceLib"))
        {
          ls(g.az(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("closeWXDeviceLib"))
        {
          ls(g.aA(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("startScanWXDevice"))
        {
          ls(g.aB(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("stopScanWXDevice"))
        {
          ls(g.aC(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("connectWXDevice"))
        {
          ls(g.aD(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("disconnectWXDevice"))
        {
          ls(g.aE(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getWXDeviceTicket"))
        {
          ls(g.aF(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getWXDeviceInfos"))
        {
          ls(g.aG(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("sendDataToWXDevice"))
        {
          ls(g.aH(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("setSendDataDirection"))
        {
          ls(g.aI(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openGameDetail"))
        {
          ls(g.aJ(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openGameCenter"))
        {
          ls(g.aK(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("setGameDebugConfig"))
        {
          ls(g.aL(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("shareQZone"))
        {
          ls(g.an(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("startTempSession"))
        {
          ls(g.aM(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getRecevieBizHongBaoRequest"))
        {
          ls(g.aN(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openMyDeviceProfile"))
        {
          ls(g.aO(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("selectPedometerSource"))
        {
          ls(this.rzi.ar(this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getH5PrepayRequest"))
        {
          ls(g.aP(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getH5TransactionRequest"))
        {
          ls(g.aQ(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("jumpToWXWallet"))
        {
          ls(g.aR(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("scanCover"))
        {
          ls(g.aS(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("nfcIsConnect"))
        {
          ls(g.aT(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("nfcConnect"))
        {
          ls(g.aU(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("nfcTransceive"))
        {
          ls(g.aV(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("nfcBatchTransceive"))
        {
          ls(g.aW(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("nfcGetId"))
        {
          ls(g.aX(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("nfcGetInfo"))
        {
          ls(g.aY(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("nfcCheckState"))
        {
          ls(g.aZ(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("videoProxyInit"))
        {
          ls(g.ba(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("videoProxyStartPlay"))
        {
          ls(g.bb(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("videoProxyStopPlay"))
        {
          ls(g.bc(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("videoProxySetPlayerState"))
        {
          ls(g.bd(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("videoProxySetRemainTime"))
        {
          ls(g.be(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getSearchData"))
        {
          ls(g.bf(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getPoiInfo"))
        {
          ls(g.bg(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("updateReddotTimeStamps"))
        {
          ls(g.bh(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("reloadSearchWAWidgetData"))
        {
          ls(g.bi(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("insertSearchWAWidgetView"))
        {
          ls(g.bj(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("removeSearchWAWidgetView"))
        {
          ls(g.bk(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("updateSearchWAWidgetView"))
        {
          ls(g.bl(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getTeachSearchData"))
        {
          ls(g.bm(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getSearchGuideData"))
        {
          ls(g.bn(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getSearchAvatarList"))
        {
          ls(g.bo(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getSearchSnsImageList"))
        {
          ls(g.bp(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getSearchImageList"))
        {
          ls(g.bq(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getSearchDisplayNameList"))
        {
          ls(g.br(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("startSearchItemDetailPage"))
        {
          ls(g.bs(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("reportSearchStatistics"))
        {
          ls(g.bt(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("reportSearchRealTimeStatistics"))
        {
          ls(g.bu(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("searchDataHasResult"))
        {
          ls(g.bv(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getSearchSuggestionData"))
        {
          ls(g.bw(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openEmotionPage"))
        {
          ls(g.bx(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("setSearchInputWord"))
        {
          ls(g.by(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openWeAppPage"))
        {
          ls(g.bz(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("reportWeAppSearchRealtime"))
        {
          ls(g.bA(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("doSearchOperation"))
        {
          ls(g.bB(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("operateGameCenterMsg"))
        {
          ls(g.bC(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getWebPayCheckoutCounterRequst"))
        {
          ls(g.bD(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("setSnsObjectXmlDescList"))
        {
          ls(g.bE(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("clickSnsMusicPlayButton"))
        {
          ls(g.bF(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("addCustomMenuItems"))
        {
          ls(g.bG(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openEnterpriseChat"))
        {
          ls(g.bH(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openEnterpriseContact"))
        {
          ls(g.bI(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("selectEnterpriseContact"))
        {
          ls(g.bJ(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("sendEnterpriseChat"))
        {
          ls(g.bK(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("enterEnterpriseChat"))
        {
          ls(g.bL(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getEnterpriseChat"))
        {
          ls(g.bM(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("reportActionInfo"))
        {
          ls(g.bN(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("showSearchOfBizHistory"))
        {
          ls(g.bO(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("cache"))
        {
          ls(g.bP(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("publicCache"))
        {
          ls(g.bQ(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("changePayActivityView"))
        {
          ls(g.bR(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("scanLicence"))
        {
          ls(g.bS(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openWeApp"))
        {
          ls(g.bT(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openECard"))
        {
          ls(g.bU(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("sendDataToMiniProgram"))
        {
          ls(g.bV(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("preloadMiniProgramEnv"))
        {
          ls(g.bW(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("preloadMiniProgramContacts"))
        {
          ls(g.bX(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("enablePullDownRefresh"))
        {
          ls(this.rzi.bD(this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("startPullDownRefresh"))
        {
          ls(this.rzi.bE(this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("stopPullDownRefresh"))
        {
          ls(this.rzi.bF(this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("disablePullDownRefresh"))
        {
          ls(this.rzi.cgv());
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("disableBounceScroll"))
        {
          ls(this.rzi.bI(this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("clearBounceBackground"))
        {
          ls(this.rzi.bJ(this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("showKeyboard"))
        {
          ls(this.rzi.bG(this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("showSmileyPanel"))
        {
          ls(this.rzi.bH(this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openMapNavigateMenu"))
        {
          ls(this.rzi.bM(this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("setNavigationBarButtons"))
        {
          ls(g.bY(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("enableFullScreen"))
        {
          ls(g.bZ(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("reportMiniProgramPageData"))
        {
          ls(g.ca(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("setPageTitle"))
        {
          ls(g.cb(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("setStatusBarStyle"))
        {
          ls(g.cc(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("forceUpdateWxaAttr"))
        {
          ls(g.cd(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("launchMiniProgram"))
        {
          ls(g.ce(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("reportIDKey"))
        {
          ls(g.cf(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("quicklyAddBrandContact"))
        {
          ls(g.cg(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("consumedShareCard"))
        {
          ls(g.ch(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("kvReport"))
        {
          ls(this.rzi.bv(this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("realtimeReport"))
        {
          ls(this.rzi.bL(this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openUrlWithExtraWebview"))
        {
          ls(g.ci(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("videoProxyPreload"))
        {
          ls(g.cj(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getLocalData"))
        {
          ls(g.ck(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("setLocalData"))
        {
          ls(g.cl(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("clearLocalData"))
        {
          ls(g.cm(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("selectSingleContact"))
        {
          ls(g.cn(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("sendAppMessageToSpecifiedContact"))
        {
          ls(g.co(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("deleteAccountSuccess"))
        {
          ls(g.f(this.rzi));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("chooseVideo"))
        {
          ls(g.cp(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("uploadVideo"))
        {
          ls(g.cq(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("setNavigationBarColor"))
        {
          ls(g.cr(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openDesignerEmojiView"))
        {
          ls(g.a(this.rzi, this.rzk, false));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openDesignerProfile"))
        {
          ls(g.b(this.rzi, this.rzk, false));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openEmoticonTopicList"))
        {
          ls(g.cs(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openDesignerEmojiViewLocal"))
        {
          ls(g.a(this.rzi, this.rzk, true));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openDesignerProfileLocal"))
        {
          ls(g.b(this.rzi, this.rzk, true));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openEmotionDetailViewLocal"))
        {
          ls(g.ct(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openNewPage"))
        {
          ls(g.cu(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getSearchEmotionData"))
        {
          ls(g.cv(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openEmotionUrl"))
        {
          ls(g.cw(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("getWCPayRealnameVerify"))
        {
          ls(this.rzi.aQ(this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("selectWalletCurrency"))
        {
          ls(this.rzi.cgt());
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("operateMusicPlayer"))
        {
          ls(g.cx(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getMusicPlayerState"))
        {
          ls(g.cy(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("clearWebviewCache"))
        {
          ls(g.cz(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("requireSoterBiometricAuthentication"))
        {
          ls(g.cA(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("getSupportSoter"))
        {
          ls(g.cB(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("unbindBankCard"))
        {
          ls(g.cC(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("setBounceBackground"))
        {
          ls(this.rzi.bK(this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("doExposePreparation"))
        {
          ls(g.cD(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("getMsgProofItems"))
        {
          ls(g.cE(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("uploadMediaFile"))
        {
          ls(g.cF(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("openSecurityView"))
        {
          ls(g.cG(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("startVoipCall"))
        {
          ls(g.cH(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("getOpenDeviceId"))
        {
          ls(g.cI(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("getRouteUrl"))
        {
          ls(g.cJ(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("idCardRealnameVerify"))
        {
          ls(this.rzi.aS(this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("uploadIdCardSuccess"))
        {
          ls(this.rzi.aT(this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("getGameCommInfo"))
        {
          ls(this.rzi.aU(this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("openGameRegion"))
        {
          ls(this.rzi.cgu());
          bool = true;
        }
        else if (this.rzk.rAO.equals("chooseIdCard"))
        {
          ls(this.rzi.aV(this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("showDatePickerView"))
        {
          ls(g.cK(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("openLuckyMoneyDetailView"))
        {
          ls(g.cL(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("resendRemittanceMsg"))
        {
          ls(g.cM(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("getLocalImgData"))
        {
          ls(g.cN(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("recordVideo"))
        {
          ls(g.cO(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("previewVideo"))
        {
          ls(g.cP(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("uploadEncryptMediaFile"))
        {
          ls(g.cQ(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("openCustomWebview"))
        {
          ls(g.cR(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("chooseMedia"))
        {
          ls(g.cS(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("openLuckyMoneyHistory"))
        {
          ls(g.cT(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("requestWxFacePictureVerify"))
        {
          ls(g.c(this.rzi, this.rzk, false));
          bool = true;
        }
        else if (this.rzk.rAO.equals("getWePkgAuthResult"))
        {
          ls(g.cU(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("getLocalWePkgInfo"))
        {
          ls(g.cV(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("openGameWebView"))
        {
          ls(g.cW(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("launchApplication"))
        {
          ls(g.cX(this.rzi, this.rzk));
          bool = true;
        }
        else if ((this.rzk.rAO.equals("login")) || (this.rzk.rAO.equals("authorize")))
        {
          ls(g.cY(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("requestWxFacePictureVerifyUnionVideo"))
        {
          ls(g.c(this.rzi, this.rzk, true));
          bool = true;
        }
        else if (this.rzk.rAO.equals("checkIsSupportFaceDetect"))
        {
          ls(g.cZ(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("operateBackgroundAudio"))
        {
          ls(g.da(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("setBackgroundAudioState"))
        {
          ls(g.e(this.rzi, this.rzk, this.rzL));
          bool = true;
        }
        else if (this.rzk.rAO.equals("getBackgroundAudioState"))
        {
          ls(g.db(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("addDownloadTaskStraight"))
        {
          ls(g.f(this.rzi, this.rzk, this.rzL));
          bool = true;
        }
        else if (this.rzk.rAO.equals("setScreenOrientation"))
        {
          ls(g.dc(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("addToEmoticon"))
        {
          ls(g.dd(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("shareEmoticon"))
        {
          ls(g.de(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("requestWxFaceRegisterInternal"))
        {
          ls(g.df(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("requestWxFaceVerifyInternal"))
        {
          ls(g.dg(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("openADCanvas"))
        {
          ls(g.a(this.rzi, this.rzk, 0));
          bool = true;
        }
        else if (this.rzk.rAO.equals("openSearchCanvas"))
        {
          ls(g.a(this.rzi, this.rzk, 1));
          bool = true;
        }
        else if (this.rzk.rAO.equals("opVoteAdData"))
        {
          ls(g.dh(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("selectContact"))
        {
          ls(g.di(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("makePhoneCall"))
        {
          ls(g.dj(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("setWCPayPassword"))
        {
          ls(g.dk(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("chooseInvoiceTitle"))
        {
          ls(g.dl(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("showSearchActionSheet"))
        {
          ls(g.dm(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("cancelSearchActionSheet"))
        {
          ls(g.dn(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("uxSearchOpLog"))
        {
          ls(g.jdMethod_do(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("openSearchWAWidgetLogView"))
        {
          ls(g.dp(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("openBizChat"))
        {
          ls(g.dq(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("tapSearchWAWidgetView"))
        {
          ls(g.dr(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("getMatchContactList"))
        {
          ls(g.ds(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("openSearchWebView"))
        {
          ls(g.dt(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equalsIgnoreCase("openWXSearchPage"))
        {
          ls(g.du(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("viewTypeChange"))
        {
          ls(g.dv(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("openGameUrlWithExtraWebView"))
        {
          ls(g.dw(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("requestWxVoicePrintVerifyInternal"))
        {
          ls(g.dx(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("closeWindowAndGoNext"))
        {
          ls(g.dy(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("invokeMiniProgramAPI"))
        {
          ls(g.dz(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("setGameData"))
        {
          ls(g.dA(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("getGameData"))
        {
          ls(g.dB(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("clearGameData"))
        {
          ls(g.dC(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("handleWCPayWalletBuffer"))
        {
          ls(g.dD(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("reportGamePageTime"))
        {
          ls(g.dE(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("insertVideoPlayer"))
        {
          ls(g.dF(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("updateVideoPlayer"))
        {
          ls(g.dG(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("removeVideoPlayer"))
        {
          ls(g.dH(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("operateVideoPlayer"))
        {
          ls(g.dI(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("getSearchHistory"))
        {
          ls(g.g(this.rzi));
          bool = true;
        }
        else if (this.rzk.rAO.equals("deleteSearchHistory"))
        {
          ls(g.dJ(this.rzi, this.rzk));
          bool = true;
        }
        else if ((this.rzk.rAO.equals("doGoToRecVideoList")) || (this.rzk.rAO.equals("jumpWSRecVideoList")))
        {
          ls(g.dK(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("recordHistory"))
        {
          ls(g.dL(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("openOfflinePayView"))
        {
          ls(g.dM(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("openWCPayCardList"))
        {
          ls(g.dN(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("bindEmail"))
        {
          ls(g.h(this.rzi));
          bool = true;
        }
        else if (this.rzk.rAO.equals("getSystemInfo"))
        {
          ls(g.dO(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("serviceClick"))
        {
          ls(g.dP(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("openRealnameAuth"))
        {
          ls(g.dQ(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("sendSingleAppMessage"))
        {
          ls(g.dR(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("openWebSearchOutLinkItem"))
        {
          ls(g.dS(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("wcPrivacyPolicyResult"))
        {
          ls(g.dT(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("currentMpInfo"))
        {
          ls(g.dU(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("faceVerifyForPay"))
        {
          ls(g.dV(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("jumpDownloaderApp"))
        {
          ls(g.dW(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("getCCData"))
        {
          ls(g.dX(this.rzi, this.rzk));
          bool = true;
        }
        else if (this.rzk.rAO.equals("calRqt"))
        {
          ls(g.dY(this.rzi, this.rzk));
          bool = true;
        }
        else
        {
          if (!d.Ua(this.rzk.rAO)) {
            break;
          }
          ls(g.dZ(this.rzi, this.rzk));
          bool = true;
        }
      }
      y.e("MicroMsg.MsgHandler", "unknown function = " + this.rzk.rAO);
      g.a(this.rzi, this.rzk, "system:function_not_exist", null);
    }
    for (;;)
    {
      ls(true);
      break;
      if (paramLinkedList == c.a.a.rxw)
      {
        y.e("MicroMsg.MsgHandler", "handleMsg access denied %s", new Object[] { this.rzN.getName() });
        if (this.rzk.rAO.equalsIgnoreCase("getBrandWCPayRequest")) {
          h.nFQ.a(157L, 1L, 1L, false);
        }
        g.a(this.rzi, this.rzk, "system:access_denied", null);
      }
      else if (paramLinkedList == c.a.a.rxv)
      {
        g.a(this.rzi, this.rzk, this.rzN.coO() + ":" + paramString, null);
      }
      else
      {
        if (bk.bl(this.rzN.coO()))
        {
          this.rzi.dCs = false;
          ls(false);
          g.d(this.rzi, this.rzk, false);
          return;
        }
        if (bk.bl(paramString)) {
          g.a(this.rzi, this.rzk, this.rzN.coO() + ":fail", null);
        } else {
          g.a(this.rzi, this.rzk, this.rzN.coO() + ":fail_" + paramString, null);
        }
      }
    }
  }
  
  public final boolean cfV()
  {
    return this.rxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.38
 * JD-Core Version:    0.7.0.1
 */