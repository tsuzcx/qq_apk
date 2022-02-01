package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.g.b.a.ga;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.f;
import com.tencent.mm.plugin.story.f.d.j;
import com.tencent.mm.plugin.story.f.e.a;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import d.g.b.p;
import d.v;
import java.util.UUID;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryImageVideoViewMgr;", "", "()V", "TAG", "", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "currentSessionId", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "videoView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "getPlayStatus", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "onUIDestroy", "onUIPause", "onUIResume", "playVideo", "sameParent", "setMute", "setVideoViewProp", "stopVideo", "detach", "plugin-story_release"})
public final class l
{
  private b BwA;
  private boolean BwB;
  f Bwu;
  private boolean Bwv;
  private String Bww;
  private boolean Bwx;
  private j Bwy;
  boolean Bwz;
  final String TAG;
  boolean fOX;
  
  public l()
  {
    AppMethodBeat.i(120526);
    this.TAG = "MicroMsg.Gallery.StoryImageVideoViewMgr";
    this.BwA = new b(ak.getContext());
    AppMethodBeat.o(120526);
  }
  
  private final void epU()
  {
    AppMethodBeat.i(120522);
    ae.i(this.TAG, "setVideoViewProp, isMute:" + this.fOX);
    f localf = this.Bwu;
    if (localf != null)
    {
      localf.setMute(this.fOX);
      AppMethodBeat.o(120522);
      return;
    }
    AppMethodBeat.o(120522);
  }
  
