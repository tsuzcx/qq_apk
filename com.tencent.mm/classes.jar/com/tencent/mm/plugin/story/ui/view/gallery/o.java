package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.util.UUID;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryImageVideoViewMgr;", "", "()V", "TAG", "", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "currentSessionId", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "videoView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryImageVideoView;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "getPlayStatus", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "onUIDestroy", "onUIPause", "onUIResume", "playVideo", "sameParent", "setMute", "setVideoViewProp", "stopVideo", "detach", "plugin-story_release"})
public final class o
{
  final String TAG;
  boolean efg;
  n sUl;
  private boolean sUm;
  private String sUn;
  private boolean sUo;
  private com.tencent.mm.plugin.story.model.d.i sUp;
  boolean sUq;
  private b sUr;
  private boolean sUs;
  
  public o()
  {
    AppMethodBeat.i(151344);
    this.TAG = "MicroMsg.Gallery.StoryImageVideoViewMgr";
    this.sUr = new b(ah.getContext());
    AppMethodBeat.o(151344);
  }
  
  private final void cGf()
  {
    AppMethodBeat.i(151340);
    ab.i(this.TAG, "setVideoViewProp, isMute:" + this.efg);
    n localn = this.sUl;
    if (localn != null)
    {
      localn.setMute(this.efg);
      AppMethodBeat.o(151340);
      return;
    }
    AppMethodBeat.o(151340);
  }
  
  private final void fd(Context paramContext)
  {
    AppMethodBeat.i(151337);
    this.sUl = new n(paramContext);
    this.sUo = false;
    AppMethodBeat.o(151337);
  }
  
