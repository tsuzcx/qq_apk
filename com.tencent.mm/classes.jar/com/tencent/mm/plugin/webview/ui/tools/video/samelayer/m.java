package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.v;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;", "", "()V", "videoProfileData", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport$VideoProfileData;", "onMediaPlayerCreated", "", "costTime", "", "onMediaPlayerVideoBufferEnd", "onMediaPlayerVideoBufferStart", "onMediaPlayerVideoEnd", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "mediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "onMediaPlayerVideoError", "what", "", "extra", "msg", "", "onMediaPlayerVideoPrepareEnd", "duration", "onMediaPlayerVideoPrepareStart", "onMediaPlayerVideoStop", "onVideoPathChanged", "cachedSize", "videoPath", "reportVideoProfile", "callFrom", "Companion", "VideoProfileData", "plugin-webview_release"})
public final class m
{
  public static final m.a Eqh;
  final b Eqg;
  
  static
  {
    AppMethodBeat.i(207792);
    Eqh = new m.a((byte)0);
    AppMethodBeat.o(207792);
  }
  
  public m()
  {
    AppMethodBeat.i(207791);
    this.Eqg = new b();
    AppMethodBeat.o(207791);
  }
  
  public final void a(a parama, b paramb)
  {
    AppMethodBeat.i(207789);
    p.h(paramb, "mediaPlayer");
    if ((!bt.isNullOrNil(this.Eqg.videoPath)) && (this.Eqg.lBi > 0L))
    {
      this.Eqg.lBp = bt.flT();
      a(parama, paramb, "onMediaPlayerVideoStop");
    }
    AppMethodBeat.o(207789);
  }
  
