package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReport;", "", "()V", "addRendererViewInFullScreenWindowsTimes", "", "addRendererViewInFullScreenWindowsTimesInvite", "addRendererViewInMiniScreenWindowsTimes", "addRendererViewInMiniScreenWindowsTimesInvite", "changeToFullScreenCount", "", "changeToHWCount", "changeToMiniScreenCount", "changeToSWCount", "mCameraRenderFrameCount", "mServiceRenderFrameCount", "mYuvRenderFrameCount", "onDecModeChanged", "", "mode", "onFrameDrawCost", "cost", "type", "isFullScreen", "", "isFaceBeauty", "onRendererDrawPerFrameEndAfterAddView", "isInvite", "onRendererDrawPerFrameEndAfterAddViewAfterInit", "onRendererViewAdd", "times", "onWindowTypeChanged", "reportCameraRendererCostPerFrame", "reportRendererTypeChangeCount", "reportRendererWindowTypePercent", "reportServiceRendererCostPerFrame", "reportWhileFinish", "reportYUVRendererCostPerFrame", "Companion", "plugin-voip_release"})
public final class f
{
  public static final a ztz;
  public long zto = -1L;
  public long ztp = -1L;
  private int ztq = -1;
  private int ztr = -1;
  public long zts = -1L;
  public long ztt = -1L;
  public long ztu = -1L;
  public long ztv = -1L;
  public int ztw = -1;
  public int ztx = -1;
  public int zty = -1;
  
  static
  {
    AppMethodBeat.i(192325);
    ztz = new a((byte)0);
    AppMethodBeat.o(192325);
  }
  
  public static final void QF(int paramInt)
  {
    AppMethodBeat.i(192327);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(192327);
      return;
      h localh = h.ztD;
      h.dWD();
      AppMethodBeat.o(192327);
      return;
      localh = h.ztD;
      h.dWE();
    }
  }
  
  private final void dWv()
  {
    AppMethodBeat.i(192322);
    this.zto += 1L;
    this.ztp += 1L;
    h localh;
    if (this.zto > 0L)
    {
      localh = h.ztD;
      h.ur(this.zto);
    }
    if (this.ztp > 0L)
    {
      localh = h.ztD;
      h.us(this.ztp);
    }
    this.zto = -1L;
    this.ztp = -1L;
    AppMethodBeat.o(192322);
  }
  
  private final void dWw()
  {
    AppMethodBeat.i(192323);
    this.ztq += 1;
    this.ztr += 1;
    int i = this.ztq + this.ztr;
    if (i != 0)
    {
      h localh;
      if (this.ztq > 0)
      {
        localh = h.ztD;
        h.uL(this.ztq * 100 / i);
      }
      if (this.ztr > 0)
      {
        localh = h.ztD;
        h.uM(this.ztr * 100 / i);
      }
    }
    this.ztq = -1;
    this.ztr = -1;
    AppMethodBeat.o(192323);
  }
  
  public static final void dWy()
  {
    AppMethodBeat.i(192326);
    h localh = h.ztD;
    h.dWA();
    AppMethodBeat.o(192326);
  }
  
  public static final void rQ(boolean paramBoolean)
  {
    AppMethodBeat.i(192328);
    if (paramBoolean)
    {
      localh = h.ztD;
      h.dWG();
      AppMethodBeat.o(192328);
      return;
    }
    h localh = h.ztD;
    h.dWF();
    AppMethodBeat.o(192328);
  }
  
  public final void QE(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.ztr += 1;
      return;
    }
    this.ztq += 1;
  }
  
  public final void as(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192320);
    h localh;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.ztu != -1L)
        {
          localh = h.ztD;
          h.uH(bt.aS(this.ztu));
          this.ztu = -1L;
          AppMethodBeat.o(192320);
        }
      }
      else
      {
        if (this.zts != -1L)
        {
          localh = h.ztD;
          h.uH(bt.aS(this.zts));
          this.zts = -1L;
        }
        AppMethodBeat.o(192320);
      }
    }
    else if (paramBoolean2)
    {
      if (this.ztv != -1L)
      {
        localh = h.ztD;
        h.uI(bt.aS(this.ztv));
        this.ztv = -1L;
        AppMethodBeat.o(192320);
      }
    }
    else if (this.ztt != -1L)
    {
      localh = h.ztD;
      h.uI(bt.aS(this.ztt));
      this.ztt = -1L;
    }
    AppMethodBeat.o(192320);
  }
  
  public final void at(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192321);
    h localh;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.ztu != -1L)
        {
          localh = h.ztD;
          h.uF(bt.aS(this.ztu));
          this.ztu = -1L;
          AppMethodBeat.o(192321);
        }
      }
      else
      {
        if (this.zts != -1L)
        {
          localh = h.ztD;
          h.uv(bt.aS(this.zts));
          this.zts = -1L;
        }
        AppMethodBeat.o(192321);
      }
    }
    else if (paramBoolean2)
    {
      if (this.ztv != -1L)
      {
        localh = h.ztD;
        h.uG(bt.aS(this.ztv));
        this.ztv = -1L;
        AppMethodBeat.o(192321);
      }
    }
    else if (this.ztt != -1L)
    {
      localh = h.ztD;
      h.uw(bt.aS(this.ztt));
      this.ztt = -1L;
    }
    AppMethodBeat.o(192321);
  }
  
  public final void dWx()
  {
    AppMethodBeat.i(192324);
    h localh = h.ztD;
    h.dWz();
    dWv();
    dWw();
    AppMethodBeat.o(192324);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReport$Companion;", "", "()V", "reportBatteryAverage", "", "data", "", "type", "", "reportCameraOnError", "reportFaceBeautyAlgoException", "reportFaceBeautyUse", "reportNewRendererInitSucc", "isCamera", "", "reportPboSizeInit", "width", "height", "reportRendererModeChanged", "isManual", "reportRendererUse", "plugin-voip_release"})
  public static final class a
  {
    public static void QG(int paramInt)
    {
      AppMethodBeat.i(192317);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(192317);
        return;
        h localh = h.ztD;
        h.dWH();
        AppMethodBeat.o(192317);
        return;
        localh = h.ztD;
        h.dWI();
        AppMethodBeat.o(192317);
        return;
        localh = h.ztD;
        h.dWJ();
      }
    }
    
    public static void QH(int paramInt)
    {
      AppMethodBeat.i(192318);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(192318);
        return;
        h localh = h.ztD;
        h.dWK();
        AppMethodBeat.o(192318);
        return;
        localh = h.ztD;
        h.dWL();
      }
    }
    
    public static void Y(long paramLong, int paramInt)
    {
      AppMethodBeat.i(192319);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(192319);
        return;
        h localh = h.ztD;
        h.uu(paramLong);
        AppMethodBeat.o(192319);
        return;
        localh = h.ztD;
        h.ut(paramLong);
      }
    }
    
    public static void rR(boolean paramBoolean)
    {
      AppMethodBeat.i(192316);
      if (paramBoolean)
      {
        localh = h.ztD;
        h.dWB();
        AppMethodBeat.o(192316);
        return;
      }
      h localh = h.ztD;
      h.dWC();
      AppMethodBeat.o(192316);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.f
 * JD-Core Version:    0.7.0.1
 */