package d.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public final class c
{
  private static final f Nqi;
  private static final Pattern Nqj;
  private static final d.g.a.b<String, f> Nqk;
  public final String Nql;
  private transient b Nqm;
  private transient c Nqn;
  private transient f Nqo;
  
  static
  {
    AppMethodBeat.i(59315);
    Nqi = f.bcG("<root>");
    Nqj = Pattern.compile("\\.");
    Nqk = new d.g.a.b() {};
    AppMethodBeat.o(59315);
  }
  
  private c(String paramString)
  {
    AppMethodBeat.i(59299);
    this.Nql = paramString;
    AppMethodBeat.o(59299);
  }
  
  c(String paramString, b paramb)
  {
    AppMethodBeat.i(59298);
    this.Nql = paramString;
    this.Nqm = paramb;
    AppMethodBeat.o(59298);
  }
  
  private c(String paramString, c paramc, f paramf)
  {
    AppMethodBeat.i(59300);
    this.Nql = paramString;
    this.Nqn = paramc;
    this.Nqo = paramf;
    AppMethodBeat.o(59300);
  }
  
  private void compute()
  {
    AppMethodBeat.i(59301);
    int i = this.Nql.lastIndexOf('.');
    if (i >= 0)
    {
      this.Nqo = f.bcH(this.Nql.substring(i + 1));
      this.Nqn = new c(this.Nql.substring(0, i));
      AppMethodBeat.o(59301);
      return;
    }
    this.Nqo = f.bcH(this.Nql);
    this.Nqn = b.Nqf.grf();
    AppMethodBeat.o(59301);
  }
  
  public static c t(f paramf)
  {
    AppMethodBeat.i(59311);
    if (paramf == null) {
      ajm(16);
    }
    paramf = new c(paramf.sD(), b.Nqf.grf(), paramf);
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
    if (!this.Nql.equals(paramObject.Nql))
    {
      AppMethodBeat.o(59313);
      return false;
    }
    AppMethodBeat.o(59313);
    return true;
  }
  
  public final f grh()
  {
    AppMethodBeat.i(59307);
    if (this.Nqo != null)
    {
      localObject = this.Nqo;
      if (localObject == null) {
        ajm(10);
      }
      AppMethodBeat.o(59307);
      return localObject;
    }
    if (this.Nql.isEmpty())
    {
      localObject = new IllegalStateException("root");
      AppMethodBeat.o(59307);
      throw ((Throwable)localObject);
    }
    compute();
    Object localObject = this.Nqo;
    if (localObject == null) {
      ajm(11);
    }
    AppMethodBeat.o(59307);
    return localObject;
  }
  
  public final f gri()
  {
    AppMethodBeat.i(59308);
    if (this.Nql.isEmpty())
    {
      localf = Nqi;
      if (localf == null) {
        ajm(12);
      }
      AppMethodBeat.o(59308);
      return localf;
    }
    f localf = grh();
    if (localf == null) {
      ajm(13);
    }
    AppMethodBeat.o(59308);
    return localf;
  }
  
  public final boolean grj()
  {
    AppMethodBeat.i(59303);
    if ((this.Nqm != null) || (sD().indexOf('<') < 0))
    {
      AppMethodBeat.o(59303);
      return true;
    }
    AppMethodBeat.o(59303);
    return false;
  }
  
  public final b grk()
  {
    AppMethodBeat.i(59304);
    if (this.Nqm != null)
    {
      localb = this.Nqm;
      if (localb == null) {
        ajm(5);
      }
      AppMethodBeat.o(59304);
      return localb;
    }
    this.Nqm = new b(this);
    b localb = this.Nqm;
    if (localb == null) {
      ajm(6);
    }
    AppMethodBeat.o(59304);
    return localb;
  }
  
  public final c grl()
  {
    AppMethodBeat.i(59305);
    if (this.Nqn != null)
    {
      localObject = this.Nqn;
      if (localObject == null) {
        ajm(7);
      }
      AppMethodBeat.o(59305);
      return localObject;
    }
    if (this.Nql.isEmpty())
    {
      localObject = new IllegalStateException("root");
      AppMethodBeat.o(59305);
      throw ((Throwable)localObject);
    }
    compute();
    Object localObject = this.Nqn;
    if (localObject == null) {
      ajm(8);
    }
    AppMethodBeat.o(59305);
    return localObject;
  }
  
  public final List<f> grm()
  {
    AppMethodBeat.i(59309);
    if (this.Nql.isEmpty()) {}
    for (List localList = Collections.emptyList();; localList = e.a(Nqj.split(this.Nql), Nqk))
    {
      if (localList == null) {
        ajm(14);
      }
      AppMethodBeat.o(59309);
      return localList;
    }
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59314);
    int i = this.Nql.hashCode();
    AppMethodBeat.o(59314);
    return i;
  }
  
  public final boolean q(f paramf)
  {
    AppMethodBeat.i(59310);
    if (paramf == null) {
      ajm(15);
    }
    if (this.Nql.isEmpty())
    {
      AppMethodBeat.o(59310);
      return false;
    }
    int j = this.Nql.indexOf('.');
    String str = this.Nql;
    paramf = paramf.sD();
    int i = j;
    if (j == -1) {
      i = this.Nql.length();
    }
    boolean bool = str.regionMatches(0, paramf, 0, i);
    AppMethodBeat.o(59310);
    return bool;
  }
  
  public final c s(f paramf)
  {
    AppMethodBeat.i(59306);
    if (paramf == null) {
      ajm(9);
    }
    if (this.Nql.isEmpty()) {}
    for (String str = paramf.sD();; str = this.Nql + "." + paramf.sD())
    {
      paramf = new c(str, this, paramf);
      AppMethodBeat.o(59306);
      return paramf;
    }
  }
  
  public final String sD()
  {
    AppMethodBeat.i(59302);
    String str = this.Nql;
    if (str == null) {
      ajm(4);
    }
    AppMethodBeat.o(59302);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59312);
    if (this.Nql.isEmpty()) {}
    for (String str = Nqi.sD();; str = this.Nql)
    {
      if (str == null) {
        ajm(17);
      }
      AppMethodBeat.o(59312);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.f.c
 * JD-Core Version:    0.7.0.1
 */