package com.tencent.mm.plugin.websearch.api;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class aa$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(124089);
    String str = aa.cZr();
    if (!TextUtils.isEmpty(str)) {
      aj.cZB().dK(str, 4);
    }
    AppMethodBeat.o(124089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aa.1
 * JD-Core Version:    0.7.0.1
 */