package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class q
  extends MMVideoView
{
  private foh TIW;
  private b TLn;
  String sessionId = "";
  
  public q(Context paramContext, b paramb)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.TLn = paramb;
  }
  
  private static boolean dTa()
  {
    AppMethodBeat.i(126177);
    try
    {
      h.baF();
      boolean bool = h.baE().ban().getBoolean(at.a.acPO, false);
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
  
  public final boolean X(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(164125);
    int i = paramInt;
    if (this.oYu != null)
    {
      int j = this.oYu.bTT();
      i = paramInt;
      if (paramInt > j)
      {
        i = paramInt;
        if (j > 0)
        {
          Log.i("MicroMsg.TopStory.TopStoryVideoView", "%s seek to reset time ori[%d] last key frame[%d]", new Object[] { bNL(), Integer.valueOf(paramInt), Integer.valueOf(j) });
          i = j;
        }
      }
    }
    paramBoolean = super.X(i, paramBoolean);
    AppMethodBeat.o(164125);
    return paramBoolean;
  }
  
  public final boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(126183);
    paramPInt1.value = Math.max(paramInt, this.oYz);
    boolean bool2;
    if ((this.oYt == 1) || (this.oYt == 0)) {
      if ((this.oYu != null) && (dTa()))
      {
        paramPInt2.value = 0;
        paramPInt1.value = 0;
        bool2 = this.oYu.b(paramInt + 1, paramPInt1, paramPInt2);
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
      if (this.oYt == 2)
      {
        if (this.oYu != null)
        {
          bool1 = this.oYu.b(paramInt, paramPInt1, paramPInt2);
          paramPInt2.value += 4;
        }
        bool2 = bool1;
        if (!bool1)
        {
          paramPInt1.value = (paramInt - 8);
          if (paramPInt1.value < 0) {
            paramPInt1.value = 0;
          }
          paramPInt2.value = (paramPInt1.value + this.oYA + 8);
          bool2 = bool1;
        }
      }
      if ((this.oYt == 3) || (this.oYt == 4))
      {
        paramPInt1.value = this.oYz;
        paramPInt2.value = (this.oYv + 1);
      }
      if (paramPInt2.value >= this.oYv + 1) {
        paramPInt2.value = (this.oYv + 1);
      }
      if (paramPInt2.value < paramPInt1.value)
      {
        paramPInt1.value += 2;
        AppMethodBeat.o(126183);
        return false;
      }
      Log.d("MicroMsg.TopStory.TopStoryVideoView", "%s calcDownloadRange2 range[%d, %d, %b] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { bNL(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Boolean.valueOf(bool2), Integer.valueOf(paramInt), Integer.valueOf(this.oYt), Integer.valueOf(this.oYz), Integer.valueOf(this.oYA), this.oYq });
      AppMethodBeat.o(126183);
      return true;
      bool2 = false;
      break;
    }
  }
  
  public final void bNR()
  {
    this.oYE.oYJ = 4;
    this.oYE.oYK = 2;
  }
  
  public final void bb(String paramString, int paramInt)
  {
    AppMethodBeat.i(126190);
    super.bb(paramString, paramInt);
    if ((paramInt != 0) && (this.vZv != null)) {
      this.vZv.d(getSessionId(), getMediaId(), "download error", paramInt, 0);
    }
    AppMethodBeat.o(126190);
  }
  
  public final void beB(String paramString)
  {
    AppMethodBeat.i(126184);
    this.sessionId = paramString;
    start();
    AppMethodBeat.o(126184);
  }
  
  public final boolean cxu()
  {
    return false;
  }
  
  public final i dY(Context paramContext)
  {
    AppMethodBeat.i(126176);
    paramContext = new TopStoryVideoPlayTextureView(paramContext);
    paramContext.setOpenWithNoneSurface(true);
    paramContext.setNeedResetExtractor(dTa());
    paramContext.setIsOnlineVideoType(true);
    AppMethodBeat.o(126176);
    return paramContext;
  }
  
  public final boolean fXY()
  {
    return false;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(126188);
    int i = 0;
    if (this.wCd != null) {
      i = this.wCd.getCurrentPosition();
    }
    if (this.oYw > 0) {
      i = this.oYw * 1000;
    }
    AppMethodBeat.o(126188);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(126189);
    int i = 0;
    if (this.wCd != null) {
      i = Math.round(this.wCd.getCurrentPosition() * 1.0F / 1000.0F);
    }
    if (this.oYw > 0) {
      i = this.oYw;
    }
    AppMethodBeat.o(126189);
    return i;
  }
  
  public final String getSessionId()
  {
    return this.sessionId;
  }
  
  public final void h(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(126181);
    if (!Util.isEqual(this.oYq, paramString))
    {
      AppMethodBeat.o(126181);
      return;
    }
    Log.d("MicroMsg.TopStory.TopStoryVideoView", "%s download  onProgress [%d, %d]", new Object[] { bNL(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.oYy) && (this.oYt == 3)) {
      xa(getCurrPosSec());
    }
    AppMethodBeat.o(126181);
  }
  
  public final void hOE()
  {
    AppMethodBeat.i(126194);
    ((TopStoryVideoPlayTextureView)this.wCd).setAlpha(0.0F);
    AppMethodBeat.o(126194);
  }
  
  public final void hOF()
  {
    AppMethodBeat.i(126195);
    ((TopStoryVideoPlayTextureView)this.wCd).setAlpha(1.0F);
    AppMethodBeat.o(126195);
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
    if ((bool2) && (this.oYt == 3)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.d("MicroMsg.TopStory.TopStoryVideoView", "%s result [%b] is playing[%b] playStatus[%d]", new Object[] { bNL(), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(this.oYt) });
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
        h.baF();
        h.baE().ban().set(at.a.acPO, Boolean.TRUE);
        if ((this.wCd instanceof TopStoryVideoPlayTextureView)) {
          ((TopStoryVideoPlayTextureView)this.wCd).setNeedResetExtractor(true);
        }
        com.tencent.mm.plugin.websearch.api.a.b.rG(com.tencent.mm.plugin.websearch.api.a.b.FtR);
        AppMethodBeat.o(126191);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", localException, "%s onError [%s]", new Object[] { bNL(), localException.toString() });
        }
      }
      com.tencent.mm.plugin.websearch.api.a.b.rG(com.tencent.mm.plugin.websearch.api.a.b.FtQ);
      AppMethodBeat.o(126191);
      return;
      com.tencent.mm.plugin.websearch.api.a.b.rG(com.tencent.mm.plugin.websearch.api.a.b.FtS);
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126185);
    super.onUIDestroy();
    this.TLn = null;
    AppMethodBeat.o(126185);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(126193);
    Log.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIPause", new Object[] { bNL() });
    if (this.sIU)
    {
      this.sJf = getCurrPosSec();
      this.sJg = isPlaying();
      this.sJm = 0;
      this.sJl = 0L;
      pause();
      stopTimer();
      this.sIU = false;
      hp(getReportIdkey() + 11);
    }
    AppMethodBeat.o(126193);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(126192);
    Log.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIResume", new Object[] { bNL() });
    if (!this.sIU)
    {
      this.sIU = true;
      if (this.wCd != null)
      {
        if (!this.sJg) {
          break label75;
        }
        bNU();
      }
    }
    for (;;)
    {
      hp(getReportIdkey() + 10);
      AppMethodBeat.o(126192);
      return;
      label75:
      ((VideoPlayerTextureView)this.wCd).cxp();
    }
  }
  
  public final void setVideoInfo(foh paramfoh)
  {
    AppMethodBeat.i(126178);
    super.b(false, paramfoh.videoUrl, 0);
    this.TIW = paramfoh;
    this.oYq = d.bL(paramfoh.Ido, paramfoh.abOw);
    this.oYr = (this.TLn.hNy() + this.oYq + ".mp4");
    AppMethodBeat.o(126178);
  }
  
  public final void start()
  {
    AppMethodBeat.i(126186);
    super.start();
    a.rG(5);
    AppMethodBeat.o(126186);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(126196);
    super.stop();
    this.TIW = null;
    AppMethodBeat.o(126196);
  }
  
  public final boolean xb(int paramInt)
  {
    AppMethodBeat.i(126180);
    if (this.oYs == 3)
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
      if ((paramInt != 0) || (this.oYu == null) || (!dTa())) {
        break label249;
      }
      localPInt4.value = 0;
      localPInt3.value = 0;
      bool1 = this.oYu.b(paramInt + 1, localPInt3, localPInt4);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          PInt localPInt4;
          this.oYz = i;
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
        Log.e("MicroMsg.TopStory.TopStoryVideoView", "%s check video data error %s ", new Object[] { bNL(), localException1.toString() });
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
      if ((this.oYp != null) && (this.oYu != null) && (this.oYu.a(paramInt, i, localPInt1, localPInt2)))
      {
        bool1 = this.oYp.isVideoDataAvailable(this.oYq, localPInt1.value, localPInt2.value);
        bool2 = bool1;
        if (!bool1) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.q
 * JD-Core Version:    0.7.0.1
 */