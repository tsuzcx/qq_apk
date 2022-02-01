package com.tencent.mm.plugin.recordvideo.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.exoplayer2.g.a.a;
import com.google.android.exoplayer2.g.f.a;
import com.google.android.exoplayer2.g.h;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.e.c.a;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.i.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.m;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "backgrounndSilent", "", "exoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "fakeImageView", "Landroid/widget/ImageView;", "fakeMusicInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "fakeVideoInfo", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "loopingFrame", "startTime", "", "stopTime", "storyFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "useFakeImage", "videoHeight", "", "videoPlaying", "videoRotation", "videoWidth", "checkFakeVideoMatchScreenRatio", "isBackgroundSilent", "pauseFakeLayer", "", "playAudio", "playFakeLayer", "mute", "requestLoopFakeFrame", "frameRetriever", "setFakeVideoInfo", "videoEditData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "stopFakeLayer", "plugin-recordvideo_release"})
public final class FakeVideoViewLayer
  extends RelativeLayout
{
  private final String TAG;
  private long gvN;
  private long startTime;
  private int videoHeight;
  private int videoWidth;
  private v xDo;
  private afy xHE;
  private AudioCacheInfo xHF;
  public boolean xHG;
  private ImageView xHH;
  private com.tencent.mm.plugin.recordvideo.ui.editor.b.g xHI;
  private boolean xHJ;
  private boolean xHK;
  private int xHL;
  
  public FakeVideoViewLayer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(75864);
    this.TAG = "MicroMsg.FakeVideoViewLayer";
    AppMethodBeat.o(75864);
  }
  
  public FakeVideoViewLayer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75865);
    this.TAG = "MicroMsg.FakeVideoViewLayer";
    AppMethodBeat.o(75865);
  }
  
  private final void a(final com.tencent.mm.plugin.recordvideo.ui.editor.b.g paramg)
  {
    AppMethodBeat.i(200434);
    if (!this.xHJ)
    {
      ad.i(this.TAG, "requestLoopFakeFrame stop");
      AppMethodBeat.o(200434);
      return;
    }
    if ((p.i(paramg, this.xHI) ^ true))
    {
      ad.i(this.TAG, "requestLoopFakeFrame frameRetriever not match");
      AppMethodBeat.o(200434);
      return;
    }
    Object localObject = this.xHE;
    if (((localObject != null) && (((afy)localObject).htP == true)) || (!this.xHK))
    {
      ad.i(this.TAG, "requestLoopFakeFrame local capture video or not useFakeImage");
      AppMethodBeat.o(200434);
      return;
    }
    com.tencent.mm.plugin.recordvideo.ui.editor.b.a locala = paramg.ckc();
    ImageView localImageView = this.xHH;
    long l;
    label180:
    int i;
    if (localImageView != null)
    {
      if (locala != null)
      {
        localObject = locala.bitmap;
        localImageView.setImageBitmap((Bitmap)localObject);
      }
    }
    else
    {
      localObject = this.xHH;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      if (locala == null) {
        break label285;
      }
      localObject = Long.valueOf(locala.xPI);
      l = ((Number)localObject).longValue();
      if (1L <= l) {
        break label242;
      }
      i = 0;
      label182:
      if (i == 0) {
        break label273;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        l = ((Number)localObject).longValue();
        localObject = this.xHH;
        if (localObject != null)
        {
          ((ImageView)localObject).postDelayed((Runnable)new a(this, paramg), l);
          AppMethodBeat.o(200434);
          return;
          localObject = null;
          break;
          label242:
          if ((1000L < l) || (!this.xHJ) || (!p.i(paramg, this.xHI))) {
            break label180;
          }
          i = 1;
          break label182;
          label273:
          localObject = null;
          continue;
        }
        AppMethodBeat.o(200434);
        return;
      }
    }
    label285:
    AppMethodBeat.o(200434);
  }
  
  private final void playAudio()
  {
    AppMethodBeat.i(75863);
    Object localObject2 = new com.google.android.exoplayer2.g.c((f.a)new a.a((com.google.android.exoplayer2.h.d)new com.google.android.exoplayer2.h.l()));
    Object localObject1 = x.h(getContext(), getContext().getString(2131755822));
    this.xDo = com.google.android.exoplayer2.g.a(getContext(), (h)localObject2);
    try
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.model.audio.i.xzM;
      localObject2 = this.xHF;
      if (localObject2 == null) {
        p.gfZ();
      }
      p.g(localObject1, "userAgent");
      localObject1 = new com.google.android.exoplayer2.source.d(i.a.a((AudioCacheInfo)localObject2, (String)localObject1), this.startTime, this.gvN * 1000L);
      localObject2 = this.xDo;
      if (localObject2 != null) {
        ((v)localObject2).aP(true);
      }
      localObject2 = this.xDo;
      if (localObject2 != null) {
        ((v)localObject2).a((com.google.android.exoplayer2.source.i)localObject1);
      }
      localObject1 = this.xDo;
      if (localObject1 != null)
      {
        ((v)localObject1).setRepeatMode(2);
        AppMethodBeat.o(75863);
        return;
      }
      AppMethodBeat.o(75863);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(75863);
    }
  }
  
  public final void dHk()
  {
    AppMethodBeat.i(75861);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("LogStory: pauseFakeLayer ");
    Object localObject = this.xHE;
    int i;
    if (localObject != null)
    {
      localObject = Long.valueOf(((afy)localObject).timeStamp);
      ad.i(str, localObject);
      localObject = this.xDo;
      if (localObject != null) {
        ((v)localObject).aP(false);
      }
      int j = getChildCount();
      i = 0;
      label76:
      if (i >= j) {
        break label131;
      }
      localObject = getChildAt(i);
      if (!(localObject instanceof MMAnimateView)) {
        break label113;
      }
      ((MMAnimateView)localObject).pause();
    }
    for (;;)
    {
      i += 1;
      break label76;
      localObject = null;
      break;
      label113:
      if ((localObject instanceof m)) {
        ((m)localObject).xPa = false;
      }
    }
    label131:
    this.xHJ = false;
    localObject = this.xHH;
    if (localObject != null) {
      ((ImageView)localObject).setImageBitmap(null);
    }
    localObject = this.xHH;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.xHI;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject).destroy();
    }
    this.xHI = null;
    AppMethodBeat.o(75861);
  }
  
  public final void dHl()
  {
    AppMethodBeat.i(75862);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("LogStory: stopFakeLayer ");
    Object localObject = this.xHE;
    int i;
    if (localObject != null)
    {
      localObject = Long.valueOf(((afy)localObject).timeStamp);
      ad.i(str, localObject);
      localObject = this.xDo;
      if (localObject != null) {
        ((v)localObject).stop();
      }
      localObject = this.xDo;
      if (localObject != null) {
        ((v)localObject).release();
      }
      this.xDo = null;
      int j = getChildCount();
      i = 0;
      label93:
      if (i >= j) {
        break label148;
      }
      localObject = getChildAt(i);
      if (!(localObject instanceof MMAnimateView)) {
        break label130;
      }
      ((MMAnimateView)localObject).stop();
    }
    for (;;)
    {
      i += 1;
      break label93;
      localObject = null;
      break;
      label130:
      if ((localObject instanceof m)) {
        ((m)localObject).xPa = false;
      }
    }
    label148:
    this.xHJ = false;
    localObject = this.xHH;
    if (localObject != null) {
      ((ImageView)localObject).setImageBitmap(null);
    }
    localObject = this.xHH;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.xHI;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject).destroy();
    }
    this.xHI = null;
    AppMethodBeat.o(75862);
  }
  
  public final void pW(boolean paramBoolean)
  {
    AppMethodBeat.i(75860);
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("LogStory: playFakeLayer ");
    Object localObject1 = this.xHE;
    int i;
    if (localObject1 != null)
    {
      localObject1 = Long.valueOf(((afy)localObject1).timeStamp);
      ad.i((String)localObject2, localObject1);
      localObject1 = this.xDo;
      if (localObject1 != null) {
        ((v)localObject1).stop();
      }
      localObject1 = this.xDo;
      if (localObject1 != null) {
        ((v)localObject1).release();
      }
      if ((this.xHF != null) && (!paramBoolean)) {
        playAudio();
      }
      int j = getChildCount();
      i = 0;
      label114:
      if (i >= j) {
        break label174;
      }
      localObject1 = getChildAt(i);
      if (!(localObject1 instanceof MMAnimateView)) {
        break label155;
      }
      ((MMAnimateView)localObject1).resume();
    }
    for (;;)
    {
      i += 1;
      break label114;
      localObject1 = null;
      break;
      label155:
      if ((localObject1 instanceof m)) {
        ((m)localObject1).resume();
      }
    }
    label174:
    if (this.xHK)
    {
      localObject1 = this.xHE;
      if (localObject1 != null)
      {
        localObject2 = this.xHI;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject2).destroy();
        }
        localObject2 = this.xHH;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageBitmap(null);
        }
        localObject2 = e.xuo;
        localObject2 = getContext();
        p.g(localObject2, "context");
        this.xHI = e.a((afy)localObject1, (Context)localObject2, this.videoWidth, this.videoHeight, this.xHL);
        localObject1 = this.xHI;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject1).start();
          this.xHJ = true;
          a((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject1);
          AppMethodBeat.o(75860);
          return;
        }
        AppMethodBeat.o(75860);
        return;
      }
    }
    AppMethodBeat.o(75860);
  }
  
  public final void setFakeVideoInfo(com.tencent.mm.plugin.recordvideo.background.c paramc)
  {
    boolean bool3 = true;
    AppMethodBeat.i(75858);
    p.h(paramc, "videoEditData");
    Object localObject1 = (com.tencent.mm.bx.a)new afy();
    Object localObject2 = paramc.field_baseItemData;
    afy localafy;
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject2);
      localObject1 = (afy)localObject1;
      if (localObject1 == null)
      {
        AppMethodBeat.o(75858);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.l("safeParser", "", new Object[] { localException });
        localafy = null;
      }
      this.videoWidth = paramc.field_targetWidth;
      this.videoHeight = paramc.field_targetHeight;
      this.xHL = paramc.field_videoRotate;
      ad.i(this.TAG, "LogStory: setFakeVideoInfo " + localafy.timeStamp);
      this.xHE = localafy;
      if (this.xHH != null) {
        break label224;
      }
    }
    paramc = new ImageView(getContext());
    if ((this.xHL == 90) || (this.xHL == 270))
    {
      int i = this.videoHeight;
      this.videoHeight = this.videoWidth;
      this.videoWidth = i;
    }
    label224:
    boolean bool2;
    if (this.videoWidth > this.videoHeight)
    {
      paramc.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.xHH = paramc;
      removeAllViews();
      paramc = this.xHE;
      if (paramc == null) {
        break label511;
      }
      paramc = paramc.videoPath;
      if (paramc == null) {
        break label511;
      }
      localObject2 = com.tencent.mm.plugin.recordvideo.e.c.xRv;
      paramc = com.tencent.mm.plugin.recordvideo.e.c.awc(paramc);
      if (paramc == null) {
        break label506;
      }
      bool1 = paramc.xRw;
      label265:
      if ((localafy.htP) || (bool1)) {
        break label516;
      }
      bool2 = true;
      label280:
      this.xHK = bool2;
      ad.i(this.TAG, "useFakeImage:" + this.xHK + ", isCaptureVideo:" + localafy.htP + ", matchScreenRatio:" + bool1);
      if (!this.xHK) {
        break label522;
      }
      addView((View)this.xHH, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      paramc = this.xHH;
      if (paramc != null) {
        paramc.setVisibility(0);
      }
      label381:
      if (localafy.hml == null) {
        break label565;
      }
      paramc = new AudioCacheInfo();
      paramc.xyZ = localafy.xyZ;
      paramc.aXj = localafy.aXj;
      paramc.cachePath = localafy.hml;
      paramc.musicUrl = localafy.musicUrl;
      this.xHF = paramc;
      label438:
      bool1 = bool3;
      if (localafy.hhG != 0) {
        if (localafy.hhG != 2) {
          break label573;
        }
      }
    }
    label516:
    label522:
    label565:
    label573:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      this.xHG = bool1;
      this.startTime = localafy.startTime;
      this.gvN = localafy.endTime;
      this.xHJ = false;
      AppMethodBeat.o(75858);
      return;
      paramc.setScaleType(ImageView.ScaleType.CENTER_CROP);
      break;
      label506:
      bool1 = false;
      break label265;
      label511:
      bool1 = false;
      break label265;
      bool2 = false;
      break label280;
      paramc = e.xuo;
      paramc = getContext();
      p.g(paramc, "context");
      e.a(localafy, paramc, (ViewGroup)this);
      paramc = this.xHH;
      if (paramc == null) {
        break label381;
      }
      paramc.setVisibility(8);
      break label381;
      this.xHF = null;
      break label438;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer$requestLoopFakeFrame$2$1"})
  static final class a
    implements Runnable
  {
    a(FakeVideoViewLayer paramFakeVideoViewLayer, com.tencent.mm.plugin.recordvideo.ui.editor.b.g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(75857);
      FakeVideoViewLayer.a(this.xHM, paramg);
      AppMethodBeat.o(75857);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer
 * JD-Core Version:    0.7.0.1
 */