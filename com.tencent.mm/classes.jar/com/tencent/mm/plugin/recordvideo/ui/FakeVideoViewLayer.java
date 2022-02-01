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
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.recordvideo.e.c.a;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.i.a;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "backgrounndSilent", "", "exoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "fakeImageView", "Landroid/widget/ImageView;", "fakeMusicInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "fakeVideoInfo", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "loopingFrame", "startTime", "", "stopTime", "storyFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/background/StoryFrameRetriever;", "useFakeImage", "videoHeight", "", "videoPlaying", "videoRotation", "videoWidth", "checkFakeVideoMatchScreenRatio", "isBackgroundSilent", "pauseFakeLayer", "", "playAudio", "playFakeLayer", "mute", "requestLoopFakeFrame", "frameRetriever", "setFakeVideoInfo", "videoEditData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "stopFakeLayer", "plugin-recordvideo_release"})
public final class FakeVideoViewLayer
  extends RelativeLayout
{
  private final String TAG;
  private long gcd;
  private long startTime;
  private int videoHeight;
  private int videoWidth;
  private v wvs;
  private int wyA;
  private adp wyt;
  private AudioCacheInfo wyu;
  public boolean wyv;
  private ImageView wyw;
  private com.tencent.mm.plugin.recordvideo.background.d wyx;
  private boolean wyy;
  private boolean wyz;
  
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
  
  private final void a(final com.tencent.mm.plugin.recordvideo.background.d paramd)
  {
    AppMethodBeat.i(75859);
    if (!this.wyy)
    {
      ac.i(this.TAG, "requestLoopFakeFrame stop");
      AppMethodBeat.o(75859);
      return;
    }
    if ((k.g(paramd, this.wyx) ^ true))
    {
      ac.i(this.TAG, "requestLoopFakeFrame frameRetriever not match");
      AppMethodBeat.o(75859);
      return;
    }
    Object localObject = this.wyt;
    if (((localObject != null) && (((adp)localObject).hbH == true)) || (!this.wyz))
    {
      ac.i(this.TAG, "requestLoopFakeFrame local capture video or not useFakeImage");
      AppMethodBeat.o(75859);
      return;
    }
    com.tencent.mm.media.g.c localc = paramd.aqZ();
    ImageView localImageView = this.wyw;
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
      localObject = this.wyw;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      if (localc == null) {
        break label285;
      }
      localObject = Long.valueOf(localc.gSx);
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
        localObject = this.wyw;
        if (localObject != null)
        {
          ((ImageView)localObject).postDelayed((Runnable)new a(this, paramd), l);
          AppMethodBeat.o(75859);
          return;
          localObject = null;
          break;
          label242:
          if ((1000L < l) || (!this.wyy) || (!k.g(paramd, this.wyx))) {
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
    this.wvs = com.google.android.exoplayer2.g.a(getContext(), (h)localObject2);
    try
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.model.audio.i.wrV;
      localObject2 = this.wyu;
      if (localObject2 == null) {
        k.fOy();
      }
      k.g(localObject1, "userAgent");
      localObject1 = new com.google.android.exoplayer2.source.d(i.a.a((AudioCacheInfo)localObject2, (String)localObject1), this.startTime, this.gcd * 1000L);
      localObject2 = this.wvs;
      if (localObject2 != null) {
        ((v)localObject2).aO(true);
      }
      localObject2 = this.wvs;
      if (localObject2 != null) {
        ((v)localObject2).a((com.google.android.exoplayer2.source.i)localObject1);
      }
      localObject1 = this.wvs;
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
      ac.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(75863);
    }
  }
  
  public final void dwy()
  {
    AppMethodBeat.i(75861);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("LogStory: pauseFakeLayer ");
    Object localObject = this.wyt;
    int i;
    if (localObject != null)
    {
      localObject = Long.valueOf(((adp)localObject).timeStamp);
      ac.i(str, localObject);
      localObject = this.wvs;
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
      if ((localObject instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.e)) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)localObject).wDv = false;
      }
    }
    label131:
    this.wyy = false;
    localObject = this.wyw;
    if (localObject != null) {
      ((ImageView)localObject).setImageBitmap(null);
    }
    localObject = this.wyw;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.wyx;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.background.d)localObject).destroy();
    }
    this.wyx = null;
    AppMethodBeat.o(75861);
  }
  
  public final void dwz()
  {
    AppMethodBeat.i(75862);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("LogStory: stopFakeLayer ");
    Object localObject = this.wyt;
    int i;
    if (localObject != null)
    {
      localObject = Long.valueOf(((adp)localObject).timeStamp);
      ac.i(str, localObject);
      localObject = this.wvs;
      if (localObject != null) {
        ((v)localObject).stop();
      }
      localObject = this.wvs;
      if (localObject != null) {
        ((v)localObject).release();
      }
      this.wvs = null;
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
      if ((localObject instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.e)) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)localObject).wDv = false;
      }
    }
    label148:
    this.wyy = false;
    localObject = this.wyw;
    if (localObject != null) {
      ((ImageView)localObject).setImageBitmap(null);
    }
    localObject = this.wyw;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.wyx;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.background.d)localObject).destroy();
    }
    this.wyx = null;
    AppMethodBeat.o(75862);
  }
  
  public final void pA(boolean paramBoolean)
  {
    AppMethodBeat.i(75860);
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("LogStory: playFakeLayer ");
    Object localObject1 = this.wyt;
    int i;
    if (localObject1 != null)
    {
      localObject1 = Long.valueOf(((adp)localObject1).timeStamp);
      ac.i((String)localObject2, localObject1);
      localObject1 = this.wvs;
      if (localObject1 != null) {
        ((v)localObject1).stop();
      }
      localObject1 = this.wvs;
      if (localObject1 != null) {
        ((v)localObject1).release();
      }
      if ((this.wyu != null) && (!paramBoolean)) {
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
      if ((localObject1 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.e)) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.e)localObject1).resume();
      }
    }
    label174:
    if (this.wyz)
    {
      localObject1 = this.wyt;
      if (localObject1 != null)
      {
        localObject2 = this.wyx;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.recordvideo.background.d)localObject2).destroy();
        }
        localObject2 = this.wyw;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageBitmap(null);
        }
        localObject2 = com.tencent.mm.plugin.recordvideo.background.g.wmx;
        localObject2 = getContext();
        k.g(localObject2, "context");
        this.wyx = com.tencent.mm.plugin.recordvideo.background.g.a((adp)localObject1, (Context)localObject2, this.videoWidth, this.videoHeight, this.wyA);
        localObject1 = this.wyx;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.recordvideo.background.d)localObject1).start();
          this.wyy = true;
          a((com.tencent.mm.plugin.recordvideo.background.d)localObject1);
          AppMethodBeat.o(75860);
          return;
        }
        AppMethodBeat.o(75860);
        return;
      }
    }
    AppMethodBeat.o(75860);
  }
  
  public final void setFakeVideoInfo(com.tencent.mm.plugin.recordvideo.background.e parame)
  {
    boolean bool3 = true;
    AppMethodBeat.i(75858);
    k.h(parame, "videoEditData");
    Object localObject1 = (a)new adp();
    Object localObject2 = parame.field_baseItemData;
    adp localadp;
    try
    {
      ((a)localObject1).parseFrom((byte[])localObject2);
      localObject1 = (adp)localObject1;
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
        ac.l("safeParser", "", new Object[] { localException });
        localadp = null;
      }
      this.videoWidth = parame.field_targetWidth;
      this.videoHeight = parame.field_targetHeight;
      this.wyA = parame.field_videoRotate;
      ac.i(this.TAG, "LogStory: setFakeVideoInfo " + localadp.timeStamp);
      this.wyt = localadp;
      if (this.wyw != null) {
        break label224;
      }
    }
    parame = new ImageView(getContext());
    if ((this.wyA == 90) || (this.wyA == 270))
    {
      int i = this.videoHeight;
      this.videoHeight = this.videoWidth;
      this.videoWidth = i;
    }
    label224:
    boolean bool2;
    if (this.videoWidth > this.videoHeight)
    {
      parame.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.wyw = parame;
      removeAllViews();
      parame = this.wyt;
      if (parame == null) {
        break label511;
      }
      parame = parame.videoPath;
      if (parame == null) {
        break label511;
      }
      localObject2 = com.tencent.mm.plugin.recordvideo.e.c.wDO;
      parame = com.tencent.mm.plugin.recordvideo.e.c.arc(parame);
      if (parame == null) {
        break label506;
      }
      bool1 = parame.wDP;
      label265:
      if ((localadp.hbH) || (bool1)) {
        break label516;
      }
      bool2 = true;
      label280:
      this.wyz = bool2;
      ac.i(this.TAG, "useFakeImage:" + this.wyz + ", isCaptureVideo:" + localadp.hbH + ", matchScreenRatio:" + bool1);
      if (!this.wyz) {
        break label522;
      }
      addView((View)this.wyw, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      parame = this.wyw;
      if (parame != null) {
        parame.setVisibility(0);
      }
      label381:
      if (localadp.gUk == null) {
        break label565;
      }
      parame = new AudioCacheInfo();
      parame.wri = localadp.wri;
      parame.aMR = localadp.aMR;
      parame.cachePath = localadp.gUk;
      parame.musicUrl = localadp.musicUrl;
      this.wyu = parame;
      label438:
      bool1 = bool3;
      if (localadp.gNK != 0) {
        if (localadp.gNK != 2) {
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
      this.wyv = bool1;
      this.startTime = localadp.startTime;
      this.gcd = localadp.endTime;
      this.wyy = false;
      AppMethodBeat.o(75858);
      return;
      parame.setScaleType(ImageView.ScaleType.CENTER_CROP);
      break;
      label506:
      bool1 = false;
      break label265;
      label511:
      bool1 = false;
      break label265;
      bool2 = false;
      break label280;
      parame = com.tencent.mm.plugin.recordvideo.background.g.wmx;
      parame = getContext();
      k.g(parame, "context");
      com.tencent.mm.plugin.recordvideo.background.g.a(localadp, parame, (ViewGroup)this);
      parame = this.wyw;
      if (parame == null) {
        break label381;
      }
      parame.setVisibility(8);
      break label381;
      this.wyu = null;
      break label438;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer$requestLoopFakeFrame$2$1"})
  static final class a
    implements Runnable
  {
    a(FakeVideoViewLayer paramFakeVideoViewLayer, com.tencent.mm.plugin.recordvideo.background.d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(75857);
      FakeVideoViewLayer.a(this.wyB, paramd);
      AppMethodBeat.o(75857);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer
 * JD-Core Version:    0.7.0.1
 */