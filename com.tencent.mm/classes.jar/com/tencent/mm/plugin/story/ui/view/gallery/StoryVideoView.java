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
import com.tencent.mm.g.b.a.dl;
import com.tencent.mm.g.b.a.eu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.MMVideoView.a;
import com.tencent.mm.plugin.recordvideo.background.d;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.vfs.i;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView;", "Lcom/tencent/mm/modelvideo/MMVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "C_TAG", "", "fakeBlurLayer", "Landroid/widget/ImageView;", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "firstPlayWaitTime", "", "getFirstPlayWaitTime", "()J", "setFirstPlayWaitTime", "(J)V", "isFakeVideo", "", "isLocalVideo", "isLocalVideoPause", "isMute", "needShowLoading", "sessionId", "startPlayTime", "surfaceAvailable", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "videoTips", "Landroid/widget/TextView;", "avgBlockTime", "", "blockCount", "calcDownloadRange", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "checkCanPlay", "checkLandscape", "", "blurBgPath", "checkNeedReset", "checkResumeLocalVideo", "createVideoView", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView;", "mContext", "fakeEndTime", "fakeStartTime", "getErrorCode", "getFilePath", "getSessionId", "getStayTime", "initView", "isLive", "isShowLoading", "moovCostTime", "onCompletion", "onFinish", "mediaId", "ret", "onGetVideoSize", "width", "height", "onProgress", "offset", "total", "onSeekComplete", "startPlay", "onSurfaceAvailable", "onTextureUpdate", "onUIDestroy", "onUIPause", "onUIResume", "pause", "play", "item", "playLocalVideo", "videoPath", "prepareVideo", "reportStopLocalVideo", "reset", "resume", "storyVideoItem", "setMute", "mute", "setNeedShowLoading", "show", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoPath", "url", "durationSec", "showDebugInfo", "path", "showLoading", "startTimer", "rightNow", "stop", "stopTimer", "Companion", "plugin-story_release"})
public final class StoryVideoView
  extends MMVideoView
{
  public static final a yAZ;
  private boolean fqj;
  private long gSP;
  private TextView qmi;
  private FakeVideoViewLayer rTL;
  private String sessionId;
  private boolean vso;
  private final String yAS;
  private boolean yAT;
  boolean yAU;
  private boolean yAV;
  private boolean yAW;
  private ImageView yAX;
  private long yAY;
  private com.tencent.mm.plugin.story.f.d.j yhF;
  
  static
  {
    AppMethodBeat.i(120621);
    yAZ = new a((byte)0);
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
    this.yAS = "MicroMsg.StoryVideoView";
    paramContext = com.tencent.mm.plugin.story.f.j.yfh;
    setRootPath(i.k(j.b.getAccStoryPath(), true));
    ewZ();
    setIsShowBasicControls(false);
    paramContext = this.kuR;
    d.g.b.k.g(paramContext, "footerRoot");
    paramContext.setVisibility(8);
    this.TAG = this.yAS;
    this.yAT = true;
    AppMethodBeat.o(120619);
  }
  
  private final void ase(String paramString)
  {
    AppMethodBeat.i(120591);
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("playLocalVideo: ").append(paramString).append(", isPlayingNow:");
    com.tencent.mm.pluginsdk.ui.tools.h localh = this.nAZ;
    d.g.b.k.g(localh, "videoView");
    ad.i((String)localObject1, localh.isPlaying());
    if (this.nAZ == null) {
      this.nAZ = cF(getContext());
    }
    reset();
    localObject1 = this.nAZ;
    if (localObject1 != null) {
      ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).stop();
    }
    localObject1 = this.nAZ;
    if (localObject1 != null) {
      if (!this.fqj)
      {
        if (!this.yAW) {
          break label204;
        }
        localObject2 = this.rTL;
        if (localObject2 == null) {
          d.g.b.k.aPZ("fakeLayer");
        }
        if (!((FakeVideoViewLayer)localObject2).vpE) {
          break label204;
        }
      }
    }
    label204:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).setMute(bool);
      this.bqS = false;
      this.yAU = true;
      setDownloadStatus(3);
      setNeedShowLoading(false);
      localObject1 = this.nAZ;
      if (localObject1 != null) {
        break;
      }
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView");
      AppMethodBeat.o(120591);
      throw paramString;
    }
    ((StoryVideoPlayTextureView)localObject1).setNeedResetExtractor(ckf());
    localObject1 = this.nAZ;
    d.g.b.k.g(localObject1, "videoView");
    ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).setVideoPath(paramString);
    this.gSP = bt.GC();
    this.yAY = 0L;
    localObject1 = com.tencent.mm.plugin.story.f.k.yfq;
    localObject1 = this.yhF;
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
    com.tencent.mm.plugin.story.f.k.aro((String)localObject1);
    this.nAZ.setVideoCallback((h.a)new b(this));
    this.yAV = false;
    this.sessionId = null;
    asf(paramString);
    AppMethodBeat.o(120591);
  }
  
  private final void asf(String paramString)
  {
    AppMethodBeat.i(120617);
    Object localObject = g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).afk().get(ae.a.Fmr, Integer.valueOf(0));
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(120617);
      throw paramString;
    }
    if (((Integer)localObject).intValue() == 1)
    {
      localObject = this.qmi;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.sight.base.e.ahc(paramString));
      }
      paramString = this.qmi;
      if (paramString != null)
      {
        paramString.setVisibility(0);
        AppMethodBeat.o(120617);
        return;
      }
    }
    AppMethodBeat.o(120617);
  }
  
  private final boolean ckf()
  {
    AppMethodBeat.i(120604);
    if (this.yAU)
    {
      AppMethodBeat.o(120604);
      return false;
    }
    try
    {
      boolean bool = g.afB().afk().getBoolean(ae.a.FnJ, false);
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
    d.g.b.k.h(paramj, "item");
    Object localObject1 = this.qmi;
    if (localObject1 != null) {
      ((TextView)localObject1).setVisibility(8);
    }
    this.yhF = paramj;
    localObject1 = paramj.yhP;
    int i = paramj.hgr;
    this.yAW = false;
    Object localObject2 = this.rTL;
    if (localObject2 == null) {
      d.g.b.k.aPZ("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject2).setVisibility(8);
    localObject2 = this.yAX;
    if (localObject2 != null) {
      ((ImageView)localObject2).setVisibility(8);
    }
    if (!paramj.dHX())
    {
      ad.i(this.TAG, "play empty item");
      showLoading();
      AppMethodBeat.o(120585);
      return;
    }
    if (paramj.dHW())
    {
      this.yAW = true;
      ad.i(this.TAG, "LogStory: play fake video");
      paramString = this.rTL;
      if (paramString == null) {
        d.g.b.k.aPZ("fakeLayer");
      }
      paramString.setVisibility(0);
      paramj = paramj.yhQ;
      if (paramj != null)
      {
        paramString = paramj.field_blurBgPath;
        d.g.b.k.g(paramString, "fakeData.field_blurBgPath");
        localObject1 = (CharSequence)paramString;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label379;
        }
        i = 1;
        if (i != 0) {
          break label384;
        }
        localObject1 = com.tencent.mm.ui.ap.cf(getContext());
        paramString = f.e(paramString, ((Point)localObject1).y, ((Point)localObject1).x, true);
        localObject1 = this.yAX;
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageBitmap(paramString);
        }
        paramString = this.yAX;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        label268:
        paramString = this.rTL;
        if (paramString == null) {
          d.g.b.k.aPZ("fakeLayer");
        }
        paramString.setFakeVideoInfo(paramj);
        paramString = this.rTL;
        if (paramString == null) {
          d.g.b.k.aPZ("fakeLayer");
        }
        paramString.oC(this.fqj);
        this.hxQ = paramj.dgA().videoPath;
        this.hxP = "";
        paramj = this.hxQ;
        d.g.b.k.g(paramj, "filepath");
        ase(paramj);
      }
    }
    for (;;)
    {
      setLoop(true);
      paramj = this.nAZ;
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
      paramString = this.yAX;
      if (paramString == null) {
        break label268;
      }
      paramString.setVisibility(8);
      break label268;
      ad.i(this.TAG, "LogStory: play normal video");
      localObject2 = s.ygj;
      Object localObject3 = s.a((cym)localObject1);
      if (i.aMN((String)localObject3) > 0L)
      {
        ad.i(this.TAG, "play " + (String)localObject3 + " downloadDone now can play " + ((cym)localObject1).Id);
        this.hxQ = ((String)localObject3);
        if (localObject3 != null) {
          ase((String)localObject3);
        }
      }
      else
      {
        localObject2 = s.ygj;
        localObject2 = s.a(paramj);
        int j = (int)i.aMN(((n)localObject2).field_filePath);
        ad.i(this.TAG, "play " + (String)localObject3 + " error try play from url or videoCache " + ((cym)localObject1).Id + " fileLength:" + j + " cacheSize:" + ((n)localObject2).field_cacheSize);
        if (j < ((n)localObject2).field_cacheSize)
        {
          ((n)localObject2).field_cacheSize = j;
          localObject3 = com.tencent.mm.plugin.story.f.j.yfh;
          j.b.dHh().b((n)localObject2);
        }
        ad.i(this.TAG, String.valueOf(localObject2));
        if ((((n)localObject2).UE()) && (i.eK(((n)localObject2).field_filePath)))
        {
          ad.i(this.TAG, "play " + ((cym)localObject1).Id + " download finish");
          this.hxQ = ((n)localObject2).field_filePath;
          paramj = s.ygj;
          this.hxP = s.bQ(i, ((cym)localObject1).Url);
          paramj = this.hxQ;
          d.g.b.k.g(paramj, "filepath");
          ase(paramj);
        }
        else
        {
          if ((((n)localObject2).UE()) && (!i.eK(((n)localObject2).field_filePath)))
          {
            ad.i(this.TAG, "error downloadFinish " + ((n)localObject2).UE() + " ret:" + i.eK(((n)localObject2).field_filePath));
            ((n)localObject2).dKS();
            localObject3 = com.tencent.mm.plugin.story.f.j.yfh;
            j.b.dHh().b((n)localObject2);
          }
          ad.i(this.TAG, "play " + ((cym)localObject1).Id + ' ' + paramString + " start online play " + ((n)localObject2).field_filePath);
          reset();
          this.nAZ.stop();
          this.nAZ.setVideoCallback((h.a)this);
          this.yAU = false;
          this.kva = true;
          setNeedShowLoading(true);
          super.c(false, paramj.yhP.Url, (int)((cym)localObject1).EqD);
          this.hxQ = ((n)localObject2).field_filePath;
          paramj = s.ygj;
          this.hxP = s.bQ(i, ((cym)localObject1).Url);
          this.sessionId = paramString;
          this.gSP = bt.GC();
          this.yAY = 0L;
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
    d.g.b.k.h(paramPInt1, "start");
    d.g.b.k.h(paramPInt2, "end");
    Object localObject1 = "";
    paramPInt1.value = Math.max(paramInt, this.hxZ);
    if (this.hxT == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.hya;
      localObject1 = "" + "step1;";
    }
    Object localObject2 = localObject1;
    if (this.hxT == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.hya + 8);
      localObject2 = (String)localObject1 + "step2;";
    }
    if (this.hxT == 3)
    {
      paramPInt1.value = this.hxZ;
      paramPInt2.value = (paramInt + 1 + this.hye.hyk);
      localObject1 = (String)localObject2 + "step3;";
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (paramPInt2.value >= this.hxV + 1)
      {
        paramPInt2.value = (this.hxV + 1);
        localObject2 = (String)localObject1 + "step5;";
      }
      if (paramPInt2.value >= paramPInt1.value) {
        break;
      }
      paramPInt1.value += this.hye.hyk;
      AppMethodBeat.o(120606);
      return false;
      localObject1 = localObject2;
      if (this.hxT == 4)
      {
        paramPInt1.value = this.hxZ;
        paramPInt2.value = (this.hya + paramInt + 1 + this.hye.hyk);
        localObject1 = (String)localObject2 + "step4;";
      }
    }
    ad.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s] %s", new Object[] { bel(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.hxT), Integer.valueOf(this.hxZ), Integer.valueOf(this.hya), this.hxP, localObject2 });
    AppMethodBeat.o(120606);
    return true;
  }
  
  public final void aCu()
  {
    AppMethodBeat.i(120616);
    ad.i(this.TAG, "prepareVideo, surfaceAvailable:" + this.vso);
    if (this.nAZ != null)
    {
      localObject = this.nAZ;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView");
        AppMethodBeat.o(120616);
        throw ((Throwable)localObject);
      }
      ((StoryVideoPlayTextureView)localObject).setNeedResetExtractor(ckf());
    }
    Object localObject = this.hxQ;
    d.g.b.k.g(localObject, "filepath");
    asf((String)localObject);
    super.aCu();
    AppMethodBeat.o(120616);
  }
  
  public final void aCw()
  {
    AppMethodBeat.i(120615);
    super.aCw();
    ad.i(this.TAG, "onSurfaceAvailable");
    this.vso = true;
    AppMethodBeat.o(120615);
  }
  
  public final boolean aXf()
  {
    AppMethodBeat.i(120595);
    if (this.yAU)
    {
      AppMethodBeat.o(120595);
      return false;
    }
    boolean bool = super.aXf();
    AppMethodBeat.o(120595);
    return bool;
  }
  
  public final void am(String paramString, int paramInt)
  {
    AppMethodBeat.i(120603);
    super.am(paramString, paramInt);
    AppMethodBeat.o(120603);
  }
  
  public final void beo()
  {
    AppMethodBeat.i(120610);
    super.beo();
    Object localObject = this.nAZ;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(120610);
      throw ((Throwable)localObject);
    }
    ((View)localObject).setAlpha(1.0F);
    String str;
    StringBuilder localStringBuilder;
    if (this.yAY <= 0L)
    {
      this.yAY = bt.aS(this.gSP);
      str = this.TAG;
      localStringBuilder = new StringBuilder("onTextureUpdate firstPlayWaitTime ").append(this.yAY).append(" storyId: ");
      localObject = this.yhF;
      if (localObject == null) {
        break label131;
      }
    }
    label131:
    for (localObject = Long.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject).dAu);; localObject = null)
    {
      ad.i(str, localObject);
      AppMethodBeat.o(120610);
      return;
    }
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(204837);
    super.c(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(204837);
  }
  
  public final com.tencent.mm.pluginsdk.ui.tools.h cF(Context paramContext)
  {
    AppMethodBeat.i(120614);
    paramContext = new StoryVideoPlayTextureView(paramContext);
    paramContext.setOpenWithNoneSurface(true);
    paramContext.setNeedResetExtractor(ckf());
    paramContext.setIsOnlineVideoType(true);
    paramContext = (com.tencent.mm.pluginsdk.ui.tools.h)paramContext;
    AppMethodBeat.o(120614);
    return paramContext;
  }
  
  public final int dLK()
  {
    if (this.BUs.xqo > this.BUs.kmA) {
      return (int)(this.BUs.xqo - this.BUs.kmA);
    }
    return 0;
  }
  
  public final int dLL()
  {
    return this.BUs.blockCount;
  }
  
  public final int dLM()
  {
    if (this.BUs.blockCount > 0) {
      return (int)(this.BUs.BWr / this.BUs.blockCount);
    }
    return 0;
  }
  
  public final void dY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120602);
    super.dY(paramInt1, paramInt2);
    ad.i(this.TAG, "onGetVideoSize, mediaId:" + getMediaId() + ", isLocalVideo:" + this.yAU + ", isPrepareVideo:" + this.hyb + ", isPrepared:" + this.WD + ", playerStatus:" + this.hxT + ", downloadStatus:" + this.hxS);
    AppMethodBeat.o(120602);
  }
  
  public final void ey(boolean paramBoolean)
  {
    AppMethodBeat.i(120592);
    if (this.yAU)
    {
      AppMethodBeat.o(120592);
      return;
    }
    super.ey(paramBoolean);
    AppMethodBeat.o(120592);
  }
  
  public final void ez(boolean paramBoolean)
  {
    AppMethodBeat.i(120593);
    ad.m(this.TAG, bel() + " startTimer, isLocalVideo:" + this.yAU, new Object[0]);
    if (!this.yAU) {
      super.ez(paramBoolean);
    }
    AppMethodBeat.o(120593);
  }
  
  public final int getErrorCode()
  {
    return this.BUs.kDa;
  }
  
  public final String getFilePath()
  {
    AppMethodBeat.i(120612);
    String str = this.hxQ;
    d.g.b.k.g(str, "filepath");
    AppMethodBeat.o(120612);
    return str;
  }
  
  public final long getFirstPlayWaitTime()
  {
    return this.yAY;
  }
  
  public final String getSessionId()
  {
    AppMethodBeat.i(120587);
    String str = bt.nullAsNil(this.sessionId);
    d.g.b.k.g(str, "Util.nullAsNil(sessionId)");
    AppMethodBeat.o(120587);
    return str;
  }
  
  public final int getStayTime()
  {
    AppMethodBeat.i(120611);
    int i = (int)bt.aS(this.gSP);
    AppMethodBeat.o(120611);
    return i;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(120584);
    super.initView();
    Object localObject = com.tencent.mm.plugin.story.f.e.a.yhX;
    this.rTL = com.tencent.mm.plugin.story.f.e.a.gf(getContext());
    this.yAX = new ImageView(getContext());
    localObject = this.yAX;
    if (localObject != null) {
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    localObject = this.yAX;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.kuN;
    FakeVideoViewLayer localFakeVideoViewLayer = this.rTL;
    if (localFakeVideoViewLayer == null) {
      d.g.b.k.aPZ("fakeLayer");
    }
    ((RelativeLayout)localObject).addView((View)localFakeVideoViewLayer, new ViewGroup.LayoutParams(-1, -1));
    this.kuN.addView((View)this.yAX, 0);
    this.qmi = ((TextView)findViewById(2131306403));
    AppMethodBeat.o(120584);
  }
  
  public final void k(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(120601);
    if (!bt.kU(this.hxP, paramString))
    {
      AppMethodBeat.o(120601);
      return;
    }
    paramString = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("%s download  onProgress [%d, %d], pauseByLoadData:").append(this.hxY).append(", playStatus:").append(this.hxT).append(", currPosMs:").append(getCurrPosMs()).append(", isPlyaing:");
    com.tencent.mm.pluginsdk.ui.tools.h localh = this.nAZ;
    d.g.b.k.g(localh, "videoView");
    ad.d(paramString, localh.isPlaying(), new Object[] { bel(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (((getCurrPosMs() <= 0) || (this.hxT == 1) || (this.hxT == 0)) && (oR(getCurrPosSec()))) {
      ez(true);
    }
    AppMethodBeat.o(120601);
  }
  
  public final void o(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    Object localObject2 = null;
    AppMethodBeat.i(120589);
    ad.i(this.TAG, "resume, current play time:" + getCurrPosMs() + ", " + getCurrPosSec() + ", " + getVideoDurationSec() + ", isPrepared:" + this.WD + ", sessionId:" + this.sessionId + ", isLocalVideo:" + this.yAU);
    Object localObject1 = this.rTL;
    if (localObject1 == null) {
      d.g.b.k.aPZ("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject1).oC(this.fqj);
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
    StringBuilder localStringBuilder = new StringBuilder("checkResumeLocalVideo, isLocalVideo:").append(this.yAU).append(", currentPosition:");
    localObject1 = this.nAZ;
    int i;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getCurrentPosition());
      ad.i((String)localObject3, localObject1);
      if (!this.yAU) {
        break label330;
      }
      localObject1 = this.nAZ;
      if (localObject1 == null) {
        break label325;
      }
      i = ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getCurrentPosition();
      label263:
      if (i <= 0) {
        break label330;
      }
      localObject3 = this.nAZ;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = Boolean.valueOf(((com.tencent.mm.pluginsdk.ui.tools.h)localObject3).start());
      }
      this.yAV = false;
    }
    label325:
    label330:
    for (boolean bool = d.g.b.k.g(localObject1, Boolean.TRUE);; bool = false)
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
    if ((getCurrPosMs() > 0) && (!this.yAU))
    {
      if (!this.WD)
      {
        this.kva = true;
        aCu();
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
  
  public final boolean oS(int paramInt)
  {
    AppMethodBeat.i(120605);
    boolean bool = super.oS(paramInt);
    ad.i(this.TAG, "checkCanPlay, cachePlayTime:" + this.hxZ + ", ret:" + bool);
    AppMethodBeat.o(120605);
    return bool;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(120586);
    ad.i(this.TAG, "onCompletion, currPosMs:" + getCurrPosMs() + ", playStatus:" + this.hxT + ", downloadStatus:" + this.hxS);
    if (getCurrPosMs() <= 0)
    {
      AppMethodBeat.o(120586);
      return;
    }
    h.b localb = this.nns;
    if (localb != null) {
      localb.dc(getSessionId(), getMediaId());
    }
    super.onCompletion();
    AppMethodBeat.o(120586);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(120600);
    ad.i(this.TAG, "onUIDestroy, isLocalVideo:" + this.yAU);
    FakeVideoViewLayer localFakeVideoViewLayer = this.rTL;
    if (localFakeVideoViewLayer == null) {
      d.g.b.k.aPZ("fakeLayer");
    }
    localFakeVideoViewLayer.diG();
    super.onUIDestroy();
    AppMethodBeat.o(120600);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(120598);
    ad.i(this.TAG, "onUIPause, isLocalVideo:" + this.yAU);
    Object localObject = this.rTL;
    if (localObject == null) {
      d.g.b.k.aPZ("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject).diF();
    if (this.yAU)
    {
      localObject = this.nAZ;
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
    ad.i(this.TAG, "onUIResume, isLocalVideo:" + this.yAU);
    if (isPlaying())
    {
      FakeVideoViewLayer localFakeVideoViewLayer = this.rTL;
      if (localFakeVideoViewLayer == null) {
        d.g.b.k.aPZ("fakeLayer");
      }
      localFakeVideoViewLayer.oC(this.fqj);
    }
    if (this.yAU)
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
    ad.i(this.TAG, "pause, isLocalVideo:" + this.yAU);
    FakeVideoViewLayer localFakeVideoViewLayer = this.rTL;
    if (localFakeVideoViewLayer == null) {
      d.g.b.k.aPZ("fakeLayer");
    }
    localFakeVideoViewLayer.diF();
    if (this.yAU)
    {
      this.yAV = true;
      this.nAZ.pause();
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
    this.vso = false;
    this.sessionId = null;
    AppMethodBeat.o(120618);
  }
  
  public final void setFirstPlayWaitTime(long paramLong)
  {
    this.yAY = paramLong;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(120588);
    super.setMute(paramBoolean);
    this.fqj = paramBoolean;
    if (this.nAZ != null) {
      this.nAZ.setMute(paramBoolean);
    }
    AppMethodBeat.o(120588);
  }
  
  public final void setNeedShowLoading(boolean paramBoolean)
  {
    AppMethodBeat.i(120596);
    ad.i(this.TAG, hashCode() + " setNeedShowLoading: " + paramBoolean);
    this.yAT = paramBoolean;
    if (!this.yAT) {
      hideLoading();
    }
    AppMethodBeat.o(120596);
  }
  
  public final void setScaleType(com.tencent.mm.pluginsdk.ui.h.e parame)
  {
    AppMethodBeat.i(120613);
    super.setScaleType(parame);
    AppMethodBeat.o(120613);
  }
  
  public final void showLoading()
  {
    AppMethodBeat.i(120597);
    if (this.yAT) {
      nM(800L);
    }
    AppMethodBeat.o(120597);
  }
  
  public final void start()
  {
    AppMethodBeat.i(120607);
    if ((this.bxy > 0) && (!this.yAU))
    {
      ad.i(this.TAG, "start from onError and not local video");
      localObject = this.yhF;
      if (localObject != null)
      {
        s locals = s.ygj;
        localObject = s.a((com.tencent.mm.plugin.story.f.d.j)localObject);
        if (((n)localObject).UE())
        {
          ad.i(this.TAG, "start from onError and download finish now");
          localObject = ((n)localObject).field_filePath;
          d.g.b.k.g(localObject, "videoCache.field_filePath");
          ase((String)localObject);
          AppMethodBeat.o(120607);
          return;
        }
      }
    }
    Object localObject = this.hxQ;
    d.g.b.k.g(localObject, "filepath");
    asf((String)localObject);
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
        Object localObject1 = this.rTL;
        if (localObject1 == null) {
          d.g.b.k.aPZ("fakeLayer");
        }
        ((FakeVideoViewLayer)localObject1).diG();
        if (this.yAU)
        {
          final eu localeu = new eu();
          localObject1 = this.yhF;
          if (localObject1 == null) {
            break label362;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject1).dAu);
          localObject1 = localeu.kM(String.valueOf(localObject1));
          com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.ynv;
          localObject1 = ((eu)localObject1).gY(com.tencent.mm.plugin.story.h.h.dJj().QS());
          localh = com.tencent.mm.plugin.story.h.h.ynv;
          if (com.tencent.mm.plugin.story.h.h.dJj().QX() != 1L) {
            break label367;
          }
          localObject1 = ((eu)localObject1).ha(l).hd(this.yAY).hh(getStayTime()).hi(getErrorCode()).hF(1L);
          localh = com.tencent.mm.plugin.story.h.h.ynv;
          localObject1 = ((eu)localObject1).hG(com.tencent.mm.plugin.story.h.h.dJj().QR());
          localh = com.tencent.mm.plugin.story.h.h.ynv;
          ((eu)localObject1).hH(com.tencent.mm.plugin.story.h.h.dJj().QU()).hc(getCurrPosMs());
          ad.d(this.TAG, "time distance %d", new Object[] { Long.valueOf(System.currentTimeMillis() - localeu.RL()) });
          if (System.currentTimeMillis() - localeu.RL() >= 500L)
          {
            localObject1 = this.yhF;
            if (localObject1 == null) {
              break label372;
            }
            l = ((com.tencent.mm.plugin.story.f.d.j)localObject1).dAu;
          }
          try
          {
            localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
            j.b.dhI().post((Runnable)new c(this, localeu, l));
            this.nAZ.stop();
            reset();
            localObject1 = this.yAX;
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
            localeu.aBj();
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
    ad.m(this.TAG, bel() + " stopTimer, isLocalVideo:" + this.yAU, new Object[0]);
    super.stopTimer();
    AppMethodBeat.o(120594);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView$Companion;", "", "()V", "PRELOAD_CACHE", "", "PRELOAD_CACHE_GOOD_NETWORK", "plugin-story_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView$playLocalVideo$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-story_release"})
  public static final class b
    implements h.a
  {
    public final void dY(int paramInt1, int paramInt2) {}
    
    public final int eM(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120582);
      com.tencent.mm.plugin.story.f.d.j localj = StoryVideoView.c(this.yBa);
      if ((localj != null) && (localj.dHW() == true) && (StoryVideoView.e(this.yBa) > 0L) && (paramInt1 >= StoryVideoView.e(this.yBa)))
      {
        ad.i(StoryVideoView.a(this.yBa), "fakeVideo exceed endTime, playTime:" + paramInt1 + ", fakeEndTime:" + StoryVideoView.e(this.yBa) + ", fakeStartTime:" + StoryVideoView.d(this.yBa));
        if (StoryVideoView.d(this.yBa) <= 0L) {
          break label146;
        }
        StoryVideoView.f(this.yBa).d(StoryVideoView.d(this.yBa), true);
      }
      for (;;)
      {
        AppMethodBeat.o(120582);
        return 0;
        label146:
        StoryVideoView.f(this.yBa).d(0.0D, true);
      }
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(120581);
      String str = StoryVideoView.a(this.yBa);
      StringBuilder localStringBuilder = new StringBuilder("localVideo onCompleted, isFakeVideo:");
      Object localObject = StoryVideoView.c(this.yBa);
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject).dHW());
        ad.i(str, localObject + ", fakeStartTime:" + StoryVideoView.d(this.yBa));
        localObject = StoryVideoView.c(this.yBa);
        if ((localObject == null) || (((com.tencent.mm.plugin.story.f.d.j)localObject).dHW() != true) || (StoryVideoView.d(this.yBa) <= 0L)) {
          break label166;
        }
        StoryVideoView.f(this.yBa).d(StoryVideoView.d(this.yBa), true);
      }
      for (;;)
      {
        localObject = StoryVideoView.h(this.yBa);
        if (localObject == null) {
          break label183;
        }
        ((h.b)localObject).dc(this.yBa.getSessionId(), StoryVideoView.i(this.yBa));
        AppMethodBeat.o(120581);
        return;
        localObject = null;
        break;
        label166:
        StoryVideoView.f(this.yBa).d(0.0D, true);
      }
      label183:
      AppMethodBeat.o(120581);
    }
    
    public final void onError(int paramInt1, int paramInt2) {}
    
    public final void rq()
    {
      AppMethodBeat.i(120580);
      String str = StoryVideoView.a(this.yBa);
      StringBuilder localStringBuilder = new StringBuilder("localVideo onPrepared, isLocalVideoPause:").append(StoryVideoView.b(this.yBa)).append(", isFakeVideo:");
      Object localObject = StoryVideoView.c(this.yBa);
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject).dHW());
        ad.i(str, localObject + ", fakeStartTime:" + StoryVideoView.d(this.yBa) + ", fakeEndTime:" + StoryVideoView.e(this.yBa));
        if (!StoryVideoView.b(this.yBa))
        {
          localObject = StoryVideoView.c(this.yBa);
          if ((localObject == null) || (((com.tencent.mm.plugin.story.f.d.j)localObject).dHW() != true) || (StoryVideoView.d(this.yBa) <= 0L)) {
            break label197;
          }
          StoryVideoView.f(this.yBa).d(StoryVideoView.d(this.yBa), true);
        }
      }
      for (;;)
      {
        StoryVideoView.f(this.yBa).setOneTimeVideoTextureUpdateCallback((com.tencent.mm.pluginsdk.ui.tools.h.e)new a(this));
        AppMethodBeat.o(120580);
        return;
        localObject = null;
        break;
        label197:
        StoryVideoView.f(this.yBa).start();
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onTextureUpdate"})
    static final class a
      implements com.tencent.mm.pluginsdk.ui.tools.h.e
    {
      a(StoryVideoView.b paramb) {}
      
      public final void beo()
      {
        AppMethodBeat.i(120579);
        this.yBb.yBa.setFirstPlayWaitTime(bt.aS(StoryVideoView.g(this.yBb.yBa)));
        aq.n((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(120578);
            ad.i(StoryVideoView.a(this.yBc.yBb.yBa), "onTextureUpdate");
            if (StoryVideoView.f(this.yBc.yBb.yBa) == null)
            {
              AppMethodBeat.o(120578);
              return;
            }
            this.yBc.yBb.yBa.hideLoading();
            Object localObject = StoryVideoView.f(this.yBc.yBb.yBa);
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(StoryVideoView paramStoryVideoView, eu parameu, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(120583);
      ad.i(StoryVideoView.a(this.yBa), "reportStopLocalVideo");
      com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.e.ano(StoryVideoView.j(this.yBa));
      if (locala != null)
      {
        eu localeu = localeu.hb(locala.videoDuration);
        j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
        localeu.gZ(j.b.dHd().tX(l)).hj(locala.videoBitrate).aBj();
      }
      AppMethodBeat.o(120583);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoView
 * JD-Core Version:    0.7.0.1
 */