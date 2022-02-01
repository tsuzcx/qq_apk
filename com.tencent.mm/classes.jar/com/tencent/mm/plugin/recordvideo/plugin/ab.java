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
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.ch;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.b.f.b;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer;
import com.tencent.mm.plugin.recordvideo.e.c.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.i;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.o;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "abaParams", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getContext", "()Landroid/content/Context;", "setContext", "editConfig", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig;", "enable", "", "encode", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "getEncode", "()Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "setEncode", "(Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;)V", "loading", "Lcom/tencent/mm/plugin/recordvideo/ui/MediaProgressDialog;", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "x264RetryTime", "", "checkAudioCache", "", "audio", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "callback", "Lkotlin/Function0;", "checkBackgroundRemux", "error", "checkDaemonVideo", "checkForegroundRemux", "checkNoNeedRemuxVideo", "checkNullProvider", "checkSaveThumb", "videoPath", "", "thumbPath", "createMixer", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer;", "encodeConfig", "doFinish", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "forceRemux", "getMixer", "getTransformInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "runForeGround", "mixer", "runMixInBackground", "editorConfig", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "expiredTime", "", "scene", "setCaptureInfo", "info", "setMoovHead", "path", "snsCheck", "videoInfo", "Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "fileLength", "startReMux", "updateABABrWithQP", "Companion", "plugin-recordvideo_release"})
public final class ab
  implements t
{
  public static final ab.a xRQ;
  Context context;
  private boolean enable;
  private int[] sTT;
  private RecordConfigProvider sYT;
  private com.tencent.mm.plugin.recordvideo.ui.a xRL;
  private com.tencent.mm.media.widget.camerarecordview.b.b xRM;
  private com.tencent.mm.plugin.recordvideo.b.f xRN;
  f.b xRO;
  private int xRP;
  
  static
  {
    AppMethodBeat.i(75676);
    xRQ = new ab.a((byte)0);
    AppMethodBeat.o(75676);
  }
  
  public ab(Context paramContext)
  {
    AppMethodBeat.i(75675);
    this.context = paramContext;
    this.sTT = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    this.enable = true;
    this.xRO = new f.b((byte)0);
    AppMethodBeat.o(75675);
  }
  
  private final ab D(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(163435);
    if ((this.sYT == null) || (!this.enable))
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
    if (!this.xRO.xNo)
    {
      Object localObject1 = this.xRM;
      if ((localObject1 != null) && (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).axQ() == true))
      {
        localObject1 = this.sYT;
        if (localObject1 != null)
        {
          localObject1 = ((RecordConfigProvider)localObject1).xOg;
          if ((localObject1 != null) && (((VideoTransPara)localObject1).hYi == 1)) {}
        }
        else
        {
          localObject1 = this.sYT;
          if (localObject1 == null) {
            break label440;
          }
          localObject1 = ((RecordConfigProvider)localObject1).xOg;
          if ((localObject1 == null) || (((VideoTransPara)localObject1).hYi != 2)) {
            break label440;
          }
        }
        localObject1 = this.sYT;
        if (localObject1 != null)
        {
          localObject1 = ((RecordConfigProvider)localObject1).xOg;
          if ((localObject1 != null) && (((VideoTransPara)localObject1).hYs == 1)) {}
        }
        else
        {
          localObject1 = this.sYT;
          if (localObject1 != null)
          {
            localObject1 = ((RecordConfigProvider)localObject1).xOg;
            if ((localObject1 != null) && (((VideoTransPara)localObject1).hYs == 2)) {}
          }
          else
          {
            localObject1 = this.sYT;
            if (localObject1 == null) {
              break label440;
            }
            localObject1 = ((RecordConfigProvider)localObject1).xOg;
            if ((localObject1 == null) || (((VideoTransPara)localObject1).hYs != 4)) {
              break label440;
            }
          }
        }
        localObject1 = this.xRN;
        if (localObject1 == null) {
          p.gkB();
        }
        localObject1 = a((com.tencent.mm.plugin.recordvideo.b.f)localObject1, this.xRO);
        Object localObject2 = ((VideoMixer)localObject1).xKF;
        if (localObject2 != null) {
          ((AdaptiveAdjustBitrate)localObject2).xNk = 3000;
        }
        int i = ((VideoMixer)localObject1).dIr();
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", "ABA: useDarmonVideo: ".concat(String.valueOf(i)));
        if (i == 1)
        {
          parama.invoke();
          AppMethodBeat.o(163436);
          return this;
        }
        localObject1 = new StringBuilder("ABA::check DarmonVideo, add the metadate for video of low bitrate path: ");
        localObject2 = this.xRM;
        if (localObject2 == null) {
          p.gkB();
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).hwF);
        localObject1 = this.xRM;
        if (localObject1 == null) {
          p.gkB();
        }
        SightVideoJNI.addReportMetadata(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).hwF, new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 1, 0);
        label440:
        localObject1 = this.sYT;
        if (localObject1 != null)
        {
          parama = new StringBuilder("daemonMediaCaptureInfo into: \ndaemonVideoPath = ");
          localObject2 = this.xRM;
          if (localObject2 == null) {
            p.gkB();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).hwF).append(", daemonVideoSize = ");
          localObject2 = this.xRM;
          if (localObject2 == null) {
            p.gkB();
          }
          parama = parama.append(o.aZR(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).hwF)).append(", \nsourceVideoPath = ");
          localObject2 = this.xRM;
          if (localObject2 == null) {
            p.gkB();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).hwB).append(", captureSize = ");
          localObject2 = this.xRM;
          if (localObject2 == null) {
            p.gkB();
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", o.aZR(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).hwB) + ", \noutputSize = " + ((RecordConfigProvider)localObject1).xOt + ", outputSize = " + o.aZR(((RecordConfigProvider)localObject1).xOt));
          parama = this.xRM;
          if (parama == null) {
            p.gkB();
          }
          o.mF(parama.hwF, ((RecordConfigProvider)localObject1).xOt);
          parama = this.xRM;
          if (parama == null) {
            p.gkB();
          }
          o.mF(parama.hwG, ((RecordConfigProvider)localObject1).thumbPath);
          parama = com.tencent.mm.plugin.recordvideo.e.b.yhe;
          com.tencent.mm.plugin.recordvideo.e.b.c(this.xRM);
          parama = com.tencent.mm.plugin.recordvideo.e.b.yhe;
          com.tencent.mm.plugin.recordvideo.e.b.f((RecordConfigProvider)localObject1);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", "daemonMediaCaptureInfo 1: " + this.xRM);
          parama = new StringBuilder("daemonMediaCaptureInfo 2: \ndaemonVideoPath = ");
          localObject2 = this.xRM;
          if (localObject2 == null) {
            p.gkB();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).hwF).append(", daemonVideoSize = ");
          localObject2 = this.xRM;
          if (localObject2 == null) {
            p.gkB();
          }
          parama = parama.append(o.aZR(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).hwF)).append(", \nsourceVideoPath = ");
          localObject2 = this.xRM;
          if (localObject2 == null) {
            p.gkB();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).hwB).append(", captureSize = ");
          localObject2 = this.xRM;
          if (localObject2 == null) {
            p.gkB();
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", o.aZR(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).hwB) + ", \noutputSize = " + ((RecordConfigProvider)localObject1).xOt + ", outputSize = " + o.aZR(((RecordConfigProvider)localObject1).xOt));
          parama = ((RecordConfigProvider)localObject1).xOt;
          p.g(parama, "this.outputVideoPath");
          localObject2 = ((RecordConfigProvider)localObject1).thumbPath;
          p.g(localObject2, "this.thumbPath");
          iQ(parama, (String)localObject2);
          parama = ((RecordConfigProvider)localObject1).xOt;
          p.g(parama, "this.outputVideoPath");
          awZ(parama);
          parama = Boolean.TRUE;
          localObject2 = ((RecordConfigProvider)localObject1).xOt;
          localObject1 = ((RecordConfigProvider)localObject1).thumbPath;
          Object localObject3 = this.xRM;
          if (localObject3 == null) {
            p.gkB();
          }
          i = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject3).hwI;
          localObject3 = this.xRM;
          if (localObject3 == null) {
            p.gkB();
          }
          long l = i - ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject3).hwH;
          localObject3 = Boolean.FALSE;
          com.tencent.mm.plugin.recordvideo.d.c localc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          b(new CaptureDataManager.CaptureVideoNormalModel(parama, (String)localObject2, (String)localObject1, Long.valueOf(l), (Boolean)localObject3, com.tencent.mm.plugin.recordvideo.d.c.dKb()));
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
    Object localObject2 = this.sYT;
    if (localObject2 != null)
    {
      Object localObject1;
      if (this.xRO.xNn)
      {
        if (!this.xRO.xNo)
        {
          localObject1 = com.tencent.mm.media.b.b.hkC;
          if (!com.tencent.mm.media.b.b.atp()) {}
        }
      }
      else
      {
        localObject1 = this.xRN;
        label106:
        int i;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.recordvideo.b.f)localObject1).xNg;
          if (localObject1 != null) {
            break label682;
          }
          parama = this.xRM;
          if ((parama == null) || (parama.hwD != true)) {
            break label406;
          }
          if (((RecordConfigProvider)localObject2).scene != 2) {
            break label377;
          }
          parama = com.tencent.mm.media.k.d.hrI;
          com.tencent.mm.media.k.d.avh();
          parama = com.tencent.mm.plugin.recordvideo.e.b.yhe;
          com.tencent.mm.plugin.recordvideo.e.b.g(this.sYT);
          parama = ((RecordConfigProvider)localObject2).xOt;
          p.g(parama, "this.outputVideoPath");
          localObject1 = ((RecordConfigProvider)localObject2).thumbPath;
          p.g(localObject1, "this.thumbPath");
          iQ(parama, (String)localObject1);
          parama = ((RecordConfigProvider)localObject2).xOt;
          p.g(parama, "this.outputVideoPath");
          awZ(parama);
          parama = this.xRM;
          if (parama != null)
          {
            localObject1 = CaptureDataManager.xNV;
            p.g(localObject1, "CaptureDataManager.INSTANCE");
            ((CaptureDataManager)localObject1).getExtData().putBoolean("key_is_capture_video", parama.hwD);
            localObject1 = CaptureDataManager.xNV;
            p.g(localObject1, "CaptureDataManager.INSTANCE");
            localObject1 = ((CaptureDataManager)localObject1).getExtData();
            parama = (Collection)parama.hwK;
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
          localObject1 = ((RecordConfigProvider)localObject2).xOt;
          localObject2 = ((RecordConfigProvider)localObject2).thumbPath;
          localObject3 = this.xRN;
          if (localObject3 == null) {
            p.gkB();
          }
          i = ((com.tencent.mm.plugin.recordvideo.b.f)localObject3).xNk;
          localObject3 = this.xRN;
          if (localObject3 == null) {
            p.gkB();
          }
          l = i - ((com.tencent.mm.plugin.recordvideo.b.f)localObject3).xNj;
          localObject3 = Boolean.FALSE;
          localc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          b(new CaptureDataManager.CaptureVideoNormalModel(parama, (String)localObject1, (String)localObject2, Long.valueOf(l), (Boolean)localObject3, com.tencent.mm.plugin.recordvideo.d.c.dKb()));
          AppMethodBeat.o(163437);
          return null;
          localObject1 = null;
          break;
          label377:
          if (((RecordConfigProvider)localObject2).scene != 1) {
            break label106;
          }
          parama = com.tencent.mm.media.k.d.hrI;
          com.tencent.mm.media.k.d.avi();
          break label106;
          i = 0;
          break label250;
        }
        label406:
        parama = this.xRM;
        if (parama == null) {
          p.gkB();
        }
        parama = parama.hwB;
        localObject1 = ((RecordConfigProvider)localObject2).thumbPath;
        p.g(localObject1, "this.thumbPath");
        iQ(parama, (String)localObject1);
        parama = this.xRM;
        if (parama == null) {
          p.gkB();
        }
        awZ(parama.hwB);
        parama = this.xRM;
        if (parama != null)
        {
          localObject1 = CaptureDataManager.xNV;
          p.g(localObject1, "CaptureDataManager.INSTANCE");
          ((CaptureDataManager)localObject1).getExtData().putBoolean("key_is_capture_video", parama.hwD);
          localObject1 = CaptureDataManager.xNV;
          p.g(localObject1, "CaptureDataManager.INSTANCE");
          localObject1 = ((CaptureDataManager)localObject1).getExtData();
          parama = (Collection)parama.hwK;
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
          localObject1 = this.xRM;
          if (localObject1 == null) {
            p.gkB();
          }
          localObject1 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).hwB;
          localObject2 = ((RecordConfigProvider)localObject2).thumbPath;
          localObject3 = this.xRN;
          if (localObject3 == null) {
            p.gkB();
          }
          i = ((com.tencent.mm.plugin.recordvideo.b.f)localObject3).xNk;
          localObject3 = this.xRN;
          if (localObject3 == null) {
            p.gkB();
          }
          l = i - ((com.tencent.mm.plugin.recordvideo.b.f)localObject3).xNj;
          localObject3 = Boolean.FALSE;
          localc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          b(new CaptureDataManager.CaptureVideoNormalModel(parama, (String)localObject1, (String)localObject2, Long.valueOf(l), (Boolean)localObject3, com.tencent.mm.plugin.recordvideo.d.c.dKb()));
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
    Object localObject = this.sYT;
    if ((localObject != null) && (p.i(((RecordConfigProvider)localObject).xOn, Boolean.TRUE)))
    {
      parama = this.xRN;
      if (parama == null) {
        p.gkB();
      }
      parama = a(parama, this.xRO);
      localObject = com.tencent.mm.plugin.recordvideo.d.f.xXh;
      com.tencent.mm.plugin.recordvideo.d.f.qd(true);
      localObject = this.xRN;
      if (localObject == null) {
        p.gkB();
      }
      a(parama, (com.tencent.mm.plugin.recordvideo.b.f)localObject, this.xRO);
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
    Object localObject1 = com.tencent.mm.plugin.recordvideo.d.f.xXh;
    com.tencent.mm.plugin.recordvideo.d.f.qd(false);
    localObject1 = this.xRN;
    if (localObject1 == null) {
      p.gkB();
    }
    localObject1 = a((com.tencent.mm.plugin.recordvideo.b.f)localObject1, this.xRO);
    RecordConfigProvider localRecordConfigProvider = this.sYT;
    if (localRecordConfigProvider != null)
    {
      final y.f localf = new y.f();
      localf.NiY = new aip();
      parama = (aip)localf.NiY;
      Object localObject2 = this.xRN;
      if (localObject2 == null) {
        p.gkB();
      }
      int i = ((com.tencent.mm.plugin.recordvideo.b.f)localObject2).xNk;
      localObject2 = this.xRN;
      if (localObject2 == null) {
        p.gkB();
      }
      parama.duration = (i - ((com.tencent.mm.plugin.recordvideo.b.f)localObject2).xNj);
      ((aip)localf.NiY).Gyo = new LinkedList((Collection)d.a.e.O(this.sTT));
      localObject2 = (aip)localf.NiY;
      parama = localRecordConfigProvider.xOg;
      if (parama != null)
      {
        parama = Integer.valueOf(parama.hYi);
        if (parama == null) {
          p.gkB();
        }
        ((aip)localObject2).hYi = parama.intValue();
        parama = (aip)localf.NiY;
        localObject2 = this.xRM;
        if (localObject2 == null) {
          break label410;
        }
      }
      label410:
      for (boolean bool = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).hwD;; bool = false)
      {
        parama.Gyp = bool;
        ((aip)localf.NiY).BUO = this.xRO.xNo;
        ((aip)localf.NiY).xOq = localRecordConfigProvider.xOq;
        ((aip)localf.NiY).xOr = localRecordConfigProvider.xOr;
        ((aip)localf.NiY).xOs = localRecordConfigProvider.xOs;
        ((aip)localf.NiY).xOt = localRecordConfigProvider.xOt;
        ((aip)localf.NiY).Gyq = localRecordConfigProvider.thumbPath;
        ((aip)localf.NiY).xLA = ((VideoMixer)localObject1).xKL.hpg;
        ((aip)localf.NiY).Gyr = 0;
        parama = this.xRN;
        if (parama == null) {
          p.gkB();
        }
        a(parama.xNg, (d.g.a.a)new d(localRecordConfigProvider, localf, this, (VideoMixer)localObject1));
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
    RecordConfigProvider localRecordConfigProvider = this.sYT;
    float f;
    if ((localRecordConfigProvider != null) && (localRecordConfigProvider.scene == 2)) {
      f = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFI, 1.0F);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", "final kbps: " + f + "  " + paramb.videoBitrate * f);
      VideoMixer.a(localVideoMixer, paramb.targetWidth, paramb.targetHeight, (int)(f * paramb.videoBitrate), paramb.audioBitrate, paramb.audioSampleRate, paramb.audioChannelCount, paramb.frameRate, paramb.hoy);
      paramb = this.sYT;
      if (paramb != null) {}
      for (paramb = paramb.xOg;; paramb = null)
      {
        if (paramb == null) {
          p.gkB();
        }
        localVideoMixer.a(paramb, paramf.xNk, paramf.xNj);
        AppMethodBeat.o(75668);
        return localVideoMixer;
        localRecordConfigProvider = this.sYT;
        if (localRecordConfigProvider != null)
        {
          if (localRecordConfigProvider.scene != 1) {
            break label227;
          }
          f = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFH, 1.0F);
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
    Object localObject = com.tencent.mm.media.k.d.hrI;
    com.tencent.mm.media.k.d.avu();
    long l = bu.HQ();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", "start forceRemux");
    localObject = this.sYT;
    String str;
    int i;
    int j;
    label197:
    label215:
    int k;
    if (localObject != null)
    {
      localObject = ((RecordConfigProvider)localObject).xOt;
      str = p.C((String)localObject, "_tmp");
      localObject = this.sYT;
      if (localObject == null) {
        p.gkB();
      }
      if (((RecordConfigProvider)localObject).xOg.hYj != 2) {
        break label421;
      }
      localObject = this.sYT;
      if (localObject == null) {
        p.gkB();
      }
      i = ((RecordConfigProvider)localObject).xOg.hkJ;
      localObject = this.sYT;
      if (localObject == null) {
        p.gkB();
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", "ABA: Using Min Max QP Limitation: [%d], [%d] ", new Object[] { Integer.valueOf(i), Integer.valueOf(((RecordConfigProvider)localObject).xOg.hkK) });
      localObject = this.sYT;
      if (localObject == null) {
        p.gkB();
      }
      i = ((RecordConfigProvider)localObject).xOg.hkJ;
      localObject = this.sYT;
      if (localObject == null) {
        p.gkB();
      }
      j = ((RecordConfigProvider)localObject).xOg.hkK;
      localObject = this.sYT;
      if (localObject == null) {
        break label429;
      }
      localObject = ((RecordConfigProvider)localObject).xOt;
      k = paramb.targetWidth;
      int m = paramb.targetHeight;
      int n = paramb.videoBitrate;
      RecordConfigProvider localRecordConfigProvider = this.sYT;
      if (localRecordConfigProvider == null) {
        p.gkB();
      }
      int i1 = localRecordConfigProvider.xOg.hXX;
      localRecordConfigProvider = this.sYT;
      if (localRecordConfigProvider == null) {
        p.gkB();
      }
      k = SightVideoJNI.remuxingVFS((String)localObject, str, k, m, n, i1, 8, localRecordConfigProvider.xOg.hXW, 25.0F, paramb.frameRate, null, 0, false, i, j);
      paramb = this.sYT;
      if (paramb == null) {
        break label435;
      }
    }
    label421:
    label429:
    label435:
    for (paramb = paramb.xOt;; paramb = null)
    {
      o.mF(str, paramb);
      o.deleteFile(str);
      l = bu.aO(l);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", "minQP :" + i + "  maxQP :" + j + "  duration:" + k + " cost:" + l);
      paramb = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.rG(l);
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
    if (this.xRL == null)
    {
      localObject = new com.tencent.mm.plugin.recordvideo.ui.a();
      ((com.tencent.mm.plugin.recordvideo.ui.a)localObject).a(this.context, (d.g.a.a)ab.e.xRZ);
      this.xRL = ((com.tencent.mm.plugin.recordvideo.ui.a)localObject);
    }
    Object localObject = com.tencent.mm.plugin.recordvideo.background.f.xKs;
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
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", bool1);
      localObject = new com.tencent.mm.plugin.recordvideo.ui.a();
      ((com.tencent.mm.plugin.recordvideo.ui.a)localObject).a(this.context, (d.g.a.a)ab.b.xRR);
      this.xRL = ((com.tencent.mm.plugin.recordvideo.ui.a)localObject);
      if ((paramAudioCacheInfo == null) || (paramAudioCacheInfo.aXj)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", "checkAudioCache false");
      localObject = i.xPI;
      i.dJz().a(this.context, paramAudioCacheInfo, (m)new c(this, paramAudioCacheInfo, parama));
      AppMethodBeat.o(163440);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", "checkAudioCache done");
    parama.invoke();
    AppMethodBeat.o(163440);
  }
  
  private static void awZ(String paramString)
  {
    AppMethodBeat.i(75667);
    long l = bu.HQ();
    SightVideoJNI.optimizeMP4VFS(paramString);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.RemuxPlugin", "time cost: " + bu.aO(l));
    AppMethodBeat.o(75667);
  }
  
  private final VideoMixer b(com.tencent.mm.plugin.recordvideo.b.f paramf)
  {
    AppMethodBeat.i(75670);
    long l = System.currentTimeMillis();
    Object localObject1 = this.sYT;
    if (localObject1 != null)
    {
      localObject2 = ((RecordConfigProvider)localObject1).xOt;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.e.b.yhe;
      localObject1 = com.tencent.mm.plugin.recordvideo.e.b.axn(String.valueOf(l));
    }
    Object localObject2 = this.sYT;
    if (localObject2 != null)
    {
      localObject3 = ((RecordConfigProvider)localObject2).thumbPath;
      localObject2 = localObject3;
      if (localObject3 != null) {}
    }
    else
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.e.b.yhe;
      localObject2 = com.tencent.mm.plugin.recordvideo.e.b.axo(String.valueOf(l));
    }
    Object localObject3 = this.sYT;
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
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFD, 0) != 1) {
        break label694;
      }
      bool2 = true;
      i = com.tencent.mm.compatible.deviceinfo.ae.geT.gdP;
      if (i == -1) {
        break label706;
      }
      if (i != 1) {
        break label700;
      }
      bool1 = true;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", "sns config use x264 encode: " + bool2 + ", deviceUseX264Encode:" + i);
      bool4 = bool1;
      if (ay.fpb().getBoolean("mediacodec_create_error", false)) {
        bool4 = true;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", "final useX264Encode: ".concat(String.valueOf(bool4)));
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
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", "checkEnableHevc, deviceSwEnableHevc:" + i + ", deviceHwEnableHevc:" + j + ", exptSwEnableHevc:" + bool1 + ", exptHwEnableHevc:" + bool2);
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
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", "checkEnableHevc, hwEnableHevc:" + bool5 + ", swEnableHevc:" + bool3 + ", enableHevc:" + bool1 + ", useSoftEncode:" + bool2);
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
      if ((k == 3) && (!o.fB(localc.xMM)))
      {
        localObject3 = com.tencent.mm.plugin.recordvideo.d.e.xXg;
        com.tencent.mm.plugin.recordvideo.d.e.qc(localc.hwD);
      }
      List localList = (List)paramf.xNh;
      float[] arrayOfFloat1 = paramf.xKR;
      float[] arrayOfFloat2 = paramf.xKS;
      localObject3 = this.sYT;
      if (localObject3 != null)
      {
        localObject3 = ((RecordConfigProvider)localObject3).xOg;
        if (localObject3 == null) {}
      }
      for (i = ((VideoTransPara)localObject3).hYh;; i = 0)
      {
        localObject3 = paramf.xKW;
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
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFE, 0) == 1)
        {
          bool2 = true;
          label744:
          i = com.tencent.mm.compatible.deviceinfo.ae.geT.gdO;
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
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", "c2c config use x264 encode: " + bool2 + ", deviceUseX264Encode:" + i);
          break;
          bool2 = false;
          break label744;
          label806:
          bool1 = false;
          continue;
          label812:
          bool1 = bool2;
        }
        i = com.tencent.mm.compatible.deviceinfo.ae.geT.gdZ;
        break label286;
        i = com.tencent.mm.compatible.deviceinfo.ae.geT.gea;
        break label286;
        j = com.tencent.mm.compatible.deviceinfo.ae.geT.gdX;
        break label314;
        j = com.tencent.mm.compatible.deviceinfo.ae.geT.gdY;
        break label314;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNe, 0) == 1)
        {
          bool1 = true;
          break label343;
        }
        bool1 = false;
        break label343;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNd, 0) == 1)
        {
          bool1 = true;
          break label343;
        }
        bool1 = false;
        break label343;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNb, 0) == 1)
        {
          bool2 = true;
          break label371;
        }
        bool2 = false;
        break label371;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNc, 0) == 1)
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
    ay.fpb().putBoolean("mediacodec_create_error", false);
    CaptureDataManager.xNV.a(this.context, paramCaptureVideoNormalModel);
    AppMethodBeat.o(75672);
  }
  
  private final com.tencent.mm.plugin.recordvideo.b.c c(com.tencent.mm.plugin.recordvideo.b.f paramf)
  {
    boolean bool = true;
    AppMethodBeat.i(75671);
    com.tencent.mm.plugin.recordvideo.b.c localc = new com.tencent.mm.plugin.recordvideo.b.c();
    Object localObject = this.xRM;
    String str;
    if (localObject != null)
    {
      str = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).hwB;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localc.awW((String)localObject);
    localObject = this.xRM;
    if (localObject != null)
    {
      str = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).hwC;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localc.awX((String)localObject);
    localc.xMS = paramf.xNg;
    int i;
    if (paramf.xMW) {
      if (localc.xMS == null) {
        i = 0;
      }
    }
    for (;;)
    {
      localc.xMR = i;
      localObject = this.xRM;
      if (localObject != null) {
        bool = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).hwD;
      }
      localc.hwD = bool;
      localc.hoy = SightVideoJNI.getMp4RotateVFS(localc.xMM);
      localc.xMO = paramf.xNj;
      localc.xMP = paramf.xNk;
      localc.ar(paramf.xNl);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", "getTransformInfo :".concat(String.valueOf(localc)));
      AppMethodBeat.o(75671);
      return localc;
      i = 2;
      continue;
      if (localc.xMS == null) {
        i = 1;
      } else {
        i = 3;
      }
    }
  }
  
  private final void iQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(75673);
    if (o.fB(paramString2)) {
      o.deleteFile(paramString2);
    }
    paramString1 = com.tencent.mm.plugin.mmsight.d.GS(paramString1);
    Object localObject;
    if (paramString1 != null)
    {
      localObject = com.tencent.mm.plugin.recordvideo.e.b.yhe;
      localObject = this.sYT;
      if (localObject == null) {
        break label84;
      }
      localObject = ((RecordConfigProvider)localObject).xOg;
      if (localObject == null) {
        break label84;
      }
    }
    label84:
    for (int i = ((VideoTransPara)localObject).hYh;; i = 0)
    {
      h.a(com.tencent.mm.plugin.recordvideo.e.b.h(paramString1, i), 60, Bitmap.CompressFormat.JPEG, paramString2, true);
      AppMethodBeat.o(75673);
      return;
    }
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(75665);
    p.h(paramb, "info");
    p.h(paramRecordConfigProvider, "configProvider");
    this.xRM = paramb;
    this.sYT = paramRecordConfigProvider;
    paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.d.c.xWV;
    com.tencent.mm.plugin.recordvideo.d.c.u("KEY_IS_CAPUTRE_BOOLEAN", Boolean.valueOf(paramb.hwD));
    if (paramb.hwD)
    {
      paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_CAPUTRE_VIDEO_PATH_STRING", paramb.axS());
      paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      if (!paramb.axR()) {
        break label98;
      }
    }
    label98:
    for (paramb = paramb.hwC;; paramb = paramb.hwG)
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", "startReMux !!!!");
    Object localObject = D((d.g.a.a)new ab.h(this));
    if (localObject != null)
    {
      ((ab)localObject).xRN = paramf;
      ((ab)localObject).xRO = paramf.a(((ab)localObject).sYT, ((ab)localObject).xRM);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", "configProvider : " + ((ab)localObject).sYT);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", "RemuxMediaEditConfig : ".concat(String.valueOf(paramf)));
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", "mediaCaptureInfo : " + ((ab)localObject).xRM);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RemuxPlugin", "generateTargetConfig info: " + ((ab)localObject).xRO + ' ');
      paramf = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_VIDEO_IS_EDITED_BOOLEAN", Boolean.valueOf(((ab)localObject).xRO.xNo));
      paramf = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.avk();
      if (((ab)localObject).xRO.xNo)
      {
        paramf = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.avj();
      }
      if (localObject != null)
      {
        paramf = ((ab)localObject).E((d.g.a.a)ab.i.xSi);
        if (paramf != null)
        {
          localObject = com.tencent.mm.plugin.recordvideo.e.b.yhe;
          com.tencent.mm.plugin.recordvideo.e.b.c(paramf.xRM);
          if (paramf != null)
          {
            paramf = paramf.F((d.g.a.a)ab.j.xSj);
            if (paramf != null)
            {
              paramf = paramf.G((d.g.a.a)ab.k.xSk);
              if (paramf != null)
              {
                paramf.H((d.g.a.a)ab.l.xSl);
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
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void azm() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(206624);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(206624);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "success", "", "<anonymous parameter 1>", "", "invoke"})
  static final class c
    extends q
    implements m<Boolean, String, z>
  {
    c(ab paramab, AudioCacheInfo paramAudioCacheInfo, d.g.a.a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin$checkBackgroundRemux$1$1"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(RecordConfigProvider paramRecordConfigProvider, y.f paramf, ab paramab, VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(ab paramab, f.b paramb, VideoMixer paramVideoMixer, com.tencent.mm.plugin.recordvideo.b.f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(ab paramab, VideoMixer paramVideoMixer, f.b paramb, com.tencent.mm.plugin.recordvideo.b.f paramf, aip paramaip, long paramLong, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(75655);
      Object localObject1 = ab.g(this.xRS);
      Object localObject3;
      boolean bool;
      label101:
      VideoMixer localVideoMixer;
      Object localObject6;
      f.b localb;
      if (localObject1 != null)
      {
        localObject3 = CaptureDataManager.xNV;
        p.g(localObject3, "CaptureDataManager.INSTANCE");
        ((CaptureDataManager)localObject3).getExtData().putBoolean("key_is_capture_video", ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).hwD);
        localObject3 = CaptureDataManager.xNV;
        p.g(localObject3, "CaptureDataManager.INSTANCE");
        localObject3 = ((CaptureDataManager)localObject3).getExtData();
        localObject1 = (Collection)((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).hwK;
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
        localVideoMixer = this.xSb;
        localObject6 = this.xSb.xKL.xKE;
        localb = this.xSa;
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
        localObject3 = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xMN;
        if (((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xMO < 0L) {
          break label687;
        }
        l = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xMO;
        k = localVideoMixer.hoy;
        if (o.fB((String)localObject3)) {
          break label1719;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Media.VideoMixer", "create thumb bitmap : ".concat(String.valueOf(l)));
        if ((((com.tencent.mm.plugin.recordvideo.b.c)localObject6).hwD) || (bu.isNullOrNil(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xMM))) {
          break label780;
        }
        localObject1 = com.tencent.mm.plugin.mmsight.d.aZ(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xMM, l * 1000L);
        localObject4 = (CharSequence)localVideoMixer.xKL.xKW;
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
            localObject5 = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xMT.get(0);
            p.g(localObject5, "captureInfo.fakeVideoImageList[0]");
            i = VideoMixer.awU((String)localObject5);
            if (i == 0) {
              break;
            }
            localObject5 = new Matrix();
            ((Matrix)localObject5).postRotate(i);
            localObject4 = Bitmap.createBitmap((Bitmap)localObject4, 0, 0, ((Bitmap)localObject4).getWidth(), ((Bitmap)localObject4).getHeight(), (Matrix)localObject5, true);
            localObject5 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject5, true);
            p.g(localObject5, "Bitmap.createBitmap(bmBg…mBg.height, matrix, true)");
            localPoint = com.tencent.mm.plugin.recordvideo.b.e.xNf.dII();
            if (localObject4 == null) {
              p.gkB();
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
              com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.Media.VideoMixer", (Throwable)localException1, "createGraffitiThumb error", new Object[0]);
              com.tencent.mm.plugin.recordvideo.d.f localf = com.tencent.mm.plugin.recordvideo.d.f.xXh;
              com.tencent.mm.plugin.recordvideo.d.f.dKi();
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
            com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.Media.VideoMixer", (Throwable)localException2, "rsblur exception", new Object[0]);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Media.VideoMixer", "rsblur exception, path:%s", new Object[] { ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xMT.get(0) });
            localObject2 = com.tencent.mm.plugin.recordvideo.b.e.xNf.dII();
            localObject2 = h.aK(Color.parseColor("#ff000000"), ((Point)localObject2).x, ((Point)localObject2).y);
            p.g(localObject2, "BitmapUtil.createColorBi…0000\"), point.x, point.y)");
            continue;
            localObject2 = h.aK(Color.parseColor("#ff000000"), localPoint.x, localPoint.y);
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
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Media.VideoMixer", "exist thumb bitmap ");
          ((BitmapFactory.Options)localObject2).inMutable = true;
          localObject4 = h.decodeFile((String)localObject3, (BitmapFactory.Options)localObject2);
        }
        localObject2 = VideoMixer.hi(localb.targetWidth, localb.targetHeight);
        localObject5 = com.tencent.mm.plugin.recordvideo.e.c.yho;
        localObject5 = com.tencent.mm.plugin.recordvideo.e.c.axr(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xMM);
        if (((com.tencent.mm.plugin.recordvideo.b.c)localObject6).hwD) {
          break label2153;
        }
      }
      if ((i != 0) || (!o.fB(localVideoMixer.xKL.xKW)))
      {
        if (localb.hoy == 270) {
          break label2326;
        }
        if (localb.hoy == 90)
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
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Media.VideoMixer", "thumbHeight:" + j + " thumbWidth:" + i);
          localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, j, true);
          localObject4 = new StringBuilder("createGraffitiThumb not capture, thumb size:[");
          p.g(localObject1, "thumb");
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Media.VideoMixer", ((Bitmap)localObject1).getWidth() + ", " + ((Bitmap)localObject1).getHeight() + "], thumbRotate:" + k + ", drawingRect:" + Arrays.toString(localVideoMixer.xKL.xKR));
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
        localObject3 = com.tencent.mm.plugin.recordvideo.e.b.yhe;
        ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).awX(com.tencent.mm.plugin.recordvideo.e.b.zp(ch.aDb()));
        localObject3 = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xMN;
        localObject4 = localObject1;
        label557:
        if (localObject4 != null) {
          break label1754;
        }
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Media.VideoMixer", "createGraffitiThumb thumb is null");
        localObject1 = com.tencent.mm.plugin.recordvideo.d.f.xXh;
        com.tencent.mm.plugin.recordvideo.d.f.dKi();
        localObject1 = com.tencent.mm.plugin.recordvideo.background.e.xKl;
        localObject1 = com.tencent.mm.plugin.recordvideo.background.e.a(this.xSb, (List)this.xSf.xNi, this.xKx, this.xSg, this.xSf.xKW, this.hVL);
        localObject3 = com.tencent.mm.plugin.recordvideo.background.f.xKs;
        com.tencent.mm.plugin.recordvideo.background.f.dIk();
        if (this.hVL == 3)
        {
          localObject3 = com.tencent.mm.plugin.recordvideo.d.e.xXg;
          com.tencent.mm.plugin.recordvideo.d.e.pY(this.xKx.Gyp);
        }
        com.tencent.mm.ac.c.h((d.g.a.a)new q((String)localObject1) {});
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
        if (((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xMT.size() != 0) {
          break label806;
        }
        localObject1 = com.tencent.mm.plugin.mmsight.d.aZ(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xMM, l);
      }
      label806:
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      BitmapFactory.decodeFile((String)((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xMT.get(0), (BitmapFactory.Options)localObject1);
      int i = ((BitmapFactory.Options)localObject1).outWidth;
      int j = ((BitmapFactory.Options)localObject1).outHeight;
      m = com.tencent.mm.plugin.recordvideo.b.e.xNf.getMaxSize();
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
        ((BitmapFactory.Options)localObject1).inSampleSize = h.O(i, j, com.tencent.mm.plugin.recordvideo.b.e.xNf.getMaxSize(), com.tencent.mm.plugin.recordvideo.b.e.xNf.getMaxSize());
        ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
        ((BitmapFactory.Options)localObject1).inMutable = true;
        localObject4 = MMBitmapFactory.decodeFile((String)((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xMT.get(0), (BitmapFactory.Options)localObject1);
        ((BitmapFactory.Options)localObject1).inSampleSize = h.O(i, j, com.tencent.mm.plugin.recordvideo.b.e.xNf.getMaxSize() / 2, com.tencent.mm.plugin.recordvideo.b.e.xNf.getMaxSize() / 2);
        localObject5 = new com.tencent.mm.ui.blur.e(ak.getContext());
        localObject1 = MMBitmapFactory.decodeFile((String)((com.tencent.mm.plugin.recordvideo.b.c)localObject6).xMT.get(0), (BitmapFactory.Options)localObject1);
      }
      label1162:
      Object localObject2;
      label1719:
      label1754:
      if ((localObject5 != null) && (!((c.a)localObject5).yhp))
      {
        localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(localVideoMixer.xKL.xKR, localVideoMixer.xKL.xKS, localVideoMixer.xKL.pYz, ((Point)localObject2).x, ((Point)localObject2).y, ((c.a)localObject5).width, ((c.a)localObject5).height, k, false, localVideoMixer.xKL.xKW, 256));
        localVideoMixer.xKD = ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject2);
        localObject2 = localVideoMixer.xKD;
        if (localObject2 == null) {
          p.bdF("frameRetriever");
        }
        ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject2).start();
        localObject6 = (Bitmap)localVideoMixer.hnM.invoke(Long.valueOf(1L));
        localObject2 = (Bitmap)localVideoMixer.hoL.invoke(Long.valueOf(1L));
        localObject5 = localVideoMixer.xKD;
        if (localObject5 == null) {
          p.bdF("frameRetriever");
        }
        ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject5).destroy();
        if (localObject2 == null) {
          break label2299;
        }
        localObject5 = VideoMixer.a((Bitmap)localObject4, (Bitmap)localObject2, 0.0F, (localb.targetHeight - ((Bitmap)localObject4).getHeight()) / 2.0F, 4);
        localObject2 = localObject5;
        if (localObject6 != null)
        {
          if (localb.hoy == 270) {
            break label2355;
          }
          if (localb.hoy != 90) {
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
          h.a((Bitmap)localObject2, 70, Bitmap.CompressFormat.JPEG, (String)localObject3, true);
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
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Media.VideoMixer", bool);
          break;
          localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(localVideoMixer.xKL.xKR, localVideoMixer.xKL.xKS, localVideoMixer.xKL.pYz, ((Point)localObject2).x, ((Point)localObject2).y, 0, 0, k, false, localVideoMixer.xKL.xKW, 256));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.ab
 * JD-Core Version:    0.7.0.1
 */