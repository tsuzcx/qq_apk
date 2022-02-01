package com.tencent.mm.plugin.scanner.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.box.c.c;
import com.tencent.mm.plugin.box.webview.d;
import com.tencent.mm.plugin.box.webview.e;
import com.tencent.mm.protocal.protobuf.mg;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebData;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/box/webview/IBoxWebData;", "uiComponent", "Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;", "(Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;)V", "netScene", "Lcom/tencent/mm/plugin/scanner/model/NetSceneBizAiScanImageRetrieval;", "finish", "", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestDataFromServer", "requestId", "queryJson", "Companion", "plugin-scan_release"})
public final class h
  implements f, e
{
  public static final a ylg;
  private final c nVq;
  com.tencent.mm.plugin.scanner.model.g ylf;
  
  static
  {
    AppMethodBeat.i(52139);
    ylg = new a((byte)0);
    AppMethodBeat.o(52139);
  }
  
  public h(c paramc)
  {
    AppMethodBeat.i(52138);
    this.nVq = paramc;
    com.tencent.mm.kernel.g.aiU().a(1532, (f)this);
    AppMethodBeat.o(52138);
  }
  
  public final void eH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52137);
    ad.i("MicroMsg.ScanBoxWebData", "alvinluo requestDataFromServer requestId: %s, queryJson: %s", new Object[] { paramString1, paramString2 });
    CharSequence localCharSequence = (CharSequence)paramString2;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(52137);
      return;
    }
    try
    {
      if (this.ylf != null) {
        com.tencent.mm.kernel.g.aiU().a((n)this.ylf);
      }
      this.ylf = new com.tencent.mm.plugin.scanner.model.g(paramString1, paramString2);
      com.tencent.mm.kernel.g.aiU().b((n)this.ylf);
      AppMethodBeat.o(52137);
      return;
    }
    catch (Exception paramString1)
    {
      ad.printErrStackTrace("MicroMsg.ScanBoxWebData", (Throwable)paramString1, "alvinluo requestDataFromServer exception", new Object[0]);
      AppMethodBeat.o(52137);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(52136);
    Object localObject;
    d locald;
    if (paramn != null)
    {
      localObject = Integer.valueOf(paramn.getType());
      ad.i("MicroMsg.ScanBoxWebData", "alvinluo onSceneEnd errType: %d, errCode: %d, errMsg: %s, scene type: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, localObject });
      if (!p.i(paramn, this.ylf)) {
        break label207;
      }
      locald = this.nVq.bNb();
      paramn = this.ylf;
      if (paramn != null)
      {
        paramn = paramn.dwW;
        if (paramn != null) {
          break label219;
        }
      }
      paramn = "";
    }
    label207:
    label213:
    label219:
    for (;;)
    {
      localObject = this.ylf;
      if (localObject != null)
      {
        if (((com.tencent.mm.plugin.scanner.model.g)localObject).hWL.aEF() == null) {
          break label213;
        }
        localObject = ((com.tencent.mm.plugin.scanner.model.g)localObject).hWL.aEF();
        if (localObject == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageRetrievalResponse");
          AppMethodBeat.o(52136);
          throw paramString;
          localObject = null;
          break;
        }
      }
      for (localObject = (mg)localObject;; localObject = null)
      {
        if (localObject != null)
        {
          String str = ((mg)localObject).FFt;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        locald.f(paramn, paramInt2, paramString, (String)localObject);
        AppMethodBeat.o(52136);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebData$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.h
 * JD-Core Version:    0.7.0.1
 */