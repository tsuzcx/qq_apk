package com.tencent.mm.plugin.wenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class a
{
  public static boolean eIs()
  {
    AppMethodBeat.i(30670);
    String str = (String)com.tencent.mm.model.c.d.aAp().tJ("100352").eYV().get("Close");
    if (!bs.isNullOrNil(str)) {}
    for (int i = bs.getInt(str, 0);; i = 0)
    {
      if (i == 0)
      {
        AppMethodBeat.o(30670);
        return true;
      }
      AppMethodBeat.o(30670);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.c.a
 * JD-Core Version:    0.7.0.1
 */