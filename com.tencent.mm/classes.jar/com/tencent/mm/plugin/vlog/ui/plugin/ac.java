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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.a.a;
import d.g.a.m;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewPlayerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "videoPreloadPlayView", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getPreviewHeight", "", "getPreviewWidth", "isRendering", "", "onDetach", "", "onPause", "onResume", "release", "renderScript", "model", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "setMute", "mute", "Companion", "plugin-vlog_release"})
public final class ac
  implements t
{
  public static final ac.a BOD;
  public VLogPreloadPlayView BOC;
  d sQE;
  
  static
  {
    AppMethodBeat.i(111167);
    BOD = new ac.a((byte)0);
    AppMethodBeat.o(111167);
  }
  
  public ac(VLogPreloadPlayView paramVLogPreloadPlayView, d paramd)
  {
    AppMethodBeat.i(111166);
    this.BOC = paramVLogPreloadPlayView;
    this.sQE = paramd;
    this.BOC.setOnSizeChangedListener((m)new ac.1(this));
    AppMethodBeat.o(111166);
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach()
  {
    AppMethodBeat.i(111165);
    Object localObject = this.BOC;
    c localc = ((VLogPreloadPlayView)localObject).BJC;
    if (localc != null) {
      localc.release();
    }
    localObject = ((VLogPreloadPlayView)localObject).BId;
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
    Object localObject1 = this.BOC;
    ad.i("MicroMsg.VLogPreloadPlayView", "pause");
    ((VLogPreloadPlayView)localObject1).BTN = false;
    Object localObject2 = ((VLogPreloadPlayView)localObject1).BJC;
    if (localObject2 != null)
    {
      k localk = ((c)localObject2).BId;
      if (localk != null) {
        localk.h((a)new c.c((c)localObject2));
      }
    }
    localObject2 = ((VLogPreloadPlayView)localObject1).BTL;
    if (localObject2 != null) {
      ((ap)localObject2).removeCallbacksAndMessages(null);
    }
    localObject1 = ((VLogPreloadPlayView)localObject1).BId;
    if (localObject1 != null)
    {
      ((k)localObject1).esI();
      AppMethodBeat.o(111163);
      return;
    }
    AppMethodBeat.o(111163);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(196395);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(196395);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(111162);
    VLogPreloadPlayView localVLogPreloadPlayView = this.BOC;
    ad.i("MicroMsg.VLogPreloadPlayView", "resume");
    localVLogPreloadPlayView.BTN = true;
    c localc = localVLogPreloadPlayView.BJC;
    if (localc != null)
    {
      k localk = localc.BId;
      if (localk != null) {
        localk.h((a)new c.f(localc));
      }
    }
    localVLogPreloadPlayView.l(localVLogPreloadPlayView.htD);
    AppMethodBeat.o(111162);
  }
  
  public final void release()
  {
    AppMethodBeat.i(111164);
    VLogPreloadPlayView localVLogPreloadPlayView = this.BOC;
    Object localObject = new StringBuilder("release  vLogDirector:").append(localVLogPreloadPlayView.BJC).append("  ");
    c localc = localVLogPreloadPlayView.BJC;
    if (localc != null) {}
    for (int i = localc.hashCode();; i = 0)
    {
      ad.i("MicroMsg.VLogPreloadPlayView", i);
      localObject = localVLogPreloadPlayView.BJC;
      if (localObject != null) {
        ((c)localObject).release();
      }
      localObject = localVLogPreloadPlayView.BId;
      if (localObject != null) {
        ((k)localObject).release();
      }
      localObject = localVLogPreloadPlayView.BTL;
      if (localObject != null) {
        ((ap)localObject).removeCallbacksAndMessages(null);
      }
      localVLogPreloadPlayView.BTK.quitSafely();
      localVLogPreloadPlayView.setSurfaceTextureListener(null);
      AppMethodBeat.o(111164);
      return;
    }
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.ac
 * JD-Core Version:    0.7.0.1
 */