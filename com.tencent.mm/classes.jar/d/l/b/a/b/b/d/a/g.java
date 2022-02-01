package d.l.b.a.b.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.d.b.n.a;
import d.l.b.a.b.d.b.n.a.b;
import d.l.b.a.b.f.b;
import d.l.b.a.b.f.c;
import java.io.InputStream;

public final class g
  implements d.l.b.a.b.d.b.n
{
  private final ClassLoader MZU;
  
  public g(ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(57377);
    this.MZU = paramClassLoader;
    AppMethodBeat.o(57377);
  }
  
  private final n.a bcm(String paramString)
  {
    AppMethodBeat.i(57373);
    paramString = e.a(this.MZU, paramString);
    if (paramString != null)
    {
      f.a locala = f.MZX;
      paramString = f.a.bw(paramString);
      if (paramString == null) {}
    }
    for (paramString = new n.a.b((d.l.b.a.b.d.b.p)paramString);; paramString = null)
    {
      paramString = (n.a)paramString;
      AppMethodBeat.o(57373);
      return paramString;
    }
  }
  
  public final n.a a(d.l.b.a.b.d.a.e.g paramg)
  {
    AppMethodBeat.i(57375);
    d.g.b.p.h(paramg, "javaClass");
    paramg = paramg.gjg();
    if (paramg != null)
    {
      paramg = paramg.sD();
      if (paramg != null) {}
    }
    else
    {
      AppMethodBeat.o(57375);
      return null;
    }
    paramg = bcm(paramg);
    AppMethodBeat.o(57375);
    return paramg;
  }
  
  public final n.a c(d.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(57374);
    d.g.b.p.h(parama, "classId");
    String str = parama.gra().sD();
    d.g.b.p.g(str, "relativeClassName.asString()");
    str = d.n.n.a(str, '.', '$');
    b localb = parama.gqZ();
    d.g.b.p.g(localb, "packageFqName");
    if (localb.Nqg.Nql.isEmpty()) {}
    for (parama = str;; parama = parama.gqZ() + '.' + str)
    {
      parama = bcm(parama);
      AppMethodBeat.o(57374);
      return parama;
    }
  }
  
  public final InputStream k(b paramb)
  {
    AppMethodBeat.i(57376);
    d.g.b.p.h(paramb, "packageFqName");
    if (!paramb.q(d.l.b.a.b.a.g.MPP))
    {
      AppMethodBeat.o(57376);
      return null;
    }
    ClassLoader localClassLoader = this.MZU;
    Object localObject = d.l.b.a.b.k.a.a.a.NzQ;
    d.g.b.p.h(paramb, "fqName");
    localObject = new StringBuilder();
    String str = paramb.sD();
    d.g.b.p.g(str, "fqName.asString()");
    localObject = ((StringBuilder)localObject).append(d.n.n.a(str, '.', '/')).append("/");
    d.g.b.p.h(paramb, "fqName");
    paramb = localClassLoader.getResourceAsStream(new StringBuilder().append(d.l.b.a.b.k.a.a.a.r(paramb)).append(".kotlin_builtins").toString());
    AppMethodBeat.o(57376);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.d.a.g
 * JD-Core Version:    0.7.0.1
 */