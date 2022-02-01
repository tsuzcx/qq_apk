package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
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
  private final i LjE;
  final Type Ljv;
  
  public l(Type paramType)
  {
    AppMethodBeat.i(57475);
    this.Ljv = paramType;
    paramType = ((l)this).Ljv;
    if ((paramType instanceof Class)) {
      paramType = (i)new j((Class)paramType);
    }
    for (;;)
    {
      this.LjE = paramType;
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
  
  public final Type fTg()
  {
    return this.Ljv;
  }
  
  public final Collection<a> fTm()
  {
    return (Collection)d.a.v.KTF;
  }
  
  public final i fTq()
  {
    return this.LjE;
  }
  
  public final String fTr()
  {
    AppMethodBeat.i(57470);
    Throwable localThrowable = (Throwable)new UnsupportedOperationException("Type not found: " + this.Ljv);
    AppMethodBeat.o(57470);
    throw localThrowable;
  }
  
  public final String fTs()
  {
    AppMethodBeat.i(57471);
    String str = this.Ljv.toString();
    AppMethodBeat.o(57471);
    return str;
  }
  
  public final boolean fTt()
  {
    AppMethodBeat.i(57472);
    Object localObject = this.Ljv;
    if ((localObject instanceof Class))
    {
      localObject = ((Class)localObject).getTypeParameters();
      k.g(localObject, "getTypeParameters()");
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
  
  public final List<d.l.b.a.b.d.a.e.v> fTu()
  {
    AppMethodBeat.i(57473);
    Object localObject2 = (Iterable)b.i(this.Ljv);
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
    k.h(paramb, "fqName");
    AppMethodBeat.o(57474);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.l
 * JD-Core Version:    0.7.0.1
 */