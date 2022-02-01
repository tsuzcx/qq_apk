package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReportPrev;", "", "()V", "addRendererViewInFullScreenWindowsTimes", "", "addRendererViewInFullScreenWindowsTimesInviteUI", "addRendererViewInMiniScreenWindowsTimes", "addRendererViewInMiniScreenWindowsTimesInviteUI", "changeToHWCount", "changeToSWCount", "mCameraRenderFrameCount", "", "mServiceRenderFrameCount", "mYuvRenderFrameCount", "onDecModeChanged", "", "mode", "onFrameDrawCost", "cost", "type", "isFullScreen", "", "isUseFaceBeauty", "onRendererDrawPerFrameEndAfterAddView", "isInviteUi", "onRendererDrawPerFrameEndAfterAddViewAfterInit", "onRendererViewAdd", "times", "reportCameraYUVRendererCostPerFrame", "reportRendererTypeChangeCount", "reportServiceRendererCostPerFrame", "reportWhileFinish", "reportYUVRendererCostPerFrame", "Companion", "plugin-voip_release"})
public final class i
{
  public static final a Hho;
  public long Hha = -1L;
  public long Hhb = -1L;
  public long Hhe = -1L;
  public long Hhf = -1L;
  public int Hhi = -1;
  public int Hhj = -1;
  public int Hhk = -1;
  public long Hhm = -1L;
  public long Hhn = -1L;
  
  static
  {
    AppMethodBeat.i(236100);
    Hho = new a((byte)0);
    AppMethodBeat.o(236100);
  }
  
  private final void fKn()
  {
    AppMethodBeat.i(236099);
    this.Hha += 1L;
    this.Hhb += 1L;
    f localf;
    if (this.Hha > 0L)
    {
      localf = f.HgY;
      f.Lm(this.Hha);
    }
    if (this.Hhb > 0L)
    {
      localf = f.HgY;
      f.Ln(this.Hhb);
    }
    this.Hha = -1L;
    this.Hhb = -1L;
    AppMethodBeat.o(236099);
  }
  
  public final void aO(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(236097);
    f localf;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.Hhm != -1L)
        {
          localf = f.HgY;
          f.LC(Util.ticksToNow(this.Hhm));
          this.Hhm = -1L;
          AppMethodBeat.o(236097);
        }
      }
      else
      {
        if (this.Hhe != -1L)
        {
          localf = f.HgY;
          f.LC(Util.ticksToNow(this.Hhe));
          this.Hhe = -1L;
        }
        AppMethodBeat.o(236097);
      }
    }
    else if (paramBoolean2)
    {
      if (this.Hhn != -1L)
      {
        localf = f.HgY;
        f.LD(Util.ticksToNow(this.Hhn));
        this.Hhn = -1L;
        AppMethodBeat.o(236097);
      }
    }
    else if (this.Hhf != -1L)
    {
      localf = f.HgY;
      f.LD(Util.ticksToNow(this.Hhf));
      this.Hhf = -1L;
    }
    AppMethodBeat.o(236097);
  }
  
  public final void aP(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(236098);
    f localf;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.Hhm != -1L)
        {
          localf = f.HgY;
          f.LA(Util.ticksToNow(this.Hhm));
          this.Hhm = -1L;
          AppMethodBeat.o(236098);
        }
      }
      else
      {
        if (this.Hhe != -1L)
        {
          localf = f.HgY;
          f.Lq(Util.ticksToNow(this.Hhe));
          this.Hhe = -1L;
        }
        AppMethodBeat.o(236098);
      }
    }
    else if (paramBoolean2)
    {
      if (this.Hhn != -1L)
      {
        localf = f.HgY;
        f.LB(Util.ticksToNow(this.Hhn));
        this.Hhn = -1L;
        AppMethodBeat.o(236098);
      }
    }
    else if (this.Hhf != -1L)
    {
      localf = f.HgY;
      f.Lr(Util.ticksToNow(this.Hhf));
      this.Hhf = -1L;
    }
    AppMethodBeat.o(236098);
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(236096);
    f localf = f.HgY;
    f.fKd();
    fKn();
    AppMethodBeat.o(236096);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReportPrev$Companion;", "", "()V", "reportBatteryAverage", "", "data", "", "type", "", "plugin-voip_release"})
  public static final class a
  {
    public static void aj(long paramLong, int paramInt)
    {
      AppMethodBeat.i(236095);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(236095);
        return;
        f localf = f.HgY;
        f.Lp(paramLong);
        AppMethodBeat.o(236095);
        return;
        localf = f.HgY;
        f.Lo(paramLong);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.i
 * JD-Core Version:    0.7.0.1
 */