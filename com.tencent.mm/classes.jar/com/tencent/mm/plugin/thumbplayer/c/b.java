package com.tencent.mm.plugin.thumbplayer.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ch;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.thumbplayer.b.b.h;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/thumbplayer/player/MMTPPlayer;", "Lcom/tencent/thumbplayer/tplayer/TPPlayer;", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "threadLooper", "Landroid/os/Looper;", "(Landroid/content/Context;Landroid/os/Looper;)V", "callbackLoop", "(Landroid/content/Context;Landroid/os/Looper;Landroid/os/Looper;)V", "TAG", "", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "inInitializing", "", "getInInitializing", "()Z", "setInInitializing", "(Z)V", "inPrepareAsync", "getInPrepareAsync", "setInPrepareAsync", "prepareCostTime", "", "getPrepareCostTime", "()J", "setPrepareCostTime", "(J)V", "startInitializedTimestamp", "getStartInitializedTimestamp", "setStartInitializedTimestamp", "stateChangeListenerProxy", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnStateChangeListener;", "stateListener", "prepareAsync", "", "reset", "resetData", "setDataSource", "pfd", "Landroid/os/ParcelFileDescriptor;", "mediaAsset", "Lcom/tencent/thumbplayer/api/composition/ITPMediaAsset;", "url", "httpHeader", "", "setMediaId", "mediaId", "setOnPlayerStateChangeListener", "listener", "stop", "plugin-thumbplayer_release"})
public final class b
  extends com.tencent.thumbplayer.g.a
  implements a
{
  boolean BHD;
  long BHE;
  boolean BHF;
  private b.h BHG;
  private b.h BHH;
  private final String TAG;
  String id;
  long rZa;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(211705);
    this.TAG = "MicroMsg.TP.MMTPPlayer";
    this.id = "";
    this.BHG = ((b.h)new a(this));
    super.a(this.BHG);
    AppMethodBeat.o(211705);
  }
  
  private final void Zq()
  {
    this.id = "";
    this.BHD = false;
    this.BHF = false;
    this.BHE = 0L;
    this.rZa = 0L;
  }
  
  public final void a(b.h paramh)
  {
    this.BHH = paramh;
  }
  
  public final void aEd(String paramString)
  {
    AppMethodBeat.i(211700);
    p.h(paramString, "mediaId");
    this.id = paramString;
    AppMethodBeat.o(211700);
  }
  
  public final long erO()
  {
    return this.rZa;
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(211702);
    if (!this.BHF)
    {
      this.BHF = true;
      super.prepareAsync();
      AppMethodBeat.o(211702);
      return;
    }
    ae.i(this.TAG, "already prepareAsync");
    AppMethodBeat.o(211702);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(211704);
    super.reset();
    Zq();
    AppMethodBeat.o(211704);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(211701);
    if (!this.BHD)
    {
      this.BHD = true;
      this.BHE = ch.aDc();
      super.setDataSource(paramString);
      AppMethodBeat.o(211701);
      return;
    }
    ae.i(this.TAG, "already setDataSource ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(211701);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(211703);
    super.stop();
    Zq();
    AppMethodBeat.o(211703);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "preState", "", "curState", "onStateChange"})
  static final class a
    implements b.h
  {
    a(b paramb) {}
    
    public final void fW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(211699);
      if (this.BHI.BHE > 0L) {
        ae.i(b.a(this.BHI), "state from:" + paramInt1 + " to:" + paramInt2 + " cost:" + (ch.aDc() - this.BHI.BHE) + " id:" + this.BHI.id);
      }
      switch (paramInt2)
      {
      }
      for (;;)
      {
        b.h localh = b.b(this.BHI);
        if (localh == null) {
          break;
        }
        localh.fW(paramInt1, paramInt2);
        AppMethodBeat.o(211699);
        return;
        this.BHI.BHD = false;
        continue;
        this.BHI.BHF = false;
        continue;
        this.BHI.rZa = (ch.aDc() - this.BHI.BHE);
      }
      AppMethodBeat.o(211699);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.b
 * JD-Core Version:    0.7.0.1
 */