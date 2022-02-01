package org.apache.commons.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements Cloneable
{
  private String MaH;
  protected char[] aPC;
  protected int size;
  
  public a()
  {
    this(32);
  }
  
  public a(int paramInt)
  {
    AppMethodBeat.i(40757);
    int i = paramInt;
    if (paramInt <= 0) {
      i = 32;
    }
    this.aPC = new char[i];
    AppMethodBeat.o(40757);
  }
  
  private a ajo(int paramInt)
  {
    AppMethodBeat.i(40759);
    if (paramInt > this.aPC.length)
    {
      char[] arrayOfChar = this.aPC;
      this.aPC = new char[paramInt * 2];
      System.arraycopy(arrayOfChar, 0, this.aPC, 0, this.size);
    }
    AppMethodBeat.o(40759);
    return this;
  }
  
  private a gfM()
  {
    AppMethodBeat.i(40760);
    if (this.MaH == null)
    {
      AppMethodBeat.o(40760);
      return this;
    }
    a locala = aXA(this.MaH);
    AppMethodBeat.o(40760);
    return locala;
  }
  
  public final a G(char paramChar)
  {
    AppMethodBeat.i(40763);
    ajo(this.size + 1);
    char[] arrayOfChar = this.aPC;
    int i = this.size;
    this.size = (i + 1);
    arrayOfChar[i] = paramChar;
    AppMethodBeat.o(40763);
    return this;
  }
  
  public final a aXA(String paramString)
  {
    AppMethodBeat.i(40762);
    if (paramString == null)
    {
      paramString = gfM();
      AppMethodBeat.o(40762);
      return paramString;
    }
    int i = paramString.length();
    if (i > 0)
    {
      int j = this.size;
      ajo(j + i);
      paramString.getChars(0, i, this.aPC, j);
      this.size = (i + this.size);
    }
    AppMethodBeat.o(40762);
    return this;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(40765);
    a locala = (a)super.clone();
    locala.aPC = new char[this.aPC.length];
    System.arraycopy(this.aPC, 0, locala.aPC, 0, this.aPC.length);
    AppMethodBeat.o(40765);
    return locala;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof a))
    {
      localObject = (a)paramObject;
      if (this == localObject) {
        break label67;
      }
      if (this.size == ((a)localObject).size) {}
    }
    else
    {
      return false;
    }
    paramObject = this.aPC;
    Object localObject = ((a)localObject).aPC;
    int i = this.size - 1;
    for (;;)
    {
      if (i < 0) {
        break label67;
      }
      if (paramObject[i] != localObject[i]) {
        break;
      }
      i -= 1;
    }
    label67:
    return true;
  }
  
  public final a gb(Object paramObject)
  {
    AppMethodBeat.i(40761);
    if (paramObject == null)
    {
      paramObject = gfM();
      AppMethodBeat.o(40761);
      return paramObject;
    }
    paramObject = aXA(paramObject.toString());
    AppMethodBeat.o(40761);
    return paramObject;
  }
  
  public final a gfL()
  {
    AppMethodBeat.i(40758);
    if (this.size > 0) {
      this.size = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(40758);
      return this;
      if (this.size < 0)
      {
        ajo(0);
        int i = this.size;
        this.size = 0;
        while (i < 0)
        {
          this.aPC[i] = '\000';
          i += 1;
        }
      }
    }
  }
  
  public final int hashCode()
  {
    char[] arrayOfChar = this.aPC;
    int j = 0;
    int i = this.size - 1;
    while (i >= 0)
    {
      j = j * 31 + arrayOfChar[i];
      i -= 1;
    }
    return j;
  }
  
  public final int length()
  {
    return this.size;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(40764);
    String str = new String(this.aPC, 0, this.size);
    AppMethodBeat.o(40764);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.apache.commons.b.c.a
 * JD-Core Version:    0.7.0.1
 */