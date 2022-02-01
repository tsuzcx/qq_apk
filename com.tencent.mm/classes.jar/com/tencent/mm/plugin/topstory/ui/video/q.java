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
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class q
  extends MMVideoView
{
  private dpa BIY;
  private b BLm;
  String sessionId = "";
  
  public q(Context paramContext, b paramb)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.BLm = paramb;
  }
  
  private static boolean cyZ()
  {
    AppMethodBeat.i(126177);
    try
    {
      g.ajS();
      boolean bool = g.ajR().ajA().getBoolean(am.a.ISo, false);
      AppMethodBeat.o(126177);
      return bool;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", localException, "check need reset error", new Object[0]);
      AppMethodBeat.o(126177);
    }
    return false;
  }
  
  public final boolean C(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(164125);
    int i = paramInt;
    if (this.iuL != null)
    {
      int j = this.iuL.aRn();
      i = paramInt;
      if (paramInt > j)
      {
        i = paramInt;
        if (j > 0)
        {
          ae.i("MicroMsg.TopStory.TopStoryVideoView", "%s seek to reset time ori[%d] last key frame[%d]", new Object[] { bpA(), Integer.valueOf(paramInt), Integer.valueOf(j) });
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
    paramPInt1.value = Math.max(paramInt, this.iuQ);
    boolean bool2;
    if ((this.iuK == 1) || (this.iuK == 0)) {
      if ((this.iuL != null) && (cyZ()))
      {
        paramPInt2.value = 0;
        paramPInt1.value = 0;
        bool2 = this.iuL.b(paramInt + 1, paramPInt1, paramPInt2);
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
      if (this.iuK == 2)
      {
        if (this.iuL != null)
        {
          bool1 = this.iuL.b(paramInt, paramPInt1, paramPInt2);
          paramPInt2.value += 4;
        }
        bool2 = bool1;
        if (!bool1)
        {
          paramPInt1.value = (paramInt - 8);
          if (paramPInt1.value < 0) {
            paramPInt1.value = 0;
          }
          paramPInt2.value = (paramPInt1.value + this.iuR + 8);
          bool2 = bool1;
        }
      }
      if ((this.iuK == 3) || (this.iuK == 4))
      {
        paramPInt1.value = this.iuQ;
        paramPInt2.value = (this.iuM + 1);
      }
      if (paramPInt2.value >= this.iuM + 1) {
        paramPInt2.value = (this.iuM + 1);
      }
      if (paramPInt2.value < paramPInt1.value)
      {
        paramPInt1.value += 2;
        AppMethodBeat.o(126183);
        return false;
      }
      ae.d("MicroMsg.TopStory.TopStoryVideoView", "%s calcDownloadRange2 range[%d, %d, %b] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { bpA(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Boolean.valueOf(bool2), Integer.valueOf(paramInt), Integer.valueOf(this.iuK), Integer.valueOf(this.iuQ), Integer.valueOf(this.iuR), this.iuG });
      AppMethodBeat.o(126183);
      return true;
      bool2 = false;
      break;
    }
  }
  
  public final void aEq(String paramString)
  {
    AppMethodBeat.i(126184);
    this.sessionId = paramString;
    start();
    AppMethodBeat.o(126184);
  }
  
  public final void aMS()
  {
    this.iuV.iva = 4;
    this.iuV.ivb = 2;
  }
  
  public final void at(String paramString, int paramInt)
  {
    AppMethodBeat.i(126190);
    super.at(paramString, paramInt);
    if ((paramInt != 0) && (this.ozA != null)) {
      this.ozA.c(getSessionId(), getMediaId(), "download error", paramInt, 0);
    }
    AppMethodBeat.o(126190);
  }
  
  public final h cN(Context paramContext)
  {
    AppMethodBeat.i(126176);
    paramContext = new TopStoryVideoPlayTextureView(paramContext);
    paramContext.setOpenWithNoneSurface(true);
    paramContext.setNeedResetExtractor(cyZ());
    paramContext.setIsOnlineVideoType(true);
    AppMethodBeat.o(126176);
    return paramContext;
  }
  
  public final boolean daW()
  {
    return false;
  }
  
  public final boolean dlY()
  {
    return false;
  }
  
  public final void euh()
  {
    AppMethodBeat.i(126194);
    ((TopStoryVideoPlayTextureView)this.oNV).setAlpha(0.0F);
    AppMethodBeat.o(126194);
  }
  
  public final void eui()
  {
    AppMethodBeat.i(126195);
    ((TopStoryVideoPlayTextureView)this.oNV).setAlpha(1.0F);
    AppMethodBeat.o(126195);
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(126188);
    int i = 0;
    if (this.oNV != null) {
      i = this.oNV.getCurrentPosition();
    }
    if (this.iuN > 0) {
      i = this.iuN * 1000;
    }
    AppMethodBeat.o(126188);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(126189);
    int i = 0;
    if (this.oNV != null) {
      i = Math.round(this.oNV.getCurrentPosition() * 1.0F / 1000.0F);
    }
    if (this.iuN > 0) {
      i = this.iuN;
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
    if (!bu.lX(this.iuG, paramString))
    {
      AppMethodBeat.o(126181);
      return;
    }
    ae.d("MicroMsg.TopStory.TopStoryVideoView", "%s download  onProgress [%d, %d]", new Object[] { bpA(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.iuP) && (this.iuK == 3)) {
      ql(getCurrPosSec());
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
    if ((bool2) && (this.iuK == 3)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ae.d("MicroMsg.TopStory.TopStoryVideoView", "%s result [%b] is playing[%b] playStatus[%d]", new Object[] { bpA(), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(this.iuK) });
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
        g.ajS();
        g.ajR().ajA().set(am.a.ISo, Boolean.TRUE);
        if ((this.oNV instanceof TopStoryVideoPlayTextureView)) {
          ((TopStoryVideoPlayTextureView)this.oNV).setNeedResetExtractor(true);
        }
        com.tencent.mm.plugin.websearch.api.a.b.md(com.tencent.mm.plugin.websearch.api.a.b.sBU);
        AppMethodBeat.o(126191);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", localException, "%s onError [%s]", new Object[] { bpA(), localException.toString() });
        }
      }
      com.tencent.mm.plugin.websearch.api.a.b.md(com.tencent.mm.plugin.websearch.api.a.b.sBT);
      AppMethodBeat.o(126191);
      return;
      com.tencent.mm.plugin.websearch.api.a.b.md(com.tencent.mm.plugin.websearch.api.a.b.sBV);
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126185);
    super.onUIDestroy();
    this.BLm = null;
    AppMethodBeat.o(126185);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(126193);
    ae.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIPause", new Object[] { bpA() });
    if (this.lxy)
    {
      this.lxJ = getCurrPosSec();
      this.lxK = isPlaying();
      this.lxQ = 0;
      this.lxP = 0L;
      pause();
      stopTimer();
      this.lxy = false;
      rd(getReportIdkey() + 11);
    }
    AppMethodBeat.o(126193);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(126192);
    ae.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIResume", new Object[] { bpA() });
    if (!this.lxy)
    {
      this.lxy = true;
      if (this.oNV != null)
      {
        if (!this.lxK) {
          break label75;
        }
        play();
      }
    }
    for (;;)
    {
      rd(getReportIdkey() + 10);
      AppMethodBeat.o(126192);
      return;
      label75:
      ((VideoPlayerTextureView)this.oNV).bpy();
    }
  }
  
  public final boolean qm(int paramInt)
  {
    AppMethodBeat.i(126180);
    if (this.iuJ == 3)
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
      if ((paramInt != 0) || (this.iuL == null) || (!cyZ())) {
        break label249;
      }
      localPInt4.value = 0;
      localPInt3.value = 0;
      bool1 = this.iuL.b(paramInt + 1, localPInt3, localPInt4);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          PInt localPInt4;
          this.iuQ = i;
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
        ae.e("MicroMsg.TopStory.TopStoryVideoView", "%s check video data error %s ", new Object[] { bpA(), localException1.toString() });
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
      if ((this.iuF != null) && (this.iuL != null) && (this.iuL.a(paramInt, i, localPInt1, localPInt2)))
      {
        bool1 = this.iuF.isVideoDataAvailable(this.iuG, localPInt1.value, localPInt2.value);
        bool2 = bool1;
        if (!bool1) {}
      }
    }
  }
  
  public final void setVideoInfo(dpa paramdpa)
  {
    AppMethodBeat.i(126178);
    super.c(false, paramdpa.videoUrl, 0);
    this.BIY = paramdpa;
    this.iuG = d.bt(paramdpa.udb, paramdpa.HWh);
    this.iuH = (this.BLm.etf() + this.iuG + ".mp4");
    AppMethodBeat.o(126178);
  }
  
  public final void start()
  {
    AppMethodBeat.i(126186);
    super.start();
    a.md(5);
    AppMethodBeat.o(126186);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(126196);
    super.stop();
    this.BIY = null;
    AppMethodBeat.o(126196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.q
 * JD-Core Version:    0.7.0.1
 */