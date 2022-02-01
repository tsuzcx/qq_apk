package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.pn;
import com.tencent.mm.f.b.a.lq;
import com.tencent.mm.f.b.a.lx;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.h.c;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "", "()V", "STORY_VIDEO_VIEW_IDKEY_STAT", "", "TAG", "", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "currentSessionId", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "onlineVideoEventListener", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1;", "proxy", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayProxy;", "showLoadingTime", "", "videoView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView;", "videoViewCallback", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "checkPauseOnProgress", "getPlayStatus", "getVideoView", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "newVideoViewInstance", "onUIDestroy", "onUIPause", "onUIResume", "pauseVideo", "playVideo", "resetVideo", "sameParent", "setMute", "setNeedShowLoading", "show", "setVideoViewProp", "stopTask", "stopVideo", "detach", "VideoPlayCdnCallback", "VideoPlayProxy", "plugin-story_release"})
public final class n
{
  boolean Mbg;
  String Mbh;
  private boolean Mbi;
  private com.tencent.mm.plugin.story.f.d.j Mbj;
  boolean Mbk;
  private com.tencent.mm.compatible.util.b Mbl;
  private boolean Mbm;
  StoryVideoView Mcc;
  private b Mcd;
  private final long Mce;
  int Mcf;
  private final d Mcg;
  private final e Mch;
  final String TAG;
  private boolean iYs;
  
  public n()
  {
    AppMethodBeat.i(120664);
    this.TAG = "MicroMsg.Gallery.StoryVideoViewMgr";
    this.Mbl = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    this.Mce = 987L;
    this.Mcg = new d(this);
    Log.i(this.TAG, "init create StoryVideoViewMgr " + hashCode());
    EventCenter.instance.addListener((IListener)this.Mcg);
    this.Mch = new e(this);
    AppMethodBeat.o(120664);
  }
  
