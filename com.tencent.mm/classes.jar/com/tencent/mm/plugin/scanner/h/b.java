package com.tencent.mm.plugin.scanner.h;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.plugin.scanner.api.f;
import com.tencent.mm.plugin.scanner.e.a.d;
import com.tencent.mm.plugin.scanner.ui.BaseScanUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/service/ScanServiceImpl;", "Lcom/tencent/mm/plugin/scanner/api/IScanService;", "()V", "imageUploader", "Lcom/tencent/mm/plugin/scanner/image/uploader/AiScanImageSceneUploader;", "cancelPreviewImage", "", "session", "", "cancelUploadImage", "createImageOCRHelper", "Lcom/tencent/mm/plugin/scanner/api/ocr/IImageOCRHelper;", "context", "Landroid/content/Context;", "scene", "", "getSearchImagePath", "", "msgId", "canUseThumb", "", "preloadResource", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "previewImageForSearch", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "callback", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResultCallback;", "showOCRMenu", "ratioList", "", "", "startScanGoods", "startScanGoodsForResult", "requestCode", "uploadImageForOcr", "uploadImageForSearch", "Companion", "plugin-scan_release"})
public final class b
  implements com.tencent.mm.plugin.scanner.api.c
{
  public static final b.a IOz;
  private d IOy;
  
  static
  {
    AppMethodBeat.i(223286);
    IOz = new b.a((byte)0);
    AppMethodBeat.o(223286);
  }
  
  public final String PK(long paramLong)
  {
    AppMethodBeat.i(223278);
    Object localObject1 = com.tencent.mm.plugin.scanner.e.c.IJz;
    localObject1 = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject1).eSe().Oq(paramLong);
    p.j(localca, "msg");
    if ((!localca.hwG()) && (!localca.hzF()))
    {
      AppMethodBeat.o(223278);
      return null;
    }
    localObject1 = com.tencent.mm.plugin.scanner.e.c.bb(localca);
    Object localObject2 = (CharSequence)localObject1;
    int i;
    Object localObject3;
    if ((localObject2 == null) || (kotlin.n.n.ba((CharSequence)localObject2)))
    {
      i = 1;
      if (i == 0) {
        break label501;
      }
      if ((!localca.hwG()) && (!localca.hzF())) {
        break label345;
      }
      if (localca.apA() != 1) {
        break label351;
      }
      paramLong = localca.apG();
      localObject2 = q.bmh().D(localca.apJ(), paramLong);
      p.j(localObject2, "SubCoreImage.getImgStg()…sgLocalId(msg.talker, id)");
      localObject1 = localObject2;
      if (((com.tencent.mm.ay.g)localObject2).getLocalId() == 0L)
      {
        paramLong = localca.apH();
        Log.d("MicroMsg.AiScanChatImageUtils", "alvinluo getImagePath img invalid and try get by msgSvrId: %s", new Object[] { Long.valueOf(paramLong) });
        localObject1 = q.bmh().C(localca.apJ(), paramLong);
        p.j(localObject1, "SubCoreImage.getImgStg()…yMsgSvrId(msg.talker, id)");
      }
      localObject3 = ((com.tencent.mm.ay.g)localObject1).blG();
      localObject2 = q.bmh().r((String)localObject3, "", "");
      Log.d("MicroMsg.AiScanChatImageUtils", "alvinluo getImagePath bigImagePath %s, %s", new Object[] { localObject3, localObject2 });
      if (!u.agG((String)localObject2)) {
        break label283;
      }
      localObject1 = localObject2;
    }
    label283:
    label345:
    label351:
    label501:
    for (;;)
    {
      AppMethodBeat.o(223278);
      return localObject1;
      i = 0;
      break;
      localObject1 = q.bmh().a(localca.apJ(), (com.tencent.mm.ay.g)localObject1);
      localObject2 = q.bmh().r((String)localObject1, "", "");
      Log.d("MicroMsg.AiScanChatImageUtils", "alvinluo getImagePath hdImagePath %s, %s", new Object[] { localObject1, localObject2 });
      localObject1 = localObject2;
      if (!u.agG((String)localObject2)) {
        do
        {
          do
          {
            localObject1 = null;
            break;
            paramLong = localca.apH();
            localObject3 = q.bmh().C(localca.apJ(), paramLong);
            p.j(localObject3, "SubCoreImage.getImgStg()…yMsgSvrId(msg.talker, id)");
            localObject1 = ((com.tencent.mm.ay.g)localObject3).blG();
            localObject2 = q.bmh().r((String)localObject1, "", "");
            Log.d("MicroMsg.AiScanChatImageUtils", "alvinluo getImagePath receiver bigImagePath %s, %s", new Object[] { localObject1, localObject2 });
            localObject1 = localObject2;
            if (u.agG((String)localObject2)) {
              break;
            }
          } while (!((com.tencent.mm.ay.g)localObject3).blK());
          localObject2 = q.bmh().a(localca.apJ(), (com.tencent.mm.ay.g)localObject3);
          localObject1 = q.bmh().r((String)localObject2, "", "");
          Log.d("MicroMsg.AiScanChatImageUtils", "alvinluo getImagePath receiver hdImagePath %s, %s", new Object[] { localObject2, localObject1 });
        } while (!u.agG((String)localObject1));
      }
    }
  }
  
  public final void PL(long paramLong)
  {
    AppMethodBeat.i(223263);
    d locald = this.IOy;
    if (locald != null)
    {
      locald.cancel(paramLong);
      AppMethodBeat.o(223263);
      return;
    }
    AppMethodBeat.o(223263);
  }
  
  public final void PM(long paramLong)
  {
    AppMethodBeat.i(223283);
    d locald = this.IOy;
    if (locald != null)
    {
      locald.cancel(paramLong);
      AppMethodBeat.o(223283);
      return;
    }
    AppMethodBeat.o(223283);
  }
  
  public final long a(e parame, com.tencent.mm.plugin.scanner.api.g paramg)
  {
    AppMethodBeat.i(223257);
    parame.IGy = 1;
    if (parame.sessionId == 0L) {
      parame.sessionId = System.currentTimeMillis();
    }
    if (this.IOy == null) {
      this.IOy = new d();
    }
    paramg = (com.tencent.mm.plugin.scanner.api.g)new d(paramg);
    d locald = this.IOy;
    if (locald != null) {
      locald.a(parame.sessionId, parame, paramg);
    }
    long l = parame.sessionId;
    AppMethodBeat.o(223257);
    return l;
  }
  
  public final void a(Context paramContext, ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(223245);
    p.k(paramContext, "context");
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(223245);
      return;
    }
    Log.i("MicroMsg.ScanServiceImpl", "startScanGoods");
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 12);
    localIntent.putExtra("key_scan_request", (Parcelable)paramScanGoodsRequest);
    localIntent.setClass(paramContext, BaseScanUI.class);
    paramScanGoodsRequest = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramScanGoodsRequest.aFh(), "com/tencent/mm/plugin/scanner/service/ScanServiceImpl", "startScanGoods", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramScanGoodsRequest.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/scanner/service/ScanServiceImpl", "startScanGoods", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(223245);
  }
  
  public final void a(Context paramContext, ScanGoodsRequest paramScanGoodsRequest, int paramInt)
  {
    AppMethodBeat.i(223249);
    p.k(paramContext, "context");
    Log.i("MicroMsg.ScanServiceImpl", "startScanGoodsForResult requestCode: %d", new Object[] { Integer.valueOf(paramInt) });
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 12);
    localIntent.putExtra("key_scan_request", (Parcelable)paramScanGoodsRequest);
    com.tencent.mm.by.c.a(paramContext, "scanner", ".ui.BaseScanUI", localIntent, paramInt, false);
    AppMethodBeat.o(223249);
  }
  
  public final com.tencent.mm.plugin.scanner.api.a.a aD(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(223285);
    p.k(paramContext, "context");
    paramContext = (com.tencent.mm.plugin.scanner.api.a.a)new com.tencent.mm.plugin.scanner.f.b(paramContext, paramInt);
    AppMethodBeat.o(223285);
    return paramContext;
  }
  
  public final long b(e parame, com.tencent.mm.plugin.scanner.api.g paramg)
  {
    AppMethodBeat.i(223261);
    if (parame == null)
    {
      AppMethodBeat.o(223261);
      return 0L;
    }
    parame.IGy = 3;
    if (parame.sessionId == 0L) {
      parame.sessionId = System.currentTimeMillis();
    }
    if (this.IOy == null) {
      this.IOy = new d();
    }
    paramg = (com.tencent.mm.plugin.scanner.api.g)new c(paramg);
    d locald = this.IOy;
    if (locald != null) {
      locald.a(parame.sessionId, parame, paramg);
    }
    long l = parame.sessionId;
    AppMethodBeat.o(223261);
    return l;
  }
  
  public final long c(e parame, com.tencent.mm.plugin.scanner.api.g paramg)
  {
    AppMethodBeat.i(223280);
    if (parame == null)
    {
      AppMethodBeat.o(223280);
      return 0L;
    }
    parame.IGy = 2;
    if (parame.sessionId == 0L) {
      parame.sessionId = System.currentTimeMillis();
    }
    if (this.IOy == null) {
      this.IOy = new d();
    }
    paramg = (com.tencent.mm.plugin.scanner.api.g)new b(paramg);
    d locald = this.IOy;
    if (locald != null) {
      locald.a(parame.sessionId, parame, paramg);
    }
    long l = parame.sessionId;
    AppMethodBeat.o(223280);
    return l;
  }
  
  public final boolean he(List<Float> paramList)
  {
    AppMethodBeat.i(223284);
    if (paramList == null)
    {
      AppMethodBeat.o(223284);
      return false;
    }
    if ((com.tencent.mm.plugin.scanner.c.a.fCy()) && (com.tencent.mm.plugin.scanner.n.hd(paramList)))
    {
      AppMethodBeat.o(223284);
      return true;
    }
    AppMethodBeat.o(223284);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "session", "", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onCallback"})
  static final class b
    implements com.tencent.mm.plugin.scanner.api.g
  {
    b(com.tencent.mm.plugin.scanner.api.g paramg) {}
    
    public final void a(long paramLong, f paramf)
    {
      AppMethodBeat.i(220104);
      p.k(paramf, "result");
      Log.i("MicroMsg.ScanServiceImpl", "alvinluo previewImage onCallback success: %b, imagePath: %s, reqKey: %s, jumpType: %d", new Object[] { Boolean.valueOf(paramf.success), paramf.imagePath, paramf.fwv, Integer.valueOf(paramf.jumpType) });
      com.tencent.mm.plugin.scanner.api.g localg = this.IOA;
      if (localg != null)
      {
        localg.a(paramLong, paramf);
        AppMethodBeat.o(220104);
        return;
      }
      AppMethodBeat.o(220104);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "session", "", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onCallback"})
  static final class c
    implements com.tencent.mm.plugin.scanner.api.g
  {
    c(com.tencent.mm.plugin.scanner.api.g paramg) {}
    
    public final void a(long paramLong, f paramf)
    {
      AppMethodBeat.i(221557);
      p.k(paramf, "result");
      Log.i("MicroMsg.ScanServiceImpl", "alvinluo uploadImageForOcr onCallback success: %b, imagePath: %s, reqKey: %s, jumpType: %d", new Object[] { Boolean.valueOf(paramf.success), paramf.imagePath, paramf.fwv, Integer.valueOf(paramf.jumpType) });
      com.tencent.mm.plugin.scanner.api.g localg = this.IOA;
      if (localg != null)
      {
        localg.a(paramLong, paramf);
        AppMethodBeat.o(221557);
        return;
      }
      AppMethodBeat.o(221557);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "session", "", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onCallback"})
  static final class d
    implements com.tencent.mm.plugin.scanner.api.g
  {
    d(com.tencent.mm.plugin.scanner.api.g paramg) {}
    
    public final void a(long paramLong, f paramf)
    {
      AppMethodBeat.i(217023);
      p.k(paramf, "result");
      Log.i("MicroMsg.ScanServiceImpl", "alvinluo uploadImage onCallback success: %b, imagePath: %s, reqKey: %s, jumpType: %d", new Object[] { Boolean.valueOf(paramf.success), paramf.imagePath, paramf.fwv, Integer.valueOf(paramf.jumpType) });
      com.tencent.mm.plugin.scanner.api.g localg = this.IOA;
      if (localg != null)
      {
        localg.a(paramLong, paramf);
        AppMethodBeat.o(217023);
        return;
      }
      AppMethodBeat.o(217023);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.h.b
 * JD-Core Version:    0.7.0.1
 */