package com.tencent.mm.plugin.scanner.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.model.c;
import com.tencent.mm.plugin.scanner.model.c.a;
import com.tencent.mm.plugin.scanner.model.x;
import com.tencent.mm.protocal.protobuf.mc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.scanlib.ui.ScanView;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/result/AiImageHandler;", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler;", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler$IResultHandleCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "scanMode", "", "scanView", "Lcom/tencent/scanlib/ui/ScanView;", "uiCallback", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler$ResultHandlerUICallback;", "scanCallback", "Lcom/tencent/mm/plugin/scanner/result/AiImageHandler$AiScanResultCallback;", "(ILcom/tencent/scanlib/ui/ScanView;Lcom/tencent/mm/plugin/scanner/result/ResultHandler$ResultHandlerUICallback;Lcom/tencent/mm/plugin/scanner/result/AiImageHandler$AiScanResultCallback;)V", "captureImageUploader", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader;", "galleryImageUploader", "locationInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "scanResultCallback", "uploadCallback", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;", "cancelResult", "", "session", "", "destroy", "finishResult", "success", "", "getSource", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "handleResult", "result", "Landroid/os/Bundle;", "notifyEvent", "eventId", "data", "onSceneEnd", "errType", "errCode", "errMsg", "", "setLocationInfo", "location", "AiScanResultCallback", "Companion", "plugin-scan_release"})
public final class a
  extends e
  implements f, e.a
{
  public static final a.b yEX;
  private final a yET;
  private final c.a yEU;
  public c yEV;
  public c yEW;
  public mc yzP;
  
  static
  {
    AppMethodBeat.i(52249);
    yEX = new a.b((byte)0);
    AppMethodBeat.o(52249);
  }
  
  public a(int paramInt, ScanView paramScanView, e.b paramb, a parama)
  {
    AppMethodBeat.i(52248);
    this.mode = paramInt;
    this.yFe = paramScanView;
    this.yFf = paramb;
    this.context = paramScanView.getContext();
    this.yET = parama;
    this.yEU = ((c.a)new c.a()
    {
      public final void a(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(161977);
        a.a(this.yEY).b(paramAnonymousInt1, paramAnonymousLong, paramAnonymousInt2, paramAnonymousString);
        AppMethodBeat.o(161977);
      }
      
      public final void a(x paramAnonymousx)
      {
        AppMethodBeat.i(52240);
        p.h(paramAnonymousx, "result");
        a.a(this.yEY).b(paramAnonymousx);
        AppMethodBeat.o(52240);
      }
      
      public final void av(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(189627);
        a.a(this.yEY).ax(paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(189627);
      }
      
      public final void dOh()
      {
        AppMethodBeat.i(52242);
        ae.e("MicroMsg.AiImageHandler", "alvinluo onUploadError errCode: %d", new Object[] { Integer.valueOf(2) });
        this.yEY.t(2, null);
        AppMethodBeat.o(52242);
      }
    });
    g.ajj().a(2580, (f)this);
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
    c localc;
    if (i == 1)
    {
      if (this.yEW == null) {
        this.yEW = new c(i, this.yEU);
      }
      localc = this.yEW;
      if (localc != null) {
        localc.yzP = this.yzP;
      }
      localc = this.yEW;
      if (localc != null)
      {
        localc.c(paramLong, paramBundle);
        AppMethodBeat.o(52243);
        return;
      }
      AppMethodBeat.o(52243);
      return;
    }
    if (i == 2)
    {
      if (this.yEV == null) {
        this.yEV = new c(i, this.yEU);
      }
      localc = this.yEW;
      if (localc != null) {
        localc.yzP = null;
      }
      localc = this.yEV;
      if (localc != null)
      {
        localc.c(paramLong, paramBundle);
        AppMethodBeat.o(52243);
        return;
      }
    }
    AppMethodBeat.o(52243);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(52247);
    g.ajj().b(2580, (f)this);
    if (this.yEV != null) {
      c.release();
    }
    if (this.yEW != null) {
      c.release();
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
      ae.i("MicroMsg.AiImageHandler", "alvinluo AiScanImage onSceneEnd errType %d, errCode %d, errMsg %s, scene type: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, localObject });
      if (paramn == null) {
        break label127;
      }
      if (paramn.getType() != 2580) {
        break label178;
      }
      if (!(paramn instanceof com.tencent.mm.plugin.scanner.model.e)) {
        break label133;
      }
      i = ((com.tencent.mm.plugin.scanner.model.e)paramn).doj;
    }
    for (;;)
    {
      if (i == 1)
      {
        localObject = this.yEW;
        if (localObject != null)
        {
          ((c)localObject).onSceneEnd(paramInt1, paramInt2, paramString, paramn);
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
      localObject = this.yEV;
      if (localObject != null)
      {
        ((c)localObject).onSceneEnd(paramInt1, paramInt2, paramString, paramn);
        AppMethodBeat.o(52245);
        return;
      }
    }
    label178:
    AppMethodBeat.o(52245);
  }
  
  public final void t(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(52246);
    ae.i("MicroMsg.AiImageHandler", "notify Event: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(52246);
      return;
      AppMethodBeat.o(52246);
      return;
      this.yFe.onResume();
      AppMethodBeat.o(52246);
      return;
      this.yFf.bXx();
      AppMethodBeat.o(52246);
      return;
      this.yFe.onPause();
    }
  }
  
  public final void z(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(161978);
    this.yzP = null;
    c localc = this.yEW;
    if (localc != null) {
      localc.z(paramLong, paramBoolean);
    }
    localc = this.yEV;
    if (localc != null)
    {
      localc.z(paramLong, paramBoolean);
      AppMethodBeat.o(161978);
      return;
    }
    AppMethodBeat.o(161978);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/result/AiImageHandler$AiScanResultCallback;", "", "notifyScanEvent", "", "source", "", "session", "", "event", "onScanResultFailed", "errCode", "errMsg", "", "onScanResultSuccess", "result", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "plugin-scan_release"})
  public static abstract interface a
  {
    public abstract void ax(int paramInt, long paramLong);
    
    public abstract void b(int paramInt1, long paramLong, int paramInt2, String paramString);
    
    public abstract void b(x paramx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.d.a
 * JD-Core Version:    0.7.0.1
 */