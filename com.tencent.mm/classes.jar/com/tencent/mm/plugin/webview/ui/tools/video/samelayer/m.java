package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;", "", "()V", "videoProfileData", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport$VideoProfileData;", "onMediaPlayerCreated", "", "costTime", "", "onMediaPlayerVideoBufferEnd", "onMediaPlayerVideoBufferStart", "onMediaPlayerVideoEnd", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "mediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "onMediaPlayerVideoError", "what", "", "extra", "msg", "", "onMediaPlayerVideoPrepareEnd", "duration", "onMediaPlayerVideoPrepareStart", "onMediaPlayerVideoStop", "onVideoPathChanged", "cachedSize", "videoPath", "reportVideoProfile", "callFrom", "Companion", "VideoProfileData", "plugin-webview_release"})
public final class m
{
  public static final m.a Jyn;
  final b Jym;
  
  static
  {
    AppMethodBeat.i(210793);
    Jyn = new m.a((byte)0);
    AppMethodBeat.o(210793);
  }
  
  public m()
  {
    AppMethodBeat.i(210792);
    this.Jym = new b();
    AppMethodBeat.o(210792);
  }
  
  public final void a(a parama, c paramc)
  {
    AppMethodBeat.i(210790);
    p.h(paramc, "mediaPlayer");
    if ((!Util.isNullOrNil(this.Jym.videoPath)) && (this.Jym.mNq > 0L))
    {
      this.Jym.mNx = Util.nowMilliSecond();
      a(parama, paramc, "onMediaPlayerVideoStop");
    }
    AppMethodBeat.o(210790);
  }
  
