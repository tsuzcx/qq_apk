package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.a.e;

public final class c
{
  private static final f abfG;
  private static final Pattern abfH;
  private static final kotlin.g.a.b<String, f> abfI;
  public final String abfJ;
  private transient b abfK;
  private transient c abfL;
  private transient f abfM;
  
  static
  {
    AppMethodBeat.i(59315);
    abfG = f.bHd("<root>");
    abfH = Pattern.compile("\\.");
    abfI = new kotlin.g.a.b() {};
    AppMethodBeat.o(59315);
  }
  
  private c(String paramString)
  {
    AppMethodBeat.i(59299);
    this.abfJ = paramString;
    AppMethodBeat.o(59299);
  }
  
  c(String paramString, b paramb)
  {
    AppMethodBeat.i(59298);
    this.abfJ = paramString;
    this.abfK = paramb;
    AppMethodBeat.o(59298);
  }
  
  private c(String paramString, c paramc, f paramf)
  {
    AppMethodBeat.i(59300);
    this.abfJ = paramString;
    this.abfL = paramc;
    this.abfM = paramf;
    AppMethodBeat.o(59300);
  }
  
  private void compute()
  {
    AppMethodBeat.i(59301);
    int i = this.abfJ.lastIndexOf('.');
    if (i >= 0)
    {
      this.abfM = f.bHe(this.abfJ.substring(i + 1));
      this.abfL = new c(this.abfJ.substring(0, i));
      AppMethodBeat.o(59301);
      return;
    }
    this.abfM = f.bHe(this.abfJ);
    this.abfL = b.abfD.iNy();
    AppMethodBeat.o(59301);
  }
  
  public static c t(f paramf)
  {
    AppMethodBeat.i(59311);
    if (paramf == null) {
      aDG(16);
    }
    paramf = new c(paramf.qu(), b.abfD.iNy(), paramf);
    AppMethodBeat.o(59311);
    return paramf;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(59313);
    if (this == paramObject)
    {
      AppMethodBeat.o(59313);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(59313);
      return false;
    }
    paramObject = (c)paramObject;
    if (!this.abfJ.equals(paramObject.abfJ))
    {
      AppMethodBeat.o(59313);
      return false;
    }
    AppMethodBeat.o(59313);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59314);
    int i = this.abfJ.hashCode();
    AppMethodBeat.o(59314);
    return i;
  }
  
  public final f iNA()
  {
    AppMethodBeat.i(59307);
    if (this.abfM != null)
    {
      localObject = this.abfM;
      if (localObject == null) {
        aDG(10);
      }
      AppMethodBeat.o(59307);
      return localObject;
    }
    if (this.abfJ.isEmpty())
    {
      localObject = new IllegalStateException("root");
      AppMethodBeat.o(59307);
      throw ((Throwable)localObject);
    }
    compute();
    Object localObject = this.abfM;
    if (localObject == null) {
      aDG(11);
    }
    AppMethodBeat.o(59307);
    return localObject;
  }
  
  public final f iNB()
  {
    AppMethodBeat.i(59308);
    if (this.abfJ.isEmpty())
    {
      localf = abfG;
      if (localf == null) {
        aDG(12);
      }
      AppMethodBeat.o(59308);
      return localf;
    }
    f localf = iNA();
    if (localf == null) {
      aDG(13);
    }
    AppMethodBeat.o(59308);
    return localf;
  }
  
  public final boolean iNC()
  {
    AppMethodBeat.i(59303);
    if ((this.abfK != null) || (qu().indexOf('<') < 0))
    {
      AppMethodBeat.o(59303);
      return true;
    }
    AppMethodBeat.o(59303);
    return false;
  }
  
  public final b iND()
  {
    AppMethodBeat.i(59304);
    if (this.abfK != null)
    {
      localb = this.abfK;
      if (localb == null) {
        aDG(5);
      }
      AppMethodBeat.o(59304);
      return localb;
    }
    this.abfK = new b(this);
    b localb = this.abfK;
    if (localb == null) {
      aDG(6);
    }
    AppMethodBeat.o(59304);
    return localb;
  }
  
  public final c iNE()
  {
    AppMethodBeat.i(59305);
    if (this.abfL != null)
    {
      localObject = this.abfL;
      if (localObject == null) {
        aDG(7);
      }
      AppMethodBeat.o(59305);
      return localObject;
    }
    if (this.abfJ.isEmpty())
    {
      localObject = new IllegalStateException("root");
      AppMethodBeat.o(59305);
      throw ((Throwable)localObject);
    }
    compute();
    Object localObject = this.abfL;
    if (localObject == null) {
      aDG(8);
    }
    AppMethodBeat.o(59305);
    return localObject;
  }
  
  public final List<f> iNF()
  {
    AppMethodBeat.i(59309);
    if (this.abfJ.isEmpty()) {}
    for (List localList = Collections.emptyList();; localList = e.a(abfH.split(this.abfJ), abfI))
    {
      if (localList == null) {
        aDG(14);
      }
      AppMethodBeat.o(59309);
      return localList;
    }
  }
  
  public final boolean q(f paramf)
  {
    AppMethodBeat.i(59310);
    if (paramf == null) {
      aDG(15);
    }
    if (this.abfJ.isEmpty())
    {
      AppMethodBeat.o(59310);
      return false;
    }
    int j = this.abfJ.indexOf('.');
    String str = this.abfJ;
    paramf = paramf.qu();
    int i = j;
    if (j == -1) {
      i = this.abfJ.length();
    }
    boolean bool = str.regionMatches(0, paramf, 0, i);
    AppMethodBeat.o(59310);
    return bool;
  }
  
  public final String qu()
  {
    AppMethodBeat.i(59302);
    String str = this.abfJ;
    if (str == null) {
      aDG(4);
    }
    AppMethodBeat.o(59302);
    return str;
  }
  
  public final c s(f paramf)
  {
    AppMethodBeat.i(59306);
    if (paramf == null) {
      aDG(9);
    }
    if (this.abfJ.isEmpty()) {}
    for (String str = paramf.qu();; str = this.abfJ + "." + paramf.qu())
    {
      paramf = new c(str, this, paramf);
      AppMethodBeat.o(59306);
      return paramf;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59312);
    if (this.abfJ.isEmpty()) {}
    for (String str = abfG.qu();; str = this.abfJ)
    {
      if (str == null) {
        aDG(17);
      }
      AppMethodBeat.o(59312);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.f.c
 * JD-Core Version:    0.7.0.1
 */