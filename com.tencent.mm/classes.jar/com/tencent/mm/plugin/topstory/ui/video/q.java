package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.topstory.ui.c;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class q
  extends MMVideoView
{
  private eiw GjH;
  private b GlS;
  String sessionId = "";
  
  public q(Context paramContext, b paramb)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.GlS = paramb;
  }
  
  private static boolean cXc()
  {
    AppMethodBeat.i(126177);
    try
    {
      g.aAi();
      boolean bool = g.aAh().azQ().getBoolean(ar.a.Oaq, false);
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
  
  public final boolean G(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(164125);
    int i = paramInt;
    if (this.jpX != null)
    {
      int j = this.jpX.blR();
      i = paramInt;
      if (paramInt > j)
      {
        i = paramInt;
        if (j > 0)
        {
          Log.i("MicroMsg.TopStory.TopStoryVideoView", "%s seek to reset time ori[%d] last key frame[%d]", new Object[] { bgQ(), Integer.valueOf(paramInt), Integer.valueOf(j) });
          i = j;
        }
      }
    }
    paramBoolean = super.G(i, paramBoolean);
    AppMethodBeat.o(164125);
    return paramBoolean;
  }
  
  public final boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(126183);
    paramPInt1.value = Math.max(paramInt, this.jqc);
    boolean bool2;
    if ((this.jpW == 1) || (this.jpW == 0)) {
      if ((this.jpX != null) && (cXc()))
      {
        paramPInt2.value = 0;
        paramPInt1.value = 0;
        bool2 = this.jpX.b(paramInt + 1, paramPInt1, paramPInt2);
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
      if (this.jpW == 2)
      {
        if (this.jpX != null)
        {
          bool1 = this.jpX.b(paramInt, paramPInt1, paramPInt2);
          paramPInt2.value += 4;
        }
        bool2 = bool1;
        if (!bool1)
        {
          paramPInt1.value = (paramInt - 8);
          if (paramPInt1.value < 0) {
            paramPInt1.value = 0;
          }
          paramPInt2.value = (paramPInt1.value + this.jqd + 8);
          bool2 = bool1;
        }
      }
      if ((this.jpW == 3) || (this.jpW == 4))
      {
        paramPInt1.value = this.jqc;
        paramPInt2.value = (this.jpY + 1);
      }
      if (paramPInt2.value >= this.jpY + 1) {
        paramPInt2.value = (this.jpY + 1);
      }
      if (paramPInt2.value < paramPInt1.value)
      {
        paramPInt1.value += 2;
        AppMethodBeat.o(126183);
        return false;
      }
      Log.d("MicroMsg.TopStory.TopStoryVideoView", "%s calcDownloadRange2 range[%d, %d, %b] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { bgQ(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Boolean.valueOf(bool2), Integer.valueOf(paramInt), Integer.valueOf(this.jpW), Integer.valueOf(this.jqc), Integer.valueOf(this.jqd), this.jpT });
      AppMethodBeat.o(126183);
      return true;
      bool2 = false;
      break;
    }
  }
  
  public final void aTG(String paramString)
  {
    AppMethodBeat.i(126184);
    this.sessionId = paramString;
    start();
    AppMethodBeat.o(126184);
  }
  
  public final void ax(String paramString, int paramInt)
  {
    AppMethodBeat.i(126190);
    super.ax(paramString, paramInt);
    if ((paramInt != 0) && (this.pNj != null)) {
      this.pNj.c(getSessionId(), getMediaId(), "download error", paramInt, 0);
    }
    AppMethodBeat.o(126190);
  }
  
  public final void bgU()
  {
    this.jqh.jqm = 4;
    this.jqh.jqn = 2;
  }
  
  public final boolean dUD()
  {
    return false;
  }
  
  public final j di(Context paramContext)
  {
    AppMethodBeat.i(126176);
    paramContext = new TopStoryVideoPlayTextureView(paramContext);
    paramContext.setOpenWithNoneSurface(true);
    paramContext.setNeedResetExtractor(cXc());
    paramContext.setIsOnlineVideoType(true);
    AppMethodBeat.o(126176);
    return paramContext;
  }
  
  public final boolean efT()
  {
    return false;
  }
  
  public final void fzD()
  {
    AppMethodBeat.i(126194);
    ((TopStoryVideoPlayTextureView)this.qbJ).setAlpha(0.0F);
    AppMethodBeat.o(126194);
  }
  
  public final void fzE()
  {
    AppMethodBeat.i(126195);
    ((TopStoryVideoPlayTextureView)this.qbJ).setAlpha(1.0F);
    AppMethodBeat.o(126195);
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(126188);
    int i = 0;
    if (this.qbJ != null) {
      i = this.qbJ.getCurrentPosition();
    }
    if (this.jpZ > 0) {
      i = this.jpZ * 1000;
    }
    AppMethodBeat.o(126188);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(126189);
    int i = 0;
    if (this.qbJ != null) {
      i = Math.round(this.qbJ.getCurrentPosition() * 1.0F / 1000.0F);
    }
    if (this.jpZ > 0) {
      i = this.jpZ;
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
    if (!Util.isEqual(this.jpT, paramString))
    {
      AppMethodBeat.o(126181);
      return;
    }
    Log.d("MicroMsg.TopStory.TopStoryVideoView", "%s download  onProgress [%d, %d]", new Object[] { bgQ(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.jqb) && (this.jpW == 3)) {
      ub(getCurrPosSec());
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
    if ((bool2) && (this.jpW == 3)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.d("MicroMsg.TopStory.TopStoryVideoView", "%s result [%b] is playing[%b] playStatus[%d]", new Object[] { bgQ(), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(this.jpW) });
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
        g.aAi();
        g.aAh().azQ().set(ar.a.Oaq, Boolean.TRUE);
        if ((this.qbJ instanceof TopStoryVideoPlayTextureView)) {
          ((TopStoryVideoPlayTextureView)this.qbJ).setNeedResetExtractor(true);
        }
        com.tencent.mm.plugin.websearch.api.a.b.pl(com.tencent.mm.plugin.websearch.api.a.b.vhO);
        AppMethodBeat.o(126191);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", localException, "%s onError [%s]", new Object[] { bgQ(), localException.toString() });
        }
      }
      com.tencent.mm.plugin.websearch.api.a.b.pl(com.tencent.mm.plugin.websearch.api.a.b.vhN);
      AppMethodBeat.o(126191);
      return;
      com.tencent.mm.plugin.websearch.api.a.b.pl(com.tencent.mm.plugin.websearch.api.a.b.vhP);
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126185);
    super.onUIDestroy();
    this.GlS = null;
    AppMethodBeat.o(126185);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(126193);
    Log.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIPause", new Object[] { bgQ() });
    if (this.mEw)
    {
      this.mEH = getCurrPosSec();
      this.mEI = isPlaying();
      this.mEO = 0;
      this.mEN = 0L;
      pause();
      stopTimer();
      this.mEw = false;
      yU(getReportIdkey() + 11);
    }
    AppMethodBeat.o(126193);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(126192);
    Log.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIResume", new Object[] { bgQ() });
    if (!this.mEw)
    {
      this.mEw = true;
      if (this.qbJ != null)
      {
        if (!this.mEI) {
          break label75;
        }
        play();
      }
    }
    for (;;)
    {
      yU(getReportIdkey() + 10);
      AppMethodBeat.o(126192);
      return;
      label75:
      ((VideoPlayerTextureView)this.qbJ).bLe();
    }
  }
  
  public final void setVideoInfo(eiw parameiw)
  {
    AppMethodBeat.i(126178);
    super.c(false, parameiw.videoUrl, 0);
    this.GjH = parameiw;
    this.jpT = c.bu(parameiw.psI, parameiw.Nip);
    this.jpU = (this.GlS.fyC() + this.jpT + ".mp4");
    AppMethodBeat.o(126178);
  }
  
  public final void start()
  {
    AppMethodBeat.i(126186);
    super.start();
    a.pl(5);
    AppMethodBeat.o(126186);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(126196);
    super.stop();
    this.GjH = null;
    AppMethodBeat.o(126196);
  }
  
  public final boolean uc(int paramInt)
  {
    AppMethodBeat.i(126180);
    if (this.jpV == 3)
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
      if ((paramInt != 0) || (this.jpX == null) || (!cXc())) {
        break label249;
      }
      localPInt4.value = 0;
      localPInt3.value = 0;
      bool1 = this.jpX.b(paramInt + 1, localPInt3, localPInt4);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          PInt localPInt4;
          this.jqc = i;
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
        Log.e("MicroMsg.TopStory.TopStoryVideoView", "%s check video data error %s ", new Object[] { bgQ(), localException1.toString() });
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
      if ((this.jpS != null) && (this.jpX != null) && (this.jpX.a(paramInt, i, localPInt1, localPInt2)))
      {
        bool1 = this.jpS.isVideoDataAvailable(this.jpT, localPInt1.value, localPInt2.value);
        bool2 = bool1;
        if (!bool1) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.q
 * JD-Core Version:    0.7.0.1
 */