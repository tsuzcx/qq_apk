package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReport;", "", "()V", "addRendererViewInFullScreenWindowsTimes", "", "addRendererViewInFullScreenWindowsTimesInvite", "addRendererViewInMiniScreenWindowsTimes", "addRendererViewInMiniScreenWindowsTimesInvite", "changeToFullScreenCount", "", "changeToHWCount", "changeToMiniScreenCount", "changeToSWCount", "mCameraRenderFrameCount", "mServiceRenderFrameCount", "mYuvRenderFrameCount", "onDecModeChanged", "", "mode", "onFrameDrawCost", "cost", "type", "isFullScreen", "", "isFaceBeauty", "onRendererDrawPerFrameEndAfterAddView", "isInvite", "onRendererDrawPerFrameEndAfterAddViewAfterInit", "onRendererViewAdd", "times", "onWindowTypeChanged", "reportCameraRendererCostPerFrame", "reportRendererTypeChangeCount", "reportRendererWindowTypePercent", "reportServiceRendererCostPerFrame", "reportWhileFinish", "reportYUVRendererCostPerFrame", "Companion", "plugin-voip_release"})
public final class h
{
  public static final a Hhl;
  public long Hha = -1L;
  public long Hhb = -1L;
  private int Hhc = -1;
  private int Hhd = -1;
  public long Hhe = -1L;
  public long Hhf = -1L;
  public long Hhg = -1L;
  public long Hhh = -1L;
  public int Hhi = -1;
  public int Hhj = -1;
  public int Hhk = -1;
  
  static
  {
    AppMethodBeat.i(236091);
    Hhl = new a((byte)0);
    AppMethodBeat.o(236091);
  }
  
