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
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.cf;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.b.f.b;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer;
import com.tencent.mm.plugin.recordvideo.e.c.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.m;
import d.g.a.r;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.d;
import d.g.b.y.f;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "abaParams", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getContext", "()Landroid/content/Context;", "setContext", "editConfig", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig;", "enable", "", "encode", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "getEncode", "()Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "setEncode", "(Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;)V", "loading", "Lcom/tencent/mm/plugin/recordvideo/ui/MediaProgressDialog;", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "x264RetryTime", "", "checkAudioCache", "", "audio", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "callback", "Lkotlin/Function0;", "checkBackgroundRemux", "error", "checkDaemonVideo", "checkForegroundRemux", "checkNoNeedRemuxVideo", "checkNullProvider", "checkSaveThumb", "videoPath", "", "thumbPath", "createMixer", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer;", "encodeConfig", "doFinish", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "forceRemux", "getMixer", "getTransformInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "runForeGround", "mixer", "runMixInBackground", "editorConfig", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "expiredTime", "", "scene", "setCaptureInfo", "info", "setMoovHead", "path", "snsCheck", "videoInfo", "Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "fileLength", "startReMux", "updateABABrWithQP", "Companion", "plugin-recordvideo_release"})
public final class ab
  implements t
{
  public static final ab.a xBV;
  Context context;
  private boolean enable;
  private int[] sIH;
  private RecordConfigProvider sNI;
  private com.tencent.mm.plugin.recordvideo.ui.a xBQ;
  private com.tencent.mm.media.widget.camerarecordview.b.b xBR;
  private com.tencent.mm.plugin.recordvideo.b.f xBS;
  f.b xBT;
  private int xBU;
  
  static
  {
    AppMethodBeat.i(75676);
    xBV = new ab.a((byte)0);
    AppMethodBeat.o(75676);
  }
  
  public ab(Context paramContext)
  {
    AppMethodBeat.i(75675);
    this.context = paramContext;
    this.sIH = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    this.enable = true;
    this.xBT = new f.b((byte)0);
    AppMethodBeat.o(75675);
  }
  
  private final ab D(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(163435);
    if ((this.sNI == null) || (!this.enable))
    {
      parama.invoke();
      AppMethodBeat.o(163435);
      return null;
    }
    this.enable = false;
    AppMethodBeat.o(163435);
    return this;
  }
  
  private final ab E(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(163436);
    if (!this.xBT.xxr)
    {
      Object localObject1 = this.xBR;
      if ((localObject1 != null) && (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).axB() == true))
      {
        localObject1 = this.sNI;
        if (localObject1 != null)
        {
          localObject1 = ((RecordConfigProvider)localObject1).xyj;
          if ((localObject1 != null) && (((VideoTransPara)localObject1).hVq == 1)) {}
        }
        else
        {
          localObject1 = this.sNI;
          if (localObject1 == null) {
            break label440;
          }
          localObject1 = ((RecordConfigProvider)localObject1).xyj;
          if ((localObject1 == null) || (((VideoTransPara)localObject1).hVq != 2)) {
            break label440;
          }
        }
        localObject1 = this.sNI;
        if (localObject1 != null)
        {
          localObject1 = ((RecordConfigProvider)localObject1).xyj;
          if ((localObject1 != null) && (((VideoTransPara)localObject1).hVA == 1)) {}
        }
        else
        {
          localObject1 = this.sNI;
          if (localObject1 != null)
          {
            localObject1 = ((RecordConfigProvider)localObject1).xyj;
            if ((localObject1 != null) && (((VideoTransPara)localObject1).hVA == 2)) {}
          }
          else
          {
            localObject1 = this.sNI;
            if (localObject1 == null) {
              break label440;
            }
            localObject1 = ((RecordConfigProvider)localObject1).xyj;
            if ((localObject1 == null) || (((VideoTransPara)localObject1).hVA != 4)) {
              break label440;
            }
          }
        }
        localObject1 = this.xBS;
        if (localObject1 == null) {
          p.gfZ();
        }
        localObject1 = a((com.tencent.mm.plugin.recordvideo.b.f)localObject1, this.xBT);
        Object localObject2 = ((VideoMixer)localObject1).xuI;
        if (localObject2 != null) {
          ((AdaptiveAdjustBitrate)localObject2).xxn = 3000;
        }
        int i = ((VideoMixer)localObject1).dFa();
        ad.i("MicroMsg.RemuxPlugin", "ABA: useDarmonVideo: ".concat(String.valueOf(i)));
        if (i == 1)
        {
          parama.invoke();
          AppMethodBeat.o(163436);
          return this;
        }
        localObject1 = new StringBuilder("ABA::check DarmonVideo, add the metadate for video of low bitrate path: ");
        localObject2 = this.xBR;
        if (localObject2 == null) {
          p.gfZ();
        }
        ad.i("MicroMsg.RemuxPlugin", ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).htR);
        localObject1 = this.xBR;
        if (localObject1 == null) {
          p.gfZ();
        }
        SightVideoJNI.addReportMetadata(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).htR, new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 1, 0);
        label440:
        localObject1 = this.sNI;
        if (localObject1 != null)
        {
          parama = new StringBuilder("daemonMediaCaptureInfo into: \ndaemonVideoPath = ");
          localObject2 = this.xBR;
          if (localObject2 == null) {
            p.gfZ();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).htR).append(", daemonVideoSize = ");
          localObject2 = this.xBR;
          if (localObject2 == null) {
            p.gfZ();
          }
          parama = parama.append(com.tencent.mm.vfs.i.aYo(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).htR)).append(", \nsourceVideoPath = ");
          localObject2 = this.xBR;
          if (localObject2 == null) {
            p.gfZ();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).htN).append(", captureSize = ");
          localObject2 = this.xBR;
          if (localObject2 == null) {
            p.gfZ();
          }
          ad.i("MicroMsg.RemuxPlugin", com.tencent.mm.vfs.i.aYo(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).htN) + ", \noutputSize = " + ((RecordConfigProvider)localObject1).xyx + ", outputSize = " + com.tencent.mm.vfs.i.aYo(((RecordConfigProvider)localObject1).xyx));
          parama = this.xBR;
          if (parama == null) {
            p.gfZ();
          }
          com.tencent.mm.vfs.i.mz(parama.htR, ((RecordConfigProvider)localObject1).xyx);
          parama = this.xBR;
          if (parama == null) {
            p.gfZ();
          }
          com.tencent.mm.vfs.i.mz(parama.htS, ((RecordConfigProvider)localObject1).thumbPath);
          parama = com.tencent.mm.plugin.recordvideo.e.b.xRl;
          com.tencent.mm.plugin.recordvideo.e.b.c(this.xBR);
          parama = com.tencent.mm.plugin.recordvideo.e.b.xRl;
          com.tencent.mm.plugin.recordvideo.e.b.f((RecordConfigProvider)localObject1);
          ad.i("MicroMsg.RemuxPlugin", "daemonMediaCaptureInfo 1: " + this.xBR);
          parama = new StringBuilder("daemonMediaCaptureInfo 2: \ndaemonVideoPath = ");
          localObject2 = this.xBR;
          if (localObject2 == null) {
            p.gfZ();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).htR).append(", daemonVideoSize = ");
          localObject2 = this.xBR;
          if (localObject2 == null) {
            p.gfZ();
          }
          parama = parama.append(com.tencent.mm.vfs.i.aYo(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).htR)).append(", \nsourceVideoPath = ");
          localObject2 = this.xBR;
          if (localObject2 == null) {
            p.gfZ();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).htN).append(", captureSize = ");
          localObject2 = this.xBR;
          if (localObject2 == null) {
            p.gfZ();
          }
          ad.i("MicroMsg.RemuxPlugin", com.tencent.mm.vfs.i.aYo(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).htN) + ", \noutputSize = " + ((RecordConfigProvider)localObject1).xyx + ", outputSize = " + com.tencent.mm.vfs.i.aYo(((RecordConfigProvider)localObject1).xyx));
          parama = ((RecordConfigProvider)localObject1).xyx;
          p.g(parama, "this.outputVideoPath");
          localObject2 = ((RecordConfigProvider)localObject1).thumbPath;
          p.g(localObject2, "this.thumbPath");
          iK(parama, (String)localObject2);
          parama = ((RecordConfigProvider)localObject1).xyx;
          p.g(parama, "this.outputVideoPath");
          avK(parama);
          parama = Boolean.TRUE;
          localObject2 = ((RecordConfigProvider)localObject1).xyx;
          localObject1 = ((RecordConfigProvider)localObject1).thumbPath;
          Object localObject3 = this.xBR;
          if (localObject3 == null) {
            p.gfZ();
          }
          i = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject3).htU;
          localObject3 = this.xBR;
          if (localObject3 == null) {
            p.gfZ();
          }
          long l = i - ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject3).htT;
          localObject3 = Boolean.FALSE;
          com.tencent.mm.plugin.recordvideo.d.c localc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
          b(new CaptureDataManager.CaptureVideoNormalModel(parama, (String)localObject2, (String)localObject1, Long.valueOf(l), (Boolean)localObject3, com.tencent.mm.plugin.recordvideo.d.c.dGK()));
          AppMethodBeat.o(163436);
          return null;
        }
      }
    }
    parama.invoke();
    AppMethodBeat.o(163436);
    return this;
  }
  
  private final ab F(d.g.a.a<z> parama)
  {
    boolean bool = true;
    AppMethodBeat.i(163437);
    Object localObject2 = this.sNI;
    if (localObject2 != null)
    {
      Object localObject1;
      if (this.xBT.xxq)
      {
        if (!this.xBT.xxr)
        {
          localObject1 = com.tencent.mm.media.b.b.hhO;
          if (!com.tencent.mm.media.b.b.ata()) {}
        }
      }
      else
      {
        localObject1 = this.xBS;
        label106:
        int i;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.recordvideo.b.f)localObject1).xxj;
          if (localObject1 != null) {
            break label682;
          }
          parama = this.xBR;
          if ((parama == null) || (parama.htP != true)) {
            break label406;
          }
          if (((RecordConfigProvider)localObject2).scene != 2) {
            break label377;
          }
          parama = com.tencent.mm.media.k.d.hoU;
          com.tencent.mm.media.k.d.auS();
          parama = com.tencent.mm.plugin.recordvideo.e.b.xRl;
          com.tencent.mm.plugin.recordvideo.e.b.g(this.sNI);
          parama = ((RecordConfigProvider)localObject2).xyx;
          p.g(parama, "this.outputVideoPath");
          localObject1 = ((RecordConfigProvider)localObject2).thumbPath;
          p.g(localObject1, "this.thumbPath");
          iK(parama, (String)localObject1);
          parama = ((RecordConfigProvider)localObject2).xyx;
          p.g(parama, "this.outputVideoPath");
          avK(parama);
          parama = this.xBR;
          if (parama != null)
          {
            localObject1 = CaptureDataManager.xxY;
            p.g(localObject1, "CaptureDataManager.INSTANCE");
            ((CaptureDataManager)localObject1).getExtData().putBoolean("key_is_capture_video", parama.htP);
            localObject1 = CaptureDataManager.xxY;
            p.g(localObject1, "CaptureDataManager.INSTANCE");
            localObject1 = ((CaptureDataManager)localObject1).getExtData();
            parama = (Collection)parama.htW;
            if ((parama != null) && (!parama.isEmpty())) {
              break label396;
            }
            i = 1;
            label250:
            if (i != 0) {
              break label401;
            }
          }
        }
        Object localObject3;
        long l;
        com.tencent.mm.plugin.recordvideo.d.c localc;
        label396:
        label401:
        for (bool = true;; bool = false)
        {
          ((Bundle)localObject1).putBoolean("key_is_photo_video", bool);
          parama = Boolean.TRUE;
          localObject1 = ((RecordConfigProvider)localObject2).xyx;
          localObject2 = ((RecordConfigProvider)localObject2).thumbPath;
          localObject3 = this.xBS;
          if (localObject3 == null) {
            p.gfZ();
          }
          i = ((com.tencent.mm.plugin.recordvideo.b.f)localObject3).xxn;
          localObject3 = this.xBS;
          if (localObject3 == null) {
            p.gfZ();
          }
          l = i - ((com.tencent.mm.plugin.recordvideo.b.f)localObject3).xxm;
          localObject3 = Boolean.FALSE;
          localc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
          b(new CaptureDataManager.CaptureVideoNormalModel(parama, (String)localObject1, (String)localObject2, Long.valueOf(l), (Boolean)localObject3, com.tencent.mm.plugin.recordvideo.d.c.dGK()));
          AppMethodBeat.o(163437);
          return null;
          localObject1 = null;
          break;
          label377:
          if (((RecordConfigProvider)localObject2).scene != 1) {
            break label106;
          }
          parama = com.tencent.mm.media.k.d.hoU;
          com.tencent.mm.media.k.d.auT();
          break label106;
          i = 0;
          break label250;
        }
        label406:
        parama = this.xBR;
        if (parama == null) {
          p.gfZ();
        }
        parama = parama.htN;
        localObject1 = ((RecordConfigProvider)localObject2).thumbPath;
        p.g(localObject1, "this.thumbPath");
        iK(parama, (String)localObject1);
        parama = this.xBR;
        if (parama == null) {
          p.gfZ();
        }
        avK(parama.htN);
        parama = this.xBR;
        if (parama != null)
        {
          localObject1 = CaptureDataManager.xxY;
          p.g(localObject1, "CaptureDataManager.INSTANCE");
          ((CaptureDataManager)localObject1).getExtData().putBoolean("key_is_capture_video", parama.htP);
          localObject1 = CaptureDataManager.xxY;
          p.g(localObject1, "CaptureDataManager.INSTANCE");
          localObject1 = ((CaptureDataManager)localObject1).getExtData();
          parama = (Collection)parama.htW;
          if ((parama != null) && (!parama.isEmpty())) {
            break label672;
          }
          i = 1;
          label544:
          if (i != 0) {
            break label677;
          }
        }
        for (;;)
        {
          ((Bundle)localObject1).putBoolean("key_is_photo_video", bool);
          parama = Boolean.TRUE;
          localObject1 = this.xBR;
          if (localObject1 == null) {
            p.gfZ();
          }
          localObject1 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).htN;
          localObject2 = ((RecordConfigProvider)localObject2).thumbPath;
          localObject3 = this.xBS;
          if (localObject3 == null) {
            p.gfZ();
          }
          i = ((com.tencent.mm.plugin.recordvideo.b.f)localObject3).xxn;
          localObject3 = this.xBS;
          if (localObject3 == null) {
            p.gfZ();
          }
          l = i - ((com.tencent.mm.plugin.recordvideo.b.f)localObject3).xxm;
          localObject3 = Boolean.FALSE;
          localc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
          b(new CaptureDataManager.CaptureVideoNormalModel(parama, (String)localObject1, (String)localObject2, Long.valueOf(l), (Boolean)localObject3, com.tencent.mm.plugin.recordvideo.d.c.dGK()));
          break;
          label672:
          i = 0;
          break label544;
          label677:
          bool = false;
        }
      }
    }
    label682:
    parama.invoke();
    AppMethodBeat.o(163437);
    return this;
  }
  
  private final ab G(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(163438);
    Object localObject = this.sNI;
    if ((localObject != null) && (p.i(((RecordConfigProvider)localObject).xyq, Boolean.TRUE)))
    {
      parama = this.xBS;
      if (parama == null) {
        p.gfZ();
      }
      parama = a(parama, this.xBT);
      localObject = com.tencent.mm.plugin.recordvideo.d.f.xHm;
      com.tencent.mm.plugin.recordvideo.d.f.pV(true);
      localObject = this.xBS;
      if (localObject == null) {
        p.gfZ();
      }
      a(parama, (com.tencent.mm.plugin.recordvideo.b.f)localObject, this.xBT);
      AppMethodBeat.o(163438);
      return null;
    }
    parama.invoke();
    AppMethodBeat.o(163438);
    return this;
  }
  
  private final ab H(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(163439);
    Object localObject1 = com.tencent.mm.plugin.recordvideo.d.f.xHm;
    com.tencent.mm.plugin.recordvideo.d.f.pV(false);
    localObject1 = this.xBS;
    if (localObject1 == null) {
      p.gfZ();
    }
    localObject1 = a((com.tencent.mm.plugin.recordvideo.b.f)localObject1, this.xBT);
    RecordConfigProvider localRecordConfigProvider = this.sNI;
    if (localRecordConfigProvider != null)
    {
      final y.f localf = new y.f();
      localf.MLV = new aif();
      parama = (aif)localf.MLV;
      Object localObject2 = this.xBS;
      if (localObject2 == null) {
        p.gfZ();
      }
      int i = ((com.tencent.mm.plugin.recordvideo.b.f)localObject2).xxn;
      localObject2 = this.xBS;
      if (localObject2 == null) {
        p.gfZ();
      }
      parama.duration = (i - ((com.tencent.mm.plugin.recordvideo.b.f)localObject2).xxm);
      ((aif)localf.MLV).GfG = new LinkedList((Collection)d.a.e.N(this.sIH));
      localObject2 = (aif)localf.MLV;
      parama = localRecordConfigProvider.xyj;
      if (parama != null)
      {
        parama = Integer.valueOf(parama.hVq);
        if (parama == null) {
          p.gfZ();
        }
        ((aif)localObject2).hVq = parama.intValue();
        parama = (aif)localf.MLV;
        localObject2 = this.xBR;
        if (localObject2 == null) {
          break label410;
        }
      }
      label410:
      for (boolean bool = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).htP;; bool = false)
      {
        parama.GfH = bool;
        ((aif)localf.MLV).BDq = this.xBT.xxr;
        ((aif)localf.MLV).xyu = localRecordConfigProvider.xyu;
        ((aif)localf.MLV).xyv = localRecordConfigProvider.xyv;
        ((aif)localf.MLV).xyw = localRecordConfigProvider.xyw;
        ((aif)localf.MLV).xyx = localRecordConfigProvider.xyx;
        ((aif)localf.MLV).GfI = localRecordConfigProvider.thumbPath;
        ((aif)localf.MLV).xvD = ((VideoMixer)localObject1).xuO.hms;
        ((aif)localf.MLV).GfJ = 0;
        parama = this.xBS;
        if (parama == null) {
          p.gfZ();
        }
        a(parama.xxj, (d.g.a.a)new d(localRecordConfigProvider, localf, this, (VideoMixer)localObject1));
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
  
  private final VideoMixer a(com.tencent.mm.plugin.recordvideo.b.f paramf, f.b paramb)
  {
    AppMethodBeat.i(75668);
    VideoMixer localVideoMixer = b(paramf);
    RecordConfigProvider localRecordConfigProvider = this.sNI;
    float f;
    if ((localRecordConfigProvider != null) && (localRecordConfigProvider.scene == 2)) {
      f = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyC, 1.0F);
    }
    for (;;)
    {
      ad.i("MicroMsg.RemuxPlugin", "final kbps: " + f + "  " + paramb.videoBitrate * f);
      VideoMixer.a(localVideoMixer, paramb.targetWidth, paramb.targetHeight, (int)(f * paramb.videoBitrate), paramb.audioBitrate, paramb.audioSampleRate, paramb.audioChannelCount, paramb.frameRate, paramb.hlJ);
      paramb = this.sNI;
      if (paramb != null) {}
      for (paramb = paramb.xyj;; paramb = null)
      {
        if (paramb == null) {
          p.gfZ();
        }
        localVideoMixer.a(paramb, paramf.xxn, paramf.xxm);
        AppMethodBeat.o(75668);
        return localVideoMixer;
        localRecordConfigProvider = this.sNI;
        if (localRecordConfigProvider != null)
        {
          if (localRecordConfigProvider.scene != 1) {
            break label227;
          }
          f = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyB, 1.0F);
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
    Object localObject = com.tencent.mm.media.k.d.hoU;
    com.tencent.mm.media.k.d.avf();
    long l = bt.HI();
    ad.i("MicroMsg.RemuxPlugin", "start forceRemux");
    localObject = this.sNI;
    String str;
    int i;
    int j;
    label197:
    label215:
    int k;
    if (localObject != null)
    {
      localObject = ((RecordConfigProvider)localObject).xyx;
      str = p.C((String)localObject, "_tmp");
      localObject = this.sNI;
      if (localObject == null) {
        p.gfZ();
      }
      if (((RecordConfigProvider)localObject).xyj.hVr != 2) {
        break label421;
      }
      localObject = this.sNI;
      if (localObject == null) {
        p.gfZ();
      }
      i = ((RecordConfigProvider)localObject).xyj.hhV;
      localObject = this.sNI;
      if (localObject == null) {
        p.gfZ();
      }
      ad.i("MicroMsg.RemuxPlugin", "ABA: Using Min Max QP Limitation: [%d], [%d] ", new Object[] { Integer.valueOf(i), Integer.valueOf(((RecordConfigProvider)localObject).xyj.hhW) });
      localObject = this.sNI;
      if (localObject == null) {
        p.gfZ();
      }
      i = ((RecordConfigProvider)localObject).xyj.hhV;
      localObject = this.sNI;
      if (localObject == null) {
        p.gfZ();
      }
      j = ((RecordConfigProvider)localObject).xyj.hhW;
      localObject = this.sNI;
      if (localObject == null) {
        break label429;
      }
      localObject = ((RecordConfigProvider)localObject).xyx;
      k = paramb.targetWidth;
      int m = paramb.targetHeight;
      int n = paramb.videoBitrate;
      RecordConfigProvider localRecordConfigProvider = this.sNI;
      if (localRecordConfigProvider == null) {
        p.gfZ();
      }
      int i1 = localRecordConfigProvider.xyj.hVf;
      localRecordConfigProvider = this.sNI;
      if (localRecordConfigProvider == null) {
        p.gfZ();
      }
      k = SightVideoJNI.remuxingVFS((String)localObject, str, k, m, n, i1, 8, localRecordConfigProvider.xyj.hVe, 25.0F, paramb.frameRate, null, 0, false, i, j);
      paramb = this.sNI;
      if (paramb == null) {
        break label435;
      }
    }
    label421:
    label429:
    label435:
    for (paramb = paramb.xyx;; paramb = null)
    {
      com.tencent.mm.vfs.i.mz(str, paramb);
      com.tencent.mm.vfs.i.deleteFile(str);
      l = bt.aO(l);
      ad.i("MicroMsg.RemuxPlugin", "minQP :" + i + "  maxQP :" + j + "  duration:" + k + " cost:" + l);
      paramb = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.rt(l);
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
    if (this.xBQ == null)
    {
      localObject = new com.tencent.mm.plugin.recordvideo.ui.a();
      ((com.tencent.mm.plugin.recordvideo.ui.a)localObject).a(this.context, (d.g.a.a)ab.e.xCe);
      this.xBQ = ((com.tencent.mm.plugin.recordvideo.ui.a)localObject);
    }
    Object localObject = com.tencent.mm.plugin.recordvideo.background.f.xuv;
    com.tencent.mm.plugin.recordvideo.background.f.C((d.g.a.a)new f(this, paramb, paramVideoMixer, paramf));
    AppMethodBeat.o(75669);
  }
  
  private final void a(final AudioCacheInfo paramAudioCacheInfo, final d.g.a.a<z> parama)
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
        bool1 = paramAudioCacheInfo.aXj;
      }
      ad.i("MicroMsg.RemuxPlugin", bool1);
      localObject = new com.tencent.mm.plugin.recordvideo.ui.a();
      ((com.tencent.mm.plugin.recordvideo.ui.a)localObject).a(this.context, (d.g.a.a)ab.b.xBW);
      this.xBQ = ((com.tencent.mm.plugin.recordvideo.ui.a)localObject);
      if ((paramAudioCacheInfo == null) || (paramAudioCacheInfo.aXj)) {
        break;
      }
      ad.i("MicroMsg.RemuxPlugin", "checkAudioCache false");
      localObject = com.tencent.mm.plugin.recordvideo.model.audio.i.xzM;
      com.tencent.mm.plugin.recordvideo.model.audio.i.dGi().a(this.context, paramAudioCacheInfo, (m)new c(this, paramAudioCacheInfo, parama));
      AppMethodBeat.o(163440);
      return;
    }
    ad.i("MicroMsg.RemuxPlugin", "checkAudioCache done");
    parama.invoke();
    AppMethodBeat.o(163440);
  }
  
  private static void avK(String paramString)
  {
    AppMethodBeat.i(75667);
    long l = bt.HI();
    SightVideoJNI.optimizeMP4VFS(paramString);
    ad.d("MicroMsg.RemuxPlugin", "time cost: " + bt.aO(l));
    AppMethodBeat.o(75667);
  }
  
  private final VideoMixer b(com.tencent.mm.plugin.recordvideo.b.f paramf)
  {
    AppMethodBeat.i(75670);
    long l = System.currentTimeMillis();
    Object localObject1 = this.sNI;
    if (localObject1 != null)
    {
      localObject2 = ((RecordConfigProvider)localObject1).xyx;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.e.b.xRl;
      localObject1 = com.tencent.mm.plugin.recordvideo.e.b.avY(String.valueOf(l));
    }
    Object localObject2 = this.sNI;
    if (localObject2 != null)
    {
      localObject3 = ((RecordConfigProvider)localObject2).thumbPath;
      localObject2 = localObject3;
      if (localObject3 != null) {}
    }
    else
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.e.b.xRl;
      localObject2 = com.tencent.mm.plugin.recordvideo.e.b.avZ(String.valueOf(l));
    }
    Object localObject3 = this.sNI;
    int k;
    boolean bool1;
    boolean bool2;
    label154:
    int i;
    label174:
    label207:
    boolean bool4;
    label286:
    int j;
    label314:
    label343:
    label371:
    boolean bool3;
    boolean bool5;
    if (localObject3 != null)
    {
      k = ((RecordConfigProvider)localObject3).scene;
      bool1 = false;
      if ((k != 2) && (k != 11)) {
        break label713;
      }
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyx, 0) != 1) {
        break label694;
      }
      bool2 = true;
      i = ae.gcL.gbH;
      if (i == -1) {
        break label706;
      }
      if (i != 1) {
        break label700;
      }
      bool1 = true;
      ad.i("MicroMsg.RemuxPlugin", "sns config use x264 encode: " + bool2 + ", deviceUseX264Encode:" + i);
      bool4 = bool1;
      if (ax.flg().getBoolean("mediacodec_create_error", false)) {
        bool4 = true;
      }
      ad.i("MicroMsg.RemuxPlugin", "final useX264Encode: ".concat(String.valueOf(bool4)));
      bool1 = false;
      if ((k != 2) && (k != 1)) {
        break label1079;
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
              ad.i("MicroMsg.RemuxPlugin", "checkEnableHevc, deviceSwEnableHevc:" + i + ", deviceHwEnableHevc:" + j + ", exptSwEnableHevc:" + bool1 + ", exptHwEnableHevc:" + bool2);
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
                label449:
                if ((bool2) || (j != -1))
                {
                  if (j != 1) {
                    break label1018;
                  }
                  bool5 = true;
                }
                label467:
                bool1 = false;
                if (!bool4) {
                  break label1041;
                }
                bool1 = bool3;
                bool2 = bool4;
                label483:
                ad.i("MicroMsg.RemuxPlugin", "checkEnableHevc, hwEnableHevc:" + bool5 + ", swEnableHevc:" + bool3 + ", enableHevc:" + bool1 + ", useSoftEncode:" + bool2);
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
      if ((k == 3) && (!com.tencent.mm.vfs.i.fv(localc.xwP)))
      {
        localObject3 = com.tencent.mm.plugin.recordvideo.d.e.xHl;
        com.tencent.mm.plugin.recordvideo.d.e.pU(localc.htP);
      }
      List localList = (List)paramf.xxk;
      float[] arrayOfFloat1 = paramf.xuU;
      float[] arrayOfFloat2 = paramf.xuV;
      localObject3 = this.sNI;
      if (localObject3 != null)
      {
        localObject3 = ((RecordConfigProvider)localObject3).xyj;
        if (localObject3 == null) {}
      }
      for (i = ((VideoTransPara)localObject3).hVp;; i = 0)
      {
        localObject3 = paramf.xuZ;
        paramf = (com.tencent.mm.plugin.recordvideo.b.f)localObject3;
        if (localObject3 == null) {
          paramf = "";
        }
        paramf = new VideoMixer(new com.tencent.mm.plugin.recordvideo.background.a.a(localc, localList, arrayOfFloat1, arrayOfFloat2, (String)localObject1, (String)localObject2, 0, bool2, bool1, i, paramf, 64));
        AppMethodBeat.o(75670);
        return paramf;
        k = 0;
        break;
        label694:
        bool2 = false;
        break label154;
        label700:
        bool1 = false;
        break label174;
        label706:
        bool1 = bool2;
        break label174;
        label713:
        if (k != 1) {
          break label207;
        }
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyy, 0) == 1)
        {
          bool2 = true;
          label744:
          i = ae.gcL.gbG;
          if (i == -1) {
            break label812;
          }
          if (i != 1) {
            break label806;
          }
          bool1 = true;
        }
        for (;;)
        {
          ad.i("MicroMsg.RemuxPlugin", "c2c config use x264 encode: " + bool2 + ", deviceUseX264Encode:" + i);
          break;
          bool2 = false;
          break label744;
          label806:
          bool1 = false;
          continue;
          label812:
          bool1 = bool2;
        }
        i = ae.gcL.gbR;
        break label286;
        i = ae.gcL.gbS;
        break label286;
        j = ae.gcL.gbP;
        break label314;
        j = ae.gcL.gbQ;
        break label314;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFy, 0) == 1)
        {
          bool1 = true;
          break label343;
        }
        bool1 = false;
        break label343;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFx, 0) == 1)
        {
          bool1 = true;
          break label343;
        }
        bool1 = false;
        break label343;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFv, 0) == 1)
        {
          bool2 = true;
          break label371;
        }
        bool2 = false;
        break label371;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFw, 0) == 1)
        {
          bool2 = true;
          break label371;
        }
        bool2 = false;
        break label371;
        if ((bool1) && (i == 2))
        {
          bool3 = false;
          break label449;
        }
        bool3 = bool1;
        break label449;
        label1018:
        if ((bool2) && (j == 2))
        {
          bool5 = false;
          break label467;
        }
        bool5 = bool2;
        break label467;
        label1041:
        if (bool3)
        {
          bool2 = true;
          bool1 = true;
          break label483;
        }
        bool2 = bool4;
        if (!bool5) {
          break label483;
        }
        bool1 = true;
        bool2 = bool4;
        break label483;
      }
      label1079:
      bool2 = bool4;
    }
  }
  
  private final void b(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(75672);
    ax.flg().putBoolean("mediacodec_create_error", false);
    CaptureDataManager.xxY.a(this.context, paramCaptureVideoNormalModel);
    AppMethodBeat.o(75672);
  }
  
  private final com.tencent.mm.plugin.recordvideo.b.c c(com.tencent.mm.plugin.recordvideo.b.f paramf)
  {
    boolean bool = true;
    AppMethodBeat.i(75671);
    com.tencent.mm.plugin.recordvideo.b.c localc = new com.tencent.mm.plugin.recordvideo.b.c();
    Object localObject = this.xBR;
    String str;
    if (localObject != null)
    {
      str = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).htN;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localc.avH((String)localObject);
    localObject = this.xBR;
    if (localObject != null)
    {
      str = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).htO;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localc.avI((String)localObject);
    localc.xwV = paramf.xxj;
    int i;
    if (paramf.xwZ) {
      if (localc.xwV == null) {
        i = 0;
      }
    }
    for (;;)
    {
      localc.xwU = i;
      localObject = this.xBR;
      if (localObject != null) {
        bool = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).htP;
      }
      localc.htP = bool;
      localc.hlJ = SightVideoJNI.getMp4RotateVFS(localc.xwP);
      localc.xwR = paramf.xxm;
      localc.xwS = paramf.xxn;
      localc.aq(paramf.xxo);
      ad.i("MicroMsg.RemuxPlugin", "getTransformInfo :".concat(String.valueOf(localc)));
      AppMethodBeat.o(75671);
      return localc;
      i = 2;
      continue;
      if (localc.xwV == null) {
        i = 1;
      } else {
        i = 3;
      }
    }
  }
  
  private final void iK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(75673);
    if (com.tencent.mm.vfs.i.fv(paramString2)) {
      com.tencent.mm.vfs.i.deleteFile(paramString2);
    }
    paramString1 = com.tencent.mm.plugin.mmsight.d.Gq(paramString1);
    Object localObject;
    if (paramString1 != null)
    {
      localObject = com.tencent.mm.plugin.recordvideo.e.b.xRl;
      localObject = this.sNI;
      if (localObject == null) {
        break label84;
      }
      localObject = ((RecordConfigProvider)localObject).xyj;
      if (localObject == null) {
        break label84;
      }
    }
    label84:
    for (int i = ((VideoTransPara)localObject).hVp;; i = 0)
    {
      com.tencent.mm.sdk.platformtools.g.a(com.tencent.mm.plugin.recordvideo.e.b.h(paramString1, i), 60, Bitmap.CompressFormat.JPEG, paramString2, true);
      AppMethodBeat.o(75673);
      return;
    }
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(75665);
    p.h(paramb, "info");
    p.h(paramRecordConfigProvider, "configProvider");
    this.xBR = paramb;
    this.sNI = paramRecordConfigProvider;
    paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.d.c.xHa;
    com.tencent.mm.plugin.recordvideo.d.c.u("KEY_IS_CAPUTRE_BOOLEAN", Boolean.valueOf(paramb.htP));
    if (paramb.htP)
    {
      paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_CAPUTRE_VIDEO_PATH_STRING", paramb.axD());
      paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      if (!paramb.axC()) {
        break label98;
      }
    }
    label98:
    for (paramb = paramb.htO;; paramb = paramb.htS)
    {
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_CAPUTRE_THUMB_PATH_STRING", paramb);
      AppMethodBeat.o(75665);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.b.f paramf)
  {
    AppMethodBeat.i(75666);
    p.h(paramf, "editConfig");
    ad.i("MicroMsg.RemuxPlugin", "startReMux !!!!");
    Object localObject = D((d.g.a.a)new ab.h(this));
    if (localObject != null)
    {
      ((ab)localObject).xBS = paramf;
      ((ab)localObject).xBT = paramf.a(((ab)localObject).sNI, ((ab)localObject).xBR);
      ad.i("MicroMsg.RemuxPlugin", "configProvider : " + ((ab)localObject).sNI);
      ad.i("MicroMsg.RemuxPlugin", "RemuxMediaEditConfig : ".concat(String.valueOf(paramf)));
      ad.i("MicroMsg.RemuxPlugin", "mediaCaptureInfo : " + ((ab)localObject).xBR);
      ad.i("MicroMsg.RemuxPlugin", "generateTargetConfig info: " + ((ab)localObject).xBT + ' ');
      paramf = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_VIDEO_IS_EDITED_BOOLEAN", Boolean.valueOf(((ab)localObject).xBT.xxr));
      paramf = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.auV();
      if (((ab)localObject).xBT.xxr)
      {
        paramf = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.auU();
      }
      if (localObject != null)
      {
        paramf = ((ab)localObject).E((d.g.a.a)ab.i.xCn);
        if (paramf != null)
        {
          localObject = com.tencent.mm.plugin.recordvideo.e.b.xRl;
          com.tencent.mm.plugin.recordvideo.e.b.c(paramf.xBR);
          if (paramf != null)
          {
            paramf = paramf.F((d.g.a.a)ab.j.xCo);
            if (paramf != null)
            {
              paramf = paramf.G((d.g.a.a)ab.k.xCp);
              if (paramf != null)
              {
                paramf.H((d.g.a.a)ab.l.xCq);
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
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(200363);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(200363);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "success", "", "<anonymous parameter 1>", "", "invoke"})
  static final class c
    extends q
    implements m<Boolean, String, z>
  {
    c(ab paramab, AudioCacheInfo paramAudioCacheInfo, d.g.a.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin$checkBackgroundRemux$1$1"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(RecordConfigProvider paramRecordConfigProvider, y.f paramf, ab paramab, VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(ab paramab, f.b paramb, VideoMixer paramVideoMixer, com.tencent.mm.plugin.recordvideo.b.f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(ab paramab, VideoMixer paramVideoMixer, f.b paramb, com.tencent.mm.plugin.recordvideo.b.f paramf, aif paramaif, long paramLong, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(75655);
      Object localObject1 = ab.g(this.xBX);
      Object localObject3;
      boolean bool;
      label101:
      VideoMixer localVideoMixer;
      Object localObject6;
      f.b localb;
      if (localObject1 != null)
      {
        localObject3 = CaptureDataManager.xxY;
        p.g(localObject3, "CaptureDataManager.INSTANCE");
        ((CaptureDataManager)localObject3).getExtData().putBoolean("key_is_capture_video", ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).htP);
        localObject3 = CaptureDataManager.xxY;
        p.g(localObject3, "CaptureDataManager.INSTANCE");
        localObject3 = ((CaptureDataManager)localObject3).getExtData();
        localObject1 = (Collection)((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).htW;
        if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
        {
          i = 1;
          if (i != 0) {
            break label681;
          }
          bool = true;
          ((Bundle)localObject3).putBoolean("key_is_photo_video", bool);
        }
      }
      else
      {
        localVideoMixer = this.xCg;
        localObject6 = this.xCg.xuO.xuH;
        localb = this.xCf;
        p.h(localObject6, "captureInfo");
        p.h(localb, "config");
      }
      label172:
      int k;
      label268:
      label311:
      label323:
      label335:
      float f2;
      try
      {
        localObject3 = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xwQ;
        if (((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xwR < 0L) {
          break label687;
        }
        l = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xwR;
        k = localVideoMixer.hlJ;
        if (com.tencent.mm.vfs.i.fv((String)localObject3)) {
          break label1719;
        }
        ad.i("MicroMsg.Media.VideoMixer", "create thumb bitmap : ".concat(String.valueOf(l)));
        if ((((com.tencent.mm.plugin.recordvideo.b.c)localObject6).htP) || (bt.isNullOrNil(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xwP))) {
          break label780;
        }
        localObject1 = com.tencent.mm.plugin.mmsight.d.aY(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xwP, l * 1000L);
        localObject4 = (CharSequence)localVideoMixer.xuO.xuZ;
        if (localObject4 == null) {
          break label2320;
        }
        if (((CharSequence)localObject4).length() != 0) {
          break label693;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            long l;
            label378:
            int m;
            label422:
            localObject1 = ((com.tencent.mm.ui.blur.e)localObject5).d((Bitmap)localObject1, 4.0F);
            p.g(localObject1, "renderScriptBlur.blur(tmpBg, 4f)");
            ((com.tencent.mm.ui.blur.e)localObject5).destroy();
            if (localObject4 == null) {
              break;
            }
            localObject5 = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xwW.get(0);
            p.g(localObject5, "captureInfo.fakeVideoImageList[0]");
            i = VideoMixer.avF((String)localObject5);
            if (i == 0) {
              break;
            }
            localObject5 = new Matrix();
            ((Matrix)localObject5).postRotate(i);
            localObject4 = Bitmap.createBitmap((Bitmap)localObject4, 0, 0, ((Bitmap)localObject4).getWidth(), ((Bitmap)localObject4).getHeight(), (Matrix)localObject5, true);
            localObject5 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject5, true);
            p.g(localObject5, "Bitmap.createBitmap(bmBg…mBg.height, matrix, true)");
            localPoint = com.tencent.mm.plugin.recordvideo.b.e.xxi.dFr();
            if (localObject4 == null) {
              p.gfZ();
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
              ad.printErrStackTrace("MicroMsg.Media.VideoMixer", (Throwable)localException1, "createGraffitiThumb error", new Object[0]);
              com.tencent.mm.plugin.recordvideo.d.f localf = com.tencent.mm.plugin.recordvideo.d.f.xHm;
              com.tencent.mm.plugin.recordvideo.d.f.dGR();
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
            ad.printErrStackTrace("MicroMsg.Media.VideoMixer", (Throwable)localException2, "rsblur exception", new Object[0]);
            ad.i("MicroMsg.Media.VideoMixer", "rsblur exception, path:%s", new Object[] { ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xwW.get(0) });
            localObject2 = com.tencent.mm.plugin.recordvideo.b.e.xxi.dFr();
            localObject2 = com.tencent.mm.sdk.platformtools.g.aJ(Color.parseColor("#ff000000"), ((Point)localObject2).x, ((Point)localObject2).y);
            p.g(localObject2, "BitmapUtil.createColorBi…0000\"), point.x, point.y)");
            continue;
            localObject2 = com.tencent.mm.sdk.platformtools.g.aJ(Color.parseColor("#ff000000"), localPoint.x, localPoint.y);
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
          ad.i("MicroMsg.Media.VideoMixer", "exist thumb bitmap ");
          ((BitmapFactory.Options)localObject2).inMutable = true;
          localObject4 = com.tencent.mm.sdk.platformtools.g.decodeFile((String)localObject3, (BitmapFactory.Options)localObject2);
        }
        localObject2 = VideoMixer.hg(localb.targetWidth, localb.targetHeight);
        localObject5 = com.tencent.mm.plugin.recordvideo.e.c.xRv;
        localObject5 = com.tencent.mm.plugin.recordvideo.e.c.awc(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xwP);
        if (((com.tencent.mm.plugin.recordvideo.b.c)localObject6).htP) {
          break label2153;
        }
      }
      if ((i != 0) || (!com.tencent.mm.vfs.i.fv(localVideoMixer.xuO.xuZ)))
      {
        if (localb.hlJ == 270) {
          break label2326;
        }
        if (localb.hlJ == 90)
        {
          break label2326;
          if (j == 0) {
            break label705;
          }
          i = localb.targetHeight;
          if (j == 0) {
            break label715;
          }
          j = localb.targetWidth;
          f1 = i / j;
          p.g(localObject1, "originThumb");
          f2 = ((Bitmap)localObject1).getWidth() / ((Bitmap)localObject1).getHeight();
          if (f1 <= f2) {
            break label2338;
          }
          j = (int)(i / f2);
          ad.i("MicroMsg.Media.VideoMixer", "thumbHeight:" + j + " thumbWidth:" + i);
          localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, j, true);
          localObject4 = new StringBuilder("createGraffitiThumb not capture, thumb size:[");
          p.g(localObject1, "thumb");
          ad.i("MicroMsg.Media.VideoMixer", ((Bitmap)localObject1).getWidth() + ", " + ((Bitmap)localObject1).getHeight() + "], thumbRotate:" + k + ", drawingRect:" + Arrays.toString(localVideoMixer.xuO.xuU));
        }
      }
      for (;;)
      {
        localObject4 = (CharSequence)localObject3;
        if (localObject4 == null) {
          break label2332;
        }
        if (((CharSequence)localObject4).length() != 0) {
          break label2349;
        }
        break label2332;
        label525:
        if (i == 0) {
          break label2306;
        }
        localObject3 = com.tencent.mm.plugin.recordvideo.e.b.xRl;
        ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).avI(com.tencent.mm.plugin.recordvideo.e.b.yR(cf.aCL()));
        localObject3 = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xwQ;
        localObject4 = localObject1;
        label557:
        if (localObject4 != null) {
          break label1754;
        }
        ad.e("MicroMsg.Media.VideoMixer", "createGraffitiThumb thumb is null");
        localObject1 = com.tencent.mm.plugin.recordvideo.d.f.xHm;
        com.tencent.mm.plugin.recordvideo.d.f.dGR();
        localObject1 = com.tencent.mm.plugin.recordvideo.background.e.xuo;
        localObject1 = com.tencent.mm.plugin.recordvideo.background.e.a(this.xCg, (List)this.xCk.xxl, this.xuA, this.xCl, this.xCk.xuZ, this.hST);
        localObject3 = com.tencent.mm.plugin.recordvideo.background.f.xuv;
        com.tencent.mm.plugin.recordvideo.background.f.dET();
        if (this.hST == 3)
        {
          localObject3 = com.tencent.mm.plugin.recordvideo.d.e.xHl;
          com.tencent.mm.plugin.recordvideo.d.e.pQ(this.xuA.GfH);
        }
        com.tencent.mm.ad.c.g((d.g.a.a)new q((String)localObject1) {});
        AppMethodBeat.o(75655);
        return;
        i = 0;
        break;
        label681:
        bool = false;
        break label101;
        label687:
        l = 0L;
        break label172;
        label693:
        i = 0;
        break label268;
        j = 0;
        break label311;
        label705:
        i = localb.targetWidth;
        break label323;
        label715:
        j = localb.targetHeight;
        break label335;
        i = Math.min(localb.targetWidth, localb.targetHeight);
        p.g(localObject1, "originThumb");
        f1 = ((Bitmap)localObject1).getWidth() / i;
        localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, (int)(((Bitmap)localObject1).getHeight() / f1), true);
        break label422;
        label780:
        if (((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xwW.size() != 0) {
          break label806;
        }
        localObject1 = com.tencent.mm.plugin.mmsight.d.aY(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xwP, l);
      }
      label806:
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      BitmapFactory.decodeFile((String)((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xwW.get(0), (BitmapFactory.Options)localObject1);
      int i = ((BitmapFactory.Options)localObject1).outWidth;
      int j = ((BitmapFactory.Options)localObject1).outHeight;
      m = com.tencent.mm.plugin.recordvideo.b.e.xxi.getMaxSize();
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
        ((BitmapFactory.Options)localObject1).inSampleSize = com.tencent.mm.sdk.platformtools.g.O(i, j, com.tencent.mm.plugin.recordvideo.b.e.xxi.getMaxSize(), com.tencent.mm.plugin.recordvideo.b.e.xxi.getMaxSize());
        ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
        ((BitmapFactory.Options)localObject1).inMutable = true;
        localObject4 = MMBitmapFactory.decodeFile((String)((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xwW.get(0), (BitmapFactory.Options)localObject1);
        ((BitmapFactory.Options)localObject1).inSampleSize = com.tencent.mm.sdk.platformtools.g.O(i, j, com.tencent.mm.plugin.recordvideo.b.e.xxi.getMaxSize() / 2, com.tencent.mm.plugin.recordvideo.b.e.xxi.getMaxSize() / 2);
        localObject5 = new com.tencent.mm.ui.blur.e(aj.getContext());
        localObject1 = MMBitmapFactory.decodeFile((String)((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xwW.get(0), (BitmapFactory.Options)localObject1);
      }
      label1162:
      Object localObject2;
      label1719:
      label1754:
      if ((localObject5 != null) && (!((c.a)localObject5).xRw))
      {
        localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(localVideoMixer.xuO.xuU, localVideoMixer.xuO.xuV, localVideoMixer.xuO.pRU, ((Point)localObject2).x, ((Point)localObject2).y, ((c.a)localObject5).width, ((c.a)localObject5).height, k, false, localVideoMixer.xuO.xuZ, 256));
        localVideoMixer.xuG = ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject2);
        localObject2 = localVideoMixer.xuG;
        if (localObject2 == null) {
          p.bcb("frameRetriever");
        }
        ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject2).start();
        localObject6 = (Bitmap)localVideoMixer.hkY.invoke(Long.valueOf(1L));
        localObject2 = (Bitmap)localVideoMixer.hlX.invoke(Long.valueOf(1L));
        localObject5 = localVideoMixer.xuG;
        if (localObject5 == null) {
          p.bcb("frameRetriever");
        }
        ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject5).destroy();
        if (localObject2 == null) {
          break label2299;
        }
        localObject5 = VideoMixer.a((Bitmap)localObject4, (Bitmap)localObject2, 0.0F, (localb.targetHeight - ((Bitmap)localObject4).getHeight()) / 2.0F, 4);
        localObject2 = localObject5;
        if (localObject6 != null)
        {
          if (localb.hlJ == 270) {
            break label2355;
          }
          if (localb.hlJ != 90) {
            break label2361;
          }
          break label2355;
        }
      }
      for (;;)
      {
        label1879:
        if (j != 0)
        {
          i = localb.targetHeight;
          label2045:
          if (j == 0) {
            break label2232;
          }
          j = localb.targetWidth;
          if (((Bitmap)localObject4).getWidth() <= i) {
            break label2242;
          }
          localObject2 = VideoMixer.a((Bitmap)localObject6, (Bitmap)localObject5, (((Bitmap)localObject4).getWidth() - i) / 2.0F, 0.0F, 8);
          com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject2, 70, Bitmap.CompressFormat.JPEG, (String)localObject3, true);
          localObject2 = new StringBuilder("createGraffitiThumb : ").append((String)localObject3).append("   graffiti : ");
          if (localObject6 != null) {
            break label2293;
          }
        }
        label2000:
        label2153:
        label2293:
        for (bool = true;; bool = false)
        {
          ad.i("MicroMsg.Media.VideoMixer", bool);
          break;
          localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(localVideoMixer.xuO.xuU, localVideoMixer.xuO.xuV, localVideoMixer.xuO.pRU, ((Point)localObject2).x, ((Point)localObject2).y, 0, 0, k, false, localVideoMixer.xuO.xuZ, 256));
          break label1879;
          i = localb.targetWidth;
          break label2045;
          j = localb.targetHeight;
          break label2057;
          if (((Bitmap)localObject4).getHeight() > j)
          {
            localObject2 = VideoMixer.a((Bitmap)localObject6, (Bitmap)localObject5, 0.0F, (((Bitmap)localObject4).getHeight() - j) / 2.0F, 4);
            break label2090;
          }
          localObject2 = VideoMixer.a((Bitmap)localObject6, (Bitmap)localObject5, 0.0F, 0.0F, 12);
          break label2090;
        }
        label2057:
        label2090:
        label2232:
        label2242:
        label2299:
        localObject5 = localObject4;
        break label2000;
        label2306:
        localObject4 = localObject2;
        break label557;
        localObject5 = localObject2;
        break label1162;
        label2320:
        i = 1;
        break;
        label2326:
        j = 1;
        break label311;
        label2332:
        i = 1;
        break label525;
        label2338:
        i = (int)(j * f2);
        break label378;
        label2349:
        i = 0;
        break label525;
        label2355:
        j = 1;
        continue;
        label2361:
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.ab
 * JD-Core Version:    0.7.0.1
 */