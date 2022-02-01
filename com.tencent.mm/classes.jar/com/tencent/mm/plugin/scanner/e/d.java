package com.tencent.mm.plugin.scanner.e;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.plugin.scanner.util.g;
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/image/AiScanDefaultImageCDNStrategy;", "Lcom/tencent/mm/plugin/scanner/image/IAiScanImageCDNStrategy;", "()V", "checkImageCdnStatus", "", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "checkImageRequest", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageRequest;", "callback", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageCallback;", "getCDNImageInfoList", "getCDNInfoCallback", "Lcom/tencent/mm/plugin/scanner/image/IAiScanImageCDNStrategy$GetCDNInfoCallback;", "name", "", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d
  implements k
{
  public static final d.a OQn;
  
  static
  {
    AppMethodBeat.i(313642);
    OQn = new d.a((byte)0);
    AppMethodBeat.o(313642);
  }
  
  protected static void a(e parame, final f.b paramb, final f.a parama)
  {
    AppMethodBeat.i(313633);
    s.u(parame, "request");
    s.u(paramb, "checkImageRequest");
    s.u(parama, "callback");
    j.a((aq)bu.ajwo, null, null, (m)new b(parame, paramb, parama, null), 3);
    AppMethodBeat.o(313633);
  }
  
  public void a(e parame, k.a parama)
  {
    AppMethodBeat.i(313660);
    s.u(parame, "request");
    f.b localb = new f.b(parame.sessionId, 3);
    Object localObject = parame.imagePath;
    s.s(localObject, "request.imagePath");
    localb.setImagePath((String)localObject);
    localObject = g.PiK;
    localb.OQs = g.aVg(parame.imagePath);
    localb.oGu = 1;
    localb.OQt = true;
    a(parame, localb, (f.a)new c(parama));
    AppMethodBeat.o(313660);
  }
  
  public String name()
  {
    return "MicroMsg.AiScanDefaultImageCDNStrategy";
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(e parame, f.b paramb, f.a parama, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(313583);
      paramObject = (kotlin.d.d)new b(this.OQi, paramb, parama, paramd);
      AppMethodBeat.o(313583);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(313579);
      Object localObject2 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(313579);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        int i = a.ahJ(this.OQi.OMG);
        boolean bool2 = a.a(paramb.OQs, i);
        if (bool2) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          Log.i("MicroMsg.AiScanDefaultImageCDNStrategy", "alvinluo checkImageCdnStatus needCompress: %s, maxImageSize: %s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i) });
          if (!bool2) {
            break label377;
          }
          paramObject = a.OPN;
          paramObject = paramb.imagePath;
          localObject1 = (kotlin.d.d)this;
          this.label = 1;
          localObject1 = a.e(paramObject, i, (kotlin.d.d)localObject1);
          paramObject = localObject1;
          if (localObject1 != localObject2) {
            break;
          }
          AppMethodBeat.o(313579);
          return localObject2;
        }
      }
      ResultKt.throwOnFailure(paramObject);
      localObject2 = (a.a)paramObject;
      if (localObject2 == null) {}
      for (paramObject = null; (localObject2 == null) || (!y.ZC(paramObject)); paramObject = ((a.a)localObject2).OPR)
      {
        paramObject = parama;
        localObject1 = new f.c();
        ((f.c)localObject1).errType = 3;
        ((f.c)localObject1).errCode = 101;
        ((f.c)localObject1).setErrMsg("checkImageCdnStatus compress image failed");
        localObject2 = ah.aiuX;
        paramObject.a((f.c)localObject1);
        paramObject = ah.aiuX;
        AppMethodBeat.o(313579);
        return paramObject;
      }
      if (paramb.OQs == null) {
        paramb.OQs = new Point();
      }
      paramObject = paramb.OQs;
      if (paramObject != null) {
        paramObject.set(((a.a)localObject2).OPS, ((a.a)localObject2).OPT);
      }
      f.b localb = paramb;
      Object localObject1 = ((a.a)localObject2).OPR;
      paramObject = localObject1;
      if (localObject1 == null) {
        paramObject = "";
      }
      localb.setImagePath(paramObject);
      this.OQi.imagePath = ((a.a)localObject2).OPR;
      paramb.OQt = true;
      paramb.oGu = 1;
      label377:
      f.a(paramb, parama);
      paramObject = ah.aiuX;
      AppMethodBeat.o(313579);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/image/AiScanDefaultImageCDNStrategy$getCDNImageInfoList$1", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageCallback;", "onCDNStartUpload", "", "mediaId", "", "onCheckResult", "checkImageResult", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageResult;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements f.a
  {
    c(k.a parama) {}
    
    public final void a(f.c paramc)
    {
      Object localObject2 = null;
      AppMethodBeat.i(313585);
      s.u(paramc, "checkImageResult");
      int i = paramc.errType;
      int j = paramc.errCode;
      Object localObject1 = paramc.OQw;
      Object localObject3;
      nn localnn;
      if (localObject1 == null)
      {
        localObject1 = null;
        Log.i("MicroMsg.AiScanDefaultImageCDNStrategy", "alvinluo getCDNImageInfoList-default errType: %s, errCode: %s: reUploadInfo: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject1 });
        if ((paramc.errType != 0) || (paramc.errCode != 0)) {
          break label253;
        }
        if (paramc.OQw == null) {
          break label226;
        }
        localObject3 = new ArrayList();
        localnn = new nn();
        localnn.YPA = 1;
        localnn.YPx = 3;
        localObject1 = paramc.OQw;
        if (localObject1 != null) {
          break label208;
        }
        localObject1 = null;
        label133:
        localnn.YPy = ((String)localObject1);
        paramc = paramc.OQw;
        if (paramc != null) {
          break label218;
        }
      }
      label208:
      label218:
      for (paramc = localObject2;; paramc = paramc.YPz)
      {
        localnn.YPz = paramc;
        paramc = ah.aiuX;
        ((ArrayList)localObject3).add(localnn);
        paramc = this.OQl;
        if (paramc == null) {
          break label283;
        }
        paramc.bx((ArrayList)localObject3);
        AppMethodBeat.o(313585);
        return;
        localObject3 = f.OQq;
        localObject1 = f.a((nn)localObject1);
        break;
        localObject1 = ((nn)localObject1).YPy;
        break label133;
      }
      label226:
      paramc = this.OQl;
      if (paramc != null)
      {
        paramc.j(4, 403, "checkImageCdnStatus re-upload cdn error");
        AppMethodBeat.o(313585);
        return;
        label253:
        localObject1 = this.OQl;
        if (localObject1 != null) {
          ((k.a)localObject1).j(paramc.errType, paramc.errCode, paramc.errMsg);
        }
      }
      label283:
      AppMethodBeat.o(313585);
    }
    
    public final void aUD(String paramString)
    {
      AppMethodBeat.i(313596);
      s.u(paramString, "mediaId");
      k.a locala = this.OQl;
      if (locala != null) {
        locala.aUE(paramString);
      }
      AppMethodBeat.o(313596);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.d
 * JD-Core Version:    0.7.0.1
 */