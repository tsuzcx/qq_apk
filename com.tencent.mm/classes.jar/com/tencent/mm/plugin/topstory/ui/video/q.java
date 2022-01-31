package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class q
  extends MMVideoView
{
  String cpW = "";
  private ckx tfm;
  private b thM;
  
  public q(Context paramContext, b paramb)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.thM = paramb;
  }
  
  private static boolean byv()
  {
    AppMethodBeat.i(1803);
    try
    {
      g.RM();
      boolean bool = g.RL().Ru().getBoolean(ac.a.yFa, false);
      AppMethodBeat.o(1803);
      return bool;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", localException, "check need reset error", new Object[0]);
      AppMethodBeat.o(1803);
    }
    return false;
  }
  
  public final boolean GK(int paramInt)
  {
    AppMethodBeat.i(141934);
    int i = paramInt;
    if (this.fVk != null)
    {
      int j = this.fVk.aoD();
      i = paramInt;
      if (paramInt > j)
      {
        i = paramInt;
        if (j > 0)
        {
          ab.i("MicroMsg.TopStory.TopStoryVideoView", "%s seek to reset time ori[%d] last key frame[%d]", new Object[] { bas(), Integer.valueOf(paramInt), Integer.valueOf(j) });
          i = j;
        }
      }
    }
    boolean bool = super.d(i, true);
    AppMethodBeat.o(141934);
    return bool;
  }
  
  public final boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(1809);
    paramPInt1.value = Math.max(paramInt, this.fVp);
    boolean bool2;
    if ((this.fVj == 1) || (this.fVj == 0)) {
      if ((this.fVk != null) && (byv()))
      {
        paramPInt2.value = 0;
        paramPInt1.value = 0;
        bool2 = this.fVk.b(paramInt + 1, paramPInt1, paramPInt2);
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
      if (this.fVj == 2)
      {
        if (this.fVk != null)
        {
          bool1 = this.fVk.b(paramInt, paramPInt1, paramPInt2);
          paramPInt2.value += 4;
        }
        bool2 = bool1;
        if (!bool1)
        {
          paramPInt1.value = (paramInt - 8);
          if (paramPInt1.value < 0) {
            paramPInt1.value = 0;
          }
          paramPInt2.value = (paramPInt1.value + this.fVq + 8);
          bool2 = bool1;
        }
      }
      if ((this.fVj == 3) || (this.fVj == 4))
      {
        paramPInt1.value = this.fVp;
        paramPInt2.value = (this.fVl + 1);
      }
      if (paramPInt2.value >= this.fVl + 1) {
        paramPInt2.value = (this.fVl + 1);
      }
      if (paramPInt2.value < paramPInt1.value)
      {
        paramPInt1.value += 2;
        AppMethodBeat.o(1809);
        return false;
      }
      ab.d("MicroMsg.TopStory.TopStoryVideoView", "%s calcDownloadRange2 range[%d, %d, %b] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { bas(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Boolean.valueOf(bool2), Integer.valueOf(paramInt), Integer.valueOf(this.fVj), Integer.valueOf(this.fVp), Integer.valueOf(this.fVq), this.fVf });
      AppMethodBeat.o(1809);
      return true;
      bool2 = false;
      break;
    }
  }
  
  public final void aEM()
  {
    AppMethodBeat.i(1811);
    super.aEM();
    this.thM = null;
    AppMethodBeat.o(1811);
  }
  
  public final void ad(String paramString, int paramInt)
  {
    AppMethodBeat.i(1816);
    super.ad(paramString, paramInt);
    if ((paramInt != 0) && (this.ryi != null)) {
      this.ryi.c(getSessionId(), getMediaId(), "download error", paramInt, 0);
    }
    AppMethodBeat.o(1816);
  }
  
  public final void aep(String paramString)
  {
    AppMethodBeat.i(1810);
    this.cpW = paramString;
    start();
    AppMethodBeat.o(1810);
  }
  
  public final void alm()
  {
    this.fVu.fVz = 4;
    this.fVu.fVA = 2;
  }
  
  public final void alo()
  {
    AppMethodBeat.i(1819);
    ab.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIPause", new Object[] { bas() });
    if (this.vPo)
    {
      this.vPv = getCurrPosSec();
      this.vPw = isPlaying();
      this.vPC = 0;
      this.vPB = 0L;
      pause();
      stopTimer();
      this.vPo = false;
      hB(getReportIdkey() + 11);
    }
    AppMethodBeat.o(1819);
  }
  
  public final void alp()
  {
    AppMethodBeat.i(1818);
    ab.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIResume", new Object[] { bas() });
    if (!this.vPo)
    {
      this.vPo = true;
      if (this.kvG != null)
      {
        if (!this.vPw) {
          break label74;
        }
        play();
      }
    }
    for (;;)
    {
      hB(getReportIdkey() + 10);
      AppMethodBeat.o(1818);
      return;
      label74:
      ((VideoPlayerTextureView)this.kvG).bQB();
    }
  }
  
  public final boolean cKe()
  {
    return false;
  }
  
  public final void cKf()
  {
    AppMethodBeat.i(1820);
    ((TopStoryVideoPlayTextureView)this.kvG).setAlpha(0.0F);
    AppMethodBeat.o(1820);
  }
  
  public final void cKg()
  {
    AppMethodBeat.i(1821);
    ((TopStoryVideoPlayTextureView)this.kvG).setAlpha(1.0F);
    AppMethodBeat.o(1821);
  }
  
  public final com.tencent.mm.pluginsdk.ui.tools.e ck(Context paramContext)
  {
    AppMethodBeat.i(1802);
    paramContext = new TopStoryVideoPlayTextureView(paramContext);
    paramContext.setOpenWithNoneSurface(true);
    paramContext.setNeedResetExtractor(byv());
    paramContext.setIsOnlineVideoType(true);
    AppMethodBeat.o(1802);
    return paramContext;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(1814);
    int i = 0;
    if (this.kvG != null) {
      i = this.kvG.getCurrentPosition();
    }
    if (this.fVm > 0) {
      i = this.fVm * 1000;
    }
    AppMethodBeat.o(1814);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(1815);
    int i = 0;
    if (this.kvG != null) {
      i = Math.round(this.kvG.getCurrentPosition() * 1.0F / 1000.0F);
    }
    if (this.fVm > 0) {
      i = this.fVm;
    }
    AppMethodBeat.o(1815);
    return i;
  }
  
  public final String getSessionId()
  {
    return this.cpW;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(1805);
    super.initView();
    AppMethodBeat.o(1805);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(1813);
    boolean bool2 = super.isPlaying();
    if ((bool2) && (this.fVj == 3)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ab.d("MicroMsg.TopStory.TopStoryVideoView", "%s result [%b] is playing[%b] playStatus[%d]", new Object[] { bas(), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(this.fVj) });
      AppMethodBeat.o(1813);
      return bool2;
    }
  }
  
  public final boolean mk(int paramInt)
  {
    AppMethodBeat.i(1806);
    if (this.fVi == 3)
    {
      AppMethodBeat.o(1806);
      return true;
    }
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      PInt localPInt3 = new PInt();
      localPInt4 = new PInt();
      if ((paramInt != 0) || (this.fVk == null) || (!byv())) {
        break label245;
      }
      localPInt4.value = 0;
      localPInt3.value = 0;
      bool1 = this.fVk.b(paramInt + 1, localPInt3, localPInt4);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          PInt localPInt4;
          this.fVp = i;
          bool2 = bool1;
          AppMethodBeat.o(1806);
          return bool2;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localException1 = localException1;
        boolean bool1 = false;
        ab.e("MicroMsg.TopStory.TopStoryVideoView", "%s check video data error %s ", new Object[] { bas(), localException1.toString() });
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
      if ((this.fVe != null) && (this.fVk != null) && (this.fVk.a(paramInt, i, localPInt1, localPInt2)))
      {
        bool1 = this.fVe.isVideoDataAvailable(this.fVf, localPInt1.value, localPInt2.value);
        bool2 = bool1;
        if (!bool1) {}
      }
    }
  }
  
  public final void n(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(1807);
    if (!bo.isEqual(this.fVf, paramString))
    {
      AppMethodBeat.o(1807);
      return;
    }
    ab.d("MicroMsg.TopStory.TopStoryVideoView", "%s download  onProgress [%d, %d]", new Object[] { bas(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((this.fVo) && (this.fVj == 3)) {
      mj(getCurrPosSec());
    }
    AppMethodBeat.o(1807);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(1817);
    super.onError(paramInt1, paramInt2);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(1817);
      return;
      try
      {
        g.RM();
        g.RL().Ru().set(ac.a.yFa, Boolean.TRUE);
        if ((this.kvG instanceof TopStoryVideoPlayTextureView)) {
          ((TopStoryVideoPlayTextureView)this.kvG).setNeedResetExtractor(true);
        }
        com.tencent.mm.plugin.websearch.api.a.b.kS(com.tencent.mm.plugin.websearch.api.a.b.uKS);
        AppMethodBeat.o(1817);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", localException, "%s onError [%s]", new Object[] { bas(), localException.toString() });
        }
      }
      com.tencent.mm.plugin.websearch.api.a.b.kS(com.tencent.mm.plugin.websearch.api.a.b.uKR);
      AppMethodBeat.o(1817);
      return;
      com.tencent.mm.plugin.websearch.api.a.b.kS(com.tencent.mm.plugin.websearch.api.a.b.uKT);
    }
  }
  
  public final void setVideoInfo(ckx paramckx)
  {
    AppMethodBeat.i(1804);
    super.c(false, paramckx.videoUrl, 0);
    this.tfm = paramckx;
    this.fVf = d.aK(paramckx.xVa, paramckx.xVb);
    this.fVg = (this.thM.cJe() + this.fVf + ".mp4");
    AppMethodBeat.o(1804);
  }
  
  public final void start()
  {
    AppMethodBeat.i(1812);
    super.start();
    a.kS(5);
    AppMethodBeat.o(1812);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(1822);
    super.stop();
    this.tfm = null;
    AppMethodBeat.o(1822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.q
 * JD-Core Version:    0.7.0.1
 */