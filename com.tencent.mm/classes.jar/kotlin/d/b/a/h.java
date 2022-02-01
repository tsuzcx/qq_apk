package kotlin.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "()V", "cache", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", "", "Cache", "kotlin-stdlib"})
final class h
{
  static final a SXX;
  public static a SXY;
  public static final h SXZ;
  
  static
  {
    AppMethodBeat.i(129610);
    SXZ = new h();
    SXX = new a(null, null, null);
    AppMethodBeat.o(129610);
  }
  
  static a b(a parama)
  {
    AppMethodBeat.i(129609);
    try
    {
      parama = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), parama.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), parama.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
      SXY = parama;
      AppMethodBeat.o(129609);
      return parama;
    }
    catch (Exception parama)
    {
      parama = SXX;
      SXY = parama;
      AppMethodBeat.o(129609);
    }
    return parama;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"})
  static final class a
  {
    public final Method SYa;
    public final Method SYb;
    public final Method SYc;
    
    public a(Method paramMethod1, Method paramMethod2, Method paramMethod3)
    {
      this.SYa = paramMethod1;
      this.SYb = paramMethod2;
      this.SYc = paramMethod3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlin.d.b.a.h
 * JD-Core Version:    0.7.0.1
 */