  final void a(a parama, c paramc, String paramString)
  {
    AppMethodBeat.i(210791);
    if (this.Jym.mNr < this.Jym.mNq)
    {
      Log.i("MicroMsg.WebViewVideoProfileReport", "reportVideoProfile, wired case, ignore reporting and reset data");
      this.Jym.reset();
      AppMethodBeat.o(210791);
      return;
    }
    if (!(parama instanceof f)) {}
    for (Object localObject = null;; localObject = parama)
    {
      localObject = (f)localObject;
      if (localObject != null)
      {
        localObject = ((f)localObject).gid();
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
          parama = z.bfG(parama);
          String str = z.bfG(this.Jym.videoPath);
          int i;
          if (com.tencent.mm.plugin.appbrand.jsapi.video.l.f(paramc))
          {
            if (paramc == null)
            {
              parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.player.exo.ExoMediaPlayer");
              AppMethodBeat.o(210791);
              throw parama;
            }
            i = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)paramc).bKD();
          }
          int j;
          while (com.tencent.mm.plugin.appbrand.jsapi.video.l.f(paramc)) {
            if (paramc == null)
            {
              parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.player.exo.ExoMediaPlayer");
              AppMethodBeat.o(210791);
              throw parama;
              i = 0;
            }
            else
            {
              j = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)paramc).bKE();
            }
          }
          int k;
          while (com.tencent.mm.plugin.appbrand.jsapi.video.l.f(paramc)) {
            if (paramc == null)
            {
              parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.player.exo.ExoMediaPlayer");
              AppMethodBeat.o(210791);
              throw parama;
              j = 0;
            }
            else
            {
              k = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)paramc).bKF();
              paramc = j.bJE();
              p.g(paramc, "VideoCore.getInstance()");
              if (!paramc.bJG()) {
                break label751;
              }
              paramc = j.bJE();
              p.g(paramc, "VideoCore.getInstance()");
              if (!paramc.bJF()) {
                break label751;
              }
            }
          }
          label751:
          for (int m = 1;; m = 0)
          {
            paramc = j.bJE();
            p.g(paramc, "VideoCore.getInstance()");
            Log.i("MicroMsg.WebViewVideoProfileReport", "reportVideoProfile:%s, webComptName:%s, proxy:%s, playerCreateTime:%s, videoPath:%s, cachedSize:%s, duration:%s, prepareTime:%s, bufferCount:%s, bufferTime:%s, error(%s, %s, %s), minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", new Object[] { paramString, localObject, Boolean.valueOf(paramc.bJG()), Long.valueOf(this.Jym.mNo), this.Jym.videoPath, Long.valueOf(this.Jym.mNp), Long.valueOf(this.Jym.duration), Long.valueOf(this.Jym.mNs), Integer.valueOf(this.Jym.mNt), Long.valueOf(this.Jym.mNu), Integer.valueOf(this.Jym.mNz), Integer.valueOf(this.Jym.mNA), this.Jym.errorMsg, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
            h.CyF.a(19953, new Object[] { localObject, parama, str, Long.valueOf(this.Jym.mNq), Long.valueOf(this.Jym.mNr), Long.valueOf(this.Jym.mNs), Long.valueOf(this.Jym.mNo), Long.valueOf(this.Jym.duration), Long.valueOf(this.Jym.mNp), Integer.valueOf(this.Jym.mNz), Integer.valueOf(this.Jym.mNA), this.Jym.errorMsg, Integer.valueOf(m), Integer.valueOf(this.Jym.mNt), Long.valueOf(this.Jym.mNu), Long.valueOf(this.Jym.mNx), Long.valueOf(this.Jym.mNy), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
            this.Jym.reset();
            AppMethodBeat.o(210791);
            return;
            k = 0;
            break;
          }
        }
      }
    }
  }
  
  public final void bbl(String paramString)
  {
    AppMethodBeat.i(210789);
    if (paramString == null)
    {
      AppMethodBeat.o(210789);
      return;
    }
    h.CyF.idkeyStat(1379L, 14L, 1L, false);
    if (0L > 0L)
    {
      h.CyF.idkeyStat(1379L, 15L, 1L, false);
      h.CyF.idkeyStat(1379L, 16L, 0L, false);
      Log.d("MicroMsg.WebViewVideoProfileReport", "onVideoPathChanged, cachedSize:%s, cachedSizeInKB:%s", new Object[] { Long.valueOf(0L), Long.valueOf(0L) });
    }
    this.Jym.setVideoPath(paramString);
    this.Jym.mNp = 0L;
    AppMethodBeat.o(210789);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport$VideoProfileData;", "", "(Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;)V", "bufferEndTime", "", "getBufferEndTime", "()J", "setBufferEndTime", "(J)V", "bufferStartTime", "getBufferStartTime", "setBufferStartTime", "buffetAllTime", "getBuffetAllTime", "setBuffetAllTime", "buffetCount", "", "getBuffetCount", "()I", "setBuffetCount", "(I)V", "cachedSize", "getCachedSize", "setCachedSize", "duration", "getDuration", "setDuration", "endTimeStamp", "getEndTimeStamp", "setEndTimeStamp", "errorExtra", "getErrorExtra", "setErrorExtra", "errorMsg", "", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "errorWhat", "getErrorWhat", "setErrorWhat", "playerCreateTime", "getPlayerCreateTime", "setPlayerCreateTime", "prepareEndTime", "getPrepareEndTime", "setPrepareEndTime", "prepareStartTime", "getPrepareStartTime", "setPrepareStartTime", "prepareTime", "getPrepareTime", "setPrepareTime", "stopTimeStamp", "getStopTimeStamp", "setStopTimeStamp", "value", "videoPath", "getVideoPath", "setVideoPath", "reset", "", "resetBufferTime", "plugin-webview_release"})
  public final class b
  {
    long duration;
    String errorMsg = "";
    int mNA;
    long mNo;
    long mNp;
    long mNq;
    long mNr;
    long mNs;
    int mNt;
    long mNu;
    long mNv;
    long mNw;
    long mNx;
    long mNy;
    int mNz;
    String videoPath = "";
    
    public final void reset()
    {
      AppMethodBeat.i(210788);
      setVideoPath("");
      this.mNo = 0L;
      this.duration = 0L;
      this.mNp = 0L;
      this.mNq = 0L;
      this.mNr = 0L;
      this.mNs = 0L;
      this.mNt = 0;
      this.mNv = 0L;
      this.mNw = 0L;
      this.mNu = 0L;
      this.mNx = 0L;
      this.mNy = 0L;
      this.mNz = 0;
      this.mNA = 0;
      this.errorMsg = "";
      AppMethodBeat.o(210788);
    }
    
    public final void setVideoPath(String paramString)
    {
      AppMethodBeat.i(210787);
      p.h(paramString, "value");
      String str;
      if (!Util.isNullOrNil(paramString))
      {
        str = paramString;
        if (paramString.length() > 512)
        {
          str = paramString.substring(0, 512);
          p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
      }
      for (;;)
      {
        this.videoPath = str;
        AppMethodBeat.o(210787);
        return;
        str = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.m
 * JD-Core Version:    0.7.0.1
 */