  private final boolean g(j paramj)
  {
    AppMethodBeat.i(120518);
    if (paramj.dKr != 0)
    {
      localObject = this.Bwy;
      if ((localObject != null) && (((j)localObject).dKr == paramj.dKr))
      {
        AppMethodBeat.o(120518);
        return true;
      }
    }
    Object localObject = (CharSequence)paramj.Bem.Url;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label123;
      }
      localObject = this.Bwy;
      if (localObject == null) {
        break label118;
      }
      localObject = ((j)localObject).Bem;
      if (localObject == null) {
        break label118;
      }
    }
    label118:
    for (localObject = ((dkg)localObject).Url;; localObject = null)
    {
      if (!p.i(localObject, paramj.Bem.Url)) {
        break label123;
      }
      AppMethodBeat.o(120518);
      return true;
      i = 0;
      break;
    }
    label123:
    AppMethodBeat.o(120518);
    return false;
  }
  
  private final void gB(Context paramContext)
  {
    AppMethodBeat.i(120519);
    a locala = a.Beu;
    this.Bwu = a.gA(paramContext);
    this.Bwx = false;
    AppMethodBeat.o(120519);
  }
  
  private final void y(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120516);
    String str = this.TAG;
    Object localObject1 = new StringBuilder("checkDetachVideoView, videoView:");
    Object localObject2 = this.Bwu;
    int i;
    boolean bool;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", isPlay:");
      localObject2 = this.Bwu;
      if (localObject2 == null) {
        break label235;
      }
      bool = ((f)localObject2).isPlaying();
      label69:
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", parent:");
      localObject1 = this.Bwu;
      if (localObject1 == null) {
        break label240;
      }
      localObject1 = ((f)localObject1).getParent();
      label100:
      if (localObject1 == null) {
        break label246;
      }
      i = localObject1.hashCode();
      label111:
      localObject1 = ((StringBuilder)localObject2).append(i).append(", newParent:");
      if (paramViewGroup == null) {
        break label251;
      }
      i = paramViewGroup.hashCode();
      label133:
      ae.i(str, i + ", isPlayingVideoItem:" + this.Bwx);
      localObject1 = this.Bwu;
      if (localObject1 == null) {
        break label256;
      }
      localObject1 = ((f)localObject1).getParent();
      label177:
      if ((localObject1 == null) || (z(paramViewGroup))) {
        break label286;
      }
      sH(false);
      paramViewGroup = this.Bwu;
      if (paramViewGroup == null) {
        break label262;
      }
    }
    label256:
    label262:
    for (paramViewGroup = paramViewGroup.getParent();; paramViewGroup = null)
    {
      if (paramViewGroup != null) {
        break label267;
      }
      paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(120516);
      throw paramViewGroup;
      i = 0;
      break;
      label235:
      bool = false;
      break label69;
      label240:
      localObject1 = null;
      break label100;
      label246:
      i = 0;
      break label111;
      label251:
      i = 0;
      break label133;
      localObject1 = null;
      break label177;
    }
    label267:
    ((ViewGroup)paramViewGroup).removeView((View)this.Bwu);
    this.Bwy = null;
    label286:
    AppMethodBeat.o(120516);
  }
  
  private final boolean z(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120517);
    Object localObject = this.Bwu;
    if (localObject != null) {}
    for (localObject = ((f)localObject).getParent();; localObject = null)
    {
      boolean bool = p.i(localObject, paramViewGroup);
      AppMethodBeat.o(120517);
      return bool;
    }
  }
  
  public final void FW()
  {
    AppMethodBeat.i(120521);
    ae.m(this.TAG, "playVideo, " + this.Bwv + ' ' + this.Bwz + ", " + this.Bwy, new Object[0]);
    epU();
    this.Bwz = true;
    j localj = this.Bwy;
    if (localj != null)
    {
      boolean bool = this.Bwv;
      this.Bwv = false;
      if (!bool) {
        break label201;
      }
      localObject1 = this.Bwu;
      if (localObject1 != null) {
        ((f)localObject1).setAlpha(1.0F);
      }
      localObject1 = this.Bwu;
      if (localObject1 != null) {
        ((f)localObject1).b(localj.Ben);
      }
      this.Bwv = false;
      if (localj.emv()) {
        this.Bwx = true;
      }
      if (!this.BwB)
      {
        this.BwA.requestFocus();
        this.BwB = true;
      }
    }
    Object localObject1 = h.BjR;
    Object localObject2 = h.enI();
    localObject1 = this.Bwu;
    if (localObject1 != null) {}
    for (localObject1 = ((f)localObject1).getContext();; localObject1 = null)
    {
      ((ga)localObject2).li(az.iX((Context)localObject1));
      AppMethodBeat.o(120521);
      return;
      label201:
      this.Bww = UUID.randomUUID().toString();
      f localf = this.Bwu;
      if (localf == null) {
        break;
      }
      localObject2 = localj.Ben;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new c();
      }
      localf.a((c)localObject1);
      break;
    }
  }
  
  public final void a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(120514);
    p.h(paramViewGroup, "parent");
    boolean bool = z(paramViewGroup);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("attachVideoView, parent:").append(paramViewGroup.hashCode()).append(", isVideoPause:").append(this.Bwv).append(", currentSessionId:").append(this.Bww).append(", isPlayingVideoItem:").append(this.Bwx).append(" videoView ");
    Object localObject = this.Bwu;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((f)localObject).hashCode());
      ae.i(str, localObject + " sameParent " + bool + " this:" + hashCode());
      y(paramViewGroup);
      if (this.Bwu == null)
      {
        localObject = ak.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        gB((Context)localObject);
      }
      if (bool) {
        break label239;
      }
      if (paramLayoutParams != null) {
        break label224;
      }
      paramViewGroup.addView((View)this.Bwu);
    }
    for (;;)
    {
      paramViewGroup = this.Bwu;
      if (paramViewGroup == null) {
        break label260;
      }
      paramViewGroup.setAlpha(0.0F);
      AppMethodBeat.o(120514);
      return;
      localObject = null;
      break;
      label224:
      paramViewGroup.addView((View)this.Bwu, paramLayoutParams);
      continue;
      label239:
      if (paramLayoutParams != null)
      {
        paramViewGroup = this.Bwu;
        if (paramViewGroup != null) {
          paramViewGroup.setLayoutParams(paramLayoutParams);
        }
      }
    }
    label260:
    AppMethodBeat.o(120514);
  }
  
  public final void a(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(120515);
    p.h(paramj, "item");
    if (!g(paramj)) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i(this.TAG, "change:" + bool + ' ' + this.Bwz + ", " + paramBoolean + ", changeVideoItem: origin: " + this.Bwy + ", new: " + paramj + ",  change:" + bool + " this:" + hashCode());
      if (bool)
      {
        this.Bwy = paramj;
        if ((this.Bwz) || (paramBoolean))
        {
          sH(false);
          FW();
        }
      }
      AppMethodBeat.o(120515);
      return;
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(120525);
    ae.i(this.TAG, "onUIDestroy " + hashCode());
    this.Bwz = false;
    y(null);
    this.Bwy = null;
    this.Bwu = null;
    if (this.BwB)
    {
      this.BwA.abn();
      this.BwB = false;
    }
    AppMethodBeat.o(120525);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(120524);
    ae.i(this.TAG, "onUIPause " + hashCode());
    y(null);
    if (this.BwB)
    {
      this.BwA.abn();
      this.BwB = false;
    }
    AppMethodBeat.o(120524);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(120523);
    ae.i(this.TAG, "onUIResume " + hashCode());
    if (this.Bwz)
    {
      f localf = this.Bwu;
      if (localf != null) {
        localf.onUIResume();
      }
      if (!this.BwB)
      {
        this.BwA.requestFocus();
        this.BwB = true;
      }
    }
    AppMethodBeat.o(120523);
  }
  
  public final void sH(boolean paramBoolean)
  {
    AppMethodBeat.i(120520);
    ae.i(this.TAG, "stopVideo, detach: ".concat(String.valueOf(paramBoolean)));
    if (this.Bwx)
    {
      this.Bww = null;
      f localf = this.Bwu;
      if (localf != null) {
        localf.stop();
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
    AppMethodBeat.o(120520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.l
 * JD-Core Version:    0.7.0.1
 */