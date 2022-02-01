package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.g.b.a.jh;
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.h.c;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "", "()V", "STORY_VIDEO_VIEW_IDKEY_STAT", "", "TAG", "", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "currentSessionId", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "onlineVideoEventListener", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1;", "proxy", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayProxy;", "showLoadingTime", "", "videoView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView;", "videoViewCallback", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "checkPauseOnProgress", "getPlayStatus", "getVideoView", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "newVideoViewInstance", "onUIDestroy", "onUIPause", "onUIResume", "pauseVideo", "playVideo", "resetVideo", "sameParent", "setMute", "setNeedShowLoading", "show", "setVideoViewProp", "stopTask", "stopVideo", "detach", "VideoPlayCdnCallback", "VideoPlayProxy", "plugin-story_release"})
public final class n
{
  boolean FHg;
  String FHh;
  private boolean FHi;
  com.tencent.mm.plugin.story.f.d.j FHj;
  boolean FHk;
  private com.tencent.mm.compatible.util.b FHl;
  private boolean FHm;
  StoryVideoView FIc;
  b FId;
  final long FIe;
  int FIf;
  private final d FIg;
  private final e FIh;
  final String TAG;
  private boolean guh;
  
  public n()
  {
    AppMethodBeat.i(120664);
    this.TAG = "MicroMsg.Gallery.StoryVideoViewMgr";
    this.FHl = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    this.FIe = 987L;
    this.FIg = new d(this);
    Log.i(this.TAG, "init create StoryVideoViewMgr " + hashCode());
    EventCenter.instance.addListener((IListener)this.FIg);
    this.FIh = new e(this);
    AppMethodBeat.o(120664);
  }
  
