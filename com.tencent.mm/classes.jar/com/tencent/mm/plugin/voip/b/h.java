package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReportPrev;", "", "()V", "addRendererViewInFullScreenWindowsTimes", "", "addRendererViewInFullScreenWindowsTimesInviteUI", "addRendererViewInMiniScreenWindowsTimes", "addRendererViewInMiniScreenWindowsTimesInviteUI", "changeToHWCount", "changeToSWCount", "mCameraRenderFrameCount", "", "mServiceRenderFrameCount", "mYuvRenderFrameCount", "onDecModeChanged", "", "mode", "onFrameDrawCost", "cost", "type", "isFullScreen", "", "isUseFaceBeauty", "onRendererDrawPerFrameEndAfterAddView", "isInviteUi", "onRendererDrawPerFrameEndAfterAddViewAfterInit", "onRendererViewAdd", "times", "reportCameraYUVRendererCostPerFrame", "reportRendererTypeChangeCount", "reportServiceRendererCostPerFrame", "reportWhileFinish", "reportYUVRendererCostPerFrame", "Companion", "plugin-voip_release"})
public final class h
{
  public static final a AMt;
  public long AMf = -1L;
  public long AMg = -1L;
  public long AMj = -1L;
  public long AMk = -1L;
  public int AMn = -1;
  public int AMo = -1;
  public int AMp = -1;
  public long AMr = -1L;
  public long AMs = -1L;
  
  static
  {
    AppMethodBeat.i(208686);
    AMt = new a((byte)0);
    AppMethodBeat.o(208686);
  }
  
  private final void elQ()
  {
    AppMethodBeat.i(208685);
    this.AMf += 1L;
    this.AMg += 1L;
    e locale;
    if (this.AMf > 0L)
    {
      locale = e.AMd;
      e.yU(this.AMf);
    }
    if (this.AMg > 0L)
    {
      locale = e.AMd;
      e.yV(this.AMg);
    }
    this.AMf = -1L;
    this.AMg = -1L;
    AppMethodBeat.o(208685);
  }
  
  public final void aw(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(208683);
    e locale;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.AMr != -1L)
        {
          locale = e.AMd;
          e.zk(bs.aO(this.AMr));
          this.AMr = -1L;
          AppMethodBeat.o(208683);
        }
      }
      else
      {
        if (this.AMj != -1L)
        {
          locale = e.AMd;
          e.zk(bs.aO(this.AMj));
          this.AMj = -1L;
        }
        AppMethodBeat.o(208683);
      }
    }
    else if (paramBoolean2)
    {
      if (this.AMs != -1L)
      {
        locale = e.AMd;
        e.zl(bs.aO(this.AMs));
        this.AMs = -1L;
        AppMethodBeat.o(208683);
      }
    }
    else if (this.AMk != -1L)
    {
      locale = e.AMd;
      e.zl(bs.aO(this.AMk));
      this.AMk = -1L;
    }
    AppMethodBeat.o(208683);
  }
  
  public final void ax(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(208684);
    e locale;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.AMr != -1L)
        {
          locale = e.AMd;
          e.zi(bs.aO(this.AMr));
          this.AMr = -1L;
          AppMethodBeat.o(208684);
        }
      }
      else
      {
        if (this.AMj != -1L)
        {
          locale = e.AMd;
          e.yY(bs.aO(this.AMj));
          this.AMj = -1L;
        }
        AppMethodBeat.o(208684);
      }
    }
    else if (paramBoolean2)
    {
      if (this.AMs != -1L)
      {
        locale = e.AMd;
        e.zj(bs.aO(this.AMs));
        this.AMs = -1L;
        AppMethodBeat.o(208684);
      }
    }
    else if (this.AMk != -1L)
    {
      locale = e.AMd;
      e.yZ(bs.aO(this.AMk));
      this.AMk = -1L;
    }
    AppMethodBeat.o(208684);
  }
  
  public final void elS()
  {
    AppMethodBeat.i(208682);
    e locale = e.AMd;
    e.elL();
    elQ();
    AppMethodBeat.o(208682);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReportPrev$Companion;", "", "()V", "reportBatteryAverage", "", "data", "", "type", "", "plugin-voip_release"})
  public static final class a
  {
    public static void ab(long paramLong, int paramInt)
    {
      AppMethodBeat.i(208681);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(208681);
        return;
        e locale = e.AMd;
        e.yX(paramLong);
        AppMethodBeat.o(208681);
        return;
        locale = e.AMd;
        e.yW(paramLong);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.h
 * JD-Core Version:    0.7.0.1
 */