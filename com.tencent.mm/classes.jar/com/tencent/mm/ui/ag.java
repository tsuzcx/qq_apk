package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vp;
import com.tencent.mm.sdk.b.a;

public final class ag
{
  public static void cG(int paramInt, String paramString)
  {
    AppMethodBeat.i(141491);
    if (a.ESL != null)
    {
      vp localvp = new vp();
      localvp.dBf.className = paramString;
      localvp.dBf.dBg = paramInt;
      a.ESL.l(localvp);
    }
    AppMethodBeat.o(141491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.ag
 * JD-Core Version:    0.7.0.1
 */