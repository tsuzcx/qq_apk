package com.tencent.mm.plugin.vlog.ui.preview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoViewMgr;", "", "()V", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "currentSessionId", "", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "videoView", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoView;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "getPlayStatus", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "onUIDestroy", "onUIPause", "onUIResume", "playVideo", "sameParent", "setMute", "setVideoViewProp", "stopVideo", "detach", "Companion", "plugin-vlog_release"})
public final class a
{
  public static final a GOm;
  private boolean FHg;
  private String FHh;
  private boolean FHi;
  public boolean FHk;
  private b FHl;
  private boolean FHm;
  public VLogFakeVideoView GOk;
  private c GOl;
  public boolean guh;
  
  static
  {
    AppMethodBeat.i(111196);
    GOm = new a((byte)0);
    AppMethodBeat.o(111196);
  }
  
  public a()
  {
    AppMethodBeat.i(111195);
    this.FHl = new b(MMApplicationContext.getContext());
    AppMethodBeat.o(111195);
  }
  
  private final void H(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(111186);
    Object localObject1 = new StringBuilder("checkDetachVideoView, videoView:");
    Object localObject2 = this.GOk;
    int i;
    boolean bool;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", isPlay:");
      localObject2 = this.GOk;
      if (localObject2 == null) {
        break label229;
      }
      bool = ((VLogFakeVideoView)localObject2).isPlaying();
      label63:
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", parent:");
      localObject1 = this.GOk;
      if (localObject1 == null) {
        break label234;
      }
      localObject1 = ((VLogFakeVideoView)localObject1).getParent();
      label94:
      if (localObject1 == null) {
        break label240;
      }
      i = localObject1.hashCode();
      label105:
      localObject1 = ((StringBuilder)localObject2).append(i).append(", newParent:");
      if (paramViewGroup == null) {
        break label245;
      }
      i = paramViewGroup.hashCode();
      label127:
      Log.i("MicroMsg.VLogFakeVideoViewMgr", i + ", isPlayingVideoItem:" + this.FHi);
      localObject1 = this.GOk;
      if (localObject1 == null) {
        break label250;
      }
      localObject1 = ((VLogFakeVideoView)localObject1).getParent();
      label171:
      if ((localObject1 == null) || (I(paramViewGroup))) {
        break label280;
      }
      wb(false);
      paramViewGroup = this.GOk;
      if (paramViewGroup == null) {
        break label256;
      }
    }
    label256:
    for (paramViewGroup = paramViewGroup.getParent();; paramViewGroup = null)
    {
      if (paramViewGroup != null) {
        break label261;
      }
      paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(111186);
      throw paramViewGroup;
      i = 0;
      break;
      label229:
      bool = false;
      break label63;
      label234:
      localObject1 = null;
      break label94;
      label240:
      i = 0;
      break label105;
      label245:
      i = 0;
      break label127;
      label250:
      localObject1 = null;
      break label171;
    }
    label261:
    ((ViewGroup)paramViewGroup).removeView((View)this.GOk);
    this.GOl = null;
    label280:
    AppMethodBeat.o(111186);
  }
  
  private final boolean I(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(111187);
    Object localObject = this.GOk;
    if (localObject != null) {}
    for (localObject = ((VLogFakeVideoView)localObject).getParent();; localObject = null)
    {
      boolean bool = p.j(localObject, paramViewGroup);
      AppMethodBeat.o(111187);
      return bool;
    }
  }
  
  private final boolean e(c paramc)
  {
    if (paramc == null) {}
    c localc;
    do
    {
      do
      {
        return false;
      } while (paramc.systemRowid == 0L);
      localc = this.GOl;
    } while ((localc == null) || (localc.systemRowid != paramc.systemRowid));
    return true;
  }
  
  private final void fst()
  {
    AppMethodBeat.i(111191);
    Log.i("MicroMsg.VLogFakeVideoViewMgr", "setVideoViewProp, isMute:" + this.guh);
    VLogFakeVideoView localVLogFakeVideoView = this.GOk;
    if (localVLogFakeVideoView != null)
    {
      localVLogFakeVideoView.setMute(this.guh);
      AppMethodBeat.o(111191);
      return;
    }
    AppMethodBeat.o(111191);
  }
  
  private final void hm(Context paramContext)
  {
    AppMethodBeat.i(111188);
    Log.i("MicroMsg.VLogFakeVideoViewMgr", "initCreateVideoView");
    this.GOk = new VLogFakeVideoView(paramContext, null, 2);
    this.FHi = false;
    AppMethodBeat.o(111188);
  }
  
  public final void PF()
  {
    AppMethodBeat.i(111190);
    Log.printInfoStack("MicroMsg.VLogFakeVideoViewMgr", "playVideo, " + this.FHg + ' ' + this.FHk + ", " + this.GOl, new Object[0]);
    fst();
    this.FHk = true;
    Object localObject;
    if (this.GOl != null)
    {
      boolean bool = this.FHg;
      this.FHg = false;
      if (!bool) {
        break label154;
      }
      localObject = this.GOk;
      if (localObject != null) {
        ((VLogFakeVideoView)localObject).setAlpha(1.0F);
      }
      localObject = this.GOk;
      if (localObject != null) {
        ((VLogFakeVideoView)localObject).b(this.GOl);
      }
    }
    for (;;)
    {
      this.FHg = false;
      this.FHi = true;
      if (!this.FHm)
      {
        this.FHl.requestFocus();
        this.FHm = true;
      }
      AppMethodBeat.o(111190);
      return;
      label154:
      this.FHh = UUID.randomUUID().toString();
      VLogFakeVideoView localVLogFakeVideoView = this.GOk;
      if (localVLogFakeVideoView != null)
      {
        c localc = this.GOl;
        localObject = localc;
        if (localc == null) {
          localObject = new c();
        }
        localVLogFakeVideoView.a((c)localObject);
      }
      localObject = this.GOk;
      if (localObject != null) {
        ((VLogFakeVideoView)localObject).setAlpha(0.0F);
      }
    }
  }
  
  public final void a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(111184);
    p.h(paramViewGroup, "parent");
    boolean bool = I(paramViewGroup);
    StringBuilder localStringBuilder = new StringBuilder("attachVideoView, parent:").append(paramViewGroup.hashCode()).append(", isVideoPause:").append(this.FHg).append(", currentSessionId:").append(this.FHh).append(", isPlayingVideoItem:").append(this.FHi).append(" videoView ");
    Object localObject = this.GOk;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((VLogFakeVideoView)localObject).hashCode());
      Log.i("MicroMsg.VLogFakeVideoViewMgr", localObject + " sameParent " + bool + " this:" + hashCode());
      H(paramViewGroup);
      if (this.GOk == null)
      {
        localObject = MMApplicationContext.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        hm((Context)localObject);
      }
      if (bool) {
        break label248;
      }
      Log.i("MicroMsg.VLogFakeVideoViewMgr", "addView layoutParams:".concat(String.valueOf(paramLayoutParams)));
      if (paramLayoutParams != null) {
        break label233;
      }
      paramViewGroup.addView((View)this.GOk);
    }
    for (;;)
    {
      paramViewGroup = this.GOk;
      if (paramViewGroup == null) {
        break label269;
      }
      paramViewGroup.setAlpha(0.0F);
      AppMethodBeat.o(111184);
      return;
      localObject = null;
      break;
      label233:
      paramViewGroup.addView((View)this.GOk, paramLayoutParams);
      continue;
      label248:
      if (paramLayoutParams != null)
      {
        paramViewGroup = this.GOk;
        if (paramViewGroup != null) {
          paramViewGroup.setLayoutParams(paramLayoutParams);
        }
      }
    }
    label269:
    AppMethodBeat.o(111184);
  }
  
  public final void a(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(111185);
    if (paramc == null)
    {
      AppMethodBeat.o(111185);
      return;
    }
    if (!e(paramc)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.VLogFakeVideoViewMgr", "change:" + bool + ' ' + this.FHk + ", " + paramBoolean + ", changeVideoItem: origin: " + this.GOl + ", new: " + paramc + ",  change:" + bool + " this:" + hashCode());
      if (bool)
      {
        this.GOl = paramc;
        if ((this.FHk) || (paramBoolean))
        {
          wb(false);
          PF();
        }
      }
      AppMethodBeat.o(111185);
      return;
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(111194);
    Log.i("MicroMsg.VLogFakeVideoViewMgr", "onUIDestroy " + hashCode());
    this.FHk = false;
    H(null);
    this.GOl = null;
    this.GOk = null;
    if (this.FHm)
    {
      this.FHl.apm();
      this.FHm = false;
    }
    AppMethodBeat.o(111194);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(111193);
    Log.i("MicroMsg.VLogFakeVideoViewMgr", "onUIPause " + hashCode());
    H(null);
    if (this.FHm)
    {
      this.FHl.apm();
      this.FHm = false;
    }
    AppMethodBeat.o(111193);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(111192);
    Log.i("MicroMsg.VLogFakeVideoViewMgr", "onUIResume " + hashCode());
    if (this.FHk)
    {
      VLogFakeVideoView localVLogFakeVideoView = this.GOk;
      if (localVLogFakeVideoView != null) {
        localVLogFakeVideoView.onUIResume();
      }
      if (!this.FHm)
      {
        this.FHl.requestFocus();
        this.FHm = true;
      }
    }
    AppMethodBeat.o(111192);
  }
  
  public final void wb(boolean paramBoolean)
  {
    AppMethodBeat.i(111189);
    Log.i("MicroMsg.VLogFakeVideoViewMgr", "stopVideo, detach: ".concat(String.valueOf(paramBoolean)));
    VLogFakeVideoView localVLogFakeVideoView = this.GOk;
    if (localVLogFakeVideoView != null) {
      localVLogFakeVideoView.setAlpha(0.0F);
    }
    if (this.FHi)
    {
      this.FHh = null;
      localVLogFakeVideoView = this.GOk;
      if (localVLogFakeVideoView != null) {
        localVLogFakeVideoView.stop();
      }
      this.FHg = false;
      if (this.FHm)
      {
        this.FHl.apm();
        this.FHm = false;
      }
      this.FHi = false;
    }
    if (paramBoolean)
    {
      this.FHk = false;
      H(null);
    }
    AppMethodBeat.o(111189);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoViewMgr$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.a
 * JD-Core Version:    0.7.0.1
 */