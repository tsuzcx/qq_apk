package com.tencent.mm.plugin.webview.ui.tools.d.a;

import com.tencent.luggage.k.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.v;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;", "", "()V", "videoProfileData", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport$VideoProfileData;", "onMediaPlayerCreated", "", "costTime", "", "onMediaPlayerVideoBufferEnd", "onMediaPlayerVideoBufferStart", "onMediaPlayerVideoEnd", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "mediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "onMediaPlayerVideoError", "what", "", "extra", "msg", "", "onMediaPlayerVideoPrepareEnd", "duration", "onMediaPlayerVideoPrepareStart", "onMediaPlayerVideoStop", "onVideoPathChanged", "cachedSize", "videoPath", "reportVideoProfile", "callFrom", "Companion", "VideoProfileData", "plugin-webview_release"})
public final class m
{
  public static final m.a BtY;
  final b BtX;
  
  static
  {
    AppMethodBeat.i(189071);
    BtY = new m.a((byte)0);
    AppMethodBeat.o(189071);
  }
  
  public m()
  {
    AppMethodBeat.i(189070);
    this.BtX = new b();
    AppMethodBeat.o(189070);
  }
  
  public final void a(a parama, b paramb)
  {
    AppMethodBeat.i(189068);
    k.h(paramb, "mediaPlayer");
    if ((!bt.isNullOrNil(this.BtX.videoPath)) && (this.BtX.kCR > 0L))
    {
      this.BtX.kCY = bt.eGO();
      a(parama, paramb, "onMediaPlayerVideoStop");
    }
    AppMethodBeat.o(189068);
  }
  
