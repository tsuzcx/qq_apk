package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.oq;
import com.tencent.mm.autogen.mmdata.rpt.ox;
import com.tencent.mm.g.h.a;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.story.g.c;
import com.tencent.mm.plugin.story.h.o;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.r;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.thumbplayer.api.ITPPlayer;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "", "()V", "STORY_VIDEO_VIEW_IDKEY_STAT", "", "TAG", "", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "currentSessionId", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "onlineVideoEventListener", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$onlineVideoEventListener$1;", "proxy", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayProxy;", "showLoadingTime", "", "videoView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView;", "videoViewCallback", "com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "checkPauseOnProgress", "getPlayStatus", "getVideoView", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "newVideoViewInstance", "onUIDestroy", "onUIPause", "onUIResume", "pauseVideo", "playVideo", "resetVideo", "sameParent", "setMute", "setNeedShowLoading", "show", "setVideoViewProp", "stopTask", "stopVideo", "detach", "VideoPlayCdnCallback", "VideoPlayProxy", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  boolean SCA;
  private com.tencent.mm.compatible.util.b SCB;
  private boolean SCC;
  boolean SCw;
  String SCx;
  private boolean SCy;
  private com.tencent.mm.plugin.story.model.d.j SCz;
  StoryVideoView SDp;
  private b SDq;
  private final long SDr;
  int SDs;
  private final StoryVideoViewMgr.onlineVideoEventListener.1 SDt;
  private final d SDu;
  final String TAG;
  private boolean lAj;
  
  public k()
  {
    AppMethodBeat.i(120664);
    this.TAG = "MicroMsg.Gallery.StoryVideoViewMgr";
    this.SCB = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    this.SDr = 987L;
    this.SDt = new StoryVideoViewMgr.onlineVideoEventListener.1(this, com.tencent.mm.app.f.hfK);
    Log.i(this.TAG, s.X("init create StoryVideoViewMgr ", Integer.valueOf(hashCode())));
    this.SDt.alive();
    this.SDu = new d(this);
    AppMethodBeat.o(120664);
  }
  
  private final void Y(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120662);
    String str = this.TAG;
    Object localObject1 = new StringBuilder("checkDetachVideoView, videoView:");
    Object localObject2 = this.SDp;
    int i;
    boolean bool;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", isPlay:");
      localObject2 = this.SDp;
      if (localObject2 != null) {
        break label225;
      }
      bool = false;
      label65:
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", parent:");
      localObject1 = this.SDp;
      if (localObject1 != null) {
        break label234;
      }
      localObject1 = null;
      label92:
      if (localObject1 == null) {
        break label244;
      }
      i = localObject1.hashCode();
      label103:
      localObject1 = ((StringBuilder)localObject2).append(i).append(", newParent:");
      if (paramViewGroup == null) {
        break label249;
      }
      i = paramViewGroup.hashCode();
      label125:
      Log.printInfoStack(str, i + ", isPlayingVideoItem:" + this.SCy, new Object[0]);
      localObject1 = this.SDp;
      if (localObject1 != null) {
        break label254;
      }
      localObject1 = null;
      label169:
      if ((localObject1 == null) || (Z(paramViewGroup))) {
        break label291;
      }
      a(this, true, 1);
      paramViewGroup = this.SDp;
      if (paramViewGroup != null) {
        break label264;
      }
    }
    label264:
    for (paramViewGroup = null;; paramViewGroup = paramViewGroup.getParent())
    {
      if (paramViewGroup != null) {
        break label272;
      }
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(120662);
      throw paramViewGroup;
      i = 0;
      break;
      label225:
      bool = ((StoryVideoView)localObject2).isPlaying();
      break label65;
      label234:
      localObject1 = ((StoryVideoView)localObject1).getParent();
      break label92;
      label244:
      i = 0;
      break label103;
      label249:
      i = 0;
      break label125;
      label254:
      localObject1 = ((StoryVideoView)localObject1).getParent();
      break label169;
    }
    label272:
    ((ViewGroup)paramViewGroup).removeView((View)this.SDp);
    this.SCz = null;
    label291:
    AppMethodBeat.o(120662);
  }
  
  private final boolean Z(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120663);
    Object localObject = this.SDp;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((StoryVideoView)localObject).getParent())
    {
      boolean bool = s.p(localObject, paramViewGroup);
      AppMethodBeat.o(120663);
      return bool;
    }
  }
  
  private final boolean g(com.tencent.mm.plugin.story.model.d.j paramj)
  {
    Object localObject2 = null;
    AppMethodBeat.i(120651);
    int i;
    if (paramj.icg != 0)
    {
      localObject1 = this.SCz;
      com.tencent.mm.plugin.story.model.d.k localk;
      if ((localObject1 != null) && (((com.tencent.mm.plugin.story.model.d.j)localObject1).icg == paramj.icg))
      {
        i = 1;
        if (i == 0) {
          break label86;
        }
        localk = paramj.Smw;
        localObject1 = this.SCz;
        if (localObject1 != null) {
          break label78;
        }
      }
      label78:
      for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.story.model.d.j)localObject1).Smw)
      {
        if (localk != localObject1) {
          break label86;
        }
        AppMethodBeat.o(120651);
        return true;
        i = 0;
        break;
      }
    }
    label86:
    Object localObject1 = (CharSequence)paramj.Smx.Url;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label206;
      }
      localObject1 = this.SCz;
      if (localObject1 != null) {
        break label176;
      }
      localObject1 = null;
      label127:
      if (!s.p(localObject1, paramj.Smx.Url)) {
        break label206;
      }
      localObject1 = paramj.Smw;
      paramj = this.SCz;
      if (paramj != null) {
        break label198;
      }
    }
    label176:
    label198:
    for (paramj = localObject2;; paramj = paramj.Smw)
    {
      if (localObject1 != paramj) {
        break label206;
      }
      AppMethodBeat.o(120651);
      return true;
      i = 0;
      break;
      localObject1 = ((com.tencent.mm.plugin.story.model.d.j)localObject1).Smx;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label127;
      }
      localObject1 = ((fis)localObject1).Url;
      break label127;
    }
    label206:
    AppMethodBeat.o(120651);
    return false;
  }
  
  public final void a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(120650);
    s.u(paramViewGroup, "parent");
    this.SDs = 0;
    boolean bool = Z(paramViewGroup);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("attachVideoView, parent:").append(paramViewGroup.hashCode()).append(", isVideoPause:").append(this.SCw).append(", currentSessionId:").append(this.SCx).append(", isPlayingVideoItem:").append(this.SCy).append(" videoView ");
    Object localObject = this.SDp;
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(((StoryVideoView)localObject).hashCode()))
    {
      Log.printInfoStack(str, localObject + " sameParent " + bool + " this:" + hashCode(), new Object[0]);
      Y(paramViewGroup);
      if (this.SDp == null)
      {
        localObject = MMApplicationContext.getContext();
        s.s(localObject, "getContext()");
        kd((Context)localObject);
      }
      if (bool) {
        break label238;
      }
      if (paramLayoutParams != null) {
        break;
      }
      paramViewGroup.addView((View)this.SDp);
      AppMethodBeat.o(120650);
      return;
    }
    paramViewGroup.addView((View)this.SDp, paramLayoutParams);
    AppMethodBeat.o(120650);
    return;
    label238:
    if (paramLayoutParams != null)
    {
      paramViewGroup = this.SDp;
      if (paramViewGroup != null) {
        paramViewGroup.setLayoutParams(paramLayoutParams);
      }
    }
    AppMethodBeat.o(120650);
  }
  
  public final void a(com.tencent.mm.plugin.story.model.d.j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(120652);
    s.u(paramj, "item");
    if (!g(paramj)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.printInfoStack(this.TAG, "change:" + bool + ' ' + this.SCA + ", " + paramBoolean + ", changeVideoItem: origin: " + this.SCz + ", new: " + paramj + ",  change:" + bool + " this:" + hashCode(), new Object[0]);
      if (bool)
      {
        this.SCz = paramj;
        if ((this.SCA) || (paramBoolean))
        {
          a(this, false, 2);
          atK();
        }
      }
      AppMethodBeat.o(120652);
      return;
    }
  }
  
  public final void atK()
  {
    AppMethodBeat.i(120653);
    Log.printInfoStack(this.TAG, "playVideo, " + this.SCw + ' ' + this.SCA + ", " + this.SCz, new Object[0]);
    hAk();
    this.SCA = true;
    Object localObject1 = this.SCz;
    if (localObject1 != null)
    {
      boolean bool = this.SCw;
      this.SCw = false;
      if (!bool) {
        break label180;
      }
      localObject2 = this.SDp;
      if (localObject2 != null) {
        ((StoryVideoView)localObject2).o((com.tencent.mm.plugin.story.model.d.j)localObject1);
      }
      this.SCw = false;
      if (((com.tencent.mm.plugin.story.model.d.j)localObject1).heF()) {
        this.SCy = true;
      }
      if (!this.SCC)
      {
        this.SCB.requestFocus();
        this.SCC = true;
      }
    }
    localObject1 = com.tencent.mm.plugin.story.g.h.SqZ;
    Object localObject2 = com.tencent.mm.plugin.story.g.h.hxW();
    localObject1 = this.SDp;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((StoryVideoView)localObject1).getContext())
    {
      ((ox)localObject2).itb = NetStatusUtil.getIOSNetType((Context)localObject1);
      AppMethodBeat.o(120653);
      return;
      label180:
      this.SCx = UUID.randomUUID().toString();
      localObject2 = this.SDq;
      if (localObject2 != null) {
        ((b)localObject2).p((com.tencent.mm.plugin.story.model.d.j)localObject1);
      }
      localObject2 = this.SDp;
      if (localObject2 == null) {
        break;
      }
      ((StoryVideoView)localObject2).a((com.tencent.mm.plugin.story.model.d.j)localObject1, this.SCx);
      break;
    }
  }
  
  public final void bf(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(120655);
    Log.printInfoStack(this.TAG, s.X("stopVideo, detach: ", Boolean.valueOf(paramBoolean1)), new Object[0]);
    Object localObject;
    if (this.SCy)
    {
      this.SCx = null;
      localObject = this.SDp;
      if (localObject != null) {
        ((StoryVideoView)localObject).stop();
      }
      this.SCw = false;
      if (this.SCC)
      {
        this.SCB.aPS();
        this.SCC = false;
      }
      this.SCy = false;
    }
    if (paramBoolean1)
    {
      this.SCA = false;
      Y(null);
      localObject = com.tencent.mm.plugin.story.g.h.SqZ;
      com.tencent.mm.plugin.story.g.h.hxW().jkD = System.currentTimeMillis();
      if (paramBoolean2)
      {
        localObject = com.tencent.mm.plugin.story.g.h.SqZ;
        com.tencent.mm.plugin.story.g.h.hxX();
      }
    }
    AppMethodBeat.o(120655);
  }
  
  final void hAk()
  {
    AppMethodBeat.i(120654);
    Log.i(this.TAG, s.X("setVideoViewProp, isMute:", Boolean.valueOf(this.lAj)));
    StoryVideoView localStoryVideoView = this.SDp;
    if (localStoryVideoView != null) {
      localStoryVideoView.setMute(this.lAj);
    }
    AppMethodBeat.o(120654);
  }
  
  final void kd(Context paramContext)
  {
    AppMethodBeat.i(120661);
    this.SDp = new StoryVideoView(paramContext);
    this.SDq = new b();
    paramContext = this.SDp;
    if (paramContext != null) {
      paramContext.setIOnlineVideoProxy((com.tencent.mm.modelvideo.f)this.SDq);
    }
    paramContext = this.SDp;
    if (paramContext != null) {
      paramContext.setIMMVideoViewCallback((i.b)this.SDu);
    }
    paramContext = this.SDp;
    if (paramContext != null) {
      paramContext.setReporter((i.c)new c(this));
    }
    this.SCy = false;
    AppMethodBeat.o(120661);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(120660);
    Log.i(this.TAG, s.X("onUIDestroy ", Integer.valueOf(hashCode())));
    this.SCA = false;
    Y(null);
    this.SCz = null;
    this.SDp = null;
    if (this.SCC)
    {
      this.SCB.aPS();
      this.SCC = false;
    }
    this.SDt.dead();
    AppMethodBeat.o(120660);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(120659);
    Log.i(this.TAG, s.X("onUIPause ", Integer.valueOf(hashCode())));
    Y(null);
    if (this.SCC)
    {
      this.SCB.aPS();
      this.SCC = false;
    }
    AppMethodBeat.o(120659);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(120658);
    StoryVideoView localStoryVideoView = this.SDp;
    if (localStoryVideoView != null) {
      localStoryVideoView.onUIResume();
    }
    AppMethodBeat.o(120658);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(120657);
    Log.i(this.TAG, "setMute " + paramBoolean + " ret " + "");
    this.lAj = paramBoolean;
    AppMethodBeat.o(120657);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayCdnCallback;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;)V", "TAG", "", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "isMoovReady", "", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "videoCache", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "onDataAvailable", "", "mediaId", "offset", "", "length", "onFinish", "ret", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onM3U8Ready", "m3u8", "onMoovReady", "svrflag", "onProgress", "total", "setIEngineCallback", "callback", "setVideoCache", "vitem", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class a
    implements h.a
  {
    volatile boolean EUK;
    private com.tencent.mm.plugin.story.model.d.j SDf;
    private com.tencent.mm.plugin.story.h.n SDv;
    private final String TAG;
    f.a xFC;
    
    public a()
    {
      AppMethodBeat.i(367664);
      this.TAG = "MicroMsg.VideoPlayProxy";
      AppMethodBeat.o(367664);
    }
    
    public final void a(com.tencent.mm.plugin.story.h.n paramn, com.tencent.mm.plugin.story.model.d.j paramj)
    {
      this.SDv = paramn;
      this.SDf = paramj;
    }
    
    public final void a(final String paramString, final int paramInt, com.tencent.mm.g.d paramd)
    {
      int j = 0;
      String str = null;
      AppMethodBeat.i(120632);
      s.u(paramString, "mediaId");
      Object localObject2 = this.TAG;
      Object localObject1 = new StringBuilder("onFinish, mediaId:").append(paramString).append(", ret:").append(paramInt).append(", sceneResult:");
      int i;
      label99:
      long l;
      if (paramd == null)
      {
        i = 0;
        StringBuilder localStringBuilder = ((StringBuilder)localObject1).append(i).append(" this:").append(this).append(" currVideoItem:");
        localObject1 = k.e(this.SDw);
        if (localObject1 != null) {
          break label529;
        }
        localObject1 = null;
        Log.i((String)localObject2, localObject1);
        localObject1 = this.SDf;
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.story.g.b.Sqn;
          com.tencent.mm.plugin.story.g.b.vR(((com.tencent.mm.plugin.story.model.d.j)localObject1).idH);
          j.SCD.wh(((com.tencent.mm.plugin.story.model.d.j)localObject1).idH);
        }
        localObject1 = this.SDv;
        if (localObject1 != null) {
          break label539;
        }
        localObject1 = null;
        label163:
        localObject1 = com.tencent.mm.plugin.sight.base.f.aVX((String)localObject1);
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.story.g.h.SqZ;
          com.tencent.mm.plugin.story.g.h.hyk().irv = ((com.tencent.mm.plugin.sight.base.b)localObject1).videoDuration;
          localObject2 = com.tencent.mm.plugin.story.g.h.SqZ;
          com.tencent.mm.plugin.story.g.h.hyk().irw = ((com.tencent.mm.plugin.sight.base.b)localObject1).videoBitrate;
          localObject2 = com.tencent.mm.plugin.story.g.h.SqZ;
          com.tencent.mm.plugin.story.g.h.hyk().irx = ((com.tencent.mm.plugin.sight.base.b)localObject1).audioBitrate;
          localObject2 = com.tencent.mm.plugin.story.g.h.SqZ;
          com.tencent.mm.plugin.story.g.h.hyk().iry = ((com.tencent.mm.plugin.sight.base.b)localObject1).frameRate;
          localObject2 = com.tencent.mm.plugin.story.g.h.SqZ;
          com.tencent.mm.plugin.story.g.h.hyk().irz = ((com.tencent.mm.plugin.sight.base.b)localObject1).width;
          localObject2 = com.tencent.mm.plugin.story.g.h.SqZ;
          com.tencent.mm.plugin.story.g.h.hyk().irA = ((com.tencent.mm.plugin.sight.base.b)localObject1).height;
          localObject2 = com.tencent.mm.plugin.story.g.h.SqZ;
          com.tencent.mm.plugin.story.g.h.hyk().irC = ((com.tencent.mm.plugin.sight.base.b)localObject1).audioChannel;
        }
        localObject1 = com.tencent.mm.plugin.story.g.h.SqZ;
        localObject1 = com.tencent.mm.plugin.story.g.h.hyk();
        if (this.SDv == null) {
          break label549;
        }
        localObject2 = this.SDv;
        s.checkNotNull(localObject2);
        l = ((com.tencent.mm.plugin.story.h.n)localObject2).field_totalSize;
        label330:
        ((oq)localObject1).iru = l;
        localObject1 = com.tencent.mm.plugin.story.g.h.SqZ;
        localObject2 = com.tencent.mm.plugin.story.g.h.hyk();
        localObject1 = this.SDv;
        if (localObject1 != null) {
          break label555;
        }
        localObject1 = null;
        label361:
        ((oq)localObject2).wt((String)localObject1);
        localObject1 = com.tencent.mm.plugin.story.g.h.SqZ;
        localObject2 = com.tencent.mm.plugin.story.g.h.hyk();
        com.tencent.mm.modelcdntran.k.bHX();
        localObject1 = this.SDv;
        if (localObject1 != null) {
          break label565;
        }
        localObject1 = null;
        label397:
        ((oq)localObject2).wu(com.tencent.mm.modelcdntran.d.Nu((String)localObject1));
        if (paramd != null)
        {
          localObject1 = com.tencent.mm.plugin.story.g.h.SqZ;
          com.tencent.mm.plugin.story.g.h.hyk().irs = paramd.field_startTime;
          localObject1 = com.tencent.mm.plugin.story.g.h.SqZ;
          com.tencent.mm.plugin.story.g.h.hyk().irt = paramd.field_endTime;
        }
        if (paramd != null) {
          break label575;
        }
        localObject1 = str;
      }
      label529:
      label539:
      label549:
      label555:
      label565:
      label575:
      for (;;)
      {
        label450:
        if (localObject1 != null)
        {
          localObject1 = new StringBuffer();
          paramd = paramd.field_usedSvrIps;
          s.s(paramd, "sceneResult.field_usedSvrIps");
          int k = paramd.length;
          i = j;
          for (;;)
          {
            if (i < k)
            {
              str = paramd[i];
              i += 1;
              ((StringBuffer)localObject1).append(str).append("|");
              continue;
              i = paramd.field_retCode;
              break;
              localObject1 = ((com.tencent.mm.plugin.story.model.d.j)localObject1).username;
              break label99;
              localObject1 = ((com.tencent.mm.plugin.story.h.n)localObject1).field_filePath;
              break label163;
              l = 0L;
              break label330;
              localObject1 = ((com.tencent.mm.plugin.story.h.n)localObject1).field_url;
              break label361;
              localObject1 = ((com.tencent.mm.plugin.story.h.n)localObject1).field_filePath;
              break label397;
              localObject1 = paramd.field_usedSvrIps;
              break label450;
            }
          }
          paramd = com.tencent.mm.plugin.story.g.h.SqZ;
          com.tencent.mm.plugin.story.g.h.hyk().wv(((StringBuffer)localObject1).toString());
        }
      }
      if (k.g(this.SDw) != null)
      {
        paramd = com.tencent.mm.plugin.story.g.h.SqZ;
        paramd = com.tencent.mm.plugin.story.g.h.hyk();
        localObject1 = k.g(this.SDw);
        s.checkNotNull(localObject1);
        paramd.irD = ((k.b)localObject1).hQV;
        paramd = com.tencent.mm.plugin.story.g.h.SqZ;
        paramd = com.tencent.mm.plugin.story.g.h.hyk();
        localObject1 = k.g(this.SDw);
        s.checkNotNull(localObject1);
        if (!((k.b)localObject1).SDe) {
          break label712;
        }
        l = 3L;
      }
      for (;;)
      {
        paramd.irE = l;
        paramd = com.tencent.mm.plugin.story.g.h.SqZ;
        com.tencent.mm.plugin.story.g.h.hyl();
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, paramString, paramInt));
        AppMethodBeat.o(120632);
        return;
        label712:
        localObject1 = k.g(this.SDw);
        s.checkNotNull(localObject1);
        if (((k.b)localObject1).hQV > 0) {
          l = 2L;
        } else {
          l = 1L;
        }
      }
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(367693);
      s.u(paramString1, "mediaId");
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onMoovReady, mediaId:").append(paramString1).append(", offset:").append(paramLong1).append(", length:").append(paramLong2).append(", isMoovReady:").append(this.EUK).append(" this:").append(this).append(" currVideoItem:");
      Object localObject = k.e(this.SDw);
      if (localObject == null) {}
      for (localObject = null;; localObject = ((com.tencent.mm.plugin.story.model.d.j)localObject).username)
      {
        Log.i(str, localObject);
        if (!this.EUK) {
          break;
        }
        AppMethodBeat.o(367693);
        return;
      }
      this.EUK = true;
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this.SDw, paramString1, paramLong1, paramLong2, paramString2));
      AppMethodBeat.o(367693);
    }
    
    public final void h(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(120631);
      s.u(paramString, "mediaId");
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onProgress, mediaId:").append(paramString).append(", offset:").append(paramLong1).append(", total:").append(paramLong2).append(" this:").append(this).append(" currVideoItem:");
      Object localObject = k.e(this.SDw);
      if (localObject == null) {}
      for (localObject = null;; localObject = ((com.tencent.mm.plugin.story.model.d.j)localObject).username)
      {
        Log.i(str, localObject);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this.SDw, paramString, paramLong1, paramLong2, this));
        AppMethodBeat.o(120631);
        return;
      }
    }
    
    public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(120630);
      s.u(paramString, "mediaId");
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onDataAvailable, mediaId:").append(paramString).append(", offset:").append(paramLong1).append(", length:").append(paramLong2).append(" this:").append(this).append(" currVideoItem:");
      Object localObject = k.e(this.SDw);
      if (localObject == null) {}
      for (localObject = null;; localObject = ((com.tencent.mm.plugin.story.model.d.j)localObject).username)
      {
        Log.i(str, localObject);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.SDw, paramString, paramLong1, paramLong2));
        AppMethodBeat.o(120630);
        return;
      }
    }
    
    public final void onM3U8Ready(String paramString1, String paramString2)
    {
      AppMethodBeat.i(367688);
      s.u(paramString1, "mediaId");
      AppMethodBeat.o(367688);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(k paramk, String paramString, long paramLong1, long paramLong2)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(k.a parama, String paramString, int paramInt)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.a<ah>
    {
      c(k paramk, String paramString1, long paramLong1, long paramLong2, String paramString2)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends u
      implements kotlin.g.a.a<ah>
    {
      d(k paramk, String paramString, long paramLong1, long paramLong2, k.a parama)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayProxy;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;)V", "TAG", "", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "preloadFinish", "", "getPreloadFinish", "()Z", "setPreloadFinish", "(Z)V", "preloadSize", "", "getPreloadSize", "()I", "setPreloadSize", "(I)V", "videoCache", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "createReportRptTips", "", "", "()[Ljava/lang/Object;", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "url", "path", "callback", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayCdnCallback;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "isVideoDataAvailable", "offset", "length", "requestVideoData", "", "setIEngineCallback", "setStoryVideoItem", "startHttpStream", "stop", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class b
    implements com.tencent.mm.modelvideo.f
  {
    boolean SDe;
    private com.tencent.mm.plugin.story.model.d.j SDf;
    private com.tencent.mm.plugin.story.h.n SDv;
    private final String TAG;
    int hQV;
    private f.a xFC;
    
    public b()
    {
      AppMethodBeat.i(367676);
      this.TAG = "MicroMsg.VideoPlayProxy";
      AppMethodBeat.o(367676);
    }
    
    public final void a(f.a parama)
    {
      this.xFC = parama;
    }
    
    public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
    {
      String str2 = null;
      String str1 = null;
      AppMethodBeat.i(120638);
      s.u(paramString, "mediaId");
      Object localObject = this.SDf;
      if (localObject != null)
      {
        r localr = r.Slb;
        this.SDv = r.a((com.tencent.mm.plugin.story.model.d.j)localObject);
        localObject = this.SDv;
        int i;
        if ((localObject != null) && (((com.tencent.mm.plugin.story.h.n)localObject).aLI() == true))
        {
          i = 1;
          if (i == 0) {
            break label173;
          }
          str2 = this.TAG;
          localObject = new StringBuilder("isVideoDataAvailable ").append(paramString).append(", ").append(paramInt1).append(", ").append(paramInt2).append(", download finish cacheSize:");
          paramString = this.SDv;
          if (paramString != null) {
            break label162;
          }
        }
        label162:
        for (paramString = str1;; paramString = Integer.valueOf(paramString.field_cacheSize))
        {
          Log.i(str2, paramString + " this:" + this);
          AppMethodBeat.o(120638);
          return true;
          i = 0;
          break;
        }
      }
      label173:
      boolean bool = v.bOi().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      str1 = this.TAG;
      localObject = new StringBuilder("isVideoDataAvailable ").append(paramString).append(", ").append(paramInt1).append(", ").append(paramInt2).append(", available:").append(bool).append(" cacheSize:");
      paramString = this.SDv;
      if (paramString == null) {}
      for (paramString = str2;; paramString = Integer.valueOf(paramString.field_cacheSize))
      {
        Log.i(str1, paramString + " this:" + this);
        AppMethodBeat.o(120638);
        return bool;
      }
    }
    
    public final void js(String paramString)
    {
      int k = 2;
      int j = 1;
      com.tencent.mm.plugin.story.model.d.j localj = null;
      AppMethodBeat.i(120636);
      s.u(paramString, "mediaId");
      Log.i(this.TAG, "this: " + this + " stop " + paramString + ' ' + Util.getStack());
      Object[] arrayOfObject = new Object[17];
      Object localObject = k.b(this.SDw);
      int i;
      if (localObject == null)
      {
        i = 0;
        arrayOfObject[0] = Integer.valueOf(i);
        localObject = k.b(this.SDw);
        if (localObject != null) {
          break label500;
        }
        localObject = null;
        label110:
        arrayOfObject[1] = localObject;
        localObject = k.b(this.SDw);
        if (localObject != null) {
          break label514;
        }
        localObject = null;
        label133:
        arrayOfObject[2] = localObject;
        localObject = k.b(this.SDw);
        if (localObject != null) {
          break label527;
        }
        localObject = null;
        label156:
        arrayOfObject[3] = localObject;
        localObject = k.b(this.SDw);
        if (localObject != null) {
          break label540;
        }
        localObject = null;
        label179:
        arrayOfObject[4] = localObject;
        localObject = k.b(this.SDw);
        if (localObject != null) {
          break label553;
        }
        localObject = null;
        label202:
        arrayOfObject[5] = localObject;
        localObject = k.b(this.SDw);
        if (localObject != null) {
          break label566;
        }
        localObject = null;
        label225:
        arrayOfObject[6] = localObject;
        arrayOfObject[7] = Integer.valueOf(this.hQV);
        if (this.hQV <= 0) {
          break label579;
        }
        i = 2;
        label253:
        arrayOfObject[8] = Integer.valueOf(i);
        i = k;
        if (this.SDe) {
          i = 3;
        }
        arrayOfObject[9] = Integer.valueOf(i);
        localObject = com.tencent.mm.plugin.story.e.b.Sjl;
        localObject = k.b(this.SDw);
        if (localObject != null) {
          break label584;
        }
        localObject = "";
        label306:
        arrayOfObject[10] = com.tencent.mm.plugin.story.e.b.a.bbG((String)localObject);
        localObject = this.SDf;
        if (localObject != null) {
          break label607;
        }
        localObject = localj;
        label331:
        arrayOfObject[11] = localObject;
        localObject = com.tencent.mm.plugin.story.g.h.SqZ;
        arrayOfObject[12] = Long.valueOf(com.tencent.mm.plugin.story.g.h.hxW().jjn);
        localObject = com.tencent.mm.plugin.story.g.h.SqZ;
        arrayOfObject[13] = Long.valueOf(com.tencent.mm.plugin.story.g.h.hxW().iuE);
        localObject = com.tencent.mm.plugin.story.g.h.SqZ;
        if (com.tencent.mm.plugin.story.g.h.hxW().jkG != 1L) {
          break label620;
        }
        i = j;
        label394:
        arrayOfObject[14] = Integer.valueOf(i);
        localObject = StoryCore.SjP;
        localObject = StoryCore.b.hvR();
        localj = this.SDf;
        if (localj != null) {
          break label625;
        }
      }
      label514:
      label527:
      label540:
      label553:
      label566:
      label579:
      label584:
      label607:
      label620:
      label625:
      for (long l = 0L;; l = localj.idH)
      {
        arrayOfObject[15] = Integer.valueOf(((com.tencent.mm.plugin.story.h.k)localObject).we(l));
        arrayOfObject[16] = Integer.valueOf(k.f(this.SDw));
        Log.i(this.TAG, s.X("reportTips: ", Arrays.toString(arrayOfObject)));
        v.bOi().k(paramString, arrayOfObject);
        AppMethodBeat.o(120636);
        return;
        i = ((StoryVideoView)localObject).getCurrPosMs();
        break;
        label500:
        localObject = Integer.valueOf((int)((StoryVideoView)localObject).getFirstPlayWaitTime());
        break label110;
        localObject = Integer.valueOf(((StoryVideoView)localObject).hAy());
        break label133;
        localObject = Integer.valueOf(((StoryVideoView)localObject).hAz());
        break label156;
        localObject = Integer.valueOf(((StoryVideoView)localObject).hAA());
        break label179;
        localObject = Integer.valueOf(((StoryVideoView)localObject).getStayTime());
        break label202;
        localObject = Integer.valueOf(((StoryVideoView)localObject).getErrorCode());
        break label225;
        i = 1;
        break label253;
        String str = ((StoryVideoView)localObject).getFilePath();
        localObject = str;
        if (str != null) {
          break label306;
        }
        localObject = "";
        break label306;
        localObject = Long.valueOf(((com.tencent.mm.plugin.story.model.d.j)localObject).idH);
        break label331;
        i = 0;
        break label394;
      }
    }
    
    public final void p(com.tencent.mm.plugin.story.model.d.j paramj)
    {
      AppMethodBeat.i(120634);
      s.u(paramj, "item");
      this.SDf = paramj;
      r localr = r.Slb;
      this.SDv = r.a(paramj);
      Log.i(this.TAG, "setStoryVideoItem " + paramj + " videoCache " + this.SDv);
      AppMethodBeat.o(120634);
    }
    
    public final void requestVideoData(final String paramString, final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(120637);
      s.u(paramString, "mediaId");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, paramString, paramInt1, paramInt2));
      AppMethodBeat.o(120637);
    }
    
    public final void w(String paramString1, String paramString2, String paramString3)
    {
      int j = 0;
      Object localObject2 = null;
      AppMethodBeat.i(120635);
      Log.i(this.TAG, "startHttpStream " + paramString1 + ' ' + paramString2 + ' ' + paramString3 + " this:" + this);
      Object localObject1;
      label597:
      boolean bool;
      if (this.SDf != null)
      {
        localObject1 = r.Slb;
        localObject1 = this.SDf;
        s.checkNotNull(localObject1);
        this.SDv = r.a((com.tencent.mm.plugin.story.model.d.j)localObject1);
        localObject1 = this.SDv;
        Object localObject3;
        if ((localObject1 != null) && (!y.ZC(((com.tencent.mm.plugin.story.h.n)localObject1).field_filePath)))
        {
          localObject3 = com.tencent.mm.plugin.story.model.k.Skq;
          localObject3 = ((com.tencent.mm.plugin.story.h.n)localObject1).field_filePath;
          s.s(localObject3, "it.field_filePath");
          com.tencent.mm.plugin.story.model.k.bbO((String)localObject3);
          Log.i(this.TAG, "startHttpStream error downloadFinish " + ((com.tencent.mm.plugin.story.h.n)localObject1).aLI() + " ret:" + y.ZC(((com.tencent.mm.plugin.story.h.n)localObject1).field_filePath) + " path:" + ((com.tencent.mm.plugin.story.h.n)localObject1).field_filePath);
          ((com.tencent.mm.plugin.story.h.n)localObject1).hzE();
          localObject3 = StoryCore.SjP;
          StoryCore.b.hvV().b((com.tencent.mm.plugin.story.h.n)localObject1);
        }
        localObject1 = k.e(this.SDw);
        long l;
        if (localObject1 != null)
        {
          localObject3 = c.SqL;
          c.hxG();
          localObject3 = com.tencent.mm.plugin.story.g.b.Sqn;
          l = ((com.tencent.mm.plugin.story.model.d.j)localObject1).idH;
          if (com.tencent.mm.plugin.story.g.b.hxC())
          {
            Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", s.X("startHttp storyId ", Long.valueOf(l)));
            if (com.tencent.mm.plugin.story.g.b.Sqp.containsKey(Long.valueOf(l)))
            {
              localObject1 = (com.tencent.mm.plugin.story.g.b.a)com.tencent.mm.plugin.story.g.b.Sqp.get(Long.valueOf(l));
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.story.g.b.a)localObject1).SqF = true;
              }
            }
          }
        }
        localObject1 = this.SDf;
        if (localObject1 != null) {
          break label851;
        }
        localObject1 = null;
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject1 = this.SDw;
          ((k)localObject1).SDs += 1;
          localObject1 = ((k)localObject1).SDp;
          if (localObject1 != null) {
            ((StoryVideoView)localObject1).setNeedShowLoading(true);
          }
          localObject1 = new k.a(this.SDw);
          ((k.a)localObject1).xFC = this.xFC;
          ((k.a)localObject1).a(this.SDv, this.SDf);
          localObject3 = new com.tencent.mm.g.h();
          ((com.tencent.mm.g.h)localObject3).taskName = "task_StoryVideoViewMgr";
          Object localObject4 = new k.a(this.SDw);
          ((k.a)localObject4).xFC = this.xFC;
          ((k.a)localObject4).a(this.SDv, this.SDf);
          ((com.tencent.mm.g.h)localObject3).field_mediaId = paramString1;
          ((com.tencent.mm.g.h)localObject3).url = paramString3;
          ((com.tencent.mm.g.h)localObject3).lxi = 1;
          ((com.tencent.mm.g.h)localObject3).lxc = 6;
          ((com.tencent.mm.g.h)localObject3).concurrentCount = 4;
          ((com.tencent.mm.g.h)localObject3).field_fullpath = paramString2;
          ((com.tencent.mm.g.h)localObject3).lxs = ((h.a)localObject1);
          ((com.tencent.mm.g.h)localObject3).field_fileType = com.tencent.mm.g.a.lwi;
          ((com.tencent.mm.g.h)localObject3).field_requestVideoFormat = e.S(1, paramString2);
          paramString2 = j.SCD;
          paramString2 = this.SDf;
          s.checkNotNull(paramString2);
          j.j(paramString2);
          paramString2 = k.e(this.SDw);
          if (paramString2 != null)
          {
            paramString3 = com.tencent.mm.plugin.story.g.b.Sqn;
            l = paramString2.idH;
            if (this.SDv != null)
            {
              paramString2 = this.SDv;
              if ((paramString2 == null) || (paramString2.field_cacheSize != 0)) {
                break label879;
              }
              i = 1;
              if (i == 0) {
                break label885;
              }
            }
            bool = true;
            label605:
            com.tencent.mm.plugin.story.g.b.X(l, bool);
          }
          v.bOi().e((com.tencent.mm.g.h)localObject3);
          if ((this.SDf != null) && (paramString1 != null))
          {
            paramString2 = j.SCD;
            paramString2 = this.SDf;
            s.checkNotNull(paramString2);
            paramString3 = j.k(paramString2);
            if ((paramString3.EUK) && (!((k.a)localObject1).EUK))
            {
              localObject3 = this.TAG;
              localObject4 = new StringBuilder("checkPreloadOnVideoPlay ").append(paramString1).append(", moovReady, offset:").append(paramString3.offset).append(", length:").append(paramString3.length).append(", cacheSize:");
              paramString2 = this.SDv;
              if (paramString2 != null) {
                break label891;
              }
              paramString2 = null;
              label730:
              localObject4 = ((StringBuilder)localObject4).append(paramString2).append(", totalSize:");
              paramString2 = this.SDv;
              if (paramString2 != null) {
                break label902;
              }
              paramString2 = localObject2;
              label756:
              Log.i((String)localObject3, paramString2 + ", preloadFinish:" + paramString3.SDe);
              if ((paramString3.offset > 0L) && (paramString3.length > 0L))
              {
                ((k.a)localObject1).a(paramString1, paramString3.offset, paramString3.length, "");
                paramString1 = this.SDv;
                if (paramString1 != null) {
                  break label913;
                }
              }
            }
          }
        }
      }
      label902:
      label913:
      for (int i = j;; i = paramString1.field_cacheSize)
      {
        this.hQV = i;
        this.SDe = paramString3.SDe;
        AppMethodBeat.o(120635);
        return;
        label851:
        localObject1 = ((com.tencent.mm.plugin.story.model.d.j)localObject1).Smx;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((fis)localObject1).Url;
        break;
        label879:
        i = 0;
        break label597;
        label885:
        bool = false;
        break label605;
        label891:
        paramString2 = Integer.valueOf(paramString2.field_cacheSize);
        break label730;
        paramString2 = Integer.valueOf(paramString2.field_totalSize);
        break label756;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(k.b paramb, String paramString, int paramInt1, int paramInt2)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$initCreateVideoView$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IReport;", "idkeyStat", "", "ID", "", "key", "value", "isImportant", "", "kvStat", "logID", "", "val", "", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements i.c
  {
    c(k paramk) {}
    
    public final void Du(String paramString) {}
    
    public final void hp(long paramLong)
    {
      AppMethodBeat.i(120639);
      StoryVideoView localStoryVideoView = k.b(this.SDw);
      if ((localStoryVideoView != null) && (!localStoryVideoView.SDj)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(k.c(this.SDw), paramLong, 1L, false);
          if ((paramLong >= 141L) && (paramLong <= 145L)) {
            Log.i(k.d(this.SDw), "initCreateVideoView test key " + paramLong + " value 1 currVideoItem:" + k.e(this.SDw) + ' ' + Util.getStack());
          }
        }
        AppMethodBeat.o(120639);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onSeekComplete", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements i.b
  {
    d(k paramk) {}
    
    public final void d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120642);
      Log.i(k.d(this.SDw), "videoViewCallback onError: " + paramString1 + ", meidiaId:" + paramString2 + ", errorMsg:" + paramString3 + ", what:" + paramInt1 + ", extra:" + paramInt2);
      AppMethodBeat.o(120642);
    }
    
    public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120645);
      Log.i(k.d(this.SDw), "videoViewCallback onGetVideoSize: " + paramString1 + ", " + k.h(this.SDw) + ", meidiaId:" + paramString2);
      AppMethodBeat.o(120645);
    }
    
    public final void el(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120643);
      Log.i(k.d(this.SDw), "videoViewCallback onPrepared: " + paramString1 + ", meidiaId:" + paramString2);
      AppMethodBeat.o(120643);
    }
    
    public final void em(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120644);
      Log.i(k.d(this.SDw), "videoViewCallback onVideoEnded: " + paramString1 + ", meidiaId:" + paramString2);
      paramString1 = com.tencent.mm.plugin.story.g.h.SqZ;
      paramString1 = com.tencent.mm.plugin.story.g.h.hxW();
      paramString1.jkK += 1L;
      paramString1 = k.e(this.SDw);
      if (paramString1 != null)
      {
        paramString2 = com.tencent.mm.plugin.story.g.b.Sqn;
        long l = paramString1.idH;
        if (com.tencent.mm.plugin.story.g.b.hxC())
        {
          Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", s.X("onVideoEnd ", Long.valueOf(l)));
          if (com.tencent.mm.plugin.story.g.b.Sqp.containsKey(Long.valueOf(l)))
          {
            paramString1 = (com.tencent.mm.plugin.story.g.b.a)com.tencent.mm.plugin.story.g.b.Sqp.get(Long.valueOf(l));
            if (paramString1 != null) {
              paramString1.nxG = true;
            }
          }
        }
      }
      AppMethodBeat.o(120644);
    }
    
    public final void en(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120646);
      Log.i(k.d(this.SDw), "videoViewCallback onVideoPause: " + paramString1 + ", meidiaId:" + paramString2);
      AppMethodBeat.o(120646);
    }
    
    public final void eo(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120647);
      String str = k.d(this.SDw);
      StringBuilder localStringBuilder = new StringBuilder("videoViewCallback onVideoPlay: ").append(paramString1).append(' ');
      Object localObject = k.b(this.SDw);
      int i;
      label151:
      long l1;
      label277:
      long l2;
      if (localObject == null)
      {
        localObject = null;
        Log.i(str, localObject + ", " + k.h(this.SDw) + ", meidiaId:" + paramString2 + ", isVideoPause:" + k.i(this.SDw));
        if ((kotlin.n.n.T(paramString1, k.h(this.SDw), false)) && (k.i(this.SDw)))
        {
          paramString1 = k.b(this.SDw);
          if ((paramString1 == null) || (paramString1.SDj)) {
            break label463;
          }
          i = 1;
          if (i != 0) {
            k.a(this.SDw);
          }
        }
        paramString2 = k.e(this.SDw);
        if (paramString2 != null)
        {
          paramString1 = c.SqL;
          c.vT(paramString2.idH);
          paramString1 = com.tencent.mm.plugin.story.g.b.Sqn;
          l1 = paramString2.idH;
          if (com.tencent.mm.plugin.story.g.b.hxC())
          {
            localObject = new StringBuilder("onVideoPlay storyId ").append(l1).append(" lastStoryId ").append(com.tencent.mm.plugin.story.g.b.Sqo).append(" contains:").append(com.tencent.mm.plugin.story.g.b.Sqp.containsKey(Long.valueOf(l1))).append(" result");
            paramString1 = (com.tencent.mm.plugin.story.g.b.a)com.tencent.mm.plugin.story.g.b.Sqp.get(Long.valueOf(l1));
            if (paramString1 != null) {
              break label468;
            }
            paramString1 = null;
            Log.v("MicroMsg.StoryBrowseDetailIDKeyStat", paramString1);
            if ((l1 == com.tencent.mm.plugin.story.g.b.Sqo) && (com.tencent.mm.plugin.story.g.b.Sqp.containsKey(Long.valueOf(l1))))
            {
              paramString1 = (com.tencent.mm.plugin.story.g.b.a)com.tencent.mm.plugin.story.g.b.Sqp.get(Long.valueOf(l1));
              if ((paramString1 != null) && (!paramString1.Ris) && (paramString1.SqE <= 0L) && (paramString1.SqD > 0L))
              {
                paramString1.isWaiting = false;
                l2 = Util.milliSecondsToNow(paramString1.SqD);
                paramString1.SqE = Util.nowMilliSecond();
                if (l2 <= 120000L) {
                  break label479;
                }
                Log.w("MicroMsg.StoryBrowseDetailIDKeyStat", "onPlayCostTime  storyId " + l1 + " onPlayCostTime:" + l2);
              }
            }
          }
        }
      }
      for (;;)
      {
        j.SCD.wg(paramString2.idH);
        paramString1 = com.tencent.mm.plugin.story.model.j.Skm;
        com.tencent.mm.plugin.story.model.j.bbI(paramString2.username);
        AppMethodBeat.o(120647);
        return;
        localObject = ((StoryVideoView)localObject).getSessionId();
        break;
        label463:
        i = 0;
        break label151;
        label468:
        paramString1 = Long.valueOf(paramString1.SqE);
        break label277;
        label479:
        Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "onPlayCostTime  storyId " + l1 + " onPlayCostTime:" + l2);
        com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 31L, l2);
        com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 30L, 1L);
        if (l2 <= 400L)
        {
          com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 90L, 1L);
          label553:
          if (l2 > 400L) {
            break label737;
          }
          com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 50L, 1L);
          label572:
          if (l1 != com.tencent.mm.plugin.story.g.b.Sqr) {
            break label858;
          }
          if (!com.tencent.mm.plugin.story.g.b.Squ) {
            break label860;
          }
          com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 40L, 1L);
          com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 42L, l2);
        }
        for (;;)
        {
          if (l2 <= 1000L)
          {
            if (com.tencent.mm.plugin.story.g.b.Squ)
            {
              com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 44L, 1L);
              break;
              if (l2 <= 800L)
              {
                com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 91L, 1L);
                break label553;
              }
              if (l2 <= 1600L)
              {
                com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 92L, 1L);
                break label553;
              }
              if (l2 <= 3200L)
              {
                com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 93L, 1L);
                break label553;
              }
              if (l2 <= 5000L)
              {
                com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 94L, 1L);
                break label553;
              }
              com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 95L, 1L);
              break label553;
              label737:
              if (l2 <= 800L)
              {
                com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 51L, 1L);
                break label572;
              }
              if (l2 <= 1000L)
              {
                com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 52L, 1L);
                break label572;
              }
              if (l2 <= 2000L)
              {
                com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 53L, 1L);
                break label572;
              }
              if (l2 <= 3000L)
              {
                com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 54L, 1L);
                break label572;
              }
              if (l2 <= 4000L)
              {
                com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 55L, 1L);
                break label572;
              }
              com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 56L, 1L);
              break label572;
              label858:
              break;
              label860:
              com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 41L, 1L);
              com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 43L, l2);
              continue;
            }
            com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 45L, 1L);
            break;
          }
        }
        if (l2 <= 2000L)
        {
          if (com.tencent.mm.plugin.story.g.b.Squ) {
            com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 46L, 1L);
          } else {
            com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 47L, 1L);
          }
        }
        else if (com.tencent.mm.plugin.story.g.b.Squ) {
          com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 48L, 1L);
        } else {
          com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 49L, 1L);
        }
      }
    }
    
    public final void ep(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120648);
      Log.i(k.d(this.SDw), "videoViewCallback onVideoWaiting: " + paramString1 + ", meidiaId:" + paramString2);
      paramString1 = k.e(this.SDw);
      if (paramString1 != null)
      {
        paramString2 = c.SqL;
        c.vS(paramString1.idH);
        paramString2 = com.tencent.mm.plugin.story.g.b.Sqn;
        long l = paramString1.idH;
        if ((com.tencent.mm.plugin.story.g.b.hxC()) && (com.tencent.mm.plugin.story.g.b.Sqp.containsKey(Long.valueOf(l))))
        {
          paramString1 = (com.tencent.mm.plugin.story.g.b.a)com.tencent.mm.plugin.story.g.b.Sqp.get(Long.valueOf(l));
          if ((paramString1 != null) && (!paramString1.Ris) && (paramString1.SqF)) {
            paramString1.isWaiting = true;
          }
        }
      }
      AppMethodBeat.o(120648);
    }
    
    public final void eq(String paramString1, String paramString2)
    {
      AppMethodBeat.i(120649);
      String str = k.d(this.SDw);
      StringBuilder localStringBuilder = new StringBuilder("videoViewCallback onVideoWaitingEnd: ").append(paramString1).append(' ');
      Object localObject = k.b(this.SDw);
      if (localObject == null)
      {
        localObject = null;
        Log.i(str, localObject + ", " + k.h(this.SDw) + ", meidiaId:" + paramString2 + ", isVideoPause:" + k.i(this.SDw));
        if ((kotlin.n.n.T(paramString1, k.h(this.SDw), false)) && (k.i(this.SDw)))
        {
          paramString1 = k.b(this.SDw);
          if ((paramString1 == null) || (paramString1.SDj)) {
            break label181;
          }
        }
      }
      label181:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          k.a(this.SDw);
        }
        AppMethodBeat.o(120649);
        return;
        localObject = ((StoryVideoView)localObject).getSessionId();
        break;
      }
    }
    
    public final void gE(String paramString1, String paramString2)
    {
      AppMethodBeat.i(367710);
      Log.i(k.d(this.SDw), "onVideoFirstFrameDraw: " + paramString1 + ", meidiaId:" + paramString2);
      AppMethodBeat.o(367710);
    }
    
    public final void onSeekComplete(ITPPlayer paramITPPlayer) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.k
 * JD-Core Version:    0.7.0.1
 */