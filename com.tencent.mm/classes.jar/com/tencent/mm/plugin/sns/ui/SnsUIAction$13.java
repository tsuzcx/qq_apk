package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.ui.tools.a.a;

final class SnsUIAction$13
  implements a.a
{
  SnsUIAction$13(SnsUIAction paramSnsUIAction) {}
  
  public final String acd(String paramString)
  {
    AppMethodBeat.i(145650);
    paramString = g.w((this.sbh.filePath + System.currentTimeMillis()).getBytes());
    paramString = ag.getAccSnsTmpPath() + paramString;
    AppMethodBeat.o(145650);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUIAction.13
 * JD-Core Version:    0.7.0.1
 */