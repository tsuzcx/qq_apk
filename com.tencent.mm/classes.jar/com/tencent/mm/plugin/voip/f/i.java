package com.tencent.mm.plugin.voip.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.d.c;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReport;", "", "()V", "addRendererViewInFullScreenWindowsTimes", "", "addRendererViewInFullScreenWindowsTimesInvite", "addRendererViewInMiniScreenWindowsTimes", "addRendererViewInMiniScreenWindowsTimesInvite", "changeToFullScreenCount", "", "changeToHWCount", "changeToMiniScreenCount", "changeToSWCount", "mCameraRenderFrameCount", "mServiceRenderFrameCount", "mYuvRenderFrameCount", "onDecModeChanged", "", "mode", "onFrameDrawCost", "cost", "type", "isFullScreen", "", "isFaceBeauty", "onRendererDrawPerFrameEndAfterAddView", "isInvite", "onRendererDrawPerFrameEndAfterAddViewAfterInit", "onRendererViewAdd", "times", "onWindowTypeChanged", "reportCameraRendererCostPerFrame", "reportRendererTypeChangeCount", "reportRendererWindowTypePercent", "reportServiceRendererCostPerFrame", "reportWhileFinish", "reportYUVRendererCostPerFrame", "Companion", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final a ULP;
  public long ULQ = -1L;
  public long ULR = -1L;
  private int ULS = -1;
  private int ULT = -1;
  public long ULU = -1L;
  public long ULV = -1L;
  public long ULW = -1L;
  public long ULX = -1L;
  public int ULY = -1;
  public int ULZ = -1;
  public int UMa = -1;
  
  static
  {
    AppMethodBeat.i(292578);
    ULP = new a((byte)0);
    AppMethodBeat.o(292578);
  }
  
  public static final void GO(boolean paramBoolean)
  {
    AppMethodBeat.i(292573);
    if (paramBoolean)
    {
      localj = j.UMb;
      j.ibW();
      AppMethodBeat.o(292573);
      return;
    }
    j localj = j.UMb;
    j.ibV();
    AppMethodBeat.o(292573);
  }
  
  public static final void are(int paramInt)
  {
    AppMethodBeat.i(292566);
    a.are(paramInt);
    AppMethodBeat.o(292566);
  }
  
  private final void ibL()
  {
    AppMethodBeat.i(292542);
    this.ULQ += 1L;
    this.ULR += 1L;
    j localj;
    if (this.ULQ > 0L)
    {
      localj = j.UMb;
      j.xa(this.ULQ);
    }
    if (this.ULR > 0L)
    {
      localj = j.UMb;
      j.xb(this.ULR);
    }
    this.ULQ = -1L;
    this.ULR = -1L;
    AppMethodBeat.o(292542);
  }
  
  private final void ibM()
  {
    AppMethodBeat.i(292549);
    this.ULS += 1;
    this.ULT += 1;
    int i = this.ULS + this.ULT;
    if (i != 0)
    {
      j localj;
      if (this.ULS > 0)
      {
        localj = j.UMb;
        j.xc(this.ULS * 100 / i);
      }
      if (this.ULT > 0)
      {
        localj = j.UMb;
        j.xd(this.ULT * 100 / i);
      }
    }
    this.ULS = -1;
    this.ULT = -1;
    AppMethodBeat.o(292549);
  }
  
  public static final void ibO()
  {
    AppMethodBeat.i(292558);
    j localj = j.UMb;
    j.ibQ();
    AppMethodBeat.o(292558);
  }
  
  public final void ard(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.ULT += 1;
      return;
    }
    this.ULS += 1;
  }
  
  public final void bu(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = 0L;
    AppMethodBeat.i(292601);
    Object localObject;
    long l2;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.ULW != -1L)
        {
          localObject = j.UMb;
          j.xq(Util.ticksToNow(this.ULW));
          localObject = c.UGb;
          localObject = c.hZG();
          l2 = Util.ticksToNow(this.ULW);
          if (SubCoreVoip.hVp().Uxh == 0L) {}
          for (;;)
          {
            ((ConcurrentLinkedQueue)localObject).add(new r(Long.valueOf(l2), Long.valueOf(l1)));
            this.ULW = -1L;
            AppMethodBeat.o(292601);
            return;
            l1 = Util.secondsToNow(SubCoreVoip.hVp().Uxh);
          }
        }
      }
      else if (this.ULU != -1L)
      {
        localObject = j.UMb;
        j.xq(Util.ticksToNow(this.ULU));
        localObject = c.UGb;
        localObject = c.hZG();
        l2 = Util.ticksToNow(this.ULU);
        if (SubCoreVoip.hVp().Uxh == 0L) {}
        for (;;)
        {
          ((ConcurrentLinkedQueue)localObject).add(new r(Long.valueOf(l2), Long.valueOf(l1)));
          this.ULU = -1L;
          AppMethodBeat.o(292601);
          return;
          l1 = Util.secondsToNow(SubCoreVoip.hVp().Uxh);
        }
      }
    }
    else if (paramBoolean2)
    {
      if (this.ULX != -1L)
      {
        localObject = j.UMb;
        j.xr(Util.ticksToNow(this.ULX));
        localObject = c.UGb;
        localObject = c.hZF();
        l2 = Util.ticksToNow(this.ULX);
        if (SubCoreVoip.hVp().Uxh == 0L) {}
        for (;;)
        {
          ((ConcurrentLinkedQueue)localObject).add(new r(Long.valueOf(l2), Long.valueOf(l1)));
          this.ULX = -1L;
          AppMethodBeat.o(292601);
          return;
          l1 = Util.secondsToNow(SubCoreVoip.hVp().Uxh);
        }
      }
    }
    else if (this.ULV != -1L)
    {
      localObject = j.UMb;
      j.xr(Util.ticksToNow(this.ULV));
      localObject = c.UGb;
      localObject = c.hZF();
      l2 = Util.ticksToNow(this.ULV);
      if (SubCoreVoip.hVp().Uxh != 0L) {
        break label422;
      }
    }
    for (;;)
    {
      ((ConcurrentLinkedQueue)localObject).add(new r(Long.valueOf(l2), Long.valueOf(l1)));
      this.ULV = -1L;
      AppMethodBeat.o(292601);
      return;
      label422:
      l1 = Util.secondsToNow(SubCoreVoip.hVp().Uxh);
    }
  }
  
  public final void bv(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = 0L;
    AppMethodBeat.i(292610);
    Object localObject;
    long l2;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (this.ULW != -1L)
        {
          localObject = j.UMb;
          j.xo(Util.ticksToNow(this.ULW));
          localObject = c.UGb;
          localObject = c.hZG();
          l2 = Util.ticksToNow(this.ULW);
          if (SubCoreVoip.hVp().Uxh == 0L) {}
          for (;;)
          {
            ((ConcurrentLinkedQueue)localObject).add(new r(Long.valueOf(l2), Long.valueOf(l1)));
            this.ULW = -1L;
            AppMethodBeat.o(292610);
            return;
            l1 = Util.secondsToNow(SubCoreVoip.hVp().Uxh);
          }
        }
      }
      else if (this.ULU != -1L)
      {
        localObject = j.UMb;
        j.xe(Util.ticksToNow(this.ULU));
        localObject = c.UGb;
        localObject = c.hZG();
        l2 = Util.ticksToNow(this.ULU);
        if (SubCoreVoip.hVp().Uxh == 0L) {}
        for (;;)
        {
          ((ConcurrentLinkedQueue)localObject).add(new r(Long.valueOf(l2), Long.valueOf(l1)));
          this.ULU = -1L;
          AppMethodBeat.o(292610);
          return;
          l1 = Util.secondsToNow(SubCoreVoip.hVp().Uxh);
        }
      }
    }
    else if (paramBoolean2)
    {
      if (this.ULX != -1L)
      {
        localObject = j.UMb;
        j.xp(Util.ticksToNow(this.ULX));
        localObject = c.UGb;
        localObject = c.hZF();
        l2 = Util.ticksToNow(this.ULX);
        if (SubCoreVoip.hVp().Uxh == 0L) {}
        for (;;)
        {
          ((ConcurrentLinkedQueue)localObject).add(new r(Long.valueOf(l2), Long.valueOf(l1)));
          this.ULX = -1L;
          AppMethodBeat.o(292610);
          return;
          l1 = Util.secondsToNow(SubCoreVoip.hVp().Uxh);
        }
      }
    }
    else if (this.ULV != -1L)
    {
      localObject = j.UMb;
      j.xf(Util.ticksToNow(this.ULV));
      localObject = c.UGb;
      localObject = c.hZF();
      l2 = Util.ticksToNow(this.ULV);
      if (SubCoreVoip.hVp().Uxh != 0L) {
        break label422;
      }
    }
    for (;;)
    {
      ((ConcurrentLinkedQueue)localObject).add(new r(Long.valueOf(l2), Long.valueOf(l1)));
      this.ULV = -1L;
      AppMethodBeat.o(292610);
      return;
      label422:
      l1 = Util.secondsToNow(SubCoreVoip.hVp().Uxh);
    }
  }
  
  public final void ibN()
  {
    AppMethodBeat.i(292617);
    j localj = j.UMb;
    j.ibP();
    ibL();
    ibM();
    AppMethodBeat.o(292617);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/util/VoipRendererReport$Companion;", "", "()V", "reportBatteryAverage", "", "data", "", "type", "", "reportCameraOnError", "reportFaceBeautyAlgoException", "reportFaceBeautyUse", "reportNewRendererInitSucc", "isCamera", "", "reportPboSizeInit", "width", "height", "reportRendererModeChanged", "isManual", "reportRendererUse", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void GP(boolean paramBoolean)
    {
      AppMethodBeat.i(292709);
      if (paramBoolean)
      {
        localj = j.UMb;
        j.ibR();
        AppMethodBeat.o(292709);
        return;
      }
      j localj = j.UMb;
      j.ibS();
      AppMethodBeat.o(292709);
    }
    
    public static void are(int paramInt)
    {
      AppMethodBeat.i(292714);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(292714);
        return;
        j localj = j.UMb;
        j.ibT();
        AppMethodBeat.o(292714);
        return;
        localj = j.UMb;
        j.ibU();
      }
    }
    
    public static void arf(int paramInt)
    {
      AppMethodBeat.i(292723);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(292723);
        return;
        j localj = j.UMb;
        j.ibX();
        AppMethodBeat.o(292723);
        return;
        localj = j.UMb;
        j.ibY();
        AppMethodBeat.o(292723);
        return;
        localj = j.UMb;
        j.ibZ();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.f.i
 * JD-Core Version:    0.7.0.1
 */