package com.tencent.mm.plugin.scanner.g;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.scanner.model.ae;
import com.tencent.mm.plugin.scanner.model.b;
import com.tencent.mm.plugin.scanner.model.b.a;
import com.tencent.mm.plugin.scanner.model.i;
import com.tencent.mm.protocal.protobuf.nq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.scanlib.ui.ScanView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/result/AiImageHandler;", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler;", "Landroid/os/Bundle;", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler$IResultHandleCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "scanMode", "", "scanView", "Lcom/tencent/scanlib/ui/ScanView;", "uiCallback", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler$ResultHandlerUICallback;", "scanCallback", "Lcom/tencent/mm/plugin/scanner/result/AiImageHandler$AiScanResultCallback;", "(ILcom/tencent/scanlib/ui/ScanView;Lcom/tencent/mm/plugin/scanner/result/ResultHandler$ResultHandlerUICallback;Lcom/tencent/mm/plugin/scanner/result/AiImageHandler$AiScanResultCallback;)V", "captureImageUploader", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader;", "galleryImageUploader", "locationInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "scanResultCallback", "uploadCallback", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;", "cancelResult", "", "session", "", "destroy", "finishResult", "success", "", "getSource", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "handleResult", "result", "notifyEvent", "eventId", "data", "onSceneEnd", "errType", "errCode", "errMsg", "", "setLocationInfo", "location", "AiScanResultCallback", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends f<Bundle>
  implements com.tencent.mm.am.h, f.a
{
  public static final a.b OVn;
  private nq OMI;
  private a OVo;
  private final b.a OVp;
  public b OVq;
  public b OVr;
  
  static
  {
    AppMethodBeat.i(52249);
    OVn = new a.b((byte)0);
    AppMethodBeat.o(52249);
  }
  
  public a(int paramInt, ScanView paramScanView, f.b paramb, a parama)
  {
    AppMethodBeat.i(52248);
    this.mode = paramInt;
    this.OVy = paramScanView;
    this.OVz = paramb;
    this.context = paramScanView.getContext();
    this.OVo = parama;
    this.OVp = ((b.a)new b.a()
    {
      public final void a(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(161977);
        a.a locala = a.a(this.OVs);
        if (locala != null) {
          locala.b(paramAnonymousInt1, paramAnonymousLong, paramAnonymousInt2, paramAnonymousString);
        }
        AppMethodBeat.o(161977);
      }
      
      public final void a(ae paramAnonymousae)
      {
        AppMethodBeat.i(52240);
        kotlin.g.b.s.u(paramAnonymousae, "result");
        a.a locala = a.a(this.OVs);
        if (locala != null) {
          locala.b(paramAnonymousae);
        }
        AppMethodBeat.o(52240);
      }
      
      public final void aW(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(313561);
        a.a locala = a.a(this.OVs);
        if (locala != null) {
          locala.a(paramAnonymousInt, paramAnonymousLong, 1);
        }
        AppMethodBeat.o(313561);
      }
      
      public final void gQI()
      {
        AppMethodBeat.i(52242);
        Log.e("MicroMsg.AiImageHandler", "alvinluo onUploadError errCode: %d", new Object[] { Integer.valueOf(2) });
        this.OVs.w(2, null);
        AppMethodBeat.o(52242);
      }
    });
    com.tencent.mm.kernel.h.aZW().a(2580, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(52248);
  }
  
  public final void Q(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(161978);
    b localb = this.OVr;
    if (localb != null) {
      localb.Q(paramLong, paramBoolean);
    }
    localb = this.OVq;
    if (localb != null) {
      localb.Q(paramLong, paramBoolean);
    }
    AppMethodBeat.o(161978);
  }
  
  public final void a(nq paramnq)
  {
    this.OMI = paramnq;
    paramnq = this.OVr;
    if (paramnq != null) {
      paramnq.OMI = this.OMI;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(52247);
    this.context = null;
    this.OVy = null;
    this.OVz = null;
    this.OVo = null;
    this.OMI = null;
    com.tencent.mm.kernel.h.aZW().b(2580, (com.tencent.mm.am.h)this);
    b localb = this.OVq;
    if (localb != null) {
      localb.release();
    }
    localb = this.OVr;
    if (localb != null) {
      localb.release();
    }
    AppMethodBeat.o(52247);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(52245);
    Object localObject;
    int i;
    if (paramp == null)
    {
      localObject = null;
      Log.i("MicroMsg.AiImageHandler", "alvinluo AiScanImage onSceneEnd errType %d, errCode %d, errMsg %s, scene type: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, localObject });
      if ((paramp == null) || (paramp.getType() != 2580)) {
        break label131;
      }
      i = 1;
      label66:
      if (i != 0)
      {
        if (!(paramp instanceof i)) {
          break label137;
        }
        i = ((i)paramp).source;
        label89:
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(52245);
      return;
      localObject = Integer.valueOf(paramp.getType());
      break;
      label131:
      i = 0;
      break label66;
      label137:
      i = -1;
      break label89;
      localObject = this.OVr;
      if (localObject != null)
      {
        ((b)localObject).onSceneEnd(paramInt1, paramInt2, paramString, paramp);
        AppMethodBeat.o(52245);
        return;
        localObject = this.OVq;
        if (localObject != null) {
          ((b)localObject).onSceneEnd(paramInt1, paramInt2, paramString, paramp);
        }
      }
    }
  }
  
  public final void w(int paramInt, Bundle paramBundle)
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
      paramBundle = this.OVy;
      if (paramBundle != null)
      {
        paramBundle.onResume();
        AppMethodBeat.o(52246);
        return;
        paramBundle = this.OVz;
        if (paramBundle != null)
        {
          paramBundle.dmh();
          AppMethodBeat.o(52246);
          return;
          paramBundle = this.OVy;
          if (paramBundle != null) {
            paramBundle.onPause();
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/result/AiImageHandler$AiScanResultCallback;", "", "notifyScanEvent", "", "source", "", "session", "", "event", "onScanResultFailed", "errCode", "errMsg", "", "onScanResultSuccess", "result", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, long paramLong, int paramInt2);
    
    public abstract void b(int paramInt1, long paramLong, int paramInt2, String paramString);
    
    public abstract void b(ae paramae);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.g.a
 * JD-Core Version:    0.7.0.1
 */