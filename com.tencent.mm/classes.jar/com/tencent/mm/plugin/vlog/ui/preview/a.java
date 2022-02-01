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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoViewMgr;", "", "()V", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "currentSessionId", "", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "videoView", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoView;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "getPlayStatus", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "onUIDestroy", "onUIPause", "onUIResume", "playVideo", "sameParent", "setMute", "setVideoViewProp", "stopVideo", "detach", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a Uox;
  public boolean SCA;
  private b SCB;
  private boolean SCC;
  private boolean SCw;
  private String SCx;
  private boolean SCy;
  public VLogFakeVideoView Uoy;
  private c Uoz;
  public boolean lAj;
  
  static
  {
    AppMethodBeat.i(111196);
    Uox = new a.a((byte)0);
    AppMethodBeat.o(111196);
  }
  
  public a()
  {
    AppMethodBeat.i(111195);
    this.SCB = new b(MMApplicationContext.getContext());
    AppMethodBeat.o(111195);
  }
  
  private final void Y(ViewGroup paramViewGroup)
  {
    int j = 0;
    AppMethodBeat.i(111186);
    Object localObject1 = new StringBuilder("checkDetachVideoView, videoView:");
    Object localObject2 = this.Uoy;
    int i;
    boolean bool;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", isPlay:");
      localObject2 = this.Uoy;
      if (localObject2 != null) {
        break label219;
      }
      bool = false;
      label62:
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", parent:");
      localObject1 = this.Uoy;
      if (localObject1 != null) {
        break label232;
      }
      localObject1 = null;
      label90:
      if (localObject1 == null) {
        break label242;
      }
      i = localObject1.hashCode();
      label101:
      localObject1 = ((StringBuilder)localObject2).append(i).append(", newParent:");
      i = j;
      if (paramViewGroup != null) {
        i = paramViewGroup.hashCode();
      }
      Log.i("MicroMsg.VLogFakeVideoViewMgr", i + ", isPlayingVideoItem:" + this.SCy);
      localObject1 = this.Uoy;
      if (localObject1 != null) {
        break label247;
      }
      localObject1 = null;
      label165:
      if ((localObject1 == null) || (Z(paramViewGroup))) {
        break label284;
      }
      a(this);
      paramViewGroup = this.Uoy;
      if (paramViewGroup != null) {
        break label257;
      }
    }
    label257:
    for (paramViewGroup = null;; paramViewGroup = paramViewGroup.getParent())
    {
      if (paramViewGroup != null) {
        break label265;
      }
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(111186);
      throw paramViewGroup;
      i = 0;
      break;
      label219:
      bool = ((VLogFakeVideoView)localObject2).getVlogVideoView().UoE;
      break label62;
      label232:
      localObject1 = ((VLogFakeVideoView)localObject1).getParent();
      break label90;
      label242:
      i = 0;
      break label101;
      label247:
      localObject1 = ((VLogFakeVideoView)localObject1).getParent();
      break label165;
    }
    label265:
    ((ViewGroup)paramViewGroup).removeView((View)this.Uoy);
    this.Uoz = null;
    label284:
    AppMethodBeat.o(111186);
  }
  
  private final boolean Z(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(111187);
    Object localObject = this.Uoy;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((VLogFakeVideoView)localObject).getParent())
    {
      boolean bool = s.p(localObject, paramViewGroup);
      AppMethodBeat.o(111187);
      return bool;
    }
  }
  
  private final boolean e(c paramc)
  {
    if (paramc == null) {}
    for (;;)
    {
      return false;
      if (paramc.systemRowid != 0L)
      {
        c localc = this.Uoz;
        if ((localc != null) && (localc.systemRowid == paramc.systemRowid)) {}
        for (int i = 1; i != 0; i = 0) {
          return true;
        }
      }
    }
  }
  
  private final void hAk()
  {
    AppMethodBeat.i(111191);
    Log.i("MicroMsg.VLogFakeVideoViewMgr", s.X("setVideoViewProp, isMute:", Boolean.valueOf(this.lAj)));
    VLogFakeVideoView localVLogFakeVideoView = this.Uoy;
    if (localVLogFakeVideoView != null) {
      localVLogFakeVideoView.setMute(this.lAj);
    }
    AppMethodBeat.o(111191);
  }
  
  private final void kd(Context paramContext)
  {
    AppMethodBeat.i(111188);
    Log.i("MicroMsg.VLogFakeVideoViewMgr", "initCreateVideoView");
    this.Uoy = new VLogFakeVideoView(paramContext);
    this.SCy = false;
    AppMethodBeat.o(111188);
  }
  
  public final void EZ(boolean paramBoolean)
  {
    AppMethodBeat.i(111189);
    Log.i("MicroMsg.VLogFakeVideoViewMgr", s.X("stopVideo, detach: ", Boolean.valueOf(paramBoolean)));
    VLogFakeVideoView localVLogFakeVideoView = this.Uoy;
    if (localVLogFakeVideoView != null) {
      localVLogFakeVideoView.setAlpha(0.0F);
    }
    if (this.SCy)
    {
      this.SCx = null;
      localVLogFakeVideoView = this.Uoy;
      if (localVLogFakeVideoView != null) {
        localVLogFakeVideoView.stop();
      }
      this.SCw = false;
      if (this.SCC)
      {
        this.SCB.aPS();
        this.SCC = false;
      }
      this.SCy = false;
    }
    if (paramBoolean)
    {
      this.SCA = false;
      Y(null);
    }
    AppMethodBeat.o(111189);
  }
  
  public final void a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(111184);
    s.u(paramViewGroup, "parent");
    boolean bool = Z(paramViewGroup);
    StringBuilder localStringBuilder = new StringBuilder("attachVideoView, parent:").append(paramViewGroup.hashCode()).append(", isVideoPause:").append(this.SCw).append(", currentSessionId:").append(this.SCx).append(", isPlayingVideoItem:").append(this.SCy).append(" videoView ");
    Object localObject = this.Uoy;
    if (localObject == null)
    {
      localObject = null;
      Log.i("MicroMsg.VLogFakeVideoViewMgr", localObject + " sameParent " + bool + " this:" + hashCode());
      Y(paramViewGroup);
      if (this.Uoy == null)
      {
        localObject = MMApplicationContext.getContext();
        s.s(localObject, "getContext()");
        kd((Context)localObject);
      }
      if (bool) {
        break label245;
      }
      Log.i("MicroMsg.VLogFakeVideoViewMgr", s.X("addView layoutParams:", paramLayoutParams));
      if (paramLayoutParams != null) {
        break label230;
      }
      paramViewGroup.addView((View)this.Uoy);
    }
    for (;;)
    {
      paramViewGroup = this.Uoy;
      if (paramViewGroup != null) {
        paramViewGroup.setAlpha(0.0F);
      }
      AppMethodBeat.o(111184);
      return;
      localObject = Integer.valueOf(((VLogFakeVideoView)localObject).hashCode());
      break;
      label230:
      paramViewGroup.addView((View)this.Uoy, paramLayoutParams);
      continue;
      label245:
      if (paramLayoutParams != null)
      {
        paramViewGroup = this.Uoy;
        if (paramViewGroup != null) {
          paramViewGroup.setLayoutParams(paramLayoutParams);
        }
      }
    }
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
      Log.i("MicroMsg.VLogFakeVideoViewMgr", "change:" + bool + ' ' + this.SCA + ", " + paramBoolean + ", changeVideoItem: origin: " + this.Uoz + ", new: " + paramc + ",  change:" + bool + " this:" + hashCode());
      if (bool)
      {
        this.Uoz = paramc;
        if ((this.SCA) || (paramBoolean))
        {
          a(this);
          atK();
        }
      }
      AppMethodBeat.o(111185);
      return;
    }
  }
  
  public final void atK()
  {
    AppMethodBeat.i(111190);
    Log.printInfoStack("MicroMsg.VLogFakeVideoViewMgr", "playVideo, " + this.SCw + ' ' + this.SCA + ", " + this.Uoz, new Object[0]);
    hAk();
    this.SCA = true;
    Object localObject;
    if (this.Uoz != null)
    {
      boolean bool = this.SCw;
      this.SCw = false;
      if (!bool) {
        break label158;
      }
      localObject = this.Uoy;
      if (localObject != null) {
        ((VLogFakeVideoView)localObject).setAlpha(1.0F);
      }
      localObject = this.Uoy;
      if (localObject != null) {
        ((VLogFakeVideoView)localObject).b(this.Uoz);
      }
    }
    for (;;)
    {
      this.SCw = false;
      this.SCy = true;
      if (!this.SCC)
      {
        this.SCB.requestFocus();
        this.SCC = true;
      }
      AppMethodBeat.o(111190);
      return;
      label158:
      this.SCx = UUID.randomUUID().toString();
      VLogFakeVideoView localVLogFakeVideoView = this.Uoy;
      if (localVLogFakeVideoView != null)
      {
        c localc = this.Uoz;
        localObject = localc;
        if (localc == null) {
          localObject = new c();
        }
        localVLogFakeVideoView.a((c)localObject);
      }
      localObject = this.Uoy;
      if (localObject != null) {
        ((VLogFakeVideoView)localObject).setAlpha(0.0F);
      }
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(111194);
    Log.i("MicroMsg.VLogFakeVideoViewMgr", s.X("onUIDestroy ", Integer.valueOf(hashCode())));
    this.SCA = false;
    Y(null);
    this.Uoz = null;
    this.Uoy = null;
    if (this.SCC)
    {
      this.SCB.aPS();
      this.SCC = false;
    }
    AppMethodBeat.o(111194);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(111193);
    Log.i("MicroMsg.VLogFakeVideoViewMgr", s.X("onUIPause ", Integer.valueOf(hashCode())));
    Y(null);
    if (this.SCC)
    {
      this.SCB.aPS();
      this.SCC = false;
    }
    AppMethodBeat.o(111193);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(111192);
    Log.i("MicroMsg.VLogFakeVideoViewMgr", s.X("onUIResume ", Integer.valueOf(hashCode())));
    if (this.SCA)
    {
      VLogFakeVideoView localVLogFakeVideoView = this.Uoy;
      if (localVLogFakeVideoView != null) {
        localVLogFakeVideoView.onUIResume();
      }
      if (!this.SCC)
      {
        this.SCB.requestFocus();
        this.SCC = true;
      }
    }
    AppMethodBeat.o(111192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.a
 * JD-Core Version:    0.7.0.1
 */