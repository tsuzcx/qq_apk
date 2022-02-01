package kotlin.l.b.a.b.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.d.a.e.a;
import kotlin.l.b.a.b.d.a.e.i;
import kotlin.l.b.a.b.f.c;

public final class l
  extends w
  implements kotlin.l.b.a.b.d.a.e.j
{
  final Type aiMV;
  private final i aiNh;
  
  public l(Type paramType)
  {
    AppMethodBeat.i(57475);
    this.aiMV = paramType;
    paramType = ((l)this).aiMV;
    if ((paramType instanceof Class)) {
      paramType = (i)new j((Class)paramType);
    }
    for (;;)
    {
      this.aiNh = paramType;
      AppMethodBeat.o(57475);
      return;
      if ((paramType instanceof TypeVariable))
      {
        paramType = (i)new x((TypeVariable)paramType);
      }
      else
      {
        if (!(paramType instanceof ParameterizedType)) {
          break;
        }
        paramType = ((ParameterizedType)paramType).getRawType();
        if (paramType == null)
        {
          paramType = new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
          AppMethodBeat.o(57475);
          throw paramType;
        }
        paramType = (i)new j((Class)paramType);
      }
    }
    paramType = new IllegalStateException("Not a classifier type (" + paramType.getClass() + "): " + paramType);
    AppMethodBeat.o(57475);
    throw paramType;
  }
  
  public final boolean kqA()
  {
    return false;
  }
  
  public final i kqU()
  {
    return this.aiNh;
  }
  
  public final String kqV()
  {
    AppMethodBeat.i(57470);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException(s.X("Type not found: ", this.aiMV));
    AppMethodBeat.o(57470);
    throw localUnsupportedOperationException;
  }
  
  public final String kqW()
  {
    AppMethodBeat.i(57471);
    String str = this.aiMV.toString();
    AppMethodBeat.o(57471);
    return str;
  }
  
  public final boolean kqX()
  {
    AppMethodBeat.i(57472);
    Object localObject = this.aiMV;
    if ((localObject instanceof Class))
    {
      localObject = ((Class)localObject).getTypeParameters();
      s.s(localObject, "getTypeParameters()");
      if (((Object[])localObject).length == 0)
      {
        i = 1;
        if (i != 0) {
          break label63;
        }
      }
      label63:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label68;
        }
        AppMethodBeat.o(57472);
        return true;
        i = 0;
        break;
      }
    }
    label68:
    AppMethodBeat.o(57472);
    return false;
  }
  
  public final List<kotlin.l.b.a.b.d.a.e.w> kqY()
  {
    AppMethodBeat.i(57473);
    Object localObject2 = (Iterable)b.k(this.aiMV);
    Object localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(w.a.l((Type)((Iterator)localObject2).next()));
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(57473);
    return localObject1;
  }
  
  public final Type kqy()
  {
    return this.aiMV;
  }
  
  public final Collection<a> kqz()
  {
    return (Collection)ab.aivy;
  }
  
  public final a m(c paramc)
  {
    AppMethodBeat.i(57474);
    s.u(paramc, "fqName");
    AppMethodBeat.o(57474);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.b.l
 * JD-Core Version:    0.7.0.1
 */