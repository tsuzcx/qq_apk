package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.f;
import com.tencent.mm.plugin.story.f.d.j;
import com.tencent.mm.plugin.story.f.e.a;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryImageVideoViewMgr;", "", "()V", "TAG", "", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "currentSessionId", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "videoView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "getPlayStatus", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "onUIDestroy", "onUIPause", "onUIResume", "playVideo", "sameParent", "setMute", "setVideoViewProp", "stopVideo", "detach", "plugin-story_release"})
public final class l
{
  f FHf;
  private boolean FHg;
  private String FHh;
  private boolean FHi;
  private j FHj;
  boolean FHk;
  private b FHl;
  private boolean FHm;
  final String TAG;
  boolean guh;
  
  public l()
  {
    AppMethodBeat.i(120526);
    this.TAG = "MicroMsg.Gallery.StoryImageVideoViewMgr";
    this.FHl = new b(MMApplicationContext.getContext());
    AppMethodBeat.o(120526);
  }
  
  private final void H(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120516);
    String str = this.TAG;
    Object localObject1 = new StringBuilder("checkDetachVideoView, videoView:");
    Object localObject2 = this.FHf;
    int i;
    boolean bool;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", isPlay:");
      localObject2 = this.FHf;
      if (localObject2 == null) {
        break label235;
      }
      bool = ((f)localObject2).isPlaying();
      label69:
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", parent:");
      localObject1 = this.FHf;
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
      Log.i(str, i + ", isPlayingVideoItem:" + this.FHi);
      localObject1 = this.FHf;
      if (localObject1 == null) {
        break label256;
      }
      localObject1 = ((f)localObject1).getParent();
      label177:
      if ((localObject1 == null) || (I(paramViewGroup))) {
        break label286;
      }
      wb(false);
      paramViewGroup = this.FHf;
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
    ((ViewGroup)paramViewGroup).removeView((View)this.FHf);
    this.FHj = null;
    label286:
    AppMethodBeat.o(120516);
  }
  
  private final boolean I(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120517);
    Object localObject = this.FHf;
    if (localObject != null) {}
    for (localObject = ((f)localObject).getParent();; localObject = null)
    {
      boolean bool = p.j(localObject, paramViewGroup);
      AppMethodBeat.o(120517);
      return bool;
    }
  }
  
  private final void fst()
  {
    AppMethodBeat.i(120522);
    Log.i(this.TAG, "setVideoViewProp, isMute:" + this.guh);
    f localf = this.FHf;
    if (localf != null)
    {
      localf.setMute(this.guh);
      AppMethodBeat.o(120522);
      return;
    }
    AppMethodBeat.o(120522);
  }
  
  private final boolean g(j paramj)
  {
    AppMethodBeat.i(120518);
    if (paramj.ecf != 0)
    {
      localObject = this.FHj;
      if ((localObject != null) && (((j)localObject).ecf == paramj.ecf))
      {
        AppMethodBeat.o(120518);
        return true;
      }
    }
    Object localObject = (CharSequence)paramj.Fpd.Url;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label123;
      }
      localObject = this.FHj;
      if (localObject == null) {
        break label118;
      }
      localObject = ((j)localObject).Fpd;
      if (localObject == null) {
        break label118;
      }
    }
    label118:
    for (localObject = ((edt)localObject).Url;; localObject = null)
    {
      if (!p.j(localObject, paramj.Fpd.Url)) {
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
  
  private final void hm(Context paramContext)
  {
    AppMethodBeat.i(120519);
    a locala = a.Fpl;
    this.FHf = a.hl(paramContext);
    this.FHi = false;
    AppMethodBeat.o(120519);
  }
  
  public final void PF()
  {
    AppMethodBeat.i(120521);
    Log.printInfoStack(this.TAG, "playVideo, " + this.FHg + ' ' + this.FHk + ", " + this.FHj, new Object[0]);
    fst();
    this.FHk = true;
    j localj = this.FHj;
    if (localj != null)
    {
      boolean bool = this.FHg;
      this.FHg = false;
      if (!bool) {
        break label201;
      }
      localObject1 = this.FHf;
      if (localObject1 != null) {
        ((f)localObject1).setAlpha(1.0F);
      }
      localObject1 = this.FHf;
      if (localObject1 != null) {
        ((f)localObject1).b(localj.Fpe);
      }
      this.FHg = false;
      if (localj.foW()) {
        this.FHi = true;
      }
      if (!this.FHm)
      {
        this.FHl.requestFocus();
        this.FHm = true;
      }
    }
    Object localObject1 = h.FuH;
    Object localObject2 = h.fqi();
    localObject1 = this.FHf;
    if (localObject1 != null) {}
    for (localObject1 = ((f)localObject1).getContext();; localObject1 = null)
    {
      ((jo)localObject2).sk(NetStatusUtil.getIOSNetType((Context)localObject1));
      AppMethodBeat.o(120521);
      return;
      label201:
      this.FHh = UUID.randomUUID().toString();
      f localf = this.FHf;
      if (localf == null) {
        break;
      }
      localObject2 = localj.Fpe;
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
    boolean bool = I(paramViewGroup);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("attachVideoView, parent:").append(paramViewGroup.hashCode()).append(", isVideoPause:").append(this.FHg).append(", currentSessionId:").append(this.FHh).append(", isPlayingVideoItem:").append(this.FHi).append(" videoView ");
    Object localObject = this.FHf;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((f)localObject).hashCode());
      Log.i(str, localObject + " sameParent " + bool + " this:" + hashCode());
      H(paramViewGroup);
      if (this.FHf == null)
      {
        localObject = MMApplicationContext.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        hm((Context)localObject);
      }
      if (bool) {
        break label239;
      }
      if (paramLayoutParams != null) {
        break label224;
      }
      paramViewGroup.addView((View)this.FHf);
    }
    for (;;)
    {
      paramViewGroup = this.FHf;
      if (paramViewGroup == null) {
        break label260;
      }
      paramViewGroup.setAlpha(0.0F);
      AppMethodBeat.o(120514);
      return;
      localObject = null;
      break;
      label224:
      paramViewGroup.addView((View)this.FHf, paramLayoutParams);
      continue;
      label239:
      if (paramLayoutParams != null)
      {
        paramViewGroup = this.FHf;
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
      Log.i(this.TAG, "change:" + bool + ' ' + this.FHk + ", " + paramBoolean + ", changeVideoItem: origin: " + this.FHj + ", new: " + paramj + ",  change:" + bool + " this:" + hashCode());
      if (bool)
      {
        this.FHj = paramj;
        if ((this.FHk) || (paramBoolean))
        {
          wb(false);
          PF();
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
    this.FHk = false;
    H(null);
    this.FHj = null;
    this.FHf = null;
    if (this.FHm)
    {
      this.FHl.apm();
      this.FHm = false;
    }
    AppMethodBeat.o(120525);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(120524);
    Log.i(this.TAG, "onUIPause " + hashCode());
    H(null);
    if (this.FHm)
    {
      this.FHl.apm();
      this.FHm = false;
    }
    AppMethodBeat.o(120524);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(120523);
    Log.i(this.TAG, "onUIResume " + hashCode());
    if (this.FHk)
    {
      f localf = this.FHf;
      if (localf != null) {
        localf.onUIResume();
      }
      if (!this.FHm)
      {
        this.FHl.requestFocus();
        this.FHm = true;
      }
    }
    AppMethodBeat.o(120523);
  }
  
  public final void wb(boolean paramBoolean)
  {
    AppMethodBeat.i(120520);
    Log.i(this.TAG, "stopVideo, detach: ".concat(String.valueOf(paramBoolean)));
    if (this.FHi)
    {
      this.FHh = null;
      f localf = this.FHf;
      if (localf != null) {
        localf.stop();
      }
      this.FHg = false;
      if (this.FHm)
      {
        this.FHl.apm();
        this.FHm = false;
      }
      this.FHi = false;
    }
    if (paramBoolean)
    {
      this.FHk = false;
      H(null);
    }
    AppMethodBeat.o(120520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.l
 * JD-Core Version:    0.7.0.1
 */