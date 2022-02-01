package d.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.lang.reflect.Method;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "()V", "cache", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", "", "Cache", "kotlin-stdlib"})
final class h
{
  private static final a Nir;
  public static a Nis;
  public static final h Nit;
  
  static
  {
    AppMethodBeat.i(129610);
    Nit = new h();
    Nir = new a(null, null, null);
    AppMethodBeat.o(129610);
  }
  
  public static String d(a parama)
  {
    AppMethodBeat.i(188744);
    p.h(parama, "continuation");
    Object localObject2 = Nis;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = e(parama);
    }
    if (localObject1 == Nir)
    {
      AppMethodBeat.o(188744);
      return null;
    }
    localObject2 = ((a)localObject1).Niu;
    if (localObject2 != null)
    {
      parama = ((Method)localObject2).invoke(parama.getClass(), new Object[0]);
      if (parama != null) {}
    }
    else
    {
      AppMethodBeat.o(188744);
      return null;
    }
    localObject2 = ((a)localObject1).Niv;
    if (localObject2 != null)
    {
      parama = ((Method)localObject2).invoke(parama, new Object[0]);
      if (parama != null) {}
    }
    else
    {
      AppMethodBeat.o(188744);
      return null;
    }
    localObject1 = ((a)localObject1).Niw;
    if (localObject1 != null) {}
    for (parama = ((Method)localObject1).invoke(parama, new Object[0]);; parama = null)
    {
      localObject1 = parama;
      if (!(parama instanceof String)) {
        localObject1 = null;
      }
      parama = (String)localObject1;
      AppMethodBeat.o(188744);
      return parama;
    }
  }
  
  private static a e(a parama)
  {
    AppMethodBeat.i(129609);
    try
    {
      parama = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), parama.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), parama.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
      Nis = parama;
      AppMethodBeat.o(129609);
      return parama;
    }
    catch (Exception parama)
    {
      parama = Nir;
      Nis = parama;
      AppMethodBeat.o(129609);
    }
    return parama;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"})
  static final class a
  {
    public final Method Niu;
    public final Method Niv;
    public final Method Niw;
    
    public a(Method paramMethod1, Method paramMethod2, Method paramMethod3)
    {
      this.Niu = paramMethod1;
      this.Niv = paramMethod2;
      this.Niw = paramMethod3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.d.b.a.h
 * JD-Core Version:    0.7.0.1
 */