package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.a.p;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class q
  extends MMVideoView
{
  String sessionId = "";
  private ddb yLU;
  private b yOm;
  
  public q(Context paramContext, b paramb)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.yOm = paramb;
  }
  
  private static boolean ckf()
  {
    AppMethodBeat.i(126177);
    try
    {
      g.afC();
      boolean bool = g.afB().afk().getBoolean(ae.a.FnJ, false);
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
    if (this.KCd != null)
    {
      int j = this.KCd.aGP();
      i = paramInt;
      if (paramInt > j)
      {
        i = paramInt;
        if (j > 0)
        {
          ad.i("MicroMsg.TopStory.TopStoryVideoView", "%s seek to reset time ori[%d] last key frame[%d]", new Object[] { bel(), Integer.valueOf(paramInt), Integer.valueOf(j) });
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
    paramPInt1.value = Math.max(paramInt, this.hxZ);
    boolean bool2;
    if ((this.hxT == 1) || (this.hxT == 0)) {
      if ((this.KCd != null) && (ckf()))
      {
        paramPInt2.value = 0;
        paramPInt1.value = 0;
        bool2 = this.KCd.b(paramInt + 1, paramPInt1, paramPInt2);
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
      if (this.hxT == 2)
      {
        if (this.KCd != null)
        {
          bool1 = this.KCd.b(paramInt, paramPInt1, paramPInt2);
          paramPInt2.value += 4;
        }
        bool2 = bool1;
        if (!bool1)
        {
          paramPInt1.value = (paramInt - 8);
          if (paramPInt1.value < 0) {
            paramPInt1.value = 0;
          }
          paramPInt2.value = (paramPInt1.value + this.hya + 8);
          bool2 = bool1;
        }
      }
      if ((this.hxT == 3) || (this.hxT == 4))
      {
        paramPInt1.value = this.hxZ;
        paramPInt2.value = (this.hxV + 1);
      }
      if (paramPInt2.value >= this.hxV + 1) {
        paramPInt2.value = (this.hxV + 1);
      }
      if (paramPInt2.value < paramPInt1.value)
      {
        paramPInt1.value += 2;
        AppMethodBeat.o(126183);
        return false;
      }
      ad.d("MicroMsg.TopStory.TopStoryVideoView", "%s calcDownloadRange2 range[%d, %d, %b] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { bel(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Boolean.valueOf(bool2), Integer.valueOf(paramInt), Integer.valueOf(this.hxT), Integer.valueOf(this.hxZ), Integer.valueOf(this.hya), this.hxP });
      AppMethodBeat.o(126183);
      return true;
      bool2 = false;
      break;
    }
  }
  
  public final void aCt()
  {
    this.hye.hyj = 4;
    this.hye.hyk = 2;
  }
  
  public final void am(String paramString, int paramInt)
  {
    AppMethodBeat.i(126190);
    super.am(paramString, paramInt);
    if ((paramInt != 0) && (this.nns != null)) {
      this.nns.c(getSessionId(), getMediaId(), "download error", paramInt, 0);
    }
    AppMethodBeat.o(126190);
  }
  
  public final void asJ(String paramString)
  {
    AppMethodBeat.i(126184);
    this.sessionId = paramString;
    start();
    AppMethodBeat.o(126184);
  }
  
  public final boolean cCw()
  {
    return false;
  }
  
  public final h cF(Context paramContext)
  {
    AppMethodBeat.i(126176);
    paramContext = new TopStoryVideoPlayTextureView(paramContext);
    paramContext.setOpenWithNoneSurface(true);
    paramContext.setNeedResetExtractor(ckf());
    paramContext.setIsOnlineVideoType(true);
    AppMethodBeat.o(126176);
    return paramContext;
  }
  
  public final boolean cMg()
  {
    return false;
  }
  
  public final void dPK()
  {
    AppMethodBeat.i(126194);
    ((TopStoryVideoPlayTextureView)this.nAZ).setAlpha(0.0F);
    AppMethodBeat.o(126194);
  }
  
  public final void dPL()
  {
    AppMethodBeat.i(126195);
    ((TopStoryVideoPlayTextureView)this.nAZ).setAlpha(1.0F);
    AppMethodBeat.o(126195);
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(126188);
    int i = 0;
    if (this.nAZ != null) {
      i = this.nAZ.getCurrentPosition();
    }
    if (this.hxW > 0) {
      i = this.hxW * 1000;
    }
    AppMethodBeat.o(126188);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(126189);
    int i = 0;
    if (this.nAZ != null) {
      i = Math.round(this.nAZ.getCurrentPosition() * 1.0F / 1000.0F);
    }
    if (this.hxW > 0) {
      i = this.hxW;
    }
    AppMethodBeat.o(126189);
    return i;
  }
  
  public final String getSessionId()
  {
    return this.sessionId;
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
    if ((bool2) && (this.hxT == 3)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.d("MicroMsg.TopStory.TopStoryVideoView", "%s result [%b] is playing[%b] playStatus[%d]", new Object[] { bel(), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(this.hxT) });
      AppMethodBeat.o(126187);
      return bool2;
    }
  }
  
  public final void k(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(126181);
    if (!bt.kU(this.hxP, paramString))
    {
      AppMethodBeat.o(126181);
      return;
    }
    ad.d("MicroMsg.TopStory.TopStoryVideoView", "%s download  onProgress [%d, %d]", new Object[] { bel(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.hxY) && (this.hxT == 3)) {
      oR(getCurrPosSec());
    }
    AppMethodBeat.o(126181);
  }
  
  public final boolean oS(int paramInt)
  {
    AppMethodBeat.i(126180);
    if (this.hxS == 3)
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
      if ((paramInt != 0) || (this.KCd == null) || (!ckf())) {
        break label249;
      }
      localPInt4.value = 0;
      localPInt3.value = 0;
      bool1 = this.KCd.b(paramInt + 1, localPInt3, localPInt4);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          PInt localPInt4;
          this.hxZ = i;
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
        ad.e("MicroMsg.TopStory.TopStoryVideoView", "%s check video data error %s ", new Object[] { bel(), localException1.toString() });
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
      if ((this.hxO != null) && (this.KCd != null) && (this.KCd.a(paramInt, i, localPInt1, localPInt2)))
      {
        bool1 = this.hxO.isVideoDataAvailable(this.hxP, localPInt1.value, localPInt2.value);
        bool2 = bool1;
        if (!bool1) {}
      }
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
        g.afC();
        g.afB().afk().set(ae.a.FnJ, Boolean.TRUE);
        if ((this.nAZ instanceof TopStoryVideoPlayTextureView)) {
          ((TopStoryVideoPlayTextureView)this.nAZ).setNeedResetExtractor(true);
        }
        com.tencent.mm.plugin.websearch.api.a.b.lI(com.tencent.mm.plugin.websearch.api.a.b.qHe);
        AppMethodBeat.o(126191);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", localException, "%s onError [%s]", new Object[] { bel(), localException.toString() });
        }
      }
      com.tencent.mm.plugin.websearch.api.a.b.lI(com.tencent.mm.plugin.websearch.api.a.b.qHd);
      AppMethodBeat.o(126191);
      return;
      com.tencent.mm.plugin.websearch.api.a.b.lI(com.tencent.mm.plugin.websearch.api.a.b.qHf);
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126185);
    super.onUIDestroy();
    this.yOm = null;
    AppMethodBeat.o(126185);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(126193);
    ad.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIPause", new Object[] { bel() });
    if (this.kuL)
    {
      this.kuX = getCurrPosSec();
      this.kuY = isPlaying();
      this.kve = 0;
      this.kvd = 0L;
      pause();
      stopTimer();
      this.kuL = false;
      ln(getReportIdkey() + 11);
    }
    AppMethodBeat.o(126193);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(126192);
    ad.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIResume", new Object[] { bel() });
    if (!this.kuL)
    {
      this.kuL = true;
      if (this.nAZ != null)
      {
        if (!this.kuY) {
          break label75;
        }
        play();
      }
    }
    for (;;)
    {
      ln(getReportIdkey() + 10);
      AppMethodBeat.o(126192);
      return;
      label75:
      ((VideoPlayerTextureView)this.nAZ).bej();
    }
  }
  
  public final void setVideoInfo(ddb paramddb)
  {
    AppMethodBeat.i(126178);
    super.c(false, paramddb.videoUrl, 0);
    this.yLU = paramddb;
    this.hxP = d.bn(paramddb.rNP, paramddb.EuN);
    this.hxQ = (this.yOm.dOG() + this.hxP + ".mp4");
    AppMethodBeat.o(126178);
  }
  
  public final void start()
  {
    AppMethodBeat.i(126186);
    super.start();
    a.lI(5);
    AppMethodBeat.o(126186);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(126196);
    super.stop();
    this.yLU = null;
    AppMethodBeat.o(126196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.q
 * JD-Core Version:    0.7.0.1
 */