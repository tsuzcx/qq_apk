package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.platformtools.g;
import com.tencent.mm.sdk.platformtools.y;
import d.a.a.b;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bv.a
{
  String ncX;
  private boolean ncY;
  LinkedList<o> ncZ = new LinkedList();
  private boolean nda;
  
  public static String Le(String paramString)
  {
    String str;
    if ((paramString == null) || (paramString.length() <= 0))
    {
      y.d("MicroMsg.getAdjustFullSpell", "%s", new Object[] { "srcName is null or empty, adjust full spell = ~" });
      str = "~";
      return str;
    }
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    for (;;)
    {
      if (i >= arrayOfChar.length) {
        break label184;
      }
      char c = arrayOfChar[i];
      if ((c >= '0') && (c <= '9')) {
        return String.format("{%c%s", new Object[] { Character.valueOf(c), paramString });
      }
      if (((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z')))
      {
        str = paramString;
        if (i == 0) {
          break;
        }
        return String.format("%c%s", new Object[] { Character.valueOf(c), paramString });
      }
      if ((c == '{') && (i == 0) && (arrayOfChar.length > 1) && (arrayOfChar[(i + 1)] >= '0'))
      {
        str = paramString;
        if (arrayOfChar[(i + 1)] <= '9') {
          break;
        }
      }
      i += 1;
    }
    label184:
    y.d("MicroMsg.getAdjustFullSpell", "%s is not ok, return '~'", new Object[] { paramString });
    return "~";
  }
  
  private static boolean a(o paramo1, o paramo2)
  {
    boolean bool = true;
    if ((paramo1 == null) || (paramo2 == null)) {
      bool = false;
    }
    int i;
    do
    {
      do
      {
        return bool;
        i = b(paramo1).compareTo(b(paramo2));
        if (i != 0) {
          break;
        }
      } while (paramo1.lCF.compareTo(paramo2.lCF) <= 0);
      return false;
    } while (i < 0);
    return false;
  }
  
  public static String b(o paramo)
  {
    String str = paramo.ndQ;
    if ((str == null) || ("".equals(str))) {}
    for (str = Le(g.oY(paramo.name.trim()).toLowerCase());; str = Le(str))
    {
      paramo.ndQ = str;
      return str;
    }
  }
  
  private a btp()
  {
    if (!this.ncY) {
      throw new b("Not all required fields were included (false = not included in message),  syncInfo:" + this.ncY);
    }
    return this;
  }
  
  public final a Ld(String paramString)
  {
    this.ncX = paramString;
    this.ncY = true;
    return this;
  }
  
  public final a a(o paramo)
  {
    int j = 0;
    if (!this.nda) {
      this.nda = true;
    }
    Iterator localIterator = this.ncZ.iterator();
    int i = 0;
    o localo;
    if (localIterator.hasNext())
    {
      localo = (o)localIterator.next();
      if (i < 10) {
        if (paramo.ndP <= localo.ndP) {
          break label96;
        }
      }
    }
    else
    {
      label65:
      if (i < this.ncZ.size()) {
        break label103;
      }
      this.ncZ.add(paramo);
    }
    label96:
    label103:
    do
    {
      return this;
      if (a(paramo, localo)) {
        break label65;
      }
      i += 1;
      break;
      this.ncZ.add(i, paramo);
    } while ((i >= 10) || (this.ncZ.size() <= 10));
    paramo = (o)this.ncZ.remove(10);
    localIterator = this.ncZ.iterator();
    i = j;
    while (localIterator.hasNext())
    {
      localo = (o)localIterator.next();
      if ((i >= 10) && (a(paramo, localo))) {
        break;
      }
      i += 1;
    }
    if (i >= this.ncZ.size())
    {
      this.ncZ.add(paramo);
      return this;
    }
    this.ncZ.add(i, paramo);
    return this;
  }
  
  public final void a(d.a.a.c.a parama)
  {
    parama.d(1, this.ncX);
    parama.d(2, 8, this.ncZ);
  }
  
  public final a aG(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new d.a.a.a.a(paramArrayOfByte, unknownTagHandler);
    int i = a(paramArrayOfByte);
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
          paramArrayOfByte.cUt();
        }
        i = a(paramArrayOfByte);
        break;
        Ld(paramArrayOfByte.xpH.readString());
        i = 1;
        continue;
        Object localObject1 = paramArrayOfByte.KN(2);
        i = 0;
        o localo;
        while (i < ((LinkedList)localObject1).size())
        {
          Object localObject2 = (byte[])((LinkedList)localObject1).get(i);
          localo = new o();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = localo.a((d.a.a.a.a)localObject2, localo, a((d.a.a.a.a)localObject2))) {}
          if (!this.nda) {
            this.nda = true;
          }
          this.ncZ.add(localo);
          i += 1;
        }
        localObject1 = new o[1];
        localObject1 = (o[])this.ncZ.toArray((Object[])localObject1);
        Arrays.sort((Object[])localObject1, new a.1(this));
        if (10 <= localObject1.length) {
          Arrays.sort((Object[])localObject1, 10, localObject1.length, new Comparator() {});
        }
        this.ncZ.clear();
        int j = localObject1.length;
        i = 0;
        while (i < j)
        {
          localo = localObject1[i];
          this.ncZ.add(localo);
          i += 1;
        }
        i = 1;
      }
    }
    return btp();
  }
  
  public final int btq()
  {
    return d.a.a.b.b.a.e(1, this.ncX) + 0 + (d.a.a.a.c(2, 8, this.ncZ) + 0);
  }
  
  public final byte[] toByteArray()
  {
    btp();
    return super.toByteArray();
  }
  
  public final String toString()
  {
    String str = "" + getClass().getName() + "(";
    str = str + "syncInfo = " + this.ncX + "   ";
    str = str + "addrs = " + this.ncZ + "   ";
    return str + ")";
  }
  
  public final a wj(int paramInt)
  {
    boolean bool = false;
    if ((paramInt < 0) || (paramInt >= this.ncZ.size())) {
      return this;
    }
    if (paramInt >= 10)
    {
      this.ncZ.remove(paramInt);
      if (this.ncZ.size() > 0) {
        bool = true;
      }
      this.nda = bool;
      return this;
    }
    this.ncZ.remove(paramInt);
    Iterator localIterator = this.ncZ.iterator();
    int i = -1;
    int k = -2147483648;
    int j = 0;
    for (;;)
    {
      label83:
      if (localIterator.hasNext())
      {
        o localo = (o)localIterator.next();
        paramInt = j + 1;
        if (j < 10) {
          break label217;
        }
        if (k >= localo.ndP) {
          break label214;
        }
        k = localo.ndP;
        i = paramInt;
      }
      label214:
      for (;;)
      {
        for (;;)
        {
          j = paramInt;
          break label83;
          if ((i == -1) || (i >= this.ncZ.size())) {
            break;
          }
          try
          {
            a((o)this.ncZ.remove(i));
          }
          catch (Exception localException)
          {
            y.printErrStackTrace("MicroMsg.AddrBook", localException, "size:%d, idx:%d", new Object[] { Integer.valueOf(this.ncZ.size()), Integer.valueOf(i) });
          }
        }
        break;
      }
      label217:
      j = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.a
 * JD-Core Version:    0.7.0.1
 */