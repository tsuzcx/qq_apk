package com.tencent.mm.plugin.sns.ad.adxml;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class c
{
  public String Jyd;
  public String Jye;
  public String finderLiveId;
  public String finderUsername;
  
  public static c w(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(266489);
    if (d.isEmpty(paramMap))
    {
      AppMethodBeat.o(266489);
      return null;
    }
    String str = (String)paramMap.get(paramString + ".finderUsername");
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(266489);
      return null;
    }
    try
    {
      c localc = new c();
      localc.finderUsername = Util.nullAsNil(str);
      localc.finderLiveId = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveId"));
      localc.Jyd = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveFeedExportId"));
      localc.Jye = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveFeedNonceId"));
      AppMethodBeat.o(266489);
      return localc;
    }
    catch (Throwable paramMap)
    {
      AppMethodBeat.o(266489);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.c
 * JD-Core Version:    0.7.0.1
 */