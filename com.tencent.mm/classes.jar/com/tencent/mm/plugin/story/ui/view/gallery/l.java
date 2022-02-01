package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.g.b.a.dl;
import com.tencent.mm.plugin.story.f.d.j;
import com.tencent.mm.plugin.story.f.e.a;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.b.k;
import d.v;
import java.util.UUID;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryImageVideoViewMgr;", "", "()V", "TAG", "", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "currentSessionId", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "videoView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "getPlayStatus", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "onUIDestroy", "onUIPause", "onUIResume", "playVideo", "sameParent", "setMute", "setVideoViewProp", "stopVideo", "detach", "plugin-story_release"})
public final class l
{
  final String TAG;
  boolean fqj;
  com.tencent.mm.plugin.recordvideo.ui.editor.d yAh;
  private boolean yAi;
  private String yAj;
  private boolean yAk;
  private j yAl;
  boolean yAm;
  private b yAn;
  private boolean yAo;
  
  public l()
  {
    AppMethodBeat.i(120526);
    this.TAG = "MicroMsg.Gallery.StoryImageVideoViewMgr";
    this.yAn = new b(aj.getContext());
    AppMethodBeat.o(120526);
  }
  
  private final void dLw()
  {
    AppMethodBeat.i(120522);
    ad.i(this.TAG, "setVideoViewProp, isMute:" + this.fqj);
    com.tencent.mm.plugin.recordvideo.ui.editor.d locald = this.yAh;
    if (locald != null)
    {
      locald.setMute(this.fqj);
      AppMethodBeat.o(120522);
      return;
    }
    AppMethodBeat.o(120522);
  }
  
