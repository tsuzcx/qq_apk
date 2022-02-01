package com.tencent.mm.plugin.vlog.ui.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.c.g.b;
import com.tencent.mm.plugin.recordvideo.f.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import com.tencent.mm.plugin.recordvideo.util.j;
import com.tencent.mm.plugin.recordvideo.util.j.a;
import com.tencent.mm.plugin.sight.base.ABAPrams;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d<-Lcom.tencent.mm.plugin.vlog.ui.video.e;>;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cx;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/video/RemuxNewPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "abaParams", "Lcom/tencent/mm/plugin/sight/base/ABAPrams;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "editConfig", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig;", "editId", "", "enable", "", "encode", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "getEncode", "()Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "setEncode", "(Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;)V", "exportHevcHard", "exportHevcSoft", "loading", "Lcom/tencent/mm/plugin/recordvideo/ui/MediaProgressDialog;", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "mediaModel", "Lcom/tencent/mm/plugin/vlog/ui/video/MediaModel;", "remuxJob", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "checkDaemonVideo", "error", "Lkotlin/Function0;", "", "checkHevcEncode", "checkNoNeedRemuxVideo", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkNullProvider", "checkRemux", "checkSaveThumb", "videoPath", "thumbPath", "checkThirdPartyVideo", "checkVideoParam", "createABAParameter", "Lcom/tencent/mm/plugin/vlog/ui/video/ABAParamsUtil;", "dismissDialog", "doFinish", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "exportVideo", "musicPath", "callback", "Lkotlin/Function3;", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", "thumb", "handleNoNeedRemuxVideoFile", "release", "setCaptureInfo", "info", "setErrorResult", "errCode", "", "setMoovHead", "path", "startReMux", "updateABABrWithQP", "videoInfo", "Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "encodeConfig", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements v
{
  public static final e.a UrQ;
  private ABAPrams Gbz;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  VideoTransPara KVn;
  private com.tencent.mm.plugin.recordvideo.ui.a NLr;
  com.tencent.mm.media.widget.camerarecordview.b.b NLs;
  private com.tencent.mm.plugin.recordvideo.c.g NLt;
  g.b NLu;
  cb NLw;
  private d UrE;
  private boolean UrR;
  private boolean UrS;
  private Context context;
  private String editId;
  private boolean enable;
  RecordConfigProvider oaV;
  final aq scope;
  
  static
  {
    AppMethodBeat.i(282169);
    UrQ = new e.a((byte)0);
    AppMethodBeat.o(282169);
  }
  
  public e(Context paramContext, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(281903);
    this.context = paramContext;
    this.GrC = parama;
    this.enable = true;
    this.NLu = new g.b((byte)0);
    this.editId = "";
    this.scope = ar.b(ar.kBZ(), (kotlin.d.f)cx.g(null));
    AppMethodBeat.o(281903);
  }
  
  private static void aTd(String paramString)
  {
    AppMethodBeat.i(281965);
    long l = Util.currentTicks();
    SightVideoJNI.optimizeMP4VFS(paramString);
    Log.d("MicroMsg.RemuxNewPlugin", s.X("time cost: ", Long.valueOf(Util.ticksToNow(l))));
    AppMethodBeat.o(281965);
  }
  
  private final void apP(int paramInt)
  {
    AppMethodBeat.i(281973);
    ((Activity)this.context).setResult(paramInt);
    ((Activity)this.context).finish();
    AppMethodBeat.o(281973);
  }
  
  private final Object b(kotlin.g.a.a<ah> parama, kotlin.d.d<? super e> paramd)
  {
    AppMethodBeat.i(281935);
    if ((paramd instanceof f))
    {
      localObject1 = (f)paramd;
      if ((((f)localObject1).label & 0x80000000) != 0) {
        ((f)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super e>)localObject1;; paramd = new f(this, paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(281935);
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
        break label545;
      }
      localObject1 = this.oaV;
      if ((localObject1 == null) || (((RecordConfigProvider)localObject1).NIq != true)) {
        break label261;
      }
      i = 1;
      label214:
      localObject1 = this;
      if (i == 0) {
        break label545;
      }
      localObject1 = this.NLs;
      if (localObject1 != null) {
        break label266;
      }
    }
    label261:
    label266:
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nJU)
    {
      if (localObject1 != null) {
        break label276;
      }
      AppMethodBeat.o(281935);
      return this;
      localObject1 = Boolean.valueOf(((RecordConfigProvider)localObject1).NIq);
      break;
      i = 0;
      break label214;
    }
    label276:
    localObject2 = this.NLr;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.recordvideo.ui.a)localObject2).dismiss();
    }
    localObject2 = new com.tencent.mm.plugin.recordvideo.ui.a();
    ((com.tencent.mm.plugin.recordvideo.ui.a)localObject2).a(this.context, b.h.remux_loading_tips, (kotlin.g.a.a)e.g.UrV);
    ah localah = ah.aiuX;
    this.NLr = ((com.tencent.mm.plugin.recordvideo.ui.a)localObject2);
    localObject2 = j.ObG;
    paramd.L$0 = this;
    paramd.Uf = parama;
    paramd.label = 1;
    localObject2 = j.o((String)localObject1, paramd);
    localObject1 = localObject2;
    paramd = this;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(281935);
      return locala;
      parama = (kotlin.g.a.a)paramd.Uf;
      paramd = (e)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
    }
    localObject2 = (j.a)localObject1;
    if (localObject2 == null)
    {
      AppMethodBeat.o(281935);
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
          break label545;
        }
        Log.i("MicroMsg.RemuxPlugin", "check is thirdparty video, pass result");
        localObject1 = paramd.gIN();
        if (localObject1 != null) {
          break;
        }
        AppMethodBeat.o(281935);
        return null;
      }
      CaptureDataManager.NHH.rnY.putString("kThirdPartyVideoExtData", ((j.a)localObject2).extData);
      paramd.b((CaptureDataManager.CaptureVideoNormalModel)localObject1);
      paramd = com.tencent.mm.plugin.recordvideo.f.g.NRB;
      com.tencent.mm.plugin.recordvideo.f.g.agO(3);
      paramd = com.tencent.mm.plugin.recordvideo.f.g.NRB;
      com.tencent.mm.plugin.recordvideo.f.g.aQ(1, 1L);
      parama.invoke();
      AppMethodBeat.o(281935);
      return null;
    }
    label545:
    AppMethodBeat.o(281935);
    return localObject1;
  }
  
  private final void b(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(281952);
    MultiProcessMMKV.getSingleDefault().putBoolean("mediacodec_create_error", false);
    CaptureDataManager.NHH.a(this.context, paramCaptureVideoNormalModel);
    AppMethodBeat.o(281952);
  }
  
  private final void b(final String paramString, final q<? super Boolean, ? super afb, ? super Bitmap, ah> paramq)
  {
    AppMethodBeat.i(281948);
    Object localObject1 = this.oaV;
    s.checkNotNull(localObject1);
    localObject1 = ((RecordConfigProvider)localObject1).NIe;
    Object localObject2 = this.NLt;
    s.checkNotNull(localObject2);
    localObject2 = ((com.tencent.mm.plugin.recordvideo.c.g)localObject2).NGV;
    Object localObject3 = this.NLt;
    s.checkNotNull(localObject3);
    localObject3 = ((com.tencent.mm.plugin.recordvideo.c.g)localObject3).NEB;
    final Rect localRect = new Rect();
    Object localObject4 = this.NLt;
    s.checkNotNull(localObject4);
    float f1 = localObject4.NEA[0];
    localObject4 = this.NLt;
    s.checkNotNull(localObject4);
    float f2 = localObject4.NEA[1];
    localObject4 = this.NLt;
    s.checkNotNull(localObject4);
    float f3 = localObject4.NEA[2];
    localObject4 = this.NLt;
    s.checkNotNull(localObject4);
    new RectF(f1, f2, f3, localObject4.NEA[3]).round(localRect);
    localObject4 = this.UrE;
    s.checkNotNull(localObject4);
    localObject4 = new ac(((d)localObject4).TYA);
    if (paramString != null) {
      ((ac)localObject4).dv(paramString, true);
    }
    paramString = this.NLt;
    s.checkNotNull(paramString);
    boolean bool;
    if (!paramString.NGG)
    {
      bool = true;
      ((ac)localObject4).FO(bool);
      paramString = new b((ac)localObject4);
      if ((this.UrS) || (this.UrR))
      {
        localObject4 = com.tencent.mm.plugin.recordvideo.f.g.NRB;
        if (!this.UrS) {
          break label309;
        }
      }
    }
    label309:
    for (int i = 1;; i = 2)
    {
      com.tencent.mm.plugin.recordvideo.f.g.agR(i);
      com.tencent.mm.ae.d.d("RemuxNewPlugin_exportVideo", (kotlin.g.a.a)new h(this, paramString, (String)localObject1, localRect, (float[])localObject3, (ArrayList)localObject2, paramq));
      AppMethodBeat.o(281948);
      return;
      bool = false;
      break;
    }
  }
  
  private final Object c(kotlin.g.a.a<ah> parama, kotlin.d.d<? super e> paramd)
  {
    AppMethodBeat.i(281943);
    Object localObject2;
    if ((paramd instanceof b))
    {
      localObject2 = (b)paramd;
      if ((((b)localObject2).label & 0x80000000) != 0) {
        ((b)localObject2).label += -2147483648;
      }
    }
    Object localObject1;
    kotlin.d.a.a locala;
    for (;;)
    {
      localObject1 = ((b)localObject2).result;
      locala = kotlin.d.a.a.aiwj;
      switch (((b)localObject2).label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(281943);
        throw parama;
        localObject2 = new b(this, paramd);
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
          ((b)localObject2).L$0 = this;
          ((b)localObject2).Uf = parama;
          ((b)localObject2).VC = localRecordConfigProvider;
          ((b)localObject2).label = 1;
          localObject1 = b(parama, (kotlin.d.d)localObject2);
          localObject2 = localObject1;
          paramd = this;
          if (localObject1 == locala)
          {
            AppMethodBeat.o(281943);
            return locala;
            parama = (kotlin.g.a.a)((b)localObject2).Uf;
            paramd = (e)((b)localObject2).L$0;
            ResultKt.throwOnFailure(localObject1);
            localObject2 = localObject1;
          }
          localObject1 = parama;
          if ((e)localObject2 == null)
          {
            AppMethodBeat.o(281943);
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
          AppMethodBeat.o(281943);
          return null;
        }
        paramd.b(parama);
        parama = com.tencent.mm.plugin.recordvideo.f.g.NRB;
        com.tencent.mm.plugin.recordvideo.f.g.agO(2);
        parama = com.tencent.mm.plugin.recordvideo.f.g.NRB;
        com.tencent.mm.plugin.recordvideo.f.g.aQ(1, 1L);
        AppMethodBeat.o(281943);
        return null;
      }
    }
    label378:
    ((kotlin.g.a.a)localObject4).invoke();
    AppMethodBeat.o(281943);
    return localObject3;
  }
  
  private final CaptureDataManager.CaptureVideoNormalModel gIN()
  {
    boolean bool = true;
    AppMethodBeat.i(281920);
    Object localObject1 = this.oaV;
    if (localObject1 != null)
    {
      Object localObject2 = this.NLs;
      int i;
      if ((localObject2 != null) && (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).nJW == true))
      {
        i = 1;
        if (i == 0) {
          break label345;
        }
        if (((RecordConfigProvider)localObject1).scene != 2) {
          break label315;
        }
        localObject2 = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.brg();
        label62:
        localObject2 = com.tencent.mm.plugin.recordvideo.util.f.Obq;
        com.tencent.mm.plugin.recordvideo.util.f.n(this.oaV);
        localObject2 = ((RecordConfigProvider)localObject1).NIe;
        s.s(localObject2, "this.outputVideoPath");
        localObject3 = ((RecordConfigProvider)localObject1).thumbPath;
        s.s(localObject3, "this.thumbPath");
        ll((String)localObject2, (String)localObject3);
        localObject2 = ((RecordConfigProvider)localObject1).NIe;
        s.s(localObject2, "this.outputVideoPath");
        aTd((String)localObject2);
        localObject3 = this.NLs;
        if (localObject3 != null)
        {
          CaptureDataManager.NHH.rnY.putBoolean("key_is_capture_video", ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject3).nJW);
          localObject2 = CaptureDataManager.NHH.rnY;
          localObject3 = (Collection)((com.tencent.mm.media.widget.camerarecordview.b.b)localObject3).nKc;
          if ((localObject3 != null) && (!((Collection)localObject3).isEmpty())) {
            break label335;
          }
          i = 1;
          label196:
          if (i != 0) {
            break label340;
          }
        }
      }
      Object localObject4;
      long l;
      c localc;
      label315:
      label335:
      label340:
      for (bool = true;; bool = false)
      {
        ((Bundle)localObject2).putBoolean("key_is_photo_video", bool);
        localObject2 = Boolean.TRUE;
        localObject3 = ((RecordConfigProvider)localObject1).NIe;
        localObject1 = ((RecordConfigProvider)localObject1).thumbPath;
        localObject4 = this.NLt;
        s.checkNotNull(localObject4);
        i = ((com.tencent.mm.plugin.recordvideo.c.g)localObject4).NGX;
        localObject4 = this.NLt;
        s.checkNotNull(localObject4);
        l = i - ((com.tencent.mm.plugin.recordvideo.c.g)localObject4).NGW;
        localObject4 = Boolean.FALSE;
        localc = c.NRf;
        localObject1 = new CaptureDataManager.CaptureVideoNormalModel((Boolean)localObject2, (String)localObject3, (String)localObject1, Long.valueOf(l), (Boolean)localObject4, c.gJe());
        AppMethodBeat.o(281920);
        return localObject1;
        i = 0;
        break;
        if (((RecordConfigProvider)localObject1).scene != 1) {
          break label62;
        }
        localObject2 = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.brh();
        break label62;
        i = 0;
        break label196;
      }
      label345:
      localObject2 = this.NLs;
      s.checkNotNull(localObject2);
      localObject2 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).nJU;
      Object localObject3 = ((RecordConfigProvider)localObject1).thumbPath;
      s.s(localObject3, "this.thumbPath");
      ll((String)localObject2, (String)localObject3);
      localObject2 = this.NLs;
      s.checkNotNull(localObject2);
      aTd(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).nJU);
      localObject3 = this.NLs;
      if (localObject3 != null)
      {
        CaptureDataManager.NHH.rnY.putBoolean("key_is_capture_video", ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject3).nJW);
        localObject2 = CaptureDataManager.NHH.rnY;
        localObject3 = (Collection)((com.tencent.mm.media.widget.camerarecordview.b.b)localObject3).nKc;
        if ((localObject3 != null) && (!((Collection)localObject3).isEmpty())) {
          break label591;
        }
        i = 1;
        if (i != 0) {
          break label596;
        }
      }
      for (;;)
      {
        ((Bundle)localObject2).putBoolean("key_is_photo_video", bool);
        localObject2 = Boolean.TRUE;
        localObject3 = this.NLs;
        s.checkNotNull(localObject3);
        localObject3 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject3).nJU;
        localObject1 = ((RecordConfigProvider)localObject1).thumbPath;
        localObject4 = this.NLt;
        s.checkNotNull(localObject4);
        i = ((com.tencent.mm.plugin.recordvideo.c.g)localObject4).NGX;
        localObject4 = this.NLt;
        s.checkNotNull(localObject4);
        l = i - ((com.tencent.mm.plugin.recordvideo.c.g)localObject4).NGW;
        localObject4 = Boolean.FALSE;
        localc = c.NRf;
        localObject1 = new CaptureDataManager.CaptureVideoNormalModel((Boolean)localObject2, (String)localObject3, (String)localObject1, Long.valueOf(l), (Boolean)localObject4, c.gJe());
        AppMethodBeat.o(281920);
        return localObject1;
        label591:
        i = 0;
        break;
        label596:
        bool = false;
      }
    }
    AppMethodBeat.o(281920);
    return null;
  }
  
  private final void ll(String paramString1, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(281958);
    if (y.ZC(paramString2)) {
      y.deleteFile(paramString2);
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
      AppMethodBeat.o(281958);
      return;
      label68:
      localObject = ((RecordConfigProvider)localObject).oXZ;
      if (localObject != null) {
        i = ((VideoTransPara)localObject).oCa;
      }
    }
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(282182);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(282182);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(282201);
    s.u(this, "this");
    AppMethodBeat.o(282201);
  }
  
  public final String name()
  {
    AppMethodBeat.i(282189);
    String str = v.a.b(this);
    AppMethodBeat.o(282189);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(282196);
    s.u(this, "this");
    AppMethodBeat.o(282196);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(282207);
    s.u(this, "this");
    AppMethodBeat.o(282207);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(282210);
    s.u(this, "this");
    AppMethodBeat.o(282210);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(282215);
    s.u(this, "this");
    AppMethodBeat.o(282215);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(282219);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(282219);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(282223);
    s.u(this, "this");
    AppMethodBeat.o(282223);
  }
  
  public final void release()
  {
    AppMethodBeat.i(282174);
    s.u((v)this, "this");
    cb localcb = this.NLw;
    if (localcb != null) {
      localcb.a(null);
    }
    AppMethodBeat.o(282174);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(282227);
    s.u(this, "this");
    AppMethodBeat.o(282227);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(282233);
    s.u(this, "this");
    AppMethodBeat.o(282233);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    int label;
    
    b(e parame, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(281929);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = e.a(this.UrT, null, (kotlin.d.d)this);
      AppMethodBeat.o(281929);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "filePath", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements m<Boolean, String, ah>
  {
    d(e parame, q<? super Boolean, ? super afb, ? super Bitmap, ah> paramq)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "thumb", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements q<Boolean, afb, Bitmap, ah>
  {
    e(String paramString, e parame, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    f(e parame, kotlin.d.d<? super f> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(281932);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = e.a(this.UrT, (kotlin.d.d)this);
      AppMethodBeat.o(281932);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(e parame, b paramb, String paramString, Rect paramRect, float[] paramArrayOfFloat, ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramArrayList, q<? super Boolean, ? super afb, ? super Bitmap, ah> paramq)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    i(e parame, com.tencent.mm.plugin.recordvideo.c.g paramg, d paramd, kotlin.d.d<? super i> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(281926);
      paramObject = (kotlin.d.d)new i(this.UrT, this.NLI, this.UrY, paramd);
      AppMethodBeat.o(281926);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(281921);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(281921);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        e.a(this.UrT);
        Log.i("MicroMsg.RemuxNewPlugin", "startReMux !!!!");
        paramObject = e.a(this.UrT, (kotlin.g.a.a)new e.i.1(this.UrT));
        if (paramObject == null) {
          break label383;
        }
        localObject1 = this.NLI;
        Object localObject2 = this.UrY;
        e.a(paramObject, (com.tencent.mm.plugin.recordvideo.c.g)localObject1);
        e.a(paramObject, (d)localObject2);
        localObject2 = new StringBuilder();
        h.baC();
        e.a(paramObject, com.tencent.mm.kernel.b.aZs() + '_' + Util.nowMilliSecond());
        localObject2 = ((com.tencent.mm.plugin.recordvideo.c.g)localObject1).a(e.c(paramObject), e.e(paramObject));
        s.u(localObject2, "<set-?>");
        paramObject.NLu = ((g.b)localObject2);
        Log.i("MicroMsg.RemuxNewPlugin", s.X("configProvider : ", e.c(paramObject)));
        Log.i("MicroMsg.RemuxNewPlugin", s.X("RemuxMediaEditConfig : ", localObject1));
        Log.i("MicroMsg.RemuxNewPlugin", s.X("mediaCaptureInfo : ", e.e(paramObject)));
        Log.i("MicroMsg.RemuxNewPlugin", "generateTargetConfig info: " + paramObject.NLu + ' ');
        localObject1 = c.NRf;
        c.I("KEY_VIDEO_IS_EDITED_BOOLEAN", Boolean.valueOf(paramObject.NLu.NHa));
        localObject1 = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.brj();
        if (paramObject.NLu.NHa)
        {
          localObject1 = com.tencent.mm.media.util.f.nFE;
          com.tencent.mm.media.util.f.bri();
        }
        paramObject = e.b(paramObject, (kotlin.g.a.a)e.i.2.UrZ);
        if (paramObject == null) {
          break label383;
        }
        localObject1 = com.tencent.mm.plugin.recordvideo.util.f.Obq;
        com.tencent.mm.plugin.recordvideo.util.f.d(e.e(paramObject));
        localObject1 = (kotlin.g.a.a)e.i.3.Usa;
        localObject2 = (kotlin.d.d)this;
        this.label = 1;
        localObject1 = e.a(paramObject, (kotlin.g.a.a)localObject1, (kotlin.d.d)localObject2);
        paramObject = localObject1;
        if (localObject1 == locala)
        {
          AppMethodBeat.o(281921);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (e)paramObject;
      if (paramObject != null)
      {
        localObject1 = e.i.4.Usb;
        e.d(paramObject);
      }
      label383:
      paramObject = ah.aiuX;
      AppMethodBeat.o(281921);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.video.e
 * JD-Core Version:    0.7.0.1
 */