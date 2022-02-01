package com.tencent.mm.plugin.thumbplayer.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.thumbplayer.b.b.h;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/thumbplayer/player/MMTPPlayer;", "Lcom/tencent/thumbplayer/tplayer/TPPlayer;", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "threadLooper", "Landroid/os/Looper;", "(Landroid/content/Context;Landroid/os/Looper;)V", "callbackLoop", "(Landroid/content/Context;Landroid/os/Looper;Landroid/os/Looper;)V", "TAG", "", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "inInitializing", "", "getInInitializing", "()Z", "setInInitializing", "(Z)V", "inPrepareAsync", "getInPrepareAsync", "setInPrepareAsync", "prepareCostTime", "", "getPrepareCostTime", "()J", "setPrepareCostTime", "(J)V", "startInitializedTimestamp", "getStartInitializedTimestamp", "setStartInitializedTimestamp", "stateChangeListenerProxy", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnStateChangeListener;", "stateListener", "prepareAsync", "", "reset", "resetData", "setDataSource", "pfd", "Landroid/os/ParcelFileDescriptor;", "mediaAsset", "Lcom/tencent/thumbplayer/api/composition/ITPMediaAsset;", "url", "httpHeader", "", "setMediaId", "mediaId", "setOnPlayerStateChangeListener", "listener", "stop", "plugin-thumbplayer_release"})
public final class b
  extends com.tencent.thumbplayer.g.a
  implements a
{
  boolean Bqe;
  long Bqf;
  boolean Bqg;
  private b.h Bqh;
  private b.h Bqi;
  private final String TAG;
  String id;
  long rQy;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(217095);
    this.TAG = "MicroMsg.TP.MMTPPlayer";
    this.id = "";
    this.Bqh = ((b.h)new a(this));
    super.a(this.Bqh);
    AppMethodBeat.o(217095);
  }
  
  private final void Zh()
  {
    this.id = "";
    this.Bqe = false;
    this.Bqg = false;
    this.Bqf = 0L;
    this.rQy = 0L;
  }
  
  public final void a(b.h paramh)
  {
    this.Bqi = paramh;
  }
  
  public final void aCK(String paramString)
  {
    AppMethodBeat.i(217090);
    p.h(paramString, "mediaId");
    this.id = paramString;
    AppMethodBeat.o(217090);
  }
  
  public final long eoh()
  {
    return this.rQy;
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(217092);
    if (!this.Bqg)
    {
      this.Bqg = true;
      super.prepareAsync();
      AppMethodBeat.o(217092);
      return;
    }
    ad.i(this.TAG, "already prepareAsync");
    AppMethodBeat.o(217092);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(217094);
    super.reset();
    Zh();
    AppMethodBeat.o(217094);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(217091);
    if (!this.Bqe)
    {
      this.Bqe = true;
      this.Bqf = cf.aCM();
      super.setDataSource(paramString);
      AppMethodBeat.o(217091);
      return;
    }
    ad.i(this.TAG, "already setDataSource ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(217091);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(217093);
    super.stop();
    Zh();
    AppMethodBeat.o(217093);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "preState", "", "curState", "onStateChange"})
  static final class a
    implements b.h
  {
    a(b paramb) {}
    
    public final void fW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(217089);
      if (this.Bqj.Bqf > 0L) {
        ad.i(b.a(this.Bqj), "state from:" + paramInt1 + " to:" + paramInt2 + " cost:" + (cf.aCM() - this.Bqj.Bqf) + " id:" + this.Bqj.id);
      }
      switch (paramInt2)
      {
      }
      for (;;)
      {
        b.h localh = b.b(this.Bqj);
        if (localh == null) {
          break;
        }
        localh.fW(paramInt1, paramInt2);
        AppMethodBeat.o(217089);
        return;
        this.Bqj.Bqe = false;
        continue;
        this.Bqj.Bqg = false;
        continue;
        this.Bqj.rQy = (cf.aCM() - this.Bqj.Bqf);
      }
      AppMethodBeat.o(217089);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.b
 * JD-Core Version:    0.7.0.1
 */