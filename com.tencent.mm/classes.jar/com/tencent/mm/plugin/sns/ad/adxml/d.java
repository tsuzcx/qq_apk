package com.tencent.mm.plugin.sns.ad.adxml;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class d
{
  public String Jxv;
  public String Jxw;
  public String Jyj;
  public String Jyk;
  public List<String> Jyl;
  public List<e> Jym;
  
  public static d x(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(262465);
    if (com.tencent.mm.plugin.sns.ad.i.d.isEmpty(paramMap))
    {
      AppMethodBeat.o(262465);
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
        AppMethodBeat.o(262465);
        return null;
      }
      d locald = new d();
      locald.Jxv = str1;
      locald.Jxw = str2;
      locald.Jyj = Util.nullAsNil((String)paramMap.get(paramString + ".finderTopicTitle"));
      locald.Jyk = Util.nullAsNil((String)paramMap.get(paramString + ".relationText"));
      locald.Jyl = y(paramMap, paramString + ".relationAvatarList");
      locald.Jym = z(paramMap, paramString + ".finderTopicResList");
      AppMethodBeat.o(262465);
      return locald;
    }
    catch (Throwable paramMap)
    {
      AppMethodBeat.o(262465);
    }
    return null;
  }
  
  private static List<String> y(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(262468);
    String str = (String)paramMap.get(paramString + ".avatar");
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(262468);
      return null;
    }
    ArrayList localArrayList = new ArrayList(10);
    localArrayList.add(str);
    int i = 1;
    while ((!TextUtils.isEmpty((CharSequence)paramMap.get(paramString + ".avatar" + i))) && (i < 10))
    {
      localArrayList.add(paramMap.get(paramString + ".avatar" + i));
      i += 1;
    }
    AppMethodBeat.o(262468);
    return localArrayList;
  }
  
  private static List<e> z(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(262470);
    e locale = e.A(paramMap, paramString + ".finderTopicResInfo");
    if (locale == null)
    {
      AppMethodBeat.o(262470);
      return null;
    }
    ArrayList localArrayList = new ArrayList(5);
    localArrayList.add(locale);
    int i = 1;
    while (i < 5)
    {
      locale = e.A(paramMap, paramString + ".finderTopicResInfo" + i);
      if (locale == null) {
        break;
      }
      localArrayList.add(locale);
      i += 1;
    }
    AppMethodBeat.o(262470);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.d
 * JD-Core Version:    0.7.0.1
 */