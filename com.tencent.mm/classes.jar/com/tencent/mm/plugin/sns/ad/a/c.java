package com.tencent.mm.plugin.sns.ad.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class c
{
  public String finderLiveFeedExportId;
  public String finderLiveFeedNonceId;
  public String finderLiveId;
  public String finderUsername;
  
  public static c v(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(201851);
    if (com.tencent.mm.plugin.sns.ad.i.c.isEmpty(paramMap))
    {
      AppMethodBeat.o(201851);
      return null;
    }
    String str = (String)paramMap.get(paramString + ".finderUsername");
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(201851);
      return null;
    }
    try
    {
      c localc = new c();
      localc.finderUsername = Util.nullAsNil(str);
      localc.finderLiveId = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveId"));
      localc.finderLiveFeedExportId = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveFeedExportId"));
      localc.finderLiveFeedNonceId = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveFeedNonceId"));
      AppMethodBeat.o(201851);
      return localc;
    }
    catch (Throwable paramMap)
    {
      AppMethodBeat.o(201851);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.a.c
 * JD-Core Version:    0.7.0.1
 */