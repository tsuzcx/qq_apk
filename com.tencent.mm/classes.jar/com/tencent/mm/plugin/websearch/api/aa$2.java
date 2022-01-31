package com.tencent.mm.plugin.websearch.api;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class aa$2
  implements Runnable
{
  aa$2(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(124090);
    String str = aa.bx(this.fwD, this.hpi);
    if (!TextUtils.isEmpty(str)) {
      aj.cZB().dK(str, 5);
    }
    AppMethodBeat.o(124090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aa.2
 * JD-Core Version:    0.7.0.1
 */