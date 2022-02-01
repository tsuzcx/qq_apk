package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.sdk.platformtools.ad;
import f.a.a.b;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bx.a
{
  String uKJ;
  private boolean uKK;
  LinkedList<p> uKL;
  private boolean uKM;
  
  public a()
  {
    AppMethodBeat.i(122638);
    this.uKL = new LinkedList();
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
      if (paramp1.sOr.compareTo(paramp2.sOr) <= 0)
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
  
  public static String akQ(String paramString)
  {
    AppMethodBeat.i(122643);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ad.d("MicroMsg.getAdjustFullSpell", "%s", new Object[] { "srcName is null or empty, adjust full spell = ~" });
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
    ad.d("MicroMsg.getAdjustFullSpell", "%s is not ok, return '~'", new Object[] { paramString });
    AppMethodBeat.o(122643);
    return "~";
  }
  
  public static String b(p paramp)
  {
    AppMethodBeat.i(122642);
    String str = paramp.uLz;
    if ((str == null) || ("".equals(str))) {}
    for (str = akQ(f.Br(paramp.name.trim()).toLowerCase());; str = akQ(str))
    {
      paramp.uLz = str;
      AppMethodBeat.o(122642);
      return str;
    }
  }
  
  private a ddT()
  {
    AppMethodBeat.i(122645);
    if (!this.uKK)
    {
      b localb = new b("Not all required fields were included (false = not included in message),  syncInfo:" + this.uKK);
      AppMethodBeat.o(122645);
      throw localb;
    }
    AppMethodBeat.o(122645);
    return this;
  }
  
  public final a JJ(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(122639);
    if ((paramInt < 0) || (paramInt >= this.uKL.size()))
    {
      AppMethodBeat.o(122639);
      return this;
    }
    if (paramInt >= 10)
    {
      this.uKL.remove(paramInt);
      if (this.uKL.size() > 0) {
        bool = true;
      }
      this.uKM = bool;
      AppMethodBeat.o(122639);
      return this;
    }
    this.uKL.remove(paramInt);
    Iterator localIterator = this.uKL.iterator();
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
        if (k >= localp.uLy) {
          break label226;
        }
        k = localp.uLy;
        i = paramInt;
      }
      label226:
      for (;;)
      {
        for (;;)
        {
          j = paramInt;
          break label97;
          if ((i == -1) || (i >= this.uKL.size())) {
            break;
          }
          try
          {
            a((p)this.uKL.remove(i));
          }
          catch (Exception localException)
          {
            ad.printErrStackTrace("MicroMsg.AddrBook", localException, "size:%d, idx:%d", new Object[] { Integer.valueOf(this.uKL.size()), Integer.valueOf(i) });
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
    if (!this.uKM) {
      this.uKM = true;
    }
    Iterator localIterator = this.uKL.iterator();
    int i = 0;
    p localp;
    if (localIterator.hasNext())
    {
      localp = (p)localIterator.next();
      if (i < 10) {
        if (paramp.uLy <= localp.uLy) {
          break label106;
        }
      }
    }
    else
    {
      label70:
      if (i < this.uKL.size()) {
        break label113;
      }
      this.uKL.add(paramp);
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
      this.uKL.add(i, paramp);
      if ((i < 10) && (this.uKL.size() > 10))
      {
        paramp = (p)this.uKL.remove(10);
        localIterator = this.uKL.iterator();
        i = j;
        while (localIterator.hasNext())
        {
          localp = (p)localIterator.next();
          if ((i >= 10) && (a(paramp, localp))) {
            break;
          }
          i += 1;
        }
        if (i >= this.uKL.size()) {
          this.uKL.add(paramp);
        } else {
          this.uKL.add(i, paramp);
        }
      }
    }
  }
  
  public final a akP(String paramString)
  {
    this.uKJ = paramString;
    this.uKK = true;
    return this;
  }
  
  public final a bv(byte[] paramArrayOfByte)
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
          paramArrayOfByte.fMq();
        }
        i = getNextFieldNumber(paramArrayOfByte);
        break;
        akP(paramArrayOfByte.KhF.readString());
        i = 1;
        continue;
        Object localObject1 = paramArrayOfByte.agn(2);
        i = 0;
        p localp;
        while (i < ((LinkedList)localObject1).size())
        {
          Object localObject2 = (byte[])((LinkedList)localObject1).get(i);
          localp = new p();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = localp.populateBuilderWithField((f.a.a.a.a)localObject2, localp, getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          if (!this.uKM) {
            this.uKM = true;
          }
          this.uKL.add(localp);
          i += 1;
        }
        localObject1 = new p[1];
        localObject1 = (p[])this.uKL.toArray((Object[])localObject1);
        Arrays.sort((Object[])localObject1, new Comparator() {});
        if (10 <= localObject1.length) {
          Arrays.sort((Object[])localObject1, 10, localObject1.length, new Comparator() {});
        }
        this.uKL.clear();
        int j = localObject1.length;
        i = 0;
        while (i < j)
        {
          localp = localObject1[i];
          this.uKL.add(localp);
          i += 1;
        }
        i = 1;
      }
    }
    paramArrayOfByte = ddT();
    AppMethodBeat.o(122649);
    return paramArrayOfByte;
  }
  
  public final int computeSize()
  {
    AppMethodBeat.i(122646);
    int i = f.a.a.b.b.a.e(1, this.uKJ);
    int j = f.a.a.a.c(2, 8, this.uKL);
    AppMethodBeat.o(122646);
    return i + 0 + (j + 0);
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(122647);
    ddT();
    byte[] arrayOfByte = super.toByteArray();
    AppMethodBeat.o(122647);
    return arrayOfByte;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122644);
    String str = "" + getClass().getName() + "(";
    str = str + "syncInfo = " + this.uKJ + "   ";
    str = str + "addrs = " + this.uKL + "   ";
    str = str + ")";
    AppMethodBeat.o(122644);
    return str;
  }
  
  public final void writeFields(f.a.a.c.a parama)
  {
    AppMethodBeat.i(122648);
    parama.d(1, this.uKJ);
    parama.e(2, 8, this.uKL);
    AppMethodBeat.o(122648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.a
 * JD-Core Version:    0.7.0.1
 */