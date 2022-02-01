package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.ui.tools.a.a;

final class ak$7
  implements a.a
{
  ak$7(ak paramak) {}
  
  public final String aqv(String paramString)
  {
    AppMethodBeat.i(98162);
    paramString = g.getMessageDigest((paramString + System.currentTimeMillis()).getBytes());
    paramString = af.getAccSnsTmpPath() + paramString;
    AppMethodBeat.o(98162);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ak.7
 * JD-Core Version:    0.7.0.1
 */