package com.tencent.mm.plugin.scanner.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.plugin.scanner.util.g;
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.a.q;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/image/AiScanChatImageCDNStrategy;", "Lcom/tencent/mm/plugin/scanner/image/AiScanDefaultImageCDNStrategy;", "()V", "fillCheckImageRequest", "", "msgId", "", "checkRequest", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageRequest;", "isHdImageValid", "", "getCDNImageInfoList", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "getCDNInfoCallback", "Lcom/tencent/mm/plugin/scanner/image/IAiScanImageCDNStrategy$GetCDNInfoCallback;", "name", "", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends d
{
  public static final b.a OQb;
  
  static
  {
    AppMethodBeat.i(313604);
    OQb = new b.a((byte)0);
    AppMethodBeat.o(313604);
  }
  
  private static void a(long paramLong, f.b paramb, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(313601);
    if (paramb.OQr == 2)
    {
      paramb.oGu = 0;
      localObject1 = ((n)h.ax(n.class)).gaZ().sl(paramLong);
      localObject2 = c.OQm;
      localObject2 = c.bs((cc)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramb.setImagePath((String)localObject1);
    }
    while (paramb.OQr != 1)
    {
      Object localObject2;
      Object localObject1 = g.PiK;
      paramb.OQs = g.aVg(paramb.imagePath);
      c.a(paramb, paramLong, paramb.oGu);
      AppMethodBeat.o(313601);
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      paramb.oGu = i;
      break;
      i = 0;
    }
  }
  
  public final void a(e parame, final k.a parama)
  {
    AppMethodBeat.i(313641);
    s.u(parame, "request");
    final long l = parame.sessionId;
    Object localObject2 = ((n)h.ax(n.class)).gaZ().sl(parame.msgId);
    Object localObject1 = new ArrayList();
    Object localObject4 = new ah.f();
    ((ah.f)localObject4).aqH = "";
    final ah.a locala1 = new ah.a();
    final ah.a locala2 = new ah.a();
    Object localObject3 = c.OQm;
    localObject3 = (q)new b.b((ah.f)localObject4, locala1, locala2);
    s.u(localObject3, "callback");
    c.a((cc)localObject2, (q)localObject3);
    Log.i("MicroMsg.AiScanChatImageStrategy", "alvinluo getCDNImageInfoList-chat msgId: %s, session: %s, isHdImageValid: %s, hasHd: %s", new Object[] { Long.valueOf(parame.msgId), Long.valueOf(l), Boolean.valueOf(locala1.aiwY), Boolean.valueOf(locala2.aiwY) });
    localObject2 = new ah.f();
    localObject3 = new ah.f();
    final f.b localb1 = new f.b(l, 2);
    a(parame.msgId, localb1, locala1.aiwY);
    final f.b localb2 = new f.b(l, 1);
    localb2.setImagePath((String)((ah.f)localObject4).aqH);
    a(parame.msgId, localb2, locala1.aiwY);
    localObject4 = f.a(localb1, a.ahJ(parame.OMG));
    f.c localc = f.a(localb2, a.ahJ(parame.OMG));
    CharSequence localCharSequence = (CharSequence)parame.imagePath;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0)
      {
        if (!y.ZC(localb2.imagePath)) {
          break label457;
        }
        parame.imagePath = localb2.imagePath;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.AiScanChatImageStrategy", "alvinluo getCDNImageInfoList-chat result midImage fileId: %s, aesKey: %s, hdImage fileId: %s aesKey: %s", new Object[] { localb1.fileId, Util.secPrint(localb1.aesKey), localb2.fileId, Util.secPrint(localb2.aesKey) });
      parama = new c((ah.f)localObject2, (ah.f)localObject3, (ArrayList)localObject1, locala1, locala2, l, parame, localb1, localb2, parama);
      ((ah.f)localObject2).aqH = localb1.gQG();
      ((ah.f)localObject3).aqH = localb2.gQG();
      if (!((f.c)localObject4).boj()) {
        break label480;
      }
      a(parame, localb1, (f.a)parama);
      AppMethodBeat.o(313641);
      return;
      i = 0;
      break;
      label457:
      if (y.ZC(localb1.imagePath)) {
        parame.imagePath = localb1.imagePath;
      }
    }
    label480:
    if (localc.boj())
    {
      a(parame, localb2, (f.a)parama);
      AppMethodBeat.o(313641);
      return;
    }
    if (localc.OQv == 2)
    {
      a(parame, localb2, (f.a)parama);
      AppMethodBeat.o(313641);
      return;
    }
    if (((f.c)localObject4).OQv == 2)
    {
      a(parame, localb1, (f.a)parama);
      AppMethodBeat.o(313641);
      return;
    }
    parame = new f.c();
    parame.errType = 3;
    parame.errCode = 401;
    localObject1 = kotlin.ah.aiuX;
    parama.a(parame);
    AppMethodBeat.o(313641);
  }
  
  public final String name()
  {
    return "MicroMsg.AiScanChatImageStrategy";
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/image/AiScanChatImageCDNStrategy$getCDNImageInfoList$callback$1", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageCallback;", "onCDNStartUpload", "", "mediaId", "", "onCheckResult", "checkImageResult", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageResult;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements f.a
  {
    c(ah.f<nn> paramf1, ah.f<nn> paramf2, ArrayList<nn> paramArrayList, ah.a parama1, ah.a parama2, long paramLong, e parame, f.b paramb1, f.b paramb2, k.a parama) {}
    
    public final void a(f.c paramc)
    {
      int i = 1;
      AppMethodBeat.i(313590);
      s.u(paramc, "checkImageResult");
      Object localObject2 = new StringBuilder("alvinluo getCDNImageInfoList-chat checkImageStatus result errType: ").append(paramc.errType).append(", errCode: ").append(paramc.errCode).append(", reUploadInfo: ");
      Object localObject1 = paramc.OQw;
      boolean bool;
      if (localObject1 == null)
      {
        localObject1 = null;
        Log.i("MicroMsg.AiScanChatImageStrategy", localObject1);
        if ((paramc.errType != 0) || (paramc.errCode != 0)) {
          break label617;
        }
        if (paramc.OQw == null) {
          break label411;
        }
        localObject1 = (nn)this.OQf.aqH;
        if (localObject1 != null) {
          ((nn)localObject1).YPA = 2;
        }
        localObject1 = (nn)this.OQg.aqH;
        if (localObject1 != null) {
          ((nn)localObject1).YPA = 2;
        }
        localObject1 = this.OQh;
        paramc = paramc.OQw;
        s.checkNotNull(paramc);
        ((ArrayList)localObject1).add(paramc);
        bool = true;
        label168:
        if (!locala1.aiwY) {
          break label456;
        }
        paramc = (nn)this.OQg.aqH;
        if (paramc != null) {
          this.OQh.add(paramc);
        }
        paramc = (nn)this.OQf.aqH;
        if (paramc != null)
        {
          localObject1 = this.OQh;
          paramc.w = 0;
          paramc.h = 0;
          ((ArrayList)localObject1).add(paramc);
        }
        label240:
        Log.i("MicroMsg.AiScanChatImageStrategy", "alvinluo getCDNImageInfoList-chat checkImageStatus result reUpload: %s, list size: %s, request.pHash: %s, needPHash: %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.OQh.size()), localb1.OMJ, Boolean.valueOf(localb1.OMK) });
        if ((localb1.OMJ == null) && (localb1.OMK))
        {
          if (!y.ZC(localb2.imagePath)) {
            break label581;
          }
          paramc = localb2.imagePath;
          label335:
          if (((CharSequence)paramc).length() <= 0) {
            break label612;
          }
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          localObject1 = localb1;
          localObject2 = com.tencent.mm.plugin.scanner.model.ah.OSL;
          ((e)localObject1).OMJ = com.tencent.mm.plugin.scanner.model.ah.aUL(paramc);
        }
        paramc = this.OQl;
        if (paramc == null) {
          break label647;
        }
        paramc.bx(this.OQh);
        AppMethodBeat.o(313590);
        return;
        f localf = f.OQq;
        localObject1 = f.a((nn)localObject1);
        break;
        label411:
        paramc = (nn)this.OQf.aqH;
        if (paramc != null) {
          paramc.YPA = 1;
        }
        paramc = (nn)this.OQg.aqH;
        if (paramc != null) {
          paramc.YPA = 1;
        }
        bool = false;
        break label168;
        label456:
        if ((locala2.aiwY) && (!locala1.aiwY))
        {
          Log.i("MicroMsg.AiScanChatImageStrategy", "alvinluo getCDNImageInfoList-chat hasHd but hd not exist");
          paramc = new f.b(l, 1);
          c.a(paramc, localb1.msgId, 1);
          paramc = paramc.gQG();
          paramc.YPx = 1;
          this.OQh.add(paramc);
          paramc = (nn)this.OQg.aqH;
          if (paramc == null) {
            break label240;
          }
          this.OQh.add(paramc);
          break label240;
        }
        paramc = (nn)this.OQg.aqH;
        if (paramc == null) {
          break label240;
        }
        this.OQh.add(paramc);
        break label240;
        label581:
        if (y.ZC(parama.imagePath))
        {
          paramc = parama.imagePath;
          break label335;
        }
        paramc = "";
        break label335;
        label612:
        i = 0;
      }
      label617:
      localObject1 = this.OQl;
      if (localObject1 != null) {
        ((k.a)localObject1).j(paramc.errType, paramc.errCode, paramc.errMsg);
      }
      label647:
      AppMethodBeat.o(313590);
    }
    
    public final void aUD(String paramString)
    {
      AppMethodBeat.i(313595);
      s.u(paramString, "mediaId");
      k.a locala = this.OQl;
      if (locala != null) {
        locala.aUE(paramString);
      }
      AppMethodBeat.o(313595);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.b
 * JD-Core Version:    0.7.0.1
 */