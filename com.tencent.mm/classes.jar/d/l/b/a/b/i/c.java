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
  public static final c JOH = a.z((d.g.a.b)d.JOT);
  public static final c JOI = a.z((d.g.a.b)b.JOR);
  public static final c JOJ = a.z((d.g.a.b)c.JOS);
  public static final c JOK = a.z((d.g.a.b)e.JOU);
  public static final c JOL = a.z((d.g.a.b)i.JOY);
  public static final c JOM = a.z((d.g.a.b)g.JOW);
  public static final c JON = a.z((d.g.a.b)j.JOZ);
  public static final c JOO = a.z((d.g.a.b)f.JOV);
  public static final c JOP = a.z((d.g.a.b)h.JOX);
  public static final a JOQ = new a((byte)0);
  
  public abstract String a(d.l.b.a.b.b.a.c paramc, d.l.b.a.b.b.a.e parame);
  
  public abstract String a(d.l.b.a.b.m.av paramav);
  
  public abstract String a(String paramString1, String paramString2, g paramg);
  
  public abstract String b(f paramf, boolean paramBoolean);
  
  public abstract String b(ab paramab);
  
  public abstract String f(d.l.b.a.b.f.c paramc);
  
  public abstract String k(d.l.b.a.b.b.l paraml);
  
  public final c z(d.g.a.b<? super i, y> paramb)
  {
    d.g.b.k.h(paramb, "changeOptions");
    if (this == null) {
      throw new v("null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
    }
    j localj1 = ((e)this).JPd;
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
        if (!n.mA((String)localObject2, "is")) {}
        for (int j = 1; (aa.JfW) && (j == 0); j = 0) {
          throw ((Throwable)new AssertionError("Fields named is* are not supported here yet"));
        }
        localObject2 = (d)w.bk(j.class);
        String str1 = localField.getName();
        StringBuilder localStringBuilder = new StringBuilder("get");
        String str2 = localField.getName();
        d.g.b.k.g(str2, "field.name");
        localField.set(localj2, localj2.fm(((d.i.b)localObject1).a((d.l.k)new u((d)localObject2, str1, n.capitalize(str2)))));
      }
    }
    paramb.aA(localj2);
    localj2.lock();
    return (c)new e(localj2);
  }
  
  public static final class a
  {
    public static c z(d.g.a.b<? super i, y> paramb)
    {
      AppMethodBeat.i(59676);
      d.g.b.k.h(paramb, "changeOptions");
      j localj = new j();
      paramb.aA(localj);
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
    public static final b JOR;
    
    static
    {
      AppMethodBeat.i(59658);
      JOR = new b();
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
    public static final c JOS;
    
    static
    {
      AppMethodBeat.i(59660);
      JOS = new c();
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
    public static final d JOT;
    
    static
    {
      AppMethodBeat.i(59662);
      JOT = new d();
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
    public static final e JOU;
    
    static
    {
      AppMethodBeat.i(59664);
      JOU = new e();
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
    public static final f JOV;
    
    static
    {
      AppMethodBeat.i(59666);
      JOV = new f();
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
    public static final g JOW;
    
    static
    {
      AppMethodBeat.i(59668);
      JOW = new g();
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
    public static final h JOX;
    
    static
    {
      AppMethodBeat.i(59670);
      JOX = new h();
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
    public static final i JOY;
    
    static
    {
      AppMethodBeat.i(59672);
      JOY = new i();
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
    public static final j JOZ;
    
    static
    {
      AppMethodBeat.i(59674);
      JOZ = new j();
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.i.c
 * JD-Core Version:    0.7.0.1
 */