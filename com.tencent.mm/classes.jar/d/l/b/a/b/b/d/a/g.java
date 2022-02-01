package d.l.b.a.b.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.d.b.n.a;
import d.l.b.a.b.d.b.n.a.b;
import d.l.b.a.b.d.b.p;
import d.l.b.a.b.f.b;
import d.l.b.a.b.f.c;
import java.io.InputStream;

public final class g
  implements d.l.b.a.b.d.b.n
{
  private final ClassLoader JvF;
  
  public g(ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(57377);
    this.JvF = paramClassLoader;
    AppMethodBeat.o(57377);
  }
  
  private final n.a aQk(String paramString)
  {
    AppMethodBeat.i(57373);
    paramString = e.a(this.JvF, paramString);
    if (paramString != null)
    {
      f.a locala = f.JvI;
      paramString = f.a.br(paramString);
      if (paramString == null) {}
    }
    for (paramString = new n.a.b((p)paramString);; paramString = null)
    {
      paramString = (n.a)paramString;
      AppMethodBeat.o(57373);
      return paramString;
    }
  }
  
  public final n.a a(d.l.b.a.b.d.a.e.g paramg)
  {
    AppMethodBeat.i(57375);
    k.h(paramg, "javaClass");
    paramg = paramg.fzd();
    if (paramg != null)
    {
      paramg = paramg.qV();
      if (paramg != null) {}
    }
    else
    {
      AppMethodBeat.o(57375);
      return null;
    }
    paramg = aQk(paramg);
    AppMethodBeat.o(57375);
    return paramg;
  }
  
  public final n.a c(d.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(57374);
    k.h(parama, "classId");
    String str = parama.fGX().qV();
    k.g(str, "relativeClassName.asString()");
    str = d.n.n.a(str, '.', '$');
    b localb = parama.fGW();
    k.g(localb, "packageFqName");
    if (localb.JLQ.JLV.isEmpty()) {}
    for (parama = str;; parama = parama.fGW() + '.' + str)
    {
      parama = aQk(parama);
      AppMethodBeat.o(57374);
      return parama;
    }
  }
  
  public final InputStream k(b paramb)
  {
    AppMethodBeat.i(57376);
    k.h(paramb, "packageFqName");
    if (!paramb.q(d.l.b.a.b.a.g.JlA))
    {
      AppMethodBeat.o(57376);
      return null;
    }
    ClassLoader localClassLoader = this.JvF;
    Object localObject = d.l.b.a.b.k.a.a.a.JVz;
    k.h(paramb, "fqName");
    localObject = new StringBuilder();
    String str = paramb.qV();
    k.g(str, "fqName.asString()");
    localObject = ((StringBuilder)localObject).append(d.n.n.a(str, '.', '/')).append("/");
    k.h(paramb, "fqName");
    paramb = localClassLoader.getResourceAsStream(new StringBuilder().append(d.l.b.a.b.k.a.a.a.r(paramb)).append(".kotlin_builtins").toString());
    AppMethodBeat.o(57376);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.d.a.g
 * JD-Core Version:    0.7.0.1
 */