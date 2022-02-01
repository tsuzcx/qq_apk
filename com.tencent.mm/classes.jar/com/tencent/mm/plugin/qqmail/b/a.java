package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.sdk.platformtools.ac;
import f.a.a.b;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bw.a
{
  String vTA;
  private boolean vTB;
  LinkedList<p> vTC;
  private boolean vTD;
  
  public a()
  {
    AppMethodBeat.i(122638);
    this.vTC = new LinkedList();
    AppMethodBeat.o(122638);
  }
  
  private static boolean a(p paramp1, p paramp2)
  {
    AppMethodBeat.i(122641);
    if ((paramp1 == null) || (paramp2 == null))
    {
      AppMethodBeat.o(122641);
      return false;
    }
    int i = b(paramp1).compareTo(b(paramp2));
    if (i == 0)
    {
      if (paramp1.tWE.compareTo(paramp2.tWE) <= 0)
      {
        AppMethodBeat.o(122641);
        return true;
      }
      AppMethodBeat.o(122641);
      return false;
    }
    if (i < 0)
    {
      AppMethodBeat.o(122641);
      return true;
    }
    AppMethodBeat.o(122641);
    return false;
  }
  
  public static String apP(String paramString)
  {
    AppMethodBeat.i(122643);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ac.d("MicroMsg.getAdjustFullSpell", "%s", new Object[] { "srcName is null or empty, adjust full spell = ~" });
      AppMethodBeat.o(122643);
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
        AppMethodBeat.o(122643);
        return paramString;
      }
      if (((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z')))
      {
        if (i == 0)
        {
          AppMethodBeat.o(122643);
          return paramString;
        }
        paramString = String.format("%c%s", new Object[] { Character.valueOf(c), paramString });
        AppMethodBeat.o(122643);
        return paramString;
      }
      if ((c == '{') && (i == 0) && (arrayOfChar.length > 1) && (arrayOfChar[(i + 1)] >= '0') && (arrayOfChar[(i + 1)] <= '9'))
      {
        AppMethodBeat.o(122643);
        return paramString;
      }
      i += 1;
    }
    ac.d("MicroMsg.getAdjustFullSpell", "%s is not ok, return '~'", new Object[] { paramString });
    AppMethodBeat.o(122643);
    return "~";
  }
  
  public static String b(p paramp)
  {
    AppMethodBeat.i(122642);
    String str = paramp.pinyin;
    if ((str == null) || ("".equals(str))) {}
    for (str = apP(f.Fv(paramp.name.trim()).toLowerCase());; str = apP(str))
    {
      paramp.pinyin = str;
      AppMethodBeat.o(122642);
      return str;
    }
  }
  
  private a drB()
  {
    AppMethodBeat.i(122645);
    if (!this.vTB)
    {
      b localb = new b("Not all required fields were included (false = not included in message),  syncInfo:" + this.vTB);
      AppMethodBeat.o(122645);
      throw localb;
    }
    AppMethodBeat.o(122645);
    return this;
  }
  
  public final a LI(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(122639);
    if ((paramInt < 0) || (paramInt >= this.vTC.size()))
    {
      AppMethodBeat.o(122639);
      return this;
    }
    if (paramInt >= 10)
    {
      this.vTC.remove(paramInt);
      if (this.vTC.size() > 0) {
        bool = true;
      }
      this.vTD = bool;
      AppMethodBeat.o(122639);
      return this;
    }
    this.vTC.remove(paramInt);
    Iterator localIterator = this.vTC.iterator();
    int i = -1;
    int k = -2147483648;
    int j = 0;
    for (;;)
    {
      label97:
      if (localIterator.hasNext())
      {
        p localp = (p)localIterator.next();
        paramInt = j + 1;
        if (j < 10) {
          break label229;
        }
        if (k >= localp.vUp) {
          break label226;
        }
        k = localp.vUp;
        i = paramInt;
      }
      label226:
      for (;;)
      {
        for (;;)
        {
          j = paramInt;
          break label97;
          if ((i == -1) || (i >= this.vTC.size())) {
            break;
          }
          try
          {
            a((p)this.vTC.remove(i));
          }
          catch (Exception localException)
          {
            ac.printErrStackTrace("MicroMsg.AddrBook", localException, "size:%d, idx:%d", new Object[] { Integer.valueOf(this.vTC.size()), Integer.valueOf(i) });
          }
        }
        break;
      }
      label229:
      j = paramInt;
    }
  }
  
  public final a a(p paramp)
  {
    int j = 0;
    AppMethodBeat.i(122640);
    if (!this.vTD) {
      this.vTD = true;
    }
    Iterator localIterator = this.vTC.iterator();
    int i = 0;
    p localp;
    if (localIterator.hasNext())
    {
      localp = (p)localIterator.next();
      if (i < 10) {
        if (paramp.vUp <= localp.vUp) {
          break label106;
        }
      }
    }
    else
    {
      label70:
      if (i < this.vTC.size()) {
        break label113;
      }
      this.vTC.add(paramp);
    }
    for (;;)
    {
      AppMethodBeat.o(122640);
      return this;
      if (a(paramp, localp)) {
        break label70;
      }
      label106:
      i += 1;
      break;
      label113:
      this.vTC.add(i, paramp);
      if ((i < 10) && (this.vTC.size() > 10))
      {
        paramp = (p)this.vTC.remove(10);
        localIterator = this.vTC.iterator();
        i = j;
        while (localIterator.hasNext())
        {
          localp = (p)localIterator.next();
          if ((i >= 10) && (a(paramp, localp))) {
            break;
          }
          i += 1;
        }
        if (i >= this.vTC.size()) {
          this.vTC.add(paramp);
        } else {
          this.vTC.add(i, paramp);
        }
      }
    }
  }
  
  public final a apO(String paramString)
  {
    this.vTA = paramString;
    this.vTB = true;
    return this;
  }
  
  public final a bu(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(122649);
    paramArrayOfByte = new f.a.a.a.a(paramArrayOfByte, unknownTagHandler);
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
          paramArrayOfByte.gfg();
        }
        i = getNextFieldNumber(paramArrayOfByte);
        break;
        apO(paramArrayOfByte.LVo.readString());
        i = 1;
        continue;
        Object localObject1 = paramArrayOfByte.ajj(2);
        i = 0;
        p localp;
        while (i < ((LinkedList)localObject1).size())
        {
          Object localObject2 = (byte[])((LinkedList)localObject1).get(i);
          localp = new p();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = localp.populateBuilderWithField((f.a.a.a.a)localObject2, localp, getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          if (!this.vTD) {
            this.vTD = true;
          }
          this.vTC.add(localp);
          i += 1;
        }
        localObject1 = new p[1];
        localObject1 = (p[])this.vTC.toArray((Object[])localObject1);
        Arrays.sort((Object[])localObject1, new Comparator() {});
        if (10 <= localObject1.length) {
          Arrays.sort((Object[])localObject1, 10, localObject1.length, new Comparator() {});
        }
        this.vTC.clear();
        int j = localObject1.length;
        i = 0;
        while (i < j)
        {
          localp = localObject1[i];
          this.vTC.add(localp);
          i += 1;
        }
        i = 1;
      }
    }
    paramArrayOfByte = drB();
    AppMethodBeat.o(122649);
    return paramArrayOfByte;
  }
  
  public final int computeSize()
  {
    AppMethodBeat.i(122646);
    int i = f.a.a.b.b.a.e(1, this.vTA);
    int j = f.a.a.a.c(2, 8, this.vTC);
    AppMethodBeat.o(122646);
    return i + 0 + (j + 0);
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(122647);
    drB();
    byte[] arrayOfByte = super.toByteArray();
    AppMethodBeat.o(122647);
    return arrayOfByte;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122644);
    String str = "" + getClass().getName() + "(";
    str = str + "syncInfo = " + this.vTA + "   ";
    str = str + "addrs = " + this.vTC + "   ";
    str = str + ")";
    AppMethodBeat.o(122644);
    return str;
  }
  
  public final void writeFields(f.a.a.c.a parama)
  {
    AppMethodBeat.i(122648);
    parama.d(1, this.vTA);
    parama.e(2, 8, this.vTC);
    AppMethodBeat.o(122648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.a
 * JD-Core Version:    0.7.0.1
 */