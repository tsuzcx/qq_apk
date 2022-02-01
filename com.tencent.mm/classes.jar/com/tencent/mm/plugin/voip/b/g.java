package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReport;", "", "()V", "addRendererViewInFullScreenWindowsTimes", "", "addRendererViewInFullScreenWindowsTimesInvite", "addRendererViewInMiniScreenWindowsTimes", "addRendererViewInMiniScreenWindowsTimesInvite", "changeToFullScreenCount", "", "changeToHWCount", "changeToMiniScreenCount", "changeToSWCount", "mCameraRenderFrameCount", "mServiceRenderFrameCount", "mYuvRenderFrameCount", "onDecModeChanged", "", "mode", "onFrameDrawCost", "cost", "type", "isFullScreen", "", "isFaceBeauty", "onRendererDrawPerFrameEndAfterAddView", "isInvite", "onRendererDrawPerFrameEndAfterAddViewAfterInit", "onRendererViewAdd", "times", "onWindowTypeChanged", "reportCameraRendererCostPerFrame", "reportRendererTypeChangeCount", "reportRendererWindowTypePercent", "reportServiceRendererCostPerFrame", "reportWhileFinish", "reportYUVRendererCostPerFrame", "Companion", "plugin-voip_release"})
public final class g
{
  public static final a AMq;
  public long AMf = -1L;
  public long AMg = -1L;
  private int AMh = -1;
  private int AMi = -1;
  public long AMj = -1L;
  public long AMk = -1L;
  public long AMl = -1L;
  public long AMm = -1L;
  public int AMn = -1;
  public int AMo = -1;
  public int AMp = -1;
  
  static
  {
    AppMethodBeat.i(208677);
    AMq = new a((byte)0);
    AppMethodBeat.o(208677);
  }
  
  public static final void SO(int paramInt)
  {
    AppMethodBeat.i(208679);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(208679);
      return;
      i locali = i.AMu;
      i.elY();
      AppMethodBeat.o(208679);
      return;
      locali = i.AMu;
      i.elZ();
    }
  }
  
  private final void elQ()
  {
    AppMethodBeat.i(208674);
    this.AMf += 1L;
    this.AMg += 1L;
    i locali;
    if (this.AMf > 0L)
    {
      locali = i.AMu;
      i.yU(this.AMf);
    }
    if (this.AMg > 0L)
    {
      locali = i.AMu;
      i.yV(this.AMg);
    }
    this.AMf = -1L;
    this.AMg = -1L;
    AppMethodBeat.o(208674);
  }
  
  private final void elR()
  {
    AppMethodBeat.i(208675);
    this.AMh += 1;
    this.AMi += 1;
    int i = this.AMh + this.AMi;
    if (i != 0)
    {
      i locali;
      if (this.AMh > 0)
      {
        locali = i.AMu;
        i.zo(this.AMh * 100 / i);
      }
      if (this.AMi > 0)
      {
        locali = i.AMu;
        i.zp(this.AMi * 100 / i);
      }
    }
    this.AMh = -1;
    this.AMi = -1;
    AppMethodBeat.o(208675);
  }
  
  public static final void elT()
  {
    AppMethodBeat.i(208678);
    i locali = i.AMu;
    i.elV();
    AppMethodBeat.o(208678);
  }
  
  public static final void sR(boolean paramBoolean)
  {
    AppMethodBeat.i(208680);
    if (paramBoolean)
    {
      locali = i.AMu;
      i.emb();
      AppMethodBeat.o(208680);
      return;
    }
    i locali = i.AMu;
    i.ema();
    AppMethodBeat.o(208680);
  }
  
  public final void SN(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.AMi += 1;
      return;
    }
    this.AMh += 1;
  }
  
  public final void aw(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(208672);
    i locali;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.AMl != -1L)
        {
          locali = i.AMu;
          i.zk(bs.aO(this.AMl));
          this.AMl = -1L;
          AppMethodBeat.o(208672);
        }
      }
      else
      {
        if (this.AMj != -1L)
        {
          locali = i.AMu;
          i.zk(bs.aO(this.AMj));
          this.AMj = -1L;
        }
        AppMethodBeat.o(208672);
      }
    }
    else if (paramBoolean2)
    {
      if (this.AMm != -1L)
      {
        locali = i.AMu;
        i.zl(bs.aO(this.AMm));
        this.AMm = -1L;
        AppMethodBeat.o(208672);
      }
    }
    else if (this.AMk != -1L)
    {
      locali = i.AMu;
      i.zl(bs.aO(this.AMk));
      this.AMk = -1L;
    }
    AppMethodBeat.o(208672);
  }
  
  public final void ax(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(208673);
    i locali;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.AMl != -1L)
        {
          locali = i.AMu;
          i.zi(bs.aO(this.AMl));
          this.AMl = -1L;
          AppMethodBeat.o(208673);
        }
      }
      else
      {
        if (this.AMj != -1L)
        {
          locali = i.AMu;
          i.yY(bs.aO(this.AMj));
          this.AMj = -1L;
        }
        AppMethodBeat.o(208673);
      }
    }
    else if (paramBoolean2)
    {
      if (this.AMm != -1L)
      {
        locali = i.AMu;
        i.zj(bs.aO(this.AMm));
        this.AMm = -1L;
        AppMethodBeat.o(208673);
      }
    }
    else if (this.AMk != -1L)
    {
      locali = i.AMu;
      i.yZ(bs.aO(this.AMk));
      this.AMk = -1L;
    }
    AppMethodBeat.o(208673);
  }
  
  public final void elS()
  {
    AppMethodBeat.i(208676);
    i locali = i.AMu;
    i.elU();
    elQ();
    elR();
    AppMethodBeat.o(208676);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReport$Companion;", "", "()V", "reportBatteryAverage", "", "data", "", "type", "", "reportCameraOnError", "reportFaceBeautyAlgoException", "reportFaceBeautyUse", "reportNewRendererInitSucc", "isCamera", "", "reportPboSizeInit", "width", "height", "reportRendererModeChanged", "isManual", "reportRendererUse", "plugin-voip_release"})
  public static final class a
  {
    public static void SP(int paramInt)
    {
      AppMethodBeat.i(208669);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(208669);
        return;
        i locali = i.AMu;
        i.emc();
        AppMethodBeat.o(208669);
        return;
        locali = i.AMu;
        i.emd();
        AppMethodBeat.o(208669);
        return;
        locali = i.AMu;
        i.eme();
      }
    }
    
    public static void SQ(int paramInt)
    {
      AppMethodBeat.i(208670);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(208670);
        return;
        i locali = i.AMu;
        i.emf();
        AppMethodBeat.o(208670);
        return;
        locali = i.AMu;
        i.emg();
      }
    }
    
    public static void ab(long paramLong, int paramInt)
    {
      AppMethodBeat.i(208671);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(208671);
        return;
        i locali = i.AMu;
        i.yX(paramLong);
        AppMethodBeat.o(208671);
        return;
        locali = i.AMu;
        i.yW(paramLong);
      }
    }
    
    public static void sS(boolean paramBoolean)
    {
      AppMethodBeat.i(208668);
      if (paramBoolean)
      {
        locali = i.AMu;
        i.elW();
        AppMethodBeat.o(208668);
        return;
      }
      i locali = i.AMu;
      i.elX();
      AppMethodBeat.o(208668);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.g
 * JD-Core Version:    0.7.0.1
 */