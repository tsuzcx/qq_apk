package com.tencent.mm.plugin.sns.ad.widget.shakead;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.Serializable;
import java.util.Map;

public class a
  implements Serializable
{
  public int JNu;
  public int JNv;
  public int JNw;
  public int JNx;
  public String JNy;
  public String JNz;
  public String desc;
  public String title;
  
  public static a M(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(221348);
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
        break label393;
      }
      i = k;
    }
    label393:
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
          locala.JNu = k;
          locala.JNv = m;
          locala.JNw = i;
          locala.JNx = j;
          locala.title = str1;
          locala.desc = str2;
          locala.JNy = Util.nullAsNil((String)paramMap.get(paramString + ".simpleTransitionAnimationUrl"));
          locala.JNz = Util.nullAsNil((String)paramMap.get(paramString + ".simpleTransitionAnimationMD5"));
          AppMethodBeat.o(221348);
          return locala;
        }
        AppMethodBeat.o(221348);
        return null;
      }
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(221354);
    String str = "{shakeStartTime=" + this.JNu + ", shakeEndTime=" + this.JNv + ", coverStartTime=" + this.JNw + ", coverEndTime=" + this.JNx + ", title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + ", simpleTransitionAnimationUrl='" + this.JNy + '\'' + ", simpleTransitionAnimationMD5='" + this.JNz + '\'' + '}';
    AppMethodBeat.o(221354);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.shakead.a
 * JD-Core Version:    0.7.0.1
 */