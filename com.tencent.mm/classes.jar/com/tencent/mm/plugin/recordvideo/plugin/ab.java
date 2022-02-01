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
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.b.f.b;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer;
import com.tencent.mm.plugin.recordvideo.e.d.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.i;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.z.d;
import kotlin.g.b.z.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "abaParams", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getContext", "()Landroid/content/Context;", "setContext", "editConfig", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig;", "enable", "", "encode", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "getEncode", "()Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "setEncode", "(Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;)V", "foregroundRemuxFinishCallback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "ret", "", "getForegroundRemuxFinishCallback", "()Lkotlin/jvm/functions/Function3;", "setForegroundRemuxFinishCallback", "(Lkotlin/jvm/functions/Function3;)V", "loading", "Lcom/tencent/mm/plugin/recordvideo/ui/MediaProgressDialog;", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "x264RetryTime", "", "checkAudioCache", "audio", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "callback", "Lkotlin/Function0;", "checkBackgroundRemux", "error", "checkDaemonVideo", "checkForegroundRemux", "checkNoNeedRemuxVideo", "checkNullProvider", "checkSaveThumb", "videoPath", "thumbPath", "createMixer", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer;", "encodeConfig", "dismissDialog", "doFinish", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "forceRemux", "getMixer", "getTransformInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "runForeGround", "mixer", "runMixInBackground", "editorConfig", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "expiredTime", "", "scene", "setCaptureInfo", "info", "setMoovHead", "path", "snsCheck", "videoInfo", "Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "fileLength", "startReMux", "updateABABrWithQP", "Companion", "plugin-recordvideo_release"})
public final class ab
  implements t
{
  public static final ab.a BRV;
  private com.tencent.mm.plugin.recordvideo.ui.a BRP;
  private com.tencent.mm.media.widget.camerarecordview.b.b BRQ;
  private com.tencent.mm.plugin.recordvideo.b.f BRR;
  f.b BRS;
  public kotlin.g.a.q<? super String, ? super String, ? super Boolean, kotlin.x> BRT;
  private int BRU;
  Context context;
  private boolean enable;
  private int[] vRR;
  private RecordConfigProvider wdm;
  
  static
  {
    AppMethodBeat.i(75676);
    BRV = new ab.a((byte)0);
    AppMethodBeat.o(75676);
  }
  
  public ab(Context paramContext)
  {
    AppMethodBeat.i(75675);
    this.context = paramContext;
    this.vRR = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    this.enable = true;
    this.BRS = new f.b((byte)0);
    AppMethodBeat.o(75675);
  }
  
  private final ab W(kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(163435);
    if ((this.wdm == null) || (!this.enable))
    {
      parama.invoke();
      AppMethodBeat.o(163435);
      return null;
    }
    this.enable = false;
    AppMethodBeat.o(163435);
    return this;
  }
  
  private final ab X(kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(163436);
    if (!this.BRS.BNu)
    {
      Object localObject1 = this.BRQ;
      if ((localObject1 != null) && (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).aQo() == true))
      {
        localObject1 = this.wdm;
        if (localObject1 != null)
        {
          localObject1 = ((RecordConfigProvider)localObject1).BOm;
          if ((localObject1 != null) && (((VideoTransPara)localObject1).iTg == 1)) {}
        }
        else
        {
          localObject1 = this.wdm;
          if (localObject1 == null) {
            break label465;
          }
          localObject1 = ((RecordConfigProvider)localObject1).BOm;
          if ((localObject1 == null) || (((VideoTransPara)localObject1).iTg != 2)) {
            break label465;
          }
        }
        localObject1 = this.wdm;
        if (localObject1 != null)
        {
          localObject1 = ((RecordConfigProvider)localObject1).BOm;
          if ((localObject1 != null) && (((VideoTransPara)localObject1).iTq == 1)) {}
        }
        else
        {
          localObject1 = this.wdm;
          if (localObject1 != null)
          {
            localObject1 = ((RecordConfigProvider)localObject1).BOm;
            if ((localObject1 != null) && (((VideoTransPara)localObject1).iTq == 2)) {}
          }
          else
          {
            localObject1 = this.wdm;
            if (localObject1 == null) {
              break label465;
            }
            localObject1 = ((RecordConfigProvider)localObject1).BOm;
            if ((localObject1 == null) || (((VideoTransPara)localObject1).iTq != 4)) {
              break label465;
            }
          }
        }
        localObject1 = this.BRR;
        if (localObject1 == null) {
          p.hyc();
        }
        localObject1 = a((com.tencent.mm.plugin.recordvideo.b.f)localObject1, this.BRS);
        Object localObject2 = ((VideoMixer)localObject1).BKJ;
        if (localObject2 != null) {
          ((AdaptiveAdjustBitrate)localObject2).BNq = 3000;
        }
        int i = ((VideoMixer)localObject1).eJe();
        Log.i("MicroMsg.RemuxPlugin", "ABA: useDarmonVideo: ".concat(String.valueOf(i)));
        if (i == 0)
        {
          parama.invoke();
          parama = com.tencent.mm.plugin.recordvideo.d.g.BXY;
          com.tencent.mm.plugin.recordvideo.d.g.VO(1);
          parama = com.tencent.mm.plugin.recordvideo.d.g.BXY;
          com.tencent.mm.plugin.recordvideo.d.g.VN(1);
          AppMethodBeat.o(163436);
          return this;
        }
        localObject1 = new StringBuilder("ABA::check DarmonVideo, add the metadate for video of low bitrate path: ");
        localObject2 = this.BRQ;
        if (localObject2 == null) {
          p.hyc();
        }
        Log.i("MicroMsg.RemuxPlugin", ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).iqh);
        localObject1 = this.BRQ;
        if (localObject1 == null) {
          p.hyc();
        }
        SightVideoJNI.addReportMetadata(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).iqh, new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 1, 0);
        localObject1 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
        com.tencent.mm.plugin.recordvideo.d.g.VN(0);
        label465:
        localObject1 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
        com.tencent.mm.plugin.recordvideo.d.g.VO(0);
        localObject1 = this.wdm;
        if (localObject1 != null)
        {
          parama = new StringBuilder("daemonMediaCaptureInfo into: \ndaemonVideoPath = ");
          localObject2 = this.BRQ;
          if (localObject2 == null) {
            p.hyc();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).iqh).append(", daemonVideoSize = ");
          localObject2 = this.BRQ;
          if (localObject2 == null) {
            p.hyc();
          }
          parama = parama.append(s.boW(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).iqh)).append(", \nsourceVideoPath = ");
          localObject2 = this.BRQ;
          if (localObject2 == null) {
            p.hyc();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).iqd).append(", captureSize = ");
          localObject2 = this.BRQ;
          if (localObject2 == null) {
            p.hyc();
          }
          Log.i("MicroMsg.RemuxPlugin", s.boW(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).iqd) + ", \noutputSize = " + ((RecordConfigProvider)localObject1).BOA + ", outputSize = " + s.boW(((RecordConfigProvider)localObject1).BOA));
          parama = this.BRQ;
          if (parama == null) {
            p.hyc();
          }
          s.nw(parama.iqh, ((RecordConfigProvider)localObject1).BOA);
          parama = this.BRQ;
          if (parama == null) {
            p.hyc();
          }
          s.nw(parama.iqi, ((RecordConfigProvider)localObject1).thumbPath);
          parama = com.tencent.mm.plugin.recordvideo.e.c.Cic;
          com.tencent.mm.plugin.recordvideo.e.c.d(this.BRQ);
          parama = com.tencent.mm.plugin.recordvideo.e.c.Cic;
          com.tencent.mm.plugin.recordvideo.e.c.f((RecordConfigProvider)localObject1);
          Log.i("MicroMsg.RemuxPlugin", "daemonMediaCaptureInfo 1: " + this.BRQ);
          parama = new StringBuilder("daemonMediaCaptureInfo 2: \ndaemonVideoPath = ");
          localObject2 = this.BRQ;
          if (localObject2 == null) {
            p.hyc();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).iqh).append(", daemonVideoSize = ");
          localObject2 = this.BRQ;
          if (localObject2 == null) {
            p.hyc();
          }
          parama = parama.append(s.boW(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).iqh)).append(", \nsourceVideoPath = ");
          localObject2 = this.BRQ;
          if (localObject2 == null) {
            p.hyc();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).iqd).append(", captureSize = ");
          localObject2 = this.BRQ;
          if (localObject2 == null) {
            p.hyc();
          }
          Log.i("MicroMsg.RemuxPlugin", s.boW(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).iqd) + ", \noutputSize = " + ((RecordConfigProvider)localObject1).BOA + ", outputSize = " + s.boW(((RecordConfigProvider)localObject1).BOA));
          parama = ((RecordConfigProvider)localObject1).BOA;
          p.g(parama, "this.outputVideoPath");
          localObject2 = ((RecordConfigProvider)localObject1).thumbPath;
          p.g(localObject2, "this.thumbPath");
          jC(parama, (String)localObject2);
          parama = ((RecordConfigProvider)localObject1).BOA;
          p.g(parama, "this.outputVideoPath");
          aLr(parama);
          parama = Boolean.TRUE;
          localObject2 = ((RecordConfigProvider)localObject1).BOA;
          localObject1 = ((RecordConfigProvider)localObject1).thumbPath;
          Object localObject3 = this.BRQ;
          if (localObject3 == null) {
            p.hyc();
          }
          i = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject3).iqk;
          localObject3 = this.BRQ;
          if (localObject3 == null) {
            p.hyc();
          }
          long l = i - ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject3).iqj;
          localObject3 = Boolean.FALSE;
          com.tencent.mm.plugin.recordvideo.d.c localc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
          b(new CaptureDataManager.CaptureVideoNormalModel(parama, (String)localObject2, (String)localObject1, Long.valueOf(l), (Boolean)localObject3, com.tencent.mm.plugin.recordvideo.d.c.eKW()));
          parama = com.tencent.mm.plugin.recordvideo.d.g.BXY;
          com.tencent.mm.plugin.recordvideo.d.g.ax(1, 1L);
          AppMethodBeat.o(163436);
          return null;
        }
      }
    }
    parama.invoke();
    AppMethodBeat.o(163436);
    return this;
  }
  
  private final ab Y(kotlin.g.a.a<kotlin.x> parama)
  {
    boolean bool = false;
    AppMethodBeat.i(163437);
    Object localObject2 = this.wdm;
    if (localObject2 != null)
    {
      Object localObject1;
      if (this.BRS.BNt)
      {
        if (!this.BRS.BNu)
        {
          localObject1 = com.tencent.mm.media.b.b.idz;
          if (!com.tencent.mm.media.b.b.aLP()) {}
        }
      }
      else
      {
        localObject1 = this.BRR;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.recordvideo.b.f)localObject1).wgG;
          if (localObject1 != null) {
            break label688;
          }
          parama = this.BRQ;
          if ((parama == null) || (parama.iqf != true)) {
            break label415;
          }
          if (((RecordConfigProvider)localObject2).scene != 2) {
            break label386;
          }
          parama = com.tencent.mm.media.k.e.ilC;
          com.tencent.mm.media.k.e.aNU();
          label106:
          parama = com.tencent.mm.plugin.recordvideo.e.c.Cic;
          com.tencent.mm.plugin.recordvideo.e.c.g(this.wdm);
          parama = ((RecordConfigProvider)localObject2).BOA;
          p.g(parama, "this.outputVideoPath");
          localObject1 = ((RecordConfigProvider)localObject2).thumbPath;
          p.g(localObject1, "this.thumbPath");
          jC(parama, (String)localObject1);
          parama = ((RecordConfigProvider)localObject2).BOA;
          p.g(parama, "this.outputVideoPath");
          aLr(parama);
          parama = this.BRQ;
          if (parama != null)
          {
            localObject1 = CaptureDataManager.BOb;
            p.g(localObject1, "CaptureDataManager.INSTANCE");
            ((CaptureDataManager)localObject1).getExtData().putBoolean("key_is_capture_video", parama.iqf);
            localObject1 = CaptureDataManager.BOb;
            p.g(localObject1, "CaptureDataManager.INSTANCE");
            localObject1 = ((CaptureDataManager)localObject1).getExtData();
            parama = (Collection)parama.iqm;
            if ((parama != null) && (!parama.isEmpty())) {
              break label405;
            }
            i = 1;
            label250:
            if (i != 0) {
              break label410;
            }
          }
        }
        Object localObject3;
        long l;
        com.tencent.mm.plugin.recordvideo.d.c localc;
        label386:
        label405:
        label410:
        for (bool = true;; bool = false)
        {
          ((Bundle)localObject1).putBoolean("key_is_photo_video", bool);
          parama = Boolean.TRUE;
          localObject1 = ((RecordConfigProvider)localObject2).BOA;
          localObject2 = ((RecordConfigProvider)localObject2).thumbPath;
          localObject3 = this.BRR;
          if (localObject3 == null) {
            p.hyc();
          }
          i = ((com.tencent.mm.plugin.recordvideo.b.f)localObject3).BNq;
          localObject3 = this.BRR;
          if (localObject3 == null) {
            p.hyc();
          }
          l = i - ((com.tencent.mm.plugin.recordvideo.b.f)localObject3).BNp;
          localObject3 = Boolean.FALSE;
          localc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
          b(new CaptureDataManager.CaptureVideoNormalModel(parama, (String)localObject1, (String)localObject2, Long.valueOf(l), (Boolean)localObject3, com.tencent.mm.plugin.recordvideo.d.c.eKW()));
          parama = com.tencent.mm.plugin.recordvideo.d.g.BXY;
          com.tencent.mm.plugin.recordvideo.d.g.ax(1, 1L);
          AppMethodBeat.o(163437);
          return null;
          localObject1 = null;
          break;
          if (((RecordConfigProvider)localObject2).scene != 1) {
            break label106;
          }
          parama = com.tencent.mm.media.k.e.ilC;
          com.tencent.mm.media.k.e.aNV();
          break label106;
          i = 0;
          break label250;
        }
        label415:
        parama = this.BRQ;
        if (parama == null) {
          p.hyc();
        }
        parama = parama.iqd;
        localObject1 = ((RecordConfigProvider)localObject2).thumbPath;
        p.g(localObject1, "this.thumbPath");
        jC(parama, (String)localObject1);
        parama = this.BRQ;
        if (parama == null) {
          p.hyc();
        }
        aLr(parama.iqd);
        parama = this.BRQ;
        if (parama != null)
        {
          localObject1 = CaptureDataManager.BOb;
          p.g(localObject1, "CaptureDataManager.INSTANCE");
          ((CaptureDataManager)localObject1).getExtData().putBoolean("key_is_capture_video", parama.iqf);
          localObject1 = CaptureDataManager.BOb;
          p.g(localObject1, "CaptureDataManager.INSTANCE");
          localObject1 = ((CaptureDataManager)localObject1).getExtData();
          parama = (Collection)parama.iqm;
          if ((parama != null) && (!parama.isEmpty())) {
            break label683;
          }
        }
        label683:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            bool = true;
          }
          ((Bundle)localObject1).putBoolean("key_is_photo_video", bool);
          parama = Boolean.TRUE;
          localObject1 = this.BRQ;
          if (localObject1 == null) {
            p.hyc();
          }
          localObject1 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).iqd;
          localObject2 = ((RecordConfigProvider)localObject2).thumbPath;
          localObject3 = this.BRR;
          if (localObject3 == null) {
            p.hyc();
          }
          i = ((com.tencent.mm.plugin.recordvideo.b.f)localObject3).BNq;
          localObject3 = this.BRR;
          if (localObject3 == null) {
            p.hyc();
          }
          l = i - ((com.tencent.mm.plugin.recordvideo.b.f)localObject3).BNp;
          localObject3 = Boolean.FALSE;
          localc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
          b(new CaptureDataManager.CaptureVideoNormalModel(parama, (String)localObject1, (String)localObject2, Long.valueOf(l), (Boolean)localObject3, com.tencent.mm.plugin.recordvideo.d.c.eKW()));
          break;
        }
      }
    }
    label688:
    parama.invoke();
    AppMethodBeat.o(163437);
    return this;
  }
  
  private final ab Z(kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(163438);
    Object localObject = this.wdm;
    if ((localObject != null) && (p.j(((RecordConfigProvider)localObject).BOt, Boolean.TRUE)))
    {
      parama = this.BRR;
      if (parama == null) {
        p.hyc();
      }
      parama = a(parama, this.BRS);
      localObject = com.tencent.mm.plugin.recordvideo.d.f.BXU;
      com.tencent.mm.plugin.recordvideo.d.f.to(true);
      localObject = this.BRR;
      if (localObject == null) {
        p.hyc();
      }
      a(parama, (com.tencent.mm.plugin.recordvideo.b.f)localObject, this.BRS);
      AppMethodBeat.o(163438);
      return null;
    }
    parama.invoke();
    AppMethodBeat.o(163438);
    return this;
  }
  
  private final VideoMixer a(com.tencent.mm.plugin.recordvideo.b.f paramf, f.b paramb)
  {
    AppMethodBeat.i(75668);
    VideoMixer localVideoMixer = b(paramf);
    RecordConfigProvider localRecordConfigProvider = this.wdm;
    float f;
    if ((localRecordConfigProvider != null) && (localRecordConfigProvider.scene == 2)) {
      f = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYU, 1.0F);
    }
    for (;;)
    {
      Log.i("MicroMsg.RemuxPlugin", "final kbps: " + f + "  " + paramb.videoBitrate * f);
      VideoMixer.a(localVideoMixer, paramb.targetWidth, paramb.targetHeight, (int)(f * paramb.videoBitrate), paramb.audioBitrate, paramb.audioSampleRate, paramb.audioChannelCount, paramb.frameRate, paramb.ihS);
      paramb = this.wdm;
      if (paramb != null) {}
      for (paramb = paramb.BOm;; paramb = null)
      {
        if (paramb == null) {
          p.hyc();
        }
        localVideoMixer.a(paramb, paramf.BNq, paramf.BNp);
        AppMethodBeat.o(75668);
        return localVideoMixer;
        localRecordConfigProvider = this.wdm;
        if (localRecordConfigProvider != null)
        {
          if (localRecordConfigProvider.scene != 1) {
            break label227;
          }
          f = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYT, 1.0F);
          break;
        }
        f = 1.0F;
        break;
      }
      label227:
      f = 1.0F;
    }
  }
  
  private final void a(f.b paramb)
  {
    AppMethodBeat.i(75674);
    Object localObject = com.tencent.mm.media.k.e.ilC;
    com.tencent.mm.media.k.e.aOh();
    long l = Util.currentTicks();
    Log.i("MicroMsg.RemuxPlugin", "start forceRemux");
    localObject = this.wdm;
    String str;
    int i;
    int j;
    label197:
    label215:
    int k;
    if (localObject != null)
    {
      localObject = ((RecordConfigProvider)localObject).BOA;
      str = p.I((String)localObject, "_tmp");
      localObject = this.wdm;
      if (localObject == null) {
        p.hyc();
      }
      if (((RecordConfigProvider)localObject).BOm.iTh != 2) {
        break label421;
      }
      localObject = this.wdm;
      if (localObject == null) {
        p.hyc();
      }
      i = ((RecordConfigProvider)localObject).BOm.idF;
      localObject = this.wdm;
      if (localObject == null) {
        p.hyc();
      }
      Log.i("MicroMsg.RemuxPlugin", "ABA: Using Min Max QP Limitation: [%d], [%d] ", new Object[] { Integer.valueOf(i), Integer.valueOf(((RecordConfigProvider)localObject).BOm.idG) });
      localObject = this.wdm;
      if (localObject == null) {
        p.hyc();
      }
      i = ((RecordConfigProvider)localObject).BOm.idF;
      localObject = this.wdm;
      if (localObject == null) {
        p.hyc();
      }
      j = ((RecordConfigProvider)localObject).BOm.idG;
      localObject = this.wdm;
      if (localObject == null) {
        break label429;
      }
      localObject = ((RecordConfigProvider)localObject).BOA;
      k = paramb.targetWidth;
      int m = paramb.targetHeight;
      int n = paramb.videoBitrate;
      RecordConfigProvider localRecordConfigProvider = this.wdm;
      if (localRecordConfigProvider == null) {
        p.hyc();
      }
      int i1 = localRecordConfigProvider.BOm.iSV;
      localRecordConfigProvider = this.wdm;
      if (localRecordConfigProvider == null) {
        p.hyc();
      }
      k = SightVideoJNI.remuxingVFS((String)localObject, str, k, m, n, i1, 8, localRecordConfigProvider.BOm.iSU, 25.0F, paramb.frameRate, null, 0, false, i, j);
      paramb = this.wdm;
      if (paramb == null) {
        break label435;
      }
    }
    label421:
    label429:
    label435:
    for (paramb = paramb.BOA;; paramb = null)
    {
      s.nw(str, paramb);
      s.deleteFile(str);
      l = Util.ticksToNow(l);
      Log.i("MicroMsg.RemuxPlugin", "minQP :" + i + "  maxQP :" + j + "  duration:" + k + " cost:" + l);
      paramb = com.tencent.mm.media.k.e.ilC;
      com.tencent.mm.media.k.e.zM(l);
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
  
  private final void a(final VideoMixer paramVideoMixer, final com.tencent.mm.plugin.recordvideo.b.f paramf, final f.b paramb)
  {
    AppMethodBeat.i(75669);
    if (this.BRP == null)
    {
      localObject = new com.tencent.mm.plugin.recordvideo.ui.a();
      ((com.tencent.mm.plugin.recordvideo.ui.a)localObject).b(this.context, (kotlin.g.a.a)ab.e.BSe);
      this.BRP = ((com.tencent.mm.plugin.recordvideo.ui.a)localObject);
    }
    Object localObject = com.tencent.mm.plugin.recordvideo.background.f.BKw;
    com.tencent.mm.plugin.recordvideo.background.f.V((kotlin.g.a.a)new f(this, paramb, paramVideoMixer, paramf));
    AppMethodBeat.o(75669);
  }
  
  private final void a(final AudioCacheInfo paramAudioCacheInfo, final kotlin.g.a.a<kotlin.x> parama)
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
        bool1 = paramAudioCacheInfo.aXa;
      }
      Log.i("MicroMsg.RemuxPlugin", bool1);
      localObject = new com.tencent.mm.plugin.recordvideo.ui.a();
      ((com.tencent.mm.plugin.recordvideo.ui.a)localObject).b(this.context, (kotlin.g.a.a)ab.b.BRW);
      this.BRP = ((com.tencent.mm.plugin.recordvideo.ui.a)localObject);
      if ((paramAudioCacheInfo == null) || (paramAudioCacheInfo.aXa)) {
        break;
      }
      Log.i("MicroMsg.RemuxPlugin", "checkAudioCache false");
      localObject = i.BPL;
      i.eKl().a(this.context, paramAudioCacheInfo, (m)new c(this, paramAudioCacheInfo, parama));
      AppMethodBeat.o(163440);
      return;
    }
    Log.i("MicroMsg.RemuxPlugin", "checkAudioCache done");
    parama.invoke();
    AppMethodBeat.o(163440);
  }
  
  private static void aLr(String paramString)
  {
    AppMethodBeat.i(75667);
    long l = Util.currentTicks();
    SightVideoJNI.optimizeMP4VFS(paramString);
    Log.d("MicroMsg.RemuxPlugin", "time cost: " + Util.ticksToNow(l));
    AppMethodBeat.o(75667);
  }
  
  private final ab aa(kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(163439);
    Object localObject1 = com.tencent.mm.plugin.recordvideo.d.f.BXU;
    com.tencent.mm.plugin.recordvideo.d.f.to(false);
    localObject1 = this.BRR;
    if (localObject1 == null) {
      p.hyc();
    }
    localObject1 = a((com.tencent.mm.plugin.recordvideo.b.f)localObject1, this.BRS);
    RecordConfigProvider localRecordConfigProvider = this.wdm;
    if (localRecordConfigProvider != null)
    {
      final z.f localf = new z.f();
      localf.SYG = new ald();
      parama = (ald)localf.SYG;
      Object localObject2 = this.BRR;
      if (localObject2 == null) {
        p.hyc();
      }
      int i = ((com.tencent.mm.plugin.recordvideo.b.f)localObject2).BNq;
      localObject2 = this.BRR;
      if (localObject2 == null) {
        p.hyc();
      }
      parama.duration = (i - ((com.tencent.mm.plugin.recordvideo.b.f)localObject2).BNp);
      ((ald)localf.SYG).Luc = new LinkedList((Collection)kotlin.a.e.W(this.vRR));
      localObject2 = (ald)localf.SYG;
      parama = localRecordConfigProvider.BOm;
      if (parama != null)
      {
        parama = Integer.valueOf(parama.iTg);
        if (parama == null) {
          p.hyc();
        }
        ((ald)localObject2).iTg = parama.intValue();
        parama = (ald)localf.SYG;
        localObject2 = this.BRQ;
        if (localObject2 == null) {
          break label418;
        }
      }
      label418:
      for (boolean bool = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).iqf;; bool = false)
      {
        parama.Lud = bool;
        ((ald)localf.SYG).Gvu = this.BRS.BNu;
        ((ald)localf.SYG).BOx = localRecordConfigProvider.BOx;
        ((ald)localf.SYG).BOy = localRecordConfigProvider.BOy;
        ((ald)localf.SYG).BOz = localRecordConfigProvider.BOz;
        ((ald)localf.SYG).BOA = localRecordConfigProvider.BOA;
        ((ald)localf.SYG).Lue = localRecordConfigProvider.thumbPath;
        ((ald)localf.SYG).BLF = ((VideoMixer)localObject1).BKP.iiC;
        ((ald)localf.SYG).Luf = 0;
        parama = this.BRR;
        if (parama == null) {
          p.hyc();
        }
        a(parama.wgG, (kotlin.g.a.a)new d(localRecordConfigProvider, localf, this, (VideoMixer)localObject1));
        parama = com.tencent.mm.plugin.recordvideo.d.g.BXY;
        com.tencent.mm.plugin.recordvideo.d.g.VP(0);
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
  
  private final VideoMixer b(com.tencent.mm.plugin.recordvideo.b.f paramf)
  {
    AppMethodBeat.i(75670);
    long l = System.currentTimeMillis();
    Object localObject1 = this.wdm;
    if (localObject1 != null)
    {
      localObject2 = ((RecordConfigProvider)localObject1).BOA;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
      localObject1 = com.tencent.mm.plugin.recordvideo.e.c.aLL(String.valueOf(l));
    }
    Object localObject2 = this.wdm;
    if (localObject2 != null)
    {
      localObject3 = ((RecordConfigProvider)localObject2).thumbPath;
      localObject2 = localObject3;
      if (localObject3 != null) {}
    }
    else
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
      localObject2 = com.tencent.mm.plugin.recordvideo.e.c.aLM(String.valueOf(l));
    }
    Object localObject3 = this.wdm;
    int k;
    boolean bool1;
    boolean bool2;
    label154:
    int i;
    label174:
    label207:
    boolean bool4;
    label306:
    int j;
    label334:
    label363:
    boolean bool3;
    label391:
    boolean bool5;
    if (localObject3 != null)
    {
      k = ((RecordConfigProvider)localObject3).scene;
      bool1 = false;
      if ((k != 2) && (k != 11)) {
        break label733;
      }
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYP, 0) != 1) {
        break label714;
      }
      bool2 = true;
      i = ae.gKA.gJo;
      if (i == -1) {
        break label726;
      }
      if (i != 1) {
        break label720;
      }
      bool1 = true;
      Log.i("MicroMsg.RemuxPlugin", "sns config use x264 encode: " + bool2 + ", deviceUseX264Encode:" + i);
      bool4 = bool1;
      if (MultiProcessMMKV.getSingleDefault().getBoolean("mediacodec_create_error", false)) {
        bool4 = true;
      }
      Log.i("MicroMsg.RemuxPlugin", "final useX264Encode: ".concat(String.valueOf(bool4)));
      localObject3 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
      com.tencent.mm.plugin.recordvideo.d.g.ts(bool4);
      localObject3 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
      com.tencent.mm.plugin.recordvideo.d.g.tt(com.tencent.mm.plugin.sight.base.b.eVr());
      bool1 = false;
      if ((k != 2) && (k != 1)) {
        break label1099;
      }
      switch (k)
      {
      default: 
        i = -1;
        switch (k)
        {
        default: 
          j = -1;
          switch (k)
          {
          default: 
            bool1 = false;
            switch (k)
            {
            default: 
              bool2 = false;
              Log.i("MicroMsg.RemuxPlugin", "checkEnableHevc, deviceSwEnableHevc:" + i + ", deviceHwEnableHevc:" + j + ", exptSwEnableHevc:" + bool1 + ", exptHwEnableHevc:" + bool2);
              bool3 = false;
              bool5 = false;
              if ((bool1) || (i != -1))
              {
                if (i == 1) {
                  bool3 = true;
                }
              }
              else
              {
                label469:
                if ((bool2) || (j != -1))
                {
                  if (j != 1) {
                    break label1038;
                  }
                  bool5 = true;
                }
                label487:
                bool1 = false;
                if (!bool4) {
                  break label1061;
                }
                bool1 = bool3;
                bool2 = bool4;
                label503:
                Log.i("MicroMsg.RemuxPlugin", "checkEnableHevc, hwEnableHevc:" + bool5 + ", swEnableHevc:" + bool3 + ", enableHevc:" + bool1 + ", useSoftEncode:" + bool2);
              }
              break;
            }
            break;
          }
          break;
        }
        break;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.recordvideo.b.c localc = c(paramf);
      if ((k == 3) && (!s.YS(localc.BMT)))
      {
        localObject3 = com.tencent.mm.plugin.recordvideo.d.e.BXT;
        com.tencent.mm.plugin.recordvideo.d.e.tn(localc.iqf);
      }
      List localList = (List)paramf.BNn;
      float[] arrayOfFloat1 = paramf.BKV;
      float[] arrayOfFloat2 = paramf.BKW;
      localObject3 = this.wdm;
      if (localObject3 != null)
      {
        localObject3 = ((RecordConfigProvider)localObject3).BOm;
        if (localObject3 == null) {}
      }
      for (i = ((VideoTransPara)localObject3).iTf;; i = 0)
      {
        localObject3 = paramf.BLa;
        paramf = (com.tencent.mm.plugin.recordvideo.b.f)localObject3;
        if (localObject3 == null) {
          paramf = "";
        }
        paramf = new VideoMixer(new com.tencent.mm.plugin.recordvideo.background.a.a(localc, localList, arrayOfFloat1, arrayOfFloat2, (String)localObject1, (String)localObject2, 0, bool2, bool1, i, paramf, 64));
        AppMethodBeat.o(75670);
        return paramf;
        k = 0;
        break;
        label714:
        bool2 = false;
        break label154;
        label720:
        bool1 = false;
        break label174;
        label726:
        bool1 = bool2;
        break label174;
        label733:
        if (k != 1) {
          break label207;
        }
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYQ, 0) == 1)
        {
          bool2 = true;
          label764:
          i = ae.gKA.gJn;
          if (i == -1) {
            break label832;
          }
          if (i != 1) {
            break label826;
          }
          bool1 = true;
        }
        for (;;)
        {
          Log.i("MicroMsg.RemuxPlugin", "c2c config use x264 encode: " + bool2 + ", deviceUseX264Encode:" + i);
          break;
          bool2 = false;
          break label764;
          label826:
          bool1 = false;
          continue;
          label832:
          bool1 = bool2;
        }
        i = ae.gKA.gJy;
        break label306;
        i = ae.gKA.gJz;
        break label306;
        j = ae.gKA.gJw;
        break label334;
        j = ae.gKA.gJx;
        break label334;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sjZ, 0) == 1)
        {
          bool1 = true;
          break label363;
        }
        bool1 = false;
        break label363;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sjY, 0) == 1)
        {
          bool1 = true;
          break label363;
        }
        bool1 = false;
        break label363;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sjW, 0) == 1)
        {
          bool2 = true;
          break label391;
        }
        bool2 = false;
        break label391;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sjX, 0) == 1)
        {
          bool2 = true;
          break label391;
        }
        bool2 = false;
        break label391;
        if ((bool1) && (i == 2))
        {
          bool3 = false;
          break label469;
        }
        bool3 = bool1;
        break label469;
        label1038:
        if ((bool2) && (j == 2))
        {
          bool5 = false;
          break label487;
        }
        bool5 = bool2;
        break label487;
        label1061:
        if (bool3)
        {
          bool2 = true;
          bool1 = true;
          break label503;
        }
        bool2 = bool4;
        if (!bool5) {
          break label503;
        }
        bool1 = true;
        bool2 = bool4;
        break label503;
      }
      label1099:
      bool2 = bool4;
    }
  }
  
  private final void b(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(75672);
    MultiProcessMMKV.getSingleDefault().putBoolean("mediacodec_create_error", false);
    CaptureDataManager.BOb.a(this.context, paramCaptureVideoNormalModel);
    AppMethodBeat.o(75672);
  }
  
  private final com.tencent.mm.plugin.recordvideo.b.c c(com.tencent.mm.plugin.recordvideo.b.f paramf)
  {
    boolean bool = true;
    AppMethodBeat.i(75671);
    com.tencent.mm.plugin.recordvideo.b.c localc = new com.tencent.mm.plugin.recordvideo.b.c();
    Object localObject = this.BRQ;
    String str;
    if (localObject != null)
    {
      str = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).iqd;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localc.aLo((String)localObject);
    localObject = this.BRQ;
    if (localObject != null)
    {
      str = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).iqe;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localc.aLp((String)localObject);
    localc.uPh = paramf.wgG;
    int i;
    if (paramf.BNc) {
      if (localc.uPh == null) {
        i = 0;
      }
    }
    for (;;)
    {
      localc.BMY = i;
      localObject = this.BRQ;
      if (localObject != null) {
        bool = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).iqf;
      }
      localc.iqf = bool;
      localc.ihS = SightVideoJNI.getMp4RotateVFS(localc.BMT);
      localc.BMV = paramf.BNp;
      localc.BMW = paramf.BNq;
      localc.aI(paramf.BNr);
      Log.i("MicroMsg.RemuxPlugin", "getTransformInfo :".concat(String.valueOf(localc)));
      AppMethodBeat.o(75671);
      return localc;
      i = 2;
      continue;
      if (localc.uPh == null) {
        i = 1;
      } else {
        i = 3;
      }
    }
  }
  
  private final void jC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(75673);
    if (s.YS(paramString2)) {
      s.deleteFile(paramString2);
    }
    paramString1 = com.tencent.mm.plugin.mmsight.d.PF(paramString1);
    Object localObject;
    if (paramString1 != null)
    {
      localObject = com.tencent.mm.plugin.recordvideo.e.c.Cic;
      localObject = this.wdm;
      if (localObject == null) {
        break label84;
      }
      localObject = ((RecordConfigProvider)localObject).BOm;
      if (localObject == null) {
        break label84;
      }
    }
    label84:
    for (int i = ((VideoTransPara)localObject).iTf;; i = 0)
    {
      BitmapUtil.saveBitmapToImage(com.tencent.mm.plugin.recordvideo.e.c.j(paramString1, i), 60, Bitmap.CompressFormat.JPEG, paramString2, true);
      AppMethodBeat.o(75673);
      return;
    }
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(75665);
    p.h(paramb, "info");
    p.h(paramRecordConfigProvider, "configProvider");
    this.BRQ = paramb;
    this.wdm = paramRecordConfigProvider;
    paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.d.c.BXI;
    com.tencent.mm.plugin.recordvideo.d.c.x("KEY_IS_CAPUTRE_BOOLEAN", Boolean.valueOf(paramb.iqf));
    if (paramb.iqf)
    {
      paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_CAPUTRE_VIDEO_PATH_STRING", paramb.aQq());
      paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      if (!paramb.aQp()) {
        break label98;
      }
    }
    label98:
    for (paramb = paramb.iqe;; paramb = paramb.iqi)
    {
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_CAPUTRE_THUMB_PATH_STRING", paramb);
      AppMethodBeat.o(75665);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.b.f paramf)
  {
    AppMethodBeat.i(75666);
    p.h(paramf, "editConfig");
    Log.i("MicroMsg.RemuxPlugin", "startReMux !!!!");
    Object localObject = W((kotlin.g.a.a)new ab.h(this));
    if (localObject != null)
    {
      ((ab)localObject).BRR = paramf;
      ((ab)localObject).BRS = paramf.a(((ab)localObject).wdm, ((ab)localObject).BRQ);
      Log.i("MicroMsg.RemuxPlugin", "configProvider : " + ((ab)localObject).wdm);
      Log.i("MicroMsg.RemuxPlugin", "RemuxMediaEditConfig : ".concat(String.valueOf(paramf)));
      Log.i("MicroMsg.RemuxPlugin", "mediaCaptureInfo : " + ((ab)localObject).BRQ);
      Log.i("MicroMsg.RemuxPlugin", "generateTargetConfig info: " + ((ab)localObject).BRS + ' ');
      paramf = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_VIDEO_IS_EDITED_BOOLEAN", Boolean.valueOf(((ab)localObject).BRS.BNu));
      paramf = com.tencent.mm.media.k.e.ilC;
      com.tencent.mm.media.k.e.aNX();
      if (((ab)localObject).BRS.BNu)
      {
        paramf = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aNW();
      }
      if (localObject != null)
      {
        paramf = ((ab)localObject).X((kotlin.g.a.a)ab.i.BSn);
        if (paramf != null)
        {
          localObject = com.tencent.mm.plugin.recordvideo.e.c.Cic;
          com.tencent.mm.plugin.recordvideo.e.c.d(paramf.BRQ);
          if (paramf != null)
          {
            paramf = paramf.Y((kotlin.g.a.a)ab.j.BSo);
            if (paramf != null)
            {
              paramf = paramf.Z((kotlin.g.a.a)ab.k.BSp);
              if (paramf != null)
              {
                paramf.aa((kotlin.g.a.a)ab.l.BSq);
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
  
  public final void aSs() {}
  
  public final String name()
  {
    return null;
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
    AppMethodBeat.i(237353);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237353);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "<anonymous parameter 1>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements m<Boolean, String, kotlin.x>
  {
    c(ab paramab, AudioCacheInfo paramAudioCacheInfo, kotlin.g.a.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin$checkBackgroundRemux$1$1"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    d(RecordConfigProvider paramRecordConfigProvider, z.f paramf, ab paramab, VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    f(ab paramab, f.b paramb, VideoMixer paramVideoMixer, com.tencent.mm.plugin.recordvideo.b.f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(ab paramab, VideoMixer paramVideoMixer, f.b paramb, com.tencent.mm.plugin.recordvideo.b.f paramf, ald paramald, long paramLong, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(75655);
      Object localObject1 = ab.f(this.BRX);
      Object localObject3;
      boolean bool;
      label101:
      VideoMixer localVideoMixer;
      label138:
      label170:
      Object localObject6;
      f.b localb;
      if (localObject1 != null)
      {
        localObject3 = CaptureDataManager.BOb;
        p.g(localObject3, "CaptureDataManager.INSTANCE");
        ((CaptureDataManager)localObject3).getExtData().putBoolean("key_is_capture_video", ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).iqf);
        localObject3 = CaptureDataManager.BOb;
        p.g(localObject3, "CaptureDataManager.INSTANCE");
        localObject3 = ((CaptureDataManager)localObject3).getExtData();
        localObject4 = (Collection)((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).iqm;
        if ((localObject4 == null) || (((Collection)localObject4).isEmpty()))
        {
          i = 1;
          if (i != 0) {
            break label741;
          }
          bool = true;
          ((Bundle)localObject3).putBoolean("key_is_photo_video", bool);
          localObject3 = (Collection)((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).iqm;
          if ((localObject3 != null) && (!((Collection)localObject3).isEmpty())) {
            break label747;
          }
          i = 1;
          if (i != 0) {
            break label753;
          }
          localObject3 = CaptureDataManager.BOb;
          p.g(localObject3, "CaptureDataManager.INSTANCE");
          ((CaptureDataManager)localObject3).getExtData().putStringArrayList("key_src_list", ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).iqm);
        }
      }
      else
      {
        localVideoMixer = this.BSg;
        localObject6 = this.BSg.BKP.BKI;
        localb = this.BSf;
        p.h(localObject6, "captureInfo");
        p.h(localb, "config");
      }
      label232:
      int k;
      label328:
      label371:
      label383:
      float f2;
      try
      {
        localObject3 = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).BMU;
        if (((com.tencent.mm.plugin.recordvideo.b.c)localObject6).BMV < 0L) {
          break label800;
        }
        l = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).BMV;
        k = localVideoMixer.ihS;
        if (s.YS((String)localObject3)) {
          break label1832;
        }
        Log.i("MicroMsg.Media.VideoMixer", "create thumb bitmap : ".concat(String.valueOf(l)));
        if ((((com.tencent.mm.plugin.recordvideo.b.c)localObject6).iqf) || (Util.isNullOrNil(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).BMT))) {
          break label893;
        }
        localObject1 = com.tencent.mm.plugin.mmsight.d.ba(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).BMT, l * 1000L);
        localObject4 = (CharSequence)localVideoMixer.BKP.BLa;
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
            p.g(localObject1, "renderScriptBlur.blur(tmpBg, 4f)");
            ((com.tencent.mm.ui.blur.e)localObject5).destroy();
            if (localObject4 == null) {
              break;
            }
            localObject5 = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).BMZ.get(0);
            p.g(localObject5, "captureInfo.fakeVideoImageList[0]");
            i = VideoMixer.aLm((String)localObject5);
            if (i == 0) {
              break;
            }
            localObject5 = new Matrix();
            ((Matrix)localObject5).postRotate(i);
            localObject4 = Bitmap.createBitmap((Bitmap)localObject4, 0, 0, ((Bitmap)localObject4).getWidth(), ((Bitmap)localObject4).getHeight(), (Matrix)localObject5, true);
            localObject5 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject5, true);
            p.g(localObject5, "Bitmap.createBitmap(bmBg…mBg.height, matrix, true)");
            localPoint = com.tencent.mm.plugin.recordvideo.b.e.BNm.eJv();
            if (localObject4 == null) {
              p.hyc();
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
              com.tencent.mm.plugin.recordvideo.d.f localf = com.tencent.mm.plugin.recordvideo.d.f.BXU;
              com.tencent.mm.plugin.recordvideo.d.f.eLe();
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
            Log.i("MicroMsg.Media.VideoMixer", "rsblur exception, path:%s", new Object[] { ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).BMZ.get(0) });
            localObject2 = com.tencent.mm.plugin.recordvideo.b.e.BNm.eJv();
            localObject2 = BitmapUtil.createColorBitmap(Color.parseColor("#ff000000"), ((Point)localObject2).x, ((Point)localObject2).y);
            p.g(localObject2, "BitmapUtil.createColorBi…0000\"), point.x, point.y)");
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
        localObject2 = VideoMixer.hS(localb.targetWidth, localb.targetHeight);
        localObject5 = com.tencent.mm.plugin.recordvideo.e.d.Cin;
        localObject5 = com.tencent.mm.plugin.recordvideo.e.d.aLQ(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).BMT);
        if (((com.tencent.mm.plugin.recordvideo.b.c)localObject6).iqf) {
          break label2266;
        }
      }
      if ((i != 0) || (!s.YS(localVideoMixer.BKP.BLa)))
      {
        if (localb.ihS == 270) {
          break label2439;
        }
        if (localb.ihS == 90)
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
          p.g(localObject1, "originThumb");
          f2 = ((Bitmap)localObject1).getWidth() / ((Bitmap)localObject1).getHeight();
          if (f1 <= f2) {
            break label2451;
          }
          j = (int)(i / f2);
          Log.i("MicroMsg.Media.VideoMixer", "thumbHeight:" + j + " thumbWidth:" + i);
          localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, j, true);
          localObject4 = new StringBuilder("createGraffitiThumb not capture, thumb size:[");
          p.g(localObject1, "thumb");
          Log.i("MicroMsg.Media.VideoMixer", ((Bitmap)localObject1).getWidth() + ", " + ((Bitmap)localObject1).getHeight() + "], thumbRotate:" + k + ", drawingRect:" + Arrays.toString(localVideoMixer.BKP.BKV));
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
        localObject3 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
        ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).aLp(com.tencent.mm.plugin.recordvideo.e.c.In(cl.aWz()));
        localObject3 = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).BMU;
        localObject4 = localObject1;
        label617:
        if (localObject4 != null) {
          break label1867;
        }
        Log.e("MicroMsg.Media.VideoMixer", "createGraffitiThumb thumb is null");
        localObject1 = com.tencent.mm.plugin.recordvideo.d.f.BXU;
        com.tencent.mm.plugin.recordvideo.d.f.eLe();
        localObject1 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
        localObject1 = com.tencent.mm.plugin.recordvideo.background.e.a(this.BSg, (List)this.BSk.BNo, this.BKB, this.BSl, this.BSk.BLa, this.$scene);
        localObject3 = com.tencent.mm.plugin.recordvideo.background.f.BKw;
        com.tencent.mm.plugin.recordvideo.background.f.eIX();
        if (this.$scene == 3)
        {
          localObject3 = com.tencent.mm.plugin.recordvideo.d.e.BXT;
          com.tencent.mm.plugin.recordvideo.d.e.tj(this.BKB.Lud);
        }
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new kotlin.g.b.q((String)localObject1) {});
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
        ((ArrayList)localObject3).add(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).iqd);
        localObject1 = CaptureDataManager.BOb;
        p.g(localObject1, "CaptureDataManager.INSTANCE");
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
        p.g(localObject1, "originThumb");
        f1 = ((Bitmap)localObject1).getWidth() / i;
        localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, (int)(((Bitmap)localObject1).getHeight() / f1), true);
        break label482;
        label893:
        if (((com.tencent.mm.plugin.recordvideo.b.c)localObject6).BMZ.size() != 0) {
          break label919;
        }
        localObject1 = com.tencent.mm.plugin.mmsight.d.ba(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).BMT, l);
      }
      label919:
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      BitmapFactory.decodeFile((String)((com.tencent.mm.plugin.recordvideo.b.c)localObject6).BMZ.get(0), (BitmapFactory.Options)localObject1);
      int i = ((BitmapFactory.Options)localObject1).outWidth;
      int j = ((BitmapFactory.Options)localObject1).outHeight;
      m = com.tencent.mm.plugin.recordvideo.b.e.BNm.getMaxSize();
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
        ((BitmapFactory.Options)localObject1).inSampleSize = BitmapUtil.calculateInSampleSize(i, j, com.tencent.mm.plugin.recordvideo.b.e.BNm.getMaxSize(), com.tencent.mm.plugin.recordvideo.b.e.BNm.getMaxSize());
        ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
        ((BitmapFactory.Options)localObject1).inMutable = true;
        localObject4 = MMBitmapFactory.decodeFile((String)((com.tencent.mm.plugin.recordvideo.b.c)localObject6).BMZ.get(0), (BitmapFactory.Options)localObject1);
        ((BitmapFactory.Options)localObject1).inSampleSize = BitmapUtil.calculateInSampleSize(i, j, com.tencent.mm.plugin.recordvideo.b.e.BNm.getMaxSize() / 2, com.tencent.mm.plugin.recordvideo.b.e.BNm.getMaxSize() / 2);
        localObject5 = new com.tencent.mm.ui.blur.e(MMApplicationContext.getContext());
        localObject1 = MMBitmapFactory.decodeFile((String)((com.tencent.mm.plugin.recordvideo.b.c)localObject6).BMZ.get(0), (BitmapFactory.Options)localObject1);
      }
      label1275:
      Object localObject2;
      label1832:
      label1867:
      if ((localObject5 != null) && (!((d.a)localObject5).Cio))
      {
        localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(localVideoMixer.BKP.BKV, localVideoMixer.BKP.BKW, localVideoMixer.BKP.rpx, ((Point)localObject2).x, ((Point)localObject2).y, ((d.a)localObject5).width, ((d.a)localObject5).height, k, false, localVideoMixer.BKP.BLa, 256));
        localVideoMixer.BKH = ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject2);
        localObject2 = localVideoMixer.BKH;
        if (localObject2 == null) {
          p.btv("frameRetriever");
        }
        ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject2).start();
        localObject6 = (Bitmap)localVideoMixer.ihf.invoke(Long.valueOf(1L));
        localObject2 = (Bitmap)localVideoMixer.iif.invoke(Long.valueOf(1L));
        localObject5 = localVideoMixer.BKH;
        if (localObject5 == null) {
          p.btv("frameRetriever");
        }
        ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject5).destroy();
        if (localObject2 == null) {
          break label2412;
        }
        localObject5 = VideoMixer.a((Bitmap)localObject4, (Bitmap)localObject2, 0.0F, (localb.targetHeight - ((Bitmap)localObject4).getHeight()) / 2.0F, 4);
        localObject2 = localObject5;
        if (localObject6 != null)
        {
          if (localb.ihS == 270) {
            break label2468;
          }
          if (localb.ihS != 90) {
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
          localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(localVideoMixer.BKP.BKV, localVideoMixer.BKP.BKW, localVideoMixer.BKP.rpx, ((Point)localObject2).x, ((Point)localObject2).y, 0, 0, k, false, localVideoMixer.BKP.BLa, 256));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.ab
 * JD-Core Version:    0.7.0.1
 */