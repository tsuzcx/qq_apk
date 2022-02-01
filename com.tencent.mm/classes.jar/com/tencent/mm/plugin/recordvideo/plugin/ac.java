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
import com.tencent.mm.model.ce;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.recordvideo.b.f.b;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer;
import com.tencent.mm.plugin.recordvideo.background.h;
import com.tencent.mm.plugin.recordvideo.e.c.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.m;
import d.g.a.r;
import d.g.b.k;
import d.g.b.v.d;
import d.g.b.v.f;
import d.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "abaParams", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getContext", "()Landroid/content/Context;", "setContext", "editConfig", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig;", "enable", "", "encode", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "getEncode", "()Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "setEncode", "(Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;)V", "loading", "Lcom/tencent/mm/plugin/recordvideo/ui/MediaProgressDialog;", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "x264RetryTime", "", "checkAudioCache", "", "audio", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "callback", "Lkotlin/Function0;", "checkBackgroundRemux", "error", "checkDaemonVideo", "checkForegroundRemux", "checkNoNeedRemuxVideo", "checkNullProvider", "checkSaveThumb", "videoPath", "", "thumbPath", "createMixer", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer;", "encodeConfig", "doFinish", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "forceRemux", "getMixer", "getTransformInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "runForeGround", "mixer", "runMixInBackground", "editorConfig", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "expiredTime", "", "scene", "setCaptureInfo", "info", "setMoovHead", "path", "snsCheck", "videoInfo", "Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "fileLength", "startReMux", "updateABABrWithQP", "Companion", "plugin-recordvideo_release"})
public final class ac
  implements t
{
  public static final ac.a wtZ;
  Context context;
  private boolean enable;
  private int[] rMF;
  private RecordConfigProvider rRi;
  private com.tencent.mm.plugin.recordvideo.ui.a wtU;
  private com.tencent.mm.media.widget.camerarecordview.b.b wtV;
  private com.tencent.mm.plugin.recordvideo.b.f wtW;
  f.b wtX;
  private int wtY;
  
  static
  {
    AppMethodBeat.i(75676);
    wtZ = new ac.a((byte)0);
    AppMethodBeat.o(75676);
  }
  
  public ac(Context paramContext)
  {
    AppMethodBeat.i(75675);
    this.context = paramContext;
    this.rMF = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    this.enable = true;
    this.wtX = new f.b((byte)0);
    AppMethodBeat.o(75675);
  }
  
  private final ac A(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(163436);
    if (!this.wtX.wpB)
    {
      Object localObject1 = this.wtV;
      if ((localObject1 != null) && (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).auO() == true))
      {
        localObject1 = this.rRi;
        if (localObject1 != null)
        {
          localObject1 = ((RecordConfigProvider)localObject1).wqt;
          if ((localObject1 != null) && (((VideoTransPara)localObject1).hCL == 1)) {}
        }
        else
        {
          localObject1 = this.rRi;
          if (localObject1 == null) {
            break label440;
          }
          localObject1 = ((RecordConfigProvider)localObject1).wqt;
          if ((localObject1 == null) || (((VideoTransPara)localObject1).hCL != 2)) {
            break label440;
          }
        }
        localObject1 = this.rRi;
        if (localObject1 != null)
        {
          localObject1 = ((RecordConfigProvider)localObject1).wqt;
          if ((localObject1 != null) && (((VideoTransPara)localObject1).hCV == 1)) {}
        }
        else
        {
          localObject1 = this.rRi;
          if (localObject1 != null)
          {
            localObject1 = ((RecordConfigProvider)localObject1).wqt;
            if ((localObject1 != null) && (((VideoTransPara)localObject1).hCV == 2)) {}
          }
          else
          {
            localObject1 = this.rRi;
            if (localObject1 == null) {
              break label440;
            }
            localObject1 = ((RecordConfigProvider)localObject1).wqt;
            if ((localObject1 == null) || (((VideoTransPara)localObject1).hCV != 4)) {
              break label440;
            }
          }
        }
        localObject1 = this.wtW;
        if (localObject1 == null) {
          k.fOy();
        }
        localObject1 = a((com.tencent.mm.plugin.recordvideo.b.f)localObject1, this.wtX);
        Object localObject2 = ((VideoMixer)localObject1).wmU;
        if (localObject2 != null) {
          ((AdaptiveAdjustBitrate)localObject2).wpx = 3000;
        }
        int i = ((VideoMixer)localObject1).duE();
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", "ABA: useDarmonVideo: ".concat(String.valueOf(i)));
        if (i == 1)
        {
          parama.invoke();
          AppMethodBeat.o(163436);
          return this;
        }
        localObject1 = new StringBuilder("ABA::check DarmonVideo, add the metadate for video of low bitrate path: ");
        localObject2 = this.wtV;
        if (localObject2 == null) {
          k.fOy();
        }
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).hbJ);
        localObject1 = this.wtV;
        if (localObject1 == null) {
          k.fOy();
        }
        SightVideoJNI.addReportMetadata(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).hbJ, new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 1, 0);
        label440:
        localObject1 = this.rRi;
        if (localObject1 != null)
        {
          parama = new StringBuilder("daemonMediaCaptureInfo into: \ndaemonVideoPath = ");
          localObject2 = this.wtV;
          if (localObject2 == null) {
            k.fOy();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).hbJ).append(", daemonVideoSize = ");
          localObject2 = this.wtV;
          if (localObject2 == null) {
            k.fOy();
          }
          parama = parama.append(com.tencent.mm.vfs.i.aSp(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).hbJ)).append(", \nsourceVideoPath = ");
          localObject2 = this.wtV;
          if (localObject2 == null) {
            k.fOy();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).hbF).append(", captureSize = ");
          localObject2 = this.wtV;
          if (localObject2 == null) {
            k.fOy();
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", com.tencent.mm.vfs.i.aSp(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).hbF) + ", \noutputSize = " + ((RecordConfigProvider)localObject1).wqG + ", outputSize = " + com.tencent.mm.vfs.i.aSp(((RecordConfigProvider)localObject1).wqG));
          parama = this.wtV;
          if (parama == null) {
            k.fOy();
          }
          com.tencent.mm.vfs.i.lZ(parama.hbJ, ((RecordConfigProvider)localObject1).wqG);
          parama = this.wtV;
          if (parama == null) {
            k.fOy();
          }
          com.tencent.mm.vfs.i.lZ(parama.hbK, ((RecordConfigProvider)localObject1).thumbPath);
          parama = com.tencent.mm.plugin.recordvideo.e.b.wDE;
          com.tencent.mm.plugin.recordvideo.e.b.c(this.wtV);
          parama = com.tencent.mm.plugin.recordvideo.e.b.wDE;
          com.tencent.mm.plugin.recordvideo.e.b.f((RecordConfigProvider)localObject1);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", "daemonMediaCaptureInfo 1: " + this.wtV);
          parama = new StringBuilder("daemonMediaCaptureInfo 2: \ndaemonVideoPath = ");
          localObject2 = this.wtV;
          if (localObject2 == null) {
            k.fOy();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).hbJ).append(", daemonVideoSize = ");
          localObject2 = this.wtV;
          if (localObject2 == null) {
            k.fOy();
          }
          parama = parama.append(com.tencent.mm.vfs.i.aSp(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).hbJ)).append(", \nsourceVideoPath = ");
          localObject2 = this.wtV;
          if (localObject2 == null) {
            k.fOy();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).hbF).append(", captureSize = ");
          localObject2 = this.wtV;
          if (localObject2 == null) {
            k.fOy();
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", com.tencent.mm.vfs.i.aSp(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).hbF) + ", \noutputSize = " + ((RecordConfigProvider)localObject1).wqG + ", outputSize = " + com.tencent.mm.vfs.i.aSp(((RecordConfigProvider)localObject1).wqG));
          parama = ((RecordConfigProvider)localObject1).wqG;
          k.g(parama, "this.outputVideoPath");
          localObject2 = ((RecordConfigProvider)localObject1).thumbPath;
          k.g(localObject2, "this.thumbPath");
          ix(parama, (String)localObject2);
          parama = ((RecordConfigProvider)localObject1).wqG;
          k.g(parama, "this.outputVideoPath");
          aqL(parama);
          parama = Boolean.TRUE;
          localObject2 = ((RecordConfigProvider)localObject1).wqG;
          localObject1 = ((RecordConfigProvider)localObject1).thumbPath;
          Object localObject3 = this.wtV;
          if (localObject3 == null) {
            k.fOy();
          }
          i = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject3).hbM;
          localObject3 = this.wtV;
          if (localObject3 == null) {
            k.fOy();
          }
          long l = i - ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject3).hbL;
          localObject3 = Boolean.FALSE;
          com.tencent.mm.plugin.recordvideo.d.c localc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          b(new CaptureDataManager.CaptureVideoNormalModel(parama, (String)localObject2, (String)localObject1, Long.valueOf(l), (Boolean)localObject3, com.tencent.mm.plugin.recordvideo.d.c.dwq()));
          AppMethodBeat.o(163436);
          return null;
        }
      }
    }
    parama.invoke();
    AppMethodBeat.o(163436);
    return this;
  }
  
  private final ac B(d.g.a.a<y> parama)
  {
    boolean bool = true;
    AppMethodBeat.i(163437);
    Object localObject2 = this.rRi;
    if (localObject2 != null)
    {
      Object localObject1;
      if (this.wtX.wpA)
      {
        if (!this.wtX.wpB)
        {
          localObject1 = com.tencent.mm.media.b.b.gNS;
          if (!com.tencent.mm.media.b.b.aql()) {}
        }
      }
      else
      {
        localObject1 = this.wtW;
        label106:
        int i;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.recordvideo.b.f)localObject1).wpt;
          if (localObject1 != null) {
            break label682;
          }
          parama = this.wtV;
          if ((parama == null) || (parama.hbH != true)) {
            break label406;
          }
          if (((RecordConfigProvider)localObject2).scene != 2) {
            break label377;
          }
          parama = com.tencent.mm.media.j.d.gWO;
          com.tencent.mm.media.j.d.asf();
          parama = com.tencent.mm.plugin.recordvideo.e.b.wDE;
          com.tencent.mm.plugin.recordvideo.e.b.g(this.rRi);
          parama = ((RecordConfigProvider)localObject2).wqG;
          k.g(parama, "this.outputVideoPath");
          localObject1 = ((RecordConfigProvider)localObject2).thumbPath;
          k.g(localObject1, "this.thumbPath");
          ix(parama, (String)localObject1);
          parama = ((RecordConfigProvider)localObject2).wqG;
          k.g(parama, "this.outputVideoPath");
          aqL(parama);
          parama = this.wtV;
          if (parama != null)
          {
            localObject1 = CaptureDataManager.wqi;
            k.g(localObject1, "CaptureDataManager.INSTANCE");
            ((CaptureDataManager)localObject1).getExtData().putBoolean("key_is_capture_video", parama.hbH);
            localObject1 = CaptureDataManager.wqi;
            k.g(localObject1, "CaptureDataManager.INSTANCE");
            localObject1 = ((CaptureDataManager)localObject1).getExtData();
            parama = (Collection)parama.hbO;
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
          localObject1 = ((RecordConfigProvider)localObject2).wqG;
          localObject2 = ((RecordConfigProvider)localObject2).thumbPath;
          localObject3 = this.wtW;
          if (localObject3 == null) {
            k.fOy();
          }
          i = ((com.tencent.mm.plugin.recordvideo.b.f)localObject3).wpx;
          localObject3 = this.wtW;
          if (localObject3 == null) {
            k.fOy();
          }
          l = i - ((com.tencent.mm.plugin.recordvideo.b.f)localObject3).wpw;
          localObject3 = Boolean.FALSE;
          localc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          b(new CaptureDataManager.CaptureVideoNormalModel(parama, (String)localObject1, (String)localObject2, Long.valueOf(l), (Boolean)localObject3, com.tencent.mm.plugin.recordvideo.d.c.dwq()));
          AppMethodBeat.o(163437);
          return null;
          localObject1 = null;
          break;
          label377:
          if (((RecordConfigProvider)localObject2).scene != 1) {
            break label106;
          }
          parama = com.tencent.mm.media.j.d.gWO;
          com.tencent.mm.media.j.d.asg();
          break label106;
          i = 0;
          break label250;
        }
        label406:
        parama = this.wtV;
        if (parama == null) {
          k.fOy();
        }
        parama = parama.hbF;
        localObject1 = ((RecordConfigProvider)localObject2).thumbPath;
        k.g(localObject1, "this.thumbPath");
        ix(parama, (String)localObject1);
        parama = this.wtV;
        if (parama == null) {
          k.fOy();
        }
        aqL(parama.hbF);
        parama = this.wtV;
        if (parama != null)
        {
          localObject1 = CaptureDataManager.wqi;
          k.g(localObject1, "CaptureDataManager.INSTANCE");
          ((CaptureDataManager)localObject1).getExtData().putBoolean("key_is_capture_video", parama.hbH);
          localObject1 = CaptureDataManager.wqi;
          k.g(localObject1, "CaptureDataManager.INSTANCE");
          localObject1 = ((CaptureDataManager)localObject1).getExtData();
          parama = (Collection)parama.hbO;
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
          localObject1 = this.wtV;
          if (localObject1 == null) {
            k.fOy();
          }
          localObject1 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).hbF;
          localObject2 = ((RecordConfigProvider)localObject2).thumbPath;
          localObject3 = this.wtW;
          if (localObject3 == null) {
            k.fOy();
          }
          i = ((com.tencent.mm.plugin.recordvideo.b.f)localObject3).wpx;
          localObject3 = this.wtW;
          if (localObject3 == null) {
            k.fOy();
          }
          l = i - ((com.tencent.mm.plugin.recordvideo.b.f)localObject3).wpw;
          localObject3 = Boolean.FALSE;
          localc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          b(new CaptureDataManager.CaptureVideoNormalModel(parama, (String)localObject1, (String)localObject2, Long.valueOf(l), (Boolean)localObject3, com.tencent.mm.plugin.recordvideo.d.c.dwq()));
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
  
  private final ac C(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(163438);
    Object localObject = this.rRi;
    if ((localObject != null) && (k.g(((RecordConfigProvider)localObject).wqA, Boolean.TRUE)))
    {
      parama = this.wtW;
      if (parama == null) {
        k.fOy();
      }
      parama = a(parama, this.wtX);
      localObject = com.tencent.mm.plugin.recordvideo.d.f.wys;
      com.tencent.mm.plugin.recordvideo.d.f.pz(true);
      localObject = this.wtW;
      if (localObject == null) {
        k.fOy();
      }
      a(parama, (com.tencent.mm.plugin.recordvideo.b.f)localObject, this.wtX);
      AppMethodBeat.o(163438);
      return null;
    }
    parama.invoke();
    AppMethodBeat.o(163438);
    return this;
  }
  
  private final ac D(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(163439);
    Object localObject1 = com.tencent.mm.plugin.recordvideo.d.f.wys;
    com.tencent.mm.plugin.recordvideo.d.f.pz(false);
    localObject1 = this.wtW;
    if (localObject1 == null) {
      k.fOy();
    }
    localObject1 = a((com.tencent.mm.plugin.recordvideo.b.f)localObject1, this.wtX);
    RecordConfigProvider localRecordConfigProvider = this.rRi;
    if (localRecordConfigProvider != null)
    {
      final v.f localf = new v.f();
      localf.KUQ = new afq();
      parama = (afq)localf.KUQ;
      Object localObject2 = this.wtW;
      if (localObject2 == null) {
        k.fOy();
      }
      int i = ((com.tencent.mm.plugin.recordvideo.b.f)localObject2).wpx;
      localObject2 = this.wtW;
      if (localObject2 == null) {
        k.fOy();
      }
      parama.duration = (i - ((com.tencent.mm.plugin.recordvideo.b.f)localObject2).wpw);
      ((afq)localf.KUQ).ExZ = new LinkedList((Collection)d.a.e.N(this.rMF));
      localObject2 = (afq)localf.KUQ;
      parama = localRecordConfigProvider.wqt;
      if (parama != null)
      {
        parama = Integer.valueOf(parama.hCL);
        if (parama == null) {
          k.fOy();
        }
        ((afq)localObject2).hCL = parama.intValue();
        parama = (afq)localf.KUQ;
        localObject2 = this.wtV;
        if (localObject2 == null) {
          break label407;
        }
      }
      label407:
      for (boolean bool = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).hbH;; bool = false)
      {
        parama.Eya = bool;
        ((afq)localf.KUQ).AlF = this.wtX.wpB;
        ((afq)localf.KUQ).wqD = localRecordConfigProvider.wqD;
        ((afq)localf.KUQ).wqE = localRecordConfigProvider.wqE;
        ((afq)localf.KUQ).wqF = localRecordConfigProvider.wqF;
        ((afq)localf.KUQ).wqG = localRecordConfigProvider.wqG;
        ((afq)localf.KUQ).Eyb = localRecordConfigProvider.thumbPath;
        ((afq)localf.KUQ).wnN = ((VideoMixer)localObject1).gUr;
        ((afq)localf.KUQ).Eyc = 0;
        parama = this.wtW;
        if (parama == null) {
          k.fOy();
        }
        a(parama.wpt, (d.g.a.a)new d(localRecordConfigProvider, localf, this, (VideoMixer)localObject1));
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
    RecordConfigProvider localRecordConfigProvider = this.rRi;
    float f;
    if ((localRecordConfigProvider != null) && (localRecordConfigProvider.scene == 2)) {
      f = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pTW, 1.0F);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", "final kbps: " + f + "  " + paramb.videoBitrate * f);
      VideoMixer.a(localVideoMixer, paramb.gNU, paramb.gNV, (int)(f * paramb.videoBitrate), paramb.audioBitrate, paramb.audioSampleRate, paramb.gOt, paramb.frameRate, paramb.gTI);
      paramb = this.rRi;
      if (paramb != null) {}
      for (paramb = paramb.wqt;; paramb = null)
      {
        if (paramb == null) {
          k.fOy();
        }
        localVideoMixer.a(paramb, paramf.wpx, paramf.wpw);
        AppMethodBeat.o(75668);
        return localVideoMixer;
        localRecordConfigProvider = this.rRi;
        if (localRecordConfigProvider != null)
        {
          if (localRecordConfigProvider.scene != 1) {
            break label227;
          }
          f = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pTV, 1.0F);
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
    Object localObject = com.tencent.mm.media.j.d.gWO;
    com.tencent.mm.media.j.d.ass();
    long l = bs.Gn();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", "start forceRemux");
    localObject = this.rRi;
    String str;
    int i;
    int j;
    label197:
    label215:
    int k;
    if (localObject != null)
    {
      localObject = ((RecordConfigProvider)localObject).wqG;
      str = k.E((String)localObject, "_tmp");
      localObject = this.rRi;
      if (localObject == null) {
        k.fOy();
      }
      if (((RecordConfigProvider)localObject).wqt.hCM != 2) {
        break label421;
      }
      localObject = this.rRi;
      if (localObject == null) {
        k.fOy();
      }
      i = ((RecordConfigProvider)localObject).wqt.gOb;
      localObject = this.rRi;
      if (localObject == null) {
        k.fOy();
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", "ABA: Using Min Max QP Limitation: [%d], [%d] ", new Object[] { Integer.valueOf(i), Integer.valueOf(((RecordConfigProvider)localObject).wqt.gOc) });
      localObject = this.rRi;
      if (localObject == null) {
        k.fOy();
      }
      i = ((RecordConfigProvider)localObject).wqt.gOb;
      localObject = this.rRi;
      if (localObject == null) {
        k.fOy();
      }
      j = ((RecordConfigProvider)localObject).wqt.gOc;
      localObject = this.rRi;
      if (localObject == null) {
        break label429;
      }
      localObject = ((RecordConfigProvider)localObject).wqG;
      k = paramb.gNU;
      int m = paramb.gNV;
      int n = paramb.videoBitrate;
      RecordConfigProvider localRecordConfigProvider = this.rRi;
      if (localRecordConfigProvider == null) {
        k.fOy();
      }
      int i1 = localRecordConfigProvider.wqt.hCA;
      localRecordConfigProvider = this.rRi;
      if (localRecordConfigProvider == null) {
        k.fOy();
      }
      k = SightVideoJNI.remuxingVFS((String)localObject, str, k, m, n, i1, 8, localRecordConfigProvider.wqt.hCz, 25.0F, paramb.frameRate, null, 0, false, i, j);
      paramb = this.rRi;
      if (paramb == null) {
        break label435;
      }
    }
    label421:
    label429:
    label435:
    for (paramb = paramb.wqG;; paramb = null)
    {
      com.tencent.mm.vfs.i.lZ(str, paramb);
      com.tencent.mm.vfs.i.deleteFile(str);
      l = bs.aO(l);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", "minQP :" + i + "  maxQP :" + j + "  duration:" + k + " cost:" + l);
      paramb = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.pu(l);
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
    if (this.wtU == null)
    {
      localObject = new com.tencent.mm.plugin.recordvideo.ui.a();
      ((com.tencent.mm.plugin.recordvideo.ui.a)localObject).a(this.context, (d.g.a.a)ac.e.wui);
      this.wtU = ((com.tencent.mm.plugin.recordvideo.ui.a)localObject);
    }
    Object localObject = h.wmI;
    h.y((d.g.a.a)new f(this, paramb, paramVideoMixer, paramf));
    AppMethodBeat.o(75669);
  }
  
  private final void a(final AudioCacheInfo paramAudioCacheInfo, final d.g.a.a<y> parama)
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
        bool1 = paramAudioCacheInfo.aMR;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", bool1);
      localObject = new com.tencent.mm.plugin.recordvideo.ui.a();
      ((com.tencent.mm.plugin.recordvideo.ui.a)localObject).a(this.context, (d.g.a.a)ac.b.wua);
      this.wtU = ((com.tencent.mm.plugin.recordvideo.ui.a)localObject);
      if ((paramAudioCacheInfo == null) || (paramAudioCacheInfo.aMR)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", "checkAudioCache false");
      localObject = com.tencent.mm.plugin.recordvideo.model.audio.i.wrV;
      com.tencent.mm.plugin.recordvideo.model.audio.i.dvK().a(this.context, paramAudioCacheInfo, (m)new c(this, paramAudioCacheInfo, parama));
      AppMethodBeat.o(163440);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", "checkAudioCache done");
    parama.invoke();
    AppMethodBeat.o(163440);
  }
  
  private static void aqL(String paramString)
  {
    AppMethodBeat.i(75667);
    long l = bs.Gn();
    SightVideoJNI.optimizeMP4VFS(paramString);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.RemuxPlugin", "time cost: " + bs.aO(l));
    AppMethodBeat.o(75667);
  }
  
  private final VideoMixer b(com.tencent.mm.plugin.recordvideo.b.f paramf)
  {
    AppMethodBeat.i(75670);
    long l = System.currentTimeMillis();
    Object localObject1 = this.rRi;
    if (localObject1 != null)
    {
      localObject2 = ((RecordConfigProvider)localObject1).wqG;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.e.b.wDE;
      localObject1 = com.tencent.mm.plugin.recordvideo.e.b.aqY(String.valueOf(l));
    }
    Object localObject2 = this.rRi;
    if (localObject2 != null)
    {
      localObject3 = ((RecordConfigProvider)localObject2).thumbPath;
      localObject2 = localObject3;
      if (localObject3 != null) {}
    }
    else
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.e.b.wDE;
      localObject2 = com.tencent.mm.plugin.recordvideo.e.b.aqZ(String.valueOf(l));
    }
    Object localObject3 = this.rRi;
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
        break label698;
      }
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pTR, 0) != 1) {
        break label679;
      }
      bool2 = true;
      i = ae.fJk.fIh;
      if (i == -1) {
        break label691;
      }
      if (i != 1) {
        break label685;
      }
      bool1 = true;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", "sns config use x264 encode: " + bool2 + ", deviceUseX264Encode:" + i);
      bool4 = bool1;
      if (aw.eVz().getBoolean("mediacodec_create_error", false)) {
        bool4 = true;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", "final useX264Encode: ".concat(String.valueOf(bool4)));
      bool1 = false;
      if ((k != 2) && (k != 1)) {
        break label1064;
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
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", "checkEnableHevc, deviceSwEnableHevc:" + i + ", deviceHwEnableHevc:" + j + ", exptSwEnableHevc:" + bool1 + ", exptHwEnableHevc:" + bool2);
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
                    break label1003;
                  }
                  bool5 = true;
                }
                label467:
                bool1 = false;
                if (!bool4) {
                  break label1026;
                }
                bool1 = bool3;
                bool2 = bool4;
                label483:
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", "checkEnableHevc, hwEnableHevc:" + bool5 + ", swEnableHevc:" + bool3 + ", enableHevc:" + bool1 + ", useSoftEncode:" + bool2);
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
      if ((k == 3) && (!com.tencent.mm.vfs.i.eA(localc.woZ)))
      {
        localObject3 = com.tencent.mm.plugin.recordvideo.d.e.wyr;
        com.tencent.mm.plugin.recordvideo.d.e.py(localc.hbH);
      }
      List localList = (List)paramf.wpu;
      float[] arrayOfFloat = paramf.wnb;
      localObject3 = this.rRi;
      if (localObject3 != null)
      {
        localObject3 = ((RecordConfigProvider)localObject3).wqt;
        if (localObject3 == null) {}
      }
      for (i = ((VideoTransPara)localObject3).hCK;; i = 0)
      {
        localObject3 = paramf.wmm;
        paramf = (com.tencent.mm.plugin.recordvideo.b.f)localObject3;
        if (localObject3 == null) {
          paramf = "";
        }
        paramf = new VideoMixer(localc, localList, arrayOfFloat, (String)localObject1, (String)localObject2, 0, bool2, bool1, i, paramf, 32);
        AppMethodBeat.o(75670);
        return paramf;
        k = 0;
        break;
        label679:
        bool2 = false;
        break label154;
        label685:
        bool1 = false;
        break label174;
        label691:
        bool1 = bool2;
        break label174;
        label698:
        if (k != 1) {
          break label207;
        }
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pTS, 0) == 1)
        {
          bool2 = true;
          label729:
          i = ae.fJk.fIg;
          if (i == -1) {
            break label797;
          }
          if (i != 1) {
            break label791;
          }
          bool1 = true;
        }
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", "c2c config use x264 encode: " + bool2 + ", deviceUseX264Encode:" + i);
          break;
          bool2 = false;
          break label729;
          label791:
          bool1 = false;
          continue;
          label797:
          bool1 = bool2;
        }
        i = ae.fJk.fIr;
        break label286;
        i = ae.fJk.fIs;
        break label286;
        j = ae.fJk.fIp;
        break label314;
        j = ae.fJk.fIq;
        break label314;
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qad, 0) == 1)
        {
          bool1 = true;
          break label343;
        }
        bool1 = false;
        break label343;
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qac, 0) == 1)
        {
          bool1 = true;
          break label343;
        }
        bool1 = false;
        break label343;
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qaa, 0) == 1)
        {
          bool2 = true;
          break label371;
        }
        bool2 = false;
        break label371;
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qab, 0) == 1)
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
        label1003:
        if ((bool2) && (j == 2))
        {
          bool5 = false;
          break label467;
        }
        bool5 = bool2;
        break label467;
        label1026:
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
      label1064:
      bool2 = bool4;
    }
  }
  
  private final void b(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(75672);
    aw.eVz().putBoolean("mediacodec_create_error", false);
    CaptureDataManager.wqi.a(this.context, paramCaptureVideoNormalModel);
    AppMethodBeat.o(75672);
  }
  
  private final com.tencent.mm.plugin.recordvideo.b.c c(com.tencent.mm.plugin.recordvideo.b.f paramf)
  {
    boolean bool = true;
    AppMethodBeat.i(75671);
    com.tencent.mm.plugin.recordvideo.b.c localc = new com.tencent.mm.plugin.recordvideo.b.c();
    Object localObject = this.wtV;
    String str;
    if (localObject != null)
    {
      str = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).hbF;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localc.aqH((String)localObject);
    localObject = this.wtV;
    if (localObject != null)
    {
      str = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).hbG;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localc.aqI((String)localObject);
    localc.wpf = paramf.wpt;
    int i;
    if (paramf.wpj) {
      if (localc.wpf == null) {
        i = 0;
      }
    }
    for (;;)
    {
      localc.wpe = i;
      localObject = this.wtV;
      if (localObject != null) {
        bool = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).hbH;
      }
      localc.hbH = bool;
      localc.gTI = SightVideoJNI.getMp4RotateVFS(localc.woZ);
      localc.wpb = paramf.wpw;
      localc.wpc = paramf.wpx;
      localc.as(paramf.wpy);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", "getTransformInfo :".concat(String.valueOf(localc)));
      AppMethodBeat.o(75671);
      return localc;
      i = 2;
      continue;
      if (localc.wpf == null) {
        i = 1;
      } else {
        i = 3;
      }
    }
  }
  
  private final void ix(String paramString1, String paramString2)
  {
    AppMethodBeat.i(75673);
    if (com.tencent.mm.vfs.i.eA(paramString2)) {
      com.tencent.mm.vfs.i.deleteFile(paramString2);
    }
    paramString1 = com.tencent.mm.plugin.mmsight.d.Dl(paramString1);
    Object localObject;
    if (paramString1 != null)
    {
      localObject = com.tencent.mm.plugin.recordvideo.e.b.wDE;
      localObject = this.rRi;
      if (localObject == null) {
        break label84;
      }
      localObject = ((RecordConfigProvider)localObject).wqt;
      if (localObject == null) {
        break label84;
      }
    }
    label84:
    for (int i = ((VideoTransPara)localObject).hCK;; i = 0)
    {
      com.tencent.mm.sdk.platformtools.f.a(com.tencent.mm.plugin.recordvideo.e.b.h(paramString1, i), 60, Bitmap.CompressFormat.JPEG, paramString2, true);
      AppMethodBeat.o(75673);
      return;
    }
  }
  
  private final ac z(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(163435);
    if ((this.rRi == null) || (!this.enable))
    {
      parama.invoke();
      AppMethodBeat.o(163435);
      return null;
    }
    this.enable = false;
    AppMethodBeat.o(163435);
    return this;
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(75665);
    k.h(paramb, "info");
    k.h(paramRecordConfigProvider, "configProvider");
    this.wtV = paramb;
    this.rRi = paramRecordConfigProvider;
    paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.d.c.wyg;
    com.tencent.mm.plugin.recordvideo.d.c.w("KEY_IS_CAPUTRE_BOOLEAN", Boolean.valueOf(paramb.hbH));
    if (paramb.hbH)
    {
      paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_CAPUTRE_VIDEO_PATH_STRING", paramb.auQ());
      paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      if (!paramb.auP()) {
        break label98;
      }
    }
    label98:
    for (paramb = paramb.hbG;; paramb = paramb.hbK)
    {
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_CAPUTRE_THUMB_PATH_STRING", paramb);
      AppMethodBeat.o(75665);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.b.f paramf)
  {
    AppMethodBeat.i(75666);
    k.h(paramf, "editConfig");
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", "startReMux !!!!");
    Object localObject = z((d.g.a.a)new h(this));
    if (localObject != null)
    {
      ((ac)localObject).wtW = paramf;
      ((ac)localObject).wtX = paramf.a(((ac)localObject).rRi, ((ac)localObject).wtV);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", "configProvider : " + ((ac)localObject).rRi);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", "RemuxMediaEditConfig : ".concat(String.valueOf(paramf)));
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", "mediaCaptureInfo : " + ((ac)localObject).wtV);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RemuxPlugin", "generateTargetConfig info: " + ((ac)localObject).wtX + ' ');
      paramf = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_VIDEO_IS_EDITED_BOOLEAN", Boolean.valueOf(((ac)localObject).wtX.wpB));
      paramf = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.asi();
      if (((ac)localObject).wtX.wpB)
      {
        paramf = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.ash();
      }
      if (localObject != null)
      {
        paramf = ((ac)localObject).A((d.g.a.a)ac.i.wur);
        if (paramf != null)
        {
          localObject = com.tencent.mm.plugin.recordvideo.e.b.wDE;
          com.tencent.mm.plugin.recordvideo.e.b.c(paramf.wtV);
          if (paramf != null)
          {
            paramf = paramf.B((d.g.a.a)ac.j.wus);
            if (paramf != null)
            {
              paramf = paramf.C((d.g.a.a)ac.k.wut);
              if (paramf != null)
              {
                paramf.D((d.g.a.a)ac.l.wuu);
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
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void awk() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "success", "", "<anonymous parameter 1>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements m<Boolean, String, y>
  {
    c(ac paramac, AudioCacheInfo paramAudioCacheInfo, d.g.a.a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin$checkBackgroundRemux$1$1"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(RecordConfigProvider paramRecordConfigProvider, v.f paramf, ac paramac, VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(ac paramac, f.b paramb, VideoMixer paramVideoMixer, com.tencent.mm.plugin.recordvideo.b.f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(ac paramac, VideoMixer paramVideoMixer, f.b paramb, com.tencent.mm.plugin.recordvideo.b.f paramf, afq paramafq, long paramLong, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(75655);
      Object localObject1 = ac.g(this.wub);
      Object localObject3;
      boolean bool;
      label101:
      VideoMixer localVideoMixer;
      Object localObject6;
      f.b localb;
      if (localObject1 != null)
      {
        localObject3 = CaptureDataManager.wqi;
        k.g(localObject3, "CaptureDataManager.INSTANCE");
        ((CaptureDataManager)localObject3).getExtData().putBoolean("key_is_capture_video", ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).hbH);
        localObject3 = CaptureDataManager.wqi;
        k.g(localObject3, "CaptureDataManager.INSTANCE");
        localObject3 = ((CaptureDataManager)localObject3).getExtData();
        localObject1 = (Collection)((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).hbO;
        if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
        {
          i = 1;
          if (i != 0) {
            break label669;
          }
          bool = true;
          ((Bundle)localObject3).putBoolean("key_is_photo_video", bool);
        }
      }
      else
      {
        localVideoMixer = this.wuk;
        localObject6 = this.wuk.wna;
        localb = this.wuj;
        k.h(localObject6, "captureInfo");
        k.h(localb, "config");
      }
      label169:
      int k;
      label262:
      label302:
      label314:
      label326:
      float f2;
      try
      {
        localObject3 = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).wpa;
        if (((com.tencent.mm.plugin.recordvideo.b.c)localObject6).wpb < 0L) {
          break label675;
        }
        l = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).wpb;
        k = localVideoMixer.gTI;
        if (com.tencent.mm.vfs.i.eA((String)localObject3)) {
          break label1707;
        }
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Media.VideoMixer", "create thumb bitmap : ".concat(String.valueOf(l)));
        if ((((com.tencent.mm.plugin.recordvideo.b.c)localObject6).hbH) || (bs.isNullOrNil(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).woZ))) {
          break label768;
        }
        localObject1 = com.tencent.mm.plugin.mmsight.d.aX(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).woZ, l * 1000L);
        localObject4 = (CharSequence)localVideoMixer.wmm;
        if (localObject4 == null) {
          break label2259;
        }
        if (((CharSequence)localObject4).length() != 0) {
          break label681;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            long l;
            label369:
            int m;
            label413:
            localObject1 = ((com.tencent.mm.ui.blur.e)localObject5).d((Bitmap)localObject1, 4.0F);
            k.g(localObject1, "renderScriptBlur.blur(tmpBg, 4f)");
            ((com.tencent.mm.ui.blur.e)localObject5).destroy();
            if (localObject4 == null) {
              break;
            }
            localObject5 = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).wpg.get(0);
            k.g(localObject5, "captureInfo.fakeVideoImageList[0]");
            i = VideoMixer.aqF((String)localObject5);
            if (i == 0) {
              break;
            }
            localObject5 = new Matrix();
            ((Matrix)localObject5).postRotate(i);
            localObject4 = Bitmap.createBitmap((Bitmap)localObject4, 0, 0, ((Bitmap)localObject4).getWidth(), ((Bitmap)localObject4).getHeight(), (Matrix)localObject5, true);
            localObject5 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject5, true);
            k.g(localObject5, "Bitmap.createBitmap(bmBg…mBg.height, matrix, true)");
            localPoint = com.tencent.mm.plugin.recordvideo.b.e.wps.duW();
            if (localObject4 == null) {
              k.fOy();
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
              com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.Media.VideoMixer", (Throwable)localException1, "createGraffitiThumb error", new Object[0]);
              com.tencent.mm.plugin.recordvideo.d.f localf = com.tencent.mm.plugin.recordvideo.d.f.wys;
              com.tencent.mm.plugin.recordvideo.d.f.dwx();
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
            com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.Media.VideoMixer", (Throwable)localException2, "rsblur exception", new Object[0]);
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Media.VideoMixer", "rsblur exception, path:%s", new Object[] { ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).wpg.get(0) });
            localObject2 = com.tencent.mm.plugin.recordvideo.b.e.wps.duW();
            localObject2 = com.tencent.mm.sdk.platformtools.f.aH(Color.parseColor("#ff000000"), ((Point)localObject2).x, ((Point)localObject2).y);
            k.g(localObject2, "BitmapUtil.createColorBi…0000\"), point.x, point.y)");
            continue;
            localObject2 = com.tencent.mm.sdk.platformtools.f.aH(Color.parseColor("#ff000000"), localPoint.x, localPoint.y);
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
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Media.VideoMixer", "exist thumb bitmap ");
          ((BitmapFactory.Options)localObject2).inMutable = true;
          localObject4 = com.tencent.mm.sdk.platformtools.f.decodeFile((String)localObject3, (BitmapFactory.Options)localObject2);
        }
        localObject2 = VideoMixer.gP(localb.gNU, localb.gNV);
        localObject5 = com.tencent.mm.plugin.recordvideo.e.c.wDO;
        localObject5 = com.tencent.mm.plugin.recordvideo.e.c.arc(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).woZ);
        if (((com.tencent.mm.plugin.recordvideo.b.c)localObject6).hbH) {
          break label2113;
        }
      }
      if ((i != 0) || (!com.tencent.mm.vfs.i.eA(localVideoMixer.wmm)))
      {
        if (localb.gTI == 270) {
          break label2265;
        }
        if (localb.gTI == 90)
        {
          break label2265;
          if (j == 0) {
            break label693;
          }
          i = localb.gNV;
          if (j == 0) {
            break label703;
          }
          j = localb.gNU;
          f1 = i / j;
          k.g(localObject1, "originThumb");
          f2 = ((Bitmap)localObject1).getWidth() / ((Bitmap)localObject1).getHeight();
          if (f1 <= f2) {
            break label2277;
          }
          j = (int)(i / f2);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Media.VideoMixer", "thumbHeight:" + j + " thumbWidth:" + i);
          localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, j, true);
          localObject4 = new StringBuilder("createGraffitiThumb not capture, thumb size:[");
          k.g(localObject1, "thumb");
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Media.VideoMixer", ((Bitmap)localObject1).getWidth() + ", " + ((Bitmap)localObject1).getHeight() + "], thumbRotate:" + k + ", drawingRect:" + Arrays.toString(localVideoMixer.wnb));
        }
      }
      for (;;)
      {
        localObject4 = (CharSequence)localObject3;
        if (localObject4 == null) {
          break label2271;
        }
        if (((CharSequence)localObject4).length() != 0) {
          break label2288;
        }
        break label2271;
        label513:
        if (i == 0) {
          break label2245;
        }
        localObject3 = com.tencent.mm.plugin.recordvideo.e.b.wDE;
        ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).aqI(com.tencent.mm.plugin.recordvideo.e.b.wx(ce.azI()));
        localObject3 = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).wpa;
        localObject4 = localObject1;
        label545:
        if (localObject4 != null) {
          break label1742;
        }
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Media.VideoMixer", "createGraffitiThumb thumb is null");
        localObject1 = com.tencent.mm.plugin.recordvideo.d.f.wys;
        com.tencent.mm.plugin.recordvideo.d.f.dwx();
        localObject1 = com.tencent.mm.plugin.recordvideo.background.g.wmx;
        localObject1 = com.tencent.mm.plugin.recordvideo.background.g.a(this.wuk, (List)this.wuo.wpv, this.wmN, this.wup, this.wuo.wmm, this.hAy);
        localObject3 = h.wmI;
        h.dux();
        if (this.hAy == 3)
        {
          localObject3 = com.tencent.mm.plugin.recordvideo.d.e.wyr;
          com.tencent.mm.plugin.recordvideo.d.e.pu(this.wmN.Eya);
        }
        com.tencent.mm.ac.c.g((d.g.a.a)new d.g.b.l((String)localObject1) {});
        AppMethodBeat.o(75655);
        return;
        i = 0;
        break;
        label669:
        bool = false;
        break label101;
        label675:
        l = 0L;
        break label169;
        label681:
        i = 0;
        break label262;
        j = 0;
        break label302;
        label693:
        i = localb.gNU;
        break label314;
        label703:
        j = localb.gNV;
        break label326;
        i = Math.min(localb.gNU, localb.gNV);
        k.g(localObject1, "originThumb");
        f1 = ((Bitmap)localObject1).getWidth() / i;
        localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, (int)(((Bitmap)localObject1).getHeight() / f1), true);
        break label413;
        label768:
        if (((com.tencent.mm.plugin.recordvideo.b.c)localObject6).wpg.size() != 0) {
          break label794;
        }
        localObject1 = com.tencent.mm.plugin.mmsight.d.aX(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).woZ, l);
      }
      label794:
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      BitmapFactory.decodeFile((String)((com.tencent.mm.plugin.recordvideo.b.c)localObject6).wpg.get(0), (BitmapFactory.Options)localObject1);
      int i = ((BitmapFactory.Options)localObject1).outWidth;
      int j = ((BitmapFactory.Options)localObject1).outHeight;
      m = com.tencent.mm.plugin.recordvideo.b.e.wps.getMaxSize();
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
        ((BitmapFactory.Options)localObject1).inSampleSize = com.tencent.mm.sdk.platformtools.f.O(i, j, com.tencent.mm.plugin.recordvideo.b.e.wps.getMaxSize(), com.tencent.mm.plugin.recordvideo.b.e.wps.getMaxSize());
        ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
        ((BitmapFactory.Options)localObject1).inMutable = true;
        localObject4 = MMBitmapFactory.decodeFile((String)((com.tencent.mm.plugin.recordvideo.b.c)localObject6).wpg.get(0), (BitmapFactory.Options)localObject1);
        ((BitmapFactory.Options)localObject1).inSampleSize = com.tencent.mm.sdk.platformtools.f.O(i, j, com.tencent.mm.plugin.recordvideo.b.e.wps.getMaxSize() / 2, com.tencent.mm.plugin.recordvideo.b.e.wps.getMaxSize() / 2);
        localObject5 = new com.tencent.mm.ui.blur.e(ai.getContext());
        localObject1 = MMBitmapFactory.decodeFile((String)((com.tencent.mm.plugin.recordvideo.b.c)localObject6).wpg.get(0), (BitmapFactory.Options)localObject1);
      }
      label1150:
      Object localObject2;
      label1707:
      label1742:
      if ((localObject5 != null) && (!((c.a)localObject5).wDP))
      {
        localVideoMixer.wmT = new com.tencent.mm.plugin.recordvideo.background.d(localVideoMixer.wnb, localVideoMixer.gSw, ((Point)localObject2).x, ((Point)localObject2).y, ((c.a)localObject5).width, ((c.a)localObject5).height, k, false, localVideoMixer.wmm, 128);
        localObject2 = localVideoMixer.wmT;
        if (localObject2 == null) {
          k.aVY("frameRetriever");
        }
        ((com.tencent.mm.plugin.recordvideo.background.d)localObject2).start();
        localObject6 = (Bitmap)localVideoMixer.gSX.ay(Long.valueOf(1L));
        localObject2 = (Bitmap)localVideoMixer.gTW.ay(Long.valueOf(1L));
        localObject5 = localVideoMixer.wmT;
        if (localObject5 == null) {
          k.aVY("frameRetriever");
        }
        ((com.tencent.mm.plugin.recordvideo.background.d)localObject5).destroy();
        if (localObject2 == null) {
          break label2238;
        }
        localObject5 = VideoMixer.a((Bitmap)localObject4, (Bitmap)localObject2, 0.0F, (localb.gNV - ((Bitmap)localObject4).getHeight()) / 2.0F, 4);
        localObject2 = localObject5;
        if (localObject6 != null)
        {
          if (localb.gTI == 270) {
            break label2294;
          }
          if (localb.gTI != 90) {
            break label2300;
          }
          break label2294;
        }
      }
      for (;;)
      {
        label1846:
        if (j != 0)
        {
          i = localb.gNV;
          label2005:
          if (j == 0) {
            break label2171;
          }
          j = localb.gNU;
          label2017:
          if (((Bitmap)localObject4).getWidth() <= i) {
            break label2181;
          }
          localObject2 = VideoMixer.a((Bitmap)localObject6, (Bitmap)localObject5, (((Bitmap)localObject4).getWidth() - i) / 2.0F, 0.0F, 8);
          com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject2, 70, Bitmap.CompressFormat.JPEG, (String)localObject3, true);
          localObject2 = new StringBuilder("createGraffitiThumb : ").append((String)localObject3).append("   graffiti : ");
          if (localObject6 != null) {
            break label2232;
          }
        }
        label1960:
        label2232:
        for (bool = true;; bool = false)
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Media.VideoMixer", bool);
          break;
          label2113:
          localVideoMixer.wmT = new com.tencent.mm.plugin.recordvideo.background.d(localVideoMixer.wnb, localVideoMixer.gSw, ((Point)localObject2).x, ((Point)localObject2).y, 0, 0, k, false, localVideoMixer.wmm, 128);
          break label1846;
          i = localb.gNU;
          break label2005;
          label2171:
          j = localb.gNV;
          break label2017;
          if (((Bitmap)localObject4).getHeight() > j)
          {
            localObject2 = VideoMixer.a((Bitmap)localObject6, (Bitmap)localObject5, 0.0F, (((Bitmap)localObject4).getHeight() - j) / 2.0F, 4);
            break label2050;
          }
          localObject2 = VideoMixer.a((Bitmap)localObject6, (Bitmap)localObject5, 0.0F, 0.0F, 12);
          break label2050;
        }
        label2050:
        label2181:
        label2238:
        localObject5 = localObject4;
        break label1960;
        label2245:
        localObject4 = localObject2;
        break label545;
        localObject5 = localObject2;
        break label1150;
        label2259:
        i = 1;
        break;
        label2265:
        j = 1;
        break label302;
        label2271:
        i = 1;
        break label513;
        label2277:
        i = (int)(j * f2);
        break label369;
        label2288:
        i = 0;
        break label513;
        label2294:
        j = 1;
        continue;
        label2300:
        j = 0;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(ac paramac)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.ac
 * JD-Core Version:    0.7.0.1
 */