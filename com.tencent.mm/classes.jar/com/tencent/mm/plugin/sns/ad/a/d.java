package com.tencent.mm.plugin.sns.ad.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d
{
  public String DrP;
  public String DrQ;
  public List<String> DrR;
  public List<e> DrS;
  public String finderEncryptedTopicId;
  public String finderTopicName;
  
  public static d w(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(201852);
    if (c.isEmpty(paramMap))
    {
      AppMethodBeat.o(201852);
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
        AppMethodBeat.o(201852);
        return null;
      }
      d locald = new d();
      locald.finderEncryptedTopicId = str1;
      locald.finderTopicName = str2;
      locald.DrP = Util.nullAsNil((String)paramMap.get(paramString + ".finderTopicTitle"));
      locald.DrQ = Util.nullAsNil((String)paramMap.get(paramString + ".relationText"));
      locald.DrR = x(paramMap, paramString + ".relationAvatarList");
      locald.DrS = y(paramMap, paramString + ".finderTopicResList");
      AppMethodBeat.o(201852);
      return locald;
    }
    catch (Throwable paramMap)
    {
      AppMethodBeat.o(201852);
    }
    return null;
  }
  
  private static List<String> x(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(201853);
    String str = (String)paramMap.get(paramString + ".avatar");
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(201853);
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
    AppMethodBeat.o(201853);
    return localArrayList;
  }
  
  private static List<e> y(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(201854);
    e locale = e.z(paramMap, paramString + ".finderTopicResInfo");
    if (locale == null)
    {
      AppMethodBeat.o(201854);
      return null;
    }
    ArrayList localArrayList = new ArrayList(5);
    localArrayList.add(locale);
    int i = 1;
    while (i < 5)
    {
      locale = e.z(paramMap, paramString + ".finderTopicResInfo" + i);
      if (locale == null) {
        break;
      }
      localArrayList.add(locale);
      i += 1;
    }
    AppMethodBeat.o(201854);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.a.d
 * JD-Core Version:    0.7.0.1
 */