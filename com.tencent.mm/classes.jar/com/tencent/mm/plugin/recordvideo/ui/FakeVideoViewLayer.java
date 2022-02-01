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
import com.google.android.exoplayer2.h.l;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.k.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.n;
import com.tencent.mm.plugin.recordvideo.util.g.a;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "backgrounndSilent", "", "exoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "fakeImageView", "Landroid/widget/ImageView;", "fakeMusicInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "fakeVideoInfo", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "loopingFrame", "startTime", "", "stopTime", "storyFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "useFakeImage", "videoHeight", "", "videoPlaying", "videoRotation", "videoWidth", "checkFakeVideoMatchScreenRatio", "isBackgroundSilent", "pauseFakeLayer", "", "playAudio", "playFakeLayer", "mute", "requestLoopFakeFrame", "frameRetriever", "setFakeVideoInfo", "videoEditData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "stopFakeLayer", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FakeVideoViewLayer
  extends RelativeLayout
{
  private ami NRV;
  private v NRW;
  private AudioCacheInfo NRX;
  public boolean NRY;
  private ImageView NRZ;
  private com.tencent.mm.plugin.recordvideo.ui.editor.b.g NSa;
  private boolean NSb;
  private boolean NSc;
  private int NSd;
  private final String TAG;
  private long mwK;
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
  
  private static final void a(FakeVideoViewLayer paramFakeVideoViewLayer, com.tencent.mm.plugin.recordvideo.ui.editor.b.g paramg)
  {
    AppMethodBeat.i(279798);
    s.u(paramFakeVideoViewLayer, "this$0");
    s.u(paramg, "$frameRetriever");
    paramFakeVideoViewLayer.a(paramg);
    AppMethodBeat.o(279798);
  }
  
  private final void a(com.tencent.mm.plugin.recordvideo.ui.editor.b.g paramg)
  {
    AppMethodBeat.i(279784);
    if (!this.NSb)
    {
      Log.i(this.TAG, "requestLoopFakeFrame stop");
      AppMethodBeat.o(279784);
      return;
    }
    if (!s.p(paramg, this.NSa))
    {
      Log.i(this.TAG, "requestLoopFakeFrame frameRetriever not match");
      AppMethodBeat.o(279784);
      return;
    }
    Object localObject = this.NRV;
    if ((localObject != null) && (((ami)localObject).nJW == true)) {}
    for (int i = 1; (i != 0) || (!this.NSc); i = 0)
    {
      Log.i(this.TAG, "requestLoopFakeFrame local capture video or not useFakeImage");
      AppMethodBeat.o(279784);
      return;
    }
    com.tencent.mm.plugin.recordvideo.ui.editor.b.a locala = paramg.dEs();
    ImageView localImageView = this.NRZ;
    long l;
    if (localImageView != null)
    {
      if (locala == null)
      {
        localObject = null;
        localImageView.setImageBitmap((Bitmap)localObject);
      }
    }
    else
    {
      localObject = this.NRZ;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      if (locala != null)
      {
        localObject = Long.valueOf(locala.nyF);
        l = ((Number)localObject).longValue();
        if (1L > l) {
          break label285;
        }
        if (l > 1000L) {
          break label280;
        }
        i = 1;
        label195:
        if ((i == 0) || (!this.NSb) || (!s.p(paramg, this.NSa))) {
          break label290;
        }
        i = 1;
        label219:
        if (i == 0) {
          break label295;
        }
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        l = ((Number)localObject).longValue();
        localObject = this.NRZ;
        if (localObject != null) {
          ((ImageView)localObject).postDelayed(new FakeVideoViewLayer..ExternalSyntheticLambda0(this, paramg), l);
        }
      }
      AppMethodBeat.o(279784);
      return;
      localObject = locala.bitmap;
      break;
      label280:
      i = 0;
      break label195;
      label285:
      i = 0;
      break label195;
      label290:
      i = 0;
      break label219;
      label295:
      localObject = null;
    }
  }
  
  private final void playAudio()
  {
    AppMethodBeat.i(75863);
    Object localObject2 = new com.google.android.exoplayer2.g.c((f.a)new a.a((d)new l()));
    Object localObject1 = x.m(getContext(), getContext().getString(b.h.app_name));
    this.NRW = com.google.android.exoplayer2.g.a(getContext(), (h)localObject2);
    try
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.model.audio.k.NJr;
      localObject2 = this.NRX;
      s.checkNotNull(localObject2);
      s.s(localObject1, "userAgent");
      localObject1 = new com.google.android.exoplayer2.source.e(k.a.a((AudioCacheInfo)localObject2, (String)localObject1), this.startTime, this.mwK * 1000L);
      localObject2 = this.NRW;
      if (localObject2 != null) {
        ((v)localObject2).bv(true);
      }
      localObject2 = this.NRW;
      if (localObject2 != null) {
        ((v)localObject2).a((com.google.android.exoplayer2.source.k)localObject1);
      }
      localObject1 = this.NRW;
      if (localObject1 != null)
      {
        ((v)localObject1).J(2);
        AppMethodBeat.o(75863);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(75863);
    }
  }
  
  public final void Br(boolean paramBoolean)
  {
    AppMethodBeat.i(75860);
    Object localObject2 = this.TAG;
    Object localObject1 = this.NRV;
    int i;
    int k;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i((String)localObject2, s.X("LogStory: playFakeLayer ", localObject1));
      localObject1 = this.NRW;
      if (localObject1 != null) {
        ((v)localObject1).stop();
      }
      localObject1 = this.NRW;
      if (localObject1 != null) {
        ((v)localObject1).release();
      }
      if ((this.NRX != null) && (!paramBoolean)) {
        playAudio();
      }
      i = 0;
      k = getChildCount();
      if (k <= 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      localObject1 = getChildAt(i);
      if ((localObject1 instanceof MMAnimateView)) {
        ((MMAnimateView)localObject1).resume();
      }
      for (;;)
      {
        if (j < k) {
          break label290;
        }
        if (this.NSc)
        {
          localObject1 = this.NRV;
          if (localObject1 != null)
          {
            localObject2 = this.NSa;
            if (localObject2 != null) {
              ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject2).destroy();
            }
            localObject2 = this.NRZ;
            if (localObject2 != null) {
              ((ImageView)localObject2).setImageBitmap(null);
            }
            localObject2 = com.tencent.mm.plugin.recordvideo.background.e.NDU;
            localObject2 = getContext();
            s.s(localObject2, "context");
            this.NSa = com.tencent.mm.plugin.recordvideo.background.e.a((ami)localObject1, (Context)localObject2, this.videoWidth, this.videoHeight, this.NSd);
            localObject1 = this.NSa;
            if (localObject1 != null)
            {
              ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject1).start();
              this.NSb = true;
              a((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject1);
            }
          }
        }
        AppMethodBeat.o(75860);
        return;
        localObject1 = Long.valueOf(((ami)localObject1).timeStamp);
        break;
        if ((localObject1 instanceof n)) {
          ((n)localObject1).resume();
        }
      }
      label290:
      i = j;
    }
  }
  
  public final void gJG()
  {
    AppMethodBeat.i(75861);
    String str = this.TAG;
    Object localObject = this.NRV;
    int k;
    if (localObject == null)
    {
      localObject = null;
      Log.i(str, s.X("LogStory: pauseFakeLayer ", localObject));
      localObject = this.NRW;
      if (localObject != null) {
        ((v)localObject).bv(false);
      }
      k = getChildCount();
      if (k <= 0) {}
    }
    int j;
    label200:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      localObject = getChildAt(i);
      if ((localObject instanceof MMAnimateView)) {
        ((MMAnimateView)localObject).pause();
      }
      for (;;)
      {
        if (j < k) {
          break label200;
        }
        this.NSb = false;
        localObject = this.NRZ;
        if (localObject != null) {
          ((ImageView)localObject).setImageBitmap(null);
        }
        localObject = this.NRZ;
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(8);
        }
        localObject = this.NSa;
        if (localObject != null) {
          ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject).destroy();
        }
        this.NSa = null;
        AppMethodBeat.o(75861);
        return;
        localObject = Long.valueOf(((ami)localObject).timeStamp);
        break;
        if ((localObject instanceof n)) {
          ((n)localObject).NZh = false;
        }
      }
    }
  }
  
  public final void gJH()
  {
    AppMethodBeat.i(75862);
    String str = this.TAG;
    Object localObject = this.NRV;
    int k;
    if (localObject == null)
    {
      localObject = null;
      Log.i(str, s.X("LogStory: stopFakeLayer ", localObject));
      localObject = this.NRW;
      if (localObject != null) {
        ((v)localObject).stop();
      }
      localObject = this.NRW;
      if (localObject != null) {
        ((v)localObject).release();
      }
      this.NRW = null;
      k = getChildCount();
      if (k <= 0) {}
    }
    int j;
    label220:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      localObject = getChildAt(i);
      if ((localObject instanceof MMAnimateView)) {
        ((MMAnimateView)localObject).stop();
      }
      for (;;)
      {
        if (j < k) {
          break label220;
        }
        this.NSb = false;
        localObject = this.NRZ;
        if (localObject != null) {
          ((ImageView)localObject).setImageBitmap(null);
        }
        localObject = this.NRZ;
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(8);
        }
        localObject = this.NSa;
        if (localObject != null) {
          ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject).destroy();
        }
        this.NSa = null;
        AppMethodBeat.o(75862);
        return;
        localObject = Long.valueOf(((ami)localObject).timeStamp);
        break;
        if ((localObject instanceof n)) {
          ((n)localObject).NZh = false;
        }
      }
    }
  }
  
  public final void setFakeVideoInfo(com.tencent.mm.plugin.recordvideo.background.c paramc)
  {
    boolean bool3 = true;
    AppMethodBeat.i(75858);
    s.u(paramc, "videoEditData");
    Object localObject1 = (com.tencent.mm.bx.a)new ami();
    Object localObject2 = paramc.field_baseItemData;
    ami localami;
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject2);
      localObject1 = (ami)localObject1;
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
        localami = null;
      }
      this.videoWidth = paramc.field_targetWidth;
      this.videoHeight = paramc.field_targetHeight;
      this.NSd = paramc.field_videoRotate;
      Log.i(this.TAG, s.X("LogStory: setFakeVideoInfo ", Long.valueOf(localami.timeStamp)));
      this.NRV = localami;
      if (this.NRZ != null) {
        break label222;
      }
    }
    paramc = new ImageView(getContext());
    if ((this.NSd == 90) || (this.NSd == 270))
    {
      int i = this.videoHeight;
      this.videoHeight = this.videoWidth;
      this.videoWidth = i;
    }
    label222:
    boolean bool2;
    if (this.videoWidth > this.videoHeight)
    {
      paramc.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localObject2 = ah.aiuX;
      this.NRZ = paramc;
      removeAllViews();
      paramc = this.NRV;
      if (paramc == null) {
        break label504;
      }
      paramc = paramc.videoPath;
      if (paramc == null) {
        break label504;
      }
      localObject2 = com.tencent.mm.plugin.recordvideo.util.g.Obu;
      paramc = com.tencent.mm.plugin.recordvideo.util.g.aTF(paramc);
      if (paramc == null) {
        break label504;
      }
      bool1 = paramc.Obv;
      label263:
      if ((localami.nJW) || (bool1)) {
        break label509;
      }
      bool2 = true;
      label278:
      this.NSc = bool2;
      Log.i(this.TAG, "useFakeImage:" + this.NSc + ", isCaptureVideo:" + localami.nJW + ", matchScreenRatio:" + bool1);
      if (!this.NSc) {
        break label515;
      }
      addView((View)this.NRZ, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      paramc = this.NRZ;
      if (paramc != null) {
        paramc.setVisibility(0);
      }
      label379:
      if (localami.nBT == null) {
        break label558;
      }
      paramc = new AudioCacheInfo();
      paramc.NID = localami.NID;
      paramc.cached = localami.cached;
      paramc.cachePath = localami.nBT;
      paramc.musicUrl = localami.musicUrl;
      this.NRX = paramc;
      label436:
      bool1 = bool3;
      if (localami.nxj != 0) {
        if (localami.nxj != 2) {
          break label566;
        }
      }
    }
    label515:
    label558:
    label566:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      this.NRY = bool1;
      this.startTime = localami.startTime;
      this.mwK = localami.endTime;
      this.NSb = false;
      AppMethodBeat.o(75858);
      return;
      paramc.setScaleType(ImageView.ScaleType.CENTER_CROP);
      break;
      label504:
      bool1 = false;
      break label263;
      label509:
      bool2 = false;
      break label278;
      paramc = com.tencent.mm.plugin.recordvideo.background.e.NDU;
      paramc = getContext();
      s.s(paramc, "context");
      com.tencent.mm.plugin.recordvideo.background.e.a(localami, paramc, (ViewGroup)this);
      paramc = this.NRZ;
      if (paramc == null) {
        break label379;
      }
      paramc.setVisibility(8);
      break label379;
      this.NRX = null;
      break label436;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer
 * JD-Core Version:    0.7.0.1
 */