package com.tencent.mm.plugin.voip.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReportPrev;", "", "()V", "addRendererViewInFullScreenWindowsTimes", "", "addRendererViewInFullScreenWindowsTimesInviteUI", "addRendererViewInMiniScreenWindowsTimes", "addRendererViewInMiniScreenWindowsTimesInviteUI", "changeToHWCount", "changeToSWCount", "mCameraRenderFrameCount", "", "mServiceRenderFrameCount", "mYuvRenderFrameCount", "onDecModeChanged", "", "mode", "onFrameDrawCost", "cost", "type", "isFullScreen", "", "isUseFaceBeauty", "onRendererDrawPerFrameEndAfterAddView", "isInviteUi", "onRendererDrawPerFrameEndAfterAddViewAfterInit", "onRendererViewAdd", "times", "reportCameraYUVRendererCostPerFrame", "reportRendererTypeChangeCount", "reportServiceRendererCostPerFrame", "reportWhileFinish", "reportYUVRendererCostPerFrame", "Companion", "plugin-voip_release"})
public final class i
{
  public static final i.a NYd;
  public long NXP = -1L;
  public long NXQ = -1L;
  public long NXT = -1L;
  public long NXU = -1L;
  public int NXX = -1;
  public int NXY = -1;
  public int NXZ = -1;
  public long NYb = -1L;
  public long NYc = -1L;
  
  static
  {
    AppMethodBeat.i(242127);
    NYd = new i.a((byte)0);
    AppMethodBeat.o(242127);
  }
  
  private final void gCN()
  {
    AppMethodBeat.i(242125);
    this.NXP += 1L;
    this.NXQ += 1L;
    f localf;
    if (this.NXP > 0L)
    {
      localf = f.NXN;
      f.SK(this.NXP);
    }
    if (this.NXQ > 0L)
    {
      localf = f.NXN;
      f.SL(this.NXQ);
    }
    this.NXP = -1L;
    this.NXQ = -1L;
    AppMethodBeat.o(242125);
  }
  
  public final void ba(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(242122);
    f localf;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.NYb != -1L)
        {
          localf = f.NXN;
          f.Ta(Util.ticksToNow(this.NYb));
          this.NYb = -1L;
          AppMethodBeat.o(242122);
        }
      }
      else
      {
        if (this.NXT != -1L)
        {
          localf = f.NXN;
          f.Ta(Util.ticksToNow(this.NXT));
          this.NXT = -1L;
        }
        AppMethodBeat.o(242122);
      }
    }
    else if (paramBoolean2)
    {
      if (this.NYc != -1L)
      {
        localf = f.NXN;
        f.Tb(Util.ticksToNow(this.NYc));
        this.NYc = -1L;
        AppMethodBeat.o(242122);
      }
    }
    else if (this.NXU != -1L)
    {
      localf = f.NXN;
      f.Tb(Util.ticksToNow(this.NXU));
      this.NXU = -1L;
    }
    AppMethodBeat.o(242122);
  }
  
  public final void bb(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(242123);
    f localf;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.NYb != -1L)
        {
          localf = f.NXN;
          f.SY(Util.ticksToNow(this.NYb));
          this.NYb = -1L;
          AppMethodBeat.o(242123);
        }
      }
      else
      {
        if (this.NXT != -1L)
        {
          localf = f.NXN;
          f.SO(Util.ticksToNow(this.NXT));
          this.NXT = -1L;
        }
        AppMethodBeat.o(242123);
      }
    }
    else if (paramBoolean2)
    {
      if (this.NYc != -1L)
      {
        localf = f.NXN;
        f.SZ(Util.ticksToNow(this.NYc));
        this.NYc = -1L;
        AppMethodBeat.o(242123);
      }
    }
    else if (this.NXU != -1L)
    {
      localf = f.NXN;
      f.SP(Util.ticksToNow(this.NXU));
      this.NXU = -1L;
    }
    AppMethodBeat.o(242123);
  }
  
  public final void gCP()
  {
    AppMethodBeat.i(242120);
    f localf = f.NXN;
    f.gCC();
    gCN();
    AppMethodBeat.o(242120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c.i
 * JD-Core Version:    0.7.0.1
 */