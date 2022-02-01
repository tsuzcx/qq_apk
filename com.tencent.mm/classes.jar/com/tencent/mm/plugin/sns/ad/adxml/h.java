package com.tencent.mm.plugin.sns.ad.adxml;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class h
{
  public String finderUsername;
  public String hAx;
  public String objectNonceId;
  
  public static h N(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(309839);
    if ((d.isEmpty(paramMap)) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(309839);
      return null;
    }
    try
    {
      h localh = new h();
      localh.finderUsername = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
      localh.hAx = Util.nullAsNil((String)paramMap.get(paramString + ".exportId"));
      localh.objectNonceId = Util.nullAsNil((String)paramMap.get(paramString + ".objectNonceId"));
      return localh;
    }
    finally
    {
      AppMethodBeat.o(309839);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.h
 * JD-Core Version:    0.7.0.1
 */