package com.tencent.mm.plugin.sns.ad.adxml;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class j
{
  public String PMS;
  public int PMT;
  public String PMU;
  public String PMV;
  public long endTime;
  public String qWk;
  public long startTime;
  
  public static j R(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(309846);
    if (d.isEmpty(paramMap))
    {
      AppMethodBeat.o(309846);
      return null;
    }
    Object localObject = (String)paramMap.get(paramString + ".endTime");
    long l = Util.safeParseLong((String)localObject);
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (l == 0L))
    {
      AppMethodBeat.o(309846);
      return null;
    }
    localObject = new j();
    ((j)localObject).endTime = (l * 1000L);
    ((j)localObject).startTime = (Util.safeParseLong((String)paramMap.get(paramString + ".startTime")) * 1000L);
    ((j)localObject).qWk = Util.nullAs((String)paramMap.get(paramString + ".barBgColor"), "");
    ((j)localObject).PMS = Util.nullAs((String)paramMap.get(paramString + ".barBgAlpha"), "");
    ((j)localObject).PMT = Util.safeParseInt((String)paramMap.get(paramString + ".leftTitleType"));
    ((j)localObject).PMU = Util.nullAs((String)paramMap.get(paramString + ".leftTitle"), "");
    ((j)localObject).PMV = Util.nullAs((String)paramMap.get(paramString + ".rightTitle"), "");
    AppMethodBeat.o(309846);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.j
 * JD-Core Version:    0.7.0.1
 */