  private final boolean h(com.tencent.mm.plugin.story.model.d.i parami)
  {
    AppMethodBeat.i(151336);
    if (parami.cIp != 0)
    {
      localObject = this.sUp;
      if ((localObject != null) && (((com.tencent.mm.plugin.story.model.d.i)localObject).cIp == parami.cIp))
      {
        AppMethodBeat.o(151336);
        return true;
      }
    }
    Object localObject = (CharSequence)parami.syB.Url;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label123;
      }
      localObject = this.sUp;
      if (localObject == null) {
        break label118;
      }
      localObject = ((com.tencent.mm.plugin.story.model.d.i)localObject).syB;
      if (localObject == null) {
        break label118;
      }
    }
    label118:
    for (localObject = ((chl)localObject).Url;; localObject = null)
    {
      if (!j.e(localObject, parami.syB.Url)) {
        break label123;
      }
      AppMethodBeat.o(151336);
      return true;
      i = 0;
      break;
    }
    label123:
    AppMethodBeat.o(151336);
    return false;
  }
  
  private final void r(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(151334);
    String str = this.TAG;
    Object localObject1 = new StringBuilder("checkDetachVideoView, videoView:");
    Object localObject2 = this.sUl;
    int i;
    boolean bool;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", isPlay:");
      localObject2 = this.sUl;
      if (localObject2 == null) {
        break label235;
      }
      bool = ((n)localObject2).isPlaying();
      label69:
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", parent:");
      localObject1 = this.sUl;
      if (localObject1 == null) {
        break label240;
      }
      localObject1 = ((n)localObject1).getParent();
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
      ab.i(str, i + ", isPlayingVideoItem:" + this.sUo);
      localObject1 = this.sUl;
      if (localObject1 == null) {
        break label256;
      }
      localObject1 = ((n)localObject1).getParent();
      label177:
      if ((localObject1 == null) || (s(paramViewGroup))) {
        break label286;
      }
      ms(false);
      paramViewGroup = this.sUl;
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
      AppMethodBeat.o(151334);
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
    ((ViewGroup)paramViewGroup).removeView((View)this.sUl);
    this.sUp = null;
    label286:
    AppMethodBeat.o(151334);
  }
  
  private final boolean s(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(151335);
    Object localObject = this.sUl;
    if (localObject != null) {}
    for (localObject = ((n)localObject).getParent();; localObject = null)
    {
      boolean bool = j.e(localObject, paramViewGroup);
      AppMethodBeat.o(151335);
      return bool;
    }
  }
  
  public final void a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(151332);
    j.q(paramViewGroup, "parent");
    boolean bool = s(paramViewGroup);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("attachVideoView, parent:").append(paramViewGroup.hashCode()).append(", isVideoPause:").append(this.sUm).append(", currentSessionId:").append(this.sUn).append(", isPlayingVideoItem:").append(this.sUo).append(" videoView ");
    Object localObject = this.sUl;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((n)localObject).hashCode());
      ab.i(str, localObject + " sameParent " + bool + " this:" + hashCode());
      r(paramViewGroup);
      if (this.sUl == null)
      {
        localObject = ah.getContext();
        j.p(localObject, "MMApplicationContext.getContext()");
        fd((Context)localObject);
      }
      if (bool) {
        break label230;
      }
      if (paramLayoutParams != null) {
        break label215;
      }
      paramViewGroup.addView((View)this.sUl);
    }
    for (;;)
    {
      paramViewGroup = this.sUl;
      if (paramViewGroup == null) {
        break label251;
      }
      paramViewGroup.setAlpha(0.0F);
      AppMethodBeat.o(151332);
      return;
      localObject = null;
      break;
      label215:
      paramViewGroup.addView((View)this.sUl, paramLayoutParams);
      continue;
      label230:
      if (paramLayoutParams != null)
      {
        paramViewGroup = this.sUl;
        if (paramViewGroup != null) {
          paramViewGroup.setLayoutParams(paramLayoutParams);
        }
      }
    }
    label251:
    AppMethodBeat.o(151332);
  }
  
  public final void a(com.tencent.mm.plugin.story.model.d.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(151333);
    j.q(parami, "item");
    if (!h(parami)) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i(this.TAG, "change:" + bool + ' ' + this.sUq + ", " + paramBoolean + ", changeVideoItem: origin: " + this.sUp + ", new: " + parami + ",  change:" + bool + " this:" + hashCode());
      if (bool)
      {
        this.sUp = parami;
        if ((this.sUq) || (paramBoolean))
        {
          ms(false);
          cGe();
        }
      }
      AppMethodBeat.o(151333);
      return;
    }
  }
  
  public final void aEM()
  {
    AppMethodBeat.i(151343);
    ab.i(this.TAG, "onUIDestroy " + hashCode());
    this.sUq = false;
    r(null);
    this.sUp = null;
    this.sUl = null;
    if (this.sUs)
    {
      this.sUr.Mh();
      this.sUs = false;
    }
    AppMethodBeat.o(151343);
  }
  
  public final void alo()
  {
    AppMethodBeat.i(151342);
    ab.i(this.TAG, "onUIPause " + hashCode());
    r(null);
    if (this.sUs)
    {
      this.sUr.Mh();
      this.sUs = false;
    }
    AppMethodBeat.o(151342);
  }
  
  public final void alp()
  {
    AppMethodBeat.i(151341);
    ab.i(this.TAG, "onUIResume " + hashCode());
    if (this.sUq)
    {
      n localn = this.sUl;
      if (localn != null) {
        localn.alp();
      }
      if (!this.sUs)
      {
        this.sUr.requestFocus();
        this.sUs = true;
      }
    }
    AppMethodBeat.o(151341);
  }
  
  public final void cGe()
  {
    AppMethodBeat.i(151339);
    ab.b(this.TAG, "playVideo, " + this.sUm + ' ' + this.sUq + ", " + this.sUp, new Object[0]);
    cGf();
    this.sUq = true;
    Object localObject1 = this.sUp;
    if (localObject1 != null)
    {
      boolean bool = this.sUm;
      this.sUm = false;
      if (!bool) {
        break label198;
      }
      localObject2 = this.sUl;
      if (localObject2 != null) {
        ((n)localObject2).setAlpha(1.0F);
      }
      localObject2 = this.sUl;
      if (localObject2 != null) {
        ((n)localObject2).g((com.tencent.mm.plugin.story.model.d.i)localObject1);
      }
      this.sUm = false;
      if (((com.tencent.mm.plugin.story.model.d.i)localObject1).cBN()) {
        this.sUo = true;
      }
      if (!this.sUs)
      {
        this.sUr.requestFocus();
        this.sUs = true;
      }
    }
    localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
    Object localObject2 = com.tencent.mm.plugin.story.g.i.cDo();
    localObject1 = this.sUl;
    if (localObject1 != null) {}
    for (localObject1 = ((n)localObject1).getContext();; localObject1 = null)
    {
      ((ba)localObject2).cD(at.gV((Context)localObject1));
      AppMethodBeat.o(151339);
      return;
      label198:
      this.sUn = UUID.randomUUID().toString();
      localObject2 = this.sUl;
      if (localObject2 == null) {
        break;
      }
      ((n)localObject2).f((com.tencent.mm.plugin.story.model.d.i)localObject1);
      break;
    }
  }
  
  public final void ms(boolean paramBoolean)
  {
    AppMethodBeat.i(151338);
    ab.i(this.TAG, "stopVideo, detach: ".concat(String.valueOf(paramBoolean)));
    if (this.sUo)
    {
      this.sUn = null;
      n localn = this.sUl;
      if (localn != null) {
        localn.stop();
      }
      this.sUm = false;
      if (this.sUs)
      {
        this.sUr.Mh();
        this.sUs = false;
      }
      this.sUo = false;
    }
    if (paramBoolean)
    {
      this.sUq = false;
      r(null);
    }
    AppMethodBeat.o(151338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.o
 * JD-Core Version:    0.7.0.1
 */