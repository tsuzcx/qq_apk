package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.d.a;
import com.tencent.mm.plugin.webview.preload.e;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.Map;

final class g$1
  extends c.c
{
  g$1(g paramg, i parami, JsapiPermissionWrapper paramJsapiPermissionWrapper, c.g paramg1) {}
  
  public final void a(c.a.a parama, String paramString, LinkedList<cpx> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9037);
    this.uZa.dgQ().put("baseErrorCode", Integer.valueOf(paramInt1));
    this.uZa.dgQ().put("jsapiErrorCode", Integer.valueOf(paramInt2));
    paramLinkedList = parama;
    if (this.vqm.ajg(this.uZa.vrQ))
    {
      ab.i("MicroMsg.MsgHandler", "current jsapi(%s) invoked is came from menu event.(original retCode : %s)", new Object[] { this.uZa.vrQ, parama });
      paramLinkedList = c.a.a.vom;
    }
    ab.i("MicroMsg.MsgHandler", "onJSVerifyEnd, put webviewID = %d", new Object[] { Integer.valueOf(g.a(this.vqm)) });
    this.uZa.pJb.put("webview_instance_id", Integer.valueOf(g.a(this.vqm)));
    boolean bool;
    if (paramLinkedList == c.a.a.vom)
    {
      if (a.a(this.uZa, this.vqm))
      {
        oB(true);
        AppMethodBeat.o(9037);
        return;
      }
      if (this.uZa.vrQ.equals("sendAppMessage"))
      {
        oB(g.a(this.vqm, this.uZa, this.vqk));
        bool = true;
      }
      for (;;)
      {
        parama = this.uZa.dgQ().get("Internal@AsyncReport");
        if ((parama == null) || (!(parama instanceof Boolean)) || (!((Boolean)parama).booleanValue())) {
          g.d(this.vqm, this.uZa, bool);
        }
        if (!bool) {
          g.b(this.vqm, this.uZa, paramLinkedList.getCode());
        }
        AppMethodBeat.o(9037);
        return;
        if (this.uZa.vrQ.equals("profile"))
        {
          oB(g.a(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("shareWeibo"))
        {
          oB(g.b(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("shareTimeline"))
        {
          oB(g.b(this.vqm, this.uZa, this.vqk));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("updateTimelineShareData"))
        {
          oB(g.c(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("updateAppMessageShareData"))
        {
          oB(g.d(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("adDataReport"))
        {
          oB(g.e(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("streamingVideoPlay"))
        {
          oB(g.f(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("addContact"))
        {
          oB(g.c(this.vqm, this.uZa, this.vqk));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("getWidgetCaptureImgUrl"))
        {
          oB(g.g(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("imagePreview"))
        {
          oB(g.h(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("log"))
        {
          oB(g.i(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("hideOptionMenu"))
        {
          oB(g.b(this.vqm));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("showOptionMenu"))
        {
          oB(g.c(this.vqm));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("getNetworkType"))
        {
          oB(g.j(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("closeWindow"))
        {
          oB(g.k(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("getInstallState"))
        {
          oB(g.l(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("scanQRCode"))
        {
          oB(g.m(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("setFontSizeCallback"))
        {
          oB(g.n(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("jumpToInstallUrl"))
        {
          oB(g.o(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getBrandWCPayRequest"))
        {
          oB(g.p(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("secureTunnel"))
        {
          oB(g.q(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("editAddress"))
        {
          oB(g.r(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getLatestAddress"))
        {
          oB(g.d(this.vqm));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getHeadingAndPitch"))
        {
          oB(g.s(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("sendEmail"))
        {
          oB(g.t(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("addDownloadTask"))
        {
          oB(g.u(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("cancelDownloadTask"))
        {
          oB(g.v(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("pauseDownloadTask"))
        {
          oB(g.w(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("resumeDownloadTask"))
        {
          oB(g.d(this.vqm, this.uZa, this.vqk));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("queryDownloadTask"))
        {
          oB(g.x(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("installDownloadTask"))
        {
          oB(g.y(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openSpecificView"))
        {
          oB(g.z(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("launch3rdApp"))
        {
          oB(g.A(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("jumpWCMall"))
        {
          oB(g.B(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("writeCommData"))
        {
          oB(g.C(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openUrlByExtBrowser"))
        {
          oB(g.D(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openProductView"))
        {
          oB(g.E(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openProductViewWithPid"))
        {
          oB(g.F(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getBrandWCPayBindCardRequest"))
        {
          oB(g.G(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("geoLocation"))
        {
          oB(g.H(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("jumpToBizProfile"))
        {
          oB(g.I(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openTimelineCheckInList"))
        {
          oB(g.J(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openLocation"))
        {
          oB(g.K(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("timelineCheckIn"))
        {
          oB(g.L(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getBrandWCPayCreateCreditCardRequest"))
        {
          oB(g.M(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("sendServiceAppMessage"))
        {
          oB(g.N(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("mmsf0001"))
        {
          oB(g.O(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("musicPlay"))
        {
          oB(g.P(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("connectToWiFi"))
        {
          oB(g.Q(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getTransferMoneyRequest"))
        {
          oB(g.R(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openWCPaySpecificView"))
        {
          oB(g.S(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("chooseCard"))
        {
          oB(g.T(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("chooseInvoice"))
        {
          oB(g.U(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("batchAddCard"))
        {
          oB(g.V(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("setCloseWindowConfirmDialogInfo"))
        {
          oB(g.W(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("preVerifyJSAPI"))
        {
          oB(g.X(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("startRecord"))
        {
          oB(g.Y(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("stopRecord"))
        {
          oB(g.Z(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("playVoice"))
        {
          oB(g.aa(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("pauseVoice"))
        {
          oB(g.ab(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("stopVoice"))
        {
          oB(g.ac(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("uploadVoice"))
        {
          oB(g.ad(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("downloadVoice"))
        {
          oB(g.ae(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("chooseImage"))
        {
          oB(g.af(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("uploadImage"))
        {
          oB(g.ag(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("downloadImage"))
        {
          oB(g.ah(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("hideMenuItems"))
        {
          oB(g.ai(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("showMenuItems"))
        {
          oB(g.aj(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("hideAllNonBaseMenuItem"))
        {
          oB(g.ak(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("showAllNonBaseMenuItem"))
        {
          oB(g.al(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("checkJsApi"))
        {
          oB(g.am(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("translateVoice"))
        {
          oB(g.an(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("shareQQ"))
        {
          oB(g.ao(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("shareWeiboApp"))
        {
          oB(g.ap(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("configWXDeviceWiFi"))
        {
          oB(g.aq(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getCurrentSSID"))
        {
          oB(g.ar(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getPaymentOrderRequest"))
        {
          oB(g.as(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("verifyWCPayPassword"))
        {
          oB(g.at(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("startMonitoringBeacons"))
        {
          g.e(this.vqm);
          oB(g.a(this.vqm, this.uZa, new int[0]));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("stopMonitoringBeacons"))
        {
          g.e(this.vqm);
          oB(g.b(this.vqm, this.uZa, new int[0]));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getSendC2CMessageRequest"))
        {
          oB(g.au(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("batchViewCard"))
        {
          oB(g.av(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("connectToFreeWifi"))
        {
          oB(g.aw(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("setFreeWifiOwner"))
        {
          oB(g.ax(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("setPageOwner"))
        {
          oB(g.ay(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getWechatVerifyTicket"))
        {
          oB(g.az(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openWXDeviceLib"))
        {
          oB(g.aA(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("closeWXDeviceLib"))
        {
          oB(g.aB(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("startScanWXDevice"))
        {
          oB(g.aC(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("stopScanWXDevice"))
        {
          oB(g.aD(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("connectWXDevice"))
        {
          oB(g.aE(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("disconnectWXDevice"))
        {
          oB(g.aF(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getWXDeviceTicket"))
        {
          oB(g.aG(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getWXDeviceInfos"))
        {
          oB(g.aH(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("sendDataToWXDevice"))
        {
          oB(g.aI(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("setSendDataDirection"))
        {
          oB(g.aJ(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openGameDetail"))
        {
          oB(g.aK(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openGameCenter"))
        {
          oB(g.aL(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("setGameDebugConfig"))
        {
          oB(g.aM(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("shareQZone"))
        {
          oB(g.ao(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("startTempSession"))
        {
          oB(g.aN(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getRecevieBizHongBaoRequest"))
        {
          oB(g.aO(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openMyDeviceProfile"))
        {
          oB(g.aP(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("selectPedometerSource"))
        {
          oB(this.vqm.av(this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getH5PrepayRequest"))
        {
          oB(g.aQ(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getH5TransactionRequest"))
        {
          oB(g.aR(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("jumpToWXWallet"))
        {
          oB(g.aS(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("scanCover"))
        {
          oB(g.aT(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("nfcIsConnect"))
        {
          oB(g.aU(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("nfcConnect"))
        {
          oB(g.aV(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("nfcTransceive"))
        {
          oB(g.aW(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("nfcBatchTransceive"))
        {
          oB(g.aX(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("nfcGetId"))
        {
          oB(g.aY(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("nfcGetInfo"))
        {
          oB(g.aZ(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("nfcCheckState"))
        {
          oB(g.ba(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("videoProxyInit"))
        {
          oB(g.bb(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("videoProxyStartPlay"))
        {
          oB(g.bc(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("videoProxyStopPlay"))
        {
          oB(g.bd(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("videoProxySetPlayerState"))
        {
          oB(g.be(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("videoProxySetRemainTime"))
        {
          oB(g.bf(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getSearchData"))
        {
          oB(g.bg(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getPoiInfo"))
        {
          oB(g.bh(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("updateReddotTimeStamps"))
        {
          oB(g.bi(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("reloadSearchWAWidgetData"))
        {
          oB(g.bj(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("gotoEmoticonPad"))
        {
          oB(g.f(this.vqm));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("querySimilarEmotion"))
        {
          oB(g.bk(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("insertSearchWAWidgetView"))
        {
          oB(g.bl(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("removeSearchWAWidgetView"))
        {
          oB(g.bm(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("updateSearchWAWidgetView"))
        {
          oB(g.bn(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getTeachSearchData"))
        {
          oB(g.bo(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getSearchGuideData"))
        {
          oB(g.bp(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getSearchAvatarList"))
        {
          oB(g.bq(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getSearchSnsImageList"))
        {
          oB(g.br(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getSearchImageList"))
        {
          oB(g.bs(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getSearchDisplayNameList"))
        {
          oB(g.bt(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("startSearchItemDetailPage"))
        {
          oB(g.bu(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("reportSearchStatistics"))
        {
          oB(g.bv(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("reportSearchRealTimeStatistics"))
        {
          oB(g.bw(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("searchDataHasResult"))
        {
          oB(g.bx(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getSearchSuggestionData"))
        {
          oB(g.by(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openEmotionPage"))
        {
          oB(g.bz(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("setSearchInputWord"))
        {
          oB(g.bA(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openWeAppPage"))
        {
          oB(g.bB(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("reportWeAppSearchRealtime"))
        {
          oB(g.bC(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("doSearchOperation"))
        {
          oB(g.bD(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("operateGameCenterMsg"))
        {
          oB(g.bE(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getWebPayCheckoutCounterRequst"))
        {
          oB(g.bF(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("setSnsObjectXmlDescList"))
        {
          oB(g.bG(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("clickSnsMusicPlayButton"))
        {
          oB(g.bH(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("addCustomMenuItems"))
        {
          oB(g.bI(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openEnterpriseChat"))
        {
          oB(g.bJ(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openEnterpriseContact"))
        {
          oB(g.bK(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("selectEnterpriseContact"))
        {
          oB(g.bL(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("sendEnterpriseChat"))
        {
          oB(g.bM(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("enterEnterpriseChat"))
        {
          oB(g.bN(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getEnterpriseChat"))
        {
          oB(g.bO(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("reportActionInfo"))
        {
          oB(g.bP(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("showSearchOfBizHistory"))
        {
          oB(g.bQ(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("changePayActivityView"))
        {
          oB(g.bR(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("scanLicence"))
        {
          oB(g.bS(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openWeApp"))
        {
          oB(g.bT(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openECard"))
        {
          oB(g.bU(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("sendDataToMiniProgram"))
        {
          oB(g.bV(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("preloadMiniProgramEnv"))
        {
          oB(g.bW(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("preloadMiniProgramContacts"))
        {
          oB(g.bX(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("enablePullDownRefresh"))
        {
          oB(this.vqm.bH(this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("startPullDownRefresh"))
        {
          oB(this.vqm.bI(this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("stopPullDownRefresh"))
        {
          oB(this.vqm.bJ(this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("disablePullDownRefresh"))
        {
          oB(this.vqm.dgK());
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("disableBounceScroll"))
        {
          oB(this.vqm.bM(this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("clearBounceBackground"))
        {
          oB(this.vqm.bN(this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("showKeyboard"))
        {
          oB(this.vqm.bK(this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("showSmileyPanel"))
        {
          oB(this.vqm.bL(this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openMapNavigateMenu"))
        {
          oB(this.vqm.bQ(this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("setNavigationBarButtons"))
        {
          oB(g.bY(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("enableFullScreen"))
        {
          oB(g.bZ(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("reportMiniProgramPageData"))
        {
          oB(g.ca(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("setPageTitle"))
        {
          oB(g.cb(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("setStatusBarStyle"))
        {
          oB(g.cc(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("forceUpdateWxaAttr"))
        {
          oB(g.cd(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("launchMiniProgram"))
        {
          oB(g.ce(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openBusinessView"))
        {
          oB(g.cf(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("reportIDKey"))
        {
          oB(g.cg(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("quicklyAddBrandContact"))
        {
          oB(g.ch(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("consumedShareCard"))
        {
          oB(g.ci(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("kvReport"))
        {
          oB(this.vqm.bz(this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("realtimeReport"))
        {
          oB(this.vqm.bP(this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openUrlWithExtraWebview"))
        {
          oB(g.cj(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("videoProxyPreload"))
        {
          oB(g.ck(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getLocalData"))
        {
          oB(g.cl(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("setLocalData"))
        {
          oB(g.cm(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("clearLocalData"))
        {
          oB(g.cn(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("selectSingleContact"))
        {
          oB(g.co(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("sendAppMessageToSpecifiedContact"))
        {
          oB(g.cp(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("deleteAccountSuccess"))
        {
          oB(g.g(this.vqm));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("chooseVideo"))
        {
          oB(g.cq(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("uploadVideo"))
        {
          oB(g.cr(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("setNavigationBarColor"))
        {
          oB(g.cs(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openDesignerEmojiView"))
        {
          oB(g.a(this.vqm, this.uZa, false));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openDesignerProfile"))
        {
          oB(g.b(this.vqm, this.uZa, false));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openEmoticonTopicList"))
        {
          oB(g.ct(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openDesignerEmojiViewLocal"))
        {
          oB(g.a(this.vqm, this.uZa, true));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openDesignerProfileLocal"))
        {
          oB(g.b(this.vqm, this.uZa, true));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openEmotionDetailViewLocal"))
        {
          oB(g.cu(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openNewPage"))
        {
          oB(g.cv(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getSearchEmotionData"))
        {
          oB(g.cw(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openEmotionUrl"))
        {
          oB(g.cx(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("getWCPayRealnameVerify"))
        {
          oB(this.vqm.aU(this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("selectWalletCurrency"))
        {
          oB(this.vqm.dgH());
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("operateMusicPlayer"))
        {
          oB(g.cy(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getMusicPlayerState"))
        {
          oB(g.cz(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("clearWebviewCache"))
        {
          oB(g.cA(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("requireSoterBiometricAuthentication"))
        {
          oB(g.cB(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("getSupportSoter"))
        {
          oB(g.cC(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("unbindBankCard"))
        {
          oB(g.cD(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("setBounceBackground"))
        {
          oB(this.vqm.bO(this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("doExposePreparation"))
        {
          oB(g.cE(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("getMsgProofItems"))
        {
          oB(g.cF(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("uploadMediaFile"))
        {
          oB(g.cG(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("openSecurityView"))
        {
          oB(g.cH(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("startVoipCall"))
        {
          oB(g.cI(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("getOpenDeviceId"))
        {
          oB(g.cJ(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("getRouteUrl"))
        {
          oB(g.cK(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("idCardRealnameVerify"))
        {
          oB(this.vqm.aW(this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("uploadIdCardSuccess"))
        {
          oB(this.vqm.aX(this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("getGameCommInfo"))
        {
          oB(this.vqm.aY(this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("openGameRegion"))
        {
          oB(this.vqm.dgI());
          bool = true;
        }
        else if (this.uZa.vrQ.equals("chooseIdCard"))
        {
          oB(this.vqm.aZ(this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("showDatePickerView"))
        {
          oB(g.cL(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("openLuckyMoneyDetailView"))
        {
          oB(g.cM(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("resendRemittanceMsg"))
        {
          oB(g.cN(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("getLocalImgData"))
        {
          oB(g.cO(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("recordVideo"))
        {
          oB(g.cP(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("previewVideo"))
        {
          oB(g.cQ(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("uploadEncryptMediaFile"))
        {
          oB(g.cR(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("openCustomWebview"))
        {
          oB(g.cS(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("chooseMedia"))
        {
          oB(g.cT(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("openLuckyMoneyHistory"))
        {
          oB(g.cU(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("requestWxFacePictureVerify"))
        {
          oB(g.c(this.vqm, this.uZa, false));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("getWePkgAuthResult"))
        {
          oB(g.cV(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("getLocalWePkgInfo"))
        {
          oB(g.cW(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("openGameWebView"))
        {
          oB(g.cX(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("launchApplication"))
        {
          oB(g.cY(this.vqm, this.uZa));
          bool = true;
        }
        else if ((this.uZa.vrQ.equals("login")) || (this.uZa.vrQ.equals("authorize")))
        {
          oB(g.cZ(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("requestWxFacePictureVerifyUnionVideo"))
        {
          oB(g.c(this.vqm, this.uZa, true));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("checkIsSupportFaceDetect"))
        {
          oB(g.da(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("operateBackgroundAudio"))
        {
          oB(g.db(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("setBackgroundAudioState"))
        {
          oB(g.e(this.vqm, this.uZa, this.vqk));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("getBackgroundAudioState"))
        {
          oB(g.dc(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("addDownloadTaskStraight"))
        {
          oB(g.f(this.vqm, this.uZa, this.vqk));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("setScreenOrientation"))
        {
          oB(g.dd(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("addToEmoticon"))
        {
          oB(g.de(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("shareEmoticon"))
        {
          oB(g.df(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("requestWxFaceRegisterInternal"))
        {
          oB(g.dg(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("requestWxFaceVerifyInternal"))
        {
          oB(g.dh(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("openADCanvas"))
        {
          oB(g.a(this.vqm, this.uZa, 0));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("openSearchCanvas"))
        {
          oB(g.a(this.vqm, this.uZa, 1));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("opVoteAdData"))
        {
          oB(g.di(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("selectContact"))
        {
          oB(g.dj(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("makePhoneCall"))
        {
          oB(g.dk(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("setWCPayPassword"))
        {
          oB(g.dl(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("chooseInvoiceTitle"))
        {
          oB(g.dm(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("showSearchActionSheet"))
        {
          oB(g.dn(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("cancelSearchActionSheet"))
        {
          oB(g.jdMethod_do(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("showSearchToast"))
        {
          oB(g.dp(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("showSearchLoading"))
        {
          oB(g.dq(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("hideSearchLoading"))
        {
          oB(g.dr(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("updateWASearchTemplate"))
        {
          oB(g.ds(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("preloadSearchWeapp"))
        {
          oB(g.dt(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("uxSearchOpLog"))
        {
          oB(g.du(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("openSearchWAWidgetLogView"))
        {
          oB(g.dv(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("openBizChat"))
        {
          oB(g.dw(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("tapSearchWAWidgetView"))
        {
          oB(g.dx(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("getMatchContactList"))
        {
          oB(g.dy(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("openSearchWebView"))
        {
          oB(g.dz(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equalsIgnoreCase("openWXSearchPage"))
        {
          oB(g.dA(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("viewTypeChange"))
        {
          oB(g.dB(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("openGameUrlWithExtraWebView"))
        {
          oB(g.dC(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("requestWxVoicePrintVerifyInternal"))
        {
          oB(g.dD(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("closeWindowAndGoNext"))
        {
          oB(g.dE(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("invokeMiniProgramAPI"))
        {
          oB(g.dF(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("setGameData"))
        {
          oB(g.dG(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("getGameData"))
        {
          oB(g.dH(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("clearGameData"))
        {
          oB(g.dI(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("handleWCPayWalletBuffer"))
        {
          oB(g.dJ(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("reportGamePageTime"))
        {
          oB(g.dK(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("insertVideoPlayer"))
        {
          oB(g.dL(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("updateVideoPlayer"))
        {
          oB(g.dM(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("removeVideoPlayer"))
        {
          oB(g.dN(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("operateVideoPlayer"))
        {
          oB(g.dO(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("getSearchHistory"))
        {
          oB(g.h(this.vqm));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("deleteSearchHistory"))
        {
          oB(g.dP(this.vqm, this.uZa));
          bool = true;
        }
        else if ((this.uZa.vrQ.equals("doGoToRecVideoList")) || (this.uZa.vrQ.equals("jumpWSRecVideoList")))
        {
          oB(g.dQ(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("recordHistory"))
        {
          oB(g.dR(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("openOfflinePayView"))
        {
          oB(g.dS(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("openWCPayCardList"))
        {
          oB(g.dT(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("bindEmail"))
        {
          oB(g.i(this.vqm));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("getSystemInfo"))
        {
          oB(g.dU(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("serviceClick"))
        {
          oB(g.dV(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("openRealnameAuth"))
        {
          oB(g.dW(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("sendSingleAppMessage"))
        {
          oB(g.dX(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("openWebSearchOutLinkItem"))
        {
          oB(g.dY(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("wcPrivacyPolicyResult"))
        {
          oB(g.dZ(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("currentMpInfo"))
        {
          oB(g.ea(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("faceVerifyForPay"))
        {
          oB(g.eb(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("jumpDownloaderWidget"))
        {
          oB(g.ec(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("batchUpdateWepkg"))
        {
          oB(g.ed(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("privateOpenWeappFunctionalPage"))
        {
          oB(g.ee(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("privateCommonApi"))
        {
          oB(g.ef(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("internelWxFaceVerify"))
        {
          oB(g.eg(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("openWebViewUseFastLoad"))
        {
          oB(g.eh(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("handleHaokanAction"))
        {
          oB(g.ei(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("handleMPPageAction"))
        {
          oB(g.ej(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("confirmDialog"))
        {
          oB(g.ek(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("getCCData"))
        {
          oB(g.el(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("calRqt"))
        {
          oB(g.em(this.vqm, this.uZa));
          bool = true;
        }
        else if (e.ahJ(this.uZa.vrQ))
        {
          oB(g.en(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("addGameDownloadTask"))
        {
          oB(g.eo(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("reportGameWeb"))
        {
          oB(g.ep(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("getDownloadWidgetTaskInfos"))
        {
          oB(g.eq(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("chooseHaowanMedia"))
        {
          oB(g.er(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("queryHaowanPublish"))
        {
          oB(g.es(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("publishHaowanEdition"))
        {
          oB(g.et(this.vqm, this.uZa));
          bool = true;
        }
        else if (this.uZa.vrQ.equals("cancelHaowanPublish"))
        {
          oB(g.eu(this.vqm, this.uZa));
          bool = true;
        }
        else
        {
          if (!this.uZa.vrQ.equals("launchGameVideoEditor")) {
            break;
          }
          oB(g.ev(this.vqm, this.uZa));
          bool = true;
        }
      }
      ab.e("MicroMsg.MsgHandler", "unknown function = " + this.uZa.vrQ);
      this.vqm.a(this.uZa, "system:function_not_exist", null);
    }
    for (;;)
    {
      oB(true);
      bool = false;
      break;
      if (paramLinkedList == c.a.a.vop)
      {
        ab.e("MicroMsg.MsgHandler", "handleMsg access denied %s", new Object[] { this.vql.getName() });
        if (this.uZa.vrQ.equalsIgnoreCase("getBrandWCPayRequest")) {
          h.qsU.idkeyStat(157L, 1L, 1L, false);
        }
        this.vqm.a(this.uZa, "system:access_denied", null);
      }
      else if (paramLinkedList == c.a.a.voo)
      {
        this.vqm.a(this.uZa, this.vql.dql() + ":" + paramString, null);
      }
      else
      {
        if (bo.isNullOrNil(this.vql.dql()))
        {
          this.vqm.ezJ = false;
          oB(false);
          g.d(this.vqm, this.uZa, false);
          AppMethodBeat.o(9037);
          return;
        }
        if (bo.isNullOrNil(paramString)) {
          this.vqm.a(this.uZa, this.vql.dql() + ":fail", null);
        } else {
          this.vqm.a(this.uZa, this.vql.dql() + ":fail_" + paramString, null);
        }
      }
    }
  }
  
  public final boolean dgh()
  {
    return this.vor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.1
 * JD-Core Version:    0.7.0.1
 */