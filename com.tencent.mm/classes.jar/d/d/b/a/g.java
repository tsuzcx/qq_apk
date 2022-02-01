package d.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.lang.reflect.Method;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "()V", "cache", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", "", "Cache", "kotlin-stdlib"})
final class g
{
  private static final a KUp;
  public static a KUq;
  public static final g KUr;
  
  static
  {
    AppMethodBeat.i(129610);
    KUr = new g();
    KUp = new a(null, null, null);
    AppMethodBeat.o(129610);
  }
  
  public static String d(a parama)
  {
    AppMethodBeat.i(186168);
    k.h(parama, "continuation");
    Object localObject2 = KUq;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = e(parama);
    }
    if (localObject1 == KUp)
    {
      AppMethodBeat.o(186168);
      return null;
    }
    localObject2 = ((a)localObject1).KUs;
    if (localObject2 != null)
    {
      parama = ((Method)localObject2).invoke(parama.getClass(), new Object[0]);
      if (parama != null) {}
    }
    else
    {
      AppMethodBeat.o(186168);
      return null;
    }
    localObject2 = ((a)localObject1).KUt;
    if (localObject2 != null)
    {
      parama = ((Method)localObject2).invoke(parama, new Object[0]);
      if (parama != null) {}
    }
    else
    {
      AppMethodBeat.o(186168);
      return null;
    }
    localObject1 = ((a)localObject1).KUu;
    if (localObject1 != null) {}
    for (parama = ((Method)localObject1).invoke(parama, new Object[0]);; parama = null)
    {
      localObject1 = parama;
      if (!(parama instanceof String)) {
        localObject1 = null;
      }
      parama = (String)localObject1;
      AppMethodBeat.o(186168);
      return parama;
    }
  }
  
  private static a e(a parama)
  {
    AppMethodBeat.i(129609);
    try
    {
      parama = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), parama.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), parama.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
      KUq = parama;
      AppMethodBeat.o(129609);
      return parama;
    }
    catch (Exception parama)
    {
      parama = KUp;
      KUq = parama;
      AppMethodBeat.o(129609);
    }
    return parama;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"})
  static final class a
  {
    public final Method KUs;
    public final Method KUt;
    public final Method KUu;
    
    public a(Method paramMethod1, Method paramMethod2, Method paramMethod3)
    {
      this.KUs = paramMethod1;
      this.KUt = paramMethod2;
      this.KUu = paramMethod3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.d.b.a.g
 * JD-Core Version:    0.7.0.1
 */