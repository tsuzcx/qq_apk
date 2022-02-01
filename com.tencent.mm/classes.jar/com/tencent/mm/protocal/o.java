package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o
{
  public String host = "";
  private int port = 80;
  private int type = 0;
  public String uZn = "";
  
  public o() {}
  
  public o(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this.type = paramInt1;
    this.uZn = paramString1;
    this.port = paramInt2;
    this.host = paramString2;
  }
  
  private static o aOc(String paramString)
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
      localo.type = bt.getInt(paramString[0], 0);
      localo.uZn = bt.nullAsNil(paramString[1]);
      localo.port = bt.getInt(paramString[2], 0);
      localo.host = bt.nullAsNil(paramString[3]);
      AppMethodBeat.o(133103);
      return localo;
    }
    catch (NumberFormatException paramString)
    {
      ad.e("MicroMsg.MMBuiltInIP", "exception:%s", new Object[] { bt.n(paramString) });
      AppMethodBeat.o(133103);
    }
    return null;
  }
  
  public static List<o> aOd(String paramString)
  {
    AppMethodBeat.i(133105);
    localLinkedList = new LinkedList();
    if (bt.isNullOrNil(paramString))
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
        o localo = aOc(arrayOfString[i]);
        if (localo != null) {
          localLinkedList.add(localo);
        }
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception localException)
    {
      ad.d("MicroMsg.MMBuiltInIP", "unserialize split failed str[%s]", new Object[] { paramString });
      ad.e("MicroMsg.MMBuiltInIP", "exception:%s", new Object[] { bt.n(localException) });
      AppMethodBeat.o(133105);
    }
  }
  
  public static String hh(List<o> paramList)
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
  
  public static a lE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133106);
    ad.d("MicroMsg.MMBuiltInIP", "parsing network control params:");
    ad.d("MicroMsg.MMBuiltInIP", "ports = ".concat(String.valueOf(paramString1)));
    ad.d("MicroMsg.MMBuiltInIP", "timeouts = ".concat(String.valueOf(paramString2)));
    int[] arrayOfInt = bt.aRb(paramString1);
    paramString2 = bt.aRb(paramString2);
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
      ad.e("MicroMsg.MMBuiltInIP", "invalid timeouts");
    }
    paramString1 = new a(arrayOfInt, (int)(paramString1[0] * 1000L), (int)(paramString1[1] * 1000L));
    AppMethodBeat.o(133106);
    return paramString1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(133102);
    String str = this.type + "," + this.uZn + "," + this.port + "," + this.host;
    AppMethodBeat.o(133102);
    return str;
  }
  
  public static final class a
  {
    public final int[] Fob = null;
    public final int[] Foc;
    public final int Fod;
    public final int Foe;
    
    public a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      this.Foc = paramArrayOfInt;
      this.Fod = paramInt1;
      this.Foe = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.o
 * JD-Core Version:    0.7.0.1
 */