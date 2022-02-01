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
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.g.b.a.lg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.MMVideoView.a;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.pluginsdk.ui.tools.j.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView;", "Lcom/tencent/mm/modelvideo/MMVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "C_TAG", "", "fakeBlurLayer", "Landroid/widget/ImageView;", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "firstPlayWaitTime", "", "getFirstPlayWaitTime", "()J", "setFirstPlayWaitTime", "(J)V", "isFakeVideo", "", "isLocalVideo", "isLocalVideoPause", "isMute", "needShowLoading", "sessionId", "startPlayTime", "surfaceAvailable", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "videoTips", "Landroid/widget/TextView;", "avgBlockTime", "", "blockCount", "calcDownloadRange", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "checkCanPlay", "checkLandscape", "", "blurBgPath", "checkNeedReset", "checkResumeLocalVideo", "createVideoView", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView;", "mContext", "fakeEndTime", "fakeStartTime", "getErrorCode", "getFilePath", "getSessionId", "getStayTime", "initView", "isLive", "isShowLoading", "moovCostTime", "onCompletion", "onFinish", "mediaId", "ret", "onGetVideoSize", "width", "height", "onProgress", "offset", "total", "onSeekComplete", "startPlay", "onSurfaceAvailable", "onTextureUpdate", "onUIDestroy", "onUIPause", "onUIResume", "pause", "play", "item", "playLocalVideo", "videoPath", "prepareVideo", "reportStopLocalVideo", "reset", "resume", "storyVideoItem", "setMute", "mute", "setNeedShowLoading", "show", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoPath", "url", "durationSec", "showDebugInfo", "path", "showLoading", "startTimer", "rightNow", "stop", "stopTimer", "Companion", "plugin-story_release"})
public final class StoryVideoView
  extends MMVideoView
{
  public static final a FHX;
  private boolean Cei;
  private final String FHQ;
  private boolean FHR;
  boolean FHS;
  private boolean FHT;
  private boolean FHU;
  private ImageView FHV;
  private long FHW;
  private com.tencent.mm.plugin.story.f.d.j FoT;
  private boolean guh;
  private long iJF;
  private String sessionId;
  private TextView tmU;
  private FakeVideoViewLayer xCO;
  
  static
  {
    AppMethodBeat.i(120621);
    FHX = new a((byte)0);
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
    this.FHQ = "MicroMsg.StoryVideoView";
    paramContext = com.tencent.mm.plugin.story.f.j.Fmy;
    setRootPath(com.tencent.mm.vfs.s.k(j.b.getAccStoryPath(), true));
    goo();
    setIsShowBasicControls(false);
    paramContext = this.mEB;
    p.g(paramContext, "footerRoot");
    paramContext.setVisibility(8);
    this.TAG = this.FHQ;
    this.FHR = true;
    AppMethodBeat.o(120619);
  }
  
  private final void aSF(String paramString)
  {
    AppMethodBeat.i(120591);
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("playLocalVideo: ").append(paramString).append(", isPlayingNow:");
    com.tencent.mm.pluginsdk.ui.tools.j localj = this.qbJ;
    p.g(localj, "videoView");
    Log.i((String)localObject1, localj.isPlaying());
    if (this.qbJ == null) {
      this.qbJ = di(getContext());
    }
    reset();
    localObject1 = this.qbJ;
    if (localObject1 != null) {
      ((com.tencent.mm.pluginsdk.ui.tools.j)localObject1).stop();
    }
    localObject1 = this.qbJ;
    if (localObject1 != null) {
      if (!this.guh)
      {
        if (!this.FHU) {
          break label204;
        }
        localObject2 = this.xCO;
        if (localObject2 == null) {
          p.btv("fakeLayer");
        }
        if (!((FakeVideoViewLayer)localObject2).BYt) {
          break label204;
        }
      }
    }
    label204:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.pluginsdk.ui.tools.j)localObject1).setMute(bool);
      this.bzP = false;
      this.FHS = true;
      setDownloadStatus(3);
      setNeedShowLoading(false);
      localObject1 = this.qbJ;
      if (localObject1 != null) {
        break;
      }
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView");
      AppMethodBeat.o(120591);
      throw paramString;
    }
    ((StoryVideoPlayTextureView)localObject1).setNeedResetExtractor(cXc());
    localObject1 = this.qbJ;
    p.g(localObject1, "videoView");
    ((com.tencent.mm.pluginsdk.ui.tools.j)localObject1).setVideoPath(paramString);
    this.iJF = Util.currentTicks();
    this.FHW = 0L;
    localObject1 = com.tencent.mm.plugin.story.f.k.FmH;
    localObject1 = this.FoT;
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
    com.tencent.mm.plugin.story.f.k.aRR((String)localObject1);
    this.qbJ.setVideoCallback((j.a)new b(this));
    this.FHT = false;
    this.sessionId = null;
    aSG(paramString);
    AppMethodBeat.o(120591);
  }
  
  private final void aSG(String paramString)
  {
    AppMethodBeat.i(120617);
    Object localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).azQ().get(ar.a.NYY, Integer.valueOf(0));
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(120617);
      throw paramString;
    }
    if (((Integer)localObject).intValue() == 1)
    {
      localObject = this.tmU;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.sight.base.e.aFm(paramString));
      }
      paramString = this.tmU;
      if (paramString != null)
      {
        paramString.setVisibility(0);
        AppMethodBeat.o(120617);
        return;
      }
    }
    AppMethodBeat.o(120617);
  }
  
  private final boolean cXc()
  {
    AppMethodBeat.i(120604);
    if (this.FHS)
    {
      AppMethodBeat.o(120604);
      return false;
    }
    try
    {
      boolean bool = g.aAh().azQ().getBoolean(ar.a.Oaq, false);
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
    p.h(paramj, "item");
    Object localObject1 = this.tmU;
    if (localObject1 != null) {
      ((TextView)localObject1).setVisibility(8);
    }
    this.FoT = paramj;
    localObject1 = paramj.Fpd;
    int i = paramj.iXu;
    this.FHU = false;
    Object localObject2 = this.xCO;
    if (localObject2 == null) {
      p.btv("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject2).setVisibility(8);
    localObject2 = this.FHV;
    if (localObject2 != null) {
      ((ImageView)localObject2).setVisibility(8);
    }
    if (!paramj.foW())
    {
      Log.i(this.TAG, "play empty item");
      showLoading();
      AppMethodBeat.o(120585);
      return;
    }
    if (paramj.foV())
    {
      this.FHU = true;
      Log.i(this.TAG, "LogStory: play fake video");
      paramString = this.xCO;
      if (paramString == null) {
        p.btv("fakeLayer");
      }
      paramString.setVisibility(0);
      paramj = paramj.Fpe;
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
        localObject1 = au.az(getContext());
        paramString = BitmapUtil.extractThumbNail(paramString, ((Point)localObject1).y, ((Point)localObject1).x, true);
        localObject1 = this.FHV;
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageBitmap(paramString);
        }
        paramString = this.FHV;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        label268:
        paramString = this.xCO;
        if (paramString == null) {
          p.btv("fakeLayer");
        }
        paramString.setFakeVideoInfo(paramj);
        paramString = this.xCO;
        if (paramString == null) {
          p.btv("fakeLayer");
        }
        paramString.tv(this.guh);
        this.jpU = paramj.eII().videoPath;
        this.jpT = "";
        paramj = this.jpU;
        p.g(paramj, "filepath");
        aSF(paramj);
      }
    }
    for (;;)
    {
      setLoop(true);
      paramj = this.qbJ;
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
      paramString = this.FHV;
      if (paramString == null) {
        break label268;
      }
      paramString.setVisibility(8);
      break label268;
      Log.i(this.TAG, "LogStory: play normal video");
      localObject2 = com.tencent.mm.plugin.story.f.s.Fny;
      Object localObject3 = com.tencent.mm.plugin.story.f.s.a((edt)localObject1);
      if (com.tencent.mm.vfs.s.boW((String)localObject3) > 0L)
      {
        Log.i(this.TAG, "play " + (String)localObject3 + " downloadDone now can play " + ((edt)localObject1).Id);
        this.jpU = ((String)localObject3);
        if (localObject3 != null) {
          aSF((String)localObject3);
        }
      }
      else
      {
        localObject2 = com.tencent.mm.plugin.story.f.s.Fny;
        localObject2 = com.tencent.mm.plugin.story.f.s.a(paramj);
        int j = (int)com.tencent.mm.vfs.s.boW(((n)localObject2).field_filePath);
        Log.i(this.TAG, "play " + (String)localObject3 + " error try play from url or videoCache " + ((edt)localObject1).Id + " fileLength:" + j + " cacheSize:" + ((n)localObject2).field_cacheSize);
        if (j < ((n)localObject2).field_cacheSize)
        {
          ((n)localObject2).field_cacheSize = j;
          localObject3 = com.tencent.mm.plugin.story.f.j.Fmy;
          j.b.fog().b((n)localObject2);
        }
        Log.i(this.TAG, String.valueOf(localObject2));
        if ((((n)localObject2).alN()) && (com.tencent.mm.vfs.s.YS(((n)localObject2).field_filePath)))
        {
          Log.i(this.TAG, "play " + ((edt)localObject1).Id + " download finish");
          this.jpU = ((n)localObject2).field_filePath;
          paramj = com.tencent.mm.plugin.story.f.s.Fny;
          this.jpT = com.tencent.mm.plugin.story.f.s.cs(i, ((edt)localObject1).Url);
          paramj = this.jpU;
          p.g(paramj, "filepath");
          aSF(paramj);
        }
        else
        {
          if ((((n)localObject2).alN()) && (!com.tencent.mm.vfs.s.YS(((n)localObject2).field_filePath)))
          {
            Log.i(this.TAG, "error downloadFinish " + ((n)localObject2).alN() + " ret:" + com.tencent.mm.vfs.s.YS(((n)localObject2).field_filePath));
            ((n)localObject2).frR();
            localObject3 = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.fog().b((n)localObject2);
          }
          Log.i(this.TAG, "play " + ((edt)localObject1).Id + ' ' + paramString + " start online play " + ((n)localObject2).field_filePath);
          reset();
          this.qbJ.stop();
          this.qbJ.setVideoCallback((j.a)this);
          this.FHS = false;
          this.mEK = true;
          setNeedShowLoading(true);
          super.c(false, paramj.Fpd.Url, (int)((edt)localObject1).Ned);
          this.jpU = ((n)localObject2).field_filePath;
          paramj = com.tencent.mm.plugin.story.f.s.Fny;
          this.jpT = com.tencent.mm.plugin.story.f.s.cs(i, ((edt)localObject1).Url);
          this.sessionId = paramString;
          this.iJF = Util.currentTicks();
          this.FHW = 0L;
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
    paramPInt1.value = Math.max(paramInt, this.jqc);
    if (this.jpW == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.jqd;
      localObject1 = "" + "step1;";
    }
    Object localObject2 = localObject1;
    if (this.jpW == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.jqd + 8);
      localObject2 = (String)localObject1 + "step2;";
    }
    if (this.jpW == 3)
    {
      paramPInt1.value = this.jqc;
      paramPInt2.value = (paramInt + 1 + this.jqh.jqn);
      localObject1 = (String)localObject2 + "step3;";
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (paramPInt2.value >= this.jpY + 1)
      {
        paramPInt2.value = (this.jpY + 1);
        localObject2 = (String)localObject1 + "step5;";
      }
      if (paramPInt2.value >= paramPInt1.value) {
        break;
      }
      paramPInt1.value += this.jqh.jqn;
      AppMethodBeat.o(120606);
      return false;
      localObject1 = localObject2;
      if (this.jpW == 4)
      {
        paramPInt1.value = this.jqc;
        paramPInt2.value = (this.jqd + paramInt + 1 + this.jqh.jqn);
        localObject1 = (String)localObject2 + "step4;";
      }
    }
    Log.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s] %s", new Object[] { bgQ(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.jpW), Integer.valueOf(this.jqc), Integer.valueOf(this.jqd), this.jpT, localObject2 });
    AppMethodBeat.o(120606);
    return true;
  }
  
  public final void ax(String paramString, int paramInt)
  {
    AppMethodBeat.i(120603);
    super.ax(paramString, paramInt);
    AppMethodBeat.o(120603);
  }
  
  public final void bLh()
  {
    AppMethodBeat.i(120610);
    super.bLh();
    Object localObject = this.qbJ;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(120610);
      throw ((Throwable)localObject);
    }
    ((View)localObject).setAlpha(1.0F);
    String str;
    StringBuilder localStringBuilder;
    if (this.FHW <= 0L)
    {
      this.FHW = Util.ticksToNow(this.iJF);
      str = this.TAG;
      localStringBuilder = new StringBuilder("onTextureUpdate firstPlayWaitTime ").append(this.FHW).append(" storyId: ");
      localObject = this.FoT;
      if (localObject == null) {
        break label131;
      }
    }
    label131:
    for (localObject = Long.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject).edx);; localObject = null)
    {
      Log.i(str, localObject);
      AppMethodBeat.o(120610);
      return;
    }
  }
  
  public final void bgV()
  {
    AppMethodBeat.i(120616);
    Log.i(this.TAG, "prepareVideo, surfaceAvailable:" + this.Cei);
    if (this.qbJ != null)
    {
      localObject = this.qbJ;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView");
        AppMethodBeat.o(120616);
        throw ((Throwable)localObject);
      }
      ((StoryVideoPlayTextureView)localObject).setNeedResetExtractor(cXc());
    }
    Object localObject = this.jpU;
    p.g(localObject, "filepath");
    aSG((String)localObject);
    super.bgV();
    AppMethodBeat.o(120616);
  }
  
  public final void bgX()
  {
    AppMethodBeat.i(120615);
    super.bgX();
    Log.i(this.TAG, "onSurfaceAvailable");
    this.Cei = true;
    AppMethodBeat.o(120615);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(258527);
    super.c(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(258527);
  }
  
  public final com.tencent.mm.pluginsdk.ui.tools.j di(Context paramContext)
  {
    AppMethodBeat.i(120614);
    paramContext = new StoryVideoPlayTextureView(paramContext);
    paramContext.setOpenWithNoneSurface(true);
    paramContext.setNeedResetExtractor(cXc());
    paramContext.setIsOnlineVideoType(true);
    paramContext = (com.tencent.mm.pluginsdk.ui.tools.j)paramContext;
    AppMethodBeat.o(120614);
    return paramContext;
  }
  
  public final void eo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120602);
    super.eo(paramInt1, paramInt2);
    Log.i(this.TAG, "onGetVideoSize, mediaId:" + getMediaId() + ", isLocalVideo:" + this.FHS + ", isPrepareVideo:" + this.jqe + ", isPrepared:" + this.ZA + ", playerStatus:" + this.jpW + ", downloadStatus:" + this.jpV);
    AppMethodBeat.o(120602);
  }
  
  public final void fN(boolean paramBoolean)
  {
    AppMethodBeat.i(120592);
    if (this.FHS)
    {
      AppMethodBeat.o(120592);
      return;
    }
    super.fN(paramBoolean);
    AppMethodBeat.o(120592);
  }
  
  public final void fO(boolean paramBoolean)
  {
    AppMethodBeat.i(120593);
    Log.printInfoStack(this.TAG, bgQ() + " startTimer, isLocalVideo:" + this.FHS, new Object[0]);
    if (!this.FHS) {
      super.fO(paramBoolean);
    }
    AppMethodBeat.o(120593);
  }
  
  public final int fsH()
  {
    if (this.KaY.Eut > this.KaY.mvz) {
      return (int)(this.KaY.Eut - this.KaY.mvz);
    }
    return 0;
  }
  
  public final int fsI()
  {
    return this.KaY.blockCount;
  }
  
  public final int fsJ()
  {
    if (this.KaY.blockCount > 0) {
      return (int)(this.KaY.KcZ / this.KaY.blockCount);
    }
    return 0;
  }
  
  public final int getErrorCode()
  {
    return this.KaY.mNz;
  }
  
  public final String getFilePath()
  {
    AppMethodBeat.i(120612);
    String str = this.jpU;
    p.g(str, "filepath");
    AppMethodBeat.o(120612);
    return str;
  }
  
  public final long getFirstPlayWaitTime()
  {
    return this.FHW;
  }
  
  public final String getSessionId()
  {
    AppMethodBeat.i(120587);
    String str = Util.nullAsNil(this.sessionId);
    p.g(str, "Util.nullAsNil(sessionId)");
    AppMethodBeat.o(120587);
    return str;
  }
  
  public final int getStayTime()
  {
    AppMethodBeat.i(120611);
    int i = (int)Util.ticksToNow(this.iJF);
    AppMethodBeat.o(120611);
    return i;
  }
  
  public final void i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(120601);
    if (!Util.isEqual(this.jpT, paramString))
    {
      AppMethodBeat.o(120601);
      return;
    }
    paramString = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("%s download  onProgress [%d, %d], pauseByLoadData:").append(this.jqb).append(", playStatus:").append(this.jpW).append(", currPosMs:").append(getCurrPosMs()).append(", isPlyaing:");
    com.tencent.mm.pluginsdk.ui.tools.j localj = this.qbJ;
    p.g(localj, "videoView");
    Log.d(paramString, localj.isPlaying(), new Object[] { bgQ(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (((getCurrPosMs() <= 0) || (this.jpW == 1) || (this.jpW == 0)) && (ub(getCurrPosSec()))) {
      fO(true);
    }
    AppMethodBeat.o(120601);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(120584);
    super.initView();
    Object localObject = com.tencent.mm.plugin.story.f.e.a.Fpl;
    this.xCO = com.tencent.mm.plugin.story.f.e.a.hk(getContext());
    this.FHV = new ImageView(getContext());
    localObject = this.FHV;
    if (localObject != null) {
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    localObject = this.FHV;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.mEy;
    FakeVideoViewLayer localFakeVideoViewLayer = this.xCO;
    if (localFakeVideoViewLayer == null) {
      p.btv("fakeLayer");
    }
    ((RelativeLayout)localObject).addView((View)localFakeVideoViewLayer, new ViewGroup.LayoutParams(-1, -1));
    this.mEy.addView((View)this.FHV, 0);
    this.tmU = ((TextView)findViewById(2131309834));
    AppMethodBeat.o(120584);
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(120595);
    if (this.FHS)
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
    Log.i(this.TAG, "resume, current play time:" + getCurrPosMs() + ", " + getCurrPosSec() + ", " + getVideoDurationSec() + ", isPrepared:" + this.ZA + ", sessionId:" + this.sessionId + ", isLocalVideo:" + this.FHS);
    Object localObject1 = this.xCO;
    if (localObject1 == null) {
      p.btv("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject1).tv(this.guh);
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
    StringBuilder localStringBuilder = new StringBuilder("checkResumeLocalVideo, isLocalVideo:").append(this.FHS).append(", currentPosition:");
    localObject1 = this.qbJ;
    int i;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.j)localObject1).getCurrentPosition());
      Log.i((String)localObject3, localObject1);
      if (!this.FHS) {
        break label330;
      }
      localObject1 = this.qbJ;
      if (localObject1 == null) {
        break label325;
      }
      i = ((com.tencent.mm.pluginsdk.ui.tools.j)localObject1).getCurrentPosition();
      label263:
      if (i <= 0) {
        break label330;
      }
      localObject3 = this.qbJ;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = Boolean.valueOf(((com.tencent.mm.pluginsdk.ui.tools.j)localObject3).start());
      }
      this.FHT = false;
    }
    label325:
    label330:
    for (boolean bool = p.j(localObject1, Boolean.TRUE);; bool = false)
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
    if ((getCurrPosMs() > 0) && (!this.FHS))
    {
      if (!this.ZA)
      {
        this.mEK = true;
        bgV();
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
    Log.i(this.TAG, "onCompletion, currPosMs:" + getCurrPosMs() + ", playStatus:" + this.jpW + ", downloadStatus:" + this.jpV);
    if (getCurrPosMs() <= 0)
    {
      AppMethodBeat.o(120586);
      return;
    }
    i.b localb = this.pNj;
    if (localb != null) {
      localb.dI(getSessionId(), getMediaId());
    }
    super.onCompletion();
    AppMethodBeat.o(120586);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(120600);
    Log.i(this.TAG, "onUIDestroy, isLocalVideo:" + this.FHS);
    FakeVideoViewLayer localFakeVideoViewLayer = this.xCO;
    if (localFakeVideoViewLayer == null) {
      p.btv("fakeLayer");
    }
    localFakeVideoViewLayer.eLB();
    super.onUIDestroy();
    AppMethodBeat.o(120600);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(120598);
    Log.i(this.TAG, "onUIPause, isLocalVideo:" + this.FHS);
    Object localObject = this.xCO;
    if (localObject == null) {
      p.btv("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject).eLA();
    if (this.FHS)
    {
      localObject = this.qbJ;
      if (localObject != null)
      {
        ((com.tencent.mm.pluginsdk.ui.tools.j)localObject).pause();
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
    Log.i(this.TAG, "onUIResume, isLocalVideo:" + this.FHS);
    if (isPlaying())
    {
      FakeVideoViewLayer localFakeVideoViewLayer = this.xCO;
      if (localFakeVideoViewLayer == null) {
        p.btv("fakeLayer");
      }
      localFakeVideoViewLayer.tv(this.guh);
    }
    if (this.FHS)
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
    Log.i(this.TAG, "pause, isLocalVideo:" + this.FHS);
    FakeVideoViewLayer localFakeVideoViewLayer = this.xCO;
    if (localFakeVideoViewLayer == null) {
      p.btv("fakeLayer");
    }
    localFakeVideoViewLayer.eLA();
    if (this.FHS)
    {
      this.FHT = true;
      this.qbJ.pause();
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
    this.Cei = false;
    this.sessionId = null;
    AppMethodBeat.o(120618);
  }
  
  public final void setFirstPlayWaitTime(long paramLong)
  {
    this.FHW = paramLong;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(120588);
    super.setMute(paramBoolean);
    this.guh = paramBoolean;
    if (this.qbJ != null) {
      this.qbJ.setMute(paramBoolean);
    }
    AppMethodBeat.o(120588);
  }
  
  public final void setNeedShowLoading(boolean paramBoolean)
  {
    AppMethodBeat.i(120596);
    Log.i(this.TAG, hashCode() + " setNeedShowLoading: " + paramBoolean);
    this.FHR = paramBoolean;
    if (!this.FHR) {
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
    if (this.FHR) {
      BT(800L);
    }
    AppMethodBeat.o(120597);
  }
  
  public final void start()
  {
    AppMethodBeat.i(120607);
    if ((this.bFM > 0) && (!this.FHS))
    {
      Log.i(this.TAG, "start from onError and not local video");
      localObject = this.FoT;
      if (localObject != null)
      {
        com.tencent.mm.plugin.story.f.s locals = com.tencent.mm.plugin.story.f.s.Fny;
        localObject = com.tencent.mm.plugin.story.f.s.a((com.tencent.mm.plugin.story.f.d.j)localObject);
        if (((n)localObject).alN())
        {
          Log.i(this.TAG, "start from onError and download finish now");
          localObject = ((n)localObject).field_filePath;
          p.g(localObject, "videoCache.field_filePath");
          aSF((String)localObject);
          AppMethodBeat.o(120607);
          return;
        }
      }
    }
    Object localObject = this.jpU;
    p.g(localObject, "filepath");
    aSG((String)localObject);
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
        Object localObject1 = this.xCO;
        if (localObject1 == null) {
          p.btv("fakeLayer");
        }
        ((FakeVideoViewLayer)localObject1).eLB();
        if (this.FHS)
        {
          final lg locallg = new lg();
          localObject1 = this.FoT;
          if (localObject1 == null) {
            break label362;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject1).edx);
          localObject1 = locallg.ys(String.valueOf(localObject1));
          h localh = h.FuH;
          localObject1 = ((lg)localObject1).tZ(h.fqi().ahw());
          localh = h.FuH;
          if (h.fqi().ahB() != 1L) {
            break label367;
          }
          localObject1 = ((lg)localObject1).ub(l).ue(this.FHW).ui(getStayTime()).uj(getErrorCode()).uG(1L);
          localh = h.FuH;
          localObject1 = ((lg)localObject1).uH(h.fqi().ahv());
          localh = h.FuH;
          ((lg)localObject1).uI(h.fqi().ahy()).ud(getCurrPosMs());
          Log.d(this.TAG, "time distance %d", new Object[] { Long.valueOf(System.currentTimeMillis() - locallg.aiy()) });
          if (System.currentTimeMillis() - locallg.aiy() >= 500L)
          {
            localObject1 = this.FoT;
            if (localObject1 == null) {
              break label372;
            }
            l = ((com.tencent.mm.plugin.story.f.d.j)localObject1).edx;
          }
          try
          {
            localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.eJP().post((Runnable)new c(this, locallg, l));
            this.qbJ.stop();
            reset();
            localObject1 = this.FHV;
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
            locallg.bfK();
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
    Log.printInfoStack(this.TAG, bgQ() + " stopTimer, isLocalVideo:" + this.FHS, new Object[0]);
    super.stopTimer();
    AppMethodBeat.o(120594);
  }
  
  public final boolean uc(int paramInt)
  {
    AppMethodBeat.i(120605);
    boolean bool = super.uc(paramInt);
    Log.i(this.TAG, "checkCanPlay, cachePlayTime:" + this.jqc + ", ret:" + bool);
    AppMethodBeat.o(120605);
    return bool;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView$Companion;", "", "()V", "PRELOAD_CACHE", "", "PRELOAD_CACHE_GOOD_NETWORK", "plugin-story_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView$playLocalVideo$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-story_release"})
  public static final class b
    implements j.a
  {
    public final void eo(int paramInt1, int paramInt2) {}
    
    public final int fh(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120582);
      com.tencent.mm.plugin.story.f.d.j localj = StoryVideoView.c(this.FHY);
      if ((localj != null) && (localj.foV() == true) && (StoryVideoView.e(this.FHY) > 0L) && (paramInt1 >= StoryVideoView.e(this.FHY)))
      {
        Log.i(StoryVideoView.a(this.FHY), "fakeVideo exceed endTime, playTime:" + paramInt1 + ", fakeEndTime:" + StoryVideoView.e(this.FHY) + ", fakeStartTime:" + StoryVideoView.d(this.FHY));
        if (StoryVideoView.d(this.FHY) <= 0L) {
          break label146;
        }
        StoryVideoView.f(this.FHY).d(StoryVideoView.d(this.FHY), true);
      }
      for (;;)
      {
        AppMethodBeat.o(120582);
        return 0;
        label146:
        StoryVideoView.f(this.FHY).d(0.0D, true);
      }
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(120581);
      String str = StoryVideoView.a(this.FHY);
      StringBuilder localStringBuilder = new StringBuilder("localVideo onCompleted, isFakeVideo:");
      Object localObject = StoryVideoView.c(this.FHY);
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject).foV());
        Log.i(str, localObject + ", fakeStartTime:" + StoryVideoView.d(this.FHY));
        localObject = StoryVideoView.c(this.FHY);
        if ((localObject == null) || (((com.tencent.mm.plugin.story.f.d.j)localObject).foV() != true) || (StoryVideoView.d(this.FHY) <= 0L)) {
          break label166;
        }
        StoryVideoView.f(this.FHY).d(StoryVideoView.d(this.FHY), true);
      }
      for (;;)
      {
        localObject = StoryVideoView.h(this.FHY);
        if (localObject == null) {
          break label183;
        }
        ((i.b)localObject).dI(this.FHY.getSessionId(), StoryVideoView.i(this.FHY));
        AppMethodBeat.o(120581);
        return;
        localObject = null;
        break;
        label166:
        StoryVideoView.f(this.FHY).d(0.0D, true);
      }
      label183:
      AppMethodBeat.o(120581);
    }
    
    public final void onError(int paramInt1, int paramInt2) {}
    
    public final void tf()
    {
      AppMethodBeat.i(120580);
      String str = StoryVideoView.a(this.FHY);
      StringBuilder localStringBuilder = new StringBuilder("localVideo onPrepared, isLocalVideoPause:").append(StoryVideoView.b(this.FHY)).append(", isFakeVideo:");
      Object localObject = StoryVideoView.c(this.FHY);
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject).foV());
        Log.i(str, localObject + ", fakeStartTime:" + StoryVideoView.d(this.FHY) + ", fakeEndTime:" + StoryVideoView.e(this.FHY));
        if (!StoryVideoView.b(this.FHY))
        {
          localObject = StoryVideoView.c(this.FHY);
          if ((localObject == null) || (((com.tencent.mm.plugin.story.f.d.j)localObject).foV() != true) || (StoryVideoView.d(this.FHY) <= 0L)) {
            break label197;
          }
          StoryVideoView.f(this.FHY).d(StoryVideoView.d(this.FHY), true);
        }
      }
      for (;;)
      {
        StoryVideoView.f(this.FHY).setOneTimeVideoTextureUpdateCallback((j.e)new a(this));
        AppMethodBeat.o(120580);
        return;
        localObject = null;
        break;
        label197:
        StoryVideoView.f(this.FHY).start();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTextureUpdate"})
    static final class a
      implements j.e
    {
      a(StoryVideoView.b paramb) {}
      
      public final void bLh()
      {
        AppMethodBeat.i(120579);
        this.FHZ.FHY.setFirstPlayWaitTime(Util.ticksToNow(StoryVideoView.g(this.FHZ.FHY)));
        MMHandlerThread.postToMainThreadDelayed((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(120578);
            Log.i(StoryVideoView.a(this.FIa.FHZ.FHY), "onTextureUpdate");
            if (StoryVideoView.f(this.FIa.FHZ.FHY) == null)
            {
              AppMethodBeat.o(120578);
              return;
            }
            this.FIa.FHZ.FHY.hideLoading();
            Object localObject = StoryVideoView.f(this.FIa.FHZ.FHY);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(StoryVideoView paramStoryVideoView, lg paramlg, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(120583);
      Log.i(StoryVideoView.a(this.FHY), "reportStopLocalVideo");
      com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.e.aNx(StoryVideoView.j(this.FHY));
      if (locala != null)
      {
        lg locallg = locallg.uc(locala.videoDuration);
        j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
        locallg.ua(j.b.foc().KB(l)).uk(locala.videoBitrate).bfK();
      }
      AppMethodBeat.o(120583);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoView
 * JD-Core Version:    0.7.0.1
 */