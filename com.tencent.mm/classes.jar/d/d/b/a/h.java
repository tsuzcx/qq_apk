package d.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.lang.reflect.Method;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "()V", "cache", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", "", "Cache", "kotlin-stdlib"})
final class h
{
  private static final a MLo;
  public static a MLp;
  public static final h MLq;
  
  static
  {
    AppMethodBeat.i(129610);
    MLq = new h();
    MLo = new a(null, null, null);
    AppMethodBeat.o(129610);
  }
  
  public static String d(a parama)
  {
    AppMethodBeat.i(199644);
    p.h(parama, "continuation");
    Object localObject2 = MLp;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = e(parama);
    }
    if (localObject1 == MLo)
    {
      AppMethodBeat.o(199644);
      return null;
    }
    localObject2 = ((a)localObject1).MLr;
    if (localObject2 != null)
    {
      parama = ((Method)localObject2).invoke(parama.getClass(), new Object[0]);
      if (parama != null) {}
    }
    else
    {
      AppMethodBeat.o(199644);
      return null;
    }
    localObject2 = ((a)localObject1).MLs;
    if (localObject2 != null)
    {
      parama = ((Method)localObject2).invoke(parama, new Object[0]);
      if (parama != null) {}
    }
    else
    {
      AppMethodBeat.o(199644);
      return null;
    }
    localObject1 = ((a)localObject1).MLt;
    if (localObject1 != null) {}
    for (parama = ((Method)localObject1).invoke(parama, new Object[0]);; parama = null)
    {
      localObject1 = parama;
      if (!(parama instanceof String)) {
        localObject1 = null;
      }
      parama = (String)localObject1;
      AppMethodBeat.o(199644);
      return parama;
    }
  }
  
  private static a e(a parama)
  {
    AppMethodBeat.i(129609);
    try
    {
      parama = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), parama.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), parama.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
      MLp = parama;
      AppMethodBeat.o(129609);
      return parama;
    }
    catch (Exception parama)
    {
      parama = MLo;
      MLp = parama;
      AppMethodBeat.o(129609);
    }
    return parama;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"})
  static final class a
  {
    public final Method MLr;
    public final Method MLs;
    public final Method MLt;
    
    public a(Method paramMethod1, Method paramMethod2, Method paramMethod3)
    {
      this.MLr = paramMethod1;
      this.MLs = paramMethod2;
      this.MLt = paramMethod3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.d.b.a.h
 * JD-Core Version:    0.7.0.1
 */