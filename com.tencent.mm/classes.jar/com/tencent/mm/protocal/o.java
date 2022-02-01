package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o
{
  public String host = "";
  private int port = 80;
  private int type = 0;
  public String vly = "";
  
  public o() {}
  
  public o(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this.type = paramInt1;
    this.vly = paramString1;
    this.port = paramInt2;
    this.host = paramString2;
  }
  
  public static List<o> aPA(String paramString)
  {
    AppMethodBeat.i(133105);
    localLinkedList = new LinkedList();
    if (bu.isNullOrNil(paramString))
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
        o localo = aPz(arrayOfString[i]);
        if (localo != null) {
          localLinkedList.add(localo);
        }
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception localException)
    {
      ae.d("MicroMsg.MMBuiltInIP", "unserialize split failed str[%s]", new Object[] { paramString });
      ae.e("MicroMsg.MMBuiltInIP", "exception:%s", new Object[] { bu.o(localException) });
      AppMethodBeat.o(133105);
    }
  }
  
  private static o aPz(String paramString)
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
      localo.type = bu.getInt(paramString[0], 0);
      localo.vly = bu.nullAsNil(paramString[1]);
      localo.port = bu.getInt(paramString[2], 0);
      localo.host = bu.nullAsNil(paramString[3]);
      AppMethodBeat.o(133103);
      return localo;
    }
    catch (NumberFormatException paramString)
    {
      ae.e("MicroMsg.MMBuiltInIP", "exception:%s", new Object[] { bu.o(paramString) });
      AppMethodBeat.o(133103);
    }
    return null;
  }
  
  public static String hr(List<o> paramList)
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
  
  public static a lL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133106);
    ae.d("MicroMsg.MMBuiltInIP", "parsing network control params:");
    ae.d("MicroMsg.MMBuiltInIP", "ports = ".concat(String.valueOf(paramString1)));
    ae.d("MicroMsg.MMBuiltInIP", "timeouts = ".concat(String.valueOf(paramString2)));
    int[] arrayOfInt = bu.aSy(paramString1);
    paramString2 = bu.aSy(paramString2);
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
      ae.e("MicroMsg.MMBuiltInIP", "invalid timeouts");
    }
    paramString1 = new a(arrayOfInt, (int)(paramString1[0] * 1000L), (int)(paramString1[1] * 1000L));
    AppMethodBeat.o(133106);
    return paramString1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(133102);
    String str = this.type + "," + this.vly + "," + this.port + "," + this.host;
    AppMethodBeat.o(133102);
    return str;
  }
  
  public static final class a
  {
    public final int[] FGA;
    public final int FGB;
    public final int FGC;
    public final int[] FGz = null;
    
    public a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      this.FGA = paramArrayOfInt;
      this.FGB = paramInt1;
      this.FGC = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.o
 * JD-Core Version:    0.7.0.1
 */