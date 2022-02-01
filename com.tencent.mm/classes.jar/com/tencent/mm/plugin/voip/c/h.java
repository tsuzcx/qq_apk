package com.tencent.mm.plugin.voip.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReport;", "", "()V", "addRendererViewInFullScreenWindowsTimes", "", "addRendererViewInFullScreenWindowsTimesInvite", "addRendererViewInMiniScreenWindowsTimes", "addRendererViewInMiniScreenWindowsTimesInvite", "changeToFullScreenCount", "", "changeToHWCount", "changeToMiniScreenCount", "changeToSWCount", "mCameraRenderFrameCount", "mServiceRenderFrameCount", "mYuvRenderFrameCount", "onDecModeChanged", "", "mode", "onFrameDrawCost", "cost", "type", "isFullScreen", "", "isFaceBeauty", "onRendererDrawPerFrameEndAfterAddView", "isInvite", "onRendererDrawPerFrameEndAfterAddViewAfterInit", "onRendererViewAdd", "times", "onWindowTypeChanged", "reportCameraRendererCostPerFrame", "reportRendererTypeChangeCount", "reportRendererWindowTypePercent", "reportServiceRendererCostPerFrame", "reportWhileFinish", "reportYUVRendererCostPerFrame", "Companion", "plugin-voip_release"})
public final class h
{
  public static final a NYa;
  public long NXP = -1L;
  public long NXQ = -1L;
  private int NXR = -1;
  private int NXS = -1;
  public long NXT = -1L;
  public long NXU = -1L;
  public long NXV = -1L;
  public long NXW = -1L;
  public int NXX = -1;
  public int NXY = -1;
  public int NXZ = -1;
  
  static
  {
    AppMethodBeat.i(233431);
    NYa = new a((byte)0);
    AppMethodBeat.o(233431);
  }
  
  public static final void Bk(boolean paramBoolean)
  {
    AppMethodBeat.i(233435);
    if (paramBoolean)
    {
      localj = j.NYe;
      j.gCY();
      AppMethodBeat.o(233435);
      return;
    }
    j localj = j.NYe;
    j.gCX();
    AppMethodBeat.o(233435);
  }
  
