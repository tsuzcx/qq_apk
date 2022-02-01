package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.g.b.a.ft;
import com.tencent.mm.g.b.a.ga;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.g.b.q;
import d.v;
import d.z;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "", "()V", "STORY_VIDEO_VIEW_IDKEY_STAT", "", "TAG", "", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "currentSessionId", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "onlineVideoEventListener", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1;", "proxy", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayProxy;", "showLoadingTime", "", "videoView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView;", "videoViewCallback", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "checkPauseOnProgress", "getPlayStatus", "getVideoView", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "newVideoViewInstance", "onUIDestroy", "onUIPause", "onUIResume", "pauseVideo", "playVideo", "resetVideo", "sameParent", "setMute", "setNeedShowLoading", "show", "setVideoViewProp", "stopTask", "stopVideo", "detach", "VideoPlayCdnCallback", "VideoPlayProxy", "plugin-story_release"})
public final class n
{
  private com.tencent.mm.compatible.util.b BwA;
  private boolean BwB;
  boolean Bwv;
  String Bww;
  private boolean Bwx;
  com.tencent.mm.plugin.story.f.d.j Bwy;
  boolean Bwz;
  StoryVideoView Bxr;
  b Bxs;
  final long Bxt;
  int Bxu;
  private final d Bxv;
  private final e Bxw;
  final String TAG;
  private boolean fOX;
  
  public n()
  {
    AppMethodBeat.i(120664);
    this.TAG = "MicroMsg.Gallery.StoryVideoViewMgr";
    this.BwA = new com.tencent.mm.compatible.util.b(ak.getContext());
    this.Bxt = 987L;
    this.Bxv = new d(this);
    ae.i(this.TAG, "init create StoryVideoViewMgr " + hashCode());
    com.tencent.mm.sdk.b.a.IvT.c((com.tencent.mm.sdk.b.c)this.Bxv);
    this.Bxw = new e(this);
    AppMethodBeat.o(120664);
  }
  
