package kotlin.l.b.a.b.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.d.a.w;
import kotlin.l.b.a.b.d.b.o.a;
import kotlin.l.b.a.b.d.b.o.b;
import kotlin.l.b.a.b.d.b.o.c;
import kotlin.l.b.a.b.f.c;

public final class b
  implements o.c
{
  private static final boolean aiXQ;
  private static final Map<kotlin.l.b.a.b.f.b, a.a> aiXR;
  public String[] aiXC = null;
  public String[] aiXD = null;
  public String[] aiXE = null;
  public String aiXF = null;
  public int aiXG = 0;
  public int[] aiXS = null;
  public a.a aiXT = null;
  public String packageName = null;
  
  static
  {
    AppMethodBeat.i(58301);
    aiXQ = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
    HashMap localHashMap = new HashMap();
    aiXR = localHashMap;
    localHashMap.put(kotlin.l.b.a.b.f.b.s(new c("kotlin.jvm.internal.KotlinClass")), a.a.aiXK);
    aiXR.put(kotlin.l.b.a.b.f.b.s(new c("kotlin.jvm.internal.KotlinFileFacade")), a.a.aiXL);
    aiXR.put(kotlin.l.b.a.b.f.b.s(new c("kotlin.jvm.internal.KotlinMultifileClass")), a.a.aiXN);
    aiXR.put(kotlin.l.b.a.b.f.b.s(new c("kotlin.jvm.internal.KotlinMultifileClassPart")), a.a.aiXO);
    aiXR.put(kotlin.l.b.a.b.f.b.s(new c("kotlin.jvm.internal.KotlinSyntheticClass")), a.a.aiXM);
    AppMethodBeat.o(58301);
  }
  
  public final o.a a(kotlin.l.b.a.b.f.b paramb, av paramav)
  {
    AppMethodBeat.i(58300);
    if (paramb == null)
    {
      paramb = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[] { "classId", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor", "visitAnnotation" }));
      AppMethodBeat.o(58300);
      throw paramb;
    }
    if (paramb.kxQ().equals(w.aiPt))
    {
      paramb = new b((byte)0);
      AppMethodBeat.o(58300);
      return paramb;
    }
    if (aiXQ)
    {
      AppMethodBeat.o(58300);
      return null;
    }
    if (this.aiXT != null)
    {
      AppMethodBeat.o(58300);
      return null;
    }
    paramb = (a.a)aiXR.get(paramb);
    if (paramb != null)
    {
      this.aiXT = paramb;
      paramb = new c((byte)0);
      AppMethodBeat.o(58300);
      return paramb;
    }
    AppMethodBeat.o(58300);
    return null;
  }
  
  public final void azp() {}
  
  static abstract class a
    implements o.b
  {
    private final List<String> aiXU = new ArrayList();
    
    public final void a(kotlin.l.b.a.b.f.b paramb, kotlin.l.b.a.b.f.f paramf)
    {
      if (paramb == null) {
        aKu(0);
      }
      if (paramf == null) {
        aKu(1);
      }
    }
    
    public final void a(kotlin.l.b.a.b.j.b.f paramf)
    {
      if (paramf == null) {
        aKu(2);
      }
    }
    
    protected abstract void am(String[] paramArrayOfString);
    
    public final void azp()
    {
      am((String[])this.aiXU.toArray(new String[0]));
    }
    
    public final o.a e(kotlin.l.b.a.b.f.b paramb)
    {
      if (paramb == null) {
        aKu(3);
      }
      return null;
    }
    
    public final void hY(Object paramObject)
    {
      if ((paramObject instanceof String)) {
        this.aiXU.add((String)paramObject);
      }
    }
  }
  
  final class b
    implements o.a
  {
    private b() {}
    
    public final o.a a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.f.b paramb)
    {
      AppMethodBeat.i(58290);
      if (paramf == null) {
        aKu(6);
      }
      if (paramb == null) {
        aKu(7);
      }
      AppMethodBeat.o(58290);
      return null;
    }
    
    public final void a(kotlin.l.b.a.b.f.f paramf, Object paramObject)
    {
      AppMethodBeat.i(58286);
      if (paramf == null)
      {
        AppMethodBeat.o(58286);
        return;
      }
      paramf = paramf.PF();
      if ("k".equals(paramf))
      {
        if ((paramObject instanceof Integer))
        {
          b.a(b.this, a.a.aKA(((Integer)paramObject).intValue()));
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
    
    public final void a(kotlin.l.b.a.b.f.f paramf1, kotlin.l.b.a.b.f.b paramb, kotlin.l.b.a.b.f.f paramf2)
    {
      AppMethodBeat.i(58289);
      if (paramf1 == null) {
        aKu(3);
      }
      if (paramb == null) {
        aKu(4);
      }
      if (paramf2 == null) {
        aKu(5);
      }
      AppMethodBeat.o(58289);
    }
    
    public final void a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.j.b.f paramf1)
    {
      AppMethodBeat.i(58287);
      if (paramf == null) {
        aKu(0);
      }
      if (paramf1 == null) {
        aKu(1);
      }
      AppMethodBeat.o(58287);
    }
    
    public final void azp() {}
    
    public final o.b o(kotlin.l.b.a.b.f.f paramf)
    {
      AppMethodBeat.i(58288);
      if (paramf == null) {
        aKu(2);
      }
      paramf = paramf.PF();
      if ("d1".equals(paramf))
      {
        paramf = new b.a()
        {
          protected final void am(String[] paramAnonymousArrayOfString)
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
          protected final void am(String[] paramAnonymousArrayOfString)
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
    implements o.a
  {
    private c() {}
    
    public final o.a a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.f.b paramb)
    {
      AppMethodBeat.i(58298);
      if (paramf == null) {
        aKu(6);
      }
      if (paramb == null) {
        aKu(7);
      }
      AppMethodBeat.o(58298);
      return null;
    }
    
    public final void a(kotlin.l.b.a.b.f.f paramf, Object paramObject)
    {
      AppMethodBeat.i(58294);
      if (paramf == null)
      {
        AppMethodBeat.o(58294);
        return;
      }
      paramf = paramf.PF();
      b localb;
      if ("version".equals(paramf))
      {
        if ((paramObject instanceof int[]))
        {
          b.a(b.this, (int[])paramObject);
          AppMethodBeat.o(58294);
        }
      }
      else if ("multifileClassName".equals(paramf))
      {
        localb = b.this;
        if (!(paramObject instanceof String)) {
          break label95;
        }
      }
      label95:
      for (paramf = (String)paramObject;; paramf = null)
      {
        b.a(localb, paramf);
        AppMethodBeat.o(58294);
        return;
      }
    }
    
    public final void a(kotlin.l.b.a.b.f.f paramf1, kotlin.l.b.a.b.f.b paramb, kotlin.l.b.a.b.f.f paramf2)
    {
      AppMethodBeat.i(58297);
      if (paramf1 == null) {
        aKu(3);
      }
      if (paramb == null) {
        aKu(4);
      }
      if (paramf2 == null) {
        aKu(5);
      }
      AppMethodBeat.o(58297);
    }
    
    public final void a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.j.b.f paramf1)
    {
      AppMethodBeat.i(58295);
      if (paramf == null) {
        aKu(0);
      }
      if (paramf1 == null) {
        aKu(1);
      }
      AppMethodBeat.o(58295);
    }
    
    public final void azp() {}
    
    public final o.b o(kotlin.l.b.a.b.f.f paramf)
    {
      AppMethodBeat.i(58296);
      if (paramf == null) {
        aKu(2);
      }
      paramf = paramf.PF();
      if (("data".equals(paramf)) || ("filePartClassNames".equals(paramf)))
      {
        paramf = new b.a()
        {
          protected final void am(String[] paramAnonymousArrayOfString)
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
          protected final void am(String[] paramAnonymousArrayOfString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.a.b
 * JD-Core Version:    0.7.0.1
 */