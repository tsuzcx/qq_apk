package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class u
  implements h.a, h.b, SensorController.a
{
  public static SensorController pEZ;
  public List<a> callbacks;
  private int dui;
  long lastShakeTime;
  public h pEU;
  private boolean pEV;
  private boolean pEW;
  private boolean pEX;
  private bl pEY;
  public String path;
  
  public u()
  {
    AppMethodBeat.i(27818);
    this.pEV = true;
    this.pEX = false;
    this.lastShakeTime = -1L;
    this.callbacks = new LinkedList();
    this.pEU = ((i)g.ab(i.class)).MN();
    bc.aCg();
    Boolean localBoolean = (Boolean)c.ajA().get(26, Boolean.FALSE);
    this.pEW = localBoolean.booleanValue();
    boolean bool;
    if (!localBoolean.booleanValue())
    {
      bool = true;
      this.pEV = bool;
      if (this.pEU == null) {
        break label213;
      }
      this.pEU.a(this);
      this.pEU.a(this);
      if ((!a.bHt()) && (!a.bHz())) {
        break label197;
      }
      this.pEU.cm(false);
    }
    for (;;)
    {
      if (pEZ == null) {
        pEZ = new SensorController(ak.getContext());
      }
      if (this.pEY == null) {
        this.pEY = new bl(ak.getContext());
      }
      AppMethodBeat.o(27818);
      return;
      bool = false;
      break;
      label197:
      this.pEU.cm(this.pEV);
      continue;
      label213:
      ae.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
  }
  
  public final boolean cU(String paramString, int paramInt)
  {
    AppMethodBeat.i(27819);
    if (this.pEU == null)
    {
      ae.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(27819);
      return false;
    }
    this.pEU.stop();
    Object localObject = this.callbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).awH(paramString);
    }
    if ((pEZ != null) && (!pEZ.aMy))
    {
      pEZ.a(this);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27817);
          u.this.lastShakeTime = bu.HQ();
          AppMethodBeat.o(27817);
        }
      };
      if (!this.pEY.aB((Runnable)localObject)) {
        break label186;
      }
    }
    label186:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.dui = paramInt;
      if ((bu.isNullOrNil(paramString)) || (!this.pEU.a(paramString, this.pEV, true, paramInt))) {
        break;
      }
      ao.aRR("keep_app_silent");
      AppMethodBeat.o(27819);
      return true;
    }
    AppMethodBeat.o(27819);
    return false;
  }
  
  public final void cgR()
  {
    AppMethodBeat.i(27824);
    if (pEZ != null) {
      pEZ.fpx();
    }
    if (this.pEY != null) {
      this.pEY.fpy();
    }
    AppMethodBeat.o(27824);
  }
  
  public final boolean cgS()
  {
    AppMethodBeat.i(27820);
    if (this.pEU == null)
    {
      ae.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
      AppMethodBeat.o(27820);
      return false;
    }
    boolean bool = this.pEU.isPlaying();
    AppMethodBeat.o(27820);
    return bool;
  }
  
  public final void km(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(27825);
    if (bu.isNullOrNil(this.path))
    {
      AppMethodBeat.o(27825);
      return;
    }
    if (this.pEX)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.pEX = paramBoolean;
        AppMethodBeat.o(27825);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bu.aO(this.lastShakeTime) > 400L))
    {
      this.pEX = true;
      AppMethodBeat.o(27825);
      return;
    }
    this.pEX = false;
    if ((this.pEU != null) && (this.pEU.PC()))
    {
      AppMethodBeat.o(27825);
      return;
    }
    if (this.pEW)
    {
      if (this.pEU != null) {
        this.pEU.cm(false);
      }
      this.pEV = false;
      AppMethodBeat.o(27825);
      return;
    }
    if ((this.pEU != null) && (!this.pEU.isPlaying()))
    {
      this.pEU.cm(true);
      this.pEV = true;
      AppMethodBeat.o(27825);
      return;
    }
    if (this.pEU != null) {
      this.pEU.cm(paramBoolean);
    }
    this.pEV = paramBoolean;
    if (!paramBoolean) {
      cU(this.path, this.dui);
    }
    AppMethodBeat.o(27825);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(27823);
    ae.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
    stopPlay();
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onFinish();
    }
    AppMethodBeat.o(27823);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(27822);
    ae.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
    stopPlay();
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onFinish();
    }
    AppMethodBeat.o(27822);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(27821);
    ae.d("MicroMsg.RecordVoiceHelper", "stop play");
    ao.aRS("keep_app_silent");
    if (this.pEU != null) {
      this.pEU.stop();
    }
    cgR();
    AppMethodBeat.o(27821);
  }
  
  public static abstract interface a
  {
    public abstract void awH(String paramString);
    
    public abstract void onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.u
 * JD-Core Version:    0.7.0.1
 */