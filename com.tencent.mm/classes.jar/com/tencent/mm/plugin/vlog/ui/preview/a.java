package com.tencent.mm.plugin.vlog.ui.preview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.plugin.recordvideo.background.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;
import d.v;
import java.util.UUID;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoViewMgr;", "", "()V", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "currentSessionId", "", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "videoView", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoView;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "getPlayStatus", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "onUIDestroy", "onUIPause", "onUIResume", "playVideo", "sameParent", "setMute", "setVideoViewProp", "stopVideo", "detach", "Companion", "plugin-vlog_release"})
public final class a
{
  public static final a zcN;
  public boolean fqj;
  private boolean yAi;
  private String yAj;
  private boolean yAk;
  public boolean yAm;
  private b yAn;
  private boolean yAo;
  public VLogFakeVideoView zcL;
  private d zcM;
  
  static
  {
    AppMethodBeat.i(111196);
    zcN = new a((byte)0);
    AppMethodBeat.o(111196);
  }
  
  public a()
  {
    AppMethodBeat.i(111195);
    this.yAn = new b(aj.getContext());
    AppMethodBeat.o(111195);
  }
  
  private final void dLw()
  {
    AppMethodBeat.i(111191);
    ad.i("MicroMsg.VLogFakeVideoViewMgr", "setVideoViewProp, isMute:" + this.fqj);
    VLogFakeVideoView localVLogFakeVideoView = this.zcL;
    if (localVLogFakeVideoView != null)
    {
      localVLogFakeVideoView.setMute(this.fqj);
      AppMethodBeat.o(111191);
      return;
    }
    AppMethodBeat.o(111191);
  }
  
  private final boolean e(d paramd)
  {
    if (paramd == null) {}
    d locald;
    do
    {
      do
      {
        return false;
      } while (paramd.systemRowid == 0L);
      locald = this.zcM;
    } while ((locald == null) || (locald.systemRowid != paramd.systemRowid));
    return true;
  }
  
  private final void gh(Context paramContext)
  {
    AppMethodBeat.i(111188);
    ad.i("MicroMsg.VLogFakeVideoViewMgr", "initCreateVideoView");
    this.zcL = new VLogFakeVideoView(paramContext, null, 2);
    this.yAk = false;
    AppMethodBeat.o(111188);
  }
  
