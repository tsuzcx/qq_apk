package com.tencent.mm.plugin.sns.ad.adxml;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class f
{
  public String finderUsername;
  public String fwa;
  public String objectNonceId;
  
  public static f B(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(219323);
    if ((d.isEmpty(paramMap)) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(219323);
      return null;
    }
    try
    {
      f localf = new f();
      localf.finderUsername = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
      localf.fwa = Util.nullAsNil((String)paramMap.get(paramString + ".exportId"));
      localf.objectNonceId = Util.nullAsNil((String)paramMap.get(paramString + ".objectNonceId"));
      AppMethodBeat.o(219323);
      return localf;
    }
    catch (Throwable paramMap)
    {
      AppMethodBeat.o(219323);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.f
 * JD-Core Version:    0.7.0.1
 */