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
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer;
import com.tencent.mm.plugin.recordvideo.c.g.b;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.util.g.a;
import com.tencent.mm.plugin.recordvideo.util.j.a;
import com.tencent.mm.plugin.sight.base.ABAPrams;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.ScopedStorageUtil.MediaStoreOps;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d<-Lcom.tencent.mm.plugin.recordvideo.plugin.ae;>;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cx;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "abaParams", "Lcom/tencent/mm/plugin/sight/base/ABAPrams;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getContext", "()Landroid/content/Context;", "setContext", "editConfig", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig;", "enable", "", "encode", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "getEncode", "()Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "setEncode", "(Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;)V", "foregroundRemuxFinishCallback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "ret", "", "getForegroundRemuxFinishCallback", "()Lkotlin/jvm/functions/Function3;", "setForegroundRemuxFinishCallback", "(Lkotlin/jvm/functions/Function3;)V", "loading", "Lcom/tencent/mm/plugin/recordvideo/ui/MediaProgressDialog;", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "remuxJob", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "x264RetryTime", "", "checkAudioCache", "audio", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "callback", "Lkotlin/Function0;", "checkBackgroundRemux", "error", "checkDaemonVideo", "checkForegroundRemux", "checkNoNeedRemuxVideo", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkNullProvider", "checkSaveThumb", "videoPath", "thumbPath", "checkThirdPartyVideo", "createMixer", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer;", "encodeConfig", "dismissDialog", "doFinish", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "forceRemux", "getMixer", "getTransformInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "handleNoNeedRemuxVideoFile", "release", "runForeGround", "mixer", "runMixInBackground", "editorConfig", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "expiredTime", "", "scene", "setCaptureInfo", "info", "setMoovHead", "path", "snsCheck", "videoInfo", "Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "fileLength", "startReMux", "updateABABrWithQP", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
  implements v
{
  public static final ae.a NLq;
  private ABAPrams Gbz;
  private com.tencent.mm.plugin.recordvideo.ui.a NLr;
  private com.tencent.mm.media.widget.camerarecordview.b.b NLs;
  private com.tencent.mm.plugin.recordvideo.c.g NLt;
  g.b NLu;
  public q<? super String, ? super String, ? super Boolean, ah> NLv;
  private cb NLw;
  private int NLx;
  Context context;
  private boolean enable;
  private RecordConfigProvider oaV;
  private final aq scope;
  
  static
  {
    AppMethodBeat.i(75676);
    NLq = new ae.a((byte)0);
    AppMethodBeat.o(75676);
  }
  
  public ae(Context paramContext)
  {
    AppMethodBeat.i(75675);
    this.context = paramContext;
    this.enable = true;
    this.NLu = new g.b((byte)0);
    this.scope = ar.b(ar.kBZ(), (kotlin.d.f)cx.g(null));
    AppMethodBeat.o(75675);
  }
  
  private final VideoMixer a(com.tencent.mm.plugin.recordvideo.c.g paramg, g.b paramb)
  {
    AppMethodBeat.i(75668);
    long l = System.currentTimeMillis();
    Object localObject1 = this.oaV;
    Object localObject2;
    label62:
    int j;
    label100:
    boolean bool1;
    boolean bool2;
    com.tencent.mm.plugin.recordvideo.c.c localc;
    label249:
    int i;
    label272:
    label306:
    boolean bool3;
    label327:
    label466:
    String str;
    float f;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.util.f.Obq;
        localObject2 = com.tencent.mm.plugin.recordvideo.util.f.aTy(String.valueOf(l));
      }
      localObject1 = this.oaV;
      if (localObject1 != null) {
        break label700;
      }
      localObject1 = null;
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.util.f.Obq;
        localObject3 = com.tencent.mm.plugin.recordvideo.util.f.aTz(String.valueOf(l));
      }
      localObject1 = this.oaV;
      if (localObject1 != null) {
        break label710;
      }
      j = 0;
      bool1 = false;
      switch (j)
      {
      default: 
        bool2 = bool1;
        if (MultiProcessMMKV.getSingleDefault().getBoolean("mediacodec_create_error", false)) {
          bool2 = true;
        }
        Log.i("MicroMsg.RemuxPlugin", s.X("final useX264Encode: ", Boolean.valueOf(bool2)));
        localObject1 = com.tencent.mm.plugin.recordvideo.f.g.NRB;
        com.tencent.mm.plugin.recordvideo.f.g.Bo(bool2);
        localObject1 = com.tencent.mm.plugin.recordvideo.f.g.NRB;
        com.tencent.mm.plugin.recordvideo.f.g.Bp(com.tencent.mm.plugin.sight.base.c.gYn());
        bool1 = false;
        switch (j)
        {
        default: 
          localc = new com.tencent.mm.plugin.recordvideo.c.c();
          localObject1 = this.NLs;
          if (localObject1 == null)
          {
            localObject1 = "";
            localc.aSY((String)localObject1);
            localObject1 = this.NLs;
            if (localObject1 != null) {
              break label1110;
            }
            localObject1 = "";
            localc.aSZ((String)localObject1);
            localc.EEx = paramg.Gss;
            if (!paramg.NGG) {
              break label1140;
            }
            if (localc.EEx != null) {
              break label1134;
            }
            i = 0;
            localc.NGC = i;
            localObject1 = this.NLs;
            if (localObject1 != null) {
              break label1160;
            }
            bool3 = true;
            localc.nJW = bool3;
            localc.nCg = SightVideoJNI.getMp4RotateVFS(localc.NGx);
            localc.NGz = paramg.NGW;
            localc.NGA = paramg.NGX;
            localObject1 = paramg.NGY;
            s.u(localObject1, "<set-?>");
            localc.NGD = ((ArrayList)localObject1);
            Log.i("MicroMsg.RemuxPlugin", s.X("getTransformInfo :", localc));
            if ((j == 3) && (!com.tencent.mm.vfs.y.ZC(localc.NGx)))
            {
              localObject1 = com.tencent.mm.plugin.recordvideo.f.e.NRz;
              com.tencent.mm.plugin.recordvideo.f.e.Bj(localc.nJW);
            }
            List localList = (List)paramg.NGU;
            float[] arrayOfFloat1 = paramg.NEA;
            float[] arrayOfFloat2 = paramg.NEB;
            localObject1 = this.oaV;
            if (localObject1 != null) {
              break label1170;
            }
            i = 0;
            str = paramg.NEF;
            localObject1 = str;
            if (str == null) {
              localObject1 = "";
            }
            localObject1 = new VideoMixer(new com.tencent.mm.plugin.recordvideo.background.a.a(localc, localList, arrayOfFloat1, arrayOfFloat2, (String)localObject2, (String)localObject3, 0, bool2, bool1, i, (String)localObject1, 64));
            f = 1.0F;
            localObject2 = this.oaV;
            if ((localObject2 == null) || (((RecordConfigProvider)localObject2).scene != 2)) {
              break label1198;
            }
            i = 1;
            label550:
            if (i == 0) {
              break label1204;
            }
            f = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVr, 1.0F);
            label574:
            Log.i("MicroMsg.RemuxPlugin", "final kbps: " + f + "  " + paramb.videoBitrate * f);
            VideoMixer.a((VideoMixer)localObject1, paramb.nxO, paramb.nxP, (int)(f * paramb.videoBitrate), paramb.audioBitrate, paramb.audioSampleRate, paramb.audioChannelCount, paramb.frameRate, paramb.nCg);
            paramb = this.oaV;
            if (paramb != null) {
              break label1260;
            }
          }
          break;
        }
        break;
      }
    }
    label700:
    label710:
    label745:
    label1258:
    label1260:
    for (paramb = null;; paramb = paramb.oXZ)
    {
      s.checkNotNull(paramb);
      ((VideoMixer)localObject1).a(paramb, paramg.NGX, paramg.NGW);
      AppMethodBeat.o(75668);
      return localObject1;
      localObject1 = ((RecordConfigProvider)localObject1).NIe;
      break;
      localObject1 = ((RecordConfigProvider)localObject1).thumbPath;
      break label62;
      j = ((RecordConfigProvider)localObject1).scene;
      break label100;
      if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVl, 0) == 1)
      {
        bool2 = true;
        i = af.lYf.lWX;
        if (i == -1) {
          break label817;
        }
        if (i != 1) {
          break label811;
        }
        bool1 = true;
      }
      for (;;)
      {
        Log.i("MicroMsg.RemuxPlugin", "sns config use x264 encode: " + bool2 + ", deviceUseX264Encode:" + i);
        break;
        bool2 = false;
        break label745;
        bool1 = false;
        continue;
        bool1 = bool2;
      }
      if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVm, 0) == 1)
      {
        bool2 = true;
        i = af.lYf.lWW;
        if (i == -1) {
          break label921;
        }
        if (i != 1) {
          break label915;
        }
        bool1 = true;
      }
      for (;;)
      {
        Log.i("MicroMsg.RemuxPlugin", "c2c config use x264 encode: " + bool2 + ", deviceUseX264Encode:" + i);
        break;
        bool2 = false;
        break label849;
        bool1 = false;
        continue;
        bool1 = bool2;
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.c.e.NGK;
      bool3 = com.tencent.mm.plugin.recordvideo.c.e.AU(true);
      localObject1 = com.tencent.mm.plugin.recordvideo.c.e.NGK;
      boolean bool4 = com.tencent.mm.plugin.recordvideo.c.e.AU(false);
      if (((bool2) && (bool3)) || (bool3) || (bool4))
      {
        bool1 = true;
        if ((!bool2) && (!bool3)) {
          break label1074;
        }
        bool2 = true;
        Log.i("MicroMsg.RemuxPlugin", "checkEnableHevc, hwEnableHevc:" + bool4 + ", swEnableHevc:" + bool3 + ", enableHevc:" + bool1 + ", useSoftEncode:" + bool2);
        if (bool1)
        {
          localObject1 = com.tencent.mm.plugin.recordvideo.f.g.NRB;
          if (!bool2) {
            break label1080;
          }
        }
      }
      for (i = 1;; i = 2)
      {
        com.tencent.mm.plugin.recordvideo.f.g.agR(i);
        break;
        bool1 = false;
        break label973;
        bool2 = false;
        break label986;
      }
      str = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nJU;
      localObject1 = str;
      if (str != null) {
        break label249;
      }
      localObject1 = "";
      break label249;
      str = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nJV;
      localObject1 = str;
      if (str != null) {
        break label272;
      }
      localObject1 = "";
      break label272;
      label1134:
      i = 2;
      break label306;
      label1140:
      if (localc.EEx == null)
      {
        i = 1;
        break label306;
      }
      i = 3;
      break label306;
      bool3 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nJW;
      break label327;
      localObject1 = ((RecordConfigProvider)localObject1).oXZ;
      if (localObject1 == null)
      {
        i = 0;
        break label466;
      }
      i = ((VideoTransPara)localObject1).oCa;
      break label466;
      i = 0;
      break label550;
      localObject2 = this.oaV;
      if ((localObject2 != null) && (((RecordConfigProvider)localObject2).scene == 1)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1258;
        }
        f = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVq, 1.0F);
        break;
      }
      break label574;
    }
  }
  
  private final void a(final VideoMixer paramVideoMixer, final com.tencent.mm.plugin.recordvideo.c.g paramg, final g.b paramb)
  {
    AppMethodBeat.i(75669);
    if (this.NLr == null)
    {
      localObject = new com.tencent.mm.plugin.recordvideo.ui.a();
      ((com.tencent.mm.plugin.recordvideo.ui.a)localObject).a(this.context, b.h.remux_loading_tips, (kotlin.g.a.a)ae.h.NLG);
      ah localah = ah.aiuX;
      this.NLr = ((com.tencent.mm.plugin.recordvideo.ui.a)localObject);
    }
    Object localObject = com.tencent.mm.plugin.recordvideo.background.f.NDY;
    com.tencent.mm.plugin.recordvideo.background.f.bK((kotlin.g.a.a)new i(this, paramb, paramVideoMixer, paramg));
    AppMethodBeat.o(75669);
  }
  
  private final void a(g.b paramb)
  {
    AppMethodBeat.i(75674);
    Object localObject = com.tencent.mm.media.util.f.nFE;
    com.tencent.mm.media.util.f.brt();
    long l = Util.currentTicks();
    Log.i("MicroMsg.RemuxPlugin", "start forceRemux");
    localObject = this.oaV;
    String str;
    int i;
    int j;
    label178:
    label192:
    int k;
    if (localObject == null)
    {
      localObject = null;
      str = s.X((String)localObject, "_tmp");
      localObject = this.oaV;
      s.checkNotNull(localObject);
      if (((RecordConfigProvider)localObject).oXZ.oCc != 2) {
        break label394;
      }
      localObject = this.oaV;
      s.checkNotNull(localObject);
      i = ((RecordConfigProvider)localObject).oXZ.nxU;
      localObject = this.oaV;
      s.checkNotNull(localObject);
      Log.i("MicroMsg.RemuxPlugin", "ABA: Using Min Max QP Limitation: [%d], [%d] ", new Object[] { Integer.valueOf(i), Integer.valueOf(((RecordConfigProvider)localObject).oXZ.nxV) });
      localObject = this.oaV;
      s.checkNotNull(localObject);
      i = ((RecordConfigProvider)localObject).oXZ.nxU;
      localObject = this.oaV;
      s.checkNotNull(localObject);
      j = ((RecordConfigProvider)localObject).oXZ.nxV;
      localObject = this.oaV;
      if (localObject != null) {
        break label402;
      }
      localObject = null;
      k = paramb.nxO;
      int m = paramb.nxP;
      int n = paramb.videoBitrate;
      RecordConfigProvider localRecordConfigProvider = this.oaV;
      s.checkNotNull(localRecordConfigProvider);
      int i1 = localRecordConfigProvider.oXZ.oBP;
      localRecordConfigProvider = this.oaV;
      s.checkNotNull(localRecordConfigProvider);
      k = SightVideoJNI.remuxingVFS((String)localObject, str, k, m, n, i1, 8, localRecordConfigProvider.oXZ.oBO, 25.0F, paramb.frameRate, null, 0, false, i, j);
      paramb = this.oaV;
      if (paramb != null) {
        break label412;
      }
    }
    label394:
    label402:
    label412:
    for (paramb = null;; paramb = paramb.NIe)
    {
      com.tencent.mm.vfs.y.O(str, paramb, false);
      com.tencent.mm.vfs.y.deleteFile(str);
      l = Util.ticksToNow(l);
      Log.i("MicroMsg.RemuxPlugin", "minQP :" + i + "  maxQP :" + j + "  duration:" + k + " cost:" + l);
      paramb = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.ib(l);
      AppMethodBeat.o(75674);
      return;
      localObject = ((RecordConfigProvider)localObject).NIe;
      break;
      i = 0;
      j = 51;
      break label178;
      localObject = ((RecordConfigProvider)localObject).NIe;
      break label192;
    }
  }
  
  private static final void a(ae paramae, final VideoMixer paramVideoMixer, final g.b paramb, com.tencent.mm.plugin.recordvideo.c.g paramg, final apw paramapw, long paramLong, int paramInt)
  {
    AppMethodBeat.i(280933);
    s.u(paramae, "this$0");
    s.u(paramVideoMixer, "$mixer");
    s.u(paramb, "$encodeConfig");
    s.u(paramg, "$editorConfig");
    s.u(paramapw, "$extraConfig");
    Object localObject1 = paramae.NLs;
    Object localObject3;
    boolean bool;
    label114:
    Object localObject6;
    if (localObject1 != null)
    {
      CaptureDataManager.NHH.rnY.putBoolean("key_is_capture_video", ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nJW);
      localObject3 = CaptureDataManager.NHH.rnY;
      localObject4 = (Collection)((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nKc;
      if ((localObject4 == null) || (((Collection)localObject4).isEmpty()))
      {
        i = 1;
        if (i != 0) {
          break label700;
        }
        bool = true;
        ((Bundle)localObject3).putBoolean("key_is_photo_video", bool);
        localObject3 = (Collection)((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nKc;
        if ((localObject3 != null) && (!((Collection)localObject3).isEmpty())) {
          break label706;
        }
        i = 1;
        label152:
        if (i != 0) {
          break label712;
        }
        CaptureDataManager.NHH.rnY.putStringArrayList("key_src_list", ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nKc);
      }
    }
    else
    {
      label174:
      localObject6 = paramVideoMixer.NEk.NEp;
      s.u(localObject6, "captureInfo");
      s.u(paramb, "config");
    }
    label222:
    int k;
    label318:
    label358:
    label369:
    label380:
    float f2;
    label421:
    label468:
    label596:
    label749:
    label755:
    label767:
    Object localObject5;
    label564:
    label700:
    label706:
    label712:
    label859:
    Object localObject2;
    try
    {
      localObject3 = ((com.tencent.mm.plugin.recordvideo.c.c)localObject6).NGy;
      if (((com.tencent.mm.plugin.recordvideo.c.c)localObject6).NGz < 0L) {
        break label749;
      }
      l = ((com.tencent.mm.plugin.recordvideo.c.c)localObject6).NGz;
      k = paramVideoMixer.nCg;
      if (com.tencent.mm.vfs.y.ZC((String)localObject3)) {
        break label1797;
      }
      Log.i("MicroMsg.Media.VideoMixer", s.X("create thumb bitmap : ", Long.valueOf(l)));
      if ((((com.tencent.mm.plugin.recordvideo.c.c)localObject6).nJW) || (Util.isNullOrNil(((com.tencent.mm.plugin.recordvideo.c.c)localObject6).NGx))) {
        break label833;
      }
      localObject1 = com.tencent.mm.plugin.mmsight.d.bl(((com.tencent.mm.plugin.recordvideo.c.c)localObject6).NGx, l * 1000L);
      localObject4 = (CharSequence)paramVideoMixer.NEk.NEF;
      if (localObject4 == null) {
        break label2398;
      }
      if (((CharSequence)localObject4).length() != 0) {
        break label755;
      }
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        try
        {
          long l;
          int m;
          localObject1 = ((com.tencent.mm.ui.blur.e)localObject5).c((Bitmap)localObject1, 4.0F);
          s.s(localObject1, "renderScriptBlur.blur(tmpBg, 4f)");
          ((com.tencent.mm.ui.blur.e)localObject5).destroy();
          if (localObject4 == null) {
            break;
          }
          localObject5 = ((com.tencent.mm.plugin.recordvideo.c.c)localObject6).NGD.get(0);
          s.s(localObject5, "captureInfo.fakeVideoImageList[0]");
          i = VideoMixer.aSW((String)localObject5);
          if (i == 0) {
            break;
          }
          localObject5 = new Matrix();
          ((Matrix)localObject5).postRotate(i);
          localObject4 = Bitmap.createBitmap((Bitmap)localObject4, 0, 0, ((Bitmap)localObject4).getWidth(), ((Bitmap)localObject4).getHeight(), (Matrix)localObject5, true);
          localObject5 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject5, true);
          s.s(localObject5, "createBitmap(bmBg, 0, 0,…mBg.height, matrix, true)");
          localObject7 = com.tencent.mm.plugin.recordvideo.c.f.NGM.gHt();
          s.checkNotNull(localObject4);
          if (((Bitmap)localObject4).getConfig() != null)
          {
            localObject1 = Bitmap.createBitmap(((Point)localObject7).x, ((Point)localObject7).y, ((Bitmap)localObject4).getConfig());
            localCanvas = new Canvas((Bitmap)localObject1);
            i = ((Bitmap)localObject5).getWidth();
            j = ((Bitmap)localObject5).getHeight();
            if ((i == ((Point)localObject7).x) && (j == ((Point)localObject7).y)) {
              continue;
            }
            f3 = 0.0F;
            f2 = 0.0F;
            if (((Point)localObject7).y * i <= ((Point)localObject7).x * j) {
              continue;
            }
            f1 = ((Point)localObject7).y / j;
            f3 = (((Point)localObject7).x - i * f1) * 0.5F;
            Matrix localMatrix = new Matrix();
            localMatrix.setScale(f1, f1);
            localMatrix.postTranslate(f3, f2);
            localCanvas.drawBitmap((Bitmap)localObject5, localMatrix, null);
            i = ((Bitmap)localObject4).getWidth();
            j = ((Bitmap)localObject4).getHeight();
            if ((i == ((Point)localObject7).x) && (j == ((Point)localObject7).y)) {
              continue;
            }
            f3 = 0.0F;
            f2 = 0.0F;
            if (((Point)localObject7).y * i <= ((Point)localObject7).x * j) {
              continue;
            }
            f1 = ((Point)localObject7).x / i;
            f2 = (((Point)localObject7).y - j * f1) * 0.5F;
            localObject5 = new Matrix();
            ((Matrix)localObject5).setScale(f1, f1);
            ((Matrix)localObject5).postTranslate(f3, f2);
            localCanvas.drawBitmap((Bitmap)localObject4, (Matrix)localObject5, null);
            continue;
            paramb = paramb;
            Log.printErrStackTrace("MicroMsg.Media.VideoMixer", (Throwable)paramb, "createGraffitiThumb error", new Object[0]);
            paramb = com.tencent.mm.plugin.recordvideo.f.f.NRA;
            com.tencent.mm.plugin.recordvideo.f.f.gJm();
            continue;
            if (i <= m) {
              continue;
            }
            ((Point)localObject4).x = m;
            f1 = j;
            ((Point)localObject4).y = ((int)(m * f1 / i));
          }
        }
        catch (Exception localException)
        {
          Canvas localCanvas;
          Log.printErrStackTrace("MicroMsg.Media.VideoMixer", (Throwable)localException, "rsblur exception", new Object[0]);
          Log.i("MicroMsg.Media.VideoMixer", "rsblur exception, path:%s", new Object[] { ((com.tencent.mm.plugin.recordvideo.c.c)localObject6).NGD.get(0) });
          localObject2 = com.tencent.mm.plugin.recordvideo.c.f.NGM.gHt();
          localObject2 = BitmapUtil.createColorBitmap(Color.parseColor("#ff000000"), ((Point)localObject2).x, ((Point)localObject2).y);
          s.s(localObject2, "createColorBitmap(Color.…0000\"), point.x, point.y)");
          continue;
          localObject2 = BitmapUtil.createColorBitmap(Color.parseColor("#ff000000"), ((Point)localObject7).x, ((Point)localObject7).y);
          continue;
          float f1 = ((Point)localObject7).x / i;
          f2 = (((Point)localObject7).y - j * f1) * 0.5F;
          continue;
          localCanvas.drawBitmap((Bitmap)localObject5, 0.0F, 0.0F, null);
          continue;
          f1 = ((Point)localObject7).y / j;
          float f3 = (((Point)localObject7).x - i * f1) * 0.5F;
          continue;
          localCanvas.drawBitmap((Bitmap)localObject4, 0.0F, 0.0F, null);
        }
        continue;
        localObject2 = new BitmapFactory.Options();
        Log.i("MicroMsg.Media.VideoMixer", "exist thumb bitmap ");
        ((BitmapFactory.Options)localObject2).inMutable = true;
        localObject4 = BitmapUtil.decodeFile((String)localObject3, (BitmapFactory.Options)localObject2);
      }
      localObject2 = VideoMixer.kD(paramb.nxO, paramb.nxP);
      localObject5 = com.tencent.mm.plugin.recordvideo.util.g.Obu;
      localObject5 = com.tencent.mm.plugin.recordvideo.util.g.aTF(((com.tencent.mm.plugin.recordvideo.c.c)localObject6).NGx);
      if (((com.tencent.mm.plugin.recordvideo.c.c)localObject6).nJW) {
        break label2237;
      }
    }
    if ((i != 0) || (!com.tencent.mm.vfs.y.ZC(paramVideoMixer.NEk.NEF)))
    {
      if (paramb.nCg == 270) {
        break label2404;
      }
      if (paramb.nCg == 90)
      {
        break label2404;
        if (j == 0) {
          break label767;
        }
        i = paramb.nxP;
        if (j == 0) {
          break label776;
        }
        j = paramb.nxO;
        f1 = i / j;
        f2 = ((Bitmap)localObject1).getWidth() / ((Bitmap)localObject1).getHeight();
        if (f1 <= f2) {
          break label2416;
        }
        j = (int)(i / f2);
        Log.i("MicroMsg.Media.VideoMixer", "thumbHeight:" + j + " thumbWidth:" + i);
        localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, j, true);
        Log.i("MicroMsg.Media.VideoMixer", "createGraffitiThumb not capture, thumb size:[" + ((Bitmap)localObject1).getWidth() + ", " + ((Bitmap)localObject1).getHeight() + "], thumbRotate:" + k + ", drawingRect:" + Arrays.toString(paramVideoMixer.NEk.NEA));
      }
    }
    for (;;)
    {
      localObject4 = (CharSequence)localObject3;
      if (localObject4 == null) {
        break label2410;
      }
      if (((CharSequence)localObject4).length() != 0) {
        break label2428;
      }
      break label2410;
      if (i == 0) {
        break label2384;
      }
      localObject3 = com.tencent.mm.plugin.recordvideo.util.f.Obq;
      ((com.tencent.mm.plugin.recordvideo.c.c)localObject6).aSZ(com.tencent.mm.plugin.recordvideo.util.f.tH(cn.bDv()));
      localObject3 = ((com.tencent.mm.plugin.recordvideo.c.c)localObject6).NGy;
      localObject4 = localObject1;
      if (localObject4 != null) {
        break label1833;
      }
      Log.e("MicroMsg.Media.VideoMixer", "createGraffitiThumb thumb is null");
      paramb = com.tencent.mm.plugin.recordvideo.f.f.NRA;
      com.tencent.mm.plugin.recordvideo.f.f.gJm();
      paramb = com.tencent.mm.plugin.recordvideo.background.e.NDU;
      paramb = com.tencent.mm.plugin.recordvideo.background.e.a(paramVideoMixer, (List)paramg.NGV, paramapw, paramLong, paramg.NEF, paramInt);
      paramg = com.tencent.mm.plugin.recordvideo.background.f.NDY;
      com.tencent.mm.plugin.recordvideo.background.f.gGR();
      if (paramInt == 3)
      {
        paramg = com.tencent.mm.plugin.recordvideo.f.e.NRz;
        com.tencent.mm.plugin.recordvideo.f.e.Bf(paramapw.Zxk);
      }
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new j(paramae, paramVideoMixer, paramb, paramapw));
      AppMethodBeat.o(280933);
      return;
      i = 0;
      break;
      bool = false;
      break label114;
      i = 0;
      break label152;
      localObject3 = new ArrayList();
      ((ArrayList)localObject3).add(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nJU);
      CaptureDataManager.NHH.rnY.putStringArrayList("key_src_list", (ArrayList)localObject3);
      break label174;
      l = 0L;
      break label222;
      i = 0;
      break label318;
      j = 0;
      break label358;
      i = paramb.nxO;
      break label369;
      label776:
      j = paramb.nxP;
      break label380;
      i = Math.min(paramb.nxO, paramb.nxP);
      f1 = ((Bitmap)localObject1).getWidth() / i;
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, (int)(((Bitmap)localObject1).getHeight() / f1), true);
      break label468;
      label833:
      if (((com.tencent.mm.plugin.recordvideo.c.c)localObject6).NGD.size() != 0) {
        break label859;
      }
      localObject1 = com.tencent.mm.plugin.mmsight.d.bl(((com.tencent.mm.plugin.recordvideo.c.c)localObject6).NGx, l);
    }
    localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    BitmapFactory.decodeFile((String)((com.tencent.mm.plugin.recordvideo.c.c)localObject6).NGD.get(0), (BitmapFactory.Options)localObject1);
    int i = ((BitmapFactory.Options)localObject1).outWidth;
    int j = ((BitmapFactory.Options)localObject1).outHeight;
    m = com.tencent.mm.plugin.recordvideo.c.f.NGM.gHs();
    Object localObject4 = new Point(i, j);
    if (i > j)
    {
      if (j > m)
      {
        ((Point)localObject4).y = m;
        f1 = i;
        ((Point)localObject4).x = ((int)(m / j * f1));
      }
      ((BitmapFactory.Options)localObject1).inSampleSize = BitmapUtil.calculateInSampleSize(i, j, com.tencent.mm.plugin.recordvideo.c.f.NGM.gHs(), com.tencent.mm.plugin.recordvideo.c.f.NGM.gHs());
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject1).inMutable = true;
      localObject4 = MMBitmapFactory.decodeFile((String)((com.tencent.mm.plugin.recordvideo.c.c)localObject6).NGD.get(0), (BitmapFactory.Options)localObject1);
      ((BitmapFactory.Options)localObject1).inSampleSize = BitmapUtil.calculateInSampleSize(i, j, com.tencent.mm.plugin.recordvideo.c.f.NGM.gHs() / 2, com.tencent.mm.plugin.recordvideo.c.f.NGM.gHs() / 2);
      localObject5 = new com.tencent.mm.ui.blur.e(MMApplicationContext.getContext());
      localObject1 = MMBitmapFactory.decodeFile((String)((com.tencent.mm.plugin.recordvideo.c.c)localObject6).NGD.get(0), (BitmapFactory.Options)localObject1);
    }
    label1217:
    Object localObject7;
    label1797:
    label1833:
    label2089:
    if ((localObject5 != null) && (!((g.a)localObject5).Obv))
    {
      i = 1;
      label1885:
      if (i != 0)
      {
        localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(paramVideoMixer.NEk.NEA, paramVideoMixer.NEk.NEB, paramVideoMixer.NEk.yhJ, ((Point)localObject2).x, ((Point)localObject2).y, ((g.a)localObject5).width, ((g.a)localObject5).height, k, false, paramVideoMixer.NEk.NEF, 256));
        paramVideoMixer.NEo = ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject2);
        localObject5 = paramVideoMixer.NEo;
        localObject2 = localObject5;
        if (localObject5 == null)
        {
          s.bIx("frameRetriever");
          localObject2 = null;
        }
        ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject2).start();
        localObject6 = (Bitmap)paramVideoMixer.nBp.invoke(Long.valueOf(1L));
        localObject7 = (Bitmap)paramVideoMixer.nCt.invoke(Long.valueOf(1L));
        localObject5 = paramVideoMixer.NEo;
        localObject2 = localObject5;
        if (localObject5 == null)
        {
          s.bIx("frameRetriever");
          localObject2 = null;
        }
        ((com.tencent.mm.plugin.recordvideo.ui.editor.b.g)localObject2).destroy();
        if (localObject7 == null) {
          break label2377;
        }
        localObject5 = VideoMixer.a((Bitmap)localObject4, (Bitmap)localObject7, 0.0F, (paramb.nxP - ((Bitmap)localObject4).getHeight()) / 2.0F, 4);
        localObject2 = localObject5;
        if (localObject6 != null)
        {
          if (paramb.nCg == 270) {
            break label2434;
          }
          if (paramb.nCg != 90) {
            break label2446;
          }
          break label2434;
        }
      }
    }
    for (;;)
    {
      label1960:
      if (j != 0)
      {
        i = paramb.nxP;
        label2131:
        if (j == 0) {
          break label2311;
        }
        j = paramb.nxO;
        label2142:
        if (((Bitmap)localObject4).getWidth() <= i) {
          break label2320;
        }
        localObject2 = VideoMixer.a((Bitmap)localObject6, (Bitmap)localObject5, (((Bitmap)localObject4).getWidth() - i) / 2.0F, 0.0F, 8);
        label2175:
        BitmapUtil.saveBitmapToImage((Bitmap)localObject2, 70, Bitmap.CompressFormat.JPEG, (String)localObject3, true);
        paramb = new StringBuilder("createGraffitiThumb : ").append((String)localObject3).append("   graffiti : ");
        if (localObject6 != null) {
          break label2371;
        }
      }
      label2237:
      label2371:
      for (bool = true;; bool = false)
      {
        Log.i("MicroMsg.Media.VideoMixer", bool);
        break;
        localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.b.g(new com.tencent.mm.plugin.recordvideo.ui.editor.b.d(paramVideoMixer.NEk.NEA, paramVideoMixer.NEk.NEB, paramVideoMixer.NEk.yhJ, ((Point)localObject2).x, ((Point)localObject2).y, 0, 0, k, false, paramVideoMixer.NEk.NEF, 256));
        break label1960;
        i = paramb.nxO;
        break label2131;
        j = paramb.nxP;
        break label2142;
        if (((Bitmap)localObject4).getHeight() > j)
        {
          localObject2 = VideoMixer.a((Bitmap)localObject6, (Bitmap)localObject5, 0.0F, (((Bitmap)localObject4).getHeight() - j) / 2.0F, 4);
          break label2175;
        }
        localObject2 = VideoMixer.a((Bitmap)localObject6, (Bitmap)localObject5, 0.0F, 0.0F, 12);
        break label2175;
      }
      label2311:
      label2320:
      label2377:
      localObject5 = localObject4;
      break label2089;
      label2384:
      localObject4 = localObject2;
      break label596;
      localObject5 = localObject2;
      break label1217;
      label2398:
      i = 1;
      break;
      label2404:
      j = 1;
      break label358;
      label2410:
      i = 1;
      break label564;
      label2416:
      i = (int)(j * f2);
      break label421;
      label2428:
      i = 0;
      break label564;
      label2434:
      j = 1;
      continue;
      i = 0;
      break label1885;
      label2446:
      j = 0;
    }
  }
  
  private static void aTd(String paramString)
  {
    AppMethodBeat.i(75667);
    long l = Util.currentTicks();
    SightVideoJNI.optimizeMP4VFS(paramString);
    Log.i("MicroMsg.RemuxPlugin", s.X("time cost: ", Long.valueOf(Util.ticksToNow(l))));
    AppMethodBeat.o(75667);
  }
  
  private final Object b(kotlin.g.a.a<ah> parama, kotlin.d.d<? super ae> paramd)
  {
    AppMethodBeat.i(280798);
    if ((paramd instanceof f))
    {
      localObject1 = (f)paramd;
      if ((((f)localObject1).label & 0x80000000) != 0) {
        ((f)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ae>)localObject1;; paramd = new f(this, paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(280798);
        throw parama;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Object localObject2 = new StringBuilder("checkThirdPartyVideo change:").append(this.NLu.NHa).append(", check:");
    Object localObject1 = this.oaV;
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("MicroMsg.RemuxPlugin", localObject1);
      localObject1 = this;
      if (this.NLu.NHa) {
        break label543;
      }
      localObject1 = this.oaV;
      if ((localObject1 == null) || (((RecordConfigProvider)localObject1).NIq != true)) {
        break label260;
      }
      i = 1;
      label213:
      localObject1 = this;
      if (i == 0) {
        break label543;
      }
      localObject1 = this.NLs;
      if (localObject1 != null) {
        break label265;
      }
    }
    label260:
    label265:
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nJU)
    {
      if (localObject1 != null) {
        break label275;
      }
      AppMethodBeat.o(280798);
      return this;
      localObject1 = Boolean.valueOf(((RecordConfigProvider)localObject1).NIq);
      break;
      i = 0;
      break label213;
    }
    label275:
    localObject2 = this.NLr;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.a)localObject2).dismiss();
    }
    localObject2 = new com.tencent.mm.plugin.recordvideo.ui.a();
    ((com.tencent.mm.plugin.recordvideo.ui.a)localObject2).a(this.context, b.h.remux_loading_tips, (kotlin.g.a.a)ae.g.NLF);
    ah localah = ah.aiuX;
    this.NLr = ((com.tencent.mm.plugin.recordvideo.ui.a)localObject2);
    localObject2 = com.tencent.mm.plugin.recordvideo.util.j.ObG;
    paramd.L$0 = this;
    paramd.Uf = parama;
    paramd.label = 1;
    localObject2 = com.tencent.mm.plugin.recordvideo.util.j.o((String)localObject1, paramd);
    localObject1 = localObject2;
    paramd = this;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(280798);
      return locala;
      parama = (kotlin.g.a.a)paramd.Uf;
      paramd = (ae)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
    }
    localObject2 = (j.a)localObject1;
    if (localObject2 == null)
    {
      AppMethodBeat.o(280798);
      return paramd;
    }
    localObject1 = paramd;
    if (((j.a)localObject2).ieB)
    {
      if (((CharSequence)((j.a)localObject2).extData).length() > 0) {}
      for (i = 1;; i = 0)
      {
        localObject1 = paramd;
        if (i == 0) {
          break label543;
        }
        Log.i("MicroMsg.RemuxPlugin", "check is thirdparty video, pass result");
        localObject1 = paramd.gIN();
        if (localObject1 != null) {
          break;
        }
        AppMethodBeat.o(280798);
        return null;
      }
      CaptureDataManager.NHH.rnY.putString("kThirdPartyVideoExtData", ((j.a)localObject2).extData);
      paramd.b((CaptureDataManager.CaptureVideoNormalModel)localObject1);
      paramd = com.tencent.mm.plugin.recordvideo.f.g.NRB;
      com.tencent.mm.plugin.recordvideo.f.g.agO(3);
      paramd = com.tencent.mm.plugin.recordvideo.f.g.NRB;
      com.tencent.mm.plugin.recordvideo.f.g.aQ(1, 1L);
      parama.invoke();
      AppMethodBeat.o(280798);
      return null;
    }
    label543:
    AppMethodBeat.o(280798);
    return localObject1;
  }
  
  private final void b(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(75672);
    MultiProcessMMKV.getSingleDefault().putBoolean("mediacodec_create_error", false);
    CaptureDataManager.NHH.a(this.context, paramCaptureVideoNormalModel);
    AppMethodBeat.o(75672);
  }
  
  private final Object c(kotlin.g.a.a<ah> parama, kotlin.d.d<? super ae> paramd)
  {
    AppMethodBeat.i(280839);
    Object localObject2;
    if ((paramd instanceof e))
    {
      localObject2 = (e)paramd;
      if ((((e)localObject2).label & 0x80000000) != 0) {
        ((e)localObject2).label += -2147483648;
      }
    }
    Object localObject1;
    kotlin.d.a.a locala;
    for (;;)
    {
      localObject1 = ((e)localObject2).result;
      locala = kotlin.d.a.a.aiwj;
      switch (((e)localObject2).label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(280839);
        throw parama;
        localObject2 = new e(this, paramd);
      }
    }
    ResultKt.throwOnFailure(localObject1);
    RecordConfigProvider localRecordConfigProvider = this.oaV;
    Object localObject3 = this;
    Object localObject4 = parama;
    if (localRecordConfigProvider != null)
    {
      paramd = this;
      localObject1 = parama;
      if (!this.NLu.NHa)
      {
        paramd = this;
        localObject1 = parama;
        if (localRecordConfigProvider.NIq)
        {
          ((e)localObject2).L$0 = this;
          ((e)localObject2).Uf = parama;
          ((e)localObject2).VC = localRecordConfigProvider;
          ((e)localObject2).label = 1;
          localObject1 = b(parama, (kotlin.d.d)localObject2);
          localObject2 = localObject1;
          paramd = this;
          if (localObject1 == locala)
          {
            AppMethodBeat.o(280839);
            return locala;
            parama = (kotlin.g.a.a)((e)localObject2).Uf;
            paramd = (ae)((e)localObject2).L$0;
            ResultKt.throwOnFailure(localObject1);
            localObject2 = localObject1;
          }
          localObject1 = parama;
          if ((ae)localObject2 == null)
          {
            AppMethodBeat.o(280839);
            return null;
          }
        }
      }
      if (paramd.NLu.NGZ)
      {
        localObject3 = paramd;
        localObject4 = localObject1;
        if (!paramd.NLu.NHa)
        {
          parama = com.tencent.mm.media.b.b.nxK;
          localObject3 = paramd;
          localObject4 = localObject1;
          if (!com.tencent.mm.media.b.b.boA()) {}
        }
      }
      else
      {
        parama = paramd.NLt;
        if (parama == null) {}
        for (parama = null;; parama = parama.Gss)
        {
          localObject3 = paramd;
          localObject4 = localObject1;
          if (parama != null) {
            break label378;
          }
          parama = paramd.gIN();
          if (parama != null) {
            break;
          }
          AppMethodBeat.o(280839);
          return null;
        }
        paramd.b(parama);
        parama = com.tencent.mm.plugin.recordvideo.f.g.NRB;
        com.tencent.mm.plugin.recordvideo.f.g.agO(2);
        parama = com.tencent.mm.plugin.recordvideo.f.g.NRB;
        com.tencent.mm.plugin.recordvideo.f.g.aQ(1, 1L);
        AppMethodBeat.o(280839);
        return null;
      }
    }
    label378:
    ((kotlin.g.a.a)localObject4).invoke();
    AppMethodBeat.o(280839);
    return localObject3;
  }
  
  private final CaptureDataManager.CaptureVideoNormalModel gIN()
  {
    boolean bool = true;
    AppMethodBeat.i(280827);
    Object localObject3 = this.oaV;
    if (localObject3 != null)
    {
      Object localObject1 = this.NLs;
      if ((localObject1 != null) && (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nJW == true))
      {
        i = 1;
        if (i == 0) {
          break label345;
        }
        if (((RecordConfigProvider)localObject3).scene != 2) {
          break label315;
        }
        localObject1 = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.brg();
        label62:
        localObject1 = com.tencent.mm.plugin.recordvideo.util.f.Obq;
        com.tencent.mm.plugin.recordvideo.util.f.n(this.oaV);
        localObject1 = ((RecordConfigProvider)localObject3).NIe;
        s.s(localObject1, "this.outputVideoPath");
        localObject2 = ((RecordConfigProvider)localObject3).thumbPath;
        s.s(localObject2, "this.thumbPath");
        ll((String)localObject1, (String)localObject2);
        localObject1 = ((RecordConfigProvider)localObject3).NIe;
        s.s(localObject1, "this.outputVideoPath");
        aTd((String)localObject1);
        localObject2 = this.NLs;
        if (localObject2 != null)
        {
          CaptureDataManager.NHH.rnY.putBoolean("key_is_capture_video", ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).nJW);
          localObject1 = CaptureDataManager.NHH.rnY;
          localObject2 = (Collection)((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).nKc;
          if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
            break label335;
          }
          i = 1;
          label196:
          if (i != 0) {
            break label340;
          }
        }
      }
      long l;
      com.tencent.mm.plugin.recordvideo.f.c localc;
      label315:
      label335:
      label340:
      for (bool = true;; bool = false)
      {
        ((Bundle)localObject1).putBoolean("key_is_photo_video", bool);
        localObject1 = Boolean.TRUE;
        localObject2 = ((RecordConfigProvider)localObject3).NIe;
        localObject3 = ((RecordConfigProvider)localObject3).thumbPath;
        localObject4 = this.NLt;
        s.checkNotNull(localObject4);
        i = ((com.tencent.mm.plugin.recordvideo.c.g)localObject4).NGX;
        localObject4 = this.NLt;
        s.checkNotNull(localObject4);
        l = i - ((com.tencent.mm.plugin.recordvideo.c.g)localObject4).NGW;
        localObject4 = Boolean.FALSE;
        localc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        localObject1 = new CaptureDataManager.CaptureVideoNormalModel((Boolean)localObject1, (String)localObject2, (String)localObject3, Long.valueOf(l), (Boolean)localObject4, com.tencent.mm.plugin.recordvideo.f.c.gJe());
        AppMethodBeat.o(280827);
        return localObject1;
        i = 0;
        break;
        if (((RecordConfigProvider)localObject3).scene != 1) {
          break label62;
        }
        localObject1 = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.brh();
        break label62;
        i = 0;
        break label196;
      }
      label345:
      if (com.tencent.mm.compatible.util.d.rb(30))
      {
        localObject2 = MMApplicationContext.getContext();
        localObject1 = this.NLs;
        if (localObject1 == null)
        {
          localObject1 = null;
          localObject1 = ScopedStorageUtil.MediaStoreOps.videoPathToUri((Context)localObject2, (String)localObject1);
          if (localObject1 != null) {
            break label517;
          }
          localObject2 = null;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = this.NLs;
            if (localObject1 != null) {
              break label527;
            }
            localObject1 = null;
          }
          Log.i("MicroMsg.RemuxPlugin", s.X("checkNoNeedRemuxVideo uriPath:", localObject1));
          if (localObject1 == null) {
            break label811;
          }
          localObject2 = this.oaV;
          if (localObject2 != null) {
            break label564;
          }
          localObject2 = null;
          if (com.tencent.mm.vfs.y.O((String)localObject1, (String)localObject2, false) < 0L) {
            break label584;
          }
          localObject1 = this.oaV;
          if (localObject1 != null) {
            break label574;
          }
          localObject1 = null;
          localObject2 = (CharSequence)localObject1;
          if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
            break label587;
          }
        }
      }
      label389:
      label412:
      label444:
      label471:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label592;
        }
        AppMethodBeat.o(280827);
        return null;
        localObject1 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nJU;
        break;
        localObject2 = ((Uri)localObject1).toString();
        break label389;
        localObject1 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nJU;
        break label412;
        localObject1 = this.NLs;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label412;
        }
        localObject1 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nJU;
        break label412;
        localObject2 = ((RecordConfigProvider)localObject2).NIe;
        break label444;
        localObject1 = ((RecordConfigProvider)localObject1).NIe;
        break label471;
        break label471;
      }
      label517:
      label527:
      label564:
      label574:
      label584:
      label587:
      label592:
      Log.i("MicroMsg.RemuxPlugin", s.X("checkNoNeedRemuxVideo, targetVideoPath:", localObject1));
      Object localObject2 = ((RecordConfigProvider)localObject3).thumbPath;
      s.s(localObject2, "this.thumbPath");
      ll((String)localObject1, (String)localObject2);
      aTd((String)localObject1);
      Object localObject4 = this.NLs;
      if (localObject4 != null)
      {
        CaptureDataManager.NHH.rnY.putBoolean("key_is_capture_video", ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject4).nJW);
        localObject2 = CaptureDataManager.NHH.rnY;
        localObject4 = (Collection)((com.tencent.mm.media.widget.camerarecordview.b.b)localObject4).nKc;
        if ((localObject4 != null) && (!((Collection)localObject4).isEmpty())) {
          break label801;
        }
        i = 1;
        if (i != 0) {
          break label806;
        }
      }
      for (;;)
      {
        ((Bundle)localObject2).putBoolean("key_is_photo_video", bool);
        localObject2 = Boolean.TRUE;
        localObject3 = ((RecordConfigProvider)localObject3).thumbPath;
        localObject4 = this.NLt;
        s.checkNotNull(localObject4);
        i = ((com.tencent.mm.plugin.recordvideo.c.g)localObject4).NGX;
        localObject4 = this.NLt;
        s.checkNotNull(localObject4);
        l = i - ((com.tencent.mm.plugin.recordvideo.c.g)localObject4).NGW;
        localObject4 = Boolean.FALSE;
        localc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        localObject1 = new CaptureDataManager.CaptureVideoNormalModel((Boolean)localObject2, (String)localObject1, (String)localObject3, Long.valueOf(l), (Boolean)localObject4, com.tencent.mm.plugin.recordvideo.f.c.gJe());
        AppMethodBeat.o(280827);
        return localObject1;
        label801:
        i = 0;
        break;
        label806:
        bool = false;
      }
    }
    label811:
    AppMethodBeat.o(280827);
    return null;
  }
  
  private final void ll(String paramString1, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(75673);
    if (com.tencent.mm.vfs.y.ZC(paramString2)) {
      com.tencent.mm.vfs.y.deleteFile(paramString2);
    }
    paramString1 = com.tencent.mm.plugin.mmsight.d.Pf(paramString1);
    Object localObject;
    if (paramString1 != null)
    {
      localObject = com.tencent.mm.plugin.recordvideo.util.f.Obq;
      localObject = this.oaV;
      if (localObject != null) {
        break label68;
      }
    }
    for (;;)
    {
      BitmapUtil.saveBitmapToImage(com.tencent.mm.plugin.recordvideo.util.f.j(paramString1, i), 60, Bitmap.CompressFormat.JPEG, paramString2, true);
      AppMethodBeat.o(75673);
      return;
      label68:
      localObject = ((RecordConfigProvider)localObject).oXZ;
      if (localObject != null) {
        i = ((VideoTransPara)localObject).oCa;
      }
    }
  }
  
  public final void a(final com.tencent.mm.plugin.recordvideo.c.g paramg)
  {
    AppMethodBeat.i(75666);
    s.u(paramg, "editConfig");
    cb localcb = this.NLw;
    if (localcb != null) {
      localcb.a(null);
    }
    this.NLw = kotlinx.coroutines.j.a(this.scope, null, null, (m)new k(this, paramg, null), 3);
    AppMethodBeat.o(75666);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(281074);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(281074);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(281089);
    s.u(this, "this");
    AppMethodBeat.o(281089);
  }
  
  public final void c(com.tencent.mm.media.widget.camerarecordview.b.b paramb, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(75665);
    s.u(paramb, "info");
    s.u(paramRecordConfigProvider, "configProvider");
    this.NLs = paramb;
    this.oaV = paramRecordConfigProvider;
    paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.I("KEY_IS_CAPUTRE_BOOLEAN", Boolean.valueOf(paramb.nJW));
    if (paramb.nJW)
    {
      paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_CAPUTRE_VIDEO_PATH_STRING", paramb.bug());
      paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_CAPUTRE_THUMB_PATH_STRING", paramb.buh());
    }
    AppMethodBeat.o(75665);
  }
  
  public final String name()
  {
    AppMethodBeat.i(281078);
    String str = v.a.b(this);
    AppMethodBeat.o(281078);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(281084);
    s.u(this, "this");
    AppMethodBeat.o(281084);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(281092);
    s.u(this, "this");
    AppMethodBeat.o(281092);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(281099);
    s.u(this, "this");
    AppMethodBeat.o(281099);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(281103);
    s.u(this, "this");
    AppMethodBeat.o(281103);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(281110);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(281110);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(281116);
    s.u(this, "this");
    AppMethodBeat.o(281116);
  }
  
  public final void release()
  {
    AppMethodBeat.i(281073);
    s.u((v)this, "this");
    cb localcb = this.NLw;
    if (localcb != null) {
      localcb.a(null);
    }
    AppMethodBeat.o(281073);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(281122);
    s.u(this, "this");
    AppMethodBeat.o(281122);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(281127);
    s.u(this, "this");
    AppMethodBeat.o(281127);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "<anonymous parameter 1>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<Boolean, String, ah>
  {
    c(AudioCacheInfo paramAudioCacheInfo, kotlin.g.a.a<ah> parama, ae paramae)
    {
      super();
    }
    
    private static final void i(ae paramae)
    {
      AppMethodBeat.i(280475);
      s.u(paramae, "this$0");
      aa.makeText(paramae.context, b.h.story_pull_music_fail, 0).show();
      AppMethodBeat.o(280475);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(ae paramae, VideoMixer paramVideoMixer, ah.f<apw> paramf, RecordConfigProvider paramRecordConfigProvider)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    int label;
    
    e(ae paramae, kotlin.d.d<? super e> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(280465);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = ae.a(this.NLA, null, (kotlin.d.d)this);
      AppMethodBeat.o(280465);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    f(ae paramae, kotlin.d.d<? super f> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(280462);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = ae.a(this.NLA, (kotlin.d.d)this);
      AppMethodBeat.o(280462);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(ae paramae, g.b paramb, VideoMixer paramVideoMixer, com.tencent.mm.plugin.recordvideo.c.g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    j(ae paramae, VideoMixer paramVideoMixer, String paramString, apw paramapw)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    k(ae paramae, com.tencent.mm.plugin.recordvideo.c.g paramg, kotlin.d.d<? super k> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(280485);
      paramObject = (kotlin.d.d)new k(this.NLA, paramg, paramd);
      AppMethodBeat.o(280485);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(280481);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(280481);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Log.i("MicroMsg.RemuxPlugin", "startReMux !!!!");
        paramObject = ae.a(this.NLA, (kotlin.g.a.a)new ae.k.1(this.NLA));
        if (paramObject == null) {
          break label343;
        }
        Object localObject1 = paramg;
        ae.a(paramObject, (com.tencent.mm.plugin.recordvideo.c.g)localObject1);
        Object localObject2 = ((com.tencent.mm.plugin.recordvideo.c.g)localObject1).a(ae.b(paramObject), ae.c(paramObject));
        s.u(localObject2, "<set-?>");
        paramObject.NLu = ((g.b)localObject2);
        Log.i("MicroMsg.RemuxPlugin", s.X("configProvider : ", ae.b(paramObject)));
        Log.i("MicroMsg.RemuxPlugin", s.X("RemuxMediaEditConfig : ", localObject1));
        Log.i("MicroMsg.RemuxPlugin", s.X("mediaCaptureInfo : ", ae.c(paramObject)));
        Log.i("MicroMsg.RemuxPlugin", "generateTargetConfig info: " + paramObject.NLu + ' ');
        localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.I("KEY_VIDEO_IS_EDITED_BOOLEAN", Boolean.valueOf(paramObject.NLu.NHa));
        localObject1 = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.brj();
        if (paramObject.NLu.NHa)
        {
          localObject1 = com.tencent.mm.media.util.f.nFE;
          com.tencent.mm.media.util.f.bri();
        }
        paramObject = ae.b(paramObject, (kotlin.g.a.a)ae.k.2.NLK);
        if (paramObject == null) {
          break label343;
        }
        localObject1 = com.tencent.mm.plugin.recordvideo.util.f.Obq;
        com.tencent.mm.plugin.recordvideo.util.f.d(ae.c(paramObject));
        localObject1 = (kotlin.g.a.a)ae.k.3.NLL;
        localObject2 = (kotlin.d.d)this;
        this.label = 1;
        localObject1 = ae.a(paramObject, (kotlin.g.a.a)localObject1, (kotlin.d.d)localObject2);
        paramObject = localObject1;
        if (localObject1 == locala)
        {
          AppMethodBeat.o(280481);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (ae)paramObject;
      if (paramObject != null)
      {
        paramObject = ae.c(paramObject, (kotlin.g.a.a)ae.k.4.NLM);
        if (paramObject != null) {
          ae.d(paramObject, (kotlin.g.a.a)ae.k.5.NLN);
        }
      }
      label343:
      paramObject = ah.aiuX;
      AppMethodBeat.o(280481);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.ae
 * JD-Core Version:    0.7.0.1
 */