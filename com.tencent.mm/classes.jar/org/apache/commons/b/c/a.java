package org.apache.commons.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements Cloneable
{
  private String Osm;
  protected char[] aZW;
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
    this.aZW = new char[i];
    AppMethodBeat.o(40757);
  }
  
  private a amJ(int paramInt)
  {
    AppMethodBeat.i(40759);
    if (paramInt > this.aZW.length)
    {
      char[] arrayOfChar = this.aZW;
      this.aZW = new char[paramInt * 2];
      System.arraycopy(arrayOfChar, 0, this.aZW, 0, this.size);
    }
    AppMethodBeat.o(40759);
    return this;
  }
  
  private a gCM()
  {
    AppMethodBeat.i(40760);
    if (this.Osm == null)
    {
      AppMethodBeat.o(40760);
      return this;
    }
    a locala = bfy(this.Osm);
    AppMethodBeat.o(40760);
    return locala;
  }
  
  public final a L(char paramChar)
  {
    AppMethodBeat.i(40763);
    amJ(this.size + 1);
    char[] arrayOfChar = this.aZW;
    int i = this.size;
    this.size = (i + 1);
    arrayOfChar[i] = paramChar;
    AppMethodBeat.o(40763);
    return this;
  }
  
  public final a bfy(String paramString)
  {
    AppMethodBeat.i(40762);
    if (paramString == null)
    {
      paramString = gCM();
      AppMethodBeat.o(40762);
      return paramString;
    }
    int i = paramString.length();
    if (i > 0)
    {
      int j = this.size;
      amJ(j + i);
      paramString.getChars(0, i, this.aZW, j);
      this.size = (i + this.size);
    }
    AppMethodBeat.o(40762);
    return this;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(40765);
    a locala = (a)super.clone();
    locala.aZW = new char[this.aZW.length];
    System.arraycopy(this.aZW, 0, locala.aZW, 0, this.aZW.length);
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
    paramObject = this.aZW;
    Object localObject = ((a)localObject).aZW;
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
  
  public final a gA(Object paramObject)
  {
    AppMethodBeat.i(40761);
    if (paramObject == null)
    {
      paramObject = gCM();
      AppMethodBeat.o(40761);
      return paramObject;
    }
    paramObject = bfy(paramObject.toString());
    AppMethodBeat.o(40761);
    return paramObject;
  }
  
  public final a gCL()
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
        amJ(0);
        int i = this.size;
        this.size = 0;
        while (i < 0)
        {
          this.aZW[i] = '\000';
          i += 1;
        }
      }
    }
  }
  
  public final int hashCode()
  {
    char[] arrayOfChar = this.aZW;
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
    String str = new String(this.aZW, 0, this.size);
    AppMethodBeat.o(40764);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.apache.commons.b.c.a
 * JD-Core Version:    0.7.0.1
 */