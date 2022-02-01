package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.g.b.a.de;
import com.tencent.mm.g.b.a.dl;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.v;
import d.y;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "", "()V", "STORY_VIDEO_VIEW_IDKEY_STAT", "", "TAG", "", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "currentSessionId", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "onlineVideoEventListener", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1;", "proxy", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayProxy;", "showLoadingTime", "", "videoView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView;", "videoViewCallback", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "checkPauseOnProgress", "getPlayStatus", "getVideoView", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "newVideoViewInstance", "onUIDestroy", "onUIPause", "onUIResume", "pauseVideo", "playVideo", "resetVideo", "sameParent", "setMute", "setNeedShowLoading", "show", "setVideoViewProp", "stopTask", "stopVideo", "detach", "VideoPlayCdnCallback", "VideoPlayProxy", "plugin-story_release"})
public final class n
{
  final String TAG;
  private boolean fqj;
  boolean yAi;
  String yAj;
  private boolean yAk;
  com.tencent.mm.plugin.story.f.d.j yAl;
  boolean yAm;
  private com.tencent.mm.compatible.util.b yAn;
  private boolean yAo;
  StoryVideoView yBe;
  b yBf;
  final long yBg;
  int yBh;
  private final d yBi;
  private final e yBj;
  
  public n()
  {
    AppMethodBeat.i(120664);
    this.TAG = "MicroMsg.Gallery.StoryVideoViewMgr";
    this.yAn = new com.tencent.mm.compatible.util.b(aj.getContext());
    this.yBg = 987L;
    this.yBi = new d(this);
    ad.i(this.TAG, "init create StoryVideoViewMgr " + hashCode());
    com.tencent.mm.sdk.b.a.ESL.c((com.tencent.mm.sdk.b.c)this.yBi);
    this.yBj = new e(this);
    AppMethodBeat.o(120664);
  }
  
