package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class e$1$1
  implements Runnable
{
  e$1$1(e.1 param1) {}
  
  public final void run()
  {
    boolean bool = true;
    AppMethodBeat.i(81378);
    if (this.qCq.qCp.qBY == null) {}
    for (;;)
    {
      ab.i("MicroMsg.scanner.QBarDecoder", "alvinluo decodeSuccess callback == null: %b", new Object[] { Boolean.valueOf(bool) });
      if (this.qCq.qCp.qBY != null) {
        this.qCq.qCp.qBY.a(b.quq, this.qCq.qCp.qCa, this.qCq.qCp.rawData, this.qCq.qCp.qBZ, this.qCq.qCp.cpE, this.qCq.qCp.cpF, this.qCq.qCp.typeName);
      }
      AppMethodBeat.o(81378);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.e.1.1
 * JD-Core Version:    0.7.0.1
 */