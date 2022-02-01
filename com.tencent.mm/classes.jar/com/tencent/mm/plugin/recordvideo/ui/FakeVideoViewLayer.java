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
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.g.a.a;
import com.google.android.exoplayer2.g.f.a;
import com.google.android.exoplayer2.g.h;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.recordvideo.background.f;
import com.tencent.mm.plugin.recordvideo.e.c.a;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.i;
import com.tencent.mm.plugin.recordvideo.model.audio.i.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.e;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "backgrounndSilent", "", "exoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "fakeImageView", "Landroid/widget/ImageView;", "fakeMusicInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "fakeVideoInfo", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "loopingFrame", "startTime", "", "stopTime", "storyFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/background/StoryFrameRetriever;", "useFakeImage", "videoHeight", "", "videoPlaying", "videoRotation", "videoWidth", "checkFakeVideoMatchScreenRatio", "isBackgroundSilent", "pauseFakeLayer", "", "playAudio", "playFakeLayer", "mute", "requestLoopFakeFrame", "frameRetriever", "setFakeVideoInfo", "videoEditData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "stopFakeLayer", "plugin-recordvideo_release"})
public final class FakeVideoViewLayer
  extends RelativeLayout
{
  private final String TAG;
  private long fXw;
  private v rdN;
  private long startTime;
  private int videoHeight;
  private int videoWidth;
  private acq vpC;
  private AudioCacheInfo vpD;
  public boolean vpE;
  private ImageView vpF;
  private com.tencent.mm.plugin.recordvideo.background.c vpG;
  private boolean vpH;
  private boolean vpI;
  private int vpJ;
  
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
  
  private final void a(final com.tencent.mm.plugin.recordvideo.background.c paramc)
  {
    AppMethodBeat.i(75859);
    if (!this.vpH)
    {
      ad.i(this.TAG, "requestLoopFakeFrame stop");
      AppMethodBeat.o(75859);
      return;
    }
    if ((k.g(paramc, this.vpG) ^ true))
    {
      ad.i(this.TAG, "requestLoopFakeFrame frameRetriever not match");
      AppMethodBeat.o(75859);
      return;
    }
    Object localObject = this.vpC;
    if (((localObject != null) && (((acq)localObject).gBl == true)) || (!this.vpI))
    {
      ad.i(this.TAG, "requestLoopFakeFrame local capture video or not useFakeImage");
      AppMethodBeat.o(75859);
      return;
    }
    com.tencent.mm.media.g.c localc = paramc.aka();
    ImageView localImageView = this.vpF;
    long l;
    label180:
    int i;
    if (localImageView != null)
    {
      if (localc != null)
      {
        localObject = localc.bitmap;
        localImageView.setImageBitmap((Bitmap)localObject);
      }
    }
    else
    {
      localObject = this.vpF;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      if (localc == null) {
        break label285;
      }
      localObject = Long.valueOf(localc.grP);
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
        localObject = this.vpF;
        if (localObject != null)
        {
          ((ImageView)localObject).postDelayed((Runnable)new a(this, paramc), l);
          AppMethodBeat.o(75859);
          return;
          localObject = null;
          break;
          label242:
          if ((1000L < l) || (!this.vpH) || (!k.g(paramc, this.vpG))) {
            break label180;
          }
          i = 1;
          break label182;
          label273:
          localObject = null;
          continue;
        }
        AppMethodBeat.o(75859);
        return;
      }
    }
    label285:
    AppMethodBeat.o(75859);
  }
  
  private final void playAudio()
  {
    AppMethodBeat.i(75863);
    Object localObject2 = new com.google.android.exoplayer2.g.c((f.a)new a.a((com.google.android.exoplayer2.h.d)new com.google.android.exoplayer2.h.l()));
    Object localObject1 = x.i(getContext(), getContext().getString(2131755822));
    this.rdN = g.a(getContext(), (h)localObject2);
    try
    {
      localObject2 = i.vjj;
      localObject2 = this.vpD;
      if (localObject2 == null) {
        k.fvU();
      }
      k.g(localObject1, "userAgent");
      localObject1 = new com.google.android.exoplayer2.source.d(i.a.a((AudioCacheInfo)localObject2, (String)localObject1), this.startTime, this.fXw * 1000L);
      localObject2 = this.rdN;
      if (localObject2 != null) {
        ((v)localObject2).aO(true);
      }
      localObject2 = this.rdN;
      if (localObject2 != null) {
        ((v)localObject2).a((j)localObject1);
      }
      localObject1 = this.rdN;
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
  
  public final void diF()
  {
    AppMethodBeat.i(75861);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("LogStory: pauseFakeLayer ");
    Object localObject = this.vpC;
    int i;
    if (localObject != null)
    {
      localObject = Long.valueOf(((acq)localObject).timeStamp);
      ad.i(str, localObject);
      localObject = this.rdN;
      if (localObject != null) {
        ((v)localObject).aO(false);
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
      if ((localObject instanceof e)) {
        ((e)localObject).vtv = false;
      }
    }
    label131:
    this.vpH = false;
    localObject = this.vpF;
    if (localObject != null) {
      ((ImageView)localObject).setImageBitmap(null);
    }
    localObject = this.vpF;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.vpG;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.background.c)localObject).destroy();
    }
    this.vpG = null;
    AppMethodBeat.o(75861);
  }
  
  public final void diG()
  {
    AppMethodBeat.i(75862);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("LogStory: stopFakeLayer ");
    Object localObject = this.vpC;
    int i;
    if (localObject != null)
    {
      localObject = Long.valueOf(((acq)localObject).timeStamp);
      ad.i(str, localObject);
      localObject = this.rdN;
      if (localObject != null) {
        ((v)localObject).stop();
      }
      localObject = this.rdN;
      if (localObject != null) {
        ((v)localObject).release();
      }
      this.rdN = null;
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
      if ((localObject instanceof e)) {
        ((e)localObject).vtv = false;
      }
    }
    label148:
    this.vpH = false;
    localObject = this.vpF;
    if (localObject != null) {
      ((ImageView)localObject).setImageBitmap(null);
    }
    localObject = this.vpF;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.vpG;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.background.c)localObject).destroy();
    }
    this.vpG = null;
    AppMethodBeat.o(75862);
  }
  
  public final void oC(boolean paramBoolean)
  {
    AppMethodBeat.i(75860);
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("LogStory: playFakeLayer ");
    Object localObject1 = this.vpC;
    int i;
    if (localObject1 != null)
    {
      localObject1 = Long.valueOf(((acq)localObject1).timeStamp);
      ad.i((String)localObject2, localObject1);
      localObject1 = this.rdN;
      if (localObject1 != null) {
        ((v)localObject1).stop();
      }
      localObject1 = this.rdN;
      if (localObject1 != null) {
        ((v)localObject1).release();
      }
      if ((this.vpD != null) && (!paramBoolean)) {
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
      if ((localObject1 instanceof e)) {
        ((e)localObject1).resume();
      }
    }
    label174:
    if (this.vpI)
    {
      localObject1 = this.vpC;
      if (localObject1 != null)
      {
        localObject2 = this.vpG;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.recordvideo.background.c)localObject2).destroy();
        }
        localObject2 = this.vpF;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageBitmap(null);
        }
        localObject2 = f.vdH;
        localObject2 = getContext();
        k.g(localObject2, "context");
        this.vpG = f.a((acq)localObject1, (Context)localObject2, this.videoWidth, this.videoHeight, this.vpJ);
        localObject1 = this.vpG;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.recordvideo.background.c)localObject1).start();
          this.vpH = true;
          a((com.tencent.mm.plugin.recordvideo.background.c)localObject1);
          AppMethodBeat.o(75860);
          return;
        }
        AppMethodBeat.o(75860);
        return;
      }
    }
    AppMethodBeat.o(75860);
  }
  
  public final void setFakeVideoInfo(com.tencent.mm.plugin.recordvideo.background.d paramd)
  {
    boolean bool3 = true;
    AppMethodBeat.i(75858);
    k.h(paramd, "videoEditData");
    Object localObject1 = (a)new acq();
    Object localObject2 = paramd.field_baseItemData;
    acq localacq;
    try
    {
      ((a)localObject1).parseFrom((byte[])localObject2);
      localObject1 = (acq)localObject1;
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
        localacq = null;
      }
      this.videoWidth = paramd.field_targetWidth;
      this.videoHeight = paramd.field_targetHeight;
      this.vpJ = paramd.field_videoRotate;
      ad.i(this.TAG, "LogStory: setFakeVideoInfo " + localacq.timeStamp);
      this.vpC = localacq;
      if (this.vpF != null) {
        break label224;
      }
    }
    paramd = new ImageView(getContext());
    if ((this.vpJ == 90) || (this.vpJ == 270))
    {
      int i = this.videoHeight;
      this.videoHeight = this.videoWidth;
      this.videoWidth = i;
    }
    label224:
    boolean bool2;
    if (this.videoWidth > this.videoHeight)
    {
      paramd.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.vpF = paramd;
      removeAllViews();
      paramd = this.vpC;
      if (paramd == null) {
        break label511;
      }
      paramd = paramd.videoPath;
      if (paramd == null) {
        break label511;
      }
      localObject2 = com.tencent.mm.plugin.recordvideo.e.c.vtL;
      paramd = com.tencent.mm.plugin.recordvideo.e.c.alZ(paramd);
      if (paramd == null) {
        break label506;
      }
      bool1 = paramd.vtM;
      label265:
      if ((localacq.gBl) || (bool1)) {
        break label516;
      }
      bool2 = true;
      label280:
      this.vpI = bool2;
      ad.i(this.TAG, "useFakeImage:" + this.vpI + ", isCaptureVideo:" + localacq.gBl + ", matchScreenRatio:" + bool1);
      if (!this.vpI) {
        break label522;
      }
      addView((View)this.vpF, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      paramd = this.vpF;
      if (paramd != null) {
        paramd.setVisibility(0);
      }
      label381:
      if (localacq.gtC == null) {
        break label565;
      }
      paramd = new AudioCacheInfo();
      paramd.viz = localacq.viz;
      paramd.aMb = localacq.aMb;
      paramd.cachePath = localacq.gtC;
      paramd.musicUrl = localacq.musicUrl;
      this.vpD = paramd;
      label438:
      bool1 = bool3;
      if (localacq.gmX != 0) {
        if (localacq.gmX != 2) {
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
      this.vpE = bool1;
      this.startTime = localacq.startTime;
      this.fXw = localacq.endTime;
      this.vpH = false;
      AppMethodBeat.o(75858);
      return;
      paramd.setScaleType(ImageView.ScaleType.CENTER_CROP);
      break;
      label506:
      bool1 = false;
      break label265;
      label511:
      bool1 = false;
      break label265;
      bool2 = false;
      break label280;
      paramd = f.vdH;
      paramd = getContext();
      k.g(paramd, "context");
      f.a(localacq, paramd, (ViewGroup)this);
      paramd = this.vpF;
      if (paramd == null) {
        break label381;
      }
      paramd.setVisibility(8);
      break label381;
      this.vpD = null;
      break label438;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer$requestLoopFakeFrame$2$1"})
  static final class a
    implements Runnable
  {
    a(FakeVideoViewLayer paramFakeVideoViewLayer, com.tencent.mm.plugin.recordvideo.background.c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(75857);
      FakeVideoViewLayer.a(this.vpK, paramc);
      AppMethodBeat.o(75857);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer
 * JD-Core Version:    0.7.0.1
 */