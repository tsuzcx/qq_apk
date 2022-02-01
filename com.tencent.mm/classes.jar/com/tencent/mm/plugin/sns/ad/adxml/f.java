package com.tencent.mm.plugin.sns.ad.adxml;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class f
{
  public String PLk;
  public String PLl;
  public String PMD;
  public String PME;
  public List<String> PMF;
  public List<g> PMG;
  
  public static f J(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(309838);
    if (d.isEmpty(paramMap))
    {
      AppMethodBeat.o(309838);
      return null;
    }
    try
    {
      String str1 = (String)paramMap.get(paramString + ".finderEncryptedTopicId");
      String str2 = (String)paramMap.get(paramString + ".finderTopicName");
      if (!TextUtils.isEmpty(str1))
      {
        boolean bool = TextUtils.isEmpty(str2);
        if (!bool) {}
      }
      else
      {
        return null;
      }
      f localf = new f();
      localf.PLk = str1;
      localf.PLl = str2;
      localf.PMD = Util.nullAsNil((String)paramMap.get(paramString + ".finderTopicTitle"));
      localf.PME = Util.nullAsNil((String)paramMap.get(paramString + ".relationText"));
      localf.PMF = K(paramMap, paramString + ".relationAvatarList");
      localf.PMG = L(paramMap, paramString + ".finderTopicResList");
      return localf;
    }
    finally
    {
      AppMethodBeat.o(309838);
    }
    return null;
  }
  
  private static List<String> K(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(309840);
    String str = (String)paramMap.get(paramString + ".avatar");
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(309840);
      return null;
    }
    ArrayList localArrayList = new ArrayList(10);
    localArrayList.add(str);
    int i = 1;
    while ((!TextUtils.isEmpty((CharSequence)paramMap.get(paramString + ".avatar" + i))) && (i < 10))
    {
      localArrayList.add((String)paramMap.get(paramString + ".avatar" + i));
      i += 1;
    }
    AppMethodBeat.o(309840);
    return localArrayList;
  }
  
  private static List<g> L(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(309844);
    g localg = g.M(paramMap, paramString + ".finderTopicResInfo");
    if (localg == null)
    {
      AppMethodBeat.o(309844);
      return null;
    }
    ArrayList localArrayList = new ArrayList(5);
    localArrayList.add(localg);
    int i = 1;
    while (i < 5)
    {
      localg = g.M(paramMap, paramString + ".finderTopicResInfo" + i);
      if (localg == null) {
        break;
      }
      localArrayList.add(localg);
      i += 1;
    }
    AppMethodBeat.o(309844);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.f
 * JD-Core Version:    0.7.0.1
 */