package kotlin.l.b.a.b.b.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.d.b.a.a.a;
import kotlin.l.b.a.b.d.b.o;
import kotlin.l.b.a.b.d.b.o.a;
import kotlin.l.b.a.b.d.b.o.c;
import kotlin.l.b.a.b.d.b.o.d;
import kotlin.l.b.a.b.d.b.o.e;
import kotlin.l.b.a.b.e.c.a.e;
import kotlin.n.n;

public final class f
  implements o
{
  public static final a aiMz;
  public final Class<?> aiMA;
  public final kotlin.l.b.a.b.d.b.a.a aiMB;
  
  static
  {
    AppMethodBeat.i(57372);
    aiMz = new a((byte)0);
    AppMethodBeat.o(57372);
  }
  
  private f(Class<?> paramClass, kotlin.l.b.a.b.d.b.a.a parama)
  {
    this.aiMA = paramClass;
    this.aiMB = parama;
  }
  
  public final void a(o.c paramc)
  {
    AppMethodBeat.i(57367);
    s.u(paramc, "visitor");
    c localc = c.aiMx;
    c.a(this.aiMA, paramc);
    AppMethodBeat.o(57367);
  }
  
  public final void a(o.d paramd)
  {
    AppMethodBeat.i(57368);
    s.u(paramd, "visitor");
    Object localObject1 = c.aiMx;
    localObject1 = this.aiMA;
    s.u(localObject1, "klass");
    s.u(paramd, "memberVisitor");
    Object localObject2 = ((Class)localObject1).getDeclaredMethods();
    s.s(localObject2, "klass.declaredMethods");
    int i = 0;
    int m = localObject2.length;
    for (;;)
    {
      Object localObject4;
      int j;
      Object localObject3;
      Object localObject5;
      int k;
      Object localObject6;
      Object localObject7;
      int n;
      if (i < m)
      {
        localObject4 = localObject2[i];
        j = i + 1;
        localObject3 = kotlin.l.b.a.b.f.f.bJe(((Method)localObject4).getName());
        s.s(localObject3, "identifier(method.name)");
        localObject5 = m.aiMK;
        s.s(localObject4, "method");
        localObject3 = paramd.a((kotlin.l.b.a.b.f.f)localObject3, m.h((Method)localObject4));
        if (localObject3 != null)
        {
          localObject5 = ((Method)localObject4).getDeclaredAnnotations();
          s.s(localObject5, "method.declaredAnnotations");
          i = 0;
          k = localObject5.length;
          while (i < k)
          {
            localObject6 = localObject5[i];
            localObject7 = (o.c)localObject3;
            s.s(localObject6, "annotation");
            c.a((o.c)localObject7, localObject6);
            i += 1;
          }
          localObject4 = ((Method)localObject4).getParameterAnnotations();
          s.s(localObject4, "method.parameterAnnotations");
          localObject4 = (Annotation[][])localObject4;
          n = ((Object[])localObject4).length;
          k = 0;
        }
      }
      else
      {
        for (;;)
        {
          int i1;
          if (k < n)
          {
            localObject5 = localObject4[k];
            s.s(localObject5, "annotations");
            i = 0;
            i1 = localObject5.length;
          }
          for (;;)
          {
            if (i >= i1) {
              break label865;
            }
            localObject6 = localObject5[i];
            i += 1;
            localObject7 = kotlin.g.a.b(kotlin.g.a.a(localObject6));
            Object localObject8 = kotlin.l.b.a.b.b.e.b.b.cM((Class)localObject7);
            s.s(localObject6, "annotation");
            localObject8 = ((o.e)localObject3).a(k, (kotlin.l.b.a.b.f.b)localObject8, (av)new b(localObject6));
            if (localObject8 != null)
            {
              c.aiMx.a((o.a)localObject8, localObject6, (Class)localObject7);
              continue;
              ((o.e)localObject3).azp();
              i = j;
              break;
              localObject2 = ((Class)localObject1).getDeclaredConstructors();
              s.s(localObject2, "klass.declaredConstructors");
              i = 0;
              m = localObject2.length;
              for (;;)
              {
                label508:
                int i2;
                if (i < m)
                {
                  localObject4 = localObject2[i];
                  j = i + 1;
                  localObject3 = kotlin.l.b.a.b.f.f.bJg("<init>");
                  s.s(localObject3, "special(\"<init>\")");
                  localObject5 = m.aiMK;
                  s.s(localObject4, "constructor");
                  localObject3 = paramd.a((kotlin.l.b.a.b.f.f)localObject3, m.b((Constructor)localObject4));
                  if (localObject3 == null) {
                    break label857;
                  }
                  localObject5 = ((Constructor)localObject4).getDeclaredAnnotations();
                  s.s(localObject5, "constructor.declaredAnnotations");
                  i = 0;
                  k = localObject5.length;
                  while (i < k)
                  {
                    localObject6 = localObject5[i];
                    localObject7 = (o.c)localObject3;
                    s.s(localObject6, "annotation");
                    c.a((o.c)localObject7, localObject6);
                    i += 1;
                  }
                  localObject5 = ((Constructor)localObject4).getParameterAnnotations();
                  s.s(localObject5, "parameterAnnotations");
                  if (((Object[])localObject5).length == 0)
                  {
                    i = 1;
                    if (i != 0) {
                      break label669;
                    }
                    i = 1;
                    label514:
                    if (i == 0) {
                      break label674;
                    }
                    n = ((Constructor)localObject4).getParameterTypes().length;
                    i1 = ((Object[])localObject5).length;
                    k = 0;
                    i2 = ((Object[])localObject5).length;
                  }
                }
                for (;;)
                {
                  int i3;
                  if (k < i2)
                  {
                    localObject4 = localObject5[k];
                    s.s(localObject4, "annotations");
                    i = 0;
                    i3 = localObject4.length;
                  }
                  for (;;)
                  {
                    if (i >= i3) {
                      break label848;
                    }
                    localObject6 = localObject4[i];
                    i += 1;
                    localObject7 = kotlin.g.a.b(kotlin.g.a.a(localObject6));
                    localObject8 = kotlin.l.b.a.b.b.e.b.b.cM((Class)localObject7);
                    s.s(localObject6, "annotation");
                    localObject8 = ((o.e)localObject3).a(k + (n - i1), (kotlin.l.b.a.b.f.b)localObject8, (av)new b(localObject6));
                    if (localObject8 != null)
                    {
                      c.aiMx.a((o.a)localObject8, localObject6, (Class)localObject7);
                      continue;
                      i = 0;
                      break label508;
                      label669:
                      i = 0;
                      break label514;
                      label674:
                      ((o.e)localObject3).azp();
                      i = j;
                      break;
                      localObject1 = ((Class)localObject1).getDeclaredFields();
                      s.s(localObject1, "klass.declaredFields");
                      i = 0;
                      k = localObject1.length;
                      for (;;)
                      {
                        if (i < k)
                        {
                          localObject2 = localObject1[i];
                          i += 1;
                          localObject3 = kotlin.l.b.a.b.f.f.bJe(((Field)localObject2).getName());
                          s.s(localObject3, "identifier(field.name)");
                          localObject4 = m.aiMK;
                          s.s(localObject2, "field");
                          localObject3 = paramd.b((kotlin.l.b.a.b.f.f)localObject3, m.k((Field)localObject2));
                          if (localObject3 != null)
                          {
                            localObject2 = ((Field)localObject2).getDeclaredAnnotations();
                            s.s(localObject2, "field.declaredAnnotations");
                            j = 0;
                            m = localObject2.length;
                            while (j < m)
                            {
                              localObject4 = localObject2[j];
                              j += 1;
                              s.s(localObject4, "annotation");
                              c.a((o.c)localObject3, (Annotation)localObject4);
                            }
                            ((o.c)localObject3).azp();
                          }
                        }
                        else
                        {
                          AppMethodBeat.o(57368);
                          return;
                        }
                      }
                    }
                  }
                  label848:
                  k += 1;
                }
                label857:
                i = j;
              }
            }
          }
          label865:
          k += 1;
        }
      }
      i = j;
    }
  }
  
  public final String dgd()
  {
    AppMethodBeat.i(57365);
    String str = this.aiMA.getName();
    s.s(str, "klass.name");
    str = s.X(n.a(str, '.', '/'), ".class");
    AppMethodBeat.o(57365);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57369);
    if (((paramObject instanceof f)) && (s.p(this.aiMA, ((f)paramObject).aiMA)))
    {
      AppMethodBeat.o(57369);
      return true;
    }
    AppMethodBeat.o(57369);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(57370);
    int i = this.aiMA.hashCode();
    AppMethodBeat.o(57370);
    return i;
  }
  
  public final kotlin.l.b.a.b.f.b kmb()
  {
    AppMethodBeat.i(369492);
    kotlin.l.b.a.b.f.b localb = kotlin.l.b.a.b.b.e.b.b.cM(this.aiMA);
    AppMethodBeat.o(369492);
    return localb;
  }
  
  public final kotlin.l.b.a.b.d.b.a.a kqo()
  {
    return this.aiMB;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57371);
    String str = getClass().getName() + ": " + this.aiMA;
    AppMethodBeat.o(57371);
    return str;
  }
  
  public static final class a
  {
    public static f cH(Class<?> paramClass)
    {
      int j = 1;
      AppMethodBeat.i(57364);
      s.u(paramClass, "klass");
      Object localObject1 = new kotlin.l.b.a.b.d.b.a.b();
      Object localObject2 = c.aiMx;
      c.a(paramClass, (o.c)localObject1);
      if ((((kotlin.l.b.a.b.d.b.a.b)localObject1).aiXT == null) || (((kotlin.l.b.a.b.d.b.a.b)localObject1).aiXS == null))
      {
        localObject1 = null;
        if (localObject1 == null)
        {
          AppMethodBeat.o(57364);
          return null;
        }
      }
      else
      {
        localObject2 = ((kotlin.l.b.a.b.d.b.a.b)localObject1).aiXS;
        boolean bool;
        if ((((kotlin.l.b.a.b.d.b.a.b)localObject1).aiXG & 0x8) != 0)
        {
          bool = true;
          label87:
          localObject2 = new e((int[])localObject2, bool);
          if (((e)localObject2).axM()) {
            break label177;
          }
          ((kotlin.l.b.a.b.d.b.a.b)localObject1).aiXD = ((kotlin.l.b.a.b.d.b.a.b)localObject1).aiXC;
          ((kotlin.l.b.a.b.d.b.a.b)localObject1).aiXC = null;
        }
        label177:
        label234:
        label237:
        for (;;)
        {
          localObject1 = new kotlin.l.b.a.b.d.b.a.a(((kotlin.l.b.a.b.d.b.a.b)localObject1).aiXT, (e)localObject2, ((kotlin.l.b.a.b.d.b.a.b)localObject1).aiXC, ((kotlin.l.b.a.b.d.b.a.b)localObject1).aiXD, ((kotlin.l.b.a.b.d.b.a.b)localObject1).aiXE, ((kotlin.l.b.a.b.d.b.a.b)localObject1).aiXF, ((kotlin.l.b.a.b.d.b.a.b)localObject1).aiXG, ((kotlin.l.b.a.b.d.b.a.b)localObject1).packageName);
          break;
          bool = false;
          break label87;
          int i = j;
          if (((kotlin.l.b.a.b.d.b.a.b)localObject1).aiXT != a.a.aiXK)
          {
            i = j;
            if (((kotlin.l.b.a.b.d.b.a.b)localObject1).aiXT != a.a.aiXL) {
              if (((kotlin.l.b.a.b.d.b.a.b)localObject1).aiXT != a.a.aiXO) {
                break label234;
              }
            }
          }
          for (i = j;; i = 0)
          {
            if ((i == 0) || (((kotlin.l.b.a.b.d.b.a.b)localObject1).aiXC != null)) {
              break label237;
            }
            localObject1 = null;
            break;
          }
        }
      }
      paramClass = new f(paramClass, (kotlin.l.b.a.b.d.b.a.a)localObject1, (byte)0);
      AppMethodBeat.o(57364);
      return paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.a.f
 * JD-Core Version:    0.7.0.1
 */