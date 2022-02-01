package d.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public final class c
{
  private static final f Lzl;
  private static final Pattern Lzm;
  private static final d.g.a.b<String, f> Lzn;
  public final String Lzo;
  private transient b Lzp;
  private transient c Lzq;
  private transient f Lzr;
  
  static
  {
    AppMethodBeat.i(59315);
    Lzl = f.aWD("<root>");
    Lzm = Pattern.compile("\\.");
    Lzn = new d.g.a.b() {};
    AppMethodBeat.o(59315);
  }
  
  private c(String paramString)
  {
    AppMethodBeat.i(59299);
    this.Lzo = paramString;
    AppMethodBeat.o(59299);
  }
  
  c(String paramString, b paramb)
  {
    AppMethodBeat.i(59298);
    this.Lzo = paramString;
    this.Lzp = paramb;
    AppMethodBeat.o(59298);
  }
  
  private c(String paramString, c paramc, f paramf)
  {
    AppMethodBeat.i(59300);
    this.Lzo = paramString;
    this.Lzq = paramc;
    this.Lzr = paramf;
    AppMethodBeat.o(59300);
  }
  
  private void compute()
  {
    AppMethodBeat.i(59301);
    int i = this.Lzo.lastIndexOf('.');
    if (i >= 0)
    {
      this.Lzr = f.aWE(this.Lzo.substring(i + 1));
      this.Lzq = new c(this.Lzo.substring(0, i));
      AppMethodBeat.o(59301);
      return;
    }
    this.Lzr = f.aWE(this.Lzo);
    this.Lzq = b.Lzi.fZG();
    AppMethodBeat.o(59301);
  }
  
  public static c t(f paramf)
  {
    AppMethodBeat.i(59311);
    if (paramf == null) {
      agL(16);
    }
    paramf = new c(paramf.rf(), b.Lzi.fZG(), paramf);
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
    if (!this.Lzo.equals(paramObject.Lzo))
    {
      AppMethodBeat.o(59313);
      return false;
    }
    AppMethodBeat.o(59313);
    return true;
  }
  
  public final f fZI()
  {
    AppMethodBeat.i(59307);
    if (this.Lzr != null)
    {
      localObject = this.Lzr;
      if (localObject == null) {
        agL(10);
      }
      AppMethodBeat.o(59307);
      return localObject;
    }
    if (this.Lzo.isEmpty())
    {
      localObject = new IllegalStateException("root");
      AppMethodBeat.o(59307);
      throw ((Throwable)localObject);
    }
    compute();
    Object localObject = this.Lzr;
    if (localObject == null) {
      agL(11);
    }
    AppMethodBeat.o(59307);
    return localObject;
  }
  
  public final f fZJ()
  {
    AppMethodBeat.i(59308);
    if (this.Lzo.isEmpty())
    {
      localf = Lzl;
      if (localf == null) {
        agL(12);
      }
      AppMethodBeat.o(59308);
      return localf;
    }
    f localf = fZI();
    if (localf == null) {
      agL(13);
    }
    AppMethodBeat.o(59308);
    return localf;
  }
  
  public final boolean fZK()
  {
    AppMethodBeat.i(59303);
    if ((this.Lzp != null) || (rf().indexOf('<') < 0))
    {
      AppMethodBeat.o(59303);
      return true;
    }
    AppMethodBeat.o(59303);
    return false;
  }
  
  public final b fZL()
  {
    AppMethodBeat.i(59304);
    if (this.Lzp != null)
    {
      localb = this.Lzp;
      if (localb == null) {
        agL(5);
      }
      AppMethodBeat.o(59304);
      return localb;
    }
    this.Lzp = new b(this);
    b localb = this.Lzp;
    if (localb == null) {
      agL(6);
    }
    AppMethodBeat.o(59304);
    return localb;
  }
  
  public final c fZM()
  {
    AppMethodBeat.i(59305);
    if (this.Lzq != null)
    {
      localObject = this.Lzq;
      if (localObject == null) {
        agL(7);
      }
      AppMethodBeat.o(59305);
      return localObject;
    }
    if (this.Lzo.isEmpty())
    {
      localObject = new IllegalStateException("root");
      AppMethodBeat.o(59305);
      throw ((Throwable)localObject);
    }
    compute();
    Object localObject = this.Lzq;
    if (localObject == null) {
      agL(8);
    }
    AppMethodBeat.o(59305);
    return localObject;
  }
  
  public final List<f> fZN()
  {
    AppMethodBeat.i(59309);
    if (this.Lzo.isEmpty()) {}
    for (List localList = Collections.emptyList();; localList = e.a(Lzm.split(this.Lzo), Lzn))
    {
      if (localList == null) {
        agL(14);
      }
      AppMethodBeat.o(59309);
      return localList;
    }
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59314);
    int i = this.Lzo.hashCode();
    AppMethodBeat.o(59314);
    return i;
  }
  
  public final boolean q(f paramf)
  {
    AppMethodBeat.i(59310);
    if (paramf == null) {
      agL(15);
    }
    if (this.Lzo.isEmpty())
    {
      AppMethodBeat.o(59310);
      return false;
    }
    int j = this.Lzo.indexOf('.');
    String str = this.Lzo;
    paramf = paramf.rf();
    int i = j;
    if (j == -1) {
      i = this.Lzo.length();
    }
    boolean bool = str.regionMatches(0, paramf, 0, i);
    AppMethodBeat.o(59310);
    return bool;
  }
  
  public final String rf()
  {
    AppMethodBeat.i(59302);
    String str = this.Lzo;
    if (str == null) {
      agL(4);
    }
    AppMethodBeat.o(59302);
    return str;
  }
  
  public final c s(f paramf)
  {
    AppMethodBeat.i(59306);
    if (paramf == null) {
      agL(9);
    }
    if (this.Lzo.isEmpty()) {}
    for (String str = paramf.rf();; str = this.Lzo + "." + paramf.rf())
    {
      paramf = new c(str, this, paramf);
      AppMethodBeat.o(59306);
      return paramf;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59312);
    if (this.Lzo.isEmpty()) {}
    for (String str = Lzl.rf();; str = this.Lzo)
    {
      if (str == null) {
        agL(17);
      }
      AppMethodBeat.o(59312);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.f.c
 * JD-Core Version:    0.7.0.1
 */