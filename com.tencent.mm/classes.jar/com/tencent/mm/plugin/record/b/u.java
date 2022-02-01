package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.h;
import com.tencent.mm.al.h.a;
import com.tencent.mm.al.h.b;
import com.tencent.mm.al.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class u
  implements h.a, h.b, SensorController.a
{
  public static SensorController pyv;
  public List<a> callbacks;
  private int dtc;
  long lastShakeTime;
  public String path;
  public h pyq;
  private boolean pyr;
  private boolean pys;
  private boolean pyt;
  private bk pyu;
  
  public u()
  {
    AppMethodBeat.i(27818);
    this.pyr = true;
    this.pyt = false;
    this.lastShakeTime = -1L;
    this.callbacks = new LinkedList();
    this.pyq = ((i)g.ab(i.class)).MS();
    ba.aBQ();
    Boolean localBoolean = (Boolean)c.ajl().get(26, Boolean.FALSE);
    this.pys = localBoolean.booleanValue();
    boolean bool;
    if (!localBoolean.booleanValue())
    {
      bool = true;
      this.pyr = bool;
      if (this.pyq == null) {
        break label213;
      }
      this.pyq.a(this);
      this.pyq.a(this);
      if ((!a.bGx()) && (!a.bGD())) {
        break label197;
      }
      this.pyq.cm(false);
    }
    for (;;)
    {
      if (pyv == null) {
        pyv = new SensorController(aj.getContext());
      }
      if (this.pyu == null) {
        this.pyu = new bk(aj.getContext());
      }
      AppMethodBeat.o(27818);
      return;
      bool = false;
      break;
      label197:
      this.pyq.cm(this.pyr);
      continue;
      label213:
      ad.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
  }
  
  public final boolean cQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(27819);
    if (this.pyq == null)
    {
      ad.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(27819);
      return false;
    }
    this.pyq.stop();
    Object localObject = this.callbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).avs(paramString);
    }
    if ((pyv != null) && (!pyv.aMy))
    {
      pyv.a(this);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27817);
          u.this.lastShakeTime = bt.HI();
          AppMethodBeat.o(27817);
        }
      };
      if (!this.pyu.aD((Runnable)localObject)) {
        break label186;
      }
    }
    label186:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.dtc = paramInt;
      if ((bt.isNullOrNil(paramString)) || (!this.pyq.a(paramString, this.pyr, true, paramInt))) {
        break;
      }
      an.aQu("keep_app_silent");
      AppMethodBeat.o(27819);
      return true;
    }
    AppMethodBeat.o(27819);
    return false;
  }
  
  public final void cfB()
  {
    AppMethodBeat.i(27824);
    if (pyv != null) {
      pyv.flC();
    }
    if (this.pyu != null) {
      this.pyu.flD();
    }
    AppMethodBeat.o(27824);
  }
  
  public final boolean cfC()
  {
    AppMethodBeat.i(27820);
    if (this.pyq == null)
    {
      ad.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
      AppMethodBeat.o(27820);
      return false;
    }
    boolean bool = this.pyq.isPlaying();
    AppMethodBeat.o(27820);
    return bool;
  }
  
  public final void kn(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(27825);
    if (bt.isNullOrNil(this.path))
    {
      AppMethodBeat.o(27825);
      return;
    }
    if (this.pyt)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.pyt = paramBoolean;
        AppMethodBeat.o(27825);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bt.aO(this.lastShakeTime) > 400L))
    {
      this.pyt = true;
      AppMethodBeat.o(27825);
      return;
    }
    this.pyt = false;
    if ((this.pyq != null) && (this.pyq.PD()))
    {
      AppMethodBeat.o(27825);
      return;
    }
    if (this.pys)
    {
      if (this.pyq != null) {
        this.pyq.cm(false);
      }
      this.pyr = false;
      AppMethodBeat.o(27825);
      return;
    }
    if ((this.pyq != null) && (!this.pyq.isPlaying()))
    {
      this.pyq.cm(true);
      this.pyr = true;
      AppMethodBeat.o(27825);
      return;
    }
    if (this.pyq != null) {
      this.pyq.cm(paramBoolean);
    }
    this.pyr = paramBoolean;
    if (!paramBoolean) {
      cQ(this.path, this.dtc);
    }
    AppMethodBeat.o(27825);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(27823);
    ad.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
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
    ad.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
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
    ad.d("MicroMsg.RecordVoiceHelper", "stop play");
    an.aQv("keep_app_silent");
    if (this.pyq != null) {
      this.pyq.stop();
    }
    cfB();
    AppMethodBeat.o(27821);
  }
  
  public static abstract interface a
  {
    public abstract void avs(String paramString);
    
    public abstract void onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.u
 * JD-Core Version:    0.7.0.1
 */