  public static final void adJ(int paramInt)
  {
    AppMethodBeat.i(236093);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(236093);
      return;
      j localj = j.Hhp;
      j.fKv();
      AppMethodBeat.o(236093);
      return;
      localj = j.Hhp;
      j.fKw();
    }
  }
  
  private final void fKn()
  {
    AppMethodBeat.i(236088);
    this.Hha += 1L;
    this.Hhb += 1L;
    j localj;
    if (this.Hha > 0L)
    {
      localj = j.Hhp;
      j.Lm(this.Hha);
    }
    if (this.Hhb > 0L)
    {
      localj = j.Hhp;
      j.Ln(this.Hhb);
    }
    this.Hha = -1L;
    this.Hhb = -1L;
    AppMethodBeat.o(236088);
  }
  
  private final void fKo()
  {
    AppMethodBeat.i(236089);
    this.Hhc += 1;
    this.Hhd += 1;
    int i = this.Hhc + this.Hhd;
    if (i != 0)
    {
      j localj;
      if (this.Hhc > 0)
      {
        localj = j.Hhp;
        j.LG(this.Hhc * 100 / i);
      }
      if (this.Hhd > 0)
      {
        localj = j.Hhp;
        j.LH(this.Hhd * 100 / i);
      }
    }
    this.Hhc = -1;
    this.Hhd = -1;
    AppMethodBeat.o(236089);
  }
  
  public static final void fKq()
  {
    AppMethodBeat.i(236092);
    j localj = j.Hhp;
    j.fKs();
    AppMethodBeat.o(236092);
  }
  
  public static final void xs(boolean paramBoolean)
  {
    AppMethodBeat.i(236094);
    if (paramBoolean)
    {
      localj = j.Hhp;
      j.fKy();
      AppMethodBeat.o(236094);
      return;
    }
    j localj = j.Hhp;
    j.fKx();
    AppMethodBeat.o(236094);
  }
  
  public final void aO(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(236086);
    j localj;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.Hhg != -1L)
        {
          localj = j.Hhp;
          j.LC(Util.ticksToNow(this.Hhg));
          this.Hhg = -1L;
          AppMethodBeat.o(236086);
        }
      }
      else
      {
        if (this.Hhe != -1L)
        {
          localj = j.Hhp;
          j.LC(Util.ticksToNow(this.Hhe));
          this.Hhe = -1L;
        }
        AppMethodBeat.o(236086);
      }
    }
    else if (paramBoolean2)
    {
      if (this.Hhh != -1L)
      {
        localj = j.Hhp;
        j.LD(Util.ticksToNow(this.Hhh));
        this.Hhh = -1L;
        AppMethodBeat.o(236086);
      }
    }
    else if (this.Hhf != -1L)
    {
      localj = j.Hhp;
      j.LD(Util.ticksToNow(this.Hhf));
      this.Hhf = -1L;
    }
    AppMethodBeat.o(236086);
  }
  
  public final void aP(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(236087);
    j localj;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.Hhg != -1L)
        {
          localj = j.Hhp;
          j.LA(Util.ticksToNow(this.Hhg));
          this.Hhg = -1L;
          AppMethodBeat.o(236087);
        }
      }
      else
      {
        if (this.Hhe != -1L)
        {
          localj = j.Hhp;
          j.Lq(Util.ticksToNow(this.Hhe));
          this.Hhe = -1L;
        }
        AppMethodBeat.o(236087);
      }
    }
    else if (paramBoolean2)
    {
      if (this.Hhh != -1L)
      {
        localj = j.Hhp;
        j.LB(Util.ticksToNow(this.Hhh));
        this.Hhh = -1L;
        AppMethodBeat.o(236087);
      }
    }
    else if (this.Hhf != -1L)
    {
      localj = j.Hhp;
      j.Lr(Util.ticksToNow(this.Hhf));
      this.Hhf = -1L;
    }
    AppMethodBeat.o(236087);
  }
  
  public final void adI(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.Hhd += 1;
      return;
    }
    this.Hhc += 1;
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(236090);
    j localj = j.Hhp;
    j.fKr();
    fKn();
    fKo();
    AppMethodBeat.o(236090);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReport$Companion;", "", "()V", "reportBatteryAverage", "", "data", "", "type", "", "reportCameraOnError", "reportFaceBeautyAlgoException", "reportFaceBeautyUse", "reportNewRendererInitSucc", "isCamera", "", "reportPboSizeInit", "width", "height", "reportRendererModeChanged", "isManual", "reportRendererUse", "plugin-voip_release"})
  public static final class a
  {
    public static void aA(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(236082);
      j localj = j.Hhp;
      j.LE(paramLong1);
      localj = j.Hhp;
      j.LF(paramLong2);
      AppMethodBeat.o(236082);
    }
    
    public static void adK(int paramInt)
    {
      AppMethodBeat.i(236083);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(236083);
        return;
        j localj = j.Hhp;
        j.fKz();
        AppMethodBeat.o(236083);
        return;
        localj = j.Hhp;
        j.fKA();
        AppMethodBeat.o(236083);
        return;
        localj = j.Hhp;
        j.fKB();
      }
    }
    
    public static void adL(int paramInt)
    {
      AppMethodBeat.i(236084);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(236084);
        return;
        j localj = j.Hhp;
        j.fKC();
        AppMethodBeat.o(236084);
        return;
        localj = j.Hhp;
        j.fKD();
      }
    }
    
    public static void aj(long paramLong, int paramInt)
    {
      AppMethodBeat.i(236085);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(236085);
        return;
        j localj = j.Hhp;
        j.Lp(paramLong);
        AppMethodBeat.o(236085);
        return;
        localj = j.Hhp;
        j.Lo(paramLong);
      }
    }
    
    public static void xt(boolean paramBoolean)
    {
      AppMethodBeat.i(236081);
      if (paramBoolean)
      {
        localj = j.Hhp;
        j.fKt();
        AppMethodBeat.o(236081);
        return;
      }
      j localj = j.Hhp;
      j.fKu();
      AppMethodBeat.o(236081);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.h
 * JD-Core Version:    0.7.0.1
 */