package com.tencent.mm.plugin.vlog.ui.preview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;
import d.v;
import java.util.UUID;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoViewMgr;", "", "()V", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "currentSessionId", "", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "videoView", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoView;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "getPlayStatus", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "onUIDestroy", "onUIPause", "onUIResume", "playVideo", "sameParent", "setMute", "setVideoViewProp", "stopVideo", "detach", "Companion", "plugin-vlog_release"})
public final class a
{
  public static final a.a BTJ;
  public VLogFakeVideoView BTH;
  private c BTI;
  private boolean BeX;
  private String BeY;
  private boolean BeZ;
  public boolean Bfb;
  private b Bfc;
  private boolean Bfd;
  public boolean fMP;
  
  static
  {
    AppMethodBeat.i(111196);
    BTJ = new a.a((byte)0);
    AppMethodBeat.o(111196);
  }
  
  public a()
  {
    AppMethodBeat.i(111195);
    this.Bfc = new b(aj.getContext());
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
      localc = this.BTI;
    } while ((localc == null) || (localc.systemRowid != paramc.systemRowid));
    return true;
  }
  
  private final void eml()
  {
    AppMethodBeat.i(111191);
    ad.i("MicroMsg.VLogFakeVideoViewMgr", "setVideoViewProp, isMute:" + this.fMP);
    VLogFakeVideoView localVLogFakeVideoView = this.BTH;
    if (localVLogFakeVideoView != null)
    {
      localVLogFakeVideoView.setMute(this.fMP);
      AppMethodBeat.o(111191);
      return;
    }
    AppMethodBeat.o(111191);
  }
  
  private final void gw(Context paramContext)
  {
    AppMethodBeat.i(111188);
    ad.i("MicroMsg.VLogFakeVideoViewMgr", "initCreateVideoView");
    this.BTH = new VLogFakeVideoView(paramContext, null, 2);
    this.BeZ = false;
    AppMethodBeat.o(111188);
  }
  
  private final void y(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(111186);
    Object localObject1 = new StringBuilder("checkDetachVideoView, videoView:");
    Object localObject2 = this.BTH;
    int i;
    boolean bool;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", isPlay:");
      localObject2 = this.BTH;
      if (localObject2 == null) {
        break label229;
      }
      bool = ((VLogFakeVideoView)localObject2).isPlaying();
      label63:
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", parent:");
      localObject1 = this.BTH;
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
      ad.i("MicroMsg.VLogFakeVideoViewMgr", i + ", isPlayingVideoItem:" + this.BeZ);
      localObject1 = this.BTH;
      if (localObject1 == null) {
        break label250;
      }
      localObject1 = ((VLogFakeVideoView)localObject1).getParent();
      label171:
      if ((localObject1 == null) || (z(paramViewGroup))) {
        break label280;
      }
      sA(false);
      paramViewGroup = this.BTH;
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
    ((ViewGroup)paramViewGroup).removeView((View)this.BTH);
    this.BTI = null;
    label280:
    AppMethodBeat.o(111186);
  }
  
  private final boolean z(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(111187);
    Object localObject = this.BTH;
    if (localObject != null) {}
    for (localObject = ((VLogFakeVideoView)localObject).getParent();; localObject = null)
    {
      boolean bool = p.i(localObject, paramViewGroup);
      AppMethodBeat.o(111187);
      return bool;
    }
  }
  
  public final void FQ()
  {
    AppMethodBeat.i(111190);
    ad.m("MicroMsg.VLogFakeVideoViewMgr", "playVideo, " + this.BeX + ' ' + this.Bfb + ", " + this.BTI, new Object[0]);
    eml();
    this.Bfb = true;
    Object localObject;
    if (this.BTI != null)
    {
      boolean bool = this.BeX;
      this.BeX = false;
      if (!bool) {
        break label154;
      }
      localObject = this.BTH;
      if (localObject != null) {
        ((VLogFakeVideoView)localObject).setAlpha(1.0F);
      }
      localObject = this.BTH;
      if (localObject != null) {
        ((VLogFakeVideoView)localObject).b(this.BTI);
      }
    }
    for (;;)
    {
      this.BeX = false;
      this.BeZ = true;
      if (!this.Bfd)
      {
        this.Bfc.requestFocus();
        this.Bfd = true;
      }
      AppMethodBeat.o(111190);
      return;
      label154:
      this.BeY = UUID.randomUUID().toString();
      VLogFakeVideoView localVLogFakeVideoView = this.BTH;
      if (localVLogFakeVideoView != null)
      {
        c localc = this.BTI;
        localObject = localc;
        if (localc == null) {
          localObject = new c();
        }
        localVLogFakeVideoView.a((c)localObject);
      }
      localObject = this.BTH;
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
    StringBuilder localStringBuilder = new StringBuilder("attachVideoView, parent:").append(paramViewGroup.hashCode()).append(", isVideoPause:").append(this.BeX).append(", currentSessionId:").append(this.BeY).append(", isPlayingVideoItem:").append(this.BeZ).append(" videoView ");
    Object localObject = this.BTH;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((VLogFakeVideoView)localObject).hashCode());
      ad.i("MicroMsg.VLogFakeVideoViewMgr", localObject + " sameParent " + bool + " this:" + hashCode());
      y(paramViewGroup);
      if (this.BTH == null)
      {
        localObject = aj.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        gw((Context)localObject);
      }
      if (bool) {
        break label248;
      }
      ad.i("MicroMsg.VLogFakeVideoViewMgr", "addView layoutParams:".concat(String.valueOf(paramLayoutParams)));
      if (paramLayoutParams != null) {
        break label233;
      }
      paramViewGroup.addView((View)this.BTH);
    }
    for (;;)
    {
      paramViewGroup = this.BTH;
      if (paramViewGroup == null) {
        break label269;
      }
      paramViewGroup.setAlpha(0.0F);
      AppMethodBeat.o(111184);
      return;
      localObject = null;
      break;
      label233:
      paramViewGroup.addView((View)this.BTH, paramLayoutParams);
      continue;
      label248:
      if (paramLayoutParams != null)
      {
        paramViewGroup = this.BTH;
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
      ad.i("MicroMsg.VLogFakeVideoViewMgr", "change:" + bool + ' ' + this.Bfb + ", " + paramBoolean + ", changeVideoItem: origin: " + this.BTI + ", new: " + paramc + ",  change:" + bool + " this:" + hashCode());
      if (bool)
      {
        this.BTI = paramc;
        if ((this.Bfb) || (paramBoolean))
        {
          sA(false);
          FQ();
        }
      }
      AppMethodBeat.o(111185);
      return;
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(111194);
    ad.i("MicroMsg.VLogFakeVideoViewMgr", "onUIDestroy " + hashCode());
    this.Bfb = false;
    y(null);
    this.BTI = null;
    this.BTH = null;
    if (this.Bfd)
    {
      this.Bfc.abe();
      this.Bfd = false;
    }
    AppMethodBeat.o(111194);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(111193);
    ad.i("MicroMsg.VLogFakeVideoViewMgr", "onUIPause " + hashCode());
    y(null);
    if (this.Bfd)
    {
      this.Bfc.abe();
      this.Bfd = false;
    }
    AppMethodBeat.o(111193);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(111192);
    ad.i("MicroMsg.VLogFakeVideoViewMgr", "onUIResume " + hashCode());
    if (this.Bfb)
    {
      VLogFakeVideoView localVLogFakeVideoView = this.BTH;
      if (localVLogFakeVideoView != null) {
        localVLogFakeVideoView.onUIResume();
      }
      if (!this.Bfd)
      {
        this.Bfc.requestFocus();
        this.Bfd = true;
      }
    }
    AppMethodBeat.o(111192);
  }
  
  public final void sA(boolean paramBoolean)
  {
    AppMethodBeat.i(111189);
    ad.i("MicroMsg.VLogFakeVideoViewMgr", "stopVideo, detach: ".concat(String.valueOf(paramBoolean)));
    VLogFakeVideoView localVLogFakeVideoView = this.BTH;
    if (localVLogFakeVideoView != null) {
      localVLogFakeVideoView.setAlpha(0.0F);
    }
    if (this.BeZ)
    {
      this.BeY = null;
      localVLogFakeVideoView = this.BTH;
      if (localVLogFakeVideoView != null) {
        localVLogFakeVideoView.stop();
      }
      this.BeX = false;
      if (this.Bfd)
      {
        this.Bfc.abe();
        this.Bfd = false;
      }
      this.BeZ = false;
    }
    if (paramBoolean)
    {
      this.Bfb = false;
      y(null);
    }
    AppMethodBeat.o(111189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.a
 * JD-Core Version:    0.7.0.1
 */