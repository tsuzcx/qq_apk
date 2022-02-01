package d.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.ac;
import d.g.b.p;
import d.g.b.q;
import d.g.b.x;
import d.l.b.a.b.a.g;
import d.l.b.a.b.b.l;
import d.l.b.a.b.f.f;
import d.l.b.a.b.m.ab;
import d.l.d;
import d.l.k;
import d.n.n;
import d.v;
import java.lang.reflect.Field;

public abstract class c
{
  public static final c NsX = a.H((d.g.a.b)c.d.Ntk);
  public static final c NsY = a.H((d.g.a.b)b.Nti);
  public static final c NsZ = a.H((d.g.a.b)c.Ntj);
  public static final c Nta = a.H((d.g.a.b)e.Ntl);
  public static final c Ntb = a.H((d.g.a.b)j.Ntq);
  public static final c Ntc = a.H((d.g.a.b)g.Ntn);
  public static final c Ntd = a.H((d.g.a.b)h.Nto);
  public static final c Nte = a.H((d.g.a.b)k.Ntr);
  public static final c Ntf = a.H((d.g.a.b)f.Ntm);
  public static final c Ntg = a.H((d.g.a.b)i.Ntp);
  public static final a Nth = new a((byte)0);
  
  public final c H(d.g.a.b<? super i, d.z> paramb)
  {
    p.h(paramb, "changeOptions");
    if (this == null) {
      throw new v("null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
    }
    j localj1 = ((e)this).Ntv;
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
        p.g(localObject2, "field.name");
        if (!n.nz((String)localObject2, "is")) {}
        for (int j = 1; (ac.MKp) && (j == 0); j = 0) {
          throw ((Throwable)new AssertionError("Fields named is* are not supported here yet"));
        }
        localObject2 = (d)d.g.b.z.bp(j.class);
        String str1 = localField.getName();
        StringBuilder localStringBuilder = new StringBuilder("get");
        String str2 = localField.getName();
        p.g(str2, "field.name");
        localField.set(localj2, localj2.fr(((d.i.b)localObject1).a((k)new x((d)localObject2, str1, n.capitalize(str2)))));
      }
    }
    paramb.invoke(localj2);
    localj2.lock();
    return (c)new e(localj2);
  }
  
  public abstract String a(d.l.b.a.b.b.a.c paramc, d.l.b.a.b.b.a.e parame);
  
  public abstract String a(d.l.b.a.b.m.av paramav);
  
  public abstract String a(String paramString1, String paramString2, g paramg);
  
  public abstract String b(f paramf, boolean paramBoolean);
  
  public abstract String b(ab paramab);
  
  public abstract String f(d.l.b.a.b.f.c paramc);
  
  public abstract String k(l paraml);
  
  public static final class a
  {
    public static c H(d.g.a.b<? super i, d.z> paramb)
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
    implements d.g.a.b<i, d.z>
  {
    public static final b Nti;
    
    static
    {
      AppMethodBeat.i(59658);
      Nti = new b();
      AppMethodBeat.o(59658);
    }
    
    b()
    {
      super();
    }
  }
  
  static final class c
    extends q
    implements d.g.a.b<i, d.z>
  {
    public static final c Ntj;
    
    static
    {
      AppMethodBeat.i(59660);
      Ntj = new c();
      AppMethodBeat.o(59660);
    }
    
    c()
    {
      super();
    }
  }
  
  static final class e
    extends q
    implements d.g.a.b<i, d.z>
  {
    public static final e Ntl;
    
    static
    {
      AppMethodBeat.i(59664);
      Ntl = new e();
      AppMethodBeat.o(59664);
    }
    
    e()
    {
      super();
    }
  }
  
  static final class f
    extends q
    implements d.g.a.b<i, d.z>
  {
    public static final f Ntm;
    
    static
    {
      AppMethodBeat.i(59666);
      Ntm = new f();
      AppMethodBeat.o(59666);
    }
    
    f()
    {
      super();
    }
  }
  
  static final class g
    extends q
    implements d.g.a.b<i, d.z>
  {
    public static final g Ntn;
    
    static
    {
      AppMethodBeat.i(59668);
      Ntn = new g();
      AppMethodBeat.o(59668);
    }
    
    g()
    {
      super();
    }
  }
  
  static final class h
    extends q
    implements d.g.a.b<i, d.z>
  {
    public static final h Nto;
    
    static
    {
      AppMethodBeat.i(187780);
      Nto = new h();
      AppMethodBeat.o(187780);
    }
    
    h()
    {
      super();
    }
  }
  
  static final class i
    extends q
    implements d.g.a.b<i, d.z>
  {
    public static final i Ntp;
    
    static
    {
      AppMethodBeat.i(59670);
      Ntp = new i();
      AppMethodBeat.o(59670);
    }
    
    i()
    {
      super();
    }
  }
  
  static final class j
    extends q
    implements d.g.a.b<i, d.z>
  {
    public static final j Ntq;
    
    static
    {
      AppMethodBeat.i(59672);
      Ntq = new j();
      AppMethodBeat.o(59672);
    }
    
    j()
    {
      super();
    }
  }
  
  static final class k
    extends q
    implements d.g.a.b<i, d.z>
  {
    public static final k Ntr;
    
    static
    {
      AppMethodBeat.i(59674);
      Ntr = new k();
      AppMethodBeat.o(59674);
    }
    
    k()
    {
      super();
    }
  }
  
  public static abstract interface l
  {
    public abstract void a(d.l.b.a.b.b.av paramav, int paramInt1, int paramInt2, StringBuilder paramStringBuilder);
    
    public abstract void a(d.l.b.a.b.b.av paramav, StringBuilder paramStringBuilder);
    
    public abstract void e(StringBuilder paramStringBuilder);
    
    public abstract void f(StringBuilder paramStringBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.i.c
 * JD-Core Version:    0.7.0.1
 */