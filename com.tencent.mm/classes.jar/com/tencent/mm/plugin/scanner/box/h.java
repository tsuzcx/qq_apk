package com.tencent.mm.plugin.scanner.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.box.c.c;
import com.tencent.mm.plugin.box.webview.d;
import com.tencent.mm.protocal.protobuf.lu;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebData;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/box/webview/IBoxWebData;", "uiComponent", "Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;", "(Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;)V", "netScene", "Lcom/tencent/mm/plugin/scanner/model/NetSceneBizAiScanImageRetrieval;", "finish", "", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestDataFromServer", "requestId", "queryJson", "Companion", "plugin-scan_release"})
public final class h
  implements com.tencent.mm.ak.g, com.tencent.mm.plugin.box.webview.e
{
  public static final a wXv;
  private final c nua;
  com.tencent.mm.plugin.scanner.model.e wXu;
  
  static
  {
    AppMethodBeat.i(52139);
    wXv = new a((byte)0);
    AppMethodBeat.o(52139);
  }
  
  public h(c paramc)
  {
    AppMethodBeat.i(52138);
    this.nua = paramc;
    com.tencent.mm.kernel.g.agi().a(1532, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(52138);
  }
  
  public final void ey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52137);
    ac.i("MicroMsg.ScanBoxWebData", "alvinluo requestDataFromServer requestId: %s, queryJson: %s", new Object[] { paramString1, paramString2 });
    CharSequence localCharSequence = (CharSequence)paramString2;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(52137);
      return;
    }
    try
    {
      if (this.wXu != null) {
        com.tencent.mm.kernel.g.agi().a((n)this.wXu);
      }
      this.wXu = new com.tencent.mm.plugin.scanner.model.e(paramString1, paramString2);
      com.tencent.mm.kernel.g.agi().b((n)this.wXu);
      AppMethodBeat.o(52137);
      return;
    }
    catch (Exception paramString1)
    {
      ac.printErrStackTrace("MicroMsg.ScanBoxWebData", (Throwable)paramString1, "alvinluo requestDataFromServer exception", new Object[0]);
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
      ac.i("MicroMsg.ScanBoxWebData", "alvinluo onSceneEnd errType: %d, errCode: %d, errMsg: %s, scene type: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, localObject });
      if (!k.g(paramn, this.wXu)) {
        break label207;
      }
      locald = this.nua.bIL();
      paramn = this.wXu;
      if (paramn != null)
      {
        paramn = paramn.dlj;
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
      localObject = this.wXu;
      if (localObject != null)
      {
        if (((com.tencent.mm.plugin.scanner.model.e)localObject).hEg.aBD() == null) {
          break label213;
        }
        localObject = ((com.tencent.mm.plugin.scanner.model.e)localObject).hEg.aBD();
        if (localObject == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageRetrievalResponse");
          AppMethodBeat.o(52136);
          throw paramString;
          localObject = null;
          break;
        }
      }
      for (localObject = (lu)localObject;; localObject = null)
      {
        if (localObject != null)
        {
          String str = ((lu)localObject).DZR;
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebData$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.h
 * JD-Core Version:    0.7.0.1
 */