package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o
{
  public String host = "";
  private int port = 80;
  public String tWE = "";
  private int type = 0;
  
  public o() {}
  
  public o(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this.type = paramInt1;
    this.tWE = paramString1;
    this.port = paramInt2;
    this.host = paramString2;
  }
  
  public static List<o> aIA(String paramString)
  {
    AppMethodBeat.i(133105);
    localLinkedList = new LinkedList();
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(133105);
      return localLinkedList;
    }
    try
    {
      String[] arrayOfString = paramString.split("\\|");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        o localo = aIz(arrayOfString[i]);
        if (localo != null) {
          localLinkedList.add(localo);
        }
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception localException)
    {
      ac.d("MicroMsg.MMBuiltInIP", "unserialize split failed str[%s]", new Object[] { paramString });
      ac.e("MicroMsg.MMBuiltInIP", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(133105);
    }
  }
  
  private static o aIz(String paramString)
  {
    AppMethodBeat.i(133103);
    paramString = paramString.split(",");
    if (paramString.length < 4)
    {
      AppMethodBeat.o(133103);
      return null;
    }
    o localo = new o();
    try
    {
      localo.type = bs.getInt(paramString[0], 0);
      localo.tWE = bs.nullAsNil(paramString[1]);
      localo.port = bs.getInt(paramString[2], 0);
      localo.host = bs.nullAsNil(paramString[3]);
      AppMethodBeat.o(133103);
      return localo;
    }
    catch (NumberFormatException paramString)
    {
      ac.e("MicroMsg.MMBuiltInIP", "exception:%s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(133103);
    }
    return null;
  }
  
  public static String gW(List<o> paramList)
  {
    AppMethodBeat.i(133104);
    Iterator localIterator = paramList.iterator();
    o localo;
    for (paramList = ""; localIterator.hasNext(); paramList = paramList + localo.toString() + "|") {
      localo = (o)localIterator.next();
    }
    AppMethodBeat.o(133104);
    return paramList;
  }
  
  public static a lf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133106);
    ac.d("MicroMsg.MMBuiltInIP", "parsing network control params:");
    ac.d("MicroMsg.MMBuiltInIP", "ports = ".concat(String.valueOf(paramString1)));
    ac.d("MicroMsg.MMBuiltInIP", "timeouts = ".concat(String.valueOf(paramString2)));
    int[] arrayOfInt = bs.aLv(paramString1);
    paramString2 = bs.aLv(paramString2);
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
      ac.e("MicroMsg.MMBuiltInIP", "invalid timeouts");
    }
    paramString1 = new a(arrayOfInt, (int)(paramString1[0] * 1000L), (int)(paramString1[1] * 1000L));
    AppMethodBeat.o(133106);
    return paramString1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(133102);
    String str = this.type + "," + this.tWE + "," + this.port + "," + this.host;
    AppMethodBeat.o(133102);
    return str;
  }
  
  public static final class a
  {
    public final int[] DIU = null;
    public final int[] DIV;
    public final int DIW;
    public final int DIX;
    
    public a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      this.DIV = paramArrayOfInt;
      this.DIW = paramInt1;
      this.DIX = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.o
 * JD-Core Version:    0.7.0.1
 */