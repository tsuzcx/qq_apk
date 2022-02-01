package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReport;", "", "()V", "addRendererViewInFullScreenWindowsTimes", "", "addRendererViewInFullScreenWindowsTimesInvite", "addRendererViewInMiniScreenWindowsTimes", "addRendererViewInMiniScreenWindowsTimesInvite", "changeToFullScreenCount", "", "changeToHWCount", "changeToMiniScreenCount", "changeToSWCount", "mCameraRenderFrameCount", "mServiceRenderFrameCount", "mYuvRenderFrameCount", "onDecModeChanged", "", "mode", "onFrameDrawCost", "cost", "type", "isFullScreen", "", "isFaceBeauty", "onRendererDrawPerFrameEndAfterAddView", "isInvite", "onRendererDrawPerFrameEndAfterAddViewAfterInit", "onRendererViewAdd", "times", "onWindowTypeChanged", "reportCameraRendererCostPerFrame", "reportRendererTypeChangeCount", "reportRendererWindowTypePercent", "reportServiceRendererCostPerFrame", "reportWhileFinish", "reportYUVRendererCostPerFrame", "Companion", "plugin-voip_release"})
public final class i
{
  public static final a ClE;
  public long ClA = -1L;
  public int ClB = -1;
  public int ClC = -1;
  public int ClD = -1;
  public long Clt = -1L;
  public long Clu = -1L;
  private int Clv = -1;
  private int Clw = -1;
  public long Clx = -1L;
  public long Cly = -1L;
  public long Clz = -1L;
  
  static
  {
    AppMethodBeat.i(216008);
    ClE = new a((byte)0);
    AppMethodBeat.o(216008);
  }
  
  public static final void UH(int paramInt)
  {
    AppMethodBeat.i(216010);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(216010);
      return;
      k localk = k.ClI;
      k.ezT();
      AppMethodBeat.o(216010);
      return;
      localk = k.ClI;
      k.ezU();
    }
  }
  
  private final void ezL()
  {
    AppMethodBeat.i(216005);
    this.Clt += 1L;
    this.Clu += 1L;
    k localk;
    if (this.Clt > 0L)
    {
      localk = k.ClI;
      k.BB(this.Clt);
    }
    if (this.Clu > 0L)
    {
      localk = k.ClI;
      k.BC(this.Clu);
    }
    this.Clt = -1L;
    this.Clu = -1L;
    AppMethodBeat.o(216005);
  }
  
  private final void ezM()
  {
    AppMethodBeat.i(216006);
    this.Clv += 1;
    this.Clw += 1;
    int i = this.Clv + this.Clw;
    if (i != 0)
    {
      k localk;
      if (this.Clv > 0)
      {
        localk = k.ClI;
        k.BV(this.Clv * 100 / i);
      }
      if (this.Clw > 0)
      {
        localk = k.ClI;
        k.BW(this.Clw * 100 / i);
      }
    }
    this.Clv = -1;
    this.Clw = -1;
    AppMethodBeat.o(216006);
  }
  
  public static final void ezO()
  {
    AppMethodBeat.i(216009);
    k localk = k.ClI;
    k.ezQ();
    AppMethodBeat.o(216009);
  }
  
  public static final void tB(boolean paramBoolean)
  {
    AppMethodBeat.i(216011);
    if (paramBoolean)
    {
      localk = k.ClI;
      k.ezW();
      AppMethodBeat.o(216011);
      return;
    }
    k localk = k.ClI;
    k.ezV();
    AppMethodBeat.o(216011);
  }
  
  public final void UG(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.Clw += 1;
      return;
    }
    this.Clv += 1;
  }
  
  public final void aD(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(216003);
    k localk;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.Clz != -1L)
        {
          localk = k.ClI;
          k.BR(bt.aO(this.Clz));
          this.Clz = -1L;
          AppMethodBeat.o(216003);
        }
      }
      else
      {
        if (this.Clx != -1L)
        {
          localk = k.ClI;
          k.BR(bt.aO(this.Clx));
          this.Clx = -1L;
        }
        AppMethodBeat.o(216003);
      }
    }
    else if (paramBoolean2)
    {
      if (this.ClA != -1L)
      {
        localk = k.ClI;
        k.BS(bt.aO(this.ClA));
        this.ClA = -1L;
        AppMethodBeat.o(216003);
      }
    }
    else if (this.Cly != -1L)
    {
      localk = k.ClI;
      k.BS(bt.aO(this.Cly));
      this.Cly = -1L;
    }
    AppMethodBeat.o(216003);
  }
  
  public final void aE(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(216004);
    k localk;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.Clz != -1L)
        {
          localk = k.ClI;
          k.BP(bt.aO(this.Clz));
          this.Clz = -1L;
          AppMethodBeat.o(216004);
        }
      }
      else
      {
        if (this.Clx != -1L)
        {
          localk = k.ClI;
          k.BF(bt.aO(this.Clx));
          this.Clx = -1L;
        }
        AppMethodBeat.o(216004);
      }
    }
    else if (paramBoolean2)
    {
      if (this.ClA != -1L)
      {
        localk = k.ClI;
        k.BQ(bt.aO(this.ClA));
        this.ClA = -1L;
        AppMethodBeat.o(216004);
      }
    }
    else if (this.Cly != -1L)
    {
      localk = k.ClI;
      k.BG(bt.aO(this.Cly));
      this.Cly = -1L;
    }
    AppMethodBeat.o(216004);
  }
  
  public final void ezN()
  {
    AppMethodBeat.i(216007);
    k localk = k.ClI;
    k.ezP();
    ezL();
    ezM();
    AppMethodBeat.o(216007);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReport$Companion;", "", "()V", "reportBatteryAverage", "", "data", "", "type", "", "reportCameraOnError", "reportFaceBeautyAlgoException", "reportFaceBeautyUse", "reportNewRendererInitSucc", "isCamera", "", "reportPboSizeInit", "width", "height", "reportRendererModeChanged", "isManual", "reportRendererUse", "plugin-voip_release"})
  public static final class a
  {
    public static void UI(int paramInt)
    {
      AppMethodBeat.i(216000);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(216000);
        return;
        k localk = k.ClI;
        k.ezX();
        AppMethodBeat.o(216000);
        return;
        localk = k.ClI;
        k.ezY();
        AppMethodBeat.o(216000);
        return;
        localk = k.ClI;
        k.ezZ();
      }
    }
    
    public static void UJ(int paramInt)
    {
      AppMethodBeat.i(216001);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(216001);
        return;
        k localk = k.ClI;
        k.eAa();
        AppMethodBeat.o(216001);
        return;
        localk = k.ClI;
        k.eAb();
      }
    }
    
    public static void ag(long paramLong, int paramInt)
    {
      AppMethodBeat.i(216002);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(216002);
        return;
        k localk = k.ClI;
        k.BE(paramLong);
        AppMethodBeat.o(216002);
        return;
        localk = k.ClI;
        k.BD(paramLong);
      }
    }
    
    public static void tC(boolean paramBoolean)
    {
      AppMethodBeat.i(215999);
      if (paramBoolean)
      {
        localk = k.ClI;
        k.ezR();
        AppMethodBeat.o(215999);
        return;
      }
      k localk = k.ClI;
      k.ezS();
      AppMethodBeat.o(215999);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.i
 * JD-Core Version:    0.7.0.1
 */