package com.tencent.mm.plugin.sns.ad.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class f
{
  public String DrX;
  public String finderUsername;
  public String objectNonceId;
  
  public static f A(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(201856);
    if ((c.isEmpty(paramMap)) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(201856);
      return null;
    }
    try
    {
      f localf = new f();
      localf.finderUsername = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
      localf.DrX = Util.nullAsNil((String)paramMap.get(paramString + ".exportId"));
      localf.objectNonceId = Util.nullAsNil((String)paramMap.get(paramString + ".objectNonceId"));
      AppMethodBeat.o(201856);
      return localf;
    }
    catch (Throwable paramMap)
    {
      AppMethodBeat.o(201856);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.a.f
 * JD-Core Version:    0.7.0.1
 */