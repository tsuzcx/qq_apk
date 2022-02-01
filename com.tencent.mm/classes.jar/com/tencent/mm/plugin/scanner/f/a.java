package com.tencent.mm.plugin.scanner.f;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.scanner.model.d;
import com.tencent.mm.plugin.scanner.model.d.a;
import com.tencent.mm.plugin.scanner.model.z;
import com.tencent.mm.protocal.protobuf.mu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.scanlib.ui.ScanView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/result/AiImageHandler;", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler;", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler$IResultHandleCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "scanMode", "", "scanView", "Lcom/tencent/scanlib/ui/ScanView;", "uiCallback", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler$ResultHandlerUICallback;", "scanCallback", "Lcom/tencent/mm/plugin/scanner/result/AiImageHandler$AiScanResultCallback;", "(ILcom/tencent/scanlib/ui/ScanView;Lcom/tencent/mm/plugin/scanner/result/ResultHandler$ResultHandlerUICallback;Lcom/tencent/mm/plugin/scanner/result/AiImageHandler$AiScanResultCallback;)V", "captureImageUploader", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader;", "galleryImageUploader", "locationInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "scanResultCallback", "uploadCallback", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;", "cancelResult", "", "session", "", "destroy", "finishResult", "success", "", "getSource", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "handleResult", "result", "Landroid/os/Bundle;", "notifyEvent", "eventId", "data", "onSceneEnd", "errType", "errCode", "errMsg", "", "setLocationInfo", "location", "AiScanResultCallback", "Companion", "plugin-scan_release"})
public final class a
  extends e
  implements i, e.a
{
  public static final a.b CIP;
  public mu CAV;
  private final a CIL;
  private final d.a CIM;
  public d CIN;
  public d CIO;
  
  static
  {
    AppMethodBeat.i(52249);
    CIP = new a.b((byte)0);
    AppMethodBeat.o(52249);
  }
  
  public a(int paramInt, ScanView paramScanView, e.b paramb, a parama)
  {
    AppMethodBeat.i(52248);
    this.mode = paramInt;
    this.CIW = paramScanView;
    this.CIX = paramb;
    this.context = paramScanView.getContext();
    this.CIL = parama;
    this.CIM = ((d.a)new d.a()
    {
      public final void a(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(161977);
        a.a(this.CIQ).b(paramAnonymousInt1, paramAnonymousLong, paramAnonymousInt2, paramAnonymousString);
        AppMethodBeat.o(161977);
      }
      
      public final void a(z paramAnonymousz)
      {
        AppMethodBeat.i(52240);
        p.h(paramAnonymousz, "result");
        a.a(this.CIQ).b(paramAnonymousz);
        AppMethodBeat.o(52240);
      }
      
      public final void aD(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(240558);
        a.a(this.CIQ).a(paramAnonymousInt, paramAnonymousLong, 1);
        AppMethodBeat.o(240558);
      }
      
      public final void ePM()
      {
        AppMethodBeat.i(52242);
        Log.e("MicroMsg.AiImageHandler", "alvinluo onUploadError errCode: %d", new Object[] { Integer.valueOf(2) });
        this.CIQ.r(2, null);
        AppMethodBeat.o(52242);
      }
    });
    com.tencent.mm.kernel.g.azz().a(2580, (i)this);
    AppMethodBeat.o(52248);
  }
  
  public final void F(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(161978);
    this.CAV = null;
    d locald = this.CIO;
    if (locald != null) {
      locald.F(paramLong, paramBoolean);
    }
    locald = this.CIN;
    if (locald != null)
    {
      locald.F(paramLong, paramBoolean);
      AppMethodBeat.o(161978);
      return;
    }
    AppMethodBeat.o(161978);
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
    d locald;
    if (i == 1)
    {
      if (this.CIO == null) {
        this.CIO = new d(i, this.CIM);
      }
      locald = this.CIO;
      if (locald != null) {
        locald.CAV = this.CAV;
      }
      locald = this.CIO;
      if (locald != null)
      {
        locald.c(paramLong, paramBundle);
        AppMethodBeat.o(52243);
        return;
      }
      AppMethodBeat.o(52243);
      return;
    }
    if (i == 2)
    {
      if (this.CIN == null) {
        this.CIN = new d(i, this.CIM);
      }
      locald = this.CIO;
      if (locald != null) {
        locald.CAV = null;
      }
      locald = this.CIN;
      if (locald != null)
      {
        locald.c(paramLong, paramBundle);
        AppMethodBeat.o(52243);
        return;
      }
    }
    AppMethodBeat.o(52243);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(52247);
    com.tencent.mm.kernel.g.azz().b(2580, (i)this);
    if (this.CIN != null) {
      d.release();
    }
    if (this.CIO != null) {
      d.release();
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
      if (!(paramq instanceof com.tencent.mm.plugin.scanner.model.g)) {
        break label133;
      }
      i = ((com.tencent.mm.plugin.scanner.model.g)paramq).source;
    }
    for (;;)
    {
      if (i == 1)
      {
        localObject = this.CIO;
        if (localObject != null)
        {
          ((d)localObject).onSceneEnd(paramInt1, paramInt2, paramString, paramq);
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
      localObject = this.CIN;
      if (localObject != null)
      {
        ((d)localObject).onSceneEnd(paramInt1, paramInt2, paramString, paramq);
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
    Log.i("MicroMsg.AiImageHandler", "notify Event: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(52246);
      return;
      AppMethodBeat.o(52246);
      return;
      this.CIW.onResume();
      AppMethodBeat.o(52246);
      return;
      this.CIX.cvn();
      AppMethodBeat.o(52246);
      return;
      this.CIW.onPause();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/result/AiImageHandler$AiScanResultCallback;", "", "notifyScanEvent", "", "source", "", "session", "", "event", "onScanResultFailed", "errCode", "errMsg", "", "onScanResultSuccess", "result", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "plugin-scan_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, long paramLong, int paramInt2);
    
    public abstract void b(int paramInt1, long paramLong, int paramInt2, String paramString);
    
    public abstract void b(z paramz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.a
 * JD-Core Version:    0.7.0.1
 */