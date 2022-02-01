package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.p;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class g
{
  @p(hkF=1)
  public String QYg;
  public String QYh;
  public String QYi;
  public String QYj;
  public String QYk;
  public String QYl;
  public String QYm;
  public String QYn;
  public String QYo;
  public String QYp;
  @p(hkF=2)
  public String QYq;
  public String QYr;
  
  public static g as(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(306585);
    if ((d.isEmpty(paramMap)) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(306585);
      return null;
    }
    if (!paramMap.containsKey(paramString))
    {
      AppMethodBeat.o(306585);
      return null;
    }
    try
    {
      String str1 = Util.nullAsNil((String)paramMap.get(paramString + ".cheerIcon"));
      String str2 = Util.nullAsNil((String)paramMap.get(paramString + ".cheerText.zh"));
      String str3 = Util.nullAsNil((String)paramMap.get(paramString + ".cheerText.tw"));
      String str4 = Util.nullAsNil((String)paramMap.get(paramString + ".cheerText.en"));
      String str5 = Util.nullAsNil((String)paramMap.get(paramString + ".cheerFinishText.zh"));
      String str6 = Util.nullAsNil((String)paramMap.get(paramString + ".cheerFinishText.tw"));
      String str7 = Util.nullAsNil((String)paramMap.get(paramString + ".cheerFinishText.en"));
      String str8 = Util.nullAsNil((String)paramMap.get(paramString + ".commentText.zh"));
      String str9 = Util.nullAsNil((String)paramMap.get(paramString + ".commentText.tw"));
      String str10 = Util.nullAsNil((String)paramMap.get(paramString + ".commentText.en"));
      if (!Util.isNullOrNil(new String[] { str1, str2, str3, str4, str5, str6, str7, str8, str9, str10 }))
      {
        g localg = new g();
        localg.QYg = str1;
        localg.QYh = str2;
        localg.QYi = str3;
        localg.QYj = str4;
        localg.QYk = str5;
        localg.QYl = str6;
        localg.QYm = str7;
        localg.QYn = str8;
        localg.QYo = str9;
        localg.QYp = str10;
        localg.QYq = Util.nullAsNil((String)paramMap.get(paramString + ".pagAnimationUrl"));
        localg.QYr = Util.nullAsNil((String)paramMap.get(paramString + ".pagAnimationMD5"));
        return localg;
      }
    }
    finally
    {
      AppMethodBeat.o(306585);
    }
    return null;
  }
  
  public static final class a
  {
    public String QYk = "";
    public String QYn = "";
    public String QYs = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.g
 * JD-Core Version:    0.7.0.1
 */