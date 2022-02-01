package org.apache.commons.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements Cloneable
{
  private String KmY;
  protected char[] aOM;
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
    this.aOM = new char[i];
    AppMethodBeat.o(40757);
  }
  
  private a ags(int paramInt)
  {
    AppMethodBeat.i(40759);
    if (paramInt > this.aOM.length)
    {
      char[] arrayOfChar = this.aOM;
      this.aOM = new char[paramInt * 2];
      System.arraycopy(arrayOfChar, 0, this.aOM, 0, this.size);
    }
    AppMethodBeat.o(40759);
    return this;
  }
  
  private a fMW()
  {
    AppMethodBeat.i(40760);
    if (this.KmY == null)
    {
      AppMethodBeat.o(40760);
      return this;
    }
    a locala = aRA(this.KmY);
    AppMethodBeat.o(40760);
    return locala;
  }
  
  public final a I(char paramChar)
  {
    AppMethodBeat.i(40763);
    ags(this.size + 1);
    char[] arrayOfChar = this.aOM;
    int i = this.size;
    this.size = (i + 1);
    arrayOfChar[i] = paramChar;
    AppMethodBeat.o(40763);
    return this;
  }
  
  public final a aRA(String paramString)
  {
    AppMethodBeat.i(40762);
    if (paramString == null)
    {
      paramString = fMW();
      AppMethodBeat.o(40762);
      return paramString;
    }
    int i = paramString.length();
    if (i > 0)
    {
      int j = this.size;
      ags(j + i);
      paramString.getChars(0, i, this.aOM, j);
      this.size = (i + this.size);
    }
    AppMethodBeat.o(40762);
    return this;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(40765);
    a locala = (a)super.clone();
    locala.aOM = new char[this.aOM.length];
    System.arraycopy(this.aOM, 0, locala.aOM, 0, this.aOM.length);
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
    paramObject = this.aOM;
    Object localObject = ((a)localObject).aOM;
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
  
  public final a fMV()
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
        ags(0);
        int i = this.size;
        this.size = 0;
        while (i < 0)
        {
          this.aOM[i] = '\000';
          i += 1;
        }
      }
    }
  }
  
  public final a fT(Object paramObject)
  {
    AppMethodBeat.i(40761);
    if (paramObject == null)
    {
      paramObject = fMW();
      AppMethodBeat.o(40761);
      return paramObject;
    }
    paramObject = aRA(paramObject.toString());
    AppMethodBeat.o(40761);
    return paramObject;
  }
  
  public final int hashCode()
  {
    char[] arrayOfChar = this.aOM;
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
    String str = new String(this.aOM, 0, this.size);
    AppMethodBeat.o(40764);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.b.c.a
 * JD-Core Version:    0.7.0.1
 */