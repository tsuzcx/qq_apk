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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoViewMgr;", "", "()V", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "currentSessionId", "", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "videoView", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoView;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "getPlayStatus", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "onUIDestroy", "onUIPause", "onUIResume", "playVideo", "sameParent", "setMute", "setVideoViewProp", "stopVideo", "detach", "Companion", "plugin-vlog_release"})
public final class a
{
  public static final a NBS;
  private boolean Mbg;
  private String Mbh;
  private boolean Mbi;
  public boolean Mbk;
  private b Mbl;
  private boolean Mbm;
  public VLogFakeVideoView NBQ;
  private c NBR;
  public boolean iYs;
  
  static
  {
    AppMethodBeat.i(111196);
    NBS = new a((byte)0);
    AppMethodBeat.o(111196);
  }
  
  public a()
  {
    AppMethodBeat.i(111195);
    this.Mbl = new b(MMApplicationContext.getContext());
    AppMethodBeat.o(111195);
  }
  
  private final void O(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(111186);
    Object localObject1 = new StringBuilder("checkDetachVideoView, videoView:");
    Object localObject2 = this.NBQ;
    int i;
    boolean bool;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", isPlay:");
      localObject2 = this.NBQ;
      if (localObject2 == null) {
        break label229;
      }
      bool = ((VLogFakeVideoView)localObject2).isPlaying();
      label63:
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", parent:");
      localObject1 = this.NBQ;
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
      Log.i("MicroMsg.VLogFakeVideoViewMgr", i + ", isPlayingVideoItem:" + this.Mbi);
      localObject1 = this.NBQ;
      if (localObject1 == null) {
        break label250;
      }
      localObject1 = ((VLogFakeVideoView)localObject1).getParent();
      label171:
      if ((localObject1 == null) || (P(paramViewGroup))) {
        break label280;
      }
      zH(false);
      paramViewGroup = this.NBQ;
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
    ((ViewGroup)paramViewGroup).removeView((View)this.NBQ);
    this.NBR = null;
    label280:
    AppMethodBeat.o(111186);
  }
  
  private final boolean P(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(111187);
    Object localObject = this.NBQ;
    if (localObject != null) {}
    for (localObject = ((VLogFakeVideoView)localObject).getParent();; localObject = null)
    {
      boolean bool = p.h(localObject, paramViewGroup);
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
      localc = this.NBR;
    } while ((localc == null) || (localc.systemRowid != paramc.systemRowid));
    return true;
  }
  
  private final void ggR()
  {
    AppMethodBeat.i(111191);
    Log.i("MicroMsg.VLogFakeVideoViewMgr", "setVideoViewProp, isMute:" + this.iYs);
    VLogFakeVideoView localVLogFakeVideoView = this.NBQ;
    if (localVLogFakeVideoView != null)
    {
      localVLogFakeVideoView.setMute(this.iYs);
      AppMethodBeat.o(111191);
      return;
    }
    AppMethodBeat.o(111191);
  }
  
  private final void in(Context paramContext)
  {
    AppMethodBeat.i(111188);
    Log.i("MicroMsg.VLogFakeVideoViewMgr", "initCreateVideoView");
    this.NBQ = new VLogFakeVideoView(paramContext);
    this.Mbi = false;
    AppMethodBeat.o(111188);
  }
  
  public final void Tf()
  {
    AppMethodBeat.i(111190);
    Log.printInfoStack("MicroMsg.VLogFakeVideoViewMgr", "playVideo, " + this.Mbg + ' ' + this.Mbk + ", " + this.NBR, new Object[0]);
    ggR();
    this.Mbk = true;
    Object localObject;
    if (this.NBR != null)
    {
      boolean bool = this.Mbg;
      this.Mbg = false;
      if (!bool) {
        break label154;
      }
      localObject = this.NBQ;
      if (localObject != null) {
        ((VLogFakeVideoView)localObject).setAlpha(1.0F);
      }
      localObject = this.NBQ;
      if (localObject != null) {
        ((VLogFakeVideoView)localObject).b(this.NBR);
      }
    }
    for (;;)
    {
      this.Mbg = false;
      this.Mbi = true;
      if (!this.Mbm)
      {
        this.Mbl.avy();
        this.Mbm = true;
      }
      AppMethodBeat.o(111190);
      return;
      label154:
      this.Mbh = UUID.randomUUID().toString();
      VLogFakeVideoView localVLogFakeVideoView = this.NBQ;
      if (localVLogFakeVideoView != null)
      {
        c localc = this.NBR;
        localObject = localc;
        if (localc == null) {
          localObject = new c();
        }
        localVLogFakeVideoView.a((c)localObject);
      }
      localObject = this.NBQ;
      if (localObject != null) {
        ((VLogFakeVideoView)localObject).setAlpha(0.0F);
      }
    }
  }
  
  public final void a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(111184);
    p.k(paramViewGroup, "parent");
    boolean bool = P(paramViewGroup);
    StringBuilder localStringBuilder = new StringBuilder("attachVideoView, parent:").append(paramViewGroup.hashCode()).append(", isVideoPause:").append(this.Mbg).append(", currentSessionId:").append(this.Mbh).append(", isPlayingVideoItem:").append(this.Mbi).append(" videoView ");
    Object localObject = this.NBQ;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((VLogFakeVideoView)localObject).hashCode());
      Log.i("MicroMsg.VLogFakeVideoViewMgr", localObject + " sameParent " + bool + " this:" + hashCode());
      O(paramViewGroup);
      if (this.NBQ == null)
      {
        localObject = MMApplicationContext.getContext();
        p.j(localObject, "MMApplicationContext.getContext()");
        in((Context)localObject);
      }
      if (bool) {
        break label248;
      }
      Log.i("MicroMsg.VLogFakeVideoViewMgr", "addView layoutParams:".concat(String.valueOf(paramLayoutParams)));
      if (paramLayoutParams != null) {
        break label233;
      }
      paramViewGroup.addView((View)this.NBQ);
    }
    for (;;)
    {
      paramViewGroup = this.NBQ;
      if (paramViewGroup == null) {
        break label269;
      }
      paramViewGroup.setAlpha(0.0F);
      AppMethodBeat.o(111184);
      return;
      localObject = null;
      break;
      label233:
      paramViewGroup.addView((View)this.NBQ, paramLayoutParams);
      continue;
      label248:
      if (paramLayoutParams != null)
      {
        paramViewGroup = this.NBQ;
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
      Log.i("MicroMsg.VLogFakeVideoViewMgr", "change:" + bool + ' ' + this.Mbk + ", " + paramBoolean + ", changeVideoItem: origin: " + this.NBR + ", new: " + paramc + ",  change:" + bool + " this:" + hashCode());
      if (bool)
      {
        this.NBR = paramc;
        if ((this.Mbk) || (paramBoolean))
        {
          zH(false);
          Tf();
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
    this.Mbk = false;
    O(null);
    this.NBR = null;
    this.NBQ = null;
    if (this.Mbm)
    {
      this.Mbl.avz();
      this.Mbm = false;
    }
    AppMethodBeat.o(111194);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(111193);
    Log.i("MicroMsg.VLogFakeVideoViewMgr", "onUIPause " + hashCode());
    O(null);
    if (this.Mbm)
    {
      this.Mbl.avz();
      this.Mbm = false;
    }
    AppMethodBeat.o(111193);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(111192);
    Log.i("MicroMsg.VLogFakeVideoViewMgr", "onUIResume " + hashCode());
    if (this.Mbk)
    {
      VLogFakeVideoView localVLogFakeVideoView = this.NBQ;
      if (localVLogFakeVideoView != null) {
        localVLogFakeVideoView.onUIResume();
      }
      if (!this.Mbm)
      {
        this.Mbl.avy();
        this.Mbm = true;
      }
    }
    AppMethodBeat.o(111192);
  }
  
  public final void zH(boolean paramBoolean)
  {
    AppMethodBeat.i(111189);
    Log.i("MicroMsg.VLogFakeVideoViewMgr", "stopVideo, detach: ".concat(String.valueOf(paramBoolean)));
    VLogFakeVideoView localVLogFakeVideoView = this.NBQ;
    if (localVLogFakeVideoView != null) {
      localVLogFakeVideoView.setAlpha(0.0F);
    }
    if (this.Mbi)
    {
      this.Mbh = null;
      localVLogFakeVideoView = this.NBQ;
      if (localVLogFakeVideoView != null) {
        localVLogFakeVideoView.stop();
      }
      this.Mbg = false;
      if (this.Mbm)
      {
        this.Mbl.avz();
        this.Mbm = false;
      }
      this.Mbi = false;
    }
    if (paramBoolean)
    {
      this.Mbk = false;
      O(null);
    }
    AppMethodBeat.o(111189);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoViewMgr$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.a
 * JD-Core Version:    0.7.0.1
 */