package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReport;", "", "()V", "addRendererViewInFullScreenWindowsTimes", "", "addRendererViewInFullScreenWindowsTimesInvite", "addRendererViewInMiniScreenWindowsTimes", "addRendererViewInMiniScreenWindowsTimesInvite", "changeToFullScreenCount", "", "changeToHWCount", "changeToMiniScreenCount", "changeToSWCount", "mCameraRenderFrameCount", "mServiceRenderFrameCount", "mYuvRenderFrameCount", "onDecModeChanged", "", "mode", "onFrameDrawCost", "cost", "type", "isFullScreen", "", "isFaceBeauty", "onRendererDrawPerFrameEndAfterAddView", "isInvite", "onRendererDrawPerFrameEndAfterAddViewAfterInit", "onRendererViewAdd", "times", "onWindowTypeChanged", "reportCameraRendererCostPerFrame", "reportRendererTypeChangeCount", "reportRendererWindowTypePercent", "reportServiceRendererCostPerFrame", "reportWhileFinish", "reportYUVRendererCostPerFrame", "Companion", "plugin-voip_release"})
public final class i
{
  public static final a CDi;
  public long CCX = -1L;
  public long CCY = -1L;
  private int CCZ = -1;
  private int CDa = -1;
  public long CDb = -1L;
  public long CDc = -1L;
  public long CDd = -1L;
  public long CDe = -1L;
  public int CDf = -1;
  public int CDg = -1;
  public int CDh = -1;
  
  static
  {
    AppMethodBeat.i(210429);
    CDi = new a((byte)0);
    AppMethodBeat.o(210429);
  }
  
  public static final void Vo(int paramInt)
  {
    AppMethodBeat.i(210431);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(210431);
      return;
      k localk = k.CDm;
      k.eDB();
      AppMethodBeat.o(210431);
      return;
      localk = k.CDm;
      k.eDC();
    }
  }
  
  private final void eDt()
  {
    AppMethodBeat.i(210426);
    this.CCX += 1L;
    this.CCY += 1L;
    k localk;
    if (this.CCX > 0L)
    {
      localk = k.CDm;
      k.BZ(this.CCX);
    }
    if (this.CCY > 0L)
    {
      localk = k.CDm;
      k.Ca(this.CCY);
    }
    this.CCX = -1L;
    this.CCY = -1L;
    AppMethodBeat.o(210426);
  }
  
  private final void eDu()
  {
    AppMethodBeat.i(210427);
    this.CCZ += 1;
    this.CDa += 1;
    int i = this.CCZ + this.CDa;
    if (i != 0)
    {
      k localk;
      if (this.CCZ > 0)
      {
        localk = k.CDm;
        k.Ct(this.CCZ * 100 / i);
      }
      if (this.CDa > 0)
      {
        localk = k.CDm;
        k.Cu(this.CDa * 100 / i);
      }
    }
    this.CCZ = -1;
    this.CDa = -1;
    AppMethodBeat.o(210427);
  }
  
  public static final void eDw()
  {
    AppMethodBeat.i(210430);
    k localk = k.CDm;
    k.eDy();
    AppMethodBeat.o(210430);
  }
  
  public static final void tI(boolean paramBoolean)
  {
    AppMethodBeat.i(210432);
    if (paramBoolean)
    {
      localk = k.CDm;
      k.eDE();
      AppMethodBeat.o(210432);
      return;
    }
    k localk = k.CDm;
    k.eDD();
    AppMethodBeat.o(210432);
  }
  
  public final void Vn(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.CDa += 1;
      return;
    }
    this.CCZ += 1;
  }
  
  public final void aC(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(210424);
    k localk;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.CDd != -1L)
        {
          localk = k.CDm;
          k.Cp(bu.aO(this.CDd));
          this.CDd = -1L;
          AppMethodBeat.o(210424);
        }
      }
      else
      {
        if (this.CDb != -1L)
        {
          localk = k.CDm;
          k.Cp(bu.aO(this.CDb));
          this.CDb = -1L;
        }
        AppMethodBeat.o(210424);
      }
    }
    else if (paramBoolean2)
    {
      if (this.CDe != -1L)
      {
        localk = k.CDm;
        k.Cq(bu.aO(this.CDe));
        this.CDe = -1L;
        AppMethodBeat.o(210424);
      }
    }
    else if (this.CDc != -1L)
    {
      localk = k.CDm;
      k.Cq(bu.aO(this.CDc));
      this.CDc = -1L;
    }
    AppMethodBeat.o(210424);
  }
  
  public final void aD(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(210425);
    k localk;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.CDd != -1L)
        {
          localk = k.CDm;
          k.Cn(bu.aO(this.CDd));
          this.CDd = -1L;
          AppMethodBeat.o(210425);
        }
      }
      else
      {
        if (this.CDb != -1L)
        {
          localk = k.CDm;
          k.Cd(bu.aO(this.CDb));
          this.CDb = -1L;
        }
        AppMethodBeat.o(210425);
      }
    }
    else if (paramBoolean2)
    {
      if (this.CDe != -1L)
      {
        localk = k.CDm;
        k.Co(bu.aO(this.CDe));
        this.CDe = -1L;
        AppMethodBeat.o(210425);
      }
    }
    else if (this.CDc != -1L)
    {
      localk = k.CDm;
      k.Ce(bu.aO(this.CDc));
      this.CDc = -1L;
    }
    AppMethodBeat.o(210425);
  }
  
  public final void eDv()
  {
    AppMethodBeat.i(210428);
    k localk = k.CDm;
    k.eDx();
    eDt();
    eDu();
    AppMethodBeat.o(210428);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReport$Companion;", "", "()V", "reportBatteryAverage", "", "data", "", "type", "", "reportCameraOnError", "reportFaceBeautyAlgoException", "reportFaceBeautyUse", "reportNewRendererInitSucc", "isCamera", "", "reportPboSizeInit", "width", "height", "reportRendererModeChanged", "isManual", "reportRendererUse", "plugin-voip_release"})
  public static final class a
  {
    public static void Vp(int paramInt)
    {
      AppMethodBeat.i(210421);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(210421);
        return;
        k localk = k.CDm;
        k.eDF();
        AppMethodBeat.o(210421);
        return;
        localk = k.CDm;
        k.eDG();
        AppMethodBeat.o(210421);
        return;
        localk = k.CDm;
        k.eDH();
      }
    }
    
    public static void Vq(int paramInt)
    {
      AppMethodBeat.i(210422);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(210422);
        return;
        k localk = k.CDm;
        k.eDI();
        AppMethodBeat.o(210422);
        return;
        localk = k.CDm;
        k.eDJ();
      }
    }
    
    public static void ag(long paramLong, int paramInt)
    {
      AppMethodBeat.i(210423);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(210423);
        return;
        k localk = k.CDm;
        k.Cc(paramLong);
        AppMethodBeat.o(210423);
        return;
        localk = k.CDm;
        k.Cb(paramLong);
      }
    }
    
    public static void tJ(boolean paramBoolean)
    {
      AppMethodBeat.i(210420);
      if (paramBoolean)
      {
        localk = k.CDm;
        k.eDz();
        AppMethodBeat.o(210420);
        return;
      }
      k localk = k.CDm;
      k.eDA();
      AppMethodBeat.o(210420);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.i
 * JD-Core Version:    0.7.0.1
 */