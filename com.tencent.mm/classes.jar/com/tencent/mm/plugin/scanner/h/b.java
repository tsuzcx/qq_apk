package com.tencent.mm.plugin.scanner.h;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.plugin.scanner.api.f;
import com.tencent.mm.plugin.scanner.api.g;
import com.tencent.mm.plugin.scanner.e.a.d;
import com.tencent.mm.plugin.scanner.ui.BaseScanUI;
import com.tencent.mm.plugin.scanner.util.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/service/ScanServiceImpl;", "Lcom/tencent/mm/plugin/scanner/api/IScanService;", "()V", "imageUploader", "Lcom/tencent/mm/plugin/scanner/image/uploader/AiScanImageSceneUploader;", "cancelPreviewImage", "", "session", "", "cancelUploadImage", "createImageOCRHelper", "Lcom/tencent/mm/plugin/scanner/api/ocr/IImageOCRHelper;", "context", "Landroid/content/Context;", "scene", "", "enableMultiCode", "", "enableOCR", "getSearchImagePath", "", "msgId", "canUseThumb", "preloadResource", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "previewImageForSearch", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "callback", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResultCallback;", "showOCRMenu", "ratioList", "", "", "startScanGoods", "enterScene", "startScanGoodsForResult", "requestCode", "uploadImageForOcr", "uploadImageForSearch", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.plugin.scanner.api.c
{
  public static final b.a OXb;
  private d OXc;
  
  static
  {
    AppMethodBeat.i(313337);
    OXb = new b.a((byte)0);
    AppMethodBeat.o(313337);
  }
  
  private static final void b(g paramg, long paramLong, f paramf)
  {
    AppMethodBeat.i(313325);
    s.u(paramf, "result");
    Log.i("MicroMsg.ScanServiceImpl", "alvinluo uploadImage onCallback success: %b, imagePath: %s, reqKey: %s, jumpType: %d", new Object[] { Boolean.valueOf(paramf.success), paramf.imagePath, paramf.hAT, Integer.valueOf(paramf.jumpType) });
    if (paramg != null) {
      paramg.onCallback(paramLong, paramf);
    }
    AppMethodBeat.o(313325);
  }
  
  private static final void c(g paramg, long paramLong, f paramf)
  {
    AppMethodBeat.i(313329);
    s.u(paramf, "result");
    Log.i("MicroMsg.ScanServiceImpl", "alvinluo uploadImageForOcr onCallback success: %b, imagePath: %s, reqKey: %s, jumpType: %d", new Object[] { Boolean.valueOf(paramf.success), paramf.imagePath, paramf.hAT, Integer.valueOf(paramf.jumpType) });
    if (paramg != null) {
      paramg.onCallback(paramLong, paramf);
    }
    AppMethodBeat.o(313329);
  }
  
  private static final void d(g paramg, long paramLong, f paramf)
  {
    AppMethodBeat.i(313334);
    s.u(paramf, "result");
    Log.i("MicroMsg.ScanServiceImpl", "alvinluo previewImage onCallback success: %b, imagePath: %s, reqKey: %s, jumpType: %d", new Object[] { Boolean.valueOf(paramf.success), paramf.imagePath, paramf.hAT, Integer.valueOf(paramf.jumpType) });
    if (paramg != null) {
      paramg.onCallback(paramLong, paramf);
    }
    AppMethodBeat.o(313334);
  }
  
  public final long a(e parame, g paramg)
  {
    AppMethodBeat.i(313365);
    parame.OMG = 1;
    if (parame.sessionId == 0L) {
      parame.sessionId = System.currentTimeMillis();
    }
    if (this.OXc == null) {
      this.OXc = new d();
    }
    paramg = new b..ExternalSyntheticLambda1(paramg);
    d locald = this.OXc;
    if (locald != null) {
      locald.a(parame.sessionId, parame, paramg);
    }
    long l = parame.sessionId;
    AppMethodBeat.o(313365);
    return l;
  }
  
  public final void a(Context paramContext, ScanGoodsRequest paramScanGoodsRequest, int paramInt)
  {
    AppMethodBeat.i(313357);
    s.u(paramContext, "context");
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(313357);
      return;
    }
    Log.i("MicroMsg.ScanServiceImpl", s.X("startScanGoods  enterScene:", Integer.valueOf(paramInt)));
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 12);
    localIntent.putExtra("key_scan_request", (Parcelable)paramScanGoodsRequest);
    localIntent.putExtra("key_scan_report_enter_scene", paramInt);
    localIntent.setClass(paramContext, BaseScanUI.class);
    paramScanGoodsRequest = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramScanGoodsRequest.aYi(), "com/tencent/mm/plugin/scanner/service/ScanServiceImpl", "startScanGoods", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramScanGoodsRequest.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/scanner/service/ScanServiceImpl", "startScanGoods", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(313357);
  }
  
  public final com.tencent.mm.plugin.scanner.api.a.a aQ(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(313388);
    s.u(paramContext, "context");
    paramContext = (com.tencent.mm.plugin.scanner.api.a.a)new com.tencent.mm.plugin.scanner.f.b(paramContext, paramInt);
    AppMethodBeat.o(313388);
    return paramContext;
  }
  
  public final long b(e parame, g paramg)
  {
    AppMethodBeat.i(313367);
    if (parame == null)
    {
      AppMethodBeat.o(313367);
      return 0L;
    }
    parame.OMG = 3;
    if (parame.sessionId == 0L) {
      parame.sessionId = System.currentTimeMillis();
    }
    if (this.OXc == null) {
      this.OXc = new d();
    }
    paramg = new b..ExternalSyntheticLambda0(paramg);
    d locald = this.OXc;
    if (locald != null) {
      locald.a(parame.sessionId, parame, paramg);
    }
    long l = parame.sessionId;
    AppMethodBeat.o(313367);
    return l;
  }
  
  public final void b(Context paramContext, ScanGoodsRequest paramScanGoodsRequest, int paramInt)
  {
    AppMethodBeat.i(313362);
    s.u(paramContext, "context");
    Log.i("MicroMsg.ScanServiceImpl", "startScanGoodsForResult requestCode: %d", new Object[] { Integer.valueOf(paramInt) });
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 12);
    localIntent.putExtra("key_scan_request", (Parcelable)paramScanGoodsRequest);
    com.tencent.mm.br.c.a(paramContext, "scanner", ".ui.BaseScanUI", localIntent, paramInt, false);
    AppMethodBeat.o(313362);
  }
  
  public final long c(e parame, g paramg)
  {
    AppMethodBeat.i(313375);
    if (parame == null)
    {
      AppMethodBeat.o(313375);
      return 0L;
    }
    parame.OMG = 2;
    if (parame.sessionId == 0L) {
      parame.sessionId = System.currentTimeMillis();
    }
    if (this.OXc == null) {
      this.OXc = new d();
    }
    paramg = new b..ExternalSyntheticLambda2(paramg);
    d locald = this.OXc;
    if (locald != null) {
      locald.a(parame.sessionId, parame, paramg);
    }
    long l = parame.sessionId;
    AppMethodBeat.o(313375);
    return l;
  }
  
  public final boolean gPA()
  {
    AppMethodBeat.i(313381);
    boolean bool = com.tencent.mm.plugin.scanner.c.a.gQm();
    AppMethodBeat.o(313381);
    return bool;
  }
  
  public final boolean gPB()
  {
    AppMethodBeat.i(313390);
    boolean bool = t.gPB();
    AppMethodBeat.o(313390);
    return bool;
  }
  
  public final boolean kf(List<Float> paramList)
  {
    AppMethodBeat.i(313385);
    if (paramList == null)
    {
      AppMethodBeat.o(313385);
      return false;
    }
    if ((com.tencent.mm.plugin.scanner.c.a.gQm()) && (com.tencent.mm.plugin.scanner.n.ke(paramList)))
    {
      AppMethodBeat.o(313385);
      return true;
    }
    AppMethodBeat.o(313385);
    return false;
  }
  
  public final String tM(long paramLong)
  {
    AppMethodBeat.i(313372);
    Object localObject1 = com.tencent.mm.plugin.scanner.e.c.OQm;
    cc localcc = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(paramLong);
    if ((!localcc.iYk()) && (!localcc.jbK()))
    {
      AppMethodBeat.o(313372);
      return null;
    }
    localObject1 = com.tencent.mm.plugin.scanner.e.c.bs(localcc);
    Object localObject2 = (CharSequence)localObject1;
    int i;
    Object localObject3;
    if ((localObject2 == null) || (kotlin.n.n.bp((CharSequence)localObject2)))
    {
      i = 1;
      if (i == 0) {
        break label513;
      }
      if ((localcc == null) || ((!localcc.iYk()) && (!localcc.jbK()))) {
        break label348;
      }
      if (localcc.field_isSend != 1) {
        break label354;
      }
      paramLong = localcc.field_msgId;
      localObject2 = r.bKa().H(localcc.field_talker, paramLong);
      s.s(localObject2, "getImgStg().getByMsgLocalId(msg.talker, id)");
      localObject1 = localObject2;
      if (((com.tencent.mm.modelimage.h)localObject2).localId == 0L)
      {
        paramLong = localcc.field_msgSvrId;
        Log.d("MicroMsg.AiScanChatImageUtils", "alvinluo getImagePath img invalid and try get by msgSvrId: %s", new Object[] { Long.valueOf(paramLong) });
        localObject1 = r.bKa().G(localcc.field_talker, paramLong);
        s.s(localObject1, "getImgStg().getByMsgSvrId(msg.talker, id)");
      }
      localObject3 = ((com.tencent.mm.modelimage.h)localObject1).oGr;
      localObject2 = r.bKa().v((String)localObject3, "", "");
      Log.d("MicroMsg.AiScanChatImageUtils", "alvinluo getImagePath bigImagePath %s, %s", new Object[] { localObject3, localObject2 });
      if (!y.ZC((String)localObject2)) {
        break label282;
      }
      localObject1 = localObject2;
    }
    label513:
    for (;;)
    {
      AppMethodBeat.o(313372);
      return localObject1;
      i = 0;
      break;
      label282:
      localObject1 = r.bKa().a(localcc.field_talker, (com.tencent.mm.modelimage.h)localObject1);
      localObject2 = r.bKa().v((String)localObject1, "", "");
      Log.d("MicroMsg.AiScanChatImageUtils", "alvinluo getImagePath hdImagePath %s, %s", new Object[] { localObject1, localObject2 });
      localObject1 = localObject2;
      if (!y.ZC((String)localObject2)) {
        label348:
        label354:
        do
        {
          do
          {
            localObject1 = null;
            break;
            paramLong = localcc.field_msgSvrId;
            localObject3 = r.bKa().G(localcc.field_talker, paramLong);
            s.s(localObject3, "getImgStg().getByMsgSvrId(msg.talker, id)");
            localObject1 = ((com.tencent.mm.modelimage.h)localObject3).oGr;
            localObject2 = r.bKa().v((String)localObject1, "", "");
            Log.d("MicroMsg.AiScanChatImageUtils", "alvinluo getImagePath receiver bigImagePath %s, %s", new Object[] { localObject1, localObject2 });
            localObject1 = localObject2;
            if (y.ZC((String)localObject2)) {
              break;
            }
          } while (!((com.tencent.mm.modelimage.h)localObject3).bJE());
          localObject2 = r.bKa().a(localcc.field_talker, (com.tencent.mm.modelimage.h)localObject3);
          localObject1 = r.bKa().v((String)localObject2, "", "");
          Log.d("MicroMsg.AiScanChatImageUtils", "alvinluo getImagePath receiver hdImagePath %s, %s", new Object[] { localObject2, localObject1 });
        } while (!y.ZC((String)localObject1));
      }
    }
  }
  
  public final void tN(long paramLong)
  {
    AppMethodBeat.i(313369);
    d locald = this.OXc;
    if (locald != null) {
      locald.cancel(paramLong);
    }
    AppMethodBeat.o(313369);
  }
  
  public final void tO(long paramLong)
  {
    AppMethodBeat.i(313379);
    d locald = this.OXc;
    if (locald != null) {
      locald.cancel(paramLong);
    }
    AppMethodBeat.o(313379);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.h.b
 * JD-Core Version:    0.7.0.1
 */