package com.tencent.mm.plugin.vlog.ui.preview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.l;
import d.v;
import java.util.UUID;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoViewMgr;", "", "()V", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "currentSessionId", "", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "videoView", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoView;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "getPlayStatus", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "onUIDestroy", "onUIPause", "onUIResume", "playVideo", "sameParent", "setMute", "setVideoViewProp", "stopVideo", "detach", "Companion", "plugin-vlog_release"})
public final class a
{
  public static final a.a Auz;
  public VLogFakeVideoView Aux;
  private e Auy;
  public boolean ftN;
  public boolean zNA;
  private b zNB;
  private boolean zNC;
  private boolean zNw;
  private String zNx;
  private boolean zNy;
  
  static
  {
    AppMethodBeat.i(111196);
    Auz = new a.a((byte)0);
    AppMethodBeat.o(111196);
  }
  
  public a()
  {
    AppMethodBeat.i(111195);
    this.zNB = new b(ai.getContext());
    AppMethodBeat.o(111195);
  }
  
  private final void dZW()
  {
    AppMethodBeat.i(111191);
    ac.i("MicroMsg.VLogFakeVideoViewMgr", "setVideoViewProp, isMute:" + this.ftN);
    VLogFakeVideoView localVLogFakeVideoView = this.Aux;
    if (localVLogFakeVideoView != null)
    {
      localVLogFakeVideoView.setMute(this.ftN);
      AppMethodBeat.o(111191);
      return;
    }
    AppMethodBeat.o(111191);
  }
  
  private final boolean e(e parame)
  {
    if (parame == null) {}
    e locale;
    do
    {
      do
      {
        return false;
      } while (parame.systemRowid == 0L);
      locale = this.Auy;
    } while ((locale == null) || (locale.systemRowid != parame.systemRowid));
    return true;
  }
  
  private final void gt(Context paramContext)
  {
    AppMethodBeat.i(111188);
    ac.i("MicroMsg.VLogFakeVideoViewMgr", "initCreateVideoView");
    this.Aux = new VLogFakeVideoView(paramContext, null, 2);
    this.zNy = false;
    AppMethodBeat.o(111188);
  }
  
