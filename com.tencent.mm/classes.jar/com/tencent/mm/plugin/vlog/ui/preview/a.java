package com.tencent.mm.plugin.vlog.ui.preview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;
import d.v;
import java.util.UUID;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoViewMgr;", "", "()V", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "currentSessionId", "", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "videoView", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoView;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "getPlayStatus", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "onUIDestroy", "onUIPause", "onUIResume", "playVideo", "sameParent", "setMute", "setVideoViewProp", "stopVideo", "detach", "Companion", "plugin-vlog_release"})
public final class a
{
  public static final a.a Clk;
  private b BwA;
  private boolean BwB;
  private boolean Bwv;
  private String Bww;
  private boolean Bwx;
  public boolean Bwz;
  public VLogFakeVideoView Cli;
  private c Clj;
  public boolean fOX;
  
  static
  {
    AppMethodBeat.i(111196);
    Clk = new a.a((byte)0);
    AppMethodBeat.o(111196);
  }
  
  public a()
  {
    AppMethodBeat.i(111195);
    this.BwA = new b(ak.getContext());
    AppMethodBeat.o(111195);
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
      localc = this.Clj;
    } while ((localc == null) || (localc.systemRowid != paramc.systemRowid));
    return true;
  }
  
  private final void epU()
  {
    AppMethodBeat.i(111191);
    ae.i("MicroMsg.VLogFakeVideoViewMgr", "setVideoViewProp, isMute:" + this.fOX);
    VLogFakeVideoView localVLogFakeVideoView = this.Cli;
    if (localVLogFakeVideoView != null)
    {
      localVLogFakeVideoView.setMute(this.fOX);
      AppMethodBeat.o(111191);
      return;
    }
    AppMethodBeat.o(111191);
  }
  
  private final void gB(Context paramContext)
  {
    AppMethodBeat.i(111188);
    ae.i("MicroMsg.VLogFakeVideoViewMgr", "initCreateVideoView");
    this.Cli = new VLogFakeVideoView(paramContext, null, 2);
    this.Bwx = false;
    AppMethodBeat.o(111188);
  }
  
  private final void y(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(111186);
    Object localObject1 = new StringBuilder("checkDetachVideoView, videoView:");
    Object localObject2 = this.Cli;
    int i;
    boolean bool;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", isPlay:");
      localObject2 = this.Cli;
      if (localObject2 == null) {
        break label229;
      }
      bool = ((VLogFakeVideoView)localObject2).isPlaying();
      label63:
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", parent:");
      localObject1 = this.Cli;
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
      ae.i("MicroMsg.VLogFakeVideoViewMgr", i + ", isPlayingVideoItem:" + this.Bwx);
      localObject1 = this.Cli;
      if (localObject1 == null) {
        break label250;
      }
      localObject1 = ((VLogFakeVideoView)localObject1).getParent();
      label171:
      if ((localObject1 == null) || (z(paramViewGroup))) {
        break label280;
      }
      sH(false);
      paramViewGroup = this.Cli;
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
      paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup");
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
    ((ViewGroup)paramViewGroup).removeView((View)this.Cli);
    this.Clj = null;
    label280:
    AppMethodBeat.o(111186);
  }
  
  private final boolean z(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(111187);
    Object localObject = this.Cli;
    if (localObject != null) {}
    for (localObject = ((VLogFakeVideoView)localObject).getParent();; localObject = null)
    {
      boolean bool = p.i(localObject, paramViewGroup);
      AppMethodBeat.o(111187);
      return bool;
    }
  }
  
  public final void FW()
  {
    AppMethodBeat.i(111190);
    ae.m("MicroMsg.VLogFakeVideoViewMgr", "playVideo, " + this.Bwv + ' ' + this.Bwz + ", " + this.Clj, new Object[0]);
    epU();
    this.Bwz = true;
    Object localObject;
    if (this.Clj != null)
    {
      boolean bool = this.Bwv;
      this.Bwv = false;
      if (!bool) {
        break label154;
      }
      localObject = this.Cli;
      if (localObject != null) {
        ((VLogFakeVideoView)localObject).setAlpha(1.0F);
      }
      localObject = this.Cli;
      if (localObject != null) {
        ((VLogFakeVideoView)localObject).b(this.Clj);
      }
    }
    for (;;)
    {
      this.Bwv = false;
      this.Bwx = true;
      if (!this.BwB)
      {
        this.BwA.requestFocus();
        this.BwB = true;
      }
      AppMethodBeat.o(111190);
      return;
      label154:
      this.Bww = UUID.randomUUID().toString();
      VLogFakeVideoView localVLogFakeVideoView = this.Cli;
      if (localVLogFakeVideoView != null)
      {
        c localc = this.Clj;
        localObject = localc;
        if (localc == null) {
          localObject = new c();
        }
        localVLogFakeVideoView.a((c)localObject);
      }
      localObject = this.Cli;
      if (localObject != null) {
        ((VLogFakeVideoView)localObject).setAlpha(0.0F);
      }
    }
  }
  
  public final void a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(111184);
    p.h(paramViewGroup, "parent");
    boolean bool = z(paramViewGroup);
    StringBuilder localStringBuilder = new StringBuilder("attachVideoView, parent:").append(paramViewGroup.hashCode()).append(", isVideoPause:").append(this.Bwv).append(", currentSessionId:").append(this.Bww).append(", isPlayingVideoItem:").append(this.Bwx).append(" videoView ");
    Object localObject = this.Cli;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((VLogFakeVideoView)localObject).hashCode());
      ae.i("MicroMsg.VLogFakeVideoViewMgr", localObject + " sameParent " + bool + " this:" + hashCode());
      y(paramViewGroup);
      if (this.Cli == null)
      {
        localObject = ak.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        gB((Context)localObject);
      }
      if (bool) {
        break label248;
      }
      ae.i("MicroMsg.VLogFakeVideoViewMgr", "addView layoutParams:".concat(String.valueOf(paramLayoutParams)));
      if (paramLayoutParams != null) {
        break label233;
      }
      paramViewGroup.addView((View)this.Cli);
    }
    for (;;)
    {
      paramViewGroup = this.Cli;
      if (paramViewGroup == null) {
        break label269;
      }
      paramViewGroup.setAlpha(0.0F);
      AppMethodBeat.o(111184);
      return;
      localObject = null;
      break;
      label233:
      paramViewGroup.addView((View)this.Cli, paramLayoutParams);
      continue;
      label248:
      if (paramLayoutParams != null)
      {
        paramViewGroup = this.Cli;
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
      ae.i("MicroMsg.VLogFakeVideoViewMgr", "change:" + bool + ' ' + this.Bwz + ", " + paramBoolean + ", changeVideoItem: origin: " + this.Clj + ", new: " + paramc + ",  change:" + bool + " this:" + hashCode());
      if (bool)
      {
        this.Clj = paramc;
        if ((this.Bwz) || (paramBoolean))
        {
          sH(false);
          FW();
        }
      }
      AppMethodBeat.o(111185);
      return;
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(111194);
    ae.i("MicroMsg.VLogFakeVideoViewMgr", "onUIDestroy " + hashCode());
    this.Bwz = false;
    y(null);
    this.Clj = null;
    this.Cli = null;
    if (this.BwB)
    {
      this.BwA.abn();
      this.BwB = false;
    }
    AppMethodBeat.o(111194);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(111193);
    ae.i("MicroMsg.VLogFakeVideoViewMgr", "onUIPause " + hashCode());
    y(null);
    if (this.BwB)
    {
      this.BwA.abn();
      this.BwB = false;
    }
    AppMethodBeat.o(111193);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(111192);
    ae.i("MicroMsg.VLogFakeVideoViewMgr", "onUIResume " + hashCode());
    if (this.Bwz)
    {
      VLogFakeVideoView localVLogFakeVideoView = this.Cli;
      if (localVLogFakeVideoView != null) {
        localVLogFakeVideoView.onUIResume();
      }
      if (!this.BwB)
      {
        this.BwA.requestFocus();
        this.BwB = true;
      }
    }
    AppMethodBeat.o(111192);
  }
  
  public final void sH(boolean paramBoolean)
  {
    AppMethodBeat.i(111189);
    ae.i("MicroMsg.VLogFakeVideoViewMgr", "stopVideo, detach: ".concat(String.valueOf(paramBoolean)));
    VLogFakeVideoView localVLogFakeVideoView = this.Cli;
    if (localVLogFakeVideoView != null) {
      localVLogFakeVideoView.setAlpha(0.0F);
    }
    if (this.Bwx)
    {
      this.Bww = null;
      localVLogFakeVideoView = this.Cli;
      if (localVLogFakeVideoView != null) {
        localVLogFakeVideoView.stop();
      }
      this.Bwv = false;
      if (this.BwB)
      {
        this.BwA.abn();
        this.BwB = false;
      }
      this.Bwx = false;
    }
    if (paramBoolean)
    {
      this.Bwz = false;
      y(null);
    }
    AppMethodBeat.o(111189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.a
 * JD-Core Version:    0.7.0.1
 */