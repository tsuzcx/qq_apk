package org.apache.commons.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements Cloneable
{
  private String CRg;
  protected char[] auc;
  protected int size;
  
  public a()
  {
    this(32);
  }
  
  public a(int paramInt)
  {
    AppMethodBeat.i(116965);
    int i = paramInt;
    if (paramInt <= 0) {
      i = 32;
    }
    this.auc = new char[i];
    AppMethodBeat.o(116965);
  }
  
  private a Wu(int paramInt)
  {
    AppMethodBeat.i(116966);
    if (paramInt > this.auc.length)
    {
      char[] arrayOfChar = this.auc;
      this.auc = new char[paramInt * 2];
      System.arraycopy(arrayOfChar, 0, this.auc, 0, this.size);
    }
    AppMethodBeat.o(116966);
    return this;
  }
  
  private a ert()
  {
    AppMethodBeat.i(116967);
    if (this.CRg == null)
    {
      AppMethodBeat.o(116967);
      return this;
    }
    a locala = azP(this.CRg);
    AppMethodBeat.o(116967);
    return locala;
  }
  
  public final a azP(String paramString)
  {
    AppMethodBeat.i(116968);
    if (paramString == null)
    {
      paramString = ert();
      AppMethodBeat.o(116968);
      return paramString;
    }
    int i = paramString.length();
    if (i > 0)
    {
      int j = this.size;
      Wu(j + i);
      paramString.getChars(0, i, this.auc, j);
      this.size = (i + this.size);
    }
    AppMethodBeat.o(116968);
    return this;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(116971);
    a locala = (a)super.clone();
    locala.auc = new char[this.auc.length];
    System.arraycopy(this.auc, 0, locala.auc, 0, this.auc.length);
    AppMethodBeat.o(116971);
    return locala;
  }
  
  public final a eo(Object paramObject)
  {
    AppMethodBeat.i(142953);
    if (paramObject == null)
    {
      paramObject = ert();
      AppMethodBeat.o(142953);
      return paramObject;
    }
    paramObject = azP(paramObject.toString());
    AppMethodBeat.o(142953);
    return paramObject;
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
    paramObject = this.auc;
    Object localObject = ((a)localObject).auc;
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
  
  public final a eru()
  {
    AppMethodBeat.i(116969);
    Wu(this.size + 1);
    char[] arrayOfChar = this.auc;
    int i = this.size;
    this.size = (i + 1);
    arrayOfChar[i] = '#';
    AppMethodBeat.o(116969);
    return this;
  }
  
  public final int hashCode()
  {
    char[] arrayOfChar = this.auc;
    int j = 0;
    int i = this.size - 1;
    while (i >= 0)
    {
      j = j * 31 + arrayOfChar[i];
      i -= 1;
    }
    return j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(116970);
    String str = new String(this.auc, 0, this.size);
    AppMethodBeat.o(116970);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.apache.commons.b.d.a
 * JD-Core Version:    0.7.0.1
 */