  public static final void alw(int paramInt)
  {
    AppMethodBeat.i(233433);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(233433);
      return;
      j localj = j.NYe;
      j.gCV();
      AppMethodBeat.o(233433);
      return;
      localj = j.NYe;
      j.gCW();
    }
  }
  
  private final void gCN()
  {
    AppMethodBeat.i(233425);
    this.NXP += 1L;
    this.NXQ += 1L;
    j localj;
    if (this.NXP > 0L)
    {
      localj = j.NYe;
      j.SK(this.NXP);
    }
    if (this.NXQ > 0L)
    {
      localj = j.NYe;
      j.SL(this.NXQ);
    }
    this.NXP = -1L;
    this.NXQ = -1L;
    AppMethodBeat.o(233425);
  }
  
  private final void gCO()
  {
    AppMethodBeat.i(233427);
    this.NXR += 1;
    this.NXS += 1;
    int i = this.NXR + this.NXS;
    if (i != 0)
    {
      j localj;
      if (this.NXR > 0)
      {
        localj = j.NYe;
        j.Te(this.NXR * 100 / i);
      }
      if (this.NXS > 0)
      {
        localj = j.NYe;
        j.Tf(this.NXS * 100 / i);
      }
    }
    this.NXR = -1;
    this.NXS = -1;
    AppMethodBeat.o(233427);
  }
  
  public static final void gCQ()
  {
    AppMethodBeat.i(233432);
    j localj = j.NYe;
    j.gCS();
    AppMethodBeat.o(233432);
  }
  
  public final void alv(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.NXS += 1;
      return;
    }
    this.NXR += 1;
  }
  
  public final void ba(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = 0L;
    AppMethodBeat.i(233419);
    Object localObject;
    long l2;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.NXV != -1L)
        {
          localObject = j.NYe;
          j.Ta(Util.ticksToNow(this.NXV));
          localObject = a.NTi;
          localObject = a.gBC();
          l2 = Util.ticksToNow(this.NXV);
          if (c.gxs().NKx == 0L) {}
          for (;;)
          {
            ((ArrayList)localObject).add(new o(Long.valueOf(l2), Long.valueOf(l1)));
            this.NXV = -1L;
            AppMethodBeat.o(233419);
            return;
            l1 = Util.secondsToNow(c.gxs().NKx);
          }
        }
      }
      else
      {
        if (this.NXT != -1L)
        {
          localObject = j.NYe;
          j.Ta(Util.ticksToNow(this.NXT));
          localObject = a.NTi;
          localObject = a.gBC();
          l2 = Util.ticksToNow(this.NXT);
          if (c.gxs().NKx != 0L) {
            break label210;
          }
        }
        for (;;)
        {
          ((ArrayList)localObject).add(new o(Long.valueOf(l2), Long.valueOf(l1)));
          this.NXT = -1L;
          AppMethodBeat.o(233419);
          return;
          label210:
          l1 = Util.secondsToNow(c.gxs().NKx);
        }
      }
    }
    else if (paramBoolean2)
    {
      if (this.NXW != -1L)
      {
        localObject = j.NYe;
        j.Tb(Util.ticksToNow(this.NXW));
        localObject = a.NTi;
        localObject = a.gBB();
        l2 = Util.ticksToNow(this.NXW);
        if (c.gxs().NKx == 0L) {}
        for (;;)
        {
          ((ArrayList)localObject).add(new o(Long.valueOf(l2), Long.valueOf(l1)));
          this.NXW = -1L;
          AppMethodBeat.o(233419);
          return;
          l1 = Util.secondsToNow(c.gxs().NKx);
        }
      }
    }
    else if (this.NXU != -1L)
    {
      localObject = j.NYe;
      j.Tb(Util.ticksToNow(this.NXU));
      localObject = a.NTi;
      localObject = a.gBB();
      l2 = Util.ticksToNow(this.NXU);
      if (c.gxs().NKx != 0L) {
        break label422;
      }
    }
    for (;;)
    {
      ((ArrayList)localObject).add(new o(Long.valueOf(l2), Long.valueOf(l1)));
      this.NXU = -1L;
      AppMethodBeat.o(233419);
      return;
      label422:
      l1 = Util.secondsToNow(c.gxs().NKx);
    }
  }
  
  public final void bb(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = 0L;
    AppMethodBeat.i(233423);
    Object localObject;
    long l2;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.NXV != -1L)
        {
          localObject = j.NYe;
          j.SY(Util.ticksToNow(this.NXV));
          localObject = a.NTi;
          localObject = a.gBC();
          l2 = Util.ticksToNow(this.NXV);
          if (c.gxs().NKx == 0L) {}
          for (;;)
          {
            ((ArrayList)localObject).add(new o(Long.valueOf(l2), Long.valueOf(l1)));
            this.NXV = -1L;
            AppMethodBeat.o(233423);
            return;
            l1 = Util.secondsToNow(c.gxs().NKx);
          }
        }
      }
      else
      {
        if (this.NXT != -1L)
        {
          localObject = j.NYe;
          j.SO(Util.ticksToNow(this.NXT));
          localObject = a.NTi;
          localObject = a.gBC();
          l2 = Util.ticksToNow(this.NXT);
          if (c.gxs().NKx != 0L) {
            break label210;
          }
        }
        for (;;)
        {
          ((ArrayList)localObject).add(new o(Long.valueOf(l2), Long.valueOf(l1)));
          this.NXT = -1L;
          AppMethodBeat.o(233423);
          return;
          label210:
          l1 = Util.secondsToNow(c.gxs().NKx);
        }
      }
    }
    else if (paramBoolean2)
    {
      if (this.NXW != -1L)
      {
        localObject = j.NYe;
        j.SZ(Util.ticksToNow(this.NXW));
        localObject = a.NTi;
        localObject = a.gBB();
        l2 = Util.ticksToNow(this.NXW);
        if (c.gxs().NKx == 0L) {}
        for (;;)
        {
          ((ArrayList)localObject).add(new o(Long.valueOf(l2), Long.valueOf(l1)));
          this.NXW = -1L;
          AppMethodBeat.o(233423);
          return;
          l1 = Util.secondsToNow(c.gxs().NKx);
        }
      }
    }
    else if (this.NXU != -1L)
    {
      localObject = j.NYe;
      j.SP(Util.ticksToNow(this.NXU));
      localObject = a.NTi;
      localObject = a.gBB();
      l2 = Util.ticksToNow(this.NXU);
      if (c.gxs().NKx != 0L) {
        break label422;
      }
    }
    for (;;)
    {
      ((ArrayList)localObject).add(new o(Long.valueOf(l2), Long.valueOf(l1)));
      this.NXU = -1L;
      AppMethodBeat.o(233423);
      return;
      label422:
      l1 = Util.secondsToNow(c.gxs().NKx);
    }
  }
  
  public final void gCP()
  {
    AppMethodBeat.i(233430);
    j localj = j.NYe;
    j.gCR();
    gCN();
    gCO();
    AppMethodBeat.o(233430);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReport$Companion;", "", "()V", "reportBatteryAverage", "", "data", "", "type", "", "reportCameraOnError", "reportFaceBeautyAlgoException", "reportFaceBeautyUse", "reportNewRendererInitSucc", "isCamera", "", "reportPboSizeInit", "width", "height", "reportRendererModeChanged", "isManual", "reportRendererUse", "plugin-voip_release"})
  public static final class a
  {
    public static void Bl(boolean paramBoolean)
    {
      AppMethodBeat.i(235268);
      if (paramBoolean)
      {
        localj = j.NYe;
        j.gCT();
        AppMethodBeat.o(235268);
        return;
      }
      j localj = j.NYe;
      j.gCU();
      AppMethodBeat.o(235268);
    }
    
    public static void aQ(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(235270);
      j localj = j.NYe;
      j.Tc(paramLong1);
      localj = j.NYe;
      j.Td(paramLong2);
      AppMethodBeat.o(235270);
    }
    
    public static void alx(int paramInt)
    {
      AppMethodBeat.i(235272);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(235272);
        return;
        j localj = j.NYe;
        j.gCZ();
        AppMethodBeat.o(235272);
        return;
        localj = j.NYe;
        j.gDa();
        AppMethodBeat.o(235272);
        return;
        localj = j.NYe;
        j.gDb();
      }
    }
    
    public static void aly(int paramInt)
    {
      AppMethodBeat.i(235274);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(235274);
        return;
        j localj = j.NYe;
        j.gDc();
        AppMethodBeat.o(235274);
        return;
        localj = j.NYe;
        j.gDd();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c.h
 * JD-Core Version:    0.7.0.1
 */