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
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.recordvideo.e.d.a;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.i;
import com.tencent.mm.plugin.recordvideo.model.audio.i.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.m;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "backgrounndSilent", "", "exoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "fakeImageView", "Landroid/widget/ImageView;", "fakeMusicInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "fakeVideoInfo", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "loopingFrame", "startTime", "", "stopTime", "storyFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "useFakeImage", "videoHeight", "", "videoPlaying", "videoRotation", "videoWidth", "checkFakeVideoMatchScreenRatio", "isBackgroundSilent", "pauseFakeLayer", "", "playAudio", "playFakeLayer", "mute", "requestLoopFakeFrame", "frameRetriever", "setFakeVideoInfo", "videoEditData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "stopFakeLayer", "plugin-recordvideo_release"})
public final class FakeVideoViewLayer
  extends RelativeLayout
{
  private v BTI;
  private aio BYr;
  private AudioCacheInfo BYs;
  public boolean BYt;
  private ImageView BYu;
  private com.tencent.mm.plugin.recordvideo.ui.editor.b.g BYv;
  private boolean BYw;
  private boolean BYx;
  private int BYy;
  private final String TAG;
  private long hlh;
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
    AppMethodBeat.i(237510);
    if (!this.BYw)
    {
      Log.i(this.TAG, "requestLoopFakeFrame stop");
      AppMethodBeat.o(237510);
      return;
    }
    if ((p.j(paramg, this.BYv) ^ true))
    {
      Log.i(this.TAG, "requestLoopFakeFrame frameRetriever not match");
      AppMethodBeat.o(237510);
      return;
    }
    Object localObject = this.BYr;
    if (((localObject != null) && (((aio)localObject).iqf == true)) || (!this.BYx))
    {
      Log.i(this.TAG, "requestLoopFakeFrame local capture video or not useFakeImage");
      AppMethodBeat.o(237510);
      return;
    }
    com.tencent.mm.plugin.recordvideo.ui.editor.b.a locala = paramg.cJu();
    ImageView localImageView = this.BYu;
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
      localObject = this.BYu;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      if (locala == null) {
        break label285;
      }
      localObject = Long.valueOf(locala.CgA);
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
        localObject = this.BYu;
        if (localObject != null)
        {
          ((ImageView)localObject).postDelayed((Runnable)new a(this, paramg), l);
          AppMethodBeat.o(237510);
          return;
          localObject = null;
          break;
          label242:
          if ((1000L < l) || (!this.BYw) || (!p.j(paramg, this.BYv))) {
            break label180;
          }
          i = 1;
          break label182;
          label273:
          localObject = null;
          continue;
        }
        AppMethodBeat.o(237510);
        return;
      }
    }
    label285:
    AppMethodBeat.o(237510);
  }
  
  private final void playAudio()
  {
    AppMethodBeat.i(75863);
    Object localObject2 = new com.google.android.exoplayer2.g.c((f.a)new a.a((com.google.android.exoplayer2.h.d)new com.google.android.exoplayer2.h.l()));
    Object localObject1 = x.h(getContext(), getContext().getString(2131755908));
    this.BTI = com.google.android.exoplayer2.g.a(getContext(), (h)localObject2);
    try
    {
      localObject2 = i.BPL;
      localObject2 = this.BYs;
      if (localObject2 == null) {
        p.hyc();
      }
      p.g(localObject1, "userAgent");
      localObject1 = new com.google.android.exoplayer2.source.e(i.a.a((AudioCacheInfo)localObject2, (String)localObject1), this.startTime, this.hlh * 1000L);
      localObject2 = this.BTI;
      if (localObject2 != null) {
        ((v)localObject2).aO(true);
      }
      localObject2 = this.BTI;
      if (localObject2 != null) {
        ((v)localObject2).a((k)localObject1);
      }
      localObject1 = this.BTI;
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
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(75863);
    }
  }
  
  public final void eLA()
  {
    AppMethodBeat.i(75861);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("LogStory: pauseFakeLayer ");
    Object localObject = this.BYr;
    int i;
    if (localObject != null)
    {
      localObject = Long.valueOf(((aio)localObject).timeStamp);
      Log.i(str, localObject);
      localObject = this.BTI;
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
      if ((localObject instanceof m)) {
        ((m)localObject).CfV = false;
      }
    }
    label131:
    this.BYw = false;
    localObject = this.BYu;
    if (localObject != null) {
      ((ImageView)localObject).setImageBitmap(null);
    }
    localObject = this.BYu;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.BYv;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject).destroy();
    }
    this.BYv = null;
    AppMethodBeat.o(75861);
  }
  
  public final void eLB()
  {
    AppMethodBeat.i(75862);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("LogStory: stopFakeLayer ");
    Object localObject = this.BYr;
    int i;
    if (localObject != null)
    {
      localObject = Long.valueOf(((aio)localObject).timeStamp);
      Log.i(str, localObject);
      localObject = this.BTI;
      if (localObject != null) {
        ((v)localObject).stop();
      }
      localObject = this.BTI;
      if (localObject != null) {
        ((v)localObject).release();
      }
      this.BTI = null;
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
        ((m)localObject).CfV = false;
      }
    }
    label148:
    this.BYw = false;
    localObject = this.BYu;
    if (localObject != null) {
      ((ImageView)localObject).setImageBitmap(null);
    }
    localObject = this.BYu;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.BYv;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject).destroy();
    }
    this.BYv = null;
    AppMethodBeat.o(75862);
  }
  
  public final void setFakeVideoInfo(com.tencent.mm.plugin.recordvideo.background.c paramc)
  {
    boolean bool3 = true;
    AppMethodBeat.i(75858);
    p.h(paramc, "videoEditData");
    Object localObject1 = (com.tencent.mm.bw.a)new aio();
    Object localObject2 = paramc.field_baseItemData;
    aio localaio;
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject2);
      localObject1 = (aio)localObject1;
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
        localaio = null;
      }
      this.videoWidth = paramc.field_targetWidth;
      this.videoHeight = paramc.field_targetHeight;
      this.BYy = paramc.field_videoRotate;
      Log.i(this.TAG, "LogStory: setFakeVideoInfo " + localaio.timeStamp);
      this.BYr = localaio;
      if (this.BYu != null) {
        break label224;
      }
    }
    paramc = new ImageView(getContext());
    if ((this.BYy == 90) || (this.BYy == 270))
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
      this.BYu = paramc;
      removeAllViews();
      paramc = this.BYr;
      if (paramc == null) {
        break label511;
      }
      paramc = paramc.videoPath;
      if (paramc == null) {
        break label511;
      }
      localObject2 = com.tencent.mm.plugin.recordvideo.e.d.Cin;
      paramc = com.tencent.mm.plugin.recordvideo.e.d.aLQ(paramc);
      if (paramc == null) {
        break label506;
      }
      bool1 = paramc.Cio;
      label265:
      if ((localaio.iqf) || (bool1)) {
        break label516;
      }
      bool2 = true;
      label280:
      this.BYx = bool2;
      Log.i(this.TAG, "useFakeImage:" + this.BYx + ", isCaptureVideo:" + localaio.iqf + ", matchScreenRatio:" + bool1);
      if (!this.BYx) {
        break label522;
      }
      addView((View)this.BYu, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      paramc = this.BYu;
      if (paramc != null) {
        paramc.setVisibility(0);
      }
      label381:
      if (localaio.iiv == null) {
        break label565;
      }
      paramc = new AudioCacheInfo();
      paramc.BOX = localaio.BOX;
      paramc.aXa = localaio.aXa;
      paramc.cachePath = localaio.iiv;
      paramc.musicUrl = localaio.musicUrl;
      this.BYs = paramc;
      label438:
      bool1 = bool3;
      if (localaio.idq != 0) {
        if (localaio.idq != 2) {
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
      this.BYt = bool1;
      this.startTime = localaio.startTime;
      this.hlh = localaio.endTime;
      this.BYw = false;
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
      paramc = com.tencent.mm.plugin.recordvideo.background.e.BKp;
      paramc = getContext();
      p.g(paramc, "context");
      com.tencent.mm.plugin.recordvideo.background.e.a(localaio, paramc, (ViewGroup)this);
      paramc = this.BYu;
      if (paramc == null) {
        break label381;
      }
      paramc.setVisibility(8);
      break label381;
      this.BYs = null;
      break label438;
    }
  }
  
  public final void tv(boolean paramBoolean)
  {
    AppMethodBeat.i(75860);
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("LogStory: playFakeLayer ");
    Object localObject1 = this.BYr;
    int i;
    if (localObject1 != null)
    {
      localObject1 = Long.valueOf(((aio)localObject1).timeStamp);
      Log.i((String)localObject2, localObject1);
      localObject1 = this.BTI;
      if (localObject1 != null) {
        ((v)localObject1).stop();
      }
      localObject1 = this.BTI;
      if (localObject1 != null) {
        ((v)localObject1).release();
      }
      if ((this.BYs != null) && (!paramBoolean)) {
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
    if (this.BYx)
    {
      localObject1 = this.BYr;
      if (localObject1 != null)
      {
        localObject2 = this.BYv;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject2).destroy();
        }
        localObject2 = this.BYu;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageBitmap(null);
        }
        localObject2 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
        localObject2 = getContext();
        p.g(localObject2, "context");
        this.BYv = com.tencent.mm.plugin.recordvideo.background.e.a((aio)localObject1, (Context)localObject2, this.videoWidth, this.videoHeight, this.BYy);
        localObject1 = this.BYv;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject1).start();
          this.BYw = true;
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer$requestLoopFakeFrame$2$1"})
  static final class a
    implements Runnable
  {
    a(FakeVideoViewLayer paramFakeVideoViewLayer, com.tencent.mm.plugin.recordvideo.ui.editor.b.g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(75857);
      FakeVideoViewLayer.a(this.BYz, paramg);
      AppMethodBeat.o(75857);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer
 * JD-Core Version:    0.7.0.1
 */