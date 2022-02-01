package d.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.aa;
import d.g.b.u;
import d.g.b.w;
import d.l.b.a.b.a.g;
import d.l.b.a.b.f.f;
import d.l.b.a.b.m.ab;
import d.l.d;
import d.n.n;
import d.v;
import d.y;
import java.lang.reflect.Field;

public abstract class c
{
  public static final c LCb = a.H((d.g.a.b)d.LCn);
  public static final c LCc = a.H((d.g.a.b)b.LCl);
  public static final c LCd = a.H((d.g.a.b)c.LCm);
  public static final c LCe = a.H((d.g.a.b)e.LCo);
  public static final c LCf = a.H((d.g.a.b)i.LCs);
  public static final c LCg = a.H((d.g.a.b)g.LCq);
  public static final c LCh = a.H((d.g.a.b)j.LCt);
  public static final c LCi = a.H((d.g.a.b)f.LCp);
  public static final c LCj = a.H((d.g.a.b)h.LCr);
  public static final a LCk = new a((byte)0);
  
  public final c H(d.g.a.b<? super i, y> paramb)
  {
    d.g.b.k.h(paramb, "changeOptions");
    if (this == null) {
      throw new v("null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
    }
    j localj1 = ((e)this).LCx;
    j localj2 = new j();
    Field[] arrayOfField = localj1.getClass().getDeclaredFields();
    int k = arrayOfField.length;
    int i = 0;
    if (i < k)
    {
      Field localField = arrayOfField[i];
      d.g.b.k.g(localField, "field");
      Object localObject2;
      Object localObject1;
      if ((localField.getModifiers() & 0x8) == 0)
      {
        localField.setAccessible(true);
        localObject2 = localField.get(localj1);
        localObject1 = localObject2;
        if (!(localObject2 instanceof d.i.b)) {
          localObject1 = null;
        }
        localObject1 = (d.i.b)localObject1;
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
        d.g.b.k.g(localObject2, "field.name");
        if (!n.nb((String)localObject2, "is")) {}
        for (int j = 1; (aa.KTq) && (j == 0); j = 0) {
          throw ((Throwable)new AssertionError("Fields named is* are not supported here yet"));
        }
        localObject2 = (d)w.bn(j.class);
        String str1 = localField.getName();
        StringBuilder localStringBuilder = new StringBuilder("get");
        String str2 = localField.getName();
        d.g.b.k.g(str2, "field.name");
        localField.set(localj2, localj2.fp(((d.i.b)localObject1).a((d.l.k)new u((d)localObject2, str1, n.capitalize(str2)))));
      }
    }
    paramb.ay(localj2);
    localj2.lock();
    return (c)new e(localj2);
  }
  
  public abstract String a(d.l.b.a.b.b.a.c paramc, d.l.b.a.b.b.a.e parame);
  
  public abstract String a(d.l.b.a.b.m.av paramav);
  
  public abstract String a(String paramString1, String paramString2, g paramg);
  
  public abstract String b(f paramf, boolean paramBoolean);
  
  public abstract String b(ab paramab);
  
  public abstract String f(d.l.b.a.b.f.c paramc);
  
  public abstract String k(d.l.b.a.b.b.l paraml);
  
  public static final class a
  {
    public static c H(d.g.a.b<? super i, y> paramb)
    {
      AppMethodBeat.i(59676);
      d.g.b.k.h(paramb, "changeOptions");
      j localj = new j();
      paramb.ay(localj);
      localj.lock();
      paramb = (c)new e(localj);
      AppMethodBeat.o(59676);
      return paramb;
    }
  }
  
  static final class b
    extends d.g.b.l
    implements d.g.a.b<i, y>
  {
    public static final b LCl;
    
    static
    {
      AppMethodBeat.i(59658);
      LCl = new b();
      AppMethodBeat.o(59658);
    }
    
    b()
    {
      super();
    }
  }
  
  static final class c
    extends d.g.b.l
    implements d.g.a.b<i, y>
  {
    public static final c LCm;
    
    static
    {
      AppMethodBeat.i(59660);
      LCm = new c();
      AppMethodBeat.o(59660);
    }
    
    c()
    {
      super();
    }
  }
  
  static final class d
    extends d.g.b.l
    implements d.g.a.b<i, y>
  {
    public static final d LCn;
    
    static
    {
      AppMethodBeat.i(59662);
      LCn = new d();
      AppMethodBeat.o(59662);
    }
    
    d()
    {
      super();
    }
  }
  
  static final class e
    extends d.g.b.l
    implements d.g.a.b<i, y>
  {
    public static final e LCo;
    
    static
    {
      AppMethodBeat.i(59664);
      LCo = new e();
      AppMethodBeat.o(59664);
    }
    
    e()
    {
      super();
    }
  }
  
  static final class f
    extends d.g.b.l
    implements d.g.a.b<i, y>
  {
    public static final f LCp;
    
    static
    {
      AppMethodBeat.i(59666);
      LCp = new f();
      AppMethodBeat.o(59666);
    }
    
    f()
    {
      super();
    }
  }
  
  static final class g
    extends d.g.b.l
    implements d.g.a.b<i, y>
  {
    public static final g LCq;
    
    static
    {
      AppMethodBeat.i(59668);
      LCq = new g();
      AppMethodBeat.o(59668);
    }
    
    g()
    {
      super();
    }
  }
  
  static final class h
    extends d.g.b.l
    implements d.g.a.b<i, y>
  {
    public static final h LCr;
    
    static
    {
      AppMethodBeat.i(59670);
      LCr = new h();
      AppMethodBeat.o(59670);
    }
    
    h()
    {
      super();
    }
  }
  
  static final class i
    extends d.g.b.l
    implements d.g.a.b<i, y>
  {
    public static final i LCs;
    
    static
    {
      AppMethodBeat.i(59672);
      LCs = new i();
      AppMethodBeat.o(59672);
    }
    
    i()
    {
      super();
    }
  }
  
  static final class j
    extends d.g.b.l
    implements d.g.a.b<i, y>
  {
    public static final j LCt;
    
    static
    {
      AppMethodBeat.i(59674);
      LCt = new j();
      AppMethodBeat.o(59674);
    }
    
    j()
    {
      super();
    }
  }
  
  public static abstract interface k
  {
    public abstract void a(d.l.b.a.b.b.av paramav, int paramInt1, int paramInt2, StringBuilder paramStringBuilder);
    
    public abstract void a(d.l.b.a.b.b.av paramav, StringBuilder paramStringBuilder);
    
    public abstract void e(StringBuilder paramStringBuilder);
    
    public abstract void f(StringBuilder paramStringBuilder);
    
    public static final class a
      implements c.k
    {
      public static final a LCu;
      
      static
      {
        AppMethodBeat.i(59681);
        LCu = new a();
        AppMethodBeat.o(59681);
      }
      
      public final void a(d.l.b.a.b.b.av paramav, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
      {
        AppMethodBeat.i(59680);
        d.g.b.k.h(paramav, "parameter");
        d.g.b.k.h(paramStringBuilder, "builder");
        if (paramInt1 != paramInt2 - 1) {
          paramStringBuilder.append(", ");
        }
        AppMethodBeat.o(59680);
      }
      
      public final void a(d.l.b.a.b.b.av paramav, StringBuilder paramStringBuilder)
      {
        AppMethodBeat.i(59679);
        d.g.b.k.h(paramav, "parameter");
        d.g.b.k.h(paramStringBuilder, "builder");
        AppMethodBeat.o(59679);
      }
      
      public final void e(StringBuilder paramStringBuilder)
      {
        AppMethodBeat.i(59677);
        d.g.b.k.h(paramStringBuilder, "builder");
        paramStringBuilder.append("(");
        AppMethodBeat.o(59677);
      }
      
      public final void f(StringBuilder paramStringBuilder)
      {
        AppMethodBeat.i(59678);
        d.g.b.k.h(paramStringBuilder, "builder");
        paramStringBuilder.append(")");
        AppMethodBeat.o(59678);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.i.c
 * JD-Core Version:    0.7.0.1
 */