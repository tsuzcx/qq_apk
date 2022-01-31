package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import a.v;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.g.b.a.bw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.MMVideoView.a;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.plugin.story.h.o;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.k;
import com.tencent.mm.plugin.story.model.s;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.chf;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView;", "Lcom/tencent/mm/modelvideo/MMVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "C_TAG", "", "fakeLayer", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewFakeLayer;", "firstPlayWaitTime", "", "getFirstPlayWaitTime", "()J", "setFirstPlayWaitTime", "(J)V", "isFakeVideo", "", "isLocalVideo", "isLocalVideoPause", "isMute", "needShowLoading", "sessionId", "startPlayTime", "surfaceAvailable", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "videoTips", "Landroid/widget/TextView;", "avgBlockTime", "", "blockCount", "calcDownloadRange", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "checkCanPlay", "checkNeedReset", "checkResumeLocalVideo", "createVideoView", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView;", "mContext", "fakeEndTime", "fakeStartTime", "getErrorCode", "getFilePath", "getSessionId", "getStayTime", "initView", "", "isLive", "isShowLoading", "moovCostTime", "onCompletion", "onFinish", "mediaId", "ret", "onGetVideoSize", "width", "height", "onProgress", "offset", "total", "onSeekComplete", "startPlay", "onSurfaceAvailable", "onTextureUpdate", "onUIDestroy", "onUIPause", "onUIResume", "pause", "play", "item", "playLocalVideo", "videoPath", "prepareVideo", "reportStopLocalVideo", "reset", "resume", "storyVideoItem", "setMute", "mute", "setNeedShowLoading", "show", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoPath", "url", "durationSec", "showDebugInfo", "path", "showLoading", "startTimer", "rightNow", "stop", "stopTimer", "Companion", "plugin-story_release"})
public final class StoryVideoView
  extends MMVideoView
{
  public static final StoryVideoView.a sVe;
  private String cpW;
  private boolean efg;
  private long fqZ;
  private TextView mEu;
  private final String sUY;
  private boolean sUZ;
  private StoryVideoViewFakeLayer sUh;
  boolean sVa;
  private boolean sVb;
  private boolean sVc;
  private long sVd;
  private boolean stu;
  private com.tencent.mm.plugin.story.model.d.i syr;
  
  static
  {
    AppMethodBeat.i(110950);
    sVe = new StoryVideoView.a((byte)0);
    AppMethodBeat.o(110950);
  }
  
  public StoryVideoView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(110949);
    AppMethodBeat.o(110949);
  }
  
  public StoryVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(110948);
    this.sUY = "MicroMsg.StoryVideoView";
    paramContext = com.tencent.mm.plugin.story.model.j.svi;
    setRootPath(j.b.getAccStoryPath());
    dmN();
    setIsShowBasicControls(false);
    paramContext = this.vPq;
    a.f.b.j.p(paramContext, "footerRoot");
    paramContext.setVisibility(8);
    this.TAG = this.sUY;
    this.sUZ = true;
    AppMethodBeat.o(110948);
  }
  
  private final void adK(String paramString)
  {
    AppMethodBeat.i(110921);
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("playLocalVideo: ").append(paramString).append(", isPlayingNow:");
    com.tencent.mm.pluginsdk.ui.tools.e locale = this.kvG;
    a.f.b.j.p(locale, "videoView");
    ab.i((String)localObject1, locale.isPlaying());
    if (this.kvG == null) {
      this.kvG = ck(getContext());
    }
    reset();
    localObject1 = this.kvG;
    if (localObject1 != null) {
      ((com.tencent.mm.pluginsdk.ui.tools.e)localObject1).stop();
    }
    localObject1 = this.kvG;
    if (localObject1 != null) {
      if (!this.efg)
      {
        if (!this.sVc) {
          break label204;
        }
        localObject2 = this.sUh;
        if (localObject2 == null) {
          a.f.b.j.ays("fakeLayer");
        }
        if (!((StoryVideoViewFakeLayer)localObject2).sVl) {
          break label204;
        }
      }
    }
    label204:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.pluginsdk.ui.tools.e)localObject1).setMute(bool);
      this.aTq = false;
      this.sVa = true;
      setDownloadStatus(3);
      setNeedShowLoading(false);
      localObject1 = this.kvG;
      if (localObject1 != null) {
        break;
      }
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView");
      AppMethodBeat.o(110921);
      throw paramString;
    }
    ((StoryVideoPlayTextureView)localObject1).setNeedResetExtractor(byv());
    localObject1 = this.kvG;
    a.f.b.j.p(localObject1, "videoView");
    ((com.tencent.mm.pluginsdk.ui.tools.e)localObject1).setVideoPath(paramString);
    this.fqZ = bo.yB();
    this.sVd = 0L;
    localObject1 = k.svr;
    localObject1 = this.syr;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.story.model.d.i)localObject1).username;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    k.acT((String)localObject1);
    this.kvG.setVideoCallback((e.a)new StoryVideoView.b(this));
    this.sVb = false;
    this.cpW = null;
    adL(paramString);
    AppMethodBeat.o(110921);
  }
  
  private final void adL(String paramString)
  {
    AppMethodBeat.i(151347);
    Object localObject = g.RL();
    a.f.b.j.p(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).Ru().get(ac.a.yDR, Integer.valueOf(0));
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(151347);
      throw paramString;
    }
    if (((Integer)localObject).intValue() == 1)
    {
      localObject = this.mEu;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)d.TX(paramString));
      }
      paramString = this.mEu;
      if (paramString != null)
      {
        paramString.setVisibility(0);
        AppMethodBeat.o(151347);
        return;
      }
    }
    AppMethodBeat.o(151347);
  }
  
  private final boolean byv()
  {
    AppMethodBeat.i(110934);
    if (this.sVa)
    {
      AppMethodBeat.o(110934);
      return false;
    }
    try
    {
      boolean bool = g.RL().Ru().getBoolean(ac.a.yFa, false);
      AppMethodBeat.o(110934);
      return bool;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace(this.TAG, (Throwable)localException, "check need reset error", new Object[0]);
      AppMethodBeat.o(110934);
    }
    return false;
  }
  
  public final void Es()
  {
    AppMethodBeat.i(110916);
    ab.i(this.TAG, "onCompletion, currPosMs:" + getCurrPosMs() + ", playStatus:" + this.fVj + ", downloadStatus:" + this.fVi);
    if (getCurrPosMs() <= 0)
    {
      AppMethodBeat.o(110916);
      return;
    }
    h.b localb = this.ryi;
    if (localb != null) {
      localb.cr(getSessionId(), getMediaId());
    }
    super.Es();
    AppMethodBeat.o(110916);
  }
  
  public final void a(com.tencent.mm.plugin.story.model.d.i parami, String paramString)
  {
    AppMethodBeat.i(110915);
    a.f.b.j.q(parami, "item");
    Object localObject1 = this.mEu;
    if (localObject1 != null) {
      ((TextView)localObject1).setVisibility(8);
    }
    this.syr = parami;
    localObject1 = parami.syB;
    int i = parami.fDT;
    this.sVc = false;
    Object localObject2 = this.sUh;
    if (localObject2 == null) {
      a.f.b.j.ays("fakeLayer");
    }
    ((StoryVideoViewFakeLayer)localObject2).setVisibility(8);
    if (!parami.cBN())
    {
      ab.i(this.TAG, "play empty item");
      showLoading();
      AppMethodBeat.o(110915);
      return;
    }
    if (parami.cBM())
    {
      this.sVc = true;
      ab.i(this.TAG, "LogStory: play fake video");
      paramString = this.sUh;
      if (paramString == null) {
        a.f.b.j.ays("fakeLayer");
      }
      paramString.setVisibility(0);
      parami = parami.syD;
      if (parami != null)
      {
        paramString = this.sUh;
        if (paramString == null) {
          a.f.b.j.ays("fakeLayer");
        }
        paramString.setFakeVideoInfo(parami);
        paramString = this.sUh;
        if (paramString == null) {
          a.f.b.j.ays("fakeLayer");
        }
        paramString.mu(this.efg);
        this.fVg = parami.videoPath;
        this.fVf = "";
        parami = this.fVg;
        a.f.b.j.p(parami, "filepath");
        adK(parami);
      }
    }
    for (;;)
    {
      setLoop(true);
      parami = this.kvG;
      if (parami != null) {
        break;
      }
      parami = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(110915);
      throw parami;
      ab.i(this.TAG, "LogStory: play normal video");
      localObject2 = s.swk;
      Object localObject3 = s.a((chl)localObject1);
      if (com.tencent.mm.vfs.e.avI((String)localObject3) > 0L)
      {
        ab.i(this.TAG, "play " + (String)localObject3 + " downloadDone now can play " + ((chl)localObject1).Id);
        this.fVg = ((String)localObject3);
        if (localObject3 != null) {
          adK((String)localObject3);
        }
      }
      else
      {
        localObject2 = s.swk;
        localObject2 = s.a(parami);
        int j = (int)com.tencent.mm.vfs.e.avI(((n)localObject2).field_filePath);
        ab.i(this.TAG, "play " + (String)localObject3 + " error try play from url or videoCache " + ((chl)localObject1).Id + " fileLength:" + j + " cacheSize:" + ((n)localObject2).field_cacheSize);
        if (j < ((n)localObject2).field_cacheSize)
        {
          ((n)localObject2).field_cacheSize = j;
          localObject3 = com.tencent.mm.plugin.story.model.j.svi;
          j.b.cAF().b((n)localObject2);
        }
        ab.i(this.TAG, String.valueOf(localObject2));
        if ((((n)localObject2).Jo()) && (com.tencent.mm.vfs.e.cN(((n)localObject2).field_filePath)))
        {
          ab.i(this.TAG, "play " + ((chl)localObject1).Id + " download finish");
          this.fVg = ((n)localObject2).field_filePath;
          parami = s.swk;
          this.fVf = s.be(i, ((chl)localObject1).Url);
          parami = this.fVg;
          a.f.b.j.p(parami, "filepath");
          adK(parami);
        }
        else
        {
          if ((((n)localObject2).Jo()) && (!com.tencent.mm.vfs.e.cN(((n)localObject2).field_filePath)))
          {
            ab.i(this.TAG, "error downloadFinish " + ((n)localObject2).Jo() + " ret:" + com.tencent.mm.vfs.e.cN(((n)localObject2).field_filePath));
            ((n)localObject2).cFl();
            localObject3 = com.tencent.mm.plugin.story.model.j.svi;
            j.b.cAF().b((n)localObject2);
          }
          ab.i(this.TAG, "play " + ((chl)localObject1).Id + ' ' + paramString + " start online play " + ((n)localObject2).field_filePath);
          reset();
          this.kvG.stop();
          this.kvG.setVideoCallback((e.a)this);
          this.sVa = false;
          this.vPy = true;
          setNeedShowLoading(true);
          super.c(false, parami.syB.Url, (int)((chl)localObject1).duration);
          this.fVg = ((n)localObject2).field_filePath;
          parami = s.swk;
          this.fVf = s.be(i, ((chl)localObject1).Url);
          this.cpW = paramString;
          this.fqZ = bo.yB();
          this.sVd = 0L;
          start();
        }
      }
    }
    ((View)parami).setAlpha(0.0F);
    AppMethodBeat.o(110915);
  }
  
  public final boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(110936);
    a.f.b.j.q(paramPInt1, "start");
    a.f.b.j.q(paramPInt2, "end");
    Object localObject1 = "";
    paramPInt1.value = Math.max(paramInt, this.fVp);
    if (this.fVj == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.fVq;
      localObject1 = "" + "step1;";
    }
    Object localObject2 = localObject1;
    if (this.fVj == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.fVq + 8);
      localObject2 = (String)localObject1 + "step2;";
    }
    if (this.fVj == 3)
    {
      paramPInt1.value = this.fVp;
      paramPInt2.value = (paramInt + 1 + this.fVu.fVA);
      localObject1 = (String)localObject2 + "step3;";
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (paramPInt2.value >= this.fVl + 1)
      {
        paramPInt2.value = (this.fVl + 1);
        localObject2 = (String)localObject1 + "step5;";
      }
      if (paramPInt2.value >= paramPInt1.value) {
        break;
      }
      paramPInt1.value += this.fVu.fVA;
      AppMethodBeat.o(110936);
      return false;
      localObject1 = localObject2;
      if (this.fVj == 4)
      {
        paramPInt1.value = this.fVp;
        paramPInt2.value = (this.fVq + paramInt + 1 + this.fVu.fVA);
        localObject1 = (String)localObject2 + "step4;";
      }
    }
    ab.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s] %s", new Object[] { bas(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.fVj), Integer.valueOf(this.fVp), Integer.valueOf(this.fVq), this.fVf, localObject2 });
    AppMethodBeat.o(110936);
    return true;
  }
  
  public final void aEM()
  {
    AppMethodBeat.i(110930);
    ab.i(this.TAG, "onUIDestroy, isLocalVideo:" + this.sVa);
    StoryVideoViewFakeLayer localStoryVideoViewFakeLayer = this.sUh;
    if (localStoryVideoViewFakeLayer == null) {
      a.f.b.j.ays("fakeLayer");
    }
    localStoryVideoViewFakeLayer.cGx();
    super.aEM();
    AppMethodBeat.o(110930);
  }
  
  public final void ad(String paramString, int paramInt)
  {
    AppMethodBeat.i(110933);
    super.ad(paramString, paramInt);
    AppMethodBeat.o(110933);
  }
  
  public final void aln()
  {
    AppMethodBeat.i(110946);
    ab.i(this.TAG, "prepareVideo, surfaceAvailable:" + this.stu);
    if (this.kvG != null)
    {
      localObject = this.kvG;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView");
        AppMethodBeat.o(110946);
        throw ((Throwable)localObject);
      }
      ((StoryVideoPlayTextureView)localObject).setNeedResetExtractor(byv());
    }
    Object localObject = this.fVg;
    a.f.b.j.p(localObject, "filepath");
    adL((String)localObject);
    super.aln();
    AppMethodBeat.o(110946);
  }
  
  public final void alo()
  {
    AppMethodBeat.i(110928);
    ab.i(this.TAG, "onUIPause, isLocalVideo:" + this.sVa);
    Object localObject = this.sUh;
    if (localObject == null) {
      a.f.b.j.ays("fakeLayer");
    }
    ((StoryVideoViewFakeLayer)localObject).cGw();
    if (this.sVa)
    {
      localObject = this.kvG;
      if (localObject != null)
      {
        ((com.tencent.mm.pluginsdk.ui.tools.e)localObject).pause();
        AppMethodBeat.o(110928);
        return;
      }
      AppMethodBeat.o(110928);
      return;
    }
    super.alo();
    AppMethodBeat.o(110928);
  }
  
  public final void alp()
  {
    AppMethodBeat.i(110929);
    ab.i(this.TAG, "onUIResume, isLocalVideo:" + this.sVa);
    if (isPlaying())
    {
      StoryVideoViewFakeLayer localStoryVideoViewFakeLayer = this.sUh;
      if (localStoryVideoViewFakeLayer == null) {
        a.f.b.j.ays("fakeLayer");
      }
      localStoryVideoViewFakeLayer.mu(this.efg);
    }
    if (this.sVa)
    {
      AppMethodBeat.o(110929);
      return;
    }
    super.alp();
    AppMethodBeat.o(110929);
  }
  
  public final void alr()
  {
    AppMethodBeat.i(110945);
    super.alr();
    ab.i(this.TAG, "onSurfaceAvailable");
    this.stu = true;
    AppMethodBeat.o(110945);
  }
  
  public final void bSk()
  {
    AppMethodBeat.i(110940);
    super.bSk();
    Object localObject = this.kvG;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(110940);
      throw ((Throwable)localObject);
    }
    ((View)localObject).setAlpha(1.0F);
    String str;
    StringBuilder localStringBuilder;
    if (this.sVd <= 0L)
    {
      this.sVd = bo.av(this.fqZ);
      str = this.TAG;
      localStringBuilder = new StringBuilder("onTextureUpdate firstPlayWaitTime ").append(this.sVd).append(" storyId: ");
      localObject = this.syr;
      if (localObject == null) {
        break label131;
      }
    }
    label131:
    for (localObject = Long.valueOf(((com.tencent.mm.plugin.story.model.d.i)localObject).cJA);; localObject = null)
    {
      ab.i(str, localObject);
      AppMethodBeat.o(110940);
      return;
    }
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(156828);
    super.c(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(156828);
  }
  
  public final int cGt()
  {
    if (this.vPK.rJM > this.vPK.startTimeStamp) {
      return (int)(this.vPK.rJM - this.vPK.startTimeStamp);
    }
    return 0;
  }
  
  public final int cGu()
  {
    return this.vPK.blockCount;
  }
  
  public final int cGv()
  {
    if (this.vPK.blockCount > 0) {
      return (int)(this.vPK.vRL / this.vPK.blockCount);
    }
    return 0;
  }
  
  public final com.tencent.mm.pluginsdk.ui.tools.e ck(Context paramContext)
  {
    AppMethodBeat.i(110944);
    paramContext = new StoryVideoPlayTextureView(paramContext);
    paramContext.setOpenWithNoneSurface(true);
    paramContext.setNeedResetExtractor(byv());
    paramContext.setIsOnlineVideoType(true);
    paramContext = (com.tencent.mm.pluginsdk.ui.tools.e)paramContext;
    AppMethodBeat.o(110944);
    return paramContext;
  }
  
  public final void dQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110932);
    super.dQ(paramInt1, paramInt2);
    ab.i(this.TAG, "onGetVideoSize, mediaId:" + getMediaId() + ", isLocalVideo:" + this.sVa + ", isPrepareVideo:" + this.fVr + ", isPrepared:" + this.Pz + ", playerStatus:" + this.fVj + ", downloadStatus:" + this.fVi);
    AppMethodBeat.o(110932);
  }
  
  public final void dg(boolean paramBoolean)
  {
    AppMethodBeat.i(110922);
    if (this.sVa)
    {
      AppMethodBeat.o(110922);
      return;
    }
    super.dg(paramBoolean);
    AppMethodBeat.o(110922);
  }
  
  public final void dh(boolean paramBoolean)
  {
    AppMethodBeat.i(110923);
    ab.b(this.TAG, bas() + " startTimer, isLocalVideo:" + this.sVa, new Object[0]);
    if (!this.sVa) {
      super.dh(paramBoolean);
    }
    AppMethodBeat.o(110923);
  }
  
  public final void g(com.tencent.mm.plugin.story.model.d.i parami)
  {
    Object localObject2 = null;
    AppMethodBeat.i(110919);
    ab.i(this.TAG, "resume, current play time:" + getCurrPosMs() + ", " + getCurrPosSec() + ", " + getVideoDurationSec() + ", isPrepared:" + this.Pz + ", sessionId:" + this.cpW + ", isLocalVideo:" + this.sVa);
    Object localObject1 = this.sUh;
    if (localObject1 == null) {
      a.f.b.j.ays("fakeLayer");
    }
    ((StoryVideoViewFakeLayer)localObject1).mu(this.efg);
    if (getCurrPosSec() >= getVideoDurationSec())
    {
      ab.i(this.TAG, "resume, restart video");
      if (parami != null)
      {
        a(parami, this.cpW);
        AppMethodBeat.o(110919);
        return;
      }
    }
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checkResumeLocalVideo, isLocalVideo:").append(this.sVa).append(", currentPosition:");
    localObject1 = this.kvG;
    int i;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.e)localObject1).getCurrentPosition());
      ab.i((String)localObject3, localObject1);
      if (!this.sVa) {
        break label330;
      }
      localObject1 = this.kvG;
      if (localObject1 == null) {
        break label325;
      }
      i = ((com.tencent.mm.pluginsdk.ui.tools.e)localObject1).getCurrentPosition();
      label263:
      if (i <= 0) {
        break label330;
      }
      localObject3 = this.kvG;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = Boolean.valueOf(((com.tencent.mm.pluginsdk.ui.tools.e)localObject3).start());
      }
      this.sVb = false;
    }
    label325:
    label330:
    for (boolean bool = a.f.b.j.e(localObject1, Boolean.TRUE);; bool = false)
    {
      if (!bool) {
        break label335;
      }
      AppMethodBeat.o(110919);
      return;
      localObject1 = null;
      break;
      i = 0;
      break label263;
    }
    label335:
    if ((getCurrPosMs() > 0) && (!this.sVa))
    {
      if (!this.Pz)
      {
        this.vPy = true;
        aln();
        AppMethodBeat.o(110919);
        return;
      }
      super.play();
      AppMethodBeat.o(110919);
      return;
    }
    if (parami != null) {
      a(parami, this.cpW);
    }
    AppMethodBeat.o(110919);
  }
  
  public final int getErrorCode()
  {
    return this.vPK.vRM;
  }
  
  public final String getFilePath()
  {
    AppMethodBeat.i(110942);
    String str = this.fVg;
    a.f.b.j.p(str, "filepath");
    AppMethodBeat.o(110942);
    return str;
  }
  
  public final long getFirstPlayWaitTime()
  {
    return this.sVd;
  }
  
  public final String getSessionId()
  {
    AppMethodBeat.i(110917);
    String str = bo.nullAsNil(this.cpW);
    a.f.b.j.p(str, "Util.nullAsNil(sessionId)");
    AppMethodBeat.o(110917);
    return str;
  }
  
  public final int getStayTime()
  {
    AppMethodBeat.i(110941);
    int i = (int)bo.av(this.fqZ);
    AppMethodBeat.o(110941);
    return i;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(110914);
    super.initView();
    Object localObject = getContext();
    a.f.b.j.p(localObject, "context");
    this.sUh = new StoryVideoViewFakeLayer((Context)localObject);
    localObject = this.vPp;
    StoryVideoViewFakeLayer localStoryVideoViewFakeLayer = this.sUh;
    if (localStoryVideoViewFakeLayer == null) {
      a.f.b.j.ays("fakeLayer");
    }
    ((RelativeLayout)localObject).addView((View)localStoryVideoViewFakeLayer, new ViewGroup.LayoutParams(-1, -1));
    this.mEu = ((TextView)findViewById(2131822194));
    AppMethodBeat.o(110914);
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(110925);
    if (this.sVa)
    {
      AppMethodBeat.o(110925);
      return false;
    }
    boolean bool = super.isLive();
    AppMethodBeat.o(110925);
    return bool;
  }
  
  public final boolean mk(int paramInt)
  {
    AppMethodBeat.i(110935);
    boolean bool = super.mk(paramInt);
    ab.i(this.TAG, "checkCanPlay, cachePlayTime:" + this.fVp + ", ret:" + bool);
    AppMethodBeat.o(110935);
    return bool;
  }
  
  public final void n(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110931);
    if (!bo.isEqual(this.fVf, paramString))
    {
      AppMethodBeat.o(110931);
      return;
    }
    paramString = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("%s download  onProgress [%d, %d], pauseByLoadData:").append(this.fVo).append(", playStatus:").append(this.fVj).append(", currPosMs:").append(getCurrPosMs()).append(", isPlyaing:");
    com.tencent.mm.pluginsdk.ui.tools.e locale = this.kvG;
    a.f.b.j.p(locale, "videoView");
    ab.d(paramString, locale.isPlaying(), new Object[] { bas(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (((getCurrPosMs() <= 0) || (this.fVj == 1) || (this.fVj == 0)) && (mj(getCurrPosSec()))) {
      dh(true);
    }
    AppMethodBeat.o(110931);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(110920);
    ab.i(this.TAG, "pause, isLocalVideo:" + this.sVa);
    StoryVideoViewFakeLayer localStoryVideoViewFakeLayer = this.sUh;
    if (localStoryVideoViewFakeLayer == null) {
      a.f.b.j.ays("fakeLayer");
    }
    localStoryVideoViewFakeLayer.cGw();
    if (this.sVa)
    {
      this.sVb = true;
      this.kvG.pause();
      AppMethodBeat.o(110920);
      return true;
    }
    boolean bool = super.pause();
    AppMethodBeat.o(110920);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(110947);
    super.reset();
    this.stu = false;
    this.cpW = null;
    AppMethodBeat.o(110947);
  }
  
  public final void setFirstPlayWaitTime(long paramLong)
  {
    this.sVd = paramLong;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(110918);
    super.setMute(paramBoolean);
    this.efg = paramBoolean;
    if (this.kvG != null) {
      this.kvG.setMute(paramBoolean);
    }
    AppMethodBeat.o(110918);
  }
  
  public final void setNeedShowLoading(boolean paramBoolean)
  {
    AppMethodBeat.i(110926);
    ab.i(this.TAG, hashCode() + " setNeedShowLoading: " + paramBoolean);
    this.sUZ = paramBoolean;
    if (!this.sUZ) {
      hideLoading();
    }
    AppMethodBeat.o(110926);
  }
  
  public final void setScaleType(h.d paramd)
  {
    AppMethodBeat.i(110943);
    super.setScaleType(paramd);
    AppMethodBeat.o(110943);
  }
  
  public final void showLoading()
  {
    AppMethodBeat.i(110927);
    if (this.sUZ) {
      ie(800L);
    }
    AppMethodBeat.o(110927);
  }
  
  public final void start()
  {
    AppMethodBeat.i(110937);
    if ((this.aZy > 0) && (!this.sVa))
    {
      ab.i(this.TAG, "start from onError and not local video");
      localObject = this.syr;
      if (localObject != null)
      {
        s locals = s.swk;
        localObject = s.a((com.tencent.mm.plugin.story.model.d.i)localObject);
        if (((n)localObject).Jo())
        {
          ab.i(this.TAG, "start from onError and download finish now");
          localObject = ((n)localObject).field_filePath;
          a.f.b.j.p(localObject, "videoCache.field_filePath");
          adK((String)localObject);
          AppMethodBeat.o(110937);
          return;
        }
      }
    }
    Object localObject = this.fVg;
    a.f.b.j.p(localObject, "filepath");
    adL((String)localObject);
    super.start();
    AppMethodBeat.o(110937);
  }
  
  public final void stop()
  {
    long l = 1L;
    AppMethodBeat.i(110938);
    for (;;)
    {
      try
      {
        Object localObject1 = this.sUh;
        if (localObject1 == null) {
          a.f.b.j.ays("fakeLayer");
        }
        ((StoryVideoViewFakeLayer)localObject1).cGx();
        if (this.sVa)
        {
          bw localbw = new bw();
          localObject1 = this.syr;
          if (localObject1 == null) {
            break label343;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.story.model.d.i)localObject1).cJA);
          localObject1 = localbw.gS(String.valueOf(localObject1));
          com.tencent.mm.plugin.story.g.i locali = com.tencent.mm.plugin.story.g.i.sFa;
          localObject1 = ((bw)localObject1).el(com.tencent.mm.plugin.story.g.i.cDo().FF());
          locali = com.tencent.mm.plugin.story.g.i.sFa;
          if (com.tencent.mm.plugin.story.g.i.cDo().FK() != 1L) {
            break label348;
          }
          localObject1 = ((bw)localObject1).en(l).eq(this.sVd).er(getStayTime()).es(getErrorCode()).GW();
          locali = com.tencent.mm.plugin.story.g.i.sFa;
          localObject1 = ((bw)localObject1).eu(com.tencent.mm.plugin.story.g.i.cDo().FE());
          locali = com.tencent.mm.plugin.story.g.i.sFa;
          ((bw)localObject1).ev(com.tencent.mm.plugin.story.g.i.cDo().FH()).ep(getCurrPosMs());
          ab.d(this.TAG, "time distance %d", new Object[] { Long.valueOf(System.currentTimeMillis() - localbw.GX()) });
          if (System.currentTimeMillis() - localbw.GX() >= 500L)
          {
            localObject1 = this.syr;
            if (localObject1 == null) {
              break label353;
            }
            l = ((com.tencent.mm.plugin.story.model.d.i)localObject1).cJA;
          }
          try
          {
            localObject1 = com.tencent.mm.plugin.story.model.j.svi;
            j.b.coO().post((Runnable)new StoryVideoView.c(this, localbw, l));
            this.kvG.stop();
            reset();
            AppMethodBeat.o(110938);
            return;
          }
          catch (Exception localException1)
          {
            ab.printErrStackTrace(this.TAG, (Throwable)localException1, "reportStopLocalVideo", new Object[0]);
            localbw.ake();
            continue;
          }
        }
        super.stop();
      }
      catch (Exception localException2)
      {
        ab.printErrStackTrace(this.TAG, (Throwable)localException2, "stop error", new Object[0]);
        AppMethodBeat.o(110938);
        return;
      }
      AppMethodBeat.o(110938);
      return;
      label343:
      Object localObject2 = null;
      continue;
      label348:
      l = 0L;
      continue;
      label353:
      l = 0L;
    }
  }
  
  public final void stopTimer()
  {
    AppMethodBeat.i(110924);
    ab.b(this.TAG, bas() + " stopTimer, isLocalVideo:" + this.sVa, new Object[0]);
    super.stopTimer();
    AppMethodBeat.o(110924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoView
 * JD-Core Version:    0.7.0.1
 */