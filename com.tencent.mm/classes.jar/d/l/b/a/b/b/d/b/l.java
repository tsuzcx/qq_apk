package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.d.a.e.a;
import d.l.b.a.b.d.a.e.i;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class l
  extends w
  implements d.l.b.a.b.d.a.e.j
{
  private final i NaA;
  final Type Nar;
  
  public l(Type paramType)
  {
    AppMethodBeat.i(57475);
    this.Nar = paramType;
    paramType = ((l)this).Nar;
    if ((paramType instanceof Class)) {
      paramType = (i)new j((Class)paramType);
    }
    for (;;)
    {
      this.NaA = paramType;
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
          paramType = new d.v("null cannot be cast to non-null type java.lang.Class<*>");
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
  
  public final Type gkF()
  {
    return this.Nar;
  }
  
  public final Collection<a> gkL()
  {
    return (Collection)d.a.v.MKE;
  }
  
  public final i gkP()
  {
    return this.NaA;
  }
  
  public final String gkQ()
  {
    AppMethodBeat.i(57470);
    Throwable localThrowable = (Throwable)new UnsupportedOperationException("Type not found: " + this.Nar);
    AppMethodBeat.o(57470);
    throw localThrowable;
  }
  
  public final String gkR()
  {
    AppMethodBeat.i(57471);
    String str = this.Nar.toString();
    AppMethodBeat.o(57471);
    return str;
  }
  
  public final boolean gkS()
  {
    AppMethodBeat.i(57472);
    Object localObject = this.Nar;
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
  
  public final List<d.l.b.a.b.d.a.e.v> gkT()
  {
    AppMethodBeat.i(57473);
    Object localObject2 = (Iterable)b.i(this.Nar);
    Object localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(w.a.j((Type)((Iterator)localObject2).next()));
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(57473);
    return localObject1;
  }
  
  public final a l(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57474);
    p.h(paramb, "fqName");
    AppMethodBeat.o(57474);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.l
 * JD-Core Version:    0.7.0.1
 */