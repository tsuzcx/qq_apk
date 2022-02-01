package kotlin.l.b.a.b.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.d.b.a.a.a;
import kotlin.l.b.a.b.d.b.p.a;
import kotlin.l.b.a.b.d.b.p.c;
import kotlin.l.b.a.b.d.b.p.d;
import kotlin.l.b.a.b.d.b.p.e;
import kotlin.n.n;

public final class f
  implements kotlin.l.b.a.b.d.b.p
{
  public static final a aaPF;
  public final Class<?> aaPD;
  public final kotlin.l.b.a.b.d.b.a.a aaPE;
  
  static
  {
    AppMethodBeat.i(57372);
    aaPF = new a((byte)0);
    AppMethodBeat.o(57372);
  }
  
  private f(Class<?> paramClass, kotlin.l.b.a.b.d.b.a.a parama)
  {
    this.aaPD = paramClass;
    this.aaPE = parama;
  }
  
  public final void a(p.c paramc)
  {
    AppMethodBeat.i(57367);
    kotlin.g.b.p.k(paramc, "visitor");
    c localc = c.aaPB;
    c.a(this.aaPD, paramc);
    AppMethodBeat.o(57367);
  }
  
  public final void a(p.d paramd)
  {
    AppMethodBeat.i(57368);
    kotlin.g.b.p.k(paramd, "visitor");
    Object localObject1 = c.aaPB;
    localObject1 = this.aaPD;
    kotlin.g.b.p.k(localObject1, "klass");
    kotlin.g.b.p.k(paramd, "memberVisitor");
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
      kotlin.g.b.p.j(localObject4, "method");
      localObject3 = kotlin.l.b.a.b.f.f.bHb(((Method)localObject4).getName());
      kotlin.g.b.p.j(localObject3, "Name.identifier(method.name)");
      localObject5 = l.aaPN;
      localObject3 = paramd.a((kotlin.l.b.a.b.f.f)localObject3, l.d((Method)localObject4));
      localObject5 = ((Method)localObject4).getDeclaredAnnotations();
      k = localObject5.length;
      j = 0;
      while (j < k)
      {
        localObject6 = localObject5[j];
        localObject7 = (p.c)localObject3;
        kotlin.g.b.p.j(localObject6, "annotation");
        c.a((p.c)localObject7, localObject6);
        j += 1;
      }
      localObject4 = ((Method)localObject4).getParameterAnnotations();
      kotlin.g.b.p.j(localObject4, "method.parameterAnnotations");
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
          localObject7 = kotlin.g.a.a(kotlin.g.a.a(localObject6));
          localObject8 = kotlin.l.b.a.b.b.d.b.b.ca((Class)localObject7);
          kotlin.g.b.p.j(localObject6, "annotation");
          localObject8 = ((p.e)localObject3).a(j, (kotlin.l.b.a.b.f.a)localObject8, (an)new b(localObject6));
          if (localObject8 != null) {
            c.aaPB.a((p.a)localObject8, localObject6, (Class)localObject7);
          }
          k += 1;
        }
        j += 1;
      }
      ((p.e)localObject3).XJ();
      i += 1;
    }
    localObject2 = ((Class)localObject1).getDeclaredConstructors();
    m = localObject2.length;
    i = 0;
    while (i < m)
    {
      localObject4 = localObject2[i];
      localObject3 = kotlin.l.b.a.b.f.f.bHd("<init>");
      kotlin.g.b.p.j(localObject3, "Name.special(\"<init>\")");
      localObject5 = l.aaPN;
      kotlin.g.b.p.j(localObject4, "constructor");
      localObject3 = paramd.a((kotlin.l.b.a.b.f.f)localObject3, l.a((Constructor)localObject4));
      localObject5 = ((Constructor)localObject4).getDeclaredAnnotations();
      k = localObject5.length;
      j = 0;
      while (j < k)
      {
        localObject6 = localObject5[j];
        localObject7 = (p.c)localObject3;
        kotlin.g.b.p.j(localObject6, "annotation");
        c.a((p.c)localObject7, localObject6);
        j += 1;
      }
      localObject5 = ((Constructor)localObject4).getParameterAnnotations();
      kotlin.g.b.p.j(localObject5, "parameterAnnotations");
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
            localObject7 = kotlin.g.a.a(kotlin.g.a.a(localObject6));
            localObject8 = kotlin.l.b.a.b.b.d.b.b.ca((Class)localObject7);
            kotlin.g.b.p.j(localObject6, "annotation");
            localObject8 = ((p.e)localObject3).a(j + (n - i1), (kotlin.l.b.a.b.f.a)localObject8, (an)new b(localObject6));
            if (localObject8 != null) {
              c.aaPB.a((p.a)localObject8, localObject6, (Class)localObject7);
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
      ((p.e)localObject3).XJ();
      i += 1;
    }
    localObject1 = ((Class)localObject1).getDeclaredFields();
    int k = localObject1.length;
    i = 0;
    while (i < k)
    {
      localObject2 = localObject1[i];
      kotlin.g.b.p.j(localObject2, "field");
      localObject3 = kotlin.l.b.a.b.f.f.bHb(((Field)localObject2).getName());
      kotlin.g.b.p.j(localObject3, "Name.identifier(field.name)");
      localObject4 = l.aaPN;
      localObject3 = paramd.b((kotlin.l.b.a.b.f.f)localObject3, l.h((Field)localObject2));
      localObject2 = ((Field)localObject2).getDeclaredAnnotations();
      m = localObject2.length;
      j = 0;
      while (j < m)
      {
        localObject4 = localObject2[j];
        kotlin.g.b.p.j(localObject4, "annotation");
        c.a((p.c)localObject3, (Annotation)localObject4);
        j += 1;
      }
      ((p.c)localObject3).XJ();
      i += 1;
    }
    AppMethodBeat.o(57368);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57369);
    if (((paramObject instanceof f)) && (kotlin.g.b.p.h(this.aaPD, ((f)paramObject).aaPD)))
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
    String str = this.aaPD.getName();
    kotlin.g.b.p.j(str, "klass.name");
    localObject = n.a(str, '.', '/') + ".class";
    AppMethodBeat.o(57365);
    return localObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(57370);
    int i = this.aaPD.hashCode();
    AppMethodBeat.o(57370);
    return i;
  }
  
  public final kotlin.l.b.a.b.f.a iCJ()
  {
    AppMethodBeat.i(185981);
    kotlin.l.b.a.b.f.a locala = kotlin.l.b.a.b.b.d.b.b.ca(this.aaPD);
    AppMethodBeat.o(185981);
    return locala;
  }
  
  public final kotlin.l.b.a.b.d.b.a.a iGR()
  {
    return this.aaPE;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57371);
    String str = getClass().getName() + ": " + this.aaPD;
    AppMethodBeat.o(57371);
    return str;
  }
  
  public static final class a
  {
    public static f bV(Class<?> paramClass)
    {
      int j = 1;
      AppMethodBeat.i(57364);
      kotlin.g.b.p.k(paramClass, "klass");
      kotlin.l.b.a.b.d.b.a.b localb = new kotlin.l.b.a.b.d.b.a.b();
      Object localObject = c.aaPB;
      c.a(paramClass, (p.c)localb);
      if ((localb.aaZv == null) || (localb.aaZu == null))
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
        localObject = localb.aaZu;
        boolean bool;
        label87:
        kotlin.l.b.a.b.e.c.a.f localf;
        label123:
        a.a locala;
        if ((localb.aaZi & 0x8) != 0)
        {
          bool = true;
          localf = new kotlin.l.b.a.b.e.c.a.f((int[])localObject, bool);
          if (localf.iMC()) {
            break label198;
          }
          localb.aaZf = localb.aaZe;
          localb.aaZe = null;
          locala = localb.aaZv;
          if (localb.aaZd == null) {
            break label260;
          }
        }
        label258:
        label260:
        for (localObject = localb.aaZd;; localObject = kotlin.l.b.a.b.e.c.a.c.abfn)
        {
          localObject = new kotlin.l.b.a.b.d.b.a.a(locala, localf, (kotlin.l.b.a.b.e.c.a.c)localObject, localb.aaZe, localb.aaZf, localb.aaZg, localb.aaZh, localb.aaZi, localb.packageName);
          break;
          bool = false;
          break label87;
          label198:
          int i = j;
          if (localb.aaZv != a.a.aaZk)
          {
            i = j;
            if (localb.aaZv != a.a.aaZl) {
              if (localb.aaZv != a.a.aaZo) {
                break label255;
              }
            }
          }
          label255:
          for (i = j;; i = 0)
          {
            if ((i == 0) || (localb.aaZe != null)) {
              break label258;
            }
            localObject = null;
            break;
          }
          break label123;
        }
      }
      paramClass = new f(paramClass, (kotlin.l.b.a.b.d.b.a.a)localObject, (byte)0);
      AppMethodBeat.o(57364);
      return paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.a.f
 * JD-Core Version:    0.7.0.1
 */