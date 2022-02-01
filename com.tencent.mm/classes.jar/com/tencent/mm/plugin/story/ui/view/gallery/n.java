package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.b.a.es;
import com.tencent.mm.g.b.a.ez;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import d.v;
import d.y;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "", "()V", "STORY_VIDEO_VIEW_IDKEY_STAT", "", "TAG", "", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "currentSessionId", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "onlineVideoEventListener", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1;", "proxy", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayProxy;", "showLoadingTime", "", "videoView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView;", "videoViewCallback", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "checkPauseOnProgress", "getPlayStatus", "getVideoView", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "newVideoViewInstance", "onUIDestroy", "onUIPause", "onUIResume", "pauseVideo", "playVideo", "resetVideo", "sameParent", "setMute", "setNeedShowLoading", "show", "setVideoViewProp", "stopTask", "stopVideo", "detach", "VideoPlayCdnCallback", "VideoPlayProxy", "plugin-story_release"})
public final class n
{
  final String TAG;
  private boolean ftN;
  boolean zNA;
  private com.tencent.mm.compatible.util.b zNB;
  private boolean zNC;
  boolean zNw;
  String zNx;
  private boolean zNy;
  com.tencent.mm.plugin.story.f.d.j zNz;
  StoryVideoView zOs;
  b zOt;
  final long zOu;
  int zOv;
  private final d zOw;
  private final e zOx;
  
  public n()
  {
    AppMethodBeat.i(120664);
    this.TAG = "MicroMsg.Gallery.StoryVideoViewMgr";
    this.zNB = new com.tencent.mm.compatible.util.b(ai.getContext());
    this.zOu = 987L;
    this.zOw = new d(this);
    ac.i(this.TAG, "init create StoryVideoViewMgr " + hashCode());
    com.tencent.mm.sdk.b.a.GpY.c((com.tencent.mm.sdk.b.c)this.zOw);
    this.zOx = new e(this);
    AppMethodBeat.o(120664);
  }
  
