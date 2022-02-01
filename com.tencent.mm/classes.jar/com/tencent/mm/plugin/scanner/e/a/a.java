package com.tencent.mm.plugin.scanner.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.aq.b;
import com.tencent.mm.plugin.scanner.api.g;
import com.tencent.mm.plugin.scanner.e.k.a;
import com.tencent.mm.protocal.protobuf.mi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/image/uploader/AiImageCDNUploader;", "Lcom/tencent/mm/plugin/scanner/image/uploader/BaseAiImageUploader;", "()V", "TAG", "", "cdnUploadingMediaIdList", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "cancelUploadImage", "", "session", "doUploadImage", "requestWrapper", "Lcom/tencent/mm/plugin/scanner/image/uploader/AiImageUploader$AiImageUploadRequestWrapper;", "resultCallback", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResultCallback;", "release", "uploadImage", "plugin-scan_release"})
public final class a
  extends e
{
  private static final HashMap<Long, String> IJQ;
  public static final a IJR;
  
  static
  {
    AppMethodBeat.i(222338);
    IJR = new a();
    IJQ = new HashMap();
    AppMethodBeat.o(222338);
  }
  
  public final void PL(long paramLong)
  {
    AppMethodBeat.i(222332);
    Log.d("MicroMsg.AiImageCDNUploader", "cancelUploadImage-cdn session: ".concat(String.valueOf(paramLong)));
    String str = (String)IJQ.remove(Long.valueOf(paramLong));
    if (str != null)
    {
      com.tencent.mm.aq.f.bkg().Vy(str);
      AppMethodBeat.o(222332);
      return;
    }
    AppMethodBeat.o(222332);
  }
  
  public final void a(c.a parama, final g paramg)
  {
    AppMethodBeat.i(222325);
    p.k(parama, "requestWrapper");
    p.k(paramg, "resultCallback");
    com.tencent.e.h.ZvG.be((Runnable)new b(parama, paramg));
    AppMethodBeat.o(222325);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/image/uploader/AiImageCDNUploader$doUploadImage$1", "Lcom/tencent/mm/plugin/scanner/image/IAiScanImageCDNStrategy$GetCDNInfoCallback;", "onCDNUploadStart", "", "mediaId", "", "onError", "errType", "", "errCode", "errMsg", "onGetCDNInfoResult", "cdnList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/BizAiScanCdnImg;", "Lkotlin/collections/ArrayList;", "plugin-scan_release"})
  public static final class a
    implements k.a
  {
    a(long paramLong, com.tencent.mm.plugin.scanner.api.e parame, g paramg, c.a parama) {}
    
    public final void aXd(final String paramString)
    {
      AppMethodBeat.i(222752);
      p.k(paramString, "mediaId");
      com.tencent.e.h.ZvG.bc((Runnable)new a(this, paramString));
      AppMethodBeat.o(222752);
    }
    
    public final void aZ(ArrayList<mi> paramArrayList)
    {
      AppMethodBeat.i(222749);
      p.k(paramArrayList, "cdnList");
      Log.i("MicroMsg.AiImageCDNUploader", "alvinuo uploadImage-cdn onGetCDNInfoResult list size: %s", new Object[] { Integer.valueOf(paramArrayList.size()) });
      Iterator localIterator = ((Iterable)paramArrayList).iterator();
      while (localIterator.hasNext())
      {
        mi localmi = (mi)localIterator.next();
        com.tencent.mm.plugin.scanner.e.f localf = com.tencent.mm.plugin.scanner.e.f.IJD;
        Log.v("MicroMsg.AiImageCDNUploader", "alvinluo uploadImage-cdn upload cdn info: %s", new Object[] { com.tencent.mm.plugin.scanner.e.f.a(localmi) });
      }
      switch (this.IJv.IGy)
      {
      case 2: 
      default: 
        paramArrayList = null;
      }
      for (;;)
      {
        if (paramArrayList != null)
        {
          this.IJT.IJX = paramArrayList.hashCode();
          com.tencent.mm.kernel.h.aGY().b(paramArrayList);
        }
        com.tencent.e.h.ZvG.bc((Runnable)new c(this));
        AppMethodBeat.o(222749);
        return;
        paramArrayList = (q)new com.tencent.mm.plugin.scanner.model.f(null, this.IJu, this.IJv.type, this.IJv.mode, this.IJv.IGz, this.IJv.IGA, this.IJv.IGB, paramArrayList);
        continue;
        paramArrayList = (q)new com.tencent.mm.plugin.scanner.f.i(null, this.IJv.sessionId, this.IJv.source, paramArrayList, 48);
      }
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(222743);
      p.k(paramString, "errMsg");
      Log.e("MicroMsg.AiImageCDNUploader", "alvinuo uploadImage-cdn onError %s %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      a locala = a.IJR;
      a.a(this.IJu, this.IJv.IGy, paramInt1, paramInt2, paramString, this.IJS);
      com.tencent.e.h.ZvG.bc((Runnable)new b(this));
      AppMethodBeat.o(222743);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.a parama, String paramString) {}
      
      public final void run()
      {
        AppMethodBeat.i(218959);
        a locala = a.IJR;
        ((Map)a.fCG()).put(Long.valueOf(this.IJU.IJu), paramString);
        AppMethodBeat.o(218959);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(218466);
        a locala = a.IJR;
        a.fCG().remove(Long.valueOf(this.IJU.IJu));
        AppMethodBeat.o(218466);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class c
      implements Runnable
    {
      c(a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(223706);
        a locala = a.IJR;
        a.fCG().remove(Long.valueOf(this.IJU.IJu));
        AppMethodBeat.o(223706);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c.a parama, g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(221851);
      a locala = a.IJR;
      a.b(this.IJT, paramg);
      AppMethodBeat.o(221851);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.a.a
 * JD-Core Version:    0.7.0.1
 */