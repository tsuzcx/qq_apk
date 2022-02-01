package d.l.b.a.b.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.an;
import d.l.b.a.b.d.a.p;
import d.l.b.a.b.d.b.p.a;
import d.l.b.a.b.d.b.p.b;
import d.l.b.a.b.d.b.p.c;
import d.l.b.a.b.e.c.a.c;
import d.l.b.a.b.f.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
  implements p.c
{
  private static final boolean NjP;
  private static final Map<a, a.a> NjQ;
  public c NjB = null;
  public String[] NjC = null;
  public String[] NjD = null;
  public String NjE = null;
  public int NjF = 0;
  public int[] NjR = null;
  public a.a NjS = null;
  public String packageName = null;
  public String[] strings = null;
  
  static
  {
    AppMethodBeat.i(58301);
    NjP = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
    HashMap localHashMap = new HashMap();
    NjQ = localHashMap;
    localHashMap.put(a.p(new d.l.b.a.b.f.b("kotlin.jvm.internal.KotlinClass")), a.a.NjH);
    NjQ.put(a.p(new d.l.b.a.b.f.b("kotlin.jvm.internal.KotlinFileFacade")), a.a.NjI);
    NjQ.put(a.p(new d.l.b.a.b.f.b("kotlin.jvm.internal.KotlinMultifileClass")), a.a.NjK);
    NjQ.put(a.p(new d.l.b.a.b.f.b("kotlin.jvm.internal.KotlinMultifileClassPart")), a.a.NjL);
    NjQ.put(a.p(new d.l.b.a.b.f.b("kotlin.jvm.internal.KotlinSyntheticClass")), a.a.NjJ);
    AppMethodBeat.o(58301);
  }
  
  public final void IH() {}
  
  public final p.a a(a parama, an paraman)
  {
    AppMethodBeat.i(58300);
    if (parama == null)
    {
      parama = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[] { "classId", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor", "visitAnnotation" }));
      AppMethodBeat.o(58300);
      throw parama;
    }
    if (parama.gre().equals(p.Ncw))
    {
      parama = new b((byte)0);
      AppMethodBeat.o(58300);
      return parama;
    }
    if (NjP)
    {
      AppMethodBeat.o(58300);
      return null;
    }
    if (this.NjS != null)
    {
      AppMethodBeat.o(58300);
      return null;
    }
    parama = (a.a)NjQ.get(parama);
    if (parama != null)
    {
      this.NjS = parama;
      parama = new c((byte)0);
      AppMethodBeat.o(58300);
      return parama;
    }
    AppMethodBeat.o(58300);
    return null;
  }
  
  static abstract class a
    implements p.b
  {
    private final List<String> NjT = new ArrayList();
    
    public final void IH()
    {
      ao((String[])this.NjT.toArray(new String[0]));
    }
    
    public final void a(a parama, d.l.b.a.b.f.f paramf)
    {
      if (parama == null) {
        ajm(0);
      }
      if (paramf == null) {
        ajm(1);
      }
    }
    
    public final void a(d.l.b.a.b.j.b.f paramf)
    {
      if (paramf == null) {
        ajm(2);
      }
    }
    
    protected abstract void ao(String[] paramArrayOfString);
    
    public final void fj(Object paramObject)
    {
      if ((paramObject instanceof String)) {
        this.NjT.add((String)paramObject);
      }
    }
  }
  
  final class b
    implements p.a
  {
    private b() {}
    
    public final void IH() {}
    
    public final p.a a(d.l.b.a.b.f.f paramf, a parama)
    {
      AppMethodBeat.i(58290);
      if (paramf == null) {
        ajm(6);
      }
      if (parama == null) {
        ajm(7);
      }
      AppMethodBeat.o(58290);
      return null;
    }
    
    public final void a(d.l.b.a.b.f.f paramf1, a parama, d.l.b.a.b.f.f paramf2)
    {
      AppMethodBeat.i(58289);
      if (paramf1 == null) {
        ajm(3);
      }
      if (parama == null) {
        ajm(4);
      }
      if (paramf2 == null) {
        ajm(5);
      }
      AppMethodBeat.o(58289);
    }
    
    public final void a(d.l.b.a.b.f.f paramf, d.l.b.a.b.j.b.f paramf1)
    {
      AppMethodBeat.i(58287);
      if (paramf == null) {
        ajm(0);
      }
      if (paramf1 == null) {
        ajm(1);
      }
      AppMethodBeat.o(58287);
    }
    
    public final void a(d.l.b.a.b.f.f paramf, Object paramObject)
    {
      AppMethodBeat.i(58286);
      if (paramf == null)
      {
        AppMethodBeat.o(58286);
        return;
      }
      paramf = paramf.sD();
      if ("k".equals(paramf))
      {
        if ((paramObject instanceof Integer))
        {
          b.a(b.this, a.a.ajr(((Integer)paramObject).intValue()));
          AppMethodBeat.o(58286);
        }
      }
      else if ("mv".equals(paramf))
      {
        if ((paramObject instanceof int[]))
        {
          b.a(b.this, (int[])paramObject);
          AppMethodBeat.o(58286);
        }
      }
      else if ("bv".equals(paramf))
      {
        if ((paramObject instanceof int[]))
        {
          b.a(b.this, new c((int[])paramObject));
          AppMethodBeat.o(58286);
        }
      }
      else if ("xs".equals(paramf))
      {
        if ((paramObject instanceof String))
        {
          b.a(b.this, (String)paramObject);
          AppMethodBeat.o(58286);
        }
      }
      else if ("xi".equals(paramf))
      {
        if ((paramObject instanceof Integer))
        {
          b.a(b.this, ((Integer)paramObject).intValue());
          AppMethodBeat.o(58286);
        }
      }
      else if (("pn".equals(paramf)) && ((paramObject instanceof String))) {
        b.b(b.this, (String)paramObject);
      }
      AppMethodBeat.o(58286);
    }
    
    public final p.b n(d.l.b.a.b.f.f paramf)
    {
      AppMethodBeat.i(58288);
      if (paramf == null) {
        ajm(2);
      }
      paramf = paramf.sD();
      if ("d1".equals(paramf))
      {
        paramf = new b.a()
        {
          protected final void ao(String[] paramAnonymousArrayOfString)
          {
            AppMethodBeat.i(58284);
            if (paramAnonymousArrayOfString == null)
            {
              paramAnonymousArrayOfString = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[] { "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd" }));
              AppMethodBeat.o(58284);
              throw paramAnonymousArrayOfString;
            }
            b.a(b.this, paramAnonymousArrayOfString);
            AppMethodBeat.o(58284);
          }
        };
        AppMethodBeat.o(58288);
        return paramf;
      }
      if ("d2".equals(paramf))
      {
        paramf = new b.a()
        {
          protected final void ao(String[] paramAnonymousArrayOfString)
          {
            AppMethodBeat.i(58285);
            if (paramAnonymousArrayOfString == null)
            {
              paramAnonymousArrayOfString = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[] { "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd" }));
              AppMethodBeat.o(58285);
              throw paramAnonymousArrayOfString;
            }
            b.b(b.this, paramAnonymousArrayOfString);
            AppMethodBeat.o(58285);
          }
        };
        AppMethodBeat.o(58288);
        return paramf;
      }
      AppMethodBeat.o(58288);
      return null;
    }
  }
  
  final class c
    implements p.a
  {
    private c() {}
    
    public final void IH() {}
    
    public final p.a a(d.l.b.a.b.f.f paramf, a parama)
    {
      AppMethodBeat.i(58298);
      if (paramf == null) {
        ajm(6);
      }
      if (parama == null) {
        ajm(7);
      }
      AppMethodBeat.o(58298);
      return null;
    }
    
    public final void a(d.l.b.a.b.f.f paramf1, a parama, d.l.b.a.b.f.f paramf2)
    {
      AppMethodBeat.i(58297);
      if (paramf1 == null) {
        ajm(3);
      }
      if (parama == null) {
        ajm(4);
      }
      if (paramf2 == null) {
        ajm(5);
      }
      AppMethodBeat.o(58297);
    }
    
    public final void a(d.l.b.a.b.f.f paramf, d.l.b.a.b.j.b.f paramf1)
    {
      AppMethodBeat.i(58295);
      if (paramf == null) {
        ajm(0);
      }
      if (paramf1 == null) {
        ajm(1);
      }
      AppMethodBeat.o(58295);
    }
    
    public final void a(d.l.b.a.b.f.f paramf, Object paramObject)
    {
      AppMethodBeat.i(58294);
      if (paramf == null)
      {
        AppMethodBeat.o(58294);
        return;
      }
      paramf = paramf.sD();
      b localb;
      if ("version".equals(paramf))
      {
        if ((paramObject instanceof int[]))
        {
          b.a(b.this, (int[])paramObject);
          if (b.a(b.this) == null)
          {
            b.a(b.this, new c((int[])paramObject));
            AppMethodBeat.o(58294);
          }
        }
      }
      else if ("multifileClassName".equals(paramf))
      {
        localb = b.this;
        if (!(paramObject instanceof String)) {
          break label127;
        }
      }
      label127:
      for (paramf = (String)paramObject;; paramf = null)
      {
        b.a(localb, paramf);
        AppMethodBeat.o(58294);
        return;
      }
    }
    
    public final p.b n(d.l.b.a.b.f.f paramf)
    {
      AppMethodBeat.i(58296);
      if (paramf == null) {
        ajm(2);
      }
      paramf = paramf.sD();
      if (("data".equals(paramf)) || ("filePartClassNames".equals(paramf)))
      {
        paramf = new b.a()
        {
          protected final void ao(String[] paramAnonymousArrayOfString)
          {
            AppMethodBeat.i(58292);
            if (paramAnonymousArrayOfString == null)
            {
              paramAnonymousArrayOfString = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[] { "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd" }));
              AppMethodBeat.o(58292);
              throw paramAnonymousArrayOfString;
            }
            b.a(b.this, paramAnonymousArrayOfString);
            AppMethodBeat.o(58292);
          }
        };
        AppMethodBeat.o(58296);
        return paramf;
      }
      if ("strings".equals(paramf))
      {
        paramf = new b.a()
        {
          protected final void ao(String[] paramAnonymousArrayOfString)
          {
            AppMethodBeat.i(58293);
            if (paramAnonymousArrayOfString == null)
            {
              paramAnonymousArrayOfString = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[] { "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd" }));
              AppMethodBeat.o(58293);
              throw paramAnonymousArrayOfString;
            }
            b.b(b.this, paramAnonymousArrayOfString);
            AppMethodBeat.o(58293);
          }
        };
        AppMethodBeat.o(58296);
        return paramf;
      }
      AppMethodBeat.o(58296);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.b.a.b
 * JD-Core Version:    0.7.0.1
 */