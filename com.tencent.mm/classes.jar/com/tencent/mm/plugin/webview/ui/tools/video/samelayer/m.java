package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.v;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;", "", "()V", "videoProfileData", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport$VideoProfileData;", "onMediaPlayerCreated", "", "costTime", "", "onMediaPlayerVideoBufferEnd", "onMediaPlayerVideoBufferStart", "onMediaPlayerVideoEnd", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "mediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "onMediaPlayerVideoError", "what", "", "extra", "msg", "", "onMediaPlayerVideoPrepareEnd", "duration", "onMediaPlayerVideoPrepareStart", "onMediaPlayerVideoStop", "onVideoPathChanged", "cachedSize", "videoPath", "reportVideoProfile", "callFrom", "Companion", "VideoProfileData", "plugin-webview_release"})
public final class m
{
  public static final m.a EIx;
  final b EIw;
  
  static
  {
    AppMethodBeat.i(199566);
    EIx = new m.a((byte)0);
    AppMethodBeat.o(199566);
  }
  
  public m()
  {
    AppMethodBeat.i(199565);
    this.EIw = new b();
    AppMethodBeat.o(199565);
  }
  
  public final void a(a parama, b paramb)
  {
    AppMethodBeat.i(199563);
    p.h(paramb, "mediaPlayer");
    if ((!bu.isNullOrNil(this.EIw.videoPath)) && (this.EIw.lFG > 0L))
    {
      this.EIw.lFN = bu.fpO();
      a(parama, paramb, "onMediaPlayerVideoStop");
    }
    AppMethodBeat.o(199563);
  }
  
