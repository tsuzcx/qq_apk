package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ga;
import com.tencent.mm.g.b.a.hp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.MMVideoView.a;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView;", "Lcom/tencent/mm/modelvideo/MMVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "C_TAG", "", "fakeBlurLayer", "Landroid/widget/ImageView;", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "firstPlayWaitTime", "", "getFirstPlayWaitTime", "()J", "setFirstPlayWaitTime", "(J)V", "isFakeVideo", "", "isLocalVideo", "isLocalVideoPause", "isMute", "needShowLoading", "sessionId", "startPlayTime", "surfaceAvailable", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "videoTips", "Landroid/widget/TextView;", "avgBlockTime", "", "blockCount", "calcDownloadRange", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "checkCanPlay", "checkLandscape", "", "blurBgPath", "checkNeedReset", "checkResumeLocalVideo", "createVideoView", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView;", "mContext", "fakeEndTime", "fakeStartTime", "getErrorCode", "getFilePath", "getSessionId", "getStayTime", "initView", "isLive", "isShowLoading", "moovCostTime", "onCompletion", "onFinish", "mediaId", "ret", "onGetVideoSize", "width", "height", "onProgress", "offset", "total", "onSeekComplete", "startPlay", "onSurfaceAvailable", "onTextureUpdate", "onUIDestroy", "onUIPause", "onUIResume", "pause", "play", "item", "playLocalVideo", "videoPath", "prepareVideo", "reportStopLocalVideo", "reset", "resume", "storyVideoItem", "setMute", "mute", "setNeedShowLoading", "show", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoPath", "url", "durationSec", "showDebugInfo", "path", "showLoading", "startTimer", "rightNow", "stop", "stopTimer", "Companion", "plugin-story_release"})
public final class StoryVideoView
  extends MMVideoView
{
  public static final StoryVideoView.a Bxm;
  private com.tencent.mm.plugin.story.f.d.j Bec;
  private final String Bxf;
  private boolean Bxg;
  boolean Bxh;
  private boolean Bxi;
  private boolean Bxj;
  private ImageView Bxk;
  private long Bxl;
  private boolean fOX;
  private long hOz;
  private TextView rNj;
  private String sessionId;
  private FakeVideoViewLayer ukv;
  private boolean ydg;
  
  static
  {
    AppMethodBeat.i(120621);
    Bxm = new StoryVideoView.a((byte)0);
    AppMethodBeat.o(120621);
  }
  
  public StoryVideoView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(120620);
    AppMethodBeat.o(120620);
  }
  
  public StoryVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(120619);
    this.Bxf = "MicroMsg.StoryVideoView";
    paramContext = com.tencent.mm.plugin.story.f.j.BbE;
    setRootPath(com.tencent.mm.vfs.o.k(j.b.getAccStoryPath(), true));
    ffe();
    setIsShowBasicControls(false);
    paramContext = this.lxD;
    p.g(paramContext, "footerRoot");
    paramContext.setVisibility(8);
    this.TAG = this.Bxf;
    this.Bxg = true;
    AppMethodBeat.o(120619);
  }
  
  private final void aDK(String paramString)
  {
    AppMethodBeat.i(120591);
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("playLocalVideo: ").append(paramString).append(", isPlayingNow:");
    com.tencent.mm.pluginsdk.ui.tools.h localh = this.oNV;
    p.g(localh, "videoView");
    ae.i((String)localObject1, localh.isPlaying());
    if (this.oNV == null) {
      this.oNV = cN(getContext());
    }
    reset();
    localObject1 = this.oNV;
    if (localObject1 != null) {
      ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).stop();
    }
    localObject1 = this.oNV;
    if (localObject1 != null) {
      if (!this.fOX)
      {
        if (!this.Bxj) {
          break label204;
        }
        localObject2 = this.ukv;
        if (localObject2 == null) {
          p.bdF("fakeLayer");
        }
        if (!((FakeVideoViewLayer)localObject2).xXB) {
          break label204;
        }
      }
    }
    label204:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).setMute(bool);
      this.bzN = false;
      this.Bxh = true;
      setDownloadStatus(3);
      setNeedShowLoading(false);
      localObject1 = this.oNV;
      if (localObject1 != null) {
        break;
      }
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView");
      AppMethodBeat.o(120591);
      throw paramString;
    }
    ((StoryVideoPlayTextureView)localObject1).setNeedResetExtractor(cyZ());
    localObject1 = this.oNV;
    p.g(localObject1, "videoView");
    ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).setVideoPath(paramString);
    this.hOz = bu.HQ();
    this.Bxl = 0L;
    localObject1 = com.tencent.mm.plugin.story.f.k.BbN;
    localObject1 = this.Bec;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.story.f.d.j)localObject1).username;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    com.tencent.mm.plugin.story.f.k.aCV((String)localObject1);
    this.oNV.setVideoCallback((h.a)new b(this));
    this.Bxi = false;
    this.sessionId = null;
    aDL(paramString);
    AppMethodBeat.o(120591);
  }
  
  private final void aDL(String paramString)
  {
    AppMethodBeat.i(120617);
    Object localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).ajA().get(am.a.IQW, Integer.valueOf(0));
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(120617);
      throw paramString;
    }
    if (((Integer)localObject).intValue() == 1)
    {
      localObject = this.rNj;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.sight.base.e.arR(paramString));
      }
      paramString = this.rNj;
      if (paramString != null)
      {
        paramString.setVisibility(0);
        AppMethodBeat.o(120617);
        return;
      }
    }
    AppMethodBeat.o(120617);
  }
  
  private final boolean cyZ()
  {
    AppMethodBeat.i(120604);
    if (this.Bxh)
    {
      AppMethodBeat.o(120604);
      return false;
    }
    try
    {
      boolean bool = g.ajR().ajA().getBoolean(am.a.ISo, false);
      AppMethodBeat.o(120604);
      return bool;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace(this.TAG, (Throwable)localException, "check need reset error", new Object[0]);
      AppMethodBeat.o(120604);
    }
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.story.f.d.j paramj, String paramString)
  {
    AppMethodBeat.i(120585);
    p.h(paramj, "item");
    Object localObject1 = this.rNj;
    if (localObject1 != null) {
      ((TextView)localObject1).setVisibility(8);
    }
    this.Bec = paramj;
    localObject1 = paramj.Bem;
    int i = paramj.icw;
    this.Bxj = false;
    Object localObject2 = this.ukv;
    if (localObject2 == null) {
      p.bdF("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject2).setVisibility(8);
    localObject2 = this.Bxk;
    if (localObject2 != null) {
      ((ImageView)localObject2).setVisibility(8);
    }
    if (!paramj.emv())
    {
      ae.i(this.TAG, "play empty item");
      showLoading();
      AppMethodBeat.o(120585);
      return;
    }
    if (paramj.emu())
    {
      this.Bxj = true;
      ae.i(this.TAG, "LogStory: play fake video");
      paramString = this.ukv;
      if (paramString == null) {
        p.bdF("fakeLayer");
      }
      paramString.setVisibility(0);
      paramj = paramj.Ben;
      if (paramj != null)
      {
        paramString = paramj.field_blurBgPath;
        p.g(paramString, "fakeData.field_blurBgPath");
        localObject1 = (CharSequence)paramString;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label379;
        }
        i = 1;
        if (i != 0) {
          break label384;
        }
        localObject1 = com.tencent.mm.ui.ar.ck(getContext());
        paramString = com.tencent.mm.sdk.platformtools.h.d(paramString, ((Point)localObject1).y, ((Point)localObject1).x, true);
        localObject1 = this.Bxk;
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageBitmap(paramString);
        }
        paramString = this.Bxk;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        label268:
        paramString = this.ukv;
        if (paramString == null) {
          p.bdF("fakeLayer");
        }
        paramString.setFakeVideoInfo(paramj);
        paramString = this.ukv;
        if (paramString == null) {
          p.bdF("fakeLayer");
        }
        paramString.qe(this.fOX);
        this.iuH = paramj.dHV().videoPath;
        this.iuG = "";
        paramj = this.iuH;
        p.g(paramj, "filepath");
        aDK(paramj);
      }
    }
    for (;;)
    {
      setLoop(true);
      paramj = this.oNV;
      if (paramj != null) {
        break label964;
      }
      paramj = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(120585);
      throw paramj;
      label379:
      i = 0;
      break;
      label384:
      paramString = this.Bxk;
      if (paramString == null) {
        break label268;
      }
      paramString.setVisibility(8);
      break label268;
      ae.i(this.TAG, "LogStory: play normal video");
      localObject2 = s.BcG;
      Object localObject3 = s.a((dkg)localObject1);
      if (com.tencent.mm.vfs.o.aZR((String)localObject3) > 0L)
      {
        ae.i(this.TAG, "play " + (String)localObject3 + " downloadDone now can play " + ((dkg)localObject1).Id);
        this.iuH = ((String)localObject3);
        if (localObject3 != null) {
          aDK((String)localObject3);
        }
      }
      else
      {
        localObject2 = s.BcG;
        localObject2 = s.a(paramj);
        int j = (int)com.tencent.mm.vfs.o.aZR(((n)localObject2).field_filePath);
        ae.i(this.TAG, "play " + (String)localObject3 + " error try play from url or videoCache " + ((dkg)localObject1).Id + " fileLength:" + j + " cacheSize:" + ((n)localObject2).field_cacheSize);
        if (j < ((n)localObject2).field_cacheSize)
        {
          ((n)localObject2).field_cacheSize = j;
          localObject3 = com.tencent.mm.plugin.story.f.j.BbE;
          j.b.elF().b((n)localObject2);
        }
        ae.i(this.TAG, String.valueOf(localObject2));
        if ((((n)localObject2).Ya()) && (com.tencent.mm.vfs.o.fB(((n)localObject2).field_filePath)))
        {
          ae.i(this.TAG, "play " + ((dkg)localObject1).Id + " download finish");
          this.iuH = ((n)localObject2).field_filePath;
          paramj = s.BcG;
          this.iuG = s.cb(i, ((dkg)localObject1).Url);
          paramj = this.iuH;
          p.g(paramj, "filepath");
          aDK(paramj);
        }
        else
        {
          if ((((n)localObject2).Ya()) && (!com.tencent.mm.vfs.o.fB(((n)localObject2).field_filePath)))
          {
            ae.i(this.TAG, "error downloadFinish " + ((n)localObject2).Ya() + " ret:" + com.tencent.mm.vfs.o.fB(((n)localObject2).field_filePath));
            ((n)localObject2).epr();
            localObject3 = com.tencent.mm.plugin.story.f.j.BbE;
            j.b.elF().b((n)localObject2);
          }
          ae.i(this.TAG, "play " + ((dkg)localObject1).Id + ' ' + paramString + " start online play " + ((n)localObject2).field_filePath);
          reset();
          this.oNV.stop();
          this.oNV.setVideoCallback((h.a)this);
          this.Bxh = false;
          this.lxM = true;
          setNeedShowLoading(true);
          super.c(false, paramj.Bem.Url, (int)((dkg)localObject1).HSb);
          this.iuH = ((n)localObject2).field_filePath;
          paramj = s.BcG;
          this.iuG = s.cb(i, ((dkg)localObject1).Url);
          this.sessionId = paramString;
          this.hOz = bu.HQ();
          this.Bxl = 0L;
          start();
        }
      }
    }
    label964:
    ((View)paramj).setAlpha(0.0F);
    AppMethodBeat.o(120585);
  }
  
  public final boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(120606);
    p.h(paramPInt1, "start");
    p.h(paramPInt2, "end");
    Object localObject1 = "";
    paramPInt1.value = Math.max(paramInt, this.iuQ);
    if (this.iuK == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.iuR;
      localObject1 = "" + "step1;";
    }
    Object localObject2 = localObject1;
    if (this.iuK == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.iuR + 8);
      localObject2 = (String)localObject1 + "step2;";
    }
    if (this.iuK == 3)
    {
      paramPInt1.value = this.iuQ;
      paramPInt2.value = (paramInt + 1 + this.iuV.ivb);
      localObject1 = (String)localObject2 + "step3;";
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (paramPInt2.value >= this.iuM + 1)
      {
        paramPInt2.value = (this.iuM + 1);
        localObject2 = (String)localObject1 + "step5;";
      }
      if (paramPInt2.value >= paramPInt1.value) {
        break;
      }
      paramPInt1.value += this.iuV.ivb;
      AppMethodBeat.o(120606);
      return false;
      localObject1 = localObject2;
      if (this.iuK == 4)
      {
        paramPInt1.value = this.iuQ;
        paramPInt2.value = (this.iuR + paramInt + 1 + this.iuV.ivb);
        localObject1 = (String)localObject2 + "step4;";
      }
    }
    ae.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s] %s", new Object[] { bpA(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.iuK), Integer.valueOf(this.iuQ), Integer.valueOf(this.iuR), this.iuG, localObject2 });
    AppMethodBeat.o(120606);
    return true;
  }
  
  public final void aMT()
  {
    AppMethodBeat.i(120616);
    ae.i(this.TAG, "prepareVideo, surfaceAvailable:" + this.ydg);
    if (this.oNV != null)
    {
      localObject = this.oNV;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView");
        AppMethodBeat.o(120616);
        throw ((Throwable)localObject);
      }
      ((StoryVideoPlayTextureView)localObject).setNeedResetExtractor(cyZ());
    }
    Object localObject = this.iuH;
    p.g(localObject, "filepath");
    aDL((String)localObject);
    super.aMT();
    AppMethodBeat.o(120616);
  }
  
  public final void aMV()
  {
    AppMethodBeat.i(120615);
    super.aMV();
    ae.i(this.TAG, "onSurfaceAvailable");
    this.ydg = true;
    AppMethodBeat.o(120615);
  }
  
  public final void at(String paramString, int paramInt)
  {
    AppMethodBeat.i(120603);
    super.at(paramString, paramInt);
    AppMethodBeat.o(120603);
  }
  
  public final boolean bip()
  {
    AppMethodBeat.i(120595);
    if (this.Bxh)
    {
      AppMethodBeat.o(120595);
      return false;
    }
    boolean bool = super.bip();
    AppMethodBeat.o(120595);
    return bool;
  }
  
  public final void bpD()
  {
    AppMethodBeat.i(120610);
    super.bpD();
    Object localObject = this.oNV;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(120610);
      throw ((Throwable)localObject);
    }
    ((View)localObject).setAlpha(1.0F);
    String str;
    StringBuilder localStringBuilder;
    if (this.Bxl <= 0L)
    {
      this.Bxl = bu.aO(this.hOz);
      str = this.TAG;
      localStringBuilder = new StringBuilder("onTextureUpdate firstPlayWaitTime ").append(this.Bxl).append(" storyId: ");
      localObject = this.Bec;
      if (localObject == null) {
        break label131;
      }
    }
    label131:
    for (localObject = Long.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject).dLI);; localObject = null)
    {
      ae.i(str, localObject);
      AppMethodBeat.o(120610);
      return;
    }
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(224267);
    super.c(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(224267);
  }
  
  public final com.tencent.mm.pluginsdk.ui.tools.h cN(Context paramContext)
  {
    AppMethodBeat.i(120614);
    paramContext = new StoryVideoPlayTextureView(paramContext);
    paramContext.setOpenWithNoneSurface(true);
    paramContext.setNeedResetExtractor(cyZ());
    paramContext.setIsOnlineVideoType(true);
    paramContext = (com.tencent.mm.pluginsdk.ui.tools.h)paramContext;
    AppMethodBeat.o(120614);
    return paramContext;
  }
  
  public final void eX(boolean paramBoolean)
  {
    AppMethodBeat.i(120592);
    if (this.Bxh)
    {
      AppMethodBeat.o(120592);
      return;
    }
    super.eX(paramBoolean);
    AppMethodBeat.o(120592);
  }
  
  public final void eY(boolean paramBoolean)
  {
    AppMethodBeat.i(120593);
    ae.m(this.TAG, bpA() + " startTimer, isLocalVideo:" + this.Bxh, new Object[0]);
    if (!this.Bxh) {
      super.eY(paramBoolean);
    }
    AppMethodBeat.o(120593);
  }
  
  public final void eb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120602);
    super.eb(paramInt1, paramInt2);
    ae.i(this.TAG, "onGetVideoSize, mediaId:" + getMediaId() + ", isLocalVideo:" + this.Bxh + ", isPrepareVideo:" + this.iuS + ", isPrepared:" + this.Zn + ", playerStatus:" + this.iuK + ", downloadStatus:" + this.iuJ);
    AppMethodBeat.o(120602);
  }
  
  public final int eqi()
  {
    if (this.Fkg.AlH > this.Fkg.loT) {
      return (int)(this.Fkg.AlH - this.Fkg.loT);
    }
    return 0;
  }
  
  public final int eqj()
  {
    return this.Fkg.blockCount;
  }
  
  public final int eqk()
  {
    if (this.Fkg.blockCount > 0) {
      return (int)(this.Fkg.Fmh / this.Fkg.blockCount);
    }
    return 0;
  }
  
  public final int getErrorCode()
  {
    return this.Fkg.lFP;
  }
  
  public final String getFilePath()
  {
    AppMethodBeat.i(120612);
    String str = this.iuH;
    p.g(str, "filepath");
    AppMethodBeat.o(120612);
    return str;
  }
  
  public final long getFirstPlayWaitTime()
  {
    return this.Bxl;
  }
  
  public final String getSessionId()
  {
    AppMethodBeat.i(120587);
    String str = bu.nullAsNil(this.sessionId);
    p.g(str, "Util.nullAsNil(sessionId)");
    AppMethodBeat.o(120587);
    return str;
  }
  
  public final int getStayTime()
  {
    AppMethodBeat.i(120611);
    int i = (int)bu.aO(this.hOz);
    AppMethodBeat.o(120611);
    return i;
  }
  
  public final void i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(120601);
    if (!bu.lX(this.iuG, paramString))
    {
      AppMethodBeat.o(120601);
      return;
    }
    paramString = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("%s download  onProgress [%d, %d], pauseByLoadData:").append(this.iuP).append(", playStatus:").append(this.iuK).append(", currPosMs:").append(getCurrPosMs()).append(", isPlyaing:");
    com.tencent.mm.pluginsdk.ui.tools.h localh = this.oNV;
    p.g(localh, "videoView");
    ae.d(paramString, localh.isPlaying(), new Object[] { bpA(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (((getCurrPosMs() <= 0) || (this.iuK == 1) || (this.iuK == 0)) && (ql(getCurrPosSec()))) {
      eY(true);
    }
    AppMethodBeat.o(120601);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(120584);
    super.initView();
    Object localObject = com.tencent.mm.plugin.story.f.e.a.Beu;
    this.ukv = com.tencent.mm.plugin.story.f.e.a.gz(getContext());
    this.Bxk = new ImageView(getContext());
    localObject = this.Bxk;
    if (localObject != null) {
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    localObject = this.Bxk;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.lxA;
    FakeVideoViewLayer localFakeVideoViewLayer = this.ukv;
    if (localFakeVideoViewLayer == null) {
      p.bdF("fakeLayer");
    }
    ((RelativeLayout)localObject).addView((View)localFakeVideoViewLayer, new ViewGroup.LayoutParams(-1, -1));
    this.lxA.addView((View)this.Bxk, 0);
    this.rNj = ((TextView)findViewById(2131306403));
    AppMethodBeat.o(120584);
  }
  
  public final void o(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    Object localObject2 = null;
    AppMethodBeat.i(120589);
    ae.i(this.TAG, "resume, current play time:" + getCurrPosMs() + ", " + getCurrPosSec() + ", " + getVideoDurationSec() + ", isPrepared:" + this.Zn + ", sessionId:" + this.sessionId + ", isLocalVideo:" + this.Bxh);
    Object localObject1 = this.ukv;
    if (localObject1 == null) {
      p.bdF("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject1).qe(this.fOX);
    if (getCurrPosSec() >= getVideoDurationSec())
    {
      ae.i(this.TAG, "resume, restart video");
      if (paramj != null)
      {
        a(paramj, this.sessionId);
        AppMethodBeat.o(120589);
        return;
      }
    }
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checkResumeLocalVideo, isLocalVideo:").append(this.Bxh).append(", currentPosition:");
    localObject1 = this.oNV;
    int i;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getCurrentPosition());
      ae.i((String)localObject3, localObject1);
      if (!this.Bxh) {
        break label330;
      }
      localObject1 = this.oNV;
      if (localObject1 == null) {
        break label325;
      }
      i = ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getCurrentPosition();
      label263:
      if (i <= 0) {
        break label330;
      }
      localObject3 = this.oNV;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = Boolean.valueOf(((com.tencent.mm.pluginsdk.ui.tools.h)localObject3).start());
      }
      this.Bxi = false;
    }
    label325:
    label330:
    for (boolean bool = p.i(localObject1, Boolean.TRUE);; bool = false)
    {
      if (!bool) {
        break label335;
      }
      AppMethodBeat.o(120589);
      return;
      localObject1 = null;
      break;
      i = 0;
      break label263;
    }
    label335:
    if ((getCurrPosMs() > 0) && (!this.Bxh))
    {
      if (!this.Zn)
      {
        this.lxM = true;
        aMT();
        AppMethodBeat.o(120589);
        return;
      }
      super.play();
      AppMethodBeat.o(120589);
      return;
    }
    if (paramj != null) {
      a(paramj, this.sessionId);
    }
    AppMethodBeat.o(120589);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(120586);
    ae.i(this.TAG, "onCompletion, currPosMs:" + getCurrPosMs() + ", playStatus:" + this.iuK + ", downloadStatus:" + this.iuJ);
    if (getCurrPosMs() <= 0)
    {
      AppMethodBeat.o(120586);
      return;
    }
    i.b localb = this.ozA;
    if (localb != null) {
      localb.dt(getSessionId(), getMediaId());
    }
    super.onCompletion();
    AppMethodBeat.o(120586);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(120600);
    ae.i(this.TAG, "onUIDestroy, isLocalVideo:" + this.Bxh);
    FakeVideoViewLayer localFakeVideoViewLayer = this.ukv;
    if (localFakeVideoViewLayer == null) {
      p.bdF("fakeLayer");
    }
    localFakeVideoViewLayer.dKC();
    super.onUIDestroy();
    AppMethodBeat.o(120600);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(120598);
    ae.i(this.TAG, "onUIPause, isLocalVideo:" + this.Bxh);
    Object localObject = this.ukv;
    if (localObject == null) {
      p.bdF("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject).dKB();
    if (this.Bxh)
    {
      localObject = this.oNV;
      if (localObject != null)
      {
        ((com.tencent.mm.pluginsdk.ui.tools.h)localObject).pause();
        AppMethodBeat.o(120598);
        return;
      }
      AppMethodBeat.o(120598);
      return;
    }
    super.onUIPause();
    AppMethodBeat.o(120598);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(120599);
    ae.i(this.TAG, "onUIResume, isLocalVideo:" + this.Bxh);
    if (isPlaying())
    {
      FakeVideoViewLayer localFakeVideoViewLayer = this.ukv;
      if (localFakeVideoViewLayer == null) {
        p.bdF("fakeLayer");
      }
      localFakeVideoViewLayer.qe(this.fOX);
    }
    if (this.Bxh)
    {
      AppMethodBeat.o(120599);
      return;
    }
    super.onUIResume();
    AppMethodBeat.o(120599);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(120590);
    ae.i(this.TAG, "pause, isLocalVideo:" + this.Bxh);
    FakeVideoViewLayer localFakeVideoViewLayer = this.ukv;
    if (localFakeVideoViewLayer == null) {
      p.bdF("fakeLayer");
    }
    localFakeVideoViewLayer.dKB();
    if (this.Bxh)
    {
      this.Bxi = true;
      this.oNV.pause();
      AppMethodBeat.o(120590);
      return true;
    }
    boolean bool = super.pause();
    AppMethodBeat.o(120590);
    return bool;
  }
  
  public final boolean qm(int paramInt)
  {
    AppMethodBeat.i(120605);
    boolean bool = super.qm(paramInt);
    ae.i(this.TAG, "checkCanPlay, cachePlayTime:" + this.iuQ + ", ret:" + bool);
    AppMethodBeat.o(120605);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(120618);
    super.reset();
    this.ydg = false;
    this.sessionId = null;
    AppMethodBeat.o(120618);
  }
  
  public final void setFirstPlayWaitTime(long paramLong)
  {
    this.Bxl = paramLong;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(120588);
    super.setMute(paramBoolean);
    this.fOX = paramBoolean;
    if (this.oNV != null) {
      this.oNV.setMute(paramBoolean);
    }
    AppMethodBeat.o(120588);
  }
  
  public final void setNeedShowLoading(boolean paramBoolean)
  {
    AppMethodBeat.i(120596);
    ae.i(this.TAG, hashCode() + " setNeedShowLoading: " + paramBoolean);
    this.Bxg = paramBoolean;
    if (!this.Bxg) {
      hideLoading();
    }
    AppMethodBeat.o(120596);
  }
  
  public final void setScaleType(i.e parame)
  {
    AppMethodBeat.i(120613);
    super.setScaleType(parame);
    AppMethodBeat.o(120613);
  }
  
  public final void showLoading()
  {
    AppMethodBeat.i(120597);
    if (this.Bxg) {
      tO(800L);
    }
    AppMethodBeat.o(120597);
  }
  
  public final void start()
  {
    AppMethodBeat.i(120607);
    if ((this.bFv > 0) && (!this.Bxh))
    {
      ae.i(this.TAG, "start from onError and not local video");
      localObject = this.Bec;
      if (localObject != null)
      {
        s locals = s.BcG;
        localObject = s.a((com.tencent.mm.plugin.story.f.d.j)localObject);
        if (((n)localObject).Ya())
        {
          ae.i(this.TAG, "start from onError and download finish now");
          localObject = ((n)localObject).field_filePath;
          p.g(localObject, "videoCache.field_filePath");
          aDK((String)localObject);
          AppMethodBeat.o(120607);
          return;
        }
      }
    }
    Object localObject = this.iuH;
    p.g(localObject, "filepath");
    aDL((String)localObject);
    super.start();
    AppMethodBeat.o(120607);
  }
  
  public final void stop()
  {
    final long l = 1L;
    AppMethodBeat.i(120608);
    for (;;)
    {
      try
      {
        Object localObject1 = this.ukv;
        if (localObject1 == null) {
          p.bdF("fakeLayer");
        }
        ((FakeVideoViewLayer)localObject1).dKC();
        if (this.Bxh)
        {
          final hp localhp = new hp();
          localObject1 = this.Bec;
          if (localObject1 == null) {
            break label362;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject1).dLI);
          localObject1 = localhp.qy(String.valueOf(localObject1));
          com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.BjR;
          localObject1 = ((hp)localObject1).mz(com.tencent.mm.plugin.story.h.h.enI().TH());
          localh = com.tencent.mm.plugin.story.h.h.BjR;
          if (com.tencent.mm.plugin.story.h.h.enI().TM() != 1L) {
            break label367;
          }
          localObject1 = ((hp)localObject1).mB(l).mE(this.Bxl).mI(getStayTime()).mJ(getErrorCode()).ng(1L);
          localh = com.tencent.mm.plugin.story.h.h.BjR;
          localObject1 = ((hp)localObject1).nh(com.tencent.mm.plugin.story.h.h.enI().TG());
          localh = com.tencent.mm.plugin.story.h.h.BjR;
          ((hp)localObject1).ni(com.tencent.mm.plugin.story.h.h.enI().TJ()).mD(getCurrPosMs());
          ae.d(this.TAG, "time distance %d", new Object[] { Long.valueOf(System.currentTimeMillis() - localhp.UH()) });
          if (System.currentTimeMillis() - localhp.UH() >= 500L)
          {
            localObject1 = this.Bec;
            if (localObject1 == null) {
              break label372;
            }
            l = ((com.tencent.mm.plugin.story.f.d.j)localObject1).dLI;
          }
          try
          {
            localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
            j.b.dJc().post((Runnable)new c(this, localhp, l));
            this.oNV.stop();
            reset();
            localObject1 = this.Bxk;
            if (localObject1 == null) {
              break label355;
            }
            ((ImageView)localObject1).setVisibility(8);
            AppMethodBeat.o(120608);
            return;
          }
          catch (Exception localException1)
          {
            ae.printErrStackTrace(this.TAG, (Throwable)localException1, "reportStopLocalVideo", new Object[0]);
            localhp.aLH();
            continue;
          }
        }
        super.stop();
      }
      catch (Exception localException2)
      {
        ae.printErrStackTrace(this.TAG, (Throwable)localException2, "stop error", new Object[0]);
        AppMethodBeat.o(120608);
        return;
      }
      continue;
      label355:
      AppMethodBeat.o(120608);
      return;
      label362:
      Object localObject2 = null;
      continue;
      label367:
      l = 0L;
      continue;
      label372:
      l = 0L;
    }
  }
  
  public final void stopTimer()
  {
    AppMethodBeat.i(120594);
    ae.m(this.TAG, bpA() + " stopTimer, isLocalVideo:" + this.Bxh, new Object[0]);
    super.stopTimer();
    AppMethodBeat.o(120594);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView$playLocalVideo$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-story_release"})
  public static final class b
    implements h.a
  {
    public final int eU(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120582);
      com.tencent.mm.plugin.story.f.d.j localj = StoryVideoView.c(this.Bxn);
      if ((localj != null) && (localj.emu() == true) && (StoryVideoView.e(this.Bxn) > 0L) && (paramInt1 >= StoryVideoView.e(this.Bxn)))
      {
        ae.i(StoryVideoView.a(this.Bxn), "fakeVideo exceed endTime, playTime:" + paramInt1 + ", fakeEndTime:" + StoryVideoView.e(this.Bxn) + ", fakeStartTime:" + StoryVideoView.d(this.Bxn));
        if (StoryVideoView.d(this.Bxn) <= 0L) {
          break label146;
        }
        StoryVideoView.f(this.Bxn).d(StoryVideoView.d(this.Bxn), true);
      }
      for (;;)
      {
        AppMethodBeat.o(120582);
        return 0;
        label146:
        StoryVideoView.f(this.Bxn).d(0.0D, true);
      }
    }
    
    public final void eb(int paramInt1, int paramInt2) {}
    
    public final void onCompletion()
    {
      AppMethodBeat.i(120581);
      String str = StoryVideoView.a(this.Bxn);
      StringBuilder localStringBuilder = new StringBuilder("localVideo onCompleted, isFakeVideo:");
      Object localObject = StoryVideoView.c(this.Bxn);
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject).emu());
        ae.i(str, localObject + ", fakeStartTime:" + StoryVideoView.d(this.Bxn));
        localObject = StoryVideoView.c(this.Bxn);
        if ((localObject == null) || (((com.tencent.mm.plugin.story.f.d.j)localObject).emu() != true) || (StoryVideoView.d(this.Bxn) <= 0L)) {
          break label166;
        }
        StoryVideoView.f(this.Bxn).d(StoryVideoView.d(this.Bxn), true);
      }
      for (;;)
      {
        localObject = StoryVideoView.h(this.Bxn);
        if (localObject == null) {
          break label183;
        }
        ((i.b)localObject).dt(this.Bxn.getSessionId(), StoryVideoView.i(this.Bxn));
        AppMethodBeat.o(120581);
        return;
        localObject = null;
        break;
        label166:
        StoryVideoView.f(this.Bxn).d(0.0D, true);
      }
      label183:
      AppMethodBeat.o(120581);
    }
    
    public final void onError(int paramInt1, int paramInt2) {}
    
    public final void ta()
    {
      AppMethodBeat.i(120580);
      String str = StoryVideoView.a(this.Bxn);
      StringBuilder localStringBuilder = new StringBuilder("localVideo onPrepared, isLocalVideoPause:").append(StoryVideoView.b(this.Bxn)).append(", isFakeVideo:");
      Object localObject = StoryVideoView.c(this.Bxn);
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject).emu());
        ae.i(str, localObject + ", fakeStartTime:" + StoryVideoView.d(this.Bxn) + ", fakeEndTime:" + StoryVideoView.e(this.Bxn));
        if (!StoryVideoView.b(this.Bxn))
        {
          localObject = StoryVideoView.c(this.Bxn);
          if ((localObject == null) || (((com.tencent.mm.plugin.story.f.d.j)localObject).emu() != true) || (StoryVideoView.d(this.Bxn) <= 0L)) {
            break label197;
          }
          StoryVideoView.f(this.Bxn).d(StoryVideoView.d(this.Bxn), true);
        }
      }
      for (;;)
      {
        StoryVideoView.f(this.Bxn).setOneTimeVideoTextureUpdateCallback((h.e)new a(this));
        AppMethodBeat.o(120580);
        return;
        localObject = null;
        break;
        label197:
        StoryVideoView.f(this.Bxn).start();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onTextureUpdate"})
    static final class a
      implements h.e
    {
      a(StoryVideoView.b paramb) {}
      
      public final void bpD()
      {
        AppMethodBeat.i(120579);
        this.Bxo.Bxn.setFirstPlayWaitTime(bu.aO(StoryVideoView.g(this.Bxo.Bxn)));
        com.tencent.mm.sdk.platformtools.ar.o((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(120578);
            ae.i(StoryVideoView.a(this.Bxp.Bxo.Bxn), "onTextureUpdate");
            if (StoryVideoView.f(this.Bxp.Bxo.Bxn) == null)
            {
              AppMethodBeat.o(120578);
              return;
            }
            this.Bxp.Bxo.Bxn.hideLoading();
            Object localObject = StoryVideoView.f(this.Bxp.Bxo.Bxn);
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type android.view.View");
              AppMethodBeat.o(120578);
              throw ((Throwable)localObject);
            }
            ((View)localObject).setAlpha(1.0F);
            AppMethodBeat.o(120578);
          }
        }, 50L);
        AppMethodBeat.o(120579);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(StoryVideoView paramStoryVideoView, hp paramhp, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(120583);
      ae.i(StoryVideoView.a(this.Bxn), "reportStopLocalVideo");
      com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.e.ayN(StoryVideoView.j(this.Bxn));
      if (locala != null)
      {
        hp localhp = localhp.mC(locala.videoDuration);
        j.b localb = com.tencent.mm.plugin.story.f.j.BbE;
        localhp.mA(j.b.elB().Bw(l)).mK(locala.videoBitrate).aLH();
      }
      AppMethodBeat.o(120583);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoView
 * JD-Core Version:    0.7.0.1
 */