package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.util.c;
import com.tencent.xweb.x5.sdk.d;
import java.util.HashMap;
import java.util.Map;

public final class u
{
  private static final Map<String, Object> vKP;
  
  static
  {
    AppMethodBeat.i(114675);
    vKP = new HashMap();
    AppMethodBeat.o(114675);
  }
  
  public static void s(String paramString, Object paramObject)
  {
    AppMethodBeat.i(114674);
    vKP.put(paramString, paramObject);
    d.initTbsSettings(vKP);
    AppMethodBeat.o(114674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.u
 * JD-Core Version:    0.7.0.1
 */