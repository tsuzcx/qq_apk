package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class q
  extends MMVideoView
{
  private esy MWs;
  private b MYE;
  String sessionId = "";
  
  public q(Context paramContext, b paramb)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.MYE = paramb;
  }
  
  private static boolean dmk()
  {
    AppMethodBeat.i(126177);
    try
    {
      h.aHH();
      boolean bool = h.aHG().aHp().getBoolean(ar.a.Vos, false);
      AppMethodBeat.o(126177);
      return bool;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", localException, "check need reset error", new Object[0]);
      AppMethodBeat.o(126177);
    }
    return false;
  }
  
  public final boolean I(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(164125);
    int i = paramInt;
    if (this.mfy != null)
    {
      int j = this.mfy.bvH();
      i = paramInt;
      if (paramInt > j)
      {
        i = paramInt;
        if (j > 0)
        {
          Log.i("MicroMsg.TopStory.TopStoryVideoView", "%s seek to reset time ori[%d] last key frame[%d]", new Object[] { bqf(), Integer.valueOf(paramInt), Integer.valueOf(j) });
          i = j;
        }
      }
    }
    paramBoolean = super.I(i, paramBoolean);
    AppMethodBeat.o(164125);
    return paramBoolean;
  }
  
  public final boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(126183);
    paramPInt1.value = Math.max(paramInt, this.mfD);
    boolean bool2;
    if ((this.mfx == 1) || (this.mfx == 0)) {
      if ((this.mfy != null) && (dmk()))
      {
        paramPInt2.value = 0;
        paramPInt1.value = 0;
        bool2 = this.mfy.b(paramInt + 1, paramPInt1, paramPInt2);
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
      if (this.mfx == 2)
      {
        if (this.mfy != null)
        {
          bool1 = this.mfy.b(paramInt, paramPInt1, paramPInt2);
          paramPInt2.value += 4;
        }
        bool2 = bool1;
        if (!bool1)
        {
          paramPInt1.value = (paramInt - 8);
          if (paramPInt1.value < 0) {
            paramPInt1.value = 0;
          }
          paramPInt2.value = (paramPInt1.value + this.mfE + 8);
          bool2 = bool1;
        }
      }
      if ((this.mfx == 3) || (this.mfx == 4))
      {
        paramPInt1.value = this.mfD;
        paramPInt2.value = (this.mfz + 1);
      }
      if (paramPInt2.value >= this.mfz + 1) {
        paramPInt2.value = (this.mfz + 1);
      }
      if (paramPInt2.value < paramPInt1.value)
      {
        paramPInt1.value += 2;
        AppMethodBeat.o(126183);
        return false;
      }
      Log.d("MicroMsg.TopStory.TopStoryVideoView", "%s calcDownloadRange2 range[%d, %d, %b] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { bqf(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Boolean.valueOf(bool2), Integer.valueOf(paramInt), Integer.valueOf(this.mfx), Integer.valueOf(this.mfD), Integer.valueOf(this.mfE), this.mfu });
      AppMethodBeat.o(126183);
      return true;
      bool2 = false;
      break;
    }
  }
  
  public final void aP(String paramString, int paramInt)
  {
    AppMethodBeat.i(126190);
    super.aP(paramString, paramInt);
    if ((paramInt != 0) && (this.sUh != null)) {
      this.sUh.c(getSessionId(), getMediaId(), "download error", paramInt, 0);
    }
    AppMethodBeat.o(126190);
  }
  
  public final void bfe(String paramString)
  {
    AppMethodBeat.i(126184);
    this.sessionId = paramString;
    start();
    AppMethodBeat.o(126184);
  }
  
  public final void bql()
  {
    this.mfI.mfN = 4;
    this.mfI.mfO = 2;
  }
  
  public final k df(Context paramContext)
  {
    AppMethodBeat.i(126176);
    paramContext = new TopStoryVideoPlayTextureView(paramContext);
    paramContext.setOpenWithNoneSurface(true);
    paramContext.setNeedResetExtractor(dmk());
    paramContext.setIsOnlineVideoType(true);
    AppMethodBeat.o(126176);
    return paramContext;
  }
  
  public final boolean ePu()
  {
    return false;
  }
  
  public final boolean exK()
  {
    return false;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(126188);
    int i = 0;
    if (this.txH != null) {
      i = this.txH.getCurrentPosition();
    }
    if (this.mfA > 0) {
      i = this.mfA * 1000;
    }
    AppMethodBeat.o(126188);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(126189);
    int i = 0;
    if (this.txH != null) {
      i = Math.round(this.txH.getCurrentPosition() * 1.0F / 1000.0F);
    }
    if (this.mfA > 0) {
      i = this.mfA;
    }
    AppMethodBeat.o(126189);
    return i;
  }
  
  public final String getSessionId()
  {
    return this.sessionId;
  }
  
  public final void grE()
  {
    AppMethodBeat.i(126194);
    ((TopStoryVideoPlayTextureView)this.txH).setAlpha(0.0F);
    AppMethodBeat.o(126194);
  }
  
  public final void grF()
  {
    AppMethodBeat.i(126195);
    ((TopStoryVideoPlayTextureView)this.txH).setAlpha(1.0F);
    AppMethodBeat.o(126195);
  }
  
  public final void h(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(126181);
    if (!Util.isEqual(this.mfu, paramString))
    {
      AppMethodBeat.o(126181);
      return;
    }
    Log.d("MicroMsg.TopStory.TopStoryVideoView", "%s download  onProgress [%d, %d]", new Object[] { bqf(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.mfC) && (this.mfx == 3)) {
      xa(getCurrPosSec());
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
    if ((bool2) && (this.mfx == 3)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.d("MicroMsg.TopStory.TopStoryVideoView", "%s result [%b] is playing[%b] playStatus[%d]", new Object[] { bqf(), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(this.mfx) });
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
        h.aHH();
        h.aHG().aHp().set(ar.a.Vos, Boolean.TRUE);
        if ((this.txH instanceof TopStoryVideoPlayTextureView)) {
          ((TopStoryVideoPlayTextureView)this.txH).setNeedResetExtractor(true);
        }
        com.tencent.mm.plugin.websearch.api.a.b.rE(com.tencent.mm.plugin.websearch.api.a.b.zYX);
        AppMethodBeat.o(126191);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", localException, "%s onError [%s]", new Object[] { bqf(), localException.toString() });
        }
      }
      com.tencent.mm.plugin.websearch.api.a.b.rE(com.tencent.mm.plugin.websearch.api.a.b.zYW);
      AppMethodBeat.o(126191);
      return;
      com.tencent.mm.plugin.websearch.api.a.b.rE(com.tencent.mm.plugin.websearch.api.a.b.zYY);
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126185);
    super.onUIDestroy();
    this.MYE = null;
    AppMethodBeat.o(126185);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(126193);
    Log.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIPause", new Object[] { bqf() });
    if (this.pDI)
    {
      this.pDT = getCurrPosSec();
      this.pDU = isPlaying();
      this.pEa = 0;
      this.pDZ = 0L;
      pause();
      stopTimer();
      this.pDI = false;
      EW(getReportIdkey() + 11);
    }
    AppMethodBeat.o(126193);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(126192);
    Log.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIResume", new Object[] { bqf() });
    if (!this.pDI)
    {
      this.pDI = true;
      if (this.txH != null)
      {
        if (!this.pDU) {
          break label75;
        }
        bqo();
      }
    }
    for (;;)
    {
      EW(getReportIdkey() + 10);
      AppMethodBeat.o(126192);
      return;
      label75:
      ((VideoPlayerTextureView)this.txH).bXe();
    }
  }
  
  public final void setVideoInfo(esy paramesy)
  {
    AppMethodBeat.i(126178);
    super.c(false, paramesy.videoUrl, 0);
    this.MWs = paramesy;
    this.mfu = d.bz(paramesy.Crh, paramesy.UuV);
    this.mfv = (this.MYE.gqz() + this.mfu + ".mp4");
    AppMethodBeat.o(126178);
  }
  
  public final void start()
  {
    AppMethodBeat.i(126186);
    super.start();
    a.rE(5);
    AppMethodBeat.o(126186);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(126196);
    super.stop();
    this.MWs = null;
    AppMethodBeat.o(126196);
  }
  
  public final boolean xb(int paramInt)
  {
    AppMethodBeat.i(126180);
    if (this.mfw == 3)
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
      if ((paramInt != 0) || (this.mfy == null) || (!dmk())) {
        break label249;
      }
      localPInt4.value = 0;
      localPInt3.value = 0;
      bool1 = this.mfy.b(paramInt + 1, localPInt3, localPInt4);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          PInt localPInt4;
          this.mfD = i;
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
        Log.e("MicroMsg.TopStory.TopStoryVideoView", "%s check video data error %s ", new Object[] { bqf(), localException1.toString() });
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
      if ((this.mft != null) && (this.mfy != null) && (this.mfy.a(paramInt, i, localPInt1, localPInt2)))
      {
        bool1 = this.mft.isVideoDataAvailable(this.mfu, localPInt1.value, localPInt2.value);
        bool2 = bool1;
        if (!bool1) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.q
 * JD-Core Version:    0.7.0.1
 */