  final void a(a parama, b paramb, String paramString)
  {
    AppMethodBeat.i(189069);
    if (this.BtX.kCS < this.BtX.kCR)
    {
      ad.i("MicroMsg.WebViewVideoProfileReport", "reportVideoProfile, wired case, ignore reporting and reset data");
      this.BtX.reset();
      AppMethodBeat.o(189069);
      return;
    }
    if (!(parama instanceof f)) {}
    for (Object localObject = null;; localObject = parama)
    {
      localObject = (f)localObject;
      if (localObject != null)
      {
        localObject = ((f)localObject).eqQ();
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
          parama = x.aCL(parama);
          String str = x.aCL(this.BtX.videoPath);
          int i;
          if (com.tencent.mm.plugin.appbrand.jsapi.video.l.f(paramb))
          {
            if (paramb == null)
            {
              parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.player.exo.ExoMediaPlayer");
              AppMethodBeat.o(189069);
              throw parama;
            }
            i = ((c)paramb).bdK();
          }
          int j;
          while (com.tencent.mm.plugin.appbrand.jsapi.video.l.f(paramb)) {
            if (paramb == null)
            {
              parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.player.exo.ExoMediaPlayer");
              AppMethodBeat.o(189069);
              throw parama;
              i = 0;
            }
            else
            {
              j = ((c)paramb).bdL();
            }
          }
          int k;
          while (com.tencent.mm.plugin.appbrand.jsapi.video.l.f(paramb)) {
            if (paramb == null)
            {
              parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.player.exo.ExoMediaPlayer");
              AppMethodBeat.o(189069);
              throw parama;
              j = 0;
            }
            else
            {
              k = ((c)paramb).bdM();
              paramb = j.bcK();
              k.g(paramb, "VideoCore.getInstance()");
              if (!paramb.bcM()) {
                break label751;
              }
              paramb = j.bcK();
              k.g(paramb, "VideoCore.getInstance()");
              if (!paramb.bcL()) {
                break label751;
              }
            }
          }
          label751:
          for (int m = 1;; m = 0)
          {
            paramb = j.bcK();
            k.g(paramb, "VideoCore.getInstance()");
            ad.i("MicroMsg.WebViewVideoProfileReport", "reportVideoProfile:%s, webComptName:%s, proxy:%s, playerCreateTime:%s, videoPath:%s, cachedSize:%s, duration:%s, prepareTime:%s, bufferCount:%s, bufferTime:%s, error(%s, %s, %s), minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", new Object[] { paramString, localObject, Boolean.valueOf(paramb.bcM()), Long.valueOf(this.BtX.kCP), this.BtX.videoPath, Long.valueOf(this.BtX.kCQ), Long.valueOf(this.BtX.duration), Long.valueOf(this.BtX.kCT), Integer.valueOf(this.BtX.kCU), Long.valueOf(this.BtX.kCV), Integer.valueOf(this.BtX.kDa), Integer.valueOf(this.BtX.kDb), this.BtX.errorMsg, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
            h.vKh.f(19953, new Object[] { localObject, parama, str, Long.valueOf(this.BtX.kCR), Long.valueOf(this.BtX.kCS), Long.valueOf(this.BtX.kCT), Long.valueOf(this.BtX.kCP), Long.valueOf(this.BtX.duration), Long.valueOf(this.BtX.kCQ), Integer.valueOf(this.BtX.kDa), Integer.valueOf(this.BtX.kDb), this.BtX.errorMsg, Integer.valueOf(m), Integer.valueOf(this.BtX.kCU), Long.valueOf(this.BtX.kCV), Long.valueOf(this.BtX.kCY), Long.valueOf(this.BtX.kCZ), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
            this.BtX.reset();
            AppMethodBeat.o(189069);
            return;
            k = 0;
            break;
          }
        }
      }
    }
  }
  
  public final void ayG(String paramString)
  {
    AppMethodBeat.i(189067);
    if (paramString == null)
    {
      AppMethodBeat.o(189067);
      return;
    }
    h.vKh.idkeyStat(1379L, 14L, 1L, false);
    if (0L > 0L)
    {
      h.vKh.idkeyStat(1379L, 15L, 1L, false);
      h.vKh.idkeyStat(1379L, 16L, 0L, false);
      ad.d("MicroMsg.WebViewVideoProfileReport", "onVideoPathChanged, cachedSize:%s, cachedSizeInKB:%s", new Object[] { Long.valueOf(0L), Long.valueOf(0L) });
    }
    this.BtX.setVideoPath(paramString);
    this.BtX.kCQ = 0L;
    AppMethodBeat.o(189067);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport$VideoProfileData;", "", "(Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;)V", "bufferEndTime", "", "getBufferEndTime", "()J", "setBufferEndTime", "(J)V", "bufferStartTime", "getBufferStartTime", "setBufferStartTime", "buffetAllTime", "getBuffetAllTime", "setBuffetAllTime", "buffetCount", "", "getBuffetCount", "()I", "setBuffetCount", "(I)V", "cachedSize", "getCachedSize", "setCachedSize", "duration", "getDuration", "setDuration", "endTimeStamp", "getEndTimeStamp", "setEndTimeStamp", "errorExtra", "getErrorExtra", "setErrorExtra", "errorMsg", "", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "errorWhat", "getErrorWhat", "setErrorWhat", "playerCreateTime", "getPlayerCreateTime", "setPlayerCreateTime", "prepareEndTime", "getPrepareEndTime", "setPrepareEndTime", "prepareStartTime", "getPrepareStartTime", "setPrepareStartTime", "prepareTime", "getPrepareTime", "setPrepareTime", "stopTimeStamp", "getStopTimeStamp", "setStopTimeStamp", "value", "videoPath", "getVideoPath", "setVideoPath", "reset", "", "resetBufferTime", "plugin-webview_release"})
  public final class b
  {
    long duration;
    String errorMsg = "";
    long kCP;
    long kCQ;
    long kCR;
    long kCS;
    long kCT;
    int kCU;
    long kCV;
    long kCW;
    long kCX;
    long kCY;
    long kCZ;
    int kDa;
    int kDb;
    String videoPath = "";
    
    public final void reset()
    {
      AppMethodBeat.i(189066);
      setVideoPath("");
      this.kCP = 0L;
      this.duration = 0L;
      this.kCQ = 0L;
      this.kCR = 0L;
      this.kCS = 0L;
      this.kCT = 0L;
      this.kCU = 0;
      this.kCW = 0L;
      this.kCX = 0L;
      this.kCV = 0L;
      this.kCY = 0L;
      this.kCZ = 0L;
      this.kDa = 0;
      this.kDb = 0;
      this.errorMsg = "";
      AppMethodBeat.o(189066);
    }
    
    public final void setVideoPath(String paramString)
    {
      AppMethodBeat.i(189065);
      k.h(paramString, "value");
      String str;
      if (!bt.isNullOrNil(paramString))
      {
        str = paramString;
        if (paramString.length() > 512)
        {
          str = paramString.substring(0, 512);
          k.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
      }
      for (;;)
      {
        this.videoPath = str;
        AppMethodBeat.o(189065);
        return;
        str = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.d.a.m
 * JD-Core Version:    0.7.0.1
 */