  private final boolean g(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    Object localObject2 = null;
    AppMethodBeat.i(120651);
    Object localObject3;
    if (paramj.dwR != 0)
    {
      localObject1 = this.zNz;
      if ((localObject1 != null) && (((com.tencent.mm.plugin.story.f.d.j)localObject1).dwR == paramj.dwR))
      {
        localObject3 = paramj.zuO;
        localObject1 = this.zNz;
        if (localObject1 != null) {}
        for (localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).zuO; localObject3 == localObject1; localObject1 = null)
        {
          AppMethodBeat.o(120651);
          return true;
        }
      }
    }
    Object localObject1 = (CharSequence)paramj.zuP.Url;
    int i;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label187;
      }
      localObject1 = this.zNz;
      if (localObject1 == null) {
        break label182;
      }
      localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).zuP;
      if (localObject1 == null) {
        break label182;
      }
    }
    label182:
    for (localObject1 = ((ddy)localObject1).Url;; localObject1 = null)
    {
      if (!d.g.b.k.g(localObject1, paramj.zuP.Url)) {
        break label187;
      }
      localObject1 = paramj.zuO;
      localObject3 = this.zNz;
      paramj = localObject2;
      if (localObject3 != null) {
        paramj = ((com.tencent.mm.plugin.story.f.d.j)localObject3).zuO;
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
  
  private final boolean w(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120663);
    Object localObject = this.zOs;
    if (localObject != null) {}
    for (localObject = ((StoryVideoView)localObject).getParent();; localObject = null)
    {
      boolean bool = d.g.b.k.g(localObject, paramViewGroup);
      AppMethodBeat.o(120663);
      return bool;
    }
  }
  
  public final void Er()
  {
    AppMethodBeat.i(120653);
    ac.m(this.TAG, "playVideo, " + this.zNw + ' ' + this.zNA + ", " + this.zNz, new Object[0]);
    dZW();
    this.zNA = true;
    Object localObject1 = this.zNz;
    if (localObject1 != null)
    {
      boolean bool = this.zNw;
      this.zNw = false;
      if (!bool) {
        break label182;
      }
      localObject2 = this.zOs;
      if (localObject2 != null) {
        ((StoryVideoView)localObject2).o((com.tencent.mm.plugin.story.f.d.j)localObject1);
      }
      this.zNw = false;
      if (((com.tencent.mm.plugin.story.f.d.j)localObject1).dWy()) {
        this.zNy = true;
      }
      if (!this.zNC)
      {
        this.zNB.requestFocus();
        this.zNC = true;
      }
    }
    localObject1 = com.tencent.mm.plugin.story.h.h.zAU;
    Object localObject2 = com.tencent.mm.plugin.story.h.h.dXK();
    localObject1 = this.zOs;
    if (localObject1 != null) {}
    for (localObject1 = ((StoryVideoView)localObject1).getContext();; localObject1 = null)
    {
      ((ez)localObject2).jl(ax.iI((Context)localObject1));
      AppMethodBeat.o(120653);
      return;
      label182:
      this.zNx = UUID.randomUUID().toString();
      localObject2 = this.zOt;
      if (localObject2 != null) {
        ((b)localObject2).p((com.tencent.mm.plugin.story.f.d.j)localObject1);
      }
      localObject2 = this.zOs;
      if (localObject2 == null) {
        break;
      }
      ((StoryVideoView)localObject2).a((com.tencent.mm.plugin.story.f.d.j)localObject1, this.zNx);
      break;
    }
  }
  
  public final void a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(120650);
    d.g.b.k.h(paramViewGroup, "parent");
    this.zOv = 0;
    boolean bool = w(paramViewGroup);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("attachVideoView, parent:").append(paramViewGroup.hashCode()).append(", isVideoPause:").append(this.zNw).append(", currentSessionId:").append(this.zNx).append(", isPlayingVideoItem:").append(this.zNy).append(" videoView ");
    Object localObject = this.zOs;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((StoryVideoView)localObject).hashCode());; localObject = null)
    {
      ac.m(str, localObject + " sameParent " + bool + " this:" + hashCode(), new Object[0]);
      v(paramViewGroup);
      if (this.zOs == null)
      {
        localObject = ai.getContext();
        d.g.b.k.g(localObject, "MMApplicationContext.getContext()");
        gt((Context)localObject);
      }
      if (bool) {
        break label239;
      }
      if (paramLayoutParams != null) {
        break;
      }
      paramViewGroup.addView((View)this.zOs);
      AppMethodBeat.o(120650);
      return;
    }
    paramViewGroup.addView((View)this.zOs, paramLayoutParams);
    AppMethodBeat.o(120650);
    return;
    label239:
    if (paramLayoutParams != null)
    {
      paramViewGroup = this.zOs;
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
      ac.m(this.TAG, "change:" + bool + ' ' + this.zNA + ", " + paramBoolean + ", changeVideoItem: origin: " + this.zNz + ", new: " + paramj + ",  change:" + bool + " this:" + hashCode(), new Object[0]);
      if (bool)
      {
        this.zNz = paramj;
        if ((this.zNA) || (paramBoolean))
        {
          a(this, false, 2);
          Er();
        }
      }
      AppMethodBeat.o(120652);
      return;
    }
  }
  
  public final void al(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(120655);
    ac.m(this.TAG, "stopVideo, detach: ".concat(String.valueOf(paramBoolean1)), new Object[0]);
    Object localObject;
    if (this.zNy)
    {
      this.zNx = null;
      localObject = this.zOs;
      if (localObject != null) {
        ((StoryVideoView)localObject).stop();
      }
      this.zNw = false;
      if (this.zNC)
      {
        this.zNB.YC();
        this.zNC = false;
      }
      this.zNy = false;
    }
    if (paramBoolean1)
    {
      this.zNA = false;
      v(null);
      localObject = com.tencent.mm.plugin.story.h.h.zAU;
      com.tencent.mm.plugin.story.h.h.dXK().jp(System.currentTimeMillis());
      if (paramBoolean2)
      {
        localObject = com.tencent.mm.plugin.story.h.h.zAU;
        com.tencent.mm.plugin.story.h.h.dXL();
      }
    }
    AppMethodBeat.o(120655);
  }
  
  final void dZW()
  {
    AppMethodBeat.i(120654);
    ac.i(this.TAG, "setVideoViewProp, isMute:" + this.ftN);
    StoryVideoView localStoryVideoView = this.zOs;
    if (localStoryVideoView != null)
    {
      localStoryVideoView.setMute(this.ftN);
      AppMethodBeat.o(120654);
      return;
    }
    AppMethodBeat.o(120654);
  }
  
  final void gt(Context paramContext)
  {
    AppMethodBeat.i(120661);
    this.zOs = new StoryVideoView(paramContext);
    this.zOt = new b();
    paramContext = this.zOs;
    if (paramContext != null) {
      paramContext.setIOnlineVideoProxy((com.tencent.mm.modelvideo.b)this.zOt);
    }
    paramContext = this.zOs;
    if (paramContext != null) {
      paramContext.setIMMVideoViewCallback((h.b)this.zOx);
    }
    paramContext = this.zOs;
    if (paramContext != null) {
      paramContext.setReporter((h.c)new c(this));
    }
    this.zNy = false;
    AppMethodBeat.o(120661);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(120660);
    ac.i(this.TAG, "onUIDestroy " + hashCode());
    this.zNA = false;
    v(null);
    this.zNz = null;
    this.zOs = null;
    if (this.zNC)
    {
      this.zNB.YC();
      this.zNC = false;
    }
    com.tencent.mm.sdk.b.a.GpY.d((com.tencent.mm.sdk.b.c)this.zOw);
    AppMethodBeat.o(120660);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(120659);
    ac.i(this.TAG, "onUIPause " + hashCode());
    v(null);
    if (this.zNC)
    {
      this.zNB.YC();
      this.zNC = false;
    }
    AppMethodBeat.o(120659);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(120658);
    StoryVideoView localStoryVideoView = this.zOs;
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
    ac.i(this.TAG, "setMute " + paramBoolean + " ret " + "");
    this.ftN = paramBoolean;
    AppMethodBeat.o(120657);
  }
  
  final void v(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120662);
    String str = this.TAG;
    Object localObject1 = new StringBuilder("checkDetachVideoView, videoView:");
    Object localObject2 = this.zOs;
    int i;
    boolean bool;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", isPlay:");
      localObject2 = this.zOs;
      if (localObject2 == null) {
        break label248;
      }
      bool = ((StoryVideoView)localObject2).isPlaying();
      label72:
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", parent:");
      localObject1 = this.zOs;
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
      ac.m(str, i + ", isPlayingVideoItem:" + this.zNy, new Object[0]);
      localObject1 = this.zOs;
      if (localObject1 == null) {
        break label269;
      }
      localObject1 = ((StoryVideoView)localObject1).getParent();
      label187:
      if ((localObject1 == null) || (w(paramViewGroup))) {
        break label299;
      }
      a(this, true, 1);
      paramViewGroup = this.zOs;
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
    ((ViewGroup)paramViewGroup).removeView((View)this.zOs);
    this.zNz = null;
    label299:
    AppMethodBeat.o(120662);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayCdnCallback;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;)V", "TAG", "", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "isMoovReady", "", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "videoCache", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "onDataAvailable", "", "mediaId", "offset", "", "length", "onFinish", "ret", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onMoovReady", "svrflag", "onProgress", "total", "setIEngineCallback", "callback", "setVideoCache", "vitem", "plugin-story_release"})
  final class a
    implements h.a
  {
    final String TAG = "MicroMsg.VideoPlayProxy";
    com.tencent.mm.modelvideo.b.a oWd;
    volatile boolean rvp;
    com.tencent.mm.plugin.story.f.d.j zOf;
    com.tencent.mm.plugin.story.i.n zOy;
    
    public final void a(com.tencent.mm.plugin.story.i.n paramn, com.tencent.mm.plugin.story.f.d.j paramj)
    {
      this.zOy = paramn;
      this.zOf = paramj;
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
        localObject1 = this.zOz.zNz;
        if (localObject1 == null) {
          break label553;
        }
        localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).username;
        ac.i((String)localObject3, (String)localObject1);
        localObject1 = this.zOf;
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.plugin.story.h.b.zzY;
          com.tencent.mm.plugin.story.h.b.yn(((com.tencent.mm.plugin.story.f.d.j)localObject1).dyg);
          m.zNR.yD(((com.tencent.mm.plugin.story.f.d.j)localObject1).dyg);
        }
        localObject1 = this.zOy;
        if (localObject1 == null) {
          break label559;
        }
        localObject1 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath;
        label174:
        localObject1 = com.tencent.mm.plugin.sight.base.e.asx((String)localObject1);
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.plugin.story.h.h.zAU;
          com.tencent.mm.plugin.story.h.h.dXY().iR(((com.tencent.mm.plugin.sight.base.a)localObject1).videoDuration);
          localObject3 = com.tencent.mm.plugin.story.h.h.zAU;
          com.tencent.mm.plugin.story.h.h.dXY().iS(((com.tencent.mm.plugin.sight.base.a)localObject1).videoBitrate);
          localObject3 = com.tencent.mm.plugin.story.h.h.zAU;
          com.tencent.mm.plugin.story.h.h.dXY().iT(((com.tencent.mm.plugin.sight.base.a)localObject1).audioBitrate);
          localObject3 = com.tencent.mm.plugin.story.h.h.zAU;
          com.tencent.mm.plugin.story.h.h.dXY().iU(((com.tencent.mm.plugin.sight.base.a)localObject1).frameRate);
          localObject3 = com.tencent.mm.plugin.story.h.h.zAU;
          com.tencent.mm.plugin.story.h.h.dXY().iV(((com.tencent.mm.plugin.sight.base.a)localObject1).width);
          localObject3 = com.tencent.mm.plugin.story.h.h.zAU;
          com.tencent.mm.plugin.story.h.h.dXY().iW(((com.tencent.mm.plugin.sight.base.a)localObject1).height);
          localObject3 = com.tencent.mm.plugin.story.h.h.zAU;
          com.tencent.mm.plugin.story.h.h.dXY().iX(((com.tencent.mm.plugin.sight.base.a)localObject1).audioChannel);
        }
        localObject1 = com.tencent.mm.plugin.story.h.h.zAU;
        localObject1 = com.tencent.mm.plugin.story.h.h.dXY();
        if (this.zOy == null) {
          break label565;
        }
        localObject3 = this.zOy;
        if (localObject3 == null) {
          d.g.b.k.fOy();
        }
        l = ((com.tencent.mm.plugin.story.i.n)localObject3).field_totalSize;
        label351:
        ((es)localObject1).iQ(l);
        localObject1 = com.tencent.mm.plugin.story.h.h.zAU;
        localObject3 = com.tencent.mm.plugin.story.h.h.dXY();
        localObject1 = this.zOy;
        if (localObject1 == null) {
          break label571;
        }
        localObject1 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_url;
        label387:
        ((es)localObject3).mt((String)localObject1);
        localObject1 = com.tencent.mm.plugin.story.h.h.zAU;
        localObject3 = com.tencent.mm.plugin.story.h.h.dXY();
        f.aDE();
        localObject1 = this.zOy;
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
        ((es)localObject3).mu(com.tencent.mm.an.a.BM((String)localObject1));
        if (paramd != null)
        {
          localObject1 = com.tencent.mm.plugin.story.h.h.zAU;
          com.tencent.mm.plugin.story.h.h.dXY().iO(paramd.field_startTime);
          localObject1 = com.tencent.mm.plugin.story.h.h.zAU;
          com.tencent.mm.plugin.story.h.h.dXY().iP(paramd.field_endTime);
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
      paramd = com.tencent.mm.plugin.story.h.h.zAU;
      com.tencent.mm.plugin.story.h.h.dXY().mv(((StringBuffer)localObject1).toString());
      label599:
      if (this.zOz.zOt != null)
      {
        paramd = com.tencent.mm.plugin.story.h.h.zAU;
        paramd = com.tencent.mm.plugin.story.h.h.dXY();
        localObject1 = this.zOz.zOt;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        paramd.iY(((n.b)localObject1).dnl);
        paramd = com.tencent.mm.plugin.story.h.h.zAU;
        paramd = com.tencent.mm.plugin.story.h.h.dXY();
        localObject1 = this.zOz.zOt;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        if (!((n.b)localObject1).zOe) {
          break label719;
        }
        l = 3L;
      }
      for (;;)
      {
        paramd.iZ(l);
        paramd = com.tencent.mm.plugin.story.h.h.zAU;
        com.tencent.mm.plugin.story.h.h.dXZ();
        com.tencent.mm.ac.c.g((d.g.a.a)new b(this, paramString, paramInt));
        AppMethodBeat.o(120632);
        return;
        label719:
        localObject1 = this.zOz.zOt;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        if (((n.b)localObject1).dnl > 0) {
          l = 2L;
        } else {
          l = 1L;
        }
      }
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(192933);
      d.g.b.k.h(paramString1, "mediaId");
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onMoovReady, mediaId:").append(paramString1).append(", offset:").append(paramLong1).append(", length:").append(paramLong2).append(", isMoovReady:").append(this.rvp).append(" this:").append(this).append(" currVideoItem:");
      Object localObject = this.zOz.zNz;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.story.f.d.j)localObject).username;; localObject = null)
      {
        ac.i(str, (String)localObject);
        if (!this.rvp) {
          break;
        }
        AppMethodBeat.o(192933);
        return;
      }
      this.rvp = true;
      com.tencent.mm.ac.c.g((d.g.a.a)new c(this, paramString1, paramLong1, paramLong2, paramString2));
      AppMethodBeat.o(192933);
    }
    
    public final void i(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(120631);
      d.g.b.k.h(paramString, "mediaId");
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onProgress, mediaId:").append(paramString).append(", offset:").append(paramLong1).append(", total:").append(paramLong2).append(" this:").append(this).append(" currVideoItem:");
      Object localObject = this.zOz.zNz;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.story.f.d.j)localObject).username;; localObject = null)
      {
        ac.i(str, (String)localObject);
        com.tencent.mm.ac.c.g((d.g.a.a)new d(this, paramString, paramLong1, paramLong2));
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
      Object localObject = this.zOz.zNz;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.story.f.d.j)localObject).username;; localObject = null)
      {
        ac.i(str, (String)localObject);
        com.tencent.mm.ac.c.g((d.g.a.a)new a(this, paramString, paramLong1, paramLong2));
        AppMethodBeat.o(120630);
        return;
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(n.a parama, String paramString, long paramLong1, long paramLong2)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(n.a parama, String paramString, int paramInt)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      c(n.a parama, String paramString1, long paramLong1, long paramLong2, String paramString2)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayProxy;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;)V", "TAG", "", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "preloadFinish", "", "getPreloadFinish", "()Z", "setPreloadFinish", "(Z)V", "preloadSize", "", "getPreloadSize", "()I", "setPreloadSize", "(I)V", "videoCache", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "createReportRptTips", "", "", "()[Ljava/lang/Object;", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "url", "path", "callback", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayCdnCallback;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "isVideoDataAvailable", "offset", "length", "requestVideoData", "", "setIEngineCallback", "setStoryVideoItem", "startHttpStream", "stop", "plugin-story_release"})
  final class b
    implements com.tencent.mm.modelvideo.b
  {
    final String TAG = "MicroMsg.VideoPlayProxy";
    int dnl;
    private com.tencent.mm.modelvideo.b.a oWd;
    boolean zOe;
    com.tencent.mm.plugin.story.f.d.j zOf;
    com.tencent.mm.plugin.story.i.n zOy;
    
    public final void a(com.tencent.mm.modelvideo.b.a parama)
    {
      this.oWd = parama;
    }
    
    public final void fo(String paramString)
    {
      int k = 2;
      int j = 1;
      com.tencent.mm.plugin.story.f.d.j localj = null;
      AppMethodBeat.i(120636);
      d.g.b.k.h(paramString, "mediaId");
      ac.i(this.TAG, "this: " + this + " stop " + paramString + ' ' + bs.eWi());
      Object[] arrayOfObject = new Object[17];
      Object localObject1 = this.zOz.zOs;
      label124:
      int i;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).getCurrPosMs());
        arrayOfObject[0] = localObject1;
        localObject1 = this.zOz.zOs;
        if (localObject1 == null) {
          break label588;
        }
        localObject1 = Integer.valueOf((int)((StoryVideoView)localObject1).getFirstPlayWaitTime());
        arrayOfObject[1] = localObject1;
        localObject1 = this.zOz.zOs;
        if (localObject1 == null) {
          break label594;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).eak());
        label154:
        arrayOfObject[2] = localObject1;
        localObject1 = this.zOz.zOs;
        if (localObject1 == null) {
          break label600;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).eal());
        label184:
        arrayOfObject[3] = localObject1;
        localObject1 = this.zOz.zOs;
        if (localObject1 == null) {
          break label606;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).eam());
        label214:
        arrayOfObject[4] = localObject1;
        localObject1 = this.zOz.zOs;
        if (localObject1 == null) {
          break label612;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).getStayTime());
        label244:
        arrayOfObject[5] = localObject1;
        localObject1 = this.zOz.zOs;
        if (localObject1 == null) {
          break label618;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).getErrorCode());
        label274:
        arrayOfObject[6] = localObject1;
        arrayOfObject[7] = Integer.valueOf(this.dnl);
        if (this.dnl <= 0) {
          break label624;
        }
        i = 2;
        label302:
        arrayOfObject[8] = Integer.valueOf(i);
        i = k;
        if (this.zOe) {
          i = 3;
        }
        arrayOfObject[9] = Integer.valueOf(i);
        localObject1 = com.tencent.mm.plugin.story.e.b.zrj;
        localObject1 = this.zOz.zOs;
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
        arrayOfObject[10] = com.tencent.mm.plugin.story.e.b.a.awu((String)localObject1);
        Object localObject2 = this.zOf;
        localObject1 = localj;
        if (localObject2 != null) {
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject2).dyg);
        }
        arrayOfObject[11] = localObject1;
        localObject1 = com.tencent.mm.plugin.story.h.h.zAU;
        arrayOfObject[12] = Long.valueOf(com.tencent.mm.plugin.story.h.h.dXK().Ru());
        localObject1 = com.tencent.mm.plugin.story.h.h.zAU;
        arrayOfObject[13] = Long.valueOf(com.tencent.mm.plugin.story.h.h.dXK().Rw());
        localObject1 = com.tencent.mm.plugin.story.h.h.zAU;
        if (com.tencent.mm.plugin.story.h.h.dXK().Rz() != 1L) {
          break label629;
        }
        i = j;
        label469:
        arrayOfObject[14] = Integer.valueOf(i);
        localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
        localObject1 = j.b.dVE();
        localj = this.zOf;
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
      for (long l = localj.dyg;; l = 0L)
      {
        arrayOfObject[15] = Integer.valueOf(((com.tencent.mm.plugin.story.i.k)localObject1).yA(l));
        arrayOfObject[16] = Integer.valueOf(this.zOz.zOv);
        ac.i(this.TAG, "reportTips: " + Arrays.toString(arrayOfObject));
        com.tencent.mm.modelvideo.o.aJz().j(paramString, arrayOfObject);
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
      Object localObject1 = this.zOf;
      if (localObject1 != null)
      {
        localObject2 = s.ztj;
        this.zOy = s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
        localObject1 = this.zOy;
        if ((localObject1 != null) && (((com.tencent.mm.plugin.story.i.n)localObject1).Vz() == true))
        {
          str2 = this.TAG;
          localObject1 = new StringBuilder("isVideoDataAvailable ").append(paramString).append(", ").append(paramInt1).append(", ").append(paramInt2).append(", download finish cacheSize:");
          localObject2 = this.zOy;
          paramString = str1;
          if (localObject2 != null) {
            paramString = Integer.valueOf(((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize);
          }
          ac.i(str2, paramString + " this:" + this);
          AppMethodBeat.o(120638);
          return true;
        }
      }
      boolean bool = com.tencent.mm.modelvideo.o.aJz().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      str1 = this.TAG;
      localObject1 = new StringBuilder("isVideoDataAvailable ").append(paramString).append(", ").append(paramInt1).append(", ").append(paramInt2).append(", available:").append(bool).append(" cacheSize:");
      Object localObject2 = this.zOy;
      paramString = str2;
      if (localObject2 != null) {
        paramString = Integer.valueOf(((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize);
      }
      ac.i(str1, paramString + " this:" + this);
      AppMethodBeat.o(120638);
      return bool;
    }
    
    public final void p(com.tencent.mm.plugin.story.f.d.j paramj)
    {
      AppMethodBeat.i(120634);
      d.g.b.k.h(paramj, "item");
      this.zOf = paramj;
      s locals = s.ztj;
      this.zOy = s.a(paramj);
      ac.i(this.TAG, "setStoryVideoItem " + paramj + " videoCache " + this.zOy);
      AppMethodBeat.o(120634);
    }
    
    public final void q(String paramString1, String paramString2, String paramString3)
    {
      int i = 0;
      Object localObject2 = null;
      AppMethodBeat.i(120635);
      ac.i(this.TAG, "startHttpStream " + paramString1 + ' ' + paramString2 + ' ' + paramString3 + " this:" + this);
      Object localObject1;
      Object localObject3;
      Object localObject4;
      boolean bool;
      if (this.zOf != null)
      {
        localObject1 = s.ztj;
        localObject1 = this.zOf;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        this.zOy = s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
        localObject1 = this.zOy;
        if ((localObject1 != null) && (!i.eA(((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath)))
        {
          localObject3 = com.tencent.mm.plugin.story.f.l.zsu;
          localObject3 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath;
          d.g.b.k.g(localObject3, "it.field_filePath");
          com.tencent.mm.plugin.story.f.l.awD((String)localObject3);
          ac.i(this.TAG, "startHttpStream error downloadFinish " + ((com.tencent.mm.plugin.story.i.n)localObject1).Vz() + " ret:" + i.eA(((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath) + " path:" + ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath);
          ((com.tencent.mm.plugin.story.i.n)localObject1).dZt();
          localObject3 = com.tencent.mm.plugin.story.f.j.zsh;
          j.b.dVI().b((com.tencent.mm.plugin.story.i.n)localObject1);
        }
        localObject1 = this.zOz.zNz;
        long l;
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.plugin.story.h.c.zAs;
          com.tencent.mm.plugin.story.h.c.dXu();
          localObject3 = com.tencent.mm.plugin.story.h.b.zzY;
          l = ((com.tencent.mm.plugin.story.f.d.j)localObject1).dyg;
          if (com.tencent.mm.plugin.story.h.b.aGX())
          {
            ac.v("MicroMsg.StoryBrowseDetailIDKeyStat", "startHttp storyId ".concat(String.valueOf(l)));
            if (com.tencent.mm.plugin.story.h.b.zzK.containsKey(Long.valueOf(l)))
            {
              localObject1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.zzK.get(Long.valueOf(l));
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.story.h.b.a)localObject1).zAc = true;
              }
            }
          }
        }
        localObject1 = this.zOf;
        if (localObject1 == null) {
          break label880;
        }
        localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).zuP;
        if (localObject1 == null) {
          break label880;
        }
        localObject1 = ((ddy)localObject1).Url;
        if (!bs.isNullOrNil((String)localObject1))
        {
          localObject1 = this.zOz;
          ((n)localObject1).zOv += 1;
          localObject1 = ((n)localObject1).zOs;
          if (localObject1 != null) {
            ((StoryVideoView)localObject1).setNeedShowLoading(true);
          }
          localObject1 = new n.a(this.zOz);
          ((n.a)localObject1).oWd = this.oWd;
          ((n.a)localObject1).a(this.zOy, this.zOf);
          localObject3 = new com.tencent.mm.i.h();
          localObject4 = new n.a(this.zOz);
          ((n.a)localObject4).oWd = this.oWd;
          ((n.a)localObject4).a(this.zOy, this.zOf);
          ((com.tencent.mm.i.h)localObject3).field_mediaId = paramString1;
          ((com.tencent.mm.i.h)localObject3).url = paramString3;
          ((com.tencent.mm.i.h)localObject3).frw = 1;
          ((com.tencent.mm.i.h)localObject3).frr = 6;
          ((com.tencent.mm.i.h)localObject3).concurrentCount = 4;
          ((com.tencent.mm.i.h)localObject3).field_fullpath = paramString2;
          ((com.tencent.mm.i.h)localObject3).frE = ((h.a)localObject1);
          ((com.tencent.mm.i.h)localObject3).field_fileType = com.tencent.mm.i.a.fqy;
          ((com.tencent.mm.i.h)localObject3).field_requestVideoFormat = com.tencent.mm.modelcontrol.d.I(1, paramString2);
          paramString2 = m.zNR;
          paramString2 = this.zOf;
          if (paramString2 == null) {
            d.g.b.k.fOy();
          }
          m.j(paramString2);
          paramString2 = this.zOz.zNz;
          if (paramString2 != null)
          {
            paramString3 = com.tencent.mm.plugin.story.h.b.zzY;
            l = paramString2.dyg;
            if (this.zOy != null)
            {
              paramString2 = this.zOy;
              if ((paramString2 == null) || (paramString2.field_cacheSize != 0)) {
                break label886;
              }
            }
            bool = true;
            label612:
            com.tencent.mm.plugin.story.h.b.F(l, bool);
          }
          com.tencent.mm.modelvideo.o.aJz().a((com.tencent.mm.i.h)localObject3);
          if ((this.zOf != null) && (paramString1 != null))
          {
            paramString2 = m.zNR;
            paramString2 = this.zOf;
            if (paramString2 == null) {
              d.g.b.k.fOy();
            }
            paramString3 = m.k(paramString2);
            if ((paramString3.rvp) && (!((n.a)localObject1).rvp))
            {
              localObject3 = this.TAG;
              localObject4 = new StringBuilder("checkPreloadOnVideoPlay ").append(paramString1).append(", moovReady, offset:").append(paramString3.offset).append(", length:").append(paramString3.length).append(", cacheSize:");
              paramString2 = this.zOy;
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
        com.tencent.mm.plugin.story.i.n localn = this.zOy;
        paramString2 = localObject2;
        if (localn != null) {
          paramString2 = Integer.valueOf(localn.field_totalSize);
        }
        ac.i((String)localObject3, paramString2 + ", preloadFinish:" + paramString3.zOe);
        if ((paramString3.offset > 0L) && (paramString3.length > 0L))
        {
          ((n.a)localObject1).a(paramString1, paramString3.offset, paramString3.length, "");
          paramString1 = this.zOy;
          if (paramString1 != null) {
            i = paramString1.field_cacheSize;
          }
          this.dnl = i;
          this.zOe = paramString3.zOe;
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
      com.tencent.mm.ac.c.g((d.g.a.a)new a(this, paramString, paramInt1, paramInt2));
      AppMethodBeat.o(120637);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$initCreateVideoView$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IReport;", "idkeyStat", "", "ID", "", "key", "value", "isImportant", "", "kvStat", "logID", "", "val", "", "plugin-story_release"})
  public static final class c
    implements h.c
  {
    public final void oQ(long paramLong)
    {
      AppMethodBeat.i(120639);
      StoryVideoView localStoryVideoView = this.zOz.zOs;
      if (localStoryVideoView != null)
      {
        if (!localStoryVideoView.zOi)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(this.zOz.zOu, paramLong, 1L, false);
          if ((paramLong >= 141L) && (paramLong <= 145L)) {
            ac.i(this.zOz.TAG, "initCreateVideoView test key " + paramLong + " value 1 currVideoItem:" + this.zOz.zNz + ' ' + bs.eWi());
          }
        }
        AppMethodBeat.o(120639);
        return;
      }
      AppMethodBeat.o(120639);
    }
    
    public final void sv(String paramString) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/OnlineVideoEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<np>
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(n.d paramd, np paramnp)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-story_release"})
  public static final class e
    implements h.b
  {
    public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120642);
      ac.i(this.zOz.TAG, "videoViewCallback onError: " + paramString1 + ", meidiaId:" + paramString2 + ", errorMsg:" + paramString3 + ", what:" + paramInt1 + ", extra:" + paramInt2);
      AppMethodBeat.o(120642);
    }
    
    public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120645);
      ac.i(this.zOz.TAG, "videoViewCallback onGetVideoSize: " + paramString1 + ", " + this.zOz.zNx + ", meidiaId:" + paramString2);
      AppMethodBeat.o(120645);
    }
    
    public final void jdMethod_do(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120643);
      ac.i(this.zOz.TAG, "videoViewCallback onPrepared: " + paramString1 + ", meidiaId:" + paramString2);
      AppMethodBeat.o(120643);
    }
    
    public final void dp(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120644);
      ac.i(this.zOz.TAG, "videoViewCallback onVideoEnded: " + paramString1 + ", meidiaId:" + paramString2);
      paramString1 = com.tencent.mm.plugin.story.h.h.zAU;
      paramString1 = com.tencent.mm.plugin.story.h.h.dXK();
      paramString1.jw(paramString1.RD() + 1L);
      paramString1 = this.zOz.zNz;
      if (paramString1 != null)
      {
        paramString2 = com.tencent.mm.plugin.story.h.b.zzY;
        long l = paramString1.dyg;
        if (com.tencent.mm.plugin.story.h.b.aGX())
        {
          ac.v("MicroMsg.StoryBrowseDetailIDKeyStat", "onVideoEnd ".concat(String.valueOf(l)));
          if (com.tencent.mm.plugin.story.h.b.zzK.containsKey(Long.valueOf(l)))
          {
            paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.zzK.get(Long.valueOf(l));
            if (paramString1 != null)
            {
              paramString1.gNN = true;
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
    
    public final void dq(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120646);
      ac.i(this.zOz.TAG, "videoViewCallback onVideoPause: " + paramString1 + ", meidiaId:" + paramString2);
      AppMethodBeat.o(120646);
    }
    
    public final void dr(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120647);
      String str = this.zOz.TAG;
      StringBuilder localStringBuilder = new StringBuilder("videoViewCallback onVideoPlay: ").append(paramString1).append(' ');
      Object localObject = this.zOz.zOs;
      long l1;
      label279:
      long l2;
      if (localObject != null)
      {
        localObject = ((StoryVideoView)localObject).getSessionId();
        ac.i(str, (String)localObject + ", " + this.zOz.zNx + ", meidiaId:" + paramString2 + ", isVideoPause:" + this.zOz.zNw);
        if ((d.n.n.I(paramString1, this.zOz.zNx, false)) && (this.zOz.zNw))
        {
          paramString1 = this.zOz.zOs;
          if ((paramString1 != null) && (!paramString1.zOi)) {
            this.zOz.v(null);
          }
        }
        paramString2 = this.zOz.zNz;
        if (paramString2 == null) {
          break label951;
        }
        paramString1 = com.tencent.mm.plugin.story.h.c.zAs;
        com.tencent.mm.plugin.story.h.c.yp(paramString2.dyg);
        paramString1 = com.tencent.mm.plugin.story.h.b.zzY;
        l1 = paramString2.dyg;
        if (com.tencent.mm.plugin.story.h.b.aGX())
        {
          localObject = new StringBuilder("onVideoPlay storyId ").append(l1).append(" lastStoryId ").append(com.tencent.mm.plugin.story.h.b.zzJ).append(" contains:").append(com.tencent.mm.plugin.story.h.b.zzK.containsKey(Long.valueOf(l1))).append(" result");
          paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.zzK.get(Long.valueOf(l1));
          if (paramString1 == null) {
            break label457;
          }
          paramString1 = Long.valueOf(paramString1.zAb);
          ac.v("MicroMsg.StoryBrowseDetailIDKeyStat", paramString1);
          if ((l1 == com.tencent.mm.plugin.story.h.b.zzJ) && (com.tencent.mm.plugin.story.h.b.zzK.containsKey(Long.valueOf(l1))))
          {
            paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.zzK.get(Long.valueOf(l1));
            if ((paramString1 != null) && (!paramString1.yDL) && (paramString1.zAb <= 0L) && (paramString1.zAa > 0L))
            {
              paramString1.isWaiting = false;
              l2 = bs.Ap(paramString1.zAa);
              paramString1.zAb = bs.eWj();
              if (l2 <= 120000L) {
                break label462;
              }
              ac.w("MicroMsg.StoryBrowseDetailIDKeyStat", "onPlayCostTime  storyId " + l1 + " onPlayCostTime:" + l2);
            }
          }
        }
      }
      for (;;)
      {
        m.zNR.yC(paramString2.dyg);
        paramString1 = com.tencent.mm.plugin.story.f.k.zsq;
        com.tencent.mm.plugin.story.f.k.awx(paramString2.username);
        AppMethodBeat.o(120647);
        return;
        localObject = null;
        break;
        label457:
        paramString1 = null;
        break label279;
        label462:
        ac.i("MicroMsg.StoryBrowseDetailIDKeyStat", "onPlayCostTime  storyId " + l1 + " onPlayCostTime:" + l2);
        com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 31L, l2);
        com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 30L, 1L);
        if (l2 <= 400L)
        {
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 90L, 1L);
          label535:
          if (l2 > 400L) {
            break label718;
          }
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 50L, 1L);
          label554:
          if (l1 != com.tencent.mm.plugin.story.h.b.zzM) {
            break label839;
          }
          if (!com.tencent.mm.plugin.story.h.b.zzQ) {
            break label841;
          }
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 40L, 1L);
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 42L, l2);
        }
        for (;;)
        {
          if (l2 <= 1000L)
          {
            if (com.tencent.mm.plugin.story.h.b.zzQ)
            {
              com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 44L, 1L);
              break;
              if (l2 <= 800L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 91L, 1L);
                break label535;
              }
              if (l2 <= 1600L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 92L, 1L);
                break label535;
              }
              if (l2 <= 3200L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 93L, 1L);
                break label535;
              }
              if (l2 <= 5000L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 94L, 1L);
                break label535;
              }
              com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 95L, 1L);
              break label535;
              label718:
              if (l2 <= 800L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 51L, 1L);
                break label554;
              }
              if (l2 <= 1000L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 52L, 1L);
                break label554;
              }
              if (l2 <= 2000L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 53L, 1L);
                break label554;
              }
              if (l2 <= 3000L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 54L, 1L);
                break label554;
              }
              if (l2 <= 4000L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 55L, 1L);
                break label554;
              }
              com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 56L, 1L);
              break label554;
              label839:
              break;
              label841:
              com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 41L, 1L);
              com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 43L, l2);
              continue;
            }
            com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 45L, 1L);
            break;
          }
        }
        if (l2 <= 2000L)
        {
          if (com.tencent.mm.plugin.story.h.b.zzQ) {
            com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 46L, 1L);
          } else {
            com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 47L, 1L);
          }
        }
        else if (com.tencent.mm.plugin.story.h.b.zzQ) {
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 48L, 1L);
        } else {
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 49L, 1L);
        }
      }
      label951:
      AppMethodBeat.o(120647);
    }
    
    public final void ds(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120648);
      ac.i(this.zOz.TAG, "videoViewCallback onVideoWaiting: " + paramString1 + ", meidiaId:" + paramString2);
      paramString1 = this.zOz.zNz;
      if (paramString1 != null)
      {
        paramString2 = com.tencent.mm.plugin.story.h.c.zAs;
        com.tencent.mm.plugin.story.h.c.yo(paramString1.dyg);
        paramString2 = com.tencent.mm.plugin.story.h.b.zzY;
        long l = paramString1.dyg;
        if ((com.tencent.mm.plugin.story.h.b.aGX()) && (com.tencent.mm.plugin.story.h.b.zzK.containsKey(Long.valueOf(l))))
        {
          paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.zzK.get(Long.valueOf(l));
          if ((paramString1 != null) && (!paramString1.yDL) && (paramString1.zAc))
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
    
    public final void dt(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120649);
      String str = this.zOz.TAG;
      StringBuilder localStringBuilder = new StringBuilder("videoViewCallback onVideoWaitingEnd: ").append(paramString1).append(' ');
      Object localObject = this.zOz.zOs;
      if (localObject != null) {}
      for (localObject = ((StoryVideoView)localObject).getSessionId();; localObject = null)
      {
        ac.i(str, (String)localObject + ", " + this.zOz.zNx + ", meidiaId:" + paramString2 + ", isVideoPause:" + this.zOz.zNw);
        if ((d.n.n.I(paramString1, this.zOz.zNx, false)) && (this.zOz.zNw))
        {
          paramString1 = this.zOz.zOs;
          if (paramString1 == null) {
            break;
          }
          if (!paramString1.zOi) {
            this.zOz.v(null);
          }
        }
        AppMethodBeat.o(120649);
        return;
      }
      AppMethodBeat.o(120649);
    }
    
    public final void eJ(String paramString1, String paramString2)
    {
      AppMethodBeat.i(192934);
      ac.i(this.zOz.TAG, "onVideoFirstFrameDraw: " + paramString1 + ", meidiaId:" + paramString2);
      AppMethodBeat.o(192934);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.n
 * JD-Core Version:    0.7.0.1
 */