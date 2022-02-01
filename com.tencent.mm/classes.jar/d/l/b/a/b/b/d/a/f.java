package d.l.b.a.b.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.an;
import d.l.b.a.b.d.b.a.a.a;
import d.l.b.a.b.d.b.p.a;
import d.l.b.a.b.d.b.p.c;
import d.l.b.a.b.d.b.p.d;
import d.l.b.a.b.d.b.p.e;
import d.n.n;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class f
  implements d.l.b.a.b.d.b.p
{
  public static final a MZX;
  public final Class<?> MZV;
  public final d.l.b.a.b.d.b.a.a MZW;
  
  static
  {
    AppMethodBeat.i(57372);
    MZX = new a((byte)0);
    AppMethodBeat.o(57372);
  }
  
  private f(Class<?> paramClass, d.l.b.a.b.d.b.a.a parama)
  {
    this.MZV = paramClass;
    this.MZW = parama;
  }
  
  public final void a(p.c paramc)
  {
    AppMethodBeat.i(57367);
    d.g.b.p.h(paramc, "visitor");
    c localc = c.MZT;
    c.a(this.MZV, paramc);
    AppMethodBeat.o(57367);
  }
  
  public final void a(p.d paramd)
  {
    AppMethodBeat.i(57368);
    d.g.b.p.h(paramd, "visitor");
    Object localObject1 = c.MZT;
    localObject1 = this.MZV;
    d.g.b.p.h(localObject1, "klass");
    d.g.b.p.h(paramd, "memberVisitor");
    Object localObject2 = ((Class)localObject1).getDeclaredMethods();
    int m = localObject2.length;
    int i = 0;
    Object localObject4;
    Object localObject3;
    Object localObject5;
    int j;
    Object localObject6;
    Object localObject7;
    int n;
    int i1;
    Object localObject8;
    while (i < m)
    {
      localObject4 = localObject2[i];
      d.g.b.p.g(localObject4, "method");
      localObject3 = d.l.b.a.b.f.f.bcE(((Method)localObject4).getName());
      d.g.b.p.g(localObject3, "Name.identifier(method.name)");
      localObject5 = l.Naf;
      localObject3 = paramd.a((d.l.b.a.b.f.f)localObject3, l.d((Method)localObject4));
      localObject5 = ((Method)localObject4).getDeclaredAnnotations();
      k = localObject5.length;
      j = 0;
      while (j < k)
      {
        localObject6 = localObject5[j];
        localObject7 = (p.c)localObject3;
        d.g.b.p.g(localObject6, "annotation");
        c.a((p.c)localObject7, localObject6);
        j += 1;
      }
      localObject4 = ((Method)localObject4).getParameterAnnotations();
      d.g.b.p.g(localObject4, "method.parameterAnnotations");
      n = localObject4.length;
      j = 0;
      while (j < n)
      {
        localObject5 = localObject4[j];
        i1 = localObject5.length;
        k = 0;
        while (k < i1)
        {
          localObject6 = localObject5[k];
          localObject7 = d.g.a.a(d.g.a.a(localObject6));
          localObject8 = d.l.b.a.b.b.d.b.b.bB((Class)localObject7);
          d.g.b.p.g(localObject6, "annotation");
          localObject8 = ((p.e)localObject3).a(j, (d.l.b.a.b.f.a)localObject8, (an)new b(localObject6));
          if (localObject8 != null) {
            c.MZT.a((p.a)localObject8, localObject6, (Class)localObject7);
          }
          k += 1;
        }
        j += 1;
      }
      ((p.e)localObject3).IH();
      i += 1;
    }
    localObject2 = ((Class)localObject1).getDeclaredConstructors();
    m = localObject2.length;
    i = 0;
    while (i < m)
    {
      localObject4 = localObject2[i];
      localObject3 = d.l.b.a.b.f.f.bcG("<init>");
      d.g.b.p.g(localObject3, "Name.special(\"<init>\")");
      localObject5 = l.Naf;
      d.g.b.p.g(localObject4, "constructor");
      localObject3 = paramd.a((d.l.b.a.b.f.f)localObject3, l.a((Constructor)localObject4));
      localObject5 = ((Constructor)localObject4).getDeclaredAnnotations();
      k = localObject5.length;
      j = 0;
      while (j < k)
      {
        localObject6 = localObject5[j];
        localObject7 = (p.c)localObject3;
        d.g.b.p.g(localObject6, "annotation");
        c.a((p.c)localObject7, localObject6);
        j += 1;
      }
      localObject5 = ((Constructor)localObject4).getParameterAnnotations();
      d.g.b.p.g(localObject5, "parameterAnnotations");
      label461:
      int i2;
      if (((Object[])localObject5).length == 0)
      {
        j = 1;
        if (j != 0) {
          break label607;
        }
        j = 1;
        if (j == 0) {
          break label619;
        }
        n = ((Constructor)localObject4).getParameterTypes().length;
        i1 = ((Object[])localObject5).length;
        i2 = localObject5.length;
        j = 0;
      }
      for (;;)
      {
        if (j >= i2) {
          break label619;
        }
        localObject4 = localObject5[j];
        int i3 = localObject4.length;
        k = 0;
        for (;;)
        {
          if (k < i3)
          {
            localObject6 = localObject4[k];
            localObject7 = d.g.a.a(d.g.a.a(localObject6));
            localObject8 = d.l.b.a.b.b.d.b.b.bB((Class)localObject7);
            d.g.b.p.g(localObject6, "annotation");
            localObject8 = ((p.e)localObject3).a(j + (n - i1), (d.l.b.a.b.f.a)localObject8, (an)new b(localObject6));
            if (localObject8 != null) {
              c.MZT.a((p.a)localObject8, localObject6, (Class)localObject7);
            }
            k += 1;
            continue;
            j = 0;
            break;
            label607:
            j = 0;
            break label461;
          }
        }
        j += 1;
      }
      label619:
      ((p.e)localObject3).IH();
      i += 1;
    }
    localObject1 = ((Class)localObject1).getDeclaredFields();
    int k = localObject1.length;
    i = 0;
    while (i < k)
    {
      localObject2 = localObject1[i];
      d.g.b.p.g(localObject2, "field");
      localObject3 = d.l.b.a.b.f.f.bcE(((Field)localObject2).getName());
      d.g.b.p.g(localObject3, "Name.identifier(field.name)");
      localObject4 = l.Naf;
      localObject3 = paramd.b((d.l.b.a.b.f.f)localObject3, l.f((Field)localObject2));
      localObject2 = ((Field)localObject2).getDeclaredAnnotations();
      m = localObject2.length;
      j = 0;
      while (j < m)
      {
        localObject4 = localObject2[j];
        d.g.b.p.g(localObject4, "annotation");
        c.a((p.c)localObject3, (Annotation)localObject4);
        j += 1;
      }
      ((p.c)localObject3).IH();
      i += 1;
    }
    AppMethodBeat.o(57368);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57369);
    if (((paramObject instanceof f)) && (d.g.b.p.i(this.MZV, ((f)paramObject).MZV)))
    {
      AppMethodBeat.o(57369);
      return true;
    }
    AppMethodBeat.o(57369);
    return false;
  }
  
  public final String getLocation()
  {
    AppMethodBeat.i(57365);
    Object localObject = new StringBuilder();
    String str = this.MZV.getName();
    d.g.b.p.g(str, "klass.name");
    localObject = n.a(str, '.', '/') + ".class";
    AppMethodBeat.o(57365);
    return localObject;
  }
  
  public final d.l.b.a.b.f.a ggt()
  {
    AppMethodBeat.i(185981);
    d.l.b.a.b.f.a locala = d.l.b.a.b.b.d.b.b.bB(this.MZV);
    AppMethodBeat.o(185981);
    return locala;
  }
  
  public final d.l.b.a.b.d.b.a.a gkw()
  {
    return this.MZW;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(57370);
    int i = this.MZV.hashCode();
    AppMethodBeat.o(57370);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57371);
    String str = getClass().getName() + ": " + this.MZV;
    AppMethodBeat.o(57371);
    return str;
  }
  
  public static final class a
  {
    public static f bw(Class<?> paramClass)
    {
      int j = 1;
      AppMethodBeat.i(57364);
      d.g.b.p.h(paramClass, "klass");
      d.l.b.a.b.d.b.a.b localb = new d.l.b.a.b.d.b.a.b();
      Object localObject = c.MZT;
      c.a(paramClass, (p.c)localb);
      if ((localb.NjS == null) || (localb.NjR == null))
      {
        localObject = null;
        if (localObject == null)
        {
          AppMethodBeat.o(57364);
          return null;
        }
      }
      else
      {
        localObject = localb.NjR;
        boolean bool;
        label87:
        d.l.b.a.b.e.c.a.f localf;
        label123:
        a.a locala;
        if ((localb.NjF & 0x8) != 0)
        {
          bool = true;
          localf = new d.l.b.a.b.e.c.a.f((int[])localObject, bool);
          if (localf.gqj()) {
            break label198;
          }
          localb.NjD = localb.NjC;
          localb.NjC = null;
          locala = localb.NjS;
          if (localb.NjB == null) {
            break label260;
          }
        }
        label258:
        label260:
        for (localObject = localb.NjB;; localObject = d.l.b.a.b.e.c.a.c.NpP)
        {
          localObject = new d.l.b.a.b.d.b.a.a(locala, localf, (d.l.b.a.b.e.c.a.c)localObject, localb.NjC, localb.NjD, localb.strings, localb.NjE, localb.NjF, localb.packageName);
          break;
          bool = false;
          break label87;
          label198:
          int i = j;
          if (localb.NjS != a.a.NjH)
          {
            i = j;
            if (localb.NjS != a.a.NjI) {
              if (localb.NjS != a.a.NjL) {
                break label255;
              }
            }
          }
          label255:
          for (i = j;; i = 0)
          {
            if ((i == 0) || (localb.NjC != null)) {
              break label258;
            }
            localObject = null;
            break;
          }
          break label123;
        }
      }
      paramClass = new f(paramClass, (d.l.b.a.b.d.b.a.a)localObject, (byte)0);
      AppMethodBeat.o(57364);
      return paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.d.a.f
 * JD-Core Version:    0.7.0.1
 */