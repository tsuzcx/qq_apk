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
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.e.e.a;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.k.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.n;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "backgrounndSilent", "", "exoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "fakeImageView", "Landroid/widget/ImageView;", "fakeMusicInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "fakeVideoInfo", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "loopingFrame", "startTime", "", "stopTime", "storyFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "useFakeImage", "videoHeight", "", "videoPlaying", "videoRotation", "videoWidth", "checkFakeVideoMatchScreenRatio", "isBackgroundSilent", "pauseFakeLayer", "", "playAudio", "playFakeLayer", "mute", "requestLoopFakeFrame", "frameRetriever", "setFakeVideoInfo", "videoEditData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "stopFakeLayer", "plugin-recordvideo_release"})
public final class FakeVideoViewLayer
  extends RelativeLayout
{
  private ajd HVf;
  private v HVg;
  private AudioCacheInfo HVh;
  public boolean HVi;
  private ImageView HVj;
  private com.tencent.mm.plugin.recordvideo.ui.editor.b.g HVk;
  private boolean HVl;
  private boolean HVm;
  private int HVn;
  private final String TAG;
  private long jWQ;
  private long startTime;
  private int videoHeight;
  private int videoWidth;
  
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
    AppMethodBeat.i(217370);
    if (!this.HVl)
    {
      Log.i(this.TAG, "requestLoopFakeFrame stop");
      AppMethodBeat.o(217370);
      return;
    }
    if ((p.h(paramg, this.HVk) ^ true))
    {
      Log.i(this.TAG, "requestLoopFakeFrame frameRetriever not match");
      AppMethodBeat.o(217370);
      return;
    }
    Object localObject = this.HVf;
    if (((localObject != null) && (((ajd)localObject).lfl == true)) || (!this.HVm))
    {
      Log.i(this.TAG, "requestLoopFakeFrame local capture video or not useFakeImage");
      AppMethodBeat.o(217370);
      return;
    }
    com.tencent.mm.plugin.recordvideo.ui.editor.b.a locala = paramg.cYc();
    ImageView localImageView = this.HVj;
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
      localObject = this.HVj;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      if (locala == null) {
        break label285;
      }
      localObject = Long.valueOf(locala.kST);
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
        localObject = this.HVj;
        if (localObject != null)
        {
          ((ImageView)localObject).postDelayed((Runnable)new a(this, paramg), l);
          AppMethodBeat.o(217370);
          return;
          localObject = null;
          break;
          label242:
          if ((1000L < l) || (!this.HVl) || (!p.h(paramg, this.HVk))) {
            break label180;
          }
          i = 1;
          break label182;
          label273:
          localObject = null;
          continue;
        }
        AppMethodBeat.o(217370);
        return;
      }
    }
    label285:
    AppMethodBeat.o(217370);
  }
  
  private final void playAudio()
  {
    AppMethodBeat.i(75863);
    Object localObject2 = new com.google.android.exoplayer2.g.c((f.a)new a.a((d)new com.google.android.exoplayer2.h.l()));
    Object localObject1 = x.i(getContext(), getContext().getString(b.h.app_name));
    this.HVg = com.google.android.exoplayer2.g.a(getContext(), (h)localObject2);
    try
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.model.audio.k.HMx;
      localObject2 = this.HVh;
      if (localObject2 == null) {
        p.iCn();
      }
      p.j(localObject1, "userAgent");
      localObject1 = new com.google.android.exoplayer2.source.e(k.a.a((AudioCacheInfo)localObject2, (String)localObject1), this.startTime, this.jWQ * 1000L);
      localObject2 = this.HVg;
      if (localObject2 != null) {
        ((v)localObject2).aM(true);
      }
      localObject2 = this.HVg;
      if (localObject2 != null) {
        ((v)localObject2).a((com.google.android.exoplayer2.source.k)localObject1);
      }
      localObject1 = this.HVg;
      if (localObject1 != null)
      {
        ((v)localObject1).L(2);
        AppMethodBeat.o(75863);
        return;
      }
      AppMethodBeat.o(75863);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(75863);
    }
  }
  
  public final void fxT()
  {
    AppMethodBeat.i(75861);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("LogStory: pauseFakeLayer ");
    Object localObject = this.HVf;
    int i;
    if (localObject != null)
    {
      localObject = Long.valueOf(((ajd)localObject).timeStamp);
      Log.i(str, localObject);
      localObject = this.HVg;
      if (localObject != null) {
        ((v)localObject).aM(false);
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
      if ((localObject instanceof n)) {
        ((n)localObject).IcL = false;
      }
    }
    label131:
    this.HVl = false;
    localObject = this.HVj;
    if (localObject != null) {
      ((ImageView)localObject).setImageBitmap(null);
    }
    localObject = this.HVj;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.HVk;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject).destroy();
    }
    this.HVk = null;
    AppMethodBeat.o(75861);
  }
  
  public final void fxU()
  {
    AppMethodBeat.i(75862);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("LogStory: stopFakeLayer ");
    Object localObject = this.HVf;
    int i;
    if (localObject != null)
    {
      localObject = Long.valueOf(((ajd)localObject).timeStamp);
      Log.i(str, localObject);
      localObject = this.HVg;
      if (localObject != null) {
        ((v)localObject).stop();
      }
      localObject = this.HVg;
      if (localObject != null) {
        ((v)localObject).release();
      }
      this.HVg = null;
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
      if ((localObject instanceof n)) {
        ((n)localObject).IcL = false;
      }
    }
    label148:
    this.HVl = false;
    localObject = this.HVj;
    if (localObject != null) {
      ((ImageView)localObject).setImageBitmap(null);
    }
    localObject = this.HVj;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.HVk;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject).destroy();
    }
    this.HVk = null;
    AppMethodBeat.o(75862);
  }
  
  public final void setFakeVideoInfo(com.tencent.mm.plugin.recordvideo.background.c paramc)
  {
    boolean bool3 = true;
    AppMethodBeat.i(75858);
    p.k(paramc, "videoEditData");
    Object localObject1 = (com.tencent.mm.cd.a)new ajd();
    Object localObject2 = paramc.field_baseItemData;
    ajd localajd;
    try
    {
      ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject2);
      localObject1 = (ajd)localObject1;
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
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        localajd = null;
      }
      this.videoWidth = paramc.field_targetWidth;
      this.videoHeight = paramc.field_targetHeight;
      this.HVn = paramc.field_videoRotate;
      Log.i(this.TAG, "LogStory: setFakeVideoInfo " + localajd.timeStamp);
      this.HVf = localajd;
      if (this.HVj != null) {
        break label224;
      }
    }
    paramc = new ImageView(getContext());
    if ((this.HVn == 90) || (this.HVn == 270))
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
      this.HVj = paramc;
      removeAllViews();
      paramc = this.HVf;
      if (paramc == null) {
        break label511;
      }
      paramc = paramc.videoPath;
      if (paramc == null) {
        break label511;
      }
      localObject2 = com.tencent.mm.plugin.recordvideo.e.e.Ife;
      paramc = com.tencent.mm.plugin.recordvideo.e.e.aWt(paramc);
      if (paramc == null) {
        break label506;
      }
      bool1 = paramc.Iff;
      label265:
      if ((localajd.lfl) || (bool1)) {
        break label516;
      }
      bool2 = true;
      label280:
      this.HVm = bool2;
      Log.i(this.TAG, "useFakeImage:" + this.HVm + ", isCaptureVideo:" + localajd.lfl + ", matchScreenRatio:" + bool1);
      if (!this.HVm) {
        break label522;
      }
      addView((View)this.HVj, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      paramc = this.HVj;
      if (paramc != null) {
        paramc.setVisibility(0);
      }
      label381:
      if (localajd.kXi == null) {
        break label565;
      }
      paramc = new AudioCacheInfo();
      paramc.HLC = localajd.HLC;
      paramc.aGs = localajd.aGs;
      paramc.cachePath = localajd.kXi;
      paramc.musicUrl = localajd.musicUrl;
      this.HVh = paramc;
      label438:
      bool1 = bool3;
      if (localajd.kRX != 0) {
        if (localajd.kRX != 2) {
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
      this.HVi = bool1;
      this.startTime = localajd.startTime;
      this.jWQ = localajd.endTime;
      this.HVl = false;
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
      paramc = com.tencent.mm.plugin.recordvideo.background.e.HGz;
      paramc = getContext();
      p.j(paramc, "context");
      com.tencent.mm.plugin.recordvideo.background.e.a(localajd, paramc, (ViewGroup)this);
      paramc = this.HVj;
      if (paramc == null) {
        break label381;
      }
      paramc.setVisibility(8);
      break label381;
      this.HVh = null;
      break label438;
    }
  }
  
  public final void wR(boolean paramBoolean)
  {
    AppMethodBeat.i(75860);
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("LogStory: playFakeLayer ");
    Object localObject1 = this.HVf;
    int i;
    if (localObject1 != null)
    {
      localObject1 = Long.valueOf(((ajd)localObject1).timeStamp);
      Log.i((String)localObject2, localObject1);
      localObject1 = this.HVg;
      if (localObject1 != null) {
        ((v)localObject1).stop();
      }
      localObject1 = this.HVg;
      if (localObject1 != null) {
        ((v)localObject1).release();
      }
      if ((this.HVh != null) && (!paramBoolean)) {
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
      if ((localObject1 instanceof n)) {
        ((n)localObject1).resume();
      }
    }
    label174:
    if (this.HVm)
    {
      localObject1 = this.HVf;
      if (localObject1 != null)
      {
        localObject2 = this.HVk;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject2).destroy();
        }
        localObject2 = this.HVj;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageBitmap(null);
        }
        localObject2 = com.tencent.mm.plugin.recordvideo.background.e.HGz;
        localObject2 = getContext();
        p.j(localObject2, "context");
        this.HVk = com.tencent.mm.plugin.recordvideo.background.e.a((ajd)localObject1, (Context)localObject2, this.videoWidth, this.videoHeight, this.HVn);
        localObject1 = this.HVk;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject1).start();
          this.HVl = true;
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer$requestLoopFakeFrame$2$1"})
  static final class a
    implements Runnable
  {
    a(FakeVideoViewLayer paramFakeVideoViewLayer, com.tencent.mm.plugin.recordvideo.ui.editor.b.g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(75857);
      FakeVideoViewLayer.a(this.HVo, paramg);
      AppMethodBeat.o(75857);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer
 * JD-Core Version:    0.7.0.1
 */