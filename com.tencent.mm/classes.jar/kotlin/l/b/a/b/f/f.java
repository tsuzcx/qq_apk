package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  implements Comparable<f>
{
  public final boolean ajeG;
  private final String name;
  
  private f(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(59320);
    this.name = paramString;
    this.ajeG = paramBoolean;
    AppMethodBeat.o(59320);
  }
  
  public static f bJe(String paramString)
  {
    AppMethodBeat.i(59324);
    if (paramString == null) {
      aKu(5);
    }
    paramString = new f(paramString, false);
    AppMethodBeat.o(59324);
    return paramString;
  }
  
  public static boolean bJf(String paramString)
  {
    AppMethodBeat.i(59325);
    if (paramString == null) {
      aKu(6);
    }
    if ((paramString.isEmpty()) || (paramString.startsWith("<")))
    {
      AppMethodBeat.o(59325);
      return false;
    }
    int i = 0;
    while (i < paramString.length())
    {
      int j = paramString.charAt(i);
      if ((j == 46) || (j == 47) || (j == 92))
      {
        AppMethodBeat.o(59325);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(59325);
    return true;
  }
  
  public static f bJg(String paramString)
  {
    AppMethodBeat.i(59326);
    if (paramString == null) {
      aKu(7);
    }
    if (!paramString.startsWith("<"))
    {
      paramString = new IllegalArgumentException("special name must start with '<': ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(59326);
      throw paramString;
    }
    paramString = new f(paramString, true);
    AppMethodBeat.o(59326);
    return paramString;
  }
  
  public static f bJh(String paramString)
  {
    AppMethodBeat.i(59327);
    if (paramString == null) {
      aKu(8);
    }
    if (paramString.startsWith("<"))
    {
      paramString = bJg(paramString);
      AppMethodBeat.o(59327);
      return paramString;
    }
    paramString = bJe(paramString);
    AppMethodBeat.o(59327);
    return paramString;
  }
  
  public final String PF()
  {
    AppMethodBeat.i(59321);
    String str = this.name;
    if (str == null) {
      aKu(1);
    }
    AppMethodBeat.o(59321);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(59328);
    if (this == paramObject)
    {
      AppMethodBeat.o(59328);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(59328);
      return false;
    }
    paramObject = (f)paramObject;
    if (this.ajeG != paramObject.ajeG)
    {
      AppMethodBeat.o(59328);
      return false;
    }
    if (!this.name.equals(paramObject.name))
    {
      AppMethodBeat.o(59328);
      return false;
    }
    AppMethodBeat.o(59328);
    return true;
  }
  
  public final String getIdentifier()
  {
    AppMethodBeat.i(59322);
    if (this.ajeG)
    {
      localObject = new IllegalStateException("not identifier: ".concat(String.valueOf(this)));
      AppMethodBeat.o(59322);
      throw ((Throwable)localObject);
    }
    Object localObject = PF();
    if (localObject == null) {
      aKu(2);
    }
    AppMethodBeat.o(59322);
    return localObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59329);
    int j = this.name.hashCode();
    if (this.ajeG) {}
    for (int i = 1;; i = 0)
    {
      AppMethodBeat.o(59329);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    return this.name;
  }
  
  public final int v(f paramf)
  {
    AppMethodBeat.i(59323);
    int i = this.name.compareTo(paramf.name);
    AppMethodBeat.o(59323);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.f.f
 * JD-Core Version:    0.7.0.1
 */