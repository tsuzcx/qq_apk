package com.tencent.mm.plugin.scanner.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRListenerImpl;", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRListener;", "()V", "isCancel", "", "sessionId", "", "onCancel", "", "session", "onDialogCancel", "dialog", "Landroid/content/DialogInterface;", "onDialogDismiss", "exitType", "", "onDialogShow", "onError", "errType", "errCode", "onGetOCRResult", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onStart", "onZoomIn", "zoomOrigin", "onZoomOut", "Companion", "plugin-scan_release"})
public final class d
  implements c
{
  public static final a INx;
  private boolean kUn;
  private long sessionId;
  
  static
  {
    AppMethodBeat.i(223149);
    INx = new a((byte)0);
    AppMethodBeat.o(223149);
  }
  
  public final void PU(long paramLong)
  {
    AppMethodBeat.i(223130);
    this.sessionId = paramLong;
    this.kUn = false;
    Log.d("MicroMsg.ImageOCRListenerImpl", "alvinluo onStart session: %s", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(223130);
  }
  
  public final void PV(long paramLong)
  {
    AppMethodBeat.i(223133);
    Log.d("MicroMsg.ImageOCRListenerImpl", "alvinluo onCancel session: %s, isCancel: %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(this.kUn) });
    if ((this.sessionId == paramLong) && (!this.kUn))
    {
      this.kUn = true;
      e.a locala = e.INz;
      e.a.ab(paramLong, 1);
    }
    AppMethodBeat.o(223133);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(223134);
    p.k(paramf, "result");
    Log.d("MicroMsg.ImageOCRListenerImpl", "alvinluo onGetOCRResult session: %s, success: %s", new Object[] { Long.valueOf(paramf.fwK), Boolean.valueOf(paramf.success) });
    AppMethodBeat.o(223134);
  }
  
  public final void adI(int paramInt)
  {
    AppMethodBeat.i(223143);
    if (this.kUn)
    {
      AppMethodBeat.o(223143);
      return;
    }
    switch (paramInt)
    {
    case 3: 
    default: 
      paramInt = -1;
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        e.a locala = e.INz;
        e.a.ab(this.sessionId, paramInt);
      }
      AppMethodBeat.o(223143);
      return;
      paramInt = 3;
      continue;
      paramInt = 4;
      continue;
      paramInt = 5;
    }
  }
  
  public final void adJ(int paramInt)
  {
    AppMethodBeat.i(223146);
    if ((paramInt == 2) && (this.sessionId != 0L))
    {
      e.a locala = e.INz;
      e.a.ac(this.sessionId, 1);
    }
    AppMethodBeat.o(223146);
  }
  
  public final void adK(int paramInt)
  {
    AppMethodBeat.i(223148);
    if ((paramInt == 2) && (this.sessionId != 0L))
    {
      e.a locala = e.INz;
      e.a.ac(this.sessionId, 2);
    }
    AppMethodBeat.o(223148);
  }
  
  public final void fBZ()
  {
    AppMethodBeat.i(223141);
    e.a locala = e.INz;
    e.a.ab(this.sessionId, 2);
    AppMethodBeat.o(223141);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223138);
    if (paramInt2 == 202)
    {
      locala = e.INz;
      e.a.ab(this.sessionId, 7);
      AppMethodBeat.o(223138);
      return;
    }
    if (paramInt1 == 4)
    {
      locala = e.INz;
      e.a.ab(this.sessionId, 6);
      AppMethodBeat.o(223138);
      return;
    }
    if ((paramInt2 == 301) || (paramInt2 == 201))
    {
      locala = e.INz;
      e.a.ab(this.sessionId, 6);
      AppMethodBeat.o(223138);
      return;
    }
    e.a locala = e.INz;
    e.a.ab(this.sessionId, 99);
    AppMethodBeat.o(223138);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRListenerImpl$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.d
 * JD-Core Version:    0.7.0.1
 */