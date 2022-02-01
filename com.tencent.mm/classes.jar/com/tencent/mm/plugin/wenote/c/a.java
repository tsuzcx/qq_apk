package com.tencent.mm.plugin.wenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class a
{
  public static boolean gkd()
  {
    AppMethodBeat.i(30670);
    String str = (String)com.tencent.mm.model.c.d.aXu().Fu("100352").gzz().get("Close");
    if (!Util.isNullOrNil(str)) {}
    for (int i = Util.getInt(str, 0);; i = 0)
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