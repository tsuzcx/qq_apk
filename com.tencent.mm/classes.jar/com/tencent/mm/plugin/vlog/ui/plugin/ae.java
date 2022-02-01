package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Intent;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import com.tencent.mm.plugin.vlog.player.c;
import com.tencent.mm.plugin.vlog.player.c.c;
import com.tencent.mm.plugin.vlog.player.c.f;
import com.tencent.mm.plugin.vlog.player.j;
import com.tencent.mm.plugin.vlog.ui.preview.VLogPreloadPlayView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewPlayerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "videoPreloadPlayView", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getPreviewHeight", "", "getPreviewWidth", "isRendering", "", "onDetach", "", "onPause", "onResume", "release", "renderScript", "model", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "setMute", "mute", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
  implements v
{
  public static final ae.a UjP;
  com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  public VLogPreloadPlayView UjQ;
  
  static
  {
    AppMethodBeat.i(111167);
    UjP = new ae.a((byte)0);
    AppMethodBeat.o(111167);
  }
  
  public ae(VLogPreloadPlayView paramVLogPreloadPlayView, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(111166);
    this.UjQ = paramVLogPreloadPlayView;
    this.GrC = parama;
    this.UjQ.setOnSizeChangedListener((m)new ae.1(this));
    AppMethodBeat.o(111166);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(282707);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(282707);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(282736);
    s.u(this, "this");
    AppMethodBeat.o(282736);
  }
  
  public final String name()
  {
    AppMethodBeat.i(282718);
    String str = v.a.b(this);
    AppMethodBeat.o(282718);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(282726);
    s.u(this, "this");
    AppMethodBeat.o(282726);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(282742);
    s.u(this, "this");
    AppMethodBeat.o(282742);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(111165);
    s.u((v)this, "this");
    Object localObject = this.UjQ;
    c localc = ((VLogPreloadPlayView)localObject).Uep;
    if (localc != null) {
      localc.release();
    }
    localObject = ((VLogPreloadPlayView)localObject).UcX;
    if (localObject != null) {
      ((j)localObject).release();
    }
    AppMethodBeat.o(111165);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(111163);
    s.u((v)this, "this");
    Object localObject1 = this.UjQ;
    Log.i("MicroMsg.VLogPreloadPlayView", "pause");
    ((VLogPreloadPlayView)localObject1).UoE = false;
    Object localObject2 = ((VLogPreloadPlayView)localObject1).Uep;
    if (localObject2 != null)
    {
      j localj = ((c)localObject2).UcX;
      if (localj != null) {
        localj.H((kotlin.g.a.a)new c.c((c)localObject2));
      }
    }
    localObject2 = ((VLogPreloadPlayView)localObject1).UoC;
    if (localObject2 != null) {
      ((MMHandler)localObject2).removeCallbacksAndMessages(null);
    }
    localObject1 = ((VLogPreloadPlayView)localObject1).UcX;
    if (localObject1 != null) {
      ((j)localObject1).hSc();
    }
    AppMethodBeat.o(111163);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(282751);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(282751);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(111162);
    s.u((v)this, "this");
    VLogPreloadPlayView localVLogPreloadPlayView = this.UjQ;
    Log.i("MicroMsg.VLogPreloadPlayView", "resume");
    localVLogPreloadPlayView.UoE = true;
    c localc = localVLogPreloadPlayView.Uep;
    if (localc != null)
    {
      j localj = localc.UcX;
      if (localj != null) {
        localj.H((kotlin.g.a.a)new c.f(localc));
      }
    }
    localVLogPreloadPlayView.s(localVLogPreloadPlayView.nwH);
    AppMethodBeat.o(111162);
  }
  
  public final void release()
  {
    AppMethodBeat.i(111164);
    s.u((v)this, "this");
    VLogPreloadPlayView localVLogPreloadPlayView = this.UjQ;
    Object localObject = new StringBuilder("release  vLogDirector:").append(localVLogPreloadPlayView.Uep).append("  ");
    c localc = localVLogPreloadPlayView.Uep;
    if (localc != null) {}
    for (int i = localc.hashCode();; i = 0)
    {
      Log.i("MicroMsg.VLogPreloadPlayView", i);
      localObject = localVLogPreloadPlayView.Uep;
      if (localObject != null) {
        ((c)localObject).release();
      }
      localObject = localVLogPreloadPlayView.UcX;
      if (localObject != null) {
        ((j)localObject).release();
      }
      localObject = localVLogPreloadPlayView.UoC;
      if (localObject != null) {
        ((MMHandler)localObject).removeCallbacksAndMessages(null);
      }
      localVLogPreloadPlayView.UoB.quitSafely();
      localVLogPreloadPlayView.setSurfaceTextureListener(null);
      AppMethodBeat.o(111164);
      return;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(282756);
    s.u(this, "this");
    AppMethodBeat.o(282756);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(282767);
    s.u(this, "this");
    AppMethodBeat.o(282767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.ae
 * JD-Core Version:    0.7.0.1
 */