package com.tencent.mm.plugin.scanner.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.scanner.model.b;
import com.tencent.mm.plugin.scanner.model.b.a;
import com.tencent.mm.plugin.scanner.model.d;
import com.tencent.mm.plugin.scanner.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.scanlib.ui.ScanView;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/result/AiImageHandler;", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler;", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler$IResultHandleCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "scanMode", "", "scanView", "Lcom/tencent/scanlib/ui/ScanView;", "uiCallback", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler$ResultHandlerUICallback;", "scanCallback", "Lcom/tencent/mm/plugin/scanner/result/AiImageHandler$AiScanResultCallback;", "(ILcom/tencent/scanlib/ui/ScanView;Lcom/tencent/mm/plugin/scanner/result/ResultHandler$ResultHandlerUICallback;Lcom/tencent/mm/plugin/scanner/result/AiImageHandler$AiScanResultCallback;)V", "captureImageUploader", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader;", "galleryImageUploader", "scanResultCallback", "uploadCallback", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;", "cancelResult", "", "session", "", "destroy", "finishResult", "success", "", "getSource", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "handleResult", "result", "Landroid/os/Bundle;", "notifyEvent", "eventId", "data", "onSceneEnd", "errType", "errCode", "errMsg", "", "AiScanResultCallback", "Companion", "plugin-scan_release"})
public final class a
  extends e
  implements com.tencent.mm.al.g, e.a
{
  public static final a.b vQs;
  private final a vQo;
  private final b.a vQp;
  public b vQq;
  public b vQr;
  
  static
  {
    AppMethodBeat.i(52249);
    vQs = new a.b((byte)0);
    AppMethodBeat.o(52249);
  }
  
  public a(int paramInt, ScanView paramScanView, e.b paramb, a parama)
  {
    AppMethodBeat.i(52248);
    this.mode = paramInt;
    this.vQz = paramScanView;
    this.vQA = paramb;
    this.context = paramScanView.getContext();
    this.vQo = parama;
    this.vQp = ((b.a)new b.a()
    {
      public final void a(u paramAnonymousu)
      {
        AppMethodBeat.i(52240);
        k.h(paramAnonymousu, "result");
        a.a(this.vQt).b(paramAnonymousu);
        AppMethodBeat.o(52240);
      }
      
      public final void b(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(161977);
        a.a(this.vQt).c(paramAnonymousInt1, paramAnonymousLong, paramAnonymousInt2, paramAnonymousString);
        AppMethodBeat.o(161977);
      }
      
      public final void dlp()
      {
        AppMethodBeat.i(52242);
        ad.e("MicroMsg.AiImageHandler", "alvinluo onUploadError errCode: %d", new Object[] { Integer.valueOf(2) });
        this.vQt.r(2, null);
        AppMethodBeat.o(52242);
      }
    });
    com.tencent.mm.kernel.g.aeS().a(2580, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(52248);
  }
  
  public final void c(long paramLong, Bundle paramBundle)
  {
    AppMethodBeat.i(52243);
    if (paramBundle == null)
    {
      AppMethodBeat.o(52243);
      return;
    }
    int i = paramBundle.getInt("scan_source", 0);
    b localb;
    if (i == 1)
    {
      if (this.vQr == null) {
        this.vQr = new b(i, this.vQp);
      }
      localb = this.vQr;
      if (localb != null)
      {
        localb.c(paramLong, paramBundle);
        AppMethodBeat.o(52243);
        return;
      }
      AppMethodBeat.o(52243);
      return;
    }
    if (i == 2)
    {
      if (this.vQq == null) {
        this.vQq = new b(i, this.vQp);
      }
      localb = this.vQq;
      if (localb != null)
      {
        localb.c(paramLong, paramBundle);
        AppMethodBeat.o(52243);
        return;
      }
    }
    AppMethodBeat.o(52243);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(52247);
    com.tencent.mm.kernel.g.aeS().b(2580, (com.tencent.mm.al.g)this);
    if (this.vQq != null) {
      b.release();
    }
    if (this.vQr != null) {
      b.release();
    }
    AppMethodBeat.o(52247);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(52245);
    Object localObject;
    int i;
    if (paramn != null)
    {
      localObject = Integer.valueOf(paramn.getType());
      ad.i("MicroMsg.AiImageHandler", "alvinluo AiScanImage onSceneEnd errType %d, errCode %d, errMsg %s, scene type: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, localObject });
      if (paramn == null) {
        break label127;
      }
      if (paramn.getType() != 2580) {
        break label178;
      }
      if (!(paramn instanceof d)) {
        break label133;
      }
      i = ((d)paramn).dep;
    }
    for (;;)
    {
      if (i == 1)
      {
        localObject = this.vQr;
        if (localObject != null)
        {
          ((b)localObject).onSceneEnd(paramInt1, paramInt2, paramString, paramn);
          AppMethodBeat.o(52245);
          return;
          localObject = null;
          break;
          label127:
          AppMethodBeat.o(52245);
          return;
          label133:
          i = -1;
          continue;
        }
        AppMethodBeat.o(52245);
        return;
      }
    }
    if (i == 2)
    {
      localObject = this.vQq;
      if (localObject != null)
      {
        ((b)localObject).onSceneEnd(paramInt1, paramInt2, paramString, paramn);
        AppMethodBeat.o(52245);
        return;
      }
    }
    label178:
    AppMethodBeat.o(52245);
  }
  
  public final void r(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(52246);
    ad.i("MicroMsg.AiImageHandler", "notify Event: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(52246);
      return;
      AppMethodBeat.o(52246);
      return;
      this.vQz.onResume();
      AppMethodBeat.o(52246);
      return;
      this.vQA.bKq();
      AppMethodBeat.o(52246);
      return;
      this.vQz.onPause();
    }
  }
  
  public final void y(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(161978);
    b localb = this.vQr;
    if (localb != null) {
      localb.y(paramLong, paramBoolean);
    }
    localb = this.vQq;
    if (localb != null)
    {
      localb.y(paramLong, paramBoolean);
      AppMethodBeat.o(161978);
      return;
    }
    AppMethodBeat.o(161978);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/result/AiImageHandler$AiScanResultCallback;", "", "onScanResultFailed", "", "source", "", "session", "", "errCode", "errMsg", "", "onScanResultSuccess", "result", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "plugin-scan_release"})
  public static abstract interface a
  {
    public abstract void b(u paramu);
    
    public abstract void c(int paramInt1, long paramLong, int paramInt2, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.d.a
 * JD-Core Version:    0.7.0.1
 */