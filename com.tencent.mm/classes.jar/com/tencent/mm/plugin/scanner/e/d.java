package com.tencent.mm.plugin.scanner.e;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.protocal.protobuf.mi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.br;
import kotlinx.coroutines.g;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/image/AiScanDefaultImageCDNStrategy;", "Lcom/tencent/mm/plugin/scanner/image/IAiScanImageCDNStrategy;", "()V", "checkImageCdnStatus", "", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "checkImageRequest", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageRequest;", "callback", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageCallback;", "getCDNImageInfoList", "getCDNInfoCallback", "Lcom/tencent/mm/plugin/scanner/image/IAiScanImageCDNStrategy$GetCDNInfoCallback;", "name", "", "Companion", "plugin-scan_release"})
public class d
  implements k
{
  public static final d.a IJA;
  
  static
  {
    AppMethodBeat.i(223494);
    IJA = new d.a((byte)0);
    AppMethodBeat.o(223494);
  }
  
  protected static void a(e parame, final f.b paramb, final f.a parama)
  {
    AppMethodBeat.i(223493);
    p.k(parame, "request");
    p.k(paramb, "checkImageRequest");
    p.k(parama, "callback");
    g.b((ak)br.abxo, null, (m)new b(parame, paramb, parama, null), 3);
    AppMethodBeat.o(223493);
  }
  
  public void a(e parame, k.a parama)
  {
    AppMethodBeat.i(223492);
    p.k(parame, "request");
    f.b localb = new f.b(parame.sessionId, 3);
    Object localObject = parame.imagePath;
    p.j(localObject, "request.imagePath");
    localb.setImagePath((String)localObject);
    localObject = com.tencent.mm.plugin.scanner.util.f.IYY;
    localb.IJE = com.tencent.mm.plugin.scanner.util.f.aXy(parame.imagePath);
    localb.lNK = 1;
    localb.IJF = true;
    a(parame, localb, (f.a)new c(parama));
    AppMethodBeat.o(223492);
  }
  
  public String name()
  {
    return "MicroMsg.AiScanDefaultImageCDNStrategy";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    boolean pdt;
    int rdc;
    
    b(e parame, f.b paramb, f.a parama, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(221581);
      p.k(paramd, "completion");
      paramd = new b(this.IJv, paramb, parama, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(221581);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(221582);
      paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(221582);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(221575);
      Object localObject2 = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(221575);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        int i = a.adm(this.IJv.IGy);
        boolean bool = a.a(paramb.IJE, i);
        Log.i("MicroMsg.AiScanDefaultImageCDNStrategy", "alvinluo checkImageCdnStatus needCompress: %s, maxImageSize: %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
        if (!bool) {
          break label374;
        }
        localObject1 = a.IJc;
        localObject1 = paramb.imagePath;
        this.L$0 = paramObject;
        this.rdc = i;
        this.pdt = bool;
        this.label = 1;
        localObject1 = a.b((String)localObject1, i, this);
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(221575);
          return localObject2;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      localObject2 = (a.a)paramObject;
      if (localObject2 != null) {}
      for (paramObject = ((a.a)localObject2).IJd; (localObject2 == null) || (!u.agG(paramObject)); paramObject = null)
      {
        paramObject = parama;
        localObject1 = new f.c();
        ((f.c)localObject1).errType = 3;
        ((f.c)localObject1).errCode = 101;
        ((f.c)localObject1).setErrMsg("checkImageCdnStatus compress image failed");
        paramObject.a((f.c)localObject1);
        paramObject = x.aazN;
        AppMethodBeat.o(221575);
        return paramObject;
      }
      if (paramb.IJE == null) {
        paramb.IJE = new Point();
      }
      paramObject = paramb.IJE;
      if (paramObject != null) {
        paramObject.set(((a.a)localObject2).IJe, ((a.a)localObject2).IJf);
      }
      f.b localb = paramb;
      Object localObject1 = ((a.a)localObject2).IJd;
      paramObject = localObject1;
      if (localObject1 == null) {
        paramObject = "";
      }
      localb.setImagePath(paramObject);
      this.IJv.imagePath = ((a.a)localObject2).IJd;
      paramb.IJF = true;
      paramb.lNK = 1;
      label374:
      f.a(paramb, parama);
      paramObject = x.aazN;
      AppMethodBeat.o(221575);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/image/AiScanDefaultImageCDNStrategy$getCDNImageInfoList$1", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageCallback;", "onCDNStartUpload", "", "mediaId", "", "onCheckResult", "checkImageResult", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageResult;", "plugin-scan_release"})
  public static final class c
    implements f.a
  {
    c(k.a parama) {}
    
    public final void a(f.c paramc)
    {
      Object localObject2 = null;
      AppMethodBeat.i(218479);
      p.k(paramc, "checkImageResult");
      int i = paramc.errType;
      int j = paramc.errCode;
      Object localObject1 = paramc.IJI;
      Object localObject3;
      mi localmi;
      if (localObject1 != null)
      {
        localObject3 = f.IJD;
        localObject1 = f.a((mi)localObject1);
        Log.i("MicroMsg.AiScanDefaultImageCDNStrategy", "alvinluo getCDNImageInfoList-default errType: %s, errCode: %s: reUploadInfo: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject1 });
        if ((paramc.errType != 0) || (paramc.errCode != 0)) {
          break label261;
        }
        if (paramc.IJI == null) {
          break label228;
        }
        localObject3 = new ArrayList();
        localmi = new mi();
        localmi.RSa = 1;
        localmi.RRX = 3;
        localObject1 = paramc.IJI;
        if (localObject1 == null) {
          break label216;
        }
      }
      label216:
      for (localObject1 = ((mi)localObject1).RRY;; localObject1 = null)
      {
        localmi.RRY = ((String)localObject1);
        localObject1 = paramc.IJI;
        paramc = localObject2;
        if (localObject1 != null) {
          paramc = ((mi)localObject1).RRZ;
        }
        localmi.RRZ = paramc;
        ((ArrayList)localObject3).add(localmi);
        paramc = this.IJy;
        if (paramc == null) {
          break label222;
        }
        paramc.aZ((ArrayList)localObject3);
        AppMethodBeat.o(218479);
        return;
        localObject1 = null;
        break;
      }
      label222:
      AppMethodBeat.o(218479);
      return;
      label228:
      paramc = this.IJy;
      if (paramc != null)
      {
        paramc.i(4, 403, "checkImageCdnStatus re-upload cdn error");
        AppMethodBeat.o(218479);
        return;
      }
      AppMethodBeat.o(218479);
      return;
      label261:
      localObject1 = this.IJy;
      if (localObject1 != null)
      {
        ((k.a)localObject1).i(paramc.errType, paramc.errCode, paramc.errMsg);
        AppMethodBeat.o(218479);
        return;
      }
      AppMethodBeat.o(218479);
    }
    
    public final void aXc(String paramString)
    {
      AppMethodBeat.i(218480);
      p.k(paramString, "mediaId");
      k.a locala = this.IJy;
      if (locala != null)
      {
        locala.aXd(paramString);
        AppMethodBeat.o(218480);
        return;
      }
      AppMethodBeat.o(218480);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.d
 * JD-Core Version:    0.7.0.1
 */