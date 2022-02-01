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
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "backgrounndSilent", "", "exoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "fakeImageView", "Landroid/widget/ImageView;", "fakeMusicInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "fakeVideoInfo", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "loopingFrame", "startTime", "", "stopTime", "storyFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "useFakeImage", "videoHeight", "", "videoPlaying", "videoRotation", "videoWidth", "checkFakeVideoMatchScreenRatio", "isBackgroundSilent", "pauseFakeLayer", "", "playAudio", "playFakeLayer", "mute", "requestLoopFakeFrame", "frameRetriever", "setFakeVideoInfo", "videoEditData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "stopFakeLayer", "plugin-recordvideo_release"})
public final class FakeVideoViewLayer
  extends RelativeLayout
{
  private final String TAG;
  private long gyu;
  private long startTime;
  private int videoHeight;
  private int videoWidth;
  private v xTj;
  private AudioCacheInfo xXA;
  public boolean xXB;
  private ImageView xXC;
  private com.tencent.mm.plugin.recordvideo.ui.editor.b.g xXD;
  private boolean xXE;
  private boolean xXF;
  private int xXG;
  private agh xXz;
  
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
    AppMethodBeat.i(206695);
    if (!this.xXE)
    {
      ae.i(this.TAG, "requestLoopFakeFrame stop");
      AppMethodBeat.o(206695);
      return;
    }
    if ((p.i(paramg, this.xXD) ^ true))
    {
      ae.i(this.TAG, "requestLoopFakeFrame frameRetriever not match");
      AppMethodBeat.o(206695);
      return;
    }
    Object localObject = this.xXz;
    if (((localObject != null) && (((agh)localObject).hwD == true)) || (!this.xXF))
    {
      ae.i(this.TAG, "requestLoopFakeFrame local capture video or not useFakeImage");
      AppMethodBeat.o(206695);
      return;
    }
    com.tencent.mm.plugin.recordvideo.ui.editor.b.a locala = paramg.cls();
    ImageView localImageView = this.xXC;
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
      localObject = this.xXC;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      if (locala == null) {
        break label285;
      }
      localObject = Long.valueOf(locala.yfB);
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
        localObject = this.xXC;
        if (localObject != null)
        {
          ((ImageView)localObject).postDelayed((Runnable)new a(this, paramg), l);
          AppMethodBeat.o(206695);
          return;
          localObject = null;
          break;
          label242:
          if ((1000L < l) || (!this.xXE) || (!p.i(paramg, this.xXD))) {
            break label180;
          }
          i = 1;
          break label182;
          label273:
          localObject = null;
          continue;
        }
        AppMethodBeat.o(206695);
        return;
      }
    }
    label285:
    AppMethodBeat.o(206695);
  }
  
  private final void playAudio()
  {
    AppMethodBeat.i(75863);
    Object localObject2 = new com.google.android.exoplayer2.g.c((f.a)new a.a((com.google.android.exoplayer2.h.d)new com.google.android.exoplayer2.h.l()));
    Object localObject1 = x.h(getContext(), getContext().getString(2131755822));
    this.xTj = com.google.android.exoplayer2.g.a(getContext(), (h)localObject2);
    try
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.model.audio.i.xPI;
      localObject2 = this.xXA;
      if (localObject2 == null) {
        p.gkB();
      }
      p.g(localObject1, "userAgent");
      localObject1 = new com.google.android.exoplayer2.source.d(i.a.a((AudioCacheInfo)localObject2, (String)localObject1), this.startTime, this.gyu * 1000L);
      localObject2 = this.xTj;
      if (localObject2 != null) {
        ((v)localObject2).aP(true);
      }
      localObject2 = this.xTj;
      if (localObject2 != null) {
        ((v)localObject2).a((com.google.android.exoplayer2.source.i)localObject1);
      }
      localObject1 = this.xTj;
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
      ae.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(75863);
    }
  }
  
  public final void dKB()
  {
    AppMethodBeat.i(75861);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("LogStory: pauseFakeLayer ");
    Object localObject = this.xXz;
    int i;
    if (localObject != null)
    {
      localObject = Long.valueOf(((agh)localObject).timeStamp);
      ae.i(str, localObject);
      localObject = this.xTj;
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
        ((m)localObject).yeT = false;
      }
    }
    label131:
    this.xXE = false;
    localObject = this.xXC;
    if (localObject != null) {
      ((ImageView)localObject).setImageBitmap(null);
    }
    localObject = this.xXC;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.xXD;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject).destroy();
    }
    this.xXD = null;
    AppMethodBeat.o(75861);
  }
  
  public final void dKC()
  {
    AppMethodBeat.i(75862);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("LogStory: stopFakeLayer ");
    Object localObject = this.xXz;
    int i;
    if (localObject != null)
    {
      localObject = Long.valueOf(((agh)localObject).timeStamp);
      ae.i(str, localObject);
      localObject = this.xTj;
      if (localObject != null) {
        ((v)localObject).stop();
      }
      localObject = this.xTj;
      if (localObject != null) {
        ((v)localObject).release();
      }
      this.xTj = null;
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
        ((m)localObject).yeT = false;
      }
    }
    label148:
    this.xXE = false;
    localObject = this.xXC;
    if (localObject != null) {
      ((ImageView)localObject).setImageBitmap(null);
    }
    localObject = this.xXC;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.xXD;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject).destroy();
    }
    this.xXD = null;
    AppMethodBeat.o(75862);
  }
  
  public final void qe(boolean paramBoolean)
  {
    AppMethodBeat.i(75860);
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("LogStory: playFakeLayer ");
    Object localObject1 = this.xXz;
    int i;
    if (localObject1 != null)
    {
      localObject1 = Long.valueOf(((agh)localObject1).timeStamp);
      ae.i((String)localObject2, localObject1);
      localObject1 = this.xTj;
      if (localObject1 != null) {
        ((v)localObject1).stop();
      }
      localObject1 = this.xTj;
      if (localObject1 != null) {
        ((v)localObject1).release();
      }
      if ((this.xXA != null) && (!paramBoolean)) {
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
    if (this.xXF)
    {
      localObject1 = this.xXz;
      if (localObject1 != null)
      {
        localObject2 = this.xXD;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject2).destroy();
        }
        localObject2 = this.xXC;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageBitmap(null);
        }
        localObject2 = e.xKl;
        localObject2 = getContext();
        p.g(localObject2, "context");
        this.xXD = e.a((agh)localObject1, (Context)localObject2, this.videoWidth, this.videoHeight, this.xXG);
        localObject1 = this.xXD;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject1).start();
          this.xXE = true;
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
    Object localObject1 = (com.tencent.mm.bw.a)new agh();
    Object localObject2 = paramc.field_baseItemData;
    agh localagh;
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject2);
      localObject1 = (agh)localObject1;
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
        ae.l("safeParser", "", new Object[] { localException });
        localagh = null;
      }
      this.videoWidth = paramc.field_targetWidth;
      this.videoHeight = paramc.field_targetHeight;
      this.xXG = paramc.field_videoRotate;
      ae.i(this.TAG, "LogStory: setFakeVideoInfo " + localagh.timeStamp);
      this.xXz = localagh;
      if (this.xXC != null) {
        break label224;
      }
    }
    paramc = new ImageView(getContext());
    if ((this.xXG == 90) || (this.xXG == 270))
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
      this.xXC = paramc;
      removeAllViews();
      paramc = this.xXz;
      if (paramc == null) {
        break label511;
      }
      paramc = paramc.videoPath;
      if (paramc == null) {
        break label511;
      }
      localObject2 = com.tencent.mm.plugin.recordvideo.e.c.yho;
      paramc = com.tencent.mm.plugin.recordvideo.e.c.axr(paramc);
      if (paramc == null) {
        break label506;
      }
      bool1 = paramc.yhp;
      label265:
      if ((localagh.hwD) || (bool1)) {
        break label516;
      }
      bool2 = true;
      label280:
      this.xXF = bool2;
      ae.i(this.TAG, "useFakeImage:" + this.xXF + ", isCaptureVideo:" + localagh.hwD + ", matchScreenRatio:" + bool1);
      if (!this.xXF) {
        break label522;
      }
      addView((View)this.xXC, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      paramc = this.xXC;
      if (paramc != null) {
        paramc.setVisibility(0);
      }
      label381:
      if (localagh.hoZ == null) {
        break label565;
      }
      paramc = new AudioCacheInfo();
      paramc.xOV = localagh.xOV;
      paramc.aXj = localagh.aXj;
      paramc.cachePath = localagh.hoZ;
      paramc.musicUrl = localagh.musicUrl;
      this.xXA = paramc;
      label438:
      bool1 = bool3;
      if (localagh.hku != 0) {
        if (localagh.hku != 2) {
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
      this.xXB = bool1;
      this.startTime = localagh.startTime;
      this.gyu = localagh.endTime;
      this.xXE = false;
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
      paramc = e.xKl;
      paramc = getContext();
      p.g(paramc, "context");
      e.a(localagh, paramc, (ViewGroup)this);
      paramc = this.xXC;
      if (paramc == null) {
        break label381;
      }
      paramc.setVisibility(8);
      break label381;
      this.xXA = null;
      break label438;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer$requestLoopFakeFrame$2$1"})
  static final class a
    implements Runnable
  {
    a(FakeVideoViewLayer paramFakeVideoViewLayer, com.tencent.mm.plugin.recordvideo.ui.editor.b.g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(75857);
      FakeVideoViewLayer.a(this.xXH, paramg);
      AppMethodBeat.o(75857);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer
 * JD-Core Version:    0.7.0.1
 */