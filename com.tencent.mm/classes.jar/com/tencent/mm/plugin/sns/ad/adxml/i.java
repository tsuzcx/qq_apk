package com.tencent.mm.plugin.sns.ad.adxml;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class i
{
  public String PML;
  public List<String> PMM;
  public List<String> PMN;
  public List<String> PMO;
  public boolean PMP;
  public float PMQ;
  public List<a> PMR;
  public String finderLiveId;
  public String finderUsername;
  public int liveType;
  
  public static i O(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(309848);
    if (d.isEmpty(paramMap))
    {
      AppMethodBeat.o(309848);
      return null;
    }
    String str = (String)paramMap.get(paramString + ".liveType");
    if (str == null)
    {
      AppMethodBeat.o(309848);
      return null;
    }
    try
    {
      i locali = new i();
      locali.liveType = Util.safeParseInt(str);
      locali.PML = Util.nullAsNil((String)paramMap.get(paramString + ".liveParams"));
      locali.finderUsername = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
      locali.finderLiveId = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveId"));
      locali.PMM = P(paramMap, paramString + ".pendingDescList");
      locali.PMN = P(paramMap, paramString + ".livingDescList");
      locali.PMO = P(paramMap, paramString + ".endDescList");
      if (Util.safeParseInt((String)paramMap.get(paramString + ".showLikeAnimation")) > 0) {}
      for (boolean bool = true;; bool = false)
      {
        locali.PMP = bool;
        locali.PMQ = Util.safeParseFloat((String)paramMap.get(paramString + ".likeAnimationInterval"));
        locali.PMR = Q(paramMap, paramString + ".liveCheerIconList");
        return locali;
      }
      return null;
    }
    finally
    {
      AppMethodBeat.o(309848);
    }
  }
  
  private static List<String> P(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(309852);
    if (d.isEmpty(paramMap))
    {
      AppMethodBeat.o(309852);
      return null;
    }
    String str = (String)paramMap.get(paramString + ".descText");
    if (str == null)
    {
      AppMethodBeat.o(309852);
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
    AppMethodBeat.o(309852);
    return localArrayList;
  }
  
  private static List<a> Q(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(309859);
    ArrayList localArrayList = new ArrayList();
    if (d.isEmpty(paramMap))
    {
      AppMethodBeat.o(309859);
      return localArrayList;
    }
    Object localObject = paramString + ".iconInfo";
    int i = 0;
    while (paramMap.containsKey(localObject))
    {
      String str = Util.nullAsNil((String)paramMap.get((String)localObject + ".iconUrl"));
      int j = Util.safeParseInt((String)paramMap.get((String)localObject + ".sampleRate"));
      if ((!TextUtils.isEmpty(str)) && (j > 0) && (j <= 100))
      {
        localObject = new a();
        ((a)localObject).iconUrl = str;
        ((a)localObject).sampleRate = j;
        localArrayList.add(localObject);
      }
      i += 1;
      localObject = paramString + ".iconInfo" + i;
    }
    AppMethodBeat.o(309859);
    return localArrayList;
  }
  
  public static final class a
  {
    public String iconUrl;
    public int sampleRate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.i
 * JD-Core Version:    0.7.0.1
 */