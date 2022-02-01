package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Intent;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.plugin.vlog.player.c;
import com.tencent.mm.plugin.vlog.player.c.c;
import com.tencent.mm.plugin.vlog.player.c.f;
import com.tencent.mm.plugin.vlog.player.k;
import com.tencent.mm.plugin.vlog.ui.preview.VLogPreloadPlayView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewPlayerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "videoPreloadPlayView", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getPreviewHeight", "", "getPreviewWidth", "isRendering", "", "onDetach", "", "onPause", "onResume", "release", "renderScript", "model", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "setMute", "mute", "Companion", "plugin-vlog_release"})
public final class ag
  implements t
{
  public static final ag.a GIU;
  public VLogPreloadPlayView GIT;
  d wgr;
  
  static
  {
    AppMethodBeat.i(111167);
    GIU = new ag.a((byte)0);
    AppMethodBeat.o(111167);
  }
  
  public ag(VLogPreloadPlayView paramVLogPreloadPlayView, d paramd)
  {
    AppMethodBeat.i(111166);
    this.GIT = paramVLogPreloadPlayView;
    this.wgr = paramd;
    this.GIT.setOnSizeChangedListener((m)new ag.1(this));
    AppMethodBeat.o(111166);
  }
  
  public final void aSs() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(111165);
    Object localObject = this.GIT;
    c localc = ((VLogPreloadPlayView)localObject).GCP;
    if (localc != null) {
      localc.release();
    }
    localObject = ((VLogPreloadPlayView)localObject).GBp;
    if (localObject != null)
    {
      ((k)localObject).release();
      AppMethodBeat.o(111165);
      return;
    }
    AppMethodBeat.o(111165);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(111163);
    Object localObject1 = this.GIT;
    Log.i("MicroMsg.VLogPreloadPlayView", "pause");
    ((VLogPreloadPlayView)localObject1).GOq = false;
    Object localObject2 = ((VLogPreloadPlayView)localObject1).GCP;
    if (localObject2 != null)
    {
      k localk = ((c)localObject2).GBp;
      if (localk != null) {
        localk.j((a)new c.c((c)localObject2));
      }
    }
    localObject2 = ((VLogPreloadPlayView)localObject1).GOo;
    if (localObject2 != null) {
      ((MMHandler)localObject2).removeCallbacksAndMessages(null);
    }
    localObject1 = ((VLogPreloadPlayView)localObject1).GBp;
    if (localObject1 != null)
    {
      ((k)localObject1).fCo();
      AppMethodBeat.o(111163);
      return;
    }
    AppMethodBeat.o(111163);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191525);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191525);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(111162);
    VLogPreloadPlayView localVLogPreloadPlayView = this.GIT;
    Log.i("MicroMsg.VLogPreloadPlayView", "resume");
    localVLogPreloadPlayView.GOq = true;
    c localc = localVLogPreloadPlayView.GCP;
    if (localc != null)
    {
      k localk = localc.GBp;
      if (localk != null) {
        localk.j((a)new c.f(localc));
      }
    }
    localVLogPreloadPlayView.n(localVLogPreloadPlayView.ipT);
    AppMethodBeat.o(111162);
  }
  
  public final void release()
  {
    AppMethodBeat.i(111164);
    VLogPreloadPlayView localVLogPreloadPlayView = this.GIT;
    Object localObject = new StringBuilder("release  vLogDirector:").append(localVLogPreloadPlayView.GCP).append("  ");
    c localc = localVLogPreloadPlayView.GCP;
    if (localc != null) {}
    for (int i = localc.hashCode();; i = 0)
    {
      Log.i("MicroMsg.VLogPreloadPlayView", i);
      localObject = localVLogPreloadPlayView.GCP;
      if (localObject != null) {
        ((c)localObject).release();
      }
      localObject = localVLogPreloadPlayView.GBp;
      if (localObject != null) {
        ((k)localObject).release();
      }
      localObject = localVLogPreloadPlayView.GOo;
      if (localObject != null) {
        ((MMHandler)localObject).removeCallbacksAndMessages(null);
      }
      localVLogPreloadPlayView.GOn.quitSafely();
      localVLogPreloadPlayView.setSurfaceTextureListener(null);
      AppMethodBeat.o(111164);
      return;
    }
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.ag
 * JD-Core Version:    0.7.0.1
 */