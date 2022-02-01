package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.ui.tools.a.a;

final class SnsUIAction$2
  implements a.a
{
  SnsUIAction$2(SnsUIAction paramSnsUIAction) {}
  
  public final String aqv(String paramString)
  {
    AppMethodBeat.i(176354);
    paramString = g.getMessageDigest((this.xJI.filePath + System.currentTimeMillis()).getBytes());
    paramString = af.getAccSnsTmpPath() + paramString;
    AppMethodBeat.o(176354);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUIAction.2
 * JD-Core Version:    0.7.0.1
 */