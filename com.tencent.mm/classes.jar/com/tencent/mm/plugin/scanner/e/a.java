package com.tencent.mm.plugin.scanner.e;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.api.c;
import com.tencent.mm.plugin.scanner.model.b.b;
import com.tencent.mm.plugin.scanner.model.b.f;
import com.tencent.mm.plugin.scanner.model.z;
import com.tencent.mm.plugin.scanner.ui.BaseScanUI;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/service/ScanServiceImpl;", "Lcom/tencent/mm/plugin/scanner/api/IScanService;", "()V", "imageUploader", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageSceneUploader;", "cancelUploadImage", "", "session", "", "getSearchImagePath", "", "msgId", "preloadResource", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "startScanGoods", "context", "Landroid/content/Context;", "startScanGoodsForResult", "requestCode", "", "uploadImageForSearch", "Lcom/tencent/mm/plugin/scanner/api/ScanUploadImageRequest;", "callback", "Lcom/tencent/mm/plugin/scanner/api/ScanUploadImageResultCallback;", "Companion", "plugin-scan_release"})
public final class a
  implements com.tencent.mm.plugin.scanner.api.a
{
  public static final a.a ypi;
  private com.tencent.mm.plugin.scanner.model.b yph;
  
  static
  {
    AppMethodBeat.i(186344);
    ypi = new a.a((byte)0);
    AppMethodBeat.o(186344);
  }
  
  public final long a(com.tencent.mm.plugin.scanner.api.b paramb, final com.tencent.mm.plugin.scanner.api.d paramd)
  {
    AppMethodBeat.i(186341);
    if (this.yph == null) {
      this.yph = new com.tencent.mm.plugin.scanner.model.b();
    }
    long l = System.currentTimeMillis();
    Object localObject = (com.tencent.mm.plugin.scanner.api.d)new b(paramb, paramd);
    paramd = this.yph;
    if (paramd != null)
    {
      p.h(localObject, "callback");
      ((Map)paramd.gpP).put(Long.valueOf(l), localObject);
      localObject = (Map)paramd.kIV;
      b.b localb = new b.b();
      localb.yml = paramb;
      ((Map)localObject).put(Long.valueOf(l), localb);
      h.LTJ.aT((Runnable)new b.f(paramd, l));
    }
    AppMethodBeat.o(186341);
    return l;
  }
  
  public final void a(Context paramContext, ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(186339);
    p.h(paramContext, "context");
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(186339);
      return;
    }
    ad.i("MicroMsg.ScanServiceImpl", "startScanGoods");
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 12);
    localIntent.putExtra("key_scan_request", (Parcelable)paramScanGoodsRequest);
    localIntent.setClass(paramContext, BaseScanUI.class);
    paramScanGoodsRequest = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramScanGoodsRequest.ahp(), "com/tencent/mm/plugin/scanner/service/ScanServiceImpl", "startScanGoods", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramScanGoodsRequest.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/scanner/service/ScanServiceImpl", "startScanGoods", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(186339);
  }
  
  public final void a(Context paramContext, ScanGoodsRequest paramScanGoodsRequest, int paramInt)
  {
    AppMethodBeat.i(186340);
    p.h(paramContext, "context");
    ad.i("MicroMsg.ScanServiceImpl", "startScanGoodsForResult requestCode: %d", new Object[] { Integer.valueOf(paramInt) });
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 12);
    localIntent.putExtra("key_scan_request", (Parcelable)paramScanGoodsRequest);
    com.tencent.mm.bs.d.a(paramContext, "scanner", ".ui.BaseScanUI", localIntent, paramInt, false);
    AppMethodBeat.o(186340);
  }
  
  public final void yT(long paramLong)
  {
    AppMethodBeat.i(186342);
    Object localObject = this.yph;
    if (localObject != null)
    {
      ad.i("MicroMsg.AiScanImageSceneUploader", "cancel");
      ((com.tencent.mm.plugin.scanner.model.b)localObject).gpP.remove(Long.valueOf(paramLong));
      localObject = (b.b)((com.tencent.mm.plugin.scanner.model.b)localObject).kIV.remove(Long.valueOf(paramLong));
      if (localObject != null)
      {
        int i = ((b.b)localObject).ymm;
        g.aiU().cancel(i);
        AppMethodBeat.o(186342);
        return;
      }
      AppMethodBeat.o(186342);
      return;
    }
    AppMethodBeat.o(186342);
  }
  
  public final String yU(long paramLong)
  {
    AppMethodBeat.i(186343);
    Object localObject = z.ynN;
    localObject = z.yY(paramLong);
    AppMethodBeat.o(186343);
    return localObject;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "session", "", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanUploadImageResult;", "onUploadCallback"})
  static final class b
    implements com.tencent.mm.plugin.scanner.api.d
  {
    b(com.tencent.mm.plugin.scanner.api.b paramb, com.tencent.mm.plugin.scanner.api.d paramd) {}
    
    public final void a(long paramLong, c paramc)
    {
      AppMethodBeat.i(186338);
      p.h(paramc, "result");
      boolean bool = paramc.success;
      Object localObject = this.ymo;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.scanner.api.b)localObject).imagePath;; localObject = null)
      {
        ad.i("MicroMsg.ScanServiceImpl", "alvinluo onUploadCallback success: %b, imagePath: %s, reqKey: %s, jumpType: %d", new Object[] { Boolean.valueOf(bool), localObject, paramc.dlu, Integer.valueOf(paramc.jumpType) });
        localObject = paramd;
        if (localObject == null) {
          break;
        }
        ((com.tencent.mm.plugin.scanner.api.d)localObject).a(paramLong, paramc);
        AppMethodBeat.o(186338);
        return;
      }
      AppMethodBeat.o(186338);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.a
 * JD-Core Version:    0.7.0.1
 */