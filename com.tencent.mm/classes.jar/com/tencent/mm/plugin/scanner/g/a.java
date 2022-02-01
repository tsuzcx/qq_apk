package com.tencent.mm.plugin.scanner.g;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.scanner.model.b;
import com.tencent.mm.plugin.scanner.model.b.a;
import com.tencent.mm.plugin.scanner.model.x;
import com.tencent.mm.protocal.protobuf.ml;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.scanlib.ui.ScanView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/result/AiImageHandler;", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler;", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler$IResultHandleCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "scanMode", "", "scanView", "Lcom/tencent/scanlib/ui/ScanView;", "uiCallback", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler$ResultHandlerUICallback;", "scanCallback", "Lcom/tencent/mm/plugin/scanner/result/AiImageHandler$AiScanResultCallback;", "(ILcom/tencent/scanlib/ui/ScanView;Lcom/tencent/mm/plugin/scanner/result/ResultHandler$ResultHandlerUICallback;Lcom/tencent/mm/plugin/scanner/result/AiImageHandler$AiScanResultCallback;)V", "captureImageUploader", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader;", "galleryImageUploader", "locationInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "scanResultCallback", "uploadCallback", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;", "cancelResult", "", "session", "", "destroy", "finishResult", "success", "", "getSource", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "handleResult", "result", "Landroid/os/Bundle;", "notifyEvent", "eventId", "data", "onSceneEnd", "errType", "errCode", "errMsg", "", "setLocationInfo", "location", "AiScanResultCallback", "Companion", "plugin-scan_release"})
public final class a
  extends e
  implements i, e.a
{
  public static final a.b IOp;
  private ml IGA;
  private a IOl;
  private final b.a IOm;
  public b IOn;
  public b IOo;
  
  static
  {
    AppMethodBeat.i(52249);
    IOp = new a.b((byte)0);
    AppMethodBeat.o(52249);
  }
  
  public a(int paramInt, ScanView paramScanView, e.b paramb, a parama)
  {
    AppMethodBeat.i(52248);
    this.mode = paramInt;
    this.IOw = paramScanView;
    this.IOx = paramb;
    this.context = paramScanView.getContext();
    this.IOl = parama;
    this.IOm = ((b.a)new b.a()
    {
      public final void a(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(161977);
        a.a locala = a.a(this.IOq);
        if (locala != null)
        {
          locala.b(paramAnonymousInt1, paramAnonymousLong, paramAnonymousInt2, paramAnonymousString);
          AppMethodBeat.o(161977);
          return;
        }
        AppMethodBeat.o(161977);
      }
      
      public final void a(x paramAnonymousx)
      {
        AppMethodBeat.i(52240);
        p.k(paramAnonymousx, "result");
        a.a locala = a.a(this.IOq);
        if (locala != null)
        {
          locala.b(paramAnonymousx);
          AppMethodBeat.o(52240);
          return;
        }
        AppMethodBeat.o(52240);
      }
      
      public final void aP(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(222377);
        a.a locala = a.a(this.IOq);
        if (locala != null)
        {
          locala.a(paramAnonymousInt, paramAnonymousLong, 1);
          AppMethodBeat.o(222377);
          return;
        }
        AppMethodBeat.o(222377);
      }
      
      public final void fCH()
      {
        AppMethodBeat.i(52242);
        Log.e("MicroMsg.AiImageHandler", "alvinluo onUploadError errCode: %d", new Object[] { Integer.valueOf(2) });
        this.IOq.t(2, null);
        AppMethodBeat.o(52242);
      }
    });
    h.aGY().a(2580, (i)this);
    AppMethodBeat.o(52248);
  }
  
  public final void G(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(161978);
    b localb = this.IOo;
    if (localb != null) {
      localb.G(paramLong, paramBoolean);
    }
    localb = this.IOn;
    if (localb != null)
    {
      localb.G(paramLong, paramBoolean);
      AppMethodBeat.o(161978);
      return;
    }
    AppMethodBeat.o(161978);
  }
  
  public final void a(ml paramml)
  {
    this.IGA = paramml;
    paramml = this.IOo;
    if (paramml != null) {
      paramml.IGA = this.IGA;
    }
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
      if (this.IOo == null) {
        this.IOo = new b(i, this.IOm);
      }
      localb = this.IOo;
      if (localb != null) {
        localb.IGA = this.IGA;
      }
      localb = this.IOo;
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
      if (this.IOn == null) {
        this.IOn = new b(i, this.IOm);
      }
      localb = this.IOn;
      if (localb != null) {
        localb.IGA = null;
      }
      localb = this.IOn;
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
    this.context = null;
    this.IOw = null;
    this.IOx = null;
    this.IOl = null;
    this.IGA = null;
    h.aGY().b(2580, (i)this);
    b localb = this.IOn;
    if (localb != null) {
      localb.release();
    }
    localb = this.IOo;
    if (localb != null)
    {
      localb.release();
      AppMethodBeat.o(52247);
      return;
    }
    AppMethodBeat.o(52247);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(52245);
    Object localObject;
    int i;
    if (paramq != null)
    {
      localObject = Integer.valueOf(paramq.getType());
      Log.i("MicroMsg.AiImageHandler", "alvinluo AiScanImage onSceneEnd errType %d, errCode %d, errMsg %s, scene type: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, localObject });
      if (paramq == null) {
        break label127;
      }
      if (paramq.getType() != 2580) {
        break label178;
      }
      if (!(paramq instanceof com.tencent.mm.plugin.scanner.model.e)) {
        break label133;
      }
      i = ((com.tencent.mm.plugin.scanner.model.e)paramq).source;
    }
    for (;;)
    {
      if (i == 1)
      {
        localObject = this.IOo;
        if (localObject != null)
        {
          ((b)localObject).onSceneEnd(paramInt1, paramInt2, paramString, paramq);
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
      localObject = this.IOn;
      if (localObject != null)
      {
        ((b)localObject).onSceneEnd(paramInt1, paramInt2, paramString, paramq);
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
    Log.i("MicroMsg.AiImageHandler", "notify Event: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    do
    {
      AppMethodBeat.o(52246);
      return;
      AppMethodBeat.o(52246);
      return;
      paramBundle = this.IOw;
      if (paramBundle != null)
      {
        paramBundle.onResume();
        AppMethodBeat.o(52246);
        return;
      }
      AppMethodBeat.o(52246);
      return;
      paramBundle = this.IOx;
      if (paramBundle != null)
      {
        paramBundle.cIP();
        AppMethodBeat.o(52246);
        return;
      }
      AppMethodBeat.o(52246);
      return;
      paramBundle = this.IOw;
    } while (paramBundle == null);
    paramBundle.onPause();
    AppMethodBeat.o(52246);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/result/AiImageHandler$AiScanResultCallback;", "", "notifyScanEvent", "", "source", "", "session", "", "event", "onScanResultFailed", "errCode", "errMsg", "", "onScanResultSuccess", "result", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "plugin-scan_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, long paramLong, int paramInt2);
    
    public abstract void b(int paramInt1, long paramLong, int paramInt2, String paramString);
    
    public abstract void b(x paramx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.g.a
 * JD-Core Version:    0.7.0.1
 */