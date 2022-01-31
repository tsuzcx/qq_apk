package com.tencent.mm.plugin.scanner.history.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.e;
import com.tencent.mm.ui.base.h.c;

final class ScannerHistoryUI$5
  implements h.c
{
  ScannerHistoryUI$5(ScannerHistoryUI paramScannerHistoryUI, int paramInt) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(80804);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(80804);
      return;
      com.tencent.mm.plugin.scanner.history.a.a locala = (com.tencent.mm.plugin.scanner.history.a.a)ScannerHistoryUI.a(this.qtO).getItem(this.gxr);
      if (locala != null)
      {
        e.chX().cib().delete(locala, new String[0]);
        ScannerHistoryUI.c(this.qtO);
        ScannerHistoryUI.a(this.qtO).a(null, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI.5
 * JD-Core Version:    0.7.0.1
 */