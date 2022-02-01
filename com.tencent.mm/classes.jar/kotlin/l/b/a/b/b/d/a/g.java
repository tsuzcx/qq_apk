package kotlin.l.b.a.b.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import kotlin.l.b.a.b.d.b.n.a;
import kotlin.l.b.a.b.d.b.n.a.b;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.c;

public final class g
  implements kotlin.l.b.a.b.d.b.n
{
  private final ClassLoader TmI;
  
  public g(ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(57377);
    this.TmI = paramClassLoader;
    AppMethodBeat.o(57377);
  }
  
  private final n.a btG(String paramString)
  {
    AppMethodBeat.i(57373);
    paramString = e.a(this.TmI, paramString);
    if (paramString != null)
    {
      f.a locala = f.TmL;
      paramString = f.a.bw(paramString);
      if (paramString == null) {}
    }
    for (paramString = new n.a.b((kotlin.l.b.a.b.d.b.p)paramString);; paramString = null)
    {
      paramString = (n.a)paramString;
      AppMethodBeat.o(57373);
      return paramString;
    }
  }
  
  public final n.a a(kotlin.l.b.a.b.d.a.e.g paramg)
  {
    AppMethodBeat.i(57375);
    kotlin.g.b.p.h(paramg, "javaClass");
    paramg = paramg.hBk();
    if (paramg != null)
    {
      paramg = paramg.sG();
      if (paramg != null) {}
    }
    else
    {
      AppMethodBeat.o(57375);
      return null;
    }
    paramg = btG(paramg);
    AppMethodBeat.o(57375);
    return paramg;
  }
  
  public final n.a c(kotlin.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(57374);
    kotlin.g.b.p.h(parama, "classId");
    String str = parama.hIZ().sG();
    kotlin.g.b.p.g(str, "relativeClassName.asString()");
    str = kotlin.n.n.a(str, '.', '$');
    b localb = parama.hIY();
    kotlin.g.b.p.g(localb, "packageFqName");
    if (localb.TCR.TCW.isEmpty()) {}
    for (parama = str;; parama = parama.hIY() + '.' + str)
    {
      parama = btG(parama);
      AppMethodBeat.o(57374);
      return parama;
    }
  }
  
  public final InputStream k(b paramb)
  {
    AppMethodBeat.i(57376);
    kotlin.g.b.p.h(paramb, "packageFqName");
    if (!paramb.q(kotlin.l.b.a.b.a.g.TcC))
    {
      AppMethodBeat.o(57376);
      return null;
    }
    ClassLoader localClassLoader = this.TmI;
    Object localObject = kotlin.l.b.a.b.k.a.a.a.TLQ;
    kotlin.g.b.p.h(paramb, "fqName");
    localObject = new StringBuilder();
    String str = paramb.sG();
    kotlin.g.b.p.g(str, "fqName.asString()");
    localObject = ((StringBuilder)localObject).append(kotlin.n.n.a(str, '.', '/')).append("/");
    kotlin.g.b.p.h(paramb, "fqName");
    paramb = localClassLoader.getResourceAsStream(new StringBuilder().append(kotlin.l.b.a.b.k.a.a.a.r(paramb)).append(".kotlin_builtins").toString());
    AppMethodBeat.o(57376);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.a.g
 * JD-Core Version:    0.7.0.1
 */