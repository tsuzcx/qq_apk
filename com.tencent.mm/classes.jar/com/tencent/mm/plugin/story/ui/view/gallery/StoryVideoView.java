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
import com.tencent.mm.f.b.a.lx;
import com.tencent.mm.f.b.a.oc;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.MMVideoView.a;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.f.e.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.pluginsdk.ui.tools.k.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ax;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView;", "Lcom/tencent/mm/modelvideo/MMVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "C_TAG", "", "fakeBlurLayer", "Landroid/widget/ImageView;", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "firstPlayWaitTime", "", "getFirstPlayWaitTime", "()J", "setFirstPlayWaitTime", "(J)V", "isFakeVideo", "", "isLocalVideo", "isLocalVideoPause", "isMute", "needShowLoading", "sessionId", "startPlayTime", "surfaceAvailable", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "videoTips", "Landroid/widget/TextView;", "avgBlockTime", "", "blockCount", "calcDownloadRange", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "checkCanPlay", "checkLandscape", "", "blurBgPath", "checkNeedReset", "checkResumeLocalVideo", "createVideoView", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView;", "mContext", "fakeEndTime", "fakeStartTime", "getErrorCode", "getFilePath", "getSessionId", "getStayTime", "initView", "isLive", "isShowLoading", "moovCostTime", "onCompletion", "onFinish", "mediaId", "ret", "onGetVideoSize", "width", "height", "onProgress", "offset", "total", "onSeekComplete", "startPlay", "onSurfaceAvailable", "onTextureUpdate", "onUIDestroy", "onUIPause", "onUIResume", "pause", "play", "item", "playLocalVideo", "videoPath", "prepareVideo", "reportStopLocalVideo", "reset", "resume", "storyVideoItem", "setMute", "mute", "setNeedShowLoading", "show", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoPath", "url", "durationSec", "showDebugInfo", "path", "showLoading", "startTimer", "rightNow", "stop", "stopTimer", "Companion", "plugin-story_release"})
public final class StoryVideoView
  extends MMVideoView
{
  public static final a MbX;
  private FakeVideoViewLayer CGO;
  private boolean IaH;
  private com.tencent.mm.plugin.story.f.d.j LIV;
  private final String MbQ;
  private boolean MbR;
  boolean MbS;
  private boolean MbT;
  private boolean MbU;
  private ImageView MbV;
  private long MbW;
  private boolean iYs;
  private long lzJ;
  private String sessionId;
  private TextView wTs;
  
  static
  {
    AppMethodBeat.i(120621);
    MbX = new a((byte)0);
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
    this.MbQ = "MicroMsg.StoryVideoView";
    paramContext = com.tencent.mm.plugin.story.f.j.LGA;
    setRootPath(u.n(j.b.getAccStoryPath(), true));
    fhw();
    setIsShowBasicControls(false);
    paramContext = this.pDN;
    p.j(paramContext, "footerRoot");
    paramContext.setVisibility(8);
    this.TAG = this.MbQ;
    this.MbR = true;
    AppMethodBeat.o(120619);
  }
  
  private final void bdJ(String paramString)
  {
    AppMethodBeat.i(120591);
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("playLocalVideo: ").append(paramString).append(", isPlayingNow:");
    com.tencent.mm.pluginsdk.ui.tools.k localk = this.txH;
    p.j(localk, "videoView");
    Log.i((String)localObject1, localk.isPlaying());
    if (this.txH == null) {
      this.txH = df(getContext());
    }
    reset();
    localObject1 = this.txH;
    if (localObject1 != null) {
      ((com.tencent.mm.pluginsdk.ui.tools.k)localObject1).stop();
    }
    localObject1 = this.txH;
    if (localObject1 != null) {
      if (!this.iYs)
      {
        if (!this.MbU) {
          break label204;
        }
        localObject2 = this.CGO;
        if (localObject2 == null) {
          p.bGy("fakeLayer");
        }
        if (!((FakeVideoViewLayer)localObject2).HVi) {
          break label204;
        }
      }
    }
    label204:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.pluginsdk.ui.tools.k)localObject1).setMute(bool);
      this.bjq = false;
      this.MbS = true;
      setDownloadStatus(3);
      setNeedShowLoading(false);
      localObject1 = this.txH;
      if (localObject1 != null) {
        break;
      }
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView");
      AppMethodBeat.o(120591);
      throw paramString;
    }
    ((StoryVideoPlayTextureView)localObject1).setNeedResetExtractor(dmk());
    localObject1 = this.txH;
    p.j(localObject1, "videoView");
    ((com.tencent.mm.pluginsdk.ui.tools.k)localObject1).setVideoPath(paramString);
    this.lzJ = Util.currentTicks();
    this.MbW = 0L;
    localObject1 = com.tencent.mm.plugin.story.f.k.LGJ;
    localObject1 = this.LIV;
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
    com.tencent.mm.plugin.story.f.k.bcV((String)localObject1);
    this.txH.setVideoCallback((k.a)new b(this));
    this.MbT = false;
    this.sessionId = null;
    bdK(paramString);
    AppMethodBeat.o(120591);
  }
  
  private final void bdK(String paramString)
  {
    AppMethodBeat.i(120617);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.VmY, Integer.valueOf(0));
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(120617);
      throw paramString;
    }
    if (((Integer)localObject).intValue() == 1)
    {
      localObject = this.wTs;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.sight.base.f.aPw(paramString));
      }
      paramString = this.wTs;
      if (paramString != null)
      {
        paramString.setVisibility(0);
        AppMethodBeat.o(120617);
        return;
      }
    }
    AppMethodBeat.o(120617);
  }
  
  private final boolean dmk()
  {
    AppMethodBeat.i(120604);
    if (this.MbS)
    {
      AppMethodBeat.o(120604);
      return false;
    }
    try
    {
      boolean bool = com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.Vos, false);
      AppMethodBeat.o(120604);
      return bool;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "check need reset error", new Object[0]);
      AppMethodBeat.o(120604);
    }
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.story.f.d.j paramj, String paramString)
  {
    AppMethodBeat.i(120585);
    p.k(paramj, "item");
    Object localObject1 = this.wTs;
    if (localObject1 != null) {
      ((TextView)localObject1).setVisibility(8);
    }
    this.LIV = paramj;
    localObject1 = paramj.LJf;
    int i = paramj.createTime;
    this.MbU = false;
    Object localObject2 = this.CGO;
    if (localObject2 == null) {
      p.bGy("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject2).setVisibility(8);
    localObject2 = this.MbV;
    if (localObject2 != null) {
      ((ImageView)localObject2).setVisibility(8);
    }
    if (!paramj.gdq())
    {
      Log.i(this.TAG, "play empty item");
      showLoading();
      AppMethodBeat.o(120585);
      return;
    }
    if (paramj.gdp())
    {
      this.MbU = true;
      Log.i(this.TAG, "LogStory: play fake video");
      paramString = this.CGO;
      if (paramString == null) {
        p.bGy("fakeLayer");
      }
      paramString.setVisibility(0);
      paramj = paramj.LJg;
      if (paramj != null)
      {
        paramString = paramj.field_blurBgPath;
        p.j(paramString, "fakeData.field_blurBgPath");
        localObject1 = (CharSequence)paramString;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label379;
        }
        i = 1;
        if (i != 0) {
          break label384;
        }
        localObject1 = ax.au(getContext());
        paramString = BitmapUtil.extractThumbNail(paramString, ((Point)localObject1).y, ((Point)localObject1).x, true);
        localObject1 = this.MbV;
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageBitmap(paramString);
        }
        paramString = this.MbV;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        label268:
        paramString = this.CGO;
        if (paramString == null) {
          p.bGy("fakeLayer");
        }
        paramString.setFakeVideoInfo(paramj);
        paramString = this.CGO;
        if (paramString == null) {
          p.bGy("fakeLayer");
        }
        paramString.wR(this.iYs);
        this.mfv = paramj.fuN().videoPath;
        this.mfu = "";
        paramj = this.mfv;
        p.j(paramj, "filepath");
        bdJ(paramj);
      }
    }
    for (;;)
    {
      setLoop(true);
      paramj = this.txH;
      if (paramj != null) {
        break label964;
      }
      paramj = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(120585);
      throw paramj;
      label379:
      i = 0;
      break;
      label384:
      paramString = this.MbV;
      if (paramString == null) {
        break label268;
      }
      paramString.setVisibility(8);
      break label268;
      Log.i(this.TAG, "LogStory: play normal video");
      localObject2 = s.LHA;
      Object localObject3 = s.a((enu)localObject1);
      if (u.bBQ((String)localObject3) > 0L)
      {
        Log.i(this.TAG, "play " + (String)localObject3 + " downloadDone now can play " + ((enu)localObject1).Id);
        this.mfv = ((String)localObject3);
        if (localObject3 != null) {
          bdJ((String)localObject3);
        }
      }
      else
      {
        localObject2 = s.LHA;
        localObject2 = s.a(paramj);
        int j = (int)u.bBQ(((n)localObject2).field_filePath);
        Log.i(this.TAG, "play " + (String)localObject3 + " error try play from url or videoCache " + ((enu)localObject1).Id + " fileLength:" + j + " cacheSize:" + ((n)localObject2).field_cacheSize);
        if (j < ((n)localObject2).field_cacheSize)
        {
          ((n)localObject2).field_cacheSize = j;
          localObject3 = com.tencent.mm.plugin.story.f.j.LGA;
          j.b.gcA().b((n)localObject2);
        }
        Log.i(this.TAG, String.valueOf(localObject2));
        if ((((n)localObject2).arM()) && (u.agG(((n)localObject2).field_filePath)))
        {
          Log.i(this.TAG, "play " + ((enu)localObject1).Id + " download finish");
          this.mfv = ((n)localObject2).field_filePath;
          paramj = s.LHA;
          this.mfu = s.cs(i, ((enu)localObject1).Url);
          paramj = this.mfv;
          p.j(paramj, "filepath");
          bdJ(paramj);
        }
        else
        {
          if ((((n)localObject2).arM()) && (!u.agG(((n)localObject2).field_filePath)))
          {
            Log.i(this.TAG, "error downloadFinish " + ((n)localObject2).arM() + " ret:" + u.agG(((n)localObject2).field_filePath));
            ((n)localObject2).ggn();
            localObject3 = com.tencent.mm.plugin.story.f.j.LGA;
            j.b.gcA().b((n)localObject2);
          }
          Log.i(this.TAG, "play " + ((enu)localObject1).Id + ' ' + paramString + " start online play " + ((n)localObject2).field_filePath);
          reset();
          this.txH.stop();
          this.txH.setVideoCallback((k.a)this);
          this.MbS = false;
          this.pDW = true;
          setNeedShowLoading(true);
          super.c(false, paramj.LJf.Url, (int)((enu)localObject1).UqC);
          this.mfv = ((n)localObject2).field_filePath;
          paramj = s.LHA;
          this.mfu = s.cs(i, ((enu)localObject1).Url);
          this.sessionId = paramString;
          this.lzJ = Util.currentTicks();
          this.MbW = 0L;
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
    p.k(paramPInt1, "start");
    p.k(paramPInt2, "end");
    Object localObject1 = "";
    paramPInt1.value = Math.max(paramInt, this.mfD);
    if (this.mfx == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.mfE;
      localObject1 = "" + "step1;";
    }
    Object localObject2 = localObject1;
    if (this.mfx == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.mfE + 8);
      localObject2 = (String)localObject1 + "step2;";
    }
    if (this.mfx == 3)
    {
      paramPInt1.value = this.mfD;
      paramPInt2.value = (paramInt + 1 + this.mfI.mfO);
      localObject1 = (String)localObject2 + "step3;";
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (paramPInt2.value >= this.mfz + 1)
      {
        paramPInt2.value = (this.mfz + 1);
        localObject2 = (String)localObject1 + "step5;";
      }
      if (paramPInt2.value >= paramPInt1.value) {
        break;
      }
      paramPInt1.value += this.mfI.mfO;
      AppMethodBeat.o(120606);
      return false;
      localObject1 = localObject2;
      if (this.mfx == 4)
      {
        paramPInt1.value = this.mfD;
        paramPInt2.value = (this.mfE + paramInt + 1 + this.mfI.mfO);
        localObject1 = (String)localObject2 + "step4;";
      }
    }
    Log.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s] %s", new Object[] { bqf(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.mfx), Integer.valueOf(this.mfD), Integer.valueOf(this.mfE), this.mfu, localObject2 });
    AppMethodBeat.o(120606);
    return true;
  }
  
  public final void aP(String paramString, int paramInt)
  {
    AppMethodBeat.i(120603);
    super.aP(paramString, paramInt);
    AppMethodBeat.o(120603);
  }
  
  public final void bXh()
  {
    AppMethodBeat.i(120610);
    super.bXh();
    Object localObject = this.txH;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(120610);
      throw ((Throwable)localObject);
    }
    ((View)localObject).setAlpha(1.0F);
    String str;
    StringBuilder localStringBuilder;
    if (this.MbW <= 0L)
    {
      this.MbW = Util.ticksToNow(this.lzJ);
      str = this.TAG;
      localStringBuilder = new StringBuilder("onTextureUpdate firstPlayWaitTime ").append(this.MbW).append(" storyId: ");
      localObject = this.LIV;
      if (localObject == null) {
        break label131;
      }
    }
    label131:
    for (localObject = Long.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject).fXG);; localObject = null)
    {
      Log.i(str, localObject);
      AppMethodBeat.o(120610);
      return;
    }
  }
  
  public final void bqm()
  {
    AppMethodBeat.i(120616);
    Log.i(this.TAG, "prepareVideo, surfaceAvailable:" + this.IaH);
    if (this.txH != null)
    {
      localObject = this.txH;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView");
        AppMethodBeat.o(120616);
        throw ((Throwable)localObject);
      }
      ((StoryVideoPlayTextureView)localObject).setNeedResetExtractor(dmk());
    }
    Object localObject = this.mfv;
    p.j(localObject, "filepath");
    bdK((String)localObject);
    super.bqm();
    AppMethodBeat.o(120616);
  }
  
  public final void bqp()
  {
    AppMethodBeat.i(120615);
    super.bqp();
    Log.i(this.TAG, "onSurfaceAvailable");
    this.IaH = true;
    AppMethodBeat.o(120615);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(292717);
    super.c(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(292717);
  }
  
  public final com.tencent.mm.pluginsdk.ui.tools.k df(Context paramContext)
  {
    AppMethodBeat.i(120614);
    paramContext = new StoryVideoPlayTextureView(paramContext);
    paramContext.setOpenWithNoneSurface(true);
    paramContext.setNeedResetExtractor(dmk());
    paramContext.setIsOnlineVideoType(true);
    paramContext = (com.tencent.mm.pluginsdk.ui.tools.k)paramContext;
    AppMethodBeat.o(120614);
    return paramContext;
  }
  
  public final void eM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120602);
    super.eM(paramInt1, paramInt2);
    Log.i(this.TAG, "onGetVideoSize, mediaId:" + getMediaId() + ", isLocalVideo:" + this.MbS + ", isPrepareVideo:" + this.mfF + ", isPrepared:" + this.gX + ", playerStatus:" + this.mfx + ", downloadStatus:" + this.mfw);
    AppMethodBeat.o(120602);
  }
  
  public final void gA(boolean paramBoolean)
  {
    AppMethodBeat.i(120593);
    Log.printInfoStack(this.TAG, bqf() + " startTimer, isLocalVideo:" + this.MbS, new Object[0]);
    if (!this.MbS) {
      super.gA(paramBoolean);
    }
    AppMethodBeat.o(120593);
  }
  
  public final int getErrorCode()
  {
    return this.RbC.pOs;
  }
  
  public final String getFilePath()
  {
    AppMethodBeat.i(120612);
    String str = this.mfv;
    p.j(str, "filepath");
    AppMethodBeat.o(120612);
    return str;
  }
  
  public final long getFirstPlayWaitTime()
  {
    return this.MbW;
  }
  
  public final String getSessionId()
  {
    AppMethodBeat.i(120587);
    String str = Util.nullAsNil(this.sessionId);
    p.j(str, "Util.nullAsNil(sessionId)");
    AppMethodBeat.o(120587);
    return str;
  }
  
  public final int getStayTime()
  {
    AppMethodBeat.i(120611);
    int i = (int)Util.ticksToNow(this.lzJ);
    AppMethodBeat.o(120611);
    return i;
  }
  
  public final int ghf()
  {
    if (this.RbC.KIk > this.RbC.ptY) {
      return (int)(this.RbC.KIk - this.RbC.ptY);
    }
    return 0;
  }
  
  public final int ghg()
  {
    return this.RbC.blockCount;
  }
  
  public final int ghh()
  {
    if (this.RbC.blockCount > 0) {
      return (int)(this.RbC.RdF / this.RbC.blockCount);
    }
    return 0;
  }
  
  public final void gz(boolean paramBoolean)
  {
    AppMethodBeat.i(120592);
    if (this.MbS)
    {
      AppMethodBeat.o(120592);
      return;
    }
    super.gz(paramBoolean);
    AppMethodBeat.o(120592);
  }
  
  public final void h(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(120601);
    if (!Util.isEqual(this.mfu, paramString))
    {
      AppMethodBeat.o(120601);
      return;
    }
    paramString = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("%s download  onProgress [%d, %d], pauseByLoadData:").append(this.mfC).append(", playStatus:").append(this.mfx).append(", currPosMs:").append(getCurrPosMs()).append(", isPlyaing:");
    com.tencent.mm.pluginsdk.ui.tools.k localk = this.txH;
    p.j(localk, "videoView");
    Log.d(paramString, localk.isPlaying(), new Object[] { bqf(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (((getCurrPosMs() <= 0) || (this.mfx == 1) || (this.mfx == 0)) && (xa(getCurrPosSec()))) {
      gA(true);
    }
    AppMethodBeat.o(120601);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(120584);
    super.initView();
    Object localObject = a.LJn;
    this.CGO = a.il(getContext());
    this.MbV = new ImageView(getContext());
    localObject = this.MbV;
    if (localObject != null) {
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    localObject = this.MbV;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.pDK;
    FakeVideoViewLayer localFakeVideoViewLayer = this.CGO;
    if (localFakeVideoViewLayer == null) {
      p.bGy("fakeLayer");
    }
    ((RelativeLayout)localObject).addView((View)localFakeVideoViewLayer, new ViewGroup.LayoutParams(-1, -1));
    this.pDK.addView((View)this.MbV, 0);
    this.wTs = ((TextView)findViewById(a.d.video_tips));
    AppMethodBeat.o(120584);
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(120595);
    if (this.MbS)
    {
      AppMethodBeat.o(120595);
      return false;
    }
    boolean bool = super.isLive();
    AppMethodBeat.o(120595);
    return bool;
  }
  
  public final void o(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    Object localObject2 = null;
    AppMethodBeat.i(120589);
    Log.i(this.TAG, "resume, current play time:" + getCurrPosMs() + ", " + getCurrPosSec() + ", " + getVideoDurationSec() + ", isPrepared:" + this.gX + ", sessionId:" + this.sessionId + ", isLocalVideo:" + this.MbS);
    Object localObject1 = this.CGO;
    if (localObject1 == null) {
      p.bGy("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject1).wR(this.iYs);
    if (getCurrPosSec() >= getVideoDurationSec())
    {
      Log.i(this.TAG, "resume, restart video");
      if (paramj != null)
      {
        a(paramj, this.sessionId);
        AppMethodBeat.o(120589);
        return;
      }
    }
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checkResumeLocalVideo, isLocalVideo:").append(this.MbS).append(", currentPosition:");
    localObject1 = this.txH;
    int i;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.k)localObject1).getCurrentPosition());
      Log.i((String)localObject3, localObject1);
      if (!this.MbS) {
        break label330;
      }
      localObject1 = this.txH;
      if (localObject1 == null) {
        break label325;
      }
      i = ((com.tencent.mm.pluginsdk.ui.tools.k)localObject1).getCurrentPosition();
      label263:
      if (i <= 0) {
        break label330;
      }
      localObject3 = this.txH;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = Boolean.valueOf(((com.tencent.mm.pluginsdk.ui.tools.k)localObject3).start());
      }
      this.MbT = false;
    }
    label325:
    label330:
    for (boolean bool = p.h(localObject1, Boolean.TRUE);; bool = false)
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
    if ((getCurrPosMs() > 0) && (!this.MbS))
    {
      if (!this.gX)
      {
        this.pDW = true;
        bqm();
        AppMethodBeat.o(120589);
        return;
      }
      super.bqo();
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
    Log.i(this.TAG, "onCompletion, currPosMs:" + getCurrPosMs() + ", playStatus:" + this.mfx + ", downloadStatus:" + this.mfw);
    if (getCurrPosMs() <= 0)
    {
      AppMethodBeat.o(120586);
      return;
    }
    i.b localb = this.sUh;
    if (localb != null) {
      localb.dT(getSessionId(), getMediaId());
    }
    super.onCompletion();
    AppMethodBeat.o(120586);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(120600);
    Log.i(this.TAG, "onUIDestroy, isLocalVideo:" + this.MbS);
    FakeVideoViewLayer localFakeVideoViewLayer = this.CGO;
    if (localFakeVideoViewLayer == null) {
      p.bGy("fakeLayer");
    }
    localFakeVideoViewLayer.fxU();
    super.onUIDestroy();
    AppMethodBeat.o(120600);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(120598);
    Log.i(this.TAG, "onUIPause, isLocalVideo:" + this.MbS);
    Object localObject = this.CGO;
    if (localObject == null) {
      p.bGy("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject).fxT();
    if (this.MbS)
    {
      localObject = this.txH;
      if (localObject != null)
      {
        ((com.tencent.mm.pluginsdk.ui.tools.k)localObject).pause();
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
    Log.i(this.TAG, "onUIResume, isLocalVideo:" + this.MbS);
    if (isPlaying())
    {
      FakeVideoViewLayer localFakeVideoViewLayer = this.CGO;
      if (localFakeVideoViewLayer == null) {
        p.bGy("fakeLayer");
      }
      localFakeVideoViewLayer.wR(this.iYs);
    }
    if (this.MbS)
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
    Log.i(this.TAG, "pause, isLocalVideo:" + this.MbS);
    FakeVideoViewLayer localFakeVideoViewLayer = this.CGO;
    if (localFakeVideoViewLayer == null) {
      p.bGy("fakeLayer");
    }
    localFakeVideoViewLayer.fxT();
    if (this.MbS)
    {
      this.MbT = true;
      this.txH.pause();
      AppMethodBeat.o(120590);
      return true;
    }
    boolean bool = super.pause();
    AppMethodBeat.o(120590);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(120618);
    super.reset();
    this.IaH = false;
    this.sessionId = null;
    AppMethodBeat.o(120618);
  }
  
  public final void setFirstPlayWaitTime(long paramLong)
  {
    this.MbW = paramLong;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(120588);
    super.setMute(paramBoolean);
    this.iYs = paramBoolean;
    if (this.txH != null) {
      this.txH.setMute(paramBoolean);
    }
    AppMethodBeat.o(120588);
  }
  
  public final void setNeedShowLoading(boolean paramBoolean)
  {
    AppMethodBeat.i(120596);
    Log.i(this.TAG, hashCode() + " setNeedShowLoading: " + paramBoolean);
    this.MbR = paramBoolean;
    if (!this.MbR) {
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
    if (this.MbR) {
      Ic(800L);
    }
    AppMethodBeat.o(120597);
  }
  
  public final void start()
  {
    AppMethodBeat.i(120607);
    if ((this.bpq > 0) && (!this.MbS))
    {
      Log.i(this.TAG, "start from onError and not local video");
      localObject = this.LIV;
      if (localObject != null)
      {
        s locals = s.LHA;
        localObject = s.a((com.tencent.mm.plugin.story.f.d.j)localObject);
        if (((n)localObject).arM())
        {
          Log.i(this.TAG, "start from onError and download finish now");
          localObject = ((n)localObject).field_filePath;
          p.j(localObject, "videoCache.field_filePath");
          bdJ((String)localObject);
          AppMethodBeat.o(120607);
          return;
        }
      }
    }
    Object localObject = this.mfv;
    p.j(localObject, "filepath");
    bdK((String)localObject);
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
        Object localObject1 = this.CGO;
        if (localObject1 == null) {
          p.bGy("fakeLayer");
        }
        ((FakeVideoViewLayer)localObject1).fxU();
        if (this.MbS)
        {
          final oc localoc = new oc();
          localObject1 = this.LIV;
          if (localObject1 == null) {
            break label362;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject1).fXG);
          localObject1 = localoc.EK(String.valueOf(localObject1));
          com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.LOJ;
          localObject1 = ((oc)localObject1).zO(com.tencent.mm.plugin.story.h.h.geE().amS());
          localh = com.tencent.mm.plugin.story.h.h.LOJ;
          if (com.tencent.mm.plugin.story.h.h.geE().amX() != 1L) {
            break label367;
          }
          localObject1 = ((oc)localObject1).zQ(l).zT(this.MbW).zX(getStayTime()).zY(getErrorCode()).Av(1L);
          localh = com.tencent.mm.plugin.story.h.h.LOJ;
          localObject1 = ((oc)localObject1).Aw(com.tencent.mm.plugin.story.h.h.geE().amR());
          localh = com.tencent.mm.plugin.story.h.h.LOJ;
          ((oc)localObject1).Ax(com.tencent.mm.plugin.story.h.h.geE().amU()).zS(getCurrPosMs());
          Log.d(this.TAG, "time distance %d", new Object[] { Long.valueOf(System.currentTimeMillis() - localoc.aob()) });
          if (System.currentTimeMillis() - localoc.aob() >= 500L)
          {
            localObject1 = this.LIV;
            if (localObject1 == null) {
              break label372;
            }
            l = ((com.tencent.mm.plugin.story.f.d.j)localObject1).fXG;
          }
          try
          {
            localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
            j.b.fwa().post((Runnable)new c(this, localoc, l));
            this.txH.stop();
            reset();
            localObject1 = this.MbV;
            if (localObject1 == null) {
              break label355;
            }
            ((ImageView)localObject1).setVisibility(8);
            AppMethodBeat.o(120608);
            return;
          }
          catch (Exception localException1)
          {
            Log.printErrStackTrace(this.TAG, (Throwable)localException1, "reportStopLocalVideo", new Object[0]);
            localoc.bpa();
            continue;
          }
        }
        super.stop();
      }
      catch (Exception localException2)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)localException2, "stop error", new Object[0]);
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
    Log.printInfoStack(this.TAG, bqf() + " stopTimer, isLocalVideo:" + this.MbS, new Object[0]);
    super.stopTimer();
    AppMethodBeat.o(120594);
  }
  
  public final boolean xb(int paramInt)
  {
    AppMethodBeat.i(120605);
    boolean bool = super.xb(paramInt);
    Log.i(this.TAG, "checkCanPlay, cachePlayTime:" + this.mfD + ", ret:" + bool);
    AppMethodBeat.o(120605);
    return bool;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView$Companion;", "", "()V", "PRELOAD_CACHE", "", "PRELOAD_CACHE_GOOD_NETWORK", "plugin-story_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView$playLocalVideo$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-story_release"})
  public static final class b
    implements k.a
  {
    public final void eM(int paramInt1, int paramInt2) {}
    
    public final int fE(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120582);
      com.tencent.mm.plugin.story.f.d.j localj = StoryVideoView.c(this.MbY);
      if ((localj != null) && (localj.gdp() == true) && (StoryVideoView.e(this.MbY) > 0L) && (paramInt1 >= StoryVideoView.e(this.MbY)))
      {
        Log.i(StoryVideoView.a(this.MbY), "fakeVideo exceed endTime, playTime:" + paramInt1 + ", fakeEndTime:" + StoryVideoView.e(this.MbY) + ", fakeStartTime:" + StoryVideoView.d(this.MbY));
        if (StoryVideoView.d(this.MbY) <= 0L) {
          break label146;
        }
        StoryVideoView.f(this.MbY).b(StoryVideoView.d(this.MbY), true);
      }
      for (;;)
      {
        AppMethodBeat.o(120582);
        return 0;
        label146:
        StoryVideoView.f(this.MbY).b(0.0D, true);
      }
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(120581);
      String str = StoryVideoView.a(this.MbY);
      StringBuilder localStringBuilder = new StringBuilder("localVideo onCompleted, isFakeVideo:");
      Object localObject = StoryVideoView.c(this.MbY);
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject).gdp());
        Log.i(str, localObject + ", fakeStartTime:" + StoryVideoView.d(this.MbY));
        localObject = StoryVideoView.c(this.MbY);
        if ((localObject == null) || (((com.tencent.mm.plugin.story.f.d.j)localObject).gdp() != true) || (StoryVideoView.d(this.MbY) <= 0L)) {
          break label166;
        }
        StoryVideoView.f(this.MbY).b(StoryVideoView.d(this.MbY), true);
      }
      for (;;)
      {
        localObject = StoryVideoView.h(this.MbY);
        if (localObject == null) {
          break label183;
        }
        ((i.b)localObject).dT(this.MbY.getSessionId(), StoryVideoView.i(this.MbY));
        AppMethodBeat.o(120581);
        return;
        localObject = null;
        break;
        label166:
        StoryVideoView.f(this.MbY).b(0.0D, true);
      }
      label183:
      AppMethodBeat.o(120581);
    }
    
    public final void onError(int paramInt1, int paramInt2) {}
    
    public final void qX()
    {
      AppMethodBeat.i(120580);
      String str = StoryVideoView.a(this.MbY);
      StringBuilder localStringBuilder = new StringBuilder("localVideo onPrepared, isLocalVideoPause:").append(StoryVideoView.b(this.MbY)).append(", isFakeVideo:");
      Object localObject = StoryVideoView.c(this.MbY);
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject).gdp());
        Log.i(str, localObject + ", fakeStartTime:" + StoryVideoView.d(this.MbY) + ", fakeEndTime:" + StoryVideoView.e(this.MbY));
        if (!StoryVideoView.b(this.MbY))
        {
          localObject = StoryVideoView.c(this.MbY);
          if ((localObject == null) || (((com.tencent.mm.plugin.story.f.d.j)localObject).gdp() != true) || (StoryVideoView.d(this.MbY) <= 0L)) {
            break label197;
          }
          StoryVideoView.f(this.MbY).b(StoryVideoView.d(this.MbY), true);
        }
      }
      for (;;)
      {
        StoryVideoView.f(this.MbY).setOneTimeVideoTextureUpdateCallback((k.e)new a(this));
        AppMethodBeat.o(120580);
        return;
        localObject = null;
        break;
        label197:
        StoryVideoView.f(this.MbY).start();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTextureUpdate"})
    static final class a
      implements k.e
    {
      a(StoryVideoView.b paramb) {}
      
      public final void bXh()
      {
        AppMethodBeat.i(120579);
        this.MbZ.MbY.setFirstPlayWaitTime(Util.ticksToNow(StoryVideoView.g(this.MbZ.MbY)));
        MMHandlerThread.postToMainThreadDelayed((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(120578);
            Log.i(StoryVideoView.a(this.Mca.MbZ.MbY), "onTextureUpdate");
            if (StoryVideoView.f(this.Mca.MbZ.MbY) == null)
            {
              AppMethodBeat.o(120578);
              return;
            }
            this.Mca.MbZ.MbY.hideLoading();
            Object localObject = StoryVideoView.f(this.Mca.MbZ.MbY);
            if (localObject == null)
            {
              localObject = new t("null cannot be cast to non-null type android.view.View");
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(StoryVideoView paramStoryVideoView, oc paramoc, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(120583);
      Log.i(StoryVideoView.a(this.MbY), "reportStopLocalVideo");
      b localb = com.tencent.mm.plugin.sight.base.f.aYg(StoryVideoView.j(this.MbY));
      if (localb != null)
      {
        oc localoc = localoc.zR(localb.videoDuration);
        j.b localb1 = com.tencent.mm.plugin.story.f.j.LGA;
        localoc.zP(j.b.gcw().RV(l)).zZ(localb.videoBitrate).bpa();
      }
      AppMethodBeat.o(120583);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoView
 * JD-Core Version:    0.7.0.1
 */