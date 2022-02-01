package com.tencent.mm.plugin.vlog.ui.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.recordvideo.b.g.b;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.u.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/video/RemuxNewPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "abaParams", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "editConfig", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig;", "editId", "", "enable", "", "encode", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "getEncode", "()Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "setEncode", "(Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;)V", "exportHevcHard", "exportHevcSoft", "loading", "Lcom/tencent/mm/plugin/recordvideo/ui/MediaProgressDialog;", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "mediaModel", "Lcom/tencent/mm/plugin/vlog/ui/video/MediaModel;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "checkDaemonVideo", "error", "Lkotlin/Function0;", "", "checkHevcEncode", "checkNoNeedRemuxVideo", "checkNullProvider", "checkRemux", "checkSaveThumb", "videoPath", "thumbPath", "checkVideoParam", "createABAParameter", "Lcom/tencent/mm/plugin/vlog/ui/video/ABAParamsUtil;", "dismissDialog", "doFinish", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "exportVideo", "musicPath", "callback", "Lkotlin/Function3;", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", "thumb", "setCaptureInfo", "info", "setErrorResult", "errCode", "", "setMoovHead", "path", "startReMux", "updateABABrWithQP", "videoInfo", "Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "encodeConfig", "Companion", "plugin-vlog_release"})
public final class g
  implements com.tencent.mm.plugin.recordvideo.plugin.u
{
  public static final a NFM;
  RecordConfigProvider ALV;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d APl;
  private int[] Azu;
  VideoTransPara EZB;
  com.tencent.mm.plugin.recordvideo.ui.a HOE;
  com.tencent.mm.media.widget.camerarecordview.b.b HOF;
  com.tencent.mm.plugin.recordvideo.b.g HOG;
  g.b HOH;
  boolean NFK;
  boolean NFL;
  e NFt;
  Context context;
  String editId;
  boolean enable;
  
  static
  {
    AppMethodBeat.i(230870);
    NFM = new a((byte)0);
    AppMethodBeat.o(230870);
  }
  
  public g(Context paramContext, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(230869);
    this.context = paramContext;
    this.APl = paramd;
    this.enable = true;
    this.HOH = new g.b((byte)0);
    this.editId = "";
    this.Azu = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    AppMethodBeat.o(230869);
  }
  
  static void aVV(String paramString)
  {
    AppMethodBeat.i(230864);
    long l = Util.currentTicks();
    SightVideoJNI.optimizeMP4VFS(paramString);
    Log.d("MicroMsg.RemuxNewPlugin", "time cost: " + Util.ticksToNow(l));
    AppMethodBeat.o(230864);
  }
  
  final void aku(int paramInt)
  {
    AppMethodBeat.i(230866);
    Object localObject = this.context;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(230866);
      throw ((Throwable)localObject);
    }
    ((Activity)localObject).setResult(paramInt);
    localObject = this.context;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(230866);
      throw ((Throwable)localObject);
    }
    ((Activity)localObject).finish();
    AppMethodBeat.o(230866);
  }
  
  final void b(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(230862);
    MultiProcessMMKV.getSingleDefault().putBoolean("mediacodec_create_error", false);
    CaptureDataManager.HKJ.a(this.context, paramCaptureVideoNormalModel);
    AppMethodBeat.o(230862);
  }
  
  final void b(final String paramString, final kotlin.g.a.q<? super Boolean, ? super acu, ? super Bitmap, x> paramq)
  {
    AppMethodBeat.i(230861);
    Object localObject1 = this.ALV;
    if (localObject1 == null) {
      p.iCn();
    }
    localObject1 = ((RecordConfigProvider)localObject1).HLg;
    Object localObject2 = this.HOG;
    if (localObject2 == null) {
      p.iCn();
    }
    localObject2 = ((com.tencent.mm.plugin.recordvideo.b.g)localObject2).HJW;
    Object localObject3 = this.HOG;
    if (localObject3 == null) {
      p.iCn();
    }
    localObject3 = ((com.tencent.mm.plugin.recordvideo.b.g)localObject3).HHh;
    final Rect localRect = new Rect();
    Object localObject4 = this.HOG;
    if (localObject4 == null) {
      p.iCn();
    }
    float f1 = localObject4.HHg[0];
    localObject4 = this.HOG;
    if (localObject4 == null) {
      p.iCn();
    }
    float f2 = localObject4.HHg[1];
    localObject4 = this.HOG;
    if (localObject4 == null) {
      p.iCn();
    }
    float f3 = localObject4.HHg[2];
    localObject4 = this.HOG;
    if (localObject4 == null) {
      p.iCn();
    }
    new RectF(f1, f2, f3, localObject4.HHg[3]).round(localRect);
    localObject4 = this.NFt;
    if (localObject4 == null) {
      p.iCn();
    }
    localObject4 = new ac(((e)localObject4).Nlb);
    if (paramString != null) {
      ((ac)localObject4).cP(paramString, true);
    }
    paramString = this.HOG;
    if (paramString == null) {
      p.iCn();
    }
    boolean bool;
    if (!paramString.HJH)
    {
      bool = true;
      ((ac)localObject4).Ap(bool);
      paramString = new b((ac)localObject4);
      if ((this.NFL) || (this.NFK))
      {
        localObject4 = com.tencent.mm.plugin.recordvideo.d.g.HUM;
        if (!this.NFL) {
          break label336;
        }
      }
    }
    label336:
    for (int i = 1;; i = 2)
    {
      com.tencent.mm.plugin.recordvideo.d.g.acB(i);
      com.tencent.mm.ae.d.b("RemuxNewPlugin_exportVideo", (kotlin.g.a.a)new e(this, paramString, (String)localObject1, localRect, (float[])localObject3, (ArrayList)localObject2, paramq));
      AppMethodBeat.o(230861);
      return;
      bool = false;
      break;
    }
  }
  
  public final void bbp() {}
  
  final void jQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(230863);
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
      AppMethodBeat.o(230863);
      return;
    }
  }
  
  public final String name()
  {
    AppMethodBeat.i(230871);
    String str = getClass().getName();
    AppMethodBeat.o(230871);
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
    AppMethodBeat.i(230873);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(230873);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/video/RemuxNewPlugin$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "filePath", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements m<Boolean, String, x>
  {
    c(g paramg, kotlin.g.a.q paramq)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "thumb", "Landroid/graphics/Bitmap;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.q<Boolean, acu, Bitmap, x>
  {
    d(g paramg, String paramString, long paramLong)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(g paramg, b paramb, String paramString, Rect paramRect, float[] paramArrayOfFloat, ArrayList paramArrayList, kotlin.g.a.q paramq)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    f(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.video.g
 * JD-Core Version:    0.7.0.1
 */