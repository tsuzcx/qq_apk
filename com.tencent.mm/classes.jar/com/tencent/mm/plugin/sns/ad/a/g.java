package com.tencent.mm.plugin.sns.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class g
{
  public String DrY;
  public List<String> DrZ;
  public List<String> Dsa;
  public List<String> Dsb;
  public String finderLiveId;
  public String finderUsername;
  public int liveType;
  
  public static g B(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(201857);
    if (c.isEmpty(paramMap))
    {
      AppMethodBeat.o(201857);
      return null;
    }
    String str = (String)paramMap.get(paramString + ".liveType");
    if (str == null)
    {
      AppMethodBeat.o(201857);
      return null;
    }
    try
    {
      g localg = new g();
      localg.liveType = Util.safeParseInt(str);
      localg.DrY = Util.nullAsNil((String)paramMap.get(paramString + ".liveParams"));
      localg.finderUsername = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
      localg.finderLiveId = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveId"));
      localg.DrZ = C(paramMap, paramString + ".pendingDescList");
      localg.Dsa = C(paramMap, paramString + ".livingDescList");
      localg.Dsb = C(paramMap, paramString + ".endDescList");
      AppMethodBeat.o(201857);
      return localg;
    }
    catch (Throwable paramMap)
    {
      AppMethodBeat.o(201857);
    }
    return null;
  }
  
  private static List<String> C(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(201858);
    if (c.isEmpty(paramMap))
    {
      AppMethodBeat.o(201858);
      return null;
    }
    String str = (String)paramMap.get(paramString + ".descText");
    if (str == null)
    {
      AppMethodBeat.o(201858);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(str);
    int i = 1;
    for (;;)
    {
      str = (String)paramMap.get(paramString + ".descText" + i);
      if (str == null) {
        break;
      }
      localArrayList.add(str);
      i += 1;
    }
    AppMethodBeat.o(201858);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.a.g
 * JD-Core Version:    0.7.0.1
 */