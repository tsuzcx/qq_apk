package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.wallet_core.c.b;

final class t$a
  implements a
{
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(46865);
    paramContext = paramArrayOfString[0];
    int i = -1;
    switch (paramContext.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(46865);
        return false;
        if (paramContext.equals("//cleanpaycn")) {
          i = 0;
        }
        break;
      }
    }
    b.dSi();
    b.clean();
    AppMethodBeat.o(46865);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.t.a
 * JD-Core Version:    0.7.0.1
 */