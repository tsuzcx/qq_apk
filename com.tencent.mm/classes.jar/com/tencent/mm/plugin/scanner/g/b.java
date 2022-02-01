package com.tencent.mm.plugin.scanner.g;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.plugin.scanner.api.f;
import com.tencent.mm.plugin.scanner.api.g;
import com.tencent.mm.plugin.scanner.i;
import com.tencent.mm.plugin.scanner.model.ac;
import com.tencent.mm.plugin.scanner.ui.BaseScanUI;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/service/ScanServiceImpl;", "Lcom/tencent/mm/plugin/scanner/api/IScanService;", "()V", "imageUploader", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageSceneUploader;", "cancelPreviewImage", "", "session", "", "cancelUploadImage", "createImageOCRHelper", "Lcom/tencent/mm/plugin/scanner/api/ocr/IImageOCRHelper;", "context", "Landroid/content/Context;", "getSearchImagePath", "", "msgId", "canUseThumb", "", "preloadResource", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "previewImageForSearch", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "callback", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResultCallback;", "showOCRMenu", "ratioList", "", "", "startScanGoods", "startScanGoodsForResult", "requestCode", "", "uploadImageForOcr", "uploadImageForSearch", "Companion", "plugin-scan_release"})
public final class b
  implements com.tencent.mm.plugin.scanner.api.c
{
  public static final b.a CIZ;
  private com.tencent.mm.plugin.scanner.model.c CIY;
  
  static
  {
    AppMethodBeat.i(240576);
    CIZ = new b.a((byte)0);
    AppMethodBeat.o(240576);
  }
  
  public final String Iq(long paramLong)
  {
    AppMethodBeat.i(240571);
    Object localObject = ac.CGB;
    localObject = ac.G(paramLong, false);
    AppMethodBeat.o(240571);
    return localObject;
  }
  
  public final void Ir(long paramLong)
  {
    AppMethodBeat.i(240570);
    com.tencent.mm.plugin.scanner.model.c localc = this.CIY;
    if (localc != null)
    {
      localc.cancel(paramLong);
      AppMethodBeat.o(240570);
      return;
    }
    AppMethodBeat.o(240570);
  }
  
  public final void Is(long paramLong)
  {
    AppMethodBeat.i(240573);
    com.tencent.mm.plugin.scanner.model.c localc = this.CIY;
    if (localc != null)
    {
      localc.cancel(paramLong);
      AppMethodBeat.o(240573);
      return;
    }
    AppMethodBeat.o(240573);
  }
  
  public final long a(e parame, g paramg)
  {
    AppMethodBeat.i(240568);
    parame.CAT = 1;
    if (parame.sessionId == 0L) {
      parame.sessionId = System.currentTimeMillis();
    }
    if (this.CIY == null) {
      this.CIY = new com.tencent.mm.plugin.scanner.model.c();
    }
    paramg = (g)new d(paramg);
    com.tencent.mm.plugin.scanner.model.c localc = this.CIY;
    if (localc != null) {
      localc.a(parame.sessionId, parame, paramg);
    }
    long l = parame.sessionId;
    AppMethodBeat.o(240568);
    return l;
  }
  
  public final void a(Context paramContext, ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(240566);
    p.h(paramContext, "context");
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(240566);
      return;
    }
    Log.i("MicroMsg.ScanServiceImpl", "startScanGoods");
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 12);
    localIntent.putExtra("key_scan_request", (Parcelable)paramScanGoodsRequest);
    localIntent.setClass(paramContext, BaseScanUI.class);
    paramScanGoodsRequest = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramScanGoodsRequest.axQ(), "com/tencent/mm/plugin/scanner/service/ScanServiceImpl", "startScanGoods", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramScanGoodsRequest.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/scanner/service/ScanServiceImpl", "startScanGoods", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(240566);
  }
  
  public final void a(Context paramContext, ScanGoodsRequest paramScanGoodsRequest, int paramInt)
  {
    AppMethodBeat.i(240567);
    p.h(paramContext, "context");
    Log.i("MicroMsg.ScanServiceImpl", "startScanGoodsForResult requestCode: %d", new Object[] { Integer.valueOf(paramInt) });
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 12);
    localIntent.putExtra("key_scan_request", (Parcelable)paramScanGoodsRequest);
    com.tencent.mm.br.c.a(paramContext, "scanner", ".ui.BaseScanUI", localIntent, paramInt, false);
    AppMethodBeat.o(240567);
  }
  
  public final long b(e parame, g paramg)
  {
    AppMethodBeat.i(240569);
    if (parame == null)
    {
      AppMethodBeat.o(240569);
      return 0L;
    }
    parame.CAT = 3;
    if (parame.sessionId == 0L) {
      parame.sessionId = System.currentTimeMillis();
    }
    if (this.CIY == null) {
      this.CIY = new com.tencent.mm.plugin.scanner.model.c();
    }
    paramg = (g)new c(paramg);
    com.tencent.mm.plugin.scanner.model.c localc = this.CIY;
    if (localc != null) {
      localc.a(parame.sessionId, parame, paramg);
    }
    long l = parame.sessionId;
    AppMethodBeat.o(240569);
    return l;
  }
  
  public final long c(e parame, g paramg)
  {
    AppMethodBeat.i(240572);
    if (parame == null)
    {
      AppMethodBeat.o(240572);
      return 0L;
    }
    parame.CAT = 2;
    if (parame.sessionId == 0L) {
      parame.sessionId = System.currentTimeMillis();
    }
    if (this.CIY == null) {
      this.CIY = new com.tencent.mm.plugin.scanner.model.c();
    }
    paramg = (g)new b(paramg);
    com.tencent.mm.plugin.scanner.model.c localc = this.CIY;
    if (localc != null) {
      localc.a(parame.sessionId, parame, paramg);
    }
    long l = parame.sessionId;
    AppMethodBeat.o(240572);
    return l;
  }
  
  public final com.tencent.mm.plugin.scanner.api.a.a gT(Context paramContext)
  {
    AppMethodBeat.i(240575);
    p.h(paramContext, "context");
    paramContext = (com.tencent.mm.plugin.scanner.api.a.a)new com.tencent.mm.plugin.scanner.e.b(paramContext);
    AppMethodBeat.o(240575);
    return paramContext;
  }
  
  public final boolean gy(List<Float> paramList)
  {
    AppMethodBeat.i(240574);
    if (paramList == null)
    {
      AppMethodBeat.o(240574);
      return false;
    }
    if ((com.tencent.mm.plugin.scanner.c.a.ePI()) && (i.gx(paramList)))
    {
      AppMethodBeat.o(240574);
      return true;
    }
    AppMethodBeat.o(240574);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "session", "", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onCallback"})
  static final class b
    implements g
  {
    b(g paramg) {}
    
    public final void a(long paramLong, f paramf)
    {
      AppMethodBeat.i(240561);
      p.h(paramf, "result");
      Log.i("MicroMsg.ScanServiceImpl", "alvinluo previewImage onCallback success: %b, imagePath: %s, reqKey: %s, jumpType: %d", new Object[] { Boolean.valueOf(paramf.success), paramf.imagePath, paramf.dDL, Integer.valueOf(paramf.jumpType) });
      g localg = this.CJa;
      if (localg != null)
      {
        localg.a(paramLong, paramf);
        AppMethodBeat.o(240561);
        return;
      }
      AppMethodBeat.o(240561);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "session", "", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onCallback"})
  static final class c
    implements g
  {
    c(g paramg) {}
    
    public final void a(long paramLong, f paramf)
    {
      AppMethodBeat.i(240563);
      p.h(paramf, "result");
      Log.i("MicroMsg.ScanServiceImpl", "alvinluo uploadImageForOcr onCallback success: %b, imagePath: %s, reqKey: %s, jumpType: %d", new Object[] { Boolean.valueOf(paramf.success), paramf.imagePath, paramf.dDL, Integer.valueOf(paramf.jumpType) });
      g localg = this.CJa;
      if (localg != null)
      {
        localg.a(paramLong, paramf);
        AppMethodBeat.o(240563);
        return;
      }
      AppMethodBeat.o(240563);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "session", "", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onCallback"})
  static final class d
    implements g
  {
    d(g paramg) {}
    
    public final void a(long paramLong, f paramf)
    {
      AppMethodBeat.i(240565);
      p.h(paramf, "result");
      Log.i("MicroMsg.ScanServiceImpl", "alvinluo uploadImage onCallback success: %b, imagePath: %s, reqKey: %s, jumpType: %d", new Object[] { Boolean.valueOf(paramf.success), paramf.imagePath, paramf.dDL, Integer.valueOf(paramf.jumpType) });
      g localg = this.CJa;
      if (localg != null)
      {
        localg.a(paramLong, paramf);
        AppMethodBeat.o(240565);
        return;
      }
      AppMethodBeat.o(240565);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.g.b
 * JD-Core Version:    0.7.0.1
 */