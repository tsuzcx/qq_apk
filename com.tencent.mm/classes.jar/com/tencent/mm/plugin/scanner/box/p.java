package com.tencent.mm.plugin.scanner.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.box.c.b;
import com.tencent.mm.plugin.box.webview.e;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebData;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/box/webview/IBoxWebData;", "uiComponent", "Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;", "(Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;)V", "netScene", "Lcom/tencent/mm/plugin/scanner/model/NetSceneBizAiScanImageRetrieval;", "finish", "", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestDataFromServer", "requestId", "queryJson", "Companion", "plugin-scan_release"})
public final class p
  implements i, e
{
  public static final a IHN;
  com.tencent.mm.plugin.scanner.model.h IHM;
  private final b som;
  
  static
  {
    AppMethodBeat.i(52139);
    IHN = new a((byte)0);
    AppMethodBeat.o(52139);
  }
  
  public p(b paramb)
  {
    AppMethodBeat.i(52138);
    this.som = paramb;
    com.tencent.mm.kernel.h.aGY().a(1532, (i)this);
    AppMethodBeat.o(52138);
  }
  
  public final void fq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52137);
    Log.i("MicroMsg.ScanBoxWebData", "alvinluo requestDataFromServer requestId: %s, queryJson: %s", new Object[] { paramString1, paramString2 });
    CharSequence localCharSequence = (CharSequence)paramString2;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(52137);
      return;
    }
    try
    {
      if (this.IHM != null) {
        com.tencent.mm.kernel.h.aGY().a((q)this.IHM);
      }
      this.IHM = new com.tencent.mm.plugin.scanner.model.h(paramString1, paramString2);
      com.tencent.mm.kernel.h.aGY().b((q)this.IHM);
      AppMethodBeat.o(52137);
      return;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.ScanBoxWebData", (Throwable)paramString1, "alvinluo requestDataFromServer exception", new Object[0]);
      AppMethodBeat.o(52137);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(52136);
    Object localObject;
    com.tencent.mm.plugin.box.webview.d locald;
    if (paramq != null)
    {
      localObject = Integer.valueOf(paramq.getType());
      Log.i("MicroMsg.ScanBoxWebData", "alvinluo onSceneEnd errType: %d, errCode: %d, errMsg: %s, scene type: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, localObject });
      if (!kotlin.g.b.p.h(paramq, this.IHM)) {
        break label207;
      }
      locald = this.som.cyw();
      paramq = this.IHM;
      if (paramq != null)
      {
        paramq = paramq.fIY;
        if (paramq != null) {
          break label219;
        }
      }
      paramq = "";
    }
    label207:
    label213:
    label219:
    for (;;)
    {
      localObject = this.IHM;
      if (localObject != null)
      {
        if (((com.tencent.mm.plugin.scanner.model.h)localObject).lKU.bhY() == null) {
          break label213;
        }
        localObject = ((com.tencent.mm.plugin.scanner.model.h)localObject).lKU.bhY();
        if (localObject == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageRetrievalResponse");
          AppMethodBeat.o(52136);
          throw paramString;
          localObject = null;
          break;
        }
      }
      for (localObject = (mp)localObject;; localObject = null)
      {
        if (localObject != null)
        {
          String str = ((mp)localObject).RSB;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        locald.g(paramq, paramInt2, paramString, (String)localObject);
        AppMethodBeat.o(52136);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebData$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.p
 * JD-Core Version:    0.7.0.1
 */