  final void a(a parama, b paramb, String paramString)
  {
    AppMethodBeat.i(199564);
    if (this.EIw.lFH < this.EIw.lFG)
    {
      ae.i("MicroMsg.WebViewVideoProfileReport", "reportVideoProfile, wired case, ignore reporting and reset data");
      this.EIw.reset();
      AppMethodBeat.o(199564);
      return;
    }
    if (!(parama instanceof f)) {}
    for (Object localObject = null;; localObject = parama)
    {
      localObject = (f)localObject;
      if (localObject != null)
      {
        localObject = ((f)localObject).eYV();
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
          parama = x.aPc(parama);
          String str = x.aPc(this.EIw.videoPath);
          int i;
          if (com.tencent.mm.plugin.appbrand.jsapi.video.l.f(paramb))
          {
            if (paramb == null)
            {
              parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.player.exo.ExoMediaPlayer");
              AppMethodBeat.o(199564);
              throw parama;
            }
            i = ((c)paramb).boZ();
          }
          int j;
          while (com.tencent.mm.plugin.appbrand.jsapi.video.l.f(paramb)) {
            if (paramb == null)
            {
              parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.player.exo.ExoMediaPlayer");
              AppMethodBeat.o(199564);
              throw parama;
              i = 0;
            }
            else
            {
              j = ((c)paramb).bpa();
            }
          }
          int k;
          while (com.tencent.mm.plugin.appbrand.jsapi.video.l.f(paramb)) {
            if (paramb == null)
            {
              parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.player.exo.ExoMediaPlayer");
              AppMethodBeat.o(199564);
              throw parama;
              j = 0;
            }
            else
            {
              k = ((c)paramb).bpb();
              paramb = j.bob();
              p.g(paramb, "VideoCore.getInstance()");
              if (!paramb.bod()) {
                break label751;
              }
              paramb = j.bob();
              p.g(paramb, "VideoCore.getInstance()");
              if (!paramb.boc()) {
                break label751;
              }
            }
          }
          label751:
          for (int m = 1;; m = 0)
          {
            paramb = j.bob();
            p.g(paramb, "VideoCore.getInstance()");
            ae.i("MicroMsg.WebViewVideoProfileReport", "reportVideoProfile:%s, webComptName:%s, proxy:%s, playerCreateTime:%s, videoPath:%s, cachedSize:%s, duration:%s, prepareTime:%s, bufferCount:%s, bufferTime:%s, error(%s, %s, %s), minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", new Object[] { paramString, localObject, Boolean.valueOf(paramb.bod()), Long.valueOf(this.EIw.lFE), this.EIw.videoPath, Long.valueOf(this.EIw.lFF), Long.valueOf(this.EIw.duration), Long.valueOf(this.EIw.lFI), Integer.valueOf(this.EIw.lFJ), Long.valueOf(this.EIw.lFK), Integer.valueOf(this.EIw.lFP), Integer.valueOf(this.EIw.lFQ), this.EIw.errorMsg, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
            g.yxI.f(19953, new Object[] { localObject, parama, str, Long.valueOf(this.EIw.lFG), Long.valueOf(this.EIw.lFH), Long.valueOf(this.EIw.lFI), Long.valueOf(this.EIw.lFE), Long.valueOf(this.EIw.duration), Long.valueOf(this.EIw.lFF), Integer.valueOf(this.EIw.lFP), Integer.valueOf(this.EIw.lFQ), this.EIw.errorMsg, Integer.valueOf(m), Integer.valueOf(this.EIw.lFJ), Long.valueOf(this.EIw.lFK), Long.valueOf(this.EIw.lFN), Long.valueOf(this.EIw.lFO), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
            this.EIw.reset();
            AppMethodBeat.o(199564);
            return;
            k = 0;
            break;
          }
        }
      }
    }
  }
  
  public final void aKV(String paramString)
  {
    AppMethodBeat.i(199562);
    if (paramString == null)
    {
      AppMethodBeat.o(199562);
      return;
    }
    g.yxI.idkeyStat(1379L, 14L, 1L, false);
    if (0L > 0L)
    {
      g.yxI.idkeyStat(1379L, 15L, 1L, false);
      g.yxI.idkeyStat(1379L, 16L, 0L, false);
      ae.d("MicroMsg.WebViewVideoProfileReport", "onVideoPathChanged, cachedSize:%s, cachedSizeInKB:%s", new Object[] { Long.valueOf(0L), Long.valueOf(0L) });
    }
    this.EIw.setVideoPath(paramString);
    this.EIw.lFF = 0L;
    AppMethodBeat.o(199562);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport$VideoProfileData;", "", "(Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;)V", "bufferEndTime", "", "getBufferEndTime", "()J", "setBufferEndTime", "(J)V", "bufferStartTime", "getBufferStartTime", "setBufferStartTime", "buffetAllTime", "getBuffetAllTime", "setBuffetAllTime", "buffetCount", "", "getBuffetCount", "()I", "setBuffetCount", "(I)V", "cachedSize", "getCachedSize", "setCachedSize", "duration", "getDuration", "setDuration", "endTimeStamp", "getEndTimeStamp", "setEndTimeStamp", "errorExtra", "getErrorExtra", "setErrorExtra", "errorMsg", "", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "errorWhat", "getErrorWhat", "setErrorWhat", "playerCreateTime", "getPlayerCreateTime", "setPlayerCreateTime", "prepareEndTime", "getPrepareEndTime", "setPrepareEndTime", "prepareStartTime", "getPrepareStartTime", "setPrepareStartTime", "prepareTime", "getPrepareTime", "setPrepareTime", "stopTimeStamp", "getStopTimeStamp", "setStopTimeStamp", "value", "videoPath", "getVideoPath", "setVideoPath", "reset", "", "resetBufferTime", "plugin-webview_release"})
  public final class b
  {
    long duration;
    String errorMsg = "";
    long lFE;
    long lFF;
    long lFG;
    long lFH;
    long lFI;
    int lFJ;
    long lFK;
    long lFL;
    long lFM;
    long lFN;
    long lFO;
    int lFP;
    int lFQ;
    String videoPath = "";
    
    public final void reset()
    {
      AppMethodBeat.i(199561);
      setVideoPath("");
      this.lFE = 0L;
      this.duration = 0L;
      this.lFF = 0L;
      this.lFG = 0L;
      this.lFH = 0L;
      this.lFI = 0L;
      this.lFJ = 0;
      this.lFL = 0L;
      this.lFM = 0L;
      this.lFK = 0L;
      this.lFN = 0L;
      this.lFO = 0L;
      this.lFP = 0;
      this.lFQ = 0;
      this.errorMsg = "";
      AppMethodBeat.o(199561);
    }
    
    public final void setVideoPath(String paramString)
    {
      AppMethodBeat.i(199560);
      p.h(paramString, "value");
      String str;
      if (!bu.isNullOrNil(paramString))
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
        AppMethodBeat.o(199560);
        return;
        str = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.m
 * JD-Core Version:    0.7.0.1
 */