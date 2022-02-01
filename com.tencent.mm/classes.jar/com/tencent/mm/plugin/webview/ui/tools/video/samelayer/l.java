package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;", "", "()V", "videoProfileData", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport$VideoProfileData;", "onMediaPlayerCreated", "", "costTime", "", "onMediaPlayerVideoBufferEnd", "onMediaPlayerVideoBufferStart", "onMediaPlayerVideoEnd", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "mediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "onMediaPlayerVideoError", "what", "", "extra", "msg", "", "onMediaPlayerVideoPrepareEnd", "duration", "onMediaPlayerVideoPrepareStart", "onMediaPlayerVideoStop", "onVideoPathChanged", "cachedSize", "videoPath", "reportVideoProfile", "callFrom", "Companion", "VideoProfileData", "plugin-webview_release"})
public final class l
{
  public static final l.a Qwx;
  final b Qww;
  
  static
  {
    AppMethodBeat.i(258425);
    Qwx = new l.a((byte)0);
    AppMethodBeat.o(258425);
  }
  
  public l()
  {
    AppMethodBeat.i(258424);
    this.Qww = new b();
    AppMethodBeat.o(258424);
  }
  
  public final void a(a parama, e parame)
  {
    AppMethodBeat.i(258419);
    p.k(parame, "mediaPlayer");
    if ((!Util.isNullOrNil(this.Qww.videoPath)) && (this.Qww.pOj > 0L))
    {
      this.Qww.pOq = Util.nowMilliSecond();
      a(parama, parame, "onMediaPlayerVideoStop");
    }
    AppMethodBeat.o(258419);
  }
  
