package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class q
  extends MMVideoView
{
  private b Acd;
  String sessionId = "";
  private dio zZN;
  
  public q(Context paramContext, b paramb)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.Acd = paramb;
  }
  
  private static boolean crM()
  {
    AppMethodBeat.i(126177);
    try
    {
      g.agS();
      boolean bool = g.agR().agA().getBoolean(ah.a.GLy, false);
      AppMethodBeat.o(126177);
      return bool;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", localException, "check need reset error", new Object[0]);
      AppMethodBeat.o(126177);
    }
    return false;
  }
  
  public final boolean C(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(164125);
    int i = paramInt;
    if (this.hYv != null)
    {
      int j = this.hYv.aNC();
      i = paramInt;
      if (paramInt > j)
      {
        i = paramInt;
        if (j > 0)
        {
          ac.i("MicroMsg.TopStory.TopStoryVideoView", "%s seek to reset time ori[%d] last key frame[%d]", new Object[] { blf(), Integer.valueOf(paramInt), Integer.valueOf(j) });
          i = j;
        }
      }
    }
    paramBoolean = super.C(i, paramBoolean);
    AppMethodBeat.o(164125);
    return paramBoolean;
  }
  
  public final boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(126183);
    paramPInt1.value = Math.max(paramInt, this.hYA);
    boolean bool2;
    if ((this.hYu == 1) || (this.hYu == 0)) {
      if ((this.hYv != null) && (crM()))
      {
        paramPInt2.value = 0;
        paramPInt1.value = 0;
        bool2 = this.hYv.b(paramInt + 1, paramPInt1, paramPInt2);
        bool1 = bool2;
        if (!bool2)
        {
          paramPInt1.value = paramInt;
          paramPInt1.value += 4;
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      bool2 = bool1;
      if (this.hYu == 2)
      {
        if (this.hYv != null)
        {
          bool1 = this.hYv.b(paramInt, paramPInt1, paramPInt2);
          paramPInt2.value += 4;
        }
        bool2 = bool1;
        if (!bool1)
        {
          paramPInt1.value = (paramInt - 8);
          if (paramPInt1.value < 0) {
            paramPInt1.value = 0;
          }
          paramPInt2.value = (paramPInt1.value + this.hYB + 8);
          bool2 = bool1;
        }
      }
      if ((this.hYu == 3) || (this.hYu == 4))
      {
        paramPInt1.value = this.hYA;
        paramPInt2.value = (this.hYw + 1);
      }
      if (paramPInt2.value >= this.hYw + 1) {
        paramPInt2.value = (this.hYw + 1);
      }
      if (paramPInt2.value < paramPInt1.value)
      {
        paramPInt1.value += 2;
        AppMethodBeat.o(126183);
        return false;
      }
      ac.d("MicroMsg.TopStory.TopStoryVideoView", "%s calcDownloadRange2 range[%d, %d, %b] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { blf(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Boolean.valueOf(bool2), Integer.valueOf(paramInt), Integer.valueOf(this.hYu), Integer.valueOf(this.hYA), Integer.valueOf(this.hYB), this.hYq });
      AppMethodBeat.o(126183);
      return true;
      bool2 = false;
      break;
    }
  }
  
  public final void aJk()
  {
    this.hYF.hYK = 4;
    this.hYF.hYL = 2;
  }
  
  public final void aq(String paramString, int paramInt)
  {
    AppMethodBeat.i(126190);
    super.aq(paramString, paramInt);
    if ((paramInt != 0) && (this.nQs != null)) {
      this.nQs.c(getSessionId(), getMediaId(), "download error", paramInt, 0);
    }
    AppMethodBeat.o(126190);
  }
  
  public final void axS(String paramString)
  {
    AppMethodBeat.i(126184);
    this.sessionId = paramString;
    start();
    AppMethodBeat.o(126184);
  }
  
  public final h cO(Context paramContext)
  {
    AppMethodBeat.i(126176);
    paramContext = new TopStoryVideoPlayTextureView(paramContext);
    paramContext.setOpenWithNoneSurface(true);
    paramContext.setNeedResetExtractor(crM());
    paramContext.setIsOnlineVideoType(true);
    AppMethodBeat.o(126176);
    return paramContext;
  }
  
  public final boolean cPH()
  {
    return false;
  }
  
  public final boolean cZM()
  {
    return false;
  }
  
  public final void eej()
  {
    AppMethodBeat.i(126194);
    ((TopStoryVideoPlayTextureView)this.odZ).setAlpha(0.0F);
    AppMethodBeat.o(126194);
  }
  
  public final void eek()
  {
    AppMethodBeat.i(126195);
    ((TopStoryVideoPlayTextureView)this.odZ).setAlpha(1.0F);
    AppMethodBeat.o(126195);
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(126188);
    int i = 0;
    if (this.odZ != null) {
      i = this.odZ.getCurrentPosition();
    }
    if (this.hYx > 0) {
      i = this.hYx * 1000;
    }
    AppMethodBeat.o(126188);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(126189);
    int i = 0;
    if (this.odZ != null) {
      i = Math.round(this.odZ.getCurrentPosition() * 1.0F / 1000.0F);
    }
    if (this.hYx > 0) {
      i = this.hYx;
    }
    AppMethodBeat.o(126189);
    return i;
  }
  
  public final String getSessionId()
  {
    return this.sessionId;
  }
  
  public final void i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(126181);
    if (!bs.lr(this.hYq, paramString))
    {
      AppMethodBeat.o(126181);
      return;
    }
    ac.d("MicroMsg.TopStory.TopStoryVideoView", "%s download  onProgress [%d, %d]", new Object[] { blf(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.hYz) && (this.hYu == 3)) {
      pG(getCurrPosSec());
    }
    AppMethodBeat.o(126181);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(126179);
    super.initView();
    AppMethodBeat.o(126179);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(126187);
    boolean bool2 = super.isPlaying();
    if ((bool2) && (this.hYu == 3)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ac.d("MicroMsg.TopStory.TopStoryVideoView", "%s result [%b] is playing[%b] playStatus[%d]", new Object[] { blf(), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(this.hYu) });
      AppMethodBeat.o(126187);
      return bool2;
    }
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126191);
    super.onError(paramInt1, paramInt2);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(126191);
      return;
      try
      {
        g.agS();
        g.agR().agA().set(ah.a.GLy, Boolean.TRUE);
        if ((this.odZ instanceof TopStoryVideoPlayTextureView)) {
          ((TopStoryVideoPlayTextureView)this.odZ).setNeedResetExtractor(true);
        }
        com.tencent.mm.plugin.websearch.api.a.b.lA(com.tencent.mm.plugin.websearch.api.a.b.rzZ);
        AppMethodBeat.o(126191);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", localException, "%s onError [%s]", new Object[] { blf(), localException.toString() });
        }
      }
      com.tencent.mm.plugin.websearch.api.a.b.lA(com.tencent.mm.plugin.websearch.api.a.b.rzY);
      AppMethodBeat.o(126191);
      return;
      com.tencent.mm.plugin.websearch.api.a.b.lA(com.tencent.mm.plugin.websearch.api.a.b.rAa);
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126185);
    super.onUIDestroy();
    this.Acd = null;
    AppMethodBeat.o(126185);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(126193);
    ac.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIPause", new Object[] { blf() });
    if (this.kWa)
    {
      this.kWl = getCurrPosSec();
      this.kWm = isPlaying();
      this.kWs = 0;
      this.kWr = 0L;
      pause();
      stopTimer();
      this.kWa = false;
      oQ(getReportIdkey() + 11);
    }
    AppMethodBeat.o(126193);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(126192);
    ac.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIResume", new Object[] { blf() });
    if (!this.kWa)
    {
      this.kWa = true;
      if (this.odZ != null)
      {
        if (!this.kWm) {
          break label75;
        }
        play();
      }
    }
    for (;;)
    {
      oQ(getReportIdkey() + 10);
      AppMethodBeat.o(126192);
      return;
      label75:
      ((VideoPlayerTextureView)this.odZ).bld();
    }
  }
  
  public final boolean pH(int paramInt)
  {
    AppMethodBeat.i(126180);
    if (this.hYt == 3)
    {
      AppMethodBeat.o(126180);
      return true;
    }
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      PInt localPInt3 = new PInt();
      localPInt4 = new PInt();
      if ((paramInt != 0) || (this.hYv == null) || (!crM())) {
        break label249;
      }
      localPInt4.value = 0;
      localPInt3.value = 0;
      bool1 = this.hYv.b(paramInt + 1, localPInt3, localPInt4);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          PInt localPInt4;
          this.hYA = i;
          bool2 = bool1;
          AppMethodBeat.o(126180);
          return bool2;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localException1 = localException1;
        boolean bool1 = false;
        ac.e("MicroMsg.TopStory.TopStoryVideoView", "%s check video data error %s ", new Object[] { blf(), localException1.toString() });
        boolean bool2 = bool1;
        continue;
        bool2 = false;
        continue;
        int i = paramInt + 1;
        continue;
        bool1 = false;
      }
    }
    if (bool1)
    {
      i = localPInt4.value;
      if ((this.hYp != null) && (this.hYv != null) && (this.hYv.a(paramInt, i, localPInt1, localPInt2)))
      {
        bool1 = this.hYp.isVideoDataAvailable(this.hYq, localPInt1.value, localPInt2.value);
        bool2 = bool1;
        if (!bool1) {}
      }
    }
  }
  
  public final void setVideoInfo(dio paramdio)
  {
    AppMethodBeat.i(126178);
    super.c(false, paramdio.videoUrl, 0);
    this.zZN = paramdio;
    this.hYq = d.bp(paramdio.sVF, paramdio.FRO);
    this.hYr = (this.Acd.edg() + this.hYq + ".mp4");
    AppMethodBeat.o(126178);
  }
  
  public final void start()
  {
    AppMethodBeat.i(126186);
    super.start();
    a.lA(5);
    AppMethodBeat.o(126186);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(126196);
    super.stop();
    this.zZN = null;
    AppMethodBeat.o(126196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.q
 * JD-Core Version:    0.7.0.1
 */