  private final boolean g(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    Object localObject2 = null;
    AppMethodBeat.i(120651);
    Object localObject3;
    if (paramj.dKr != 0)
    {
      localObject1 = this.Bwy;
      if ((localObject1 != null) && (((com.tencent.mm.plugin.story.f.d.j)localObject1).dKr == paramj.dKr))
      {
        localObject3 = paramj.Bel;
        localObject1 = this.Bwy;
        if (localObject1 != null) {}
        for (localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).Bel; localObject3 == localObject1; localObject1 = null)
        {
          AppMethodBeat.o(120651);
          return true;
        }
      }
    }
    Object localObject1 = (CharSequence)paramj.Bem.Url;
    int i;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label187;
      }
      localObject1 = this.Bwy;
      if (localObject1 == null) {
        break label182;
      }
      localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).Bem;
      if (localObject1 == null) {
        break label182;
      }
    }
    label182:
    for (localObject1 = ((dkg)localObject1).Url;; localObject1 = null)
    {
      if (!p.i(localObject1, paramj.Bem.Url)) {
        break label187;
      }
      localObject1 = paramj.Bel;
      localObject3 = this.Bwy;
      paramj = localObject2;
      if (localObject3 != null) {
        paramj = ((com.tencent.mm.plugin.story.f.d.j)localObject3).Bel;
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
  
  private final boolean z(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120663);
    Object localObject = this.Bxr;
    if (localObject != null) {}
    for (localObject = ((StoryVideoView)localObject).getParent();; localObject = null)
    {
      boolean bool = p.i(localObject, paramViewGroup);
      AppMethodBeat.o(120663);
      return bool;
    }
  }
  
  public final void FW()
  {
    AppMethodBeat.i(120653);
    ae.m(this.TAG, "playVideo, " + this.Bwv + ' ' + this.Bwz + ", " + this.Bwy, new Object[0]);
    epU();
    this.Bwz = true;
    Object localObject1 = this.Bwy;
    if (localObject1 != null)
    {
      boolean bool = this.Bwv;
      this.Bwv = false;
      if (!bool) {
        break label182;
      }
      localObject2 = this.Bxr;
      if (localObject2 != null) {
        ((StoryVideoView)localObject2).o((com.tencent.mm.plugin.story.f.d.j)localObject1);
      }
      this.Bwv = false;
      if (((com.tencent.mm.plugin.story.f.d.j)localObject1).emv()) {
        this.Bwx = true;
      }
      if (!this.BwB)
      {
        this.BwA.requestFocus();
        this.BwB = true;
      }
    }
    localObject1 = com.tencent.mm.plugin.story.h.h.BjR;
    Object localObject2 = com.tencent.mm.plugin.story.h.h.enI();
    localObject1 = this.Bxr;
    if (localObject1 != null) {}
    for (localObject1 = ((StoryVideoView)localObject1).getContext();; localObject1 = null)
    {
      ((ga)localObject2).li(az.iX((Context)localObject1));
      AppMethodBeat.o(120653);
      return;
      label182:
      this.Bww = UUID.randomUUID().toString();
      localObject2 = this.Bxs;
      if (localObject2 != null) {
        ((b)localObject2).p((com.tencent.mm.plugin.story.f.d.j)localObject1);
      }
      localObject2 = this.Bxr;
      if (localObject2 == null) {
        break;
      }
      ((StoryVideoView)localObject2).a((com.tencent.mm.plugin.story.f.d.j)localObject1, this.Bww);
      break;
    }
  }
  
  public final void a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(120650);
    p.h(paramViewGroup, "parent");
    this.Bxu = 0;
    boolean bool = z(paramViewGroup);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("attachVideoView, parent:").append(paramViewGroup.hashCode()).append(", isVideoPause:").append(this.Bwv).append(", currentSessionId:").append(this.Bww).append(", isPlayingVideoItem:").append(this.Bwx).append(" videoView ");
    Object localObject = this.Bxr;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((StoryVideoView)localObject).hashCode());; localObject = null)
    {
      ae.m(str, localObject + " sameParent " + bool + " this:" + hashCode(), new Object[0]);
      y(paramViewGroup);
      if (this.Bxr == null)
      {
        localObject = ak.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        gB((Context)localObject);
      }
      if (bool) {
        break label239;
      }
      if (paramLayoutParams != null) {
        break;
      }
      paramViewGroup.addView((View)this.Bxr);
      AppMethodBeat.o(120650);
      return;
    }
    paramViewGroup.addView((View)this.Bxr, paramLayoutParams);
    AppMethodBeat.o(120650);
    return;
    label239:
    if (paramLayoutParams != null)
    {
      paramViewGroup = this.Bxr;
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
    p.h(paramj, "item");
    if (!g(paramj)) {}
    for (boolean bool = true;; bool = false)
    {
      ae.m(this.TAG, "change:" + bool + ' ' + this.Bwz + ", " + paramBoolean + ", changeVideoItem: origin: " + this.Bwy + ", new: " + paramj + ",  change:" + bool + " this:" + hashCode(), new Object[0]);
      if (bool)
      {
        this.Bwy = paramj;
        if ((this.Bwz) || (paramBoolean))
        {
          a(this, false, 2);
          FW();
        }
      }
      AppMethodBeat.o(120652);
      return;
    }
  }
  
  public final void ao(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(120655);
    ae.m(this.TAG, "stopVideo, detach: ".concat(String.valueOf(paramBoolean1)), new Object[0]);
    Object localObject;
    if (this.Bwx)
    {
      this.Bww = null;
      localObject = this.Bxr;
      if (localObject != null) {
        ((StoryVideoView)localObject).stop();
      }
      this.Bwv = false;
      if (this.BwB)
      {
        this.BwA.abn();
        this.BwB = false;
      }
      this.Bwx = false;
    }
    if (paramBoolean1)
    {
      this.Bwz = false;
      y(null);
      localObject = com.tencent.mm.plugin.story.h.h.BjR;
      com.tencent.mm.plugin.story.h.h.enI().lm(System.currentTimeMillis());
      if (paramBoolean2)
      {
        localObject = com.tencent.mm.plugin.story.h.h.BjR;
        com.tencent.mm.plugin.story.h.h.enJ();
      }
    }
    AppMethodBeat.o(120655);
  }
  
  final void epU()
  {
    AppMethodBeat.i(120654);
    ae.i(this.TAG, "setVideoViewProp, isMute:" + this.fOX);
    StoryVideoView localStoryVideoView = this.Bxr;
    if (localStoryVideoView != null)
    {
      localStoryVideoView.setMute(this.fOX);
      AppMethodBeat.o(120654);
      return;
    }
    AppMethodBeat.o(120654);
  }
  
  final void gB(Context paramContext)
  {
    AppMethodBeat.i(120661);
    this.Bxr = new StoryVideoView(paramContext);
    this.Bxs = new b();
    paramContext = this.Bxr;
    if (paramContext != null) {
      paramContext.setIOnlineVideoProxy((com.tencent.mm.modelvideo.b)this.Bxs);
    }
    paramContext = this.Bxr;
    if (paramContext != null) {
      paramContext.setIMMVideoViewCallback((i.b)this.Bxw);
    }
    paramContext = this.Bxr;
    if (paramContext != null) {
      paramContext.setReporter((i.c)new c(this));
    }
    this.Bwx = false;
    AppMethodBeat.o(120661);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(120660);
    ae.i(this.TAG, "onUIDestroy " + hashCode());
    this.Bwz = false;
    y(null);
    this.Bwy = null;
    this.Bxr = null;
    if (this.BwB)
    {
      this.BwA.abn();
      this.BwB = false;
    }
    com.tencent.mm.sdk.b.a.IvT.d((com.tencent.mm.sdk.b.c)this.Bxv);
    AppMethodBeat.o(120660);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(120659);
    ae.i(this.TAG, "onUIPause " + hashCode());
    y(null);
    if (this.BwB)
    {
      this.BwA.abn();
      this.BwB = false;
    }
    AppMethodBeat.o(120659);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(120658);
    StoryVideoView localStoryVideoView = this.Bxr;
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
    p.g("", "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
    ae.i(this.TAG, "setMute " + paramBoolean + " ret " + "");
    this.fOX = paramBoolean;
    AppMethodBeat.o(120657);
  }
  
  final void y(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120662);
    String str = this.TAG;
    Object localObject1 = new StringBuilder("checkDetachVideoView, videoView:");
    Object localObject2 = this.Bxr;
    int i;
    boolean bool;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", isPlay:");
      localObject2 = this.Bxr;
      if (localObject2 == null) {
        break label248;
      }
      bool = ((StoryVideoView)localObject2).isPlaying();
      label72:
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", parent:");
      localObject1 = this.Bxr;
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
      ae.m(str, i + ", isPlayingVideoItem:" + this.Bwx, new Object[0]);
      localObject1 = this.Bxr;
      if (localObject1 == null) {
        break label269;
      }
      localObject1 = ((StoryVideoView)localObject1).getParent();
      label187:
      if ((localObject1 == null) || (z(paramViewGroup))) {
        break label299;
      }
      a(this, true, 1);
      paramViewGroup = this.Bxr;
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
    ((ViewGroup)paramViewGroup).removeView((View)this.Bxr);
    this.Bwy = null;
    label299:
    AppMethodBeat.o(120662);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayCdnCallback;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;)V", "TAG", "", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "isMoovReady", "", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "videoCache", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "onDataAvailable", "", "mediaId", "offset", "", "length", "onFinish", "ret", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onMoovReady", "svrflag", "onProgress", "total", "setIEngineCallback", "callback", "setVideoCache", "vitem", "plugin-story_release"})
  final class a
    implements h.a
  {
    com.tencent.mm.plugin.story.f.d.j Bxe;
    com.tencent.mm.plugin.story.i.n Bxx;
    final String TAG = "MicroMsg.VideoPlayProxy";
    com.tencent.mm.modelvideo.b.a pGr;
    volatile boolean stM;
    
    public final void a(com.tencent.mm.plugin.story.i.n paramn, com.tencent.mm.plugin.story.f.d.j paramj)
    {
      this.Bxx = paramn;
      this.Bxe = paramj;
    }
    
    public final void a(final String paramString, final int paramInt, com.tencent.mm.i.d paramd)
    {
      int j = 0;
      Object localObject2 = null;
      AppMethodBeat.i(120632);
      p.h(paramString, "mediaId");
      Object localObject3 = this.TAG;
      Object localObject1 = new StringBuilder("onFinish, mediaId:").append(paramString).append(", ret:").append(paramInt).append(", sceneResult:");
      int i;
      label106:
      long l;
      if (paramd != null)
      {
        i = paramd.field_retCode;
        StringBuilder localStringBuilder = ((StringBuilder)localObject1).append(i).append(" this:").append(this).append(" currVideoItem:");
        localObject1 = this.Bxy.Bwy;
        if (localObject1 == null) {
          break label553;
        }
        localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).username;
        ae.i((String)localObject3, (String)localObject1);
        localObject1 = this.Bxe;
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.plugin.story.h.b.BiV;
          com.tencent.mm.plugin.story.h.b.Bj(((com.tencent.mm.plugin.story.f.d.j)localObject1).dLI);
          m.BwQ.Bz(((com.tencent.mm.plugin.story.f.d.j)localObject1).dLI);
        }
        localObject1 = this.Bxx;
        if (localObject1 == null) {
          break label559;
        }
        localObject1 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath;
        label174:
        localObject1 = com.tencent.mm.plugin.sight.base.e.ayN((String)localObject1);
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.plugin.story.h.h.BjR;
          com.tencent.mm.plugin.story.h.h.enW().kO(((com.tencent.mm.plugin.sight.base.a)localObject1).videoDuration);
          localObject3 = com.tencent.mm.plugin.story.h.h.BjR;
          com.tencent.mm.plugin.story.h.h.enW().kP(((com.tencent.mm.plugin.sight.base.a)localObject1).videoBitrate);
          localObject3 = com.tencent.mm.plugin.story.h.h.BjR;
          com.tencent.mm.plugin.story.h.h.enW().kQ(((com.tencent.mm.plugin.sight.base.a)localObject1).audioBitrate);
          localObject3 = com.tencent.mm.plugin.story.h.h.BjR;
          com.tencent.mm.plugin.story.h.h.enW().kR(((com.tencent.mm.plugin.sight.base.a)localObject1).frameRate);
          localObject3 = com.tencent.mm.plugin.story.h.h.BjR;
          com.tencent.mm.plugin.story.h.h.enW().kS(((com.tencent.mm.plugin.sight.base.a)localObject1).width);
          localObject3 = com.tencent.mm.plugin.story.h.h.BjR;
          com.tencent.mm.plugin.story.h.h.enW().kT(((com.tencent.mm.plugin.sight.base.a)localObject1).height);
          localObject3 = com.tencent.mm.plugin.story.h.h.BjR;
          com.tencent.mm.plugin.story.h.h.enW().kU(((com.tencent.mm.plugin.sight.base.a)localObject1).audioChannel);
        }
        localObject1 = com.tencent.mm.plugin.story.h.h.BjR;
        localObject1 = com.tencent.mm.plugin.story.h.h.enW();
        if (this.Bxx == null) {
          break label565;
        }
        localObject3 = this.Bxx;
        if (localObject3 == null) {
          p.gkB();
        }
        l = ((com.tencent.mm.plugin.story.i.n)localObject3).field_totalSize;
        label351:
        ((ft)localObject1).kN(l);
        localObject1 = com.tencent.mm.plugin.story.h.h.BjR;
        localObject3 = com.tencent.mm.plugin.story.h.h.enW();
        localObject1 = this.Bxx;
        if (localObject1 == null) {
          break label571;
        }
        localObject1 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_url;
        label387:
        ((ft)localObject3).pb((String)localObject1);
        localObject1 = com.tencent.mm.plugin.story.h.h.BjR;
        localObject3 = com.tencent.mm.plugin.story.h.h.enW();
        f.aHa();
        localObject1 = this.Bxx;
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
        ((ft)localObject3).pc(com.tencent.mm.an.a.Fn((String)localObject1));
        if (paramd != null)
        {
          localObject1 = com.tencent.mm.plugin.story.h.h.BjR;
          com.tencent.mm.plugin.story.h.h.enW().kL(paramd.field_startTime);
          localObject1 = com.tencent.mm.plugin.story.h.h.BjR;
          com.tencent.mm.plugin.story.h.h.enW().kM(paramd.field_endTime);
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
      paramd = com.tencent.mm.plugin.story.h.h.BjR;
      com.tencent.mm.plugin.story.h.h.enW().pd(((StringBuffer)localObject1).toString());
      label599:
      if (this.Bxy.Bxs != null)
      {
        paramd = com.tencent.mm.plugin.story.h.h.BjR;
        paramd = com.tencent.mm.plugin.story.h.h.enW();
        localObject1 = this.Bxy.Bxs;
        if (localObject1 == null) {
          p.gkB();
        }
        paramd.kV(((n.b)localObject1).dAe);
        paramd = com.tencent.mm.plugin.story.h.h.BjR;
        paramd = com.tencent.mm.plugin.story.h.h.enW();
        localObject1 = this.Bxy.Bxs;
        if (localObject1 == null) {
          p.gkB();
        }
        if (!((n.b)localObject1).Bxd) {
          break label719;
        }
        l = 3L;
      }
      for (;;)
      {
        paramd.kW(l);
        paramd = com.tencent.mm.plugin.story.h.h.BjR;
        com.tencent.mm.plugin.story.h.h.enX();
        com.tencent.mm.ac.c.h((d.g.a.a)new b(this, paramString, paramInt));
        AppMethodBeat.o(120632);
        return;
        label719:
        localObject1 = this.Bxy.Bxs;
        if (localObject1 == null) {
          p.gkB();
        }
        if (((n.b)localObject1).dAe > 0) {
          l = 2L;
        } else {
          l = 1L;
        }
      }
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(221756);
      p.h(paramString1, "mediaId");
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onMoovReady, mediaId:").append(paramString1).append(", offset:").append(paramLong1).append(", length:").append(paramLong2).append(", isMoovReady:").append(this.stM).append(" this:").append(this).append(" currVideoItem:");
      Object localObject = this.Bxy.Bwy;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.story.f.d.j)localObject).username;; localObject = null)
      {
        ae.i(str, (String)localObject);
        if (!this.stM) {
          break;
        }
        AppMethodBeat.o(221756);
        return;
      }
      this.stM = true;
      com.tencent.mm.ac.c.h((d.g.a.a)new c(this, paramString1, paramLong1, paramLong2, paramString2));
      AppMethodBeat.o(221756);
    }
    
    public final void i(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(120631);
      p.h(paramString, "mediaId");
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onProgress, mediaId:").append(paramString).append(", offset:").append(paramLong1).append(", total:").append(paramLong2).append(" this:").append(this).append(" currVideoItem:");
      Object localObject = this.Bxy.Bwy;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.story.f.d.j)localObject).username;; localObject = null)
      {
        ae.i(str, (String)localObject);
        com.tencent.mm.ac.c.h((d.g.a.a)new d(this, paramString, paramLong1, paramLong2));
        AppMethodBeat.o(120631);
        return;
      }
    }
    
    public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(120630);
      p.h(paramString, "mediaId");
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onDataAvailable, mediaId:").append(paramString).append(", offset:").append(paramLong1).append(", length:").append(paramLong2).append(" this:").append(this).append(" currVideoItem:");
      Object localObject = this.Bxy.Bwy;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.story.f.d.j)localObject).username;; localObject = null)
      {
        ae.i(str, (String)localObject);
        com.tencent.mm.ac.c.h((d.g.a.a)new a(this, paramString, paramLong1, paramLong2));
        AppMethodBeat.o(120630);
        return;
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(n.a parama, String paramString, long paramLong1, long paramLong2)
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<z>
    {
      b(n.a parama, String paramString, int paramInt)
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements d.g.a.a<z>
    {
      c(n.a parama, String paramString1, long paramLong1, long paramLong2, String paramString2)
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class d
      extends q
      implements d.g.a.a<z>
    {
      d(n.a parama, String paramString, long paramLong1, long paramLong2)
      {
        super();
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayProxy;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;)V", "TAG", "", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "preloadFinish", "", "getPreloadFinish", "()Z", "setPreloadFinish", "(Z)V", "preloadSize", "", "getPreloadSize", "()I", "setPreloadSize", "(I)V", "videoCache", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "createReportRptTips", "", "", "()[Ljava/lang/Object;", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "url", "path", "callback", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayCdnCallback;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "isVideoDataAvailable", "offset", "length", "requestVideoData", "", "setIEngineCallback", "setStoryVideoItem", "startHttpStream", "stop", "plugin-story_release"})
  final class b
    implements com.tencent.mm.modelvideo.b
  {
    boolean Bxd;
    com.tencent.mm.plugin.story.f.d.j Bxe;
    com.tencent.mm.plugin.story.i.n Bxx;
    final String TAG = "MicroMsg.VideoPlayProxy";
    int dAe;
    private com.tencent.mm.modelvideo.b.a pGr;
    
    public final void a(com.tencent.mm.modelvideo.b.a parama)
    {
      this.pGr = parama;
    }
    
    public final void gp(String paramString)
    {
      int k = 2;
      int j = 1;
      com.tencent.mm.plugin.story.f.d.j localj = null;
      AppMethodBeat.i(120636);
      p.h(paramString, "mediaId");
      ae.i(this.TAG, "this: " + this + " stop " + paramString + ' ' + bu.fpN());
      Object[] arrayOfObject = new Object[17];
      Object localObject1 = this.Bxy.Bxr;
      label124:
      int i;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).getCurrPosMs());
        arrayOfObject[0] = localObject1;
        localObject1 = this.Bxy.Bxr;
        if (localObject1 == null) {
          break label588;
        }
        localObject1 = Integer.valueOf((int)((StoryVideoView)localObject1).getFirstPlayWaitTime());
        arrayOfObject[1] = localObject1;
        localObject1 = this.Bxy.Bxr;
        if (localObject1 == null) {
          break label594;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).eqi());
        label154:
        arrayOfObject[2] = localObject1;
        localObject1 = this.Bxy.Bxr;
        if (localObject1 == null) {
          break label600;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).eqj());
        label184:
        arrayOfObject[3] = localObject1;
        localObject1 = this.Bxy.Bxr;
        if (localObject1 == null) {
          break label606;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).eqk());
        label214:
        arrayOfObject[4] = localObject1;
        localObject1 = this.Bxy.Bxr;
        if (localObject1 == null) {
          break label612;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).getStayTime());
        label244:
        arrayOfObject[5] = localObject1;
        localObject1 = this.Bxy.Bxr;
        if (localObject1 == null) {
          break label618;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).getErrorCode());
        label274:
        arrayOfObject[6] = localObject1;
        arrayOfObject[7] = Integer.valueOf(this.dAe);
        if (this.dAe <= 0) {
          break label624;
        }
        i = 2;
        label302:
        arrayOfObject[8] = Integer.valueOf(i);
        i = k;
        if (this.Bxd) {
          i = 3;
        }
        arrayOfObject[9] = Integer.valueOf(i);
        localObject1 = com.tencent.mm.plugin.story.e.b.BaG;
        localObject1 = this.Bxy.Bxr;
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
        arrayOfObject[10] = com.tencent.mm.plugin.story.e.b.a.aCS((String)localObject1);
        Object localObject2 = this.Bxe;
        localObject1 = localj;
        if (localObject2 != null) {
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject2).dLI);
        }
        arrayOfObject[11] = localObject1;
        localObject1 = com.tencent.mm.plugin.story.h.h.BjR;
        arrayOfObject[12] = Long.valueOf(com.tencent.mm.plugin.story.h.h.enI().TH());
        localObject1 = com.tencent.mm.plugin.story.h.h.BjR;
        arrayOfObject[13] = Long.valueOf(com.tencent.mm.plugin.story.h.h.enI().TJ());
        localObject1 = com.tencent.mm.plugin.story.h.h.BjR;
        if (com.tencent.mm.plugin.story.h.h.enI().TM() != 1L) {
          break label629;
        }
        i = j;
        label469:
        arrayOfObject[14] = Integer.valueOf(i);
        localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
        localObject1 = j.b.elB();
        localj = this.Bxe;
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
      for (long l = localj.dLI;; l = 0L)
      {
        arrayOfObject[15] = Integer.valueOf(((com.tencent.mm.plugin.story.i.k)localObject1).Bw(l));
        arrayOfObject[16] = Integer.valueOf(this.Bxy.Bxu);
        ae.i(this.TAG, "reportTips: " + Arrays.toString(arrayOfObject));
        com.tencent.mm.modelvideo.o.aNi().l(paramString, arrayOfObject);
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
      p.h(paramString, "mediaId");
      Object localObject1 = this.Bxe;
      if (localObject1 != null)
      {
        localObject2 = s.BcG;
        this.Bxx = s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
        localObject1 = this.Bxx;
        if ((localObject1 != null) && (((com.tencent.mm.plugin.story.i.n)localObject1).Ya() == true))
        {
          str2 = this.TAG;
          localObject1 = new StringBuilder("isVideoDataAvailable ").append(paramString).append(", ").append(paramInt1).append(", ").append(paramInt2).append(", download finish cacheSize:");
          localObject2 = this.Bxx;
          paramString = str1;
          if (localObject2 != null) {
            paramString = Integer.valueOf(((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize);
          }
          ae.i(str2, paramString + " this:" + this);
          AppMethodBeat.o(120638);
          return true;
        }
      }
      boolean bool = com.tencent.mm.modelvideo.o.aNi().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      str1 = this.TAG;
      localObject1 = new StringBuilder("isVideoDataAvailable ").append(paramString).append(", ").append(paramInt1).append(", ").append(paramInt2).append(", available:").append(bool).append(" cacheSize:");
      Object localObject2 = this.Bxx;
      paramString = str2;
      if (localObject2 != null) {
        paramString = Integer.valueOf(((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize);
      }
      ae.i(str1, paramString + " this:" + this);
      AppMethodBeat.o(120638);
      return bool;
    }
    
    public final void p(com.tencent.mm.plugin.story.f.d.j paramj)
    {
      AppMethodBeat.i(120634);
      p.h(paramj, "item");
      this.Bxe = paramj;
      s locals = s.BcG;
      this.Bxx = s.a(paramj);
      ae.i(this.TAG, "setStoryVideoItem " + paramj + " videoCache " + this.Bxx);
      AppMethodBeat.o(120634);
    }
    
    public final void p(String paramString1, String paramString2, String paramString3)
    {
      int i = 0;
      Object localObject2 = null;
      AppMethodBeat.i(120635);
      ae.i(this.TAG, "startHttpStream " + paramString1 + ' ' + paramString2 + ' ' + paramString3 + " this:" + this);
      Object localObject1;
      Object localObject3;
      Object localObject4;
      boolean bool;
      if (this.Bxe != null)
      {
        localObject1 = s.BcG;
        localObject1 = this.Bxe;
        if (localObject1 == null) {
          p.gkB();
        }
        this.Bxx = s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
        localObject1 = this.Bxx;
        if ((localObject1 != null) && (!com.tencent.mm.vfs.o.fB(((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath)))
        {
          localObject3 = com.tencent.mm.plugin.story.f.l.BbR;
          localObject3 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath;
          p.g(localObject3, "it.field_filePath");
          com.tencent.mm.plugin.story.f.l.aDb((String)localObject3);
          ae.i(this.TAG, "startHttpStream error downloadFinish " + ((com.tencent.mm.plugin.story.i.n)localObject1).Ya() + " ret:" + com.tencent.mm.vfs.o.fB(((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath) + " path:" + ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath);
          ((com.tencent.mm.plugin.story.i.n)localObject1).epr();
          localObject3 = com.tencent.mm.plugin.story.f.j.BbE;
          j.b.elF().b((com.tencent.mm.plugin.story.i.n)localObject1);
        }
        localObject1 = this.Bxy.Bwy;
        long l;
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.plugin.story.h.c.Bjp;
          com.tencent.mm.plugin.story.h.c.ens();
          localObject3 = com.tencent.mm.plugin.story.h.b.BiV;
          l = ((com.tencent.mm.plugin.story.f.d.j)localObject1).dLI;
          if (com.tencent.mm.plugin.story.h.b.aKB())
          {
            ae.v("MicroMsg.StoryBrowseDetailIDKeyStat", "startHttp storyId ".concat(String.valueOf(l)));
            if (com.tencent.mm.plugin.story.h.b.BiH.containsKey(Long.valueOf(l)))
            {
              localObject1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.BiH.get(Long.valueOf(l));
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.story.h.b.a)localObject1).BiZ = true;
              }
            }
          }
        }
        localObject1 = this.Bxe;
        if (localObject1 == null) {
          break label888;
        }
        localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).Bem;
        if (localObject1 == null) {
          break label888;
        }
        localObject1 = ((dkg)localObject1).Url;
        if (!bu.isNullOrNil((String)localObject1))
        {
          localObject1 = this.Bxy;
          ((n)localObject1).Bxu += 1;
          localObject1 = ((n)localObject1).Bxr;
          if (localObject1 != null) {
            ((StoryVideoView)localObject1).setNeedShowLoading(true);
          }
          localObject1 = new n.a(this.Bxy);
          ((n.a)localObject1).pGr = this.pGr;
          ((n.a)localObject1).a(this.Bxx, this.Bxe);
          localObject3 = new com.tencent.mm.i.h();
          ((com.tencent.mm.i.h)localObject3).fLl = "task_StoryVideoViewMgr";
          localObject4 = new n.a(this.Bxy);
          ((n.a)localObject4).pGr = this.pGr;
          ((n.a)localObject4).a(this.Bxx, this.Bxe);
          ((com.tencent.mm.i.h)localObject3).field_mediaId = paramString1;
          ((com.tencent.mm.i.h)localObject3).url = paramString3;
          ((com.tencent.mm.i.h)localObject3).fLI = 1;
          ((com.tencent.mm.i.h)localObject3).fLD = 6;
          ((com.tencent.mm.i.h)localObject3).concurrentCount = 4;
          ((com.tencent.mm.i.h)localObject3).field_fullpath = paramString2;
          ((com.tencent.mm.i.h)localObject3).fLQ = ((h.a)localObject1);
          ((com.tencent.mm.i.h)localObject3).field_fileType = com.tencent.mm.i.a.fKJ;
          ((com.tencent.mm.i.h)localObject3).field_requestVideoFormat = com.tencent.mm.modelcontrol.d.I(1, paramString2);
          paramString2 = m.BwQ;
          paramString2 = this.Bxe;
          if (paramString2 == null) {
            p.gkB();
          }
          m.j(paramString2);
          paramString2 = this.Bxy.Bwy;
          if (paramString2 != null)
          {
            paramString3 = com.tencent.mm.plugin.story.h.b.BiV;
            l = paramString2.dLI;
            if (this.Bxx != null)
            {
              paramString2 = this.Bxx;
              if ((paramString2 == null) || (paramString2.field_cacheSize != 0)) {
                break label894;
              }
            }
            bool = true;
            label620:
            com.tencent.mm.plugin.story.h.b.H(l, bool);
          }
          com.tencent.mm.modelvideo.o.aNi().a((com.tencent.mm.i.h)localObject3);
          if ((this.Bxe != null) && (paramString1 != null))
          {
            paramString2 = m.BwQ;
            paramString2 = this.Bxe;
            if (paramString2 == null) {
              p.gkB();
            }
            paramString3 = m.k(paramString2);
            if ((paramString3.stM) && (!((n.a)localObject1).stM))
            {
              localObject3 = this.TAG;
              localObject4 = new StringBuilder("checkPreloadOnVideoPlay ").append(paramString1).append(", moovReady, offset:").append(paramString3.offset).append(", length:").append(paramString3.length).append(", cacheSize:");
              paramString2 = this.Bxx;
              if (paramString2 == null) {
                break label900;
              }
            }
          }
        }
      }
      label900:
      for (paramString2 = Integer.valueOf(paramString2.field_cacheSize);; paramString2 = null)
      {
        localObject4 = ((StringBuilder)localObject4).append(paramString2).append(", totalSize:");
        com.tencent.mm.plugin.story.i.n localn = this.Bxx;
        paramString2 = localObject2;
        if (localn != null) {
          paramString2 = Integer.valueOf(localn.field_totalSize);
        }
        ae.i((String)localObject3, paramString2 + ", preloadFinish:" + paramString3.Bxd);
        if ((paramString3.offset > 0L) && (paramString3.length > 0L))
        {
          ((n.a)localObject1).a(paramString1, paramString3.offset, paramString3.length, "");
          paramString1 = this.Bxx;
          if (paramString1 != null) {
            i = paramString1.field_cacheSize;
          }
          this.dAe = i;
          this.Bxd = paramString3.Bxd;
        }
        AppMethodBeat.o(120635);
        return;
        label888:
        localObject1 = null;
        break;
        label894:
        bool = false;
        break label620;
      }
    }
    
    public final void requestVideoData(final String paramString, final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(120637);
      p.h(paramString, "mediaId");
      com.tencent.mm.ac.c.h((d.g.a.a)new a(this, paramString, paramInt1, paramInt2));
      AppMethodBeat.o(120637);
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(n.b paramb, String paramString, int paramInt1, int paramInt2)
      {
        super();
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$initCreateVideoView$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IReport;", "idkeyStat", "", "ID", "", "key", "value", "isImportant", "", "kvStat", "logID", "", "val", "", "plugin-story_release"})
  public static final class c
    implements i.c
  {
    public final void rd(long paramLong)
    {
      AppMethodBeat.i(120639);
      StoryVideoView localStoryVideoView = this.Bxy.Bxr;
      if (localStoryVideoView != null)
      {
        if (!localStoryVideoView.Bxh)
        {
          g.yxI.idkeyStat(this.Bxy.Bxt, paramLong, 1L, false);
          if ((paramLong >= 141L) && (paramLong <= 145L)) {
            ae.i(this.Bxy.TAG, "initCreateVideoView test key " + paramLong + " value 1 currVideoItem:" + this.Bxy.Bwy + ' ' + bu.fpN());
          }
        }
        AppMethodBeat.o(120639);
        return;
      }
      AppMethodBeat.o(120639);
    }
    
    public final void vG(String paramString) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/OnlineVideoEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<ny>
  {
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(n.d paramd, ny paramny)
      {
        super();
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-story_release"})
  public static final class e
    implements i.b
  {
    public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120642);
      ae.i(this.Bxy.TAG, "videoViewCallback onError: " + paramString1 + ", meidiaId:" + paramString2 + ", errorMsg:" + paramString3 + ", what:" + paramInt1 + ", extra:" + paramInt2);
      AppMethodBeat.o(120642);
    }
    
    public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120645);
      ae.i(this.Bxy.TAG, "videoViewCallback onGetVideoSize: " + paramString1 + ", " + this.Bxy.Bww + ", meidiaId:" + paramString2);
      AppMethodBeat.o(120645);
    }
    
    public final void ds(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120643);
      ae.i(this.Bxy.TAG, "videoViewCallback onPrepared: " + paramString1 + ", meidiaId:" + paramString2);
      AppMethodBeat.o(120643);
    }
    
    public final void dt(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120644);
      ae.i(this.Bxy.TAG, "videoViewCallback onVideoEnded: " + paramString1 + ", meidiaId:" + paramString2);
      paramString1 = com.tencent.mm.plugin.story.h.h.BjR;
      paramString1 = com.tencent.mm.plugin.story.h.h.enI();
      paramString1.lt(paramString1.TQ() + 1L);
      paramString1 = this.Bxy.Bwy;
      if (paramString1 != null)
      {
        paramString2 = com.tencent.mm.plugin.story.h.b.BiV;
        long l = paramString1.dLI;
        if (com.tencent.mm.plugin.story.h.b.aKB())
        {
          ae.v("MicroMsg.StoryBrowseDetailIDKeyStat", "onVideoEnd ".concat(String.valueOf(l)));
          if (com.tencent.mm.plugin.story.h.b.BiH.containsKey(Long.valueOf(l)))
          {
            paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.BiH.get(Long.valueOf(l));
            if (paramString1 != null)
            {
              paramString1.hkx = true;
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
    
    public final void du(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120646);
      ae.i(this.Bxy.TAG, "videoViewCallback onVideoPause: " + paramString1 + ", meidiaId:" + paramString2);
      AppMethodBeat.o(120646);
    }
    
    public final void dv(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120647);
      String str = this.Bxy.TAG;
      StringBuilder localStringBuilder = new StringBuilder("videoViewCallback onVideoPlay: ").append(paramString1).append(' ');
      Object localObject = this.Bxy.Bxr;
      long l1;
      label280:
      long l2;
      if (localObject != null)
      {
        localObject = ((StoryVideoView)localObject).getSessionId();
        ae.i(str, (String)localObject + ", " + this.Bxy.Bww + ", meidiaId:" + paramString2 + ", isVideoPause:" + this.Bxy.Bwv);
        if ((d.n.n.H(paramString1, this.Bxy.Bww, false)) && (this.Bxy.Bwv))
        {
          paramString1 = this.Bxy.Bxr;
          if ((paramString1 != null) && (!paramString1.Bxh)) {
            this.Bxy.y(null);
          }
        }
        paramString2 = this.Bxy.Bwy;
        if (paramString2 == null) {
          break label952;
        }
        paramString1 = com.tencent.mm.plugin.story.h.c.Bjp;
        com.tencent.mm.plugin.story.h.c.Bl(paramString2.dLI);
        paramString1 = com.tencent.mm.plugin.story.h.b.BiV;
        l1 = paramString2.dLI;
        if (com.tencent.mm.plugin.story.h.b.aKB())
        {
          localObject = new StringBuilder("onVideoPlay storyId ").append(l1).append(" lastStoryId ").append(com.tencent.mm.plugin.story.h.b.BiG).append(" contains:").append(com.tencent.mm.plugin.story.h.b.BiH.containsKey(Long.valueOf(l1))).append(" result");
          paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.BiH.get(Long.valueOf(l1));
          if (paramString1 == null) {
            break label458;
          }
          paramString1 = Long.valueOf(paramString1.BiY);
          ae.v("MicroMsg.StoryBrowseDetailIDKeyStat", paramString1);
          if ((l1 == com.tencent.mm.plugin.story.h.b.BiG) && (com.tencent.mm.plugin.story.h.b.BiH.containsKey(Long.valueOf(l1))))
          {
            paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.BiH.get(Long.valueOf(l1));
            if ((paramString1 != null) && (!paramString1.Amo) && (paramString1.BiY <= 0L) && (paramString1.BiX > 0L))
            {
              paramString1.isWaiting = false;
              l2 = bu.DD(paramString1.BiX);
              paramString1.BiY = bu.fpO();
              if (l2 <= 120000L) {
                break label463;
              }
              ae.w("MicroMsg.StoryBrowseDetailIDKeyStat", "onPlayCostTime  storyId " + l1 + " onPlayCostTime:" + l2);
            }
          }
        }
      }
      for (;;)
      {
        m.BwQ.By(paramString2.dLI);
        paramString1 = com.tencent.mm.plugin.story.f.k.BbN;
        com.tencent.mm.plugin.story.f.k.aCV(paramString2.username);
        AppMethodBeat.o(120647);
        return;
        localObject = null;
        break;
        label458:
        paramString1 = null;
        break label280;
        label463:
        ae.i("MicroMsg.StoryBrowseDetailIDKeyStat", "onPlayCostTime  storyId " + l1 + " onPlayCostTime:" + l2);
        com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 31L, l2);
        com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 30L, 1L);
        if (l2 <= 400L)
        {
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 90L, 1L);
          label536:
          if (l2 > 400L) {
            break label719;
          }
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 50L, 1L);
          label555:
          if (l1 != com.tencent.mm.plugin.story.h.b.BiJ) {
            break label840;
          }
          if (!com.tencent.mm.plugin.story.h.b.BiN) {
            break label842;
          }
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 40L, 1L);
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 42L, l2);
        }
        for (;;)
        {
          if (l2 <= 1000L)
          {
            if (com.tencent.mm.plugin.story.h.b.BiN)
            {
              com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 44L, 1L);
              break;
              if (l2 <= 800L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 91L, 1L);
                break label536;
              }
              if (l2 <= 1600L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 92L, 1L);
                break label536;
              }
              if (l2 <= 3200L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 93L, 1L);
                break label536;
              }
              if (l2 <= 5000L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 94L, 1L);
                break label536;
              }
              com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 95L, 1L);
              break label536;
              label719:
              if (l2 <= 800L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 51L, 1L);
                break label555;
              }
              if (l2 <= 1000L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 52L, 1L);
                break label555;
              }
              if (l2 <= 2000L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 53L, 1L);
                break label555;
              }
              if (l2 <= 3000L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 54L, 1L);
                break label555;
              }
              if (l2 <= 4000L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 55L, 1L);
                break label555;
              }
              com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 56L, 1L);
              break label555;
              label840:
              break;
              label842:
              com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 41L, 1L);
              com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 43L, l2);
              continue;
            }
            com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 45L, 1L);
            break;
          }
        }
        if (l2 <= 2000L)
        {
          if (com.tencent.mm.plugin.story.h.b.BiN) {
            com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 46L, 1L);
          } else {
            com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 47L, 1L);
          }
        }
        else if (com.tencent.mm.plugin.story.h.b.BiN) {
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 48L, 1L);
        } else {
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pXC, 49L, 1L);
        }
      }
      label952:
      AppMethodBeat.o(120647);
    }
    
    public final void dw(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120648);
      ae.i(this.Bxy.TAG, "videoViewCallback onVideoWaiting: " + paramString1 + ", meidiaId:" + paramString2);
      paramString1 = this.Bxy.Bwy;
      if (paramString1 != null)
      {
        paramString2 = com.tencent.mm.plugin.story.h.c.Bjp;
        com.tencent.mm.plugin.story.h.c.Bk(paramString1.dLI);
        paramString2 = com.tencent.mm.plugin.story.h.b.BiV;
        long l = paramString1.dLI;
        if ((com.tencent.mm.plugin.story.h.b.aKB()) && (com.tencent.mm.plugin.story.h.b.BiH.containsKey(Long.valueOf(l))))
        {
          paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.BiH.get(Long.valueOf(l));
          if ((paramString1 != null) && (!paramString1.Amo) && (paramString1.BiZ))
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
    
    public final void dx(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120649);
      String str = this.Bxy.TAG;
      StringBuilder localStringBuilder = new StringBuilder("videoViewCallback onVideoWaitingEnd: ").append(paramString1).append(' ');
      Object localObject = this.Bxy.Bxr;
      if (localObject != null) {}
      for (localObject = ((StoryVideoView)localObject).getSessionId();; localObject = null)
      {
        ae.i(str, (String)localObject + ", " + this.Bxy.Bww + ", meidiaId:" + paramString2 + ", isVideoPause:" + this.Bxy.Bwv);
        if ((d.n.n.H(paramString1, this.Bxy.Bww, false)) && (this.Bxy.Bwv))
        {
          paramString1 = this.Bxy.Bxr;
          if (paramString1 == null) {
            break;
          }
          if (!paramString1.Bxh) {
            this.Bxy.y(null);
          }
        }
        AppMethodBeat.o(120649);
        return;
      }
      AppMethodBeat.o(120649);
    }
    
    public final void eX(String paramString1, String paramString2)
    {
      AppMethodBeat.i(221757);
      ae.i(this.Bxy.TAG, "onVideoFirstFrameDraw: " + paramString1 + ", meidiaId:" + paramString2);
      AppMethodBeat.o(221757);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.n
 * JD-Core Version:    0.7.0.1
 */