  private final boolean I(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120663);
    Object localObject = this.FIc;
    if (localObject != null) {}
    for (localObject = ((StoryVideoView)localObject).getParent();; localObject = null)
    {
      boolean bool = p.j(localObject, paramViewGroup);
      AppMethodBeat.o(120663);
      return bool;
    }
  }
  
  private final boolean g(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    Object localObject2 = null;
    AppMethodBeat.i(120651);
    Object localObject3;
    if (paramj.ecf != 0)
    {
      localObject1 = this.FHj;
      if ((localObject1 != null) && (((com.tencent.mm.plugin.story.f.d.j)localObject1).ecf == paramj.ecf))
      {
        localObject3 = paramj.Fpc;
        localObject1 = this.FHj;
        if (localObject1 != null) {}
        for (localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).Fpc; localObject3 == localObject1; localObject1 = null)
        {
          AppMethodBeat.o(120651);
          return true;
        }
      }
    }
    Object localObject1 = (CharSequence)paramj.Fpd.Url;
    int i;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label187;
      }
      localObject1 = this.FHj;
      if (localObject1 == null) {
        break label182;
      }
      localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).Fpd;
      if (localObject1 == null) {
        break label182;
      }
    }
    label182:
    for (localObject1 = ((edt)localObject1).Url;; localObject1 = null)
    {
      if (!p.j(localObject1, paramj.Fpd.Url)) {
        break label187;
      }
      localObject1 = paramj.Fpc;
      localObject3 = this.FHj;
      paramj = localObject2;
      if (localObject3 != null) {
        paramj = ((com.tencent.mm.plugin.story.f.d.j)localObject3).Fpc;
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
  
  final void H(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120662);
    String str = this.TAG;
    Object localObject1 = new StringBuilder("checkDetachVideoView, videoView:");
    Object localObject2 = this.FIc;
    int i;
    boolean bool;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", isPlay:");
      localObject2 = this.FIc;
      if (localObject2 == null) {
        break label246;
      }
      bool = ((StoryVideoView)localObject2).isPlaying();
      label71:
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", parent:");
      localObject1 = this.FIc;
      if (localObject1 == null) {
        break label251;
      }
      localObject1 = ((StoryVideoView)localObject1).getParent();
      label103:
      if (localObject1 == null) {
        break label257;
      }
      i = localObject1.hashCode();
      label114:
      localObject1 = ((StringBuilder)localObject2).append(i).append(", newParent:");
      if (paramViewGroup == null) {
        break label262;
      }
      i = paramViewGroup.hashCode();
      label137:
      Log.printInfoStack(str, i + ", isPlayingVideoItem:" + this.FHi, new Object[0]);
      localObject1 = this.FIc;
      if (localObject1 == null) {
        break label267;
      }
      localObject1 = ((StoryVideoView)localObject1).getParent();
      label186:
      if ((localObject1 == null) || (I(paramViewGroup))) {
        break label297;
      }
      a(this, true, 1);
      paramViewGroup = this.FIc;
      if (paramViewGroup == null) {
        break label273;
      }
    }
    label257:
    label262:
    label267:
    label273:
    for (paramViewGroup = paramViewGroup.getParent();; paramViewGroup = null)
    {
      if (paramViewGroup != null) {
        break label278;
      }
      paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(120662);
      throw paramViewGroup;
      i = 0;
      break;
      label246:
      bool = false;
      break label71;
      label251:
      localObject1 = null;
      break label103;
      i = 0;
      break label114;
      i = 0;
      break label137;
      localObject1 = null;
      break label186;
    }
    label278:
    ((ViewGroup)paramViewGroup).removeView((View)this.FIc);
    this.FHj = null;
    label297:
    AppMethodBeat.o(120662);
  }
  
  public final void PF()
  {
    AppMethodBeat.i(120653);
    Log.printInfoStack(this.TAG, "playVideo, " + this.FHg + ' ' + this.FHk + ", " + this.FHj, new Object[0]);
    fst();
    this.FHk = true;
    Object localObject1 = this.FHj;
    if (localObject1 != null)
    {
      boolean bool = this.FHg;
      this.FHg = false;
      if (!bool) {
        break label184;
      }
      localObject2 = this.FIc;
      if (localObject2 != null) {
        ((StoryVideoView)localObject2).o((com.tencent.mm.plugin.story.f.d.j)localObject1);
      }
      this.FHg = false;
      if (((com.tencent.mm.plugin.story.f.d.j)localObject1).foW()) {
        this.FHi = true;
      }
      if (!this.FHm)
      {
        this.FHl.requestFocus();
        this.FHm = true;
      }
    }
    localObject1 = com.tencent.mm.plugin.story.h.h.FuH;
    Object localObject2 = com.tencent.mm.plugin.story.h.h.fqi();
    localObject1 = this.FIc;
    if (localObject1 != null) {}
    for (localObject1 = ((StoryVideoView)localObject1).getContext();; localObject1 = null)
    {
      ((jo)localObject2).sk(NetStatusUtil.getIOSNetType((Context)localObject1));
      AppMethodBeat.o(120653);
      return;
      label184:
      this.FHh = UUID.randomUUID().toString();
      localObject2 = this.FId;
      if (localObject2 != null) {
        ((b)localObject2).p((com.tencent.mm.plugin.story.f.d.j)localObject1);
      }
      localObject2 = this.FIc;
      if (localObject2 == null) {
        break;
      }
      ((StoryVideoView)localObject2).a((com.tencent.mm.plugin.story.f.d.j)localObject1, this.FHh);
      break;
    }
  }
  
  public final void a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(120650);
    p.h(paramViewGroup, "parent");
    this.FIf = 0;
    boolean bool = I(paramViewGroup);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("attachVideoView, parent:").append(paramViewGroup.hashCode()).append(", isVideoPause:").append(this.FHg).append(", currentSessionId:").append(this.FHh).append(", isPlayingVideoItem:").append(this.FHi).append(" videoView ");
    Object localObject = this.FIc;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((StoryVideoView)localObject).hashCode());; localObject = null)
    {
      Log.printInfoStack(str, localObject + " sameParent " + bool + " this:" + hashCode(), new Object[0]);
      H(paramViewGroup);
      if (this.FIc == null)
      {
        localObject = MMApplicationContext.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        hm((Context)localObject);
      }
      if (bool) {
        break label239;
      }
      if (paramLayoutParams != null) {
        break;
      }
      paramViewGroup.addView((View)this.FIc);
      AppMethodBeat.o(120650);
      return;
    }
    paramViewGroup.addView((View)this.FIc, paramLayoutParams);
    AppMethodBeat.o(120650);
    return;
    label239:
    if (paramLayoutParams != null)
    {
      paramViewGroup = this.FIc;
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
      Log.printInfoStack(this.TAG, "change:" + bool + ' ' + this.FHk + ", " + paramBoolean + ", changeVideoItem: origin: " + this.FHj + ", new: " + paramj + ",  change:" + bool + " this:" + hashCode(), new Object[0]);
      if (bool)
      {
        this.FHj = paramj;
        if ((this.FHk) || (paramBoolean))
        {
          a(this, false, 2);
          PF();
        }
      }
      AppMethodBeat.o(120652);
      return;
    }
  }
  
  public final void aw(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(120655);
    Log.printInfoStack(this.TAG, "stopVideo, detach: ".concat(String.valueOf(paramBoolean1)), new Object[0]);
    Object localObject;
    if (this.FHi)
    {
      this.FHh = null;
      localObject = this.FIc;
      if (localObject != null) {
        ((StoryVideoView)localObject).stop();
      }
      this.FHg = false;
      if (this.FHm)
      {
        this.FHl.apm();
        this.FHm = false;
      }
      this.FHi = false;
    }
    if (paramBoolean1)
    {
      this.FHk = false;
      H(null);
      localObject = com.tencent.mm.plugin.story.h.h.FuH;
      com.tencent.mm.plugin.story.h.h.fqi().so(System.currentTimeMillis());
      if (paramBoolean2)
      {
        localObject = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.fqj();
      }
    }
    AppMethodBeat.o(120655);
  }
  
  final void fst()
  {
    AppMethodBeat.i(120654);
    Log.i(this.TAG, "setVideoViewProp, isMute:" + this.guh);
    StoryVideoView localStoryVideoView = this.FIc;
    if (localStoryVideoView != null)
    {
      localStoryVideoView.setMute(this.guh);
      AppMethodBeat.o(120654);
      return;
    }
    AppMethodBeat.o(120654);
  }
  
  final void hm(Context paramContext)
  {
    AppMethodBeat.i(120661);
    this.FIc = new StoryVideoView(paramContext);
    this.FId = new b();
    paramContext = this.FIc;
    if (paramContext != null) {
      paramContext.setIOnlineVideoProxy((com.tencent.mm.modelvideo.b)this.FId);
    }
    paramContext = this.FIc;
    if (paramContext != null) {
      paramContext.setIMMVideoViewCallback((i.b)this.FIh);
    }
    paramContext = this.FIc;
    if (paramContext != null) {
      paramContext.setReporter((i.c)new c(this));
    }
    this.FHi = false;
    AppMethodBeat.o(120661);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(120660);
    Log.i(this.TAG, "onUIDestroy " + hashCode());
    this.FHk = false;
    H(null);
    this.FHj = null;
    this.FIc = null;
    if (this.FHm)
    {
      this.FHl.apm();
      this.FHm = false;
    }
    EventCenter.instance.removeListener((IListener)this.FIg);
    AppMethodBeat.o(120660);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(120659);
    Log.i(this.TAG, "onUIPause " + hashCode());
    H(null);
    if (this.FHm)
    {
      this.FHl.apm();
      this.FHm = false;
    }
    AppMethodBeat.o(120659);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(120658);
    StoryVideoView localStoryVideoView = this.FIc;
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
    Log.i(this.TAG, "setMute " + paramBoolean + " ret " + "");
    this.guh = paramBoolean;
    AppMethodBeat.o(120657);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayCdnCallback;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;)V", "TAG", "", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "isMoovReady", "", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "videoCache", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "onDataAvailable", "", "mediaId", "offset", "", "length", "onFinish", "ret", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onM3U8Ready", "m3u8", "onMoovReady", "svrflag", "onProgress", "total", "setIEngineCallback", "callback", "setVideoCache", "vitem", "plugin-story_release"})
  final class a
    implements h.a
  {
    com.tencent.mm.plugin.story.f.d.j FHP;
    com.tencent.mm.plugin.story.i.n FIi;
    final String TAG = "MicroMsg.VideoPlayProxy";
    com.tencent.mm.modelvideo.b.a qWn;
    volatile boolean uTW;
    
    public final void Ds(String paramString)
    {
      AppMethodBeat.i(222931);
      p.h(paramString, "mediaId");
      AppMethodBeat.o(222931);
    }
    
    public final void a(com.tencent.mm.plugin.story.i.n paramn, com.tencent.mm.plugin.story.f.d.j paramj)
    {
      this.FIi = paramn;
      this.FHP = paramj;
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
        localObject1 = this.FIj.FHj;
        if (localObject1 == null) {
          break label553;
        }
        localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).username;
        Log.i((String)localObject3, (String)localObject1);
        localObject1 = this.FHP;
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.plugin.story.h.b.FtL;
          com.tencent.mm.plugin.story.h.b.Ko(((com.tencent.mm.plugin.story.f.d.j)localObject1).edx);
          m.FHB.KE(((com.tencent.mm.plugin.story.f.d.j)localObject1).edx);
        }
        localObject1 = this.FIi;
        if (localObject1 == null) {
          break label559;
        }
        localObject1 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath;
        label174:
        localObject1 = com.tencent.mm.plugin.sight.base.e.aNx((String)localObject1);
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.plugin.story.h.h.FuH;
          com.tencent.mm.plugin.story.h.h.fqw().rQ(((com.tencent.mm.plugin.sight.base.a)localObject1).videoDuration);
          localObject3 = com.tencent.mm.plugin.story.h.h.FuH;
          com.tencent.mm.plugin.story.h.h.fqw().rR(((com.tencent.mm.plugin.sight.base.a)localObject1).videoBitrate);
          localObject3 = com.tencent.mm.plugin.story.h.h.FuH;
          com.tencent.mm.plugin.story.h.h.fqw().rS(((com.tencent.mm.plugin.sight.base.a)localObject1).audioBitrate);
          localObject3 = com.tencent.mm.plugin.story.h.h.FuH;
          com.tencent.mm.plugin.story.h.h.fqw().rT(((com.tencent.mm.plugin.sight.base.a)localObject1).frameRate);
          localObject3 = com.tencent.mm.plugin.story.h.h.FuH;
          com.tencent.mm.plugin.story.h.h.fqw().rU(((com.tencent.mm.plugin.sight.base.a)localObject1).width);
          localObject3 = com.tencent.mm.plugin.story.h.h.FuH;
          com.tencent.mm.plugin.story.h.h.fqw().rV(((com.tencent.mm.plugin.sight.base.a)localObject1).height);
          localObject3 = com.tencent.mm.plugin.story.h.h.FuH;
          com.tencent.mm.plugin.story.h.h.fqw().rW(((com.tencent.mm.plugin.sight.base.a)localObject1).audioChannel);
        }
        localObject1 = com.tencent.mm.plugin.story.h.h.FuH;
        localObject1 = com.tencent.mm.plugin.story.h.h.fqw();
        if (this.FIi == null) {
          break label565;
        }
        localObject3 = this.FIi;
        if (localObject3 == null) {
          p.hyc();
        }
        l = ((com.tencent.mm.plugin.story.i.n)localObject3).field_totalSize;
        label351:
        ((jh)localObject1).rP(l);
        localObject1 = com.tencent.mm.plugin.story.h.h.FuH;
        localObject3 = com.tencent.mm.plugin.story.h.h.fqw();
        localObject1 = this.FIi;
        if (localObject1 == null) {
          break label571;
        }
        localObject1 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_url;
        label387:
        ((jh)localObject3).wK((String)localObject1);
        localObject1 = com.tencent.mm.plugin.story.h.h.FuH;
        localObject3 = com.tencent.mm.plugin.story.h.h.fqw();
        f.baR();
        localObject1 = this.FIi;
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
        ((jh)localObject3).wL(com.tencent.mm.an.a.NX((String)localObject1));
        if (paramd != null)
        {
          localObject1 = com.tencent.mm.plugin.story.h.h.FuH;
          com.tencent.mm.plugin.story.h.h.fqw().rN(paramd.field_startTime);
          localObject1 = com.tencent.mm.plugin.story.h.h.FuH;
          com.tencent.mm.plugin.story.h.h.fqw().rO(paramd.field_endTime);
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
      paramd = com.tencent.mm.plugin.story.h.h.FuH;
      com.tencent.mm.plugin.story.h.h.fqw().wM(((StringBuffer)localObject1).toString());
      label599:
      if (this.FIj.FId != null)
      {
        paramd = com.tencent.mm.plugin.story.h.h.FuH;
        paramd = com.tencent.mm.plugin.story.h.h.fqw();
        localObject1 = this.FIj.FId;
        if (localObject1 == null) {
          p.hyc();
        }
        paramd.rX(((n.b)localObject1).dRQ);
        paramd = com.tencent.mm.plugin.story.h.h.FuH;
        paramd = com.tencent.mm.plugin.story.h.h.fqw();
        localObject1 = this.FIj.FId;
        if (localObject1 == null) {
          p.hyc();
        }
        if (!((n.b)localObject1).FHO) {
          break label719;
        }
        l = 3L;
      }
      for (;;)
      {
        paramd.rY(l);
        paramd = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.fqx();
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new b(this, paramString, paramInt));
        AppMethodBeat.o(120632);
        return;
        label719:
        localObject1 = this.FIj.FId;
        if (localObject1 == null) {
          p.hyc();
        }
        if (((n.b)localObject1).dRQ > 0) {
          l = 2L;
        } else {
          l = 1L;
        }
      }
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(222932);
      p.h(paramString1, "mediaId");
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onMoovReady, mediaId:").append(paramString1).append(", offset:").append(paramLong1).append(", length:").append(paramLong2).append(", isMoovReady:").append(this.uTW).append(" this:").append(this).append(" currVideoItem:");
      Object localObject = this.FIj.FHj;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.story.f.d.j)localObject).username;; localObject = null)
      {
        Log.i(str, (String)localObject);
        if (!this.uTW) {
          break;
        }
        AppMethodBeat.o(222932);
        return;
      }
      this.uTW = true;
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new c(this, paramString1, paramLong1, paramLong2, paramString2));
      AppMethodBeat.o(222932);
    }
    
    public final void i(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(120631);
      p.h(paramString, "mediaId");
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onProgress, mediaId:").append(paramString).append(", offset:").append(paramLong1).append(", total:").append(paramLong2).append(" this:").append(this).append(" currVideoItem:");
      Object localObject = this.FIj.FHj;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.story.f.d.j)localObject).username;; localObject = null)
      {
        Log.i(str, (String)localObject);
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new d(this, paramString, paramLong1, paramLong2));
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
      Object localObject = this.FIj.FHj;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.story.f.d.j)localObject).username;; localObject = null)
      {
        Log.i(str, (String)localObject);
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this, paramString, paramLong1, paramLong2));
        AppMethodBeat.o(120630);
        return;
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(n.a parama, String paramString, long paramLong1, long paramLong2)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(n.a parama, String paramString, int paramInt)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<x>
    {
      c(n.a parama, String paramString1, long paramLong1, long paramLong2, String paramString2)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class d
      extends q
      implements kotlin.g.a.a<x>
    {
      d(n.a parama, String paramString, long paramLong1, long paramLong2)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayProxy;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;)V", "TAG", "", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "preloadFinish", "", "getPreloadFinish", "()Z", "setPreloadFinish", "(Z)V", "preloadSize", "", "getPreloadSize", "()I", "setPreloadSize", "(I)V", "videoCache", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "createReportRptTips", "", "", "()[Ljava/lang/Object;", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "url", "path", "callback", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayCdnCallback;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "isVideoDataAvailable", "offset", "length", "requestVideoData", "", "setIEngineCallback", "setStoryVideoItem", "startHttpStream", "stop", "plugin-story_release"})
  final class b
    implements com.tencent.mm.modelvideo.b
  {
    boolean FHO;
    com.tencent.mm.plugin.story.f.d.j FHP;
    com.tencent.mm.plugin.story.i.n FIi;
    final String TAG = "MicroMsg.VideoPlayProxy";
    int dRQ;
    private com.tencent.mm.modelvideo.b.a qWn;
    
    public final void a(com.tencent.mm.modelvideo.b.a parama)
    {
      this.qWn = parama;
    }
    
    public final void he(String paramString)
    {
      int k = 2;
      int j = 1;
      com.tencent.mm.plugin.story.f.d.j localj = null;
      AppMethodBeat.i(120636);
      p.h(paramString, "mediaId");
      Log.i(this.TAG, "this: " + this + " stop " + paramString + ' ' + Util.getStack());
      Object[] arrayOfObject = new Object[17];
      Object localObject1 = this.FIj.FIc;
      label124:
      int i;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).getCurrPosMs());
        arrayOfObject[0] = localObject1;
        localObject1 = this.FIj.FIc;
        if (localObject1 == null) {
          break label588;
        }
        localObject1 = Integer.valueOf((int)((StoryVideoView)localObject1).getFirstPlayWaitTime());
        arrayOfObject[1] = localObject1;
        localObject1 = this.FIj.FIc;
        if (localObject1 == null) {
          break label594;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).fsH());
        label154:
        arrayOfObject[2] = localObject1;
        localObject1 = this.FIj.FIc;
        if (localObject1 == null) {
          break label600;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).fsI());
        label184:
        arrayOfObject[3] = localObject1;
        localObject1 = this.FIj.FIc;
        if (localObject1 == null) {
          break label606;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).fsJ());
        label214:
        arrayOfObject[4] = localObject1;
        localObject1 = this.FIj.FIc;
        if (localObject1 == null) {
          break label612;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).getStayTime());
        label244:
        arrayOfObject[5] = localObject1;
        localObject1 = this.FIj.FIc;
        if (localObject1 == null) {
          break label618;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).getErrorCode());
        label274:
        arrayOfObject[6] = localObject1;
        arrayOfObject[7] = Integer.valueOf(this.dRQ);
        if (this.dRQ <= 0) {
          break label624;
        }
        i = 2;
        label302:
        arrayOfObject[8] = Integer.valueOf(i);
        i = k;
        if (this.FHO) {
          i = 3;
        }
        arrayOfObject[9] = Integer.valueOf(i);
        localObject1 = com.tencent.mm.plugin.story.e.b.FlA;
        localObject1 = this.FIj.FIc;
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
        arrayOfObject[10] = com.tencent.mm.plugin.story.e.b.a.aRO((String)localObject1);
        Object localObject2 = this.FHP;
        localObject1 = localj;
        if (localObject2 != null) {
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject2).edx);
        }
        arrayOfObject[11] = localObject1;
        localObject1 = com.tencent.mm.plugin.story.h.h.FuH;
        arrayOfObject[12] = Long.valueOf(com.tencent.mm.plugin.story.h.h.fqi().ahw());
        localObject1 = com.tencent.mm.plugin.story.h.h.FuH;
        arrayOfObject[13] = Long.valueOf(com.tencent.mm.plugin.story.h.h.fqi().ahy());
        localObject1 = com.tencent.mm.plugin.story.h.h.FuH;
        if (com.tencent.mm.plugin.story.h.h.fqi().ahB() != 1L) {
          break label629;
        }
        i = j;
        label469:
        arrayOfObject[14] = Integer.valueOf(i);
        localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
        localObject1 = j.b.foc();
        localj = this.FHP;
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
      for (long l = localj.edx;; l = 0L)
      {
        arrayOfObject[15] = Integer.valueOf(((com.tencent.mm.plugin.story.i.k)localObject1).KB(l));
        arrayOfObject[16] = Integer.valueOf(this.FIj.FIf);
        Log.i(this.TAG, "reportTips: " + Arrays.toString(arrayOfObject));
        com.tencent.mm.modelvideo.o.bhk().l(paramString, arrayOfObject);
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
      Object localObject1 = this.FHP;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.story.f.s.Fny;
        this.FIi = com.tencent.mm.plugin.story.f.s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
        localObject1 = this.FIi;
        if ((localObject1 != null) && (((com.tencent.mm.plugin.story.i.n)localObject1).alN() == true))
        {
          str2 = this.TAG;
          localObject1 = new StringBuilder("isVideoDataAvailable ").append(paramString).append(", ").append(paramInt1).append(", ").append(paramInt2).append(", download finish cacheSize:");
          localObject2 = this.FIi;
          paramString = str1;
          if (localObject2 != null) {
            paramString = Integer.valueOf(((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize);
          }
          Log.i(str2, paramString + " this:" + this);
          AppMethodBeat.o(120638);
          return true;
        }
      }
      boolean bool = com.tencent.mm.modelvideo.o.bhk().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      str1 = this.TAG;
      localObject1 = new StringBuilder("isVideoDataAvailable ").append(paramString).append(", ").append(paramInt1).append(", ").append(paramInt2).append(", available:").append(bool).append(" cacheSize:");
      Object localObject2 = this.FIi;
      paramString = str2;
      if (localObject2 != null) {
        paramString = Integer.valueOf(((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize);
      }
      Log.i(str1, paramString + " this:" + this);
      AppMethodBeat.o(120638);
      return bool;
    }
    
    public final void p(com.tencent.mm.plugin.story.f.d.j paramj)
    {
      AppMethodBeat.i(120634);
      p.h(paramj, "item");
      this.FHP = paramj;
      com.tencent.mm.plugin.story.f.s locals = com.tencent.mm.plugin.story.f.s.Fny;
      this.FIi = com.tencent.mm.plugin.story.f.s.a(paramj);
      Log.i(this.TAG, "setStoryVideoItem " + paramj + " videoCache " + this.FIi);
      AppMethodBeat.o(120634);
    }
    
    public final void p(String paramString1, String paramString2, String paramString3)
    {
      int i = 0;
      Object localObject2 = null;
      AppMethodBeat.i(120635);
      Log.i(this.TAG, "startHttpStream " + paramString1 + ' ' + paramString2 + ' ' + paramString3 + " this:" + this);
      Object localObject1;
      Object localObject3;
      Object localObject4;
      boolean bool;
      if (this.FHP != null)
      {
        localObject1 = com.tencent.mm.plugin.story.f.s.Fny;
        localObject1 = this.FHP;
        if (localObject1 == null) {
          p.hyc();
        }
        this.FIi = com.tencent.mm.plugin.story.f.s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
        localObject1 = this.FIi;
        if ((localObject1 != null) && (!com.tencent.mm.vfs.s.YS(((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath)))
        {
          localObject3 = com.tencent.mm.plugin.story.f.l.FmK;
          localObject3 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath;
          p.g(localObject3, "it.field_filePath");
          com.tencent.mm.plugin.story.f.l.aRX((String)localObject3);
          Log.i(this.TAG, "startHttpStream error downloadFinish " + ((com.tencent.mm.plugin.story.i.n)localObject1).alN() + " ret:" + com.tencent.mm.vfs.s.YS(((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath) + " path:" + ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath);
          ((com.tencent.mm.plugin.story.i.n)localObject1).frR();
          localObject3 = com.tencent.mm.plugin.story.f.j.Fmy;
          j.b.fog().b((com.tencent.mm.plugin.story.i.n)localObject1);
        }
        localObject1 = this.FIj.FHj;
        long l;
        if (localObject1 != null)
        {
          localObject3 = c.Fuf;
          c.fpS();
          localObject3 = com.tencent.mm.plugin.story.h.b.FtL;
          l = ((com.tencent.mm.plugin.story.f.d.j)localObject1).edx;
          if (com.tencent.mm.plugin.story.h.b.beE())
          {
            Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "startHttp storyId ".concat(String.valueOf(l)));
            if (com.tencent.mm.plugin.story.h.b.Ftx.containsKey(Long.valueOf(l)))
            {
              localObject1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.Ftx.get(Long.valueOf(l));
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.story.h.b.a)localObject1).FtP = true;
              }
            }
          }
        }
        localObject1 = this.FHP;
        if (localObject1 == null) {
          break label888;
        }
        localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).Fpd;
        if (localObject1 == null) {
          break label888;
        }
        localObject1 = ((edt)localObject1).Url;
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject1 = this.FIj;
          ((n)localObject1).FIf += 1;
          localObject1 = ((n)localObject1).FIc;
          if (localObject1 != null) {
            ((StoryVideoView)localObject1).setNeedShowLoading(true);
          }
          localObject1 = new n.a(this.FIj);
          ((n.a)localObject1).qWn = this.qWn;
          ((n.a)localObject1).a(this.FIi, this.FHP);
          localObject3 = new com.tencent.mm.i.h();
          ((com.tencent.mm.i.h)localObject3).taskName = "task_StoryVideoViewMgr";
          localObject4 = new n.a(this.FIj);
          ((n.a)localObject4).qWn = this.qWn;
          ((n.a)localObject4).a(this.FIi, this.FHP);
          ((com.tencent.mm.i.h)localObject3).field_mediaId = paramString1;
          ((com.tencent.mm.i.h)localObject3).url = paramString3;
          ((com.tencent.mm.i.h)localObject3).gqU = 1;
          ((com.tencent.mm.i.h)localObject3).gqP = 6;
          ((com.tencent.mm.i.h)localObject3).concurrentCount = 4;
          ((com.tencent.mm.i.h)localObject3).field_fullpath = paramString2;
          ((com.tencent.mm.i.h)localObject3).gre = ((h.a)localObject1);
          ((com.tencent.mm.i.h)localObject3).field_fileType = com.tencent.mm.i.a.gpV;
          ((com.tencent.mm.i.h)localObject3).field_requestVideoFormat = com.tencent.mm.modelcontrol.e.L(1, paramString2);
          paramString2 = m.FHB;
          paramString2 = this.FHP;
          if (paramString2 == null) {
            p.hyc();
          }
          m.j(paramString2);
          paramString2 = this.FIj.FHj;
          if (paramString2 != null)
          {
            paramString3 = com.tencent.mm.plugin.story.h.b.FtL;
            l = paramString2.edx;
            if (this.FIi != null)
            {
              paramString2 = this.FIi;
              if ((paramString2 == null) || (paramString2.field_cacheSize != 0)) {
                break label894;
              }
            }
            bool = true;
            label620:
            com.tencent.mm.plugin.story.h.b.M(l, bool);
          }
          com.tencent.mm.modelvideo.o.bhk().e((com.tencent.mm.i.h)localObject3);
          if ((this.FHP != null) && (paramString1 != null))
          {
            paramString2 = m.FHB;
            paramString2 = this.FHP;
            if (paramString2 == null) {
              p.hyc();
            }
            paramString3 = m.k(paramString2);
            if ((paramString3.uTW) && (!((n.a)localObject1).uTW))
            {
              localObject3 = this.TAG;
              localObject4 = new StringBuilder("checkPreloadOnVideoPlay ").append(paramString1).append(", moovReady, offset:").append(paramString3.offset).append(", length:").append(paramString3.length).append(", cacheSize:");
              paramString2 = this.FIi;
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
        com.tencent.mm.plugin.story.i.n localn = this.FIi;
        paramString2 = localObject2;
        if (localn != null) {
          paramString2 = Integer.valueOf(localn.field_totalSize);
        }
        Log.i((String)localObject3, paramString2 + ", preloadFinish:" + paramString3.FHO);
        if ((paramString3.offset > 0L) && (paramString3.length > 0L))
        {
          ((n.a)localObject1).a(paramString1, paramString3.offset, paramString3.length, "");
          paramString1 = this.FIi;
          if (paramString1 != null) {
            i = paramString1.field_cacheSize;
          }
          this.dRQ = i;
          this.FHO = paramString3.FHO;
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
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this, paramString, paramInt1, paramInt2));
      AppMethodBeat.o(120637);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(n.b paramb, String paramString, int paramInt1, int paramInt2)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$initCreateVideoView$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IReport;", "idkeyStat", "", "ID", "", "key", "value", "isImportant", "", "kvStat", "logID", "", "val", "", "plugin-story_release"})
  public static final class c
    implements i.c
  {
    public final void DX(String paramString) {}
    
    public final void yU(long paramLong)
    {
      AppMethodBeat.i(120639);
      StoryVideoView localStoryVideoView = this.FIj.FIc;
      if (localStoryVideoView != null)
      {
        if (!localStoryVideoView.FHS)
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(this.FIj.FIe, paramLong, 1L, false);
          if ((paramLong >= 141L) && (paramLong <= 145L)) {
            Log.i(this.FIj.TAG, "initCreateVideoView test key " + paramLong + " value 1 currVideoItem:" + this.FIj.FHj + ' ' + Util.getStack());
          }
        }
        AppMethodBeat.o(120639);
        return;
      }
      AppMethodBeat.o(120639);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/OnlineVideoEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class d
    extends IListener<oq>
  {
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(n.d paramd, oq paramoq)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-story_release"})
  public static final class e
    implements i.b
  {
    public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120642);
      Log.i(this.FIj.TAG, "videoViewCallback onError: " + paramString1 + ", meidiaId:" + paramString2 + ", errorMsg:" + paramString3 + ", what:" + paramInt1 + ", extra:" + paramInt2);
      AppMethodBeat.o(120642);
    }
    
    public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120645);
      Log.i(this.FIj.TAG, "videoViewCallback onGetVideoSize: " + paramString1 + ", " + this.FIj.FHh + ", meidiaId:" + paramString2);
      AppMethodBeat.o(120645);
    }
    
    public final void dH(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120643);
      Log.i(this.FIj.TAG, "videoViewCallback onPrepared: " + paramString1 + ", meidiaId:" + paramString2);
      AppMethodBeat.o(120643);
    }
    
    public final void dI(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120644);
      Log.i(this.FIj.TAG, "videoViewCallback onVideoEnded: " + paramString1 + ", meidiaId:" + paramString2);
      paramString1 = com.tencent.mm.plugin.story.h.h.FuH;
      paramString1 = com.tencent.mm.plugin.story.h.h.fqi();
      paramString1.sv(paramString1.ahF() + 1L);
      paramString1 = this.FIj.FHj;
      if (paramString1 != null)
      {
        paramString2 = com.tencent.mm.plugin.story.h.b.FtL;
        long l = paramString1.edx;
        if (com.tencent.mm.plugin.story.h.b.beE())
        {
          Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "onVideoEnd ".concat(String.valueOf(l)));
          if (com.tencent.mm.plugin.story.h.b.Ftx.containsKey(Long.valueOf(l)))
          {
            paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.Ftx.get(Long.valueOf(l));
            if (paramString1 != null)
            {
              paramString1.idt = true;
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
    
    public final void dJ(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120646);
      Log.i(this.FIj.TAG, "videoViewCallback onVideoPause: " + paramString1 + ", meidiaId:" + paramString2);
      AppMethodBeat.o(120646);
    }
    
    public final void dK(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120647);
      String str = this.FIj.TAG;
      StringBuilder localStringBuilder = new StringBuilder("videoViewCallback onVideoPlay: ").append(paramString1).append(' ');
      Object localObject = this.FIj.FIc;
      long l1;
      label280:
      long l2;
      if (localObject != null)
      {
        localObject = ((StoryVideoView)localObject).getSessionId();
        Log.i(str, (String)localObject + ", " + this.FIj.FHh + ", meidiaId:" + paramString2 + ", isVideoPause:" + this.FIj.FHg);
        if ((kotlin.n.n.I(paramString1, this.FIj.FHh, false)) && (this.FIj.FHg))
        {
          paramString1 = this.FIj.FIc;
          if ((paramString1 != null) && (!paramString1.FHS)) {
            this.FIj.H(null);
          }
        }
        paramString2 = this.FIj.FHj;
        if (paramString2 == null) {
          break label952;
        }
        paramString1 = c.Fuf;
        c.Kq(paramString2.edx);
        paramString1 = com.tencent.mm.plugin.story.h.b.FtL;
        l1 = paramString2.edx;
        if (com.tencent.mm.plugin.story.h.b.beE())
        {
          localObject = new StringBuilder("onVideoPlay storyId ").append(l1).append(" lastStoryId ").append(com.tencent.mm.plugin.story.h.b.Ftw).append(" contains:").append(com.tencent.mm.plugin.story.h.b.Ftx.containsKey(Long.valueOf(l1))).append(" result");
          paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.Ftx.get(Long.valueOf(l1));
          if (paramString1 == null) {
            break label458;
          }
          paramString1 = Long.valueOf(paramString1.FtO);
          Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", paramString1);
          if ((l1 == com.tencent.mm.plugin.story.h.b.Ftw) && (com.tencent.mm.plugin.story.h.b.Ftx.containsKey(Long.valueOf(l1))))
          {
            paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.Ftx.get(Long.valueOf(l1));
            if ((paramString1 != null) && (!paramString1.Eva) && (paramString1.FtO <= 0L) && (paramString1.FtN > 0L))
            {
              paramString1.isWaiting = false;
              l2 = Util.milliSecondsToNow(paramString1.FtN);
              paramString1.FtO = Util.nowMilliSecond();
              if (l2 <= 120000L) {
                break label463;
              }
              Log.w("MicroMsg.StoryBrowseDetailIDKeyStat", "onPlayCostTime  storyId " + l1 + " onPlayCostTime:" + l2);
            }
          }
        }
      }
      for (;;)
      {
        m.FHB.KD(paramString2.edx);
        paramString1 = com.tencent.mm.plugin.story.f.k.FmH;
        com.tencent.mm.plugin.story.f.k.aRR(paramString2.username);
        AppMethodBeat.o(120647);
        return;
        localObject = null;
        break;
        label458:
        paramString1 = null;
        break label280;
        label463:
        Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "onPlayCostTime  storyId " + l1 + " onPlayCostTime:" + l2);
        com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 31L, l2);
        com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 30L, 1L);
        if (l2 <= 400L)
        {
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 90L, 1L);
          label536:
          if (l2 > 400L) {
            break label719;
          }
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 50L, 1L);
          label555:
          if (l1 != com.tencent.mm.plugin.story.h.b.Ftz) {
            break label840;
          }
          if (!com.tencent.mm.plugin.story.h.b.FtD) {
            break label842;
          }
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 40L, 1L);
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 42L, l2);
        }
        for (;;)
        {
          if (l2 <= 1000L)
          {
            if (com.tencent.mm.plugin.story.h.b.FtD)
            {
              com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 44L, 1L);
              break;
              if (l2 <= 800L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 91L, 1L);
                break label536;
              }
              if (l2 <= 1600L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 92L, 1L);
                break label536;
              }
              if (l2 <= 3200L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 93L, 1L);
                break label536;
              }
              if (l2 <= 5000L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 94L, 1L);
                break label536;
              }
              com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 95L, 1L);
              break label536;
              label719:
              if (l2 <= 800L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 51L, 1L);
                break label555;
              }
              if (l2 <= 1000L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 52L, 1L);
                break label555;
              }
              if (l2 <= 2000L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 53L, 1L);
                break label555;
              }
              if (l2 <= 3000L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 54L, 1L);
                break label555;
              }
              if (l2 <= 4000L)
              {
                com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 55L, 1L);
                break label555;
              }
              com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 56L, 1L);
              break label555;
              label840:
              break;
              label842:
              com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 41L, 1L);
              com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 43L, l2);
              continue;
            }
            com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 45L, 1L);
            break;
          }
        }
        if (l2 <= 2000L)
        {
          if (com.tencent.mm.plugin.story.h.b.FtD) {
            com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 46L, 1L);
          } else {
            com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 47L, 1L);
          }
        }
        else if (com.tencent.mm.plugin.story.h.b.FtD) {
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 48L, 1L);
        } else {
          com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 49L, 1L);
        }
      }
      label952:
      AppMethodBeat.o(120647);
    }
    
    public final void dL(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120648);
      Log.i(this.FIj.TAG, "videoViewCallback onVideoWaiting: " + paramString1 + ", meidiaId:" + paramString2);
      paramString1 = this.FIj.FHj;
      if (paramString1 != null)
      {
        paramString2 = c.Fuf;
        c.Kp(paramString1.edx);
        paramString2 = com.tencent.mm.plugin.story.h.b.FtL;
        long l = paramString1.edx;
        if ((com.tencent.mm.plugin.story.h.b.beE()) && (com.tencent.mm.plugin.story.h.b.Ftx.containsKey(Long.valueOf(l))))
        {
          paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.Ftx.get(Long.valueOf(l));
          if ((paramString1 != null) && (!paramString1.Eva) && (paramString1.FtP))
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
    
    public final void dM(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120649);
      String str = this.FIj.TAG;
      StringBuilder localStringBuilder = new StringBuilder("videoViewCallback onVideoWaitingEnd: ").append(paramString1).append(' ');
      Object localObject = this.FIj.FIc;
      if (localObject != null) {}
      for (localObject = ((StoryVideoView)localObject).getSessionId();; localObject = null)
      {
        Log.i(str, (String)localObject + ", " + this.FIj.FHh + ", meidiaId:" + paramString2 + ", isVideoPause:" + this.FIj.FHg);
        if ((kotlin.n.n.I(paramString1, this.FIj.FHh, false)) && (this.FIj.FHg))
        {
          paramString1 = this.FIj.FIc;
          if (paramString1 == null) {
            break;
          }
          if (!paramString1.FHS) {
            this.FIj.H(null);
          }
        }
        AppMethodBeat.o(120649);
        return;
      }
      AppMethodBeat.o(120649);
    }
    
    public final void fo(String paramString1, String paramString2)
    {
      AppMethodBeat.i(222933);
      Log.i(this.FIj.TAG, "onVideoFirstFrameDraw: " + paramString1 + ", meidiaId:" + paramString2);
      AppMethodBeat.o(222933);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.n
 * JD-Core Version:    0.7.0.1
 */