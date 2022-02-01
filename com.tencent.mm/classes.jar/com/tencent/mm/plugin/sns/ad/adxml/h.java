package com.tencent.mm.plugin.sns.ad.adxml;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class h
{
  public String JyA;
  public String JyB;
  public String Jyy;
  public int Jyz;
  public long endTime;
  public String nWx;
  public long startTime;
  
  public static h F(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(266141);
    if (d.isEmpty(paramMap))
    {
      AppMethodBeat.o(266141);
      return null;
    }
    Object localObject = (String)paramMap.get(paramString + ".endTime");
    long l = Util.safeParseLong((String)localObject);
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (l == 0L))
    {
      AppMethodBeat.o(266141);
      return null;
    }
    localObject = new h();
    ((h)localObject).endTime = (l * 1000L);
    ((h)localObject).startTime = (Util.safeParseLong((String)paramMap.get(paramString + ".startTime")) * 1000L);
    ((h)localObject).nWx = Util.nullAs((String)paramMap.get(paramString + ".barBgColor"), "");
    ((h)localObject).Jyy = Util.nullAs((String)paramMap.get(paramString + ".barBgAlpha"), "");
    ((h)localObject).Jyz = Util.safeParseInt((String)paramMap.get(paramString + ".leftTitleType"));
    ((h)localObject).JyA = Util.nullAs((String)paramMap.get(paramString + ".leftTitle"), "");
    ((h)localObject).JyB = Util.nullAs((String)paramMap.get(paramString + ".rightTitle"), "");
    AppMethodBeat.o(266141);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.h
 * JD-Core Version:    0.7.0.1
 */