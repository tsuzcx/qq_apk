package com.tencent.mm.protocal;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
{
  public String host = "";
  public String lCF = "";
  private int port = 80;
  private int type = 0;
  
  public n() {}
  
  public n(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this.type = paramInt1;
    this.lCF = paramString1;
    this.port = paramInt2;
    this.host = paramString2;
  }
  
  private static n Xr(String paramString)
  {
    paramString = paramString.split(",");
    if (paramString.length < 4) {
      return null;
    }
    n localn = new n();
    try
    {
      localn.type = bk.getInt(paramString[0], 0);
      localn.lCF = bk.pm(paramString[1]);
      localn.port = bk.getInt(paramString[2], 0);
      localn.host = bk.pm(paramString[3]);
      return localn;
    }
    catch (NumberFormatException paramString)
    {
      y.e("MicroMsg.MMBuiltInIP", "exception:%s", new Object[] { bk.j(paramString) });
    }
    return null;
  }
  
  public static List<n> Xs(String paramString)
  {
    localLinkedList = new LinkedList();
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return localLinkedList;
      try
      {
        String[] arrayOfString = paramString.split("\\|");
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          n localn = Xr(arrayOfString[i]);
          if (localn != null) {
            localLinkedList.add(localn);
          }
          i += 1;
        }
        return localLinkedList;
      }
      catch (Exception localException)
      {
        y.d("MicroMsg.MMBuiltInIP", "unserialize split failed str[%s]", new Object[] { paramString });
        y.e("MicroMsg.MMBuiltInIP", "exception:%s", new Object[] { bk.j(localException) });
      }
    }
  }
  
  public static String di(List<n> paramList)
  {
    Iterator localIterator = paramList.iterator();
    n localn;
    for (paramList = ""; localIterator.hasNext(); paramList = paramList + localn.toString() + "|") {
      localn = (n)localIterator.next();
    }
    return paramList;
  }
  
  public static a ga(String paramString1, String paramString2)
  {
    y.d("MicroMsg.MMBuiltInIP", "parsing network control params:");
    y.d("MicroMsg.MMBuiltInIP", "ports = " + paramString1);
    y.d("MicroMsg.MMBuiltInIP", "timeouts = " + paramString2);
    int[] arrayOfInt = bk.ZN(paramString1);
    paramString2 = bk.ZN(paramString2);
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramString2.length >= 2) {}
    }
    else
    {
      paramString1 = new int[2];
      paramString1[0] = 0;
      paramString1[1] = 0;
      paramString1;
      y.e("MicroMsg.MMBuiltInIP", "invalid timeouts");
    }
    return new a(arrayOfInt, (int)(paramString1[0] * 1000L), (int)(paramString1[1] * 1000L));
  }
  
  public final String toString()
  {
    return this.type + "," + this.lCF + "," + this.port + "," + this.host;
  }
  
  public static final class a
  {
    public final int[] spU = null;
    public final int[] spV;
    public final int spW;
    public final int spX;
    
    public a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      this.spV = paramArrayOfInt;
      this.spW = paramInt1;
      this.spX = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.n
 * JD-Core Version:    0.7.0.1
 */