package com.tencent.mm.plugin.scanner.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.scanner.e.f;
import com.tencent.mm.plugin.scanner.e.k.a;
import com.tencent.mm.plugin.scanner.model.j;
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/image/uploader/AiImageCDNUploader;", "Lcom/tencent/mm/plugin/scanner/image/uploader/BaseAiImageUploader;", "()V", "TAG", "", "cdnUploadingMediaIdList", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "cancelUploadImage", "", "session", "doUploadImage", "requestWrapper", "Lcom/tencent/mm/plugin/scanner/image/uploader/AiImageUploader$AiImageUploadRequestWrapper;", "resultCallback", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResultCallback;", "release", "uploadImage", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends e
{
  public static final a OQD;
  private static final HashMap<Long, String> OQE;
  
  static
  {
    AppMethodBeat.i(313623);
    OQD = new a();
    OQE = new HashMap();
    AppMethodBeat.o(313623);
  }
  
  private static final void b(final c.a parama, final com.tencent.mm.plugin.scanner.api.g paramg)
  {
    AppMethodBeat.i(313613);
    kotlin.g.b.s.u(parama, "$requestWrapper");
    kotlin.g.b.s.u(paramg, "$resultCallback");
    if (parama == null) {}
    for (com.tencent.mm.plugin.scanner.api.e locale = null;; locale = parama.OQI)
    {
      if (locale != null)
      {
        locale = parama.OQI;
        kotlin.g.b.s.checkNotNull(locale);
        long l = locale.sessionId;
        Object localObject = com.tencent.mm.plugin.scanner.e.i.OQB;
        localObject = com.tencent.mm.plugin.scanner.e.i.ahK(locale.type);
        Log.i("MicroMsg.AiImageCDNUploader", "alvinluo uploadImage-cdn requestType: %s, strategy: %s", new Object[] { Integer.valueOf(locale.type), ((com.tencent.mm.plugin.scanner.e.k)localObject).name() });
        ((com.tencent.mm.plugin.scanner.e.k)localObject).a(locale, (k.a)new a(l, locale, paramg, parama));
      }
      AppMethodBeat.o(313613);
      return;
    }
  }
  
  public final void a(c.a parama, com.tencent.mm.plugin.scanner.api.g paramg)
  {
    AppMethodBeat.i(313640);
    kotlin.g.b.s.u(parama, "requestWrapper");
    kotlin.g.b.s.u(paramg, "resultCallback");
    com.tencent.threadpool.h.ahAA.bm(new a..ExternalSyntheticLambda0(parama, paramg));
    AppMethodBeat.o(313640);
  }
  
  public final void tN(long paramLong)
  {
    AppMethodBeat.i(313648);
    Log.d("MicroMsg.AiImageCDNUploader", kotlin.g.b.s.X("cancelUploadImage-cdn session: ", Long.valueOf(paramLong)));
    String str = (String)OQE.remove(Long.valueOf(paramLong));
    if (str != null) {
      com.tencent.mm.modelcdntran.k.bHW().Ny(str);
    }
    AppMethodBeat.o(313648);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/image/uploader/AiImageCDNUploader$doUploadImage$1", "Lcom/tencent/mm/plugin/scanner/image/IAiScanImageCDNStrategy$GetCDNInfoCallback;", "onCDNUploadStart", "", "mediaId", "", "onError", "errType", "", "errCode", "errMsg", "onGetCDNInfoResult", "cdnList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/BizAiScanCdnImg;", "Lkotlin/collections/ArrayList;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements k.a
  {
    a(long paramLong, com.tencent.mm.plugin.scanner.api.e parame, com.tencent.mm.plugin.scanner.api.g paramg, c.a parama) {}
    
    private static final void ae(long paramLong, String paramString)
    {
      AppMethodBeat.i(313621);
      kotlin.g.b.s.u(paramString, "$mediaId");
      ((Map)a.gQH()).put(Long.valueOf(paramLong), paramString);
      AppMethodBeat.o(313621);
    }
    
    private static final void tT(long paramLong)
    {
      AppMethodBeat.i(313609);
      a.gQH().remove(Long.valueOf(paramLong));
      AppMethodBeat.o(313609);
    }
    
    private static final void tU(long paramLong)
    {
      AppMethodBeat.i(313615);
      a.gQH().remove(Long.valueOf(paramLong));
      AppMethodBeat.o(313615);
    }
    
    public final void aUE(String paramString)
    {
      AppMethodBeat.i(313672);
      kotlin.g.b.s.u(paramString, "mediaId");
      com.tencent.threadpool.h.ahAA.bk(new a.a..ExternalSyntheticLambda2(this.vTZ, paramString));
      AppMethodBeat.o(313672);
    }
    
    public final void bx(ArrayList<nn> paramArrayList)
    {
      AppMethodBeat.i(313667);
      kotlin.g.b.s.u(paramArrayList, "cdnList");
      Log.i("MicroMsg.AiImageCDNUploader", "alvinuo uploadImage-cdn onGetCDNInfoResult list size: %s", new Object[] { Integer.valueOf(paramArrayList.size()) });
      Iterator localIterator = ((Iterable)paramArrayList).iterator();
      while (localIterator.hasNext())
      {
        nn localnn = (nn)localIterator.next();
        f localf = f.OQq;
        Log.v("MicroMsg.AiImageCDNUploader", "alvinluo uploadImage-cdn upload cdn info: %s", new Object[] { f.a(localnn) });
      }
      switch (paramg.OMG)
      {
      case 2: 
      default: 
        paramArrayList = null;
      }
      for (;;)
      {
        if (paramArrayList != null)
        {
          this.OQG.OQJ = paramArrayList.hashCode();
          com.tencent.mm.kernel.h.aZW().a(paramArrayList, 0);
        }
        com.tencent.threadpool.h.ahAA.bk(new a.a..ExternalSyntheticLambda1(this.vTZ));
        AppMethodBeat.o(313667);
        return;
        paramArrayList = (p)new j(null, this.vTZ, paramg.type, paramg.mode, paramg.OMH, paramg.OMI, paramg.OMJ, paramArrayList);
        continue;
        paramArrayList = (p)new com.tencent.mm.plugin.scanner.f.i(null, paramg.sessionId, paramg.source, paramArrayList, 48);
      }
    }
    
    public final void j(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(313652);
      kotlin.g.b.s.u(paramString, "errMsg");
      Log.e("MicroMsg.AiImageCDNUploader", "alvinuo uploadImage-cdn onError %s %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      a locala = a.OQD;
      a.a(this.vTZ, paramg.OMG, paramInt1, paramInt2, paramString, parama);
      com.tencent.threadpool.h.ahAA.bk(new a.a..ExternalSyntheticLambda0(this.vTZ));
      AppMethodBeat.o(313652);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.a.a
 * JD-Core Version:    0.7.0.1
 */