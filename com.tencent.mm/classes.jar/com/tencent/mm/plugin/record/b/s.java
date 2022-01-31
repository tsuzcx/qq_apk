package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.h;
import com.tencent.mm.ai.h.a;
import com.tencent.mm.ai.h.b;
import com.tencent.mm.ai.i;
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

public final class s
  implements h.a, h.b, SensorController.a
{
  public static SensorController mub;
  public List<s.a> callbacks;
  private int cve;
  long lastShakeTime;
  public h mtU;
  private boolean mtV;
  private boolean mtW;
  private boolean mtX;
  private bf mtY;
  public String path;
  
  public s()
  {
    AppMethodBeat.i(24180);
    this.mtV = true;
    this.mtX = false;
    this.lastShakeTime = -1L;
    this.callbacks = new LinkedList();
    this.mtU = ((i)com.tencent.mm.kernel.g.E(i.class)).BP();
    aw.aaz();
    Boolean localBoolean = (Boolean)c.Ru().get(26, Boolean.FALSE);
    this.mtW = localBoolean.booleanValue();
    boolean bool;
    if (!localBoolean.booleanValue())
    {
      bool = true;
      this.mtV = bool;
      if (this.mtU == null) {
        break label219;
      }
      this.mtU.a(this);
      this.mtU.a(this);
      if ((!com.tencent.mm.compatible.b.g.KC().KN()) && (!com.tencent.mm.compatible.b.g.KC().KH())) {
        break label203;
      }
      this.mtU.bx(false);
    }
    for (;;)
    {
      if (mub == null) {
        mub = new SensorController(ah.getContext());
      }
      if (this.mtY == null) {
        this.mtY = new bf(ah.getContext());
      }
      AppMethodBeat.o(24180);
      return;
      bool = false;
      break;
      label203:
      this.mtU.bx(this.mtV);
      continue;
      label219:
      ab.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
  }
  
  public final void Es()
  {
    AppMethodBeat.i(24185);
    ab.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
    stopPlay();
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((s.a)localIterator.next()).onFinish();
    }
    AppMethodBeat.o(24185);
  }
  
  public final void bwC()
  {
    AppMethodBeat.i(24186);
    if (mub != null) {
      mub.dtJ();
    }
    if (this.mtY != null) {
      this.mtY.dtK();
    }
    AppMethodBeat.o(24186);
  }
  
  public final boolean bwz()
  {
    AppMethodBeat.i(24182);
    if (this.mtU == null)
    {
      ab.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
      AppMethodBeat.o(24182);
      return false;
    }
    boolean bool = this.mtU.isPlaying();
    AppMethodBeat.o(24182);
    return bool;
  }
  
  public final void hv(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(24187);
    if (bo.isNullOrNil(this.path))
    {
      AppMethodBeat.o(24187);
      return;
    }
    if (this.mtX)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.mtX = paramBoolean;
        AppMethodBeat.o(24187);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bo.av(this.lastShakeTime) > 400L))
    {
      this.mtX = true;
      AppMethodBeat.o(24187);
      return;
    }
    this.mtX = false;
    if ((this.mtU != null) && (this.mtU.Ep()))
    {
      AppMethodBeat.o(24187);
      return;
    }
    if (this.mtW)
    {
      if (this.mtU != null) {
        this.mtU.bx(false);
      }
      this.mtV = false;
      AppMethodBeat.o(24187);
      return;
    }
    if ((this.mtU != null) && (!this.mtU.isPlaying()))
    {
      this.mtU.bx(true);
      this.mtV = true;
      AppMethodBeat.o(24187);
      return;
    }
    if (this.mtU != null) {
      this.mtU.bx(paramBoolean);
    }
    this.mtV = paramBoolean;
    if (!paramBoolean) {
      startPlay(this.path, this.cve);
    }
    AppMethodBeat.o(24187);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(24184);
    ab.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
    stopPlay();
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((s.a)localIterator.next()).onFinish();
    }
    AppMethodBeat.o(24184);
  }
  
  public final boolean startPlay(String paramString, int paramInt)
  {
    AppMethodBeat.i(24181);
    if (this.mtU == null)
    {
      ab.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(24181);
      return false;
    }
    this.mtU.stop();
    Object localObject = this.callbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((s.a)((Iterator)localObject).next()).XT(paramString);
    }
    if ((mub != null) && (!mub.yqq))
    {
      mub.a(this);
      localObject = new s.1(this);
      if (!this.mtY.ai((Runnable)localObject)) {
        break label187;
      }
    }
    label187:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.cve = paramInt;
      if ((bo.isNullOrNil(paramString)) || (!this.mtU.a(paramString, this.mtV, true, paramInt))) {
        break;
      }
      aj.apk("keep_app_silent");
      AppMethodBeat.o(24181);
      return true;
    }
    AppMethodBeat.o(24181);
    return false;
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(24183);
    ab.d("MicroMsg.RecordVoiceHelper", "stop play");
    aj.apl("keep_app_silent");
    if (this.mtU != null) {
      this.mtU.stop();
    }
    bwC();
    AppMethodBeat.o(24183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.s
 * JD-Core Version:    0.7.0.1
 */