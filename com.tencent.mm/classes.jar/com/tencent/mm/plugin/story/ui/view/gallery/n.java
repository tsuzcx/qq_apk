package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.g.b.a.fr;
import com.tencent.mm.g.b.a.fy;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.g.b.q;
import d.v;
import d.z;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "", "()V", "STORY_VIDEO_VIEW_IDKEY_STAT", "", "TAG", "", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "currentSessionId", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "onlineVideoEventListener", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1;", "proxy", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayProxy;", "showLoadingTime", "", "videoView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView;", "videoViewCallback", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "checkPauseOnProgress", "getPlayStatus", "getVideoView", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "newVideoViewInstance", "onUIDestroy", "onUIPause", "onUIResume", "pauseVideo", "playVideo", "resetVideo", "sameParent", "setMute", "setNeedShowLoading", "show", "setVideoViewProp", "stopTask", "stopVideo", "detach", "VideoPlayCdnCallback", "VideoPlayProxy", "plugin-story_release"})
public final class n
{
  boolean BeX;
  String BeY;
  private boolean BeZ;
  StoryVideoView BfT;
  b BfU;
  final long BfV;
  int BfW;
  private final d BfX;
  private final e BfY;
  com.tencent.mm.plugin.story.f.d.j Bfa;
  boolean Bfb;
  private com.tencent.mm.compatible.util.b Bfc;
  private boolean Bfd;
  final String TAG;
  private boolean fMP;
  
  public n()
  {
    AppMethodBeat.i(120664);
    this.TAG = "MicroMsg.Gallery.StoryVideoViewMgr";
    this.Bfc = new com.tencent.mm.compatible.util.b(aj.getContext());
    this.BfV = 987L;
    this.BfX = new d(this);
    ad.i(this.TAG, "init create StoryVideoViewMgr " + hashCode());
    com.tencent.mm.sdk.b.a.IbL.c((com.tencent.mm.sdk.b.c)this.BfX);
    this.BfY = new e(this);
    AppMethodBeat.o(120664);
  }
  
