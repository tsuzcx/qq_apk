package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReportPrev;", "", "()V", "addRendererViewInFullScreenWindowsTimes", "", "addRendererViewInFullScreenWindowsTimesInviteUI", "addRendererViewInMiniScreenWindowsTimes", "addRendererViewInMiniScreenWindowsTimesInviteUI", "changeToHWCount", "changeToSWCount", "mCameraRenderFrameCount", "", "mServiceRenderFrameCount", "mYuvRenderFrameCount", "onDecModeChanged", "", "mode", "onFrameDrawCost", "cost", "type", "isFullScreen", "", "isUseFaceBeauty", "onRendererDrawPerFrameEndAfterAddView", "isInviteUi", "onRendererDrawPerFrameEndAfterAddViewAfterInit", "onRendererViewAdd", "times", "reportCameraYUVRendererCostPerFrame", "reportRendererTypeChangeCount", "reportServiceRendererCostPerFrame", "reportWhileFinish", "reportYUVRendererCostPerFrame", "Companion", "plugin-voip_release"})
public final class j
{
  public static final a CDl;
  public long CCX = -1L;
  public long CCY = -1L;
  public long CDb = -1L;
  public long CDc = -1L;
  public int CDf = -1;
  public int CDg = -1;
  public int CDh = -1;
  public long CDj = -1L;
  public long CDk = -1L;
  
  static
  {
    AppMethodBeat.i(210438);
    CDl = new a((byte)0);
    AppMethodBeat.o(210438);
  }
  
  private final void eDt()
  {
    AppMethodBeat.i(210437);
    this.CCX += 1L;
    this.CCY += 1L;
    g localg;
    if (this.CCX > 0L)
    {
      localg = g.CCV;
      g.BZ(this.CCX);
    }
    if (this.CCY > 0L)
    {
      localg = g.CCV;
      g.Ca(this.CCY);
    }
    this.CCX = -1L;
    this.CCY = -1L;
    AppMethodBeat.o(210437);
  }
  
  public final void aC(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(210435);
    g localg;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.CDj != -1L)
        {
          localg = g.CCV;
          g.Cp(bu.aO(this.CDj));
          this.CDj = -1L;
          AppMethodBeat.o(210435);
        }
      }
      else
      {
        if (this.CDb != -1L)
        {
          localg = g.CCV;
          g.Cp(bu.aO(this.CDb));
          this.CDb = -1L;
        }
        AppMethodBeat.o(210435);
      }
    }
    else if (paramBoolean2)
    {
      if (this.CDk != -1L)
      {
        localg = g.CCV;
        g.Cq(bu.aO(this.CDk));
        this.CDk = -1L;
        AppMethodBeat.o(210435);
      }
    }
    else if (this.CDc != -1L)
    {
      localg = g.CCV;
      g.Cq(bu.aO(this.CDc));
      this.CDc = -1L;
    }
    AppMethodBeat.o(210435);
  }
  
  public final void aD(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(210436);
    g localg;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.CDj != -1L)
        {
          localg = g.CCV;
          g.Cn(bu.aO(this.CDj));
          this.CDj = -1L;
          AppMethodBeat.o(210436);
        }
      }
      else
      {
        if (this.CDb != -1L)
        {
          localg = g.CCV;
          g.Cd(bu.aO(this.CDb));
          this.CDb = -1L;
        }
        AppMethodBeat.o(210436);
      }
    }
    else if (paramBoolean2)
    {
      if (this.CDk != -1L)
      {
        localg = g.CCV;
        g.Co(bu.aO(this.CDk));
        this.CDk = -1L;
        AppMethodBeat.o(210436);
      }
    }
    else if (this.CDc != -1L)
    {
      localg = g.CCV;
      g.Ce(bu.aO(this.CDc));
      this.CDc = -1L;
    }
    AppMethodBeat.o(210436);
  }
  
  public final void eDv()
  {
    AppMethodBeat.i(210434);
    g localg = g.CCV;
    g.eDm();
    eDt();
    AppMethodBeat.o(210434);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReportPrev$Companion;", "", "()V", "reportBatteryAverage", "", "data", "", "type", "", "plugin-voip_release"})
  public static final class a
  {
    public static void ag(long paramLong, int paramInt)
    {
      AppMethodBeat.i(210433);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(210433);
        return;
        g localg = g.CCV;
        g.Cc(paramLong);
        AppMethodBeat.o(210433);
        return;
        localg = g.CCV;
        g.Cb(paramLong);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.j
 * JD-Core Version:    0.7.0.1
 */