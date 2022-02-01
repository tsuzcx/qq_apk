package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.e.a;
import kotlin.l.b.a.b.d.a.e.i;
import kotlin.t;

public final class l
  extends w
  implements kotlin.l.b.a.b.d.a.e.j
{
  final Type Tnf;
  private final i Tno;
  
  public l(Type paramType)
  {
    AppMethodBeat.i(57475);
    this.Tnf = paramType;
    paramType = ((l)this).Tnf;
    if ((paramType instanceof Class)) {
      paramType = (i)new j((Class)paramType);
    }
    for (;;)
    {
      this.Tno = paramType;
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
          paramType = new t("null cannot be cast to non-null type java.lang.Class<*>");
          AppMethodBeat.o(57475);
          throw paramType;
        }
        paramType = (i)new j((Class)paramType);
      }
    }
    paramType = (Throwable)new IllegalStateException("Not a classifier type (" + paramType.getClass() + "): " + paramType);
    AppMethodBeat.o(57475);
    throw paramType;
  }
  
  public final Type hCJ()
  {
    return this.Tnf;
  }
  
  public final Collection<a> hCP()
  {
    return (Collection)kotlin.a.v.SXr;
  }
  
  public final i hCT()
  {
    return this.Tno;
  }
  
  public final String hCU()
  {
    AppMethodBeat.i(57470);
    Throwable localThrowable = (Throwable)new UnsupportedOperationException("Type not found: " + this.Tnf);
    AppMethodBeat.o(57470);
    throw localThrowable;
  }
  
  public final String hCV()
  {
    AppMethodBeat.i(57471);
    String str = this.Tnf.toString();
    AppMethodBeat.o(57471);
    return str;
  }
  
  public final boolean hCW()
  {
    AppMethodBeat.i(57472);
    Object localObject = this.Tnf;
    if ((localObject instanceof Class))
    {
      localObject = ((Class)localObject).getTypeParameters();
      p.g(localObject, "getTypeParameters()");
      if (localObject.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label60;
        }
      }
      label60:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label65;
        }
        AppMethodBeat.o(57472);
        return true;
        i = 0;
        break;
      }
    }
    label65:
    AppMethodBeat.o(57472);
    return false;
  }
  
  public final List<kotlin.l.b.a.b.d.a.e.v> hCX()
  {
    AppMethodBeat.i(57473);
    Object localObject2 = (Iterable)b.a(this.Tnf);
    Object localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(w.a.b((Type)((Iterator)localObject2).next()));
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(57473);
    return localObject1;
  }
  
  public final a l(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57474);
    p.h(paramb, "fqName");
    AppMethodBeat.o(57474);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.l
 * JD-Core Version:    0.7.0.1
 */