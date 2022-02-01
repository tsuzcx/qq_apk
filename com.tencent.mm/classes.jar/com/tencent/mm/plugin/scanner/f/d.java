package com.tencent.mm.plugin.scanner.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRListenerImpl;", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRListener;", "()V", "isCancel", "", "sessionId", "", "onCancel", "", "session", "onDialogCancel", "dialog", "Landroid/content/DialogInterface;", "onDialogDismiss", "exitType", "", "onDialogShow", "onError", "errType", "errCode", "onGetOCRResult", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onStart", "onZoomIn", "zoomOrigin", "onZoomOut", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements c
{
  public static final a OUB;
  private boolean nzW;
  private long sessionId;
  
  static
  {
    AppMethodBeat.i(313474);
    OUB = new a((byte)0);
    AppMethodBeat.o(313474);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(313509);
    s.u(paramf, "result");
    Log.d("MicroMsg.ImageOCRListenerImpl", "alvinluo onGetOCRResult session: %s, success: %s", new Object[] { Long.valueOf(paramf.hBk), Boolean.valueOf(paramf.success) });
    AppMethodBeat.o(313509);
  }
  
  public final void aif(int paramInt)
  {
    AppMethodBeat.i(313533);
    if (this.nzW)
    {
      AppMethodBeat.o(313533);
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
        e.a locala = e.OUC;
        e.a.as(this.sessionId, paramInt);
      }
      AppMethodBeat.o(313533);
      return;
      paramInt = 3;
      continue;
      paramInt = 4;
      continue;
      paramInt = 5;
    }
  }
  
  public final void aig(int paramInt)
  {
    AppMethodBeat.i(313542);
    if ((paramInt == 2) && (this.sessionId != 0L))
    {
      e.a locala = e.OUC;
      e.a.at(this.sessionId, 1);
    }
    AppMethodBeat.o(313542);
  }
  
  public final void aih(int paramInt)
  {
    AppMethodBeat.i(313548);
    if ((paramInt == 2) && (this.sessionId != 0L))
    {
      e.a locala = e.OUC;
      e.a.at(this.sessionId, 2);
    }
    AppMethodBeat.o(313548);
  }
  
  public final void gPF()
  {
    AppMethodBeat.i(313525);
    e.a locala = e.OUC;
    e.a.as(this.sessionId, 2);
    AppMethodBeat.o(313525);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(313516);
    if (paramInt2 == 202)
    {
      locala = e.OUC;
      e.a.as(this.sessionId, 7);
      AppMethodBeat.o(313516);
      return;
    }
    if (paramInt1 == 4)
    {
      locala = e.OUC;
      e.a.as(this.sessionId, 6);
      AppMethodBeat.o(313516);
      return;
    }
    if ((paramInt2 == 301) || (paramInt2 == 201))
    {
      locala = e.OUC;
      e.a.as(this.sessionId, 6);
      AppMethodBeat.o(313516);
      return;
    }
    e.a locala = e.OUC;
    e.a.as(this.sessionId, 99);
    AppMethodBeat.o(313516);
  }
  
  public final void rl(long paramLong)
  {
    AppMethodBeat.i(313488);
    this.sessionId = paramLong;
    this.nzW = false;
    Log.d("MicroMsg.ImageOCRListenerImpl", "alvinluo onStart session: %s", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(313488);
  }
  
  public final void tZ(long paramLong)
  {
    AppMethodBeat.i(313499);
    Log.d("MicroMsg.ImageOCRListenerImpl", "alvinluo onCancel session: %s, isCancel: %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(this.nzW) });
    if ((this.sessionId == paramLong) && (!this.nzW))
    {
      this.nzW = true;
      e.a locala = e.OUC;
      e.a.as(paramLong, 1);
    }
    AppMethodBeat.o(313499);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRListenerImpl$Companion;", "", "()V", "TAG", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.d
 * JD-Core Version:    0.7.0.1
 */