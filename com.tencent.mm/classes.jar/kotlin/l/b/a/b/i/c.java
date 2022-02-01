package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.d;
import kotlin.l.k;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

public abstract class c
{
  public static final c TFb = a.T((kotlin.g.a.b)d.TFo);
  public static final c TFc = a.T((kotlin.g.a.b)b.TFm);
  public static final c TFd = a.T((kotlin.g.a.b)c.TFn);
  public static final c TFe = a.T((kotlin.g.a.b)e.TFp);
  public static final c TFf = a.T((kotlin.g.a.b)j.TFu);
  public static final c TFg = a.T((kotlin.g.a.b)g.TFr);
  public static final c TFh = a.T((kotlin.g.a.b)h.TFs);
  public static final c TFi = a.T((kotlin.g.a.b)k.TFv);
  public static final c TFj = a.T((kotlin.g.a.b)f.TFq);
  public static final c TFk = a.T((kotlin.g.a.b)i.TFt);
  public static final a TFl = new a((byte)0);
  
  public final c T(kotlin.g.a.b<? super i, x> paramb)
  {
    p.h(paramb, "changeOptions");
    if (this == null) {
      throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
    }
    j localj1 = ((e)this).TFz;
    j localj2 = new j();
    Field[] arrayOfField = localj1.getClass().getDeclaredFields();
    int k = arrayOfField.length;
    int i = 0;
    if (i < k)
    {
      Field localField = arrayOfField[i];
      p.g(localField, "field");
      Object localObject2;
      Object localObject1;
      if ((localField.getModifiers() & 0x8) == 0)
      {
        localField.setAccessible(true);
        localObject2 = localField.get(localj1);
        localObject1 = localObject2;
        if (!(localObject2 instanceof kotlin.i.b)) {
          localObject1 = null;
        }
        localObject1 = (kotlin.i.b)localObject1;
        if (localObject1 != null) {
          break label134;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label134:
        localObject2 = localField.getName();
        p.g(localObject2, "field.name");
        if (!n.J((String)localObject2, "is", false)) {}
        for (int j = 1; (kotlin.aa.SXc) && (j == 0); j = 0) {
          throw ((Throwable)new AssertionError("Fields named is* are not supported here yet"));
        }
        localObject2 = (d)kotlin.g.b.aa.bp(j.class);
        String str1 = localField.getName();
        StringBuilder localStringBuilder = new StringBuilder("get");
        String str2 = localField.getName();
        p.g(str2, "field.name");
        localField.set(localj2, localj2.fy(((kotlin.i.b)localObject1).a((k)new y((d)localObject2, str1, n.capitalize(str2)))));
      }
    }
    paramb.invoke(localj2);
    localj2.lock();
    return (c)new e(localj2);
  }
  
  public abstract String a(String paramString1, String paramString2, g paramg);
  
  public abstract String a(kotlin.l.b.a.b.b.a.c paramc, kotlin.l.b.a.b.b.a.e parame);
  
  public abstract String a(kotlin.l.b.a.b.m.av paramav);
  
  public abstract String b(f paramf, boolean paramBoolean);
  
  public abstract String b(ab paramab);
  
  public abstract String f(kotlin.l.b.a.b.f.c paramc);
  
  public abstract String k(l paraml);
  
  public static final class a
  {
    public static c T(kotlin.g.a.b<? super i, x> paramb)
    {
      AppMethodBeat.i(59676);
      p.h(paramb, "changeOptions");
      j localj = new j();
      paramb.invoke(localj);
      localj.lock();
      paramb = (c)new e(localj);
      AppMethodBeat.o(59676);
      return paramb;
    }
  }
  
  static final class b
    extends q
    implements kotlin.g.a.b<i, x>
  {
    public static final b TFm;
    
    static
    {
      AppMethodBeat.i(59658);
      TFm = new b();
      AppMethodBeat.o(59658);
    }
    
    b()
    {
      super();
    }
  }
  
  static final class c
    extends q
    implements kotlin.g.a.b<i, x>
  {
    public static final c TFn;
    
    static
    {
      AppMethodBeat.i(59660);
      TFn = new c();
      AppMethodBeat.o(59660);
    }
    
    c()
    {
      super();
    }
  }
  
  static final class d
    extends q
    implements kotlin.g.a.b<i, x>
  {
    public static final d TFo;
    
    static
    {
      AppMethodBeat.i(59662);
      TFo = new d();
      AppMethodBeat.o(59662);
    }
    
    d()
    {
      super();
    }
  }
  
  static final class e
    extends q
    implements kotlin.g.a.b<i, x>
  {
    public static final e TFp;
    
    static
    {
      AppMethodBeat.i(59664);
      TFp = new e();
      AppMethodBeat.o(59664);
    }
    
    e()
    {
      super();
    }
  }
  
  static final class f
    extends q
    implements kotlin.g.a.b<i, x>
  {
    public static final f TFq;
    
    static
    {
      AppMethodBeat.i(59666);
      TFq = new f();
      AppMethodBeat.o(59666);
    }
    
    f()
    {
      super();
    }
  }
  
  static final class g
    extends q
    implements kotlin.g.a.b<i, x>
  {
    public static final g TFr;
    
    static
    {
      AppMethodBeat.i(59668);
      TFr = new g();
      AppMethodBeat.o(59668);
    }
    
    g()
    {
      super();
    }
  }
  
  static final class h
    extends q
    implements kotlin.g.a.b<i, x>
  {
    public static final h TFs;
    
    static
    {
      AppMethodBeat.i(186255);
      TFs = new h();
      AppMethodBeat.o(186255);
    }
    
    h()
    {
      super();
    }
  }
  
  static final class i
    extends q
    implements kotlin.g.a.b<i, x>
  {
    public static final i TFt;
    
    static
    {
      AppMethodBeat.i(59670);
      TFt = new i();
      AppMethodBeat.o(59670);
    }
    
    i()
    {
      super();
    }
  }
  
  static final class j
    extends q
    implements kotlin.g.a.b<i, x>
  {
    public static final j TFu;
    
    static
    {
      AppMethodBeat.i(59672);
      TFu = new j();
      AppMethodBeat.o(59672);
    }
    
    j()
    {
      super();
    }
  }
  
  static final class k
    extends q
    implements kotlin.g.a.b<i, x>
  {
    public static final k TFv;
    
    static
    {
      AppMethodBeat.i(59674);
      TFv = new k();
      AppMethodBeat.o(59674);
    }
    
    k()
    {
      super();
    }
  }
  
  public static abstract interface l
  {
    public abstract void a(kotlin.l.b.a.b.b.av paramav, int paramInt1, int paramInt2, StringBuilder paramStringBuilder);
    
    public abstract void a(kotlin.l.b.a.b.b.av paramav, StringBuilder paramStringBuilder);
    
    public abstract void e(StringBuilder paramStringBuilder);
    
    public abstract void f(StringBuilder paramStringBuilder);
    
    public static final class a
      implements c.l
    {
      public static final a TFw;
      
      static
      {
        AppMethodBeat.i(59681);
        TFw = new a();
        AppMethodBeat.o(59681);
      }
      
      public final void a(kotlin.l.b.a.b.b.av paramav, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
      {
        AppMethodBeat.i(59680);
        p.h(paramav, "parameter");
        p.h(paramStringBuilder, "builder");
        if (paramInt1 != paramInt2 - 1) {
          paramStringBuilder.append(", ");
        }
        AppMethodBeat.o(59680);
      }
      
      public final void a(kotlin.l.b.a.b.b.av paramav, StringBuilder paramStringBuilder)
      {
        AppMethodBeat.i(59679);
        p.h(paramav, "parameter");
        p.h(paramStringBuilder, "builder");
        AppMethodBeat.o(59679);
      }
      
      public final void e(StringBuilder paramStringBuilder)
      {
        AppMethodBeat.i(59677);
        p.h(paramStringBuilder, "builder");
        paramStringBuilder.append("(");
        AppMethodBeat.o(59677);
      }
      
      public final void f(StringBuilder paramStringBuilder)
      {
        AppMethodBeat.i(59678);
        p.h(paramStringBuilder, "builder");
        paramStringBuilder.append(")");
        AppMethodBeat.o(59678);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.i.c
 * JD-Core Version:    0.7.0.1
 */