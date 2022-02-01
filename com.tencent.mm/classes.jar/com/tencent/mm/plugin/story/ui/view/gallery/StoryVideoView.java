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
import com.tencent.mm.g.b.a.ez;
import com.tencent.mm.g.b.a.gk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.MMVideoView.a;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.vfs.i;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView;", "Lcom/tencent/mm/modelvideo/MMVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "C_TAG", "", "fakeBlurLayer", "Landroid/widget/ImageView;", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "firstPlayWaitTime", "", "getFirstPlayWaitTime", "()J", "setFirstPlayWaitTime", "(J)V", "isFakeVideo", "", "isLocalVideo", "isLocalVideoPause", "isMute", "needShowLoading", "sessionId", "startPlayTime", "surfaceAvailable", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "videoTips", "Landroid/widget/TextView;", "avgBlockTime", "", "blockCount", "calcDownloadRange", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "checkCanPlay", "checkLandscape", "", "blurBgPath", "checkNeedReset", "checkResumeLocalVideo", "createVideoView", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView;", "mContext", "fakeEndTime", "fakeStartTime", "getErrorCode", "getFilePath", "getSessionId", "getStayTime", "initView", "isLive", "isShowLoading", "moovCostTime", "onCompletion", "onFinish", "mediaId", "ret", "onGetVideoSize", "width", "height", "onProgress", "offset", "total", "onSeekComplete", "startPlay", "onSurfaceAvailable", "onTextureUpdate", "onUIDestroy", "onUIPause", "onUIResume", "pause", "play", "item", "playLocalVideo", "videoPath", "prepareVideo", "reportStopLocalVideo", "reset", "resume", "storyVideoItem", "setMute", "mute", "setNeedShowLoading", "show", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoPath", "url", "durationSec", "showDebugInfo", "path", "showLoading", "startTimer", "rightNow", "stop", "stopTimer", "Companion", "plugin-story_release"})
public final class StoryVideoView
  extends MMVideoView
{
  public static final StoryVideoView.a zOn;
  private boolean ftN;
  private long hto;
  private TextView qUK;
  private String sessionId;
  private FakeVideoViewLayer tbD;
  private boolean wCo;
  private final String zOg;
  private boolean zOh;
  boolean zOi;
  private boolean zOj;
  private boolean zOk;
  private ImageView zOl;
  private long zOm;
  private com.tencent.mm.plugin.story.f.d.j zuF;
  
  static
  {
    AppMethodBeat.i(120621);
    zOn = new StoryVideoView.a((byte)0);
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
    this.zOg = "MicroMsg.StoryVideoView";
    paramContext = com.tencent.mm.plugin.story.f.j.zsh;
    setRootPath(i.k(j.b.getAccStoryPath(), true));
    eMt();
    setIsShowBasicControls(false);
    paramContext = this.kWf;
    d.g.b.k.g(paramContext, "footerRoot");
    paramContext.setVisibility(8);
    this.TAG = this.zOg;
    this.zOh = true;
    AppMethodBeat.o(120619);
  }
  
  private final void axn(String paramString)
  {
    AppMethodBeat.i(120591);
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("playLocalVideo: ").append(paramString).append(", isPlayingNow:");
    com.tencent.mm.pluginsdk.ui.tools.h localh = this.odZ;
    d.g.b.k.g(localh, "videoView");
    ac.i((String)localObject1, localh.isPlaying());
    if (this.odZ == null) {
      this.odZ = cO(getContext());
    }
    reset();
    localObject1 = this.odZ;
    if (localObject1 != null) {
      ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).stop();
    }
    localObject1 = this.odZ;
    if (localObject1 != null) {
      if (!this.ftN)
      {
        if (!this.zOk) {
          break label204;
        }
        localObject2 = this.tbD;
        if (localObject2 == null) {
          d.g.b.k.aVY("fakeLayer");
        }
        if (!((FakeVideoViewLayer)localObject2).wyv) {
          break label204;
        }
      }
    }
    label204:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).setMute(bool);
      this.bps = false;
      this.zOi = true;
      setDownloadStatus(3);
      setNeedShowLoading(false);
      localObject1 = this.odZ;
      if (localObject1 != null) {
        break;
      }
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView");
      AppMethodBeat.o(120591);
      throw paramString;
    }
    ((StoryVideoPlayTextureView)localObject1).setNeedResetExtractor(crM());
    localObject1 = this.odZ;
    d.g.b.k.g(localObject1, "videoView");
    ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).setVideoPath(paramString);
    this.hto = bs.Gn();
    this.zOm = 0L;
    localObject1 = com.tencent.mm.plugin.story.f.k.zsq;
    localObject1 = this.zuF;
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
    com.tencent.mm.plugin.story.f.k.awx((String)localObject1);
    this.odZ.setVideoCallback((h.a)new b(this));
    this.zOj = false;
    this.sessionId = null;
    axo(paramString);
    AppMethodBeat.o(120591);
  }
  
  private final void axo(String paramString)
  {
    AppMethodBeat.i(120617);
    Object localObject = g.agR();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).agA().get(ah.a.GKg, Integer.valueOf(0));
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(120617);
      throw paramString;
    }
    if (((Integer)localObject).intValue() == 1)
    {
      localObject = this.qUK;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.sight.base.e.alX(paramString));
      }
      paramString = this.qUK;
      if (paramString != null)
      {
        paramString.setVisibility(0);
        AppMethodBeat.o(120617);
        return;
      }
    }
    AppMethodBeat.o(120617);
  }
  
  private final boolean crM()
  {
    AppMethodBeat.i(120604);
    if (this.zOi)
    {
      AppMethodBeat.o(120604);
      return false;
    }
    try
    {
      boolean bool = g.agR().agA().getBoolean(ah.a.GLy, false);
      AppMethodBeat.o(120604);
      return bool;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace(this.TAG, (Throwable)localException, "check need reset error", new Object[0]);
      AppMethodBeat.o(120604);
    }
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.story.f.d.j paramj, String paramString)
  {
    AppMethodBeat.i(120585);
    d.g.b.k.h(paramj, "item");
    Object localObject1 = this.qUK;
    if (localObject1 != null) {
      ((TextView)localObject1).setVisibility(8);
    }
    this.zuF = paramj;
    localObject1 = paramj.zuP;
    int i = paramj.hGU;
    this.zOk = false;
    Object localObject2 = this.tbD;
    if (localObject2 == null) {
      d.g.b.k.aVY("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject2).setVisibility(8);
    localObject2 = this.zOl;
    if (localObject2 != null) {
      ((ImageView)localObject2).setVisibility(8);
    }
    if (!paramj.dWy())
    {
      ac.i(this.TAG, "play empty item");
      showLoading();
      AppMethodBeat.o(120585);
      return;
    }
    if (paramj.dWx())
    {
      this.zOk = true;
      ac.i(this.TAG, "LogStory: play fake video");
      paramString = this.tbD;
      if (paramString == null) {
        d.g.b.k.aVY("fakeLayer");
      }
      paramString.setVisibility(0);
      paramj = paramj.zuQ;
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
        localObject1 = com.tencent.mm.ui.ap.cl(getContext());
        paramString = f.e(paramString, ((Point)localObject1).y, ((Point)localObject1).x, true);
        localObject1 = this.zOl;
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageBitmap(paramString);
        }
        paramString = this.zOl;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        label268:
        paramString = this.tbD;
        if (paramString == null) {
          d.g.b.k.aVY("fakeLayer");
        }
        paramString.setFakeVideoInfo(paramj);
        paramString = this.tbD;
        if (paramString == null) {
          d.g.b.k.aVY("fakeLayer");
        }
        paramString.pA(this.ftN);
        this.hYr = paramj.dui().videoPath;
        this.hYq = "";
        paramj = this.hYr;
        d.g.b.k.g(paramj, "filepath");
        axn(paramj);
      }
    }
    for (;;)
    {
      setLoop(true);
      paramj = this.odZ;
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
      paramString = this.zOl;
      if (paramString == null) {
        break label268;
      }
      paramString.setVisibility(8);
      break label268;
      ac.i(this.TAG, "LogStory: play normal video");
      localObject2 = s.ztj;
      Object localObject3 = s.a((ddy)localObject1);
      if (i.aSp((String)localObject3) > 0L)
      {
        ac.i(this.TAG, "play " + (String)localObject3 + " downloadDone now can play " + ((ddy)localObject1).Id);
        this.hYr = ((String)localObject3);
        if (localObject3 != null) {
          axn((String)localObject3);
        }
      }
      else
      {
        localObject2 = s.ztj;
        localObject2 = s.a(paramj);
        int j = (int)i.aSp(((n)localObject2).field_filePath);
        ac.i(this.TAG, "play " + (String)localObject3 + " error try play from url or videoCache " + ((ddy)localObject1).Id + " fileLength:" + j + " cacheSize:" + ((n)localObject2).field_cacheSize);
        if (j < ((n)localObject2).field_cacheSize)
        {
          ((n)localObject2).field_cacheSize = j;
          localObject3 = com.tencent.mm.plugin.story.f.j.zsh;
          j.b.dVI().b((n)localObject2);
        }
        ac.i(this.TAG, String.valueOf(localObject2));
        if ((((n)localObject2).Vz()) && (i.eA(((n)localObject2).field_filePath)))
        {
          ac.i(this.TAG, "play " + ((ddy)localObject1).Id + " download finish");
          this.hYr = ((n)localObject2).field_filePath;
          paramj = s.ztj;
          this.hYq = s.bU(i, ((ddy)localObject1).Url);
          paramj = this.hYr;
          d.g.b.k.g(paramj, "filepath");
          axn(paramj);
        }
        else
        {
          if ((((n)localObject2).Vz()) && (!i.eA(((n)localObject2).field_filePath)))
          {
            ac.i(this.TAG, "error downloadFinish " + ((n)localObject2).Vz() + " ret:" + i.eA(((n)localObject2).field_filePath));
            ((n)localObject2).dZt();
            localObject3 = com.tencent.mm.plugin.story.f.j.zsh;
            j.b.dVI().b((n)localObject2);
          }
          ac.i(this.TAG, "play " + ((ddy)localObject1).Id + ' ' + paramString + " start online play " + ((n)localObject2).field_filePath);
          reset();
          this.odZ.stop();
          this.odZ.setVideoCallback((h.a)this);
          this.zOi = false;
          this.kWo = true;
          setNeedShowLoading(true);
          super.c(false, paramj.zuP.Url, (int)((ddy)localObject1).FNF);
          this.hYr = ((n)localObject2).field_filePath;
          paramj = s.ztj;
          this.hYq = s.bU(i, ((ddy)localObject1).Url);
          this.sessionId = paramString;
          this.hto = bs.Gn();
          this.zOm = 0L;
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
    paramPInt1.value = Math.max(paramInt, this.hYA);
    if (this.hYu == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.hYB;
      localObject1 = "" + "step1;";
    }
    Object localObject2 = localObject1;
    if (this.hYu == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.hYB + 8);
      localObject2 = (String)localObject1 + "step2;";
    }
    if (this.hYu == 3)
    {
      paramPInt1.value = this.hYA;
      paramPInt2.value = (paramInt + 1 + this.hYF.hYL);
      localObject1 = (String)localObject2 + "step3;";
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (paramPInt2.value >= this.hYw + 1)
      {
        paramPInt2.value = (this.hYw + 1);
        localObject2 = (String)localObject1 + "step5;";
      }
      if (paramPInt2.value >= paramPInt1.value) {
        break;
      }
      paramPInt1.value += this.hYF.hYL;
      AppMethodBeat.o(120606);
      return false;
      localObject1 = localObject2;
      if (this.hYu == 4)
      {
        paramPInt1.value = this.hYA;
        paramPInt2.value = (this.hYB + paramInt + 1 + this.hYF.hYL);
        localObject1 = (String)localObject2 + "step4;";
      }
    }
    ac.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s] %s", new Object[] { blf(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.hYu), Integer.valueOf(this.hYA), Integer.valueOf(this.hYB), this.hYq, localObject2 });
    AppMethodBeat.o(120606);
    return true;
  }
  
  public final void aJl()
  {
    AppMethodBeat.i(120616);
    ac.i(this.TAG, "prepareVideo, surfaceAvailable:" + this.wCo);
    if (this.odZ != null)
    {
      localObject = this.odZ;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView");
        AppMethodBeat.o(120616);
        throw ((Throwable)localObject);
      }
      ((StoryVideoPlayTextureView)localObject).setNeedResetExtractor(crM());
    }
    Object localObject = this.hYr;
    d.g.b.k.g(localObject, "filepath");
    axo((String)localObject);
    super.aJl();
    AppMethodBeat.o(120616);
  }
  
  public final void aJn()
  {
    AppMethodBeat.i(120615);
    super.aJn();
    ac.i(this.TAG, "onSurfaceAvailable");
    this.wCo = true;
    AppMethodBeat.o(120615);
  }
  
  public final void aq(String paramString, int paramInt)
  {
    AppMethodBeat.i(120603);
    super.aq(paramString, paramInt);
    AppMethodBeat.o(120603);
  }
  
  public final boolean bed()
  {
    AppMethodBeat.i(120595);
    if (this.zOi)
    {
      AppMethodBeat.o(120595);
      return false;
    }
    boolean bool = super.bed();
    AppMethodBeat.o(120595);
    return bool;
  }
  
  public final void bli()
  {
    AppMethodBeat.i(120610);
    super.bli();
    Object localObject = this.odZ;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(120610);
      throw ((Throwable)localObject);
    }
    ((View)localObject).setAlpha(1.0F);
    String str;
    StringBuilder localStringBuilder;
    if (this.zOm <= 0L)
    {
      this.zOm = bs.aO(this.hto);
      str = this.TAG;
      localStringBuilder = new StringBuilder("onTextureUpdate firstPlayWaitTime ").append(this.zOm).append(" storyId: ");
      localObject = this.zuF;
      if (localObject == null) {
        break label131;
      }
    }
    label131:
    for (localObject = Long.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject).dyg);; localObject = null)
    {
      ac.i(str, localObject);
      AppMethodBeat.o(120610);
      return;
    }
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(210148);
    super.c(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(210148);
  }
  
  public final com.tencent.mm.pluginsdk.ui.tools.h cO(Context paramContext)
  {
    AppMethodBeat.i(120614);
    paramContext = new StoryVideoPlayTextureView(paramContext);
    paramContext.setOpenWithNoneSurface(true);
    paramContext.setNeedResetExtractor(crM());
    paramContext.setIsOnlineVideoType(true);
    paramContext = (com.tencent.mm.pluginsdk.ui.tools.h)paramContext;
    AppMethodBeat.o(120614);
    return paramContext;
  }
  
  public final void dZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120602);
    super.dZ(paramInt1, paramInt2);
    ac.i(this.TAG, "onGetVideoSize, mediaId:" + getMediaId() + ", isLocalVideo:" + this.zOi + ", isPrepareVideo:" + this.hYC + ", isPrepared:" + this.Xy + ", playerStatus:" + this.hYu + ", downloadStatus:" + this.hYt);
    AppMethodBeat.o(120602);
  }
  
  public final void eS(boolean paramBoolean)
  {
    AppMethodBeat.i(120592);
    if (this.zOi)
    {
      AppMethodBeat.o(120592);
      return;
    }
    super.eS(paramBoolean);
    AppMethodBeat.o(120592);
  }
  
  public final void eT(boolean paramBoolean)
  {
    AppMethodBeat.i(120593);
    ac.m(this.TAG, blf() + " startTimer, isLocalVideo:" + this.zOi, new Object[0]);
    if (!this.zOi) {
      super.eT(paramBoolean);
    }
    AppMethodBeat.o(120593);
  }
  
  public final int eak()
  {
    if (this.DmI.yDe > this.DmI.kNS) {
      return (int)(this.DmI.yDe - this.DmI.kNS);
    }
    return 0;
  }
  
  public final int eal()
  {
    return this.DmI.blockCount;
  }
  
  public final int eam()
  {
    if (this.DmI.blockCount > 0) {
      return (int)(this.DmI.DoI / this.DmI.blockCount);
    }
    return 0;
  }
  
  public final int getErrorCode()
  {
    return this.DmI.les;
  }
  
  public final String getFilePath()
  {
    AppMethodBeat.i(120612);
    String str = this.hYr;
    d.g.b.k.g(str, "filepath");
    AppMethodBeat.o(120612);
    return str;
  }
  
  public final long getFirstPlayWaitTime()
  {
    return this.zOm;
  }
  
  public final String getSessionId()
  {
    AppMethodBeat.i(120587);
    String str = bs.nullAsNil(this.sessionId);
    d.g.b.k.g(str, "Util.nullAsNil(sessionId)");
    AppMethodBeat.o(120587);
    return str;
  }
  
  public final int getStayTime()
  {
    AppMethodBeat.i(120611);
    int i = (int)bs.aO(this.hto);
    AppMethodBeat.o(120611);
    return i;
  }
  
  public final void i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(120601);
    if (!bs.lr(this.hYq, paramString))
    {
      AppMethodBeat.o(120601);
      return;
    }
    paramString = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("%s download  onProgress [%d, %d], pauseByLoadData:").append(this.hYz).append(", playStatus:").append(this.hYu).append(", currPosMs:").append(getCurrPosMs()).append(", isPlyaing:");
    com.tencent.mm.pluginsdk.ui.tools.h localh = this.odZ;
    d.g.b.k.g(localh, "videoView");
    ac.d(paramString, localh.isPlaying(), new Object[] { blf(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (((getCurrPosMs() <= 0) || (this.hYu == 1) || (this.hYu == 0)) && (pG(getCurrPosSec()))) {
      eT(true);
    }
    AppMethodBeat.o(120601);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(120584);
    super.initView();
    Object localObject = com.tencent.mm.plugin.story.f.e.a.zuX;
    this.tbD = com.tencent.mm.plugin.story.f.e.a.gr(getContext());
    this.zOl = new ImageView(getContext());
    localObject = this.zOl;
    if (localObject != null) {
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    localObject = this.zOl;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.kWc;
    FakeVideoViewLayer localFakeVideoViewLayer = this.tbD;
    if (localFakeVideoViewLayer == null) {
      d.g.b.k.aVY("fakeLayer");
    }
    ((RelativeLayout)localObject).addView((View)localFakeVideoViewLayer, new ViewGroup.LayoutParams(-1, -1));
    this.kWc.addView((View)this.zOl, 0);
    this.qUK = ((TextView)findViewById(2131306403));
    AppMethodBeat.o(120584);
  }
  
  public final void o(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    Object localObject2 = null;
    AppMethodBeat.i(120589);
    ac.i(this.TAG, "resume, current play time:" + getCurrPosMs() + ", " + getCurrPosSec() + ", " + getVideoDurationSec() + ", isPrepared:" + this.Xy + ", sessionId:" + this.sessionId + ", isLocalVideo:" + this.zOi);
    Object localObject1 = this.tbD;
    if (localObject1 == null) {
      d.g.b.k.aVY("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject1).pA(this.ftN);
    if (getCurrPosSec() >= getVideoDurationSec())
    {
      ac.i(this.TAG, "resume, restart video");
      if (paramj != null)
      {
        a(paramj, this.sessionId);
        AppMethodBeat.o(120589);
        return;
      }
    }
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checkResumeLocalVideo, isLocalVideo:").append(this.zOi).append(", currentPosition:");
    localObject1 = this.odZ;
    int i;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getCurrentPosition());
      ac.i((String)localObject3, localObject1);
      if (!this.zOi) {
        break label330;
      }
      localObject1 = this.odZ;
      if (localObject1 == null) {
        break label325;
      }
      i = ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getCurrentPosition();
      label263:
      if (i <= 0) {
        break label330;
      }
      localObject3 = this.odZ;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = Boolean.valueOf(((com.tencent.mm.pluginsdk.ui.tools.h)localObject3).start());
      }
      this.zOj = false;
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
    if ((getCurrPosMs() > 0) && (!this.zOi))
    {
      if (!this.Xy)
      {
        this.kWo = true;
        aJl();
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
    ac.i(this.TAG, "onCompletion, currPosMs:" + getCurrPosMs() + ", playStatus:" + this.hYu + ", downloadStatus:" + this.hYt);
    if (getCurrPosMs() <= 0)
    {
      AppMethodBeat.o(120586);
      return;
    }
    h.b localb = this.nQs;
    if (localb != null) {
      localb.dp(getSessionId(), getMediaId());
    }
    super.onCompletion();
    AppMethodBeat.o(120586);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(120600);
    ac.i(this.TAG, "onUIDestroy, isLocalVideo:" + this.zOi);
    FakeVideoViewLayer localFakeVideoViewLayer = this.tbD;
    if (localFakeVideoViewLayer == null) {
      d.g.b.k.aVY("fakeLayer");
    }
    localFakeVideoViewLayer.dwz();
    super.onUIDestroy();
    AppMethodBeat.o(120600);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(120598);
    ac.i(this.TAG, "onUIPause, isLocalVideo:" + this.zOi);
    Object localObject = this.tbD;
    if (localObject == null) {
      d.g.b.k.aVY("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject).dwy();
    if (this.zOi)
    {
      localObject = this.odZ;
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
    ac.i(this.TAG, "onUIResume, isLocalVideo:" + this.zOi);
    if (isPlaying())
    {
      FakeVideoViewLayer localFakeVideoViewLayer = this.tbD;
      if (localFakeVideoViewLayer == null) {
        d.g.b.k.aVY("fakeLayer");
      }
      localFakeVideoViewLayer.pA(this.ftN);
    }
    if (this.zOi)
    {
      AppMethodBeat.o(120599);
      return;
    }
    super.onUIResume();
    AppMethodBeat.o(120599);
  }
  
  public final boolean pH(int paramInt)
  {
    AppMethodBeat.i(120605);
    boolean bool = super.pH(paramInt);
    ac.i(this.TAG, "checkCanPlay, cachePlayTime:" + this.hYA + ", ret:" + bool);
    AppMethodBeat.o(120605);
    return bool;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(120590);
    ac.i(this.TAG, "pause, isLocalVideo:" + this.zOi);
    FakeVideoViewLayer localFakeVideoViewLayer = this.tbD;
    if (localFakeVideoViewLayer == null) {
      d.g.b.k.aVY("fakeLayer");
    }
    localFakeVideoViewLayer.dwy();
    if (this.zOi)
    {
      this.zOj = true;
      this.odZ.pause();
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
    this.wCo = false;
    this.sessionId = null;
    AppMethodBeat.o(120618);
  }
  
  public final void setFirstPlayWaitTime(long paramLong)
  {
    this.zOm = paramLong;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(120588);
    super.setMute(paramBoolean);
    this.ftN = paramBoolean;
    if (this.odZ != null) {
      this.odZ.setMute(paramBoolean);
    }
    AppMethodBeat.o(120588);
  }
  
  public final void setNeedShowLoading(boolean paramBoolean)
  {
    AppMethodBeat.i(120596);
    ac.i(this.TAG, hashCode() + " setNeedShowLoading: " + paramBoolean);
    this.zOh = paramBoolean;
    if (!this.zOh) {
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
    if (this.zOh) {
      ry(800L);
    }
    AppMethodBeat.o(120597);
  }
  
  public final void start()
  {
    AppMethodBeat.i(120607);
    if ((this.bvh > 0) && (!this.zOi))
    {
      ac.i(this.TAG, "start from onError and not local video");
      localObject = this.zuF;
      if (localObject != null)
      {
        s locals = s.ztj;
        localObject = s.a((com.tencent.mm.plugin.story.f.d.j)localObject);
        if (((n)localObject).Vz())
        {
          ac.i(this.TAG, "start from onError and download finish now");
          localObject = ((n)localObject).field_filePath;
          d.g.b.k.g(localObject, "videoCache.field_filePath");
          axn((String)localObject);
          AppMethodBeat.o(120607);
          return;
        }
      }
    }
    Object localObject = this.hYr;
    d.g.b.k.g(localObject, "filepath");
    axo((String)localObject);
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
        Object localObject1 = this.tbD;
        if (localObject1 == null) {
          d.g.b.k.aVY("fakeLayer");
        }
        ((FakeVideoViewLayer)localObject1).dwz();
        if (this.zOi)
        {
          final gk localgk = new gk();
          localObject1 = this.zuF;
          if (localObject1 == null) {
            break label362;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject1).dyg);
          localObject1 = localgk.nE(String.valueOf(localObject1));
          com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.zAU;
          localObject1 = ((gk)localObject1).kt(com.tencent.mm.plugin.story.h.h.dXK().Ru());
          localh = com.tencent.mm.plugin.story.h.h.zAU;
          if (com.tencent.mm.plugin.story.h.h.dXK().Rz() != 1L) {
            break label367;
          }
          localObject1 = ((gk)localObject1).kv(l).ky(this.zOm).kC(getStayTime()).kD(getErrorCode()).la(1L);
          localh = com.tencent.mm.plugin.story.h.h.zAU;
          localObject1 = ((gk)localObject1).lb(com.tencent.mm.plugin.story.h.h.dXK().Rt());
          localh = com.tencent.mm.plugin.story.h.h.zAU;
          ((gk)localObject1).lc(com.tencent.mm.plugin.story.h.h.dXK().Rw()).kx(getCurrPosMs());
          ac.d(this.TAG, "time distance %d", new Object[] { Long.valueOf(System.currentTimeMillis() - localgk.Sn()) });
          if (System.currentTimeMillis() - localgk.Sn() >= 500L)
          {
            localObject1 = this.zuF;
            if (localObject1 == null) {
              break label372;
            }
            l = ((com.tencent.mm.plugin.story.f.d.j)localObject1).dyg;
          }
          try
          {
            localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
            j.b.dvq().post((Runnable)new c(this, localgk, l));
            this.odZ.stop();
            reset();
            localObject1 = this.zOl;
            if (localObject1 == null) {
              break label355;
            }
            ((ImageView)localObject1).setVisibility(8);
            AppMethodBeat.o(120608);
            return;
          }
          catch (Exception localException1)
          {
            ac.printErrStackTrace(this.TAG, (Throwable)localException1, "reportStopLocalVideo", new Object[0]);
            localgk.aHZ();
            continue;
          }
        }
        super.stop();
      }
      catch (Exception localException2)
      {
        ac.printErrStackTrace(this.TAG, (Throwable)localException2, "stop error", new Object[0]);
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
    ac.m(this.TAG, blf() + " stopTimer, isLocalVideo:" + this.zOi, new Object[0]);
    super.stopTimer();
    AppMethodBeat.o(120594);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView$playLocalVideo$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-story_release"})
  public static final class b
    implements h.a
  {
    public final void dZ(int paramInt1, int paramInt2) {}
    
    public final int eP(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120582);
      com.tencent.mm.plugin.story.f.d.j localj = StoryVideoView.c(this.zOo);
      if ((localj != null) && (localj.dWx() == true) && (StoryVideoView.e(this.zOo) > 0L) && (paramInt1 >= StoryVideoView.e(this.zOo)))
      {
        ac.i(StoryVideoView.a(this.zOo), "fakeVideo exceed endTime, playTime:" + paramInt1 + ", fakeEndTime:" + StoryVideoView.e(this.zOo) + ", fakeStartTime:" + StoryVideoView.d(this.zOo));
        if (StoryVideoView.d(this.zOo) <= 0L) {
          break label146;
        }
        StoryVideoView.f(this.zOo).d(StoryVideoView.d(this.zOo), true);
      }
      for (;;)
      {
        AppMethodBeat.o(120582);
        return 0;
        label146:
        StoryVideoView.f(this.zOo).d(0.0D, true);
      }
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(120581);
      String str = StoryVideoView.a(this.zOo);
      StringBuilder localStringBuilder = new StringBuilder("localVideo onCompleted, isFakeVideo:");
      Object localObject = StoryVideoView.c(this.zOo);
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject).dWx());
        ac.i(str, localObject + ", fakeStartTime:" + StoryVideoView.d(this.zOo));
        localObject = StoryVideoView.c(this.zOo);
        if ((localObject == null) || (((com.tencent.mm.plugin.story.f.d.j)localObject).dWx() != true) || (StoryVideoView.d(this.zOo) <= 0L)) {
          break label166;
        }
        StoryVideoView.f(this.zOo).d(StoryVideoView.d(this.zOo), true);
      }
      for (;;)
      {
        localObject = StoryVideoView.h(this.zOo);
        if (localObject == null) {
          break label183;
        }
        ((h.b)localObject).dp(this.zOo.getSessionId(), StoryVideoView.i(this.zOo));
        AppMethodBeat.o(120581);
        return;
        localObject = null;
        break;
        label166:
        StoryVideoView.f(this.zOo).d(0.0D, true);
      }
      label183:
      AppMethodBeat.o(120581);
    }
    
    public final void onError(int paramInt1, int paramInt2) {}
    
    public final void rB()
    {
      AppMethodBeat.i(120580);
      String str = StoryVideoView.a(this.zOo);
      StringBuilder localStringBuilder = new StringBuilder("localVideo onPrepared, isLocalVideoPause:").append(StoryVideoView.b(this.zOo)).append(", isFakeVideo:");
      Object localObject = StoryVideoView.c(this.zOo);
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((com.tencent.mm.plugin.story.f.d.j)localObject).dWx());
        ac.i(str, localObject + ", fakeStartTime:" + StoryVideoView.d(this.zOo) + ", fakeEndTime:" + StoryVideoView.e(this.zOo));
        if (!StoryVideoView.b(this.zOo))
        {
          localObject = StoryVideoView.c(this.zOo);
          if ((localObject == null) || (((com.tencent.mm.plugin.story.f.d.j)localObject).dWx() != true) || (StoryVideoView.d(this.zOo) <= 0L)) {
            break label197;
          }
          StoryVideoView.f(this.zOo).d(StoryVideoView.d(this.zOo), true);
        }
      }
      for (;;)
      {
        StoryVideoView.f(this.zOo).setOneTimeVideoTextureUpdateCallback((com.tencent.mm.pluginsdk.ui.tools.h.e)new a(this));
        AppMethodBeat.o(120580);
        return;
        localObject = null;
        break;
        label197:
        StoryVideoView.f(this.zOo).start();
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTextureUpdate"})
    static final class a
      implements com.tencent.mm.pluginsdk.ui.tools.h.e
    {
      a(StoryVideoView.b paramb) {}
      
      public final void bli()
      {
        AppMethodBeat.i(120579);
        this.zOp.zOo.setFirstPlayWaitTime(bs.aO(StoryVideoView.g(this.zOp.zOo)));
        com.tencent.mm.sdk.platformtools.ap.n((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(120578);
            ac.i(StoryVideoView.a(this.zOq.zOp.zOo), "onTextureUpdate");
            if (StoryVideoView.f(this.zOq.zOp.zOo) == null)
            {
              AppMethodBeat.o(120578);
              return;
            }
            this.zOq.zOp.zOo.hideLoading();
            Object localObject = StoryVideoView.f(this.zOq.zOp.zOo);
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(StoryVideoView paramStoryVideoView, gk paramgk, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(120583);
      ac.i(StoryVideoView.a(this.zOo), "reportStopLocalVideo");
      com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.e.asx(StoryVideoView.j(this.zOo));
      if (locala != null)
      {
        gk localgk = localgk.kw(locala.videoDuration);
        j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
        localgk.ku(j.b.dVE().yA(l)).kE(locala.videoBitrate).aHZ();
      }
      AppMethodBeat.o(120583);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoView
 * JD-Core Version:    0.7.0.1
 */