  final void a(a parama, e parame, String paramString)
  {
    AppMethodBeat.i(258422);
    if (this.Qww.pOk < this.Qww.pOj)
    {
      Log.i("MicroMsg.WebViewVideoProfileReport", "reportVideoProfile, wired case, ignore reporting and reset data");
      this.Qww.reset();
      AppMethodBeat.o(258422);
      return;
    }
    if (!(parama instanceof f)) {}
    for (Object localObject = null;; localObject = parama)
    {
      localObject = (f)localObject;
      if (localObject != null)
      {
        localObject = ((f)localObject).hbC();
        if (localObject != null) {}
      }
      else
      {
        localObject = "";
      }
      for (;;)
      {
        if (!(parama instanceof f)) {
          parama = null;
        }
        for (;;)
        {
          parama = (f)parama;
          if (parama != null)
          {
            str = parama.getCurrentUrl();
            parama = str;
            if (str != null) {}
          }
          else
          {
            parama = "";
          }
          parama = ab.aXb(parama);
          String str = ab.aXb(this.Qww.videoPath);
          int i;
          if (k.f(parame))
          {
            if (parame == null)
            {
              parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.player.exo.ExoMediaPlayer");
              AppMethodBeat.o(258422);
              throw parama;
            }
            i = ((g)parame).bWy();
          }
          int j;
          while (k.f(parame)) {
            if (parame == null)
            {
              parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.player.exo.ExoMediaPlayer");
              AppMethodBeat.o(258422);
              throw parama;
              i = 0;
            }
            else
            {
              j = ((g)parame).bWz();
            }
          }
          int k;
          while (k.f(parame)) {
            if (parame == null)
            {
              parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.player.exo.ExoMediaPlayer");
              AppMethodBeat.o(258422);
              throw parama;
              j = 0;
            }
            else
            {
              k = ((g)parame).bWA();
              parame = i.bVn();
              p.j(parame, "VideoCore.getInstance()");
              if (!parame.bVp()) {
                break label751;
              }
              parame = i.bVn();
              p.j(parame, "VideoCore.getInstance()");
              if (!parame.bVo()) {
                break label751;
              }
            }
          }
          label751:
          for (int m = 1;; m = 0)
          {
            parame = i.bVn();
            p.j(parame, "VideoCore.getInstance()");
            Log.i("MicroMsg.WebViewVideoProfileReport", "reportVideoProfile:%s, webComptName:%s, proxy:%s, playerCreateTime:%s, videoPath:%s, cachedSize:%s, duration:%s, prepareTime:%s, bufferCount:%s, bufferTime:%s, error(%s, %s, %s), minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", new Object[] { paramString, localObject, Boolean.valueOf(parame.bVp()), Long.valueOf(this.Qww.pOh), this.Qww.videoPath, Long.valueOf(this.Qww.pOi), Long.valueOf(this.Qww.duration), Long.valueOf(this.Qww.pOl), Integer.valueOf(this.Qww.pOm), Long.valueOf(this.Qww.pOn), Integer.valueOf(this.Qww.pOs), Integer.valueOf(this.Qww.pOt), this.Qww.errorMsg, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
            h.IzE.a(19953, new Object[] { localObject, parama, str, Long.valueOf(this.Qww.pOj), Long.valueOf(this.Qww.pOk), Long.valueOf(this.Qww.pOl), Long.valueOf(this.Qww.pOh), Long.valueOf(this.Qww.duration), Long.valueOf(this.Qww.pOi), Integer.valueOf(this.Qww.pOs), Integer.valueOf(this.Qww.pOt), this.Qww.errorMsg, Integer.valueOf(m), Integer.valueOf(this.Qww.pOm), Long.valueOf(this.Qww.pOn), Long.valueOf(this.Qww.pOq), Long.valueOf(this.Qww.pOr), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
            this.Qww.reset();
            AppMethodBeat.o(258422);
            return;
            k = 0;
            break;
          }
        }
      }
    }
  }
  
  public final void bnj(String paramString)
  {
    AppMethodBeat.i(258418);
    if (paramString == null)
    {
      AppMethodBeat.o(258418);
      return;
    }
    h.IzE.idkeyStat(1379L, 14L, 1L, false);
    if (0L > 0L)
    {
      h.IzE.idkeyStat(1379L, 15L, 1L, false);
      h.IzE.idkeyStat(1379L, 16L, 0L, false);
      Log.d("MicroMsg.WebViewVideoProfileReport", "onVideoPathChanged, cachedSize:%s, cachedSizeInKB:%s", new Object[] { Long.valueOf(0L), Long.valueOf(0L) });
    }
    this.Qww.setVideoPath(paramString);
    this.Qww.pOi = 0L;
    AppMethodBeat.o(258418);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport$VideoProfileData;", "", "(Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;)V", "bufferEndTime", "", "getBufferEndTime", "()J", "setBufferEndTime", "(J)V", "bufferStartTime", "getBufferStartTime", "setBufferStartTime", "buffetAllTime", "getBuffetAllTime", "setBuffetAllTime", "buffetCount", "", "getBuffetCount", "()I", "setBuffetCount", "(I)V", "cachedSize", "getCachedSize", "setCachedSize", "duration", "getDuration", "setDuration", "endTimeStamp", "getEndTimeStamp", "setEndTimeStamp", "errorExtra", "getErrorExtra", "setErrorExtra", "errorMsg", "", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "errorWhat", "getErrorWhat", "setErrorWhat", "playerCreateTime", "getPlayerCreateTime", "setPlayerCreateTime", "prepareEndTime", "getPrepareEndTime", "setPrepareEndTime", "prepareStartTime", "getPrepareStartTime", "setPrepareStartTime", "prepareTime", "getPrepareTime", "setPrepareTime", "stopTimeStamp", "getStopTimeStamp", "setStopTimeStamp", "value", "videoPath", "getVideoPath", "setVideoPath", "reset", "", "resetBufferTime", "plugin-webview_release"})
  public final class b
  {
    long duration;
    String errorMsg = "";
    long pOh;
    long pOi;
    long pOj;
    long pOk;
    long pOl;
    int pOm;
    long pOn;
    long pOo;
    long pOp;
    long pOq;
    long pOr;
    int pOs;
    int pOt;
    String videoPath = "";
    
    public final void reset()
    {
      AppMethodBeat.i(236747);
      setVideoPath("");
      this.pOh = 0L;
      this.duration = 0L;
      this.pOi = 0L;
      this.pOj = 0L;
      this.pOk = 0L;
      this.pOl = 0L;
      this.pOm = 0;
      this.pOo = 0L;
      this.pOp = 0L;
      this.pOn = 0L;
      this.pOq = 0L;
      this.pOr = 0L;
      this.pOs = 0;
      this.pOt = 0;
      this.errorMsg = "";
      AppMethodBeat.o(236747);
    }
    
    public final void setVideoPath(String paramString)
    {
      AppMethodBeat.i(236740);
      p.k(paramString, "value");
      String str;
      if (!Util.isNullOrNil(paramString))
      {
        str = paramString;
        if (paramString.length() > 512)
        {
          str = paramString.substring(0, 512);
          p.j(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
      }
      for (;;)
      {
        this.videoPath = str;
        AppMethodBeat.o(236740);
        return;
        str = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.l
 * JD-Core Version:    0.7.0.1
 */