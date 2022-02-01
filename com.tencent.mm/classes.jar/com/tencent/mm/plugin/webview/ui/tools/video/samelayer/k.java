package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;", "", "()V", "videoProfileData", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport$VideoProfileData;", "onMediaPlayerCreated", "", "costTime", "", "onMediaPlayerVideoBufferEnd", "onMediaPlayerVideoBufferStart", "onMediaPlayerVideoEnd", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "mediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "onMediaPlayerVideoError", "what", "", "extra", "msg", "", "onMediaPlayerVideoPrepareEnd", "duration", "onMediaPlayerVideoPrepareStart", "onMediaPlayerVideoStop", "onVideoPathChanged", "cachedSize", "videoPath", "reportVideoProfile", "callFrom", "Companion", "VideoProfileData", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k.a XoQ;
  final b XoR;
  
  static
  {
    AppMethodBeat.i(297098);
    XoQ = new k.a((byte)0);
    AppMethodBeat.o(297098);
  }
  
  public k()
  {
    AppMethodBeat.i(297095);
    this.XoR = new b();
    AppMethodBeat.o(297095);
  }
  
  public final void a(a parama, g paramg)
  {
    AppMethodBeat.i(297110);
    s.u(paramg, "mediaPlayer");
    if ((!Util.isNullOrNil(this.XoR.videoPath)) && (this.XoR.sSH > 0L))
    {
      this.XoR.sSO = Util.nowMilliSecond();
      a(parama, paramg, "onMediaPlayerVideoStop");
    }
    AppMethodBeat.o(297110);
  }
  
  final void a(a parama, g paramg, String paramString)
  {
    AppMethodBeat.i(297117);
    if (this.XoR.sSI < this.XoR.sSH)
    {
      Log.i("MicroMsg.WebViewVideoProfileReport", "reportVideoProfile, wired case, ignore reporting and reset data");
      this.XoR.reset();
      AppMethodBeat.o(297117);
      return;
    }
    Object localObject;
    label65:
    label77:
    label84:
    String str;
    int i;
    label117:
    int j;
    label133:
    int k;
    if ((parama instanceof f))
    {
      localObject = (f)parama;
      if (localObject != null) {
        break label620;
      }
      localObject = "";
      if (!(parama instanceof f)) {
        break label642;
      }
      parama = (f)parama;
      if (parama != null) {
        break label647;
      }
      parama = "";
      parama = aa.aUC(parama);
      str = aa.aUC(this.XoR.videoPath);
      if (!com.tencent.mm.plugin.appbrand.jsapi.video.k.e(paramg)) {
        break label667;
      }
      i = ((j)paramg).cwK();
      if (!com.tencent.mm.plugin.appbrand.jsapi.video.k.e(paramg)) {
        break label673;
      }
      j = ((j)paramg).cwL();
      if (!com.tencent.mm.plugin.appbrand.jsapi.video.k.e(paramg)) {
        break label679;
      }
      k = ((j)paramg).cwM();
      label149:
      if ((!i.cvD().sAx) || (!i.cvD().sAy)) {
        break label685;
      }
    }
    label642:
    label647:
    label667:
    label673:
    label679:
    label685:
    for (int m = 1;; m = 0)
    {
      Log.i("MicroMsg.WebViewVideoProfileReport", "reportVideoProfile:%s, webComptName:%s, proxy:%s, playerCreateTime:%s, videoPath:%s, cachedSize:%s, duration:%s, prepareTime:%s, bufferCount:%s, bufferTime:%s, error(%s, %s, %s), minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", new Object[] { paramString, localObject, Boolean.valueOf(i.cvD().sAx), Long.valueOf(this.XoR.sSF), this.XoR.videoPath, Long.valueOf(this.XoR.sSG), Long.valueOf(this.XoR.duration), Long.valueOf(this.XoR.sSJ), Integer.valueOf(this.XoR.sSK), Long.valueOf(this.XoR.sSL), Integer.valueOf(this.XoR.sSQ), Integer.valueOf(this.XoR.sSR), this.XoR.errorMsg, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      h.OAn.b(19953, new Object[] { localObject, parama, str, Long.valueOf(this.XoR.sSH), Long.valueOf(this.XoR.sSI), Long.valueOf(this.XoR.sSJ), Long.valueOf(this.XoR.sSF), Long.valueOf(this.XoR.duration), Long.valueOf(this.XoR.sSG), Integer.valueOf(this.XoR.sSQ), Integer.valueOf(this.XoR.sSR), this.XoR.errorMsg, Integer.valueOf(m), Integer.valueOf(this.XoR.sSK), Long.valueOf(this.XoR.sSL), Long.valueOf(this.XoR.sSO), Long.valueOf(this.XoR.sSP), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      this.XoR.reset();
      AppMethodBeat.o(297117);
      return;
      localObject = null;
      break;
      label620:
      localObject = ((f)localObject).iBP();
      if (localObject == null)
      {
        localObject = "";
        break label65;
      }
      break label65;
      parama = null;
      break label77;
      str = parama.getCurrentUrl();
      parama = str;
      if (str != null) {
        break label84;
      }
      parama = "";
      break label84;
      i = 0;
      break label117;
      j = 0;
      break label133;
      k = 0;
      break label149;
    }
  }
  
  public final void bmQ(String paramString)
  {
    AppMethodBeat.i(297105);
    if (paramString == null)
    {
      AppMethodBeat.o(297105);
      return;
    }
    h.OAn.idkeyStat(1379L, 14L, 1L, false);
    if (0L > 0L)
    {
      h.OAn.idkeyStat(1379L, 15L, 1L, false);
      h.OAn.idkeyStat(1379L, 16L, 0L, false);
      Log.d("MicroMsg.WebViewVideoProfileReport", "onVideoPathChanged, cachedSize:%s, cachedSizeInKB:%s", new Object[] { Long.valueOf(0L), Long.valueOf(0L) });
    }
    this.XoR.setVideoPath(paramString);
    this.XoR.sSG = 0L;
    AppMethodBeat.o(297105);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport$VideoProfileData;", "", "(Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;)V", "bufferEndTime", "", "getBufferEndTime", "()J", "setBufferEndTime", "(J)V", "bufferStartTime", "getBufferStartTime", "setBufferStartTime", "buffetAllTime", "getBuffetAllTime", "setBuffetAllTime", "buffetCount", "", "getBuffetCount", "()I", "setBuffetCount", "(I)V", "cachedSize", "getCachedSize", "setCachedSize", "duration", "getDuration", "setDuration", "endTimeStamp", "getEndTimeStamp", "setEndTimeStamp", "errorExtra", "getErrorExtra", "setErrorExtra", "errorMsg", "", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "errorWhat", "getErrorWhat", "setErrorWhat", "playerCreateTime", "getPlayerCreateTime", "setPlayerCreateTime", "prepareEndTime", "getPrepareEndTime", "setPrepareEndTime", "prepareStartTime", "getPrepareStartTime", "setPrepareStartTime", "prepareTime", "getPrepareTime", "setPrepareTime", "stopTimeStamp", "getStopTimeStamp", "setStopTimeStamp", "value", "videoPath", "getVideoPath", "setVideoPath", "reset", "", "resetBufferTime", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
  {
    long duration;
    String errorMsg;
    long sSF;
    long sSG;
    long sSH;
    long sSI;
    long sSJ;
    int sSK;
    long sSL;
    long sSM;
    long sSN;
    long sSO;
    long sSP;
    int sSQ;
    int sSR;
    String videoPath;
    
    public b()
    {
      AppMethodBeat.i(297097);
      this.errorMsg = "";
      this.videoPath = "";
      AppMethodBeat.o(297097);
    }
    
    public final void reset()
    {
      AppMethodBeat.i(297107);
      setVideoPath("");
      this.sSF = 0L;
      this.duration = 0L;
      this.sSG = 0L;
      this.sSH = 0L;
      this.sSI = 0L;
      this.sSJ = 0L;
      this.sSK = 0;
      this.sSM = 0L;
      this.sSN = 0L;
      this.sSL = 0L;
      this.sSO = 0L;
      this.sSP = 0L;
      this.sSQ = 0;
      this.sSR = 0;
      this.errorMsg = "";
      AppMethodBeat.o(297107);
    }
    
    public final void setVideoPath(String paramString)
    {
      AppMethodBeat.i(297103);
      s.u(paramString, "value");
      String str;
      if (!Util.isNullOrNil(paramString))
      {
        str = paramString;
        if (paramString.length() > 512)
        {
          str = paramString.substring(0, 512);
          s.s(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
      }
      for (;;)
      {
        this.videoPath = str;
        AppMethodBeat.o(297103);
        return;
        str = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.k
 * JD-Core Version:    0.7.0.1
 */