package com.tencent.mm.plugin.sight.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidMediaUtil;

class SightVideoJNI$1
  implements Runnable
{
  SightVideoJNI$1(String paramString) {}
  
  public void run()
  {
    AppMethodBeat.i(291870);
    AndroidMediaUtil.insertPathIntoMediaStore(MMApplicationContext.getContext(), this.val$sourceFilePath);
    AppMethodBeat.o(291870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.SightVideoJNI.1
 * JD-Core Version:    0.7.0.1
 */