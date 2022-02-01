package com.tencent.mm.plugin.webview.ui.tools.c.a;

import com.tencent.luggage.k.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.n;
import com.tencent.mm.plugin.appbrand.jsapi.video.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;", "", "()V", "videoProfileData", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport$VideoProfileData;", "onMediaPlayerCreated", "", "costTime", "", "onMediaPlayerVideoBufferEnd", "onMediaPlayerVideoBufferStart", "onMediaPlayerVideoEnd", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "mediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "onMediaPlayerVideoError", "what", "", "extra", "msg", "", "onMediaPlayerVideoPrepareEnd", "duration", "onMediaPlayerVideoPrepareStart", "onMediaPlayerVideoStop", "onVideoPathChanged", "cachedSize", "videoPath", "reportVideoProfile", "callFrom", "Companion", "VideoProfileData", "plugin-webview_release"})
public final class m
{
  public static final m.a CMh;
  final b CMg;
  
  static
  {
    AppMethodBeat.i(189657);
    CMh = new m.a((byte)0);
    AppMethodBeat.o(189657);
  }
  
  public m()
  {
    AppMethodBeat.i(189656);
    this.CMg = new b();
    AppMethodBeat.o(189656);
  }
  
  public final void a(a parama, b paramb)
  {
    AppMethodBeat.i(189654);
    k.h(paramb, "mediaPlayer");
    if ((!bs.isNullOrNil(this.CMg.videoPath)) && (this.CMg.lei > 0L))
    {
      this.CMg.leq = bs.eWj();
      a(parama, paramb, "onMediaPlayerVideoStop");
    }
    AppMethodBeat.o(189654);
  }
  
