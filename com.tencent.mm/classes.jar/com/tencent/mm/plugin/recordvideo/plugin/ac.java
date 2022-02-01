package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.b.g.b;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer;
import com.tencent.mm.plugin.recordvideo.e.e.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.k;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.ScopedStorageUtil.MediaStoreOps;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.a<Lkotlin.x;>;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.aa.d;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "abaParams", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getContext", "()Landroid/content/Context;", "setContext", "editConfig", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig;", "enable", "", "encode", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "getEncode", "()Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "setEncode", "(Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;)V", "foregroundRemuxFinishCallback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "ret", "", "getForegroundRemuxFinishCallback", "()Lkotlin/jvm/functions/Function3;", "setForegroundRemuxFinishCallback", "(Lkotlin/jvm/functions/Function3;)V", "loading", "Lcom/tencent/mm/plugin/recordvideo/ui/MediaProgressDialog;", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "x264RetryTime", "", "checkAudioCache", "audio", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "callback", "Lkotlin/Function0;", "checkBackgroundRemux", "error", "checkDaemonVideo", "checkForegroundRemux", "checkNoNeedRemuxVideo", "checkNullProvider", "checkSaveThumb", "videoPath", "thumbPath", "createMixer", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer;", "encodeConfig", "dismissDialog", "doFinish", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "forceRemux", "getMixer", "getTransformInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "runForeGround", "mixer", "runMixInBackground", "editorConfig", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "expiredTime", "", "scene", "setCaptureInfo", "info", "setMoovHead", "path", "snsCheck", "videoInfo", "Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "fileLength", "startReMux", "updateABABrWithQP", "Companion", "plugin-recordvideo_release"})
public final class ac
  implements u
{
  public static final a HOK;
  private RecordConfigProvider ALV;
  private int[] Azu;
  private com.tencent.mm.plugin.recordvideo.ui.a HOE;
  private com.tencent.mm.media.widget.camerarecordview.b.b HOF;
  private com.tencent.mm.plugin.recordvideo.b.g HOG;
  g.b HOH;
  public kotlin.g.a.q<? super String, ? super String, ? super Boolean, x> HOI;
  private int HOJ;
  Context context;
  private boolean enable;
  
  static
  {
    AppMethodBeat.i(75676);
    HOK = new a((byte)0);
    AppMethodBeat.o(75676);
  }
  
  public ac(Context paramContext)
  {
    AppMethodBeat.i(75675);
    this.context = paramContext;
    this.Azu = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    this.enable = true;
    this.HOH = new g.b((byte)0);
    AppMethodBeat.o(75675);
  }
  
  private final ac Z(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(163435);
    if ((this.ALV == null) || (!this.enable))
    {
      parama.invoke();
      AppMethodBeat.o(163435);
      return null;
    }
    this.enable = false;
    AppMethodBeat.o(163435);
    return this;
  }
  
  private final VideoMixer a(com.tencent.mm.plugin.recordvideo.b.g paramg, g.b paramb)
  {
    AppMethodBeat.i(75668);
    VideoMixer localVideoMixer = b(paramg);
    RecordConfigProvider localRecordConfigProvider = this.ALV;
    float f;
    if ((localRecordConfigProvider != null) && (localRecordConfigProvider.scene == 2)) {
      f = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFR, 1.0F);
    }
    for (;;)
    {
      Log.i("MicroMsg.RemuxPlugin", "final kbps: " + f + "  " + paramb.videoBitrate * f);
      VideoMixer.a(localVideoMixer, paramb.targetWidth, paramb.targetHeight, (int)(f * paramb.videoBitrate), paramb.audioBitrate, paramb.audioSampleRate, paramb.audioChannelCount, paramb.frameRate, paramb.kWG);
      paramb = this.ALV;
      if (paramb != null) {}
      for (paramb = paramb.mfk;; paramb = null)
      {
        if (paramb == null) {
          p.iCn();
        }
        localVideoMixer.a(paramb, paramg.HJY, paramg.HJX);
        AppMethodBeat.o(75668);
        return localVideoMixer;
        localRecordConfigProvider = this.ALV;
        if (localRecordConfigProvider != null)
        {
          if (localRecordConfigProvider.scene != 1) {
            break label221;
          }
          f = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFQ, 1.0F);
          break;
        }
        f = 1.0F;
        break;
      }
      label221:
      f = 1.0F;
    }
  }
  
  private final void a(g.b paramb)
  {
    AppMethodBeat.i(75674);
    Object localObject = com.tencent.mm.media.k.f.laB;
    com.tencent.mm.media.k.f.aWL();
    long l = Util.currentTicks();
    Log.i("MicroMsg.RemuxPlugin", "start forceRemux");
    localObject = this.ALV;
    String str;
    int i;
    int j;
    label197:
    label215:
    int k;
    if (localObject != null)
    {
      localObject = ((RecordConfigProvider)localObject).HLg;
      str = p.I((String)localObject, "_tmp");
      localObject = this.ALV;
      if (localObject == null) {
        p.iCn();
      }
      if (((RecordConfigProvider)localObject).mfk.lJA != 2) {
        break label421;
      }
      localObject = this.ALV;
      if (localObject == null) {
        p.iCn();
      }
      i = ((RecordConfigProvider)localObject).mfk.kSl;
      localObject = this.ALV;
      if (localObject == null) {
        p.iCn();
      }
      Log.i("MicroMsg.RemuxPlugin", "ABA: Using Min Max QP Limitation: [%d], [%d] ", new Object[] { Integer.valueOf(i), Integer.valueOf(((RecordConfigProvider)localObject).mfk.kSm) });
      localObject = this.ALV;
      if (localObject == null) {
        p.iCn();
      }
      i = ((RecordConfigProvider)localObject).mfk.kSl;
      localObject = this.ALV;
      if (localObject == null) {
        p.iCn();
      }
      j = ((RecordConfigProvider)localObject).mfk.kSm;
      localObject = this.ALV;
      if (localObject == null) {
        break label429;
      }
      localObject = ((RecordConfigProvider)localObject).HLg;
      k = paramb.targetWidth;
      int m = paramb.targetHeight;
      int n = paramb.videoBitrate;
      RecordConfigProvider localRecordConfigProvider = this.ALV;
      if (localRecordConfigProvider == null) {
        p.iCn();
      }
      int i1 = localRecordConfigProvider.mfk.lJn;
      localRecordConfigProvider = this.ALV;
      if (localRecordConfigProvider == null) {
        p.iCn();
      }
      k = SightVideoJNI.remuxingVFS((String)localObject, str, k, m, n, i1, 8, localRecordConfigProvider.mfk.lJm, 25.0F, paramb.frameRate, null, 0, false, i, j);
      paramb = this.ALV;
      if (paramb == null) {
        break label435;
      }
    }
    label421:
    label429:
    label435:
    for (paramb = paramb.HLg;; paramb = null)
    {
      com.tencent.mm.vfs.u.on(str, paramb);
      com.tencent.mm.vfs.u.deleteFile(str);
      l = Util.ticksToNow(l);
      Log.i("MicroMsg.RemuxPlugin", "minQP :" + i + "  maxQP :" + j + "  duration:" + k + " cost:" + l);
      paramb = com.tencent.mm.media.k.f.laB;
      com.tencent.mm.media.k.f.FT(l);
      AppMethodBeat.o(75674);
      return;
      localObject = null;
      break;
      i = 0;
      j = 51;
      break label197;
      localObject = null;
      break label215;
    }
  }
  
  private final void a(final VideoMixer paramVideoMixer, final com.tencent.mm.plugin.recordvideo.b.g paramg, final g.b paramb)
  {
    AppMethodBeat.i(75669);
    if (this.HOE == null)
    {
      localObject = new com.tencent.mm.plugin.recordvideo.ui.a();
      ((com.tencent.mm.plugin.recordvideo.ui.a)localObject).a(this.context, b.h.remux_loading_tips, (kotlin.g.a.a)e.HOT);
      this.HOE = ((com.tencent.mm.plugin.recordvideo.ui.a)localObject);
    }
    Object localObject = com.tencent.mm.plugin.recordvideo.background.f.HGG;
    com.tencent.mm.plugin.recordvideo.background.f.Y((kotlin.g.a.a)new f(this, paramb, paramVideoMixer, paramg));
    AppMethodBeat.o(75669);
  }
  
  private final void a(final AudioCacheInfo paramAudioCacheInfo, final kotlin.g.a.a<x> parama)
  {
    boolean bool2 = false;
    AppMethodBeat.i(163440);
    Object localObject = new StringBuilder("checkAudioCache audio:");
    if (paramAudioCacheInfo != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject = ((StringBuilder)localObject).append(bool1).append(", cache:");
      bool1 = bool2;
      if (paramAudioCacheInfo != null) {
        bool1 = paramAudioCacheInfo.aGs;
      }
      Log.i("MicroMsg.RemuxPlugin", bool1);
      localObject = new com.tencent.mm.plugin.recordvideo.ui.a();
      ((com.tencent.mm.plugin.recordvideo.ui.a)localObject).a(this.context, b.h.remux_loading_tips, (kotlin.g.a.a)b.HOL);
      this.HOE = ((com.tencent.mm.plugin.recordvideo.ui.a)localObject);
      if ((paramAudioCacheInfo == null) || (paramAudioCacheInfo.aGs)) {
        break;
      }
      Log.i("MicroMsg.RemuxPlugin", "checkAudioCache false");
      localObject = k.HMx;
      k.fwB().a(this.context, paramAudioCacheInfo, (m)new c(this, paramAudioCacheInfo, parama));
      AppMethodBeat.o(163440);
      return;
    }
    Log.i("MicroMsg.RemuxPlugin", "checkAudioCache done");
    parama.invoke();
    AppMethodBeat.o(163440);
  }
  
  private static void aVV(String paramString)
  {
    AppMethodBeat.i(75667);
    long l = Util.currentTicks();
    SightVideoJNI.optimizeMP4VFS(paramString);
    Log.i("MicroMsg.RemuxPlugin", "time cost: " + Util.ticksToNow(l));
    AppMethodBeat.o(75667);
  }
  
  private final ac aa(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(163436);
    if (!this.HOH.HKc)
    {
      Object localObject1 = this.HOF;
      if ((localObject1 != null) && (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).aZf() == true))
      {
        localObject1 = this.ALV;
        if (localObject1 != null)
        {
          localObject1 = ((RecordConfigProvider)localObject1).mfk;
          if ((localObject1 != null) && (((VideoTransPara)localObject1).lJz == 1)) {}
        }
        else
        {
          localObject1 = this.ALV;
          if (localObject1 == null) {
            break label468;
          }
          localObject1 = ((RecordConfigProvider)localObject1).mfk;
          if ((localObject1 == null) || (((VideoTransPara)localObject1).lJz != 2)) {
            break label468;
          }
        }
        localObject1 = this.ALV;
        if (localObject1 != null)
        {
          localObject1 = ((RecordConfigProvider)localObject1).mfk;
          if ((localObject1 != null) && (((VideoTransPara)localObject1).lJJ == 1)) {}
        }
        else
        {
          localObject1 = this.ALV;
          if (localObject1 != null)
          {
            localObject1 = ((RecordConfigProvider)localObject1).mfk;
            if ((localObject1 != null) && (((VideoTransPara)localObject1).lJJ == 2)) {}
          }
          else
          {
            localObject1 = this.ALV;
            if (localObject1 == null) {
              break label468;
            }
            localObject1 = ((RecordConfigProvider)localObject1).mfk;
            if ((localObject1 == null) || (((VideoTransPara)localObject1).lJJ != 4)) {
              break label468;
            }
          }
        }
        localObject1 = this.HOG;
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = a((com.tencent.mm.plugin.recordvideo.b.g)localObject1, this.HOH);
        Object localObject2 = ((VideoMixer)localObject1).HGT;
        if (localObject2 != null) {
          ((AdaptiveAdjustBitrate)localObject2).HJY = 3000;
        }
        int i = ((VideoMixer)localObject1).fvi();
        Log.i("MicroMsg.RemuxPlugin", "ABA: useDarmonVideo: ".concat(String.valueOf(i)));
        if (i == 0)
        {
          parama.invoke();
          parama = com.tencent.mm.plugin.recordvideo.d.g.HUM;
          com.tencent.mm.plugin.recordvideo.d.g.acx(1);
          parama = com.tencent.mm.plugin.recordvideo.d.g.HUM;
          com.tencent.mm.plugin.recordvideo.d.g.acw(1);
          AppMethodBeat.o(163436);
          return this;
        }
        localObject1 = new StringBuilder("ABA::check DarmonVideo, add the metadate for video of low bitrate path: ");
        localObject2 = this.HOF;
        if (localObject2 == null) {
          p.iCn();
        }
        Log.i("MicroMsg.RemuxPlugin", ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).lfm);
        localObject1 = this.HOF;
        if (localObject1 == null) {
          p.iCn();
        }
        SightVideoJNI.addReportMetadata(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).lfm, new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 1, 0);
        localObject1 = com.tencent.mm.plugin.recordvideo.d.g.HUM;
        com.tencent.mm.plugin.recordvideo.d.g.acw(0);
        label468:
        localObject1 = com.tencent.mm.plugin.recordvideo.d.g.HUM;
        com.tencent.mm.plugin.recordvideo.d.g.acx(0);
        localObject1 = this.ALV;
        if (localObject1 != null)
        {
          parama = new StringBuilder("daemonMediaCaptureInfo into: \ndaemonVideoPath = ");
          localObject2 = this.HOF;
          if (localObject2 == null) {
            p.iCn();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).lfm).append(", daemonVideoSize = ");
          localObject2 = this.HOF;
          if (localObject2 == null) {
            p.iCn();
          }
          parama = parama.append(com.tencent.mm.vfs.u.bBQ(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).lfm)).append(", \nsourceVideoPath = ");
          localObject2 = this.HOF;
          if (localObject2 == null) {
            p.iCn();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).lfj).append(", captureSize = ");
          localObject2 = this.HOF;
          if (localObject2 == null) {
            p.iCn();
          }
          Log.i("MicroMsg.RemuxPlugin", com.tencent.mm.vfs.u.bBQ(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).lfj) + ", \noutputSize = " + ((RecordConfigProvider)localObject1).HLg + ", outputSize = " + com.tencent.mm.vfs.u.bBQ(((RecordConfigProvider)localObject1).HLg));
          parama = this.HOF;
          if (parama == null) {
            p.iCn();
          }
          com.tencent.mm.vfs.u.on(parama.lfm, ((RecordConfigProvider)localObject1).HLg);
          parama = this.HOF;
          if (parama == null) {
            p.iCn();
          }
          com.tencent.mm.vfs.u.on(parama.lfn, ((RecordConfigProvider)localObject1).thumbPath);
          parama = com.tencent.mm.plugin.recordvideo.e.d.IeU;
          com.tencent.mm.plugin.recordvideo.e.d.d(this.HOF);
          parama = com.tencent.mm.plugin.recordvideo.e.d.IeU;
          com.tencent.mm.plugin.recordvideo.e.d.h((RecordConfigProvider)localObject1);
          Log.i("MicroMsg.RemuxPlugin", "daemonMediaCaptureInfo 1: " + this.HOF);
          parama = new StringBuilder("daemonMediaCaptureInfo 2: \ndaemonVideoPath = ");
          localObject2 = this.HOF;
          if (localObject2 == null) {
            p.iCn();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).lfm).append(", daemonVideoSize = ");
          localObject2 = this.HOF;
          if (localObject2 == null) {
            p.iCn();
          }
          parama = parama.append(com.tencent.mm.vfs.u.bBQ(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).lfm)).append(", \nsourceVideoPath = ");
          localObject2 = this.HOF;
          if (localObject2 == null) {
            p.iCn();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).lfj).append(", captureSize = ");
          localObject2 = this.HOF;
          if (localObject2 == null) {
            p.iCn();
          }
          Log.i("MicroMsg.RemuxPlugin", com.tencent.mm.vfs.u.bBQ(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).lfj) + ", \noutputSize = " + ((RecordConfigProvider)localObject1).HLg + ", outputSize = " + com.tencent.mm.vfs.u.bBQ(((RecordConfigProvider)localObject1).HLg));
          parama = ((RecordConfigProvider)localObject1).HLg;
          p.j(parama, "this.outputVideoPath");
          localObject2 = ((RecordConfigProvider)localObject1).thumbPath;
          p.j(localObject2, "this.thumbPath");
          jQ(parama, (String)localObject2);
          parama = ((RecordConfigProvider)localObject1).HLg;
          p.j(parama, "this.outputVideoPath");
          aVV(parama);
          parama = com.tencent.mm.plugin.recordvideo.d.g.HUM;
          com.tencent.mm.plugin.recordvideo.d.g.acy(1);
          parama = com.tencent.mm.plugin.recordvideo.d.g.HUM;
          com.tencent.mm.plugin.recordvideo.d.g.aJ(1, 1L);
          parama = Boolean.TRUE;
          localObject2 = ((RecordConfigProvider)localObject1).HLg;
          localObject1 = ((RecordConfigProvider)localObject1).thumbPath;
          Object localObject3 = this.HOF;
          if (localObject3 == null) {
            p.iCn();
          }
          i = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject3).lfp;
          localObject3 = this.HOF;
          if (localObject3 == null) {
            p.iCn();
          }
          long l = i - ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject3).lfo;
          localObject3 = Boolean.FALSE;
          com.tencent.mm.plugin.recordvideo.d.c localc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
          b(new CaptureDataManager.CaptureVideoNormalModel(parama, (String)localObject2, (String)localObject1, Long.valueOf(l), (Boolean)localObject3, com.tencent.mm.plugin.recordvideo.d.c.fxp()));
          AppMethodBeat.o(163436);
          return null;
        }
      }
    }
    parama.invoke();
    AppMethodBeat.o(163436);
    return this;
  }
  
  private final ac ab(kotlin.g.a.a<x> parama)
  {
    boolean bool = false;
    AppMethodBeat.i(163437);
    Object localObject2 = this.ALV;
    if (localObject2 != null)
    {
      Object localObject1;
      if (this.HOH.HKb)
      {
        if (!this.HOH.HKc)
        {
          localObject1 = com.tencent.mm.media.b.b.kSf;
          if (!com.tencent.mm.media.b.b.aTW()) {}
        }
      }
      else
      {
        localObject1 = this.HOG;
        label106:
        label250:
        Object localObject3;
        label256:
        long l;
        com.tencent.mm.plugin.recordvideo.d.c localc;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.recordvideo.b.g)localObject1).AQf;
          if (localObject1 != null) {
            break label880;
          }
          parama = this.HOF;
          if ((parama == null) || (parama.lfl != true)) {
            break label423;
          }
          if (((RecordConfigProvider)localObject2).scene != 2) {
            break label394;
          }
          parama = com.tencent.mm.media.k.f.laB;
          com.tencent.mm.media.k.f.aWy();
          parama = com.tencent.mm.plugin.recordvideo.e.d.IeU;
          com.tencent.mm.plugin.recordvideo.e.d.i(this.ALV);
          parama = ((RecordConfigProvider)localObject2).HLg;
          p.j(parama, "this.outputVideoPath");
          localObject1 = ((RecordConfigProvider)localObject2).thumbPath;
          p.j(localObject1, "this.thumbPath");
          jQ(parama, (String)localObject1);
          parama = ((RecordConfigProvider)localObject2).HLg;
          p.j(parama, "this.outputVideoPath");
          aVV(parama);
          parama = this.HOF;
          if (parama != null)
          {
            localObject1 = CaptureDataManager.HKJ;
            p.j(localObject1, "CaptureDataManager.INSTANCE");
            ((CaptureDataManager)localObject1).getExtData().putBoolean("key_is_capture_video", parama.lfl);
            localObject1 = CaptureDataManager.HKJ;
            p.j(localObject1, "CaptureDataManager.INSTANCE");
            localObject1 = ((CaptureDataManager)localObject1).getExtData();
            parama = (Collection)parama.lfr;
            if ((parama != null) && (!parama.isEmpty())) {
              break label413;
            }
            i = 1;
            if (i != 0) {
              break label418;
            }
            bool = true;
            ((Bundle)localObject1).putBoolean("key_is_photo_video", bool);
          }
          parama = Boolean.TRUE;
          localObject1 = ((RecordConfigProvider)localObject2).HLg;
          localObject2 = ((RecordConfigProvider)localObject2).thumbPath;
          localObject3 = this.HOG;
          if (localObject3 == null) {
            p.iCn();
          }
          i = ((com.tencent.mm.plugin.recordvideo.b.g)localObject3).HJY;
          localObject3 = this.HOG;
          if (localObject3 == null) {
            p.iCn();
          }
          l = i - ((com.tencent.mm.plugin.recordvideo.b.g)localObject3).HJX;
          localObject3 = Boolean.FALSE;
          localc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
          b(new CaptureDataManager.CaptureVideoNormalModel(parama, (String)localObject1, (String)localObject2, Long.valueOf(l), (Boolean)localObject3, com.tencent.mm.plugin.recordvideo.d.c.fxp()));
        }
        label394:
        label413:
        label418:
        label423:
        label489:
        do
        {
          parama = com.tencent.mm.plugin.recordvideo.d.g.HUM;
          com.tencent.mm.plugin.recordvideo.d.g.acy(2);
          parama = com.tencent.mm.plugin.recordvideo.d.g.HUM;
          com.tencent.mm.plugin.recordvideo.d.g.aJ(1, 1L);
          AppMethodBeat.o(163437);
          return null;
          localObject1 = null;
          break;
          if (((RecordConfigProvider)localObject2).scene != 1) {
            break label106;
          }
          parama = com.tencent.mm.media.k.f.laB;
          com.tencent.mm.media.k.f.aWz();
          break label106;
          i = 0;
          break label250;
          bool = false;
          break label256;
          if (!com.tencent.mm.compatible.util.d.qV(30)) {
            break label596;
          }
          localObject1 = MMApplicationContext.getContext();
          parama = this.HOF;
          if (parama == null) {
            break label586;
          }
          parama = parama.lfj;
          parama = ScopedStorageUtil.MediaStoreOps.videoPathToUri((Context)localObject1, parama);
          if (parama != null)
          {
            localObject1 = parama.toString();
            parama = (kotlin.g.a.a<x>)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            parama = this.HOF;
            if (parama == null) {
              break label591;
            }
            parama = parama.lfj;
          }
          Log.i("MicroMsg.RemuxPlugin", "checkNoNeedRemuxVideo uriPath:".concat(String.valueOf(parama)));
        } while (parama == null);
        localObject1 = this.ALV;
        if (localObject1 != null)
        {
          localObject1 = ((RecordConfigProvider)localObject1).HLg;
          label526:
          if (com.tencent.mm.vfs.u.on(parama, (String)localObject1) < 0L) {
            break label629;
          }
          parama = this.ALV;
          if (parama == null) {
            break label624;
          }
          parama = parama.HLg;
          label551:
          localObject1 = (CharSequence)parama;
          if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
            break label632;
          }
        }
        label586:
        label591:
        label596:
        label624:
        label629:
        label632:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label637;
          }
          AppMethodBeat.o(163437);
          return null;
          parama = null;
          break;
          parama = null;
          break label489;
          parama = this.HOF;
          if (parama != null)
          {
            parama = parama.lfj;
            break label489;
          }
          parama = null;
          break label489;
          localObject1 = null;
          break label526;
          parama = null;
          break label551;
          break label551;
        }
        label637:
        Log.i("MicroMsg.RemuxPlugin", "checkNoNeedRemuxVideo, targetVideoPath:".concat(String.valueOf(parama)));
        localObject1 = ((RecordConfigProvider)localObject2).thumbPath;
        p.j(localObject1, "this.thumbPath");
        jQ(parama, (String)localObject1);
        aVV(parama);
        localObject1 = this.HOF;
        if (localObject1 != null)
        {
          localObject3 = CaptureDataManager.HKJ;
          p.j(localObject3, "CaptureDataManager.INSTANCE");
          ((CaptureDataManager)localObject3).getExtData().putBoolean("key_is_capture_video", ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).lfl);
          localObject3 = CaptureDataManager.HKJ;
          p.j(localObject3, "CaptureDataManager.INSTANCE");
          localObject3 = ((CaptureDataManager)localObject3).getExtData();
          localObject1 = (Collection)((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).lfr;
          if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
            break label875;
          }
        }
        label875:
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            bool = true;
          }
          ((Bundle)localObject3).putBoolean("key_is_photo_video", bool);
          localObject1 = Boolean.TRUE;
          localObject2 = ((RecordConfigProvider)localObject2).thumbPath;
          localObject3 = this.HOG;
          if (localObject3 == null) {
            p.iCn();
          }
          i = ((com.tencent.mm.plugin.recordvideo.b.g)localObject3).HJY;
          localObject3 = this.HOG;
          if (localObject3 == null) {
            p.iCn();
          }
          l = i - ((com.tencent.mm.plugin.recordvideo.b.g)localObject3).HJX;
          localObject3 = Boolean.FALSE;
          localc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
          b(new CaptureDataManager.CaptureVideoNormalModel((Boolean)localObject1, parama, (String)localObject2, Long.valueOf(l), (Boolean)localObject3, com.tencent.mm.plugin.recordvideo.d.c.fxp()));
          break;
        }
      }
    }
    label880:
    parama.invoke();
    AppMethodBeat.o(163437);
    return this;
  }
  
  private final ac ac(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(163438);
    Object localObject = this.ALV;
    if ((localObject != null) && (p.h(((RecordConfigProvider)localObject).HKZ, Boolean.TRUE)))
    {
      parama = this.HOG;
      if (parama == null) {
        p.iCn();
      }
      parama = a(parama, this.HOH);
      localObject = com.tencent.mm.plugin.recordvideo.d.f.HUI;
      com.tencent.mm.plugin.recordvideo.d.f.wK(true);
      localObject = this.HOG;
      if (localObject == null) {
        p.iCn();
      }
      a(parama, (com.tencent.mm.plugin.recordvideo.b.g)localObject, this.HOH);
      AppMethodBeat.o(163438);
      return null;
    }
    parama.invoke();
    AppMethodBeat.o(163438);
    return this;
  }
  
  private final ac ad(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(163439);
    Object localObject1 = com.tencent.mm.plugin.recordvideo.d.f.HUI;
    com.tencent.mm.plugin.recordvideo.d.f.wK(false);
    localObject1 = this.HOG;
    if (localObject1 == null) {
      p.iCn();
    }
    localObject1 = a((com.tencent.mm.plugin.recordvideo.b.g)localObject1, this.HOH);
    RecordConfigProvider localRecordConfigProvider = this.ALV;
    if (localRecordConfigProvider != null)
    {
      final aa.f localf = new aa.f();
      localf.aaBC = new ame();
      parama = (ame)localf.aaBC;
      Object localObject2 = this.HOG;
      if (localObject2 == null) {
        p.iCn();
      }
      int i = ((com.tencent.mm.plugin.recordvideo.b.g)localObject2).HJY;
      localObject2 = this.HOG;
      if (localObject2 == null) {
        p.iCn();
      }
      parama.duration = (i - ((com.tencent.mm.plugin.recordvideo.b.g)localObject2).HJX);
      ((ame)localf.aaBC).SwA = new LinkedList((Collection)kotlin.a.e.V(this.Azu));
      localObject2 = (ame)localf.aaBC;
      parama = localRecordConfigProvider.mfk;
      if (parama != null)
      {
        parama = Integer.valueOf(parama.lJz);
        if (parama == null) {
          p.iCn();
        }
        ((ame)localObject2).lJz = parama.intValue();
        parama = (ame)localf.aaBC;
        localObject2 = this.HOF;
        if (localObject2 == null) {
          break label418;
        }
      }
      label418:
      for (boolean bool = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).lfl;; bool = false)
      {
        parama.SwB = bool;
        ((ame)localf.aaBC).NiN = this.HOH.HKc;
        ((ame)localf.aaBC).HLd = localRecordConfigProvider.HLd;
        ((ame)localf.aaBC).HLe = localRecordConfigProvider.HLe;
        ((ame)localf.aaBC).HLf = localRecordConfigProvider.HLf;
        ((ame)localf.aaBC).HLg = localRecordConfigProvider.HLg;
        ((ame)localf.aaBC).SwC = localRecordConfigProvider.thumbPath;
        ((ame)localf.aaBC).HHQ = ((VideoMixer)localObject1).HHa.kXp;
        ((ame)localf.aaBC).SwD = 0;
        parama = this.HOG;
        if (parama == null) {
          p.iCn();
        }
        a(parama.AQf, (kotlin.g.a.a)new d(localRecordConfigProvider, localf, this, (VideoMixer)localObject1));
        parama = com.tencent.mm.plugin.recordvideo.d.g.HUM;
        com.tencent.mm.plugin.recordvideo.d.g.acy(0);
        AppMethodBeat.o(163439);
        return null;
        parama = null;
        break;
      }
    }
    parama.invoke();
    AppMethodBeat.o(163439);
    return this;
  }
  
  private final VideoMixer b(com.tencent.mm.plugin.recordvideo.b.g paramg)
  {
    int j = 1;
    AppMethodBeat.i(75670);
    long l = System.currentTimeMillis();
    Object localObject1 = this.ALV;
    if (localObject1 != null)
    {
      localObject2 = ((RecordConfigProvider)localObject1).HLg;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.e.d.IeU;
      localObject1 = com.tencent.mm.plugin.recordvideo.e.d.aWp(String.valueOf(l));
    }
    Object localObject2 = this.ALV;
    if (localObject2 != null)
    {
      localObject3 = ((RecordConfigProvider)localObject2).thumbPath;
      localObject2 = localObject3;
      if (localObject3 != null) {}
    }
    else
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.e.d.IeU;
      localObject2 = com.tencent.mm.plugin.recordvideo.e.d.aWq(String.valueOf(l));
    }
    Object localObject3 = this.ALV;
    int i;
    boolean bool2;
    label149:
    int k;
    boolean bool1;
    if (localObject3 != null)
    {
      i = ((RecordConfigProvider)localObject3).scene;
      if ((i != 2) && (i != 11)) {
        break label578;
      }
      if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFM, 0) != 1) {
        break label559;
      }
      bool2 = true;
      k = af.juO.jtG;
      if (k == -1) {
        break label571;
      }
      if (k != 1) {
        break label565;
      }
      bool1 = true;
      label172:
      Log.i("MicroMsg.RemuxPlugin", "sns config use x264 encode: " + bool2 + ", deviceUseX264Encode:" + k);
    }
    for (;;)
    {
      bool2 = bool1;
      if (MultiProcessMMKV.getSingleDefault().getBoolean("mediacodec_create_error", false)) {
        bool2 = true;
      }
      Log.i("MicroMsg.RemuxPlugin", "final useX264Encode: ".concat(String.valueOf(bool2)));
      localObject3 = com.tencent.mm.plugin.recordvideo.d.g.HUM;
      com.tencent.mm.plugin.recordvideo.d.g.wO(bool2);
      localObject3 = com.tencent.mm.plugin.recordvideo.d.g.HUM;
      com.tencent.mm.plugin.recordvideo.d.g.wP(com.tencent.mm.plugin.sight.base.c.fIu());
      if ((i == 2) || (i == 1))
      {
        localObject3 = com.tencent.mm.plugin.recordvideo.b.e.HJM;
        boolean bool3 = com.tencent.mm.plugin.recordvideo.b.e.wv(true);
        localObject3 = com.tencent.mm.plugin.recordvideo.b.e.HJM;
        boolean bool4 = com.tencent.mm.plugin.recordvideo.b.e.wv(false);
        if (((bool2) && (bool3)) || (bool3) || (bool4))
        {
          bool1 = true;
          label318:
          if ((!bool2) && (!bool3)) {
            break label692;
          }
          bool2 = true;
          label331:
          Log.i("MicroMsg.RemuxPlugin", "checkEnableHevc, hwEnableHevc:" + bool4 + ", swEnableHevc:" + bool3 + ", enableHevc:" + bool1 + ", useSoftEncode:" + bool2);
          if (bool1)
          {
            localObject3 = com.tencent.mm.plugin.recordvideo.d.g.HUM;
            if (!bool2) {
              break label698;
            }
            label402:
            com.tencent.mm.plugin.recordvideo.d.g.acB(j);
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.recordvideo.b.c localc = c(paramg);
        if ((i == 3) && (!com.tencent.mm.vfs.u.agG(localc.HJy)))
        {
          localObject3 = com.tencent.mm.plugin.recordvideo.d.e.HUH;
          com.tencent.mm.plugin.recordvideo.d.e.wJ(localc.lfl);
        }
        List localList = (List)paramg.HJV;
        float[] arrayOfFloat1 = paramg.HHg;
        float[] arrayOfFloat2 = paramg.HHh;
        localObject3 = this.ALV;
        if (localObject3 != null)
        {
          localObject3 = ((RecordConfigProvider)localObject3).mfk;
          if (localObject3 == null) {}
        }
        for (i = ((VideoTransPara)localObject3).lJy;; i = 0)
        {
          localObject3 = paramg.HHl;
          paramg = (com.tencent.mm.plugin.recordvideo.b.g)localObject3;
          if (localObject3 == null) {
            paramg = "";
          }
          paramg = new VideoMixer(new com.tencent.mm.plugin.recordvideo.background.a.a(localc, localList, arrayOfFloat1, arrayOfFloat2, (String)localObject1, (String)localObject2, 0, bool2, bool1, i, paramg, 64));
          AppMethodBeat.o(75670);
          return paramg;
          i = 0;
          break;
          label559:
          bool2 = false;
          break label149;
          label565:
          bool1 = false;
          break label172;
          label571:
          bool1 = bool2;
          break label172;
          label578:
          if (i != 1) {
            break label714;
          }
          if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFN, 0) == 1)
          {
            bool2 = true;
            label607:
            k = af.juO.jtF;
            if (k == -1) {
              break label679;
            }
            if (k != 1) {
              break label673;
            }
            bool1 = true;
          }
          for (;;)
          {
            Log.i("MicroMsg.RemuxPlugin", "c2c config use x264 encode: " + bool2 + ", deviceUseX264Encode:" + k);
            break;
            bool2 = false;
            break label607;
            label673:
            bool1 = false;
            continue;
            label679:
            bool1 = bool2;
          }
          bool1 = false;
          break label318;
          label692:
          bool2 = false;
          break label331;
          label698:
          j = 2;
          break label402;
        }
        bool1 = false;
      }
      label714:
      bool1 = false;
    }
  }
  
  private final void b(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(75672);
    MultiProcessMMKV.getSingleDefault().putBoolean("mediacodec_create_error", false);
    CaptureDataManager.HKJ.a(this.context, paramCaptureVideoNormalModel);
    AppMethodBeat.o(75672);
  }
  
  private final com.tencent.mm.plugin.recordvideo.b.c c(com.tencent.mm.plugin.recordvideo.b.g paramg)
  {
    boolean bool = true;
    AppMethodBeat.i(75671);
    com.tencent.mm.plugin.recordvideo.b.c localc = new com.tencent.mm.plugin.recordvideo.b.c();
    Object localObject = this.HOF;
    String str;
    if (localObject != null)
    {
      str = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).lfj;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localc.aVQ((String)localObject);
    localObject = this.HOF;
    if (localObject != null)
    {
      str = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).lfk;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localc.aVR((String)localObject);
    localc.zBD = paramg.AQf;
    int i;
    if (paramg.HJH) {
      if (localc.zBD == null) {
        i = 0;
      }
    }
    for (;;)
    {
      localc.HJD = i;
      localObject = this.HOF;
      if (localObject != null) {
        bool = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).lfl;
      }
      localc.lfl = bool;
      localc.kWG = SightVideoJNI.getMp4RotateVFS(localc.HJy);
      localc.HJA = paramg.HJX;
      localc.HJB = paramg.HJY;
      localc.aQ(paramg.HJZ);
      Log.i("MicroMsg.RemuxPlugin", "getTransformInfo :".concat(String.valueOf(localc)));
      AppMethodBeat.o(75671);
      return localc;
      i = 2;
      continue;
      if (localc.zBD == null) {
        i = 1;
      } else {
        i = 3;
      }
    }
  }
  
  private final void jQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(75673);
    if (com.tencent.mm.vfs.u.agG(paramString2)) {
      com.tencent.mm.vfs.u.deleteFile(paramString2);
    }
    paramString1 = com.tencent.mm.plugin.mmsight.d.Xd(paramString1);
    Object localObject;
    if (paramString1 != null)
    {
      localObject = com.tencent.mm.plugin.recordvideo.e.d.IeU;
      localObject = this.ALV;
      if (localObject == null) {
        break label84;
      }
      localObject = ((RecordConfigProvider)localObject).mfk;
      if (localObject == null) {
        break label84;
      }
    }
    label84:
    for (int i = ((VideoTransPara)localObject).lJy;; i = 0)
    {
      BitmapUtil.saveBitmapToImage(com.tencent.mm.plugin.recordvideo.e.d.k(paramString1, i), 60, Bitmap.CompressFormat.JPEG, paramString2, true);
      AppMethodBeat.o(75673);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.b.g paramg)
  {
    AppMethodBeat.i(75666);
    p.k(paramg, "editConfig");
    Log.i("MicroMsg.RemuxPlugin", "startReMux !!!!");
    Object localObject = Z((kotlin.g.a.a)new h(this));
    if (localObject != null)
    {
      ((ac)localObject).HOG = paramg;
      ((ac)localObject).HOH = paramg.a(((ac)localObject).ALV, ((ac)localObject).HOF);
      Log.i("MicroMsg.RemuxPlugin", "configProvider : " + ((ac)localObject).ALV);
      Log.i("MicroMsg.RemuxPlugin", "RemuxMediaEditConfig : ".concat(String.valueOf(paramg)));
      Log.i("MicroMsg.RemuxPlugin", "mediaCaptureInfo : " + ((ac)localObject).HOF);
      Log.i("MicroMsg.RemuxPlugin", "generateTargetConfig info: " + ((ac)localObject).HOH + ' ');
      paramg = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_VIDEO_IS_EDITED_BOOLEAN", Boolean.valueOf(((ac)localObject).HOH.HKc));
      paramg = com.tencent.mm.media.k.f.laB;
      com.tencent.mm.media.k.f.aWB();
      if (((ac)localObject).HOH.HKc)
      {
        paramg = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aWA();
      }
      if (localObject != null)
      {
        paramg = ((ac)localObject).aa((kotlin.g.a.a)i.HPc);
        if (paramg != null)
        {
          localObject = com.tencent.mm.plugin.recordvideo.e.d.IeU;
          com.tencent.mm.plugin.recordvideo.e.d.d(paramg.HOF);
          if (paramg != null)
          {
            paramg = paramg.ab((kotlin.g.a.a)j.HPd);
            if (paramg != null)
            {
              paramg = paramg.ac((kotlin.g.a.a)k.HPe);
              if (paramg != null)
              {
                paramg.ad((kotlin.g.a.a)l.HPf);
                AppMethodBeat.o(75666);
                return;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(75666);
  }
  
  public final void b(com.tencent.mm.media.widget.camerarecordview.b.b paramb, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(75665);
    p.k(paramb, "info");
    p.k(paramRecordConfigProvider, "configProvider");
    this.HOF = paramb;
    this.ALV = paramRecordConfigProvider;
    paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.d.c.HUw;
    com.tencent.mm.plugin.recordvideo.d.c.w("KEY_IS_CAPUTRE_BOOLEAN", Boolean.valueOf(paramb.lfl));
    if (paramb.lfl)
    {
      paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_CAPUTRE_VIDEO_PATH_STRING", paramb.aZh());
      paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_CAPUTRE_THUMB_PATH_STRING", paramb.aZi());
    }
    AppMethodBeat.o(75665);
  }
  
  public final void bbp() {}
  
  public final String name()
  {
    AppMethodBeat.i(226971);
    String str = getClass().getName();
    AppMethodBeat.o(226971);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(226979);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(226979);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final b HOL;
    
    static
    {
      AppMethodBeat.i(75647);
      HOL = new b();
      AppMethodBeat.o(75647);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "<anonymous parameter 1>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements m<Boolean, String, x>
  {
    c(ac paramac, AudioCacheInfo paramAudioCacheInfo, kotlin.g.a.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin$checkBackgroundRemux$1$1"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(RecordConfigProvider paramRecordConfigProvider, aa.f paramf, ac paramac, VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final e HOT;
    
    static
    {
      AppMethodBeat.i(75651);
      HOT = new e();
      AppMethodBeat.o(75651);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    f(ac paramac, g.b paramb, VideoMixer paramVideoMixer, com.tencent.mm.plugin.recordvideo.b.g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(ac paramac, VideoMixer paramVideoMixer, g.b paramb, com.tencent.mm.plugin.recordvideo.b.g paramg, ame paramame, long paramLong, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(75655);
      Object localObject1 = ac.f(this.HOM);
      Object localObject3;
      boolean bool;
      label101:
      VideoMixer localVideoMixer;
      label138:
      label170:
      Object localObject6;
      g.b localb;
      if (localObject1 != null)
      {
        localObject3 = CaptureDataManager.HKJ;
        p.j(localObject3, "CaptureDataManager.INSTANCE");
        ((CaptureDataManager)localObject3).getExtData().putBoolean("key_is_capture_video", ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).lfl);
        localObject3 = CaptureDataManager.HKJ;
        p.j(localObject3, "CaptureDataManager.INSTANCE");
        localObject3 = ((CaptureDataManager)localObject3).getExtData();
        localObject4 = (Collection)((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).lfr;
        if ((localObject4 == null) || (((Collection)localObject4).isEmpty()))
        {
          i = 1;
          if (i != 0) {
            break label741;
          }
          bool = true;
          ((Bundle)localObject3).putBoolean("key_is_photo_video", bool);
          localObject3 = (Collection)((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).lfr;
          if ((localObject3 != null) && (!((Collection)localObject3).isEmpty())) {
            break label747;
          }
          i = 1;
          if (i != 0) {
            break label753;
          }
          localObject3 = CaptureDataManager.HKJ;
          p.j(localObject3, "CaptureDataManager.INSTANCE");
          ((CaptureDataManager)localObject3).getExtData().putStringArrayList("key_src_list", ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).lfr);
        }
      }
      else
      {
        localVideoMixer = this.HOV;
        localObject6 = this.HOV.HHa.HGS;
        localb = this.HOU;
        p.k(localObject6, "captureInfo");
        p.k(localb, "config");
      }
      label232:
      int k;
      label328:
      label371:
      label383:
      float f2;
      try
      {
        localObject3 = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).HJz;
        if (((com.tencent.mm.plugin.recordvideo.b.c)localObject6).HJA < 0L) {
          break label800;
        }
        l = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).HJA;
        k = localVideoMixer.kWG;
        if (com.tencent.mm.vfs.u.agG((String)localObject3)) {
          break label1832;
        }
        Log.i("MicroMsg.Media.VideoMixer", "create thumb bitmap : ".concat(String.valueOf(l)));
        if ((((com.tencent.mm.plugin.recordvideo.b.c)localObject6).lfl) || (Util.isNullOrNil(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).HJy))) {
          break label893;
        }
        localObject1 = com.tencent.mm.plugin.mmsight.d.bb(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).HJy, l * 1000L);
        localObject4 = (CharSequence)localVideoMixer.HHa.HHl;
        if (localObject4 == null) {
          break label2433;
        }
        if (((CharSequence)localObject4).length() != 0) {
          break label806;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            long l;
            label395:
            label438:
            label482:
            int m;
            localObject1 = ((com.tencent.mm.ui.blur.e)localObject5).b((Bitmap)localObject1, 4.0F);
            p.j(localObject1, "renderScriptBlur.blur(tmpBg, 4f)");
            ((com.tencent.mm.ui.blur.e)localObject5).destroy();
            if (localObject4 == null) {
              break;
            }
            localObject5 = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).HJE.get(0);
            p.j(localObject5, "captureInfo.fakeVideoImageList[0]");
            i = VideoMixer.aVO((String)localObject5);
            if (i == 0) {
              break;
            }
            localObject5 = new Matrix();
            ((Matrix)localObject5).postRotate(i);
            localObject4 = Bitmap.createBitmap((Bitmap)localObject4, 0, 0, ((Bitmap)localObject4).getWidth(), ((Bitmap)localObject4).getHeight(), (Matrix)localObject5, true);
            localObject5 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject5, true);
            p.j(localObject5, "Bitmap.createBitmap(bmBg…mBg.height, matrix, true)");
            localPoint = com.tencent.mm.plugin.recordvideo.b.f.HJU.fvF();
            if (localObject4 == null) {
              p.iCn();
            }
            if (((Bitmap)localObject4).getConfig() != null)
            {
              localObject1 = Bitmap.createBitmap(localPoint.x, localPoint.y, ((Bitmap)localObject4).getConfig());
              localCanvas = new Canvas((Bitmap)localObject1);
              i = ((Bitmap)localObject5).getWidth();
              j = ((Bitmap)localObject5).getHeight();
              if ((i == localPoint.x) && (j == localPoint.y)) {
                continue;
              }
              f3 = 0.0F;
              f2 = 0.0F;
              if (localPoint.y * i <= localPoint.x * j) {
                continue;
              }
              f1 = localPoint.y / j;
              f3 = (localPoint.x - i * f1) * 0.5F;
              Matrix localMatrix = new Matrix();
              localMatrix.setScale(f1, f1);
              localMatrix.postTranslate(f3, f2);
              localCanvas.drawBitmap((Bitmap)localObject5, localMatrix, null);
              i = ((Bitmap)localObject4).getWidth();
              j = ((Bitmap)localObject4).getHeight();
              if ((i == localPoint.x) && (j == localPoint.y)) {
                continue;
              }
              f3 = 0.0F;
              f2 = 0.0F;
              if (localPoint.y * i <= localPoint.x * j) {
                continue;
              }
              f1 = localPoint.x / i;
              f2 = (localPoint.y - j * f1) * 0.5F;
              localObject5 = new Matrix();
              ((Matrix)localObject5).setScale(f1, f1);
              ((Matrix)localObject5).postTranslate(f3, f2);
              localCanvas.drawBitmap((Bitmap)localObject4, (Matrix)localObject5, null);
              continue;
              localException1 = localException1;
              Log.printErrStackTrace("MicroMsg.Media.VideoMixer", (Throwable)localException1, "createGraffitiThumb error", new Object[0]);
              com.tencent.mm.plugin.recordvideo.d.f localf = com.tencent.mm.plugin.recordvideo.d.f.HUI;
              com.tencent.mm.plugin.recordvideo.d.f.fxx();
              continue;
              if (i <= m) {
                continue;
              }
              ((Point)localObject4).x = m;
              f1 = j;
              ((Point)localObject4).y = ((int)(m * f1 / i));
            }
          }
          catch (Exception localException2)
          {
            Point localPoint;
            Canvas localCanvas;
            Log.printErrStackTrace("MicroMsg.Media.VideoMixer", (Throwable)localException2, "rsblur exception", new Object[0]);
            Log.i("MicroMsg.Media.VideoMixer", "rsblur exception, path:%s", new Object[] { ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).HJE.get(0) });
            localObject2 = com.tencent.mm.plugin.recordvideo.b.f.HJU.fvF();
            localObject2 = BitmapUtil.createColorBitmap(Color.parseColor("#ff000000"), ((Point)localObject2).x, ((Point)localObject2).y);
            p.j(localObject2, "BitmapUtil.createColorBi…0000\"), point.x, point.y)");
            continue;
            localObject2 = BitmapUtil.createColorBitmap(Color.parseColor("#ff000000"), localPoint.x, localPoint.y);
            continue;
            float f1 = localPoint.x / i;
            f2 = (localPoint.y - j * f1) * 0.5F;
            continue;
            localCanvas.drawBitmap((Bitmap)localObject5, 0.0F, 0.0F, null);
            continue;
            f1 = localPoint.y / j;
            float f3 = (localPoint.x - i * f1) * 0.5F;
            continue;
            localCanvas.drawBitmap((Bitmap)localObject4, 0.0F, 0.0F, null);
          }
          continue;
          localObject2 = new BitmapFactory.Options();
          Log.i("MicroMsg.Media.VideoMixer", "exist thumb bitmap ");
          ((BitmapFactory.Options)localObject2).inMutable = true;
          localObject4 = BitmapUtil.decodeFile((String)localObject3, (BitmapFactory.Options)localObject2);
        }
        localObject2 = VideoMixer.iX(localb.targetWidth, localb.targetHeight);
        localObject5 = com.tencent.mm.plugin.recordvideo.e.e.Ife;
        localObject5 = com.tencent.mm.plugin.recordvideo.e.e.aWt(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).HJy);
        if (((com.tencent.mm.plugin.recordvideo.b.c)localObject6).lfl) {
          break label2266;
        }
      }
      if ((i != 0) || (!com.tencent.mm.vfs.u.agG(localVideoMixer.HHa.HHl)))
      {
        if (localb.kWG == 270) {
          break label2439;
        }
        if (localb.kWG == 90)
        {
          break label2439;
          if (j == 0) {
            break label818;
          }
          i = localb.targetHeight;
          if (j == 0) {
            break label828;
          }
          j = localb.targetWidth;
          f1 = i / j;
          p.j(localObject1, "originThumb");
          f2 = ((Bitmap)localObject1).getWidth() / ((Bitmap)localObject1).getHeight();
          if (f1 <= f2) {
            break label2451;
          }
          j = (int)(i / f2);
          Log.i("MicroMsg.Media.VideoMixer", "thumbHeight:" + j + " thumbWidth:" + i);
          localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, j, true);
          localObject4 = new StringBuilder("createGraffitiThumb not capture, thumb size:[");
          p.j(localObject1, "thumb");
          Log.i("MicroMsg.Media.VideoMixer", ((Bitmap)localObject1).getWidth() + ", " + ((Bitmap)localObject1).getHeight() + "], thumbRotate:" + k + ", drawingRect:" + Arrays.toString(localVideoMixer.HHa.HHg));
        }
      }
      for (;;)
      {
        localObject4 = (CharSequence)localObject3;
        if (localObject4 == null) {
          break label2445;
        }
        if (((CharSequence)localObject4).length() != 0) {
          break label2462;
        }
        break label2445;
        label585:
        if (i == 0) {
          break label2419;
        }
        localObject3 = com.tencent.mm.plugin.recordvideo.e.d.IeU;
        ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).aVR(com.tencent.mm.plugin.recordvideo.e.d.PH(cm.bfD()));
        localObject3 = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).HJz;
        localObject4 = localObject1;
        label617:
        if (localObject4 != null) {
          break label1867;
        }
        Log.e("MicroMsg.Media.VideoMixer", "createGraffitiThumb thumb is null");
        localObject1 = com.tencent.mm.plugin.recordvideo.d.f.HUI;
        com.tencent.mm.plugin.recordvideo.d.f.fxx();
        localObject1 = com.tencent.mm.plugin.recordvideo.background.e.HGz;
        localObject1 = com.tencent.mm.plugin.recordvideo.background.e.a(this.HOV, (List)this.HOZ.HJW, this.HGL, this.HPa, this.HOZ.HHl, this.$scene);
        localObject3 = com.tencent.mm.plugin.recordvideo.background.f.HGG;
        com.tencent.mm.plugin.recordvideo.background.f.fvb();
        if (this.$scene == 3)
        {
          localObject3 = com.tencent.mm.plugin.recordvideo.d.e.HUH;
          com.tencent.mm.plugin.recordvideo.d.e.wF(this.HGL.SwB);
        }
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new kotlin.g.b.q((String)localObject1) {});
        AppMethodBeat.o(75655);
        return;
        i = 0;
        break;
        label741:
        bool = false;
        break label101;
        label747:
        i = 0;
        break label138;
        label753:
        localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).lfj);
        localObject1 = CaptureDataManager.HKJ;
        p.j(localObject1, "CaptureDataManager.INSTANCE");
        ((CaptureDataManager)localObject1).getExtData().putStringArrayList("key_src_list", (ArrayList)localObject3);
        break label170;
        label800:
        l = 0L;
        break label232;
        label806:
        i = 0;
        break label328;
        j = 0;
        break label371;
        label818:
        i = localb.targetWidth;
        break label383;
        label828:
        j = localb.targetHeight;
        break label395;
        i = Math.min(localb.targetWidth, localb.targetHeight);
        p.j(localObject1, "originThumb");
        f1 = ((Bitmap)localObject1).getWidth() / i;
        localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, (int)(((Bitmap)localObject1).getHeight() / f1), true);
        break label482;
        label893:
        if (((com.tencent.mm.plugin.recordvideo.b.c)localObject6).HJE.size() != 0) {
          break label919;
        }
        localObject1 = com.tencent.mm.plugin.mmsight.d.bb(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).HJy, l);
      }
      label919:
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      BitmapFactory.decodeFile((String)((com.tencent.mm.plugin.recordvideo.b.c)localObject6).HJE.get(0), (BitmapFactory.Options)localObject1);
      int i = ((BitmapFactory.Options)localObject1).outWidth;
      int j = ((BitmapFactory.Options)localObject1).outHeight;
      m = com.tencent.mm.plugin.recordvideo.b.f.HJU.fvE();
      Object localObject4 = new Point(i, j);
      Object localObject5;
      if (i > j)
      {
        if (j > m)
        {
          ((Point)localObject4).y = m;
          f1 = i;
          ((Point)localObject4).x = ((int)(m / j * f1));
        }
        ((BitmapFactory.Options)localObject1).inSampleSize = BitmapUtil.calculateInSampleSize(i, j, com.tencent.mm.plugin.recordvideo.b.f.HJU.fvE(), com.tencent.mm.plugin.recordvideo.b.f.HJU.fvE());
        ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
        ((BitmapFactory.Options)localObject1).inMutable = true;
        localObject4 = MMBitmapFactory.decodeFile((String)((com.tencent.mm.plugin.recordvideo.b.c)localObject6).HJE.get(0), (BitmapFactory.Options)localObject1);
        ((BitmapFactory.Options)localObject1).inSampleSize = BitmapUtil.calculateInSampleSize(i, j, com.tencent.mm.plugin.recordvideo.b.f.HJU.fvE() / 2, com.tencent.mm.plugin.recordvideo.b.f.HJU.fvE() / 2);
        localObject5 = new com.tencent.mm.ui.blur.e(MMApplicationContext.getContext());
        localObject1 = MMBitmapFactory.decodeFile((String)((com.tencent.mm.plugin.recordvideo.b.c)localObject6).HJE.get(0), (BitmapFactory.Options)localObject1);
      }
      label1275:
      Object localObject2;
      label1832:
      label1867:
      if ((localObject5 != null) && (!((e.a)localObject5).Iff))
      {
        localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(localVideoMixer.HHa.HHg, localVideoMixer.HHa.HHh, localVideoMixer.HHa.uVd, ((Point)localObject2).x, ((Point)localObject2).y, ((e.a)localObject5).width, ((e.a)localObject5).height, k, false, localVideoMixer.HHa.HHl, 256));
        localVideoMixer.HGR = ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject2);
        localObject2 = localVideoMixer.HGR;
        if (localObject2 == null) {
          p.bGy("frameRetriever");
        }
        ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject2).start();
        localObject6 = (Bitmap)localVideoMixer.kVT.invoke(Long.valueOf(1L));
        localObject2 = (Bitmap)localVideoMixer.kWT.invoke(Long.valueOf(1L));
        localObject5 = localVideoMixer.HGR;
        if (localObject5 == null) {
          p.bGy("frameRetriever");
        }
        ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject5).destroy();
        if (localObject2 == null) {
          break label2412;
        }
        localObject5 = VideoMixer.a((Bitmap)localObject4, (Bitmap)localObject2, 0.0F, (localb.targetHeight - ((Bitmap)localObject4).getHeight()) / 2.0F, 4);
        localObject2 = localObject5;
        if (localObject6 != null)
        {
          if (localb.kWG == 270) {
            break label2468;
          }
          if (localb.kWG != 90) {
            break label2474;
          }
          break label2468;
        }
      }
      for (;;)
      {
        label1992:
        if (j != 0)
        {
          i = localb.targetHeight;
          label2158:
          if (j == 0) {
            break label2345;
          }
          j = localb.targetWidth;
          label2170:
          if (((Bitmap)localObject4).getWidth() <= i) {
            break label2355;
          }
          localObject2 = VideoMixer.a((Bitmap)localObject6, (Bitmap)localObject5, (((Bitmap)localObject4).getWidth() - i) / 2.0F, 0.0F, 8);
          BitmapUtil.saveBitmapToImage((Bitmap)localObject2, 70, Bitmap.CompressFormat.JPEG, (String)localObject3, true);
          localObject2 = new StringBuilder("createGraffitiThumb : ").append((String)localObject3).append("   graffiti : ");
          if (localObject6 != null) {
            break label2406;
          }
        }
        label2113:
        label2266:
        label2406:
        for (bool = true;; bool = false)
        {
          Log.i("MicroMsg.Media.VideoMixer", bool);
          break;
          localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(localVideoMixer.HHa.HHg, localVideoMixer.HHa.HHh, localVideoMixer.HHa.uVd, ((Point)localObject2).x, ((Point)localObject2).y, 0, 0, k, false, localVideoMixer.HHa.HHl, 256));
          break label1992;
          i = localb.targetWidth;
          break label2158;
          j = localb.targetHeight;
          break label2170;
          if (((Bitmap)localObject4).getHeight() > j)
          {
            localObject2 = VideoMixer.a((Bitmap)localObject6, (Bitmap)localObject5, 0.0F, (((Bitmap)localObject4).getHeight() - j) / 2.0F, 4);
            break label2203;
          }
          localObject2 = VideoMixer.a((Bitmap)localObject6, (Bitmap)localObject5, 0.0F, 0.0F, 12);
          break label2203;
        }
        label2203:
        label2345:
        label2355:
        label2412:
        localObject5 = localObject4;
        break label2113;
        label2419:
        localObject4 = localObject2;
        break label617;
        localObject5 = localObject2;
        break label1275;
        label2433:
        i = 1;
        break;
        label2439:
        j = 1;
        break label371;
        label2445:
        i = 1;
        break label585;
        label2451:
        i = (int)(j * f2);
        break label438;
        label2462:
        i = 0;
        break label585;
        label2468:
        j = 1;
        continue;
        label2474:
        j = 0;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    h(ac paramac)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final i HPc;
    
    static
    {
      AppMethodBeat.i(75658);
      HPc = new i();
      AppMethodBeat.o(75658);
    }
    
    i()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final j HPd;
    
    static
    {
      AppMethodBeat.i(75660);
      HPd = new j();
      AppMethodBeat.o(75660);
    }
    
    j()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final k HPe;
    
    static
    {
      AppMethodBeat.i(75662);
      HPe = new k();
      AppMethodBeat.o(75662);
    }
    
    k()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final l HPf;
    
    static
    {
      AppMethodBeat.i(75664);
      HPf = new l();
      AppMethodBeat.o(75664);
    }
    
    l()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.ac
 * JD-Core Version:    0.7.0.1
 */