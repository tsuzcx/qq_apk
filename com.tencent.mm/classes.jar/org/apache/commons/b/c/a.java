package org.apache.commons.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements Cloneable
{
  protected char[] aJp;
  private String abKz;
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
    this.aJp = new char[i];
    AppMethodBeat.o(40757);
  }
  
  private a aGg(int paramInt)
  {
    AppMethodBeat.i(40759);
    if (paramInt > this.aJp.length)
    {
      char[] arrayOfChar = this.aJp;
      this.aJp = new char[paramInt * 2];
      System.arraycopy(arrayOfChar, 0, this.aJp, 0, this.size);
    }
    AppMethodBeat.o(40759);
    return this;
  }
  
  private a iUZ()
  {
    AppMethodBeat.i(40760);
    if (this.abKz == null)
    {
      AppMethodBeat.o(40760);
      return this;
    }
    a locala = bIt(this.abKz);
    AppMethodBeat.o(40760);
    return locala;
  }
  
  public final a V(char paramChar)
  {
    AppMethodBeat.i(40763);
    aGg(this.size + 1);
    char[] arrayOfChar = this.aJp;
    int i = this.size;
    this.size = (i + 1);
    arrayOfChar[i] = paramChar;
    AppMethodBeat.o(40763);
    return this;
  }
  
  public final a bIt(String paramString)
  {
    AppMethodBeat.i(40762);
    if (paramString == null)
    {
      paramString = iUZ();
      AppMethodBeat.o(40762);
      return paramString;
    }
    int i = paramString.length();
    if (i > 0)
    {
      int j = this.size;
      aGg(j + i);
      paramString.getChars(0, i, this.aJp, j);
      this.size = (i + this.size);
    }
    AppMethodBeat.o(40762);
    return this;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(40765);
    a locala = (a)super.clone();
    locala.aJp = new char[this.aJp.length];
    System.arraycopy(this.aJp, 0, locala.aJp, 0, this.aJp.length);
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
    paramObject = this.aJp;
    Object localObject = ((a)localObject).aJp;
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
  
  public final a gX(Object paramObject)
  {
    AppMethodBeat.i(40761);
    if (paramObject == null)
    {
      paramObject = iUZ();
      AppMethodBeat.o(40761);
      return paramObject;
    }
    paramObject = bIt(paramObject.toString());
    AppMethodBeat.o(40761);
    return paramObject;
  }
  
  public final int hashCode()
  {
    char[] arrayOfChar = this.aJp;
    int j = 0;
    int i = this.size - 1;
    while (i >= 0)
    {
      j = j * 31 + arrayOfChar[i];
      i -= 1;
    }
    return j;
  }
  
  public final a iUY()
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
        aGg(0);
        int i = this.size;
        this.size = 0;
        while (i < 0)
        {
          this.aJp[i] = '\000';
          i += 1;
        }
      }
    }
  }
  
  public final boolean isEmpty()
  {
    return this.size == 0;
  }
  
  public final int length()
  {
    return this.size;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(40764);
    String str = new String(this.aJp, 0, this.size);
    AppMethodBeat.o(40764);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.b.c.a
 * JD-Core Version:    0.7.0.1
 */