  private final boolean g(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    Object localObject2 = null;
    AppMethodBeat.i(120651);
    Object localObject3;
    if (paramj.dJd != 0)
    {
      localObject1 = this.Bfa;
      if ((localObject1 != null) && (((com.tencent.mm.plugin.story.f.d.j)localObject1).dJd == paramj.dJd))
      {
        localObject3 = paramj.AMJ;
        localObject1 = this.Bfa;
        if (localObject1 != null) {}
        for (localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).AMJ; localObject3 == localObject1; localObject1 = null)
        {
          AppMethodBeat.o(120651);
          return true;
        }
      }
    }
    Object localObject1 = (CharSequence)paramj.AMK.Url;
    int i;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label187;
      }
      localObject1 = this.Bfa;
      if (localObject1 == null) {
        break label182;
      }
      localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).AMK;
      if (localObject1 == null) {
        break label182;
      }
    }
    label182:
    for (localObject1 = ((djl)localObject1).Url;; localObject1 = null)
    {
      if (!p.i(localObject1, paramj.AMK.Url)) {
        break label187;
      }
      localObject1 = paramj.AMJ;
      localObject3 = this.Bfa;
      paramj = localObject2;
      if (localObject3 != null) {
        paramj = ((com.tencent.mm.plugin.story.f.d.j)localObject3).AMJ;
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
    Object localObject = this.BfT;
    if (localObject != null) {}
    for (localObject = ((StoryVideoView)localObject).getParent();; localObject = null)
    {
      boolean bool = p.i(localObject, paramViewGroup);
      AppMethodBeat.o(120663);
      return bool;
    }
  }
  
  public final void FQ()
  {
    AppMethodBeat.i(120653);
    ad.m(this.TAG, "playVideo, " + this.BeX + ' ' + this.Bfb + ", " + this.Bfa, new Object[0]);
    eml();
    this.Bfb = true;
    Object localObject1 = this.Bfa;
    if (localObject1 != null)
    {
      boolean bool = this.BeX;
      this.BeX = false;
      if (!bool) {
        break label182;
      }
      localObject2 = this.BfT;
      if (localObject2 != null) {
        ((StoryVideoView)localObject2).o((com.tencent.mm.plugin.story.f.d.j)localObject1);
      }
      this.BeX = false;
      if (((com.tencent.mm.plugin.story.f.d.j)localObject1).eiN()) {
        this.BeZ = true;
      }
      if (!this.Bfd)
      {
        this.Bfc.requestFocus();
        this.Bfd = true;
      }
    }
    localObject1 = com.tencent.mm.plugin.story.h.h.ASt;
    Object localObject2 = com.tencent.mm.plugin.story.h.h.ejZ();
    localObject1 = this.BfT;
    if (localObject1 != null) {}
    for (localObject1 = ((StoryVideoView)localObject1).getContext();; localObject1 = null)
    {
      ((fy)localObject2).kX(ay.iS((Context)localObject1));
      AppMethodBeat.o(120653);
      return;
      label182:
      this.BeY = UUID.randomUUID().toString();
      localObject2 = this.BfU;
      if (localObject2 != null) {
        ((b)localObject2).p((com.tencent.mm.plugin.story.f.d.j)localObject1);
      }
      localObject2 = this.BfT;
      if (localObject2 == null) {
        break;
      }
      ((StoryVideoView)localObject2).a((com.tencent.mm.plugin.story.f.d.j)localObject1, this.BeY);
      break;
    }
  }
  
  public final void a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(120650);
    p.h(paramViewGroup, "parent");
    this.BfW = 0;
    boolean bool = z(paramViewGroup);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("attachVideoView, parent:").append(paramViewGroup.hashCode()).append(", isVideoPause:").append(this.BeX).append(", currentSessionId:").append(this.BeY).append(", isPlayingVideoItem:").append(this.BeZ).append(" videoView ");
    Object localObject = this.BfT;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((StoryVideoView)localObject).hashCode());; localObject = null)
    {
      ad.m(str, localObject + " sameParent " + bool + " this:" + hashCode(), new Object[0]);
      y(paramViewGroup);
      if (this.BfT == null)
      {
        localObject = aj.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        gw((Context)localObject);
      }
      if (bool) {
        break label239;
      }
      if (paramLayoutParams != null) {
        break;
      }
      paramViewGroup.addView((View)this.BfT);
      AppMethodBeat.o(120650);
      return;
    }
    paramViewGroup.addView((View)this.BfT, paramLayoutParams);
    AppMethodBeat.o(120650);
    return;
    label239:
    if (paramLayoutParams != null)
    {
      paramViewGroup = this.BfT;
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
      ad.m(this.TAG, "change:" + bool + ' ' + this.Bfb + ", " + paramBoolean + ", changeVideoItem: origin: " + this.Bfa + ", new: " + paramj + ",  change:" + bool + " this:" + hashCode(), new Object[0]);
      if (bool)
      {
        this.Bfa = paramj;
        if ((this.Bfb) || (paramBoolean))
        {
          a(this, false, 2);
          FQ();
        }
      }
      AppMethodBeat.o(120652);
      return;
    }
  }
  
  public final void ap(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(120655);
    ad.m(this.TAG, "stopVideo, detach: ".concat(String.valueOf(paramBoolean1)), new Object[0]);
    Object localObject;
    if (this.BeZ)
    {
      this.BeY = null;
      localObject = this.BfT;
      if (localObject != null) {
        ((StoryVideoView)localObject).stop();
      }
      this.BeX = false;
      if (this.Bfd)
      {
        this.Bfc.abe();
        this.Bfd = false;
      }
      this.BeZ = false;
    }
    if (paramBoolean1)
    {
      this.Bfb = false;
      y(null);
      localObject = com.tencent.mm.plugin.story.h.h.ASt;
      com.tencent.mm.plugin.story.h.h.ejZ().lb(System.currentTimeMillis());
      if (paramBoolean2)
      {
        localObject = com.tencent.mm.plugin.story.h.h.ASt;
        com.tencent.mm.plugin.story.h.h.eka();
      }
    }
    AppMethodBeat.o(120655);
  }
  
  final void eml()
  {
    AppMethodBeat.i(120654);
    ad.i(this.TAG, "setVideoViewProp, isMute:" + this.fMP);
    StoryVideoView localStoryVideoView = this.BfT;
    if (localStoryVideoView != null)
    {
      localStoryVideoView.setMute(this.fMP);
      AppMethodBeat.o(120654);
      return;
    }
    AppMethodBeat.o(120654);
  }
  
  final void gw(Context paramContext)
  {
    AppMethodBeat.i(120661);
    this.BfT = new StoryVideoView(paramContext);
    this.BfU = new b();
    paramContext = this.BfT;
    if (paramContext != null) {
      paramContext.setIOnlineVideoProxy((com.tencent.mm.modelvideo.b)this.BfU);
    }
    paramContext = this.BfT;
    if (paramContext != null) {
      paramContext.setIMMVideoViewCallback((i.b)this.BfY);
    }
    paramContext = this.BfT;
    if (paramContext != null) {
      paramContext.setReporter((i.c)new c(this));
    }
    this.BeZ = false;
    AppMethodBeat.o(120661);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(120660);
    ad.i(this.TAG, "onUIDestroy " + hashCode());
    this.Bfb = false;
    y(null);
    this.Bfa = null;
    this.BfT = null;
    if (this.Bfd)
    {
      this.Bfc.abe();
      this.Bfd = false;
    }
    com.tencent.mm.sdk.b.a.IbL.d((com.tencent.mm.sdk.b.c)this.BfX);
    AppMethodBeat.o(120660);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(120659);
    ad.i(this.TAG, "onUIPause " + hashCode());
    y(null);
    if (this.Bfd)
    {
      this.Bfc.abe();
      this.Bfd = false;
    }
    AppMethodBeat.o(120659);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(120658);
    StoryVideoView localStoryVideoView = this.BfT;
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
    ad.i(this.TAG, "setMute " + paramBoolean + " ret " + "");
    this.fMP = paramBoolean;
    AppMethodBeat.o(120657);
  }
  
  final void y(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120662);
    String str = this.TAG;
    Object localObject1 = new StringBuilder("checkDetachVideoView, videoView:");
    Object localObject2 = this.BfT;
    int i;
    boolean bool;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", isPlay:");
      localObject2 = this.BfT;
      if (localObject2 == null) {
        break label248;
      }
      bool = ((StoryVideoView)localObject2).isPlaying();
      label72:
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", parent:");
      localObject1 = this.BfT;
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
      ad.m(str, i + ", isPlayingVideoItem:" + this.BeZ, new Object[0]);
      localObject1 = this.BfT;
      if (localObject1 == null) {
        break label269;
      }
      localObject1 = ((StoryVideoView)localObject1).getParent();
      label187:
      if ((localObject1 == null) || (z(paramViewGroup))) {
        break label299;
      }
      a(this, true, 1);
      paramViewGroup = this.BfT;
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
    ((ViewGroup)paramViewGroup).removeView((View)this.BfT);
    this.Bfa = null;
    label299:
    AppMethodBeat.o(120662);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayCdnCallback;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;)V", "TAG", "", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "isMoovReady", "", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "videoCache", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "onDataAvailable", "", "mediaId", "offset", "", "length", "onFinish", "ret", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onMoovReady", "svrflag", "onProgress", "total", "setIEngineCallback", "callback", "setVideoCache", "vitem", "plugin-story_release"})
  final class a
    implements h.a
  {
    com.tencent.mm.plugin.story.f.d.j BfG;
    com.tencent.mm.plugin.story.i.n BfZ;
    final String TAG = "MicroMsg.VideoPlayProxy";
    com.tencent.mm.modelvideo.b.a pzN;
    volatile boolean skP;
    
    public final void a(com.tencent.mm.plugin.story.i.n paramn, com.tencent.mm.plugin.story.f.d.j paramj)
    {
      this.BfZ = paramn;
      this.BfG = paramj;
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
        localObject1 = this.Bga.Bfa;
        if (localObject1 == null) {
          break label553;
        }
        localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).username;
        ad.i((String)localObject3, (String)localObject1);
        localObject1 = this.BfG;
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.plugin.story.h.b.ARx;
          com.tencent.mm.plugin.story.h.b.AL(((com.tencent.mm.plugin.story.f.d.j)localObject1).dKt);
          m.Bfs.Bb(((com.tencent.mm.plugin.story.f.d.j)localObject1).dKt);
        }
        localObject1 = this.BfZ;
        if (localObject1 == null) {
          break label559;
        }
        localObject1 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath;
        label174:
        localObject1 = com.tencent.mm.plugin.sight.base.e.axx((String)localObject1);
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.plugin.story.h.h.ASt;
          com.tencent.mm.plugin.story.h.h.ekn().kD(((com.tencent.mm.plugin.sight.base.a)localObject1).videoDuration);
          localObject3 = com.tencent.mm.plugin.story.h.h.ASt;
          com.tencent.mm.plugin.story.h.h.ekn().kE(((com.tencent.mm.plugin.sight.base.a)localObject1).videoBitrate);
          localObject3 = com.tencent.mm.plugin.story.h.h.ASt;
          com.tencent.mm.plugin.story.h.h.ekn().kF(((com.tencent.mm.plugin.sight.base.a)localObject1).audioBitrate);
          localObject3 = com.tencent.mm.plugin.story.h.h.ASt;
          com.tencent.mm.plugin.story.h.h.ekn().kG(((com.tencent.mm.plugin.sight.base.a)localObject1).frameRate);
          localObject3 = com.tencent.mm.plugin.story.h.h.ASt;
          com.tencent.mm.plugin.story.h.h.ekn().kH(((com.tencent.mm.plugin.sight.base.a)localObject1).width);
          localObject3 = com.tencent.mm.plugin.story.h.h.ASt;
          com.tencent.mm.plugin.story.h.h.ekn().kI(((com.tencent.mm.plugin.sight.base.a)localObject1).height);
          localObject3 = com.tencent.mm.plugin.story.h.h.ASt;
          com.tencent.mm.plugin.story.h.h.ekn().kJ(((com.tencent.mm.plugin.sight.base.a)localObject1).audioChannel);
        }
        localObject1 = com.tencent.mm.plugin.story.h.h.ASt;
        localObject1 = com.tencent.mm.plugin.story.h.h.ekn();
        if (this.BfZ == null) {
          break label565;
        }
        localObject3 = this.BfZ;
        if (localObject3 == null) {
          p.gfZ();
        }
        l = ((com.tencent.mm.plugin.story.i.n)localObject3).field_totalSize;
        label351:
        ((fr)localObject1).kC(l);
        localObject1 = com.tencent.mm.plugin.story.h.h.ASt;
        localObject3 = com.tencent.mm.plugin.story.h.h.ekn();
        localObject1 = this.BfZ;
        if (localObject1 == null) {
          break label571;
        }
        localObject1 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_url;
        label387:
        ((fr)localObject3).oG((String)localObject1);
        localObject1 = com.tencent.mm.plugin.story.h.h.ASt;
        localObject3 = com.tencent.mm.plugin.story.h.h.ekn();
        f.aGJ();
        localObject1 = this.BfZ;
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
        ((fr)localObject3).oH(com.tencent.mm.ao.a.EL((String)localObject1));
        if (paramd != null)
        {
          localObject1 = com.tencent.mm.plugin.story.h.h.ASt;
          com.tencent.mm.plugin.story.h.h.ekn().kA(paramd.field_startTime);
          localObject1 = com.tencent.mm.plugin.story.h.h.ASt;
          com.tencent.mm.plugin.story.h.h.ekn().kB(paramd.field_endTime);
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
      paramd = com.tencent.mm.plugin.story.h.h.ASt;
      com.tencent.mm.plugin.story.h.h.ekn().oI(((StringBuffer)localObject1).toString());
      label599:
      if (this.Bga.BfU != null)
      {
        paramd = com.tencent.mm.plugin.story.h.h.ASt;
        paramd = com.tencent.mm.plugin.story.h.h.ekn();
        localObject1 = this.Bga.BfU;
        if (localObject1 == null) {
          p.gfZ();
        }
        paramd.kK(((n.b)localObject1).dyZ);
        paramd = com.tencent.mm.plugin.story.h.h.ASt;
        paramd = com.tencent.mm.plugin.story.h.h.ekn();
        localObject1 = this.Bga.BfU;
        if (localObject1 == null) {
          p.gfZ();
        }
        if (!((n.b)localObject1).BfF) {
          break label719;
        }
        l = 3L;
      }
      for (;;)
      {
        paramd.kL(l);
        paramd = com.tencent.mm.plugin.story.h.h.ASt;
        com.tencent.mm.plugin.story.h.h.eko();
        com.tencent.mm.ad.c.g((d.g.a.a)new b(this, paramString, paramInt));
        AppMethodBeat.o(120632);
        return;
        label719:
        localObject1 = this.Bga.BfU;
        if (localObject1 == null) {
          p.gfZ();
        }
        if (((n.b)localObject1).dyZ > 0) {
          l = 2L;
        } else {
          l = 1L;
        }
      }
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(189786);
      p.h(paramString1, "mediaId");
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onMoovReady, mediaId:").append(paramString1).append(", offset:").append(paramLong1).append(", length:").append(paramLong2).append(", isMoovReady:").append(this.skP).append(" this:").append(this).append(" currVideoItem:");
      Object localObject = this.Bga.Bfa;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.story.f.d.j)localObject).username;; localObject = null)
      {
        ad.i(str, (String)localObject);
        if (!this.skP) {
          break;
        }
        AppMethodBeat.o(189786);
        return;
      }
      this.skP = true;
      com.tencent.mm.ad.c.g((d.g.a.a)new c(this, paramString1, paramLong1, paramLong2, paramString2));
      AppMethodBeat.o(189786);
    }
    
    public final void i(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(120631);
      p.h(paramString, "mediaId");
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onProgress, mediaId:").append(paramString).append(", offset:").append(paramLong1).append(", total:").append(paramLong2).append(" this:").append(this).append(" currVideoItem:");
      Object localObject = this.Bga.Bfa;
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
      p.h(paramString, "mediaId");
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onDataAvailable, mediaId:").append(paramString).append(", offset:").append(paramLong1).append(", length:").append(paramLong2).append(" this:").append(this).append(" currVideoItem:");
      Object localObject = this.Bga.Bfa;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.story.f.d.j)localObject).username;; localObject = null)
      {
        ad.i(str, (String)localObject);
        com.tencent.mm.ad.c.g((d.g.a.a)new a(this, paramString, paramLong1, paramLong2));
        AppMethodBeat.o(120630);
        return;
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(n.a parama, String paramString, long paramLong1, long paramLong2)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<z>
    {
      b(n.a parama, String paramString, int paramInt)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements d.g.a.a<z>
    {
      c(n.a parama, String paramString1, long paramLong1, long paramLong2, String paramString2)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayProxy;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;)V", "TAG", "", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "preloadFinish", "", "getPreloadFinish", "()Z", "setPreloadFinish", "(Z)V", "preloadSize", "", "getPreloadSize", "()I", "setPreloadSize", "(I)V", "videoCache", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "createReportRptTips", "", "", "()[Ljava/lang/Object;", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "url", "path", "callback", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayCdnCallback;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "isVideoDataAvailable", "offset", "length", "requestVideoData", "", "setIEngineCallback", "setStoryVideoItem", "startHttpStream", "stop", "plugin-story_release"})
  final class b
    implements com.tencent.mm.modelvideo.b
  {
    boolean BfF;
    com.tencent.mm.plugin.story.f.d.j BfG;
    com.tencent.mm.plugin.story.i.n BfZ;
    final String TAG = "MicroMsg.VideoPlayProxy";
    int dyZ;
    private com.tencent.mm.modelvideo.b.a pzN;
    
    public final void a(com.tencent.mm.modelvideo.b.a parama)
    {
      this.pzN = parama;
    }
    
    public final void gj(String paramString)
    {
      int k = 2;
      int j = 1;
      com.tencent.mm.plugin.story.f.d.j localj = null;
      AppMethodBeat.i(120636);
      p.h(paramString, "mediaId");
      ad.i(this.TAG, "this: " + this + " stop " + paramString + ' ' + bt.flS());
      Object[] arrayOfObject = new Object[17];
      Object localObject1 = this.Bga.BfT;
      label124:
      int i;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).getCurrPosMs());
        arrayOfObject[0] = localObject1;
        localObject1 = this.Bga.BfT;
        if (localObject1 == null) {
          break label588;
        }
        localObject1 = Integer.valueOf((int)((StoryVideoView)localObject1).getFirstPlayWaitTime());
        arrayOfObject[1] = localObject1;
        localObject1 = this.Bga.BfT;
        if (localObject1 == null) {
          break label594;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).emz());
        label154:
        arrayOfObject[2] = localObject1;
        localObject1 = this.Bga.BfT;
        if (localObject1 == null) {
          break label600;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).emA());
        label184:
        arrayOfObject[3] = localObject1;
        localObject1 = this.Bga.BfT;
        if (localObject1 == null) {
          break label606;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).emB());
        label214:
        arrayOfObject[4] = localObject1;
        localObject1 = this.Bga.BfT;
        if (localObject1 == null) {
          break label612;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).getStayTime());
        label244:
        arrayOfObject[5] = localObject1;
        localObject1 = this.Bga.BfT;
        if (localObject1 == null) {
          break label618;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).getErrorCode());
        label274:
        arrayOfObject[6] = localObject1;
        arrayOfObject[7] = Integer.valueOf(this.dyZ);
        if (this.dyZ <= 0) {
          break label624;
        }
        i = 2;
        label302:
        arrayOfObject[8] = Integer.valueOf(i);
        i = k;
        if (this.BfF) {
          i = 3;
        }
        arrayOfObject[9] = Integer.valueOf(i);
        localObject1 = com.tencent.mm.plugin.story.e.b.AJd;
        localObject1 = this.Bga.BfT;
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
        arrayOfObject[10] = com.tencent.mm.plugin.story.e.b.a.aBz((String)localObject1);
        Object localObject2 = this.BfG;
        localObject1 = localj;
        if (localObject2 != null) {
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject2).dKt);
        }
        arrayOfObject[11] = localObject1;
        localObject1 = com.tencent.mm.plugin.story.h.h.ASt;
        arrayOfObject[12] = Long.valueOf(com.tencent.mm.plugin.story.h.h.ejZ().TB());
        localObject1 = com.tencent.mm.plugin.story.h.h.ASt;
        arrayOfObject[13] = Long.valueOf(com.tencent.mm.plugin.story.h.h.ejZ().TD());
        localObject1 = com.tencent.mm.plugin.story.h.h.ASt;
        if (com.tencent.mm.plugin.story.h.h.ejZ().TG() != 1L) {
          break label629;
        }
        i = j;
        label469:
        arrayOfObject[14] = Integer.valueOf(i);
        localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
        localObject1 = j.b.ehT();
        localj = this.BfG;
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
      for (long l = localj.dKt;; l = 0L)
      {
        arrayOfObject[15] = Integer.valueOf(((com.tencent.mm.plugin.story.i.k)localObject1).AY(l));
        arrayOfObject[16] = Integer.valueOf(this.Bga.BfW);
        ad.i(this.TAG, "reportTips: " + Arrays.toString(arrayOfObject));
        com.tencent.mm.modelvideo.o.aMK().l(paramString, arrayOfObject);
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
      Object localObject1 = this.BfG;
      if (localObject1 != null)
      {
        localObject2 = s.ALd;
        this.BfZ = s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
        localObject1 = this.BfZ;
        if ((localObject1 != null) && (((com.tencent.mm.plugin.story.i.n)localObject1).XQ() == true))
        {
          str2 = this.TAG;
          localObject1 = new StringBuilder("isVideoDataAvailable ").append(paramString).append(", ").append(paramInt1).append(", ").append(paramInt2).append(", download finish cacheSize:");
          localObject2 = this.BfZ;
          paramString = str1;
          if (localObject2 != null) {
            paramString = Integer.valueOf(((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize);
          }
          ad.i(str2, paramString + " this:" + this);
          AppMethodBeat.o(120638);
          return true;
        }
      }
      boolean bool = com.tencent.mm.modelvideo.o.aMK().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      str1 = this.TAG;
      localObject1 = new StringBuilder("isVideoDataAvailable ").append(paramString).append(", ").append(paramInt1).append(", ").append(paramInt2).append(", available:").append(bool).append(" cacheSize:");
      Object localObject2 = this.BfZ;
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
      p.h(paramj, "item");
      this.BfG = paramj;
      s locals = s.ALd;
      this.BfZ = s.a(paramj);
      ad.i(this.TAG, "setStoryVideoItem " + paramj + " videoCache " + this.BfZ);
      AppMethodBeat.o(120634);
    }
    
    public final void p(String paramString1, String paramString2, String paramString3)
    {
      int i = 0;
      Object localObject2 = null;
      AppMethodBeat.i(120635);
      ad.i(this.TAG, "startHttpStream " + paramString1 + ' ' + paramString2 + ' ' + paramString3 + " this:" + this);
      Object localObject1;
      Object localObject3;
      Object localObject4;
      boolean bool;
      if (this.BfG != null)
      {
        localObject1 = s.ALd;
        localObject1 = this.BfG;
        if (localObject1 == null) {
          p.gfZ();
        }
        this.BfZ = s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
        localObject1 = this.BfZ;
        if ((localObject1 != null) && (!i.fv(((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath)))
        {
          localObject3 = com.tencent.mm.plugin.story.f.l.AKo;
          localObject3 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath;
          p.g(localObject3, "it.field_filePath");
          com.tencent.mm.plugin.story.f.l.aBI((String)localObject3);
          ad.i(this.TAG, "startHttpStream error downloadFinish " + ((com.tencent.mm.plugin.story.i.n)localObject1).XQ() + " ret:" + i.fv(((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath) + " path:" + ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath);
          ((com.tencent.mm.plugin.story.i.n)localObject1).elI();
          localObject3 = com.tencent.mm.plugin.story.f.j.AKb;
          j.b.ehX().b((com.tencent.mm.plugin.story.i.n)localObject1);
        }
        localObject1 = this.Bga.Bfa;
        long l;
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.plugin.story.h.c.ARR;
          com.tencent.mm.plugin.story.h.c.ejJ();
          localObject3 = com.tencent.mm.plugin.story.h.b.ARx;
          l = ((com.tencent.mm.plugin.story.f.d.j)localObject1).dKt;
          if (com.tencent.mm.plugin.story.h.b.aKi())
          {
            ad.v("MicroMsg.StoryBrowseDetailIDKeyStat", "startHttp storyId ".concat(String.valueOf(l)));
            if (com.tencent.mm.plugin.story.h.b.ARj.containsKey(Long.valueOf(l)))
            {
              localObject1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.ARj.get(Long.valueOf(l));
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.story.h.b.a)localObject1).ARB = true;
              }
            }
          }
        }
        localObject1 = this.BfG;
        if (localObject1 == null) {
          break label888;
        }
        localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).AMK;
        if (localObject1 == null) {
          break label888;
        }
        localObject1 = ((djl)localObject1).Url;
        if (!bt.isNullOrNil((String)localObject1))
        {
          localObject1 = this.Bga;
          ((n)localObject1).BfW += 1;
          localObject1 = ((n)localObject1).BfT;
          if (localObject1 != null) {
            ((StoryVideoView)localObject1).setNeedShowLoading(true);
          }
          localObject1 = new n.a(this.Bga);
          ((n.a)localObject1).pzN = this.pzN;
          ((n.a)localObject1).a(this.BfZ, this.BfG);
          localObject3 = new com.tencent.mm.i.h();
          ((com.tencent.mm.i.h)localObject3).fJi = "task_StoryVideoViewMgr";
          localObject4 = new n.a(this.Bga);
          ((n.a)localObject4).pzN = this.pzN;
          ((n.a)localObject4).a(this.BfZ, this.BfG);
          ((com.tencent.mm.i.h)localObject3).field_mediaId = paramString1;
          ((com.tencent.mm.i.h)localObject3).url = paramString3;
          ((com.tencent.mm.i.h)localObject3).fJF = 1;
          ((com.tencent.mm.i.h)localObject3).fJA = 6;
          ((com.tencent.mm.i.h)localObject3).concurrentCount = 4;
          ((com.tencent.mm.i.h)localObject3).field_fullpath = paramString2;
          ((com.tencent.mm.i.h)localObject3).fJN = ((h.a)localObject1);
          ((com.tencent.mm.i.h)localObject3).field_fileType = com.tencent.mm.i.a.fIF;
          ((com.tencent.mm.i.h)localObject3).field_requestVideoFormat = com.tencent.mm.modelcontrol.d.I(1, paramString2);
          paramString2 = m.Bfs;
          paramString2 = this.BfG;
          if (paramString2 == null) {
            p.gfZ();
          }
          m.j(paramString2);
          paramString2 = this.Bga.Bfa;
          if (paramString2 != null)
          {
            paramString3 = com.tencent.mm.plugin.story.h.b.ARx;
            l = paramString2.dKt;
            if (this.BfZ != null)
            {
              paramString2 = this.BfZ;
              if ((paramString2 == null) || (paramString2.field_cacheSize != 0)) {
                break label894;
              }
            }
            bool = true;
            label620:
            com.tencent.mm.plugin.story.h.b.F(l, bool);
          }
          com.tencent.mm.modelvideo.o.aMK().a((com.tencent.mm.i.h)localObject3);
          if ((this.BfG != null) && (paramString1 != null))
          {
            paramString2 = m.Bfs;
            paramString2 = this.BfG;
            if (paramString2 == null) {
              p.gfZ();
            }
            paramString3 = m.k(paramString2);
            if ((paramString3.skP) && (!((n.a)localObject1).skP))
            {
              localObject3 = this.TAG;
              localObject4 = new StringBuilder("checkPreloadOnVideoPlay ").append(paramString1).append(", moovReady, offset:").append(paramString3.offset).append(", length:").append(paramString3.length).append(", cacheSize:");
              paramString2 = this.BfZ;
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
        com.tencent.mm.plugin.story.i.n localn = this.BfZ;
        paramString2 = localObject2;
        if (localn != null) {
          paramString2 = Integer.valueOf(localn.field_totalSize);
        }
        ad.i((String)localObject3, paramString2 + ", preloadFinish:" + paramString3.BfF);
        if ((paramString3.offset > 0L) && (paramString3.length > 0L))
        {
          ((n.a)localObject1).a(paramString1, paramString3.offset, paramString3.length, "");
          paramString1 = this.BfZ;
          if (paramString1 != null) {
            i = paramString1.field_cacheSize;
          }
          this.dyZ = i;
          this.BfF = paramString3.BfF;
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
      com.tencent.mm.ad.c.g((d.g.a.a)new a(this, paramString, paramInt1, paramInt2));
      AppMethodBeat.o(120637);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$initCreateVideoView$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IReport;", "idkeyStat", "", "ID", "", "key", "value", "isImportant", "", "kvStat", "logID", "", "val", "", "plugin-story_release"})
  public static final class c
    implements i.c
  {
    public final void qQ(long paramLong)
    {
      AppMethodBeat.i(120639);
      StoryVideoView localStoryVideoView = this.Bga.BfT;
      if (localStoryVideoView != null)
      {
        if (!localStoryVideoView.BfJ)
        {
          g.yhR.idkeyStat(this.Bga.BfV, paramLong, 1L, false);
          if ((paramLong >= 141L) && (paramLong <= 145L)) {
            ad.i(this.Bga.TAG, "initCreateVideoView test key " + paramLong + " value 1 currVideoItem:" + this.Bga.Bfa + ' ' + bt.flS());
          }
        }
        AppMethodBeat.o(120639);
        return;
      }
      AppMethodBeat.o(120639);
    }
    
    public final void vk(String paramString) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/OnlineVideoEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<nx>
  {
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(n.d paramd, nx paramnx)
      {
        super();
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-story_release"})
  public static final class e
    implements i.b
  {
    public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120642);
      ad.i(this.Bga.TAG, "videoViewCallback onError: " + paramString1 + ", meidiaId:" + paramString2 + ", errorMsg:" + paramString3 + ", what:" + paramInt1 + ", extra:" + paramInt2);
      AppMethodBeat.o(120642);
    }
    
    public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120645);
      ad.i(this.Bga.TAG, "videoViewCallback onGetVideoSize: " + paramString1 + ", " + this.Bga.BeY + ", meidiaId:" + paramString2);
      AppMethodBeat.o(120645);
    }
    
    public final void dq(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120643);
      ad.i(this.Bga.TAG, "videoViewCallback onPrepared: " + paramString1 + ", meidiaId:" + paramString2);
      AppMethodBeat.o(120643);
    }
    
    public final void dr(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120644);
      ad.i(this.Bga.TAG, "videoViewCallback onVideoEnded: " + paramString1 + ", meidiaId:" + paramString2);
      paramString1 = com.tencent.mm.plugin.story.h.h.ASt;
      paramString1 = com.tencent.mm.plugin.story.h.h.ejZ();
      paramString1.li(paramString1.TK() + 1L);
      paramString1 = this.Bga.Bfa;
      if (paramString1 != null)
      {
        paramString2 = com.tencent.mm.plugin.story.h.b.ARx;
        long l = paramString1.dKt;
        if (com.tencent.mm.plugin.story.h.b.aKi())
        {
          ad.v("MicroMsg.StoryBrowseDetailIDKeyStat", "onVideoEnd ".concat(String.valueOf(l)));
          if (com.tencent.mm.plugin.story.h.b.ARj.containsKey(Long.valueOf(l)))
          {
            paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.ARj.get(Long.valueOf(l));
            if (paramString1 != null)
            {
              paramString1.hhJ = true;
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
    
    public final void ds(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120646);
      ad.i(this.Bga.TAG, "videoViewCallback onVideoPause: " + paramString1 + ", meidiaId:" + paramString2);
      AppMethodBeat.o(120646);
    }
    
    public final void dt(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120647);
      String str = this.Bga.TAG;
      StringBuilder localStringBuilder = new StringBuilder("videoViewCallback onVideoPlay: ").append(paramString1).append(' ');
      Object localObject = this.Bga.BfT;
      long l1;
      label280:
      long l2;
      if (localObject != null)
      {
        localObject = ((StoryVideoView)localObject).getSessionId();
        ad.i(str, (String)localObject + ", " + this.Bga.BeY + ", meidiaId:" + paramString2 + ", isVideoPause:" + this.Bga.BeX);
        if ((d.n.n.H(paramString1, this.Bga.BeY, false)) && (this.Bga.BeX))
        {
          paramString1 = this.Bga.BfT;
          if ((paramString1 != null) && (!paramString1.BfJ)) {
            this.Bga.y(null);
          }
        }
        paramString2 = this.Bga.Bfa;
        if (paramString2 == null) {
          break label952;
        }
        paramString1 = com.tencent.mm.plugin.story.h.c.ARR;
        com.tencent.mm.plugin.story.h.c.AN(paramString2.dKt);
        paramString1 = com.tencent.mm.plugin.story.h.b.ARx;
        l1 = paramString2.dKt;
        if (com.tencent.mm.plugin.story.h.b.aKi())
        {
          localObject = new StringBuilder("onVideoPlay storyId ").append(l1).append(" lastStoryId ").append(com.tencent.mm.plugin.story.h.b.ARi).append(" contains:").append(com.tencent.mm.plugin.story.h.b.ARj.containsKey(Long.valueOf(l1))).append(" result");
          paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.ARj.get(Long.valueOf(l1));
          if (paramString1 == null) {
            break label458;
          }
          paramString1 = Long.valueOf(paramString1.ARA);
          ad.v("MicroMsg.StoryBrowseDetailIDKeyStat", paramString1);
          if ((l1 == com.tencent.mm.plugin.story.h.b.ARi) && (com.tencent.mm.plugin.story.h.b.ARj.containsKey(Long.valueOf(l1))))
          {
            paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.ARj.get(Long.valueOf(l1));
            if ((paramString1 != null) && (!paramString1.zVg) && (paramString1.ARA <= 0L) && (paramString1.ARz > 0L))
            {
              paramString1.isWaiting = false;
              l2 = bt.Df(paramString1.ARz);
              paramString1.ARA = bt.flT();
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
        m.Bfs.Ba(paramString2.dKt);
        paramString1 = com.tencent.mm.plugin.story.f.k.AKk;
        com.tencent.mm.plugin.story.f.k.aBC(paramString2.username);
        AppMethodBeat.o(120647);
        return;
        localObject = null;
        break;
        label458:
        paramString1 = null;
        break label280;
        label463:
        ad.i("MicroMsg.StoryBrowseDetailIDKeyStat", "onPlayCostTime  storyId " + l1 + " onPlayCostTime:" + l2);
        com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 31L, l2);
        com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 30L, 1L);
        if (l2 <= 400L)
        {
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 90L, 1L);
          label536:
          if (l2 > 400L) {
            break label719;
          }
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 50L, 1L);
          label555:
          if (l1 != com.tencent.mm.plugin.story.h.b.ARl) {
            break label840;
          }
          if (!com.tencent.mm.plugin.story.h.b.ARp) {
            break label842;
          }
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 40L, 1L);
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 42L, l2);
        }
        for (;;)
        {
          if (l2 <= 1000L)
          {
            if (com.tencent.mm.plugin.story.h.b.ARp)
            {
              com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 44L, 1L);
              break;
              if (l2 <= 800L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 91L, 1L);
                break label536;
              }
              if (l2 <= 1600L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 92L, 1L);
                break label536;
              }
              if (l2 <= 3200L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 93L, 1L);
                break label536;
              }
              if (l2 <= 5000L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 94L, 1L);
                break label536;
              }
              com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 95L, 1L);
              break label536;
              label719:
              if (l2 <= 800L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 51L, 1L);
                break label555;
              }
              if (l2 <= 1000L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 52L, 1L);
                break label555;
              }
              if (l2 <= 2000L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 53L, 1L);
                break label555;
              }
              if (l2 <= 3000L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 54L, 1L);
                break label555;
              }
              if (l2 <= 4000L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 55L, 1L);
                break label555;
              }
              com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 56L, 1L);
              break label555;
              label840:
              break;
              label842:
              com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 41L, 1L);
              com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 43L, l2);
              continue;
            }
            com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 45L, 1L);
            break;
          }
        }
        if (l2 <= 2000L)
        {
          if (com.tencent.mm.plugin.story.h.b.ARp) {
            com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 46L, 1L);
          } else {
            com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 47L, 1L);
          }
        }
        else if (com.tencent.mm.plugin.story.h.b.ARp) {
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 48L, 1L);
        } else {
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 49L, 1L);
        }
      }
      label952:
      AppMethodBeat.o(120647);
    }
    
    public final void du(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120648);
      ad.i(this.Bga.TAG, "videoViewCallback onVideoWaiting: " + paramString1 + ", meidiaId:" + paramString2);
      paramString1 = this.Bga.Bfa;
      if (paramString1 != null)
      {
        paramString2 = com.tencent.mm.plugin.story.h.c.ARR;
        com.tencent.mm.plugin.story.h.c.AM(paramString1.dKt);
        paramString2 = com.tencent.mm.plugin.story.h.b.ARx;
        long l = paramString1.dKt;
        if ((com.tencent.mm.plugin.story.h.b.aKi()) && (com.tencent.mm.plugin.story.h.b.ARj.containsKey(Long.valueOf(l))))
        {
          paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.ARj.get(Long.valueOf(l));
          if ((paramString1 != null) && (!paramString1.zVg) && (paramString1.ARB))
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
    
    public final void dv(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120649);
      String str = this.Bga.TAG;
      StringBuilder localStringBuilder = new StringBuilder("videoViewCallback onVideoWaitingEnd: ").append(paramString1).append(' ');
      Object localObject = this.Bga.BfT;
      if (localObject != null) {}
      for (localObject = ((StoryVideoView)localObject).getSessionId();; localObject = null)
      {
        ad.i(str, (String)localObject + ", " + this.Bga.BeY + ", meidiaId:" + paramString2 + ", isVideoPause:" + this.Bga.BeX);
        if ((d.n.n.H(paramString1, this.Bga.BeY, false)) && (this.Bga.BeX))
        {
          paramString1 = this.Bga.BfT;
          if (paramString1 == null) {
            break;
          }
          if (!paramString1.BfJ) {
            this.Bga.y(null);
          }
        }
        AppMethodBeat.o(120649);
        return;
      }
      AppMethodBeat.o(120649);
    }
    
    public final void eT(String paramString1, String paramString2)
    {
      AppMethodBeat.i(189787);
      ad.i(this.Bga.TAG, "onVideoFirstFrameDraw: " + paramString1 + ", meidiaId:" + paramString2);
      AppMethodBeat.o(189787);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.n
 * JD-Core Version:    0.7.0.1
 */