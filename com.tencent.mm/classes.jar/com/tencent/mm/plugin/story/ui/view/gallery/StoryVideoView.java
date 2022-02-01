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
import com.tencent.mm.autogen.mmdata.rpt.ox;
import com.tencent.mm.autogen.mmdata.rpt.ru;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.MMVideoView.a;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.plugin.story.h.o;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.e.a;
import com.tencent.mm.plugin.story.model.r;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.bf;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView;", "Lcom/tencent/mm/modelvideo/MMVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "C_TAG", "", "fakeBlurLayer", "Landroid/widget/ImageView;", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "firstPlayWaitTime", "", "getFirstPlayWaitTime", "()J", "setFirstPlayWaitTime", "(J)V", "isFakeVideo", "", "isLocalVideo", "isLocalVideoPause", "isMute", "needShowLoading", "sessionId", "startPlayTime", "surfaceAvailable", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "videoTips", "Landroid/widget/TextView;", "avgBlockTime", "", "blockCount", "calcDownloadRange", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "checkCanPlay", "checkLandscape", "", "blurBgPath", "checkNeedReset", "checkResumeLocalVideo", "createVideoView", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView;", "mContext", "fakeEndTime", "fakeStartTime", "getErrorCode", "getFilePath", "getSessionId", "getStayTime", "initView", "isLive", "isShowLoading", "moovCostTime", "onCompletion", "onFinish", "mediaId", "ret", "onGetVideoSize", "width", "height", "onProgress", "offset", "total", "onSeekComplete", "startPlay", "onSurfaceAvailable", "onTextureUpdate", "onUIDestroy", "onUIPause", "onUIResume", "pause", "play", "item", "playLocalVideo", "videoPath", "prepareVideo", "reportStopLocalVideo", "reset", "resume", "storyVideoItem", "setMute", "mute", "setNeedShowLoading", "show", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoPath", "url", "durationSec", "showDebugInfo", "path", "showLoading", "startTimer", "rightNow", "stop", "stopTimer", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryVideoView
  extends MMVideoView
{
  public static final StoryVideoView.a SDg;
  private TextView ApV;
  private FakeVideoViewLayer IAY;
  private boolean NXj;
  private final String SDh;
  private boolean SDi;
  boolean SDj;
  private boolean SDk;
  private boolean SDl;
  private ImageView SDm;
  private long SDn;
  private com.tencent.mm.plugin.story.model.d.j Smr;
  private boolean lAj;
  private long ork;
  private String sessionId;
  
  static
  {
    AppMethodBeat.i(120621);
    SDg = new StoryVideoView.a((byte)0);
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
    this.SDh = "MicroMsg.StoryVideoView";
    paramContext = StoryCore.SjP;
    setRootPath(y.n(StoryCore.b.getAccStoryPath(), true));
    grj();
    setIsShowBasicControls(false);
    this.sIZ.setVisibility(8);
    this.TAG = this.SDh;
    this.SDi = true;
    AppMethodBeat.o(120619);
  }
  
  private static final void a(StoryVideoView paramStoryVideoView, ru paramru, long paramLong)
  {
    AppMethodBeat.i(367677);
    s.u(paramStoryVideoView, "this$0");
    s.u(paramru, "$storyVideoPlayReportStruct");
    Log.i(paramStoryVideoView.TAG, "reportStopLocalVideo");
    paramStoryVideoView = com.tencent.mm.plugin.sight.base.f.aVX(paramStoryVideoView.oYr);
    if (paramStoryVideoView != null)
    {
      paramru.irv = paramStoryVideoView.videoDuration;
      StoryCore.b localb = StoryCore.SjP;
      paramru.jwe = StoryCore.b.hvR().we(paramLong);
      paramru.irw = paramStoryVideoView.videoBitrate;
      paramru.bMH();
    }
    AppMethodBeat.o(367677);
  }
  
  private final void bcv(String paramString)
  {
    AppMethodBeat.i(120591);
    Log.i(this.TAG, "playLocalVideo: " + paramString + ", isPlayingNow:" + this.wCd.isPlaying());
    if (this.wCd == null) {
      this.wCd = dY(getContext());
    }
    reset();
    Object localObject1 = this.wCd;
    if (localObject1 != null) {
      ((i)localObject1).stop();
    }
    i locali = this.wCd;
    Object localObject2;
    if (locali != null) {
      if (!this.lAj)
      {
        if (!this.SDl) {
          break label198;
        }
        localObject2 = this.IAY;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("fakeLayer");
          localObject1 = null;
        }
        if (!((FakeVideoViewLayer)localObject1).NRY) {
          break label198;
        }
      }
    }
    label198:
    for (boolean bool = true;; bool = false)
    {
      locali.setMute(bool);
      this.ddk = false;
      this.SDj = true;
      setDownloadStatus(3);
      setNeedShowLoading(false);
      localObject1 = this.wCd;
      if (localObject1 != null) {
        break;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView");
      AppMethodBeat.o(120591);
      throw paramString;
    }
    ((StoryVideoPlayTextureView)localObject1).setNeedResetExtractor(dTa());
    this.wCd.setVideoPath(paramString);
    this.ork = Util.currentTicks();
    this.SDn = 0L;
    localObject1 = com.tencent.mm.plugin.story.model.j.Skm;
    localObject1 = this.Smr;
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      com.tencent.mm.plugin.story.model.j.bbI((String)localObject1);
      this.wCd.setVideoCallback((i.a)new b(this));
      this.SDk = false;
      this.sessionId = null;
      bcw(paramString);
      AppMethodBeat.o(120591);
      return;
      localObject2 = ((com.tencent.mm.plugin.story.model.d.j)localObject1).username;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
  }
  
  private final void bcw(String paramString)
  {
    AppMethodBeat.i(120617);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acOt, Integer.valueOf(0));
    if (localObject == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(120617);
      throw paramString;
    }
    if (((Integer)localObject).intValue() == 1)
    {
      localObject = this.ApV;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.sight.base.f.aMu(paramString));
      }
      paramString = this.ApV;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
    }
    AppMethodBeat.o(120617);
  }
  
  private final boolean dTa()
  {
    AppMethodBeat.i(120604);
    if (this.SDj)
    {
      AppMethodBeat.o(120604);
      return false;
    }
    try
    {
      boolean bool = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acPO, false);
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
  
  public final void a(com.tencent.mm.plugin.story.model.d.j paramj, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(120585);
    s.u(paramj, "item");
    Object localObject1 = this.ApV;
    if (localObject1 != null) {
      ((TextView)localObject1).setVisibility(8);
    }
    this.Smr = paramj;
    fis localfis = paramj.Smx;
    int i = paramj.createTime;
    this.SDl = false;
    FakeVideoViewLayer localFakeVideoViewLayer = this.IAY;
    localObject1 = localFakeVideoViewLayer;
    if (localFakeVideoViewLayer == null)
    {
      s.bIx("fakeLayer");
      localObject1 = null;
    }
    ((FakeVideoViewLayer)localObject1).setVisibility(8);
    localObject1 = this.SDm;
    if (localObject1 != null) {
      ((ImageView)localObject1).setVisibility(8);
    }
    if (!paramj.heF())
    {
      Log.i(this.TAG, "play empty item");
      showLoading();
      AppMethodBeat.o(120585);
      return;
    }
    if (paramj.hwL())
    {
      this.SDl = true;
      Log.i(this.TAG, "LogStory: play fake video");
      localObject1 = this.IAY;
      paramString = (String)localObject1;
      if (localObject1 == null)
      {
        s.bIx("fakeLayer");
        paramString = null;
      }
      paramString.setVisibility(0);
      localObject1 = paramj.Smy;
      if (localObject1 != null)
      {
        paramj = ((c)localObject1).field_blurBgPath;
        s.s(paramj, "fakeData.field_blurBgPath");
        paramString = (CharSequence)paramj;
        if ((paramString != null) && (paramString.length() != 0)) {
          break label399;
        }
        i = 1;
        if (i != 0) {
          break label404;
        }
        paramString = bf.bf(getContext());
        paramj = BitmapUtil.extractThumbNail(paramj, paramString.y, paramString.x, true);
        paramString = this.SDm;
        if (paramString != null) {
          paramString.setImageBitmap(paramj);
        }
        paramj = this.SDm;
        if (paramj != null) {
          paramj.setVisibility(0);
        }
        label279:
        paramString = this.IAY;
        paramj = paramString;
        if (paramString == null)
        {
          s.bIx("fakeLayer");
          paramj = null;
        }
        paramj.setFakeVideoInfo((c)localObject1);
        paramj = this.IAY;
        if (paramj != null) {
          break label422;
        }
        s.bIx("fakeLayer");
        paramj = (com.tencent.mm.plugin.story.model.d.j)localObject2;
        label322:
        paramj.Br(this.lAj);
        this.oYr = ((c)localObject1).gGD().videoPath;
        this.oYq = "";
        paramj = this.oYr;
        s.s(paramj, "filepath");
        bcv(paramj);
      }
    }
    for (;;)
    {
      setLoop(true);
      paramj = this.wCd;
      if (paramj != null) {
        break label987;
      }
      paramj = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(120585);
      throw paramj;
      label399:
      i = 0;
      break;
      label404:
      paramj = this.SDm;
      if (paramj == null) {
        break label279;
      }
      paramj.setVisibility(8);
      break label279;
      label422:
      break label322;
      Log.i(this.TAG, "LogStory: play normal video");
      localObject1 = r.Slb;
      localObject2 = r.a(localfis);
      if (y.bEl((String)localObject2) > 0L)
      {
        Log.i(this.TAG, "play " + localObject2 + " downloadDone now can play " + localfis.Id);
        this.oYr = ((String)localObject2);
        if (localObject2 != null) {
          bcv((String)localObject2);
        }
      }
      else
      {
        localObject1 = r.Slb;
        localObject1 = r.a(paramj);
        int j = (int)y.bEl(((n)localObject1).field_filePath);
        Log.i(this.TAG, "play " + localObject2 + " error try play from url or videoCache " + localfis.Id + " fileLength:" + j + " cacheSize:" + ((n)localObject1).field_cacheSize);
        if (j < ((n)localObject1).field_cacheSize)
        {
          ((n)localObject1).field_cacheSize = j;
          localObject2 = StoryCore.SjP;
          StoryCore.b.hvV().b((n)localObject1);
        }
        Log.i(this.TAG, String.valueOf(localObject1));
        if ((((n)localObject1).aLI()) && (y.ZC(((n)localObject1).field_filePath)))
        {
          Log.i(this.TAG, "play " + localfis.Id + " download finish");
          this.oYr = ((n)localObject1).field_filePath;
          paramj = r.Slb;
          this.oYq = r.de(i, localfis.Url);
          paramj = this.oYr;
          s.s(paramj, "filepath");
          bcv(paramj);
        }
        else
        {
          if ((((n)localObject1).aLI()) && (!y.ZC(((n)localObject1).field_filePath)))
          {
            Log.i(this.TAG, "error downloadFinish " + ((n)localObject1).aLI() + " ret:" + y.ZC(((n)localObject1).field_filePath));
            ((n)localObject1).hzE();
            localObject2 = StoryCore.SjP;
            StoryCore.b.hvV().b((n)localObject1);
          }
          Log.i(this.TAG, "play " + localfis.Id + ' ' + paramString + " start online play " + ((n)localObject1).field_filePath);
          reset();
          this.wCd.stop();
          this.wCd.setVideoCallback((i.a)this);
          this.SDj = false;
          this.sJi = true;
          setNeedShowLoading(true);
          super.b(false, paramj.Smx.Url, (int)localfis.abJB);
          this.oYr = ((n)localObject1).field_filePath;
          paramj = r.Slb;
          this.oYq = r.de(i, localfis.Url);
          this.sessionId = paramString;
          this.ork = Util.currentTicks();
          this.SDn = 0L;
          start();
        }
      }
    }
    label987:
    ((View)paramj).setAlpha(0.0F);
    AppMethodBeat.o(120585);
  }
  
  public final boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(120606);
    s.u(paramPInt1, "start");
    s.u(paramPInt2, "end");
    Object localObject1 = "";
    paramPInt1.value = Math.max(paramInt, this.oYz);
    if (this.oYt == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.oYA;
      localObject1 = s.X("", "step1;");
    }
    Object localObject2 = localObject1;
    if (this.oYt == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.oYA + 8);
      localObject2 = s.X((String)localObject1, "step2;");
    }
    if (this.oYt == 3)
    {
      paramPInt1.value = this.oYz;
      paramPInt2.value = (paramInt + 1 + this.oYE.oYK);
      localObject1 = s.X((String)localObject2, "step3;");
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (paramPInt2.value >= this.oYv + 1)
      {
        paramPInt2.value = (this.oYv + 1);
        localObject2 = s.X((String)localObject1, "step5;");
      }
      if (paramPInt2.value >= paramPInt1.value) {
        break;
      }
      paramPInt1.value += this.oYE.oYK;
      AppMethodBeat.o(120606);
      return false;
      localObject1 = localObject2;
      if (this.oYt == 4)
      {
        paramPInt1.value = this.oYz;
        paramPInt2.value = (this.oYA + paramInt + 1 + this.oYE.oYK);
        localObject1 = s.X((String)localObject2, "step4;");
      }
    }
    Log.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s] %s", new Object[] { bNL(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.oYt), Integer.valueOf(this.oYz), Integer.valueOf(this.oYA), this.oYq, localObject2 });
    AppMethodBeat.o(120606);
    return true;
  }
  
  public final void b(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(371912);
    super.b(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(371912);
  }
  
  public final void bNS()
  {
    AppMethodBeat.i(120616);
    Log.i(this.TAG, s.X("prepareVideo, surfaceAvailable:", Boolean.valueOf(this.NXj)));
    if (this.wCd != null)
    {
      localObject = this.wCd;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView");
        AppMethodBeat.o(120616);
        throw ((Throwable)localObject);
      }
      ((StoryVideoPlayTextureView)localObject).setNeedResetExtractor(dTa());
    }
    Object localObject = this.oYr;
    s.s(localObject, "filepath");
    bcw((String)localObject);
    super.bNS();
    AppMethodBeat.o(120616);
  }
  
  public final void bNV()
  {
    AppMethodBeat.i(120615);
    super.bNV();
    Log.i(this.TAG, "onSurfaceAvailable");
    this.NXj = true;
    AppMethodBeat.o(120615);
  }
  
  public final void bb(String paramString, int paramInt)
  {
    AppMethodBeat.i(120603);
    super.bb(paramString, paramInt);
    AppMethodBeat.o(120603);
  }
  
  public final i dY(Context paramContext)
  {
    AppMethodBeat.i(120614);
    paramContext = new StoryVideoPlayTextureView(paramContext);
    paramContext.setOpenWithNoneSurface(true);
    paramContext.setNeedResetExtractor(dTa());
    paramContext.setIsOnlineVideoType(true);
    paramContext = (i)paramContext;
    AppMethodBeat.o(120614);
    return paramContext;
  }
  
  public final void fG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120602);
    super.fG(paramInt1, paramInt2);
    Log.i(this.TAG, "onGetVideoSize, mediaId:" + getMediaId() + ", isLocalVideo:" + this.SDj + ", isPrepareVideo:" + this.oYB + ", isPrepared:" + this.hS + ", playerStatus:" + this.oYt + ", downloadStatus:" + this.oYs);
    AppMethodBeat.o(120602);
  }
  
  public final int getErrorCode()
  {
    return this.XXJ.sSQ;
  }
  
  public final String getFilePath()
  {
    AppMethodBeat.i(120612);
    String str = this.oYr;
    s.s(str, "filepath");
    AppMethodBeat.o(120612);
    return str;
  }
  
  public final long getFirstPlayWaitTime()
  {
    return this.SDn;
  }
  
  public final String getSessionId()
  {
    AppMethodBeat.i(120587);
    String str = Util.nullAsNil(this.sessionId);
    s.s(str, "nullAsNil(sessionId)");
    AppMethodBeat.o(120587);
    return str;
  }
  
  public final int getStayTime()
  {
    AppMethodBeat.i(120611);
    int i = (int)Util.ticksToNow(this.ork);
    AppMethodBeat.o(120611);
    return i;
  }
  
  public final void h(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(120601);
    if (!Util.isEqual(this.oYq, paramString))
    {
      AppMethodBeat.o(120601);
      return;
    }
    Log.d(this.TAG, "%s download  onProgress [%d, %d], pauseByLoadData:" + this.oYy + ", playStatus:" + this.oYt + ", currPosMs:" + getCurrPosMs() + ", isPlyaing:" + this.wCd.isPlaying(), new Object[] { bNL(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (((getCurrPosMs() <= 0) || (this.oYt == 1) || (this.oYt == 0)) && (xa(getCurrPosSec()))) {
      ho(true);
    }
    AppMethodBeat.o(120601);
  }
  
  public final int hAA()
  {
    if (this.XXJ.blockCount > 0) {
      return (int)(this.XXJ.XZL / this.XXJ.blockCount);
    }
    return 0;
  }
  
  public final int hAy()
  {
    if (this.XXJ.RhK > this.XXJ.sze) {
      return (int)(this.XXJ.RhK - this.XXJ.sze);
    }
    return 0;
  }
  
  public final int hAz()
  {
    return this.XXJ.blockCount;
  }
  
  public final void ho(boolean paramBoolean)
  {
    AppMethodBeat.i(120593);
    Log.printInfoStack(this.TAG, bNL() + " startTimer, isLocalVideo:" + this.SDj, new Object[0]);
    if (!this.SDj) {
      super.ho(paramBoolean);
    }
    AppMethodBeat.o(120593);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(120584);
    super.initView();
    Object localObject = a.SmE;
    this.IAY = a.kb(getContext());
    this.SDm = new ImageView(getContext());
    localObject = this.SDm;
    if (localObject != null) {
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    localObject = this.SDm;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    RelativeLayout localRelativeLayout = this.sIW;
    FakeVideoViewLayer localFakeVideoViewLayer = this.IAY;
    localObject = localFakeVideoViewLayer;
    if (localFakeVideoViewLayer == null)
    {
      s.bIx("fakeLayer");
      localObject = null;
    }
    localRelativeLayout.addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
    this.sIW.addView((View)this.SDm, 0);
    this.ApV = ((TextView)findViewById(a.d.video_tips));
    AppMethodBeat.o(120584);
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(120595);
    if (this.SDj)
    {
      AppMethodBeat.o(120595);
      return false;
    }
    boolean bool = super.isLive();
    AppMethodBeat.o(120595);
    return bool;
  }
  
  public final void o(com.tencent.mm.plugin.story.model.d.j paramj)
  {
    Object localObject2 = null;
    AppMethodBeat.i(120589);
    Log.i(this.TAG, "resume, current play time:" + getCurrPosMs() + ", " + getCurrPosSec() + ", " + getVideoDurationSec() + ", isPrepared:" + this.hS + ", sessionId:" + this.sessionId + ", isLocalVideo:" + this.SDj);
    Object localObject3 = this.IAY;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("fakeLayer");
      localObject1 = null;
    }
    ((FakeVideoViewLayer)localObject1).Br(this.lAj);
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
    localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checkResumeLocalVideo, isLocalVideo:").append(this.SDj).append(", currentPosition:");
    localObject1 = this.wCd;
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i((String)localObject3, localObject1);
      if (!this.SDj) {
        break label340;
      }
      localObject1 = this.wCd;
      if (localObject1 != null) {
        break label314;
      }
      i = 0;
      label255:
      if (i <= 0) {
        break label340;
      }
      localObject1 = this.wCd;
      if (localObject1 != null) {
        break label325;
      }
      localObject1 = localObject2;
      label274:
      this.SDk = false;
    }
    label314:
    label325:
    label340:
    for (boolean bool = s.p(localObject1, Boolean.TRUE);; bool = false)
    {
      if (!bool) {
        break label345;
      }
      AppMethodBeat.o(120589);
      return;
      localObject1 = Integer.valueOf(((i)localObject1).getCurrentPosition());
      break;
      i = ((i)localObject1).getCurrentPosition();
      break label255;
      localObject1 = Boolean.valueOf(((i)localObject1).start());
      break label274;
    }
    label345:
    if ((getCurrPosMs() > 0) && (!this.SDj))
    {
      if (!this.hS)
      {
        this.sJi = true;
        bNS();
        AppMethodBeat.o(120589);
        return;
      }
      super.bNU();
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
    Log.i(this.TAG, "onCompletion, currPosMs:" + getCurrPosMs() + ", playStatus:" + this.oYt + ", downloadStatus:" + this.oYs);
    if (getCurrPosMs() <= 0)
    {
      AppMethodBeat.o(120586);
      return;
    }
    i.b localb = this.vZv;
    if (localb != null) {
      localb.em(getSessionId(), getMediaId());
    }
    super.onCompletion();
    AppMethodBeat.o(120586);
  }
  
  public final void onSeekComplete(boolean paramBoolean)
  {
    AppMethodBeat.i(120592);
    if (this.SDj)
    {
      AppMethodBeat.o(120592);
      return;
    }
    super.onSeekComplete(paramBoolean);
    AppMethodBeat.o(120592);
  }
  
  public final void onTextureUpdate()
  {
    AppMethodBeat.i(120610);
    super.onTextureUpdate();
    Object localObject = this.wCd;
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(120610);
      throw ((Throwable)localObject);
    }
    ((View)localObject).setAlpha(1.0F);
    String str;
    StringBuilder localStringBuilder;
    if (this.SDn <= 0L)
    {
      this.SDn = Util.ticksToNow(this.ork);
      str = this.TAG;
      localStringBuilder = new StringBuilder("onTextureUpdate firstPlayWaitTime ").append(this.SDn).append(" storyId: ");
      localObject = this.Smr;
      if (localObject != null) {
        break label125;
      }
    }
    label125:
    for (localObject = null;; localObject = Long.valueOf(((com.tencent.mm.plugin.story.model.d.j)localObject).idH))
    {
      Log.i(str, localObject);
      AppMethodBeat.o(120610);
      return;
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(120600);
    Log.i(this.TAG, s.X("onUIDestroy, isLocalVideo:", Boolean.valueOf(this.SDj)));
    FakeVideoViewLayer localFakeVideoViewLayer2 = this.IAY;
    FakeVideoViewLayer localFakeVideoViewLayer1 = localFakeVideoViewLayer2;
    if (localFakeVideoViewLayer2 == null)
    {
      s.bIx("fakeLayer");
      localFakeVideoViewLayer1 = null;
    }
    localFakeVideoViewLayer1.gJH();
    super.onUIDestroy();
    AppMethodBeat.o(120600);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(120598);
    Log.i(this.TAG, s.X("onUIPause, isLocalVideo:", Boolean.valueOf(this.SDj)));
    FakeVideoViewLayer localFakeVideoViewLayer = this.IAY;
    Object localObject = localFakeVideoViewLayer;
    if (localFakeVideoViewLayer == null)
    {
      s.bIx("fakeLayer");
      localObject = null;
    }
    ((FakeVideoViewLayer)localObject).gJG();
    if (this.SDj)
    {
      localObject = this.wCd;
      if (localObject != null)
      {
        ((i)localObject).pause();
        AppMethodBeat.o(120598);
      }
    }
    else
    {
      super.onUIPause();
    }
    AppMethodBeat.o(120598);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(120599);
    Log.i(this.TAG, s.X("onUIResume, isLocalVideo:", Boolean.valueOf(this.SDj)));
    if (isPlaying())
    {
      FakeVideoViewLayer localFakeVideoViewLayer2 = this.IAY;
      FakeVideoViewLayer localFakeVideoViewLayer1 = localFakeVideoViewLayer2;
      if (localFakeVideoViewLayer2 == null)
      {
        s.bIx("fakeLayer");
        localFakeVideoViewLayer1 = null;
      }
      localFakeVideoViewLayer1.Br(this.lAj);
    }
    if (this.SDj)
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
    Log.i(this.TAG, s.X("pause, isLocalVideo:", Boolean.valueOf(this.SDj)));
    FakeVideoViewLayer localFakeVideoViewLayer2 = this.IAY;
    FakeVideoViewLayer localFakeVideoViewLayer1 = localFakeVideoViewLayer2;
    if (localFakeVideoViewLayer2 == null)
    {
      s.bIx("fakeLayer");
      localFakeVideoViewLayer1 = null;
    }
    localFakeVideoViewLayer1.gJG();
    if (this.SDj)
    {
      this.SDk = true;
      this.wCd.pause();
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
    this.NXj = false;
    this.sessionId = null;
    AppMethodBeat.o(120618);
  }
  
  public final void setFirstPlayWaitTime(long paramLong)
  {
    this.SDn = paramLong;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(120588);
    super.setMute(paramBoolean);
    this.lAj = paramBoolean;
    if (this.wCd != null) {
      this.wCd.setMute(paramBoolean);
    }
    AppMethodBeat.o(120588);
  }
  
  public final void setNeedShowLoading(boolean paramBoolean)
  {
    AppMethodBeat.i(120596);
    Log.i(this.TAG, hashCode() + " setNeedShowLoading: " + paramBoolean);
    this.SDi = paramBoolean;
    if (!this.SDi) {
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
    if (this.SDi) {
      ku(800L);
    }
    AppMethodBeat.o(120597);
  }
  
  public final void start()
  {
    AppMethodBeat.i(120607);
    if ((this.diT > 0) && (!this.SDj))
    {
      Log.i(this.TAG, "start from onError and not local video");
      localObject = this.Smr;
      if (localObject != null)
      {
        r localr = r.Slb;
        localObject = r.a((com.tencent.mm.plugin.story.model.d.j)localObject);
        if (((n)localObject).aLI())
        {
          Log.i(this.TAG, "start from onError and download finish now");
          localObject = ((n)localObject).field_filePath;
          s.s(localObject, "videoCache.field_filePath");
          bcv((String)localObject);
          AppMethodBeat.o(120607);
          return;
        }
      }
    }
    Object localObject = this.oYr;
    s.s(localObject, "filepath");
    bcw((String)localObject);
    super.start();
    AppMethodBeat.o(120607);
  }
  
  public final void stop()
  {
    long l2 = 0L;
    com.tencent.mm.plugin.story.g.h localh = null;
    long l1 = 1L;
    AppMethodBeat.i(120608);
    for (;;)
    {
      try
      {
        Object localObject2 = this.IAY;
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("fakeLayer");
          localObject1 = null;
        }
        ((FakeVideoViewLayer)localObject1).gJH();
        if (this.SDj)
        {
          localObject2 = new ru();
          localObject1 = this.Smr;
          if (localObject1 == null)
          {
            localObject1 = localh;
            localObject1 = ((ru)localObject2).ys(String.valueOf(localObject1));
            localh = com.tencent.mm.plugin.story.g.h.SqZ;
            ((ru)localObject1).jwd = com.tencent.mm.plugin.story.g.h.hxW().jjn;
            localh = com.tencent.mm.plugin.story.g.h.SqZ;
            if (com.tencent.mm.plugin.story.g.h.hxW().jkG != 1L) {
              break label405;
            }
            ((ru)localObject1).jwf = l1;
            ((ru)localObject1).iYV = this.SDn;
            ((ru)localObject1).iZq = getStayTime();
            ((ru)localObject1).jwi = getErrorCode();
            ((ru)localObject1).jwB = 1L;
            localh = com.tencent.mm.plugin.story.g.h.SqZ;
            ((ru)localObject1).itb = com.tencent.mm.plugin.story.g.h.hxW().itb;
            localh = com.tencent.mm.plugin.story.g.h.SqZ;
            ((ru)localObject1).jwC = com.tencent.mm.plugin.story.g.h.hxW().iuE;
            ((ru)localObject1).jwg = getCurrPosMs();
            Log.d(this.TAG, "time distance %d", new Object[] { Long.valueOf(System.currentTimeMillis() - ((ru)localObject2).jwC) });
            if (System.currentTimeMillis() - ((ru)localObject2).jwC >= 500L)
            {
              localObject1 = this.Smr;
              if (localObject1 != null) {
                continue;
              }
              l1 = l2;
            }
          }
          try
          {
            localObject1 = StoryCore.SjP;
            StoryCore.b.gHI().post(new StoryVideoView..ExternalSyntheticLambda0(this, (ru)localObject2, l1));
            this.wCd.stop();
            reset();
            localObject1 = this.SDm;
            if (localObject1 != null)
            {
              ((ImageView)localObject1).setVisibility(8);
              AppMethodBeat.o(120608);
              return;
              localObject1 = Long.valueOf(((com.tencent.mm.plugin.story.model.d.j)localObject1).idH);
              continue;
              l1 = ((com.tencent.mm.plugin.story.model.d.j)localObject1).idH;
              continue;
            }
          }
          catch (Exception localException1)
          {
            Log.printErrStackTrace(this.TAG, (Throwable)localException1, "reportStopLocalVideo", new Object[0]);
            ((ru)localObject2).bMH();
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
      label405:
      l1 = 0L;
    }
  }
  
  public final void stopTimer()
  {
    AppMethodBeat.i(120594);
    Log.printInfoStack(this.TAG, bNL() + " stopTimer, isLocalVideo:" + this.SDj, new Object[0]);
    super.stopTimer();
    AppMethodBeat.o(120594);
  }
  
  public final boolean xb(int paramInt)
  {
    AppMethodBeat.i(120605);
    boolean bool = super.xb(paramInt);
    Log.i(this.TAG, "checkCanPlay, cachePlayTime:" + this.oYz + ", ret:" + bool);
    AppMethodBeat.o(120605);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView$playLocalVideo$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements i.a
  {
    b(StoryVideoView paramStoryVideoView) {}
    
    private static final void j(StoryVideoView paramStoryVideoView)
    {
      AppMethodBeat.i(367595);
      s.u(paramStoryVideoView, "this$0");
      Log.i(StoryVideoView.a(paramStoryVideoView), "onTextureUpdate");
      if (StoryVideoView.f(paramStoryVideoView) == null)
      {
        AppMethodBeat.o(367595);
        return;
      }
      paramStoryVideoView.hideLoading();
      paramStoryVideoView = StoryVideoView.f(paramStoryVideoView);
      if (paramStoryVideoView == null)
      {
        paramStoryVideoView = new NullPointerException("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(367595);
        throw paramStoryVideoView;
      }
      ((View)paramStoryVideoView).setAlpha(1.0F);
      AppMethodBeat.o(367595);
    }
    
    private static final void k(StoryVideoView paramStoryVideoView)
    {
      AppMethodBeat.i(367598);
      s.u(paramStoryVideoView, "this$0");
      paramStoryVideoView.setFirstPlayWaitTime(Util.ticksToNow(StoryVideoView.i(paramStoryVideoView)));
      MMHandlerThread.postToMainThreadDelayed(new StoryVideoView.b..ExternalSyntheticLambda1(paramStoryVideoView), 50L);
      AppMethodBeat.o(367598);
    }
    
    public final void Qz()
    {
      AppMethodBeat.i(120580);
      String str = StoryVideoView.a(this.SDo);
      StringBuilder localStringBuilder = new StringBuilder("localVideo onPrepared, isLocalVideoPause:").append(StoryVideoView.b(this.SDo)).append(", isFakeVideo:");
      Object localObject = StoryVideoView.c(this.SDo);
      int i;
      if (localObject == null)
      {
        localObject = null;
        Log.i(str, localObject + ", fakeStartTime:" + StoryVideoView.d(this.SDo) + ", fakeEndTime:" + StoryVideoView.e(this.SDo));
        if (!StoryVideoView.b(this.SDo))
        {
          localObject = StoryVideoView.c(this.SDo);
          if ((localObject == null) || (((com.tencent.mm.plugin.story.model.d.j)localObject).hwL() != true)) {
            break label205;
          }
          i = 1;
          label128:
          if ((i == 0) || (StoryVideoView.d(this.SDo) <= 0L)) {
            break label210;
          }
          StoryVideoView.f(this.SDo).c(StoryVideoView.d(this.SDo), true);
        }
      }
      for (;;)
      {
        StoryVideoView.f(this.SDo).setOneTimeVideoTextureUpdateCallback(new StoryVideoView.b..ExternalSyntheticLambda0(this.SDo));
        AppMethodBeat.o(120580);
        return;
        localObject = Boolean.valueOf(((com.tencent.mm.plugin.story.model.d.j)localObject).hwL());
        break;
        label205:
        i = 0;
        break label128;
        label210:
        StoryVideoView.f(this.SDo).start();
      }
    }
    
    public final void fG(int paramInt1, int paramInt2) {}
    
    public final int gw(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120582);
      com.tencent.mm.plugin.story.model.d.j localj = StoryVideoView.c(this.SDo);
      if ((localj != null) && (localj.hwL() == true))
      {
        paramInt2 = 1;
        if ((paramInt2 != 0) && (StoryVideoView.e(this.SDo) > 0L) && (paramInt1 >= StoryVideoView.e(this.SDo)))
        {
          Log.i(StoryVideoView.a(this.SDo), "fakeVideo exceed endTime, playTime:" + paramInt1 + ", fakeEndTime:" + StoryVideoView.e(this.SDo) + ", fakeStartTime:" + StoryVideoView.d(this.SDo));
          if (StoryVideoView.d(this.SDo) <= 0L) {
            break label157;
          }
          StoryVideoView.f(this.SDo).c(StoryVideoView.d(this.SDo), true);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(120582);
        return 0;
        paramInt2 = 0;
        break;
        label157:
        StoryVideoView.f(this.SDo).c(0.0D, true);
      }
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(120581);
      String str = StoryVideoView.a(this.SDo);
      StringBuilder localStringBuilder = new StringBuilder("localVideo onCompleted, isFakeVideo:");
      Object localObject = StoryVideoView.c(this.SDo);
      int i;
      if (localObject == null)
      {
        localObject = null;
        Log.i(str, localObject + ", fakeStartTime:" + StoryVideoView.d(this.SDo));
        localObject = StoryVideoView.c(this.SDo);
        if ((localObject == null) || (((com.tencent.mm.plugin.story.model.d.j)localObject).hwL() != true)) {
          break label174;
        }
        i = 1;
        label88:
        if ((i == 0) || (StoryVideoView.d(this.SDo) <= 0L)) {
          break label179;
        }
        StoryVideoView.f(this.SDo).c(StoryVideoView.d(this.SDo), true);
      }
      for (;;)
      {
        localObject = StoryVideoView.g(this.SDo);
        if (localObject != null) {
          ((i.b)localObject).em(this.SDo.getSessionId(), StoryVideoView.h(this.SDo));
        }
        AppMethodBeat.o(120581);
        return;
        localObject = Boolean.valueOf(((com.tencent.mm.plugin.story.model.d.j)localObject).hwL());
        break;
        label174:
        i = 0;
        break label88;
        label179:
        StoryVideoView.f(this.SDo).c(0.0D, true);
      }
    }
    
    public final void onError(int paramInt1, int paramInt2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoView
 * JD-Core Version:    0.7.0.1
 */