package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.sdk.platformtools.ab;
import e.a.a.b;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bv.a
{
  String pIp;
  private boolean pIq;
  LinkedList<o> pIr;
  private boolean pIs;
  
  public a()
  {
    AppMethodBeat.i(67903);
    this.pIr = new LinkedList();
    AppMethodBeat.o(67903);
  }
  
  public static String Xn(String paramString)
  {
    AppMethodBeat.i(67908);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ab.d("MicroMsg.getAdjustFullSpell", "%s", new Object[] { "srcName is null or empty, adjust full spell = ~" });
      AppMethodBeat.o(67908);
      return "~";
    }
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    while (i < arrayOfChar.length)
    {
      char c = arrayOfChar[i];
      if ((c >= '0') && (c <= '9'))
      {
        paramString = String.format("{%c%s", new Object[] { Character.valueOf(c), paramString });
        AppMethodBeat.o(67908);
        return paramString;
      }
      if (((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z')))
      {
        if (i == 0)
        {
          AppMethodBeat.o(67908);
          return paramString;
        }
        paramString = String.format("%c%s", new Object[] { Character.valueOf(c), paramString });
        AppMethodBeat.o(67908);
        return paramString;
      }
      if ((c == '{') && (i == 0) && (arrayOfChar.length > 1) && (arrayOfChar[(i + 1)] >= '0') && (arrayOfChar[(i + 1)] <= '9'))
      {
        AppMethodBeat.o(67908);
        return paramString;
      }
      i += 1;
    }
    ab.d("MicroMsg.getAdjustFullSpell", "%s is not ok, return '~'", new Object[] { paramString });
    AppMethodBeat.o(67908);
    return "~";
  }
  
  private static boolean a(o paramo1, o paramo2)
  {
    AppMethodBeat.i(67906);
    if ((paramo1 == null) || (paramo2 == null))
    {
      AppMethodBeat.o(67906);
      return false;
    }
    int i = b(paramo1).compareTo(b(paramo2));
    if (i == 0)
    {
      if (paramo1.nZR.compareTo(paramo2.nZR) <= 0)
      {
        AppMethodBeat.o(67906);
        return true;
      }
      AppMethodBeat.o(67906);
      return false;
    }
    if (i < 0)
    {
      AppMethodBeat.o(67906);
      return true;
    }
    AppMethodBeat.o(67906);
    return false;
  }
  
  public static String b(o paramo)
  {
    AppMethodBeat.i(67907);
    String str = paramo.pJg;
    if ((str == null) || ("".equals(str))) {}
    for (str = Xn(g.wq(paramo.name.trim()).toLowerCase());; str = Xn(str))
    {
      paramo.pJg = str;
      AppMethodBeat.o(67907);
      return str;
    }
  }
  
  private a cdB()
  {
    AppMethodBeat.i(67910);
    if (!this.pIq)
    {
      b localb = new b("Not all required fields were included (false = not included in message),  syncInfo:" + this.pIq);
      AppMethodBeat.o(67910);
      throw localb;
    }
    AppMethodBeat.o(67910);
    return this;
  }
  
  public final a BU(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(67904);
    if ((paramInt < 0) || (paramInt >= this.pIr.size()))
    {
      AppMethodBeat.o(67904);
      return this;
    }
    if (paramInt >= 10)
    {
      this.pIr.remove(paramInt);
      if (this.pIr.size() > 0) {
        bool = true;
      }
      this.pIs = bool;
      AppMethodBeat.o(67904);
      return this;
    }
    this.pIr.remove(paramInt);
    Iterator localIterator = this.pIr.iterator();
    int i = -1;
    int k = -2147483648;
    int j = 0;
    for (;;)
    {
      label97:
      if (localIterator.hasNext())
      {
        o localo = (o)localIterator.next();
        paramInt = j + 1;
        if (j < 10) {
          break label229;
        }
        if (k >= localo.pJf) {
          break label226;
        }
        k = localo.pJf;
        i = paramInt;
      }
      label226:
      for (;;)
      {
        for (;;)
        {
          j = paramInt;
          break label97;
          if ((i == -1) || (i >= this.pIr.size())) {
            break;
          }
          try
          {
            a((o)this.pIr.remove(i));
          }
          catch (Exception localException)
          {
            ab.printErrStackTrace("MicroMsg.AddrBook", localException, "size:%d, idx:%d", new Object[] { Integer.valueOf(this.pIr.size()), Integer.valueOf(i) });
          }
        }
        break;
      }
      label229:
      j = paramInt;
    }
  }
  
  public final a Xm(String paramString)
  {
    this.pIp = paramString;
    this.pIq = true;
    return this;
  }
  
  public final a a(o paramo)
  {
    int j = 0;
    AppMethodBeat.i(67905);
    if (!this.pIs) {
      this.pIs = true;
    }
    Iterator localIterator = this.pIr.iterator();
    int i = 0;
    o localo;
    if (localIterator.hasNext())
    {
      localo = (o)localIterator.next();
      if (i < 10) {
        if (paramo.pJf <= localo.pJf) {
          break label106;
        }
      }
    }
    else
    {
      label70:
      if (i < this.pIr.size()) {
        break label113;
      }
      this.pIr.add(paramo);
    }
    for (;;)
    {
      AppMethodBeat.o(67905);
      return this;
      if (a(paramo, localo)) {
        break label70;
      }
      label106:
      i += 1;
      break;
      label113:
      this.pIr.add(i, paramo);
      if ((i < 10) && (this.pIr.size() > 10))
      {
        paramo = (o)this.pIr.remove(10);
        localIterator = this.pIr.iterator();
        i = j;
        while (localIterator.hasNext())
        {
          localo = (o)localIterator.next();
          if ((i >= 10) && (a(paramo, localo))) {
            break;
          }
          i += 1;
        }
        if (i >= this.pIr.size()) {
          this.pIr.add(paramo);
        } else {
          this.pIr.add(i, paramo);
        }
      }
    }
  }
  
  public final a bf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67914);
    paramArrayOfByte = new e.a.a.a.a(paramArrayOfByte, unknownTagHandler);
    int i = getNextFieldNumber(paramArrayOfByte);
    if (i > 0)
    {
      switch (i)
      {
      default: 
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          paramArrayOfByte.eqQ();
        }
        i = getNextFieldNumber(paramArrayOfByte);
        break;
        Xm(paramArrayOfByte.CLY.readString());
        i = 1;
        continue;
        Object localObject1 = paramArrayOfByte.Wp(2);
        i = 0;
        o localo;
        while (i < ((LinkedList)localObject1).size())
        {
          Object localObject2 = (byte[])((LinkedList)localObject1).get(i);
          localo = new o();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = localo.populateBuilderWithField((e.a.a.a.a)localObject2, localo, getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          if (!this.pIs) {
            this.pIs = true;
          }
          this.pIr.add(localo);
          i += 1;
        }
        localObject1 = new o[1];
        localObject1 = (o[])this.pIr.toArray((Object[])localObject1);
        Arrays.sort((Object[])localObject1, new a.1(this));
        if (10 <= localObject1.length) {
          Arrays.sort((Object[])localObject1, 10, localObject1.length, new a.2(this));
        }
        this.pIr.clear();
        int j = localObject1.length;
        i = 0;
        while (i < j)
        {
          localo = localObject1[i];
          this.pIr.add(localo);
          i += 1;
        }
        i = 1;
      }
    }
    paramArrayOfByte = cdB();
    AppMethodBeat.o(67914);
    return paramArrayOfByte;
  }
  
  public final int computeSize()
  {
    AppMethodBeat.i(67911);
    int i = e.a.a.b.b.a.f(1, this.pIp);
    int j = e.a.a.a.c(2, 8, this.pIr);
    AppMethodBeat.o(67911);
    return i + 0 + (j + 0);
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(67912);
    cdB();
    byte[] arrayOfByte = super.toByteArray();
    AppMethodBeat.o(67912);
    return arrayOfByte;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(67909);
    String str = "" + getClass().getName() + "(";
    str = str + "syncInfo = " + this.pIp + "   ";
    str = str + "addrs = " + this.pIr + "   ";
    str = str + ")";
    AppMethodBeat.o(67909);
    return str;
  }
  
  public final void writeFields(e.a.a.c.a parama)
  {
    AppMethodBeat.i(67913);
    parama.e(1, this.pIp);
    parama.e(2, 8, this.pIr);
    AppMethodBeat.o(67913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.a
 * JD-Core Version:    0.7.0.1
 */