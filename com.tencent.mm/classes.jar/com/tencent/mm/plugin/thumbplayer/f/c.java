package com.tencent.mm.plugin.thumbplayer.f;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.g.b;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/player/MMTPPlayer;", "Lcom/tencent/thumbplayer/tplayer/TPPlayer;", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "threadLooper", "Landroid/os/Looper;", "(Landroid/content/Context;Landroid/os/Looper;)V", "callbackLoop", "(Landroid/content/Context;Landroid/os/Looper;Landroid/os/Looper;)V", "TAG", "", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "inInitializing", "", "getInInitializing", "()Z", "setInInitializing", "(Z)V", "inPrepareAsync", "getInPrepareAsync", "setInPrepareAsync", "prepareCostTime", "", "getPrepareCostTime", "()J", "setPrepareCostTime", "(J)V", "startInitializedTimestamp", "getStartInitializedTimestamp", "setStartInitializedTimestamp", "stateChangeListenerProxy", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnStateChangeListener;", "stateListener", "prepareAsync", "", "reset", "resetData", "setDataSource", "pfd", "Landroid/os/ParcelFileDescriptor;", "mediaAsset", "Lcom/tencent/thumbplayer/api/composition/ITPMediaAsset;", "url", "httpHeader", "", "setMediaId", "mediaId", "setOnPlayerStateChangeListener", "listener", "stop", "plugin-thumbplayer_release"})
public final class c
  extends b
  implements a
{
  boolean MTp;
  long MTq;
  boolean MTr;
  private ITPPlayerListener.IOnStateChangeListener MTs;
  private ITPPlayerListener.IOnStateChangeListener MTt;
  private final String TAG;
  String id;
  long xqA;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(192986);
    this.TAG = ("MicroMsg.TP.MMTPPlayer@" + hashCode());
    this.id = "";
    this.MTs = ((ITPPlayerListener.IOnStateChangeListener)new a(this));
    super.setOnPlayerStateChangeListener(this.MTs);
    AppMethodBeat.o(192986);
  }
  
  private final void ate()
  {
    this.id = "";
    this.MTp = false;
    this.MTr = false;
    this.MTq = 0L;
    this.xqA = 0L;
  }
  
  public final long goq()
  {
    return this.xqA;
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(192977);
    Log.i(this.TAG, "prepareAsync, inPrepareAsync:" + this.MTr + ", mediaId:" + this.id);
    if (!this.MTr)
    {
      this.MTr = true;
      super.prepareAsync();
      AppMethodBeat.o(192977);
      return;
    }
    Log.i(this.TAG, "already prepareAsync");
    AppMethodBeat.o(192977);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(192981);
    super.reset();
    ate();
    AppMethodBeat.o(192981);
  }
  
  public final void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(192972);
    if (!this.MTp)
    {
      this.MTp = true;
      this.MTq = cm.bfE();
      super.setDataSource(paramParcelFileDescriptor);
      Log.d(this.TAG, "setDataSource");
      AppMethodBeat.o(192972);
      return;
    }
    Log.i(this.TAG, "already setDataSource ".concat(String.valueOf(paramParcelFileDescriptor)));
    AppMethodBeat.o(192972);
  }
  
  public final void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(192974);
    if (!this.MTp)
    {
      this.MTp = true;
      this.MTq = cm.bfE();
      super.setDataSource(paramITPMediaAsset);
      Log.d(this.TAG, "setDataSource");
      AppMethodBeat.o(192974);
      return;
    }
    Log.i(this.TAG, "already setDataSource ".concat(String.valueOf(paramITPMediaAsset)));
    AppMethodBeat.o(192974);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(192967);
    if (!this.MTp)
    {
      this.MTp = true;
      this.MTq = cm.bfE();
      super.setDataSource(paramString);
      Log.d(this.TAG, "setDataSource");
      AppMethodBeat.o(192967);
      return;
    }
    Log.i(this.TAG, "already setDataSource ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(192967);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(192970);
    if (!this.MTp)
    {
      this.MTp = true;
      this.MTq = cm.bfE();
      super.setDataSource(paramString, paramMap);
      Log.d(this.TAG, "setDataSource");
      AppMethodBeat.o(192970);
      return;
    }
    Log.i(this.TAG, "already setDataSource ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(192970);
  }
  
  public final void setMediaId(String paramString)
  {
    AppMethodBeat.i(192963);
    p.k(paramString, "mediaId");
    this.id = paramString;
    Log.d(this.TAG, "setMediaId");
    AppMethodBeat.o(192963);
  }
  
  public final void setOnPlayerStateChangeListener(ITPPlayerListener.IOnStateChangeListener paramIOnStateChangeListener)
  {
    this.MTt = paramIOnStateChangeListener;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(192979);
    super.stop();
    ate();
    AppMethodBeat.o(192979);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "preState", "", "curState", "onStateChange"})
  static final class a
    implements ITPPlayerListener.IOnStateChangeListener
  {
    a(c paramc) {}
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(193069);
      if (this.MTu.MTq > 0L) {
        Log.i(c.a(this.MTu), "state from:" + paramInt1 + " to:" + paramInt2 + " cost:" + (cm.bfE() - this.MTu.MTq) + " id:" + this.MTu.id);
      }
      switch (paramInt2)
      {
      }
      for (;;)
      {
        ITPPlayerListener.IOnStateChangeListener localIOnStateChangeListener = c.b(this.MTu);
        if (localIOnStateChangeListener == null) {
          break;
        }
        localIOnStateChangeListener.onStateChange(paramInt1, paramInt2);
        AppMethodBeat.o(193069);
        return;
        this.MTu.MTp = false;
        continue;
        this.MTu.MTr = false;
        continue;
        this.MTu.xqA = (cm.bfE() - this.MTu.MTq);
      }
      AppMethodBeat.o(193069);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.f.c
 * JD-Core Version:    0.7.0.1
 */