  private final void u(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(111186);
    Object localObject1 = new StringBuilder("checkDetachVideoView, videoView:");
    Object localObject2 = this.zcL;
    int i;
    boolean bool;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", isPlay:");
      localObject2 = this.zcL;
      if (localObject2 == null) {
        break label229;
      }
      bool = ((VLogFakeVideoView)localObject2).isPlaying();
      label63:
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", parent:");
      localObject1 = this.zcL;
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
      ad.i("MicroMsg.VLogFakeVideoViewMgr", i + ", isPlayingVideoItem:" + this.yAk);
      localObject1 = this.zcL;
      if (localObject1 == null) {
        break label250;
      }
      localObject1 = ((VLogFakeVideoView)localObject1).getParent();
      label171:
      if ((localObject1 == null) || (v(paramViewGroup))) {
        break label280;
      }
      qW(false);
      paramViewGroup = this.zcL;
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
    ((ViewGroup)paramViewGroup).removeView((View)this.zcL);
    this.zcM = null;
    label280:
    AppMethodBeat.o(111186);
  }
  
  private final boolean v(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(111187);
    Object localObject = this.zcL;
    if (localObject != null) {}
    for (localObject = ((VLogFakeVideoView)localObject).getParent();; localObject = null)
    {
      boolean bool = k.g(localObject, paramViewGroup);
      AppMethodBeat.o(111187);
      return bool;
    }
  }
  
  public final void EN()
  {
    AppMethodBeat.i(111190);
    ad.m("MicroMsg.VLogFakeVideoViewMgr", "playVideo, " + this.yAi + ' ' + this.yAm + ", " + this.zcM, new Object[0]);
    dLw();
    this.yAm = true;
    Object localObject;
    if (this.zcM != null)
    {
      boolean bool = this.yAi;
      this.yAi = false;
      if (!bool) {
        break label154;
      }
      localObject = this.zcL;
      if (localObject != null) {
        ((VLogFakeVideoView)localObject).setAlpha(1.0F);
      }
      localObject = this.zcL;
      if (localObject != null) {
        ((VLogFakeVideoView)localObject).b(this.zcM);
      }
    }
    for (;;)
    {
      this.yAi = false;
      this.yAk = true;
      if (!this.yAo)
      {
        this.yAn.requestFocus();
        this.yAo = true;
      }
      AppMethodBeat.o(111190);
      return;
      label154:
      this.yAj = UUID.randomUUID().toString();
      VLogFakeVideoView localVLogFakeVideoView = this.zcL;
      if (localVLogFakeVideoView != null)
      {
        d locald = this.zcM;
        localObject = locald;
        if (locald == null) {
          localObject = new d();
        }
        localVLogFakeVideoView.a((d)localObject);
      }
      localObject = this.zcL;
      if (localObject != null) {
        ((VLogFakeVideoView)localObject).setAlpha(0.0F);
      }
    }
  }
  
  public final void a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(111184);
    k.h(paramViewGroup, "parent");
    boolean bool = v(paramViewGroup);
    StringBuilder localStringBuilder = new StringBuilder("attachVideoView, parent:").append(paramViewGroup.hashCode()).append(", isVideoPause:").append(this.yAi).append(", currentSessionId:").append(this.yAj).append(", isPlayingVideoItem:").append(this.yAk).append(" videoView ");
    Object localObject = this.zcL;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((VLogFakeVideoView)localObject).hashCode());
      ad.i("MicroMsg.VLogFakeVideoViewMgr", localObject + " sameParent " + bool + " this:" + hashCode());
      u(paramViewGroup);
      if (this.zcL == null)
      {
        localObject = aj.getContext();
        k.g(localObject, "MMApplicationContext.getContext()");
        gh((Context)localObject);
      }
      if (bool) {
        break label248;
      }
      ad.i("MicroMsg.VLogFakeVideoViewMgr", "addView layoutParams:".concat(String.valueOf(paramLayoutParams)));
      if (paramLayoutParams != null) {
        break label233;
      }
      paramViewGroup.addView((View)this.zcL);
    }
    for (;;)
    {
      paramViewGroup = this.zcL;
      if (paramViewGroup == null) {
        break label269;
      }
      paramViewGroup.setAlpha(0.0F);
      AppMethodBeat.o(111184);
      return;
      localObject = null;
      break;
      label233:
      paramViewGroup.addView((View)this.zcL, paramLayoutParams);
      continue;
      label248:
      if (paramLayoutParams != null)
      {
        paramViewGroup = this.zcL;
        if (paramViewGroup != null) {
          paramViewGroup.setLayoutParams(paramLayoutParams);
        }
      }
    }
    label269:
    AppMethodBeat.o(111184);
  }
  
  public final void a(d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(111185);
    if (paramd == null)
    {
      AppMethodBeat.o(111185);
      return;
    }
    if (!e(paramd)) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.VLogFakeVideoViewMgr", "change:" + bool + ' ' + this.yAm + ", " + paramBoolean + ", changeVideoItem: origin: " + this.zcM + ", new: " + paramd + ",  change:" + bool + " this:" + hashCode());
      if (bool)
      {
        this.zcM = paramd;
        if ((this.yAm) || (paramBoolean))
        {
          qW(false);
          EN();
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
    this.yAm = false;
    u(null);
    this.zcM = null;
    this.zcL = null;
    if (this.yAo)
    {
      this.yAn.XF();
      this.yAo = false;
    }
    AppMethodBeat.o(111194);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(111193);
    ad.i("MicroMsg.VLogFakeVideoViewMgr", "onUIPause " + hashCode());
    u(null);
    if (this.yAo)
    {
      this.yAn.XF();
      this.yAo = false;
    }
    AppMethodBeat.o(111193);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(111192);
    ad.i("MicroMsg.VLogFakeVideoViewMgr", "onUIResume " + hashCode());
    if (this.yAm)
    {
      VLogFakeVideoView localVLogFakeVideoView = this.zcL;
      if (localVLogFakeVideoView != null) {
        localVLogFakeVideoView.onUIResume();
      }
      if (!this.yAo)
      {
        this.yAn.requestFocus();
        this.yAo = true;
      }
    }
    AppMethodBeat.o(111192);
  }
  
  public final void qW(boolean paramBoolean)
  {
    AppMethodBeat.i(111189);
    ad.i("MicroMsg.VLogFakeVideoViewMgr", "stopVideo, detach: ".concat(String.valueOf(paramBoolean)));
    VLogFakeVideoView localVLogFakeVideoView = this.zcL;
    if (localVLogFakeVideoView != null) {
      localVLogFakeVideoView.setAlpha(0.0F);
    }
    if (this.yAk)
    {
      this.yAj = null;
      localVLogFakeVideoView = this.zcL;
      if (localVLogFakeVideoView != null) {
        localVLogFakeVideoView.stop();
      }
      this.yAi = false;
      if (this.yAo)
      {
        this.yAn.XF();
        this.yAo = false;
      }
      this.yAk = false;
    }
    if (paramBoolean)
    {
      this.yAm = false;
      u(null);
    }
    AppMethodBeat.o(111189);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoViewMgr$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.a
 * JD-Core Version:    0.7.0.1
 */