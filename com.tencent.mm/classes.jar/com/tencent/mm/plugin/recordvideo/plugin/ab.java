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
import com.tencent.mm.plugin.recordvideo.e.c.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.m;
import d.g.a.r;
import d.g.b.k;
import d.g.b.v.c;
import d.g.b.v.e;
import d.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "abaParams", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getContext", "()Landroid/content/Context;", "setContext", "editConfig", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig;", "enable", "", "encode", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "getEncode", "()Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "setEncode", "(Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;)V", "loading", "Lcom/tencent/mm/plugin/recordvideo/ui/MediaProgressDialog;", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "x264RetryTime", "", "checkAudioCache", "", "audio", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "callback", "Lkotlin/Function0;", "checkBackgroundRemux", "error", "checkDaemonVideo", "checkForegroundRemux", "checkNoNeedRemuxVideo", "checkNullProvider", "checkSaveThumb", "videoPath", "", "thumbPath", "createMixer", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer;", "encodeConfig", "doFinish", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "forceRemux", "getMixer", "getTransformInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "runForeGround", "mixer", "runMixInBackground", "editorConfig", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "expiredTime", "", "scene", "setCaptureInfo", "info", "setMoovHead", "path", "snsCheck", "videoInfo", "Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "fileLength", "startReMux", "updateABABrWithQP", "Companion", "plugin-recordvideo_release"})
public final class ab
  implements t
{
  public static final a vlt;
  Context context;
  private boolean enable;
  private int[] qQH;
  private RecordConfigProvider vcC;
  private com.tencent.mm.plugin.recordvideo.ui.a vlo;
  private com.tencent.mm.media.widget.camerarecordview.b.b vlp;
  private com.tencent.mm.plugin.recordvideo.b.f vlq;
  f.b vlr;
  private int vls;
  
  static
  {
    AppMethodBeat.i(75676);
    vlt = new a((byte)0);
    AppMethodBeat.o(75676);
  }
  
  public ab(Context paramContext)
  {
    AppMethodBeat.i(75675);
    this.context = paramContext;
    this.qQH = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    this.enable = true;
    this.vlr = new f.b((byte)0);
    AppMethodBeat.o(75675);
  }
  
  private final VideoMixer a(com.tencent.mm.plugin.recordvideo.b.f paramf, f.b paramb)
  {
    AppMethodBeat.i(75668);
    VideoMixer localVideoMixer = b(paramf);
    RecordConfigProvider localRecordConfigProvider = this.vcC;
    float f;
    if ((localRecordConfigProvider != null) && (localRecordConfigProvider.scene == 2)) {
      f = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pql, 1.0F);
    }
    for (;;)
    {
      ad.i("MicroMsg.RemuxPlugin", "final kbps: " + f + "  " + paramb.videoBitrate * f);
      VideoMixer.a(localVideoMixer, paramb.gnh, paramb.gni, (int)(f * paramb.videoBitrate), paramb.audioBitrate, paramb.audioSampleRate, paramb.gnH, paramb.frameRate, paramb.gta);
      paramb = this.vcC;
      if (paramb != null) {}
      for (paramb = paramb.vhH;; paramb = null)
      {
        if (paramb == null) {
          k.fvU();
        }
        localVideoMixer.a(paramb, paramf.vgL, paramf.vgK);
        AppMethodBeat.o(75668);
        return localVideoMixer;
        localRecordConfigProvider = this.vcC;
        if (localRecordConfigProvider != null)
        {
          if (localRecordConfigProvider.scene != 1) {
            break label221;
          }
          f = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqk, 1.0F);
          break;
        }
        f = 1.0F;
        break;
      }
      label221:
      f = 1.0F;
    }
  }
  
  private final void a(f.b paramb)
  {
    AppMethodBeat.i(75674);
    Object localObject = com.tencent.mm.media.j.d.gwr;
    com.tencent.mm.media.j.d.aly();
    long l = bt.GC();
    ad.i("MicroMsg.RemuxPlugin", "start forceRemux");
    localObject = this.vcC;
    String str;
    int i;
    int j;
    label197:
    label215:
    int k;
    if (localObject != null)
    {
      localObject = ((RecordConfigProvider)localObject).vhU;
      str = k.C((String)localObject, "_tmp");
      localObject = this.vcC;
      if (localObject == null) {
        k.fvU();
      }
      if (((RecordConfigProvider)localObject).vhH.hck != 2) {
        break label421;
      }
      localObject = this.vcC;
      if (localObject == null) {
        k.fvU();
      }
      i = ((RecordConfigProvider)localObject).vhH.gnp;
      localObject = this.vcC;
      if (localObject == null) {
        k.fvU();
      }
      ad.i("MicroMsg.RemuxPlugin", "ABA: Using Min Max QP Limitation: [%d], [%d] ", new Object[] { Integer.valueOf(i), Integer.valueOf(((RecordConfigProvider)localObject).vhH.gnq) });
      localObject = this.vcC;
      if (localObject == null) {
        k.fvU();
      }
      i = ((RecordConfigProvider)localObject).vhH.gnp;
      localObject = this.vcC;
      if (localObject == null) {
        k.fvU();
      }
      j = ((RecordConfigProvider)localObject).vhH.gnq;
      localObject = this.vcC;
      if (localObject == null) {
        break label429;
      }
      localObject = ((RecordConfigProvider)localObject).vhU;
      k = paramb.gnh;
      int m = paramb.gni;
      int n = paramb.videoBitrate;
      RecordConfigProvider localRecordConfigProvider = this.vcC;
      if (localRecordConfigProvider == null) {
        k.fvU();
      }
      int i1 = localRecordConfigProvider.vhH.hbY;
      localRecordConfigProvider = this.vcC;
      if (localRecordConfigProvider == null) {
        k.fvU();
      }
      k = SightVideoJNI.remuxingVFS((String)localObject, str, k, m, n, i1, 8, localRecordConfigProvider.vhH.hbX, 25.0F, paramb.frameRate, null, 0, false, i, j);
      paramb = this.vcC;
      if (paramb == null) {
        break label435;
      }
    }
    label421:
    label429:
    label435:
    for (paramb = paramb.vhU;; paramb = null)
    {
      com.tencent.mm.vfs.i.lC(str, paramb);
      com.tencent.mm.vfs.i.deleteFile(str);
      l = bt.aS(l);
      ad.i("MicroMsg.RemuxPlugin", "minQP :" + i + "  maxQP :" + j + "  duration:" + k + " cost:" + l);
      paramb = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.lG(l);
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
    if (this.vlo == null)
    {
      localObject = new com.tencent.mm.plugin.recordvideo.ui.a();
      ((com.tencent.mm.plugin.recordvideo.ui.a)localObject).a(this.context, (d.g.a.a)e.vlC);
      this.vlo = ((com.tencent.mm.plugin.recordvideo.ui.a)localObject);
    }
    Object localObject = com.tencent.mm.plugin.recordvideo.background.g.vdS;
    com.tencent.mm.plugin.recordvideo.background.g.s((d.g.a.a)new f(this, paramb, paramVideoMixer, paramf));
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
        bool1 = paramAudioCacheInfo.aMb;
      }
      ad.i("MicroMsg.RemuxPlugin", bool1);
      localObject = new com.tencent.mm.plugin.recordvideo.ui.a();
      ((com.tencent.mm.plugin.recordvideo.ui.a)localObject).a(this.context, (d.g.a.a)b.vlu);
      this.vlo = ((com.tencent.mm.plugin.recordvideo.ui.a)localObject);
      if ((paramAudioCacheInfo == null) || (paramAudioCacheInfo.aMb)) {
        break;
      }
      ad.i("MicroMsg.RemuxPlugin", "checkAudioCache false");
      localObject = com.tencent.mm.plugin.recordvideo.model.audio.i.vjj;
      com.tencent.mm.plugin.recordvideo.model.audio.i.dhZ().a(this.context, paramAudioCacheInfo, (m)new c(this, paramAudioCacheInfo, parama));
      AppMethodBeat.o(163440);
      return;
    }
    ad.i("MicroMsg.RemuxPlugin", "checkAudioCache done");
    parama.invoke();
    AppMethodBeat.o(163440);
  }
  
  private static void alL(String paramString)
  {
    AppMethodBeat.i(75667);
    long l = bt.GC();
    SightVideoJNI.optimizeMP4VFS(paramString);
    ad.d("MicroMsg.RemuxPlugin", "time cost: " + bt.aS(l));
    AppMethodBeat.o(75667);
  }
  
  private final VideoMixer b(com.tencent.mm.plugin.recordvideo.b.f paramf)
  {
    AppMethodBeat.i(75670);
    long l = System.currentTimeMillis();
    Object localObject1 = this.vcC;
    if (localObject1 != null)
    {
      localObject2 = ((RecordConfigProvider)localObject1).vhU;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.e.b.vtE;
      localObject1 = com.tencent.mm.plugin.recordvideo.e.b.alV(String.valueOf(l));
    }
    Object localObject2 = this.vcC;
    if (localObject2 != null)
    {
      localObject3 = ((RecordConfigProvider)localObject2).thumbPath;
      localObject2 = localObject3;
      if (localObject3 != null) {}
    }
    else
    {
      localObject2 = com.tencent.mm.plugin.recordvideo.e.b.vtE;
      localObject2 = com.tencent.mm.plugin.recordvideo.e.b.alW(String.valueOf(l));
    }
    Object localObject3 = this.vcC;
    int k;
    boolean bool1;
    boolean bool2;
    label153:
    int i;
    label173:
    label206:
    boolean bool4;
    label282:
    int j;
    label310:
    label339:
    label367:
    boolean bool3;
    boolean bool5;
    if (localObject3 != null)
    {
      k = ((RecordConfigProvider)localObject3).scene;
      bool1 = false;
      if ((k != 2) && (k != 11)) {
        break label694;
      }
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqg, 0) != 1) {
        break label675;
      }
      bool2 = true;
      i = ae.fFD.fEA;
      if (i == -1) {
        break label687;
      }
      if (i != 1) {
        break label681;
      }
      bool1 = true;
      ad.i("MicroMsg.RemuxPlugin", "sns config use x264 encode: " + bool2 + ", deviceUseX264Encode:" + i);
      bool4 = bool1;
      if (ax.eGe().getBoolean("mediacodec_create_error", false)) {
        bool4 = true;
      }
      ad.i("MicroMsg.RemuxPlugin", "final useX264Encode: ".concat(String.valueOf(bool4)));
      bool1 = false;
      if ((k != 2) && (k != 1)) {
        break label1055;
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
                label445:
                if ((bool2) || (j != -1))
                {
                  if (j != 1) {
                    break label994;
                  }
                  bool5 = true;
                }
                label463:
                bool1 = false;
                if (!bool4) {
                  break label1017;
                }
                bool1 = bool3;
                bool2 = bool4;
                label479:
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
      if ((k == 3) && (!com.tencent.mm.vfs.i.eK(localc.vgn)))
      {
        localObject3 = com.tencent.mm.plugin.recordvideo.d.d.vpA;
        com.tencent.mm.plugin.recordvideo.d.d.oA(localc.gBl);
      }
      List localList = (List)paramf.vgI;
      float[] arrayOfFloat = paramf.vem;
      localObject3 = this.vcC;
      if (localObject3 != null)
      {
        localObject3 = ((RecordConfigProvider)localObject3).vhH;
        if (localObject3 == null) {}
      }
      for (i = ((VideoTransPara)localObject3).hci;; i = 0)
      {
        localObject3 = paramf.vdw;
        paramf = (com.tencent.mm.plugin.recordvideo.b.f)localObject3;
        if (localObject3 == null) {
          paramf = "";
        }
        paramf = new VideoMixer(localc, localList, arrayOfFloat, (String)localObject1, (String)localObject2, 0, bool2, bool1, i, paramf, 32);
        AppMethodBeat.o(75670);
        return paramf;
        k = 0;
        break;
        label675:
        bool2 = false;
        break label153;
        label681:
        bool1 = false;
        break label173;
        label687:
        bool1 = bool2;
        break label173;
        label694:
        if (k != 1) {
          break label206;
        }
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqh, 0) == 1)
        {
          bool2 = true;
          label724:
          i = ae.fFD.fEz;
          if (i == -1) {
            break label792;
          }
          if (i != 1) {
            break label786;
          }
          bool1 = true;
        }
        for (;;)
        {
          ad.i("MicroMsg.RemuxPlugin", "c2c config use x264 encode: " + bool2 + ", deviceUseX264Encode:" + i);
          break;
          bool2 = false;
          break label724;
          label786:
          bool1 = false;
          continue;
          label792:
          bool1 = bool2;
        }
        i = ae.fFD.fEK;
        break label282;
        i = ae.fFD.fEL;
        break label282;
        j = ae.fFD.fEI;
        break label310;
        j = ae.fFD.fEJ;
        break label310;
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pvP, 0) == 1)
        {
          bool1 = true;
          break label339;
        }
        bool1 = false;
        break label339;
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pvO, 0) == 1)
        {
          bool1 = true;
          break label339;
        }
        bool1 = false;
        break label339;
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pvM, 0) == 1)
        {
          bool2 = true;
          break label367;
        }
        bool2 = false;
        break label367;
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pvN, 0) == 1)
        {
          bool2 = true;
          break label367;
        }
        bool2 = false;
        break label367;
        if ((bool1) && (i == 2))
        {
          bool3 = false;
          break label445;
        }
        bool3 = bool1;
        break label445;
        label994:
        if ((bool2) && (j == 2))
        {
          bool5 = false;
          break label463;
        }
        bool5 = bool2;
        break label463;
        label1017:
        if (bool3)
        {
          bool2 = true;
          bool1 = true;
          break label479;
        }
        bool2 = bool4;
        if (!bool5) {
          break label479;
        }
        bool1 = true;
        bool2 = bool4;
        break label479;
      }
      label1055:
      bool2 = bool4;
    }
  }
  
  private final com.tencent.mm.plugin.recordvideo.b.c c(com.tencent.mm.plugin.recordvideo.b.f paramf)
  {
    boolean bool = true;
    AppMethodBeat.i(75671);
    com.tencent.mm.plugin.recordvideo.b.c localc = new com.tencent.mm.plugin.recordvideo.b.c();
    Object localObject = this.vlp;
    String str;
    if (localObject != null)
    {
      str = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).gBj;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localc.alI((String)localObject);
    localObject = this.vlp;
    if (localObject != null)
    {
      str = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).gBk;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localc.alJ((String)localObject);
    localc.vgt = paramf.vgH;
    int i;
    if (paramf.vgx) {
      if (localc.vgt == null) {
        i = 0;
      }
    }
    for (;;)
    {
      localc.vgs = i;
      localObject = this.vlp;
      if (localObject != null) {
        bool = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).gBl;
      }
      localc.gBl = bool;
      localc.gta = SightVideoJNI.getMp4RotateVFS(localc.vgn);
      localc.vgp = paramf.vgK;
      localc.vgq = paramf.vgL;
      localc.ah(paramf.vgM);
      ad.i("MicroMsg.RemuxPlugin", "getTransformInfo :".concat(String.valueOf(localc)));
      AppMethodBeat.o(75671);
      return localc;
      i = 2;
      continue;
      if (localc.vgt == null) {
        i = 1;
      } else {
        i = 3;
      }
    }
  }
  
  private final void c(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(75672);
    ax.eGe().putBoolean("mediacodec_create_error", false);
    CaptureDataManager.vhw.a(this.context, paramCaptureVideoNormalModel);
    AppMethodBeat.o(75672);
  }
  
  private final void ie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(75673);
    if (com.tencent.mm.vfs.i.eK(paramString2)) {
      com.tencent.mm.vfs.i.deleteFile(paramString2);
    }
    paramString1 = com.tencent.mm.plugin.mmsight.d.zg(paramString1);
    Object localObject;
    if (paramString1 != null)
    {
      localObject = com.tencent.mm.plugin.recordvideo.e.b.vtE;
      localObject = this.vcC;
      if (localObject == null) {
        break label84;
      }
      localObject = ((RecordConfigProvider)localObject).vhH;
      if (localObject == null) {
        break label84;
      }
    }
    label84:
    for (int i = ((VideoTransPara)localObject).hci;; i = 0)
    {
      com.tencent.mm.sdk.platformtools.f.a(com.tencent.mm.plugin.recordvideo.e.b.h(paramString1, i), 60, Bitmap.CompressFormat.JPEG, paramString2, true);
      AppMethodBeat.o(75673);
      return;
    }
  }
  
  private final ab t(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(163435);
    if ((this.vcC == null) || (!this.enable))
    {
      parama.invoke();
      AppMethodBeat.o(163435);
      return null;
    }
    this.enable = false;
    AppMethodBeat.o(163435);
    return this;
  }
  
  private final ab u(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(163436);
    if (!this.vlr.vgP)
    {
      Object localObject1 = this.vlp;
      if ((localObject1 != null) && (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).anY() == true))
      {
        localObject1 = this.vcC;
        if (localObject1 != null)
        {
          localObject1 = ((RecordConfigProvider)localObject1).vhH;
          if ((localObject1 != null) && (((VideoTransPara)localObject1).hcj == 1)) {}
        }
        else
        {
          localObject1 = this.vcC;
          if (localObject1 == null) {
            break label444;
          }
          localObject1 = ((RecordConfigProvider)localObject1).vhH;
          if ((localObject1 == null) || (((VideoTransPara)localObject1).hcj != 2)) {
            break label444;
          }
        }
        localObject1 = this.vcC;
        if (localObject1 != null)
        {
          localObject1 = ((RecordConfigProvider)localObject1).vhH;
          if ((localObject1 != null) && (((VideoTransPara)localObject1).hcs == 1)) {}
        }
        else
        {
          localObject1 = this.vcC;
          if (localObject1 != null)
          {
            localObject1 = ((RecordConfigProvider)localObject1).vhH;
            if ((localObject1 != null) && (((VideoTransPara)localObject1).hcs == 2)) {}
          }
          else
          {
            localObject1 = this.vcC;
            if (localObject1 == null) {
              break label444;
            }
            localObject1 = ((RecordConfigProvider)localObject1).vhH;
            if ((localObject1 == null) || (((VideoTransPara)localObject1).hcs != 4)) {
              break label444;
            }
          }
        }
        localObject1 = this.vlq;
        if (localObject1 == null) {
          k.fvU();
        }
        localObject1 = a((com.tencent.mm.plugin.recordvideo.b.f)localObject1, this.vlr);
        Object localObject2 = ((VideoMixer)localObject1).vef;
        if (localObject2 != null) {
          ((AdaptiveAdjustBitrate)localObject2).vgL = 3000;
        }
        int i = ((VideoMixer)localObject1).dgW();
        ad.i("MicroMsg.RemuxPlugin", "ABA: useDarmonVideo: ".concat(String.valueOf(i)));
        if (i == 1)
        {
          parama.invoke();
          AppMethodBeat.o(163436);
          return this;
        }
        localObject1 = new StringBuilder("ABA::check DarmonVideo, add the metadate for video of low bitrate path: ");
        localObject2 = this.vlp;
        if (localObject2 == null) {
          k.fvU();
        }
        ad.i("MicroMsg.RemuxPlugin", ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).gBn);
        localObject1 = this.vlp;
        if (localObject1 == null) {
          k.fvU();
        }
        SightVideoJNI.addReportMetadata(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).gBn, new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 1, 0);
        label444:
        localObject1 = this.vcC;
        if (localObject1 != null)
        {
          parama = new StringBuilder("daemonMediaCaptureInfo into: \ndaemonVideoPath = ");
          localObject2 = this.vlp;
          if (localObject2 == null) {
            k.fvU();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).gBn).append(", daemonVideoSize = ");
          localObject2 = this.vlp;
          if (localObject2 == null) {
            k.fvU();
          }
          parama = parama.append(com.tencent.mm.vfs.i.aMN(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).gBn)).append(", \nsourceVideoPath = ");
          localObject2 = this.vlp;
          if (localObject2 == null) {
            k.fvU();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).gBj).append(", captureSize = ");
          localObject2 = this.vlp;
          if (localObject2 == null) {
            k.fvU();
          }
          ad.i("MicroMsg.RemuxPlugin", com.tencent.mm.vfs.i.aMN(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).gBj) + ", \noutputSize = " + ((RecordConfigProvider)localObject1).vhU + ", outputSize = " + com.tencent.mm.vfs.i.aMN(((RecordConfigProvider)localObject1).vhU));
          parama = this.vlp;
          if (parama == null) {
            k.fvU();
          }
          com.tencent.mm.vfs.i.lC(parama.gBn, ((RecordConfigProvider)localObject1).vhU);
          parama = this.vlp;
          if (parama == null) {
            k.fvU();
          }
          com.tencent.mm.vfs.i.lC(parama.gBo, ((RecordConfigProvider)localObject1).thumbPath);
          parama = com.tencent.mm.plugin.recordvideo.e.b.vtE;
          com.tencent.mm.plugin.recordvideo.e.b.b(this.vlp);
          parama = com.tencent.mm.plugin.recordvideo.e.b.vtE;
          com.tencent.mm.plugin.recordvideo.e.b.e((RecordConfigProvider)localObject1);
          ad.i("MicroMsg.RemuxPlugin", "daemonMediaCaptureInfo 1: " + this.vlp);
          parama = new StringBuilder("daemonMediaCaptureInfo 2: \ndaemonVideoPath = ");
          localObject2 = this.vlp;
          if (localObject2 == null) {
            k.fvU();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).gBn).append(", daemonVideoSize = ");
          localObject2 = this.vlp;
          if (localObject2 == null) {
            k.fvU();
          }
          parama = parama.append(com.tencent.mm.vfs.i.aMN(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).gBn)).append(", \nsourceVideoPath = ");
          localObject2 = this.vlp;
          if (localObject2 == null) {
            k.fvU();
          }
          parama = parama.append(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).gBj).append(", captureSize = ");
          localObject2 = this.vlp;
          if (localObject2 == null) {
            k.fvU();
          }
          ad.i("MicroMsg.RemuxPlugin", com.tencent.mm.vfs.i.aMN(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).gBj) + ", \noutputSize = " + ((RecordConfigProvider)localObject1).vhU + ", outputSize = " + com.tencent.mm.vfs.i.aMN(((RecordConfigProvider)localObject1).vhU));
          parama = ((RecordConfigProvider)localObject1).vhU;
          k.g(parama, "this.outputVideoPath");
          localObject2 = ((RecordConfigProvider)localObject1).thumbPath;
          k.g(localObject2, "this.thumbPath");
          ie(parama, (String)localObject2);
          parama = ((RecordConfigProvider)localObject1).vhU;
          k.g(parama, "this.outputVideoPath");
          alL(parama);
          parama = Boolean.TRUE;
          localObject2 = ((RecordConfigProvider)localObject1).vhU;
          localObject1 = ((RecordConfigProvider)localObject1).thumbPath;
          Object localObject3 = this.vlp;
          if (localObject3 == null) {
            k.fvU();
          }
          i = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject3).gBq;
          localObject3 = this.vlp;
          if (localObject3 == null) {
            k.fvU();
          }
          long l = i - ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject3).gBp;
          localObject3 = Boolean.FALSE;
          com.tencent.mm.plugin.recordvideo.d.b localb = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          c(new CaptureDataManager.CaptureVideoNormalModel(parama, (String)localObject2, (String)localObject1, Long.valueOf(l), (Boolean)localObject3, com.tencent.mm.plugin.recordvideo.d.b.dix()));
          AppMethodBeat.o(163436);
          return null;
        }
      }
    }
    parama.invoke();
    AppMethodBeat.o(163436);
    return this;
  }
  
  private final ab v(d.g.a.a<y> parama)
  {
    boolean bool = true;
    AppMethodBeat.i(163437);
    Object localObject2 = this.vcC;
    if (localObject2 != null)
    {
      Object localObject1;
      if (this.vlr.vgO)
      {
        if (!this.vlr.vgP)
        {
          localObject1 = com.tencent.mm.media.b.b.gnf;
          if (!com.tencent.mm.media.b.b.ajl()) {}
        }
      }
      else
      {
        localObject1 = this.vlq;
        label106:
        int i;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.recordvideo.b.f)localObject1).vgH;
          if (localObject1 != null) {
            break label682;
          }
          parama = this.vlp;
          if ((parama == null) || (parama.gBl != true)) {
            break label406;
          }
          if (((RecordConfigProvider)localObject2).scene != 2) {
            break label377;
          }
          parama = com.tencent.mm.media.j.d.gwr;
          com.tencent.mm.media.j.d.all();
          parama = com.tencent.mm.plugin.recordvideo.e.b.vtE;
          com.tencent.mm.plugin.recordvideo.e.b.f(this.vcC);
          parama = ((RecordConfigProvider)localObject2).vhU;
          k.g(parama, "this.outputVideoPath");
          localObject1 = ((RecordConfigProvider)localObject2).thumbPath;
          k.g(localObject1, "this.thumbPath");
          ie(parama, (String)localObject1);
          parama = ((RecordConfigProvider)localObject2).vhU;
          k.g(parama, "this.outputVideoPath");
          alL(parama);
          parama = this.vlp;
          if (parama != null)
          {
            localObject1 = CaptureDataManager.vhw;
            k.g(localObject1, "CaptureDataManager.INSTANCE");
            ((CaptureDataManager)localObject1).getExtData().putBoolean("key_is_capture_video", parama.gBl);
            localObject1 = CaptureDataManager.vhw;
            k.g(localObject1, "CaptureDataManager.INSTANCE");
            localObject1 = ((CaptureDataManager)localObject1).getExtData();
            parama = (Collection)parama.gBs;
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
        com.tencent.mm.plugin.recordvideo.d.b localb;
        label396:
        label401:
        for (bool = true;; bool = false)
        {
          ((Bundle)localObject1).putBoolean("key_is_photo_video", bool);
          parama = Boolean.TRUE;
          localObject1 = ((RecordConfigProvider)localObject2).vhU;
          localObject2 = ((RecordConfigProvider)localObject2).thumbPath;
          localObject3 = this.vlq;
          if (localObject3 == null) {
            k.fvU();
          }
          i = ((com.tencent.mm.plugin.recordvideo.b.f)localObject3).vgL;
          localObject3 = this.vlq;
          if (localObject3 == null) {
            k.fvU();
          }
          l = i - ((com.tencent.mm.plugin.recordvideo.b.f)localObject3).vgK;
          localObject3 = Boolean.FALSE;
          localb = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          c(new CaptureDataManager.CaptureVideoNormalModel(parama, (String)localObject1, (String)localObject2, Long.valueOf(l), (Boolean)localObject3, com.tencent.mm.plugin.recordvideo.d.b.dix()));
          AppMethodBeat.o(163437);
          return null;
          localObject1 = null;
          break;
          label377:
          if (((RecordConfigProvider)localObject2).scene != 1) {
            break label106;
          }
          parama = com.tencent.mm.media.j.d.gwr;
          com.tencent.mm.media.j.d.alm();
          break label106;
          i = 0;
          break label250;
        }
        label406:
        parama = this.vlp;
        if (parama == null) {
          k.fvU();
        }
        parama = parama.gBj;
        localObject1 = ((RecordConfigProvider)localObject2).thumbPath;
        k.g(localObject1, "this.thumbPath");
        ie(parama, (String)localObject1);
        parama = this.vlp;
        if (parama == null) {
          k.fvU();
        }
        alL(parama.gBj);
        parama = this.vlp;
        if (parama != null)
        {
          localObject1 = CaptureDataManager.vhw;
          k.g(localObject1, "CaptureDataManager.INSTANCE");
          ((CaptureDataManager)localObject1).getExtData().putBoolean("key_is_capture_video", parama.gBl);
          localObject1 = CaptureDataManager.vhw;
          k.g(localObject1, "CaptureDataManager.INSTANCE");
          localObject1 = ((CaptureDataManager)localObject1).getExtData();
          parama = (Collection)parama.gBs;
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
          localObject1 = this.vlp;
          if (localObject1 == null) {
            k.fvU();
          }
          localObject1 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).gBj;
          localObject2 = ((RecordConfigProvider)localObject2).thumbPath;
          localObject3 = this.vlq;
          if (localObject3 == null) {
            k.fvU();
          }
          i = ((com.tencent.mm.plugin.recordvideo.b.f)localObject3).vgL;
          localObject3 = this.vlq;
          if (localObject3 == null) {
            k.fvU();
          }
          l = i - ((com.tencent.mm.plugin.recordvideo.b.f)localObject3).vgK;
          localObject3 = Boolean.FALSE;
          localb = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          c(new CaptureDataManager.CaptureVideoNormalModel(parama, (String)localObject1, (String)localObject2, Long.valueOf(l), (Boolean)localObject3, com.tencent.mm.plugin.recordvideo.d.b.dix()));
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
  
  private final ab w(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(163438);
    Object localObject = this.vcC;
    if ((localObject != null) && (k.g(((RecordConfigProvider)localObject).vhO, Boolean.TRUE)))
    {
      parama = this.vlq;
      if (parama == null) {
        k.fvU();
      }
      parama = a(parama, this.vlr);
      localObject = com.tencent.mm.plugin.recordvideo.d.e.vpB;
      com.tencent.mm.plugin.recordvideo.d.e.oB(true);
      localObject = this.vlq;
      if (localObject == null) {
        k.fvU();
      }
      a(parama, (com.tencent.mm.plugin.recordvideo.b.f)localObject, this.vlr);
      AppMethodBeat.o(163438);
      return null;
    }
    parama.invoke();
    AppMethodBeat.o(163438);
    return this;
  }
  
  private final ab x(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(163439);
    Object localObject1 = com.tencent.mm.plugin.recordvideo.d.e.vpB;
    com.tencent.mm.plugin.recordvideo.d.e.oB(false);
    localObject1 = this.vlq;
    if (localObject1 == null) {
      k.fvU();
    }
    localObject1 = a((com.tencent.mm.plugin.recordvideo.b.f)localObject1, this.vlr);
    RecordConfigProvider localRecordConfigProvider = this.vcC;
    if (localRecordConfigProvider != null)
    {
      final v.e locale = new v.e();
      locale.Jhw = new aer();
      parama = (aer)locale.Jhw;
      Object localObject2 = this.vlq;
      if (localObject2 == null) {
        k.fvU();
      }
      int i = ((com.tencent.mm.plugin.recordvideo.b.f)localObject2).vgL;
      localObject2 = this.vlq;
      if (localObject2 == null) {
        k.fvU();
      }
      parama.duration = (i - ((com.tencent.mm.plugin.recordvideo.b.f)localObject2).vgK);
      ((aer)locale.Jhw).DeT = new LinkedList((Collection)d.a.e.N(this.qQH));
      localObject2 = (aer)locale.Jhw;
      parama = localRecordConfigProvider.vhH;
      if (parama != null)
      {
        parama = Integer.valueOf(parama.hcj);
        if (parama == null) {
          k.fvU();
        }
        ((aer)localObject2).hcj = parama.intValue();
        parama = (aer)locale.Jhw;
        localObject2 = this.vlp;
        if (localObject2 == null) {
          break label407;
        }
      }
      label407:
      for (boolean bool = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).gBl;; bool = false)
      {
        parama.DeU = bool;
        ((aer)locale.Jhw).yXQ = this.vlr.vgP;
        ((aer)locale.Jhw).vhR = localRecordConfigProvider.vhR;
        ((aer)locale.Jhw).vhS = localRecordConfigProvider.vhS;
        ((aer)locale.Jhw).vhT = localRecordConfigProvider.vhT;
        ((aer)locale.Jhw).vhU = localRecordConfigProvider.vhU;
        ((aer)locale.Jhw).DeV = localRecordConfigProvider.thumbPath;
        ((aer)locale.Jhw).vfa = ((VideoMixer)localObject1).gtM;
        ((aer)locale.Jhw).DeW = 0;
        parama = this.vlq;
        if (parama == null) {
          k.fvU();
        }
        a(parama.vgH, (d.g.a.a)new d(localRecordConfigProvider, locale, this, (VideoMixer)localObject1));
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
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(75665);
    k.h(paramb, "info");
    k.h(paramRecordConfigProvider, "configProvider");
    this.vlp = paramb;
    this.vcC = paramRecordConfigProvider;
    paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    com.tencent.mm.plugin.recordvideo.d.b.v("KEY_IS_CAPUTRE_BOOLEAN", Boolean.valueOf(paramb.gBl));
    if (paramb.gBl)
    {
      paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_CAPUTRE_VIDEO_PATH_STRING", paramb.aoa());
      paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      if (!paramb.anZ()) {
        break label98;
      }
    }
    label98:
    for (paramb = paramb.gBk;; paramb = paramb.gBo)
    {
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_CAPUTRE_THUMB_PATH_STRING", paramb);
      AppMethodBeat.o(75665);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.b.f paramf)
  {
    AppMethodBeat.i(75666);
    k.h(paramf, "editConfig");
    ad.i("MicroMsg.RemuxPlugin", "startReMux !!!!");
    Object localObject = t((d.g.a.a)new h(this));
    if (localObject != null)
    {
      ((ab)localObject).vlq = paramf;
      ((ab)localObject).vlr = paramf.a(((ab)localObject).vcC, ((ab)localObject).vlp);
      ad.i("MicroMsg.RemuxPlugin", "configProvider : " + ((ab)localObject).vcC);
      ad.i("MicroMsg.RemuxPlugin", "RemuxMediaEditConfig : ".concat(String.valueOf(paramf)));
      ad.i("MicroMsg.RemuxPlugin", "mediaCaptureInfo : " + ((ab)localObject).vlp);
      ad.i("MicroMsg.RemuxPlugin", "generateTargetConfig info: " + ((ab)localObject).vlr + ' ');
      paramf = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_VIDEO_IS_EDITED_BOOLEAN", Boolean.valueOf(((ab)localObject).vlr.vgP));
      paramf = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.alo();
      if (((ab)localObject).vlr.vgP)
      {
        paramf = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.aln();
      }
      if (localObject != null)
      {
        paramf = ((ab)localObject).u((d.g.a.a)i.vlL);
        if (paramf != null)
        {
          localObject = com.tencent.mm.plugin.recordvideo.e.b.vtE;
          com.tencent.mm.plugin.recordvideo.e.b.b(paramf.vlp);
          if (paramf != null)
          {
            paramf = paramf.v((d.g.a.a)j.vlM);
            if (paramf != null)
            {
              paramf = paramf.w((d.g.a.a)k.vlN);
              if (paramf != null)
              {
                paramf.x((d.g.a.a)l.vlO);
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
  
  public final void apt() {}
  
  public final boolean dia()
  {
    return false;
  }
  
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final b vlu;
    
    static
    {
      AppMethodBeat.i(75647);
      vlu = new b();
      AppMethodBeat.o(75647);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "success", "", "<anonymous parameter 1>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements m<Boolean, String, y>
  {
    c(ab paramab, AudioCacheInfo paramAudioCacheInfo, d.g.a.a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin$checkBackgroundRemux$1$1"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(RecordConfigProvider paramRecordConfigProvider, v.e parame, ab paramab, VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final e vlC;
    
    static
    {
      AppMethodBeat.i(75651);
      vlC = new e();
      AppMethodBeat.o(75651);
    }
    
    e()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(ab paramab, f.b paramb, VideoMixer paramVideoMixer, com.tencent.mm.plugin.recordvideo.b.f paramf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(ab paramab, VideoMixer paramVideoMixer, f.b paramb, com.tencent.mm.plugin.recordvideo.b.f paramf, aer paramaer, long paramLong, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(75655);
      Object localObject1 = ab.g(this.vlv);
      Object localObject3;
      boolean bool;
      label101:
      VideoMixer localVideoMixer;
      Object localObject6;
      f.b localb;
      if (localObject1 != null)
      {
        localObject3 = CaptureDataManager.vhw;
        k.g(localObject3, "CaptureDataManager.INSTANCE");
        ((CaptureDataManager)localObject3).getExtData().putBoolean("key_is_capture_video", ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).gBl);
        localObject3 = CaptureDataManager.vhw;
        k.g(localObject3, "CaptureDataManager.INSTANCE");
        localObject3 = ((CaptureDataManager)localObject3).getExtData();
        localObject1 = (Collection)((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).gBs;
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
        localVideoMixer = this.vlE;
        localObject6 = this.vlE.vel;
        localb = this.vlD;
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
        localObject3 = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).vgo;
        if (((com.tencent.mm.plugin.recordvideo.b.c)localObject6).vgp < 0L) {
          break label675;
        }
        l = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).vgp;
        k = localVideoMixer.gta;
        if (com.tencent.mm.vfs.i.eK((String)localObject3)) {
          break label1707;
        }
        ad.i("MicroMsg.Media.VideoMixer", "create thumb bitmap : ".concat(String.valueOf(l)));
        if ((((com.tencent.mm.plugin.recordvideo.b.c)localObject6).gBl) || (bt.isNullOrNil(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).vgn))) {
          break label768;
        }
        localObject1 = com.tencent.mm.plugin.mmsight.d.aV(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).vgn, l * 1000L);
        localObject4 = (CharSequence)localVideoMixer.vdw;
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
            localObject5 = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).vgu.get(0);
            k.g(localObject5, "captureInfo.fakeVideoImageList[0]");
            i = VideoMixer.alG((String)localObject5);
            if (i == 0) {
              break;
            }
            localObject5 = new Matrix();
            ((Matrix)localObject5).postRotate(i);
            localObject4 = Bitmap.createBitmap((Bitmap)localObject4, 0, 0, ((Bitmap)localObject4).getWidth(), ((Bitmap)localObject4).getHeight(), (Matrix)localObject5, true);
            localObject5 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject5, true);
            k.g(localObject5, "Bitmap.createBitmap(bmBg…mBg.height, matrix, true)");
            localPoint = com.tencent.mm.plugin.recordvideo.b.e.vgG.dhq();
            if (localObject4 == null) {
              k.fvU();
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
              com.tencent.mm.plugin.recordvideo.d.e locale = com.tencent.mm.plugin.recordvideo.d.e.vpB;
              com.tencent.mm.plugin.recordvideo.d.e.diE();
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
            ad.i("MicroMsg.Media.VideoMixer", "rsblur exception, path:%s", new Object[] { ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).vgu.get(0) });
            localObject2 = com.tencent.mm.plugin.recordvideo.b.e.vgG.dhq();
            localObject2 = com.tencent.mm.sdk.platformtools.f.aG(Color.parseColor("#ff000000"), ((Point)localObject2).x, ((Point)localObject2).y);
            k.g(localObject2, "BitmapUtil.createColorBi…0000\"), point.x, point.y)");
            continue;
            localObject2 = com.tencent.mm.sdk.platformtools.f.aG(Color.parseColor("#ff000000"), localPoint.x, localPoint.y);
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
          localObject4 = com.tencent.mm.sdk.platformtools.f.decodeFile((String)localObject3, (BitmapFactory.Options)localObject2);
        }
        localObject2 = VideoMixer.gI(localb.gnh, localb.gni);
        localObject5 = com.tencent.mm.plugin.recordvideo.e.c.vtL;
        localObject5 = com.tencent.mm.plugin.recordvideo.e.c.alZ(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).vgn);
        if (((com.tencent.mm.plugin.recordvideo.b.c)localObject6).gBl) {
          break label2113;
        }
      }
      if ((i != 0) || (!com.tencent.mm.vfs.i.eK(localVideoMixer.vdw)))
      {
        if (localb.gta == 270) {
          break label2265;
        }
        if (localb.gta == 90)
        {
          break label2265;
          if (j == 0) {
            break label693;
          }
          i = localb.gni;
          if (j == 0) {
            break label703;
          }
          j = localb.gnh;
          f1 = i / j;
          k.g(localObject1, "originThumb");
          f2 = ((Bitmap)localObject1).getWidth() / ((Bitmap)localObject1).getHeight();
          if (f1 <= f2) {
            break label2277;
          }
          j = (int)(i / f2);
          ad.i("MicroMsg.Media.VideoMixer", "thumbHeight:" + j + " thumbWidth:" + i);
          localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, j, true);
          localObject4 = new StringBuilder("createGraffitiThumb not capture, thumb size:[");
          k.g(localObject1, "thumb");
          ad.i("MicroMsg.Media.VideoMixer", ((Bitmap)localObject1).getWidth() + ", " + ((Bitmap)localObject1).getHeight() + "], thumbRotate:" + k + ", drawingRect:" + Arrays.toString(localVideoMixer.vem));
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
        localObject3 = com.tencent.mm.plugin.recordvideo.e.b.vtE;
        ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).alJ(com.tencent.mm.plugin.recordvideo.e.b.rU(ce.asR()));
        localObject3 = ((com.tencent.mm.plugin.recordvideo.b.c)localObject6).vgo;
        localObject4 = localObject1;
        label545:
        if (localObject4 != null) {
          break label1742;
        }
        ad.e("MicroMsg.Media.VideoMixer", "createGraffitiThumb thumb is null");
        localObject1 = com.tencent.mm.plugin.recordvideo.d.e.vpB;
        com.tencent.mm.plugin.recordvideo.d.e.diE();
        localObject1 = com.tencent.mm.plugin.recordvideo.background.f.vdH;
        localObject1 = com.tencent.mm.plugin.recordvideo.background.f.a(this.vlE, (List)this.vlI.vgJ, this.vdY, this.vlJ, this.vlI.vdw, this.gZZ);
        localObject3 = com.tencent.mm.plugin.recordvideo.background.g.vdS;
        com.tencent.mm.plugin.recordvideo.background.g.dgP();
        if (this.gZZ == 3)
        {
          localObject3 = com.tencent.mm.plugin.recordvideo.d.d.vpA;
          com.tencent.mm.plugin.recordvideo.d.d.ow(this.vdY.DeU);
        }
        com.tencent.mm.ad.c.g((d.g.a.a)new d.g.b.l((String)localObject1) {});
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
        i = localb.gnh;
        break label314;
        label703:
        j = localb.gni;
        break label326;
        i = Math.min(localb.gnh, localb.gni);
        k.g(localObject1, "originThumb");
        f1 = ((Bitmap)localObject1).getWidth() / i;
        localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, (int)(((Bitmap)localObject1).getHeight() / f1), true);
        break label413;
        label768:
        if (((com.tencent.mm.plugin.recordvideo.b.c)localObject6).vgu.size() != 0) {
          break label794;
        }
        localObject1 = com.tencent.mm.plugin.mmsight.d.aV(((com.tencent.mm.plugin.recordvideo.b.c)localObject6).vgn, l);
      }
      label794:
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      BitmapFactory.decodeFile((String)((com.tencent.mm.plugin.recordvideo.b.c)localObject6).vgu.get(0), (BitmapFactory.Options)localObject1);
      int i = ((BitmapFactory.Options)localObject1).outWidth;
      int j = ((BitmapFactory.Options)localObject1).outHeight;
      m = com.tencent.mm.plugin.recordvideo.b.e.vgG.getMaxSize();
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
        ((BitmapFactory.Options)localObject1).inSampleSize = com.tencent.mm.sdk.platformtools.f.M(i, j, com.tencent.mm.plugin.recordvideo.b.e.vgG.getMaxSize(), com.tencent.mm.plugin.recordvideo.b.e.vgG.getMaxSize());
        ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
        ((BitmapFactory.Options)localObject1).inMutable = true;
        localObject4 = MMBitmapFactory.decodeFile((String)((com.tencent.mm.plugin.recordvideo.b.c)localObject6).vgu.get(0), (BitmapFactory.Options)localObject1);
        ((BitmapFactory.Options)localObject1).inSampleSize = com.tencent.mm.sdk.platformtools.f.M(i, j, com.tencent.mm.plugin.recordvideo.b.e.vgG.getMaxSize() / 2, com.tencent.mm.plugin.recordvideo.b.e.vgG.getMaxSize() / 2);
        localObject5 = new com.tencent.mm.ui.blur.e(aj.getContext());
        localObject1 = MMBitmapFactory.decodeFile((String)((com.tencent.mm.plugin.recordvideo.b.c)localObject6).vgu.get(0), (BitmapFactory.Options)localObject1);
      }
      label1150:
      Object localObject2;
      label1707:
      label1742:
      if ((localObject5 != null) && (!((c.a)localObject5).vtM))
      {
        localVideoMixer.vee = new com.tencent.mm.plugin.recordvideo.background.c(localVideoMixer.vem, localVideoMixer.grO, ((Point)localObject2).x, ((Point)localObject2).y, ((c.a)localObject5).width, ((c.a)localObject5).height, k, false, localVideoMixer.vdw, 128);
        localObject2 = localVideoMixer.vee;
        if (localObject2 == null) {
          k.aPZ("frameRetriever");
        }
        ((com.tencent.mm.plugin.recordvideo.background.c)localObject2).start();
        localObject6 = (Bitmap)localVideoMixer.gsq.aA(Long.valueOf(1L));
        localObject2 = (Bitmap)localVideoMixer.gto.aA(Long.valueOf(1L));
        localObject5 = localVideoMixer.vee;
        if (localObject5 == null) {
          k.aPZ("frameRetriever");
        }
        ((com.tencent.mm.plugin.recordvideo.background.c)localObject5).destroy();
        if (localObject2 == null) {
          break label2238;
        }
        localObject5 = VideoMixer.a((Bitmap)localObject4, (Bitmap)localObject2, 0.0F, (localb.gni - ((Bitmap)localObject4).getHeight()) / 2.0F, 4);
        localObject2 = localObject5;
        if (localObject6 != null)
        {
          if (localb.gta == 270) {
            break label2294;
          }
          if (localb.gta != 90) {
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
          i = localb.gni;
          label2005:
          if (j == 0) {
            break label2171;
          }
          j = localb.gnh;
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
          ad.i("MicroMsg.Media.VideoMixer", bool);
          break;
          label2113:
          localVideoMixer.vee = new com.tencent.mm.plugin.recordvideo.background.c(localVideoMixer.vem, localVideoMixer.grO, ((Point)localObject2).x, ((Point)localObject2).y, 0, 0, k, false, localVideoMixer.vdw, 128);
          break label1846;
          i = localb.gnh;
          break label2005;
          label2171:
          j = localb.gni;
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(ab paramab)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final i vlL;
    
    static
    {
      AppMethodBeat.i(75658);
      vlL = new i();
      AppMethodBeat.o(75658);
    }
    
    i()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final j vlM;
    
    static
    {
      AppMethodBeat.i(75660);
      vlM = new j();
      AppMethodBeat.o(75660);
    }
    
    j()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final k vlN;
    
    static
    {
      AppMethodBeat.i(75662);
      vlN = new k();
      AppMethodBeat.o(75662);
    }
    
    k()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final l vlO;
    
    static
    {
      AppMethodBeat.i(75664);
      vlO = new l();
      AppMethodBeat.o(75664);
    }
    
    l()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.ab
 * JD-Core Version:    0.7.0.1
 */