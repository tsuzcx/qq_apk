package com.tencent.mm.plugin.scanner.util;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

final class e$1
  implements Runnable
{
  e$1(e parame, byte[] paramArrayOfByte, Point paramPoint) {}
  
  public final void run()
  {
    AppMethodBeat.i(81380);
    if (e.a(this.qCp, this.val$data, this.qCo))
    {
      al.d(new e.1.1(this));
      AppMethodBeat.o(81380);
      return;
    }
    al.d(new e.1.2(this));
    AppMethodBeat.o(81380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.e.1
 * JD-Core Version:    0.7.0.1
 */