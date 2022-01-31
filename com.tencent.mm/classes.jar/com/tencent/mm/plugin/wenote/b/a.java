package com.tencent.mm.plugin.wenote.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.d;
import java.util.Map;

public final class a
{
  public static boolean djK()
  {
    AppMethodBeat.i(26976);
    String str = (String)com.tencent.mm.model.c.c.abU().me("100352").dvN().get("Close");
    if (!bo.isNullOrNil(str)) {}
    for (int i = bo.getInt(str, 0);; i = 0)
    {
      if (i == 0)
      {
        AppMethodBeat.o(26976);
        return true;
      }
      AppMethodBeat.o(26976);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.b.a
 * JD-Core Version:    0.7.0.1
 */