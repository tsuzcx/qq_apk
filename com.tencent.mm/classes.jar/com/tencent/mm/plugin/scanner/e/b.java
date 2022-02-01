package com.tencent.mm.plugin.scanner.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.plugin.scanner.model.aa;
import com.tencent.mm.protocal.protobuf.mi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import kotlin.g.a.q;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/image/AiScanChatImageCDNStrategy;", "Lcom/tencent/mm/plugin/scanner/image/AiScanDefaultImageCDNStrategy;", "()V", "fillCheckImageRequest", "", "msgId", "", "checkRequest", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageRequest;", "isHdImageValid", "", "getCDNImageInfoList", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "getCDNInfoCallback", "Lcom/tencent/mm/plugin/scanner/image/IAiScanImageCDNStrategy$GetCDNInfoCallback;", "name", "", "Companion", "plugin-scan_release"})
public final class b
  extends d
{
  public static final b.a IJn;
  
  static
  {
    AppMethodBeat.i(219055);
    IJn = new b.a((byte)0);
    AppMethodBeat.o(219055);
  }
  
  private static void a(long paramLong, f.b paramb, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(219052);
    if (paramb.IJG == 2)
    {
      paramb.lNK = 0;
      localObject1 = h.ae(n.class);
      p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
      localObject1 = ((n)localObject1).eSe().Oq(paramLong);
      localObject2 = c.IJz;
      localObject2 = c.bb((ca)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramb.setImagePath((String)localObject1);
    }
    while (paramb.IJG != 1)
    {
      Object localObject2;
      Object localObject1 = com.tencent.mm.plugin.scanner.util.f.IYY;
      paramb.IJE = com.tencent.mm.plugin.scanner.util.f.aXy(paramb.imagePath);
      c.a(paramb, paramLong, paramb.lNK);
      AppMethodBeat.o(219052);
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      paramb.lNK = i;
      break;
      i = 0;
    }
  }
  
  public final void a(e parame, final k.a parama)
  {
    AppMethodBeat.i(219048);
    p.k(parame, "request");
    final long l = parame.sessionId;
    Object localObject1 = h.ae(n.class);
    p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    Object localObject2 = ((n)localObject1).eSe().Oq(parame.msgId);
    localObject1 = new ArrayList();
    Object localObject4 = new aa.f();
    ((aa.f)localObject4).aaBC = "";
    final aa.a locala1 = new aa.a();
    locala1.aaBx = false;
    final aa.a locala2 = new aa.a();
    locala2.aaBx = false;
    Object localObject3 = c.IJz;
    localObject3 = (q)new b.b((aa.f)localObject4, locala1, locala2);
    p.k(localObject3, "callback");
    c.a((ca)localObject2, (q)localObject3);
    Log.i("MicroMsg.AiScanChatImageStrategy", "alvinluo getCDNImageInfoList-chat msgId: %s, session: %s, isHdImageValid: %s, hasHd: %s", new Object[] { Long.valueOf(parame.msgId), Long.valueOf(l), Boolean.valueOf(locala1.aaBx), Boolean.valueOf(locala2.aaBx) });
    localObject2 = new aa.f();
    ((aa.f)localObject2).aaBC = null;
    localObject3 = new aa.f();
    ((aa.f)localObject3).aaBC = null;
    final f.b localb1 = new f.b(l, 2);
    a(parame.msgId, localb1, locala1.aaBx);
    final f.b localb2 = new f.b(l, 1);
    localb2.setImagePath((String)((aa.f)localObject4).aaBC);
    a(parame.msgId, localb2, locala1.aaBx);
    localObject4 = f.a(localb1, a.adm(parame.IGy));
    f.c localc = f.a(localb2, a.adm(parame.IGy));
    CharSequence localCharSequence = (CharSequence)parame.imagePath;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0)
      {
        if (!u.agG(localb2.imagePath)) {
          break label492;
        }
        parame.imagePath = localb2.imagePath;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.AiScanChatImageStrategy", "alvinluo getCDNImageInfoList-chat result midImage fileId: %s, aesKey: %s, hdImage fileId: %s aesKey: %s", new Object[] { localb1.fileId, Util.secPrint(localb1.aesKey), localb2.fileId, Util.secPrint(localb2.aesKey) });
      parama = new c((aa.f)localObject2, (aa.f)localObject3, (ArrayList)localObject1, locala1, locala2, l, parame, localb1, localb2, parama);
      ((aa.f)localObject2).aaBC = localb1.fCE();
      ((aa.f)localObject3).aaBC = localb2.fCE();
      if (!((f.c)localObject4).fCF()) {
        break label515;
      }
      a(parame, localb1, (f.a)parama);
      AppMethodBeat.o(219048);
      return;
      i = 0;
      break;
      label492:
      if (u.agG(localb1.imagePath)) {
        parame.imagePath = localb1.imagePath;
      }
    }
    label515:
    if (localc.fCF())
    {
      a(parame, localb2, (f.a)parama);
      AppMethodBeat.o(219048);
      return;
    }
    if (localc.IJH == 2)
    {
      a(parame, localb2, (f.a)parama);
      AppMethodBeat.o(219048);
      return;
    }
    if (((f.c)localObject4).IJH == 2)
    {
      a(parame, localb1, (f.a)parama);
      AppMethodBeat.o(219048);
      return;
    }
    parame = new f.c();
    parame.errType = 3;
    parame.errCode = 401;
    parama.a(parame);
    AppMethodBeat.o(219048);
  }
  
  public final String name()
  {
    return "MicroMsg.AiScanChatImageStrategy";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/image/AiScanChatImageCDNStrategy$getCDNImageInfoList$callback$1", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageCallback;", "onCDNStartUpload", "", "mediaId", "", "onCheckResult", "checkImageResult", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageResult;", "plugin-scan_release"})
  public static final class c
    implements f.a
  {
    c(aa.f paramf1, aa.f paramf2, ArrayList paramArrayList, aa.a parama1, aa.a parama2, long paramLong, e parame, f.b paramb1, f.b paramb2, k.a parama) {}
    
    public final void a(f.c paramc)
    {
      int i = 1;
      AppMethodBeat.i(220513);
      p.k(paramc, "checkImageResult");
      Object localObject2 = new StringBuilder("alvinluo getCDNImageInfoList-chat checkImageStatus result errType: ").append(paramc.errType).append(", errCode: ").append(paramc.errCode).append(", reUploadInfo: ");
      Object localObject1 = paramc.IJI;
      boolean bool;
      if (localObject1 != null)
      {
        f localf = f.IJD;
        localObject1 = f.a((mi)localObject1);
        Log.i("MicroMsg.AiScanChatImageStrategy", (String)localObject1);
        if ((paramc.errType != 0) || (paramc.errCode != 0)) {
          break label626;
        }
        if (paramc.IJI == null) {
          break label410;
        }
        localObject1 = (mi)this.IJr.aaBC;
        if (localObject1 != null) {
          ((mi)localObject1).RSa = 2;
        }
        localObject1 = (mi)this.IJs.aaBC;
        if (localObject1 != null) {
          ((mi)localObject1).RSa = 2;
        }
        localObject1 = this.IJt;
        paramc = paramc.IJI;
        if (paramc == null) {
          p.iCn();
        }
        ((ArrayList)localObject1).add(paramc);
        bool = true;
        label180:
        if (!locala1.aaBx) {
          break label460;
        }
        paramc = (mi)this.IJs.aaBC;
        if (paramc != null) {
          this.IJt.add(paramc);
        }
        paramc = (mi)this.IJr.aaBC;
        if (paramc != null)
        {
          paramc.w = 0;
          paramc.h = 0;
          this.IJt.add(paramc);
        }
        label248:
        Log.i("MicroMsg.AiScanChatImageStrategy", "alvinluo getCDNImageInfoList-chat checkImageStatus result reUpload: %s, list size: %s, request.pHash: %s, needPHash: %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.IJt.size()), localb1.IGB, Boolean.valueOf(localb1.IGC) });
        if ((localb1.IGB == null) && (localb1.IGC))
        {
          if (!u.agG(localb2.imagePath)) {
            break label585;
          }
          paramc = localb2.imagePath;
          label343:
          if (((CharSequence)paramc).length() <= 0) {
            break label615;
          }
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          localObject1 = localb1;
          localObject2 = aa.ILM;
          ((e)localObject1).IGB = aa.aXh(paramc);
        }
        paramc = this.IJy;
        if (paramc == null) {
          break label620;
        }
        paramc.aZ(this.IJt);
        AppMethodBeat.o(220513);
        return;
        localObject1 = null;
        break;
        label410:
        paramc = (mi)this.IJr.aaBC;
        if (paramc != null) {
          paramc.RSa = 1;
        }
        paramc = (mi)this.IJs.aaBC;
        if (paramc != null)
        {
          paramc.RSa = 1;
          bool = false;
          break label180;
        }
        bool = false;
        break label180;
        label460:
        if ((locala2.aaBx) && (!locala1.aaBx))
        {
          Log.i("MicroMsg.AiScanChatImageStrategy", "alvinluo getCDNImageInfoList-chat hasHd but hd not exist");
          paramc = new f.b(l, 1);
          c.a(paramc, localb1.msgId, 1);
          paramc = paramc.fCE();
          paramc.RRX = 1;
          this.IJt.add(paramc);
          paramc = (mi)this.IJs.aaBC;
          if (paramc == null) {
            break label248;
          }
          this.IJt.add(paramc);
          break label248;
        }
        paramc = (mi)this.IJs.aaBC;
        if (paramc == null) {
          break label248;
        }
        this.IJt.add(paramc);
        break label248;
        label585:
        if (u.agG(parama.imagePath))
        {
          paramc = parama.imagePath;
          break label343;
        }
        paramc = "";
        break label343;
        label615:
        i = 0;
      }
      label620:
      AppMethodBeat.o(220513);
      return;
      label626:
      localObject1 = this.IJy;
      if (localObject1 != null)
      {
        ((k.a)localObject1).i(paramc.errType, paramc.errCode, paramc.errMsg);
        AppMethodBeat.o(220513);
        return;
      }
      AppMethodBeat.o(220513);
    }
    
    public final void aXc(String paramString)
    {
      AppMethodBeat.i(220515);
      p.k(paramString, "mediaId");
      k.a locala = this.IJy;
      if (locala != null)
      {
        locala.aXd(paramString);
        AppMethodBeat.o(220515);
        return;
      }
      AppMethodBeat.o(220515);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.b
 * JD-Core Version:    0.7.0.1
 */