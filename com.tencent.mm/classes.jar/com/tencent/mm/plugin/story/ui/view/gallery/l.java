package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.f.b.a.lx;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.f;
import com.tencent.mm.plugin.story.f.d.j;
import com.tencent.mm.plugin.story.f.e.a;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryImageVideoViewMgr;", "", "()V", "TAG", "", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "currentSessionId", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "videoView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "getPlayStatus", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "onUIDestroy", "onUIPause", "onUIResume", "playVideo", "sameParent", "setMute", "setVideoViewProp", "stopVideo", "detach", "plugin-story_release"})
public final class l
{
  f Mbf;
  private boolean Mbg;
  private String Mbh;
  private boolean Mbi;
  private j Mbj;
  boolean Mbk;
  private b Mbl;
  private boolean Mbm;
  final String TAG;
  boolean iYs;
  
  public l()
  {
    AppMethodBeat.i(120526);
    this.TAG = "MicroMsg.Gallery.StoryImageVideoViewMgr";
    this.Mbl = new b(MMApplicationContext.getContext());
    AppMethodBeat.o(120526);
  }
  
  private final void O(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120516);
    String str = this.TAG;
    Object localObject1 = new StringBuilder("checkDetachVideoView, videoView:");
    Object localObject2 = this.Mbf;
    int i;
    boolean bool;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", isPlay:");
      localObject2 = this.Mbf;
      if (localObject2 == null) {
        break label235;
      }
      bool = ((f)localObject2).isPlaying();
      label69:
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", parent:");
      localObject1 = this.Mbf;
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
      Log.i(str, i + ", isPlayingVideoItem:" + this.Mbi);
      localObject1 = this.Mbf;
      if (localObject1 == null) {
        break label256;
      }
      localObject1 = ((f)localObject1).getParent();
      label177:
      if ((localObject1 == null) || (P(paramViewGroup))) {
        break label286;
      }
      zH(false);
      paramViewGroup = this.Mbf;
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
      paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup");
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
    ((ViewGroup)paramViewGroup).removeView((View)this.Mbf);
    this.Mbj = null;
    label286:
    AppMethodBeat.o(120516);
  }
  
  private final boolean P(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120517);
    Object localObject = this.Mbf;
    if (localObject != null) {}
    for (localObject = ((f)localObject).getParent();; localObject = null)
    {
      boolean bool = p.h(localObject, paramViewGroup);
      AppMethodBeat.o(120517);
      return bool;
    }
  }
  
  private final boolean g(j paramj)
  {
    AppMethodBeat.i(120518);
    if (paramj.fWh != 0)
    {
      localObject = this.Mbj;
      if ((localObject != null) && (((j)localObject).fWh == paramj.fWh))
      {
        AppMethodBeat.o(120518);
        return true;
      }
    }
    Object localObject = (CharSequence)paramj.LJf.Url;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label123;
      }
      localObject = this.Mbj;
      if (localObject == null) {
        break label118;
      }
      localObject = ((j)localObject).LJf;
      if (localObject == null) {
        break label118;
      }
    }
    label118:
    for (localObject = ((enu)localObject).Url;; localObject = null)
    {
      if (!p.h(localObject, paramj.LJf.Url)) {
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
  
  private final void ggR()
  {
    AppMethodBeat.i(120522);
    Log.i(this.TAG, "setVideoViewProp, isMute:" + this.iYs);
    f localf = this.Mbf;
    if (localf != null)
    {
      localf.setMute(this.iYs);
      AppMethodBeat.o(120522);
      return;
    }
    AppMethodBeat.o(120522);
  }
  
  private final void in(Context paramContext)
  {
    AppMethodBeat.i(120519);
    a locala = a.LJn;
    this.Mbf = a.im(paramContext);
    this.Mbi = false;
    AppMethodBeat.o(120519);
  }
  
  public final void Tf()
  {
    AppMethodBeat.i(120521);
    Log.printInfoStack(this.TAG, "playVideo, " + this.Mbg + ' ' + this.Mbk + ", " + this.Mbj, new Object[0]);
    ggR();
    this.Mbk = true;
    j localj = this.Mbj;
    if (localj != null)
    {
      boolean bool = this.Mbg;
      this.Mbg = false;
      if (!bool) {
        break label201;
      }
      localObject1 = this.Mbf;
      if (localObject1 != null) {
        ((f)localObject1).setAlpha(1.0F);
      }
      localObject1 = this.Mbf;
      if (localObject1 != null) {
        ((f)localObject1).b(localj.LJg);
      }
      this.Mbg = false;
      if (localj.gdq()) {
        this.Mbi = true;
      }
      if (!this.Mbm)
      {
        this.Mbl.avy();
        this.Mbm = true;
      }
    }
    Object localObject1 = h.LOJ;
    Object localObject2 = h.geE();
    localObject1 = this.Mbf;
    if (localObject1 != null) {}
    for (localObject1 = ((f)localObject1).getContext();; localObject1 = null)
    {
      ((lx)localObject2).wm(NetStatusUtil.getIOSNetType((Context)localObject1));
      AppMethodBeat.o(120521);
      return;
      label201:
      this.Mbh = UUID.randomUUID().toString();
      f localf = this.Mbf;
      if (localf == null) {
        break;
      }
      localObject2 = localj.LJg;
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
    p.k(paramViewGroup, "parent");
    boolean bool = P(paramViewGroup);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("attachVideoView, parent:").append(paramViewGroup.hashCode()).append(", isVideoPause:").append(this.Mbg).append(", currentSessionId:").append(this.Mbh).append(", isPlayingVideoItem:").append(this.Mbi).append(" videoView ");
    Object localObject = this.Mbf;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((f)localObject).hashCode());
      Log.i(str, localObject + " sameParent " + bool + " this:" + hashCode());
      O(paramViewGroup);
      if (this.Mbf == null)
      {
        localObject = MMApplicationContext.getContext();
        p.j(localObject, "MMApplicationContext.getContext()");
        in((Context)localObject);
      }
      if (bool) {
        break label239;
      }
      if (paramLayoutParams != null) {
        break label224;
      }
      paramViewGroup.addView((View)this.Mbf);
    }
    for (;;)
    {
      paramViewGroup = this.Mbf;
      if (paramViewGroup == null) {
        break label260;
      }
      paramViewGroup.setAlpha(0.0F);
      AppMethodBeat.o(120514);
      return;
      localObject = null;
      break;
      label224:
      paramViewGroup.addView((View)this.Mbf, paramLayoutParams);
      continue;
      label239:
      if (paramLayoutParams != null)
      {
        paramViewGroup = this.Mbf;
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
    p.k(paramj, "item");
    if (!g(paramj)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(this.TAG, "change:" + bool + ' ' + this.Mbk + ", " + paramBoolean + ", changeVideoItem: origin: " + this.Mbj + ", new: " + paramj + ",  change:" + bool + " this:" + hashCode());
      if (bool)
      {
        this.Mbj = paramj;
        if ((this.Mbk) || (paramBoolean))
        {
          zH(false);
          Tf();
        }
      }
      AppMethodBeat.o(120515);
      return;
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(120525);
    Log.i(this.TAG, "onUIDestroy " + hashCode());
    this.Mbk = false;
    O(null);
    this.Mbj = null;
    this.Mbf = null;
    if (this.Mbm)
    {
      this.Mbl.avz();
      this.Mbm = false;
    }
    AppMethodBeat.o(120525);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(120524);
    Log.i(this.TAG, "onUIPause " + hashCode());
    O(null);
    if (this.Mbm)
    {
      this.Mbl.avz();
      this.Mbm = false;
    }
    AppMethodBeat.o(120524);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(120523);
    Log.i(this.TAG, "onUIResume " + hashCode());
    if (this.Mbk)
    {
      f localf = this.Mbf;
      if (localf != null) {
        localf.onUIResume();
      }
      if (!this.Mbm)
      {
        this.Mbl.avy();
        this.Mbm = true;
      }
    }
    AppMethodBeat.o(120523);
  }
  
  public final void zH(boolean paramBoolean)
  {
    AppMethodBeat.i(120520);
    Log.i(this.TAG, "stopVideo, detach: ".concat(String.valueOf(paramBoolean)));
    if (this.Mbi)
    {
      this.Mbh = null;
      f localf = this.Mbf;
      if (localf != null) {
        localf.stop();
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
    AppMethodBeat.o(120520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.l
 * JD-Core Version:    0.7.0.1
 */