  private final boolean g(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    Object localObject2 = null;
    AppMethodBeat.i(120651);
    Object localObject3;
    if (paramj.dzf != 0)
    {
      localObject1 = this.yAl;
      if ((localObject1 != null) && (((com.tencent.mm.plugin.story.f.d.j)localObject1).dzf == paramj.dzf))
      {
        localObject3 = paramj.yhO;
        localObject1 = this.yAl;
        if (localObject1 != null) {}
        for (localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).yhO; localObject3 == localObject1; localObject1 = null)
        {
          AppMethodBeat.o(120651);
          return true;
        }
      }
    }
    Object localObject1 = (CharSequence)paramj.yhP.Url;
    int i;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label187;
      }
      localObject1 = this.yAl;
      if (localObject1 == null) {
        break label182;
      }
      localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).yhP;
      if (localObject1 == null) {
        break label182;
      }
    }
    label182:
    for (localObject1 = ((cym)localObject1).Url;; localObject1 = null)
    {
      if (!d.g.b.k.g(localObject1, paramj.yhP.Url)) {
        break label187;
      }
      localObject1 = paramj.yhO;
      localObject3 = this.yAl;
      paramj = localObject2;
      if (localObject3 != null) {
        paramj = ((com.tencent.mm.plugin.story.f.d.j)localObject3).yhO;
      }
      if (localObject1 != paramj) {
        break label187;
      }
      AppMethodBeat.o(120651);
      return true;
      i = 0;
      break;
    }
    label187:
    AppMethodBeat.o(120651);
    return false;
  }
  
  private final boolean v(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120663);
    Object localObject = this.yBe;
    if (localObject != null) {}
    for (localObject = ((StoryVideoView)localObject).getParent();; localObject = null)
    {
      boolean bool = d.g.b.k.g(localObject, paramViewGroup);
      AppMethodBeat.o(120663);
      return bool;
    }
  }
  
  public final void EN()
  {
    AppMethodBeat.i(120653);
    ad.m(this.TAG, "playVideo, " + this.yAi + ' ' + this.yAm + ", " + this.yAl, new Object[0]);
    dLw();
    this.yAm = true;
    Object localObject1 = this.yAl;
    if (localObject1 != null)
    {
      boolean bool = this.yAi;
      this.yAi = false;
      if (!bool) {
        break label182;
      }
      localObject2 = this.yBe;
      if (localObject2 != null) {
        ((StoryVideoView)localObject2).o((com.tencent.mm.plugin.story.f.d.j)localObject1);
      }
      this.yAi = false;
      if (((com.tencent.mm.plugin.story.f.d.j)localObject1).dHX()) {
        this.yAk = true;
      }
      if (!this.yAo)
      {
        this.yAn.requestFocus();
        this.yAo = true;
      }
    }
    localObject1 = com.tencent.mm.plugin.story.h.h.ynv;
    Object localObject2 = com.tencent.mm.plugin.story.h.h.dJj();
    localObject1 = this.yBe;
    if (localObject1 != null) {}
    for (localObject1 = ((StoryVideoView)localObject1).getContext();; localObject1 = null)
    {
      ((dl)localObject2).fY(ay.ix((Context)localObject1));
      AppMethodBeat.o(120653);
      return;
      label182:
      this.yAj = UUID.randomUUID().toString();
      localObject2 = this.yBf;
      if (localObject2 != null) {
        ((b)localObject2).p((com.tencent.mm.plugin.story.f.d.j)localObject1);
      }
      localObject2 = this.yBe;
      if (localObject2 == null) {
        break;
      }
      ((StoryVideoView)localObject2).a((com.tencent.mm.plugin.story.f.d.j)localObject1, this.yAj);
      break;
    }
  }
  
  public final void a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(120650);
    d.g.b.k.h(paramViewGroup, "parent");
    this.yBh = 0;
    boolean bool = v(paramViewGroup);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("attachVideoView, parent:").append(paramViewGroup.hashCode()).append(", isVideoPause:").append(this.yAi).append(", currentSessionId:").append(this.yAj).append(", isPlayingVideoItem:").append(this.yAk).append(" videoView ");
    Object localObject = this.yBe;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((StoryVideoView)localObject).hashCode());; localObject = null)
    {
      ad.m(str, localObject + " sameParent " + bool + " this:" + hashCode(), new Object[0]);
      u(paramViewGroup);
      if (this.yBe == null)
      {
        localObject = aj.getContext();
        d.g.b.k.g(localObject, "MMApplicationContext.getContext()");
        gh((Context)localObject);
      }
      if (bool) {
        break label239;
      }
      if (paramLayoutParams != null) {
        break;
      }
      paramViewGroup.addView((View)this.yBe);
      AppMethodBeat.o(120650);
      return;
    }
    paramViewGroup.addView((View)this.yBe, paramLayoutParams);
    AppMethodBeat.o(120650);
    return;
    label239:
    if (paramLayoutParams != null)
    {
      paramViewGroup = this.yBe;
      if (paramViewGroup != null)
      {
        paramViewGroup.setLayoutParams(paramLayoutParams);
        AppMethodBeat.o(120650);
        return;
      }
    }
    AppMethodBeat.o(120650);
  }
  
  public final void a(com.tencent.mm.plugin.story.f.d.j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(120652);
    d.g.b.k.h(paramj, "item");
    if (!g(paramj)) {}
    for (boolean bool = true;; bool = false)
    {
      ad.m(this.TAG, "change:" + bool + ' ' + this.yAm + ", " + paramBoolean + ", changeVideoItem: origin: " + this.yAl + ", new: " + paramj + ",  change:" + bool + " this:" + hashCode(), new Object[0]);
      if (bool)
      {
        this.yAl = paramj;
        if ((this.yAm) || (paramBoolean))
        {
          a(this, false, 2);
          EN();
        }
      }
      AppMethodBeat.o(120652);
      return;
    }
  }
  
  public final void ai(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(120655);
    ad.m(this.TAG, "stopVideo, detach: ".concat(String.valueOf(paramBoolean1)), new Object[0]);
    Object localObject;
    if (this.yAk)
    {
      this.yAj = null;
      localObject = this.yBe;
      if (localObject != null) {
        ((StoryVideoView)localObject).stop();
      }
      this.yAi = false;
      if (this.yAo)
      {
        this.yAn.XF();
        this.yAo = false;
      }
      this.yAk = false;
    }
    if (paramBoolean1)
    {
      this.yAm = false;
      u(null);
      localObject = com.tencent.mm.plugin.story.h.h.ynv;
      com.tencent.mm.plugin.story.h.h.dJj().gc(System.currentTimeMillis());
      if (paramBoolean2)
      {
        localObject = com.tencent.mm.plugin.story.h.h.ynv;
        com.tencent.mm.plugin.story.h.h.dJk();
      }
    }
    AppMethodBeat.o(120655);
  }
  
  final void dLw()
  {
    AppMethodBeat.i(120654);
    ad.i(this.TAG, "setVideoViewProp, isMute:" + this.fqj);
    StoryVideoView localStoryVideoView = this.yBe;
    if (localStoryVideoView != null)
    {
      localStoryVideoView.setMute(this.fqj);
      AppMethodBeat.o(120654);
      return;
    }
    AppMethodBeat.o(120654);
  }
  
  final void gh(Context paramContext)
  {
    AppMethodBeat.i(120661);
    this.yBe = new StoryVideoView(paramContext);
    this.yBf = new b();
    paramContext = this.yBe;
    if (paramContext != null) {
      paramContext.setIOnlineVideoProxy((com.tencent.mm.modelvideo.b)this.yBf);
    }
    paramContext = this.yBe;
    if (paramContext != null) {
      paramContext.setIMMVideoViewCallback((h.b)this.yBj);
    }
    paramContext = this.yBe;
    if (paramContext != null) {
      paramContext.setReporter((h.c)new c(this));
    }
    this.yAk = false;
    AppMethodBeat.o(120661);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(120660);
    ad.i(this.TAG, "onUIDestroy " + hashCode());
    this.yAm = false;
    u(null);
    this.yAl = null;
    this.yBe = null;
    if (this.yAo)
    {
      this.yAn.XF();
      this.yAo = false;
    }
    com.tencent.mm.sdk.b.a.ESL.d((com.tencent.mm.sdk.b.c)this.yBi);
    AppMethodBeat.o(120660);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(120659);
    ad.i(this.TAG, "onUIPause " + hashCode());
    u(null);
    if (this.yAo)
    {
      this.yAn.XF();
      this.yAo = false;
    }
    AppMethodBeat.o(120659);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(120658);
    StoryVideoView localStoryVideoView = this.yBe;
    if (localStoryVideoView != null)
    {
      localStoryVideoView.onUIResume();
      AppMethodBeat.o(120658);
      return;
    }
    AppMethodBeat.o(120658);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(120657);
    d.g.b.k.g("", "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
    ad.i(this.TAG, "setMute " + paramBoolean + " ret " + "");
    this.fqj = paramBoolean;
    AppMethodBeat.o(120657);
  }
  
  final void u(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120662);
    String str = this.TAG;
    Object localObject1 = new StringBuilder("checkDetachVideoView, videoView:");
    Object localObject2 = this.yBe;
    int i;
    boolean bool;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", isPlay:");
      localObject2 = this.yBe;
      if (localObject2 == null) {
        break label248;
      }
      bool = ((StoryVideoView)localObject2).isPlaying();
      label72:
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", parent:");
      localObject1 = this.yBe;
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
      ad.m(str, i + ", isPlayingVideoItem:" + this.yAk, new Object[0]);
      localObject1 = this.yBe;
      if (localObject1 == null) {
        break label269;
      }
      localObject1 = ((StoryVideoView)localObject1).getParent();
      label187:
      if ((localObject1 == null) || (v(paramViewGroup))) {
        break label299;
      }
      a(this, true, 1);
      paramViewGroup = this.yBe;
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
      AppMethodBeat.o(120662);
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
    ((ViewGroup)paramViewGroup).removeView((View)this.yBe);
    this.yAl = null;
    label299:
    AppMethodBeat.o(120662);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayCdnCallback;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;)V", "TAG", "", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "isMoovReady", "", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "videoCache", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "onDataAvailable", "", "mediaId", "offset", "", "length", "onFinish", "ret", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onMoovReady", "svrflag", "onProgress", "total", "setIEngineCallback", "callback", "setVideoCache", "vitem", "plugin-story_release"})
  final class a
    implements h.a
  {
    final String TAG = "MicroMsg.VideoPlayProxy";
    com.tencent.mm.modelvideo.b.a osD;
    volatile boolean qEp;
    com.tencent.mm.plugin.story.f.d.j yAR;
    com.tencent.mm.plugin.story.i.n yBk;
    
    public final void a(com.tencent.mm.plugin.story.i.n paramn, com.tencent.mm.plugin.story.f.d.j paramj)
    {
      this.yBk = paramn;
      this.yAR = paramj;
    }
    
    public final void a(final String paramString, final int paramInt, com.tencent.mm.i.d paramd)
    {
      int j = 0;
      Object localObject2 = null;
      AppMethodBeat.i(120632);
      d.g.b.k.h(paramString, "mediaId");
      Object localObject3 = this.TAG;
      Object localObject1 = new StringBuilder("onFinish, mediaId:").append(paramString).append(", ret:").append(paramInt).append(", sceneResult:");
      int i;
      label106:
      long l;
      if (paramd != null)
      {
        i = paramd.field_retCode;
        StringBuilder localStringBuilder = ((StringBuilder)localObject1).append(i).append(" this:").append(this).append(" currVideoItem:");
        localObject1 = this.yBl.yAl;
        if (localObject1 == null) {
          break label553;
        }
        localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).username;
        ad.i((String)localObject3, (String)localObject1);
        localObject1 = this.yAR;
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.plugin.story.h.b.ymz;
          com.tencent.mm.plugin.story.h.b.tK(((com.tencent.mm.plugin.story.f.d.j)localObject1).dAu);
          m.yAD.ua(((com.tencent.mm.plugin.story.f.d.j)localObject1).dAu);
        }
        localObject1 = this.yBk;
        if (localObject1 == null) {
          break label559;
        }
        localObject1 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath;
        label174:
        localObject1 = com.tencent.mm.plugin.sight.base.e.ano((String)localObject1);
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.plugin.story.h.h.ynv;
          com.tencent.mm.plugin.story.h.h.dJx().fE(((com.tencent.mm.plugin.sight.base.a)localObject1).videoDuration);
          localObject3 = com.tencent.mm.plugin.story.h.h.ynv;
          com.tencent.mm.plugin.story.h.h.dJx().fF(((com.tencent.mm.plugin.sight.base.a)localObject1).videoBitrate);
          localObject3 = com.tencent.mm.plugin.story.h.h.ynv;
          com.tencent.mm.plugin.story.h.h.dJx().fG(((com.tencent.mm.plugin.sight.base.a)localObject1).audioBitrate);
          localObject3 = com.tencent.mm.plugin.story.h.h.ynv;
          com.tencent.mm.plugin.story.h.h.dJx().fH(((com.tencent.mm.plugin.sight.base.a)localObject1).frameRate);
          localObject3 = com.tencent.mm.plugin.story.h.h.ynv;
          com.tencent.mm.plugin.story.h.h.dJx().fI(((com.tencent.mm.plugin.sight.base.a)localObject1).width);
          localObject3 = com.tencent.mm.plugin.story.h.h.ynv;
          com.tencent.mm.plugin.story.h.h.dJx().fJ(((com.tencent.mm.plugin.sight.base.a)localObject1).height);
          localObject3 = com.tencent.mm.plugin.story.h.h.ynv;
          com.tencent.mm.plugin.story.h.h.dJx().fK(((com.tencent.mm.plugin.sight.base.a)localObject1).audioChannel);
        }
        localObject1 = com.tencent.mm.plugin.story.h.h.ynv;
        localObject1 = com.tencent.mm.plugin.story.h.h.dJx();
        if (this.yBk == null) {
          break label565;
        }
        localObject3 = this.yBk;
        if (localObject3 == null) {
          d.g.b.k.fvU();
        }
        l = ((com.tencent.mm.plugin.story.i.n)localObject3).field_totalSize;
        label351:
        ((de)localObject1).fD(l);
        localObject1 = com.tencent.mm.plugin.story.h.h.ynv;
        localObject3 = com.tencent.mm.plugin.story.h.h.dJx();
        localObject1 = this.yBk;
        if (localObject1 == null) {
          break label571;
        }
        localObject1 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_url;
        label387:
        ((de)localObject3).jD((String)localObject1);
        localObject1 = com.tencent.mm.plugin.story.h.h.ynv;
        localObject3 = com.tencent.mm.plugin.story.h.h.dJx();
        f.awM();
        localObject1 = this.yBk;
        if (localObject1 == null) {
          break label577;
        }
      }
      label553:
      label559:
      label565:
      label571:
      label577:
      for (localObject1 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath;; localObject1 = null)
      {
        ((de)localObject3).jE(com.tencent.mm.ao.a.xG((String)localObject1));
        if (paramd != null)
        {
          localObject1 = com.tencent.mm.plugin.story.h.h.ynv;
          com.tencent.mm.plugin.story.h.h.dJx().fB(paramd.field_startTime);
          localObject1 = com.tencent.mm.plugin.story.h.h.ynv;
          com.tencent.mm.plugin.story.h.h.dJx().fC(paramd.field_endTime);
        }
        localObject1 = localObject2;
        if (paramd != null) {
          localObject1 = paramd.field_usedSvrIps;
        }
        if (localObject1 == null) {
          break label599;
        }
        localObject1 = new StringBuffer();
        paramd = paramd.field_usedSvrIps;
        int k = paramd.length;
        i = j;
        while (i < k)
        {
          ((StringBuffer)localObject1).append(paramd[i]).append("|");
          i += 1;
        }
        i = 0;
        break;
        localObject1 = null;
        break label106;
        localObject1 = null;
        break label174;
        l = 0L;
        break label351;
        localObject1 = null;
        break label387;
      }
      paramd = com.tencent.mm.plugin.story.h.h.ynv;
      com.tencent.mm.plugin.story.h.h.dJx().jF(((StringBuffer)localObject1).toString());
      label599:
      if (this.yBl.yBf != null)
      {
        paramd = com.tencent.mm.plugin.story.h.h.ynv;
        paramd = com.tencent.mm.plugin.story.h.h.dJx();
        localObject1 = this.yBl.yBf;
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        paramd.fL(((n.b)localObject1).dpA);
        paramd = com.tencent.mm.plugin.story.h.h.ynv;
        paramd = com.tencent.mm.plugin.story.h.h.dJx();
        localObject1 = this.yBl.yBf;
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        if (!((n.b)localObject1).yAQ) {
          break label719;
        }
        l = 3L;
      }
      for (;;)
      {
        paramd.fM(l);
        paramd = com.tencent.mm.plugin.story.h.h.ynv;
        com.tencent.mm.plugin.story.h.h.dJy();
        com.tencent.mm.ad.c.g((d.g.a.a)new b(this, paramString, paramInt));
        AppMethodBeat.o(120632);
        return;
        label719:
        localObject1 = this.yBl.yBf;
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        if (((n.b)localObject1).dpA > 0) {
          l = 2L;
        } else {
          l = 1L;
        }
      }
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(204838);
      d.g.b.k.h(paramString1, "mediaId");
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onMoovReady, mediaId:").append(paramString1).append(", offset:").append(paramLong1).append(", length:").append(paramLong2).append(", isMoovReady:").append(this.qEp).append(" this:").append(this).append(" currVideoItem:");
      Object localObject = this.yBl.yAl;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.story.f.d.j)localObject).username;; localObject = null)
      {
        ad.i(str, (String)localObject);
        if (!this.qEp) {
          break;
        }
        AppMethodBeat.o(204838);
        return;
      }
      this.qEp = true;
      com.tencent.mm.ad.c.g((d.g.a.a)new c(this, paramString1, paramLong1, paramLong2, paramString2));
      AppMethodBeat.o(204838);
    }
    
    public final void k(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(120631);
      d.g.b.k.h(paramString, "mediaId");
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onProgress, mediaId:").append(paramString).append(", offset:").append(paramLong1).append(", total:").append(paramLong2).append(" this:").append(this).append(" currVideoItem:");
      Object localObject = this.yBl.yAl;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.story.f.d.j)localObject).username;; localObject = null)
      {
        ad.i(str, (String)localObject);
        com.tencent.mm.ad.c.g((d.g.a.a)new d(this, paramString, paramLong1, paramLong2));
        AppMethodBeat.o(120631);
        return;
      }
    }
    
    public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(120630);
      d.g.b.k.h(paramString, "mediaId");
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onDataAvailable, mediaId:").append(paramString).append(", offset:").append(paramLong1).append(", length:").append(paramLong2).append(" this:").append(this).append(" currVideoItem:");
      Object localObject = this.yBl.yAl;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.story.f.d.j)localObject).username;; localObject = null)
      {
        ad.i(str, (String)localObject);
        com.tencent.mm.ad.c.g((d.g.a.a)new a(this, paramString, paramLong1, paramLong2));
        AppMethodBeat.o(120630);
        return;
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(n.a parama, String paramString, long paramLong1, long paramLong2)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(n.a parama, String paramString, int paramInt)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      c(n.a parama, String paramString1, long paramLong1, long paramLong2, String paramString2)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class d
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      d(n.a parama, String paramString, long paramLong1, long paramLong2)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayProxy;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;)V", "TAG", "", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "preloadFinish", "", "getPreloadFinish", "()Z", "setPreloadFinish", "(Z)V", "preloadSize", "", "getPreloadSize", "()I", "setPreloadSize", "(I)V", "videoCache", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "createReportRptTips", "", "", "()[Ljava/lang/Object;", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "url", "path", "callback", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayCdnCallback;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "isVideoDataAvailable", "offset", "length", "requestVideoData", "", "setIEngineCallback", "setStoryVideoItem", "startHttpStream", "stop", "plugin-story_release"})
  final class b
    implements com.tencent.mm.modelvideo.b
  {
    final String TAG = "MicroMsg.VideoPlayProxy";
    int dpA;
    private com.tencent.mm.modelvideo.b.a osD;
    boolean yAQ;
    com.tencent.mm.plugin.story.f.d.j yAR;
    com.tencent.mm.plugin.story.i.n yBk;
    
    public final void a(com.tencent.mm.modelvideo.b.a parama)
    {
      this.osD = parama;
    }
    
    public final void fy(String paramString)
    {
      int k = 2;
      int j = 1;
      com.tencent.mm.plugin.story.f.d.j localj = null;
      AppMethodBeat.i(120636);
      d.g.b.k.h(paramString, "mediaId");
      ad.i(this.TAG, "this: " + this + " stop " + paramString + ' ' + bt.eGN());
      Object[] arrayOfObject = new Object[17];
      Object localObject1 = this.yBl.yBe;
      label124:
      int i;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).getCurrPosMs());
        arrayOfObject[0] = localObject1;
        localObject1 = this.yBl.yBe;
        if (localObject1 == null) {
          break label588;
        }
        localObject1 = Integer.valueOf((int)((StoryVideoView)localObject1).getFirstPlayWaitTime());
        arrayOfObject[1] = localObject1;
        localObject1 = this.yBl.yBe;
        if (localObject1 == null) {
          break label594;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).dLK());
        label154:
        arrayOfObject[2] = localObject1;
        localObject1 = this.yBl.yBe;
        if (localObject1 == null) {
          break label600;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).dLL());
        label184:
        arrayOfObject[3] = localObject1;
        localObject1 = this.yBl.yBe;
        if (localObject1 == null) {
          break label606;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).dLM());
        label214:
        arrayOfObject[4] = localObject1;
        localObject1 = this.yBl.yBe;
        if (localObject1 == null) {
          break label612;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).getStayTime());
        label244:
        arrayOfObject[5] = localObject1;
        localObject1 = this.yBl.yBe;
        if (localObject1 == null) {
          break label618;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).getErrorCode());
        label274:
        arrayOfObject[6] = localObject1;
        arrayOfObject[7] = Integer.valueOf(this.dpA);
        if (this.dpA <= 0) {
          break label624;
        }
        i = 2;
        label302:
        arrayOfObject[8] = Integer.valueOf(i);
        i = k;
        if (this.yAQ) {
          i = 3;
        }
        arrayOfObject[9] = Integer.valueOf(i);
        localObject1 = com.tencent.mm.plugin.story.e.b.yej;
        localObject1 = this.yBl.yBe;
        if (localObject1 != null)
        {
          localObject2 = ((StoryVideoView)localObject1).getFilePath();
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        arrayOfObject[10] = com.tencent.mm.plugin.story.e.b.a.arl((String)localObject1);
        Object localObject2 = this.yAR;
        localObject1 = localj;
        if (localObject2 != null) {
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject2).dAu);
        }
        arrayOfObject[11] = localObject1;
        localObject1 = com.tencent.mm.plugin.story.h.h.ynv;
        arrayOfObject[12] = Long.valueOf(com.tencent.mm.plugin.story.h.h.dJj().QS());
        localObject1 = com.tencent.mm.plugin.story.h.h.ynv;
        arrayOfObject[13] = Long.valueOf(com.tencent.mm.plugin.story.h.h.dJj().QU());
        localObject1 = com.tencent.mm.plugin.story.h.h.ynv;
        if (com.tencent.mm.plugin.story.h.h.dJj().QX() != 1L) {
          break label629;
        }
        i = j;
        label469:
        arrayOfObject[14] = Integer.valueOf(i);
        localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
        localObject1 = j.b.dHd();
        localj = this.yAR;
        if (localj == null) {
          break label634;
        }
      }
      label588:
      label594:
      label600:
      label606:
      label612:
      label618:
      label624:
      label629:
      label634:
      for (long l = localj.dAu;; l = 0L)
      {
        arrayOfObject[15] = Integer.valueOf(((com.tencent.mm.plugin.story.i.k)localObject1).tX(l));
        arrayOfObject[16] = Integer.valueOf(this.yBl.yBh);
        ad.i(this.TAG, "reportTips: " + Arrays.toString(arrayOfObject));
        com.tencent.mm.modelvideo.o.aCJ().j(paramString, arrayOfObject);
        AppMethodBeat.o(120636);
        return;
        localObject1 = Integer.valueOf(0);
        break;
        localObject1 = null;
        break label124;
        localObject1 = null;
        break label154;
        localObject1 = null;
        break label184;
        localObject1 = null;
        break label214;
        localObject1 = null;
        break label244;
        localObject1 = null;
        break label274;
        i = 1;
        break label302;
        i = 0;
        break label469;
      }
    }
    
    public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
    {
      String str2 = null;
      String str1 = null;
      AppMethodBeat.i(120638);
      d.g.b.k.h(paramString, "mediaId");
      Object localObject1 = this.yAR;
      if (localObject1 != null)
      {
        localObject2 = s.ygj;
        this.yBk = s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
        localObject1 = this.yBk;
        if ((localObject1 != null) && (((com.tencent.mm.plugin.story.i.n)localObject1).UE() == true))
        {
          str2 = this.TAG;
          localObject1 = new StringBuilder("isVideoDataAvailable ").append(paramString).append(", ").append(paramInt1).append(", ").append(paramInt2).append(", download finish cacheSize:");
          localObject2 = this.yBk;
          paramString = str1;
          if (localObject2 != null) {
            paramString = Integer.valueOf(((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize);
          }
          ad.i(str2, paramString + " this:" + this);
          AppMethodBeat.o(120638);
          return true;
        }
      }
      boolean bool = com.tencent.mm.modelvideo.o.aCJ().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      str1 = this.TAG;
      localObject1 = new StringBuilder("isVideoDataAvailable ").append(paramString).append(", ").append(paramInt1).append(", ").append(paramInt2).append(", available:").append(bool).append(" cacheSize:");
      Object localObject2 = this.yBk;
      paramString = str2;
      if (localObject2 != null) {
        paramString = Integer.valueOf(((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize);
      }
      ad.i(str1, paramString + " this:" + this);
      AppMethodBeat.o(120638);
      return bool;
    }
    
    public final void p(com.tencent.mm.plugin.story.f.d.j paramj)
    {
      AppMethodBeat.i(120634);
      d.g.b.k.h(paramj, "item");
      this.yAR = paramj;
      s locals = s.ygj;
      this.yBk = s.a(paramj);
      ad.i(this.TAG, "setStoryVideoItem " + paramj + " videoCache " + this.yBk);
      AppMethodBeat.o(120634);
    }
    
    public final void q(String paramString1, String paramString2, String paramString3)
    {
      int i = 0;
      Object localObject2 = null;
      AppMethodBeat.i(120635);
      ad.i(this.TAG, "startHttpStream " + paramString1 + ' ' + paramString2 + ' ' + paramString3 + " this:" + this);
      Object localObject1;
      Object localObject3;
      Object localObject4;
      boolean bool;
      if (this.yAR != null)
      {
        localObject1 = s.ygj;
        localObject1 = this.yAR;
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        this.yBk = s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
        localObject1 = this.yBk;
        if ((localObject1 != null) && (!i.eK(((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath)))
        {
          localObject3 = com.tencent.mm.plugin.story.f.l.yfu;
          localObject3 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath;
          d.g.b.k.g(localObject3, "it.field_filePath");
          com.tencent.mm.plugin.story.f.l.aru((String)localObject3);
          ad.i(this.TAG, "startHttpStream error downloadFinish " + ((com.tencent.mm.plugin.story.i.n)localObject1).UE() + " ret:" + i.eK(((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath) + " path:" + ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath);
          ((com.tencent.mm.plugin.story.i.n)localObject1).dKS();
          localObject3 = com.tencent.mm.plugin.story.f.j.yfh;
          j.b.dHh().b((com.tencent.mm.plugin.story.i.n)localObject1);
        }
        localObject1 = this.yBl.yAl;
        long l;
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.plugin.story.h.c.ymT;
          com.tencent.mm.plugin.story.h.c.dIT();
          localObject3 = com.tencent.mm.plugin.story.h.b.ymz;
          l = ((com.tencent.mm.plugin.story.f.d.j)localObject1).dAu;
          if (com.tencent.mm.plugin.story.h.b.aAh())
          {
            ad.v("MicroMsg.StoryBrowseDetailIDKeyStat", "startHttp storyId ".concat(String.valueOf(l)));
            if (com.tencent.mm.plugin.story.h.b.yml.containsKey(Long.valueOf(l)))
            {
              localObject1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.yml.get(Long.valueOf(l));
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.story.h.b.a)localObject1).ymD = true;
              }
            }
          }
        }
        localObject1 = this.yAR;
        if (localObject1 == null) {
          break label880;
        }
        localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).yhP;
        if (localObject1 == null) {
          break label880;
        }
        localObject1 = ((cym)localObject1).Url;
        if (!bt.isNullOrNil((String)localObject1))
        {
          localObject1 = this.yBl;
          ((n)localObject1).yBh += 1;
          localObject1 = ((n)localObject1).yBe;
          if (localObject1 != null) {
            ((StoryVideoView)localObject1).setNeedShowLoading(true);
          }
          localObject1 = new n.a(this.yBl);
          ((n.a)localObject1).osD = this.osD;
          ((n.a)localObject1).a(this.yBk, this.yAR);
          localObject3 = new com.tencent.mm.i.h();
          localObject4 = new n.a(this.yBl);
          ((n.a)localObject4).osD = this.osD;
          ((n.a)localObject4).a(this.yBk, this.yAR);
          ((com.tencent.mm.i.h)localObject3).field_mediaId = paramString1;
          ((com.tencent.mm.i.h)localObject3).url = paramString3;
          ((com.tencent.mm.i.h)localObject3).foc = 1;
          ((com.tencent.mm.i.h)localObject3).fnX = 6;
          ((com.tencent.mm.i.h)localObject3).concurrentCount = 4;
          ((com.tencent.mm.i.h)localObject3).field_fullpath = paramString2;
          ((com.tencent.mm.i.h)localObject3).foj = ((h.a)localObject1);
          ((com.tencent.mm.i.h)localObject3).field_fileType = com.tencent.mm.i.a.fne;
          ((com.tencent.mm.i.h)localObject3).field_requestVideoFormat = com.tencent.mm.modelcontrol.d.H(1, paramString2);
          paramString2 = m.yAD;
          paramString2 = this.yAR;
          if (paramString2 == null) {
            d.g.b.k.fvU();
          }
          m.j(paramString2);
          paramString2 = this.yBl.yAl;
          if (paramString2 != null)
          {
            paramString3 = com.tencent.mm.plugin.story.h.b.ymz;
            l = paramString2.dAu;
            if (this.yBk != null)
            {
              paramString2 = this.yBk;
              if ((paramString2 == null) || (paramString2.field_cacheSize != 0)) {
                break label886;
              }
            }
            bool = true;
            label612:
            com.tencent.mm.plugin.story.h.b.F(l, bool);
          }
          com.tencent.mm.modelvideo.o.aCJ().a((com.tencent.mm.i.h)localObject3);
          if ((this.yAR != null) && (paramString1 != null))
          {
            paramString2 = m.yAD;
            paramString2 = this.yAR;
            if (paramString2 == null) {
              d.g.b.k.fvU();
            }
            paramString3 = m.k(paramString2);
            if ((paramString3.qEp) && (!((n.a)localObject1).qEp))
            {
              localObject3 = this.TAG;
              localObject4 = new StringBuilder("checkPreloadOnVideoPlay ").append(paramString1).append(", moovReady, offset:").append(paramString3.offset).append(", length:").append(paramString3.length).append(", cacheSize:");
              paramString2 = this.yBk;
              if (paramString2 == null) {
                break label892;
              }
            }
          }
        }
      }
      label880:
      label886:
      label892:
      for (paramString2 = Integer.valueOf(paramString2.field_cacheSize);; paramString2 = null)
      {
        localObject4 = ((StringBuilder)localObject4).append(paramString2).append(", totalSize:");
        com.tencent.mm.plugin.story.i.n localn = this.yBk;
        paramString2 = localObject2;
        if (localn != null) {
          paramString2 = Integer.valueOf(localn.field_totalSize);
        }
        ad.i((String)localObject3, paramString2 + ", preloadFinish:" + paramString3.yAQ);
        if ((paramString3.offset > 0L) && (paramString3.length > 0L))
        {
          ((n.a)localObject1).a(paramString1, paramString3.offset, paramString3.length, "");
          paramString1 = this.yBk;
          if (paramString1 != null) {
            i = paramString1.field_cacheSize;
          }
          this.dpA = i;
          this.yAQ = paramString3.yAQ;
        }
        AppMethodBeat.o(120635);
        return;
        localObject1 = null;
        break;
        bool = false;
        break label612;
      }
    }
    
    public final void requestVideoData(final String paramString, final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(120637);
      d.g.b.k.h(paramString, "mediaId");
      com.tencent.mm.ad.c.g((d.g.a.a)new a(this, paramString, paramInt1, paramInt2));
      AppMethodBeat.o(120637);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(n.b paramb, String paramString, int paramInt1, int paramInt2)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$initCreateVideoView$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IReport;", "idkeyStat", "", "ID", "", "key", "value", "isImportant", "", "kvStat", "logID", "", "val", "", "plugin-story_release"})
  public static final class c
    implements h.c
  {
    public final void ln(long paramLong)
    {
      AppMethodBeat.i(120639);
      StoryVideoView localStoryVideoView = this.yBl.yBe;
      if (localStoryVideoView != null)
      {
        if (!localStoryVideoView.yAU)
        {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(this.yBl.yBg, paramLong, 1L, false);
          if ((paramLong >= 141L) && (paramLong <= 145L)) {
            ad.i(this.yBl.TAG, "initCreateVideoView test key " + paramLong + " value 1 currVideoItem:" + this.yBl.yAl + ' ' + bt.eGN());
          }
        }
        AppMethodBeat.o(120639);
        return;
      }
      AppMethodBeat.o(120639);
    }
    
    public final void pj(String paramString) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/OnlineVideoEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<ng>
  {
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(n.d paramd, ng paramng)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-story_release"})
  public static final class e
    implements h.b
  {
    public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120642);
      ad.i(this.yBl.TAG, "videoViewCallback onError: " + paramString1 + ", meidiaId:" + paramString2 + ", errorMsg:" + paramString3 + ", what:" + paramInt1 + ", extra:" + paramInt2);
      AppMethodBeat.o(120642);
    }
    
    public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120645);
      ad.i(this.yBl.TAG, "videoViewCallback onGetVideoSize: " + paramString1 + ", " + this.yBl.yAj + ", meidiaId:" + paramString2);
      AppMethodBeat.o(120645);
    }
    
    public final void db(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120643);
      ad.i(this.yBl.TAG, "videoViewCallback onPrepared: " + paramString1 + ", meidiaId:" + paramString2);
      AppMethodBeat.o(120643);
    }
    
    public final void dc(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120644);
      ad.i(this.yBl.TAG, "videoViewCallback onVideoEnded: " + paramString1 + ", meidiaId:" + paramString2);
      paramString1 = com.tencent.mm.plugin.story.h.h.ynv;
      paramString1 = com.tencent.mm.plugin.story.h.h.dJj();
      paramString1.gj(paramString1.Rb() + 1L);
      paramString1 = this.yBl.yAl;
      if (paramString1 != null)
      {
        paramString2 = com.tencent.mm.plugin.story.h.b.ymz;
        long l = paramString1.dAu;
        if (com.tencent.mm.plugin.story.h.b.aAh())
        {
          ad.v("MicroMsg.StoryBrowseDetailIDKeyStat", "onVideoEnd ".concat(String.valueOf(l)));
          if (com.tencent.mm.plugin.story.h.b.yml.containsKey(Long.valueOf(l)))
          {
            paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.yml.get(Long.valueOf(l));
            if (paramString1 != null)
            {
              paramString1.gna = true;
              AppMethodBeat.o(120644);
              return;
            }
          }
        }
        AppMethodBeat.o(120644);
        return;
      }
      AppMethodBeat.o(120644);
    }
    
    public final void dd(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120646);
      ad.i(this.yBl.TAG, "videoViewCallback onVideoPause: " + paramString1 + ", meidiaId:" + paramString2);
      AppMethodBeat.o(120646);
    }
    
    public final void de(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120647);
      String str = this.yBl.TAG;
      StringBuilder localStringBuilder = new StringBuilder("videoViewCallback onVideoPlay: ").append(paramString1).append(' ');
      Object localObject = this.yBl.yBe;
      long l1;
      label280:
      long l2;
      if (localObject != null)
      {
        localObject = ((StoryVideoView)localObject).getSessionId();
        ad.i(str, (String)localObject + ", " + this.yBl.yAj + ", meidiaId:" + paramString2 + ", isVideoPause:" + this.yBl.yAi);
        if ((d.n.n.I(paramString1, this.yBl.yAj, false)) && (this.yBl.yAi))
        {
          paramString1 = this.yBl.yBe;
          if ((paramString1 != null) && (!paramString1.yAU)) {
            this.yBl.u(null);
          }
        }
        paramString2 = this.yBl.yAl;
        if (paramString2 == null) {
          break label952;
        }
        paramString1 = com.tencent.mm.plugin.story.h.c.ymT;
        com.tencent.mm.plugin.story.h.c.tM(paramString2.dAu);
        paramString1 = com.tencent.mm.plugin.story.h.b.ymz;
        l1 = paramString2.dAu;
        if (com.tencent.mm.plugin.story.h.b.aAh())
        {
          localObject = new StringBuilder("onVideoPlay storyId ").append(l1).append(" lastStoryId ").append(com.tencent.mm.plugin.story.h.b.ymk).append(" contains:").append(com.tencent.mm.plugin.story.h.b.yml.containsKey(Long.valueOf(l1))).append(" result");
          paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.yml.get(Long.valueOf(l1));
          if (paramString1 == null) {
            break label458;
          }
          paramString1 = Long.valueOf(paramString1.ymC);
          ad.v("MicroMsg.StoryBrowseDetailIDKeyStat", paramString1);
          if ((l1 == com.tencent.mm.plugin.story.h.b.ymk) && (com.tencent.mm.plugin.story.h.b.yml.containsKey(Long.valueOf(l1))))
          {
            paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.yml.get(Long.valueOf(l1));
            if ((paramString1 != null) && (!paramString1.xqV) && (paramString1.ymC <= 0L) && (paramString1.ymB > 0L))
            {
              paramString1.isWaiting = false;
              l2 = bt.vM(paramString1.ymB);
              paramString1.ymC = bt.eGO();
              if (l2 <= 120000L) {
                break label463;
              }
              ad.w("MicroMsg.StoryBrowseDetailIDKeyStat", "onPlayCostTime  storyId " + l1 + " onPlayCostTime:" + l2);
            }
          }
        }
      }
      for (;;)
      {
        m.yAD.tZ(paramString2.dAu);
        paramString1 = com.tencent.mm.plugin.story.f.k.yfq;
        com.tencent.mm.plugin.story.f.k.aro(paramString2.username);
        AppMethodBeat.o(120647);
        return;
        localObject = null;
        break;
        label458:
        paramString1 = null;
        break label280;
        label463:
        ad.i("MicroMsg.StoryBrowseDetailIDKeyStat", "onPlayCostTime  storyId " + l1 + " onPlayCostTime:" + l2);
        com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 31L, l2);
        com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 30L, 1L);
        if (l2 <= 400L)
        {
          com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 90L, 1L);
          label536:
          if (l2 > 400L) {
            break label719;
          }
          com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 50L, 1L);
          label555:
          if (l1 != com.tencent.mm.plugin.story.h.b.ymn) {
            break label840;
          }
          if (!com.tencent.mm.plugin.story.h.b.ymr) {
            break label842;
          }
          com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 40L, 1L);
          com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 42L, l2);
        }
        for (;;)
        {
          if (l2 <= 1000L)
          {
            if (com.tencent.mm.plugin.story.h.b.ymr)
            {
              com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 44L, 1L);
              break;
              if (l2 <= 800L)
              {
                com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 91L, 1L);
                break label536;
              }
              if (l2 <= 1600L)
              {
                com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 92L, 1L);
                break label536;
              }
              if (l2 <= 3200L)
              {
                com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 93L, 1L);
                break label536;
              }
              if (l2 <= 5000L)
              {
                com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 94L, 1L);
                break label536;
              }
              com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 95L, 1L);
              break label536;
              label719:
              if (l2 <= 800L)
              {
                com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 51L, 1L);
                break label555;
              }
              if (l2 <= 1000L)
              {
                com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 52L, 1L);
                break label555;
              }
              if (l2 <= 2000L)
              {
                com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 53L, 1L);
                break label555;
              }
              if (l2 <= 3000L)
              {
                com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 54L, 1L);
                break label555;
              }
              if (l2 <= 4000L)
              {
                com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 55L, 1L);
                break label555;
              }
              com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 56L, 1L);
              break label555;
              label840:
              break;
              label842:
              com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 41L, 1L);
              com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 43L, l2);
              continue;
            }
            com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 45L, 1L);
            break;
          }
        }
        if (l2 <= 2000L)
        {
          if (com.tencent.mm.plugin.story.h.b.ymr) {
            com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 46L, 1L);
          } else {
            com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 47L, 1L);
          }
        }
        else if (com.tencent.mm.plugin.story.h.b.ymr) {
          com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 48L, 1L);
        } else {
          com.tencent.mm.plugin.story.h.b.n(com.tencent.mm.plugin.story.h.b.oJZ, 49L, 1L);
        }
      }
      label952:
      AppMethodBeat.o(120647);
    }
    
    public final void dg(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120648);
      ad.i(this.yBl.TAG, "videoViewCallback onVideoWaiting: " + paramString1 + ", meidiaId:" + paramString2);
      paramString1 = this.yBl.yAl;
      if (paramString1 != null)
      {
        paramString2 = com.tencent.mm.plugin.story.h.c.ymT;
        com.tencent.mm.plugin.story.h.c.tL(paramString1.dAu);
        paramString2 = com.tencent.mm.plugin.story.h.b.ymz;
        long l = paramString1.dAu;
        if ((com.tencent.mm.plugin.story.h.b.aAh()) && (com.tencent.mm.plugin.story.h.b.yml.containsKey(Long.valueOf(l))))
        {
          paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.yml.get(Long.valueOf(l));
          if ((paramString1 != null) && (!paramString1.xqV) && (paramString1.ymD))
          {
            paramString1.isWaiting = true;
            AppMethodBeat.o(120648);
            return;
          }
        }
        AppMethodBeat.o(120648);
        return;
      }
      AppMethodBeat.o(120648);
    }
    
    public final void dh(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120649);
      String str = this.yBl.TAG;
      StringBuilder localStringBuilder = new StringBuilder("videoViewCallback onVideoWaitingEnd: ").append(paramString1).append(' ');
      Object localObject = this.yBl.yBe;
      if (localObject != null) {}
      for (localObject = ((StoryVideoView)localObject).getSessionId();; localObject = null)
      {
        ad.i(str, (String)localObject + ", " + this.yBl.yAj + ", meidiaId:" + paramString2 + ", isVideoPause:" + this.yBl.yAi);
        if ((d.n.n.I(paramString1, this.yBl.yAj, false)) && (this.yBl.yAi))
        {
          paramString1 = this.yBl.yBe;
          if (paramString1 == null) {
            break;
          }
          if (!paramString1.yAU) {
            this.yBl.u(null);
          }
        }
        AppMethodBeat.o(120649);
        return;
      }
      AppMethodBeat.o(120649);
    }
    
    public final void jw(String paramString1, String paramString2)
    {
      AppMethodBeat.i(204839);
      ad.i(this.yBl.TAG, "onVideoFirstFrameDraw: " + paramString1 + ", meidiaId:" + paramString2);
      AppMethodBeat.o(204839);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.n
 * JD-Core Version:    0.7.0.1
 */