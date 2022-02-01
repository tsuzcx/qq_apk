package com.tencent.mm.plugin.recordvideo.background;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.os.HandlerThread;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.f.f;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.k;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.g;
import com.tencent.mm.plugin.sight.base.ABAPrams;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "videoMixData", "Lcom/tencent/mm/plugin/recordvideo/background/data/VideoMixData;", "(Lcom/tencent/mm/plugin/recordvideo/background/data/VideoMixData;)V", "ABAPrams", "Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;", "getABAPrams", "()Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;", "setABAPrams", "(Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;)V", "SCENE_C2C", "", "SCENE_FINDER", "SCENE_SNS", "SCENE_STORY", "abaFlag", "abaParams", "Lcom/tencent/mm/plugin/sight/base/ABAPrams;", "audioBitrate", "audioChannelCount", "audioSampleRate", "blendBitmapProvider", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "blurBgProvider", "captureInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "forceResolution", "", "framePassDuration", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "lastFrameInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameInfo;", "mixThread", "Landroid/os/HandlerThread;", "onFinish", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "ret", "errorCode", "", "videoBitrate", "videoFrameRate", "videoHeight", "videoMaxQP", "videoMinQP", "getVideoMixData", "()Lcom/tencent/mm/plugin/recordvideo/background/data/VideoMixData;", "videoRotate", "videoWidth", "blendBitmap", "graffiti", "thumb", "left", "", "top", "calcMixEmojiSize", "Landroid/graphics/Point;", "centerCrop", "canvas", "Landroid/graphics/Canvas;", "thumbnail", "size", "centerInside", "checkAudioCache", "callback", "Lkotlin/Function0;", "checkThumbSize", "bitmap", "shortSide", "createGraffitiThumb", "config", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "createThumb", "getAbaFlag", "getMixConfig", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "mix", "readPictureDegree", "path", "videoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "reMuxEndTimeMsPrams", "reMuxStartTimeMsPrams", "setForceResolution", "setMixConfig", "width", "height", "start", "onFinishCallback", "Companion", "MixConfig", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VideoMixer
  implements com.tencent.mm.plugin.recordvideo.background.c.c
{
  public static final VideoMixer.a NEj;
  private final int ACC;
  private ABAPrams Gbz;
  public final com.tencent.mm.plugin.recordvideo.background.a.a NEk;
  private r<? super String, ? super String, ? super Boolean, ? super Integer, ah> NEl;
  private long NEm;
  private com.tencent.mm.plugin.recordvideo.ui.editor.b.a NEn;
  public g NEo;
  private com.tencent.mm.plugin.recordvideo.c.c NEp;
  public AdaptiveAdjustBitrate NEq;
  public int NEr;
  public boolean NEs;
  private final int NEt;
  private final int NEu;
  private final int NEv;
  private HandlerThread NEw;
  private int audioBitrate;
  private int audioChannelCount;
  private int audioSampleRate;
  public final kotlin.g.a.b<Long, Bitmap> nBp;
  private int nCa;
  private int nCb;
  public int nCg;
  public final kotlin.g.a.b<Long, Bitmap> nCt;
  private int videoBitrate;
  private int videoFrameRate;
  private int videoHeight;
  private int videoWidth;
  
  static
  {
    AppMethodBeat.i(75262);
    NEj = new VideoMixer.a((byte)0);
    AppMethodBeat.o(75262);
  }
  
  public VideoMixer(com.tencent.mm.plugin.recordvideo.background.a.a parama)
  {
    AppMethodBeat.i(279438);
    this.NEk = parama;
    this.NEm = -1L;
    this.NEp = this.NEk.NEp;
    this.NEt = 1;
    this.NEu = 2;
    this.NEv = 3;
    this.ACC = 4;
    Log.i("MicroMsg.Media.VideoMixer", s.X("create VideoMixer, ", this.NEk));
    this.nBp = ((kotlin.g.a.b)new b(this));
    this.nCt = ((kotlin.g.a.b)new c(this));
    AppMethodBeat.o(279438);
  }
  
  public static int aSW(String paramString)
  {
    AppMethodBeat.i(75251);
    s.u(paramString, "path");
    for (;;)
    {
      try
      {
        paramString = y.Lh(paramString);
        if (paramString == null) {
          continue;
        }
        localCloseable = (Closeable)paramString;
      }
      catch (IOException paramString)
      {
        Closeable localCloseable;
        ah localah;
        int i = 0;
        continue;
      }
      try
      {
        paramString = new androidx.f.a.a((InputStream)localCloseable);
        localah = ah.aiuX;
        kotlin.f.b.a(localCloseable, null);
        if (paramString != null) {
          continue;
        }
        paramString = null;
      }
      finally
      {
        try
        {
          AppMethodBeat.o(75251);
          throw paramString;
        }
        finally
        {
          kotlin.f.b.a(localCloseable, paramString);
          AppMethodBeat.o(75251);
        }
        paramString = Integer.valueOf(paramString.k("Orientation", 1));
        continue;
        if (paramString.intValue() != 6) {
          continue;
        }
        i = 90;
        continue;
        if (paramString.intValue() != 3) {
          continue;
        }
        i = 180;
        continue;
        i = paramString.intValue();
        if (i != 8) {
          continue;
        }
      }
      if (paramString == null)
      {
        if (paramString != null) {
          continue;
        }
        if (paramString != null) {
          continue;
        }
        i = 0;
        AppMethodBeat.o(75251);
        return i;
      }
      i = 270;
      continue;
      paramString = null;
    }
  }
  
  private final String gGX()
  {
    boolean bool = true;
    AppMethodBeat.i(75250);
    Bitmap localBitmap = d.bl(this.NEk.NEC, 200000L);
    if (localBitmap != null) {}
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.Media.VideoMixer", "createThumb getParentAbsolutePath: " + y.bEo(this.NEk.NED) + "  thumb size:" + this.NEk.NEE);
        y.ew(this.NEk.NED, true);
        i = this.NEk.NEE;
        if ((i <= 0) || (Math.min(localBitmap.getWidth(), localBitmap.getHeight()) <= i)) {
          break label343;
        }
        if (localBitmap.getWidth() >= localBitmap.getHeight()) {
          continue;
        }
        int k = (int)(localBitmap.getHeight() * i * 1.0F / localBitmap.getWidth());
        j = i;
        i = k;
        localObject1 = Bitmap.createScaledBitmap(localBitmap, j, i, true);
        s.s(localObject1, "createScaledBitmap(bitma…idth, outputHeight, true)");
        BitmapUtil.saveBitmapToImage((Bitmap)localObject1, 60, Bitmap.CompressFormat.JPEG, this.NEk.NED, true);
      }
      catch (IOException localIOException)
      {
        int i;
        int j;
        Object localObject1;
        float f;
        localObject2 = f.NRA;
        f.gJm();
        continue;
      }
      localObject1 = new StringBuilder(" mixVideoPath : ").append(this.NEk.NEC).append(" mixThumbPath:").append(this.NEk.NED).append("   thumb-bitmap is null:");
      if (localBitmap == null)
      {
        Log.i("MicroMsg.Media.VideoMixer", bool);
        if (localBitmap == null)
        {
          AppMethodBeat.o(75250);
          return null;
          f = localBitmap.getWidth() * i;
          j = localBitmap.getHeight();
          j = (int)(f * 1.0F / j);
          continue;
          localObject2 = f.NRA;
          f.gJm();
          continue;
        }
      }
      else
      {
        bool = false;
        continue;
      }
      Object localObject2 = this.NEk.NED;
      AppMethodBeat.o(75250);
      return localObject2;
      label343:
      localObject2 = localBitmap;
    }
  }
  
  public static Point kD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75258);
    Point localPoint = new Point(paramInt1 * 1, paramInt2 * 1);
    AppMethodBeat.o(75258);
    return localPoint;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    AppMethodBeat.i(75255);
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
    this.videoBitrate = paramInt3;
    this.audioBitrate = paramInt4;
    this.audioSampleRate = paramInt5;
    this.audioChannelCount = paramInt6;
    this.videoFrameRate = paramInt7;
    this.nCg = paramInt8;
    this.nCa = paramInt9;
    this.nCb = paramInt10;
    if (this.NEq == null) {
      this.NEq = new AdaptiveAdjustBitrate();
    }
    AdaptiveAdjustBitrate localAdaptiveAdjustBitrate = this.NEq;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.gYm();
    }
    AppMethodBeat.o(75255);
  }
  
  public final void a(VideoTransPara paramVideoTransPara, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75253);
    s.u(paramVideoTransPara, "videoParam");
    if (this.NEq == null) {
      this.NEq = new AdaptiveAdjustBitrate();
    }
    Log.i("MicroMsg.Media.VideoMixer", "Scene: [%d], ABASwitch: [%d] ceilingVideoBR:[%d]", new Object[] { Integer.valueOf(paramVideoTransPara.oCl), Integer.valueOf(paramVideoTransPara.oCb), Integer.valueOf(paramVideoTransPara.oCf) });
    AdaptiveAdjustBitrate localAdaptiveAdjustBitrate = this.NEq;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.nxP = this.videoHeight;
    }
    localAdaptiveAdjustBitrate = this.NEq;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.nxO = this.videoWidth;
    }
    localAdaptiveAdjustBitrate = this.NEq;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.PEZ = this.videoBitrate;
    }
    localAdaptiveAdjustBitrate = this.NEq;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.NGW = paramInt2;
    }
    localAdaptiveAdjustBitrate = this.NEq;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.NGX = paramInt1;
    }
    localAdaptiveAdjustBitrate = this.NEq;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.oCl = paramVideoTransPara.oCl;
    }
    localAdaptiveAdjustBitrate = this.NEq;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.oCb = paramVideoTransPara.oCb;
    }
    localAdaptiveAdjustBitrate = this.NEq;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.oCc = paramVideoTransPara.oCc;
    }
    localAdaptiveAdjustBitrate = this.NEq;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.PFa = paramVideoTransPara.oCd;
    }
    localAdaptiveAdjustBitrate = this.NEq;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.PFb = paramVideoTransPara.oCe;
    }
    localAdaptiveAdjustBitrate = this.NEq;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.oCf = paramVideoTransPara.oCf;
    }
    localAdaptiveAdjustBitrate = this.NEq;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.oCg = paramVideoTransPara.oCg;
    }
    localAdaptiveAdjustBitrate = this.NEq;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.oCi = paramVideoTransPara.oCi;
    }
    localAdaptiveAdjustBitrate = this.NEq;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.isEnableHEVC = paramVideoTransPara.oCh;
    }
    localAdaptiveAdjustBitrate = this.NEq;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.oCj = paramVideoTransPara.oCj;
    }
    localAdaptiveAdjustBitrate = this.NEq;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.nxU = paramVideoTransPara.nxU;
    }
    localAdaptiveAdjustBitrate = this.NEq;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.nxV = paramVideoTransPara.nxV;
    }
    localAdaptiveAdjustBitrate = this.NEq;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.oCk = paramVideoTransPara.oCk;
    }
    AppMethodBeat.o(75253);
  }
  
  public final void f(r<? super String, ? super String, ? super Boolean, ? super Integer, ah> paramr)
  {
    AppMethodBeat.i(75249);
    Log.i("MicroMsg.Media.VideoMixer", s.X("Start mixer ", Util.getStack()));
    this.NEl = ((r)new g(paramr, this));
    paramr = (kotlin.g.a.a)new h(this);
    if (this.NEk.NEp.EEx != null)
    {
      Object localObject = this.NEk.NEp.EEx;
      s.checkNotNull(localObject);
      if (!((AudioCacheInfo)localObject).cached)
      {
        localObject = k.NJr;
        localObject = k.gIk();
        AudioCacheInfo localAudioCacheInfo = this.NEk.NEp.EEx;
        s.checkNotNull(localAudioCacheInfo);
        ((k)localObject).a(localAudioCacheInfo, (m)new VideoMixer.d(paramr));
        AppMethodBeat.o(75249);
        return;
      }
    }
    paramr.invoke();
    AppMethodBeat.o(75249);
  }
  
  public final int gGY()
  {
    AppMethodBeat.i(75254);
    Log.i("MicroMsg.Media.VideoMixer", s.X("ABA: Input encoding prams :Br: [%d]  height: [%d]  width: [%d] forceResolution:", Boolean.valueOf(this.NEs)), new Object[] { Integer.valueOf(this.videoBitrate), Integer.valueOf(this.videoHeight), Integer.valueOf(this.videoWidth) });
    Object localObject1 = this.NEq;
    Object localObject2;
    label86:
    Object localObject3;
    label100:
    float f1;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = this.NEq;
      if (localObject2 != null) {
        break label934;
      }
      localObject2 = null;
      localObject3 = this.NEq;
      if (localObject3 != null) {
        break label947;
      }
      localObject3 = null;
      Log.i("MicroMsg.Media.VideoMixer", "Scene: [%d], ABASwitch: [%d], QPSwitch: [%d]", new Object[] { localObject1, localObject2, localObject3 });
      f1 = 1.0F;
      localObject1 = this.NEq;
      if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).oCb != 1)) {
        break label960;
      }
      i = 1;
      label152:
      if (i == 0)
      {
        localObject1 = this.NEq;
        if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).oCb != 2)) {
          break label966;
        }
        i = 1;
        label180:
        if (i == 0) {
          break label1189;
        }
      }
      localObject1 = this.NEq;
      if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).oCl != this.NEu)) {
        break label972;
      }
      i = 1;
      label211:
      if (i == 0)
      {
        localObject1 = this.NEq;
        if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).oCl != this.NEt)) {
          break label978;
        }
        i = 1;
        label242:
        if (i == 0)
        {
          localObject1 = this.NEq;
          if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).oCl != this.ACC)) {
            break label984;
          }
          i = 1;
          if (i == 0) {
            break label1189;
          }
        }
      }
      label273:
      if (this.NEk.nyh)
      {
        Log.i("MicroMsg.Media.VideoMixer", s.X("getABAPrams enableHevc, softEncode:", Boolean.valueOf(this.NEk.nBZ)));
        if (!this.NEk.nBZ) {
          break label1003;
        }
        localObject1 = this.NEq;
        if (localObject1 != null) {
          ((AdaptiveAdjustBitrate)localObject1).isEnableHEVC = 1;
        }
        localObject1 = this.NEq;
        if (localObject1 != null) {
          break label990;
        }
        localObject1 = null;
        label350:
        s.checkNotNull(localObject1);
        f1 = ((Float)localObject1).floatValue();
      }
      localObject2 = this.NEp.NGx;
      i = this.videoHeight;
      int j = this.videoWidth;
      int k = this.videoFrameRate;
      int m = this.videoBitrate;
      localObject1 = this.NEq;
      if (localObject1 != null) {
        break label1061;
      }
      localObject1 = null;
      label408:
      s.checkNotNull(localObject1);
      int n = ((Integer)localObject1).intValue();
      localObject1 = this.NEq;
      if (localObject1 != null) {
        break label1074;
      }
      localObject1 = null;
      label434:
      s.checkNotNull(localObject1);
      float f2 = (n - ((Integer)localObject1).intValue()) / 1000;
      localObject1 = this.NEq;
      if (localObject1 != null) {
        break label1087;
      }
      localObject1 = null;
      label467:
      s.checkNotNull(localObject1);
      float f3 = ((Integer)localObject1).intValue() / 1000;
      localObject1 = this.NEq;
      if (localObject1 != null) {
        break label1100;
      }
      localObject1 = null;
      label497:
      s.checkNotNull(localObject1);
      n = ((Integer)localObject1).intValue();
      localObject1 = this.NEq;
      if (localObject1 != null) {
        break label1113;
      }
      localObject1 = null;
      label523:
      s.checkNotNull(localObject1);
      int i1 = ((Integer)localObject1).intValue();
      localObject1 = this.NEq;
      if (localObject1 != null) {
        break label1126;
      }
      localObject1 = null;
      label549:
      s.checkNotNull(localObject1);
      int i2 = ((Integer)localObject1).intValue();
      localObject1 = this.NEq;
      if (localObject1 != null) {
        break label1139;
      }
      localObject1 = null;
      label575:
      s.checkNotNull(localObject1);
      int i3 = ((Integer)localObject1).intValue();
      localObject1 = this.NEq;
      if (localObject1 != null) {
        break label1152;
      }
      localObject1 = null;
      label601:
      s.checkNotNull(localObject1);
      int i4 = ((Integer)localObject1).intValue();
      localObject1 = this.NEq;
      if (localObject1 != null) {
        break label1165;
      }
      localObject1 = null;
      label627:
      s.checkNotNull(localObject1);
      this.Gbz = AdaptiveAdjustBitrate.a((String)localObject2, i, j, k, m, f2, f3, n, f1, i1, i2, i3, i4, ((Integer)localObject1).intValue(), false);
      if (this.Gbz != null)
      {
        localObject1 = this.Gbz;
        s.checkNotNull(localObject1);
        this.videoBitrate = (((ABAPrams)localObject1).outputKbps * 1000);
      }
      if (this.Gbz != null)
      {
        localObject1 = this.Gbz;
        s.checkNotNull(localObject1);
        if ((((ABAPrams)localObject1).resolutionAdjust > 0) && (!this.NEs))
        {
          localObject1 = this.Gbz;
          s.checkNotNull(localObject1);
          this.videoWidth = ((ABAPrams)localObject1).outputWidth;
          localObject1 = this.Gbz;
          s.checkNotNull(localObject1);
          this.videoHeight = ((ABAPrams)localObject1).outputHeight;
        }
      }
      Log.i("MicroMsg.Media.VideoMixer", "ABA: Adaptive Bitrate Methods:videoBitrate [%d]  targetWidth [%d]  targetHeight [%d]", new Object[] { Integer.valueOf(this.videoBitrate), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight) });
      v.bOi();
      j.a(this.Gbz);
      if (this.Gbz == null) {
        break label1178;
      }
      localObject1 = this.Gbz;
      s.checkNotNull(localObject1);
      if (((ABAPrams)localObject1).bitrateAdaptiveUP <= 0)
      {
        localObject1 = this.Gbz;
        s.checkNotNull(localObject1);
        if (((ABAPrams)localObject1).bitrateAdaptiveDown <= 0)
        {
          localObject1 = this.Gbz;
          s.checkNotNull(localObject1);
          if (((ABAPrams)localObject1).resolutionAdjust <= 0) {
            break label1178;
          }
        }
      }
      localObject1 = this.Gbz;
      s.checkNotNull(localObject1);
      this.NEr = ((ABAPrams)localObject1).bitrateAdaptiveUP;
    }
    for (int i = 0;; i = 1)
    {
      AppMethodBeat.o(75254);
      return i;
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).oCl);
      break;
      label934:
      localObject2 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject2).oCb);
      break label86;
      label947:
      localObject3 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject3).oCc);
      break label100;
      label960:
      i = 0;
      break label152;
      label966:
      i = 0;
      break label180;
      label972:
      i = 0;
      break label211;
      label978:
      i = 0;
      break label242;
      label984:
      i = 0;
      break label273;
      label990:
      localObject1 = Float.valueOf(((AdaptiveAdjustBitrate)localObject1).PFa);
      break label350;
      label1003:
      localObject1 = this.NEq;
      if (localObject1 != null) {
        ((AdaptiveAdjustBitrate)localObject1).isEnableHEVC = 2;
      }
      localObject1 = this.NEq;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = Float.valueOf(((AdaptiveAdjustBitrate)localObject1).PFb))
      {
        s.checkNotNull(localObject1);
        f1 = ((Float)localObject1).floatValue();
        break;
      }
      label1061:
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).NGX);
      break label408;
      label1074:
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).NGW);
      break label434;
      label1087:
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).NGW);
      break label467;
      label1100:
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).oCl);
      break label497;
      label1113:
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).oCf);
      break label523;
      label1126:
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).oCg);
      break label549;
      label1139:
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).isEnableHEVC);
      break label575;
      label1152:
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).oCi);
      break label601;
      label1165:
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).oCj);
      break label627;
      label1178:
      this.NEr = 0;
    }
    label1189:
    i = this.videoBitrate;
    localObject1 = this.NEq;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).oCk))
    {
      Log.i("MicroMsg.Media.VideoMixer", "ABA: No use ABA algorithm: final bitrate: [%d], takePhotosVideoBR: [%d]", new Object[] { Integer.valueOf(i), localObject1 });
      i = 1;
      break;
    }
  }
  
  public final MixConfig gGZ()
  {
    AppMethodBeat.i(75257);
    MixConfig localMixConfig = new MixConfig();
    localMixConfig.videoWidth = this.videoWidth;
    localMixConfig.videoHeight = this.videoHeight;
    localMixConfig.videoBitrate = this.videoBitrate;
    localMixConfig.audioBitrate = this.audioBitrate;
    localMixConfig.audioSampleRate = this.audioSampleRate;
    localMixConfig.audioChannelCount = this.audioChannelCount;
    localMixConfig.videoFrameRate = this.videoFrameRate;
    localMixConfig.nCg = this.nCg;
    AppMethodBeat.o(75257);
    return localMixConfig;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "audioBitrate", "", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "audioChannelCount", "getAudioChannelCount", "setAudioChannelCount", "audioSampleRate", "getAudioSampleRate", "setAudioSampleRate", "videoBitrate", "getVideoBitrate", "setVideoBitrate", "videoFrameRate", "getVideoFrameRate", "setVideoFrameRate", "videoHeight", "getVideoHeight", "setVideoHeight", "videoRotate", "getVideoRotate", "setVideoRotate", "videoWidth", "getVideoWidth", "setVideoWidth", "describeContents", "toString", "", "writeToParcel", "", "flags", "CREATOR", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class MixConfig
    implements Parcelable
  {
    public static final VideoMixer.MixConfig.a CREATOR;
    public int audioBitrate;
    public int audioChannelCount;
    public int audioSampleRate;
    public int nCg;
    public int videoBitrate;
    public int videoFrameRate;
    public int videoHeight;
    public int videoWidth;
    
    static
    {
      AppMethodBeat.i(75241);
      CREATOR = new VideoMixer.MixConfig.a((byte)0);
      AppMethodBeat.o(75241);
    }
    
    public MixConfig() {}
    
    public MixConfig(Parcel paramParcel)
    {
      this();
      AppMethodBeat.i(75240);
      this.videoWidth = paramParcel.readInt();
      this.videoHeight = paramParcel.readInt();
      this.videoBitrate = paramParcel.readInt();
      this.audioBitrate = paramParcel.readInt();
      this.audioSampleRate = paramParcel.readInt();
      this.audioChannelCount = paramParcel.readInt();
      this.videoFrameRate = paramParcel.readInt();
      this.nCg = paramParcel.readInt();
      AppMethodBeat.o(75240);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(75238);
      String str = "[MixConfig]videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.audioBitrate + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.audioChannelCount + ", videoFrameRate=" + this.videoFrameRate + ", videoRotate=" + this.nCg;
      AppMethodBeat.o(75238);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(75239);
      s.u(paramParcel, "parcel");
      paramParcel.writeInt(this.videoWidth);
      paramParcel.writeInt(this.videoHeight);
      paramParcel.writeInt(this.videoBitrate);
      paramParcel.writeInt(this.audioBitrate);
      paramParcel.writeInt(this.audioSampleRate);
      paramParcel.writeInt(this.audioChannelCount);
      paramParcel.writeInt(this.videoFrameRate);
      paramParcel.writeInt(this.nCg);
      AppMethodBeat.o(75239);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/graphics/Bitmap;", "pts", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Long, Bitmap>
  {
    b(VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/graphics/Bitmap;", "pts", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Long, Bitmap>
  {
    c(VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    e(boolean paramBoolean, VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    f(VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "mixVideo", "", "mixThumb", "ret", "", "errorCode", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements r<String, String, Boolean, Integer, ah>
  {
    g(r<? super String, ? super String, ? super Boolean, ? super Integer, ah> paramr, VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(VideoMixer paramVideoMixer)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.VideoMixer
 * JD-Core Version:    0.7.0.1
 */