  private final void O(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120662);
    String str = this.TAG;
    Object localObject1 = new StringBuilder("checkDetachVideoView, videoView:");
    Object localObject2 = this.Mcc;
    int i;
    boolean bool;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", isPlay:");
      localObject2 = this.Mcc;
      if (localObject2 == null) {
        break label240;
      }
      bool = ((StoryVideoView)localObject2).isPlaying();
      label69:
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", parent:");
      localObject1 = this.Mcc;
      if (localObject1 == null) {
        break label245;
      }
      localObject1 = ((StoryVideoView)localObject1).getParent();
      label100:
      if (localObject1 == null) {
        break label251;
      }
      i = localObject1.hashCode();
      label111:
      localObject1 = ((StringBuilder)localObject2).append(i).append(", newParent:");
      if (paramViewGroup == null) {
        break label256;
      }
      i = paramViewGroup.hashCode();
      label133:
      Log.printInfoStack(str, i + ", isPlayingVideoItem:" + this.Mbi, new Object[0]);
      localObject1 = this.Mcc;
      if (localObject1 == null) {
        break label261;
      }
      localObject1 = ((StoryVideoView)localObject1).getParent();
      label181:
      if ((localObject1 == null) || (P(paramViewGroup))) {
        break label291;
      }
      a(this, true, 1);
      paramViewGroup = this.Mcc;
      if (paramViewGroup == null) {
        break label267;
      }
    }
    label256:
    label261:
    label267:
    for (paramViewGroup = paramViewGroup.getParent();; paramViewGroup = null)
    {
      if (paramViewGroup != null) {
        break label272;
      }
      paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(120662);
      throw paramViewGroup;
      i = 0;
      break;
      label240:
      bool = false;
      break label69;
      label245:
      localObject1 = null;
      break label100;
      label251:
      i = 0;
      break label111;
      i = 0;
      break label133;
      localObject1 = null;
      break label181;
    }
    label272:
    ((ViewGroup)paramViewGroup).removeView((View)this.Mcc);
    this.Mbj = null;
    label291:
    AppMethodBeat.o(120662);
  }
  
  private final boolean P(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120663);
    Object localObject = this.Mcc;
    if (localObject != null) {}
    for (localObject = ((StoryVideoView)localObject).getParent();; localObject = null)
    {
      boolean bool = p.h(localObject, paramViewGroup);
      AppMethodBeat.o(120663);
      return bool;
    }
  }
  
  private final boolean g(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    Object localObject2 = null;
    AppMethodBeat.i(120651);
    Object localObject3;
    if (paramj.fWh != 0)
    {
      localObject1 = this.Mbj;
      if ((localObject1 != null) && (((com.tencent.mm.plugin.story.f.d.j)localObject1).fWh == paramj.fWh))
      {
        localObject3 = paramj.LJe;
        localObject1 = this.Mbj;
        if (localObject1 != null) {}
        for (localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).LJe; localObject3 == localObject1; localObject1 = null)
        {
          AppMethodBeat.o(120651);
          return true;
        }
      }
    }
    Object localObject1 = (CharSequence)paramj.LJf.Url;
    int i;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label190;
      }
      localObject1 = this.Mbj;
      if (localObject1 == null) {
        break label185;
      }
      localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).LJf;
      if (localObject1 == null) {
        break label185;
      }
    }
    label185:
    for (localObject1 = ((enu)localObject1).Url;; localObject1 = null)
    {
      if (!p.h(localObject1, paramj.LJf.Url)) {
        break label190;
      }
      localObject1 = paramj.LJe;
      localObject3 = this.Mbj;
      paramj = localObject2;
      if (localObject3 != null) {
        paramj = ((com.tencent.mm.plugin.story.f.d.j)localObject3).LJe;
      }
      if (localObject1 != paramj) {
        break label190;
      }
      AppMethodBeat.o(120651);
      return true;
      i = 0;
      break;
    }
    label190:
    AppMethodBeat.o(120651);
    return false;
  }
  
  public final void Tf()
  {
    AppMethodBeat.i(120653);
    Log.printInfoStack(this.TAG, "playVideo, " + this.Mbg + ' ' + this.Mbk + ", " + this.Mbj, new Object[0]);
    ggR();
    this.Mbk = true;
    Object localObject1 = this.Mbj;
    if (localObject1 != null)
    {
      boolean bool = this.Mbg;
      this.Mbg = false;
      if (!bool) {
        break label184;
      }
      localObject2 = this.Mcc;
      if (localObject2 != null) {
        ((StoryVideoView)localObject2).o((com.tencent.mm.plugin.story.f.d.j)localObject1);
      }
      this.Mbg = false;
      if (((com.tencent.mm.plugin.story.f.d.j)localObject1).gdq()) {
        this.Mbi = true;
      }
      if (!this.Mbm)
      {
        this.Mbl.avy();
        this.Mbm = true;
      }
    }
    localObject1 = com.tencent.mm.plugin.story.h.h.LOJ;
    Object localObject2 = com.tencent.mm.plugin.story.h.h.geE();
    localObject1 = this.Mcc;
    if (localObject1 != null) {}
    for (localObject1 = ((StoryVideoView)localObject1).getContext();; localObject1 = null)
    {
      ((lx)localObject2).wm(NetStatusUtil.getIOSNetType((Context)localObject1));
      AppMethodBeat.o(120653);
      return;
      label184:
      this.Mbh = UUID.randomUUID().toString();
      localObject2 = this.Mcd;
      if (localObject2 != null) {
        ((b)localObject2).p((com.tencent.mm.plugin.story.f.d.j)localObject1);
      }
      localObject2 = this.Mcc;
      if (localObject2 == null) {
        break;
      }
      ((StoryVideoView)localObject2).a((com.tencent.mm.plugin.story.f.d.j)localObject1, this.Mbh);
      break;
    }
  }
  
  public final void a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(120650);
    p.k(paramViewGroup, "parent");
    this.Mcf = 0;
    boolean bool = P(paramViewGroup);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("attachVideoView, parent:").append(paramViewGroup.hashCode()).append(", isVideoPause:").append(this.Mbg).append(", currentSessionId:").append(this.Mbh).append(", isPlayingVideoItem:").append(this.Mbi).append(" videoView ");
    Object localObject = this.Mcc;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((StoryVideoView)localObject).hashCode());; localObject = null)
    {
      Log.printInfoStack(str, localObject + " sameParent " + bool + " this:" + hashCode(), new Object[0]);
      O(paramViewGroup);
      if (this.Mcc == null)
      {
        localObject = MMApplicationContext.getContext();
        p.j(localObject, "MMApplicationContext.getContext()");
        in((Context)localObject);
      }
      if (bool) {
        break label238;
      }
      if (paramLayoutParams != null) {
        break;
      }
      paramViewGroup.addView((View)this.Mcc);
      AppMethodBeat.o(120650);
      return;
    }
    paramViewGroup.addView((View)this.Mcc, paramLayoutParams);
    AppMethodBeat.o(120650);
    return;
    label238:
    if (paramLayoutParams != null)
    {
      paramViewGroup = this.Mcc;
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
    p.k(paramj, "item");
    if (!g(paramj)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.printInfoStack(this.TAG, "change:" + bool + ' ' + this.Mbk + ", " + paramBoolean + ", changeVideoItem: origin: " + this.Mbj + ", new: " + paramj + ",  change:" + bool + " this:" + hashCode(), new Object[0]);
      if (bool)
      {
        this.Mbj = paramj;
        if ((this.Mbk) || (paramBoolean))
        {
          a(this, false, 2);
          Tf();
        }
      }
      AppMethodBeat.o(120652);
      return;
    }
  }
  
  public final void aI(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(120655);
    Log.printInfoStack(this.TAG, "stopVideo, detach: ".concat(String.valueOf(paramBoolean1)), new Object[0]);
    Object localObject;
    if (this.Mbi)
    {
      this.Mbh = null;
      localObject = this.Mcc;
      if (localObject != null) {
        ((StoryVideoView)localObject).stop();
      }
      this.Mbg = false;
      if (this.Mbm)
      {
        this.Mbl.avz();
        this.Mbm = false;
      }
      this.Mbi = false;
    }
    if (paramBoolean1)
    {
      this.Mbk = false;
      O(null);
      localObject = com.tencent.mm.plugin.story.h.h.LOJ;
      com.tencent.mm.plugin.story.h.h.geE().wq(System.currentTimeMillis());
      if (paramBoolean2)
      {
        localObject = com.tencent.mm.plugin.story.h.h.LOJ;
        com.tencent.mm.plugin.story.h.h.geF();
      }
    }
    AppMethodBeat.o(120655);
  }
  
  final void ggR()
  {
    AppMethodBeat.i(120654);
    Log.i(this.TAG, "setVideoViewProp, isMute:" + this.iYs);
    StoryVideoView localStoryVideoView = this.Mcc;
    if (localStoryVideoView != null)
    {
      localStoryVideoView.setMute(this.iYs);
      AppMethodBeat.o(120654);
      return;
    }
    AppMethodBeat.o(120654);
  }
  
  final void in(Context paramContext)
  {
    AppMethodBeat.i(120661);
    this.Mcc = new StoryVideoView(paramContext);
    this.Mcd = new b();
    paramContext = this.Mcc;
    if (paramContext != null) {
      paramContext.setIOnlineVideoProxy((com.tencent.mm.modelvideo.f)this.Mcd);
    }
    paramContext = this.Mcc;
    if (paramContext != null) {
      paramContext.setIMMVideoViewCallback((i.b)this.Mch);
    }
    paramContext = this.Mcc;
    if (paramContext != null) {
      paramContext.setReporter((i.c)new c(this));
    }
    this.Mbi = false;
    AppMethodBeat.o(120661);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(120660);
    Log.i(this.TAG, "onUIDestroy " + hashCode());
    this.Mbk = false;
    O(null);
    this.Mbj = null;
    this.Mcc = null;
    if (this.Mbm)
    {
      this.Mbl.avz();
      this.Mbm = false;
    }
    EventCenter.instance.removeListener((IListener)this.Mcg);
    AppMethodBeat.o(120660);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(120659);
    Log.i(this.TAG, "onUIPause " + hashCode());
    O(null);
    if (this.Mbm)
    {
      this.Mbl.avz();
      this.Mbm = false;
    }
    AppMethodBeat.o(120659);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(120658);
    StoryVideoView localStoryVideoView = this.Mcc;
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
    p.j("", "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
    Log.i(this.TAG, "setMute " + paramBoolean + " ret " + "");
    this.iYs = paramBoolean;
    AppMethodBeat.o(120657);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayCdnCallback;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;)V", "TAG", "", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "isMoovReady", "", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "videoCache", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "onDataAvailable", "", "mediaId", "offset", "", "length", "onFinish", "ret", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onM3U8Ready", "m3u8", "onMoovReady", "svrflag", "onProgress", "total", "setIEngineCallback", "callback", "setVideoCache", "vitem", "plugin-story_release"})
  final class a
    implements h.a
  {
    private com.tencent.mm.plugin.story.f.d.j MbP;
    private com.tencent.mm.plugin.story.i.n Mci;
    private final String TAG = "MicroMsg.VideoPlayProxy";
    f.a uyX;
    volatile boolean zKm;
    
    public final void Kj(String paramString)
    {
      AppMethodBeat.i(217274);
      p.k(paramString, "mediaId");
      AppMethodBeat.o(217274);
    }
    
    public final void a(com.tencent.mm.plugin.story.i.n paramn, com.tencent.mm.plugin.story.f.d.j paramj)
    {
      this.Mci = paramn;
      this.MbP = paramj;
    }
    
    public final void a(final String paramString, final int paramInt, com.tencent.mm.i.d paramd)
    {
      int j = 0;
      Object localObject2 = null;
      AppMethodBeat.i(120632);
      p.k(paramString, "mediaId");
      Object localObject3 = this.TAG;
      Object localObject1 = new StringBuilder("onFinish, mediaId:").append(paramString).append(", ret:").append(paramInt).append(", sceneResult:");
      int i;
      label106:
      long l;
      if (paramd != null)
      {
        i = paramd.field_retCode;
        StringBuilder localStringBuilder = ((StringBuilder)localObject1).append(i).append(" this:").append(this).append(" currVideoItem:");
        localObject1 = n.b(this.Mcj);
        if (localObject1 == null) {
          break label553;
        }
        localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).username;
        Log.i((String)localObject3, (String)localObject1);
        localObject1 = this.MbP;
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.plugin.story.h.b.LNM;
          com.tencent.mm.plugin.story.h.b.RI(((com.tencent.mm.plugin.story.f.d.j)localObject1).fXG);
          m.MbB.RY(((com.tencent.mm.plugin.story.f.d.j)localObject1).fXG);
        }
        localObject1 = this.Mci;
        if (localObject1 == null) {
          break label559;
        }
        localObject1 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath;
        label174:
        localObject1 = com.tencent.mm.plugin.sight.base.f.aYg((String)localObject1);
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.plugin.story.h.h.LOJ;
          com.tencent.mm.plugin.story.h.h.geS().vS(((com.tencent.mm.plugin.sight.base.b)localObject1).videoDuration);
          localObject3 = com.tencent.mm.plugin.story.h.h.LOJ;
          com.tencent.mm.plugin.story.h.h.geS().vT(((com.tencent.mm.plugin.sight.base.b)localObject1).videoBitrate);
          localObject3 = com.tencent.mm.plugin.story.h.h.LOJ;
          com.tencent.mm.plugin.story.h.h.geS().vU(((com.tencent.mm.plugin.sight.base.b)localObject1).audioBitrate);
          localObject3 = com.tencent.mm.plugin.story.h.h.LOJ;
          com.tencent.mm.plugin.story.h.h.geS().vV(((com.tencent.mm.plugin.sight.base.b)localObject1).frameRate);
          localObject3 = com.tencent.mm.plugin.story.h.h.LOJ;
          com.tencent.mm.plugin.story.h.h.geS().vW(((com.tencent.mm.plugin.sight.base.b)localObject1).width);
          localObject3 = com.tencent.mm.plugin.story.h.h.LOJ;
          com.tencent.mm.plugin.story.h.h.geS().vX(((com.tencent.mm.plugin.sight.base.b)localObject1).height);
          localObject3 = com.tencent.mm.plugin.story.h.h.LOJ;
          com.tencent.mm.plugin.story.h.h.geS().vY(((com.tencent.mm.plugin.sight.base.b)localObject1).audioChannel);
        }
        localObject1 = com.tencent.mm.plugin.story.h.h.LOJ;
        localObject1 = com.tencent.mm.plugin.story.h.h.geS();
        if (this.Mci == null) {
          break label565;
        }
        localObject3 = this.Mci;
        if (localObject3 == null) {
          p.iCn();
        }
        l = ((com.tencent.mm.plugin.story.i.n)localObject3).field_totalSize;
        label351:
        ((lq)localObject1).vR(l);
        localObject1 = com.tencent.mm.plugin.story.h.h.LOJ;
        localObject3 = com.tencent.mm.plugin.story.h.h.geS();
        localObject1 = this.Mci;
        if (localObject1 == null) {
          break label571;
        }
        localObject1 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_url;
        label387:
        ((lq)localObject3).Cl((String)localObject1);
        localObject1 = com.tencent.mm.plugin.story.h.h.LOJ;
        localObject3 = com.tencent.mm.plugin.story.h.h.geS();
        com.tencent.mm.aq.f.bkh();
        localObject1 = this.Mci;
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
        ((lq)localObject3).Cm(com.tencent.mm.aq.a.Vu((String)localObject1));
        if (paramd != null)
        {
          localObject1 = com.tencent.mm.plugin.story.h.h.LOJ;
          com.tencent.mm.plugin.story.h.h.geS().vP(paramd.field_startTime);
          localObject1 = com.tencent.mm.plugin.story.h.h.LOJ;
          com.tencent.mm.plugin.story.h.h.geS().vQ(paramd.field_endTime);
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
      paramd = com.tencent.mm.plugin.story.h.h.LOJ;
      com.tencent.mm.plugin.story.h.h.geS().Cn(((StringBuffer)localObject1).toString());
      label599:
      if (n.e(this.Mcj) != null)
      {
        paramd = com.tencent.mm.plugin.story.h.h.LOJ;
        paramd = com.tencent.mm.plugin.story.h.h.geS();
        localObject1 = n.e(this.Mcj);
        if (localObject1 == null) {
          p.iCn();
        }
        paramd.vZ(((n.b)localObject1).fLn);
        paramd = com.tencent.mm.plugin.story.h.h.LOJ;
        paramd = com.tencent.mm.plugin.story.h.h.geS();
        localObject1 = n.e(this.Mcj);
        if (localObject1 == null) {
          p.iCn();
        }
        if (!((n.b)localObject1).MbO) {
          break label719;
        }
        l = 3L;
      }
      for (;;)
      {
        paramd.wa(l);
        paramd = com.tencent.mm.plugin.story.h.h.LOJ;
        com.tencent.mm.plugin.story.h.h.geT();
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, paramString, paramInt));
        AppMethodBeat.o(120632);
        return;
        label719:
        localObject1 = n.e(this.Mcj);
        if (localObject1 == null) {
          p.iCn();
        }
        if (((n.b)localObject1).fLn > 0) {
          l = 2L;
        } else {
          l = 1L;
        }
      }
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(217275);
      p.k(paramString1, "mediaId");
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onMoovReady, mediaId:").append(paramString1).append(", offset:").append(paramLong1).append(", length:").append(paramLong2).append(", isMoovReady:").append(this.zKm).append(" this:").append(this).append(" currVideoItem:");
      Object localObject = n.b(this.Mcj);
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.story.f.d.j)localObject).username;; localObject = null)
      {
        Log.i(str, (String)localObject);
        if (!this.zKm) {
          break;
        }
        AppMethodBeat.o(217275);
        return;
      }
      this.zKm = true;
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, paramString1, paramLong1, paramLong2, paramString2));
      AppMethodBeat.o(217275);
    }
    
    public final void h(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(120631);
      p.k(paramString, "mediaId");
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onProgress, mediaId:").append(paramString).append(", offset:").append(paramLong1).append(", total:").append(paramLong2).append(" this:").append(this).append(" currVideoItem:");
      Object localObject = n.b(this.Mcj);
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.story.f.d.j)localObject).username;; localObject = null)
      {
        Log.i(str, (String)localObject);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this, paramString, paramLong1, paramLong2));
        AppMethodBeat.o(120631);
        return;
      }
    }
    
    public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(120630);
      p.k(paramString, "mediaId");
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onDataAvailable, mediaId:").append(paramString).append(", offset:").append(paramLong1).append(", length:").append(paramLong2).append(" this:").append(this).append(" currVideoItem:");
      Object localObject = n.b(this.Mcj);
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.story.f.d.j)localObject).username;; localObject = null)
      {
        Log.i(str, (String)localObject);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, paramString, paramLong1, paramLong2));
        AppMethodBeat.o(120630);
        return;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(n.a parama, String paramString, long paramLong1, long paramLong2)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(n.a parama, String paramString, int paramInt)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<x>
    {
      c(n.a parama, String paramString1, long paramLong1, long paramLong2, String paramString2)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayProxy;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;)V", "TAG", "", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "preloadFinish", "", "getPreloadFinish", "()Z", "setPreloadFinish", "(Z)V", "preloadSize", "", "getPreloadSize", "()I", "setPreloadSize", "(I)V", "videoCache", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "createReportRptTips", "", "", "()[Ljava/lang/Object;", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "url", "path", "callback", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayCdnCallback;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "isVideoDataAvailable", "offset", "length", "requestVideoData", "", "setIEngineCallback", "setStoryVideoItem", "startHttpStream", "stop", "plugin-story_release"})
  final class b
    implements com.tencent.mm.modelvideo.f
  {
    boolean MbO;
    private com.tencent.mm.plugin.story.f.d.j MbP;
    private com.tencent.mm.plugin.story.i.n Mci;
    private final String TAG = "MicroMsg.VideoPlayProxy";
    int fLn;
    private f.a uyX;
    
    public final void a(f.a parama)
    {
      this.uyX = parama;
    }
    
    public final void hR(String paramString)
    {
      int k = 2;
      int j = 1;
      com.tencent.mm.plugin.story.f.d.j localj = null;
      AppMethodBeat.i(120636);
      p.k(paramString, "mediaId");
      Log.i(this.TAG, "this: " + this + " stop " + paramString + ' ' + Util.getStack());
      Object[] arrayOfObject = new Object[17];
      Object localObject1 = n.c(this.Mcj);
      label124:
      int i;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).getCurrPosMs());
        arrayOfObject[0] = localObject1;
        localObject1 = n.c(this.Mcj);
        if (localObject1 == null) {
          break label588;
        }
        localObject1 = Integer.valueOf((int)((StoryVideoView)localObject1).getFirstPlayWaitTime());
        arrayOfObject[1] = localObject1;
        localObject1 = n.c(this.Mcj);
        if (localObject1 == null) {
          break label594;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).ghf());
        label154:
        arrayOfObject[2] = localObject1;
        localObject1 = n.c(this.Mcj);
        if (localObject1 == null) {
          break label600;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).ghg());
        label184:
        arrayOfObject[3] = localObject1;
        localObject1 = n.c(this.Mcj);
        if (localObject1 == null) {
          break label606;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).ghh());
        label214:
        arrayOfObject[4] = localObject1;
        localObject1 = n.c(this.Mcj);
        if (localObject1 == null) {
          break label612;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).getStayTime());
        label244:
        arrayOfObject[5] = localObject1;
        localObject1 = n.c(this.Mcj);
        if (localObject1 == null) {
          break label618;
        }
        localObject1 = Integer.valueOf(((StoryVideoView)localObject1).getErrorCode());
        label274:
        arrayOfObject[6] = localObject1;
        arrayOfObject[7] = Integer.valueOf(this.fLn);
        if (this.fLn <= 0) {
          break label624;
        }
        i = 2;
        label302:
        arrayOfObject[8] = Integer.valueOf(i);
        i = k;
        if (this.MbO) {
          i = 3;
        }
        arrayOfObject[9] = Integer.valueOf(i);
        localObject1 = com.tencent.mm.plugin.story.e.b.LFC;
        localObject1 = n.c(this.Mcj);
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
        arrayOfObject[10] = com.tencent.mm.plugin.story.e.b.a.bcS((String)localObject1);
        Object localObject2 = this.MbP;
        localObject1 = localj;
        if (localObject2 != null) {
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject2).fXG);
        }
        arrayOfObject[11] = localObject1;
        localObject1 = com.tencent.mm.plugin.story.h.h.LOJ;
        arrayOfObject[12] = Long.valueOf(com.tencent.mm.plugin.story.h.h.geE().amS());
        localObject1 = com.tencent.mm.plugin.story.h.h.LOJ;
        arrayOfObject[13] = Long.valueOf(com.tencent.mm.plugin.story.h.h.geE().amU());
        localObject1 = com.tencent.mm.plugin.story.h.h.LOJ;
        if (com.tencent.mm.plugin.story.h.h.geE().amX() != 1L) {
          break label629;
        }
        i = j;
        label469:
        arrayOfObject[14] = Integer.valueOf(i);
        localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
        localObject1 = j.b.gcw();
        localj = this.MbP;
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
      for (long l = localj.fXG;; l = 0L)
      {
        arrayOfObject[15] = Integer.valueOf(((com.tencent.mm.plugin.story.i.k)localObject1).RV(l));
        arrayOfObject[16] = Integer.valueOf(n.d(this.Mcj));
        Log.i(this.TAG, "reportTips: " + Arrays.toString(arrayOfObject));
        com.tencent.mm.modelvideo.s.bqC().k(paramString, arrayOfObject);
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
      p.k(paramString, "mediaId");
      Object localObject1 = this.MbP;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.story.f.s.LHA;
        this.Mci = com.tencent.mm.plugin.story.f.s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
        localObject1 = this.Mci;
        if ((localObject1 != null) && (((com.tencent.mm.plugin.story.i.n)localObject1).arM() == true))
        {
          str2 = this.TAG;
          localObject1 = new StringBuilder("isVideoDataAvailable ").append(paramString).append(", ").append(paramInt1).append(", ").append(paramInt2).append(", download finish cacheSize:");
          localObject2 = this.Mci;
          paramString = str1;
          if (localObject2 != null) {
            paramString = Integer.valueOf(((com.tencent.mm.plugin.story.i.n)localObject2).field_cacheSize);
          }
          Log.i(str2, paramString + " this:" + this);
          AppMethodBeat.o(120638);
          return true;
        }
      }
      boolean bool = com.tencent.mm.modelvideo.s.bqC().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      str1 = this.TAG;
      localObject1 = new StringBuilder("isVideoDataAvailable ").append(paramString).append(", ").append(paramInt1).append(", ").append(paramInt2).append(", available:").append(bool).append(" cacheSize:");
      Object localObject2 = this.Mci;
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
      p.k(paramj, "item");
      this.MbP = paramj;
      com.tencent.mm.plugin.story.f.s locals = com.tencent.mm.plugin.story.f.s.LHA;
      this.Mci = com.tencent.mm.plugin.story.f.s.a(paramj);
      Log.i(this.TAG, "setStoryVideoItem " + paramj + " videoCache " + this.Mci);
      AppMethodBeat.o(120634);
    }
    
    public final void requestVideoData(final String paramString, final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(120637);
      p.k(paramString, "mediaId");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, paramString, paramInt1, paramInt2));
      AppMethodBeat.o(120637);
    }
    
    public final void s(String paramString1, String paramString2, String paramString3)
    {
      int i = 0;
      Object localObject2 = null;
      AppMethodBeat.i(120635);
      Log.i(this.TAG, "startHttpStream " + paramString1 + ' ' + paramString2 + ' ' + paramString3 + " this:" + this);
      Object localObject1;
      Object localObject3;
      Object localObject4;
      boolean bool;
      if (this.MbP != null)
      {
        localObject1 = com.tencent.mm.plugin.story.f.s.LHA;
        localObject1 = this.MbP;
        if (localObject1 == null) {
          p.iCn();
        }
        this.Mci = com.tencent.mm.plugin.story.f.s.a((com.tencent.mm.plugin.story.f.d.j)localObject1);
        localObject1 = this.Mci;
        if ((localObject1 != null) && (!u.agG(((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath)))
        {
          localObject3 = com.tencent.mm.plugin.story.f.l.LGM;
          localObject3 = ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath;
          p.j(localObject3, "it.field_filePath");
          com.tencent.mm.plugin.story.f.l.bdb((String)localObject3);
          Log.i(this.TAG, "startHttpStream error downloadFinish " + ((com.tencent.mm.plugin.story.i.n)localObject1).arM() + " ret:" + u.agG(((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath) + " path:" + ((com.tencent.mm.plugin.story.i.n)localObject1).field_filePath);
          ((com.tencent.mm.plugin.story.i.n)localObject1).ggn();
          localObject3 = com.tencent.mm.plugin.story.f.j.LGA;
          j.b.gcA().b((com.tencent.mm.plugin.story.i.n)localObject1);
        }
        localObject1 = n.b(this.Mcj);
        long l;
        if (localObject1 != null)
        {
          localObject3 = c.LOg;
          c.gen();
          localObject3 = com.tencent.mm.plugin.story.h.b.LNM;
          l = ((com.tencent.mm.plugin.story.f.d.j)localObject1).fXG;
          if (com.tencent.mm.plugin.story.h.b.gej())
          {
            Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "startHttp storyId ".concat(String.valueOf(l)));
            if (com.tencent.mm.plugin.story.h.b.LNA.containsKey(Long.valueOf(l)))
            {
              localObject1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.LNA.get(Long.valueOf(l));
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.story.h.b.a)localObject1).LNQ = true;
              }
            }
          }
        }
        localObject1 = this.MbP;
        if (localObject1 == null) {
          break label888;
        }
        localObject1 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).LJf;
        if (localObject1 == null) {
          break label888;
        }
        localObject1 = ((enu)localObject1).Url;
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject1 = this.Mcj;
          ((n)localObject1).Mcf += 1;
          localObject1 = ((n)localObject1).Mcc;
          if (localObject1 != null) {
            ((StoryVideoView)localObject1).setNeedShowLoading(true);
          }
          localObject1 = new n.a(this.Mcj);
          ((n.a)localObject1).uyX = this.uyX;
          ((n.a)localObject1).a(this.Mci, this.MbP);
          localObject3 = new com.tencent.mm.i.h();
          ((com.tencent.mm.i.h)localObject3).taskName = "task_StoryVideoViewMgr";
          localObject4 = new n.a(this.Mcj);
          ((n.a)localObject4).uyX = this.uyX;
          ((n.a)localObject4).a(this.Mci, this.MbP);
          ((com.tencent.mm.i.h)localObject3).field_mediaId = paramString1;
          ((com.tencent.mm.i.h)localObject3).url = paramString3;
          ((com.tencent.mm.i.h)localObject3).iVd = 1;
          ((com.tencent.mm.i.h)localObject3).iUX = 6;
          ((com.tencent.mm.i.h)localObject3).concurrentCount = 4;
          ((com.tencent.mm.i.h)localObject3).field_fullpath = paramString2;
          ((com.tencent.mm.i.h)localObject3).iVn = ((h.a)localObject1);
          ((com.tencent.mm.i.h)localObject3).field_fileType = com.tencent.mm.i.a.iUd;
          ((com.tencent.mm.i.h)localObject3).field_requestVideoFormat = com.tencent.mm.modelcontrol.e.N(1, paramString2);
          paramString2 = m.MbB;
          paramString2 = this.MbP;
          if (paramString2 == null) {
            p.iCn();
          }
          m.j(paramString2);
          paramString2 = n.b(this.Mcj);
          if (paramString2 != null)
          {
            paramString3 = com.tencent.mm.plugin.story.h.b.LNM;
            l = paramString2.fXG;
            if (this.Mci != null)
            {
              paramString2 = this.Mci;
              if ((paramString2 == null) || (paramString2.field_cacheSize != 0)) {
                break label894;
              }
            }
            bool = true;
            label620:
            com.tencent.mm.plugin.story.h.b.M(l, bool);
          }
          com.tencent.mm.modelvideo.s.bqC().e((com.tencent.mm.i.h)localObject3);
          if ((this.MbP != null) && (paramString1 != null))
          {
            paramString2 = m.MbB;
            paramString2 = this.MbP;
            if (paramString2 == null) {
              p.iCn();
            }
            paramString3 = m.k(paramString2);
            if ((paramString3.zKm) && (!((n.a)localObject1).zKm))
            {
              localObject3 = this.TAG;
              localObject4 = new StringBuilder("checkPreloadOnVideoPlay ").append(paramString1).append(", moovReady, offset:").append(paramString3.offset).append(", length:").append(paramString3.aFL).append(", cacheSize:");
              paramString2 = this.Mci;
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
        com.tencent.mm.plugin.story.i.n localn = this.Mci;
        paramString2 = localObject2;
        if (localn != null) {
          paramString2 = Integer.valueOf(localn.field_totalSize);
        }
        Log.i((String)localObject3, paramString2 + ", preloadFinish:" + paramString3.MbO);
        if ((paramString3.offset > 0L) && (paramString3.aFL > 0L))
        {
          ((n.a)localObject1).a(paramString1, paramString3.offset, paramString3.aFL, "");
          paramString1 = this.Mci;
          if (paramString1 != null) {
            i = paramString1.field_cacheSize;
          }
          this.fLn = i;
          this.MbO = paramString3.MbO;
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
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$initCreateVideoView$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IReport;", "idkeyStat", "", "ID", "", "key", "value", "isImportant", "", "kvStat", "logID", "", "val", "", "plugin-story_release"})
  public static final class c
    implements i.c
  {
    public final void EW(long paramLong)
    {
      AppMethodBeat.i(120639);
      StoryVideoView localStoryVideoView = n.c(this.Mcj);
      if (localStoryVideoView != null)
      {
        if (!localStoryVideoView.MbS)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(n.f(this.Mcj), paramLong, 1L, false);
          if ((paramLong >= 141L) && (paramLong <= 145L)) {
            Log.i(n.g(this.Mcj), "initCreateVideoView test key " + paramLong + " value 1 currVideoItem:" + n.b(this.Mcj) + ' ' + Util.getStack());
          }
        }
        AppMethodBeat.o(120639);
        return;
      }
      AppMethodBeat.o(120639);
    }
    
    public final void KP(String paramString) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/OnlineVideoEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class d
    extends IListener<pn>
  {
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(n.d paramd, pn parampn)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-story_release"})
  public static final class e
    implements i.b
  {
    public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120642);
      Log.i(n.g(this.Mcj), "videoViewCallback onError: " + paramString1 + ", meidiaId:" + paramString2 + ", errorMsg:" + paramString3 + ", what:" + paramInt1 + ", extra:" + paramInt2);
      AppMethodBeat.o(120642);
    }
    
    public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120645);
      Log.i(n.g(this.Mcj), "videoViewCallback onGetVideoSize: " + paramString1 + ", " + n.h(this.Mcj) + ", meidiaId:" + paramString2);
      AppMethodBeat.o(120645);
    }
    
    public final void dS(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120643);
      Log.i(n.g(this.Mcj), "videoViewCallback onPrepared: " + paramString1 + ", meidiaId:" + paramString2);
      AppMethodBeat.o(120643);
    }
    
    public final void dT(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120644);
      Log.i(n.g(this.Mcj), "videoViewCallback onVideoEnded: " + paramString1 + ", meidiaId:" + paramString2);
      paramString1 = com.tencent.mm.plugin.story.h.h.LOJ;
      paramString1 = com.tencent.mm.plugin.story.h.h.geE();
      paramString1.wx(paramString1.anb() + 1L);
      paramString1 = n.b(this.Mcj);
      if (paramString1 != null)
      {
        paramString2 = com.tencent.mm.plugin.story.h.b.LNM;
        long l = paramString1.fXG;
        if (com.tencent.mm.plugin.story.h.b.gej())
        {
          Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", "onVideoEnd ".concat(String.valueOf(l)));
          if (com.tencent.mm.plugin.story.h.b.LNA.containsKey(Long.valueOf(l)))
          {
            paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.LNA.get(Long.valueOf(l));
            if (paramString1 != null)
            {
              paramString1.kSa = true;
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
    
    public final void dU(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120646);
      Log.i(n.g(this.Mcj), "videoViewCallback onVideoPause: " + paramString1 + ", meidiaId:" + paramString2);
      AppMethodBeat.o(120646);
    }
    
    public final void dV(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120647);
      String str = n.g(this.Mcj);
      StringBuilder localStringBuilder = new StringBuilder("videoViewCallback onVideoPlay: ").append(paramString1).append(' ');
      Object localObject = n.c(this.Mcj);
      long l1;
      label278:
      long l2;
      if (localObject != null)
      {
        localObject = ((StoryVideoView)localObject).getSessionId();
        Log.i(str, (String)localObject + ", " + n.h(this.Mcj) + ", meidiaId:" + paramString2 + ", isVideoPause:" + n.i(this.Mcj));
        if ((kotlin.n.n.L(paramString1, n.h(this.Mcj), false)) && (n.i(this.Mcj)))
        {
          paramString1 = n.c(this.Mcj);
          if ((paramString1 != null) && (!paramString1.MbS)) {
            n.a(this.Mcj);
          }
        }
        paramString2 = n.b(this.Mcj);
        if (paramString2 == null) {
          break label950;
        }
        paramString1 = c.LOg;
        c.RK(paramString2.fXG);
        paramString1 = com.tencent.mm.plugin.story.h.b.LNM;
        l1 = paramString2.fXG;
        if (com.tencent.mm.plugin.story.h.b.gej())
        {
          localObject = new StringBuilder("onVideoPlay storyId ").append(l1).append(" lastStoryId ").append(com.tencent.mm.plugin.story.h.b.LNz).append(" contains:").append(com.tencent.mm.plugin.story.h.b.LNA.containsKey(Long.valueOf(l1))).append(" result");
          paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.LNA.get(Long.valueOf(l1));
          if (paramString1 == null) {
            break label456;
          }
          paramString1 = Long.valueOf(paramString1.LNP);
          Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", paramString1);
          if ((l1 == com.tencent.mm.plugin.story.h.b.LNz) && (com.tencent.mm.plugin.story.h.b.LNA.containsKey(Long.valueOf(l1))))
          {
            paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.LNA.get(Long.valueOf(l1));
            if ((paramString1 != null) && (!paramString1.KIR) && (paramString1.LNP <= 0L) && (paramString1.LNO > 0L))
            {
              paramString1.isWaiting = false;
              l2 = Util.milliSecondsToNow(paramString1.LNO);
              paramString1.LNP = Util.nowMilliSecond();
              if (l2 <= 120000L) {
                break label461;
              }
              Log.w("MicroMsg.StoryBrowseDetailIDKeyStat", "onPlayCostTime  storyId " + l1 + " onPlayCostTime:" + l2);
            }
          }
        }
      }
      for (;;)
      {
        m.MbB.RX(paramString2.fXG);
        paramString1 = com.tencent.mm.plugin.story.f.k.LGJ;
        com.tencent.mm.plugin.story.f.k.bcV(paramString2.username);
        AppMethodBeat.o(120647);
        return;
        localObject = null;
        break;
        label456:
        paramString1 = null;
        break label278;
        label461:
        Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "onPlayCostTime  storyId " + l1 + " onPlayCostTime:" + l2);
        com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 31L, l2);
        com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 30L, 1L);
        if (l2 <= 400L)
        {
          com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 90L, 1L);
          label534:
          if (l2 > 400L) {
            break label717;
          }
          com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 50L, 1L);
          label553:
          if (l1 != com.tencent.mm.plugin.story.h.b.LNC) {
            break label838;
          }
          if (!com.tencent.mm.plugin.story.h.b.LNF) {
            break label840;
          }
          com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 40L, 1L);
          com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 42L, l2);
        }
        for (;;)
        {
          if (l2 <= 1000L)
          {
            if (com.tencent.mm.plugin.story.h.b.LNF)
            {
              com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 44L, 1L);
              break;
              if (l2 <= 800L)
              {
                com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 91L, 1L);
                break label534;
              }
              if (l2 <= 1600L)
              {
                com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 92L, 1L);
                break label534;
              }
              if (l2 <= 3200L)
              {
                com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 93L, 1L);
                break label534;
              }
              if (l2 <= 5000L)
              {
                com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 94L, 1L);
                break label534;
              }
              com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 95L, 1L);
              break label534;
              label717:
              if (l2 <= 800L)
              {
                com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 51L, 1L);
                break label553;
              }
              if (l2 <= 1000L)
              {
                com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 52L, 1L);
                break label553;
              }
              if (l2 <= 2000L)
              {
                com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 53L, 1L);
                break label553;
              }
              if (l2 <= 3000L)
              {
                com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 54L, 1L);
                break label553;
              }
              if (l2 <= 4000L)
              {
                com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 55L, 1L);
                break label553;
              }
              com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 56L, 1L);
              break label553;
              label838:
              break;
              label840:
              com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 41L, 1L);
              com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 43L, l2);
              continue;
            }
            com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 45L, 1L);
            break;
          }
        }
        if (l2 <= 2000L)
        {
          if (com.tencent.mm.plugin.story.h.b.LNF) {
            com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 46L, 1L);
          } else {
            com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 47L, 1L);
          }
        }
        else if (com.tencent.mm.plugin.story.h.b.LNF) {
          com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 48L, 1L);
        } else {
          com.tencent.mm.plugin.story.h.b.f(com.tencent.mm.plugin.story.h.b.rJY, 49L, 1L);
        }
      }
      label950:
      AppMethodBeat.o(120647);
    }
    
    public final void dW(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120648);
      Log.i(n.g(this.Mcj), "videoViewCallback onVideoWaiting: " + paramString1 + ", meidiaId:" + paramString2);
      paramString1 = n.b(this.Mcj);
      if (paramString1 != null)
      {
        paramString2 = c.LOg;
        c.RJ(paramString1.fXG);
        paramString2 = com.tencent.mm.plugin.story.h.b.LNM;
        long l = paramString1.fXG;
        if ((com.tencent.mm.plugin.story.h.b.gej()) && (com.tencent.mm.plugin.story.h.b.LNA.containsKey(Long.valueOf(l))))
        {
          paramString1 = (com.tencent.mm.plugin.story.h.b.a)com.tencent.mm.plugin.story.h.b.LNA.get(Long.valueOf(l));
          if ((paramString1 != null) && (!paramString1.KIR) && (paramString1.LNQ))
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
    
    public final void dX(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120649);
      String str = n.g(this.Mcj);
      StringBuilder localStringBuilder = new StringBuilder("videoViewCallback onVideoWaitingEnd: ").append(paramString1).append(' ');
      Object localObject = n.c(this.Mcj);
      if (localObject != null) {}
      for (localObject = ((StoryVideoView)localObject).getSessionId();; localObject = null)
      {
        Log.i(str, (String)localObject + ", " + n.h(this.Mcj) + ", meidiaId:" + paramString2 + ", isVideoPause:" + n.i(this.Mcj));
        if ((kotlin.n.n.L(paramString1, n.h(this.Mcj), false)) && (n.i(this.Mcj)))
        {
          paramString1 = n.c(this.Mcj);
          if (paramString1 == null) {
            break;
          }
          if (!paramString1.MbS) {
            n.a(this.Mcj);
          }
        }
        AppMethodBeat.o(120649);
        return;
      }
      AppMethodBeat.o(120649);
    }
    
    public final void fC(String paramString1, String paramString2)
    {
      AppMethodBeat.i(215933);
      Log.i(n.g(this.Mcj), "onVideoFirstFrameDraw: " + paramString1 + ", meidiaId:" + paramString2);
      AppMethodBeat.o(215933);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.n
 * JD-Core Version:    0.7.0.1
 */