  final void a(a parama, b paramb, String paramString)
  {
    AppMethodBeat.i(207790);
    if (this.Eqg.lBj < this.Eqg.lBi)
    {
      ad.i("MicroMsg.WebViewVideoProfileReport", "reportVideoProfile, wired case, ignore reporting and reset data");
      this.Eqg.reset();
      AppMethodBeat.o(207790);
      return;
    }
    if (!(parama instanceof f)) {}
    for (Object localObject = null;; localObject = parama)
    {
      localObject = (f)localObject;
      if (localObject != null)
      {
        localObject = ((f)localObject).eVi();
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
          parama = x.aNF(parama);
          String str = x.aNF(this.Eqg.videoPath);
          int i;
          if (com.tencent.mm.plugin.appbrand.jsapi.video.l.f(paramb))
          {
            if (paramb == null)
            {
              parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.player.exo.ExoMediaPlayer");
              AppMethodBeat.o(207790);
              throw parama;
            }
            i = ((c)paramb).bop();
          }
          int j;
          while (com.tencent.mm.plugin.appbrand.jsapi.video.l.f(paramb)) {
            if (paramb == null)
            {
              parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.player.exo.ExoMediaPlayer");
              AppMethodBeat.o(207790);
              throw parama;
              i = 0;
            }
            else
            {
              j = ((c)paramb).boq();
            }
          }
          int k;
          while (com.tencent.mm.plugin.appbrand.jsapi.video.l.f(paramb)) {
            if (paramb == null)
            {
              parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.player.exo.ExoMediaPlayer");
              AppMethodBeat.o(207790);
              throw parama;
              j = 0;
            }
            else
            {
              k = ((c)paramb).bor();
              paramb = j.bnr();
              p.g(paramb, "VideoCore.getInstance()");
              if (!paramb.bnt()) {
                break label751;
              }
              paramb = j.bnr();
              p.g(paramb, "VideoCore.getInstance()");
              if (!paramb.bns()) {
                break label751;
              }
            }
          }
          label751:
          for (int m = 1;; m = 0)
          {
            paramb = j.bnr();
            p.g(paramb, "VideoCore.getInstance()");
            ad.i("MicroMsg.WebViewVideoProfileReport", "reportVideoProfile:%s, webComptName:%s, proxy:%s, playerCreateTime:%s, videoPath:%s, cachedSize:%s, duration:%s, prepareTime:%s, bufferCount:%s, bufferTime:%s, error(%s, %s, %s), minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", new Object[] { paramString, localObject, Boolean.valueOf(paramb.bnt()), Long.valueOf(this.Eqg.lBg), this.Eqg.videoPath, Long.valueOf(this.Eqg.lBh), Long.valueOf(this.Eqg.duration), Long.valueOf(this.Eqg.lBk), Integer.valueOf(this.Eqg.lBl), Long.valueOf(this.Eqg.lBm), Integer.valueOf(this.Eqg.lBr), Integer.valueOf(this.Eqg.lBs), this.Eqg.errorMsg, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
            g.yhR.f(19953, new Object[] { localObject, parama, str, Long.valueOf(this.Eqg.lBi), Long.valueOf(this.Eqg.lBj), Long.valueOf(this.Eqg.lBk), Long.valueOf(this.Eqg.lBg), Long.valueOf(this.Eqg.duration), Long.valueOf(this.Eqg.lBh), Integer.valueOf(this.Eqg.lBr), Integer.valueOf(this.Eqg.lBs), this.Eqg.errorMsg, Integer.valueOf(m), Integer.valueOf(this.Eqg.lBl), Long.valueOf(this.Eqg.lBm), Long.valueOf(this.Eqg.lBp), Long.valueOf(this.Eqg.lBq), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
            this.Eqg.reset();
            AppMethodBeat.o(207790);
            return;
            k = 0;
            break;
          }
        }
      }
    }
  }
  
  public final void aJz(String paramString)
  {
    AppMethodBeat.i(207788);
    if (paramString == null)
    {
      AppMethodBeat.o(207788);
      return;
    }
    g.yhR.idkeyStat(1379L, 14L, 1L, false);
    if (0L > 0L)
    {
      g.yhR.idkeyStat(1379L, 15L, 1L, false);
      g.yhR.idkeyStat(1379L, 16L, 0L, false);
      ad.d("MicroMsg.WebViewVideoProfileReport", "onVideoPathChanged, cachedSize:%s, cachedSizeInKB:%s", new Object[] { Long.valueOf(0L), Long.valueOf(0L) });
    }
    this.Eqg.setVideoPath(paramString);
    this.Eqg.lBh = 0L;
    AppMethodBeat.o(207788);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport$VideoProfileData;", "", "(Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;)V", "bufferEndTime", "", "getBufferEndTime", "()J", "setBufferEndTime", "(J)V", "bufferStartTime", "getBufferStartTime", "setBufferStartTime", "buffetAllTime", "getBuffetAllTime", "setBuffetAllTime", "buffetCount", "", "getBuffetCount", "()I", "setBuffetCount", "(I)V", "cachedSize", "getCachedSize", "setCachedSize", "duration", "getDuration", "setDuration", "endTimeStamp", "getEndTimeStamp", "setEndTimeStamp", "errorExtra", "getErrorExtra", "setErrorExtra", "errorMsg", "", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "errorWhat", "getErrorWhat", "setErrorWhat", "playerCreateTime", "getPlayerCreateTime", "setPlayerCreateTime", "prepareEndTime", "getPrepareEndTime", "setPrepareEndTime", "prepareStartTime", "getPrepareStartTime", "setPrepareStartTime", "prepareTime", "getPrepareTime", "setPrepareTime", "stopTimeStamp", "getStopTimeStamp", "setStopTimeStamp", "value", "videoPath", "getVideoPath", "setVideoPath", "reset", "", "resetBufferTime", "plugin-webview_release"})
  public final class b
  {
    long duration;
    String errorMsg = "";
    long lBg;
    long lBh;
    long lBi;
    long lBj;
    long lBk;
    int lBl;
    long lBm;
    long lBn;
    long lBo;
    long lBp;
    long lBq;
    int lBr;
    int lBs;
    String videoPath = "";
    
    public final void reset()
    {
      AppMethodBeat.i(207787);
      setVideoPath("");
      this.lBg = 0L;
      this.duration = 0L;
      this.lBh = 0L;
      this.lBi = 0L;
      this.lBj = 0L;
      this.lBk = 0L;
      this.lBl = 0;
      this.lBn = 0L;
      this.lBo = 0L;
      this.lBm = 0L;
      this.lBp = 0L;
      this.lBq = 0L;
      this.lBr = 0;
      this.lBs = 0;
      this.errorMsg = "";
      AppMethodBeat.o(207787);
    }
    
    public final void setVideoPath(String paramString)
    {
      AppMethodBeat.i(207786);
      p.h(paramString, "value");
      String str;
      if (!bt.isNullOrNil(paramString))
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
        AppMethodBeat.o(207786);
        return;
        str = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.m
 * JD-Core Version:    0.7.0.1
 */