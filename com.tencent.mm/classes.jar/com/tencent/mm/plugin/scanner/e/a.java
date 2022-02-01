package com.tencent.mm.plugin.scanner.e;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.api.c;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.plugin.scanner.model.aa;
import com.tencent.mm.plugin.scanner.ui.BaseScanUI;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/service/ScanServiceImpl;", "Lcom/tencent/mm/plugin/scanner/api/IScanService;", "()V", "imageUploader", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageSceneUploader;", "cancelPreviewImage", "", "session", "", "cancelUploadImage", "getSearchImagePath", "", "msgId", "canUseThumb", "", "preloadResource", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "previewImageForSearch", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "callback", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResultCallback;", "startScanGoods", "context", "Landroid/content/Context;", "startScanGoodsForResult", "requestCode", "", "uploadImageForSearch", "Companion", "plugin-scan_release"})
public final class a
  implements com.tencent.mm.plugin.scanner.api.b
{
  public static final a.a yFh;
  private com.tencent.mm.plugin.scanner.model.b yFg;
  
  static
  {
    AppMethodBeat.i(189639);
    yFh = new a.a((byte)0);
    AppMethodBeat.o(189639);
  }
  
  public final String Gt(long paramLong)
  {
    AppMethodBeat.i(224246);
    Object localObject = aa.yDM;
    localObject = aa.A(paramLong, false);
    AppMethodBeat.o(224246);
    return localObject;
  }
  
  public final long a(c paramc, e parame)
  {
    AppMethodBeat.i(189634);
    paramc.yzN = 1;
    if (paramc.sessionId == 0L) {
      paramc.sessionId = System.currentTimeMillis();
    }
    if (this.yFg == null) {
      this.yFg = new com.tencent.mm.plugin.scanner.model.b();
    }
    parame = (e)new c(parame);
    com.tencent.mm.plugin.scanner.model.b localb = this.yFg;
    if (localb != null) {
      localb.a(paramc.sessionId, paramc, parame);
    }
    long l = paramc.sessionId;
    AppMethodBeat.o(189634);
    return l;
  }
  
  public final void a(Context paramContext, ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(189632);
    p.h(paramContext, "context");
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(189632);
      return;
    }
    ae.i("MicroMsg.ScanServiceImpl", "startScanGoods");
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 12);
    localIntent.putExtra("key_scan_request", (Parcelable)paramScanGoodsRequest);
    localIntent.setClass(paramContext, BaseScanUI.class);
    paramScanGoodsRequest = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramScanGoodsRequest.ahE(), "com/tencent/mm/plugin/scanner/service/ScanServiceImpl", "startScanGoods", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramScanGoodsRequest.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/scanner/service/ScanServiceImpl", "startScanGoods", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(189632);
  }
  
  public final void a(Context paramContext, ScanGoodsRequest paramScanGoodsRequest, int paramInt)
  {
    AppMethodBeat.i(189633);
    p.h(paramContext, "context");
    ae.i("MicroMsg.ScanServiceImpl", "startScanGoodsForResult requestCode: %d", new Object[] { Integer.valueOf(paramInt) });
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 12);
    localIntent.putExtra("key_scan_request", (Parcelable)paramScanGoodsRequest);
    com.tencent.mm.br.d.a(paramContext, "scanner", ".ui.BaseScanUI", localIntent, paramInt, false);
    AppMethodBeat.o(189633);
  }
  
  public final long b(c paramc, e parame)
  {
    AppMethodBeat.i(189637);
    if (paramc == null)
    {
      AppMethodBeat.o(189637);
      return 0L;
    }
    paramc.yzN = 2;
    if (paramc.sessionId == 0L) {
      paramc.sessionId = System.currentTimeMillis();
    }
    if (this.yFg == null) {
      this.yFg = new com.tencent.mm.plugin.scanner.model.b();
    }
    parame = (e)new b(parame);
    com.tencent.mm.plugin.scanner.model.b localb = this.yFg;
    if (localb != null) {
      localb.a(paramc.sessionId, paramc, parame);
    }
    long l = paramc.sessionId;
    AppMethodBeat.o(189637);
    return l;
  }
  
  public final void zr(long paramLong)
  {
    AppMethodBeat.i(189635);
    com.tencent.mm.plugin.scanner.model.b localb = this.yFg;
    if (localb != null)
    {
      localb.cancel(paramLong);
      AppMethodBeat.o(189635);
      return;
    }
    AppMethodBeat.o(189635);
  }
  
  public final void zs(long paramLong)
  {
    AppMethodBeat.i(189638);
    com.tencent.mm.plugin.scanner.model.b localb = this.yFg;
    if (localb != null)
    {
      localb.cancel(paramLong);
      AppMethodBeat.o(189638);
      return;
    }
    AppMethodBeat.o(189638);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "session", "", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onCallback"})
  static final class b
    implements e
  {
    b(e parame) {}
    
    public final void a(long paramLong, com.tencent.mm.plugin.scanner.api.d paramd)
    {
      AppMethodBeat.i(189629);
      p.h(paramd, "result");
      ae.i("MicroMsg.ScanServiceImpl", "alvinluo previewImage onCallback success: %b, imagePath: %s, reqKey: %s, jumpType: %d", new Object[] { Boolean.valueOf(paramd.success), paramd.imagePath, paramd.dmw, Integer.valueOf(paramd.jumpType) });
      e locale = this.yFi;
      if (locale != null)
      {
        locale.a(paramLong, paramd);
        AppMethodBeat.o(189629);
        return;
      }
      AppMethodBeat.o(189629);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "session", "", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onCallback"})
  static final class c
    implements e
  {
    c(e parame) {}
    
    public final void a(long paramLong, com.tencent.mm.plugin.scanner.api.d paramd)
    {
      AppMethodBeat.i(189631);
      p.h(paramd, "result");
      ae.i("MicroMsg.ScanServiceImpl", "alvinluo uploadImage onCallback success: %b, imagePath: %s, reqKey: %s, jumpType: %d", new Object[] { Boolean.valueOf(paramd.success), paramd.imagePath, paramd.dmw, Integer.valueOf(paramd.jumpType) });
      e locale = this.yFi;
      if (locale != null)
      {
        locale.a(paramLong, paramd);
        AppMethodBeat.o(189631);
        return;
      }
      AppMethodBeat.o(189631);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.a
 * JD-Core Version:    0.7.0.1
 */