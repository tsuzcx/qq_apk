package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class q
  extends MMVideoView
{
  private dod Brz;
  private b BtO;
  String sessionId = "";
  
  public q(Context paramContext, b paramb)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.BtO = paramb;
  }
  
  private static boolean cxy()
  {
    AppMethodBeat.i(126177);
    try
    {
      g.ajD();
      boolean bool = g.ajC().ajl().getBoolean(al.a.IxQ, false);
      AppMethodBeat.o(126177);
      return bool;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", localException, "check need reset error", new Object[0]);
      AppMethodBeat.o(126177);
    }
    return false;
  }
  
  public final boolean C(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(164125);
    int i = paramInt;
    if (this.irR != null)
    {
      int j = this.irR.aQO();
      i = paramInt;
      if (paramInt > j)
      {
        i = paramInt;
        if (j > 0)
        {
          ad.i("MicroMsg.TopStory.TopStoryVideoView", "%s seek to reset time ori[%d] last key frame[%d]", new Object[] { boQ(), Integer.valueOf(paramInt), Integer.valueOf(j) });
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
    paramPInt1.value = Math.max(paramInt, this.irW);
    boolean bool2;
    if ((this.irQ == 1) || (this.irQ == 0)) {
      if ((this.irR != null) && (cxy()))
      {
        paramPInt2.value = 0;
        paramPInt1.value = 0;
        bool2 = this.irR.b(paramInt + 1, paramPInt1, paramPInt2);
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
      if (this.irQ == 2)
      {
        if (this.irR != null)
        {
          bool1 = this.irR.b(paramInt, paramPInt1, paramPInt2);
          paramPInt2.value += 4;
        }
        bool2 = bool1;
        if (!bool1)
        {
          paramPInt1.value = (paramInt - 8);
          if (paramPInt1.value < 0) {
            paramPInt1.value = 0;
          }
          paramPInt2.value = (paramPInt1.value + this.irX + 8);
          bool2 = bool1;
        }
      }
      if ((this.irQ == 3) || (this.irQ == 4))
      {
        paramPInt1.value = this.irW;
        paramPInt2.value = (this.irS + 1);
      }
      if (paramPInt2.value >= this.irS + 1) {
        paramPInt2.value = (this.irS + 1);
      }
      if (paramPInt2.value < paramPInt1.value)
      {
        paramPInt1.value += 2;
        AppMethodBeat.o(126183);
        return false;
      }
      ad.d("MicroMsg.TopStory.TopStoryVideoView", "%s calcDownloadRange2 range[%d, %d, %b] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { boQ(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Boolean.valueOf(bool2), Integer.valueOf(paramInt), Integer.valueOf(this.irQ), Integer.valueOf(this.irW), Integer.valueOf(this.irX), this.irM });
      AppMethodBeat.o(126183);
      return true;
      bool2 = false;
      break;
    }
  }
  
  public final void aCX(String paramString)
  {
    AppMethodBeat.i(126184);
    this.sessionId = paramString;
    start();
    AppMethodBeat.o(126184);
  }
  
  public final void aMu()
  {
    this.isb.isg = 4;
    this.isb.ish = 2;
  }
  
  public final void as(String paramString, int paramInt)
  {
    AppMethodBeat.i(126190);
    super.as(paramString, paramInt);
    if ((paramInt != 0) && (this.osZ != null)) {
      this.osZ.c(getSessionId(), getMediaId(), "download error", paramInt, 0);
    }
    AppMethodBeat.o(126190);
  }
  
  public final h cL(Context paramContext)
  {
    AppMethodBeat.i(126176);
    paramContext = new TopStoryVideoPlayTextureView(paramContext);
    paramContext.setOpenWithNoneSurface(true);
    paramContext.setNeedResetExtractor(cxy());
    paramContext.setIsOnlineVideoType(true);
    AppMethodBeat.o(126176);
    return paramContext;
  }
  
  public final boolean cYm()
  {
    return false;
  }
  
  public final boolean diZ()
  {
    return false;
  }
  
  public final void eqA()
  {
    AppMethodBeat.i(126194);
    ((TopStoryVideoPlayTextureView)this.oHt).setAlpha(0.0F);
    AppMethodBeat.o(126194);
  }
  
  public final void eqB()
  {
    AppMethodBeat.i(126195);
    ((TopStoryVideoPlayTextureView)this.oHt).setAlpha(1.0F);
    AppMethodBeat.o(126195);
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(126188);
    int i = 0;
    if (this.oHt != null) {
      i = this.oHt.getCurrentPosition();
    }
    if (this.irT > 0) {
      i = this.irT * 1000;
    }
    AppMethodBeat.o(126188);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(126189);
    int i = 0;
    if (this.oHt != null) {
      i = Math.round(this.oHt.getCurrentPosition() * 1.0F / 1000.0F);
    }
    if (this.irT > 0) {
      i = this.irT;
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
    if (!bt.lQ(this.irM, paramString))
    {
      AppMethodBeat.o(126181);
      return;
    }
    ad.d("MicroMsg.TopStory.TopStoryVideoView", "%s download  onProgress [%d, %d]", new Object[] { boQ(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.irV) && (this.irQ == 3)) {
      qi(getCurrPosSec());
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
    if ((bool2) && (this.irQ == 3)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.d("MicroMsg.TopStory.TopStoryVideoView", "%s result [%b] is playing[%b] playStatus[%d]", new Object[] { boQ(), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(this.irQ) });
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
        g.ajD();
        g.ajC().ajl().set(al.a.IxQ, Boolean.TRUE);
        if ((this.oHt instanceof TopStoryVideoPlayTextureView)) {
          ((TopStoryVideoPlayTextureView)this.oHt).setNeedResetExtractor(true);
        }
        com.tencent.mm.plugin.websearch.api.a.b.ma(com.tencent.mm.plugin.websearch.api.a.b.srK);
        AppMethodBeat.o(126191);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", localException, "%s onError [%s]", new Object[] { boQ(), localException.toString() });
        }
      }
      com.tencent.mm.plugin.websearch.api.a.b.ma(com.tencent.mm.plugin.websearch.api.a.b.srJ);
      AppMethodBeat.o(126191);
      return;
      com.tencent.mm.plugin.websearch.api.a.b.ma(com.tencent.mm.plugin.websearch.api.a.b.srL);
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126185);
    super.onUIDestroy();
    this.BtO = null;
    AppMethodBeat.o(126185);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(126193);
    ad.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIPause", new Object[] { boQ() });
    if (this.lsZ)
    {
      this.ltk = getCurrPosSec();
      this.ltl = isPlaying();
      this.ltr = 0;
      this.ltq = 0L;
      pause();
      stopTimer();
      this.lsZ = false;
      qQ(getReportIdkey() + 11);
    }
    AppMethodBeat.o(126193);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(126192);
    ad.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIResume", new Object[] { boQ() });
    if (!this.lsZ)
    {
      this.lsZ = true;
      if (this.oHt != null)
      {
        if (!this.ltl) {
          break label75;
        }
        play();
      }
    }
    for (;;)
    {
      qQ(getReportIdkey() + 10);
      AppMethodBeat.o(126192);
      return;
      label75:
      ((VideoPlayerTextureView)this.oHt).boO();
    }
  }
  
  public final boolean qj(int paramInt)
  {
    AppMethodBeat.i(126180);
    if (this.irP == 3)
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
      if ((paramInt != 0) || (this.irR == null) || (!cxy())) {
        break label249;
      }
      localPInt4.value = 0;
      localPInt3.value = 0;
      bool1 = this.irR.b(paramInt + 1, localPInt3, localPInt4);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          PInt localPInt4;
          this.irW = i;
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
        ad.e("MicroMsg.TopStory.TopStoryVideoView", "%s check video data error %s ", new Object[] { boQ(), localException1.toString() });
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
      if ((this.irL != null) && (this.irR != null) && (this.irR.a(paramInt, i, localPInt1, localPInt2)))
      {
        bool1 = this.irL.isVideoDataAvailable(this.irM, localPInt1.value, localPInt2.value);
        bool2 = bool1;
        if (!bool1) {}
      }
    }
  }
  
  public final void setVideoInfo(dod paramdod)
  {
    AppMethodBeat.i(126178);
    super.c(false, paramdod.videoUrl, 0);
    this.Brz = paramdod;
    this.irM = d.bs(paramdod.tSk, paramdod.HCu);
    this.irN = (this.BtO.epy() + this.irM + ".mp4");
    AppMethodBeat.o(126178);
  }
  
  public final void start()
  {
    AppMethodBeat.i(126186);
    super.start();
    a.ma(5);
    AppMethodBeat.o(126186);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(126196);
    super.stop();
    this.Brz = null;
    AppMethodBeat.o(126196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.q
 * JD-Core Version:    0.7.0.1
 */