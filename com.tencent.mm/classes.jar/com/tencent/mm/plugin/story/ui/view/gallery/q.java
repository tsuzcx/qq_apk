package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.v;
import a.y;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.util.UUID;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "", "()V", "STORY_VIDEO_VIEW_IDKEY_STAT", "", "TAG", "", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "currentSessionId", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "onlineVideoEventListener", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1;", "proxy", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayProxy;", "showLoadingTime", "", "videoView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView;", "videoViewCallback", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "checkPauseOnProgress", "getPlayStatus", "getVideoView", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "newVideoViewInstance", "onUIDestroy", "onUIPause", "onUIResume", "pauseVideo", "playVideo", "resetVideo", "sameParent", "setMute", "setNeedShowLoading", "show", "setVideoViewProp", "stopTask", "stopVideo", "detach", "VideoPlayCdnCallback", "VideoPlayProxy", "plugin-story_release"})
public final class q
{
  final String TAG;
  private boolean efg;
  boolean sUm;
  String sUn;
  private boolean sUo;
  com.tencent.mm.plugin.story.model.d.i sUp;
  boolean sUq;
  private com.tencent.mm.compatible.util.b sUr;
  private boolean sUs;
  StoryVideoView sVs;
  q.b sVt;
  final long sVu;
  int sVv;
  private final q.d sVw;
  private final q.e sVx;
  
  public q()
  {
    AppMethodBeat.i(111001);
    this.TAG = "MicroMsg.Gallery.StoryVideoViewMgr";
    this.sUr = new com.tencent.mm.compatible.util.b(ah.getContext());
    this.sVu = 987L;
    this.sVw = new q.d(this);
    ab.i(this.TAG, "init create StoryVideoViewMgr " + hashCode());
    com.tencent.mm.sdk.b.a.ymk.c((c)this.sVw);
    this.sVx = new q.e(this);
    AppMethodBeat.o(111001);
  }
  
