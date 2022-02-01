package com.tencent.mm.plugin.sns.ad.widget.shakead;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.p;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.Serializable;
import java.util.Map;

public class a
  implements Serializable
{
  public int PRS;
  public int PRT;
  public int QhU;
  public int QhV;
  public int QhW;
  public int QhX;
  @p(hkF=2)
  public String QhY;
  public String QhZ;
  @p(hkF=2)
  public String Qia;
  public String Qib;
  public String desc;
  public String title;
  
  public static a ad(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(310549);
    int k;
    int m;
    int i;
    int j;
    if (paramMap.containsKey(paramString))
    {
      k = Util.safeParseInt((String)paramMap.get(paramString + ".shakeStartTime"));
      m = Util.safeParseInt((String)paramMap.get(paramString + ".shakeEndTime"));
      i = Util.safeParseInt((String)paramMap.get(paramString + ".coverStartTime"));
      j = Util.safeParseInt((String)paramMap.get(paramString + ".coverEndTime"));
      if (i != 0) {
        break label537;
      }
      i = k;
    }
    label537:
    for (;;)
    {
      if (j == 0) {
        j = m;
      }
      for (;;)
      {
        if ((k >= 0) && (m > k) && (j >= i) && (i >= k) && (j <= m))
        {
          String str1 = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
          String str2 = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
          a locala = new a();
          locala.QhU = k;
          locala.QhV = m;
          locala.QhW = i;
          locala.QhX = j;
          locala.title = str1;
          locala.desc = str2;
          locala.QhY = Util.nullAsNil((String)paramMap.get(paramString + ".simpleTransitionAnimationUrl"));
          locala.QhZ = Util.nullAsNil((String)paramMap.get(paramString + ".simpleTransitionAnimationMD5"));
          locala.Qia = Util.nullAsNil((String)paramMap.get(paramString + ".themePAGUrl"));
          locala.Qib = Util.nullAsNil((String)paramMap.get(paramString + ".themePAGMD5"));
          locala.PRS = Util.safeParseInt((String)paramMap.get(paramString + ".triggerGForceMin"));
          locala.PRT = Util.safeParseInt((String)paramMap.get(paramString + ".triggerGForceMax"));
          AppMethodBeat.o(310549);
          return locala;
        }
        AppMethodBeat.o(310549);
        return null;
      }
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(310556);
    String str = "{shakeStartTime=" + this.QhU + ", shakeEndTime=" + this.QhV + ", coverStartTime=" + this.QhW + ", coverEndTime=" + this.QhX + ", title=" + this.title + ", desc=" + this.desc + ", simpleTransitionAnimationUrl=" + this.QhY + ", simpleTransitionAnimationMD5=" + this.QhZ + ", themePAGUrl=" + this.Qia + ", themePAGMD5=" + this.Qib + '}';
    AppMethodBeat.o(310556);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.shakead.a
 * JD-Core Version:    0.7.0.1
 */