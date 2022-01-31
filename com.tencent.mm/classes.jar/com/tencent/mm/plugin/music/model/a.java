package com.tencent.mm.plugin.music.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.LinkedList;

public final class a
{
  public String album;
  public String giq;
  private int jQL = 0;
  public ArrayList<a.a> mzk = new ArrayList();
  public LinkedList<Long> mzl = new LinkedList();
  public String mzm;
  public String mzn;
  public String mzo;
  private boolean mzp = false;
  public long pj;
  public String title;
  
  public static long Jy(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = paramString.split(":");
        int k = d.Jz(paramString[0]);
        if (paramString.length <= 1) {
          break label119;
        }
        paramString = paramString[1].split("\\.");
        j = d.Jz(paramString[0]);
        if (paramString.length > 1)
        {
          i = d.Jz(paramString[1]);
          long l1 = k;
          long l2 = j * 1000;
          return i * 10 + (l2 + l1 * 60L * 1000L);
        }
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.Music.LyricObj", paramString, "", new Object[0]);
        y.w("MicroMsg.Music.LyricObj", "strToLong error: %s", new Object[] { paramString.getLocalizedMessage() });
        return 0L;
      }
      int i = 0;
      continue;
      label119:
      i = 0;
      int j = 0;
    }
  }
  
  public static String ee(String paramString1, String paramString2)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2))) {
      return paramString1;
    }
    if (paramString2.length() >= paramString1.length() - 1) {
      return "";
    }
    String str = paramString1.substring(paramString2.length(), paramString1.length() - 1);
    y.d("MicroMsg.Music.LyricObj", "str[%s] prefix[%s] attr[%s]", new Object[] { paramString1, paramString2, str });
    return str;
  }
  
  public final a.a uN(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mzk.size())) {
      return null;
    }
    return (a.a)this.mzk.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a
 * JD-Core Version:    0.7.0.1
 */