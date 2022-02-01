package kotlin.l.b.a.b.b.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import kotlin.g.b.s;
import kotlin.l.b.a.b.a.k;
import kotlin.l.b.a.b.d.b.m;
import kotlin.l.b.a.b.d.b.m.a;
import kotlin.l.b.a.b.d.b.m.a.b;
import kotlin.l.b.a.b.d.b.o;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.d;
import kotlin.l.b.a.b.k.a.a.a;
import kotlin.n.n;

public final class g
  implements m
{
  private final kotlin.l.b.a.b.k.a.a.c aiMC;
  private final ClassLoader aiMy;
  
  public g(ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(57377);
    this.aiMy = paramClassLoader;
    this.aiMC = new kotlin.l.b.a.b.k.a.a.c();
    AppMethodBeat.o(57377);
  }
  
  private final m.a bIK(String paramString)
  {
    AppMethodBeat.i(57373);
    paramString = e.e(this.aiMy, paramString);
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      paramString = (m.a)paramString;
      AppMethodBeat.o(57373);
      return paramString;
      f.a locala = f.aiMz;
      paramString = f.a.cH(paramString);
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = new m.a.b((o)paramString, (byte)0);
      }
    }
  }
  
  public final m.a a(kotlin.l.b.a.b.d.a.e.g paramg)
  {
    AppMethodBeat.i(57375);
    s.u(paramg, "javaClass");
    paramg = paramg.koY();
    if (paramg == null) {}
    for (paramg = null; paramg == null; paramg = paramg.PF())
    {
      AppMethodBeat.o(57375);
      return null;
    }
    paramg = bIK(paramg);
    AppMethodBeat.o(57375);
    return paramg;
  }
  
  public final m.a c(b paramb)
  {
    AppMethodBeat.i(57374);
    s.u(paramb, "classId");
    String str = paramb.kxM().PF();
    s.s(str, "relativeClassName.asString()");
    str = n.a(str, '.', '$');
    if (paramb.kxL().ajex.ajeC.isEmpty()) {}
    for (paramb = str;; paramb = paramb.kxL() + '.' + str)
    {
      paramb = bIK(paramb);
      AppMethodBeat.o(57374);
      return paramb;
    }
  }
  
  public final InputStream l(kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(57376);
    s.u(paramc, "packageFqName");
    if (!paramc.r(k.aiCq))
    {
      AppMethodBeat.o(57376);
      return null;
    }
    Object localObject1 = this.aiMC;
    Object localObject2 = a.ajnb;
    s.u(paramc, "fqName");
    localObject2 = new StringBuilder();
    String str = paramc.PF();
    s.s(str, "fqName.asString()");
    localObject2 = ((StringBuilder)localObject2).append(n.a(str, '.', '/')).append('/');
    s.u(paramc, "fqName");
    paramc = s.X(a.u(paramc), ".kotlin_builtins");
    s.u(paramc, "path");
    localObject1 = localObject1.getClass().getClassLoader();
    if (localObject1 == null)
    {
      paramc = ClassLoader.getSystemResourceAsStream(paramc);
      AppMethodBeat.o(57376);
      return paramc;
    }
    paramc = ((ClassLoader)localObject1).getResource(paramc);
    if (paramc == null)
    {
      AppMethodBeat.o(57376);
      return null;
    }
    paramc = paramc.openConnection();
    paramc.setUseCaches(false);
    paramc = paramc.getInputStream();
    AppMethodBeat.o(57376);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.a.g
 * JD-Core Version:    0.7.0.1
 */