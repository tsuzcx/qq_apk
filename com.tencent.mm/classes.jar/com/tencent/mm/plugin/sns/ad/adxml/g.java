package com.tencent.mm.plugin.sns.ad.adxml;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class g
{
  public String Jyr;
  public List<String> Jys;
  public List<String> Jyt;
  public List<String> Jyu;
  public boolean Jyv;
  public float Jyw;
  public List<a> Jyx;
  public String finderLiveId;
  public String finderUsername;
  public int liveType;
  
  public static g C(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(196208);
    if (d.isEmpty(paramMap))
    {
      AppMethodBeat.o(196208);
      return null;
    }
    String str = (String)paramMap.get(paramString + ".liveType");
    if (str == null)
    {
      AppMethodBeat.o(196208);
      return null;
    }
    try
    {
      g localg = new g();
      localg.liveType = Util.safeParseInt(str);
      localg.Jyr = Util.nullAsNil((String)paramMap.get(paramString + ".liveParams"));
      localg.finderUsername = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
      localg.finderLiveId = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveId"));
      localg.Jys = D(paramMap, paramString + ".pendingDescList");
      localg.Jyt = D(paramMap, paramString + ".livingDescList");
      localg.Jyu = D(paramMap, paramString + ".endDescList");
      if (Util.safeParseInt((String)paramMap.get(paramString + ".showLikeAnimation")) > 0) {}
      for (boolean bool = true;; bool = false)
      {
        localg.Jyv = bool;
        localg.Jyw = Util.safeParseFloat((String)paramMap.get(paramString + ".likeAnimationInterval"));
        localg.Jyx = E(paramMap, paramString + ".liveCheerIconList");
        AppMethodBeat.o(196208);
        return localg;
      }
      return null;
    }
    catch (Throwable paramMap)
    {
      AppMethodBeat.o(196208);
    }
  }
  
  private static List<String> D(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(196213);
    if (d.isEmpty(paramMap))
    {
      AppMethodBeat.o(196213);
      return null;
    }
    String str = (String)paramMap.get(paramString + ".descText");
    if (str == null)
    {
      AppMethodBeat.o(196213);
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
    AppMethodBeat.o(196213);
    return localArrayList;
  }
  
  private static List<a> E(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(196221);
    ArrayList localArrayList = new ArrayList();
    if (d.isEmpty(paramMap))
    {
      AppMethodBeat.o(196221);
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
    AppMethodBeat.o(196221);
    return localArrayList;
  }
  
  public static final class a
  {
    public String iconUrl;
    public int sampleRate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.g
 * JD-Core Version:    0.7.0.1
 */