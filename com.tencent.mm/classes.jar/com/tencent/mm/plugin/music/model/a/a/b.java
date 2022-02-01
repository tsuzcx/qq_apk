package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.f;
import com.tencent.mm.plugin.music.logic.a;
import com.tencent.mm.plugin.music.logic.j;
import com.tencent.mm.sdk.platformtools.MD5Util;

public final class b
{
  public static String aPd(String paramString)
  {
    AppMethodBeat.i(63092);
    f localf = j.gnw().LLw.gng();
    if ((localf == null) || (!paramString.equalsIgnoreCase(localf.oOv)))
    {
      paramString = "0_" + MD5Util.getMD5String(paramString);
      AppMethodBeat.o(63092);
      return paramString;
    }
    paramString = com.tencent.mm.plugin.music.h.b.Y(localf);
    AppMethodBeat.o(63092);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.b
 * JD-Core Version:    0.7.0.1
 */