  private final void v(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(111186);
    Object localObject1 = new StringBuilder("checkDetachVideoView, videoView:");
    Object localObject2 = this.Aux;
    int i;
    boolean bool;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", isPlay:");
      localObject2 = this.Aux;
      if (localObject2 == null) {
        break label229;
      }
      bool = ((VLogFakeVideoView)localObject2).isPlaying();
      label63:
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", parent:");
      localObject1 = this.Aux;
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
      ac.i("MicroMsg.VLogFakeVideoViewMgr", i + ", isPlayingVideoItem:" + this.zNy);
      localObject1 = this.Aux;
      if (localObject1 == null) {
        break label250;
      }
      localObject1 = ((VLogFakeVideoView)localObject1).getParent();
      label171:
      if ((localObject1 == null) || (w(paramViewGroup))) {
        break label280;
      }
      rU(false);
      paramViewGroup = this.Aux;
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
    ((ViewGroup)paramViewGroup).removeView((View)this.Aux);
    this.Auy = null;
    label280:
    AppMethodBeat.o(111186);
  }
  
  private final boolean w(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(111187);
    Object localObject = this.Aux;
    if (localObject != null) {}
    for (localObject = ((VLogFakeVideoView)localObject).getParent();; localObject = null)
    {
      boolean bool = k.g(localObject, paramViewGroup);
      AppMethodBeat.o(111187);
      return bool;
    }
  }
  
  public final void Er()
  {
    AppMethodBeat.i(111190);
    ac.m("MicroMsg.VLogFakeVideoViewMgr", "playVideo, " + this.zNw + ' ' + this.zNA + ", " + this.Auy, new Object[0]);
    dZW();
    this.zNA = true;
    Object localObject;
    if (this.Auy != null)
    {
      boolean bool = this.zNw;
      this.zNw = false;
      if (!bool) {
        break label154;
      }
      localObject = this.Aux;
      if (localObject != null) {
        ((VLogFakeVideoView)localObject).setAlpha(1.0F);
      }
      localObject = this.Aux;
      if (localObject != null) {
        ((VLogFakeVideoView)localObject).b(this.Auy);
      }
    }
    for (;;)
    {
      this.zNw = false;
      this.zNy = true;
      if (!this.zNC)
      {
        this.zNB.requestFocus();
        this.zNC = true;
      }
      AppMethodBeat.o(111190);
      return;
      label154:
      this.zNx = UUID.randomUUID().toString();
      VLogFakeVideoView localVLogFakeVideoView = this.Aux;
      if (localVLogFakeVideoView != null)
      {
        e locale = this.Auy;
        localObject = locale;
        if (locale == null) {
          localObject = new e();
        }
        localVLogFakeVideoView.a((e)localObject);
      }
      localObject = this.Aux;
      if (localObject != null) {
        ((VLogFakeVideoView)localObject).setAlpha(0.0F);
      }
    }
  }
  
  public final void a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(111184);
    k.h(paramViewGroup, "parent");
    boolean bool = w(paramViewGroup);
    StringBuilder localStringBuilder = new StringBuilder("attachVideoView, parent:").append(paramViewGroup.hashCode()).append(", isVideoPause:").append(this.zNw).append(", currentSessionId:").append(this.zNx).append(", isPlayingVideoItem:").append(this.zNy).append(" videoView ");
    Object localObject = this.Aux;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((VLogFakeVideoView)localObject).hashCode());
      ac.i("MicroMsg.VLogFakeVideoViewMgr", localObject + " sameParent " + bool + " this:" + hashCode());
      v(paramViewGroup);
      if (this.Aux == null)
      {
        localObject = ai.getContext();
        k.g(localObject, "MMApplicationContext.getContext()");
        gt((Context)localObject);
      }
      if (bool) {
        break label248;
      }
      ac.i("MicroMsg.VLogFakeVideoViewMgr", "addView layoutParams:".concat(String.valueOf(paramLayoutParams)));
      if (paramLayoutParams != null) {
        break label233;
      }
      paramViewGroup.addView((View)this.Aux);
    }
    for (;;)
    {
      paramViewGroup = this.Aux;
      if (paramViewGroup == null) {
        break label269;
      }
      paramViewGroup.setAlpha(0.0F);
      AppMethodBeat.o(111184);
      return;
      localObject = null;
      break;
      label233:
      paramViewGroup.addView((View)this.Aux, paramLayoutParams);
      continue;
      label248:
      if (paramLayoutParams != null)
      {
        paramViewGroup = this.Aux;
        if (paramViewGroup != null) {
          paramViewGroup.setLayoutParams(paramLayoutParams);
        }
      }
    }
    label269:
    AppMethodBeat.o(111184);
  }
  
  public final void a(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(111185);
    if (parame == null)
    {
      AppMethodBeat.o(111185);
      return;
    }
    if (!e(parame)) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.VLogFakeVideoViewMgr", "change:" + bool + ' ' + this.zNA + ", " + paramBoolean + ", changeVideoItem: origin: " + this.Auy + ", new: " + parame + ",  change:" + bool + " this:" + hashCode());
      if (bool)
      {
        this.Auy = parame;
        if ((this.zNA) || (paramBoolean))
        {
          rU(false);
          Er();
        }
      }
      AppMethodBeat.o(111185);
      return;
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(111194);
    ac.i("MicroMsg.VLogFakeVideoViewMgr", "onUIDestroy " + hashCode());
    this.zNA = false;
    v(null);
    this.Auy = null;
    this.Aux = null;
    if (this.zNC)
    {
      this.zNB.YC();
      this.zNC = false;
    }
    AppMethodBeat.o(111194);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(111193);
    ac.i("MicroMsg.VLogFakeVideoViewMgr", "onUIPause " + hashCode());
    v(null);
    if (this.zNC)
    {
      this.zNB.YC();
      this.zNC = false;
    }
    AppMethodBeat.o(111193);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(111192);
    ac.i("MicroMsg.VLogFakeVideoViewMgr", "onUIResume " + hashCode());
    if (this.zNA)
    {
      VLogFakeVideoView localVLogFakeVideoView = this.Aux;
      if (localVLogFakeVideoView != null) {
        localVLogFakeVideoView.onUIResume();
      }
      if (!this.zNC)
      {
        this.zNB.requestFocus();
        this.zNC = true;
      }
    }
    AppMethodBeat.o(111192);
  }
  
  public final void rU(boolean paramBoolean)
  {
    AppMethodBeat.i(111189);
    ac.i("MicroMsg.VLogFakeVideoViewMgr", "stopVideo, detach: ".concat(String.valueOf(paramBoolean)));
    VLogFakeVideoView localVLogFakeVideoView = this.Aux;
    if (localVLogFakeVideoView != null) {
      localVLogFakeVideoView.setAlpha(0.0F);
    }
    if (this.zNy)
    {
      this.zNx = null;
      localVLogFakeVideoView = this.Aux;
      if (localVLogFakeVideoView != null) {
        localVLogFakeVideoView.stop();
      }
      this.zNw = false;
      if (this.zNC)
      {
        this.zNB.YC();
        this.zNC = false;
      }
      this.zNy = false;
    }
    if (paramBoolean)
    {
      this.zNA = false;
      v(null);
    }
    AppMethodBeat.o(111189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.a
 * JD-Core Version:    0.7.0.1
 */