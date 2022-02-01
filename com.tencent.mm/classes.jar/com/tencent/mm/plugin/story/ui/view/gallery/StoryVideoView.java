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
import com.tencent.mm.g.b.a.fy;
import com.tencent.mm.g.b.a.hn;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.MMVideoView.a;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView;", "Lcom/tencent/mm/modelvideo/MMVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "C_TAG", "", "fakeBlurLayer", "Landroid/widget/ImageView;", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "firstPlayWaitTime", "", "getFirstPlayWaitTime", "()J", "setFirstPlayWaitTime", "(J)V", "isFakeVideo", "", "isLocalVideo", "isLocalVideoPause", "isMute", "needShowLoading", "sessionId", "startPlayTime", "surfaceAvailable", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "videoTips", "Landroid/widget/TextView;", "avgBlockTime", "", "blockCount", "calcDownloadRange", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "checkCanPlay", "checkLandscape", "", "blurBgPath", "checkNeedReset", "checkResumeLocalVideo", "createVideoView", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView;", "mContext", "fakeEndTime", "fakeStartTime", "getErrorCode", "getFilePath", "getSessionId", "getStayTime", "initView", "isLive", "isShowLoading", "moovCostTime", "onCompletion", "onFinish", "mediaId", "ret", "onGetVideoSize", "width", "height", "onProgress", "offset", "total", "onSeekComplete", "startPlay", "onSurfaceAvailable", "onTextureUpdate", "onUIDestroy", "onUIPause", "onUIResume", "pause", "play", "item", "playLocalVideo", "videoPath", "prepareVideo", "reportStopLocalVideo", "reset", "resume", "storyVideoItem", "setMute", "mute", "setNeedShowLoading", "show", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoPath", "url", "durationSec", "showDebugInfo", "path", "showLoading", "startTimer", "rightNow", "stop", "stopTimer", "Companion", "plugin-story_release"})
public final class StoryVideoView
  extends MMVideoView
{
  public static final StoryVideoView.a BfO;
  private com.tencent.mm.plugin.story.f.d.j AMA;
  private final String BfH;
  private boolean BfI;
  boolean BfJ;
  private boolean BfK;
  private boolean BfL;
  private ImageView BfM;
  private long BfN;
  private boolean fMP;
  private long hLG;
  private TextView rEY;
  private String sessionId;
  private FakeVideoViewLayer tZt;
  private boolean xNn;
  
  static
  {
    AppMethodBeat.i(120621);
    BfO = new StoryVideoView.a((byte)0);
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
    this.BfH = "MicroMsg.StoryVideoView";
    paramContext = com.tencent.mm.plugin.story.f.j.AKb;
    setRootPath(i.k(j.b.getAccStoryPath(), true));
    fbq();
    setIsShowBasicControls(false);
    paramContext = this.lte;
    p.g(paramContext, "footerRoot");
    paramContext.setVisibility(8);
    this.TAG = this.BfH;
    this.BfI = true;
    AppMethodBeat.o(120619);
  }
  
  private final void aCr(String paramString)
  {
    AppMethodBeat.i(120591);
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("playLocalVideo: ").append(paramString).append(", isPlayingNow:");
    com.tencent.mm.pluginsdk.ui.tools.h localh = this.oHt;
    p.g(localh, "videoView");
    ad.i((String)localObject1, localh.isPlaying());
    if (this.oHt == null) {
      this.oHt = cL(getContext());
    }
    reset();
    localObject1 = this.oHt;
    if (localObject1 != null) {
      ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).stop();
    }
    localObject1 = this.oHt;
    if (localObject1 != null) {
      if (!this.fMP)
      {
        if (!this.BfL) {
          break label204;
        }
        localObject2 = this.tZt;
        if (localObject2 == null) {
          p.bcb("fakeLayer");
        }
        if (!((FakeVideoViewLayer)localObject2).xHG) {
          break label204;
        }
      }
    }
    label204:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).setMute(bool);
      this.bzN = false;
      this.BfJ = true;
      setDownloadStatus(3);
      setNeedShowLoading(false);
      localObject1 = this.oHt;
      if (localObject1 != null) {
        break;
      }
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView");
      AppMethodBeat.o(120591);
      throw paramString;
    }
    ((StoryVideoPlayTextureView)localObject1).setNeedResetExtractor(cxy());
    localObject1 = this.oHt;
    p.g(localObject1, "videoView");
    ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).setVideoPath(paramString);
    this.hLG = bt.HI();
    this.BfN = 0L;
    localObject1 = com.tencent.mm.plugin.story.f.k.AKk;
    localObject1 = this.AMA;
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
    com.tencent.mm.plugin.story.f.k.aBC((String)localObject1);
    this.oHt.setVideoCallback((h.a)new b(this));
    this.BfK = false;
    this.sessionId = null;
    aCs(paramString);
    AppMethodBeat.o(120591);
  }
  
  private final void aCs(String paramString)
  {
    AppMethodBeat.i(120617);
    Object localObject = com.tencent.mm.kernel.g.ajC();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).ajl().get(al.a.Iwy, Integer.valueOf(0));
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(120617);
      throw paramString;
    }
    if (((Integer)localObject).intValue() == 1)
    {
      localObject = this.rEY;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.sight.base.e.aqM(paramString));
      }
      paramString = this.rEY;
      if (paramString != null)
      {
        paramString.setVisibility(0);
        AppMethodBeat.o(120617);
        return;
      }
    }
    AppMethodBeat.o(120617);
  }
  
  private final boolean cxy()
  {
    AppMethodBeat.i(120604);
    if (this.BfJ)
    {
      AppMethodBeat.o(120604);
      return false;
    }
    try
    {
      boolean bool = com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.IxQ, false);
      AppMethodBeat.o(120604);
      return bool;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(this.TAG, (Throwable)localException, "check need reset error", new Object[0]);
      AppMethodBeat.o(120604);
    }
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.story.f.d.j paramj, String paramString)
  {
    AppMethodBeat.i(120585);
    p.h(paramj, "item");
    Object localObject1 = this.rEY;
    if (localObject1 != null) {
      ((TextView)localObject1).setVisibility(8);
    }
    this.AMA = paramj;
    localObject1 = paramj.AMK;
    int i = paramj.hZE;
    this.BfL = false;
    Object localObject2 = this.tZt;
    if (localObject2 == null) {
      p.bcb("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject2).setVisibility(8);
    localObject2 = this.BfM;
    if (localObject2 != null) {
      ((ImageView)localObject2).setVisibility(8);
    }
    if (!paramj.eiN())
    {
      ad.i(this.TAG, "play empty item");
      showLoading();
      AppMethodBeat.o(120585);
      return;
    }
    if (paramj.eiM())
    {
      this.BfL = true;
      ad.i(this.TAG, "LogStory: play fake video");
      paramString = this.tZt;
      if (paramString == null) {
        p.bcb("fakeLayer");
      }
      paramString.setVisibility(0);
      paramj = paramj.AML;
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
        localObject1 = ar.ci(getContext());
        paramString = com.tencent.mm.sdk.platformtools.g.d(paramString, ((Point)localObject1).y, ((Point)localObject1).x, true);
        localObject1 = this.BfM;
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageBitmap(paramString);
        }
        paramString = this.BfM;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        label268:
        paramString = this.tZt;
        if (paramString == null) {
          p.bcb("fakeLayer");
        }
        paramString.setFakeVideoInfo(paramj);
        paramString = this.tZt;
        if (paramString == null) {
          p.bcb("fakeLayer");
        }
        paramString.pW(this.fMP);
        this.irN = paramj.dEE().videoPath;
        this.irM = "";
        paramj = this.irN;
        p.g(paramj, "filepath");
        aCr(paramj);
      }
    }
    for (;;)
    {
      setLoop(true);
      paramj = this.oHt;
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
      paramString = this.BfM;
      if (paramString == null) {
        break label268;
      }
      paramString.setVisibility(8);
      break label268;
      ad.i(this.TAG, "LogStory: play normal video");
      localObject2 = s.ALd;
      Object localObject3 = s.a((djl)localObject1);
      if (i.aYo((String)localObject3) > 0L)
      {
        ad.i(this.TAG, "play " + (String)localObject3 + " downloadDone now can play " + ((djl)localObject1).Id);
        this.irN = ((String)localObject3);
        if (localObject3 != null) {
          aCr((String)localObject3);
        }
      }
      else
      {
        localObject2 = s.ALd;
        localObject2 = s.a(paramj);
        int j = (int)i.aYo(((n)localObject2).field_filePath);
        ad.i(this.TAG, "play " + (String)localObject3 + " error try play from url or videoCache " + ((djl)localObject1).Id + " fileLength:" + j + " cacheSize:" + ((n)localObject2).field_cacheSize);
        if (j < ((n)localObject2).field_cacheSize)
        {
          ((n)localObject2).field_cacheSize = j;
          localObject3 = com.tencent.mm.plugin.story.f.j.AKb;
          j.b.ehX().b((n)localObject2);
        }
        ad.i(this.TAG, String.valueOf(localObject2));
        if ((((n)localObject2).XQ()) && (i.fv(((n)localObject2).field_filePath)))
        {
          ad.i(this.TAG, "play " + ((djl)localObject1).Id + " download finish");
          this.irN = ((n)localObject2).field_filePath;
          paramj = s.ALd;
          this.irM = s.cb(i, ((djl)localObject1).Url);
          paramj = this.irN;
          p.g(paramj, "filepath");
          aCr(paramj);
        }
        else
        {
          if ((((n)localObject2).XQ()) && (!i.fv(((n)localObject2).field_filePath)))
          {
            ad.i(this.TAG, "error downloadFinish " + ((n)localObject2).XQ() + " ret:" + i.fv(((n)localObject2).field_filePath));
            ((n)localObject2).elI();
            localObject3 = com.tencent.mm.plugin.story.f.j.AKb;
            j.b.ehX().b((n)localObject2);
          }
          ad.i(this.TAG, "play " + ((djl)localObject1).Id + ' ' + paramString + " start online play " + ((n)localObject2).field_filePath);
          reset();
          this.oHt.stop();
          this.oHt.setVideoCallback((h.a)this);
          this.BfJ = false;
          this.ltn = true;
          setNeedShowLoading(true);
          super.c(false, paramj.AMK.Url, (int)((djl)localObject1).Hyq);
          this.irN = ((n)localObject2).field_filePath;
          paramj = s.ALd;
          this.irM = s.cb(i, ((djl)localObject1).Url);
          this.sessionId = paramString;
          this.hLG = bt.HI();
          this.BfN = 0L;
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
    paramPInt1.value = Math.max(paramInt, this.irW);
    if (this.irQ == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.irX;
      localObject1 = "" + "step1;";
    }
    Object localObject2 = localObject1;
    if (this.irQ == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.irX + 8);
      localObject2 = (String)localObject1 + "step2;";
    }
    if (this.irQ == 3)
    {
      paramPInt1.value = this.irW;
      paramPInt2.value = (paramInt + 1 + this.isb.ish);
      localObject1 = (String)localObject2 + "step3;";
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (paramPInt2.value >= this.irS + 1)
      {
        paramPInt2.value = (this.irS + 1);
        localObject2 = (String)localObject1 + "step5;";
      }
      if (paramPInt2.value >= paramPInt1.value) {
        break;
      }
      paramPInt1.value += this.isb.ish;
      AppMethodBeat.o(120606);
      return false;
      localObject1 = localObject2;
      if (this.irQ == 4)
      {
        paramPInt1.value = this.irW;
        paramPInt2.value = (this.irX + paramInt + 1 + this.isb.ish);
        localObject1 = (String)localObject2 + "step4;";
      }
    }
    ad.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s] %s", new Object[] { boQ(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.irQ), Integer.valueOf(this.irW), Integer.valueOf(this.irX), this.irM, localObject2 });
    AppMethodBeat.o(120606);
    return true;
  }
  
  public final void aMv()
  {
    AppMethodBeat.i(120616);
    ad.i(this.TAG, "prepareVideo, surfaceAvailable:" + this.xNn);
    if (this.oHt != null)
    {
      localObject = this.oHt;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView");
        AppMethodBeat.o(120616);
        throw ((Throwable)localObject);
      }
      ((StoryVideoPlayTextureView)localObject).setNeedResetExtractor(cxy());
    }
    Object localObject = this.irN;
    p.g(localObject, "filepath");
    aCs((String)localObject);
    super.aMv();
    AppMethodBeat.o(120616);
  }
  
  public final void aMx()
  {
    AppMethodBeat.i(120615);
    super.aMx();
    ad.i(this.TAG, "onSurfaceAvailable");
    this.xNn = true;
    AppMethodBeat.o(120615);
  }
  
  public final void as(String paramString, int paramInt)
  {
    AppMethodBeat.i(120603);
    super.as(paramString, paramInt);
    AppMethodBeat.o(120603);
  }
  
  public final boolean bhH()
  {
    AppMethodBeat.i(120595);
    if (this.BfJ)
    {
      AppMethodBeat.o(120595);
      return false;
    }
    boolean bool = super.bhH();
    AppMethodBeat.o(120595);
    return bool;
  }
  
  public final void boT()
  {
    AppMethodBeat.i(120610);
    super.boT();
    Object localObject = this.oHt;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(120610);
      throw ((Throwable)localObject);
    }
    ((View)localObject).setAlpha(1.0F);
    String str;
    StringBuilder localStringBuilder;
    if (this.BfN <= 0L)
    {
      this.BfN = bt.aO(this.hLG);
      str = this.TAG;
      localStringBuilder = new StringBuilder("onTextureUpdate firstPlayWaitTime ").append(this.BfN).append(" storyId: ");
      localObject = this.AMA;
      if (localObject == null) {
        break label131;
      }
    }
    label131:
    for (localObject = Long.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject).dKt);; localObject = null)
    {
      ad.i(str, localObject);
      AppMethodBeat.o(120610);
      return;
    }
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(221435);
    super.c(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(221435);
  }
  
  public final com.tencent.mm.pluginsdk.ui.tools.h cL(Context paramContext)
  {
    AppMethodBeat.i(120614);
    paramContext = new StoryVideoPlayTextureView(paramContext);
    paramContext.setOpenWithNoneSurface(true);
    paramContext.setNeedResetExtractor(cxy());
    paramContext.setIsOnlineVideoType(true);
    paramContext = (com.tencent.mm.pluginsdk.ui.tools.h)paramContext;
    AppMethodBeat.o(120614);
    return paramContext;
  }
  
  public final void eU(boolean paramBoolean)
  {
    AppMethodBeat.i(120592);
    if (this.BfJ)
    {
      AppMethodBeat.o(120592);
      return;
    }
    super.eU(paramBoolean);
    AppMethodBeat.o(120592);
  }
  
  public final void eV(boolean paramBoolean)
  {
    AppMethodBeat.i(120593);
    ad.m(this.TAG, boQ() + " startTimer, isLocalVideo:" + this.BfJ, new Object[0]);
    if (!this.BfJ) {
      super.eV(paramBoolean);
    }
    AppMethodBeat.o(120593);
  }
  
  public final void eb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120602);
    super.eb(paramInt1, paramInt2);
    ad.i(this.TAG, "onGetVideoSize, mediaId:" + getMediaId() + ", isLocalVideo:" + this.BfJ + ", isPrepareVideo:" + this.irY + ", isPrepared:" + this.Zn + ", playerStatus:" + this.irQ + ", downloadStatus:" + this.irP);
    AppMethodBeat.o(120602);
  }
  
  public final int emA()
  {
    return this.ERL.blockCount;
  }
  
  public final int emB()
  {
    if (this.ERL.blockCount > 0) {
      return (int)(this.ERL.ETM / this.ERL.blockCount);
    }
    return 0;
  }
  
  public final int emz()
  {
    if (this.ERL.zUz > this.ERL.lkv) {
      return (int)(this.ERL.zUz - this.ERL.lkv);
    }
    return 0;
  }
  
  public final int getErrorCode()
  {
    return this.ERL.lBr;
  }
  
  public final String getFilePath()
  {
    AppMethodBeat.i(120612);
    String str = this.irN;
    p.g(str, "filepath");
    AppMethodBeat.o(120612);
    return str;
  }
  
  public final long getFirstPlayWaitTime()
  {
    return this.BfN;
  }
  
  public final String getSessionId()
  {
    AppMethodBeat.i(120587);
    String str = bt.nullAsNil(this.sessionId);
    p.g(str, "Util.nullAsNil(sessionId)");
    AppMethodBeat.o(120587);
    return str;
  }
  
  public final int getStayTime()
  {
    AppMethodBeat.i(120611);
    int i = (int)bt.aO(this.hLG);
    AppMethodBeat.o(120611);
    return i;
  }
  
  public final void i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(120601);
    if (!bt.lQ(this.irM, paramString))
    {
      AppMethodBeat.o(120601);
      return;
    }
    paramString = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("%s download  onProgress [%d, %d], pauseByLoadData:").append(this.irV).append(", playStatus:").append(this.irQ).append(", currPosMs:").append(getCurrPosMs()).append(", isPlyaing:");
    com.tencent.mm.pluginsdk.ui.tools.h localh = this.oHt;
    p.g(localh, "videoView");
    ad.d(paramString, localh.isPlaying(), new Object[] { boQ(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (((getCurrPosMs() <= 0) || (this.irQ == 1) || (this.irQ == 0)) && (qi(getCurrPosSec()))) {
      eV(true);
    }
    AppMethodBeat.o(120601);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(120584);
    super.initView();
    Object localObject = com.tencent.mm.plugin.story.f.e.a.AMT;
    this.tZt = com.tencent.mm.plugin.story.f.e.a.gu(getContext());
    this.BfM = new ImageView(getContext());
    localObject = this.BfM;
    if (localObject != null) {
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    localObject = this.BfM;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.ltb;
    FakeVideoViewLayer localFakeVideoViewLayer = this.tZt;
    if (localFakeVideoViewLayer == null) {
      p.bcb("fakeLayer");
    }
    ((RelativeLayout)localObject).addView((View)localFakeVideoViewLayer, new ViewGroup.LayoutParams(-1, -1));
    this.ltb.addView((View)this.BfM, 0);
    this.rEY = ((TextView)findViewById(2131306403));
    AppMethodBeat.o(120584);
  }
  
  public final void o(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    Object localObject2 = null;
    AppMethodBeat.i(120589);
    ad.i(this.TAG, "resume, current play time:" + getCurrPosMs() + ", " + getCurrPosSec() + ", " + getVideoDurationSec() + ", isPrepared:" + this.Zn + ", sessionId:" + this.sessionId + ", isLocalVideo:" + this.BfJ);
    Object localObject1 = this.tZt;
    if (localObject1 == null) {
      p.bcb("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject1).pW(this.fMP);
    if (getCurrPosSec() >= getVideoDurationSec())
    {
      ad.i(this.TAG, "resume, restart video");
      if (paramj != null)
      {
        a(paramj, this.sessionId);
        AppMethodBeat.o(120589);
        return;
      }
    }
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checkResumeLocalVideo, isLocalVideo:").append(this.BfJ).append(", currentPosition:");
    localObject1 = this.oHt;
    int i;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getCurrentPosition());
      ad.i((String)localObject3, localObject1);
      if (!this.BfJ) {
        break label330;
      }
      localObject1 = this.oHt;
      if (localObject1 == null) {
        break label325;
      }
      i = ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getCurrentPosition();
      label263:
      if (i <= 0) {
        break label330;
      }
      localObject3 = this.oHt;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = Boolean.valueOf(((com.tencent.mm.pluginsdk.ui.tools.h)localObject3).start());
      }
      this.BfK = false;
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
    if ((getCurrPosMs() > 0) && (!this.BfJ))
    {
      if (!this.Zn)
      {
        this.ltn = true;
        aMv();
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
    ad.i(this.TAG, "onCompletion, currPosMs:" + getCurrPosMs() + ", playStatus:" + this.irQ + ", downloadStatus:" + this.irP);
    if (getCurrPosMs() <= 0)
    {
      AppMethodBeat.o(120586);
      return;
    }
    i.b localb = this.osZ;
    if (localb != null) {
      localb.dr(getSessionId(), getMediaId());
    }
    super.onCompletion();
    AppMethodBeat.o(120586);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(120600);
    ad.i(this.TAG, "onUIDestroy, isLocalVideo:" + this.BfJ);
    FakeVideoViewLayer localFakeVideoViewLayer = this.tZt;
    if (localFakeVideoViewLayer == null) {
      p.bcb("fakeLayer");
    }
    localFakeVideoViewLayer.dHl();
    super.onUIDestroy();
    AppMethodBeat.o(120600);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(120598);
    ad.i(this.TAG, "onUIPause, isLocalVideo:" + this.BfJ);
    Object localObject = this.tZt;
    if (localObject == null) {
      p.bcb("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject).dHk();
    if (this.BfJ)
    {
      localObject = this.oHt;
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
    ad.i(this.TAG, "onUIResume, isLocalVideo:" + this.BfJ);
    if (isPlaying())
    {
      FakeVideoViewLayer localFakeVideoViewLayer = this.tZt;
      if (localFakeVideoViewLayer == null) {
        p.bcb("fakeLayer");
      }
      localFakeVideoViewLayer.pW(this.fMP);
    }
    if (this.BfJ)
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
    ad.i(this.TAG, "pause, isLocalVideo:" + this.BfJ);
    FakeVideoViewLayer localFakeVideoViewLayer = this.tZt;
    if (localFakeVideoViewLayer == null) {
      p.bcb("fakeLayer");
    }
    localFakeVideoViewLayer.dHk();
    if (this.BfJ)
    {
      this.BfK = true;
      this.oHt.pause();
      AppMethodBeat.o(120590);
      return true;
    }
    boolean bool = super.pause();
    AppMethodBeat.o(120590);
    return bool;
  }
  
  public final boolean qj(int paramInt)
  {
    AppMethodBeat.i(120605);
    boolean bool = super.qj(paramInt);
    ad.i(this.TAG, "checkCanPlay, cachePlayTime:" + this.irW + ", ret:" + bool);
    AppMethodBeat.o(120605);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(120618);
    super.reset();
    this.xNn = false;
    this.sessionId = null;
    AppMethodBeat.o(120618);
  }
  
  public final void setFirstPlayWaitTime(long paramLong)
  {
    this.BfN = paramLong;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(120588);
    super.setMute(paramBoolean);
    this.fMP = paramBoolean;
    if (this.oHt != null) {
      this.oHt.setMute(paramBoolean);
    }
    AppMethodBeat.o(120588);
  }
  
  public final void setNeedShowLoading(boolean paramBoolean)
  {
    AppMethodBeat.i(120596);
    ad.i(this.TAG, hashCode() + " setNeedShowLoading: " + paramBoolean);
    this.BfI = paramBoolean;
    if (!this.BfI) {
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
    if (this.BfI) {
      tx(800L);
    }
    AppMethodBeat.o(120597);
  }
  
  public final void start()
  {
    AppMethodBeat.i(120607);
    if ((this.bFv > 0) && (!this.BfJ))
    {
      ad.i(this.TAG, "start from onError and not local video");
      localObject = this.AMA;
      if (localObject != null)
      {
        s locals = s.ALd;
        localObject = s.a((com.tencent.mm.plugin.story.f.d.j)localObject);
        if (((n)localObject).XQ())
        {
          ad.i(this.TAG, "start from onError and download finish now");
          localObject = ((n)localObject).field_filePath;
          p.g(localObject, "videoCache.field_filePath");
          aCr((String)localObject);
          AppMethodBeat.o(120607);
          return;
        }
      }
    }
    Object localObject = this.irN;
    p.g(localObject, "filepath");
    aCs((String)localObject);
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
        Object localObject1 = this.tZt;
        if (localObject1 == null) {
          p.bcb("fakeLayer");
        }
        ((FakeVideoViewLayer)localObject1).dHl();
        if (this.BfJ)
        {
          final hn localhn = new hn();
          localObject1 = this.AMA;
          if (localObject1 == null) {
            break label362;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject1).dKt);
          localObject1 = localhn.qd(String.valueOf(localObject1));
          com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.ASt;
          localObject1 = ((hn)localObject1).mn(com.tencent.mm.plugin.story.h.h.ejZ().TB());
          localh = com.tencent.mm.plugin.story.h.h.ASt;
          if (com.tencent.mm.plugin.story.h.h.ejZ().TG() != 1L) {
            break label367;
          }
          localObject1 = ((hn)localObject1).mp(l).ms(this.BfN).mw(getStayTime()).mx(getErrorCode()).mU(1L);
          localh = com.tencent.mm.plugin.story.h.h.ASt;
          localObject1 = ((hn)localObject1).mV(com.tencent.mm.plugin.story.h.h.ejZ().TA());
          localh = com.tencent.mm.plugin.story.h.h.ASt;
          ((hn)localObject1).mW(com.tencent.mm.plugin.story.h.h.ejZ().TD()).mr(getCurrPosMs());
          ad.d(this.TAG, "time distance %d", new Object[] { Long.valueOf(System.currentTimeMillis() - localhn.UB()) });
          if (System.currentTimeMillis() - localhn.UB() >= 500L)
          {
            localObject1 = this.AMA;
            if (localObject1 == null) {
              break label372;
            }
            l = ((com.tencent.mm.plugin.story.f.d.j)localObject1).dKt;
          }
          try
          {
            localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
            j.b.dFL().post((Runnable)new c(this, localhn, l));
            this.oHt.stop();
            reset();
            localObject1 = this.BfM;
            if (localObject1 == null) {
              break label355;
            }
            ((ImageView)localObject1).setVisibility(8);
            AppMethodBeat.o(120608);
            return;
          }
          catch (Exception localException1)
          {
            ad.printErrStackTrace(this.TAG, (Throwable)localException1, "reportStopLocalVideo", new Object[0]);
            localhn.aLk();
            continue;
          }
        }
        super.stop();
      }
      catch (Exception localException2)
      {
        ad.printErrStackTrace(this.TAG, (Throwable)localException2, "stop error", new Object[0]);
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
    ad.m(this.TAG, boQ() + " stopTimer, isLocalVideo:" + this.BfJ, new Object[0]);
    super.stopTimer();
    AppMethodBeat.o(120594);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView$playLocalVideo$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-story_release"})
  public static final class b
    implements h.a
  {
    public final int eT(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120582);
      com.tencent.mm.plugin.story.f.d.j localj = StoryVideoView.c(this.BfP);
      if ((localj != null) && (localj.eiM() == true) && (StoryVideoView.e(this.BfP) > 0L) && (paramInt1 >= StoryVideoView.e(this.BfP)))
      {
        ad.i(StoryVideoView.a(this.BfP), "fakeVideo exceed endTime, playTime:" + paramInt1 + ", fakeEndTime:" + StoryVideoView.e(this.BfP) + ", fakeStartTime:" + StoryVideoView.d(this.BfP));
        if (StoryVideoView.d(this.BfP) <= 0L) {
          break label146;
        }
        StoryVideoView.f(this.BfP).d(StoryVideoView.d(this.BfP), true);
      }
      for (;;)
      {
        AppMethodBeat.o(120582);
        return 0;
        label146:
        StoryVideoView.f(this.BfP).d(0.0D, true);
      }
    }
    
    public final void eb(int paramInt1, int paramInt2) {}
    
    public final void onCompletion()
    {
      AppMethodBeat.i(120581);
      String str = StoryVideoView.a(this.BfP);
      StringBuilder localStringBuilder = new StringBuilder("localVideo onCompleted, isFakeVideo:");
      Object localObject = StoryVideoView.c(this.BfP);
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject).eiM());
        ad.i(str, localObject + ", fakeStartTime:" + StoryVideoView.d(this.BfP));
        localObject = StoryVideoView.c(this.BfP);
        if ((localObject == null) || (((com.tencent.mm.plugin.story.f.d.j)localObject).eiM() != true) || (StoryVideoView.d(this.BfP) <= 0L)) {
          break label166;
        }
        StoryVideoView.f(this.BfP).d(StoryVideoView.d(this.BfP), true);
      }
      for (;;)
      {
        localObject = StoryVideoView.h(this.BfP);
        if (localObject == null) {
          break label183;
        }
        ((i.b)localObject).dr(this.BfP.getSessionId(), StoryVideoView.i(this.BfP));
        AppMethodBeat.o(120581);
        return;
        localObject = null;
        break;
        label166:
        StoryVideoView.f(this.BfP).d(0.0D, true);
      }
      label183:
      AppMethodBeat.o(120581);
    }
    
    public final void onError(int paramInt1, int paramInt2) {}
    
    public final void ta()
    {
      AppMethodBeat.i(120580);
      String str = StoryVideoView.a(this.BfP);
      StringBuilder localStringBuilder = new StringBuilder("localVideo onPrepared, isLocalVideoPause:").append(StoryVideoView.b(this.BfP)).append(", isFakeVideo:");
      Object localObject = StoryVideoView.c(this.BfP);
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject).eiM());
        ad.i(str, localObject + ", fakeStartTime:" + StoryVideoView.d(this.BfP) + ", fakeEndTime:" + StoryVideoView.e(this.BfP));
        if (!StoryVideoView.b(this.BfP))
        {
          localObject = StoryVideoView.c(this.BfP);
          if ((localObject == null) || (((com.tencent.mm.plugin.story.f.d.j)localObject).eiM() != true) || (StoryVideoView.d(this.BfP) <= 0L)) {
            break label197;
          }
          StoryVideoView.f(this.BfP).d(StoryVideoView.d(this.BfP), true);
        }
      }
      for (;;)
      {
        StoryVideoView.f(this.BfP).setOneTimeVideoTextureUpdateCallback((h.e)new a(this));
        AppMethodBeat.o(120580);
        return;
        localObject = null;
        break;
        label197:
        StoryVideoView.f(this.BfP).start();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onTextureUpdate"})
    static final class a
      implements h.e
    {
      a(StoryVideoView.b paramb) {}
      
      public final void boT()
      {
        AppMethodBeat.i(120579);
        this.BfQ.BfP.setFirstPlayWaitTime(bt.aO(StoryVideoView.g(this.BfQ.BfP)));
        aq.o((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(120578);
            ad.i(StoryVideoView.a(this.BfR.BfQ.BfP), "onTextureUpdate");
            if (StoryVideoView.f(this.BfR.BfQ.BfP) == null)
            {
              AppMethodBeat.o(120578);
              return;
            }
            this.BfR.BfQ.BfP.hideLoading();
            Object localObject = StoryVideoView.f(this.BfR.BfQ.BfP);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(StoryVideoView paramStoryVideoView, hn paramhn, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(120583);
      ad.i(StoryVideoView.a(this.BfP), "reportStopLocalVideo");
      com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.e.axx(StoryVideoView.j(this.BfP));
      if (locala != null)
      {
        hn localhn = localhn.mq(locala.videoDuration);
        j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
        localhn.mo(j.b.ehT().AY(l)).my(locala.videoBitrate).aLk();
      }
      AppMethodBeat.o(120583);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoView
 * JD-Core Version:    0.7.0.1
 */