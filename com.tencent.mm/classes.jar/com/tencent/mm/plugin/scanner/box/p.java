package com.tencent.mm.plugin.scanner.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.plugin.box.c.b;
import com.tencent.mm.plugin.box.webview.d;
import com.tencent.mm.plugin.box.webview.e;
import com.tencent.mm.plugin.scanner.model.m;
import com.tencent.mm.protocal.protobuf.nu;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebData;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/box/webview/IBoxWebData;", "uiComponent", "Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;", "(Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;)V", "netScene", "Lcom/tencent/mm/plugin/scanner/model/NetSceneBizAiScanImageRetrieval;", "finish", "", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestDataFromServer", "requestId", "queryJson", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  implements com.tencent.mm.am.h, e
{
  public static final a ONP;
  m ONQ;
  private final b vAk;
  
  static
  {
    AppMethodBeat.i(52139);
    ONP = new a((byte)0);
    AppMethodBeat.o(52139);
  }
  
  public p(b paramb)
  {
    AppMethodBeat.i(52138);
    this.vAk = paramb;
    com.tencent.mm.kernel.h.aZW().a(1532, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(52138);
  }
  
  public final void fH(String paramString1, String paramString2)
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
      if (this.ONQ != null) {
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)this.ONQ);
      }
      this.ONQ = new m(paramString1, paramString2);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)this.ONQ, 0);
      AppMethodBeat.o(52137);
      return;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.ScanBoxWebData", (Throwable)paramString1, "alvinluo requestDataFromServer exception", new Object[0]);
      AppMethodBeat.o(52137);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(52136);
    Object localObject;
    d locald;
    if (paramp == null)
    {
      localObject = null;
      Log.i("MicroMsg.ScanBoxWebData", "alvinluo onSceneEnd errType: %d, errCode: %d, errMsg: %s, scene type: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, localObject });
      if (kotlin.g.b.s.p(paramp, this.ONQ))
      {
        locald = this.vAk.dbn();
        paramp = this.ONQ;
        if (paramp != null) {
          break label130;
        }
        localObject = "";
        label85:
        paramp = this.ONQ;
        if (paramp != null) {
          break label152;
        }
        paramp = "";
      }
    }
    for (;;)
    {
      locald.c((String)localObject, paramInt2, paramString, paramp);
      AppMethodBeat.o(52136);
      return;
      localObject = Integer.valueOf(paramp.getType());
      break;
      label130:
      localObject = paramp.hOG;
      if (localObject == null)
      {
        localObject = "";
        break label85;
      }
      break label85;
      label152:
      if (c.c.b(paramp.oDw.otC) != null)
      {
        paramp = c.c.b(paramp.oDw.otC);
        if (paramp == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageRetrievalResponse");
          AppMethodBeat.o(52136);
          throw paramString;
        }
      }
      for (paramp = (nu)paramp;; paramp = null)
      {
        if (paramp != null) {
          break label226;
        }
        paramp = "";
        break;
      }
      label226:
      String str = paramp.YQb;
      paramp = str;
      if (str == null) {
        paramp = "";
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebData$Companion;", "", "()V", "TAG", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.p
 * JD-Core Version:    0.7.0.1
 */