package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.h;
import com.tencent.mm.ai.h.a;
import com.tencent.mm.ai.h.b;
import com.tencent.mm.ai.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class a
  implements h.a, h.b, SensorController.a
{
  public static volatile a vEk = null;
  public List<a.a> callbacks;
  private int cve;
  private long lastShakeTime;
  public h mtU;
  private boolean mtV;
  private boolean mtW;
  private boolean mtX;
  public bf mtY;
  public SensorController mub;
  public String path;
  
  private a()
  {
    AppMethodBeat.i(27198);
    this.mtV = true;
    this.mtX = false;
    this.lastShakeTime = -1L;
    this.callbacks = new LinkedList();
    this.mtU = ((i)g.E(i.class)).BP();
    aw.aaz();
    Boolean localBoolean = (Boolean)c.Ru().get(26, Boolean.FALSE);
    this.mtW = localBoolean.booleanValue();
    boolean bool;
    if (!localBoolean.booleanValue())
    {
      bool = true;
      this.mtV = bool;
      if (this.mtU == null) {
        break label190;
      }
      this.mtU.a(this);
      this.mtU.a(this);
      this.mtU.bx(this.mtV);
    }
    for (;;)
    {
      if (this.mub == null) {
        this.mub = new SensorController(ah.getContext());
      }
      if (this.mtY == null) {
        this.mtY = new bf(ah.getContext());
      }
      AppMethodBeat.o(27198);
      return;
      bool = false;
      break;
      label190:
      ab.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
  }
  
  private void bLl()
  {
    AppMethodBeat.i(27201);
    if ((this.mub != null) && (!this.mub.yqq))
    {
      this.mub.a(this);
      a.1 local1 = new a.1(this);
      if (this.mtY.ai(local1))
      {
        this.lastShakeTime = 0L;
        AppMethodBeat.o(27201);
        return;
      }
      this.lastShakeTime = -1L;
    }
    AppMethodBeat.o(27201);
  }
  
  private void bwC()
  {
    AppMethodBeat.i(27202);
    if (this.mub != null) {
      this.mub.dtJ();
    }
    if (this.mtY != null) {
      this.mtY.dtK();
    }
    AppMethodBeat.o(27202);
  }
  
  public static a djZ()
  {
    AppMethodBeat.i(27199);
    if (vEk == null) {}
    try
    {
      if (vEk == null) {
        vEk = new a();
      }
      a locala = vEk;
      AppMethodBeat.o(27199);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(27199);
    }
  }
  
  public final double Er()
  {
    AppMethodBeat.i(27206);
    if (this.mtU == null)
    {
      ab.w("MicroMsg.RecordVoiceHelper", "get now progress error, player is null");
      AppMethodBeat.o(27206);
      return 0.0D;
    }
    double d = this.mtU.Er();
    AppMethodBeat.o(27206);
    return d;
  }
  
  public final void Es()
  {
    AppMethodBeat.i(27208);
    ab.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
    stopPlay();
    AppMethodBeat.o(27208);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(27200);
    if (parama == null)
    {
      AppMethodBeat.o(27200);
      return;
    }
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      if (parama == (a.a)localIterator.next())
      {
        AppMethodBeat.o(27200);
        return;
      }
    }
    this.callbacks.add(parama);
    AppMethodBeat.o(27200);
  }
  
  public final boolean bwz()
  {
    AppMethodBeat.i(27205);
    if (this.mtU == null)
    {
      ab.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
      AppMethodBeat.o(27205);
      return false;
    }
    boolean bool = this.mtU.isPlaying();
    AppMethodBeat.o(27205);
    return bool;
  }
  
  public final void hv(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(27209);
    if (bo.isNullOrNil(this.path))
    {
      AppMethodBeat.o(27209);
      return;
    }
    if (this.mtX)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.mtX = paramBoolean;
        AppMethodBeat.o(27209);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bo.av(this.lastShakeTime) > 400L))
    {
      this.mtX = true;
      AppMethodBeat.o(27209);
      return;
    }
    this.mtX = false;
    if ((this.mtU != null) && (this.mtU.Ep()))
    {
      AppMethodBeat.o(27209);
      return;
    }
    if (this.mtW)
    {
      if (this.mtU != null) {
        this.mtU.bx(false);
      }
      this.mtV = false;
      AppMethodBeat.o(27209);
      return;
    }
    if ((this.mtU != null) && (!this.mtU.isPlaying()))
    {
      this.mtU.bx(true);
      this.mtV = true;
      AppMethodBeat.o(27209);
      return;
    }
    if (this.mtU != null) {
      this.mtU.bx(paramBoolean);
    }
    this.mtV = paramBoolean;
    if (!paramBoolean) {
      startPlay(this.path, this.cve);
    }
    AppMethodBeat.o(27209);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(27207);
    ab.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
    stopPlay();
    AppMethodBeat.o(27207);
  }
  
  public final boolean startPlay(String paramString, int paramInt)
  {
    AppMethodBeat.i(27203);
    if (this.mtU == null)
    {
      ab.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(27203);
      return false;
    }
    this.mtU.stop();
    bLl();
    this.path = paramString;
    this.cve = paramInt;
    if ((!bo.isNullOrNil(paramString)) && (this.mtU.a(paramString, this.mtV, true, paramInt)))
    {
      aj.apk("keep_app_silent");
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        a.a locala = (a.a)localIterator.next();
        if (locala != null) {
          locala.akb(paramString);
        }
      }
      AppMethodBeat.o(27203);
      return true;
    }
    AppMethodBeat.o(27203);
    return false;
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(27204);
    ab.i("MicroMsg.RecordVoiceHelper", "stop play");
    aj.apl("keep_app_silent");
    if (this.mtU != null)
    {
      this.mtU.stop();
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        a.a locala = (a.a)localIterator.next();
        if (locala != null) {
          locala.djY();
        }
      }
    }
    bwC();
    AppMethodBeat.o(27204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a
 * JD-Core Version:    0.7.0.1
 */