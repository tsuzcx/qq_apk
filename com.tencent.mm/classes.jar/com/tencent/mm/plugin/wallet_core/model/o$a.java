package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;

final class o$a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
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
        return false;
        if (paramContext.equals("//cleanpaycn")) {
          i = 0;
        }
        break;
      }
    }
    com.tencent.mm.wallet_core.c.a.cMr();
    com.tencent.mm.wallet_core.c.a.clean();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.o.a
 * JD-Core Version:    0.7.0.1
 */