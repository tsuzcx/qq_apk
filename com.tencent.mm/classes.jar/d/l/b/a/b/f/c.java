package d.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public final class c
{
  private static final f NNo;
  private static final Pattern NNp;
  private static final d.g.a.b<String, f> NNq;
  public final String NNr;
  private transient b NNs;
  private transient c NNt;
  private transient f NNu;
  
  static
  {
    AppMethodBeat.i(59315);
    NNo = f.bek("<root>");
    NNp = Pattern.compile("\\.");
    NNq = new d.g.a.b() {};
    AppMethodBeat.o(59315);
  }
  
  private c(String paramString)
  {
    AppMethodBeat.i(59299);
    this.NNr = paramString;
    AppMethodBeat.o(59299);
  }
  
  c(String paramString, b paramb)
  {
    AppMethodBeat.i(59298);
    this.NNr = paramString;
    this.NNs = paramb;
    AppMethodBeat.o(59298);
  }
  
  private c(String paramString, c paramc, f paramf)
  {
    AppMethodBeat.i(59300);
    this.NNr = paramString;
    this.NNt = paramc;
    this.NNu = paramf;
    AppMethodBeat.o(59300);
  }
  
  private void compute()
  {
    AppMethodBeat.i(59301);
    int i = this.NNr.lastIndexOf('.');
    if (i >= 0)
    {
      this.NNu = f.bel(this.NNr.substring(i + 1));
      this.NNt = new c(this.NNr.substring(0, i));
      AppMethodBeat.o(59301);
      return;
    }
    this.NNu = f.bel(this.NNr);
    this.NNt = b.NNl.gvH();
    AppMethodBeat.o(59301);
  }
  
  public static c t(f paramf)
  {
    AppMethodBeat.i(59311);
    if (paramf == null) {
      ajW(16);
    }
    paramf = new c(paramf.sD(), b.NNl.gvH(), paramf);
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
    if (!this.NNr.equals(paramObject.NNr))
    {
      AppMethodBeat.o(59313);
      return false;
    }
    AppMethodBeat.o(59313);
    return true;
  }
  
  public final f gvJ()
  {
    AppMethodBeat.i(59307);
    if (this.NNu != null)
    {
      localObject = this.NNu;
      if (localObject == null) {
        ajW(10);
      }
      AppMethodBeat.o(59307);
      return localObject;
    }
    if (this.NNr.isEmpty())
    {
      localObject = new IllegalStateException("root");
      AppMethodBeat.o(59307);
      throw ((Throwable)localObject);
    }
    compute();
    Object localObject = this.NNu;
    if (localObject == null) {
      ajW(11);
    }
    AppMethodBeat.o(59307);
    return localObject;
  }
  
  public final f gvK()
  {
    AppMethodBeat.i(59308);
    if (this.NNr.isEmpty())
    {
      localf = NNo;
      if (localf == null) {
        ajW(12);
      }
      AppMethodBeat.o(59308);
      return localf;
    }
    f localf = gvJ();
    if (localf == null) {
      ajW(13);
    }
    AppMethodBeat.o(59308);
    return localf;
  }
  
  public final boolean gvL()
  {
    AppMethodBeat.i(59303);
    if ((this.NNs != null) || (sD().indexOf('<') < 0))
    {
      AppMethodBeat.o(59303);
      return true;
    }
    AppMethodBeat.o(59303);
    return false;
  }
  
  public final b gvM()
  {
    AppMethodBeat.i(59304);
    if (this.NNs != null)
    {
      localb = this.NNs;
      if (localb == null) {
        ajW(5);
      }
      AppMethodBeat.o(59304);
      return localb;
    }
    this.NNs = new b(this);
    b localb = this.NNs;
    if (localb == null) {
      ajW(6);
    }
    AppMethodBeat.o(59304);
    return localb;
  }
  
  public final c gvN()
  {
    AppMethodBeat.i(59305);
    if (this.NNt != null)
    {
      localObject = this.NNt;
      if (localObject == null) {
        ajW(7);
      }
      AppMethodBeat.o(59305);
      return localObject;
    }
    if (this.NNr.isEmpty())
    {
      localObject = new IllegalStateException("root");
      AppMethodBeat.o(59305);
      throw ((Throwable)localObject);
    }
    compute();
    Object localObject = this.NNt;
    if (localObject == null) {
      ajW(8);
    }
    AppMethodBeat.o(59305);
    return localObject;
  }
  
  public final List<f> gvO()
  {
    AppMethodBeat.i(59309);
    if (this.NNr.isEmpty()) {}
    for (List localList = Collections.emptyList();; localList = e.a(NNp.split(this.NNr), NNq))
    {
      if (localList == null) {
        ajW(14);
      }
      AppMethodBeat.o(59309);
      return localList;
    }
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59314);
    int i = this.NNr.hashCode();
    AppMethodBeat.o(59314);
    return i;
  }
  
  public final boolean q(f paramf)
  {
    AppMethodBeat.i(59310);
    if (paramf == null) {
      ajW(15);
    }
    if (this.NNr.isEmpty())
    {
      AppMethodBeat.o(59310);
      return false;
    }
    int j = this.NNr.indexOf('.');
    String str = this.NNr;
    paramf = paramf.sD();
    int i = j;
    if (j == -1) {
      i = this.NNr.length();
    }
    boolean bool = str.regionMatches(0, paramf, 0, i);
    AppMethodBeat.o(59310);
    return bool;
  }
  
  public final c s(f paramf)
  {
    AppMethodBeat.i(59306);
    if (paramf == null) {
      ajW(9);
    }
    if (this.NNr.isEmpty()) {}
    for (String str = paramf.sD();; str = this.NNr + "." + paramf.sD())
    {
      paramf = new c(str, this, paramf);
      AppMethodBeat.o(59306);
      return paramf;
    }
  }
  
  public final String sD()
  {
    AppMethodBeat.i(59302);
    String str = this.NNr;
    if (str == null) {
      ajW(4);
    }
    AppMethodBeat.o(59302);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59312);
    if (this.NNr.isEmpty()) {}
    for (String str = NNo.sD();; str = this.NNr)
    {
      if (str == null) {
        ajW(17);
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