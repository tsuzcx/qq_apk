package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReportPrev;", "", "()V", "addRendererViewInFullScreenWindowsTimes", "", "addRendererViewInFullScreenWindowsTimesInviteUI", "addRendererViewInMiniScreenWindowsTimes", "addRendererViewInMiniScreenWindowsTimesInviteUI", "changeToHWCount", "changeToSWCount", "mCameraRenderFrameCount", "", "mServiceRenderFrameCount", "mYuvRenderFrameCount", "onDecModeChanged", "", "mode", "onFrameDrawCost", "cost", "type", "isFullScreen", "", "isUseFaceBeauty", "onRendererDrawPerFrameEndAfterAddView", "isInviteUi", "onRendererDrawPerFrameEndAfterAddViewAfterInit", "onRendererViewAdd", "times", "reportCameraYUVRendererCostPerFrame", "reportRendererTypeChangeCount", "reportServiceRendererCostPerFrame", "reportWhileFinish", "reportYUVRendererCostPerFrame", "Companion", "plugin-voip_release"})
public final class j
{
  public static final a ClH;
  public int ClB = -1;
  public int ClC = -1;
  public int ClD = -1;
  public long ClF = -1L;
  public long ClG = -1L;
  public long Clt = -1L;
  public long Clu = -1L;
  public long Clx = -1L;
  public long Cly = -1L;
  
  static
  {
    AppMethodBeat.i(216017);
    ClH = new a((byte)0);
    AppMethodBeat.o(216017);
  }
  
  private final void ezL()
  {
    AppMethodBeat.i(216016);
    this.Clt += 1L;
    this.Clu += 1L;
    g localg;
    if (this.Clt > 0L)
    {
      localg = g.Clr;
      g.BB(this.Clt);
    }
    if (this.Clu > 0L)
    {
      localg = g.Clr;
      g.BC(this.Clu);
    }
    this.Clt = -1L;
    this.Clu = -1L;
    AppMethodBeat.o(216016);
  }
  
  public final void aD(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(216014);
    g localg;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.ClF != -1L)
        {
          localg = g.Clr;
          g.BR(bt.aO(this.ClF));
          this.ClF = -1L;
          AppMethodBeat.o(216014);
        }
      }
      else
      {
        if (this.Clx != -1L)
        {
          localg = g.Clr;
          g.BR(bt.aO(this.Clx));
          this.Clx = -1L;
        }
        AppMethodBeat.o(216014);
      }
    }
    else if (paramBoolean2)
    {
      if (this.ClG != -1L)
      {
        localg = g.Clr;
        g.BS(bt.aO(this.ClG));
        this.ClG = -1L;
        AppMethodBeat.o(216014);
      }
    }
    else if (this.Cly != -1L)
    {
      localg = g.Clr;
      g.BS(bt.aO(this.Cly));
      this.Cly = -1L;
    }
    AppMethodBeat.o(216014);
  }
  
  public final void aE(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(216015);
    g localg;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.ClF != -1L)
        {
          localg = g.Clr;
          g.BP(bt.aO(this.ClF));
          this.ClF = -1L;
          AppMethodBeat.o(216015);
        }
      }
      else
      {
        if (this.Clx != -1L)
        {
          localg = g.Clr;
          g.BF(bt.aO(this.Clx));
          this.Clx = -1L;
        }
        AppMethodBeat.o(216015);
      }
    }
    else if (paramBoolean2)
    {
      if (this.ClG != -1L)
      {
        localg = g.Clr;
        g.BQ(bt.aO(this.ClG));
        this.ClG = -1L;
        AppMethodBeat.o(216015);
      }
    }
    else if (this.Cly != -1L)
    {
      localg = g.Clr;
      g.BG(bt.aO(this.Cly));
      this.Cly = -1L;
    }
    AppMethodBeat.o(216015);
  }
  
  public final void ezN()
  {
    AppMethodBeat.i(216013);
    g localg = g.Clr;
    g.ezE();
    ezL();
    AppMethodBeat.o(216013);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReportPrev$Companion;", "", "()V", "reportBatteryAverage", "", "data", "", "type", "", "plugin-voip_release"})
  public static final class a
  {
    public static void ag(long paramLong, int paramInt)
    {
      AppMethodBeat.i(216012);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(216012);
        return;
        g localg = g.Clr;
        g.BE(paramLong);
        AppMethodBeat.o(216012);
        return;
        localg = g.Clr;
        g.BD(paramLong);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.j
 * JD-Core Version:    0.7.0.1
 */