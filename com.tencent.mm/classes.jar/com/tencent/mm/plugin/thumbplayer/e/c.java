package com.tencent.mm.plugin.thumbplayer.e;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.g.b;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/thumbplayer/player/MMTPPlayer;", "Lcom/tencent/thumbplayer/tplayer/TPPlayer;", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "threadLooper", "Landroid/os/Looper;", "(Landroid/content/Context;Landroid/os/Looper;)V", "callbackLoop", "(Landroid/content/Context;Landroid/os/Looper;Landroid/os/Looper;)V", "TAG", "", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "inInitializing", "", "getInInitializing", "()Z", "setInInitializing", "(Z)V", "inPrepareAsync", "getInPrepareAsync", "setInPrepareAsync", "prepareCostTime", "", "getPrepareCostTime", "()J", "setPrepareCostTime", "(J)V", "startInitializedTimestamp", "getStartInitializedTimestamp", "setStartInitializedTimestamp", "stateChangeListenerProxy", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnStateChangeListener;", "stateListener", "prepareAsync", "", "reset", "resetData", "setDataSource", "pfd", "Landroid/os/ParcelFileDescriptor;", "mediaAsset", "Lcom/tencent/thumbplayer/api/composition/ITPMediaAsset;", "url", "httpHeader", "", "setMediaId", "mediaId", "setOnPlayerStateChangeListener", "listener", "stop", "plugin-thumbplayer_release"})
public final class c
  extends b
  implements a
{
  boolean GhT;
  long GhU;
  boolean GhV;
  private ITPPlayerListener.IOnStateChangeListener GhW;
  private ITPPlayerListener.IOnStateChangeListener GhX;
  private final String TAG;
  String id;
  long tHR;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(238746);
    this.TAG = "MicroMsg.TP.MMTPPlayer";
    this.id = "";
    this.GhW = ((ITPPlayerListener.IOnStateChangeListener)new a(this));
    super.setOnPlayerStateChangeListener(this.GhW);
    AppMethodBeat.o(238746);
  }
  
  private final void and()
  {
    this.id = "";
    this.GhT = false;
    this.GhV = false;
    this.GhU = 0L;
    this.tHR = 0L;
  }
  
  public final long fwS()
  {
    return this.tHR;
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(238743);
    if (!this.GhV)
    {
      this.GhV = true;
      super.prepareAsync();
      AppMethodBeat.o(238743);
      return;
    }
    Log.i(this.TAG, "already prepareAsync");
    AppMethodBeat.o(238743);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(238745);
    super.reset();
    and();
    AppMethodBeat.o(238745);
  }
  
  public final void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(238741);
    if (!this.GhT)
    {
      this.GhT = true;
      this.GhU = cl.aWA();
      super.setDataSource(paramParcelFileDescriptor);
      Log.d(this.TAG, "setDataSource");
      AppMethodBeat.o(238741);
      return;
    }
    Log.i(this.TAG, "already setDataSource ".concat(String.valueOf(paramParcelFileDescriptor)));
    AppMethodBeat.o(238741);
  }
  
  public final void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(238742);
    if (!this.GhT)
    {
      this.GhT = true;
      this.GhU = cl.aWA();
      super.setDataSource(paramITPMediaAsset);
      Log.d(this.TAG, "setDataSource");
      AppMethodBeat.o(238742);
      return;
    }
    Log.i(this.TAG, "already setDataSource ".concat(String.valueOf(paramITPMediaAsset)));
    AppMethodBeat.o(238742);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(238739);
    if (!this.GhT)
    {
      this.GhT = true;
      this.GhU = cl.aWA();
      super.setDataSource(paramString);
      Log.d(this.TAG, "setDataSource");
      AppMethodBeat.o(238739);
      return;
    }
    Log.i(this.TAG, "already setDataSource ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(238739);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(238740);
    if (!this.GhT)
    {
      this.GhT = true;
      this.GhU = cl.aWA();
      super.setDataSource(paramString, paramMap);
      Log.d(this.TAG, "setDataSource");
      AppMethodBeat.o(238740);
      return;
    }
    Log.i(this.TAG, "already setDataSource ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(238740);
  }
  
  public final void setMediaId(String paramString)
  {
    AppMethodBeat.i(238738);
    p.h(paramString, "mediaId");
    this.id = paramString;
    Log.d(this.TAG, "setMediaId");
    AppMethodBeat.o(238738);
  }
  
  public final void setOnPlayerStateChangeListener(ITPPlayerListener.IOnStateChangeListener paramIOnStateChangeListener)
  {
    this.GhX = paramIOnStateChangeListener;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(238744);
    super.stop();
    and();
    AppMethodBeat.o(238744);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "preState", "", "curState", "onStateChange"})
  static final class a
    implements ITPPlayerListener.IOnStateChangeListener
  {
    a(c paramc) {}
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(238737);
      if (this.GhY.GhU > 0L) {
        Log.i(c.a(this.GhY), "state from:" + paramInt1 + " to:" + paramInt2 + " cost:" + (cl.aWA() - this.GhY.GhU) + " id:" + this.GhY.id);
      }
      switch (paramInt2)
      {
      }
      for (;;)
      {
        ITPPlayerListener.IOnStateChangeListener localIOnStateChangeListener = c.b(this.GhY);
        if (localIOnStateChangeListener == null) {
          break;
        }
        localIOnStateChangeListener.onStateChange(paramInt1, paramInt2);
        AppMethodBeat.o(238737);
        return;
        this.GhY.GhT = false;
        continue;
        this.GhY.GhV = false;
        continue;
        this.GhY.tHR = (cl.aWA() - this.GhY.GhU);
      }
      AppMethodBeat.o(238737);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.e.c
 * JD-Core Version:    0.7.0.1
 */