package com.tencent.mm.plugin.thumbplayer.e;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.g.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/player/MMTPPlayer;", "Lcom/tencent/thumbplayer/tplayer/TPPlayer;", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "threadLooper", "Landroid/os/Looper;", "(Landroid/content/Context;Landroid/os/Looper;)V", "callbackLoop", "(Landroid/content/Context;Landroid/os/Looper;Landroid/os/Looper;)V", "TAG", "", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "inInitializing", "", "getInInitializing", "()Z", "setInInitializing", "(Z)V", "inPrepareAsync", "getInPrepareAsync", "setInPrepareAsync", "prepareCostTime", "", "getPrepareCostTime", "()J", "setPrepareCostTime", "(J)V", "startInitializedTimestamp", "getStartInitializedTimestamp", "setStartInitializedTimestamp", "stateChangeListenerProxy", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnStateChangeListener;", "stateListener", "prepareAsync", "", "reset", "resetData", "setDataSource", "pfd", "Landroid/os/ParcelFileDescriptor;", "mediaAsset", "Lcom/tencent/thumbplayer/api/composition/ITPMediaAsset;", "url", "httpHeader", "", "setMediaId", "mediaId", "setOnPlayerStateChangeListener", "listener", "stop", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends b
  implements a
{
  private long ANN;
  private final String TAG;
  private boolean TFF;
  private long TFG;
  private boolean TFH;
  private ITPPlayerListener.IOnStateChangeListener TFI;
  private ITPPlayerListener.IOnStateChangeListener TFJ;
  private String id;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(272127);
    this.TAG = s.X("MicroMsg.TP.MMTPPlayer@", Integer.valueOf(hashCode()));
    this.id = "";
    this.TFI = new c..ExternalSyntheticLambda0(this);
    super.setOnPlayerStateChangeListener(this.TFI);
    AppMethodBeat.o(272127);
  }
  
  private static final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(272144);
    s.u(paramc, "this$0");
    if (paramc.TFG > 0L) {
      Log.i(paramc.TAG, "state from:" + paramInt1 + " to:" + paramInt2 + " cost:" + (cn.bDw() - paramc.TFG) + " id:" + paramc.id);
    }
    switch (paramInt2)
    {
    }
    for (;;)
    {
      paramc = paramc.TFJ;
      if (paramc != null) {
        paramc.onStateChange(paramInt1, paramInt2);
      }
      AppMethodBeat.o(272144);
      return;
      paramc.TFF = false;
      continue;
      paramc.TFH = false;
      continue;
      paramc.ANN = (cn.bDw() - paramc.TFG);
    }
  }
  
  private final void aNm()
  {
    this.id = "";
    this.TFF = false;
    this.TFH = false;
    this.TFG = 0L;
    this.ANN = 0L;
  }
  
  public final long hLd()
  {
    return this.ANN;
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(272195);
    Log.i(this.TAG, "prepareAsync, inPrepareAsync:" + this.TFH + ", mediaId:" + this.id);
    if (!this.TFH)
    {
      this.TFH = true;
      super.prepareAsync();
      AppMethodBeat.o(272195);
      return;
    }
    Log.i(this.TAG, "already prepareAsync");
    AppMethodBeat.o(272195);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(272214);
    super.reset();
    aNm();
    AppMethodBeat.o(272214);
  }
  
  public final void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(272176);
    if (!this.TFF)
    {
      this.TFF = true;
      this.TFG = cn.bDw();
      super.setDataSource(paramParcelFileDescriptor);
      Log.d(this.TAG, "setDataSource");
      AppMethodBeat.o(272176);
      return;
    }
    Log.i(this.TAG, s.X("already setDataSource ", paramParcelFileDescriptor));
    AppMethodBeat.o(272176);
  }
  
  public final void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(272186);
    if (!this.TFF)
    {
      this.TFF = true;
      this.TFG = cn.bDw();
      super.setDataSource(paramITPMediaAsset);
      Log.d(this.TAG, "setDataSource");
      AppMethodBeat.o(272186);
      return;
    }
    Log.i(this.TAG, s.X("already setDataSource ", paramITPMediaAsset));
    AppMethodBeat.o(272186);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(272161);
    if (!this.TFF)
    {
      this.TFF = true;
      this.TFG = cn.bDw();
      super.setDataSource(paramString);
      Log.d(this.TAG, "setDataSource");
      AppMethodBeat.o(272161);
      return;
    }
    Log.i(this.TAG, s.X("already setDataSource ", paramString));
    AppMethodBeat.o(272161);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(272168);
    if (!this.TFF)
    {
      this.TFF = true;
      this.TFG = cn.bDw();
      super.setDataSource(paramString, paramMap);
      Log.d(this.TAG, "setDataSource");
      AppMethodBeat.o(272168);
      return;
    }
    Log.i(this.TAG, s.X("already setDataSource ", paramString));
    AppMethodBeat.o(272168);
  }
  
  public final void setMediaId(String paramString)
  {
    AppMethodBeat.i(272154);
    s.u(paramString, "mediaId");
    this.id = paramString;
    Log.d(this.TAG, "setMediaId");
    AppMethodBeat.o(272154);
  }
  
  public final void setOnPlayerStateChangeListener(ITPPlayerListener.IOnStateChangeListener paramIOnStateChangeListener)
  {
    this.TFJ = paramIOnStateChangeListener;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(272203);
    super.stop();
    aNm();
    AppMethodBeat.o(272203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.e.c
 * JD-Core Version:    0.7.0.1
 */