  private final boolean h(com.tencent.mm.plugin.story.model.d.i parami)
  {
    AppMethodBeat.i(110988);
    if (parami.cIp != 0)
    {
      localObject = this.sUp;
      if ((localObject != null) && (((com.tencent.mm.plugin.story.model.d.i)localObject).cIp == parami.cIp))
      {
        AppMethodBeat.o(110988);
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
      AppMethodBeat.o(110988);
      return true;
      i = 0;
      break;
    }
    label123:
    AppMethodBeat.o(110988);
    return false;
  }
  
  private final boolean s(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(111000);
    Object localObject = this.sVs;
    if (localObject != null) {}
    for (localObject = ((StoryVideoView)localObject).getParent();; localObject = null)
    {
      boolean bool = j.e(localObject, paramViewGroup);
      AppMethodBeat.o(111000);
      return bool;
    }
  }
  
  public final void P(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(110992);
    ab.b(this.TAG, "stopVideo, detach: ".concat(String.valueOf(paramBoolean1)), new Object[0]);
    Object localObject;
    if (this.sUo)
    {
      this.sUn = null;
      localObject = this.sVs;
      if (localObject != null) {
        ((StoryVideoView)localObject).stop();
      }
      this.sUm = false;
      if (this.sUs)
      {
        this.sUr.Mh();
        this.sUs = false;
      }
      this.sUo = false;
    }
    if (paramBoolean1)
    {
      this.sUq = false;
      r(null);
      localObject = com.tencent.mm.plugin.story.g.i.sFa;
      com.tencent.mm.plugin.story.g.i.cDo().cH(System.currentTimeMillis());
      if (paramBoolean2)
      {
        localObject = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDp();
      }
    }
    AppMethodBeat.o(110992);
  }
  
  public final void a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(110987);
    j.q(paramViewGroup, "parent");
    this.sVv = 0;
    boolean bool = s(paramViewGroup);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("attachVideoView, parent:").append(paramViewGroup.hashCode()).append(", isVideoPause:").append(this.sUm).append(", currentSessionId:").append(this.sUn).append(", isPlayingVideoItem:").append(this.sUo).append(" videoView ");
    Object localObject = this.sVs;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((StoryVideoView)localObject).hashCode());; localObject = null)
    {
      ab.b(str, localObject + " sameParent " + bool + " this:" + hashCode(), new Object[0]);
      r(paramViewGroup);
      if (this.sVs == null)
      {
        localObject = ah.getContext();
        j.p(localObject, "MMApplicationContext.getContext()");
        fd((Context)localObject);
      }
      if (bool) {
        break label239;
      }
      if (paramLayoutParams != null) {
        break;
      }
      paramViewGroup.addView((View)this.sVs);
      AppMethodBeat.o(110987);
      return;
    }
    paramViewGroup.addView((View)this.sVs, paramLayoutParams);
    AppMethodBeat.o(110987);
    return;
    label239:
    if (paramLayoutParams != null)
    {
      paramViewGroup = this.sVs;
      if (paramViewGroup != null)
      {
        paramViewGroup.setLayoutParams(paramLayoutParams);
        AppMethodBeat.o(110987);
        return;
      }
    }
    AppMethodBeat.o(110987);
  }
  
  public final void a(com.tencent.mm.plugin.story.model.d.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(151349);
    j.q(parami, "item");
    if (!h(parami)) {}
    for (boolean bool = true;; bool = false)
    {
      ab.b(this.TAG, "change:" + bool + ' ' + this.sUq + ", " + paramBoolean + ", changeVideoItem: origin: " + this.sUp + ", new: " + parami + ",  change:" + bool + " this:" + hashCode(), new Object[0]);
      if (bool)
      {
        this.sUp = parami;
        if ((this.sUq) || (paramBoolean))
        {
          a(this, false, 2);
          cGe();
        }
      }
      AppMethodBeat.o(151349);
      return;
    }
  }
  
  public final void aEM()
  {
    AppMethodBeat.i(110997);
    ab.i(this.TAG, "onUIDestroy " + hashCode());
    this.sUq = false;
    r(null);
    this.sUp = null;
    this.sVs = null;
    if (this.sUs)
    {
      this.sUr.Mh();
      this.sUs = false;
    }
    com.tencent.mm.sdk.b.a.ymk.d((c)this.sVw);
    AppMethodBeat.o(110997);
  }
  
  public final void alo()
  {
    AppMethodBeat.i(110996);
    ab.i(this.TAG, "onUIPause " + hashCode());
    r(null);
    if (this.sUs)
    {
      this.sUr.Mh();
      this.sUs = false;
    }
    AppMethodBeat.o(110996);
  }
  
  public final void alp()
  {
    AppMethodBeat.i(110995);
    StoryVideoView localStoryVideoView = this.sVs;
    if (localStoryVideoView != null)
    {
      localStoryVideoView.alp();
      AppMethodBeat.o(110995);
      return;
    }
    AppMethodBeat.o(110995);
  }
  
  public final void cGe()
  {
    AppMethodBeat.i(110990);
    ab.b(this.TAG, "playVideo, " + this.sUm + ' ' + this.sUq + ", " + this.sUp, new Object[0]);
    cGf();
    this.sUq = true;
    Object localObject1 = this.sUp;
    if (localObject1 != null)
    {
      boolean bool = this.sUm;
      this.sUm = false;
      if (!bool) {
        break label184;
      }
      localObject2 = this.sVs;
      if (localObject2 != null) {
        ((StoryVideoView)localObject2).g((com.tencent.mm.plugin.story.model.d.i)localObject1);
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
    localObject1 = this.sVs;
    if (localObject1 != null) {}
    for (localObject1 = ((StoryVideoView)localObject1).getContext();; localObject1 = null)
    {
      ((ba)localObject2).cD(at.gV((Context)localObject1));
      AppMethodBeat.o(110990);
      return;
      label184:
      this.sUn = UUID.randomUUID().toString();
      localObject2 = this.sVt;
      if (localObject2 != null) {
        ((q.b)localObject2).p((com.tencent.mm.plugin.story.model.d.i)localObject1);
      }
      localObject2 = this.sVs;
      if (localObject2 == null) {
        break;
      }
      ((StoryVideoView)localObject2).a((com.tencent.mm.plugin.story.model.d.i)localObject1, this.sUn);
      break;
    }
  }
  
  final void cGf()
  {
    AppMethodBeat.i(110991);
    ab.i(this.TAG, "setVideoViewProp, isMute:" + this.efg);
    StoryVideoView localStoryVideoView = this.sVs;
    if (localStoryVideoView != null)
    {
      localStoryVideoView.setMute(this.efg);
      AppMethodBeat.o(110991);
      return;
    }
    AppMethodBeat.o(110991);
  }
  
  final void fd(Context paramContext)
  {
    AppMethodBeat.i(110998);
    this.sVs = new StoryVideoView(paramContext);
    this.sVt = new q.b(this);
    paramContext = this.sVs;
    if (paramContext != null) {
      paramContext.setIOnlineVideoProxy((com.tencent.mm.modelvideo.b)this.sVt);
    }
    paramContext = this.sVs;
    if (paramContext != null) {
      paramContext.setIMMVideoViewCallback((h.b)this.sVx);
    }
    paramContext = this.sVs;
    if (paramContext != null) {
      paramContext.setReporter((h.c)new q.c(this));
    }
    this.sUo = false;
    AppMethodBeat.o(110998);
  }
  
  final void r(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(110999);
    String str = this.TAG;
    Object localObject1 = new StringBuilder("checkDetachVideoView, videoView:");
    Object localObject2 = this.sVs;
    int i;
    boolean bool;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", isPlay:");
      localObject2 = this.sVs;
      if (localObject2 == null) {
        break label248;
      }
      bool = ((StoryVideoView)localObject2).isPlaying();
      label72:
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", parent:");
      localObject1 = this.sVs;
      if (localObject1 == null) {
        break label253;
      }
      localObject1 = ((StoryVideoView)localObject1).getParent();
      label104:
      if (localObject1 == null) {
        break label259;
      }
      i = localObject1.hashCode();
      label115:
      localObject1 = ((StringBuilder)localObject2).append(i).append(", newParent:");
      if (paramViewGroup == null) {
        break label264;
      }
      i = paramViewGroup.hashCode();
      label138:
      ab.b(str, i + ", isPlayingVideoItem:" + this.sUo, new Object[0]);
      localObject1 = this.sVs;
      if (localObject1 == null) {
        break label269;
      }
      localObject1 = ((StoryVideoView)localObject1).getParent();
      label187:
      if ((localObject1 == null) || (s(paramViewGroup))) {
        break label299;
      }
      a(this, true, 1);
      paramViewGroup = this.sVs;
      if (paramViewGroup == null) {
        break label275;
      }
    }
    label259:
    label264:
    label269:
    label275:
    for (paramViewGroup = paramViewGroup.getParent();; paramViewGroup = null)
    {
      if (paramViewGroup != null) {
        break label280;
      }
      paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(110999);
      throw paramViewGroup;
      i = 0;
      break;
      label248:
      bool = false;
      break label72;
      label253:
      localObject1 = null;
      break label104;
      i = 0;
      break label115;
      i = 0;
      break label138;
      localObject1 = null;
      break label187;
    }
    label280:
    ((ViewGroup)paramViewGroup).removeView((View)this.sVs);
    this.sUp = null;
    label299:
    AppMethodBeat.o(110999);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(110994);
    j.p("", "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
    ab.i(this.TAG, "setMute " + paramBoolean + " ret " + "");
    this.efg = paramBoolean;
    AppMethodBeat.o(110994);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class a$a
    extends k
    implements a.f.a.a<y>
  {
    a$a(q.a parama, String paramString, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.q
 * JD-Core Version:    0.7.0.1
 */