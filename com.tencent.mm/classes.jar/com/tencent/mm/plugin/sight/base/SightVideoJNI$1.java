package com.tencent.mm.plugin.sight.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidMediaUtil;

final class SightVideoJNI$1
  implements Runnable
{
  SightVideoJNI$1(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(213870);
    AndroidMediaUtil.insertPathIntoMediaStore(MMApplicationContext.getContext(), this.val$sourceFilePath);
    AppMethodBeat.o(213870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.SightVideoJNI.1
 * JD-Core Version:    0.7.0.1
 */