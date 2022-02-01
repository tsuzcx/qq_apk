package d.l.b.a.b.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.b.an;
import d.l.b.a.b.d.b.a.a.a;
import d.l.b.a.b.d.b.p;
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
  implements p
{
  public static final a JvI;
  public final Class<?> JvG;
  public final d.l.b.a.b.d.b.a.a JvH;
  
  static
  {
    AppMethodBeat.i(57372);
    JvI = new a((byte)0);
    AppMethodBeat.o(57372);
  }
  
  private f(Class<?> paramClass, d.l.b.a.b.d.b.a.a parama)
  {
    this.JvG = paramClass;
    this.JvH = parama;
  }
  
  public final void a(p.c paramc)
  {
    AppMethodBeat.i(57367);
    k.h(paramc, "visitor");
    c localc = c.JvE;
    c.a(this.JvG, paramc);
    AppMethodBeat.o(57367);
  }
  
  public final void a(p.d paramd)
  {
    AppMethodBeat.i(57368);
    k.h(paramd, "visitor");
    Object localObject1 = c.JvE;
    localObject1 = this.JvG;
    k.h(localObject1, "klass");
    k.h(paramd, "memberVisitor");
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
      k.g(localObject4, "method");
      localObject3 = d.l.b.a.b.f.f.aQC(((Method)localObject4).getName());
      k.g(localObject3, "Name.identifier(method.name)");
      localObject5 = l.JvQ;
      localObject3 = paramd.a((d.l.b.a.b.f.f)localObject3, l.d((Method)localObject4));
      localObject5 = ((Method)localObject4).getDeclaredAnnotations();
      k = localObject5.length;
      j = 0;
      while (j < k)
      {
        localObject6 = localObject5[j];
        localObject7 = (p.c)localObject3;
        k.g(localObject6, "annotation");
        c.a((p.c)localObject7, localObject6);
        j += 1;
      }
      localObject4 = ((Method)localObject4).getParameterAnnotations();
      k.g(localObject4, "method.parameterAnnotations");
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
          localObject8 = d.l.b.a.b.b.d.b.b.bw((Class)localObject7);
          k.g(localObject6, "annotation");
          localObject8 = ((p.e)localObject3).a(j, (d.l.b.a.b.f.a)localObject8, (an)new b(localObject6));
          if (localObject8 != null) {
            c.JvE.a((p.a)localObject8, localObject6, (Class)localObject7);
          }
          k += 1;
        }
        j += 1;
      }
      ((p.e)localObject3).HB();
      i += 1;
    }
    localObject2 = ((Class)localObject1).getDeclaredConstructors();
    m = localObject2.length;
    i = 0;
    while (i < m)
    {
      localObject4 = localObject2[i];
      localObject3 = d.l.b.a.b.f.f.aQE("<init>");
      k.g(localObject3, "Name.special(\"<init>\")");
      localObject5 = l.JvQ;
      k.g(localObject4, "constructor");
      localObject3 = paramd.a((d.l.b.a.b.f.f)localObject3, l.a((Constructor)localObject4));
      localObject5 = ((Constructor)localObject4).getDeclaredAnnotations();
      k = localObject5.length;
      j = 0;
      while (j < k)
      {
        localObject6 = localObject5[j];
        localObject7 = (p.c)localObject3;
        k.g(localObject6, "annotation");
        c.a((p.c)localObject7, localObject6);
        j += 1;
      }
      localObject5 = ((Constructor)localObject4).getParameterAnnotations();
      k.g(localObject5, "parameterAnnotations");
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
            localObject8 = d.l.b.a.b.b.d.b.b.bw((Class)localObject7);
            k.g(localObject6, "annotation");
            localObject8 = ((p.e)localObject3).a(j + (n - i1), (d.l.b.a.b.f.a)localObject8, (an)new b(localObject6));
            if (localObject8 != null) {
              c.JvE.a((p.a)localObject8, localObject6, (Class)localObject7);
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
      ((p.e)localObject3).HB();
      i += 1;
    }
    localObject1 = ((Class)localObject1).getDeclaredFields();
    int k = localObject1.length;
    i = 0;
    while (i < k)
    {
      localObject2 = localObject1[i];
      k.g(localObject2, "field");
      localObject3 = d.l.b.a.b.f.f.aQC(((Field)localObject2).getName());
      k.g(localObject3, "Name.identifier(field.name)");
      localObject4 = l.JvQ;
      localObject3 = paramd.b((d.l.b.a.b.f.f)localObject3, l.f((Field)localObject2));
      localObject2 = ((Field)localObject2).getDeclaredAnnotations();
      m = localObject2.length;
      j = 0;
      while (j < m)
      {
        localObject4 = localObject2[j];
        k.g(localObject4, "annotation");
        c.a((p.c)localObject3, (Annotation)localObject4);
        j += 1;
      }
      ((p.c)localObject3).HB();
      i += 1;
    }
    AppMethodBeat.o(57368);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57369);
    if (((paramObject instanceof f)) && (k.g(this.JvG, ((f)paramObject).JvG)))
    {
      AppMethodBeat.o(57369);
      return true;
    }
    AppMethodBeat.o(57369);
    return false;
  }
  
  public final d.l.b.a.b.d.b.a.a fAt()
  {
    return this.JvH;
  }
  
  public final d.l.b.a.b.f.a fwp()
  {
    AppMethodBeat.i(202317);
    d.l.b.a.b.f.a locala = d.l.b.a.b.b.d.b.b.bw(this.JvG);
    AppMethodBeat.o(202317);
    return locala;
  }
  
  public final String getLocation()
  {
    AppMethodBeat.i(57365);
    Object localObject = new StringBuilder();
    String str = this.JvG.getName();
    k.g(str, "klass.name");
    localObject = n.a(str, '.', '/') + ".class";
    AppMethodBeat.o(57365);
    return localObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(57370);
    int i = this.JvG.hashCode();
    AppMethodBeat.o(57370);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57371);
    String str = getClass().getName() + ": " + this.JvG;
    AppMethodBeat.o(57371);
    return str;
  }
  
  public static final class a
  {
    public static f br(Class<?> paramClass)
    {
      int j = 1;
      AppMethodBeat.i(57364);
      k.h(paramClass, "klass");
      d.l.b.a.b.d.b.a.b localb = new d.l.b.a.b.d.b.a.b();
      Object localObject = c.JvE;
      c.a(paramClass, (p.c)localb);
      if ((localb.JFC == null) || (localb.JFB == null))
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
        localObject = localb.JFB;
        boolean bool;
        label87:
        d.l.b.a.b.e.c.a.f localf;
        label123:
        a.a locala;
        if ((localb.JFp & 0x8) != 0)
        {
          bool = true;
          localf = new d.l.b.a.b.e.c.a.f((int[])localObject, bool);
          if (localf.fGg()) {
            break label198;
          }
          localb.JFn = localb.JFm;
          localb.JFm = null;
          locala = localb.JFC;
          if (localb.JFl == null) {
            break label260;
          }
        }
        label258:
        label260:
        for (localObject = localb.JFl;; localObject = d.l.b.a.b.e.c.a.c.JLz)
        {
          localObject = new d.l.b.a.b.d.b.a.a(locala, localf, (d.l.b.a.b.e.c.a.c)localObject, localb.JFm, localb.JFn, localb.strings, localb.JFo, localb.JFp, localb.packageName);
          break;
          bool = false;
          break label87;
          label198:
          int i = j;
          if (localb.JFC != a.a.JFr)
          {
            i = j;
            if (localb.JFC != a.a.JFs) {
              if (localb.JFC != a.a.JFv) {
                break label255;
              }
            }
          }
          label255:
          for (i = j;; i = 0)
          {
            if ((i == 0) || (localb.JFm != null)) {
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