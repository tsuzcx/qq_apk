package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReportPrev;", "", "()V", "addRendererViewInFullScreenWindowsTimes", "", "addRendererViewInFullScreenWindowsTimesInviteUI", "addRendererViewInMiniScreenWindowsTimes", "addRendererViewInMiniScreenWindowsTimesInviteUI", "changeToHWCount", "changeToSWCount", "mCameraRenderFrameCount", "", "mServiceRenderFrameCount", "mYuvRenderFrameCount", "onDecModeChanged", "", "mode", "onFrameDrawCost", "cost", "type", "isFullScreen", "", "isUseFaceBeauty", "onRendererDrawPerFrameEndAfterAddView", "isInviteUi", "onRendererDrawPerFrameEndAfterAddViewAfterInit", "onRendererViewAdd", "times", "reportCameraYUVRendererCostPerFrame", "reportRendererTypeChangeCount", "reportServiceRendererCostPerFrame", "reportWhileFinish", "reportYUVRendererCostPerFrame", "Companion", "plugin-voip_release"})
public final class g
{
  public static final a ztC;
  public long ztA = -1L;
  public long ztB = -1L;
  public long zto = -1L;
  public long ztp = -1L;
  public long zts = -1L;
  public long ztt = -1L;
  public int ztw = -1;
  public int ztx = -1;
  public int zty = -1;
  
  static
  {
    AppMethodBeat.i(192334);
    ztC = new a((byte)0);
    AppMethodBeat.o(192334);
  }
  
  private final void dWv()
  {
    AppMethodBeat.i(192333);
    this.zto += 1L;
    this.ztp += 1L;
    d locald;
    if (this.zto > 0L)
    {
      locald = d.ztm;
      d.ur(this.zto);
    }
    if (this.ztp > 0L)
    {
      locald = d.ztm;
      d.us(this.ztp);
    }
    this.zto = -1L;
    this.ztp = -1L;
    AppMethodBeat.o(192333);
  }
  
  public final void as(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192331);
    d locald;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.ztA != -1L)
        {
          locald = d.ztm;
          d.uH(bt.aS(this.ztA));
          this.ztA = -1L;
          AppMethodBeat.o(192331);
        }
      }
      else
      {
        if (this.zts != -1L)
        {
          locald = d.ztm;
          d.uH(bt.aS(this.zts));
          this.zts = -1L;
        }
        AppMethodBeat.o(192331);
      }
    }
    else if (paramBoolean2)
    {
      if (this.ztB != -1L)
      {
        locald = d.ztm;
        d.uI(bt.aS(this.ztB));
        this.ztB = -1L;
        AppMethodBeat.o(192331);
      }
    }
    else if (this.ztt != -1L)
    {
      locald = d.ztm;
      d.uI(bt.aS(this.ztt));
      this.ztt = -1L;
    }
    AppMethodBeat.o(192331);
  }
  
  public final void at(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192332);
    d locald;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.ztA != -1L)
        {
          locald = d.ztm;
          d.uF(bt.aS(this.ztA));
          this.ztA = -1L;
          AppMethodBeat.o(192332);
        }
      }
      else
      {
        if (this.zts != -1L)
        {
          locald = d.ztm;
          d.uv(bt.aS(this.zts));
          this.zts = -1L;
        }
        AppMethodBeat.o(192332);
      }
    }
    else if (paramBoolean2)
    {
      if (this.ztB != -1L)
      {
        locald = d.ztm;
        d.uG(bt.aS(this.ztB));
        this.ztB = -1L;
        AppMethodBeat.o(192332);
      }
    }
    else if (this.ztt != -1L)
    {
      locald = d.ztm;
      d.uw(bt.aS(this.ztt));
      this.ztt = -1L;
    }
    AppMethodBeat.o(192332);
  }
  
  public final void dWx()
  {
    AppMethodBeat.i(192330);
    d locald = d.ztm;
    d.dWt();
    dWv();
    AppMethodBeat.o(192330);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReportPrev$Companion;", "", "()V", "reportBatteryAverage", "", "data", "", "type", "", "plugin-voip_release"})
  public static final class a
  {
    public static void Y(long paramLong, int paramInt)
    {
      AppMethodBeat.i(192329);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(192329);
        return;
        d locald = d.ztm;
        d.uu(paramLong);
        AppMethodBeat.o(192329);
        return;
        locald = d.ztm;
        d.ut(paramLong);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.g
 * JD-Core Version:    0.7.0.1
 */