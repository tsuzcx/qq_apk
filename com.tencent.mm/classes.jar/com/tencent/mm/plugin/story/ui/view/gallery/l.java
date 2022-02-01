package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.g.b.a.ez;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.d;
import com.tencent.mm.plugin.story.f.d.j;
import com.tencent.mm.plugin.story.f.e.a;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.k;
import d.v;
import java.util.UUID;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryImageVideoViewMgr;", "", "()V", "TAG", "", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "currentSessionId", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "videoView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "getPlayStatus", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "onUIDestroy", "onUIPause", "onUIResume", "playVideo", "sameParent", "setMute", "setVideoViewProp", "stopVideo", "detach", "plugin-story_release"})
public final class l
{
  final String TAG;
  boolean ftN;
  boolean zNA;
  private b zNB;
  private boolean zNC;
  d zNv;
  private boolean zNw;
  private String zNx;
  private boolean zNy;
  private j zNz;
  
  public l()
  {
    AppMethodBeat.i(120526);
    this.TAG = "MicroMsg.Gallery.StoryImageVideoViewMgr";
    this.zNB = new b(ai.getContext());
    AppMethodBeat.o(120526);
  }
  
  private final void dZW()
  {
    AppMethodBeat.i(120522);
    ac.i(this.TAG, "setVideoViewProp, isMute:" + this.ftN);
    d locald = this.zNv;
    if (locald != null)
    {
      locald.setMute(this.ftN);
      AppMethodBeat.o(120522);
      return;
    }
    AppMethodBeat.o(120522);
  }
  
