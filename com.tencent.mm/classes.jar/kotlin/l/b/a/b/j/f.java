package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.b.bf;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.bl;

public final class f
{
  private static final c ajiV;
  
  static
  {
    AppMethodBeat.i(192195);
    ajiV = new c("kotlin.jvm.JvmInline");
    AppMethodBeat.o(192195);
  }
  
  public static final boolean D(l paraml)
  {
    AppMethodBeat.i(59941);
    s.u(paraml, "<this>");
    if (((paraml instanceof e)) && ((((e)paraml).kng()) || (((e)paraml).isValue())))
    {
      AppMethodBeat.o(59941);
      return true;
    }
    AppMethodBeat.o(59941);
    return false;
  }
  
  public static final boolean R(ad paramad)
  {
    AppMethodBeat.i(59942);
    s.u(paramad, "<this>");
    paramad = paramad.kzm().knA();
    if (paramad == null)
    {
      AppMethodBeat.o(59942);
      return false;
    }
    boolean bool = D((l)paramad);
    AppMethodBeat.o(59942);
    return bool;
  }
  
  public static final ad S(ad paramad)
  {
    AppMethodBeat.i(59943);
    s.u(paramad, "<this>");
    s.u(paramad, "<this>");
    h localh = paramad.kzm().knA();
    Object localObject = localh;
    if (!(localh instanceof e)) {
      localObject = null;
    }
    localObject = (e)localObject;
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      localObject = (ad)localObject;
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(59943);
      return null;
      localObject = ((e)localObject).knn();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = (al)((y)localObject).aiGW;
      }
    }
    paramad = be.aq(paramad).c((ad)localObject, bl.ajqM);
    AppMethodBeat.o(59943);
    return paramad;
  }
  
  public static final boolean a(bf parambf)
  {
    AppMethodBeat.i(59945);
    s.u(parambf, "<this>");
    if (parambf.knY() == null)
    {
      Object localObject = parambf.knp();
      if ((localObject instanceof e))
      {
        localObject = (e)localObject;
        if (localObject != null) {
          break label70;
        }
        localObject = null;
      }
      for (;;)
      {
        if (!s.p(localObject, parambf.kok())) {
          break label94;
        }
        AppMethodBeat.o(59945);
        return true;
        localObject = null;
        break;
        label70:
        localObject = ((e)localObject).knn();
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = ((y)localObject).aiGV;
        }
      }
    }
    label94:
    AppMethodBeat.o(59945);
    return false;
  }
  
  public static final boolean f(a parama)
  {
    AppMethodBeat.i(59944);
    s.u(parama, "<this>");
    if ((parama instanceof aq))
    {
      parama = ((aq)parama).kpb();
      s.s(parama, "correspondingProperty");
      if (a((bf)parama))
      {
        AppMethodBeat.o(59944);
        return true;
      }
    }
    AppMethodBeat.o(59944);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.f
 * JD-Core Version:    0.7.0.1
 */