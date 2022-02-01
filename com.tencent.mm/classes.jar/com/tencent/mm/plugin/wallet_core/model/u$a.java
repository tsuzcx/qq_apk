package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.wallet_core.c.b;

final class u$a
  implements a
{
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(70382);
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
        AppMethodBeat.o(70382);
        return false;
        if (paramContext.equals("//cleanpaycn")) {
          i = 0;
        }
        break;
      }
    }
    b.iiL();
    b.clean();
    AppMethodBeat.o(70382);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.u.a
 * JD-Core Version:    0.7.0.1
 */