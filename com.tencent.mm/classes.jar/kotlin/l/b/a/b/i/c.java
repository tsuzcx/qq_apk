package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;
import kotlin.l.d;
import kotlin.t;
import kotlin.x;

public abstract class c
{
  public static final c abhF = a.aj((kotlin.g.a.b)d.abhS);
  public static final c abhG = a.aj((kotlin.g.a.b)b.abhQ);
  public static final c abhH = a.aj((kotlin.g.a.b)c.abhR);
  public static final c abhI = a.aj((kotlin.g.a.b)e.abhT);
  public static final c abhJ = a.aj((kotlin.g.a.b)j.abhY);
  public static final c abhK = a.aj((kotlin.g.a.b)g.abhV);
  public static final c abhL = a.aj((kotlin.g.a.b)h.abhW);
  public static final c abhM = a.aj((kotlin.g.a.b)k.abhZ);
  public static final c abhN = a.aj((kotlin.g.a.b)f.abhU);
  public static final c abhO = a.aj((kotlin.g.a.b)i.abhX);
  public static final a abhP = new a((byte)0);
  
  public abstract String a(String paramString1, String paramString2, g paramg);
  
  public abstract String a(kotlin.l.b.a.b.b.a.c paramc, kotlin.l.b.a.b.b.a.e parame);
  
  public abstract String a(kotlin.l.b.a.b.m.av paramav);
  
  public final c aj(kotlin.g.a.b<? super i, x> paramb)
  {
    p.k(paramb, "changeOptions");
    if (this == null) {
      throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
    }
    j localj1 = ((e)this).abid;
    j localj2 = new j();
    Field[] arrayOfField = localj1.getClass().getDeclaredFields();
    int k = arrayOfField.length;
    int i = 0;
    if (i < k)
    {
      Field localField = arrayOfField[i];
      p.j(localField, "field");
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
        p.j(localObject2, "field.name");
        if (!kotlin.n.n.M((String)localObject2, "is", false)) {}
        for (int j = 1; (kotlin.z.aazO) && (j == 0); j = 0) {
          throw ((Throwable)new AssertionError("Fields named is* are not supported here yet"));
        }
        localObject2 = (d)kotlin.g.b.ab.bO(j.class);
        String str1 = localField.getName();
        StringBuilder localStringBuilder = new StringBuilder("get");
        String str2 = localField.getName();
        p.j(str2, "field.name");
        localField.set(localj2, localj2.fE(((kotlin.i.b)localObject1).a((kotlin.l.n)new kotlin.g.b.z((d)localObject2, str1, kotlin.n.n.capitalize(str2)))));
      }
    }
    paramb.invoke(localj2);
    localj2.lock();
    return (c)new e(localj2);
  }
  
  public abstract String b(f paramf, boolean paramBoolean);
  
  public abstract String b(kotlin.l.b.a.b.m.ab paramab);
  
  public abstract String f(kotlin.l.b.a.b.f.c paramc);
  
  public abstract String k(l paraml);
  
  public static final class a
  {
    public static c aj(kotlin.g.a.b<? super i, x> paramb)
    {
      AppMethodBeat.i(59676);
      p.k(paramb, "changeOptions");
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
    public static final b abhQ;
    
    static
    {
      AppMethodBeat.i(59658);
      abhQ = new b();
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
    public static final c abhR;
    
    static
    {
      AppMethodBeat.i(59660);
      abhR = new c();
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
    public static final d abhS;
    
    static
    {
      AppMethodBeat.i(59662);
      abhS = new d();
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
    public static final e abhT;
    
    static
    {
      AppMethodBeat.i(59664);
      abhT = new e();
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
    public static final f abhU;
    
    static
    {
      AppMethodBeat.i(59666);
      abhU = new f();
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
    public static final g abhV;
    
    static
    {
      AppMethodBeat.i(59668);
      abhV = new g();
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
    public static final h abhW;
    
    static
    {
      AppMethodBeat.i(268353);
      abhW = new h();
      AppMethodBeat.o(268353);
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
    public static final i abhX;
    
    static
    {
      AppMethodBeat.i(59670);
      abhX = new i();
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
    public static final j abhY;
    
    static
    {
      AppMethodBeat.i(59672);
      abhY = new j();
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
    public static final k abhZ;
    
    static
    {
      AppMethodBeat.i(59674);
      abhZ = new k();
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
      public static final a abia;
      
      static
      {
        AppMethodBeat.i(59681);
        abia = new a();
        AppMethodBeat.o(59681);
      }
      
      public final void a(kotlin.l.b.a.b.b.av paramav, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
      {
        AppMethodBeat.i(59680);
        p.k(paramav, "parameter");
        p.k(paramStringBuilder, "builder");
        if (paramInt1 != paramInt2 - 1) {
          paramStringBuilder.append(", ");
        }
        AppMethodBeat.o(59680);
      }
      
      public final void a(kotlin.l.b.a.b.b.av paramav, StringBuilder paramStringBuilder)
      {
        AppMethodBeat.i(59679);
        p.k(paramav, "parameter");
        p.k(paramStringBuilder, "builder");
        AppMethodBeat.o(59679);
      }
      
      public final void e(StringBuilder paramStringBuilder)
      {
        AppMethodBeat.i(59677);
        p.k(paramStringBuilder, "builder");
        paramStringBuilder.append("(");
        AppMethodBeat.o(59677);
      }
      
      public final void f(StringBuilder paramStringBuilder)
      {
        AppMethodBeat.i(59678);
        p.k(paramStringBuilder, "builder");
        paramStringBuilder.append(")");
        AppMethodBeat.o(59678);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.i.c
 * JD-Core Version:    0.7.0.1
 */