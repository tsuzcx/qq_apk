package com.tencent.mm.plugin.scanner.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRListenerImpl;", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRListener;", "()V", "sessionId", "", "onCancel", "", "session", "onDialogCancel", "dialog", "Landroid/content/DialogInterface;", "onDialogDismiss", "exitType", "", "onDialogShow", "onGetOCRResult", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onStart", "onZoomIn", "onZoomOut", "Companion", "plugin-scan_release"})
public final class d
  implements c
{
  public static final a CIH;
  private long sessionId;
  
  static
  {
    AppMethodBeat.i(240547);
    CIH = new a((byte)0);
    AppMethodBeat.o(240547);
  }
  
  public final void IA(long paramLong)
  {
    AppMethodBeat.i(240540);
    this.sessionId = paramLong;
    Log.d("MicroMsg.ImageOCRListenerImpl", "alvinluo onStart session: %s", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(240540);
  }
  
  public final void IB(long paramLong)
  {
    AppMethodBeat.i(240541);
    Log.d("MicroMsg.ImageOCRListenerImpl", "alvinluo onCancel session: %s", new Object[] { Long.valueOf(paramLong) });
    if (this.sessionId == paramLong)
    {
      e.a locala = e.CIJ;
      e.a.S(paramLong, 1);
    }
    AppMethodBeat.o(240541);
  }
  
  public final void WM(int paramInt)
  {
    AppMethodBeat.i(240544);
    e.a locala;
    if (paramInt == 4)
    {
      locala = e.CIJ;
      e.a.S(this.sessionId, 3);
      AppMethodBeat.o(240544);
      return;
    }
    if (paramInt == 5)
    {
      locala = e.CIJ;
      e.a.S(this.sessionId, 4);
    }
    AppMethodBeat.o(240544);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(240542);
    p.h(paramf, "result");
    Log.d("MicroMsg.ImageOCRListenerImpl", "alvinluo onGetOCRResult session: %s, success: %s", new Object[] { Long.valueOf(paramf.dDZ), Boolean.valueOf(paramf.success) });
    AppMethodBeat.o(240542);
  }
  
  public final void bqQ()
  {
    AppMethodBeat.i(240546);
    e.a locala = e.CIJ;
    e.a.T(this.sessionId, 2);
    AppMethodBeat.o(240546);
  }
  
  public final void bqR()
  {
    AppMethodBeat.i(240545);
    e.a locala = e.CIJ;
    e.a.T(this.sessionId, 1);
    AppMethodBeat.o(240545);
  }
  
  public final void eOX()
  {
    AppMethodBeat.i(240543);
    e.a locala = e.CIJ;
    e.a.S(this.sessionId, 2);
    AppMethodBeat.o(240543);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRListenerImpl$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.d
 * JD-Core Version:    0.7.0.1
 */