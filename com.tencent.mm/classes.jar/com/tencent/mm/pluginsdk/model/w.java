package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.x5.sdk.d;
import java.util.HashMap;
import java.util.Map;

public final class w
{
  private static final Map<String, Object> FeQ;
  
  static
  {
    AppMethodBeat.i(133686);
    FeQ = new HashMap();
    AppMethodBeat.o(133686);
  }
  
  public static void x(String paramString, Object paramObject)
  {
    AppMethodBeat.i(133685);
    FeQ.put(paramString, paramObject);
    d.initTbsSettings(FeQ);
    AppMethodBeat.o(133685);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.w
 * JD-Core Version:    0.7.0.1
 */