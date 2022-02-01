package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class e
{
  public String description;
  public String iconUrl;
  public String title;
  
  public static e ar(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(306595);
    if ((d.isEmpty(paramMap)) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(306595);
      return null;
    }
    if (!paramMap.containsKey(paramString))
    {
      AppMethodBeat.o(306595);
      return null;
    }
    try
    {
      e locale = new e();
      locale.title = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
      locale.description = Util.nullAsNil((String)paramMap.get(paramString + ".description"));
      locale.iconUrl = Util.nullAsNil((String)paramMap.get(paramString + ".iconUrl"));
      boolean bool = Util.isNullOrNil(locale.description);
      if (bool) {
        return null;
      }
      return locale;
    }
    finally
    {
      AppMethodBeat.o(306595);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.e
 * JD-Core Version:    0.7.0.1
 */