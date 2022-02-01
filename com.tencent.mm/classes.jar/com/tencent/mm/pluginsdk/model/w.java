package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.x5.sdk.d;
import java.util.HashMap;
import java.util.Map;

public final class w
{
  private static final Map<String, Object> DhH;
  
  static
  {
    AppMethodBeat.i(133686);
    DhH = new HashMap();
    AppMethodBeat.o(133686);
  }
  
  public static void z(String paramString, Object paramObject)
  {
    AppMethodBeat.i(133685);
    DhH.put(paramString, paramObject);
    d.initTbsSettings(DhH);
    AppMethodBeat.o(133685);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.w
 * JD-Core Version:    0.7.0.1
 */