package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
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
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.story.e.c.a;
import com.tencent.mm.plugin.story.e.c.a.a;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.story.model.audio.i.a;
import com.tencent.mm.plugin.story.model.e.a;
import com.tencent.mm.protocal.protobuf.chf;
import com.tencent.mm.sdk.platformtools.ab;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewFakeLayer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "backgrounndSilent", "", "exoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "fakeImageView", "Landroid/widget/ImageView;", "fakeMusicInfo", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "fakeVideoInfo", "Lcom/tencent/mm/protocal/protobuf/StoryEditorProtoData;", "loopingFrame", "startTime", "", "stopTime", "storyFrameRetriever", "Lcom/tencent/mm/plugin/story/model/mix/StoryFrameRetriever;", "useFakeImage", "videoPlaying", "checkFakeVideoMatchScreenRatio", "isBackgroundSilent", "pauseFakeLayer", "", "playAudio", "playFakeLayer", "mute", "requestLoopFakeFrame", "frameRetriever", "setFakeVideoInfo", "stopFakeLayer", "plugin-story_release"})
public final class StoryVideoViewFakeLayer
  extends RelativeLayout
{
  private final String TAG;
  private long eBT;
  private v qdF;
  private chf sVj;
  private AudioCacheInfo sVk;
  boolean sVl;
  private ImageView sVm;
  private a sVn;
  private boolean sVo;
  private boolean sVp;
  private long startTime;
  
  public StoryVideoViewFakeLayer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(110960);
    this.TAG = "MicroMsg.StoryVideoViewFakeLayer";
    AppMethodBeat.o(110960);
  }
  
  public StoryVideoViewFakeLayer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(151348);
    this.TAG = "MicroMsg.StoryVideoViewFakeLayer";
    AppMethodBeat.o(151348);
  }
  
  private final void a(a parama)
  {
    AppMethodBeat.i(110955);
    if (!this.sVo)
    {
      ab.i(this.TAG, "requestLoopFakeFrame stop");
      AppMethodBeat.o(110955);
      return;
    }
    if ((j.e(parama, this.sVn) ^ true))
    {
      ab.i(this.TAG, "requestLoopFakeFrame frameRetriever not match");
      AppMethodBeat.o(110955);
      return;
    }
    Object localObject = this.sVj;
    if (((localObject != null) && (((chf)localObject).fbp == true)) || (!this.sVp))
    {
      ab.i(this.TAG, "requestLoopFakeFrame local capture video or not useFakeImage");
      AppMethodBeat.o(110955);
      return;
    }
    com.tencent.mm.media.f.c localc = parama.UX();
    ImageView localImageView = this.sVm;
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
      localObject = this.sVm;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      if (localc == null) {
        break label285;
      }
      localObject = Long.valueOf(localc.eVx);
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
        localObject = this.sVm;
        if (localObject != null)
        {
          ((ImageView)localObject).postDelayed((Runnable)new StoryVideoViewFakeLayer.a(this, parama), l);
          AppMethodBeat.o(110955);
          return;
          localObject = null;
          break;
          label242:
          if ((1000L < l) || (!this.sVo) || (!j.e(parama, this.sVn))) {
            break label180;
          }
          i = 1;
          break label182;
          label273:
          localObject = null;
          continue;
        }
        AppMethodBeat.o(110955);
        return;
      }
    }
    label285:
    AppMethodBeat.o(110955);
  }
  
  private final void playAudio()
  {
    AppMethodBeat.i(110959);
    Object localObject2 = new com.google.android.exoplayer2.g.c((f.a)new a.a((com.google.android.exoplayer2.h.d)new com.google.android.exoplayer2.h.l()));
    Object localObject1 = x.i(getContext(), getContext().getString(2131297005));
    this.qdF = g.a(getContext(), (h)localObject2);
    try
    {
      localObject2 = com.tencent.mm.plugin.story.model.audio.i.swW;
      localObject2 = this.sVk;
      if (localObject2 == null) {
        j.ebi();
      }
      j.p(localObject1, "userAgent");
      localObject1 = new com.google.android.exoplayer2.source.d(i.a.a((AudioCacheInfo)localObject2, (String)localObject1), this.startTime, this.eBT * 1000L);
      localObject2 = this.qdF;
      if (localObject2 != null) {
        ((v)localObject2).aC(true);
      }
      localObject2 = this.qdF;
      if (localObject2 != null) {
        ((v)localObject2).a((com.google.android.exoplayer2.source.i)localObject1);
      }
      localObject1 = this.qdF;
      if (localObject1 != null)
      {
        ((v)localObject1).setRepeatMode(2);
        AppMethodBeat.o(110959);
        return;
      }
      AppMethodBeat.o(110959);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(110959);
    }
  }
  
  public final void cGw()
  {
    AppMethodBeat.i(110957);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("LogStory: pauseFakeLayer ");
    Object localObject = this.sVj;
    int i;
    if (localObject != null)
    {
      localObject = Long.valueOf(((chf)localObject).timeStamp);
      ab.i(str, localObject);
      localObject = this.qdF;
      if (localObject != null) {
        ((v)localObject).aC(false);
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
      if ((localObject instanceof com.tencent.mm.plugin.story.ui.view.editor.item.d)) {
        ((com.tencent.mm.plugin.story.ui.view.editor.item.d)localObject).sRd = false;
      }
    }
    label131:
    this.sVo = false;
    localObject = this.sVm;
    if (localObject != null) {
      ((ImageView)localObject).setImageBitmap(null);
    }
    localObject = this.sVm;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.sVn;
    if (localObject != null) {
      ((a)localObject).destroy();
    }
    this.sVn = null;
    AppMethodBeat.o(110957);
  }
  
  public final void cGx()
  {
    AppMethodBeat.i(110958);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("LogStory: stopFakeLayer ");
    Object localObject = this.sVj;
    int i;
    if (localObject != null)
    {
      localObject = Long.valueOf(((chf)localObject).timeStamp);
      ab.i(str, localObject);
      localObject = this.qdF;
      if (localObject != null) {
        ((v)localObject).stop();
      }
      localObject = this.qdF;
      if (localObject != null) {
        ((v)localObject).release();
      }
      this.qdF = null;
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
      if ((localObject instanceof com.tencent.mm.plugin.story.ui.view.editor.item.d)) {
        ((com.tencent.mm.plugin.story.ui.view.editor.item.d)localObject).sRd = false;
      }
    }
    label148:
    this.sVo = false;
    localObject = this.sVm;
    if (localObject != null) {
      ((ImageView)localObject).setImageBitmap(null);
    }
    localObject = this.sVm;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.sVn;
    if (localObject != null) {
      ((a)localObject).destroy();
    }
    this.sVn = null;
    AppMethodBeat.o(110958);
  }
  
  public final void mu(boolean paramBoolean)
  {
    AppMethodBeat.i(110956);
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("LogStory: playFakeLayer ");
    Object localObject1 = this.sVj;
    int i;
    if (localObject1 != null)
    {
      localObject1 = Long.valueOf(((chf)localObject1).timeStamp);
      ab.i((String)localObject2, localObject1);
      localObject1 = this.qdF;
      if (localObject1 != null) {
        ((v)localObject1).stop();
      }
      localObject1 = this.qdF;
      if (localObject1 != null) {
        ((v)localObject1).release();
      }
      if ((this.sVk != null) && (!paramBoolean)) {
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
      if ((localObject1 instanceof com.tencent.mm.plugin.story.ui.view.editor.item.d)) {
        ((com.tencent.mm.plugin.story.ui.view.editor.item.d)localObject1).resume();
      }
    }
    label174:
    if (this.sVp)
    {
      localObject1 = this.sVj;
      if (localObject1 != null)
      {
        localObject2 = this.sVn;
        if (localObject2 != null) {
          ((a)localObject2).destroy();
        }
        localObject2 = this.sVm;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageBitmap(null);
        }
        localObject2 = k.sCp;
        localObject2 = getContext();
        j.p(localObject2, "context");
        this.sVn = k.b((chf)localObject1, (Context)localObject2);
        localObject1 = this.sVn;
        if (localObject1 != null)
        {
          ((a)localObject1).start();
          this.sVo = true;
          a((a)localObject1);
          AppMethodBeat.o(110956);
          return;
        }
        AppMethodBeat.o(110956);
        return;
      }
    }
    AppMethodBeat.o(110956);
  }
  
  public final void setFakeVideoInfo(chf paramchf)
  {
    boolean bool3 = true;
    AppMethodBeat.i(110954);
    j.q(paramchf, "fakeVideoInfo");
    ab.i(this.TAG, "LogStory: setFakeVideoInfo " + paramchf.timeStamp);
    this.sVj = paramchf;
    if (this.sVm == null)
    {
      localObject = new ImageView(getContext());
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.sVm = ((ImageView)localObject);
    }
    removeAllViews();
    Object localObject = this.sVj;
    boolean bool2;
    if (localObject != null)
    {
      localObject = ((chf)localObject).videoPath;
      if (localObject != null)
      {
        c.a locala = com.tencent.mm.plugin.story.e.c.ssB;
        localObject = c.a.acN((String)localObject);
        if (localObject != null)
        {
          bool1 = ((c.a.a)localObject).ssC;
          if ((paramchf.fbp) || (bool1)) {
            break label369;
          }
          bool2 = true;
          label145:
          this.sVp = bool2;
          ab.i(this.TAG, "useFakeImage:" + this.sVp + ", isCaptureVideo:" + paramchf.fbp + ", matchScreenRatio:" + bool1);
          if (!this.sVp) {
            break label374;
          }
          addView((View)this.sVm, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
          localObject = this.sVm;
          if (localObject != null) {
            ((ImageView)localObject).setVisibility(0);
          }
          label247:
          if (paramchf.eXm == null) {
            break label423;
          }
          localObject = new AudioCacheInfo();
          ((AudioCacheInfo)localObject).swp = paramchf.swp;
          ((AudioCacheInfo)localObject).arq = paramchf.arq;
          ((AudioCacheInfo)localObject).cachePath = paramchf.eXm;
          ((AudioCacheInfo)localObject).musicUrl = paramchf.musicUrl;
          this.sVk = ((AudioCacheInfo)localObject);
          label305:
          bool1 = bool3;
          if (paramchf.eRn != 0) {
            if (paramchf.eRn != 2) {
              break label431;
            }
          }
        }
      }
    }
    label423:
    label431:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      this.sVl = bool1;
      this.startTime = paramchf.startTime;
      this.eBT = paramchf.endTime;
      this.sVo = false;
      AppMethodBeat.o(110954);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break;
      label369:
      bool2 = false;
      break label145;
      label374:
      localObject = k.sCp;
      localObject = getContext();
      j.p(localObject, "context");
      k.a(paramchf, (Context)localObject, (ViewGroup)this);
      localObject = this.sVm;
      if (localObject == null) {
        break label247;
      }
      ((ImageView)localObject).setVisibility(8);
      break label247;
      this.sVk = null;
      break label305;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoViewFakeLayer
 * JD-Core Version:    0.7.0.1
 */