  private final boolean g(j paramj)
  {
    AppMethodBeat.i(120518);
    if (paramj.dwR != 0)
    {
      localObject = this.zNz;
      if ((localObject != null) && (((j)localObject).dwR == paramj.dwR))
      {
        AppMethodBeat.o(120518);
        return true;
      }
    }
    Object localObject = (CharSequence)paramj.zuP.Url;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label123;
      }
      localObject = this.zNz;
      if (localObject == null) {
        break label118;
      }
      localObject = ((j)localObject).zuP;
      if (localObject == null) {
        break label118;
      }
    }
    label118:
    for (localObject = ((ddy)localObject).Url;; localObject = null)
    {
      if (!k.g(localObject, paramj.zuP.Url)) {
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
  
  private final void gt(Context paramContext)
  {
    AppMethodBeat.i(120519);
    a locala = a.zuX;
    this.zNv = a.gs(paramContext);
    this.zNy = false;
    AppMethodBeat.o(120519);
  }
  
  private final void v(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120516);
    String str = this.TAG;
    Object localObject1 = new StringBuilder("checkDetachVideoView, videoView:");
    Object localObject2 = this.zNv;
    int i;
    boolean bool;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", isPlay:");
      localObject2 = this.zNv;
      if (localObject2 == null) {
        break label235;
      }
      bool = ((d)localObject2).isPlaying();
      label69:
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", parent:");
      localObject1 = this.zNv;
      if (localObject1 == null) {
        break label240;
      }
      localObject1 = ((d)localObject1).getParent();
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
      ac.i(str, i + ", isPlayingVideoItem:" + this.zNy);
      localObject1 = this.zNv;
      if (localObject1 == null) {
        break label256;
      }
      localObject1 = ((d)localObject1).getParent();
      label177:
      if ((localObject1 == null) || (w(paramViewGroup))) {
        break label286;
      }
      rU(false);
      paramViewGroup = this.zNv;
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
    ((ViewGroup)paramViewGroup).removeView((View)this.zNv);
    this.zNz = null;
    label286:
    AppMethodBeat.o(120516);
  }
  
  private final boolean w(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120517);
    Object localObject = this.zNv;
    if (localObject != null) {}
    for (localObject = ((d)localObject).getParent();; localObject = null)
    {
      boolean bool = k.g(localObject, paramViewGroup);
      AppMethodBeat.o(120517);
      return bool;
    }
  }
  
  public final void Er()
  {
    AppMethodBeat.i(120521);
    ac.m(this.TAG, "playVideo, " + this.zNw + ' ' + this.zNA + ", " + this.zNz, new Object[0]);
    dZW();
    this.zNA = true;
    j localj = this.zNz;
    if (localj != null)
    {
      boolean bool = this.zNw;
      this.zNw = false;
      if (!bool) {
        break label201;
      }
      localObject1 = this.zNv;
      if (localObject1 != null) {
        ((d)localObject1).setAlpha(1.0F);
      }
      localObject1 = this.zNv;
      if (localObject1 != null) {
        ((d)localObject1).b(localj.zuQ);
      }
      this.zNw = false;
      if (localj.dWy()) {
        this.zNy = true;
      }
      if (!this.zNC)
      {
        this.zNB.requestFocus();
        this.zNC = true;
      }
    }
    Object localObject1 = h.zAU;
    Object localObject2 = h.dXK();
    localObject1 = this.zNv;
    if (localObject1 != null) {}
    for (localObject1 = ((d)localObject1).getContext();; localObject1 = null)
    {
      ((ez)localObject2).jl(ax.iI((Context)localObject1));
      AppMethodBeat.o(120521);
      return;
      label201:
      this.zNx = UUID.randomUUID().toString();
      d locald = this.zNv;
      if (locald == null) {
        break;
      }
      localObject2 = localj.zuQ;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new e();
      }
      locald.a((e)localObject1);
      break;
    }
  }
  
  public final void a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(120514);
    k.h(paramViewGroup, "parent");
    boolean bool = w(paramViewGroup);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("attachVideoView, parent:").append(paramViewGroup.hashCode()).append(", isVideoPause:").append(this.zNw).append(", currentSessionId:").append(this.zNx).append(", isPlayingVideoItem:").append(this.zNy).append(" videoView ");
    Object localObject = this.zNv;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((d)localObject).hashCode());
      ac.i(str, localObject + " sameParent " + bool + " this:" + hashCode());
      v(paramViewGroup);
      if (this.zNv == null)
      {
        localObject = ai.getContext();
        k.g(localObject, "MMApplicationContext.getContext()");
        gt((Context)localObject);
      }
      if (bool) {
        break label239;
      }
      if (paramLayoutParams != null) {
        break label224;
      }
      paramViewGroup.addView((View)this.zNv);
    }
    for (;;)
    {
      paramViewGroup = this.zNv;
      if (paramViewGroup == null) {
        break label260;
      }
      paramViewGroup.setAlpha(0.0F);
      AppMethodBeat.o(120514);
      return;
      localObject = null;
      break;
      label224:
      paramViewGroup.addView((View)this.zNv, paramLayoutParams);
      continue;
      label239:
      if (paramLayoutParams != null)
      {
        paramViewGroup = this.zNv;
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
    k.h(paramj, "item");
    if (!g(paramj)) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i(this.TAG, "change:" + bool + ' ' + this.zNA + ", " + paramBoolean + ", changeVideoItem: origin: " + this.zNz + ", new: " + paramj + ",  change:" + bool + " this:" + hashCode());
      if (bool)
      {
        this.zNz = paramj;
        if ((this.zNA) || (paramBoolean))
        {
          rU(false);
          Er();
        }
      }
      AppMethodBeat.o(120515);
      return;
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(120525);
    ac.i(this.TAG, "onUIDestroy " + hashCode());
    this.zNA = false;
    v(null);
    this.zNz = null;
    this.zNv = null;
    if (this.zNC)
    {
      this.zNB.YC();
      this.zNC = false;
    }
    AppMethodBeat.o(120525);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(120524);
    ac.i(this.TAG, "onUIPause " + hashCode());
    v(null);
    if (this.zNC)
    {
      this.zNB.YC();
      this.zNC = false;
    }
    AppMethodBeat.o(120524);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(120523);
    ac.i(this.TAG, "onUIResume " + hashCode());
    if (this.zNA)
    {
      d locald = this.zNv;
      if (locald != null) {
        locald.onUIResume();
      }
      if (!this.zNC)
      {
        this.zNB.requestFocus();
        this.zNC = true;
      }
    }
    AppMethodBeat.o(120523);
  }
  
  public final void rU(boolean paramBoolean)
  {
    AppMethodBeat.i(120520);
    ac.i(this.TAG, "stopVideo, detach: ".concat(String.valueOf(paramBoolean)));
    if (this.zNy)
    {
      this.zNx = null;
      d locald = this.zNv;
      if (locald != null) {
        locald.stop();
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
    AppMethodBeat.o(120520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.l
 * JD-Core Version:    0.7.0.1
 */