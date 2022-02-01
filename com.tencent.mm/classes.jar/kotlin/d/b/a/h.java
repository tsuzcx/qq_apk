package kotlin.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "()V", "cache", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", "", "Cache", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class h
{
  static final a aiws;
  static a aiwt;
  public static final h aiwu;
  
  static
  {
    AppMethodBeat.i(129610);
    aiwu = new h();
    aiws = new a(null, null, null);
    AppMethodBeat.o(129610);
  }
  
  static a b(a parama)
  {
    AppMethodBeat.i(129609);
    try
    {
      parama = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), parama.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), parama.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
      aiwt = parama;
      AppMethodBeat.o(129609);
      return parama;
    }
    catch (Exception parama)
    {
      parama = aiws;
      aiwt = parama;
      AppMethodBeat.o(129609);
    }
    return parama;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  static final class a
  {
    public final Method aiwv;
    public final Method aiww;
    public final Method aiwx;
    
    public a(Method paramMethod1, Method paramMethod2, Method paramMethod3)
    {
      this.aiwv = paramMethod1;
      this.aiww = paramMethod2;
      this.aiwx = paramMethod3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.d.b.a.h
 * JD-Core Version:    0.7.0.1
 */