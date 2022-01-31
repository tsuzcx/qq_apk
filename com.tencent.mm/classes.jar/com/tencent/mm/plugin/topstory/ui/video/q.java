package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class q
  extends MMVideoView
{
  private String bIB = "";
  private byg pDy;
  private b pEp;
  
  public q(Context paramContext, b paramb)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.pEp = paramb;
  }
  
  private static boolean bOq()
  {
    try
    {
      g.DQ();
      boolean bool = g.DP().Dz().getBoolean(ac.a.uuT, false);
      return bool;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", localException, "check need reset error", new Object[0]);
    }
    return false;
  }
  
  public final void PN(String paramString)
  {
    this.bIB = paramString;
    start();
  }
  
  protected final void Sc()
  {
    this.eFD.eFI = 4;
    this.eFD.eFJ = 2;
  }
  
  public final void Se()
  {
    y.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIPause", new Object[] { ayL() });
    if (this.rYz)
    {
      this.rYG = getCurrPosSec();
      this.rYH = isPlaying();
      this.rYN = 0;
      this.rYM = 0L;
      pause();
      stopTimer();
      this.rYz = false;
      cB(getReportIdkey() + 11);
    }
  }
  
  public final void Sf()
  {
    y.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIResume", new Object[] { ayL() });
    if (!this.rYz)
    {
      this.rYz = true;
      if (this.iuC != null)
      {
        if (!this.rYH) {
          break label62;
        }
        play();
      }
    }
    for (;;)
    {
      cB(getReportIdkey() + 10);
      return;
      label62:
      ((VideoPlayerTextureView)this.iuC).biz();
    }
  }
  
  public final void V(String paramString, int paramInt)
  {
    super.V(paramString, paramInt);
    if ((paramInt != 0) && (this.oIn != null)) {
      this.oIn.c(getSessionId(), getMediaId(), "download error", paramInt, 0);
    }
  }
  
  protected final boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    paramPInt1.value = Math.max(paramInt, this.eFy);
    boolean bool2;
    if ((this.eFs == 1) || (this.eFs == 0)) {
      if ((this.eFt != null) && (bOq()))
      {
        paramPInt2.value = 0;
        paramPInt1.value = 0;
        bool2 = this.eFt.b(paramInt + 1, paramPInt1, paramPInt2);
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
      if (this.eFs == 2)
      {
        if (this.eFt != null)
        {
          bool1 = this.eFt.b(paramInt, paramPInt1, paramPInt2);
          paramPInt2.value += 4;
        }
        bool2 = bool1;
        if (!bool1)
        {
          paramPInt1.value = (paramInt - 8);
          if (paramPInt1.value < 0) {
            paramPInt1.value = 0;
          }
          paramPInt2.value = (paramPInt1.value + this.eFz + 8);
          bool2 = bool1;
        }
      }
      if ((this.eFs == 3) || (this.eFs == 4))
      {
        paramPInt1.value = this.eFy;
        paramPInt2.value = (this.eFu + 1);
      }
      if (paramPInt2.value >= this.eFu + 1) {
        paramPInt2.value = (this.eFu + 1);
      }
      if (paramPInt2.value < paramPInt1.value)
      {
        paramPInt1.value += 2;
        return false;
      }
      y.d("MicroMsg.TopStory.TopStoryVideoView", "%s calcDownloadRange2 range[%d, %d, %b] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { ayL(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Boolean.valueOf(bool2), Integer.valueOf(paramInt), Integer.valueOf(this.eFs), Integer.valueOf(this.eFy), Integer.valueOf(this.eFz), this.eFo });
      return true;
      bool2 = false;
      break;
    }
  }
  
  public final void akT()
  {
    super.akT();
    this.pEp = null;
  }
  
  protected final com.tencent.mm.pluginsdk.ui.tools.f bF(Context paramContext)
  {
    paramContext = new TopStoryVideoPlayTextureView(paramContext);
    paramContext.setOpenWithNoneSurface(true);
    paramContext.setNeedResetExtractor(bOq());
    paramContext.setIsOnlineVideoType(true);
    return paramContext;
  }
  
  protected final boolean bOr()
  {
    return false;
  }
  
  public final void bOs()
  {
    ((TopStoryVideoPlayTextureView)this.iuC).setAlpha(1.0F);
  }
  
  public final void e(String paramString, int paramInt1, int paramInt2)
  {
    if (!bk.isEqual(this.eFo, paramString)) {}
    do
    {
      return;
      y.d("MicroMsg.TopStory.TopStoryVideoView", "%s download  onProgress [%d, %d]", new Object[] { ayL(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    } while ((!this.eFx) || (this.eFs != 3));
    jr(getCurrPosSec());
  }
  
  public final int getCurrPosMs()
  {
    int i = 0;
    if (this.iuC != null) {
      i = this.iuC.getCurrentPosition();
    }
    if (this.eFv > 0) {
      i = this.eFv * 1000;
    }
    return i;
  }
  
  public final int getCurrPosSec()
  {
    int i = 0;
    if (this.iuC != null) {
      i = Math.round(this.iuC.getCurrentPosition() * 1.0F / 1000.0F);
    }
    if (this.eFv > 0) {
      i = this.eFv;
    }
    return i;
  }
  
  public final String getSessionId()
  {
    return this.bIB;
  }
  
  protected final void initView()
  {
    super.initView();
  }
  
  public final boolean isPlaying()
  {
    boolean bool2 = super.isPlaying();
    if ((bool2) && (this.eFs == 3)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      y.d("MicroMsg.TopStory.TopStoryVideoView", "%s result [%b] is playing[%b] playStatus[%d]", new Object[] { ayL(), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(this.eFs) });
      return bool2;
    }
  }
  
  public final boolean js(int paramInt)
  {
    boolean bool2;
    if (this.eFr == 3)
    {
      bool2 = true;
      return bool2;
    }
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    for (;;)
    {
      try
      {
        PInt localPInt3 = new PInt();
        PInt localPInt4 = new PInt();
        if ((paramInt != 0) || (this.eFt == null) || (!bOq())) {
          break label219;
        }
        localPInt4.value = 0;
        localPInt3.value = 0;
        bool1 = this.eFt.b(paramInt + 1, localPInt3, localPInt4);
        if (!bool1) {
          break label212;
        }
        i = localPInt4.value;
        if ((this.eFn == null) || (this.eFt == null) || (!this.eFt.a(paramInt, i, localPInt1, localPInt2))) {
          break label210;
        }
        bool1 = this.eFn.isVideoDataAvailable(this.eFo, localPInt1.value, localPInt2.value);
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        try
        {
          this.eFy = i;
          return bool1;
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        bool1 = false;
        continue;
      }
      y.e("MicroMsg.TopStory.TopStoryVideoView", "%s check video data error %s ", new Object[] { ayL(), localException1.toString() });
      return bool1;
      label210:
      return false;
      label212:
      int i = paramInt + 1;
      continue;
      label219:
      boolean bool1 = false;
    }
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    super.onError(paramInt1, paramInt2);
    switch (paramInt2)
    {
    default: 
      return;
    case -2: 
      try
      {
        g.DQ();
        g.DP().Dz().c(ac.a.uuT, Boolean.valueOf(true));
        if ((this.iuC instanceof TopStoryVideoPlayTextureView)) {
          ((TopStoryVideoPlayTextureView)this.iuC).setNeedResetExtractor(true);
        }
        com.tencent.mm.plugin.websearch.api.a.b.jdMethod_if(com.tencent.mm.plugin.websearch.api.a.b.qVH);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", localException, "%s onError [%s]", new Object[] { ayL(), localException.toString() });
        }
      }
    case -1: 
      com.tencent.mm.plugin.websearch.api.a.b.jdMethod_if(com.tencent.mm.plugin.websearch.api.a.b.qVG);
      return;
    }
    com.tencent.mm.plugin.websearch.api.a.b.jdMethod_if(com.tencent.mm.plugin.websearch.api.a.b.qVI);
  }
  
  public final void setVideoInfo(byg parambyg)
  {
    super.c(false, parambyg.videoUrl, parambyg.tOw);
    this.pDy = parambyg;
    this.eFo = d.an(parambyg.tOx, parambyg.tOy);
    this.eFp = (this.pEp.bNu() + this.eFo + ".mp4");
  }
  
  public final void start()
  {
    super.start();
    a.jdMethod_if(5);
  }
  
  public final void stop()
  {
    super.stop();
    this.pDy = null;
  }
  
  public final boolean y(int paramInt, boolean paramBoolean)
  {
    int i = paramInt;
    if (this.eFt != null)
    {
      int j = this.eFt.Vf();
      i = paramInt;
      if (paramInt > j)
      {
        i = paramInt;
        if (j > 0)
        {
          y.i("MicroMsg.TopStory.TopStoryVideoView", "%s seek to reset time ori[%d] last key frame[%d]", new Object[] { ayL(), Integer.valueOf(paramInt), Integer.valueOf(j) });
          i = j;
        }
      }
    }
    return super.y(i, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.q
 * JD-Core Version:    0.7.0.1
 */