package com.tencent.mm.plugin.sns.ad.adxml;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.p;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class k
{
  public List<String> PMW;
  @p(hkF=1)
  public String iconUrl;
  
  public static k S(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(309843);
    if (d.isEmpty(paramMap))
    {
      AppMethodBeat.o(309843);
      return null;
    }
    try
    {
      String str = Util.nullAsNil((String)paramMap.get(paramString + ".iconUrl"));
      paramMap = T(paramMap, paramString + ".textList");
      if (!d.isEmpty(paramMap))
      {
        paramString = new k();
        paramString.iconUrl = str;
        paramString.PMW = paramMap;
        return paramString;
      }
    }
    finally
    {
      AppMethodBeat.o(309843);
    }
    return null;
  }
  
  private static List<String> T(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(309847);
    ArrayList localArrayList = new ArrayList();
    if (d.isEmpty(paramMap))
    {
      AppMethodBeat.o(309847);
      return localArrayList;
    }
    String str1 = paramString + ".text";
    int i = 0;
    paramString = str1;
    if (i > 0) {
      paramString = str1 + i;
    }
    for (;;)
    {
      if (paramMap.containsKey(paramString))
      {
        String str2 = (String)paramMap.get(paramString);
        if (!Util.isNullOrNil(str2)) {
          localArrayList.add(str2);
        }
        i += 1;
        break;
      }
      AppMethodBeat.o(309847);
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.k
 * JD-Core Version:    0.7.0.1
 */