  private final boolean g(j paramj)
  {
    AppMethodBeat.i(120518);
    if (paramj.dzf != 0)
    {
      localObject = this.yAl;
      if ((localObject != null) && (((j)localObject).dzf == paramj.dzf))
      {
        AppMethodBeat.o(120518);
        return true;
      }
    }
    Object localObject = (CharSequence)paramj.yhP.Url;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label123;
      }
      localObject = this.yAl;
      if (localObject == null) {
        break label118;
      }
      localObject = ((j)localObject).yhP;
      if (localObject == null) {
        break label118;
      }
    }
    label118:
    for (localObject = ((cym)localObject).Url;; localObject = null)
    {
      if (!k.g(localObject, paramj.yhP.Url)) {
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
  
  private final void gh(Context paramContext)
  {
    AppMethodBeat.i(120519);
    a locala = a.yhX;
    this.yAh = a.gg(paramContext);
    this.yAk = false;
    AppMethodBeat.o(120519);
  }
  
  private final void u(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120516);
    String str = this.TAG;
    Object localObject1 = new StringBuilder("checkDetachVideoView, videoView:");
    Object localObject2 = this.yAh;
    int i;
    boolean bool;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", isPlay:");
      localObject2 = this.yAh;
      if (localObject2 == null) {
        break label235;
      }
      bool = ((com.tencent.mm.plugin.recordvideo.ui.editor.d)localObject2).isPlaying();
      label69:
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", parent:");
      localObject1 = this.yAh;
      if (localObject1 == null) {
        break label240;
      }
      localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.d)localObject1).getParent();
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
      ad.i(str, i + ", isPlayingVideoItem:" + this.yAk);
      localObject1 = this.yAh;
      if (localObject1 == null) {
        break label256;
      }
      localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.d)localObject1).getParent();
      label177:
      if ((localObject1 == null) || (v(paramViewGroup))) {
        break label286;
      }
      qW(false);
      paramViewGroup = this.yAh;
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
    ((ViewGroup)paramViewGroup).removeView((View)this.yAh);
    this.yAl = null;
    label286:
    AppMethodBeat.o(120516);
  }
  
  private final boolean v(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120517);
    Object localObject = this.yAh;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.recordvideo.ui.editor.d)localObject).getParent();; localObject = null)
    {
      boolean bool = k.g(localObject, paramViewGroup);
      AppMethodBeat.o(120517);
      return bool;
    }
  }
  
  public final void EN()
  {
    AppMethodBeat.i(120521);
    ad.m(this.TAG, "playVideo, " + this.yAi + ' ' + this.yAm + ", " + this.yAl, new Object[0]);
    dLw();
    this.yAm = true;
    j localj = this.yAl;
    if (localj != null)
    {
      boolean bool = this.yAi;
      this.yAi = false;
      if (!bool) {
        break label201;
      }
      localObject1 = this.yAh;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.d)localObject1).setAlpha(1.0F);
      }
      localObject1 = this.yAh;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.d)localObject1).b(localj.yhQ);
      }
      this.yAi = false;
      if (localj.dHX()) {
        this.yAk = true;
      }
      if (!this.yAo)
      {
        this.yAn.requestFocus();
        this.yAo = true;
      }
    }
    Object localObject1 = h.ynv;
    Object localObject2 = h.dJj();
    localObject1 = this.yAh;
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.d)localObject1).getContext();; localObject1 = null)
    {
      ((dl)localObject2).fY(ay.ix((Context)localObject1));
      AppMethodBeat.o(120521);
      return;
      label201:
      this.yAj = UUID.randomUUID().toString();
      com.tencent.mm.plugin.recordvideo.ui.editor.d locald = this.yAh;
      if (locald == null) {
        break;
      }
      localObject2 = localj.yhQ;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.recordvideo.background.d();
      }
      locald.a((com.tencent.mm.plugin.recordvideo.background.d)localObject1);
      break;
    }
  }
  
  public final void a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(120514);
    k.h(paramViewGroup, "parent");
    boolean bool = v(paramViewGroup);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("attachVideoView, parent:").append(paramViewGroup.hashCode()).append(", isVideoPause:").append(this.yAi).append(", currentSessionId:").append(this.yAj).append(", isPlayingVideoItem:").append(this.yAk).append(" videoView ");
    Object localObject = this.yAh;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((com.tencent.mm.plugin.recordvideo.ui.editor.d)localObject).hashCode());
      ad.i(str, localObject + " sameParent " + bool + " this:" + hashCode());
      u(paramViewGroup);
      if (this.yAh == null)
      {
        localObject = aj.getContext();
        k.g(localObject, "MMApplicationContext.getContext()");
        gh((Context)localObject);
      }
      if (bool) {
        break label239;
      }
      if (paramLayoutParams != null) {
        break label224;
      }
      paramViewGroup.addView((View)this.yAh);
    }
    for (;;)
    {
      paramViewGroup = this.yAh;
      if (paramViewGroup == null) {
        break label260;
      }
      paramViewGroup.setAlpha(0.0F);
      AppMethodBeat.o(120514);
      return;
      localObject = null;
      break;
      label224:
      paramViewGroup.addView((View)this.yAh, paramLayoutParams);
      continue;
      label239:
      if (paramLayoutParams != null)
      {
        paramViewGroup = this.yAh;
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
      ad.i(this.TAG, "change:" + bool + ' ' + this.yAm + ", " + paramBoolean + ", changeVideoItem: origin: " + this.yAl + ", new: " + paramj + ",  change:" + bool + " this:" + hashCode());
      if (bool)
      {
        this.yAl = paramj;
        if ((this.yAm) || (paramBoolean))
        {
          qW(false);
          EN();
        }
      }
      AppMethodBeat.o(120515);
      return;
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(120525);
    ad.i(this.TAG, "onUIDestroy " + hashCode());
    this.yAm = false;
    u(null);
    this.yAl = null;
    this.yAh = null;
    if (this.yAo)
    {
      this.yAn.XF();
      this.yAo = false;
    }
    AppMethodBeat.o(120525);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(120524);
    ad.i(this.TAG, "onUIPause " + hashCode());
    u(null);
    if (this.yAo)
    {
      this.yAn.XF();
      this.yAo = false;
    }
    AppMethodBeat.o(120524);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(120523);
    ad.i(this.TAG, "onUIResume " + hashCode());
    if (this.yAm)
    {
      com.tencent.mm.plugin.recordvideo.ui.editor.d locald = this.yAh;
      if (locald != null) {
        locald.onUIResume();
      }
      if (!this.yAo)
      {
        this.yAn.requestFocus();
        this.yAo = true;
      }
    }
    AppMethodBeat.o(120523);
  }
  
  public final void qW(boolean paramBoolean)
  {
    AppMethodBeat.i(120520);
    ad.i(this.TAG, "stopVideo, detach: ".concat(String.valueOf(paramBoolean)));
    if (this.yAk)
    {
      this.yAj = null;
      com.tencent.mm.plugin.recordvideo.ui.editor.d locald = this.yAh;
      if (locald != null) {
        locald.stop();
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
    AppMethodBeat.o(120520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.l
 * JD-Core Version:    0.7.0.1
 */