  final void a(a parama, b paramb, String paramString)
  {
    AppMethodBeat.i(189655);
    if (this.CMg.lej < this.CMg.lei)
    {
      ac.i("MicroMsg.WebViewVideoProfileReport", "reportVideoProfile, wired case, ignore reporting and reset data");
      this.CMg.reset();
      AppMethodBeat.o(189655);
      return;
    }
    if (!(parama instanceof f)) {}
    for (Object localObject = null;; localObject = parama)
    {
      localObject = (f)localObject;
      if (localObject != null)
      {
        localObject = ((f)localObject).eGk();
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
          parama = x.aId(parama);
          String str = x.aId(this.CMg.videoPath);
          int i;
          if (r.f(paramb))
          {
            if (paramb == null)
            {
              parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.player.exo.ExoMediaPlayer");
              AppMethodBeat.o(189655);
              throw parama;
            }
            i = ((c)paramb).bkE();
          }
          int j;
          while (r.f(paramb)) {
            if (paramb == null)
            {
              parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.player.exo.ExoMediaPlayer");
              AppMethodBeat.o(189655);
              throw parama;
              i = 0;
            }
            else
            {
              j = ((c)paramb).bkF();
            }
          }
          int k;
          while (r.f(paramb)) {
            if (paramb == null)
            {
              parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.player.exo.ExoMediaPlayer");
              AppMethodBeat.o(189655);
              throw parama;
              j = 0;
            }
            else
            {
              k = ((c)paramb).bkG();
              paramb = n.bjG();
              k.g(paramb, "VideoCore.getInstance()");
              if (!paramb.bjI()) {
                break label751;
              }
              paramb = n.bjG();
              k.g(paramb, "VideoCore.getInstance()");
              if (!paramb.bjH()) {
                break label751;
              }
            }
          }
          label751:
          for (int m = 1;; m = 0)
          {
            paramb = n.bjG();
            k.g(paramb, "VideoCore.getInstance()");
            ac.i("MicroMsg.WebViewVideoProfileReport", "reportVideoProfile:%s, webComptName:%s, proxy:%s, playerCreateTime:%s, videoPath:%s, cachedSize:%s, duration:%s, prepareTime:%s, bufferCount:%s, bufferTime:%s, error(%s, %s, %s), minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", new Object[] { paramString, localObject, Boolean.valueOf(paramb.bjI()), Long.valueOf(this.CMg.leg), this.CMg.videoPath, Long.valueOf(this.CMg.leh), Long.valueOf(this.CMg.duration), Long.valueOf(this.CMg.lek), Integer.valueOf(this.CMg.lel), Long.valueOf(this.CMg.lem), Integer.valueOf(this.CMg.les), Integer.valueOf(this.CMg.let), this.CMg.errorMsg, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
            h.wUl.f(19953, new Object[] { localObject, parama, str, Long.valueOf(this.CMg.lei), Long.valueOf(this.CMg.lej), Long.valueOf(this.CMg.lek), Long.valueOf(this.CMg.leg), Long.valueOf(this.CMg.duration), Long.valueOf(this.CMg.leh), Integer.valueOf(this.CMg.les), Integer.valueOf(this.CMg.let), this.CMg.errorMsg, Integer.valueOf(m), Integer.valueOf(this.CMg.lel), Long.valueOf(this.CMg.lem), Long.valueOf(this.CMg.leq), Long.valueOf(this.CMg.ler), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
            this.CMg.reset();
            AppMethodBeat.o(189655);
            return;
            k = 0;
            break;
          }
        }
      }
    }
  }
  
  public final void aDX(String paramString)
  {
    AppMethodBeat.i(189653);
    if (paramString == null)
    {
      AppMethodBeat.o(189653);
      return;
    }
    h.wUl.idkeyStat(1379L, 14L, 1L, false);
    if (0L > 0L)
    {
      h.wUl.idkeyStat(1379L, 15L, 1L, false);
      h.wUl.idkeyStat(1379L, 16L, 0L, false);
      ac.d("MicroMsg.WebViewVideoProfileReport", "onVideoPathChanged, cachedSize:%s, cachedSizeInKB:%s", new Object[] { Long.valueOf(0L), Long.valueOf(0L) });
    }
    this.CMg.setVideoPath(paramString);
    this.CMg.leh = 0L;
    AppMethodBeat.o(189653);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport$VideoProfileData;", "", "(Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;)V", "bufferEndTime", "", "getBufferEndTime", "()J", "setBufferEndTime", "(J)V", "bufferStartTime", "getBufferStartTime", "setBufferStartTime", "buffetAllTime", "getBuffetAllTime", "setBuffetAllTime", "buffetCount", "", "getBuffetCount", "()I", "setBuffetCount", "(I)V", "cachedSize", "getCachedSize", "setCachedSize", "duration", "getDuration", "setDuration", "endTimeStamp", "getEndTimeStamp", "setEndTimeStamp", "errorExtra", "getErrorExtra", "setErrorExtra", "errorMsg", "", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "errorWhat", "getErrorWhat", "setErrorWhat", "playerCreateTime", "getPlayerCreateTime", "setPlayerCreateTime", "prepareEndTime", "getPrepareEndTime", "setPrepareEndTime", "prepareStartTime", "getPrepareStartTime", "setPrepareStartTime", "prepareTime", "getPrepareTime", "setPrepareTime", "stopTimeStamp", "getStopTimeStamp", "setStopTimeStamp", "value", "videoPath", "getVideoPath", "setVideoPath", "reset", "", "resetBufferTime", "plugin-webview_release"})
  public final class b
  {
    long duration;
    String errorMsg = "";
    long leg;
    long leh;
    long lei;
    long lej;
    long lek;
    int lel;
    long lem;
    long leo;
    long lep;
    long leq;
    long ler;
    int les;
    int let;
    String videoPath = "";
    
    public final void reset()
    {
      AppMethodBeat.i(189652);
      setVideoPath("");
      this.leg = 0L;
      this.duration = 0L;
      this.leh = 0L;
      this.lei = 0L;
      this.lej = 0L;
      this.lek = 0L;
      this.lel = 0;
      this.leo = 0L;
      this.lep = 0L;
      this.lem = 0L;
      this.leq = 0L;
      this.ler = 0L;
      this.les = 0;
      this.let = 0;
      this.errorMsg = "";
      AppMethodBeat.o(189652);
    }
    
    public final void setVideoPath(String paramString)
    {
      AppMethodBeat.i(189651);
      k.h(paramString, "value");
      String str;
      if (!bs.isNullOrNil(paramString))
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
        AppMethodBeat.o(189651);
        return;
        str = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c.a.m
 * JD-Core Version:    0.7.0.1
 */