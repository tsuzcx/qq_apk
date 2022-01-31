package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o
{
  public String host = "";
  public String nZR = "";
  private int port = 80;
  private int type = 0;
  
  public o() {}
  
  public o(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this.type = paramInt1;
    this.nZR = paramString1;
    this.port = paramInt2;
    this.host = paramString2;
  }
  
  private static o ann(String paramString)
  {
    AppMethodBeat.i(58844);
    paramString = paramString.split(",");
    if (paramString.length < 4)
    {
      AppMethodBeat.o(58844);
      return null;
    }
    o localo = new o();
    try
    {
      localo.type = bo.getInt(paramString[0], 0);
      localo.nZR = bo.nullAsNil(paramString[1]);
      localo.port = bo.getInt(paramString[2], 0);
      localo.host = bo.nullAsNil(paramString[3]);
      AppMethodBeat.o(58844);
      return localo;
    }
    catch (NumberFormatException paramString)
    {
      ab.e("MicroMsg.MMBuiltInIP", "exception:%s", new Object[] { bo.l(paramString) });
      AppMethodBeat.o(58844);
    }
    return null;
  }
  
  public static List<o> ano(String paramString)
  {
    AppMethodBeat.i(58846);
    localLinkedList = new LinkedList();
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(58846);
      return localLinkedList;
    }
    try
    {
      String[] arrayOfString = paramString.split("\\|");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        o localo = ann(arrayOfString[i]);
        if (localo != null) {
          localLinkedList.add(localo);
        }
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception localException)
    {
      ab.d("MicroMsg.MMBuiltInIP", "unserialize split failed str[%s]", new Object[] { paramString });
      ab.e("MicroMsg.MMBuiltInIP", "exception:%s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(58846);
    }
  }
  
  public static String eq(List<o> paramList)
  {
    AppMethodBeat.i(58845);
    Iterator localIterator = paramList.iterator();
    o localo;
    for (paramList = ""; localIterator.hasNext(); paramList = paramList + localo.toString() + "|") {
      localo = (o)localIterator.next();
    }
    AppMethodBeat.o(58845);
    return paramList;
  }
  
  public static a ib(String paramString1, String paramString2)
  {
    AppMethodBeat.i(58847);
    ab.d("MicroMsg.MMBuiltInIP", "parsing network control params:");
    ab.d("MicroMsg.MMBuiltInIP", "ports = ".concat(String.valueOf(paramString1)));
    ab.d("MicroMsg.MMBuiltInIP", "timeouts = ".concat(String.valueOf(paramString2)));
    int[] arrayOfInt = bo.apR(paramString1);
    paramString2 = bo.apR(paramString2);
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
      ab.e("MicroMsg.MMBuiltInIP", "invalid timeouts");
    }
    paramString1 = new a(arrayOfInt, (int)(paramString1[0] * 1000L), (int)(paramString1[1] * 1000L));
    AppMethodBeat.o(58847);
    return paramString1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58843);
    String str = this.type + "," + this.nZR + "," + this.port + "," + this.host;
    AppMethodBeat.o(58843);
    return str;
  }
  
  public static final class a
  {
    public final int wiA;
    public final int wiB;
    public final int[] wiy = null;
    public final int[] wiz;
    
    public a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      this.wiz = paramArrayOfInt;
      this.wiA = paramInt1;
      this.wiB = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.o
 * JD-Core Version:    0.7.0.1
 */